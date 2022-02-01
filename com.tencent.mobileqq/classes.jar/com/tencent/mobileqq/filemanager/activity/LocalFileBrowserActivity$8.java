package com.tencent.mobileqq.filemanager.activity;

import android.view.View;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;

class LocalFileBrowserActivity$8
  implements AdapterView.OnItemClickListener
{
  LocalFileBrowserActivity$8(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (FileInfo)this.a.b.get(paramInt);
    if (paramAdapterView.d())
    {
      LocalFileBrowserActivity.a(this.a, paramAdapterView.c(), true);
      return;
    }
    if (this.a.f())
    {
      if (FMDataCache.a(paramAdapterView))
      {
        FMDataCache.b(paramAdapterView);
      }
      else
      {
        if (this.a.h) {
          FMDataCache.b();
        }
        FMDataCache.a(paramAdapterView);
      }
      this.a.l();
      LocalFileBrowserActivity.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity.8
 * JD-Core Version:    0.7.0.1
 */