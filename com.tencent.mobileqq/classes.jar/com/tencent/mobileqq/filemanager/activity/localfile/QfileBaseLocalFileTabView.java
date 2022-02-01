package com.tencent.mobileqq.filemanager.activity.localfile;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileLocalImageExpandableListAdapter;
import com.tencent.mobileqq.filemanager.activity.delDownloadFile.QFileDelDownloadAdapter;
import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.FileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.IClickListenerVer51;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView.ScanParams;
import com.tencent.mobileqq.filemanager.widget.ViewerMoreRelativeLayout;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.ListView;
import java.io.File;
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
  BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
  protected ArrayList<FileInfo> a;
  public View.OnClickListener b = new QfileBaseLocalFileTabView.3(this);
  public View.OnClickListener c;
  protected LinkedHashMap<String, List<FileInfo>> c;
  public View.OnClickListener d;
  protected List<QfileTabBarView.ScanParams> d;
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
    paramString = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getExtension(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = paramString.toLowerCase();
    if ((paramInt == 0) && (!".jpg|.bmp|.jpeg|.gif|.png|.ico|".contains(paramString))) {
      return false;
    }
    if ((paramInt == 2) && (!".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|".contains(paramString))) {
      return false;
    }
    if (paramInt == 3)
    {
      if ((!".doc|.docx|.wps|.pages|".contains(paramString)) && (!".xls|.xlsx|.et|.numbers|".contains(paramString)) && (!".pdf|".contains(paramString)) && (!".ppt|.pptx.|.dps|.keynote|".contains(paramString))) {
        return false;
      }
    }
    else
    {
      if ((paramInt == 5) && (!".apk|".contains(paramString))) {
        return false;
      }
      if ((paramInt == 11) && ((".jpg|.bmp|.jpeg|.gif|.png|.ico|".contains(paramString)) || (".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|".contains(paramString)) || (".doc|.docx|.wps|.pages|".contains(paramString)) || (".xls|.xlsx|.et|.numbers|".contains(paramString)) || (".pdf|".contains(paramString)) || (".ppt|.pptx.|.dps|.keynote|".contains(paramString)) || (".apk|".contains(paramString)))) {
        return false;
      }
    }
    return true;
  }
  
  private void p()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView = ((QfilePinnedHeaderExpandableListView)findViewById(2131366803));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelection(0);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setFocusable(false);
  }
  
  private void q()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = new NoFileRelativeLayout(a());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setText(2131692286);
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
  
  protected int a(List<FileInfo> paramList, long paramLong)
  {
    int j = paramList.size() - 1;
    int i = 0;
    while (i <= j)
    {
      int k = i + j >>> 1;
      FileInfo localFileInfo = (FileInfo)paramList.get(k);
      if (localFileInfo.b() > paramLong) {
        i = k + 1;
      } else if (localFileInfo.b() < paramLong) {
        j = k - 1;
      } else {
        return k;
      }
    }
    return i;
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
    if ((g()) && (!paramBoolean))
    {
      if (FMDataCache.a(paramFileInfo))
      {
        FMDataCache.b(paramFileInfo);
        b(paramFileInfo, false);
      }
      else
      {
        FMDataCache.a(paramFileInfo);
        b(paramFileInfo, true);
        if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.i()) && (!FMDataCache.a(FMDataCache.jdField_a_of_type_Int)) && (!FMDataCache.b(paramFileInfo)))
        {
          paramView = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131698222);
          paramView.setPositiveButton(2131719788, new DialogUtil.DialogOnClickAdapter());
          paramView.show();
          FMDataCache.b(FMDataCache.jdField_a_of_type_Int);
          FileManagerReporter.a("0X800942D");
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h(true);
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f) && (!FileUtils.fileExistsAndNotEmpty(paramFileInfo.c())))
      {
        paramView = new StringBuilder();
        paramView.append(QQFileManagerUtil.b(paramFileInfo.d()));
        paramView.append(HardCodeUtil.a(2131698194));
        FMToastUtil.a(paramView.toString());
        FMDataCache.b(paramFileInfo);
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
      u();
      FileManagerEntity localFileManagerEntity = QQFileManagerUtil.a(paramFileInfo);
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).openLocalFileViewBrowser(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, this.jdField_c_of_type_JavaUtilLinkedHashMap, paramFileInfo, paramView, localFileManagerEntity);
      paramView = new FileManagerReporter.FileAssistantReportData();
      paramView.b = "file_viewer_in";
      paramView.jdField_a_of_type_Int = 80;
      paramView.c = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getExtension(paramFileInfo.d());
      paramView.jdField_a_of_type_Long = paramFileInfo.a();
      FileManagerReporter.a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getCurrentAccountUin(), paramView);
      FileManagerReporter.a("0X8004AE5");
    }
    a(g());
  }
  
  protected void a(String paramString1, QfileTabBarView.ScanParams paramScanParams, List<String> paramList, int paramInt1, TreeMap<Long, FileInfo> paramTreeMap, int paramInt2, String paramString2)
  {
    String str = paramString2;
    if ((!this.h) && (paramString1 != null))
    {
      Object localObject = new File(paramString1);
      int i;
      if (((File)localObject).isDirectory())
      {
        if (((File)localObject).getName().indexOf(".") == 0) {
          return;
        }
        paramString1 = ((File)localObject).listFiles();
        if (paramString1 == null) {
          return;
        }
        int j = paramString1.length;
        i = 0;
        while (i < j)
        {
          str = paramString1[i];
          if (this.h)
          {
            paramString1 = jdField_a_of_type_JavaLangString;
            paramScanParams = new StringBuilder();
            paramScanParams.append("cancel scanMaxFileInfos bPause[");
            paramScanParams.append(this.h);
            paramScanParams.append("]");
            QLog.i(paramString1, 1, paramScanParams.toString());
            return;
          }
          a(str.getAbsolutePath(), paramScanParams, paramList, paramInt1, paramTreeMap, paramInt2, paramString2);
          i += 1;
        }
      }
      if ((!paramScanParams.a()) && (!a(paramString1, paramInt1))) {
        return;
      }
      localObject = FileInfo.a(paramString1);
      if (localObject == null) {
        return;
      }
      if (paramScanParams.b()) {
        ((FileInfo)localObject).a();
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        i = paramList.indexOf(str);
        paramInt1 = i;
        if (i < 0)
        {
          paramString1 = str;
          if (!str.endsWith("/"))
          {
            paramString1 = new StringBuilder();
            paramString1.append(str);
            paramString1.append("/");
            paramString1 = paramString1.toString();
          }
          paramList.add(paramString1);
          paramInt1 = paramList.size() - 1;
        }
        if (paramInt1 >= 0)
        {
          paramString1 = new StringBuilder();
          paramString1.append(paramInt1);
          paramString1.append("");
          ((FileInfo)localObject).e(paramString1.toString());
        }
      }
      ((FileInfo)localObject).a(true);
      paramTreeMap.put(Long.valueOf(((FileInfo)localObject).a()), localObject);
      if (paramTreeMap.size() > paramInt2) {
        paramTreeMap.pollFirstEntry();
      }
      return;
    }
    paramString1 = jdField_a_of_type_JavaLangString;
    paramScanParams = new StringBuilder();
    paramScanParams.append("cancel scanMaxFileInfos bPause[");
    paramScanParams.append(this.h);
    paramScanParams.append("]");
    QLog.i(paramString1, 1, paramScanParams.toString());
  }
  
  protected void a(boolean paramBoolean)
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.k();
    String str2 = "";
    String str1;
    if (bool)
    {
      if ((this instanceof QfileLocalFileMediaTabView)) {
        str1 = "0x8009DAF";
      }
      for (;;)
      {
        break;
        if ((this instanceof QfileLocalFilePicTabView))
        {
          str1 = "0x8009DB1";
        }
        else if ((this instanceof QfileLocalFileDocTabView))
        {
          str1 = "0x8009DB3";
        }
        else if ((this instanceof QfileLocalFileAppTabView))
        {
          str1 = "0x8009DB5";
        }
        else
        {
          str1 = str2;
          if ((this instanceof QfileLocalFileOtherTabView)) {
            str1 = "0x8009DB7";
          }
        }
      }
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "dc00898", "", "", str1, str1, 0, 0, "", "", "", "");
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.j()) && (!paramBoolean))
    {
      if ((this instanceof QfileLocalFileMediaTabView))
      {
        str1 = "0X8009E49";
      }
      else if ((this instanceof QfileLocalFilePicTabView))
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
        if ((this instanceof QfileLocalFileOtherTabView)) {
          str1 = "0X8009E48";
        }
      }
    }
    else
    {
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
    if (!TextUtils.isEmpty(str1)) {
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "dc00898", "", "", str1, str1, 0, 0, "", "", "", "");
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
    d(2131560796);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(a());
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    p();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter = a();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView);
    q();
    QfileBaseExpandableListAdapter localQfileBaseExpandableListAdapter = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter;
    boolean bool = localQfileBaseExpandableListAdapter instanceof QfileLocalImageExpandableListAdapter;
    int j = 0;
    int i = 0;
    if ((!bool) && (!(localQfileBaseExpandableListAdapter instanceof QFileDelDownloadAdapter)))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelector(2131167333);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setTranscriptMode(0);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setWhetherImageTab(false);
    }
    while (i < this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.getGroupCount())
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.expandGroup(i);
      i += 1;
      continue;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelector(2131167333);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setTranscriptMode(0);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setWhetherImageTab(true);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setGridSize(((QfileLocalImageExpandableListAdapter)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter).b());
      i = j;
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
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_JavaLangRunnable, 64);
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_c_of_type_JavaUtilLinkedHashMap.clear();
    v();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
  }
  
  public void d()
  {
    Object localObject = this.jdField_c_of_type_JavaUtilLinkedHashMap;
    if (localObject == null) {
      return;
    }
    localObject = new ArrayList(((LinkedHashMap)localObject).values()).iterator();
    while (((Iterator)localObject).hasNext()) {
      FMDataCache.a((List)((Iterator)localObject).next());
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
    Object localObject = this.jdField_c_of_type_JavaUtilLinkedHashMap;
    if ((localObject != null) && (((LinkedHashMap)localObject).size() != 0))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout;
      if (localObject != null)
      {
        ((NoFileRelativeLayout)localObject).setGone();
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.removeHeaderView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout);
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.j()) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setTopViewHeight(0.5F);
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setVisible(true);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setText(2131692294);
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout;
      if (localObject != null) {
        ((ViewerMoreRelativeLayout)localObject).setGone();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.notifyDataSetChanged();
    g();
  }
  
  protected void g()
  {
    NoFileRelativeLayout localNoFileRelativeLayout = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout;
    if (localNoFileRelativeLayout != null) {
      localNoFileRelativeLayout.setLayoutParams(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.getWidth(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.getHeight());
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
    LinkedHashMap localLinkedHashMap = this.jdField_c_of_type_JavaUtilLinkedHashMap;
    if ((localLinkedHashMap != null) && (localLinkedHashMap.size() != 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g(true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g(false);
  }
  
  public void n()
  {
    this.h = false;
    LinkedHashMap localLinkedHashMap = this.jdField_c_of_type_JavaUtilLinkedHashMap;
    if ((localLinkedHashMap == null) || (localLinkedHashMap.size() == 0)) {
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
    ViewerMoreRelativeLayout localViewerMoreRelativeLayout;
    if (paramBoolean)
    {
      localViewerMoreRelativeLayout = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout;
      if (localViewerMoreRelativeLayout != null) {
        localViewerMoreRelativeLayout.setGone();
      }
    }
    else
    {
      localViewerMoreRelativeLayout = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout;
      if (localViewerMoreRelativeLayout != null) {
        localViewerMoreRelativeLayout.setVisible();
      }
    }
    this.g = paramBoolean;
  }
  
  public void setPos(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      if (paramInt2 < 0) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.getGroupCount() <= paramInt1) {
        return;
      }
      a(new QfileBaseLocalFileTabView.9(this, paramInt1, paramInt2));
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView
 * JD-Core Version:    0.7.0.1
 */