import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import com.tencent.biz.qqstory.newshare.job.ShareGroupAvatarSaveFileJob.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class tda
  extends tcy
{
  private final String c;
  
  private boolean a(txr paramtxr)
  {
    boolean bool = false;
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramtxr.a(), paramtxr.b(), Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      localCanvas.drawColor(-1);
      localCanvas.drawBitmap(paramtxr.a(), 0.0F, 0.0F, null);
      bacm.a(bacm.a(localBitmap, 100), new File(this.c));
      bool = true;
    }
    catch (IOException paramtxr)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ShareGroupAvatarSaveFileJob", 2, paramtxr, new Object[0]);
      return false;
    }
    catch (OutOfMemoryError paramtxr)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ShareGroupAvatarSaveFileJob", 2, paramtxr, new Object[0]);
    }
    return bool;
    return false;
  }
  
  protected void a(Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShareGroupAvatarSaveFileJob", 2, paramError, new Object[0]);
    }
    b(false);
  }
  
  protected void a(Map<String, Object> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()) && (paramMap.containsKey("ShareGroupAvatarSaveFileJob_sgi"))) {
      this.a = ((String)a("ShareGroupAvatarSaveFileJob_sgi"));
    }
  }
  
  protected void a(txr paramtxr)
  {
    ThreadManager.post(new ShareGroupAvatarSaveFileJob.1(this, paramtxr), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tda
 * JD-Core Version:    0.7.0.1
 */