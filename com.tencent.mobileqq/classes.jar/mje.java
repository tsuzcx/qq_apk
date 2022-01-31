import android.graphics.Bitmap;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;

public class mje
  implements FaceDecoder.DecodeTaskCompletionListener
{
  public mje(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (ReadinjoyTabFrame.b(this.a) != null) {
      ReadinjoyTabFrame.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mje
 * JD-Core Version:    0.7.0.1
 */