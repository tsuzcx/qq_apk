import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.qphone.base.util.BaseApplication;

public class kzz
  implements FaceDecoder.DecodeTaskCompletionListener
{
  public kzz(EcShopAssistantManager paramEcShopAssistantManager) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramBitmap != null))
    {
      Intent localIntent = new Intent("action_decode_finish");
      localIntent.putExtra("bitmap", paramBitmap);
      localIntent.putExtra("uin", paramString);
      BaseApplicationImpl.getContext().sendBroadcast(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kzz
 * JD-Core Version:    0.7.0.1
 */