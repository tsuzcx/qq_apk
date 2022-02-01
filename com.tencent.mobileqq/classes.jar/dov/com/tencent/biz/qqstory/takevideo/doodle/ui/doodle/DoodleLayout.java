package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam.MotionInfo;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LiuHaiUtils;
import dov.com.qq.im.ae.AEKitForQQ;
import dov.com.qq.im.ae.camera.ui.AECaptureController;
import dov.com.qq.im.capture.data.IFaceSelectedListener;
import dov.com.qq.im.capture.layer.PickLayer;
import dov.com.qq.im.capture.text.DynamicTextBuilder;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.qq.im.capture.text.DynamicTextItem.TextMap;
import dov.com.qq.im.capture.text.NormalTextItem;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoDoodle;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoLimitRegion.LimitMessage;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import dov.com.tencent.biz.qqstory.takevideo.StoryMediaEditNotifier;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.DynamicFaceLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.EmptyLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.FaceItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.LayerEventListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.LayerParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.GuideLineLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.LineLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextFaceEditLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextFaceEditLayer.LayerListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer.TextItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.base.BaseLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.base.DoodleStrategy;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.config.DoodleConfig;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.config.DoodleConfig.Builder;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.LocationFacePackage.Item;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.StoryGuideLineView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.DoodleUtil;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper.ZoomItem;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.strategy.ConfigurableLineLayerStrokeStrategy;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.strategy.EditDialogStrokeStrategy;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.stroke.HorizontalStroke;
import dov.com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.os.MqqHandler;
import org.json.JSONArray;

@TargetApi(14)
public class DoodleLayout
  extends RelativeLayout
  implements View.OnClickListener
{
  public static boolean a;
  public int a;
  public long a;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public Rect a;
  public SparseArray<DoodleConfig> a;
  public SparseBooleanArray a;
  public FrameLayout a;
  public ImageView a;
  public RelativeLayout a;
  protected IFaceSelectedListener a;
  private PickLayer jdField_a_of_type_DovComQqImCaptureLayerPickLayer;
  DynamicTextBuilder jdField_a_of_type_DovComQqImCaptureTextDynamicTextBuilder = new DynamicTextBuilder();
  private EditVideoDoodle jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle;
  public EditVideoParams a;
  public FaceLayer.FaceItem a;
  public GuideLineLayer a;
  public EditTextDialog a;
  public DoodleEditView a;
  protected DoodleLayout.DoodleBtnOperationHelper a;
  public DoodleLayout.DoodleEventListener a;
  public DoodleLayout.EditDialogListener a;
  private DoodleLayout.OnTextDialogShowListener jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$OnTextDialogShowListener;
  private DoodleLayout.TextDialogInputShow jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$TextDialogInputShow;
  public DoodleLayout.TextFaceLayerTouchListener a;
  public DoodleTextureView a;
  public DoodleView a;
  private StoryGuideLineView jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView;
  public HorizontalSelectColorLayout a;
  private RuntimeException jdField_a_of_type_JavaLangRuntimeException;
  private Comparator<BaseLayer> jdField_a_of_type_JavaUtilComparator = new DoodleLayout.1(this);
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  private final Condition jdField_a_of_type_JavaUtilConcurrentLocksCondition = this.jdField_a_of_type_JavaUtilConcurrentLocksLock.newCondition();
  private final Lock jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  public int b;
  private long b;
  public SparseArray<DoodleLayout.LayerCollection> b;
  public SparseBooleanArray b;
  public DoodleView b;
  public boolean b;
  public int c;
  private long c;
  public boolean c;
  public int d;
  private long jdField_d_of_type_Long = 0L;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = -1;
  private boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int = -1;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int = -1;
  private boolean jdField_g_of_type_Boolean = false;
  private int jdField_h_of_type_Int = -1;
  private boolean jdField_h_of_type_Boolean = false;
  private int jdField_i_of_type_Int = -1;
  private boolean jdField_i_of_type_Boolean = true;
  private int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean = true;
  private int jdField_k_of_type_Int = 0;
  private boolean jdField_k_of_type_Boolean;
  private boolean l = false;
  
  public DoodleLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
    this.jdField_b_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_c_of_type_Long = 0L;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$TextFaceLayerTouchListener = new DoodleLayout.TextFaceLayerTouchListener(this, null);
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    LayoutInflater.from(super.getContext()).inflate(2131559180, this);
    u();
    c(this.jdField_c_of_type_Int);
    this.jdField_j_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  public static void a(String paramString)
  {
    if (jdField_a_of_type_Boolean) {}
    for (String str = "2";; str = "1")
    {
      a(paramString, 0, 0, new String[] { str });
      return;
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    StoryReportor.a("video_edit", paramString, paramInt1, paramInt2, paramVarArgs);
  }
  
  private boolean a(boolean paramBoolean)
  {
    b();
    SLog.b("DoodleLayout", "onBackPressed, buttonState:" + this.jdField_d_of_type_Int + ",activeLayer:" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a());
    if ((this.jdField_d_of_type_Int == 0) || ((this.jdField_d_of_type_Int == 2) && (!paramBoolean))) {
      return false;
    }
    l();
    b(0);
    if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.b())
    {
      SLog.b("DoodleLayout", "onBackPressed, resetDoodleView.");
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.f();
    }
    return true;
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerGuideLineLayer == null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerGuideLineLayer = new GuideLineLayer(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
    }
    Object localObject1 = (DoodleConfig)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    int m;
    if (localObject1 == null)
    {
      SLog.b("DoodleLayout", "initDoodleView for the %d video", Integer.valueOf(paramInt));
      Object localObject4 = a();
      localObject1 = (FaceLayer)((DoodleLayout.NormalDoodleStategy)localObject4).a(FaceLayer.jdField_a_of_type_JavaLangString);
      DynamicFaceLayer localDynamicFaceLayer = (DynamicFaceLayer)((DoodleLayout.NormalDoodleStategy)localObject4).a("DynamicFaceLayer");
      Object localObject2 = (LineLayer)((DoodleLayout.NormalDoodleStategy)localObject4).a("LineLayer");
      TextLayer localTextLayer = (TextLayer)((DoodleLayout.NormalDoodleStategy)localObject4).a(TextLayer.jdField_a_of_type_JavaLangString);
      Object localObject3 = (GuideLineLayer)((DoodleLayout.NormalDoodleStategy)localObject4).a("GuideLineLayer");
      if (localObject2 != null)
      {
        MosaicOperator localMosaicOperator = (MosaicOperator)((LineLayer)localObject2).a(103);
        if ((localMosaicOperator != null) && (this.jdField_e_of_type_Int != -1)) {
          localMosaicOperator.b(this.jdField_e_of_type_Int);
        }
        if ((localMosaicOperator != null) && (this.jdField_f_of_type_Int != -1) && (this.jdField_g_of_type_Int != -1)) {
          localMosaicOperator.b(this.jdField_f_of_type_Int, this.jdField_g_of_type_Int);
        }
      }
      localObject4 = new DoodleConfig.Builder().a((DoodleStrategy)localObject4);
      if (this.jdField_h_of_type_Int != -1)
      {
        m = this.jdField_h_of_type_Int;
        localObject4 = ((DoodleConfig.Builder)localObject4).a(m);
        if (this.jdField_i_of_type_Int == -1) {
          break label508;
        }
        m = this.jdField_i_of_type_Int;
        label241:
        localObject4 = ((DoodleConfig.Builder)localObject4).b(m).a();
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setDoodleConfig((DoodleConfig)localObject4);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setDoodleLayout(this);
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null)
        {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
        }
        localObject3 = new DoodleLayout.LayerCollection(localTextLayer, (LineLayer)localObject2, (FaceLayer)localObject1, localDynamicFaceLayer, (GuideLineLayer)localObject3, (EmptyLayer)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(EmptyLayer.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject4);
        this.jdField_b_of_type_AndroidUtilSparseArray.put(paramInt, localObject3);
        if (localObject2 != null)
        {
          ((LineLayer)localObject2).a(new DoodleLayout.LineLayerTouchListener(this, null));
          ((LineLayer)localObject2).a(new DoodleLayout.7(this));
        }
        if (localObject1 != null) {
          ((FaceLayer)localObject1).a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$TextFaceLayerTouchListener);
        }
        if (localDynamicFaceLayer != null) {
          localDynamicFaceLayer.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$TextFaceLayerTouchListener);
        }
        localObject2 = new DoodleLayout.8(this);
        if (localObject1 != null) {
          ((FaceLayer)localObject1).a((FaceLayer.LayerEventListener)localObject2);
        }
        if (localDynamicFaceLayer != null) {
          localDynamicFaceLayer.a((FaceLayer.LayerEventListener)localObject2);
        }
        if ((localTextLayer != null) && (!this.jdField_d_of_type_Boolean))
        {
          localTextLayer.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$TextFaceLayerTouchListener);
          localTextLayer.a(new DoodleLayout.TextLayerListener(this, null));
        }
        this.jdField_a_of_type_DovComQqImCaptureLayerPickLayer = ((PickLayer)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a("PickLayer"));
      }
    }
    for (;;)
    {
      v();
      this.jdField_f_of_type_Boolean = false;
      return;
      m = 480;
      break;
      label508:
      m = 640;
      break label241;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setDoodleConfig((DoodleConfig)localObject1);
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if (!this.jdField_j_of_type_Boolean) {}
    while (this.jdField_k_of_type_Boolean == paramBoolean) {
      return;
    }
    this.jdField_k_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      SLog.b("DoodleLayout", "rubbish active.");
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(getResources().getColor(2131166370));
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847146);
      return;
    }
    SLog.b("DoodleLayout", "rubbish unActive.");
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(getResources().getColor(2131166371));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847146);
  }
  
  private static void e(boolean paramBoolean)
  {
    if (paramBoolean) {
      StoryMediaEditNotifier.a().a();
    }
  }
  
  private void u()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131377418));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131369798));
    if (LiuHaiUtils.f()) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, LiuHaiUtils.a(), 0, 0);
    }
    this.jdField_a_of_type_DovComQqImCaptureDataIFaceSelectedListener = new DoodleLayout.FaceSelectedListener(this, null);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout = ((HorizontalSelectColorLayout)super.findViewById(2131372228));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setOnUndoViewClickListener(new DoodleLayout.2(this));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setOnStrokeSelectedListener(new DoodleLayout.3(this));
    View localView = super.findViewById(2131363823);
    if (localView != null) {
      localView.setVisibility(0);
    }
    x();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView = ((DoodleView)super.findViewById(2131365963));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView = ((DoodleEditView)super.findViewById(2131365964));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setDoodleLayout(this);
    setOnTextDialogShowListener(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setOnLayerTouchListener();
    this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView = ((DoodleView)super.findViewById(2131365970));
    l();
  }
  
  private void v()
  {
    LineLayer localLineLayer = a();
    if ((localLineLayer != null) && (this.jdField_e_of_type_Boolean))
    {
      localLineLayer.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleTextureView);
      localLineLayer.a.a(new DoodleLayout.4(this));
      if (this.jdField_e_of_type_Boolean)
      {
        ((PersonalityOperator)localLineLayer.a.a(102)).a(false);
        localLineLayer.a.a(new DoodleLayout.5(this));
        localLineLayer.c();
      }
    }
  }
  
  private void w()
  {
    GestureHelper.ZoomItem localZoomItem;
    Object localObject;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b())
    {
      localZoomItem = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.a();
      localZoomItem.jdField_k_of_type_Boolean = false;
      if (!(localZoomItem instanceof FaceLayer.FaceItem)) {
        break label118;
      }
      localObject = a();
      if (((((FaceLayer.FaceItem)localZoomItem).jdField_h_of_type_Int != 1) && (((FaceLayer.FaceItem)localZoomItem).jdField_h_of_type_Int != 3)) || ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()))) {
        break label147;
      }
      localObject = a();
      ((FaceLayer.FaceItem)localZoomItem).jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
    }
    label147:
    for (;;)
    {
      if (localObject != null) {}
      label118:
      do
      {
        ((FaceLayer)localObject).jdField_a_of_type_JavaUtilList.add((FaceLayer.FaceItem)localZoomItem);
        do
        {
          return;
        } while (!(localZoomItem instanceof TextLayer.TextItem));
        localObject = a();
      } while (localObject == null);
      ((TextLayer)localObject).jdField_a_of_type_JavaUtilArrayList.add((TextLayer.TextItem)localZoomItem);
      return;
    }
  }
  
  private void x()
  {
    for (;;)
    {
      try
      {
        if ((super.getContext() instanceof QQStoryBaseActivity))
        {
          AppInterface localAppInterface = ((QQStoryBaseActivity)super.getContext()).a;
          if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (!VideoEnvironment.isX86Platform()) && (AEKitForQQ.b()))
          {
            bool = true;
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setStrokeStrategy(new ConfigurableLineLayerStrokeStrategy(localAppInterface, true, bool, a()), true, 2);
            t();
            return;
          }
          boolean bool = false;
          continue;
        }
        Object localObject = null;
      }
      catch (Exception localException)
      {
        QLog.e("DoodleLayout", 1, "refresh Stroke error", localException);
        return;
      }
    }
  }
  
  protected int a()
  {
    return ScreenUtil.a(65.0F);
  }
  
  public int a(int paramInt)
  {
    DoodleLayout.LayerCollection localLayerCollection = (DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localLayerCollection != null)
    {
      paramInt = localLayerCollection.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer.b();
      int m = localLayerCollection.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerLineLayer.b();
      int n = localLayerCollection.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.b();
      int i1 = localLayerCollection.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerDynamicFaceLayer.b();
      SLog.b("DoodleLayout", "DoodleCount: text->" + paramInt + ",line->" + m + ",face->" + n + " " + i1);
      return i1 + (paramInt + m + n);
    }
    return 0;
  }
  
  public Bitmap a()
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a();
  }
  
  public Bitmap a(int paramInt)
  {
    DoodleLayout.LayerCollection localLayerCollection = (DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localLayerCollection != null) {
      return localLayerCollection.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerLineLayer.a();
    }
    return null;
  }
  
  /* Error */
  public Bitmap a(int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 265	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView	Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleView;
    //   4: invokevirtual 694	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleView:b	()I
    //   7: istore_3
    //   8: aload_0
    //   9: getfield 265	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView	Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleView;
    //   12: invokevirtual 696	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleView:c	()I
    //   15: istore 4
    //   17: iload_3
    //   18: ifle +8 -> 26
    //   21: iload 4
    //   23: ifgt +32 -> 55
    //   26: ldc 249
    //   28: ldc_w 698
    //   31: iconst_2
    //   32: anewarray 700	java/lang/Object
    //   35: dup
    //   36: iconst_0
    //   37: iload_3
    //   38: invokestatic 316	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   41: aastore
    //   42: dup
    //   43: iconst_1
    //   44: iload 4
    //   46: invokestatic 316	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   49: aastore
    //   50: invokestatic 703	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   53: aconst_null
    //   54: areturn
    //   55: aload_0
    //   56: getfield 119	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   59: iconst_0
    //   60: invokevirtual 706	java/util/concurrent/atomic/AtomicBoolean:getAndSet	(Z)Z
    //   63: ifeq +16 -> 79
    //   66: aload_0
    //   67: iload_3
    //   68: iload 4
    //   70: getstatic 712	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   73: invokestatic 718	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   76: putfield 720	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   79: aload_0
    //   80: getfield 124	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   83: invokeinterface 723 1 0
    //   88: aload_0
    //   89: getfield 720	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   92: astore 9
    //   94: aload 9
    //   96: ifnonnull +118 -> 214
    //   99: ldc 249
    //   101: ldc_w 725
    //   104: invokestatic 727	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: aload_0
    //   108: getfield 132	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaUtilConcurrentLocksCondition	Ljava/util/concurrent/locks/Condition;
    //   111: ldc2_w 728
    //   114: getstatic 735	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   117: invokeinterface 741 4 0
    //   122: ifne -34 -> 88
    //   125: ldc 249
    //   127: ldc_w 743
    //   130: iconst_1
    //   131: anewarray 700	java/lang/Object
    //   134: dup
    //   135: iconst_0
    //   136: invokestatic 749	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   139: invokevirtual 753	java/lang/Thread:getId	()J
    //   142: invokestatic 758	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   145: aastore
    //   146: invokestatic 760	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   149: aload_0
    //   150: getfield 762	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaLangRuntimeException	Ljava/lang/RuntimeException;
    //   153: ifnull -65 -> 88
    //   156: ldc 249
    //   158: ldc_w 764
    //   161: aload_0
    //   162: getfield 762	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaLangRuntimeException	Ljava/lang/RuntimeException;
    //   165: invokestatic 767	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   168: goto -80 -> 88
    //   171: astore 9
    //   173: ldc 249
    //   175: ldc_w 769
    //   178: aload 9
    //   180: invokestatic 767	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   183: goto -95 -> 88
    //   186: astore 9
    //   188: aload_0
    //   189: getfield 124	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   192: invokeinterface 772 1 0
    //   197: aload 9
    //   199: athrow
    //   200: astore 9
    //   202: ldc 249
    //   204: ldc_w 774
    //   207: aload 9
    //   209: invokestatic 776	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   212: aconst_null
    //   213: areturn
    //   214: aload_0
    //   215: getfield 720	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   218: astore 9
    //   220: aload_0
    //   221: aconst_null
    //   222: putfield 720	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   225: new 778	android/graphics/Canvas
    //   228: dup
    //   229: aload 9
    //   231: invokespecial 781	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   234: astore 10
    //   236: new 783	android/graphics/Paint
    //   239: dup
    //   240: invokespecial 784	android/graphics/Paint:<init>	()V
    //   243: astore 11
    //   245: aload 11
    //   247: new 786	android/graphics/PorterDuffXfermode
    //   250: dup
    //   251: getstatic 792	android/graphics/PorterDuff$Mode:CLEAR	Landroid/graphics/PorterDuff$Mode;
    //   254: invokespecial 795	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   257: invokevirtual 799	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   260: pop
    //   261: aload 10
    //   263: aload 11
    //   265: invokevirtual 803	android/graphics/Canvas:drawPaint	(Landroid/graphics/Paint;)V
    //   268: aload_0
    //   269: getfield 84	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   272: iload_1
    //   273: invokevirtual 306	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   276: checkcast 387	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout$LayerCollection
    //   279: astore 11
    //   281: aload 11
    //   283: ifnonnull +34 -> 317
    //   286: ldc 249
    //   288: ldc_w 805
    //   291: iconst_1
    //   292: anewarray 700	java/lang/Object
    //   295: dup
    //   296: iconst_0
    //   297: iload_1
    //   298: invokestatic 316	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   301: aastore
    //   302: invokestatic 703	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   305: aload_0
    //   306: getfield 124	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   309: invokeinterface 772 1 0
    //   314: aload 9
    //   316: areturn
    //   317: invokestatic 810	android/os/SystemClock:uptimeMillis	()J
    //   320: lstore 5
    //   322: aload 11
    //   324: getfield 666	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout$LayerCollection:jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerLineLayer	Ldov/com/tencent/biz/qqstory/takevideo/doodle/layer/LineLayer;
    //   327: astore 12
    //   329: aload 12
    //   331: getfield 545	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/LineLayer:a	Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleOpController;
    //   334: invokevirtual 811	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleOpController:a	()Z
    //   337: ifeq +20 -> 357
    //   340: ldc 249
    //   342: ldc_w 813
    //   345: invokestatic 727	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   348: aload 12
    //   350: getfield 545	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/LineLayer:a	Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleOpController;
    //   353: iload_3
    //   354: invokevirtual 814	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleOpController:b	(I)V
    //   357: aload_0
    //   358: getfield 377	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams;
    //   361: ifnull +20 -> 381
    //   364: aload_0
    //   365: getfield 377	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams;
    //   368: invokevirtual 815	dov/com/tencent/biz/qqstory/takevideo/EditVideoParams:a	()Z
    //   371: ifeq +10 -> 381
    //   374: aload 12
    //   376: aload 10
    //   378: invokevirtual 818	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/LineLayer:c	(Landroid/graphics/Canvas;)V
    //   381: aload_0
    //   382: getfield 206	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoDoodle;
    //   385: getfield 823	dov/com/tencent/biz/qqstory/takevideo/EditVideoDoodle:a	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoPartManager;
    //   388: invokevirtual 827	dov/com/tencent/biz/qqstory/takevideo/EditVideoPartManager:c	()J
    //   391: lstore 7
    //   393: lload 7
    //   395: lconst_0
    //   396: lcmp
    //   397: ifeq +33 -> 430
    //   400: iload_2
    //   401: ifeq +29 -> 430
    //   404: aload_0
    //   405: getfield 206	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoDoodle;
    //   408: lload 7
    //   410: invokevirtual 830	dov/com/tencent/biz/qqstory/takevideo/EditVideoDoodle:a	(J)V
    //   413: aload_0
    //   414: getfield 206	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoDoodle;
    //   417: invokevirtual 833	dov/com/tencent/biz/qqstory/takevideo/EditVideoDoodle:a	()Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout;
    //   420: lload 7
    //   422: ldc2_w 834
    //   425: ldiv
    //   426: iconst_0
    //   427: invokevirtual 839	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:setTimeStamp	(JZ)V
    //   430: new 841	java/util/LinkedList
    //   433: dup
    //   434: aload 11
    //   436: getfield 842	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout$LayerCollection:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   439: invokespecial 845	java/util/LinkedList:<init>	(Ljava/util/Collection;)V
    //   442: astore 11
    //   444: aload 11
    //   446: aload_0
    //   447: getfield 148	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaUtilComparator	Ljava/util/Comparator;
    //   450: invokestatic 851	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   453: aload 11
    //   455: invokevirtual 854	java/util/LinkedList:size	()I
    //   458: iconst_1
    //   459: isub
    //   460: istore_1
    //   461: iload_1
    //   462: iflt +35 -> 497
    //   465: aload 11
    //   467: iload_1
    //   468: invokevirtual 855	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   471: checkcast 857	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/base/BaseLayer
    //   474: astore 12
    //   476: aload 12
    //   478: ifnull +118 -> 596
    //   481: aload 12
    //   483: aload 10
    //   485: aload 12
    //   487: invokevirtual 860	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/base/BaseLayer:a	()F
    //   490: iload_2
    //   491: invokevirtual 863	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/base/BaseLayer:a	(Landroid/graphics/Canvas;FZ)V
    //   494: goto +102 -> 596
    //   497: iload_2
    //   498: ifeq +49 -> 547
    //   501: aload 11
    //   503: invokevirtual 854	java/util/LinkedList:size	()I
    //   506: iconst_1
    //   507: isub
    //   508: istore_1
    //   509: iload_1
    //   510: iflt +37 -> 547
    //   513: aload 11
    //   515: iload_1
    //   516: invokevirtual 855	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   519: checkcast 857	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/base/BaseLayer
    //   522: astore 12
    //   524: aload 12
    //   526: ifnull +63 -> 589
    //   529: aload 12
    //   531: instanceof 336
    //   534: ifeq +55 -> 589
    //   537: aload 12
    //   539: checkcast 336	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/DynamicFaceLayer
    //   542: aload 10
    //   544: invokevirtual 864	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/DynamicFaceLayer:c	(Landroid/graphics/Canvas;)V
    //   547: ldc 249
    //   549: new 251	java/lang/StringBuilder
    //   552: dup
    //   553: invokespecial 252	java/lang/StringBuilder:<init>	()V
    //   556: ldc_w 866
    //   559: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: invokestatic 810	android/os/SystemClock:uptimeMillis	()J
    //   565: lload 5
    //   567: lsub
    //   568: invokevirtual 869	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   571: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   574: invokestatic 282	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   577: aload_0
    //   578: getfield 124	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   581: invokeinterface 772 1 0
    //   586: aload 9
    //   588: areturn
    //   589: iload_1
    //   590: iconst_1
    //   591: isub
    //   592: istore_1
    //   593: goto -84 -> 509
    //   596: iload_1
    //   597: iconst_1
    //   598: isub
    //   599: istore_1
    //   600: goto -139 -> 461
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	603	0	this	DoodleLayout
    //   0	603	1	paramInt	int
    //   0	603	2	paramBoolean	boolean
    //   7	347	3	m	int
    //   15	54	4	n	int
    //   320	246	5	l1	long
    //   391	30	7	l2	long
    //   92	3	9	localBitmap1	Bitmap
    //   171	8	9	localInterruptedException	java.lang.InterruptedException
    //   186	12	9	localObject1	Object
    //   200	8	9	localOutOfMemoryError	OutOfMemoryError
    //   218	369	9	localBitmap2	Bitmap
    //   234	309	10	localCanvas	android.graphics.Canvas
    //   243	271	11	localObject2	Object
    //   327	211	12	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   99	168	171	java/lang/InterruptedException
    //   88	94	186	finally
    //   99	168	186	finally
    //   173	183	186	finally
    //   214	281	186	finally
    //   286	305	186	finally
    //   317	357	186	finally
    //   357	381	186	finally
    //   381	393	186	finally
    //   404	430	186	finally
    //   430	461	186	finally
    //   465	476	186	finally
    //   481	494	186	finally
    //   501	509	186	finally
    //   513	524	186	finally
    //   529	547	186	finally
    //   547	577	186	finally
    //   66	79	200	java/lang/OutOfMemoryError
  }
  
  public IFaceSelectedListener a()
  {
    return this.jdField_a_of_type_DovComQqImCaptureDataIFaceSelectedListener;
  }
  
  public DynamicFaceLayer a()
  {
    DoodleLayout.LayerCollection localLayerCollection = (DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.get(this.jdField_c_of_type_Int);
    if (localLayerCollection == null)
    {
      SLog.d("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int) });
      return null;
    }
    return localLayerCollection.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerDynamicFaceLayer;
  }
  
  public EmptyLayer a()
  {
    DoodleLayout.LayerCollection localLayerCollection = (DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.get(this.jdField_c_of_type_Int);
    if (localLayerCollection == null)
    {
      SLog.d("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int) });
      return null;
    }
    return localLayerCollection.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerEmptyLayer;
  }
  
  public FaceLayer a()
  {
    DoodleLayout.LayerCollection localLayerCollection = (DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.get(this.jdField_c_of_type_Int);
    if (localLayerCollection == null)
    {
      SLog.d("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int) });
      return null;
    }
    return localLayerCollection.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer;
  }
  
  public LineLayer a()
  {
    DoodleLayout.LayerCollection localLayerCollection = (DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.get(this.jdField_c_of_type_Int);
    if (localLayerCollection == null)
    {
      SLog.d("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int) });
      return null;
    }
    return localLayerCollection.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerLineLayer;
  }
  
  public TextLayer a()
  {
    DoodleLayout.LayerCollection localLayerCollection = (DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.get(this.jdField_c_of_type_Int);
    if (localLayerCollection == null)
    {
      SLog.d("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int) });
      return null;
    }
    return localLayerCollection.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer;
  }
  
  protected DoodleLayout.NormalDoodleStategy a()
  {
    return new DoodleLayout.NormalDoodleStategy(new BaseLayer[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerGuideLineLayer, new PickLayer(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView), new FaceLayer(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView), new DynamicFaceLayer(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView), new LineLayer(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView), new TextLayer(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView) });
  }
  
  public String a()
  {
    Object localObject2 = "";
    Object localObject3 = a();
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (((TextLayer)localObject3).jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject1 = localObject2;
        if (!((TextLayer)localObject3).jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          localObject1 = new JSONArray();
          localObject2 = ((TextLayer)localObject3).jdField_a_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (TextLayer.TextItem)((Iterator)localObject2).next();
            if ((((TextLayer.TextItem)localObject3).jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null) && (((TextLayer.TextItem)localObject3).jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a() != null)) {
              ((JSONArray)localObject1).put(((TextLayer.TextItem)localObject3).jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a().toString());
            }
          }
          localObject1 = ((JSONArray)localObject1).toString();
        }
      }
    }
    return localObject1;
  }
  
  public String a(int paramInt)
  {
    Object localObject = (DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject == null)
    {
      SLog.d("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(paramInt) });
      return null;
    }
    localObject = ((DoodleLayout.LayerCollection)localObject).jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer;
    if ((((TextLayer)localObject).jdField_a_of_type_JavaUtilArrayList != null) && (!((TextLayer)localObject).jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      localObject = ((TextLayer)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        TextLayer.TextItem localTextItem = (TextLayer.TextItem)((Iterator)localObject).next();
        if (localTextItem.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null)
        {
          localObject = localTextItem.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a().toString();
          return ((String)localObject).substring(0, ((String)localObject).length() - 1);
        }
      }
    }
    return null;
  }
  
  public List<String> a(int paramInt)
  {
    Object localObject = (DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject != null)
    {
      localObject = ((DoodleLayout.LayerCollection)localObject).jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerLineLayer.a.a();
      StringBuilder localStringBuilder = new StringBuilder().append("image doodle type count:");
      if ((localObject == null) || (((List)localObject).isEmpty())) {}
      for (paramInt = 0;; paramInt = ((List)localObject).size())
      {
        SLog.b("DoodleLayout", paramInt);
        return localObject;
      }
    }
    return Collections.emptyList();
  }
  
  public Map<String, List<String>> a(int paramInt)
  {
    Object localObject = (DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject != null)
    {
      localObject = ((DoodleLayout.LayerCollection)localObject).jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.jdField_a_of_type_JavaUtilMap;
      SLog.b("DoodleLayout", "Using face map:" + localObject.toString());
      return Collections.unmodifiableMap((Map)localObject);
    }
    return Collections.emptyMap();
  }
  
  public void a()
  {
    this.jdField_j_of_type_Boolean = false;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener.a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
    }
  }
  
  protected void a(int paramInt)
  {
    if (!DoodleLayout.State.a(paramInt))
    {
      SLog.e("DoodleLayout", "illegal state.");
      return;
    }
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getContext().getSharedPreferences("DoodleLay_State", 4).edit();
    localEditor.putInt("Line_LastType", paramInt1);
    localEditor.putInt("Line_LastSubType", paramInt2);
    localEditor.commit();
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    SLog.b("DoodleLayout", String.format("changeDoodleViewSize, width: %d, height: %d ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    setDoodleBitmapMaxSize(paramInt1, paramInt2);
    int m = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.getWidth();
    int n = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.getHeight();
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = paramInt1;
    ((RelativeLayout.LayoutParams)localObject).height = paramInt2;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (!paramBoolean) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.g();
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.h();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.onSizeChanged(paramInt1, paramInt2, m, n);
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a(paramInt1, paramInt2);
    }
    localObject = (MosaicOperator)a().a(104);
    if (localObject != null) {
      ((MosaicOperator)localObject).e();
    }
    if (this.jdField_e_of_type_Boolean)
    {
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = paramInt1;
      ((RelativeLayout.LayoutParams)localObject).height = paramInt2;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener.b(paramInt, paramObject);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    b();
    SLog.b("DoodleLayout", "addNewSticker, buttonState:" + this.jdField_d_of_type_Int + ",activeLayer:" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a());
    TextLayer localTextLayer = a();
    paramString = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextBuilder.a(paramInt, Arrays.asList(new String[] { paramString }));
    a().a(d());
    a().b(paramString);
    localTextLayer.d(true);
    a().a(4);
  }
  
  public void a(Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
      throw new IllegalArgumentException("bitmap should not be null or recycled");
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      throw new IllegalStateException("add bitmap as buffer duplicate");
    }
    this.jdField_a_of_type_JavaLangRuntimeException = null;
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
      this.jdField_a_of_type_JavaUtilConcurrentLocksCondition.signal();
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public void a(DynamicTextItem paramDynamicTextItem, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a()) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a.getBoolean("key_enable_edit_title_bar"))) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramDynamicTextItem, paramInt1, paramInt2, bool);
      return;
    }
  }
  
  public void a(DynamicTextItem paramDynamicTextItem, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    SLog.b("DoodleLayout", "onClickInside: showEditTextDialog." + paramDynamicTextItem);
    if (paramDynamicTextItem != null) {
      paramDynamicTextItem.b();
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$EditDialogListener = new DoodleLayout.EditDialogListener(this, null);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiEditTextDialog = new EditTextDialog(super.getContext());
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null)) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiEditTextDialog.jdField_a_of_type_AndroidWidgetRelativeLayout = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a.jdField_a_of_type_AndroidWidgetRelativeLayout;
    }
    boolean bool;
    if ((((Activity)getContext()).getWindow().getAttributes().flags & 0x400) == 1024)
    {
      bool = true;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiEditTextDialog.d(bool);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiEditTextDialog.jdField_g_of_type_Int = paramInt2;
      EditTextDialog localEditTextDialog = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiEditTextDialog;
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) || (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a())) {
        break label298;
      }
      bool = true;
      label170:
      localEditTextDialog.c(bool);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiEditTextDialog.a(a());
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiEditTextDialog.b(paramBoolean);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiEditTextDialog.setContentView(2131561792);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiEditTextDialog.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$EditDialogListener);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiEditTextDialog.a(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextBuilder);
      if (paramInt2 == 0)
      {
        if ((paramDynamicTextItem instanceof NormalTextItem)) {
          ((NormalTextItem)paramDynamicTextItem).a(EditDialogStrokeStrategy.a(a()));
        }
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiEditTextDialog.a(paramDynamicTextItem, paramInt1);
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiEditTextDialog.show();
      invalidate();
      if (this.jdField_d_of_type_Int != 0) {
        break label304;
      }
    }
    for (;;)
    {
      a(3);
      b(3);
      return;
      bool = false;
      break;
      label298:
      bool = false;
      break label170;
      label304:
      if (this.jdField_d_of_type_Int == 1)
      {
        b(new View[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView });
        setDoodleGLViewVisibility(0);
      }
      else if (this.jdField_d_of_type_Int == 2)
      {
        a(new View[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout });
        a().d(false);
      }
    }
  }
  
  public void a(LocationFacePackage.Item paramItem, float paramFloat1, float paramFloat2)
  {
    b();
    if (paramItem == null) {
      SLog.e("DoodleLayout", "the item is null.");
    }
    for (;;)
    {
      return;
      SLog.b("DoodleLayout", "addLocationFaceItem:" + paramItem.toString());
      FaceLayer.LayerParams localLayerParams = DoodleUtil.a(paramItem, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.getWidth(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.getHeight(), paramFloat1, paramFloat2);
      File localFile;
      Object localObject;
      if (localLayerParams != null)
      {
        if ((paramItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) || (!(paramItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof URLDrawable))) {
          break label225;
        }
        localFile = ((URLDrawable)paramItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getFileInLocal();
        if ((localFile == null) || (!localFile.exists())) {
          break label225;
        }
        FaceLayer localFaceLayer = a();
        localObject = localFaceLayer;
        if (paramItem.jdField_a_of_type_Int == 1) {
          if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null)
          {
            localObject = localFaceLayer;
            if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()) {}
          }
          else
          {
            localObject = a();
          }
        }
      }
      label225:
      for (boolean bool = ((FaceLayer)localObject).a(paramItem.g, paramItem.c, paramItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable, localLayerParams, localFile.getAbsolutePath(), true, paramItem.jdField_a_of_type_Int, d()); bool; bool = false)
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener.a(paramItem);
        VideoEditReport.a("0X80076CE");
        return;
        SLog.e("DoodleLayout", "create FaceLayer.ItemParams failed.");
        return;
      }
    }
  }
  
  public void a(LocationFacePackage.Item paramItem, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    a(paramItem, paramFloat1, paramFloat2, paramFloat3, null);
  }
  
  public void a(LocationFacePackage.Item paramItem, float paramFloat1, float paramFloat2, float paramFloat3, SegmentKeeper paramSegmentKeeper)
  {
    b();
    if (paramItem == null) {
      SLog.e("DoodleLayout", "the item is null.");
    }
    for (;;)
    {
      return;
      SLog.b("DoodleLayout", "addLocationFaceItem:" + paramItem.toString());
      FaceLayer.LayerParams localLayerParams = DoodleUtil.a(paramItem, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.getWidth(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.getHeight(), paramFloat1, paramFloat2, paramFloat3);
      File localFile;
      Object localObject;
      if (localLayerParams != null)
      {
        if ((paramItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) || (!(paramItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof URLDrawable))) {
          break label228;
        }
        localFile = ((URLDrawable)paramItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getFileInLocal();
        if ((localFile == null) || (!localFile.exists())) {
          break label228;
        }
        localObject = a();
        if (((paramItem.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null)) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b())) {
          localObject = a();
        }
      }
      label228:
      for (boolean bool = ((FaceLayer)localObject).a(paramItem.g, paramItem.c, paramItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable, localLayerParams, localFile.getAbsolutePath(), true, paramItem.jdField_a_of_type_Int, d(), paramSegmentKeeper); bool; bool = false)
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener.a(paramItem);
        VideoEditReport.a("0X80076CE");
        e(this.jdField_b_of_type_Boolean);
        return;
        SLog.e("DoodleLayout", "create FaceLayer.ItemParams failed.");
        return;
      }
    }
  }
  
  public void a(Map<Long, TrackerStickerParam.MotionInfo> paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoodleLayout", 2, "notifyFinishMotionTrack");
    }
    ThreadManager.getUIHandler().post(new DoodleLayout.12(this, paramMap));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_DovComQqImCaptureLayerPickLayer.d(paramBoolean);
  }
  
  public void a(boolean paramBoolean1, float paramFloat, int paramInt1, int paramInt2, PointF paramPointF, boolean paramBoolean2, int paramInt3)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerGuideLineLayer == null) {
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerGuideLineLayer.a(paramBoolean1, paramFloat, paramInt1, paramInt2, paramPointF, paramBoolean2, paramInt3);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoodleLayout", 2, "show limitView in doodleLayout  , mStoryGuideLineView : " + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView);
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView == null) {
      return;
    }
    if (paramBoolean4)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.a(true);
      if (!paramBoolean2) {
        break label89;
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.b();
    }
    for (;;)
    {
      if (!paramBoolean1) {
        break label99;
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.d();
      return;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.a();
      break;
      label89:
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.c();
    }
    label99:
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.e();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    if (this.jdField_h_of_type_Boolean) {}
    do
    {
      return;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle != null) {
        break;
      }
    } while (!(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener instanceof AECaptureController));
    if (QLog.isColorLevel()) {
      QLog.d("DoodleLayout", 2, "mEditDoodlePart == null && mListener instanceof QIMCaptureController/AECaptureController, showLimitBorder");
    }
    a(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("DoodleLayout", 2, "mEditDoodlePart != null || mListener is not instanceof QIMCaptureController/AECaptureController, broadcast showLimitBorder message");
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a.a(Message.obtain(null, 15, 0, 0, new EditVideoLimitRegion.LimitMessage(paramBoolean3, paramBoolean4, paramBoolean2, paramBoolean1, paramBoolean5)));
  }
  
  protected void a(View... paramVarArgs)
  {
    int n = paramVarArgs.length;
    int m = 0;
    while (m < n)
    {
      View localView = paramVarArgs[m];
      if (localView != null) {
        localView.setVisibility(4);
      }
      m += 1;
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener != null) {
      return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener.b();
    }
    return true;
  }
  
  public boolean a(float paramFloat1, float paramFloat2, Rect paramRect, float paramFloat3)
  {
    boolean bool = false;
    if (paramRect == null) {}
    for (int m = 0;; m = paramRect.width() / 2)
    {
      if ((paramFloat1 < -m) || (paramFloat2 < -m) || (paramFloat1 > this.jdField_a_of_type_AndroidGraphicsRect.width() + m) || (paramFloat2 > m + this.jdField_a_of_type_AndroidGraphicsRect.height() + paramFloat3)) {
        bool = true;
      }
      return bool;
    }
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(paramInt, false);
  }
  
  public boolean a(TextLayer.TextItem paramTextItem, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) && (paramTextItem != null))
    {
      if (paramBoolean) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setVisibility(0);
      }
      w();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.a(paramTextItem);
      paramTextItem.jdField_k_of_type_Boolean = true;
      Object localObject = paramTextItem.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper;
      if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a()) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        ((SegmentKeeper)localObject).lockData(paramBoolean);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.requestLayout();
        localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a();
        if ((localObject != null) && (((TextFaceEditLayer)localObject).a != null) && (paramTextItem.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null) && (paramTextItem.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a()))
        {
          paramTextItem.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.c();
          ((TextFaceEditLayer)localObject).a.a(paramTextItem, paramTextItem.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b(), 0, 0.0F, 0.0F);
        }
        return true;
      }
    }
    return false;
  }
  
  public byte[] a(int paramInt)
  {
    DoodleLayout.LayerCollection localLayerCollection = (DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localLayerCollection == null) {
      return null;
    }
    return localLayerCollection.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerLineLayer.a();
  }
  
  public int[] a(int paramInt)
  {
    Object localObject = (DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject != null)
    {
      localObject = ((DoodleLayout.LayerCollection)localObject).jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerLineLayer.a.a();
      SLog.b("DoodleLayout", "normal path count:" + localObject[0] + ",mosaic path count:" + localObject[1]);
      return localObject;
    }
    return new int[] { 0, 0 };
  }
  
  public int b()
  {
    int m = 0;
    int n = 0;
    while (m < this.jdField_b_of_type_AndroidUtilSparseArray.size())
    {
      DoodleLayout.LayerCollection localLayerCollection = (DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(m);
      n = n + localLayerCollection.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer.b() + localLayerCollection.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerLineLayer.b() + localLayerCollection.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.b() + localLayerCollection.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerDynamicFaceLayer.b();
      m += 1;
    }
    return n;
  }
  
  public Bitmap b()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleBtnOperationHelper == null) {
      return null;
    }
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleBtnOperationHelper.b();
  }
  
  public String b()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject1 = a();
      if ((localObject1 != null) && (((TextLayer)localObject1).jdField_a_of_type_JavaUtilArrayList != null) && (!((TextLayer)localObject1).jdField_a_of_type_JavaUtilArrayList.isEmpty()))
      {
        localObject1 = ((TextLayer)localObject1).jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (TextLayer.TextItem)((Iterator)localObject1).next();
          if (((TextLayer.TextItem)localObject2).jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null)
          {
            localObject2 = DynamicTextBuilder.a(((TextLayer.TextItem)localObject2).jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.c());
            if ((localObject2 != null) && (((List)localObject2).size() > 0))
            {
              localObject2 = (String)((List)localObject2).get(0);
              if (!TextUtils.isEmpty((CharSequence)localObject2))
              {
                localStringBuilder.append((String)localObject2);
                localStringBuilder.append(",");
              }
            }
          }
        }
      }
      if (localException.length() <= 0) {
        break label155;
      }
    }
    catch (Exception localException)
    {
      return "empty";
    }
    localException.deleteCharAt(localException.length() - 1);
    return localException.toString();
    label155:
    return "empty";
  }
  
  public List<FaceLayer.FaceItem> b(int paramInt)
  {
    DoodleLayout.LayerCollection localLayerCollection = (DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localLayerCollection != null)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(localLayerCollection.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.b);
      localArrayList.addAll(localLayerCollection.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerDynamicFaceLayer.b);
      SLog.b("DoodleLayout", "Using poi list:" + localArrayList.toString());
      return Collections.unmodifiableList(localArrayList);
    }
    return Collections.emptyList();
  }
  
  protected void b()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      throw new IllegalStateException("Only the original thread that created a view hierarchy can touch its views.");
    }
  }
  
  protected void b(int paramInt)
  {
    a(paramInt, null);
  }
  
  public void b(boolean paramBoolean)
  {
    DynamicFaceLayer localDynamicFaceLayer = a();
    if (localDynamicFaceLayer != null) {
      localDynamicFaceLayer.a(paramBoolean);
    }
  }
  
  protected void b(View... paramVarArgs)
  {
    int n = paramVarArgs.length;
    int m = 0;
    while (m < n)
    {
      View localView = paramVarArgs[m];
      if (localView != null) {
        localView.setVisibility(0);
      }
      m += 1;
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.c();
  }
  
  public boolean b(int paramInt)
  {
    return this.jdField_b_of_type_AndroidUtilSparseBooleanArray.get(paramInt, false);
  }
  
  public int[] b(int paramInt)
  {
    Object localObject = (DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject != null)
    {
      localObject = ((DoodleLayout.LayerCollection)localObject).jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.a();
      SLog.b("DoodleLayout", "normal face count:" + localObject[0] + ",location face count:" + localObject[1]);
      return localObject;
    }
    return new int[] { 0, 0 };
  }
  
  public int c()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public String c()
  {
    Object localObject;
    FaceLayer.FaceItem localFaceItem;
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localObject = a();
      if ((localObject != null) && (((FaceLayer)localObject).jdField_a_of_type_JavaUtilList != null) && (!((FaceLayer)localObject).jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        localObject = ((FaceLayer)localObject).jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localFaceItem = (FaceLayer.FaceItem)((Iterator)localObject).next();
          if ((localFaceItem != null) && (!TextUtils.isEmpty(localFaceItem.e)))
          {
            localStringBuilder.append(localFaceItem.e);
            localStringBuilder.append(",");
          }
        }
      }
      localObject = a();
    }
    catch (Exception localException)
    {
      return "empty";
    }
    if ((localObject != null) && (((DynamicFaceLayer)localObject).jdField_a_of_type_JavaUtilList != null) && (!((DynamicFaceLayer)localObject).jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      localObject = ((DynamicFaceLayer)localObject).jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localFaceItem = (FaceLayer.FaceItem)((Iterator)localObject).next();
        if ((localFaceItem != null) && (!TextUtils.isEmpty(localFaceItem.e)))
        {
          localException.append(localFaceItem.e);
          localException.append(",");
        }
      }
    }
    if (localException.length() > 0)
    {
      localException.deleteCharAt(localException.length() - 1);
      return localException.toString();
    }
    return "empty";
  }
  
  public void c()
  {
    LineLayer localLineLayer = a();
    if (localLineLayer != null) {
      localLineLayer.d();
    }
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a() == a());
  }
  
  public boolean c(int paramInt)
  {
    Object localObject = (DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject != null)
    {
      localObject = ((DoodleLayout.LayerCollection)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (!((BaseLayer)((Iterator)localObject).next()).a()) {
          return false;
        }
      }
    }
    return true;
  }
  
  public int d()
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView == null) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a() == 1)) {}
    while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a() != 0) {
      return 1;
    }
    return 0;
  }
  
  public String d()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject1 = a();
      if ((localObject1 != null) && (((TextLayer)localObject1).jdField_a_of_type_JavaUtilArrayList != null) && (!((TextLayer)localObject1).jdField_a_of_type_JavaUtilArrayList.isEmpty()))
      {
        localObject1 = ((TextLayer)localObject1).jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (TextLayer.TextItem)((Iterator)localObject1).next();
          if (((TextLayer.TextItem)localObject2).jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null)
          {
            localObject2 = DynamicTextBuilder.a(((TextLayer.TextItem)localObject2).jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.c());
            if ((localObject2 != null) && (((List)localObject2).size() > 0))
            {
              localObject2 = (String)((List)localObject2).get(0);
              if (!TextUtils.isEmpty((CharSequence)localObject2))
              {
                localStringBuilder.append((String)localObject2);
                localStringBuilder.append("|");
              }
            }
          }
        }
      }
      if (localException.length() <= 0) {
        break label155;
      }
    }
    catch (Exception localException)
    {
      return "";
    }
    localException.deleteCharAt(localException.length() - 1);
    return localException.toString();
    label155:
    return "";
  }
  
  public void d()
  {
    ThreadManager.getUIHandler().post(new DoodleLayout.6(this));
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a() == this.jdField_a_of_type_DovComQqImCaptureLayerPickLayer);
  }
  
  public String e()
  {
    StringBuilder localStringBuilder;
    Iterator localIterator;
    FaceLayer.FaceItem localFaceItem;
    String str;
    try
    {
      localStringBuilder = new StringBuilder();
      Object localObject1 = a();
      if ((localObject1 != null) && (((FaceLayer)localObject1).jdField_a_of_type_JavaUtilList != null) && (!((FaceLayer)localObject1).jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        localIterator = ((FaceLayer)localObject1).jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          localFaceItem = (FaceLayer.FaceItem)localIterator.next();
          if ((localFaceItem != null) && (!TextUtils.isEmpty(localFaceItem.e)))
          {
            str = localFaceItem.d;
            localObject1 = str;
            if (TextUtils.isEmpty(str)) {
              localObject1 = "none";
            }
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append("_");
            localStringBuilder.append(localFaceItem.e);
            localStringBuilder.append("|");
          }
        }
      }
      localObject2 = a();
    }
    catch (Exception localException)
    {
      return "";
    }
    Object localObject2;
    if ((localObject2 != null) && (((DynamicFaceLayer)localObject2).jdField_a_of_type_JavaUtilList != null) && (!((DynamicFaceLayer)localObject2).jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      localIterator = ((DynamicFaceLayer)localObject2).jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localFaceItem = (FaceLayer.FaceItem)localIterator.next();
        if ((localFaceItem != null) && (!TextUtils.isEmpty(localFaceItem.e)))
        {
          str = localFaceItem.d;
          localObject2 = str;
          if (TextUtils.isEmpty(str)) {
            localObject2 = "none";
          }
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append("_");
          localStringBuilder.append(localFaceItem.e);
          localStringBuilder.append("|");
        }
      }
    }
    if (localStringBuilder.length() > 0)
    {
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public void e()
  {
    b();
    LineLayer localLineLayer = a();
    SLog.b("DoodleLayout", "undo, activeLayer:" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a() + ",pathCount:" + localLineLayer.a.b());
    if (localLineLayer.d())
    {
      localLineLayer.e();
      if (localLineLayer.a.b() == 0) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(false);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(true);
  }
  
  public boolean e()
  {
    return this.jdField_h_of_type_Boolean;
  }
  
  public void f()
  {
    b();
    SLog.b("DoodleLayout", "onFacePressed, buttonState:" + this.jdField_d_of_type_Int + ",activeLayer:" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a());
    VideoEditReport.a("0X80076BA", VideoEditReport.jdField_b_of_type_Int);
    if (this.jdField_d_of_type_Int == 0) {}
    for (;;)
    {
      a(1);
      do
      {
        return;
        if (this.jdField_d_of_type_Int != 3) {
          break;
        }
        a(1);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiEditTextDialog.a(false);
      } while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView == null);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a(true);
      return;
      if (this.jdField_d_of_type_Int == 2)
      {
        a().d(false);
        a(new View[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout });
      }
    }
  }
  
  public void g()
  {
    if (this.jdField_d_of_type_Int == 3)
    {
      a(0);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiEditTextDialog.a(false);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a(true);
      }
    }
  }
  
  public void h()
  {
    if (this.jdField_d_of_type_Int == 3)
    {
      a(0);
      b(0);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiEditTextDialog.a(false);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a(true);
      }
    }
  }
  
  public void i()
  {
    if (this.jdField_d_of_type_Int == 3)
    {
      a(0);
      b(0);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiEditTextDialog.a(false);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a(true);
      }
    }
  }
  
  public void j()
  {
    b();
    SLog.b("DoodleLayout", "onTextPressed, buttonState:" + this.jdField_d_of_type_Int + ",activeLayer:" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a());
    a().d(true);
    DynamicTextItem localDynamicTextItem = a().a(d());
    a(a().a(), false);
    if (localDynamicTextItem != null)
    {
      a(localDynamicTextItem, 0, 0);
      return;
    }
    QQToast.a(getContext(), getContext().getString(2131698302), 0).a();
    ThreadManager.getUIHandler().post(new DoodleLayout.9(this));
  }
  
  public void k()
  {
    b();
    SLog.b("DoodleLayout", "onLinePressed, buttonState:" + this.jdField_d_of_type_Int + ",activeLayer:" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a());
    VideoEditReport.a("0X80076B8", VideoEditReport.jdField_b_of_type_Int);
    LineLayer localLineLayer = a();
    b(new View[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout });
    localLineLayer.d(true);
    t();
    if (localLineLayer.a.b() > 0)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(true);
      if (this.jdField_d_of_type_Int != 0) {
        break label128;
      }
    }
    for (;;)
    {
      a(2);
      label128:
      do
      {
        return;
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(false);
        break;
        if (this.jdField_d_of_type_Int != 3) {
          break label165;
        }
        a(2);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiEditTextDialog.a(false);
      } while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView == null);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a(true);
      return;
      label165:
      if (this.jdField_d_of_type_Int == 1)
      {
        b(new View[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView });
        setDoodleGLViewVisibility(0);
      }
    }
  }
  
  public void l()
  {
    b();
    b(new View[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView, this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView });
    setDoodleGLViewVisibility(0);
    a(new View[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout, this.jdField_a_of_type_AndroidWidgetRelativeLayout });
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(false);
    if ((this.jdField_d_of_type_Int == 3) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiEditTextDialog != null))
    {
      a(0);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiEditTextDialog.a(false);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a(true);
      }
      return;
    }
    a(0);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.f();
    this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.f();
  }
  
  public void m()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.i();
  }
  
  public void n()
  {
    this.jdField_d_of_type_Boolean = true;
    int m = 0;
    while (m < this.jdField_b_of_type_AndroidUtilSparseArray.size())
    {
      TextLayer localTextLayer = ((DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(m)).jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer;
      localTextLayer.a(null);
      localTextLayer.a(null);
      m += 1;
    }
  }
  
  public void o()
  {
    if (this.jdField_d_of_type_Int == 6)
    {
      a(2, Boolean.valueOf(false));
      a(2);
      if (a().a.b() <= 0) {
        break label135;
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(true);
    }
    for (;;)
    {
      b(new View[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout });
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(500L);
      localAlphaAnimation.setFillAfter(true);
      localAlphaAnimation.setAnimationListener(new DoodleLayout.10(this));
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.startAnimation(localAlphaAnimation);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleBtnOperationHelper != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleBtnOperationHelper.b(localAlphaAnimation);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Personality", 2, "exitFullScreen");
      }
      return;
      label135:
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(false);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_b_of_type_Long > System.currentTimeMillis()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((!a(false)) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener != null)) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener.n();
      }
    }
  }
  
  public void onDetachedFromWindow()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.c();
    this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.c();
    if (this.jdField_e_of_type_Boolean) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleTextureView.b();
    }
    super.onDetachedFromWindow();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a() == this.jdField_a_of_type_DovComQqImCaptureLayerPickLayer)
    {
      b(7);
      BaseLayer localBaseLayer = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(paramMotionEvent);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setActiveLayer(localBaseLayer);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setTopLevelLayer(localBaseLayer);
      localBaseLayer.d(paramMotionEvent);
      this.l = true;
    }
    do
    {
      return true;
      if (!this.l) {
        break;
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a().d(paramMotionEvent);
    } while ((paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3));
    this.l = false;
    return true;
    this.l = false;
    return false;
  }
  
  public void p()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener.m();
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.d();
    }
    e(this.jdField_b_of_type_Boolean);
  }
  
  public void q()
  {
    MosaicOperator localMosaicOperator = (MosaicOperator)a().a(104);
    if (localMosaicOperator != null) {
      localMosaicOperator.e();
    }
  }
  
  public void r()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.invalidate();
  }
  
  public void s()
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null))
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.getLayoutParams();
      localLayoutParams.bottomMargin = 0;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setLayoutParams(localLayoutParams);
    }
  }
  
  public void setDoodleBitmapMaxSize(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      SLog.e("DoodleLayout", "width or height is illegal, width=" + paramInt1 + ",height=" + paramInt2);
    }
    for (;;)
    {
      return;
      SLog.b("DoodleLayout", "setDoodleBitmapMaxSize, maxWidth" + paramInt1 + ",maxHeight:" + paramInt2);
      this.jdField_h_of_type_Int = paramInt1;
      this.jdField_i_of_type_Int = paramInt2;
      int m = 0;
      while (m < this.jdField_a_of_type_AndroidUtilSparseArray.size())
      {
        ((DoodleConfig)this.jdField_a_of_type_AndroidUtilSparseArray.get(m)).jdField_a_of_type_Int = paramInt1;
        ((DoodleConfig)this.jdField_a_of_type_AndroidUtilSparseArray.get(m)).jdField_b_of_type_Int = paramInt2;
        m += 1;
      }
    }
  }
  
  public void setDoodleBtnOperationHelper(DoodleLayout.DoodleBtnOperationHelper paramDoodleBtnOperationHelper)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleBtnOperationHelper = paramDoodleBtnOperationHelper;
  }
  
  public void setDoodleEventListener(DoodleLayout.DoodleEventListener paramDoodleEventListener)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener = paramDoodleEventListener;
  }
  
  @TargetApi(14)
  public void setDoodleGLViewVisibility(int paramInt)
  {
    if (!this.jdField_e_of_type_Boolean) {
      return;
    }
    if (!this.jdField_c_of_type_Boolean)
    {
      SLog.b("DoodleLayout", "setDoodleGLViewVisibility, soload failed, glview default invisible");
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleTextureView.setVisibility(4);
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleTextureView.a(paramInt);
  }
  
  public void setEditMode(boolean paramBoolean)
  {
    this.jdField_h_of_type_Boolean = true;
    this.jdField_i_of_type_Boolean = paramBoolean;
  }
  
  public void setEditVideoDoodle(EditVideoDoodle paramEditVideoDoodle)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle = paramEditVideoDoodle;
  }
  
  public void setEditVideoParams(EditVideoParams paramEditVideoParams)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(paramEditVideoParams);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a(paramEditVideoParams);
    jdField_a_of_type_Boolean = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a();
    x();
  }
  
  public void setFaceLayerPosition(long paramLong)
  {
    int n = 0;
    Object localObject1 = a();
    int m;
    if (localObject1 != null)
    {
      localObject1 = ((FaceLayer)localObject1).jdField_a_of_type_JavaUtilList;
      m = 0;
    }
    for (;;)
    {
      TrackerStickerParam.MotionInfo localMotionInfo;
      float f1;
      if (m < ((List)localObject1).size())
      {
        FaceLayer.FaceItem localFaceItem = (FaceLayer.FaceItem)((List)localObject1).get(m);
        try
        {
          localMotionInfo = (TrackerStickerParam.MotionInfo)localFaceItem.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
          if (localMotionInfo == null) {
            break label535;
          }
          if (!localMotionInfo.isLost)
          {
            localFaceItem.jdField_a_of_type_AndroidGraphicsPointF.set(0.0F, 0.0F);
            localFaceItem.s = localMotionInfo.x;
            localFaceItem.t = localMotionInfo.y;
            f1 = localFaceItem.o;
            localFaceItem.q = (localMotionInfo.scale * f1);
          }
          else
          {
            localFaceItem.jdField_a_of_type_AndroidGraphicsPointF.set(-2000.0F, 0.0F);
            localFaceItem.s = localMotionInfo.x;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          if (!QLog.isColorLevel()) {
            break label535;
          }
        }
        QLog.e("DoodleLayout", 2, "setFaceLayerPosition OOM :" + localOutOfMemoryError);
      }
      else
      {
        localObject1 = a();
        Object localObject2;
        if (localObject1 != null)
        {
          localObject1 = ((FaceLayer)localObject1).jdField_a_of_type_JavaUtilList;
          m = 0;
          if (m < ((List)localObject1).size())
          {
            localObject2 = (FaceLayer.FaceItem)((List)localObject1).get(m);
            localMotionInfo = (TrackerStickerParam.MotionInfo)((FaceLayer.FaceItem)localObject2).jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
            if (localMotionInfo != null)
            {
              if (localMotionInfo.isLost) {
                break label332;
              }
              ((FaceLayer.FaceItem)localObject2).jdField_a_of_type_AndroidGraphicsPointF.set(0.0F, 0.0F);
              ((FaceLayer.FaceItem)localObject2).s = localMotionInfo.x;
              ((FaceLayer.FaceItem)localObject2).t = localMotionInfo.y;
              f1 = ((FaceLayer.FaceItem)localObject2).o;
              ((FaceLayer.FaceItem)localObject2).q = (localMotionInfo.scale * f1);
            }
            for (;;)
            {
              m += 1;
              break;
              label332:
              ((FaceLayer.FaceItem)localObject2).jdField_a_of_type_AndroidGraphicsPointF.set(-2000.0F, 0.0F);
              ((FaceLayer.FaceItem)localObject2).s = localMotionInfo.x;
            }
          }
        }
        localObject1 = a();
        if (localObject1 != null)
        {
          localObject1 = ((TextLayer)localObject1).jdField_a_of_type_JavaUtilArrayList;
          m = n;
          if (m < ((List)localObject1).size())
          {
            localObject2 = (TextLayer.TextItem)((List)localObject1).get(m);
            localMotionInfo = (TrackerStickerParam.MotionInfo)((TextLayer.TextItem)localObject2).jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
            if (localMotionInfo != null)
            {
              if (localMotionInfo.isLost) {
                break label494;
              }
              ((TextLayer.TextItem)localObject2).jdField_a_of_type_AndroidGraphicsPointF.set(0.0F, 0.0F);
              ((TextLayer.TextItem)localObject2).s = localMotionInfo.x;
              ((TextLayer.TextItem)localObject2).t = localMotionInfo.y;
              f1 = ((TextLayer.TextItem)localObject2).o;
              ((TextLayer.TextItem)localObject2).q = (localMotionInfo.scale * f1);
            }
            for (;;)
            {
              m += 1;
              break;
              label494:
              ((TextLayer.TextItem)localObject2).jdField_a_of_type_AndroidGraphicsPointF.set(-2000.0F, 0.0F);
              ((TextLayer.TextItem)localObject2).s = localMotionInfo.x;
            }
          }
        }
        ThreadManager.getUIHandler().post(new DoodleLayout.11(this));
        return;
      }
      label535:
      m += 1;
    }
  }
  
  public void setLocation(TroopBarPOI paramTroopBarPOI)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$FaceItem == null)
    {
      SLog.e("DoodleLayout", "ClickFaceItem not found.");
      return;
    }
    SLog.b("DoodleLayout", "setLocation: clickItem-->" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$FaceItem);
    a().a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$FaceItem, paramTroopBarPOI);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$FaceItem = null;
  }
  
  public void setMosaicSize(int paramInt)
  {
    int m = paramInt;
    if (paramInt < 1)
    {
      SLog.e("DoodleLayout", "MosaicSize little than 1.");
      m = 1;
    }
    this.jdField_e_of_type_Int = m;
    paramInt = 0;
    while (paramInt < this.jdField_b_of_type_AndroidUtilSparseArray.size())
    {
      MosaicOperator localMosaicOperator = (MosaicOperator)((DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(paramInt)).jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerLineLayer.a(103);
      if (localMosaicOperator != null) {
        localMosaicOperator.b(m);
      }
      paramInt += 1;
    }
  }
  
  public void setMosaicStandardSize(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      SLog.e("DoodleLayout", "StandardMosaicSize, width or height <= 0. width:" + paramInt1 + ",height:" + paramInt2);
    }
    for (;;)
    {
      return;
      this.jdField_f_of_type_Int = paramInt1;
      this.jdField_g_of_type_Int = paramInt2;
      int m = 0;
      while (m < this.jdField_b_of_type_AndroidUtilSparseArray.size())
      {
        MosaicOperator localMosaicOperator = (MosaicOperator)((DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(m)).jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerLineLayer.a(103);
        if (localMosaicOperator != null) {
          localMosaicOperator.b(paramInt1, paramInt2);
        }
        m += 1;
      }
    }
  }
  
  public void setOnTextDialogShowListener(DoodleLayout.OnTextDialogShowListener paramOnTextDialogShowListener)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$OnTextDialogShowListener = paramOnTextDialogShowListener;
  }
  
  public void setRecording(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public void setTimeStamp(long paramLong, boolean paramBoolean)
  {
    if ((!this.jdField_g_of_type_Boolean) || (paramBoolean))
    {
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setTimeStamp(paramLong);
      }
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setTimeStamp(paramLong);
      }
      if (this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView != null) {
        this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setTimeStamp(paramLong);
      }
    }
  }
  
  public void setTrackerState(GestureHelper.ZoomItem paramZoomItem, int paramInt)
  {
    if (paramZoomItem == null) {}
    do
    {
      return;
      paramZoomItem.jdField_i_of_type_Int = paramInt;
    } while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener == null);
    if (!paramZoomItem.a())
    {
      float f3 = paramZoomItem.jdField_a_of_type_AndroidGraphicsPointF.x + paramZoomItem.s - paramZoomItem.u / 2.0F;
      float f4 = paramZoomItem.jdField_a_of_type_AndroidGraphicsPointF.y + paramZoomItem.t - paramZoomItem.v / 2.0F;
      float f2 = f4;
      float f1 = f3;
      if (paramZoomItem.jdField_g_of_type_Boolean)
      {
        f2 = f4;
        f1 = f3;
        if (paramZoomItem.jdField_h_of_type_Boolean)
        {
          f1 = paramZoomItem.l + paramZoomItem.j - paramZoomItem.u / 2.0F;
          f2 = paramZoomItem.m + paramZoomItem.jdField_k_of_type_Float - paramZoomItem.v / 2.0F;
        }
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener.a(f1, f2, paramZoomItem.u, paramZoomItem.v);
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener.p();
    paramZoomItem.d();
  }
  
  public void setupPersonality()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)super.findViewById(2131365965));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleTextureView = new DoodleTextureView(super.getContext());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleTextureView, localLayoutParams);
    this.jdField_c_of_type_Boolean = PtvFilterSoLoad.b();
    if (!this.jdField_c_of_type_Boolean)
    {
      a(new View[] { this.jdField_a_of_type_AndroidWidgetFrameLayout });
      setDoodleGLViewVisibility(4);
      this.jdField_e_of_type_Boolean = false;
      return;
    }
    this.jdField_e_of_type_Boolean = true;
    v();
  }
  
  public void t()
  {
    Object localObject = a();
    if (localObject == null) {}
    while ((PureOperator)((LineLayer)localObject).a(101) == null) {
      return;
    }
    if (this.jdField_a_of_type_Int == -1)
    {
      localObject = BaseApplicationImpl.getContext().getSharedPreferences("DoodleLay_State", 4);
      if ((((SharedPreferences)localObject).contains("Line_LastType")) && (((SharedPreferences)localObject).contains("Line_LastSubType"))) {
        break label97;
      }
      this.jdField_a_of_type_Int = 0;
    }
    for (this.jdField_b_of_type_Int = HorizontalStroke.a(a());; this.jdField_b_of_type_Int = ((SharedPreferences)localObject).getInt("Line_LastSubType", 0))
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setSelectedStroke(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      return;
      label97:
      this.jdField_a_of_type_Int = ((SharedPreferences)localObject).getInt("Line_LastType", 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout
 * JD-Core Version:    0.7.0.1
 */