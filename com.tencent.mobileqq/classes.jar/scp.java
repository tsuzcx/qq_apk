import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.qphone.base.util.BaseApplication;

public class scp
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
        szl.a(paramContext);
        localAdvertisementInfo = oef.a((AdData)paramBaseData);
      } while (szl.a(paramContext, (AdData)paramBaseData, localAdvertisementInfo));
      localAdvertisementInfo.setClickPos(paramInt);
      if ((oee.h(localAdvertisementInfo)) && ((paramInt == 4) || (paramInt == 3)) && ((paramContext instanceof Activity)))
      {
        oee.a((Activity)paramContext, 1);
        szl.a((Activity)paramContext, localAdvertisementInfo);
        noy.a(new obk().a(BaseApplication.getContext()).a(noy.a).b(noy.ai).a(localAdvertisementInfo).d(noy.a((AdData)paramBaseData)).a());
        return;
      }
      localObject = new obg();
      if (paramInt == 8) {
        ((obg)localObject).c = true;
      }
      localObject = szl.a((Activity)paramContext, localAdvertisementInfo, null, 5, paramBoolean2, false, paramBoolean1, (obg)localObject);
    } while (localObject == null);
    ((GdtHandler.Params)localObject).f = oed.b((AdData)paramBaseData);
    szl.a((GdtHandler.Params)localObject, paramContext, localAdvertisementInfo);
    jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = (GdtHandler.Params)localObject;
    if (jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params != null) {}
    for (long l = SystemClock.elapsedRealtime();; l = -2147483648L)
    {
      jdField_a_of_type_Long = l;
      oef.a((AdData)paramBaseData, paramInt);
      return;
    }
  }
  
  public void a()
  {
    szl.a(2, jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params, jdField_a_of_type_Long);
    jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = null;
    jdField_a_of_type_Long = -2147483648L;
  }
  
  public void b()
  {
    jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = null;
    jdField_a_of_type_Long = -2147483648L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     scp
 * JD-Core Version:    0.7.0.1
 */