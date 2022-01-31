import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.qphone.base.util.BaseApplication;

public class rmq
{
  public static long a;
  public static GdtHandler.Params a;
  
  static
  {
    jdField_a_of_type_Long = -2147483648L;
  }
  
  public static void a(Context paramContext, BaseData paramBaseData, boolean paramBoolean, int paramInt)
  {
    a(paramContext, paramBaseData, false, paramBoolean, paramInt);
  }
  
  public static void a(Context paramContext, BaseData paramBaseData, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if ((paramBaseData == null) || (paramContext == null) || (!(paramContext instanceof Activity))) {}
    AdvertisementInfo localAdvertisementInfo;
    Object localObject;
    do
    {
      do
      {
        return;
        shq.a(paramContext);
        localAdvertisementInfo = oas.a((AdData)paramBaseData);
      } while (shq.a(paramContext, (AdData)paramBaseData, localAdvertisementInfo));
      localAdvertisementInfo.setClickPos(paramInt);
      if ((oar.h(localAdvertisementInfo)) && ((paramInt == 4) || (paramInt == 3)) && ((paramContext instanceof Activity)))
      {
        oar.a((Activity)paramContext, 1);
        shq.a((Activity)paramContext, localAdvertisementInfo);
        nmc.a(new nyd().a(BaseApplication.getContext()).a(nmc.a).b(nmc.ai).a(localAdvertisementInfo).d(nmc.a((AdData)paramBaseData)).a());
        return;
      }
      localObject = new nxz();
      if (paramInt == 8) {
        ((nxz)localObject).c = true;
      }
      localObject = shq.a((Activity)paramContext, localAdvertisementInfo, null, 5, paramBoolean2, false, paramBoolean1, (nxz)localObject);
    } while (localObject == null);
    ((GdtHandler.Params)localObject).f = oaq.b((AdData)paramBaseData);
    shq.a((GdtHandler.Params)localObject, paramContext, localAdvertisementInfo);
    jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = (GdtHandler.Params)localObject;
    if (jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params != null) {}
    for (long l = SystemClock.elapsedRealtime();; l = -2147483648L)
    {
      jdField_a_of_type_Long = l;
      oas.a((AdData)paramBaseData, paramInt);
      return;
    }
  }
  
  public void a()
  {
    shq.a(2, jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params, jdField_a_of_type_Long);
    jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = null;
    jdField_a_of_type_Long = -2147483648L;
  }
  
  public void b()
  {
    jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = null;
    jdField_a_of_type_Long = -2147483648L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rmq
 * JD-Core Version:    0.7.0.1
 */