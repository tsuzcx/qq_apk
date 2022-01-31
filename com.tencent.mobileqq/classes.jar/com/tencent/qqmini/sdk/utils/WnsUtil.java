package com.tencent.qqmini.sdk.utils;

import android.text.TextUtils;
import bglq;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

public class WnsUtil
{
  public static String defaultShareImg()
  {
    return bglq.a("qqtriton", "MiniGameDefaultShareImg", "https://qzonestyle.gtimg.cn/aoi/sola/20190510161934_LYAUVguqnV.png");
  }
  
  public static int getBannerAdMinWidth()
  {
    return bglq.a("qqtriton", "MiniGameBannerAdMinWidth", 300);
  }
  
  public static BaseLibInfo getGameBaseLibInfo()
  {
    Object localObject = bglq.a("qqtriton", "MiniGameBaseLib", "{\"key1\":\"https://d3g.qq.com/sngapp/app/update/20190708174635_6988/lib-1.4.7.zip\",\"key2\":\"\",\"key3\":\"1.4.7\",\"key4\": {\"file_length\": 6336933},\"key5\":2}");
    QMLog.i("minigame", "MiniEng getWnsGameBaseLibInfo " + (String)localObject);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      try
      {
        localObject = BaseLibInfo.fromJSON(new JSONObject((String)localObject));
        return localObject;
      }
      catch (Exception localException)
      {
        QMLog.e("minigame", "MiniEng getWnsGameBaseLibInfo failed", localException);
      }
    }
    return null;
  }
  
  public static String getGameEngineVersion(String paramString)
  {
    return bglq.a("qqtriton", "MiniGameEngineVersion", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.WnsUtil
 * JD-Core Version:    0.7.0.1
 */