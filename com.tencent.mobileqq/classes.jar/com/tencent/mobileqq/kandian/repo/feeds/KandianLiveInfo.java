package com.tencent.mobileqq.kandian.repo.feeds;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.articlesummary.articlesummary.KdLiveInfo;

public class KandianLiveInfo
{
  public int a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  
  public static KandianLiveInfo a(articlesummary.KdLiveInfo paramKdLiveInfo)
  {
    KandianLiveInfo localKandianLiveInfo = new KandianLiveInfo();
    localKandianLiveInfo.a = paramKdLiveInfo.uint32_style_type.get();
    localKandianLiveInfo.b = paramKdLiveInfo.bytes_status_bg_url.get().toStringUtf8();
    localKandianLiveInfo.c = paramKdLiveInfo.bytes_status_icon_url.get().toStringUtf8();
    localKandianLiveInfo.d = paramKdLiveInfo.bytes_status_text.get().toStringUtf8();
    localKandianLiveInfo.e = paramKdLiveInfo.bytes_hot_icon_url.get().toStringUtf8();
    localKandianLiveInfo.f = paramKdLiveInfo.bytes_hot_text.get().toStringUtf8();
    localKandianLiveInfo.g = paramKdLiveInfo.bytes_title_jump_url.get().toStringUtf8();
    localKandianLiveInfo.h = paramKdLiveInfo.bytes_report_common_data.get().toStringUtf8();
    return localKandianLiveInfo;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\n");
    localStringBuilder.append("style=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("\n");
    localStringBuilder.append("statusBgUrl=");
    localStringBuilder.append(this.b);
    localStringBuilder.append("\n");
    localStringBuilder.append("statusIconUrl=");
    localStringBuilder.append(this.c);
    localStringBuilder.append("\n");
    localStringBuilder.append("statusText=");
    localStringBuilder.append(this.d);
    localStringBuilder.append("\n");
    localStringBuilder.append("hotIconUrl=");
    localStringBuilder.append(this.e);
    localStringBuilder.append("\n");
    localStringBuilder.append("hotText=");
    localStringBuilder.append(this.f);
    localStringBuilder.append("\n");
    localStringBuilder.append("titleJumpUrl=");
    localStringBuilder.append(this.g);
    localStringBuilder.append("\n");
    localStringBuilder.append("reportCommonData=");
    localStringBuilder.append(this.h);
    localStringBuilder.append("\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.KandianLiveInfo
 * JD-Core Version:    0.7.0.1
 */