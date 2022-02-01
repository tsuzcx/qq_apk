import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.readinjoy.video.player.ReadinjoyPlayerReporter.1;
import com.tencent.biz.pubaccount.readinjoy.video.player.ReadinjoyPlayerReporter.3;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;

public class ssz
  extends ssr
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private SparseArray<stj> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private VideoPreDownloadMgr jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
  public rqa a;
  private sti jdField_a_of_type_Sti;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public ssz(int paramInt, sti paramsti)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Rqa = new rqa();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Sti = paramsti;
    b();
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null)
    {
      this.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramString2, paramString1);
      if (QLog.isColorLevel()) {
        QLog.d("ReadinjoyPlayerReporter", 2, "视频预下载: url:" + paramString1 + " ;isPreDownloadHit: " + this.jdField_b_of_type_Boolean);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramString1, this.jdField_b_of_type_Boolean);
    }
  }
  
  private void a(rqa paramrqa)
  {
    this.jdField_c_of_type_Boolean = true;
    ThreadManager.excute(new ReadinjoyPlayerReporter.1(this, paramrqa), 16, null, true);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(112, new stb(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(113, new sta(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(28, new stc(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(40, new stk(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(39, new stf(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(41, new ste(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(42, new sth(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(208, new stg(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(105, new std(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(209, new stl(this));
  }
  
  private void b(String paramString)
  {
    this.jdField_a_of_type_Rqa = new rqa();
    this.jdField_a_of_type_Rqa.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Rqa.jdField_d_of_type_Int = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Rqa.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Rqa.o = 0;
    this.jdField_a_of_type_Rqa.jdField_p_of_type_Int = 0;
    this.jdField_a_of_type_Rqa.jdField_q_of_type_Int = 0;
    this.jdField_a_of_type_Rqa.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_Rqa.jdField_f_of_type_JavaLangString = "";
    this.jdField_a_of_type_Rqa.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_Rqa.jdField_h_of_type_Boolean = false;
    if (this.jdField_a_of_type_Sti != null) {
      this.jdField_a_of_type_Sti.a(this.jdField_a_of_type_Rqa);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Rqa.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Rqa.jdField_b_of_type_Boolean = true;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_Rqa.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Rqa.jdField_c_of_type_JavaLangString = (paramInt1 + ":" + paramInt2);
    this.jdField_a_of_type_Rqa.jdField_d_of_type_JavaLangString = paramString;
  }
  
  public void a(int paramInt, Object paramObject)
  {
    stj localstj = (stj)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localstj != null) {
      localstj.a(paramInt, paramObject);
    }
  }
  
  public void a(VideoPreDownloadMgr paramVideoPreDownloadMgr)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = paramVideoPreDownloadMgr;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Rqa.jdField_g_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    b(paramString1);
    this.jdField_a_of_type_Rqa.jdField_n_of_type_Int = 0;
    if (!paramBoolean1) {
      this.jdField_a_of_type_Rqa.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    }
    this.jdField_a_of_type_Rqa.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Rqa.o = 0;
    this.jdField_a_of_type_Rqa.jdField_p_of_type_Int = 0;
    this.jdField_a_of_type_Rqa.jdField_q_of_type_Int = 0;
    this.jdField_a_of_type_Rqa.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_Rqa.jdField_h_of_type_Boolean = false;
    this.jdField_a_of_type_Rqa.jdField_i_of_type_Boolean = paramBoolean2;
    a(paramString1, paramString2);
  }
  
  public void a(spn paramspn)
  {
    this.jdField_a_of_type_Rqa.jdField_m_of_type_Int = paramspn.d();
    this.jdField_a_of_type_Rqa.jdField_l_of_type_Int = paramspn.c();
  }
  
  public void a(spn paramspn, int paramInt)
  {
    this.jdField_a_of_type_Rqa.jdField_a_of_type_Long = paramspn.a(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Rqa.jdField_f_of_type_Int = paramspn.e();
    this.jdField_a_of_type_Rqa.jdField_n_of_type_Long = paramspn.c();
    this.jdField_a_of_type_Rqa.jdField_g_of_type_Int = paramspn.f();
    this.jdField_a_of_type_Rqa.jdField_c_of_type_Boolean = paramspn.jdField_b_of_type_Boolean;
    this.jdField_a_of_type_Rqa.jdField_q_of_type_Long = paramspn.jdField_b_of_type_Long;
    this.jdField_a_of_type_Rqa.jdField_p_of_type_Long = paramspn.jdField_a_of_type_Long;
    this.jdField_a_of_type_Rqa.jdField_r_of_type_Long = paramspn.g();
    if ((this.jdField_a_of_type_Rqa.jdField_a_of_type_Long == 0L) && (this.jdField_a_of_type_Rqa.jdField_d_of_type_Long == 0L))
    {
      this.jdField_a_of_type_Rqa.jdField_d_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_a_of_type_Rqa.jdField_b_of_type_Long);
      this.jdField_a_of_type_Rqa.jdField_f_of_type_Long = this.jdField_a_of_type_Rqa.jdField_d_of_type_Long;
    }
    this.jdField_a_of_type_Rqa.t = srh.a().a();
    this.jdField_a_of_type_Rqa.jdField_m_of_type_JavaLangString = srq.a().a();
    this.jdField_a_of_type_Rqa.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_Rqa.jdField_l_of_type_Boolean = paramspn.p();
    paramspn.a(this.jdField_a_of_type_Rqa.b());
    a(this.jdField_a_of_type_Rqa);
  }
  
  public void a(sxc paramsxc)
  {
    int i = 0;
    this.jdField_a_of_type_Rqa.jdField_j_of_type_Long = swx.a().a.longValue();
    this.jdField_a_of_type_Rqa.jdField_e_of_type_Int = paramsxc.jdField_d_of_type_Int;
    this.jdField_a_of_type_Rqa.jdField_d_of_type_Boolean = paramsxc.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Rqa.jdField_e_of_type_JavaLangString = paramsxc.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_Rqa.jdField_e_of_type_Boolean = paramsxc.jdField_b_of_type_Boolean;
    this.jdField_a_of_type_Rqa.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_Rqa.jdField_f_of_type_JavaLangString = "";
    this.jdField_a_of_type_Rqa.jdField_j_of_type_JavaLangString = paramsxc.jdField_d_of_type_JavaLangString;
    Object localObject = this.jdField_a_of_type_Rqa;
    boolean bool;
    if (!TextUtils.isEmpty(paramsxc.jdField_e_of_type_JavaLangString)) {
      bool = true;
    }
    for (;;)
    {
      ((rqa)localObject).jdField_h_of_type_Boolean = bool;
      try
      {
        localObject = new URL(paramsxc.jdField_a_of_type_JavaLangString).getHost();
        paramsxc = InnerDns.getInstance().reqDnsForIpList((String)localObject, 1006);
        rqa localrqa = this.jdField_a_of_type_Rqa;
        if (paramsxc == null)
        {
          localrqa.jdField_r_of_type_Int = i;
          localrqa = this.jdField_a_of_type_Rqa;
          if (paramsxc != null) {
            break label195;
          }
        }
        label195:
        for (paramsxc = "";; paramsxc = paramsxc.toString())
        {
          localrqa.jdField_i_of_type_JavaLangString = paramsxc;
          this.jdField_a_of_type_Rqa.jdField_h_of_type_JavaLangString = ((String)localObject);
          return;
          i = paramsxc.size();
          break;
        }
        bool = false;
      }
      catch (Exception paramsxc)
      {
        return;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Rqa.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    rqa localrqa = this.jdField_a_of_type_Rqa;
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      localrqa.jdField_n_of_type_Int = i;
      return;
    }
  }
  
  public void b(spn paramspn)
  {
    if (this.jdField_a_of_type_Rqa.jdField_d_of_type_Long != 0L) {
      return;
    }
    this.jdField_a_of_type_Rqa.jdField_d_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_a_of_type_Rqa.jdField_b_of_type_Long);
    Object localObject = this.jdField_a_of_type_Rqa;
    ((rqa)localObject).jdField_f_of_type_Long += this.jdField_a_of_type_Rqa.jdField_d_of_type_Long;
    localObject = this.jdField_a_of_type_Rqa;
    ((rqa)localObject).jdField_c_of_type_Int += 1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doReportOnVideoPrepared: vid=").append(this.jdField_a_of_type_Rqa.jdField_b_of_type_JavaLangString).append(", 预加载状态：").append(this.jdField_a_of_type_Rqa.jdField_n_of_type_Int).append(", 预下载命中：").append(this.jdField_b_of_type_Boolean).append(", 首帧耗时：").append(this.jdField_a_of_type_Rqa.jdField_d_of_type_Long);
      QLog.d("ReadinjoyPlayerReporter", 2, ((StringBuilder)localObject).toString());
    }
    ThreadManager.excute(new ReadinjoyPlayerReporter.3(this, paramspn), 16, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ssz
 * JD-Core Version:    0.7.0.1
 */