import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;
import java.util.Map;

public class tci
  implements tfc
{
  private tcm jdField_a_of_type_Tcm = new tck(this);
  private tcn jdField_a_of_type_Tcn;
  private final tcp jdField_a_of_type_Tcp = new tcj(this);
  private tdo jdField_a_of_type_Tdo;
  private tfc jdField_a_of_type_Tfc;
  private tfd jdField_a_of_type_Tfd;
  
  public tci() {}
  
  private tci(@NonNull Activity paramActivity)
  {
    this.jdField_a_of_type_Tfd = new tey(paramActivity);
  }
  
  public static tci a(@NonNull Activity paramActivity)
  {
    return new tci(paramActivity);
  }
  
  public static tci a(@NonNull Activity paramActivity, tfd paramtfd)
  {
    return new tci().a(paramtfd);
  }
  
  public tci a()
  {
    if (this.jdField_a_of_type_Tfd.a() == null) {
      return this;
    }
    this.jdField_a_of_type_Tfd.jdField_a_of_type_Boolean = false;
    return this;
  }
  
  public tci a(int paramInt)
  {
    Activity localActivity = this.jdField_a_of_type_Tfd.a();
    if (localActivity == null) {
      return this;
    }
    this.jdField_a_of_type_Tfd.jdField_a_of_type_JavaLangString = localActivity.getString(paramInt);
    return this;
  }
  
  public tci a(@NonNull String paramString)
  {
    this.jdField_a_of_type_Tfd.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public tci a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Tdo == null) {
      throw new IllegalStateException("Error: mShareMode is null! StoryShare should init mode() first!");
    }
    this.jdField_a_of_type_Tdo.b.put(paramString1, paramString2);
    return this;
  }
  
  public tci a(@NonNull List<int[]> paramList)
  {
    this.jdField_a_of_type_Tfd.jdField_a_of_type_JavaUtilList = paramList;
    return this;
  }
  
  public tci a(tcn paramtcn)
  {
    this.jdField_a_of_type_Tcn = paramtcn;
    return this;
  }
  
  public tci a(@NonNull tdo paramtdo)
  {
    this.jdField_a_of_type_Tdo = paramtdo;
    this.jdField_a_of_type_Tdo.a(this.jdField_a_of_type_Tfd.a());
    this.jdField_a_of_type_Tdo.jdField_a_of_type_Tcm = this.jdField_a_of_type_Tcm;
    this.jdField_a_of_type_Tfc = new tcl(this);
    return this;
  }
  
  public tci a(tfd paramtfd)
  {
    this.jdField_a_of_type_Tfd = paramtfd;
    return this;
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public boolean a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 29782)
    {
      Activity localActivity = this.jdField_a_of_type_Tfd.a();
      if ((paramInt2 == -1) && (localActivity != null)) {}
      for (;;)
      {
        try
        {
          azsq.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), (Activity)localActivity, paramInt2, paramIntent);
          if (this.jdField_a_of_type_Tcn != null) {
            this.jdField_a_of_type_Tcn.a(1);
          }
          if (this.jdField_a_of_type_Tcn != null) {
            this.jdField_a_of_type_Tcn.a();
          }
        }
        catch (Exception paramIntent)
        {
          if (this.jdField_a_of_type_Tcn == null) {
            continue;
          }
          this.jdField_a_of_type_Tcn.c(1);
          if (this.jdField_a_of_type_Tcn == null) {
            continue;
          }
          this.jdField_a_of_type_Tcn.a();
          continue;
        }
        return true;
        if (this.jdField_a_of_type_Tcn != null) {
          this.jdField_a_of_type_Tcn.d(1);
        }
        if (this.jdField_a_of_type_Tcn != null) {
          this.jdField_a_of_type_Tcn.a();
        }
      }
    }
    return false;
  }
  
  public tci b()
  {
    urk.a("StoryShare", "show(): %s", toString());
    if (this.jdField_a_of_type_Tdo == null) {
      if (this.jdField_a_of_type_Tcn != null) {
        this.jdField_a_of_type_Tcn.c(0);
      }
    }
    do
    {
      return this;
      this.jdField_a_of_type_Tfd.a(this.jdField_a_of_type_Tfc);
      if (this.jdField_a_of_type_Tcn != null) {
        this.jdField_a_of_type_Tcn.b();
      }
      this.jdField_a_of_type_Tfd.d();
    } while (this.jdField_a_of_type_Tcn == null);
    this.jdField_a_of_type_Tcn.c();
    return this;
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tci
 * JD-Core Version:    0.7.0.1
 */