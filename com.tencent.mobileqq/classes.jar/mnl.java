import android.util.LruCache;

class mnl
  extends LruCache<String, mnm>
{
  mnl(mnk parammnk, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(String paramString, mnm parammnm)
  {
    if (parammnm == null) {
      return 0;
    }
    return parammnm.a.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mnl
 * JD-Core Version:    0.7.0.1
 */