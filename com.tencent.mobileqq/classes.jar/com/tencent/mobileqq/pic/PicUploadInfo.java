package com.tencent.mobileqq.pic;

import com.tencent.image.GifDrawable;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;

public class PicUploadInfo
  extends PicBaseInfo
{
  public int A = 0;
  public String B;
  public int C;
  public int D;
  public long E;
  public int F;
  public int G;
  public int I = 0;
  public Object J;
  public int K;
  public int L = 0;
  public boolean M = false;
  public long N;
  public String O;
  public long P;
  public long Q;
  public PhotoSendParams R;
  public boolean S;
  public long T;
  public int U;
  public boolean V = false;
  public int W;
  public String X;
  public String Y;
  public String Z;
  public String aa;
  public int ab;
  public PicUploadExtra ac;
  public PicUploadInfo.RetryInfo ad;
  public String n;
  public String o;
  public int p;
  public int q;
  public ArrayList<Integer> r;
  public int s = -1;
  public int t;
  public long u = 0L;
  public boolean v = true;
  public boolean w = false;
  public boolean x = false;
  public boolean y = false;
  public boolean z = false;
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nPicUploadInfo");
    localStringBuilder.append("\n |-");
    localStringBuilder.append("localPath:");
    localStringBuilder.append(this.n);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("protocolType:");
    localStringBuilder.append(this.s);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("md5:");
    localStringBuilder.append(this.m);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("sendSizeSpec:");
    localStringBuilder.append(this.t);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("thumbPath:");
    localStringBuilder.append(this.o);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("thumbWidth:");
    localStringBuilder.append(this.p);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("thumbHeight:");
    localStringBuilder.append(this.q);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("source_image_width:");
    localStringBuilder.append(this.C);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("source_image_height:");
    localStringBuilder.append(this.D);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("source_image_filesize:");
    localStringBuilder.append(this.E);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("source_image_filesizeflag:");
    localStringBuilder.append(this.F);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("source_image_type:");
    localStringBuilder.append(this.G);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("entrance:");
    localStringBuilder.append(this.I);
    return localStringBuilder.toString();
  }
  
  public boolean b()
  {
    StringBuilder localStringBuilder;
    if (!FileUtils.fileExistsAndNotEmpty(this.n))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("path invalid,localPath:");
      localStringBuilder.append(this.n);
      a("checkPicInfo", localStringBuilder.toString());
      return false;
    }
    if (((this.c == 1000) || (this.c == 1020) || (this.c == 1004)) && (this.f == null))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("secondId invalid,uinType:");
      localStringBuilder.append(this.c);
      localStringBuilder.append(",secondId:");
      localStringBuilder.append(this.f);
      a("checkPicInfo", localStringBuilder.toString());
      return false;
    }
    if (j() == -1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("protocolType invalid,protocolType:");
      localStringBuilder.append(this.s);
      a("PicBaseInfo.check", localStringBuilder.toString());
      return false;
    }
    return super.b();
  }
  
  String c()
  {
    if (this.l == null)
    {
      Logger.b("PIC_TAG_ERROR", "PicUploadInfo.getUrlString", "protocol == null");
      return null;
    }
    boolean bool = "chatthumb".equals(this.l);
    int i = 65537;
    if (!bool) {
      if ("chatimg".equals(this.l)) {
        i = 1;
      } else if ("chatraw".equals(this.l)) {
        i = 131075;
      }
    }
    URL localURL = ((IPicHelper)QRoute.api(IPicHelper.class)).getURL(this, i, null);
    if (localURL != null) {
      return localURL.toString();
    }
    return null;
  }
  
  public boolean g()
  {
    PicUploadExtra localPicUploadExtra = this.ac;
    return (localPicUploadExtra != null) && (localPicUploadExtra.c);
  }
  
  public boolean h()
  {
    PicUploadExtra localPicUploadExtra = this.ac;
    return (localPicUploadExtra != null) && (localPicUploadExtra.f);
  }
  
  public boolean i()
  {
    PicUploadExtra localPicUploadExtra = this.ac;
    return (localPicUploadExtra != null) && (localPicUploadExtra.g);
  }
  
  public int j()
  {
    int i = this.s;
    if (i != -1) {
      return i;
    }
    String str = this.n;
    if (str != null)
    {
      if (GifDrawable.isGifFile(new File(str)))
      {
        this.s = 0;
        return this.s;
      }
    }
    else {
      Logger.b("PIC_TAG_ERROR", "PicUploadInfo.getProtocolType", "localPath == null");
    }
    if (this.t == 2) {
      this.s = 1;
    } else {
      this.s = 0;
    }
    return this.s;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicUploadInfo
 * JD-Core Version:    0.7.0.1
 */