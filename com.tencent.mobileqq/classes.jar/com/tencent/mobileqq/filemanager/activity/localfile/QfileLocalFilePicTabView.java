package com.tencent.mobileqq.filemanager.activity.localfile;

import ajyc;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import aopv;
import aopw;
import aoqa;
import aoqc;
import aoss;
import aost;
import aosu;
import aoza;
import apeh;
import apoe;
import apog;
import apoj;
import aptv;
import apuc;
import apud;
import apue;
import apvb;
import apvh;
import apxt;
import apxv;
import axqw;
import bbcv;
import bbdf;
import bbgg;
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
import xpx;

public class QfileLocalFilePicTabView
  extends QfileBaseLocalFileTabView
{
  aoqa jdField_a_of_type_Aoqa = null;
  aoqc jdField_a_of_type_Aoqc;
  protected apxt a;
  private View.OnClickListener e = new aost(this);
  private View.OnClickListener f = new aosu(this);
  
  public QfileLocalFilePicTabView(Context paramContext, List<apxv> paramList, boolean paramBoolean)
  {
    super(paramContext, paramList, paramBoolean);
    this.jdField_a_of_type_Apxt = new aoss(this);
    setEditbarButton(true, false, true, true, true);
    this.jdField_a_of_type_JavaLangRunnable = new QfileLocalFilePicTabView.1(this, paramContext);
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    Object localObject2 = (aopv)paramView.getTag();
    paramView = (FileInfo)((aopv)localObject2).jdField_a_of_type_JavaLangObject;
    Object localObject1 = ((aopv)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
    if (paramView == null) {
      return;
    }
    Object localObject3;
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g()) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h()))
    {
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getSharedPreferences("LAST_CHOOSE_", 0).edit();
      ((SharedPreferences.Editor)localObject3).putInt("GROUP", ((aopv)localObject2).b);
      ((SharedPreferences.Editor)localObject3).putInt("CHILD", (((aopv)localObject2).jdField_a_of_type_Int + 1) / 4);
      ((SharedPreferences.Editor)localObject3).commit();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
    if (paramBoolean) {
      if (apeh.a(paramView))
      {
        apeh.b(paramView);
        b(paramView, false);
        label139:
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h(true);
        if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.d) && (!apvb.b(paramView.c())))
        {
          aptv.a(apue.d(paramView.d()) + ajyc.a(2131709677));
          apeh.b(paramView);
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
      apeh.a(paramView);
      b(paramView, true);
      if ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.i()) || (apeh.a(apeh.jdField_a_of_type_Int)) || (apeh.b(paramView))) {
        break label139;
      }
      localObject1 = bbcv.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131698194);
      ((bbgg)localObject1).setPositiveButton(2131720411, new bbdf());
      ((bbgg)localObject1).show();
      apeh.b(apeh.jdField_a_of_type_Int);
      apuc.a("0X800942D");
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
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
      }
      r();
      localObject2 = apue.a(paramView);
      localObject3 = new apoe(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (FileManagerEntity)localObject2, 10000);
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
        apeh.a((ArrayList)localObject4);
        localObject4 = new Bundle();
        ((Bundle)localObject4).putInt("clicked_file_hashcode", paramView.hashCode());
        ((apoe)localObject3).a((Bundle)localObject4);
      }
      localObject3 = new apog(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (apoj)localObject3);
      ((apog)localObject3).a(8);
      if (((((FileManagerEntity)localObject2).nFileType == 0) || (((FileManagerEntity)localObject2).nFileType == 2)) && (localObject1 != null) && ((((View)localObject1).getId() == 2131366211) || (((View)localObject1).getId() == 2131367776))) {
        ((apog)localObject3).a(xpx.a((View)localObject1));
      }
      ((apog)localObject3).a();
      localObject1 = new apud();
      ((apud)localObject1).b = "file_viewer_in";
      ((apud)localObject1).jdField_a_of_type_Int = 80;
      ((apud)localObject1).c = apvb.a(paramView.d());
      ((apud)localObject1).jdField_a_of_type_Long = paramView.a();
      apuc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (apud)localObject1);
      apuc.a("0X8004AE5");
    }
  }
  
  private boolean a(FileInfo paramFileInfo, boolean paramBoolean)
  {
    if (paramFileInfo == null) {}
    while ((f()) && (((apeh.a(paramFileInfo)) && (paramBoolean)) || ((!apeh.a(paramFileInfo)) && (!paramBoolean)))) {
      return false;
    }
    if (f())
    {
      if (!paramBoolean) {
        break label70;
      }
      if (this.jdField_a_of_type_Aoqa != null) {
        this.jdField_a_of_type_Aoqa.a(paramFileInfo, true);
      }
      apeh.a(paramFileInfo);
    }
    for (;;)
    {
      return true;
      label70:
      if (this.jdField_a_of_type_Aoqa != null) {
        this.jdField_a_of_type_Aoqa.a(paramFileInfo, false);
      }
      apeh.b(paramFileInfo);
    }
  }
  
  protected aopw a()
  {
    this.jdField_a_of_type_Aoqc = new aoqc(a(), this.c, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.f, this.e, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.d);
    return this.jdField_a_of_type_Aoqc;
  }
  
  protected void a()
  {
    ThreadManager.executeOnFileThread(this.jdField_a_of_type_JavaLangRunnable);
    ThreadManager.executeOnFileThread(new QfileLocalFilePicTabView.2(this));
  }
  
  protected void a(aoqa paramaoqa)
  {
    this.jdField_a_of_type_Aoqa = paramaoqa;
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
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnIndexChangedListener(this.jdField_a_of_type_Apxt);
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