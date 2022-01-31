package cooperation.weiyun.sdk.download;

public class DownloadFile$DownloadServerInfo
  implements Cloneable
{
  public int a;
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  
  private DownloadFile$DownloadServerInfo(DownloadFile paramDownloadFile, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
  }
  
  public DownloadServerInfo a()
  {
    try
    {
      DownloadServerInfo localDownloadServerInfo = (DownloadServerInfo)super.clone();
      return localDownloadServerInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.weiyun.sdk.download.DownloadFile.DownloadServerInfo
 * JD-Core Version:    0.7.0.1
 */