import com.tencent.av.VideoController;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class mju
  extends lfb
{
  public mju(VideoInviteActivity paramVideoInviteActivity) {}
  
  protected void a(long paramLong, int paramInt)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.a.jdField_a_of_type_JavaLangString, 1, "onDestroyInviteUI, relationId[" + paramLong + "], seq[" + l + "]");
    }
    boolean bool = this.a.i;
    if ((bool) && (this.a.c != null) && (this.a.c.equals(String.valueOf(paramLong))))
    {
      super.a(paramLong);
      mtq.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      this.a.a(l);
      if ((bool) && (this.a.c.length() > 2) && (paramLong != 0L))
      {
        paramLong = Long.valueOf(this.a.c).longValue();
        if (!this.a.h)
        {
          this.a.h = true;
          if (paramInt != 1) {
            break label255;
          }
          this.a.a().a(l, paramLong, 7);
        }
      }
    }
    for (;;)
    {
      this.a.e = true;
      if ((!this.a.l) || (this.a.jdField_a_of_type_Mhj == null) || (this.a.f())) {
        break;
      }
      this.a.jdField_a_of_type_Mhj.a(new mjv(this));
      return;
      label255:
      if (paramInt == 2) {
        this.a.a().a(l, paramLong, 2);
      }
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mju
 * JD-Core Version:    0.7.0.1
 */