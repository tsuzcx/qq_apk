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
  private IClickListenerVer51 jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListenerVer51 = null;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = null;
  
  public QfileRecentDocFileTabView(Context paramContext)
  {
    super(paramContext);
    f();
    setEditbarButton(false, true, true, true, true);
  }
  
  public QfileRecentDocFileTabView(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    f();
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
      if (QQFileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity))
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
  
  private List<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      o();
    }
    Object localObject = this.jdField_a_of_type_JavaUtilHashMap;
    if (localObject != null)
    {
      localObject = ((HashMap)localObject).keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add((String)((Iterator)localObject).next());
      }
    }
    return localArrayList;
  }
  
  private String b(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      o();
    }
    Object localObject = this.jdField_a_of_type_JavaUtilHashMap;
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
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.c()) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().H();
    } else {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().M();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListenerVer51 != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListenerVer51);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListenerVer51 = new QfileRecentDocFileTabView.1(this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListenerVer51);
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null)
    {
      String str = TencentDocImportFileInfoProcessor.a().d();
      if (!TextUtils.isEmpty(str)) {
        this.jdField_a_of_type_JavaUtilHashMap = TencentDocConfig.a(str);
      }
      if (this.jdField_a_of_type_JavaUtilHashMap == null) {
        this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      }
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("WORD")) {
        this.jdField_a_of_type_JavaUtilHashMap.put("WORD", ".doc|.docx|.wps|.pages|");
      }
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("PPT")) {
        this.jdField_a_of_type_JavaUtilHashMap.put("PPT", ".ppt|.pptx.|.dps|.keynote|");
      }
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("EXCEL")) {
        this.jdField_a_of_type_JavaUtilHashMap.put("EXCEL", ".xls|.xlsx|.et|.numbers|");
      }
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("PDF")) {
        this.jdField_a_of_type_JavaUtilHashMap.put("PDF", ".pdf|");
      }
    }
  }
  
  protected QfileBaseExpandableListAdapter a()
  {
    return new QfileRecentFileBaseExpandableListAdapter(a(), this.jdField_a_of_type_JavaUtilLinkedHashMap, a(), this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_b_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.c);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put("WORD", new ArrayList());
    localLinkedHashMap.put("EXCEL", new ArrayList());
    localLinkedHashMap.put("PDF", new ArrayList());
    localLinkedHashMap.put("PPT", new ArrayList());
    Object localObject2;
    if (QQFileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity))
    {
      localObject1 = a();
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
    Object localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (FileManagerEntity)((Iterator)localObject1).next();
      if (!((FileManagerEntity)localObject2).bDelInFM)
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
    this.jdField_a_of_type_JavaUtilLinkedHashMap.putAll(localLinkedHashMap);
    i();
    setSelect(0);
    a(true);
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void b(FileManagerEntity paramFileManagerEntity)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramFileManagerEntity))
    {
      if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.trim().length() != 0) && (!this.jdField_b_of_type_JavaLangString.equals(paramFileManagerEntity.peerUin))) {
        return;
      }
      this.jdField_a_of_type_JavaUtilList.add(paramFileManagerEntity);
      Collections.sort(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilComparator);
    }
    String str = a(paramFileManagerEntity.fileName);
    if (str == null) {
      return;
    }
    a(new QfileRecentDocFileTabView.2(this, str, paramFileManagerEntity));
  }
  
  protected boolean b(FileManagerEntity paramFileManagerEntity)
  {
    Object localObject = a(paramFileManagerEntity.fileName);
    if (!this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(localObject))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "delRecentFileRecords, fileEntities find, but recentRecords not find!");
      return false;
    }
    synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      localObject = ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject)).iterator();
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
  
  public void c(ArrayList<FileManagerEntity> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        b((FileManagerEntity)paramArrayList.next());
      }
    }
  }
  
  public void j()
  {
    super.j();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h(true);
    setEditbarButton(false, true, true, true, true);
    k();
  }
  
  public void m()
  {
    super.m();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentDocFileTabView
 * JD-Core Version:    0.7.0.1
 */