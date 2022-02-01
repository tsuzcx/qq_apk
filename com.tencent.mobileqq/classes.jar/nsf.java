import android.os.SystemClock;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/officialaccount/OfficialAccountReporter;", "", "()V", "Reporter", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class nsf
{
  private static int jdField_a_of_type_Int;
  private static long jdField_a_of_type_Long;
  private static final HashMap<Integer, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static final HashSet<Integer> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  public static final nsg a;
  private static int jdField_b_of_type_Int;
  private static long jdField_b_of_type_Long;
  private static long c;
  private static long d;
  private static long e;
  
  static
  {
    jdField_a_of_type_Nsg = new nsg(null);
    QLog.e("OfficialAccountReporter", 2, "OfficialAccountReporter.init: false");
    UserAction.registerTunnel(new TunnelInfo("00000KCQ7Y3ITP3Z"));
    c = SystemClock.elapsedRealtime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nsf
 * JD-Core Version:    0.7.0.1
 */