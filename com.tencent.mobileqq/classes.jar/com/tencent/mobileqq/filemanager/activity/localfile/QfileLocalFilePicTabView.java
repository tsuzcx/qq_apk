package com.tencent.mobileqq.filemanager.activity.localfile;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.ImageHolder;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter.IQfileViewBinder;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileLocalImageExpandableListAdapter;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.open.CommonFileBrowserParams;
import com.tencent.mobileqq.filemanager.fileviewer.open.FileBrowserCreator;
import com.tencent.mobileqq.filemanager.fileviewer.open.IFileBrowserParams;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.FileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.IClickListenerVer51;
import com.tencent.mobileqq.filemanager.util.IReportVer51;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView.OnSelectListener;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView.ScanParams;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mobileqq.filemanager.data.FileInfo;>;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class QfileLocalFilePicTabView
  extends QfileBaseLocalFileTabView
{
  QfileBaseExpandableListAdapter.IQfileViewBinder jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter$IQfileViewBinder = null;
  QfileLocalImageExpandableListAdapter jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileLocalImageExpandableListAdapter;
  protected QfilePinnedHeaderExpandableListView.OnSelectListener a;
  private IClickListenerVer51 b = null;
  private View.OnClickListener e = new QfileLocalFilePicTabView.5(this);
  private View.OnClickListener f;
  
  public QfileLocalFilePicTabView(Context paramContext, List<QfileTabBarView.ScanParams> paramList, boolean paramBoolean)
  {
    super(paramContext, paramList, paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$OnSelectListener = new QfileLocalFilePicTabView.4(this);
    this.jdField_f_of_type_AndroidViewView$OnClickListener = new QfileLocalFilePicTabView.6(this);
    setEditbarButton(true, false, true, true, true);
    this.jdField_a_of_type_JavaLangRunnable = new QfileLocalFilePicTabView.1(this);
  }
  
  private ArrayList<FileInfo> a()
  {
    if (this.jdField_f_of_type_Boolean) {}
    for (HashMap localHashMap = (HashMap)FileCategoryUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);; localHashMap = null)
    {
      if (localHashMap == null) {
        localHashMap = new HashMap();
      }
      for (;;)
      {
        Object localObject = this.jdField_d_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext()) {
          FileCategoryUtil.a(true, ((QfileTabBarView.ScanParams)((Iterator)localObject).next()).a(), ".jpg|.bmp|.jpeg|.gif|.png|.ico|", "", localHashMap, this);
        }
        if (this.jdField_f_of_type_Boolean) {}
        for (localObject = FMSettings.a().a();; localObject = null)
        {
          if (localObject != null) {
            FileCategoryUtil.a(true, (String)localObject, ".jpg|.bmp|.jpeg|.gif|.png|.ico|", "", localHashMap, this);
          }
          localObject = new ArrayList();
          ((ArrayList)localObject).addAll(this.jdField_a_of_type_JavaUtilArrayList);
          if (!d()) {
            break;
          }
          return localObject;
        }
        FileCategoryUtil.a(localHashMap);
        if (localHashMap != null)
        {
          Iterator localIterator = localHashMap.keySet().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if (!"QQfile_recv".equalsIgnoreCase(str)) {
              ((ArrayList)localObject).addAll((List)localHashMap.get(str));
            }
          }
        }
        return localObject;
      }
    }
  }
  
  private Map<String, List<FileInfo>> a(ArrayList<FileInfo> paramArrayList)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put(HardCodeUtil.a(2131709650), new ArrayList());
    localLinkedHashMap.put(HardCodeUtil.a(2131709649), new ArrayList());
    Iterator localIterator = paramArrayList.iterator();
    Object localObject2;
    Object localObject1;
    while (localIterator.hasNext())
    {
      localObject2 = (FileInfo)localIterator.next();
      localObject1 = ((FileInfo)localObject2).a();
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equalsIgnoreCase("QQfile_recv")))
      {
        paramArrayList = (ArrayList<FileInfo>)localObject1;
        if (!((String)localObject1).equalsIgnoreCase("QQ")) {}
      }
      else
      {
        paramArrayList = HardCodeUtil.a(2131709641);
      }
      localObject1 = paramArrayList;
      if (paramArrayList.equalsIgnoreCase("camera") == true) {
        localObject1 = HardCodeUtil.a(2131709665);
      }
      if (!localLinkedHashMap.containsKey(localObject1)) {
        localLinkedHashMap.put(localObject1, new ArrayList());
      }
      ((List)localLinkedHashMap.get(localObject1)).add(localObject2);
    }
    if (((FMActivity)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity).h() == 1)
    {
      paramArrayList = HardCodeUtil.a(2131698174);
      localLinkedHashMap.put(paramArrayList, new ArrayList());
      localObject1 = new HashMap();
      FileCategoryUtil.a(true, VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH) + "/chatpic/chatimg/", "", "", (HashMap)localObject1, null);
      localIterator = ((HashMap)localObject1).keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (List)((HashMap)localObject1).get((String)localIterator.next());
        ((List)localLinkedHashMap.get(paramArrayList)).addAll((Collection)localObject2);
      }
    }
    paramArrayList = localLinkedHashMap.keySet().iterator();
    while (paramArrayList.hasNext()) {
      if (((List)localLinkedHashMap.get((String)paramArrayList.next())).size() == 0) {
        paramArrayList.remove();
      }
    }
    return localLinkedHashMap;
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    Object localObject2 = (ImageHolder)paramView.getTag();
    paramView = (FileInfo)((ImageHolder)localObject2).jdField_a_of_type_JavaLangObject;
    Object localObject1 = ((ImageHolder)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
    if (paramView == null) {
      return;
    }
    Object localObject3;
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g()) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h()))
    {
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getSharedPreferences("LAST_CHOOSE_", 0).edit();
      ((SharedPreferences.Editor)localObject3).putInt("GROUP", ((ImageHolder)localObject2).b);
      ((SharedPreferences.Editor)localObject3).putInt("CHILD", (((ImageHolder)localObject2).jdField_a_of_type_Int + 1) / 4);
      ((SharedPreferences.Editor)localObject3).commit();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().b();
    if (paramBoolean) {
      if (FMDataCache.a(paramView))
      {
        FMDataCache.b(paramView);
        b(paramView, false);
        label141:
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h(true);
        if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.jdField_f_of_type_Boolean) && (!FileUtil.b(paramView.c())))
        {
          FMToastUtil.a(FileManagerUtil.d(paramView.d()) + HardCodeUtil.a(2131709652));
          FMDataCache.b(paramView);
        }
        f();
        w();
        k();
      }
    }
    for (;;)
    {
      a(g());
      return;
      FMDataCache.a(paramView);
      b(paramView, true);
      if ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.i()) || (FMDataCache.a(FMDataCache.jdField_a_of_type_Int)) || (FMDataCache.b(paramView))) {
        break label141;
      }
      localObject1 = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131698166);
      ((QQCustomDialog)localObject1).setPositiveButton(2131720056, new DialogUtil.DialogOnClickAdapter());
      ((QQCustomDialog)localObject1).show();
      FMDataCache.b(FMDataCache.jdField_a_of_type_Int);
      FileManagerReporter.a("0X800942D");
      break label141;
      if (!c())
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i(jdField_a_of_type_JavaLangString, 2, "click too fast , wait a minute.");
        return;
      }
      if (g()) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
      }
      u();
      localObject2 = FileManagerUtil.a(paramView);
      localObject3 = new CommonFileBrowserParams(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (FileManagerEntity)localObject2, 10000);
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
        FMDataCache.a((ArrayList)localObject4);
        localObject4 = new Bundle();
        ((Bundle)localObject4).putInt("clicked_file_hashcode", paramView.hashCode());
        ((CommonFileBrowserParams)localObject3).a((Bundle)localObject4);
      }
      localObject3 = new FileBrowserCreator(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (IFileBrowserParams)localObject3);
      ((FileBrowserCreator)localObject3).a(8);
      if (((((FileManagerEntity)localObject2).nFileType == 0) || (((FileManagerEntity)localObject2).nFileType == 2)) && (localObject1 != null) && ((((View)localObject1).getId() == 2131366919) || (((View)localObject1).getId() == 2131368729))) {
        ((FileBrowserCreator)localObject3).a(AnimationUtils.a((View)localObject1));
      }
      ((FileBrowserCreator)localObject3).a();
      localObject1 = new FileManagerReporter.FileAssistantReportData();
      ((FileManagerReporter.FileAssistantReportData)localObject1).b = "file_viewer_in";
      ((FileManagerReporter.FileAssistantReportData)localObject1).jdField_a_of_type_Int = 80;
      ((FileManagerReporter.FileAssistantReportData)localObject1).c = FileUtil.a(paramView.d());
      ((FileManagerReporter.FileAssistantReportData)localObject1).jdField_a_of_type_Long = paramView.a();
      FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (FileManagerReporter.FileAssistantReportData)localObject1);
      FileManagerReporter.a("0X8004AE5");
    }
  }
  
  private boolean a(FileInfo paramFileInfo, boolean paramBoolean)
  {
    if (paramFileInfo == null) {}
    while ((g()) && (((FMDataCache.a(paramFileInfo)) && (paramBoolean)) || ((!FMDataCache.a(paramFileInfo)) && (!paramBoolean)))) {
      return false;
    }
    if (g())
    {
      if (!paramBoolean) {
        break label70;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter$IQfileViewBinder != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter$IQfileViewBinder.a(paramFileInfo, true);
      }
      FMDataCache.a(paramFileInfo);
    }
    for (;;)
    {
      return true;
      label70:
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter$IQfileViewBinder != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter$IQfileViewBinder.a(paramFileInfo, false);
      }
      FMDataCache.b(paramFileInfo);
    }
  }
  
  protected QfileBaseExpandableListAdapter a()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileLocalImageExpandableListAdapter = new QfileLocalImageExpandableListAdapter(a(), this.c, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_f_of_type_AndroidViewView$OnClickListener, this.e, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.jdField_d_of_type_AndroidViewView$OnClickListener);
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileLocalImageExpandableListAdapter;
  }
  
  protected void a()
  {
    ThreadManagerV2.excute(this.jdField_a_of_type_JavaLangRunnable, 64, null, true);
  }
  
  protected void a(QfileBaseExpandableListAdapter.IQfileViewBinder paramIQfileViewBinder)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter$IQfileViewBinder = paramIQfileViewBinder;
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
    a(new QfileLocalFilePicTabView.2(this, paramFileInfo));
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
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().T();
    }
    for (;;)
    {
      o();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnIndexChangedListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$OnSelectListener);
      return;
      label61:
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().Y();
    }
  }
  
  public void p()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.runOnUiThread(new QfileLocalFilePicTabView.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView
 * JD-Core Version:    0.7.0.1
 */