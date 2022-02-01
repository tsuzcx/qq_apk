package com.tencent.mobileqq.filemanager.core;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IFMSettings;
import com.tencent.mobileqq.filemanager.api.IFileIPv6StrateyController;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DiscVideoThumbDownloader
  extends BaseThumbDownloader
{
  private FMObserver c = new DiscVideoThumbDownloader.1(this);
  
  public DiscVideoThumbDownloader(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    paramQQAppInterface.getFileManagerNotifyCenter().addObserver(this.c);
  }
  
  private DiscVideoThumbDownloader.VideoSession a(long paramLong, boolean paramBoolean)
  {
    BaseThumbDownloader.Session localSession = b(paramLong);
    if (localSession == null) {
      return null;
    }
    if ((localSession instanceof DiscVideoThumbDownloader.VideoSession)) {
      return (DiscVideoThumbDownloader.VideoSession)localSession;
    }
    return null;
  }
  
  public String a(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    if (paramFileManagerEntity.Uuid == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[downloadThumb]  download. uuid = null nSession[");
      ((StringBuilder)localObject1).append(paramFileManagerEntity.nSessionId);
      ((StringBuilder)localObject1).append("]");
      QLog.e("DiscVideoThumbDownloader<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
      this.a.getFileManagerNotifyCenter().a(false, 50, new Object[] { paramFileManagerEntity });
      return null;
    }
    int i = a(paramFileManagerEntity.fileName);
    if (-1 == i)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[downloadThumb]  download. can not getThumb of file:");
      ((StringBuilder)localObject1).append(paramFileManagerEntity.fileName);
      QLog.e("DiscVideoThumbDownloader<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
      this.a.getFileManagerNotifyCenter().a(false, 50, new Object[] { paramFileManagerEntity });
      return null;
    }
    Object localObject1 = paramFileManagerEntity.Uuid.replace("/", "");
    a();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(FMSettings.a().getDefaultThumbPath());
    ((StringBuilder)localObject2).append(a(paramInt, (String)localObject1));
    localObject1 = ((StringBuilder)localObject2).toString();
    if (FileUtils.fileExistsAndNotEmpty((String)localObject1) == true)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[downloadThumb] Id[");
      ((StringBuilder)localObject2).append(paramFileManagerEntity.nSessionId);
      ((StringBuilder)localObject2).append("] thumb Downloaded:");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.e("DiscVideoThumbDownloader<FileAssistant>", 1, ((StringBuilder)localObject2).toString());
      return localObject1;
    }
    localObject2 = new DiscVideoThumbDownloader.VideoSession(paramFileManagerEntity);
    ((DiscVideoThumbDownloader.VideoSession)localObject2).c = paramInt;
    ((DiscVideoThumbDownloader.VideoSession)localObject2).d = i;
    a((BaseThumbDownloader.Session)localObject2, (String)localObject1, true);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[downloadThumb] download  nSession[");
    ((StringBuilder)localObject1).append(paramFileManagerEntity.nSessionId);
    ((StringBuilder)localObject1).append("], ThumbDownloadId[");
    ((StringBuilder)localObject1).append(((DiscVideoThumbDownloader.VideoSession)localObject2).a);
    ((StringBuilder)localObject1).append("]");
    QLog.i("DiscVideoThumbDownloader<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
    return null;
  }
  
  public List<String> a(long paramLong, String paramString, int paramInt, boolean paramBoolean, List<String> paramList)
  {
    paramList = a(paramLong, false);
    if ((paramList != null) && (paramList.b != null) && (!TextUtils.isEmpty(paramString)) && (FileIPv6StrateyController.b().isConfigEnableIPV6(this.a, 5)))
    {
      paramList = new StringBuilder();
      paramList.append("[downloadThumb]  ID[");
      paramList.append(paramLong);
      paramList.append("] [IPv6-File] discVideo thumb. is config enable IPv6. domain[");
      paramList.append(paramString);
      paramList.append("]");
      QLog.i("DiscVideoThumbDownloader<FileAssistant>", 1, paramList.toString());
      paramString = new FileIPv6StrateyController.DomainInfo(paramString, paramInt);
      paramList = FileIPv6StrateyController.b().getIPlistForV6Domain(this.a, paramString, 5);
      if ((paramList != null) && (!paramList.a()))
      {
        paramString = new ArrayList();
        paramList = paramList.b.iterator();
        while (paramList.hasNext())
        {
          FileIPv6StrateyController.IPInfo localIPInfo = (FileIPv6StrateyController.IPInfo)paramList.next();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(localIPInfo.a);
          localStringBuilder.append(":");
          localStringBuilder.append(localIPInfo.b);
          paramString.add(localStringBuilder.toString());
        }
        paramList = new StringBuilder();
        paramList.append("[downloadThumb]  ID[");
        paramList.append(paramLong);
        paramList.append("] [IPv6-File] discVideo thumb. use IPv6. hostlist:");
        paramList.append(paramString.toString());
        QLog.i("DiscVideoThumbDownloader<FileAssistant>", 1, paramList.toString());
        return paramString;
      }
      paramString = new StringBuilder();
      paramString.append("[downloadThumb]  ID[");
      paramString.append(paramLong);
      paramString.append("] [IPv6-File] discVideo thumb. use IPv4:");
      QLog.i("DiscVideoThumbDownloader<FileAssistant>", 1, paramString.toString());
    }
    return null;
  }
  
  public void a(long paramLong, HttpMsg paramHttpMsg)
  {
    paramHttpMsg.busiType = 0;
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt, String paramString, ThumbHttpDownloader.DownloadTask paramDownloadTask)
  {
    DiscVideoThumbDownloader.VideoSession localVideoSession = a(paramLong, false);
    if (localVideoSession == null)
    {
      paramString = new StringBuilder();
      paramString.append("[downloadThumb]  ID[");
      paramString.append(paramLong);
      paramString.append("] onDownloadCompleted no this session");
      QLog.e("DiscVideoThumbDownloader<FileAssistant>", 2, paramString.toString());
      return;
    }
    if (paramBoolean)
    {
      localVideoSession.b.strLargeThumPath = paramString;
      FileManagerUtil.n(localVideoSession.b);
      this.a.getFileManagerDataCenter().c(localVideoSession.b);
    }
    this.a.getFileManagerNotifyCenter().a(paramBoolean, 50, new Object[] { localVideoSession.b, Integer.valueOf(localVideoSession.c) });
    super.a(paramLong, paramBoolean, paramInt, paramString, paramDownloadTask);
  }
  
  public boolean a(long paramLong, ThumbHttpDownloader.DownloadTask paramDownloadTask)
  {
    paramDownloadTask = a(paramLong, false);
    if (paramDownloadTask == null)
    {
      paramDownloadTask = new StringBuilder();
      paramDownloadTask.append("[downloadThumb]  ID[");
      paramDownloadTask.append(paramLong);
      paramDownloadTask.append("] onGetDownloadUrl no this session");
      QLog.e("DiscVideoThumbDownloader<FileAssistant>", 2, paramDownloadTask.toString());
      return false;
    }
    this.a.getFileTransferHandler().b(paramDownloadTask.b.peerUin, paramDownloadTask.b.Uuid, paramLong);
    return true;
  }
  
  public void b(long paramLong, ThumbHttpDownloader.DownloadTask paramDownloadTask) {}
  
  public void c(long paramLong, ThumbHttpDownloader.DownloadTask paramDownloadTask) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.DiscVideoThumbDownloader
 * JD-Core Version:    0.7.0.1
 */