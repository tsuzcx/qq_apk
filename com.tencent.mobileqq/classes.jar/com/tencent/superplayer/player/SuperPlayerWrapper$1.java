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
    if (paramInt1 == 102)
    {
      if ((paramObject instanceof Map)) {
        SuperPlayerWrapper.access$002(this.this$0, (String)((Map)paramObject).get("flowid"));
      }
    }
    else if (paramInt1 == 501)
    {
      paramString = SuperPlayerWrapper.access$100(this.this$0);
      paramObject = new StringBuilder();
      paramObject.append("日志过滤(Player): 【SuperPlayer-");
      paramObject.append(SuperPlayerWrapper.access$200(this.this$0));
      paramObject.append("|playId:");
      paramObject.append(paramInt2);
      paramObject.append("|player");
      paramObject.append(paramInt2);
      paramObject.append("】 , ");
      paramObject.append(SuperPlayerWrapper.access$300(this.this$0));
      LogUtil.d(paramString, paramObject.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.superplayer.player.SuperPlayerWrapper.1
 * JD-Core Version:    0.7.0.1
 */