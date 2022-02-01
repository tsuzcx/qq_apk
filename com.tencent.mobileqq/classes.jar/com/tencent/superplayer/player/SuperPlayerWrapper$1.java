package com.tencent.superplayer.player;

import com.tencent.superplayer.utils.LogUtil;
import com.tencent.thumbplayer.tplayer.plugins.ITPPluginBase;
import java.util.Map;

class SuperPlayerWrapper$1
  implements ITPPluginBase
{
  SuperPlayerWrapper$1(SuperPlayerWrapper paramSuperPlayerWrapper) {}
  
  public void onAttach() {}
  
  public void onDetach() {}
  
  public void onEvent(int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (paramInt1 == 102) {
      if ((paramObject instanceof Map)) {
        SuperPlayerWrapper.access$002(this.this$0, (String)((Map)paramObject).get("flowid"));
      }
    }
    while (paramInt1 != 501) {
      return;
    }
    LogUtil.d(SuperPlayerWrapper.access$100(this.this$0), "日志过滤(Player): 【SuperPlayer-" + SuperPlayerWrapper.access$200(this.this$0) + "|playId:" + paramInt2 + "|player" + paramInt2 + "】 , " + SuperPlayerWrapper.access$300(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.player.SuperPlayerWrapper.1
 * JD-Core Version:    0.7.0.1
 */