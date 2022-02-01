package com.wifisdk.ui.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wifisdk.ui.api.RProxy.anim;
import com.wifisdk.ui.api.RProxy.id;
import java.util.List;
import wf7.hn;
import wf7.hs;

public class c
{
  private Context mContext;
  private Handler uD = new c.1(this, Looper.getMainLooper());
  private ListView uH;
  private hs vk;
  private b vl;
  private RelativeLayout vm;
  private ImageView vn;
  private ImageView vo;
  private TextView vp;
  private Animation vq;
  
  public c(Context paramContext, View paramView)
  {
    this.mContext = paramContext;
    this.vm = ((RelativeLayout)paramView.findViewById(RProxy.id.wifi_sdk_security_header_container));
    this.vn = ((ImageView)paramView.findViewById(RProxy.id.tmsdk_wifi_checking_img));
    this.vo = ((ImageView)paramView.findViewById(RProxy.id.tmsdk_wifi_checking_img_rotate));
    this.vp = ((TextView)paramView.findViewById(RProxy.id.tmsdk_wifi_checking_state));
    fP();
    this.uH = ((ListView)paramView.findViewById(RProxy.id.wifi_sdk_security_list));
    this.vl = new b(this.mContext);
    this.uH.setAdapter(this.vl);
  }
  
  private void fN()
  {
    this.uD.removeMessages(1);
    this.uD.removeMessages(2);
    this.uD.removeMessages(3);
    this.uD.removeMessages(4);
  }
  
  private void fP()
  {
    this.vq = AnimationUtils.loadAnimation(this.mContext, RProxy.anim.tmsdk_wifi_secure_rotate);
    LinearInterpolator localLinearInterpolator = new LinearInterpolator();
    this.vq.setInterpolator(localLinearInterpolator);
  }
  
  public void aE(int paramInt)
  {
    fN();
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.arg1 = paramInt;
    this.uD.sendMessage(localMessage);
  }
  
  public void aF(int paramInt)
  {
    fN();
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    localMessage.arg1 = paramInt;
    this.uD.sendMessage(localMessage);
  }
  
  public void aG(int paramInt)
  {
    fN();
    Message localMessage = Message.obtain();
    localMessage.what = 4;
    localMessage.arg1 = paramInt;
    this.uD.sendMessage(localMessage);
  }
  
  public void fO()
  {
    fN();
    this.uD.sendEmptyMessage(1);
  }
  
  public void l(hs paramhs)
  {
    this.vk = paramhs;
  }
  
  public void t(List<hn> paramList)
  {
    this.uD.removeMessages(5);
    Message localMessage = Message.obtain();
    localMessage.what = 5;
    localMessage.obj = paramList;
    this.uD.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.wifisdk.ui.view.c
 * JD-Core Version:    0.7.0.1
 */