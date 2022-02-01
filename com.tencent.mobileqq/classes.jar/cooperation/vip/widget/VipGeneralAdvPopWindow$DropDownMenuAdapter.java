package cooperation.vip.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class VipGeneralAdvPopWindow$DropDownMenuAdapter
  extends BaseAdapter
{
  private Context b;
  private LayoutInflater c;
  
  public VipGeneralAdvPopWindow$DropDownMenuAdapter(VipGeneralAdvPopWindow paramVipGeneralAdvPopWindow, Context paramContext)
  {
    this.b = paramContext;
  }
  
  private LayoutInflater a()
  {
    if (this.c == null) {
      this.c = LayoutInflater.from(this.b);
    }
    return this.c;
  }
  
  private void a(VipGeneralAdvPopWindow.MenuData paramMenuData, VipGeneralAdvPopWindow.ViewHolder paramViewHolder)
  {
    paramMenuData = URLDrawable.getDrawable(paramMenuData.c, null);
    paramViewHolder.c.setImageDrawable(paramMenuData);
    paramViewHolder.b.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    paramViewHolder.c.setVisibility(0);
  }
  
  private View b()
  {
    return a().inflate(2131629650, null);
  }
  
  public int getCount()
  {
    if (this.a.b != null) {
      return this.a.b.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.a.b != null) {
      return this.a.b.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    if (this.a.b != null) {
      return this.a.b.size();
    }
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    VipGeneralAdvPopWindow.ViewHolder localViewHolder;
    if (paramView == null)
    {
      localViewHolder = new VipGeneralAdvPopWindow.ViewHolder(this.a);
      paramView = b();
      localViewHolder.b = ((TextView)paramView.findViewById(2131438120));
      localViewHolder.c = ((ImageView)paramView.findViewById(2131437100));
      localViewHolder.d = paramView.findViewById(2131432257);
      paramView.setTag(localViewHolder);
    }
    else
    {
      localViewHolder = (VipGeneralAdvPopWindow.ViewHolder)paramView.getTag();
    }
    if (localViewHolder != null)
    {
      if (getCount() <= 1)
      {
        localViewHolder.d.setVisibility(8);
        paramView.setBackgroundResource(2130851256);
      }
      else if (paramInt <= 0)
      {
        localViewHolder.d.setVisibility(0);
        paramView.setBackgroundResource(2130851256);
      }
      else if (paramInt < getCount() - 1)
      {
        localViewHolder.d.setVisibility(0);
        paramView.setBackgroundResource(2130851255);
      }
      else
      {
        localViewHolder.d.setVisibility(8);
        paramView.setBackgroundResource(2130851254);
      }
      VipGeneralAdvPopWindow.MenuData localMenuData = (VipGeneralAdvPopWindow.MenuData)getItem(paramInt);
      if (localMenuData != null)
      {
        localViewHolder.a = localMenuData;
        localViewHolder.b.setText(localMenuData.b);
        if (TextUtils.isEmpty(localMenuData.c)) {
          localViewHolder.c.setVisibility(8);
        }
        a(localMenuData, localViewHolder);
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.widget.VipGeneralAdvPopWindow.DropDownMenuAdapter
 * JD-Core Version:    0.7.0.1
 */