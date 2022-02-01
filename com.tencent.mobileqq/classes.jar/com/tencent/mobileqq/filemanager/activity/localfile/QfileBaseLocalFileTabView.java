package com.tencent.mobileqq.filemanager.activity.localfile;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileLocalImageExpandableListAdapter;
import com.tencent.mobileqq.filemanager.activity.delDownloadFile.QFileDelDownloadAdapter;
import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
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
import com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView.ScanParams;
import com.tencent.mobileqq.filemanager.widget.ViewerMoreRelativeLayout;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public abstract class QfileBaseLocalFileTabView
  extends QfileBaseTabView
{
  static String jdField_a_of_type_JavaLangString = "QfileBaseLocalFileTabView<FileAssistant>";
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = null;
  public View.OnClickListener a;
  public View.OnLongClickListener a;
  protected QfileBaseExpandableListAdapter a;
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new QfileBaseLocalFileTabView.7(this);
  IClickListenerVer51 jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListenerVer51 = null;
  NoFileRelativeLayout jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = null;
  protected QfilePinnedHeaderExpandableListView a;
  public ViewerMoreRelativeLayout a;
  ScrollerRunnable jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable;
  BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
  protected ArrayList<FileInfo> a;
  public View.OnClickListener b = new QfileBaseLocalFileTabView.3(this);
  public View.OnClickListener c;
  protected LinkedHashMap<String, List<FileInfo>> c;
  public View.OnClickListener d;
  public List<QfileTabBarView.ScanParams> d;
  protected boolean f;
  boolean g;
  protected boolean h = false;
  
  public QfileBaseLocalFileTabView(Context paramContext, List<QfileTabBarView.ScanParams> paramList, boolean paramBoolean)
  {
    super(paramContext);
    this.jdField_c_of_type_JavaUtilLinkedHashMap = null;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new QfileBaseLocalFileTabView.2(this);
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = new QfileBaseLocalFileTabView.4(this);
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new QfileBaseLocalFileTabView.5(this);
    this.jdField_d_of_type_AndroidViewView$OnClickListener = new QfileBaseLocalFileTabView.6(this);
    this.jdField_d_of_type_JavaUtilList = paramList;
    this.f = paramBoolean;
    this.jdField_c_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private boolean a(String paramString, int paramInt)
  {
    paramString = FileUtil.a(paramString);
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return false;
        paramString = paramString.toLowerCase();
      } while (((paramInt == 0) && (!".jpg|.bmp|.jpeg|.gif|.png|.ico|".contains(paramString))) || ((paramInt == 2) && (!".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|".contains(paramString))));
      if (paramInt != 3) {
        break;
      }
    } while ((!".doc|.docx|.wps|.pages|".contains(paramString)) && (!".xls|.xlsx|.et|.numbers|".contains(paramString)) && (!".pdf|".contains(paramString)) && (!".ppt|.pptx.|.dps|.keynote|".contains(paramString)));
    do
    {
      do
      {
        return true;
        if ((paramInt == 5) && (!".apk|".contains(paramString))) {
          break;
        }
      } while (paramInt != 11);
      if ((".jpg|.bmp|.jpeg|.gif|.png|.ico|".contains(paramString)) || (".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|".contains(paramString)) || (".doc|.docx|.wps|.pages|".contains(paramString)) || (".xls|.xlsx|.et|.numbers|".contains(paramString)) || (".pdf|".contains(paramString)) || (".ppt|.pptx.|.dps|.keynote|".contains(paramString))) {
        break;
      }
    } while (!".apk|".contains(paramString));
    return false;
  }
  
  private void p()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView = ((QfilePinnedHeaderExpandableListView)findViewById(2131366941));
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelection(0);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setFocusable(false);
  }
  
  private void q()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = new NoFileRelativeLayout(a());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setText(2131692357);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.post(new QfileBaseLocalFileTabView.1(this));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.addHeaderView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout = new ViewerMoreRelativeLayout(a());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setOnClickListener(this.b);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.addFooterView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.getHeight();
  }
  
  protected abstract QfileBaseExpandableListAdapter a();
  
  public ListView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView;
  }
  
  protected abstract void a();
  
  public void a(FileInfo paramFileInfo)
  {
    if (paramFileInfo == null) {
      return;
    }
    b(paramFileInfo);
  }
  
  public void a(FileInfo paramFileInfo, View paramView, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().b();
    if ((g()) && (!paramBoolean)) {
      if (FMDataCache.a(paramFileInfo))
      {
        FMDataCache.b(paramFileInfo);
        b(paramFileInfo, false);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h(true);
        if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f) && (!FileUtil.b(paramFileInfo.c())))
        {
          FMToastUtil.a(FileManagerUtil.d(paramFileInfo.d()) + HardCodeUtil.a(2131709598));
          FMDataCache.b(paramFileInfo);
        }
        f();
        w();
        k();
      }
    }
    for (;;)
    {
      a(g());
      do
      {
        return;
        FMDataCache.a(paramFileInfo);
        b(paramFileInfo, true);
        if ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.i()) || (FMDataCache.a(FMDataCache.jdField_a_of_type_Int)) || (FMDataCache.b(paramFileInfo))) {
          break;
        }
        paramView = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131698166);
        paramView.setPositiveButton(2131720056, new DialogUtil.DialogOnClickAdapter());
        paramView.show();
        FMDataCache.b(FMDataCache.jdField_a_of_type_Int);
        FileManagerReporter.a("0X800942D");
        break;
        if (c()) {
          break label228;
        }
      } while (!QLog.isColorLevel());
      QLog.i(jdField_a_of_type_JavaLangString, 2, "click too fast , wait a minute.");
      return;
      label228:
      u();
      FileManagerEntity localFileManagerEntity = FileManagerUtil.a(paramFileInfo);
      Object localObject1 = new CommonFileBrowserParams(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, localFileManagerEntity, 10000);
      if (localFileManagerEntity.nFileType == 0)
      {
        Object localObject2 = new ArrayList();
        if (this.jdField_c_of_type_JavaUtilLinkedHashMap != null)
        {
          Iterator localIterator = this.jdField_c_of_type_JavaUtilLinkedHashMap.keySet().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            ((ArrayList)localObject2).addAll((Collection)this.jdField_c_of_type_JavaUtilLinkedHashMap.get(str));
          }
        }
        FMDataCache.a((ArrayList)localObject2);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("clicked_file_hashcode", paramFileInfo.hashCode());
        ((CommonFileBrowserParams)localObject1).a((Bundle)localObject2);
      }
      localObject1 = new FileBrowserCreator(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (IFileBrowserParams)localObject1);
      ((FileBrowserCreator)localObject1).a(8);
      if (((localFileManagerEntity.nFileType == 0) || (localFileManagerEntity.nFileType == 2)) && (paramView != null) && ((paramView.getId() == 2131366919) || (paramView.getId() == 2131368729))) {
        ((FileBrowserCreator)localObject1).a(AnimationUtils.a(paramView));
      }
      ((FileBrowserCreator)localObject1).a();
      paramView = new FileManagerReporter.FileAssistantReportData();
      paramView.b = "file_viewer_in";
      paramView.jdField_a_of_type_Int = 80;
      paramView.c = FileUtil.a(paramFileInfo.d());
      paramView.jdField_a_of_type_Long = paramFileInfo.a();
      FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramView);
      FileManagerReporter.a("0X8004AE5");
    }
  }
  
  public void a(String paramString1, QfileTabBarView.ScanParams paramScanParams, List<String> paramList, int paramInt1, TreeMap<Long, FileInfo> paramTreeMap, int paramInt2, String paramString2)
  {
    if ((this.h) || (paramString1 == null)) {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "cancel scanMaxFileInfos bPause[" + this.h + "]");
    }
    do
    {
      Object localObject;
      int i;
      do
      {
        do
        {
          for (;;)
          {
            return;
            localObject = new VFSFile(paramString1);
            if (!((VFSFile)localObject).isDirectory()) {
              break;
            }
            if (((VFSFile)localObject).getName().indexOf(".") != 0)
            {
              paramString1 = ((VFSFile)localObject).listFiles();
              if (paramString1 != null)
              {
                int j = paramString1.length;
                i = 0;
                while (i < j)
                {
                  localObject = paramString1[i];
                  if (this.h)
                  {
                    QLog.i(jdField_a_of_type_JavaLangString, 1, "cancel scanMaxFileInfos bPause[" + this.h + "]");
                    return;
                  }
                  a(((VFSFile)localObject).getAbsolutePath(), paramScanParams, paramList, paramInt1, paramTreeMap, paramInt2, paramString2);
                  i += 1;
                }
              }
            }
          }
        } while ((!paramScanParams.a()) && (!a(paramString1, paramInt1)));
        localObject = FileInfo.a(paramString1);
      } while (localObject == null);
      if (paramScanParams.b()) {
        ((FileInfo)localObject).a();
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        i = paramList.indexOf(paramString2);
        paramInt1 = i;
        if (i < 0)
        {
          paramString1 = paramString2;
          if (!paramString2.endsWith("/")) {
            paramString1 = paramString2 + "/";
          }
          paramList.add(paramString1);
          paramInt1 = paramList.size() - 1;
        }
        if (paramInt1 >= 0) {
          ((FileInfo)localObject).e(paramInt1 + "");
        }
      }
      ((FileInfo)localObject).a(true);
      paramTreeMap.put(Long.valueOf(((FileInfo)localObject).a()), localObject);
    } while (paramTreeMap.size() <= paramInt2);
    paramTreeMap.pollFirstEntry();
  }
  
  protected void a(boolean paramBoolean)
  {
    String str2 = "";
    String str1;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.k()) {
      if ((this instanceof QfileLocalFileMediaTabView))
      {
        str1 = "0x8009DAF";
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", str1, str1, 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      return;
      if ((this instanceof QfileLocalFilePicTabView))
      {
        str1 = "0x8009DB1";
        break;
      }
      if ((this instanceof QfileLocalFileDocTabView))
      {
        str1 = "0x8009DB3";
        break;
      }
      if ((this instanceof QfileLocalFileAppTabView))
      {
        str1 = "0x8009DB5";
        break;
      }
      str1 = str2;
      if (!(this instanceof QfileLocalFileOtherTabView)) {
        break;
      }
      str1 = "0x8009DB7";
      break;
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.j()) && (!paramBoolean)) {
        if ((this instanceof QfileLocalFileMediaTabView)) {
          str1 = "0X8009E49";
        }
      }
      while (!TextUtils.isEmpty(str1))
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", str1, str1, 0, 0, "", "", "", "");
        return;
        if ((this instanceof QfileLocalFilePicTabView))
        {
          str1 = "0X8009E46";
        }
        else if ((this instanceof QfileLocalFileDocTabView))
        {
          str1 = "0X8009E44";
        }
        else if ((this instanceof QfileLocalFileAppTabView))
        {
          str1 = "0X8009E4C";
        }
        else
        {
          str1 = str2;
          if ((this instanceof QfileLocalFileOtherTabView))
          {
            str1 = "0X8009E48";
            continue;
            str1 = str2;
            if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.j()) {
              if ((this instanceof QfileLocalFileMediaTabView))
              {
                str1 = "0X8009E5B";
              }
              else if ((this instanceof QfileLocalFilePicTabView))
              {
                str1 = "0X8009E58";
              }
              else if ((this instanceof QfileLocalFileDocTabView))
              {
                str1 = "0X8009E56";
              }
              else if ((this instanceof QfileLocalFileAppTabView))
              {
                str1 = "0X8009E5E";
              }
              else
              {
                str1 = str2;
                if ((this instanceof QfileLocalFileOtherTabView)) {
                  str1 = "0X8009E5A";
                }
              }
            }
          }
        }
      }
    }
  }
  
  public boolean a(FileInfo paramFileInfo)
  {
    if (paramFileInfo == null) {
      return false;
    }
    return b(paramFileInfo);
  }
  
  public void b()
  {
    int i = 0;
    d(2131560922);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(a());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    p();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter = a();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView);
    q();
    if (((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter instanceof QfileLocalImageExpandableListAdapter)) || ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter instanceof QFileDelDownloadAdapter)))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelector(2131167305);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setTranscriptMode(0);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setWhetherImageTab(true);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setGridSize(((QfileLocalImageExpandableListAdapter)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter).b());
      i = 0;
    }
    while (i < this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.getGroupCount())
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.expandGroup(i);
      i += 1;
      continue;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelector(2131167305);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setTranscriptMode(0);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setWhetherImageTab(false);
      while (i < this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.getGroupCount())
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.expandGroup(i);
        i += 1;
      }
    }
    setLoadAllRecord(true);
  }
  
  protected abstract void b(FileInfo paramFileInfo);
  
  protected void b(FileInfo paramFileInfo, boolean paramBoolean) {}
  
  public void b(boolean paramBoolean) {}
  
  protected abstract boolean b(FileInfo paramFileInfo);
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.b();
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_JavaLangRunnable, 64);
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_c_of_type_JavaUtilLinkedHashMap.clear();
    v();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a();
  }
  
  public void d()
  {
    if (this.jdField_c_of_type_JavaUtilLinkedHashMap == null) {
      return;
    }
    Iterator localIterator = new ArrayList(this.jdField_c_of_type_JavaUtilLinkedHashMap.values()).iterator();
    while (localIterator.hasNext()) {
      FMDataCache.a((List)localIterator.next());
    }
    int j = this.jdField_c_of_type_JavaUtilLinkedHashMap.keySet().size();
    int i = 0;
    while (i < j)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.expandGroup(i);
      i += 1;
    }
    w();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.notifyDataSetChanged();
  }
  
  public void e()
  {
    Iterator localIterator1 = this.jdField_c_of_type_JavaUtilLinkedHashMap.values().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((List)localIterator1.next()).iterator();
      while (localIterator2.hasNext()) {
        FMDataCache.b((FileInfo)localIterator2.next());
      }
    }
    w();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.notifyDataSetChanged();
  }
  
  protected void f()
  {
    if ((this.jdField_c_of_type_JavaUtilLinkedHashMap == null) || (this.jdField_c_of_type_JavaUtilLinkedHashMap.size() == 0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.j()) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setTopViewHeight(0.5F);
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setVisible(true);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setText(2131692366);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setGone();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.notifyDataSetChanged();
      g();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setGone();
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.removeHeaderView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout);
      }
    }
  }
  
  protected void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setLayoutParams(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.getWidth(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.getHeight());
    }
  }
  
  protected void h() {}
  
  public void i()
  {
    a(new QfileBaseLocalFileTabView.8(this));
  }
  
  public void j()
  {
    if (this.jdField_c_of_type_JavaUtilLinkedHashMap.size() > 0) {
      f();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f());
  }
  
  protected void k()
  {
    if ((this.jdField_c_of_type_JavaUtilLinkedHashMap == null) || (this.jdField_c_of_type_JavaUtilLinkedHashMap.size() == 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g(true);
  }
  
  public void n()
  {
    this.h = false;
    if ((this.jdField_c_of_type_JavaUtilLinkedHashMap == null) || (this.jdField_c_of_type_JavaUtilLinkedHashMap.size() == 0)) {
      a();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f());
  }
  
  protected void o()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListenerVer51 != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListenerVer51);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListenerVer51 = new QfileBaseLocalFileTabView.11(this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListenerVer51);
  }
  
  public void setLoadAllRecord(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setGone();
      }
    }
    for (;;)
    {
      this.g = paramBoolean;
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setVisible();
      }
    }
  }
  
  public void setPos(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt2 < 0)) {}
    while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.getGroupCount() <= paramInt1) {
      return;
    }
    a(new QfileBaseLocalFileTabView.9(this, paramInt1, paramInt2));
  }
  
  public void setSelect(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.getGroupCount() <= paramInt) {
      return;
    }
    a(new QfileBaseLocalFileTabView.10(this, paramInt));
  }
  
  public void setTabType(int paramInt) {}
  
  public void t()
  {
    super.t();
    this.h = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView
 * JD-Core Version:    0.7.0.1
 */