import android.util.LruCache;
import com.tencent.biz.qqstory.shareGroup.icon.IconLog;
import com.tencent.biz.qqstory.shareGroup.icon.ShareGroupIconManager;

public class nwi
  extends LruCache
{
  public nwi(ShareGroupIconManager paramShareGroupIconManager, int paramInt)
  {
    super(paramInt);
  }
  
  protected void a(boolean paramBoolean, String paramString, nwb paramnwb1, nwb paramnwb2)
  {
    super.entryRemoved(paramBoolean, paramString, paramnwb1, paramnwb2);
    IconLog.a("story.icon.ShareGroupIconManager", "entryRemoved key = %s" + paramString);
    paramnwb1.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nwi
 * JD-Core Version:    0.7.0.1
 */