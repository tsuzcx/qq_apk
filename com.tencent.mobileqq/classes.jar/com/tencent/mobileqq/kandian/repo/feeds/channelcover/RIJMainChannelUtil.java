package com.tencent.mobileqq.kandian.repo.feeds.channelcover;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJMaybeInitializedAladdinConfig;
import com.tencent.mobileqq.kandian.repo.xtab.api.impl.RIJXTabConfigHandler;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/feeds/channelcover/RIJMainChannelUtil;", "", "()V", "TAG", "", "hasInit", "", "lock", "mainFeedsChannelId", "", "mainFeedsChannelName", "mainFeedsViolaUrl", "getMainFeedsChannelId", "getMainFeedsChannelName", "getMainFeedsViolaUrl", "init", "", "reset", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJMainChannelUtil
{
  public static final RIJMainChannelUtil a = new RIJMainChannelUtil();
  private static int b = -1;
  private static String c = "";
  private static String d = "";
  private static boolean e;
  private static final Object f = new Object();
  
  public final void a()
  {
    if (e) {
      return;
    }
    synchronized (f)
    {
      boolean bool = e;
      if (bool) {
        return;
      }
      RIJMaybeInitializedAladdinConfig.a();
      Object localObject2 = Aladdin.getConfig(220);
      b = ((AladdinConfig)localObject2).getIntegerFromString("main_feeds_channel_id", -1);
      String str = ((AladdinConfig)localObject2).getString("main_feeds_channel_name", "");
      Intrinsics.checkExpressionValueIsNotNull(str, "config.getString(\"main_feeds_channel_name\", \"\")");
      c = str;
      localObject2 = ((AladdinConfig)localObject2).getString("main_feeds_viola_url", "");
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "config.getString(\"main_feeds_viola_url\", \"\")");
      d = (String)localObject2;
      e = true;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[init] mainFeedsChannelId = ");
      ((StringBuilder)localObject2).append(b);
      ((StringBuilder)localObject2).append(", mainFeedsChannelName = ");
      ((StringBuilder)localObject2).append(c);
      ((StringBuilder)localObject2).append(", mainFeedsViolaUrl = ");
      ((StringBuilder)localObject2).append(d);
      QLog.i("RIJMainChannelUtil", 1, ((StringBuilder)localObject2).toString());
      localObject2 = Unit.INSTANCE;
      return;
    }
  }
  
  public final void b()
  {
    e = false;
    b = -1;
    c = "";
    d = "";
  }
  
  public final int c()
  {
    a();
    if (RIJXTabConfigHandler.INSTANCE.isXTabMode()) {
      return 0;
    }
    return b;
  }
  
  @NotNull
  public final String d()
  {
    a();
    return c;
  }
  
  @NotNull
  public final String e()
  {
    a();
    return d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.channelcover.RIJMainChannelUtil
 * JD-Core Version:    0.7.0.1
 */