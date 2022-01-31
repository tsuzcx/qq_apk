import android.content.Context;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import org.json.JSONObject;

public class oeu
{
  public static void a(rfs paramrfs, Context paramContext, rjn paramrjn)
  {
    boolean bool2 = true;
    label57:
    int i;
    label114:
    int j;
    if (paramrjn.e() == 0L)
    {
      paramrfs.jdField_a_of_type_Qlp.d = paramrfs.jdField_a_of_type_Qlp.e;
      paramrfs.jdField_a_of_type_Qlp.e = ((int)paramrjn.b());
      qlp localqlp = paramrfs.jdField_a_of_type_Qlp;
      if (paramrfs.jdField_a_of_type_Qlp.d != 0) {
        break label268;
      }
      bool1 = true;
      localqlp.b = bool1;
      paramrfs.jdField_a_of_type_Qlp.c = true;
      localqlp = paramrfs.jdField_a_of_type_Qlp;
      AdvertisementInfo localAdvertisementInfo = noy.a(paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a);
      int k = localqlp.d;
      int m = localqlp.e;
      if (!localqlp.b) {
        break label274;
      }
      i = 1;
      if (!localqlp.c) {
        break label279;
      }
      j = 1;
      label125:
      JSONObject localJSONObject = noy.a(k, m, i, j, localqlp.f, 1, 0, noy.aE, 0);
      noy.a(new obk().a(paramContext).a(noy.f).b(localqlp.g).a(localAdvertisementInfo).a(paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a).a(localJSONObject).a());
      paramrjn.o();
      paramrfs.jdField_a_of_type_Qlp.d = 0;
      paramrfs.jdField_a_of_type_Qlp.e = 0;
      paramContext = paramrfs.jdField_a_of_type_Qlp;
      if (paramrfs.jdField_a_of_type_Qlp.d != 0) {
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
      paramrfs.jdField_a_of_type_Qlp.c = false;
      return;
      paramrfs.jdField_a_of_type_Qlp.d = ((int)paramrjn.e());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oeu
 * JD-Core Version:    0.7.0.1
 */