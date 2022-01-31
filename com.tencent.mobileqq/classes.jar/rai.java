public class rai
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  
  public String a(int paramInt)
  {
    if (paramInt == 2) {
      return this.d;
    }
    if (paramInt == 3) {
      return this.e;
    }
    if (paramInt == 6) {
      return this.a;
    }
    if (paramInt == 4) {
      return this.c;
    }
    if (paramInt == 5) {
      return this.b;
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("weibo : ").append(this.a).append("\n");
    localStringBuilder.append("qq : ").append(this.d).append("\n");
    localStringBuilder.append("wx : ").append(this.c).append("\n");
    localStringBuilder.append("pyq : ").append(this.b).append("\n");
    localStringBuilder.append("qzone : ").append(this.e).append("\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rai
 * JD-Core Version:    0.7.0.1
 */