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
    if (paramString.endsWith(".ttf"))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramFile.getAbsolutePath());
      localStringBuilder.append(File.separatorChar);
      localStringBuilder.append(paramString);
      paramString = localStringBuilder.toString();
      try
      {
        if (new File(paramString).exists())
        {
          paramFile = paramFile.getAbsolutePath().split(File.separator);
          this.this$1.val$downloadedList.put(Integer.parseInt(paramFile[(paramFile.length - 1)]));
        }
      }
      catch (Exception paramFile)
      {
        paramString = new StringBuilder();
        paramString.append("updateFontList listFile error: ");
        paramString.append(paramFile.getMessage());
        QLog.e("ChatFontJsPlugin", 1, paramString.toString());
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ChatFontJsPlugin.1.1
 * JD-Core Version:    0.7.0.1
 */