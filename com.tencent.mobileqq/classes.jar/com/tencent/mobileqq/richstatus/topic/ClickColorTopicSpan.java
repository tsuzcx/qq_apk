package com.tencent.mobileqq.richstatus.topic;

import android.content.res.ColorStateList;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.profile.view.ClickPreventableTextView;
import com.tencent.mobileqq.text.ITopic;
import com.tencent.mobileqq.text.ITopic.OnTopicClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;

public class ClickColorTopicSpan
  extends ClickableSpan
  implements ITopic
{
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private ITopic.OnTopicClickListener jdField_a_of_type_ComTencentMobileqqTextITopic$OnTopicClickListener;
  private Object jdField_a_of_type_JavaLangObject;
  private boolean jdField_a_of_type_Boolean;
  private ColorStateList jdField_b_of_type_AndroidContentResColorStateList;
  private boolean jdField_b_of_type_Boolean;
  
  public ClickColorTopicSpan(ITopic.OnTopicClickListener paramOnTopicClickListener, ColorStateList paramColorStateList1, ColorStateList paramColorStateList2, Object paramObject)
  {
    this.jdField_a_of_type_ComTencentMobileqqTextITopic$OnTopicClickListener = paramOnTopicClickListener;
    this.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList1;
    this.jdField_b_of_type_AndroidContentResColorStateList = paramColorStateList2;
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public ClickColorTopicSpan(ITopic.OnTopicClickListener paramOnTopicClickListener, ColorStateList paramColorStateList, Object paramObject)
  {
    this(paramOnTopicClickListener, paramColorStateList, null, paramObject);
  }
  
  public Object getData()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView instanceof ClickPreventableTextView))
    {
      localObject = (ClickPreventableTextView)paramView;
      if (((ClickPreventableTextView)localObject).a()) {
        return;
      }
      ((ClickPreventableTextView)localObject).a();
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTextITopic$OnTopicClickListener;
    if (localObject != null) {
      ((ITopic.OnTopicClickListener)localObject).onClick(this, paramView);
    }
  }
  
  public void setCustomFont(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean != paramBoolean) {
      this.jdField_b_of_type_Boolean = paramBoolean;
    }
  }
  
  public void setPressed(View paramView, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ClickColorTopicSpan", 2, String.format("setPressed %b", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      paramView.invalidate();
    }
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    if ((localObject instanceof Pair))
    {
      localObject = (Pair)localObject;
      localStringBuilder.append("id=");
      localStringBuilder.append(((Pair)localObject).first);
      localStringBuilder.append(",");
      localStringBuilder.append("topic=");
      localStringBuilder.append((String)((Pair)localObject).second);
      localStringBuilder.append(",");
    }
    return localStringBuilder.toString();
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    paramTextPaint.setUnderlineText(false);
    ColorStateList localColorStateList = this.jdField_a_of_type_AndroidContentResColorStateList;
    int i;
    if (localColorStateList != null)
    {
      if (this.jdField_a_of_type_Boolean) {
        i = localColorStateList.getColorForState(new int[] { 16842919 }, 0);
      } else {
        i = localColorStateList.getColorForState(new int[0], 0);
      }
      paramTextPaint.setColor(i);
    }
    else
    {
      paramTextPaint.setColor(-16777216);
    }
    localColorStateList = this.jdField_b_of_type_AndroidContentResColorStateList;
    if (localColorStateList != null)
    {
      if (this.jdField_a_of_type_Boolean) {
        i = localColorStateList.getColorForState(new int[] { 16842919 }, 0);
      } else {
        i = localColorStateList.getColorForState(new int[0], 0);
      }
      paramTextPaint.bgColor = i;
      return;
    }
    paramTextPaint.bgColor = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.topic.ClickColorTopicSpan
 * JD-Core Version:    0.7.0.1
 */