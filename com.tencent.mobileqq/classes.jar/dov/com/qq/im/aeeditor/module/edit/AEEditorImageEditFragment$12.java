package dov.com.qq.im.aeeditor.module.edit;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.microrapid.opencv.ImageAutoProcessor;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.tavcut.bean.Size;
import com.tencent.tavcut.util.BitmapUtil;
import com.tencent.tavsticker.utils.CollectionUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.data.AEEditorImageInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import mqq.os.MqqHandler;

class AEEditorImageEditFragment$12
  implements Runnable
{
  AEEditorImageEditFragment$12(AEEditorImageEditFragment paramAEEditorImageEditFragment, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    int i = 2;
    Object localObject1;
    Object localObject2;
    if ((List)AEEditorImageEditFragment.b(this.this$0).get(this.jdField_a_of_type_Int) == null)
    {
      if ((AEEditorImageEditFragment.a(this.this$0) == null) || (AEEditorImageEditFragment.a(this.this$0).size() <= this.jdField_a_of_type_Int) || (AEEditorImageEditFragment.a(this.this$0).get(this.jdField_a_of_type_Int) == null))
      {
        AEQLog.d("AEEditorImageEditFragment", "source image info error.");
        return;
      }
      localObject1 = (AEEditorImageInfo)AEEditorImageEditFragment.a(this.this$0).get(this.jdField_a_of_type_Int);
      localObject2 = BitmapUtil.getImageSize(((AEEditorImageInfo)localObject1).jdField_a_of_type_JavaLangString);
      if (Math.min(((Size)localObject2).getWidth(), ((Size)localObject2).getHeight()) / 480 < 2) {}
      for (;;)
      {
        localObject1 = BitmapUtil.cropBitmap(((AEEditorImageInfo)localObject1).jdField_a_of_type_JavaLangString, ((AEEditorImageInfo)localObject1).jdField_a_of_type_ComTencentTavcutBeanCropConfig, i);
        if (localObject1 != null) {
          break;
        }
        AEQLog.d("AEEditorImageEditFragment", "extractColor error input bitmap null.");
        return;
        i = 4;
      }
    }
    try
    {
      localObject2 = ImageAutoProcessor.mainColorExtract((Bitmap)localObject1, 6);
      BitmapUtils.recycle((Bitmap)localObject1);
      AEEditorImageEditFragment.a(this.this$0, (List)localObject2);
      AEEditorImageEditFragment.c(this.this$0).put(this.jdField_a_of_type_Int, new ArrayList((Collection)localObject2));
      if (!CollectionUtil.isEmptyList((List)localObject2)) {
        ((List)localObject2).add(((List)localObject2).remove(0));
      }
      AEEditorImageEditFragment.b(this.this$0).put(this.jdField_a_of_type_Int, localObject2);
      AEQLog.a("AEEditorImageEditFragment", "[extractColor], extracted color cached, index=" + this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_Int == AEEditorImageEditFragment.a(this.this$0)) {
        ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.12.1(this));
      }
      ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.12.2(this));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.12
 * JD-Core Version:    0.7.0.1
 */