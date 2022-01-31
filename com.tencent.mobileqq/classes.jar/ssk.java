import android.support.v4.util.LruCache;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

class ssk
  extends LruCache<KEY, VALUE>
{
  ssk(ssj paramssj, int paramInt)
  {
    super(paramInt);
  }
  
  protected void a(boolean paramBoolean, KEY paramKEY, VALUE paramVALUE1, VALUE paramVALUE2)
  {
    this.a.a.put(paramKEY, new WeakReference(paramVALUE1));
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ssk
 * JD-Core Version:    0.7.0.1
 */