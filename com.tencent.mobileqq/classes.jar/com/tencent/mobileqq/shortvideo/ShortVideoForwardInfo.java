package com.tencent.mobileqq.shortvideo;

public class ShortVideoForwardInfo
  extends ShortVideoBaseInfo
{
  public int A;
  public String B;
  public String C;
  public boolean D;
  public int E;
  public int F;
  public int G;
  public String H = "";
  public String I = "";
  public String J = "";
  public String K = "";
  public int L = 0;
  public int M = 0;
  public int N = 0;
  public String O = "";
  public long P = 0L;
  public boolean Q = false;
  public boolean R;
  public String S = "";
  public String T = "";
  public ShortVideoForwardInfo.RetryInfo U;
  public int l;
  public int m;
  public int n;
  public int o;
  public String p;
  public String q;
  public int r;
  public int s;
  public int t;
  public int u;
  public Object v;
  public int w;
  public String x;
  public String y;
  public int z;
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nShortVideoForwardInfo");
    localStringBuilder.append("\n |-");
    localStringBuilder.append("fromChatType:");
    localStringBuilder.append(this.l);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("toChatType:");
    localStringBuilder.append(this.m);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("fromBusiType:");
    localStringBuilder.append(this.n);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("toBusiType:");
    localStringBuilder.append(this.o);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("localPath:");
    localStringBuilder.append(this.p);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("md5:");
    localStringBuilder.append(this.i);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("thumbPath:");
    localStringBuilder.append(this.q);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("thumbWidth:");
    localStringBuilder.append(this.r);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("thumbHeight:");
    localStringBuilder.append(this.s);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("sendSizeSpec:");
    localStringBuilder.append(this.t);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("fileTime:");
    localStringBuilder.append(this.u);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("fileSource:");
    localStringBuilder.append(this.x);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("uuid:");
    localStringBuilder.append(this.a);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("fromUin:");
    localStringBuilder.append(this.B);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("fromSessionUin:");
    localStringBuilder.append(this.C);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("supportProgressive:");
    localStringBuilder.append(this.D);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("templateId:");
    localStringBuilder.append(this.S);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("templateName:");
    localStringBuilder.append(this.T);
    return localStringBuilder.toString();
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
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoForwardInfo
 * JD-Core Version:    0.7.0.1
 */