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
    this.a.x = paramInt2;
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)localIterator.next();
      paramInt1 = QQFileManagerUtil.k(localWeiYunFileInfo.c);
      String str;
      if (paramInt1 == 0)
      {
        str = ((IQQFileEngine)QfileCloudFileTabView.b(this.a).getRuntimeService(IQQFileEngine.class)).getWeiYunPicThumb(localWeiYunFileInfo.a, localWeiYunFileInfo.i, 3, localWeiYunFileInfo);
        if (str != null) {
          localWeiYunFileInfo.l = str;
        }
      }
      else if (2 == paramInt1)
      {
        str = ((IQQFileEngine)QfileCloudFileTabView.c(this.a).getRuntimeService(IQQFileEngine.class)).getWeiYunVideoThumb(localWeiYunFileInfo.a, localWeiYunFileInfo.i, 2, localWeiYunFileInfo);
        if (str != null) {
          localWeiYunFileInfo.l = str;
        }
      }
    }
    if (!paramString1.equals(this.a.a)) {
      return;
    }
    if (QfileCloudFileTabView.d(this.a)) {
      this.a.i.clear();
    }
    this.a.i.addAll(paramList);
    if (!this.a.a.equalsIgnoreCase("picture")) {
      this.a.setListFooter();
    }
    paramString1 = this.a;
    paramString1.y = paramString2;
    paramString1.A = true;
    paramString1.g();
    this.a.getRecentFileRecords();
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    this.a.j.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView.3
 * JD-Core Version:    0.7.0.1
 */