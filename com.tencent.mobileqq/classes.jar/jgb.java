import android.os.Handler;
import com.tencent.av.AVLog;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.magicface.MagicFaceDataEntity;

public class jgb
  implements Runnable
{
  public jgb(MagicFaceDataEntity paramMagicFaceDataEntity, String paramString) {}
  
  public void run()
  {
    AVLog.c("MagicFaceDataEntity", "reloadDecrateList 2:" + this.jdField_a_of_type_JavaLangString);
    jgc localjgc = new jgc(this);
    this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity.a.a().post(localjgc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jgb
 * JD-Core Version:    0.7.0.1
 */