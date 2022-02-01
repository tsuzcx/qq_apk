package com.tencent.mobileqq.flashshow.utils.download;

import android.content.SharedPreferences;
import com.tencent.biz.richframework.download.RFWDownloadStrategy;
import com.tencent.mobileqq.flashshow.utils.FSSpUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleConstants;

public class FSDownloadStrategy
  extends RFWDownloadStrategy
{
  public String getBusinessKey()
  {
    return "QCircleStrategy";
  }
  
  public String getDownloadRootPath()
  {
    return QCircleConstants.i;
  }
  
  public SharedPreferences getSP()
  {
    return FSSpUtil.a(true, true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.utils.download.FSDownloadStrategy
 * JD-Core Version:    0.7.0.1
 */