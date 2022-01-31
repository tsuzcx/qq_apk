package com.tencent.mobileqq.filemanager.activity.localfile;

import acsb;
import acsc;
import acse;
import acsf;
import acsg;
import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileLocalImageExpandableListAdapter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.IReport_Ver51;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView.OnSelectListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class QfileLocalFilePicTabView
  extends QfileBaseLocalFileTabView
{
  QfileLocalImageExpandableListAdapter jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileLocalImageExpandableListAdapter;
  QfilePinnedHeaderExpandableListView.OnSelectListener jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$OnSelectListener = new acsg(this);
  
  public QfileLocalFilePicTabView(Context paramContext)
  {
    super(paramContext);
    setEditbarButton(true, false, true, true, true);
    this.jdField_a_of_type_JavaLangRunnable = new acsb(this, paramContext);
    ThreadManager.executeOnFileThread(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  private boolean a(FileInfo paramFileInfo, boolean paramBoolean)
  {
    if (paramFileInfo == null) {}
    while ((paramFileInfo.a() != 0) || ((f()) && (((FMDataCache.a(paramFileInfo)) && (paramBoolean)) || ((!FMDataCache.a(paramFileInfo)) && (!paramBoolean))))) {
      return false;
    }
    if (f())
    {
      if (!paramBoolean) {
        break label59;
      }
      FMDataCache.a(paramFileInfo);
    }
    for (;;)
    {
      return true;
      label59:
      FMDataCache.b(paramFileInfo);
    }
  }
  
  protected QfileBaseExpandableListAdapter a()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileLocalImageExpandableListAdapter = new QfileLocalImageExpandableListAdapter(a(), this.jdField_a_of_type_JavaUtilLinkedHashMap, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.c, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.d);
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileLocalImageExpandableListAdapter;
  }
  
  public void a()
  {
    ThreadManager.executeOnFileThread(new acsc(this));
  }
  
  protected void b(FileInfo paramFileInfo)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramFileInfo)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramFileInfo);
    }
    a(new acse(this, paramFileInfo));
  }
  
  protected boolean b(FileInfo paramFileInfo)
  {
    String str = paramFileInfo.a();
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramFileInfo);
    if (!this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(str))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "delRecentFileRecords, fileEntities find, but recentRecords not find!");
      return false;
    }
    ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(str)).remove(paramFileInfo);
    i();
    return true;
  }
  
  public void d(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        b((FileInfo)paramArrayList.next());
      }
    }
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.runOnUiThread(new acsf(this));
  }
  
  public void j()
  {
    super.j();
    setEditbarButton(true, false, true, true, true);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.c()) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a().V();
    }
    for (;;)
    {
      g();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnIndexChangedListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$OnSelectListener);
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a().aa();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView
 * JD-Core Version:    0.7.0.1
 */