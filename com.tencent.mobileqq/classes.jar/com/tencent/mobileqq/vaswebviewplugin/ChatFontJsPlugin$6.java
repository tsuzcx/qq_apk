package com.tencent.mobileqq.vaswebviewplugin;

import java.io.File;
import java.io.FilenameFilter;

class ChatFontJsPlugin$6
  implements FilenameFilter
{
  ChatFontJsPlugin$6(ChatFontJsPlugin paramChatFontJsPlugin) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return new File(paramFile.getAbsolutePath() + File.separator + paramString).isDirectory();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ChatFontJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */