package com.tencent.mobileqq.kandian.glue.video.player;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.utils.ThreadUtil;
import com.tencent.mobileqq.kandian.base.video.player.BusiType;
import com.tencent.mobileqq.kandian.base.video.player.LitePlayer;
import com.tencent.mobileqq.kandian.base.video.player.PlayerStatusListener;
import com.tencent.mobileqq.kandian.base.video.player.data.ReadInJoyVideoReportData;
import com.tencent.mobileqq.kandian.base.video.player.videourl.ThirdVideoManager;
import com.tencent.mobileqq.kandian.biz.video.api.IReadInJoyPlayer;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoPreDownloadMgr;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.Nullable;

public class ReadInJoyPlayer
  extends LitePlayer
  implements PlayerStatusListener, IReadInJoyPlayer, ReadinjoyPlayerReporter.ReportDelegate
{
  private int jdField_a_of_type_Int;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public ReadinjoyPlayerReporter a;
  private final String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  
  public ReadInJoyPlayer(int paramInt)
  {
    this(paramInt, null, false);
  }
  
  public ReadInJoyPlayer(int paramInt, String paramString, boolean paramBoolean)
  {
    super(BaseApplicationImpl.getContext(), paramString, paramBoolean);
    paramString = new StringBuilder();
    paramString.append("ReadInjoyPlayer<");
    paramString.append(Integer.toHexString(hashCode()));
    paramString.append(">");
    this.jdField_a_of_type_JavaLangString = paramString.toString();
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoPlayerReadinjoyPlayerReporter = new ReadinjoyPlayerReporter(paramInt, this);
    a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoPlayerReadinjoyPlayerReporter);
    a(this);
  }
  
  private void a(String paramString, long paramLong)
  {
    if (paramString == null) {
      return;
    }
    a(paramString, 1, paramLong);
  }
  
  private void a(String paramString, long paramLong, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    a(paramString, 101, paramLong, paramInt);
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    boolean bool1 = TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString);
    boolean bool3 = TextUtils.isEmpty(this.c);
    boolean bool2 = false;
    int i;
    if ((bool1) && (bool3)) {
      i = 0;
    } else {
      i = 1;
    }
    int j;
    if ((!bool1) && (!this.jdField_b_of_type_JavaLangString.equals(paramString1))) {
      j = 0;
    } else {
      j = 1;
    }
    int k;
    if ((!bool3) && (!this.c.equals(paramString2))) {
      k = 0;
    } else {
      k = 1;
    }
    bool1 = bool2;
    if (i != 0)
    {
      bool1 = bool2;
      if (j != 0)
      {
        bool1 = bool2;
        if (k != 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void b(String paramString, long paramLong, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    ThirdVideoManager.a().a(paramString, new ReadInJoyPlayer.1(this, paramString, paramLong, paramInt));
  }
  
  private void c(String paramString, long paramLong, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    a(paramString, paramString, 101, paramLong, paramInt);
  }
  
  private void n() {}
  
  public void a(int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.c = paramString2;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    if (QLog.isColorLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("openByBusiType: vid=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", url=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", busiType=");
      localStringBuilder.append(paramInt1);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (BusiType.a(paramInt1))
    {
      a(paramString1, paramLong);
      return;
    }
    if ((paramInt1 != 2) && ((paramInt1 != 6) || (TextUtils.isEmpty(paramString1))))
    {
      if (paramInt1 == 5)
      {
        c(paramString1, paramLong, paramInt2);
        return;
      }
      a(paramString2, paramLong, paramInt2);
      return;
    }
    b(paramString1, paramLong, paramInt2);
  }
  
  public void a(ReadInJoyVideoReportData paramReadInJoyVideoReportData)
  {
    paramReadInJoyVideoReportData.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    paramReadInJoyVideoReportData.l = b();
    paramReadInJoyVideoReportData.m = c();
  }
  
  public void a(@Nullable IVideoPreDownloadMgr paramIVideoPreDownloadMgr)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoPlayerReadinjoyPlayerReporter.a(paramIVideoPreDownloadMgr);
  }
  
  public void b(String paramString)
  {
    this.d = paramString;
    if (h()) {
      ThreadUtil.a(new ReadInJoyPlayer.2(this));
    }
  }
  
  public void beforeVideoStart() {}
  
  public void onBufferEnd() {}
  
  public void onBufferStart() {}
  
  public void onCompletion() {}
  
  public void onFirstFrameRendered() {}
  
  public void onProgressChanged(long paramLong)
  {
    ThreadUtil.a(new ReadInJoyPlayer.4(this));
  }
  
  public void onVideoEnd(int paramInt) {}
  
  public void onVideoError(int paramInt1, int paramInt2, String paramString) {}
  
  public void onVideoOpen() {}
  
  public void onVideoPause() {}
  
  public void onVideoPrepared() {}
  
  public void onVideoRestart() {}
  
  public void onVideoStart() {}
  
  public void onVideoStop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.player.ReadInJoyPlayer
 * JD-Core Version:    0.7.0.1
 */