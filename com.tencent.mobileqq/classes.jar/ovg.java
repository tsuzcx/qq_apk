import java.util.List;

public abstract interface ovg
  extends ovf
{
  public abstract void onCommentCreate(boolean paramBoolean, otp paramotp, List<otp> paramList, int paramInt);
  
  public abstract void onCommentCreate(boolean paramBoolean1, otp paramotp, boolean paramBoolean2, List<otp> paramList, int paramInt);
  
  public abstract void onCommentDelete(int paramInt1, boolean paramBoolean, otp paramotp, int paramInt2);
  
  public abstract void onCommentLikeOrDislike(boolean paramBoolean, String paramString, int paramInt1, int paramInt2);
  
  public abstract void onCommentLoadMore(int paramInt1, boolean paramBoolean1, List<otp> paramList, boolean paramBoolean2, int paramInt2);
  
  public abstract void onCommentReply(boolean paramBoolean, otp paramotp);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ovg
 * JD-Core Version:    0.7.0.1
 */