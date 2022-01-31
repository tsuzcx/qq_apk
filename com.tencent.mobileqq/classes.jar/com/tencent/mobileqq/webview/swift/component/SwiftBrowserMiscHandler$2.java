package com.tencent.mobileqq.webview.swift.component;

import android.os.Environment;
import apdh;
import bbbg;
import java.io.File;

public class SwiftBrowserMiscHandler$2
  implements Runnable
{
  public SwiftBrowserMiscHandler$2(bbbg parambbbg) {}
  
  public void run()
  {
    apdh.a(new File(Environment.getExternalStorageDirectory(), "/tencent/MobileQQ/ShareScreenShots"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserMiscHandler.2
 * JD-Core Version:    0.7.0.1
 */