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
    RFLog.i("QCircleOkHttpDW", RFLog.USR, "seq = " + this.val$option.getSeq() + "okHttp（）okHttpDownLoadException" + paramIOException);
    QCircleOkHttpDW.access$000(this.this$0, this.val$option, this.val$callBack);
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    if (paramResponse.isSuccessful()) {
      QCircleOkHttpDW.access$100(this.this$0, this.val$option, paramResponse, this.val$callBack);
    }
    while ((!paramResponse.isRedirect()) && (paramResponse.code() >= 200) && (paramResponse.code() < 301)) {
      return;
    }
    RFLog.i("QCircleOkHttpDW", RFLog.USR, "seq = " + this.val$option.getSeq() + "okHttp（）okHttpDownLoadFailed:" + paramResponse.code());
    QCircleOkHttpDW.access$000(this.this$0, this.val$option, this.val$callBack);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCircleOkHttpDW.1
 * JD-Core Version:    0.7.0.1
 */