import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.qqshop.qq_ad.QQAdGetRsp;

class ofq
  implements BusinessObserver
{
  ofq(ofp paramofp, oft paramoft) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EcshopMinusViewChatPie", 2, "isSuccess: " + paramBoolean);
    }
    if (paramInt != 1) {}
    for (;;)
    {
      return;
      qq_ad.QQAdGetRsp localQQAdGetRsp = new qq_ad.QQAdGetRsp();
      try
      {
        localQQAdGetRsp.mergeFrom(paramBundle.getByteArray("data"));
        if (localQQAdGetRsp.qgg_msgs.has())
        {
          paramBundle = localQQAdGetRsp.qgg_msgs.get();
          if ((paramBundle != null) && (!paramBundle.isEmpty()))
          {
            paramBundle = paramBundle.iterator();
            paramInt = 0;
            while (paramBundle.hasNext())
            {
              String str = (String)paramBundle.next();
              MessageForArkApp localMessageForArkApp = (MessageForArkApp)bcry.a(-5008);
              localMessageForArkApp.msgtype = -5008;
              ArkAppMessage localArkAppMessage = new ArkAppMessage();
              localArkAppMessage.fromAppXml(str);
              localMessageForArkApp.msgData = localArkAppMessage.toBytes();
              localMessageForArkApp.parse();
              if ((!TextUtils.isEmpty(localMessageForArkApp.ark_app_message.appName)) && (!TextUtils.isEmpty(localMessageForArkApp.ark_app_message.appView)))
              {
                ofp.a(this.jdField_a_of_type_Ofp).add(localMessageForArkApp);
                localMessageForArkApp.time = System.currentTimeMillis();
                if (paramInt == 0) {
                  localMessageForArkApp.saveExtInfoToExtStr("add_title", "minus_view_title_second");
                }
              }
              ogd.a().a.put(Long.valueOf(localMessageForArkApp.uniseq), localMessageForArkApp);
              paramInt += 1;
            }
          }
        }
        paramBundle = BaseApplicationImpl.getApplication().getRuntime();
        if ((paramBundle instanceof QQAppInterface))
        {
          paramBundle = (oer)((QQAppInterface)paramBundle).a(139);
          if (paramBundle != null)
          {
            if (QLog.isColorLevel()) {
              QLog.i("EcshopMinusViewChatPie", 2, "-----deleteRiskAd----");
            }
            paramBundle.a(localQQAdGetRsp);
          }
        }
        if (this.jdField_a_of_type_Oft != null) {
          this.jdField_a_of_type_Oft.a(ofp.a(this.jdField_a_of_type_Ofp));
        }
        if ((localQQAdGetRsp.qgg_prompt.has()) && (localQQAdGetRsp.qgg_prompt_id.has()))
        {
          ofz.a(localQQAdGetRsp.qgg_prompt.get(), localQQAdGetRsp.qgg_prompt_id.get());
          return;
        }
      }
      catch (Throwable paramBundle)
      {
        paramBundle.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ofq
 * JD-Core Version:    0.7.0.1
 */