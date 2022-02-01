package com.tencent.qcircle.cooperation.config.download;

import android.content.SharedPreferences;
import com.tencent.biz.richframework.download.RFWDownloadStrategy;
import com.tencent.mobileqq.qcircle.api.constant.QCircleConstants;
import com.tencent.qcircle.cooperation.config.QCircleSpUtil;

public class QCircleDownloadStrategy
  extends RFWDownloadStrategy
{
  public String getBusinessKey()
  {
    return "QCircleStrategy";
  }
  
  public String getDownloadRootPath()
  {
    return QCircleConstants.QCIRCLE_DOWNLOAD_ROOT_PATH;
  }
  
  public SharedPreferences getSP()
  {
    return QCircleSpUtil.a(true, true);
  }
  
  public boolean supportBreakPointDownload()
  {
    return true;
  }
  
  public boolean supportUnZipFile()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qcircle.cooperation.config.download.QCircleDownloadStrategy
 * JD-Core Version:    0.7.0.1
 */