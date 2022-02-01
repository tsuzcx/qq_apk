package com.tencent.mobileqq.mini.entry.desktop;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class MiniAppDesktopAdapter$DesktopMostCommonlyUsedViewHolder$2
  implements MiniAppCmdInterface
{
  MiniAppDesktopAdapter$DesktopMostCommonlyUsedViewHolder$2(MiniAppDesktopAdapter.DesktopMostCommonlyUsedViewHolder paramDesktopMostCommonlyUsedViewHolder) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      QLog.d("MiniAppDesktopAdapter", 2, new Object[] { "rejectFrequentlyRecommends suc, ret = ", paramJSONObject });
      return;
    }
    QLog.e("MiniAppDesktopAdapter", 1, new Object[] { "rejectFrequentlyRecommends fail, ret = ", paramJSONObject });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.DesktopMostCommonlyUsedViewHolder.2
 * JD-Core Version:    0.7.0.1
 */