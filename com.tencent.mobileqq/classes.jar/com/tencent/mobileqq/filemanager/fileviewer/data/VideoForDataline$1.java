package com.tencent.mobileqq.filemanager.fileviewer.data;

import android.text.TextUtils;
import com.dataline.compatible.DatalineDownloadRespInfo;
import com.dataline.compatible.IDatalineFileReqCallback;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.core.FileVideoDownloadManager.FileVideoManagerCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class VideoForDataline$1
  implements IDatalineFileReqCallback
{
  VideoForDataline$1(VideoForDataline paramVideoForDataline, FileVideoDownloadManager.FileVideoManagerCallback paramFileVideoManagerCallback) {}
  
  public void a(DatalineDownloadRespInfo paramDatalineDownloadRespInfo)
  {
    DataLineHandler localDataLineHandler = (DataLineHandler)VideoForDataline.a(this.b).getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    long l = paramDatalineDownloadRespInfo.a;
    String str = paramDatalineDownloadRespInfo.g;
    Object localObject1 = paramDatalineDownloadRespInfo.d;
    int i = paramDatalineDownloadRespInfo.e;
    Object localObject2 = paramDatalineDownloadRespInfo.n;
    List localList = paramDatalineDownloadRespInfo.p;
    localObject2 = VideoForDataline.a(this.b, (String)localObject2, i);
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = localObject2;
    }
    paramDatalineDownloadRespInfo = paramDatalineDownloadRespInfo.h;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("http://");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(":");
    ((StringBuilder)localObject2).append(String.valueOf(i));
    ((StringBuilder)localObject2).append(str);
    localObject1 = ((StringBuilder)localObject2).toString();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("offlineVideo download. downloadUrl:");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.i("VideoForDataline<QFile>XOXO", 1, ((StringBuilder)localObject2).toString());
    }
    this.a.a((String)localObject1, paramDatalineDownloadRespInfo);
    localDataLineHandler.OnSessionStart(VideoForDataline.b(this.b).sessionid);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.data.VideoForDataline.1
 * JD-Core Version:    0.7.0.1
 */