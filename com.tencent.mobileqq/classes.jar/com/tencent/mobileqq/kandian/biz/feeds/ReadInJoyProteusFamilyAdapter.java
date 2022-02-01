package com.tencent.mobileqq.kandian.biz.feeds;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.pts.ReadInjoyContext;
import com.tencent.mobileqq.kandian.biz.pts.util.DynamicItemViewHelper;
import com.tencent.mobileqq.kandian.glue.businesshandler.HandlerFactory;
import com.tencent.mobileqq.kandian.glue.businesshandler.api.IBaseHandler;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.kandian.repo.feeds.RIJBaseItemViewType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class ReadInJoyProteusFamilyAdapter
  extends ReadInJoyBaseAdapter
{
  private static DynamicItemViewHelper C = new DynamicItemViewHelper();
  private VafContext A = new ReadInjoyContext();
  private Activity B;
  private SparseArray<IBaseHandler> D;
  private Context z;
  
  public ReadInJoyProteusFamilyAdapter(Activity paramActivity, LayoutInflater paramLayoutInflater, int paramInt, ListView paramListView, SparseArray<IBaseHandler> paramSparseArray, Context paramContext)
  {
    super(paramActivity, paramLayoutInflater, paramInt, paramListView, paramSparseArray);
    this.B = paramActivity;
    this.z = paramContext;
    this.D = paramSparseArray;
    a(this.D);
    this.A.setContext(paramActivity);
    this.A.setCurActivity(paramActivity);
    ProteusSupportUtil.a(this.A, "default_feeds");
    C.a(this.A);
  }
  
  private void a(SparseArray<IBaseHandler> paramSparseArray)
  {
    this.D = paramSparseArray;
    int i = 0;
    while (i < this.D.size())
    {
      ((IBaseHandler)this.D.valueAt(i)).a(this);
      i += 1;
    }
  }
  
  public Activity a()
  {
    return this.B;
  }
  
  public AbsBaseArticleInfo a(int paramInt, long paramLong)
  {
    return null;
  }
  
  public void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, ArrayList<DislikeInfo> paramArrayList) {}
  
  public void a(int paramInt, ArrayList<AbsBaseArticleInfo> paramArrayList, ArrayList<DislikeInfo> paramArrayList1) {}
  
  public void a(List<AbsBaseArticleInfo> paramList)
  {
    if ((h() != null) && (paramList != null)) {
      h().addAll(paramList);
    }
    HandlerFactory.b(this.D, new ReadInJoyProteusFamilyAdapter.1(this, "onSetData", paramList));
    notifyDataSetChanged();
  }
  
  public AbsBaseArticleInfo b(int paramInt)
  {
    return null;
  }
  
  public boolean b(int paramInt, long paramLong)
  {
    return false;
  }
  
  public int c(int paramInt)
  {
    return RIJBaseItemViewType.c((AbsBaseArticleInfo)getItem(paramInt));
  }
  
  public boolean c(int paramInt, long paramLong)
  {
    return false;
  }
  
  public int getCount()
  {
    if (h() != null) {
      return h().size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return super.getItem(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return c(paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((h() != null) && (h().size() != 0))
    {
      paramView = a(paramInt);
      int i = getItemViewType(paramInt);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getView | position : ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" type : ");
      localStringBuilder.append(i);
      localStringBuilder.append(" article_title = ");
      localStringBuilder.append(paramView.mTitle);
      QLog.d("ReadInJoyProteusFamilyAdapter", 2, localStringBuilder.toString());
      return (View)HandlerFactory.a(this.D, new ReadInJoyProteusFamilyAdapter.2(this, "onAdapterGetView", i, paramView, paramInt, paramViewGroup));
    }
    return null;
  }
  
  public boolean r()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.ReadInJoyProteusFamilyAdapter
 * JD-Core Version:    0.7.0.1
 */