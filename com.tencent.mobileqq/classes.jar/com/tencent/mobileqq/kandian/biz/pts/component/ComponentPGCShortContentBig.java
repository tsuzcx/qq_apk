package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.content.res.Resources;
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
  public static int a;
  public static String a;
  private float jdField_a_of_type_Float;
  private ViewGroup.LayoutParams jdField_a_of_type_AndroidViewViewGroup$LayoutParams;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private IMediaView jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoMediaIMediaView;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int = 0;
  private float jdField_f_of_type_Float;
  private int jdField_f_of_type_Int = 0;
  private int g;
  private int h = 0;
  
  static
  {
    jdField_a_of_type_Int = Aladdin.getConfig(174).getIntegerFromString("gif_playmode", 1);
    jdField_a_of_type_JavaLangString = "";
  }
  
  public ComponentPGCShortContentBig(Context paramContext)
  {
    super(paramContext);
    g();
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
    if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.a != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.a.a != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.a.a.size() > 0))
    {
      localObject1 = (PGCPicInfo)paramAbsBaseArticleInfo.mSocialFeedInfo.a.a.get(0);
      if (!TextUtils.isEmpty(((PGCPicInfo)localObject1).jdField_b_of_type_JavaLangString))
      {
        localObject1 = ((PGCPicInfo)localObject1).jdField_b_of_type_JavaLangString;
        break label85;
      }
    }
    Object localObject1 = "";
    label85:
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      if ((!TextUtils.isEmpty(paramAbsBaseArticleInfo.gifCoverUrl)) && (this.jdField_a_of_type_Boolean)) {
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
      int i = 0;
      while (i < paramString.length)
      {
        if (paramInt1 - 20 <= paramString[i])
        {
          paramString = a((String)localObject1, paramString[i]);
          break label106;
        }
        i += 1;
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
    double d1 = paramFloat1;
    if (d1 < 0.667D)
    {
      paramLayoutParams.width = (paramInt * 2 / 3);
      paramLayoutParams.height = paramInt;
      b(HardCodeUtil.a(2131702535));
      return;
    }
    if ((0.667D <= d1) && (d1 <= 1.5D))
    {
      paramLayoutParams.width = ((int)(paramInt * paramFloat1));
      paramLayoutParams.height = paramInt;
      b("");
      return;
    }
    d1 = paramInt;
    Double.isNaN(d1);
    paramLayoutParams.width = ((int)(d1 * 1.5D));
    paramLayoutParams.height = paramInt;
    b(HardCodeUtil.a(2131702535));
  }
  
  private void a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, ViewGroup.LayoutParams paramLayoutParams)
  {
    paramFloat1 /= paramFloat2;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView != null)
    {
      double d1 = paramFloat1;
      if (d1 < 0.455D)
      {
        paramLayoutParams.width = paramInt2;
        paramLayoutParams.height = paramInt1;
        paramLayoutParams = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView;
        if (this.jdField_a_of_type_Boolean) {
          paramInt1 = 2131702480;
        } else {
          paramInt1 = 2131702520;
        }
        paramLayoutParams.setText(HardCodeUtil.a(paramInt1));
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setVisibility(0);
        return;
      }
      if ((0.455D <= d1) && (d1 <= 0.7441D))
      {
        paramLayoutParams.width = paramInt2;
        paramLayoutParams.height = paramInt1;
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setText(HardCodeUtil.a(2131702452));
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setVisibility(4);
        return;
      }
      if ((0.7441D <= d1) && (d1 <= 1.3439D))
      {
        paramLayoutParams.width = paramInt1;
        paramLayoutParams.height = paramInt1;
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setText(HardCodeUtil.a(2131702457));
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setVisibility(4);
        return;
      }
      if ((1.3439D <= d1) && (d1 <= 2.2D))
      {
        paramLayoutParams.width = paramInt1;
        paramLayoutParams.height = paramInt2;
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setText(HardCodeUtil.a(2131702442));
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setVisibility(4);
        return;
      }
      paramLayoutParams.width = paramInt1;
      paramLayoutParams.height = paramInt2;
      paramLayoutParams = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView;
      if (this.jdField_a_of_type_Boolean) {
        paramInt1 = 2131702458;
      } else {
        paramInt1 = 2131702465;
      }
      paramLayoutParams.setText(HardCodeUtil.a(paramInt1));
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setVisibility(0);
    }
  }
  
  private void a(int paramInt, PGCPicInfo paramPGCPicInfo)
  {
    if ((paramInt != this.jdField_d_of_type_Int) || (this.jdField_f_of_type_Int == 0))
    {
      if ((paramInt == this.jdField_d_of_type_Int) && (a(paramPGCPicInfo)))
      {
        QLog.d("ComponentPGCShortContentBig", 1, "reuse video");
        return;
      }
      QLog.d("ComponentPGCShortContentBig", 2, "recreate video");
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoMediaIMediaView != null)
      {
        QLog.d("gifvideo.ComponentPGCShortContentBig", 1, "reset destroy");
        this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoMediaIMediaView.d();
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoMediaIMediaView = MediaViewFactory.a(paramInt, BaseApplicationImpl.getContext());
      if (paramInt == 1)
      {
        ((VideoView)this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoMediaIMediaView).setUseVid(false);
        ((VideoView)this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoMediaIMediaView).setShowVideoMask(false);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoMediaIMediaView instanceof View))
      {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
        if (this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams == null) {
          this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams = new ViewGroup.LayoutParams(-2, -2);
        }
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoMediaIMediaView, this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
      }
      this.jdField_d_of_type_Int = paramInt;
    }
  }
  
  private void a(PGCVideoInfo paramPGCVideoInfo)
  {
    if (paramPGCVideoInfo != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoMediaIMediaView;
      if (localObject != null)
      {
        ((IMediaView)localObject).setMediaPlayVid(paramPGCVideoInfo.e);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoMediaIMediaView.setMediaPlayUrl(null);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoMediaIMediaView.setMediaCoverUrl(paramPGCVideoInfo.d);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("set url ");
        ((StringBuilder)localObject).append(null);
        QLog.d("gifvideo.ComponentPGCShortContentBig", 1, ((StringBuilder)localObject).toString());
        if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoMediaIMediaView instanceof MediaVideoView))
        {
          localObject = ThirdVideoManager.a(paramPGCVideoInfo.e);
          if ((localObject != null) && (((VideoUrlInfo)localObject).a(System.currentTimeMillis() / 1000L, 3600L)))
          {
            a(((VideoUrlInfo)localObject).jdField_a_of_type_JavaLangString);
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
  
  private void a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoMediaIMediaView;
    if ((localObject != null) && ((localObject instanceof VideoView)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("set url ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("gifvideo.ComponentPGCShortContentBig", 1, ((StringBuilder)localObject).toString());
      VideoPredownloadManager.a(paramString);
      ((MediaVideoView)this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoMediaIMediaView).setVideoUrl(paramString);
      if (b()) {
        ((MediaVideoView)this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoMediaIMediaView).openVideo();
      }
      if (VideoPredownloadManager.a(paramString)) {
        QLog.d("ComponentPGCShortContentBig", 2, "preload cache hit");
      }
      if (((MediaVideoView)this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoMediaIMediaView).getAction() == 3) {
        ((MediaVideoView)this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoMediaIMediaView).startPlay();
      }
    }
  }
  
  private boolean a(PGCPicInfo paramPGCPicInfo)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoMediaIMediaView;
    if ((localObject instanceof VideoView))
    {
      localObject = (VideoView)localObject;
      return (paramPGCPicInfo != null) && (paramPGCPicInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityPGCVideoInfo != null) && (paramPGCPicInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityPGCVideoInfo.e != null) && (paramPGCPicInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityPGCVideoInfo.e.equals(((VideoView)localObject).getVideoVid()));
    }
    if ((localObject instanceof GifView)) {
      return ((GifView)localObject).isPlaying() ^ true;
    }
    return false;
  }
  
  private void b(IReadInJoyModel paramIReadInJoyModel)
  {
    if (paramIReadInJoyModel != null)
    {
      paramIReadInJoyModel = paramIReadInJoyModel.a();
      if (paramIReadInJoyModel != null)
      {
        if ((paramIReadInJoyModel.mSocialFeedInfo != null) && (paramIReadInJoyModel.mSocialFeedInfo.a != null) && (paramIReadInJoyModel.mSocialFeedInfo.a.a != null) && (paramIReadInJoyModel.mSocialFeedInfo.a.a.size() > 0))
        {
          paramIReadInJoyModel = (PGCPicInfo)paramIReadInJoyModel.mSocialFeedInfo.a.a.get(0);
          if ((paramIReadInJoyModel.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityPGCVideoInfo != null) && (this.jdField_e_of_type_Int == 1))
          {
            a(1, paramIReadInJoyModel);
            a(paramIReadInJoyModel.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityPGCVideoInfo);
          }
          else
          {
            a(0, paramIReadInJoyModel);
            j();
          }
        }
        else
        {
          j();
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setVisibility(8);
        ((View)this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoMediaIMediaView).setVisibility(0);
      }
    }
  }
  
  private void b(String paramString)
  {
    boolean bool = this.jdField_a_of_type_Boolean;
    int i = 0;
    if (bool)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setText(HardCodeUtil.a(2131702455));
      return;
    }
    KanDianRoundCornerTextView localKanDianRoundCornerTextView = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView;
    if (TextUtils.isEmpty(paramString)) {
      i = 4;
    }
    localKanDianRoundCornerTextView.setVisibility(i);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setText(paramString);
  }
  
  private boolean b()
  {
    IMediaView localIMediaView = this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoMediaIMediaView;
    boolean bool3 = localIMediaView instanceof VideoView;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      int i = ((VideoView)localIMediaView).getCurrentState();
      bool1 = bool2;
      if (i != 5)
      {
        bool1 = bool2;
        if (i != 7)
        {
          bool1 = bool2;
          if (i != 6) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean c()
  {
    float f1 = this.jdField_a_of_type_Float;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (f1 != 0.0F)
    {
      bool1 = bool3;
      if (this.jdField_b_of_type_Float != 0.0F)
      {
        bool1 = bool3;
        if (this.jdField_c_of_type_Float != 0.0F)
        {
          bool1 = bool3;
          if (this.jdField_d_of_type_Float != 0.0F)
          {
            bool1 = bool3;
            if (this.jdField_e_of_type_Float != 0.0F)
            {
              bool1 = bool3;
              if (this.jdField_f_of_type_Float != 0.0F)
              {
                if (this.h == 0) {
                  return false;
                }
                long l;
                if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a() != null)) {
                  l = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().mChannelID;
                } else {
                  l = -1L;
                }
                int i = this.h;
                if (i == 1)
                {
                  if (l != 0L)
                  {
                    bool1 = bool2;
                    if (l != DailyModeConfigHandler.b()) {}
                  }
                  else
                  {
                    bool1 = true;
                  }
                  return bool1;
                }
                bool1 = bool3;
                if (i == 2) {
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
  
  public static void f()
  {
    jdField_a_of_type_Int = Aladdin.getConfig(174).getIntegerFromString("gif_playmode", 1);
  }
  
  private void g()
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.g = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    h();
    i();
  }
  
  private void h()
  {
    this.jdField_e_of_type_Int = Aladdin.getConfig(205).getIntegerFromString("shortcontent_gif_video_type", 0);
    this.jdField_f_of_type_Int = Aladdin.getConfig(212).getIntegerFromString("shortcontent_video_reuse", 0);
  }
  
  private void i()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(269);
    if (localAladdinConfig != null)
    {
      jdField_a_of_type_JavaLangString = localAladdinConfig.getString("shortcontent_report_key", "");
      this.jdField_a_of_type_Float = localAladdinConfig.getFloatFromString("shortcontent_x_multipler", 0.0F);
      this.jdField_b_of_type_Float = localAladdinConfig.getFloatFromString("shortcontent_divisor", 0.0F);
      this.jdField_c_of_type_Float = localAladdinConfig.getFloatFromString("shortcontent_long_multiplier", 0.0F);
      this.jdField_d_of_type_Float = localAladdinConfig.getFloatFromString("shortcontent_width_multiplier", 0.0F);
      this.jdField_e_of_type_Float = localAladdinConfig.getFloatFromString("shortcontent_long_ratio", 0.0F);
      this.jdField_f_of_type_Float = localAladdinConfig.getFloatFromString("shortcontent_width_ratio", 0.0F);
      this.h = localAladdinConfig.getIntegerFromString("shortcontent_channel", 0);
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoMediaIMediaView != null)
    {
      String str1 = a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a).toString();
      String str2 = a(str1, this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.getMeasuredWidth(), this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.getMeasuredHeight());
      this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoMediaIMediaView.setMediaCoverUrl(str2);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoMediaIMediaView.setMediaPlayUrl(str1);
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a == null) {
        return;
      }
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a != null)
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a() != null)
          {
            localObject1 = localObject2;
            if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().mSocialFeedInfo != null)
            {
              localObject1 = localObject2;
              if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().mSocialFeedInfo.a != null)
              {
                localObject1 = localObject2;
                if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().mSocialFeedInfo.a.a != null) {
                  localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().mSocialFeedInfo.a.a;
                }
              }
            }
          }
        }
      }
      this.jdField_a_of_type_Boolean = false;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        this.jdField_b_of_type_Int = ((PGCPicInfo)((List)localObject1).get(0)).jdField_a_of_type_Int;
        this.jdField_c_of_type_Int = ((PGCPicInfo)((List)localObject1).get(0)).jdField_b_of_type_Int;
        if (((PGCPicInfo)((List)localObject1).get(0)).jdField_c_of_type_Int == 1) {
          this.jdField_a_of_type_Boolean = true;
        } else if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().isUseGif) {
          this.jdField_a_of_type_Boolean = true;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("ComponentPGCShortContentBig", 2, "pgc pic info is null");
        }
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().isUseGif) {
          this.jdField_a_of_type_Boolean = true;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a().a().isShowGif = this.jdField_a_of_type_Boolean;
      this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.getLayoutParams();
      if (c())
      {
        QLog.d("ComponentPGCShortContentBig", 2, "configOptimizedImageLayoutParams");
        l();
      }
      else
      {
        QLog.d("ComponentPGCShortContentBig", 2, "configDefaultdImageLayoutParams");
        m();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("imageParams.width is ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.width);
      ((StringBuilder)localObject1).append("; imageParams.height is ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.height);
      QLog.d("ComponentPGCSingleImage", 2, ((StringBuilder)localObject1).toString());
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setLayoutParams(this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setPadding(0, 0, 0, 0);
      ((View)this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoMediaIMediaView).setLayoutParams(this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
      ((View)this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoMediaIMediaView).setPadding(0, 0, 0, 0);
    }
  }
  
  private void l()
  {
    int i = AIOUtils.b(12.0F, getResources());
    int j = AIOUtils.b(4.5F, getResources());
    i = (int)((this.g - (i * this.jdField_a_of_type_Float + j)) / this.jdField_b_of_type_Float);
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams;
    localLayoutParams.height = i;
    j = this.jdField_b_of_type_Int;
    if (j == 0)
    {
      localLayoutParams.width = i;
      b("");
      return;
    }
    float f1 = this.jdField_c_of_type_Int / j;
    if ((f1 >= this.jdField_f_of_type_Float) && (f1 <= this.jdField_e_of_type_Float))
    {
      localLayoutParams.width = ((int)(i / f1));
      b("");
      return;
    }
    if (f1 > this.jdField_e_of_type_Float)
    {
      this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.width = ((int)(i * this.jdField_c_of_type_Float));
      b(HardCodeUtil.a(2131702535));
      return;
    }
    if (f1 < this.jdField_f_of_type_Float)
    {
      this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.width = ((int)(i * this.jdField_d_of_type_Float));
      b(HardCodeUtil.a(2131702535));
    }
  }
  
  private void m()
  {
    int k = AIOUtils.b(12.0F, getResources());
    int i = AIOUtils.b(4.5F, getResources());
    int j = this.g;
    int m = k * 2;
    k = (j - (i * 2 + m)) / 3 * 2 + i;
    i = (j - (m + i)) / 2;
    if ((this.jdField_b_of_type_Int == 0) || (this.jdField_c_of_type_Int == 0))
    {
      this.jdField_c_of_type_Int = k;
      this.jdField_b_of_type_Int = k;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().mChannelID == 0L)
    {
      a(ReadInJoyDisplayUtils.a(this.g, getResources()), this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
      return;
    }
    a(k, i, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
  }
  
  private void n()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a() == null) {
        return;
      }
      AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a();
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
      if ((jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_Boolean))
      {
        if (this.jdField_b_of_type_Boolean)
        {
          if (Aladdin.getConfig(192).getIntegerFromString("picture_click_jumptype", 0) == 0)
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().a() != null)) {
              TroopNoticeJsHandler.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().a(), 0, localArrayList, null, null, false, false, "4", 100, null, null, "");
            }
          }
          else {
            o();
          }
        }
        else
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoMediaIMediaView;
          if (localObject != null) {
            ((IMediaView)localObject).a();
          }
          this.jdField_b_of_type_Boolean = true;
        }
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().a() != null)) {
        TroopNoticeJsHandler.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().a(), 0, localArrayList, null, null, false, false, "4", 100, null, null, "");
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[showPicture] isGif ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject).append(", urls : ");
      ((StringBuilder)localObject).append(localArrayList);
      QLog.d("ComponentPGCShortContentBig", 1, ((StringBuilder)localObject).toString());
      try
      {
        localAbsBaseArticleInfo.clickArea = 9;
        RIJFrameworkReportManager.a(((ReadInJoyBaseAdapter)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a()).a().getContext(), localAbsBaseArticleInfo, (int)localAbsBaseArticleInfo.mChannelID);
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        QLog.e("ComponentPGCShortContentBig", 2, localNullPointerException.getLocalizedMessage());
      }
    }
  }
  
  private void o()
  {
    Context localContext = getContext();
    AbsBaseArticleInfo localAbsBaseArticleInfo;
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a != null)) {
      localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a();
    } else {
      localAbsBaseArticleInfo = null;
    }
    PGCShortContentUtils.a(localContext, localAbsBaseArticleInfo);
  }
  
  protected int a()
  {
    return 2131560129;
  }
  
  protected URL a(IReadInJoyModel paramIReadInJoyModel)
  {
    paramIReadInJoyModel = paramIReadInJoyModel.a();
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
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131366941));
    this.jdField_d_of_type_Int = -1;
    a(0, null);
  }
  
  protected void a(IReadInJoyModel paramIReadInJoyModel)
  {
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_Boolean)
    {
      b(paramIReadInJoyModel);
    }
    else
    {
      ((View)this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoMediaIMediaView).setVisibility(8);
      paramIReadInJoyModel = a(paramIReadInJoyModel);
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setClickable(true);
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setOnClickListener(this);
      }
      PGCShortContentUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, getContext(), this.jdField_a_of_type_JavaNetURL, paramIReadInJoyModel, new ComponentPGCShortContentBig.3(this, paramIReadInJoyModel));
    }
    ((View)this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoMediaIMediaView).setClickable(true);
    ((View)this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoMediaIMediaView).setOnClickListener(this);
  }
  
  protected void a(IReadInJoyModel paramIReadInJoyModel, AbsBaseArticleInfo paramAbsBaseArticleInfo) {}
  
  public void a(Object paramObject)
  {
    f();
    super.a(paramObject);
  }
  
  public boolean a()
  {
    IMediaView localIMediaView = this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoMediaIMediaView;
    if ((localIMediaView != null) && (this.jdField_a_of_type_Boolean) && (!localIMediaView.isPlaying()) && (jdField_a_of_type_Int == 3))
    {
      localIMediaView = this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoMediaIMediaView;
      if ((localIMediaView instanceof VideoView)) {
        return ((VideoView)localIMediaView).startPlay();
      }
      localIMediaView.a();
    }
    return false;
  }
  
  protected int b()
  {
    return 9;
  }
  
  public void b()
  {
    k();
  }
  
  public void c()
  {
    IMediaView localIMediaView = this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoMediaIMediaView;
    if ((localIMediaView != null) && (this.jdField_a_of_type_Boolean)) {
      localIMediaView.b();
    }
  }
  
  public void d()
  {
    IMediaView localIMediaView = this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoMediaIMediaView;
    if ((localIMediaView != null) && (this.jdField_a_of_type_Boolean)) {
      localIMediaView.c();
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoMediaIMediaView != null) && (this.jdField_a_of_type_Boolean))
    {
      QLog.d("gifvideo.ComponentPGCShortContentBig", 1, "destroy play");
      this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoMediaIMediaView.d();
    }
  }
  
  public void onClick(View paramView)
  {
    if ((Aladdin.getConfig(192).getIntegerFromString("picture_click_jumptype", 0) != 0) && (jdField_a_of_type_Int != 2)) {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().clickArea = b();
        o();
        RIJFrameworkReportManager.a(((ReadInJoyBaseAdapter)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a()).a().getContext(), this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a(), (int)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().mChannelID);
        return;
      }
      catch (NullPointerException paramView)
      {
        QLog.e("ComponentPGCShortContentBig", 2, paramView.getLocalizedMessage());
        return;
      }
    }
    n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentPGCShortContentBig
 * JD-Core Version:    0.7.0.1
 */