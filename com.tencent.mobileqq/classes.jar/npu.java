import android.content.Context;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import org.json.JSONObject;

public class npu
{
  public static void a(qeq paramqeq, Context paramContext, qhw paramqhw)
  {
    boolean bool2 = true;
    label57:
    int i;
    label114:
    int j;
    if (paramqhw.d() == 0L)
    {
      paramqeq.jdField_a_of_type_Pqa.d = paramqeq.jdField_a_of_type_Pqa.e;
      paramqeq.jdField_a_of_type_Pqa.e = ((int)paramqhw.b());
      pqa localpqa = paramqeq.jdField_a_of_type_Pqa;
      if (paramqeq.jdField_a_of_type_Pqa.d != 0) {
        break label268;
      }
      bool1 = true;
      localpqa.b = bool1;
      paramqeq.jdField_a_of_type_Pqa.c = true;
      localpqa = paramqeq.jdField_a_of_type_Pqa;
      AdvertisementInfo localAdvertisementInfo = nbe.a(paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a);
      int k = localpqa.d;
      int m = localpqa.e;
      if (!localpqa.b) {
        break label274;
      }
      i = 1;
      if (!localpqa.c) {
        break label279;
      }
      j = 1;
      label125:
      JSONObject localJSONObject = nbe.a(k, m, i, j, localpqa.f, 1, 0, nbe.aD, 0);
      nbe.a(new nmv().a(paramContext).a(nbe.f).b(localpqa.g).a(localAdvertisementInfo).a(paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a).a(localJSONObject).a());
      paramqhw.o();
      paramqeq.jdField_a_of_type_Pqa.d = 0;
      paramqeq.jdField_a_of_type_Pqa.e = 0;
      paramContext = paramqeq.jdField_a_of_type_Pqa;
      if (paramqeq.jdField_a_of_type_Pqa.d != 0) {
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
      paramqeq.jdField_a_of_type_Pqa.c = false;
      return;
      paramqeq.jdField_a_of_type_Pqa.d = ((int)paramqhw.d());
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
 * Qualified Name:     npu
 * JD-Core Version:    0.7.0.1
 */