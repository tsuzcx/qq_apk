package com.tencent.mobileqq.webview.swift.component;

import android.graphics.Bitmap;
import android.os.Environment;
import bhin;
import bigv;
import biqd;
import biqf;
import java.io.File;

public class SwiftBrowserMiscHandler$3
  implements Runnable
{
  public SwiftBrowserMiscHandler$3(biqd parambiqd, Bitmap paramBitmap, biqf parambiqf) {}
  
  public void run()
  {
    Object localObject = "";
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      localObject = new File(bigv.a(Environment.getExternalStorageDirectory() + "/tencent/MobileQQ/ShareScreenShots"));
      String str = "ShareScreenShot_" + System.currentTimeMillis() + ".jpg";
      localObject = bhin.a(this.jdField_a_of_type_AndroidGraphicsBitmap, (File)localObject, str);
      this.this$0.a = true;
    }
    if (this.jdField_a_of_type_Biqf != null) {
      this.jdField_a_of_type_Biqf.a((String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserMiscHandler.3
 * JD-Core Version:    0.7.0.1
 */