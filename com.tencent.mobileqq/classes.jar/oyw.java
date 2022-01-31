import android.os.Bundle;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.oidb_0xb7e.RspBody;

class oyw
  extends mxg
{
  oyw(oyv paramoyv, boolean paramBoolean) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0)
    {
      try
      {
        paramBundle = new oidb_0xb7e.RspBody();
        paramBundle.mergeFrom(paramArrayOfByte);
        if (!paramBundle.rpt_top_item.has()) {
          break label129;
        }
        List localList = paramBundle.rpt_top_item.get();
        if ((localList == null) || (localList.size() <= 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d(oyv.a, 2, "requestDiandianTopConfig rpt_top_item is empty");
          }
          osj.a().a(true, null);
          oyv.a(this.a, paramArrayOfByte, 0L);
          return;
        }
        oyv.a(this.a, paramArrayOfByte, System.currentTimeMillis());
        if (!this.b) {
          return;
        }
        oyv.a(this.a, paramBundle);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      QLog.e(oyv.a, 2, "requestDiandianTopConfig parser failed");
      return;
      label129:
      if (QLog.isColorLevel()) {
        QLog.d(oyv.a, 2, "requestDiandianTopConfig rpt_top_item is empty");
      }
      oyv.a(this.a, paramArrayOfByte, 0L);
      osj.a().a(true, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e(oyv.a, 2, "requestDiandianTopConfig failed errorCode = " + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oyw
 * JD-Core Version:    0.7.0.1
 */