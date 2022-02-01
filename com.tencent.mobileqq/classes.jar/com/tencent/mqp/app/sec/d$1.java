package com.tencent.mqp.app.sec;

final class d$1
  implements Runnable
{
  d$1(int paramInt, Object[] paramArrayOfObject, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_Int;
    if (i != -1)
    {
      Object[] arrayOfObject = this.jdField_a_of_type_ArrayOfJavaLangObject;
      if (arrayOfObject != null)
      {
        byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
        if (arrayOfByte != null) {
          try
          {
            d.e(i, arrayOfObject, arrayOfByte);
            return;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mqp.app.sec.d.1
 * JD-Core Version:    0.7.0.1
 */