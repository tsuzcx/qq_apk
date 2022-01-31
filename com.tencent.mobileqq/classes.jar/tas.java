import com.tencent.biz.qqstory.network.pb.qqstory_service.RspAuthKey;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;

public class tas
  extends slz<tcd>
{
  public String a()
  {
    return skt.a("StorySvc.video_apply_authkey");
  }
  
  public tcd a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspAuthKey localRspAuthKey = new qqstory_service.RspAuthKey();
    try
    {
      localRspAuthKey.mergeFrom(paramArrayOfByte);
      return new tcd(localRspAuthKey);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      urk.d("Q.qqstory:RefreshVideoFileKeyRequest", "" + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tas
 * JD-Core Version:    0.7.0.1
 */