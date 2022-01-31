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

public class qip
  extends qef
  implements qif
{
  private Context jdField_a_of_type_AndroidContentContext;
  public Bundle a;
  axeq jdField_a_of_type_Axeq = new qit(this);
  axes jdField_a_of_type_Axes = new qis(this);
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  private qid jdField_a_of_type_Qid;
  private qij jdField_a_of_type_Qij;
  private qik jdField_a_of_type_Qik = new qiq(this);
  private long jdField_b_of_type_Long;
  private QQAppInterface jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
  private WeakReference<qeh> jdField_b_of_type_JavaLangRefWeakReference;
  private qij jdField_b_of_type_Qij;
  private qik jdField_b_of_type_Qik = new qir(this);
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
  
  public qip(Context paramContext, qeh paramqeh, Intent paramIntent)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramqeh);
    this.jdField_a_of_type_AndroidOsBundle = paramIntent.getExtras();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(this.jdField_a_of_type_AndroidOsBundle);
    qee.a(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_Qij = new qil(paramContext, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Qik);
    this.jdField_b_of_type_Qij = new qiu(paramContext, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Qik, this.jdField_d_of_type_JavaLangString);
  }
  
  private void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if ((this.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null)) {
      ((qeh)this.jdField_b_of_type_JavaLangRefWeakReference.get()).a(this.jdField_a_of_type_JavaLangString, paramInt, qig.a().a(paramString1).b(paramString2).d(paramString4).c(paramString3).e(paramString5).a(this.c).b(this.jdField_d_of_type_Long).a());
    }
  }
  
  private void a(Bundle paramBundle)
  {
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)onh.a());
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
  
  private void a(qig paramqig)
  {
    this.jdField_a_of_type_AndroidOsBundle.putString("compressPath", this.jdField_h_of_type_JavaLangString);
    a(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidOsBundle, paramqig, (qeh)this.jdField_b_of_type_JavaLangRefWeakReference.get());
  }
  
  private void b(float paramFloat)
  {
    this.jdField_a_of_type_Float = (50.0F * (1.0F + paramFloat / 100.0F));
    if ((this.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null) && (!this.jdField_g_of_type_Boolean)) {
      ((qeh)this.jdField_b_of_type_JavaLangRefWeakReference.get()).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Float);
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
      this.jdField_a_of_type_Qij.a(this.jdField_e_of_type_JavaLangString, true);
      continue;
      c(100.0F);
      if (!this.jdField_g_of_type_Boolean)
      {
        this.jdField_b_of_type_Qij.a(this.jdField_h_of_type_JavaLangString, true);
        continue;
        b(100.0F);
      }
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_Qid = new qid((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_e_of_type_Boolean, this.jdField_f_of_type_Boolean, this);
    this.jdField_a_of_type_Qid.execute(new String[] { this.jdField_d_of_type_JavaLangString });
    this.jdField_f_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
  }
  
  private void c(float paramFloat)
  {
    this.jdField_a_of_type_Float = (50.0F * paramFloat / 100.0F);
    if ((this.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null) && (!this.jdField_g_of_type_Boolean)) {
      ((qeh)this.jdField_b_of_type_JavaLangRefWeakReference.get()).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Float);
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
      VideoEnvironment.a("ReadInJoyDeliverVideoActivity_AvCodecSo", ajya.a(2131707623), null);
      return;
    }
    if (this.jdField_f_of_type_Boolean)
    {
      VideoEnvironment.a("ReadInJoyDeliverVideoActivity_AvCodecSo", "短视频插件ready", null);
      return;
    }
    VideoEnvironment.a("ReadInJoyDeliverVideoActivity_AvCodecSo", "短视频插件not ready", null);
    if (bbfj.g(null))
    {
      VideoEnvironment.a("ReadInJoyDeliverVideoActivity_AvCodecSo", ajya.a(2131707618), null);
      ShortVideoResourceManager.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Axes);
      return;
    }
    VideoEnvironment.a("ReadInJoyDeliverVideoActivity_AvCodecSo", ajya.a(2131707616), null);
  }
  
  private void d(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = this.jdField_i_of_type_Long;
    axrn localaxrn = axrn.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    String str = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localaxrn.a(str, "actReadInJoyUGCVideo", bool, l1 - l2, 0L, localHashMap, "");
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
    this.jdField_a_of_type_Qij.a();
    this.jdField_b_of_type_Qij.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qip
 * JD-Core Version:    0.7.0.1
 */