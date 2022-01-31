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
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.proto.lbsshare.LBSShare.POI;
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
    this.textGray = paramContext.getResources().getColor(2131101333);
    this.textBlack = paramContext.getResources().getColor(2131101260);
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
    if (this.poiList == null) {
      return 0;
    }
    return this.poiList.size();
  }
  
  public LBSShare.POI getItem(int paramInt)
  {
    if (this.poiList == null) {}
    int i;
    do
    {
      return null;
      i = this.poiList.size();
    } while ((i <= 0) || (paramInt <= -1) || (paramInt >= i));
    return (LBSShare.POI)this.poiList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new POIAdapter.PoiItemViewHolder();
      paramView = this.mInflater.inflate(2131495974, null);
      paramViewGroup.nameTextView = ((TextView)paramView.findViewById(2131304994));
      paramViewGroup.addrTextView = ((TextView)paramView.findViewById(2131296588));
      paramViewGroup.chooseView = paramView.findViewById(2131310033);
      paramViewGroup.chooseView.setVisibility(4);
      paramViewGroup.detailView = paramView;
      paramView.setTag(paramViewGroup);
    }
    LBSShare.POI localPOI;
    for (;;)
    {
      localPOI = getItem(paramInt);
      if (localPOI != null) {
        break;
      }
      return null;
      paramViewGroup = (POIAdapter.PoiItemViewHolder)paramView.getTag();
    }
    paramViewGroup.poi = localPOI;
    paramViewGroup.nameTextView.setText(localPOI.name.get());
    paramViewGroup.addrTextView.setText(localPOI.addr.get());
    if (paramInt == this.selectPos)
    {
      paramViewGroup.nameTextView.setTextColor(this.blueColor);
      paramViewGroup.addrTextView.setTextColor(this.blueColor);
      paramViewGroup.chooseView.setVisibility(0);
      return paramView;
    }
    paramViewGroup.nameTextView.setTextColor(this.textBlack);
    paramViewGroup.addrTextView.setTextColor(this.textGray);
    paramViewGroup.chooseView.setVisibility(4);
    return paramView;
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
    if (paramInt >= this.poiList.size()) {}
    while (paramInt == this.selectPos) {
      return;
    }
    this.selectPos = paramInt;
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.activity.POIAdapter
 * JD-Core Version:    0.7.0.1
 */