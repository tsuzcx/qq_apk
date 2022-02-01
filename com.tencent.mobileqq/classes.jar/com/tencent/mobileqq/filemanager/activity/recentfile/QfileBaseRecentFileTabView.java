package com.tencent.mobileqq.filemanager.activity.recentfile;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.tendoc.TencentDocImportFileInfoBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocImportFileInfoProcessor;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileRecentImageExpandableListAdapter;
import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.open.CommonFileBrowserParams;
import com.tencent.mobileqq.filemanager.fileviewer.open.FileBrowserCreator;
import com.tencent.mobileqq.filemanager.fileviewer.open.IFileBrowserParams;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.FileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import mqq.app.MobileQQ;

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
  private DataLineObserver jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = new QfileBaseRecentFileTabView.3(this);
  QfileBaseExpandableListAdapter jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter = null;
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new QfileBaseRecentFileTabView.10(this);
  private FileTransferObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver = new QfileBaseRecentFileTabView.9(this);
  NoFileRelativeLayout jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = null;
  QfilePinnedHeaderExpandableListView jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView;
  ScrollerRunnable jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable;
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
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new QfileBaseRecentFileTabView.6(this);
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = new QfileBaseRecentFileTabView.RecentFileItemLongClickListener(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new QfileBaseRecentFileTabView.7(this);
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new QfileBaseRecentFileTabView.8(this);
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public QfileBaseRecentFileTabView(Context paramContext, String paramString)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new QfileBaseRecentFileTabView.6(this);
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = new QfileBaseRecentFileTabView.RecentFileItemLongClickListener(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new QfileBaseRecentFileTabView.7(this);
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new QfileBaseRecentFileTabView.8(this);
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a(Boolean paramBoolean, List<OfflineFileInfo> paramList)
  {
    long l;
    if ((paramList == null) || (paramList.size() == 0))
    {
      paramBoolean = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("OfflineFileMerge" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 0);
      l = System.currentTimeMillis();
      paramBoolean.edit().putLong("LastRequestTime", l).commit();
      QLog.i(jdField_a_of_type_JavaLangString, 1, "megre over list size = 0, updata last process time");
      return;
    }
    Collections.sort(paramList, new QfileBaseRecentFileTabView.4(this));
    paramBoolean = paramList.iterator();
    label514:
    for (;;)
    {
      Object localObject;
      label135:
      FileManagerEntity localFileManagerEntity;
      int i;
      if (paramBoolean.hasNext())
      {
        paramList = (OfflineFileInfo)paramBoolean.next();
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        if (!((Iterator)localObject).hasNext()) {
          break label511;
        }
        localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
        String str = paramList.jdField_a_of_type_JavaLangString.replace("/offline", "");
        if ((localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.equalsIgnoreCase(str))) {
          i = 1;
        }
      }
      for (;;)
      {
        label193:
        if (i != 0) {
          break label514;
        }
        paramList = FileManagerUtil.a(paramList, 0);
        if (paramList.nFileType == 0) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(paramList, 5);
        }
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "mergeOfflineList,addEntity:fileName[" + paramList.fileName + "],bSend[" + paramList.bSend + "],Uuid[" + paramList.Uuid + "]");
          }
          paramList.bOnceSuccess = true;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramList);
          b(paramList);
          break;
          if ((Math.abs(localFileManagerEntity.srvTime - paramList.d) >= 60000L) || (localFileManagerEntity.fileSize != paramList.b) || (localFileManagerEntity.peerUin == null) || (!localFileManagerEntity.peerUin.equalsIgnoreCase(String.valueOf(paramList.jdField_a_of_type_Long))) || (localFileManagerEntity.fileName == null) || (!localFileManagerEntity.fileName.equalsIgnoreCase(paramList.jdField_c_of_type_JavaLangString))) {
            break label135;
          }
          i = 1;
          break label193;
          if (paramList.nFileType == 2)
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(paramList);
            if (localObject != null) {
              paramList.strThumbPath = ((String)localObject);
            }
          }
        }
        paramBoolean = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("OfflineFileMerge" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 0);
        l = System.currentTimeMillis();
        paramBoolean.edit().putLong("LastRequestTime", l).commit();
        QLog.i(jdField_a_of_type_JavaLangString, 1, "process over , updata last process time");
        return;
        label511:
        i = 0;
      }
    }
  }
  
  private void a(boolean paramBoolean, FileManagerEntity paramFileManagerEntity)
  {
    String str2 = "";
    String str1;
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.j()) && (!paramBoolean)) {
      if ((this instanceof QfileRecentAllFileTabView))
      {
        if ((paramFileManagerEntity.nFileType == 13) && (this.jdField_b_of_type_Int == 1)) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A072", "0X800A072", 0, 0, "", "", "", "");
        }
        str1 = "0X8009E3F";
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str1)) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", str1, str1, 0, 0, "", "", "", "");
      }
      return;
      if ((this instanceof QfileRecentAppFileTabView))
      {
        str1 = "0X8009E76";
      }
      else if ((this instanceof QfileRecentDocFileTabView))
      {
        str1 = "0X8009E40";
      }
      else if ((this instanceof QfileRecentMediaFileTabView))
      {
        str1 = "0X8009E75";
      }
      else if ((this instanceof QfileRecentPicFileTabView))
      {
        str1 = "0X8009E41";
      }
      else
      {
        str1 = str2;
        if ((this instanceof QfileRecentTencentDocFileTabView))
        {
          str1 = "0X800A07A";
          continue;
          str1 = str2;
          if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.j()) {
            if ((this instanceof QfileRecentAllFileTabView))
            {
              if ((paramFileManagerEntity.nFileType == 13) && (this.jdField_b_of_type_Int == 2)) {
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A087", "0X800A087", 0, 0, "", "", "", "");
              }
              str1 = "0X8009E51";
            }
            else if ((this instanceof QfileRecentAppFileTabView))
            {
              str1 = "0X8009E6D";
            }
            else if ((this instanceof QfileRecentDocFileTabView))
            {
              str1 = "0X8009E52";
            }
            else if ((this instanceof QfileRecentMediaFileTabView))
            {
              str1 = "0X8009E6C";
            }
            else if ((this instanceof QfileRecentPicFileTabView))
            {
              str1 = "0X8009E53";
            }
            else
            {
              str1 = str2;
              if ((this instanceof QfileRecentTencentDocFileTabView))
              {
                str1 = str2;
                if (this.jdField_b_of_type_Int == 2) {
                  str1 = "0X800A08C";
                }
              }
            }
          }
        }
      }
    }
  }
  
  private boolean a()
  {
    if ((FileManagerUtil.a(getContext())) && (this.jdField_a_of_type_JavaUtilLinkedHashMap != null) && (this.jdField_a_of_type_JavaUtilLinkedHashMap.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject)).iterator();
        if (((Iterator)localObject).hasNext())
        {
          FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
          if (localFileManagerEntity.fileSize > FMDataCache.a()) {}
          for (int i = 1;; i = 0)
          {
            boolean bool = FileManagerUtil.a(localFileManagerEntity.fileName, a().e);
            if ((i == 0) && (bool)) {
              break;
            }
            return true;
          }
        }
      }
    }
    return false;
  }
  
  private void d(FileManagerEntity paramFileManagerEntity)
  {
    if (FMDataCache.a(paramFileManagerEntity)) {
      FMDataCache.b(paramFileManagerEntity);
    }
    for (;;)
    {
      if (((this instanceof QfileRecentDocFileTabView)) || ((this instanceof QfileRecentAllFileTabView))) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h(true);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f) && (paramFileManagerEntity.cloudType == 3) && (!FileUtil.b(paramFileManagerEntity.getFilePath())))
      {
        FMToastUtil.a(FileManagerUtil.d(paramFileManagerEntity.fileName) + HardCodeUtil.a(2131709588));
        FMDataCache.b(paramFileManagerEntity);
      }
      w();
      g();
      return;
      FMDataCache.a(paramFileManagerEntity);
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.i()) && (!FMDataCache.a(FMDataCache.jdField_a_of_type_Int)) && (!FMDataCache.b(paramFileManagerEntity)))
      {
        QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131698166);
        localQQCustomDialog.setPositiveButton(2131720056, new DialogUtil.DialogOnClickAdapter());
        localQQCustomDialog.show();
        FMDataCache.b(FMDataCache.jdField_a_of_type_Int);
        FileManagerReporter.a("0X800942D");
      }
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(0, 30, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().b(0, 30, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver);
  }
  
  private void o()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView = ((QfilePinnedHeaderExpandableListView)findViewById(2131366941));
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelection(0);
    AccessibilityUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView, false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setFocusable(false);
  }
  
  private void p()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = new NoFileRelativeLayout(a());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setText(2131692367);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setVisible(false);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.addHeaderView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setGone();
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getLayoutInflater().inflate(2131563089, null, false);
      this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131379406);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379133));
      ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370283)).setColorFilter(-15550475, PorterDuff.Mode.MULTIPLY);
      ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131364815)).setOnClickListener(new QfileBaseRecentFileTabView.5(this));
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().b();
    if ((g()) && (!paramBoolean)) {
      d(paramFileManagerEntity);
    }
    for (;;)
    {
      a(g(), paramFileManagerEntity);
      do
      {
        return;
        if (c()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i(jdField_a_of_type_JavaLangString, 2, "click too fast , wait a minute.");
      return;
      u();
      FileManagerUtil.b(paramFileManagerEntity);
      Object localObject = new FileManagerReporter.FileAssistantReportData();
      ((FileManagerReporter.FileAssistantReportData)localObject).jdField_b_of_type_JavaLangString = "file_viewer_in";
      ((FileManagerReporter.FileAssistantReportData)localObject).jdField_a_of_type_Int = 73;
      if (paramFileManagerEntity.nFileType == 13) {}
      for (((FileManagerReporter.FileAssistantReportData)localObject).jdField_c_of_type_JavaLangString = "tencentdoc_ext";; ((FileManagerReporter.FileAssistantReportData)localObject).jdField_c_of_type_JavaLangString = FileUtil.a(paramFileManagerEntity.fileName))
      {
        ((FileManagerReporter.FileAssistantReportData)localObject).jdField_a_of_type_Long = paramFileManagerEntity.fileSize;
        FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (FileManagerReporter.FileAssistantReportData)localObject);
        FileManagerReporter.a("0X8004AE4");
        localObject = new CommonFileBrowserParams(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramFileManagerEntity, 10001);
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("from_qlink_enter_recent", this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g());
        if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.trim().length() != 0)) {
          localBundle.putString("c2c_discussion_recentfile", this.jdField_b_of_type_JavaLangString);
        }
        ((CommonFileBrowserParams)localObject).a(localBundle);
        localObject = new FileBrowserCreator(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (IFileBrowserParams)localObject);
        ((FileBrowserCreator)localObject).a(7);
        if (((paramFileManagerEntity.nFileType == 0) || (paramFileManagerEntity.nFileType == 2)) && (paramView != null) && ((paramView.getId() == 2131366919) || (paramView.getId() == 2131368729)))
        {
          ((FileBrowserCreator)localObject).a(AnimationUtils.a(paramView));
          ((FileBrowserCreator)localObject).a(true);
        }
        if (paramFileManagerEntity.nFileType != 2) {
          break label402;
        }
        if (!FileUtil.b(paramFileManagerEntity.getFilePath())) {
          break;
        }
        ((FileBrowserCreator)localObject).a();
        return;
      }
      if ((paramFileManagerEntity.isSend()) && (!FileUtil.b(paramFileManagerEntity.getFilePath())) && (paramFileManagerEntity.status != 1) && (paramFileManagerEntity.status != -1))
      {
        FMToastUtil.a(HardCodeUtil.a(2131709587));
        return;
      }
      if (!NetworkUtil.d(BaseApplication.getContext()))
      {
        FMToastUtil.a(2131692602);
        return;
      }
      ((FileBrowserCreator)localObject).a();
      continue;
      label402:
      if (paramFileManagerEntity.nFileType == 13)
      {
        if ((this instanceof QfileRecentAllFileTabView)) {
          TeamWorkUtils.a(paramFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 3, paramFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app);
        } else if ((this instanceof QfileRecentTencentDocFileTabView)) {
          TeamWorkUtils.a(paramFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 20, paramFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app);
        }
      }
      else {
        ((FileBrowserCreator)localObject).a();
      }
    }
  }
  
  public void a(ArrayList<FileManagerEntity> paramArrayList)
  {
    if (paramArrayList == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramArrayList.size())
      {
        b((FileManagerEntity)paramArrayList.get(i));
        i += 1;
      }
    }
  }
  
  protected void a(List<FileManagerEntity> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity == null) || (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.c()) || (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h())) {
        break;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramList.next();
        if (!QFileUtils.b(localFileManagerEntity)) {
          this.jdField_a_of_type_JavaUtilList.add(localFileManagerEntity);
        }
      }
    }
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(boolean paramBoolean) {}
  
  public boolean a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      return false;
    }
    return b(paramFileManagerEntity);
  }
  
  public void aq_()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      a();
      if (QLog.isDevelopLevel()) {
        QLog.e("crashBUG", 1, "Thread id: " + Thread.currentThread().getId() + " resetData -> getRecentFileRecords ");
      }
    }
  }
  
  public void b()
  {
    int i = 0;
    d(2131560922);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(a());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    o();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter = a();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView);
    p();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelector(2131167305);
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter instanceof QfileRecentImageExpandableListAdapter))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelector(2131167305);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setWhetherImageTab(true);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setGridSize(((QfileRecentImageExpandableListAdapter)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter).a());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setTranscriptMode(0);
      i = 0;
      while (i < this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.getGroupCount())
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.expandGroup(i);
        i += 1;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelector(2131167305);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setWhetherImageTab(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setTranscriptMode(0);
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
      if (QLog.isDevelopLevel()) {
        QLog.e("crashBUG", 1, "Thread id: " + Thread.currentThread().getId() + " delRecent");
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        if (paramFileManagerEntity == (FileManagerEntity)localIterator.next())
        {
          localIterator.remove();
          return true;
        }
      }
      return false;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.b();
    }
    if (QLog.isDevelopLevel()) {
      QLog.e("crashBUG", 1, "Thread id: " + Thread.currentThread().getId() + " onDestroy");
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    v();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a();
  }
  
  protected void c(FileManagerEntity paramFileManagerEntity)
  {
    QFileUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramFileManagerEntity);
  }
  
  public void clearAllForTest() {}
  
  /* Error */
  void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 71	com/tencent/mobileqq/filemanager/activity/recentfile/QfileBaseRecentFileTabView:jdField_b_of_type_Boolean	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 71	com/tencent/mobileqq/filemanager/activity/recentfile/QfileBaseRecentFileTabView:jdField_b_of_type_Boolean	Z
    //   19: invokestatic 655	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   22: ifeq +13 -> 35
    //   25: getstatic 36	com/tencent/mobileqq/filemanager/activity/recentfile/QfileBaseRecentFileTabView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   28: iconst_2
    //   29: ldc_w 892
    //   32: invokestatic 212	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: invokestatic 276	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   38: ifeq +41 -> 79
    //   41: ldc_w 791
    //   44: iconst_1
    //   45: new 162	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   52: ldc_w 793
    //   55: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokestatic 799	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   61: invokevirtual 801	java/lang/Thread:getId	()J
    //   64: invokevirtual 804	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   67: ldc_w 894
    //   70: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 808	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   79: new 896	com/tencent/mobileqq/filemanager/activity/recentfile/QfileBaseRecentFileTabView$2
    //   82: dup
    //   83: aload_0
    //   84: invokespecial 897	com/tencent/mobileqq/filemanager/activity/recentfile/QfileBaseRecentFileTabView$2:<init>	(Lcom/tencent/mobileqq/filemanager/activity/recentfile/QfileBaseRecentFileTabView;)V
    //   87: bipush 8
    //   89: aconst_null
    //   90: iconst_1
    //   91: invokestatic 903	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   94: goto -83 -> 11
    //   97: astore_2
    //   98: aload_0
    //   99: monitorexit
    //   100: aload_2
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	QfileBaseRecentFileTabView
    //   6	2	1	bool	boolean
    //   97	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	97	finally
    //   14	35	97	finally
    //   35	79	97	finally
    //   79	94	97	finally
  }
  
  protected void g()
  {
    if ((this.jdField_a_of_type_JavaUtilLinkedHashMap == null) || (this.jdField_a_of_type_JavaUtilLinkedHashMap.size() == 0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.j()) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setTopViewHeight(0.2F);
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setVisible(true);
      if ((this instanceof QfileRecentTencentDocFileTabView))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.a();
        ReportController.b(a().app, "dc00898", "", "", "0X800A225", "0X800A225", 0, 0, "", "", "", "");
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setEnabled(false);
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
    }
    for (;;)
    {
      h();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.notifyDataSetChanged();
      return;
      if ((this instanceof QfileRecentTDocFileTabView))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.a();
        ReportController.b(a().app, "dc00898", "", "", "0X800A08B", "0X800A08B", 0, 0, "", "", "", "");
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.b();
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setGone();
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.removeHeaderView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setEnabled(true);
        if (a())
        {
          String str = TencentDocImportFileInfoProcessor.a().a();
          if (TextUtils.isEmpty(str))
          {
            this.jdField_c_of_type_AndroidViewView.setVisibility(8);
          }
          else
          {
            this.jdField_c_of_type_AndroidViewView.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
          }
        }
        else
        {
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        }
      }
    }
  }
  
  protected void h()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.getMeasuredHeight();
    QLog.d(jdField_a_of_type_JavaLangString, 2, "================================================================> 高度为" + i);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setLayoutParams(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.getWidth(), i);
      View localView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.findViewById(2131379692);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.height = 0;
      localView.setLayoutParams(localLayoutParams);
    }
  }
  
  public void i()
  {
    a(new QfileBaseRecentFileTabView.11(this));
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
      QLog.e(jdField_a_of_type_JavaLangString, 1, "setSelect[" + paramInt + "] faild,becouse GroupCount[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.getGroupCount() + "]");
      return;
    }
    a(new QfileBaseRecentFileTabView.12(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView
 * JD-Core Version:    0.7.0.1
 */