package com.tencent.qqlive.tvkplayer.vinfo.vod;

import org.w3c.dom.Node;

class TVKCGIVideoInfoBuilder$LnkParseVinfoViNodeAction
  implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
{
  TVKCGIVideoInfoBuilder$LnkParseVinfoViNodeAction(TVKCGIVideoInfoBuilder paramTVKCGIVideoInfoBuilder) {}
  
  public void onParseVinfoViNode(Node paramNode)
  {
    TVKCGIVideoInfoBuilder localTVKCGIVideoInfoBuilder = this.this$0;
    TVKCGIVideoInfoBuilder.access$602(localTVKCGIVideoInfoBuilder, TVKCGIVideoInfoBuilder.access$200(localTVKCGIVideoInfoBuilder, paramNode));
    TVKCGIVideoInfoBuilder.access$300(this.this$0).setLnk(TVKCGIVideoInfoBuilder.access$600(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIVideoInfoBuilder.LnkParseVinfoViNodeAction
 * JD-Core Version:    0.7.0.1
 */