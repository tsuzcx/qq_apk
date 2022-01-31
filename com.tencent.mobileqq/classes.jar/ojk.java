import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.RoundedTransformation;
import com.tencent.biz.qqstory.takevideo.EditDoodleExport;
import com.tencent.biz.qqstory.takevideo.EditFilterExport;
import com.tencent.biz.qqstory.takevideo.EditVideoFragment;
import com.tencent.biz.qqstory.takevideo.VideoFragmentInfo;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

public class ojk
{
  int jdField_a_of_type_Int;
  RoundedTransformation jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageRoundedTransformation;
  EditDoodleExport jdField_a_of_type_ComTencentBizQqstoryTakevideoEditDoodleExport;
  EditFilterExport jdField_a_of_type_ComTencentBizQqstoryTakevideoEditFilterExport;
  int b;
  int c;
  int d;
  int e;
  int f;
  
  public ojk(EditVideoFragment paramEditVideoFragment)
  {
    this.jdField_a_of_type_Int = AIOUtils.a(15.0F, paramEditVideoFragment.a());
    this.b = AIOUtils.a(12.0F, paramEditVideoFragment.a());
    this.c = AIOUtils.a(2.0F, paramEditVideoFragment.a());
    this.d = ((ScreenUtil.jdField_a_of_type_Int - this.jdField_a_of_type_Int * 2 - this.b * 5) / 6);
    this.e = (this.d - this.c * 2);
    this.f = (this.e * 8 / 5);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageRoundedTransformation = new RoundedTransformation(AIOUtils.a(3.0F, paramEditVideoFragment.a()), 0, this.f * 1.0F / this.e, null, null);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditDoodleExport = ((EditDoodleExport)paramEditVideoFragment.a(EditDoodleExport.class));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditFilterExport = ((EditFilterExport)paramEditVideoFragment.a(EditFilterExport.class));
  }
  
  public Bitmap a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditDoodleExport != null) {
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditDoodleExport.a(paramInt))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditFilterExport != null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditFilterExport.a(paramInt)) {}
        }
      }
      else
      {
        Bitmap localBitmap1 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditDoodleExport.a(paramInt);
        localObject1 = localObject2;
        if (localBitmap1 != null)
        {
          if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditFilterExport != null) {
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditFilterExport.a(paramInt, new Canvas(localBitmap1), localBitmap1.getWidth(), localBitmap1.getHeight());
          }
          Bitmap localBitmap2 = BitmapUtils.a(localBitmap1, this.e, this.f, false);
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditDoodleExport.a(localBitmap1);
          localObject1 = localObject2;
          if (localBitmap2 != null) {
            localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageRoundedTransformation.a(localBitmap2);
          }
        }
      }
    }
    return localObject1;
  }
  
  public void a(VideoFragmentInfo paramVideoFragmentInfo, ojl paramojl)
  {
    Bitmap localBitmap = BitmapUtils.a(paramVideoFragmentInfo.c, this.e, this.f, false);
    paramVideoFragmentInfo = null;
    if (localBitmap != null) {
      paramVideoFragmentInfo = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageRoundedTransformation.a(localBitmap);
    }
    paramojl.b = paramVideoFragmentInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ojk
 * JD-Core Version:    0.7.0.1
 */