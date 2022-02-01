package com.tencent.mobileqq.pic;

import com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

public class PicReq
  implements Comparable<PicReq>
{
  public int a = -1;
  public int b;
  public String c = a();
  public String d;
  public CompressInfo e;
  public PicDownloadInfo f;
  public PicUploadInfo g;
  public PicFowardInfo h;
  public PicMessageExtraData i;
  public ArrayList<PicFowardInfo> j;
  public UiCallBack k;
  public MessageForPic l;
  public int m;
  public int n;
  public int o = 1;
  public int p = this.o;
  public ICompressionCallBack q;
  public Object r;
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("__");
    localStringBuilder.append(UUID.randomUUID().toString());
    return localStringBuilder.toString();
  }
  
  public int a(PicReq paramPicReq)
  {
    int i1 = this.o;
    int i2 = paramPicReq.o;
    if (i1 < i2) {
      return -1;
    }
    if (i1 > i2) {
      return 1;
    }
    return 0;
  }
  
  public void a(UiCallBack paramUiCallBack)
  {
    this.k = paramUiCallBack;
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
    paramString = this.e;
    if (paramString != null) {
      paramString.a = this.c;
    }
    paramString = this.g;
    if (paramString != null) {
      paramString.a = this.c;
    }
    paramString = this.f;
    if (paramString != null) {
      paramString.a = this.c;
    }
  }
  
  public void a(ArrayList<PicFowardInfo> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        PicFowardInfo localPicFowardInfo = (PicFowardInfo)localIterator.next();
        if (localPicFowardInfo != null)
        {
          if (localPicFowardInfo.b != null)
          {
            localPicFowardInfo.b.a = this.c;
            localPicFowardInfo.b.b = this.b;
          }
          if (localPicFowardInfo.c != null)
          {
            localPicFowardInfo.c.a = this.c;
            localPicFowardInfo.c.b = this.b;
          }
        }
      }
      this.j = paramArrayList;
      this.d = Logger.a(((PicFowardInfo)paramArrayList.get(0)).b.c, 2, 1);
      return;
    }
    Logger.a("PIC_TAG_ERROR", this.c, "bindReqObj", "fwInfoList is empty");
  }
  
  public boolean a(MessageForPic paramMessageForPic, PicDownloadInfo paramPicDownloadInfo)
  {
    if (paramPicDownloadInfo == null)
    {
      Logger.a("PIC_TAG_ERROR", this.c, "bindReqObj", "downInfo == null");
      return false;
    }
    paramPicDownloadInfo.a = this.c;
    paramPicDownloadInfo.b = this.b;
    paramPicDownloadInfo.u = paramMessageForPic.time;
    paramPicDownloadInfo.G = paramMessageForPic.bEnableEnc;
    this.f = paramPicDownloadInfo;
    int i1 = this.a;
    if (i1 == 5)
    {
      this.f.l = "chatthumb";
      i1 = 65537;
    }
    else if (i1 == 7)
    {
      i1 = 131075;
      this.f.l = "chatraw";
    }
    else
    {
      if (i1 == 6) {
        this.f.l = "chatimg";
      }
      i1 = 1;
    }
    this.d = Logger.a(this.f.c, 0, i1);
    this.l = paramMessageForPic;
    return true;
  }
  
  public boolean a(CompressInfo paramCompressInfo)
  {
    if (paramCompressInfo == null) {
      return false;
    }
    paramCompressInfo.a = this.c;
    if (paramCompressInfo.h == null) {
      return false;
    }
    this.e = paramCompressInfo;
    return true;
  }
  
  public boolean a(PicFowardInfo paramPicFowardInfo)
  {
    if (paramPicFowardInfo == null)
    {
      Logger.a("PIC_TAG_ERROR", this.c, "bindReqObj", "forwardInfo == null");
      return false;
    }
    if (paramPicFowardInfo.b != null)
    {
      paramPicFowardInfo.b.a = this.c;
      paramPicFowardInfo.b.b = this.b;
    }
    if (paramPicFowardInfo.c != null)
    {
      paramPicFowardInfo.c.a = this.c;
      paramPicFowardInfo.c.b = this.b;
    }
    this.h = paramPicFowardInfo;
    int i1 = -1;
    if (paramPicFowardInfo.b != null) {
      i1 = paramPicFowardInfo.b.c;
    }
    this.d = Logger.a(i1, 2, 1);
    return true;
  }
  
  public boolean a(PicUploadInfo paramPicUploadInfo)
  {
    if (paramPicUploadInfo == null)
    {
      Logger.a("PIC_TAG_ERROR", this.c, "bindReqObj", "upInfo == null");
      return false;
    }
    paramPicUploadInfo.a = this.c;
    paramPicUploadInfo.b = this.b;
    this.g = paramPicUploadInfo;
    this.d = Logger.a(this.g.c, 1, 1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicReq
 * JD-Core Version:    0.7.0.1
 */