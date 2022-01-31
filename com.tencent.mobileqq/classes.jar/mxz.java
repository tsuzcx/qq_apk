import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.util.GalleryShareHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import java.io.IOException;
import java.util.Map;

public class mxz
  implements Runnable
{
  public mxz(GalleryShareHelper paramGalleryShareHelper, String paramString, Map paramMap, int paramInt) {}
  
  public void run()
  {
    label149:
    try
    {
      localObject = HttpUtil.a(BaseApplicationImpl.getContext(), MsfSdkUtils.insertMtype("GameCenter", this.jdField_a_of_type_JavaLangString), "GET", null, null);
      if (localObject == null) {
        break label120;
      }
      localObject = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
      if (localObject == null) {
        break label120;
      }
      int i = ((Bitmap)localObject).getWidth();
      int j = ((Bitmap)localObject).getHeight();
      if (i * j <= 8000) {
        break label149;
      }
      double d = Math.sqrt(8000.0D / (i * j));
      Bitmap localBitmap = Bitmap.createScaledBitmap((Bitmap)localObject, (int)(i * d), (int)(j * d), true);
      ((Bitmap)localObject).recycle();
      localObject = localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Object localObject;
      break label120;
    }
    catch (IOException localIOException)
    {
      label120:
      for (;;) {}
    }
    this.jdField_a_of_type_JavaUtilMap.put("image", localObject);
    GalleryShareHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilGalleryShareHelper).runOnUiThread(new mya(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mxz
 * JD-Core Version:    0.7.0.1
 */