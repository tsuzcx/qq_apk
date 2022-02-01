import android.text.TextUtils;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;

class sph
  implements sxa
{
  sph(spg paramspg, spn paramspn, spk paramspk, swx paramswx) {}
  
  public void a(sxc paramsxc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "UUIDToUrlCallback Callback videoUrlInfo=" + paramsxc);
    }
    if ((this.jdField_a_of_type_Spn != null) && (spg.a(this.jdField_a_of_type_Spg) == this.jdField_a_of_type_Spn) && (paramsxc.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_Spk.c))) {
      if (paramsxc.jdField_d_of_type_Int == 2) {
        spg.a(this.jdField_a_of_type_Spg).a(this.jdField_a_of_type_Spn, 202, 108, 0, "vid2url failed, video deleted", null);
      }
    }
    label303:
    label455:
    while (!QLog.isColorLevel())
    {
      return;
      if (TextUtils.isEmpty(paramsxc.jdField_a_of_type_JavaLangString))
      {
        spg.a(this.jdField_a_of_type_Spg).a(this.jdField_a_of_type_Spn, 202, 107, 0, "vid2url failed, get null", null);
        return;
      }
      Object localObject = this.jdField_a_of_type_Spn;
      int i;
      boolean bool;
      if (paramsxc.jdField_a_of_type_Boolean)
      {
        i = 1;
        ((spn)localObject).b = i;
        this.jdField_a_of_type_Spk.g = paramsxc.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_Spk.a.jdField_j_of_type_Long = this.jdField_a_of_type_Swx.a.longValue();
        this.jdField_a_of_type_Spk.a.jdField_e_of_type_Int = paramsxc.jdField_d_of_type_Int;
        this.jdField_a_of_type_Spk.a.d = paramsxc.jdField_a_of_type_Boolean;
        this.jdField_a_of_type_Spk.a.jdField_e_of_type_JavaLangString = paramsxc.c;
        this.jdField_a_of_type_Spk.a.jdField_e_of_type_Boolean = paramsxc.jdField_b_of_type_Boolean;
        this.jdField_a_of_type_Spk.a.jdField_f_of_type_Boolean = false;
        this.jdField_a_of_type_Spk.a.jdField_f_of_type_JavaLangString = "";
        this.jdField_a_of_type_Spk.a.jdField_j_of_type_JavaLangString = paramsxc.jdField_d_of_type_JavaLangString;
        localObject = this.jdField_a_of_type_Spk.a;
        if (TextUtils.isEmpty(paramsxc.jdField_e_of_type_JavaLangString)) {
          break label455;
        }
        bool = true;
        ((rqa)localObject).jdField_h_of_type_Boolean = bool;
      }
      for (;;)
      {
        try
        {
          String str = new URL(paramsxc.jdField_a_of_type_JavaLangString).getHost();
          localObject = InnerDns.getInstance().reqDnsForIpList(str, 1006);
          rqa localrqa = this.jdField_a_of_type_Spk.a;
          if (localObject != null) {
            continue;
          }
          i = 0;
          localrqa.r = i;
          localrqa = this.jdField_a_of_type_Spk.a;
          if (localObject != null) {
            continue;
          }
          localObject = "";
          localrqa.i = ((String)localObject);
          this.jdField_a_of_type_Spk.a.jdField_h_of_type_JavaLangString = str;
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("Q.readinjoy.video", 2, "doOpenVideo UUIDToUrlCallback 设置ip直通车出错", localException);
          continue;
          this.jdField_a_of_type_Spn.a(paramsxc.jdField_b_of_type_JavaLangString, paramsxc.jdField_a_of_type_JavaLangString, 101, this.jdField_a_of_type_Spk.d, this.jdField_a_of_type_Spk.e, this.jdField_a_of_type_Spk.b, paramsxc.jdField_b_of_type_Boolean, true, false, paramsxc.jdField_e_of_type_JavaLangString);
          return;
        }
        if (paramsxc.jdField_a_of_type_Int != 1) {
          continue;
        }
        this.jdField_a_of_type_Spn.a(paramsxc.jdField_b_of_type_JavaLangString, paramsxc.jdField_a_of_type_JavaLangString, 104, this.jdField_a_of_type_Spk.d, this.jdField_a_of_type_Spk.e, this.jdField_a_of_type_Spk.b, paramsxc.jdField_b_of_type_Boolean, true, false);
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
    QLog.w("Q.readinjoy.video", 2, "vid2url换回来后，当前视频已经不再播放，vid:" + paramsxc.jdField_b_of_type_JavaLangString + " url:" + paramsxc.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sph
 * JD-Core Version:    0.7.0.1
 */