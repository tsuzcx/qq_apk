import com.tencent.av.ui.MultiVideoMembersListviewAvtivity;
import java.util.Comparator;

public class mgm
  implements Comparator<ldr>
{
  public mgm(MultiVideoMembersListviewAvtivity paramMultiVideoMembersListviewAvtivity) {}
  
  public int a(ldr paramldr1, ldr paramldr2)
  {
    if ((paramldr2.b) && (paramldr1.b)) {
      return paramldr2.d - paramldr1.d;
    }
    if ((!paramldr2.b) && (!paramldr1.b)) {
      return paramldr2.d - paramldr1.d;
    }
    if ((paramldr2.b) && (!paramldr1.b)) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mgm
 * JD-Core Version:    0.7.0.1
 */