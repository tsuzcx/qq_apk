package dov.com.qq.im.ae.gif.video;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.PTFaceAttr;
import dov.com.qq.im.ae.gif.giftext.AEGIFTextColorConfig;
import dov.com.qq.im.ae.gif.giftext.AEGIFTextColorConfig.SmartTextColor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Semaphore;
import org.light.device.LightDeviceUtils;

public class PngsCreateWorkingQueue
{
  private static String jdField_a_of_type_JavaLangString = "PngsCreateWorkingQueue";
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private PngCreateResult jdField_a_of_type_DovComQqImAeGifVideoPngCreateResult = new PngCreateResult();
  private PngsCreateWorkingQueue.Callback jdField_a_of_type_DovComQqImAeGifVideoPngsCreateWorkingQueue$Callback;
  private PngsCreator jdField_a_of_type_DovComQqImAeGifVideoPngsCreator;
  private String b;
  
  public PngsCreateWorkingQueue(String paramString1, List<PTFaceAttr> paramList, String paramString2, Context paramContext)
  {
    this.jdField_a_of_type_DovComQqImAeGifVideoPngsCreator = new PngsCreator(paramString1, paramList);
    paramString1 = new HandlerThread("PngsCreateWorkingQueue");
    paramString1.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(paramString1.getLooper());
    this.b = paramString2;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a()
  {
    Iterator localIterator = this.jdField_a_of_type_DovComQqImAeGifVideoPngCreateResult.a.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      QLog.d(jdField_a_of_type_JavaLangString, 4, "clear frame files, dir = " + str);
      FileUtils.a(str);
    }
  }
  
  private void b(MaterialWrapper paramMaterialWrapper)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = "";
    Semaphore localSemaphore = new Semaphore(0);
    AEGIFTextColorConfig.SmartTextColor localSmartTextColor = (AEGIFTextColorConfig.SmartTextColor)AEGIFTextColorConfig.jdField_a_of_type_JavaUtilList.get(AEGIFTextColorConfig.jdField_a_of_type_ArrayOfInt[(paramMaterialWrapper.jdField_a_of_type_Int % AEGIFTextColorConfig.jdField_a_of_type_ArrayOfInt.length)]);
    float f1 = 0.81F;
    float f2 = 0.16F;
    if (paramMaterialWrapper.b.contains("\n"))
    {
      f1 = 0.67F;
      f2 = 0.3F;
    }
    int i;
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      j = (int)(LightDeviceUtils.getScreenWidth(this.jdField_a_of_type_AndroidContentContext) * 0.44F) + 1;
      if (this.jdField_a_of_type_AndroidContentContext == null) {
        break label246;
      }
      i = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 2.0F) * 320 / j;
      label119:
      if (this.jdField_a_of_type_AndroidContentContext == null) {
        break label252;
      }
    }
    label246:
    label252:
    for (int j = DisplayUtil.c(this.jdField_a_of_type_AndroidContentContext, 23.0F) * 320 / j;; j = 19)
    {
      this.jdField_a_of_type_DovComQqImAeGifVideoPngsCreator.a(paramMaterialWrapper.b, j, localSmartTextColor.jdField_a_of_type_JavaLangString, localSmartTextColor.b, i, this.b, 0.0F, f1, 1.0F, f2);
      this.jdField_a_of_type_DovComQqImAeGifVideoPngsCreator.a(paramMaterialWrapper.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_DovComQqImAeGifVideoPngsCreator.a(new PngsCreateWorkingQueue.2(this, paramMaterialWrapper, arrayOfString, localSemaphore));
      try
      {
        localSemaphore.acquire();
        if (this.jdField_a_of_type_DovComQqImAeGifVideoPngsCreateWorkingQueue$Callback != null) {
          this.jdField_a_of_type_DovComQqImAeGifVideoPngsCreateWorkingQueue$Callback.a(paramMaterialWrapper.jdField_a_of_type_Int, arrayOfString[0]);
        }
        return;
      }
      catch (InterruptedException paramMaterialWrapper)
      {
        paramMaterialWrapper.printStackTrace();
      }
      j = 1920;
      break;
      i = 5;
      break label119;
    }
  }
  
  public PngCreateResult a()
  {
    return this.jdField_a_of_type_DovComQqImAeGifVideoPngCreateResult;
  }
  
  public void a(MaterialWrapper paramMaterialWrapper)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new PngsCreateWorkingQueue.1(this, paramMaterialWrapper));
  }
  
  public void a(PngsCreateWorkingQueue.Callback paramCallback)
  {
    this.jdField_a_of_type_DovComQqImAeGifVideoPngsCreateWorkingQueue$Callback = paramCallback;
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 4, "stop, clearFiles = " + paramBoolean);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.post(new PngsCreateWorkingQueue.3(this, paramBoolean));
    this.jdField_a_of_type_AndroidContentContext = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.video.PngsCreateWorkingQueue
 * JD-Core Version:    0.7.0.1
 */