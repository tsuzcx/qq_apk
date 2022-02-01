package com.tencent.open.agent;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.widget.SlideDetectListView;

class BindGroupActivity$1
  implements Runnable
{
  BindGroupActivity$1(BindGroupActivity paramBindGroupActivity, String paramString, Bitmap paramBitmap) {}
  
  public void run()
  {
    int j = this.this$0.h.getChildCount();
    int i = 0;
    while (i < j)
    {
      BindGroupActivity.ViewHolder localViewHolder = (BindGroupActivity.ViewHolder)this.this$0.h.getChildAt(i).getTag();
      if ((localViewHolder != null) && (this.a.equals(localViewHolder.c)))
      {
        localViewHolder.a.setImageBitmap(this.b);
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupActivity.1
 * JD-Core Version:    0.7.0.1
 */