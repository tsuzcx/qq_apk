import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.cmd0x791.oidb_0x791.RspBody;
import tencent.im.oidb.cmd0x791.oidb_0x791.SetRedDotRes;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

class mxp
  implements BusinessObserver
{
  mxp(mxn parammxn) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {
      try
      {
        Object localObject = paramBundle.getByteArray("data");
        paramBundle = new oidb_sso.OIDBSSOPkg();
        paramBundle.mergeFrom((byte[])localObject);
        if ((paramBundle != null) && (paramBundle.uint32_result.has()) && (paramBundle.uint32_result.get() == 0) && (paramBundle.bytes_bodybuffer.has()))
        {
          if (paramBundle.bytes_bodybuffer.get() == null) {
            return;
          }
          localObject = new oidb_0x791.RspBody();
          ((oidb_0x791.RspBody)localObject).mergeFrom(paramBundle.bytes_bodybuffer.get().toByteArray());
          localObject = (oidb_0x791.SetRedDotRes)((oidb_0x791.RspBody)localObject).msg_set_reddot_res.get();
          if (localObject != null)
          {
            paramBundle = "";
            localObject = ((oidb_0x791.SetRedDotRes)localObject).rpt_uint64_failed_uin.get().iterator();
            while (((Iterator)localObject).hasNext())
            {
              long l = ((Long)((Iterator)localObject).next()).longValue();
              paramBundle = paramBundle + String.valueOf(l) + ",";
            }
            if ((!TextUtils.isEmpty(paramBundle)) && (QLog.isColorLevel()))
            {
              QLog.d("SplashActivityQ.qqstory.redPoint", 2, "reportRedTouchHasClick failed result is:" + paramBundle);
              return;
            }
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        paramBundle.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mxp
 * JD-Core Version:    0.7.0.1
 */