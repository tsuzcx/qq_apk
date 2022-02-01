import android.util.LruCache;

class m
  extends LruCache<Integer, String>
{
  public m(l paraml, int paramInt)
  {
    super(paramInt);
  }
  
  protected void a(boolean paramBoolean, Integer paramInteger, String paramString1, String paramString2)
  {
    super.entryRemoved(paramBoolean, paramInteger, paramString1, paramString2);
    n.a("FastColorFontHelper", "release start font " + paramString1);
    this.a.a(paramInteger.intValue());
    k.a(paramInteger.intValue());
    n.a("FastColorFontHelper", "release end   font " + paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     m
 * JD-Core Version:    0.7.0.1
 */