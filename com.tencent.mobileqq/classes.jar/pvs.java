import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ColumnTwoVideoProteusItem.ColumnSubscriptionCallback.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0xd4b.oidb_0xd4b.RspBody;
import tencent.im.oidb.cmd0xd4b.oidb_0xd4b.SubscribeVideoColumnRsp;

public class pvs
  extends nkq
{
  private int jdField_a_of_type_Int;
  private qwn jdField_a_of_type_Qwn;
  
  pvs(qwn paramqwn, int paramInt)
  {
    this.jdField_a_of_type_Qwn = paramqwn;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0)
    {
      paramInt = this.jdField_a_of_type_Qwn.d;
      if (this.jdField_a_of_type_Int == 1) {
        paramInt += 1;
      }
      for (;;)
      {
        pfd.a().a(this.jdField_a_of_type_Qwn.jdField_a_of_type_Int, this.jdField_a_of_type_Int, paramInt);
        oidb_0xd4b.RspBody localRspBody = new oidb_0xd4b.RspBody();
        try
        {
          localRspBody.mergeFrom(paramArrayOfByte);
          paramInt = ((oidb_0xd4b.SubscribeVideoColumnRsp)((oidb_0xd4b.RspBody)localRspBody.get()).msg_subscribe_video_column_rsp.get()).uint32_guide_type.get();
          QLog.i("ColumnTwoVideoProteusItem", 1, "ColumnSubscriptionCallback " + paramInt);
          ThreadManager.getUIHandler().post(new ColumnTwoVideoProteusItem.ColumnSubscriptionCallback.1(this, paramBundle, paramInt));
          return;
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          QLog.e("ColumnTwoVideoProteusItem", 1, paramArrayOfByte.toString());
          return;
        }
        paramInt -= 1;
      }
    }
    QLog.e("ColumnTwoVideoProteusItem", 1, "ColumnTwoVideoProteusItem subscribe column fail. columnId:" + this.jdField_a_of_type_Qwn.jdField_a_of_type_Int + " subscribeAction:" + this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pvs
 * JD-Core Version:    0.7.0.1
 */