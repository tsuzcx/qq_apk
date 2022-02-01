package com.tencent.mobileqq.kandian.biz.playfeeds;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.tencent.mobileqq.app.QBaseFragment;
import java.util.List;

public class VideoFeedsLoadDelegate$Adapter
  extends FragmentStatePagerAdapter
{
  private List<QBaseFragment> jdField_a_of_type_JavaUtilList;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  public VideoFeedsLoadDelegate$Adapter(FragmentManager paramFragmentManager, List<QBaseFragment> paramList, String[] paramArrayOfString)
  {
    super(paramFragmentManager);
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
  }
  
  public QBaseFragment a(int paramInt)
  {
    return (QBaseFragment)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public List<QBaseFragment> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public int getCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public int getItemPosition(Object paramObject)
  {
    if (this.jdField_a_of_type_JavaUtilList.indexOf(paramObject) < 0) {
      return -2;
    }
    return -1;
  }
  
  public CharSequence getPageTitle(int paramInt)
  {
    String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
    if ((arrayOfString != null) && (paramInt < arrayOfString.length)) {
      return arrayOfString[paramInt];
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsLoadDelegate.Adapter
 * JD-Core Version:    0.7.0.1
 */