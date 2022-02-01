package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.cgi;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.basic.DynamicItemViewHelperCompatBase;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.basic.ProteusSupportUtilBase;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.basic.ReadInJoyDynamicChannelAbstractAdapter;
import com.tencent.mobileqq.kandian.biz.pts.data.DynamicChannelDataModel;
import com.tencent.mobileqq.kandian.biz.pts.item.ProteusItemView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ReadInJoyCGIDynamicChannelAdapter
  extends ReadInJoyDynamicChannelAbstractAdapter<String, DynamicChannelDataModel>
{
  private DynamicItemViewHelperCompatCGI h = new DynamicItemViewHelperCompatCGI();
  
  public ReadInJoyCGIDynamicChannelAdapter(Activity paramActivity, RecyclerViewWithHeaderFooter paramRecyclerViewWithHeaderFooter, int paramInt)
  {
    super(paramActivity, paramRecyclerViewWithHeaderFooter, paramInt);
    this.h.a(this.b, 0);
  }
  
  public BaseViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    boolean bool = this.h.a(paramInt);
    paramViewGroup = null;
    if (bool)
    {
      localObject = (String)this.e.get(Integer.valueOf(paramInt));
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        paramViewGroup = ProteusSupportUtilBase.a(this.b, b(), (String)localObject);
        if ((paramInt == DynamicItemViewHelperCompatBase.c) && (paramViewGroup != null)) {
          paramViewGroup.setVisibility(8);
        }
        QLog.d("ReadInJoyCGIDynamicChannelAdapter", 2, new Object[] { "onCreateViewHolder, viewType = ", Integer.valueOf(paramInt), ", styleID = ", localObject });
      }
      else
      {
        QLog.d("ReadInJoyCGIDynamicChannelAdapter", 2, "onCreateViewHolder styleID is empty");
      }
    }
    else
    {
      QLog.d("ReadInJoyCGIDynamicChannelAdapter", 2, "onCreateViewHolder not the right type");
    }
    Object localObject = paramViewGroup;
    if (paramViewGroup == null)
    {
      localObject = new ProteusItemView(this.b.getContext());
      QLog.d("ReadInJoyCGIDynamicChannelAdapter", 2, "proteusItemView is null");
    }
    return new ReadInJoyCGIDynamicChannelAdapter.CustomViewHolder(this, (View)localObject);
  }
  
  public void a(BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    DynamicChannelDataModel localDynamicChannelDataModel = (DynamicChannelDataModel)a(paramInt);
    int i = paramBaseViewHolder.getItemViewType();
    paramBaseViewHolder = (ProteusItemView)paramBaseViewHolder.itemView;
    if (localDynamicChannelDataModel != null)
    {
      if (this.h.a(i))
      {
        if (i == DynamicItemViewHelperCompatBase.c) {
          paramBaseViewHolder.setVisibility(8);
        } else {
          this.h.a(paramBaseViewHolder, i, localDynamicChannelDataModel, this.b, paramInt);
        }
      }
      else {
        QLog.d("ReadInJoyCGIDynamicChannelAdapter", 1, "onBindViewHolder not the right type");
      }
      a(localDynamicChannelDataModel.uniqueID, localDynamicChannelDataModel);
    }
    QLog.d("ReadInJoyCGIDynamicChannelAdapter", 2, new Object[] { "onBindViewHolder, dataModel = ", localDynamicChannelDataModel, ", proteusItemView = ", paramBaseViewHolder, " , position = ", Integer.valueOf(paramInt), ", type = ", Integer.valueOf(i) });
  }
  
  public long e()
  {
    Object localObject = this.a;
    long l1 = -1L;
    long l2 = l1;
    if (localObject != null)
    {
      l2 = l1;
      if (this.a.size() > 0)
      {
        localObject = this.a.iterator();
        for (;;)
        {
          l2 = l1;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          DynamicChannelDataModel localDynamicChannelDataModel = (DynamicChannelDataModel)((Iterator)localObject).next();
          if (localDynamicChannelDataModel.recommendSeq > l1) {
            l1 = localDynamicChannelDataModel.recommendSeq;
          }
        }
      }
    }
    return l2;
  }
  
  public int getItemViewType(int paramInt)
  {
    Object localObject = (DynamicChannelDataModel)a(paramInt);
    int i = DynamicItemViewHelperCompatBase.c;
    paramInt = i;
    if (localObject != null)
    {
      paramInt = i;
      if (this.h.a((DynamicChannelDataModel)localObject))
      {
        i = this.h.b((DynamicChannelDataModel)localObject);
        localObject = ((DynamicChannelDataModel)localObject).styleID;
        paramInt = i;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          this.e.put(Integer.valueOf(i), localObject);
          paramInt = i;
        }
      }
    }
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.cgi.ReadInJoyCGIDynamicChannelAdapter
 * JD-Core Version:    0.7.0.1
 */