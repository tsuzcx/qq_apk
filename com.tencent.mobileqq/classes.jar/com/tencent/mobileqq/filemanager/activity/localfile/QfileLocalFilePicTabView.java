package com.tencent.mobileqq.filemanager.activity.localfile;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.ImageHolder;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter.IQfileViewBinder;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileLocalImageExpandableListAdapter;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.FileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.IClickListenerVer51;
import com.tencent.mobileqq.filemanager.util.IReportVer51;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView.OnSelectListener;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView.ScanParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.FileUtils;
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
    if (this.jdField_f_of_type_Boolean) {
      localObject1 = (HashMap)FileCategoryUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new HashMap();
    }
    Object localObject1 = this.jdField_d_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      FileCategoryUtil.a(true, ((QfileTabBarView.ScanParams)((Iterator)localObject1).next()).a(), ".jpg|.bmp|.jpeg|.gif|.png|.ico|", "", (HashMap)localObject2, this);
    }
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).addAll(this.jdField_a_of_type_JavaUtilArrayList);
    if (d()) {
      return localObject1;
    }
    FileCategoryUtil.a((Map)localObject2);
    if (localObject2 != null)
    {
      Iterator localIterator = ((HashMap)localObject2).keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!"QQfile_recv".equalsIgnoreCase(str)) {
          ((ArrayList)localObject1).addAll((List)((HashMap)localObject2).get(str));
        }
      }
    }
    return localObject1;
  }
  
  private Map<String, List<FileInfo>> a(ArrayList<FileInfo> paramArrayList)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put(HardCodeUtil.a(2131698208), new ArrayList());
    localLinkedHashMap.put(HardCodeUtil.a(2131698192), new ArrayList());
    Object localObject2 = paramArrayList.iterator();
    Object localObject3;
    Object localObject1;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (FileInfo)((Iterator)localObject2).next();
      localObject1 = ((FileInfo)localObject3).a();
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equalsIgnoreCase("QQfile_recv")))
      {
        paramArrayList = (ArrayList<FileInfo>)localObject1;
        if (!((String)localObject1).equalsIgnoreCase("QQ")) {}
      }
      else
      {
        paramArrayList = HardCodeUtil.a(2131698192);
      }
      localObject1 = paramArrayList;
      if (paramArrayList.equalsIgnoreCase("camera") == true) {
        localObject1 = HardCodeUtil.a(2131698208);
      }
      if (!localLinkedHashMap.containsKey(localObject1)) {
        localLinkedHashMap.put(localObject1, new ArrayList());
      }
      ((List)localLinkedHashMap.get(localObject1)).add(localObject3);
    }
    if (((FMActivity)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity).h() == 1)
    {
      paramArrayList = HardCodeUtil.a(2131698238);
      localLinkedHashMap.put(paramArrayList, new ArrayList());
      localObject1 = new HashMap();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH));
      ((StringBuilder)localObject2).append("/chatpic/chatimg/");
      FileCategoryUtil.a(true, ((StringBuilder)localObject2).toString(), "", "", (HashMap)localObject1, null);
      localObject2 = ((HashMap)localObject1).keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (List)((HashMap)localObject1).get((String)((Iterator)localObject2).next());
        ((List)localLinkedHashMap.get(paramArrayList)).addAll((Collection)localObject3);
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
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g()) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h()))
    {
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getSharedPreferences("LAST_CHOOSE_", 0).edit();
      localEditor.putInt("GROUP", ((ImageHolder)localObject2).b);
      localEditor.putInt("CHILD", (((ImageHolder)localObject2).jdField_a_of_type_Int + 1) / 4);
      localEditor.commit();
    }
    if (paramBoolean)
    {
      if (FMDataCache.a(paramView))
      {
        FMDataCache.b(paramView);
        b(paramView, false);
      }
      else
      {
        FMDataCache.a(paramView);
        b(paramView, true);
        if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.i()) && (!FMDataCache.a(FMDataCache.jdField_a_of_type_Int)) && (!FMDataCache.b(paramView)))
        {
          localObject1 = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131698222);
          ((QQCustomDialog)localObject1).setPositiveButton(2131719788, new DialogUtil.DialogOnClickAdapter());
          ((QQCustomDialog)localObject1).show();
          FMDataCache.b(FMDataCache.jdField_a_of_type_Int);
          FileManagerReporter.a("0X800942D");
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h(true);
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.jdField_f_of_type_Boolean) && (!FileUtils.fileExistsAndNotEmpty(paramView.c())))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(QQFileManagerUtil.b(paramView.d()));
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131698194));
        FMToastUtil.a(((StringBuilder)localObject1).toString());
        FMDataCache.b(paramView);
      }
      f();
      w();
      k();
    }
    else
    {
      if (!c())
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "click too fast , wait a minute.");
        }
        return;
      }
      if (g()) {
        ReportController.b(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
      }
      u();
      localObject2 = QQFileManagerUtil.a(paramView);
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).openLocalFileViewBrowser(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, this.c, paramView, (View)localObject1, (FileManagerEntity)localObject2);
      localObject1 = new FileManagerReporter.FileAssistantReportData();
      ((FileManagerReporter.FileAssistantReportData)localObject1).b = "file_viewer_in";
      ((FileManagerReporter.FileAssistantReportData)localObject1).jdField_a_of_type_Int = 80;
      ((FileManagerReporter.FileAssistantReportData)localObject1).c = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getExtension(paramView.d());
      ((FileManagerReporter.FileAssistantReportData)localObject1).jdField_a_of_type_Long = paramView.a();
      FileManagerReporter.a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getCurrentAccountUin(), (FileManagerReporter.FileAssistantReportData)localObject1);
      FileManagerReporter.a("0X8004AE5");
    }
    a(g());
  }
  
  private boolean a(FileInfo paramFileInfo, boolean paramBoolean)
  {
    if (paramFileInfo == null) {
      return false;
    }
    if ((g()) && (((FMDataCache.a(paramFileInfo)) && (paramBoolean)) || ((!FMDataCache.a(paramFileInfo)) && (!paramBoolean)))) {
      return false;
    }
    if (g())
    {
      if (paramBoolean)
      {
        localIQfileViewBinder = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter$IQfileViewBinder;
        if (localIQfileViewBinder != null) {
          localIQfileViewBinder.a(paramFileInfo, true);
        }
        FMDataCache.a(paramFileInfo);
        return true;
      }
      QfileBaseExpandableListAdapter.IQfileViewBinder localIQfileViewBinder = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter$IQfileViewBinder;
      if (localIQfileViewBinder != null) {
        localIQfileViewBinder.a(paramFileInfo, false);
      }
      FMDataCache.b(paramFileInfo);
    }
    return true;
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
    if (paramSet != null)
    {
      if (paramSet.size() == 0) {
        return;
      }
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
    if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.k()) {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.c()) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().T();
      } else {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().Y();
      }
    }
    o();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnIndexChangedListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$OnSelectListener);
  }
  
  public void p()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.runOnUiThread(new QfileLocalFilePicTabView.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView
 * JD-Core Version:    0.7.0.1
 */