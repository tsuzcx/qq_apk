import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class msb
  extends mta
{
  public msq a;
  
  msb(mrt parammrt)
  {
    super(parammrt);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    mrt localmrt = a();
    if (localmrt == null) {
      return;
    }
    msq localmsq = this.jdField_a_of_type_Msq;
    this.jdField_a_of_type_Msq = new msq(paramString1, paramString2, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    QLog.w("AVRedBag_GameSink", 1, "onGameStart, new[" + this.jdField_a_of_type_Msq + "], last[" + localmsq + "], fromType[" + paramInt + "], isAVActivityVisible[" + localmrt.e() + "], isSelfVideoOpen[" + msp.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface) + "]");
    if (!this.jdField_a_of_type_Msq.jdField_b_of_type_Boolean)
    {
      if (!localmrt.e()) {
        mso.a();
      }
      if (!msp.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface)) {
        mso.b();
      }
    }
    mso.a(paramInt);
    localmrt.a(this);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString5, String paramString6, String paramString7, boolean paramBoolean, int paramInt5)
  {
    mrt localmrt = a();
    if (localmrt == null) {
      return;
    }
    if (this.jdField_a_of_type_Msq == null)
    {
      this.jdField_a_of_type_Msq = new msq(paramString1, paramString2, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      QLog.w("AVRedBag_GameSink", 1, "onGameEnd , mResultData is empty");
    }
    String str1 = this.jdField_a_of_type_Msq.jdField_a_of_type_JavaLangString;
    String str2 = this.jdField_a_of_type_Msq.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_Msq.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Msq.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Msq.jdField_b_of_type_Boolean = TextUtils.equals(paramString1, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    this.jdField_a_of_type_Msq.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_Msq.jdField_d_of_type_JavaLangString = paramString4;
    this.jdField_a_of_type_Msq.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Msq.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Msq.jdField_c_of_type_Int = paramInt3;
    this.jdField_a_of_type_Msq.jdField_d_of_type_Int = paramInt4;
    this.jdField_a_of_type_Msq.i = paramString5;
    this.jdField_a_of_type_Msq.jdField_f_of_type_JavaLangString = paramString7;
    this.jdField_a_of_type_Msq.jdField_e_of_type_JavaLangString = paramString6;
    this.jdField_a_of_type_Msq.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Msq.jdField_f_of_type_Int = paramInt5;
    if (this.jdField_a_of_type_Msq.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_Msq.jdField_e_of_type_Int = msc.a(this.jdField_a_of_type_Msq.i, this.jdField_a_of_type_Msq.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Msq.jdField_f_of_type_JavaLangString);
    }
    if ((!this.jdField_a_of_type_Msq.jdField_b_of_type_Boolean) && (paramBoolean)) {
      azri.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), "avRedPacketFinGameSuc", true, 0L, 0L, null, "");
    }
    paramString1 = new StringBuilder().append("onGameEnd, startUin[").append(str1).append("->").append(this.jdField_a_of_type_Msq.jdField_a_of_type_JavaLangString).append("], playUin[").append(str2).append("->").append(this.jdField_a_of_type_Msq.jdField_b_of_type_JavaLangString).append("], mStarter[").append(this.jdField_a_of_type_Msq.jdField_b_of_type_Boolean).append("], score[").append(this.jdField_a_of_type_Msq.jdField_a_of_type_Int).append("/").append(this.jdField_a_of_type_Msq.jdField_b_of_type_Int).append("], Emoji[").append(this.jdField_a_of_type_Msq.jdField_c_of_type_Int).append("/").append(this.jdField_a_of_type_Msq.jdField_d_of_type_Int).append("], money[").append(this.jdField_a_of_type_Msq.i).append("], playerGetRedbagResultCode[").append(this.jdField_a_of_type_Msq.jdField_e_of_type_JavaLangString).append("], playerGetRedbagResultState[").append(this.jdField_a_of_type_Msq.jdField_f_of_type_JavaLangString).append("], isSucc[").append(this.jdField_a_of_type_Msq.jdField_a_of_type_Boolean).append("], exceptionType[").append(this.jdField_a_of_type_Msq.jdField_f_of_type_Int).append("], mRedbagErrorType[").append(this.jdField_a_of_type_Msq.jdField_e_of_type_Int).append("], mRedbagId[").append(this.jdField_a_of_type_Msq.jdField_c_of_type_JavaLangString).append("], mAuthKey[");
    if (paramString4 == null) {}
    for (paramInt1 = 0;; paramInt1 = paramString4.length())
    {
      QLog.w("AVRedBag_GameSink", 1, paramInt1 + "]");
      localmrt.b(this.jdField_a_of_type_Msq);
      if ((this.jdField_a_of_type_Msq.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Msq.a()))
      {
        paramString1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131696255);
        msp.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_Msq.jdField_b_of_type_JavaLangString, 0, paramString1);
      }
      if (this.jdField_a_of_type_Msq.jdField_b_of_type_Boolean) {
        mso.a(this.jdField_a_of_type_Msq.jdField_c_of_type_JavaLangString);
      }
      mse.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      this.jdField_a_of_type_Msq = null;
      return;
    }
  }
  
  public String toString()
  {
    return "mResultData[" + this.jdField_a_of_type_Msq + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     msb
 * JD-Core Version:    0.7.0.1
 */