package com.tencent.qqlive.tvkplayer.vinfo.vod;

import org.w3c.dom.Node;

class TVKCGIVideoInfoBuilder$FvkeyParseVinfoViNodeAction
  implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
{
  TVKCGIVideoInfoBuilder$FvkeyParseVinfoViNodeAction(TVKCGIVideoInfoBuilder paramTVKCGIVideoInfoBuilder) {}
  
  public void onParseVinfoViNode(Node paramNode)
  {
    TVKCGIVideoInfoBuilder.access$702(this.this$0, TVKCGIVideoInfoBuilder.access$200(this.this$0, paramNode));
    TVKCGIVideoInfoBuilder.access$300(this.this$0).setFvkey(TVKCGIVideoInfoBuilder.access$700(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIVideoInfoBuilder.FvkeyParseVinfoViNodeAction
 * JD-Core Version:    0.7.0.1
 */