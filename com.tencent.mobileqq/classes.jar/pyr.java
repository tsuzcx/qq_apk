import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.1;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.qphone.base.util.QLog;

public class pyr
  implements pyb
{
  public pyr(UserOperationModule.1 param1) {}
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2)
  {
    QLog.e("UserOperationModule", 1, "handle0x978Resp onLoadUserInfoFailed, uin=" + paramString1 + ", errMsg=" + paramString2);
    pyq.a(this.a.this$0, this.a.a, "", this.a.b, 2);
  }
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    paramString = "";
    if (paramReadInJoyUserInfo != null) {
      paramString = paramReadInJoyUserInfo.faceUrl;
    }
    pyq.a(this.a.this$0, this.a.a, paramString, this.a.b, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pyr
 * JD-Core Version:    0.7.0.1
 */