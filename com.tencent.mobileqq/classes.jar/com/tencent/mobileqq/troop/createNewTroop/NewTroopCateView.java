package com.tencent.mobileqq.troop.createNewTroop;

import amyt;
import amzm;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListView;
import axqw;
import azke;
import azly;
import azlz;
import bali;
import balj;
import basn;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import xbo;

public class NewTroopCateView
  extends AbsNewTroopBaseView
{
  protected int a;
  public ListView a;
  protected azke a;
  
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
    a(2131560314);
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131378555));
    this.jdField_a_of_type_Azke = new azke(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Azke);
    this.jdField_a_of_type_AndroidWidgetListView.setDivider(null);
    this.jdField_a_of_type_AndroidWidgetListView.setDividerHeight(0);
    this.jdField_a_of_type_AndroidWidgetListView.setOverScrollMode(2);
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
      findViewById(2131370840).setVisibility(0);
    }
  }
  
  private void h()
  {
    ArrayList localArrayList = azly.a().a();
    Object localObject;
    azlz localazlz1;
    if (!((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a.a)
    {
      localObject = localArrayList.iterator();
      if (((Iterator)localObject).hasNext())
      {
        localazlz1 = (azlz)((Iterator)localObject).next();
        if (!azke.jdField_a_of_type_JavaLangString.equals(localazlz1.b)) {
          break label91;
        }
        localArrayList.remove(localazlz1);
      }
    }
    for (;;)
    {
      if ((localArrayList != null) && (!localArrayList.isEmpty())) {
        this.jdField_a_of_type_Azke.a(localArrayList);
      }
      return;
      label91:
      if (!azke.b.equals(localazlz1.b)) {
        break;
      }
      localObject = new ArrayList();
      Iterator localIterator = localazlz1.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        azlz localazlz2 = (azlz)localIterator.next();
        if ((!TextUtils.equals(localazlz2.jdField_a_of_type_JavaLangString, "20001")) && (!TextUtils.equals(localazlz2.jdField_a_of_type_JavaLangString, "20002"))) {
          ((ArrayList)localObject).add(localazlz2);
        }
      }
      localazlz1.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject);
      continue;
      if (amyt.c().b) {
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "qq_vip", "0X800A581", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void a(NewTroopCreateActivity paramNewTroopCreateActivity)
  {
    super.a(paramNewTroopCreateActivity);
    f();
    g();
    h();
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create_new", "", "create_page", "exp_category", 0, 0, "", "" + this.jdField_a_of_type_Int, "", "");
  }
  
  public void a(String paramString)
  {
    String str = "";
    if (paramString.equals("20001")) {
      str = amyt.c().a();
    }
    for (;;)
    {
      paramString = new Intent(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity, QQBrowserActivity.class);
      paramString.putExtra("url", str);
      this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.startActivity(paramString);
      return;
      if (paramString.equals("20002")) {
        str = amyt.c().b();
      }
    }
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
    bali localbali = bali.a();
    paramString2 = localbali.a("troop_create");
    if ("32".equals(str1)) {
      paramString1 = localbali.a("troop_create_for_school");
    }
    for (;;)
    {
      paramString2 = new balj();
      paramString2.f = str1;
      paramString2.g = str2;
      paramString2.c = (this.jdField_a_of_type_Int + "");
      paramString1 = localbali.a(paramString1, paramString2);
      paramString2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity, QQBrowserActivity.class);
      paramString2.putExtra("url", paramString1);
      this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.startActivity(paramString2);
      if (QLog.isColorLevel()) {
        QLog.d("createNewTroop.NewTroopCateView", 2, "openCreateTroopPage " + paramString1);
      }
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
              paramString1 = localbali.a("troop_create_for_game");
            }
          }
        }
      }
    }
  }
  
  protected void e()
  {
    basn.a(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity).a();
    super.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.NewTroopCateView
 * JD-Core Version:    0.7.0.1
 */