package cooperation.qqcircle.picload;

import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.qcircle.api.data.Option;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

class QCircleOkHttpDW$1
  implements Callback
{
  QCircleOkHttpDW$1(QCircleOkHttpDW paramQCircleOkHttpDW, Option paramOption, AbsPicDW.ICallBackListener paramICallBackListener) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    int i = RFLog.USR;
    paramCall = new StringBuilder();
    paramCall.append("seq = ");
    paramCall.append(this.val$option.getSeq());
    paramCall.append("okHttp（）okHttpDownLoadException");
    paramCall.append(paramIOException);
    RFLog.i("QCircleOkHttpDW", i, paramCall.toString());
    QCircleOkHttpDW.access$000(this.this$0, this.val$option, this.val$callBack);
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    if (paramResponse.isSuccessful())
    {
      QCircleOkHttpDW.access$100(this.this$0, this.val$option, paramResponse, this.val$callBack);
      return;
    }
    if ((paramResponse.isRedirect()) || (paramResponse.code() < 200) || (paramResponse.code() >= 301))
    {
      int i = RFLog.USR;
      paramCall = new StringBuilder();
      paramCall.append("seq = ");
      paramCall.append(this.val$option.getSeq());
      paramCall.append("okHttp（）okHttpDownLoadFailed:");
      paramCall.append(paramResponse.code());
      RFLog.i("QCircleOkHttpDW", i, paramCall.toString());
      QCircleOkHttpDW.access$000(this.this$0, this.val$option, this.val$callBack);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCircleOkHttpDW.1
 * JD-Core Version:    0.7.0.1
 */