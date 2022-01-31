import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.3;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;

public class rji
  implements osi
{
  public rji(VideoPlayManager.3 param3, osf paramosf) {}
  
  public void a(osl paramosl)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "UUIDToUrlCallback Callback vid=" + paramosl.jdField_b_of_type_JavaLangString + ", url=" + paramosl.jdField_a_of_type_JavaLangString + ", isH265=, isHWCodec=" + paramosl.jdField_b_of_type_Boolean + "，urlType=" + paramosl.jdField_a_of_type_Int + ", hwBackupUrl=" + paramosl.f);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Rjn != null) && (rjg.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.this$0) == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Rjn) && (paramosl.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Rjk.c))) {
      if (TextUtils.isEmpty(paramosl.jdField_a_of_type_JavaLangString)) {
        if (rjg.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.this$0) != null) {
          rjg.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.this$0).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Rjn, 123, 107, 0, "UUIDToUrlCallback vid2url ERROR ", null);
        }
      }
    }
    label401:
    label573:
    while (!QLog.isColorLevel())
    {
      return;
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Rjn;
      int i;
      boolean bool;
      if (paramosl.jdField_a_of_type_Boolean)
      {
        i = 1;
        ((rjn)localObject).b = i;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Rjk.g = paramosl.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Rjk.a.jdField_i_of_type_Long = this.jdField_a_of_type_Osf.a.longValue();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Rjk.a.jdField_d_of_type_Int = paramosl.jdField_d_of_type_Int;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Rjk.a.jdField_d_of_type_Boolean = paramosl.jdField_a_of_type_Boolean;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Rjk.a.jdField_e_of_type_JavaLangString = paramosl.c;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Rjk.a.jdField_e_of_type_Boolean = paramosl.jdField_b_of_type_Boolean;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Rjk.a.f = false;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Rjk.a.g = "";
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Rjk.a.k = paramosl.jdField_d_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Rjk.a.l = paramosl.jdField_e_of_type_JavaLangString;
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Rjk.a;
        if (TextUtils.isEmpty(paramosl.f)) {
          break label573;
        }
        bool = true;
        ((qlq)localObject).h = bool;
      }
      for (;;)
      {
        try
        {
          String str = new URL(paramosl.jdField_a_of_type_JavaLangString).getHost();
          localObject = bazo.a().a(str, 1006);
          qlq localqlq = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Rjk.a;
          if (localObject != null) {
            continue;
          }
          i = 0;
          localqlq.q = i;
          localqlq = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Rjk.a;
          if (localObject != null) {
            continue;
          }
          localObject = "";
          localqlq.j = ((String)localObject);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Rjk.a.jdField_i_of_type_JavaLangString = str;
        }
        catch (Exception localException)
        {
          continue;
        }
        if (paramosl.jdField_a_of_type_Int != 1) {
          continue;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Rjn.a(paramosl.jdField_b_of_type_JavaLangString, paramosl.jdField_a_of_type_JavaLangString, 1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Rjk.d, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Rjk.e, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Rjk.b, paramosl.jdField_b_of_type_Boolean, true, false);
        return;
        i = 0;
        break;
        bool = false;
        break label401;
        i = ((ArrayList)localObject).size();
        continue;
        localObject = ((ArrayList)localObject).toString();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Rjn.a(paramosl.jdField_b_of_type_JavaLangString, paramosl.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Rjk.d, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Rjk.e, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Rjk.b, paramosl.jdField_b_of_type_Boolean, true, false, paramosl.f);
      return;
    }
    QLog.w("Q.readinjoy.video", 2, "vid2url换回来后，当前视频已经不再播放，vid:" + paramosl.jdField_b_of_type_JavaLangString + " url:" + paramosl.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rji
 * JD-Core Version:    0.7.0.1
 */