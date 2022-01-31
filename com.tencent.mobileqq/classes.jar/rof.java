import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.readinjoy.video.player.ReadinjoyPlayerReporter.1;
import com.tencent.biz.pubaccount.readinjoy.video.player.ReadinjoyPlayerReporter.3;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONObject;

public class rof
  extends rnx
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private VideoPreDownloadMgr jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
  public qlq a;
  private rog jdField_a_of_type_Rog;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public rof(int paramInt, rog paramrog)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Qlq = new qlq();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Rog = paramrog;
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
  
  private void a(qlq paramqlq)
  {
    this.jdField_c_of_type_Boolean = true;
    ThreadManager.excute(new ReadinjoyPlayerReporter.1(this, paramqlq), 16, null, true);
  }
  
  private void b(String paramString)
  {
    this.jdField_a_of_type_Qlq = new qlq();
    this.jdField_a_of_type_Qlq.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Qlq.jdField_c_of_type_Int = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Qlq.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Qlq.jdField_n_of_type_Int = 0;
    this.jdField_a_of_type_Qlq.jdField_o_of_type_Int = 0;
    this.jdField_a_of_type_Qlq.jdField_p_of_type_Int = 0;
    this.jdField_a_of_type_Qlq.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_Qlq.jdField_g_of_type_JavaLangString = "";
    this.jdField_a_of_type_Qlq.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_Qlq.jdField_h_of_type_Boolean = false;
    if (this.jdField_a_of_type_Rog != null) {
      this.jdField_a_of_type_Rog.a(this.jdField_a_of_type_Qlq);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Qlq.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Qlq.jdField_b_of_type_Boolean = true;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_Qlq.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Qlq.jdField_c_of_type_JavaLangString = (paramInt1 + ":" + paramInt2);
    this.jdField_a_of_type_Qlq.jdField_d_of_type_JavaLangString = paramString;
  }
  
  public void a(int paramInt, Object paramObject)
  {
    int i = 0;
    switch (paramInt)
    {
    }
    label183:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              this.jdField_a_of_type_Qlq.jdField_d_of_type_Long = SystemClock.uptimeMillis();
              return;
              paramObject = this.jdField_a_of_type_Qlq;
              paramObject.jdField_e_of_type_Long += SystemClock.uptimeMillis() - this.jdField_a_of_type_Qlq.jdField_d_of_type_Long;
              paramObject = this.jdField_a_of_type_Qlq;
              paramObject.jdField_b_of_type_Int += 1;
              return;
              if (QLog.isColorLevel()) {
                QLog.d("ReadinjoyPlayerReporter", 2, "播放状态回调 onInfo() PLAYER_INFO_DECODER_BLOCK");
              }
              paramObject = this.jdField_a_of_type_Qlq;
              paramObject.jdField_n_of_type_Int += 1;
              return;
              try
              {
                paramObject = new JSONObject((String)paramObject);
                paramInt = paramObject.optInt("decoderMode", 0);
              }
              catch (Exception paramObject)
              {
                for (;;)
                {
                  int j;
                  paramInt = 0;
                }
              }
              try
              {
                j = paramObject.optInt("skipFrameCount", 1);
                i = j;
              }
              catch (Exception paramObject)
              {
                break label183;
              }
              if (i > 0)
              {
                paramObject = this.jdField_a_of_type_Qlq;
                paramObject.jdField_o_of_type_Int += i;
              }
              paramObject = this.jdField_a_of_type_Qlq;
              paramObject.jdField_p_of_type_Int += i;
            } while (!QLog.isColorLevel());
            QLog.d("ReadinjoyPlayerReporter", 2, "播放状态回调 onInfo() PLAYER_INFO_SKIP_ONE_FRAME decoderMode = " + paramInt + ", skipFrameCount = " + i + ", totalSkipCount = " + this.jdField_a_of_type_Qlq.jdField_o_of_type_Int + ", finalSkipCount = " + this.jdField_a_of_type_Qlq.jdField_p_of_type_Int);
            return;
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyPlayerReporter", 2, "播放状态回调 onInfo() PLAYER_INFO_HW_DECODE_FAILED");
            }
            this.jdField_a_of_type_Qlq.jdField_f_of_type_Boolean = true;
          } while (!(paramObject instanceof String));
          this.jdField_a_of_type_Qlq.jdField_g_of_type_JavaLangString = ((String)paramObject);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("ReadinjoyPlayerReporter", 2, "播放状态回调 onInfo() PLAYER_INFO_CHANGE_HW_BACKUP_URL");
          }
          this.jdField_a_of_type_Qlq.jdField_g_of_type_Boolean = true;
          return;
        } while (paramObject == null);
        paramObject = ((String)paramObject).split(":", 2);
      } while ((paramObject == null) || (paramObject.length != 2));
      if (QLog.isColorLevel()) {
        QLog.d("ReadinjoyPlayerReporter", 2, "PERFORMANCE_REPORT method:" + paramObject[0] + "\ntimeJson:" + paramObject[1]);
      }
    } while (!"prepare".equals(paramObject[0]));
    this.jdField_a_of_type_Qlq.jdField_m_of_type_JavaLangString = paramObject[1];
  }
  
  public void a(VideoPreDownloadMgr paramVideoPreDownloadMgr)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = paramVideoPreDownloadMgr;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Qlq.jdField_h_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    b(paramString1);
    this.jdField_a_of_type_Qlq.jdField_m_of_type_Int = 0;
    if (!paramBoolean1) {
      this.jdField_a_of_type_Qlq.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    }
    if (this.jdField_a_of_type_Qlq != null)
    {
      this.jdField_a_of_type_Qlq.jdField_n_of_type_Int = 0;
      this.jdField_a_of_type_Qlq.jdField_o_of_type_Int = 0;
      this.jdField_a_of_type_Qlq.jdField_p_of_type_Int = 0;
      this.jdField_a_of_type_Qlq.jdField_g_of_type_Boolean = false;
      this.jdField_a_of_type_Qlq.jdField_h_of_type_Boolean = false;
      this.jdField_a_of_type_Qlq.jdField_i_of_type_Boolean = paramBoolean2;
    }
    a(paramString1, paramString2);
  }
  
  public void a(osl paramosl)
  {
    int i = 0;
    this.jdField_a_of_type_Qlq.jdField_i_of_type_Long = osf.a().a.longValue();
    this.jdField_a_of_type_Qlq.jdField_d_of_type_Int = paramosl.jdField_d_of_type_Int;
    this.jdField_a_of_type_Qlq.jdField_d_of_type_Boolean = paramosl.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Qlq.jdField_e_of_type_JavaLangString = paramosl.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_Qlq.jdField_e_of_type_Boolean = paramosl.jdField_b_of_type_Boolean;
    this.jdField_a_of_type_Qlq.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_Qlq.jdField_g_of_type_JavaLangString = "";
    this.jdField_a_of_type_Qlq.jdField_k_of_type_JavaLangString = paramosl.jdField_d_of_type_JavaLangString;
    this.jdField_a_of_type_Qlq.jdField_l_of_type_JavaLangString = paramosl.jdField_e_of_type_JavaLangString;
    Object localObject = this.jdField_a_of_type_Qlq;
    boolean bool;
    if (!TextUtils.isEmpty(paramosl.jdField_f_of_type_JavaLangString)) {
      bool = true;
    }
    for (;;)
    {
      ((qlq)localObject).jdField_h_of_type_Boolean = bool;
      try
      {
        localObject = new URL(paramosl.jdField_a_of_type_JavaLangString).getHost();
        paramosl = bazo.a().a((String)localObject, 1006);
        qlq localqlq = this.jdField_a_of_type_Qlq;
        if (paramosl == null)
        {
          localqlq.jdField_q_of_type_Int = i;
          localqlq = this.jdField_a_of_type_Qlq;
          if (paramosl != null) {
            break label206;
          }
        }
        label206:
        for (paramosl = "";; paramosl = paramosl.toString())
        {
          localqlq.j = paramosl;
          this.jdField_a_of_type_Qlq.jdField_i_of_type_JavaLangString = ((String)localObject);
          return;
          i = paramosl.size();
          break;
        }
        bool = false;
      }
      catch (Exception paramosl)
      {
        return;
      }
    }
  }
  
  public void a(rjn paramrjn)
  {
    this.jdField_a_of_type_Qlq.jdField_l_of_type_Int = paramrjn.b();
    this.jdField_a_of_type_Qlq.jdField_k_of_type_Int = paramrjn.a();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Qlq.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    qlq localqlq = this.jdField_a_of_type_Qlq;
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      localqlq.jdField_m_of_type_Int = i;
      return;
    }
  }
  
  public void b(rjn paramrjn)
  {
    this.jdField_a_of_type_Qlq.jdField_a_of_type_Long = paramrjn.a(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Qlq.jdField_e_of_type_Int = paramrjn.c();
    this.jdField_a_of_type_Qlq.jdField_m_of_type_Long = paramrjn.c();
    this.jdField_a_of_type_Qlq.jdField_f_of_type_Int = paramrjn.d();
    this.jdField_a_of_type_Qlq.jdField_c_of_type_Boolean = paramrjn.jdField_b_of_type_Boolean;
    this.jdField_a_of_type_Qlq.jdField_p_of_type_Long = paramrjn.jdField_b_of_type_Long;
    this.jdField_a_of_type_Qlq.jdField_o_of_type_Long = paramrjn.jdField_a_of_type_Long;
    this.jdField_a_of_type_Qlq.jdField_q_of_type_Long = paramrjn.f();
    this.jdField_a_of_type_Qlq.r = paramrjn.f();
    this.jdField_a_of_type_Qlq.jdField_f_of_type_JavaLangString = paramrjn.a();
    this.jdField_a_of_type_Qlq.t = paramrjn.h();
    this.jdField_a_of_type_Qlq.u = paramrjn.g();
    if ((this.jdField_a_of_type_Qlq.jdField_a_of_type_Long == 0L) && (this.jdField_a_of_type_Qlq.jdField_c_of_type_Long == 0L))
    {
      this.jdField_a_of_type_Qlq.jdField_c_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_a_of_type_Qlq.jdField_b_of_type_Long);
      this.jdField_a_of_type_Qlq.jdField_e_of_type_Long = this.jdField_a_of_type_Qlq.jdField_c_of_type_Long;
    }
    this.jdField_a_of_type_Qlq.v = rlt.a().a();
    this.jdField_a_of_type_Qlq.jdField_n_of_type_JavaLangString = rmc.a().a();
    a(this.jdField_a_of_type_Qlq);
  }
  
  public void c(rjn paramrjn)
  {
    if (this.jdField_a_of_type_Qlq.jdField_c_of_type_Long != 0L) {
      return;
    }
    this.jdField_a_of_type_Qlq.jdField_c_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_a_of_type_Qlq.jdField_b_of_type_Long);
    Object localObject = this.jdField_a_of_type_Qlq;
    ((qlq)localObject).jdField_e_of_type_Long += this.jdField_a_of_type_Qlq.jdField_c_of_type_Long;
    localObject = this.jdField_a_of_type_Qlq;
    ((qlq)localObject).jdField_b_of_type_Int += 1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doReportOnVideoPrepared: vid=").append(this.jdField_a_of_type_Qlq.jdField_b_of_type_JavaLangString).append(", 预加载状态：").append(this.jdField_a_of_type_Qlq.jdField_m_of_type_Int).append(", 预下载命中：").append(this.jdField_b_of_type_Boolean).append(", 首帧耗时：").append(this.jdField_a_of_type_Qlq.jdField_c_of_type_Long);
      QLog.d("ReadinjoyPlayerReporter", 2, ((StringBuilder)localObject).toString());
    }
    ThreadManager.excute(new ReadinjoyPlayerReporter.3(this, paramrjn), 16, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rof
 * JD-Core Version:    0.7.0.1
 */