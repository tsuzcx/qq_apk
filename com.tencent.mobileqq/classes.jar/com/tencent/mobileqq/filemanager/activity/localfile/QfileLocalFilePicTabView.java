package com.tencent.mobileqq.filemanager.activity.localfile;

import ajjy;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import anzc;
import anzd;
import anzh;
import anzj;
import aoby;
import aobz;
import aoca;
import aoig;
import aonm;
import aowq;
import aows;
import aowv;
import apcb;
import apci;
import apcj;
import apck;
import apdh;
import apdn;
import apfq;
import apfs;
import awqx;
import babr;
import baca;
import bafb;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import xgx;

public class QfileLocalFilePicTabView
  extends QfileBaseLocalFileTabView
{
  anzh jdField_a_of_type_Anzh = null;
  anzj jdField_a_of_type_Anzj;
  protected apfq a;
  private View.OnClickListener e = new aobz(this);
  private View.OnClickListener f = new aoca(this);
  
  public QfileLocalFilePicTabView(Context paramContext, List<apfs> paramList, boolean paramBoolean)
  {
    super(paramContext, paramList, paramBoolean);
    this.jdField_a_of_type_Apfq = new aoby(this);
    setEditbarButton(true, false, true, true, true);
    this.jdField_a_of_type_JavaLangRunnable = new QfileLocalFilePicTabView.1(this, paramContext);
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    Object localObject2 = (anzc)paramView.getTag();
    paramView = (FileInfo)((anzc)localObject2).jdField_a_of_type_JavaLangObject;
    Object localObject1 = ((anzc)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
    if (paramView == null) {
      return;
    }
    Object localObject3;
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g()) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h()))
    {
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getSharedPreferences("LAST_CHOOSE_", 0).edit();
      ((SharedPreferences.Editor)localObject3).putInt("GROUP", ((anzc)localObject2).b);
      ((SharedPreferences.Editor)localObject3).putInt("CHILD", (((anzc)localObject2).jdField_a_of_type_Int + 1) / 4);
      ((SharedPreferences.Editor)localObject3).commit();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
    if (paramBoolean) {
      if (aonm.a(paramView))
      {
        aonm.b(paramView);
        b(paramView, false);
        label139:
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h(true);
        if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.d) && (!apdh.b(paramView.c())))
        {
          apcb.a(apck.d(paramView.d()) + ajjy.a(2131643892));
          aonm.b(paramView);
        }
        f();
        t();
        k();
      }
    }
    for (;;)
    {
      a(f());
      return;
      aonm.a(paramView);
      b(paramView, true);
      if ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.i()) || (aonm.a(aonm.jdField_a_of_type_Int)) || (aonm.b(paramView))) {
        break label139;
      }
      localObject1 = babr.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131632462);
      ((bafb)localObject1).setPositiveButton(2131654515, new baca());
      ((bafb)localObject1).show();
      aonm.b(aonm.jdField_a_of_type_Int);
      apci.a("0X800942D");
      break label139;
      if (!b())
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i(jdField_a_of_type_JavaLangString, 2, "click too fast , wait a minute.");
        return;
      }
      if (f()) {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
      }
      r();
      localObject2 = apck.a(paramView);
      localObject3 = new aowq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (FileManagerEntity)localObject2, 10000);
      if (((FileManagerEntity)localObject2).nFileType == 0)
      {
        Object localObject4 = new ArrayList();
        if (this.c != null)
        {
          Iterator localIterator = this.c.keySet().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            ((ArrayList)localObject4).addAll((Collection)this.c.get(str));
          }
        }
        aonm.a((ArrayList)localObject4);
        localObject4 = new Bundle();
        ((Bundle)localObject4).putInt("clicked_file_hashcode", paramView.hashCode());
        ((aowq)localObject3).a((Bundle)localObject4);
      }
      localObject3 = new aows(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (aowv)localObject3);
      ((aows)localObject3).a(8);
      if (((((FileManagerEntity)localObject2).nFileType == 0) || (((FileManagerEntity)localObject2).nFileType == 2)) && (localObject1 != null) && ((((View)localObject1).getId() == 2131300609) || (((View)localObject1).getId() == 2131302158))) {
        ((aows)localObject3).a(xgx.a((View)localObject1));
      }
      ((aows)localObject3).a();
      localObject1 = new apcj();
      ((apcj)localObject1).b = "file_viewer_in";
      ((apcj)localObject1).jdField_a_of_type_Int = 80;
      ((apcj)localObject1).c = apdh.a(paramView.d());
      ((apcj)localObject1).jdField_a_of_type_Long = paramView.a();
      apci.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (apcj)localObject1);
      apci.a("0X8004AE5");
    }
  }
  
  private boolean a(FileInfo paramFileInfo, boolean paramBoolean)
  {
    if (paramFileInfo == null) {}
    while ((f()) && (((aonm.a(paramFileInfo)) && (paramBoolean)) || ((!aonm.a(paramFileInfo)) && (!paramBoolean)))) {
      return false;
    }
    if (f())
    {
      if (!paramBoolean) {
        break label70;
      }
      if (this.jdField_a_of_type_Anzh != null) {
        this.jdField_a_of_type_Anzh.a(paramFileInfo, true);
      }
      aonm.a(paramFileInfo);
    }
    for (;;)
    {
      return true;
      label70:
      if (this.jdField_a_of_type_Anzh != null) {
        this.jdField_a_of_type_Anzh.a(paramFileInfo, false);
      }
      aonm.b(paramFileInfo);
    }
  }
  
  protected anzd a()
  {
    this.jdField_a_of_type_Anzj = new anzj(a(), this.c, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.f, this.e, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.d);
    return this.jdField_a_of_type_Anzj;
  }
  
  protected void a()
  {
    ThreadManager.executeOnFileThread(this.jdField_a_of_type_JavaLangRunnable);
    ThreadManager.executeOnFileThread(new QfileLocalFilePicTabView.2(this));
  }
  
  protected void a(anzh paramanzh)
  {
    this.jdField_a_of_type_Anzh = paramanzh;
  }
  
  public void a(Set<FileInfo> paramSet)
  {
    if ((paramSet == null) || (paramSet.size() == 0)) {}
    for (;;)
    {
      return;
      paramSet = paramSet.iterator();
      while (paramSet.hasNext()) {
        b((FileInfo)paramSet.next());
      }
    }
  }
  
  protected void b(FileInfo paramFileInfo)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramFileInfo)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramFileInfo);
    }
    a(new QfileLocalFilePicTabView.3(this, paramFileInfo));
  }
  
  protected boolean b(FileInfo paramFileInfo)
  {
    String str = paramFileInfo.a();
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramFileInfo);
    if (!this.c.containsKey(str))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "delRecentFileRecords, fileEntities find, but recentRecords not find!");
      return false;
    }
    ((List)this.c.get(str)).remove(paramFileInfo);
    i();
    return true;
  }
  
  public void j()
  {
    super.j();
    setEditbarButton(true, false, true, true, true);
    if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.k())
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.c()) {
        break label61;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().V();
    }
    for (;;)
    {
      l();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnIndexChangedListener(this.jdField_a_of_type_Apfq);
      return;
      label61:
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().aa();
    }
  }
  
  public void o()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.runOnUiThread(new QfileLocalFilePicTabView.4(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView
 * JD-Core Version:    0.7.0.1
 */