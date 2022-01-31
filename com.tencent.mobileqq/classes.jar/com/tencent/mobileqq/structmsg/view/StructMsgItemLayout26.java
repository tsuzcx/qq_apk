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
import com.tencent.mobileqq.nearby.FaceScoreUtils;
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
  public static final int a(String paramString)
  {
    int j = 0;
    int i = j;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      i = new JSONObject(paramString).optInt("msgType", 0);
      return i;
    }
    catch (Exception paramString)
    {
      do
      {
        i = j;
      } while (!QLog.isColorLevel());
      QLog.e("StructMsg", 2, "generate 26: " + QLog.getStackTraceString(paramString));
    }
    return 0;
  }
  
  private RelativeLayout a(Context paramContext)
  {
    BubbleViewLayout localBubbleViewLayout = new BubbleViewLayout(paramContext);
    localBubbleViewLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    localBubbleViewLayout.setId(2131365643);
    localBubbleViewLayout.setRadius(10.0F);
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    localLinearLayout.setPadding(0, 0, 0, AIOUtils.a(10.0F, paramContext.getResources()));
    localLinearLayout.setOrientation(1);
    localLinearLayout.setId(2131361995);
    localLinearLayout.setBackgroundColor(-1);
    localBubbleViewLayout.addView(localLinearLayout);
    return localBubbleViewLayout;
  }
  
  protected int b()
  {
    return 26;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Resources localResources = paramContext.getResources();
    int j = a(paramBundle.getString("extraData"));
    RelativeLayout localRelativeLayout = a(paramContext);
    LinearLayout localLinearLayout2 = (LinearLayout)localRelativeLayout.findViewById(2131361995);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    Object localObject1 = null;
    LinearLayout localLinearLayout1 = null;
    Object localObject3 = null;
    Object localObject2 = paramView;
    paramView = (View)localObject3;
    int i;
    if (localIterator.hasNext())
    {
      localObject2 = (AbsStructMsgElement)localIterator.next();
      ((AbsStructMsgElement)localObject2).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
      localObject3 = ((AbsStructMsgElement)localObject2).jdField_a_of_type_JavaLangString;
      if ((("picture".equals(localObject3)) || ("vote".equals(localObject3)) || ("video".equals(localObject3))) && (localObject1 == null))
      {
        localObject1 = ((AbsStructMsgElement)localObject2).a(paramContext, null, paramBundle);
        i = AIOUtils.a(200.0F, localResources);
        if (!(localObject2 instanceof StructMsgItemCover)) {
          break label724;
        }
        localObject2 = (StructMsgItemCover)localObject2;
        if (((StructMsgItemCover)localObject2).f > 0)
        {
          i = ((StructMsgItemCover)localObject2).f;
          label182:
          if ((j & 0x2) == 0) {
            break label721;
          }
          localObject2 = new RelativeLayout(paramContext);
          localObject3 = new RelativeLayout.LayoutParams(-1, i);
          ((RelativeLayout.LayoutParams)localObject3).addRule(14);
          ((RelativeLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
          localObject1 = new ImageView(paramContext);
          ((ImageView)localObject1).setImageResource(2130839712);
          localObject3 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject3).addRule(13);
          ((RelativeLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
          localObject1 = localObject2;
        }
      }
    }
    label294:
    label584:
    label594:
    label724:
    for (;;)
    {
      localLinearLayout2.addView((View)localObject1, new LinearLayout.LayoutParams(-1, i));
      for (;;)
      {
        if (localObject1 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("StructMsg", 2, "generate 26 item failure.");
          }
          paramContext = null;
        }
        do
        {
          do
          {
            return paramContext;
            break label182;
            if ("summary".equals(localObject3))
            {
              paramView = (TextView)((AbsStructMsgElement)localObject2).a(paramContext, null, paramBundle);
              localLinearLayout2.addView(paramView);
              break label294;
            }
            if (!"taglist".equals(localObject3)) {
              break label718;
            }
            localLinearLayout1 = (LinearLayout)((AbsStructMsgElement)localObject2).a(paramContext, null, paramBundle);
            localObject2 = new LinearLayout.LayoutParams(-1, -2);
            ((LinearLayout.LayoutParams)localObject2).setMargins(0, AIOUtils.a(10.0F, localResources), 0, AIOUtils.a(6.0F, localResources));
            localLinearLayout2.addView(localLinearLayout1, (ViewGroup.LayoutParams)localObject2);
            break label294;
            localObject2 = localRelativeLayout;
            break;
            boolean bool = paramBundle.getBoolean("isSend", true);
            ((BubbleViewLayout)((View)localObject2).findViewById(2131365643)).a = bool;
            if (!bool) {
              break label645;
            }
            if (localLinearLayout1 != null) {
              localLinearLayout1.setPadding(AIOUtils.a(12.0F, localResources), 0, AIOUtils.a(22.0F, localResources), 0);
            }
            if (paramView != null) {
              paramView.setPadding(AIOUtils.a(12.0F, localResources), 0, AIOUtils.a(22.0F, localResources), 0);
            }
            if ((AppSetting.b) && (paramView != null))
            {
              paramContext = new StringBuilder();
              paramContext.append(paramView.getText());
              localLinearLayout2.setContentDescription(paramContext.toString());
            }
            paramContext = (Context)localObject2;
          } while (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg == null);
          paramContext = (Context)localObject2;
        } while (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message == null);
        if (FaceScoreUtils.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message, "isFaceScoreSecondMember"))
        {
          paramContext = "2";
          if ((j & 0x2) == 0) {
            break label705;
          }
          i = 1;
          paramBundle = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.uin;
          if (i == 0) {
            break label711;
          }
        }
        for (paramView = "2";; paramView = "1")
        {
          FaceScoreUtils.a("exp_obj", paramBundle, new String[] { paramContext, "", "", paramView });
          return localObject2;
          if (localLinearLayout1 != null) {
            localLinearLayout1.setPadding(AIOUtils.a(22.0F, localResources), 0, AIOUtils.a(12.0F, localResources), 0);
          }
          if (paramView == null) {
            break;
          }
          paramView.setPadding(AIOUtils.a(22.0F, localResources), 0, AIOUtils.a(12.0F, localResources), 0);
          break;
          paramContext = "1";
          break label584;
          i = 0;
          break label594;
        }
      }
    }
  }
  
  public String b()
  {
    return "Layout26";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout26
 * JD-Core Version:    0.7.0.1
 */