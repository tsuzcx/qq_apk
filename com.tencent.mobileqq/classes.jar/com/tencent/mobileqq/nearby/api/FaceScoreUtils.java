package com.tencent.mobileqq.nearby.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.nearby.FaceScoreConfig;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class FaceScoreUtils
{
  public static FaceScoreConfig a(AppInterface paramAppInterface)
  {
    FaceScoreConfig localFaceScoreConfig = new FaceScoreConfig();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("nearby_face_score_config_");
    ((StringBuilder)localObject).append(paramAppInterface.getCurrentAccountUin());
    localObject = ((StringBuilder)localObject).toString();
    paramAppInterface = paramAppInterface.getApplication().getApplicationContext().getSharedPreferences((String)localObject, 4);
    localFaceScoreConfig.a = paramAppInterface.getBoolean("isShowCard", false);
    localFaceScoreConfig.b = paramAppInterface.getBoolean("isShowList", false);
    localFaceScoreConfig.c = paramAppInterface.getLong("expireTime", 0L);
    localFaceScoreConfig.d = paramAppInterface.getString("entranceJumpUrl", "");
    localFaceScoreConfig.e = paramAppInterface.getString("entranceJumpUrlForHost", "");
    localFaceScoreConfig.f = paramAppInterface.getString("entranceJumpUrlForGuest", "");
    if (QLog.isColorLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("FaceScoreUtils.getConfig config.expireTime=");
      paramAppInterface.append(localFaceScoreConfig.a);
      paramAppInterface.append("  config.isShowList=");
      paramAppInterface.append(localFaceScoreConfig.b);
      paramAppInterface.append("  config.expireTime=");
      paramAppInterface.append(localFaceScoreConfig.c);
      paramAppInterface.append("  config.entranceJumpUrl=");
      paramAppInterface.append(localFaceScoreConfig.d);
      paramAppInterface.append("  config.entranceJumpUrlForHost=");
      paramAppInterface.append(localFaceScoreConfig.e);
      paramAppInterface.append("  config.entranceJumpUrlForGuest=");
      paramAppInterface.append(localFaceScoreConfig.f);
      QLog.e("Q..troop.faceScore", 2, paramAppInterface.toString());
    }
    return localFaceScoreConfig;
  }
  
  public static String a(int paramInt, String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > paramInt)) {
      return paramVarArgs[paramInt];
    }
    return "";
  }
  
  public static void a(AppInterface paramAppInterface, FaceScoreConfig paramFaceScoreConfig)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("nearby_face_score_config_");
      ((StringBuilder)localObject).append(paramAppInterface.getCurrentAccountUin());
      localObject = ((StringBuilder)localObject).toString();
      paramAppInterface.getApplication().getApplicationContext().getSharedPreferences((String)localObject, 4).edit().putBoolean("isShowCard", paramFaceScoreConfig.a).putBoolean("isShowList", paramFaceScoreConfig.b).putLong("expireTime", paramFaceScoreConfig.c).putString("entranceJumpUrl", paramFaceScoreConfig.d).putString("entranceJumpUrlForHost", paramFaceScoreConfig.e).putString("entranceJumpUrlForGuest", paramFaceScoreConfig.f).commit();
      if (QLog.isColorLevel())
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("FaceScoreUtils.saveConfig config.expireTime=");
        paramAppInterface.append(paramFaceScoreConfig.a);
        paramAppInterface.append("  config.isShowList=");
        paramAppInterface.append(paramFaceScoreConfig.b);
        paramAppInterface.append("  config.expireTime=");
        paramAppInterface.append(paramFaceScoreConfig.c);
        paramAppInterface.append("  config.entranceJumpUrl=");
        paramAppInterface.append(paramFaceScoreConfig.d);
        paramAppInterface.append("  config.entranceJumpUrlForHost=");
        paramAppInterface.append(paramFaceScoreConfig.e);
        paramAppInterface.append("  config.entranceJumpUrlForGuest=");
        paramAppInterface.append(paramFaceScoreConfig.f);
        QLog.e("Q..troop.faceScore", 2, paramAppInterface.toString());
      }
      return;
    }
    finally
    {
      paramAppInterface = finally;
      throw paramAppInterface;
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("nearby_face_score_config_");
    ((StringBuilder)localObject).append(paramAppInterface.getCurrentAccountUin());
    localObject = ((StringBuilder)localObject).toString();
    paramAppInterface = paramAppInterface.getApplication().getApplicationContext().getSharedPreferences((String)localObject, 4);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("has_insert_face_score_msg_");
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    paramAppInterface.edit().putBoolean((String)localObject, true).commit();
    if (QLog.isColorLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("FaceScoreUtils.setHasInsertMsgFlag uin=");
      paramAppInterface.append(paramString);
      QLog.e("Q..troop.faceScore", 2, paramAppInterface.toString());
    }
  }
  
  public static void a(MessageRecord paramMessageRecord, String paramString, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setFaceScoreFlag, msg = ");
      ((StringBuilder)localObject).append(paramMessageRecord);
      ((StringBuilder)localObject).append("  key=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" flag=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("Q..troop.faceScore", 2, ((StringBuilder)localObject).toString());
    }
    if (paramMessageRecord == null) {
      return;
    }
    try
    {
      if (TextUtils.isEmpty(paramMessageRecord.extStr))
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put(paramString, paramBoolean);
        paramMessageRecord.extStr = ((JSONObject)localObject).toString();
      }
      else
      {
        localObject = new JSONObject(paramMessageRecord.extStr);
        ((JSONObject)localObject).put(paramString, paramBoolean);
        paramMessageRecord.extStr = ((JSONObject)localObject).toString();
      }
      paramMessageRecord.extLong |= 0x1;
      return;
    }
    catch (JSONException paramMessageRecord)
    {
      paramMessageRecord.printStackTrace();
    }
  }
  
  public static void a(String paramString1, String paramString2, String... paramVarArgs)
  {
    ReportController.b(null, "dc00899", "grp_lbs", paramString2, "face_score", paramString1, 0, 0, a(0, paramVarArgs), a(1, paramVarArgs), a(2, paramVarArgs), a(3, paramVarArgs));
  }
  
  public static boolean a(MessageRecord paramMessageRecord, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getFaceScoreFlag, msg = ");
      localStringBuilder.append(paramMessageRecord);
      localStringBuilder.append("  key=");
      localStringBuilder.append(paramString);
      QLog.d("Q..troop.faceScore", 2, localStringBuilder.toString());
    }
    boolean bool2 = false;
    if (paramMessageRecord == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (paramMessageRecord.extStr != null)
    {
      bool1 = bool2;
      if ((paramMessageRecord.extLong & 0x1) == 1)
      {
        bool1 = bool2;
        if (paramMessageRecord.extStr.contains(paramString))
        {
          bool1 = bool2;
          if (paramMessageRecord.getExtInfoFromExtStr(paramString).equals("true")) {
            bool1 = true;
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("isFaceScoreGrayTips, ret=");
      paramString.append(bool1);
      paramString.append(", mr=");
      paramString.append(paramMessageRecord);
      QLog.d("PhotoPreviewActivity", 2, paramString.toString());
    }
    return bool1;
  }
  
  public static boolean b(AppInterface paramAppInterface, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("nearby_face_score_config_");
    ((StringBuilder)localObject).append(paramAppInterface.getCurrentAccountUin());
    localObject = ((StringBuilder)localObject).toString();
    paramAppInterface = paramAppInterface.getApplication().getApplicationContext().getSharedPreferences((String)localObject, 4);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("has_insert_face_score_msg_");
    ((StringBuilder)localObject).append(paramString);
    boolean bool = paramAppInterface.getBoolean(((StringBuilder)localObject).toString(), false);
    if (QLog.isColorLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("FaceScoreUtils.getHasInsertMsgFlag uin=");
      paramAppInterface.append(paramString);
      paramAppInterface.append("  flag=");
      paramAppInterface.append(bool);
      QLog.e("Q..troop.faceScore", 2, paramAppInterface.toString());
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.FaceScoreUtils
 * JD-Core Version:    0.7.0.1
 */