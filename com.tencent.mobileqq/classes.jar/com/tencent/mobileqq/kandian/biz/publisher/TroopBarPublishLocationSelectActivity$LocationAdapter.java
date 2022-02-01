package com.tencent.mobileqq.kandian.biz.publisher;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.tribe.data.TroopBarPOI;
import com.tencent.widget.XBaseAdapter;
import java.util.ArrayList;

class TroopBarPublishLocationSelectActivity$LocationAdapter
  extends XBaseAdapter
{
  protected LayoutInflater a = null;
  protected boolean b = false;
  
  public TroopBarPublishLocationSelectActivity$LocationAdapter(TroopBarPublishLocationSelectActivity paramTroopBarPublishLocationSelectActivity, Context paramContext, boolean paramBoolean)
  {
    this.a = LayoutInflater.from(paramContext);
    this.b = paramBoolean;
  }
  
  public int getCount()
  {
    if (this.c.f == null) {
      return 0;
    }
    return this.c.f.size();
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.a.inflate(2131628635, null);
      paramViewGroup = new TroopBarPublishLocationSelectActivity.LocationAdapter.ViewHolder(this);
      paramViewGroup.a = ((ImageView)paramView.findViewById(2131437050));
      paramViewGroup.b = ((ImageView)paramView.findViewById(2131445557));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131437038));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131437033));
      paramView.setTag(paramViewGroup);
    }
    else
    {
      paramViewGroup = (TroopBarPublishLocationSelectActivity.LocationAdapter.ViewHolder)paramView.getTag();
    }
    TroopBarPOI localTroopBarPOI = (TroopBarPOI)this.c.f.get(paramInt);
    paramViewGroup.c.setText(localTroopBarPOI.c);
    ImageView localImageView = paramViewGroup.b;
    int i;
    if (localTroopBarPOI.equals(this.c.e)) {
      i = 0;
    } else {
      i = 8;
    }
    localImageView.setVisibility(i);
    if (!TextUtils.isEmpty(localTroopBarPOI.e))
    {
      paramViewGroup.d.setText(localTroopBarPOI.e);
      paramViewGroup.d.setVisibility(0);
    }
    else
    {
      paramViewGroup.d.setVisibility(8);
    }
    if (paramInt == 0) {
      paramViewGroup.a.setVisibility(4);
    } else {
      paramViewGroup.a.setVisibility(0);
    }
    if (this.b) {
      paramView.setBackgroundResource(17170445);
    } else {
      paramView.setBackgroundResource(2130850269);
    }
    paramView.setContentDescription(localTroopBarPOI.c);
    paramView.setFocusable(true);
    paramView.setFocusableInTouchMode(true);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.TroopBarPublishLocationSelectActivity.LocationAdapter
 * JD-Core Version:    0.7.0.1
 */