package com.tencent.mobileqq.qzonevip.gift;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class QzoneGiftManager$GiftData
{
  public int a;
  public String a;
  public String b;
  public String c;
  public String d;
  
  public static GiftData a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    GiftData localGiftData = new GiftData();
    try
    {
      paramString = new JSONObject(paramString);
      localGiftData.jdField_a_of_type_Int = paramString.optInt("animationType");
      localGiftData.jdField_a_of_type_JavaLangString = paramString.optString("boxZipUrl", null);
      localGiftData.b = paramString.optString("giftZipUrl", null);
      localGiftData.c = paramString.optString("giftParticleUrl", null);
      localGiftData.d = paramString.optString("lottieUrl", null);
      return localGiftData;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      QLog.e("QzoneGiftManager", 1, "handleFlashChatConfig failed" + paramString);
    }
    return localGiftData;
  }
  
  public String toString()
  {
    return " mBoxZipUrl = " + this.jdField_a_of_type_JavaLangString + " mGiftZipUrl = " + this.b + " mGiftUrl = " + this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qzonevip.gift.QzoneGiftManager.GiftData
 * JD-Core Version:    0.7.0.1
 */