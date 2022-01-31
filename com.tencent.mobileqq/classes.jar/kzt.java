import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountSearchRecommendManager;
import com.tencent.biz.pubaccount.PublicAccountSearchRecommendManager.GetRecommendListListener;
import com.tencent.biz.pubaccount.PublicAccountSearchRecommendManager.PublicAccountSearchRecommendItem;
import com.tencent.mobileqq.ac.ArticleComment.GetRecommendPubAccountResponse;
import com.tencent.mobileqq.ac.ArticleComment.Record;
import com.tencent.mobileqq.ac.ArticleComment.RetInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class kzt
  implements BusinessObserver
{
  public kzt(PublicAccountSearchRecommendManager paramPublicAccountSearchRecommendManager, NewIntent paramNewIntent, QQAppInterface paramQQAppInterface, PublicAccountSearchRecommendManager.GetRecommendListListener paramGetRecommendListListener) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
    if (!paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(PublicAccountSearchRecommendManager.b(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountSearchRecommendManager), 2, "OnReceiveGetRecommendPubAccountResponse failed!");
      }
      PublicAccountSearchRecommendManager.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountSearchRecommendManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountSearchRecommendManager$GetRecommendListListener);
      return;
    }
    Object localObject;
    try
    {
      localObject = new ArticleComment.GetRecommendPubAccountResponse();
      ((ArticleComment.GetRecommendPubAccountResponse)localObject).mergeFrom(paramBundle.getByteArray("data"));
      if (QLog.isColorLevel()) {
        QLog.d(PublicAccountSearchRecommendManager.b(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountSearchRecommendManager), 2, "OnReceiveGetRecommendPubAccountResponse->retCode:" + ((ArticleComment.GetRecommendPubAccountResponse)localObject).ret.ret_code.get() + ", title:" + ((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_title.get() + ", listSize:" + ((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_list.get().size());
      }
      if (!((ArticleComment.GetRecommendPubAccountResponse)localObject).ret.has())
      {
        if (QLog.isColorLevel()) {
          QLog.d(PublicAccountSearchRecommendManager.b(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountSearchRecommendManager), 2, "OnReceiveGetRecommendPubAccountResponse failed!(no ret)");
        }
        PublicAccountSearchRecommendManager.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountSearchRecommendManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountSearchRecommendManager$GetRecommendListListener);
        return;
      }
    }
    catch (Exception paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.d(PublicAccountSearchRecommendManager.b(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountSearchRecommendManager), 2, "OnReceiveGetRecommendPubAccountResponse exception:" + paramBundle);
      }
      PublicAccountSearchRecommendManager.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountSearchRecommendManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountSearchRecommendManager$GetRecommendListListener);
      return;
    }
    paramInt = ((ArticleComment.GetRecommendPubAccountResponse)localObject).ret.ret_code.get();
    if (paramInt == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d(PublicAccountSearchRecommendManager.b(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountSearchRecommendManager), 2, "OnReceiveGetRecommendPubAccountResponse forbidden!");
      }
      PublicAccountSearchRecommendManager.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountSearchRecommendManager, true);
      this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountSearchRecommendManager$GetRecommendListListener.a(new ArrayList(), null, true);
      return;
    }
    PublicAccountSearchRecommendManager.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountSearchRecommendManager, false);
    if (((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_title.has()) {}
    for (paramBundle = ((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_title.get().toStringUtf8();; paramBundle = "")
    {
      if ((paramInt == 0) && (!TextUtils.isEmpty(paramBundle)) && (((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_list.has()) && (((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_list.get().size() > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d(PublicAccountSearchRecommendManager.b(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountSearchRecommendManager), 2, "OnReceiveGetRecommendPubAccountResponse update cache!");
        }
        PublicAccountSearchRecommendManager.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountSearchRecommendManager, paramBundle);
        PublicAccountSearchRecommendManager.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountSearchRecommendManager).clear();
        paramBundle = ((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_list.get().iterator();
        while (paramBundle.hasNext())
        {
          localObject = (ArticleComment.Record)paramBundle.next();
          PublicAccountSearchRecommendManager.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountSearchRecommendManager).add(new PublicAccountSearchRecommendManager.PublicAccountSearchRecommendItem(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountSearchRecommendManager, ((ArticleComment.Record)localObject).puin.get().toStringUtf8(), ((ArticleComment.Record)localObject).name.get().toStringUtf8(), true));
        }
        PublicAccountSearchRecommendManager.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountSearchRecommendManager, NetConnInfoCenter.getServerTimeMillis());
        PublicAccountSearchRecommendManager.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountSearchRecommendManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      PublicAccountSearchRecommendManager.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountSearchRecommendManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountSearchRecommendManager$GetRecommendListListener);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(PublicAccountSearchRecommendManager.b(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountSearchRecommendManager), 2, "OnReceiveGetRecommendPubAccountResponse update UI->title:" + PublicAccountSearchRecommendManager.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountSearchRecommendManager) + ", cacheTime:" + PublicAccountSearchRecommendManager.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountSearchRecommendManager) + ", isFobidden:" + PublicAccountSearchRecommendManager.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountSearchRecommendManager) + ", recommendSize:" + PublicAccountSearchRecommendManager.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountSearchRecommendManager).size());
      paramBundle = PublicAccountSearchRecommendManager.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountSearchRecommendManager).iterator();
      while (paramBundle.hasNext())
      {
        localObject = (PublicAccountSearchRecommendManager.PublicAccountSearchRecommendItem)paramBundle.next();
        QLog.d(PublicAccountSearchRecommendManager.b(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountSearchRecommendManager), 2, ((PublicAccountSearchRecommendManager.PublicAccountSearchRecommendItem)localObject).toString());
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kzt
 * JD-Core Version:    0.7.0.1
 */