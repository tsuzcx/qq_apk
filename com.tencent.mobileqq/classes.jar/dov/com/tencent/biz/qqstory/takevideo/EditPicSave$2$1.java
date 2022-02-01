package dov.com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.entry.AECameraEntry;
import java.io.File;

class EditPicSave$2$1
  implements Runnable
{
  EditPicSave$2$1(EditPicSave.2 param2, String paramString) {}
  
  public void run()
  {
    try
    {
      if ((AECameraEntry.e(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicSave$2.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getIntent())) || (AECameraEntry.f(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicSave$2.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getIntent())))
      {
        EditPicSave.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicSave$2.a, ((IMiniAppService)QRoute.api(IMiniAppService.class)).getTmpPathFromOut(this.jdField_a_of_type_JavaLangString, EditPicSave.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicSave$2.a, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicSave$2.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a())));
        FileUtils.a(new File(this.jdField_a_of_type_JavaLangString), new File(EditPicSave.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicSave$2.a)));
        return;
      }
      EditPicSave.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicSave$2.a, PlusPanelUtils.a());
      File localFile = new File(EditPicSave.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicSave$2.a));
      if (FileUtils.a(new File(this.jdField_a_of_type_JavaLangString), localFile))
      {
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicSave$2.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a() == 14) {
          EditPicSave.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicSave$2.a, true);
        }
        ImageUtil.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicSave$2.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity(), localFile);
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EditPicSave", 2, "savePic " + localException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditPicSave.2.1
 * JD-Core Version:    0.7.0.1
 */