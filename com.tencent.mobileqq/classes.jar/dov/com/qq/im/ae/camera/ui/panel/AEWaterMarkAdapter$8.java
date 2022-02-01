package dov.com.qq.im.ae.camera.ui.panel;

import bnge;
import bnrh;

public class AEWaterMarkAdapter$8
  implements Runnable
{
  public AEWaterMarkAdapter$8(bnge parambnge, int paramInt, Object[] paramArrayOfObject) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int == 114)
    {
      bnrh.a("AEWaterMarkAdapter", "water mark notify SHOW_WATERMARK_EDITPICTURE");
      if ((this.jdField_a_of_type_ArrayOfJavaLangObject != null) && (this.jdField_a_of_type_ArrayOfJavaLangObject.length == 1)) {
        bnge.a(this.this$0, true, this.jdField_a_of_type_ArrayOfJavaLangObject[0]);
      }
    }
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_Int != 115) {
          break;
        }
        bnrh.a("AEWaterMarkAdapter", "water mark notify SHOW_WATERMARK_EDITPICTURE");
      } while ((this.jdField_a_of_type_ArrayOfJavaLangObject == null) || (this.jdField_a_of_type_ArrayOfJavaLangObject.length != 1));
      bnge.a(this.this$0, false, this.jdField_a_of_type_ArrayOfJavaLangObject[0]);
      return;
      if (this.jdField_a_of_type_Int == 1025)
      {
        this.this$0.notifyDataSetChanged();
        return;
      }
    } while (this.jdField_a_of_type_Int != 113);
    this.this$0.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEWaterMarkAdapter.8
 * JD-Core Version:    0.7.0.1
 */