import com.tencent.kingkong.Common;
import com.tencent.kingkong.Common.Log;
import com.tencent.kingkong.PatchManager;
import com.tencent.kingkong.ReportThread;
import com.tencent.kingkong.UpdateManager;
import com.tencent.kingkong.Utils.InterProcessLock;

public final class rhi
  extends Thread
{
  public void run()
  {
    try
    {
      if ((!Common.jdField_a_of_type_Boolean) && (Common.b()) && (Common.c()) && (Common.d()))
      {
        if (!Common.jdField_a_of_type_ComTencentKingkongUtils$InterProcessLock.a()) {
          return;
        }
        Common.a(true);
        if (PatchManager.a(Common.jdField_a_of_type_AndroidContentContext))
        {
          if (Common.jdField_a_of_type_ComTencentKingkongReportThread == null)
          {
            Common.jdField_a_of_type_ComTencentKingkongReportThread = new ReportThread();
            Common.jdField_a_of_type_ComTencentKingkongReportThread.start();
          }
          UpdateManager.a(Common.jdField_a_of_type_AndroidContentContext);
          if (UpdateManager.b()) {
            UpdateManager.b();
          }
          if (UpdateManager.a()) {
            UpdateManager.a();
          }
          PatchManager.a();
        }
        Common.jdField_a_of_type_Boolean = true;
        Common.a(false);
        Common.jdField_a_of_type_ComTencentKingkongUtils$InterProcessLock.a();
        return;
      }
    }
    catch (Exception localException)
    {
      Common.jdField_a_of_type_Boolean = false;
      Common.Log.a("KingKongCommon", " SetSafeStatus Exception : " + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rhi
 * JD-Core Version:    0.7.0.1
 */