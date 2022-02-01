package cooperation.qqcircle.picload;

import com.tencent.qphone.base.util.QLog;
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
    QLog.i("QCircleOkHttpDW", 1, "seq = " + this.val$option.getSeq() + "okHttp（）okHttpDownLoadException");
    QCircleOkHttpDW.access$000(this.this$0, this.val$option, this.val$callBack);
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    if (paramResponse.isSuccessful()) {
      QCircleOkHttpDW.access$100(this.this$0, this.val$option, paramResponse, this.val$callBack);
    }
    while ((!paramResponse.isRedirect()) && (paramResponse.code() >= 200) && (paramResponse.code() < 300)) {
      return;
    }
    QLog.i("QCircleOkHttpDW", 1, "seq = " + this.val$option.getSeq() + "okHttp（）okHttpDownLoadFailed:" + paramResponse.code());
    QCircleOkHttpDW.access$000(this.this$0, this.val$option, this.val$callBack);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCircleOkHttpDW.1
 * JD-Core Version:    0.7.0.1
 */