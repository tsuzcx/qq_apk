package com.tencent.mobileqq.intervideo.huiyin;

import android.net.Uri;
import android.util.Log;
import atbn;
import atbo;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public final class FileUploadUtil$1
  implements Runnable
{
  public FileUploadUtil$1(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, atbo paramatbo) {}
  
  public void run()
  {
    atbn.a(atbn.a());
    HashMap localHashMap = new HashMap();
    atbn.b("sex=" + this.jdField_a_of_type_JavaLangString + ";user_name=" + this.b + ";ilive_tinyid=" + this.c + ";ilive_a2=" + this.d + ";ilive_login_type=0;ilive_uin=" + this.e + ";");
    localHashMap.put("sex", this.jdField_a_of_type_JavaLangString);
    localHashMap.put("voice_word", Uri.encode(this.f));
    try
    {
      atbn.a(this.g, localHashMap, new File(this.h), this.jdField_a_of_type_Atbo);
      return;
    }
    catch (Exception localException)
    {
      Log.e("HuiyinFileUpload", localException.getLocalizedMessage());
      this.jdField_a_of_type_Atbo.a(1, localException.getLocalizedMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huiyin.FileUploadUtil.1
 * JD-Core Version:    0.7.0.1
 */