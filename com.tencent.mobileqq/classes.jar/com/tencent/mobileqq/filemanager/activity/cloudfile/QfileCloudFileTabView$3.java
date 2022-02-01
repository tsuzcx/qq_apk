package com.tencent.mobileqq.filemanager.activity.cloudfile;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class QfileCloudFileTabView$3
  extends FMObserver
{
  QfileCloudFileTabView$3(QfileCloudFileTabView paramQfileCloudFileTabView) {}
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    super.a(paramInt, paramString1, paramString2);
    this.a.c(false);
  }
  
  public void a(Integer paramInteger, long paramLong, String paramString)
  {
    FileManagerUtil.a(paramLong, paramInteger.intValue(), paramString);
  }
  
  public void a(String paramString1, boolean paramBoolean, int paramInt1, String paramString2, List<WeiYunFileInfo> paramList, int paramInt2)
  {
    QfileCloudFileTabView.b(this.a, true);
    QfileCloudFileTabView.c(this.a, paramBoolean);
    this.a.jdField_c_of_type_Int = paramInt2;
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)localIterator.next();
      paramInt1 = FileManagerUtil.a(localWeiYunFileInfo.jdField_c_of_type_JavaLangString);
      String str;
      if (paramInt1 == 0)
      {
        str = QfileCloudFileTabView.a(this.a).getFileManagerEngine().a(localWeiYunFileInfo.jdField_a_of_type_JavaLangString, localWeiYunFileInfo.e, 3, localWeiYunFileInfo);
        if (str != null) {
          localWeiYunFileInfo.h = str;
        }
      }
      else if (2 == paramInt1)
      {
        str = QfileCloudFileTabView.b(this.a).getFileManagerEngine().b(localWeiYunFileInfo.jdField_a_of_type_JavaLangString, localWeiYunFileInfo.e, 2, localWeiYunFileInfo);
        if (str != null) {
          localWeiYunFileInfo.h = str;
        }
      }
    }
    if (!paramString1.equals(this.a.jdField_a_of_type_JavaLangString)) {
      return;
    }
    if (QfileCloudFileTabView.b(this.a)) {
      this.a.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    this.a.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    if (!this.a.jdField_a_of_type_JavaLangString.equalsIgnoreCase("picture")) {
      this.a.setListFooter();
    }
    this.a.jdField_c_of_type_JavaLangString = paramString2;
    this.a.jdField_c_of_type_Boolean = true;
    this.a.g();
    this.a.a();
  }
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView.3
 * JD-Core Version:    0.7.0.1
 */