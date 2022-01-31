package com.wifisdk.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.wifisdk.ui.api.RProxy.anim;
import com.wifisdk.ui.api.RProxy.color;
import com.wifisdk.ui.api.RProxy.drawable;
import com.wifisdk.ui.api.RProxy.id;
import com.wifisdk.ui.api.RProxy.layout;
import com.wifisdk.ui.api.RProxy.string;
import java.util.ArrayList;
import java.util.List;
import wf7.hn;
import wf7.ho;
import wf7.hp;
import wf7.hq;

public class b
  extends BaseAdapter
{
  private Context mContext;
  private List<hn> va = new ArrayList();
  
  public b(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private View a(ho paramho, View paramView)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.mContext).inflate(RProxy.layout.wifi_sdk_list_item_header, null);
      c(localView);
    }
    paramView = (b.a)localView.getTag();
    paramView.vd.setText(paramho.tA);
    if (paramho.tB)
    {
      paramView.ve.setVisibility(0);
      paramho = AnimationUtils.loadAnimation(this.mContext, RProxy.anim.tmsdk_wifi_secure_rotate);
      paramho.setInterpolator(new LinearInterpolator());
      paramView.ve.startAnimation(paramho);
      return localView;
    }
    paramView.ve.setVisibility(8);
    paramView.ve.clearAnimation();
    return localView;
  }
  
  private View a(hp paramhp, View paramView)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.mContext).inflate(RProxy.layout.wifi_sdk_security_check_item, null);
      a(localView);
    }
    paramView = (b.b)localView.getTag();
    paramView.vd.setText(paramhp.tC);
    if (paramhp.tF)
    {
      paramView.vf.setVisibility(8);
      paramView.vg.setVisibility(8);
      return localView;
    }
    paramView.vf.setVisibility(0);
    paramView.vf.setText(paramhp.tD);
    if (paramhp.tG == 1)
    {
      paramView.vg.setVisibility(0);
      if (paramhp.tE == 0)
      {
        paramView.vg.setImageResource(RProxy.drawable.tmsdk_wifi_secure_item_safe);
        paramView.vf.setTextColor(this.mContext.getResources().getColor(RProxy.color.tmsdk_wifi_security_item_right_text_safe));
        return localView;
      }
      paramView.vg.setImageResource(RProxy.drawable.tmsdk_wifi_secure_item_risk);
      paramView.vf.setTextColor(this.mContext.getResources().getColor(RProxy.color.tmsdk_wifi_security_item_right_text_danger));
      return localView;
    }
    paramView.vg.setVisibility(8);
    paramView.vf.setTextColor(this.mContext.getResources().getColor(RProxy.color.tmsdk_wifi_security_item_right_text_safe));
    return localView;
  }
  
  private View a(hq paramhq, View paramView)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.mContext).inflate(RProxy.layout.wifi_sdk_security_result_recomand_item, null);
      b(localView);
    }
    paramView = (b.c)localView.getTag();
    if (paramhq.tH == 2)
    {
      paramView.vh.setText(this.mContext.getText(RProxy.string.tmsdk_wifi_security_high_risk_bt_text));
      paramView.vi.setText(this.mContext.getText(RProxy.string.tmsdk_wifi_security_high_risk_sub_text));
      paramView.vj.setText(this.mContext.getText(RProxy.string.tmsdk_wifi_security_high_risk_bt_text));
      paramView.vj.setOnClickListener(new b.1(this));
      return localView;
    }
    paramView.vh.setText(this.mContext.getText(RProxy.string.tmsdk_wifi_security_normal_risk_text));
    paramView.vi.setText(this.mContext.getText(RProxy.string.tmsdk_wifi_security_normal_risk_sub_text));
    paramView.vj.setText(this.mContext.getText(RProxy.string.tmsdk_wifi_security_normal_risk_bt_text));
    paramView.vj.setOnClickListener(new b.2(this, paramhq));
    return localView;
  }
  
  private b.b a(View paramView)
  {
    b.b localb = new b.b(this, null);
    localb.vd = ((TextView)paramView.findViewById(RProxy.id.wifi_sdk_security_item_left_text));
    localb.vf = ((TextView)paramView.findViewById(RProxy.id.wifi_sdk_security_item_right_text));
    localb.vg = ((ImageView)paramView.findViewById(RProxy.id.wifi_sdk_security_item_right_img));
    paramView.setTag(localb);
    return localb;
  }
  
  private b.c b(View paramView)
  {
    b.c localc = new b.c(this, null);
    localc.vh = ((TextView)paramView.findViewById(RProxy.id.tmsdk_wifi_recommend_text));
    localc.vi = ((TextView)paramView.findViewById(RProxy.id.tmsdk_wifi_recommend_sub_text));
    localc.vj = ((Button)paramView.findViewById(RProxy.id.tmsdk_wifi_recommend_button));
    paramView.setTag(localc);
    return localc;
  }
  
  public b.a c(View paramView)
  {
    b.a locala = new b.a(this, null);
    locala.vd = ((TextView)paramView.findViewById(RProxy.id.tmsdk_wifi_list_header_text));
    locala.ve = ((ImageView)paramView.findViewById(RProxy.id.tmsdk_wifi_list_header_rotate));
    paramView.findViewById(RProxy.id.tmsdk_wifi_list_header_line_for_security).setVisibility(0);
    paramView.setTag(locala);
    return locala;
  }
  
  public int getCount()
  {
    return this.va.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.va.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((hn)this.va.get(paramInt)).tz;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    paramViewGroup = getItem(paramInt);
    if (i == 2) {
      return a((hp)paramViewGroup, paramView);
    }
    if (i == 3) {
      return a((hq)paramViewGroup, paramView);
    }
    if (i == 1) {
      return a((ho)paramViewGroup, paramView);
    }
    return new View(this.mContext);
  }
  
  public int getViewTypeCount()
  {
    return 4;
  }
  
  public void s(List<hn> paramList)
  {
    this.va.clear();
    this.va.addAll(paramList);
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.wifisdk.ui.view.b
 * JD-Core Version:    0.7.0.1
 */