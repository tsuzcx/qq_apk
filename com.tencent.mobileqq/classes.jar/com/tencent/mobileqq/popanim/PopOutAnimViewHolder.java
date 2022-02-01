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
  private static Random c = new Random();
  public Context a = MobileQQ.getContext();
  public RelativeLayout b = (RelativeLayout)LayoutInflater.from(this.a).inflate(2131624090, null);
  private StickerBubbleAnimationView d;
  private boolean e;
  private List<WeakReference<StickerBubbleAnimationView.StickerBubbleAnimationCallback>> f = new CopyOnWriteArrayList();
  private StickerBubbleAnimationView g;
  private boolean h;
  private List<WeakReference<StickerBubbleAnimationView.StickerBubbleAnimationCallback>> i = new CopyOnWriteArrayList();
  private StickerBubbleAnimationView.StickerBubbleAnimationCallback j = new PopOutAnimViewHolder.4(this);
  private StickerBubbleAnimationView.StickerBubbleAnimationCallback k = new PopOutAnimViewHolder.5(this);
  
  private PopOutAnimViewHolder()
  {
    this.b.setClickable(false);
    this.b.setFocusable(false);
    this.b.setFocusableInTouchMode(false);
    PopOutAnimViewHelper.a(new PopOutAnimViewHolder.1(this, (DiniFlyAnimationView)this.b.findViewById(2131446324)));
    PopOutAnimViewHelper.b(new PopOutAnimViewHolder.2(this, (DiniFlyAnimationView)this.b.findViewById(2131433178)));
  }
  
  public static AddItemRequest a(int paramInt, String paramString, boolean paramBoolean)
  {
    AddItemRequest localAddItemRequest = new AddItemRequest().a(new Point(paramInt / 2, 0)).a(paramString).a(paramBoolean);
    int m = 2000;
    if (paramBoolean) {
      paramInt = -c.nextInt(2000) + 1000;
    } else {
      paramInt = -c.nextInt(8000) + 4000;
    }
    double d1 = paramInt;
    if (paramBoolean)
    {
      paramString = c;
      paramInt = 500;
    }
    else
    {
      paramString = c;
      paramInt = m;
    }
    return localAddItemRequest.a(new ItemStatus.Velocity(d1, paramString.nextInt(paramInt))).a(new ItemStatus.Acceleration(0.0D, 200.0D)).a(49);
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
    if (this.g == null)
    {
      this.g = new StickerBubbleAnimationView(this.a);
      this.g.setShowText(false, paramTypeface);
      this.g.setAnimationCallback(this.j);
      this.g.a();
    }
    return this.g;
  }
  
  public AddItemRequest a(@NonNull Point paramPoint, @NonNull String paramString, boolean paramBoolean)
  {
    paramPoint = new AddItemRequest().a(paramPoint).a(paramString).a(paramBoolean);
    int m;
    if (paramBoolean) {
      m = -c.nextInt(1500) + 750;
    } else {
      m = -c.nextInt(6000) + 3000;
    }
    double d1 = m;
    if (paramBoolean) {
      m = -1000 - c.nextInt(500);
    } else {
      m = -2000 - c.nextInt(1000);
    }
    return paramPoint.a(new ItemStatus.Velocity(d1, m)).a(new ItemStatus.Acceleration(0.0D, 200.0D)).a(85);
  }
  
  public StickerBubbleAnimationView a(Typeface paramTypeface)
  {
    if (this.d == null)
    {
      this.d = new StickerBubbleAnimationView(this.a);
      this.d.setShowText(true, paramTypeface);
      this.d.setAnimationCallback(this.k);
      this.d.a();
    }
    return this.d;
  }
  
  public StickerBubbleAnimationView a(ViewGroup paramViewGroup, Typeface paramTypeface)
  {
    paramTypeface = a(paramTypeface);
    if (!this.e)
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
      this.e = true;
    }
    return paramTypeface;
  }
  
  public void a(StickerBubbleAnimationView.StickerBubbleAnimationCallback paramStickerBubbleAnimationCallback, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      List localList = this.f;
      break label19;
      localList = this.i;
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
  
  public StickerBubbleAnimationView b(ViewGroup paramViewGroup, Typeface paramTypeface)
  {
    paramTypeface = b(paramTypeface);
    if (!this.h)
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
      this.h = true;
    }
    return paramTypeface;
  }
  
  public void b()
  {
    ThreadManager.getUIHandler().post(new PopOutAnimViewHolder.3(this));
  }
  
  public void b(StickerBubbleAnimationView.StickerBubbleAnimationCallback paramStickerBubbleAnimationCallback, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      List localList = this.f;
      break label19;
      localList = this.i;
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
  
  public StickerBubbleAnimationView c()
  {
    StickerBubbleAnimationView localStickerBubbleAnimationView = this.d;
    if (this.e)
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
      this.e = false;
    }
    return localStickerBubbleAnimationView;
  }
  
  public StickerBubbleAnimationView d()
  {
    StickerBubbleAnimationView localStickerBubbleAnimationView = this.g;
    if (this.h)
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
      this.h = false;
    }
    return localStickerBubbleAnimationView;
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PopOutAnimViewHolder", 2, "cleanView");
    }
    if (this.h) {
      d();
    }
    if (this.e) {
      c();
    }
    this.g = null;
    this.d = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.popanim.PopOutAnimViewHolder
 * JD-Core Version:    0.7.0.1
 */