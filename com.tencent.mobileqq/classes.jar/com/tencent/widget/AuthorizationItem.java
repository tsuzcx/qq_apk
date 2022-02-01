package com.tencent.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.ad.api.R.styleable;

public class AuthorizationItem
  extends LinearLayout
{
  public static final AuthorizationItem.ItemType a = new AuthorizationItem.ItemType("昵称  ", "key_authorize_user_name", 0);
  public static final AuthorizationItem.ItemType b = new AuthorizationItem.ItemType("手机号", "key_authorize_phone", 1);
  public static final AuthorizationItem.ItemType c = new AuthorizationItem.ItemType("省市区", "key_authorize_place", 2);
  public static final AuthorizationItem.ItemType d = new AuthorizationItem.ItemType("", "", -1);
  private int e;
  private AuthorizationItem.ItemType f;
  private String g;
  
  public AuthorizationItem(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public AuthorizationItem(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  public AuthorizationItem(Context paramContext, String paramString, AuthorizationItem.ItemType paramItemType, int paramInt)
  {
    super(paramContext);
    this.f = paramItemType;
    this.e = paramInt;
    this.g = paramString;
    a(paramContext, null);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    LayoutInflater.from(paramContext).inflate(2131627320, this, true);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.s);
      this.e = paramContext.getInteger(R.styleable.t, -1);
      this.f = AuthorizationItem.ItemType.a(paramContext.getInteger(R.styleable.v, -1));
      this.g = paramContext.getString(R.styleable.u);
      paramContext.recycle();
    }
    setPositionType(this.e);
    setItemType(this.f);
    setContent(this.g);
  }
  
  public void setContent(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      ((TextView)findViewById(2131448543)).setText(paramString);
    }
  }
  
  public void setItemType(AuthorizationItem.ItemType paramItemType)
  {
    ((TextView)findViewById(2131448545)).setText(paramItemType.a);
  }
  
  public void setPositionType(int paramInt)
  {
    if (paramInt == 0)
    {
      setBackgroundResource(2130846354);
      return;
    }
    if (paramInt == 1)
    {
      setBackgroundResource(2130846353);
      return;
    }
    if (paramInt == 2)
    {
      setBackgroundResource(2130846351);
      return;
    }
    if (paramInt == 3) {
      setBackgroundResource(2130846350);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.AuthorizationItem
 * JD-Core Version:    0.7.0.1
 */