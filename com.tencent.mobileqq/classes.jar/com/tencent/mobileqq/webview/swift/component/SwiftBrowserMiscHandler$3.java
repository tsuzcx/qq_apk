package com.tencent.mobileqq.webview.swift.component;

import android.graphics.Bitmap;
import android.os.Environment;
import bhao;
import bihb;
import bihd;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import java.io.File;

public class SwiftBrowserMiscHandler$3
  implements Runnable
{
  public SwiftBrowserMiscHandler$3(bihb parambihb, Bitmap paramBitmap, bihd parambihd) {}
  
  public void run()
  {
    Object localObject = "";
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      localObject = new File(VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory() + "/tencent/MobileQQ/ShareScreenShots"));
      String str = "ShareScreenShot_" + System.currentTimeMillis() + ".jpg";
      localObject = bhao.a(this.jdField_a_of_type_AndroidGraphicsBitmap, (File)localObject, str);
      this.this$0.a = true;
    }
    if (this.jdField_a_of_type_Bihd != null) {
      this.jdField_a_of_type_Bihd.a((String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserMiscHandler.3
 * JD-Core Version:    0.7.0.1
 */