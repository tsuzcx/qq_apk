package com.tencent.mobileqq.config.business;

import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.config.QConfItem;
import org.json.JSONObject;

public class QQGamePreloadConfBean
{
  public int a;
  public String a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  
  public static QQGamePreloadConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    int i = 0;
    localQQGamePreloadConfBean = new QQGamePreloadConfBean();
    try
    {
      while (i < paramArrayOfQConfItem.length)
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfQConfItem[i].jdField_a_of_type_JavaLangString);
        if (localJSONObject.has("preloadSwitch"))
        {
          localQQGamePreloadConfBean.c = localJSONObject.optInt("preloadSwitch");
          if (QLog.isColorLevel()) {
            QLog.d("QQGamePreloadConfBean", 0, "onParsed preloadswtich=" + localQQGamePreloadConfBean.c);
          }
        }
        if (localJSONObject.has("preloadInterval"))
        {
          localQQGamePreloadConfBean.d = localJSONObject.optInt("preloadInterval", 3);
          if (QLog.isColorLevel()) {
            QLog.d("QQGamePreloadConfBean", 0, "onParsed swtich=" + localQQGamePreloadConfBean.d);
          }
        }
        if (localJSONObject.has("hippySwitch"))
        {
          localQQGamePreloadConfBean.jdField_a_of_type_Int = localJSONObject.optInt("hippySwitch", 1);
          if (QLog.isColorLevel()) {
            QLog.d("QQGamePreloadConfBean", 0, "onParsed preload url=" + localQQGamePreloadConfBean.jdField_a_of_type_Int);
          }
        }
        if (localJSONObject.has("hippyV2Switch"))
        {
          localQQGamePreloadConfBean.b = localJSONObject.optInt("hippyV2Switch", 1);
          if (QLog.isColorLevel()) {
            QLog.d("QQGamePreloadConfBean", 0, "onParsed preload url=" + localQQGamePreloadConfBean.b);
          }
        }
        localQQGamePreloadConfBean.e = localJSONObject.optInt("preloadFeedsSwitch");
        localQQGamePreloadConfBean.jdField_a_of_type_JavaLangString = localJSONObject.optString("preloadFeedsUrl");
        localQQGamePreloadConfBean.f = localJSONObject.optInt("preloadFeedsLoadAll", 0);
        if (QLog.isColorLevel()) {
          QLog.d("QQGamePreloadConfBean", 0, "parse QQGamePreloadConfBean=" + localQQGamePreloadConfBean);
        }
        i += 1;
      }
      return localQQGamePreloadConfBean;
    }
    catch (Throwable paramArrayOfQConfItem)
    {
      QLog.e("QQGamePreloadConfBean", 1, "QQGameConfBean parse error e=" + paramArrayOfQConfItem.toString());
    }
  }
  
  public String toString()
  {
    return "QQGamePreloadConfBean{mHippySwitch=" + this.jdField_a_of_type_Int + ", mHippyV2Switch=" + this.b + ", mPreloadSwitch=" + this.c + ", mPreloadInterval=" + this.d + ", mPreloadFeedsSwitch=" + this.e + ", mPreloadFeedsUrl='" + this.jdField_a_of_type_JavaLangString + '\'' + ", mPreloadFeedsLoadAll=" + this.f + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QQGamePreloadConfBean
 * JD-Core Version:    0.7.0.1
 */