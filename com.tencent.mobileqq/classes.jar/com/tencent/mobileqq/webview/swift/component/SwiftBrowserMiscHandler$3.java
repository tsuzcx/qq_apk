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
    Object localObject1;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(Environment.getExternalStorageDirectory());
      ((StringBuilder)localObject1).append("/tencent/MobileQQ/ShareScreenShots");
      localObject1 = new File(VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject1).toString()));
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("ShareScreenShot_");
      ((StringBuilder)localObject2).append(System.currentTimeMillis());
      ((StringBuilder)localObject2).append(".jpg");
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = ScreenShotUtil.a(this.jdField_a_of_type_AndroidGraphicsBitmap, (File)localObject1, (String)localObject2);
      this.this$0.a = true;
    }
    else
    {
      localObject1 = "";
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserMiscHandler$ScreenShotCallback;
    if (localObject2 != null) {
      ((SwiftBrowserMiscHandler.ScreenShotCallback)localObject2).a((String)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserMiscHandler.3
 * JD-Core Version:    0.7.0.1
 */