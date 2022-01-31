import android.support.v4.util.LruCache;

class lbh
  extends LruCache<String, String>
{
  lbh(lbg paramlbg, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(String paramString1, String paramString2)
  {
    return paramString2.length() + 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     lbh
 * JD-Core Version:    0.7.0.1
 */