import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.gdtad.aditem.GdtHandler.Params;

public class ssa
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
      tkr localtkr = new tkr();
      localtkr.d = paramBoolean1;
      localtkr.b = paramBoolean2;
      tkj.a(paramAdvertisementInfo, (Activity)paramContext, nzq.M, nzq.a, 3, localtkr);
      if (tpp.a(paramAdvertisementInfo)) {}
      do
      {
        do
        {
          return;
        } while ((paramAdvertisementInfo.isSoftAd()) && (paramAdvertisementInfo.mAdvertisementSoftInfo.c != 0));
        paramAdvertisementInfo.setClickPos(paramInt);
        paramContext = tko.a(paramAdvertisementInfo, (Activity)paramContext, localtkr);
      } while (paramContext == null);
      paramContext.f = tpz.b(paramAdvertisementInfo);
      jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = paramContext;
      jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      return;
    }
    tpx.a("FastWebRecommendAdHelper", "onAdJump error: advertisementInfo is null or context is not activity");
  }
  
  public static void a(Context paramContext, BaseData paramBaseData, boolean paramBoolean, int paramInt)
  {
    if ((!(paramContext instanceof Activity)) || (!(paramBaseData instanceof AdData))) {
      return;
    }
    AdvertisementInfo localAdvertisementInfo2 = ((AdData)paramBaseData).a;
    AdvertisementInfo localAdvertisementInfo1 = localAdvertisementInfo2;
    if (localAdvertisementInfo2 == null) {
      localAdvertisementInfo1 = tqb.a((AdData)paramBaseData);
    }
    a(paramContext, localAdvertisementInfo1, false, paramBoolean, paramInt);
  }
  
  public void a()
  {
    ubd.a(2, jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params, jdField_a_of_type_Long);
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
 * Qualified Name:     ssa
 * JD-Core Version:    0.7.0.1
 */