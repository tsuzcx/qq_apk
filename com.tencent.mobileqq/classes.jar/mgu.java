import com.tencent.av.ui.MultiVideoMembersListviewAvtivity;
import com.tencent.qphone.base.util.QLog;

public class mgu
  extends lfg
{
  public mgu(MultiVideoMembersListviewAvtivity paramMultiVideoMembersListviewAvtivity) {}
  
  protected void a(long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    if ((!this.a.jdField_a_of_type_Boolean) && (this.a.jdField_a_of_type_Mgv != null)) {
      this.a.jdField_a_of_type_Mgv.notifyDataSetChanged();
    }
  }
  
  protected void a(long paramLong1, long paramLong2, long paramLong3, int paramInt, boolean paramBoolean)
  {
    if ((!this.a.jdField_a_of_type_Boolean) && (this.a.jdField_a_of_type_Mgv != null)) {
      this.a.jdField_a_of_type_Mgv.notifyDataSetChanged();
    }
  }
  
  protected void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    super.a(paramLong1, paramLong2, paramBoolean);
    if (!this.a.jdField_a_of_type_Boolean)
    {
      if (this.a.jdField_a_of_type_Mgv != null) {
        this.a.jdField_a_of_type_Mgv.notifyDataSetChanged();
      }
      this.a.c();
    }
  }
  
  protected void a(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramLong1, paramLong2, paramBoolean1, paramBoolean2);
    if (!this.a.jdField_a_of_type_Boolean)
    {
      if (this.a.jdField_a_of_type_Mgv != null) {
        this.a.jdField_a_of_type_Mgv.notifyDataSetChanged();
      }
      this.a.c();
    }
  }
  
  protected void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!this.a.jdField_a_of_type_Boolean) && (this.a.jdField_a_of_type_Mgv != null)) {
      this.a.jdField_a_of_type_Mgv.notifyDataSetChanged();
    }
  }
  
  protected void c(long paramLong1, long paramLong2)
  {
    if ((!this.a.jdField_a_of_type_Boolean) && (this.a.jdField_a_of_type_Mgv != null)) {
      this.a.jdField_a_of_type_Mgv.notifyDataSetChanged();
    }
  }
  
  protected void d(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoMembersListviewAvtivity", 2, "onCloseMemberListActivity --> RelationId = " + paramLong + "mRelationUin = " + this.a.jdField_a_of_type_Long);
    }
    if (paramLong == this.a.jdField_a_of_type_Long) {
      MultiVideoMembersListviewAvtivity.a(this.a);
    }
    super.d(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mgu
 * JD-Core Version:    0.7.0.1
 */