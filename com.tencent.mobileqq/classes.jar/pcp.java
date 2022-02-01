import java.util.List;

public abstract interface pcp
  extends pco
{
  public abstract void onCommentCreate(boolean paramBoolean, pay parampay, List<pay> paramList, int paramInt);
  
  public abstract void onCommentCreate(boolean paramBoolean1, pay parampay, boolean paramBoolean2, List<pay> paramList, int paramInt);
  
  public abstract void onCommentDelete(int paramInt1, boolean paramBoolean, pay parampay, int paramInt2);
  
  public abstract void onCommentLikeOrDislike(boolean paramBoolean, String paramString, int paramInt1, int paramInt2);
  
  public abstract void onCommentLoadMore(int paramInt1, boolean paramBoolean1, List<pay> paramList, boolean paramBoolean2, int paramInt2);
  
  public abstract void onCommentReply(boolean paramBoolean, pay parampay);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pcp
 * JD-Core Version:    0.7.0.1
 */