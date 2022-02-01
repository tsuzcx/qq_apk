package dov.com.tencent.biz.qqstory.takevideo;

import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.view.ProviderViewEditContainer;
import dov.com.qq.im.capture.view.VideoCoverPickerProviderView;
import dov.com.qq.im.capture.view.VideoCoverPickerProviderView.PickerListener;

public class EditVideoCover
  extends EditVideoPart
  implements View.OnClickListener
{
  public long a;
  private View jdField_a_of_type_AndroidViewView;
  private VideoCoverPickerProviderView.PickerListener jdField_a_of_type_DovComQqImCaptureViewVideoCoverPickerProviderView$PickerListener;
  private boolean jdField_a_of_type_Boolean;
  public long b;
  private boolean b;
  public long c;
  private long e;
  
  private void c()
  {
    if (this.jdField_a_of_type_DovComQqImCaptureViewVideoCoverPickerProviderView$PickerListener == null) {
      this.jdField_a_of_type_DovComQqImCaptureViewVideoCoverPickerProviderView$PickerListener = new EditVideoCover.1(this);
    }
  }
  
  public int a()
  {
    int i = 1;
    int j = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_transiton_src_from", -1);
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d()) {
      i = 4;
    }
    do
    {
      return i;
      if (j == 1) {
        return 0;
      }
    } while (j == 2);
    return 2;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidViewView = a(2131381236);
    this.c = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.b();
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditLocalVideoSource)) {
      this.e = ((EditLocalVideoSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a).a;
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
    Object localObject = (EditMultiSegmentExport)a(EditMultiSegmentExport.class);
    if (localObject != null) {
      ((EditMultiSegmentExport)localObject).a(this.e, false);
    }
    localObject = (EditMusicExport)a(EditMusicExport.class);
    if (localObject != null) {
      ((EditMusicExport)localObject).b();
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
    if (paramBoolean)
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
      QQToast.a(a(), 2, HardCodeUtil.a(2131703934), 0).a();
      if (paramLong != 0L) {
        ReportController.b(null, "dc00899", "grp_story", "", "video_edit_cover", "done_cover", a(), 1, "", "", "", "");
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditVideoCover", 2, new Object[] { "SegmentPickerFinish, coverTime: ", Long.valueOf(this.jdField_a_of_type_Long) });
      }
      return;
      this.jdField_a_of_type_Long = this.jdField_b_of_type_Long;
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  protected boolean a(Message paramMessage)
  {
    int i = paramMessage.what;
    return super.a(paramMessage);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QLog.d("EditVideoCover", 1, new Object[] { "Click, current covertime, ", Long.valueOf(this.jdField_a_of_type_Long) });
      c();
      ProviderViewEditContainer localProviderViewEditContainer = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditProviderPart.a;
      VideoCoverPickerProviderView localVideoCoverPickerProviderView = (VideoCoverPickerProviderView)localProviderViewEditContainer.a(109);
      if (localVideoCoverPickerProviderView != null)
      {
        EditMultiSegmentExport localEditMultiSegmentExport = (EditMultiSegmentExport)a(EditMultiSegmentExport.class);
        if (localEditMultiSegmentExport != null)
        {
          localVideoCoverPickerProviderView.setPlayMode(localEditMultiSegmentExport.a());
          localVideoCoverPickerProviderView.setUseIFrameVideo(localEditMultiSegmentExport.a());
          localEditMultiSegmentExport.a();
          if ((!this.jdField_b_of_type_Boolean) && (localEditMultiSegmentExport.a() == 1)) {
            this.jdField_a_of_type_Long = (this.c * 1000000L);
          }
          localEditMultiSegmentExport.a(this.jdField_a_of_type_Long / 1000000L, true);
        }
      }
      localProviderViewEditContainer.setVideoCoverPickerListener(this.jdField_a_of_type_DovComQqImCaptureViewVideoCoverPickerProviderView$PickerListener);
      localProviderViewEditContainer.a(109, new Object[] { Long.valueOf(this.jdField_a_of_type_Long / 1000000L) });
    }
  }
  
  public void y_()
  {
    if (this.jdField_a_of_type_Long != 0L) {
      ReportController.b(null, "dc00899", "grp_story", "", "video_edit_cover", "pub_cover", a(), 1, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoCover
 * JD-Core Version:    0.7.0.1
 */