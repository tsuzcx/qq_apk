package com.tencent.mobileqq.troop.utils;

import bftx;
import bgsg;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.FileOutputStream;
import java.io.IOException;
import tencent.im.oidb.cmd0x934.cmd0x934.RspBody;

public class TroopRobotManager$7
  implements Runnable
{
  public TroopRobotManager$7(bftx parambftx, String paramString1, String paramString2, cmd0x934.RspBody paramRspBody) {}
  
  public void run()
  {
    Object localObject3 = null;
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        localFileOutputStream = BaseApplication.getContext().openFileOutput("troop_robot_panel_data_" + this.jdField_a_of_type_JavaLangString + "_" + this.b, 0);
        localObject1 = localFileOutputStream;
        localObject3 = localFileOutputStream;
        localFileOutputStream.write(this.jdField_a_of_type_TencentImOidbCmd0x934Cmd0x934$RspBody.toByteArray());
        localObject1 = localFileOutputStream;
        localObject3 = localFileOutputStream;
        localFileOutputStream.flush();
        localObject1 = localFileOutputStream;
        localObject3 = localFileOutputStream;
        localFileOutputStream.close();
        localObject1 = localFileOutputStream;
        localObject3 = localFileOutputStream;
        bgsg.M(BaseApplication.getContext(), this.jdField_a_of_type_JavaLangString + "_" + this.b, this.jdField_a_of_type_TencentImOidbCmd0x934Cmd0x934$RspBody.version.get());
      }
      catch (IOException localIOException4)
      {
        FileOutputStream localFileOutputStream;
        localObject3 = localIOException1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject3 = localIOException1;
        QLog.e("TroopRobotManager", 2, QLog.getStackTraceString(localIOException4));
        if (localIOException1 == null) {
          continue;
        }
        try
        {
          localIOException1.close();
          return;
        }
        catch (IOException localIOException2) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("TroopRobotManager", 2, QLog.getStackTraceString(localIOException2));
        return;
      }
      finally
      {
        if (localObject3 == null) {
          break label210;
        }
      }
      try
      {
        localFileOutputStream.close();
        return;
      }
      catch (IOException localIOException1)
      {
        if (QLog.isColorLevel())
        {
          QLog.e("TroopRobotManager", 2, QLog.getStackTraceString(localIOException1));
          return;
        }
      }
    }
    try
    {
      localObject3.close();
      label210:
      throw localObject2;
    }
    catch (IOException localIOException3)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TroopRobotManager", 2, QLog.getStackTraceString(localIOException3));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopRobotManager.7
 * JD-Core Version:    0.7.0.1
 */