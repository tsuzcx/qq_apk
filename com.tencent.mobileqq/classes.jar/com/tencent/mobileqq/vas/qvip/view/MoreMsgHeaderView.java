package com.tencent.mobileqq.vas.qvip.view;

import android.app.Activity;
import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anvx;
import bhsh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.vas.qvip.QQVipMsgInfo;

public class MoreMsgHeaderView
  extends RelativeLayout
  implements bhsh
{
  public MoreMsgHeaderView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(QQVipMsgInfo paramQQVipMsgInfo, Activity paramActivity, int paramInt)
  {
    paramQQVipMsgInfo = new TextView(getContext());
    paramQQVipMsgInfo.setText(anvx.a(2131706348));
    paramQQVipMsgInfo.setTextColor(-16777216);
    paramQQVipMsgInfo.setAlpha(0.5F);
    paramQQVipMsgInfo.setEms(1);
    paramActivity = new RelativeLayout.LayoutParams(-2, -2);
    paramActivity.addRule(9);
    paramActivity.addRule(15);
    paramActivity.leftMargin = AIOUtils.dp2px(50.0F, BaseApplicationImpl.getApplication().getResources());
    addView(paramQQVipMsgInfo, paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qvip.view.MoreMsgHeaderView
 * JD-Core Version:    0.7.0.1
 */