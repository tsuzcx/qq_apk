package com.tencent.mobileqq.troop.createNewTroop;

import aahu;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListView;
import arju;
import arku;
import bdla;
import bfdg;
import bffa;
import bffb;
import bgld;
import bgle;
import bgst;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class NewTroopCateView
  extends AbsNewTroopBaseView
{
  protected int a;
  public ListView a;
  protected bfdg a;
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
    a(2131560653);
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131380401));
    this.jdField_a_of_type_Bfdg = new bfdg(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Bfdg);
    this.jdField_a_of_type_AndroidWidgetListView.setDivider(null);
    this.jdField_a_of_type_AndroidWidgetListView.setDividerHeight(0);
    this.jdField_a_of_type_AndroidWidgetListView.setOverScrollMode(2);
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
      findViewById(2131371991).setVisibility(0);
    }
  }
  
  private void h()
  {
    ArrayList localArrayList = bffa.a().a();
    Object localObject;
    bffb localbffb1;
    if (!((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a.a)
    {
      localObject = localArrayList.iterator();
      if (((Iterator)localObject).hasNext())
      {
        localbffb1 = (bffb)((Iterator)localObject).next();
        if (!bfdg.jdField_a_of_type_JavaLangString.equals(localbffb1.b)) {
          break label92;
        }
        localArrayList.remove(localbffb1);
      }
    }
    for (;;)
    {
      if ((localArrayList != null) && (!localArrayList.isEmpty())) {
        this.jdField_a_of_type_Bfdg.a(localArrayList);
      }
      return;
      label92:
      if (!bfdg.b.equals(localbffb1.b)) {
        break;
      }
      localObject = new ArrayList();
      Iterator localIterator = localbffb1.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        bffb localbffb2 = (bffb)localIterator.next();
        if ((!TextUtils.equals(localbffb2.jdField_a_of_type_JavaLangString, "20001")) && (!TextUtils.equals(localbffb2.jdField_a_of_type_JavaLangString, "20002"))) {
          ((ArrayList)localObject).add(localbffb2);
        }
      }
      localbffb1.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject);
      continue;
      if (arju.c().b) {
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "qq_vip", "0X800A581", 0, 0, "", "", "", "");
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
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create_new", "", "create_page", "exp_category", 0, 0, "", "" + this.jdField_a_of_type_Int, "", "");
  }
  
  public void a(String paramString)
  {
    String str = "";
    if (paramString.equals("20001")) {
      str = arju.c().a();
    }
    for (;;)
    {
      paramString = new Intent(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity, QQBrowserActivity.class);
      paramString.putExtra("url", str);
      this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.startActivity(paramString);
      return;
      if (paramString.equals("20002")) {
        str = arju.c().b();
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
    bgld localbgld = bgld.a();
    Object localObject = localbgld.a("troop_create");
    if ("32".equals(str))
    {
      this.jdField_a_of_type_JavaLangString = localbgld.a("troop_create_for_school");
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
              paramString2 = localbgld.a("troop_create_for_game");
            }
          }
        }
      }
      localObject = new bgle();
      ((bgle)localObject).f = str;
      ((bgle)localObject).g = paramString1;
      ((bgle)localObject).c = (this.jdField_a_of_type_Int + "");
      paramString1 = localbgld.a(paramString2, (bgle)localObject);
      paramString2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity, QQBrowserActivity.class);
      paramString2.putExtra("url", paramString1);
      this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.startActivity(paramString2);
    } while (!QLog.isColorLevel());
    QLog.d("createNewTroop.NewTroopCateView", 2, "openCreateTroopPage " + paramString1);
  }
  
  protected void e()
  {
    bgst.a(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity).a();
    super.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.NewTroopCateView
 * JD-Core Version:    0.7.0.1
 */