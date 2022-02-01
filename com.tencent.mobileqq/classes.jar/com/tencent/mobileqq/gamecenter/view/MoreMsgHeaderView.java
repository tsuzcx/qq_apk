package com.tencent.mobileqq.gamecenter.view;

import afur;
import android.app.Activity;
import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anni;
import auuq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;

public class MoreMsgHeaderView
  extends RelativeLayout
  implements auuq
{
  public MoreMsgHeaderView(Context paramContext)
  {
    super(paramContext);
  }
  
  public String a()
  {
    return "";
  }
  
  public void a() {}
  
  public void a(MessageRecord paramMessageRecord, Activity paramActivity)
  {
    paramMessageRecord = new TextView(getContext());
    paramMessageRecord.setText(anni.a(2131705660));
    paramMessageRecord.setTextColor(-16777216);
    paramMessageRecord.setAlpha(0.5F);
    paramMessageRecord.setEms(1);
    paramActivity = new RelativeLayout.LayoutParams(-2, -2);
    paramActivity.addRule(9);
    paramActivity.addRule(15);
    paramActivity.leftMargin = afur.a(50.0F, BaseApplicationImpl.getApplication().getResources());
    addView(paramMessageRecord, paramActivity);
  }
  
  public void a(QQGameMsgInfo paramQQGameMsgInfo, Activity paramActivity, int paramInt)
  {
    paramQQGameMsgInfo = new TextView(getContext());
    paramQQGameMsgInfo.setText(anni.a(2131705660));
    paramQQGameMsgInfo.setTextColor(-16777216);
    paramQQGameMsgInfo.setAlpha(0.5F);
    paramQQGameMsgInfo.setEms(1);
    paramActivity = new RelativeLayout.LayoutParams(-2, -2);
    paramActivity.addRule(9);
    paramActivity.addRule(15);
    paramActivity.leftMargin = afur.a(50.0F, BaseApplicationImpl.getApplication().getResources());
    addView(paramQQGameMsgInfo, paramActivity);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.MoreMsgHeaderView
 * JD-Core Version:    0.7.0.1
 */