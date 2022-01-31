import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.3;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;

public class qtw
  implements ooa
{
  public qtw(VideoPlayManager.3 param3, onx paramonx) {}
  
  public void a(ood paramood)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "UUIDToUrlCallback Callback vid=" + paramood.jdField_b_of_type_JavaLangString + ", url=" + paramood.jdField_a_of_type_JavaLangString + ", isH265=, isHWCodec=" + paramood.jdField_b_of_type_Boolean + "，urlType=" + paramood.jdField_a_of_type_Int + ", hwBackupUrl=" + paramood.f);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qub != null) && (qtu.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.this$0) == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qub) && (paramood.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qty.c))) {
      if (TextUtils.isEmpty(paramood.jdField_a_of_type_JavaLangString)) {
        if (qtu.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.this$0) != null) {
          qtu.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.this$0).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qub, 123, 107, 0, "UUIDToUrlCallback vid2url ERROR ", null);
        }
      }
    }
    label401:
    label573:
    while (!QLog.isColorLevel())
    {
      return;
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qub;
      int i;
      boolean bool;
      if (paramood.jdField_a_of_type_Boolean)
      {
        i = 1;
        ((qub)localObject).jdField_a_of_type_Int = i;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qty.g = paramood.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qty.a.jdField_i_of_type_Long = this.jdField_a_of_type_Onx.a.longValue();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qty.a.jdField_d_of_type_Int = paramood.jdField_d_of_type_Int;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qty.a.jdField_d_of_type_Boolean = paramood.jdField_a_of_type_Boolean;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qty.a.jdField_e_of_type_JavaLangString = paramood.c;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qty.a.jdField_e_of_type_Boolean = paramood.jdField_b_of_type_Boolean;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qty.a.f = false;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qty.a.g = "";
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qty.a.k = paramood.jdField_d_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qty.a.l = paramood.jdField_e_of_type_JavaLangString;
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qty.a;
        if (TextUtils.isEmpty(paramood.f)) {
          break label573;
        }
        bool = true;
        ((qbx)localObject).h = bool;
      }
      for (;;)
      {
        try
        {
          String str = new URL(paramood.jdField_a_of_type_JavaLangString).getHost();
          localObject = ayxe.a().a(str, 1006);
          qbx localqbx = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qty.a;
          if (localObject != null) {
            continue;
          }
          i = 0;
          localqbx.q = i;
          localqbx = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qty.a;
          if (localObject != null) {
            continue;
          }
          localObject = "";
          localqbx.j = ((String)localObject);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qty.a.jdField_i_of_type_JavaLangString = str;
        }
        catch (Exception localException)
        {
          continue;
        }
        if (paramood.jdField_a_of_type_Int != 1) {
          continue;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qub.a(paramood.jdField_b_of_type_JavaLangString, paramood.jdField_a_of_type_JavaLangString, 1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qty.d, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qty.e, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qty.b, paramood.jdField_b_of_type_Boolean, true, false);
        return;
        i = 0;
        break;
        bool = false;
        break label401;
        i = ((ArrayList)localObject).size();
        continue;
        localObject = ((ArrayList)localObject).toString();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qub.a(paramood.jdField_b_of_type_JavaLangString, paramood.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qty.d, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qty.e, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$3.jdField_a_of_type_Qty.b, paramood.jdField_b_of_type_Boolean, true, false, paramood.f);
      return;
    }
    QLog.w("Q.readinjoy.video", 2, "vid2url换回来后，当前视频已经不再播放，vid:" + paramood.jdField_b_of_type_JavaLangString + " url:" + paramood.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qtw
 * JD-Core Version:    0.7.0.1
 */