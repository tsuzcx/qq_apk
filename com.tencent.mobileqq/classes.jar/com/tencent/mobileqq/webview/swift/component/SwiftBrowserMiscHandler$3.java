package com.tencent.mobileqq.webview.swift.component;

import android.graphics.Bitmap;
import android.os.Environment;
import azyy;
import bbbg;
import bbbi;
import java.io.File;

public class SwiftBrowserMiscHandler$3
  implements Runnable
{
  public SwiftBrowserMiscHandler$3(bbbg parambbbg, Bitmap paramBitmap, bbbi parambbbi) {}
  
  public void run()
  {
    Object localObject = "";
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      localObject = new File(Environment.getExternalStorageDirectory(), "/tencent/MobileQQ/ShareScreenShots");
      String str = "ShareScreenShot_" + System.currentTimeMillis() + ".jpg";
      localObject = azyy.a(this.jdField_a_of_type_AndroidGraphicsBitmap, (File)localObject, str);
      this.this$0.a = true;
    }
    if (this.jdField_a_of_type_Bbbi != null) {
      this.jdField_a_of_type_Bbbi.a((String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserMiscHandler.3
 * JD-Core Version:    0.7.0.1
 */