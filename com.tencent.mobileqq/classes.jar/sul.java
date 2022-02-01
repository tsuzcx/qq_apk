import android.os.Handler;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyVideoChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoySlidingIndicator;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;

public class sul
  extends Handler
{
  public sul(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
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
      for (;;)
      {
        QLog.d("Q.readinjoy.4tab", 2, "update self icon red point, value : " + i);
        return;
        ReadinjoyTabFrame.a(this.a).d();
        ReadinjoyTabFrame.a(this.a).invalidate();
      }
    case 3: 
      if (paramMessage.arg1 > 0)
      {
        paramMessage = new BusinessInfoCheckUpdate.RedTypeInfo();
        paramMessage.red_type.set(0);
        ReadinjoyTabFrame.a(this.a).a(paramMessage);
        ReadinjoyTabFrame.a(this.a).invalidate();
      }
      for (;;)
      {
        QLog.d("Q.readinjoy.4tab", 2, "update self icon red point for coin campaign");
        return;
        ReadinjoyTabFrame.a(this.a).d();
        ReadinjoyTabFrame.a(this.a).invalidate();
      }
    }
    int i = paramMessage.arg1;
    int j = paramMessage.arg2;
    if ((i <= 0) || ((j == 2131376089) && ((this.a.a() instanceof ReadInJoyVideoChannelFragment))))
    {
      ReadinjoyTabFrame.a(this.a).a(j);
      return;
    }
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
    localRedTypeInfo.red_type.set(0);
    localRedTypeInfo.red_content.set(String.valueOf(i));
    localRedTypeInfo.red_desc.set("{'cn':'#FF0000'}");
    QLog.d("Q.readinjoy.4tab", 2, "update indicator red point , index : " + paramMessage.obj + ", value : " + i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sul
 * JD-Core Version:    0.7.0.1
 */