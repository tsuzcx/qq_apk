import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

class nty
  implements bdbc
{
  nty(ntw paramntw) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nty
 * JD-Core Version:    0.7.0.1
 */