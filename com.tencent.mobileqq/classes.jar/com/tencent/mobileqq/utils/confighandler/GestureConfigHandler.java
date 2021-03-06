package com.tencent.mobileqq.utils.confighandler;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgrAppDownload;

public class GestureConfigHandler
  extends ConfigHandler<DownloadInfo>
{
  public GestureConfigHandler()
  {
    super("QavGesture", null);
  }
  
  public int getConfigVer()
  {
    return getConfigVer(getSP(), "config", "ver");
  }
  
  public SharedPreferences getSP()
  {
    return DownloadInfo.getSP();
  }
  
  public void onGetConfigFinish(QQAppInterface paramQQAppInterface, String paramString, DownloadInfo paramDownloadInfo)
  {
    GestureMgrAppDownload.a(paramQQAppInterface, paramString, paramDownloadInfo);
  }
  
  public void saveConfig(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = getSP();
    if (TextUtils.isEmpty(paramString)) {
      localSharedPreferences.edit().remove("config");
    } else {
      localSharedPreferences.edit().putString("config", paramString);
    }
    localSharedPreferences.edit().putInt("ver", paramInt);
    localSharedPreferences.edit().commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.confighandler.GestureConfigHandler
 * JD-Core Version:    0.7.0.1
 */