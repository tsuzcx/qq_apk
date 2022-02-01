package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView.ScaleType;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.video.player.videourl.ThirdVideoManager;
import com.tencent.mobileqq.kandian.base.video.player.videourl.VideoUrlInfo;
import com.tencent.mobileqq.kandian.base.view.widget.KanDianRoundCornerTextView;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.gifvideo.base.gif.GifView;
import com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoPredownloadManager;
import com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoView;
import com.tencent.mobileqq.kandian.biz.gifvideo.media.IMediaView;
import com.tencent.mobileqq.kandian.biz.gifvideo.media.MediaVideoView;
import com.tencent.mobileqq.kandian.biz.gifvideo.media.MediaViewFactory;
import com.tencent.mobileqq.kandian.biz.pts.util.PGCShortContentUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCPicInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.video.entity.PGCVideoInfo;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class ComponentPGCShortContentBig
  extends ComponentContentBig
  implements View.OnClickListener
{
  private static Drawable A;
  public static int f = Aladdin.getConfig(174).getIntegerFromString("gif_playmode", 1);
  public static String g = "";
  private static Drawable z;
  private boolean h = false;
  private boolean i = false;
  private IMediaView j;
  private FrameLayout k;
  private int l;
  private int m;
  private int n;
  private ViewGroup.LayoutParams o;
  private int p = 0;
  private int q = 0;
  private int r;
  private float s;
  private float t;
  private float u;
  private float v;
  private float w;
  private float x;
  private int y = 0;
  
  public ComponentPGCShortContentBig(Context paramContext)
  {
    super(paramContext);
    h();
  }
  
  public ComponentPGCShortContentBig(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentPGCShortContentBig(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private String a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.t != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.t.a != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.t.a.size() > 0))
    {
      localObject1 = (PGCPicInfo)paramAbsBaseArticleInfo.mSocialFeedInfo.t.a.get(0);
      if (!TextUtils.isEmpty(((PGCPicInfo)localObject1).d))
      {
        localObject1 = ((PGCPicInfo)localObject1).d;
        break label85;
      }
    }
    Object localObject1 = "";
    label85:
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      if ((!TextUtils.isEmpty(paramAbsBaseArticleInfo.gifCoverUrl)) && (this.h)) {
        return paramAbsBaseArticleInfo.gifCoverUrl;
      }
      localObject2 = paramAbsBaseArticleInfo.mFirstPagePicUrl;
    }
    return localObject2;
  }
  
  private String a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    Object localObject = paramString;
    if (paramString.contains("qpic.cn/qq_public"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("$1");
      localObject = paramString.replaceAll("/\\d+($|\\?)", ((StringBuilder)localObject).toString());
    }
    return localObject;
  }
  
  private String a(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject1 = paramString;
    if ((!TextUtils.isEmpty(paramString)) && (((String)localObject1).contains("qpic.cn/qq_public")))
    {
      paramString = new int[5];
      String tmp28_27 = paramString;
      tmp28_27[0] = '´';
      String tmp34_28 = tmp28_27;
      tmp34_28[1] = 'È';
      String tmp40_34 = tmp34_28;
      tmp40_34[2] = 320;
      String tmp46_40 = tmp40_34;
      tmp46_40[3] = 600;
      String tmp52_46 = tmp46_40;
      tmp52_46[4] = 900;
      tmp52_46;
      int i1 = 0;
      while (i1 < paramString.length)
      {
        if (paramInt1 - 20 <= paramString[i1])
        {
          paramString = a((String)localObject1, paramString[i1]);
          break label106;
        }
        i1 += 1;
      }
      paramString = (String)localObject1;
      label106:
      double[] arrayOfDouble1 = new double[15];
      double[] tmp114_112 = arrayOfDouble1;
      tmp114_112[0] = 0.62105D;
      double[] tmp120_114 = tmp114_112;
      tmp120_114[1] = 0.83158D;
      double[] tmp126_120 = tmp120_114;
      tmp126_120[2] = 0.93684D;
      double[] tmp132_126 = tmp126_120;
      tmp132_126[3] = 1.0D;
      double[] tmp136_132 = tmp132_126;
      tmp136_132[4] = 1.1049D;
      double[] tmp142_136 = tmp136_132;
      tmp142_136[5] = 1.11579D;
      double[] tmp148_142 = tmp142_136;
      tmp148_142[6] = 1.24476D;
      double[] tmp155_148 = tmp148_142;
      tmp155_148[7] = 1.25263D;
      double[] tmp162_155 = tmp155_148;
      tmp162_155[8] = 1.30526D;
      double[] tmp169_162 = tmp162_155;
      tmp169_162[9] = 1.66434D;
      double[] tmp176_169 = tmp169_162;
      tmp176_169[10] = 1.67368D;
      double[] tmp183_176 = tmp176_169;
      tmp183_176[11] = 1.80723D;
      double[] tmp190_183 = tmp183_176;
      tmp190_183[12] = 1.88421D;
      double[] tmp197_190 = tmp190_183;
      tmp197_190[13] = 2.5035D;
      double[] tmp204_197 = tmp197_190;
      tmp204_197[14] = 2.51579D;
      tmp204_197;
      String[] arrayOfString1 = new String[15];
      arrayOfString1[0] = "59_95";
      arrayOfString1[1] = "79_95";
      arrayOfString1[2] = "89_95";
      arrayOfString1[3] = "280_280";
      arrayOfString1[4] = "158_143";
      arrayOfString1[5] = "212_190";
      arrayOfString1[6] = "178_143";
      arrayOfString1[7] = "119_95";
      arrayOfString1[8] = "248_190";
      arrayOfString1[9] = "238_143";
      arrayOfString1[10] = "159_95";
      arrayOfString1[11] = "750_415";
      arrayOfString1[12] = "179_95";
      arrayOfString1[13] = "358_143";
      arrayOfString1[14] = "239_95";
      double[] arrayOfDouble2 = new double[5];
      double[] tmp325_323 = arrayOfDouble2;
      tmp325_323[0] = 0.5625D;
      double[] tmp331_325 = tmp325_323;
      tmp331_325[1] = 0.75D;
      double[] tmp337_331 = tmp331_325;
      tmp337_331[2] = 1.0D;
      double[] tmp341_337 = tmp337_331;
      tmp341_337[3] = 1.33333D;
      double[] tmp347_341 = tmp341_337;
      tmp347_341[4] = 1.77777D;
      tmp347_341;
      String[] arrayOfString2 = new String[5];
      arrayOfString2[0] = "90_160";
      arrayOfString2[1] = "30_40";
      arrayOfString2[2] = "280_280";
      arrayOfString2[3] = "40_30";
      arrayOfString2[4] = "160_90";
      if (!paramString.contains("_open"))
      {
        localObject1 = paramString;
        if (!paramString.contains("_vsmcut")) {}
      }
      else
      {
        localObject1 = paramString;
        if (!paramString.contains("_open_"))
        {
          if (paramString.contains("_vsmcut_")) {
            return paramString;
          }
          double d1 = paramInt1;
          double d2 = paramInt2;
          Double.isNaN(d1);
          Double.isNaN(d2);
          d1 /= d2;
          localObject1 = "";
          if (paramString.contains("_open"))
          {
            if (d1 < arrayOfDouble1[0]) {
              localObject1 = arrayOfString1[0];
            }
            localObject2 = localObject1;
            if (d1 > arrayOfDouble1[(arrayOfDouble1.length - 1)]) {
              localObject2 = arrayOfString1[(arrayOfString1.length - 1)];
            }
            paramInt1 = 0;
            for (;;)
            {
              localObject1 = localObject2;
              if (paramInt1 >= arrayOfDouble1.length - 1) {
                break;
              }
              if (d1 >= arrayOfDouble1[paramInt1])
              {
                paramInt2 = paramInt1 + 1;
                if (d1 < arrayOfDouble1[paramInt2])
                {
                  if (d1 - arrayOfDouble1[paramInt1] < arrayOfDouble1[paramInt2] - d1)
                  {
                    localObject1 = arrayOfString1[paramInt1];
                    break;
                  }
                  localObject1 = arrayOfString1[paramInt2];
                  break;
                }
              }
              paramInt1 += 1;
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("_open_");
            ((StringBuilder)localObject2).append((String)localObject1);
            return paramString.replace("_open", ((StringBuilder)localObject2).toString());
          }
          paramInt2 = 0;
          Object localObject2 = localObject1;
          if (d1 < arrayOfDouble2[0]) {
            localObject2 = arrayOfString2[0];
          }
          paramInt1 = paramInt2;
          if (d1 > arrayOfDouble2[(arrayOfDouble2.length - 1)])
          {
            localObject2 = arrayOfString2[(arrayOfString2.length - 1)];
            paramInt1 = paramInt2;
          }
          for (;;)
          {
            localObject1 = localObject2;
            if (paramInt1 >= arrayOfDouble2.length - 1) {
              break;
            }
            if (d1 >= arrayOfDouble2[paramInt1])
            {
              paramInt2 = paramInt1 + 1;
              if (d1 < arrayOfDouble2[paramInt2])
              {
                if (d1 - arrayOfDouble2[paramInt1] < arrayOfDouble2[paramInt2] - d1)
                {
                  localObject1 = arrayOfString2[paramInt1];
                  break;
                }
                localObject1 = arrayOfString2[paramInt2];
                break;
              }
            }
            paramInt1 += 1;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("_vsmcut_");
          ((StringBuilder)localObject2).append((String)localObject1);
          localObject1 = paramString.replace("_vsmcut", ((StringBuilder)localObject2).toString());
        }
      }
      return localObject1;
    }
    return localObject1;
  }
  
  private void a(int paramInt, float paramFloat1, float paramFloat2, ViewGroup.LayoutParams paramLayoutParams)
  {
    paramFloat1 /= paramFloat2;
    double d = paramFloat1;
    if (d < 0.667D)
    {
      paramLayoutParams.width = (paramInt * 2 / 3);
      paramLayoutParams.height = paramInt;
      setCornerText(HardCodeUtil.a(2131900528));
      return;
    }
    if ((0.667D <= d) && (d <= 1.5D))
    {
      paramLayoutParams.width = ((int)(paramInt * paramFloat1));
      paramLayoutParams.height = paramInt;
      setCornerText("");
      return;
    }
    d = paramInt;
    Double.isNaN(d);
    paramLayoutParams.width = ((int)(d * 1.5D));
    paramLayoutParams.height = paramInt;
    setCornerText(HardCodeUtil.a(2131900528));
  }
  
  private void a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, ViewGroup.LayoutParams paramLayoutParams)
  {
    paramFloat1 /= paramFloat2;
    if (this.c != null)
    {
      double d = paramFloat1;
      if (d < 0.455D)
      {
        paramLayoutParams.width = paramInt2;
        paramLayoutParams.height = paramInt1;
        paramLayoutParams = this.c;
        if (this.h) {
          paramInt1 = 2131900482;
        } else {
          paramInt1 = 2131900515;
        }
        paramLayoutParams.setText(HardCodeUtil.a(paramInt1));
        this.c.setVisibility(0);
        return;
      }
      if ((0.455D <= d) && (d <= 0.7441D))
      {
        paramLayoutParams.width = paramInt2;
        paramLayoutParams.height = paramInt1;
        if (this.h)
        {
          this.c.setVisibility(0);
          this.c.setText(HardCodeUtil.a(2131900454));
          return;
        }
        this.c.setVisibility(4);
        return;
      }
      if ((0.7441D <= d) && (d <= 1.3439D))
      {
        paramLayoutParams.width = paramInt1;
        paramLayoutParams.height = paramInt1;
        if (this.h)
        {
          this.c.setVisibility(0);
          this.c.setText(HardCodeUtil.a(2131900459));
          return;
        }
        this.c.setVisibility(4);
        return;
      }
      if ((1.3439D <= d) && (d <= 2.2D))
      {
        paramLayoutParams.width = paramInt1;
        paramLayoutParams.height = paramInt2;
        if (this.h)
        {
          this.c.setVisibility(0);
          this.c.setText(HardCodeUtil.a(2131900445));
          return;
        }
        this.c.setVisibility(4);
        return;
      }
      paramLayoutParams.width = paramInt1;
      paramLayoutParams.height = paramInt2;
      paramLayoutParams = this.c;
      if (this.h) {
        paramInt1 = 2131900460;
      } else {
        paramInt1 = 2131900467;
      }
      paramLayoutParams.setText(HardCodeUtil.a(paramInt1));
      this.c.setVisibility(0);
    }
  }
  
  private void a(int paramInt, PGCPicInfo paramPGCPicInfo)
  {
    if ((paramInt != this.n) || (this.q == 0))
    {
      if ((paramInt == this.n) && (a(paramPGCPicInfo)))
      {
        QLog.d("ComponentPGCShortContentBig", 1, "reuse video");
        return;
      }
      QLog.d("ComponentPGCShortContentBig", 2, "recreate video");
      if (this.j != null)
      {
        QLog.d("gifvideo.ComponentPGCShortContentBig", 1, "reset destroy");
        this.j.d();
      }
      this.j = MediaViewFactory.a(paramInt, BaseApplicationImpl.getContext());
      if (paramInt == 1)
      {
        ((VideoView)this.j).setUseVid(false);
        ((VideoView)this.j).setShowVideoMask(false);
      }
      if ((this.j instanceof View))
      {
        this.k.removeAllViews();
        if (this.o == null) {
          this.o = new ViewGroup.LayoutParams(-2, -2);
        }
        this.k.addView((View)this.j, this.o);
      }
      this.n = paramInt;
    }
  }
  
  private void a(String paramString)
  {
    Object localObject = this.j;
    if ((localObject != null) && ((localObject instanceof VideoView)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("set url ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("gifvideo.ComponentPGCShortContentBig", 1, ((StringBuilder)localObject).toString());
      VideoPredownloadManager.a(paramString);
      ((MediaVideoView)this.j).setVideoUrl(paramString);
      if (k()) {
        ((MediaVideoView)this.j).openVideo();
      }
      if (VideoPredownloadManager.b(paramString)) {
        QLog.d("ComponentPGCShortContentBig", 2, "preload cache hit");
      }
      if (((MediaVideoView)this.j).getAction() == 3) {
        ((MediaVideoView)this.j).startPlay();
      }
    }
  }
  
  private boolean a(PGCPicInfo paramPGCPicInfo)
  {
    Object localObject = this.j;
    if ((localObject instanceof VideoView))
    {
      localObject = (VideoView)localObject;
      return (paramPGCPicInfo != null) && (paramPGCPicInfo.i != null) && (paramPGCPicInfo.i.e != null) && (paramPGCPicInfo.i.e.equals(((VideoView)localObject).getVideoVid()));
    }
    if ((localObject instanceof GifView)) {
      return ((GifView)localObject).isPlaying() ^ true;
    }
    return false;
  }
  
  public static void g()
  {
    f = Aladdin.getConfig(174).getIntegerFromString("gif_playmode", 1);
  }
  
  private static Drawable getLoadingDrawable()
  {
    if (z == null) {
      z = BaseApplicationImpl.getApplication().getResources().getDrawable(2130842737);
    }
    return z;
  }
  
  private static Drawable getTransparentDrawable()
  {
    if (A == null) {
      A = BaseApplicationImpl.getApplication().getResources().getDrawable(2130853313);
    }
    return A;
  }
  
  private void h()
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.r = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    i();
    j();
  }
  
  private void i()
  {
    this.p = Aladdin.getConfig(205).getIntegerFromString("shortcontent_gif_video_type", 0);
    this.q = Aladdin.getConfig(212).getIntegerFromString("shortcontent_video_reuse", 0);
  }
  
  private void j()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(269);
    if (localAladdinConfig != null)
    {
      g = localAladdinConfig.getString("shortcontent_report_key", "");
      this.s = localAladdinConfig.getFloatFromString("shortcontent_x_multipler", 0.0F);
      this.t = localAladdinConfig.getFloatFromString("shortcontent_divisor", 0.0F);
      this.u = localAladdinConfig.getFloatFromString("shortcontent_long_multiplier", 0.0F);
      this.v = localAladdinConfig.getFloatFromString("shortcontent_width_multiplier", 0.0F);
      this.w = localAladdinConfig.getFloatFromString("shortcontent_long_ratio", 0.0F);
      this.x = localAladdinConfig.getFloatFromString("shortcontent_width_ratio", 0.0F);
      this.y = localAladdinConfig.getIntegerFromString("shortcontent_channel", 0);
    }
  }
  
  private boolean k()
  {
    IMediaView localIMediaView = this.j;
    boolean bool3 = localIMediaView instanceof VideoView;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      int i1 = ((VideoView)localIMediaView).getCurrentState();
      bool1 = bool2;
      if (i1 != 5)
      {
        bool1 = bool2;
        if (i1 != 7)
        {
          bool1 = bool2;
          if (i1 != 6) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private void l()
  {
    if (this.j != null)
    {
      String str1 = b(this.a.a).toString();
      String str2 = a(str1, this.b.getMeasuredWidth(), this.b.getMeasuredHeight());
      this.j.setMediaCoverUrl(str2);
      this.j.setMediaPlayUrl(str1);
    }
  }
  
  private void m()
  {
    if (this.a != null)
    {
      if (this.a.a == null) {
        return;
      }
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (this.a != null)
      {
        localObject1 = localObject2;
        if (this.a.a != null)
        {
          localObject1 = localObject2;
          if (this.a.a.k() != null)
          {
            localObject1 = localObject2;
            if (this.a.a.k().mSocialFeedInfo != null)
            {
              localObject1 = localObject2;
              if (this.a.a.k().mSocialFeedInfo.t != null)
              {
                localObject1 = localObject2;
                if (this.a.a.k().mSocialFeedInfo.t.a != null) {
                  localObject1 = this.a.a.k().mSocialFeedInfo.t.a;
                }
              }
            }
          }
        }
      }
      this.h = false;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        this.l = ((PGCPicInfo)((List)localObject1).get(0)).a;
        this.m = ((PGCPicInfo)((List)localObject1).get(0)).b;
        if (((PGCPicInfo)((List)localObject1).get(0)).f == 1) {
          this.h = true;
        } else if (this.a.a.k().isUseGif) {
          this.h = true;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("ComponentPGCShortContentBig", 2, "pgc pic info is null");
        }
        if (this.a.a.k().isUseGif) {
          this.h = true;
        }
      }
      this.a.a().k().isShowGif = this.h;
      this.o = this.b.getLayoutParams();
      if (n())
      {
        QLog.d("ComponentPGCShortContentBig", 2, "configOptimizedImageLayoutParams");
        o();
      }
      else
      {
        QLog.d("ComponentPGCShortContentBig", 2, "configDefaultdImageLayoutParams");
        p();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("imageParams.width is ");
      ((StringBuilder)localObject1).append(this.o.width);
      ((StringBuilder)localObject1).append("; imageParams.height is ");
      ((StringBuilder)localObject1).append(this.o.height);
      QLog.d("ComponentPGCSingleImage", 2, ((StringBuilder)localObject1).toString());
      this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.b.setLayoutParams(this.o);
      this.b.setPadding(0, 0, 0, 0);
      ((View)this.j).setLayoutParams(this.o);
      ((View)this.j).setPadding(0, 0, 0, 0);
    }
  }
  
  private boolean n()
  {
    float f1 = this.s;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (f1 != 0.0F)
    {
      bool1 = bool3;
      if (this.t != 0.0F)
      {
        bool1 = bool3;
        if (this.u != 0.0F)
        {
          bool1 = bool3;
          if (this.v != 0.0F)
          {
            bool1 = bool3;
            if (this.w != 0.0F)
            {
              bool1 = bool3;
              if (this.x != 0.0F)
              {
                if (this.y == 0) {
                  return false;
                }
                long l1;
                if ((this.a != null) && (this.a.a != null) && (this.a.a.k() != null)) {
                  l1 = this.a.a.k().mChannelID;
                } else {
                  l1 = -1L;
                }
                int i1 = this.y;
                if (i1 == 1)
                {
                  if (l1 != 0L)
                  {
                    bool1 = bool2;
                    if (l1 != DailyModeConfigHandler.j()) {}
                  }
                  else
                  {
                    bool1 = true;
                  }
                  return bool1;
                }
                bool1 = bool3;
                if (i1 == 2) {
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private void o()
  {
    int i1 = AIOUtils.b(12.0F, getResources());
    int i2 = AIOUtils.b(4.5F, getResources());
    i1 = (int)((this.r - (i1 * this.s + i2)) / this.t);
    ViewGroup.LayoutParams localLayoutParams = this.o;
    localLayoutParams.height = i1;
    i2 = this.l;
    if (i2 == 0)
    {
      localLayoutParams.width = i1;
      setCornerText("");
      return;
    }
    float f1 = this.m / i2;
    if ((f1 >= this.x) && (f1 <= this.w))
    {
      localLayoutParams.width = ((int)(i1 / f1));
      setCornerText("");
      return;
    }
    if (f1 > this.w)
    {
      this.o.width = ((int)(i1 * this.u));
      setCornerText(HardCodeUtil.a(2131900528));
      return;
    }
    if (f1 < this.x)
    {
      this.o.width = ((int)(i1 * this.v));
      setCornerText(HardCodeUtil.a(2131900528));
    }
  }
  
  private void p()
  {
    int i3 = AIOUtils.b(12.0F, getResources());
    int i1 = AIOUtils.b(4.5F, getResources());
    int i2 = this.r;
    int i4 = i3 * 2;
    i3 = (i2 - (i1 * 2 + i4)) / 3 * 2 + i1;
    i1 = (i2 - (i4 + i1)) / 2;
    if ((this.l == 0) || (this.m == 0))
    {
      this.m = i3;
      this.l = i3;
    }
    if (this.a.a.k().mChannelID == 0L)
    {
      a(ReadInJoyDisplayUtils.a(this.r, getResources()), this.l, this.m, this.o);
      return;
    }
    a(i3, i1, this.l, this.m, this.o);
  }
  
  private void q()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.a != null) && (this.a.a != null))
    {
      if (this.a.a.k() == null) {
        return;
      }
      AbsBaseArticleInfo localAbsBaseArticleInfo = this.a.a.k();
      String str = a(localAbsBaseArticleInfo);
      Object localObject = str;
      if (!TextUtils.isEmpty(str))
      {
        localObject = str;
        if (str.contains("https")) {
          localObject = str.replaceFirst("https", "http");
        }
      }
      localArrayList.add(localObject);
      if ((f == 2) && (this.h))
      {
        if (this.i)
        {
          if (Aladdin.getConfig(192).getIntegerFromString("picture_click_jumptype", 0) == 0)
          {
            if ((this.a != null) && (this.a.a != null) && (this.a.a.u() != null) && (this.a.a.u().a() != null)) {
              TroopNoticeJsHandler.a(this.a.a.u().a(), 0, localArrayList, null, null, false, false, "4", 100, null, null, "");
            }
          }
          else {
            r();
          }
        }
        else
        {
          localObject = this.j;
          if (localObject != null) {
            ((IMediaView)localObject).a();
          }
          this.i = true;
        }
      }
      else if ((this.a != null) && (this.a.a != null) && (this.a.a.u() != null) && (this.a.a.u().a() != null)) {
        TroopNoticeJsHandler.a(this.a.a.u().a(), 0, localArrayList, null, null, false, false, "4", 100, null, null, "");
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[showPicture] isGif ");
      ((StringBuilder)localObject).append(this.h);
      ((StringBuilder)localObject).append(", urls : ");
      ((StringBuilder)localObject).append(localArrayList);
      QLog.d("ComponentPGCShortContentBig", 1, ((StringBuilder)localObject).toString());
      try
      {
        localAbsBaseArticleInfo.clickArea = 9;
        RIJFrameworkReportManager.a(((ReadInJoyBaseAdapter)this.a.a.u()).F().getContext(), localAbsBaseArticleInfo, (int)localAbsBaseArticleInfo.mChannelID);
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        QLog.e("ComponentPGCShortContentBig", 2, localNullPointerException.getLocalizedMessage());
      }
    }
  }
  
  private void r()
  {
    Context localContext = getContext();
    AbsBaseArticleInfo localAbsBaseArticleInfo;
    if ((this.a != null) && (this.a.a != null)) {
      localAbsBaseArticleInfo = this.a.a.k();
    } else {
      localAbsBaseArticleInfo = null;
    }
    PGCShortContentUtils.a(localContext, localAbsBaseArticleInfo);
  }
  
  private void setCornerText(String paramString)
  {
    boolean bool = this.h;
    int i1 = 0;
    if (bool)
    {
      this.c.setVisibility(0);
      this.c.setText(HardCodeUtil.a(2131900457));
      return;
    }
    KanDianRoundCornerTextView localKanDianRoundCornerTextView = this.c;
    if (TextUtils.isEmpty(paramString)) {
      i1 = 4;
    }
    localKanDianRoundCornerTextView.setVisibility(i1);
    this.c.setText(paramString);
  }
  
  private void setMediaInfo(IReadInJoyModel paramIReadInJoyModel)
  {
    if (paramIReadInJoyModel != null)
    {
      paramIReadInJoyModel = paramIReadInJoyModel.k();
      if (paramIReadInJoyModel != null)
      {
        if ((paramIReadInJoyModel.mSocialFeedInfo != null) && (paramIReadInJoyModel.mSocialFeedInfo.t != null) && (paramIReadInJoyModel.mSocialFeedInfo.t.a != null) && (paramIReadInJoyModel.mSocialFeedInfo.t.a.size() > 0))
        {
          paramIReadInJoyModel = (PGCPicInfo)paramIReadInJoyModel.mSocialFeedInfo.t.a.get(0);
          if ((paramIReadInJoyModel.i != null) && (this.p == 1))
          {
            a(1, paramIReadInJoyModel);
            setMediaVideo(paramIReadInJoyModel.i);
          }
          else
          {
            a(0, paramIReadInJoyModel);
            l();
          }
        }
        else
        {
          l();
        }
        this.b.setVisibility(8);
        ((View)this.j).setVisibility(0);
      }
    }
  }
  
  private void setMediaVideo(PGCVideoInfo paramPGCVideoInfo)
  {
    if (paramPGCVideoInfo != null)
    {
      Object localObject = this.j;
      if (localObject != null)
      {
        ((IMediaView)localObject).setMediaPlayVid(paramPGCVideoInfo.e);
        this.j.setMediaPlayUrl(null);
        this.j.setMediaCoverUrl(paramPGCVideoInfo.d);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("set url ");
        ((StringBuilder)localObject).append(null);
        QLog.d("gifvideo.ComponentPGCShortContentBig", 1, ((StringBuilder)localObject).toString());
        if ((this.j instanceof MediaVideoView))
        {
          localObject = ThirdVideoManager.b(paramPGCVideoInfo.e);
          if ((localObject != null) && (((VideoUrlInfo)localObject).a(System.currentTimeMillis() / 1000L, 3600L)))
          {
            a(((VideoUrlInfo)localObject).a);
            QLog.d("gifvideo.ComponentPGCShortContentBig", 1, "url hit");
            return;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("request url by vid ");
          ((StringBuilder)localObject).append(paramPGCVideoInfo.e);
          QLog.d("gifvideo.ComponentPGCShortContentBig", 1, ((StringBuilder)localObject).toString());
          paramPGCVideoInfo = new ComponentPGCShortContentBig.1(this, paramPGCVideoInfo);
          ThreadManager.getFileThreadHandler().post(new ComponentPGCShortContentBig.2(this, paramPGCVideoInfo));
        }
      }
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.k = ((FrameLayout)paramView.findViewById(2131433295));
    this.n = -1;
    a(0, null);
  }
  
  protected void a(IReadInJoyModel paramIReadInJoyModel)
  {
    this.i = false;
    if (this.h)
    {
      setMediaInfo(paramIReadInJoyModel);
    }
    else
    {
      ((View)this.j).setVisibility(8);
      paramIReadInJoyModel = b(paramIReadInJoyModel);
      if (this.b != null)
      {
        this.b.setVisibility(0);
        this.b.setClickable(true);
        this.b.setOnClickListener(this);
      }
      PGCShortContentUtils.a(this.b, getContext(), this.e, paramIReadInJoyModel, new ComponentPGCShortContentBig.3(this, paramIReadInJoyModel));
    }
    ((View)this.j).setClickable(true);
    ((View)this.j).setOnClickListener(this);
  }
  
  protected void a(IReadInJoyModel paramIReadInJoyModel, AbsBaseArticleInfo paramAbsBaseArticleInfo) {}
  
  public void a(Object paramObject)
  {
    g();
    super.a(paramObject);
  }
  
  protected URL b(IReadInJoyModel paramIReadInJoyModel)
  {
    paramIReadInJoyModel = paramIReadInJoyModel.k();
    try
    {
      if (!TextUtils.isEmpty(a(paramIReadInJoyModel))) {
        return new URL(a(paramIReadInJoyModel));
      }
      URL localURL = paramIReadInJoyModel.mSinglePicture;
      return localURL;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      QLog.e("ComponentPGCShortContentBig", 1, localMalformedURLException.getMessage());
    }
    return paramIReadInJoyModel.mSinglePicture;
  }
  
  public void b()
  {
    m();
  }
  
  public boolean c()
  {
    IMediaView localIMediaView = this.j;
    if ((localIMediaView != null) && (this.h) && (!localIMediaView.isPlaying()) && (f == 3))
    {
      localIMediaView = this.j;
      if ((localIMediaView instanceof VideoView)) {
        return ((VideoView)localIMediaView).startPlay();
      }
      localIMediaView.a();
    }
    return false;
  }
  
  public void d()
  {
    IMediaView localIMediaView = this.j;
    if ((localIMediaView != null) && (this.h)) {
      localIMediaView.b();
    }
  }
  
  public void e()
  {
    IMediaView localIMediaView = this.j;
    if ((localIMediaView != null) && (this.h)) {
      localIMediaView.c();
    }
  }
  
  public void f()
  {
    if ((this.j != null) && (this.h))
    {
      QLog.d("gifvideo.ComponentPGCShortContentBig", 1, "destroy play");
      this.j.d();
    }
  }
  
  protected int getClickArea()
  {
    return 9;
  }
  
  protected int getLayoutId()
  {
    return 2131626176;
  }
  
  public void onClick(View paramView)
  {
    if ((Aladdin.getConfig(192).getIntegerFromString("picture_click_jumptype", 0) != 0) && (f != 2)) {
      try
      {
        this.a.a.k().clickArea = getClickArea();
        r();
        RIJFrameworkReportManager.a(((ReadInJoyBaseAdapter)this.a.a.u()).F().getContext(), this.a.a.k(), (int)this.a.a.k().mChannelID);
        return;
      }
      catch (NullPointerException paramView)
      {
        QLog.e("ComponentPGCShortContentBig", 2, paramView.getLocalizedMessage());
        return;
      }
    }
    q();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentPGCShortContentBig
 * JD-Core Version:    0.7.0.1
 */