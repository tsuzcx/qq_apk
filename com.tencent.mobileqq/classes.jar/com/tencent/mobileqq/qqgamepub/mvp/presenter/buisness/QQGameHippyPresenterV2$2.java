package com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness;

import android.text.TextUtils;
import com.tencent.mobileqq.qqgamepub.utils.GamePAPreloadHelper;
import com.tencent.mobileqq.qqgamepub.utils.GamePAPreloadHelper.OnPreloadFeedsListener;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;

class QQGameHippyPresenterV2$2
  implements GamePAPreloadHelper.OnPreloadFeedsListener
{
  QQGameHippyPresenterV2$2(QQGameHippyPresenterV2 paramQQGameHippyPresenterV2) {}
  
  public void a(String paramString)
  {
    HippyMap localHippyMap = new HippyMap();
    if ((!TextUtils.isEmpty(paramString)) && (GamePAPreloadHelper.c() > 0L))
    {
      localHippyMap.pushString("result", paramString);
      this.a.a("onGameListDataPreload", localHippyMap);
      GamePAPreloadHelper.b("1");
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("mPreloadFeedsListener,onResult -> getPreloadGetTime:");
      paramString.append(GamePAPreloadHelper.c());
      paramString.append(",hippyMap:");
      paramString.append(localHippyMap);
      QLog.i("feedsPreload_QQGamePub_QQGameHippyPresenterV2", 2, paramString.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameHippyPresenterV2.2
 * JD-Core Version:    0.7.0.1
 */