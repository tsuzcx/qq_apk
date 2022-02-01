package com.tencent.mobileqq.utils.confighandler;

import anvx;
import com.tencent.av.so.ResInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import mai;

public class QAVSoConfigHandler
  extends ConfigHandler<ResInfo>
{
  public QAVSoConfigHandler()
  {
    super("ResMgr", null);
  }
  
  public int getConfigVer()
  {
    if (AudioHelper.e()) {
      throw new IllegalArgumentException(this.TAG + anvx.a(2131708402));
    }
    return 0;
  }
  
  public void onGetConfigFinish(QQAppInterface paramQQAppInterface, String paramString, ResInfo paramResInfo)
  {
    mai.a().a(paramQQAppInterface, paramString, paramResInfo);
  }
  
  public void saveConfig(String paramString, int paramInt)
  {
    if (AudioHelper.e()) {
      throw new IllegalArgumentException(this.TAG + anvx.a(2131708401));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.confighandler.QAVSoConfigHandler
 * JD-Core Version:    0.7.0.1
 */