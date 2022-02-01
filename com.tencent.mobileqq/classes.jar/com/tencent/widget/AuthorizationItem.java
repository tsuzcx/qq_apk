package com.tencent.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import blaf;
import com.tencent.mobileqq.R.styleable;

public class AuthorizationItem
  extends LinearLayout
{
  public static final blaf a;
  public static final blaf b = new blaf("手机号", "key_authorize_phone", 1);
  public static final blaf c = new blaf("省市区", "key_authorize_place", 2);
  public static final blaf d = new blaf("", "", -1);
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private blaf e;
  
  static
  {
    jdField_a_of_type_Blaf = new blaf("昵称  ", "key_authorize_user_name", 0);
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
  
  public AuthorizationItem(Context paramContext, String paramString, blaf paramblaf, int paramInt)
  {
    super(paramContext);
    this.e = paramblaf;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    a(paramContext, null);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    LayoutInflater.from(paramContext).inflate(2131561029, this, true);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.AuthorizationItem);
      this.jdField_a_of_type_Int = paramContext.getInteger(1, -1);
      this.e = blaf.a(paramContext.getInteger(2, -1));
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
      ((TextView)findViewById(2131379994)).setText(paramString);
    }
  }
  
  public void setItemType(blaf paramblaf)
  {
    ((TextView)findViewById(2131379996)).setText(paramblaf.jdField_a_of_type_JavaLangString);
  }
  
  public void setPositionType(int paramInt)
  {
    if (paramInt == 0) {
      setBackgroundResource(2130844883);
    }
    do
    {
      return;
      if (paramInt == 1)
      {
        setBackgroundResource(2130844882);
        return;
      }
      if (paramInt == 2)
      {
        setBackgroundResource(2130844880);
        return;
      }
    } while (paramInt != 3);
    setBackgroundResource(2130844879);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.widget.AuthorizationItem
 * JD-Core Version:    0.7.0.1
 */