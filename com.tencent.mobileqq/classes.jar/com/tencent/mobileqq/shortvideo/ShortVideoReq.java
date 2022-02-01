package com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicReq;
import java.util.ArrayList;

public class ShortVideoReq
  implements Comparable<ShortVideoReq>
{
  public int a = -1;
  public int b;
  public String c = PicReq.a();
  public String d;
  public ShortVideoDownloadInfo e;
  public ShortVideoUploadInfo f;
  public ShortVideoForwardInfo g;
  public ArrayList<ShortVideoForwardInfo> h;
  public UiCallBack i;
  public MessageForShortVideo j;
  public int k;
  public int l;
  public int m = 201;
  public boolean n;
  public VideoDownCallback o;
  public int p;
  public String[] q;
  public long r;
  
  public int a(ShortVideoReq paramShortVideoReq)
  {
    int i1 = this.m;
    int i2 = paramShortVideoReq.m;
    if (i1 < i2) {
      return -1;
    }
    if (i1 > i2) {
      return 1;
    }
    return 0;
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo)
  {
    this.j = paramMessageForShortVideo;
  }
  
  public void a(ShortVideoDownloadInfo paramShortVideoDownloadInfo)
  {
    if (paramShortVideoDownloadInfo == null)
    {
      Logger.a("PIC_TAG_ERROR", this.c, "bindReqObj", "downInfo == null");
      return;
    }
    paramShortVideoDownloadInfo.b = this.b;
    this.e = paramShortVideoDownloadInfo;
    int i2 = paramShortVideoDownloadInfo.q;
    int i1 = 6;
    if (i2 == 1002) {
      i1 = 7;
    } else if (paramShortVideoDownloadInfo.q == 1006) {
      i1 = 18;
    } else if (paramShortVideoDownloadInfo.q == 1004) {
      i1 = 16;
    } else if (paramShortVideoDownloadInfo.q != 1001) {
      if (paramShortVideoDownloadInfo.q == 1005) {
        i1 = 17;
      } else if (paramShortVideoDownloadInfo.q == 1003) {
        i1 = 9;
      } else if (paramShortVideoDownloadInfo.q == 1008) {
        i1 = 68;
      } else if (paramShortVideoDownloadInfo.q == 1007) {
        i1 = 67;
      }
    }
    this.d = Logger.a(this.e.c, 0, i1);
  }
  
  public void a(ShortVideoForwardInfo paramShortVideoForwardInfo)
  {
    if (paramShortVideoForwardInfo == null)
    {
      Logger.a("PIC_TAG_ERROR", this.c, "bindReqObj", "forwardInfo == null");
      return;
    }
    paramShortVideoForwardInfo.b = this.b;
    this.g = paramShortVideoForwardInfo;
    this.d = Logger.a(this.g.c, 2, 20);
  }
  
  public void a(ShortVideoUploadInfo paramShortVideoUploadInfo)
  {
    if (paramShortVideoUploadInfo == null)
    {
      Logger.a("PIC_TAG_ERROR", this.c, "bindReqObj", "upInfo == null");
      return;
    }
    paramShortVideoUploadInfo.b = this.b;
    this.f = paramShortVideoUploadInfo;
    int i2 = paramShortVideoUploadInfo.c;
    int i1 = 6;
    if (i2 != 0) {
      if (paramShortVideoUploadInfo.c == 3000) {
        i1 = 17;
      } else if (paramShortVideoUploadInfo.c == 1) {
        i1 = 9;
      }
    }
    this.d = Logger.a(this.f.c, 1, i1);
  }
  
  public void a(UiCallBack paramUiCallBack)
  {
    this.i = paramUiCallBack;
  }
  
  public void a(ArrayList<ShortVideoForwardInfo> paramArrayList)
  {
    this.h = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoReq
 * JD-Core Version:    0.7.0.1
 */