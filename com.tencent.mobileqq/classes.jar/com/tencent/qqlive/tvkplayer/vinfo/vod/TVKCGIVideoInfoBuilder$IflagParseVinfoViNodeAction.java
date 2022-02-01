package com.tencent.qqlive.tvkplayer.vinfo.vod;

import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import org.w3c.dom.Node;

class TVKCGIVideoInfoBuilder$IflagParseVinfoViNodeAction
  implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
{
  TVKCGIVideoInfoBuilder$IflagParseVinfoViNodeAction(TVKCGIVideoInfoBuilder paramTVKCGIVideoInfoBuilder) {}
  
  public void onParseVinfoViNode(Node paramNode)
  {
    TVKCGIVideoInfoBuilder.access$300(this.this$0).setIflag(TVKUtils.optInt(TVKCGIVideoInfoBuilder.access$200(this.this$0, paramNode), 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIVideoInfoBuilder.IflagParseVinfoViNodeAction
 * JD-Core Version:    0.7.0.1
 */