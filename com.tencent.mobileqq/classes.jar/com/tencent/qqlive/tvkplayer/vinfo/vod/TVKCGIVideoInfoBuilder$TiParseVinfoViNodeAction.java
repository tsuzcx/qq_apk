package com.tencent.qqlive.tvkplayer.vinfo.vod;

import org.w3c.dom.Node;

class TVKCGIVideoInfoBuilder$TiParseVinfoViNodeAction
  implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
{
  TVKCGIVideoInfoBuilder$TiParseVinfoViNodeAction(TVKCGIVideoInfoBuilder paramTVKCGIVideoInfoBuilder) {}
  
  public void onParseVinfoViNode(Node paramNode)
  {
    TVKCGIVideoInfoBuilder.access$300(this.this$0).setTi(TVKCGIVideoInfoBuilder.access$200(this.this$0, paramNode));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIVideoInfoBuilder.TiParseVinfoViNodeAction
 * JD-Core Version:    0.7.0.1
 */