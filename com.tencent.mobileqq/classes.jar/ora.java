import android.content.Context;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import org.json.JSONObject;

public class ora
{
  public static void a(sar paramsar, Context paramContext, sfb paramsfb)
  {
    boolean bool2 = true;
    label57:
    int i;
    label114:
    int j;
    if (paramsfb.e() == 0L)
    {
      paramsar.jdField_a_of_type_Rgb.d = paramsar.jdField_a_of_type_Rgb.e;
      paramsar.jdField_a_of_type_Rgb.e = ((int)paramsfb.b());
      rgb localrgb = paramsar.jdField_a_of_type_Rgb;
      if (paramsar.jdField_a_of_type_Rgb.d != 0) {
        break label268;
      }
      bool1 = true;
      localrgb.b = bool1;
      paramsar.jdField_a_of_type_Rgb.c = true;
      localrgb = paramsar.jdField_a_of_type_Rgb;
      AdvertisementInfo localAdvertisementInfo = nxw.a(paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a);
      int k = localrgb.d;
      int m = localrgb.e;
      if (!localrgb.b) {
        break label274;
      }
      i = 1;
      if (!localrgb.c) {
        break label279;
      }
      j = 1;
      label125:
      JSONObject localJSONObject = nxw.a(k, m, i, j, localrgb.f, 1, 0, nxw.aI, 0);
      nxw.a(new omp().a(paramContext).a(nxw.f).b(localrgb.g).a(localAdvertisementInfo).a(paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a).a(localJSONObject).a());
      paramsfb.m();
      paramsar.jdField_a_of_type_Rgb.d = 0;
      paramsar.jdField_a_of_type_Rgb.e = 0;
      paramContext = paramsar.jdField_a_of_type_Rgb;
      if (paramsar.jdField_a_of_type_Rgb.d != 0) {
        break label285;
      }
    }
    label268:
    label274:
    label279:
    label285:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramContext.b = bool1;
      paramsar.jdField_a_of_type_Rgb.c = false;
      return;
      paramsar.jdField_a_of_type_Rgb.d = ((int)paramsfb.e());
      break;
      bool1 = false;
      break label57;
      i = 0;
      break label114;
      j = 0;
      break label125;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ora
 * JD-Core Version:    0.7.0.1
 */