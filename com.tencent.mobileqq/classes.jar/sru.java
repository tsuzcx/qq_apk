public class sru
{
  @vlq(a="pkIconUrl")
  public String a;
  @vlq(a="pkWording")
  public String b;
  @vlq(a="pkAction")
  public String c;
  @vlq(a="pkIconUrlSelf")
  public String d;
  @vlq(a="pkWordingSelf")
  public String e;
  @vlq(a="pkActionSelf")
  public String f;
  
  public String toString()
  {
    return "VideoLinkGameInfo {, pkBody='" + this.b + '\'' + ", pkIconUrl='" + this.a + '\'' + ", pkAction='" + this.c + '\'' + ", pkBodySelf='" + this.e + '\'' + ", pkIconUrlSelf='" + this.d + '\'' + ", pkActionSelf='" + this.f + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sru
 * JD-Core Version:    0.7.0.1
 */