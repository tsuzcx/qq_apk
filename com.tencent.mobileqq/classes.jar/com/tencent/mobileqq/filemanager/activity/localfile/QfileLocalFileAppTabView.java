package com.tencent.mobileqq.filemanager.activity.localfile;

import ajjy;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import anzd;
import aobv;
import apck;
import apdn;
import apfs;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class QfileLocalFileAppTabView
  extends QfileBaseLocalFileTabView
{
  protected LinkedHashMap<String, List<FileInfo>> a;
  private boolean a;
  private boolean b;
  
  public QfileLocalFileAppTabView(Context paramContext, List<apfs> paramList, boolean paramBoolean)
  {
    super(paramContext, paramList, paramBoolean);
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    setEditbarButton(false, false, true, true, false);
  }
  
  private void c(FileInfo paramFileInfo)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramFileInfo)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramFileInfo);
    }
    String str = paramFileInfo.a();
    if (str != null)
    {
      localObject = str;
      if (str.length() != 0) {}
    }
    else
    {
      localObject = ajjy.a(2131643891);
    }
    if (!this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(localObject)) {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localObject, new ArrayList());
    }
    Object localObject = (List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
    if (((List)localObject).contains(paramFileInfo) == true) {
      return;
    }
    int j = apck.a((List)localObject, paramFileInfo.b());
    int i = j;
    if (j < 0) {
      i = 0;
    }
    ((List)localObject).add(i, paramFileInfo);
  }
  
  private void o()
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    if (this.f) {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(ajjy.a(2131643887), new ArrayList());
    }
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put(ajjy.a(2131643900), new ArrayList());
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a(this);
    this.jdField_a_of_type_JavaLangRunnable = new QfileLocalFileAppTabView.2(this);
    ThreadManager.executeOnFileThread(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  protected anzd a()
  {
    return new aobv(a(), this.jdField_c_of_type_JavaUtilLinkedHashMap, a(), this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_c_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.d);
  }
  
  protected void a()
  {
    ThreadManagerV2.executeOnSubThread(new QfileLocalFileAppTabView.1(this));
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
  
  protected boolean a()
  {
    if (this.b) {
      return this.jdField_a_of_type_Boolean;
    }
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getSharedPreferences("qfile_permission", 0).getBoolean("qfile_permission_access_apps", false);
    this.b = true;
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void b(FileInfo paramFileInfo)
  {
    Thread localThread = Thread.currentThread();
    Looper localLooper = Looper.getMainLooper();
    if (localLooper.getThread() != localThread)
    {
      new Handler(localLooper).post(new QfileLocalFileAppTabView.3(this, paramFileInfo));
      return;
    }
    c(paramFileInfo);
  }
  
  protected boolean b(FileInfo paramFileInfo)
  {
    String str = paramFileInfo.a();
    if (!this.jdField_c_of_type_JavaUtilLinkedHashMap.containsKey(str))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "delRecentFileRecords, fileEntities find, but recentRecords not find!");
      return false;
    }
    ((List)this.jdField_c_of_type_JavaUtilLinkedHashMap.get(str)).remove(paramFileInfo);
    i();
    return true;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.b = true;
    ThreadManagerV2.executeOnSubThread(new QfileLocalFileAppTabView.4(this, paramBoolean));
  }
  
  public void j()
  {
    super.j();
    setEditbarButton(false, false, true, true, false);
    if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.k())
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.c()) {
        break label50;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().R();
    }
    for (;;)
    {
      l();
      return;
      label50:
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().W();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileAppTabView
 * JD-Core Version:    0.7.0.1
 */