package com.tencent.mobileqq.filemanager.activity.cloudfile;

import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView.OnSelectListener;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;

class QfileCloudFileTabView$6
  implements QfilePinnedHeaderExpandableListView.OnSelectListener
{
  private boolean b;
  private int c;
  private int d;
  
  QfileCloudFileTabView$6(QfileCloudFileTabView paramQfileCloudFileTabView) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    this.b = false;
    this.c = -2147483648;
    this.d = 2147483647;
    WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)this.a.j.getChild(paramInt1, paramInt2);
    if (localWeiYunFileInfo == null) {
      return;
    }
    this.b = (FMDataCache.a(localWeiYunFileInfo) ^ true);
    if (QfileCloudFileTabView.a(this.a, localWeiYunFileInfo, this.b)) {
      this.a.o();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 != paramInt3) {
      return;
    }
    int i = Math.min(paramInt2, paramInt4);
    int j = Math.max(paramInt2, paramInt4);
    if (paramInt4 < paramInt2) {
      this.d = Math.min(paramInt4, this.d);
    } else {
      this.c = Math.max(paramInt4, this.c);
    }
    paramInt2 = i;
    QfileCloudFileTabView localQfileCloudFileTabView;
    while (paramInt2 <= j)
    {
      localQfileCloudFileTabView = this.a;
      QfileCloudFileTabView.a(localQfileCloudFileTabView, (WeiYunFileInfo)localQfileCloudFileTabView.j.getChild(paramInt1, paramInt2), this.b);
      paramInt2 += 1;
    }
    paramInt2 = this.d;
    for (;;)
    {
      paramInt3 = j;
      if (paramInt2 >= i) {
        break;
      }
      localQfileCloudFileTabView = this.a;
      QfileCloudFileTabView.a(localQfileCloudFileTabView, (WeiYunFileInfo)localQfileCloudFileTabView.j.getChild(paramInt1, paramInt2), this.b ^ true);
      paramInt2 += 1;
    }
    for (;;)
    {
      paramInt3 += 1;
      if (paramInt3 > this.c) {
        break;
      }
      localQfileCloudFileTabView = this.a;
      QfileCloudFileTabView.a(localQfileCloudFileTabView, (WeiYunFileInfo)localQfileCloudFileTabView.j.getChild(paramInt1, paramInt3), this.b ^ true);
    }
    this.a.o();
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView.6
 * JD-Core Version:    0.7.0.1
 */