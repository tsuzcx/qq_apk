class mar
{
  lqt jdField_a_of_type_Lqt;
  maq[] jdField_a_of_type_ArrayOfMaq = new maq[2];
  
  mar(map parammap)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfMaq.length)
    {
      this.jdField_a_of_type_ArrayOfMaq[i] = new maq(parammap);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mar
 * JD-Core Version:    0.7.0.1
 */