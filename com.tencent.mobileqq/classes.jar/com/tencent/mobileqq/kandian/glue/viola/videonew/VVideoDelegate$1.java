package com.tencent.mobileqq.kandian.glue.viola.videonew;

import com.tencent.mobileqq.kandian.biz.video.ReadInJoyPlayerFactory;
import com.tencent.mobileqq.kandian.biz.video.api.IReadInJoyPlayerFactory;
import com.tencent.mobileqq.kandian.glue.video.player.ReadInJoyPlayer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

class VVideoDelegate$1
  implements Function1<Unit, ReadInJoyPlayer>
{
  VVideoDelegate$1(VVideoDelegate paramVVideoDelegate, int paramInt, String paramString, boolean paramBoolean) {}
  
  public ReadInJoyPlayer a(Unit paramUnit)
  {
    return (ReadInJoyPlayer)ReadInJoyPlayerFactory.get().createPlayer(this.a, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.videonew.VVideoDelegate.1
 * JD-Core Version:    0.7.0.1
 */