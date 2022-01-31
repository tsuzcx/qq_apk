package dov.com.qq.im.capture.paster;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.NativeApngDecoder;
import com.tencent.mobileqq.richmedia.capture.data.GifDecoder;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public class ApngDecodeWrapper
  implements GifDecoder
{
  private NativeApngDecoder jdField_a_of_type_ComTencentImageNativeApngDecoder;
  private String jdField_a_of_type_JavaLangString;
  
  public ApngDecodeWrapper(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public Bitmap a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentImageNativeApngDecoder != null) {
      return this.jdField_a_of_type_ComTencentImageNativeApngDecoder.a(paramLong);
    }
    return null;
  }
  
  public void a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    File localFile;
    do
    {
      do
      {
        return;
        if ((VasApngUtil.b.get()) || (VasApngUtil.a(BaseApplicationImpl.sApplication.getRuntime()))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ApngDecodeWrapper", 2, "so not loaded");
      return;
      localFile = new File(this.jdField_a_of_type_JavaLangString);
    } while ((!localFile.exists()) || (!localFile.isFile()));
    try
    {
      this.jdField_a_of_type_ComTencentImageNativeApngDecoder = new NativeApngDecoder(localFile);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.paster.ApngDecodeWrapper
 * JD-Core Version:    0.7.0.1
 */