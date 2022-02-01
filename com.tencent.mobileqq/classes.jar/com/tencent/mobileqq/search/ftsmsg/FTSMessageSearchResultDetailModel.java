package com.tencent.mobileqq.search.ftsmsg;

import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SearchHistoryManager;
import com.tencent.mobileqq.fts.data.msg.FTSMessage;
import com.tencent.mobileqq.fts.v1.FTSEntity;
import com.tencent.mobileqq.fts.v1.utils.TextMsgExts;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchResultDetailModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
import java.util.ArrayList;

public class FTSMessageSearchResultDetailModel
  extends FTSEntitySearchResultDetailModel
{
  private String h;
  private String i;
  private int j;
  
  public FTSMessageSearchResultDetailModel(QQAppInterface paramQQAppInterface, String paramString, ArrayList<String> paramArrayList, FTSEntity paramFTSEntity)
  {
    super(paramQQAppInterface, paramString, paramArrayList, paramFTSEntity);
    paramQQAppInterface = (FTSMessage)this.a;
    this.h = String.valueOf(paramQQAppInterface.uin);
    this.i = paramQQAppInterface.senderuin;
    this.j = paramQQAppInterface.istroop;
    d();
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
    RecentUtil.a = true;
    FTSMessage localFTSMessage = (FTSMessage)this.a;
    if (localFTSMessage.msgExts != null) {
      if ((localFTSMessage.istroop != 1) && (localFTSMessage.istroop != 3000)) {
        RecentUtil.c = ((TextMsgExts)localFTSMessage.msgExts).time;
      } else {
        RecentUtil.c = ((TextMsgExts)localFTSMessage.msgExts).shmsgseq;
      }
    }
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.d = localFTSMessage.searchStrategy;
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.f = 1;
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.g = this.j;
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.j = ((FTSMessage)this.a).senderNum;
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.k = ((FTSMessage)this.a).friendNum;
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.l = ((FTSMessage)this.a).friendIndex;
    SQLiteFTSUtils.a(paramView);
    RecentUtil.a(paramView.getContext(), this.e, this.h, this.j, ContactUtils.a(this.e, this.h, this.j), false);
    SearchHistoryManager.a(this.e, this.b);
    SearchUtils.a(this.b, 40, paramView, true);
  }
  
  public String c()
  {
    return String.valueOf(((FTSMessage)this.a).senderuin);
  }
  
  public CharSequence d()
  {
    if (this.f == null)
    {
      FTSMessage localFTSMessage = (FTSMessage)this.a;
      if (localFTSMessage.matchTitle != null)
      {
        this.f = localFTSMessage.matchTitle;
      }
      else
      {
        boolean bool = this.e.getCurrentAccountUin().equals(localFTSMessage.senderuin);
        SessionInfo localSessionInfo = new SessionInfo();
        localSessionInfo.a = this.j;
        localSessionInfo.b = this.h;
        if ("80000000".equals(this.i)) {
          this.f = HardCodeUtil.a(2131902944);
        } else {
          this.f = ContactUtils.a(this.e, localSessionInfo, bool, localFTSMessage.senderuin);
        }
      }
    }
    return this.f;
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
 * Qualified Name:     com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchResultDetailModel
 * JD-Core Version:    0.7.0.1
 */