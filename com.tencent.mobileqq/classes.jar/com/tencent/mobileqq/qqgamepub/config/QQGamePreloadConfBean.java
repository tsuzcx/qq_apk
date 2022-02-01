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
  public String a;
  public List<String> a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  
  public QQGamePreloadConfBean()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static QQGamePreloadConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    QQGamePreloadConfBean localQQGamePreloadConfBean = new QQGamePreloadConfBean();
    int i = 0;
    for (;;)
    {
      int j;
      try
      {
        Object localObject1;
        if (i < paramArrayOfQConfItem.length)
        {
          localObject1 = new JSONObject(paramArrayOfQConfItem[i].jdField_a_of_type_JavaLangString);
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
            localQQGamePreloadConfBean.jdField_a_of_type_Int = ((JSONObject)localObject1).optInt("hippySwitch", 1);
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("onParsed preload url=");
              ((StringBuilder)localObject2).append(localQQGamePreloadConfBean.jdField_a_of_type_Int);
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
            j = 0;
            if (j < ((JSONArray)localObject2).length())
            {
              String str = ((JSONArray)localObject2).getString(j);
              if (TextUtils.isEmpty(str)) {
                break label562;
              }
              localQQGamePreloadConfBean.jdField_a_of_type_JavaUtilList.add(str);
              break label562;
            }
          }
          localQQGamePreloadConfBean.f = ((JSONObject)localObject1).optInt("preloadFeedsSwitch");
          localQQGamePreloadConfBean.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).optString("preloadFeedsUrl");
          localQQGamePreloadConfBean.g = ((JSONObject)localObject1).optInt("preloadFeedsLoadAll", 0);
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
          i += 1;
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
      j += 1;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQGamePreloadConfBean{mHippySwitch=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", mHippyV2Switch=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mPreloadSwitch=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mPreloadInterval=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", mPreloadFeedsSwitch=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", mPreloadFeedsUrl='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mPreloadFeedsLoadAll=");
    localStringBuilder.append(this.g);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.config.QQGamePreloadConfBean
 * JD-Core Version:    0.7.0.1
 */