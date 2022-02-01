import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.1;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.qphone.base.util.QLog;

public class pwv
  implements pwf
{
  public pwv(UserOperationModule.1 param1) {}
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2)
  {
    QLog.e("UserOperationModule", 1, "handle0x978Resp onLoadUserInfoFailed, uin=" + paramString1 + ", errMsg=" + paramString2);
    pwu.a(this.a.this$0, this.a.jdField_a_of_type_Int, "", this.a.b, 2, this.a.jdField_a_of_type_Boolean);
  }
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    paramString = "";
    if (paramReadInJoyUserInfo != null) {
      paramString = paramReadInJoyUserInfo.faceUrl;
    }
    pwu.a(this.a.this$0, this.a.jdField_a_of_type_Int, paramString, this.a.b, 2, this.a.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pwv
 * JD-Core Version:    0.7.0.1
 */