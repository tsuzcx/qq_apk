package com.tencent.mobileqq.richstatus.sign;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;

public class AIOSignViewHolder
  extends BaseSignViewHolder
{
  TextView a;
  public String b;
  public int c;
  public long d;
  public int e;
  public String f;
  public int g;
  public int h;
  
  public AIOSignViewHolder(Context paramContext, AppInterface paramAppInterface, View paramView, String paramString)
  {
    super(paramContext, paramAppInterface, paramView, paramString);
    this.u = 2;
    this.F = 2130847783;
    VasWebviewUtil.a(paramAppInterface.getCurrentAccountUin(), "signature_aio", "show", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
  }
  
  public View a(RichStatus paramRichStatus)
  {
    paramRichStatus = super.a(paramRichStatus);
    this.a.setText(this.b);
    this.a.setTextColor(this.c);
    this.p.mMsgId = this.d;
    w();
    return paramRichStatus;
  }
  
  protected void a()
  {
    this.E = AIOUtils.b(16.0F, this.v.getResources());
    super.a();
    this.a = new TextView(this.v);
    this.c = this.v.getResources().getColor(2131167337);
    this.a.setTextColor(this.c);
    this.a.setTextSize(1, 12.0F);
    this.a.setGravity(17);
    int i = AIOUtils.b(36.0F, this.v.getResources());
    Object localObject = new FrameLayout.LayoutParams(-1, i);
    this.i.addView(this.a, (ViewGroup.LayoutParams)localObject);
    this.i.setYOffset(i + AIOUtils.b(10.0F, this.v.getResources()));
    i = (int)(ScreenUtil.SCREEN_WIDTH * 0.11F);
    this.i.a(i);
    localObject = (ViewGroup.MarginLayoutParams)this.q.getLayoutParams();
    localObject = (ViewGroup.MarginLayoutParams)this.p.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = AIOUtils.b(12.0F, this.v.getResources());
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = AIOUtils.b(12.0F, this.v.getResources());
  }
  
  protected boolean b()
  {
    return true;
  }
  
  protected int c()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.sign.AIOSignViewHolder
 * JD-Core Version:    0.7.0.1
 */