import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.ugc.upload.RIJUgcImageUploader.1;
import com.tencent.biz.pubaccount.readinjoy.ugc.upload.RIJUgcImageUploader.1.1.1;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;

public class rtg
  implements rtq
{
  public rtg(RIJUgcImageUploader.1 param1) {}
  
  public void a() {}
  
  public void a(float paramFloat)
  {
    rtf.a(this.a.this$0).a(paramFloat);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.i(rtf.a, 2, "uploadImage finish, url=" + paramString1);
    }
    rtf.a(this.a.this$0, false);
    ThreadManagerV2.getUIHandlerV2().post(new RIJUgcImageUploader.1.1.1(this, paramInt, paramString1));
    rtf.a(this.a.this$0).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rtg
 * JD-Core Version:    0.7.0.1
 */