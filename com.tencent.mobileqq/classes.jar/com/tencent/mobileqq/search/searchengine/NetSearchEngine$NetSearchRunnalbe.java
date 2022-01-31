package com.tencent.mobileqq.search.searchengine;

import affj;
import ajxj;
import awuv;
import awvb;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.concurrent.CountDownLatch;

public class NetSearchEngine$NetSearchRunnalbe
  implements Runnable
{
  private int jdField_a_of_type_Int;
  public ajxj a;
  private awuv jdField_a_of_type_Awuv;
  private String jdField_a_of_type_JavaLangString;
  public CountDownLatch a;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt;
  
  public NetSearchEngine$NetSearchRunnalbe(NetSearchEngine paramNetSearchEngine, String paramString, int[] paramArrayOfInt, int paramInt, awuv paramawuv)
  {
    this.jdField_a_of_type_Ajxj = new awvb(this);
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    this.jdField_a_of_type_Awuv = paramawuv;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch = new CountDownLatch(1);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Awuv = null;
    NetSearchEngine.a(this.this$0).removeObserver(this.jdField_a_of_type_Ajxj);
    this.jdField_a_of_type_Ajxj = null;
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
  }
  
  public void run()
  {
    NetSearchEngine.a(this.this$0).addObserver(this.jdField_a_of_type_Ajxj);
    this.this$0.jdField_a_of_type_Affj.a(this.jdField_a_of_type_Int);
    if (NetSearchEngine.a(this.this$0) == 12)
    {
      this.this$0.jdField_a_of_type_Affj.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfInt, NetSearchEngine.b, NetSearchEngine.jdField_a_of_type_Double, false, 1);
      return;
    }
    this.this$0.jdField_a_of_type_Affj.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfInt, NetSearchEngine.b, NetSearchEngine.jdField_a_of_type_Double, false, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.NetSearchEngine.NetSearchRunnalbe
 * JD-Core Version:    0.7.0.1
 */