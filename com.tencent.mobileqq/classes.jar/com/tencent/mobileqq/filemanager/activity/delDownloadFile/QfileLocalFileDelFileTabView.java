package com.tencent.mobileqq.filemanager.activity.delDownloadFile;

import android.content.Context;
import atab;
import ataf;
import atdu;
import atpm;
import augj;
import bdla;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileDocTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
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
  implements ataf
{
  int jdField_a_of_type_Int = -1;
  Pair<String, Integer> jdField_a_of_type_ComTencentUtilPair;
  LinkedHashMap<String, List<FileInfo>> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  List<FileInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  LinkedHashMap<String, List<FileInfo>> jdField_b_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  boolean jdField_b_of_type_Boolean = false;
  final int jdField_c_of_type_Int = 1000;
  List<FileInfo> jdField_c_of_type_JavaUtilList = new ArrayList();
  
  public QfileLocalFileDelFileTabView(Context paramContext, List<augj> paramList, Pair<String, Integer> paramPair)
  {
    super(paramContext, paramList, false);
    this.jdField_d_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentUtilPair = paramPair;
    this.jdField_a_of_type_Int = ((Integer)this.jdField_a_of_type_ComTencentUtilPair.second).intValue();
    a();
  }
  
  private int b()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return -1;
    case 3: 
      return 1;
    case 5: 
      return 4;
    }
    return 5;
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
    do
    {
      bool2 = bool1;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      str = (String)((Iterator)localObject).next();
      localList = (List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(str);
    } while ((localList == null) || (!localList.contains(paramFileInfo)));
    localList.remove(paramFileInfo);
    if (localList.size() == 0) {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(str);
    }
    bool2 = true;
    localObject = this.jdField_b_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        str = (String)((Iterator)localObject).next();
        localList = (List)this.jdField_b_of_type_JavaUtilLinkedHashMap.get(str);
        if ((localList != null) && (localList.contains(paramFileInfo)))
        {
          localList.remove(paramFileInfo);
          if (localList.size() == 0) {
            this.jdField_b_of_type_JavaUtilLinkedHashMap.remove(str);
          }
        }
      }
    }
    for (bool1 = true;; bool1 = bool2) {
      try
      {
        localObject = a(paramFileInfo);
        paramFileInfo = new File((String)localObject);
        if (!paramFileInfo.exists())
        {
          paramFileInfo = "file not exists";
          if (QLog.isColorLevel()) {
            paramFileInfo = "file not exists" + " : " + (String)localObject;
          }
          QLog.w("delDownloadFiles<FileAssistant>", 1, paramFileInfo);
          return bool1;
        }
        paramFileInfo.delete();
        return bool1;
      }
      catch (Exception paramFileInfo)
      {
        QLog.e("delDownloadFiles<FileAssistant>", 1, "del file error:" + paramFileInfo.toString());
        return bool1;
      }
    }
  }
  
  public atab a()
  {
    atdu localatdu = new atdu(a(), this.jdField_c_of_type_JavaUtilLinkedHashMap, a(), this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_c_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.jdField_d_of_type_AndroidViewView$OnClickListener);
    localatdu.a(this);
    return localatdu;
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
      catch (Exception paramFileInfo) {}
    }
    return str;
  }
  
  public void a()
  {
    setEditbarButton(false, false, false, false, true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a(this);
    this.jdField_a_of_type_JavaLangRunnable = new QfileLocalFileDelFileTabView.1(this);
    ThreadManager.executeOnFileThread(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void a(FileInfo paramFileInfo, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_b_of_type_Int += 1;
      this.jdField_c_of_type_JavaUtilList.add(paramFileInfo);
      paramFileInfo = a();
      if ((this.jdField_b_of_type_Int != 0) && (this.jdField_b_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size())) {
        break label85;
      }
    }
    label85:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramFileInfo.e(paramBoolean);
      return;
      this.jdField_b_of_type_Int -= 1;
      this.jdField_c_of_type_JavaUtilList.remove(paramFileInfo);
      break;
    }
  }
  
  public void a(Set<FileInfo> paramSet)
  {
    if (this.jdField_c_of_type_JavaUtilList.size() == 0) {
      return;
    }
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    long l1 = 0L;
    long l2 = 0L;
    if (localIterator.hasNext())
    {
      FileInfo localFileInfo = (FileInfo)localIterator.next();
      if (!c(localFileInfo)) {
        break label173;
      }
      paramSet.remove(localFileInfo);
      l2 += localFileInfo.a();
      l1 = 1L + l1;
    }
    label173:
    for (;;)
    {
      break;
      this.jdField_c_of_type_JavaUtilList.clear();
      i();
      l2 /= 1048576L;
      bdla.b(null, "dc00898", "", "", "0X800A0CC", "0X800A0CC", b(), 0, "" + l1, "" + l2, "", "");
      return;
    }
  }
  
  public int[] a()
  {
    if (this.jdField_a_of_type_Int == 5) {
      return new int[] { 1, 0 };
    }
    return new int[] { 1, 0, 2 };
  }
  
  public void b(FileInfo paramFileInfo, boolean paramBoolean)
  {
    super.b(paramFileInfo, paramBoolean);
    a(paramFileInfo, paramBoolean);
  }
  
  public void d()
  {
    this.jdField_b_of_type_Int = this.jdField_a_of_type_JavaUtilList.size();
    this.jdField_c_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    long l = atpm.d() / 1048576L;
    bdla.b(null, "dc00898", "", "", "0X800A0CB", "0X800A0CB", b(), 0, "" + this.jdField_b_of_type_Int, "" + l, "", "");
    super.d();
  }
  
  public void e()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_JavaUtilList.clear();
    super.e();
  }
  
  public void j()
  {
    boolean bool = false;
    super.j();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a(this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnGroupClickListener(null);
    if (this.jdField_a_of_type_JavaUtilList != null) {}
    for (int i = this.jdField_a_of_type_JavaUtilList.size();; i = 0)
    {
      BaseFileAssistantActivity localBaseFileAssistantActivity = a();
      if ((i == 0) || (this.jdField_b_of_type_Int < i)) {
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
    switch (this.jdField_d_of_type_Int)
    {
    }
    for (;;)
    {
      i();
      setSelect(0);
      return;
      bdla.b(null, "dc00898", "", "", "0X800A0C8", "0X800A0C8", b(), 0, "", "", "", "");
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        this.jdField_c_of_type_JavaUtilLinkedHashMap.put(this.jdField_a_of_type_ComTencentUtilPair.first, this.jdField_a_of_type_JavaUtilList);
        continue;
        bdla.b(null, "dc00898", "", "", "0X800A0C9", "0X800A0C9", b(), 0, "", "", "", "");
        this.jdField_c_of_type_JavaUtilLinkedHashMap.putAll(this.jdField_a_of_type_JavaUtilLinkedHashMap);
        continue;
        bdla.b(null, "dc00898", "", "", "0X800A0CA", "0X800A0CA", b(), 0, "", "", "", "");
        this.jdField_c_of_type_JavaUtilLinkedHashMap.putAll(this.jdField_b_of_type_JavaUtilLinkedHashMap);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelFileTabView
 * JD-Core Version:    0.7.0.1
 */