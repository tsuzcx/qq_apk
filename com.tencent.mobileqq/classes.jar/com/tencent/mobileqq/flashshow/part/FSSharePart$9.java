package com.tencent.mobileqq.flashshow.part;

import android.graphics.Bitmap;
import com.tencent.mobileqq.flashshow.widgets.share.FSProgressDialog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wxapi.api.IWXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class FSSharePart$9
  implements Runnable
{
  FSSharePart$9(FSSharePart paramFSSharePart, Map paramMap, boolean paramBoolean, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    if ((FSSharePart.k(this.this$0) != null) && (FSSharePart.k(this.this$0).isShowing())) {
      FSSharePart.k(this.this$0).dismiss();
    }
    FSSharePart.a(this.this$0, String.valueOf(System.currentTimeMillis()));
    Bitmap localBitmap = (Bitmap)this.a.remove("image");
    FSSharePart.c(this.this$0, true);
    if (this.b) {
      ((IWXShareHelper)QRoute.api(IWXShareHelper.class)).shareTroopToWXFriend(FSSharePart.l(this.this$0), this.c, localBitmap, this.d, this.e);
    } else {
      ((IWXShareHelper)QRoute.api(IWXShareHelper.class)).shareTroopToWXFriendCircle(FSSharePart.l(this.this$0), this.c, localBitmap, this.d, this.e);
    }
    QLog.d("FSSharePart", 1, "shareToWeChat success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSSharePart.9
 * JD-Core Version:    0.7.0.1
 */