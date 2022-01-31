import com.tencent.av.ui.MultiVideoMembersListviewAvtivity;
import java.util.Comparator;

public class mgr
  implements Comparator<ldw>
{
  public mgr(MultiVideoMembersListviewAvtivity paramMultiVideoMembersListviewAvtivity) {}
  
  public int a(ldw paramldw1, ldw paramldw2)
  {
    if ((paramldw2.b) && (paramldw1.b)) {
      return paramldw2.d - paramldw1.d;
    }
    if ((!paramldw2.b) && (!paramldw1.b)) {
      return paramldw2.d - paramldw1.d;
    }
    if ((paramldw2.b) && (!paramldw1.b)) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mgr
 * JD-Core Version:    0.7.0.1
 */