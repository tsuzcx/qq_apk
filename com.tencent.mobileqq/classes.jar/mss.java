import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsPlayManager;
import com.tencent.mobileqq.widget.QQToast;

public class mss
  implements Runnable
{
  public mss(FastWebVideoFeedsPlayManager paramFastWebVideoFeedsPlayManager) {}
  
  public void run()
  {
    QQToast.a(FastWebVideoFeedsPlayManager.a(this.a), 1, "无网络连接,请检测网络配置!", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mss
 * JD-Core Version:    0.7.0.1
 */