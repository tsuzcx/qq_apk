package com.tencent.mobileqq.qqlive.config;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class QQLiveConfigBean
{
  public String a = "https://h5.qzone.qq.com/v2/vip/live/profile?puin={pUin}&openid={anchorOpenId}&anchorUid={anchorUid}&_wv=16777217";
  public String b = "https://sola.gtimg.cn/aoi/sola/20201215180203_9wAPjFrkcp.png";
  public String c = "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/PK/PK/prize/kjdh.png?nowebp&nosharpp";
  public String d = "https://h5.qzone.qq.com/v2/vip/live/qlive-h5/pages/plat-lottery.html?lotteryId={lotteryId}&roomId={roomId}&programId={programId}&busId={busId}";
  public String e = "https://qlive.qq.com/pages/name-auth.html";
  
  @Nullable
  public static QQLiveConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    QQLiveConfigBean localQQLiveConfigBean = new QQLiveConfigBean();
    if (paramArrayOfQConfItem != null)
    {
      if (paramArrayOfQConfItem.length == 0) {
        return localQQLiveConfigBean;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQLiveConfigBean", 2, "parse");
      }
      int j = paramArrayOfQConfItem.length;
      int i = 0;
      while (i < j)
      {
        a(localQQLiveConfigBean, paramArrayOfQConfItem[i]);
        i += 1;
      }
      QLog.d("QQLiveConfigBean", 1, new Object[] { "parse, config=", localQQLiveConfigBean });
    }
    return localQQLiveConfigBean;
  }
  
  private static void a(QQLiveConfigBean paramQQLiveConfigBean, QConfItem paramQConfItem)
  {
    try
    {
      if (!TextUtils.isEmpty(paramQConfItem.b))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLiveConfigBean", 2, new Object[] { "parse, content=", paramQConfItem.b });
        }
        paramQConfItem = new JSONObject(paramQConfItem.b);
        paramQQLiveConfigBean.a = paramQConfItem.optString("livePersonalPageUrl", "https://h5.qzone.qq.com/v2/vip/live/profile?puin={pUin}&openid={anchorOpenId}&anchorUid={anchorUid}&_wv=16777217");
        paramQQLiveConfigBean.b = paramQConfItem.optString("lotteryPic", "https://sola.gtimg.cn/aoi/sola/20201215180203_9wAPjFrkcp.png");
        paramQQLiveConfigBean.c = paramQConfItem.optString("lotteryEffectPic", "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/PK/PK/prize/kjdh.png?nowebp&nosharpp");
        paramQQLiveConfigBean.d = paramQConfItem.optString("lotteryPageUrl", "https://h5.qzone.qq.com/v2/vip/live/qlive-h5/pages/plat-lottery.html?lotteryId={lotteryId}&roomId={roomId}&programId={programId}&busId={busId}");
        paramQQLiveConfigBean.e = paramQConfItem.optString("liveVerifyUrl", "https://qlive.qq.com/pages/name-auth.html");
        return;
      }
    }
    catch (Exception paramQQLiveConfigBean)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQLiveConfigBean", 1, new Object[] { "parse e:", paramQQLiveConfigBean.getMessage() });
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQLiveConfigBean{livePersonalPageUrl='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", lotteryPic='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", lotteryEffectPic='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", lotteryPageUrl='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", liveVerifyUrl='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.config.QQLiveConfigBean
 * JD-Core Version:    0.7.0.1
 */