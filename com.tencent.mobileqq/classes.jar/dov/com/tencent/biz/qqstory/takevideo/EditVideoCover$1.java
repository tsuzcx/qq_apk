package dov.com.tencent.biz.qqstory.takevideo;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import dov.com.qq.im.capture.view.ProviderViewEditContainer;
import dov.com.qq.im.capture.view.VideoCoverPickerProviderView;
import dov.com.qq.im.capture.view.VideoCoverPickerProviderView.PickerListener;
import java.util.List;

class EditVideoCover$1
  implements VideoCoverPickerProviderView.PickerListener
{
  EditVideoCover$1(EditVideoCover paramEditVideoCover) {}
  
  public void a()
  {
    VideoCoverPickerProviderView localVideoCoverPickerProviderView = (VideoCoverPickerProviderView)this.a.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditProviderPart.a.a(109);
    boolean bool;
    Object localObject;
    if (localVideoCoverPickerProviderView != null)
    {
      bool = this.a.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_is_need_gaussion_blur", false);
      if ((this.a.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditTakeVideoSource))
      {
        localObject = (EditTakeVideoSource)this.a.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a;
        localVideoCoverPickerProviderView.setVideo(((EditTakeVideoSource)localObject).jdField_a_of_type_JavaLangString, 0L, ((EditTakeVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration, ((EditTakeVideoSource)localObject).a(), ((EditTakeVideoSource)localObject).b(), ((EditTakeVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation, true, bool);
      }
    }
    else
    {
      return;
    }
    if ((this.a.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditLocalVideoSource))
    {
      localObject = (EditLocalVideoSource)this.a.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a;
      localVideoCoverPickerProviderView.setVideo(((EditLocalVideoSource)localObject).jdField_a_of_type_JavaLangString, ((EditLocalVideoSource)localObject).jdField_a_of_type_Int, ((EditLocalVideoSource)localObject).b, ((EditLocalVideoSource)localObject).a(), ((EditLocalVideoSource)localObject).b(), ((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation, true, bool);
      return;
    }
    throw new IllegalArgumentException("SegmentEdit init error");
  }
  
  public void a(long paramLong)
  {
    EditVideoCover.a(this.a, true);
    EditMultiSegmentExport localEditMultiSegmentExport = (EditMultiSegmentExport)this.a.a(EditMultiSegmentExport.class);
    if (localEditMultiSegmentExport != null) {
      localEditMultiSegmentExport.a(paramLong, true, false);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    this.a.a(paramLong, paramBoolean);
  }
  
  public void a(List<Long> paramList)
  {
    EditMultiSegmentExport localEditMultiSegmentExport = (EditMultiSegmentExport)this.a.a(EditMultiSegmentExport.class);
    if (localEditMultiSegmentExport != null) {
      localEditMultiSegmentExport.a(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoCover.1
 * JD-Core Version:    0.7.0.1
 */