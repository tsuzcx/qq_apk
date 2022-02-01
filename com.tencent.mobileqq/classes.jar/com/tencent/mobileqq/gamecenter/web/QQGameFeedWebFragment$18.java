package com.tencent.mobileqq.gamecenter.web;

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

class QQGameFeedWebFragment$18
  implements Runnable
{
  QQGameFeedWebFragment$18(QQGameFeedWebFragment paramQQGameFeedWebFragment, GmpEnterInfoRsp paramGmpEnterInfoRsp) {}
  
  public void run()
  {
    if ((this.this$0.getActivity() != null) && (!this.this$0.getActivity().isFinishing()) && (this.this$0.isAdded()) && (this.this$0.a != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GameWebPage", 1, "show game enter icon");
      }
      this.this$0.a.setCurType(1);
      this.this$0.a.a(false);
      this.this$0.a.a(this.a.icon, this.a.content, this.a.url);
      this.this$0.a.setmBubbleid(this.a.bubble_id);
      QQGameHelper.a(this.a);
      HashMap localHashMap = new HashMap();
      if (!TextUtils.isEmpty(this.a.bubble_id)) {
        localHashMap.put(Integer.valueOf(2), this.a.bubble_id);
      }
      localHashMap.put(Integer.valueOf(3), "3");
      localHashMap.put(Integer.valueOf(4), "8");
      localHashMap.put(Integer.valueOf(24), "1");
      GameCenterUtils.a(CmGameUtil.a(), "770", "207021", "", "77002", "1", "160", localHashMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment.18
 * JD-Core Version:    0.7.0.1
 */