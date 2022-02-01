package com.tencent.mobileqq.filemanager.activity.localfile;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView.OnSelectListener;

class QfileLocalFilePicTabView$4
  implements QfilePinnedHeaderExpandableListView.OnSelectListener
{
  private boolean b;
  private int c;
  private int d;
  
  QfileLocalFilePicTabView$4(QfileLocalFilePicTabView paramQfileLocalFilePicTabView) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    this.b = false;
    this.c = -2147483648;
    this.d = 2147483647;
    FileInfo localFileInfo = (FileInfo)this.a.w.getChild(paramInt1, paramInt2);
    if (localFileInfo == null) {
      return;
    }
    this.b = (FMDataCache.a(localFileInfo) ^ true);
    if (QfileLocalFilePicTabView.a(this.a, localFileInfo, this.b)) {
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
    QfileLocalFilePicTabView localQfileLocalFilePicTabView;
    while (paramInt2 <= j)
    {
      localQfileLocalFilePicTabView = this.a;
      QfileLocalFilePicTabView.a(localQfileLocalFilePicTabView, (FileInfo)localQfileLocalFilePicTabView.w.getChild(paramInt1, paramInt2), this.b);
      paramInt2 += 1;
    }
    paramInt2 = this.d;
    for (;;)
    {
      paramInt3 = j;
      if (paramInt2 >= i) {
        break;
      }
      localQfileLocalFilePicTabView = this.a;
      QfileLocalFilePicTabView.a(localQfileLocalFilePicTabView, (FileInfo)localQfileLocalFilePicTabView.w.getChild(paramInt1, paramInt2), this.b ^ true);
      paramInt2 += 1;
    }
    for (;;)
    {
      paramInt3 += 1;
      if (paramInt3 > this.c) {
        break;
      }
      localQfileLocalFilePicTabView = this.a;
      QfileLocalFilePicTabView.a(localQfileLocalFilePicTabView, (FileInfo)localQfileLocalFilePicTabView.w.getChild(paramInt1, paramInt3), this.b ^ true);
    }
    this.a.o();
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      URLDrawable.pause();
      return;
    }
    URLDrawable.resume();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((this.a.C.F()) || (this.a.C.G()))
    {
      SharedPreferences.Editor localEditor = this.a.C.getSharedPreferences("LAST_CHOOSE_", 0).edit();
      localEditor.putInt("GROUP", paramInt1);
      localEditor.putInt("CHILD", (paramInt2 + 1) / 4);
      localEditor.commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView.4
 * JD-Core Version:    0.7.0.1
 */