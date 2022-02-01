package com.tencent.mobileqq.troop.data;

import NearbyGroup.GroupInfo;
import NearbyGroup.GroupLabel;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class NearbyTroops
{
  public static final boolean a = AppSetting.e;
  
  public static View a(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    return a(paramContext, paramViewGroup, paramInt, 2131629314);
  }
  
  public static View a(Context paramContext, ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(paramInt2, paramViewGroup, false);
    paramViewGroup = new NearbyTroops.CustomViewHolder();
    paramViewGroup.A = ((ImageView)paramContext.findViewById(2131447981));
    paramViewGroup.a = ((TextView)paramContext.findViewById(2131448053));
    paramViewGroup.b = ((TextView)paramContext.findViewById(2131447922));
    paramViewGroup.c = ((TroopLabelLayout)paramContext.findViewById(2131448010));
    paramViewGroup.c.setLabelType(paramInt1);
    paramViewGroup.d = ((TroopLabelLayout)paramContext.findViewById(2131448011));
    paramViewGroup.d.setLabelType(2);
    paramViewGroup.s = ((TextView)paramContext.findViewById(2131431992));
    paramViewGroup.c.setDistanceTextView(paramViewGroup.s);
    paramViewGroup.e = ((TextView)paramContext.findViewById(2131447954));
    paramViewGroup.f = ((ImageView)paramContext.findViewById(2131447913));
    paramViewGroup.g = ((ImageView)paramContext.findViewById(2131447875));
    paramViewGroup.t = ((RelativeLayout)paramContext.findViewById(2131445012));
    paramViewGroup.u = ((Button)paramContext.findViewById(2131436679));
    paramViewGroup.A.setImageBitmap(null);
    paramViewGroup.m = ((LinearLayout)paramContext.findViewById(2131436054));
    paramViewGroup.n = ((LinearLayout)paramContext.findViewById(2131446660));
    paramViewGroup.o = ((TextView)paramContext.findViewById(2131447921));
    paramViewGroup.q = paramContext.findViewById(2131437197);
    paramViewGroup.p = paramInt1;
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public static void a(Context paramContext, AppInterface paramAppInterface)
  {
    HotChatManager.a(paramContext, false);
  }
  
  public static void a(View paramView, GroupInfo paramGroupInfo, Context paramContext, boolean paramBoolean)
  {
    a(paramView, paramGroupInfo, paramContext, paramBoolean, false);
  }
  
  public static void a(View paramView, GroupInfo paramGroupInfo, Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramView, paramGroupInfo, paramContext, paramBoolean1, true, paramBoolean2);
  }
  
  public static void a(View paramView, GroupInfo paramGroupInfo, Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    NearbyTroops.CustomViewHolder localCustomViewHolder = (NearbyTroops.CustomViewHolder)paramView.getTag();
    localCustomViewHolder.y = String.valueOf(paramGroupInfo.lCode);
    localCustomViewHolder.a.setText(paramGroupInfo.strName);
    localCustomViewHolder.a.setTextColor(paramContext.getResources().getColor(2131168001));
    Object localObject1;
    Object localObject2;
    int i;
    if ((paramBoolean2) && (paramGroupInfo.labels != null))
    {
      localObject1 = paramGroupInfo.labels.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (GroupLabel)((Iterator)localObject1).next();
        if (((GroupLabel)localObject2).type == 2001L)
        {
          i = android.graphics.Color.rgb((int)((GroupLabel)localObject2).text_color.R, (int)((GroupLabel)localObject2).text_color.G, (int)((GroupLabel)localObject2).text_color.B);
          localCustomViewHolder.a.setTextColor(i);
        }
      }
    }
    int j = 0;
    if ((paramBoolean1) || (paramBoolean3)) {
      localCustomViewHolder.t.setVisibility(0);
    }
    if (paramBoolean3) {
      localCustomViewHolder.u.setVisibility(0);
    }
    localCustomViewHolder.e.setVisibility(0);
    if (TextUtils.isEmpty(paramGroupInfo.strIntro))
    {
      localCustomViewHolder.e.setText(2131893911);
    }
    else
    {
      i = paramContext.getResources().getDisplayMetrics().widthPixels;
      if (localCustomViewHolder.i == 1) {
        i -= AIOUtils.b(110.0F, paramContext.getResources());
      } else {
        i = (i - AIOUtils.b(137.0F, paramContext.getResources())) * 2;
      }
      localObject1 = HttpUtil.unEscape(HttpUtil.removeHtmlTags(paramGroupInfo.strIntro));
      TextUtils.ellipsize((CharSequence)localObject1, localCustomViewHolder.e.getPaint(), i, TextUtils.TruncateAt.END, false, new NearbyTroops.1(localCustomViewHolder, (String)localObject1));
    }
    localCustomViewHolder.r = paramGroupInfo;
    if ((paramGroupInfo.labels != null) && (paramGroupInfo.labels.size() != 0))
    {
      if ((!a(paramContext, localCustomViewHolder, paramGroupInfo)) && (QLog.isColorLevel()))
      {
        paramContext = new StringBuilder();
        paramContext.append("fillTroopLabels failed:");
        paramContext.append(paramGroupInfo.strName);
        QLog.e("NearbyTroops", 2, paramContext.toString());
      }
    }
    else
    {
      if ((localCustomViewHolder.l == null) || (localCustomViewHolder.l.size() == 0))
      {
        localObject1 = new ArrayList(1);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramGroupInfo.iMemberCnt);
        ((StringBuilder)localObject2).append("");
        ((ArrayList)localObject1).add(new GroupLabel(((StringBuilder)localObject2).toString(), new NearbyGroup.Color(175L, 195L, 213L), 1L, new NearbyGroup.Color(190L, 206L, 220L)));
        localCustomViewHolder.l = ((ArrayList)localObject1);
      }
      localObject1 = (GroupLabel)localCustomViewHolder.l.get(0);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramGroupInfo.iMemberCnt);
      ((StringBuilder)localObject2).append("");
      ((GroupLabel)localObject1).strWording = ((StringBuilder)localObject2).toString();
      paramGroupInfo.labels = localCustomViewHolder.l;
      a(paramContext, localCustomViewHolder, paramGroupInfo);
    }
    if ((paramGroupInfo.dwGroupFlagExt & 0x800) != 0L)
    {
      if (paramGroupInfo.dwCertType == 2L)
      {
        localCustomViewHolder.f.setVisibility(0);
        localCustomViewHolder.f.setBackgroundResource(2130844940);
      }
      else if (paramGroupInfo.dwCertType == 1L)
      {
        localCustomViewHolder.f.setVisibility(0);
        localCustomViewHolder.f.setBackgroundResource(2130844940);
      }
      else
      {
        localCustomViewHolder.f.setVisibility(8);
      }
    }
    else {
      localCustomViewHolder.f.setVisibility(8);
    }
    if ((paramGroupInfo.dwExtFlag & 1L) != 0L)
    {
      localCustomViewHolder.g.setBackgroundResource(2130843550);
      localCustomViewHolder.g.setVisibility(0);
    }
    else
    {
      localCustomViewHolder.g.setVisibility(8);
    }
    if (a)
    {
      paramContext = new StringBuilder();
      paramContext.append("");
      paramContext.append(paramGroupInfo.strName);
      localObject2 = paramContext.toString();
      paramContext = new StringBuilder();
      paramContext.append(paramGroupInfo.iMemberCnt);
      paramContext.append(HardCodeUtil.a(2131905236));
      localObject1 = paramContext.toString();
      paramContext = (Context)localObject1;
      if (paramGroupInfo.labels != null)
      {
        StringBuffer localStringBuffer = new StringBuffer();
        int k = paramGroupInfo.labels.size();
        i = j;
        while (i < k)
        {
          paramContext = (GroupLabel)paramGroupInfo.labels.get(i);
          if ((paramContext != null) && (!TextUtils.isEmpty(paramContext.strWording)))
          {
            localStringBuffer.append(paramContext.strWording);
            localStringBuffer.append(" ");
          }
          i += 1;
        }
        paramContext = (Context)localObject1;
        if (localStringBuffer.length() > 0) {
          paramContext = localStringBuffer.toString();
        }
      }
      localCustomViewHolder.b.setContentDescription(paramContext);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(paramContext);
      paramContext = ((StringBuilder)localObject1).toString();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramContext);
      ((StringBuilder)localObject1).append(paramGroupInfo.strIntro);
      paramView.setContentDescription(((StringBuilder)localObject1).toString());
    }
  }
  
  protected static boolean a(Context paramContext, NearbyTroops.CustomViewHolder paramCustomViewHolder, GroupInfo paramGroupInfo)
  {
    if ((paramContext != null) && (paramCustomViewHolder != null) && (paramGroupInfo != null) && (paramGroupInfo.labels != null))
    {
      if (paramGroupInfo.labels.size() == 0) {
        return false;
      }
      paramCustomViewHolder.b.setVisibility(8);
      paramCustomViewHolder.c.setVisibility(0);
      paramContext = paramGroupInfo.labels;
      paramCustomViewHolder.d.a(paramContext);
      return paramCustomViewHolder.c.a(paramContext);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.NearbyTroops
 * JD-Core Version:    0.7.0.1
 */