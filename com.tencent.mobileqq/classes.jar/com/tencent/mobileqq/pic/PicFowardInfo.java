package com.tencent.mobileqq.pic;

import com.tencent.mobileqq.utils.FileUtils;

public class PicFowardInfo
  extends PicInfoInterface
  implements PicUiInterface
{
  public boolean a;
  public PicUploadInfo b = new PicUploadInfo();
  public PicDownloadInfo c = new PicDownloadInfo();
  public boolean d = true;
  public int e = -1;
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nPicFowardInfo");
    Object localObject = this.b;
    if (localObject != null) {
      localObject = ((PicUploadInfo)localObject).a();
    } else {
      localObject = "\n |-upInfo=null";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
  
  public boolean b()
  {
    Object localObject = this.b;
    if (localObject == null)
    {
      a("PicFowardInfo.check", "upInfo == null");
      return false;
    }
    if (((((PicUploadInfo)localObject).c == 1000) || (this.b.c == 1020) || (this.b.c == 1004)) && (this.b.f == null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("secondId invalid,uinType:");
      ((StringBuilder)localObject).append(this.b.c);
      ((StringBuilder)localObject).append(",secondId:");
      ((StringBuilder)localObject).append(this.b.f);
      a("PicFowardInfo.check", ((StringBuilder)localObject).toString());
      return false;
    }
    if (this.b.s == -1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("protocolType invalid,protocolType:");
      ((StringBuilder)localObject).append(this.b.s);
      a("PicFowardInfo.check", ((StringBuilder)localObject).toString());
      return false;
    }
    if (!FileUtils.fileExistsAndNotEmpty(this.b.n))
    {
      localObject = this.c;
      if (localObject == null)
      {
        a("PicFowardInfo.check", "downInfo == null");
        return false;
      }
      if (!((PicDownloadInfo)localObject).b())
      {
        this.H = this.c.H;
        return false;
      }
    }
    return true;
  }
  
  public PicDownloadInfo getPicDownloadInfo()
  {
    return this.c;
  }
  
  public PicUploadInfo getPicUploadInfo()
  {
    return this.b;
  }
  
  public boolean isSendFromLocal()
  {
    return this.d;
  }
  
  public String toString()
  {
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicFowardInfo
 * JD-Core Version:    0.7.0.1
 */