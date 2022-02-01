import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class mpm
  extends mql
{
  public mqb a;
  
  mpm(mpe parammpe)
  {
    super(parammpe);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    mpe localmpe = a();
    if (localmpe == null) {
      return;
    }
    mqb localmqb = this.jdField_a_of_type_Mqb;
    this.jdField_a_of_type_Mqb = new mqb(paramString1, paramString2, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    QLog.w("AVRedBag_GameSink", 1, "onGameStart, new[" + this.jdField_a_of_type_Mqb + "], last[" + localmqb + "], fromType[" + paramInt + "], isAVActivityVisible[" + localmpe.e() + "], isSelfVideoOpen[" + mqa.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface) + "]");
    if (!this.jdField_a_of_type_Mqb.jdField_b_of_type_Boolean)
    {
      if (!localmpe.e()) {
        mpz.a();
      }
      if (!mqa.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface)) {
        mpz.b();
      }
    }
    mpz.a(paramInt);
    localmpe.a(this);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString5, String paramString6, String paramString7, boolean paramBoolean, int paramInt5)
  {
    mpe localmpe = a();
    if (localmpe == null) {
      return;
    }
    if (this.jdField_a_of_type_Mqb == null)
    {
      this.jdField_a_of_type_Mqb = new mqb(paramString1, paramString2, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      QLog.w("AVRedBag_GameSink", 1, "onGameEnd , mResultData is empty");
    }
    String str1 = this.jdField_a_of_type_Mqb.jdField_a_of_type_JavaLangString;
    String str2 = this.jdField_a_of_type_Mqb.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_Mqb.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Mqb.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Mqb.jdField_b_of_type_Boolean = TextUtils.equals(paramString1, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    this.jdField_a_of_type_Mqb.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_Mqb.jdField_d_of_type_JavaLangString = paramString4;
    this.jdField_a_of_type_Mqb.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Mqb.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Mqb.jdField_c_of_type_Int = paramInt3;
    this.jdField_a_of_type_Mqb.jdField_d_of_type_Int = paramInt4;
    this.jdField_a_of_type_Mqb.i = paramString5;
    this.jdField_a_of_type_Mqb.jdField_f_of_type_JavaLangString = paramString7;
    this.jdField_a_of_type_Mqb.jdField_e_of_type_JavaLangString = paramString6;
    this.jdField_a_of_type_Mqb.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Mqb.jdField_f_of_type_Int = paramInt5;
    if (this.jdField_a_of_type_Mqb.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_Mqb.jdField_e_of_type_Int = mpn.a(this.jdField_a_of_type_Mqb.i, this.jdField_a_of_type_Mqb.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Mqb.jdField_f_of_type_JavaLangString);
    }
    if ((!this.jdField_a_of_type_Mqb.jdField_b_of_type_Boolean) && (paramBoolean)) {
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), "avRedPacketFinGameSuc", true, 0L, 0L, null, "");
    }
    paramString1 = new StringBuilder().append("onGameEnd, startUin[").append(str1).append("->").append(this.jdField_a_of_type_Mqb.jdField_a_of_type_JavaLangString).append("], playUin[").append(str2).append("->").append(this.jdField_a_of_type_Mqb.jdField_b_of_type_JavaLangString).append("], mStarter[").append(this.jdField_a_of_type_Mqb.jdField_b_of_type_Boolean).append("], score[").append(this.jdField_a_of_type_Mqb.jdField_a_of_type_Int).append("/").append(this.jdField_a_of_type_Mqb.jdField_b_of_type_Int).append("], Emoji[").append(this.jdField_a_of_type_Mqb.jdField_c_of_type_Int).append("/").append(this.jdField_a_of_type_Mqb.jdField_d_of_type_Int).append("], money[").append(this.jdField_a_of_type_Mqb.i).append("], playerGetRedbagResultCode[").append(this.jdField_a_of_type_Mqb.jdField_e_of_type_JavaLangString).append("], playerGetRedbagResultState[").append(this.jdField_a_of_type_Mqb.jdField_f_of_type_JavaLangString).append("], isSucc[").append(this.jdField_a_of_type_Mqb.jdField_a_of_type_Boolean).append("], exceptionType[").append(this.jdField_a_of_type_Mqb.jdField_f_of_type_Int).append("], mRedbagErrorType[").append(this.jdField_a_of_type_Mqb.jdField_e_of_type_Int).append("], mRedbagId[").append(this.jdField_a_of_type_Mqb.jdField_c_of_type_JavaLangString).append("], mAuthKey[");
    if (paramString4 == null) {}
    for (paramInt1 = 0;; paramInt1 = paramString4.length())
    {
      QLog.w("AVRedBag_GameSink", 1, paramInt1 + "]");
      localmpe.b(this.jdField_a_of_type_Mqb);
      if ((this.jdField_a_of_type_Mqb.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Mqb.a()))
      {
        paramString1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131695317);
        mqa.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_Mqb.jdField_b_of_type_JavaLangString, 0, paramString1);
      }
      if (this.jdField_a_of_type_Mqb.jdField_b_of_type_Boolean) {
        mpz.a(this.jdField_a_of_type_Mqb.jdField_c_of_type_JavaLangString);
      }
      mpp.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      this.jdField_a_of_type_Mqb = null;
      return;
    }
  }
  
  public String toString()
  {
    return "mResultData[" + this.jdField_a_of_type_Mqb + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mpm
 * JD-Core Version:    0.7.0.1
 */