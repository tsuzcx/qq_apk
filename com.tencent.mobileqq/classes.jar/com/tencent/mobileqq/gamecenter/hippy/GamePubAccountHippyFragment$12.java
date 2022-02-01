package com.tencent.mobileqq.gamecenter.hippy;

import com.tencent.gamecenter.appointment.GameCenterUtils;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.gamecenter.util.QQGameHelper;
import java.util.HashMap;
import java.util.Map;

class GamePubAccountHippyFragment$12
  implements Runnable
{
  GamePubAccountHippyFragment$12(GamePubAccountHippyFragment paramGamePubAccountHippyFragment) {}
  
  public void run()
  {
    GamePubAccountHippyFragment.a(this.this$0, false, 0);
    QQGameHelper.b(this.this$0.getActivity());
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(24), this.this$0.a());
    localHashMap.put(Integer.valueOf(4), "20");
    GameCenterUtils.a(CmGameUtil.a(), "769", "205036", "", "76901", "1", "160", localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.hippy.GamePubAccountHippyFragment.12
 * JD-Core Version:    0.7.0.1
 */