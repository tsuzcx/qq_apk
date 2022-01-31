import android.os.Handler;
import com.tencent.av.AVLog;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.magicface.MagicFaceDataEntity;

public class jhp
  implements Runnable
{
  public jhp(MagicFaceDataEntity paramMagicFaceDataEntity, String paramString) {}
  
  public void run()
  {
    AVLog.c("MagicFaceDataEntity", "reloadDecrateList 2:" + this.jdField_a_of_type_JavaLangString);
    jhq localjhq = new jhq(this);
    this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity.a.a().post(localjhq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jhp
 * JD-Core Version:    0.7.0.1
 */