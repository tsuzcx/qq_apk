package com.tencent.mobileqq.flashshow.part.msg;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.flashshow.api.data.FSRedPointData;
import com.tencent.mobileqq.flashshow.part.FSBasePart;
import com.tencent.mobileqq.flashshow.viewmodel.msg.FSMsgBubbleViewModel;
import com.tencent.mobileqq.flashshow.widgets.msg.FSMsgBubbleView;
import com.tencent.qphone.base.util.QLog;

public class FSTabMsgBubblePart
  extends FSBasePart
{
  private FSMsgBubbleViewModel a;
  private FSMsgBubbleView b;
  private ViewStub c;
  
  private void a(FSRedPointData paramFSRedPointData)
  {
    f();
    FSMsgBubbleView localFSMsgBubbleView = this.b;
    if (localFSMsgBubbleView != null) {
      localFSMsgBubbleView.setData(paramFSRedPointData);
    }
  }
  
  private void e()
  {
    this.a = ((FSMsgBubbleViewModel)a(j(), null, FSMsgBubbleViewModel.class));
    FSMsgBubbleViewModel localFSMsgBubbleViewModel = this.a;
    if (localFSMsgBubbleViewModel != null) {
      localFSMsgBubbleViewModel.b().observe(j(), new FSTabMsgBubblePart.1(this));
    }
  }
  
  private void f()
  {
    Object localObject = this.c;
    if ((localObject != null) && (this.b == null))
    {
      localObject = (ViewGroup)((ViewStub)localObject).inflate();
      this.b = new FSMsgBubbleView(g());
      ((ViewGroup)localObject).addView(this.b);
    }
  }
  
  public String a()
  {
    return "FSTabMsgBubblePart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.c = ((ViewStub)paramView.findViewById(2131433863));
    e();
  }
  
  public void a(String paramString, Object paramObject)
  {
    int i = 0;
    QLog.d("FSTabMsgBubblePart", 1, new Object[] { "[handleBroadcastMessage] action: ", paramString });
    int j = paramString.hashCode();
    if (j != -305720601)
    {
      if ((j == 689464194) && (paramString.equals("tag_hide_msg_bubble")))
      {
        i = 1;
        break label72;
      }
    }
    else {
      if (paramString.equals("tag_show_msg_bubble")) {
        break label72;
      }
    }
    i = -1;
    label72:
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      paramString = this.b;
      if (paramString != null) {
        paramString.b();
      }
    }
    else
    {
      paramString = this.b;
      if (paramString != null) {
        paramString.a();
      }
    }
  }
  
  public void d()
  {
    FSMsgBubbleViewModel localFSMsgBubbleViewModel = this.a;
    if (localFSMsgBubbleViewModel != null) {
      localFSMsgBubbleViewModel.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.msg.FSTabMsgBubblePart
 * JD-Core Version:    0.7.0.1
 */