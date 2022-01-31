package com.tencent.mobileqq.filemanager.activity.cloudfile;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import aqiy;
import aqiz;
import aqjl;
import aqkd;
import aqkf;
import aqkg;
import aqki;
import aqkj;
import aqkk;
import aqkl;
import aqkm;
import aqnl;
import aqns;
import aqsc;
import aqse;
import aqxj;
import arhj;
import arho;
import armz;
import arng;
import arni;
import arof;
import aroh;
import arol;
import aroy;
import arqx;
import azmj;
import bdcd;
import bdco;
import bdee;
import bdfq;
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
  aqkm jdField_a_of_type_Aqkm = null;
  aqnl jdField_a_of_type_Aqnl = null;
  private aroh jdField_a_of_type_Aroh;
  arqx jdField_a_of_type_Arqx = new aqkj(this);
  final int b;
  public int c;
  public String c;
  public boolean c;
  private int jdField_e_of_type_Int;
  private View.OnClickListener jdField_e_of_type_AndroidViewView$OnClickListener = new aqkk(this);
  private View.OnClickListener jdField_f_of_type_AndroidViewView$OnClickListener = new aqkl(this);
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
    paramView = (WeiYunFileInfo)((aqiy)paramView.getTag()).a;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
    if (paramBoolean) {
      if (aqxj.a(paramView))
      {
        aqxj.b(paramView);
        t();
        aB_();
      }
    }
    for (;;)
    {
      b(f());
      do
      {
        return;
        aqxj.a(paramView);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h(true);
        if ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.i()) || (aqxj.a(aqxj.jdField_b_of_type_Int))) {
          break;
        }
        paramView = bdcd.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131698496);
        paramView.setPositiveButton(2131720960, new bdco());
        paramView.show();
        aqxj.b(aqxj.jdField_b_of_type_Int);
        arng.a("0X800942F");
        break;
        if (b()) {
          break label152;
        }
      } while (!QLog.isColorLevel());
      QLog.i(jdField_b_of_type_JavaLangString, 2, "click too fast , wait a minute.");
      return;
      label152:
      if (f()) {
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
      }
      r();
      arng.a("0X8004AE6");
      arho localarho = new arho(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramView);
      if (arni.a(paramView.jdField_c_of_type_JavaLangString) == 0) {
        localarho.a(a(paramView));
      }
      paramView = new arhj(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, localarho);
      paramView.a(9);
      paramView.a();
    }
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_Aqnl == null) {
      l();
    }
    if (this.jdField_a_of_type_Aqkm == null) {
      k();
    }
    a(false);
  }
  
  private boolean a(WeiYunFileInfo paramWeiYunFileInfo, boolean paramBoolean)
  {
    if (paramWeiYunFileInfo == null) {}
    while ((arni.a(arof.a(paramWeiYunFileInfo.jdField_c_of_type_JavaLangString)) != 0) || ((f()) && (((aqxj.a(paramWeiYunFileInfo)) && (paramBoolean)) || ((!aqxj.a(paramWeiYunFileInfo)) && (!paramBoolean))))) {
      return false;
    }
    if (f())
    {
      if (!paramBoolean) {
        break label65;
      }
      aqxj.a(paramWeiYunFileInfo);
    }
    for (;;)
    {
      return true;
      label65:
      aqxj.b(paramWeiYunFileInfo);
    }
  }
  
  private void v()
  {
    if (this.jdField_a_of_type_Aroh == null) {
      this.jdField_a_of_type_Aroh = new aqkf(this);
    }
    if (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("document") == true) {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.c()) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().u();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a(this.jdField_a_of_type_Aroh);
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
  
  protected aqiz a()
  {
    if (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("picture") == true)
    {
      setEditbarButton(true, true, false, true, true);
      return new aqjl(this.jdField_a_of_type_Aqkm, a(), this.jdField_a_of_type_JavaUtilLinkedHashMap, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_e_of_type_AndroidViewView$OnClickListener, this.jdField_f_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.jdField_d_of_type_AndroidViewView$OnClickListener);
    }
    setEditbarButton(false, true, false, true, true);
    return new aqkd(a(), this.jdField_a_of_type_JavaUtilLinkedHashMap, a(), this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_c_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.jdField_d_of_type_AndroidViewView$OnClickListener);
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
    String str = aroy.a(paramWeiYunFileInfo.b);
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
    if (!bdee.g(a()))
    {
      armz.a(2131692745);
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
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnIndexChangedListener(this.jdField_a_of_type_Arqx);
      return;
    }
    setEditbarButton(false, true, false, true, true);
    v();
  }
  
  void k()
  {
    this.jdField_a_of_type_Aqkm = new aqkg(this);
  }
  
  void l()
  {
    if (this.jdField_a_of_type_Aqnl != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Aqnl);
    }
    this.jdField_a_of_type_Aqnl = new aqki(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_Aqnl);
  }
  
  public void m()
  {
    super.m();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Aqnl);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView
 * JD-Core Version:    0.7.0.1
 */