package com.tencent.mobileqq.qqgamepub.fragment;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqgamepub.data.GmpEnterInfoRsp;
import com.tencent.mobileqq.qqgamepub.utils.GameCenterUtils;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qqgamepub.view.NavBarQQGamePub;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

class QQGameFeedWebFragment$17
  implements Runnable
{
  QQGameFeedWebFragment$17(QQGameFeedWebFragment paramQQGameFeedWebFragment, GmpEnterInfoRsp paramGmpEnterInfoRsp) {}
  
  public void run()
  {
    if ((QQGameFeedWebFragment.a(this.this$0) != null) && (!QQGameFeedWebFragment.a(this.this$0).isFinishing()) && (this.this$0.isAdded()) && (this.this$0.a != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GameWebPage", 1, "show game enter icon");
      }
      this.this$0.a.setCurType(1);
      this.this$0.a.a(false);
      this.this$0.a.a(this.a.icon, this.a.content, this.a.url);
      this.this$0.a.setmBubbleid(this.a.bubble_id);
      GamePubAccountHelper.a(this.a);
      HashMap localHashMap = new HashMap();
      if (!TextUtils.isEmpty(this.a.bubble_id)) {
        localHashMap.put(Integer.valueOf(2), this.a.bubble_id);
      }
      localHashMap.put(Integer.valueOf(3), "3");
      localHashMap.put(Integer.valueOf(4), "8");
      localHashMap.put(Integer.valueOf(24), "1");
      GameCenterUtils.a(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface(), "770", "207021", "", "77002", "1", "160", localHashMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.fragment.QQGameFeedWebFragment.17
 * JD-Core Version:    0.7.0.1
 */