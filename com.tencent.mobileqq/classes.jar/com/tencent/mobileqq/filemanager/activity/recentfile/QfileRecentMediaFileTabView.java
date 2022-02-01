package com.tencent.mobileqq.filemanager.activity.recentfile;

import android.content.Context;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.IClickListenerVer51;
import com.tencent.mobileqq.filemanager.util.IReportVer51;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class QfileRecentMediaFileTabView
  extends QfileBaseRecentFileTabView
{
  private IClickListenerVer51 w = null;
  
  public QfileRecentMediaFileTabView(Context paramContext)
  {
    super(paramContext);
    e();
    setEditbarButton(false, true, true, true, true);
  }
  
  public QfileRecentMediaFileTabView(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    e();
    setEditbarButton(false, true, true, true, true);
  }
  
  private String a(String paramString)
  {
    int i = QQFileManagerUtil.k(paramString);
    if (i != 1)
    {
      if (i != 2) {
        return null;
      }
      return HardCodeUtil.a(2131889612);
    }
    return HardCodeUtil.a(2131889607);
  }
  
  private void h()
  {
    if (this.C.q()) {
      this.C.A().I();
    } else {
      this.C.A().N();
    }
    if (this.w != null)
    {
      this.C.a(this.w);
      return;
    }
    this.w = new QfileRecentMediaFileTabView.1(this);
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
    String str = a(paramFileManagerEntity.fileName);
    if (str == null) {
      return;
    }
    a(new QfileRecentMediaFileTabView.2(this, str, paramFileManagerEntity));
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
    Object localObject = a(paramFileManagerEntity.fileName);
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
      if ((!localFileManagerEntity.bDelInFM) && (((!this.C.m) && (localFileManagerEntity.peerType != 10014)) || (QQFileManagerUtil.v(localFileManagerEntity.getFilePath()))))
      {
        String str = a(localFileManagerEntity.fileName);
        if (str != null)
        {
          if (!this.c.containsKey(str)) {
            this.c.put(str, new ArrayList());
          }
          ((List)this.c.get(str)).add(localFileManagerEntity);
        }
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
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentMediaFileTabView
 * JD-Core Version:    0.7.0.1
 */