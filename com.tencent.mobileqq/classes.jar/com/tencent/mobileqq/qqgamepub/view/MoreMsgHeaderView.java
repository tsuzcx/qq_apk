package com.tencent.mobileqq.qqgamepub.view;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.utils.UIUtils;
import mqq.app.MobileQQ;

public class MoreMsgHeaderView
  extends RelativeLayout
  implements IHeaderView
{
  public MoreMsgHeaderView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a() {}
  
  public void a(QQGameMsgInfo paramQQGameMsgInfo, Context paramContext, int paramInt, String paramString)
  {
    paramQQGameMsgInfo = new TextView(getContext());
    paramQQGameMsgInfo.setText(HardCodeUtil.a(2131892941));
    paramQQGameMsgInfo.setTextColor(-16777216);
    paramQQGameMsgInfo.setAlpha(0.5F);
    paramQQGameMsgInfo.setEms(1);
    paramContext = new RelativeLayout.LayoutParams(-2, -2);
    paramContext.addRule(9);
    paramContext.addRule(15);
    paramContext.leftMargin = UIUtils.a(50.0F, MobileQQ.sMobileQQ.getResources());
    addView(paramQQGameMsgInfo, paramContext);
  }
  
  public void b() {}
  
  public void c() {}
  
  public String getAppName()
  {
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.view.MoreMsgHeaderView
 * JD-Core Version:    0.7.0.1
 */