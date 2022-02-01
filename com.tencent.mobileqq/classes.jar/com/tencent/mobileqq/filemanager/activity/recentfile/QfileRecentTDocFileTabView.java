package com.tencent.mobileqq.filemanager.activity.recentfile;

import android.content.Context;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.IClickListenerVer51;
import com.tencent.mobileqq.filemanager.util.IReportVer51;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class QfileRecentTDocFileTabView
  extends QfileBaseRecentFileTabView
{
  private IClickListenerVer51 w = null;
  
  public QfileRecentTDocFileTabView(Context paramContext)
  {
    super(paramContext);
    e();
    setEditbarButton(false, true, true, true, true);
  }
  
  public QfileRecentTDocFileTabView(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    e();
    setEditbarButton(false, true, true, true, true);
  }
  
  private void h()
  {
    if (this.C.q()) {
      this.C.A().G();
    } else {
      this.C.A().L();
    }
    if (this.w != null)
    {
      this.C.a(this.w);
      return;
    }
    this.w = new QfileRecentTDocFileTabView.2(this);
    this.C.a(this.w);
  }
  
  void c(FileManagerEntity paramFileManagerEntity)
  {
    if (!this.k.contains(paramFileManagerEntity))
    {
      if ((this.b != null) && (this.b.trim().length() != 0) && (!this.b.equals(paramFileManagerEntity.peerUin))) {
        return;
      }
      this.k.add(paramFileManagerEntity);
      Collections.sort(this.k, this.q);
    }
    a(new QfileRecentTDocFileTabView.1(this, paramFileManagerEntity));
  }
  
  protected QfileBaseExpandableListAdapter getQfileRecentFileBaseExpandableListAdapter()
  {
    return new QfileRecentFileBaseExpandableListAdapter(getActivity(), this.c, getActivity(), this.s, this.u, this.t, this.v);
  }
  
  void getRecentFileRecords()
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
      if ((!localFileManagerEntity.bDelInFM) && (localFileManagerEntity.nFileType == 13))
      {
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
  
  public void j()
  {
    super.j();
    this.C.h(true);
    setEditbarButton(false, true, true, true, true);
    h();
  }
  
  public void m()
  {
    super.m();
    this.C.h(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentTDocFileTabView
 * JD-Core Version:    0.7.0.1
 */