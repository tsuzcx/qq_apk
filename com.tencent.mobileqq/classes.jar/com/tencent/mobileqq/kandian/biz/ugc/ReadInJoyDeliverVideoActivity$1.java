package com.tencent.mobileqq.kandian.biz.ugc;

import android.os.Bundle;
import android.widget.EditText;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.share.KingMomentInfo;

class ReadInJoyDeliverVideoActivity$1
  extends ReadInJoyObserver
{
  ReadInJoyDeliverVideoActivity$1(ReadInJoyDeliverVideoActivity paramReadInJoyDeliverVideoActivity) {}
  
  public void a(int paramInt, KingMomentInfo paramKingMomentInfo)
  {
    if ((paramInt == 0) && (ReadInJoyDeliverVideoActivity.a(this.a)))
    {
      ReadInJoyDeliverVideoActivity.a(this.a, new Bundle());
      ReadInJoyDeliverVideoActivity.a(this.a).putString("arg_video_cover_url", paramKingMomentInfo.h);
      ReadInJoyDeliverVideoActivity.a(this.a).putString("arg_video_url", paramKingMomentInfo.g);
      ReadInJoyDeliverVideoActivity.a(this.a).putString("arg_video_title", paramKingMomentInfo.jdField_d_of_type_JavaLangString);
      ReadInJoyDeliverVideoActivity.a(this.a).putString("arg_video_uuid", paramKingMomentInfo.f);
      ReadInJoyDeliverVideoActivity.a(this.a).putLong("arg_video_duration", paramKingMomentInfo.jdField_a_of_type_Long);
      ReadInJoyDeliverVideoActivity.a(this.a).putInt("arg_video_cover_width", paramKingMomentInfo.c);
      ReadInJoyDeliverVideoActivity.a(this.a).putInt("arg_video_cover_height", paramKingMomentInfo.jdField_b_of_type_Int);
      ReadInJoyDeliverVideoActivity.a(this.a).putInt("arg_video_width", paramKingMomentInfo.e);
      ReadInJoyDeliverVideoActivity.a(this.a).putInt("arg_video_height", paramKingMomentInfo.jdField_d_of_type_Int);
      Object localObject = ReadInJoyDeliverVideoActivity.a(this.a);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramKingMomentInfo.jdField_a_of_type_Int);
      localStringBuilder.append("");
      ((Bundle)localObject).putString("arg_topic_id", localStringBuilder.toString());
      localObject = this.a.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("#");
      localStringBuilder.append(paramKingMomentInfo.jdField_a_of_type_JavaLangString);
      localStringBuilder.append("#");
      ((EditText)localObject).setHint(localStringBuilder.toString());
      ReadInJoyDeliverVideoActivity.a(this.a, paramKingMomentInfo.jdField_b_of_type_JavaLangString);
      ReadInJoyDeliverVideoActivity.a(this.a, true);
      ReadInJoyDeliverVideoActivity.a(this.a, paramKingMomentInfo.h);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDeliverVideoActivity.1
 * JD-Core Version:    0.7.0.1
 */