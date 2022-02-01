import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class ter
  implements rgw
{
  public ter(BridgeModule paramBridgeModule, String paramString1, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString2) {}
  
  public void a(@NotNull List<UgcVideo> paramList)
  {
    Object localObject = paramList.iterator();
    UgcVideo localUgcVideo;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localUgcVideo = (UgcVideo)((Iterator)localObject).next();
    } while (!TextUtils.equals(localUgcVideo.seqId, this.jdField_a_of_type_JavaLangString));
    for (;;)
    {
      if (localUgcVideo != null)
      {
        localObject = rab.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, localUgcVideo.publicType).a();
        if (localUgcVideo.status == UgcVideo.STATUS_PAUSE) {
          ocd.a("0X800AC62", (String)localObject);
        }
        while ((bhnv.b(BaseApplicationImpl.getContext())) && (BaseActivity.sTopActivity != null))
        {
          long l = rab.a(localUgcVideo);
          if (l > 0L)
          {
            rab.a(BaseActivity.sTopActivity, l, new tes(this, localUgcVideo, paramList), null);
            return;
            if (localUgcVideo.status == UgcVideo.STATUS_FAILED) {
              ocd.a("0X800AC63", (String)localObject);
            }
          }
          else
          {
            rgo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localUgcVideo, true);
            BridgeModule.access$1500(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule, this.jdField_b_of_type_Int, paramList, this.jdField_b_of_type_JavaLangString, 0, "");
            return;
          }
        }
        rgo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localUgcVideo, true);
        BridgeModule.access$1500(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule, this.jdField_b_of_type_Int, paramList, this.jdField_b_of_type_JavaLangString, 0, "");
        return;
      }
      BridgeModule.access$1500(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule, this.jdField_b_of_type_Int, paramList, this.jdField_b_of_type_JavaLangString, -1, "ugcVideo not exist");
      return;
      localUgcVideo = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ter
 * JD-Core Version:    0.7.0.1
 */