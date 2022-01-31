import NS_KING_INTERFACE.stPostFeedDingReq;
import NS_KING_INTERFACE.stPostFeedDingRsp;

public class sab
  extends ryw<stPostFeedDingRsp>
{
  public sab(String paramString, int paramInt)
  {
    super("PostFeedDing");
    this.a = new stPostFeedDingReq(paramString, null, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sab
 * JD-Core Version:    0.7.0.1
 */