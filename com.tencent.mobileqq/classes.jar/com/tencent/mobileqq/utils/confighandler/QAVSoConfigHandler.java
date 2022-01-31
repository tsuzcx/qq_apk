package com.tencent.mobileqq.utils.confighandler;

import ajya;
import com.tencent.av.so.DownloadInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import lzr;

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
      throw new IllegalArgumentException(this.TAG + ajya.a(2131708954));
    }
    return 0;
  }
  
  public void onGetConfigFinish(QQAppInterface paramQQAppInterface, String paramString, DownloadInfo paramDownloadInfo)
  {
    lzr.a(paramQQAppInterface, paramString, paramDownloadInfo);
  }
  
  public void saveConfig(String paramString, int paramInt)
  {
    if (AudioHelper.d()) {
      throw new IllegalArgumentException(this.TAG + ajya.a(2131708953));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.confighandler.QAVSoConfigHandler
 * JD-Core Version:    0.7.0.1
 */