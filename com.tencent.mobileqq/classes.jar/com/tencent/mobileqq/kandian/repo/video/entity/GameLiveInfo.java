package com.tencent.mobileqq.kandian.repo.video.entity;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.articlesummary.articlesummary.GameLiveInfo;

public class GameLiveInfo
{
  public int a;
  public String a;
  public int b;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  
  public static GameLiveInfo a(articlesummary.GameLiveInfo paramGameLiveInfo)
  {
    GameLiveInfo localGameLiveInfo = new GameLiveInfo();
    if (paramGameLiveInfo.bytes_play_bill_id.has()) {
      localGameLiveInfo.jdField_a_of_type_JavaLangString = paramGameLiveInfo.bytes_play_bill_id.get().toStringUtf8();
    }
    if (paramGameLiveInfo.uint32_status.has()) {
      localGameLiveInfo.jdField_a_of_type_Int = paramGameLiveInfo.uint32_status.get();
    }
    if (paramGameLiveInfo.uint32_audience_count.has()) {
      localGameLiveInfo.jdField_b_of_type_Int = paramGameLiveInfo.uint32_audience_count.get();
    }
    if (paramGameLiveInfo.bytes_game_name.has()) {
      localGameLiveInfo.d = paramGameLiveInfo.bytes_game_name.get().toStringUtf8();
    }
    if (paramGameLiveInfo.bytes_play_url.has()) {
      localGameLiveInfo.c = paramGameLiveInfo.bytes_play_url.get().toStringUtf8();
    }
    if (paramGameLiveInfo.bytes_tips_wording.has()) {
      localGameLiveInfo.e = paramGameLiveInfo.bytes_tips_wording.get().toStringUtf8();
    }
    if (paramGameLiveInfo.bytes_status.has()) {
      localGameLiveInfo.f = paramGameLiveInfo.bytes_status.get().toStringUtf8();
    }
    if (paramGameLiveInfo.bytes_status_icon_url.has()) {
      localGameLiveInfo.g = paramGameLiveInfo.bytes_status_icon_url.get().toStringUtf8();
    }
    return localGameLiveInfo;
  }
  
  public static articlesummary.GameLiveInfo a(GameLiveInfo paramGameLiveInfo)
  {
    articlesummary.GameLiveInfo localGameLiveInfo = new articlesummary.GameLiveInfo();
    if (!TextUtils.isEmpty(paramGameLiveInfo.jdField_a_of_type_JavaLangString)) {
      localGameLiveInfo.bytes_play_bill_id.set(ByteStringMicro.copyFromUtf8(paramGameLiveInfo.jdField_a_of_type_JavaLangString));
    }
    localGameLiveInfo.uint32_status.set(paramGameLiveInfo.jdField_a_of_type_Int);
    localGameLiveInfo.uint32_audience_count.set(paramGameLiveInfo.jdField_b_of_type_Int);
    if (!TextUtils.isEmpty(paramGameLiveInfo.d)) {
      localGameLiveInfo.bytes_game_name.set(ByteStringMicro.copyFromUtf8(paramGameLiveInfo.d));
    }
    if (!TextUtils.isEmpty(paramGameLiveInfo.c)) {
      localGameLiveInfo.bytes_play_url.set(ByteStringMicro.copyFromUtf8(paramGameLiveInfo.c));
    }
    if (!TextUtils.isEmpty(paramGameLiveInfo.e)) {
      localGameLiveInfo.bytes_tips_wording.set(ByteStringMicro.copyFromUtf8(paramGameLiveInfo.e));
    }
    if (!TextUtils.isEmpty(paramGameLiveInfo.f)) {
      localGameLiveInfo.bytes_status.set(ByteStringMicro.copyFromUtf8(paramGameLiveInfo.f));
    }
    if (!TextUtils.isEmpty(paramGameLiveInfo.g)) {
      localGameLiveInfo.bytes_status_icon_url.set(ByteStringMicro.copyFromUtf8(paramGameLiveInfo.g));
    }
    return localGameLiveInfo;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GameLiveInfo{playBillId=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", status=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", audienceCount=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", audiences=");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", playUrl=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", gameName=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", tipsWording=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", liveStatus=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", statusIconUrl=");
    localStringBuilder.append(this.g);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.video.entity.GameLiveInfo
 * JD-Core Version:    0.7.0.1
 */