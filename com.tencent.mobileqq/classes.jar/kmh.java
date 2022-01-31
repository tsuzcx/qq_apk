import android.os.Bundle;
import com.tencent.biz.TroopRedpoint.TroopRedTouchHandler;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class kmh
  implements BusinessObserver
{
  public kmh(TroopRedTouchHandler paramTroopRedTouchHandler, List paramList) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopRedTouchHandler", 2, "getRedPointInfo onReceive :" + paramBoolean);
    }
    int i;
    if ((paramBoolean) && (paramBundle != null))
    {
      paramBundle = paramBundle.getByteArray("data");
      if ((!this.jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(46))) || (!TeamWorkUtils.a(this.jdField_a_of_type_ComTencentBizTroopRedpointTroopRedTouchHandler.b))) {
        break label272;
      }
      i = 1;
      if (i == 0) {
        break label306;
      }
      oidb_0x791.RedDotInfo localRedDotInfo = ((TroopRedTouchManager)this.jdField_a_of_type_ComTencentBizTroopRedpointTroopRedTouchHandler.b.getManager(69)).a(46, false);
      if ((localRedDotInfo == null) || (!localRedDotInfo.uint32_last_time.has())) {
        break label278;
      }
      paramInt = localRedDotInfo.uint32_last_time.get();
    }
    for (;;)
    {
      label132:
      if ((paramBundle != null) && (TroopRedTouchHandler.a(this.jdField_a_of_type_ComTencentBizTroopRedpointTroopRedTouchHandler.b, new ArrayList(this.jdField_a_of_type_JavaUtilList), paramBundle)))
      {
        this.jdField_a_of_type_ComTencentBizTroopRedpointTroopRedTouchHandler.a = 1;
        if (QLog.isColorLevel()) {
          QLog.i("storyRedDotDebug", 2, "getRedPointAsync");
        }
        this.jdField_a_of_type_ComTencentBizTroopRedpointTroopRedTouchHandler.a(105, true, null);
        if (i != 0)
        {
          paramBundle = ((TroopRedTouchManager)this.jdField_a_of_type_ComTencentBizTroopRedpointTroopRedTouchHandler.b.getManager(69)).a(46, false);
          if ((paramBundle != null) && (QLog.isColorLevel())) {
            QLog.d("TroopRedTouchHandlerQ.qqstory.redPoint", 2, "getRedPointInfoAsync enableTencentDocsAssistant:" + TroopRedTouchManager.a(paramBundle));
          }
          TroopRedTouchHandler.a(this.jdField_a_of_type_ComTencentBizTroopRedpointTroopRedTouchHandler.b, paramBundle, paramInt);
        }
      }
      label272:
      label278:
      do
      {
        return;
        i = 0;
        break;
        paramInt = 0;
        break label132;
        this.jdField_a_of_type_ComTencentBizTroopRedpointTroopRedTouchHandler.a = 2;
      } while (!QLog.isColorLevel());
      QLog.e("TroopRedTouchHandler", 2, "getRedPointInfo success data is null");
      return;
      label306:
      paramInt = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kmh
 * JD-Core Version:    0.7.0.1
 */