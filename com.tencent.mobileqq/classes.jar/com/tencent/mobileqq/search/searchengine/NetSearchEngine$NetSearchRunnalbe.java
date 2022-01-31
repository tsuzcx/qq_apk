package com.tencent.mobileqq.search.searchengine;

import ahhd;
import altm;
import ayuh;
import ayun;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.concurrent.CountDownLatch;

public class NetSearchEngine$NetSearchRunnalbe
  implements Runnable
{
  private int jdField_a_of_type_Int;
  public altm a;
  private ayuh jdField_a_of_type_Ayuh;
  private String jdField_a_of_type_JavaLangString;
  public CountDownLatch a;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt;
  
  public NetSearchEngine$NetSearchRunnalbe(NetSearchEngine paramNetSearchEngine, String paramString, int[] paramArrayOfInt, int paramInt, ayuh paramayuh)
  {
    this.jdField_a_of_type_Altm = new ayun(this);
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    this.jdField_a_of_type_Ayuh = paramayuh;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch = new CountDownLatch(1);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Ayuh = null;
    NetSearchEngine.a(this.this$0).removeObserver(this.jdField_a_of_type_Altm);
    this.jdField_a_of_type_Altm = null;
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
  }
  
  public void run()
  {
    NetSearchEngine.a(this.this$0).addObserver(this.jdField_a_of_type_Altm);
    this.this$0.jdField_a_of_type_Ahhd.a(this.jdField_a_of_type_Int);
    if (NetSearchEngine.a(this.this$0) == 12)
    {
      this.this$0.jdField_a_of_type_Ahhd.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfInt, NetSearchEngine.b, NetSearchEngine.jdField_a_of_type_Double, false, 1);
      return;
    }
    this.this$0.jdField_a_of_type_Ahhd.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfInt, NetSearchEngine.b, NetSearchEngine.jdField_a_of_type_Double, false, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.NetSearchEngine.NetSearchRunnalbe
 * JD-Core Version:    0.7.0.1
 */