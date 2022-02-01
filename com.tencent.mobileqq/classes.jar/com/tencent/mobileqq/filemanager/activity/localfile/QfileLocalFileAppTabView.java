package com.tencent.mobileqq.filemanager.activity.localfile;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.IReportVer51;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView.ScanParams;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class QfileLocalFileAppTabView
  extends QfileBaseLocalFileTabView
{
  protected LinkedHashMap<String, List<FileInfo>> a = new LinkedHashMap();
  private boolean b = false;
  private boolean c = false;
  
  public QfileLocalFileAppTabView(Context paramContext, List<QfileTabBarView.ScanParams> paramList, boolean paramBoolean)
  {
    super(paramContext, paramList, paramBoolean);
    setEditbarButton(false, false, true, true, false);
  }
  
  private void a(FileInfo paramFileInfo)
  {
    if (!this.v.contains(paramFileInfo)) {
      this.v.add(paramFileInfo);
    }
    String str = paramFileInfo.a();
    if (str != null)
    {
      localObject = str;
      if (str.length() != 0) {}
    }
    else
    {
      localObject = HardCodeUtil.a(2131889355);
    }
    if (!this.a.containsKey(localObject)) {
      this.a.put(localObject, new ArrayList());
    }
    Object localObject = (List)this.a.get(localObject);
    if (((List)localObject).contains(paramFileInfo) == true) {
      return;
    }
    int j = a((List)localObject, paramFileInfo.g());
    int i = j;
    if (j < 0) {
      i = 0;
    }
    ((List)localObject).add(i, paramFileInfo);
  }
  
  private void o()
  {
    this.a.clear();
    if (this.n) {
      this.a.put(HardCodeUtil.a(2131889277), new ArrayList());
    }
    this.a.put(HardCodeUtil.a(2131889355), new ArrayList());
    this.C.a(this);
    this.J = new QfileLocalFileAppTabView.2(this);
    ThreadManagerV2.excute(this.J, 64, null, true);
  }
  
  public void a(Set<FileInfo> paramSet)
  {
    if (paramSet != null)
    {
      if (paramSet.size() == 0) {
        return;
      }
      paramSet = paramSet.iterator();
      while (paramSet.hasNext()) {
        e((FileInfo)paramSet.next());
      }
    }
  }
  
  protected void d(FileInfo paramFileInfo)
  {
    Thread localThread = Thread.currentThread();
    Looper localLooper = Looper.getMainLooper();
    if (localLooper.getThread() != localThread)
    {
      new Handler(localLooper).post(new QfileLocalFileAppTabView.3(this, paramFileInfo));
      return;
    }
    a(paramFileInfo);
  }
  
  protected boolean e(FileInfo paramFileInfo)
  {
    String str = paramFileInfo.a();
    if (!this.l.containsKey(str))
    {
      QLog.e(o, 1, "delRecentFileRecords, fileEntities find, but recentRecords not find!");
      return false;
    }
    ((List)this.l.get(str)).remove(paramFileInfo);
    i();
    return true;
  }
  
  protected boolean getAccessAppListPermission()
  {
    if (this.c) {
      return this.b;
    }
    this.b = this.C.getSharedPreferences("qfile_permission", 0).getBoolean("qfile_permission_access_apps", false);
    this.c = true;
    return this.b;
  }
  
  protected void getFileRecordsFromLocal()
  {
    this.v.clear();
    getRecentFileRecords();
  }
  
  protected QfileBaseExpandableListAdapter getQfileRecentFileBaseExpandableListAdapter()
  {
    return new QfileLocalFileBaseExpandableListAdapter(getActivity(), this.l, getActivity(), this.y, this.B, this.A, this.K);
  }
  
  protected void getRecentFileRecords()
  {
    ThreadManagerV2.executeOnSubThread(new QfileLocalFileAppTabView.1(this));
  }
  
  public void j()
  {
    super.j();
    setEditbarButton(false, false, true, true, false);
    if (!this.C.K()) {
      if (this.C.q()) {
        this.C.A().P();
      } else {
        this.C.A().U();
      }
    }
    k();
  }
  
  protected void setAccessAppListPermission(boolean paramBoolean)
  {
    this.b = paramBoolean;
    this.c = true;
    ThreadManagerV2.executeOnSubThread(new QfileLocalFileAppTabView.4(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileAppTabView
 * JD-Core Version:    0.7.0.1
 */