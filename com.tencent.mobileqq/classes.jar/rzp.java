import android.os.Bundle;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xe33.oidb_0xe33.RspBody;
import tencent.im.oidb.cmd0xe33.oidb_0xe33.TopicInfoSetRsp;

class rzp
  extends ntf
{
  rzp(rzo paramrzo, rzi paramrzi, int paramInt) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramArrayOfByte != null) {
      try
      {
        paramBundle = new oidb_0xe33.RspBody();
        paramBundle.mergeFrom(paramArrayOfByte);
        if (paramBundle.topic_info_set_rsp.has())
        {
          paramArrayOfByte = paramBundle.topic_info_set_rsp;
          this.jdField_a_of_type_Rzi.a(paramInt, paramArrayOfByte.err_msg.get(), paramArrayOfByte.ret_code.get(), paramArrayOfByte.topic_id.get());
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        if (QLog.isColorLevel())
        {
          if (this.jdField_a_of_type_Int != 1) {
            break label123;
          }
          QLog.d("RIJUGC.ManagerColumnModel", 1, "ManageColumnModel createColumn failed." + paramArrayOfByte.toString());
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Rzi.a(paramInt, "", -1, 0);
      return;
      label123:
      if (this.jdField_a_of_type_Int == 2) {
        QLog.d("RIJUGC.ManagerColumnModel", 1, "ManageColumnModel editColumn failed." + paramArrayOfByte.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rzp
 * JD-Core Version:    0.7.0.1
 */