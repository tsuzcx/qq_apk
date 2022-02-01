package com.tencent.mobileqq.troop.createNewTroop;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListView;
import com.tencent.biz.troopconfig.TroopConfigForAllUser;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.business.qvip.QVIPPrettyTroopProcessor;
import com.tencent.mobileqq.config.business.qvip.QVipPrettyTroopConfig;
import com.tencent.mobileqq.service.troop.TroopConstants.CreateTroopSource;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.utils.TroopLinkManager;
import com.tencent.mobileqq.troop.utils.TroopLinkManager.LinkParams;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class NewTroopCateView
  extends AbsNewTroopBaseView
  implements TroopConstants.CreateTroopSource
{
  protected int a;
  protected ListView a;
  protected CateListAdapter a;
  private String a;
  
  public NewTroopCateView(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_Int = 0;
  }
  
  private void f()
  {
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.getIntent().getIntExtra("create_source", 0);
  }
  
  private void g()
  {
    a(2131560743);
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131380844));
    this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopCateListAdapter = new CateListAdapter(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopCateListAdapter);
    this.jdField_a_of_type_AndroidWidgetListView.setDivider(null);
    this.jdField_a_of_type_AndroidWidgetListView.setDividerHeight(0);
    this.jdField_a_of_type_AndroidWidgetListView.setOverScrollMode(2);
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
      findViewById(2131372298).setVisibility(0);
    }
  }
  
  private void h()
  {
    ArrayList localArrayList = TroopCateListProvider.a().a();
    Object localObject;
    TroopCateListProvider.TroopCateInfo localTroopCateInfo1;
    if (!((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a.a)
    {
      localObject = localArrayList.iterator();
      if (((Iterator)localObject).hasNext())
      {
        localTroopCateInfo1 = (TroopCateListProvider.TroopCateInfo)((Iterator)localObject).next();
        if (!CateListAdapter.jdField_a_of_type_JavaLangString.equals(localTroopCateInfo1.b)) {
          break label92;
        }
        localArrayList.remove(localTroopCateInfo1);
      }
    }
    for (;;)
    {
      if ((localArrayList != null) && (!localArrayList.isEmpty())) {
        this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopCateListAdapter.a(localArrayList);
      }
      return;
      label92:
      if (!CateListAdapter.b.equals(localTroopCateInfo1.b)) {
        break;
      }
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
      continue;
      if (QVIPPrettyTroopProcessor.c().b) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "qq_vip", "0X800A581", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void i()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity, QQBrowserActivity.class);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    localIntent.putExtra("url", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.startActivity(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("createNewTroop.NewTroopCateView", 2, "openCreateHWTroopPage" + this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(NewTroopCreateActivity paramNewTroopCreateActivity)
  {
    super.a(paramNewTroopCreateActivity);
    f();
    g();
    h();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create_new", "", "create_page", "exp_category", 0, 0, "", "" + this.jdField_a_of_type_Int, "", "");
  }
  
  public void a(String paramString)
  {
    String str = "";
    if (paramString.equals("20001")) {
      str = QVIPPrettyTroopProcessor.c().a();
    }
    for (;;)
    {
      paramString = new Intent(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity, QQBrowserActivity.class);
      paramString.putExtra("url", str);
      this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.startActivity(paramString);
      return;
      if (paramString.equals("20002")) {
        str = QVIPPrettyTroopProcessor.c().b();
      }
    }
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
    TroopLinkManager localTroopLinkManager = TroopLinkManager.a();
    Object localObject = localTroopLinkManager.a("troop_create");
    if ("32".equals(str))
    {
      this.jdField_a_of_type_JavaLangString = localTroopLinkManager.a("troop_create_for_school");
      i();
    }
    do
    {
      return;
      paramString2 = (String)localObject;
      if ("25".equals(str))
      {
        paramString2 = (String)localObject;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
          paramString2 = (String)localObject;
          if (localSharedPreferences != null)
          {
            paramString2 = (String)localObject;
            if (localSharedPreferences.getBoolean("key_game_troop_bind_config_switch", false)) {
              paramString2 = localTroopLinkManager.a("troop_create_for_game");
            }
          }
        }
      }
      localObject = new TroopLinkManager.LinkParams();
      ((TroopLinkManager.LinkParams)localObject).f = str;
      ((TroopLinkManager.LinkParams)localObject).g = paramString1;
      ((TroopLinkManager.LinkParams)localObject).c = (this.jdField_a_of_type_Int + "");
      paramString1 = localTroopLinkManager.a(paramString2, (TroopLinkManager.LinkParams)localObject);
      paramString2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity, QQBrowserActivity.class);
      paramString2.putExtra("url", paramString1);
      this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.startActivity(paramString2);
    } while (!QLog.isColorLevel());
    QLog.d("createNewTroop.NewTroopCateView", 2, "openCreateTroopPage " + paramString1);
  }
  
  protected void e()
  {
    GroupCatalogTool.a(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity).a();
    super.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.NewTroopCateView
 * JD-Core Version:    0.7.0.1
 */