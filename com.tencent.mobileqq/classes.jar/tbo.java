import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.List;

public class tbo
  extends FragmentPagerAdapter
{
  private List<Fragment> jdField_a_of_type_JavaUtilList;
  
  public tbo(FragmentManager paramFragmentManager, List<Fragment> paramList)
  {
    super(paramList);
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Fragment getItem(int paramInt)
  {
    return (Fragment)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tbo
 * JD-Core Version:    0.7.0.1
 */