import com.tencent.biz.qqstory.network.pb.qqstory_service.RspCheckActivity;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class stn
  extends slu
{
  public long a;
  public int b;
  
  public stn(qqstory_service.RspCheckActivity paramRspCheckActivity)
  {
    super(paramRspCheckActivity.result);
    this.b = paramRspCheckActivity.is_activity.get();
    this.a = paramRspCheckActivity.next_check_time.get();
  }
  
  public String toString()
  {
    return "MsgTabCheckActiveResponse{active=" + this.b + ", nextCheckTime=" + this.a + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     stn
 * JD-Core Version:    0.7.0.1
 */