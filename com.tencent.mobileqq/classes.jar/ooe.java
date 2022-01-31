import java.util.List;

public abstract interface ooe
  extends ood
{
  public abstract void onCommentCreate(boolean paramBoolean, omt paramomt, List<omt> paramList, int paramInt);
  
  public abstract void onCommentCreate(boolean paramBoolean1, omt paramomt, boolean paramBoolean2, List<omt> paramList, int paramInt);
  
  public abstract void onCommentDelete(int paramInt1, boolean paramBoolean, omt paramomt, int paramInt2);
  
  public abstract void onCommentLikeOrDislike(boolean paramBoolean, String paramString, int paramInt1, int paramInt2);
  
  public abstract void onCommentLoadMore(int paramInt1, boolean paramBoolean1, List<omt> paramList, boolean paramBoolean2, int paramInt2);
  
  public abstract void onCommentReply(boolean paramBoolean, omt paramomt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ooe
 * JD-Core Version:    0.7.0.1
 */