package com.tencent.open.agent;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.protofile.getappinfo.GetAppInfoProto.MsgIconsurl;
import java.util.List;

class BindGroupConfirmActivity$2
  extends Handler
{
  BindGroupConfirmActivity$2(BindGroupConfirmActivity paramBindGroupConfirmActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      return;
    }
    int i = paramMessage.what;
    Object localObject;
    if (i != 3)
    {
      if (i != 4) {
        return;
      }
      paramMessage = (Bitmap)paramMessage.obj;
      localObject = AuthorityUtil.a(this.a, paramMessage, 50, 50);
      paramMessage.recycle();
      if (localObject != null) {
        this.a.b.setImageBitmap((Bitmap)localObject);
      }
    }
    else
    {
      paramMessage = (GetAppInfoProto.GetAppinfoResponse)paramMessage.obj;
      if (paramMessage.iconsURL.has())
      {
        i = 0;
        int m = 0;
        int j = 0;
        while (i < paramMessage.iconsURL.get().size())
        {
          localObject = (GetAppInfoProto.MsgIconsurl)paramMessage.iconsURL.get(i);
          try
          {
            k = Integer.parseInt(((GetAppInfoProto.MsgIconsurl)localObject).size.get());
          }
          catch (NumberFormatException localNumberFormatException)
          {
            int k;
            label135:
            int n;
            break label135;
          }
          k = 0;
          if (k >= 100) {
            break label178;
          }
          n = m;
          if (k > m)
          {
            j = i;
            n = k;
          }
          i += 1;
          m = n;
        }
        i = j;
        label178:
        paramMessage = (GetAppInfoProto.MsgIconsurl)paramMessage.iconsURL.get(i);
        if (paramMessage != null) {
          ThreadManager.executeOnNetWorkThread(new BindGroupConfirmActivity.2.1(this, paramMessage));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupConfirmActivity.2
 * JD-Core Version:    0.7.0.1
 */