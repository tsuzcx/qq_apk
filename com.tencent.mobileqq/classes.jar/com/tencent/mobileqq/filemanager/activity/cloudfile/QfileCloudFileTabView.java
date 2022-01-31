package com.tencent.mobileqq.filemanager.activity.cloudfile;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import aoqa;
import aoqb;
import aoqn;
import aorf;
import aorh;
import aori;
import aork;
import aorl;
import aorm;
import aorn;
import aoro;
import aoun;
import aouu;
import aoze;
import aozg;
import apel;
import apok;
import apop;
import aptx;
import apue;
import apug;
import apvd;
import apvf;
import apvj;
import apvw;
import apxv;
import axqy;
import bbdj;
import bbdt;
import bbfj;
import bbgu;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class QfileCloudFileTabView
  extends QfileBaseCloudFileTabView
{
  aoro jdField_a_of_type_Aoro = null;
  aoun jdField_a_of_type_Aoun = null;
  private apvf jdField_a_of_type_Apvf;
  apxv jdField_a_of_type_Apxv = new aorl(this);
  final int b;
  public int c;
  public String c;
  public boolean c;
  private int jdField_e_of_type_Int;
  private View.OnClickListener jdField_e_of_type_AndroidViewView$OnClickListener = new aorm(this);
  private View.OnClickListener jdField_f_of_type_AndroidViewView$OnClickListener = new aorn(this);
  private boolean jdField_f_of_type_Boolean;
  private boolean g;
  private boolean h;
  
  public QfileCloudFileTabView(Context paramContext, String paramString, int paramInt)
  {
    super(paramContext);
    this.jdField_b_of_type_Int = 15;
    this.jdField_c_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_e_of_type_Int = paramInt;
    a(paramString);
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    paramView = (WeiYunFileInfo)((aoqa)paramView.getTag()).a;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
    if (paramBoolean) {
      if (apel.a(paramView))
      {
        apel.b(paramView);
        t();
        au_();
      }
    }
    for (;;)
    {
      b(f());
      do
      {
        return;
        apel.a(paramView);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h(true);
        if ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.i()) || (apel.a(apel.jdField_b_of_type_Int))) {
          break;
        }
        paramView = bbdj.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131698206);
        paramView.setPositiveButton(2131720422, new bbdt());
        paramView.show();
        apel.b(apel.jdField_b_of_type_Int);
        apue.a("0X800942F");
        break;
        if (b()) {
          break label152;
        }
      } while (!QLog.isColorLevel());
      QLog.i(jdField_b_of_type_JavaLangString, 2, "click too fast , wait a minute.");
      return;
      label152:
      if (f()) {
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
      }
      r();
      apue.a("0X8004AE6");
      apop localapop = new apop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramView);
      if (apug.a(paramView.jdField_c_of_type_JavaLangString) == 0) {
        localapop.a(a(paramView));
      }
      paramView = new apok(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, localapop);
      paramView.a(9);
      paramView.a();
    }
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_Aoun == null) {
      l();
    }
    if (this.jdField_a_of_type_Aoro == null) {
      k();
    }
    a(false);
  }
  
  private boolean a(WeiYunFileInfo paramWeiYunFileInfo, boolean paramBoolean)
  {
    if (paramWeiYunFileInfo == null) {}
    while ((apug.a(apvd.a(paramWeiYunFileInfo.jdField_c_of_type_JavaLangString)) != 0) || ((f()) && (((apel.a(paramWeiYunFileInfo)) && (paramBoolean)) || ((!apel.a(paramWeiYunFileInfo)) && (!paramBoolean))))) {
      return false;
    }
    if (f())
    {
      if (!paramBoolean) {
        break label65;
      }
      apel.a(paramWeiYunFileInfo);
    }
    for (;;)
    {
      return true;
      label65:
      apel.b(paramWeiYunFileInfo);
    }
  }
  
  private void v()
  {
    if (this.jdField_a_of_type_Apvf == null) {
      this.jdField_a_of_type_Apvf = new aorh(this);
    }
    if (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("document") == true) {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.c()) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().u();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a(this.jdField_a_of_type_Apvf);
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().z();
      continue;
      if (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("picture") == true)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.c()) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().v();
        } else {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().A();
        }
      }
      else if (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("video") == true)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.c()) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().w();
        } else {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().B();
        }
      }
      else if (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("music") == true)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.c()) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().x();
        } else {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().C();
        }
      }
      else if (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("other") == true) {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.c()) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().y();
        } else {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().D();
        }
      }
    }
  }
  
  protected aoqb a()
  {
    if (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("picture") == true)
    {
      setEditbarButton(true, true, false, true, true);
      return new aoqn(this.jdField_a_of_type_Aoro, a(), this.jdField_a_of_type_JavaUtilLinkedHashMap, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_e_of_type_AndroidViewView$OnClickListener, this.jdField_f_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.jdField_d_of_type_AndroidViewView$OnClickListener);
    }
    setEditbarButton(false, true, false, true, true);
    return new aorf(a(), this.jdField_a_of_type_JavaUtilLinkedHashMap, a(), this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_c_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.jdField_d_of_type_AndroidViewView$OnClickListener);
  }
  
  public void a()
  {
    a(new QfileCloudFileTabView.4(this));
  }
  
  protected void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_e_of_type_Int, this.jdField_a_of_type_JavaLangString, 0, 15, this.jdField_c_of_type_JavaLangString);
  }
  
  public boolean a()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  protected boolean a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramWeiYunFileInfo)) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramWeiYunFileInfo);
    String str = apvw.a(paramWeiYunFileInfo.b);
    if (!this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(str))
    {
      QLog.e(jdField_b_of_type_JavaLangString, 1, "delRecentFileRecords, fileEntities find, but recentRecords not find!");
      return false;
    }
    ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(str)).remove(paramWeiYunFileInfo);
    if (((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(str)).size() == 0) {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(str);
    }
    i();
    return true;
  }
  
  public void h()
  {
    this.h = false;
    if (!bbfj.g(a()))
    {
      aptx.a(2131692666);
      return;
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_e_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_Int * 15, 15, this.jdField_c_of_type_JavaLangString);
    f();
  }
  
  public void j()
  {
    super.j();
    if (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("picture") == true)
    {
      setEditbarButton(true, true, false, true, true);
      v();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnIndexChangedListener(this.jdField_a_of_type_Apxv);
      return;
    }
    setEditbarButton(false, true, false, true, true);
    v();
  }
  
  void k()
  {
    this.jdField_a_of_type_Aoro = new aori(this);
  }
  
  void l()
  {
    if (this.jdField_a_of_type_Aoun != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Aoun);
    }
    this.jdField_a_of_type_Aoun = new aork(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_Aoun);
  }
  
  public void m()
  {
    super.m();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Aoun);
  }
  
  public void n()
  {
    super.n();
    l();
    if (this.g) {
      i();
    }
  }
  
  public void o()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.runOnUiThread(new QfileCloudFileTabView.7(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView
 * JD-Core Version:    0.7.0.1
 */