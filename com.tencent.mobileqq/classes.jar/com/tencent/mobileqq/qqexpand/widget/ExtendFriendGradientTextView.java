package com.tencent.mobileqq.qqexpand.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.util.AttributeSet;
import com.etrump.mixlayout.ETLayout;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.qqexpand.profilecard.ProfileCardExtendFriendView;

public class ExtendFriendGradientTextView
  extends ETTextView
{
  public String a = null;
  public String b = null;
  public boolean c = false;
  int d = 10;
  ProfileCardExtendFriendView e;
  int f = 0;
  boolean g = true;
  
  public ExtendFriendGradientTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ExtendFriendGradientTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ExtendFriendGradientTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((getETLayout() != null) && (getETLayout().a() > this.d) && (getETLayout().d(0) != null))
    {
      this.f = (this.d * getETLayout().d(0).length);
      setShowMoreButton(true);
      return;
    }
    if ((getLayout() != null) && (getLayout().getLineCount() > this.d))
    {
      this.f = getLayout().getLineStart(this.d);
      setShowMoreButton(true);
    }
  }
  
  public void setCardView(ProfileCardExtendFriendView paramProfileCardExtendFriendView)
  {
    this.e = paramProfileCardExtendFriendView;
  }
  
  public void setContent(String paramString)
  {
    String str = this.a;
    if (str == null) {
      str = "";
    }
    this.a = str;
    if ((paramString != null) && (!this.a.equals(paramString)))
    {
      this.a = paramString;
      str = this.b;
      if ((str != null) && (this.g))
      {
        setETContent(str);
        return;
      }
      setETContent(paramString);
    }
  }
  
  public void setETContent(String paramString)
  {
    super.setTextMsg(paramString);
    setTextSize(1, 16.0F);
  }
  
  public void setFold(boolean paramBoolean)
  {
    this.g = paramBoolean;
    if (paramBoolean)
    {
      String str2 = this.b;
      String str1 = str2;
      if (str2 == null) {
        str1 = this.a;
      }
      setETContent(str1);
      return;
    }
    setETContent(this.a);
  }
  
  public void setShowMoreButton(boolean paramBoolean)
  {
    if (paramBoolean != this.c)
    {
      this.c = paramBoolean;
      this.b = this.a.substring(0, this.f);
      this.e.a(paramBoolean);
      setETContent(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.ExtendFriendGradientTextView
 * JD-Core Version:    0.7.0.1
 */