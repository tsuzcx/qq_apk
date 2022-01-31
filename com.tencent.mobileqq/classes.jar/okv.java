import com.tencent.biz.qqstory.model.lbs.LbsManager.OnLocationListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.EditVideoPoi;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;

public class okv
  extends LbsManager.OnLocationListener
{
  public okv(EditVideoPoi paramEditVideoPoi, String paramString, boolean paramBoolean)
  {
    super(paramString);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    super.a(paramInt, paramSosoLbsInfo);
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoi.a = paramSosoLbsInfo.a.a;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoi.b = paramSosoLbsInfo.a.b;
      SLog.b("Q.qqstory.publish.edit.EditVideoPoi", "onLocationUpdate() latitude=" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoi.a + " longitude=" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoi.b);
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoi.e();
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoi.a = 0.0D;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoi.b = 0.0D;
    SLog.b("Q.qqstory.publish.edit.EditVideoPoi", "onLocationUpdate() error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     okv
 * JD-Core Version:    0.7.0.1
 */