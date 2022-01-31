import android.util.LruCache;
import com.tencent.biz.qqstory.shareGroup.icon.IconLog;
import com.tencent.biz.qqstory.shareGroup.icon.ShareGroupIconManager;

public class nqf
  extends LruCache
{
  public nqf(ShareGroupIconManager paramShareGroupIconManager, int paramInt)
  {
    super(paramInt);
  }
  
  protected void a(boolean paramBoolean, String paramString, npy paramnpy1, npy paramnpy2)
  {
    super.entryRemoved(paramBoolean, paramString, paramnpy1, paramnpy2);
    IconLog.a("story.icon.ShareGroupIconManager", "entryRemoved key = %s" + paramString);
    paramnpy1.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nqf
 * JD-Core Version:    0.7.0.1
 */