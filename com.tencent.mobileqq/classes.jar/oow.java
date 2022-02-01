import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/channelbanner/RIJChannelBannerUtil;", "", "()V", "KEY_REQUEST_FREQUENCY_LIMIT", "", "KEY_SHOW_BANNER_CHANNEL_IDS", "TAG", "bannerSwitchMap", "", "", "getRequestFrequencyLimit", "isAbleToRequestBanner", "", "lastRequestTimeStamp", "", "isAbleToShowBanner", "channelId", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class oow
{
  private static final List<Integer> a;
  public static final oow a;
  
  static
  {
    Object localObject3 = null;
    jdField_a_of_type_Oow = new oow();
    jdField_a_of_type_JavaUtilList = (List)new ArrayList();
    Object localObject2 = Aladdin.getConfig(344);
    Object localObject1;
    if (localObject2 != null) {
      localObject1 = ((AladdinConfig)localObject2).getString("show_banner_channel_ids", "");
    }
    for (;;)
    {
      if (localObject2 != null)
      {
        localObject2 = Integer.valueOf(((AladdinConfig)localObject2).getIntegerFromString("request_frequency_limit", 1));
        QLog.i("RIJChannelBannerUtil", 1, "[init] showBannerChannelIds = " + (String)localObject1 + ", requestFrequencyLimit = " + localObject2);
        localObject2 = localObject3;
        if (localObject1 != null)
        {
          localObject1 = StringsKt.split$default((CharSequence)localObject1, new String[] { "," }, false, 0, 6, null);
          localObject2 = localObject3;
          if (localObject1 != null) {
            localObject2 = ((List)localObject1).iterator();
          }
        }
        label139:
        if ((localObject2 != null) && (((Iterator)localObject2).hasNext()))
        {
          localObject1 = (String)((Iterator)localObject2).next();
          QLog.i("RIJChannelBannerUtil", 1, "[init], channelId = " + (String)localObject1);
        }
      }
      else
      {
        try
        {
          jdField_a_of_type_JavaUtilList.add(Integer.valueOf(Integer.parseInt((String)localObject1)));
          break label139;
          localObject1 = null;
          continue;
          localObject2 = null;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            QLog.e("RIJChannelBannerUtil", 1, "[init] failed, e = " + localNumberFormatException + ", it = " + (String)localObject1);
          }
        }
      }
    }
  }
  
  private final int a()
  {
    int i = 1;
    AladdinConfig localAladdinConfig = Aladdin.getConfig(344);
    if (localAladdinConfig != null) {
      i = localAladdinConfig.getIntegerFromString("request_frequency_limit", 1);
    }
    return i;
  }
  
  public final boolean a(int paramInt)
  {
    boolean bool = bduy.a();
    QLog.i("RIJChannelBannerUtil", 1, "[isAbleToShowBanner], isStudyMode = " + bool);
    return (jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(paramInt))) && (!bool);
  }
  
  public final boolean a(long paramLong)
  {
    int i = a() * 60 * 1000;
    long l = System.currentTimeMillis() - paramLong;
    QLog.i("RIJChannelBannerUtil", 1, "[isAbleToRequestBanner], timeInterval = " + l + ", frequencyLimit = " + i + ", lastRequestTimeStamp = " + paramLong);
    return l >= i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oow
 * JD-Core Version:    0.7.0.1
 */