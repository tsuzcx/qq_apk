package com.tencent.mobileqq.kandian.biz.ugc;

import android.os.Bundle;
import com.tencent.mobileqq.kandian.biz.biu.BiuEditText;
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
      ReadInJoyDeliverVideoActivity.b(this.a).putString("arg_video_cover_url", paramKingMomentInfo.i);
      ReadInJoyDeliverVideoActivity.b(this.a).putString("arg_video_url", paramKingMomentInfo.h);
      ReadInJoyDeliverVideoActivity.b(this.a).putString("arg_video_title", paramKingMomentInfo.e);
      ReadInJoyDeliverVideoActivity.b(this.a).putString("arg_video_uuid", paramKingMomentInfo.g);
      ReadInJoyDeliverVideoActivity.b(this.a).putLong("arg_video_duration", paramKingMomentInfo.l);
      ReadInJoyDeliverVideoActivity.b(this.a).putInt("arg_video_cover_width", paramKingMomentInfo.k);
      ReadInJoyDeliverVideoActivity.b(this.a).putInt("arg_video_cover_height", paramKingMomentInfo.j);
      ReadInJoyDeliverVideoActivity.b(this.a).putInt("arg_video_width", paramKingMomentInfo.n);
      ReadInJoyDeliverVideoActivity.b(this.a).putInt("arg_video_height", paramKingMomentInfo.m);
      Object localObject = ReadInJoyDeliverVideoActivity.b(this.a);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramKingMomentInfo.a);
      localStringBuilder.append("");
      ((Bundle)localObject).putString("arg_topic_id", localStringBuilder.toString());
      localObject = this.a.e;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("#");
      localStringBuilder.append(paramKingMomentInfo.b);
      localStringBuilder.append("#");
      ((BiuEditText)localObject).setHint(localStringBuilder.toString());
      ReadInJoyDeliverVideoActivity.a(this.a, paramKingMomentInfo.c);
      ReadInJoyDeliverVideoActivity.a(this.a, true);
      ReadInJoyDeliverVideoActivity.b(this.a, paramKingMomentInfo.i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDeliverVideoActivity.1
 * JD-Core Version:    0.7.0.1
 */