package com.tencent.qqlive.tvkplayer.vinfo.vod;

import com.tencent.qqlive.tvkplayer.vinfo.apiinner.ITVKCGIVInfoResponse;
import com.tencent.qqlive.tvkplayer.vinfo.apiinner.ITVKVideoInfoResponse;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKVideoInfoTransfer;
import org.w3c.dom.Document;

class TVKVideoInfoRequest$1
  implements ITVKCGIVInfoResponse
{
  TVKVideoInfoRequest$1(TVKVideoInfoRequest paramTVKVideoInfoRequest) {}
  
  public void onVInfoFailure(String paramString1, String paramString2, int paramInt)
  {
    TVKVideoInfoRequest.access$100(this.this$0).onFailure(TVKVideoInfoRequest.access$000(this.this$0), 101, paramString2, paramInt, null);
  }
  
  public void onVInfoSuccess(String paramString1, String paramString2, Document paramDocument)
  {
    TVKVideoInfoRequest.access$202(this.this$0, TVKVideoInfoRequest.access$300(this.this$0).parseVinfo(paramDocument));
    TVKVideoInfoRequest.access$300(this.this$0).setVinfoXml(paramString2);
    if (TVKVideoInfoRequest.access$300(this.this$0).getEm() > 0)
    {
      int i = TVKVideoInfoRequest.access$300(this.this$0).getEm() + 1300000;
      TVKVideoInfoRequest.access$100(this.this$0).onFailure(TVKVideoInfoRequest.access$000(this.this$0), 101, String.format("%d;%d.%d", new Object[] { Integer.valueOf(101), Integer.valueOf(i), Integer.valueOf(TVKVideoInfoRequest.access$300(this.this$0).getExem()) }), i, paramString2);
      return;
    }
    if ((TVKVideoInfoRequest.access$300(this.this$0).getDltype() == 1) && (TVKVideoInfoRequest.access$300(this.this$0).getClipCount() > 1) && (TVKVideoInfoRequest.access$300(this.this$0).getSt() != 8))
    {
      TVKVideoInfoRequest.access$400(this.this$0);
      return;
    }
    TVKVideoInfoRequest.access$300(this.this$0).buildCdnUrl(TVKVideoInfoRequest.access$500(this.this$0).getUpc());
    TVKVideoInfoRequest.access$200(this.this$0).setUrl(TVKVideoInfoRequest.access$300(this.this$0).getUrl());
    TVKVideoInfoRequest.access$200(this.this$0).setVinfoXml(TVKVideoInfoRequest.access$300(this.this$0).getVinfoXml());
    TVKVideoInfoRequest.access$100(this.this$0).onSuccess(TVKVideoInfoRequest.access$000(this.this$0), TVKVideoInfoTransfer.transfer(TVKVideoInfoRequest.access$200(this.this$0), TVKVideoInfoRequest.access$500(this.this$0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKVideoInfoRequest.1
 * JD-Core Version:    0.7.0.1
 */