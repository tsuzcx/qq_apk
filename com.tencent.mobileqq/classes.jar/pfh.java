import java.util.List;

public abstract interface pfh
  extends pfg
{
  public abstract void onCommentCreate(boolean paramBoolean, pdp parampdp, List<pdp> paramList, int paramInt);
  
  public abstract void onCommentCreate(boolean paramBoolean1, pdp parampdp, boolean paramBoolean2, List<pdp> paramList, int paramInt);
  
  public abstract void onCommentDelete(int paramInt1, boolean paramBoolean, pdp parampdp, int paramInt2);
  
  public abstract void onCommentLikeOrDislike(boolean paramBoolean, String paramString, int paramInt1, int paramInt2);
  
  public abstract void onCommentLoadMore(int paramInt1, boolean paramBoolean1, List<pdp> paramList, boolean paramBoolean2, int paramInt2);
  
  public abstract void onCommentReply(boolean paramBoolean, pdp parampdp);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pfh
 * JD-Core Version:    0.7.0.1
 */