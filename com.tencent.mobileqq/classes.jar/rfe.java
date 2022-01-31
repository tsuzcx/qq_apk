import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import java.util.List;
import tencent.im.kqq.searchgroup.SearchGroup.GroupInfo;

public class rfe
  extends Handler
{
  public rfe(AddFriendActivity paramAddFriendActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      this.a.a();
    }
    do
    {
      do
      {
        return;
        if (paramMessage.what == 3)
        {
          AddFriendActivity.a(this.a);
          localObject1 = (TroopInfo)paramMessage.obj;
          localObject2 = ((TroopInfo)localObject1).troopuin;
          str1 = ((TroopInfo)localObject1).troopcode;
          String str2 = ((TroopInfo)localObject1).troopname;
          String str3 = ((TroopInfo)localObject1).troopowneruin;
          String str4 = ((TroopInfo)localObject1).Administrator;
          b = (byte)((TroopInfo)localObject1).cGroupOption;
          l = ((TroopInfo)localObject1).dwGroupClassExt;
          s = ((TroopInfo)localObject1).troopface;
          String str5 = ((TroopInfo)localObject1).fingertroopmemo;
          String str6 = ((TroopInfo)localObject1).strLocation;
          if (paramMessage.arg1 == 1) {}
          for (boolean bool = true;; bool = false)
          {
            paramMessage = TroopInfoActivity.a(2, (String)localObject2, str1, str2, str3, str4, b, l, s, str5, str6, bool, this.a.getIntent().getStringExtra("param_return_addr"), ((TroopInfo)localObject1).dwGroupFlagExt, ((TroopInfo)localObject1).dwAuthGroupType, 0);
            ChatSettingForTroop.a(this.a, paramMessage, 2);
            this.a.finish();
            return;
          }
        }
      } while (paramMessage.what != 4);
      AddFriendActivity.a(this.a);
      i = paramMessage.arg1;
      if (paramMessage.arg2 == 1) {}
      paramMessage = (List)paramMessage.obj;
    } while ((i != 1) || (paramMessage == null) || (paramMessage.size() <= 0));
    Object localObject2 = (SearchGroup.GroupInfo)paramMessage.get(0);
    int i = ((SearchGroup.GroupInfo)localObject2).dwGroupCode.get();
    String str1 = ((SearchGroup.GroupInfo)localObject2).sGroupName.get();
    int j = ((SearchGroup.GroupInfo)localObject2).dwGroupOwnerId.get();
    byte b = (byte)TroopUtils.a((SearchGroup.GroupInfo)localObject2);
    long l = ((SearchGroup.GroupInfo)localObject2).dwGroupClass.get();
    short s = (short)((SearchGroup.GroupInfo)localObject2).dwGroupFaceId.get();
    if (((SearchGroup.GroupInfo)localObject2).sGroupFingerMem.has())
    {
      paramMessage = ((SearchGroup.GroupInfo)localObject2).sGroupFingerMem.get();
      if (!((SearchGroup.GroupInfo)localObject2).sGroupLocation.has()) {
        break label438;
      }
    }
    label438:
    for (Object localObject1 = ((SearchGroup.GroupInfo)localObject2).sGroupLocation.get();; localObject1 = "")
    {
      paramMessage = TroopInfoActivity.a(6, String.valueOf(i), "", str1, String.valueOf(j), "", b, l, s, paramMessage, (String)localObject1, ((SearchGroup.GroupInfo)localObject2).bGroupIn.get(), null, ((SearchGroup.GroupInfo)localObject2).dwGroupFlagExt.get(), ((SearchGroup.GroupInfo)localObject2).dwAuthGroupType.get(), 0);
      ChatSettingForTroop.a(this.a, paramMessage, 2);
      this.a.finish();
      return;
      paramMessage = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rfe
 * JD-Core Version:    0.7.0.1
 */