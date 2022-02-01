package com.tencent.mobileqq.filemanager.activity.localfile;

import android.content.Context;
import atjm;
import atnf;
import aumo;
import aunb;
import auom;
import aupu;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
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
  private int a;
  
  public QfileLocalFileMediaTabView(Context paramContext, int paramInt, List<aupu> paramList, boolean paramBoolean)
  {
    super(paramContext, paramList, paramBoolean);
    this.jdField_a_of_type_Int = 3;
    setEditbarButton(false, false, true, true, true);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private HashMap<String, List<FileInfo>> a()
  {
    HashMap localHashMap = new HashMap();
    String str;
    if (this.f) {
      str = aumo.a().a();
    }
    while ((this.jdField_a_of_type_Int & 0x1) > 0)
    {
      Iterator localIterator = this.jdField_d_of_type_JavaUtilList.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          aunb.a(true, ((aupu)localIterator.next()).a(), ".mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|", ".mpg", localHashMap, null);
          continue;
          str = null;
          break;
        }
      }
      if (str != null) {
        aunb.a(true, str, ".mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|", ".mpg", localHashMap, null);
      }
      aunb.a(localHashMap);
    }
    return localHashMap;
  }
  
  private HashMap<String, List<FileInfo>> b()
  {
    HashMap localHashMap = new HashMap();
    String str;
    if (this.f) {
      str = aumo.a().a();
    }
    while ((this.jdField_a_of_type_Int & 0x2) > 0)
    {
      Iterator localIterator = this.jdField_d_of_type_JavaUtilList.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          aunb.a(true, ((aupu)localIterator.next()).a(), ".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|", "", localHashMap, null);
          continue;
          str = null;
          break;
        }
      }
      if (str != null) {
        aunb.a(true, str, ".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|", "", localHashMap, null);
      }
      aunb.a(localHashMap);
    }
    return localHashMap;
  }
  
  private void d(ArrayList<FileInfo> paramArrayList)
  {
    if (paramArrayList == null) {
      break label4;
    }
    for (;;)
    {
      label4:
      return;
      if ((this.f) && ((this.jdField_a_of_type_Int & 0x1) > 0))
      {
        Map localMap = aunb.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);
        if (localMap == null) {
          break;
        }
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
      break label4;
    }
    for (;;)
    {
      label4:
      return;
      if ((this.f) && ((this.jdField_a_of_type_Int & 0x2) > 0))
      {
        Map localMap = aunb.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);
        if (localMap == null) {
          break;
        }
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
  
  protected atjm a()
  {
    return new atnf(a(), this.jdField_c_of_type_JavaUtilLinkedHashMap, a(), this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_c_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.jdField_d_of_type_AndroidViewView$OnClickListener);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_JavaLangRunnable = new QfileLocalFileMediaTabView.1(this);
    ThreadManagerV2.excute(this.jdField_a_of_type_JavaLangRunnable, 64, null, true);
  }
  
  public void a(Set<FileInfo> paramSet)
  {
    if ((paramSet == null) || (paramSet.size() == 0)) {}
    for (;;)
    {
      return;
      paramSet = paramSet.iterator();
      while (paramSet.hasNext()) {
        b((FileInfo)paramSet.next());
      }
    }
  }
  
  protected void b(FileInfo paramFileInfo)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramFileInfo)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramFileInfo);
    }
    a(new QfileLocalFileMediaTabView.2(this, paramFileInfo));
  }
  
  protected boolean b(FileInfo paramFileInfo)
  {
    String str = paramFileInfo.a();
    if (!this.jdField_c_of_type_JavaUtilLinkedHashMap.containsKey(str))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "delRecentFileRecords, fileEntities find, but recentRecords not find!");
      return false;
    }
    ((List)this.jdField_c_of_type_JavaUtilLinkedHashMap.get(str)).remove(paramFileInfo);
    i();
    return true;
  }
  
  public void j()
  {
    super.j();
    setEditbarButton(false, false, true, true, true);
    if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.k())
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.c()) {
        break label50;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().R();
    }
    for (;;)
    {
      o();
      return;
      label50:
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().W();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileMediaTabView
 * JD-Core Version:    0.7.0.1
 */