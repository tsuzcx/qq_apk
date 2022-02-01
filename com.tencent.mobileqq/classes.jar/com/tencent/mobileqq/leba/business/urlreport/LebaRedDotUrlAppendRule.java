package com.tencent.mobileqq.leba.business.urlreport;

import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import java.util.Iterator;
import java.util.List;

public class LebaRedDotUrlAppendRule
  extends BaseLebaUrlAppendRule
{
  private List<String> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  
  public LebaRedDotUrlAppendRule(boolean paramBoolean, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if ((paramAppInfo != null) && (paramAppInfo.missions != null)) {
      this.jdField_a_of_type_JavaUtilList = paramAppInfo.missions.get();
    }
  }
  
  public String a()
  {
    String str = String.format("&hasRedDot=%b", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    Object localObject1 = str;
    if (this.jdField_a_of_type_Boolean)
    {
      Object localObject2 = this.jdField_a_of_type_JavaUtilList;
      localObject1 = str;
      if (localObject2 != null)
      {
        localObject1 = str;
        if (!((List)localObject2).isEmpty())
        {
          localObject1 = new StringBuilder();
          localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            ((StringBuilder)localObject1).append((String)((Iterator)localObject2).next());
            ((StringBuilder)localObject1).append("_");
          }
          ((StringBuilder)localObject1).deleteCharAt(((StringBuilder)localObject1).length() - 1);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(str);
          ((StringBuilder)localObject2).append(String.format("&missions=%s", new Object[] { ((StringBuilder)localObject1).toString() }));
          localObject1 = ((StringBuilder)localObject2).toString();
        }
      }
    }
    return localObject1;
  }
  
  public boolean a(String paramString)
  {
    return (paramString != null) && (paramString.contains("need_fill_red_point_info=1"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.urlreport.LebaRedDotUrlAppendRule
 * JD-Core Version:    0.7.0.1
 */