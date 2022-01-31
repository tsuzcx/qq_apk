package com.tencent.mobileqq.utils.confighandler;

import ajjy;
import com.tencent.av.so.DownloadInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import lpe;

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
      throw new IllegalArgumentException(this.TAG + ajjy.a(2131643158));
    }
    return 0;
  }
  
  public void onGetConfigFinish(QQAppInterface paramQQAppInterface, String paramString, DownloadInfo paramDownloadInfo)
  {
    lpe.a(paramQQAppInterface, paramString, paramDownloadInfo);
  }
  
  public void saveConfig(String paramString, int paramInt)
  {
    if (AudioHelper.d()) {
      throw new IllegalArgumentException(this.TAG + ajjy.a(2131643157));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.confighandler.QAVSoConfigHandler
 * JD-Core Version:    0.7.0.1
 */