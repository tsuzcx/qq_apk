package com.tencent.mobileqq.qqgamepub.config;

import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class QQGamePreloadConfBean
{
  public int a;
  public int b;
  public int c;
  public int d;
  public int e;
  public List<String> f = new ArrayList();
  public int g;
  public String h;
  public int i;
  
  public static QQGamePreloadConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    QQGamePreloadConfBean localQQGamePreloadConfBean = new QQGamePreloadConfBean();
    int j = 0;
    for (;;)
    {
      int k;
      try
      {
        Object localObject1;
        if (j < paramArrayOfQConfItem.length)
        {
          localObject1 = new JSONObject(paramArrayOfQConfItem[j].b);
          Object localObject2;
          if (((JSONObject)localObject1).has("preloadSwitch"))
          {
            localQQGamePreloadConfBean.c = ((JSONObject)localObject1).optInt("preloadSwitch");
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("onParsed preloadswtich=");
              ((StringBuilder)localObject2).append(localQQGamePreloadConfBean.c);
              QLog.d("QQGamePreloadConfBean", 2, ((StringBuilder)localObject2).toString());
            }
          }
          if (((JSONObject)localObject1).has("preloadInterval"))
          {
            localQQGamePreloadConfBean.d = ((JSONObject)localObject1).optInt("preloadInterval", 3);
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("onParsed swtich=");
              ((StringBuilder)localObject2).append(localQQGamePreloadConfBean.d);
              QLog.d("QQGamePreloadConfBean", 2, ((StringBuilder)localObject2).toString());
            }
          }
          boolean bool = ((JSONObject)localObject1).has("hippySwitch");
          if (bool)
          {
            localQQGamePreloadConfBean.a = ((JSONObject)localObject1).optInt("hippySwitch", 1);
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("onParsed preload url=");
              ((StringBuilder)localObject2).append(localQQGamePreloadConfBean.a);
              QLog.d("QQGamePreloadConfBean", 2, ((StringBuilder)localObject2).toString());
            }
          }
          if (((JSONObject)localObject1).has("hippyV2Switch"))
          {
            localQQGamePreloadConfBean.b = ((JSONObject)localObject1).optInt("hippyV2Switch", 1);
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("onParsed preload url=");
              ((StringBuilder)localObject2).append(localQQGamePreloadConfBean.b);
              QLog.d("QQGamePreloadConfBean", 2, ((StringBuilder)localObject2).toString());
            }
          }
          if (((JSONObject)localObject1).has("interceptAdId"))
          {
            localObject2 = ((JSONObject)localObject1).optJSONArray("interceptAdId");
            k = 0;
            if (k < ((JSONArray)localObject2).length())
            {
              String str = ((JSONArray)localObject2).getString(k);
              if (TextUtils.isEmpty(str)) {
                break label562;
              }
              localQQGamePreloadConfBean.f.add(str);
              break label562;
            }
          }
          localQQGamePreloadConfBean.g = ((JSONObject)localObject1).optInt("preloadFeedsSwitch");
          localQQGamePreloadConfBean.h = ((JSONObject)localObject1).optString("preloadFeedsUrl");
          localQQGamePreloadConfBean.i = ((JSONObject)localObject1).optInt("preloadFeedsLoadAll", 0);
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("parse QQGamePreloadConfBean=");
            ((StringBuilder)localObject2).append(localQQGamePreloadConfBean);
            QLog.d("QQGamePreloadConfBean", 2, ((StringBuilder)localObject2).toString());
          }
          if (((JSONObject)localObject1).has("flutterPreload"))
          {
            localQQGamePreloadConfBean.e = ((JSONObject)localObject1).optInt("flutterPreload");
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("onParsed flutterPreload =");
              ((StringBuilder)localObject1).append(localQQGamePreloadConfBean.e);
              QLog.d("QQGamePreloadConfBean", 2, ((StringBuilder)localObject1).toString());
            }
          }
          j += 1;
        }
        else
        {
          return localQQGamePreloadConfBean;
        }
      }
      catch (Throwable paramArrayOfQConfItem)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("QQGameConfBean parse error e=");
        ((StringBuilder)localObject1).append(paramArrayOfQConfItem.toString());
        QLog.e("QQGamePreloadConfBean", 1, ((StringBuilder)localObject1).toString());
      }
      label562:
      k += 1;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQGamePreloadConfBean{mHippySwitch=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mHippyV2Switch=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mPreloadSwitch=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mPreloadInterval=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", mPreloadFeedsSwitch=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", mPreloadFeedsUrl='");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mPreloadFeedsLoadAll=");
    localStringBuilder.append(this.i);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.config.QQGamePreloadConfBean
 * JD-Core Version:    0.7.0.1
 */