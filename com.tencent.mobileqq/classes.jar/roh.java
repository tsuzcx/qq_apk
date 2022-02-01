import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0xe2a.oidb_0xe2a.AddVideoRsp;
import tencent.im.oidb.cmd0xe2a.oidb_0xe2a.RspBody;

final class roh
  extends niv
{
  roh(rok paramrok) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    paramBundle = new ArrayList();
    QLog.i("RIJUGC.PublishVideoHelper", 1, "publishVideo, errorCode=" + paramInt);
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      Object localObject = new oidb_0xe2a.RspBody();
      try
      {
        ((oidb_0xe2a.RspBody)localObject).mergeFrom(paramArrayOfByte);
        if ((!((oidb_0xe2a.RspBody)localObject).msg_add_video_rsp.has()) || (!((oidb_0xe2a.RspBody)localObject).msg_add_video_rsp.rpt_rowkey_list.has())) {
          break label251;
        }
        paramArrayOfByte = ((oidb_0xe2a.RspBody)localObject).msg_add_video_rsp.rpt_rowkey_list.get().iterator();
        while (paramArrayOfByte.hasNext())
        {
          localObject = (ByteStringMicro)paramArrayOfByte.next();
          if (((ByteStringMicro)localObject).toStringUtf8().isEmpty()) {
            break label240;
          }
          paramBundle.add(((ByteStringMicro)localObject).toStringUtf8());
        }
        paramArrayOfByte = pha.a();
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RIJUGC.PublishVideoHelper", 2, "publishVideo" + paramArrayOfByte.toString());
        }
      }
    }
    else
    {
      label180:
      if ((paramArrayOfByte != null) && (bmqa.l(paramArrayOfByte)))
      {
        if ((paramInt != 0) || (paramBundle.size() <= 0)) {
          break label262;
        }
        QQToast.a(BaseApplicationImpl.getContext(), 0, "视频发表成功", 0).a();
      }
    }
    for (;;)
    {
      if (this.a != null) {
        this.a.a(paramBundle);
      }
      return;
      label240:
      QLog.i("RIJUGC.PublishVideoHelper", 1, "publishVideo, rowKey isEmpty");
      break;
      label251:
      QLog.i("RIJUGC.PublishVideoHelper", 1, "publishVideo, not has rpt_rowkey_list");
      break label180;
      label262:
      QQToast.a(BaseApplicationImpl.getContext(), 0, "视频发表失败，errorCode=" + paramInt, 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     roh
 * JD-Core Version:    0.7.0.1
 */