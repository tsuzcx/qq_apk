package com.tencent.mobileqq.musicgene;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;

class MusicPlayerActivity$1$1
  implements AdapterView.OnItemClickListener
{
  MusicPlayerActivity$1$1(MusicPlayerActivity.1 param1, MusicPlayerActivity.ShareInfo paramShareInfo) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if ((paramInt == 2) || (paramInt == 3)) {
          ThreadManager.post(new MusicPlayerActivity.1.1.1(this, paramInt), 8, null, true);
        }
      }
      else {
        MusicPlayerActivity.b(this.b.a, this.a.a, this.a.b, this.a.d, this.a.c, this.a.e);
      }
    }
    else {
      MusicPlayerActivity.a(this.b.a, this.a.a, this.a.b, this.a.d, this.a.c, this.a.e);
    }
    MusicPlayerActivity.1.a(this.b).dismiss();
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.musicgene.MusicPlayerActivity.1.1
 * JD-Core Version:    0.7.0.1
 */