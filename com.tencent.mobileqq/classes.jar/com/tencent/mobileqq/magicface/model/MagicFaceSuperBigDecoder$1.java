package com.tencent.mobileqq.magicface.model;

import awfq;
import awfv;
import com.tencent.mobileqq.magicface.DecoderUtil;
import com.tencent.qphone.base.util.QLog;

public class MagicFaceSuperBigDecoder$1
  implements Runnable
{
  public MagicFaceSuperBigDecoder$1(awfq paramawfq) {}
  
  public void run()
  {
    long l2;
    label665:
    int i;
    label692:
    long l1;
    for (;;)
    {
      long l3;
      Object localObject;
      try
      {
        if (!QLog.isColorLevel()) {
          break label692;
        }
        QLog.d("MagicFaceSuperBigDecoder", 2, "func mDecoder.run begins, isStartDecodr:" + this.this$0.jdField_a_of_type_Boolean);
      }
      catch (Exception localException)
      {
        int j;
        localException.printStackTrace();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MagicFaceSuperBigDecoder", 2, "func mDecoder.run ends, error is catched.msg:" + localException.getMessage());
        return;
        this.this$0.h = j;
        this.this$0.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.decodeAlphaDecoderReturnYUV(this.this$0.jdField_e_of_type_ArrayOfByte, this.this$0.g, this.this$0.jdField_f_of_type_ArrayOfByte);
        if (this.this$0.i != -1) {
          continue;
        }
        this.this$0.i = this.this$0.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.getWidthAlphaDecoder();
        this.this$0.j = this.this$0.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.getHeightAlphaDecoder();
        if (this.this$0.jdField_a_of_type_Awfv == null) {
          continue;
        }
        this.this$0.jdField_a_of_type_Awfv.a(this.this$0.jdField_c_of_type_ArrayOfByte, this.this$0.jdField_f_of_type_ArrayOfByte, this.this$0.jdField_e_of_type_Int, this.this$0.jdField_f_of_type_Int, 0.0F);
        l3 = System.currentTimeMillis() - l2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MagicFaceSuperBigDecoder", 2, "func mDecoder.run, 【useFrameTime】 " + l3);
        if (l3 >= this.this$0.jdField_b_of_type_Int) {
          break label665;
        }
        if (localObject <= 0L) {
          continue;
        }
        l2 = this.this$0.jdField_b_of_type_Int - l3;
        if (l2 <= localObject) {
          break label711;
        }
        Thread.sleep(l2 - localObject);
        break label700;
        Thread.sleep(this.this$0.jdField_b_of_type_Int - l3);
        l2 = localObject;
        break label703;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localOutOfMemoryError.printStackTrace();
        return;
      }
      if (!this.this$0.jdField_a_of_type_Boolean) {
        break;
      }
      l2 = System.currentTimeMillis();
      j = this.this$0.a(this.this$0.jdField_a_of_type_ArrayOfByte, this.this$0.jdField_d_of_type_Int);
      this.this$0.jdField_c_of_type_Int = (j - this.this$0.jdField_d_of_type_Int);
      if (this.this$0.jdField_c_of_type_Int <= 0)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MagicFaceSuperBigDecoder", 2, "func mDecoder.run ends, 【condition】 frame len <= 0, videoFrameLength:" + this.this$0.jdField_c_of_type_Int);
        return;
      }
      this.this$0.a(this.this$0.jdField_c_of_type_Int, this.this$0.jdField_d_of_type_Int, this.this$0.jdField_a_of_type_ArrayOfByte);
      this.this$0.jdField_d_of_type_Int = j;
      this.this$0.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.decodeVideoDecoderReturnYUV(this.this$0.jdField_b_of_type_ArrayOfByte, this.this$0.jdField_c_of_type_Int, this.this$0.jdField_c_of_type_ArrayOfByte);
      if (this.this$0.jdField_e_of_type_Int == -1)
      {
        this.this$0.jdField_e_of_type_Int = this.this$0.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.getWidthVideoDecoder();
        this.this$0.jdField_f_of_type_Int = this.this$0.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.getHeightVideoDecoder();
      }
      j = this.this$0.a(this.this$0.jdField_d_of_type_ArrayOfByte, this.this$0.h);
      this.this$0.g = (j - this.this$0.h);
      this.this$0.b(this.this$0.g, this.this$0.h, this.this$0.jdField_d_of_type_ArrayOfByte);
      if (this.this$0.g <= 0)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MagicFaceSuperBigDecoder", 2, "func mDecoder.run ends, 【condition】 frame len <= 0, alphaFrameLength:" + this.this$0.g);
        return;
      }
      l2 = localObject;
      if (i != 0) {
        break label703;
      }
      i = this.this$0.jdField_b_of_type_Int;
      l2 = localObject + (l3 - i);
      break label703;
      l1 = 0L;
      i = 1;
    }
    return;
    for (;;)
    {
      label700:
      l2 = l1;
      label703:
      i = 0;
      l1 = l2;
      break;
      label711:
      l1 -= l2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.model.MagicFaceSuperBigDecoder.1
 * JD-Core Version:    0.7.0.1
 */