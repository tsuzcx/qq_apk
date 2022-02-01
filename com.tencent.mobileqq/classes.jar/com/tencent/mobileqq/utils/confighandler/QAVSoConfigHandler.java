package com.tencent.mobileqq.utils.confighandler;

import anzj;
import com.tencent.av.so.DownloadInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import mae;

public class QAVSoConfigHandler
  extends ConfigHandler<DownloadInfo>
{
  public QAVSoConfigHandler()
  {
    super("QavSo", null);
  }
  
  public int getConfigVer()
  {
    if (AudioHelper.e()) {
      throw new IllegalArgumentException(this.TAG + anzj.a(2131707823));
    }
    return 0;
  }
  
  public void onGetConfigFinish(QQAppInterface paramQQAppInterface, String paramString, DownloadInfo paramDownloadInfo)
  {
    mae.a(paramQQAppInterface, paramString, paramDownloadInfo);
  }
  
  public void saveConfig(String paramString, int paramInt)
  {
    if (AudioHelper.e()) {
      throw new IllegalArgumentException(this.TAG + anzj.a(2131707822));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.confighandler.QAVSoConfigHandler
 * JD-Core Version:    0.7.0.1
 */