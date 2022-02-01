package com.tencent.mobileqq.mini.entry.desktop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.ScaleAnimation;
import bgtn;
import bkrd;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DragRecyclerView
  extends RecyclerView
{
  int SCROLL_OFFSET = bgtn.a(20.0F);
  boolean autoScrollEnable = false;
  int autoScrollOffsetX = 0;
  boolean autoScrollStatus = false;
  protected List<DragRecyclerView> children = new ArrayList();
  private RecyclerView.ViewHolder currDragViewHolder;
  int hasScrolledOffsetX = 0;
  protected boolean isDragging;
  private int lastDragX;
  private int lastDragY;
  private boolean mAutoScrollEnable;
  private boolean mCanAutoScroll;
  private DragRecyclerView.DragDeleteListener mDeleteDragListener;
  private boolean mIsDeletePrepared;
  private DragRecyclerView.OnItemChangeListener mOnItemChangeListener;
  private Handler mainHandler = new Handler(Looper.myLooper());
  boolean oritationRight = true;
  private ScaleAnimation revertAnimation = new ScaleAnimation(1.1F, 1.0F, 1.1F, 1.0F, 1, 0.5F, 1, 0.5F);
  int startAutoScrollOffset = 0;
  bkrd touchHelper = new DragRecyclerView.MiniItemTouchHelper(this, new DragRecyclerView.4(this));
  private boolean up;
  private ScaleAnimation zoomAnimation = new ScaleAnimation(1.0F, 1.1F, 1.0F, 1.1F, 1, 0.5F, 1, 0.5F);
  
  public DragRecyclerView(Context paramContext)
  {
    super(paramContext.getApplicationContext());
    init(paramContext.getApplicationContext());
  }
  
  public DragRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext.getApplicationContext(), paramAttributeSet);
    init(paramContext.getApplicationContext());
  }
  
  private void doAutoScroolToBottom()
  {
    if (this.mAutoScrollEnable)
    {
      if ((this.mCanAutoScroll) && (!isSlideToBottom()))
      {
        if (this.startAutoScrollOffset <= 0) {
          this.startAutoScrollOffset = (computeVerticalScrollExtent() + computeVerticalScrollOffset());
        }
        smoothScrollBy(0, 100);
      }
      this.mainHandler.postDelayed(new DragRecyclerView.3(this), 50L);
    }
  }
  
  private void init(Context paramContext)
  {
    addOnScrollListener(new DragRecyclerView.1(this));
    this.touchHelper.attachToRecyclerView(this);
    addOnItemTouchListener(new DragRecyclerView.2(this, this));
  }
  
  private void onDragFinish()
  {
    if (!this.isDragging) {
      return;
    }
    QLog.i("DragRecycleView", 1, "onDragFinish");
    try
    {
      if (this.mDeleteDragListener != null) {
        this.mDeleteDragListener.onDeleteDragFinish();
      }
    }
    catch (Throwable localThrowable2)
    {
      try
      {
        if ((this.mIsDeletePrepared) && (this.mOnItemChangeListener != null) && (this.currDragViewHolder != null) && (this.currDragViewHolder.getAdapterPosition() >= 0)) {
          this.mOnItemChangeListener.onItemDelete(this.currDragViewHolder.getAdapterPosition());
        }
      }
      catch (Throwable localThrowable2)
      {
        try
        {
          for (;;)
          {
            if ((this.mOnItemChangeListener != null) && (this.currDragViewHolder != null)) {
              this.mOnItemChangeListener.onDragFinish(this.currDragViewHolder, this.currDragViewHolder.getAdapterPosition());
            }
            this.mAutoScrollEnable = false;
            this.startAutoScrollOffset = 0;
            this.isDragging = false;
            this.mIsDeletePrepared = false;
            this.lastDragX = 0;
            this.lastDragY = 0;
            this.currDragViewHolder = null;
            return;
            localThrowable1 = localThrowable1;
            QLog.e("DragRecycleView", 1, localThrowable1, new Object[0]);
            continue;
            localThrowable2 = localThrowable2;
            QLog.e("DragRecycleView", 1, localThrowable2, new Object[0]);
          }
        }
        catch (Throwable localThrowable3)
        {
          for (;;)
          {
            QLog.e("DragRecycleView", 1, localThrowable3, new Object[0]);
          }
        }
      }
    }
  }
  
  private void onDragMove(int paramInt1, int paramInt2)
  {
    if (!this.isDragging) {}
    label7:
    label100:
    do
    {
      do
      {
        break label7;
        break label7;
        for (;;)
        {
          return;
          if ((Math.abs(this.lastDragX - paramInt1) >= bgtn.b(3.0F)) || (Math.abs(this.lastDragY - paramInt2) >= bgtn.b(3.0F)))
          {
            this.lastDragX = paramInt1;
            this.lastDragY = paramInt2;
            if (this.mOnItemChangeListener != null) {
              this.mOnItemChangeListener.onDragMove(this.lastDragX, this.lastDragY);
            }
            if (paramInt2 >= getHeight() - getResources().getDimensionPixelSize(2131296868))
            {
              this.mCanAutoScroll = true;
              if (this.mOnItemChangeListener == null) {
                break label209;
              }
            }
            for (boolean bool = this.mOnItemChangeListener.isItemDeleteable(this.currDragViewHolder.getAdapterPosition());; bool = false)
            {
              if ((!bool) || (this.mDeleteDragListener == null)) {
                break label212;
              }
              if ((this.mOnItemChangeListener == null) || (!this.mOnItemChangeListener.isMoveToDeleteArea(paramInt1, paramInt2))) {
                break label214;
              }
              if (this.mIsDeletePrepared) {
                break;
              }
              this.mIsDeletePrepared = true;
              this.mDeleteDragListener.onDeleteDragComplete();
              if (this.mOnItemChangeListener == null) {
                break;
              }
              this.mOnItemChangeListener.onItemPrepared(this.currDragViewHolder.getAdapterPosition());
              return;
              this.mCanAutoScroll = false;
              break label100;
            }
          }
        }
      } while (!this.mIsDeletePrepared);
      this.mIsDeletePrepared = false;
      this.mDeleteDragListener.onDeleteDragStart();
    } while (this.mOnItemChangeListener == null);
    label209:
    label212:
    label214:
    this.mOnItemChangeListener.onItemPrepared(-1);
  }
  
  private void onDragStart(RecyclerView.ViewHolder paramViewHolder)
  {
    this.isDragging = true;
    this.currDragViewHolder = paramViewHolder;
    if (paramViewHolder != null)
    {
      QLog.i("DragRecycleView", 1, "onDragStart index:" + paramViewHolder.getAdapterPosition());
      if (this.mOnItemChangeListener != null) {
        this.mOnItemChangeListener.onDragStart(paramViewHolder, paramViewHolder.getAdapterPosition());
      }
      if (this.mOnItemChangeListener == null) {
        break label115;
      }
    }
    label115:
    for (boolean bool = this.mOnItemChangeListener.isItemDeleteable(paramViewHolder.getAdapterPosition());; bool = false)
    {
      if ((bool) && (this.mDeleteDragListener != null)) {
        this.mDeleteDragListener.onDeleteDragStart();
      }
      this.mAutoScrollEnable = true;
      doAutoScroolToBottom();
      return;
    }
  }
  
  private void zoomView(View paramView)
  {
    paramView.setAnimation(this.zoomAnimation);
    this.zoomAnimation.setFillAfter(true);
    this.zoomAnimation.setDuration(200L);
    this.zoomAnimation.start();
  }
  
  public void addChildDragRecycleView(DragRecyclerView paramDragRecyclerView)
  {
    if (!this.children.contains(paramDragRecyclerView)) {
      this.children.add(paramDragRecyclerView);
    }
  }
  
  public View findChildViewAt(float paramFloat1, float paramFloat2)
  {
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      View localView = getChildAt(i);
      float f1 = ViewCompat.getTranslationX(localView);
      float f2 = ViewCompat.getTranslationY(localView);
      if ((paramFloat1 >= localView.getLeft() + f1) && (paramFloat1 <= f1 + localView.getRight()) && (paramFloat2 >= localView.getTop() + f2) && (paramFloat2 <= localView.getBottom() + f2)) {
        return localView;
      }
      i -= 1;
    }
    return null;
  }
  
  public List<DragRecyclerView> getChildRecycleView()
  {
    return new ArrayList(this.children);
  }
  
  public DragRecyclerView.DragDeleteListener getDragDeleteListener()
  {
    return this.mDeleteDragListener;
  }
  
  protected boolean isSlideToBottom()
  {
    return computeVerticalScrollExtent() + computeVerticalScrollOffset() >= computeVerticalScrollRange();
  }
  
  public void onScrollStateChanged(int paramInt)
  {
    super.onScrollStateChanged(paramInt);
  }
  
  public void onScrolled(int paramInt1, int paramInt2)
  {
    super.onScrolled(paramInt1, paramInt2);
    if ((this.autoScrollEnable) && (this.autoScrollStatus))
    {
      this.hasScrolledOffsetX += paramInt1;
      if (Math.abs(paramInt1) <= Math.abs(this.autoScrollOffsetX))
      {
        this.hasScrolledOffsetX = 0;
        smoothScrollBy(this.autoScrollOffsetX, 0);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.isDragging)
    {
      switch (paramMotionEvent.getAction())
      {
      }
      for (;;)
      {
        return true;
        onDragFinish();
        continue;
        onDragMove((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      }
    }
    Iterator localIterator = this.children.iterator();
    while (localIterator.hasNext())
    {
      DragRecyclerView localDragRecyclerView = (DragRecyclerView)localIterator.next();
      if (localDragRecyclerView.isDragging)
      {
        localDragRecyclerView.onTouchEventFromParent(paramMotionEvent, 0);
        if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) {
          return super.onTouchEvent(paramMotionEvent);
        }
        return true;
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEventFromParent(MotionEvent paramMotionEvent, int paramInt)
  {
    boolean bool = false;
    if (this.isDragging)
    {
      this.mAutoScrollEnable = false;
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      bool = true;
      return bool;
      onDragFinish();
      continue;
      onDragMove((int)paramMotionEvent.getX() - getLeft(), (int)paramMotionEvent.getY() - getTop() - paramInt);
    }
  }
  
  public void setAutoScrollEnable(boolean paramBoolean)
  {
    this.autoScrollEnable = paramBoolean;
  }
  
  public DragRecyclerView setDragChangeListener(DragRecyclerView.OnItemChangeListener paramOnItemChangeListener)
  {
    this.mOnItemChangeListener = paramOnItemChangeListener;
    return this;
  }
  
  public void setDragDeleteListener(DragRecyclerView.DragDeleteListener paramDragDeleteListener)
  {
    this.mDeleteDragListener = paramDragDeleteListener;
  }
  
  public void startAutoScrollX(boolean paramBoolean)
  {
    if (!this.autoScrollEnable) {}
    while ((this.autoScrollStatus) && (this.oritationRight == paramBoolean)) {
      return;
    }
    this.autoScrollStatus = true;
    this.oritationRight = paramBoolean;
    if (paramBoolean) {}
    for (int i = this.SCROLL_OFFSET;; i = this.SCROLL_OFFSET * -1)
    {
      this.autoScrollOffsetX = i;
      smoothScrollBy(this.autoScrollOffsetX, 0);
      return;
    }
  }
  
  public void startDrag(int paramInt)
  {
    this.touchHelper.startDrag(getChildViewHolder(getChildAt(paramInt)));
  }
  
  public void startDrag(RecyclerView.ViewHolder paramViewHolder)
  {
    this.touchHelper.startDrag(paramViewHolder);
  }
  
  public void stopAutoScroll()
  {
    this.autoScrollStatus = false;
    this.autoScrollOffsetX = 0;
    this.hasScrolledOffsetX = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.widget.DragRecyclerView
 * JD-Core Version:    0.7.0.1
 */