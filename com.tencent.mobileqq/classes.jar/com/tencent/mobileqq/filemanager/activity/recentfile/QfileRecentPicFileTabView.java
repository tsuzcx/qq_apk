package com.tencent.mobileqq.filemanager.activity.recentfile;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.ImageHolder;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileRecentImageExpandableListAdapter;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.open.CommonFileBrowserParams;
import com.tencent.mobileqq.filemanager.fileviewer.open.FileBrowserCreator;
import com.tencent.mobileqq.filemanager.fileviewer.open.IFileBrowserParams;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.FileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.IClickListenerVer51;
import com.tencent.mobileqq.filemanager.util.IReportVer51;
import com.tencent.mobileqq.filemanager.util.QfileTimeUtils;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView.OnSelectListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class QfileRecentPicFileTabView
  extends QfileBaseRecentFileTabView
{
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = null;
  private IClickListenerVer51 jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListenerVer51 = null;
  QfilePinnedHeaderExpandableListView.OnSelectListener jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$OnSelectListener = new QfileRecentPicFileTabView.4(this);
  private View.OnClickListener d = new QfileRecentPicFileTabView.6(this);
  private View.OnClickListener e = new QfileRecentPicFileTabView.7(this);
  
  public QfileRecentPicFileTabView(Context paramContext)
  {
    super(paramContext);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver == null) {
      o();
    }
    f();
    setEditbarButton(true, true, true, true, true);
  }
  
  public QfileRecentPicFileTabView(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    f();
    setEditbarButton(false, true, true, true, true);
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    Object localObject1 = (ImageHolder)paramView.getTag();
    paramView = (FileManagerEntity)((ImageHolder)localObject1).jdField_a_of_type_JavaLangObject;
    localObject1 = ((ImageHolder)localObject1).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
    if (paramView == null) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().b();
      if (paramBoolean)
      {
        if (FMDataCache.a(paramView)) {
          FMDataCache.b(paramView);
        }
        for (;;)
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f) && (paramView.cloudType == 3) && (!FileUtil.b(paramView.getFilePath())))
          {
            FMToastUtil.a(FileManagerUtil.d(paramView.fileName) + HardCodeUtil.a(2131709671));
            FMDataCache.b(paramView);
          }
          w();
          g();
          return;
          FMDataCache.a(paramView);
          if (c(paramView))
          {
            localObject1 = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131698166);
            ((QQCustomDialog)localObject1).setPositiveButton(2131720056, new DialogUtil.DialogOnClickAdapter());
            ((QQCustomDialog)localObject1).show();
            FMDataCache.b(FMDataCache.jdField_a_of_type_Int);
            FileManagerReporter.a("0X800942D");
          }
        }
      }
      if (g()) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
      }
      if (c()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, "click too fast , wait a minute.");
    return;
    u();
    Object localObject2 = new FileManagerReporter.FileAssistantReportData();
    ((FileManagerReporter.FileAssistantReportData)localObject2).jdField_b_of_type_JavaLangString = "file_viewer_in";
    ((FileManagerReporter.FileAssistantReportData)localObject2).jdField_a_of_type_Int = 73;
    ((FileManagerReporter.FileAssistantReportData)localObject2).c = FileUtil.a(paramView.fileName);
    ((FileManagerReporter.FileAssistantReportData)localObject2).jdField_a_of_type_Long = paramView.fileSize;
    FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (FileManagerReporter.FileAssistantReportData)localObject2);
    FileManagerReporter.a("0X8004AE4");
    localObject2 = new CommonFileBrowserParams(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramView, 10001);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("from_qlink_enter_recent", this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g());
    if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.trim().length() != 0)) {
      localBundle.putString("c2c_discussion_recentfile", this.jdField_b_of_type_JavaLangString);
    }
    ((CommonFileBrowserParams)localObject2).a(localBundle);
    localObject2 = new FileBrowserCreator(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (IFileBrowserParams)localObject2);
    ((FileBrowserCreator)localObject2).a(7);
    if (((paramView.nFileType == 0) || (paramView.nFileType == 2)) && (localObject1 != null) && ((((View)localObject1).getId() == 2131366919) || (((View)localObject1).getId() == 2131368729)))
    {
      ((FileBrowserCreator)localObject2).a(AnimationUtils.a((View)localObject1));
      ((FileBrowserCreator)localObject2).a(true);
    }
    if (paramView.nFileType == 2)
    {
      if (FileUtil.b(paramView.getFilePath()))
      {
        ((FileBrowserCreator)localObject2).a();
        return;
      }
      if ((paramView.isSend()) && (!FileUtil.b(paramView.getFilePath())) && (paramView.status != 1) && (paramView.status != -1))
      {
        FMToastUtil.a(HardCodeUtil.a(2131709668));
        return;
      }
      if (!NetworkUtil.d(BaseApplication.getContext()))
      {
        FMToastUtil.a(2131692602);
        return;
      }
      ((FileBrowserCreator)localObject2).a();
      return;
    }
    ((FileBrowserCreator)localObject2).a();
  }
  
  private boolean a(FileManagerEntity paramFileManagerEntity, boolean paramBoolean)
  {
    if (paramFileManagerEntity == null) {}
    while ((paramFileManagerEntity.nFileType != 0) || ((g()) && (((FMDataCache.a(paramFileManagerEntity)) && (paramBoolean)) || ((!FMDataCache.a(paramFileManagerEntity)) && (!paramBoolean))))) {
      return false;
    }
    if (g())
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
  
  private boolean c(FileManagerEntity paramFileManagerEntity)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.i()) && (!FMDataCache.a(FMDataCache.jdField_a_of_type_Int)) && (!FMDataCache.b(paramFileManagerEntity));
  }
  
  private void o()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new QfileRecentPicFileTabView.1(this);
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.c()) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().J();
    }
    while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListenerVer51 != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListenerVer51);
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().O();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListenerVer51 = new QfileRecentPicFileTabView.2(this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListenerVer51);
  }
  
  protected QfileBaseExpandableListAdapter a()
  {
    return new QfileRecentImageExpandableListAdapter(a(), this.jdField_a_of_type_JavaUtilLinkedHashMap, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.d, this.e, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.c);
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
            break label194;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(localFileManagerEntity, 7);
        }
        for (;;)
        {
          String str = QfileTimeUtils.a(localFileManagerEntity.srvTime);
          if (!this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(str)) {
            this.jdField_a_of_type_JavaUtilLinkedHashMap.put(str, new ArrayList());
          }
          ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(str)).add(localFileManagerEntity);
          break;
          label194:
          if (localFileManagerEntity.getCloudType() == 2) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(localFileManagerEntity.WeiYunFileId, localFileManagerEntity.strLargeThumPath, 3, localFileManagerEntity);
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
    a(new QfileRecentPicFileTabView.3(this, paramFileManagerEntity));
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
    setEditbarButton(true, true, true, true, true);
    p();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnIndexChangedListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$OnSelectListener);
  }
  
  public void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.runOnUiThread(new QfileRecentPicFileTabView.5(this));
  }
  
  public void m()
  {
    super.m();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentPicFileTabView
 * JD-Core Version:    0.7.0.1
 */