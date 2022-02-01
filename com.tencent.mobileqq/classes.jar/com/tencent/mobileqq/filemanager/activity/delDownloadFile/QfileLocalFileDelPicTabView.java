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

public class QfileLocalFileDelPicTabView
  extends QfileLocalFilePicTabView
  implements QfileBaseExpandableListAdapter.IQfileViewBinder
{
  int jdField_a_of_type_Int = 0;
  LinkedHashMap<String, List<FileInfo>> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  List<FileInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  final int jdField_b_of_type_Int = 1000;
  List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  boolean jdField_b_of_type_Boolean = false;
  List<FileInfo> jdField_c_of_type_JavaUtilList = new ArrayList();
  boolean jdField_c_of_type_Boolean = false;
  
  public QfileLocalFileDelPicTabView(Context paramContext, List<QfileTabBarView.ScanParams> paramList, boolean paramBoolean)
  {
    super(paramContext, paramList, paramBoolean);
    this.jdField_d_of_type_Int = 1;
    a();
    a(this);
  }
  
  private boolean c(FileInfo paramFileInfo)
  {
    Object localObject = this.jdField_c_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    String str;
    List localList;
    while (((Iterator)localObject).hasNext())
    {
      str = (String)((Iterator)localObject).next();
      localList = (List)this.jdField_c_of_type_JavaUtilLinkedHashMap.get(str);
      if ((localList != null) && (localList.contains(paramFileInfo)))
      {
        localList.remove(paramFileInfo);
        if (localList.size() == 0) {
          this.jdField_c_of_type_JavaUtilLinkedHashMap.remove(str);
        }
        bool1 = true;
        break label102;
      }
    }
    boolean bool1 = false;
    label102:
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
    boolean bool2 = true;
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
  
  protected QfileBaseExpandableListAdapter a()
  {
    QFileDelDownloadAdapter localQFileDelDownloadAdapter = new QFileDelDownloadAdapter(a(), this.jdField_c_of_type_JavaUtilLinkedHashMap, 0);
    localQFileDelDownloadAdapter.a(this);
    return localQFileDelDownloadAdapter;
  }
  
  public String a(FileInfo paramFileInfo)
  {
    if (paramFileInfo == null) {
      return "";
    }
    String str = paramFileInfo.c();
    if (paramFileInfo.c()) {
      try
      {
        int i = Integer.parseInt(str);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)this.jdField_b_of_type_JavaUtilList.get(i));
        localStringBuilder.append(paramFileInfo.d());
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
  
  protected void a()
  {
    this.jdField_c_of_type_Boolean = false;
    setEditbarButton(false, false, false, false, true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a(this);
    this.jdField_a_of_type_JavaLangRunnable = new QfileLocalFileDelPicTabView.1(this);
    ThreadManager.executeOnFileThread(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void a(FileInfo paramFileInfo, boolean paramBoolean)
  {
    boolean bool = true;
    if (paramBoolean)
    {
      this.jdField_a_of_type_Int += 1;
      this.jdField_c_of_type_JavaUtilList.add(paramFileInfo);
    }
    else
    {
      this.jdField_a_of_type_Int -= 1;
      this.jdField_c_of_type_JavaUtilList.remove(paramFileInfo);
    }
    paramFileInfo = a();
    int i = this.jdField_a_of_type_Int;
    paramBoolean = bool;
    if (i != 0) {
      if (i < this.jdField_a_of_type_JavaUtilList.size()) {
        paramBoolean = bool;
      } else {
        paramBoolean = false;
      }
    }
    paramFileInfo.e(paramBoolean);
  }
  
  public void a(Set<FileInfo> paramSet)
  {
    if (this.jdField_c_of_type_JavaUtilList.size() == 0) {
      return;
    }
    paramSet = this.jdField_c_of_type_JavaUtilList.iterator();
    long l2 = 0L;
    long l1 = 0L;
    while (paramSet.hasNext())
    {
      localObject = (FileInfo)paramSet.next();
      if (c((FileInfo)localObject))
      {
        l2 += ((FileInfo)localObject).a();
        l1 += 1L;
      }
    }
    this.jdField_c_of_type_JavaUtilList.clear();
    i();
    l2 /= 1048576L;
    paramSet = new StringBuilder();
    paramSet.append("");
    paramSet.append(l1);
    paramSet = paramSet.toString();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(l2);
    ReportController.b(null, "dc00898", "", "", "0X800A0CC", "0X800A0CC", 3, 0, paramSet, ((StringBuilder)localObject).toString(), "", "");
  }
  
  public int[] a()
  {
    return new int[] { 1, 0 };
  }
  
  public void d()
  {
    this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilList.size();
    this.jdField_c_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    long l = FMDataCache.d() / 1048576L;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(l);
    ReportController.b(null, "dc00898", "", "", "0X800A0CB", "0X800A0CB", 3, 0, (String)localObject, localStringBuilder.toString(), "", "");
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
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a(this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.l();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnIndexChangedListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$OnSelectListener);
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    boolean bool = false;
    int i;
    if (localObject != null) {
      i = ((List)localObject).size();
    } else {
      i = 0;
    }
    localObject = a();
    if ((i == 0) || (this.jdField_a_of_type_Int < i)) {
      bool = true;
    }
    ((BaseFileAssistantActivity)localObject).e(bool);
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
    if (paramInt != 0)
    {
      if (paramInt == 1)
      {
        ReportController.b(null, "dc00898", "", "", "0X800A0C8", "0X800A0C8", 3, 0, "", "", "", "");
        if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
          this.jdField_c_of_type_JavaUtilLinkedHashMap.put(HardCodeUtil.a(2131698192), this.jdField_a_of_type_JavaUtilList);
        }
      }
    }
    else
    {
      ReportController.b(null, "dc00898", "", "", "0X800A0C9", "0X800A0C9", 3, 0, "", "", "", "");
      this.jdField_c_of_type_JavaUtilLinkedHashMap.putAll(this.jdField_a_of_type_JavaUtilLinkedHashMap);
    }
    i();
    setSelect(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelPicTabView
 * JD-Core Version:    0.7.0.1
 */