package dov.com.tencent.biz.qqstory.takevideo;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UIUtils.LoadImageCallback;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.qq.im.capture.util.PasterUtil;
import dov.com.qq.im.capture.util.PasterUtil.Position;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;

class EditVideoDoodle$8
  extends UIUtils.LoadImageCallback
{
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    super.onLoadCanceled(paramURLDrawable);
    SLog.e("Q.qqstory.publish.edit.StoryDoodle", "onLoadCanceled");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    super.onLoadFialed(paramURLDrawable, paramThrowable);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a().b();
    QQToast.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a(), HardCodeUtil.a(2131703753), 1).a();
    SLog.e("Q.qqstory.publish.edit.StoryDoodle", "onLoadFailed");
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    super.onLoadSuccessed(paramURLDrawable);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a().b();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item.a = paramURLDrawable;
    paramURLDrawable = PasterUtil.a();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item, paramURLDrawable.a, paramURLDrawable.b);
    SLog.e("Q.qqstory.publish.edit.StoryDoodle", "onLoadSucceed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoDoodle.8
 * JD-Core Version:    0.7.0.1
 */