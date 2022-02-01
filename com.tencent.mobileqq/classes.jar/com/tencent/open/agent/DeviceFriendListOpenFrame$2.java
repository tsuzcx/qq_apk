package com.tencent.open.agent;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.widget.PinnedDividerListView;

class DeviceFriendListOpenFrame$2
  implements Runnable
{
  DeviceFriendListOpenFrame$2(DeviceFriendListOpenFrame paramDeviceFriendListOpenFrame, String paramString, Bitmap paramBitmap) {}
  
  public void run()
  {
    int j = this.this$0.b.getChildCount();
    int i = 0;
    while (i < j)
    {
      DeviceFriendListOpenFrame.ViewHolder localViewHolder = (DeviceFriendListOpenFrame.ViewHolder)this.this$0.b.getChildAt(i).getTag();
      if ((localViewHolder != null) && (this.a.equals(localViewHolder.f)))
      {
        localViewHolder.c.setImageBitmap(this.b);
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.DeviceFriendListOpenFrame.2
 * JD-Core Version:    0.7.0.1
 */