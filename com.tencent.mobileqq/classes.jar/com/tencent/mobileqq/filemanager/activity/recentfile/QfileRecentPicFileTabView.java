package com.tencent.mobileqq.filemanager.activity.recentfile;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.ImageHolder;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileRecentImageExpandableListAdapter;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.FileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.IClickListenerVer51;
import com.tencent.mobileqq.filemanager.util.IReportVer51;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView.OnSelectListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class QfileRecentPicFileTabView
  extends QfileBaseRecentFileTabView
{
  private View.OnClickListener A = new QfileRecentPicFileTabView.7(this);
  QfilePinnedHeaderExpandableListView.OnSelectListener w = new QfileRecentPicFileTabView.4(this);
  private IClickListenerVer51 x = null;
  private FMObserver y = null;
  private View.OnClickListener z = new QfileRecentPicFileTabView.6(this);
  
  public QfileRecentPicFileTabView(Context paramContext)
  {
    super(paramContext);
    if (this.y == null) {
      k();
    }
    e();
    setEditbarButton(true, true, true, true, true);
  }
  
  public QfileRecentPicFileTabView(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    e();
    setEditbarButton(false, true, true, true, true);
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    Object localObject = (ImageHolder)paramView.getTag();
    paramView = (FileManagerEntity)((ImageHolder)localObject).i;
    localObject = ((ImageHolder)localObject).a;
    if (paramView == null) {
      return;
    }
    if (paramBoolean)
    {
      if (FMDataCache.a(paramView))
      {
        FMDataCache.c(paramView);
      }
      else
      {
        FMDataCache.b(paramView);
        if (f(paramView))
        {
          localObject = DialogUtil.a(this.C, 2131896123);
          ((QQCustomDialog)localObject).setPositiveButton(2131917392, new DialogUtil.DialogOnClickAdapter());
          ((QQCustomDialog)localObject).show();
          FMDataCache.b(FMDataCache.a);
          FileManagerReporter.a("0X800942D");
        }
      }
      if ((this.C.l) && (paramView.cloudType == 3) && (!FileUtils.fileExistsAndNotEmpty(paramView.getFilePath())))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(QQFileManagerUtil.b(paramView.fileName));
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131896095));
        FMToastUtil.a(((StringBuilder)localObject).toString());
        FMDataCache.c(paramView);
      }
      C();
      f();
      return;
    }
    if (B()) {
      ReportController.b(this.D, "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
    }
    if (!v())
    {
      if (QLog.isColorLevel()) {
        QLog.i(a, 2, "click too fast , wait a minute.");
      }
      return;
    }
    w();
    FileManagerReporter.FileAssistantReportData localFileAssistantReportData = new FileManagerReporter.FileAssistantReportData();
    localFileAssistantReportData.b = "file_viewer_in";
    localFileAssistantReportData.c = 73;
    localFileAssistantReportData.d = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getExtension(paramView.fileName);
    localFileAssistantReportData.e = paramView.fileSize;
    FileManagerReporter.a(this.D.getCurrentAccountUin(), localFileAssistantReportData);
    FileManagerReporter.a("0X8004AE4");
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).openRencentFileBrowserOnItemClick(this.D, this.C, paramView, this.C.F(), this.b, (View)localObject, false, false);
  }
  
  private boolean a(FileManagerEntity paramFileManagerEntity, boolean paramBoolean)
  {
    if (paramFileManagerEntity == null) {
      return false;
    }
    if (paramFileManagerEntity.nFileType != 0) {
      return false;
    }
    if ((B()) && (((FMDataCache.a(paramFileManagerEntity)) && (paramBoolean)) || ((!FMDataCache.a(paramFileManagerEntity)) && (!paramBoolean)))) {
      return false;
    }
    if (B()) {
      if (paramBoolean) {
        FMDataCache.b(paramFileManagerEntity);
      } else {
        FMDataCache.c(paramFileManagerEntity);
      }
    }
    return true;
  }
  
  private boolean f(FileManagerEntity paramFileManagerEntity)
  {
    return (this.C.I()) && (!FMDataCache.c(FMDataCache.a)) && (!FMDataCache.d(paramFileManagerEntity));
  }
  
  private void k()
  {
    this.y = new QfileRecentPicFileTabView.1(this);
  }
  
  private void o()
  {
    if (this.C.q()) {
      this.C.A().J();
    } else {
      this.C.A().O();
    }
    if (this.x != null)
    {
      this.C.a(this.x);
      return;
    }
    this.x = new QfileRecentPicFileTabView.2(this);
    this.C.a(this.x);
  }
  
  protected void c(FileManagerEntity paramFileManagerEntity)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Thread id: ");
      localStringBuilder.append(Thread.currentThread().getId());
      localStringBuilder.append(" refreshRecentFileRecords");
      QLog.e("crashBUG", 1, localStringBuilder.toString());
    }
    if (!this.k.contains(paramFileManagerEntity))
    {
      if ((this.b != null) && (this.b.trim().length() != 0) && (!this.b.equals(paramFileManagerEntity.peerUin))) {
        return;
      }
      this.k.add(paramFileManagerEntity);
      Collections.sort(this.k, this.q);
    }
    if (paramFileManagerEntity.nFileType != 0) {
      return;
    }
    a(new QfileRecentPicFileTabView.3(this, paramFileManagerEntity));
  }
  
  public void c(ArrayList<FileManagerEntity> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        d((FileManagerEntity)paramArrayList.next());
      }
    }
  }
  
  protected boolean d(FileManagerEntity paramFileManagerEntity)
  {
    Object localObject = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getHistoryGroupByTime(paramFileManagerEntity.srvTime);
    if (!this.c.containsKey(localObject))
    {
      QLog.e(a, 1, "delRecentFileRecords, fileEntities find, but recentRecords not find!");
      return false;
    }
    synchronized (this.c)
    {
      localObject = ((List)this.c.get(localObject)).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (paramFileManagerEntity == (FileManagerEntity)((Iterator)localObject).next()) {
          ((Iterator)localObject).remove();
        }
      }
      i();
      return true;
    }
    for (;;)
    {
      throw paramFileManagerEntity;
    }
  }
  
  protected QfileBaseExpandableListAdapter getQfileRecentFileBaseExpandableListAdapter()
  {
    return new QfileRecentImageExpandableListAdapter(getActivity(), this.c, this.s, this.z, this.A, this.t, this.v);
  }
  
  protected void getRecentFileRecords()
  {
    if (this.k == null) {
      return;
    }
    this.c.clear();
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Thread id: ");
      ((StringBuilder)localObject).append(Thread.currentThread().getId());
      QLog.e("crashBUG", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.k.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
      if ((!localFileManagerEntity.bDelInFM) && (localFileManagerEntity.nFileType == 0) && (((!this.C.m) && (localFileManagerEntity.peerType != 10014)) || (QQFileManagerUtil.v(localFileManagerEntity.getFilePath()))))
      {
        if ((!FileUtils.fileExistsAndNotEmpty(localFileManagerEntity.getFilePath())) && (!FileUtils.fileExistsAndNotEmpty(localFileManagerEntity.strThumbPath))) {
          if (localFileManagerEntity.getCloudType() == 1) {
            ((IQQFileEngine)this.D.getRuntimeService(IQQFileEngine.class)).downLoadDiscThumb(localFileManagerEntity, 7);
          } else if (localFileManagerEntity.getCloudType() == 2) {
            ((IQQFileEngine)this.D.getRuntimeService(IQQFileEngine.class)).getWeiYunPicThumb(localFileManagerEntity.WeiYunFileId, localFileManagerEntity.strLargeThumPath, 3, localFileManagerEntity);
          }
        }
        String str = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getHistoryGroupByTime(localFileManagerEntity.srvTime);
        if (!this.c.containsKey(str)) {
          this.c.put(str, new ArrayList());
        }
        ((List)this.c.get(str)).add(localFileManagerEntity);
      }
    }
    i();
    setSelect(0);
    a(true);
    this.p = false;
  }
  
  public void h()
  {
    this.C.runOnUiThread(new QfileRecentPicFileTabView.5(this));
  }
  
  public void j()
  {
    super.j();
    setEditbarButton(true, true, true, true, true);
    o();
    this.h.setOnIndexChangedListener(this.w);
  }
  
  public void m()
  {
    super.m();
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).deleteObserver(this.y);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentPicFileTabView
 * JD-Core Version:    0.7.0.1
 */