package dov.com.qq.im.ae.data;

import java.io.File;

public class AEPreDownloadResMetaData
  extends AEMaterialMetaData
{
  public String s;
  public String t;
  
  public String a()
  {
    File localFile = new File(this.t);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return this.t + File.separator + this.f;
  }
  
  public String b()
  {
    File localFile = new File(this.t);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return this.t + File.separator;
  }
  
  public String c()
  {
    File localFile = new File(this.s);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return this.s + File.separator + this.f;
  }
  
  public boolean d()
  {
    Object localObject = new File(a());
    if (!((File)localObject).exists()) {}
    do
    {
      return false;
      localObject = ((File)localObject).list();
    } while ((localObject == null) || (localObject.length <= 0));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.data.AEPreDownloadResMetaData
 * JD-Core Version:    0.7.0.1
 */