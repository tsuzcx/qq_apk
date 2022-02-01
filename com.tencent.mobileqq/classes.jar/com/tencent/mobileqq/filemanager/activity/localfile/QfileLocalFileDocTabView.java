package com.tencent.mobileqq.filemanager.activity.localfile;

import android.content.Context;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.IReportVer51;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView.ScanParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class QfileLocalFileDocTabView
  extends QfileBaseLocalFileTabView
{
  public QfileLocalFileDocTabView(Context paramContext, List<QfileTabBarView.ScanParams> paramList, boolean paramBoolean)
  {
    super(paramContext, paramList, paramBoolean);
    setEditbarButton(false, false, true, true, true);
  }
  
  private String a(String paramString)
  {
    paramString = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getExtension(paramString);
    if ((paramString != null) && (paramString.length() != 0))
    {
      paramString = paramString.toLowerCase();
      if (".doc|.docx|.wps|.pages|".indexOf(paramString) >= 0) {
        return "WORD";
      }
      if (".ppt|.pptx.|.dps|.keynote|".indexOf(paramString) >= 0) {
        return "PPT";
      }
      if (".xls|.xlsx|.et|.numbers|".indexOf(paramString) >= 0) {
        return "EXCEL";
      }
      if (".pdf|".indexOf(paramString) >= 0) {
        return "PDF";
      }
      return HardCodeUtil.a(2131889609);
    }
    return HardCodeUtil.a(2131889609);
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
    if (!this.v.contains(paramFileInfo)) {
      this.v.add(paramFileInfo);
    }
    a(new QfileLocalFileDocTabView.2(this, paramFileInfo));
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
  
  protected void getFileRecordsFromLocal()
  {
    this.v.clear();
    getRecentFileRecords();
    b(true);
  }
  
  protected QfileBaseExpandableListAdapter getQfileRecentFileBaseExpandableListAdapter()
  {
    return new QfileLocalFileBaseExpandableListAdapter(getActivity(), this.l, getActivity(), this.y, this.B, this.A, this.K);
  }
  
  protected void getRecentFileRecords()
  {
    this.C.a(this);
    this.J = new QfileLocalFileDocTabView.1(this);
    ThreadManagerV2.excute(this.J, 64, null, true);
  }
  
  public void j()
  {
    super.j();
    if (this.C.q())
    {
      if (!this.C.K()) {
        this.C.A().Q();
      }
      this.C.h(true);
    }
    else if (!this.C.K())
    {
      this.C.A().V();
    }
    setEditbarButton(false, false, true, true, true);
    k();
  }
  
  public void m()
  {
    super.m();
    this.C.h(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileDocTabView
 * JD-Core Version:    0.7.0.1
 */