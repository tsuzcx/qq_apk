package com.tencent.mobileqq.gamecenter.view;

import aepi;
import alud;
import android.app.Activity;
import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import asnu;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;

public class MoreMsgHeaderView
  extends RelativeLayout
  implements asnu
{
  public MoreMsgHeaderView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(MessageRecord paramMessageRecord, Activity paramActivity)
  {
    paramMessageRecord = new TextView(getContext());
    paramMessageRecord.setText(alud.a(2131707269));
    paramMessageRecord.setTextColor(-16777216);
    paramMessageRecord.setAlpha(0.5F);
    paramMessageRecord.setEms(1);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(15);
    localLayoutParams.leftMargin = aepi.a(50.0F, paramActivity.getResources());
    addView(paramMessageRecord, localLayoutParams);
  }
  
  public void a(QQGameMsgInfo paramQQGameMsgInfo, Activity paramActivity, int paramInt)
  {
    paramQQGameMsgInfo = new TextView(getContext());
    paramQQGameMsgInfo.setText(alud.a(2131707269));
    paramQQGameMsgInfo.setTextColor(-16777216);
    paramQQGameMsgInfo.setAlpha(0.5F);
    paramQQGameMsgInfo.setEms(1);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(15);
    localLayoutParams.leftMargin = aepi.a(50.0F, paramActivity.getResources());
    addView(paramQQGameMsgInfo, localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.MoreMsgHeaderView
 * JD-Core Version:    0.7.0.1
 */