package com.tencent.mobileqq.emoticon;

import ackv;
import ackw;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.magicface.model.MagicPromotionInfo;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;

public class EPRecommendTask
{
  public VasQuickUpdateManager.CallBacker a;
  Runnable a;
  public String a;
  public WeakReference a;
  public String b;
  
  public EPRecommendTask(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRunnable = new ackv(this);
    this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new ackw(this);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  public static MagicPromotionInfo a(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = null;
    try
    {
      Object localObject = paramJSONObject.optJSONArray("emojiAioConfig");
      if (localObject != null)
      {
        if (((JSONArray)localObject).length() == 0) {
          return null;
        }
        paramJSONObject = new MagicPromotionInfo();
      }
      label116:
      return null;
    }
    catch (Exception localException1)
    {
      try
      {
        localObject = (JSONObject)((JSONArray)localObject).get(0);
        paramJSONObject.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("hide");
        paramJSONObject.jdField_b_of_type_Int = ((JSONObject)localObject).optInt("version");
        paramJSONObject.c = ((JSONObject)localObject).optString("url");
        localJSONObject = ((JSONObject)localObject).optJSONObject("gifUrl");
        if (localJSONObject != null) {
          paramJSONObject.jdField_a_of_type_JavaLangString = localJSONObject.optString("src");
        }
        localObject = ((JSONObject)localObject).optJSONObject("imgUrl");
        if (localObject != null) {
          paramJSONObject.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("src");
        }
        return paramJSONObject;
      }
      catch (Exception localException2)
      {
        break label116;
      }
      localException1 = localException1;
      paramJSONObject = localJSONObject;
      localException1.printStackTrace();
      return paramJSONObject;
    }
  }
  
  public EPRecommendTask a(String paramString1, String paramString2)
  {
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_JavaLangString = paramString1;
    return this;
  }
  
  public void a()
  {
    ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 5, null, true);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    SharedPreferences localSharedPreferences;
    do
    {
      for (;;)
      {
        return;
        try
        {
          paramJSONObject = a(paramJSONObject);
          if (paramJSONObject != null)
          {
            localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("mobileQQ", 0);
            localSharedPreferences.edit().putInt("magic_promotion_hide", paramJSONObject.jdField_a_of_type_Int).commit();
            if (QLog.isColorLevel()) {
              QLog.d("EPRecommendTask", 2, "promotionInfo:[hide]:" + paramJSONObject.jdField_a_of_type_Int + ",[ver]:" + paramJSONObject.jdField_b_of_type_Int);
            }
            if (1 != paramJSONObject.jdField_a_of_type_Int) {
              if ((TextUtils.isEmpty(paramJSONObject.jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(paramJSONObject.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramJSONObject.c)))
              {
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d("EPRecommendTask", 2, "promotionInfo: imgUrl = " + paramJSONObject.jdField_b_of_type_JavaLangString + " gifUrl = " + paramJSONObject.jdField_a_of_type_JavaLangString + " jumpUrl = " + paramJSONObject.c);
              }
            }
          }
        }
        catch (Exception paramJSONObject)
        {
          paramJSONObject.printStackTrace();
          return;
        }
      }
      localSharedPreferences.edit().putString("magic_promotion_jump_url", paramJSONObject.c).commit();
      localSharedPreferences.edit().putString("magic_promotion_imgUrl", "http://gxh.vip.qq.com/xydata/" + paramJSONObject.jdField_b_of_type_JavaLangString).commit();
      localSharedPreferences.edit().putString("magic_promotion_gifUrl", "http://gxh.vip.qq.com/xydata/" + paramJSONObject.jdField_a_of_type_JavaLangString).commit();
    } while (localSharedPreferences.getInt("magic_promotion_old_ver_" + EarlyDownloadManager.a(), -1) >= paramJSONObject.jdField_b_of_type_Int);
    localSharedPreferences.edit().putBoolean("magic_promotion_is_new_content_" + EarlyDownloadManager.a(), true).commit();
    localSharedPreferences.edit().putInt("magic_promotion_old_ver_" + EarlyDownloadManager.a(), paramJSONObject.jdField_b_of_type_Int).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EPRecommendTask
 * JD-Core Version:    0.7.0.1
 */