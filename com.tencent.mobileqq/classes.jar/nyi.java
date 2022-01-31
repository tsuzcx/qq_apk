import java.util.List;

public abstract interface nyi
  extends nyh
{
  public abstract void onCommentCreate(boolean paramBoolean, nwx paramnwx, List<nwx> paramList, int paramInt);
  
  public abstract void onCommentCreate(boolean paramBoolean1, nwx paramnwx, boolean paramBoolean2, List<nwx> paramList, int paramInt);
  
  public abstract void onCommentDelete(int paramInt1, boolean paramBoolean, nwx paramnwx, int paramInt2);
  
  public abstract void onCommentLikeOrDislike(boolean paramBoolean, String paramString, int paramInt1, int paramInt2);
  
  public abstract void onCommentLoadMore(int paramInt1, boolean paramBoolean1, List<nwx> paramList, boolean paramBoolean2, int paramInt2);
  
  public abstract void onCommentReply(boolean paramBoolean, nwx paramnwx);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     nyi
 * JD-Core Version:    0.7.0.1
 */