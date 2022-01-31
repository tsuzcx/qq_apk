import android.graphics.drawable.BitmapDrawable;
import android.util.LruCache;
import com.tencent.biz.qqstory.takevideo.EditGifImage;
import com.tencent.biz.qqstory.takevideo.EditGifImage.AntiShakeTask;
import com.tencent.biz.qqstory.takevideo.EditLocalGifSource;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import cooperation.qzone.util.GifAntishakeModule;
import java.util.ArrayList;

public class ocr
  implements Runnable
{
  public ocr(EditGifImage paramEditGifImage, LruCache paramLruCache) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.b)
    {
      if ((!(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.a instanceof EditLocalGifSource)) || (((EditLocalGifSource)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.a).a == null) || (((EditLocalGifSource)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.a).a.size() <= 0)) {
        break label284;
      }
      ArrayList localArrayList = ((EditLocalGifSource)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.a).a;
      if (!GifAntishakeModule.a().a(localArrayList, this.jdField_a_of_type_AndroidUtilLruCache)) {
        break label247;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.c = true;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(996);
      if ((this.jdField_a_of_type_AndroidUtilLruCache != null) && (this.jdField_a_of_type_AndroidUtilLruCache.size() == localArrayList.size()))
      {
        localArrayList = new ArrayList();
        int i = 0;
        while (i < this.jdField_a_of_type_AndroidUtilLruCache.size())
        {
          BitmapDrawable localBitmapDrawable = (BitmapDrawable)this.jdField_a_of_type_AndroidUtilLruCache.get(Integer.valueOf(i));
          if (localBitmapDrawable != null) {
            localArrayList.add(localBitmapDrawable.getBitmap());
          }
          i += 1;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage$AntiShakeTask = new EditGifImage.AntiShakeTask(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage$AntiShakeTask.execute(new ArrayList[] { localArrayList });
      }
    }
    label247:
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.c = false;
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(997);
      } while (!QLog.isColorLevel());
      QLog.d("QzoneVision", 2, "MSG_CANNOT_ANTISHAKE");
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.c = false;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(997);
    } while (!QLog.isColorLevel());
    label284:
    QLog.d("QzoneVision", 2, "MSG_CANNOT_ANTISHAKE");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ocr
 * JD-Core Version:    0.7.0.1
 */