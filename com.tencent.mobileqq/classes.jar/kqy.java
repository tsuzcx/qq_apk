import android.support.v4.util.LruCache;

class kqy
  extends LruCache<String, String>
{
  kqy(kqx paramkqx, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(String paramString1, String paramString2)
  {
    return paramString2.length() + 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     kqy
 * JD-Core Version:    0.7.0.1
 */