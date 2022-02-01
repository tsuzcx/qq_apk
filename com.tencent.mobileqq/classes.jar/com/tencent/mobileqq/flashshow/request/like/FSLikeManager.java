package com.tencent.mobileqq.flashshow.request.like;

import com.tencent.mobileqq.flashshow.data.call.FSRequestCall;
import com.tencent.mobileqq.flashshow.request.FSBaseRequest;
import com.tencent.mobileqq.flashshow.sender.FSRequestSender;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.richframework.sender.call.BaseCall;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;

public class FSLikeManager
{
  private static String a = "FSLikeManager";
  
  public static void a(FeedCloudMeta.StFeed paramStFeed)
  {
    a(paramStFeed, true);
  }
  
  private static void a(FeedCloudMeta.StFeed paramStFeed, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramStFeed.likeInfo.status.get() == 1)) {
      return;
    }
    if ((!paramBoolean) && (paramStFeed.likeInfo.status.get() == 0)) {
      return;
    }
    paramStFeed = b(paramStFeed, paramBoolean);
    if (paramStFeed == null) {
      return;
    }
    FSRequestSender.a().b().b(new FSLikeFakeInterceptor(true, null)).a(paramStFeed).a(new FSLikeManager.1(paramBoolean)).a();
  }
  
  private static FSBaseRequest b(FeedCloudMeta.StFeed paramStFeed, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static void b(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {
      return;
    }
    if (paramStFeed.likeInfo.status.get() == 1)
    {
      a(paramStFeed, false);
      return;
    }
    if (paramStFeed.likeInfo.status.get() == 0) {
      a(paramStFeed, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.request.like.FSLikeManager
 * JD-Core Version:    0.7.0.1
 */