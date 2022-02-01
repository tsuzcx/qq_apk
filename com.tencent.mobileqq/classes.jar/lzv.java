class lzv
{
  lpx jdField_a_of_type_Lpx;
  lzu[] jdField_a_of_type_ArrayOfLzu = new lzu[2];
  
  lzv(lzt paramlzt)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfLzu.length)
    {
      this.jdField_a_of_type_ArrayOfLzu[i] = new lzu(paramlzt);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lzv
 * JD-Core Version:    0.7.0.1
 */