package com.tencent.mobileqq.webview.swift.component;

import android.os.Environment;
import arof;
import bduw;
import bedv;
import java.io.File;

public class SwiftBrowserMiscHandler$2
  implements Runnable
{
  public SwiftBrowserMiscHandler$2(bedv parambedv) {}
  
  public void run()
  {
    arof.a(new File(bduw.a(Environment.getExternalStorageDirectory() + "/tencent/MobileQQ/ShareScreenShots")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserMiscHandler.2
 * JD-Core Version:    0.7.0.1
 */