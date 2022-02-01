package cooperation.qqcircle.picload;

import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

class RFWOkHttpDW$1
  implements Callback
{
  RFWOkHttpDW$1(RFWOkHttpDW paramRFWOkHttpDW, Option paramOption, RFWAbsPicDW.ICallBackListener paramICallBackListener) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    paramCall = new StringBuilder();
    paramCall.append("seq = ");
    paramCall.append(this.val$option.getSeq());
    paramCall.append("okHttp（）okHttpDownLoadException");
    paramCall.append(paramIOException);
    QLog.i("QCircleOkHttpDW", 1, paramCall.toString());
    RFWOkHttpDW.access$000(this.this$0, this.val$option, this.val$callBack);
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    if (paramResponse.isSuccessful())
    {
      RFWOkHttpDW.access$100(this.this$0, this.val$option, paramResponse, this.val$callBack);
      return;
    }
    if ((paramResponse.isRedirect()) || (paramResponse.code() < 200) || (paramResponse.code() >= 301))
    {
      paramCall = new StringBuilder();
      paramCall.append("seq = ");
      paramCall.append(this.val$option.getSeq());
      paramCall.append("okHttp（）okHttpDownLoadFailed:");
      paramCall.append(paramResponse.code());
      QLog.i("QCircleOkHttpDW", 1, paramCall.toString());
      RFWOkHttpDW.access$000(this.this$0, this.val$option, this.val$callBack);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.picload.RFWOkHttpDW.1
 * JD-Core Version:    0.7.0.1
 */