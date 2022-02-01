import NS_QWEB_PROTOCAL.PROTOCAL.StQWebReq;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.oac.OACProfilePb.ProfileDataReq;
import com.tencent.pb.oac.OACProfilePb.ProfileDataRsp;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.app.Packet;

public class ocl
  extends ock
{
  public static void a(Long paramLong, String paramString, ocn<OACProfilePb.ProfileDataRsp> paramocn)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = new OACProfilePb.ProfileDataReq();
    paramString.puin.set(paramLong.longValue());
    paramString.attachinfo.set(str);
    a("officialaccount.clientbusilogic.DataProfile", paramString, OACProfilePb.ProfileDataRsp.class, paramocn);
  }
  
  public static <E extends MessageMicro<?>> void a(String paramString, MessageMicro<?> paramMessageMicro, Class<E> paramClass, ocn<E> paramocn)
  {
    NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getApplication(), ocl.class);
    PROTOCAL.StQWebReq localStQWebReq = new PROTOCAL.StQWebReq();
    localStQWebReq.Seq.set(-1L);
    localStQWebReq.qua.set(bmsw.a());
    localStQWebReq.deviceInfo.set(bmsv.a().c());
    localStQWebReq.busiBuff.set(ByteStringMicro.copyFrom(paramMessageMicro.toByteArray()));
    paramMessageMicro = aalx.a();
    if (!TextUtils.isEmpty(paramMessageMicro)) {
      localStQWebReq.traceid.set(paramMessageMicro);
    }
    localNewIntent.putExtra("traceid", paramMessageMicro);
    localNewIntent.putExtra("cmd", paramString);
    localNewIntent.putExtra("data", localStQWebReq.toByteArray());
    localNewIntent.setObserver(new ocm(paramocn, paramClass));
    BaseApplicationImpl.getApplication().peekAppRuntime().startServlet(localNewIntent);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("data");
    paramIntent = paramIntent.getStringExtra("cmd");
    txk.a(arrayOfByte, paramIntent);
    paramPacket.setSSOCommand(paramIntent);
    if (arrayOfByte != null) {
      paramPacket.putSendData(bhuf.a(arrayOfByte));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ocl
 * JD-Core Version:    0.7.0.1
 */