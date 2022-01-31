import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.qphone.base.util.BaseApplication;

public class rab
{
  public static long a;
  public static yjs a;
  
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
        rvb.a(paramContext);
        localAdvertisementInfo = npk.a((AdData)paramBaseData);
      } while (rvb.a(paramContext, (AdData)paramBaseData, localAdvertisementInfo));
      localAdvertisementInfo.setClickPos(paramInt);
      if ((npj.h(localAdvertisementInfo)) && ((paramInt == 4) || (paramInt == 3)) && ((paramContext instanceof Activity)))
      {
        npj.a((Activity)paramContext, 1);
        rvb.a((Activity)paramContext, localAdvertisementInfo);
        nbe.a(new nmv().a(BaseApplication.getContext()).a(nbe.a).b(nbe.ai).a(localAdvertisementInfo).d(nbe.a((AdData)paramBaseData)).a());
        return;
      }
      localObject = new nmr();
      if (paramInt == 8) {
        ((nmr)localObject).c = true;
      }
      localObject = rvb.a((Activity)paramContext, localAdvertisementInfo, null, 5, paramBoolean2, false, paramBoolean1, (nmr)localObject);
    } while (localObject == null);
    ((yjs)localObject).f = npi.b((AdData)paramBaseData);
    rvb.a((yjs)localObject, paramContext, localAdvertisementInfo);
    jdField_a_of_type_Yjs = (yjs)localObject;
    if (jdField_a_of_type_Yjs != null) {}
    for (long l = SystemClock.elapsedRealtime();; l = -2147483648L)
    {
      jdField_a_of_type_Long = l;
      npk.a((AdData)paramBaseData, paramInt);
      return;
    }
  }
  
  public void a()
  {
    rvb.a(2, jdField_a_of_type_Yjs, jdField_a_of_type_Long);
    jdField_a_of_type_Yjs = null;
    jdField_a_of_type_Long = -2147483648L;
  }
  
  public void b()
  {
    jdField_a_of_type_Yjs = null;
    jdField_a_of_type_Long = -2147483648L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rab
 * JD-Core Version:    0.7.0.1
 */