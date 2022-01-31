package com.tencent.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import bhra;
import com.tencent.mobileqq.R.styleable;

public class AuthorizationItem
  extends LinearLayout
{
  public static final bhra a;
  public static final bhra b = new bhra("手机号", "key_authorize_phone", 1);
  public static final bhra c = new bhra("省市区", "key_authorize_place", 2);
  public static final bhra d = new bhra("", "", -1);
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private bhra e;
  
  static
  {
    jdField_a_of_type_Bhra = new bhra("昵称  ", "key_authorize_user_name", 0);
  }
  
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
  
  public AuthorizationItem(Context paramContext, String paramString, bhra parambhra, int paramInt)
  {
    super(paramContext);
    this.e = parambhra;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    a(paramContext, null);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    LayoutInflater.from(paramContext).inflate(2131560836, this, true);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.AuthorizationItem);
      this.jdField_a_of_type_Int = paramContext.getInteger(1, -1);
      this.e = bhra.a(paramContext.getInteger(2, -1));
      this.jdField_a_of_type_JavaLangString = paramContext.getString(0);
      paramContext.recycle();
    }
    setPositionType(this.jdField_a_of_type_Int);
    setItemType(this.e);
    setContent(this.jdField_a_of_type_JavaLangString);
  }
  
  public void setContent(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      ((TextView)findViewById(2131378796)).setText(paramString);
    }
  }
  
  public void setItemType(bhra parambhra)
  {
    ((TextView)findViewById(2131378798)).setText(parambhra.jdField_a_of_type_JavaLangString);
  }
  
  public void setPositionType(int paramInt)
  {
    if (paramInt == 0) {
      setBackgroundResource(2130844449);
    }
    do
    {
      return;
      if (paramInt == 1)
      {
        setBackgroundResource(2130844448);
        return;
      }
      if (paramInt == 2)
      {
        setBackgroundResource(2130844446);
        return;
      }
    } while (paramInt != 3);
    setBackgroundResource(2130844445);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.widget.AuthorizationItem
 * JD-Core Version:    0.7.0.1
 */