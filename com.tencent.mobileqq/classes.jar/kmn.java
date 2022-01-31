import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x791.oidb_0x791.GetRedDotRes;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class kmn
  implements Runnable
{
  public kmn(TroopRedTouchManager paramTroopRedTouchManager, oidb_0x791.GetRedDotRes paramGetRedDotRes) {}
  
  public void run()
  {
    int i = 0;
    Object localObject1 = new File(this.jdField_a_of_type_ComTencentBizTroopRedpointTroopRedTouchManager.a.getApplication().getFilesDir(), "TroopRedTouchManager2_" + this.jdField_a_of_type_ComTencentBizTroopRedpointTroopRedTouchManager.a.getCurrentAccountUin()).getAbsolutePath();
    synchronized (this.jdField_a_of_type_ComTencentBizTroopRedpointTroopRedTouchManager)
    {
      try
      {
        FileUtils.a((String)localObject1, this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.toByteArray(), false);
        localObject1 = new StringBuilder("saveLocalFile==>");
        while (i < this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size())
        {
          ((StringBuilder)localObject1).append(TroopRedTouchManager.a((oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(i)));
          i += 1;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_ComTencentBizTroopRedpointTroopRedTouchManager.b + "Q.qqstory.redPoint", 2, localObject2.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kmn
 * JD-Core Version:    0.7.0.1
 */