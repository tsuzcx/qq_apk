import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.mobileqq.utils.AudioHelper;

public abstract class mlg
{
  protected int a;
  protected long a;
  public final VideoInviteActivity a;
  protected int b;
  protected long b;
  protected int c;
  protected long c;
  
  public mlg(VideoInviteActivity paramVideoInviteActivity)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity = paramVideoInviteActivity;
    this.jdField_a_of_type_Long = AudioHelper.b();
    this.jdField_b_of_type_Int = mvd.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity);
    this.jdField_b_of_type_Int = mvd.b(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity);
  }
  
  public void BtnOnClick(View paramView) {}
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Resources a()
  {
    return this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.getResources();
  }
  
  public <T extends View> T a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.findViewById(paramInt);
  }
  
  public String a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.getString(paramInt);
  }
  
  public void a() {}
  
  public void a(Context paramContext, String paramString, Intent paramIntent) {}
  
  protected void a(String paramString)
  {
    bdll.b(null, "CliOper", "", "", paramString, paramString, 0, 0, Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.d), Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.h), Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.i), "");
  }
  
  public void a(mlg parammlg)
  {
    if (parammlg != null)
    {
      this.jdField_b_of_type_Long = parammlg.jdField_b_of_type_Long;
      this.c = parammlg.c;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_b_of_type_Long = SystemClock.elapsedRealtime();
      return;
    }
    this.c = SystemClock.elapsedRealtime();
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
  
  public void f() {}
  
  public void g() {}
  
  public void h() {}
  
  public void i() {}
  
  public void j() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mlg
 * JD-Core Version:    0.7.0.1
 */