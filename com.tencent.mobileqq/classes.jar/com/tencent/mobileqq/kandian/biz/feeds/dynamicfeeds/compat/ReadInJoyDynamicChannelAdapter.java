package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.compat;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyBaseAdapterInterface;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyListViewGroup;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.basic.DynamicItemViewHelperCompatBase;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.basic.ProteusSupportUtilBase;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.basic.ReadInJoyDynamicChannelAbstractAdapter;
import com.tencent.mobileqq.kandian.biz.pts.item.ProteusItemView;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.fastweb.FastWebModule;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyDynamicChannelAdapter
  extends ReadInJoyDynamicChannelAbstractAdapter<Long, AbsBaseArticleInfo>
  implements ReadInJoyBaseAdapterInterface
{
  private int h = -1;
  private DynamicItemViewHelperCompat i = new DynamicItemViewHelperCompat();
  private View.OnClickListener j = new ReadInJoyDynamicChannelAdapter.1(this);
  
  public ReadInJoyDynamicChannelAdapter(Activity paramActivity, RecyclerViewWithHeaderFooter paramRecyclerViewWithHeaderFooter, int paramInt)
  {
    super(paramActivity, paramRecyclerViewWithHeaderFooter, paramInt);
    this.i.a(this.b, 3);
  }
  
  private void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    try
    {
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.proteusItemsData))
      {
        paramAbsBaseArticleInfo = new JSONObject(paramAbsBaseArticleInfo.proteusItemsData).getString("style_ID");
        if (!TextUtils.isEmpty(paramAbsBaseArticleInfo))
        {
          QLog.d("ReadInJoyDynamicChannelAdapter", 2, new Object[] { "addViewTypeStyleMap, adapterViewType = ", Integer.valueOf(paramInt), ", styleID = ", paramAbsBaseArticleInfo });
          this.e.put(Integer.valueOf(paramInt), paramAbsBaseArticleInfo);
          return;
        }
        QLog.d("ReadInJoyDynamicChannelAdapter", 2, "addViewTypeStyleMap, styleID is null");
        return;
      }
      QLog.d("ReadInJoyDynamicChannelAdapter", 2, "addViewTypeStyleMap, proteusItemData is empty");
      return;
    }
    catch (JSONException paramAbsBaseArticleInfo)
    {
      QLog.d("ReadInJoyDynamicChannelAdapter", 1, "addViewTypeStyleMap, e", paramAbsBaseArticleInfo);
    }
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    FastWebModule localFastWebModule = ReadInJoyLogicEngine.a().d();
    AbsBaseArticleInfo localAbsBaseArticleInfo = paramAbsBaseArticleInfo;
    if (RIJFeedsType.l(paramAbsBaseArticleInfo))
    {
      localAbsBaseArticleInfo = paramAbsBaseArticleInfo;
      if (!paramAbsBaseArticleInfo.mNewPolymericInfo.a) {
        localAbsBaseArticleInfo = ReadInJoyListViewGroup.a(paramAbsBaseArticleInfo);
      }
    }
    if (localFastWebModule != null) {
      this.h = localFastWebModule.a(localAbsBaseArticleInfo.mArticleContentUrl, String.valueOf(localAbsBaseArticleInfo.innerUniqueID), localAbsBaseArticleInfo.mSubscribeID, 1, null);
    }
    b(localAbsBaseArticleInfo);
  }
  
  private AbsBaseArticleInfo b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size())) {
      return (AbsBaseArticleInfo)this.a.get(paramInt);
    }
    return null;
  }
  
  private void b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null)
    {
      QLog.d("ReadInJoyDynamicChannelAdapter", 2, "startWebFastActivity, articleInfo is null.");
      return;
    }
    RIJJumpUtils.a((Activity)this.c, paramAbsBaseArticleInfo);
  }
  
  public BaseViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    boolean bool = this.i.a(paramInt);
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
        QLog.d("ReadInJoyDynamicChannelAdapter", 2, new Object[] { "onCreateViewHolder, viewType = ", Integer.valueOf(paramInt), ", styleID =", localObject });
      }
      else
      {
        QLog.d("ReadInJoyDynamicChannelAdapter", 2, "onCreateViewHolder styleID is empty");
      }
    }
    else if (ProteusSupportUtilDynamic.a(paramInt))
    {
      paramViewGroup = ProteusSupportUtilDynamic.a(this.b, paramInt, b());
    }
    else
    {
      QLog.d("ReadInJoyDynamicChannelAdapter", 1, "onCreateViewHolder not the right type");
    }
    Object localObject = paramViewGroup;
    if (paramViewGroup == null)
    {
      localObject = new ProteusItemView(this.b.getContext());
      QLog.d("ReadInJoyDynamicChannelAdapter", 2, "proteusItemView is null");
    }
    QLog.d("ReadInJoyDynamicChannelAdapter", 2, new Object[] { "onCreateViewHolder, proteusItemView = ", localObject, ", viewType = ", Integer.valueOf(paramInt) });
    return new ReadInJoyDynamicChannelAdapter.CustomViewHolder(this, (View)localObject);
  }
  
  public void a(int paramInt, View paramView)
  {
    paramView = b(paramInt);
    if (paramView == null)
    {
      QLog.d("ReadInJoyDynamicChannelAdapter", 1, "onItemClick articleInfo is null.");
      return;
    }
    if (RIJFeedsType.a(paramView.mArticleContentUrl, paramView.mChannelID, paramView)) {
      a(paramView);
    }
  }
  
  public void a(BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = b(paramInt);
    int k = paramBaseViewHolder.getItemViewType();
    paramBaseViewHolder = (ProteusItemView)paramBaseViewHolder.itemView;
    if (localAbsBaseArticleInfo != null)
    {
      if (this.i.a(k))
      {
        if (k == DynamicItemViewHelperCompatBase.c) {
          paramBaseViewHolder.setVisibility(8);
        } else {
          this.i.a(paramBaseViewHolder, k, localAbsBaseArticleInfo, this.b, paramInt);
        }
      }
      else if (ProteusSupportUtilDynamic.a(k)) {
        ProteusSupportUtilDynamic.a(paramBaseViewHolder, k, localAbsBaseArticleInfo, this.b, paramInt, b());
      } else {
        QLog.d("ReadInJoyDynamicChannelAdapter", 1, "onBindViewHolder not the right type");
      }
      a(Long.valueOf(localAbsBaseArticleInfo.mArticleID), localAbsBaseArticleInfo);
    }
    QLog.d("ReadInJoyDynamicChannelAdapter", 2, new Object[] { "onBindViewHolder, articleInfo = ", localAbsBaseArticleInfo, ", proteusItemView = ", paramBaseViewHolder, ", position = ", Integer.valueOf(paramInt), ", type = ", Integer.valueOf(k) });
  }
  
  public void e()
  {
    FastWebModule localFastWebModule = ((ReadInJoyLogicManager)ReadInJoyUtils.b().getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).getReadInJoyLogicEngine().d();
    if (localFastWebModule != null) {
      localFastWebModule.a(this.h);
    }
    if (this.e != null) {
      this.e.clear();
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = b(paramInt);
    if (localAbsBaseArticleInfo != null)
    {
      if (this.i.a(localAbsBaseArticleInfo))
      {
        paramInt = this.i.b(localAbsBaseArticleInfo);
        a(paramInt, localAbsBaseArticleInfo);
        return paramInt;
      }
      if (localAbsBaseArticleInfo.mShowBigPicture) {
        return 2;
      }
      if (!TextUtils.isEmpty(localAbsBaseArticleInfo.mFirstPagePicUrl)) {
        return 1;
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.compat.ReadInJoyDynamicChannelAdapter
 * JD-Core Version:    0.7.0.1
 */