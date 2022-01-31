import java.util.List;

public abstract interface ojq
  extends ojp
{
  public abstract void onCommentCreate(boolean paramBoolean, oif paramoif, List<oif> paramList, int paramInt);
  
  public abstract void onCommentCreate(boolean paramBoolean1, oif paramoif, boolean paramBoolean2, List<oif> paramList, int paramInt);
  
  public abstract void onCommentDelete(int paramInt1, boolean paramBoolean, oif paramoif, int paramInt2);
  
  public abstract void onCommentLikeOrDislike(boolean paramBoolean, String paramString, int paramInt1, int paramInt2);
  
  public abstract void onCommentLoadMore(int paramInt1, boolean paramBoolean1, List<oif> paramList, boolean paramBoolean2, int paramInt2);
  
  public abstract void onCommentReply(boolean paramBoolean, oif paramoif);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ojq
 * JD-Core Version:    0.7.0.1
 */