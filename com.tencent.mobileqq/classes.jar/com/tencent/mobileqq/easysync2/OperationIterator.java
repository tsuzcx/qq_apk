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
      this.jdField_a_of_type_JavaUtilIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      return;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    Matcher localMatcher = Pattern.compile("((?:\\*[0-9a-z]+)*)(?:\\|([0-9a-z]+))?([-+=])([0-9a-z]+)|\\?|").matcher(paramString);
    label61:
    Object localObject;
    char c;
    label140:
    String str;
    while (localMatcher.find()) {
      if (localMatcher.group(0).length() != 0)
      {
        if ("?".equals(localMatcher.group(0))) {
          throw new IllegalArgumentException("Hit error opcode in op stream: " + paramString);
        }
        localObject = localMatcher.group(3);
        if (!Utils.a((String)localObject)) {
          break label220;
        }
        c = '\000';
        localObject = Changeset.a(c);
        str = localMatcher.group(2);
        if (!Utils.a(str)) {
          break label230;
        }
        i = 0;
        label164:
        ((Operation)localObject).b = i;
        ((Operation)localObject).jdField_a_of_type_JavaLangString = localMatcher.group(1);
        str = localMatcher.group(4);
        if (!Utils.a(str)) {
          break label239;
        }
      }
    }
    label220:
    label230:
    label239:
    for (int i = 0;; i = Changeset.a(str))
    {
      ((Operation)localObject).jdField_a_of_type_Int = i;
      this.jdField_a_of_type_JavaUtilList.add(localObject);
      break label61;
      break;
      c = ((String)localObject).charAt(0);
      break label140;
      i = Changeset.a(str);
      break label164;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.easysync2.OperationIterator
 * JD-Core Version:    0.7.0.1
 */