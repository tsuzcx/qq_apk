package com.tencent.mobileqq.kandian.biz.skin;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout;
import com.tencent.gdtad.statistics.GdtC2SReporter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJProteusOfflineBidSp;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.surfaceviewaction.BaseNode;
import com.tencent.mobileqq.surfaceviewaction.IImageButton;
import com.tencent.mobileqq.surfaceviewaction.ILayer;
import com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder;
import com.tencent.mobileqq.surfaceviewaction.nv.SpriteNativeView;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

public class ReadInJoySkinSlideDownView
  extends RelativeLayout
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  protected MediaPlayer a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  ViewTreeObserver jdField_a_of_type_AndroidViewViewTreeObserver;
  private ILayer jdField_a_of_type_ComTencentMobileqqSurfaceviewactionILayer;
  protected SpriteNativeView a;
  private String jdField_a_of_type_JavaLangString;
  protected boolean a;
  private int jdField_b_of_type_Int;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  
  public ReadInJoySkinSlideDownView(int paramInt1, Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt2, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnClickListener paramOnClickListener3)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener1;
    this.jdField_b_of_type_AndroidViewView$OnClickListener = paramOnClickListener3;
    LayoutInflater.from(getContext()).inflate(2131562709, this);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionNvSpriteNativeView = ((SpriteNativeView)findViewById(2131377644));
    setClickable(true);
    this.jdField_a_of_type_AndroidViewViewTreeObserver = getViewTreeObserver();
    this.jdField_a_of_type_AndroidViewViewTreeObserver.addOnGlobalLayoutListener(this);
  }
  
  private void a(int paramInt, Context paramContext, String paramString1, String paramString2, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    new SceneBuilder().a(paramString2).a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionNvSpriteNativeView.getWidth()).a(new ReadInJoySkinSlideDownView.3(this, paramOnClickListener1, paramString1, paramInt, paramString2, paramContext, paramOnClickListener2)).a(new ReadInJoySkinSlideDownView.2(this)).a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionNvSpriteNativeView, new ReadInJoySkinSlideDownView.1(this));
  }
  
  private void a(int paramInt1, String paramString, int paramInt2)
  {
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext;
    if ((localObject1 instanceof BaseActivity))
    {
      Object localObject2 = (BaseActivity)localObject1;
      SharedPreUtils.p((Context)localObject1, ((BaseActivity)localObject2).getCurrentAccountUin());
      Object localObject3 = (ReadInJoyRefreshManager)((BaseActivity)localObject2).app.getManager(QQManagerFactory.READ_INJOY_REFRESH_MANAGER);
      localObject1 = ((ReadInJoyRefreshManager)localObject3).a();
      int i = 0;
      localObject2 = ((ReadInJoyRefreshManager)localObject3).a((Context)localObject2, 0);
      localObject3 = new RIJTransMergeKanDianReport.ReportR5Builder();
      try
      {
        ((RIJTransMergeKanDianReport.ReportR5Builder)localObject3).addFolderStatus().addTime().addChannelId(paramInt1).addKandianMode().addKandianModeNew().addTabSource().addSessionId().addSkinVoice(0).addRefreshCategory(2).addAntiCheat();
        TextUtils.isEmpty(paramString);
        ((RIJTransMergeKanDianReport.ReportR5Builder)localObject3).addString("jump_url", paramString);
        ((RIJTransMergeKanDianReport.ReportR5Builder)localObject3).addString("guide_id", (String)localObject1);
        ((RIJTransMergeKanDianReport.ReportR5Builder)localObject3).addInt("jump_url_type", paramInt2);
        paramInt1 = i;
        if (localObject2 != null)
        {
          paramInt1 = i;
          if (((RefreshData)localObject2).isAD) {
            paramInt1 = 1;
          }
        }
        ((RIJTransMergeKanDianReport.ReportR5Builder)localObject3).addInt("ad_page", paramInt1);
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X800969C", "0X800969C", 0, 0, RIJProteusOfflineBidSp.a("default_feeds_proteus_offline_bid"), "", "", ((RIJTransMergeKanDianReport.ReportR5Builder)localObject3).build(), false);
      if ((localObject2 != null) && (((RefreshData)localObject2).isAD) && (((RefreshData)localObject2).adClickReports != null) && (((RefreshData)localObject2).adClickReports.size() > 0)) {
        try
        {
          paramString = new qq_ad_get.QQAdGetRsp.AdInfo();
          long l = ((RefreshData)localObject2).adId.longValue();
          paramString.report_info.trace_info.aid.set(l);
          paramString.report_info.thirdparty_monitor_urls.api_click_monitor_url.set(((RefreshData)localObject2).getUrls(((RefreshData)localObject2).adClickReports));
          GdtC2SReporter.a(1, 1, paramString);
          return;
        }
        catch (NumberFormatException paramString)
        {
          paramString.printStackTrace();
        }
      }
    }
  }
  
  public String a()
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionILayer.a().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (BaseNode)localIterator.next();
      if ((localObject instanceof IImageButton))
      {
        localObject = ((IImageButton)localObject).a();
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals("close")) && (!((String)localObject).equals("open_sound")) && (!((String)localObject).equals("use_skin"))) {
          return localObject;
        }
      }
    }
    return null;
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionNvSpriteNativeView.d();
    }
    MediaPlayer localMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if (localMediaPlayer != null) {
      try
      {
        localMediaPlayer.stop();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ReadInJoySkinSlideDownView", 2, QLog.getStackTraceString(localException));
        }
      }
    }
    if (this.jdField_a_of_type_AndroidViewViewTreeObserver != null)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        if (this.jdField_a_of_type_AndroidViewViewTreeObserver.isAlive()) {
          this.jdField_a_of_type_AndroidViewViewTreeObserver.removeOnGlobalLayoutListener(this);
        }
      }
      else if (this.jdField_a_of_type_AndroidViewViewTreeObserver.isAlive()) {
        this.jdField_a_of_type_AndroidViewViewTreeObserver.removeGlobalOnLayoutListener(this);
      }
      this.jdField_a_of_type_AndroidViewViewTreeObserver = null;
    }
  }
  
  public void b()
  {
    MediaPlayer localMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if (localMediaPlayer != null) {
      try
      {
        localMediaPlayer.pause();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.seekTo(0);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ReadInJoySkinSlideDownView", 2, QLog.getStackTraceString(localException));
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionNvSpriteNativeView.b();
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionNvSpriteNativeView.c();
  }
  
  public void onGlobalLayout()
  {
    if ((!this.jdField_b_of_type_Boolean) && (getWidth() > 0))
    {
      if (getHeight() <= 0) {
        return;
      }
      this.jdField_b_of_type_Boolean = true;
      if (Build.VERSION.SDK_INT >= 16)
      {
        if (this.jdField_a_of_type_AndroidViewViewTreeObserver.isAlive()) {
          this.jdField_a_of_type_AndroidViewViewTreeObserver.removeOnGlobalLayoutListener(this);
        }
      }
      else if (this.jdField_a_of_type_AndroidViewViewTreeObserver.isAlive()) {
        this.jdField_a_of_type_AndroidViewViewTreeObserver.removeGlobalOnLayoutListener(this);
      }
      this.jdField_a_of_type_AndroidViewViewTreeObserver = null;
      a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_b_of_type_AndroidViewView$OnClickListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinSlideDownView
 * JD-Core Version:    0.7.0.1
 */