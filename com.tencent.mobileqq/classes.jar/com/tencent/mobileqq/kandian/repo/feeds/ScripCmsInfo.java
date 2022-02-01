package com.tencent.mobileqq.kandian.repo.feeds;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.articlesummary.articlesummary.ScripCmsInfo;

public class ScripCmsInfo
  implements Cloneable
{
  public static int n;
  public static int o;
  public String a = "";
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public String h = "";
  public String i = "";
  public int j = 1;
  public long k = 0L;
  public String l = "";
  public int m = 0;
  
  public static ScripCmsInfo a(articlesummary.ScripCmsInfo paramScripCmsInfo)
  {
    ScripCmsInfo localScripCmsInfo = new ScripCmsInfo();
    localScripCmsInfo.a = paramScripCmsInfo.bytes_main_title.get().toStringUtf8();
    localScripCmsInfo.b = paramScripCmsInfo.bytes_sub_title.get().toStringUtf8();
    localScripCmsInfo.c = paramScripCmsInfo.bytes_background_url.get().toStringUtf8();
    localScripCmsInfo.d = paramScripCmsInfo.bytes_left_bottom_txt.get().toStringUtf8();
    localScripCmsInfo.e = paramScripCmsInfo.bytes_icon_url.get().toStringUtf8();
    localScripCmsInfo.f = paramScripCmsInfo.bytes_background_animation_url.get().toStringUtf8();
    localScripCmsInfo.g = paramScripCmsInfo.bytes_guide_main_title.get().toStringUtf8();
    localScripCmsInfo.h = paramScripCmsInfo.bytes_guide_sub_title.get().toStringUtf8();
    localScripCmsInfo.i = paramScripCmsInfo.bytes_guide_background_url.get().toStringUtf8();
    localScripCmsInfo.k = paramScripCmsInfo.uint64_from_uin.get();
    localScripCmsInfo.l = paramScripCmsInfo.bytes_scrip_tag.get().toStringUtf8();
    n = paramScripCmsInfo.uint32_scrip_total_sum.get();
    o = paramScripCmsInfo.uint32_frequency_limit.get();
    return localScripCmsInfo;
  }
  
  public ScripCmsInfo a()
  {
    try
    {
      super.clone();
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScripCmsInfo", 2, new Object[] { "Clone not support: ", localCloneNotSupportedException.toString() });
      }
    }
    ScripCmsInfo localScripCmsInfo = new ScripCmsInfo();
    localScripCmsInfo.a = this.a;
    localScripCmsInfo.b = this.b;
    localScripCmsInfo.c = this.c;
    localScripCmsInfo.d = this.d;
    localScripCmsInfo.e = this.e;
    localScripCmsInfo.f = this.f;
    localScripCmsInfo.i = this.i;
    localScripCmsInfo.g = this.g;
    localScripCmsInfo.h = this.h;
    localScripCmsInfo.j = this.j;
    localScripCmsInfo.k = this.k;
    localScripCmsInfo.l = this.l;
    return localScripCmsInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.ScripCmsInfo
 * JD-Core Version:    0.7.0.1
 */