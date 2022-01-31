import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMsgTabNodeWatched;

public class stv
  extends slu
{
  public stv(qqstory_service.RspMsgTabNodeWatched paramRspMsgTabNodeWatched)
  {
    super(paramRspMsgTabNodeWatched.result);
  }
  
  public String toString()
  {
    return "MsgTabNodeWatchedResponse{errorCode=" + this.a + ", errorMsg='" + this.b + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     stv
 * JD-Core Version:    0.7.0.1
 */