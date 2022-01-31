package com.tencent.mobileqq.nearby;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class FaceScoreUtils
{
  public static HashSet a = new HashSet();
  
  public static FaceScoreConfig a(AppInterface paramAppInterface)
  {
    FaceScoreConfig localFaceScoreConfig = new FaceScoreConfig();
    String str = "nearby_face_score_config_" + paramAppInterface.getCurrentAccountUin();
    paramAppInterface = paramAppInterface.getApplication().getApplicationContext().getSharedPreferences(str, 4);
    localFaceScoreConfig.jdField_a_of_type_Boolean = paramAppInterface.getBoolean("isShowCard", false);
    localFaceScoreConfig.jdField_b_of_type_Boolean = paramAppInterface.getBoolean("isShowList", false);
    localFaceScoreConfig.jdField_a_of_type_Long = paramAppInterface.getLong("expireTime", 0L);
    localFaceScoreConfig.jdField_a_of_type_JavaLangString = paramAppInterface.getString("entranceJumpUrl", "");
    localFaceScoreConfig.jdField_b_of_type_JavaLangString = paramAppInterface.getString("entranceJumpUrlForHost", "");
    localFaceScoreConfig.c = paramAppInterface.getString("entranceJumpUrlForGuest", "");
    if (QLog.isColorLevel()) {
      QLog.e("Q..troop.faceScore", 2, "FaceScoreUtils.getConfig config.expireTime=" + localFaceScoreConfig.jdField_a_of_type_Boolean + "  config.isShowList=" + localFaceScoreConfig.jdField_b_of_type_Boolean + "  config.expireTime=" + localFaceScoreConfig.jdField_a_of_type_Long + "  config.entranceJumpUrl=" + localFaceScoreConfig.jdField_a_of_type_JavaLangString + "  config.entranceJumpUrlForHost=" + localFaceScoreConfig.jdField_b_of_type_JavaLangString + "  config.entranceJumpUrlForGuest=" + localFaceScoreConfig.c);
    }
    return localFaceScoreConfig;
  }
  
  public static String a(int paramInt, String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= paramInt)) {
      return "";
    }
    return paramVarArgs[paramInt];
  }
  
  public static void a(AppInterface paramAppInterface, FaceScoreConfig paramFaceScoreConfig)
  {
    try
    {
      String str = "nearby_face_score_config_" + paramAppInterface.getCurrentAccountUin();
      paramAppInterface.getApplication().getApplicationContext().getSharedPreferences(str, 4).edit().putBoolean("isShowCard", paramFaceScoreConfig.jdField_a_of_type_Boolean).putBoolean("isShowList", paramFaceScoreConfig.jdField_b_of_type_Boolean).putLong("expireTime", paramFaceScoreConfig.jdField_a_of_type_Long).putString("entranceJumpUrl", paramFaceScoreConfig.jdField_a_of_type_JavaLangString).putString("entranceJumpUrlForHost", paramFaceScoreConfig.jdField_b_of_type_JavaLangString).putString("entranceJumpUrlForGuest", paramFaceScoreConfig.c).commit();
      if (QLog.isColorLevel()) {
        QLog.e("Q..troop.faceScore", 2, "FaceScoreUtils.saveConfig config.expireTime=" + paramFaceScoreConfig.jdField_a_of_type_Boolean + "  config.isShowList=" + paramFaceScoreConfig.jdField_b_of_type_Boolean + "  config.expireTime=" + paramFaceScoreConfig.jdField_a_of_type_Long + "  config.entranceJumpUrl=" + paramFaceScoreConfig.jdField_a_of_type_JavaLangString + "  config.entranceJumpUrlForHost=" + paramFaceScoreConfig.jdField_b_of_type_JavaLangString + "  config.entranceJumpUrlForGuest=" + paramFaceScoreConfig.c);
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
    String str = "nearby_face_score_config_" + paramAppInterface.getCurrentAccountUin();
    paramAppInterface = paramAppInterface.getApplication().getApplicationContext().getSharedPreferences(str, 4);
    str = "has_insert_face_score_msg_" + paramString;
    paramAppInterface.edit().putBoolean(str, true).commit();
    if (QLog.isColorLevel()) {
      QLog.e("Q..troop.faceScore", 2, "FaceScoreUtils.setHasInsertMsgFlag uin=" + paramString);
    }
  }
  
  public static void a(MessageRecord paramMessageRecord, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q..troop.faceScore", 2, "setFaceScoreFlag, msg = " + paramMessageRecord + "  key=" + paramString + " flag=" + paramBoolean);
    }
    if (paramMessageRecord == null) {
      return;
    }
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramMessageRecord.extStr))
        {
          localJSONObject = new JSONObject();
          localJSONObject.put(paramString, paramBoolean);
          paramMessageRecord.extStr = localJSONObject.toString();
          paramMessageRecord.extLong |= 0x1;
          return;
        }
      }
      catch (JSONException paramMessageRecord)
      {
        paramMessageRecord.printStackTrace();
        return;
      }
      JSONObject localJSONObject = new JSONObject(paramMessageRecord.extStr);
      localJSONObject.put(paramString, paramBoolean);
      paramMessageRecord.extStr = localJSONObject.toString();
    }
  }
  
  public static void a(String paramString1, String paramString2, String... paramVarArgs)
  {
    ReportController.b(null, "dc00899", "grp_lbs", paramString2, "face_score", paramString1, 0, 0, a(0, paramVarArgs), a(1, paramVarArgs), a(2, paramVarArgs), a(3, paramVarArgs));
  }
  
  public static boolean a(AppInterface paramAppInterface, String paramString)
  {
    String str = "nearby_face_score_config_" + paramAppInterface.getCurrentAccountUin();
    boolean bool = paramAppInterface.getApplication().getApplicationContext().getSharedPreferences(str, 4).getBoolean("has_insert_face_score_msg_" + paramString, false);
    if (QLog.isColorLevel()) {
      QLog.e("Q..troop.faceScore", 2, "FaceScoreUtils.getHasInsertMsgFlag uin=" + paramString + "  flag=" + bool);
    }
    return bool;
  }
  
  public static boolean a(MessageRecord paramMessageRecord, String paramString)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("Q..troop.faceScore", 2, "getFaceScoreFlag, msg = " + paramMessageRecord + "  key=" + paramString);
    }
    if (paramMessageRecord == null) {
      return false;
    }
    if ((paramMessageRecord.extStr != null) && ((paramMessageRecord.extLong & 0x1) == 1) && (paramMessageRecord.extStr.contains(paramString)) && (paramMessageRecord.getExtInfoFromExtStr(paramString).equals("true"))) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q..troop.faceScore.FaceScoreUtils", 2, "isFaceScoreGrayTips, ret=" + bool + ", mr=" + paramMessageRecord);
      }
      return bool;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.FaceScoreUtils
 * JD-Core Version:    0.7.0.1
 */