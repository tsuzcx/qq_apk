package com.tencent.mobileqq.filemanager.activity.cloudfile;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import ataa;
import atab;
import atan;
import atbf;
import atbh;
import atbi;
import atbk;
import atbl;
import atbm;
import atbn;
import atbo;
import atfq;
import athn;
import atlf;
import atlh;
import atpm;
import atyk;
import atyp;
import audr;
import audy;
import auea;
import auex;
import aufb;
import aufn;
import augh;
import bdla;
import bhdj;
import bhdx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class QfileCloudFileTabView
  extends QfileBaseCloudFileTabView
{
  atbo jdField_a_of_type_Atbo = null;
  atfq jdField_a_of_type_Atfq = null;
  private auex jdField_a_of_type_Auex;
  augh jdField_a_of_type_Augh = new atbl(this);
  final int b;
  public int c;
  public String c;
  public boolean c;
  private int jdField_e_of_type_Int;
  private View.OnClickListener jdField_e_of_type_AndroidViewView$OnClickListener = new atbm(this);
  private View.OnClickListener jdField_f_of_type_AndroidViewView$OnClickListener = new atbn(this);
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
    paramView = (WeiYunFileInfo)((ataa)paramView.getTag()).a;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().b();
    if (paramBoolean) {
      if (atpm.a(paramView))
      {
        atpm.b(paramView);
        w();
        an_();
      }
    }
    for (;;)
    {
      b(g());
      do
      {
        return;
        atpm.a(paramView);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h(true);
        if ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.i()) || (atpm.a(atpm.jdField_b_of_type_Int))) {
          break;
        }
        paramView = bhdj.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131697911);
        paramView.setPositiveButton(2131719492, new bhdx());
        paramView.show();
        atpm.b(atpm.jdField_b_of_type_Int);
        audy.a("0X800942F");
        break;
        if (c()) {
          break label152;
        }
      } while (!QLog.isColorLevel());
      QLog.i(jdField_b_of_type_JavaLangString, 2, "click too fast , wait a minute.");
      return;
      label152:
      if (g()) {
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
      }
      u();
      audy.a("0X8004AE6");
      atyp localatyp = new atyp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramView);
      if (auea.a(paramView.jdField_c_of_type_JavaLangString) == 0) {
        localatyp.a(a(paramView));
      }
      paramView = new atyk(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, localatyp);
      paramView.a(9);
      paramView.a();
    }
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_Atfq == null) {
      l();
    }
    if (this.jdField_a_of_type_Atbo == null) {
      k();
    }
    a(false);
  }
  
  private boolean a(WeiYunFileInfo paramWeiYunFileInfo, boolean paramBoolean)
  {
    if (paramWeiYunFileInfo == null) {}
    while ((auea.a(FileUtil.getExtension(paramWeiYunFileInfo.jdField_c_of_type_JavaLangString)) != 0) || ((g()) && (((atpm.a(paramWeiYunFileInfo)) && (paramBoolean)) || ((!atpm.a(paramWeiYunFileInfo)) && (!paramBoolean))))) {
      return false;
    }
    if (g())
    {
      if (!paramBoolean) {
        break label65;
      }
      atpm.a(paramWeiYunFileInfo);
    }
    for (;;)
    {
      return true;
      label65:
      atpm.b(paramWeiYunFileInfo);
    }
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_Auex == null) {
      this.jdField_a_of_type_Auex = new atbh(this);
    }
    if (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("document") == true) {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.c()) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().s();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a(this.jdField_a_of_type_Auex);
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().x();
      continue;
      if (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("picture") == true)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.c()) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().t();
        } else {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().y();
        }
      }
      else if (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("video") == true)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.c()) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().u();
        } else {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().z();
        }
      }
      else if (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("music") == true)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.c()) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().v();
        } else {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().A();
        }
      }
      else if (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("other") == true) {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.c()) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().w();
        } else {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().B();
        }
      }
    }
  }
  
  protected atab a()
  {
    if (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("picture") == true)
    {
      setEditbarButton(true, true, false, true, true);
      return new atan(this.jdField_a_of_type_Atbo, a(), this.jdField_a_of_type_JavaUtilLinkedHashMap, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_e_of_type_AndroidViewView$OnClickListener, this.jdField_f_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.jdField_d_of_type_AndroidViewView$OnClickListener);
    }
    setEditbarButton(false, true, false, true, true);
    return new atbf(a(), this.jdField_a_of_type_JavaUtilLinkedHashMap, a(), this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_c_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.jdField_d_of_type_AndroidViewView$OnClickListener);
  }
  
  public void a()
  {
    a(new QfileCloudFileTabView.4(this));
  }
  
  protected void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(this.jdField_e_of_type_Int, this.jdField_a_of_type_JavaLangString, 0, 15, this.jdField_c_of_type_JavaLangString);
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
    String str = aufn.a(paramWeiYunFileInfo.b);
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
    if (!NetworkUtil.isNetworkAvailable(a()))
    {
      audr.a(2131692469);
      return;
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(this.jdField_e_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_Int * 15, 15, this.jdField_c_of_type_JavaLangString);
    f();
  }
  
  public void j()
  {
    super.j();
    if (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("picture") == true)
    {
      setEditbarButton(true, true, false, true, true);
      p();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnIndexChangedListener(this.jdField_a_of_type_Augh);
      return;
    }
    setEditbarButton(false, true, false, true, true);
    p();
  }
  
  void k()
  {
    this.jdField_a_of_type_Atbo = new atbi(this);
  }
  
  void l()
  {
    if (this.jdField_a_of_type_Atfq != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().deleteObserver(this.jdField_a_of_type_Atfq);
    }
    this.jdField_a_of_type_Atfq = new atbk(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().addObserver(this.jdField_a_of_type_Atfq);
  }
  
  public void m()
  {
    super.m();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().deleteObserver(this.jdField_a_of_type_Atfq);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView
 * JD-Core Version:    0.7.0.1
 */