package com.tencent.mobileqq.filemanager.activity.recentfile;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.tendoc.TencentDocImportFileInfoBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocImportFileInfoProcessor;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileRecentImageExpandableListAdapter;
import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.FileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TencentDocConfig;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public abstract class QfileBaseRecentFileTabView
  extends QfileBaseTabView
{
  static String jdField_a_of_type_JavaLangString = "<FileAssistant>";
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = -1L;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = null;
  public View.OnClickListener a;
  public View.OnLongClickListener a;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  QfileBaseExpandableListAdapter jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter = null;
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new QfileBaseRecentFileTabView.7(this);
  NoFileRelativeLayout jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = null;
  QfilePinnedHeaderExpandableListView jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView;
  BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
  Comparator<FileManagerEntity> jdField_a_of_type_JavaUtilComparator = new QfileBaseRecentFileTabView.1(this);
  LinkedHashMap<String, List<FileManagerEntity>> jdField_a_of_type_JavaUtilLinkedHashMap = null;
  List<FileManagerEntity> jdField_a_of_type_JavaUtilList = null;
  volatile boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  public View.OnClickListener b;
  View jdField_b_of_type_AndroidViewView = null;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = false;
  public View.OnClickListener c;
  View jdField_c_of_type_AndroidViewView = null;
  final String jdField_c_of_type_JavaLangString = "LastRequestTime";
  
  public QfileBaseRecentFileTabView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new QfileBaseRecentFileTabView.4(this);
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = new QfileBaseRecentFileTabView.RecentFileItemLongClickListener(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new QfileBaseRecentFileTabView.5(this);
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new QfileBaseRecentFileTabView.6(this);
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public QfileBaseRecentFileTabView(Context paramContext, String paramString)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new QfileBaseRecentFileTabView.4(this);
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = new QfileBaseRecentFileTabView.RecentFileItemLongClickListener(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new QfileBaseRecentFileTabView.5(this);
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new QfileBaseRecentFileTabView.6(this);
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a(boolean paramBoolean, FileManagerEntity paramFileManagerEntity)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.j()) && (!paramBoolean))
    {
      if ((this instanceof QfileRecentAllFileTabView))
      {
        if ((paramFileManagerEntity.nFileType == 13) && (this.jdField_b_of_type_Int == 1)) {
          ReportController.b(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "dc00898", "", "", "0X800A072", "0X800A072", 0, 0, "", "", "", "");
        }
        paramFileManagerEntity = "0X8009E3F";
        break label279;
      }
      if ((this instanceof QfileRecentAppFileTabView))
      {
        paramFileManagerEntity = "0X8009E76";
        break label279;
      }
      if ((this instanceof QfileRecentDocFileTabView))
      {
        paramFileManagerEntity = "0X8009E40";
        break label279;
      }
      if ((this instanceof QfileRecentMediaFileTabView))
      {
        paramFileManagerEntity = "0X8009E75";
        break label279;
      }
      if ((this instanceof QfileRecentPicFileTabView))
      {
        paramFileManagerEntity = "0X8009E41";
        break label279;
      }
      if ((this instanceof QfileRecentTencentDocFileTabView))
      {
        paramFileManagerEntity = "0X800A07A";
        break label279;
      }
    }
    else if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.j())
    {
      if ((this instanceof QfileRecentAllFileTabView))
      {
        if ((paramFileManagerEntity.nFileType == 13) && (this.jdField_b_of_type_Int == 2)) {
          ReportController.b(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "dc00898", "", "", "0X800A087", "0X800A087", 0, 0, "", "", "", "");
        }
        paramFileManagerEntity = "0X8009E51";
        break label279;
      }
      if ((this instanceof QfileRecentAppFileTabView))
      {
        paramFileManagerEntity = "0X8009E6D";
        break label279;
      }
      if ((this instanceof QfileRecentDocFileTabView))
      {
        paramFileManagerEntity = "0X8009E52";
        break label279;
      }
      if ((this instanceof QfileRecentMediaFileTabView))
      {
        paramFileManagerEntity = "0X8009E6C";
        break label279;
      }
      if ((this instanceof QfileRecentPicFileTabView))
      {
        paramFileManagerEntity = "0X8009E53";
        break label279;
      }
      if (((this instanceof QfileRecentTencentDocFileTabView)) && (this.jdField_b_of_type_Int == 2))
      {
        paramFileManagerEntity = "0X800A08C";
        break label279;
      }
    }
    paramFileManagerEntity = "";
    label279:
    if (!TextUtils.isEmpty(paramFileManagerEntity)) {
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "dc00898", "", "", paramFileManagerEntity, paramFileManagerEntity, 0, 0, "", "", "", "");
    }
  }
  
  private boolean a()
  {
    if (QQFileManagerUtil.a(getContext()))
    {
      Object localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap;
      if ((localObject1 != null) && (((LinkedHashMap)localObject1).size() > 0))
      {
        int i;
        boolean bool;
        do
        {
          localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
          Object localObject2;
          while (!((Iterator)localObject2).hasNext())
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject2 = (String)((Iterator)localObject1).next();
            localObject2 = ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject2)).iterator();
          }
          FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject2).next();
          if (localFileManagerEntity.fileSize > FMDataCache.a()) {
            i = 1;
          } else {
            i = 0;
          }
          bool = QQFileManagerUtil.b(localFileManagerEntity.fileName, TencentDocConfig.a().jdField_a_of_type_JavaLangString);
        } while ((i == 0) && (bool));
        return true;
      }
    }
    return false;
  }
  
  private void d(FileManagerEntity paramFileManagerEntity)
  {
    Object localObject;
    if (FMDataCache.a(paramFileManagerEntity))
    {
      FMDataCache.b(paramFileManagerEntity);
    }
    else
    {
      FMDataCache.a(paramFileManagerEntity);
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.i()) && (!FMDataCache.a(FMDataCache.jdField_a_of_type_Int)) && (!FMDataCache.b(paramFileManagerEntity)))
      {
        localObject = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131698222);
        ((QQCustomDialog)localObject).setPositiveButton(2131719788, new DialogUtil.DialogOnClickAdapter());
        ((QQCustomDialog)localObject).show();
        FMDataCache.b(FMDataCache.jdField_a_of_type_Int);
        FileManagerReporter.a("0X800942D");
      }
    }
    if (((this instanceof QfileRecentDocFileTabView)) || ((this instanceof QfileRecentAllFileTabView))) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h(true);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f) && (paramFileManagerEntity.cloudType == 3) && (!FileUtils.fileExistsAndNotEmpty(paramFileManagerEntity.getFilePath())))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(QQFileManagerUtil.b(paramFileManagerEntity.fileName));
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131698194));
      FMToastUtil.a(((StringBuilder)localObject).toString());
      FMDataCache.b(paramFileManagerEntity);
    }
    w();
    g();
  }
  
  private void k() {}
  
  private void o()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView = ((QfilePinnedHeaderExpandableListView)findViewById(2131366803));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelection(0);
    AccessibilityUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView, false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setFocusable(false);
  }
  
  private void p()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = new NoFileRelativeLayout(a());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setText(2131692295);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setVisible(false);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.addHeaderView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setGone();
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getLayoutInflater().inflate(2131562916, null, false);
      this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131378757);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131378503));
      ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369951)).setColorFilter(-15550475, PorterDuff.Mode.MULTIPLY);
      ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131364703)).setOnClickListener(new QfileBaseRecentFileTabView.3(this));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.addHeaderView(this.jdField_b_of_type_AndroidViewView);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public int a()
  {
    return 0;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView;
  }
  
  protected abstract QfileBaseExpandableListAdapter a();
  
  public ListView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView;
  }
  
  abstract void a();
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      return;
    }
    b(paramFileManagerEntity);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, View paramView, boolean paramBoolean)
  {
    if ((g()) && (!paramBoolean))
    {
      d(paramFileManagerEntity);
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
      u();
      QQFileManagerUtil.c(paramFileManagerEntity);
      FileManagerReporter.FileAssistantReportData localFileAssistantReportData = new FileManagerReporter.FileAssistantReportData();
      localFileAssistantReportData.jdField_b_of_type_JavaLangString = "file_viewer_in";
      localFileAssistantReportData.jdField_a_of_type_Int = 73;
      if (paramFileManagerEntity.nFileType == 13) {
        localFileAssistantReportData.jdField_c_of_type_JavaLangString = "tencentdoc_ext";
      } else {
        localFileAssistantReportData.jdField_c_of_type_JavaLangString = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getExtension(paramFileManagerEntity.fileName);
      }
      localFileAssistantReportData.jdField_a_of_type_Long = paramFileManagerEntity.fileSize;
      FileManagerReporter.a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getCurrentAccountUin(), localFileAssistantReportData);
      FileManagerReporter.a("0X8004AE4");
      paramBoolean = this instanceof QfileRecentAllFileTabView;
      boolean bool = this instanceof QfileRecentTencentDocFileTabView;
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).openRencentFileBrowserOnItemClick(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g(), this.jdField_b_of_type_JavaLangString, paramView, paramBoolean, bool);
    }
    a(g(), paramFileManagerEntity);
  }
  
  public void a(ArrayList<FileManagerEntity> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    int i = 0;
    while (i < paramArrayList.size())
    {
      b((FileManagerEntity)paramArrayList.get(i));
      i += 1;
    }
  }
  
  protected void a(List<FileManagerEntity> paramList)
  {
    if (paramList == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null) {
      ((List)localObject).clear();
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.c()) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h())) {
      paramList = paramList.iterator();
    }
    while (paramList.hasNext())
    {
      localObject = (FileManagerEntity)paramList.next();
      if (!((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).isUndownloadDatalineEntity((FileManagerEntity)localObject))
      {
        this.jdField_a_of_type_JavaUtilList.add(localObject);
        continue;
        this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      }
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public boolean a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      return false;
    }
    return b(paramFileManagerEntity);
  }
  
  public void ak_()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      a();
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Thread id: ");
        ((StringBuilder)localObject).append(Thread.currentThread().getId());
        ((StringBuilder)localObject).append(" resetData -> getRecentFileRecords ");
        QLog.e("crashBUG", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void b()
  {
    d(2131560796);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(a());
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).addDatalineObserver();
    o();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter = a();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView);
    p();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelector(2131167333);
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter instanceof QfileRecentImageExpandableListAdapter;
    int j = 0;
    int i = 0;
    if (bool)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelector(2131167333);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setWhetherImageTab(true);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setGridSize(((QfileRecentImageExpandableListAdapter)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter).a());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setTranscriptMode(0);
      while (i < this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.getGroupCount())
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.expandGroup(i);
        i += 1;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelector(2131167333);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setWhetherImageTab(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setTranscriptMode(0);
    i = j;
    while (i < this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.getGroupCount())
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.expandGroup(i);
      i += 1;
    }
  }
  
  abstract void b(FileManagerEntity paramFileManagerEntity);
  
  protected boolean b(FileManagerEntity paramFileManagerEntity)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Thread id: ");
        ((StringBuilder)localObject).append(Thread.currentThread().getId());
        ((StringBuilder)localObject).append(" delRecent");
        QLog.e("crashBUG", 1, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (paramFileManagerEntity == (FileManagerEntity)((Iterator)localObject).next())
        {
          ((Iterator)localObject).remove();
          return true;
        }
      }
      return false;
    }
    for (;;)
    {
      throw paramFileManagerEntity;
    }
  }
  
  public void c()
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Thread id: ");
      localStringBuilder.append(Thread.currentThread().getId());
      localStringBuilder.append(" onDestroy");
      QLog.e("crashBUG", 1, localStringBuilder.toString());
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    v();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).removeDatalineObserver();
  }
  
  protected void c(FileManagerEntity paramFileManagerEntity)
  {
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).forwardFile(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramFileManagerEntity);
  }
  
  void f()
  {
    try
    {
      boolean bool = this.jdField_b_of_type_Boolean;
      if (bool) {
        return;
      }
      this.jdField_b_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "queryFileEntitiesFromDB");
      }
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Thread id: ");
        localStringBuilder.append(Thread.currentThread().getId());
        localStringBuilder.append(" queryFileEntitiesFromDB");
        QLog.e("crashBUG", 1, localStringBuilder.toString());
      }
      ThreadManager.post(new QfileBaseRecentFileTabView.2(this), 8, null, true);
      return;
    }
    finally {}
  }
  
  protected void g()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilLinkedHashMap;
    if ((localObject != null) && (((LinkedHashMap)localObject).size() != 0))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout;
      if (localObject != null)
      {
        ((NoFileRelativeLayout)localObject).setGone();
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.removeHeaderView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setEnabled(true);
        if (a())
        {
          localObject = TencentDocImportFileInfoProcessor.a().a();
          if (TextUtils.isEmpty((CharSequence)localObject))
          {
            this.jdField_c_of_type_AndroidViewView.setVisibility(8);
          }
          else
          {
            this.jdField_c_of_type_AndroidViewView.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
          }
        }
        else
        {
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        }
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.j()) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setTopViewHeight(0.2F);
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setVisible(true);
      if ((this instanceof QfileRecentTencentDocFileTabView))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.a();
        ReportController.b(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "dc00898", "", "", "0X800A225", "0X800A225", 0, 0, "", "", "", "");
      }
      else if ((this instanceof QfileRecentTDocFileTabView))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.a();
        ReportController.b(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "dc00898", "", "", "0X800A08B", "0X800A08B", 0, 0, "", "", "", "");
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.b();
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setEnabled(false);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    h();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.notifyDataSetChanged();
  }
  
  protected void h()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.getMeasuredHeight();
    Object localObject1 = jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("================================================================> 高度为");
    ((StringBuilder)localObject2).append(i);
    QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout;
    if (localObject1 != null)
    {
      ((NoFileRelativeLayout)localObject1).setLayoutParams(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.getWidth(), i);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.findViewById(2131379034);
      localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).height = 0;
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
  }
  
  public void i()
  {
    a(new QfileBaseRecentFileTabView.8(this));
  }
  
  public void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f());
  }
  
  public void n()
  {
    f();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f());
    i();
  }
  
  public void setAttribution(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void setSelect(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.getGroupCount() <= paramInt)
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSelect[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("] faild,becouse GroupCount[");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.getGroupCount());
      localStringBuilder.append("]");
      QLog.e(str, 1, localStringBuilder.toString());
      return;
    }
    a(new QfileBaseRecentFileTabView.9(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView
 * JD-Core Version:    0.7.0.1
 */