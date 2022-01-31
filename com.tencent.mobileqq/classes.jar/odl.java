import com.tencent.biz.qqstory.takevideo.EditPicSave;
import com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import com.tencent.biz.qqstory.takevideo.EditVideoUi;
import com.tencent.mobileqq.widget.QQToast;

class odl
  implements Runnable
{
  odl(odk paramodk) {}
  
  public void run()
  {
    this.a.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
    this.a.a.jdField_a_of_type_Boolean = true;
    this.a.a.a(100);
    this.a.a.h();
    QQToast.a(this.a.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a(), 2, "已保存到系统相册", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     odl
 * JD-Core Version:    0.7.0.1
 */