import android.util.LruCache;

class h
  extends LruCache<Integer, String>
{
  public h(g paramg, int paramInt)
  {
    super(paramInt);
  }
  
  protected void a(boolean paramBoolean, Integer paramInteger, String paramString1, String paramString2)
  {
    super.entryRemoved(paramBoolean, paramInteger, paramString1, paramString2);
    i.a("FastColorFontHelper", "release start font " + paramString1);
    this.a.a(paramInteger.intValue());
    f.a(paramInteger.intValue());
    i.a("FastColorFontHelper", "release end   font " + paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     h
 * JD-Core Version:    0.7.0.1
 */