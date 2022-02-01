package com.tencent.mobileqq.easysync2;

import com.tencent.mobileqq.easysync2.utils.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OperationIterator
  implements Iterator<Operation>
{
  private Iterator<Operation> jdField_a_of_type_JavaUtilIterator;
  List<Operation> jdField_a_of_type_JavaUtilList;
  
  public OperationIterator(String paramString)
  {
    if (Changeset.a)
    {
      this.jdField_a_of_type_JavaUtilList = new OperationParser().a(paramString);
    }
    else
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      Object localObject1 = Pattern.compile("((?:\\*[0-9a-z]+)*)(?:\\|([0-9a-z]+))?([-+=])([0-9a-z]+)|\\?|").matcher(paramString);
      while (((Matcher)localObject1).find())
      {
        int j = 0;
        if (((Matcher)localObject1).group(0).length() != 0) {
          if (!"?".equals(((Matcher)localObject1).group(0)))
          {
            Object localObject2 = ((Matcher)localObject1).group(3);
            char c;
            if (Utils.a((String)localObject2)) {
              c = '\000';
            } else {
              c = ((String)localObject2).charAt(0);
            }
            localObject2 = Changeset.a(c);
            String str = ((Matcher)localObject1).group(2);
            int i;
            if (Utils.a(str)) {
              i = 0;
            } else {
              i = Changeset.a(str);
            }
            ((Operation)localObject2).b = i;
            ((Operation)localObject2).jdField_a_of_type_JavaLangString = ((Matcher)localObject1).group(1);
            str = ((Matcher)localObject1).group(4);
            if (Utils.a(str)) {
              i = j;
            } else {
              i = Changeset.a(str);
            }
            ((Operation)localObject2).jdField_a_of_type_Int = i;
            this.jdField_a_of_type_JavaUtilList.add(localObject2);
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("Hit error opcode in op stream: ");
            ((StringBuilder)localObject1).append(paramString);
            throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
          }
        }
      }
    }
    this.jdField_a_of_type_JavaUtilIterator = this.jdField_a_of_type_JavaUtilList.iterator();
  }
  
  public Operation a()
  {
    return (Operation)this.jdField_a_of_type_JavaUtilIterator.next();
  }
  
  public boolean hasNext()
  {
    return this.jdField_a_of_type_JavaUtilIterator.hasNext();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.easysync2.OperationIterator
 * JD-Core Version:    0.7.0.1
 */