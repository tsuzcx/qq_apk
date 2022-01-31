package dov.com.tencent.biz.qqstory.takevideo.tag;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import anot;
import com.tencent.biz.qqstory.takevideo.tag.TagItem;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

public class QQStoryTagAdapter
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  @Nullable
  private TagItem jdField_a_of_type_ComTencentBizQqstoryTakevideoTagTagItem;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public QQStoryTagAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  @Nullable
  public TagItem a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagTagItem;
  }
  
  public void a(@Nullable TagItem paramTagItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagTagItem = paramTagItem;
  }
  
  public void a(List paramList)
  {
    if (paramList == null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      return;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970804, null);
      paramView = new anot(paramViewGroup);
      paramViewGroup.setTag(paramView);
    }
    for (;;)
    {
      paramView.a((TagItem)this.jdField_a_of_type_JavaUtilList.get(paramInt), this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagTagItem);
      return paramView.a;
      paramView = (anot)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.tag.QQStoryTagAdapter
 * JD-Core Version:    0.7.0.1
 */