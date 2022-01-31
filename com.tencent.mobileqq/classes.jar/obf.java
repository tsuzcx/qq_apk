import android.content.Context;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import org.json.JSONObject;

public class obf
{
  public static void a(qqo paramqqo, Context paramContext, qub paramqub)
  {
    boolean bool2 = true;
    label57:
    int i;
    label114:
    int j;
    if (paramqub.e() == 0L)
    {
      paramqqo.jdField_a_of_type_Qbw.d = paramqqo.jdField_a_of_type_Qbw.e;
      paramqqo.jdField_a_of_type_Qbw.e = ((int)paramqub.b());
      qbw localqbw = paramqqo.jdField_a_of_type_Qbw;
      if (paramqqo.jdField_a_of_type_Qbw.d != 0) {
        break label268;
      }
      bool1 = true;
      localqbw.b = bool1;
      paramqqo.jdField_a_of_type_Qbw.c = true;
      localqbw = paramqqo.jdField_a_of_type_Qbw;
      AdvertisementInfo localAdvertisementInfo = nmf.a(paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a);
      int k = localqbw.d;
      int m = localqbw.e;
      if (!localqbw.b) {
        break label274;
      }
      i = 1;
      if (!localqbw.c) {
        break label279;
      }
      j = 1;
      label125:
      JSONObject localJSONObject = nmf.a(k, m, i, j, localqbw.f, 1, 0, nmf.aE, 0);
      nmf.a(new nyg().a(paramContext).a(nmf.f).b(localqbw.g).a(localAdvertisementInfo).a(paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a).a(localJSONObject).a());
      paramqub.o();
      paramqqo.jdField_a_of_type_Qbw.d = 0;
      paramqqo.jdField_a_of_type_Qbw.e = 0;
      paramContext = paramqqo.jdField_a_of_type_Qbw;
      if (paramqqo.jdField_a_of_type_Qbw.d != 0) {
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
      paramqqo.jdField_a_of_type_Qbw.c = false;
      return;
      paramqqo.jdField_a_of_type_Qbw.d = ((int)paramqub.e());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     obf
 * JD-Core Version:    0.7.0.1
 */