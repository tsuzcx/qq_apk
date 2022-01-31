import com.tencent.av.ui.MultiVideoMembersListviewAvtivity;
import java.util.Comparator;

public class lvz
  implements Comparator<kth>
{
  public lvz(MultiVideoMembersListviewAvtivity paramMultiVideoMembersListviewAvtivity) {}
  
  public int a(kth paramkth1, kth paramkth2)
  {
    if ((paramkth2.b) && (paramkth1.b)) {
      return paramkth2.d - paramkth1.d;
    }
    if ((!paramkth2.b) && (!paramkth1.b)) {
      return paramkth2.d - paramkth1.d;
    }
    if ((paramkth2.b) && (!paramkth1.b)) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lvz
 * JD-Core Version:    0.7.0.1
 */