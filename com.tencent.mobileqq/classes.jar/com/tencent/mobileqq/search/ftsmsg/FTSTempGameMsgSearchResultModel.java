package com.tencent.mobileqq.search.ftsmsg;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager;
import com.tencent.mobileqq.activity.recent.gamemsgbox.data.GameBoxRecentUser;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SearchHistoryManager;
import com.tencent.mobileqq.fts.data.msg.FTSMessage;
import com.tencent.mobileqq.fts.v1.FTSEntity;
import com.tencent.mobileqq.fts.v1.utils.TextMsgExts;
import com.tencent.mobileqq.gamecenter.msginfo.GameDetailInfo;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchDetailActivity;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchResultModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.ArrayList;
import java.util.List;

public class FTSTempGameMsgSearchResultModel
  extends FTSEntitySearchResultModel
{
  private String n;
  private GameDetailInfo o;
  private GameBoxRecentUser p;
  
  public FTSTempGameMsgSearchResultModel(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, ArrayList<String> paramArrayList, List<? extends FTSEntity> paramList, String paramString3)
  {
    super(paramQQAppInterface, paramString1, paramString2, paramArrayList, paramList);
    this.n = paramString3;
    paramQQAppInterface = (IGameMsgBoxManager)paramQQAppInterface.getRuntimeService(IGameMsgBoxManager.class, "");
    this.p = paramQQAppInterface.findGameBoxRecentUserInfo(paramString3);
    this.o = paramQQAppInterface.findGameDetailInfoByConvertUin(paramString3);
  }
  
  public CharSequence a()
  {
    if (this.h == null)
    {
      int i = this.m.size();
      if (i == 1)
      {
        this.h = SearchUtils.a(((FTSEntity)this.m.get(0)).mContent, ((FTSEntity)this.m.get(0)).mProximityStart, this.c);
      }
      else
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131902945));
        ((StringBuilder)localObject).append("\"");
        localObject = new SpannableStringBuilder(((StringBuilder)localObject).toString());
        ((SpannableStringBuilder)localObject).append(SearchUtils.a(this.a, this.a));
        ((SpannableStringBuilder)localObject).append("\"").append("相关记录");
        this.h = ((CharSequence)localObject);
      }
    }
    return this.h;
  }
  
  public void a(View paramView)
  {
    this.e = this.o.e;
    if (this.m.size() == 1)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("uin", this.n);
      localBundle.putString("game_msg_friend_role_id", this.p.mToRoleId);
      localBundle.putString("game_msg_my_role_id", this.p.mFromRoleId);
      localBundle.putInt("uintype", 10007);
      localBundle.putInt("game_msg_open_aio_from", 6);
      RecentUtil.a = true;
      FTSMessage localFTSMessage = (FTSMessage)this.m.get(0);
      if (localFTSMessage.msgExts != null) {
        RecentUtil.c = ((TextMsgExts)localFTSMessage.msgExts).time;
      }
      SearchHistoryManager.a(this.d, this.a);
      RecentUtil.a(paramView.getContext(), this.d, this.n, 10007, this.o.e, false, localBundle, null);
      return;
    }
    FTSEntitySearchDetailActivity.a(paramView.getContext(), g(), this.b, this.e, this.m, 1, this.n, 10007);
  }
  
  public int b()
  {
    return 119;
  }
  
  public String c()
  {
    return this.n;
  }
  
  public CharSequence d()
  {
    return this.o.e;
  }
  
  public CharSequence e()
  {
    return null;
  }
  
  public CharSequence i()
  {
    return null;
  }
  
  public CharSequence j()
  {
    return null;
  }
  
  public boolean m()
  {
    return (this.p != null) && (this.o != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsmsg.FTSTempGameMsgSearchResultModel
 * JD-Core Version:    0.7.0.1
 */