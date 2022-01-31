package com.tencent.mobileqq.filemanager.activity.delDownloadFile;

import alud;
import android.content.Context;
import aqni;
import aqnm;
import aqow;
import arbs;
import arvi;
import azqs;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class QfileLocalFileDelMediaTabView
  extends QfileLocalFilePicTabView
  implements aqnm
{
  int jdField_a_of_type_Int = 0;
  LinkedHashMap<String, List<FileInfo>> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  List<FileInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  final int jdField_b_of_type_Int = 1000;
  List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  boolean jdField_b_of_type_Boolean = false;
  List<FileInfo> c;
  
  public QfileLocalFileDelMediaTabView(Context paramContext, List<arvi> paramList, boolean paramBoolean)
  {
    super(paramContext, paramList, paramBoolean);
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_d_of_type_Int = 1;
    a(this);
    a();
  }
  
  private boolean c(FileInfo paramFileInfo)
  {
    boolean bool2 = false;
    Object localObject = this.jdField_c_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    String str;
    List localList;
    do
    {
      bool1 = bool2;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      str = (String)((Iterator)localObject).next();
      localList = (List)this.jdField_c_of_type_JavaUtilLinkedHashMap.get(str);
    } while ((localList == null) || (!localList.contains(paramFileInfo)));
    localList.remove(paramFileInfo);
    if (localList.size() == 0) {
      this.jdField_c_of_type_JavaUtilLinkedHashMap.remove(str);
    }
    boolean bool1 = true;
    this.jdField_a_of_type_JavaUtilList.remove(paramFileInfo);
    localObject = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      str = (String)((Iterator)localObject).next();
      localList = (List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(str);
      if ((localList != null) && (localList.contains(paramFileInfo)))
      {
        localList.remove(paramFileInfo);
        if (localList.size() == 0) {
          this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(str);
        }
        bool1 = true;
      }
    }
    for (;;)
    {
      try
      {
        paramFileInfo = a(paramFileInfo);
        localObject = new File(paramFileInfo);
        if (!((File)localObject).exists())
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          new StringBuilder().append("file not exists").append(" : ").append(paramFileInfo).toString();
          return bool1;
        }
        ((File)localObject).delete();
        return bool1;
      }
      catch (Exception paramFileInfo)
      {
        QLog.e("delDownloadFiles<FileAssistant>", 1, "del file error:" + paramFileInfo.toString());
        return bool1;
      }
    }
    return bool1;
  }
  
  public aqni a()
  {
    aqow localaqow = new aqow(a(), this.jdField_c_of_type_JavaUtilLinkedHashMap, 2);
    localaqow.a(this);
    return localaqow;
  }
  
  public String a(FileInfo paramFileInfo)
  {
    if (paramFileInfo == null) {
      return "";
    }
    String str = paramFileInfo.c();
    if (paramFileInfo.b()) {
      try
      {
        int i = Integer.parseInt(str);
        paramFileInfo = (String)this.jdField_b_of_type_JavaUtilList.get(i) + paramFileInfo.d();
        return paramFileInfo;
      }
      catch (Exception paramFileInfo)
      {
        paramFileInfo.printStackTrace();
      }
    }
    return str;
  }
  
  public void a()
  {
    setEditbarButton(false, false, false, false, true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a(this);
    this.jdField_a_of_type_JavaLangRunnable = new QfileLocalFileDelMediaTabView.1(this);
    ThreadManager.executeOnFileThread(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void a(FileInfo paramFileInfo, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Int += 1;
      this.jdField_c_of_type_JavaUtilList.add(paramFileInfo);
      paramFileInfo = a();
      if ((this.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size())) {
        break label85;
      }
    }
    label85:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramFileInfo.e(paramBoolean);
      return;
      this.jdField_a_of_type_Int -= 1;
      this.jdField_c_of_type_JavaUtilList.remove(paramFileInfo);
      break;
    }
  }
  
  public void a(Set<FileInfo> paramSet)
  {
    if ((this.jdField_c_of_type_JavaUtilList == null) || (this.jdField_c_of_type_JavaUtilList.size() == 0)) {
      return;
    }
    paramSet = this.jdField_c_of_type_JavaUtilList.iterator();
    long l1 = 0L;
    long l2 = 0L;
    if (paramSet.hasNext())
    {
      FileInfo localFileInfo = (FileInfo)paramSet.next();
      if (!c(localFileInfo)) {
        break label162;
      }
      l2 += localFileInfo.a();
      l1 = 1L + l1;
    }
    label162:
    for (;;)
    {
      break;
      this.jdField_c_of_type_JavaUtilList.clear();
      i();
      l2 /= 1048576L;
      azqs.b(null, "dc00898", "", "", "0X800A0CC", "0X800A0CC", 2, 0, "" + l1, "" + l2, "", "");
      return;
    }
  }
  
  public int[] a()
  {
    return new int[] { 1, 0 };
  }
  
  public void d()
  {
    this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilList.size();
    this.jdField_c_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    long l = arbs.d() / 1048576L;
    azqs.b(null, "dc00898", "", "", "0X800A0CB", "0X800A0CB", 2, 0, "" + this.jdField_a_of_type_Int, "" + l, "", "");
    super.d();
  }
  
  public void e()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_JavaUtilList.clear();
    super.e();
  }
  
  public void j()
  {
    boolean bool = false;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a(this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.l();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnIndexChangedListener(this.jdField_a_of_type_Arvg);
    if (this.jdField_a_of_type_JavaUtilList != null) {}
    for (int i = this.jdField_a_of_type_JavaUtilList.size();; i = 0)
    {
      BaseFileAssistantActivity localBaseFileAssistantActivity = a();
      if ((i == 0) || (this.jdField_a_of_type_Int < i)) {
        bool = true;
      }
      localBaseFileAssistantActivity.e(bool);
      return;
    }
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_Boolean) {
      i();
    }
  }
  
  public void setSortType(int paramInt)
  {
    super.setSortType(paramInt);
    this.jdField_c_of_type_JavaUtilLinkedHashMap.clear();
    switch (paramInt)
    {
    }
    for (;;)
    {
      i();
      setSelect(0);
      return;
      azqs.b(null, "dc00898", "", "", "0X800A0C8", "0X800A0C8", 2, 0, "", "", "", "");
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        this.jdField_c_of_type_JavaUtilLinkedHashMap.put(alud.a(2131710075), this.jdField_a_of_type_JavaUtilList);
        continue;
        azqs.b(null, "dc00898", "", "", "0X800A0C9", "0X800A0C9", 2, 0, "", "", "", "");
        this.jdField_c_of_type_JavaUtilLinkedHashMap.putAll(this.jdField_a_of_type_JavaUtilLinkedHashMap);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelMediaTabView
 * JD-Core Version:    0.7.0.1
 */