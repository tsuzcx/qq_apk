package com.tencent.mobileqq.widget;

import ahde;
import ahgl;
import alqr;
import alqt;
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
import arnh;
import bcst;
import bdnt;
import bdod;
import bdzx;
import bhud;
import bhyf;
import bhyg;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.activity.selectable.SelectableLinearLayout;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MixedMsgLinearLayout
  extends LinearLayout
  implements alqr
{
  private int jdField_a_of_type_Int;
  private alqr jdField_a_of_type_Alqr;
  private alqt jdField_a_of_type_Alqt;
  private MotionEvent jdField_a_of_type_AndroidViewMotionEvent;
  public bhud a;
  private bhyf jdField_a_of_type_Bhyf = new bhyf(this);
  private bhyg jdField_a_of_type_Bhyg = new bhyg(this);
  private boolean jdField_a_of_type_Boolean;
  private final int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private int jdField_b_of_type_Int;
  private MotionEvent jdField_b_of_type_AndroidViewMotionEvent;
  public bhud b;
  private boolean jdField_b_of_type_Boolean;
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
    int k = 99;
    ChatThumbView localChatThumbView = new ChatThumbView(getContext());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = 0;
    localLayoutParams.rightMargin = 0;
    localChatThumbView.setLayoutParams(localLayoutParams);
    localChatThumbView.setAdjustViewBounds(true);
    int m = bdzx.a(false);
    int i = bdzx.c(false);
    int j = bdzx.d(false);
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
      if (!(bdzx.b() instanceof SkinnableBitmapDrawable)) {
        break label526;
      }
      paramMessageForPic = ((SkinnableBitmapDrawable)bdzx.b()).getBitmap();
      localChatThumbView.setImageDrawable(new arnh(getResources(), paramMessageForPic, j, i, -921103));
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
        label337:
        float f2;
        if (m > n)
        {
          f1 = i / m;
          if (m <= n) {
            break label408;
          }
          f2 = j / n;
          label352:
          Math.max(f1, f2);
          if (f1 >= f2) {
            break label426;
          }
          if (m <= n) {
            break label419;
          }
        }
        label408:
        label419:
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
          break label337;
          f2 = j / m;
          break label352;
        }
        label426:
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
    label526:
    if ((bdzx.b() instanceof BitmapDrawable))
    {
      paramMessageForPic = ((BitmapDrawable)bdzx.b()).getBitmap();
      localChatThumbView.setImageDrawable(new arnh(getResources(), paramMessageForPic, j, i, -921103));
      return localChatThumbView;
    }
    localChatThumbView.setImageDrawable(bdzx.b());
    return localChatThumbView;
  }
  
  private AnimationTextView a()
  {
    AnimationTextView localAnimationTextView = new AnimationTextView(getContext());
    localAnimationTextView.setTextColor(getContext().getResources().getColorStateList(2131167004));
    localAnimationTextView.setLinkTextColor(getContext().getResources().getColorStateList(2131166998));
    localAnimationTextView.setSpannableFactory(bdnt.a);
    localAnimationTextView.setMaxWidth(BaseChatItemLayout.f);
    localAnimationTextView.setMovementMethod(LinkMovementMethod.getInstance());
    localAnimationTextView.setPadding(0, 0, 0, 0);
    localAnimationTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    localAnimationTextView.onDoubleClick = this.jdField_a_of_type_Bhud;
    return localAnimationTextView;
  }
  
  private boolean a(MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramMessageRecord instanceof MessageForText))
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
    int j = this.jdField_a_of_type_Int;
    int k = this.jdField_b_of_type_Int;
    int n = 0;
    int i = 0;
    Object localObject;
    int m;
    int i1;
    if (n < i3)
    {
      localObject = getChildAt(n);
      if ((localObject instanceof alqr))
      {
        localObject = (alqr)localObject;
        m = i;
        if (i != 0) {
          break label211;
        }
        i1 = ((alqr)localObject).contentLength();
        if (j >= i1)
        {
          m = k - i1;
          k = j - i1;
          j = m;
        }
      }
    }
    for (;;)
    {
      label96:
      m = k;
      i1 = j;
      int i2 = i;
      for (;;)
      {
        n += 1;
        i = i2;
        k = i1;
        j = m;
        break;
        if (k <= i1) {
          i = 1;
        }
        localObject = ((alqr)localObject).selectContent();
        if (localObject != null) {
          localStringBuilder.append((CharSequence)localObject);
        }
        m = i;
        if (i != 0) {
          break label211;
        }
        j = k - i1;
        k = 0;
        break label96;
        i2 = i;
        i1 = k;
        m = j;
        if (n != 0)
        {
          localStringBuilder.append(" ");
          i2 = i;
          i1 = k;
          m = j;
        }
      }
      return localStringBuilder.toString();
      label211:
      i = k;
      k = j;
      j = i;
      i = m;
    }
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
  
  public void a(List<MessageRecord> paramList, ahde paramahde)
  {
    int k = 0;
    Object localObject1 = new ArrayList();
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
      ((AnimationTextView)localObject1).setText("");
      this.jdField_a_of_type_Bhyg.a((AnimationTextView)localObject1);
      i += 1;
    }
    j = paramList.size();
    i = 0;
    if (i < j)
    {
      Object localObject2 = paramList.get(i);
      if ((localObject2 instanceof MessageForReplyText))
      {
        localObject1 = new SelectableLinearLayout(getContext());
        ((LinearLayout)localObject1).setOrientation(1);
        localObject2 = ahgl.a(getContext());
        paramahde.e = i;
        paramahde.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((ViewGroup)localObject2).findViewById(2131371539));
        paramahde.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((ViewGroup)localObject2).findViewById(2131371338));
        paramahde.jdField_b_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((ViewGroup)localObject2).findViewById(2131371355));
        ((LinearLayout)localObject1).addView((View)localObject2);
        localObject2 = new ETTextView(getContext());
        ((ETTextView)localObject2).setTextColor(getContext().getResources().getColorStateList(2131167004));
        ((ETTextView)localObject2).setLinkTextColor(getContext().getResources().getColorStateList(2131166998));
        ((ETTextView)localObject2).setEditableFactory(bdod.a);
        ((ETTextView)localObject2).setSpannableFactory(bdnt.a);
        ((ETTextView)localObject2).setMaxWidth(BaseChatItemLayout.e);
        ((ETTextView)localObject2).setMovementMethod(LinkMovementMethod.getInstance());
        ((LinearLayout)localObject1).addView((View)localObject2);
        ((LinearLayout)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addViewInLayout((View)localObject1, i, ((LinearLayout)localObject1).getLayoutParams(), true);
        paramahde.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localObject2);
      }
      label509:
      do
      {
        for (;;)
        {
          i += 1;
          break;
          if (!(localObject2 instanceof MessageForText)) {
            break label509;
          }
          localObject2 = this.jdField_a_of_type_Bhyg.a();
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = a();
          }
          addViewInLayout((View)localObject1, i, ((AnimationTextView)localObject1).getLayoutParams(), true);
        }
      } while (!(localObject2 instanceof MessageForPic));
      localObject1 = this.jdField_a_of_type_Bhyf.a();
      if (localObject1 != null) {
        break label677;
      }
      localObject1 = a((MessageForPic)localObject2);
    }
    label677:
    for (;;)
    {
      addViewInLayout((View)localObject1, i, ((ChatThumbView)localObject1).getLayoutParams(), true);
      break;
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
          ((ChatThumbView)paramList).setImageDrawable(null);
          ((ChatThumbView)paramList).setURLDrawableDownListener(null);
          this.jdField_a_of_type_Bhyf.a((ChatThumbView)paramList);
        }
        i += 1;
      }
      return;
    }
  }
  
  public void bind(@Nullable alqt paramalqt)
  {
    this.jdField_a_of_type_Alqt = paramalqt;
  }
  
  public void clearHighlightContent()
  {
    this.jdField_a_of_type_Boolean = false;
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if ((localView instanceof alqr)) {
        ((alqr)localView).clearHighlightContent();
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
      if ((localView instanceof alqr)) {
        localStringBuilder.append(((alqr)localView).content());
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public int contentLength()
  {
    int k = getChildCount();
    int j = 0;
    int i = 0;
    if (j < k)
    {
      View localView = getChildAt(j);
      if (!(localView instanceof alqr)) {
        break label51;
      }
      i = ((alqr)localView).contentLength() + i;
    }
    label51:
    for (;;)
    {
      j += 1;
      break;
      return i;
    }
  }
  
  @Nullable
  public alqt delegate()
  {
    return this.jdField_a_of_type_Alqt;
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
    if (this.jdField_a_of_type_Alqt == null) {
      throw new IllegalStateException("Has no bound delegate!");
    }
    this.jdField_a_of_type_Alqr = null;
    this.jdField_a_of_type_Alqt.a(paramChatMessage);
    bcst.b(null, "dc00898", "", "", "0X800AE7A", "0X800AE7A", 2, 0, "", "", "", "");
  }
  
  public boolean hasSelected()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean hasTouchSelectableArea(int paramInt1, int paramInt2)
  {
    getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
    int i = paramInt1 - this.jdField_a_of_type_ArrayOfInt[0];
    paramInt2 = paramInt2 - this.jdField_a_of_type_ArrayOfInt[1] - getPaddingTop();
    int j = getChildCount();
    paramInt1 = 0;
    while (paramInt1 < j)
    {
      View localView = getChildAt(paramInt1);
      if ((localView instanceof alqr))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MixedMsgLinearLayout", 2, new Object[] { "left=", Integer.valueOf(localView.getLeft()), " right=", Integer.valueOf(localView.getRight()), " top=", Integer.valueOf(localView.getTop()), " bottom=", Integer.valueOf(localView.getBottom()), " relativeX=", Integer.valueOf(i), " relativeY=", Integer.valueOf(paramInt2) });
        }
        if ((i > localView.getLeft()) && (i < localView.getRight()) && (paramInt2 > localView.getTop()) && (paramInt2 < localView.getBottom())) {
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
    label19:
    Object localObject;
    if (i < j)
    {
      localObject = getChildAt(i);
      if ((localObject instanceof alqr))
      {
        localObject = (alqr)localObject;
        if (!((alqr)localObject).hasSelected()) {
          break label74;
        }
        ((alqr)localObject).highlightBackgroundColor(this.jdField_c_of_type_Int);
        ((alqr)localObject).highlightContent();
      }
    }
    for (;;)
    {
      i += 1;
      break label19;
      break;
      label74:
      ((alqr)localObject).clearHighlightContent();
    }
  }
  
  public void locationByIndex(int paramInt, @NonNull int[] paramArrayOfInt, boolean paramBoolean)
  {
    int j = getChildCount();
    int i = 0;
    Object localObject;
    if (i < j)
    {
      localObject = getChildAt(i);
      if (!(localObject instanceof alqr)) {
        break label79;
      }
      localObject = (alqr)localObject;
      int k = ((alqr)localObject).contentLength();
      if (paramInt > k) {
        paramInt -= k;
      }
    }
    label79:
    for (;;)
    {
      i += 1;
      break;
      ((alqr)localObject).locationByIndex(paramInt, paramArrayOfInt, paramBoolean);
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
    if (this.jdField_b_of_type_Bhud != null) {
      if ((this.jdField_b_of_type_AndroidViewMotionEvent != null) && (paramMotionEvent.getAction() == 0))
      {
        this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
        if ((this.jdField_b_of_type_AndroidViewMotionEvent != null) && (this.jdField_a_of_type_AndroidViewMotionEvent != null) && (AnimationTextView.isConsideredDoubleTap(this.jdField_a_of_type_AndroidViewMotionEvent, this.jdField_b_of_type_AndroidViewMotionEvent, paramMotionEvent)))
        {
          this.jdField_a_of_type_AndroidViewMotionEvent = null;
          this.jdField_b_of_type_AndroidViewMotionEvent = null;
          if (this.jdField_b_of_type_Bhud != null)
          {
            this.jdField_b_of_type_Bhud.a(this);
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
    int i;
    int k;
    label46:
    alqr localalqr;
    int m;
    int j;
    if ((paramInt1 == -1) || (paramInt2 == -1))
    {
      this.jdField_a_of_type_Int = -1;
      this.jdField_b_of_type_Int = -1;
      this.jdField_b_of_type_Boolean = false;
      paramInt2 = this.jdField_a_of_type_Int;
      i = this.jdField_b_of_type_Int;
      int n = getChildCount();
      k = 0;
      paramInt1 = 0;
      if (k >= n) {
        break label257;
      }
      View localView = getChildAt(k);
      if (!(localView instanceof alqr)) {
        break label266;
      }
      localalqr = (alqr)localView;
      if (paramInt1 != 0) {
        break label237;
      }
      m = localalqr.contentLength();
      if (paramInt2 < m) {
        break label190;
      }
      i -= m;
      localalqr.selectContent(-1, -1);
      j = paramInt2 - m;
      paramInt2 = paramInt1;
      paramInt1 = j;
      label120:
      localView.invalidate();
    }
    for (;;)
    {
      k += 1;
      j = paramInt2;
      paramInt2 = paramInt1;
      paramInt1 = j;
      break label46;
      if (paramInt1 > paramInt2) {
        this.jdField_a_of_type_Int = paramInt2;
      }
      for (this.jdField_b_of_type_Int = paramInt1;; this.jdField_b_of_type_Int = paramInt2)
      {
        if (this.jdField_b_of_type_Int - this.jdField_a_of_type_Int <= 0) {
          break label188;
        }
        this.jdField_b_of_type_Boolean = true;
        break;
        this.jdField_a_of_type_Int = paramInt1;
      }
      label188:
      break;
      label190:
      if (i > m)
      {
        j = paramInt1;
        paramInt1 = m;
      }
      for (;;)
      {
        localalqr.selectContent(paramInt2, paramInt1);
        if (j != 0) {
          break label258;
        }
        i -= m;
        paramInt1 = 0;
        paramInt2 = j;
        break;
        paramInt1 = i;
        j = 1;
      }
      label237:
      localalqr.selectContent(-1, -1);
      j = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = j;
      break label120;
      label257:
      return;
      label258:
      paramInt1 = paramInt2;
      paramInt2 = j;
      break label120;
      label266:
      j = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = j;
    }
  }
  
  public int touchIndex(int paramInt1, int paramInt2)
  {
    getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
    int m = paramInt1 - this.jdField_a_of_type_ArrayOfInt[0] - getPaddingLeft();
    int n = paramInt2 - this.jdField_a_of_type_ArrayOfInt[1] - getPaddingTop();
    int k = getChildCount();
    int j = 0;
    int i = 0;
    Object localObject;
    if (j < k)
    {
      localObject = getChildAt(j);
      if (!(localObject instanceof alqr)) {
        break label238;
      }
      alqr localalqr = (alqr)localObject;
      if ((m > ((View)localObject).getLeft()) && (m < ((View)localObject).getRight()) && (n > ((View)localObject).getTop()) && (n < ((View)localObject).getBottom()))
      {
        this.jdField_a_of_type_Alqr = localalqr;
        return localalqr.touchIndex(paramInt1, paramInt2) + i;
      }
      i = localalqr.contentLength() + i;
    }
    label235:
    label238:
    for (;;)
    {
      j += 1;
      break;
      j = 0;
      i = 0;
      if (j < k)
      {
        localObject = getChildAt(j);
        if (!(localObject instanceof alqr)) {
          break label235;
        }
        localObject = (alqr)localObject;
        if (this.jdField_a_of_type_Alqr == localObject) {
          return this.jdField_a_of_type_Alqr.touchIndex(paramInt1, paramInt2) + i;
        }
        i = ((alqr)localObject).contentLength() + i;
      }
      for (;;)
      {
        j += 1;
        break;
        return -1;
      }
    }
  }
  
  @Nullable
  public View view()
  {
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.MixedMsgLinearLayout
 * JD-Core Version:    0.7.0.1
 */