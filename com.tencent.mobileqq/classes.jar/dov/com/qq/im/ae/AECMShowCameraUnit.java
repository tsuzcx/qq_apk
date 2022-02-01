package dov.com.qq.im.ae;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tavsticker.utils.TAVStickerUtil;
import com.tencent.ttpic.openapi.PTFaceAttr;
import dov.com.qq.im.ae.camera.AEPhotoCaptureResult;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.filter.AEFilterProcessTex;
import dov.com.qq.im.ae.cmshow.AECMShowLoadingView;
import dov.com.qq.im.ae.cmshow.AECMShowRequestController;
import dov.com.qq.im.ae.cmshow.AECMShowRequestController.Callback;
import dov.com.qq.im.ae.cmshow.AECMShowRequestController.CmShowDataWrapper;
import dov.com.qq.im.ae.download.AEResInfo;
import dov.com.qq.im.ae.download.AEResUtil;
import dov.com.qq.im.ae.part.VideoStoryCapturePartManager;
import dov.com.qq.im.ae.play.FaceChangeUtils;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.ae.view.AECMShowFaceScanView;
import dov.com.qq.im.ae.view.AECMShowFaceScanView.FaceRectData;
import dov.com.qq.im.ae.view.AECMShowFaceScanView.ScanViewListener;
import dov.com.qq.im.setting.ICameraEntrance;
import dov.com.qq.im.setting.IQIMCameraContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class AECMShowCameraUnit
  extends AEPituCameraUnit
  implements AECMShowRequestController.Callback, AECMShowFaceScanView.ScanViewListener
{
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int = 1000;
  long jdField_a_of_type_Long = -1L;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private PTFaceAttr jdField_a_of_type_ComTencentTtpicOpenapiPTFaceAttr;
  private AECMShowLoadingView jdField_a_of_type_DovComQqImAeCmshowAECMShowLoadingView;
  AECMShowRequestController.CmShowDataWrapper jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController$CmShowDataWrapper;
  private AECMShowRequestController jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController = new AECMShowRequestController(1, this);
  private AECMShowFaceScanView.FaceRectData jdField_a_of_type_DovComQqImAeViewAECMShowFaceScanView$FaceRectData;
  private AECMShowFaceScanView jdField_a_of_type_DovComQqImAeViewAECMShowFaceScanView;
  private String jdField_a_of_type_JavaLangString = "";
  private List<AEResInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  volatile boolean jdField_a_of_type_Boolean = false;
  long jdField_b_of_type_Long = 0L;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private long c = 0L;
  private long d = 0L;
  private long e = 0L;
  private volatile boolean h = false;
  private volatile boolean i = false;
  private boolean j = false;
  
  public AECMShowCameraUnit(IQIMCameraContainer paramIQIMCameraContainer, ICameraEntrance paramICameraEntrance)
  {
    super(paramIQIMCameraContainer, paramICameraEntrance);
    ac();
    ae();
  }
  
  private AECMShowFaceScanView.FaceRectData a()
  {
    if ((this.jdField_a_of_type_ComTencentTtpicOpenapiPTFaceAttr == null) || (this.jdField_a_of_type_ComTencentTtpicOpenapiPTFaceAttr.getAllFacePoints() == null) || (this.jdField_a_of_type_ComTencentTtpicOpenapiPTFaceAttr.getAllFacePoints().size() == 0)) {
      return b();
    }
    AECMShowFaceScanView.FaceRectData localFaceRectData = new AECMShowFaceScanView.FaceRectData();
    RectF localRectF = new RectF();
    List localList = FaceChangeUtils.getMaxFacePoints(this.jdField_a_of_type_ComTencentTtpicOpenapiPTFaceAttr.getAllFacePoints(), this.jdField_a_of_type_Float);
    PointF localPointF1 = (PointF)localList.get(0);
    PointF localPointF2 = (PointF)localList.get(18);
    PointF localPointF3 = new PointF((localPointF1.x + localPointF2.x) / 2.0F, (localPointF1.y + localPointF2.y) / 2.0F);
    float f1 = TAVStickerUtil.getDistance(localPointF3, (PointF)localList.get(9));
    float f2 = TAVStickerUtil.getDistance(localPointF1, localPointF2) / 2.0F;
    localRectF.left = (localPointF3.x - f2);
    localRectF.right = (f2 + localPointF3.x);
    localRectF.top = (localPointF3.y - f1);
    localRectF.bottom = (f1 + localPointF3.y);
    localFaceRectData.a(localRectF);
    f1 = localPointF2.y;
    f2 = localPointF1.y;
    float f3 = localPointF2.x;
    float f4 = localPointF1.x;
    localFaceRectData.a((float)Math.toDegrees(Math.atan2(f1 - f2, f3 - f4)));
    return localFaceRectData;
  }
  
  private void a(AEFilterManager paramAEFilterManager)
  {
    this.jdField_a_of_type_ComTencentTtpicOpenapiPTFaceAttr = paramAEFilterManager.getFaceAttr();
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiPTFaceAttr == null) {
      return;
    }
    paramAEFilterManager = this.jdField_a_of_type_ComTencentTtpicOpenapiPTFaceAttr.getAllFacePoints();
    if ((paramAEFilterManager == null) || (paramAEFilterManager.size() == 0)) {
      if (this.jdField_a_of_type_Long == -1L) {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
    }
    for (;;)
    {
      af();
      return;
      this.jdField_b_of_type_Long = (System.currentTimeMillis() - this.jdField_a_of_type_Long);
      continue;
      this.jdField_b_of_type_Long = 0L;
      this.jdField_a_of_type_Long = -1L;
    }
  }
  
  private void ac()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.add(AEResInfo.k);
  }
  
  private void ad()
  {
    this.i = true;
    this.jdField_a_of_type_Int = 1001;
    this.jdField_a_of_type_DovComQqImAeViewAECMShowFaceScanView.a(1003, null);
    a("triggerState1", "1");
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.queueEvent(new AECMShowCameraUnit.1(this));
  }
  
  private void ae()
  {
    ThreadManager.getSubThreadHandler().post(new AECMShowCameraUnit.2(this));
  }
  
  private void af()
  {
    ThreadManager.getUIHandler().post(new AECMShowCameraUnit.3(this));
  }
  
  private void ag()
  {
    AEBaseDataReporter.a().aC();
    a().setResult(0);
    a().finish();
  }
  
  private void ah()
  {
    switch (((Integer)this.jdField_a_of_type_AndroidWidgetImageView.getTag()).intValue())
    {
    default: 
      an();
      return;
    case 5: 
      an();
      return;
    }
    AEBaseDataReporter.a().aK();
    ai();
  }
  
  private void ai()
  {
    this.jdField_a_of_type_DovComQqImAeCameraAEPhotoCaptureResult = null;
    this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController$CmShowDataWrapper = null;
    ak();
    am();
  }
  
  private void aj()
  {
    switch (((Integer)this.jdField_a_of_type_AndroidWidgetButton.getTag()).intValue())
    {
    default: 
      al();
      return;
    case 1: 
      AEBaseDataReporter.a().aJ();
      A();
      return;
    }
    AEBaseDataReporter.a().aL();
    ai();
  }
  
  private void ak()
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setMaterial(null);
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setMaterial(this.jdField_a_of_type_JavaLangString);
  }
  
  private void al()
  {
    this.i = true;
    AEBaseDataReporter.a().aB();
    if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.captureByCameraProxy())
    {
      y();
      return;
    }
    x();
  }
  
  private void am()
  {
    this.i = false;
    this.jdField_a_of_type_Int = 1000;
    AEBaseDataReporter.a().ay();
    if (this.d > 0L) {
      AEBaseDataReporter.a().g(System.currentTimeMillis() - this.d);
    }
    for (;;)
    {
      this.c = System.currentTimeMillis();
      this.d = 0L;
      this.e = 0L;
      ThreadManager.getUIHandler().post(new AECMShowCameraUnit.8(this));
      return;
      if (this.e > 0L) {
        AEBaseDataReporter.a().a(0, System.currentTimeMillis() - this.e);
      }
    }
  }
  
  private void an()
  {
    AEBaseDataReporter.a().az();
    Intent localIntent = new Intent(a(), NewPhotoListActivity.class);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 6);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    localIntent.putExtra("enter_from", 53);
    a().startActivityForResult(localIntent, 10006);
  }
  
  private void ao()
  {
    if ((this.jdField_a_of_type_DovComQqImAeCameraAEPhotoCaptureResult != null) && (!StringUtil.a(this.jdField_a_of_type_DovComQqImAeCameraAEPhotoCaptureResult.jdField_a_of_type_JavaLangString)))
    {
      a("triggerState1", "1");
      Bitmap localBitmap = BitmapFactory.decodeFile(this.jdField_a_of_type_DovComQqImAeCameraAEPhotoCaptureResult.jdField_a_of_type_JavaLangString);
      ThreadManager.getSubThreadHandler().post(new AECMShowCameraUnit.9(this, localBitmap));
      return;
    }
    AEQLog.d(this.jdField_b_of_type_JavaLangString, "sendMakeFaceRequests: 拍摄结果异常");
  }
  
  private AECMShowFaceScanView.FaceRectData b()
  {
    if (this.jdField_a_of_type_DovComQqImAeViewAECMShowFaceScanView$FaceRectData == null) {
      this.jdField_a_of_type_DovComQqImAeViewAECMShowFaceScanView$FaceRectData = c();
    }
    return this.jdField_a_of_type_DovComQqImAeViewAECMShowFaceScanView$FaceRectData;
  }
  
  private AECMShowFaceScanView.FaceRectData c()
  {
    AECMShowFaceScanView.FaceRectData localFaceRectData = new AECMShowFaceScanView.FaceRectData();
    RectF localRectF = new RectF();
    int k = UIUtils.a(a(), 65.0F);
    localRectF.left = k;
    localRectF.right = (UIUtils.b(a()) - k);
    k = (int)(localRectF.width() / 0.786047F);
    localRectF.top = ((int)(UIUtils.c(a()) / 2.0F - k / 2.0F));
    float f = UIUtils.c(a()) / 2.0F;
    localRectF.bottom = ((int)(k / 2.0F + f));
    localFaceRectData.a(localRectF);
    f = localRectF.width();
    localFaceRectData.a((int)(localRectF.height() * f));
    return localFaceRectData;
  }
  
  protected void A()
  {
    Intent localIntent = new Intent();
    if (this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController$CmShowDataWrapper != null) {
      localIntent.putExtra("cms_face_data", this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController$CmShowDataWrapper);
    }
    a().setResult(-1, localIntent);
    a().finish();
  }
  
  public void B()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (AEResInfo)localIterator.next();
      String str = AEResUtil.c((AEResInfo)localObject);
      localObject = ((AEResInfo)localObject).c;
      if ((this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView != null) && (!StringUtil.a(str)))
      {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "[cmShowSetKapuModel][refreshBundle] bundlePath =" + str);
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "[cmShowSetKapuModel][refreshBundle] agentType =" + (String)localObject);
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setBundlePath(str, (String)localObject);
      }
    }
  }
  
  protected void C()
  {
    ThreadManager.getUIHandler().post(new AECMShowCameraUnit.4(this));
  }
  
  protected void D()
  {
    this.jdField_a_of_type_Int = 1001;
    ThreadManager.getUIHandler().post(new AECMShowCameraUnit.5(this));
  }
  
  protected void E()
  {
    this.jdField_a_of_type_Int = 1001;
    AEBaseDataReporter.a().aI();
    this.d = System.currentTimeMillis();
    this.e = 0L;
    this.c = 0L;
    ThreadManager.getUIHandler().post(new AECMShowCameraUnit.6(this));
  }
  
  public void F()
  {
    if (this.c > 0L)
    {
      AEBaseDataReporter.a().e(System.currentTimeMillis() - this.c);
      this.c = 0L;
    }
    D();
    ao();
  }
  
  public void G() {}
  
  protected int a()
  {
    return 2131558501;
  }
  
  public View a()
  {
    this.jdField_a_of_type_AndroidViewView = a().getLayoutInflater().inflate(a(), null, false);
    this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager = new VideoStoryCapturePartManager(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a(), this.jdField_a_of_type_AndroidViewView, this);
    this.j = false;
    q();
    aa();
    r();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  protected void a()
  {
    B();
  }
  
  protected void a(int paramInt)
  {
    this.jdField_a_of_type_Int = 1001;
    AEBaseDataReporter.a().d(0);
    this.e = System.currentTimeMillis();
    this.d = 0L;
    this.c = 0L;
    ThreadManager.getUIHandler().post(new AECMShowCameraUnit.7(this, paramInt));
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.a(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Float = (1.0F * paramInt1 / paramInt3);
  }
  
  protected void a(int paramInt, AEFilterManager paramAEFilterManager)
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager == null) {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager = paramAEFilterManager;
    }
    a(paramAEFilterManager);
  }
  
  public void a(int paramInt, @Nullable AECMShowRequestController.CmShowDataWrapper paramCmShowDataWrapper)
  {
    this.i = true;
    if ((this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) && (paramCmShowDataWrapper != null))
    {
      this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController$CmShowDataWrapper = paramCmShowDataWrapper;
      if (paramInt == 1)
      {
        ThreadManager.getUIHandler().post(new AECMShowCameraUnit.12(this, paramCmShowDataWrapper));
        return;
      }
      a(paramInt);
      return;
    }
    a(paramInt);
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    if ((paramIntent != null) && (paramIntent.hasExtra("KEY_CMSHOW_DATA")))
    {
      this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController$CmShowDataWrapper = ((AECMShowRequestController.CmShowDataWrapper)paramIntent.getSerializableExtra("KEY_CMSHOW_DATA"));
      A();
    }
  }
  
  protected void a(String paramString1, String paramString2)
  {
    AEQLog.a(this.jdField_b_of_type_JavaLangString, "invokeTriggerState");
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.queueEvent(new AECMShowCameraUnit.10(this, paramString1, paramString2));
  }
  
  public void b()
  {
    super.b();
    this.j = true;
    if (this.c > 0L) {
      AEBaseDataReporter.a().e(System.currentTimeMillis() - this.c);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController != null)
      {
        this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController.b();
        this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController = null;
      }
      return;
      if (this.d > 0L) {
        AEBaseDataReporter.a().g(System.currentTimeMillis() - this.d);
      } else if (this.e > 0L) {
        AEBaseDataReporter.a().a(0, System.currentTimeMillis() - this.e);
      }
    }
  }
  
  public void b(int paramInt)
  {
    ThreadManager.getUIHandler().post(new AECMShowCameraUnit.11(this, paramInt));
  }
  
  public void c()
  {
    super.c();
  }
  
  public void onAEKitInited()
  {
    super.onAEKitInited();
    this.h = true;
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setPauseFilterChainWhenCapture(false);
    if (!StringUtil.a(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setMaterial(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Boolean = true;
      AEQLog.a(this.jdField_b_of_type_JavaLangString, "[cmShowFirstFrame] onAEKitInited: 完成设置素材");
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      aj();
      continue;
      ah();
      continue;
      ag();
    }
  }
  
  public void onPhotoCaptured(AEPhotoCaptureResult paramAEPhotoCaptureResult)
  {
    super.onPhotoCaptured(paramAEPhotoCaptureResult);
    Log.d("cmjoy_request", "onPhotoCaptured: 厘米秀 拍摄完成 ---" + Thread.currentThread());
    C();
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null)
    {
      a("shoot", "1");
      this.jdField_a_of_type_DovComQqImAeViewAECMShowFaceScanView.a(1001, a());
    }
  }
  
  public void onSetFilterProcess(AEFilterProcessTex paramAEFilterProcessTex)
  {
    super.onSetFilterProcess(paramAEFilterProcessTex);
    if (this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController == null) {
      this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController = new AECMShowRequestController(1, this);
    }
    if (this.j) {
      this.jdField_a_of_type_DovComQqImAeViewAECMShowFaceScanView.a(1003, null);
    }
  }
  
  protected void q()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363738));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363736));
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView = ((AECameraGLSurfaceView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364338));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363943));
    this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(3));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369562));
    this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(5));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369611));
    this.jdField_a_of_type_DovComQqImAeViewAECMShowFaceScanView = ((AECMShowFaceScanView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366567));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380647));
    this.jdField_a_of_type_DovComQqImAeCmshowAECMShowLoadingView = ((AECMShowLoadingView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364915));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_DovComQqImAeViewAECMShowFaceScanView.setListener(this);
  }
  
  public void reportFirstFrameShown()
  {
    super.reportFirstFrameShown();
    AEQLog.a(this.jdField_b_of_type_JavaLangString, "[cmShowFirstFrame]:  revisible = " + this.j);
    if ((this.jdField_a_of_type_DovComQqImAeCameraAEPhotoCaptureResult != null) && (this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController$CmShowDataWrapper != null) && (this.j))
    {
      AEQLog.a(this.jdField_b_of_type_JavaLangString, "[cmShowFirstFrame]: 还原捏脸结果");
      ad();
    }
    for (;;)
    {
      this.j = false;
      return;
      if (this.j)
      {
        AEQLog.a(this.jdField_b_of_type_JavaLangString, "[cmShowFirstFrame]: 重置素材");
        ak();
        am();
      }
      else
      {
        AEQLog.a(this.jdField_b_of_type_JavaLangString, "[cmShowFirstFrame]: 首次打开");
        this.c = System.currentTimeMillis();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AECMShowCameraUnit
 * JD-Core Version:    0.7.0.1
 */