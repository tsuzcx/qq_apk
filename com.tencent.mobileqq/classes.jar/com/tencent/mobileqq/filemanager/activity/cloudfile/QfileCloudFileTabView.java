package com.tencent.mobileqq.filemanager.activity.cloudfile;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.ImageHolder;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileWeiYunImageExpandableListAdapter;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.IClickListenerVer51;
import com.tencent.mobileqq.filemanager.util.IReportVer51;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView.OnSelectListener;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class QfileCloudFileTabView
  extends QfileBaseCloudFileTabView
{
  boolean A = false;
  QfilePinnedHeaderExpandableListView.OnSelectListener B = new QfileCloudFileTabView.6(this);
  private boolean K;
  private boolean L = false;
  private IClickListenerVer51 M = null;
  private boolean N = false;
  private int O;
  private View.OnClickListener P = new QfileCloudFileTabView.8(this);
  private View.OnClickListener Q = new QfileCloudFileTabView.9(this);
  FMObserver v = null;
  final int w = 15;
  int x = 0;
  String y;
  QfileCloudFileTabView.IWeiYunImageEvent z = null;
  
  public QfileCloudFileTabView(Context paramContext, String paramString, int paramInt)
  {
    super(paramContext);
    this.O = paramInt;
    a(paramString);
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    paramView = (WeiYunFileInfo)((ImageHolder)paramView.getTag()).i;
    if (paramBoolean)
    {
      if (FMDataCache.a(paramView))
      {
        FMDataCache.c(paramView);
      }
      else
      {
        FMDataCache.b(paramView);
        this.C.h(true);
        if ((this.C.I()) && (!FMDataCache.c(FMDataCache.b)))
        {
          paramView = DialogUtil.a(this.C, 2131896125);
          paramView.setPositiveButton(2131917392, new DialogUtil.DialogOnClickAdapter());
          paramView.show();
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
      if (B()) {
        ReportController.b(this.D, "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
      }
      w();
      FileManagerReporter.a("0X8004AE6");
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).openWeiYunFileBrowser(this.C, c(paramView), paramView);
    }
    b(B());
  }
  
  private void a(String paramString)
  {
    this.a = paramString;
    if (this.v == null) {
      l();
    }
    if (this.z == null) {
      k();
    }
    a(false);
  }
  
  private boolean a(WeiYunFileInfo paramWeiYunFileInfo, boolean paramBoolean)
  {
    if (paramWeiYunFileInfo == null) {
      return false;
    }
    if (QQFileManagerUtil.k(((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getExtension(paramWeiYunFileInfo.c)) != 0) {
      return false;
    }
    if ((B()) && (((FMDataCache.a(paramWeiYunFileInfo)) && (paramBoolean)) || ((!FMDataCache.a(paramWeiYunFileInfo)) && (!paramBoolean)))) {
      return false;
    }
    if (B()) {
      if (paramBoolean) {
        FMDataCache.b(paramWeiYunFileInfo);
      } else {
        FMDataCache.c(paramWeiYunFileInfo);
      }
    }
    return true;
  }
  
  private void p()
  {
    if (this.M == null) {
      this.M = new QfileCloudFileTabView.1(this);
    }
    if (this.a.equalsIgnoreCase("document") == true)
    {
      if (this.C.q()) {
        this.C.A().s();
      } else {
        this.C.A().x();
      }
    }
    else if (this.a.equalsIgnoreCase("picture") == true)
    {
      if (this.C.q()) {
        this.C.A().t();
      } else {
        this.C.A().y();
      }
    }
    else if (this.a.equalsIgnoreCase("video") == true)
    {
      if (this.C.q()) {
        this.C.A().u();
      } else {
        this.C.A().z();
      }
    }
    else if (this.a.equalsIgnoreCase("music") == true)
    {
      if (this.C.q()) {
        this.C.A().v();
      } else {
        this.C.A().A();
      }
    }
    else if (this.a.equalsIgnoreCase("other") == true) {
      if (this.C.q()) {
        this.C.A().w();
      } else {
        this.C.A().B();
      }
    }
    this.C.a(this.M);
  }
  
  protected void a(boolean paramBoolean)
  {
    this.N = paramBoolean;
    ((IQQFileEngine)this.D.getRuntimeService(IQQFileEngine.class)).queryWeiyunFileList(this.O, this.a, 0, 15, this.y);
  }
  
  protected boolean a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    if (!this.i.contains(paramWeiYunFileInfo)) {
      return false;
    }
    this.i.remove(paramWeiYunFileInfo);
    String str = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getHistoryGroupByTime(paramWeiYunFileInfo.e);
    if (!this.b.containsKey(str))
    {
      QLog.e(c, 1, "delRecentFileRecords, fileEntities find, but recentRecords not find!");
      return false;
    }
    ((List)this.b.get(str)).remove(paramWeiYunFileInfo);
    if (((List)this.b.get(str)).size() == 0) {
      this.b.remove(str);
    }
    i();
    return true;
  }
  
  public boolean e()
  {
    return this.K;
  }
  
  protected QfileBaseExpandableListAdapter getQfileRecentFileBaseExpandableListAdapter()
  {
    if (this.a.equalsIgnoreCase("picture") == true)
    {
      setEditbarButton(true, true, false, true, true);
      return new QfileWeiYunImageExpandableListAdapter(this.z, getActivity(), this.b, this.n, this.P, this.Q, this.s, this.u);
    }
    setEditbarButton(false, true, false, true, true);
    return new QfileCloudFileBaseExpandableListAdapter(getActivity(), this.b, getActivity(), this.n, this.t, this.s, this.u);
  }
  
  protected void getRecentFileRecords()
  {
    a(new QfileCloudFileTabView.4(this));
  }
  
  protected void h()
  {
    this.N = false;
    if (!NetworkUtil.isNetworkAvailable(getActivity()))
    {
      FMToastUtil.a(2131889577);
      return;
    }
    this.A = false;
    ((IQQFileEngine)this.D.getRuntimeService(IQQFileEngine.class)).queryWeiyunFileList(this.O, this.a, this.x * 15, 15, this.y);
    f();
  }
  
  public void j()
  {
    super.j();
    if (this.a.equalsIgnoreCase("picture") == true)
    {
      setEditbarButton(true, true, false, true, true);
      p();
      this.f.setOnIndexChangedListener(this.B);
      return;
    }
    setEditbarButton(false, true, false, true, true);
    p();
  }
  
  void k()
  {
    this.z = new QfileCloudFileTabView.2(this);
  }
  
  void l()
  {
    if (this.v != null) {
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).deleteObserver(this.v);
    }
    this.v = new QfileCloudFileTabView.3(this);
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).addObserver(this.v);
  }
  
  public void m()
  {
    super.m();
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).deleteObserver(this.v);
  }
  
  public void n()
  {
    super.n();
    l();
    if (this.L) {
      i();
    }
  }
  
  public void o()
  {
    this.C.runOnUiThread(new QfileCloudFileTabView.7(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView
 * JD-Core Version:    0.7.0.1
 */