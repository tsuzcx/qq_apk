package com.tencent.mobileqq.troop.troopcreate.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.troop.TroopConstants.CreateTroopSource;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.troopcreate.ITroopCreateConfig;
import com.tencent.mobileqq.troop.troopcatalog.GroupCatalogTool;
import com.tencent.mobileqq.troop.troopcreate.TroopCreateUtils;
import com.tencent.mobileqq.troop.trooplink.api.ITroopLinkApi;
import com.tencent.mobileqq.troop.trooplink.api.ITroopLinkApi.LinkParams;
import com.tencent.mobileqq.vas.config.business.qvip.QVIPPrettyTroopProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.QVipPrettyTroopConfig;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class NewTroopCateView
  extends AbsNewTroopBaseView
  implements TroopConstants.CreateTroopSource
{
  public ListView c;
  protected CateListAdapter d;
  protected int e = 0;
  private String f;
  
  public NewTroopCateView(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private void g()
  {
    setContentView(2131626676);
    this.c = ((ListView)findViewById(2131449022));
    this.d = new CateListAdapter(this, this.b);
    this.c.setAdapter(this.d);
    this.c.setDivider(null);
    this.c.setDividerHeight(0);
    this.c.setOverScrollMode(2);
    if (ThemeUtil.isNowThemeIsNight(this.b, false, null)) {
      findViewById(2131439329).setVisibility(0);
    }
  }
  
  private void getIntentExtras()
  {
    this.e = this.a.getIntent().getIntExtra("create_source", 0);
  }
  
  private void h()
  {
    ArrayList localArrayList = TroopCateListProvider.a().a(this.b);
    if (!((ITroopCreateConfig)this.b.getRuntimeService(ITroopCreateConfig.class, "")).isShow3KTroopTips())
    {
      Object localObject = localArrayList.iterator();
      TroopCateListProvider.TroopCateInfo localTroopCateInfo1;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localTroopCateInfo1 = (TroopCateListProvider.TroopCateInfo)((Iterator)localObject).next();
        if (CateListAdapter.a.equals(localTroopCateInfo1.b))
        {
          localArrayList.remove(localTroopCateInfo1);
          break;
        }
      } while (!CateListAdapter.b.equals(localTroopCateInfo1.b));
      localObject = new ArrayList();
      Iterator localIterator = localTroopCateInfo1.g.iterator();
      while (localIterator.hasNext())
      {
        TroopCateListProvider.TroopCateInfo localTroopCateInfo2 = (TroopCateListProvider.TroopCateInfo)localIterator.next();
        if ((!TextUtils.equals(localTroopCateInfo2.a, "20001")) && (!TextUtils.equals(localTroopCateInfo2.a, "20002"))) {
          ((ArrayList)localObject).add(localTroopCateInfo2);
        }
      }
      localTroopCateInfo1.g = ((ArrayList)localObject);
    }
    else if (QVIPPrettyTroopProcessor.e().b)
    {
      ReportController.b(this.b, "dc00898", "", "", "qq_vip", "0X800A581", 0, 0, "", "", "", "");
    }
    if ((localArrayList != null) && (!localArrayList.isEmpty())) {
      this.d.a(localArrayList);
    }
  }
  
  public void a(QBaseActivity paramQBaseActivity)
  {
    super.a(paramQBaseActivity);
    getIntentExtras();
    g();
    h();
    paramQBaseActivity = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.e);
    ReportController.b(paramQBaseActivity, "dc00899", "Grp_create_new", "", "create_page", "exp_category", 0, 0, "", localStringBuilder.toString(), "", "");
  }
  
  public void a(String paramString1, String paramString2)
  {
    Object localObject = paramString1;
    if (paramString1 == null) {
      localObject = "";
    }
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    ITroopLinkApi localITroopLinkApi = (ITroopLinkApi)QRoute.api(ITroopLinkApi.class);
    paramString2 = localITroopLinkApi.getUrl("troop_create");
    if ("32".equals(localObject))
    {
      this.f = localITroopLinkApi.getUrl("troop_create_for_school");
      TroopCreateUtils.c(this.a, this.f);
      return;
    }
    if ("25".equals(localObject))
    {
      paramString1 = paramString2;
      if (this.b != null)
      {
        SharedPreferences localSharedPreferences = this.b.getPreferences();
        paramString1 = paramString2;
        if (localSharedPreferences != null)
        {
          paramString1 = paramString2;
          if (localSharedPreferences.getBoolean("key_game_troop_bind_config_switch", false)) {
            paramString1 = localITroopLinkApi.getUrl("troop_create_for_game");
          }
        }
      }
    }
    else
    {
      paramString1 = paramString2;
      if ("50000".equals(localObject)) {
        paramString1 = localITroopLinkApi.getUrl("guild_create");
      }
    }
    paramString2 = new ITroopLinkApi.LinkParams();
    paramString2.f = ((String)localObject);
    paramString2.g = str;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.e);
    ((StringBuilder)localObject).append("");
    paramString2.c = ((StringBuilder)localObject).toString();
    paramString1 = localITroopLinkApi.replaceParams(paramString1, paramString2);
    paramString2 = new Intent();
    paramString2.putExtra("url", paramString1);
    this.a.startActivity(paramString2);
    TroopCreateUtils.a(this.a, paramString2, "/base/browser");
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("openCreateTroopPage ");
      paramString2.append(paramString1);
      QLog.d("createNewTroop.NewTroopCateView", 2, paramString2.toString());
    }
  }
  
  public void e()
  {
    GroupCatalogTool.a(this.a).c();
    super.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.NewTroopCateView
 * JD-Core Version:    0.7.0.1
 */