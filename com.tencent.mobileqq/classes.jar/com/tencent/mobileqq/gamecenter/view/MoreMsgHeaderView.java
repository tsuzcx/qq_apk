package com.tencent.mobileqq.gamecenter.view;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;

public class MoreMsgHeaderView
  extends RelativeLayout
  implements IHeaderView
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
  
  public void a(QQGameMsgInfo paramQQGameMsgInfo, Context paramContext, int paramInt, String paramString)
  {
    paramQQGameMsgInfo = new TextView(getContext());
    paramQQGameMsgInfo.setText(HardCodeUtil.a(2131706888));
    paramQQGameMsgInfo.setTextColor(-16777216);
    paramQQGameMsgInfo.setAlpha(0.5F);
    paramQQGameMsgInfo.setEms(1);
    paramContext = new RelativeLayout.LayoutParams(-2, -2);
    paramContext.addRule(9);
    paramContext.addRule(15);
    paramContext.leftMargin = AIOUtils.a(50.0F, BaseApplicationImpl.getApplication().getResources());
    addView(paramQQGameMsgInfo, paramContext);
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.MoreMsgHeaderView
 * JD-Core Version:    0.7.0.1
 */