package com.tencent.mobileqq.hotpic;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.XPanelContainer;

@TargetApi(15)
public class PublicAccountHotPicPanel
  extends HotPicMainPanel
{
  PublicAccountGifListener y;
  
  public PublicAccountHotPicPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  @TargetApi(14)
  public void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, PanelIconLinearLayout paramPanelIconLinearLayout, XPanelContainer paramXPanelContainer)
  {
    this.f = paramQQAppInterface;
    this.g = paramBaseActivity;
    this.o = paramBaseActivity;
    this.l = paramPanelIconLinearLayout;
    this.m = paramXPanelContainer;
    this.n = new SessionInfo();
    this.i = findViewById(2131437622);
    this.k = findViewById(2131435175);
    this.j = LayoutInflater.from(this.g).inflate(2131624102, null);
    this.j.setVisibility(8);
    this.p = ((ViewPager)findViewById(2131435181));
    this.t = ((HotPicTab)findViewById(2131435162));
    this.t.setOnItemClickListener(this);
    this.n.a = 1008;
  }
  
  public void c() {}
  
  public void d() {}
  
  public void setPublicAccountGifListener(PublicAccountGifListener paramPublicAccountGifListener)
  {
    this.y = paramPublicAccountGifListener;
    HotPicManager.a(this.f).a(paramPublicAccountGifListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.PublicAccountHotPicPanel
 * JD-Core Version:    0.7.0.1
 */