package com.tencent.mobileqq.search.model;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SearchHistoryManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import java.text.SimpleDateFormat;

public class MessageSearchResultDetailModel
  extends ISearchResultPositionModel
{
  private static SimpleDateFormat a = new SimpleDateFormat("yy/MM/dd");
  private RecentUser b;
  private MessageRecord c;
  private String d;
  private CharSequence e;
  private QQAppInterface f;
  private CharSequence g;
  private CharSequence h;
  
  public MessageSearchResultDetailModel(QQAppInterface paramQQAppInterface, String paramString, RecentUser paramRecentUser, MessageRecord paramMessageRecord)
  {
    this.f = paramQQAppInterface;
    this.d = paramString;
    this.b = paramRecentUser;
    this.c = paramMessageRecord;
  }
  
  public CharSequence a()
  {
    if (TextUtils.isEmpty(this.e)) {
      this.e = TimeFormatterUtils.a(BaseApplicationImpl.sApplication, 3, this.c.time * 1000L);
    }
    return this.e;
  }
  
  public void a(View paramView)
  {
    RecentUtil.a = true;
    RecentUtil.b = this.c;
    RecentUtil.a(paramView.getContext(), this.f, this.b.uin, this.b.getType(), ContactUtils.a(this.f, this.b.uin, this.b.getType()), false);
    SearchHistoryManager.a(this.f, this.d);
    SearchUtils.a(this.d, 40, paramView, true);
  }
  
  public int b()
  {
    return 1;
  }
  
  public String c()
  {
    return this.c.senderuin;
  }
  
  public CharSequence d()
  {
    if (this.g == null)
    {
      Object localObject;
      if (AnonymousChatHelper.c(this.c))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(BaseApplicationImpl.sApplication.getString(2131895011));
        ((StringBuilder)localObject).append(AnonymousChatHelper.g(this.c).c);
        this.g = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = new SessionInfo();
        ((SessionInfo)localObject).a = this.b.getType();
        ((SessionInfo)localObject).b = this.b.uin;
        this.g = ContactUtils.a(this.f, (SessionInfo)localObject, this.c.isSend(), this.c.senderuin);
      }
    }
    return this.g;
  }
  
  public CharSequence e()
  {
    if (this.h == null) {
      this.h = SearchUtils.a(this.c.msg, this.d);
    }
    return this.h;
  }
  
  public CharSequence f()
  {
    return null;
  }
  
  public String g()
  {
    return this.d;
  }
  
  public boolean h()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.MessageSearchResultDetailModel
 * JD-Core Version:    0.7.0.1
 */