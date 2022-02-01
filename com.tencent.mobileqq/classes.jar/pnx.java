import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager.OpenRedPacketResultStruct;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

public class pnx
  extends pnq
  implements rac
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  @Nullable
  private String jdField_a_of_type_JavaLangString;
  private qzp jdField_a_of_type_Qzp;
  private raj jdField_a_of_type_Raj = new raj(new rag());
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  
  public pnx(@NotNull pnr parampnr, Activity paramActivity)
  {
    super(parampnr, "RIJRedPacketPopupStep");
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private boolean a(Activity paramActivity)
  {
    if ((RIJRedPacketManager.a().a()) && (!(paramActivity instanceof ReadInJoyNewFeedsActivity)))
    {
      this.jdField_a_of_type_Raj.a(this);
      this.jdField_a_of_type_Raj.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.b, this.c);
      RIJRedPacketManager.a().a();
      return true;
    }
    return false;
  }
  
  private boolean b(Activity paramActivity)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    Intent localIntent;
    String str;
    if (!(paramActivity instanceof ReadInJoyNewFeedsActivity))
    {
      localIntent = paramActivity.getIntent();
      int i = localIntent.getIntExtra("launch_from", 0);
      str = localIntent.getStringExtra("redpackid");
      if (i != 17) {
        break label218;
      }
      this.jdField_a_of_type_Raj.a(this);
      i = localIntent.getIntExtra("share_source_from_content", 5);
      int j = localIntent.getIntExtra("plat_source", 0);
      RIJRedPacketManager.OpenRedPacketResultStruct localOpenRedPacketResultStruct = (RIJRedPacketManager.OpenRedPacketResultStruct)localIntent.getParcelableExtra("key_open_red_packet_result");
      if (localOpenRedPacketResultStruct != null)
      {
        paramActivity = null;
        if (localOpenRedPacketResultStruct.jdField_a_of_type_Boolean)
        {
          paramActivity = new qzh();
          paramActivity.c = localOpenRedPacketResultStruct.d;
          paramActivity.b = localOpenRedPacketResultStruct.c;
          paramActivity.jdField_a_of_type_JavaLangString = localOpenRedPacketResultStruct.b;
        }
        this.jdField_a_of_type_Raj.a(localOpenRedPacketResultStruct.jdField_a_of_type_Long, localOpenRedPacketResultStruct.jdField_a_of_type_JavaLangString, paramActivity, localOpenRedPacketResultStruct.e, 2, j, 2);
      }
      QLog.i("RIJRedPacketPopupStep", 1, "launch from red packet tips click. share source: " + i + "\n packetId: " + str + "\n");
      localIntent.removeExtra("launch_from");
      localIntent.removeExtra("redpackid");
      bool1 = true;
    }
    label218:
    do
    {
      return bool1;
      bool1 = bool2;
    } while (TextUtils.isEmpty(str));
    this.jdField_a_of_type_Raj.a(this);
    this.jdField_a_of_type_Raj.b(str, this.jdField_a_of_type_Int, this.b, this.c);
    localIntent.removeExtra("redpackid");
    return true;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.d("RIJRedPacketPopupStep", 1, "showErrorRedPacketDialog");
    if ((a()) && (b()))
    {
      new qzu((ViewGroup)this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView(), BaseApplicationImpl.getContext().getString(2131717049), BaseApplicationImpl.getContext().getString(2131717247), paramInt1, paramInt2, this.jdField_a_of_type_JavaLangString).a(false);
      a(true);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(long paramLong, String paramString1, @Nullable qzh paramqzh, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.d("RIJRedPacketPopupStep", 1, "showOpenRedPacketDialog, rowkey = " + this.jdField_a_of_type_JavaLangString);
    ViewGroup localViewGroup;
    if (b())
    {
      localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView();
      if (paramqzh != null) {
        break label90;
      }
    }
    label90:
    for (paramString1 = new qzs(localViewGroup, paramLong, paramString2, paramString1, paramInt1, paramInt2, paramInt3, this.jdField_a_of_type_JavaLangString);; paramString1 = new qzw(localViewGroup, paramLong, paramString1, paramqzh, paramString2, paramInt1, paramInt2, paramInt3, this.jdField_a_of_type_JavaLangString))
    {
      paramString1.a(false);
      a(true);
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.d("RIJRedPacketPopupStep", 1, "showErrorRedPacketDialog, wording = " + paramString1);
    if ((a()) && (b()))
    {
      new qzu((ViewGroup)this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView(), paramString1, paramString2, paramInt1, paramInt2, this.jdField_a_of_type_JavaLangString).a(false);
      a(true);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    QLog.d("RIJRedPacketPopupStep", 1, "showRedPacketDialog, rowkey = " + paramString3);
    if ((a()) && (b()) && ((this.jdField_a_of_type_Qzp == null) || (!this.jdField_a_of_type_Qzp.a())))
    {
      this.jdField_a_of_type_Qzp = new qzp((ViewGroup)this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView(), paramString1, paramString2, this.jdField_a_of_type_Raj, paramInt1, paramInt2, paramInt3, paramString3);
      this.jdField_a_of_type_Qzp.a();
    }
    a(true);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    QLog.d("RIJRedPacketPopupStep", 1, "haveWallet = " + paramBoolean1 + " hasOpen = " + paramBoolean2);
  }
  
  public void f()
  {
    super.f();
    this.jdField_a_of_type_Raj.a();
    if (this.jdField_a_of_type_Qzp != null)
    {
      this.jdField_a_of_type_Qzp.b();
      this.jdField_a_of_type_Qzp = null;
    }
  }
  
  protected void g()
  {
    QLog.d("RIJRedPacketPopupStep", 1, "doStepFromOnResume");
    a(this.jdField_a_of_type_Boolean);
  }
  
  protected void h()
  {
    QLog.d("RIJRedPacketPopupStep", 1, "doStepFromOnShowSelf");
    if ((b()) && (this.jdField_a_of_type_AndroidAppActivity != null))
    {
      if ((b(this.jdField_a_of_type_AndroidAppActivity)) || (a(this.jdField_a_of_type_AndroidAppActivity))) {
        this.jdField_a_of_type_Boolean = true;
      }
    }
    else {
      return;
    }
    a(false);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void i()
  {
    QLog.d("RIJRedPacketPopupStep", 1, "dismissRedPacketDialog");
    if (this.jdField_a_of_type_Qzp != null) {
      this.jdField_a_of_type_Qzp.b();
    }
  }
  
  public void j()
  {
    QLog.d("RIJRedPacketPopupStep", 1, "showOtherPopupView");
    a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pnx
 * JD-Core Version:    0.7.0.1
 */