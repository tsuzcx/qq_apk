package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FilenameFilter;
import org.json.JSONArray;

class ChatFontJsPlugin$1$1
  implements FilenameFilter
{
  ChatFontJsPlugin$1$1(ChatFontJsPlugin.1 param1) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    if (paramString.endsWith(".ttf")) {
      paramString = paramFile.getAbsolutePath() + File.separatorChar + paramString;
    }
    try
    {
      if (new File(paramString).exists())
      {
        paramFile = paramFile.getAbsolutePath().split(File.separator);
        this.this$1.val$downloadedList.put(Integer.parseInt(paramFile[(paramFile.length - 1)]));
      }
      return false;
    }
    catch (Exception paramFile)
    {
      for (;;)
      {
        QLog.e("ChatFontJsPlugin", 1, "updateFontList listFile error: " + paramFile.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ChatFontJsPlugin.1.1
 * JD-Core Version:    0.7.0.1
 */