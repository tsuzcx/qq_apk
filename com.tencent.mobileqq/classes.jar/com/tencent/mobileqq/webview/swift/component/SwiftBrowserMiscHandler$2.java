package com.tencent.mobileqq.webview.swift.component;

import android.os.Environment;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import java.io.File;

class SwiftBrowserMiscHandler$2
  implements Runnable
{
  SwiftBrowserMiscHandler$2(SwiftBrowserMiscHandler paramSwiftBrowserMiscHandler) {}
  
  public void run()
  {
    FileUtil.a(new File(VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory() + "/tencent/MobileQQ/ShareScreenShots")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserMiscHandler.2
 * JD-Core Version:    0.7.0.1
 */