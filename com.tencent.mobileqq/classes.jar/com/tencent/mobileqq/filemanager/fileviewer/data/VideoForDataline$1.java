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
    DataLineHandler localDataLineHandler = (DataLineHandler)VideoForDataline.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataVideoForDataline).getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    if (paramDatalineDownloadRespInfo.jdField_a_of_type_Long == -100001L) {}
    String str2 = paramDatalineDownloadRespInfo.d;
    Object localObject = paramDatalineDownloadRespInfo.jdField_b_of_type_JavaLangString;
    int i = paramDatalineDownloadRespInfo.jdField_a_of_type_Int;
    String str1 = paramDatalineDownloadRespInfo.j;
    List localList = paramDatalineDownloadRespInfo.jdField_b_of_type_JavaUtilList;
    str1 = VideoForDataline.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataVideoForDataline, str1, i);
    if (!TextUtils.isEmpty(str1)) {
      localObject = str1;
    }
    for (;;)
    {
      paramDatalineDownloadRespInfo = paramDatalineDownloadRespInfo.e;
      localObject = "http://" + (String)localObject + ":" + String.valueOf(i) + str2;
      if (QLog.isColorLevel()) {
        QLog.i("VideoForDataline<QFile>XOXO", 1, "offlineVideo download. downloadUrl:" + (String)localObject);
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoDownloadManager$FileVideoManagerCallback.a((String)localObject, paramDatalineDownloadRespInfo);
      localDataLineHandler.OnSessionStart(VideoForDataline.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataVideoForDataline).sessionid);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.data.VideoForDataline.1
 * JD-Core Version:    0.7.0.1
 */