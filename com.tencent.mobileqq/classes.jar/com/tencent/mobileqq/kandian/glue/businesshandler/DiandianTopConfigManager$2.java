package com.tencent.mobileqq.kandian.glue.businesshandler;

import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.UiThreadUtil;

class DiandianTopConfigManager$2
  implements Runnable
{
  DiandianTopConfigManager$2(DiandianTopConfigManager paramDiandianTopConfigManager) {}
  
  public void run()
  {
    synchronized (DiandianTopConfigManager.a)
    {
      AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
      BaseApplication localBaseApplication = BaseApplication.getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("file_readinjoy_diandian_top_config");
      localStringBuilder.append(localAppInterface.getCurrentAccountUin());
      UiThreadUtil.a(new DiandianTopConfigManager.2.1(this, FileUtils.fileToBytes(localBaseApplication.getFileStreamPath(localStringBuilder.toString()))));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.DiandianTopConfigManager.2
 * JD-Core Version:    0.7.0.1
 */