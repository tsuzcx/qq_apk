package com.tencent.mobileqq.filemanager.activity;

import android.os.AsyncTask;
import com.tencent.mobileqq.filemanager.data.FileCategoryAdapter;
import com.tencent.mobileqq.filemanager.data.FileCategoryEntity;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import java.util.Iterator;
import java.util.List;

class FMLocalFileActivity$1
  extends AsyncTask<Void, Void, Integer>
{
  FMLocalFileActivity$1(FMLocalFileActivity paramFMLocalFileActivity) {}
  
  protected Integer a(Void... paramVarArgs)
  {
    return Integer.valueOf(FileCategoryUtil.f(this.a));
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    this.a.stopTitleProgress();
    Iterator localIterator = this.a.G.iterator();
    while (localIterator.hasNext())
    {
      FileCategoryEntity localFileCategoryEntity = (FileCategoryEntity)localIterator.next();
      if (localFileCategoryEntity.g == 4)
      {
        localFileCategoryEntity.e = paramInteger.intValue();
        this.a.I.notifyDataSetChanged();
      }
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    this.a.startTitleProgress();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FMLocalFileActivity.1
 * JD-Core Version:    0.7.0.1
 */