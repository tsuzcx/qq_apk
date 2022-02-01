package com.tencent.mobileqq.config.business;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import com.tencent.mobileqq.qassistant.core.FriendSortHelper;
import com.tencent.mobileqq.qassistant.core.VoiceAssistantManager;
import com.tencent.mobileqq.qassistant.wake.WakeManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QQAssistantConfigProcessor
  extends IQConfigProcessor<QQAssistantConfigProcessor.QAssistantConfigContent>
{
  private boolean a(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return false;
      try
      {
        String str;
        if (paramJSONObject.has("manufacturer"))
        {
          str = paramJSONObject.getString("manufacturer");
          if ((str != null) && (!"".equals(str)) && (!Build.MANUFACTURER.equals(str))) {}
        }
        else if (paramJSONObject.has("brand"))
        {
          str = paramJSONObject.getString("brand");
          if ((str != null) && (!"".equals(str)) && (!Build.BRAND.equals(str))) {}
        }
        else if (paramJSONObject.has("model"))
        {
          str = paramJSONObject.getString("model");
          if ((str != null) && (!"".equals(str)) && (!Build.MODEL.equals(str))) {}
        }
        else if (paramJSONObject.has("fingerprint"))
        {
          str = paramJSONObject.getString("fingerprint");
          if ((str != null) && (!"".equals(str)) && (!Build.FINGERPRINT.equals(str))) {}
        }
        else
        {
          if (paramJSONObject.has("androidId"))
          {
            paramJSONObject = paramJSONObject.getString("androidId");
            if ((paramJSONObject != null) && (!"".equals(paramJSONObject)) && (!"".equals(paramString)))
            {
              boolean bool = paramString.equals(paramJSONObject);
              if (!bool) {
                continue;
              }
            }
          }
          return true;
        }
      }
      catch (Exception paramJSONObject) {}
    }
    return false;
  }
  
  @NonNull
  public QQAssistantConfigProcessor.QAssistantConfigContent a(int paramInt)
  {
    return new QQAssistantConfigProcessor.QAssistantConfigContent();
  }
  
  @Nullable
  public QQAssistantConfigProcessor.QAssistantConfigContent a(QConfItem[] paramArrayOfQConfItem)
  {
    QQAssistantConfigProcessor.QAssistantConfigContent localQAssistantConfigContent = new QQAssistantConfigProcessor.QAssistantConfigContent();
    if (QLog.isColorLevel()) {
      QLog.d("QQAssistantConfigProcessor", 2, "onParsed confFiles.length = " + paramArrayOfQConfItem.length);
    }
    if (paramArrayOfQConfItem.length > 0)
    {
      paramArrayOfQConfItem = paramArrayOfQConfItem[0];
      localQAssistantConfigContent.jdField_a_of_type_Int = paramArrayOfQConfItem.jdField_a_of_type_Int;
      localQAssistantConfigContent.jdField_a_of_type_JavaLangString = paramArrayOfQConfItem.jdField_a_of_type_JavaLangString;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQAssistantConfigProcessor", 2, "onParsed taskId = " + localQAssistantConfigContent.jdField_a_of_type_Int + " | content = " + localQAssistantConfigContent.jdField_a_of_type_JavaLangString);
    }
    return localQAssistantConfigContent;
  }
  
  public void a(QQAssistantConfigProcessor.QAssistantConfigContent paramQAssistantConfigContent)
  {
    if ((paramQAssistantConfigContent != null) && (paramQAssistantConfigContent.jdField_a_of_type_JavaLangString != null)) {}
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = paramQAssistantConfigContent.jdField_a_of_type_JavaLangString;
        localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (QLog.isColorLevel()) {
          QLog.d("QQAssistantConfigProcessor", 2, "onUpdate content = " + paramQAssistantConfigContent.jdField_a_of_type_JavaLangString);
        }
        try
        {
          localObject1 = new JSONObject(paramQAssistantConfigContent.jdField_a_of_type_JavaLangString);
          paramQAssistantConfigContent = BaseApplicationImpl.getApplication().getSharedPreferences("qq_assistant_sp_key", 4).edit();
          Object localObject2 = DeviceInfoUtil.f();
          AssistantUtils.a("HelloQQWake", "parseJson MANUFACTURER:" + Build.MANUFACTURER + ",BRAND:" + Build.BRAND + ",MODEL:" + Build.MODEL + ",FINGERPRINT:" + Build.FINGERPRINT + ",ANDROID_ID:" + (String)localObject2);
          JSONArray localJSONArray;
          if (((JSONObject)localObject1).has("ban"))
          {
            localJSONArray = ((JSONObject)localObject1).getJSONArray("ban");
            i = 0;
          }
          try
          {
            if (i >= localJSONArray.length()) {
              continue;
            }
            bool = a(localJSONArray.getJSONObject(i), (String)localObject2);
            if (!bool) {
              break label753;
            }
            bool = true;
          }
          catch (Exception localException)
          {
            AssistantUtils.a("HelloQQWake", "parseJson needBan error " + localException.getMessage());
            boolean bool = false;
            continue;
          }
          AssistantUtils.a("HelloQQWake", "parseJson needBan  " + bool);
          paramQAssistantConfigContent.putBoolean("ban", bool);
          WakeManager.a().e = bool;
          if (((JSONObject)localObject1).has("enable"))
          {
            bool = ((JSONObject)localObject1).getBoolean("enable");
            AssistantUtils.a("HelloQQWake", "parseJson enable  " + bool);
            paramQAssistantConfigContent.putBoolean(WakeManager.a(), bool);
            WakeManager.a().d = bool;
            if (WakeManager.a().b())
            {
              localObject2 = AssistantUtils.a();
              if (localObject2 != null) {
                ((VoiceAssistantManager)localObject2).a();
              }
              WakeManager.a().a("manager enable");
            }
          }
          if (((JSONObject)localObject1).has("resModel"))
          {
            localObject2 = ((JSONObject)localObject1).getString("resModel");
            AssistantUtils.a("HelloQQWake", "parseJson resModel  " + (String)localObject2);
            paramQAssistantConfigContent.putString("resModel", (String)localObject2);
          }
          if (((JSONObject)localObject1).has("resVoice"))
          {
            localObject2 = ((JSONObject)localObject1).getString("resVoice");
            AssistantUtils.a("HelloQQWake", "parseJson resVoice  " + (String)localObject2);
            paramQAssistantConfigContent.putString("resVoice", (String)localObject2);
          }
          if (((JSONObject)localObject1).has("resAnimation"))
          {
            localObject2 = ((JSONObject)localObject1).getString("resAnimation");
            AssistantUtils.a("HelloQQWake", "parseJson resAnimation  " + (String)localObject2);
            paramQAssistantConfigContent.putString("resAnimation", (String)localObject2);
          }
          if (((JSONObject)localObject1).has("FriendSort"))
          {
            localObject2 = ((JSONObject)localObject1).getString("FriendSort");
            AssistantUtils.a("HelloQQWake", "parseJson FriendSort  " + (String)localObject2);
            FriendSortHelper.a((String)localObject2);
            paramQAssistantConfigContent.putString("FriendSort", (String)localObject2);
          }
          if (((JSONObject)localObject1).has("confidence"))
          {
            localObject1 = ((JSONObject)localObject1).getString("confidence");
            AssistantUtils.a("HelloQQWake", "parseJson confidence  " + (String)localObject1);
            FriendSortHelper.a((String)localObject1);
            paramQAssistantConfigContent.putString("confidence", (String)localObject1);
          }
          paramQAssistantConfigContent.apply();
          return;
        }
        catch (JSONException paramQAssistantConfigContent)
        {
          paramQAssistantConfigContent.printStackTrace();
          QLog.e("QQAssistantConfigProcessor", 2, "parseJson has exception  " + paramQAssistantConfigContent.getMessage());
          return;
        }
        QLog.e("QQAssistantConfigProcessor", 2, "onUpdate has empty content newConf is null = " + null);
      }
      catch (Exception paramQAssistantConfigContent)
      {
        paramQAssistantConfigContent.printStackTrace();
        QLog.e("QQAssistantConfigProcessor", 2, "onUpdate has exception", paramQAssistantConfigContent);
        return;
      }
      return;
      label753:
      i += 1;
    }
  }
  
  public Class<QQAssistantConfigProcessor.QAssistantConfigContent> clazz()
  {
    return QQAssistantConfigProcessor.QAssistantConfigContent.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAssistantConfigProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAssistantConfigProcessor", 2, "onReqFailed, code = " + paramInt);
    }
  }
  
  public int type()
  {
    return 679;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QQAssistantConfigProcessor
 * JD-Core Version:    0.7.0.1
 */