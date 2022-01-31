package com.tencent.mobileqq.widget;

import akuu;
import akuv;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.drawable.BitmapDrawableWithMargin;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MixedMsgLinearLayout
  extends LinearLayout
{
  private akuu jdField_a_of_type_Akuu = new akuu(this);
  private akuv jdField_a_of_type_Akuv = new akuv(this);
  private MotionEvent jdField_a_of_type_AndroidViewMotionEvent;
  public AnimationTextView.OnDoubleClick a;
  private MotionEvent b;
  public AnimationTextView.OnDoubleClick b;
  
  public MixedMsgLinearLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public MixedMsgLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private ChatThumbView a(MessageForPic paramMessageForPic)
  {
    int k = 99;
    ChatThumbView localChatThumbView = new ChatThumbView(getContext());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = BaseChatItemLayout.n;
    localLayoutParams.rightMargin = BaseChatItemLayout.o;
    localChatThumbView.setLayoutParams(localLayoutParams);
    localChatThumbView.setAdjustViewBounds(true);
    int m = URLDrawableHelper.a(false);
    int i = URLDrawableHelper.c(false);
    int j = URLDrawableHelper.d(false);
    localChatThumbView.setMaxHeight(m);
    localChatThumbView.setMaxWidth(m);
    m = paramMessageForPic.thumbWidth;
    int n = paramMessageForPic.thumbHeight;
    if ((m > 0) && (n > 0)) {
      if ((m < j) || (n < j)) {
        if (m < n)
        {
          k = (int)(j / m * n + 0.5F);
          if (k > i) {
            k = j;
          }
        }
      }
    }
    for (;;)
    {
      float f1 = getResources().getDisplayMetrics().densityDpi / 160.0F;
      j = (int)(k * f1 + 0.5F);
      i = (int)(i * f1 + 0.5F);
      if (!(URLDrawableHelper.b() instanceof SkinnableBitmapDrawable)) {
        break label530;
      }
      paramMessageForPic = ((SkinnableBitmapDrawable)URLDrawableHelper.b()).getBitmap();
      localChatThumbView.setImageDrawable(new BitmapDrawableWithMargin(getResources(), paramMessageForPic, j, i, -921103));
      return localChatThumbView;
      i = k;
      break;
      k = (int)(j / n * m + 0.5F);
      i = k;
      if (k > j) {
        i = j;
      }
      k = i;
      i = j;
      j = k;
      break;
      if ((m < i) && (n < i))
      {
        i = n;
        k = m;
      }
      else
      {
        label341:
        float f2;
        if (m > n)
        {
          f1 = i / m;
          if (m <= n) {
            break label412;
          }
          f2 = j / n;
          label356:
          Math.max(f1, f2);
          if (f1 >= f2) {
            break label430;
          }
          if (m <= n) {
            break label423;
          }
        }
        label412:
        label423:
        for (m = i;; m = j)
        {
          k = m;
          if (n > m) {
            break;
          }
          i = j;
          k = m;
          break;
          f1 = i / n;
          break label341;
          f2 = j / m;
          break label356;
        }
        label430:
        if (m > n) {}
        for (f1 = i / m;; f1 = i / n)
        {
          k = (int)(m * f1 + 0.5F);
          i = (int)(f1 * n + 0.5F);
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MixedMsgLinearLayout", 2, "MessageForPic without width/height of thumb, width = " + m + ", height = " + n);
        }
        i = 99;
      }
    }
    label530:
    if ((URLDrawableHelper.b() instanceof BitmapDrawable))
    {
      paramMessageForPic = ((BitmapDrawable)URLDrawableHelper.b()).getBitmap();
      localChatThumbView.setImageDrawable(new BitmapDrawableWithMargin(getResources(), paramMessageForPic, j, i, -921103));
      return localChatThumbView;
    }
    localChatThumbView.setImageDrawable(URLDrawableHelper.b());
    return localChatThumbView;
  }
  
  private AnimationTextView a()
  {
    AnimationTextView localAnimationTextView = new AnimationTextView(getContext());
    localAnimationTextView.setTextColor(getContext().getResources().getColorStateList(2131494227));
    localAnimationTextView.setLinkTextColor(getContext().getResources().getColorStateList(2131494224));
    localAnimationTextView.setSpannableFactory(QQText.a);
    localAnimationTextView.setMaxWidth(BaseChatItemLayout.e);
    localAnimationTextView.setMovementMethod(LinkMovementMethod.getInstance());
    localAnimationTextView.setPadding(BaseChatItemLayout.n, 0, BaseChatItemLayout.o, 0);
    localAnimationTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    localAnimationTextView.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick;
    return localAnimationTextView;
  }
  
  public void a(ColorStateList paramColorStateList1, ColorStateList paramColorStateList2)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = getChildAt(i);
      if ((localObject instanceof AnimationTextView))
      {
        localObject = (AnimationTextView)localObject;
        ((AnimationTextView)localObject).setTextColor(paramColorStateList1);
        ((AnimationTextView)localObject).setLinkTextColor(paramColorStateList2);
      }
      i += 1;
    }
  }
  
  public void a(List paramList)
  {
    int k = 0;
    Object localObject1 = new ArrayList();
    Object localObject2 = paramList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (MessageRecord)((Iterator)localObject2).next();
      if ((localObject3 instanceof MessageForText))
      {
        CharSequence localCharSequence = ((MessageForText)localObject3).sb;
        if ((localCharSequence != null) && (localCharSequence.toString().equals("\n"))) {
          ((ArrayList)localObject1).add(localObject3);
        }
      }
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramList.remove((MessageRecord)((Iterator)localObject1).next());
    }
    int j = getChildCount();
    Object localObject3 = new ArrayList();
    int i = 0;
    while (i < j)
    {
      localObject1 = getChildAt(i);
      if ((localObject1 instanceof AnimationTextView)) {
        ((ArrayList)localObject3).add(localObject1);
      }
      i += 1;
    }
    i = 0;
    while (i < ((ArrayList)localObject3).size())
    {
      localObject1 = (View)((ArrayList)localObject3).get(i);
      detachViewFromParent((View)localObject1);
      ((AnimationTextView)localObject1).setText("");
      this.jdField_a_of_type_Akuv.a((AnimationTextView)localObject1);
      i += 1;
    }
    j = paramList.size();
    i = 0;
    if (i < j)
    {
      localObject2 = paramList.get(i);
      if ((localObject2 instanceof MessageForReplyText))
      {
        localObject1 = new LinearLayout(getContext());
        ((LinearLayout)localObject1).setOrientation(1);
        ((LinearLayout)localObject1).addView(ReplyTextItemBuilder.a(getContext()));
        localObject2 = new ETTextView(getContext());
        ((ETTextView)localObject2).setTextColor(getContext().getResources().getColorStateList(2131494227));
        ((ETTextView)localObject2).setLinkTextColor(getContext().getResources().getColorStateList(2131494224));
        ((ETTextView)localObject2).setEditableFactory(QQTextBuilder.a);
        ((ETTextView)localObject2).setSpannableFactory(QQText.a);
        ((ETTextView)localObject2).setMaxWidth(BaseChatItemLayout.d);
        ((ETTextView)localObject2).setMovementMethod(LinkMovementMethod.getInstance());
        ((LinearLayout)localObject1).addView((View)localObject2);
        ((LinearLayout)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addViewInLayout((View)localObject1, i, ((LinearLayout)localObject1).getLayoutParams(), true);
      }
      label472:
      do
      {
        for (;;)
        {
          i += 1;
          break;
          if (!(localObject2 instanceof MessageForText)) {
            break label472;
          }
          localObject2 = this.jdField_a_of_type_Akuv.a();
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = a();
          }
          addViewInLayout((View)localObject1, i, ((AnimationTextView)localObject1).getLayoutParams(), true);
        }
      } while (!(localObject2 instanceof MessageForPic));
      localObject1 = this.jdField_a_of_type_Akuu.a();
      if (localObject1 != null) {
        break label635;
      }
      localObject1 = a((MessageForPic)localObject2);
    }
    label635:
    for (;;)
    {
      addViewInLayout((View)localObject1, i, ((ChatThumbView)localObject1).getLayoutParams(), true);
      break;
      ((ArrayList)localObject3).clear();
      int m = getChildCount();
      i = k;
      if (m > j) {
        for (;;)
        {
          i = k;
          if (j >= m) {
            break;
          }
          ((ArrayList)localObject3).add(getChildAt(j));
          j += 1;
        }
      }
      while (i < ((ArrayList)localObject3).size())
      {
        paramList = (View)((ArrayList)localObject3).get(i);
        detachViewFromParent(paramList);
        if ((paramList instanceof ChatThumbView))
        {
          ((ChatThumbView)paramList).setImageDrawable(null);
          ((ChatThumbView)paramList).setURLDrawableDownListener(null);
          this.jdField_a_of_type_Akuu.a((ChatThumbView)paramList);
        }
        i += 1;
      }
      return;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick != null) {
      if ((this.jdField_b_of_type_AndroidViewMotionEvent != null) && (paramMotionEvent.getAction() == 0))
      {
        this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
        if ((this.jdField_b_of_type_AndroidViewMotionEvent != null) && (this.jdField_a_of_type_AndroidViewMotionEvent != null) && (AnimationTextView.a(this.jdField_a_of_type_AndroidViewMotionEvent, this.jdField_b_of_type_AndroidViewMotionEvent, paramMotionEvent)))
        {
          this.jdField_a_of_type_AndroidViewMotionEvent = null;
          this.jdField_b_of_type_AndroidViewMotionEvent = null;
          if (this.jdField_b_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick != null)
          {
            this.jdField_b_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick.a(this);
            return true;
          }
        }
      }
      else if (paramMotionEvent.getAction() == 1)
      {
        this.jdField_b_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.widget.MixedMsgLinearLayout
 * JD-Core Version:    0.7.0.1
 */