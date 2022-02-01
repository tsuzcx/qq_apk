package cooperation.comic;

import android.support.annotation.NonNull;
import java.util.ArrayList;

public class VipComicNavConfigHelper$TabItemData
  implements Comparable<TabItemData>
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  String b;
  String c;
  String d;
  
  public int a(@NonNull TabItemData paramTabItemData)
  {
    if (this.jdField_a_of_type_Int < paramTabItemData.jdField_a_of_type_Int) {}
    int i;
    int j;
    do
    {
      return -1;
      if (this.jdField_a_of_type_Int > paramTabItemData.jdField_a_of_type_Int) {
        return 1;
      }
      i = VipComicNavConfigHelper.a().indexOf(this.jdField_a_of_type_JavaLangString);
      j = VipComicNavConfigHelper.a().indexOf(paramTabItemData.jdField_a_of_type_JavaLangString);
    } while (i < j);
    if (i > j) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.comic.VipComicNavConfigHelper.TabItemData
 * JD-Core Version:    0.7.0.1
 */