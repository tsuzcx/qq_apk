import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.protofile.cmd0xe40.cmd0xe40.RspBody;
import com.tencent.qphone.base.util.QLog;

public class qfn
  extends nac
{
  public qfn(RIJRedPacketManager paramRIJRedPacketManager, qfo paramqfo) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    QLog.i("RIJRedPacketManager", 1, "yyy_0xe40 error code: " + paramInt);
    if (paramInt == 0) {
      paramBundle = new cmd0xe40.RspBody();
    }
    for (;;)
    {
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        if (!paramBundle.status.has()) {
          break label208;
        }
        paramInt = paramBundle.status.get();
        if (!paramBundle.tips.has()) {
          break label202;
        }
        paramArrayOfByte = paramBundle.tips.get();
        QLog.i("RIJRedPacketManager", 1, "yyy_0xe40 status: " + paramInt + " | tips wording: " + paramArrayOfByte);
        paramBundle = this.jdField_a_of_type_Qfo;
        if (!TextUtils.isEmpty(paramArrayOfByte))
        {
          bool = true;
          paramBundle.a(bool, paramArrayOfByte, paramInt);
          return;
        }
        boolean bool = false;
        continue;
        this.jdField_a_of_type_Qfo.a(false, "", 0);
      }
      catch (Exception paramArrayOfByte)
      {
        this.jdField_a_of_type_Qfo.a(false, "", 0);
        QLog.i("RIJRedPacketManager", 1, "yyy_0xe40 error: " + paramArrayOfByte.toString());
        return;
      }
      return;
      label202:
      paramArrayOfByte = "";
      continue;
      label208:
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qfn
 * JD-Core Version:    0.7.0.1
 */