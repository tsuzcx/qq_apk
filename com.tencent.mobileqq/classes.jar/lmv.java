import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.GaInviteActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class lmv
  extends ldy
{
  public lmv(GaInviteActivity paramGaInviteActivity) {}
  
  protected void a()
  {
    super.a();
    if (this.a.jdField_a_of_type_Boolean) {
      this.a.a("onServiceConnected");
    }
  }
  
  protected void a(long paramLong, int paramInt)
  {
    if ((this.a.jdField_a_of_type_Long == paramLong) || (0L == paramLong)) {
      this.a.f();
    }
  }
  
  protected void a(long paramLong, String paramString)
  {
    if ((this.a.jdField_a_of_type_Long == paramLong) && (this.a.c.equals(paramString))) {
      this.a.finish();
    }
  }
  
  protected void a(long paramLong, ArrayList<lco> paramArrayList, int paramInt1, int paramInt2)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      if (String.valueOf(((lco)paramArrayList.next()).jdField_a_of_type_Long).equalsIgnoreCase(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount())) {
        this.a.finish();
      }
    }
  }
  
  protected void b(long paramLong1, long paramLong2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_b_of_type_JavaLangString + ".troopgroup_vedio.invite", 2, "groupId:" + paramLong1 + ", memUin:" + paramLong2 + ",invitedId:" + paramString + ", mInviterUin:" + this.a.jdField_b_of_type_Long + ", mGroupId:" + this.a.jdField_a_of_type_Long);
    }
    if ((paramLong2 == this.a.jdField_b_of_type_Long) && (paramLong1 == this.a.jdField_a_of_type_Long)) {
      this.a.finish();
    }
  }
  
  protected void d(long paramLong)
  {
    if (this.a.jdField_a_of_type_Long != paramLong) {
      this.a.a(-1035L);
    }
    this.a.finish();
  }
  
  protected void e(long paramLong)
  {
    if (this.a.jdField_a_of_type_Long == paramLong) {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lmv
 * JD-Core Version:    0.7.0.1
 */