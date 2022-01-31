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

public class qmr
  extends qmj
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private VideoPreDownloadMgr jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
  public pqb a;
  private qms jdField_a_of_type_Qms;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public qmr(int paramInt, qms paramqms)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Pqb = new pqb();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Qms = paramqms;
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
  
  private void a(pqb parampqb)
  {
    this.jdField_c_of_type_Boolean = true;
    ThreadManager.excute(new ReadinjoyPlayerReporter.1(this, parampqb), 16, null, true);
  }
  
  private void b(String paramString)
  {
    this.jdField_a_of_type_Pqb = new pqb();
    this.jdField_a_of_type_Pqb.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Pqb.jdField_c_of_type_Int = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Pqb.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Pqb.n = 0;
    this.jdField_a_of_type_Pqb.jdField_o_of_type_Int = 0;
    this.jdField_a_of_type_Pqb.jdField_p_of_type_Int = 0;
    this.jdField_a_of_type_Pqb.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_Pqb.jdField_g_of_type_JavaLangString = "";
    this.jdField_a_of_type_Pqb.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_Pqb.jdField_h_of_type_Boolean = false;
    if (this.jdField_a_of_type_Qms != null) {
      this.jdField_a_of_type_Qms.a(this.jdField_a_of_type_Pqb);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Pqb.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Pqb.jdField_b_of_type_Boolean = true;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_Pqb.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Pqb.jdField_c_of_type_JavaLangString = (paramInt1 + ":" + paramInt2);
    this.jdField_a_of_type_Pqb.jdField_d_of_type_JavaLangString = paramString;
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
              this.jdField_a_of_type_Pqb.jdField_d_of_type_Long = SystemClock.uptimeMillis();
              return;
              paramObject = this.jdField_a_of_type_Pqb;
              paramObject.jdField_e_of_type_Long += SystemClock.uptimeMillis() - this.jdField_a_of_type_Pqb.jdField_d_of_type_Long;
              paramObject = this.jdField_a_of_type_Pqb;
              paramObject.jdField_b_of_type_Int += 1;
              return;
              if (QLog.isColorLevel()) {
                QLog.d("ReadinjoyPlayerReporter", 2, "播放状态回调 onInfo() PLAYER_INFO_DECODER_BLOCK");
              }
              paramObject = this.jdField_a_of_type_Pqb;
              paramObject.n += 1;
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
                paramObject = this.jdField_a_of_type_Pqb;
                paramObject.jdField_o_of_type_Int += i;
              }
              paramObject = this.jdField_a_of_type_Pqb;
              paramObject.jdField_p_of_type_Int += i;
            } while (!QLog.isColorLevel());
            QLog.d("ReadinjoyPlayerReporter", 2, "播放状态回调 onInfo() PLAYER_INFO_SKIP_ONE_FRAME decoderMode = " + paramInt + ", skipFrameCount = " + i + ", totalSkipCount = " + this.jdField_a_of_type_Pqb.jdField_o_of_type_Int + ", finalSkipCount = " + this.jdField_a_of_type_Pqb.jdField_p_of_type_Int);
            return;
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyPlayerReporter", 2, "播放状态回调 onInfo() PLAYER_INFO_HW_DECODE_FAILED");
            }
            this.jdField_a_of_type_Pqb.jdField_f_of_type_Boolean = true;
          } while (!(paramObject instanceof String));
          this.jdField_a_of_type_Pqb.jdField_g_of_type_JavaLangString = ((String)paramObject);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("ReadinjoyPlayerReporter", 2, "播放状态回调 onInfo() PLAYER_INFO_CHANGE_HW_BACKUP_URL");
          }
          this.jdField_a_of_type_Pqb.jdField_g_of_type_Boolean = true;
          return;
        } while (paramObject == null);
        paramObject = ((String)paramObject).split(":", 2);
      } while ((paramObject == null) || (paramObject.length != 2));
      if (QLog.isColorLevel()) {
        QLog.d("ReadinjoyPlayerReporter", 2, "PERFORMANCE_REPORT method:" + paramObject[0] + "\ntimeJson:" + paramObject[1]);
      }
    } while (!"prepare".equals(paramObject[0]));
    this.jdField_a_of_type_Pqb.jdField_m_of_type_JavaLangString = paramObject[1];
  }
  
  public void a(VideoPreDownloadMgr paramVideoPreDownloadMgr)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = paramVideoPreDownloadMgr;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Pqb.jdField_h_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    b(paramString1);
    this.jdField_a_of_type_Pqb.jdField_m_of_type_Int = 0;
    if (!paramBoolean1) {
      this.jdField_a_of_type_Pqb.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    }
    if (this.jdField_a_of_type_Pqb != null)
    {
      this.jdField_a_of_type_Pqb.n = 0;
      this.jdField_a_of_type_Pqb.jdField_o_of_type_Int = 0;
      this.jdField_a_of_type_Pqb.jdField_p_of_type_Int = 0;
      this.jdField_a_of_type_Pqb.jdField_g_of_type_Boolean = false;
      this.jdField_a_of_type_Pqb.jdField_h_of_type_Boolean = false;
      this.jdField_a_of_type_Pqb.jdField_i_of_type_Boolean = paramBoolean2;
    }
    a(paramString1, paramString2);
  }
  
  public void a(ocs paramocs)
  {
    int i = 0;
    this.jdField_a_of_type_Pqb.jdField_i_of_type_Long = ocm.a().a.longValue();
    this.jdField_a_of_type_Pqb.jdField_d_of_type_Int = paramocs.jdField_d_of_type_Int;
    this.jdField_a_of_type_Pqb.jdField_d_of_type_Boolean = paramocs.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Pqb.jdField_e_of_type_JavaLangString = paramocs.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_Pqb.jdField_e_of_type_Boolean = paramocs.jdField_b_of_type_Boolean;
    this.jdField_a_of_type_Pqb.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_Pqb.jdField_g_of_type_JavaLangString = "";
    this.jdField_a_of_type_Pqb.jdField_k_of_type_JavaLangString = paramocs.jdField_d_of_type_JavaLangString;
    this.jdField_a_of_type_Pqb.jdField_l_of_type_JavaLangString = paramocs.jdField_e_of_type_JavaLangString;
    Object localObject = this.jdField_a_of_type_Pqb;
    boolean bool;
    if (!TextUtils.isEmpty(paramocs.jdField_f_of_type_JavaLangString)) {
      bool = true;
    }
    for (;;)
    {
      ((pqb)localObject).jdField_h_of_type_Boolean = bool;
      try
      {
        localObject = new URL(paramocs.jdField_a_of_type_JavaLangString).getHost();
        paramocs = axwx.a().a((String)localObject, 1006);
        pqb localpqb = this.jdField_a_of_type_Pqb;
        if (paramocs == null)
        {
          localpqb.jdField_q_of_type_Int = i;
          localpqb = this.jdField_a_of_type_Pqb;
          if (paramocs != null) {
            break label206;
          }
        }
        label206:
        for (paramocs = "";; paramocs = paramocs.toString())
        {
          localpqb.j = paramocs;
          this.jdField_a_of_type_Pqb.jdField_i_of_type_JavaLangString = ((String)localObject);
          return;
          i = paramocs.size();
          break;
        }
        bool = false;
      }
      catch (Exception paramocs)
      {
        return;
      }
    }
  }
  
  public void a(qhw paramqhw)
  {
    this.jdField_a_of_type_Pqb.jdField_l_of_type_Int = paramqhw.b();
    this.jdField_a_of_type_Pqb.jdField_k_of_type_Int = paramqhw.a();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Pqb.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    pqb localpqb = this.jdField_a_of_type_Pqb;
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      localpqb.jdField_m_of_type_Int = i;
      return;
    }
  }
  
  public void b(qhw paramqhw)
  {
    this.jdField_a_of_type_Pqb.jdField_a_of_type_Long = paramqhw.a(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Pqb.jdField_e_of_type_Int = paramqhw.c();
    this.jdField_a_of_type_Pqb.jdField_m_of_type_Long = paramqhw.c();
    this.jdField_a_of_type_Pqb.jdField_f_of_type_Int = paramqhw.d();
    this.jdField_a_of_type_Pqb.jdField_c_of_type_Boolean = paramqhw.jdField_b_of_type_Boolean;
    this.jdField_a_of_type_Pqb.jdField_p_of_type_Long = paramqhw.jdField_b_of_type_Long;
    this.jdField_a_of_type_Pqb.jdField_o_of_type_Long = paramqhw.jdField_a_of_type_Long;
    this.jdField_a_of_type_Pqb.jdField_q_of_type_Long = paramqhw.e();
    this.jdField_a_of_type_Pqb.r = paramqhw.h();
    this.jdField_a_of_type_Pqb.jdField_f_of_type_JavaLangString = paramqhw.a();
    this.jdField_a_of_type_Pqb.t = paramqhw.g();
    this.jdField_a_of_type_Pqb.u = paramqhw.f();
    if ((this.jdField_a_of_type_Pqb.jdField_a_of_type_Long == 0L) && (this.jdField_a_of_type_Pqb.jdField_c_of_type_Long == 0L))
    {
      this.jdField_a_of_type_Pqb.jdField_c_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_a_of_type_Pqb.jdField_b_of_type_Long);
      this.jdField_a_of_type_Pqb.jdField_e_of_type_Long = this.jdField_a_of_type_Pqb.jdField_c_of_type_Long;
    }
    this.jdField_a_of_type_Pqb.v = qka.a().a();
    paramqhw = qka.a().a();
    this.jdField_a_of_type_Pqb.z = paramqhw[0];
    this.jdField_a_of_type_Pqb.A = paramqhw[1];
    this.jdField_a_of_type_Pqb.x = paramqhw[2];
    this.jdField_a_of_type_Pqb.y = paramqhw[3];
    this.jdField_a_of_type_Pqb.w = paramqhw[4];
    a(this.jdField_a_of_type_Pqb);
  }
  
  public void c(qhw paramqhw)
  {
    if (this.jdField_a_of_type_Pqb.jdField_c_of_type_Long != 0L) {
      return;
    }
    this.jdField_a_of_type_Pqb.jdField_c_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_a_of_type_Pqb.jdField_b_of_type_Long);
    Object localObject = this.jdField_a_of_type_Pqb;
    ((pqb)localObject).jdField_e_of_type_Long += this.jdField_a_of_type_Pqb.jdField_c_of_type_Long;
    localObject = this.jdField_a_of_type_Pqb;
    ((pqb)localObject).jdField_b_of_type_Int += 1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doReportOnVideoPrepared: vid=").append(this.jdField_a_of_type_Pqb.jdField_b_of_type_JavaLangString).append(", 预加载状态：").append(this.jdField_a_of_type_Pqb.jdField_m_of_type_Int).append(", 预下载命中：").append(this.jdField_b_of_type_Boolean).append(", 首帧耗时：").append(this.jdField_a_of_type_Pqb.jdField_c_of_type_Long);
      QLog.d("ReadinjoyPlayerReporter", 2, ((StringBuilder)localObject).toString());
    }
    ThreadManager.excute(new ReadinjoyPlayerReporter.3(this, paramqhw), 16, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qmr
 * JD-Core Version:    0.7.0.1
 */