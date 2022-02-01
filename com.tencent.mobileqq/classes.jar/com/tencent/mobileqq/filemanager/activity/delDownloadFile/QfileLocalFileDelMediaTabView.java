package com.tencent.mobileqq.filemanager.activity.delDownloadFile;

import android.content.Context;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter.IQfileViewBinder;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView.ScanParams;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class QfileLocalFileDelMediaTabView
  extends QfileLocalFilePicTabView
  implements QfileBaseExpandableListAdapter.IQfileViewBinder
{
  LinkedHashMap<String, List<FileInfo>> a = new LinkedHashMap();
  List<FileInfo> b = new ArrayList();
  List<String> c = new ArrayList();
  boolean d = false;
  boolean e = false;
  int f = 0;
  final int g = 1000;
  List<FileInfo> h = new ArrayList();
  
  public QfileLocalFileDelMediaTabView(Context paramContext, List<QfileTabBarView.ScanParams> paramList, boolean paramBoolean)
  {
    super(paramContext, paramList, paramBoolean);
    this.H = 1;
    setViewBinder(this);
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
        bool1 = true;
        break label102;
      }
    }
    boolean bool1 = false;
    label102:
    this.b.remove(paramFileInfo);
    localObject = this.a.keySet().iterator();
    do
    {
      bool2 = bool1;
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
    boolean bool2 = true;
    try
    {
      paramFileInfo = a(paramFileInfo);
      localObject = new File(paramFileInfo);
      if (!((File)localObject).exists())
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("file not exists");
          ((StringBuilder)localObject).append(" : ");
          ((StringBuilder)localObject).append(paramFileInfo);
          ((StringBuilder)localObject).toString();
          return bool2;
        }
      }
      else
      {
        ((File)localObject).delete();
        return bool2;
      }
    }
    catch (Exception paramFileInfo)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("del file error:");
      ((StringBuilder)localObject).append(paramFileInfo.toString());
      QLog.e("delDownloadFiles<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      return bool2;
    }
    return bool2;
  }
  
  public String a(FileInfo paramFileInfo)
  {
    if (paramFileInfo == null) {
      return "";
    }
    String str = paramFileInfo.d();
    if (paramFileInfo.j()) {
      try
      {
        int i = Integer.parseInt(str);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)this.c.get(i));
        localStringBuilder.append(paramFileInfo.e());
        paramFileInfo = localStringBuilder.toString();
        return paramFileInfo;
      }
      catch (Exception paramFileInfo)
      {
        paramFileInfo.printStackTrace();
      }
    }
    return str;
  }
  
  public void a(FileInfo paramFileInfo, boolean paramBoolean)
  {
    boolean bool = true;
    if (paramBoolean)
    {
      this.f += 1;
      this.h.add(paramFileInfo);
    }
    else
    {
      this.f -= 1;
      this.h.remove(paramFileInfo);
    }
    paramFileInfo = getActivity();
    int i = this.f;
    paramBoolean = bool;
    if (i != 0) {
      if (i < this.b.size()) {
        paramBoolean = bool;
      } else {
        paramBoolean = false;
      }
    }
    paramFileInfo.e(paramBoolean);
  }
  
  public void a(Set<FileInfo> paramSet)
  {
    paramSet = this.h;
    if (paramSet != null)
    {
      if (paramSet.size() == 0) {
        return;
      }
      paramSet = this.h.iterator();
      long l2 = 0L;
      long l1 = 0L;
      while (paramSet.hasNext())
      {
        localObject = (FileInfo)paramSet.next();
        if (f((FileInfo)localObject))
        {
          l2 += ((FileInfo)localObject).f();
          l1 += 1L;
        }
      }
      this.h.clear();
      i();
      l2 /= 1048576L;
      paramSet = new StringBuilder();
      paramSet.append("");
      paramSet.append(l1);
      paramSet = paramSet.toString();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(l2);
      ReportController.b(null, "dc00898", "", "", "0X800A0CC", "0X800A0CC", 2, 0, paramSet, ((StringBuilder)localObject).toString(), "", "");
    }
  }
  
  public void c()
  {
    this.f = this.b.size();
    this.h.addAll(this.b);
    long l = FMDataCache.m() / 1048576L;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(this.f);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(l);
    ReportController.b(null, "dc00898", "", "", "0X800A0CB", "0X800A0CB", 2, 0, (String)localObject, localStringBuilder.toString(), "", "");
    super.c();
  }
  
  public void d()
  {
    this.f = 0;
    this.h.clear();
    super.d();
  }
  
  protected QfileBaseExpandableListAdapter getQfileRecentFileBaseExpandableListAdapter()
  {
    QFileDelDownloadAdapter localQFileDelDownloadAdapter = new QFileDelDownloadAdapter(getActivity(), this.l, 2);
    localQFileDelDownloadAdapter.a(this);
    return localQFileDelDownloadAdapter;
  }
  
  protected void getRecentFileRecords()
  {
    setEditbarButton(false, false, false, false, true);
    this.C.a(this);
    this.J = new QfileLocalFileDelMediaTabView.1(this);
    ThreadManager.executeOnFileThread(this.J);
  }
  
  public int[] getSupportSortType()
  {
    return new int[] { 1, 0 };
  }
  
  public void j()
  {
    this.C.a(this);
    this.C.B();
    this.r.setOnIndexChangedListener(this.M);
    Object localObject = this.b;
    boolean bool = false;
    int i;
    if (localObject != null) {
      i = ((List)localObject).size();
    } else {
      i = 0;
    }
    localObject = getActivity();
    if ((i == 0) || (this.f < i)) {
      bool = true;
    }
    ((BaseFileAssistantActivity)localObject).e(bool);
  }
  
  public void n()
  {
    if (this.d) {
      i();
    }
  }
  
  public void setSortType(int paramInt)
  {
    super.setSortType(paramInt);
    this.l.clear();
    if (paramInt != 0)
    {
      if (paramInt == 1)
      {
        ReportController.b(null, "dc00898", "", "", "0X800A0C8", "0X800A0C8", 2, 0, "", "", "", "");
        if (this.b.size() > 0) {
          this.l.put(HardCodeUtil.a(2131896094), this.b);
        }
      }
    }
    else
    {
      ReportController.b(null, "dc00898", "", "", "0X800A0C9", "0X800A0C9", 2, 0, "", "", "", "");
      this.l.putAll(this.a);
    }
    i();
    setSelect(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelMediaTabView
 * JD-Core Version:    0.7.0.1
 */