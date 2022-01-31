package com.tencent.mobileqq.webview.swift.component;

import android.os.Environment;
import apvd;
import bbvj;
import bceu;
import java.io.File;

public class SwiftBrowserMiscHandler$2
  implements Runnable
{
  public SwiftBrowserMiscHandler$2(bceu parambceu) {}
  
  public void run()
  {
    apvd.a(new File(bbvj.a(Environment.getExternalStorageDirectory() + "/tencent/MobileQQ/ShareScreenShots")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserMiscHandler.2
 * JD-Core Version:    0.7.0.1
 */