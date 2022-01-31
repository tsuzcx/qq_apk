import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

class see
  implements Runnable
{
  see(sed paramsed) {}
  
  public void run()
  {
    ArrayList localArrayList = this.a.jdField_a_of_type_AndroidContentIntent.getExtras().getStringArrayList("deleted_members");
    if (localArrayList != null)
    {
      int i;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.c != null)
      {
        if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.d == 2) && (!this.a.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a.isMember)) {
          this.a.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.c.setText(this.a.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a.wMemberNum + "人");
        }
      }
      else {
        i = localArrayList.size() - 1;
      }
      for (;;)
      {
        if (i < 0) {
          break label277;
        }
        int j = this.a.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.e.size() - 1;
        label136:
        if (j >= 0)
        {
          oidb_0x899.memberlist localmemberlist = (oidb_0x899.memberlist)this.a.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.e.get(j);
          if ((localmemberlist == null) || (!localmemberlist.uint64_member_uin.has())) {}
          while (!String.valueOf(localmemberlist.uint64_member_uin.get()).equals(localArrayList.get(i)))
          {
            j -= 1;
            break label136;
            this.a.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.c.setText(this.a.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a.wMemberNum + "名成员");
            break;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.e.remove(j);
        }
        i -= 1;
      }
    }
    label277:
    this.a.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     see
 * JD-Core Version:    0.7.0.1
 */