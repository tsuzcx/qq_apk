package com.tencent.mobileqq.troop.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.troop.adapter.base.ItemViewDelegate;
import com.tencent.mobileqq.troop.adapter.base.ItemViewDelegateManager;
import com.tencent.mobileqq.troop.adapter.base.ViewHolder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class QuickRecyclerAdapter<T>
  extends RecyclerView.Adapter<ViewHolder>
{
  private SparseArray<View> a = new SparseArray();
  private SparseArray<View> b = new SparseArray();
  private View c;
  private int d;
  protected Context e;
  protected List<T> f = new ArrayList();
  protected ItemViewDelegateManager g;
  protected QuickRecyclerAdapter.OnItemClickListener h;
  protected View i;
  protected int j;
  protected int k = -1;
  protected boolean l = false;
  private QuickRecyclerAdapter.OnLoadMoreListener m;
  
  public QuickRecyclerAdapter(Context paramContext)
  {
    this.e = paramContext;
    this.g = new ItemViewDelegateManager();
  }
  
  private QuickRecyclerAdapter<T> b(QuickRecyclerAdapter.OnLoadMoreListener paramOnLoadMoreListener)
  {
    if (paramOnLoadMoreListener != null) {
      this.m = paramOnLoadMoreListener;
    }
    return this;
  }
  
  public int a()
  {
    List localList = this.f;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public QuickRecyclerAdapter a(ItemViewDelegate<T> paramItemViewDelegate)
  {
    this.g.a(paramItemViewDelegate);
    return this;
  }
  
  public ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 2147483646)
    {
      if (this.i != null) {
        return ViewHolder.a(paramViewGroup.getContext(), this.i);
      }
      return ViewHolder.a(paramViewGroup.getContext(), paramViewGroup, this.j);
    }
    if ((paramInt == 2147483645) && (d()))
    {
      if (this.c != null) {
        return ViewHolder.a(paramViewGroup.getContext(), this.c);
      }
      return ViewHolder.a(paramViewGroup.getContext(), paramViewGroup, this.d);
    }
    if (paramInt >= 1000000)
    {
      localObject = this.a;
      if ((localObject != null) && (((SparseArray)localObject).get(paramInt) != null)) {
        return ViewHolder.a(paramViewGroup.getContext(), (View)this.a.get(paramInt));
      }
    }
    if (paramInt >= 2000000)
    {
      localObject = this.b;
      if ((localObject != null) && (((SparseArray)localObject).get(paramInt) != null)) {
        return ViewHolder.a(paramViewGroup.getContext(), (View)this.b.get(paramInt));
      }
    }
    int n = this.g.a(paramInt).a();
    Object localObject = b(this.e, paramViewGroup, n);
    a((ViewHolder)localObject, ((ViewHolder)localObject).a());
    a(paramViewGroup, (ViewHolder)localObject, paramInt);
    return localObject;
  }
  
  protected T a(int paramInt)
  {
    List localList = this.f;
    Object localObject = null;
    if (localList == null) {
      return null;
    }
    paramInt -= f();
    if (paramInt < this.f.size()) {
      localObject = this.f.get(paramInt);
    }
    return localObject;
  }
  
  public void a(View paramView)
  {
    this.i = paramView;
  }
  
  protected void a(ViewGroup paramViewGroup, ViewHolder paramViewHolder, int paramInt)
  {
    if (!g(paramInt)) {
      return;
    }
    paramViewHolder.a().setOnClickListener(new QuickRecyclerAdapter.2(this, paramViewHolder));
    paramViewHolder.a().setOnLongClickListener(new QuickRecyclerAdapter.3(this, paramViewHolder));
  }
  
  public void a(QuickRecyclerAdapter.OnItemClickListener paramOnItemClickListener)
  {
    this.h = paramOnItemClickListener;
  }
  
  public void a(QuickRecyclerAdapter.OnLoadMoreListener paramOnLoadMoreListener)
  {
    if (d()) {
      return;
    }
    b(paramOnLoadMoreListener);
    this.l = true;
    notifyDataSetChanged();
  }
  
  public void a(ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    if ((b(paramViewHolder.getLayoutPosition())) || (c(paramViewHolder.getLayoutPosition())) || (d(paramViewHolder.getLayoutPosition())) || (e()))
    {
      paramViewHolder = paramViewHolder.itemView.getLayoutParams();
      if ((paramViewHolder != null) && ((paramViewHolder instanceof StaggeredGridLayoutManager.LayoutParams))) {
        ((StaggeredGridLayoutManager.LayoutParams)paramViewHolder).setFullSpan(true);
      }
    }
  }
  
  public void a(ViewHolder paramViewHolder, int paramInt)
  {
    if ((!b(paramInt)) && (!c(paramInt)) && (!e())) {
      if (d(paramInt))
      {
        QuickRecyclerAdapter.OnLoadMoreListener localOnLoadMoreListener = this.m;
        if (localOnLoadMoreListener != null) {
          localOnLoadMoreListener.a();
        }
      }
      else
      {
        a(paramViewHolder, a(paramInt));
      }
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void a(ViewHolder paramViewHolder, View paramView) {}
  
  public void a(ViewHolder paramViewHolder, T paramT)
  {
    this.g.a(paramViewHolder, paramT, paramViewHolder.getAdapterPosition());
  }
  
  public void a(List<T> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      if (e())
      {
        notifyItemRemoved(this.k);
        notifyDataSetChanged();
      }
      int n = f();
      int i1 = a();
      this.f.addAll(paramList);
      notifyItemRangeInserted(n + i1, paramList.size());
    }
  }
  
  public ViewHolder b(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    return ViewHolder.a(paramContext, paramViewGroup, paramInt);
  }
  
  public void b()
  {
    this.f.clear();
    notifyDataSetChanged();
  }
  
  protected boolean b(int paramInt)
  {
    return paramInt < f();
  }
  
  public void c()
  {
    if (d())
    {
      b(null);
      this.l = false;
      notifyDataSetChanged();
    }
  }
  
  protected boolean c(int paramInt)
  {
    return (paramInt >= a() + f() + i()) && (paramInt < a() + f() + i() + g());
  }
  
  public boolean d()
  {
    return (this.l) && ((this.c != null) || (this.d != 0));
  }
  
  protected boolean d(int paramInt)
  {
    return (d()) && (paramInt == a() + f() + i() + g());
  }
  
  public QuickRecyclerAdapter e(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
  
  protected boolean e()
  {
    return ((this.i != null) || (this.j != 0)) && (a() == 0);
  }
  
  public int f()
  {
    SparseArray localSparseArray = this.a;
    if (localSparseArray != null) {
      return localSparseArray.size();
    }
    return 0;
  }
  
  public void f(int paramInt)
  {
    this.j = paramInt;
  }
  
  public int g()
  {
    SparseArray localSparseArray = this.b;
    if (localSparseArray != null) {
      return localSparseArray.size();
    }
    return 0;
  }
  
  protected boolean g(int paramInt)
  {
    return true;
  }
  
  public int getItemCount()
  {
    return f() + g() + a() + i() + h();
  }
  
  public int getItemViewType(int paramInt)
  {
    if (b(paramInt)) {
      return this.a.keyAt(paramInt);
    }
    if (e())
    {
      int n = this.k;
      if ((n == -1) || (paramInt == n))
      {
        this.k = paramInt;
        return 2147483646;
      }
    }
    if (c(paramInt)) {
      return this.b.keyAt(paramInt - f() - a() - i());
    }
    if (d(paramInt)) {
      return 2147483645;
    }
    if (j()) {
      return this.g.a(a(paramInt), paramInt);
    }
    return super.getItemViewType(paramInt);
  }
  
  protected int h()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected int i()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected boolean j()
  {
    return this.g.a() > 0;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if ((paramRecyclerView instanceof GridLayoutManager))
    {
      paramRecyclerView = (GridLayoutManager)paramRecyclerView;
      paramRecyclerView.setSpanSizeLookup(new QuickRecyclerAdapter.1(this, paramRecyclerView));
      paramRecyclerView.setSpanCount(paramRecyclerView.getSpanCount());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.adapter.QuickRecyclerAdapter
 * JD-Core Version:    0.7.0.1
 */