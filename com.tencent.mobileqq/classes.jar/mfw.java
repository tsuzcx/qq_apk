import com.tencent.av.VideoController;
import com.tencent.av.ui.MultiVideoCtrlLayerUI4Discussion;
import java.util.ArrayList;

public class mfw
  implements mif
{
  public mfw(MultiVideoCtrlLayerUI4Discussion paramMultiVideoCtrlLayerUI4Discussion, long paramLong) {}
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.j = true;
    this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.M();
  }
  
  public void b()
  {
    lff locallff = this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.a.a();
    if (locallff != null)
    {
      lbj.d(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.d, " TYPE_NOTIFY_CAMERA_CLOSE 2: " + locallff.j + "|" + locallff.d);
      if (locallff.j) {
        this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.jdField_b_of_type_Mct.update(null, new Object[] { Integer.valueOf(106), Long.valueOf(this.jdField_a_of_type_Long) });
      }
    }
    MultiVideoCtrlLayerUI4Discussion.a(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion, this.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.d(true);
    if (this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.a.e)
    {
      this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.a.a(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.a.c, this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.a.jdField_a_of_type_Long, 100);
      bdll.b(null, "CliOper", "", "", "0X8004CF2", "0X8004CF2", 0, 0, "", "", "", "");
      if (((this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.f != 90) && (this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.f != 270)) || (this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.a.a().b() == -1) || (((lob)this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.a.a().c.get(0)).a != 1)) {
        break label318;
      }
      bdll.b(null, "CliOper", "", "", "0X8004CFB", "0X8004CFB", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.j = false;
      return;
      this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.a.a(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.e, this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.jdField_b_of_type_Long, 101);
      break;
      label318:
      if (((this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.f == 90) || (this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.f == 270)) && (this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.a.a().b() != -1) && (((lob)this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.a.a().c.get(0)).a == 2)) {
        bdll.b(null, "CliOper", "", "", "0X8004CFC", "0X8004CFC", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mfw
 * JD-Core Version:    0.7.0.1
 */