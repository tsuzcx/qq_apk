package com.tencent.mobileqq.vas.qvip.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.vas.qvip.QQVipMsgInfo;
import com.tencent.mobileqq.vas.qvip.util.QQVipHelper;
import com.tencent.mobileqq.widget.RoundImageView;
import cooperation.qzone.mobilereport.MobileReportManager;

public class ImgHeaderView
  extends RelativeLayout
  implements IHeaderView
{
  private RelativeLayout a;
  private TextView b;
  private RoundImageView c;
  private String d;
  private Button e;
  
  public ImgHeaderView(Context paramContext)
  {
    super(paramContext);
    setBackgroundColor(0);
  }
  
  private void a(Activity paramActivity, String paramString1, String paramString2, int paramInt, QQVipMsgInfo paramQQVipMsgInfo)
  {
    if (!TextUtils.isEmpty(this.d))
    {
      paramString1 = new Intent(paramActivity, QQBrowserActivity.class);
      paramString1.putExtra("url", this.d);
      paramActivity.startActivity(paramString1);
    }
    else
    {
      QQVipHelper.a(paramActivity);
    }
    paramActivity = MobileReportManager.getInstance();
    paramString1 = new StringBuilder();
    paramString1.append(paramInt + 1);
    paramString1.append("");
    paramActivity.reportAction("QQVipAccount", "1", "1", paramString1.toString(), "", "1", 102, 1);
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
    try
    {
      this.d = paramQQVipMsgInfo.mUrl;
      this.a = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131628225, this, false));
      this.a.setBackgroundColor(0);
      this.c = ((RoundImageView)this.a.findViewById(2131435543));
      this.c.setmRadius(UIUtils.a(getContext(), 6.0F), true);
      URLDrawable localURLDrawable = URLDrawable.getDrawable(paramQQVipMsgInfo.mCoverUrl);
      this.c.setImageDrawable(localURLDrawable);
      this.b = ((TextView)this.a.findViewById(2131447062));
      this.b.setText(paramQQVipMsgInfo.mTitle);
      this.e = ((Button)this.a.findViewById(2131431774));
      this.e.setOnClickListener(new ImgHeaderView.1(this, paramActivity, paramQQVipMsgInfo, paramInt));
      this.a.setOnClickListener(new ImgHeaderView.2(this, paramActivity, paramQQVipMsgInfo, paramInt));
      addView(this.a);
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
 * Qualified Name:     com.tencent.mobileqq.vas.qvip.view.ImgHeaderView
 * JD-Core Version:    0.7.0.1
 */