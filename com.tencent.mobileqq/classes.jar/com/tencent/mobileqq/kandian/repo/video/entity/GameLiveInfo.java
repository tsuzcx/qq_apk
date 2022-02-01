package com.tencent.mobileqq.kandian.repo.video.entity;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.articlesummary.articlesummary.GameLiveInfo;

public class GameLiveInfo
{
  public String a;
  public int b;
  public int c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  
  public static GameLiveInfo a(articlesummary.GameLiveInfo paramGameLiveInfo)
  {
    GameLiveInfo localGameLiveInfo = new GameLiveInfo();
    if (paramGameLiveInfo.bytes_play_bill_id.has()) {
      localGameLiveInfo.a = paramGameLiveInfo.bytes_play_bill_id.get().toStringUtf8();
    }
    if (paramGameLiveInfo.uint32_status.has()) {
      localGameLiveInfo.b = paramGameLiveInfo.uint32_status.get();
    }
    if (paramGameLiveInfo.uint32_audience_count.has()) {
      localGameLiveInfo.c = paramGameLiveInfo.uint32_audience_count.get();
    }
    if (paramGameLiveInfo.bytes_game_name.has()) {
      localGameLiveInfo.f = paramGameLiveInfo.bytes_game_name.get().toStringUtf8();
    }
    if (paramGameLiveInfo.bytes_play_url.has()) {
      localGameLiveInfo.e = paramGameLiveInfo.bytes_play_url.get().toStringUtf8();
    }
    if (paramGameLiveInfo.bytes_tips_wording.has()) {
      localGameLiveInfo.g = paramGameLiveInfo.bytes_tips_wording.get().toStringUtf8();
    }
    if (paramGameLiveInfo.bytes_status.has()) {
      localGameLiveInfo.h = paramGameLiveInfo.bytes_status.get().toStringUtf8();
    }
    if (paramGameLiveInfo.bytes_status_icon_url.has()) {
      localGameLiveInfo.i = paramGameLiveInfo.bytes_status_icon_url.get().toStringUtf8();
    }
    return localGameLiveInfo;
  }
  
  public static articlesummary.GameLiveInfo a(GameLiveInfo paramGameLiveInfo)
  {
    articlesummary.GameLiveInfo localGameLiveInfo = new articlesummary.GameLiveInfo();
    if (!TextUtils.isEmpty(paramGameLiveInfo.a)) {
      localGameLiveInfo.bytes_play_bill_id.set(ByteStringMicro.copyFromUtf8(paramGameLiveInfo.a));
    }
    localGameLiveInfo.uint32_status.set(paramGameLiveInfo.b);
    localGameLiveInfo.uint32_audience_count.set(paramGameLiveInfo.c);
    if (!TextUtils.isEmpty(paramGameLiveInfo.f)) {
      localGameLiveInfo.bytes_game_name.set(ByteStringMicro.copyFromUtf8(paramGameLiveInfo.f));
    }
    if (!TextUtils.isEmpty(paramGameLiveInfo.e)) {
      localGameLiveInfo.bytes_play_url.set(ByteStringMicro.copyFromUtf8(paramGameLiveInfo.e));
    }
    if (!TextUtils.isEmpty(paramGameLiveInfo.g)) {
      localGameLiveInfo.bytes_tips_wording.set(ByteStringMicro.copyFromUtf8(paramGameLiveInfo.g));
    }
    if (!TextUtils.isEmpty(paramGameLiveInfo.h)) {
      localGameLiveInfo.bytes_status.set(ByteStringMicro.copyFromUtf8(paramGameLiveInfo.h));
    }
    if (!TextUtils.isEmpty(paramGameLiveInfo.i)) {
      localGameLiveInfo.bytes_status_icon_url.set(ByteStringMicro.copyFromUtf8(paramGameLiveInfo.i));
    }
    return localGameLiveInfo;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GameLiveInfo{playBillId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", status=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", audienceCount=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", audiences=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", playUrl=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", gameName=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", tipsWording=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", liveStatus=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", statusIconUrl=");
    localStringBuilder.append(this.i);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.video.entity.GameLiveInfo
 * JD-Core Version:    0.7.0.1
 */