import com.tencent.av.VideoController;
import com.tencent.av.ui.MultiVideoCtrlLayerUI4Discussion;
import java.util.ArrayList;

public class mff
  implements mho
{
  public mff(MultiVideoCtrlLayerUI4Discussion paramMultiVideoCtrlLayerUI4Discussion, long paramLong) {}
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.j = true;
    this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.M();
  }
  
  public void b()
  {
    lez locallez = this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.a.a();
    if (locallez != null)
    {
      lba.g(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.d, " TYPE_NOTIFY_CAMERA_CLOSE 2: " + locallez.j + "|" + locallez.d);
      if (locallez.j) {
        this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.b.update(null, new Object[] { Integer.valueOf(106), Long.valueOf(this.jdField_a_of_type_Long) });
      }
    }
    MultiVideoCtrlLayerUI4Discussion.a(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion, this.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.d(true);
    bcef.b(null, "CliOper", "", "", "0X8004CF2", "0X8004CF2", 0, 0, "", "", "", "");
    if (((this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.f == 90) || (this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.f == 270)) && (this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.a.a().b() != -1) && (((lno)this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.a.a().c.get(0)).a == 1)) {
      bcef.b(null, "CliOper", "", "", "0X8004CFB", "0X8004CFB", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.j = false;
      return;
      if (((this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.f == 90) || (this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.f == 270)) && (this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.a.a().b() != -1) && (((lno)this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.a.a().c.get(0)).a == 2)) {
        bcef.b(null, "CliOper", "", "", "0X8004CFC", "0X8004CFC", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mff
 * JD-Core Version:    0.7.0.1
 */