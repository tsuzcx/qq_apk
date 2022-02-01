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

class ods
  implements BusinessObserver
{
  ods(odr paramodr, NewIntent paramNewIntent, QQAppInterface paramQQAppInterface, odt paramodt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
    if (!paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(odr.b(this.jdField_a_of_type_Odr), 2, "OnReceiveGetRecommendPubAccountResponse failed!");
      }
      odr.a(this.jdField_a_of_type_Odr, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Odt);
      return;
    }
    Object localObject;
    try
    {
      localObject = new ArticleComment.GetRecommendPubAccountResponse();
      ((ArticleComment.GetRecommendPubAccountResponse)localObject).mergeFrom(paramBundle.getByteArray("data"));
      if (QLog.isColorLevel()) {
        QLog.d(odr.b(this.jdField_a_of_type_Odr), 2, "OnReceiveGetRecommendPubAccountResponse->retCode:" + ((ArticleComment.GetRecommendPubAccountResponse)localObject).ret.ret_code.get() + ", title:" + ((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_title.get() + ", listSize:" + ((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_list.get().size());
      }
      if (!((ArticleComment.GetRecommendPubAccountResponse)localObject).ret.has())
      {
        if (QLog.isColorLevel()) {
          QLog.d(odr.b(this.jdField_a_of_type_Odr), 2, "OnReceiveGetRecommendPubAccountResponse failed!(no ret)");
        }
        odr.a(this.jdField_a_of_type_Odr, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Odt);
        return;
      }
    }
    catch (Exception paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.d(odr.b(this.jdField_a_of_type_Odr), 2, "OnReceiveGetRecommendPubAccountResponse exception:" + paramBundle);
      }
      odr.a(this.jdField_a_of_type_Odr, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Odt);
      return;
    }
    paramInt = ((ArticleComment.GetRecommendPubAccountResponse)localObject).ret.ret_code.get();
    if (paramInt == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d(odr.b(this.jdField_a_of_type_Odr), 2, "OnReceiveGetRecommendPubAccountResponse forbidden!");
      }
      odr.a(this.jdField_a_of_type_Odr, true);
      this.jdField_a_of_type_Odt.a(new ArrayList(), null, true);
      return;
    }
    odr.a(this.jdField_a_of_type_Odr, false);
    if (((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_title.has()) {}
    for (paramBundle = ((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_title.get().toStringUtf8();; paramBundle = "")
    {
      if ((paramInt == 0) && (!TextUtils.isEmpty(paramBundle)) && (((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_list.has()) && (((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_list.get().size() > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d(odr.b(this.jdField_a_of_type_Odr), 2, "OnReceiveGetRecommendPubAccountResponse update cache!");
        }
        odr.a(this.jdField_a_of_type_Odr, paramBundle);
        odr.a(this.jdField_a_of_type_Odr).clear();
        paramBundle = ((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_list.get().iterator();
        while (paramBundle.hasNext())
        {
          localObject = (ArticleComment.Record)paramBundle.next();
          odr.a(this.jdField_a_of_type_Odr).add(new odv(this.jdField_a_of_type_Odr, ((ArticleComment.Record)localObject).puin.get().toStringUtf8(), ((ArticleComment.Record)localObject).name.get().toStringUtf8(), true));
        }
        odr.a(this.jdField_a_of_type_Odr, NetConnInfoCenter.getServerTimeMillis());
        odr.a(this.jdField_a_of_type_Odr, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      odr.a(this.jdField_a_of_type_Odr, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Odt);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(odr.b(this.jdField_a_of_type_Odr), 2, "OnReceiveGetRecommendPubAccountResponse update UI->title:" + odr.a(this.jdField_a_of_type_Odr) + ", cacheTime:" + odr.a(this.jdField_a_of_type_Odr) + ", isFobidden:" + odr.a(this.jdField_a_of_type_Odr) + ", recommendSize:" + odr.a(this.jdField_a_of_type_Odr).size());
      paramBundle = odr.a(this.jdField_a_of_type_Odr).iterator();
      while (paramBundle.hasNext())
      {
        localObject = (odv)paramBundle.next();
        QLog.d(odr.b(this.jdField_a_of_type_Odr), 2, ((odv)localObject).toString());
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ods
 * JD-Core Version:    0.7.0.1
 */