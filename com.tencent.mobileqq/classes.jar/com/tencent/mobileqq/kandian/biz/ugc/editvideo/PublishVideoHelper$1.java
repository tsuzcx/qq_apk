package com.tencent.mobileqq.kandian.biz.ugc.editvideo;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0xe2a.oidb_0xe2a.AddVideoRsp;
import tencent.im.oidb.cmd0xe2a.oidb_0xe2a.RspBody;

final class PublishVideoHelper$1
  extends ProtoUtils.TroopProtocolObserver
{
  PublishVideoHelper$1(boolean paramBoolean, PublishVideoHelper.IPublishVideoCallback paramIPublishVideoCallback) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    paramBundle = new ArrayList();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("publishVideo, errorCode=");
    ((StringBuilder)localObject).append(paramInt);
    QLog.i("RIJUGC.PublishVideoHelper", 1, ((StringBuilder)localObject).toString());
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      localObject = new oidb_0xe2a.RspBody();
      try
      {
        ((oidb_0xe2a.RspBody)localObject).mergeFrom(paramArrayOfByte);
        if ((((oidb_0xe2a.RspBody)localObject).msg_add_video_rsp.has()) && (((oidb_0xe2a.RspBody)localObject).msg_add_video_rsp.rpt_rowkey_list.has())) {
          paramArrayOfByte = ((oidb_0xe2a.RspBody)localObject).msg_add_video_rsp.rpt_rowkey_list.get().iterator();
        }
        while (paramArrayOfByte.hasNext())
        {
          localObject = (ByteStringMicro)paramArrayOfByte.next();
          if (!((ByteStringMicro)localObject).toStringUtf8().isEmpty())
          {
            paramBundle.add(((ByteStringMicro)localObject).toStringUtf8());
          }
          else
          {
            QLog.i("RIJUGC.PublishVideoHelper", 1, "publishVideo, rowKey isEmpty");
            continue;
            QLog.i("RIJUGC.PublishVideoHelper", 1, "publishVideo, not has rpt_rowkey_list");
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("publishVideo");
          ((StringBuilder)localObject).append(paramArrayOfByte.toString());
          QLog.d("RIJUGC.PublishVideoHelper", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
    ThreadManager.getUIHandler().post(new PublishVideoHelper.1.1(this, paramInt));
    paramArrayOfByte = RIJQQAppInterfaceUtil.a();
    if ((paramArrayOfByte != null) && (ReadInJoyHelper.t(paramArrayOfByte))) {
      if ((paramInt == 0) && (paramBundle.size() > 0))
      {
        QQToast.makeText(BaseApplicationImpl.getContext(), 0, "视频发表成功", 0).show();
      }
      else
      {
        paramArrayOfByte = BaseApplicationImpl.getContext();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("视频发表失败，errorCode=");
        ((StringBuilder)localObject).append(paramInt);
        QQToast.makeText(paramArrayOfByte, 0, ((StringBuilder)localObject).toString(), 0).show();
      }
    }
    paramArrayOfByte = this.b;
    if (paramArrayOfByte != null) {
      paramArrayOfByte.a(paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.editvideo.PublishVideoHelper.1
 * JD-Core Version:    0.7.0.1
 */