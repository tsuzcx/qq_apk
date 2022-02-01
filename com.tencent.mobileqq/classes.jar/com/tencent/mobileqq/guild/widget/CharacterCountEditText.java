package com.tencent.mobileqq.guild.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import androidx.annotation.RequiresApi;

@SuppressLint({"AppCompatCustomView"})
@RequiresApi(api=21)
public class CharacterCountEditText
  extends EditText
{
  private TextWatcher a;
  private int b = 2147483647;
  private CharacterCountEditText.ITextEditEventListener c;
  
  public CharacterCountEditText(Context paramContext)
  {
    this(paramContext, null, 16842862, 0);
  }
  
  public CharacterCountEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842862, 0);
  }
  
  public CharacterCountEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public CharacterCountEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a();
  }
  
  private void a()
  {
    setEditableFactory(new CharacterCountEditText.1(this));
    this.a = new CharacterCountEditText.2(this);
    addTextChangedListener(this.a);
  }
  
  public void setCountChangeListener(CharacterCountEditText.ITextEditEventListener paramITextEditEventListener)
  {
    this.c = paramITextEditEventListener;
  }
  
  public void setLimitCount(int paramInt)
  {
    this.b = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.widget.CharacterCountEditText
 * JD-Core Version:    0.7.0.1
 */