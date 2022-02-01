package com.tencent.mobileqq.easysync2;

final class Changeset$14
  implements OpZipProcessor
{
  public void a(Operation paramOperation1, Operation paramOperation2, Operation paramOperation3)
  {
    int i = paramOperation1.jdField_a_of_type_Char;
    int j = paramOperation2.jdField_a_of_type_Char;
    if ((i == 43) && (j == 45)) {
      this.jdField_a_of_type_ComTencentMobileqqEasysync2StringIterator.a(Math.min(paramOperation1.jdField_a_of_type_Int, paramOperation2.jdField_a_of_type_Int));
    }
    Changeset.b(paramOperation1, paramOperation2, paramOperation3, this.jdField_a_of_type_ComTencentMobileqqEasysync2AttribPool);
    if (paramOperation3.jdField_a_of_type_Char == '+')
    {
      if (j == 43)
      {
        this.jdField_a_of_type_JavaLangStringBuilder.append(this.b.a(paramOperation3.jdField_a_of_type_Int));
        return;
      }
      this.jdField_a_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqEasysync2StringIterator.a(paramOperation3.jdField_a_of_type_Int));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.easysync2.Changeset.14
 * JD-Core Version:    0.7.0.1
 */