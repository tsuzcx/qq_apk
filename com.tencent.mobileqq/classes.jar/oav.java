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

class oav
  implements BusinessObserver
{
  oav(oau paramoau, NewIntent paramNewIntent, QQAppInterface paramQQAppInterface, oaw paramoaw) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
    if (!paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(oau.b(this.jdField_a_of_type_Oau), 2, "OnReceiveGetRecommendPubAccountResponse failed!");
      }
      oau.a(this.jdField_a_of_type_Oau, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Oaw);
      return;
    }
    Object localObject;
    try
    {
      localObject = new ArticleComment.GetRecommendPubAccountResponse();
      ((ArticleComment.GetRecommendPubAccountResponse)localObject).mergeFrom(paramBundle.getByteArray("data"));
      if (QLog.isColorLevel()) {
        QLog.d(oau.b(this.jdField_a_of_type_Oau), 2, "OnReceiveGetRecommendPubAccountResponse->retCode:" + ((ArticleComment.GetRecommendPubAccountResponse)localObject).ret.ret_code.get() + ", title:" + ((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_title.get() + ", listSize:" + ((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_list.get().size());
      }
      if (!((ArticleComment.GetRecommendPubAccountResponse)localObject).ret.has())
      {
        if (QLog.isColorLevel()) {
          QLog.d(oau.b(this.jdField_a_of_type_Oau), 2, "OnReceiveGetRecommendPubAccountResponse failed!(no ret)");
        }
        oau.a(this.jdField_a_of_type_Oau, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Oaw);
        return;
      }
    }
    catch (Exception paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.d(oau.b(this.jdField_a_of_type_Oau), 2, "OnReceiveGetRecommendPubAccountResponse exception:" + paramBundle);
      }
      oau.a(this.jdField_a_of_type_Oau, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Oaw);
      return;
    }
    paramInt = ((ArticleComment.GetRecommendPubAccountResponse)localObject).ret.ret_code.get();
    if (paramInt == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d(oau.b(this.jdField_a_of_type_Oau), 2, "OnReceiveGetRecommendPubAccountResponse forbidden!");
      }
      oau.a(this.jdField_a_of_type_Oau, true);
      this.jdField_a_of_type_Oaw.a(new ArrayList(), null, true);
      return;
    }
    oau.a(this.jdField_a_of_type_Oau, false);
    if (((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_title.has()) {}
    for (paramBundle = ((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_title.get().toStringUtf8();; paramBundle = "")
    {
      if ((paramInt == 0) && (!TextUtils.isEmpty(paramBundle)) && (((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_list.has()) && (((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_list.get().size() > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d(oau.b(this.jdField_a_of_type_Oau), 2, "OnReceiveGetRecommendPubAccountResponse update cache!");
        }
        oau.a(this.jdField_a_of_type_Oau, paramBundle);
        oau.a(this.jdField_a_of_type_Oau).clear();
        paramBundle = ((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_list.get().iterator();
        while (paramBundle.hasNext())
        {
          localObject = (ArticleComment.Record)paramBundle.next();
          oau.a(this.jdField_a_of_type_Oau).add(new oay(this.jdField_a_of_type_Oau, ((ArticleComment.Record)localObject).puin.get().toStringUtf8(), ((ArticleComment.Record)localObject).name.get().toStringUtf8(), true));
        }
        oau.a(this.jdField_a_of_type_Oau, NetConnInfoCenter.getServerTimeMillis());
        oau.a(this.jdField_a_of_type_Oau, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      oau.a(this.jdField_a_of_type_Oau, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Oaw);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(oau.b(this.jdField_a_of_type_Oau), 2, "OnReceiveGetRecommendPubAccountResponse update UI->title:" + oau.a(this.jdField_a_of_type_Oau) + ", cacheTime:" + oau.a(this.jdField_a_of_type_Oau) + ", isFobidden:" + oau.a(this.jdField_a_of_type_Oau) + ", recommendSize:" + oau.a(this.jdField_a_of_type_Oau).size());
      paramBundle = oau.a(this.jdField_a_of_type_Oau).iterator();
      while (paramBundle.hasNext())
      {
        localObject = (oay)paramBundle.next();
        QLog.d(oau.b(this.jdField_a_of_type_Oau), 2, ((oay)localObject).toString());
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oav
 * JD-Core Version:    0.7.0.1
 */