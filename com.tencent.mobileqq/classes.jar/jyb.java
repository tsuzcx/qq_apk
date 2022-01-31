import android.content.Intent;
import com.tencent.av.ui.MultiVideoEnterPageActivity;
import com.tencent.av.ui.MultiVideoMembersListviewAvtivity;
import com.tencent.av.utils.MultiVideoMembersClickListener;
import com.tencent.qphone.base.util.QLog;

public class jyb
  implements MultiVideoMembersClickListener
{
  public jyb(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity) {}
  
  private void b()
  {
    Intent localIntent = new Intent(this.a.getApplicationContext(), MultiVideoMembersListviewAvtivity.class);
    localIntent.putExtra("uinType", this.a.b);
    localIntent.putExtra("RelationUin", String.valueOf(this.a.jdField_a_of_type_Long));
    localIntent.putExtra("needDataSimple", 1);
    this.a.startActivity(localIntent);
  }
  
  public void a() {}
  
  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "MultiVideoMembersClickListener , Uin = " + paramLong + " , videoScr = " + paramInt1 + " , isNeedRequest " + paramBoolean + " , positon = " + paramInt2);
    }
    if ((paramInt2 == 17) && (paramBoolean)) {
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jyb
 * JD-Core Version:    0.7.0.1
 */