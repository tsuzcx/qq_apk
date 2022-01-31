import com.tencent.av.ui.MultiVideoMembersListviewAvtivity;
import java.util.Comparator;

public class mje
  implements Comparator<lfu>
{
  public mje(MultiVideoMembersListviewAvtivity paramMultiVideoMembersListviewAvtivity) {}
  
  public int a(lfu paramlfu1, lfu paramlfu2)
  {
    if ((paramlfu2.b) && (paramlfu1.b)) {
      return paramlfu2.e - paramlfu1.e;
    }
    if ((!paramlfu2.b) && (!paramlfu1.b)) {
      return paramlfu2.e - paramlfu1.e;
    }
    if ((paramlfu2.b) && (!paramlfu1.b)) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mje
 * JD-Core Version:    0.7.0.1
 */