import java.net.URL;

public abstract interface qbe
{
  public abstract int getCommentCount();
  
  public abstract String getInnerUniqueID();
  
  public abstract String getShareUrl();
  
  public abstract String getSubscribeName();
  
  public abstract String getSubscribeUin();
  
  public abstract URL getVideoCoverURL();
  
  public abstract URL getVideoCoverUrlWithSmartCut(boolean paramBoolean);
  
  public abstract URL getVideoCoverWithSmartCut(int paramInt1, int paramInt2);
  
  public abstract int getVideoDuration();
  
  public abstract int getVideoHeight();
  
  public abstract String getVideoVid();
  
  public abstract int getVideoWidth();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qbe
 * JD-Core Version:    0.7.0.1
 */