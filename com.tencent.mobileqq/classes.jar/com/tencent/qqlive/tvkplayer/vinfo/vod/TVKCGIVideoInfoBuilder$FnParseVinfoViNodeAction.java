package com.tencent.qqlive.tvkplayer.vinfo.vod;

import org.w3c.dom.Node;

class TVKCGIVideoInfoBuilder$FnParseVinfoViNodeAction
  implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
{
  TVKCGIVideoInfoBuilder$FnParseVinfoViNodeAction(TVKCGIVideoInfoBuilder paramTVKCGIVideoInfoBuilder) {}
  
  public void onParseVinfoViNode(Node paramNode)
  {
    TVKCGIVideoInfoBuilder localTVKCGIVideoInfoBuilder = this.this$0;
    TVKCGIVideoInfoBuilder.access$402(localTVKCGIVideoInfoBuilder, TVKCGIVideoInfoBuilder.access$200(localTVKCGIVideoInfoBuilder, paramNode));
    TVKCGIVideoInfoBuilder.access$300(this.this$0).setFn(TVKCGIVideoInfoBuilder.access$400(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIVideoInfoBuilder.FnParseVinfoViNodeAction
 * JD-Core Version:    0.7.0.1
 */