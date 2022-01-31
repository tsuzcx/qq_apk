package com.tencent.mobileqq.filemanager.activity.localfile;

import alud;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import aqnh;
import aqni;
import aqnm;
import aqno;
import aqqd;
import aqqe;
import aqqf;
import aqwl;
import arbs;
import arlq;
import arls;
import arlv;
import arri;
import arrp;
import arrq;
import arrr;
import arso;
import arsu;
import arvg;
import arvi;
import azqs;
import bdgm;
import bdgx;
import bdjz;
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
import zjc;

public class QfileLocalFilePicTabView
  extends QfileBaseLocalFileTabView
{
  aqnm jdField_a_of_type_Aqnm = null;
  aqno jdField_a_of_type_Aqno;
  protected arvg a;
  private View.OnClickListener e = new aqqe(this);
  private View.OnClickListener f = new aqqf(this);
  
  public QfileLocalFilePicTabView(Context paramContext, List<arvi> paramList, boolean paramBoolean)
  {
    super(paramContext, paramList, paramBoolean);
    this.jdField_a_of_type_Arvg = new aqqd(this);
    setEditbarButton(true, false, true, true, true);
    this.jdField_a_of_type_JavaLangRunnable = new QfileLocalFilePicTabView.1(this, paramContext);
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    Object localObject2 = (aqnh)paramView.getTag();
    paramView = (FileInfo)((aqnh)localObject2).jdField_a_of_type_JavaLangObject;
    Object localObject1 = ((aqnh)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
    if (paramView == null) {
      return;
    }
    Object localObject3;
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g()) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h()))
    {
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getSharedPreferences("LAST_CHOOSE_", 0).edit();
      ((SharedPreferences.Editor)localObject3).putInt("GROUP", ((aqnh)localObject2).b);
      ((SharedPreferences.Editor)localObject3).putInt("CHILD", (((aqnh)localObject2).jdField_a_of_type_Int + 1) / 4);
      ((SharedPreferences.Editor)localObject3).commit();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
    if (paramBoolean) {
      if (arbs.a(paramView))
      {
        arbs.b(paramView);
        b(paramView, false);
        label139:
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h(true);
        if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.d) && (!arso.b(paramView.c())))
        {
          arri.a(arrr.d(paramView.d()) + alud.a(2131710072));
          arbs.b(paramView);
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
      arbs.a(paramView);
      b(paramView, true);
      if ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.i()) || (arbs.a(arbs.jdField_a_of_type_Int)) || (arbs.b(paramView))) {
        break label139;
      }
      localObject1 = bdgm.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131698506);
      ((bdjz)localObject1).setPositiveButton(2131720972, new bdgx());
      ((bdjz)localObject1).show();
      arbs.b(arbs.jdField_a_of_type_Int);
      arrp.a("0X800942D");
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
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
      }
      r();
      localObject2 = arrr.a(paramView);
      localObject3 = new arlq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (FileManagerEntity)localObject2, 10000);
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
        arbs.a((ArrayList)localObject4);
        localObject4 = new Bundle();
        ((Bundle)localObject4).putInt("clicked_file_hashcode", paramView.hashCode());
        ((arlq)localObject3).a((Bundle)localObject4);
      }
      localObject3 = new arls(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (arlv)localObject3);
      ((arls)localObject3).a(8);
      if (((((FileManagerEntity)localObject2).nFileType == 0) || (((FileManagerEntity)localObject2).nFileType == 2)) && (localObject1 != null) && ((((View)localObject1).getId() == 2131366301) || (((View)localObject1).getId() == 2131367921))) {
        ((arls)localObject3).a(zjc.a((View)localObject1));
      }
      ((arls)localObject3).a();
      localObject1 = new arrq();
      ((arrq)localObject1).b = "file_viewer_in";
      ((arrq)localObject1).jdField_a_of_type_Int = 80;
      ((arrq)localObject1).c = arso.a(paramView.d());
      ((arrq)localObject1).jdField_a_of_type_Long = paramView.a();
      arrp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (arrq)localObject1);
      arrp.a("0X8004AE5");
    }
  }
  
  private boolean a(FileInfo paramFileInfo, boolean paramBoolean)
  {
    if (paramFileInfo == null) {}
    while ((f()) && (((arbs.a(paramFileInfo)) && (paramBoolean)) || ((!arbs.a(paramFileInfo)) && (!paramBoolean)))) {
      return false;
    }
    if (f())
    {
      if (!paramBoolean) {
        break label70;
      }
      if (this.jdField_a_of_type_Aqnm != null) {
        this.jdField_a_of_type_Aqnm.a(paramFileInfo, true);
      }
      arbs.a(paramFileInfo);
    }
    for (;;)
    {
      return true;
      label70:
      if (this.jdField_a_of_type_Aqnm != null) {
        this.jdField_a_of_type_Aqnm.a(paramFileInfo, false);
      }
      arbs.b(paramFileInfo);
    }
  }
  
  protected aqni a()
  {
    this.jdField_a_of_type_Aqno = new aqno(a(), this.c, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.f, this.e, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.d);
    return this.jdField_a_of_type_Aqno;
  }
  
  protected void a()
  {
    ThreadManager.executeOnFileThread(this.jdField_a_of_type_JavaLangRunnable);
    ThreadManager.executeOnFileThread(new QfileLocalFilePicTabView.2(this));
  }
  
  protected void a(aqnm paramaqnm)
  {
    this.jdField_a_of_type_Aqnm = paramaqnm;
  }
  
  public void a(FileInfo paramFileInfo) {}
  
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
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnIndexChangedListener(this.jdField_a_of_type_Arvg);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView
 * JD-Core Version:    0.7.0.1
 */