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

class non
  implements BusinessObserver
{
  non(nom paramnom, NewIntent paramNewIntent, QQAppInterface paramQQAppInterface, noo paramnoo) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
    if (!paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(nom.b(this.jdField_a_of_type_Nom), 2, "OnReceiveGetRecommendPubAccountResponse failed!");
      }
      nom.a(this.jdField_a_of_type_Nom, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Noo);
      return;
    }
    Object localObject;
    try
    {
      localObject = new ArticleComment.GetRecommendPubAccountResponse();
      ((ArticleComment.GetRecommendPubAccountResponse)localObject).mergeFrom(paramBundle.getByteArray("data"));
      if (QLog.isColorLevel()) {
        QLog.d(nom.b(this.jdField_a_of_type_Nom), 2, "OnReceiveGetRecommendPubAccountResponse->retCode:" + ((ArticleComment.GetRecommendPubAccountResponse)localObject).ret.ret_code.get() + ", title:" + ((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_title.get() + ", listSize:" + ((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_list.get().size());
      }
      if (!((ArticleComment.GetRecommendPubAccountResponse)localObject).ret.has())
      {
        if (QLog.isColorLevel()) {
          QLog.d(nom.b(this.jdField_a_of_type_Nom), 2, "OnReceiveGetRecommendPubAccountResponse failed!(no ret)");
        }
        nom.a(this.jdField_a_of_type_Nom, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Noo);
        return;
      }
    }
    catch (Exception paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.d(nom.b(this.jdField_a_of_type_Nom), 2, "OnReceiveGetRecommendPubAccountResponse exception:" + paramBundle);
      }
      nom.a(this.jdField_a_of_type_Nom, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Noo);
      return;
    }
    paramInt = ((ArticleComment.GetRecommendPubAccountResponse)localObject).ret.ret_code.get();
    if (paramInt == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d(nom.b(this.jdField_a_of_type_Nom), 2, "OnReceiveGetRecommendPubAccountResponse forbidden!");
      }
      nom.a(this.jdField_a_of_type_Nom, true);
      this.jdField_a_of_type_Noo.a(new ArrayList(), null, true);
      return;
    }
    nom.a(this.jdField_a_of_type_Nom, false);
    if (((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_title.has()) {}
    for (paramBundle = ((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_title.get().toStringUtf8();; paramBundle = "")
    {
      if ((paramInt == 0) && (!TextUtils.isEmpty(paramBundle)) && (((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_list.has()) && (((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_list.get().size() > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d(nom.b(this.jdField_a_of_type_Nom), 2, "OnReceiveGetRecommendPubAccountResponse update cache!");
        }
        nom.a(this.jdField_a_of_type_Nom, paramBundle);
        nom.a(this.jdField_a_of_type_Nom).clear();
        paramBundle = ((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_list.get().iterator();
        while (paramBundle.hasNext())
        {
          localObject = (ArticleComment.Record)paramBundle.next();
          nom.a(this.jdField_a_of_type_Nom).add(new noq(this.jdField_a_of_type_Nom, ((ArticleComment.Record)localObject).puin.get().toStringUtf8(), ((ArticleComment.Record)localObject).name.get().toStringUtf8(), true));
        }
        nom.a(this.jdField_a_of_type_Nom, NetConnInfoCenter.getServerTimeMillis());
        nom.a(this.jdField_a_of_type_Nom, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      nom.a(this.jdField_a_of_type_Nom, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Noo);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(nom.b(this.jdField_a_of_type_Nom), 2, "OnReceiveGetRecommendPubAccountResponse update UI->title:" + nom.a(this.jdField_a_of_type_Nom) + ", cacheTime:" + nom.a(this.jdField_a_of_type_Nom) + ", isFobidden:" + nom.a(this.jdField_a_of_type_Nom) + ", recommendSize:" + nom.a(this.jdField_a_of_type_Nom).size());
      paramBundle = nom.a(this.jdField_a_of_type_Nom).iterator();
      while (paramBundle.hasNext())
      {
        localObject = (noq)paramBundle.next();
        QLog.d(nom.b(this.jdField_a_of_type_Nom), 2, ((noq)localObject).toString());
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     non
 * JD-Core Version:    0.7.0.1
 */