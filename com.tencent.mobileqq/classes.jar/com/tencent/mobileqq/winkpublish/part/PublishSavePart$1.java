package com.tencent.mobileqq.winkpublish.part;

import com.tencent.mobileqq.winkpublish.util.FileUtil;
import java.util.Iterator;
import java.util.List;

final class PublishSavePart$1
  implements Runnable
{
  PublishSavePart$1(List paramList, String paramString) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("QQCircle_");
      ((StringBuilder)localObject).append(String.valueOf(System.currentTimeMillis()));
      ((StringBuilder)localObject).append(str.substring(str.lastIndexOf(".")));
      localObject = ((StringBuilder)localObject).toString();
      FileUtil.a(str, this.b, (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.PublishSavePart.1
 * JD-Core Version:    0.7.0.1
 */