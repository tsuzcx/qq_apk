package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class LineLayer$ClearTempFileJob
  implements Runnable
{
  public final String a;
  
  public LineLayer$ClearTempFileJob(LineLayer paramLineLayer)
  {
    paramLineLayer = new StringBuilder();
    paramLineLayer.append(AppConstants.SCRIBBLE_FILE_DIR);
    paramLineLayer.append("temp");
    paramLineLayer.append(File.separator);
    this.a = paramLineLayer.toString();
  }
  
  public void run()
  {
    try
    {
      FileUtils.delete(this.a, true);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("makedir execption: ");
      localStringBuilder.append(localException);
      QLog.d("ClearTempFileJobdownloading", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.LineLayer.ClearTempFileJob
 * JD-Core Version:    0.7.0.1
 */