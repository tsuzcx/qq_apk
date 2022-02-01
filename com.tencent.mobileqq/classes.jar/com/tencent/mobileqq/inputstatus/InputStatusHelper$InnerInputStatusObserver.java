package com.tencent.mobileqq.inputstatus;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.lang.ref.WeakReference;
import tencent.im.oidb.cmd0xcd4.cmd0xcd4.InputNotifyRsp;

final class InputStatusHelper$InnerInputStatusObserver
  extends InputStatusObserver
{
  private WeakReference<InputStatusHelper> a;
  
  private InputStatusHelper$InnerInputStatusObserver(InputStatusHelper paramInputStatusHelper)
  {
    this.a = new WeakReference(paramInputStatusHelper);
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (((paramObject instanceof cmd0xcd4.InputNotifyRsp)) && (paramBoolean))
    {
      paramObject = (cmd0xcd4.InputNotifyRsp)paramObject;
      int i = paramObject.sint32_result.get();
      int j = paramObject.uint32_interval.get();
      paramObject = paramObject.bytes_err_msg.get().toStringUtf8();
      if (i == 0)
      {
        if ((j > 0) && (this.a.get() != null)) {
          ((InputStatusHelper)this.a.get()).a = (j * 1000);
        }
      }
      else
      {
        String str = InputStatusHelper.a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("send input status fail : ");
        localStringBuilder.append(paramObject);
        QLog.d(str, 1, localStringBuilder.toString());
      }
    }
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (this.a.get() != null))
    {
      if ((!InputStatusHelper.a((InputStatusHelper)this.a.get())) && (paramBoolean2))
      {
        if (InputStatusHelper.a((InputStatusHelper)this.a.get()) != null) {
          InputStatusHelper.a((InputStatusHelper)this.a.get()).a(InputStatusHelper.a((InputStatusHelper)this.a.get()));
        }
        InputStatusHelper.a((InputStatusHelper)this.a.get()).a.addTextChangedListener(InputStatusHelper.a((InputStatusHelper)this.a.get()));
      }
      InputStatusHelper.a((InputStatusHelper)this.a.get(), paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.inputstatus.InputStatusHelper.InnerInputStatusObserver
 * JD-Core Version:    0.7.0.1
 */