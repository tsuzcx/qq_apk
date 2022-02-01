package com.tencent.mobileqq.filemanager.activity.delDownloadFile;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter.IQfileViewBinder;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileDocTabView;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView.ScanParams;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class QfileLocalFileDelFileTabView
  extends QfileLocalFileDocTabView
  implements QfileBaseExpandableListAdapter.IQfileViewBinder
{
  LinkedHashMap<String, List<FileInfo>> a = new LinkedHashMap();
  LinkedHashMap<String, List<FileInfo>> b = new LinkedHashMap();
  List<FileInfo> c = new ArrayList();
  List<String> d = new ArrayList();
  Pair<String, Integer> e;
  int f = -1;
  boolean g = false;
  boolean h = false;
  int i = 0;
  final int j = 1000;
  List<FileInfo> k = new ArrayList();
  
  public QfileLocalFileDelFileTabView(Context paramContext, List<QfileTabBarView.ScanParams> paramList, Pair<String, Integer> paramPair)
  {
    super(paramContext, paramList, false);
    this.H = 1;
    this.e = paramPair;
    this.f = ((Integer)this.e.second).intValue();
    getRecentFileRecords();
  }
  
  private boolean f(FileInfo paramFileInfo)
  {
    Object localObject = this.l.keySet().iterator();
    String str;
    List localList;
    while (((Iterator)localObject).hasNext())
    {
      str = (String)((Iterator)localObject).next();
      localList = (List)this.l.get(str);
      if ((localList != null) && (localList.contains(paramFileInfo)))
      {
        localList.remove(paramFileInfo);
        if (localList.size() == 0) {
          this.l.remove(str);
        }
        bool2 = true;
        break label102;
      }
    }
    boolean bool2 = false;
    label102:
    this.c.remove(paramFileInfo);
    localObject = this.a.keySet().iterator();
    do
    {
      bool1 = bool2;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      str = (String)((Iterator)localObject).next();
      localList = (List)this.a.get(str);
    } while ((localList == null) || (!localList.contains(paramFileInfo)));
    localList.remove(paramFileInfo);
    if (localList.size() == 0) {
      this.a.remove(str);
    }
    boolean bool1 = true;
    localObject = this.b.keySet().iterator();
    do
    {
      bool2 = bool1;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      str = (String)((Iterator)localObject).next();
      localList = (List)this.b.get(str);
    } while ((localList == null) || (!localList.contains(paramFileInfo)));
    localList.remove(paramFileInfo);
    if (localList.size() == 0) {
      this.b.remove(str);
    }
    bool2 = true;
    try
    {
      localObject = a(paramFileInfo);
      paramFileInfo = new File((String)localObject);
      if (!paramFileInfo.exists())
      {
        paramFileInfo = "file not exists";
        if (QLog.isColorLevel())
        {
          paramFileInfo = new StringBuilder();
          paramFileInfo.append("file not exists");
          paramFileInfo.append(" : ");
          paramFileInfo.append((String)localObject);
          paramFileInfo = paramFileInfo.toString();
        }
        QLog.w("delDownloadFiles<FileAssistant>", 1, paramFileInfo);
        return bool2;
      }
      paramFileInfo.delete();
      return bool2;
    }
    catch (Exception paramFileInfo)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("del file error:");
      ((StringBuilder)localObject).append(paramFileInfo.toString());
      QLog.e("delDownloadFiles<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
    return bool2;
  }
  
  private int getReportType()
  {
    int m = this.f;
    if (m != 3)
    {
      if (m != 5)
      {
        if (m != 11) {
          return -1;
        }
        return 5;
      }
      return 4;
    }
    return 1;
  }
  
  public String a(FileInfo paramFileInfo)
  {
    if (paramFileInfo == null) {
      return "";
    }
    String str = paramFileInfo.d();
    if (paramFileInfo.j()) {}
    try
    {
      int m = Integer.parseInt(str);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)this.d.get(m));
      localStringBuilder.append(paramFileInfo.e());
      paramFileInfo = localStringBuilder.toString();
      return paramFileInfo;
    }
    catch (Exception paramFileInfo) {}
    return str;
    return str;
  }
  
  public void a(FileInfo paramFileInfo, boolean paramBoolean)
  {
    boolean bool = true;
    if (paramBoolean)
    {
      this.i += 1;
      this.k.add(paramFileInfo);
    }
    else
    {
      this.i -= 1;
      this.k.remove(paramFileInfo);
    }
    paramFileInfo = getActivity();
    int m = this.i;
    paramBoolean = bool;
    if (m != 0) {
      if (m < this.c.size()) {
        paramBoolean = bool;
      } else {
        paramBoolean = false;
      }
    }
    paramFileInfo.e(paramBoolean);
  }
  
  public void a(Set<FileInfo> paramSet)
  {
    if (this.k.size() == 0) {
      return;
    }
    Object localObject = this.k.iterator();
    long l2 = 0L;
    long l1 = 0L;
    while (((Iterator)localObject).hasNext())
    {
      FileInfo localFileInfo = (FileInfo)((Iterator)localObject).next();
      if (f(localFileInfo))
      {
        paramSet.remove(localFileInfo);
        l2 += localFileInfo.f();
        l1 += 1L;
      }
    }
    this.k.clear();
    i();
    l2 /= 1048576L;
    int m = getReportType();
    paramSet = new StringBuilder();
    paramSet.append("");
    paramSet.append(l1);
    paramSet = paramSet.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(l2);
    ReportController.b(null, "dc00898", "", "", "0X800A0CC", "0X800A0CC", m, 0, paramSet, ((StringBuilder)localObject).toString(), "", "");
  }
  
  protected void b(FileInfo paramFileInfo, boolean paramBoolean)
  {
    super.b(paramFileInfo, paramBoolean);
    a(paramFileInfo, paramBoolean);
  }
  
  public void c()
  {
    this.i = this.c.size();
    this.k.addAll(this.c);
    long l = FMDataCache.m() / 1048576L;
    int m = getReportType();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(this.i);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(l);
    ReportController.b(null, "dc00898", "", "", "0X800A0CB", "0X800A0CB", m, 0, (String)localObject, localStringBuilder.toString(), "", "");
    super.c();
  }
  
  public void d()
  {
    this.i = 0;
    this.k.clear();
    super.d();
  }
  
  protected QfileBaseExpandableListAdapter getQfileRecentFileBaseExpandableListAdapter()
  {
    QfileLocalFileBaseExpandableListAdapter localQfileLocalFileBaseExpandableListAdapter = new QfileLocalFileBaseExpandableListAdapter(getActivity(), this.l, getActivity(), this.y, this.B, this.A, this.K);
    localQfileLocalFileBaseExpandableListAdapter.a(this);
    return localQfileLocalFileBaseExpandableListAdapter;
  }
  
  protected void getRecentFileRecords()
  {
    setEditbarButton(false, false, false, false, true);
    this.C.a(this);
    this.J = new QfileLocalFileDelFileTabView.1(this);
    ThreadManager.executeOnFileThread(this.J);
  }
  
  public int[] getSupportSortType()
  {
    if (this.f == 5) {
      return new int[] { 1, 0 };
    }
    return new int[] { 1, 0, 2 };
  }
  
  public void j()
  {
    super.j();
    this.C.a(this);
    this.r.setOnGroupClickListener(null);
    Object localObject = this.c;
    boolean bool = false;
    int m;
    if (localObject != null) {
      m = ((List)localObject).size();
    } else {
      m = 0;
    }
    localObject = getActivity();
    if ((m == 0) || (this.i < m)) {
      bool = true;
    }
    ((BaseFileAssistantActivity)localObject).e(bool);
  }
  
  public void n()
  {
    if (this.g) {
      i();
    }
  }
  
  public void setSortType(int paramInt)
  {
    super.setSortType(paramInt);
    this.l.clear();
    paramInt = this.H;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2)
        {
          ReportController.b(null, "dc00898", "", "", "0X800A0CA", "0X800A0CA", getReportType(), 0, "", "", "", "");
          this.l.putAll(this.b);
        }
      }
      else
      {
        ReportController.b(null, "dc00898", "", "", "0X800A0C8", "0X800A0C8", getReportType(), 0, "", "", "", "");
        if (this.c.size() > 0) {
          this.l.put(this.e.first, this.c);
        }
      }
    }
    else
    {
      ReportController.b(null, "dc00898", "", "", "0X800A0C9", "0X800A0C9", getReportType(), 0, "", "", "", "");
      this.l.putAll(this.a);
    }
    i();
    setSelect(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelFileTabView
 * JD-Core Version:    0.7.0.1
 */