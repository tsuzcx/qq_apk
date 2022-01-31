package dov.com.qq.im.capture;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import ankh;
import anki;
import ankj;
import ankk;
import ankl;
import ankm;
import anko;
import ankp;
import ankq;
import ankr;
import anks;
import ankt;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.common.app.AppInterface;
import com.tencent.image.ApngImage;
import com.tencent.image.NativeGifImage;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.richmedia.FlowCameraConstant;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.shortvideo.dancegame.DanceGameVideoManager;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.ptvfilter.QQSharpFaceFilter;
import com.tencent.mobileqq.statistics.QIMReportController;
import com.tencent.mobileqq.statistics.reportitem.QIMReadWriteReportItem;
import com.tencent.mobileqq.troop.widget.RedDotImageView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.util.VideoPrefsUtil;
import dov.com.qq.im.QIMSegmentCaptureManager;
import dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter;
import dov.com.qq.im.capture.banner.QIMCaptureBannerManager;
import dov.com.qq.im.capture.data.CaptureComboManager.CaptureRecord;
import dov.com.qq.im.capture.data.CaptureComboObeserver;
import dov.com.qq.im.capture.music.CaptureConfigUpdateObserver;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.music.QimMusicPlayer;
import dov.com.qq.im.capture.poi.FacePoiManager;
import dov.com.qq.im.capture.poi.FacePoiSearchUI;
import dov.com.qq.im.capture.poi.FacePoiSearchUI.FacePoiSearchUIListener;
import dov.com.qq.im.capture.poi.FacePoiUI;
import dov.com.qq.im.capture.poi.FacePoiUI.FacePoiUIListener;
import dov.com.qq.im.capture.util.DoodleLayoutConnector;
import dov.com.qq.im.capture.view.MusicProviderView;
import dov.com.qq.im.capture.view.ProviderView.ProviderViewListener;
import dov.com.qq.im.capture.view.ProviderViewEditContainer;
import dov.com.qq.im.capture.view.QIMProviderContainerView;
import dov.com.qq.im.setting.ICameraEntrance;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPoiPickerCallback;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.DynamicFaceLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.EmptyLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.DoodleEventListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.LocationFacePackage.Item;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;
import dov.com.tencent.mobileqq.activity.richmedia.view.GLVideoClipUtil;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayout;

@TargetApi(17)
public class QIMCaptureController
  implements ProviderView.ProviderViewListener, DoodleLayout.DoodleEventListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  public AppInterface a;
  private final EffectsCameraCaptureView jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView;
  private QIMCaptureController.NotifyQIMFlowCameraActivity jdField_a_of_type_DovComQqImCaptureQIMCaptureController$NotifyQIMFlowCameraActivity;
  public CaptureComboObeserver a;
  CaptureConfigUpdateObserver jdField_a_of_type_DovComQqImCaptureMusicCaptureConfigUpdateObserver = new anko(this);
  private FacePoiSearchUI.FacePoiSearchUIListener jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI$FacePoiSearchUIListener = new ankk(this);
  private FacePoiSearchUI jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI;
  private FacePoiUI.FacePoiUIListener jdField_a_of_type_DovComQqImCapturePoiFacePoiUI$FacePoiUIListener = new ankj(this);
  private FacePoiUI jdField_a_of_type_DovComQqImCapturePoiFacePoiUI;
  private ProviderViewEditContainer jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer;
  public QIMProviderContainerView a;
  ICameraEntrance jdField_a_of_type_DovComQqImSettingICameraEntrance;
  private EditVideoPoiPickerCallback jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPoiPickerCallback = new anki(this);
  public DoodleLayout a;
  private QIMCameraCaptureButtonLayout jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout;
  public boolean a;
  private int jdField_b_of_type_Int = -1;
  private View jdField_b_of_type_AndroidViewView;
  private ViewStub jdField_b_of_type_AndroidViewViewStub;
  private QIMCameraCaptureButtonLayout jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout;
  private boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int = -1;
  private View jdField_c_of_type_AndroidViewView;
  private QIMCameraCaptureButtonLayout jdField_c_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  
  public QIMCaptureController(AppInterface paramAppInterface, View paramView, ICameraEntrance paramICameraEntrance)
  {
    this.jdField_a_of_type_DovComQqImCaptureDataCaptureComboObeserver = new anks(this);
    if (paramView == null) {
      throw new IllegalStateException("rootView is null");
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_DovComQqImSettingICameraEntrance = paramICameraEntrance;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView = ((EffectsCameraCaptureView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366945));
    this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView = ((QIMProviderContainerView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368982));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131368983));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131369008);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365911);
    this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout = ((QIMCameraCaptureButtonLayout)paramView.findViewById(2131368954));
    this.jdField_c_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout = ((QIMCameraCaptureButtonLayout)paramView.findViewById(2131368955));
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout = this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiUI = new FacePoiUI();
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiUI.a(this.jdField_a_of_type_DovComQqImCapturePoiFacePoiUI$FacePoiUIListener);
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiUI.a(paramView);
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI = new FacePoiSearchUI();
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI.a(this.jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI$FacePoiSearchUIListener);
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI.a(paramView);
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.registObserver(this.jdField_a_of_type_DovComQqImCaptureMusicCaptureConfigUpdateObserver);
    }
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CaptureController", 2, "removeBannerEntranceTip...");
    }
    if (paramViewGroup != null)
    {
      View localView = paramViewGroup.findViewById(2131362500);
      if (localView != null)
      {
        paramViewGroup.removeView(localView);
        if (QLog.isColorLevel()) {
          QLog.i("CaptureController", 2, "removeBannerEntranceTip...removed");
        }
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  private void i(boolean paramBoolean)
  {
    RedDotImageView localRedDotImageView = (RedDotImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369015);
    View localView1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131362500);
    View localView2 = this.jdField_a_of_type_AndroidViewView.findViewById(2131362501);
    RelativeLayout.LayoutParams localLayoutParams;
    if (localView2 != null)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)localView2.getLayoutParams();
      if (this.jdField_c_of_type_Boolean) {
        paramBoolean = true;
      }
      if (!paramBoolean) {
        break label163;
      }
      float f = localRedDotImageView.getScaleX();
      int j = localRedDotImageView.getWidth();
      int i = (int)(localRedDotImageView.getLeft() + (1.0F - f) * j / 2.0F);
      j = (int)(j - (1.0F - f) * j);
      int k = localView1.getLeft();
      int m = localView2.getWidth();
      localLayoutParams.removeRule(14);
      localLayoutParams.addRule(5);
      localLayoutParams.leftMargin = (i + j / 2 - m / 2 - k);
    }
    for (;;)
    {
      localView2.setLayoutParams(localLayoutParams);
      return;
      label163:
      localLayoutParams.removeRule(5);
      localLayoutParams.addRule(14);
    }
  }
  
  private void u() {}
  
  private void v() {}
  
  public int a()
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout == null) {
      return 10000;
    }
    return (int)this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.a();
  }
  
  public DoodleLayout a()
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
  }
  
  public void a()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("makeSureInitStub mDoodleLayout:");
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
        break label333;
      }
      bool = true;
      localObject = ((StringBuilder)localObject).append(bool).append(" mEditContainer:");
      if (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) {
        break label338;
      }
    }
    label333:
    label338:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("CaptureController", 2, bool);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null)
      {
        this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131364351));
        this.jdField_a_of_type_AndroidViewViewStub.inflate();
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = ((DoodleLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368981));
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setVisibility(0);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleEventListener(this);
        this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.setCaptureControllerAndPreloadView(this);
        DoodleLayoutConnector.a().a(0, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout);
      }
      if (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer == null)
      {
        this.jdField_b_of_type_AndroidViewViewStub = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131364359));
        this.jdField_b_of_type_AndroidViewViewStub.inflate();
        localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView;
        this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer = ((ProviderViewEditContainer)this.jdField_a_of_type_AndroidViewView.findViewById(2131368996));
        this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a(0);
        this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.setProviderViewListener(this);
        this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.setStickerListener(((DoodleEditView)localObject).a());
        ((DoodleEditView)localObject).setFrom(0);
        ((DoodleEditView)localObject).a(false);
        ((DoodleEditView)localObject).setDoodleEditViewListener(new ankh(this));
        this.jdField_a_of_type_AndroidViewView.findViewById(2131368995).setOnTouchListener(new ankl(this));
      }
      a(true);
      VideoFilterTools.a().a(0);
      ((dov.com.qq.im.capture.data.CaptureComboManager)QIMManager.a(5)).a[0].a((Activity)this.jdField_a_of_type_AndroidViewView.getContext());
      b();
      if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
        this.jdField_a_of_type_ComTencentCommonAppAppInterface.registObserver(this.jdField_a_of_type_DovComQqImCaptureDataCaptureComboObeserver);
      }
      return;
      bool = false;
      break;
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {}
  
  public void a(int paramInt)
  {
    if ((paramInt == 4) || (paramInt == 8))
    {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131369015).setVisibility(paramInt);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131369016).setVisibility(paramInt);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131369018).setVisibility(paramInt);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131369017).setVisibility(paramInt);
      a((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365911));
    }
    while (this.e) {
      return;
    }
    a(false);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    long l = SystemClock.elapsedRealtime();
    if ((1 == paramInt1) && (l - this.jdField_a_of_type_Long > 4000L))
    {
      QQToast.a(this.jdField_a_of_type_AndroidViewView.getContext(), "表情个数已达上限", 0).a();
      this.jdField_a_of_type_Long = l;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.a(paramInt1, paramInt2, paramIntent);
    }
    for (;;)
    {
      if ((paramInt2 == 0) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null)) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b(this.e);
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.d("CaptureController", 2, "onActivityResult null!!!");
      }
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CaptureController", 2, "changeProviderViewStateWithExtra: invoked. info: index = " + paramInt);
    }
    MusicProviderView localMusicProviderView;
    if (paramInt == 104)
    {
      paramObject = (QIMMusicConfigManager)QIMManager.a(2);
      localMusicProviderView = (MusicProviderView)this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.a(MusicProviderView.class);
      if (localMusicProviderView != null) {
        localMusicProviderView.setPreSelectTagIndex(paramObject.a() - 1);
      }
    }
    try
    {
      localMusicProviderView.d();
      return;
    }
    catch (Throwable paramObject)
    {
      QLog.d("CaptureController", 1, String.format("throwable = %s", new Object[] { paramObject }));
    }
  }
  
  @TargetApi(11)
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((paramInt == this.jdField_b_of_type_Int) && (!paramBoolean))
    {
      d();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().d(true);
    }
    for (this.jdField_b_of_type_Int = -1;; this.jdField_b_of_type_Int = paramInt)
    {
      this.jdField_c_of_type_Int = paramInt;
      return;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(true);
      if (this.jdField_b_of_type_Int == -1) {
        a(true, 150);
      }
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController$NotifyQIMFlowCameraActivity != null) {
      this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController$NotifyQIMFlowCameraActivity.a(paramInt, paramVarArgs);
    }
  }
  
  public void a(Bitmap paramBitmap, boolean paramBoolean) {}
  
  public void a(ViewGroup paramViewGroup, Context paramContext)
  {
    if ((paramViewGroup == null) || (paramViewGroup.findViewById(2131362500) != null)) {}
    do
    {
      return;
      localObject1 = (RedDotImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369015);
    } while ((localObject1 == null) || (!(this.jdField_a_of_type_AndroidViewView instanceof RelativeLayout)));
    int i = ((RedDotImageView)localObject1).getLeft();
    int j = ((RedDotImageView)localObject1).getWidth();
    Object localObject1 = new RelativeLayout(paramContext);
    ((RelativeLayout)localObject1).setId(2131362500);
    ((RelativeLayout)localObject1).setOnClickListener(new ankq(this));
    Object localObject2 = new View(paramContext);
    ((View)localObject2).setBackgroundResource(2130841900);
    ((View)localObject2).setId(2131362501);
    ((View)localObject2).setRotation(180.0F);
    AIOUtils.a(13.0F, paramContext.getResources());
    int k = AIOUtils.a(12.0F, paramContext.getResources());
    if (QLog.isColorLevel()) {
      QLog.d("CaptureController", 2, "showBannerEntranceTip : marginLeftOfArrow = " + k);
    }
    Object localObject3 = new RelativeLayout.LayoutParams(AIOUtils.a(13.0F, paramContext.getResources()), AIOUtils.a(7.0F, paramContext.getResources()));
    ((RelativeLayout.LayoutParams)localObject3).addRule(10);
    ((RelativeLayout.LayoutParams)localObject3).addRule(14);
    ((RelativeLayout.LayoutParams)localObject3).leftMargin = k;
    ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    localObject2 = new TextView(paramContext);
    ((TextView)localObject2).setText("不知道怎么玩？看看这里或许会有灵感~");
    localObject3 = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidViewView.getResources(), 2130841899);
    byte[] arrayOfByte = ((Bitmap)localObject3).getNinePatchChunk();
    localObject3 = new NinePatchDrawable(this.jdField_a_of_type_AndroidViewView.getResources(), (Bitmap)localObject3, arrayOfByte, new Rect(0, 0, 0, 0), null);
    k = AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidViewView.getResources());
    ((TextView)localObject2).setBackground((Drawable)localObject3);
    ((TextView)localObject2).setTextColor(-1);
    ((TextView)localObject2).setTextSize(1, 16.0F);
    ((TextView)localObject2).setGravity(17);
    ((TextView)localObject2).setPadding(k, 0, k, 0);
    localObject3 = new RelativeLayout.LayoutParams(-2, AIOUtils.a(36.0F, paramContext.getResources()));
    ((RelativeLayout.LayoutParams)localObject3).addRule(9);
    ((RelativeLayout.LayoutParams)localObject3).addRule(3, 2131362501);
    ((TextView)localObject2).measure(-2, -2);
    k = ((TextView)localObject2).getMeasuredWidth();
    ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    localObject2 = new RelativeLayout.LayoutParams(-2, AIOUtils.a(80.0F, paramContext.getResources()));
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131369015);
    i = i - (k - j) / 2 - AIOUtils.a(15.0F, paramContext.getResources());
    if (i <= 0) {
      this.jdField_c_of_type_Boolean = true;
    }
    for (((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidViewView.getResources());; ((RelativeLayout.LayoutParams)localObject2).leftMargin = i)
    {
      ((RelativeLayout.LayoutParams)localObject2).topMargin = AIOUtils.a(5.0F, this.jdField_a_of_type_AndroidViewView.getResources());
      paramViewGroup.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      if (i <= 0) {
        ((RelativeLayout)localObject1).post(new ankr(this));
      }
      float f = ((RelativeLayout)localObject1).getTranslationY();
      paramViewGroup = ObjectAnimator.ofFloat(localObject1, "translationY", new float[] { f - AIOUtils.a(15.0F, paramContext.getResources()), f });
      paramViewGroup.setDuration(140L);
      paramViewGroup.setInterpolator(new AccelerateDecelerateInterpolator());
      paramContext = ObjectAnimator.ofFloat(localObject1, "alpha", new float[] { 0.0F, 1.0F });
      paramContext.setDuration(140L);
      localObject1 = new AnimatorSet();
      ((AnimatorSet)localObject1).playTogether(new Animator[] { paramViewGroup, paramContext });
      ((AnimatorSet)localObject1).start();
      this.jdField_a_of_type_Boolean = true;
      return;
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  public void a(LocationFacePackage.Item paramItem)
  {
    ((StoryConfigManager)SuperManager.a(10)).b("has_show_add_poi_paster_guide", Boolean.valueOf(true));
  }
  
  public void a(String paramString)
  {
    if (this.jdField_b_of_type_Boolean) {
      VideoPrefsUtil.setMaterialMute(false);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setMovieEffect(paramString);
      }
      if (QLog.isColorLevel()) {
        QLog.d("CaptureController", 2, "onDrawMovieTemplateOnScreen isOriginal" + this.jdField_b_of_type_Boolean);
      }
      return;
      VideoPrefsUtil.setMaterialMute(true);
    }
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (VideoPrefsUtil.getDefaultPrefs() != null) {
      if (this.jdField_b_of_type_Boolean) {
        VideoPrefsUtil.setMaterialMute(false);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CaptureController", 2, "onDrawTemplateOnScreen isOriginal" + this.jdField_b_of_type_Boolean);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setFaceEffect(paramString);
      }
      return;
      VideoPrefsUtil.setMaterialMute(true);
      continue;
      if (QLog.isColorLevel()) {
        QLog.e("CaptureController", 2, "VideoPrefsUtil.getDefaultPrefs is null");
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMCaptureBannerManager", 2, "updateBannerView");
    }
    QIMCaptureBannerManager localQIMCaptureBannerManager = (QIMCaptureBannerManager)QIMManager.a(9);
    RedDotImageView localRedDotImageView = (RedDotImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369015);
    Object localObject = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369016);
    ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369018);
    URLImageView localURLImageView = (URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369017);
    if (localRedDotImageView == null) {
      if (QLog.isColorLevel()) {
        QLog.d("CaptureController", 2, "qim merge do resume");
      }
    }
    label399:
    do
    {
      return;
      if (!((Activity)this.jdField_a_of_type_AndroidViewView.getContext()).getIntent().getBooleanExtra("need_show_banner", true))
      {
        if (QLog.isColorLevel()) {
          QLog.d("CaptureController", 2, "cur page needn't Show banner");
        }
        localRedDotImageView.setVisibility(8);
        ((ImageView)localObject).setVisibility(8);
        localImageView.setVisibility(8);
        localURLImageView.setVisibility(8);
        return;
      }
      boolean bool1 = localQIMCaptureBannerManager.a();
      boolean bool2 = localQIMCaptureBannerManager.f();
      boolean bool3 = localQIMCaptureBannerManager.e();
      boolean bool4 = localQIMCaptureBannerManager.c();
      boolean bool5 = localQIMCaptureBannerManager.d();
      if (QLog.isColorLevel()) {
        QLog.d("CaptureController", 2, "needShowBanner=" + bool1 + ",needShowRedDot=" + bool2 + ",bannerAnimEnableStatus=" + bool3 + ",hasShownBlur=" + bool4 + ",hasShownRedDot=" + bool5);
      }
      if (bool1)
      {
        if ((bool2) && (!bool5))
        {
          localRedDotImageView.setReddotXOffsetDp(10);
          localRedDotImageView.setReddotYOffsetDp(10);
          localRedDotImageView.a(true);
          localRedDotImageView.setVisibility(0);
          if (paramBoolean)
          {
            localObject = new QIMReadWriteReportItem();
            ((QIMReadWriteReportItem)localObject).d = "0X800875B";
            QIMReportController.a(null, (QIMReadWriteReportItem)localObject);
          }
          localRedDotImageView.setLayerType(1, null);
          if ((!bool3) || (bool4)) {
            break label399;
          }
          u();
        }
        for (;;)
        {
          localRedDotImageView.setOnClickListener(new ankm(this, localRedDotImageView, bool1, bool3, localQIMCaptureBannerManager, bool2));
          return;
          localRedDotImageView.a(false);
          break;
          v();
        }
      }
      localRedDotImageView.setVisibility(8);
      ((ImageView)localObject).setVisibility(8);
      localImageView.setVisibility(8);
      localURLImageView.setVisibility(8);
      a((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365911));
    } while (!QLog.isColorLevel());
    QLog.d("CaptureController", 2, "need not Show Banner");
  }
  
  @TargetApi(11)
  public void a(boolean paramBoolean, int paramInt)
  {
    float f = this.jdField_a_of_type_AndroidViewViewGroup.getHeight();
    ObjectAnimator localObjectAnimator;
    if (paramBoolean) {
      localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewViewGroup, "translationY", new float[] { 0.0F, f });
    }
    for (ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.7F, 1.0F, 0.7F, 1, 0.5F, 1, 0.5F);; localScaleAnimation = new ScaleAnimation(0.7F, 1.0F, 0.7F, 1.0F, 1, 0.5F, 1, 0.5F))
    {
      localScaleAnimation.setDuration(paramInt);
      localScaleAnimation.setFillAfter(true);
      localObjectAnimator.setDuration(paramInt).start();
      this.jdField_b_of_type_AndroidViewView.startAnimation(localScaleAnimation);
      return;
      localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewViewGroup, "translationY", new float[] { f, 0.0F });
    }
  }
  
  public void a(byte[] paramArrayOfByte) {}
  
  public boolean a()
  {
    if (this.jdField_a_of_type_DovComQqImCapturePoiFacePoiUI.a())
    {
      this.jdField_a_of_type_DovComQqImCapturePoiFacePoiUI.d();
      return true;
    }
    if (this.jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI.b())
    {
      this.jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI.e();
      return true;
    }
    return false;
  }
  
  public void ay_()
  {
    Activity localActivity = (Activity)this.jdField_a_of_type_AndroidViewView.getContext();
    if ((!MusicProviderView.jdField_a_of_type_Boolean) && (localActivity.getIntent() != null)) {
      localActivity.getIntent().removeExtra("video_tag_info");
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.h();
    }
  }
  
  public void b(int paramInt)
  {
    if ((paramInt == 4) || (paramInt == 8)) {
      e();
    }
    if ((this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer == null) || (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.getVisibility() != 0)) {
      this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.setVisibility(paramInt);
    }
    a(paramInt);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b(int paramInt, Object paramObject)
  {
    if (DanceGameVideoManager.a().c()) {}
    do
    {
      do
      {
        do
        {
          return;
          if (paramInt != 4) {
            break;
          }
        } while ((this.jdField_a_of_type_Int != 0) || (this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() != 0));
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.setVisibility(8);
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        return;
        if (paramInt != 0) {
          break;
        }
      } while (this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() != 8);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.setVisibility(0);
      this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      return;
      if (paramInt == 7)
      {
        if ((this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) && (this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView != null) && (this.jdField_a_of_type_AndroidViewViewGroup != null))
        {
          this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.setVisibility(0);
          this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
          this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.b();
        }
        d();
        return;
      }
    } while (paramInt != 3);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.setVisibility(8);
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    boolean bool;
    EffectsCameraCaptureView localEffectsCameraCaptureView;
    if ((!paramBoolean) || (FlowCameraConstant.jdField_a_of_type_Int != 2) || (!QIMPtvTemplateAdapter.jdField_b_of_type_JavaLangString.equals("0")) || (QIMPtvTemplateAdapter.jdField_b_of_type_Int != 0))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.i) && (paramInt >= 0))
      {
        bool = true;
        QQSharpFaceFilter.jdField_a_of_type_Boolean = bool;
      }
    }
    else
    {
      if ((QLog.isColorLevel()) && (!paramBoolean)) {
        QLog.d("CaptureController", 2, "onDrawSharpFaceFeature level = " + paramInt + ", faceopen:" + QQSharpFaceFilter.jdField_a_of_type_Boolean);
      }
      localEffectsCameraCaptureView = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView;
      if (!QQSharpFaceFilter.jdField_a_of_type_Boolean) {
        break label122;
      }
    }
    for (;;)
    {
      localEffectsCameraCaptureView.a(paramInt, paramBoolean);
      return;
      bool = false;
      break;
      label122:
      paramInt = -1;
    }
  }
  
  public void b(int paramInt, Object... paramVarArgs)
  {
    if ((this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) && (this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView != null) && (this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.getVisibility() != 0) && (this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.a(MusicProviderView.class)))
    {
      this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a(paramInt, paramVarArgs);
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiUI.a();
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiUI.a().a(true);
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiUI.a().a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPoiPickerCallback, paramString);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CaptureController", 2, "updateBannerEntranceTip isDarkMode=" + paramBoolean);
      }
      if ((((QIMCaptureBannerManager)QIMManager.a(9)).a()) && (this.jdField_a_of_type_Boolean))
      {
        RedDotImageView localRedDotImageView = (RedDotImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369015);
        View localView1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131362501);
        View localView2 = this.jdField_a_of_type_AndroidViewView.findViewById(2131362500);
        if ((localRedDotImageView != null) && (localView1 != null) && (localView2 != null)) {
          localRedDotImageView.post(new ankp(this, paramBoolean));
        }
      }
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void c()
  {
    this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.a();
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.unRegistObserver(this.jdField_a_of_type_DovComQqImCaptureMusicCaptureConfigUpdateObserver);
    }
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.unRegistObserver(this.jdField_a_of_type_DovComQqImCaptureDataCaptureComboObeserver);
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
    DoodleLayoutConnector.a().a(0);
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.c() == paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CaptureController", 2, "onDrawBeautyFeature AdvancedProviderView.sBeautyLevel equals to level");
      }
      return;
    }
    if (((FlowCameraConstant.jdField_a_of_type_Int == 2) && (QIMPtvTemplateAdapter.jdField_b_of_type_JavaLangString.equals("0")) && (QIMPtvTemplateAdapter.jdField_b_of_type_Int == 0)) || (GLVideoClipUtil.b()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CaptureController", 2, "onDrawBeautyFeature is in (back_camera && no template is selected) || NightMode is on");
      }
      paramInt = 0;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setBeauty(paramInt);
  }
  
  public void c(boolean paramBoolean)
  {
    boolean bool = true;
    this.jdField_b_of_type_Boolean = paramBoolean;
    QQFilterRenderManager localQQFilterRenderManager;
    if (this.jdField_b_of_type_Boolean)
    {
      VideoPrefsUtil.setMaterialMute(false);
      localQQFilterRenderManager = EffectsCameraCaptureView.a();
      if (localQQFilterRenderManager != null) {
        if (paramBoolean) {
          break label80;
        }
      }
    }
    label80:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localQQFilterRenderManager.c(paramBoolean);
      if (QLog.isColorLevel()) {
        QLog.d("CaptureController", 2, "onPlayVideoMusic isOriginal" + this.jdField_b_of_type_Boolean);
      }
      return;
      VideoPrefsUtil.setMaterialMute(true);
      break;
    }
  }
  
  public boolean c()
  {
    return this.jdField_b_of_type_Int != -1;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.d();
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.f();
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    }
    this.jdField_b_of_type_Int = -1;
  }
  
  public void d(int paramInt)
  {
    if ((this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) && (this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView != null) && (this.jdField_a_of_type_AndroidViewViewGroup != null))
    {
      this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.b();
    }
  }
  
  public void d(boolean paramBoolean)
  {
    MusicProviderView localMusicProviderView = (MusicProviderView)this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.a(MusicProviderView.class);
    MusicItemInfo localMusicItemInfo = ((QimMusicPlayer)QIMManager.a().c(8)).b();
    EffectsCameraCaptureView localEffectsCameraCaptureView = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView;
    if ((paramBoolean) && (localMusicProviderView != null) && ((localMusicItemInfo == null) || (!localMusicItemInfo.b())) && (localMusicProviderView.b())) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localEffectsCameraCaptureView.d(paramBoolean);
      return;
    }
  }
  
  public boolean d()
  {
    if (this.d) {}
    while ((this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) && (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a())) {
      return true;
    }
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.d()))
    {
      b(7, null);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(false);
      return true;
    }
    return false;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.d();
    }
  }
  
  public void e(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.c())) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.s();
    }
  }
  
  public void e(boolean paramBoolean) {}
  
  public void f() {}
  
  public void f(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (QIMCameraCaptureButtonLayout localQIMCameraCaptureButtonLayout = this.jdField_c_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout;; localQIMCameraCaptureButtonLayout = this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout = localQIMCameraCaptureButtonLayout;
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.a();
      return;
    }
  }
  
  public void g(boolean paramBoolean)
  {
    if (this.e != paramBoolean)
    {
      this.e = paramBoolean;
      if (this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView != null) {
        this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.b(paramBoolean);
      }
      if ((!paramBoolean) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null)) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.s();
      }
    }
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CaptureController", 2, "onStop...");
    }
    this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.e();
    ((QIMCaptureBannerManager)QIMManager.a(9)).a(true);
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.r();
    }
  }
  
  public void h(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null)
    {
      if (((QIMSegmentCaptureManager)QIMManager.a(13)).a()) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(paramBoolean, false);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.s();
  }
  
  public void i()
  {
    ThreadManager.postImmediately(new ankt(this), null, true);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.f();
    VideoFilterTools.a().a(0);
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.s();
    }
    NativeGifImage.resumeAll();
    ApngImage.playByTag(13);
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      DoodleLayoutConnector.a().a(0, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout);
    }
  }
  
  public void j()
  {
    d();
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a() != null))
    {
      if (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) {
        this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.c();
      }
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.b(true);
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a();
    }
    this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.g();
    VideoFilterTools.a().a(0);
    VideoFilterViewPager localVideoFilterViewPager = (VideoFilterViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131368994);
    if (localVideoFilterViewPager != null) {
      localVideoFilterViewPager.a(0);
    }
    DoodleLayoutConnector.a().a(0);
  }
  
  public void k() {}
  
  public void l() {}
  
  public void m() {}
  
  public void n() {}
  
  public void o() {}
  
  public void p() {}
  
  public void q()
  {
    this.d = true;
    MusicProviderView localMusicProviderView = (MusicProviderView)this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.a(MusicProviderView.class);
    DoodleLayout localDoodleLayout = DoodleLayoutConnector.a().a(0);
    if (localDoodleLayout != null) {
      localDoodleLayout.setRecording(this.d);
    }
    if (localMusicProviderView != null) {
      localMusicProviderView.b(true);
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(true, true);
    }
  }
  
  public void r()
  {
    this.d = false;
    DoodleLayout localDoodleLayout = DoodleLayoutConnector.a().a(0);
    if (localDoodleLayout != null) {
      localDoodleLayout.setRecording(this.d);
    }
  }
  
  public void s()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.r();
    }
  }
  
  public void t()
  {
    this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.a(this.jdField_b_of_type_Int, QIMPtvTemplateAdapter.jdField_b_of_type_Int, QIMPtvTemplateAdapter.jdField_b_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.QIMCaptureController
 * JD-Core Version:    0.7.0.1
 */