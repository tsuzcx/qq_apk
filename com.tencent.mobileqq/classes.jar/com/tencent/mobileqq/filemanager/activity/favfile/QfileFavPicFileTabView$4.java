package com.tencent.mobileqq.filemanager.activity.favfile;

import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView.OnSelectListener;

class QfileFavPicFileTabView$4
  implements QfilePinnedHeaderExpandableListView.OnSelectListener
{
  private boolean b;
  private int c;
  private int d;
  
  QfileFavPicFileTabView$4(QfileFavPicFileTabView paramQfileFavPicFileTabView) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    this.b = false;
    this.c = -2147483648;
    this.d = 2147483647;
    FavFileInfo localFavFileInfo = (FavFileInfo)this.a.e.getChild(paramInt1, paramInt2);
    if (localFavFileInfo == null) {
      return;
    }
    this.b = (FMDataCache.c(localFavFileInfo) ^ true);
    if (QfileFavPicFileTabView.a(this.a, localFavFileInfo, this.b)) {
      this.a.s();
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
    QfileFavPicFileTabView localQfileFavPicFileTabView;
    while (paramInt2 <= j)
    {
      localQfileFavPicFileTabView = this.a;
      QfileFavPicFileTabView.a(localQfileFavPicFileTabView, (FavFileInfo)localQfileFavPicFileTabView.e.getChild(paramInt1, paramInt2), this.b);
      paramInt2 += 1;
    }
    paramInt2 = this.d;
    for (;;)
    {
      paramInt3 = j;
      if (paramInt2 >= i) {
        break;
      }
      localQfileFavPicFileTabView = this.a;
      QfileFavPicFileTabView.a(localQfileFavPicFileTabView, (FavFileInfo)localQfileFavPicFileTabView.e.getChild(paramInt1, paramInt2), this.b ^ true);
      paramInt2 += 1;
    }
    for (;;)
    {
      paramInt3 += 1;
      if (paramInt3 > this.c) {
        break;
      }
      localQfileFavPicFileTabView = this.a;
      QfileFavPicFileTabView.a(localQfileFavPicFileTabView, (FavFileInfo)localQfileFavPicFileTabView.e.getChild(paramInt1, paramInt3), this.b ^ true);
    }
    this.a.s();
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavPicFileTabView.4
 * JD-Core Version:    0.7.0.1
 */