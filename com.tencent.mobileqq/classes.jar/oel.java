import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.ecshopassit.EcShopData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.os.MqqHandler;

class oel
  extends BroadcastReceiver
{
  oel(oek paramoek) {}
  
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
        if ((TextUtils.isEmpty(???)) || (this.a.jdField_a_of_type_Aoof == null)) {
          continue;
        }
        paramIntent = this.a.jdField_a_of_type_Aoof.a(1, ???);
        if (paramIntent != null)
        {
          localObject = new Intent("action_decode_finish");
          ((Intent)localObject).putExtra("bitmap", paramIntent);
          ((Intent)localObject).putExtra("uin", ???);
          BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject);
          return;
        }
        this.a.jdField_a_of_type_Aoof.a(???, 1, true);
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
        synchronized (oek.a(this.a))
        {
          paramIntent = (EcShopData)oek.a(this.a).get(localObject);
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
            alpb.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject, 1008);
            paramIntent = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
            if (paramIntent != null) {
              paramIntent.a(???.frienduin, ???.istroop, true);
            }
          }
          if (!bool) {
            continue;
          }
          this.a.b((String)localObject);
          if (((String)localObject).equals(oek.g))
          {
            l = oek.a().getLong("ad_id", 0L);
            ((ofe)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(88)).a(134246438, null, null, null, null, l, false);
            ??? = oek.a().edit();
            ???.remove("ad_id");
            ???.putBoolean("is_ad_added", false);
            ???.commit();
            oek.g = "";
            return;
          }
        }
        bdll.b(null, "dc00899", "Pb_account_lifeservice", (String)localObject, "0X80064D2", "0X80064D2", 0, 0, "" + i, "", "", "");
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
        ??? = oek.a();
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
          oek.a().edit().putLong("last_stay_folder", System.currentTimeMillis());
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
        paramIntent = oek.a().edit();
        paramIntent.putString("str_ecshop_diy", ???);
        paramIntent.putInt("last_show_time1", (int)(System.currentTimeMillis() / 1000L));
        paramIntent.putInt("FOLDER_MSG_TYPE", i);
        paramIntent.putString("PUSH_JUMP_URL", "");
        paramIntent.commit();
        return;
      }
      if ("action_set_folder_tab_red".equals(???))
      {
        oek.a().edit().putBoolean("folder_tab_red", true).commit();
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
        bool = ((aody)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).a(Long.valueOf(l));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oel
 * JD-Core Version:    0.7.0.1
 */