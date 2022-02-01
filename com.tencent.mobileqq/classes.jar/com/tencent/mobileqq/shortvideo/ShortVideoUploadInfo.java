package com.tencent.mobileqq.shortvideo;

public class ShortVideoUploadInfo
  extends ShortVideoBaseInfo
{
  public boolean A;
  public boolean B = false;
  public boolean C = false;
  public boolean D = false;
  public String E = "";
  public String F = "";
  public String G = "";
  public String H = "";
  public String I = "";
  public int J = 0;
  public long K = 0L;
  public int L = 0;
  public boolean M = false;
  public int N;
  public String O;
  public boolean P = false;
  public boolean Q;
  public String R;
  public String S;
  public ShortVideoUploadInfo.RetryInfo T;
  public String l;
  public String m;
  public String n;
  public int o;
  public int p;
  public int q;
  public int r;
  public Object s;
  public int t;
  public String u;
  public String v;
  public boolean w = true;
  public boolean x;
  public int y;
  public int z;
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nShortVideoUploadInfo");
    localStringBuilder.append("\n |-");
    localStringBuilder.append("localPath:");
    localStringBuilder.append(this.l);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("md5:");
    localStringBuilder.append(this.i);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("thumbPath:");
    localStringBuilder.append(this.n);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("thumbWidth:");
    localStringBuilder.append(this.o);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("thumbHeight:");
    localStringBuilder.append(this.p);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("sendSizeSpec:");
    localStringBuilder.append(this.q);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("fileTime:");
    localStringBuilder.append(this.r);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("fileSource:");
    localStringBuilder.append(this.v);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("supportProgressive:");
    localStringBuilder.append(this.x);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("fileWidth:");
    localStringBuilder.append(this.y);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("fileHeight:");
    localStringBuilder.append(this.z);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("templateId:");
    localStringBuilder.append(this.R);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("templateName:");
    localStringBuilder.append(this.S);
    return localStringBuilder.toString();
  }
  
  public boolean b()
  {
    return super.b();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo
 * JD-Core Version:    0.7.0.1
 */