package com.tencent.mobileqq.winkpublish.publishconst;

import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;

public class FSUploadConst
{
  public static String a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1700)
      {
        if (paramInt != 10000)
        {
          if (paramInt != 10001)
          {
            switch (paramInt)
            {
            default: 
              return QCircleConfigHelper.a("QZoneTextSetting", "UploadFail", "上传失败");
            case 1707: 
              return QCircleConfigHelper.a("QZoneTextSetting", "UploadGenerateVideoCoverFail", "传视频封面失败(文件不存在)");
            case 1706: 
              return QCircleConfigHelper.a("QZoneTextSetting", "UploadVideoComposeFail", "视频合成失败");
            case 1705: 
              return QCircleConfigHelper.a("QZoneTextSetting", "UploadNotLogin", "登录未完成，请稍后重试");
            case 1704: 
              return QCircleConfigHelper.a("QZoneTextSetting", "UploadResultError", "上传返回结果失败");
            case 1703: 
              return QCircleConfigHelper.a("QZoneTextSetting", "UploadLoginError", "登录态异常，请重新登录后重试");
            }
            return QCircleConfigHelper.a("QZoneTextSetting", "UploadLoginError", "登录态异常，请重新登录后重试");
          }
          return QCircleConfigHelper.a("QZoneTextSetting", "QcircleUploadGenerateVideoTimeOutFail", "视频合成超时");
        }
        return QCircleConfigHelper.a("QZoneTextSetting", "QcircleUploadGenerateVideoFail", "视频合成失败");
      }
      return QCircleConfigHelper.a("QZoneTextSetting", "UploadFileNotExist", "文件不存在,请检查文件");
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.publishconst.FSUploadConst
 * JD-Core Version:    0.7.0.1
 */