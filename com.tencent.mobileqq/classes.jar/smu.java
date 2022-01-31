import NS_KING_INTERFACE.stPostFeedDingReq;
import NS_KING_INTERFACE.stPostFeedDingRsp;

public class smu
  extends slp<stPostFeedDingRsp>
{
  public smu(String paramString, int paramInt)
  {
    super("PostFeedDing");
    this.a = new stPostFeedDingReq(paramString, null, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     smu
 * JD-Core Version:    0.7.0.1
 */