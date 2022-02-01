package com.tencent.mobileqq.filemanager.activity;

import com.tencent.biz.troop.file.ZipFilesListAdapter;
import com.tencent.mobileqq.filemanager.app.FMObserver;

class TroopFileZipPreviewActivity$4
  extends FMObserver
{
  TroopFileZipPreviewActivity$4(TroopFileZipPreviewActivity paramTroopFileZipPreviewActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, String paramString1, String paramString2)
  {
    if ((paramBoolean) && (this.a.a != null)) {
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.TroopFileZipPreviewActivity.4
 * JD-Core Version:    0.7.0.1
 */