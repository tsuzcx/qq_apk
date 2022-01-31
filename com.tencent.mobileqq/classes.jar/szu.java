import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetLocation;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetLocation;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GpsMsg;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class szu
  extends slz<tbo>
{
  private static final String a = skt.a("StorySvc.get_location");
  public final int c;
  public final int d;
  public final int e;
  
  public szu(int paramInt1, int paramInt2, int paramInt3)
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
    qqstory_service.RspGetLocation localRspGetLocation = new qqstory_service.RspGetLocation();
    try
    {
      localRspGetLocation.mergeFrom(paramArrayOfByte);
      return new tbo(localRspGetLocation);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqGetLocation localReqGetLocation = new qqstory_service.ReqGetLocation();
    localReqGetLocation.coordinate.set(this.c);
    localReqGetLocation.gps.lng.set(this.d);
    localReqGetLocation.gps.lat.set(this.e);
    localReqGetLocation.gps.setHasFlag(true);
    return localReqGetLocation.toByteArray();
  }
  
  public String toString()
  {
    return "GetLocationRequest{mCoordinate=" + this.c + ", mLng=" + this.d + ", mLat=" + this.e + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     szu
 * JD-Core Version:    0.7.0.1
 */