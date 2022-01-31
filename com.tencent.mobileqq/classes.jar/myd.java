import android.support.v4.util.LruCache;
import com.tencent.biz.qqstory.base.Copyable;
import com.tencent.biz.qqstory.base.OneObjectCacheList;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

public class myd
  extends LruCache
{
  public myd(OneObjectCacheList paramOneObjectCacheList, int paramInt)
  {
    super(paramInt);
  }
  
  protected void a(boolean paramBoolean, Object paramObject, Copyable paramCopyable1, Copyable paramCopyable2)
  {
    this.a.a.put(paramObject, new WeakReference(paramCopyable1));
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     myd
 * JD-Core Version:    0.7.0.1
 */