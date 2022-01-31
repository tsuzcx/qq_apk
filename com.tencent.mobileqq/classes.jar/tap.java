import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetWeather;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetWeather;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class tap
  extends slz<tca>
{
  private static final String a = skt.a("StorySvc.get_weather");
  public final int c;
  public final int d;
  public final int e;
  
  public tap(int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramInt3;
  }
  
  public String a()
  {
    return a;
  }
  
  public slu a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetWeather localRspGetWeather = new qqstory_service.RspGetWeather();
    try
    {
      localRspGetWeather.mergeFrom(paramArrayOfByte);
      return new tca(localRspGetWeather);
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
    qqstory_service.ReqGetWeather localReqGetWeather = new qqstory_service.ReqGetWeather();
    localReqGetWeather.coordinate.set(this.c);
    localReqGetWeather.longitude.set(this.d);
    localReqGetWeather.latitude.set(this.e);
    return localReqGetWeather.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tap
 * JD-Core Version:    0.7.0.1
 */