package com.tencent.mobileqq.kandian.biz.feeds.channelbanner;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/feeds/channelbanner/RIJChannelBannerUtil;", "", "()V", "KEY_REQUEST_FREQUENCY_LIMIT", "", "KEY_SHOW_BANNER_CHANNEL_IDS", "TAG", "bannerSwitchMap", "", "", "getRequestFrequencyLimit", "init", "", "isAbleToRequestBanner", "", "lastRequestTimeStamp", "", "isAbleToShowBanner", "channelId", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJChannelBannerUtil
{
  public static final RIJChannelBannerUtil a;
  private static final List<Integer> a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerUtil = new RIJChannelBannerUtil();
    jdField_a_of_type_JavaUtilList = (List)new ArrayList();
  }
  
  private final int a()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(344);
    int i = 1;
    if (localAladdinConfig != null) {
      i = localAladdinConfig.getIntegerFromString("request_frequency_limit", 1);
    }
    return i;
  }
  
  public final void a()
  {
    Object localObject2 = Aladdin.getConfig(344);
    StringBuilder localStringBuilder1 = null;
    Object localObject1;
    if (localObject2 != null) {
      localObject1 = ((AladdinConfig)localObject2).getString("show_banner_channel_ids", "");
    } else {
      localObject1 = null;
    }
    if (localObject2 != null) {
      localObject2 = Integer.valueOf(((AladdinConfig)localObject2).getIntegerFromString("request_frequency_limit", 1));
    } else {
      localObject2 = null;
    }
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("[init] showBannerChannelIds = ");
    localStringBuilder2.append((String)localObject1);
    localStringBuilder2.append(", requestFrequencyLimit = ");
    localStringBuilder2.append(localObject2);
    QLog.i("RIJChannelBannerUtil", 1, localStringBuilder2.toString());
    localObject2 = localStringBuilder1;
    if (localObject1 != null)
    {
      localObject1 = StringsKt.split$default((CharSequence)localObject1, new String[] { "," }, false, 0, 6, null);
      localObject2 = localStringBuilder1;
      if (localObject1 != null) {
        localObject2 = ((List)localObject1).iterator();
      }
    }
    if (localObject2 != null) {
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (String)((Iterator)localObject2).next();
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("[init], channelId = ");
        localStringBuilder1.append((String)localObject1);
        QLog.i("RIJChannelBannerUtil", 1, localStringBuilder1.toString());
        try
        {
          jdField_a_of_type_JavaUtilList.add(Integer.valueOf(Integer.parseInt((String)localObject1)));
        }
        catch (NumberFormatException localNumberFormatException)
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("[init] failed, e = ");
          localStringBuilder2.append(localNumberFormatException);
          localStringBuilder2.append(", it = ");
          localStringBuilder2.append((String)localObject1);
          QLog.e("RIJChannelBannerUtil", 1, localStringBuilder2.toString());
        }
      }
    }
  }
  
  public final boolean a(int paramInt)
  {
    boolean bool = StudyModeManager.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[isAbleToShowBanner], isStudyMode = ");
    localStringBuilder.append(bool);
    QLog.i("RIJChannelBannerUtil", 1, localStringBuilder.toString());
    return (jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(paramInt))) && (!bool);
  }
  
  public final boolean a(long paramLong)
  {
    int i = a() * 60 * 1000;
    long l = System.currentTimeMillis() - paramLong;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[isAbleToRequestBanner], timeInterval = ");
    localStringBuilder.append(l);
    localStringBuilder.append(", frequencyLimit = ");
    localStringBuilder.append(i);
    localStringBuilder.append(", lastRequestTimeStamp = ");
    localStringBuilder.append(paramLong);
    QLog.i("RIJChannelBannerUtil", 1, localStringBuilder.toString());
    return l >= i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.channelbanner.RIJChannelBannerUtil
 * JD-Core Version:    0.7.0.1
 */