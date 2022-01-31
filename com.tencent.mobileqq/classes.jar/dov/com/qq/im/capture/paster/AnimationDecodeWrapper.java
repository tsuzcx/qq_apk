package dov.com.qq.im.capture.paster;

import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.capture.data.GifDecoder;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.InformationFaceConstant;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.InfoStickerDrawable;

public class AnimationDecodeWrapper
  implements GifDecoder
{
  private int jdField_a_of_type_Int;
  private InfoStickerDrawable jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetInfoStickerDrawable;
  private String jdField_a_of_type_JavaLangString;
  
  public AnimationDecodeWrapper(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public Bitmap a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AnimationDecodeWrapper", 2, "timestamp:" + paramLong);
    }
    paramLong = paramLong / 1000L / 1000L;
    if (QLog.isColorLevel()) {
      QLog.d("AnimationDecodeWrapper", 2, "timestampMs:" + paramLong);
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetInfoStickerDrawable != null) {
      return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetInfoStickerDrawable.a(paramLong);
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetInfoStickerDrawable = InformationFaceConstant.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.paster.AnimationDecodeWrapper
 * JD-Core Version:    0.7.0.1
 */