import android.text.TextUtils;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;

class sev
  implements slp
{
  sev(seu paramseu, sfb paramsfb, sey paramsey, slm paramslm) {}
  
  public void a(slr paramslr)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "UUIDToUrlCallback Callback videoUrlInfo=" + paramslr);
    }
    if ((this.jdField_a_of_type_Sfb != null) && (seu.a(this.jdField_a_of_type_Seu) == this.jdField_a_of_type_Sfb) && (paramslr.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_Sey.c))) {
      if (paramslr.jdField_d_of_type_Int == 2) {
        seu.a(this.jdField_a_of_type_Seu).a(this.jdField_a_of_type_Sfb, 202, 108, 0, "vid2url failed, video deleted", null);
      }
    }
    label303:
    label455:
    while (!QLog.isColorLevel())
    {
      return;
      if (TextUtils.isEmpty(paramslr.jdField_a_of_type_JavaLangString))
      {
        seu.a(this.jdField_a_of_type_Seu).a(this.jdField_a_of_type_Sfb, 202, 107, 0, "vid2url failed, get null", null);
        return;
      }
      Object localObject = this.jdField_a_of_type_Sfb;
      int i;
      boolean bool;
      if (paramslr.jdField_a_of_type_Boolean)
      {
        i = 1;
        ((sfb)localObject).b = i;
        this.jdField_a_of_type_Sey.g = paramslr.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_Sey.a.jdField_j_of_type_Long = this.jdField_a_of_type_Slm.a.longValue();
        this.jdField_a_of_type_Sey.a.jdField_e_of_type_Int = paramslr.jdField_d_of_type_Int;
        this.jdField_a_of_type_Sey.a.d = paramslr.jdField_a_of_type_Boolean;
        this.jdField_a_of_type_Sey.a.jdField_e_of_type_JavaLangString = paramslr.c;
        this.jdField_a_of_type_Sey.a.jdField_e_of_type_Boolean = paramslr.jdField_b_of_type_Boolean;
        this.jdField_a_of_type_Sey.a.jdField_f_of_type_Boolean = false;
        this.jdField_a_of_type_Sey.a.jdField_f_of_type_JavaLangString = "";
        this.jdField_a_of_type_Sey.a.jdField_j_of_type_JavaLangString = paramslr.jdField_d_of_type_JavaLangString;
        localObject = this.jdField_a_of_type_Sey.a;
        if (TextUtils.isEmpty(paramslr.jdField_e_of_type_JavaLangString)) {
          break label455;
        }
        bool = true;
        ((rgc)localObject).jdField_h_of_type_Boolean = bool;
      }
      for (;;)
      {
        try
        {
          String str = new URL(paramslr.jdField_a_of_type_JavaLangString).getHost();
          localObject = InnerDns.getInstance().reqDnsForIpList(str, 1006);
          rgc localrgc = this.jdField_a_of_type_Sey.a;
          if (localObject != null) {
            continue;
          }
          i = 0;
          localrgc.r = i;
          localrgc = this.jdField_a_of_type_Sey.a;
          if (localObject != null) {
            continue;
          }
          localObject = "";
          localrgc.i = ((String)localObject);
          this.jdField_a_of_type_Sey.a.jdField_h_of_type_JavaLangString = str;
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("Q.readinjoy.video", 2, "doOpenVideo UUIDToUrlCallback 设置ip直通车出错", localException);
          continue;
          this.jdField_a_of_type_Sfb.a(paramslr.jdField_b_of_type_JavaLangString, paramslr.jdField_a_of_type_JavaLangString, 101, this.jdField_a_of_type_Sey.d, this.jdField_a_of_type_Sey.e, this.jdField_a_of_type_Sey.b, paramslr.jdField_b_of_type_Boolean, true, false, paramslr.jdField_e_of_type_JavaLangString);
          return;
        }
        if (paramslr.jdField_a_of_type_Int != 1) {
          continue;
        }
        this.jdField_a_of_type_Sfb.a(paramslr.jdField_b_of_type_JavaLangString, paramslr.jdField_a_of_type_JavaLangString, 104, this.jdField_a_of_type_Sey.d, this.jdField_a_of_type_Sey.e, this.jdField_a_of_type_Sey.b, paramslr.jdField_b_of_type_Boolean, true, false);
        return;
        i = 0;
        break;
        bool = false;
        break label303;
        i = ((ArrayList)localObject).size();
        continue;
        localObject = ((ArrayList)localObject).toString();
      }
    }
    QLog.w("Q.readinjoy.video", 2, "vid2url换回来后，当前视频已经不再播放，vid:" + paramslr.jdField_b_of_type_JavaLangString + " url:" + paramslr.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sev
 * JD-Core Version:    0.7.0.1
 */