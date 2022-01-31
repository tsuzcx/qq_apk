import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebShareUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import java.io.IOException;
import java.util.Map;

public class mmz
  implements Runnable
{
  public mmz(FastWebShareUtils paramFastWebShareUtils, String paramString, Map paramMap, AppInterface paramAppInterface, Runnable paramRunnable) {}
  
  public void run()
  {
    label142:
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
        break label142;
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
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.runOnUiThread(this.jdField_a_of_type_JavaLangRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mmz
 * JD-Core Version:    0.7.0.1
 */