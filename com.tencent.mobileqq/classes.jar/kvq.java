import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.qav_gvideo_sdk_transfer.gVideoDownChannelControl;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;

public class kvq
  extends kvt
{
  public static int J = -1;
  public static int W;
  public int A = 0;
  public boolean A;
  public int B = -1;
  public boolean B;
  public int C = 0;
  public boolean C;
  public int D = 0;
  public boolean D;
  public int E = 2;
  public boolean E;
  public int F;
  public boolean F;
  public int G = 1;
  public boolean G;
  @Deprecated
  public int H = -1;
  public boolean H;
  public int I;
  public boolean I;
  public boolean J;
  public int K = 1;
  public boolean K;
  public int L;
  public boolean L;
  public int M;
  public boolean M;
  public int N;
  public boolean N;
  public int O;
  public boolean O;
  public int P;
  public boolean P;
  public int Q = 1;
  public boolean Q;
  public int R = 0;
  public boolean R;
  public int S;
  public boolean S;
  public int T = -1;
  public boolean T;
  public int U;
  public boolean U;
  public int V;
  @Deprecated
  public boolean V;
  @Deprecated
  public boolean W;
  public int X;
  @Deprecated
  public boolean X;
  public int Y;
  @Deprecated
  public boolean Y;
  public int Z;
  @Deprecated
  public boolean Z;
  public long a;
  public PtvTemplateManager.PtvTemplateInfo a;
  public final String a;
  private WeakReference<mat> jdField_a_of_type_JavaLangRefWeakReference;
  public ArrayList<Long> a;
  public BitSet a;
  public HashSet<Integer> a;
  kvc jdField_a_of_type_Kvc = new kvc();
  private kvp jdField_a_of_type_Kvp;
  public kvr a;
  public kvs a;
  public byte[] a;
  public long[] a;
  public String[] a;
  public boolean aA;
  public boolean aa;
  private int ab = 0;
  public boolean ab;
  public volatile boolean ac;
  public boolean ad;
  public boolean ae;
  public boolean af = true;
  public boolean ag;
  public boolean ah;
  public boolean ai;
  public boolean aj;
  public boolean ak;
  public boolean al;
  public boolean am;
  public boolean an;
  public boolean ao;
  public boolean ap;
  public boolean aq;
  public boolean ar;
  public boolean as;
  public boolean at;
  public boolean au = true;
  public boolean av;
  public boolean aw;
  public boolean ax;
  public boolean ay = true;
  public boolean az;
  public long b;
  public String b;
  public ArrayList<String> b = new ArrayList();
  public boolean b;
  public int c;
  public long c;
  public String c;
  public volatile ArrayList<leb> c;
  public boolean c;
  public int d;
  public long d;
  public String d;
  public ArrayList<leb> d;
  public boolean d;
  public int e;
  public long e;
  public String e;
  public ArrayList<leb> e;
  public boolean e;
  public int f;
  public long f;
  public String f;
  public ArrayList<AVPhoneUserInfo> f;
  public boolean f;
  public int g;
  public long g;
  public String g;
  public boolean g;
  public int h;
  public long h;
  public String h;
  public boolean h;
  public int i;
  public long i;
  public String i;
  public boolean i;
  public int j;
  public long j;
  public String j;
  public boolean j;
  public int k;
  public long k;
  public String k;
  public boolean k;
  public int l;
  public String l;
  public boolean l;
  public int m;
  public String m;
  public boolean m;
  public int n;
  public String n;
  public boolean n;
  public int o;
  public String o;
  public boolean o = true;
  public int p;
  public String p;
  public boolean p;
  public int q;
  public String q;
  public boolean q = true;
  public int r;
  public String r;
  public boolean r;
  public int s;
  public String s;
  public boolean s;
  public int t;
  public String t;
  public boolean t;
  public int u;
  public String u;
  public boolean u;
  public int v;
  public boolean v;
  public int w;
  public boolean w;
  public int x;
  public boolean x;
  public int y;
  public boolean y;
  public int z;
  public boolean z;
  
  public kvq()
  {
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 15000;
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = 0;
    this.jdField_h_of_type_Int = 0;
    this.jdField_i_of_type_Int = -1;
    this.jdField_j_of_type_Int = -1;
    this.jdField_i_of_type_Boolean = true;
    this.jdField_l_of_type_Boolean = true;
    this.jdField_n_of_type_Boolean = true;
    this.jdField_k_of_type_Int = 3;
    this.jdField_n_of_type_Int = -1;
    this.jdField_s_of_type_Int = 0;
    this.jdField_c_of_type_Long = -1L;
    this.jdField_F_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet(8);
    this.jdField_d_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_w_of_type_Int = -1;
    this.jdField_F_of_type_Int = 0;
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_e_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_f_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_s_of_type_JavaLangString = "DEVICE_NONE";
    this.jdField_I_of_type_Int = 7;
    this.jdField_a_of_type_JavaUtilBitSet = new BitSet();
    this.jdField_t_of_type_JavaLangString = "";
    this.jdField_N_of_type_Int = -1;
    this.jdField_S_of_type_Int = 0;
    this.jdField_U_of_type_Int = -1;
    this.jdField_V_of_type_Int = -1;
    this.jdField_a_of_type_Kvr = new kvr(this);
    this.jdField_a_of_type_Kvs = new kvs(this);
    this.jdField_X_of_type_Int = -1;
    this.jdField_Y_of_type_Int = -1;
    this.jdField_Z_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = ("SessionInfo_" + AudioHelper.b());
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "createSession");
  }
  
  private boolean a(leb paramleb)
  {
    Iterator localIterator = this.jdField_d_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      leb localleb = (leb)localIterator.next();
      if ((paramleb.jdField_a_of_type_Int == localleb.jdField_a_of_type_Int) && (paramleb.jdField_a_of_type_Long == localleb.jdField_a_of_type_Long)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean s()
  {
    return true;
  }
  
  public int a()
  {
    int i1 = 0;
    while (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
    {
      if (((leb)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_b_of_type_Boolean) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  public int a(long paramLong)
  {
    int i1 = 0;
    while (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
    {
      if ((((leb)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_c_of_type_Boolean) && (((leb)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long != paramLong)) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  public int a(long paramLong, int paramInt)
  {
    int i1;
    if (paramInt != 0)
    {
      i1 = 0;
      while (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
      {
        if ((((leb)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long == paramLong) && (((leb)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Int == paramInt)) {
          return i1;
        }
        i1 += 1;
      }
    }
    paramInt = 0;
    for (;;)
    {
      if (paramInt >= this.jdField_c_of_type_JavaUtilArrayList.size()) {
        break label112;
      }
      i1 = paramInt;
      if (((leb)this.jdField_c_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Long == paramLong) {
        break;
      }
      paramInt += 1;
    }
    label112:
    return -1;
  }
  
  public long a()
  {
    long l1 = 0L;
    long l2;
    if ((this.jdField_I_of_type_Boolean) || (this.C == 100))
    {
      l2 = this.jdField_g_of_type_Long;
      l1 = l2;
      if (l2 != 0L) {}
    }
    else
    {
      do
      {
        do
        {
          try
          {
            l1 = Long.parseLong(this.jdField_d_of_type_JavaLangString);
            return l1;
          }
          catch (Throwable localThrowable1)
          {
            if (QLog.isDevelopLevel()) {
              QLog.i(this.jdField_a_of_type_JavaLangString, 4, "getChatRoomUin", localThrowable1);
            }
            return l2;
          }
          if ((this.jdField_d_of_type_Int != 1) && (this.jdField_d_of_type_Int != 2) && (this.C != 3)) {
            break;
          }
          try
          {
            l2 = Long.parseLong(this.jdField_d_of_type_JavaLangString);
            return l2;
          }
          catch (Throwable localThrowable2) {}
        } while (!QLog.isDevelopLevel());
        QLog.i(this.jdField_a_of_type_JavaLangString, 4, "getChatRoomUin", localThrowable2);
        return 0L;
      } while ((this.jdField_d_of_type_Int != 3) && (this.jdField_d_of_type_Int != 4) && (this.C != 1) && (this.C != 2));
      l2 = this.jdField_g_of_type_Long;
      l1 = l2;
      if (l2 == 0L) {
        try
        {
          l1 = Long.parseLong(this.jdField_f_of_type_JavaLangString);
          return l1;
        }
        catch (Throwable localThrowable3)
        {
          l1 = l2;
          if (QLog.isDevelopLevel())
          {
            QLog.i(this.jdField_a_of_type_JavaLangString, 4, "getChatRoomUin", localThrowable3);
            l1 = l2;
          }
        }
      }
    }
    return l1;
  }
  
  public AVPhoneUserInfo a(long paramLong, ArrayList<AVPhoneUserInfo> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      AVPhoneUserInfo localAVPhoneUserInfo = (AVPhoneUserInfo)paramArrayList.next();
      if ((localAVPhoneUserInfo.accountType != 1) && (localAVPhoneUserInfo.account == paramLong)) {
        return localAVPhoneUserInfo;
      }
    }
    return null;
  }
  
  public String a()
  {
    return this.jdField_h_of_type_JavaLangString;
  }
  
  public kvp a()
  {
    if (this.jdField_a_of_type_Kvp == null) {}
    try
    {
      if (this.jdField_a_of_type_Kvp == null) {
        this.jdField_a_of_type_Kvp = new kvp();
      }
      return this.jdField_a_of_type_Kvp;
    }
    finally {}
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoController", 2, "clearRandomSessionInfo sessionId = " + this.jdField_c_of_type_JavaLangString);
    }
    this.jdField_a_of_type_Kvr.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Kvr.jdField_c_of_type_JavaLangString = null;
    this.jdField_a_of_type_Kvr.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Kvr.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_Kvr.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_Kvr.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Kvr.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_Kvr.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Kvr.jdField_b_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_Kvr.jdField_c_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_Kvr.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_Kvr.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_Kvr.jdField_e_of_type_JavaLangString = null;
    this.jdField_a_of_type_Kvr.jdField_c_of_type_Int = -1;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "SessionInfo setAvType:" + paramInt);
    }
    this.A = paramInt;
    jdField_W_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_h_of_type_Int != paramInt2) || (QLog.isColorLevel())) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setSwitchState[" + paramInt1 + "], state[" + this.jdField_h_of_type_Int + "->" + paramInt2 + "]");
    }
    this.jdField_h_of_type_Int = paramInt2;
  }
  
  public void a(int paramInt, leb paramleb)
  {
    long l1 = paramleb.jdField_a_of_type_Long;
    int i1 = paramleb.jdField_a_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addVideoViewInfo-->Uin = " + l1 + " ,VideoSrcType = " + i1 + " ,Pos = " + paramInt);
    }
    int i2 = a(l1, i1);
    if ((i2 != -1) && (QLog.isColorLevel())) {
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, "addVideoViewInfo Error,The View Info Is Exsit.Uin = " + l1 + " ,VideoSrcType = " + i1 + " ,Index = " + i2);
    }
    this.jdField_c_of_type_JavaUtilArrayList.add(paramInt, paramleb);
    synchronized (this.jdField_d_of_type_JavaUtilArrayList)
    {
      if (!a(paramleb))
      {
        this.jdField_d_of_type_JavaUtilArrayList.add(paramInt, paramleb);
        c();
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addVideoViewInfo mMultiVideoTalkList-->Uin = " + l1 + " ,VideoSrcType = " + i1 + " ,Pos = " + paramInt);
        }
      }
      return;
    }
  }
  
  void a(long paramLong)
  {
    a(paramLong, 0L);
    this.jdField_k_of_type_Long = 0L;
    a("clearSessionInfo", 0);
    this.jdField_i_of_type_Int = -1;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    a(paramLong, "clearSessionInfo", 0);
    this.R = 0;
    this.jdField_S_of_type_Int = 0;
    this.ax = false;
    this.ay = true;
    a(false);
    this.jdField_a_of_type_Kvc.a();
    this.jdField_d_of_type_Long = 0L;
    this.r = null;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_t_of_type_Boolean = false;
    this.jdField_w_of_type_Boolean = false;
    this.x = false;
    this.y = false;
    this.jdField_w_of_type_Int = -1;
    this.au = true;
    this.jdField_t_of_type_JavaLangString = "";
    this.jdField_j_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo = null;
    this.jdField_a_of_type_JavaUtilBitSet.clear();
    a(paramLong, false);
    b(paramLong, false);
    this.K = 1;
    this.C = 0;
    this.jdField_V_of_type_Int = -1;
    this.z = false;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.v = 0;
    try
    {
      this.jdField_a_of_type_Kvp = null;
      return;
    }
    finally {}
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setConnectedTime, connectedTime[" + this.jdField_e_of_type_Long + "->" + paramLong2 + "], seq[" + paramLong1 + "]");
    this.jdField_e_of_type_Long = paramLong2;
  }
  
  public void a(long paramLong, String paramString, int paramInt)
  {
    if ((this.jdField_d_of_type_Int != paramInt) || (QLog.isColorLevel())) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setSessionType[" + paramString + "], SessionType[" + this.jdField_d_of_type_Int + "->" + paramInt + "], seq[" + paramLong + "]");
    }
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setVideoState[" + paramString + "], startOrStopVideo[" + paramBoolean1 + "], isRemote[" + paramBoolean2 + "], seq[" + paramLong + "]");
    }
    if (paramBoolean1) {
      if (paramBoolean2)
      {
        b(paramLong, true);
        if (this.jdField_d_of_type_Int != 1) {
          break label128;
        }
        a(paramLong, "setVideoState.1", 2);
        label105:
        if ((this.jdField_d_of_type_Int != 4) || (!paramBoolean2)) {}
      }
    }
    label128:
    do
    {
      return;
      a(paramLong, true);
      break;
      if (this.jdField_d_of_type_Int != 3) {
        break label105;
      }
      a(paramLong, "setVideoState.2", 4);
      break label105;
      if (paramBoolean2) {
        b(paramLong, false);
      }
      while (((this.jdField_d_of_type_Int != 4) || (!paramBoolean2)) || ((this.jdField_d_of_type_Int == 2) && (!this.jdField_k_of_type_Boolean) && (!this.jdField_j_of_type_Boolean)))
      {
        a(paramLong, "setVideoState.3", 1);
        return;
        a(paramLong, false);
      }
    } while ((this.jdField_d_of_type_Int != 4) || (this.jdField_k_of_type_Boolean) || (this.jdField_j_of_type_Boolean));
    a(paramLong, "setVideoState.4", 3);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if ((QLog.isDevelopLevel()) || (this.jdField_j_of_type_Boolean != paramBoolean))
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setLocalHasVideo, localHasVideo[" + this.jdField_j_of_type_Boolean + "->" + paramBoolean + "], seq[" + paramLong + "]");
      if (!paramBoolean) {
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "why call not local hasVideo, str[1], isVisible[]", new Throwable("打印调用栈"));
      }
    }
    this.jdField_j_of_type_Boolean = paramBoolean;
    if (this.jdField_j_of_type_Boolean)
    {
      lfi.e();
      if (VideoController.a().a() != null) {
        ley.c(VideoController.a().a());
      }
    }
    if ((this.jdField_k_of_type_Boolean) && (this.jdField_j_of_type_Boolean))
    {
      lja.a().b(1);
      return;
    }
    lja.a().a(1);
  }
  
  public void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "resetVideoDisplayListExceptTargetUin-->Uin = " + paramLong + " ,clearRenderFlag" + paramBoolean1 + " ,clearRecvDataFlag" + paramBoolean2);
    }
    int i1 = 0;
    while (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
    {
      if (((leb)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long != paramLong)
      {
        if (paramBoolean1) {
          ((leb)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_b_of_type_Boolean = false;
        }
        if (paramBoolean2) {
          ((leb)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).d = false;
        }
      }
      i1 += 1;
    }
  }
  
  public void a(AVPhoneUserInfo paramAVPhoneUserInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onPhoneUserInfoInRoom info = " + paramAVPhoneUserInfo.toString());
    }
    this.jdField_f_of_type_JavaUtilArrayList.add(paramAVPhoneUserInfo);
  }
  
  public void a(String paramString)
  {
    this.jdField_h_of_type_JavaLangString = paramString;
    if (QLog.isDevelopLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 4, "setPhoneNum, phoneNum[" + paramString + "]");
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((this.jdField_g_of_type_Int != paramInt) || (QLog.isColorLevel())) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setState[" + paramString + "], state[" + this.jdField_g_of_type_Int + "->" + paramInt + "]");
    }
    if (this.jdField_g_of_type_Int != paramInt)
    {
      lif.a(this.jdField_g_of_type_Int, paramInt);
      this.jdField_g_of_type_Int = paramInt;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((AudioHelper.e()) || (!TextUtils.equals(paramString2, this.p))) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setDeviceName, from[" + paramString1 + "], deviceName[" + this.p + "->" + paramString2 + "]");
    }
    this.p = paramString2;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if ((AudioHelper.e()) || (paramBoolean != this.jdField_N_of_type_Boolean)) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setSpeakerOn, from[" + paramString + "], isSpeakerOn[" + this.jdField_N_of_type_Boolean + "->" + paramBoolean + "]");
    }
    this.jdField_N_of_type_Boolean = paramBoolean;
  }
  
  public void a(leb paramleb)
  {
    long l1 = paramleb.jdField_a_of_type_Long;
    int i1 = paramleb.jdField_a_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addVideoViewInfo-->Uin = " + l1 + " ,VideoSrcType = " + i1);
    }
    int i2 = a(l1, i1);
    if ((i2 != -1) && (QLog.isColorLevel())) {
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, "addVideoViewInfo Error,The View Info Is Exsit.Uin = " + l1 + " ,VideoSrcType = " + i1 + " ,Index = " + i2);
    }
    this.jdField_c_of_type_JavaUtilArrayList.add(paramleb);
    synchronized (this.jdField_d_of_type_JavaUtilArrayList)
    {
      if (!a(paramleb))
      {
        this.jdField_d_of_type_JavaUtilArrayList.add(paramleb);
        c();
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addVideoViewInfo mMultiVideoTalkList-->Uin = " + l1 + " ,VideoSrcType = " + i1 + " ,Pos = ");
        }
      }
      return;
    }
  }
  
  public void a(mat parammat)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() == parammat)) {
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parammat);
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setHasChangeDoubleScreen, hasChangeDoubleScreen[" + this.jdField_S_of_type_Boolean + "->" + paramBoolean + "]");
    this.jdField_S_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.D != 0;
  }
  
  public boolean a(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_Kvc == null) {
      return s();
    }
    return this.jdField_a_of_type_Kvc.a(paramLong, paramInt);
  }
  
  public boolean a(VideoController paramVideoController)
  {
    boolean bool = true;
    if ((this.jdField_Z_of_type_Int == -1) && (paramVideoController != null)) {
      this.jdField_Z_of_type_Int = paramVideoController.a(this, this.jdField_d_of_type_JavaLangString);
    }
    if ((this.jdField_Y_of_type_Int == -1) && (paramVideoController != null)) {
      this.jdField_Y_of_type_Int = paramVideoController.b(this, this.jdField_d_of_type_JavaLangString);
    }
    if (this.jdField_Z_of_type_Int == 2) {
      if (this.jdField_Y_of_type_Int < 100) {}
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("double_2_multi", 2, "isPeerSupportDMeetingSwitchTroop, end[" + this.jdField_Z_of_type_Int + "," + this.jdField_Y_of_type_Int + "," + bool + "]");
      }
      return bool;
      bool = false;
      continue;
      if (this.jdField_Z_of_type_Int == 4)
      {
        if (this.jdField_Y_of_type_Int < 101) {
          bool = false;
        }
      }
      else if (this.jdField_Z_of_type_Int == 5)
      {
        if (this.jdField_Y_of_type_Int < 5635) {
          bool = false;
        }
      }
      else {
        bool = false;
      }
    }
  }
  
  public boolean a(VideoAppInterface paramVideoAppInterface)
  {
    int i1;
    if ((this.ab == 0) && (paramVideoAppInterface != null))
    {
      i1 = this.jdField_i_of_type_Int;
      if (i1 != -1) {
        break label210;
      }
      i1 = mjg.c(this.C);
    }
    label67:
    label204:
    label210:
    for (;;)
    {
      String str;
      if (i1 == 0) {
        str = this.jdField_d_of_type_JavaLangString;
      }
      for (;;)
      {
        boolean bool;
        int i2;
        if (i1 != -1)
        {
          bool = ajyy.a(paramVideoAppInterface.getApp(), paramVideoAppInterface.getAccount(), str, i1);
          if (bool)
          {
            i2 = 2;
            this.ab = i2;
          }
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i(this.jdField_a_of_type_JavaLangString, 2, "isVideoMsgBlocked ret[" + bool + "], uin[" + str + "], type[" + i1 + "], flag[" + this.ab + "]");
          }
          if (this.ab == 1)
          {
            return true;
            if (i1 == 1)
            {
              str = String.valueOf(this.jdField_g_of_type_Long);
              break;
            }
            if (i1 != -1) {
              break label204;
            }
            str = String.valueOf(this.jdField_g_of_type_Long);
            break;
            i2 = 1;
            break label67;
          }
          return false;
          bool = true;
        }
        str = null;
      }
    }
  }
  
  public boolean a(qav_gvideo_sdk_transfer.gVideoDownChannelControl paramgVideoDownChannelControl)
  {
    if (this.jdField_a_of_type_Kvc != null) {
      return this.jdField_a_of_type_Kvc.a(paramgVideoDownChannelControl);
    }
    return false;
  }
  
  public int b()
  {
    int i1 = 0;
    if ((this.jdField_I_of_type_Boolean) || (this.C == 100)) {
      i1 = 1;
    }
    do
    {
      return i1;
      if ((this.jdField_d_of_type_Int == 1) || (this.jdField_d_of_type_Int == 2) || (this.C == 3)) {
        return 2;
      }
    } while ((this.jdField_d_of_type_Int != 3) && (this.jdField_d_of_type_Int != 4) && (this.C != 1) && (this.C != 2));
    return 1;
  }
  
  public int b(long paramLong, int paramInt)
  {
    int i1 = 0;
    int i2 = 0;
    ArrayList localArrayList = this.jdField_d_of_type_JavaUtilArrayList;
    if (paramInt != 0) {
      i1 = i2;
    }
    for (;;)
    {
      try
      {
        if (i1 < this.jdField_d_of_type_JavaUtilArrayList.size())
        {
          if ((((leb)this.jdField_d_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long != paramLong) || (((leb)this.jdField_d_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Int != paramInt)) {
            break label131;
          }
          return i1;
          if (i1 < this.jdField_d_of_type_JavaUtilArrayList.size())
          {
            if (((leb)this.jdField_d_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long != paramLong) {
              break label140;
            }
            return i1;
          }
        }
        return -1;
      }
      finally {}
      label131:
      i1 += 1;
      continue;
      label140:
      i1 += 1;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Kvs = new kvs(this);
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("double_2_multi", 2, "setPeerSdkVersion [" + paramInt + "]");
    }
    this.jdField_Y_of_type_Int = paramInt;
  }
  
  public void b(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "clearDoubleVideoSessionInfo, sessionId[" + this.jdField_c_of_type_JavaLangString + "], seq[" + paramLong + "]");
    }
    a(paramLong);
    b();
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    if ((QLog.isDevelopLevel()) || (this.jdField_k_of_type_Boolean != paramBoolean)) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setRemoteHasVideo, remoteHasVideo[" + this.jdField_k_of_type_Boolean + "->" + paramBoolean + "], seq[" + paramLong + "]");
    }
    this.jdField_k_of_type_Boolean = paramBoolean;
    if ((this.jdField_k_of_type_Boolean) && (this.jdField_j_of_type_Boolean))
    {
      lja.a().b(1);
      return;
    }
    lja.a().a(1);
  }
  
  public void b(String paramString, int paramInt)
  {
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setSwitchToGAudioMode[" + paramString + "], switchToGAudioMode[" + this.D + "->" + paramInt + "]");
    this.D = paramInt;
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    if ((AudioHelper.e()) || (paramBoolean != this.jdField_U_of_type_Boolean)) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setRoomMicOff[" + paramString + "], isRoomMicOff[" + this.jdField_U_of_type_Boolean + "->" + paramBoolean + "]");
    }
    this.jdField_U_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.D == 2;
  }
  
  public boolean b(long paramLong, int paramInt)
  {
    boolean bool2 = false;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
      {
        if ((((leb)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long == paramLong) && (((leb)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Int == paramInt)) {
          bool1 = ((leb)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).d;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  public boolean b(VideoController paramVideoController)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.i("double_2_multi", 2, "isPeerSupportDoubleSwitchToTroop, start[" + this.jdField_Z_of_type_Int + "," + this.jdField_Y_of_type_Int + "]");
    }
    if ((this.jdField_Z_of_type_Int == -1) && (paramVideoController != null)) {
      this.jdField_Z_of_type_Int = paramVideoController.b(this.jdField_d_of_type_JavaLangString);
    }
    if ((this.jdField_Y_of_type_Int == -1) && (paramVideoController != null)) {
      this.jdField_Y_of_type_Int = paramVideoController.c(this.jdField_d_of_type_JavaLangString);
    }
    if (this.jdField_Z_of_type_Int == 2) {
      if (this.jdField_Y_of_type_Int < 100) {}
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("double_2_multi", 2, "isPeerSupportDoubleSwitchToTroop, end[" + this.jdField_Z_of_type_Int + "," + this.jdField_Y_of_type_Int + "," + bool + "]");
      }
      return bool;
      bool = false;
      continue;
      if (this.jdField_Z_of_type_Int == 4)
      {
        if (this.jdField_Y_of_type_Int < 101) {
          bool = false;
        }
      }
      else if (this.jdField_Z_of_type_Int == 5) {
        bool = false;
      } else {
        bool = false;
      }
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((mat)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a();
    }
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("double_2_multi", 2, "setPeerTerminalType [" + paramInt + "]");
    }
    this.jdField_Z_of_type_Int = paramInt;
  }
  
  public void c(long paramLong)
  {
    a(paramLong);
    b("clearMultiVideoSessionInfo", false);
    this.jdField_h_of_type_Long = 0L;
    this.H = -1;
    this.jdField_V_of_type_Boolean = false;
    this.jdField_W_of_type_Boolean = false;
    this.jdField_X_of_type_Boolean = false;
    this.jdField_Y_of_type_Boolean = false;
    this.jdField_Z_of_type_Boolean = false;
    this.aa = false;
    this.jdField_c_of_type_JavaUtilArrayList.clear();
    synchronized (this.jdField_d_of_type_JavaUtilArrayList)
    {
      this.jdField_d_of_type_JavaUtilArrayList.clear();
      c();
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      this.jdField_e_of_type_JavaUtilArrayList.clear();
      a(0);
      return;
    }
  }
  
  public void c(String paramString, int paramInt)
  {
    if ((AudioHelper.e()) || (paramInt != this.E)) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setMicAuthByAdmin[" + paramString + "], micAuthByAdmin[" + this.E + "->" + paramInt + "]");
    }
    this.E = paramInt;
  }
  
  public boolean c()
  {
    return this.C == 2;
  }
  
  public boolean d()
  {
    return (this.jdField_g_of_type_Int == 0) && (this.jdField_a_of_type_Kvr.jdField_b_of_type_Int <= 0);
  }
  
  public boolean e()
  {
    return (this.jdField_g_of_type_Int == 0) && ((this.jdField_a_of_type_Kvr.jdField_b_of_type_Int == 1) || (this.jdField_a_of_type_Kvr.jdField_b_of_type_Int == 2));
  }
  
  public boolean f()
  {
    return this.jdField_g_of_type_Int == 1;
  }
  
  public boolean g()
  {
    return this.jdField_g_of_type_Int == 2;
  }
  
  public boolean h()
  {
    return (this.jdField_g_of_type_Int == 2) || (this.jdField_g_of_type_Int == 7);
  }
  
  public boolean i()
  {
    return this.jdField_g_of_type_Int == 3;
  }
  
  public boolean j()
  {
    return this.jdField_g_of_type_Int == 4;
  }
  
  public boolean k()
  {
    return this.jdField_g_of_type_Int == 10;
  }
  
  public boolean l()
  {
    return this.jdField_g_of_type_Int == 14;
  }
  
  public boolean m()
  {
    return this.jdField_g_of_type_Int == 5;
  }
  
  public boolean n()
  {
    return this.jdField_g_of_type_Int == 6;
  }
  
  public boolean o()
  {
    return this.jdField_g_of_type_Int == 15;
  }
  
  public boolean p()
  {
    return (this.jdField_d_of_type_Int == 3) || (this.jdField_d_of_type_Int == 4) || ((this.jdField_a_of_type_Kvr.jdField_b_of_type_Int > 0) && (this.jdField_a_of_type_Kvr.jdField_a_of_type_Int == 3));
  }
  
  public boolean q()
  {
    int i1 = 0;
    while (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
    {
      if (((leb)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).d) {
        return false;
      }
      i1 += 1;
    }
    return true;
  }
  
  public boolean r()
  {
    return (this.jdField_d_of_type_Int == 2) || (this.jdField_d_of_type_Int == 4);
  }
  
  public boolean t()
  {
    boolean bool2 = false;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
      {
        if (((leb)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Boolean) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  public String toString()
  {
    return "[" + this.jdField_a_of_type_JavaLangString + "], sessionId[" + this.jdField_c_of_type_JavaLangString + "], SessionType[" + this.jdField_d_of_type_Int + "], sessionStatus[" + this.jdField_c_of_type_Int + "], relationType[" + this.C + "], uinType[" + this.jdField_i_of_type_Int + "], relationId[" + this.jdField_g_of_type_Long + "], state[" + this.jdField_g_of_type_Int + "], switchState[" + this.jdField_h_of_type_Int + "], peerUin[" + this.jdField_d_of_type_JavaLangString + "], peerName[" + this.jdField_e_of_type_JavaLangString + "], extraUin[" + this.jdField_f_of_type_JavaLangString + "], extraCode[" + this.jdField_g_of_type_JavaLangString + "], multiAVType[" + this.A + "], localHasVideo[" + this.jdField_j_of_type_Boolean + "], roomId[" + this.jdField_l_of_type_Long + "], isReceiver[" + this.jdField_e_of_type_Boolean + "]";
  }
  
  public boolean u()
  {
    if (this.jdField_N_of_type_Int == -1) {
      if (this.C != 2) {
        break label35;
      }
    }
    label35:
    for (this.jdField_N_of_type_Int = baep.b(this.jdField_g_of_type_Long);; this.jdField_N_of_type_Int = 0) {
      return baep.a(this.jdField_N_of_type_Int);
    }
  }
  
  public boolean v()
  {
    return (this.jdField_d_of_type_Int == 1) || (this.jdField_d_of_type_Int == 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     kvq
 * JD-Core Version:    0.7.0.1
 */