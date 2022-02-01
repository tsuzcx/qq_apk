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
  public AnimationTextView.OnDoubleClick a;
  public AnimationTextView.OnDoubleClick b;
  private MixedMsgLinearLayout.TextViewScrapHeap c = new MixedMsgLinearLayout.TextViewScrapHeap(this);
  private MixedMsgLinearLayout.ImageScrapHeap d = new MixedMsgLinearLayout.ImageScrapHeap(this);
  private SelectableDelegate e;
  private int f;
  private int g;
  private int h = -5250572;
  private boolean i = false;
  private boolean j = false;
  private boolean k = true;
  private SelectableComponent l;
  private final int[] m = new int[2];
  private MotionEvent n;
  private MotionEvent o;
  
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
    int i3 = CommonImgThumbHelper.getImgThumbMaxPx(false);
    int i2 = CommonImgThumbHelper.getImgThumbMaxDp(false);
    int i1 = CommonImgThumbHelper.getImgThumbMinDp(false);
    localChatThumbView.setMaxHeight(i3);
    localChatThumbView.setMaxWidth(i3);
    i3 = paramMessageForPic.thumbWidth;
    int i5 = paramMessageForPic.thumbHeight;
    if ((i3 > 0) && (i5 > 0))
    {
      float f2;
      if ((i3 >= i1) && (i5 >= i1))
      {
        if ((i3 < i2) && (i5 < i2))
        {
          i1 = i3;
          i2 = i5;
          break label474;
        }
        if (i3 > i5)
        {
          f1 = i2;
          f2 = i3;
        }
        else
        {
          f1 = i2;
          f2 = i5;
        }
        float f3 = f1 / f2;
        if (i3 > i5)
        {
          f1 = i1;
          f2 = i5;
        }
        else
        {
          f1 = i1;
          f2 = i3;
        }
        f1 /= f2;
        Math.max(f3, f1);
        if (f3 < f1)
        {
          if (i3 > i5) {
            i3 = i2;
          } else {
            i3 = i1;
          }
          i4 = i3;
          if (i5 > i3) {
            i1 = i2;
          }
        }
      }
      for (int i4 = i3;; i4 = i2)
      {
        i2 = i1;
        i1 = i4;
        break;
        if (i3 > i5)
        {
          f1 = i2;
          f2 = i3;
        }
        else
        {
          f1 = i2;
          f2 = i5;
        }
        f1 /= f2;
        i1 = (int)(i3 * f1 + 0.5F);
        i2 = (int)(i5 * f1 + 0.5F);
        break;
        if (i3 < i5)
        {
          f1 = i1 / i3;
          i4 = (int)(i5 * f1 + 0.5F);
          i3 = i4;
          if (i4 > i2) {
            i3 = i2;
          }
          i2 = i3;
          break;
        }
        f1 = i1 / i5;
        i3 = (int)(i3 * f1 + 0.5F);
        i2 = i3;
        if (i3 > i1) {
          i2 = i1;
        }
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        paramMessageForPic = new StringBuilder();
        paramMessageForPic.append("MessageForPic without width/height of thumb, width = ");
        paramMessageForPic.append(i3);
        paramMessageForPic.append(", height = ");
        paramMessageForPic.append(i5);
        QLog.d("MixedMsgLinearLayout", 2, paramMessageForPic.toString());
      }
      i2 = 99;
      i1 = 99;
    }
    label474:
    float f1 = getResources().getDisplayMetrics().densityDpi / 160.0F;
    i1 = (int)(i1 * f1 + 0.5F);
    i2 = (int)(i2 * f1 + 0.5F);
    if ((URLDrawableHelper.getLoadingDrawable() instanceof SkinnableBitmapDrawable))
    {
      paramMessageForPic = ((SkinnableBitmapDrawable)URLDrawableHelper.getLoadingDrawable()).getBitmap();
      localChatThumbView.setImageDrawable(new BitmapDrawableWithMargin(getResources(), paramMessageForPic, i1, i2, -921103));
      return localChatThumbView;
    }
    if ((URLDrawableHelper.getLoadingDrawable() instanceof BitmapDrawable))
    {
      paramMessageForPic = ((BitmapDrawable)URLDrawableHelper.getLoadingDrawable()).getBitmap();
      localChatThumbView.setImageDrawable(new BitmapDrawableWithMargin(getResources(), paramMessageForPic, i1, i2, -921103));
      return localChatThumbView;
    }
    localChatThumbView.setImageDrawable(URLDrawableHelper.getLoadingDrawable());
    return localChatThumbView;
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
  
  private AnimationTextView b()
  {
    AnimationTextView localAnimationTextView = new AnimationTextView(getContext());
    localAnimationTextView.setTextColor(getContext().getResources().getColorStateList(2131168016));
    localAnimationTextView.setLinkTextColor(getContext().getResources().getColorStateList(2131168008));
    localAnimationTextView.setSpannableFactory(QQText.SPANNABLE_FACTORY);
    localAnimationTextView.setMaxWidth(BaseChatItemLayout.f);
    localAnimationTextView.setMovementMethod(LinkMovementMethod.getInstance());
    localAnimationTextView.setPadding(0, 0, 0, 0);
    localAnimationTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    localAnimationTextView.onDoubleClick = this.a;
    return localAnimationTextView;
  }
  
  public CharSequence a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i8 = getChildCount();
    int i7 = this.f;
    int i5 = this.g;
    int i4 = 0;
    int i2 = 0;
    while (i4 < i8)
    {
      Object localObject = getChildAt(i4);
      int i6;
      int i1;
      int i3;
      if ((localObject instanceof SelectableComponent))
      {
        localObject = (SelectableComponent)localObject;
        i6 = i2;
        i1 = i7;
        i3 = i5;
        if (i2 == 0)
        {
          int i9 = ((SelectableComponent)localObject).contentLength();
          if (i7 >= i9)
          {
            i1 = i7 - i9;
            i3 = i5 - i9;
            i6 = i2;
          }
          else
          {
            if (i5 <= i9) {
              i2 = 1;
            }
            localObject = ((SelectableComponent)localObject).selectContent();
            if (localObject != null) {
              localStringBuilder.append((CharSequence)localObject);
            }
            i6 = i2;
            i1 = i7;
            i3 = i5;
            if (i2 == 0)
            {
              i3 = i5 - i9;
              i1 = 0;
              i6 = i2;
            }
          }
        }
      }
      else
      {
        i6 = i2;
        i1 = i7;
        i3 = i5;
        if (i4 != 0)
        {
          localStringBuilder.append(" ");
          i3 = i5;
          i1 = i7;
          i6 = i2;
        }
      }
      i4 += 1;
      i2 = i6;
      i7 = i1;
      i5 = i3;
    }
    return localStringBuilder.toString();
  }
  
  public void a(ColorStateList paramColorStateList1, ColorStateList paramColorStateList2)
  {
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject = getChildAt(i1);
      if ((localObject instanceof AnimationTextView))
      {
        localObject = (AnimationTextView)localObject;
        ((AnimationTextView)localObject).setTextColor(paramColorStateList1);
        ((AnimationTextView)localObject).setLinkTextColor(paramColorStateList2);
      }
      i1 += 1;
    }
  }
  
  public void a(Typeface paramTypeface)
  {
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = getChildAt(i1);
      if ((localView instanceof TextView)) {
        ((TextView)localView).setTypeface(paramTypeface);
      }
      i1 += 1;
    }
  }
  
  public void a(List<MessageRecord> paramList, MixedMsgItemBuilder.MixedHolder paramMixedHolder)
  {
    Object localObject1 = new ArrayList();
    int i3 = 0;
    int i1 = 0;
    while (i1 < paramList.size())
    {
      if (a((MessageRecord)paramList.get(i1))) {
        ((List)localObject1).add(paramList.get(i1));
      }
      i1 += 1;
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramList.remove((MessageRecord)((Iterator)localObject1).next());
    }
    int i2 = getChildCount();
    ArrayList localArrayList = new ArrayList();
    i1 = 0;
    while (i1 < i2)
    {
      localObject1 = getChildAt(i1);
      if ((localObject1 instanceof AnimationTextView)) {
        localArrayList.add(localObject1);
      }
      i1 += 1;
    }
    i1 = 0;
    while (i1 < localArrayList.size())
    {
      localObject1 = (View)localArrayList.get(i1);
      detachViewFromParent((View)localObject1);
      localObject1 = (AnimationTextView)localObject1;
      ((AnimationTextView)localObject1).setText("");
      this.c.a((AnimationTextView)localObject1);
      i1 += 1;
    }
    i2 = paramList.size();
    i1 = 0;
    while (i1 < i2)
    {
      Object localObject3 = paramList.get(i1);
      Object localObject2;
      if ((localObject3 instanceof MessageForReplyText))
      {
        localObject1 = new SelectableLinearLayout(getContext());
        ((LinearLayout)localObject1).setOrientation(1);
        localObject2 = ReplyTextItemBuilder.a(getContext());
        paramMixedHolder.b = i1;
        paramMixedHolder.d = ((TextView)((ViewGroup)localObject2).findViewById(2131439121));
        paramMixedHolder.c = ((TextView)((ViewGroup)localObject2).findViewById(2131447354));
        paramMixedHolder.e = ((ETTextView)((ViewGroup)localObject2).findViewById(2131438908));
        paramMixedHolder.f = ((ETTextView)((ViewGroup)localObject2).findViewById(2131438922));
        ((LinearLayout)localObject1).addView((View)localObject2);
        localObject2 = new ETTextView(getContext());
        ((ETTextView)localObject2).setTextColor(getContext().getResources().getColorStateList(2131168016));
        ((ETTextView)localObject2).setLinkTextColor(getContext().getResources().getColorStateList(2131168008));
        ((ETTextView)localObject2).setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
        ((ETTextView)localObject2).setSpannableFactory(QQText.SPANNABLE_FACTORY);
        ((ETTextView)localObject2).setMaxWidth(BaseChatItemLayout.e);
        ((ETTextView)localObject2).setMovementMethod(LinkMovementMethod.getInstance());
        ((LinearLayout)localObject1).addView((View)localObject2);
        ((LinearLayout)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addViewInLayout((View)localObject1, i1, ((LinearLayout)localObject1).getLayoutParams(), true);
        paramMixedHolder.g = ((TextView)localObject2);
      }
      else if ((localObject3 instanceof MessageForText))
      {
        localObject2 = this.c.a();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = b();
        }
        addViewInLayout((View)localObject1, i1, ((AnimationTextView)localObject1).getLayoutParams(), true);
      }
      else if ((localObject3 instanceof MessageForPic))
      {
        localObject2 = this.d.a();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = a((MessageForPic)localObject3);
        }
        addViewInLayout((View)localObject1, i1, ((ChatThumbView)localObject1).getLayoutParams(), true);
      }
      i1 += 1;
    }
    localArrayList.clear();
    int i4 = getChildCount();
    i1 = i3;
    if (i4 > i2) {
      for (;;)
      {
        i1 = i3;
        if (i2 >= i4) {
          break;
        }
        localArrayList.add(getChildAt(i2));
        i2 += 1;
      }
    }
    while (i1 < localArrayList.size())
    {
      paramList = (View)localArrayList.get(i1);
      detachViewFromParent(paramList);
      if ((paramList instanceof ChatThumbView))
      {
        paramList = (ChatThumbView)paramList;
        paramList.setImageDrawable(null);
        paramList.setURLDrawableDownListener(null);
        this.d.a(paramList);
      }
      i1 += 1;
    }
  }
  
  public void bind(@Nullable SelectableDelegate paramSelectableDelegate)
  {
    this.e = paramSelectableDelegate;
  }
  
  public void clearHighlightContent()
  {
    int i1 = 0;
    this.i = false;
    int i2 = getChildCount();
    while (i1 < i2)
    {
      View localView = getChildAt(i1);
      if ((localView instanceof SelectableComponent)) {
        ((SelectableComponent)localView).clearHighlightContent();
      }
      i1 += 1;
    }
  }
  
  @Nullable
  public CharSequence content()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = getChildAt(i1);
      if ((localView instanceof SelectableComponent)) {
        localStringBuilder.append(((SelectableComponent)localView).content());
      }
      i1 += 1;
    }
    return localStringBuilder.toString();
  }
  
  public int contentLength()
  {
    int i4 = getChildCount();
    int i1 = 0;
    int i3;
    for (int i2 = 0; i1 < i4; i2 = i3)
    {
      View localView = getChildAt(i1);
      i3 = i2;
      if ((localView instanceof SelectableComponent)) {
        i3 = i2 + ((SelectableComponent)localView).contentLength();
      }
      i1 += 1;
    }
    return i2;
  }
  
  @Nullable
  public SelectableDelegate delegate()
  {
    return this.e;
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
    SelectableDelegate localSelectableDelegate = this.e;
    if (localSelectableDelegate != null)
    {
      this.l = null;
      localSelectableDelegate.a(paramChatMessage);
      ReportController.b(null, "dc00898", "", "", "0X800AE7A", "0X800AE7A", 2, 0, "", "", "", "");
      return;
    }
    throw new IllegalStateException("Has no bound delegate!");
  }
  
  public boolean hasSelected()
  {
    return this.j;
  }
  
  public boolean hasTouchSelectableArea(int paramInt1, int paramInt2)
  {
    getLocationInWindow(this.m);
    Object localObject = this.m;
    int i1 = paramInt1 - localObject[0];
    paramInt2 = paramInt2 - localObject[1] - getPaddingTop();
    int i2 = getChildCount();
    paramInt1 = 0;
    while (paramInt1 < i2)
    {
      localObject = getChildAt(paramInt1);
      if ((localObject instanceof SelectableComponent))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MixedMsgLinearLayout", 2, new Object[] { "left=", Integer.valueOf(((View)localObject).getLeft()), " right=", Integer.valueOf(((View)localObject).getRight()), " top=", Integer.valueOf(((View)localObject).getTop()), " bottom=", Integer.valueOf(((View)localObject).getBottom()), " relativeX=", Integer.valueOf(i1), " relativeY=", Integer.valueOf(paramInt2) });
        }
        if ((i1 > ((View)localObject).getLeft()) && (i1 < ((View)localObject).getRight()) && (paramInt2 > ((View)localObject).getTop()) && (paramInt2 < ((View)localObject).getBottom())) {
          return true;
        }
      }
      paramInt1 += 1;
    }
    return false;
  }
  
  public void highlightBackgroundColor(@ColorInt int paramInt)
  {
    this.h = paramInt;
  }
  
  public void highlightContent()
  {
    if (!hasSelected())
    {
      clearHighlightContent();
      return;
    }
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject = getChildAt(i1);
      if ((localObject instanceof SelectableComponent))
      {
        localObject = (SelectableComponent)localObject;
        if (((SelectableComponent)localObject).hasSelected())
        {
          ((SelectableComponent)localObject).highlightBackgroundColor(this.h);
          ((SelectableComponent)localObject).highlightContent();
        }
        else
        {
          ((SelectableComponent)localObject).clearHighlightContent();
        }
      }
      i1 += 1;
    }
  }
  
  public void locationByIndex(int paramInt, @NonNull int[] paramArrayOfInt, boolean paramBoolean)
  {
    int i3 = getChildCount();
    int i2 = 0;
    int i1 = paramInt;
    paramInt = i2;
    while (paramInt < i3)
    {
      Object localObject = getChildAt(paramInt);
      i2 = i1;
      if ((localObject instanceof SelectableComponent))
      {
        localObject = (SelectableComponent)localObject;
        i2 = ((SelectableComponent)localObject).contentLength();
        if (i1 > i2)
        {
          i2 = i1 - i2;
        }
        else
        {
          ((SelectableComponent)localObject).locationByIndex(i1, paramArrayOfInt, paramBoolean);
          return;
        }
      }
      paramInt += 1;
      i1 = i2;
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
    if (this.b != null) {
      if ((this.o != null) && (paramMotionEvent.getAction() == 0))
      {
        this.n = MotionEvent.obtain(paramMotionEvent);
        Object localObject = this.o;
        if (localObject != null)
        {
          MotionEvent localMotionEvent = this.n;
          if ((localMotionEvent != null) && (AnimationTextView.isConsideredDoubleTap(localMotionEvent, (MotionEvent)localObject, paramMotionEvent)))
          {
            this.n = null;
            this.o = null;
            localObject = this.b;
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
        this.o = MotionEvent.obtain(paramMotionEvent);
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  @Nullable
  public CharSequence selectContent()
  {
    CharSequence localCharSequence = content();
    if (localCharSequence != null) {
      return localCharSequence.subSequence(this.f, this.g);
    }
    return null;
  }
  
  public void selectContent(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != -1) && (paramInt2 != -1))
    {
      if (paramInt1 > paramInt2)
      {
        this.f = paramInt2;
        this.g = paramInt1;
      }
      else
      {
        this.f = paramInt1;
        this.g = paramInt2;
      }
      if (this.g - this.f > 0) {
        this.j = true;
      }
    }
    else
    {
      this.f = -1;
      this.g = -1;
      this.j = false;
    }
    int i1 = this.f;
    paramInt1 = this.g;
    int i6 = getChildCount();
    int i4 = 0;
    int i2;
    for (paramInt2 = 0; i4 < i6; paramInt2 = i2)
    {
      View localView = getChildAt(i4);
      int i5 = i1;
      int i3 = paramInt1;
      i2 = paramInt2;
      if ((localView instanceof SelectableComponent))
      {
        SelectableComponent localSelectableComponent = (SelectableComponent)localView;
        if (paramInt2 == 0)
        {
          i5 = localSelectableComponent.contentLength();
          if (i1 >= i5)
          {
            i1 -= i5;
            paramInt1 -= i5;
            localSelectableComponent.selectContent(-1, -1);
            i3 = paramInt2;
            paramInt2 = paramInt1;
          }
          else
          {
            if (paramInt1 > i5)
            {
              i2 = paramInt2;
              paramInt2 = i5;
            }
            else
            {
              paramInt2 = paramInt1;
              i2 = 1;
            }
            localSelectableComponent.selectContent(i1, paramInt2);
            paramInt2 = paramInt1;
            i3 = i2;
            if (i2 == 0)
            {
              paramInt2 = paramInt1 - i5;
              i1 = 0;
              i3 = i2;
            }
          }
          paramInt1 = paramInt2;
          paramInt2 = i3;
        }
        else
        {
          localSelectableComponent.selectContent(-1, -1);
        }
        localView.invalidate();
        i2 = paramInt2;
        i3 = paramInt1;
        i5 = i1;
      }
      i4 += 1;
      i1 = i5;
      paramInt1 = i3;
    }
  }
  
  public int touchIndex(int paramInt1, int paramInt2)
  {
    getLocationInWindow(this.m);
    Object localObject = this.m;
    int i4 = 0;
    int i6 = paramInt1 - localObject[0] - getPaddingLeft();
    int i7 = paramInt2 - this.m[1] - getPaddingTop();
    int i5 = getChildCount();
    int i1 = 0;
    int i3;
    SelectableComponent localSelectableComponent;
    for (int i2 = 0; i1 < i5; i2 = i3)
    {
      localObject = getChildAt(i1);
      i3 = i2;
      if ((localObject instanceof SelectableComponent))
      {
        localSelectableComponent = (SelectableComponent)localObject;
        if ((i6 > ((View)localObject).getLeft()) && (i6 < ((View)localObject).getRight()) && (i7 > ((View)localObject).getTop()) && (i7 < ((View)localObject).getBottom()))
        {
          this.l = localSelectableComponent;
          return i2 + localSelectableComponent.touchIndex(paramInt1, paramInt2);
        }
        i3 = i2 + localSelectableComponent.contentLength();
      }
      i1 += 1;
    }
    i2 = 0;
    i1 = i4;
    while (i1 < i5)
    {
      localObject = getChildAt(i1);
      i3 = i2;
      if ((localObject instanceof SelectableComponent))
      {
        localObject = (SelectableComponent)localObject;
        localSelectableComponent = this.l;
        if (localSelectableComponent == localObject) {
          return i2 + localSelectableComponent.touchIndex(paramInt1, paramInt2);
        }
        i3 = i2 + ((SelectableComponent)localObject).contentLength();
      }
      i1 += 1;
      i2 = i3;
    }
    return -1;
  }
  
  @Nullable
  public View view()
  {
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.MixedMsgLinearLayout
 * JD-Core Version:    0.7.0.1
 */