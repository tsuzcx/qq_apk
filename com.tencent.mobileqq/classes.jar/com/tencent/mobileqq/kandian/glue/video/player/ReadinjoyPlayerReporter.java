package com.tencent.mobileqq.kandian.glue.video.player;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.bandwidth.BandwidthPredictor;
import com.tencent.mobileqq.kandian.base.bandwidth.VideoBufferRangeController;
import com.tencent.mobileqq.kandian.base.video.player.IPlayerReporter;
import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.video.player.data.ReadInJoyVideoReportData;
import com.tencent.mobileqq.kandian.base.video.player.videourl.ThirdVideoManager;
import com.tencent.mobileqq.kandian.base.video.player.videourl.VideoUrlInfo;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoPreDownloadMgr;
import com.tencent.mobileqq.transfile.dns.BaseInnerDns;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;

public class ReadinjoyPlayerReporter
  extends IPlayerReporter
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private SparseArray<ReadinjoyPlayerReporter.ReportInfoAction> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  public ReadInJoyVideoReportData a;
  private IVideoPreDownloadMgr jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIVideoPreDownloadMgr;
  private ReadinjoyPlayerReporter.ReportDelegate jdField_a_of_type_ComTencentMobileqqKandianGlueVideoPlayerReadinjoyPlayerReporter$ReportDelegate;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public ReadinjoyPlayerReporter(int paramInt, ReadinjoyPlayerReporter.ReportDelegate paramReportDelegate)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData = new ReadInJoyVideoReportData();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoPlayerReadinjoyPlayerReporter$ReportDelegate = paramReportDelegate;
    b();
  }
  
  private void a(ReadInJoyVideoReportData paramReadInJoyVideoReportData)
  {
    this.jdField_c_of_type_Boolean = true;
    ThreadManager.excute(new ReadinjoyPlayerReporter.1(this, paramReadInJoyVideoReportData), 16, null, true);
  }
  
  private void a(String paramString1, String paramString2)
  {
    IVideoPreDownloadMgr localIVideoPreDownloadMgr = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIVideoPreDownloadMgr;
    if (localIVideoPreDownloadMgr != null)
    {
      this.jdField_b_of_type_Boolean = localIVideoPreDownloadMgr.a(paramString2, paramString1);
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("视频预下载: url:");
        paramString2.append(paramString1);
        paramString2.append(" ;isPreDownloadHit: ");
        paramString2.append(this.jdField_b_of_type_Boolean);
        QLog.d("ReadinjoyPlayerReporter", 2, paramString2.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIVideoPreDownloadMgr.a(paramString1, this.jdField_b_of_type_Boolean);
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(112, new ReadinjoyPlayerReporter.BufferingStartAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(113, new ReadinjoyPlayerReporter.BufferingEndAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(28, new ReadinjoyPlayerReporter.DecoderBlockAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(40, new ReadinjoyPlayerReporter.SkipOneFrameAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(39, new ReadinjoyPlayerReporter.HWDecodeFailedAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(41, new ReadinjoyPlayerReporter.HWBackupUrlAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(42, new ReadinjoyPlayerReporter.PreForManceReportAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(208, new ReadinjoyPlayerReporter.ObjectMediaCodecInfoAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(105, new ReadinjoyPlayerReporter.FirstVideoFrameRenderedAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(209, new ReadinjoyPlayerReporter.VideoFrameCheckInfoAction(this));
  }
  
  private void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData = new ReadInJoyVideoReportData();
    ReadInJoyVideoReportData localReadInJoyVideoReportData = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData;
    localReadInJoyVideoReportData.jdField_c_of_type_JavaLangString = paramString;
    localReadInJoyVideoReportData.jdField_e_of_type_Int = this.jdField_a_of_type_Int;
    localReadInJoyVideoReportData.jdField_a_of_type_Boolean = true;
    localReadInJoyVideoReportData.jdField_q_of_type_Int = 0;
    localReadInJoyVideoReportData.jdField_r_of_type_Int = 0;
    localReadInJoyVideoReportData.s = 0;
    localReadInJoyVideoReportData.jdField_f_of_type_Boolean = false;
    localReadInJoyVideoReportData.jdField_g_of_type_JavaLangString = "";
    localReadInJoyVideoReportData.jdField_g_of_type_Boolean = false;
    localReadInJoyVideoReportData.jdField_h_of_type_Boolean = false;
    paramString = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoPlayerReadinjoyPlayerReporter$ReportDelegate;
    if (paramString != null) {
      paramString.a(localReadInJoyVideoReportData);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    ReadInJoyVideoReportData localReadInJoyVideoReportData = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData;
    localReadInJoyVideoReportData.jdField_a_of_type_Boolean = true;
    localReadInJoyVideoReportData.jdField_b_of_type_Boolean = true;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    ReadInJoyVideoReportData localReadInJoyVideoReportData = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData;
    localReadInJoyVideoReportData.jdField_a_of_type_Boolean = false;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(":");
    localStringBuilder.append(paramInt2);
    localReadInJoyVideoReportData.jdField_d_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData.jdField_e_of_type_JavaLangString = paramString;
  }
  
  public void a(int paramInt, Object paramObject)
  {
    ReadinjoyPlayerReporter.ReportInfoAction localReportInfoAction = (ReadinjoyPlayerReporter.ReportInfoAction)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localReportInfoAction != null) {
      localReportInfoAction.a(paramInt, paramObject);
    }
  }
  
  public void a(VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData.o = paramVideoPlayerWrapper.d();
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData.jdField_n_of_type_Int = paramVideoPlayerWrapper.c();
  }
  
  public void a(VideoPlayerWrapper paramVideoPlayerWrapper, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData.jdField_a_of_type_Long = paramVideoPlayerWrapper.a(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData.jdField_h_of_type_Int = paramVideoPlayerWrapper.e();
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData.jdField_n_of_type_Long = paramVideoPlayerWrapper.c();
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData.jdField_i_of_type_Int = paramVideoPlayerWrapper.f();
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData.jdField_c_of_type_Boolean = paramVideoPlayerWrapper.jdField_b_of_type_Boolean;
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData.jdField_q_of_type_Long = paramVideoPlayerWrapper.jdField_b_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData.jdField_p_of_type_Long = paramVideoPlayerWrapper.jdField_a_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData.jdField_r_of_type_Long = paramVideoPlayerWrapper.g();
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData.jdField_a_of_type_Long == 0L) && (this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData.jdField_d_of_type_Long == 0L))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData.jdField_d_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData.jdField_b_of_type_Long);
      localReadInJoyVideoReportData = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData;
      localReadInJoyVideoReportData.jdField_f_of_type_Long = localReadInJoyVideoReportData.jdField_d_of_type_Long;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData.jdField_t_of_type_Long = BandwidthPredictor.from().getCurrentPrediction();
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData.jdField_n_of_type_JavaLangString = VideoBufferRangeController.a().a();
    ReadInJoyVideoReportData localReadInJoyVideoReportData = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData;
    localReadInJoyVideoReportData.jdField_c_of_type_Int = paramInt;
    localReadInJoyVideoReportData.l = paramVideoPlayerWrapper.p();
    paramVideoPlayerWrapper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData.b());
    a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData);
  }
  
  public void a(VideoUrlInfo paramVideoUrlInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData.jdField_j_of_type_Long = ThirdVideoManager.a().a.longValue();
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData.jdField_f_of_type_Int = paramVideoUrlInfo.jdField_c_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData.jdField_d_of_type_Boolean = paramVideoUrlInfo.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData.jdField_f_of_type_JavaLangString = paramVideoUrlInfo.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData.jdField_e_of_type_Boolean = paramVideoUrlInfo.jdField_b_of_type_Boolean;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData;
    int i = 0;
    ((ReadInJoyVideoReportData)localObject).jdField_f_of_type_Boolean = false;
    String str = "";
    ((ReadInJoyVideoReportData)localObject).jdField_g_of_type_JavaLangString = "";
    ((ReadInJoyVideoReportData)localObject).k = paramVideoUrlInfo.jdField_d_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData.jdField_h_of_type_Boolean = (TextUtils.isEmpty(paramVideoUrlInfo.jdField_e_of_type_JavaLangString) ^ true);
    try
    {
      localObject = new URL(paramVideoUrlInfo.jdField_a_of_type_JavaLangString).getHost();
      paramVideoUrlInfo = InnerDns.getInstance().reqDnsForIpList((String)localObject, 1006);
      ReadInJoyVideoReportData localReadInJoyVideoReportData = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData;
      if (paramVideoUrlInfo != null) {
        i = paramVideoUrlInfo.size();
      }
      localReadInJoyVideoReportData.jdField_t_of_type_Int = i;
      localReadInJoyVideoReportData = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData;
      if (paramVideoUrlInfo == null) {
        paramVideoUrlInfo = str;
      } else {
        paramVideoUrlInfo = paramVideoUrlInfo.toString();
      }
      localReadInJoyVideoReportData.jdField_j_of_type_JavaLangString = paramVideoUrlInfo;
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData.jdField_i_of_type_JavaLangString = ((String)localObject);
      return;
    }
    catch (Exception paramVideoUrlInfo) {}
  }
  
  public void a(IVideoPreDownloadMgr paramIVideoPreDownloadMgr)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIVideoPreDownloadMgr = paramIVideoPreDownloadMgr;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData.jdField_h_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    b(paramString1);
    ReadInJoyVideoReportData localReadInJoyVideoReportData = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData;
    localReadInJoyVideoReportData.jdField_p_of_type_Int = 0;
    if (!paramBoolean1) {
      localReadInJoyVideoReportData.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    localReadInJoyVideoReportData = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData;
    localReadInJoyVideoReportData.jdField_q_of_type_Int = 0;
    localReadInJoyVideoReportData.jdField_r_of_type_Int = 0;
    localReadInJoyVideoReportData.s = 0;
    localReadInJoyVideoReportData.jdField_g_of_type_Boolean = false;
    localReadInJoyVideoReportData.jdField_h_of_type_Boolean = false;
    localReadInJoyVideoReportData.jdField_i_of_type_Boolean = paramBoolean2;
    a(paramString1, paramString2);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    ReadInJoyVideoReportData localReadInJoyVideoReportData = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData;
    int i;
    if (paramBoolean) {
      i = 2;
    } else {
      i = 1;
    }
    localReadInJoyVideoReportData.jdField_p_of_type_Int = i;
  }
  
  public void b(VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData.jdField_d_of_type_Long != 0L) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData.jdField_d_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData.jdField_b_of_type_Long);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData;
    ((ReadInJoyVideoReportData)localObject).jdField_f_of_type_Long += this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData.jdField_d_of_type_Long;
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData;
    ((ReadInJoyVideoReportData)localObject).jdField_d_of_type_Int += 1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doReportOnVideoPrepared: vid=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData.jdField_c_of_type_JavaLangString);
      ((StringBuilder)localObject).append(", 预加载状态：");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData.jdField_p_of_type_Int);
      ((StringBuilder)localObject).append(", 预下载命中：");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
      ((StringBuilder)localObject).append(", 首帧耗时：");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData.jdField_d_of_type_Long);
      QLog.d("ReadinjoyPlayerReporter", 2, ((StringBuilder)localObject).toString());
    }
    ThreadManager.excute(new ReadinjoyPlayerReporter.3(this, paramVideoPlayerWrapper), 16, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.player.ReadinjoyPlayerReporter
 * JD-Core Version:    0.7.0.1
 */