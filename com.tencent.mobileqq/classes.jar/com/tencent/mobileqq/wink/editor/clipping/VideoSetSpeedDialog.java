package com.tencent.mobileqq.wink.editor.clipping;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class VideoSetSpeedDialog
  extends ReportDialog
{
  HashMap<Float, TextView> a = new HashMap();
  float b = 1.0F;
  VideoSetSpeedDialog.OnSpeedChangeListener c;
  private final int d = getContext().getResources().getColor(2131168464);
  private final int e = getContext().getResources().getColor(2131165601);
  private TextView f;
  private TextView g;
  private TextView h;
  private TextView i;
  private TextView j;
  private int k = DisplayUtil.a(getContext(), 212.0F);
  private int l = DisplayUtil.a(getContext(), 12.0F);
  private int m = 85;
  private View n;
  
  public VideoSetSpeedDialog(Context paramContext, int paramInt)
  {
    super(paramContext, 2131952062);
    a();
  }
  
  private void a()
  {
    this.n = LayoutInflater.from(getContext()).inflate(2131628256, null);
    c();
    this.f = ((TextView)this.n.findViewById(2131448866));
    this.g = ((TextView)this.n.findViewById(2131448754));
    this.h = ((TextView)this.n.findViewById(2131448760));
    this.i = ((TextView)this.n.findViewById(2131448674));
    this.j = ((TextView)this.n.findViewById(2131448865));
    this.f.setOnClickListener(new VideoSetSpeedDialog.OnItemSelectListener(this, 0.5F));
    this.g.setOnClickListener(new VideoSetSpeedDialog.OnItemSelectListener(this, 0.75F));
    this.h.setOnClickListener(new VideoSetSpeedDialog.OnItemSelectListener(this, 1.0F));
    this.i.setOnClickListener(new VideoSetSpeedDialog.OnItemSelectListener(this, 1.5F));
    this.j.setOnClickListener(new VideoSetSpeedDialog.OnItemSelectListener(this, 2.0F));
    this.a.put(Float.valueOf(0.5F), this.f);
    this.a.put(Float.valueOf(0.75F), this.g);
    this.a.put(Float.valueOf(1.0F), this.h);
    this.a.put(Float.valueOf(1.5F), this.i);
    this.a.put(Float.valueOf(2.0F), this.j);
    a(this.f, "em_xsj_speed_button");
  }
  
  private void a(View paramView, String paramString)
  {
    VideoReport.setElementId(paramView, paramString);
    VideoReport.setElementExposePolicy(paramView, ExposurePolicy.REPORT_NONE);
    VideoReport.setElementClickPolicy(paramView, ClickPolicy.REPORT_ALL);
  }
  
  private void b()
  {
    Object localObject1 = this.a;
    if (localObject1 != null)
    {
      localObject1 = ((HashMap)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        boolean bool = SpeedFloatUtil.a(((Float)((Map.Entry)localObject2).getKey()).floatValue(), this.b);
        ((TextView)((Map.Entry)localObject2).getValue()).setSelected(bool);
        localObject2 = (TextView)((Map.Entry)localObject2).getValue();
        int i1;
        if (bool) {
          i1 = this.e;
        } else {
          i1 = this.d;
        }
        ((TextView)localObject2).setTextColor(i1);
      }
    }
  }
  
  private void c()
  {
    if (this.n == null) {
      return;
    }
    VideoReport.addToDetectionWhitelist(getOwnerActivity());
    VideoReport.setPageId(this.n, "pg_xsj_edit_page");
    VideoReport.setPageParams(this.n, new WinkDTParamBuilder().buildPageParams(null));
    VideoReport.ignorePageInOutEvent(this.n, true);
  }
  
  public void a(float paramFloat)
  {
    this.b = paramFloat;
    b();
  }
  
  public void a(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void a(VideoSetSpeedDialog.OnSpeedChangeListener paramOnSpeedChangeListener)
  {
    this.c = paramOnSpeedChangeListener;
  }
  
  public void b(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void c(int paramInt)
  {
    this.m = paramInt;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void show()
  {
    setCancelable(true);
    setCanceledOnTouchOutside(true);
    super.show();
    Window localWindow = getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localWindow.setGravity(this.m);
    localLayoutParams.y = this.k;
    localLayoutParams.x = this.l;
    localLayoutParams.dimAmount = 0.1F;
    localWindow.setAttributes(localLayoutParams);
    localWindow.setLayout(DisplayUtil.a(getContext(), 65.0F), -2);
    localWindow.setContentView(this.n);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.VideoSetSpeedDialog
 * JD-Core Version:    0.7.0.1
 */