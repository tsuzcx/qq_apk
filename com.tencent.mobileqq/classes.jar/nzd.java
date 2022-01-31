import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.URLImageLoader;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.URLImageLoader.Config;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.InfoPrinter;

public class nzd
  extends LruCache
{
  public nzd(URLImageLoader paramURLImageLoader, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(URLImageLoader.Config paramConfig, Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable))
    {
      paramDrawable = ((BitmapDrawable)paramDrawable).getBitmap();
      if (paramDrawable != null)
      {
        int i = paramDrawable.getRowBytes();
        i = paramDrawable.getHeight() * i;
        InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "URLImageLoader cache put:", paramConfig, " size=", Integer.valueOf(i) });
        return i;
      }
    }
    return 524288;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nzd
 * JD-Core Version:    0.7.0.1
 */