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
  static String a = "<FileAssistant>";
  String b;
  LinkedHashMap<String, List<FileManagerEntity>> c = null;
  NoFileRelativeLayout d = null;
  View e = null;
  View f = null;
  TextView g = null;
  QfilePinnedHeaderExpandableListView h;
  long i = -1L;
  LayoutInflater j = null;
  List<FileManagerEntity> k = null;
  QfileBaseExpandableListAdapter l = null;
  final String m = "LastRequestTime";
  int n = 0;
  volatile boolean o = false;
  boolean p = false;
  Comparator<FileManagerEntity> q = new QfileBaseRecentFileTabView.1(this);
  BubblePopupWindow r = null;
  public View.OnClickListener s = new QfileBaseRecentFileTabView.4(this);
  public View.OnLongClickListener t = new QfileBaseRecentFileTabView.RecentFileItemLongClickListener(this);
  public View.OnClickListener u = new QfileBaseRecentFileTabView.5(this);
  public View.OnClickListener v = new QfileBaseRecentFileTabView.6(this);
  private int w;
  private FMObserver x = new QfileBaseRecentFileTabView.7(this);
  
  public QfileBaseRecentFileTabView(Context paramContext)
  {
    super(paramContext);
    this.c = new LinkedHashMap();
    this.k = new ArrayList();
  }
  
  public QfileBaseRecentFileTabView(Context paramContext, String paramString)
  {
    super(paramContext);
    this.b = paramString;
    this.c = new LinkedHashMap();
    this.k = new ArrayList();
  }
  
  private void a(boolean paramBoolean, FileManagerEntity paramFileManagerEntity)
  {
    if ((this.C.J()) && (!paramBoolean))
    {
      if ((this instanceof QfileRecentAllFileTabView))
      {
        if ((paramFileManagerEntity.nFileType == 13) && (this.w == 1)) {
          ReportController.b(this.D, "dc00898", "", "", "0X800A072", "0X800A072", 0, 0, "", "", "", "");
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
    else if (!this.C.J())
    {
      if ((this instanceof QfileRecentAllFileTabView))
      {
        if ((paramFileManagerEntity.nFileType == 13) && (this.w == 2)) {
          ReportController.b(this.D, "dc00898", "", "", "0X800A087", "0X800A087", 0, 0, "", "", "", "");
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
      if (((this instanceof QfileRecentTencentDocFileTabView)) && (this.w == 2))
      {
        paramFileManagerEntity = "0X800A08C";
        break label279;
      }
    }
    paramFileManagerEntity = "";
    label279:
    if (!TextUtils.isEmpty(paramFileManagerEntity)) {
      ReportController.b(this.D, "dc00898", "", "", paramFileManagerEntity, paramFileManagerEntity, 0, 0, "", "", "", "");
    }
  }
  
  private void f(FileManagerEntity paramFileManagerEntity)
  {
    Object localObject;
    if (FMDataCache.a(paramFileManagerEntity))
    {
      FMDataCache.c(paramFileManagerEntity);
    }
    else
    {
      FMDataCache.b(paramFileManagerEntity);
      if ((this.C.I()) && (!FMDataCache.c(FMDataCache.a)) && (!FMDataCache.d(paramFileManagerEntity)))
      {
        localObject = DialogUtil.a(this.C, 2131896123);
        ((QQCustomDialog)localObject).setPositiveButton(2131917392, new DialogUtil.DialogOnClickAdapter());
        ((QQCustomDialog)localObject).show();
        FMDataCache.b(FMDataCache.a);
        FileManagerReporter.a("0X800942D");
      }
    }
    if (((this instanceof QfileRecentDocFileTabView)) || ((this instanceof QfileRecentAllFileTabView))) {
      this.C.h(true);
    }
    if ((this.C.l) && (paramFileManagerEntity.cloudType == 3) && (!FileUtils.fileExistsAndNotEmpty(paramFileManagerEntity.getFilePath())))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(QQFileManagerUtil.b(paramFileManagerEntity.fileName));
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131896095));
      FMToastUtil.a(((StringBuilder)localObject).toString());
      FMDataCache.c(paramFileManagerEntity);
    }
    C();
    f();
  }
  
  private void h() {}
  
  private void k()
  {
    this.h = ((QfilePinnedHeaderExpandableListView)findViewById(2131433125));
    this.h.setSelection(0);
    AccessibilityUtil.a(this.h, false);
    this.h.setFocusable(false);
  }
  
  private void o()
  {
    try
    {
      this.d = new NoFileRelativeLayout(getActivity());
      this.d.setText(2131889283);
      this.d.setVisible(false);
      this.h.addHeaderView(this.d);
      this.d.setGone();
      this.e = this.C.getLayoutInflater().inflate(2131629376, null, false);
      this.f = this.e.findViewById(2131447431);
      this.g = ((TextView)this.e.findViewById(2131447119));
      ((ImageView)this.e.findViewById(2131437100)).setColorFilter(-15550475, PorterDuff.Mode.MULTIPLY);
      ((ImageView)this.e.findViewById(2131430806)).setOnClickListener(new QfileBaseRecentFileTabView.3(this));
      this.h.addHeaderView(this.e);
      this.f.setVisibility(8);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private boolean p()
  {
    if (QQFileManagerUtil.c(getContext()))
    {
      Object localObject1 = this.c;
      if ((localObject1 != null) && (((LinkedHashMap)localObject1).size() > 0))
      {
        int i1;
        boolean bool;
        do
        {
          localObject1 = this.c.keySet().iterator();
          Object localObject2;
          while (!((Iterator)localObject2).hasNext())
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject2 = (String)((Iterator)localObject1).next();
            localObject2 = ((List)this.c.get(localObject2)).iterator();
          }
          FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject2).next();
          if (localFileManagerEntity.fileSize > FMDataCache.c()) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          bool = QQFileManagerUtil.b(localFileManagerEntity.fileName, TencentDocConfig.a().a);
        } while ((i1 == 0) && (bool));
        return true;
      }
    }
    return false;
  }
  
  public void a()
  {
    setContentView(2131627054);
    this.j = LayoutInflater.from(getActivity());
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).addObserver(this.x);
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).addDatalineObserver();
    k();
    this.l = getQfileRecentFileBaseExpandableListAdapter();
    this.l.a(this.h);
    o();
    this.h.setSelector(2131168376);
    boolean bool = this.l instanceof QfileRecentImageExpandableListAdapter;
    int i2 = 0;
    int i1 = 0;
    if (bool)
    {
      this.h.setSelector(2131168376);
      this.h.setWhetherImageTab(true);
      this.h.setGridSize(((QfileRecentImageExpandableListAdapter)this.l).a());
      this.h.setAdapter(this.l);
      this.h.setTranscriptMode(0);
      while (i1 < this.l.getGroupCount())
      {
        this.h.expandGroup(i1);
        i1 += 1;
      }
    }
    this.h.setSelector(2131168376);
    this.h.setWhetherImageTab(false);
    this.h.setAdapter(this.l);
    this.h.setTranscriptMode(0);
    i1 = i2;
    while (i1 < this.l.getGroupCount())
    {
      this.h.expandGroup(i1);
      i1 += 1;
    }
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      return;
    }
    c(paramFileManagerEntity);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, View paramView, boolean paramBoolean)
  {
    if ((B()) && (!paramBoolean))
    {
      f(paramFileManagerEntity);
    }
    else
    {
      if (!v())
      {
        if (QLog.isColorLevel()) {
          QLog.i(a, 2, "click too fast , wait a minute.");
        }
        return;
      }
      w();
      QQFileManagerUtil.j(paramFileManagerEntity);
      FileManagerReporter.FileAssistantReportData localFileAssistantReportData = new FileManagerReporter.FileAssistantReportData();
      localFileAssistantReportData.b = "file_viewer_in";
      localFileAssistantReportData.c = 73;
      if (paramFileManagerEntity.nFileType == 13) {
        localFileAssistantReportData.d = "tencentdoc_ext";
      } else {
        localFileAssistantReportData.d = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getExtension(paramFileManagerEntity.fileName);
      }
      localFileAssistantReportData.e = paramFileManagerEntity.fileSize;
      FileManagerReporter.a(this.D.getCurrentAccountUin(), localFileAssistantReportData);
      FileManagerReporter.a("0X8004AE4");
      paramBoolean = this instanceof QfileRecentAllFileTabView;
      boolean bool = this instanceof QfileRecentTencentDocFileTabView;
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).openRencentFileBrowserOnItemClick(this.D, this.C, paramFileManagerEntity, this.C.F(), this.b, paramView, paramBoolean, bool);
    }
    a(B(), paramFileManagerEntity);
  }
  
  public void a(ArrayList<FileManagerEntity> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    int i1 = 0;
    while (i1 < paramArrayList.size())
    {
      c((FileManagerEntity)paramArrayList.get(i1));
      i1 += 1;
    }
  }
  
  protected void a(List<FileManagerEntity> paramList)
  {
    if (paramList == null) {
      return;
    }
    Object localObject = this.k;
    if (localObject != null) {
      ((List)localObject).clear();
    }
    if (this.k == null) {
      this.k = new ArrayList();
    }
    if ((this.C != null) && (this.C.q()) && (this.C.G())) {
      paramList = paramList.iterator();
    }
    while (paramList.hasNext())
    {
      localObject = (FileManagerEntity)paramList.next();
      if (!((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).isUndownloadDatalineEntity((FileManagerEntity)localObject))
      {
        this.k.add(localObject);
        continue;
        this.k.addAll(paramList);
      }
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b()
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Thread id: ");
      localStringBuilder.append(Thread.currentThread().getId());
      localStringBuilder.append(" onDestroy");
      QLog.e("crashBUG", 1, localStringBuilder.toString());
    }
    this.k.clear();
    this.c.clear();
    x();
    if (this.x != null) {
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).deleteObserver(this.x);
    }
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).removeDatalineObserver();
  }
  
  public boolean b(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      return false;
    }
    return d(paramFileManagerEntity);
  }
  
  abstract void c(FileManagerEntity paramFileManagerEntity);
  
  public void ci_()
  {
    Object localObject = this.k;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      getRecentFileRecords();
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
  
  protected boolean d(FileManagerEntity paramFileManagerEntity)
  {
    synchronized (this.k)
    {
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Thread id: ");
        ((StringBuilder)localObject).append(Thread.currentThread().getId());
        ((StringBuilder)localObject).append(" delRecent");
        QLog.e("crashBUG", 1, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.k.iterator();
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
  
  void e()
  {
    try
    {
      boolean bool = this.p;
      if (bool) {
        return;
      }
      this.p = true;
      if (QLog.isColorLevel()) {
        QLog.i(a, 2, "queryFileEntitiesFromDB");
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
  
  protected void e(FileManagerEntity paramFileManagerEntity)
  {
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).forwardFile(this.C, paramFileManagerEntity);
  }
  
  protected void f()
  {
    Object localObject = this.c;
    if ((localObject != null) && (((LinkedHashMap)localObject).size() != 0))
    {
      localObject = this.d;
      if (localObject != null)
      {
        ((NoFileRelativeLayout)localObject).setGone();
        this.h.removeHeaderView(this.d);
        this.h.setEnabled(true);
        if (p())
        {
          localObject = TencentDocImportFileInfoProcessor.a().a();
          if (TextUtils.isEmpty((CharSequence)localObject))
          {
            this.f.setVisibility(8);
          }
          else
          {
            this.f.setVisibility(0);
            this.g.setText((CharSequence)localObject);
          }
        }
        else
        {
          this.f.setVisibility(8);
        }
      }
    }
    else
    {
      if (this.C.J()) {
        this.d.setTopViewHeight(0.2F);
      }
      this.d.setVisible(true);
      if ((this instanceof QfileRecentTencentDocFileTabView))
      {
        this.d.a();
        ReportController.b(this.D, "dc00898", "", "", "0X800A225", "0X800A225", 0, 0, "", "", "", "");
      }
      else if ((this instanceof QfileRecentTDocFileTabView))
      {
        this.d.a();
        ReportController.b(this.D, "dc00898", "", "", "0X800A08B", "0X800A08B", 0, 0, "", "", "", "");
      }
      else
      {
        this.d.b();
      }
      this.h.setEnabled(false);
      this.f.setVisibility(8);
    }
    g();
    this.l.notifyDataSetChanged();
  }
  
  protected void g()
  {
    int i1 = this.h.getMeasuredHeight();
    Object localObject1 = a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("================================================================> 高度为");
    ((StringBuilder)localObject2).append(i1);
    QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    localObject1 = this.d;
    if (localObject1 != null)
    {
      ((NoFileRelativeLayout)localObject1).setLayoutParams(this.h.getWidth(), i1);
      localObject1 = this.d.findViewById(2131447757);
      localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).height = 0;
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
  }
  
  public int getFootHeight()
  {
    return 0;
  }
  
  public ListView getListView()
  {
    return this.h;
  }
  
  protected abstract QfileBaseExpandableListAdapter getQfileRecentFileBaseExpandableListAdapter();
  
  abstract void getRecentFileRecords();
  
  public View getScrollableView()
  {
    return this.h;
  }
  
  public void i()
  {
    a(new QfileBaseRecentFileTabView.8(this));
  }
  
  public void j()
  {
    this.C.b(this.C.D());
  }
  
  public void n()
  {
    e();
    this.C.b(this.C.D());
    i();
  }
  
  public void setAttribution(int paramInt)
  {
    this.w = paramInt;
  }
  
  public void setSelect(int paramInt)
  {
    if (this.l.getGroupCount() <= paramInt)
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSelect[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("] faild,becouse GroupCount[");
      localStringBuilder.append(this.l.getGroupCount());
      localStringBuilder.append("]");
      QLog.e(str, 1, localStringBuilder.toString());
      return;
    }
    a(new QfileBaseRecentFileTabView.9(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView
 * JD-Core Version:    0.7.0.1
 */