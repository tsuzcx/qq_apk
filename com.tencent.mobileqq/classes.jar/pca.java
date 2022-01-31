import com.tencent.biz.troop.VideoCombineHelper.Callback;
import com.tencent.biz.troop.VideoCombineHelper.TaskListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class pca
  implements VideoCombineHelper.Callback
{
  pca(pbx parampbx, long paramLong) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      QLog.d(".troop.VideoCombineHelper", 2, "combineWording end! isSuccess:" + paramBoolean + " path = " + paramString1);
      QLog.d(".troop.trace_video_combine", 2, "combineWordingTime:" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    File localFile = new File(paramString1);
    if ((paramBoolean) && (localFile.exists()))
    {
      this.jdField_a_of_type_Pbx.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineParams.e = paramString1;
      this.jdField_a_of_type_Pbx.jdField_a_of_type_Pbw.a.b(this.jdField_a_of_type_Pbx.jdField_a_of_type_Pbw);
      this.jdField_a_of_type_Pbx.jdField_a_of_type_Pbw.b();
      return;
    }
    this.jdField_a_of_type_Pbx.jdField_a_of_type_Pbw.d = paramString2;
    this.jdField_a_of_type_Pbx.jdField_a_of_type_Pbw.a.a(this.jdField_a_of_type_Pbx.jdField_a_of_type_Pbw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pca
 * JD-Core Version:    0.7.0.1
 */