package com.tencent.open.agent;

import android.app.Activity;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.virtual.OpenSdkVirtualUtil;

class BaseAuthorityAccountView$5
  implements Runnable
{
  BaseAuthorityAccountView$5(BaseAuthorityAccountView paramBaseAuthorityAccountView, String paramString, ImageView paramImageView) {}
  
  public void run()
  {
    Bitmap localBitmap = OpenSdkVirtualUtil.a(this.a, 58, true);
    if (this.this$0.c == null)
    {
      SSOLog.b("BaseAuthorityAccountView", new Object[] { "-->updateAccountFace mContext == null" });
      return;
    }
    ((Activity)this.this$0.c).runOnUiThread(new BaseAuthorityAccountView.5.1(this, localBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.BaseAuthorityAccountView.5
 * JD-Core Version:    0.7.0.1
 */