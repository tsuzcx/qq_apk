package com.tencent.mobileqq.filemanager.activity.recentfile;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.config.business.tendoc.TencentDocImportFileInfoBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocImportFileInfoProcessor;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.IClickListenerVer51;
import com.tencent.mobileqq.filemanager.util.IReportVer51;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.TencentDocConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class QfileRecentDocFileTabView
  extends QfileBaseRecentFileTabView
{
  private IClickListenerVer51 w = null;
  private HashMap<String, String> x = null;
  
  public QfileRecentDocFileTabView(Context paramContext)
  {
    super(paramContext);
    e();
    setEditbarButton(false, true, true, true, true);
  }
  
  public QfileRecentDocFileTabView(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    e();
    setEditbarButton(false, true, true, true, true);
  }
  
  private String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getExtension(paramString).toLowerCase();
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return null;
      }
      if (QQFileManagerUtil.c(this.C))
      {
        paramString = b(paramString);
        if (!TextUtils.isEmpty(paramString)) {
          return paramString;
        }
      }
      else
      {
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
      }
    }
    return null;
  }
  
  private String b(String paramString)
  {
    if (this.x == null) {
      k();
    }
    Object localObject = this.x;
    if (localObject != null)
    {
      localObject = ((HashMap)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        String str = (String)localEntry.getValue();
        if ((!TextUtils.isEmpty(str)) && (str.indexOf(paramString) >= 0)) {
          return (String)localEntry.getKey();
        }
      }
    }
    return null;
  }
  
  private List<String> getConfigDocFileGroup()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.x == null) {
      k();
    }
    Object localObject = this.x;
    if (localObject != null)
    {
      localObject = ((HashMap)localObject).keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add((String)((Iterator)localObject).next());
      }
    }
    return localArrayList;
  }
  
  private void h()
  {
    if (this.C.q()) {
      this.C.A().H();
    } else {
      this.C.A().M();
    }
    if (this.w != null)
    {
      this.C.a(this.w);
      return;
    }
    this.w = new QfileRecentDocFileTabView.1(this);
    this.C.a(this.w);
  }
  
  private void k()
  {
    if (this.x == null)
    {
      String str = TencentDocImportFileInfoProcessor.a().e();
      if (!TextUtils.isEmpty(str)) {
        this.x = TencentDocConfig.a(str);
      }
      if (this.x == null) {
        this.x = new HashMap();
      }
      if (!this.x.containsKey("WORD")) {
        this.x.put("WORD", ".doc|.docx|.wps|.pages|");
      }
      if (!this.x.containsKey("PPT")) {
        this.x.put("PPT", ".ppt|.pptx.|.dps|.keynote|");
      }
      if (!this.x.containsKey("EXCEL")) {
        this.x.put("EXCEL", ".xls|.xlsx|.et|.numbers|");
      }
      if (!this.x.containsKey("PDF")) {
        this.x.put("PDF", ".pdf|");
      }
    }
  }
  
  public void c(FileManagerEntity paramFileManagerEntity)
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
    a(new QfileRecentDocFileTabView.2(this, str, paramFileManagerEntity));
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
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put("WORD", new ArrayList());
    localLinkedHashMap.put("EXCEL", new ArrayList());
    localLinkedHashMap.put("PDF", new ArrayList());
    localLinkedHashMap.put("PPT", new ArrayList());
    Object localObject2;
    if (QQFileManagerUtil.c(this.C))
    {
      localObject1 = getConfigDocFileGroup();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!((String)localObject2).equals("WORD")) && (!((String)localObject2).equals("EXCEL")) && (!((String)localObject2).equals("PDF")) && (!((String)localObject2).equals("PPT"))) {
            localLinkedHashMap.put(localObject2, new ArrayList());
          }
        }
      }
    }
    Object localObject1 = this.k.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (FileManagerEntity)((Iterator)localObject1).next();
      if ((!((FileManagerEntity)localObject2).bDelInFM) && (((!this.C.m) && (((FileManagerEntity)localObject2).peerType != 10014)) || (QQFileManagerUtil.v(((FileManagerEntity)localObject2).getFilePath()))))
      {
        String str = a(((FileManagerEntity)localObject2).fileName);
        if ((str != null) || (localLinkedHashMap.containsKey(str))) {
          ((List)localLinkedHashMap.get(str)).add(localObject2);
        }
      }
    }
    localObject1 = localLinkedHashMap.keySet().iterator();
    while (((Iterator)localObject1).hasNext()) {
      if (((List)localLinkedHashMap.get((String)((Iterator)localObject1).next())).size() == 0) {
        ((Iterator)localObject1).remove();
      }
    }
    this.c.putAll(localLinkedHashMap);
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
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentDocFileTabView
 * JD-Core Version:    0.7.0.1
 */