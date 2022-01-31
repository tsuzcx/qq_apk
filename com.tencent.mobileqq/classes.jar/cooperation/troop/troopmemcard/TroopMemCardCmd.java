package cooperation.troop.troopmemcard;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.HWTroopMemberCard;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.ServerConfigManager.ConfigType;

public class TroopMemCardCmd
  extends RemoteCommand
{
  QQAppInterface a;
  
  public TroopMemCardCmd(QQAppInterface paramQQAppInterface)
  {
    super("troop.troopmemcard.get_app_interface_data");
    this.a = paramQQAppInterface;
  }
  
  public Bundle a(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    paramOnInvokeFinishLinstener = paramBundle.getString("troopUin");
    String str2 = paramBundle.getString("memUin");
    paramBundle = this.a.a().a(paramOnInvokeFinishLinstener, 1, 100);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("chatmsg:");
    if (!TextUtils.isEmpty(str2)) {}
    for (int i = 10;; i = 20)
    {
      Iterator localIterator = paramBundle.iterator();
      int j = 0;
      MessageRecord localMessageRecord;
      do
      {
        if (localIterator.hasNext())
        {
          localMessageRecord = (MessageRecord)localIterator.next();
          if (j <= i) {}
        }
        else
        {
          paramBundle = "";
        }
        try
        {
          paramOnInvokeFinishLinstener = URLEncoder.encode(localStringBuilder.toString(), "UTF-8");
          paramBundle = paramOnInvokeFinishLinstener;
        }
        catch (Throwable paramOnInvokeFinishLinstener)
        {
          for (;;)
          {
            String str1;
            paramOnInvokeFinishLinstener.printStackTrace();
          }
        }
        paramOnInvokeFinishLinstener = new Bundle();
        paramOnInvokeFinishLinstener.putString("msgtoupload", paramBundle);
        return paramOnInvokeFinishLinstener;
      } while ((localMessageRecord == null) || ((!TextUtils.isEmpty(str2)) && (!TextUtils.equals(localMessageRecord.senderuin, str2))));
      if ((localMessageRecord instanceof MessageForPic)) {
        paramOnInvokeFinishLinstener = ((MessageForPic)localMessageRecord).uuid;
      }
      for (str1 = "2";; str1 = "1")
      {
        paramBundle = paramOnInvokeFinishLinstener;
        try
        {
          paramOnInvokeFinishLinstener = paramOnInvokeFinishLinstener.replace("\"", "\\\"");
          paramBundle = paramOnInvokeFinishLinstener;
          paramOnInvokeFinishLinstener = paramOnInvokeFinishLinstener.replace("'", "\\'");
          paramBundle = paramOnInvokeFinishLinstener;
          paramOnInvokeFinishLinstener = paramOnInvokeFinishLinstener.replace("|", "\\|");
          paramBundle = paramOnInvokeFinishLinstener;
          paramOnInvokeFinishLinstener = paramOnInvokeFinishLinstener.replace(":", "\\:");
          paramBundle = paramOnInvokeFinishLinstener;
          paramOnInvokeFinishLinstener = paramOnInvokeFinishLinstener.replace(";", "\\;");
          paramBundle = paramOnInvokeFinishLinstener;
          paramOnInvokeFinishLinstener = paramOnInvokeFinishLinstener.replace("[", "\\[");
          paramBundle = paramOnInvokeFinishLinstener;
          paramOnInvokeFinishLinstener = paramOnInvokeFinishLinstener.replace("]", "\\]");
          paramBundle = paramOnInvokeFinishLinstener;
          paramOnInvokeFinishLinstener = paramOnInvokeFinishLinstener.replace("=", "\\=");
          paramBundle = paramOnInvokeFinishLinstener;
        }
        catch (Throwable paramOnInvokeFinishLinstener)
        {
          for (;;)
          {
            paramOnInvokeFinishLinstener.printStackTrace();
          }
        }
        localStringBuilder.append("[");
        localStringBuilder.append("uin=" + localMessageRecord.senderuin);
        localStringBuilder.append(";");
        localStringBuilder.append("content=" + paramBundle);
        localStringBuilder.append(";");
        localStringBuilder.append("type=" + str1);
        localStringBuilder.append("]");
        j += 1;
        break;
        if (((!(localMessageRecord instanceof MessageForText)) && (!(localMessageRecord instanceof MessageForLongMsg))) || (localMessageRecord.msgtype != -1000)) {
          break;
        }
        paramOnInvokeFinishLinstener = localMessageRecord.msg;
      }
    }
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    Bundle localBundle;
    if (paramBundle == null)
    {
      localBundle = null;
      label7:
      return localBundle;
    }
    for (;;)
    {
      try
      {
        i = paramBundle.getInt("req_sub_cmd");
        localBundle = new Bundle();
        switch (i)
        {
        case 1001: 
          localBundle = paramBundle;
          if (paramOnInvokeFinishLinstener == null) {
            break label7;
          }
          paramOnInvokeFinishLinstener.onInvokeFinish(paramBundle);
          return paramBundle;
        }
      }
      catch (Exception paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemCardCmd", 2, "invoke Exception hanppend! ExceptionClass = + " + paramBundle.getClass().getName() + "msg = " + paramBundle.getMessage());
        }
        ReportController.b(this.a, "P_CliOper", "BizTechReport", "", "troop_member_card_plugin", "plugin_cmd_exp", 0, 0, paramBundle.getClass().getName(), null, null, null);
        return null;
      }
      paramBundle = a(paramBundle, paramOnInvokeFinishLinstener);
      continue;
      paramBundle = (TroopInfo)paramBundle.getSerializable("troopInfo");
      ((TroopManager)this.a.getManager(51)).b(paramBundle);
      paramBundle = localBundle;
      continue;
      paramBundle = paramBundle.getString("troopUin");
      localBundle.putSerializable("troopInfo", ((TroopManager)this.a.getManager(51)).a(paramBundle));
      paramBundle = localBundle;
      continue;
      Object localObject = paramBundle.getString("troopUin");
      paramBundle = paramBundle.getString("memUin");
      localBundle.putSerializable("card", ((TroopManager)this.a.getManager(51)).a((String)localObject, paramBundle));
      paramBundle = localBundle;
      continue;
      localObject = paramBundle.getString("troopUin");
      String str1 = paramBundle.getString("memUin");
      paramBundle = (HWTroopMemberCard)paramBundle.getSerializable("card");
      ((TroopManager)this.a.getManager(51)).a((String)localObject, str1, paramBundle);
      paramBundle = localBundle;
      continue;
      localObject = paramBundle.getString("troopUin");
      str1 = paramBundle.getString("memUin");
      byte b = paramBundle.getByte("flag");
      localBundle.putBoolean("result", ((TroopManager)this.a.getManager(51)).a((String)localObject, str1, b));
      paramBundle = localBundle;
      continue;
      localObject = paramBundle.getString("troopUin");
      str1 = paramBundle.getString("memUin");
      String str2 = paramBundle.getString("uniqueTitle");
      int i = paramBundle.getInt("uniqueTitleExpire");
      ((TroopManager)this.a.getManager(51)).a((String)localObject, str1, str2, i);
      paramBundle = localBundle;
      continue;
      paramBundle = paramBundle.getString("troopCode");
      localObject = (TroopManager)this.a.getManager(51);
      this.a.a().a(paramBundle, 1);
      ((TroopManager)localObject).b(paramBundle);
      DBUtils.a().a(this.a, paramBundle, this.a.getCurrentAccountUin(), this.a.getApp());
      paramBundle = localBundle;
      continue;
      localObject = paramBundle.getString("key");
      paramBundle = (ServerConfigManager.ConfigType)paramBundle.getSerializable("type");
      localBundle.putString("result", this.a.a(paramBundle, (String)localObject));
      paramBundle = localBundle;
      continue;
      localObject = paramBundle.getString("troopUin");
      paramBundle = paramBundle.getStringArrayList("memberUins");
      ((TroopManager)this.a.getManager(51)).c((String)localObject, (String)paramBundle.get(0));
      paramBundle = localBundle;
      continue;
      localObject = paramBundle.getString("troopUin");
      str1 = paramBundle.getString("memberUin");
      str2 = paramBundle.getString("troopNick");
      i = paramBundle.getInt("level");
      String str3 = paramBundle.getString("friendNick");
      String str4 = paramBundle.getString("troopRemark");
      int j = paramBundle.getInt("age");
      int k = paramBundle.getInt("sex");
      int m = paramBundle.getInt("distance");
      long l1 = paramBundle.getLong("msgseq");
      long l2 = paramBundle.getLong("gagTimeStamp");
      ((TroopManager)this.a.getManager(51)).a((String)localObject, str1, str2, i, str3, str4, j, k, m, l1, l2);
      paramBundle = localBundle;
      continue;
      paramBundle = localBundle;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.troop.troopmemcard.TroopMemCardCmd
 * JD-Core Version:    0.7.0.1
 */