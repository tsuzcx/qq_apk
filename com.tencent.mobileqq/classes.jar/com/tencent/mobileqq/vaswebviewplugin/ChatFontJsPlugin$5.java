package com.tencent.mobileqq.vaswebviewplugin;

import java.io.File;
import java.io.FilenameFilter;

class ChatFontJsPlugin$5
  implements FilenameFilter
{
  ChatFontJsPlugin$5(ChatFontJsPlugin paramChatFontJsPlugin) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramFile.getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    return new File(localStringBuilder.toString()).isDirectory();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ChatFontJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */