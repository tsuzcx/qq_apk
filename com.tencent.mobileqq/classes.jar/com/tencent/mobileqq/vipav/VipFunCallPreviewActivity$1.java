package com.tencent.mobileqq.vipav;

import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.vas.vipav.VipFullScreenVideoView;

class VipFunCallPreviewActivity$1
  extends Handler
{
  VipFunCallPreviewActivity$1(VipFunCallPreviewActivity paramVipFunCallPreviewActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 50)
    {
      if (i != 51) {
        return;
      }
      if ((paramMessage.obj != null) && ((paramMessage.obj instanceof BitmapDrawable)))
      {
        RelativeLayout localRelativeLayout = (RelativeLayout)this.a.findViewById(2131449924);
        BitmapDrawable localBitmapDrawable = (BitmapDrawable)paramMessage.obj;
        if ((localBitmapDrawable != null) && (localRelativeLayout != null))
        {
          localRelativeLayout.setBackgroundDrawable(localBitmapDrawable);
          if (paramMessage.arg1 == 1) {
            this.a.d.setBackgroundDrawable(localBitmapDrawable);
          }
        }
      }
    }
    else
    {
      VipFunCallPreviewActivity.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vipav.VipFunCallPreviewActivity.1
 * JD-Core Version:    0.7.0.1
 */