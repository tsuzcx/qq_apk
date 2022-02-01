package com.tencent.mobileqq.filemanager.fileviewer.data;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.api.IFMSettings;
import com.tencent.mobileqq.filemanager.api.IFileIPv6StrateyController;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController.DomainInfo;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController.IPInfo;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController.IPListInfo;
import com.tencent.mobileqq.filemanager.core.FileVideoDownloadManager.FileVideoManagerCallback;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.securitysdk.utils.MD5;
import java.util.List;

public class VideoForDataline
  implements BaseVideoBiz
{
  private QQAppInterface a;
  private DataLineMsgRecord b;
  
  public VideoForDataline(QQAppInterface paramQQAppInterface, DataLineMsgRecord paramDataLineMsgRecord)
  {
    this.a = paramQQAppInterface;
    this.b = paramDataLineMsgRecord;
  }
  
  private String a(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[IPv6-File] dataline offlineVideo download. is config enable IPv6. domain[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("]");
      QLog.i("VideoForDataline<QFile>XOXO", 1, ((StringBuilder)localObject).toString());
      paramString = new FileIPv6StrateyController.DomainInfo(paramString, paramInt);
      paramString = FileIPv6StrateyController.b().getIPlistForV6Domain(this.a, paramString, 1);
      int i;
      if ((paramString != null) && (!paramString.a()))
      {
        i = paramString.b.size();
        paramInt = 0;
      }
      while (paramInt < i)
      {
        localObject = (FileIPv6StrateyController.IPInfo)paramString.b.get(paramInt);
        if ((localObject != null) && (!TextUtils.isEmpty(((FileIPv6StrateyController.IPInfo)localObject).a)))
        {
          paramString = ((FileIPv6StrateyController.IPInfo)localObject).a;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[IPv6-File] offlineVideo download. use IPv6. hostlist:");
          ((StringBuilder)localObject).append(paramString);
          QLog.i("VideoForDataline<QFile>XOXO", 1, ((StringBuilder)localObject).toString());
          return paramString;
        }
        paramInt += 1;
        continue;
        QLog.i("VideoForDataline<QFile>XOXO", 1, "[IPv6-File] offlineVideo download. use IPv4");
      }
    }
    return "";
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b.sessionid);
    localStringBuilder.append("");
    return localStringBuilder.toString();
  }
  
  public void a(long paramLong)
  {
    ((DataLineHandler)this.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).OnSessionProgress(this.b.sessionid, paramLong, this.b.filesize, 0);
  }
  
  public void a(FileVideoDownloadManager.FileVideoManagerCallback paramFileVideoManagerCallback)
  {
    if (TextUtils.isEmpty(this.b.serverPath))
    {
      a(true);
      paramFileVideoManagerCallback.a(-6101, BaseApplication.getContext().getResources().getString(2131889822));
      paramFileVideoManagerCallback = new StringBuilder();
      paramFileVideoManagerCallback.append("[");
      paramFileVideoManagerCallback.append(a());
      paramFileVideoManagerCallback.append("],[getOnlinePlay]  uuid is null");
      QLog.e("VideoForDataline<QFile>XOXO", 2, paramFileVideoManagerCallback.toString());
      return;
    }
    ((DataLineHandler)this.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(this.b, new VideoForDataline.1(this, paramFileVideoManagerCallback));
  }
  
  public void a(String paramString)
  {
    DataLineHandler localDataLineHandler = (DataLineHandler)this.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    DataLineMsgRecord localDataLineMsgRecord = this.b;
    localDataLineMsgRecord.path = paramString;
    localDataLineHandler.OnSessionComplete(localDataLineMsgRecord.sessionid, 2, 0);
  }
  
  public void a(boolean paramBoolean)
  {
    ((DataLineHandler)this.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).OnSessionComplete(this.b.sessionid, 0, 0);
  }
  
  public long b()
  {
    return this.b.filesize;
  }
  
  public String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(FMSettings.a().getDefaultTmpPath());
    localStringBuilder.append(MD5.b(a()));
    return localStringBuilder.toString();
  }
  
  public String d()
  {
    return this.b.filename;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.data.VideoForDataline
 * JD-Core Version:    0.7.0.1
 */