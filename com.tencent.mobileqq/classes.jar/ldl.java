import android.support.v4.util.LruCache;

class ldl
  extends LruCache<String, String>
{
  ldl(ldk paramldk, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(String paramString1, String paramString2)
  {
    return paramString2.length() + 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ldl
 * JD-Core Version:    0.7.0.1
 */