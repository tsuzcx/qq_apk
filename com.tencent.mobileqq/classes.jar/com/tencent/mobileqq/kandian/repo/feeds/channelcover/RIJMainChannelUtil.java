package com.tencent.mobileqq.kandian.repo.feeds.channelcover;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJMaybeInitializedAladdinConfig;
import com.tencent.mobileqq.kandian.repo.xtab.api.IRIJXTabConfigHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/feeds/channelcover/RIJMainChannelUtil;", "", "()V", "TAG", "", "hasInit", "", "lock", "mainFeedsChannelId", "", "mainFeedsChannelName", "mainFeedsViolaUrl", "getMainFeedsChannelId", "getMainFeedsChannelName", "getMainFeedsViolaUrl", "init", "", "reset", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJMainChannelUtil
{
  private static int jdField_a_of_type_Int;
  public static final RIJMainChannelUtil a;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static String jdField_a_of_type_JavaLangString;
  private static boolean jdField_a_of_type_Boolean;
  private static String b;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsChannelcoverRIJMainChannelUtil = new RIJMainChannelUtil();
    jdField_a_of_type_Int = -1;
    jdField_a_of_type_JavaLangString = "";
    b = "";
  }
  
  public final int a()
  {
    a();
    if (((IRIJXTabConfigHandler)QRoute.api(IRIJXTabConfigHandler.class)).isXTabMode()) {
      return 0;
    }
    return jdField_a_of_type_Int;
  }
  
  @NotNull
  public final String a()
  {
    a();
    return jdField_a_of_type_JavaLangString;
  }
  
  public final void a()
  {
    if (jdField_a_of_type_Boolean) {
      return;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      boolean bool = jdField_a_of_type_Boolean;
      if (bool) {
        return;
      }
      RIJMaybeInitializedAladdinConfig.a();
      Object localObject2 = Aladdin.getConfig(220);
      jdField_a_of_type_Int = ((AladdinConfig)localObject2).getIntegerFromString("main_feeds_channel_id", -1);
      String str = ((AladdinConfig)localObject2).getString("main_feeds_channel_name", "");
      Intrinsics.checkExpressionValueIsNotNull(str, "config.getString(\"main_feeds_channel_name\", \"\")");
      jdField_a_of_type_JavaLangString = str;
      localObject2 = ((AladdinConfig)localObject2).getString("main_feeds_viola_url", "");
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "config.getString(\"main_feeds_viola_url\", \"\")");
      b = (String)localObject2;
      jdField_a_of_type_Boolean = true;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[init] mainFeedsChannelId = ");
      ((StringBuilder)localObject2).append(jdField_a_of_type_Int);
      ((StringBuilder)localObject2).append(", mainFeedsChannelName = ");
      ((StringBuilder)localObject2).append(jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject2).append(", mainFeedsViolaUrl = ");
      ((StringBuilder)localObject2).append(b);
      QLog.i("RIJMainChannelUtil", 1, ((StringBuilder)localObject2).toString());
      localObject2 = Unit.INSTANCE;
      return;
    }
  }
  
  @NotNull
  public final String b()
  {
    a();
    return b;
  }
  
  public final void b()
  {
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_Int = -1;
    jdField_a_of_type_JavaLangString = "";
    b = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.channelcover.RIJMainChannelUtil
 * JD-Core Version:    0.7.0.1
 */