package com.tencent.mobileqq.troop.navigatebar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.SparseArray;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.guild.temp.api.GuildManagerProvider;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.URLThemeImageView;
import java.util.List;

public class NavigateBarDelegateFactory
  implements INavigateBar
{
  final String a = "NavigateBarDelegateFactory";
  private final QQAppInterface b;
  private final Context c;
  private final BaseSessionInfo d;
  private final BaseAioMsgNavigateBar e;
  private SparseArray<BaseAioMsgNavigateBarDelegate> f;
  
  public NavigateBarDelegateFactory(QQAppInterface paramQQAppInterface, Context paramContext, BaseAioMsgNavigateBar paramBaseAioMsgNavigateBar, BaseSessionInfo paramBaseSessionInfo)
  {
    this.b = paramQQAppInterface;
    this.c = paramContext;
    this.e = paramBaseAioMsgNavigateBar;
    this.d = paramBaseSessionInfo;
    a();
  }
  
  public int a(int paramInt)
  {
    if (this.f.get(paramInt) != null) {
      return ((BaseAioMsgNavigateBarDelegate)this.f.get(paramInt)).a(paramInt);
    }
    return 0;
  }
  
  @Nullable
  public BaseAioMsgNavigateBarDelegate.Entity a(int paramInt1, List<Long> paramList, long paramLong1, Object paramObject, long paramLong2, long paramLong3, int paramInt2)
  {
    if (this.f.get(paramInt1) != null) {
      return ((BaseAioMsgNavigateBarDelegate)this.f.get(paramInt1)).a(paramInt1, paramList, paramLong1, paramObject, paramLong2, paramLong3, paramInt2);
    }
    return null;
  }
  
  public void a()
  {
    this.f = new SparseArray();
    Object localObject;
    if (GuildManagerProvider.a(this.e))
    {
      localObject = (BaseAioMsgNavigateBarDelegate)GuildManagerProvider.a(this.b, this.c, this.d);
      this.f.put(((BaseAioMsgNavigateBarDelegate)localObject).c(), localObject);
      localObject = (BaseAioMsgNavigateBarDelegate)GuildManagerProvider.b(this.b, this.c, this.d);
      this.f.put(((BaseAioMsgNavigateBarDelegate)localObject).c(), localObject);
      localObject = (BaseAioMsgNavigateBarDelegate)GuildManagerProvider.c(this.b, this.c, this.d);
      this.f.put(((BaseAioMsgNavigateBarDelegate)localObject).c(), localObject);
    }
    else
    {
      localObject = new TroopAioMsgNavigateArk(this.b, this.c, this.d);
      this.f.put(((BaseAioMsgNavigateBarDelegate)localObject).c(), localObject);
      localObject = new TroopAioMsgNavigateAtAll(this.b, this.c, this.d);
      this.f.put(((BaseAioMsgNavigateBarDelegate)localObject).c(), localObject);
      localObject = new TroopAioMsgNavigateAtMe(this.b, this.c, this.d);
      this.f.put(((BaseAioMsgNavigateBarDelegate)localObject).c(), localObject);
      localObject = new TroopAioMsgNavigateCalendar(this.b, this.c, this.d);
      this.f.put(((BaseAioMsgNavigateBarDelegate)localObject).c(), localObject);
      localObject = new TroopAioMsgNavigateConfessToMe(this.b, this.c, this.d);
      this.f.put(((BaseAioMsgNavigateBarDelegate)localObject).c(), localObject);
      localObject = new TroopAioMsgNavigateDingDongAtMe(this.b, this.c, this.d);
      this.f.put(((BaseAioMsgNavigateBarDelegate)localObject).c(), localObject);
      localObject = new TroopAioMsgNavigateEffectPic(this.b, this.c, this.d);
      this.f.put(((BaseAioMsgNavigateBarDelegate)localObject).c(), localObject);
      localObject = new TroopAioMsgNavigateFlowers(this.b, this.c, this.d);
      this.f.put(((BaseAioMsgNavigateBarDelegate)localObject).c(), localObject);
      localObject = new TroopAioMsgNavigateFocusWord(this.b, this.c, this.d);
      this.f.put(((BaseAioMsgNavigateBarDelegate)localObject).c(), localObject);
      localObject = new TroopAioMsgNavigateGameParty(this.b, this.c, this.d);
      this.f.put(((BaseAioMsgNavigateBarDelegate)localObject).c(), localObject);
      localObject = new TroopAioMsgNavigateHomeWork(this.b, this.c, this.d);
      this.f.put(((BaseAioMsgNavigateBarDelegate)localObject).c(), localObject);
      localObject = new TroopAioMsgNavigateHomeworkPraise(this.b, this.c, this.d);
      this.f.put(((BaseAioMsgNavigateBarDelegate)localObject).c(), localObject);
      localObject = new TroopAioMsgNavigateNewAblum(this.b, this.c, this.d);
      this.f.put(((BaseAioMsgNavigateBarDelegate)localObject).c(), localObject);
      localObject = new TroopAioMsgNavigateNewFile(this.b, this.c, this.d);
      this.f.put(((BaseAioMsgNavigateBarDelegate)localObject).c(), localObject);
      localObject = new TroopAioMsgNavigateReceipt(this.b, this.c, this.d);
      this.f.put(((BaseAioMsgNavigateBarDelegate)localObject).c(), localObject);
      localObject = new TroopAioMsgNavigateReply(this.b, this.c, this.d);
      this.f.put(((BaseAioMsgNavigateBarDelegate)localObject).c(), localObject);
      localObject = new TroopAioMsgNavigateShopArk(this.b, this.c, this.d);
      this.f.put(((BaseAioMsgNavigateBarDelegate)localObject).c(), localObject);
      localObject = new TroopAioMsgNavigateSpecial(this.b, this.c, this.d);
      this.f.put(((BaseAioMsgNavigateBarDelegate)localObject).c(), localObject);
      localObject = new TroopAioMsgNavigateSticker(this.b, this.c, this.d);
      this.f.put(((BaseAioMsgNavigateBarDelegate)localObject).c(), localObject);
      localObject = new TroopAioMsgNavigateUnRead(this.b, this.c, (TroopAioMsgNavigateBar)this.e, this.d);
      this.f.put(((BaseAioMsgNavigateBarDelegate)localObject).c(), localObject);
      localObject = new TroopAioMsgNavigateNotification(this.b, this.c, (TroopAioMsgNavigateBar)this.e, this.d);
      this.f.put(((BaseAioMsgNavigateBarDelegate)localObject).c(), localObject);
    }
    int i = 0;
    while (i < this.f.size())
    {
      ((BaseAioMsgNavigateBarDelegate)this.f.valueAt(i)).a();
      i += 1;
    }
  }
  
  public void a(int paramInt, TextView paramTextView1, TextView paramTextView2, ImageView paramImageView, String paramString)
  {
    if (this.f.get(paramInt) != null) {
      ((BaseAioMsgNavigateBarDelegate)this.f.get(paramInt)).a(paramInt, paramTextView1, paramTextView2, paramImageView, paramString);
    }
  }
  
  public void a(int paramInt1, AioAgent.Message paramMessage, String paramString, int paramInt2, TextView paramTextView1, TextView paramTextView2, long paramLong)
  {
    if (this.f.get(paramInt1) != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onClickMultiNavBar ");
        localStringBuilder.append(this.f.get(paramInt1));
        QLog.d("NavigateBarDelegateFactory", 2, localStringBuilder.toString());
      }
      ((BaseAioMsgNavigateBarDelegate)this.f.get(paramInt1)).a(paramInt1, paramMessage, paramString, paramInt2, paramTextView1, paramTextView2, paramLong);
    }
  }
  
  public void a(int paramInt, Object paramObject, String paramString)
  {
    if (this.f.get(paramInt) != null) {
      ((BaseAioMsgNavigateBarDelegate)this.f.get(paramInt)).a(paramInt, paramObject, paramString);
    }
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (this.f.get(paramInt1) != null) {
      return ((BaseAioMsgNavigateBarDelegate)this.f.get(paramInt1)).a(paramInt1, paramInt2);
    }
    return false;
  }
  
  public boolean a(int paramInt, URLThemeImageView paramURLThemeImageView, String paramString)
  {
    paramInt = a(paramInt);
    if (paramInt != 0)
    {
      paramURLThemeImageView.setImageDrawable(null);
      paramURLThemeImageView.setImageResource(paramInt);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    int i = 0;
    while (i < this.f.size())
    {
      ((BaseAioMsgNavigateBarDelegate)this.f.valueAt(i)).b();
      i += 1;
    }
    this.f.clear();
  }
  
  public void b(int paramInt, Object paramObject, String paramString)
  {
    if (this.f.get(paramInt) != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onClick ");
        localStringBuilder.append(this.f.get(paramInt));
        QLog.d("NavigateBarDelegateFactory", 2, localStringBuilder.toString());
      }
      ((BaseAioMsgNavigateBarDelegate)this.f.get(paramInt)).b(paramInt, paramObject, paramString);
    }
  }
  
  public boolean b(int paramInt)
  {
    if (this.f.get(paramInt) != null) {
      return ((BaseAioMsgNavigateBarDelegate)this.f.get(paramInt)).b(paramInt);
    }
    return paramInt == 103;
  }
  
  public BaseAioMsgNavigateBarDelegate c(int paramInt)
  {
    if (this.f.get(paramInt) != null) {
      return ((BaseAioMsgNavigateBarDelegate)this.f.get(paramInt)).c(paramInt);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.navigatebar.NavigateBarDelegateFactory
 * JD-Core Version:    0.7.0.1
 */