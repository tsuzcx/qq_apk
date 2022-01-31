package com.tencent.mobileqq.utils.confighandler;

import alpo;
import com.tencent.av.so.DownloadInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import mcg;

public class QAVSoConfigHandler
  extends ConfigHandler<DownloadInfo>
{
  public QAVSoConfigHandler()
  {
    super("QavSo", null);
  }
  
  public int getConfigVer()
  {
    if (AudioHelper.d()) {
      throw new IllegalArgumentException(this.TAG + alpo.a(2131709326));
    }
    return 0;
  }
  
  public void onGetConfigFinish(QQAppInterface paramQQAppInterface, String paramString, DownloadInfo paramDownloadInfo)
  {
    mcg.a(paramQQAppInterface, paramString, paramDownloadInfo);
  }
  
  public void saveConfig(String paramString, int paramInt)
  {
    if (AudioHelper.d()) {
      throw new IllegalArgumentException(this.TAG + alpo.a(2131709325));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.confighandler.QAVSoConfigHandler
 * JD-Core Version:    0.7.0.1
 */