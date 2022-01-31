package com.tencent.mobileqq.vaswebviewplugin;

import java.io.File;
import java.io.FilenameFilter;
import org.json.JSONArray;

class ChatFontJsPlugin$1
  implements FilenameFilter
{
  ChatFontJsPlugin$1(ChatFontJsPlugin paramChatFontJsPlugin, JSONArray paramJSONArray) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    paramFile = new File(paramFile.getAbsolutePath() + File.separatorChar + paramString);
    if (paramFile.isDirectory()) {
      paramFile.listFiles(new ChatFontJsPlugin.1.1(this));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ChatFontJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */