package com.tencent.timi.game.profile.impl.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.userinfo.api.IUserInfoService;
import com.tencent.timi.game.userinfo.api.view.IUserInfoView;
import com.tencent.timi.game.userinfo.api.view.UserInfoViewWrapper;
import trpc.yes.common.CommonOuterClass.QQUserId;

public class SexAtView
  extends TextView
  implements IUserInfoView
{
  private UserInfoViewWrapper a;
  private CommonOuterClass.QQUserId b;
  private String c = "@他";
  
  public SexAtView(Context paramContext)
  {
    super(paramContext);
    a(null);
  }
  
  public SexAtView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    this.a = ((IUserInfoService)ServiceCenter.a(IUserInfoService.class)).a(this);
  }
  
  private String b(IUserInfo paramIUserInfo)
  {
    if (paramIUserInfo != null)
    {
      paramIUserInfo = paramIUserInfo.d(this.b);
      if (paramIUserInfo == "男") {
        return "@他";
      }
      if (paramIUserInfo == "女") {
        return "@她";
      }
    }
    return this.c;
  }
  
  public void a(IUserInfo paramIUserInfo)
  {
    setText(b(paramIUserInfo));
  }
  
  public boolean a()
  {
    return getUserId() == 0L;
  }
  
  public void b()
  {
    setText(this.c);
  }
  
  public void c()
  {
    setText(this.c);
  }
  
  public void d()
  {
    c();
  }
  
  public long getUserId()
  {
    return this.a.a();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.a.c();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.a.d();
  }
  
  public void setUserId(CommonOuterClass.QQUserId paramQQUserId)
  {
    this.b = paramQQUserId;
    this.a.a(paramQQUserId.uid.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.profile.impl.view.SexAtView
 * JD-Core Version:    0.7.0.1
 */