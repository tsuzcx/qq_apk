import com.tencent.av.ReqGroupVideo.ReqCreateShareUrl;
import com.tencent.av.ReqGroupVideo.RspCreateShareUrl;
import com.tencent.av.common.ErrorInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;

class lyp
  extends lhg<ReqGroupVideo.ReqCreateShareUrl, ReqGroupVideo.RspCreateShareUrl>
{
  lyp(lyn paramlyn) {}
  
  public void a(long paramLong, boolean paramBoolean, ReqGroupVideo.ReqCreateShareUrl paramReqCreateShareUrl, ReqGroupVideo.RspCreateShareUrl paramRspCreateShareUrl, Object paramObject)
  {
    this.a.jdField_a_of_type_Boolean = false;
    paramReqCreateShareUrl = paramRspCreateShareUrl.share_url_with_no_sig.get().toStringUtf8();
    paramObject = paramRspCreateShareUrl.share_url.get().toStringUtf8();
    paramRspCreateShareUrl = (common.ErrorInfo)paramRspCreateShareUrl.result.get();
    int i = lhd.a(paramRspCreateShareUrl);
    QLog.w("ShareChat", 1, "requestGetUrlFromServer.callback, result[" + i + "], bytes_errmsg[" + paramRspCreateShareUrl.bytes_errmsg.get().toStringUtf8() + "], share_url_with_no_sig[" + paramReqCreateShareUrl + "], share_url[" + paramObject + "], seq[" + paramLong + "]");
    if (i == 0)
    {
      this.a.c = paramObject;
      this.a.b = paramReqCreateShareUrl;
      bbfn.a().a(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.a.b, this.a.c);
    }
    for (;;)
    {
      this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      return;
      if (i != 11001) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lyp
 * JD-Core Version:    0.7.0.1
 */