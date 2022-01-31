import android.text.TextUtils;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqCheckActivity;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspCheckActivity;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class tgf
  extends sys
{
  public static String a = sxm.a("StorySvc.check_activity");
  public String b;
  public final String c;
  
  public tgf(String paramString)
  {
    this.c = paramString;
  }
  
  public String a()
  {
    return a;
  }
  
  public syn a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspCheckActivity localRspCheckActivity = new qqstory_service.RspCheckActivity();
    try
    {
      localRspCheckActivity.mergeFrom(paramArrayOfByte);
      return new tgg(localRspCheckActivity);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqCheckActivity localReqCheckActivity = new qqstory_service.ReqCheckActivity();
    if (!TextUtils.isEmpty(this.c)) {
      localReqCheckActivity.adcode.set(Long.valueOf(this.c).longValue());
    }
    ved.a("MsgTabCheckActiveRequest", "client version=%s", "8.3.0");
    localReqCheckActivity.version.set("8.3.0");
    return localReqCheckActivity.toByteArray();
  }
  
  public String toString()
  {
    return "MsgTabCheckActiveRequest{value='" + this.b + '\'' + ", adCode='" + this.c + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tgf
 * JD-Core Version:    0.7.0.1
 */