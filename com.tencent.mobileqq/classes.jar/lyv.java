import com.tencent.av.ReqGroupVideo.ReqPushShareArk;
import com.tencent.av.ReqGroupVideo.RspPushShareArk;
import com.tencent.av.common.ErrorInfo;
import com.tencent.qphone.base.util.QLog;

public final class lyv
  extends lgn<ReqGroupVideo.ReqPushShareArk, ReqGroupVideo.RspPushShareArk>
{
  public void a(long paramLong, boolean paramBoolean, ReqGroupVideo.ReqPushShareArk paramReqPushShareArk, ReqGroupVideo.RspPushShareArk paramRspPushShareArk, Object paramObject)
  {
    int i = lgk.a((common.ErrorInfo)paramRspPushShareArk.result.get());
    QLog.d("ShareChat", 1, "shareGAVArkMsg errCode[" + i + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     lyv
 * JD-Core Version:    0.7.0.1
 */