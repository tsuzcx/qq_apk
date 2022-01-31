public class mtb
{
  public ayrx a;
  public String a = "";
  public String b = "";
  public String c = "";
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("DownloadInfo{");
    localStringBuffer.append(", url='").append(this.a).append('\'');
    localStringBuffer.append(", md5='").append(this.b).append('\'');
    localStringBuffer.append(", fileName='").append(this.c).append('\'');
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mtb
 * JD-Core Version:    0.7.0.1
 */