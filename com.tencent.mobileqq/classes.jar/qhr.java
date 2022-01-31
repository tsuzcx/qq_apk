import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.3;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;

public class qhr
  implements ocp
{
  public qhr(VideoPlayManager.3 param3, ocm paramocm) {}
  
  public void a(ocs paramocs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "UUIDToUrlCallback Callback vid=" + paramocs.jdField_b_of_type_JavaLangString + ", url=" + paramocs.jdField_a_of_type_JavaLangString + ", isH265=, isHWCodec=" + paramocs.jdField_b_of_type_Boolean + "，urlType=" + paramocs.jdField_a_of_type_Int + ", hwBackupUrl=" + paramocs.f);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qhw != null) && (qhp.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.this$0) == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qhw) && (paramocs.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qht.c))) {
      if (TextUtils.isEmpty(paramocs.jdField_a_of_type_JavaLangString)) {
        if (qhp.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.this$0) != null) {
          qhp.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.this$0).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qhw, 123, 107, 0, "UUIDToUrlCallback vid2url ERROR ", null);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qht.g = paramocs.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qht.a.jdField_i_of_type_Long = this.jdField_a_of_type_Ocm.a.longValue();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qht.a.jdField_d_of_type_Int = paramocs.jdField_d_of_type_Int;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qht.a.jdField_d_of_type_Boolean = paramocs.jdField_a_of_type_Boolean;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qht.a.jdField_e_of_type_JavaLangString = paramocs.c;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qht.a.jdField_e_of_type_Boolean = paramocs.jdField_b_of_type_Boolean;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qht.a.f = false;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qht.a.g = "";
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qht.a.k = paramocs.jdField_d_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qht.a.l = paramocs.jdField_e_of_type_JavaLangString;
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qht.a;
      boolean bool;
      if (!TextUtils.isEmpty(paramocs.f))
      {
        bool = true;
        ((pqb)localObject).h = bool;
      }
      for (;;)
      {
        try
        {
          String str = new URL(paramocs.jdField_a_of_type_JavaLangString).getHost();
          localObject = axwx.a().a(str, 1006);
          pqb localpqb = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qht.a;
          if (localObject != null) {
            continue;
          }
          i = 0;
          localpqb.q = i;
          localpqb = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qht.a;
          if (localObject != null) {
            continue;
          }
          localObject = "";
          localpqb.j = ((String)localObject);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qht.a.jdField_i_of_type_JavaLangString = str;
        }
        catch (Exception localException)
        {
          int i;
          continue;
        }
        if (paramocs.jdField_a_of_type_Int != 1) {
          continue;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qhw.a(paramocs.jdField_b_of_type_JavaLangString, paramocs.jdField_a_of_type_JavaLangString, 1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qht.d, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qht.e, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qht.b, paramocs.jdField_b_of_type_Boolean, true, false);
        return;
        bool = false;
        break;
        i = ((ArrayList)localObject).size();
        continue;
        localObject = ((ArrayList)localObject).toString();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qhw.a(paramocs.jdField_b_of_type_JavaLangString, paramocs.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qht.d, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qht.e, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qht.b, paramocs.jdField_b_of_type_Boolean, true, false, paramocs.f);
      return;
    }
    QLog.w("Q.readinjoy.video", 2, "vid2url换回来后，当前视频已经不再播放，vid:" + paramocs.jdField_b_of_type_JavaLangString + " url:" + paramocs.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qhr
 * JD-Core Version:    0.7.0.1
 */