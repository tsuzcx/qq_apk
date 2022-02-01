package com.tencent.mobileqq.flashshow.widgets.msg;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.flashshow.api.data.DataBuilder;
import com.tencent.mobileqq.flashshow.api.data.FSRedPointData;
import com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11001;
import com.tencent.mobileqq.flashshow.widgets.FSBaseWidgetView;
import com.tencent.mobileqq.flashshow.widgets.common.FSAvatarListView;
import com.tencent.qphone.base.util.QLog;

public class FSMsgBubbleView
  extends FSBaseWidgetView<FSRedPointData>
{
  private FrameLayout a;
  private FSAvatarListView b;
  private TextView c;
  private FSMsgBubbleInfo d;
  
  public FSMsgBubbleView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public FSMsgBubbleView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FSMsgBubbleView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(@NonNull FSRedPointData paramFSRedPointData)
  {
    this.d = new FSMsgBubbleInfo(paramFSRedPointData);
    if (!this.d.d())
    {
      QLog.e("FSMsgBubbleView", 1, "initMsgBubbleContent error,invalid data");
      g();
      return;
    }
    d();
  }
  
  private void c()
  {
    if (this.d == null) {
      return;
    }
    DataBuilder localDataBuilder = new DataBuilder(getReportBean()).setActionType(18).setSubActionType(2).setThrActionType(0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.d.f());
    localStringBuilder.append("");
    FSLpReportDc11001.a(localDataBuilder.setExt5(localStringBuilder.toString()).setExt6(this.d.e()));
  }
  
  private void d()
  {
    QLog.d("FSMsgBubbleView", 1, "initMsgBubbleUI");
    FSMsgBubbleInfo localFSMsgBubbleInfo = this.d;
    if ((localFSMsgBubbleInfo != null) && (localFSMsgBubbleInfo.d()))
    {
      this.c.setText(this.d.b());
      this.b.setDataGeneral(this.d.a(), null);
    }
  }
  
  private void e()
  {
    QLog.d("FSMsgBubbleView", 1, "showBubbleView");
    f();
    if (this.a.getVisibility() == 0) {
      return;
    }
    this.a.animate().setDuration(200L).alpha(1.0F).setListener(new FSMsgBubbleView.2(this));
  }
  
  private void f()
  {
    QLog.d("FSMsgBubbleView", 1, "reportBubbleExpose");
    DataBuilder localDataBuilder = new DataBuilder(getReportBean()).setActionType(18).setSubActionType(1).setThrActionType(0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.d.f());
    localStringBuilder.append("");
    FSLpReportDc11001.a(localDataBuilder.setExt5(localStringBuilder.toString()).setExt6(this.d.e()));
  }
  
  private void g()
  {
    QLog.d("FSMsgBubbleView", 1, "hideBubbleView");
    if (this.a.getVisibility() == 8) {
      return;
    }
    this.a.animate().setDuration(200L).alpha(0.0F).setListener(new FSMsgBubbleView.3(this));
  }
  
  public void a()
  {
    QLog.d("FSMsgBubbleView", 1, "activateBubbleView");
    FSMsgBubbleInfo localFSMsgBubbleInfo = this.d;
    if ((localFSMsgBubbleInfo != null) && (localFSMsgBubbleInfo.d()))
    {
      e();
      return;
    }
    this.a.setVisibility(8);
  }
  
  protected void a(FSRedPointData paramFSRedPointData, int paramInt)
  {
    this.d = null;
    if ((paramFSRedPointData != null) && (paramFSRedPointData.hasRedPointInfo()))
    {
      a(paramFSRedPointData);
      return;
    }
    this.a.setVisibility(8);
  }
  
  public void b()
  {
    QLog.d("FSMsgBubbleView", 1, "inactivateBubbleView");
    g();
  }
  
  public int getLayoutId()
  {
    return 2131624816;
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.a = ((FrameLayout)paramView.findViewById(2131437496));
    this.b = ((FSAvatarListView)paramView.findViewById(2131428292));
    this.c = ((TextView)paramView.findViewById(2131448584));
    this.a.setOnClickListener(new FSMsgBubbleView.1(this, paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.msg.FSMsgBubbleView
 * JD-Core Version:    0.7.0.1
 */