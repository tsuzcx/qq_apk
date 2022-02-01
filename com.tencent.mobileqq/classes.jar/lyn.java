import android.os.Handler;
import android.os.Looper;
import com.tencent.av.ReqGroupVideo.ReqShareBackflowVerify;
import com.tencent.av.ReqGroupVideo.RspShareBackflowVerify;
import com.tencent.av.share.AVSchema;
import com.tencent.av.share.AVSchema.MyMsgListener.1;

public class lyn
  extends lgh<ReqGroupVideo.ReqShareBackflowVerify, ReqGroupVideo.RspShareBackflowVerify>
{
  public lym a;
  
  public lyn(AVSchema paramAVSchema, lym paramlym)
  {
    this.jdField_a_of_type_Lym = paramlym;
  }
  
  public void a(long paramLong, boolean paramBoolean, ReqGroupVideo.ReqShareBackflowVerify paramReqShareBackflowVerify, ReqGroupVideo.RspShareBackflowVerify paramRspShareBackflowVerify, Object paramObject)
  {
    if (this.jdField_a_of_type_ComTencentAvShareAVSchema.isDetached()) {
      return;
    }
    new Handler(Looper.getMainLooper()).post(new AVSchema.MyMsgListener.1(this, paramRspShareBackflowVerify, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lyn
 * JD-Core Version:    0.7.0.1
 */