package com.tencent.mobileqq.config.business;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.transfile.quic.internal.Utils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class QQShortVideoQuicNetProcessor$ShortVideoQuicNetConfBean
{
  public int a = 0;
  
  public static ShortVideoQuicNetConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    ShortVideoQuicNetConfBean localShortVideoQuicNetConfBean = new ShortVideoQuicNetConfBean();
    int j;
    int i;
    try
    {
      j = paramArrayOfQConfItem.length;
      i = 0;
    }
    catch (Throwable paramArrayOfQConfItem)
    {
      boolean bool;
      StringBuilder localStringBuilder;
      QLog.d("QQShortVideoQuicNetProcessor", 2, "parse S$EConfBean failed!", paramArrayOfQConfItem);
    }
    Object localObject = ((QConfItem)localObject).b;
    bool = TextUtils.isEmpty((CharSequence)localObject);
    if (!bool)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject((String)localObject);
        if (localJSONObject.has("quic_open")) {
          localShortVideoQuicNetConfBean.a = localJSONObject.optInt("quic_open");
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("parse S$EConfBean: ");
        localStringBuilder.append((String)localObject);
        QLog.i("QQShortVideoQuicNetProcessor", 2, localStringBuilder.toString());
      }
    }
    for (;;)
    {
      i += 1;
      while (i >= j) {
        return localShortVideoQuicNetConfBean;
      }
      localObject = paramArrayOfQConfItem[i];
      if (localObject != null) {
        break;
      }
    }
  }
  
  public boolean a()
  {
    return (this.a == 1) && (Build.VERSION.SDK_INT >= 21) && (!Utils.checkIfCPUx86());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ShortVideoQuicNetConfBean{mQuicOpen=");
    localStringBuilder.append(this.a);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QQShortVideoQuicNetProcessor.ShortVideoQuicNetConfBean
 * JD-Core Version:    0.7.0.1
 */