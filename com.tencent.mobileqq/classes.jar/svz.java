import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.gdtad.aditem.GdtHandler.Params;

public class svz
{
  public static long a;
  public static GdtHandler.Params a;
  
  static
  {
    jdField_a_of_type_Long = -2147483648L;
  }
  
  public static void a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, boolean paramBoolean, int paramInt)
  {
    if (!(paramContext instanceof Activity)) {
      return;
    }
    a(paramContext, paramAdvertisementInfo, false, paramBoolean, paramInt);
  }
  
  public static void a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (((paramContext instanceof Activity)) && (paramAdvertisementInfo != null))
    {
      paramAdvertisementInfo.setClickPos(paramInt);
      tqh localtqh = new tqh();
      localtqh.d = paramBoolean1;
      localtqh.b = paramBoolean2;
      tpx.a(paramAdvertisementInfo, (Activity)paramContext, obb.M, obb.a, 3, localtqh);
      if (twh.a(paramAdvertisementInfo)) {}
      do
      {
        do
        {
          return;
        } while ((paramAdvertisementInfo.isSoftAd()) && (paramAdvertisementInfo.mAdvertisementSoftInfo.c != 0));
        paramAdvertisementInfo.setClickPos(paramInt);
        paramContext = tqe.a(paramAdvertisementInfo, (Activity)paramContext, localtqh);
      } while (paramContext == null);
      paramContext.f = twq.b(paramAdvertisementInfo);
      jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = paramContext;
      jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      return;
    }
    twp.a("FastWebRecommendAdHelper", "onAdJump error: advertisementInfo is null or context is not activity");
  }
  
  public static void a(Context paramContext, BaseData paramBaseData, boolean paramBoolean, int paramInt)
  {
    if ((!(paramContext instanceof Activity)) || (!(paramBaseData instanceof AdData))) {
      return;
    }
    AdvertisementInfo localAdvertisementInfo2 = ((AdData)paramBaseData).a;
    AdvertisementInfo localAdvertisementInfo1 = localAdvertisementInfo2;
    if (localAdvertisementInfo2 == null) {
      localAdvertisementInfo1 = tws.a((AdData)paramBaseData);
    }
    a(paramContext, localAdvertisementInfo1, false, paramBoolean, paramInt);
  }
  
  public void a()
  {
    uhs.a(2, jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params, jdField_a_of_type_Long);
    jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = null;
    jdField_a_of_type_Long = -2147483648L;
  }
  
  public void b()
  {
    jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = null;
    jdField_a_of_type_Long = -2147483648L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     svz
 * JD-Core Version:    0.7.0.1
 */