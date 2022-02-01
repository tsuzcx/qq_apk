import android.text.TextUtils;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;

class rvz
  implements sct
{
  rvz(rvy paramrvy, rwf paramrwf, rwc paramrwc, scq paramscq) {}
  
  public void a(scv paramscv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "UUIDToUrlCallback Callback videoUrlInfo=" + paramscv);
    }
    if ((this.jdField_a_of_type_Rwf != null) && (rvy.a(this.jdField_a_of_type_Rvy) == this.jdField_a_of_type_Rwf) && (paramscv.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_Rwc.c))) {
      if (paramscv.jdField_d_of_type_Int == 2) {
        rvy.a(this.jdField_a_of_type_Rvy).a(this.jdField_a_of_type_Rwf, 202, 108, 0, "vid2url failed, video deleted", null);
      }
    }
    label303:
    label455:
    while (!QLog.isColorLevel())
    {
      return;
      if (TextUtils.isEmpty(paramscv.jdField_a_of_type_JavaLangString))
      {
        rvy.a(this.jdField_a_of_type_Rvy).a(this.jdField_a_of_type_Rwf, 202, 107, 0, "vid2url failed, get null", null);
        return;
      }
      Object localObject = this.jdField_a_of_type_Rwf;
      int i;
      boolean bool;
      if (paramscv.jdField_a_of_type_Boolean)
      {
        i = 1;
        ((rwf)localObject).b = i;
        this.jdField_a_of_type_Rwc.g = paramscv.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_Rwc.a.jdField_j_of_type_Long = this.jdField_a_of_type_Scq.a.longValue();
        this.jdField_a_of_type_Rwc.a.jdField_e_of_type_Int = paramscv.jdField_d_of_type_Int;
        this.jdField_a_of_type_Rwc.a.d = paramscv.jdField_a_of_type_Boolean;
        this.jdField_a_of_type_Rwc.a.jdField_e_of_type_JavaLangString = paramscv.c;
        this.jdField_a_of_type_Rwc.a.jdField_e_of_type_Boolean = paramscv.jdField_b_of_type_Boolean;
        this.jdField_a_of_type_Rwc.a.jdField_f_of_type_Boolean = false;
        this.jdField_a_of_type_Rwc.a.jdField_f_of_type_JavaLangString = "";
        this.jdField_a_of_type_Rwc.a.jdField_j_of_type_JavaLangString = paramscv.jdField_d_of_type_JavaLangString;
        localObject = this.jdField_a_of_type_Rwc.a;
        if (TextUtils.isEmpty(paramscv.jdField_e_of_type_JavaLangString)) {
          break label455;
        }
        bool = true;
        ((qwv)localObject).jdField_h_of_type_Boolean = bool;
      }
      for (;;)
      {
        try
        {
          String str = new URL(paramscv.jdField_a_of_type_JavaLangString).getHost();
          localObject = InnerDns.getInstance().reqDnsForIpList(str, 1006);
          qwv localqwv = this.jdField_a_of_type_Rwc.a;
          if (localObject != null) {
            continue;
          }
          i = 0;
          localqwv.r = i;
          localqwv = this.jdField_a_of_type_Rwc.a;
          if (localObject != null) {
            continue;
          }
          localObject = "";
          localqwv.i = ((String)localObject);
          this.jdField_a_of_type_Rwc.a.jdField_h_of_type_JavaLangString = str;
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("Q.readinjoy.video", 2, "doOpenVideo UUIDToUrlCallback 设置ip直通车出错", localException);
          continue;
          this.jdField_a_of_type_Rwf.a(paramscv.jdField_b_of_type_JavaLangString, paramscv.jdField_a_of_type_JavaLangString, 101, this.jdField_a_of_type_Rwc.d, this.jdField_a_of_type_Rwc.e, this.jdField_a_of_type_Rwc.b, paramscv.jdField_b_of_type_Boolean, true, false, paramscv.jdField_e_of_type_JavaLangString);
          return;
        }
        if (paramscv.jdField_a_of_type_Int != 1) {
          continue;
        }
        this.jdField_a_of_type_Rwf.a(paramscv.jdField_b_of_type_JavaLangString, paramscv.jdField_a_of_type_JavaLangString, 104, this.jdField_a_of_type_Rwc.d, this.jdField_a_of_type_Rwc.e, this.jdField_a_of_type_Rwc.b, paramscv.jdField_b_of_type_Boolean, true, false);
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
    QLog.w("Q.readinjoy.video", 2, "vid2url换回来后，当前视频已经不再播放，vid:" + paramscv.jdField_b_of_type_JavaLangString + " url:" + paramscv.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rvz
 * JD-Core Version:    0.7.0.1
 */