package com.wifisdk.ui.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.wifisdk.ui.api.RProxy.dimen;
import com.wifisdk.ui.api.RProxy.drawable;
import com.wifisdk.ui.api.RProxy.id;
import com.wifisdk.ui.api.RProxy.layout;
import java.util.ArrayList;
import java.util.List;
import wf7.hn;
import wf7.ho;
import wf7.hr;

public class e
  extends BaseAdapter
{
  private Context mContext;
  private int vJ;
  private List<hn> va = new ArrayList();
  
  public e(Context paramContext)
  {
    this.mContext = paramContext;
    this.vJ = ((int)paramContext.getResources().getDimension(RProxy.dimen.tmsdk_wifi_list_item_ssid_max_width));
  }
  
  private View a(ho paramho, View paramView)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.mContext).inflate(RProxy.layout.wifi_sdk_list_item_header, null);
      localView.setTag((TextView)localView.findViewById(RProxy.id.tmsdk_wifi_list_header_text));
    }
    ((TextView)localView.getTag()).setText(paramho.tA);
    return localView;
  }
  
  private View a(hr paramhr, View paramView)
  {
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.mContext).inflate(RProxy.layout.wifi_sdk_list_view_item, null);
      paramView = d(localView);
    }
    else
    {
      e.a locala = (e.a)paramView.getTag();
      localView = paramView;
      paramView = locala;
    }
    a(paramView, paramhr);
    int i = this.mContext.getResources().getConfiguration().orientation;
    if (i == 1)
    {
      localView.setMinimumHeight((int)this.mContext.getResources().getDimension(RProxy.dimen.tmsdk_wifi_item_height));
      return localView;
    }
    if (i == 2) {
      localView.setMinimumHeight((int)this.mContext.getResources().getDimension(RProxy.dimen.tmsdk_wifi_item_height_landscape));
    }
    return localView;
  }
  
  private void a(e.a parama, hr paramhr)
  {
    try
    {
      parama.vK.setText(paramhr.ssid);
      i = paramhr.level;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (paramhr.tI == 1) {
                i = RProxy.drawable.tmsdk_wifi_wifi_1_2;
              } else if ((paramhr.tJ != 2) && (paramhr.tJ != 1)) {
                i = RProxy.drawable.tmsdk_wifi_wifi_5_2;
              } else {
                i = RProxy.drawable.tmsdk_wifi_wifi_config_2;
              }
            }
            else if (paramhr.tI == 1) {
              i = RProxy.drawable.tmsdk_wifi_wifi_1_4;
            } else if ((paramhr.tJ != 2) && (paramhr.tJ != 1)) {
              i = RProxy.drawable.tmsdk_wifi_wifi_5_4;
            } else {
              i = RProxy.drawable.tmsdk_wifi_wifi_config_4;
            }
          }
          else if (paramhr.tI == 1) {
            i = RProxy.drawable.tmsdk_wifi_wifi_1_3;
          } else if ((paramhr.tJ != 2) && (paramhr.tJ != 1)) {
            i = RProxy.drawable.tmsdk_wifi_wifi_5_3;
          } else {
            i = RProxy.drawable.tmsdk_wifi_wifi_config_3;
          }
        }
        else if (paramhr.tI == 1) {
          i = RProxy.drawable.tmsdk_wifi_wifi_1_2;
        } else if ((paramhr.tJ != 2) && (paramhr.tJ != 1)) {
          i = RProxy.drawable.tmsdk_wifi_wifi_5_2;
        } else {
          i = RProxy.drawable.tmsdk_wifi_wifi_config_2;
        }
      }
      else if (paramhr.tI == 1) {
        i = RProxy.drawable.tmsdk_wifi_wifi_1_1;
      } else if ((paramhr.tJ != 2) && (paramhr.tJ != 1)) {
        i = RProxy.drawable.tmsdk_wifi_wifi_5_1;
      } else {
        i = RProxy.drawable.tmsdk_wifi_wifi_config_1;
      }
      parama.vL.setBackgroundResource(i);
      j = paramhr.tI;
      i = 0;
      if (j != 1) {
        break label603;
      }
      parama.vR.setVisibility(0);
      parama.vR.setBackgroundResource(RProxy.drawable.tmsdk_wifi_item_connect_button_selector);
      if ((paramhr.isBestWiFi) && (paramhr.tN))
      {
        parama.vM.setVisibility(0);
        parama.vM.setImageResource(RProxy.drawable.tmsdk_wifi_tag);
        parama.vK.setMaxWidth(this.vJ);
        if (TextUtils.isEmpty(paramhr.recommendReason))
        {
          parama.vQ.setVisibility(8);
        }
        else
        {
          parama.vQ.setVisibility(0);
          parama.vQ.setText(paramhr.recommendReason);
        }
      }
      else if ((paramhr.tM) && (paramhr.tO))
      {
        parama.vM.setVisibility(0);
        parama.vM.setImageResource(RProxy.drawable.tmsdk_wifi_subway_tag);
        parama.vK.setMaxWidth(this.vJ);
        parama.vQ.setVisibility(0);
      }
      else
      {
        parama.vM.setVisibility(8);
        parama.vK.setMaxWidth(2147483647);
        parama.vQ.setVisibility(8);
      }
      if (TextUtils.isEmpty(paramhr.tL))
      {
        parama.vN.setVisibility(8);
      }
      else
      {
        parama.vN.setText(paramhr.tL);
        parama.vN.setVisibility(0);
      }
      if (paramhr.starLevel <= 0) {
        break label591;
      }
      parama.vO.setVisibility(0);
    }
    finally
    {
      for (;;)
      {
        int i;
        int j;
        ImageView localImageView;
        label666:
        for (;;)
        {
          label591:
          label603:
          throw parama;
        }
        label680:
        i += 1;
      }
    }
    if (i < parama.vP.length)
    {
      localImageView = parama.vP[i];
      if (localImageView == null) {
        break label680;
      }
      if (i < paramhr.starLevel) {
        j = RProxy.drawable.tmsdk_wifi_star_on;
      } else {
        j = RProxy.drawable.tmsdk_wifi_star_off;
      }
      localImageView.setBackgroundResource(j);
      break label680;
      parama.vO.setVisibility(8);
      break label666;
      parama.vR.setVisibility(0);
      parama.vR.setBackgroundResource(RProxy.drawable.tmsdk_wifi_item_connect_button_selector);
      parama.vO.setVisibility(8);
      parama.vQ.setVisibility(8);
      parama.vN.setVisibility(8);
      parama.vK.setMaxWidth(2147483647);
      parama.vM.setVisibility(8);
    }
  }
  
  private e.a d(View paramView)
  {
    e.a locala = new e.a(this, null);
    locala.vK = ((TextView)paramView.findViewById(RProxy.id.tmsdk_wifi_tv));
    locala.vL = ((ImageView)paramView.findViewById(RProxy.id.tmsdk_wifi_wifi_icon));
    locala.vM = ((ImageView)paramView.findViewById(RProxy.id.tmsdk_wifi_quality));
    locala.vN = ((TextView)paramView.findViewById(RProxy.id.tmsdk_wifi_description));
    locala.vO = ((RelativeLayout)paramView.findViewById(RProxy.id.tmsdk_wifi_score));
    ImageView localImageView1 = (ImageView)locala.vO.findViewById(RProxy.id.tmsdk_wifi_star1);
    ImageView localImageView2 = (ImageView)locala.vO.findViewById(RProxy.id.tmsdk_wifi_star2);
    ImageView localImageView3 = (ImageView)locala.vO.findViewById(RProxy.id.tmsdk_wifi_star3);
    ImageView localImageView4 = (ImageView)locala.vO.findViewById(RProxy.id.tmsdk_wifi_star4);
    ImageView localImageView5 = (ImageView)locala.vO.findViewById(RProxy.id.tmsdk_wifi_star5);
    locala.vP = new ImageView[5];
    locala.vP[0] = localImageView1;
    locala.vP[1] = localImageView2;
    locala.vP[2] = localImageView3;
    locala.vP[3] = localImageView4;
    locala.vP[4] = localImageView5;
    locala.vQ = ((TextView)paramView.findViewById(RProxy.id.tmsdk_wifi_latency_layout));
    locala.vR = ((TextView)paramView.findViewById(RProxy.id.tmsdk_wifi_connect));
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
    Object localObject = getItem(paramInt);
    if (i == 0) {
      localObject = a((hr)localObject, paramView);
    } else {
      localObject = a((ho)localObject, paramView);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localObject;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.wifisdk.ui.view.e
 * JD-Core Version:    0.7.0.1
 */