class mav
{
  lqo jdField_a_of_type_Lqo;
  mau[] jdField_a_of_type_ArrayOfMau = new mau[2];
  
  mav(mat parammat)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfMau.length)
    {
      this.jdField_a_of_type_ArrayOfMau[i] = new mau(parammat);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mav
 * JD-Core Version:    0.7.0.1
 */