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

class olj
  implements BusinessObserver
{
  olj(oli paramoli, NewIntent paramNewIntent, QQAppInterface paramQQAppInterface, olk paramolk) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
    if (!paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(oli.b(this.jdField_a_of_type_Oli), 2, "OnReceiveGetRecommendPubAccountResponse failed!");
      }
      oli.a(this.jdField_a_of_type_Oli, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Olk);
      return;
    }
    Object localObject;
    try
    {
      localObject = new ArticleComment.GetRecommendPubAccountResponse();
      ((ArticleComment.GetRecommendPubAccountResponse)localObject).mergeFrom(paramBundle.getByteArray("data"));
      if (QLog.isColorLevel()) {
        QLog.d(oli.b(this.jdField_a_of_type_Oli), 2, "OnReceiveGetRecommendPubAccountResponse->retCode:" + ((ArticleComment.GetRecommendPubAccountResponse)localObject).ret.ret_code.get() + ", title:" + ((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_title.get() + ", listSize:" + ((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_list.get().size());
      }
      if (!((ArticleComment.GetRecommendPubAccountResponse)localObject).ret.has())
      {
        if (QLog.isColorLevel()) {
          QLog.d(oli.b(this.jdField_a_of_type_Oli), 2, "OnReceiveGetRecommendPubAccountResponse failed!(no ret)");
        }
        oli.a(this.jdField_a_of_type_Oli, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Olk);
        return;
      }
    }
    catch (Exception paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.d(oli.b(this.jdField_a_of_type_Oli), 2, "OnReceiveGetRecommendPubAccountResponse exception:" + paramBundle);
      }
      oli.a(this.jdField_a_of_type_Oli, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Olk);
      return;
    }
    paramInt = ((ArticleComment.GetRecommendPubAccountResponse)localObject).ret.ret_code.get();
    if (paramInt == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d(oli.b(this.jdField_a_of_type_Oli), 2, "OnReceiveGetRecommendPubAccountResponse forbidden!");
      }
      oli.a(this.jdField_a_of_type_Oli, true);
      this.jdField_a_of_type_Olk.a(new ArrayList(), null, true);
      return;
    }
    oli.a(this.jdField_a_of_type_Oli, false);
    if (((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_title.has()) {}
    for (paramBundle = ((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_title.get().toStringUtf8();; paramBundle = "")
    {
      if ((paramInt == 0) && (!TextUtils.isEmpty(paramBundle)) && (((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_list.has()) && (((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_list.get().size() > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d(oli.b(this.jdField_a_of_type_Oli), 2, "OnReceiveGetRecommendPubAccountResponse update cache!");
        }
        oli.a(this.jdField_a_of_type_Oli, paramBundle);
        oli.a(this.jdField_a_of_type_Oli).clear();
        paramBundle = ((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_list.get().iterator();
        while (paramBundle.hasNext())
        {
          localObject = (ArticleComment.Record)paramBundle.next();
          oli.a(this.jdField_a_of_type_Oli).add(new olm(this.jdField_a_of_type_Oli, ((ArticleComment.Record)localObject).puin.get().toStringUtf8(), ((ArticleComment.Record)localObject).name.get().toStringUtf8(), true));
        }
        oli.a(this.jdField_a_of_type_Oli, NetConnInfoCenter.getServerTimeMillis());
        oli.a(this.jdField_a_of_type_Oli, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      oli.a(this.jdField_a_of_type_Oli, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Olk);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(oli.b(this.jdField_a_of_type_Oli), 2, "OnReceiveGetRecommendPubAccountResponse update UI->title:" + oli.a(this.jdField_a_of_type_Oli) + ", cacheTime:" + oli.a(this.jdField_a_of_type_Oli) + ", isFobidden:" + oli.a(this.jdField_a_of_type_Oli) + ", recommendSize:" + oli.a(this.jdField_a_of_type_Oli).size());
      paramBundle = oli.a(this.jdField_a_of_type_Oli).iterator();
      while (paramBundle.hasNext())
      {
        localObject = (olm)paramBundle.next();
        QLog.d(oli.b(this.jdField_a_of_type_Oli), 2, ((olm)localObject).toString());
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     olj
 * JD-Core Version:    0.7.0.1
 */