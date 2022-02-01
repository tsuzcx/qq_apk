import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.gdtad.aditem.GdtHandler.Params;

public class tbe
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
      olj localolj = new olj();
      localolj.d = paramBoolean1;
      localolj.b = paramBoolean2;
      olb.a(paramAdvertisementInfo, (Activity)paramContext, nxw.M, nxw.a, 3, localolj);
      if (opz.a(paramAdvertisementInfo)) {}
      do
      {
        do
        {
          return;
        } while ((paramAdvertisementInfo.isSoftAd()) && (paramAdvertisementInfo.mAdvertisementSoftInfo.c != 0));
        paramAdvertisementInfo.setClickPos(paramInt);
        paramContext = olg.a(paramAdvertisementInfo, (Activity)paramContext, localolj);
      } while (paramContext == null);
      paramContext.f = oqi.b(paramAdvertisementInfo);
      jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = paramContext;
      jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      return;
    }
    oqh.a("FastWebRecommendAdHelper", "onAdJump error: advertisementInfo is null or context is not activity");
  }
  
  public static void a(Context paramContext, BaseData paramBaseData, boolean paramBoolean, int paramInt)
  {
    if ((!(paramContext instanceof Activity)) || (!(paramBaseData instanceof AdData))) {
      return;
    }
    AdvertisementInfo localAdvertisementInfo2 = ((AdData)paramBaseData).a;
    AdvertisementInfo localAdvertisementInfo1 = localAdvertisementInfo2;
    if (localAdvertisementInfo2 == null) {
      localAdvertisementInfo1 = oqk.a((AdData)paramBaseData);
    }
    a(paramContext, localAdvertisementInfo1, false, paramBoolean, paramInt);
  }
  
  public void a()
  {
    ubb.a(2, jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params, jdField_a_of_type_Long);
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
 * Qualified Name:     tbe
 * JD-Core Version:    0.7.0.1
 */