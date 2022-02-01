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
  List<Operation> a;
  private Iterator<Operation> b;
  
  public OperationIterator(String paramString)
  {
    if (Changeset.b)
    {
      this.a = new OperationParser().a(paramString);
    }
    else
    {
      this.a = new ArrayList();
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
              i = Changeset.b(str);
            }
            ((Operation)localObject2).c = i;
            ((Operation)localObject2).d = ((Matcher)localObject1).group(1);
            str = ((Matcher)localObject1).group(4);
            if (Utils.a(str)) {
              i = j;
            } else {
              i = Changeset.b(str);
            }
            ((Operation)localObject2).b = i;
            this.a.add(localObject2);
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
    this.b = this.a.iterator();
  }
  
  public Operation a()
  {
    return (Operation)this.b.next();
  }
  
  public boolean hasNext()
  {
    return this.b.hasNext();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.easysync2.OperationIterator
 * JD-Core Version:    0.7.0.1
 */