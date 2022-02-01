package com.tencent.mobileqq.search.model;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import java.util.List;
import pb.unify.search.UnifySearchUnite.TabItemGroup;
import tencent.im.oidb.search.UniteSearch.TabItemGroup;

public class GroupTabModel
{
  public String a;
  public List<Long> a;
  
  public GroupTabModel() {}
  
  public GroupTabModel(UnifySearchUnite.TabItemGroup paramTabItemGroup)
  {
    if (paramTabItemGroup != null)
    {
      this.jdField_a_of_type_JavaLangString = paramTabItemGroup.tab_name.get().toStringUtf8();
      this.jdField_a_of_type_JavaUtilList = paramTabItemGroup.rpt_group_mask.get();
      return;
    }
    throw new RuntimeException("group is null in GroupTabModel Constructor.");
  }
  
  public GroupTabModel(UniteSearch.TabItemGroup paramTabItemGroup)
  {
    if (paramTabItemGroup != null)
    {
      this.jdField_a_of_type_JavaLangString = paramTabItemGroup.tab_name.get().toStringUtf8();
      this.jdField_a_of_type_JavaUtilList = paramTabItemGroup.rpt_group_mask.get();
      return;
    }
    throw new RuntimeException("group is null in GroupTabModel Constructor.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.GroupTabModel
 * JD-Core Version:    0.7.0.1
 */