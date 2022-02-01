package com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview;

import com.tencent.mobileqq.filemanager.core.HttpThumbDownloader.ThumbEventCallback;
import com.tencent.qphone.base.util.QLog;

class GuildFileBubbleModel$5
  implements HttpThumbDownloader.ThumbEventCallback
{
  GuildFileBubbleModel$5(GuildFileBubbleModel paramGuildFileBubbleModel) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString1, boolean paramBoolean, int paramInt, String paramString2, long paramLong)
  {
    paramString1 = new StringBuilder();
    paramString1.append("preview download result: ");
    paramString1.append(paramInt);
    paramString1.append(" with sessionId = ");
    paramString1.append(paramLong);
    QLog.i("GuildFileBubbleModel", 1, paramString1.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.GuildFileBubbleModel.5
 * JD-Core Version:    0.7.0.1
 */