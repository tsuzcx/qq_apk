public class svd
{
  public String a;
  public String b;
  public String c;
  public String d;
  
  public svd(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if ((paramObject instanceof svd)) {
        return false;
      }
      paramObject = (svd)paramObject;
      if ((this.b == null) || (!this.b.equals(paramObject.b))) {
        break;
      }
    } while ((this.c != null) && (this.c.equals(paramObject.c)));
    return false;
    return false;
  }
  
  public String toString()
  {
    return " bid :" + this.b + " localPath:" + this.c + "  ";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     svd
 * JD-Core Version:    0.7.0.1
 */