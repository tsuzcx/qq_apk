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

public class rzq
  extends rzi
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private VideoPreDownloadMgr jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
  public qwv a;
  private rzr jdField_a_of_type_Rzr;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public rzq(int paramInt, rzr paramrzr)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Qwv = new qwv();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Rzr = paramrzr;
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
  
  private void a(qwv paramqwv)
  {
    this.jdField_c_of_type_Boolean = true;
    ThreadManager.excute(new ReadinjoyPlayerReporter.1(this, paramqwv), 16, null, true);
  }
  
  private void b(String paramString)
  {
    this.jdField_a_of_type_Qwv = new qwv();
    this.jdField_a_of_type_Qwv.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Qwv.jdField_d_of_type_Int = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Qwv.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Qwv.o = 0;
    this.jdField_a_of_type_Qwv.jdField_p_of_type_Int = 0;
    this.jdField_a_of_type_Qwv.jdField_q_of_type_Int = 0;
    this.jdField_a_of_type_Qwv.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_Qwv.jdField_f_of_type_JavaLangString = "";
    this.jdField_a_of_type_Qwv.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_Qwv.jdField_h_of_type_Boolean = false;
    if (this.jdField_a_of_type_Rzr != null) {
      this.jdField_a_of_type_Rzr.a(this.jdField_a_of_type_Qwv);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Qwv.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Qwv.jdField_b_of_type_Boolean = true;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_Qwv.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Qwv.jdField_c_of_type_JavaLangString = (paramInt1 + ":" + paramInt2);
    this.jdField_a_of_type_Qwv.jdField_d_of_type_JavaLangString = paramString;
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
                this.jdField_a_of_type_Qwv.jdField_e_of_type_Long = SystemClock.uptimeMillis();
                return;
                paramObject = this.jdField_a_of_type_Qwv;
                paramObject.jdField_f_of_type_Long += SystemClock.uptimeMillis() - this.jdField_a_of_type_Qwv.jdField_e_of_type_Long;
                paramObject = this.jdField_a_of_type_Qwv;
                paramObject.jdField_c_of_type_Int += 1;
                return;
                if (QLog.isColorLevel()) {
                  QLog.d("ReadinjoyPlayerReporter", 2, "播放状态回调 onInfo() PLAYER_INFO_DECODER_BLOCK");
                }
                paramObject = this.jdField_a_of_type_Qwv;
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
                  paramObject = this.jdField_a_of_type_Qwv;
                  paramObject.jdField_p_of_type_Int += i;
                }
                paramObject = this.jdField_a_of_type_Qwv;
                paramObject.jdField_q_of_type_Int += i;
              } while (!QLog.isColorLevel());
              QLog.d("ReadinjoyPlayerReporter", 2, "播放状态回调 onInfo() PLAYER_INFO_SKIP_ONE_FRAME decoderMode = " + paramInt + ", skipFrameCount = " + i + ", totalSkipCount = " + this.jdField_a_of_type_Qwv.jdField_p_of_type_Int + ", finalSkipCount = " + this.jdField_a_of_type_Qwv.jdField_q_of_type_Int);
              return;
              if (QLog.isColorLevel()) {
                QLog.d("ReadinjoyPlayerReporter", 2, "播放状态回调 onInfo() PLAYER_INFO_HW_DECODE_FAILED");
              }
              this.jdField_a_of_type_Qwv.jdField_f_of_type_Boolean = true;
            } while (!(paramObject instanceof String));
            this.jdField_a_of_type_Qwv.jdField_f_of_type_JavaLangString = ((String)paramObject);
            return;
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyPlayerReporter", 2, "播放状态回调 onInfo() PLAYER_INFO_CHANGE_HW_BACKUP_URL");
            }
            this.jdField_a_of_type_Qwv.jdField_g_of_type_Boolean = true;
            return;
          } while (paramObject == null);
          paramObject = ((String)paramObject).split(":", 2);
        } while ((paramObject == null) || (paramObject.length != 2));
        if (QLog.isColorLevel()) {
          QLog.d("ReadinjoyPlayerReporter", 2, "PERFORMANCE_REPORT method:" + paramObject[0] + "\ntimeJson:" + paramObject[1]);
        }
      } while (!"prepare".equals(paramObject[0]));
      this.jdField_a_of_type_Qwv.jdField_l_of_type_JavaLangString = paramObject[1];
      return;
    case 208: 
      rle.a.a(paramObject, this.jdField_a_of_type_Qwv);
      return;
    case 105: 
      paramInt = j;
      if (this.jdField_a_of_type_Qwv.jdField_b_of_type_Long > 0L) {
        paramInt = 1;
      }
      if (paramInt != 0) {}
      for (this.jdField_a_of_type_Qwv.v = (SystemClock.uptimeMillis() - this.jdField_a_of_type_Qwv.jdField_b_of_type_Long);; this.jdField_a_of_type_Qwv.v = 0L)
      {
        this.jdField_a_of_type_Qwv.w = (SystemClock.uptimeMillis() - this.jdField_a_of_type_Qwv.jdField_c_of_type_Long);
        return;
      }
    case 209: 
      label211:
      this.jdField_a_of_type_Qwv.jdField_t_of_type_Int = ((Long)paramObject).intValue();
      return;
    }
  }
  
  public void a(VideoPreDownloadMgr paramVideoPreDownloadMgr)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = paramVideoPreDownloadMgr;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Qwv.jdField_g_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    b(paramString1);
    this.jdField_a_of_type_Qwv.jdField_n_of_type_Int = 0;
    if (!paramBoolean1) {
      this.jdField_a_of_type_Qwv.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    }
    this.jdField_a_of_type_Qwv.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Qwv.o = 0;
    this.jdField_a_of_type_Qwv.jdField_p_of_type_Int = 0;
    this.jdField_a_of_type_Qwv.jdField_q_of_type_Int = 0;
    this.jdField_a_of_type_Qwv.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_Qwv.jdField_h_of_type_Boolean = false;
    this.jdField_a_of_type_Qwv.jdField_i_of_type_Boolean = paramBoolean2;
    a(paramString1, paramString2);
  }
  
  public void a(rwf paramrwf)
  {
    this.jdField_a_of_type_Qwv.jdField_m_of_type_Int = paramrwf.d();
    this.jdField_a_of_type_Qwv.jdField_l_of_type_Int = paramrwf.c();
  }
  
  public void a(rwf paramrwf, int paramInt)
  {
    this.jdField_a_of_type_Qwv.jdField_a_of_type_Long = paramrwf.a(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Qwv.jdField_f_of_type_Int = paramrwf.e();
    this.jdField_a_of_type_Qwv.jdField_n_of_type_Long = paramrwf.c();
    this.jdField_a_of_type_Qwv.jdField_g_of_type_Int = paramrwf.f();
    this.jdField_a_of_type_Qwv.jdField_c_of_type_Boolean = paramrwf.jdField_b_of_type_Boolean;
    this.jdField_a_of_type_Qwv.jdField_q_of_type_Long = paramrwf.jdField_b_of_type_Long;
    this.jdField_a_of_type_Qwv.jdField_p_of_type_Long = paramrwf.jdField_a_of_type_Long;
    this.jdField_a_of_type_Qwv.jdField_r_of_type_Long = paramrwf.g();
    if ((this.jdField_a_of_type_Qwv.jdField_a_of_type_Long == 0L) && (this.jdField_a_of_type_Qwv.jdField_d_of_type_Long == 0L))
    {
      this.jdField_a_of_type_Qwv.jdField_d_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_a_of_type_Qwv.jdField_b_of_type_Long);
      this.jdField_a_of_type_Qwv.jdField_f_of_type_Long = this.jdField_a_of_type_Qwv.jdField_d_of_type_Long;
    }
    this.jdField_a_of_type_Qwv.jdField_t_of_type_Long = rxy.a().a();
    this.jdField_a_of_type_Qwv.jdField_m_of_type_JavaLangString = ryh.a().a();
    this.jdField_a_of_type_Qwv.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_Qwv.jdField_l_of_type_Boolean = paramrwf.p();
    a(this.jdField_a_of_type_Qwv);
  }
  
  public void a(scv paramscv)
  {
    int i = 0;
    this.jdField_a_of_type_Qwv.jdField_j_of_type_Long = scq.a().a.longValue();
    this.jdField_a_of_type_Qwv.jdField_e_of_type_Int = paramscv.jdField_d_of_type_Int;
    this.jdField_a_of_type_Qwv.jdField_d_of_type_Boolean = paramscv.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Qwv.jdField_e_of_type_JavaLangString = paramscv.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_Qwv.jdField_e_of_type_Boolean = paramscv.jdField_b_of_type_Boolean;
    this.jdField_a_of_type_Qwv.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_Qwv.jdField_f_of_type_JavaLangString = "";
    this.jdField_a_of_type_Qwv.jdField_j_of_type_JavaLangString = paramscv.jdField_d_of_type_JavaLangString;
    Object localObject = this.jdField_a_of_type_Qwv;
    boolean bool;
    if (!TextUtils.isEmpty(paramscv.jdField_e_of_type_JavaLangString)) {
      bool = true;
    }
    for (;;)
    {
      ((qwv)localObject).jdField_h_of_type_Boolean = bool;
      try
      {
        localObject = new URL(paramscv.jdField_a_of_type_JavaLangString).getHost();
        paramscv = InnerDns.getInstance().reqDnsForIpList((String)localObject, 1006);
        qwv localqwv = this.jdField_a_of_type_Qwv;
        if (paramscv == null)
        {
          localqwv.jdField_r_of_type_Int = i;
          localqwv = this.jdField_a_of_type_Qwv;
          if (paramscv != null) {
            break label195;
          }
        }
        label195:
        for (paramscv = "";; paramscv = paramscv.toString())
        {
          localqwv.jdField_i_of_type_JavaLangString = paramscv;
          this.jdField_a_of_type_Qwv.jdField_h_of_type_JavaLangString = ((String)localObject);
          return;
          i = paramscv.size();
          break;
        }
        bool = false;
      }
      catch (Exception paramscv)
      {
        return;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Qwv.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    qwv localqwv = this.jdField_a_of_type_Qwv;
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      localqwv.jdField_n_of_type_Int = i;
      return;
    }
  }
  
  public void b(rwf paramrwf)
  {
    if (this.jdField_a_of_type_Qwv.jdField_d_of_type_Long != 0L) {
      return;
    }
    this.jdField_a_of_type_Qwv.jdField_d_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_a_of_type_Qwv.jdField_b_of_type_Long);
    Object localObject = this.jdField_a_of_type_Qwv;
    ((qwv)localObject).jdField_f_of_type_Long += this.jdField_a_of_type_Qwv.jdField_d_of_type_Long;
    localObject = this.jdField_a_of_type_Qwv;
    ((qwv)localObject).jdField_c_of_type_Int += 1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doReportOnVideoPrepared: vid=").append(this.jdField_a_of_type_Qwv.jdField_b_of_type_JavaLangString).append(", 预加载状态：").append(this.jdField_a_of_type_Qwv.jdField_n_of_type_Int).append(", 预下载命中：").append(this.jdField_b_of_type_Boolean).append(", 首帧耗时：").append(this.jdField_a_of_type_Qwv.jdField_d_of_type_Long);
      QLog.d("ReadinjoyPlayerReporter", 2, ((StringBuilder)localObject).toString());
    }
    ThreadManager.excute(new ReadinjoyPlayerReporter.3(this, paramrwf), 16, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rzq
 * JD-Core Version:    0.7.0.1
 */