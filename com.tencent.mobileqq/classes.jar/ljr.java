import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;

public class ljr
{
  public static String a;
  public static String b;
  public static String c;
  public static String d;
  public static String e;
  public static String f;
  public static String g;
  public static String h;
  public static String i;
  public static String j;
  public static String k;
  public static String l;
  public static String m;
  public static String n;
  public static String o;
  public static String p;
  public static String q;
  public static String r;
  public static String s;
  public static String t;
  public static String u;
  public static String v;
  public static String w;
  public static String x;
  public static String y;
  public static String z;
  public byte a;
  public int a;
  @Deprecated
  lke a;
  public byte b;
  public int b;
  public byte c;
  public int c;
  public byte d;
  public int d;
  public byte e;
  public byte f;
  public byte g;
  public byte h;
  public byte i;
  public byte j;
  public byte k;
  public byte l;
  public byte m;
  public byte n;
  public byte o;
  public byte p;
  public byte q;
  public byte r;
  public byte s;
  public byte t;
  public byte u;
  public byte v;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    jdField_a_of_type_JavaLangString = "sharp/camera_angle/" + "enable";
    localStringBuilder.setLength(0);
    jdField_b_of_type_JavaLangString = "sharp/camera_angle/" + "local/" + "front";
    localStringBuilder.setLength(0);
    jdField_c_of_type_JavaLangString = "sharp/camera_angle/" + "local/" + "back";
    localStringBuilder.setLength(0);
    jdField_d_of_type_JavaLangString = "sharp/camera_angle/" + "remote/" + "front/" + "0";
    localStringBuilder.setLength(0);
    jdField_e_of_type_JavaLangString = "sharp/camera_angle/" + "remote/" + "front/" + "90";
    localStringBuilder.setLength(0);
    jdField_f_of_type_JavaLangString = "sharp/camera_angle/" + "remote/" + "front/" + "180";
    localStringBuilder.setLength(0);
    jdField_g_of_type_JavaLangString = "sharp/camera_angle/" + "remote/" + "front/" + "270";
    localStringBuilder.setLength(0);
    jdField_h_of_type_JavaLangString = "sharp/camera_angle/" + "remote/" + "back/" + "0";
    localStringBuilder.setLength(0);
    jdField_i_of_type_JavaLangString = "sharp/camera_angle/" + "remote/" + "back/" + "90";
    localStringBuilder.setLength(0);
    jdField_j_of_type_JavaLangString = "sharp/camera_angle/" + "remote/" + "back/" + "180";
    localStringBuilder.setLength(0);
    jdField_k_of_type_JavaLangString = "sharp/camera_angle/" + "remote/" + "back/" + "270";
    localStringBuilder.setLength(0);
    jdField_l_of_type_JavaLangString = "sharp/camera_angle/" + "sensor";
    localStringBuilder.setLength(0);
    jdField_m_of_type_JavaLangString = "sharp/camera_angle/" + "mini_sdk";
    localStringBuilder.setLength(0);
    jdField_n_of_type_JavaLangString = "sharp/camera_angle_landscape/" + "enable";
    localStringBuilder.setLength(0);
    jdField_o_of_type_JavaLangString = "sharp/camera_angle_landscape/" + "local/" + "front";
    localStringBuilder.setLength(0);
    jdField_p_of_type_JavaLangString = "sharp/camera_angle_landscape/" + "local/" + "back";
    localStringBuilder.setLength(0);
    jdField_q_of_type_JavaLangString = "sharp/camera_angle_landscape/" + "remote/" + "front/" + "0";
    localStringBuilder.setLength(0);
    jdField_r_of_type_JavaLangString = "sharp/camera_angle_landscape/" + "remote/" + "front/" + "90";
    localStringBuilder.setLength(0);
    jdField_s_of_type_JavaLangString = "sharp/camera_angle_landscape/" + "remote/" + "front/" + "180";
    localStringBuilder.setLength(0);
    jdField_t_of_type_JavaLangString = "sharp/camera_angle_landscape/" + "remote/" + "front/" + "270";
    localStringBuilder.setLength(0);
    jdField_u_of_type_JavaLangString = "sharp/camera_angle_landscape/" + "remote/" + "back/" + "0";
    localStringBuilder.setLength(0);
    jdField_v_of_type_JavaLangString = "sharp/camera_angle_landscape/" + "remote/" + "back/" + "90";
    localStringBuilder.setLength(0);
    w = "sharp/camera_angle_landscape/" + "remote/" + "back/" + "180";
    localStringBuilder.setLength(0);
    x = "sharp/camera_angle_landscape/" + "remote/" + "back/" + "270";
    localStringBuilder.setLength(0);
    y = "sharp/camera_angle_landscape/" + "sensor";
    localStringBuilder.setLength(0);
    z = "sharp/camera_angle_landscape/" + "mini_sdk";
    localStringBuilder.setLength(0);
  }
  
  public ljr()
  {
    this.jdField_a_of_type_Lke = null;
  }
  
  private byte a(int paramInt)
  {
    if ((paramInt < -128) || (paramInt > 127)) {
      throw new IllegalArgumentException(paramInt + " out of the range of byte");
    }
    return (byte)paramInt;
  }
  
  public boolean a(lke paramlke)
  {
    return paramlke.a(jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int) >= 1;
  }
  
  public boolean b(lke paramlke)
  {
    boolean bool2 = false;
    if (a(paramlke)) {}
    for (;;)
    {
      try
      {
        this.jdField_b_of_type_Int = paramlke.a(jdField_m_of_type_JavaLangString, this.jdField_b_of_type_Int);
        if (Build.VERSION.SDK_INT < this.jdField_b_of_type_Int) {
          continue;
        }
        this.jdField_a_of_type_Byte = a(paramlke.a(jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Byte));
        this.jdField_b_of_type_Byte = a(paramlke.a(jdField_c_of_type_JavaLangString, this.jdField_b_of_type_Byte));
        this.jdField_c_of_type_Byte = a(paramlke.a(jdField_d_of_type_JavaLangString, this.jdField_c_of_type_Byte));
        this.jdField_d_of_type_Byte = a(paramlke.a(jdField_e_of_type_JavaLangString, this.jdField_d_of_type_Byte));
        this.jdField_e_of_type_Byte = a(paramlke.a(jdField_f_of_type_JavaLangString, this.jdField_e_of_type_Byte));
        this.jdField_f_of_type_Byte = a(paramlke.a(jdField_g_of_type_JavaLangString, this.jdField_f_of_type_Byte));
        this.jdField_g_of_type_Byte = a(paramlke.a(jdField_h_of_type_JavaLangString, this.jdField_g_of_type_Byte));
        this.jdField_h_of_type_Byte = a(paramlke.a(jdField_i_of_type_JavaLangString, this.jdField_h_of_type_Byte));
        this.jdField_i_of_type_Byte = a(paramlke.a(jdField_j_of_type_JavaLangString, this.jdField_i_of_type_Byte));
        this.jdField_j_of_type_Byte = a(paramlke.a(jdField_k_of_type_JavaLangString, this.jdField_j_of_type_Byte));
        this.jdField_k_of_type_Byte = a(paramlke.a(jdField_l_of_type_JavaLangString, this.jdField_k_of_type_Byte));
        bool1 = true;
      }
      catch (Exception paramlke)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("CameraConfigParser", 2, "parse camera angle config error, reset data.", paramlke);
        this.jdField_a_of_type_Byte = 0;
        this.jdField_b_of_type_Byte = 0;
        this.jdField_c_of_type_Byte = 0;
        this.jdField_d_of_type_Byte = 0;
        this.jdField_e_of_type_Byte = 0;
        this.jdField_f_of_type_Byte = 0;
        this.jdField_g_of_type_Byte = 0;
        this.jdField_h_of_type_Byte = 0;
        this.jdField_i_of_type_Byte = 0;
        this.jdField_j_of_type_Byte = 0;
        this.jdField_k_of_type_Byte = 0;
        this.jdField_b_of_type_Int = 0;
        bool1 = bool2;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("CameraConfigParser", 2, "value_local_front:" + this.jdField_a_of_type_Byte + ", value_local_back:" + this.jdField_b_of_type_Byte + ", value_remote_front_0:" + this.jdField_c_of_type_Byte + ", value_remote_front_90:" + this.jdField_d_of_type_Byte + ", value_remote_front_180:" + this.jdField_e_of_type_Byte + ", value_remote_front_270:" + this.jdField_f_of_type_Byte + ", value_remote_back_0:" + this.jdField_g_of_type_Byte + ", value_remote_back_90:" + this.jdField_h_of_type_Byte + ", value_remote_back_180:" + this.jdField_i_of_type_Byte + ", value_remote_back_270:" + this.jdField_j_of_type_Byte + ", value_sensor:" + this.jdField_k_of_type_Byte + ", value_minisdk:" + this.jdField_b_of_type_Int);
      }
      return bool1;
      boolean bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("CameraConfigParser", 2, "ignore camera angle config: sdk version not in range, miniSdk:" + this.jdField_b_of_type_Int);
        bool1 = bool2;
        continue;
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("CameraConfigParser", 2, "camera angle config disable, return");
          bool1 = bool2;
        }
      }
    }
  }
  
  public boolean c(lke paramlke)
  {
    return paramlke.a(jdField_n_of_type_JavaLangString, this.jdField_c_of_type_Int) >= 1;
  }
  
  public boolean d(lke paramlke)
  {
    boolean bool2 = false;
    if (c(paramlke)) {}
    for (;;)
    {
      try
      {
        this.jdField_d_of_type_Int = paramlke.a(z, this.jdField_d_of_type_Int);
        if (Build.VERSION.SDK_INT < this.jdField_d_of_type_Int) {
          continue;
        }
        this.jdField_l_of_type_Byte = a(paramlke.a(jdField_o_of_type_JavaLangString, this.jdField_l_of_type_Byte));
        this.jdField_m_of_type_Byte = a(paramlke.a(jdField_p_of_type_JavaLangString, this.jdField_m_of_type_Byte));
        this.jdField_n_of_type_Byte = a(paramlke.a(jdField_q_of_type_JavaLangString, this.jdField_n_of_type_Byte));
        this.jdField_o_of_type_Byte = a(paramlke.a(jdField_r_of_type_JavaLangString, this.jdField_o_of_type_Byte));
        this.jdField_p_of_type_Byte = a(paramlke.a(jdField_s_of_type_JavaLangString, this.jdField_p_of_type_Byte));
        this.jdField_q_of_type_Byte = a(paramlke.a(jdField_t_of_type_JavaLangString, this.jdField_q_of_type_Byte));
        this.jdField_r_of_type_Byte = a(paramlke.a(jdField_u_of_type_JavaLangString, this.jdField_r_of_type_Byte));
        this.jdField_s_of_type_Byte = a(paramlke.a(jdField_v_of_type_JavaLangString, this.jdField_s_of_type_Byte));
        this.jdField_t_of_type_Byte = a(paramlke.a(w, this.jdField_t_of_type_Byte));
        this.jdField_u_of_type_Byte = a(paramlke.a(x, this.jdField_u_of_type_Byte));
        this.jdField_v_of_type_Byte = a(paramlke.a(y, this.jdField_v_of_type_Byte));
        bool1 = true;
      }
      catch (Exception paramlke)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("CameraConfigParser", 2, "parse camera landscape angle config error, reset data.", paramlke);
        this.jdField_l_of_type_Byte = 0;
        this.jdField_m_of_type_Byte = 0;
        this.jdField_n_of_type_Byte = 0;
        this.jdField_o_of_type_Byte = 0;
        this.jdField_p_of_type_Byte = 0;
        this.jdField_q_of_type_Byte = 0;
        this.jdField_r_of_type_Byte = 0;
        this.jdField_s_of_type_Byte = 0;
        this.jdField_t_of_type_Byte = 0;
        this.jdField_u_of_type_Byte = 0;
        this.jdField_v_of_type_Byte = 0;
        this.jdField_d_of_type_Int = 0;
        bool1 = bool2;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("CameraConfigParser", 2, "value_landscape_local_front:" + this.jdField_l_of_type_Byte + ", value_landscape_local_back:" + this.jdField_m_of_type_Byte + ", value_landscape_remote_front_0:" + this.jdField_n_of_type_Byte + ", value_landscape_remote_front_90:" + this.jdField_o_of_type_Byte + ", value_landscape_remote_front_180:" + this.jdField_p_of_type_Byte + ", value_landscape_remote_front_270:" + this.jdField_q_of_type_Byte + ", value_landscape_remote_back_0:" + this.jdField_r_of_type_Byte + ", value_landscape_remote_back_90:" + this.jdField_s_of_type_Byte + ", value_landscape_remote_back_180:" + this.jdField_t_of_type_Byte + ", value_landscape_remote_back_270:" + this.jdField_u_of_type_Byte + ", value_landscape_sensor:" + this.jdField_v_of_type_Byte + ", value_landscape_minisdk:" + this.jdField_d_of_type_Int);
      }
      return bool1;
      boolean bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("CameraConfigParser", 2, "ignore camera landscape angle config: sdk version not in range, miniSdk:" + this.jdField_d_of_type_Int);
        bool1 = bool2;
        continue;
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("CameraConfigParser", 2, "camera landscape angle config disable");
          bool1 = bool2;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ljr
 * JD-Core Version:    0.7.0.1
 */