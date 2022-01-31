import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetPromoteTaskList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;

public class taz
  extends szf<qqstory_service.ReqGetPromoteTaskList>
{
  public static final String b = skt.a("StorySvc.get_promote_tasklist");
  
  public taz(String paramString)
  {
    super(b, new qqstory_service.ReqGetPromoteTaskList(), null);
    ((qqstory_service.ReqGetPromoteTaskList)this.a).bytes_cookie.set(ByteStringMicro.copyFromUtf8(paramString));
  }
  
  public slu a(byte[] paramArrayOfByte)
  {
    return new tba(paramArrayOfByte);
  }
  
  protected byte[] a()
  {
    urk.a("GetPromoteTaskRequest", "encode: %s", this);
    return super.a();
  }
  
  public String toString()
  {
    return vlw.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     taz
 * JD-Core Version:    0.7.0.1
 */