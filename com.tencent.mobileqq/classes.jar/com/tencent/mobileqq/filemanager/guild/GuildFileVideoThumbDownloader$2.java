package com.tencent.mobileqq.filemanager.guild;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.guild.file.IGuildPreviewThumbReqCallback;
import com.tencent.mobileqq.guild.file.UFTGuildPreviewThumbRsp;
import com.tencent.qphone.base.util.QLog;

class GuildFileVideoThumbDownloader$2
  implements IGuildPreviewThumbReqCallback
{
  GuildFileVideoThumbDownloader$2(GuildFileVideoThumbDownloader paramGuildFileVideoThumbDownloader, long paramLong) {}
  
  public void a(boolean paramBoolean, UFTGuildPreviewThumbRsp paramUFTGuildPreviewThumbRsp)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPreviewThumbReqCallback isSucc = ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" taskId = ");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("GuildVideoThumbDownloader<FileAssistant>", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = GuildFileVideoThumbDownloader.a(this.b, this.a, false);
    if ((paramBoolean) && (paramUFTGuildPreviewThumbRsp != null) && (!TextUtils.isEmpty(paramUFTGuildPreviewThumbRsp.c())))
    {
      if (localObject == null)
      {
        GuildFileVideoThumbDownloader.b(this.b, this.a);
        GuildFileVideoThumbDownloader.b(this.b, this.a, false, null, 0, null, null, null, false, null, (short)0, null);
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onPreviewThumbReqCallback onGetDownloadUrl + isSucc = ");
        localStringBuilder.append(paramBoolean);
        localStringBuilder.append(" taskId = ");
        localStringBuilder.append(this.a);
        localStringBuilder.append(" url = ");
        localStringBuilder.append(paramUFTGuildPreviewThumbRsp.c());
        QLog.d("GuildVideoThumbDownloader<FileAssistant>", 2, localStringBuilder.toString());
      }
      GuildFileVideoThumbDownloader.VideoSession.a((GuildFileVideoThumbDownloader.VideoSession)localObject, paramUFTGuildPreviewThumbRsp);
      GuildFileVideoThumbDownloader.a(this.b, this.a, paramBoolean, paramUFTGuildPreviewThumbRsp.c());
      return;
    }
    boolean bool = true;
    if (localObject != null) {
      GuildFileVideoThumbDownloader.a(this.b).getFileManagerNotifyCenter().a(false, 54, new Object[] { ((GuildFileVideoThumbDownloader.VideoSession)localObject).b });
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onPreviewThumbReqCallback isSucc = ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(" previewThumbRsp null ? = ");
    ((StringBuilder)localObject).append(paramUFTGuildPreviewThumbRsp);
    if (((StringBuilder)localObject).toString() == null) {
      paramBoolean = bool;
    } else {
      paramBoolean = false;
    }
    QLog.e("GuildVideoThumbDownloader<FileAssistant>", 2, new Object[] { Boolean.valueOf(paramBoolean) });
    GuildFileVideoThumbDownloader.a(this.b, this.a);
    GuildFileVideoThumbDownloader.a(this.b, this.a, false, null, 0, null, null, null, false, null, (short)0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.guild.GuildFileVideoThumbDownloader.2
 * JD-Core Version:    0.7.0.1
 */