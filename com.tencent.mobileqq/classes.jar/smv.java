import NS_KING_INTERFACE.stGetFeedCommentListReq;
import UserGrowth.stQQGetFeedCommentListReq;
import UserGrowth.stQQGetFeedCommentListRsp;

public class smv
  extends sls<stQQGetFeedCommentListRsp>
{
  public smv()
  {
    super("QQGetFeedCommentList");
    this.a = new stGetFeedCommentListReq("", "76C9BjPDT1HaN4nHs", "", 0, "", 0);
  }
  
  public smv(String paramString1, String paramString2, int paramInt)
  {
    super("QQGetFeedCommentList");
    this.a = new stQQGetFeedCommentListReq(new stGetFeedCommentListReq(paramString1, paramString2, "", 0, "", paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     smv
 * JD-Core Version:    0.7.0.1
 */