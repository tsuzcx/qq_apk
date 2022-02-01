package com.tencent.mobileqq.mini.out.activity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.proto.lbsshare.LBSShare.POI;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class POIAdapter
  extends BaseAdapter
{
  protected int blueColor;
  public boolean hasMore = true;
  protected LayoutInflater mInflater;
  public int nextBegin;
  protected List<LBSShare.POI> poiList = new ArrayList();
  public int selectPos = -1;
  protected int textBlack;
  protected int textGray;
  
  public POIAdapter(Context paramContext)
  {
    this.mInflater = LayoutInflater.from(paramContext);
    this.blueColor = Color.rgb(0, 121, 255);
    ThemeUtil.getCurrentThemeInfo().getString("themeId");
    this.textGray = paramContext.getResources().getColor(2131167138);
    this.textBlack = paramContext.getResources().getColor(2131167056);
  }
  
  public void addPoiList(List<LBSShare.POI> paramList, boolean paramBoolean)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.hasMore = paramBoolean;
      this.nextBegin += 1;
      this.poiList.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    List localList = this.poiList;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public LBSShare.POI getItem(int paramInt)
  {
    List localList = this.poiList;
    if (localList == null) {
      return null;
    }
    int i = localList.size();
    if ((i > 0) && (paramInt > -1) && (paramInt < i)) {
      return (LBSShare.POI)this.poiList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramView == null)
    {
      localObject1 = new POIAdapter.PoiItemViewHolder();
      paramView = this.mInflater.inflate(2131561969, null);
      ((POIAdapter.PoiItemViewHolder)localObject1).nameTextView = ((TextView)paramView.findViewById(2131371709));
      ((POIAdapter.PoiItemViewHolder)localObject1).addrTextView = ((TextView)paramView.findViewById(2131362252));
      ((POIAdapter.PoiItemViewHolder)localObject1).chooseView = paramView.findViewById(2131377149);
      ((POIAdapter.PoiItemViewHolder)localObject1).chooseView.setVisibility(4);
      ((POIAdapter.PoiItemViewHolder)localObject1).detailView = paramView;
      paramView.setTag(localObject1);
    }
    else
    {
      localObject1 = (POIAdapter.PoiItemViewHolder)paramView.getTag();
    }
    LBSShare.POI localPOI = getItem(paramInt);
    if (localPOI == null)
    {
      localObject1 = localObject2;
    }
    else
    {
      ((POIAdapter.PoiItemViewHolder)localObject1).poi = localPOI;
      ((POIAdapter.PoiItemViewHolder)localObject1).nameTextView.setText(localPOI.name.get());
      ((POIAdapter.PoiItemViewHolder)localObject1).addrTextView.setText(localPOI.addr.get());
      if (paramInt == this.selectPos)
      {
        ((POIAdapter.PoiItemViewHolder)localObject1).nameTextView.setTextColor(this.blueColor);
        ((POIAdapter.PoiItemViewHolder)localObject1).addrTextView.setTextColor(this.blueColor);
        ((POIAdapter.PoiItemViewHolder)localObject1).chooseView.setVisibility(0);
      }
      else
      {
        ((POIAdapter.PoiItemViewHolder)localObject1).nameTextView.setTextColor(this.textBlack);
        ((POIAdapter.PoiItemViewHolder)localObject1).addrTextView.setTextColor(this.textGray);
        ((POIAdapter.PoiItemViewHolder)localObject1).chooseView.setVisibility(4);
      }
      localObject1 = paramView;
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
  
  public void reset()
  {
    this.nextBegin = 0;
    this.selectPos = -1;
    this.hasMore = true;
    this.poiList.clear();
    notifyDataSetChanged();
  }
  
  public void select(int paramInt)
  {
    if (paramInt >= this.poiList.size()) {
      return;
    }
    if (paramInt != this.selectPos)
    {
      this.selectPos = paramInt;
      notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.activity.POIAdapter
 * JD-Core Version:    0.7.0.1
 */