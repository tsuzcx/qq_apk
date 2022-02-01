package com.tencent.mobileqq.filemanager.activity.localfile;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.filemanager.util.IReportVer51;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView.ScanParams;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class QfileLocalFileMediaTabView
  extends QfileBaseLocalFileTabView
{
  private int a = 3;
  
  public QfileLocalFileMediaTabView(Context paramContext, int paramInt, List<QfileTabBarView.ScanParams> paramList, boolean paramBoolean)
  {
    super(paramContext, paramList, paramBoolean);
    setEditbarButton(false, false, true, true, true);
    this.a = paramInt;
  }
  
  private void d(ArrayList<FileInfo> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    if ((this.n) && ((this.a & 0x1) > 0))
    {
      Map localMap = FileCategoryUtil.c(this.C);
      if (localMap != null)
      {
        Iterator localIterator = localMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (!"QQfile_recv".equalsIgnoreCase(str)) {
            paramArrayList.addAll((List)localMap.get(str));
          }
        }
      }
    }
  }
  
  private void e(ArrayList<FileInfo> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    if ((this.n) && ((this.a & 0x2) > 0))
    {
      Map localMap = FileCategoryUtil.b(this.C);
      if (localMap != null)
      {
        Iterator localIterator = localMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (!"QQfile_recv".equalsIgnoreCase(str)) {
            paramArrayList.addAll((List)localMap.get(str));
          }
        }
      }
    }
  }
  
  private HashMap<String, List<FileInfo>> o()
  {
    HashMap localHashMap = new HashMap();
    if ((this.a & 0x1) > 0)
    {
      Iterator localIterator = this.m.iterator();
      while (localIterator.hasNext()) {
        FileCategoryUtil.a(true, ((QfileTabBarView.ScanParams)localIterator.next()).a(), ".mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|", ".mpg", localHashMap, null);
      }
      FileCategoryUtil.a(localHashMap);
    }
    return localHashMap;
  }
  
  private HashMap<String, List<FileInfo>> p()
  {
    HashMap localHashMap = new HashMap();
    if ((this.a & 0x2) > 0)
    {
      Iterator localIterator = this.m.iterator();
      while (localIterator.hasNext()) {
        FileCategoryUtil.a(true, ((QfileTabBarView.ScanParams)localIterator.next()).a(), ".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|", "", localHashMap, null);
      }
      FileCategoryUtil.a(localHashMap);
    }
    return localHashMap;
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
    a(new QfileLocalFileMediaTabView.2(this, paramFileInfo));
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
  
  protected QfileBaseExpandableListAdapter getQfileRecentFileBaseExpandableListAdapter()
  {
    return new QfileLocalFileBaseExpandableListAdapter(getActivity(), this.l, getActivity(), this.y, this.B, this.A, this.K);
  }
  
  protected void getRecentFileRecords()
  {
    this.J = new QfileLocalFileMediaTabView.1(this);
    ThreadManagerV2.excute(this.J, 64, null, true);
  }
  
  public void j()
  {
    super.j();
    setEditbarButton(false, false, true, true, true);
    if (!this.C.K()) {
      if (this.C.q()) {
        this.C.A().R();
      } else {
        this.C.A().W();
      }
    }
    k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileMediaTabView
 * JD-Core Version:    0.7.0.1
 */