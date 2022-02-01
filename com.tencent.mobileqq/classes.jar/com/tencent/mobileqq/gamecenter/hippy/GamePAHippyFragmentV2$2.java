package com.tencent.mobileqq.gamecenter.hippy;

import android.text.TextUtils;
import com.tencent.mobileqq.gamecenter.util.QQGameHelper;
import com.tencent.mobileqq.gamecenter.util.QQGameHelper.OnPreloadFeedsListener;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;

class GamePAHippyFragmentV2$2
  implements QQGameHelper.OnPreloadFeedsListener
{
  GamePAHippyFragmentV2$2(GamePAHippyFragmentV2 paramGamePAHippyFragmentV2) {}
  
  public void a(String paramString)
  {
    HippyMap localHippyMap = new HippyMap();
    if ((!TextUtils.isEmpty(paramString)) && (QQGameHelper.b() > 0L))
    {
      localHippyMap.pushString("result", paramString);
      this.a.sendHippyNativeEvent("onGameListDataPreload", localHippyMap);
      QQGameHelper.e("1");
    }
    if (QLog.isColorLevel()) {
      QLog.i("feedsPreload_GamePAHippyFragmentV2", 2, "mPreloadFeedsListener,onResult -> getPreloadGetTime:" + QQGameHelper.b() + ",hippyMap:" + localHippyMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.hippy.GamePAHippyFragmentV2.2
 * JD-Core Version:    0.7.0.1
 */