package com.tencent.qqlive.tvkplayer.vinfo.vod;

import com.tencent.qqlive.tvkplayer.vinfo.apiinner.ITVKCGIVkeyResponse;
import com.tencent.qqlive.tvkplayer.vinfo.apiinner.ITVKVideoInfoResponse;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKVideoInfoTransfer;
import org.w3c.dom.Document;

class TVKVideoInfoRequest$2
  implements ITVKCGIVkeyResponse
{
  TVKVideoInfoRequest$2(TVKVideoInfoRequest paramTVKVideoInfoRequest) {}
  
  public void OnVkeyFailure(String paramString1, String paramString2, int paramInt)
  {
    TVKVideoInfoRequest.access$100(this.this$0).onFailure(TVKVideoInfoRequest.access$000(this.this$0), 103, paramString2, paramInt, null);
  }
  
  public void OnVkeySuccess(String paramString1, String paramString2, Document paramDocument)
  {
    TVKVideoInfoRequest.access$300(this.this$0).parseVkeyInfo(paramDocument);
    if (TVKVideoInfoRequest.access$300(this.this$0).getEm() > 0)
    {
      int i = TVKVideoInfoRequest.access$300(this.this$0).getEm() + 1300200;
      TVKVideoInfoRequest.access$100(this.this$0).onFailure(TVKVideoInfoRequest.access$000(this.this$0), 103, String.format("%d;%d.%d", new Object[] { Integer.valueOf(103), Integer.valueOf(i), Integer.valueOf(TVKVideoInfoRequest.access$300(this.this$0).getExem()) }), i, null);
      return;
    }
    if (TVKVideoInfoRequest.access$300(this.this$0).getClipCount() == TVKVideoInfoRequest.access$300(this.this$0).getVkeyCount())
    {
      TVKVideoInfoRequest.access$300(this.this$0).buildCdnUrl(TVKVideoInfoRequest.access$500(this.this$0).getUpc());
      TVKVideoInfoRequest.access$200(this.this$0).setUrl(TVKVideoInfoRequest.access$300(this.this$0).getUrl());
      TVKVideoInfoRequest.access$200(this.this$0).setVinfoXml(TVKVideoInfoRequest.access$300(this.this$0).getVinfoXml());
      TVKVideoInfoRequest.access$100(this.this$0).OnSuccess(TVKVideoInfoRequest.access$000(this.this$0), TVKVideoInfoTransfer.transfer(TVKVideoInfoRequest.access$200(this.this$0), TVKVideoInfoRequest.access$500(this.this$0)));
      return;
    }
    TVKVideoInfoRequest.access$400(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKVideoInfoRequest.2
 * JD-Core Version:    0.7.0.1
 */