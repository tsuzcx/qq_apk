import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.readinjoy.video.player.ReadinjoyPlayerReporter.1;
import com.tencent.biz.pubaccount.readinjoy.video.player.ReadinjoyPlayerReporter.3;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONObject;

public class sim
  extends sie
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private VideoPreDownloadMgr jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
  public rgc a;
  private sin jdField_a_of_type_Sin;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public sim(int paramInt, sin paramsin)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Rgc = new rgc();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Sin = paramsin;
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
  
  private void a(rgc paramrgc)
  {
    this.jdField_c_of_type_Boolean = true;
    ThreadManager.excute(new ReadinjoyPlayerReporter.1(this, paramrgc), 16, null, true);
  }
  
  private void b(String paramString)
  {
    this.jdField_a_of_type_Rgc = new rgc();
    this.jdField_a_of_type_Rgc.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Rgc.jdField_d_of_type_Int = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Rgc.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Rgc.o = 0;
    this.jdField_a_of_type_Rgc.jdField_p_of_type_Int = 0;
    this.jdField_a_of_type_Rgc.jdField_q_of_type_Int = 0;
    this.jdField_a_of_type_Rgc.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_Rgc.jdField_f_of_type_JavaLangString = "";
    this.jdField_a_of_type_Rgc.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_Rgc.jdField_h_of_type_Boolean = false;
    if (this.jdField_a_of_type_Sin != null) {
      this.jdField_a_of_type_Sin.a(this.jdField_a_of_type_Rgc);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Rgc.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Rgc.jdField_b_of_type_Boolean = true;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_Rgc.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Rgc.jdField_c_of_type_JavaLangString = (paramInt1 + ":" + paramInt2);
    this.jdField_a_of_type_Rgc.jdField_d_of_type_JavaLangString = paramString;
  }
  
  public void a(int paramInt, Object paramObject)
  {
    int j = 0;
    int i = 0;
    switch (paramInt)
    {
    default: 
    case 112: 
    case 113: 
    case 28: 
    case 40: 
    case 39: 
    case 41: 
    case 42: 
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
                this.jdField_a_of_type_Rgc.jdField_e_of_type_Long = SystemClock.uptimeMillis();
                return;
                paramObject = this.jdField_a_of_type_Rgc;
                paramObject.jdField_f_of_type_Long += SystemClock.uptimeMillis() - this.jdField_a_of_type_Rgc.jdField_e_of_type_Long;
                paramObject = this.jdField_a_of_type_Rgc;
                paramObject.jdField_c_of_type_Int += 1;
                return;
                if (QLog.isColorLevel()) {
                  QLog.d("ReadinjoyPlayerReporter", 2, "播放状态回调 onInfo() PLAYER_INFO_DECODER_BLOCK");
                }
                paramObject = this.jdField_a_of_type_Rgc;
                paramObject.o += 1;
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
                  break label211;
                }
                if (i > 0)
                {
                  paramObject = this.jdField_a_of_type_Rgc;
                  paramObject.jdField_p_of_type_Int += i;
                }
                paramObject = this.jdField_a_of_type_Rgc;
                paramObject.jdField_q_of_type_Int += i;
              } while (!QLog.isColorLevel());
              QLog.d("ReadinjoyPlayerReporter", 2, "播放状态回调 onInfo() PLAYER_INFO_SKIP_ONE_FRAME decoderMode = " + paramInt + ", skipFrameCount = " + i + ", totalSkipCount = " + this.jdField_a_of_type_Rgc.jdField_p_of_type_Int + ", finalSkipCount = " + this.jdField_a_of_type_Rgc.jdField_q_of_type_Int);
              return;
              if (QLog.isColorLevel()) {
                QLog.d("ReadinjoyPlayerReporter", 2, "播放状态回调 onInfo() PLAYER_INFO_HW_DECODE_FAILED");
              }
              this.jdField_a_of_type_Rgc.jdField_f_of_type_Boolean = true;
            } while (!(paramObject instanceof String));
            this.jdField_a_of_type_Rgc.jdField_f_of_type_JavaLangString = ((String)paramObject);
            return;
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyPlayerReporter", 2, "播放状态回调 onInfo() PLAYER_INFO_CHANGE_HW_BACKUP_URL");
            }
            this.jdField_a_of_type_Rgc.jdField_g_of_type_Boolean = true;
            return;
          } while (paramObject == null);
          paramObject = ((String)paramObject).split(":", 2);
        } while ((paramObject == null) || (paramObject.length != 2));
        if (QLog.isColorLevel()) {
          QLog.d("ReadinjoyPlayerReporter", 2, "PERFORMANCE_REPORT method:" + paramObject[0] + "\ntimeJson:" + paramObject[1]);
        }
      } while (!"prepare".equals(paramObject[0]));
      this.jdField_a_of_type_Rgc.jdField_l_of_type_JavaLangString = paramObject[1];
      return;
    case 208: 
      rui.a.a(paramObject, this.jdField_a_of_type_Rgc);
      return;
    case 105: 
      paramInt = j;
      if (this.jdField_a_of_type_Rgc.jdField_b_of_type_Long > 0L) {
        paramInt = 1;
      }
      if (paramInt != 0) {}
      for (this.jdField_a_of_type_Rgc.v = (SystemClock.uptimeMillis() - this.jdField_a_of_type_Rgc.jdField_b_of_type_Long);; this.jdField_a_of_type_Rgc.v = 0L)
      {
        this.jdField_a_of_type_Rgc.w = (SystemClock.uptimeMillis() - this.jdField_a_of_type_Rgc.jdField_c_of_type_Long);
        return;
      }
    case 209: 
      label211:
      this.jdField_a_of_type_Rgc.jdField_t_of_type_Int = ((Long)paramObject).intValue();
      return;
    }
  }
  
  public void a(VideoPreDownloadMgr paramVideoPreDownloadMgr)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = paramVideoPreDownloadMgr;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Rgc.jdField_g_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    b(paramString1);
    this.jdField_a_of_type_Rgc.jdField_n_of_type_Int = 0;
    if (!paramBoolean1) {
      this.jdField_a_of_type_Rgc.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    }
    this.jdField_a_of_type_Rgc.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Rgc.o = 0;
    this.jdField_a_of_type_Rgc.jdField_p_of_type_Int = 0;
    this.jdField_a_of_type_Rgc.jdField_q_of_type_Int = 0;
    this.jdField_a_of_type_Rgc.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_Rgc.jdField_h_of_type_Boolean = false;
    this.jdField_a_of_type_Rgc.jdField_i_of_type_Boolean = paramBoolean2;
    a(paramString1, paramString2);
  }
  
  public void a(sfb paramsfb)
  {
    this.jdField_a_of_type_Rgc.jdField_m_of_type_Int = paramsfb.d();
    this.jdField_a_of_type_Rgc.jdField_l_of_type_Int = paramsfb.c();
  }
  
  public void a(sfb paramsfb, int paramInt)
  {
    this.jdField_a_of_type_Rgc.jdField_a_of_type_Long = paramsfb.a(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Rgc.jdField_f_of_type_Int = paramsfb.e();
    this.jdField_a_of_type_Rgc.jdField_n_of_type_Long = paramsfb.c();
    this.jdField_a_of_type_Rgc.jdField_g_of_type_Int = paramsfb.f();
    this.jdField_a_of_type_Rgc.jdField_c_of_type_Boolean = paramsfb.jdField_b_of_type_Boolean;
    this.jdField_a_of_type_Rgc.jdField_q_of_type_Long = paramsfb.jdField_b_of_type_Long;
    this.jdField_a_of_type_Rgc.jdField_p_of_type_Long = paramsfb.jdField_a_of_type_Long;
    this.jdField_a_of_type_Rgc.jdField_r_of_type_Long = paramsfb.g();
    if ((this.jdField_a_of_type_Rgc.jdField_a_of_type_Long == 0L) && (this.jdField_a_of_type_Rgc.jdField_d_of_type_Long == 0L))
    {
      this.jdField_a_of_type_Rgc.jdField_d_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_a_of_type_Rgc.jdField_b_of_type_Long);
      this.jdField_a_of_type_Rgc.jdField_f_of_type_Long = this.jdField_a_of_type_Rgc.jdField_d_of_type_Long;
    }
    this.jdField_a_of_type_Rgc.jdField_t_of_type_Long = sgu.a().a();
    this.jdField_a_of_type_Rgc.jdField_m_of_type_JavaLangString = shd.a().a();
    this.jdField_a_of_type_Rgc.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_Rgc.jdField_l_of_type_Boolean = paramsfb.p();
    a(this.jdField_a_of_type_Rgc);
  }
  
  public void a(slr paramslr)
  {
    int i = 0;
    this.jdField_a_of_type_Rgc.jdField_j_of_type_Long = slm.a().a.longValue();
    this.jdField_a_of_type_Rgc.jdField_e_of_type_Int = paramslr.jdField_d_of_type_Int;
    this.jdField_a_of_type_Rgc.jdField_d_of_type_Boolean = paramslr.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Rgc.jdField_e_of_type_JavaLangString = paramslr.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_Rgc.jdField_e_of_type_Boolean = paramslr.jdField_b_of_type_Boolean;
    this.jdField_a_of_type_Rgc.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_Rgc.jdField_f_of_type_JavaLangString = "";
    this.jdField_a_of_type_Rgc.jdField_j_of_type_JavaLangString = paramslr.jdField_d_of_type_JavaLangString;
    Object localObject = this.jdField_a_of_type_Rgc;
    boolean bool;
    if (!TextUtils.isEmpty(paramslr.jdField_e_of_type_JavaLangString)) {
      bool = true;
    }
    for (;;)
    {
      ((rgc)localObject).jdField_h_of_type_Boolean = bool;
      try
      {
        localObject = new URL(paramslr.jdField_a_of_type_JavaLangString).getHost();
        paramslr = InnerDns.getInstance().reqDnsForIpList((String)localObject, 1006);
        rgc localrgc = this.jdField_a_of_type_Rgc;
        if (paramslr == null)
        {
          localrgc.jdField_r_of_type_Int = i;
          localrgc = this.jdField_a_of_type_Rgc;
          if (paramslr != null) {
            break label195;
          }
        }
        label195:
        for (paramslr = "";; paramslr = paramslr.toString())
        {
          localrgc.jdField_i_of_type_JavaLangString = paramslr;
          this.jdField_a_of_type_Rgc.jdField_h_of_type_JavaLangString = ((String)localObject);
          return;
          i = paramslr.size();
          break;
        }
        bool = false;
      }
      catch (Exception paramslr)
      {
        return;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Rgc.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    rgc localrgc = this.jdField_a_of_type_Rgc;
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      localrgc.jdField_n_of_type_Int = i;
      return;
    }
  }
  
  public void b(sfb paramsfb)
  {
    if (this.jdField_a_of_type_Rgc.jdField_d_of_type_Long != 0L) {
      return;
    }
    this.jdField_a_of_type_Rgc.jdField_d_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_a_of_type_Rgc.jdField_b_of_type_Long);
    Object localObject = this.jdField_a_of_type_Rgc;
    ((rgc)localObject).jdField_f_of_type_Long += this.jdField_a_of_type_Rgc.jdField_d_of_type_Long;
    localObject = this.jdField_a_of_type_Rgc;
    ((rgc)localObject).jdField_c_of_type_Int += 1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doReportOnVideoPrepared: vid=").append(this.jdField_a_of_type_Rgc.jdField_b_of_type_JavaLangString).append(", 预加载状态：").append(this.jdField_a_of_type_Rgc.jdField_n_of_type_Int).append(", 预下载命中：").append(this.jdField_b_of_type_Boolean).append(", 首帧耗时：").append(this.jdField_a_of_type_Rgc.jdField_d_of_type_Long);
      QLog.d("ReadinjoyPlayerReporter", 2, ((StringBuilder)localObject).toString());
    }
    ThreadManager.excute(new ReadinjoyPlayerReporter.3(this, paramsfb), 16, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sim
 * JD-Core Version:    0.7.0.1
 */