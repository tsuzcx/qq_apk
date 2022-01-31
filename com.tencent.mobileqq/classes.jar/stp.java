import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMsgTabNodeWatched;

public class stp
  extends slu
{
  public stp(qqstory_service.RspMsgTabNodeWatched paramRspMsgTabNodeWatched)
  {
    super(paramRspMsgTabNodeWatched.result);
  }
  
  public String toString()
  {
    return "MsgTabNodeWatchedResponse{errorCode=" + this.a + ", errorMsg='" + this.b + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     stp
 * JD-Core Version:    0.7.0.1
 */