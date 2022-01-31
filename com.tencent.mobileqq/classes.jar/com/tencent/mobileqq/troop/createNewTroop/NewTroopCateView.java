package com.tencent.mobileqq.troop.createNewTroop;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.ListView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.service.troop.TroopConstants.CreateTroopSource;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopLinkManager;
import com.tencent.mobileqq.troop.utils.TroopLinkManager.LinkParams;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import java.util.ArrayList;

public class NewTroopCateView
  extends AbsNewTroopBaseView
  implements TroopConstants.CreateTroopSource
{
  protected int a;
  public ListView a;
  protected CateListAdapter a;
  
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
    a(2130969874);
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131368334));
    this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopCateListAdapter = new CateListAdapter(this);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopCateListAdapter);
    this.jdField_a_of_type_AndroidWidgetListView.setDivider(null);
    this.jdField_a_of_type_AndroidWidgetListView.setDividerHeight(0);
  }
  
  private void h()
  {
    ArrayList localArrayList = TroopCateListProvider.a().a();
    if ((localArrayList != null) && (!localArrayList.isEmpty())) {
      this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopCateListAdapter.a(localArrayList);
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
  
  public void a(String paramString1, String paramString2)
  {
    String str1 = paramString1;
    if (paramString1 == null) {
      str1 = "";
    }
    String str2 = paramString2;
    if (paramString2 == null) {
      str2 = "";
    }
    TroopLinkManager localTroopLinkManager = TroopLinkManager.a();
    paramString2 = localTroopLinkManager.a("troop_create");
    if ("32".equals(str1)) {
      paramString1 = localTroopLinkManager.a("troop_create_for_school");
    }
    for (;;)
    {
      paramString2 = new TroopLinkManager.LinkParams();
      paramString2.f = str1;
      paramString2.g = str2;
      paramString2.c = (this.jdField_a_of_type_Int + "");
      paramString1 = localTroopLinkManager.a(paramString1, paramString2);
      paramString2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity, QQBrowserActivity.class);
      paramString2.putExtra("url", paramString1);
      this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.startActivity(paramString2);
      return;
      paramString1 = paramString2;
      if ("25".equals(str1))
      {
        paramString1 = paramString2;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
          paramString1 = paramString2;
          if (localSharedPreferences != null)
          {
            paramString1 = paramString2;
            if (localSharedPreferences.getBoolean("key_game_troop_bind_config_switch", false)) {
              paramString1 = localTroopLinkManager.a("troop_create_for_game");
            }
          }
        }
      }
    }
  }
  
  protected void e()
  {
    GroupCatalogTool.a(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity).a();
    super.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.NewTroopCateView
 * JD-Core Version:    0.7.0.1
 */