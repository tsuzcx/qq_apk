package com.tencent.mobileqq.kandian.biz.pts.view.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.biz.ui.CenteredImageSpan;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.repo.db.struct.AwesomeCommentInfo;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;

public class NativeAwesomeCommentView
  extends FrameLayout
  implements IView
{
  private static int jdField_a_of_type_Int = ((Integer)RIJSPUtils.a(AwesomeCommentInfo.i, Integer.valueOf(1))).intValue();
  ClickableSpan jdField_a_of_type_AndroidTextStyleClickableSpan = new NativeAwesomeCommentView.1(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AwesomeCommentInfo jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructAwesomeCommentInfo;
  private boolean jdField_a_of_type_Boolean = false;
  
  public NativeAwesomeCommentView(@NonNull Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public NativeAwesomeCommentView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public NativeAwesomeCommentView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  public static int a()
  {
    return jdField_a_of_type_Int;
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)inflate(getContext(), 2131560099, this).findViewById(2131379538));
  }
  
  public static void setMaxLines(int paramInt)
  {
    jdField_a_of_type_Int = paramInt;
  }
  
  public void comLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onComLayout(true, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int getComMeasuredHeight()
  {
    if (getVisibility() == 0) {
      return getMeasuredHeight();
    }
    return 0;
  }
  
  public int getComMeasuredWidth()
  {
    if (getVisibility() == 0) {
      return getMeasuredWidth();
    }
    return 0;
  }
  
  public void measureComponent(int paramInt1, int paramInt2)
  {
    onComMeasure(paramInt1, paramInt2);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  public void setAwesomeCommentInfo(AwesomeCommentInfo paramAwesomeCommentInfo)
  {
    if ((paramAwesomeCommentInfo != null) && (AwesomeCommentInfo.c != 1))
    {
      setVisibility(0);
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setAwesomeCommentInfo: ");
      ((StringBuilder)localObject1).append(paramAwesomeCommentInfo);
      QLog.d("ReadInJoyAwesomeCommentView", 2, ((StringBuilder)localObject1).toString());
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructAwesomeCommentInfo = paramAwesomeCommentInfo;
      Object localObject2 = paramAwesomeCommentInfo.jdField_b_of_type_JavaLangString;
      localObject1 = EmotionCodecUtils.b(paramAwesomeCommentInfo.d);
      Object localObject3 = EmotionCodecUtils.b(paramAwesomeCommentInfo.g);
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("  ");
      ((StringBuilder)localObject4).append((String)localObject1);
      ((StringBuilder)localObject4).append(": ");
      ((StringBuilder)localObject4).append((String)localObject3);
      localObject3 = new SpannableString(((StringBuilder)localObject4).toString());
      localObject4 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = getResources().getDrawable(2130842841);
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject2 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject4);
        ((URLDrawable)localObject2).setBounds(0, 0, paramAwesomeCommentInfo.jdField_a_of_type_Int * 2, paramAwesomeCommentInfo.jdField_b_of_type_Int * 2);
        ((URLDrawable)localObject2).setCallback(new NativeAwesomeCommentView.2(this, (SpannableString)localObject3));
        ((URLDrawable)localObject2).setDownloadListener(new NativeAwesomeCommentView.3(this, (SpannableString)localObject3));
        ((SpannableString)localObject3).setSpan(new CenteredImageSpan((Drawable)localObject2), 0, 1, 17);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        i = ((String)localObject1).length() + 1;
      } else {
        i = 1;
      }
      ((SpannableString)localObject3).setSpan(this.jdField_a_of_type_AndroidTextStyleClickableSpan, 2, i + 1, 17);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(new QQText((CharSequence)localObject3, 7, 16));
      int i = jdField_a_of_type_Int;
      if (i != 0) {
        this.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(i);
      } else {
        this.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2147483647);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new NativeAwesomeCommentView.4(this, paramAwesomeCommentInfo));
      return;
    }
    setVisibility(8);
    QLog.d("ReadInJoyAwesomeCommentView", 2, "awesomeComment is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeAwesomeCommentView
 * JD-Core Version:    0.7.0.1
 */