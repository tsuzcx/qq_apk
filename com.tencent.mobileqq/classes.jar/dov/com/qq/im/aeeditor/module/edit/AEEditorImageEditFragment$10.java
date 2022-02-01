package dov.com.qq.im.aeeditor.module.edit;

import android.graphics.Bitmap;
import android.util.SparseArray;
import bnrh;
import bnsw;
import com.microrapid.opencv.ImageAutoProcessor;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.tavcut.util.BitmapUtil;
import com.tencent.tavsticker.utils.CollectionUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

class AEEditorImageEditFragment$10
  implements Runnable
{
  AEEditorImageEditFragment$10(AEEditorImageEditFragment paramAEEditorImageEditFragment, int paramInt) {}
  
  public void run()
  {
    if ((List)AEEditorImageEditFragment.b(this.this$0).get(this.a) != null) {}
    for (;;)
    {
      return;
      if ((AEEditorImageEditFragment.a(this.this$0) == null) || (AEEditorImageEditFragment.a(this.this$0).size() <= this.a) || (AEEditorImageEditFragment.a(this.this$0).get(this.a) == null))
      {
        bnrh.d("AEEditorImageEditFragment", "source image info error.");
        return;
      }
      Object localObject = (bnsw)AEEditorImageEditFragment.a(this.this$0).get(this.a);
      localObject = BitmapUtil.cropBitmap(((bnsw)localObject).jdField_a_of_type_JavaLangString, ((bnsw)localObject).jdField_a_of_type_ComTencentTavcutBeanCropConfig);
      if (localObject == null)
      {
        bnrh.d("AEEditorImageEditFragment", "extractColor error input bitmap null.");
        return;
      }
      try
      {
        List localList = ImageAutoProcessor.mainColorExtract((Bitmap)localObject, 4);
        BitmapUtils.recycle((Bitmap)localObject);
        AEEditorImageEditFragment.a(this.this$0, localList);
        AEEditorImageEditFragment.c(this.this$0).put(this.a, new ArrayList(localList));
        if (!CollectionUtil.isEmptyList(localList)) {
          localList.add(localList.remove(0));
        }
        AEEditorImageEditFragment.b(this.this$0).put(this.a, localList);
        bnrh.a("AEEditorImageEditFragment", "[extractColor], extracted color cached, index=" + this.a);
        if (this.a == AEEditorImageEditFragment.a(this.this$0))
        {
          ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.10.1(this));
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.10
 * JD-Core Version:    0.7.0.1
 */