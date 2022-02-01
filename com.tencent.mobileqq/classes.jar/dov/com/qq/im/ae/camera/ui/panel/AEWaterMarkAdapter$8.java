package dov.com.qq.im.ae.camera.ui.panel;

import dov.com.qq.im.ae.util.AEQLog;

class AEWaterMarkAdapter$8
  implements Runnable
{
  AEWaterMarkAdapter$8(AEWaterMarkAdapter paramAEWaterMarkAdapter, int paramInt, Object[] paramArrayOfObject) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int == 114)
    {
      AEQLog.a("AEWaterMarkAdapter", "water mark notify SHOW_WATERMARK_EDITPICTURE");
      if ((this.jdField_a_of_type_ArrayOfJavaLangObject != null) && (this.jdField_a_of_type_ArrayOfJavaLangObject.length == 1)) {
        AEWaterMarkAdapter.a(this.this$0, true, this.jdField_a_of_type_ArrayOfJavaLangObject[0]);
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
        AEQLog.a("AEWaterMarkAdapter", "water mark notify SHOW_WATERMARK_EDITPICTURE");
      } while ((this.jdField_a_of_type_ArrayOfJavaLangObject == null) || (this.jdField_a_of_type_ArrayOfJavaLangObject.length != 1));
      AEWaterMarkAdapter.a(this.this$0, false, this.jdField_a_of_type_ArrayOfJavaLangObject[0]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEWaterMarkAdapter.8
 * JD-Core Version:    0.7.0.1
 */