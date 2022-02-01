package com.tencent.mobileqq.kandian.repo.feeds;

import android.util.SparseArray;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SpecialChannelFilter
{
  private static SpecialChannelFilter jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsSpecialChannelFilter;
  private SparseArray<ChannelInfo> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private HashSet<Integer> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private boolean jdField_a_of_type_Boolean = true;
  
  public static SpecialChannelFilter a()
  {
    if (jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsSpecialChannelFilter == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsSpecialChannelFilter == null) {
          jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsSpecialChannelFilter = new SpecialChannelFilter();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsSpecialChannelFilter;
  }
  
  private static boolean a(int paramInt)
  {
    return paramInt == 9999;
  }
  
  public void a(List<Integer> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        int i = ((Integer)paramList.next()).intValue();
        this.jdField_a_of_type_AndroidUtilSparseArray.remove(i);
        this.jdField_a_of_type_JavaUtilHashSet.remove(Integer.valueOf(i));
      }
    }
  }
  
  public void b(List<Integer> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      int j = this.jdField_a_of_type_AndroidUtilSparseArray.size();
      int i = 0;
      while (i < j)
      {
        int k = this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i);
        if ((!a(k)) && (!paramList.contains(Integer.valueOf(k)))) {
          localArrayList.add(Integer.valueOf(k));
        }
        i += 1;
      }
      paramList = localArrayList.iterator();
      while (paramList.hasNext())
      {
        i = ((Integer)paramList.next()).intValue();
        this.jdField_a_of_type_AndroidUtilSparseArray.remove(i);
        this.jdField_a_of_type_JavaUtilHashSet.remove(Integer.valueOf(i));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.SpecialChannelFilter
 * JD-Core Version:    0.7.0.1
 */