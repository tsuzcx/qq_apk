import android.content.Intent;
import android.os.SystemClock;

public class lvy
{
  static volatile lvy a;
  public long A;
  public long B;
  public long C;
  public long D;
  public long E;
  public long F;
  public long G;
  public long H;
  public long I;
  public long J;
  public long K;
  public long L;
  public long M;
  public long N;
  public long O;
  public long P;
  public long Q;
  public long R;
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public long c;
  public boolean c;
  public long d;
  public boolean d;
  public long e;
  public boolean e;
  public long f;
  public boolean f;
  public long g;
  public boolean g;
  public long h;
  public boolean h;
  public long i;
  public boolean i;
  public long j;
  public boolean j;
  public long k;
  public boolean k;
  public long l;
  public boolean l;
  public long m;
  public boolean m;
  public long n;
  public boolean n;
  public long o;
  public boolean o;
  public long p;
  public boolean p;
  public long q;
  public long r;
  public long s;
  public long t;
  public long u;
  public long v;
  public long w;
  public long x;
  public long y;
  public long z;
  
  private lvy()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public static lvy a()
  {
    if (jdField_a_of_type_Lvy == null) {}
    try
    {
      if (jdField_a_of_type_Lvy == null) {
        jdField_a_of_type_Lvy = new lvy();
      }
      return jdField_a_of_type_Lvy;
    }
    finally {}
  }
  
  public void a()
  {
    this.jdField_p_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_f_of_type_Long = 0L;
    this.jdField_g_of_type_Long = 0L;
    this.jdField_h_of_type_Long = 0L;
    this.jdField_i_of_type_Long = 0L;
    this.jdField_j_of_type_Long = 0L;
    this.jdField_k_of_type_Long = 0L;
    this.jdField_l_of_type_Long = 0L;
    this.jdField_m_of_type_Long = 0L;
    this.jdField_n_of_type_Long = 0L;
    this.jdField_o_of_type_Long = 0L;
    this.jdField_p_of_type_Long = 0L;
    this.q = 0L;
    this.r = 0L;
    this.s = 0L;
    this.t = 0L;
    this.u = 0L;
    this.v = 0L;
    this.w = 0L;
    this.x = 0L;
    this.y = 0L;
    this.z = 0L;
    this.A = 0L;
    this.B = 0L;
    this.C = 0L;
    this.D = 0L;
    this.E = 0L;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_o_of_type_Boolean = false;
    this.F = 0L;
    this.jdField_d_of_type_Boolean = false;
    this.G = 0L;
    this.jdField_e_of_type_Boolean = false;
    this.H = 0L;
    this.jdField_f_of_type_Boolean = false;
    this.I = 0L;
    this.jdField_g_of_type_Boolean = false;
    this.J = 0L;
    this.jdField_h_of_type_Boolean = false;
    this.K = 0L;
    this.jdField_i_of_type_Boolean = false;
    this.L = 0L;
    this.jdField_j_of_type_Boolean = false;
    this.M = 0L;
    this.jdField_k_of_type_Boolean = false;
    this.N = 0L;
    this.jdField_l_of_type_Boolean = false;
    this.O = 0L;
    this.jdField_m_of_type_Boolean = false;
    this.P = 0L;
    this.jdField_n_of_type_Boolean = false;
    this.Q = 0L;
  }
  
  public void a(Intent paramIntent, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    if (paramIntent != null)
    {
      this.jdField_h_of_type_Long = SystemClock.elapsedRealtime();
      this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("isSender", false);
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_h_of_type_Long = SystemClock.elapsedRealtime();
        this.jdField_i_of_type_Long = 0L;
        this.jdField_a_of_type_Long = paramIntent.getLongExtra("senderStartTime", 0L);
      }
    }
    else
    {
      return;
    }
    this.w = SystemClock.elapsedRealtime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     lvy
 * JD-Core Version:    0.7.0.1
 */