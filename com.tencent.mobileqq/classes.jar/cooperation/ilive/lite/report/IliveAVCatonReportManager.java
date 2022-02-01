package cooperation.ilive.lite.report;

import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.livesdk.accountengine.UserEngine;
import com.tencent.livesdk.livesdkplayer.AVCatonReport4Player;
import com.tencent.livesdk.roomengine.RoomEngine;
import java.util.LinkedList;
import java.util.Queue;

public class IliveAVCatonReportManager
  extends AVCatonReport4Player
{
  private static IliveAVCatonReportManager jdField_a_of_type_CooperationIliveLiteReportIliveAVCatonReportManager;
  private Queue<IliveAVCatonReport> jdField_a_of_type_JavaUtilQueue = new LinkedList();
  
  private IliveAVCatonReport a()
  {
    return (IliveAVCatonReport)this.jdField_a_of_type_JavaUtilQueue.peek();
  }
  
  public static IliveAVCatonReportManager a()
  {
    if (jdField_a_of_type_CooperationIliveLiteReportIliveAVCatonReportManager == null) {
      try
      {
        if (jdField_a_of_type_CooperationIliveLiteReportIliveAVCatonReportManager == null) {
          jdField_a_of_type_CooperationIliveLiteReportIliveAVCatonReportManager = new IliveAVCatonReportManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_CooperationIliveLiteReportIliveAVCatonReportManager;
  }
  
  private String a()
  {
    if (BizEngineMgr.getInstance().getUserEngine() == null) {
      return "";
    }
    Object localObject = BizEngineMgr.getInstance().getUserEngine();
    if (((UserEngine)localObject).getCurrentRoomEngine() == null) {
      return "";
    }
    localObject = ((UserEngine)localObject).getCurrentRoomEngine();
    if (((RoomEngine)localObject).getService(RoomServiceInterface.class) == null) {
      return "";
    }
    localObject = (RoomServiceInterface)((RoomEngine)localObject).getService(RoomServiceInterface.class);
    if (((RoomServiceInterface)localObject).getEnterRoomInfo() == null) {
      return "";
    }
    return String.valueOf(((RoomServiceInterface)localObject).getEnterRoomInfo().roomId);
  }
  
  public void a()
  {
    if (a() != null) {
      a().a();
    }
    this.jdField_a_of_type_JavaUtilQueue.poll();
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (a() != null) {
      a().a(paramLong1, paramLong2);
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    if (a() != null) {
      a().a(paramLong1, paramLong2, paramLong3, paramLong4);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if (a() != null) {
      a().a(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
    }
  }
  
  public void b()
  {
    IliveAVCatonReport localIliveAVCatonReport = new IliveAVCatonReport();
    localIliveAVCatonReport.a(a());
    this.jdField_a_of_type_JavaUtilQueue.offer(localIliveAVCatonReport);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.lite.report.IliveAVCatonReportManager
 * JD-Core Version:    0.7.0.1
 */