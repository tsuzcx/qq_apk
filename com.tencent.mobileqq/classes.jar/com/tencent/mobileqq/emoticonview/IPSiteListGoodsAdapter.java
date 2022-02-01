package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.EmotionUtils;
import com.tencent.mobileqq.data.IPSiteModel.Goods;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;

public class IPSiteListGoodsAdapter
  extends BaseAdapter
{
  private static int MAX_ITEM_SIZE = 6;
  private String ipId;
  private Context mContext;
  private Drawable mDefaultDrawable;
  private List<Object> mGoodsList;
  private URLDrawable.URLDrawableListener mURLDrawableListener;
  private String netStr;
  private String uin;
  
  public IPSiteListGoodsAdapter(Context paramContext, List<Object> paramList, URLDrawable.URLDrawableListener paramURLDrawableListener, Drawable paramDrawable, String paramString1, String paramString2, String paramString3)
  {
    this.mContext = paramContext;
    this.mGoodsList = paramList;
    this.mURLDrawableListener = paramURLDrawableListener;
    this.mDefaultDrawable = paramDrawable;
    this.uin = paramString1;
    this.ipId = paramString2;
    this.netStr = paramString3;
  }
  
  public int getCount()
  {
    List localList = this.mGoodsList;
    if (localList != null)
    {
      int i = localList.size();
      int j = MAX_ITEM_SIZE;
      if (i > j) {
        return j + 1;
      }
      return i + 1;
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject3;
    Object localObject1;
    Object localObject2;
    Object localObject4;
    Object localObject5;
    if (paramInt < getCount() - 1)
    {
      localObject3 = (IPSiteModel.Goods)this.mGoodsList.get(paramInt);
      if (paramView == null)
      {
        paramView = LayoutInflater.from(this.mContext).inflate(2131561600, null, false);
        localObject1 = new IPSiteListGoodsAdapter.Holder(this, null);
        ((IPSiteListGoodsAdapter.Holder)localObject1).itemLayout = ((RelativeLayout)paramView);
        ((IPSiteListGoodsAdapter.Holder)localObject1).cover = ((ImageView)paramView.findViewById(2131362395));
        ((IPSiteListGoodsAdapter.Holder)localObject1).title = ((TextView)paramView.findViewById(2131362396));
        ((IPSiteListGoodsAdapter.Holder)localObject1).desc = ((TextView)paramView.findViewById(2131362394));
        paramView.setTag(localObject1);
      }
      else
      {
        localObject1 = (IPSiteListGoodsAdapter.Holder)paramView.getTag();
      }
      localObject2 = paramView;
      if (localObject3 != null)
      {
        ((IPSiteListGoodsAdapter.Holder)localObject1).cover.setImageDrawable(IPSiteUtil.getIPSiteDrawable(((IPSiteModel.Goods)localObject3).cover, this.mURLDrawableListener, this.mDefaultDrawable));
        ((IPSiteListGoodsAdapter.Holder)localObject1).title.setText(((IPSiteModel.Goods)localObject3).name);
        if (!TextUtils.isEmpty(((IPSiteModel.Goods)localObject3).saleNum)) {
          localObject2 = ((IPSiteModel.Goods)localObject3).saleNum;
        } else {
          localObject2 = "0";
        }
        localObject4 = ((IPSiteListGoodsAdapter.Holder)localObject1).desc;
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append((String)localObject2);
        ((StringBuilder)localObject5).append(this.mContext.getString(2131699711));
        ((TextView)localObject4).setText(((StringBuilder)localObject5).toString());
        ((IPSiteListGoodsAdapter.Holder)localObject1).itemLayout.setOnClickListener(new IPSiteListGoodsAdapter.1(this, (IPSiteModel.Goods)localObject3));
        localObject2 = paramView;
      }
    }
    else
    {
      paramView = (IPSiteModel.Goods)this.mGoodsList.get(0);
      localObject2 = new RelativeLayout(this.mContext);
      ((RelativeLayout)localObject2).setBackgroundColor(Color.parseColor("#fafafa"));
      localObject1 = new AbsListView.LayoutParams(EmotionUtils.a(75.0F, this.mContext.getResources()), EmotionUtils.a(75.0F, this.mContext.getResources()));
      ((RelativeLayout)localObject2).setMinimumWidth(EmotionUtils.a(75.0F, this.mContext.getResources()));
      ((RelativeLayout)localObject2).setMinimumHeight(EmotionUtils.a(75.0F, this.mContext.getResources()));
      ((RelativeLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = new RelativeLayout(this.mContext);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(15);
      ((RelativeLayout.LayoutParams)localObject3).addRule(14);
      ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      localObject3 = new TextView(this.mContext);
      ((TextView)localObject3).setId(2131362404);
      ((TextView)localObject3).setTextSize(12.0F);
      ((TextView)localObject3).setTextColor(Color.parseColor("#777777"));
      ((TextView)localObject3).setText(this.mContext.getString(2131699737));
      ((TextView)localObject3).setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
      localObject4 = new ImageView(this.mContext);
      ((ImageView)localObject4).setImageResource(2130846444);
      localObject5 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject5).addRule(1, 2131362404);
      ((RelativeLayout.LayoutParams)localObject5).addRule(15);
      ((RelativeLayout.LayoutParams)localObject5).leftMargin = EmotionUtils.a(2.0F, this.mContext.getResources());
      ((ImageView)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject5);
      ((RelativeLayout)localObject1).addView((View)localObject3);
      ((RelativeLayout)localObject1).addView((View)localObject4);
      ((RelativeLayout)localObject2).addView((View)localObject1);
      ((RelativeLayout)localObject2).setOnClickListener(new IPSiteListGoodsAdapter.2(this, paramView));
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject2, paramViewGroup, getItemId(paramInt));
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.IPSiteListGoodsAdapter
 * JD-Core Version:    0.7.0.1
 */