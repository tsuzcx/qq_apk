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
  protected int a;
  public ListView a;
  protected CateListAdapter a;
  private String a;
  
  public NewTroopCateView(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_Int = 0;
  }
  
  private void f()
  {
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent().getIntExtra("create_source", 0);
  }
  
  private void g()
  {
    a(2131560631);
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131380108));
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiCateListAdapter = new CateListAdapter(this, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiCateListAdapter);
    this.jdField_a_of_type_AndroidWidgetListView.setDivider(null);
    this.jdField_a_of_type_AndroidWidgetListView.setDividerHeight(0);
    this.jdField_a_of_type_AndroidWidgetListView.setOverScrollMode(2);
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentCommonAppAppInterface, false, null)) {
      findViewById(2131371886).setVisibility(0);
    }
  }
  
  private void h()
  {
    ArrayList localArrayList = TroopCateListProvider.a().a();
    if (!((ITroopCreateConfig)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopCreateConfig.class, "")).isShow3KTroopTips())
    {
      Object localObject = localArrayList.iterator();
      TroopCateListProvider.TroopCateInfo localTroopCateInfo1;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localTroopCateInfo1 = (TroopCateListProvider.TroopCateInfo)((Iterator)localObject).next();
        if (CateListAdapter.jdField_a_of_type_JavaLangString.equals(localTroopCateInfo1.b))
        {
          localArrayList.remove(localTroopCateInfo1);
          break;
        }
      } while (!CateListAdapter.b.equals(localTroopCateInfo1.b));
      localObject = new ArrayList();
      Iterator localIterator = localTroopCateInfo1.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        TroopCateListProvider.TroopCateInfo localTroopCateInfo2 = (TroopCateListProvider.TroopCateInfo)localIterator.next();
        if ((!TextUtils.equals(localTroopCateInfo2.jdField_a_of_type_JavaLangString, "20001")) && (!TextUtils.equals(localTroopCateInfo2.jdField_a_of_type_JavaLangString, "20002"))) {
          ((ArrayList)localObject).add(localTroopCateInfo2);
        }
      }
      localTroopCateInfo1.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject);
    }
    else if (QVIPPrettyTroopProcessor.c().b)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "qq_vip", "0X800A581", 0, 0, "", "", "", "");
    }
    if ((localArrayList != null) && (!localArrayList.isEmpty())) {
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiCateListAdapter.a(localArrayList);
    }
  }
  
  public void a(QBaseActivity paramQBaseActivity)
  {
    super.a(paramQBaseActivity);
    f();
    g();
    h();
    paramQBaseActivity = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    ReportController.b(paramQBaseActivity, "dc00899", "Grp_create_new", "", "create_page", "exp_category", 0, 0, "", localStringBuilder.toString(), "", "");
  }
  
  public void a(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    ITroopLinkApi localITroopLinkApi = (ITroopLinkApi)QRoute.api(ITroopLinkApi.class);
    Object localObject = localITroopLinkApi.getUrl("troop_create");
    if ("32".equals(str))
    {
      this.jdField_a_of_type_JavaLangString = localITroopLinkApi.getUrl("troop_create_for_school");
      TroopCreateUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_JavaLangString);
      return;
    }
    paramString2 = (String)localObject;
    if ("25".equals(str))
    {
      paramString2 = (String)localObject;
      if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
      {
        SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getPreferences();
        paramString2 = (String)localObject;
        if (localSharedPreferences != null)
        {
          paramString2 = (String)localObject;
          if (localSharedPreferences.getBoolean("key_game_troop_bind_config_switch", false)) {
            paramString2 = localITroopLinkApi.getUrl("troop_create_for_game");
          }
        }
      }
    }
    localObject = new ITroopLinkApi.LinkParams();
    ((ITroopLinkApi.LinkParams)localObject).f = str;
    ((ITroopLinkApi.LinkParams)localObject).g = paramString1;
    paramString1 = new StringBuilder();
    paramString1.append(this.jdField_a_of_type_Int);
    paramString1.append("");
    ((ITroopLinkApi.LinkParams)localObject).c = paramString1.toString();
    paramString1 = localITroopLinkApi.replaceParams(paramString2, (ITroopLinkApi.LinkParams)localObject);
    paramString2 = new Intent();
    paramString2.putExtra("url", paramString1);
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.startActivity(paramString2);
    TroopCreateUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, paramString2, "/base/browser");
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
    GroupCatalogTool.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity).a();
    super.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.NewTroopCateView
 * JD-Core Version:    0.7.0.1
 */