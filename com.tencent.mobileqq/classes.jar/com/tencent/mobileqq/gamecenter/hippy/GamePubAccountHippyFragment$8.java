package com.tencent.mobileqq.gamecenter.hippy;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.gamecenter.appointment.GameCenterUtils;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.gamecenter.protocol.GmpEnterInfoRsp;
import com.tencent.mobileqq.gamecenter.util.QQGameHelper;
import com.tencent.mobileqq.gamecenter.view.NavBarQQGamePub;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

class GamePubAccountHippyFragment$8
  implements Runnable
{
  GamePubAccountHippyFragment$8(GamePubAccountHippyFragment paramGamePubAccountHippyFragment, GmpEnterInfoRsp paramGmpEnterInfoRsp) {}
  
  public void run()
  {
    if ((this.this$0.getActivity() != null) && (!this.this$0.getActivity().isFinishing()) && (this.this$0.isAdded()) && (GamePubAccountHippyFragment.a(this.this$0) != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GamePubAccountHippyFragment", 1, "show game enter icon");
      }
      GamePubAccountHippyFragment.a(this.this$0).setCurType(2);
      GamePubAccountHippyFragment.a(this.this$0).a(false);
      GamePubAccountHippyFragment.a(this.this$0).a(this.a.icon, this.a.content, this.a.url);
      GamePubAccountHippyFragment.a(this.this$0).setmBubbleid(this.a.bubble_id);
      QQGameHelper.a(this.a);
      HashMap localHashMap = new HashMap();
      if (!TextUtils.isEmpty(this.a.bubble_id)) {
        localHashMap.put(Integer.valueOf(2), this.a.bubble_id);
      }
      localHashMap.put(Integer.valueOf(3), "3");
      localHashMap.put(Integer.valueOf(4), "8");
      localHashMap.put(Integer.valueOf(24), this.this$0.a());
      GameCenterUtils.a(CmGameUtil.a(), "770", "207021", "", "77002", "1", "160", localHashMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.hippy.GamePubAccountHippyFragment.8
 * JD-Core Version:    0.7.0.1
 */