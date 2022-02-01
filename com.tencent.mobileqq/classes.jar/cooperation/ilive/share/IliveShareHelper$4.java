package cooperation.ilive.share;

import android.graphics.Bitmap;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import java.util.Map;

class IliveShareHelper$4
  implements Runnable
{
  IliveShareHelper$4(IliveShareHelper paramIliveShareHelper, Map paramMap, String paramString1, String paramString2, String paramString3, int paramInt) {}
  
  public void run()
  {
    if ((IliveShareHelper.access$500(this.this$0) != null) && (IliveShareHelper.access$500(this.this$0).isShowing())) {
      IliveShareHelper.access$500(this.this$0).dismiss();
    }
    IliveShareHelper.access$602(this.this$0, String.valueOf(System.currentTimeMillis()));
    Bitmap localBitmap = (Bitmap)this.val$wrapper.remove("image");
    WXShareHelper localWXShareHelper = WXShareHelper.a();
    String str1 = IliveShareHelper.access$600(this.this$0);
    String str2 = this.val$title;
    String str3 = this.val$desc;
    String str4 = this.val$shareUrl;
    int i;
    if (this.val$shareType == 9) {
      i = 0;
    } else {
      i = 1;
    }
    localWXShareHelper.a(str1, str2, localBitmap, str3, str4, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.share.IliveShareHelper.4
 * JD-Core Version:    0.7.0.1
 */