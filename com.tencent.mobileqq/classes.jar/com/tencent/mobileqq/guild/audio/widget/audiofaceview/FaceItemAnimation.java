package com.tencent.mobileqq.guild.audio.widget.audiofaceview;

import android.support.annotation.NonNull;
import android.support.v4.animation.AnimatorCompatHelper;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import androidx.recyclerview.widget.SimpleItemAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FaceItemAnimation
  extends SimpleItemAnimator
{
  private ArrayList<RecyclerView.ViewHolder> a = new ArrayList();
  private ArrayList<RecyclerView.ViewHolder> b = new ArrayList();
  private ArrayList<FaceItemAnimation.MoveInfo> c = new ArrayList();
  private ArrayList<FaceItemAnimation.ChangeInfo> d = new ArrayList();
  private ArrayList<ArrayList<RecyclerView.ViewHolder>> e = new ArrayList();
  private ArrayList<ArrayList<FaceItemAnimation.MoveInfo>> f = new ArrayList();
  private ArrayList<ArrayList<FaceItemAnimation.ChangeInfo>> g = new ArrayList();
  private ArrayList<RecyclerView.ViewHolder> h = new ArrayList();
  private ArrayList<RecyclerView.ViewHolder> i = new ArrayList();
  private ArrayList<RecyclerView.ViewHolder> j = new ArrayList();
  private ArrayList<RecyclerView.ViewHolder> k = new ArrayList();
  private long l = 360L;
  private long m = 280L;
  
  private void a()
  {
    if (!isRunning()) {
      dispatchAnimationsFinished();
    }
  }
  
  private void a(RecyclerView.ViewHolder paramViewHolder)
  {
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = ViewCompat.animate(paramViewHolder.itemView);
    this.j.add(paramViewHolder);
    localViewPropertyAnimatorCompat.setDuration(getRemoveDuration()).alpha(0.0F).translationX(-paramViewHolder.itemView.getWidth()).setListener(new FaceItemAnimation.4(this, paramViewHolder, localViewPropertyAnimatorCompat)).start();
  }
  
  private void a(RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = paramViewHolder.itemView;
    paramInt1 = paramInt3 - paramInt1;
    paramInt2 = paramInt4 - paramInt2;
    if (paramInt1 != 0) {
      ViewCompat.animate((View)localObject).translationX(0.0F);
    }
    if (paramInt2 != 0) {
      ViewCompat.animate((View)localObject).translationY(0.0F);
    }
    localObject = ViewCompat.animate((View)localObject);
    this.i.add(paramViewHolder);
    ((ViewPropertyAnimatorCompat)localObject).setDuration(getMoveDuration()).setListener(new FaceItemAnimation.6(this, paramViewHolder, paramInt1, paramInt2, (ViewPropertyAnimatorCompat)localObject)).start();
  }
  
  private void a(FaceItemAnimation.ChangeInfo paramChangeInfo)
  {
    Object localObject = paramChangeInfo.a;
    View localView = null;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((RecyclerView.ViewHolder)localObject).itemView;
    }
    RecyclerView.ViewHolder localViewHolder = paramChangeInfo.b;
    if (localViewHolder != null) {
      localView = localViewHolder.itemView;
    }
    if (localObject != null)
    {
      localObject = ViewCompat.animate((View)localObject).setDuration(getChangeDuration());
      this.k.add(paramChangeInfo.a);
      ((ViewPropertyAnimatorCompat)localObject).translationX(paramChangeInfo.e - paramChangeInfo.c);
      ((ViewPropertyAnimatorCompat)localObject).translationY(paramChangeInfo.f - paramChangeInfo.d);
      ((ViewPropertyAnimatorCompat)localObject).alpha(1.0F).setListener(new FaceItemAnimation.7(this, paramChangeInfo, (ViewPropertyAnimatorCompat)localObject)).start();
    }
    if (localView != null)
    {
      localObject = ViewCompat.animate(localView);
      this.k.add(paramChangeInfo.b);
      ((ViewPropertyAnimatorCompat)localObject).translationX(0.0F).translationY(0.0F).setDuration(getChangeDuration()).alpha(1.0F).setListener(new FaceItemAnimation.8(this, paramChangeInfo, (ViewPropertyAnimatorCompat)localObject, localView)).start();
    }
  }
  
  private void a(List<FaceItemAnimation.ChangeInfo> paramList, RecyclerView.ViewHolder paramViewHolder)
  {
    int n = paramList.size() - 1;
    while (n >= 0)
    {
      FaceItemAnimation.ChangeInfo localChangeInfo = (FaceItemAnimation.ChangeInfo)paramList.get(n);
      if ((a(localChangeInfo, paramViewHolder)) && (localChangeInfo.a == null) && (localChangeInfo.b == null)) {
        paramList.remove(localChangeInfo);
      }
      n -= 1;
    }
  }
  
  private boolean a(FaceItemAnimation.ChangeInfo paramChangeInfo, RecyclerView.ViewHolder paramViewHolder)
  {
    RecyclerView.ViewHolder localViewHolder = paramChangeInfo.b;
    boolean bool = false;
    if (localViewHolder == paramViewHolder)
    {
      paramChangeInfo.b = null;
    }
    else
    {
      if (paramChangeInfo.a != paramViewHolder) {
        break label69;
      }
      paramChangeInfo.a = null;
      bool = true;
    }
    ViewCompat.setAlpha(paramViewHolder.itemView, 1.0F);
    ViewCompat.setTranslationX(paramViewHolder.itemView, 0.0F);
    ViewCompat.setTranslationY(paramViewHolder.itemView, 0.0F);
    dispatchChangeFinished(paramViewHolder, bool);
    return true;
    label69:
    return false;
  }
  
  private void b(RecyclerView.ViewHolder paramViewHolder)
  {
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = ViewCompat.animate(paramViewHolder.itemView);
    this.h.add(paramViewHolder);
    localViewPropertyAnimatorCompat.alpha(1.0F).translationX(0.0F).setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(getAddDuration()).setListener(new FaceItemAnimation.5(this, paramViewHolder, localViewPropertyAnimatorCompat)).start();
  }
  
  private void b(FaceItemAnimation.ChangeInfo paramChangeInfo)
  {
    if (paramChangeInfo.a != null) {
      a(paramChangeInfo, paramChangeInfo.a);
    }
    if (paramChangeInfo.b != null) {
      a(paramChangeInfo, paramChangeInfo.b);
    }
  }
  
  private void c(RecyclerView.ViewHolder paramViewHolder)
  {
    AnimatorCompatHelper.clearInterpolator(paramViewHolder.itemView);
    endAnimation(paramViewHolder);
  }
  
  void a(List<RecyclerView.ViewHolder> paramList)
  {
    int n = paramList.size() - 1;
    while (n >= 0)
    {
      ViewCompat.animate(((RecyclerView.ViewHolder)paramList.get(n)).itemView).cancel();
      n -= 1;
    }
  }
  
  public boolean animateAdd(RecyclerView.ViewHolder paramViewHolder)
  {
    c(paramViewHolder);
    ViewCompat.setAlpha(paramViewHolder.itemView, 0.0F);
    ViewCompat.setTranslationX(paramViewHolder.itemView, -paramViewHolder.itemView.getWidth());
    this.b.add(paramViewHolder);
    return true;
  }
  
  public boolean animateChange(RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramViewHolder1 == paramViewHolder2) {
      return animateMove(paramViewHolder1, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    float f1 = ViewCompat.getTranslationX(paramViewHolder1.itemView);
    float f2 = ViewCompat.getTranslationY(paramViewHolder1.itemView);
    float f3 = ViewCompat.getAlpha(paramViewHolder1.itemView);
    c(paramViewHolder1);
    int n = (int)(paramInt3 - paramInt1 - f1);
    int i1 = (int)(paramInt4 - paramInt2 - f2);
    ViewCompat.setTranslationX(paramViewHolder1.itemView, f1);
    ViewCompat.setTranslationY(paramViewHolder1.itemView, f2);
    ViewCompat.setAlpha(paramViewHolder1.itemView, f3);
    if (paramViewHolder2 != null)
    {
      c(paramViewHolder2);
      ViewCompat.setTranslationX(paramViewHolder2.itemView, -n);
      ViewCompat.setTranslationY(paramViewHolder2.itemView, -i1);
      ViewCompat.setAlpha(paramViewHolder2.itemView, 1.0F);
    }
    this.d.add(new FaceItemAnimation.ChangeInfo(paramViewHolder1, paramViewHolder2, paramInt1, paramInt2, paramInt3, paramInt4, null));
    return true;
  }
  
  public boolean animateMove(RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = paramViewHolder.itemView;
    paramInt1 = (int)(paramInt1 + ViewCompat.getTranslationX(paramViewHolder.itemView));
    paramInt2 = (int)(paramInt2 + ViewCompat.getTranslationY(paramViewHolder.itemView));
    c(paramViewHolder);
    int n = paramInt3 - paramInt1;
    int i1 = paramInt4 - paramInt2;
    if ((n == 0) && (i1 == 0))
    {
      dispatchMoveFinished(paramViewHolder);
      return false;
    }
    if (n != 0) {
      ViewCompat.setTranslationX(localView, -n);
    }
    if (i1 != 0) {
      ViewCompat.setTranslationY(localView, -i1);
    }
    this.c.add(new FaceItemAnimation.MoveInfo(paramViewHolder, paramInt1, paramInt2, paramInt3, paramInt4, null));
    return true;
  }
  
  public boolean animateRemove(RecyclerView.ViewHolder paramViewHolder)
  {
    c(paramViewHolder);
    this.a.add(paramViewHolder);
    return true;
  }
  
  public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, @NonNull List<Object> paramList)
  {
    return (!paramList.isEmpty()) || (super.canReuseUpdatedViewHolder(paramViewHolder, paramList));
  }
  
  public void endAnimation(RecyclerView.ViewHolder paramViewHolder)
  {
    View localView = paramViewHolder.itemView;
    ViewCompat.animate(localView).cancel();
    int n = this.c.size() - 1;
    while (n >= 0)
    {
      if (((FaceItemAnimation.MoveInfo)this.c.get(n)).a == paramViewHolder)
      {
        ViewCompat.setTranslationY(localView, 0.0F);
        ViewCompat.setTranslationX(localView, 0.0F);
        dispatchMoveFinished(paramViewHolder);
        this.c.remove(n);
      }
      n -= 1;
    }
    a(this.d, paramViewHolder);
    if (this.a.remove(paramViewHolder))
    {
      ViewCompat.setAlpha(localView, 1.0F);
      dispatchRemoveFinished(paramViewHolder);
    }
    if (this.b.remove(paramViewHolder))
    {
      ViewCompat.setAlpha(localView, 1.0F);
      dispatchAddFinished(paramViewHolder);
    }
    n = this.g.size() - 1;
    ArrayList localArrayList;
    while (n >= 0)
    {
      localArrayList = (ArrayList)this.g.get(n);
      a(localArrayList, paramViewHolder);
      if (localArrayList.isEmpty()) {
        this.g.remove(n);
      }
      n -= 1;
    }
    n = this.f.size() - 1;
    while (n >= 0)
    {
      localArrayList = (ArrayList)this.f.get(n);
      int i1 = localArrayList.size() - 1;
      while (i1 >= 0)
      {
        if (((FaceItemAnimation.MoveInfo)localArrayList.get(i1)).a == paramViewHolder)
        {
          ViewCompat.setTranslationY(localView, 0.0F);
          ViewCompat.setTranslationX(localView, 0.0F);
          dispatchMoveFinished(paramViewHolder);
          localArrayList.remove(i1);
          if (!localArrayList.isEmpty()) {
            break;
          }
          this.f.remove(n);
          break;
        }
        i1 -= 1;
      }
      n -= 1;
    }
    n = this.e.size() - 1;
    while (n >= 0)
    {
      localArrayList = (ArrayList)this.e.get(n);
      if (localArrayList.remove(paramViewHolder))
      {
        ViewCompat.setAlpha(localView, 1.0F);
        dispatchAddFinished(paramViewHolder);
        if (localArrayList.isEmpty()) {
          this.e.remove(n);
        }
      }
      n -= 1;
    }
    this.j.remove(paramViewHolder);
    this.h.remove(paramViewHolder);
    this.k.remove(paramViewHolder);
    this.i.remove(paramViewHolder);
    a();
  }
  
  public void endAnimations()
  {
    int n = this.c.size() - 1;
    Object localObject1;
    Object localObject2;
    while (n >= 0)
    {
      localObject1 = (FaceItemAnimation.MoveInfo)this.c.get(n);
      localObject2 = ((FaceItemAnimation.MoveInfo)localObject1).a.itemView;
      ViewCompat.setTranslationY((View)localObject2, 0.0F);
      ViewCompat.setTranslationX((View)localObject2, 0.0F);
      dispatchMoveFinished(((FaceItemAnimation.MoveInfo)localObject1).a);
      this.c.remove(n);
      n -= 1;
    }
    n = this.a.size() - 1;
    while (n >= 0)
    {
      dispatchRemoveFinished((RecyclerView.ViewHolder)this.a.get(n));
      this.a.remove(n);
      n -= 1;
    }
    n = this.b.size() - 1;
    while (n >= 0)
    {
      localObject1 = (RecyclerView.ViewHolder)this.b.get(n);
      ViewCompat.setAlpha(((RecyclerView.ViewHolder)localObject1).itemView, 1.0F);
      dispatchAddFinished((RecyclerView.ViewHolder)localObject1);
      this.b.remove(n);
      n -= 1;
    }
    n = this.d.size() - 1;
    while (n >= 0)
    {
      b((FaceItemAnimation.ChangeInfo)this.d.get(n));
      n -= 1;
    }
    this.d.clear();
    if (!isRunning()) {
      return;
    }
    n = this.f.size() - 1;
    int i1;
    while (n >= 0)
    {
      localObject1 = (ArrayList)this.f.get(n);
      i1 = ((ArrayList)localObject1).size() - 1;
      while (i1 >= 0)
      {
        localObject2 = (FaceItemAnimation.MoveInfo)((ArrayList)localObject1).get(i1);
        View localView = ((FaceItemAnimation.MoveInfo)localObject2).a.itemView;
        ViewCompat.setTranslationY(localView, 0.0F);
        ViewCompat.setTranslationX(localView, 0.0F);
        dispatchMoveFinished(((FaceItemAnimation.MoveInfo)localObject2).a);
        ((ArrayList)localObject1).remove(i1);
        if (((ArrayList)localObject1).isEmpty()) {
          this.f.remove(localObject1);
        }
        i1 -= 1;
      }
      n -= 1;
    }
    n = this.e.size() - 1;
    while (n >= 0)
    {
      localObject1 = (ArrayList)this.e.get(n);
      i1 = ((ArrayList)localObject1).size() - 1;
      while (i1 >= 0)
      {
        localObject2 = (RecyclerView.ViewHolder)((ArrayList)localObject1).get(i1);
        ViewCompat.setAlpha(((RecyclerView.ViewHolder)localObject2).itemView, 1.0F);
        dispatchAddFinished((RecyclerView.ViewHolder)localObject2);
        ((ArrayList)localObject1).remove(i1);
        if (((ArrayList)localObject1).isEmpty()) {
          this.e.remove(localObject1);
        }
        i1 -= 1;
      }
      n -= 1;
    }
    n = this.g.size() - 1;
    while (n >= 0)
    {
      localObject1 = (ArrayList)this.g.get(n);
      i1 = ((ArrayList)localObject1).size() - 1;
      while (i1 >= 0)
      {
        b((FaceItemAnimation.ChangeInfo)((ArrayList)localObject1).get(i1));
        if (((ArrayList)localObject1).isEmpty()) {
          this.g.remove(localObject1);
        }
        i1 -= 1;
      }
      n -= 1;
    }
    a(this.j);
    a(this.i);
    a(this.h);
    a(this.k);
    dispatchAnimationsFinished();
  }
  
  public long getAddDuration()
  {
    return this.l;
  }
  
  public long getChangeDuration()
  {
    return 0L;
  }
  
  public long getMoveDuration()
  {
    return 0L;
  }
  
  public long getRemoveDuration()
  {
    return this.m;
  }
  
  public boolean isRunning()
  {
    return (!this.b.isEmpty()) || (!this.d.isEmpty()) || (!this.c.isEmpty()) || (!this.a.isEmpty()) || (!this.i.isEmpty()) || (!this.j.isEmpty()) || (!this.h.isEmpty()) || (!this.k.isEmpty()) || (!this.f.isEmpty()) || (!this.e.isEmpty()) || (!this.g.isEmpty());
  }
  
  public void runPendingAnimations()
  {
    boolean bool1 = this.a.isEmpty() ^ true;
    boolean bool2 = this.c.isEmpty() ^ true;
    boolean bool3 = this.d.isEmpty() ^ true;
    boolean bool4 = this.b.isEmpty() ^ true;
    if ((!bool1) && (!bool2) && (!bool4) && (!bool3)) {
      return;
    }
    Object localObject1 = this.a.iterator();
    while (((Iterator)localObject1).hasNext()) {
      a((RecyclerView.ViewHolder)((Iterator)localObject1).next());
    }
    this.a.clear();
    Object localObject2;
    if (bool2)
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.c);
      this.f.add(localObject1);
      this.c.clear();
      localObject2 = new FaceItemAnimation.1(this, (ArrayList)localObject1);
      if (bool1) {
        ViewCompat.postOnAnimationDelayed(((FaceItemAnimation.MoveInfo)((ArrayList)localObject1).get(0)).a.itemView, (Runnable)localObject2, getRemoveDuration());
      } else {
        ((Runnable)localObject2).run();
      }
    }
    if (bool3)
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.d);
      this.g.add(localObject1);
      this.d.clear();
      localObject2 = new FaceItemAnimation.2(this, (ArrayList)localObject1);
      if (bool1) {
        ViewCompat.postOnAnimationDelayed(((FaceItemAnimation.ChangeInfo)((ArrayList)localObject1).get(0)).a.itemView, (Runnable)localObject2, getRemoveDuration());
      } else {
        ((Runnable)localObject2).run();
      }
    }
    if (bool4)
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.b);
      this.e.add(localObject1);
      this.b.clear();
      localObject2 = new FaceItemAnimation.3(this, (ArrayList)localObject1);
      if ((!bool1) && (!bool2) && (!bool3))
      {
        ((Runnable)localObject2).run();
        return;
      }
      long l3 = 0L;
      long l1;
      if (bool1) {
        l1 = getRemoveDuration();
      } else {
        l1 = 0L;
      }
      if (bool2) {
        l2 = getMoveDuration();
      } else {
        l2 = 0L;
      }
      if (bool3) {
        l3 = getChangeDuration();
      }
      long l2 = Math.max(l2, l3);
      ViewCompat.postOnAnimationDelayed(((RecyclerView.ViewHolder)((ArrayList)localObject1).get(0)).itemView, (Runnable)localObject2, l1 + l2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.widget.audiofaceview.FaceItemAnimation
 * JD-Core Version:    0.7.0.1
 */