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
  private int jdField_a_of_type_Int;
  private SparseArray<View> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  protected View a;
  protected QuickRecyclerAdapter.OnItemClickListener a;
  private QuickRecyclerAdapter.OnLoadMoreListener jdField_a_of_type_ComTencentMobileqqTroopAdapterQuickRecyclerAdapter$OnLoadMoreListener;
  protected ItemViewDelegateManager a;
  protected List<T> a;
  protected boolean a;
  protected int b;
  protected Context b;
  private SparseArray<View> jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
  private View jdField_b_of_type_AndroidViewView;
  protected int c = -1;
  
  public QuickRecyclerAdapter(Context paramContext)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqTroopAdapterBaseItemViewDelegateManager = new ItemViewDelegateManager();
  }
  
  private QuickRecyclerAdapter<T> a(QuickRecyclerAdapter.OnLoadMoreListener paramOnLoadMoreListener)
  {
    if (paramOnLoadMoreListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopAdapterQuickRecyclerAdapter$OnLoadMoreListener = paramOnLoadMoreListener;
    }
    return this;
  }
  
  public int a()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public QuickRecyclerAdapter a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public QuickRecyclerAdapter a(ItemViewDelegate<T> paramItemViewDelegate)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopAdapterBaseItemViewDelegateManager.a(paramItemViewDelegate);
    return this;
  }
  
  public ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 2147483646)
    {
      if (this.jdField_a_of_type_AndroidViewView != null) {
        return ViewHolder.a(paramViewGroup.getContext(), this.jdField_a_of_type_AndroidViewView);
      }
      return ViewHolder.a(paramViewGroup.getContext(), paramViewGroup, this.jdField_b_of_type_Int);
    }
    if ((paramInt == 2147483645) && (a()))
    {
      if (this.jdField_b_of_type_AndroidViewView != null) {
        return ViewHolder.a(paramViewGroup.getContext(), this.jdField_b_of_type_AndroidViewView);
      }
      return ViewHolder.a(paramViewGroup.getContext(), paramViewGroup, this.jdField_a_of_type_Int);
    }
    if (paramInt >= 1000000)
    {
      localObject = this.jdField_a_of_type_AndroidUtilSparseArray;
      if ((localObject != null) && (((SparseArray)localObject).get(paramInt) != null)) {
        return ViewHolder.a(paramViewGroup.getContext(), (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt));
      }
    }
    if (paramInt >= 2000000)
    {
      localObject = this.jdField_b_of_type_AndroidUtilSparseArray;
      if ((localObject != null) && (((SparseArray)localObject).get(paramInt) != null)) {
        return ViewHolder.a(paramViewGroup.getContext(), (View)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt));
      }
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqTroopAdapterBaseItemViewDelegateManager.a(paramInt).a();
    Object localObject = b(this.jdField_b_of_type_AndroidContentContext, paramViewGroup, i);
    a((ViewHolder)localObject, ((ViewHolder)localObject).a());
    a(paramViewGroup, (ViewHolder)localObject, paramInt);
    return localObject;
  }
  
  protected T a(int paramInt)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    Object localObject = null;
    if (localList == null) {
      return null;
    }
    paramInt -= b();
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      localObject = this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return localObject;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    notifyDataSetChanged();
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  protected void a(ViewGroup paramViewGroup, ViewHolder paramViewHolder, int paramInt)
  {
    if (!d(paramInt)) {
      return;
    }
    paramViewHolder.a().setOnClickListener(new QuickRecyclerAdapter.2(this, paramViewHolder));
    paramViewHolder.a().setOnLongClickListener(new QuickRecyclerAdapter.3(this, paramViewHolder));
  }
  
  public void a(QuickRecyclerAdapter.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopAdapterQuickRecyclerAdapter$OnItemClickListener = paramOnItemClickListener;
  }
  
  public void a(QuickRecyclerAdapter.OnLoadMoreListener paramOnLoadMoreListener)
  {
    if (a()) {
      return;
    }
    a(paramOnLoadMoreListener);
    this.jdField_a_of_type_Boolean = true;
    notifyDataSetChanged();
  }
  
  public void a(ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    if ((a(paramViewHolder.getLayoutPosition())) || (b(paramViewHolder.getLayoutPosition())) || (c(paramViewHolder.getLayoutPosition())) || (b()))
    {
      paramViewHolder = paramViewHolder.itemView.getLayoutParams();
      if ((paramViewHolder != null) && ((paramViewHolder instanceof StaggeredGridLayoutManager.LayoutParams))) {
        ((StaggeredGridLayoutManager.LayoutParams)paramViewHolder).setFullSpan(true);
      }
    }
  }
  
  public void a(ViewHolder paramViewHolder, int paramInt)
  {
    if ((!a(paramInt)) && (!b(paramInt)) && (!b())) {
      if (c(paramInt))
      {
        QuickRecyclerAdapter.OnLoadMoreListener localOnLoadMoreListener = this.jdField_a_of_type_ComTencentMobileqqTroopAdapterQuickRecyclerAdapter$OnLoadMoreListener;
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
    this.jdField_a_of_type_ComTencentMobileqqTroopAdapterBaseItemViewDelegateManager.a(paramViewHolder, paramT, paramViewHolder.getAdapterPosition());
  }
  
  public void a(List<T> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      if (b())
      {
        notifyItemRemoved(this.c);
        notifyDataSetChanged();
      }
      int i = b();
      int j = a();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      notifyItemRangeInserted(i + j, paramList.size());
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Boolean) && ((this.jdField_b_of_type_AndroidViewView != null) || (this.jdField_a_of_type_Int != 0));
  }
  
  protected boolean a(int paramInt)
  {
    return paramInt < b();
  }
  
  public int b()
  {
    SparseArray localSparseArray = this.jdField_a_of_type_AndroidUtilSparseArray;
    if (localSparseArray != null) {
      return localSparseArray.size();
    }
    return 0;
  }
  
  public ViewHolder b(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    return ViewHolder.a(paramContext, paramViewGroup, paramInt);
  }
  
  public void b()
  {
    if (a())
    {
      a(null);
      this.jdField_a_of_type_Boolean = false;
      notifyDataSetChanged();
    }
  }
  
  protected boolean b()
  {
    return ((this.jdField_a_of_type_AndroidViewView != null) || (this.jdField_b_of_type_Int != 0)) && (a() == 0);
  }
  
  protected boolean b(int paramInt)
  {
    return (paramInt >= a() + b() + e()) && (paramInt < a() + b() + e() + c());
  }
  
  public int c()
  {
    SparseArray localSparseArray = this.jdField_b_of_type_AndroidUtilSparseArray;
    if (localSparseArray != null) {
      return localSparseArray.size();
    }
    return 0;
  }
  
  protected boolean c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopAdapterBaseItemViewDelegateManager.a() > 0;
  }
  
  protected boolean c(int paramInt)
  {
    return (a()) && (paramInt == a() + b() + e() + c());
  }
  
  protected int d()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected boolean d(int paramInt)
  {
    return true;
  }
  
  protected int e()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public int getItemCount()
  {
    return b() + c() + a() + e() + d();
  }
  
  public int getItemViewType(int paramInt)
  {
    if (a(paramInt)) {
      return this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(paramInt);
    }
    if (b())
    {
      int i = this.c;
      if ((i == -1) || (paramInt == i))
      {
        this.c = paramInt;
        return 2147483646;
      }
    }
    if (b(paramInt)) {
      return this.jdField_b_of_type_AndroidUtilSparseArray.keyAt(paramInt - b() - a() - e());
    }
    if (c(paramInt)) {
      return 2147483645;
    }
    if (c()) {
      return this.jdField_a_of_type_ComTencentMobileqqTroopAdapterBaseItemViewDelegateManager.a(a(paramInt), paramInt);
    }
    return super.getItemViewType(paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.adapter.QuickRecyclerAdapter
 * JD-Core Version:    0.7.0.1
 */