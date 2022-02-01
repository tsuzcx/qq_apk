package com.tencent.mobileqq.vas.qvip.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.vas.qvip.QQVipMsgInfo;
import com.tencent.mobileqq.vas.qvip.util.QQVipHelper;
import cooperation.qzone.mobilereport.MobileReportManager;

public class TextHeaderView
  extends RelativeLayout
  implements IHeaderView
{
  private RelativeLayout a;
  private TextView b;
  private TextView c;
  private View d;
  private String e;
  private String f;
  private String g;
  
  public TextHeaderView(Context paramContext)
  {
    super(paramContext);
    setBackgroundColor(0);
  }
  
  private void a(Activity paramActivity, int paramInt, QQVipMsgInfo paramQQVipMsgInfo)
  {
    if (!TextUtils.isEmpty(this.g))
    {
      localObject = new Intent(paramActivity, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", this.g);
      paramActivity.startActivity((Intent)localObject);
    }
    else
    {
      QQVipHelper.a(paramActivity);
    }
    paramActivity = MobileReportManager.getInstance();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt + 1);
    ((StringBuilder)localObject).append("");
    paramActivity.reportAction("QQVipAccount", "1", "1", ((StringBuilder)localObject).toString(), "", "1", 102, 1);
    try
    {
      QQVipHelper.a(118, paramQQVipMsgInfo, paramInt);
      return;
    }
    catch (Throwable paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  public void a(QQVipMsgInfo paramQQVipMsgInfo, Activity paramActivity, int paramInt)
  {
    this.e = paramQQVipMsgInfo.mTitle;
    this.f = paramQQVipMsgInfo.mContentText;
    this.g = paramQQVipMsgInfo.mUrl;
    this.a = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131628226, this, false));
    this.a.setBackgroundColor(0);
    this.b = ((TextView)this.a.findViewById(2131447463));
    this.b.setText(this.e);
    this.c = ((TextView)this.a.findViewById(2131447062));
    this.c.setText(this.f);
    this.d = this.a.findViewById(2131437976);
    URLDrawable localURLDrawable = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/welling-test/qqvip/background_android@2x.png");
    this.d.setBackground(localURLDrawable);
    this.a.findViewById(2131431774).setOnClickListener(new TextHeaderView.1(this, paramActivity, paramInt, paramQQVipMsgInfo));
    this.a.setOnClickListener(new TextHeaderView.2(this, paramActivity, paramInt, paramQQVipMsgInfo));
    addView(this.a);
    try
    {
      QQVipHelper.a(117, paramQQVipMsgInfo, paramInt);
      return;
    }
    catch (Throwable paramQQVipMsgInfo)
    {
      paramQQVipMsgInfo.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qvip.view.TextHeaderView
 * JD-Core Version:    0.7.0.1
 */