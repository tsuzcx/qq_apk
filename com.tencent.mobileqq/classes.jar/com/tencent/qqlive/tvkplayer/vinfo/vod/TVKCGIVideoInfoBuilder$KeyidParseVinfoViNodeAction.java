package com.tencent.qqlive.tvkplayer.vinfo.vod;

import org.w3c.dom.Node;

class TVKCGIVideoInfoBuilder$KeyidParseVinfoViNodeAction
  implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
{
  TVKCGIVideoInfoBuilder$KeyidParseVinfoViNodeAction(TVKCGIVideoInfoBuilder paramTVKCGIVideoInfoBuilder) {}
  
  public void onParseVinfoViNode(Node paramNode)
  {
    TVKCGIVideoInfoBuilder.access$300(this.this$0).setKeyid(TVKCGIVideoInfoBuilder.access$200(this.this$0, paramNode));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIVideoInfoBuilder.KeyidParseVinfoViNodeAction
 * JD-Core Version:    0.7.0.1
 */