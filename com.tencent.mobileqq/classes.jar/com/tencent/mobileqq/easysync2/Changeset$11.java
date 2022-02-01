package com.tencent.mobileqq.easysync2;

final class Changeset$11
  implements OpZipProcessor
{
  Changeset$11(StringIterator paramStringIterator1, StringIterator paramStringIterator2, AttributeTester paramAttributeTester, boolean paramBoolean, AttribPool paramAttribPool, int[] paramArrayOfInt1, int[] paramArrayOfInt2) {}
  
  public void a(Operation paramOperation1, Operation paramOperation2, Operation paramOperation3)
  {
    if ((paramOperation1.jdField_a_of_type_Char != '+') && (paramOperation2.jdField_a_of_type_Char != '+'))
    {
      if (paramOperation1.jdField_a_of_type_Char == '-')
      {
        Changeset.b(paramOperation1, paramOperation2);
      }
      else if (paramOperation2.jdField_a_of_type_Char == '-')
      {
        Changeset.a(paramOperation1, paramOperation2, paramOperation3);
      }
      else if (paramOperation1.jdField_a_of_type_Char == 0)
      {
        Changeset.a(paramOperation2, paramOperation3);
        paramOperation2.jdField_a_of_type_Char = '\000';
      }
      else if (paramOperation2.jdField_a_of_type_Char == 0)
      {
        paramOperation1.jdField_a_of_type_Char = '\000';
      }
      else
      {
        Changeset.c(paramOperation1, paramOperation2, paramOperation3, this.jdField_a_of_type_ComTencentMobileqqEasysync2AttribPool);
      }
    }
    else {
      Changeset.a(paramOperation1, paramOperation2, paramOperation3, this.jdField_a_of_type_ComTencentMobileqqEasysync2StringIterator, this.jdField_b_of_type_ComTencentMobileqqEasysync2StringIterator, this.jdField_a_of_type_ComTencentMobileqqEasysync2AttributeTester, this.jdField_a_of_type_Boolean);
    }
    int i = paramOperation3.jdField_a_of_type_Char;
    if (i != 43)
    {
      if (i != 45)
      {
        if (i != 61) {
          return;
        }
        paramOperation1 = this.jdField_a_of_type_ArrayOfInt;
        paramOperation1[0] += paramOperation3.jdField_a_of_type_Int;
        paramOperation1 = this.jdField_b_of_type_ArrayOfInt;
        paramOperation1[0] += paramOperation3.jdField_a_of_type_Int;
        return;
      }
      paramOperation1 = this.jdField_a_of_type_ArrayOfInt;
      paramOperation1[0] += paramOperation3.jdField_a_of_type_Int;
      return;
    }
    paramOperation1 = this.jdField_b_of_type_ArrayOfInt;
    paramOperation1[0] += paramOperation3.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.easysync2.Changeset.11
 * JD-Core Version:    0.7.0.1
 */