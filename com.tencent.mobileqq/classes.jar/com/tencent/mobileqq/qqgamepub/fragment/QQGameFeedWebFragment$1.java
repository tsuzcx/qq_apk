package com.tencent.mobileqq.qqgamepub.fragment;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.utils.GameCenterUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Map;

class QQGameFeedWebFragment$1
  implements View.OnClickListener
{
  QQGameFeedWebFragment$1(QQGameFeedWebFragment paramQQGameFeedWebFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject = QQGameFeedWebFragment.a(this.a);
    String str1 = "";
    String str2;
    if (localObject != null)
    {
      str2 = ((QQGameMsgInfo)localObject).gameAppId;
      if (!TextUtils.isEmpty(((QQGameMsgInfo)localObject).paMsgid)) {
        str1 = ((QQGameMsgInfo)localObject).paMsgid;
      }
    }
    else
    {
      str2 = "";
    }
    localObject = new HashMap();
    ((Map)localObject).put(Integer.valueOf(2), str1);
    ((Map)localObject).put(Integer.valueOf(3), "1");
    ((Map)localObject).put(Integer.valueOf(4), "20");
    ((Map)localObject).put(Integer.valueOf(24), "1");
    GameCenterUtils.a(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface(), "769", "205037", str2, "76901", "1", "160", (Map)localObject);
    ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).enterGameCenter(((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).getGamePubUrl());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.fragment.QQGameFeedWebFragment.1
 * JD-Core Version:    0.7.0.1
 */