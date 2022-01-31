import android.text.TextUtils;
import com.tencent.av.VideoConstants.EmShareState;
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
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class lid
  extends lig
{
  public static int L = -1;
  public static int Y;
  public int A;
  public boolean A;
  public int B;
  public boolean B;
  public int C = 0;
  public boolean C;
  public int D = -1;
  public boolean D;
  public int E = 0;
  public boolean E;
  public int F = 0;
  public boolean F;
  public int G;
  public boolean G;
  public int H = 0;
  public boolean H;
  public int I = 1;
  public boolean I;
  @Deprecated
  public int J;
  public boolean J;
  public int K;
  public boolean K;
  public boolean L;
  public int M = 1;
  public boolean M;
  public int N;
  public boolean N;
  public int O;
  public boolean O;
  public int P = -1;
  public boolean P;
  public int Q;
  public boolean Q;
  public int R;
  public boolean R;
  public int S = 1;
  public boolean S;
  public int T;
  public boolean T;
  public int U;
  public boolean U;
  public int V;
  public boolean V;
  public int W;
  @Deprecated
  public boolean W;
  public int X;
  @Deprecated
  public boolean X;
  @Deprecated
  public boolean Y;
  public int Z;
  @Deprecated
  public boolean Z;
  public long a;
  public VideoConstants.EmShareState a;
  public PtvTemplateManager.PtvTemplateInfo a;
  public final String a;
  private WeakReference<mob> jdField_a_of_type_JavaLangRefWeakReference;
  public ArrayList<Long> a;
  public BitSet a;
  public HashSet<Integer> a;
  private final ConcurrentHashMap<Long, Boolean> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  lhp jdField_a_of_type_Lhp = new lhp();
  private lic jdField_a_of_type_Lic;
  public lie a;
  public lif a;
  public byte[] a;
  public long[] a;
  public String[] a;
  public boolean aA;
  public boolean aB;
  public boolean aC;
  public boolean aD;
  public boolean aE;
  public boolean aF;
  public int aa;
  @Deprecated
  public boolean aa;
  public int ab;
  public boolean ab;
  public int ac = 0;
  public boolean ac;
  public int ad = 0;
  public volatile boolean ad;
  public int ae = 0;
  public boolean ae;
  public boolean af;
  private int ag;
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
  public boolean au;
  public boolean av = true;
  public boolean aw;
  public boolean ax;
  public boolean ay;
  public boolean az = true;
  public long b;
  public String b;
  public ArrayList<String> b = new ArrayList();
  public boolean b;
  public int c;
  public long c;
  public String c;
  public volatile ArrayList<lqq> c;
  public boolean c;
  public int d;
  public long d;
  public String d;
  public ArrayList<lqq> d;
  public boolean d;
  public int e;
  public long e;
  public String e;
  public ArrayList<lqq> e;
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
  public boolean m = true;
  public int n;
  public String n;
  public boolean n;
  public int o;
  public String o;
  public boolean o = true;
  public int p;
  public String p;
  public boolean p = true;
  public int q;
  public String q;
  public boolean q;
  public int r;
  public String r;
  public boolean r = true;
  public int s;
  public String s;
  public boolean s;
  public int t;
  public String t = "DEVICE_NONE";
  public boolean t;
  public int u;
  public String u;
  public boolean u;
  public int v = 0;
  public String v;
  public boolean v;
  public int w;
  public boolean w;
  public int x;
  public boolean x;
  public int y;
  public boolean y;
  public int z;
  public boolean z;
  
  public lid()
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
    this.jdField_k_of_type_Int = 3;
    this.jdField_n_of_type_Int = -1;
    this.jdField_s_of_type_Int = 0;
    this.jdField_c_of_type_Long = -1L;
    this.jdField_n_of_type_JavaLangString = "";
    this.jdField_G_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet(8);
    this.jdField_d_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_y_of_type_Int = -1;
    this.jdField_G_of_type_Int = 2;
    this.jdField_J_of_type_Int = -1;
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_e_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_f_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_ag_of_type_Boolean = true;
    this.jdField_K_of_type_Int = 7;
    this.jdField_a_of_type_JavaUtilBitSet = new BitSet();
    this.jdField_u_of_type_JavaLangString = "";
    this.jdField_T_of_type_Int = 0;
    this.jdField_U_of_type_Int = 0;
    this.jdField_V_of_type_Int = -1;
    this.jdField_W_of_type_Int = -1;
    this.jdField_X_of_type_Int = -1;
    this.jdField_a_of_type_Lie = new lie(this);
    this.jdField_a_of_type_Lif = new lif(this);
    this.jdField_Z_of_type_Int = -1;
    this.jdField_aa_of_type_Int = -1;
    this.jdField_ab_of_type_Int = -1;
    this.jdField_ag_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentAvVideoConstants$EmShareState = VideoConstants.EmShareState.NONE;
    this.jdField_a_of_type_JavaLangString = ("SessionInfo_" + AudioHelper.b());
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "createSession");
  }
  
  private boolean a(lqq paramlqq)
  {
    Iterator localIterator = this.jdField_d_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      lqq locallqq = (lqq)localIterator.next();
      if ((paramlqq.jdField_a_of_type_Int == locallqq.jdField_a_of_type_Int) && (paramlqq.jdField_a_of_type_Long == locallqq.jdField_a_of_type_Long)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean t()
  {
    return true;
  }
  
  public int a()
  {
    int i1 = 0;
    while (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
    {
      if (((lqq)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_b_of_type_Boolean) {
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
      if ((((lqq)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_c_of_type_Boolean) && (((lqq)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long != paramLong)) {
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
        if ((((lqq)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long == paramLong) && (((lqq)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Int == paramInt)) {
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
      if (((lqq)this.jdField_c_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Long == paramLong) {
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
    if ((this.jdField_J_of_type_Boolean) || (this.E == 100))
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
          if ((this.jdField_d_of_type_Int != 1) && (this.jdField_d_of_type_Int != 2) && (this.E != 3)) {
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
      } while ((this.jdField_d_of_type_Int != 3) && (this.jdField_d_of_type_Int != 4) && (this.E != 1) && (this.E != 2));
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
  
  public lic a()
  {
    if (this.jdField_a_of_type_Lic == null) {}
    try
    {
      if (this.jdField_a_of_type_Lic == null) {
        this.jdField_a_of_type_Lic = new lic();
      }
      return this.jdField_a_of_type_Lic;
    }
    finally {}
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoController", 2, "clearRandomSessionInfo sessionId = " + this.jdField_c_of_type_JavaLangString);
    }
    this.jdField_a_of_type_Lie.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Lie.jdField_c_of_type_JavaLangString = null;
    this.jdField_a_of_type_Lie.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Lie.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_Lie.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_Lie.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Lie.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_Lie.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Lie.jdField_b_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_Lie.jdField_c_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_Lie.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_Lie.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_Lie.jdField_e_of_type_JavaLangString = null;
    this.jdField_a_of_type_Lie.jdField_c_of_type_Int = -1;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "SessionInfo setAvType:" + paramInt);
    }
    this.C = paramInt;
    jdField_Y_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_h_of_type_Int != paramInt2) || (QLog.isColorLevel())) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setSwitchState[" + paramInt1 + "], state[" + this.jdField_h_of_type_Int + "->" + paramInt2 + "]");
    }
    this.jdField_h_of_type_Int = paramInt2;
  }
  
  public void a(int paramInt, lqq paramlqq)
  {
    long l1 = paramlqq.jdField_a_of_type_Long;
    int i1 = paramlqq.jdField_a_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addVideoViewInfo-->Uin = " + l1 + " ,VideoSrcType = " + i1 + " ,Pos = " + paramInt);
    }
    int i2 = a(l1, i1);
    if ((i2 != -1) && (QLog.isColorLevel())) {
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, "addVideoViewInfo Error,The View Info Is Exsit.Uin = " + l1 + " ,VideoSrcType = " + i1 + " ,Index = " + i2);
    }
    this.jdField_c_of_type_JavaUtilArrayList.add(paramInt, paramlqq);
    synchronized (this.jdField_d_of_type_JavaUtilArrayList)
    {
      if (!a(paramlqq))
      {
        this.jdField_d_of_type_JavaUtilArrayList.add(paramInt, paramlqq);
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
    this.jdField_T_of_type_Int = 0;
    this.jdField_U_of_type_Int = 0;
    this.ay = false;
    this.az = true;
    a(false);
    this.jdField_a_of_type_Lhp.a();
    this.jdField_d_of_type_Long = 0L;
    this.jdField_s_of_type_JavaLangString = null;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_u_of_type_Boolean = false;
    this.x = false;
    this.jdField_y_of_type_Boolean = false;
    this.z = false;
    this.aB = false;
    this.jdField_y_of_type_Int = -1;
    this.av = true;
    this.jdField_u_of_type_JavaLangString = "";
    this.jdField_j_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo = null;
    this.jdField_a_of_type_JavaUtilBitSet.clear();
    a(paramLong, false);
    b(paramLong, false);
    this.M = 1;
    this.E = 0;
    this.jdField_X_of_type_Int = -1;
    this.A = false;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.v = 0;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    try
    {
      this.jdField_a_of_type_Lic = null;
      a("clearSessionInfo", VideoConstants.EmShareState.NONE, 0);
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
          break label115;
        }
        a(paramLong, "setVideoState.1", 2);
      }
    }
    label115:
    do
    {
      do
      {
        return;
        a(paramLong, true);
        break;
      } while (this.jdField_d_of_type_Int != 3);
      a(paramLong, "setVideoState.2", 4);
      return;
      if (paramBoolean2) {
        b(paramLong, false);
      }
      while ((this.jdField_d_of_type_Int == 2) && (!this.jdField_k_of_type_Boolean) && (!this.jdField_j_of_type_Boolean) && (!this.jdField_l_of_type_Boolean))
      {
        a(paramLong, "setVideoState.3", 1);
        return;
        a(paramLong, false);
      }
    } while ((this.jdField_d_of_type_Int != 4) || (this.jdField_k_of_type_Boolean) || (this.jdField_j_of_type_Boolean) || (this.jdField_l_of_type_Boolean));
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
      lsa.e();
      if (VideoController.a().a() != null) {
        lro.c(VideoController.a().a());
      }
    }
    if ((this.jdField_k_of_type_Boolean) && (this.jdField_j_of_type_Boolean))
    {
      lvt.a().b(1);
      return;
    }
    lvt.a().a(1);
  }
  
  public void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "resetVideoDisplayListExceptTargetUin-->Uin = " + paramLong + " ,clearRenderFlag" + paramBoolean1 + " ,clearRecvDataFlag" + paramBoolean2);
    }
    int i1 = 0;
    while (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
    {
      if (((lqq)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long != paramLong)
      {
        if (paramBoolean1) {
          ((lqq)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_b_of_type_Boolean = false;
        }
        if (paramBoolean2) {
          ((lqq)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).d = false;
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
      luy.a(this.jdField_g_of_type_Int, paramInt);
      this.jdField_g_of_type_Int = paramInt;
    }
  }
  
  public void a(String paramString, VideoConstants.EmShareState paramEmShareState, int paramInt)
  {
    if (((this.jdField_a_of_type_ComTencentAvVideoConstants$EmShareState != paramEmShareState) || (this.ad != paramInt)) && (QLog.isColorLevel())) {
      QLog.i("AVShare", 2, "updateShareInfo, state[" + this.jdField_a_of_type_ComTencentAvVideoConstants$EmShareState + "-->" + paramEmShareState + "], type[" + this.ad + "-->" + paramInt + "], from[" + paramString + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoConstants$EmShareState != paramEmShareState) {
      this.jdField_a_of_type_ComTencentAvVideoConstants$EmShareState = paramEmShareState;
    }
    if (this.ad != paramInt) {
      this.ad = paramInt;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((!TextUtils.equals(this.jdField_c_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString)) || (QLog.isColorLevel())) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 1, "setSessionId, [" + this.jdField_c_of_type_JavaLangString + "," + paramString2 + "], from[" + paramString1 + "]");
    }
    this.jdField_c_of_type_JavaLangString = paramString2;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if ((AudioHelper.e()) || (paramBoolean != this.O)) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setSpeakerOn, from[" + paramString + "], isSpeakerOn[" + this.O + "->" + paramBoolean + "]");
    }
    this.O = paramBoolean;
  }
  
  public void a(lqq paramlqq)
  {
    long l1 = paramlqq.jdField_a_of_type_Long;
    int i1 = paramlqq.jdField_a_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addVideoViewInfo-->Uin = " + l1 + " ,VideoSrcType = " + i1);
    }
    int i2 = a(l1, i1);
    if ((i2 != -1) && (QLog.isColorLevel())) {
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, "addVideoViewInfo Error,The View Info Is Exsit.Uin = " + l1 + " ,VideoSrcType = " + i1 + " ,Index = " + i2);
    }
    this.jdField_c_of_type_JavaUtilArrayList.add(paramlqq);
    synchronized (this.jdField_d_of_type_JavaUtilArrayList)
    {
      if (!a(paramlqq))
      {
        this.jdField_d_of_type_JavaUtilArrayList.add(paramlqq);
        c();
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addVideoViewInfo mMultiVideoTalkList-->Uin = " + l1 + " ,VideoSrcType = " + i1 + " ,Pos = ");
        }
      }
      return;
    }
  }
  
  public void a(mob parammob)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() == parammob)) {
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parammob);
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setHasChangeDoubleScreen, hasChangeDoubleScreen[" + this.jdField_T_of_type_Boolean + "->" + paramBoolean + "]");
    this.jdField_T_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return (b()) || (this.aE);
  }
  
  public boolean a(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_Lhp == null) {
      return t();
    }
    return this.jdField_a_of_type_Lhp.a(paramLong, paramInt);
  }
  
  public boolean a(VideoController paramVideoController)
  {
    boolean bool = true;
    if ((this.jdField_ab_of_type_Int == -1) && (paramVideoController != null)) {
      this.jdField_ab_of_type_Int = paramVideoController.a(this, this.jdField_d_of_type_JavaLangString);
    }
    if ((this.jdField_aa_of_type_Int == -1) && (paramVideoController != null)) {
      this.jdField_aa_of_type_Int = paramVideoController.b(this, this.jdField_d_of_type_JavaLangString);
    }
    if (this.jdField_ab_of_type_Int == 2) {
      if (this.jdField_aa_of_type_Int < 100) {}
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("double_2_multi", 2, "isPeerSupportDMeetingSwitchTroop, end[" + this.jdField_ab_of_type_Int + "," + this.jdField_aa_of_type_Int + "," + bool + "]");
      }
      return bool;
      bool = false;
      continue;
      if (this.jdField_ab_of_type_Int == 4)
      {
        if (this.jdField_aa_of_type_Int < 101) {
          bool = false;
        }
      }
      else if (this.jdField_ab_of_type_Int == 5)
      {
        if (this.jdField_aa_of_type_Int < 5635) {
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
    if ((this.jdField_ag_of_type_Int == 0) && (paramVideoAppInterface != null))
    {
      i1 = this.jdField_i_of_type_Int;
      if (i1 != -1) {
        break label210;
      }
      i1 = mww.c(this.E);
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
          bool = amey.a(paramVideoAppInterface.getApp(), paramVideoAppInterface.getAccount(), str, i1);
          if (bool)
          {
            i2 = 2;
            this.jdField_ag_of_type_Int = i2;
          }
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i(this.jdField_a_of_type_JavaLangString, 2, "isVideoMsgBlocked ret[" + bool + "], uin[" + str + "], type[" + i1 + "], flag[" + this.jdField_ag_of_type_Int + "]");
          }
          if (this.jdField_ag_of_type_Int == 1)
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
    if (this.jdField_a_of_type_Lhp != null) {
      return this.jdField_a_of_type_Lhp.a(paramgVideoDownChannelControl);
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    bool1 = bool2;
    try
    {
      l1 = mti.a(paramString);
      bool1 = bool2;
      paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      Map.Entry localEntry;
      do
      {
        do
        {
          do
          {
            do
            {
              bool1 = bool2;
              if (!paramString.hasNext()) {
                break;
              }
              bool1 = bool2;
              localEntry = (Map.Entry)paramString.next();
              bool1 = bool2;
            } while (localEntry.getValue() == null);
            bool1 = bool2;
          } while (!((Boolean)localEntry.getValue()).booleanValue());
          bool1 = bool2;
        } while (localEntry.getKey() == null);
        bool1 = bool2;
      } while (((Long)localEntry.getKey()).longValue() == l1);
      bool1 = true;
      l1 = ((Long)localEntry.getKey()).longValue();
      bool1 = true;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        long l1 = 0L;
        continue;
        l1 = 0L;
        bool1 = false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("AVShare", 2, "isOtherUserShareScreenNow, [" + l1 + "," + bool1 + "]");
    }
    return bool1;
  }
  
  public int b()
  {
    return this.jdField_aa_of_type_Int;
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
          if ((((lqq)this.jdField_d_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long != paramLong) || (((lqq)this.jdField_d_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Int != paramInt)) {
            break label131;
          }
          return i1;
          if (i1 < this.jdField_d_of_type_JavaUtilArrayList.size())
          {
            if (((lqq)this.jdField_d_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long != paramLong) {
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
    this.jdField_a_of_type_Lif = new lif(this);
  }
  
  public void b(int paramInt)
  {
    QLog.i(this.jdField_a_of_type_JavaLangString, 1, "setPeerSdkVersion [" + paramInt + "]");
    this.jdField_aa_of_type_Int = paramInt;
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
      lvt.a().b(1);
      return;
    }
    lvt.a().a(1);
  }
  
  public void b(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong), Boolean.valueOf(paramBoolean1));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void b(String paramString, int paramInt)
  {
    boolean bool2 = true;
    if (paramInt != 0)
    {
      bool1 = bool2;
      if (paramInt != 1) {}
    }
    else
    {
      bool1 = bool2;
      if (this.D == 2) {
        switch (this.jdField_g_of_type_Int)
        {
        }
      }
    }
    for (boolean bool1 = bool2;; bool1 = false)
    {
      if ((QLog.isColorLevel()) || (this.D != paramInt)) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "setGAudioStatusType, from[" + paramString + "], isNeedUpdate[" + bool1 + "], state[" + this.jdField_g_of_type_Int + "], cur[" + this.D + "], come[" + paramInt + "]");
      }
      if (bool1) {
        this.D = paramInt;
      }
      return;
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    if ((AudioHelper.e()) || (!TextUtils.equals(paramString2, this.q))) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setDeviceName, from[" + paramString1 + "], deviceName[" + this.q + "->" + paramString2 + "]");
    }
    this.q = paramString2;
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    if ((AudioHelper.e()) || (paramBoolean != this.jdField_V_of_type_Boolean)) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setRoomMicOff[" + paramString + "], isRoomMicOff[" + this.jdField_V_of_type_Boolean + "->" + paramBoolean + "]");
    }
    this.jdField_V_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.F != 0;
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
        if ((((lqq)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long == paramLong) && (((lqq)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Int == paramInt)) {
          bool1 = ((lqq)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).d;
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
      QLog.i("double_2_multi", 2, "isPeerSupportDoubleSwitchToTroop, start[" + this.jdField_ab_of_type_Int + "," + this.jdField_aa_of_type_Int + "]");
    }
    if ((this.jdField_ab_of_type_Int == -1) && (paramVideoController != null)) {
      this.jdField_ab_of_type_Int = paramVideoController.b(this.jdField_d_of_type_JavaLangString);
    }
    if ((this.jdField_aa_of_type_Int == -1) && (paramVideoController != null)) {
      this.jdField_aa_of_type_Int = paramVideoController.c(this.jdField_d_of_type_JavaLangString);
    }
    if (this.jdField_ab_of_type_Int == 2) {
      if (this.jdField_aa_of_type_Int < 100) {}
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("double_2_multi", 2, "isPeerSupportDoubleSwitchToTroop, end[" + this.jdField_ab_of_type_Int + "," + this.jdField_aa_of_type_Int + "," + bool + "]");
      }
      return bool;
      bool = false;
      continue;
      if (this.jdField_ab_of_type_Int == 4)
      {
        if (this.jdField_aa_of_type_Int < 101) {
          bool = false;
        }
      }
      else if (this.jdField_ab_of_type_Int == 5) {
        bool = false;
      } else {
        bool = false;
      }
    }
  }
  
  public int c()
  {
    return this.jdField_ab_of_type_Int;
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((mob)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a();
    }
  }
  
  public void c(int paramInt)
  {
    QLog.i(this.jdField_a_of_type_JavaLangString, 1, "setPeerTerminalType [" + paramInt + "]");
    this.jdField_ab_of_type_Int = paramInt;
  }
  
  public void c(long paramLong)
  {
    a(paramLong);
    b("clearMultiVideoSessionInfo", false);
    this.jdField_h_of_type_Long = 0L;
    this.jdField_J_of_type_Int = -1;
    this.jdField_W_of_type_Boolean = false;
    this.jdField_X_of_type_Boolean = false;
    this.jdField_Y_of_type_Boolean = false;
    this.jdField_Z_of_type_Boolean = false;
    this.jdField_aa_of_type_Boolean = false;
    this.jdField_ab_of_type_Boolean = false;
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
  
  public void c(long paramLong, boolean paramBoolean)
  {
    if ((QLog.isDevelopLevel()) || (this.jdField_l_of_type_Boolean != paramBoolean)) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setRemoteHasVideo, remoteHasVideo[" + this.jdField_l_of_type_Boolean + "->" + paramBoolean + "], seq[" + paramLong + "]");
    }
    this.jdField_l_of_type_Boolean = paramBoolean;
  }
  
  public void c(String paramString, int paramInt)
  {
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setSwitchToGAudioMode[" + paramString + "], switchToGAudioMode[" + this.F + "->" + paramInt + "]");
    this.F = paramInt;
  }
  
  public void c(String paramString, boolean paramBoolean)
  {
    if ((this.jdField_K_of_type_Boolean != paramBoolean) || (QLog.isColorLevel())) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 1, "updateInMeetingRoom, from[" + paramString + "], [" + this.jdField_K_of_type_Boolean + "-->" + paramBoolean + "]");
    }
    if (this.jdField_K_of_type_Boolean != paramBoolean) {
      this.jdField_K_of_type_Boolean = paramBoolean;
    }
  }
  
  public boolean c()
  {
    return this.F == 2;
  }
  
  public int d()
  {
    int i1 = 0;
    if ((this.jdField_J_of_type_Boolean) || (this.E == 100)) {
      i1 = 1;
    }
    do
    {
      return i1;
      if ((this.jdField_d_of_type_Int == 1) || (this.jdField_d_of_type_Int == 2) || (this.E == 3)) {
        return 2;
      }
    } while ((this.jdField_d_of_type_Int != 3) && (this.jdField_d_of_type_Int != 4) && (this.E != 1) && (this.E != 2));
    return 1;
  }
  
  public void d(String paramString, int paramInt)
  {
    if ((AudioHelper.e()) || (paramInt != this.jdField_G_of_type_Int)) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setMicAuthByAdmin[" + paramString + "], micAuthByAdmin[" + this.jdField_G_of_type_Int + "->" + paramInt + "]");
    }
    this.jdField_G_of_type_Int = paramInt;
  }
  
  public void d(String paramString, boolean paramBoolean)
  {
    if ((this.jdField_J_of_type_Boolean != paramBoolean) || (QLog.isColorLevel())) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 1, "updateDoubleMeeting, from[" + paramString + "], [" + this.jdField_J_of_type_Boolean + "-->" + paramBoolean + "]");
    }
    if (this.jdField_J_of_type_Boolean != paramBoolean) {
      this.jdField_J_of_type_Boolean = paramBoolean;
    }
  }
  
  public boolean d()
  {
    return this.E == 2;
  }
  
  public void e(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("normal_2_meeting", 2, "setSwitch2DoubleMeeting, from[" + paramString + "], [" + this.aE + "-->" + paramBoolean + "]");
    }
    this.aE = paramBoolean;
  }
  
  public boolean e()
  {
    return (this.jdField_g_of_type_Int == 0) && (this.jdField_a_of_type_Lie.jdField_b_of_type_Int <= 0);
  }
  
  public boolean f()
  {
    return (this.jdField_g_of_type_Int == 0) && ((this.jdField_a_of_type_Lie.jdField_b_of_type_Int == 1) || (this.jdField_a_of_type_Lie.jdField_b_of_type_Int == 2));
  }
  
  public boolean g()
  {
    return this.jdField_g_of_type_Int == 1;
  }
  
  public boolean h()
  {
    return this.jdField_g_of_type_Int == 2;
  }
  
  public boolean i()
  {
    return (this.jdField_g_of_type_Int == 2) || (this.jdField_g_of_type_Int == 7);
  }
  
  public boolean j()
  {
    return this.jdField_g_of_type_Int == 3;
  }
  
  public boolean k()
  {
    return this.jdField_g_of_type_Int == 4;
  }
  
  public boolean l()
  {
    return this.jdField_g_of_type_Int == 10;
  }
  
  public boolean m()
  {
    return this.jdField_g_of_type_Int == 14;
  }
  
  public boolean n()
  {
    return this.jdField_g_of_type_Int == 5;
  }
  
  public boolean o()
  {
    return this.jdField_g_of_type_Int == 6;
  }
  
  public boolean p()
  {
    return this.jdField_g_of_type_Int == 15;
  }
  
  public boolean q()
  {
    return (this.jdField_d_of_type_Int == 3) || (this.jdField_d_of_type_Int == 4) || ((this.jdField_a_of_type_Lie.jdField_b_of_type_Int > 0) && (this.jdField_a_of_type_Lie.jdField_a_of_type_Int == 3));
  }
  
  public boolean r()
  {
    int i1 = 0;
    while (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
    {
      if (((lqq)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).d) {
        return false;
      }
      i1 += 1;
    }
    return true;
  }
  
  public boolean s()
  {
    return (this.jdField_d_of_type_Int == 2) || (this.jdField_d_of_type_Int == 4);
  }
  
  public String toString()
  {
    return "[" + this.jdField_a_of_type_JavaLangString + "], sessionId[" + this.jdField_c_of_type_JavaLangString + "], SessionType[" + this.jdField_d_of_type_Int + "], sessionStatus[" + this.jdField_c_of_type_Int + "], relationType[" + this.E + "], uinType[" + this.jdField_i_of_type_Int + "], relationId[" + this.jdField_g_of_type_Long + "], state[" + this.jdField_g_of_type_Int + "], switchState[" + this.jdField_h_of_type_Int + "], peerUin[" + this.jdField_d_of_type_JavaLangString + "], peerName[" + this.jdField_e_of_type_JavaLangString + "], extraUin[" + this.jdField_f_of_type_JavaLangString + "], extraCode[" + this.jdField_g_of_type_JavaLangString + "], multiAVType[" + this.C + "], localHasVideo[" + this.jdField_j_of_type_Boolean + "], roomId[" + this.jdField_l_of_type_Long + "], isReceiver[" + this.jdField_e_of_type_Boolean + "]";
  }
  
  public boolean u()
  {
    boolean bool2 = false;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
      {
        if (((lqq)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Boolean) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  public boolean v()
  {
    if (this.P == -1) {
      if (this.E != 2) {
        break label35;
      }
    }
    label35:
    for (this.P = bdfe.b(this.jdField_g_of_type_Long);; this.P = 0) {
      return bdfe.a(this.P);
    }
  }
  
  public boolean w()
  {
    return (this.jdField_d_of_type_Int == 1) || (this.jdField_d_of_type_Int == 2);
  }
  
  public boolean x()
  {
    int i1 = this.jdField_c_of_type_JavaUtilArrayList.size();
    if (QLog.isColorLevel()) {
      QLog.i("AVShare", 2, "isVideoNumReachMaxNow, size[" + i1 + "]");
    }
    return i1 >= 16;
  }
  
  public boolean y()
  {
    boolean bool2 = true;
    boolean bool1 = false;
    if ((this.E == 1) || (this.E == 2)) {}
    for (bool1 = this.jdField_U_of_type_Boolean;; bool1 = this.jdField_K_of_type_Boolean)
    {
      do
      {
        if (QLog.isColorLevel()) {
          QLog.i("AVShare", 2, "canStartScreenShare, relationType[" + this.E + "], isDoubleVideoMeeting[" + this.jdField_J_of_type_Boolean + "], ret[" + bool1 + "]");
        }
        return bool1;
      } while ((this.E != 3) && (this.E != 0));
      if (!this.jdField_J_of_type_Boolean) {
        break;
      }
    }
    if (this.jdField_g_of_type_Int == 4) {}
    for (bool1 = bool2;; bool1 = false) {
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lid
 * JD-Core Version:    0.7.0.1
 */