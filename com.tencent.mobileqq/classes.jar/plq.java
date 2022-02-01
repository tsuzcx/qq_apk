import android.widget.ListAdapter;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;

public class plq
{
  static int jdField_a_of_type_Int = -1;
  static long jdField_a_of_type_Long;
  static int jdField_b_of_type_Int = -1;
  static long jdField_b_of_type_Long;
  static int c;
  
  public static int a()
  {
    return c;
  }
  
  static void a(AbsListView paramAbsListView)
  {
    pls localpls = new pls();
    int i = paramAbsListView.getLastVisiblePosition();
    int j = ((ListAdapter)paramAbsListView.getAdapter()).getCount();
    localpls.jdField_a_of_type_Int = b();
    localpls.jdField_b_of_type_Int = Math.abs(jdField_b_of_type_Int - jdField_a_of_type_Int);
    localpls.jdField_a_of_type_Long = (jdField_b_of_type_Long - jdField_a_of_type_Long);
    localpls.c = (j - i);
    localpls.jdField_b_of_type_Long = jdField_b_of_type_Long;
    localpls.d = j;
    plr.a(localpls);
  }
  
  public static void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramAbsListView == null) || (paramAbsListView.getChildCount() == 0) || (paramAbsListView.getAdapter() == null)) {}
    do
    {
      do
      {
        return;
        b(paramAbsListView, paramInt);
      } while ((plr.jdField_a_of_type_Long < 0L) || (plr.jdField_b_of_type_Long < 0L));
      switch (paramInt)
      {
      default: 
        return;
      }
    } while ((jdField_b_of_type_Int >= 0) || (jdField_b_of_type_Long >= 0L));
    jdField_b_of_type_Int = paramAbsListView.getFirstVisiblePosition();
    jdField_b_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    a(paramAbsListView);
    return;
    jdField_a_of_type_Int = paramAbsListView.getFirstVisiblePosition();
    jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    jdField_b_of_type_Int = -1;
    jdField_b_of_type_Long = -1L;
  }
  
  static int b()
  {
    if (jdField_a_of_type_Int > jdField_b_of_type_Int) {
      return 0;
    }
    return 1;
  }
  
  private static void b(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt != 0) {
      return;
    }
    c = paramAbsListView.getFirstVisiblePosition() - ((ListView)paramAbsListView).getHeaderViewsCount();
    if (c < 0) {
      c = 0;
    }
    QLog.d("ReadinjoySPEventReport", 2, new Object[] { "[onScrollStateChanged] record firstItemPos : ", Integer.valueOf(c) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     plq
 * JD-Core Version:    0.7.0.1
 */