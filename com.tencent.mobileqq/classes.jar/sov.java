import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class sov
  implements quv
{
  public sov(BridgeModule paramBridgeModule, String paramString1, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString2) {}
  
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
        localObject = qok.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, localUgcVideo.isRemindQQFriend).a();
        if (localUgcVideo.status == UgcVideo.STATUS_PAUSE) {
          nrt.a("0X800AC62", (String)localObject);
        }
        while ((bdin.b(BaseApplicationImpl.getContext())) && (BaseActivity.sTopActivity != null))
        {
          long l = qok.a(localUgcVideo);
          if (l > 0L)
          {
            qok.a(BaseActivity.sTopActivity, l, new sow(this, localUgcVideo, paramList), null);
            return;
            if (localUgcVideo.status == UgcVideo.STATUS_FAILED) {
              nrt.a("0X800AC63", (String)localObject);
            }
          }
          else
          {
            qun.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localUgcVideo, true);
            BridgeModule.access$800(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule, this.jdField_b_of_type_Int, paramList, this.jdField_b_of_type_JavaLangString, 0, "");
            return;
          }
        }
        qun.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localUgcVideo, true);
        BridgeModule.access$800(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule, this.jdField_b_of_type_Int, paramList, this.jdField_b_of_type_JavaLangString, 0, "");
        return;
      }
      BridgeModule.access$800(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule, this.jdField_b_of_type_Int, paramList, this.jdField_b_of_type_JavaLangString, -1, "ugcVideo not exist");
      return;
      localUgcVideo = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sov
 * JD-Core Version:    0.7.0.1
 */