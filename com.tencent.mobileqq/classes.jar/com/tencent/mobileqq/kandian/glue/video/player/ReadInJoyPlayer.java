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
import com.tencent.mobileqq.kandian.base.video.player.videourl.VideoUrlInfo;
import com.tencent.mobileqq.kandian.biz.video.api.IReadInJoyPlayer;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoPreDownloadMgr;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.Nullable;

public class ReadInJoyPlayer
  extends LitePlayer
  implements PlayerStatusListener, IReadInJoyPlayer, ReadinjoyPlayerReporter.ReportDelegate
{
  public ReadinjoyPlayerReporter e;
  private final String f;
  private String g;
  private String h;
  private int i;
  private int j;
  private TextView k;
  private String l;
  
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
    this.f = paramString.toString();
    this.e = new ReadinjoyPlayerReporter(paramInt, this);
  }
  
  private void G() {}
  
  private void a(VideoUrlInfo paramVideoUrlInfo, String paramString, long paramLong, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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
  
  private void b(String paramString, long paramLong, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    ThirdVideoManager.a().a(paramString, new ReadInJoyPlayer.1(this, paramString, paramLong, paramInt));
  }
  
  private boolean b(String paramString1, String paramString2)
  {
    boolean bool1 = TextUtils.isEmpty(this.g);
    boolean bool3 = TextUtils.isEmpty(this.h);
    boolean bool2 = false;
    int m;
    if ((bool1) && (bool3)) {
      m = 0;
    } else {
      m = 1;
    }
    int n;
    if ((!bool1) && (!this.g.equals(paramString1))) {
      n = 0;
    } else {
      n = 1;
    }
    int i1;
    if ((!bool3) && (!this.h.equals(paramString2))) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    bool1 = bool2;
    if (m != 0)
    {
      bool1 = bool2;
      if (n != 0)
      {
        bool1 = bool2;
        if (i1 != 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void c(String paramString, long paramLong, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    a(paramString, paramString, 101, paramLong, paramInt);
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2)
  {
    this.g = paramString1;
    this.h = paramString2;
    this.i = paramInt1;
    this.j = paramInt2;
    if (QLog.isColorLevel())
    {
      String str = this.f;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("openByBusiType: vid=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", url=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", busiType=");
      localStringBuilder.append(paramInt1);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.d = false;
    a(this.e);
    a(this);
    if (BusiType.a(paramInt1))
    {
      a(paramString1, paramLong);
      return;
    }
    if ((paramInt1 != 2) && ((paramInt1 != 6) || (TextUtils.isEmpty(paramString1))))
    {
      if (paramInt1 == 5)
      {
        this.d = true;
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
    paramReadInJoyVideoReportData.g = this.i;
    paramReadInJoyVideoReportData.O = w();
    paramReadInJoyVideoReportData.P = x();
  }
  
  public void a(@Nullable IVideoPreDownloadMgr paramIVideoPreDownloadMgr)
  {
    this.e.a(paramIVideoPreDownloadMgr);
  }
  
  public void b(String paramString)
  {
    this.l = paramString;
    if (u()) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.player.ReadInJoyPlayer
 * JD-Core Version:    0.7.0.1
 */