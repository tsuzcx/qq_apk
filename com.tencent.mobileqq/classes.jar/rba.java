import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.List;

class rba
{
  public long a;
  public List<Pair<Long, Long>> a;
  private boolean a;
  public long b;
  public List<Pair<Long, Long>> b;
  public long c;
  public long d;
  public long e;
  
  public rba(long paramLong)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Long = paramLong;
    if (this.jdField_a_of_type_Long <= 0L) {
      this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() >= 30) {
      return;
    }
    this.d = NetConnInfoCenter.getServerTimeMillis();
    if (this.jdField_b_of_type_Long == 0L) {
      this.jdField_b_of_type_Long = this.d;
    }
    this.e = paramLong;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    this.c = NetConnInfoCenter.getServerTimeMillis();
    if (this.jdField_a_of_type_JavaUtilList.size() >= 30) {}
    do
    {
      return;
      l3 = (this.c - this.d) / 100L;
    } while (l3 == 0L);
    long l1 = paramLong - this.e;
    long l2 = (this.c - this.jdField_a_of_type_Long) / 100L;
    long l3 = Utils.px2dp((float)(l1 / l3));
    this.jdField_a_of_type_JavaUtilList.add(new Pair(Long.valueOf(l3), Long.valueOf(l2)));
    if ((this.jdField_a_of_type_Boolean) || (paramBoolean)) {
      this.jdField_b_of_type_JavaUtilList.add(new Pair(Long.valueOf(this.c - this.d), Long.valueOf(l1)));
    }
    this.e = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rba
 * JD-Core Version:    0.7.0.1
 */