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
    case 113: 
      TPLogUtil.d("TPLogPlugin", "on reset");
      return;
    case 112: 
      TPLogUtil.d("TPLogPlugin", "on release");
      return;
    case 111: 
      TPLogUtil.d("TPLogPlugin", "on play complete");
      return;
    case 110: 
      TPLogUtil.d("TPLogPlugin", "seek complete");
      return;
    case 109: 
      TPLogUtil.d("TPLogPlugin", "start seek");
      return;
    case 108: 
      paramString = new StringBuilder();
      paramString.append("on error:");
      paramString.append(paramInt2);
      TPLogUtil.d("TPLogPlugin", paramString.toString());
      return;
    case 107: 
      TPLogUtil.d("TPLogPlugin", "on stoped");
      return;
    case 106: 
      TPLogUtil.d("TPLogPlugin", "on paused");
      return;
    case 104: 
      TPLogUtil.d("TPLogPlugin", "start play");
      return;
    case 103: 
      TPLogUtil.d("TPLogPlugin", "on prepared");
      return;
    case 102: 
      TPLogUtil.d("TPLogPlugin", "start prepare");
      return;
    }
    TPLogUtil.d("TPLogPlugin", "create player adapter");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.plugins.report.TPLogPlugin
 * JD-Core Version:    0.7.0.1
 */