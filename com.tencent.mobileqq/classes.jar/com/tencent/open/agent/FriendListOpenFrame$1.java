package com.tencent.open.agent;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.widget.PinnedDividerListView;

class FriendListOpenFrame$1
  extends Handler
{
  FriendListOpenFrame$1(FriendListOpenFrame paramFriendListOpenFrame) {}
  
  public void handleMessage(Message paramMessage)
  {
    int j = paramMessage.what;
    int i = 0;
    if (j != 1)
    {
      if (j != 2)
      {
        if (j != 3) {
          return;
        }
        String str = paramMessage.getData().getString("url");
        paramMessage = (Bitmap)paramMessage.obj;
        j = this.a.a.getChildCount();
        while (i < j)
        {
          FriendListOpenFrame.ViewHolder localViewHolder = (FriendListOpenFrame.ViewHolder)this.a.a.getChildAt(i).getTag();
          if ((localViewHolder != null) && (str.equals(localViewHolder.f)))
          {
            localViewHolder.c.setImageBitmap(paramMessage);
            return;
          }
          i += 1;
        }
      }
      this.a.e.setPadding(0, 0, 0, 0);
      return;
    }
    this.a.e.setPadding(0, 0, 40, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.FriendListOpenFrame.1
 * JD-Core Version:    0.7.0.1
 */