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
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0xfc2.oidb_0xfc2.Addr;

public class GuildFileImageThumbDownloader
  extends BaseThumbDownloader
{
  private static int c;
  
  public GuildFileImageThumbDownloader(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private GuildFileImageThumbDownloader.PicSession a(long paramLong, boolean paramBoolean)
  {
    Object localObject = b(paramLong);
    if ((localObject instanceof GuildFileImageThumbDownloader.PicSession)) {
      return (GuildFileImageThumbDownloader.PicSession)localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[downloadThumb] getSession  ID[");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("] no instance");
    QLog.e("GuildImageThumbDownloader<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    return null;
  }
  
  private void a(int paramInt, GuildFileImageThumbDownloader.PicSession paramPicSession, ThumbHttpDownloader.DownloadTask paramDownloadTask)
  {
    paramDownloadTask = new StringBuilder();
    paramDownloadTask.append("handleDownloadCompletedError sessionId = ");
    paramDownloadTask.append(paramPicSession.a);
    paramDownloadTask.append(" errorCode = ");
    paramDownloadTask.append(paramInt);
    QLog.e("GuildImageThumbDownloader<FileAssistant>", 1, paramDownloadTask.toString());
  }
  
  private void a(GuildFileImageThumbDownloader.PicSession paramPicSession, String paramString, ThumbHttpDownloader.DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel())
    {
      paramDownloadTask = new StringBuilder();
      paramDownloadTask.append("handleDownloadCompletedSuccess isSucc = truesessionId = ");
      paramDownloadTask.append(paramPicSession.a);
      paramDownloadTask.append(" thumbPath = ");
      paramDownloadTask.append(paramString);
      QLog.d("GuildImageThumbDownloader<FileAssistant>", 2, paramDownloadTask.toString());
    }
    if (paramPicSession.c == 7)
    {
      paramPicSession.b.strLargeThumPath = paramString;
      FileManagerUtil.n(paramPicSession.b);
      ThreadManager.post(new GuildFileImageThumbDownloader.3(this, paramPicSession), 8, null, false);
    }
    else if (paramPicSession.c == 5)
    {
      paramPicSession.b.strMiddleThumPath = paramString;
      FileManagerUtil.n(paramPicSession.b);
      if (FilePicURLDrawlableHelper.i(paramPicSession.b)) {
        ThreadManager.post(new GuildFileImageThumbDownloader.4(this, paramPicSession), 8, null, false);
      }
    }
    else
    {
      paramPicSession.b.strThumbPath = paramString;
    }
    this.a.getFileManagerDataCenter().c(paramPicSession.b);
  }
  
  private boolean a(FileManagerEntity paramFileManagerEntity)
  {
    if ((paramFileManagerEntity != null) && (paramFileManagerEntity.Uuid != null)) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[downloadThumb]  download. uuid = null nSession[");
    localStringBuilder.append(paramFileManagerEntity.nSessionId);
    localStringBuilder.append("]");
    QLog.e("GuildImageThumbDownloader<FileAssistant>", 1, localStringBuilder.toString());
    this.a.getFileManagerNotifyCenter().a(false, 54, new Object[] { paramFileManagerEntity });
    return true;
  }
  
  private boolean a(FileManagerEntity paramFileManagerEntity, String paramString, int paramInt)
  {
    if (!FileUtils.fileExistsAndNotEmpty(paramString)) {
      return false;
    }
    if (paramInt == 7)
    {
      paramFileManagerEntity.strLargeThumPath = paramString;
      if (FilePicURLDrawlableHelper.i(paramFileManagerEntity)) {
        ThreadManager.post(new GuildFileImageThumbDownloader.1(this, paramFileManagerEntity), 8, null, false);
      }
    }
    else if (paramInt == 5)
    {
      paramFileManagerEntity.strMiddleThumPath = paramString;
      if (FilePicURLDrawlableHelper.i(paramFileManagerEntity)) {
        ThreadManager.post(new GuildFileImageThumbDownloader.2(this, paramFileManagerEntity), 8, null, false);
      }
    }
    else
    {
      paramFileManagerEntity.strThumbPath = paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[downloadThumb] Id[");
    localStringBuilder.append(paramFileManagerEntity.nSessionId);
    localStringBuilder.append("] thumb Downloaded:");
    localStringBuilder.append(paramString);
    QLog.e("GuildImageThumbDownloader<FileAssistant>", 1, localStringBuilder.toString());
    this.a.getFileManagerDataCenter().c(paramFileManagerEntity);
    this.a.getFileManagerNotifyCenter().a(true, 54, new Object[] { paramFileManagerEntity, Integer.valueOf(paramInt) });
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
  
  private int b(int paramInt)
  {
    if (paramInt == 6) {
      return 640;
    }
    if (paramInt == 7) {}
    return 750;
  }
  
  private String b(int paramInt, String paramString)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "x-dsc-";
      break;
    case 8: 
      str = "screen-dsc-";
      break;
    case 7: 
      str = "qxlarge-dsc-";
      break;
    case 6: 
      str = "xlarge-dsc-";
      break;
    case 5: 
      str = "qlarge-dsc-";
      break;
    case 4: 
      str = "large-dsc-";
      break;
    case 3: 
      str = "middle-dsc-";
      break;
    case 2: 
      str = "small-dsc-";
      break;
    case 1: 
      str = "minni-dsc-";
      break;
    case 0: 
      str = "micro-dsc-";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private String b(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(FMSettings.a().getDefaultThumbPath());
    ((StringBuilder)localObject).append(b(paramInt, MD5.b(paramFileManagerEntity.Uuid)));
    String str = ((StringBuilder)localObject).toString();
    localObject = str;
    if (!FileUtil.b(str))
    {
      localObject = str;
      if (!TextUtils.isEmpty(paramFileManagerEntity.strFileMd5))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(FMSettings.a().getDefaultThumbPath());
        ((StringBuilder)localObject).append(b(paramInt, MD5.b(paramFileManagerEntity.strFileMd5)));
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    if (QLog.isColorLevel())
    {
      paramFileManagerEntity = new StringBuilder();
      paramFileManagerEntity.append("getThumbFilePath strThumbPath = ");
      paramFileManagerEntity.append((String)localObject);
      QLog.d("GuildImageThumbDownloader<FileAssistant>", 2, paramFileManagerEntity.toString());
    }
    return localObject;
  }
  
  private IGuildPreviewThumbReqCallback c(long paramLong)
  {
    return new GuildFileImageThumbDownloader.5(this, paramLong);
  }
  
  public String a(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("download thumSize = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("GuildImageThumbDownloader<FileAssistant>", 2, ((StringBuilder)localObject).toString());
    }
    if (a(paramFileManagerEntity))
    {
      QLog.e("GuildImageThumbDownloader<FileAssistant>", 1, "entity is invaild");
      return null;
    }
    a();
    Object localObject = b(paramFileManagerEntity, paramInt);
    if (a(paramFileManagerEntity, (String)localObject, paramInt))
    {
      if (QLog.isColorLevel())
      {
        paramFileManagerEntity = new StringBuilder();
        paramFileManagerEntity.append("download file exists filePath = ");
        paramFileManagerEntity.append((String)localObject);
        QLog.d("GuildImageThumbDownloader<FileAssistant>", 2, paramFileManagerEntity.toString());
      }
      return localObject;
    }
    GuildFileImageThumbDownloader.PicSession localPicSession = new GuildFileImageThumbDownloader.PicSession(paramFileManagerEntity);
    localPicSession.c = paramInt;
    a(localPicSession, (String)localObject, true);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[downloadThumb] download  nSession[");
    ((StringBuilder)localObject).append(paramFileManagerEntity.nSessionId);
    ((StringBuilder)localObject).append("], ThumbDownloadId[");
    ((StringBuilder)localObject).append(localPicSession.a);
    ((StringBuilder)localObject).append("]");
    QLog.i("GuildImageThumbDownloader<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    return null;
  }
  
  public List<String> a(long paramLong, String paramString, int paramInt, boolean paramBoolean, List<String> paramList)
  {
    paramString = a(paramLong, false);
    if ((paramString != null) && (paramString.d != null))
    {
      paramList = paramString.d.b();
      if (paramList == null)
      {
        QLog.d("GuildImageThumbDownloader<FileAssistant>", 2, "onGetIPV6List addrList == null");
        return null;
      }
      paramString = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        oidb_0xfc2.Addr localAddr = (oidb_0xfc2.Addr)paramList.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localAddr.str_ip);
        localStringBuilder.append(":");
        localStringBuilder.append(localAddr.uint32_https_port);
        paramString.add(localStringBuilder.toString());
      }
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("ipv6List size = ");
        paramList.append(paramString.size());
        QLog.d("GuildImageThumbDownloader<FileAssistant>", 2, paramList.toString());
      }
      return paramString;
    }
    QLog.d("GuildImageThumbDownloader<FileAssistant>", 2, "onGetIPV6List session == null || session.previewThumbRsp == null");
    return null;
  }
  
  public void a(long paramLong, int paramInt, ThumbHttpDownloader.DownloadTask paramDownloadTask)
  {
    paramDownloadTask = a(paramLong, false);
    if (paramDownloadTask == null)
    {
      paramDownloadTask = new StringBuilder();
      paramDownloadTask.append("[downloadThumb]  ID[");
      paramDownloadTask.append(paramLong);
      paramDownloadTask.append("] onDownloadCompleted no this session");
      QLog.e("GuildImageThumbDownloader<FileAssistant>", 2, paramDownloadTask.toString());
      return;
    }
    this.a.getFileManagerNotifyCenter().a(true, 55, new Object[] { paramDownloadTask.b, Integer.valueOf(paramInt) });
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
      ((StringBuilder)localObject).append("onDownloadCompleted isSucc = ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("taskId = ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" thumbPath = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("GuildImageThumbDownloader<FileAssistant>", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = a(paramLong, false);
    if (localObject == null)
    {
      paramString = new StringBuilder();
      paramString.append("[downloadThumb]  ID[");
      paramString.append(paramLong);
      paramString.append("] onDownloadCompleted no this session");
      QLog.e("GuildImageThumbDownloader<FileAssistant>", 2, paramString.toString());
      return;
    }
    if (paramBoolean) {
      a((GuildFileImageThumbDownloader.PicSession)localObject, paramString, paramDownloadTask);
    } else {
      a(paramInt, (GuildFileImageThumbDownloader.PicSession)localObject, paramDownloadTask);
    }
    this.a.getFileManagerNotifyCenter().a(paramBoolean, 54, new Object[] { ((GuildFileImageThumbDownloader.PicSession)localObject).b, Integer.valueOf(((GuildFileImageThumbDownloader.PicSession)localObject).c) });
    super.a(paramLong, paramBoolean, paramInt, paramString, paramDownloadTask);
  }
  
  public boolean a(long paramLong, ThumbHttpDownloader.DownloadTask paramDownloadTask)
  {
    Object localObject = a(paramLong, false);
    if ((localObject != null) && (((GuildFileImageThumbDownloader.PicSession)localObject).b != null) && (!TextUtils.isEmpty(((GuildFileImageThumbDownloader.PicSession)localObject).b.guildId)) && (!TextUtils.isEmpty(((GuildFileImageThumbDownloader.PicSession)localObject).b.channelId)) && (!TextUtils.isEmpty(((GuildFileImageThumbDownloader.PicSession)localObject).b.Uuid)))
    {
      IGuildFileHandler localIGuildFileHandler = (IGuildFileHandler)this.a.getBusinessHandler(((IGuildHandlerNameApi)QRoute.api(IGuildHandlerNameApi.class)).getGuildFileHandlerName());
      paramDownloadTask = new UFTGuildPreviewThumbReq();
      paramDownloadTask.a(b());
      paramDownloadTask.b(4202);
      paramDownloadTask.b(((GuildFileImageThumbDownloader.PicSession)localObject).b.channelId);
      paramDownloadTask.c(((GuildFileImageThumbDownloader.PicSession)localObject).b.guildId);
      paramDownloadTask.a(((GuildFileImageThumbDownloader.PicSession)localObject).b.Uuid);
      localIGuildFileHandler.b(paramDownloadTask, c(paramLong));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("get image thumb guildid = ");
        ((StringBuilder)localObject).append(paramDownloadTask.e());
        ((StringBuilder)localObject).append(" channelId = ");
        ((StringBuilder)localObject).append(paramDownloadTask.d());
        ((StringBuilder)localObject).append(" fileid = ");
        ((StringBuilder)localObject).append(paramDownloadTask.b());
        QLog.d("GuildImageThumbDownloader<FileAssistant>", 2, ((StringBuilder)localObject).toString());
      }
      return true;
    }
    paramDownloadTask = new StringBuilder();
    paramDownloadTask.append("[downloadThumb]  ID[");
    paramDownloadTask.append(paramLong);
    paramDownloadTask.append("] onGetDownloadUrl no this session");
    QLog.e("GuildImageThumbDownloader<FileAssistant>", 2, paramDownloadTask.toString());
    return false;
  }
  
  public void b(long paramLong, ThumbHttpDownloader.DownloadTask paramDownloadTask)
  {
    if (a(paramLong, false) == null)
    {
      paramDownloadTask = new StringBuilder();
      paramDownloadTask.append("[downloadThumb]  ID[");
      paramDownloadTask.append(paramLong);
      paramDownloadTask.append("] onDownloadCompleted no this session");
      QLog.e("GuildImageThumbDownloader<FileAssistant>", 2, paramDownloadTask.toString());
      return;
    }
    paramDownloadTask = new StringBuilder();
    paramDownloadTask.append("[downloadThumb]  ID[");
    paramDownloadTask.append(paramLong);
    paramDownloadTask.append("] onRetryDownload");
    QLog.e("GuildImageThumbDownloader<FileAssistant>", 2, paramDownloadTask.toString());
  }
  
  public void c(long paramLong, ThumbHttpDownloader.DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel())
    {
      paramDownloadTask = new StringBuilder();
      paramDownloadTask.append("onChangeUrlDownload taskId = ");
      paramDownloadTask.append(paramLong);
      QLog.d("GuildImageThumbDownloader<FileAssistant>", 2, paramDownloadTask.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.guild.GuildFileImageThumbDownloader
 * JD-Core Version:    0.7.0.1
 */