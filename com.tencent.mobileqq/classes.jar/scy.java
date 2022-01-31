import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

class scy
  implements Runnable
{
  scy(scx paramscx, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Scx.a.e != null)
    {
      Iterator localIterator = this.jdField_a_of_type_Scx.a.e.iterator();
      while (localIterator.hasNext())
      {
        oidb_0x899.memberlist localmemberlist = (oidb_0x899.memberlist)localIterator.next();
        if (!this.jdField_a_of_type_JavaUtilArrayList.contains(localmemberlist.uint64_member_uin.get() + "")) {
          this.jdField_a_of_type_JavaUtilArrayList.add(localmemberlist.uint64_member_uin.get() + "");
        }
      }
    }
    ChatSettingForTroop.a(this.jdField_a_of_type_Scx.a, this.jdField_a_of_type_Scx.a.a.troopUin, this.jdField_a_of_type_Scx.a.a.isOwnerOrAdim(), this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Scx.a.a("Grp", "Clk_invite_new", "0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     scy
 * JD-Core Version:    0.7.0.1
 */