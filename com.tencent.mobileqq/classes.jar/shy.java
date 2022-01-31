import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class shy
  extends BroadcastReceiver
{
  public shy(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int j = 0;
    paramContext = paramIntent.getAction();
    int i = j;
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
    {
      i = j;
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isHomeworkTroop()) {
        i = 1;
      }
    }
    if ("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramContext))
    {
      paramContext = paramIntent.getStringExtra("data");
      paramIntent = paramIntent.getStringExtra("event");
      if ("onHomeworkTroopIdentityChanged".equals(paramIntent)) {
        if (i != 0) {}
      }
    }
    for (;;)
    {
      return;
      if (!TextUtils.isEmpty(paramContext)) {
        try
        {
          Object localObject = new JSONObject(paramContext);
          paramContext = ((JSONObject)localObject).optString("groupCode");
          if (TextUtils.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramContext))
          {
            paramIntent = ((JSONObject)localObject).optString("content");
            String str1 = ((JSONObject)localObject).optString("source");
            i = ((JSONObject)localObject).optInt("rankId", 333);
            String str2 = ((JSONObject)localObject).optString("nickName");
            String str3 = ((JSONObject)localObject).optString("uin");
            String str4 = ((JSONObject)localObject).optString("course");
            localObject = ((JSONObject)localObject).optString("name");
            if ("troopProfile".equals(str1)) {
              ThreadManager.post(new shz(this, str3, str2, i, str4, (String)localObject), 8, null, false);
            }
            while (QLog.isColorLevel())
            {
              QLog.d("zivonchen", 2, "mHomeworkTroopIdentityChangedReceiver troopUin = " + paramContext + ", content = " + paramIntent + ", source = " + str1 + ", rankId = " + i + ", nickName = " + str2);
              return;
              if ("join".equals(str1))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("wyx", 2, new Object[] { "mHomeworkTroopIdentityChangedReceiver source=join. cGroupOption=", Short.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption), ", joinType=", Integer.valueOf(ChatSettingForTroop.a(this.a)) });
                }
                if (ChatSettingForTroop.a(this.a) == 1) {
                  ChatSettingForTroop.a(this.a);
                } else if (ChatSettingForTroop.a(this.a) == 2) {
                  ChatSettingForTroop.a(this.a, paramIntent);
                }
              }
            }
            if ("bindGames".equals(paramIntent))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.chatopttroop", 2, "receive bind game event, data=" + paramContext);
              }
              try
              {
                paramContext = new JSONObject(paramContext);
                paramIntent = paramContext.getString("groupid");
                if ((!this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin.equals(paramIntent)) || (paramContext.getInt("appid") > 0)) {
                  continue;
                }
                paramContext = (ViewGroup)this.a.jdField_a_of_type_ArrayOfAndroidViewView[29];
                paramContext.setVisibility(8);
                paramContext.removeAllViews();
                ThreadManager.post(new sia(this, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin), 5, null, false);
                return;
              }
              catch (JSONException paramContext)
              {
                QLog.e("Q.chatopttroop", 1, "parse bind game event error", paramContext);
                return;
              }
              if ("start_recomend_page".equals(paramContext))
              {
                this.a.finish();
                return;
              }
            }
          }
        }
        catch (JSONException paramContext) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     shy
 * JD-Core Version:    0.7.0.1
 */