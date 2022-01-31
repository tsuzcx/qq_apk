package com.tencent.mobileqq.filemanager.activity.localfile;

import alpo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import aqiy;
import aqiz;
import aqjd;
import aqjf;
import aqlu;
import aqlv;
import aqlw;
import aqsc;
import aqxj;
import arhh;
import arhj;
import arhm;
import armz;
import arng;
import arnh;
import arni;
import arof;
import arol;
import arqx;
import arqz;
import azmj;
import bdcd;
import bdco;
import bdfq;
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
import zen;

public class QfileLocalFilePicTabView
  extends QfileBaseLocalFileTabView
{
  aqjd jdField_a_of_type_Aqjd = null;
  aqjf jdField_a_of_type_Aqjf;
  protected arqx a;
  private View.OnClickListener e = new aqlv(this);
  private View.OnClickListener f = new aqlw(this);
  
  public QfileLocalFilePicTabView(Context paramContext, List<arqz> paramList, boolean paramBoolean)
  {
    super(paramContext, paramList, paramBoolean);
    this.jdField_a_of_type_Arqx = new aqlu(this);
    setEditbarButton(true, false, true, true, true);
    this.jdField_a_of_type_JavaLangRunnable = new QfileLocalFilePicTabView.1(this, paramContext);
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    Object localObject2 = (aqiy)paramView.getTag();
    paramView = (FileInfo)((aqiy)localObject2).jdField_a_of_type_JavaLangObject;
    Object localObject1 = ((aqiy)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
    if (paramView == null) {
      return;
    }
    Object localObject3;
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g()) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h()))
    {
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getSharedPreferences("LAST_CHOOSE_", 0).edit();
      ((SharedPreferences.Editor)localObject3).putInt("GROUP", ((aqiy)localObject2).b);
      ((SharedPreferences.Editor)localObject3).putInt("CHILD", (((aqiy)localObject2).jdField_a_of_type_Int + 1) / 4);
      ((SharedPreferences.Editor)localObject3).commit();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
    if (paramBoolean) {
      if (aqxj.a(paramView))
      {
        aqxj.b(paramView);
        b(paramView, false);
        label139:
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h(true);
        if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.d) && (!arof.b(paramView.c())))
        {
          armz.a(arni.d(paramView.d()) + alpo.a(2131710060));
          aqxj.b(paramView);
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
      aqxj.a(paramView);
      b(paramView, true);
      if ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.i()) || (aqxj.a(aqxj.jdField_a_of_type_Int)) || (aqxj.b(paramView))) {
        break label139;
      }
      localObject1 = bdcd.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131698494);
      ((bdfq)localObject1).setPositiveButton(2131720960, new bdco());
      ((bdfq)localObject1).show();
      aqxj.b(aqxj.jdField_a_of_type_Int);
      arng.a("0X800942D");
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
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
      }
      r();
      localObject2 = arni.a(paramView);
      localObject3 = new arhh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (FileManagerEntity)localObject2, 10000);
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
        aqxj.a((ArrayList)localObject4);
        localObject4 = new Bundle();
        ((Bundle)localObject4).putInt("clicked_file_hashcode", paramView.hashCode());
        ((arhh)localObject3).a((Bundle)localObject4);
      }
      localObject3 = new arhj(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (arhm)localObject3);
      ((arhj)localObject3).a(8);
      if (((((FileManagerEntity)localObject2).nFileType == 0) || (((FileManagerEntity)localObject2).nFileType == 2)) && (localObject1 != null) && ((((View)localObject1).getId() == 2131366299) || (((View)localObject1).getId() == 2131367910))) {
        ((arhj)localObject3).a(zen.a((View)localObject1));
      }
      ((arhj)localObject3).a();
      localObject1 = new arnh();
      ((arnh)localObject1).b = "file_viewer_in";
      ((arnh)localObject1).jdField_a_of_type_Int = 80;
      ((arnh)localObject1).c = arof.a(paramView.d());
      ((arnh)localObject1).jdField_a_of_type_Long = paramView.a();
      arng.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (arnh)localObject1);
      arng.a("0X8004AE5");
    }
  }
  
  private boolean a(FileInfo paramFileInfo, boolean paramBoolean)
  {
    if (paramFileInfo == null) {}
    while ((f()) && (((aqxj.a(paramFileInfo)) && (paramBoolean)) || ((!aqxj.a(paramFileInfo)) && (!paramBoolean)))) {
      return false;
    }
    if (f())
    {
      if (!paramBoolean) {
        break label70;
      }
      if (this.jdField_a_of_type_Aqjd != null) {
        this.jdField_a_of_type_Aqjd.a(paramFileInfo, true);
      }
      aqxj.a(paramFileInfo);
    }
    for (;;)
    {
      return true;
      label70:
      if (this.jdField_a_of_type_Aqjd != null) {
        this.jdField_a_of_type_Aqjd.a(paramFileInfo, false);
      }
      aqxj.b(paramFileInfo);
    }
  }
  
  protected aqiz a()
  {
    this.jdField_a_of_type_Aqjf = new aqjf(a(), this.c, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.f, this.e, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.d);
    return this.jdField_a_of_type_Aqjf;
  }
  
  protected void a()
  {
    ThreadManager.executeOnFileThread(this.jdField_a_of_type_JavaLangRunnable);
    ThreadManager.executeOnFileThread(new QfileLocalFilePicTabView.2(this));
  }
  
  protected void a(aqjd paramaqjd)
  {
    this.jdField_a_of_type_Aqjd = paramaqjd;
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
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnIndexChangedListener(this.jdField_a_of_type_Arqx);
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