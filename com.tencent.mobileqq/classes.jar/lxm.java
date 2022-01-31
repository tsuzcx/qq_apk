import com.tencent.biz.pubaccount.readinjoy.skin.SkinGifImageDownloader;
import com.tencent.image.NativeGifImage;
import java.io.File;

public class lxm
  extends NativeGifImage
{
  public lxm(SkinGifImageDownloader paramSkinGifImageDownloader, File paramFile, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, float paramFloat)
  {
    super(paramFile, paramBoolean1, paramBoolean2, paramInt1, paramInt2, paramFloat);
  }
  
  protected void executeNewTask()
  {
    if (this.mCurrentLoop == 1) {
      return;
    }
    super.executeNewTask();
  }
  
  public void reset()
  {
    super.reset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lxm
 * JD-Core Version:    0.7.0.1
 */