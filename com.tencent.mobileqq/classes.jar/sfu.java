public class sfu
{
  public String a;
  public String b;
  public String c;
  public String d;
  
  public sfu(String paramString)
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
      if ((paramObject instanceof sfu)) {
        return false;
      }
      paramObject = (sfu)paramObject;
    } while ((this.b != null) && (this.b.equals(paramObject.b)) && (this.c != null) && (this.c.equals(paramObject.c)));
    return false;
  }
  
  public String toString()
  {
    return " bid :" + this.b + " localPath:" + this.c + "  ";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sfu
 * JD-Core Version:    0.7.0.1
 */