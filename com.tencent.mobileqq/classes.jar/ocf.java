import android.os.Bundle;
import android.text.TextUtils;
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

class ocf
  implements BusinessObserver
{
  ocf(oce paramoce, NewIntent paramNewIntent, QQAppInterface paramQQAppInterface, ocg paramocg) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
    if (!paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(oce.b(this.jdField_a_of_type_Oce), 2, "OnReceiveGetRecommendPubAccountResponse failed!");
      }
      oce.a(this.jdField_a_of_type_Oce, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ocg);
      return;
    }
    Object localObject;
    try
    {
      localObject = new ArticleComment.GetRecommendPubAccountResponse();
      ((ArticleComment.GetRecommendPubAccountResponse)localObject).mergeFrom(paramBundle.getByteArray("data"));
      if (QLog.isColorLevel()) {
        QLog.d(oce.b(this.jdField_a_of_type_Oce), 2, "OnReceiveGetRecommendPubAccountResponse->retCode:" + ((ArticleComment.GetRecommendPubAccountResponse)localObject).ret.ret_code.get() + ", title:" + ((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_title.get() + ", listSize:" + ((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_list.get().size());
      }
      if (!((ArticleComment.GetRecommendPubAccountResponse)localObject).ret.has())
      {
        if (QLog.isColorLevel()) {
          QLog.d(oce.b(this.jdField_a_of_type_Oce), 2, "OnReceiveGetRecommendPubAccountResponse failed!(no ret)");
        }
        oce.a(this.jdField_a_of_type_Oce, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ocg);
        return;
      }
    }
    catch (Exception paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.d(oce.b(this.jdField_a_of_type_Oce), 2, "OnReceiveGetRecommendPubAccountResponse exception:" + paramBundle);
      }
      oce.a(this.jdField_a_of_type_Oce, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ocg);
      return;
    }
    paramInt = ((ArticleComment.GetRecommendPubAccountResponse)localObject).ret.ret_code.get();
    if (paramInt == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d(oce.b(this.jdField_a_of_type_Oce), 2, "OnReceiveGetRecommendPubAccountResponse forbidden!");
      }
      oce.a(this.jdField_a_of_type_Oce, true);
      this.jdField_a_of_type_Ocg.a(new ArrayList(), null, true);
      return;
    }
    oce.a(this.jdField_a_of_type_Oce, false);
    if (((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_title.has()) {}
    for (paramBundle = ((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_title.get().toStringUtf8();; paramBundle = "")
    {
      if ((paramInt == 0) && (!TextUtils.isEmpty(paramBundle)) && (((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_list.has()) && (((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_list.get().size() > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d(oce.b(this.jdField_a_of_type_Oce), 2, "OnReceiveGetRecommendPubAccountResponse update cache!");
        }
        oce.a(this.jdField_a_of_type_Oce, paramBundle);
        oce.a(this.jdField_a_of_type_Oce).clear();
        paramBundle = ((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_list.get().iterator();
        while (paramBundle.hasNext())
        {
          localObject = (ArticleComment.Record)paramBundle.next();
          oce.a(this.jdField_a_of_type_Oce).add(new oci(this.jdField_a_of_type_Oce, ((ArticleComment.Record)localObject).puin.get().toStringUtf8(), ((ArticleComment.Record)localObject).name.get().toStringUtf8(), true));
        }
        oce.a(this.jdField_a_of_type_Oce, NetConnInfoCenter.getServerTimeMillis());
        oce.a(this.jdField_a_of_type_Oce, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      oce.a(this.jdField_a_of_type_Oce, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ocg);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(oce.b(this.jdField_a_of_type_Oce), 2, "OnReceiveGetRecommendPubAccountResponse update UI->title:" + oce.a(this.jdField_a_of_type_Oce) + ", cacheTime:" + oce.a(this.jdField_a_of_type_Oce) + ", isFobidden:" + oce.a(this.jdField_a_of_type_Oce) + ", recommendSize:" + oce.a(this.jdField_a_of_type_Oce).size());
      paramBundle = oce.a(this.jdField_a_of_type_Oce).iterator();
      while (paramBundle.hasNext())
      {
        localObject = (oci)paramBundle.next();
        QLog.d(oce.b(this.jdField_a_of_type_Oce), 2, ((oci)localObject).toString());
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ocf
 * JD-Core Version:    0.7.0.1
 */