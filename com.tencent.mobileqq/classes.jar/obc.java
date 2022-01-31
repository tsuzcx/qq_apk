import android.content.Context;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import org.json.JSONObject;

public class obc
{
  public static void a(qql paramqql, Context paramContext, qty paramqty)
  {
    boolean bool2 = true;
    label57:
    int i;
    label114:
    int j;
    if (paramqty.e() == 0L)
    {
      paramqql.jdField_a_of_type_Qbt.d = paramqql.jdField_a_of_type_Qbt.e;
      paramqql.jdField_a_of_type_Qbt.e = ((int)paramqty.b());
      qbt localqbt = paramqql.jdField_a_of_type_Qbt;
      if (paramqql.jdField_a_of_type_Qbt.d != 0) {
        break label268;
      }
      bool1 = true;
      localqbt.b = bool1;
      paramqql.jdField_a_of_type_Qbt.c = true;
      localqbt = paramqql.jdField_a_of_type_Qbt;
      AdvertisementInfo localAdvertisementInfo = nmc.a(paramqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a);
      int k = localqbt.d;
      int m = localqbt.e;
      if (!localqbt.b) {
        break label274;
      }
      i = 1;
      if (!localqbt.c) {
        break label279;
      }
      j = 1;
      label125:
      JSONObject localJSONObject = nmc.a(k, m, i, j, localqbt.f, 1, 0, nmc.aE, 0);
      nmc.a(new nyd().a(paramContext).a(nmc.f).b(localqbt.g).a(localAdvertisementInfo).a(paramqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a).a(localJSONObject).a());
      paramqty.o();
      paramqql.jdField_a_of_type_Qbt.d = 0;
      paramqql.jdField_a_of_type_Qbt.e = 0;
      paramContext = paramqql.jdField_a_of_type_Qbt;
      if (paramqql.jdField_a_of_type_Qbt.d != 0) {
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
      paramqql.jdField_a_of_type_Qbt.c = false;
      return;
      paramqql.jdField_a_of_type_Qbt.d = ((int)paramqty.e());
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
 * Qualified Name:     obc
 * JD-Core Version:    0.7.0.1
 */