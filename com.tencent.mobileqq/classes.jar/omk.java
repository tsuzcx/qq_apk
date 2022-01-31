import android.text.TextUtils;

class omk
{
  public String a;
  public String b;
  
  omk(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public boolean a()
  {
    return (!TextUtils.isEmpty(this.a)) && (!TextUtils.isEmpty(this.b));
  }
  
  public String toString()
  {
    return "[insertArticleInfo] algorithmID = " + this.a + ", rowKey = " + this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     omk
 * JD-Core Version:    0.7.0.1
 */