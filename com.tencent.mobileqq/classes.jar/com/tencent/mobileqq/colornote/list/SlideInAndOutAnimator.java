package com.tencent.mobileqq.colornote.list;

import android.support.v4.animation.AnimatorCompatHelper;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.widget.RecyclerView.ItemAnimator.ItemAnimatorFinishedListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SlideInAndOutAnimator
  extends SimpleItemAnimator
{
  private ArrayList<RecyclerView.ViewHolder> a = new ArrayList();
  private ArrayList<SlideInAndOutAnimator.MoveInfo> b = new ArrayList();
  private ArrayList<RecyclerView.ViewHolder> c = new ArrayList();
  private ArrayList<RecyclerView.ViewHolder> d = new ArrayList();
  private ArrayList<RecyclerView.ViewHolder> e = new ArrayList();
  private ArrayList<RecyclerView.ViewHolder> f = new ArrayList();
  private boolean g = true;
  private RecyclerView.ItemAnimator.ItemAnimatorFinishedListener h;
  
  private void a()
  {
    if (!isRunning()) {
      dispatchAnimationsFinished();
    }
  }
  
  private void a(RecyclerView.ViewHolder paramViewHolder)
  {
    View localView = paramViewHolder.itemView;
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = ViewCompat.animate(localView);
    this.d.add(paramViewHolder);
    int j = localView.getMeasuredWidth();
    int i = j;
    if (!this.g) {
      i = -j;
    }
    localViewPropertyAnimatorCompat.setDuration(getRemoveDuration()).alpha(0.0F).translationX(i).setListener(new SlideInAndOutAnimator.1(this, paramViewHolder, localViewPropertyAnimatorCompat)).start();
  }
  
  private void a(RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = paramViewHolder.itemView;
    paramInt1 = paramInt4 - paramInt2;
    ViewPropertyAnimator localViewPropertyAnimator1 = localView.animate();
    this.e.add(paramViewHolder);
    ViewPropertyAnimator localViewPropertyAnimator2 = localViewPropertyAnimator1.setDuration(getMoveDuration());
    float f1;
    if (paramInt1 != 0) {
      f1 = 0.0F;
    } else {
      f1 = -paramViewHolder.itemView.getHeight();
    }
    localViewPropertyAnimator2.translationY(f1).setInterpolator(new DecelerateInterpolator()).setListener(new SlideInAndOutAnimator.3(this, paramViewHolder, paramInt1, localView, localViewPropertyAnimator1)).start();
  }
  
  private void b(RecyclerView.ViewHolder paramViewHolder)
  {
    View localView = paramViewHolder.itemView;
    ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
    this.f.add(paramViewHolder);
    localViewPropertyAnimator.alpha(1.0F).setDuration(getAddDuration()).translationX(0.0F).setInterpolator(new DecelerateInterpolator()).setListener(new SlideInAndOutAnimator.2(this, paramViewHolder, localView, localViewPropertyAnimator)).start();
  }
  
  private void c(RecyclerView.ViewHolder paramViewHolder)
  {
    AnimatorCompatHelper.clearInterpolator(paramViewHolder.itemView);
    endAnimation(paramViewHolder);
  }
  
  void a(List<RecyclerView.ViewHolder> paramList)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      ViewCompat.animate(((RecyclerView.ViewHolder)paramList.get(i)).itemView).cancel();
      i -= 1;
    }
  }
  
  public boolean animateAdd(RecyclerView.ViewHolder paramViewHolder)
  {
    c(paramViewHolder);
    paramViewHolder.itemView.setAlpha(0.0F);
    View localView = paramViewHolder.itemView;
    int i;
    if (this.g) {
      i = paramViewHolder.itemView.getWidth();
    } else {
      i = -paramViewHolder.itemView.getWidth();
    }
    localView.setTranslationX(i);
    this.c.add(paramViewHolder);
    return true;
  }
  
  public boolean animateChange(RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return false;
  }
  
  public boolean animateMove(RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = paramViewHolder.itemView;
    paramInt1 = (int)(paramInt1 + ViewCompat.getTranslationX(paramViewHolder.itemView));
    paramInt2 = (int)(paramInt2 + ViewCompat.getTranslationY(paramViewHolder.itemView));
    c(paramViewHolder);
    int i = paramInt3 - paramInt1;
    int j = paramInt4 - paramInt2;
    if ((i == 0) && (j == 0))
    {
      dispatchMoveFinished(paramViewHolder);
      return false;
    }
    if (i != 0) {
      ViewCompat.setTranslationX(localView, -i);
    }
    if (j != 0) {
      ViewCompat.setTranslationY(localView, -j);
    }
    this.b.add(new SlideInAndOutAnimator.MoveInfo(paramViewHolder, paramInt1, paramInt2, paramInt3, paramInt4, null));
    return true;
  }
  
  public boolean animateRemove(RecyclerView.ViewHolder paramViewHolder)
  {
    c(paramViewHolder);
    this.a.add(paramViewHolder);
    return true;
  }
  
  public void endAnimation(RecyclerView.ViewHolder paramViewHolder)
  {
    View localView = paramViewHolder.itemView;
    int i = this.b.size() - 1;
    while (i >= 0)
    {
      if (((SlideInAndOutAnimator.MoveInfo)this.b.get(i)).a == paramViewHolder)
      {
        localView.setTranslationY(0.0F);
        dispatchMoveFinished(paramViewHolder);
        this.b.remove(i);
      }
      i -= 1;
    }
    if (this.c.remove(paramViewHolder))
    {
      localView.setAlpha(1.0F);
      localView.setTranslationY(0.0F);
      dispatchAddFinished(paramViewHolder);
    }
    if (this.a.remove(paramViewHolder))
    {
      localView.setAlpha(0.0F);
      dispatchRemoveFinished(paramViewHolder);
    }
    a();
  }
  
  public void endAnimations()
  {
    int i = this.b.size() - 1;
    Object localObject;
    while (i >= 0)
    {
      localObject = (SlideInAndOutAnimator.MoveInfo)this.b.get(i);
      ((SlideInAndOutAnimator.MoveInfo)localObject).a.itemView.setTranslationY(0.0F);
      dispatchMoveFinished(((SlideInAndOutAnimator.MoveInfo)localObject).a);
      this.b.remove(i);
      i -= 1;
    }
    i = this.a.size() - 1;
    while (i >= 0)
    {
      dispatchRemoveFinished((RecyclerView.ViewHolder)this.a.get(i));
      this.a.remove(i);
      i -= 1;
    }
    i = this.c.size() - 1;
    while (i >= 0)
    {
      localObject = (RecyclerView.ViewHolder)this.c.get(i);
      ((RecyclerView.ViewHolder)localObject).itemView.setAlpha(1.0F);
      ((RecyclerView.ViewHolder)localObject).itemView.setTranslationY(0.0F);
      dispatchAddFinished((RecyclerView.ViewHolder)localObject);
      this.c.remove(i);
      i -= 1;
    }
    if (isRunning())
    {
      a(this.d);
      a(this.e);
      a(this.f);
      dispatchAnimationsFinished();
    }
  }
  
  public boolean isRunning()
  {
    return (!this.c.isEmpty()) || (!this.a.isEmpty()) || (!this.d.isEmpty()) || (!this.b.isEmpty()) || (!this.e.isEmpty()) || (!this.f.isEmpty());
  }
  
  public void onAnimationFinished(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onAnimationFinished(paramViewHolder);
    paramViewHolder = this.h;
    if (paramViewHolder != null) {
      paramViewHolder.onAnimationsFinished();
    }
  }
  
  public void runPendingAnimations()
  {
    boolean bool1 = this.a.isEmpty() ^ true;
    boolean bool2 = this.b.isEmpty() ^ true;
    boolean bool3 = this.c.isEmpty() ^ true;
    if ((!bool1) && (!bool2) && (!bool3)) {
      return;
    }
    Object localObject;
    if (bool1)
    {
      localObject = this.a.iterator();
      while (((Iterator)localObject).hasNext()) {
        a((RecyclerView.ViewHolder)((Iterator)localObject).next());
      }
    }
    Iterator localIterator;
    if (bool2)
    {
      localObject = new ArrayList(this.b);
      this.b.clear();
      localIterator = ((ArrayList)localObject).iterator();
      while (localIterator.hasNext())
      {
        SlideInAndOutAnimator.MoveInfo localMoveInfo = (SlideInAndOutAnimator.MoveInfo)localIterator.next();
        a(localMoveInfo.a, localMoveInfo.b, localMoveInfo.c, localMoveInfo.d, localMoveInfo.e);
      }
      ((ArrayList)localObject).clear();
    }
    if (bool3)
    {
      localObject = new ArrayList(this.c);
      this.c.clear();
      localIterator = ((ArrayList)localObject).iterator();
      while (localIterator.hasNext()) {
        b((RecyclerView.ViewHolder)localIterator.next());
      }
      ((ArrayList)localObject).clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.list.SlideInAndOutAnimator
 * JD-Core Version:    0.7.0.1
 */