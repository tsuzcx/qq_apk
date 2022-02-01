import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class mpg
  extends mqf
{
  public mpv a;
  
  mpg(moy parammoy)
  {
    super(parammoy);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    moy localmoy = a();
    if (localmoy == null) {
      return;
    }
    mpv localmpv = this.jdField_a_of_type_Mpv;
    this.jdField_a_of_type_Mpv = new mpv(paramString1, paramString2, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    QLog.w("AVRedBag_GameSink", 1, "onGameStart, new[" + this.jdField_a_of_type_Mpv + "], last[" + localmpv + "], fromType[" + paramInt + "], isAVActivityVisible[" + localmoy.e() + "], isSelfVideoOpen[" + mpu.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface) + "]");
    if (!this.jdField_a_of_type_Mpv.jdField_b_of_type_Boolean)
    {
      if (!localmoy.e()) {
        mpt.a();
      }
      if (!mpu.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface)) {
        mpt.b();
      }
    }
    mpt.a(paramInt);
    localmoy.a(this);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString5, String paramString6, String paramString7, boolean paramBoolean, int paramInt5)
  {
    moy localmoy = a();
    if (localmoy == null) {
      return;
    }
    if (this.jdField_a_of_type_Mpv == null)
    {
      this.jdField_a_of_type_Mpv = new mpv(paramString1, paramString2, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      QLog.w("AVRedBag_GameSink", 1, "onGameEnd , mResultData is empty");
    }
    String str1 = this.jdField_a_of_type_Mpv.jdField_a_of_type_JavaLangString;
    String str2 = this.jdField_a_of_type_Mpv.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_Mpv.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Mpv.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Mpv.jdField_b_of_type_Boolean = TextUtils.equals(paramString1, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    this.jdField_a_of_type_Mpv.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_Mpv.jdField_d_of_type_JavaLangString = paramString4;
    this.jdField_a_of_type_Mpv.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Mpv.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Mpv.jdField_c_of_type_Int = paramInt3;
    this.jdField_a_of_type_Mpv.jdField_d_of_type_Int = paramInt4;
    this.jdField_a_of_type_Mpv.i = paramString5;
    this.jdField_a_of_type_Mpv.jdField_f_of_type_JavaLangString = paramString7;
    this.jdField_a_of_type_Mpv.jdField_e_of_type_JavaLangString = paramString6;
    this.jdField_a_of_type_Mpv.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Mpv.jdField_f_of_type_Int = paramInt5;
    if (this.jdField_a_of_type_Mpv.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_Mpv.jdField_e_of_type_Int = mph.a(this.jdField_a_of_type_Mpv.i, this.jdField_a_of_type_Mpv.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Mpv.jdField_f_of_type_JavaLangString);
    }
    if ((!this.jdField_a_of_type_Mpv.jdField_b_of_type_Boolean) && (paramBoolean)) {
      bctj.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), "avRedPacketFinGameSuc", true, 0L, 0L, null, "");
    }
    paramString1 = new StringBuilder().append("onGameEnd, startUin[").append(str1).append("->").append(this.jdField_a_of_type_Mpv.jdField_a_of_type_JavaLangString).append("], playUin[").append(str2).append("->").append(this.jdField_a_of_type_Mpv.jdField_b_of_type_JavaLangString).append("], mStarter[").append(this.jdField_a_of_type_Mpv.jdField_b_of_type_Boolean).append("], score[").append(this.jdField_a_of_type_Mpv.jdField_a_of_type_Int).append("/").append(this.jdField_a_of_type_Mpv.jdField_b_of_type_Int).append("], Emoji[").append(this.jdField_a_of_type_Mpv.jdField_c_of_type_Int).append("/").append(this.jdField_a_of_type_Mpv.jdField_d_of_type_Int).append("], money[").append(this.jdField_a_of_type_Mpv.i).append("], playerGetRedbagResultCode[").append(this.jdField_a_of_type_Mpv.jdField_e_of_type_JavaLangString).append("], playerGetRedbagResultState[").append(this.jdField_a_of_type_Mpv.jdField_f_of_type_JavaLangString).append("], isSucc[").append(this.jdField_a_of_type_Mpv.jdField_a_of_type_Boolean).append("], exceptionType[").append(this.jdField_a_of_type_Mpv.jdField_f_of_type_Int).append("], mRedbagErrorType[").append(this.jdField_a_of_type_Mpv.jdField_e_of_type_Int).append("], mRedbagId[").append(this.jdField_a_of_type_Mpv.jdField_c_of_type_JavaLangString).append("], mAuthKey[");
    if (paramString4 == null) {}
    for (paramInt1 = 0;; paramInt1 = paramString4.length())
    {
      QLog.w("AVRedBag_GameSink", 1, paramInt1 + "]");
      localmoy.b(this.jdField_a_of_type_Mpv);
      if ((this.jdField_a_of_type_Mpv.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Mpv.a()))
      {
        paramString1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131695135);
        mpu.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_Mpv.jdField_b_of_type_JavaLangString, 0, paramString1);
      }
      if (this.jdField_a_of_type_Mpv.jdField_b_of_type_Boolean) {
        mpt.a(this.jdField_a_of_type_Mpv.jdField_c_of_type_JavaLangString);
      }
      mpj.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      this.jdField_a_of_type_Mpv = null;
      return;
    }
  }
  
  public String toString()
  {
    return "mResultData[" + this.jdField_a_of_type_Mpv + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mpg
 * JD-Core Version:    0.7.0.1
 */