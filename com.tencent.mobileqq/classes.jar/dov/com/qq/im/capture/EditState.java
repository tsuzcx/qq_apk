package dov.com.qq.im.capture;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.QIMProviderContainerView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.DynamicFaceLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;

public class EditState
{
  public static Bundle a(@NonNull Intent paramIntent)
  {
    return paramIntent.getBundleExtra("state");
  }
  
  public static Bundle a(@NonNull QIMCaptureController paramQIMCaptureController)
  {
    Bundle localBundle = new Bundle();
    if (paramQIMCaptureController.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null)
    {
      FaceLayer localFaceLayer = (FaceLayer)paramQIMCaptureController.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a.a(FaceLayer.a);
      DynamicFaceLayer localDynamicFaceLayer = (DynamicFaceLayer)paramQIMCaptureController.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a.a("DynamicFaceLayer");
      TextLayer localTextLayer = (TextLayer)paramQIMCaptureController.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a.a(TextLayer.a);
      localBundle.putBundle(FaceLayer.a, localFaceLayer.a());
      localBundle.putBundle("DynamicFaceLayer", localDynamicFaceLayer.a());
      if (localTextLayer != null) {
        localBundle.putBundle(TextLayer.a, localTextLayer.a());
      }
      localBundle.putBundle("container", paramQIMCaptureController.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.a());
      return localBundle;
    }
    QLog.e("EditState", 1, "saveState mDoodleLayout is null");
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.EditState
 * JD-Core Version:    0.7.0.1
 */