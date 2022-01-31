package dov.com.tencent.biz.qqstory.takevideo.permission;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.Groups;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ComplexPart$Group
{
  @NonNull
  protected final Groups a;
  @NonNull
  private final List jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  @NonNull
  private final List b = new ArrayList();
  
  public ComplexPart$Group(@NonNull Groups paramGroups, @NonNull List paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataGroups = paramGroups;
    this.jdField_a_of_type_JavaUtilList = paramList;
    paramGroups = paramList.iterator();
    while (paramGroups.hasNext())
    {
      paramList = (ComplexPart.Friend)paramGroups.next();
      if (paramList.jdField_a_of_type_Boolean) {
        this.b.add(paramList);
      }
    }
  }
  
  public int a()
  {
    return this.b.size();
  }
  
  @NonNull
  public List a()
  {
    return Collections.unmodifiableList(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public void a(ComplexPart.Friend paramFriend)
  {
    paramFriend.a();
    if ((paramFriend.jdField_a_of_type_Boolean) && (!this.b.contains(paramFriend)))
    {
      this.b.add(paramFriend);
      return;
    }
    if ((!paramFriend.jdField_a_of_type_Boolean) && (this.b.contains(paramFriend)))
    {
      this.b.remove(paramFriend);
      return;
    }
    throw new IllegalStateException("onFriendClick, friend select:" + paramFriend.jdField_a_of_type_Boolean + ",contains:" + this.b.contains(paramFriend));
  }
  
  public boolean a()
  {
    return (!this.b.isEmpty()) && (this.jdField_a_of_type_JavaUtilList.size() == this.b.size());
  }
  
  public int b()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  @NonNull
  public List b()
  {
    return Collections.unmodifiableList(this.b);
  }
  
  public void b()
  {
    this.b.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      ComplexPart.Friend localFriend = (ComplexPart.Friend)localIterator.next();
      localFriend.jdField_a_of_type_Boolean = true;
      this.b.add(localFriend);
    }
  }
  
  public void b(ComplexPart.Friend paramFriend)
  {
    paramFriend.jdField_a_of_type_Boolean = true;
    if (!this.b.contains(paramFriend)) {
      this.b.add(paramFriend);
    }
  }
  
  public void c()
  {
    this.b.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ComplexPart.Friend)localIterator.next()).jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.permission.ComplexPart.Group
 * JD-Core Version:    0.7.0.1
 */