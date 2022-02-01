package com.tencent.mobileqq.filemanager.activity.recentfile;

import android.content.Context;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.IClickListenerVer51;
import com.tencent.mobileqq.filemanager.util.IReportVer51;
import com.tencent.mobileqq.filemanager.util.QfileTimeUtils;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class QfileRecentAllFileTabView
  extends QfileBaseRecentFileTabView
{
  private IClickListenerVer51 a;
  
  public QfileRecentAllFileTabView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListenerVer51 = null;
    f();
    setEditbarButton(false, true, true, true, true);
  }
  
  public QfileRecentAllFileTabView(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListenerVer51 = null;
    f();
    setEditbarButton(false, true, true, true, true);
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.c()) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().F();
    }
    while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListenerVer51 != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListenerVer51);
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().K();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListenerVer51 = new QfileRecentAllFileTabView.1(this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListenerVer51);
  }
  
  protected QfileBaseExpandableListAdapter a()
  {
    return new QfileRecentFileBaseExpandableListAdapter(a(), this.jdField_a_of_type_JavaUtilLinkedHashMap, a(), this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_b_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.c);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if (!localFileManagerEntity.bDelInFM)
      {
        String str = QfileTimeUtils.a(localFileManagerEntity.srvTime);
        if (!this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(str)) {
          this.jdField_a_of_type_JavaUtilLinkedHashMap.put(str, new ArrayList());
        }
        ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(str)).add(localFileManagerEntity);
      }
    }
    i();
    setSelect(0);
    a(true);
    this.jdField_b_of_type_Boolean = false;
  }
  
  protected void b(FileManagerEntity paramFileManagerEntity)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramFileManagerEntity))
    {
      if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.trim().length() != 0) && (!this.jdField_b_of_type_JavaLangString.equals(paramFileManagerEntity.peerUin))) {
        return;
      }
      this.jdField_a_of_type_JavaUtilList.add(paramFileManagerEntity);
      Collections.sort(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilComparator);
    }
    a(new QfileRecentAllFileTabView.2(this, paramFileManagerEntity));
  }
  
  protected boolean b(FileManagerEntity paramFileManagerEntity)
  {
    Object localObject = QfileTimeUtils.a(paramFileManagerEntity.srvTime);
    if (!this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(localObject))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "delRecentFileRecords, fileEntities find, but recentRecords not find!");
      return false;
    }
    synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      localObject = ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject)).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (paramFileManagerEntity == (FileManagerEntity)((Iterator)localObject).next()) {
          ((Iterator)localObject).remove();
        }
      }
      i();
      return true;
    }
  }
  
  protected void c(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity.nFileType == 13)
    {
      TeamWorkUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramFileManagerEntity);
      return;
    }
    super.c(paramFileManagerEntity);
  }
  
  public void c(ArrayList<FileManagerEntity> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        b((FileManagerEntity)paramArrayList.next());
      }
    }
  }
  
  public void j()
  {
    super.j();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h(true);
    setEditbarButton(false, true, true, true, true);
    k();
  }
  
  public void m()
  {
    super.m();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentAllFileTabView
 * JD-Core Version:    0.7.0.1
 */