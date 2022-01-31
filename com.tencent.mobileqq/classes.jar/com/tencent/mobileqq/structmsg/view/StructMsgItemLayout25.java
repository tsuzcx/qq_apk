package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.widget.PAImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class StructMsgItemLayout25
  extends AbsStructMsgItem
{
  private TextView a;
  
  private void a(Context paramContext, Resources paramResources, RelativeLayout paramRelativeLayout, View paramView, LinearLayout paramLinearLayout, TextView paramTextView1, TextView paramTextView2)
  {
    float f = paramResources.getDisplayMetrics().density;
    paramRelativeLayout.addView(paramView, new RelativeLayout.LayoutParams(-1, -1));
    paramResources = new FrameLayout(paramContext);
    paramResources.setId(2131362336);
    paramView = new ImageView(paramContext);
    paramView.setImageResource(2130846097);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 80;
    paramResources.addView(paramView, localLayoutParams);
    paramView = new FrameLayout.LayoutParams(-2, -2);
    paramView.gravity = 17;
    paramResources.addView(paramLinearLayout, paramView);
    paramView = new RelativeLayout.LayoutParams(-2, -2);
    paramView.addRule(14);
    paramView.addRule(10);
    paramView.topMargin = ((int)(32.0F * f));
    paramRelativeLayout.addView(paramResources, paramView);
    paramTextView2.setId(2131362334);
    paramTextView2.setIncludeFontPadding(false);
    paramTextView2.setSingleLine(false);
    paramTextView2.setMaxLines(2);
    paramTextView2.setTextSize(1, 40.0F);
    paramTextView2.setTextColor(-1);
    paramTextView2.setGravity(17);
    paramTextView2.getPaint().setFakeBoldText(true);
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView2;
    paramResources = new RelativeLayout.LayoutParams((int)(240.0F * f), -2);
    paramResources.addRule(14);
    paramResources.addRule(3, 2131362336);
    paramResources.topMargin = ((int)(5.0F * f));
    paramResources.bottomMargin = ((int)(5.0F * f));
    paramRelativeLayout.addView(paramTextView2, paramResources);
    paramResources = new ImageView(paramContext);
    paramResources.setId(2131362335);
    paramResources.setImageResource(2130846099);
    paramView = new RelativeLayout.LayoutParams(-2, -2);
    paramView.addRule(14);
    paramView.addRule(3, 2131362334);
    paramRelativeLayout.addView(paramResources, paramView);
    paramResources = new RelativeLayout(paramContext);
    paramView = new ImageView(paramContext);
    paramView.setId(2131362333);
    paramView.setImageResource(2130846100);
    paramLinearLayout = new RelativeLayout.LayoutParams(-2, -2);
    paramLinearLayout.addRule(13);
    paramResources.addView(paramView, paramLinearLayout);
    paramContext = new ImageView(paramContext);
    paramContext.setImageResource(2130846096);
    paramView = new RelativeLayout.LayoutParams(-2, -2);
    paramView.addRule(15);
    paramView.addRule(0, 2131362333);
    paramView.rightMargin = ((int)(6.0F * f));
    paramResources.addView(paramContext, paramView);
    paramTextView1.setIncludeFontPadding(false);
    paramTextView1.setTextSize(1, 22.0F);
    paramTextView1.setTextColor(-1);
    paramTextView1.getPaint().setFakeBoldText(true);
    paramContext = new RelativeLayout.LayoutParams(-2, -2);
    paramContext.addRule(15);
    paramContext.addRule(1, 2131362333);
    paramContext.leftMargin = ((int)(6.0F * f));
    paramResources.addView(paramTextView1, paramContext);
    paramContext = new RelativeLayout.LayoutParams((int)(240.0F * f), -2);
    paramContext.addRule(14);
    paramContext.addRule(3, 2131362335);
    paramContext.topMargin = ((int)(f * 10.0F));
    paramRelativeLayout.addView(paramResources, paramContext);
  }
  
  protected int b()
  {
    return 25;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Resources localResources = paramContext.getResources();
    LinearLayout localLinearLayout;
    RelativeLayout localRelativeLayout;
    int i;
    Object localObject3;
    Object localObject1;
    Object localObject4;
    Object localObject2;
    label89:
    Object localObject5;
    int j;
    Object localObject6;
    Object localObject7;
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      localLinearLayout = (LinearLayout)paramView;
      localLinearLayout.removeAllViews();
      localRelativeLayout = new RelativeLayout(paramContext);
      localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, AIOUtils.a(290.0F, localResources)));
      localLinearLayout.addView(localRelativeLayout);
      i = 0;
      localObject3 = null;
      localObject1 = null;
      localObject4 = null;
      localObject2 = null;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (!localIterator.hasNext()) {
        break label531;
      }
      paramView = (AbsStructMsgElement)localIterator.next();
      localObject5 = paramView.a;
      if ((!"type".equals(localObject5)) || (!(paramView instanceof StructMsgItemType))) {
        break label264;
      }
      j = ((StructMsgItemType)paramView).e;
      i = j;
      paramView = (View)localObject4;
      localObject5 = localObject2;
      localObject6 = localObject3;
      localObject7 = localObject1;
      if (QLog.isColorLevel())
      {
        QLog.d("StructMsgItemLayout25", 2, "getView socialType=" + j);
        localObject7 = localObject1;
        localObject6 = localObject3;
        localObject5 = localObject2;
        paramView = (View)localObject4;
        i = j;
      }
    }
    for (;;)
    {
      localObject4 = paramView;
      localObject2 = localObject5;
      localObject3 = localObject6;
      localObject1 = localObject7;
      break label89;
      localLinearLayout = new LinearLayout(paramContext);
      localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      localLinearLayout.setOrientation(1);
      break;
      label264:
      if (("title".equals(localObject5)) && (localObject3 == null))
      {
        if ((paramView instanceof StructMsgItemTitle)) {
          ((StructMsgItemTitle)paramView).a(a(), this.f);
        }
        localObject6 = (TextView)paramView.a(paramContext, null, paramBundle);
        ((TextView)localObject6).setSingleLine();
        ((TextView)localObject6).setEllipsize(TextUtils.TruncateAt.END);
        ((TextView)localObject6).getPaint().setFakeBoldText(true);
        paramView = (View)localObject4;
        localObject5 = localObject2;
        localObject7 = localObject1;
      }
      else if (("summary".equals(localObject5)) && (localObject1 == null))
      {
        localObject7 = (TextView)paramView.a(paramContext, null, paramBundle);
        ((TextView)localObject7).setSingleLine();
        ((TextView)localObject7).setEllipsize(TextUtils.TruncateAt.END);
        paramView = (View)localObject4;
        localObject5 = localObject2;
        localObject6 = localObject3;
      }
      else
      {
        if (("picture".equals(localObject5)) && (localObject4 == null))
        {
          paramView = paramView.a(paramContext, null, paramBundle);
          if ((paramView != null) && ((paramView instanceof PAImageView)))
          {
            float f = localResources.getDimensionPixelSize(2131558689);
            ((PAImageView)paramView).setUseRadiusRound(true, f);
            localObject5 = localObject2;
            localObject6 = localObject3;
            localObject7 = localObject1;
          }
        }
        else
        {
          if (("head".equals(localObject5)) && ((paramView instanceof StructMsgItemAvatar)) && (localObject2 == null))
          {
            ((StructMsgItemAvatar)paramView).e = i;
            localObject5 = (LinearLayout)paramView.a(paramContext, null, paramBundle);
            paramView = (View)localObject4;
            localObject6 = localObject3;
            localObject7 = localObject1;
            continue;
            label531:
            paramView = new StructMsgItemMore(paramContext.getString(2131438725)).a(paramContext, null, null);
            paramBundle = new LinearLayout.LayoutParams(-1, -2);
            j = AIOUtils.a(15.0F, localResources);
            paramView.setLayoutParams(paramBundle);
            paramView.setPadding(j, j, j, j);
            paramBundle = (TextView)paramView.findViewById(2131375172);
            paramBundle.setSingleLine();
            paramBundle.setEllipsize(TextUtils.TruncateAt.END);
            paramBundle.setTextSize(1, 18.0F);
            localLinearLayout.addView(paramView);
            if ((localObject3 == null) || (localObject1 == null) || (localObject4 == null) || (localObject2 == null)) {
              return localLinearLayout;
            }
            if (i == 4)
            {
              a(paramContext, localResources, localRelativeLayout, (View)localObject4, localObject2, localObject3, localObject1);
              paramBundle.setText("上周社交大数据新鲜出炉，请查阅。");
              return localLinearLayout;
            }
            localRelativeLayout.addView((View)localObject4, new RelativeLayout.LayoutParams(-1, -1));
            paramView = new RelativeLayout.LayoutParams(-2, -2);
            paramView.addRule(14);
            paramView.topMargin = AIOUtils.a(25.0F, localResources);
            localObject3.setLayoutParams(paramView);
            localObject3.setId(2131362332);
            localRelativeLayout.addView(localObject3);
            paramView = new RelativeLayout(paramContext);
            paramBundle = new RelativeLayout.LayoutParams(-2, -2);
            paramBundle.addRule(13);
            localObject1.setLayoutParams(paramBundle);
            paramView.addView(localObject1);
            paramBundle = new ImageView(paramContext);
            paramBundle.setImageResource(2130846091);
            localObject4 = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject4).addRule(0, localObject1.getId());
            ((RelativeLayout.LayoutParams)localObject4).addRule(15);
            ((RelativeLayout.LayoutParams)localObject4).rightMargin = AIOUtils.a(7.0F, localResources);
            paramView.addView(paramBundle, (ViewGroup.LayoutParams)localObject4);
            paramContext = new ImageView(paramContext);
            paramContext.setImageResource(2130846092);
            paramBundle = new RelativeLayout.LayoutParams(-2, -2);
            paramBundle.addRule(1, localObject1.getId());
            paramBundle.addRule(15);
            paramBundle.leftMargin = AIOUtils.a(7.0F, localResources);
            paramView.addView(paramContext, paramBundle);
            paramContext = new RelativeLayout.LayoutParams(-1, -2);
            paramContext.topMargin = AIOUtils.a(5.0F, localResources);
            paramContext.addRule(3, 2131362332);
            paramView.setLayoutParams(paramContext);
            paramView.setId(2131362334);
            localRelativeLayout.addView(paramView);
            paramContext = new RelativeLayout.LayoutParams(-2, -2);
            paramContext.addRule(14);
            paramContext.addRule(3, 2131362334);
            paramContext.topMargin = AIOUtils.a(10.0F, localResources);
            if (localObject2 != null)
            {
              localObject2.setId(2131362336);
              localObject2.setLayoutParams(paramContext);
              localRelativeLayout.addView(localObject2);
            }
            localObject3.setTextSize(2, 14.0F);
            localObject3.setTextColor(-1);
            localObject1.setTextSize(2, 30.0F);
            localObject1.setTextColor(-1);
            return localLinearLayout;
          }
          paramView = (View)localObject4;
          localObject5 = localObject2;
          localObject6 = localObject3;
          localObject7 = localObject1;
          continue;
        }
        localObject5 = localObject2;
        localObject6 = localObject3;
        localObject7 = localObject1;
      }
    }
  }
  
  public String b()
  {
    return "layout25";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout25
 * JD-Core Version:    0.7.0.1
 */