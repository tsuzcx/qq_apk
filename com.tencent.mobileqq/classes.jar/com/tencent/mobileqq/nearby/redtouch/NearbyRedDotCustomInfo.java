package com.tencent.mobileqq.nearby.redtouch;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class NearbyRedDotCustomInfo
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public String d;
  
  public NearbyRedDotCustomInfo()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  public void a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if (paramRedTypeInfo == null) {
      return;
    }
    if (paramRedTypeInfo.red_desc.has())
    {
      Object localObject = paramRedTypeInfo.red_desc.get();
      try
      {
        localObject = new JSONObject((String)localObject);
        this.jdField_b_of_type_Boolean = ((JSONObject)localObject).optBoolean("isOfficialNotify");
        this.jdField_b_of_type_Int = ((JSONObject)localObject).optInt("redContentType");
        this.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("redContentMsg");
        this.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("topicId");
        this.jdField_c_of_type_Int = ((JSONObject)localObject).optInt("userType");
        this.jdField_c_of_type_JavaLangString = ((JSONObject)localObject).optString("msgId");
        this.jdField_a_of_type_Int = Integer.valueOf(paramRedTypeInfo.red_content.get()).intValue();
        this.d = ((JSONObject)localObject).optString("faceUrl");
        this.jdField_a_of_type_Long = ((JSONObject)localObject).optLong("uin");
        return;
      }
      catch (Exception paramRedTypeInfo)
      {
        paramRedTypeInfo.printStackTrace();
      }
    }
  }
  
  public void a(oidb_0x791.RedDotInfo paramRedDotInfo)
  {
    if (paramRedDotInfo == null) {
      return;
    }
    if ((paramRedDotInfo.str_custom_buffer.has()) && (!paramRedDotInfo.str_custom_buffer.get().isEmpty())) {
      paramRedDotInfo = paramRedDotInfo.str_custom_buffer.get().toStringUtf8();
    }
    for (;;)
    {
      try
      {
        paramRedDotInfo = new JSONObject(paramRedDotInfo);
        int i = paramRedDotInfo.optInt("official_topic");
        boolean bool2 = false;
        if (i != 1) {
          break label149;
        }
        bool1 = true;
        this.jdField_b_of_type_Boolean = bool1;
        this.jdField_b_of_type_Int = paramRedDotInfo.optInt("red_content_type");
        this.jdField_a_of_type_JavaLangString = paramRedDotInfo.optString("red_content_msg");
        this.jdField_b_of_type_JavaLangString = paramRedDotInfo.optString("red_topic_tag");
        this.jdField_c_of_type_Int = paramRedDotInfo.optInt("red_user_type");
        bool1 = bool2;
        if (paramRedDotInfo.optInt("red_type") == 0) {
          bool1 = true;
        }
        this.jdField_a_of_type_Boolean = bool1;
        this.jdField_c_of_type_JavaLangString = paramRedDotInfo.optString("red_msg_id");
        return;
      }
      catch (Exception paramRedDotInfo)
      {
        paramRedDotInfo.printStackTrace();
      }
      return;
      label149:
      boolean bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.redtouch.NearbyRedDotCustomInfo
 * JD-Core Version:    0.7.0.1
 */