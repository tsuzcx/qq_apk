import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcShopData;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.os.MqqHandler;

public class lch
  extends BroadcastReceiver
{
  public lch(EcShopAssistantManager paramEcShopAssistantManager) {}
  
  public void onReceive(Context arg1, Intent paramIntent)
  {
    if ((paramIntent == null) || (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    for (;;)
    {
      return;
      ??? = paramIntent.getAction();
      Object localObject;
      if ("action_get_PA_head".equals(???))
      {
        ??? = paramIntent.getStringExtra("uin");
        if ((TextUtils.isEmpty(???)) || (this.a.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder == null)) {
          continue;
        }
        paramIntent = this.a.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(1, ???);
        if (paramIntent != null)
        {
          localObject = new Intent("action_decode_finish");
          ((Intent)localObject).putExtra("bitmap", paramIntent);
          ((Intent)localObject).putExtra("uin", ???);
          BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject);
          return;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(???, 1, true);
        return;
      }
      int i;
      boolean bool;
      long l;
      if ("action_shop_set_read".equals(???))
      {
        localObject = paramIntent.getStringExtra("uin");
        i = paramIntent.getIntExtra("unReadNum", 0);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          continue;
        }
        bool = paramIntent.getBooleanExtra("needDelete", false);
        synchronized (EcShopAssistantManager.a(this.a))
        {
          paramIntent = (EcShopData)EcShopAssistantManager.a(this.a).get(localObject);
          if (paramIntent == null) {
            continue;
          }
          ??? = null;
          paramIntent = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          if (paramIntent != null) {
            ??? = paramIntent.a((String)localObject, 1008);
          }
          if (??? != null)
          {
            RecentUtil.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject, 1008);
            paramIntent = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
            if (paramIntent != null) {
              paramIntent.a(???.frienduin, ???.istroop, true);
            }
          }
          if (!bool) {
            continue;
          }
          this.a.b((String)localObject);
          if (((String)localObject).equals(EcShopAssistantManager.g))
          {
            l = EcShopAssistantManager.a().getLong("ad_id", 0L);
            ((EcshopReportHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(88)).a(134246438, null, null, null, null, l, false);
            ??? = EcShopAssistantManager.a().edit();
            ???.remove("ad_id");
            ???.putBoolean("is_ad_added", false);
            ???.commit();
            EcShopAssistantManager.g = "";
            return;
          }
        }
        ReportController.b(null, "dc00899", "Pb_account_lifeservice", (String)localObject, "0X80064D2", "0X80064D2", 0, 0, "" + i, "", "", "");
        return;
      }
      if ("action_folder_set_read".equals(???))
      {
        ??? = paramIntent.getStringExtra("uin");
        if (!TextUtils.isEmpty(???))
        {
          ??? = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(???, 1008);
          if (??? != null) {
            this.a.a(???.time);
          }
        }
        ??? = EcShopAssistantManager.a();
        this.a.e = false;
        if (???.getBoolean("folder_reddot", false)) {
          ???.edit().putBoolean("folder_reddot", false).commit();
        }
        ??? = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
        if (??? == null) {
          continue;
        }
        ???.sendEmptyMessage(1009);
        return;
      }
      if ("action_folder_destroy".equals(???))
      {
        if (paramIntent.getLongExtra("stay_time", 0L) >= this.a.jdField_a_of_type_Long) {
          EcShopAssistantManager.a().edit().putLong("last_stay_folder", System.currentTimeMillis());
        }
        this.a.f = false;
        return;
      }
      if ("action_folder_msg_change".equals(???))
      {
        ??? = paramIntent.getStringExtra("msg");
        i = paramIntent.getIntExtra("type", -1);
        paramIntent = this.a.a();
        if ((TextUtils.isEmpty(???)) || (paramIntent == null)) {
          continue;
        }
        paramIntent = EcShopAssistantManager.a().edit();
        paramIntent.putString("str_ecshop_diy", ???);
        paramIntent.putInt("last_show_time1", (int)(System.currentTimeMillis() / 1000L));
        paramIntent.putInt("FOLDER_MSG_TYPE", i);
        paramIntent.putString("PUSH_JUMP_URL", "");
        paramIntent.commit();
        return;
      }
      if ("action_set_folder_tab_red".equals(???))
      {
        EcShopAssistantManager.a().edit().putBoolean("folder_tab_red", true).commit();
        return;
      }
      if (!"action_follow_status".equals(???)) {
        continue;
      }
      ??? = paramIntent.getStringExtra("puin");
      if (TextUtils.isEmpty(???)) {
        continue;
      }
      try
      {
        l = Long.parseLong(???);
        if (l == -1L) {
          continue;
        }
        bool = ((PublicAccountDataManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55)).a(Long.valueOf(l));
        paramIntent = new Intent("action_follow_status_finish");
        paramIntent.putExtra("isFollow", bool);
        paramIntent.putExtra("uin", String.valueOf(l));
        BaseApplicationImpl.getContext().sendBroadcast(paramIntent);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("EcShopAssistantManager", 2, "follow_status uin:" + ??? + ",isfollow:" + bool);
        return;
      }
      catch (Exception paramIntent)
      {
        for (;;)
        {
          l = -1L;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lch
 * JD-Core Version:    0.7.0.1
 */