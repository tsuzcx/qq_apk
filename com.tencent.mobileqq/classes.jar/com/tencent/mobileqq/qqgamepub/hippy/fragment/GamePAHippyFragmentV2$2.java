package com.tencent.mobileqq.qqgamepub.hippy.fragment;

import android.text.TextUtils;
import com.tencent.mobileqq.qqgamepub.utils.GamePAPreloadHelper;
import com.tencent.mobileqq.qqgamepub.utils.GamePAPreloadHelper.OnPreloadFeedsListener;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;

class GamePAHippyFragmentV2$2
  implements GamePAPreloadHelper.OnPreloadFeedsListener
{
  GamePAHippyFragmentV2$2(GamePAHippyFragmentV2 paramGamePAHippyFragmentV2) {}
  
  public void a(String paramString)
  {
    HippyMap localHippyMap = new HippyMap();
    if ((!TextUtils.isEmpty(paramString)) && (GamePAPreloadHelper.a() > 0L))
    {
      localHippyMap.pushString("result", paramString);
      this.a.sendHippyNativeEvent("onGameListDataPreload", localHippyMap);
      GamePAPreloadHelper.b("1");
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("mPreloadFeedsListener,onResult -> getPreloadGetTime:");
      paramString.append(GamePAPreloadHelper.a());
      paramString.append(",hippyMap:");
      paramString.append(localHippyMap);
      QLog.i("feedsPreload_QQGamePub_GamePAHippyFragmentV2", 2, paramString.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyFragmentV2.2
 * JD-Core Version:    0.7.0.1
 */