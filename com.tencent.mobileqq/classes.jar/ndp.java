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

class ndp
  implements BusinessObserver
{
  ndp(ndo paramndo, NewIntent paramNewIntent, QQAppInterface paramQQAppInterface, ndq paramndq) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
    if (!paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(ndo.b(this.jdField_a_of_type_Ndo), 2, "OnReceiveGetRecommendPubAccountResponse failed!");
      }
      ndo.a(this.jdField_a_of_type_Ndo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ndq);
      return;
    }
    Object localObject;
    try
    {
      localObject = new ArticleComment.GetRecommendPubAccountResponse();
      ((ArticleComment.GetRecommendPubAccountResponse)localObject).mergeFrom(paramBundle.getByteArray("data"));
      if (QLog.isColorLevel()) {
        QLog.d(ndo.b(this.jdField_a_of_type_Ndo), 2, "OnReceiveGetRecommendPubAccountResponse->retCode:" + ((ArticleComment.GetRecommendPubAccountResponse)localObject).ret.ret_code.get() + ", title:" + ((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_title.get() + ", listSize:" + ((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_list.get().size());
      }
      if (!((ArticleComment.GetRecommendPubAccountResponse)localObject).ret.has())
      {
        if (QLog.isColorLevel()) {
          QLog.d(ndo.b(this.jdField_a_of_type_Ndo), 2, "OnReceiveGetRecommendPubAccountResponse failed!(no ret)");
        }
        ndo.a(this.jdField_a_of_type_Ndo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ndq);
        return;
      }
    }
    catch (Exception paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.d(ndo.b(this.jdField_a_of_type_Ndo), 2, "OnReceiveGetRecommendPubAccountResponse exception:" + paramBundle);
      }
      ndo.a(this.jdField_a_of_type_Ndo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ndq);
      return;
    }
    paramInt = ((ArticleComment.GetRecommendPubAccountResponse)localObject).ret.ret_code.get();
    if (paramInt == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d(ndo.b(this.jdField_a_of_type_Ndo), 2, "OnReceiveGetRecommendPubAccountResponse forbidden!");
      }
      ndo.a(this.jdField_a_of_type_Ndo, true);
      this.jdField_a_of_type_Ndq.a(new ArrayList(), null, true);
      return;
    }
    ndo.a(this.jdField_a_of_type_Ndo, false);
    if (((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_title.has()) {}
    for (paramBundle = ((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_title.get().toStringUtf8();; paramBundle = "")
    {
      if ((paramInt == 0) && (!TextUtils.isEmpty(paramBundle)) && (((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_list.has()) && (((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_list.get().size() > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d(ndo.b(this.jdField_a_of_type_Ndo), 2, "OnReceiveGetRecommendPubAccountResponse update cache!");
        }
        ndo.a(this.jdField_a_of_type_Ndo, paramBundle);
        ndo.a(this.jdField_a_of_type_Ndo).clear();
        paramBundle = ((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_list.get().iterator();
        while (paramBundle.hasNext())
        {
          localObject = (ArticleComment.Record)paramBundle.next();
          ndo.a(this.jdField_a_of_type_Ndo).add(new nds(this.jdField_a_of_type_Ndo, ((ArticleComment.Record)localObject).puin.get().toStringUtf8(), ((ArticleComment.Record)localObject).name.get().toStringUtf8(), true));
        }
        ndo.a(this.jdField_a_of_type_Ndo, NetConnInfoCenter.getServerTimeMillis());
        ndo.a(this.jdField_a_of_type_Ndo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      ndo.a(this.jdField_a_of_type_Ndo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ndq);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(ndo.b(this.jdField_a_of_type_Ndo), 2, "OnReceiveGetRecommendPubAccountResponse update UI->title:" + ndo.a(this.jdField_a_of_type_Ndo) + ", cacheTime:" + ndo.a(this.jdField_a_of_type_Ndo) + ", isFobidden:" + ndo.a(this.jdField_a_of_type_Ndo) + ", recommendSize:" + ndo.a(this.jdField_a_of_type_Ndo).size());
      paramBundle = ndo.a(this.jdField_a_of_type_Ndo).iterator();
      while (paramBundle.hasNext())
      {
        localObject = (nds)paramBundle.next();
        QLog.d(ndo.b(this.jdField_a_of_type_Ndo), 2, ((nds)localObject).toString());
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ndp
 * JD-Core Version:    0.7.0.1
 */