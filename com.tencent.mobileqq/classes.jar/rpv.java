public class rpv
{
  public String a;
  public String b;
  public String c;
  public String d;
  
  public rpv(String paramString)
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
      if ((paramObject instanceof rpv)) {
        return false;
      }
      paramObject = (rpv)paramObject;
    } while ((this.b != null) && (this.b.equals(paramObject.b)) && (this.c != null) && (this.c.equals(paramObject.c)));
    return false;
  }
  
  public String toString()
  {
    return " bid :" + this.b + " localPath:" + this.c + "  ";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rpv
 * JD-Core Version:    0.7.0.1
 */