package com.tencent.mobileqq.kandian.biz.tab;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.kandian.base.view.widget.ReadinjoySlidingIndicator;
import com.tencent.mobileqq.kandian.biz.video.ReadInJoyVideoChannelFragment;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;

class ReadinjoyTabFrame$17
  extends Handler
{
  ReadinjoyTabFrame$17(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        if (paramMessage.arg1 > 0)
        {
          paramMessage = new BusinessInfoCheckUpdate.RedTypeInfo();
          paramMessage.red_type.set(0);
          ReadinjoyTabFrame.a(this.a).a(paramMessage);
          ReadinjoyTabFrame.a(this.a).invalidate();
        }
        else
        {
          ReadinjoyTabFrame.a(this.a).d();
          ReadinjoyTabFrame.a(this.a).invalidate();
        }
        QLog.d("Q.readinjoy.4tab", 2, "update self icon red point for coin campaign");
        return;
      }
      i = paramMessage.arg1;
      int j = paramMessage.arg2;
      if ((i > 0) && ((j != 2131376141) || (!(this.a.a() instanceof ReadInJoyVideoChannelFragment))))
      {
        Object localObject = new BusinessInfoCheckUpdate.RedTypeInfo();
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_type.set(0);
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_content.set(String.valueOf(i));
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_desc.set("{'cn':'#FF0000'}");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("update indicator red point , index : ");
        ((StringBuilder)localObject).append(paramMessage.obj);
        ((StringBuilder)localObject).append(", value : ");
        ((StringBuilder)localObject).append(i);
        QLog.d("Q.readinjoy.4tab", 2, ((StringBuilder)localObject).toString());
        return;
      }
      ReadinjoyTabFrame.a(this.a).a(j);
      return;
    }
    i = paramMessage.arg1;
    if (i > 0)
    {
      paramMessage = new BusinessInfoCheckUpdate.RedTypeInfo();
      paramMessage.red_content.set(String.valueOf(i));
      paramMessage.red_desc.set("{'cn':'#FF0000'}");
      paramMessage.red_type.set(5);
      ReadinjoyTabFrame.a(this.a).a(paramMessage);
      ReadinjoyTabFrame.a(this.a).invalidate();
    }
    else
    {
      ReadinjoyTabFrame.a(this.a).d();
      ReadinjoyTabFrame.a(this.a).invalidate();
    }
    paramMessage = new StringBuilder();
    paramMessage.append("update self icon red point, value : ");
    paramMessage.append(i);
    QLog.d("Q.readinjoy.4tab", 2, paramMessage.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadinjoyTabFrame.17
 * JD-Core Version:    0.7.0.1
 */