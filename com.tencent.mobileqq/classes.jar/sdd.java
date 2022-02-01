import android.text.TextUtils;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;

class sdd
  implements sjr
{
  sdd(sdc paramsdc, sdj paramsdj, sdg paramsdg, sjo paramsjo) {}
  
  public void a(sjt paramsjt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "UUIDToUrlCallback Callback videoUrlInfo=" + paramsjt);
    }
    if ((this.jdField_a_of_type_Sdj != null) && (sdc.a(this.jdField_a_of_type_Sdc) == this.jdField_a_of_type_Sdj) && (paramsjt.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_Sdg.c))) {
      if (paramsjt.jdField_d_of_type_Int == 2) {
        sdc.a(this.jdField_a_of_type_Sdc).a(this.jdField_a_of_type_Sdj, 202, 108, 0, "vid2url failed, video deleted", null);
      }
    }
    label303:
    label455:
    while (!QLog.isColorLevel())
    {
      return;
      if (TextUtils.isEmpty(paramsjt.jdField_a_of_type_JavaLangString))
      {
        sdc.a(this.jdField_a_of_type_Sdc).a(this.jdField_a_of_type_Sdj, 202, 107, 0, "vid2url failed, get null", null);
        return;
      }
      Object localObject = this.jdField_a_of_type_Sdj;
      int i;
      boolean bool;
      if (paramsjt.jdField_a_of_type_Boolean)
      {
        i = 1;
        ((sdj)localObject).b = i;
        this.jdField_a_of_type_Sdg.g = paramsjt.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_Sdg.a.jdField_j_of_type_Long = this.jdField_a_of_type_Sjo.a.longValue();
        this.jdField_a_of_type_Sdg.a.jdField_e_of_type_Int = paramsjt.jdField_d_of_type_Int;
        this.jdField_a_of_type_Sdg.a.d = paramsjt.jdField_a_of_type_Boolean;
        this.jdField_a_of_type_Sdg.a.jdField_e_of_type_JavaLangString = paramsjt.c;
        this.jdField_a_of_type_Sdg.a.jdField_e_of_type_Boolean = paramsjt.jdField_b_of_type_Boolean;
        this.jdField_a_of_type_Sdg.a.jdField_f_of_type_Boolean = false;
        this.jdField_a_of_type_Sdg.a.jdField_f_of_type_JavaLangString = "";
        this.jdField_a_of_type_Sdg.a.jdField_j_of_type_JavaLangString = paramsjt.jdField_d_of_type_JavaLangString;
        localObject = this.jdField_a_of_type_Sdg.a;
        if (TextUtils.isEmpty(paramsjt.jdField_e_of_type_JavaLangString)) {
          break label455;
        }
        bool = true;
        ((rdt)localObject).jdField_h_of_type_Boolean = bool;
      }
      for (;;)
      {
        try
        {
          String str = new URL(paramsjt.jdField_a_of_type_JavaLangString).getHost();
          localObject = InnerDns.getInstance().reqDnsForIpList(str, 1006);
          rdt localrdt = this.jdField_a_of_type_Sdg.a;
          if (localObject != null) {
            continue;
          }
          i = 0;
          localrdt.r = i;
          localrdt = this.jdField_a_of_type_Sdg.a;
          if (localObject != null) {
            continue;
          }
          localObject = "";
          localrdt.i = ((String)localObject);
          this.jdField_a_of_type_Sdg.a.jdField_h_of_type_JavaLangString = str;
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("Q.readinjoy.video", 2, "doOpenVideo UUIDToUrlCallback 设置ip直通车出错", localException);
          continue;
          this.jdField_a_of_type_Sdj.a(paramsjt.jdField_b_of_type_JavaLangString, paramsjt.jdField_a_of_type_JavaLangString, 101, this.jdField_a_of_type_Sdg.d, this.jdField_a_of_type_Sdg.e, this.jdField_a_of_type_Sdg.b, paramsjt.jdField_b_of_type_Boolean, true, false, paramsjt.jdField_e_of_type_JavaLangString);
          return;
        }
        if (paramsjt.jdField_a_of_type_Int != 1) {
          continue;
        }
        this.jdField_a_of_type_Sdj.a(paramsjt.jdField_b_of_type_JavaLangString, paramsjt.jdField_a_of_type_JavaLangString, 104, this.jdField_a_of_type_Sdg.d, this.jdField_a_of_type_Sdg.e, this.jdField_a_of_type_Sdg.b, paramsjt.jdField_b_of_type_Boolean, true, false);
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
    QLog.w("Q.readinjoy.video", 2, "vid2url换回来后，当前视频已经不再播放，vid:" + paramsjt.jdField_b_of_type_JavaLangString + " url:" + paramsjt.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sdd
 * JD-Core Version:    0.7.0.1
 */