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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory());
    localStringBuilder.append("/tencent/MobileQQ/ShareScreenShots");
    FileUtil.a(new File(VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString())));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserMiscHandler.2
 * JD-Core Version:    0.7.0.1
 */