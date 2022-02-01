package com.tencent.mobileqq.utils.confighandler;

import com.tencent.av.so.ResDownloadControl;
import com.tencent.av.so.ResInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQAudioHelper;

public class QAVSoConfigHandler
  extends ConfigHandler<ResInfo>
{
  public QAVSoConfigHandler()
  {
    super("AVResMgr", null);
  }
  
  public int getConfigVer()
  {
    if (!QQAudioHelper.b()) {
      return 0;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.TAG);
    localStringBuilder.append(HardCodeUtil.a(2131708935));
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void onGetConfigFinish(QQAppInterface paramQQAppInterface, String paramString, ResInfo paramResInfo)
  {
    ResDownloadControl.a().a(paramQQAppInterface, paramString, paramResInfo);
  }
  
  public void saveConfig(String paramString, int paramInt)
  {
    if (!QQAudioHelper.b()) {
      return;
    }
    paramString = new StringBuilder();
    paramString.append(this.TAG);
    paramString.append(HardCodeUtil.a(2131708934));
    throw new IllegalArgumentException(paramString.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.confighandler.QAVSoConfigHandler
 * JD-Core Version:    0.7.0.1
 */