package com.tencent.mobileqq.search.searchengine;

import ajdx;
import anyu;
import bcmd;
import bcmj;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.concurrent.CountDownLatch;

public class NetSearchEngine$NetSearchRunnalbe
  implements Runnable
{
  private int jdField_a_of_type_Int;
  public anyu a;
  private bcmd jdField_a_of_type_Bcmd;
  private String jdField_a_of_type_JavaLangString;
  public CountDownLatch a;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt;
  
  public NetSearchEngine$NetSearchRunnalbe(NetSearchEngine paramNetSearchEngine, String paramString, int[] paramArrayOfInt, int paramInt, bcmd parambcmd)
  {
    this.jdField_a_of_type_Anyu = new bcmj(this);
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    this.jdField_a_of_type_Bcmd = parambcmd;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch = new CountDownLatch(1);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bcmd = null;
    NetSearchEngine.a(this.this$0).removeObserver(this.jdField_a_of_type_Anyu);
    this.jdField_a_of_type_Anyu = null;
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
  }
  
  public void run()
  {
    NetSearchEngine.a(this.this$0).addObserver(this.jdField_a_of_type_Anyu);
    this.this$0.jdField_a_of_type_Ajdx.a(this.jdField_a_of_type_Int);
    if (NetSearchEngine.a(this.this$0) == 12)
    {
      this.this$0.jdField_a_of_type_Ajdx.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfInt, NetSearchEngine.b, NetSearchEngine.jdField_a_of_type_Double, false, 1);
      return;
    }
    this.this$0.jdField_a_of_type_Ajdx.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfInt, NetSearchEngine.b, NetSearchEngine.jdField_a_of_type_Double, false, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.NetSearchEngine.NetSearchRunnalbe
 * JD-Core Version:    0.7.0.1
 */