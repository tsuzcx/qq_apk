package com.tencent.mobileqq.search.ftsmsg;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager;
import com.tencent.mobileqq.activity.recent.gamemsgbox.data.GameBoxRecentUser;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SearchHistoryManager;
import com.tencent.mobileqq.fts.data.msg.FTSMessage;
import com.tencent.mobileqq.fts.v1.FTSEntity;
import com.tencent.mobileqq.fts.v1.utils.TextMsgExts;
import com.tencent.mobileqq.gamecenter.msginfo.GameDetailInfo;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchResultDetailModel;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import java.util.ArrayList;

public class FTSTempGameMsgSearchResultDetailModel
  extends FTSEntitySearchResultDetailModel
{
  private String h;
  private GameDetailInfo i;
  private GameBoxRecentUser j;
  
  public FTSTempGameMsgSearchResultDetailModel(QQAppInterface paramQQAppInterface, String paramString, ArrayList<String> paramArrayList, FTSEntity paramFTSEntity)
  {
    super(paramQQAppInterface, paramString, paramArrayList, paramFTSEntity);
    this.h = String.valueOf(((FTSMessage)paramFTSEntity).uin);
    paramQQAppInterface = (IGameMsgBoxManager)paramQQAppInterface.getRuntimeService(IGameMsgBoxManager.class, "");
    this.j = paramQQAppInterface.findGameBoxRecentUserInfo(this.h);
    this.i = paramQQAppInterface.findGameDetailInfoByConvertUin(this.h);
  }
  
  public CharSequence a()
  {
    if (TextUtils.isEmpty(this.d))
    {
      this.d = "";
      FTSMessage localFTSMessage = (FTSMessage)this.a;
      if (localFTSMessage.msgExts != null) {
        this.d = TimeFormatterUtils.a(BaseApplicationImpl.sApplication, 3, ((TextMsgExts)localFTSMessage.msgExts).time * 1000L);
      }
    }
    return this.d;
  }
  
  public void a(View paramView)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", this.h);
    localBundle.putString("game_msg_friend_role_id", this.j.mToRoleId);
    localBundle.putString("game_msg_my_role_id", this.j.mFromRoleId);
    localBundle.putInt("uintype", 10007);
    localBundle.putInt("game_msg_open_aio_from", 6);
    RecentUtil.a = true;
    FTSMessage localFTSMessage = (FTSMessage)this.a;
    if (localFTSMessage.msgExts != null) {
      RecentUtil.c = ((TextMsgExts)localFTSMessage.msgExts).time;
    }
    SearchHistoryManager.a(this.e, this.b);
    RecentUtil.a(paramView.getContext(), this.e, this.h, 10007, this.i.e, false, localBundle, null);
  }
  
  public int b()
  {
    return 119;
  }
  
  public String c()
  {
    return this.h;
  }
  
  public CharSequence d()
  {
    return this.i.e;
  }
  
  public CharSequence i()
  {
    if (this.g == null)
    {
      FTSMessage localFTSMessage = (FTSMessage)this.a;
      if (localFTSMessage.matchSecondTitle != null) {
        this.g = localFTSMessage.matchSecondTitle;
      }
    }
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsmsg.FTSTempGameMsgSearchResultDetailModel
 * JD-Core Version:    0.7.0.1
 */