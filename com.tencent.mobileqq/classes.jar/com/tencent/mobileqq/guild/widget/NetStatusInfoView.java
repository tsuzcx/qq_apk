package com.tencent.mobileqq.guild.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

public class NetStatusInfoView
  extends FrameLayout
{
  private final ImageView a;
  private final TextView b;
  private final BroadcastReceiver c;
  private final Context d;
  
  public NetStatusInfoView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NetStatusInfoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NetStatusInfoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.d = paramContext;
    paramContext = LayoutInflater.from(paramContext).inflate(2131625097, this);
    this.a = ((ImageView)paramContext.findViewById(2131439198));
    this.b = ((TextView)paramContext.findViewById(2131439200));
    this.c = new NetStatusInfoView.1(this);
    a();
  }
  
  private void d()
  {
    boolean bool = NetworkUtil.isNetSupportHw(this.d);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[updateVisible] isNetSupport = ");
    localStringBuilder.append(bool);
    QLog.d("NetStatusInfoView", 1, localStringBuilder.toString());
    int i;
    if (bool) {
      i = 8;
    } else {
      i = 0;
    }
    setVisibility(i);
  }
  
  public void a()
  {
    QLog.d("NetStatusInfoView", 1, "[registerReceiver]");
    IntentFilter localIntentFilter = new IntentFilter(new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    try
    {
      this.d.registerReceiver(this.c, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.d("NetStatusInfoView", 1, "[registerReceiver] catch exception");
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      d();
    }
  }
  
  public void b()
  {
    QLog.d("NetStatusInfoView", 1, "[unregisterReceiver]");
    try
    {
      this.d.unregisterReceiver(this.c);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.d("NetStatusInfoView", 1, "[unregisterReceiver] catch exception");
    }
  }
  
  public void c()
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.widget.NetStatusInfoView
 * JD-Core Version:    0.7.0.1
 */