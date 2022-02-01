package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.activity.aio.item.MixedMsgItemBuilder.MixedHolder;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder;
import com.tencent.mobileqq.activity.selectable.SelectableComponent;
import com.tencent.mobileqq.activity.selectable.SelectableDelegate;
import com.tencent.mobileqq.activity.selectable.SelectableLinearLayout;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.drawable.BitmapDrawableWithMargin;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.transfile.CommonImgThumbHelper;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MixedMsgLinearLayout
  extends LinearLayout
  implements SelectableComponent
{
  private int jdField_a_of_type_Int;
  private MotionEvent jdField_a_of_type_AndroidViewMotionEvent;
  private SelectableComponent jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent;
  private SelectableDelegate jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate;
  public AnimationTextView.OnDoubleClick a;
  private MixedMsgLinearLayout.ImageScrapHeap jdField_a_of_type_ComTencentMobileqqWidgetMixedMsgLinearLayout$ImageScrapHeap = new MixedMsgLinearLayout.ImageScrapHeap(this);
  private MixedMsgLinearLayout.TextViewScrapHeap jdField_a_of_type_ComTencentMobileqqWidgetMixedMsgLinearLayout$TextViewScrapHeap = new MixedMsgLinearLayout.TextViewScrapHeap(this);
  private boolean jdField_a_of_type_Boolean = false;
  private final int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private int jdField_b_of_type_Int;
  private MotionEvent jdField_b_of_type_AndroidViewMotionEvent;
  public AnimationTextView.OnDoubleClick b;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = -5250572;
  private boolean jdField_c_of_type_Boolean = true;
  
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
    ChatThumbView localChatThumbView = new ChatThumbView(getContext());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = 0;
    localLayoutParams.rightMargin = 0;
    localChatThumbView.setLayoutParams(localLayoutParams);
    localChatThumbView.setAdjustViewBounds(true);
    int k = CommonImgThumbHelper.getImgThumbMaxPx(false);
    int j = CommonImgThumbHelper.getImgThumbMaxDp(false);
    int i = CommonImgThumbHelper.getImgThumbMinDp(false);
    localChatThumbView.setMaxHeight(k);
    localChatThumbView.setMaxWidth(k);
    k = paramMessageForPic.thumbWidth;
    int n = paramMessageForPic.thumbHeight;
    if ((k > 0) && (n > 0))
    {
      float f2;
      if ((k >= i) && (n >= i))
      {
        if ((k < j) && (n < j))
        {
          i = k;
          j = n;
          break label474;
        }
        if (k > n)
        {
          f1 = j;
          f2 = k;
        }
        else
        {
          f1 = j;
          f2 = n;
        }
        float f3 = f1 / f2;
        if (k > n)
        {
          f1 = i;
          f2 = n;
        }
        else
        {
          f1 = i;
          f2 = k;
        }
        f1 /= f2;
        Math.max(f3, f1);
        if (f3 < f1)
        {
          if (k > n) {
            k = j;
          } else {
            k = i;
          }
          m = k;
          if (n > k) {
            i = j;
          }
        }
      }
      for (int m = k;; m = j)
      {
        j = i;
        i = m;
        break;
        if (k > n)
        {
          f1 = j;
          f2 = k;
        }
        else
        {
          f1 = j;
          f2 = n;
        }
        f1 /= f2;
        i = (int)(k * f1 + 0.5F);
        j = (int)(n * f1 + 0.5F);
        break;
        if (k < n)
        {
          f1 = i / k;
          m = (int)(n * f1 + 0.5F);
          k = m;
          if (m > j) {
            k = j;
          }
          j = k;
          break;
        }
        f1 = i / n;
        k = (int)(k * f1 + 0.5F);
        j = k;
        if (k > i) {
          j = i;
        }
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        paramMessageForPic = new StringBuilder();
        paramMessageForPic.append("MessageForPic without width/height of thumb, width = ");
        paramMessageForPic.append(k);
        paramMessageForPic.append(", height = ");
        paramMessageForPic.append(n);
        QLog.d("MixedMsgLinearLayout", 2, paramMessageForPic.toString());
      }
      j = 99;
      i = 99;
    }
    label474:
    float f1 = getResources().getDisplayMetrics().densityDpi / 160.0F;
    i = (int)(i * f1 + 0.5F);
    j = (int)(j * f1 + 0.5F);
    if ((URLDrawableHelper.getLoadingDrawable() instanceof SkinnableBitmapDrawable))
    {
      paramMessageForPic = ((SkinnableBitmapDrawable)URLDrawableHelper.getLoadingDrawable()).getBitmap();
      localChatThumbView.setImageDrawable(new BitmapDrawableWithMargin(getResources(), paramMessageForPic, i, j, -921103));
      return localChatThumbView;
    }
    if ((URLDrawableHelper.getLoadingDrawable() instanceof BitmapDrawable))
    {
      paramMessageForPic = ((BitmapDrawable)URLDrawableHelper.getLoadingDrawable()).getBitmap();
      localChatThumbView.setImageDrawable(new BitmapDrawableWithMargin(getResources(), paramMessageForPic, i, j, -921103));
      return localChatThumbView;
    }
    localChatThumbView.setImageDrawable(URLDrawableHelper.getLoadingDrawable());
    return localChatThumbView;
  }
  
  private AnimationTextView a()
  {
    AnimationTextView localAnimationTextView = new AnimationTextView(getContext());
    localAnimationTextView.setTextColor(getContext().getResources().getColorStateList(2131167075));
    localAnimationTextView.setLinkTextColor(getContext().getResources().getColorStateList(2131167068));
    localAnimationTextView.setSpannableFactory(QQText.SPANNABLE_FACTORY);
    localAnimationTextView.setMaxWidth(BaseChatItemLayout.f);
    localAnimationTextView.setMovementMethod(LinkMovementMethod.getInstance());
    localAnimationTextView.setPadding(0, 0, 0, 0);
    localAnimationTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    localAnimationTextView.onDoubleClick = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick;
    return localAnimationTextView;
  }
  
  private boolean a(MessageRecord paramMessageRecord)
  {
    boolean bool3 = paramMessageRecord instanceof MessageForText;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramMessageRecord = ((MessageForText)paramMessageRecord).sb;
      bool1 = bool2;
      if (paramMessageRecord != null)
      {
        bool1 = bool2;
        if (paramMessageRecord.toString().equals("\n")) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public CharSequence a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i3 = getChildCount();
    int i2 = this.jdField_a_of_type_Int;
    int n = this.jdField_b_of_type_Int;
    int m = 0;
    int j = 0;
    while (m < i3)
    {
      Object localObject = getChildAt(m);
      int i1;
      int i;
      int k;
      if ((localObject instanceof SelectableComponent))
      {
        localObject = (SelectableComponent)localObject;
        i1 = j;
        i = i2;
        k = n;
        if (j == 0)
        {
          int i4 = ((SelectableComponent)localObject).contentLength();
          if (i2 >= i4)
          {
            i = i2 - i4;
            k = n - i4;
            i1 = j;
          }
          else
          {
            if (n <= i4) {
              j = 1;
            }
            localObject = ((SelectableComponent)localObject).selectContent();
            if (localObject != null) {
              localStringBuilder.append((CharSequence)localObject);
            }
            i1 = j;
            i = i2;
            k = n;
            if (j == 0)
            {
              k = n - i4;
              i = 0;
              i1 = j;
            }
          }
        }
      }
      else
      {
        i1 = j;
        i = i2;
        k = n;
        if (m != 0)
        {
          localStringBuilder.append(" ");
          k = n;
          i = i2;
          i1 = j;
        }
      }
      m += 1;
      j = i1;
      i2 = i;
      n = k;
    }
    return localStringBuilder.toString();
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
  
  public void a(Typeface paramTypeface)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if ((localView instanceof TextView)) {
        ((TextView)localView).setTypeface(paramTypeface);
      }
      i += 1;
    }
  }
  
  public void a(List<MessageRecord> paramList, MixedMsgItemBuilder.MixedHolder paramMixedHolder)
  {
    Object localObject1 = new ArrayList();
    int k = 0;
    int i = 0;
    while (i < paramList.size())
    {
      if (a((MessageRecord)paramList.get(i))) {
        ((List)localObject1).add(paramList.get(i));
      }
      i += 1;
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramList.remove((MessageRecord)((Iterator)localObject1).next());
    }
    int j = getChildCount();
    ArrayList localArrayList = new ArrayList();
    i = 0;
    while (i < j)
    {
      localObject1 = getChildAt(i);
      if ((localObject1 instanceof AnimationTextView)) {
        localArrayList.add(localObject1);
      }
      i += 1;
    }
    i = 0;
    while (i < localArrayList.size())
    {
      localObject1 = (View)localArrayList.get(i);
      detachViewFromParent((View)localObject1);
      localObject1 = (AnimationTextView)localObject1;
      ((AnimationTextView)localObject1).setText("");
      this.jdField_a_of_type_ComTencentMobileqqWidgetMixedMsgLinearLayout$TextViewScrapHeap.a((AnimationTextView)localObject1);
      i += 1;
    }
    j = paramList.size();
    i = 0;
    while (i < j)
    {
      Object localObject3 = paramList.get(i);
      Object localObject2;
      if ((localObject3 instanceof MessageForReplyText))
      {
        localObject1 = new SelectableLinearLayout(getContext());
        ((LinearLayout)localObject1).setOrientation(1);
        localObject2 = ReplyTextItemBuilder.a(getContext());
        paramMixedHolder.e = i;
        paramMixedHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((ViewGroup)localObject2).findViewById(2131371697));
        paramMixedHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((ViewGroup)localObject2).findViewById(2131378696));
        paramMixedHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((ViewGroup)localObject2).findViewById(2131371529));
        paramMixedHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((ViewGroup)localObject2).findViewById(2131371543));
        ((LinearLayout)localObject1).addView((View)localObject2);
        localObject2 = new ETTextView(getContext());
        ((ETTextView)localObject2).setTextColor(getContext().getResources().getColorStateList(2131167075));
        ((ETTextView)localObject2).setLinkTextColor(getContext().getResources().getColorStateList(2131167068));
        ((ETTextView)localObject2).setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
        ((ETTextView)localObject2).setSpannableFactory(QQText.SPANNABLE_FACTORY);
        ((ETTextView)localObject2).setMaxWidth(BaseChatItemLayout.e);
        ((ETTextView)localObject2).setMovementMethod(LinkMovementMethod.getInstance());
        ((LinearLayout)localObject1).addView((View)localObject2);
        ((LinearLayout)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addViewInLayout((View)localObject1, i, ((LinearLayout)localObject1).getLayoutParams(), true);
        paramMixedHolder.c = ((TextView)localObject2);
      }
      else if ((localObject3 instanceof MessageForText))
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetMixedMsgLinearLayout$TextViewScrapHeap.a();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = a();
        }
        addViewInLayout((View)localObject1, i, ((AnimationTextView)localObject1).getLayoutParams(), true);
      }
      else if ((localObject3 instanceof MessageForPic))
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetMixedMsgLinearLayout$ImageScrapHeap.a();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = a((MessageForPic)localObject3);
        }
        addViewInLayout((View)localObject1, i, ((ChatThumbView)localObject1).getLayoutParams(), true);
      }
      i += 1;
    }
    localArrayList.clear();
    int m = getChildCount();
    i = k;
    if (m > j) {
      for (;;)
      {
        i = k;
        if (j >= m) {
          break;
        }
        localArrayList.add(getChildAt(j));
        j += 1;
      }
    }
    while (i < localArrayList.size())
    {
      paramList = (View)localArrayList.get(i);
      detachViewFromParent(paramList);
      if ((paramList instanceof ChatThumbView))
      {
        paramList = (ChatThumbView)paramList;
        paramList.setImageDrawable(null);
        paramList.setURLDrawableDownListener(null);
        this.jdField_a_of_type_ComTencentMobileqqWidgetMixedMsgLinearLayout$ImageScrapHeap.a(paramList);
      }
      i += 1;
    }
  }
  
  public void bind(@Nullable SelectableDelegate paramSelectableDelegate)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate = paramSelectableDelegate;
  }
  
  public void clearHighlightContent()
  {
    int i = 0;
    this.jdField_a_of_type_Boolean = false;
    int j = getChildCount();
    while (i < j)
    {
      View localView = getChildAt(i);
      if ((localView instanceof SelectableComponent)) {
        ((SelectableComponent)localView).clearHighlightContent();
      }
      i += 1;
    }
  }
  
  @Nullable
  public CharSequence content()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if ((localView instanceof SelectableComponent)) {
        localStringBuilder.append(((SelectableComponent)localView).content());
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public int contentLength()
  {
    int m = getChildCount();
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      View localView = getChildAt(i);
      k = j;
      if ((localView instanceof SelectableComponent)) {
        k = j + ((SelectableComponent)localView).contentLength();
      }
      i += 1;
    }
    return j;
  }
  
  @Nullable
  public SelectableDelegate delegate()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate;
  }
  
  public void doSelecting(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MixedMsgLinearLayout", 2, "doSelecting msg = null.");
      }
      return;
    }
    SelectableDelegate localSelectableDelegate = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate;
    if (localSelectableDelegate != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent = null;
      localSelectableDelegate.a(paramChatMessage);
      ReportController.b(null, "dc00898", "", "", "0X800AE7A", "0X800AE7A", 2, 0, "", "", "", "");
      return;
    }
    throw new IllegalStateException("Has no bound delegate!");
  }
  
  public boolean hasSelected()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean hasTouchSelectableArea(int paramInt1, int paramInt2)
  {
    getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
    Object localObject = this.jdField_a_of_type_ArrayOfInt;
    int i = paramInt1 - localObject[0];
    paramInt2 = paramInt2 - localObject[1] - getPaddingTop();
    int j = getChildCount();
    paramInt1 = 0;
    while (paramInt1 < j)
    {
      localObject = getChildAt(paramInt1);
      if ((localObject instanceof SelectableComponent))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MixedMsgLinearLayout", 2, new Object[] { "left=", Integer.valueOf(((View)localObject).getLeft()), " right=", Integer.valueOf(((View)localObject).getRight()), " top=", Integer.valueOf(((View)localObject).getTop()), " bottom=", Integer.valueOf(((View)localObject).getBottom()), " relativeX=", Integer.valueOf(i), " relativeY=", Integer.valueOf(paramInt2) });
        }
        if ((i > ((View)localObject).getLeft()) && (i < ((View)localObject).getRight()) && (paramInt2 > ((View)localObject).getTop()) && (paramInt2 < ((View)localObject).getBottom())) {
          return true;
        }
      }
      paramInt1 += 1;
    }
    return false;
  }
  
  public void highlightBackgroundColor(@ColorInt int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void highlightContent()
  {
    if (!hasSelected())
    {
      clearHighlightContent();
      return;
    }
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = getChildAt(i);
      if ((localObject instanceof SelectableComponent))
      {
        localObject = (SelectableComponent)localObject;
        if (((SelectableComponent)localObject).hasSelected())
        {
          ((SelectableComponent)localObject).highlightBackgroundColor(this.jdField_c_of_type_Int);
          ((SelectableComponent)localObject).highlightContent();
        }
        else
        {
          ((SelectableComponent)localObject).clearHighlightContent();
        }
      }
      i += 1;
    }
  }
  
  public void locationByIndex(int paramInt, @NonNull int[] paramArrayOfInt, boolean paramBoolean)
  {
    int k = getChildCount();
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < k)
    {
      Object localObject = getChildAt(paramInt);
      j = i;
      if ((localObject instanceof SelectableComponent))
      {
        localObject = (SelectableComponent)localObject;
        j = ((SelectableComponent)localObject).contentLength();
        if (i > j)
        {
          j = i - j;
        }
        else
        {
          ((SelectableComponent)localObject).locationByIndex(i, paramArrayOfInt, paramBoolean);
          return;
        }
      }
      paramInt += 1;
      i = j;
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
        Object localObject = this.jdField_b_of_type_AndroidViewMotionEvent;
        if (localObject != null)
        {
          MotionEvent localMotionEvent = this.jdField_a_of_type_AndroidViewMotionEvent;
          if ((localMotionEvent != null) && (AnimationTextView.isConsideredDoubleTap(localMotionEvent, (MotionEvent)localObject, paramMotionEvent)))
          {
            this.jdField_a_of_type_AndroidViewMotionEvent = null;
            this.jdField_b_of_type_AndroidViewMotionEvent = null;
            localObject = this.jdField_b_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick;
            if (localObject != null)
            {
              ((AnimationTextView.OnDoubleClick)localObject).a(this);
              return true;
            }
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
  
  @Nullable
  public CharSequence selectContent()
  {
    CharSequence localCharSequence = content();
    if (localCharSequence != null) {
      return localCharSequence.subSequence(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    }
    return null;
  }
  
  public void selectContent(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != -1) && (paramInt2 != -1))
    {
      if (paramInt1 > paramInt2)
      {
        this.jdField_a_of_type_Int = paramInt2;
        this.jdField_b_of_type_Int = paramInt1;
      }
      else
      {
        this.jdField_a_of_type_Int = paramInt1;
        this.jdField_b_of_type_Int = paramInt2;
      }
      if (this.jdField_b_of_type_Int - this.jdField_a_of_type_Int > 0) {
        this.jdField_b_of_type_Boolean = true;
      }
    }
    else
    {
      this.jdField_a_of_type_Int = -1;
      this.jdField_b_of_type_Int = -1;
      this.jdField_b_of_type_Boolean = false;
    }
    int i = this.jdField_a_of_type_Int;
    paramInt1 = this.jdField_b_of_type_Int;
    int i1 = getChildCount();
    int m = 0;
    int j;
    for (paramInt2 = 0; m < i1; paramInt2 = j)
    {
      View localView = getChildAt(m);
      int n = i;
      int k = paramInt1;
      j = paramInt2;
      if ((localView instanceof SelectableComponent))
      {
        SelectableComponent localSelectableComponent = (SelectableComponent)localView;
        if (paramInt2 == 0)
        {
          n = localSelectableComponent.contentLength();
          if (i >= n)
          {
            i -= n;
            paramInt1 -= n;
            localSelectableComponent.selectContent(-1, -1);
            k = paramInt2;
            paramInt2 = paramInt1;
          }
          else
          {
            if (paramInt1 > n)
            {
              j = paramInt2;
              paramInt2 = n;
            }
            else
            {
              paramInt2 = paramInt1;
              j = 1;
            }
            localSelectableComponent.selectContent(i, paramInt2);
            paramInt2 = paramInt1;
            k = j;
            if (j == 0)
            {
              paramInt2 = paramInt1 - n;
              i = 0;
              k = j;
            }
          }
          paramInt1 = paramInt2;
          paramInt2 = k;
        }
        else
        {
          localSelectableComponent.selectContent(-1, -1);
        }
        localView.invalidate();
        j = paramInt2;
        k = paramInt1;
        n = i;
      }
      m += 1;
      i = n;
      paramInt1 = k;
    }
  }
  
  public int touchIndex(int paramInt1, int paramInt2)
  {
    getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
    Object localObject = this.jdField_a_of_type_ArrayOfInt;
    int m = 0;
    int i1 = paramInt1 - localObject[0] - getPaddingLeft();
    int i2 = paramInt2 - this.jdField_a_of_type_ArrayOfInt[1] - getPaddingTop();
    int n = getChildCount();
    int i = 0;
    int k;
    SelectableComponent localSelectableComponent;
    for (int j = 0; i < n; j = k)
    {
      localObject = getChildAt(i);
      k = j;
      if ((localObject instanceof SelectableComponent))
      {
        localSelectableComponent = (SelectableComponent)localObject;
        if ((i1 > ((View)localObject).getLeft()) && (i1 < ((View)localObject).getRight()) && (i2 > ((View)localObject).getTop()) && (i2 < ((View)localObject).getBottom()))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent = localSelectableComponent;
          return j + localSelectableComponent.touchIndex(paramInt1, paramInt2);
        }
        k = j + localSelectableComponent.contentLength();
      }
      i += 1;
    }
    j = 0;
    i = m;
    while (i < n)
    {
      localObject = getChildAt(i);
      k = j;
      if ((localObject instanceof SelectableComponent))
      {
        localObject = (SelectableComponent)localObject;
        localSelectableComponent = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent;
        if (localSelectableComponent == localObject) {
          return j + localSelectableComponent.touchIndex(paramInt1, paramInt2);
        }
        k = j + ((SelectableComponent)localObject).contentLength();
      }
      i += 1;
      j = k;
    }
    return -1;
  }
  
  @Nullable
  public View view()
  {
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.MixedMsgLinearLayout
 * JD-Core Version:    0.7.0.1
 */