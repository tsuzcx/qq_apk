package com.tencent.thumbplayer.tplayer.plugins.report;

import com.tencent.thumbplayer.tplayer.plugins.ITPPluginBase;
import com.tencent.thumbplayer.utils.TPLogUtil;

public class TPLogPlugin
  implements ITPPluginBase
{
  public static final String TAG = "TPLogPlugin";
  
  public void onAttach() {}
  
  public void onDetach() {}
  
  public void onEvent(int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    switch (paramInt1)
    {
    case 105: 
    default: 
      return;
    case 101: 
      TPLogUtil.d("TPLogPlugin", "create player adapter");
      return;
    case 102: 
      TPLogUtil.d("TPLogPlugin", "start prepare");
      return;
    case 103: 
      TPLogUtil.d("TPLogPlugin", "on prepared");
      return;
    case 104: 
      TPLogUtil.d("TPLogPlugin", "start play");
      return;
    case 106: 
      TPLogUtil.d("TPLogPlugin", "on paused");
      return;
    case 107: 
      TPLogUtil.d("TPLogPlugin", "on stoped");
      return;
    case 108: 
      TPLogUtil.d("TPLogPlugin", "on error:" + paramInt2);
      return;
    case 109: 
      TPLogUtil.d("TPLogPlugin", "start seek");
      return;
    case 110: 
      TPLogUtil.d("TPLogPlugin", "seek complete");
      return;
    case 111: 
      TPLogUtil.d("TPLogPlugin", "on play complete");
      return;
    case 113: 
      TPLogUtil.d("TPLogPlugin", "on reset");
      return;
    }
    TPLogUtil.d("TPLogPlugin", "on release");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.plugins.report.TPLogPlugin
 * JD-Core Version:    0.7.0.1
 */