import android.util.LruCache;
import com.tencent.biz.qqstory.shareGroup.icon.IconLog;
import com.tencent.biz.qqstory.shareGroup.icon.ShareGroupIconManager;

public class nrs
  extends LruCache
{
  public nrs(ShareGroupIconManager paramShareGroupIconManager, int paramInt)
  {
    super(paramInt);
  }
  
  protected void a(boolean paramBoolean, String paramString, nrl paramnrl1, nrl paramnrl2)
  {
    super.entryRemoved(paramBoolean, paramString, paramnrl1, paramnrl2);
    IconLog.a("story.icon.ShareGroupIconManager", "entryRemoved key = %s" + paramString);
    paramnrl1.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nrs
 * JD-Core Version:    0.7.0.1
 */