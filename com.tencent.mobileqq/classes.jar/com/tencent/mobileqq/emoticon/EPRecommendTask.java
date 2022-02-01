package com.tencent.mobileqq.emoticon;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.magicface.model.MagicPromotionInfo;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;

public class EPRecommendTask
  implements IEPRecommendTask
{
  WeakReference<BaseQQAppInterface> a;
  String b;
  String c;
  Runnable d = new EPRecommendTask.1(this);
  CallBacker e = new EPRecommendTask.2(this);
  
  public EPRecommendTask(BaseQQAppInterface paramBaseQQAppInterface)
  {
    this.a = new WeakReference(paramBaseQQAppInterface);
  }
  
  public static String a()
  {
    Object localObject = MobileQQ.sMobileQQ.getApplicationContext();
    int i;
    if (Build.VERSION.SDK_INT > 10) {
      i = 4;
    } else {
      i = 0;
    }
    localObject = ((Context)localObject).getSharedPreferences("Last_Login", i).getString("uin", "");
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      return localObject;
    }
    return "10000";
  }
  
  public static MagicPromotionInfo b(JSONObject paramJSONObject)
  {
    try
    {
      Object localObject = paramJSONObject.optJSONArray("emojiAioConfig");
      if (localObject != null)
      {
        if (((JSONArray)localObject).length() == 0) {
          return null;
        }
        paramJSONObject = new MagicPromotionInfo();
        try
        {
          localObject = (JSONObject)((JSONArray)localObject).get(0);
          paramJSONObject.a = ((JSONObject)localObject).optInt("hide");
          paramJSONObject.b = ((JSONObject)localObject).optInt("version");
          paramJSONObject.e = ((JSONObject)localObject).optString("url");
          JSONObject localJSONObject2 = ((JSONObject)localObject).optJSONObject("gifUrl");
          if (localJSONObject2 != null) {
            paramJSONObject.c = localJSONObject2.optString("src");
          }
          localJSONObject2 = ((JSONObject)localObject).optJSONObject("imgUrl");
          localObject = paramJSONObject;
          if (localJSONObject2 == null) {
            return ???;
          }
          paramJSONObject.d = localJSONObject2.optString("src");
          return paramJSONObject;
        }
        catch (Exception localException1) {}
      }
      else
      {
        return null;
      }
    }
    catch (Exception localException2)
    {
      paramJSONObject = null;
      localException2.printStackTrace();
      JSONObject localJSONObject1 = paramJSONObject;
      return localJSONObject1;
    }
  }
  
  public EPRecommendTask a(String paramString1, String paramString2)
  {
    this.c = paramString2;
    this.b = paramString1;
    return this;
  }
  
  void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    try
    {
      paramJSONObject = b(paramJSONObject);
      if (paramJSONObject == null) {
        return;
      }
      Object localObject1 = MobileQQ.getContext().getSharedPreferences("mobileQQ", 0);
      ((SharedPreferences)localObject1).edit().putInt("magic_promotion_hide", paramJSONObject.a).commit();
      boolean bool = QLog.isColorLevel();
      Object localObject2;
      if (bool)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("promotionInfo:[hide]:");
        ((StringBuilder)localObject2).append(paramJSONObject.a);
        ((StringBuilder)localObject2).append(",[ver]:");
        ((StringBuilder)localObject2).append(paramJSONObject.b);
        QLog.d("EPRecommendTask", 2, ((StringBuilder)localObject2).toString());
      }
      if (1 == paramJSONObject.a) {
        return;
      }
      if ((!TextUtils.isEmpty(paramJSONObject.d)) && (!TextUtils.isEmpty(paramJSONObject.c)) && (!TextUtils.isEmpty(paramJSONObject.e)))
      {
        ((SharedPreferences)localObject1).edit().putString("magic_promotion_jump_url", paramJSONObject.e).commit();
        localObject2 = ((SharedPreferences)localObject1).edit();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("https://gxh.vip.qq.com/xydata/");
        localStringBuilder.append(paramJSONObject.d);
        ((SharedPreferences.Editor)localObject2).putString("magic_promotion_imgUrl", localStringBuilder.toString()).commit();
        localObject2 = ((SharedPreferences)localObject1).edit();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("https://gxh.vip.qq.com/xydata/");
        localStringBuilder.append(paramJSONObject.c);
        ((SharedPreferences.Editor)localObject2).putString("magic_promotion_gifUrl", localStringBuilder.toString()).commit();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("magic_promotion_old_ver_");
        ((StringBuilder)localObject2).append(a());
        if (((SharedPreferences)localObject1).getInt(((StringBuilder)localObject2).toString(), -1) < paramJSONObject.b)
        {
          localObject2 = ((SharedPreferences)localObject1).edit();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("magic_promotion_is_new_content_");
          localStringBuilder.append(a());
          ((SharedPreferences.Editor)localObject2).putBoolean(localStringBuilder.toString(), true).commit();
          localObject1 = ((SharedPreferences)localObject1).edit();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("magic_promotion_old_ver_");
          ((StringBuilder)localObject2).append(a());
          ((SharedPreferences.Editor)localObject1).putInt(((StringBuilder)localObject2).toString(), paramJSONObject.b).commit();
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("promotionInfo: imgUrl = ");
          ((StringBuilder)localObject1).append(paramJSONObject.d);
          ((StringBuilder)localObject1).append(" gifUrl = ");
          ((StringBuilder)localObject1).append(paramJSONObject.c);
          ((StringBuilder)localObject1).append(" jumpUrl = ");
          ((StringBuilder)localObject1).append(paramJSONObject.e);
          QLog.d("EPRecommendTask", 2, ((StringBuilder)localObject1).toString());
        }
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public void runTask()
  {
    ThreadManager.post(this.d, 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EPRecommendTask
 * JD-Core Version:    0.7.0.1
 */