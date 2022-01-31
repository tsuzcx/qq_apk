package com.tencent.mobileqq.shortvideo.filter;

import aigf;
import aigg;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferData;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferRender;
import java.util.LinkedList;

public class QQTransferFilter
  extends QQBaseFilter
{
  private TransferRender jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferRender = new TransferRender();
  private final LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private boolean jdField_a_of_type_Boolean = true;
  
  public QQTransferFilter(QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(160, paramQQFilterRenderManager);
  }
  
  private void a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) {
        ((Runnable)this.jdField_a_of_type_JavaUtilLinkedList.removeFirst()).run();
      }
    }
  }
  
  private void a(Runnable paramRunnable)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.addLast(paramRunnable);
      return;
    }
  }
  
  public void a(float paramFloat)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    a(new aigg(this, paramFloat));
  }
  
  public void a(TransferData paramTransferData)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    a(new aigf(this, paramTransferData));
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferRender.a(paramInt1, paramInt2);
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferRender.a();
  }
  
  public boolean f_()
  {
    return (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferRender.a());
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      a();
      long l = a().b() / 1000000L;
      int i = this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferRender.a(this.jdField_a_of_type_Int, null, null, l);
      if (i >= 0)
      {
        this.b = i;
        return;
      }
      this.b = this.jdField_a_of_type_Int;
      return;
    }
    this.b = this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQTransferFilter
 * JD-Core Version:    0.7.0.1
 */