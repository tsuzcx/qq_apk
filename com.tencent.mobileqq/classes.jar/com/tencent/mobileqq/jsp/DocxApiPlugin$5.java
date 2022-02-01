package com.tencent.mobileqq.jsp;

import awgk;
import bebl;
import bioy;
import com.tencent.common.app.AppInterface;
import java.util.ArrayList;
import java.util.Iterator;

public class DocxApiPlugin$5
  implements Runnable
{
  public DocxApiPlugin$5(awgk paramawgk, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      bebl.a(this.this$0.mRuntime.a().getCurrentAccountUin(), bebl.a(str), str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.DocxApiPlugin.5
 * JD-Core Version:    0.7.0.1
 */