import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class pwu
  extends psk
  implements pwk
{
  private Context jdField_a_of_type_AndroidContentContext;
  public Bundle a;
  awfg jdField_a_of_type_Awfg = new pwy(this);
  awfi jdField_a_of_type_Awfi = new pwx(this);
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  private pwi jdField_a_of_type_Pwi;
  private pwo jdField_a_of_type_Pwo;
  private pwp jdField_a_of_type_Pwp = new pwv(this);
  private long jdField_b_of_type_Long;
  private QQAppInterface jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
  private WeakReference<psm> jdField_b_of_type_JavaLangRefWeakReference;
  private pwo jdField_b_of_type_Pwo;
  private pwp jdField_b_of_type_Pwp = new pww(this);
  private long c;
  private long jdField_d_of_type_Long;
  private String jdField_d_of_type_JavaLangString;
  private long jdField_e_of_type_Long;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private long jdField_f_of_type_Long;
  private String jdField_f_of_type_JavaLangString;
  private boolean jdField_f_of_type_Boolean;
  private long jdField_g_of_type_Long;
  private String jdField_g_of_type_JavaLangString;
  private boolean jdField_g_of_type_Boolean;
  private long jdField_h_of_type_Long;
  private String jdField_h_of_type_JavaLangString;
  private boolean jdField_h_of_type_Boolean;
  private long jdField_i_of_type_Long;
  private String jdField_i_of_type_JavaLangString;
  
  public pwu(Context paramContext, psm parampsm, Intent paramIntent)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(parampsm);
    this.jdField_a_of_type_AndroidOsBundle = paramIntent.getExtras();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(this.jdField_a_of_type_AndroidOsBundle);
    psj.a(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_Pwo = new pwq(paramContext, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Pwp);
    this.jdField_b_of_type_Pwo = new pwz(paramContext, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Pwp, this.jdField_d_of_type_JavaLangString);
  }
  
  private void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if ((this.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null)) {
      ((psm)this.jdField_b_of_type_JavaLangRefWeakReference.get()).a(this.jdField_a_of_type_JavaLangString, paramInt, pwl.a().a(paramString1).b(paramString2).d(paramString4).c(paramString3).e(paramString5).a(this.c).b(this.jdField_d_of_type_Long).a());
    }
  }
  
  private void a(Bundle paramBundle)
  {
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)obz.a());
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("mTaskID");
    this.jdField_e_of_type_Boolean = paramBundle.getBoolean("supportShortVideo", false);
    this.jdField_f_of_type_Boolean = paramBundle.getBoolean("shortVideoSoReady", false);
    if (!this.jdField_f_of_type_Boolean) {
      d();
    }
    this.jdField_d_of_type_JavaLangString = paramBundle.getString("arg_video_path");
    this.jdField_e_of_type_JavaLangString = paramBundle.getString("arg_video_cover");
    paramBundle.putString("mTaskID", this.jdField_a_of_type_JavaLangString);
  }
  
  private void a(pwl parampwl)
  {
    this.jdField_a_of_type_AndroidOsBundle.putString("compressPath", this.jdField_h_of_type_JavaLangString);
    a(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidOsBundle, parampwl, (psm)this.jdField_b_of_type_JavaLangRefWeakReference.get());
  }
  
  private void b(float paramFloat)
  {
    this.jdField_a_of_type_Float = (50.0F * (1.0F + paramFloat / 100.0F));
    if ((this.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null) && (!this.jdField_g_of_type_Boolean)) {
      ((psm)this.jdField_b_of_type_JavaLangRefWeakReference.get()).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Float);
    }
  }
  
  private void b(int paramInt)
  {
    QLog.d("VideoDeliverController", 1, "transitState: from " + this.jdField_a_of_type_Int + " to " + paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
      this.jdField_a_of_type_Pwo.a(this.jdField_e_of_type_JavaLangString, true);
      continue;
      c(100.0F);
      if (!this.jdField_g_of_type_Boolean)
      {
        this.jdField_b_of_type_Pwo.a(this.jdField_h_of_type_JavaLangString, true);
        continue;
        b(100.0F);
      }
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_Pwi = new pwi((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_e_of_type_Boolean, this.jdField_f_of_type_Boolean, this);
    this.jdField_a_of_type_Pwi.execute(new String[] { this.jdField_d_of_type_JavaLangString });
    this.jdField_f_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
  }
  
  private void c(float paramFloat)
  {
    this.jdField_a_of_type_Float = (50.0F * paramFloat / 100.0F);
    if ((this.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null) && (!this.jdField_g_of_type_Boolean)) {
      ((psm)this.jdField_b_of_type_JavaLangRefWeakReference.get()).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Float);
    }
  }
  
  private void c(int paramInt)
  {
    a(paramInt, null, null, null, null, null);
  }
  
  private void d()
  {
    this.jdField_e_of_type_Boolean = VideoEnvironment.c(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_f_of_type_Boolean = VideoEnvironment.e(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    if (!this.jdField_e_of_type_Boolean)
    {
      VideoEnvironment.a("ReadInJoyDeliverVideoActivity_AvCodecSo", ajjy.a(2131641827), null);
      return;
    }
    if (this.jdField_f_of_type_Boolean)
    {
      VideoEnvironment.a("ReadInJoyDeliverVideoActivity_AvCodecSo", "短视频插件ready", null);
      return;
    }
    VideoEnvironment.a("ReadInJoyDeliverVideoActivity_AvCodecSo", "短视频插件not ready", null);
    if (badq.g(null))
    {
      VideoEnvironment.a("ReadInJoyDeliverVideoActivity_AvCodecSo", ajjy.a(2131641822), null);
      ShortVideoResourceManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Awfi);
      return;
    }
    VideoEnvironment.a("ReadInJoyDeliverVideoActivity_AvCodecSo", ajjy.a(2131641820), null);
  }
  
  private void d(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = this.jdField_i_of_type_Long;
    awrn localawrn = awrn.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    String str = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localawrn.a(str, "actReadInJoyUGCVideo", bool, l1 - l2, 0L, localHashMap, "");
      return;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    c();
    b(1);
    this.jdField_i_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
  }
  
  public void a(float paramFloat)
  {
    c(paramFloat);
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2, String paramString1, String paramString2, long paramLong3)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_e_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
      this.jdField_b_of_type_Long = paramLong1;
      this.c = paramLong2;
      this.jdField_d_of_type_Long = paramLong3;
      return;
      c(1);
      continue;
      c(2);
      continue;
      c(3);
      d(1003);
      continue;
      c(4);
      d(1005);
      continue;
      this.jdField_h_of_type_JavaLangString = paramString1;
      this.jdField_i_of_type_JavaLangString = paramString2;
      b(2);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Pwo.a();
    this.jdField_b_of_type_Pwo.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pwu
 * JD-Core Version:    0.7.0.1
 */