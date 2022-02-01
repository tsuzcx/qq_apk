package com.wifisdk.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.wifisdk.services.common.api.e;
import com.wifisdk.ui.api.RProxy.color;
import com.wifisdk.ui.api.RProxy.id;
import com.wifisdk.ui.api.RProxy.string;
import java.io.File;
import wf7.fm;
import wf7.fm.a;
import wf7.fq;
import wf7.hc.b;
import wf7.hl;
import wf7.hv;

public class WifiCommonView
  extends RelativeLayout
  implements View.OnClickListener
{
  private static final String TAG = "WifiCommonView";
  private hc.b sJ;
  private TextView uG;
  private int un = 1;
  private TextView vs;
  private TextView vt;
  private TextView vu;
  private ProgressBar vv;
  private TextView vw;
  private boolean vx;
  private Context vy;
  
  public WifiCommonView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WifiCommonView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WifiCommonView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private hc.b fJ()
  {
    return new WifiCommonView.1(this);
  }
  
  public void c(Context paramContext, int paramInt)
  {
    this.un = paramInt;
    this.vy = paramContext;
    this.vs = ((TextView)findViewById(RProxy.id.tmsdk_wifi_floor_title));
    this.vt = ((TextView)findViewById(RProxy.id.tmsdk_wifi_floor_des));
    this.vu = ((TextView)findViewById(RProxy.id.tmsdk_wifi_floor_button));
    this.vu.setOnClickListener(this);
    this.vv = ((ProgressBar)findViewById(RProxy.id.tmsdk_wifi_floor_progress));
    this.vw = ((TextView)findViewById(RProxy.id.tmsdk_wifi_floor_progress_text));
    this.uG = ((TextView)findViewById(RProxy.id.tmsdk_wifi_floor_tip));
  }
  
  public boolean fQ()
  {
    return this.vx;
  }
  
  public void fR()
  {
    int i = this.un;
    Object localObject5 = null;
    if (i == 1) {}
    try
    {
      localObject1 = fq.ek().getString("kfpt", null);
      if (localObject1 != null)
      {
        localObject1 = ((String)localObject1).split(File.separator);
        if ((localObject1 != null) && (localObject1.length == 3))
        {
          localObject2 = localObject1[0];
          localObject4 = localObject1[1];
        }
      }
    }
    catch (Throwable localThrowable1)
    {
      Object localObject1;
      Object localObject2;
      Object localObject4;
      Object localObject3;
      label108:
      int j;
      break label114;
    }
    try
    {
      localObject3 = new SpannableString((CharSequence)localObject4);
    }
    catch (Throwable localThrowable2)
    {
      break label108;
    }
    try
    {
      ((SpannableString)localObject3).setSpan(new ForegroundColorSpan(this.vy.getResources().getColor(RProxy.color.tmsdk_wifi_floor_text_color)), 0, ((String)localObject4).length(), 33);
      localObject1 = localObject1[2];
    }
    catch (Throwable localThrowable3)
    {
      break label121;
    }
    localObject3 = null;
    break label121;
    label114:
    localObject2 = null;
    localObject3 = localObject2;
    label121:
    localObject1 = null;
    break label135;
    localObject1 = null;
    localObject2 = localObject1;
    localObject3 = localObject2;
    label135:
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject3)))
    {
      localObject4 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    }
    else
    {
      localObject2 = this.vy.getString(RProxy.string.tmsdk_wifi_floor_content_title);
      localObject1 = this.vy.getString(RProxy.string.tmsdk_wifi_floor_content_des);
      localObject3 = new SpannableString((CharSequence)localObject1);
      ((SpannableString)localObject3).setSpan(new ForegroundColorSpan(this.vy.getResources().getColor(RProxy.color.tmsdk_wifi_floor_text_color)), 0, 3, 33);
      ((SpannableString)localObject3).setSpan(new ForegroundColorSpan(this.vy.getResources().getColor(RProxy.color.tmsdk_wifi_security_button_bg)), 4, ((String)localObject1).length(), 33);
      localObject4 = this.vy.getString(RProxy.string.tmsdk_wifi_floor_btn_text);
    }
    this.vs.setText((CharSequence)localObject2);
    this.vt.setText((CharSequence)localObject3);
    this.vu.setText((CharSequence)localObject4);
    localObject2 = fm.dL().dO();
    localObject1 = localObject5;
    if (localObject2 != null) {
      localObject1 = ((fm.a)localObject2).qu;
    }
    j = hl.i("com.tencent.wifimanager", (String)localObject1);
    i = 8;
    if (j == 3)
    {
      this.uG.setVisibility(8);
    }
    else
    {
      localObject1 = this.uG;
      if (j != 2) {
        i = 0;
      }
      ((TextView)localObject1).setVisibility(i);
    }
    if (this.sJ == null) {
      this.sJ = fJ();
    }
    hv.fD().a(this.sJ);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.vu)
    {
      this.vx = true;
      hv localhv = hv.fD();
      Context localContext = this.vy;
      int i;
      if (this.un == 1) {
        i = 8;
      } else {
        i = 4;
      }
      localhv.a(localContext, i);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    hv.fD().a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.wifisdk.ui.view.WifiCommonView
 * JD-Core Version:    0.7.0.1
 */