package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.nearby.api.IFaceScoreUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.widget.BubbleViewLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class StructMsgItemLayout26
  extends AbsStructMsgItem
{
  protected int az = 0;
  
  private RelativeLayout a(Context paramContext)
  {
    BubbleViewLayout localBubbleViewLayout = new BubbleViewLayout(paramContext);
    localBubbleViewLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    localBubbleViewLayout.setId(2131430084);
    localBubbleViewLayout.setRadius(10.0F);
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    localLinearLayout.setPadding(0, 0, 0, AIOUtils.b(10.0F, paramContext.getResources()));
    localLinearLayout.setOrientation(1);
    localLinearLayout.setId(2131428025);
    localLinearLayout.setBackgroundColor(-1);
    localBubbleViewLayout.addView(localLinearLayout);
    return localBubbleViewLayout;
  }
  
  public static final int d(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        int i = new JSONObject(paramString).optInt("msgType", 0);
        return i;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("generate 26: ");
          localStringBuilder.append(QLog.getStackTraceString(paramString));
          QLog.e("StructMsg", 2, localStringBuilder.toString());
        }
      }
    }
    return 0;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Resources localResources = paramContext.getResources();
    int k = d(paramBundle.getString("extraData"));
    RelativeLayout localRelativeLayout = a(paramContext);
    LinearLayout localLinearLayout = (LinearLayout)localRelativeLayout.findViewById(2131428025);
    Iterator localIterator = this.ax.iterator();
    Object localObject3 = null;
    paramView = (View)localObject3;
    Object localObject1 = paramView;
    Object localObject2 = paramView;
    paramView = (View)localObject3;
    int i;
    while (localIterator.hasNext())
    {
      Object localObject4 = (AbsStructMsgElement)localIterator.next();
      ((AbsStructMsgElement)localObject4).ar = this.ar;
      localObject3 = ((AbsStructMsgElement)localObject4).b;
      if ((("picture".equals(localObject3)) || ("vote".equals(localObject3)) || ("video".equals(localObject3))) && (paramView == null))
      {
        localObject3 = ((AbsStructMsgElement)localObject4).a(paramContext, null, paramBundle);
        i = AIOUtils.b(200.0F, localResources);
        paramView = (View)localObject3;
        int j = i;
        if ((localObject4 instanceof StructMsgItemCover))
        {
          paramView = (StructMsgItemCover)localObject4;
          if (paramView.ay > 0) {
            i = paramView.ay;
          }
          paramView = (View)localObject3;
          j = i;
          if ((k & 0x2) != 0)
          {
            paramView = new RelativeLayout(paramContext);
            localObject4 = new RelativeLayout.LayoutParams(-1, i);
            ((RelativeLayout.LayoutParams)localObject4).addRule(14);
            paramView.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
            localObject3 = new ImageView(paramContext);
            ((ImageView)localObject3).setImageResource(2130842671);
            localObject4 = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject4).addRule(13);
            paramView.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
            j = i;
          }
        }
        localLinearLayout.addView(paramView, new LinearLayout.LayoutParams(-1, j));
      }
      else if ("summary".equals(localObject3))
      {
        localObject1 = (TextView)((AbsStructMsgElement)localObject4).a(paramContext, null, paramBundle);
        localLinearLayout.addView((View)localObject1);
      }
      else if ("taglist".equals(localObject3))
      {
        localObject2 = (LinearLayout)((AbsStructMsgElement)localObject4).a(paramContext, null, paramBundle);
        localObject3 = new LinearLayout.LayoutParams(-1, -2);
        ((LinearLayout.LayoutParams)localObject3).setMargins(0, AIOUtils.b(10.0F, localResources), 0, AIOUtils.b(6.0F, localResources));
        localLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      }
    }
    if (paramView == null)
    {
      paramContext = new StringBuilder();
      paramContext.append("generate 26 item failure coverView == null，mElements.size=");
      paramContext.append(this.ax.size());
      QLog.e("StructMsg", 1, paramContext.toString());
    }
    if (localLinearLayout == null)
    {
      paramContext = new StringBuilder();
      paramContext.append("generate 26 item failure containerView == null, mElements.size=");
      paramContext.append(this.ax.size());
      QLog.e("StructMsg", 1, paramContext.toString());
    }
    boolean bool = paramBundle.getBoolean("isSend", true);
    ((BubbleViewLayout)localRelativeLayout.findViewById(2131430084)).a = bool;
    if (bool)
    {
      if (localObject2 != null) {
        ((LinearLayout)localObject2).setPadding(AIOUtils.b(12.0F, localResources), 0, AIOUtils.b(22.0F, localResources), 0);
      }
      if (localObject1 != null) {
        ((TextView)localObject1).setPadding(AIOUtils.b(12.0F, localResources), 0, AIOUtils.b(22.0F, localResources), 0);
      }
    }
    else
    {
      if (localObject2 != null) {
        ((LinearLayout)localObject2).setPadding(AIOUtils.b(22.0F, localResources), 0, AIOUtils.b(12.0F, localResources), 0);
      }
      if (localObject1 != null) {
        ((TextView)localObject1).setPadding(AIOUtils.b(22.0F, localResources), 0, AIOUtils.b(12.0F, localResources), 0);
      }
    }
    if ((AppSetting.e) && (localObject1 != null))
    {
      paramContext = new StringBuilder();
      paramContext.append(((TextView)localObject1).getText());
      localLinearLayout.setContentDescription(paramContext.toString());
    }
    if ((this.as != null) && (this.as.message != null))
    {
      bool = ((IFaceScoreUtils)QRoute.api(IFaceScoreUtils.class)).getFaceScoreFlag(this.as.message, "isFaceScoreSecondMember");
      paramView = "2";
      if (bool) {
        paramContext = "2";
      } else {
        paramContext = "1";
      }
      if ((k & 0x2) != 0) {
        i = 1;
      } else {
        i = 0;
      }
      paramBundle = (IFaceScoreUtils)QRoute.api(IFaceScoreUtils.class);
      localObject1 = this.as.uin;
      if (i == 0) {
        paramView = "1";
      }
      paramBundle.report("exp_obj", (String)localObject1, new String[] { paramContext, "", "", paramView });
    }
    return localRelativeLayout;
  }
  
  protected int c()
  {
    return 26;
  }
  
  public String e()
  {
    return "Layout26";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout26
 * JD-Core Version:    0.7.0.1
 */