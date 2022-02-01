package com.tencent.mobileqq.filemanager.activity.cloudfile;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class QfileCloudFileTabView$3
  extends FMObserver
{
  QfileCloudFileTabView$3(QfileCloudFileTabView paramQfileCloudFileTabView) {}
  
  protected void a(int paramInt, String paramString1, String paramString2)
  {
    super.a(paramInt, paramString1, paramString2);
    this.a.c(false);
  }
  
  protected void a(Integer paramInteger, long paramLong, String paramString)
  {
    QQFileManagerUtil.a(paramLong, paramInteger.intValue(), paramString);
  }
  
  protected void a(String paramString1, boolean paramBoolean, int paramInt1, String paramString2, List<WeiYunFileInfo> paramList, int paramInt2)
  {
    QfileCloudFileTabView.b(this.a, true);
    QfileCloudFileTabView.c(this.a, paramBoolean);
    this.a.jdField_c_of_type_Int = paramInt2;
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)localIterator.next();
      paramInt1 = QQFileManagerUtil.b(localWeiYunFileInfo.jdField_c_of_type_JavaLangString);
      String str;
      if (paramInt1 == 0)
      {
        str = ((IQQFileEngine)QfileCloudFileTabView.a(this.a).getRuntimeService(IQQFileEngine.class)).getWeiYunPicThumb(localWeiYunFileInfo.jdField_a_of_type_JavaLangString, localWeiYunFileInfo.e, 3, localWeiYunFileInfo);
        if (str != null) {
          localWeiYunFileInfo.h = str;
        }
      }
      else if (2 == paramInt1)
      {
        str = ((IQQFileEngine)QfileCloudFileTabView.b(this.a).getRuntimeService(IQQFileEngine.class)).getWeiYunVideoThumb(localWeiYunFileInfo.jdField_a_of_type_JavaLangString, localWeiYunFileInfo.e, 2, localWeiYunFileInfo);
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
    paramString1 = this.a;
    paramString1.jdField_c_of_type_JavaLangString = paramString2;
    paramString1.jdField_c_of_type_Boolean = true;
    paramString1.g();
    this.a.a();
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView.3
 * JD-Core Version:    0.7.0.1
 */