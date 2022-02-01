import java.util.List;

public abstract interface owg
  extends owf
{
  public abstract void onCommentCreate(boolean paramBoolean, ouo paramouo, List<ouo> paramList, int paramInt);
  
  public abstract void onCommentCreate(boolean paramBoolean1, ouo paramouo, boolean paramBoolean2, List<ouo> paramList, int paramInt);
  
  public abstract void onCommentDelete(int paramInt1, boolean paramBoolean, ouo paramouo, int paramInt2);
  
  public abstract void onCommentLikeOrDislike(boolean paramBoolean, String paramString, int paramInt1, int paramInt2);
  
  public abstract void onCommentLoadMore(int paramInt1, boolean paramBoolean1, List<ouo> paramList, boolean paramBoolean2, int paramInt2);
  
  public abstract void onCommentReply(boolean paramBoolean, ouo paramouo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     owg
 * JD-Core Version:    0.7.0.1
 */