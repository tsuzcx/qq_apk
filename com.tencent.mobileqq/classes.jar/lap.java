import android.support.v4.util.LruCache;

class lap
  extends LruCache<String, String>
{
  lap(lao paramlao, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(String paramString1, String paramString2)
  {
    return paramString2.length() + 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lap
 * JD-Core Version:    0.7.0.1
 */