package dov.com.tencent.biz.qqstory.takevideo.filter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

public abstract class FilterData$FilterPageItem<T extends FilterData>
{
  protected int a;
  public final View a;
  public T a;
  
  protected FilterData$FilterPageItem(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = a(paramContext, paramViewGroup);
    if (this.jdField_a_of_type_AndroidViewView == null) {
      throw new NullPointerException("onCreateView can not return null");
    }
  }
  
  protected abstract View a(@NonNull Context paramContext, ViewGroup paramViewGroup);
  
  public void a()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoFilterFilterData = null;
    this.jdField_a_of_type_Int = -1;
  }
  
  public void a(T paramT, int paramInt)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoFilterFilterData = paramT;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoFilterFilterData != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoFilterFilterData.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.filter.FilterData.FilterPageItem
 * JD-Core Version:    0.7.0.1
 */