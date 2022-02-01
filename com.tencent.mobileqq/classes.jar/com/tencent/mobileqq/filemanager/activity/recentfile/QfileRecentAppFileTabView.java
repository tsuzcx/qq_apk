package com.tencent.mobileqq.filemanager.activity.recentfile;

import android.content.Context;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.IClickListenerVer51;
import com.tencent.mobileqq.filemanager.util.IReportVer51;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class QfileRecentAppFileTabView
  extends QfileBaseRecentFileTabView
{
  private IClickListenerVer51 w = null;
  
  public QfileRecentAppFileTabView(Context paramContext)
  {
    super(paramContext);
    e();
    setEditbarButton(false, true, true, true, true);
  }
  
  public QfileRecentAppFileTabView(Context paramContext, String paramString)
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
    this.w = new QfileRecentAppFileTabView.1(this);
    this.C.a(this.w);
  }
  
  protected void c(FileManagerEntity paramFileManagerEntity)
  {
    if (!this.k.contains(paramFileManagerEntity))
    {
      if ((this.b != null) && (this.b.trim().length() != 0) && (!this.b.equals(paramFileManagerEntity.peerUin))) {
        return;
      }
      this.k.add(paramFileManagerEntity);
      Collections.sort(this.k, this.q);
    }
    if (paramFileManagerEntity.nFileType != 5) {
      return;
    }
    a(new QfileRecentAppFileTabView.2(this, paramFileManagerEntity));
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
    return new QfileRecentFileBaseExpandableListAdapter(getActivity(), this.c, getActivity(), this.s, this.u, this.t, this.v);
  }
  
  protected void getRecentFileRecords()
  {
    this.c.clear();
    Iterator localIterator = this.k.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if ((!localFileManagerEntity.bDelInFM) && (localFileManagerEntity.nFileType == 5) && (((!this.C.m) && (localFileManagerEntity.peerType != 10014)) || (QQFileManagerUtil.v(localFileManagerEntity.getFilePath()))))
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
    setEditbarButton(false, true, true, true, true);
    h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentAppFileTabView
 * JD-Core Version:    0.7.0.1
 */