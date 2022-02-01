package com.tencent.qidian.data;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qidian.proto.mobileqq_qidian.ConfigCorpSimpleInfo;
import com.tencent.qidian.proto.mobileqq_qidian.ConfigInfo;

public class QidianProfileUiInfo$ConfigInfo
{
  public int a = 1;
  public int b = 0;
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public boolean g = false;
  public QidianProfileUiInfo.ConfigCorpSimpleInfo h;
  public String i = "";
  public String j = "";
  public String k = "";
  public int l = 0;
  
  public QidianProfileUiInfo$ConfigInfo() {}
  
  public QidianProfileUiInfo$ConfigInfo(mobileqq_qidian.ConfigInfo paramConfigInfo)
  {
    if (paramConfigInfo.uint32_type.has()) {
      this.a = paramConfigInfo.uint32_type.get();
    }
    if (paramConfigInfo.uint32_event.has()) {
      this.b = paramConfigInfo.uint32_event.get();
    }
    if (paramConfigInfo.str_title.has()) {
      this.c = paramConfigInfo.str_title.get();
    }
    if (paramConfigInfo.str_content.has()) {
      this.d = paramConfigInfo.str_content.get();
    }
    if (paramConfigInfo.str_action.has()) {
      this.e = paramConfigInfo.str_action.get();
    }
    if (paramConfigInfo.str_aaction.has()) {
      this.f = paramConfigInfo.str_aaction.get();
    }
    if (paramConfigInfo.msg_corp_simple.has()) {
      this.h = new QidianProfileUiInfo.ConfigCorpSimpleInfo(paramConfigInfo.msg_corp_simple);
    }
    if (paramConfigInfo.str_url.has()) {
      this.i = paramConfigInfo.str_url.get();
    }
    if (paramConfigInfo.str_lat.has()) {
      this.j = paramConfigInfo.str_lat.get();
    }
    if (paramConfigInfo.str_log.has()) {
      this.k = paramConfigInfo.str_log.get();
    }
    if (paramConfigInfo.uint32_title_type.has()) {
      this.l = paramConfigInfo.uint32_title_type.get();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qidian.data.QidianProfileUiInfo.ConfigInfo
 * JD-Core Version:    0.7.0.1
 */