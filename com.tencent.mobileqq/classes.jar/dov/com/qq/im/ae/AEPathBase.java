package dov.com.qq.im.ae;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class AEPathBase
{
  protected static final String a = BaseApplicationImpl.getContext().getCacheDir().getPath();
  protected static final String b;
  protected static final String c = BaseApplicationImpl.getContext().getFilesDir().getParent();
  
  static
  {
    if ((BaseApplicationImpl.getContext().getExternalFilesDir(null) != null) && (BaseApplicationImpl.getContext().getExternalCacheDir() != null)) {}
    for (int i = 1; i != 0; i = 0)
    {
      b = BaseApplicationImpl.getContext().getExternalFilesDir(null).getPath();
      a = BaseApplicationImpl.getContext().getExternalCacheDir().getPath();
      return;
    }
    b = BaseApplicationImpl.getContext().getFilesDir().getPath();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPathBase
 * JD-Core Version:    0.7.0.1
 */