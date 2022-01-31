import com.tencent.av.ui.MultiVideoCtrlLayerUIBase;

public class jxj
  implements Runnable
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  boolean jdField_a_of_type_Boolean;
  int b;
  
  public jxj(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase, long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.b = paramInt2;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt1;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jxj
 * JD-Core Version:    0.7.0.1
 */