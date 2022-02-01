import android.support.v4.util.LruCache;

class lai
  extends LruCache<String, String>
{
  lai(lah paramlah, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(String paramString1, String paramString2)
  {
    return paramString2.length() + 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lai
 * JD-Core Version:    0.7.0.1
 */