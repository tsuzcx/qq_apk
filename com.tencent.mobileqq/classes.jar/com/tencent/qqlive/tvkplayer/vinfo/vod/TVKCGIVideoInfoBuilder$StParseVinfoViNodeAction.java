package com.tencent.qqlive.tvkplayer.vinfo.vod;

import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import org.w3c.dom.Node;

class TVKCGIVideoInfoBuilder$StParseVinfoViNodeAction
  implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
{
  TVKCGIVideoInfoBuilder$StParseVinfoViNodeAction(TVKCGIVideoInfoBuilder paramTVKCGIVideoInfoBuilder) {}
  
  public void onParseVinfoViNode(Node paramNode)
  {
    TVKCGIVideoInfoBuilder localTVKCGIVideoInfoBuilder = this.this$0;
    TVKCGIVideoInfoBuilder.access$502(localTVKCGIVideoInfoBuilder, TVKUtils.optInt(TVKCGIVideoInfoBuilder.access$200(localTVKCGIVideoInfoBuilder, paramNode), 0));
    TVKCGIVideoInfoBuilder.access$300(this.this$0).setSt(TVKCGIVideoInfoBuilder.access$500(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIVideoInfoBuilder.StParseVinfoViNodeAction
 * JD-Core Version:    0.7.0.1
 */