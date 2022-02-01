package com.tencent.mobileqq.filemanager.activity.cloudfile;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileWeiYunImageExpandableListAdapter;
import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.api.IFileManagerReporter;
import com.tencent.mobileqq.filemanager.api.IQQFileDataCenter;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.recreate.FileModel;
import com.tencent.mobileqq.filemanager.recreate.IFModel;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.filemanager.widget.ViewerMoreRelativeLayout;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public abstract class QfileBaseCloudFileTabView
  extends QfileBaseTabView
{
  static String c = "QfileRecentFileActivity<FileAssistant>";
  public String a = null;
  protected LinkedHashMap<String, List<WeiYunFileInfo>> b = null;
  public ViewerMoreRelativeLayout d;
  NoFileRelativeLayout e = null;
  QfilePinnedHeaderExpandableListView f;
  long g = -1L;
  LayoutInflater h = null;
  protected ArrayList<WeiYunFileInfo> i = null;
  protected QfileBaseExpandableListAdapter j = null;
  int k = 0;
  volatile boolean l = false;
  BubblePopupWindow m = null;
  public View.OnClickListener n = new QfileBaseCloudFileTabView.5(this);
  public View.OnClickListener o = new QfileBaseCloudFileTabView.9(this);
  TextView p;
  Drawable q;
  boolean r;
  public View.OnLongClickListener s = new QfileBaseCloudFileTabView.10(this);
  public View.OnClickListener t = new QfileBaseCloudFileTabView.11(this);
  public View.OnClickListener u = new QfileBaseCloudFileTabView.12(this);
  private PullRefreshHeader v = null;
  private FMObserver w = new QfileBaseCloudFileTabView.14(this);
  
  public QfileBaseCloudFileTabView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(WeiYunFileInfo paramWeiYunFileInfo, FMDialogUtil.FMDialogInterface paramFMDialogInterface)
  {
    if ((paramWeiYunFileInfo.d > ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize()) && (QQFileManagerUtil.h()))
    {
      QQFileManagerUtil.a(false, this.C, paramFMDialogInterface);
      return;
    }
    paramFMDialogInterface.a();
  }
  
  private void c(FileManagerEntity paramFileManagerEntity)
  {
    FileModel.a(paramFileManagerEntity).a(false, this.C, new QfileBaseCloudFileTabView.13(this, paramFileManagerEntity));
  }
  
  private void d(WeiYunFileInfo paramWeiYunFileInfo)
  {
    paramWeiYunFileInfo = QQFileManagerUtil.a(paramWeiYunFileInfo);
    ((IQQFileEngine)this.D.getRuntimeService(IQQFileEngine.class)).reciveFile(paramWeiYunFileInfo);
    ((IQQFileDataCenter)this.D.getRuntimeService(IQQFileDataCenter.class)).insertToFMList(paramWeiYunFileInfo);
    a(paramWeiYunFileInfo);
  }
  
  private void k()
  {
    this.f = ((QfilePinnedHeaderExpandableListView)findViewById(2131433125));
    this.f.setSelection(0);
    this.f.setFocusable(false);
  }
  
  private void o()
  {
    try
    {
      this.e = new NoFileRelativeLayout(getActivity());
      this.f.addHeaderView(this.e);
      this.d = new ViewerMoreRelativeLayout(getActivity());
      this.d.setOnClickListener(this.o);
      this.d.setGone();
      this.p = ((TextView)this.d.findViewById(2131449882));
      this.f.addFooterView(this.d);
      ch_();
      this.e.setText(2131889274);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a()
  {
    setContentView(2131627054);
    this.h = LayoutInflater.from(getActivity());
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).addObserver(this.w);
    k();
    this.j = getQfileRecentFileBaseExpandableListAdapter();
    this.j.a(this.f);
    o();
    if ((this.j instanceof QfileWeiYunImageExpandableListAdapter))
    {
      this.f.setSelector(2131168376);
      this.f.setAdapter(this.j);
      this.f.setTranscriptMode(0);
      this.f.setWhetherImageTab(true);
      this.f.setGridSize(((QfileWeiYunImageExpandableListAdapter)this.j).a());
      i1 = 0;
      while (i1 < this.j.getGroupCount())
      {
        this.f.expandGroup(i1);
        i1 += 1;
      }
    }
    this.f.setOnGroupExpandListener(new QfileBaseCloudFileTabView.1(this));
    this.f.setOnGroupCollapseListener(new QfileBaseCloudFileTabView.2(this));
    this.f.setSelector(2131168376);
    this.f.setAdapter(this.j);
    this.f.setTranscriptMode(0);
    this.f.setWhetherImageTab(false);
    int i1 = 0;
    while (i1 < this.j.getGroupCount())
    {
      this.f.expandGroup(i1);
      i1 += 1;
    }
    this.f.smoothScrollToPosition(0);
    this.f.setStackFromBottom(false);
    this.f.setTranscriptMode(0);
    if ((this.j instanceof QfileWeiYunImageExpandableListAdapter))
    {
      this.f.getViewTreeObserver().addOnGlobalLayoutListener(new QfileBaseCloudFileTabView.3(this));
      if (this.d == null) {
        this.d = new ViewerMoreRelativeLayout(getContext());
      }
      this.p = ((TextView)this.d.findViewById(2131449882));
      this.d.setOnClickListener(this.o);
      this.d.setGone();
      return;
    }
    this.f.getViewTreeObserver().addOnGlobalLayoutListener(new QfileBaseCloudFileTabView.4(this));
  }
  
  public void a(WeiYunFileInfo paramWeiYunFileInfo, int paramInt, boolean paramBoolean)
  {
    if ((B()) && (!paramBoolean))
    {
      if (FMDataCache.a(paramWeiYunFileInfo))
      {
        FMDataCache.c(paramWeiYunFileInfo);
      }
      else
      {
        FMDataCache.b(paramWeiYunFileInfo);
        this.C.h(true);
        if ((this.C.I()) && (!FMDataCache.c(FMDataCache.b)))
        {
          paramWeiYunFileInfo = DialogUtil.a(this.C, 2131896125);
          paramWeiYunFileInfo.setPositiveButton(2131917392, new DialogUtil.DialogOnClickAdapter());
          paramWeiYunFileInfo.show();
          FMDataCache.b(FMDataCache.b);
          FileManagerReporter.a("0X800942F");
        }
      }
      C();
      cg_();
    }
    else
    {
      if (!v())
      {
        if (QLog.isColorLevel()) {
          QLog.i(c, 2, "click too fast , wait a minute.");
        }
        return;
      }
      w();
      ((IFileManagerReporter)QRoute.api(IFileManagerReporter.class)).addData("0X8004AE6");
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).openWeiYunFileBrowser(this.C, c(paramWeiYunFileInfo), paramWeiYunFileInfo);
    }
    b(B());
  }
  
  protected abstract void a(boolean paramBoolean);
  
  protected abstract boolean a(WeiYunFileInfo paramWeiYunFileInfo);
  
  public void b()
  {
    super.b();
    m();
    this.i.clear();
    this.b.clear();
    x();
    if (this.w != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(c, 2, "onDestroy, del fmObserver");
      }
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).deleteObserver(this.w);
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    String str;
    if ((this.C.J()) && (!paramBoolean))
    {
      if ("document".equals(this.a)) {
        str = "0X8009E6E";
      } else if ("picture".equals(this.a)) {
        str = "0X8009E6F";
      } else if ("video".equals(this.a)) {
        str = "0X8009E70";
      } else if ("music".equals(this.a)) {
        str = "0X8009E71";
      } else {
        str = "0X8009E72";
      }
    }
    else if (!this.C.J())
    {
      if ("document".equals(this.a)) {
        str = "0X8009E61";
      } else if ("picture".equals(this.a)) {
        str = "0X8009E62";
      } else if ("video".equals(this.a)) {
        str = "0X8009E63";
      } else if ("music".equals(this.a)) {
        str = "0X8009E64";
      } else {
        str = "0X8009E65";
      }
    }
    else {
      str = "";
    }
    if (!TextUtils.isEmpty(str)) {
      ReportController.b(this.D, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
    }
  }
  
  public boolean b(WeiYunFileInfo paramWeiYunFileInfo)
  {
    if (paramWeiYunFileInfo == null) {
      return false;
    }
    return a(paramWeiYunFileInfo);
  }
  
  protected ArrayList<WeiYunFileInfo> c(WeiYunFileInfo paramWeiYunFileInfo)
  {
    if (this.i.size() <= 250) {
      return this.i;
    }
    int i3 = this.i.indexOf(paramWeiYunFileInfo);
    int i2 = 0;
    int i1 = i3;
    if (i3 == -1)
    {
      if (QLog.isColorLevel())
      {
        String str = c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("can not find the clicked weiYunFileInfo. targetInfo fileId[");
        localStringBuilder.append(paramWeiYunFileInfo.a);
        localStringBuilder.append("]");
        QLog.i(str, 1, localStringBuilder.toString());
      }
      i1 = 0;
    }
    if (i1 >= 100) {
      i2 = i1 - 100;
    }
    int i4 = this.i.size();
    i3 = i1 + 100;
    i1 = i3;
    if (i4 - 1 < i3) {
      i1 = this.i.size() - 1;
    }
    return new ArrayList(this.i.subList(i2, i1));
  }
  
  public void c(boolean paramBoolean) {}
  
  protected void cg_()
  {
    Object localObject = this.b;
    if (((localObject == null) || (((LinkedHashMap)localObject).size() == 0)) && (e()))
    {
      if (this.C.J()) {
        this.e.setTopViewHeight(0.5F);
      }
      this.e.setText(2131889282);
      this.e.setVisible(true);
      this.d.setGone();
    }
    else
    {
      localObject = this.e;
      if (localObject != null)
      {
        ((NoFileRelativeLayout)localObject).setGone();
        this.f.removeHeaderView(this.e);
      }
    }
    this.j.notifyDataSetChanged();
  }
  
  protected void ch_()
  {
    int i1 = this.C.getWindow().getDecorView().getHeight() / 2;
    this.e.setLayoutParams(this.f.getWidth(), i1);
  }
  
  public abstract boolean e();
  
  protected void f()
  {
    if ((this.p != null) && (this.q == null))
    {
      this.q = getResources().getDrawable(2130839585);
      this.p.setCompoundDrawablesWithIntrinsicBounds(this.q, null, null, null);
      ((Animatable)this.q).start();
    }
  }
  
  protected void g()
  {
    this.r = false;
    if (this.p != null)
    {
      Drawable localDrawable = this.q;
      if (localDrawable != null)
      {
        ((Animatable)localDrawable).stop();
        this.q = null;
        this.p.setCompoundDrawables(null, null, null, null);
      }
    }
  }
  
  public int getFootHeight()
  {
    return this.d.getHeight();
  }
  
  public ListView getListView()
  {
    return this.f;
  }
  
  protected abstract QfileBaseExpandableListAdapter getQfileRecentFileBaseExpandableListAdapter();
  
  protected abstract void getRecentFileRecords();
  
  protected void h() {}
  
  public void i()
  {
    a(new QfileBaseCloudFileTabView.15(this));
  }
  
  public void j()
  {
    if (this.b.size() > 0) {
      cg_();
    }
    this.C.h(false);
    this.C.b(this.C.D());
  }
  
  public void setListFooter()
  {
    QfileBaseExpandableListAdapter localQfileBaseExpandableListAdapter = this.j;
    if ((localQfileBaseExpandableListAdapter instanceof QfileWeiYunImageExpandableListAdapter)) {
      return;
    }
    if ((localQfileBaseExpandableListAdapter.getGroupCount() > 0) && (this.f.isGroupExpanded(this.j.getGroupCount() - 1)) && (this.d != null))
    {
      if (!e())
      {
        this.d.setVisible();
        return;
      }
      this.d.setGone();
    }
  }
  
  public void setSelect(int paramInt)
  {
    if (this.j.getGroupCount() <= paramInt)
    {
      if (QLog.isColorLevel())
      {
        String str = c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setSelect[");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("] faild,becouse GroupCount[");
        localStringBuilder.append(this.j.getGroupCount());
        localStringBuilder.append("]");
        QLog.e(str, 1, localStringBuilder.toString());
      }
      return;
    }
    a(new QfileBaseCloudFileTabView.16(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView
 * JD-Core Version:    0.7.0.1
 */