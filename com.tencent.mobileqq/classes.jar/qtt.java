import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.3;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;

public class qtt
  implements onx
{
  public qtt(VideoPlayManager.3 param3, onu paramonu) {}
  
  public void a(ooa paramooa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "UUIDToUrlCallback Callback vid=" + paramooa.jdField_b_of_type_JavaLangString + ", url=" + paramooa.jdField_a_of_type_JavaLangString + ", isH265=, isHWCodec=" + paramooa.jdField_b_of_type_Boolean + "，urlType=" + paramooa.jdField_a_of_type_Int + ", hwBackupUrl=" + paramooa.f);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qty != null) && (qtr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.this$0) == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qty) && (paramooa.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qtv.c))) {
      if (TextUtils.isEmpty(paramooa.jdField_a_of_type_JavaLangString)) {
        if (qtr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.this$0) != null) {
          qtr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.this$0).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qty, 123, 107, 0, "UUIDToUrlCallback vid2url ERROR ", null);
        }
      }
    }
    label401:
    label573:
    while (!QLog.isColorLevel())
    {
      return;
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qty;
      int i;
      boolean bool;
      if (paramooa.jdField_a_of_type_Boolean)
      {
        i = 1;
        ((qty)localObject).jdField_a_of_type_Int = i;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qtv.g = paramooa.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qtv.a.jdField_i_of_type_Long = this.jdField_a_of_type_Onu.a.longValue();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qtv.a.jdField_d_of_type_Int = paramooa.jdField_d_of_type_Int;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qtv.a.jdField_d_of_type_Boolean = paramooa.jdField_a_of_type_Boolean;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qtv.a.jdField_e_of_type_JavaLangString = paramooa.c;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qtv.a.jdField_e_of_type_Boolean = paramooa.jdField_b_of_type_Boolean;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qtv.a.f = false;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qtv.a.g = "";
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qtv.a.k = paramooa.jdField_d_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qtv.a.l = paramooa.jdField_e_of_type_JavaLangString;
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qtv.a;
        if (TextUtils.isEmpty(paramooa.f)) {
          break label573;
        }
        bool = true;
        ((qbu)localObject).h = bool;
      }
      for (;;)
      {
        try
        {
          String str = new URL(paramooa.jdField_a_of_type_JavaLangString).getHost();
          localObject = ayxg.a().a(str, 1006);
          qbu localqbu = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qtv.a;
          if (localObject != null) {
            continue;
          }
          i = 0;
          localqbu.q = i;
          localqbu = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qtv.a;
          if (localObject != null) {
            continue;
          }
          localObject = "";
          localqbu.j = ((String)localObject);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qtv.a.jdField_i_of_type_JavaLangString = str;
        }
        catch (Exception localException)
        {
          continue;
        }
        if (paramooa.jdField_a_of_type_Int != 1) {
          continue;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qty.a(paramooa.jdField_b_of_type_JavaLangString, paramooa.jdField_a_of_type_JavaLangString, 1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qtv.d, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qtv.e, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qtv.b, paramooa.jdField_b_of_type_Boolean, true, false);
        return;
        i = 0;
        break;
        bool = false;
        break label401;
        i = ((ArrayList)localObject).size();
        continue;
        localObject = ((ArrayList)localObject).toString();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qty.a(paramooa.jdField_b_of_type_JavaLangString, paramooa.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qtv.d, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qtv.e, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qtv.b, paramooa.jdField_b_of_type_Boolean, true, false, paramooa.f);
      return;
    }
    QLog.w("Q.readinjoy.video", 2, "vid2url换回来后，当前视频已经不再播放，vid:" + paramooa.jdField_b_of_type_JavaLangString + " url:" + paramooa.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qtt
 * JD-Core Version:    0.7.0.1
 */