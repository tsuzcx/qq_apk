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
  static String o = "QfileBaseLocalFileTabView<FileAssistant>";
  public View.OnLongClickListener A = new QfileBaseLocalFileTabView.4(this);
  public View.OnClickListener B = new QfileBaseLocalFileTabView.5(this);
  public View.OnClickListener K = new QfileBaseLocalFileTabView.6(this);
  IClickListenerVer51 L = null;
  private FMObserver a = new QfileBaseLocalFileTabView.7(this);
  protected LinkedHashMap<String, List<FileInfo>> l = null;
  protected List<QfileTabBarView.ScanParams> m;
  protected boolean n;
  public ViewerMoreRelativeLayout p;
  NoFileRelativeLayout q = null;
  protected QfilePinnedHeaderExpandableListView r;
  boolean s;
  LayoutInflater t = null;
  protected boolean u = false;
  protected ArrayList<FileInfo> v = null;
  protected QfileBaseExpandableListAdapter w = null;
  BubblePopupWindow x = null;
  public View.OnClickListener y = new QfileBaseLocalFileTabView.2(this);
  public View.OnClickListener z = new QfileBaseLocalFileTabView.3(this);
  
  public QfileBaseLocalFileTabView(Context paramContext, List<QfileTabBarView.ScanParams> paramList, boolean paramBoolean)
  {
    super(paramContext);
    this.m = paramList;
    this.n = paramBoolean;
    this.l = new LinkedHashMap();
    this.v = new ArrayList();
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
  
  private void o()
  {
    this.r = ((QfilePinnedHeaderExpandableListView)findViewById(2131433125));
    this.r.setSelection(0);
    this.r.setFocusable(false);
  }
  
  private void p()
  {
    try
    {
      this.q = new NoFileRelativeLayout(getActivity());
      this.q.setText(2131889274);
      this.r.post(new QfileBaseLocalFileTabView.1(this));
      this.r.addHeaderView(this.q);
      this.p = new ViewerMoreRelativeLayout(getActivity());
      this.p.setOnClickListener(this.z);
      this.r.addFooterView(this.p);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected int a(List<FileInfo> paramList, long paramLong)
  {
    int j = paramList.size() - 1;
    int i = 0;
    while (i <= j)
    {
      int k = i + j >>> 1;
      FileInfo localFileInfo = (FileInfo)paramList.get(k);
      if (localFileInfo.g() > paramLong) {
        i = k + 1;
      } else if (localFileInfo.g() < paramLong) {
        j = k - 1;
      } else {
        return k;
      }
    }
    return i;
  }
  
  public void a()
  {
    setContentView(2131627054);
    this.t = LayoutInflater.from(getActivity());
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).addObserver(this.a);
    o();
    this.w = getQfileRecentFileBaseExpandableListAdapter();
    this.w.a(this.r);
    p();
    QfileBaseExpandableListAdapter localQfileBaseExpandableListAdapter = this.w;
    boolean bool = localQfileBaseExpandableListAdapter instanceof QfileLocalImageExpandableListAdapter;
    int j = 0;
    int i = 0;
    if ((!bool) && (!(localQfileBaseExpandableListAdapter instanceof QFileDelDownloadAdapter)))
    {
      this.r.setSelector(2131168376);
      this.r.setAdapter(this.w);
      this.r.setTranscriptMode(0);
      this.r.setWhetherImageTab(false);
    }
    while (i < this.w.getGroupCount())
    {
      this.r.expandGroup(i);
      i += 1;
      continue;
      this.r.setSelector(2131168376);
      this.r.setAdapter(this.w);
      this.r.setTranscriptMode(0);
      this.r.setWhetherImageTab(true);
      this.r.setGridSize(((QfileLocalImageExpandableListAdapter)this.w).b());
      i = j;
      while (i < this.w.getGroupCount())
      {
        this.r.expandGroup(i);
        i += 1;
      }
    }
    setLoadAllRecord(true);
  }
  
  public void a(FileInfo paramFileInfo, View paramView, boolean paramBoolean)
  {
    if ((B()) && (!paramBoolean))
    {
      if (FMDataCache.a(paramFileInfo))
      {
        FMDataCache.c(paramFileInfo);
        b(paramFileInfo, false);
      }
      else
      {
        FMDataCache.b(paramFileInfo);
        b(paramFileInfo, true);
        if ((this.C.I()) && (!FMDataCache.c(FMDataCache.a)) && (!FMDataCache.d(paramFileInfo)))
        {
          paramView = DialogUtil.a(this.C, 2131896123);
          paramView.setPositiveButton(2131917392, new DialogUtil.DialogOnClickAdapter());
          paramView.show();
          FMDataCache.b(FMDataCache.a);
          FileManagerReporter.a("0X800942D");
        }
      }
      this.C.h(true);
      if ((this.C.l) && (!FileUtils.fileExistsAndNotEmpty(paramFileInfo.d())))
      {
        paramView = new StringBuilder();
        paramView.append(QQFileManagerUtil.b(paramFileInfo.e()));
        paramView.append(HardCodeUtil.a(2131896095));
        FMToastUtil.a(paramView.toString());
        FMDataCache.c(paramFileInfo);
      }
      e();
      C();
      h();
    }
    else
    {
      if (!v())
      {
        if (QLog.isColorLevel()) {
          QLog.i(o, 2, "click too fast , wait a minute.");
        }
        return;
      }
      w();
      FileManagerEntity localFileManagerEntity = QQFileManagerUtil.a(paramFileInfo);
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).openLocalFileViewBrowser(this.C, this.l, paramFileInfo, paramView, localFileManagerEntity);
      paramView = new FileManagerReporter.FileAssistantReportData();
      paramView.b = "file_viewer_in";
      paramView.c = 80;
      paramView.d = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getExtension(paramFileInfo.e());
      paramView.e = paramFileInfo.f();
      FileManagerReporter.a(this.D.getCurrentAccountUin(), paramView);
      FileManagerReporter.a("0X8004AE5");
    }
    a(B());
  }
  
  protected void a(String paramString1, QfileTabBarView.ScanParams paramScanParams, List<String> paramList, int paramInt1, TreeMap<Long, FileInfo> paramTreeMap, int paramInt2, String paramString2)
  {
    String str = paramString2;
    if ((!this.u) && (paramString1 != null))
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
          if (this.u)
          {
            paramString1 = o;
            paramScanParams = new StringBuilder();
            paramScanParams.append("cancel scanMaxFileInfos bPause[");
            paramScanParams.append(this.u);
            paramScanParams.append("]");
            QLog.i(paramString1, 1, paramScanParams.toString());
            return;
          }
          a(str.getAbsolutePath(), paramScanParams, paramList, paramInt1, paramTreeMap, paramInt2, paramString2);
          i += 1;
        }
      }
      if ((!paramScanParams.b()) && (!a(paramString1, paramInt1))) {
        return;
      }
      localObject = FileInfo.e(paramString1);
      if (localObject == null) {
        return;
      }
      if (paramScanParams.c()) {
        ((FileInfo)localObject).i();
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
          ((FileInfo)localObject).f(paramString1.toString());
        }
      }
      ((FileInfo)localObject).a(true);
      paramTreeMap.put(Long.valueOf(((FileInfo)localObject).f()), localObject);
      if (paramTreeMap.size() > paramInt2) {
        paramTreeMap.pollFirstEntry();
      }
      return;
    }
    paramString1 = o;
    paramScanParams = new StringBuilder();
    paramScanParams.append("cancel scanMaxFileInfos bPause[");
    paramScanParams.append(this.u);
    paramScanParams.append("]");
    QLog.i(paramString1, 1, paramScanParams.toString());
  }
  
  protected void a(boolean paramBoolean)
  {
    boolean bool = this.C.K();
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
      ReportController.b(this.D, "dc00898", "", "", str1, str1, 0, 0, "", "", "", "");
      return;
    }
    if ((this.C.J()) && (!paramBoolean))
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
      if (!this.C.J()) {
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
      ReportController.b(this.D, "dc00898", "", "", str1, str1, 0, 0, "", "", "", "");
    }
  }
  
  public void b()
  {
    super.b();
    if (this.J != null) {
      ThreadManager.removeJobFromThreadPool(this.J, 64);
    }
    this.v.clear();
    this.l.clear();
    x();
    if (this.a != null) {
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).deleteObserver(this.a);
    }
  }
  
  public void b(FileInfo paramFileInfo)
  {
    if (paramFileInfo == null) {
      return;
    }
    d(paramFileInfo);
  }
  
  protected void b(FileInfo paramFileInfo, boolean paramBoolean) {}
  
  public void b(boolean paramBoolean) {}
  
  public void c()
  {
    Object localObject = this.l;
    if (localObject == null) {
      return;
    }
    localObject = new ArrayList(((LinkedHashMap)localObject).values()).iterator();
    while (((Iterator)localObject).hasNext()) {
      FMDataCache.a((List)((Iterator)localObject).next());
    }
    int j = this.l.keySet().size();
    int i = 0;
    while (i < j)
    {
      this.r.expandGroup(i);
      i += 1;
    }
    C();
    this.w.notifyDataSetChanged();
  }
  
  public boolean c(FileInfo paramFileInfo)
  {
    if (paramFileInfo == null) {
      return false;
    }
    return e(paramFileInfo);
  }
  
  public void d()
  {
    Iterator localIterator1 = this.l.values().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((List)localIterator1.next()).iterator();
      while (localIterator2.hasNext()) {
        FMDataCache.c((FileInfo)localIterator2.next());
      }
    }
    C();
    this.w.notifyDataSetChanged();
  }
  
  protected abstract void d(FileInfo paramFileInfo);
  
  protected void e()
  {
    Object localObject = this.l;
    if ((localObject != null) && (((LinkedHashMap)localObject).size() != 0))
    {
      localObject = this.q;
      if (localObject != null)
      {
        ((NoFileRelativeLayout)localObject).setGone();
        this.r.removeHeaderView(this.q);
      }
    }
    else
    {
      if (this.C.J()) {
        this.q.setTopViewHeight(0.5F);
      }
      this.q.setVisible(true);
      this.q.setText(2131889282);
      localObject = this.p;
      if (localObject != null) {
        ((ViewerMoreRelativeLayout)localObject).setGone();
      }
    }
    this.w.notifyDataSetChanged();
    f();
  }
  
  protected abstract boolean e(FileInfo paramFileInfo);
  
  protected void f()
  {
    NoFileRelativeLayout localNoFileRelativeLayout = this.q;
    if (localNoFileRelativeLayout != null) {
      localNoFileRelativeLayout.setLayoutParams(this.r.getWidth(), this.r.getHeight());
    }
  }
  
  protected void g() {}
  
  public int getFootHeight()
  {
    return this.p.getHeight();
  }
  
  public ListView getListView()
  {
    return this.r;
  }
  
  protected abstract QfileBaseExpandableListAdapter getQfileRecentFileBaseExpandableListAdapter();
  
  protected abstract void getRecentFileRecords();
  
  protected void h()
  {
    LinkedHashMap localLinkedHashMap = this.l;
    if ((localLinkedHashMap != null) && (localLinkedHashMap.size() != 0))
    {
      this.C.g(true);
      return;
    }
    this.C.g(false);
  }
  
  public void i()
  {
    a(new QfileBaseLocalFileTabView.8(this));
  }
  
  public void j()
  {
    if (this.l.size() > 0) {
      e();
    }
    this.C.b(this.C.D());
  }
  
  protected void k()
  {
    if (this.L != null)
    {
      this.C.a(this.L);
      return;
    }
    this.L = new QfileBaseLocalFileTabView.11(this);
    this.C.a(this.L);
  }
  
  public void n()
  {
    this.u = false;
    LinkedHashMap localLinkedHashMap = this.l;
    if ((localLinkedHashMap == null) || (localLinkedHashMap.size() == 0)) {
      getRecentFileRecords();
    }
    this.C.b(this.C.D());
  }
  
  public void setLoadAllRecord(boolean paramBoolean)
  {
    ViewerMoreRelativeLayout localViewerMoreRelativeLayout;
    if (paramBoolean)
    {
      localViewerMoreRelativeLayout = this.p;
      if (localViewerMoreRelativeLayout != null) {
        localViewerMoreRelativeLayout.setGone();
      }
    }
    else
    {
      localViewerMoreRelativeLayout = this.p;
      if (localViewerMoreRelativeLayout != null) {
        localViewerMoreRelativeLayout.setVisible();
      }
    }
    this.s = paramBoolean;
  }
  
  public void setPos(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      if (paramInt2 < 0) {
        return;
      }
      if (this.w.getGroupCount() <= paramInt1) {
        return;
      }
      a(new QfileBaseLocalFileTabView.9(this, paramInt1, paramInt2));
    }
  }
  
  public void setSelect(int paramInt)
  {
    if (this.w.getGroupCount() <= paramInt) {
      return;
    }
    a(new QfileBaseLocalFileTabView.10(this, paramInt));
  }
  
  public void setTabType(int paramInt) {}
  
  public void u()
  {
    super.u();
    this.u = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView
 * JD-Core Version:    0.7.0.1
 */