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

public class qyw
  extends qyo
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private VideoPreDownloadMgr jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
  public qbx a;
  private qyx jdField_a_of_type_Qyx;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public qyw(int paramInt, qyx paramqyx)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Qbx = new qbx();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Qyx = paramqyx;
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
  
  private void a(qbx paramqbx)
  {
    this.jdField_c_of_type_Boolean = true;
    ThreadManager.excute(new ReadinjoyPlayerReporter.1(this, paramqbx), 16, null, true);
  }
  
  private void b(String paramString)
  {
    this.jdField_a_of_type_Qbx = new qbx();
    this.jdField_a_of_type_Qbx.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Qbx.jdField_c_of_type_Int = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Qbx.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Qbx.n = 0;
    this.jdField_a_of_type_Qbx.jdField_o_of_type_Int = 0;
    this.jdField_a_of_type_Qbx.jdField_p_of_type_Int = 0;
    this.jdField_a_of_type_Qbx.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_Qbx.jdField_g_of_type_JavaLangString = "";
    this.jdField_a_of_type_Qbx.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_Qbx.jdField_h_of_type_Boolean = false;
    if (this.jdField_a_of_type_Qyx != null) {
      this.jdField_a_of_type_Qyx.a(this.jdField_a_of_type_Qbx);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Qbx.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Qbx.jdField_b_of_type_Boolean = true;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_Qbx.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Qbx.jdField_c_of_type_JavaLangString = (paramInt1 + ":" + paramInt2);
    this.jdField_a_of_type_Qbx.jdField_d_of_type_JavaLangString = paramString;
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
              this.jdField_a_of_type_Qbx.jdField_d_of_type_Long = SystemClock.uptimeMillis();
              return;
              paramObject = this.jdField_a_of_type_Qbx;
              paramObject.jdField_e_of_type_Long += SystemClock.uptimeMillis() - this.jdField_a_of_type_Qbx.jdField_d_of_type_Long;
              paramObject = this.jdField_a_of_type_Qbx;
              paramObject.jdField_b_of_type_Int += 1;
              return;
              if (QLog.isColorLevel()) {
                QLog.d("ReadinjoyPlayerReporter", 2, "播放状态回调 onInfo() PLAYER_INFO_DECODER_BLOCK");
              }
              paramObject = this.jdField_a_of_type_Qbx;
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
                paramObject = this.jdField_a_of_type_Qbx;
                paramObject.jdField_o_of_type_Int += i;
              }
              paramObject = this.jdField_a_of_type_Qbx;
              paramObject.jdField_p_of_type_Int += i;
            } while (!QLog.isColorLevel());
            QLog.d("ReadinjoyPlayerReporter", 2, "播放状态回调 onInfo() PLAYER_INFO_SKIP_ONE_FRAME decoderMode = " + paramInt + ", skipFrameCount = " + i + ", totalSkipCount = " + this.jdField_a_of_type_Qbx.jdField_o_of_type_Int + ", finalSkipCount = " + this.jdField_a_of_type_Qbx.jdField_p_of_type_Int);
            return;
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyPlayerReporter", 2, "播放状态回调 onInfo() PLAYER_INFO_HW_DECODE_FAILED");
            }
            this.jdField_a_of_type_Qbx.jdField_f_of_type_Boolean = true;
          } while (!(paramObject instanceof String));
          this.jdField_a_of_type_Qbx.jdField_g_of_type_JavaLangString = ((String)paramObject);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("ReadinjoyPlayerReporter", 2, "播放状态回调 onInfo() PLAYER_INFO_CHANGE_HW_BACKUP_URL");
          }
          this.jdField_a_of_type_Qbx.jdField_g_of_type_Boolean = true;
          return;
        } while (paramObject == null);
        paramObject = ((String)paramObject).split(":", 2);
      } while ((paramObject == null) || (paramObject.length != 2));
      if (QLog.isColorLevel()) {
        QLog.d("ReadinjoyPlayerReporter", 2, "PERFORMANCE_REPORT method:" + paramObject[0] + "\ntimeJson:" + paramObject[1]);
      }
    } while (!"prepare".equals(paramObject[0]));
    this.jdField_a_of_type_Qbx.jdField_m_of_type_JavaLangString = paramObject[1];
  }
  
  public void a(VideoPreDownloadMgr paramVideoPreDownloadMgr)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = paramVideoPreDownloadMgr;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Qbx.jdField_h_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    b(paramString1);
    this.jdField_a_of_type_Qbx.jdField_m_of_type_Int = 0;
    if (!paramBoolean1) {
      this.jdField_a_of_type_Qbx.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    }
    if (this.jdField_a_of_type_Qbx != null)
    {
      this.jdField_a_of_type_Qbx.n = 0;
      this.jdField_a_of_type_Qbx.jdField_o_of_type_Int = 0;
      this.jdField_a_of_type_Qbx.jdField_p_of_type_Int = 0;
      this.jdField_a_of_type_Qbx.jdField_g_of_type_Boolean = false;
      this.jdField_a_of_type_Qbx.jdField_h_of_type_Boolean = false;
      this.jdField_a_of_type_Qbx.jdField_i_of_type_Boolean = paramBoolean2;
    }
    a(paramString1, paramString2);
  }
  
  public void a(ood paramood)
  {
    int i = 0;
    this.jdField_a_of_type_Qbx.jdField_i_of_type_Long = onx.a().a.longValue();
    this.jdField_a_of_type_Qbx.jdField_d_of_type_Int = paramood.jdField_d_of_type_Int;
    this.jdField_a_of_type_Qbx.jdField_d_of_type_Boolean = paramood.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Qbx.jdField_e_of_type_JavaLangString = paramood.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_Qbx.jdField_e_of_type_Boolean = paramood.jdField_b_of_type_Boolean;
    this.jdField_a_of_type_Qbx.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_Qbx.jdField_g_of_type_JavaLangString = "";
    this.jdField_a_of_type_Qbx.jdField_k_of_type_JavaLangString = paramood.jdField_d_of_type_JavaLangString;
    this.jdField_a_of_type_Qbx.jdField_l_of_type_JavaLangString = paramood.jdField_e_of_type_JavaLangString;
    Object localObject = this.jdField_a_of_type_Qbx;
    boolean bool;
    if (!TextUtils.isEmpty(paramood.jdField_f_of_type_JavaLangString)) {
      bool = true;
    }
    for (;;)
    {
      ((qbx)localObject).jdField_h_of_type_Boolean = bool;
      try
      {
        localObject = new URL(paramood.jdField_a_of_type_JavaLangString).getHost();
        paramood = ayxe.a().a((String)localObject, 1006);
        qbx localqbx = this.jdField_a_of_type_Qbx;
        if (paramood == null)
        {
          localqbx.jdField_q_of_type_Int = i;
          localqbx = this.jdField_a_of_type_Qbx;
          if (paramood != null) {
            break label206;
          }
        }
        label206:
        for (paramood = "";; paramood = paramood.toString())
        {
          localqbx.j = paramood;
          this.jdField_a_of_type_Qbx.jdField_i_of_type_JavaLangString = ((String)localObject);
          return;
          i = paramood.size();
          break;
        }
        bool = false;
      }
      catch (Exception paramood)
      {
        return;
      }
    }
  }
  
  public void a(qub paramqub)
  {
    this.jdField_a_of_type_Qbx.jdField_l_of_type_Int = paramqub.b();
    this.jdField_a_of_type_Qbx.jdField_k_of_type_Int = paramqub.a();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Qbx.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    qbx localqbx = this.jdField_a_of_type_Qbx;
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      localqbx.jdField_m_of_type_Int = i;
      return;
    }
  }
  
  public void b(qub paramqub)
  {
    this.jdField_a_of_type_Qbx.jdField_a_of_type_Long = paramqub.a(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Qbx.jdField_e_of_type_Int = paramqub.c();
    this.jdField_a_of_type_Qbx.jdField_m_of_type_Long = paramqub.c();
    this.jdField_a_of_type_Qbx.jdField_f_of_type_Int = paramqub.d();
    this.jdField_a_of_type_Qbx.jdField_c_of_type_Boolean = paramqub.jdField_b_of_type_Boolean;
    this.jdField_a_of_type_Qbx.jdField_p_of_type_Long = paramqub.jdField_b_of_type_Long;
    this.jdField_a_of_type_Qbx.jdField_o_of_type_Long = paramqub.jdField_a_of_type_Long;
    this.jdField_a_of_type_Qbx.jdField_q_of_type_Long = paramqub.f();
    this.jdField_a_of_type_Qbx.r = paramqub.i();
    this.jdField_a_of_type_Qbx.jdField_f_of_type_JavaLangString = paramqub.a();
    this.jdField_a_of_type_Qbx.t = paramqub.h();
    this.jdField_a_of_type_Qbx.u = paramqub.g();
    if ((this.jdField_a_of_type_Qbx.jdField_a_of_type_Long == 0L) && (this.jdField_a_of_type_Qbx.jdField_c_of_type_Long == 0L))
    {
      this.jdField_a_of_type_Qbx.jdField_c_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_a_of_type_Qbx.jdField_b_of_type_Long);
      this.jdField_a_of_type_Qbx.jdField_e_of_type_Long = this.jdField_a_of_type_Qbx.jdField_c_of_type_Long;
    }
    this.jdField_a_of_type_Qbx.v = qwf.a().a();
    paramqub = qwf.a().a();
    this.jdField_a_of_type_Qbx.z = paramqub[0];
    this.jdField_a_of_type_Qbx.A = paramqub[1];
    this.jdField_a_of_type_Qbx.x = paramqub[2];
    this.jdField_a_of_type_Qbx.y = paramqub[3];
    this.jdField_a_of_type_Qbx.w = paramqub[4];
    a(this.jdField_a_of_type_Qbx);
  }
  
  public void c(qub paramqub)
  {
    if (this.jdField_a_of_type_Qbx.jdField_c_of_type_Long != 0L) {
      return;
    }
    this.jdField_a_of_type_Qbx.jdField_c_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_a_of_type_Qbx.jdField_b_of_type_Long);
    Object localObject = this.jdField_a_of_type_Qbx;
    ((qbx)localObject).jdField_e_of_type_Long += this.jdField_a_of_type_Qbx.jdField_c_of_type_Long;
    localObject = this.jdField_a_of_type_Qbx;
    ((qbx)localObject).jdField_b_of_type_Int += 1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doReportOnVideoPrepared: vid=").append(this.jdField_a_of_type_Qbx.jdField_b_of_type_JavaLangString).append(", 预加载状态：").append(this.jdField_a_of_type_Qbx.jdField_m_of_type_Int).append(", 预下载命中：").append(this.jdField_b_of_type_Boolean).append(", 首帧耗时：").append(this.jdField_a_of_type_Qbx.jdField_c_of_type_Long);
      QLog.d("ReadinjoyPlayerReporter", 2, ((StringBuilder)localObject).toString());
    }
    ThreadManager.excute(new ReadinjoyPlayerReporter.3(this, paramqub), 16, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qyw
 * JD-Core Version:    0.7.0.1
 */