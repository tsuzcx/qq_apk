package com.tencent.mobileqq.openapi.sdk;

import com.tencent.mobileqq.app.HardCodeUtil;

public class MessageItem
{
  public static final String a = HardCodeUtil.a(2131904520);
  public static final String b = HardCodeUtil.a(2131904519);
  public static final String c = HardCodeUtil.a(2131904518);
  public static final String d = HardCodeUtil.a(2131904522);
  public static final String e = HardCodeUtil.a(2131904521);
  public static final String f = HardCodeUtil.a(2131904523);
  public static final String[] g = { "uin", "uin_type", "senderUin", "msg_type", "msgid", "msgTime", "is_send", "msgContent", "media_path", "mediaStatus" };
  public String h;
  public int i;
  public String j;
  public int k;
  public String l;
  public long m;
  public boolean n;
  public String o;
  public int p;
  public String q;
  
  private MessageItem() {}
  
  public MessageItem(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, long paramLong, boolean paramBoolean, String paramString4, String paramString5, int paramInt3)
  {
    this.h = paramString1;
    this.i = paramInt1;
    this.j = paramString2;
    this.k = paramInt2;
    this.l = paramString3;
    this.m = paramLong;
    this.n = paramBoolean;
    this.o = paramString4;
    this.q = paramString5;
    this.p = paramInt3;
  }
  
  public Object[] a()
  {
    return new Object[] { this.h, Integer.valueOf(this.i), this.j, Integer.valueOf(this.k), this.l, Long.valueOf(this.m), Boolean.valueOf(this.n), this.o, this.q, Integer.valueOf(this.p) };
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(200);
    localStringBuilder.append(this.h);
    localStringBuilder.append("; ");
    localStringBuilder.append(this.k);
    localStringBuilder.append("; ");
    localStringBuilder.append(this.j);
    localStringBuilder.append("; ");
    localStringBuilder.append(this.l);
    localStringBuilder.append("; ");
    localStringBuilder.append(this.m);
    localStringBuilder.append(";");
    localStringBuilder.append(this.n);
    localStringBuilder.append("; ");
    localStringBuilder.append(this.o);
    localStringBuilder.append("; ");
    localStringBuilder.append(this.q);
    localStringBuilder.append("; ");
    localStringBuilder.append(this.p);
    localStringBuilder.append(". ");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.openapi.sdk.MessageItem
 * JD-Core Version:    0.7.0.1
 */