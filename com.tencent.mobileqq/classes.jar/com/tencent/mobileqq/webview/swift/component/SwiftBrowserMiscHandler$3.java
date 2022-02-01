package com.tencent.mobileqq.webview.swift.component;

import android.graphics.Bitmap;
import android.os.Environment;
import com.tencent.mobileqq.util.ScreenShotUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import java.io.File;

class SwiftBrowserMiscHandler$3
  implements Runnable
{
  SwiftBrowserMiscHandler$3(SwiftBrowserMiscHandler paramSwiftBrowserMiscHandler, Bitmap paramBitmap, SwiftBrowserMiscHandler.ScreenShotCallback paramScreenShotCallback) {}
  
  public void run()
  {
    Object localObject = "";
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      localObject = new File(VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory() + "/tencent/MobileQQ/ShareScreenShots"));
      String str = "ShareScreenShot_" + System.currentTimeMillis() + ".jpg";
      localObject = ScreenShotUtil.a(this.jdField_a_of_type_AndroidGraphicsBitmap, (File)localObject, str);
      this.this$0.a = true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserMiscHandler$ScreenShotCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserMiscHandler$ScreenShotCallback.a((String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserMiscHandler.3
 * JD-Core Version:    0.7.0.1
 */