package com.tencent.mobileqq.qqgamepub.api.impl;

import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;

class QQGamePreDownloadServiceImpl$6
  implements AsyncBack
{
  QQGamePreDownloadServiceImpl$6(QQGamePreDownloadServiceImpl paramQQGamePreDownloadServiceImpl, JSONArray paramJSONArray) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preloadH5Res, loaded param:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",code:");
      localStringBuilder.append(paramInt);
      QLog.d("QQGamePub_QQGamePreDownloadServiceImpl", 1, localStringBuilder.toString());
    }
    QQGamePreDownloadServiceImpl.reportSceneDownloadResult(this.jdField_a_of_type_OrgJsonJSONArray.toString(), paramInt, 2);
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.QQGamePreDownloadServiceImpl.6
 * JD-Core Version:    0.7.0.1
 */