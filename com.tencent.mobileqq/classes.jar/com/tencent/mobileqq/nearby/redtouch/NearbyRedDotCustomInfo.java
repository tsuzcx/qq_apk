package com.tencent.mobileqq.nearby.redtouch;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class NearbyRedDotCustomInfo
{
  public int a = 0;
  public boolean b = false;
  public boolean c = false;
  public int d = 1;
  public int e = 0;
  public String f;
  public String g = "";
  public String h = "";
  public String i;
  public long j;
  
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
        this.c = ((JSONObject)localObject).optBoolean("isOfficialNotify");
        this.d = ((JSONObject)localObject).optInt("redContentType");
        this.f = ((JSONObject)localObject).optString("redContentMsg");
        this.g = ((JSONObject)localObject).optString("topicId");
        this.e = ((JSONObject)localObject).optInt("userType");
        this.h = ((JSONObject)localObject).optString("msgId");
        this.a = Integer.valueOf(paramRedTypeInfo.red_content.get()).intValue();
        this.i = ((JSONObject)localObject).optString("faceUrl");
        this.j = ((JSONObject)localObject).optLong("uin");
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
        int k = paramRedDotInfo.optInt("official_topic");
        boolean bool2 = false;
        if (k != 1) {
          break label149;
        }
        bool1 = true;
        this.c = bool1;
        this.d = paramRedDotInfo.optInt("red_content_type");
        this.f = paramRedDotInfo.optString("red_content_msg");
        this.g = paramRedDotInfo.optString("red_topic_tag");
        this.e = paramRedDotInfo.optInt("red_user_type");
        bool1 = bool2;
        if (paramRedDotInfo.optInt("red_type") == 0) {
          bool1 = true;
        }
        this.b = bool1;
        this.h = paramRedDotInfo.optString("red_msg_id");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.redtouch.NearbyRedDotCustomInfo
 * JD-Core Version:    0.7.0.1
 */