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

class nrv
  implements BusinessObserver
{
  nrv(nru paramnru, NewIntent paramNewIntent, QQAppInterface paramQQAppInterface, nrw paramnrw) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
    if (!paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(nru.b(this.jdField_a_of_type_Nru), 2, "OnReceiveGetRecommendPubAccountResponse failed!");
      }
      nru.a(this.jdField_a_of_type_Nru, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Nrw);
      return;
    }
    Object localObject;
    try
    {
      localObject = new ArticleComment.GetRecommendPubAccountResponse();
      ((ArticleComment.GetRecommendPubAccountResponse)localObject).mergeFrom(paramBundle.getByteArray("data"));
      if (QLog.isColorLevel()) {
        QLog.d(nru.b(this.jdField_a_of_type_Nru), 2, "OnReceiveGetRecommendPubAccountResponse->retCode:" + ((ArticleComment.GetRecommendPubAccountResponse)localObject).ret.ret_code.get() + ", title:" + ((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_title.get() + ", listSize:" + ((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_list.get().size());
      }
      if (!((ArticleComment.GetRecommendPubAccountResponse)localObject).ret.has())
      {
        if (QLog.isColorLevel()) {
          QLog.d(nru.b(this.jdField_a_of_type_Nru), 2, "OnReceiveGetRecommendPubAccountResponse failed!(no ret)");
        }
        nru.a(this.jdField_a_of_type_Nru, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Nrw);
        return;
      }
    }
    catch (Exception paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.d(nru.b(this.jdField_a_of_type_Nru), 2, "OnReceiveGetRecommendPubAccountResponse exception:" + paramBundle);
      }
      nru.a(this.jdField_a_of_type_Nru, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Nrw);
      return;
    }
    paramInt = ((ArticleComment.GetRecommendPubAccountResponse)localObject).ret.ret_code.get();
    if (paramInt == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d(nru.b(this.jdField_a_of_type_Nru), 2, "OnReceiveGetRecommendPubAccountResponse forbidden!");
      }
      nru.a(this.jdField_a_of_type_Nru, true);
      this.jdField_a_of_type_Nrw.a(new ArrayList(), null, true);
      return;
    }
    nru.a(this.jdField_a_of_type_Nru, false);
    if (((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_title.has()) {}
    for (paramBundle = ((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_title.get().toStringUtf8();; paramBundle = "")
    {
      if ((paramInt == 0) && (!TextUtils.isEmpty(paramBundle)) && (((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_list.has()) && (((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_list.get().size() > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d(nru.b(this.jdField_a_of_type_Nru), 2, "OnReceiveGetRecommendPubAccountResponse update cache!");
        }
        nru.a(this.jdField_a_of_type_Nru, paramBundle);
        nru.a(this.jdField_a_of_type_Nru).clear();
        paramBundle = ((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_list.get().iterator();
        while (paramBundle.hasNext())
        {
          localObject = (ArticleComment.Record)paramBundle.next();
          nru.a(this.jdField_a_of_type_Nru).add(new nry(this.jdField_a_of_type_Nru, ((ArticleComment.Record)localObject).puin.get().toStringUtf8(), ((ArticleComment.Record)localObject).name.get().toStringUtf8(), true));
        }
        nru.a(this.jdField_a_of_type_Nru, NetConnInfoCenter.getServerTimeMillis());
        nru.a(this.jdField_a_of_type_Nru, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      nru.a(this.jdField_a_of_type_Nru, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Nrw);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(nru.b(this.jdField_a_of_type_Nru), 2, "OnReceiveGetRecommendPubAccountResponse update UI->title:" + nru.a(this.jdField_a_of_type_Nru) + ", cacheTime:" + nru.a(this.jdField_a_of_type_Nru) + ", isFobidden:" + nru.a(this.jdField_a_of_type_Nru) + ", recommendSize:" + nru.a(this.jdField_a_of_type_Nru).size());
      paramBundle = nru.a(this.jdField_a_of_type_Nru).iterator();
      while (paramBundle.hasNext())
      {
        localObject = (nry)paramBundle.next();
        QLog.d(nru.b(this.jdField_a_of_type_Nru), 2, ((nry)localObject).toString());
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nrv
 * JD-Core Version:    0.7.0.1
 */