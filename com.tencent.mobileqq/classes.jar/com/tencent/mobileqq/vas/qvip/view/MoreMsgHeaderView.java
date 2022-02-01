package com.tencent.mobileqq.vas.qvip.view;

import android.app.Activity;
import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.vas.qvip.QQVipMsgInfo;

public class MoreMsgHeaderView
  extends RelativeLayout
  implements IHeaderView
{
  public MoreMsgHeaderView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(QQVipMsgInfo paramQQVipMsgInfo, Activity paramActivity, int paramInt)
  {
    paramQQVipMsgInfo = new TextView(getContext());
    paramQQVipMsgInfo.setText(HardCodeUtil.a(2131706888));
    paramQQVipMsgInfo.setTextColor(-16777216);
    paramQQVipMsgInfo.setAlpha(0.5F);
    paramQQVipMsgInfo.setEms(1);
    paramActivity = new RelativeLayout.LayoutParams(-2, -2);
    paramActivity.addRule(9);
    paramActivity.addRule(15);
    paramActivity.leftMargin = AIOUtils.a(50.0F, BaseApplicationImpl.getApplication().getResources());
    addView(paramQQVipMsgInfo, paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qvip.view.MoreMsgHeaderView
 * JD-Core Version:    0.7.0.1
 */