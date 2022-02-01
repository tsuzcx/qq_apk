package com.tencent.mobileqq.search.model;

import addcontacts.AccountSearchPb.record;
import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.contact.addcontact.publicaccount.PublicView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.QLog;

public class GroupNetSearchModelPublicAcntItem
  extends ISearchResultPositionModel
{
  public CharSequence a;
  private AccountSearchPb.record b;
  private String c;
  
  public GroupNetSearchModelPublicAcntItem(AccountSearchPb.record paramrecord, String paramString, CharSequence paramCharSequence)
  {
    this.b = paramrecord;
    this.c = paramString;
    this.a = paramCharSequence;
  }
  
  public CharSequence a()
  {
    return HardCodeUtil.a(2131903335);
  }
  
  public void a(View paramView)
  {
    Context localContext = paramView.getContext();
    if ((localContext != null) && ((localContext instanceof BaseActivity)))
    {
      PublicView.a((QQAppInterface)((BaseActivity)localContext).getAppRuntime(), localContext, this.b.class_index.get(), String.valueOf(this.b.uin.get()), String.valueOf(this.b.uin.get()), this.b.account_flag.get(), this.b.name.get(), 4);
      SearchUtils.a(this.c, 70, 0, paramView);
      SearchUtils.a(this.c, 70, paramView, false);
    }
  }
  
  public int b()
  {
    return 1;
  }
  
  public String c()
  {
    return String.valueOf(this.b.uin.get());
  }
  
  public CharSequence d()
  {
    return SearchUtils.a(this.b.name.get(), this.c);
  }
  
  public CharSequence e()
  {
    return null;
  }
  
  public CharSequence f()
  {
    return null;
  }
  
  public String g()
  {
    return this.c;
  }
  
  public boolean h()
  {
    return false;
  }
  
  public boolean i()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("name = ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(", isCert = ");
      boolean bool;
      if ((this.b.has()) && (this.b.flag.get() == 1L)) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      QLog.d("GroupNetSearchModelPublicAcntItem", 2, localStringBuilder.toString());
    }
    return (this.b.flag.has()) && (this.b.flag.get() == 1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.GroupNetSearchModelPublicAcntItem
 * JD-Core Version:    0.7.0.1
 */