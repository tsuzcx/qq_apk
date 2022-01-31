package com.tencent.mobileqq.filemanager.activity.recentfile;

import actn;
import acto;
import actp;
import actq;
import actr;
import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileRecentImageExpandableListAdapter;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.IClickListener_Ver51;
import com.tencent.mobileqq.filemanager.util.IReport_Ver51;
import com.tencent.mobileqq.filemanager.util.QfileTimeUtils;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView.OnSelectListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class QfileRecentPicFileTabView
  extends QfileBaseRecentFileTabView
{
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver;
  private IClickListener_Ver51 jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51;
  QfilePinnedHeaderExpandableListView.OnSelectListener jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$OnSelectListener = new actq(this);
  
  public QfileRecentPicFileTabView(Context paramContext)
  {
    super(paramContext);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver == null) {
      h();
    }
    d();
    setEditbarButton(true, true, true, true, true);
  }
  
  public QfileRecentPicFileTabView(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    d();
    setEditbarButton(false, true, true, true, true);
  }
  
  private boolean a(FileManagerEntity paramFileManagerEntity, boolean paramBoolean)
  {
    if (paramFileManagerEntity == null) {}
    while ((paramFileManagerEntity.nFileType != 0) || ((f()) && (((FMDataCache.a(paramFileManagerEntity)) && (paramBoolean)) || ((!FMDataCache.a(paramFileManagerEntity)) && (!paramBoolean))))) {
      return false;
    }
    if (f())
    {
      if (!paramBoolean) {
        break label59;
      }
      FMDataCache.a(paramFileManagerEntity);
    }
    for (;;)
    {
      return true;
      label59:
      FMDataCache.b(paramFileManagerEntity);
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new actn(this);
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.c()) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a().L();
    }
    while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51 != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51);
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a().Q();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51 = new acto(this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51);
  }
  
  protected QfileBaseExpandableListAdapter a()
  {
    return new QfileRecentImageExpandableListAdapter(a(), this.jdField_a_of_type_JavaUtilLinkedHashMap, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_b_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.c);
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    if (QLog.isDevelopLevel()) {
      QLog.e("crashBUG", 1, "Thread id: " + Thread.currentThread().getId());
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if ((!localFileManagerEntity.bDelInFM) && (localFileManagerEntity.nFileType == 0))
      {
        if ((!FileUtil.b(localFileManagerEntity.getFilePath())) && (!FileUtil.b(localFileManagerEntity.strThumbPath)))
        {
          if (localFileManagerEntity.getCloudType() != 1) {
            break label192;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity, 7);
        }
        for (;;)
        {
          String str = QfileTimeUtils.b(localFileManagerEntity.srvTime);
          if (!this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(str)) {
            this.jdField_a_of_type_JavaUtilLinkedHashMap.put(str, new ArrayList());
          }
          ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(str)).add(localFileManagerEntity);
          break;
          label192:
          if (localFileManagerEntity.getCloudType() == 2) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.WeiYunFileId, localFileManagerEntity.strLargeThumPath, 3, localFileManagerEntity);
          }
        }
      }
    }
    i();
    setSelect(0);
    a(true);
    this.jdField_b_of_type_Boolean = false;
  }
  
  protected void b(FileManagerEntity paramFileManagerEntity)
  {
    if (QLog.isDevelopLevel()) {
      QLog.e("crashBUG", 1, "Thread id: " + Thread.currentThread().getId() + " refreshRecentFileRecords");
    }
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramFileManagerEntity)) {
      if ((this.jdField_b_of_type_JavaLangString == null) || (this.jdField_b_of_type_JavaLangString.trim().length() == 0) || (this.jdField_b_of_type_JavaLangString.equals(paramFileManagerEntity.peerUin))) {}
    }
    while (paramFileManagerEntity.nFileType != 0)
    {
      return;
      this.jdField_a_of_type_JavaUtilList.add(paramFileManagerEntity);
      Collections.sort(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilComparator);
    }
    a(new actp(this, paramFileManagerEntity));
  }
  
  protected boolean b(FileManagerEntity paramFileManagerEntity)
  {
    Object localObject = QfileTimeUtils.b(paramFileManagerEntity.srvTime);
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
  
  public void c(ArrayList paramArrayList)
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
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.runOnUiThread(new actr(this));
  }
  
  public void j()
  {
    super.j();
    setEditbarButton(true, true, true, true, true);
    k();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnIndexChangedListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$OnSelectListener);
  }
  
  public void m()
  {
    super.m();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentPicFileTabView
 * JD-Core Version:    0.7.0.1
 */