package com.tencent.mobileqq.utils.confighandler;

import com.tencent.av.so.ResDownloadControl;
import com.tencent.av.so.ResInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;

public class QAVSoConfigHandler
  extends ConfigHandler<ResInfo>
{
  public QAVSoConfigHandler()
  {
    super("AVResMgr", null);
  }
  
  public int getConfigVer()
  {
    if (AudioHelper.d()) {
      throw new IllegalArgumentException(this.TAG + HardCodeUtil.a(2131708929));
    }
    return 0;
  }
  
  public void onGetConfigFinish(QQAppInterface paramQQAppInterface, String paramString, ResInfo paramResInfo)
  {
    ResDownloadControl.a().a(paramQQAppInterface, paramString, paramResInfo);
  }
  
  public void saveConfig(String paramString, int paramInt)
  {
    if (AudioHelper.d()) {
      throw new IllegalArgumentException(this.TAG + HardCodeUtil.a(2131708928));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.confighandler.QAVSoConfigHandler
 * JD-Core Version:    0.7.0.1
 */