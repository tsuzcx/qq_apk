package com.tencent.mobileqq.filemanager.guild;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.api.IFMSettings;
import com.tencent.mobileqq.filemanager.core.BaseThumbDownloader;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.ThumbHttpDownloader.DownloadTask;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.file.IGuildFileHandler;
import com.tencent.mobileqq.guild.file.IGuildPreviewThumbReqCallback;
import com.tencent.mobileqq.guild.file.UFTGuildPreviewThumbReq;
import com.tencent.mobileqq.guild.file.UFTGuildPreviewThumbRsp;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.securitysdk.utils.MD5;
import java.util.List;
import mqq.os.MqqHandler;

public class GuildFileVideoThumbDownloader
  extends BaseThumbDownloader
{
  private static int c;
  
  public GuildFileVideoThumbDownloader(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private GuildFileVideoThumbDownloader.VideoSession a(long paramLong, boolean paramBoolean)
  {
    Object localObject = b(paramLong);
    if ((localObject instanceof GuildFileVideoThumbDownloader.VideoSession)) {
      return (GuildFileVideoThumbDownloader.VideoSession)localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[downloadThumb] getSession  ID[");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("] no instance");
    QLog.e("GuildVideoThumbDownloader<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    return null;
  }
  
  private void a(GuildFileVideoThumbDownloader.VideoSession paramVideoSession, long paramLong, boolean paramBoolean, int paramInt, String paramString, ThumbHttpDownloader.DownloadTask paramDownloadTask)
  {
    paramVideoSession.b.strLargeThumPath = paramString;
    FileManagerUtil.n(paramVideoSession.b);
    this.a.getFileManagerDataCenter().c(paramVideoSession.b);
    QLog.d("GuildVideoThumbDownloader<FileAssistant>", 2, "download success");
    this.a.getFileManagerNotifyCenter().a(paramBoolean, 54, new Object[] { paramVideoSession.b, Integer.valueOf(GuildFileVideoThumbDownloader.VideoSession.c(paramVideoSession)) });
    super.a(paramLong, paramBoolean, paramInt, paramString, paramDownloadTask);
  }
  
  private boolean a(FileManagerEntity paramFileManagerEntity)
  {
    if ((paramFileManagerEntity != null) && (paramFileManagerEntity.Uuid != null))
    {
      if (a(paramFileManagerEntity.fileName) == -1)
      {
        this.a.getFileManagerNotifyCenter().a(false, 54, new Object[] { paramFileManagerEntity });
        return true;
      }
      return false;
    }
    QLog.e("GuildVideoThumbDownloader<FileAssistant>", 1, "[downloadThumb]  download. entity arg error");
    this.a.getFileManagerNotifyCenter().a(false, 54, new Object[] { paramFileManagerEntity });
    return true;
  }
  
  public static int b()
  {
    try
    {
      int i = c + 1;
      c = i;
      return i;
    }
    finally {}
  }
  
  private String b(FileManagerEntity paramFileManagerEntity, int paramInt1, int paramInt2)
  {
    Object localObject1 = paramFileManagerEntity.Uuid.replace("/", "");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(FMSettings.a().getDefaultThumbPath());
    ((StringBuilder)localObject2).append(a(paramInt1, (String)localObject1));
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append(paramInt2);
    localObject2 = ((StringBuilder)localObject2).toString();
    localObject1 = localObject2;
    if (!FileUtil.b((String)localObject2))
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramFileManagerEntity.strFileMd5))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(FMSettings.a().getDefaultThumbPath());
        ((StringBuilder)localObject1).append(a(paramInt1, MD5.b(paramFileManagerEntity.strFileMd5)));
        ((StringBuilder)localObject1).append("_");
        ((StringBuilder)localObject1).append(paramInt2);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    if (QLog.isColorLevel())
    {
      paramFileManagerEntity = new StringBuilder();
      paramFileManagerEntity.append("getThumbFilePath filePath = ");
      paramFileManagerEntity.append((String)localObject1);
      QLog.d("GuildVideoThumbDownloader<FileAssistant>", 2, paramFileManagerEntity.toString());
    }
    return localObject1;
  }
  
  private void b(GuildFileVideoThumbDownloader.VideoSession paramVideoSession, long paramLong, boolean paramBoolean, int paramInt, String paramString, ThumbHttpDownloader.DownloadTask paramDownloadTask)
  {
    if (paramInt == -11)
    {
      a(paramLong);
      int j = GuildFileVideoThumbDownloader.VideoSession.b(paramVideoSession);
      int i = 1000;
      if (j < 3000)
      {
        GuildFileVideoThumbDownloader.VideoSession.c(paramVideoSession, GuildFileVideoThumbDownloader.VideoSession.b(paramVideoSession) + 1000);
      }
      else
      {
        GuildFileVideoThumbDownloader.VideoSession.c(paramVideoSession, GuildFileVideoThumbDownloader.VideoSession.b(paramVideoSession) + 5000);
        i = 5000;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("download retry delaytime = ");
      localStringBuilder.append(i);
      QLog.d("GuildVideoThumbDownloader<FileAssistant>", 2, localStringBuilder.toString());
      if (GuildFileVideoThumbDownloader.VideoSession.b(paramVideoSession) < 30000)
      {
        ThreadManager.getUIHandler().postDelayed(new GuildFileVideoThumbDownloader.1(this, paramVideoSession), i);
        return;
      }
      QLog.d("GuildVideoThumbDownloader<FileAssistant>", 2, "retry over ! download failed");
    }
    this.a.getFileManagerNotifyCenter().a(paramBoolean, 54, new Object[] { paramVideoSession.b, Integer.valueOf(GuildFileVideoThumbDownloader.VideoSession.c(paramVideoSession)) });
    super.a(paramLong, paramBoolean, paramInt, paramString, paramDownloadTask);
  }
  
  private IGuildPreviewThumbReqCallback c(long paramLong)
  {
    return new GuildFileVideoThumbDownloader.2(this, paramLong);
  }
  
  public String a(FileManagerEntity paramFileManagerEntity, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("video download start thumbSize = ");
      ((StringBuilder)localObject).append(paramInt1);
      QLog.d("GuildVideoThumbDownloader<FileAssistant>", 2, ((StringBuilder)localObject).toString());
    }
    if (a(paramFileManagerEntity))
    {
      QLog.e("GuildVideoThumbDownloader<FileAssistant>", 1, "download entity error");
      return null;
    }
    Object localObject = b(paramFileManagerEntity, paramInt1, paramInt2);
    if (FileUtils.fileExistsAndNotEmpty((String)localObject))
    {
      if (QLog.isColorLevel())
      {
        paramFileManagerEntity = new StringBuilder();
        paramFileManagerEntity.append("fileExistsAndNotEmpty strThumbPath = ");
        paramFileManagerEntity.append((String)localObject);
        QLog.d("GuildVideoThumbDownloader<FileAssistant>", 2, paramFileManagerEntity.toString());
      }
      return localObject;
    }
    a();
    int i = a(paramFileManagerEntity.fileName);
    GuildFileVideoThumbDownloader.VideoSession localVideoSession = new GuildFileVideoThumbDownloader.VideoSession(paramFileManagerEntity);
    GuildFileVideoThumbDownloader.VideoSession.a(localVideoSession, paramInt1);
    GuildFileVideoThumbDownloader.VideoSession.b(localVideoSession, i);
    GuildFileVideoThumbDownloader.VideoSession.c(localVideoSession, paramInt2);
    a(localVideoSession, (String)localObject, false);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[downloadThumb] download  nSession[");
    ((StringBuilder)localObject).append(paramFileManagerEntity.nSessionId);
    ((StringBuilder)localObject).append("], ThumbDownloadId[");
    ((StringBuilder)localObject).append(localVideoSession.a);
    ((StringBuilder)localObject).append("]");
    QLog.i("GuildVideoThumbDownloader<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    return "";
  }
  
  public List<String> a(long paramLong, String paramString, int paramInt, boolean paramBoolean, List<String> paramList)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("onGetIPV6List call");
      paramString.append(paramLong);
      QLog.d("GuildVideoThumbDownloader<FileAssistant>", 2, paramString.toString());
    }
    return null;
  }
  
  public void a(long paramLong, HttpMsg paramHttpMsg)
  {
    paramHttpMsg.busiType = 10014;
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt, String paramString, ThumbHttpDownloader.DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDownloadCompleted suc");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("errorCode = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" taskId = ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" thumbPath = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("GuildVideoThumbDownloader<FileAssistant>", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = a(paramLong, false);
    if (localObject == null)
    {
      paramString = new StringBuilder();
      paramString.append("[downloadThumb]  ID[");
      paramString.append(paramLong);
      paramString.append("] onDownloadCompleted no this session");
      QLog.e("GuildVideoThumbDownloader<FileAssistant>", 2, paramString.toString());
      return;
    }
    if (paramBoolean)
    {
      a((GuildFileVideoThumbDownloader.VideoSession)localObject, paramLong, paramBoolean, paramInt, paramString, paramDownloadTask);
      return;
    }
    b((GuildFileVideoThumbDownloader.VideoSession)localObject, paramLong, paramBoolean, paramInt, paramString, paramDownloadTask);
  }
  
  public boolean a(long paramLong, ThumbHttpDownloader.DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel())
    {
      paramDownloadTask = new StringBuilder();
      paramDownloadTask.append("onGetDownloadUrl taskId = ");
      paramDownloadTask.append(paramLong);
      QLog.d("GuildVideoThumbDownloader<FileAssistant>", 2, paramDownloadTask.toString());
    }
    paramDownloadTask = a(paramLong, false);
    if ((paramDownloadTask != null) && (paramDownloadTask.b != null) && (!TextUtils.isEmpty(paramDownloadTask.b.guildId)) && (!TextUtils.isEmpty(paramDownloadTask.b.channelId)) && (!TextUtils.isEmpty(paramDownloadTask.b.Uuid)))
    {
      if (GuildFileVideoThumbDownloader.VideoSession.a(paramDownloadTask) != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("download retry onGetDownloadUrl");
        ((StringBuilder)localObject).append(GuildFileVideoThumbDownloader.VideoSession.b(paramDownloadTask));
        QLog.d("GuildVideoThumbDownloader<FileAssistant>", 2, ((StringBuilder)localObject).toString());
        a(paramLong, true, GuildFileVideoThumbDownloader.VideoSession.a(paramDownloadTask).c());
        return true;
      }
      IGuildFileHandler localIGuildFileHandler = (IGuildFileHandler)this.a.getBusinessHandler(((IGuildHandlerNameApi)QRoute.api(IGuildHandlerNameApi.class)).getGuildFileHandlerName());
      Object localObject = new UFTGuildPreviewThumbReq();
      ((UFTGuildPreviewThumbReq)localObject).a(b());
      ((UFTGuildPreviewThumbReq)localObject).b(4202);
      ((UFTGuildPreviewThumbReq)localObject).b(paramDownloadTask.b.channelId);
      ((UFTGuildPreviewThumbReq)localObject).c(paramDownloadTask.b.guildId);
      ((UFTGuildPreviewThumbReq)localObject).a(paramDownloadTask.b.Uuid);
      localIGuildFileHandler.a((UFTGuildPreviewThumbReq)localObject, c(paramLong));
      if (QLog.isColorLevel())
      {
        paramDownloadTask = new StringBuilder();
        paramDownloadTask.append("get video image thumb req guildId = ");
        paramDownloadTask.append(((UFTGuildPreviewThumbReq)localObject).e());
        paramDownloadTask.append(" channelId = ");
        paramDownloadTask.append(((UFTGuildPreviewThumbReq)localObject).d());
        paramDownloadTask.append("fileId = ");
        paramDownloadTask.append(((UFTGuildPreviewThumbReq)localObject).b());
        QLog.d("GuildVideoThumbDownloader<FileAssistant>", 2, paramDownloadTask.toString());
      }
      return true;
    }
    paramDownloadTask = new StringBuilder();
    paramDownloadTask.append("[downloadThumb]  ID[");
    paramDownloadTask.append(paramLong);
    paramDownloadTask.append("] onGetDownloadUrl no this session");
    QLog.e("GuildVideoThumbDownloader<FileAssistant>", 2, paramDownloadTask.toString());
    return false;
  }
  
  public void b(long paramLong, ThumbHttpDownloader.DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel())
    {
      paramDownloadTask = new StringBuilder();
      paramDownloadTask.append("onRetryDownload call");
      paramDownloadTask.append(paramLong);
      QLog.d("GuildVideoThumbDownloader<FileAssistant>", 2, paramDownloadTask.toString());
    }
  }
  
  public void c(long paramLong, ThumbHttpDownloader.DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel())
    {
      paramDownloadTask = new StringBuilder();
      paramDownloadTask.append("onChangeUrlDownload call");
      paramDownloadTask.append(paramLong);
      QLog.d("GuildVideoThumbDownloader<FileAssistant>", 2, paramDownloadTask.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.guild.GuildFileVideoThumbDownloader
 * JD-Core Version:    0.7.0.1
 */