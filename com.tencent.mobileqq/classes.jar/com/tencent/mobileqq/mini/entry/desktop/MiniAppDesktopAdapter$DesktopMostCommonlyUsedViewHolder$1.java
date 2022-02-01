package com.tencent.mobileqq.mini.entry.desktop;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class MiniAppDesktopAdapter$DesktopMostCommonlyUsedViewHolder$1
  implements MiniAppCmdInterface
{
  MiniAppDesktopAdapter$DesktopMostCommonlyUsedViewHolder$1(MiniAppDesktopAdapter.DesktopMostCommonlyUsedViewHolder paramDesktopMostCommonlyUsedViewHolder) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      QLog.d("MiniAppDesktopAdapter", 2, "mostCommonlyUsed setUserAppTop suc");
      return;
    }
    QLog.e("MiniAppDesktopAdapter", 1, "mostCommonlyUsed setUserAppTop fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.DesktopMostCommonlyUsedViewHolder.1
 * JD-Core Version:    0.7.0.1
 */