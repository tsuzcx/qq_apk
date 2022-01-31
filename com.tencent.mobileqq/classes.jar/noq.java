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

class noq
  implements BusinessObserver
{
  noq(nop paramnop, NewIntent paramNewIntent, QQAppInterface paramQQAppInterface, nor paramnor) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
    if (!paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(nop.b(this.jdField_a_of_type_Nop), 2, "OnReceiveGetRecommendPubAccountResponse failed!");
      }
      nop.a(this.jdField_a_of_type_Nop, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Nor);
      return;
    }
    Object localObject;
    try
    {
      localObject = new ArticleComment.GetRecommendPubAccountResponse();
      ((ArticleComment.GetRecommendPubAccountResponse)localObject).mergeFrom(paramBundle.getByteArray("data"));
      if (QLog.isColorLevel()) {
        QLog.d(nop.b(this.jdField_a_of_type_Nop), 2, "OnReceiveGetRecommendPubAccountResponse->retCode:" + ((ArticleComment.GetRecommendPubAccountResponse)localObject).ret.ret_code.get() + ", title:" + ((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_title.get() + ", listSize:" + ((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_list.get().size());
      }
      if (!((ArticleComment.GetRecommendPubAccountResponse)localObject).ret.has())
      {
        if (QLog.isColorLevel()) {
          QLog.d(nop.b(this.jdField_a_of_type_Nop), 2, "OnReceiveGetRecommendPubAccountResponse failed!(no ret)");
        }
        nop.a(this.jdField_a_of_type_Nop, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Nor);
        return;
      }
    }
    catch (Exception paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.d(nop.b(this.jdField_a_of_type_Nop), 2, "OnReceiveGetRecommendPubAccountResponse exception:" + paramBundle);
      }
      nop.a(this.jdField_a_of_type_Nop, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Nor);
      return;
    }
    paramInt = ((ArticleComment.GetRecommendPubAccountResponse)localObject).ret.ret_code.get();
    if (paramInt == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d(nop.b(this.jdField_a_of_type_Nop), 2, "OnReceiveGetRecommendPubAccountResponse forbidden!");
      }
      nop.a(this.jdField_a_of_type_Nop, true);
      this.jdField_a_of_type_Nor.a(new ArrayList(), null, true);
      return;
    }
    nop.a(this.jdField_a_of_type_Nop, false);
    if (((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_title.has()) {}
    for (paramBundle = ((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_title.get().toStringUtf8();; paramBundle = "")
    {
      if ((paramInt == 0) && (!TextUtils.isEmpty(paramBundle)) && (((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_list.has()) && (((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_list.get().size() > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d(nop.b(this.jdField_a_of_type_Nop), 2, "OnReceiveGetRecommendPubAccountResponse update cache!");
        }
        nop.a(this.jdField_a_of_type_Nop, paramBundle);
        nop.a(this.jdField_a_of_type_Nop).clear();
        paramBundle = ((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_list.get().iterator();
        while (paramBundle.hasNext())
        {
          localObject = (ArticleComment.Record)paramBundle.next();
          nop.a(this.jdField_a_of_type_Nop).add(new not(this.jdField_a_of_type_Nop, ((ArticleComment.Record)localObject).puin.get().toStringUtf8(), ((ArticleComment.Record)localObject).name.get().toStringUtf8(), true));
        }
        nop.a(this.jdField_a_of_type_Nop, NetConnInfoCenter.getServerTimeMillis());
        nop.a(this.jdField_a_of_type_Nop, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      nop.a(this.jdField_a_of_type_Nop, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Nor);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(nop.b(this.jdField_a_of_type_Nop), 2, "OnReceiveGetRecommendPubAccountResponse update UI->title:" + nop.a(this.jdField_a_of_type_Nop) + ", cacheTime:" + nop.a(this.jdField_a_of_type_Nop) + ", isFobidden:" + nop.a(this.jdField_a_of_type_Nop) + ", recommendSize:" + nop.a(this.jdField_a_of_type_Nop).size());
      paramBundle = nop.a(this.jdField_a_of_type_Nop).iterator();
      while (paramBundle.hasNext())
      {
        localObject = (not)paramBundle.next();
        QLog.d(nop.b(this.jdField_a_of_type_Nop), 2, ((not)localObject).toString());
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     noq
 * JD-Core Version:    0.7.0.1
 */