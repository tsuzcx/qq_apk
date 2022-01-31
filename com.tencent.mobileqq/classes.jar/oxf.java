import com.tencent.biz.troop.VideoCombineHelper;
import com.tencent.biz.troop.VideoCombineHelper.Callback;
import com.tencent.biz.troop.VideoCombineHelper.CombineParams;
import com.tencent.biz.troop.VideoCombineHelper.TaskListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class oxf
  implements VideoCombineHelper.Callback
{
  oxf(oxe paramoxe, VideoCombineHelper.CombineParams paramCombineParams) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.VideoCombineHelper", 2, "combineVideos end! isSuccess:" + paramBoolean + " path = " + paramString1);
    }
    File localFile = new File(paramString1);
    if ((paramBoolean) && (localFile.exists()))
    {
      if (this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineParams.a)
      {
        this.jdField_a_of_type_Oxe.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$TaskListener.b(this.jdField_a_of_type_Oxe);
        return;
      }
      if (this.jdField_a_of_type_Oxe.jdField_a_of_type_JavaLangString != null)
      {
        l = System.currentTimeMillis();
        this.jdField_a_of_type_Oxe.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper.a(paramString1, this.jdField_a_of_type_Oxe.jdField_a_of_type_JavaLangString, new oxg(this, l));
        return;
      }
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_Oxe.a(localFile, this.jdField_a_of_type_Oxe.b, new oxi(this, l));
      return;
    }
    this.jdField_a_of_type_Oxe.d = paramString2;
    this.jdField_a_of_type_Oxe.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$TaskListener.a(this.jdField_a_of_type_Oxe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oxf
 * JD-Core Version:    0.7.0.1
 */