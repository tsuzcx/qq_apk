import java.util.List;

public abstract interface ojt
  extends ojs
{
  public abstract void onCommentCreate(boolean paramBoolean, oii paramoii, List<oii> paramList, int paramInt);
  
  public abstract void onCommentCreate(boolean paramBoolean1, oii paramoii, boolean paramBoolean2, List<oii> paramList, int paramInt);
  
  public abstract void onCommentDelete(int paramInt1, boolean paramBoolean, oii paramoii, int paramInt2);
  
  public abstract void onCommentLikeOrDislike(boolean paramBoolean, String paramString, int paramInt1, int paramInt2);
  
  public abstract void onCommentLoadMore(int paramInt1, boolean paramBoolean1, List<oii> paramList, boolean paramBoolean2, int paramInt2);
  
  public abstract void onCommentReply(boolean paramBoolean, oii paramoii);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ojt
 * JD-Core Version:    0.7.0.1
 */