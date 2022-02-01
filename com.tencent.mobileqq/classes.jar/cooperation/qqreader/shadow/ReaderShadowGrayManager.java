package cooperation.qqreader.shadow;

import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.util.Pair;
import mqq.app.AppRuntime;

public class ReaderShadowGrayManager
{
  private static final Pair<Integer, Integer> jdField_a_of_type_ComTencentUtilPair = new Pair(Integer.valueOf(1494), Integer.valueOf(2));
  private static boolean jdField_a_of_type_Boolean = false;
  
  public static SharedPreferences a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("Reader_shadow_gray" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.shadow.ReaderShadowGrayManager
 * JD-Core Version:    0.7.0.1
 */