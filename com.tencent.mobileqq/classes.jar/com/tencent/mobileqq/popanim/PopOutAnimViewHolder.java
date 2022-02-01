package com.tencent.mobileqq.popanim;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.stickerbubble.AddItemRequest;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView.StickerBubbleAnimationCallback;
import com.tencent.mobileqq.activity.aio.stickerbubble.item.ItemStatus.Acceleration;
import com.tencent.mobileqq.activity.aio.stickerbubble.item.ItemStatus.Velocity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.popanim.util.PopOutEmoticonUtil;
import com.tencent.mobileqq.popanim.view.PopOutAnimViewHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class PopOutAnimViewHolder
{
  private static Random jdField_a_of_type_JavaUtilRandom = new Random();
  public Context a;
  public RelativeLayout a;
  private StickerBubbleAnimationView.StickerBubbleAnimationCallback jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView$StickerBubbleAnimationCallback = new PopOutAnimViewHolder.4(this);
  private StickerBubbleAnimationView jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView;
  private List<WeakReference<StickerBubbleAnimationView.StickerBubbleAnimationCallback>> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private boolean jdField_a_of_type_Boolean;
  private StickerBubbleAnimationView.StickerBubbleAnimationCallback jdField_b_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView$StickerBubbleAnimationCallback = new PopOutAnimViewHolder.5(this);
  private StickerBubbleAnimationView jdField_b_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView;
  private List<WeakReference<StickerBubbleAnimationView.StickerBubbleAnimationCallback>> jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private boolean jdField_b_of_type_Boolean;
  
  private PopOutAnimViewHolder()
  {
    this.jdField_a_of_type_AndroidContentContext = MobileQQ.getContext();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558537, null));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setFocusable(false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setFocusableInTouchMode(false);
    PopOutAnimViewHelper.a(new PopOutAnimViewHolder.1(this, (DiniFlyAnimationView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131377848)));
    PopOutAnimViewHelper.b(new PopOutAnimViewHolder.2(this, (DiniFlyAnimationView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366851)));
  }
  
  public static AddItemRequest a(int paramInt, String paramString, boolean paramBoolean)
  {
    AddItemRequest localAddItemRequest = new AddItemRequest().a(new Point(paramInt / 2, 0)).a(paramString).a(paramBoolean);
    int i = 2000;
    if (paramBoolean) {
      paramInt = -jdField_a_of_type_JavaUtilRandom.nextInt(2000) + 1000;
    } else {
      paramInt = -jdField_a_of_type_JavaUtilRandom.nextInt(8000) + 4000;
    }
    double d = paramInt;
    if (paramBoolean)
    {
      paramString = jdField_a_of_type_JavaUtilRandom;
      paramInt = 500;
    }
    else
    {
      paramString = jdField_a_of_type_JavaUtilRandom;
      paramInt = i;
    }
    return localAddItemRequest.a(new ItemStatus.Velocity(d, paramString.nextInt(paramInt))).a(new ItemStatus.Acceleration(0.0D, 200.0D)).a(49);
  }
  
  public static PopOutAnimViewHolder a()
  {
    return PopOutAnimViewHolder.Holder.a();
  }
  
  private void a(List<WeakReference<StickerBubbleAnimationView.StickerBubbleAnimationCallback>> paramList)
  {
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        StickerBubbleAnimationView.StickerBubbleAnimationCallback localStickerBubbleAnimationCallback = (StickerBubbleAnimationView.StickerBubbleAnimationCallback)((WeakReference)paramList.next()).get();
        if (localStickerBubbleAnimationCallback != null) {
          localStickerBubbleAnimationCallback.a();
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramList;
    }
  }
  
  private void a(List<WeakReference<StickerBubbleAnimationView.StickerBubbleAnimationCallback>> paramList, int paramInt)
  {
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        StickerBubbleAnimationView.StickerBubbleAnimationCallback localStickerBubbleAnimationCallback = (StickerBubbleAnimationView.StickerBubbleAnimationCallback)((WeakReference)paramList.next()).get();
        if (localStickerBubbleAnimationCallback != null) {
          localStickerBubbleAnimationCallback.a(paramInt);
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramList;
    }
  }
  
  private StickerBubbleAnimationView b(Typeface paramTypeface)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView == null)
    {
      this.jdField_b_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView = new StickerBubbleAnimationView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView.setShowText(false, paramTypeface);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView.setAnimationCallback(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView$StickerBubbleAnimationCallback);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView.a();
    }
    return this.jdField_b_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView;
  }
  
  public AddItemRequest a(@NonNull Point paramPoint, @NonNull String paramString, boolean paramBoolean)
  {
    paramPoint = new AddItemRequest().a(paramPoint).a(paramString).a(paramBoolean);
    int i;
    if (paramBoolean) {
      i = -jdField_a_of_type_JavaUtilRandom.nextInt(1500) + 750;
    } else {
      i = -jdField_a_of_type_JavaUtilRandom.nextInt(6000) + 3000;
    }
    double d = i;
    if (paramBoolean) {
      i = -1000 - jdField_a_of_type_JavaUtilRandom.nextInt(500);
    } else {
      i = -2000 - jdField_a_of_type_JavaUtilRandom.nextInt(1000);
    }
    return paramPoint.a(new ItemStatus.Velocity(d, i)).a(new ItemStatus.Acceleration(0.0D, 200.0D)).a(85);
  }
  
  public StickerBubbleAnimationView a()
  {
    StickerBubbleAnimationView localStickerBubbleAnimationView = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView;
    if (this.jdField_a_of_type_Boolean)
    {
      if (localStickerBubbleAnimationView != null)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("hideSendAnimationView: ");
          localStringBuilder.append(localStickerBubbleAnimationView);
          QLog.d("PopOutAnimViewHolder", 2, localStringBuilder.toString());
        }
        PopOutEmoticonUtil.a(localStickerBubbleAnimationView);
      }
      this.jdField_a_of_type_Boolean = false;
    }
    return localStickerBubbleAnimationView;
  }
  
  public StickerBubbleAnimationView a(Typeface paramTypeface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView = new StickerBubbleAnimationView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView.setShowText(true, paramTypeface);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView.setAnimationCallback(this.jdField_b_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView$StickerBubbleAnimationCallback);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView.a();
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView;
  }
  
  public StickerBubbleAnimationView a(ViewGroup paramViewGroup, Typeface paramTypeface)
  {
    paramTypeface = a(paramTypeface);
    if (!this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("showSendAnimationView: ");
        localStringBuilder.append(paramTypeface.getParent());
        localStringBuilder.append(" / ");
        localStringBuilder.append(paramViewGroup);
        QLog.d("PopOutAnimViewHolder", 2, localStringBuilder.toString());
      }
      PopOutEmoticonUtil.a(paramViewGroup, paramTypeface);
      this.jdField_a_of_type_Boolean = true;
    }
    return paramTypeface;
  }
  
  public void a()
  {
    ThreadManager.getUIHandler().post(new PopOutAnimViewHolder.3(this));
  }
  
  public void a(StickerBubbleAnimationView.StickerBubbleAnimationCallback paramStickerBubbleAnimationCallback, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      List localList = this.jdField_a_of_type_JavaUtilList;
      break label19;
      localList = this.jdField_b_of_type_JavaUtilList;
      label19:
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (WeakReference)localIterator.next();
        if (localObject != null)
        {
          localObject = ((WeakReference)localObject).get();
          if (localObject == paramStickerBubbleAnimationCallback) {
            return;
          }
        }
      }
      localList.add(new WeakReference(paramStickerBubbleAnimationCallback));
      return;
    }
    finally {}
    for (;;)
    {
      throw paramStickerBubbleAnimationCallback;
    }
  }
  
  public StickerBubbleAnimationView b()
  {
    StickerBubbleAnimationView localStickerBubbleAnimationView = this.jdField_b_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView;
    if (this.jdField_b_of_type_Boolean)
    {
      if (localStickerBubbleAnimationView != null)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("hideReceiveAnimationView: ");
          localStringBuilder.append(localStickerBubbleAnimationView);
          QLog.d("PopOutAnimViewHolder", 2, localStringBuilder.toString());
        }
        PopOutEmoticonUtil.a(localStickerBubbleAnimationView);
      }
      this.jdField_b_of_type_Boolean = false;
    }
    return localStickerBubbleAnimationView;
  }
  
  public StickerBubbleAnimationView b(ViewGroup paramViewGroup, Typeface paramTypeface)
  {
    paramTypeface = b(paramTypeface);
    if (!this.jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("showReceiveAnimationView: ");
        localStringBuilder.append(paramTypeface.getParent());
        localStringBuilder.append(" / ");
        localStringBuilder.append(paramViewGroup);
        QLog.d("PopOutAnimViewHolder", 2, localStringBuilder.toString());
      }
      PopOutEmoticonUtil.a(paramViewGroup, paramTypeface);
      this.jdField_b_of_type_Boolean = true;
    }
    return paramTypeface;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PopOutAnimViewHolder", 2, "cleanView");
    }
    if (this.jdField_b_of_type_Boolean) {
      b();
    }
    if (this.jdField_a_of_type_Boolean) {
      a();
    }
    this.jdField_b_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView = null;
  }
  
  public void b(StickerBubbleAnimationView.StickerBubbleAnimationCallback paramStickerBubbleAnimationCallback, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      List localList = this.jdField_a_of_type_JavaUtilList;
      break label19;
      localList = this.jdField_b_of_type_JavaUtilList;
      label19:
      CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() == paramStickerBubbleAnimationCallback)) {
          localCopyOnWriteArrayList.add(localWeakReference);
        }
      }
      localList.removeAll(localCopyOnWriteArrayList);
      return;
    }
    finally {}
    for (;;)
    {
      throw paramStickerBubbleAnimationCallback;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.popanim.PopOutAnimViewHolder
 * JD-Core Version:    0.7.0.1
 */