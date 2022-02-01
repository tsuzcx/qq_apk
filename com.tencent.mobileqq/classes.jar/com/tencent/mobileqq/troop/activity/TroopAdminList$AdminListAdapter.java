package com.tencent.mobileqq.troop.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import java.util.Map;

public class TroopAdminList$AdminListAdapter
  extends BaseAdapter
{
  private LayoutInflater b;
  
  public TroopAdminList$AdminListAdapter(TroopAdminList paramTroopAdminList, Context paramContext)
  {
    this.b = LayoutInflater.from(paramContext);
  }
  
  public int getCount()
  {
    return this.a.f.size();
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
    TroopAdminList.ViewHolder localViewHolder;
    if (paramView == null)
    {
      localViewHolder = new TroopAdminList.ViewHolder();
      paramView = this.b.inflate(2131626650, null);
      localViewHolder.A = ((ImageView)paramView.findViewById(2131436403));
      localViewHolder.a = ((TextView)paramView.findViewById(2131439121));
      localViewHolder.b = ((TextView)paramView.findViewById(2131435692));
      paramView.setTag(localViewHolder);
      paramView.setOnClickListener(this.a.m);
    }
    else
    {
      localViewHolder = (TroopAdminList.ViewHolder)paramView.getTag();
    }
    Map localMap = (Map)this.a.f.get(paramInt);
    String str = localMap.get("uin").toString();
    localViewHolder.y = str;
    localViewHolder.A.setBackgroundDrawable(ImageUtil.j());
    FaceDrawable localFaceDrawable = FaceDrawable.getUserFaceDrawable(this.a.app, localMap.get("uin").toString(), (byte)3);
    if (localFaceDrawable != null) {
      localViewHolder.A.setBackgroundDrawable(localFaceDrawable);
    }
    localViewHolder.a.setText(localMap.get("nick").toString());
    if (this.a.g.equals(str)) {
      localViewHolder.b.setVisibility(0);
    } else {
      localViewHolder.b.setVisibility(4);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAdminList.AdminListAdapter
 * JD-Core Version:    0.7.0.1
 */