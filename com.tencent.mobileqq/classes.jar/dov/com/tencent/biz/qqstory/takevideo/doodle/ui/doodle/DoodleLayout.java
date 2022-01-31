package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import anil;
import anim;
import anin;
import anio;
import aniq;
import anir;
import anis;
import anit;
import aniu;
import aniv;
import aniw;
import anix;
import aniy;
import aniz;
import anja;
import anjb;
import anjd;
import anje;
import anjg;
import anjh;
import anjk;
import anjl;
import anjm;
import anjn;
import anjo;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam.MotionInfo;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.data.IFaceSelectedListener;
import dov.com.qq.im.capture.layer.PickLayer;
import dov.com.qq.im.capture.text.DynamicTextBuilder;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.qq.im.capture.text.DynamicTextItem.TextMap;
import dov.com.tencent.biz.qqstory.takevideo.EditInteractExport;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalGifSource;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoDoodle;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import dov.com.tencent.biz.qqstory.takevideo.EditVoteExport;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.DynamicFaceLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.EmptyLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.FaceItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.LayerEventListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.LayerParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.InteractPasterLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.InteractPasterLayer.InteractItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.LineLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextFaceEditLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextFaceEditLayer.LayerListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer.TextItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.VoteLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.VoteLayer.VoteItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.base.BaseLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.base.DoodleStrategy;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.config.DoodleConfig;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.config.DoodleConfig.Builder;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.GuideHelper;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.LocationFacePackage.Item;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.DoodleUtil;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper.ZoomItem;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.strategy.ConfigurableLineLayerStrokeStrategy;
import dov.com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
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
  public SparseArray a;
  public SparseBooleanArray a;
  public FrameLayout a;
  public ImageView a;
  public RelativeLayout a;
  public anje a;
  private anjk jdField_a_of_type_Anjk;
  private anjl jdField_a_of_type_Anjl;
  public anjm a;
  private anjo jdField_a_of_type_Anjo = new anjo(this, null);
  protected IFaceSelectedListener a;
  private PickLayer jdField_a_of_type_DovComQqImCaptureLayerPickLayer;
  DynamicTextBuilder jdField_a_of_type_DovComQqImCaptureTextDynamicTextBuilder = new DynamicTextBuilder();
  private EditVideoDoodle jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle;
  public EditVideoParams a;
  public FaceLayer.FaceItem a;
  public InteractPasterLayer a;
  public VoteLayer a;
  public EditTextDialog a;
  private GuideHelper jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiGuideHelper;
  public DoodleEditView a;
  public DoodleLayout.DoodleBtnOperationHelper a;
  public DoodleLayout.DoodleEventListener a;
  public DoodleTextureView a;
  public DoodleView a;
  public GestureHelper.ZoomItem a;
  public HorizontalSelectColorLayout a;
  private RuntimeException jdField_a_of_type_JavaLangRuntimeException;
  private Comparator jdField_a_of_type_JavaUtilComparator = new anil(this);
  private List jdField_a_of_type_JavaUtilList;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  private final Condition jdField_a_of_type_JavaUtilConcurrentLocksCondition = this.jdField_a_of_type_JavaUtilConcurrentLocksLock.newCondition();
  private final Lock jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  public int b;
  private long b;
  public SparseArray b;
  public SparseBooleanArray b;
  public DoodleView b;
  public boolean b;
  private int jdField_c_of_type_Int = -1;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  private long jdField_d_of_type_Long;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = -1;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = -1;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int = -1;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean;
  private int i;
  
  public DoodleLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
    this.jdField_b_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Anjm = new anjm(this, null);
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    LayoutInflater.from(super.getContext()).inflate(2130968950, this);
    t();
    d(this.jdField_a_of_type_Int);
    e(this.jdField_a_of_type_Int);
    this.jdField_h_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  private void a(long paramLong)
  {
    SegmentKeeper.b(-1L * paramLong);
  }
  
  private void a(FaceLayer paramFaceLayer)
  {
    paramFaceLayer = paramFaceLayer.a();
    if ((paramFaceLayer != null) && (!jdField_a_of_type_Boolean) && (d() == 1))
    {
      paramFaceLayer.b(true);
      if (paramFaceLayer.jdField_c_of_type_Boolean) {
        ThreadManager.getUIHandler().post(new anit(this, paramFaceLayer));
      }
    }
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
    a();
    SLog.b("DoodleLayout", "onBackPressed, buttonState:" + this.jdField_b_of_type_Int + ",activeLayer:" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a());
    if ((this.jdField_b_of_type_Int == 0) || ((this.jdField_b_of_type_Int == 2) && (!paramBoolean))) {
      return false;
    }
    j();
    c(0);
    if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.b())
    {
      SLog.b("DoodleLayout", "onBackPressed, resetDoodleView.");
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.f();
    }
    return true;
  }
  
  private void c(GestureHelper.ZoomItem paramZoomItem)
  {
    if (d() == 0) {
      break label7;
    }
    label7:
    label217:
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener == null) || (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener.b()))
      {
        if ((getContext() instanceof QQStoryBaseActivity)) {}
        for (AppInterface localAppInterface = ((QQStoryBaseActivity)getContext()).a;; localAppInterface = null)
        {
          if ((localAppInterface == null) || (SharedPreUtils.z(getContext(), localAppInterface.getCurrentAccountUin()))) {
            break label217;
          }
          if (SharedPreUtils.y(getContext(), localAppInterface.getCurrentAccountUin()))
          {
            SharedPreUtils.J(getContext(), localAppInterface.getCurrentAccountUin());
            return;
          }
          if (paramZoomItem.r != 0.0F) {
            break;
          }
          int j = DisplayUtil.a() / 2;
          int k = (int)(paramZoomItem.jdField_a_of_type_AndroidGraphicsPointF.x + paramZoomItem.s - paramZoomItem.u * paramZoomItem.q / 2.0F);
          int m = paramZoomItem.jdField_j_of_type_Int;
          int n = (int)(paramZoomItem.jdField_a_of_type_AndroidGraphicsPointF.y + paramZoomItem.t + paramZoomItem.v * paramZoomItem.q / 2.0F);
          int i1 = paramZoomItem.jdField_j_of_type_Int;
          if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiGuideHelper == null) {
            break;
          }
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiGuideHelper.a(this, getContext(), localAppInterface.getCurrentAccountUin(), k - m, n + i1 + j);
          return;
        }
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.jdField_g_of_type_Boolean != paramBoolean)
    {
      this.jdField_g_of_type_Boolean = paramBoolean;
      if (paramBoolean)
      {
        SLog.b("DoodleLayout", "rubbish active.");
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(getResources().getColor(2131493773));
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843586);
      }
    }
    else
    {
      return;
    }
    SLog.b("DoodleLayout", "rubbish unActive.");
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(getResources().getColor(2131493772));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843586);
  }
  
  private void d(int paramInt)
  {
    Object localObject1 = (DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    localObject1 = (DoodleConfig)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    int j;
    if (localObject1 == null)
    {
      SLog.b("DoodleLayout", "initDoodleView for the %d video", Integer.valueOf(paramInt));
      Object localObject3 = a();
      localObject1 = (FaceLayer)((DoodleLayout.NormalDoodleStategy)localObject3).a(FaceLayer.jdField_a_of_type_JavaLangString);
      DynamicFaceLayer localDynamicFaceLayer = (DynamicFaceLayer)((DoodleLayout.NormalDoodleStategy)localObject3).a("DynamicFaceLayer");
      Object localObject2 = (LineLayer)((DoodleLayout.NormalDoodleStategy)localObject3).a("LineLayer");
      TextLayer localTextLayer = (TextLayer)((DoodleLayout.NormalDoodleStategy)localObject3).a(TextLayer.jdField_a_of_type_JavaLangString);
      Object localObject4;
      if (localObject2 != null)
      {
        localObject4 = (MosaicOperator)((LineLayer)localObject2).a(103);
        if ((localObject4 != null) && (this.jdField_c_of_type_Int != -1)) {
          ((MosaicOperator)localObject4).b(this.jdField_c_of_type_Int);
        }
        if ((localObject4 != null) && (this.jdField_d_of_type_Int != -1) && (this.jdField_e_of_type_Int != -1)) {
          ((MosaicOperator)localObject4).b(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int);
        }
      }
      localObject3 = new DoodleConfig.Builder().a((DoodleStrategy)localObject3);
      if (this.jdField_f_of_type_Int != -1)
      {
        j = this.jdField_f_of_type_Int;
        localObject3 = ((DoodleConfig.Builder)localObject3).a(j);
        if (this.jdField_g_of_type_Int == -1) {
          break label469;
        }
        j = this.jdField_g_of_type_Int;
        label219:
        localObject3 = ((DoodleConfig.Builder)localObject3).b(j).a();
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setDoodleConfig((DoodleConfig)localObject3);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setDoodleLayout(this);
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null)
        {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
        }
        localObject4 = new DoodleLayout.LayerCollection(localTextLayer, (LineLayer)localObject2, (FaceLayer)localObject1, localDynamicFaceLayer, (EmptyLayer)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(EmptyLayer.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject3);
        this.jdField_b_of_type_AndroidUtilSparseArray.put(paramInt, localObject4);
        ((LineLayer)localObject2).a(new anjh(this, null));
        ((LineLayer)localObject2).a(new anja(this));
        if (localObject1 != null) {
          ((FaceLayer)localObject1).a(this.jdField_a_of_type_Anjm);
        }
        if (localDynamicFaceLayer != null) {
          localDynamicFaceLayer.a(this.jdField_a_of_type_Anjm);
        }
        localObject2 = new anjb(this);
        if (localObject1 != null) {
          ((FaceLayer)localObject1).a((FaceLayer.LayerEventListener)localObject2);
        }
        localDynamicFaceLayer.a((FaceLayer.LayerEventListener)localObject2);
        if (!this.jdField_c_of_type_Boolean)
        {
          localTextLayer.a(this.jdField_a_of_type_Anjm);
          localTextLayer.a(new anjn(this, null));
        }
        this.jdField_a_of_type_DovComQqImCaptureLayerPickLayer = ((PickLayer)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a("PickLayer"));
      }
    }
    for (;;)
    {
      u();
      this.jdField_e_of_type_Boolean = false;
      return;
      j = 480;
      break;
      label469:
      j = 640;
      break label219;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setDoodleConfig((DoodleConfig)localObject1);
    }
  }
  
  private void e(int paramInt)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer = new VoteLayer(this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerInteractPasterLayer = new InteractPasterLayer(this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
    Object localObject = new anjd(this);
    localObject = new DoodleConfig.Builder().a((DoodleStrategy)localObject);
    if (this.jdField_f_of_type_Int != -1)
    {
      paramInt = this.jdField_f_of_type_Int;
      localObject = ((DoodleConfig.Builder)localObject).a(paramInt);
      if (this.jdField_g_of_type_Int == -1) {
        break label168;
      }
    }
    label168:
    for (paramInt = this.jdField_g_of_type_Int;; paramInt = 640)
    {
      localObject = ((DoodleConfig.Builder)localObject).b(paramInt).a();
      this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setDoodleConfig((DoodleConfig)localObject);
      this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setDoodleLayout(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer.a(this.jdField_a_of_type_Anjo);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer.a(new anim(this));
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerInteractPasterLayer.a(this.jdField_a_of_type_Anjo);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerInteractPasterLayer.a(new anin(this));
      return;
      paramInt = 480;
      break;
    }
  }
  
  private void f(int paramInt)
  {
    Object localObject = a(this.jdField_a_of_type_Int);
    if (localObject != null)
    {
      localObject = ((DoodleLayout.LayerCollection)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        BaseLayer localBaseLayer = (BaseLayer)((Iterator)localObject).next();
        if (localBaseLayer != null) {
          localBaseLayer.a(paramInt);
        }
      }
    }
  }
  
  private void t()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131364346));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131364347));
    this.jdField_a_of_type_DovComQqImCaptureDataIFaceSelectedListener = new anjg(this, null);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout = ((HorizontalSelectColorLayout)super.findViewById(2131364351));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setOnUndoViewClickListener(new aniv(this));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setOnStrokeSelectedListener(new aniw(this));
    v();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView = ((DoodleView)super.findViewById(2131364348));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView = ((DoodleEditView)super.findViewById(2131364352));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setDoodleLayout(this);
    setOnTextDialogShowListener(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setOnLayerTouchListener();
    this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView = ((DoodleView)super.findViewById(2131364350));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiGuideHelper = new GuideHelper();
    j();
  }
  
  private void u()
  {
    LineLayer localLineLayer = a();
    if ((localLineLayer != null) && (this.jdField_d_of_type_Boolean))
    {
      localLineLayer.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleTextureView, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
      localLineLayer.a.a(new anix(this));
      if (this.jdField_d_of_type_Boolean)
      {
        ((PersonalityOperator)localLineLayer.a.a(102)).a(false);
        localLineLayer.a.a(new aniy(this));
        localLineLayer.b();
      }
    }
  }
  
  private void v()
  {
    boolean bool3 = false;
    AppInterface localAppInterface = null;
    if ((super.getContext() instanceof QQStoryBaseActivity)) {
      localAppInterface = ((QQStoryBaseActivity)super.getContext()).a;
    }
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) || ((!(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)) && (!(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalGifSource)))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool3;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null)
      {
        bool2 = bool3;
        if (!EditVideoPartManager.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_b_of_type_Int, 262144))
        {
          bool2 = bool3;
          if (!VideoEnvironment.c()) {
            bool2 = true;
          }
        }
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setStrokeStrategy(new ConfigurableLineLayerStrokeStrategy(localAppInterface, bool1, bool2), true, 2);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setSelectedStrokeWithColor(dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.stroke.HorizontalStroke.a[1]);
      return;
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
      int j = localLayerCollection.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerLineLayer.b();
      int k = localLayerCollection.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.b();
      int m = localLayerCollection.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerDynamicFaceLayer.b();
      SLog.b("DoodleLayout", "DoodleCount: text->" + paramInt + ",line->" + j + ",face->" + k + " " + m);
      return m + (paramInt + j + k);
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
    //   1: getfield 288	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView	Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleView;
    //   4: invokevirtual 753	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleView:b	()I
    //   7: istore_3
    //   8: aload_0
    //   9: getfield 288	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView	Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleView;
    //   12: invokevirtual 755	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleView:c	()I
    //   15: istore 4
    //   17: iload_3
    //   18: ifle +8 -> 26
    //   21: iload 4
    //   23: ifgt +33 -> 56
    //   26: ldc_w 272
    //   29: ldc_w 757
    //   32: iconst_2
    //   33: anewarray 759	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: iload_3
    //   39: invokestatic 433	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   42: aastore
    //   43: dup
    //   44: iconst_1
    //   45: iload 4
    //   47: invokestatic 433	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   50: aastore
    //   51: invokestatic 762	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   54: aconst_null
    //   55: areturn
    //   56: aload_0
    //   57: getfield 93	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   60: iconst_0
    //   61: invokevirtual 765	java/util/concurrent/atomic/AtomicBoolean:getAndSet	(Z)Z
    //   64: ifeq +16 -> 80
    //   67: aload_0
    //   68: iload_3
    //   69: iload 4
    //   71: getstatic 771	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   74: invokestatic 777	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   77: putfield 779	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   80: aload_0
    //   81: getfield 98	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   84: invokeinterface 782 1 0
    //   89: aload_0
    //   90: getfield 779	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   93: astore 7
    //   95: aload 7
    //   97: ifnonnull +123 -> 220
    //   100: ldc_w 272
    //   103: ldc_w 784
    //   106: invokestatic 786	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   109: aload_0
    //   110: getfield 106	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaUtilConcurrentLocksCondition	Ljava/util/concurrent/locks/Condition;
    //   113: ldc2_w 787
    //   116: getstatic 794	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   119: invokeinterface 800 4 0
    //   124: ifne -35 -> 89
    //   127: ldc_w 272
    //   130: ldc_w 802
    //   133: iconst_1
    //   134: anewarray 759	java/lang/Object
    //   137: dup
    //   138: iconst_0
    //   139: invokestatic 808	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   142: invokevirtual 812	java/lang/Thread:getId	()J
    //   145: invokestatic 817	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   148: aastore
    //   149: invokestatic 819	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   152: aload_0
    //   153: getfield 821	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaLangRuntimeException	Ljava/lang/RuntimeException;
    //   156: ifnull -67 -> 89
    //   159: ldc_w 272
    //   162: ldc_w 823
    //   165: aload_0
    //   166: getfield 821	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaLangRuntimeException	Ljava/lang/RuntimeException;
    //   169: invokestatic 826	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   172: goto -83 -> 89
    //   175: astore 7
    //   177: ldc_w 272
    //   180: ldc_w 828
    //   183: aload 7
    //   185: invokestatic 826	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   188: goto -99 -> 89
    //   191: astore 7
    //   193: aload_0
    //   194: getfield 98	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   197: invokeinterface 831 1 0
    //   202: aload 7
    //   204: athrow
    //   205: astore 7
    //   207: ldc_w 272
    //   210: ldc_w 833
    //   213: aload 7
    //   215: invokestatic 835	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   218: aconst_null
    //   219: areturn
    //   220: aload_0
    //   221: getfield 779	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   224: astore 7
    //   226: aload_0
    //   227: aconst_null
    //   228: putfield 779	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   231: new 837	android/graphics/Canvas
    //   234: dup
    //   235: aload 7
    //   237: invokespecial 840	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   240: astore 8
    //   242: new 842	android/graphics/Paint
    //   245: dup
    //   246: invokespecial 843	android/graphics/Paint:<init>	()V
    //   249: astore 9
    //   251: aload 9
    //   253: new 845	android/graphics/PorterDuffXfermode
    //   256: dup
    //   257: getstatic 851	android/graphics/PorterDuff$Mode:CLEAR	Landroid/graphics/PorterDuff$Mode;
    //   260: invokespecial 854	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   263: invokevirtual 858	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   266: pop
    //   267: aload 8
    //   269: aload 9
    //   271: invokevirtual 862	android/graphics/Canvas:drawPaint	(Landroid/graphics/Paint;)V
    //   274: aload_0
    //   275: getfield 76	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   278: iload_1
    //   279: invokevirtual 421	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   282: checkcast 423	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout$LayerCollection
    //   285: astore 9
    //   287: aload 9
    //   289: ifnonnull +35 -> 324
    //   292: ldc_w 272
    //   295: ldc_w 864
    //   298: iconst_1
    //   299: anewarray 759	java/lang/Object
    //   302: dup
    //   303: iconst_0
    //   304: iload_1
    //   305: invokestatic 433	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   308: aastore
    //   309: invokestatic 762	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   312: aload_0
    //   313: getfield 98	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   316: invokeinterface 831 1 0
    //   321: aload 7
    //   323: areturn
    //   324: invokestatic 869	android/os/SystemClock:uptimeMillis	()J
    //   327: lstore 5
    //   329: aload 9
    //   331: getfield 725	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout$LayerCollection:jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerLineLayer	Ldov/com/tencent/biz/qqstory/takevideo/doodle/layer/LineLayer;
    //   334: astore 10
    //   336: aload 10
    //   338: getfield 656	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/LineLayer:a	Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleOpController;
    //   341: invokevirtual 871	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleOpController:a	()Z
    //   344: ifeq +142 -> 486
    //   347: ldc_w 272
    //   350: ldc_w 873
    //   353: invokestatic 786	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   356: aload_0
    //   357: getfield 648	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_d_of_type_Boolean	Z
    //   360: ifeq +117 -> 477
    //   363: aload_0
    //   364: getfield 491	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams;
    //   367: ifnull +110 -> 477
    //   370: aload_0
    //   371: getfield 491	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams;
    //   374: getfield 874	dov/com/tencent/biz/qqstory/takevideo/EditVideoParams:jdField_a_of_type_Int	I
    //   377: iconst_1
    //   378: if_icmpne +99 -> 477
    //   381: aload 10
    //   383: getfield 656	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/LineLayer:a	Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleOpController;
    //   386: invokevirtual 875	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleOpController:b	()Z
    //   389: ifeq +88 -> 477
    //   392: iconst_1
    //   393: newarray int
    //   395: astore 11
    //   397: aload 11
    //   399: iconst_0
    //   400: iconst_0
    //   401: iastore
    //   402: iconst_5
    //   403: istore_1
    //   404: aload 10
    //   406: getfield 656	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/LineLayer:a	Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleOpController;
    //   409: new 877	anip
    //   412: dup
    //   413: aload_0
    //   414: aload 10
    //   416: iload_3
    //   417: aload 11
    //   419: invokespecial 880	anip:<init>	(Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout;Ldov/com/tencent/biz/qqstory/takevideo/doodle/layer/LineLayer;I[I)V
    //   422: invokevirtual 883	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleOpController:a	(Ljava/lang/Runnable;)V
    //   425: aload 11
    //   427: iconst_0
    //   428: iaload
    //   429: istore_3
    //   430: iload_3
    //   431: iconst_1
    //   432: if_icmpeq +54 -> 486
    //   435: iload_1
    //   436: iconst_1
    //   437: isub
    //   438: istore_3
    //   439: iload_1
    //   440: ifle +46 -> 486
    //   443: ldc2_w 787
    //   446: invokestatic 886	java/lang/Thread:sleep	(J)V
    //   449: ldc_w 272
    //   452: ldc_w 888
    //   455: iload_3
    //   456: invokestatic 433	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   459: invokestatic 436	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   462: iload_3
    //   463: istore_1
    //   464: goto -39 -> 425
    //   467: astore 12
    //   469: aload 12
    //   471: invokevirtual 891	java/lang/InterruptedException:printStackTrace	()V
    //   474: goto -25 -> 449
    //   477: aload 10
    //   479: getfield 656	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/LineLayer:a	Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleOpController;
    //   482: iload_3
    //   483: invokevirtual 892	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleOpController:b	(I)V
    //   486: aload_0
    //   487: getfield 491	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams;
    //   490: ifnull +20 -> 510
    //   493: aload_0
    //   494: getfield 491	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams;
    //   497: invokevirtual 893	dov/com/tencent/biz/qqstory/takevideo/EditVideoParams:a	()Z
    //   500: ifeq +10 -> 510
    //   503: aload 10
    //   505: aload 8
    //   507: invokevirtual 896	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/LineLayer:c	(Landroid/graphics/Canvas;)V
    //   510: new 898	java/util/LinkedList
    //   513: dup
    //   514: aload 9
    //   516: getfield 582	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout$LayerCollection:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   519: invokespecial 901	java/util/LinkedList:<init>	(Ljava/util/Collection;)V
    //   522: astore 9
    //   524: aload 9
    //   526: aload_0
    //   527: getfield 120	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaUtilComparator	Ljava/util/Comparator;
    //   530: invokestatic 907	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   533: aload 9
    //   535: invokevirtual 910	java/util/LinkedList:size	()I
    //   538: iconst_1
    //   539: isub
    //   540: istore_1
    //   541: iload_1
    //   542: iflt +29 -> 571
    //   545: aload 9
    //   547: iload_1
    //   548: invokevirtual 911	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   551: checkcast 599	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/base/BaseLayer
    //   554: astore 10
    //   556: aload 10
    //   558: ifnull +113 -> 671
    //   561: aload 10
    //   563: aload 8
    //   565: invokevirtual 913	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/base/BaseLayer:b	(Landroid/graphics/Canvas;)V
    //   568: goto +103 -> 671
    //   571: iload_2
    //   572: ifeq +49 -> 621
    //   575: aload 9
    //   577: invokevirtual 910	java/util/LinkedList:size	()I
    //   580: iconst_1
    //   581: isub
    //   582: istore_1
    //   583: iload_1
    //   584: iflt +37 -> 621
    //   587: aload 9
    //   589: iload_1
    //   590: invokevirtual 911	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   593: checkcast 599	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/base/BaseLayer
    //   596: astore 10
    //   598: aload 10
    //   600: ifnull +64 -> 664
    //   603: aload 10
    //   605: instanceof 451
    //   608: ifeq +56 -> 664
    //   611: aload 10
    //   613: checkcast 451	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/DynamicFaceLayer
    //   616: aload 8
    //   618: invokevirtual 914	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/DynamicFaceLayer:c	(Landroid/graphics/Canvas;)V
    //   621: ldc_w 272
    //   624: new 274	java/lang/StringBuilder
    //   627: dup
    //   628: invokespecial 275	java/lang/StringBuilder:<init>	()V
    //   631: ldc_w 916
    //   634: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: invokestatic 869	android/os/SystemClock:uptimeMillis	()J
    //   640: lload 5
    //   642: lsub
    //   643: invokevirtual 919	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   646: invokevirtual 300	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   649: invokestatic 305	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   652: aload_0
    //   653: getfield 98	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   656: invokeinterface 831 1 0
    //   661: aload 7
    //   663: areturn
    //   664: iload_1
    //   665: iconst_1
    //   666: isub
    //   667: istore_1
    //   668: goto -85 -> 583
    //   671: iload_1
    //   672: iconst_1
    //   673: isub
    //   674: istore_1
    //   675: goto -134 -> 541
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	678	0	this	DoodleLayout
    //   0	678	1	paramInt	int
    //   0	678	2	paramBoolean	boolean
    //   7	476	3	j	int
    //   15	55	4	k	int
    //   327	314	5	l	long
    //   93	3	7	localBitmap1	Bitmap
    //   175	9	7	localInterruptedException1	java.lang.InterruptedException
    //   191	12	7	localObject1	Object
    //   205	9	7	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   224	438	7	localBitmap2	Bitmap
    //   240	377	8	localCanvas	android.graphics.Canvas
    //   249	339	9	localObject2	Object
    //   334	278	10	localObject3	Object
    //   395	31	11	arrayOfInt	int[]
    //   467	3	12	localInterruptedException2	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   100	172	175	java/lang/InterruptedException
    //   89	95	191	finally
    //   100	172	191	finally
    //   177	188	191	finally
    //   220	287	191	finally
    //   292	312	191	finally
    //   324	397	191	finally
    //   404	425	191	finally
    //   443	449	191	finally
    //   449	462	191	finally
    //   469	474	191	finally
    //   477	486	191	finally
    //   486	510	191	finally
    //   510	541	191	finally
    //   545	556	191	finally
    //   561	568	191	finally
    //   575	583	191	finally
    //   587	598	191	finally
    //   603	621	191	finally
    //   621	652	191	finally
    //   67	80	205	java/lang/OutOfMemoryError
    //   443	449	467	java/lang/InterruptedException
  }
  
  public IFaceSelectedListener a()
  {
    return this.jdField_a_of_type_DovComQqImCaptureDataIFaceSelectedListener;
  }
  
  public DynamicFaceLayer a()
  {
    DoodleLayout.LayerCollection localLayerCollection = (DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Int);
    if (localLayerCollection == null)
    {
      SLog.d("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
      return null;
    }
    return localLayerCollection.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerDynamicFaceLayer;
  }
  
  public EmptyLayer a()
  {
    DoodleLayout.LayerCollection localLayerCollection = (DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Int);
    if (localLayerCollection == null)
    {
      SLog.d("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
      return null;
    }
    return localLayerCollection.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerEmptyLayer;
  }
  
  public FaceLayer a()
  {
    DoodleLayout.LayerCollection localLayerCollection = (DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Int);
    if (localLayerCollection == null)
    {
      SLog.d("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
      return null;
    }
    return localLayerCollection.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer;
  }
  
  public InteractPasterLayer a()
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerInteractPasterLayer;
  }
  
  public LineLayer a()
  {
    DoodleLayout.LayerCollection localLayerCollection = (DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Int);
    if (localLayerCollection == null)
    {
      SLog.d("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
      return null;
    }
    return localLayerCollection.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerLineLayer;
  }
  
  public TextLayer a()
  {
    DoodleLayout.LayerCollection localLayerCollection = (DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Int);
    if (localLayerCollection == null)
    {
      SLog.d("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
      return null;
    }
    return localLayerCollection.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer;
  }
  
  public VoteLayer a()
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer;
  }
  
  public DoodleLayout.LayerCollection a(int paramInt)
  {
    return (DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  protected DoodleLayout.NormalDoodleStategy a()
  {
    return new DoodleLayout.NormalDoodleStategy(new BaseLayer[] { new PickLayer(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView), new FaceLayer(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView), new DynamicFaceLayer(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView), new LineLayer(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView), new TextLayer(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView) });
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
  
  public String a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = a();
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((FaceLayer)localObject1).a();
      if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
      {
        localObject2 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          TrackerStickerParam localTrackerStickerParam = (TrackerStickerParam)((Iterator)localObject2).next();
          if (localTrackerStickerParam.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper != null) {
            localTrackerStickerParam.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.b(false);
          }
        }
        localArrayList.addAll((Collection)localObject1);
      }
    }
    localObject1 = a();
    if (localObject1 != null)
    {
      paramString = ((TextLayer)localObject1).a(paramString);
      if ((paramString != null) && (!paramString.isEmpty()))
      {
        localObject1 = paramString.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (TrackerStickerParam)((Iterator)localObject1).next();
          if (((TrackerStickerParam)localObject2).jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper != null) {
            ((TrackerStickerParam)localObject2).jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.b(false);
          }
        }
        localArrayList.addAll(paramString);
      }
    }
    return TrackerStickerParam.a(localArrayList);
  }
  
  public List a(int paramInt)
  {
    Object localObject = (DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject != null)
    {
      localObject = ((DoodleLayout.LayerCollection)localObject).jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerLineLayer.a.b();
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
  
  public Map a(int paramInt)
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
    if (Looper.myLooper() != Looper.getMainLooper()) {
      throw new IllegalStateException("Only the original thread that created a view hierarchy can touch its views.");
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener.a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
    }
  }
  
  public void a(int paramInt)
  {
    SLog.b("DoodleLayout", "changeVideoIndex from %d to %d", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramInt));
    this.jdField_a_of_type_Int = paramInt;
    d(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    SLog.b("DoodleLayout", String.format("changeDoodleViewSize, width: %d, height: %d ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    setDoodleBitmapMaxSize(paramInt1, paramInt2);
    int j = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.getWidth();
    int k = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.getHeight();
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = paramInt1;
    ((RelativeLayout.LayoutParams)localObject).height = paramInt2;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (!paramBoolean) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.g();
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.h();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.onSizeChanged(paramInt1, paramInt2, j, k);
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a(paramInt1, paramInt2);
    }
    localObject = (MosaicOperator)a().a(104);
    if (localObject != null) {
      ((MosaicOperator)localObject).e();
    }
    if (this.jdField_d_of_type_Boolean)
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
  
  public void a(DynamicTextItem paramDynamicTextItem, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    SLog.b("DoodleLayout", "onClickInside: showEditTextDialog." + paramDynamicTextItem);
    if (paramDynamicTextItem != null) {
      paramDynamicTextItem.b();
    }
    this.jdField_a_of_type_Anje = new anje(this, null);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiEditTextDialog = new EditTextDialog(super.getContext(), paramBoolean);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiEditTextDialog.jdField_f_of_type_Int = paramInt2;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiEditTextDialog.a(a());
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiEditTextDialog.setContentView(2130970667);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiEditTextDialog.a(this.jdField_a_of_type_Anje);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiEditTextDialog.a(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextBuilder);
    if (paramInt2 == 0) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiEditTextDialog.a(paramDynamicTextItem, paramInt1);
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiEditTextDialog.show();
    invalidate();
    if (this.jdField_b_of_type_Int == 0) {}
    for (;;)
    {
      b(3);
      c(3);
      return;
      if (this.jdField_b_of_type_Int == 1)
      {
        b(new View[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView });
        setDoodleGLViewVisibility(0);
      }
      else if (this.jdField_b_of_type_Int == 2)
      {
        a(new View[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout });
        a().d(false);
      }
    }
  }
  
  public void a(FaceLayer.FaceItem paramFaceItem)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$FaceItem = paramFaceItem;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener != null)
    {
      SLog.b("DoodleLayout", "selectLocation: clickItem-->" + paramFaceItem.toString());
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener.b(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$FaceItem.a());
    }
  }
  
  public void a(InteractPasterLayer.InteractItem paramInteractItem)
  {
    a().a();
  }
  
  public void a(InteractPasterLayer.InteractItem paramInteractItem, float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle != null)
    {
      EditInteractExport localEditInteractExport = (EditInteractExport)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a(EditInteractExport.class);
      if (localEditInteractExport != null) {
        localEditInteractExport.a(paramInteractItem, paramFloat1, paramFloat2);
      }
    }
    a().c();
  }
  
  public void a(VoteLayer.VoteItem paramVoteItem)
  {
    a().a();
  }
  
  public void a(VoteLayer.VoteItem paramVoteItem, float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle != null)
    {
      EditVoteExport localEditVoteExport = (EditVoteExport)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a(EditVoteExport.class);
      if (localEditVoteExport != null) {
        localEditVoteExport.a(paramVoteItem, paramFloat1, paramFloat2);
      }
    }
    a().c();
  }
  
  public void a(LocationFacePackage.Item paramItem, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    a(paramItem, paramFloat1, paramFloat2, paramFloat3, null);
  }
  
  public void a(LocationFacePackage.Item paramItem, float paramFloat1, float paramFloat2, float paramFloat3, SegmentKeeper paramSegmentKeeper)
  {
    a();
    if (paramItem == null) {
      SLog.e("DoodleLayout", "the item is null.");
    }
    for (;;)
    {
      return;
      SLog.b("DoodleLayout", "addLocationFaceItem:" + paramItem.toString());
      FaceLayer.LayerParams localLayerParams = DoodleUtil.a(paramItem, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.getWidth(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.getHeight(), paramFloat1, paramFloat2, paramFloat3);
      boolean bool;
      if (localLayerParams != null)
      {
        if ((paramItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) || (!(paramItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof URLDrawable))) {
          break label235;
        }
        File localFile = ((URLDrawable)paramItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getFileInLocal();
        if ((localFile == null) || (!localFile.exists())) {
          break label235;
        }
        Object localObject = a();
        if (((paramItem.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null)) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b())) {
          localObject = a();
        }
        bool = ((FaceLayer)localObject).a(paramItem.g, paramItem.c, paramItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable, localLayerParams, localFile.getAbsolutePath(), true, paramItem.jdField_a_of_type_Int, d(), paramSegmentKeeper);
        if (bool) {
          a((FaceLayer)localObject);
        }
      }
      while (bool)
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener.a(paramItem);
        VideoEditReport.a("0X80076CE");
        return;
        SLog.e("DoodleLayout", "create FaceLayer.ItemParams failed.");
        return;
        label235:
        bool = false;
      }
    }
  }
  
  public void a(GestureHelper.ZoomItem paramZoomItem)
  {
    if (d() == 0) {
      break label7;
    }
    label7:
    label169:
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener == null) || (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener.b()))
      {
        if ((getContext() instanceof QQStoryBaseActivity)) {}
        for (AppInterface localAppInterface = ((QQStoryBaseActivity)getContext()).a;; localAppInterface = null)
        {
          if ((localAppInterface == null) || (SharedPreUtils.y(getContext(), localAppInterface.getCurrentAccountUin())) || (paramZoomItem.r != 0.0F)) {
            break label169;
          }
          int j = DisplayUtil.a() / 2;
          int k = (int)(paramZoomItem.jdField_a_of_type_AndroidGraphicsPointF.x + paramZoomItem.s);
          int m = (int)(paramZoomItem.jdField_a_of_type_AndroidGraphicsPointF.y + paramZoomItem.t - paramZoomItem.v * paramZoomItem.q / 2.0F);
          int n = paramZoomItem.jdField_j_of_type_Int;
          if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiGuideHelper == null) {
            break;
          }
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiGuideHelper.b(this, getContext(), localAppInterface.getCurrentAccountUin(), k, m - n - j);
          return;
        }
      }
    }
  }
  
  public void a(Map paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoodleLayout", 2, "notifyFinishMotionTrack");
    }
    ThreadManager.getUIHandler().post(new anis(this, paramMap));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_DovComQqImCaptureLayerPickLayer.d(paramBoolean);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    long l = System.currentTimeMillis();
    if (paramBoolean1) {
      if (paramBoolean2)
      {
        this.jdField_d_of_type_Long = l;
        this.jdField_a_of_type_JavaUtilList.clear();
        f(0);
        a(this.jdField_d_of_type_Long);
      }
    }
    for (this.jdField_f_of_type_Boolean = false;; this.jdField_f_of_type_Boolean = true)
    {
      this.jdField_c_of_type_Long = l;
      return;
      this.jdField_d_of_type_Long += l - this.jdField_c_of_type_Long;
      break;
      this.jdField_a_of_type_JavaUtilList.add(Long.valueOf(l - this.jdField_c_of_type_Long));
    }
  }
  
  public void a(View... paramVarArgs)
  {
    int k = paramVarArgs.length;
    int j = 0;
    while (j < k)
    {
      View localView = paramVarArgs[j];
      if (localView != null) {
        localView.setVisibility(4);
      }
      j += 1;
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener != null) {
      return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener.b();
    }
    return true;
  }
  
  public boolean a(float paramFloat1, float paramFloat2, Rect paramRect)
  {
    boolean bool = false;
    if (paramRect == null) {}
    for (int j = 0;; j = paramRect.width() / 2)
    {
      if ((paramFloat1 < -j) || (paramFloat2 < -j) || (paramFloat1 > this.jdField_a_of_type_AndroidGraphicsRect.width() + j) || (paramFloat2 > j + this.jdField_a_of_type_AndroidGraphicsRect.height())) {
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
    GestureHelper.ZoomItem localZoomItem;
    Object localObject;
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) && (paramTextItem != null))
    {
      if (paramBoolean) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setVisibility(0);
      }
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b())
      {
        localZoomItem = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.a();
        localZoomItem.jdField_j_of_type_Boolean = false;
        if (!(localZoomItem instanceof FaceLayer.FaceItem)) {
          break label273;
        }
        localObject = a();
        if (((((FaceLayer.FaceItem)localZoomItem).jdField_h_of_type_Int != 1) && (((FaceLayer.FaceItem)localZoomItem).jdField_h_of_type_Int != 3)) || ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()))) {
          break label313;
        }
        localObject = a();
        ((FaceLayer.FaceItem)localZoomItem).jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
      }
    }
    label273:
    label313:
    for (;;)
    {
      if (localObject != null) {
        ((FaceLayer)localObject).jdField_a_of_type_JavaUtilList.add((FaceLayer.FaceItem)localZoomItem);
      }
      if (paramTextItem.jdField_c_of_type_Boolean)
      {
        q();
        c(paramTextItem);
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.a(paramTextItem);
      paramTextItem.jdField_j_of_type_Boolean = true;
      localObject = paramTextItem.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper;
      if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a()) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        ((SegmentKeeper)localObject).a(paramBoolean);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.requestLayout();
        localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a();
        if ((localObject != null) && (((TextFaceEditLayer)localObject).a != null) && (paramTextItem.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null) && (paramTextItem.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a()))
        {
          paramTextItem.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.c();
          ((TextFaceEditLayer)localObject).a.a(paramTextItem, paramTextItem.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b(), 0, 0.0F, 0.0F);
        }
        return true;
        if (!(localZoomItem instanceof TextLayer.TextItem)) {
          break;
        }
        localObject = a();
        if (localObject == null) {
          break;
        }
        ((TextLayer)localObject).jdField_a_of_type_JavaUtilArrayList.add((TextLayer.TextItem)localZoomItem);
        break;
      }
      return false;
    }
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
    int j = 0;
    int k = 0;
    while (j < this.jdField_b_of_type_AndroidUtilSparseArray.size())
    {
      DoodleLayout.LayerCollection localLayerCollection = (DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(j);
      k = k + localLayerCollection.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer.b() + localLayerCollection.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerLineLayer.b() + localLayerCollection.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.b() + localLayerCollection.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerDynamicFaceLayer.b();
      j += 1;
    }
    return k;
  }
  
  public Bitmap b()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleBtnOperationHelper == null) {
      return null;
    }
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleBtnOperationHelper.b();
  }
  
  public List b(int paramInt)
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
  
  public void b()
  {
    ThreadManager.getUIHandler().post(new aniz(this));
  }
  
  public void b(int paramInt)
  {
    if (!DoodleLayout.State.a(paramInt))
    {
      SLog.e("DoodleLayout", "illegal state.");
      return;
    }
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(GestureHelper.ZoomItem paramZoomItem)
  {
    int n = 0;
    int j = 0;
    if (d() == 0) {
      break label13;
    }
    label13:
    label197:
    label838:
    label847:
    label858:
    label860:
    label866:
    label879:
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener == null) || (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener.b()))
      {
        if ((getContext() instanceof QQStoryBaseActivity)) {}
        for (AppInterface localAppInterface = ((QQStoryBaseActivity)getContext()).a;; localAppInterface = null)
        {
          if ((localAppInterface == null) || (SharedPreUtils.A(getContext(), localAppInterface.getCurrentAccountUin()))) {
            break label879;
          }
          if (SharedPreUtils.z(getContext(), localAppInterface.getCurrentAccountUin()))
          {
            SharedPreUtils.K(getContext(), localAppInterface.getCurrentAccountUin());
            return;
          }
          if (SharedPreUtils.y(getContext(), localAppInterface.getCurrentAccountUin()))
          {
            SharedPreUtils.K(getContext(), localAppInterface.getCurrentAccountUin());
            return;
          }
          Object localObject1;
          int m;
          int k;
          if (paramZoomItem != null) {
            if ((paramZoomItem instanceof TextLayer.TextItem))
            {
              localObject1 = a();
              if (localObject1 == null) {
                break label866;
              }
              j = ((TextLayer)localObject1).n;
              m = ((TextLayer)localObject1).o;
              if (paramZoomItem.r == 0.0F) {
                break label860;
              }
              k = (int)((TextLayer)localObject1).a(paramZoomItem);
            }
          }
          for (;;)
          {
            n = k;
            k = j;
            j = n;
            for (;;)
            {
              if (paramZoomItem == null) {
                break label858;
              }
              if (!paramZoomItem.jdField_c_of_type_Boolean)
              {
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("showTrackingFirstTips", 2, "trackingEnable false");
                return;
                if (paramZoomItem.r == 0.0F) {
                  break label847;
                }
                j = (int)a().a(paramZoomItem);
                m = 0;
                k = 0;
                continue;
                localObject1 = a().jdField_a_of_type_JavaUtilList;
                if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
                  break label838;
                }
                localObject1 = (GestureHelper.ZoomItem)((List)localObject1).get(((List)localObject1).size() - 1);
                if (((GestureHelper.ZoomItem)localObject1).r == 0.0F) {
                  break label832;
                }
                k = (int)a().a((GestureHelper.ZoomItem)localObject1);
              }
              for (;;)
              {
                Object localObject2 = a().jdField_a_of_type_JavaUtilList;
                paramZoomItem = (GestureHelper.ZoomItem)localObject1;
                j = k;
                if (localObject2 != null)
                {
                  paramZoomItem = (GestureHelper.ZoomItem)localObject1;
                  j = k;
                  if (((List)localObject2).size() > 0)
                  {
                    localObject1 = (GestureHelper.ZoomItem)((List)localObject2).get(((List)localObject2).size() - 1);
                    paramZoomItem = (GestureHelper.ZoomItem)localObject1;
                    j = k;
                    if (((GestureHelper.ZoomItem)localObject1).r != 0.0F)
                    {
                      j = (int)a().a((GestureHelper.ZoomItem)localObject1);
                      paramZoomItem = (GestureHelper.ZoomItem)localObject1;
                    }
                  }
                }
                localObject2 = a();
                if (localObject2 != null)
                {
                  ArrayList localArrayList = ((TextLayer)localObject2).jdField_a_of_type_JavaUtilArrayList;
                  k = ((TextLayer)localObject2).n;
                  m = ((TextLayer)localObject2).o;
                  localObject1 = paramZoomItem;
                  if (localArrayList != null)
                  {
                    localObject1 = paramZoomItem;
                    if (localArrayList.size() > 0)
                    {
                      paramZoomItem = (GestureHelper.ZoomItem)localArrayList.get(localArrayList.size() - 1);
                      localObject1 = paramZoomItem;
                      if (paramZoomItem.r != 0.0F)
                      {
                        j = (int)((TextLayer)localObject2).a(paramZoomItem);
                        break label197;
                        int i1 = DisplayUtil.a() / 2;
                        if ((paramZoomItem instanceof TextLayer.TextItem))
                        {
                          localObject1 = (TextLayer.TextItem)paramZoomItem;
                          if ((k > 0) && (m > 0))
                          {
                            m = m - (int)(paramZoomItem.v * paramZoomItem.q / 2.0F) - paramZoomItem.jdField_j_of_type_Int - i1;
                            n = k;
                            if (paramZoomItem.r == 0.0F) {
                              break label806;
                            }
                          }
                        }
                        for (;;)
                        {
                          m = k;
                          k = j;
                          for (;;)
                          {
                            if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiGuideHelper == null) || (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiGuideHelper.a(this, getContext(), localAppInterface.getCurrentAccountUin(), m, k))) {
                              break label804;
                            }
                            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem = paramZoomItem;
                            paramZoomItem.jdField_e_of_type_Boolean = true;
                            if ((paramZoomItem instanceof FaceLayer.FaceItem))
                            {
                              paramZoomItem = (FaceLayer.FaceItem)paramZoomItem;
                              if (paramZoomItem.jdField_h_of_type_Int == 0) {
                                paramZoomItem.d();
                              }
                            }
                            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.invalidate();
                            return;
                            float f1 = paramZoomItem.jdField_a_of_type_AndroidGraphicsPointF.x;
                            float f2 = paramZoomItem.s;
                            k = (int)(((TextLayer.TextItem)localObject1).jdField_a_of_type_Float + (f1 + f2));
                            m = (int)(paramZoomItem.jdField_a_of_type_AndroidGraphicsPointF.y + paramZoomItem.t - paramZoomItem.v * paramZoomItem.q / 2.0F) - paramZoomItem.jdField_j_of_type_Int - i1;
                            n = k;
                            if (paramZoomItem.r == 0.0F) {
                              break label806;
                            }
                            break;
                            n = (int)(paramZoomItem.jdField_a_of_type_AndroidGraphicsPointF.x + paramZoomItem.s) - paramZoomItem.jdField_j_of_type_Int;
                            k = (int)(paramZoomItem.jdField_a_of_type_AndroidGraphicsPointF.y + paramZoomItem.t - paramZoomItem.v * paramZoomItem.q / 2.0F) - paramZoomItem.jdField_j_of_type_Int - i1;
                            m = n;
                            if (paramZoomItem.r != 0.0F)
                            {
                              m = n;
                              k = j;
                            }
                          }
                          break;
                          k = n;
                          j = m;
                        }
                      }
                    }
                  }
                  paramZoomItem = (GestureHelper.ZoomItem)localObject1;
                  break label197;
                }
                m = 0;
                k = 0;
                break label197;
                k = 0;
                continue;
                k = 0;
                localObject1 = paramZoomItem;
              }
              m = 0;
              k = 0;
              j = n;
            }
            break label13;
            k = 0;
            continue;
            m = 0;
            k = 0;
          }
        }
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      a(System.currentTimeMillis());
      invalidate();
      return;
    }
    a(this.jdField_d_of_type_Long);
    setTimeStamp(this.jdField_c_of_type_Long, true);
  }
  
  public void b(View... paramVarArgs)
  {
    int k = paramVarArgs.length;
    int j = 0;
    while (j < k)
    {
      View localView = paramVarArgs[j];
      if (localView != null) {
        localView.setVisibility(0);
      }
      j += 1;
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
    return this.jdField_b_of_type_Int;
  }
  
  public void c()
  {
    a();
    LineLayer localLineLayer = a();
    SLog.b("DoodleLayout", "undo, activeLayer:" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a() + ",pathCount:" + localLineLayer.a.b());
    if (localLineLayer.d())
    {
      localLineLayer.c();
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
  
  public void c(int paramInt)
  {
    a(paramInt, null);
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
  
  public void d()
  {
    a();
    SLog.b("DoodleLayout", "onFacePressed, buttonState:" + this.jdField_b_of_type_Int + ",activeLayer:" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a());
    VideoEditReport.a("0X80076BA", VideoEditReport.jdField_b_of_type_Int);
    if (this.jdField_b_of_type_Int == 0) {}
    for (;;)
    {
      b(1);
      do
      {
        return;
        if (this.jdField_b_of_type_Int != 3) {
          break;
        }
        b(1);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiEditTextDialog.a(false);
      } while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView == null);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.b(true);
      return;
      if (this.jdField_b_of_type_Int == 2)
      {
        a().d(false);
        a(new View[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout });
      }
    }
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a() == this.jdField_a_of_type_DovComQqImCaptureLayerPickLayer);
  }
  
  public int e()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) {
      return 0;
    }
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a();
  }
  
  public void e()
  {
    if (this.jdField_b_of_type_Int == 3)
    {
      b(0);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiEditTextDialog.a(false);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.b(true);
      }
    }
  }
  
  public void f()
  {
    if (this.jdField_b_of_type_Int == 3)
    {
      b(0);
      c(0);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiEditTextDialog.a(false);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.b(true);
      }
    }
  }
  
  public void g()
  {
    if (this.jdField_b_of_type_Int == 3)
    {
      b(0);
      c(0);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiEditTextDialog.a(false);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.b(true);
      }
    }
  }
  
  public void h()
  {
    a();
    SLog.b("DoodleLayout", "onTextPressed, buttonState:" + this.jdField_b_of_type_Int + ",activeLayer:" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a());
    a().d(true);
    DynamicTextItem localDynamicTextItem = a().a(d());
    a(a().a(), false);
    if (localDynamicTextItem != null)
    {
      a(localDynamicTextItem, 0, 0, true);
      return;
    }
    QQToast.a(getContext(), getContext().getString(2131439183), 0).a();
    ThreadManager.getUIHandler().post(new anio(this));
  }
  
  public void i()
  {
    a();
    SLog.b("DoodleLayout", "onLinePressed, buttonState:" + this.jdField_b_of_type_Int + ",activeLayer:" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a());
    VideoEditReport.a("0X80076B8", VideoEditReport.jdField_b_of_type_Int);
    LineLayer localLineLayer = a();
    b(new View[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout });
    localLineLayer.d(true);
    if (localLineLayer.b())
    {
      PureOperator localPureOperator = (PureOperator)localLineLayer.a(101);
      if (localPureOperator != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setSelectedStrokeWithColor(localPureOperator.jdField_b_of_type_Int);
      }
    }
    if (localLineLayer.a.b() > 0)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(true);
      if (this.jdField_b_of_type_Int != 0) {
        break label157;
      }
    }
    for (;;)
    {
      b(2);
      label157:
      do
      {
        return;
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(false);
        break;
        if (this.jdField_b_of_type_Int != 3) {
          break label194;
        }
        b(2);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiEditTextDialog.a(false);
      } while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView == null);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.b(true);
      return;
      label194:
      if (this.jdField_b_of_type_Int == 1)
      {
        b(new View[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView });
        setDoodleGLViewVisibility(0);
      }
    }
  }
  
  public void j()
  {
    a();
    b(new View[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView, this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView });
    setDoodleGLViewVisibility(0);
    a(new View[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout, this.jdField_a_of_type_AndroidWidgetRelativeLayout });
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(false);
    if ((this.jdField_b_of_type_Int == 3) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiEditTextDialog != null))
    {
      b(0);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiEditTextDialog.a(false);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.b(true);
      }
      return;
    }
    b(0);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.f();
    this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.f();
  }
  
  public void k()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.i();
  }
  
  public void l()
  {
    this.jdField_c_of_type_Boolean = true;
    int j = 0;
    while (j < this.jdField_b_of_type_AndroidUtilSparseArray.size())
    {
      TextLayer localTextLayer = ((DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(j)).jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer;
      localTextLayer.a(null);
      localTextLayer.a(null);
      j += 1;
    }
  }
  
  public void m()
  {
    if (this.jdField_b_of_type_Int == 6)
    {
      a(2, Boolean.valueOf(false));
      b(2);
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
      localAlphaAnimation.setAnimationListener(new aniq(this));
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
  
  public void n()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener.k();
    }
  }
  
  public void o()
  {
    MosaicOperator localMosaicOperator = (MosaicOperator)a().a(104);
    if (localMosaicOperator != null) {
      localMosaicOperator.e();
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_b_of_type_Long > System.currentTimeMillis()) {}
    while ((a(false)) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener == null)) {
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener.l();
  }
  
  protected void onDetachedFromWindow()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.c();
    this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.c();
    if (this.jdField_d_of_type_Boolean) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleTextureView.b();
    }
    super.onDetachedFromWindow();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a() == this.jdField_a_of_type_DovComQqImCaptureLayerPickLayer)
    {
      c(7);
      BaseLayer localBaseLayer = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(paramMotionEvent);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setActiveLayer(localBaseLayer);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setTopLevelLayer(localBaseLayer);
      localBaseLayer.d(paramMotionEvent);
      this.jdField_h_of_type_Boolean = true;
      bool = true;
    }
    for (;;)
    {
      if ((paramMotionEvent.getAction() == 0) && (d() == 1)) {
        q();
      }
      return bool;
      if (this.jdField_h_of_type_Boolean)
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a().d(paramMotionEvent);
        if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) {
          this.jdField_h_of_type_Boolean = false;
        }
        bool = true;
      }
      else
      {
        this.jdField_h_of_type_Boolean = false;
      }
    }
  }
  
  public void p()
  {
    TextLayer.TextItem localTextItem = a().jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$TextItem;
    if ((localTextItem != null) && (!jdField_a_of_type_Boolean) && (d() == 1))
    {
      localTextItem.b(true);
      if (localTextItem.jdField_c_of_type_Boolean) {
        ThreadManager.getUIHandler().post(new aniu(this, localTextItem));
      }
    }
  }
  
  public void q()
  {
    if ((getContext() instanceof QQStoryBaseActivity)) {}
    for (AppInterface localAppInterface = ((QQStoryBaseActivity)getContext()).a;; localAppInterface = null)
    {
      if (localAppInterface == null) {}
      while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiGuideHelper == null) {
        return;
      }
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.jdField_e_of_type_Boolean))
      {
        if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem instanceof FaceLayer.FaceItem)) {
          ((FaceLayer.FaceItem)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem).e();
        }
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.jdField_e_of_type_Boolean = false;
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem = null;
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.invalidate();
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiGuideHelper.a(this);
      return;
    }
  }
  
  public void r()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      long l1 = System.currentTimeMillis();
      long l2 = ((Long)this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_JavaUtilList.size() - 1)).longValue();
      long l3 = this.jdField_d_of_type_Long;
      this.jdField_d_of_type_Long = (l2 + l1 - this.jdField_c_of_type_Long + l3);
      this.jdField_c_of_type_Long = l1;
      a(this.jdField_d_of_type_Long);
      setTimeStamp(l1, true);
    }
  }
  
  public void s()
  {
    this.jdField_f_of_type_Boolean = false;
    f(1);
    a(System.currentTimeMillis());
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
      this.jdField_f_of_type_Int = paramInt1;
      this.jdField_g_of_type_Int = paramInt2;
      int j = 0;
      while (j < this.jdField_a_of_type_AndroidUtilSparseArray.size())
      {
        ((DoodleConfig)this.jdField_a_of_type_AndroidUtilSparseArray.get(j)).jdField_a_of_type_Int = paramInt1;
        ((DoodleConfig)this.jdField_a_of_type_AndroidUtilSparseArray.get(j)).jdField_b_of_type_Int = paramInt2;
        j += 1;
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
    if (!this.jdField_d_of_type_Boolean) {
      return;
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      SLog.b("DoodleLayout", "setDoodleGLViewVisibility, soload failed, glview default invisible");
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleTextureView.setVisibility(4);
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleTextureView.a(paramInt);
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
    v();
  }
  
  public void setFaceLayerPosition(long paramLong)
  {
    int k = 0;
    Object localObject1 = a();
    int j;
    Object localObject2;
    TrackerStickerParam.MotionInfo localMotionInfo;
    float f1;
    if (localObject1 != null)
    {
      localObject1 = ((FaceLayer)localObject1).jdField_a_of_type_JavaUtilList;
      j = 0;
      if (j < ((List)localObject1).size())
      {
        localObject2 = (FaceLayer.FaceItem)((List)localObject1).get(j);
        localMotionInfo = (TrackerStickerParam.MotionInfo)((FaceLayer.FaceItem)localObject2).jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
        if (localMotionInfo != null)
        {
          if (localMotionInfo.jdField_a_of_type_Boolean) {
            break label139;
          }
          ((FaceLayer.FaceItem)localObject2).jdField_a_of_type_AndroidGraphicsPointF.set(0.0F, 0.0F);
          ((FaceLayer.FaceItem)localObject2).s = localMotionInfo.jdField_a_of_type_Float;
          ((FaceLayer.FaceItem)localObject2).t = localMotionInfo.b;
          f1 = ((FaceLayer.FaceItem)localObject2).o;
          ((FaceLayer.FaceItem)localObject2).q = (localMotionInfo.c * f1);
        }
        for (;;)
        {
          j += 1;
          break;
          label139:
          ((FaceLayer.FaceItem)localObject2).jdField_a_of_type_AndroidGraphicsPointF.set(-2000.0F, 0.0F);
          ((FaceLayer.FaceItem)localObject2).s = localMotionInfo.jdField_a_of_type_Float;
        }
      }
    }
    localObject1 = a();
    if (localObject1 != null)
    {
      localObject1 = ((FaceLayer)localObject1).jdField_a_of_type_JavaUtilList;
      j = 0;
      if (j < ((List)localObject1).size())
      {
        localObject2 = (FaceLayer.FaceItem)((List)localObject1).get(j);
        localMotionInfo = (TrackerStickerParam.MotionInfo)((FaceLayer.FaceItem)localObject2).jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
        if (localMotionInfo != null)
        {
          if (localMotionInfo.jdField_a_of_type_Boolean) {
            break label300;
          }
          ((FaceLayer.FaceItem)localObject2).jdField_a_of_type_AndroidGraphicsPointF.set(0.0F, 0.0F);
          ((FaceLayer.FaceItem)localObject2).s = localMotionInfo.jdField_a_of_type_Float;
          ((FaceLayer.FaceItem)localObject2).t = localMotionInfo.b;
          f1 = ((FaceLayer.FaceItem)localObject2).o;
          ((FaceLayer.FaceItem)localObject2).q = (localMotionInfo.c * f1);
        }
        for (;;)
        {
          j += 1;
          break;
          label300:
          ((FaceLayer.FaceItem)localObject2).jdField_a_of_type_AndroidGraphicsPointF.set(-2000.0F, 0.0F);
          ((FaceLayer.FaceItem)localObject2).s = localMotionInfo.jdField_a_of_type_Float;
        }
      }
    }
    localObject1 = a();
    if (localObject1 != null)
    {
      localObject1 = ((TextLayer)localObject1).jdField_a_of_type_JavaUtilArrayList;
      j = k;
      if (j < ((List)localObject1).size())
      {
        localObject2 = (TextLayer.TextItem)((List)localObject1).get(j);
        localMotionInfo = (TrackerStickerParam.MotionInfo)((TextLayer.TextItem)localObject2).jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
        if (localMotionInfo != null)
        {
          if (localMotionInfo.jdField_a_of_type_Boolean) {
            break label462;
          }
          ((TextLayer.TextItem)localObject2).jdField_a_of_type_AndroidGraphicsPointF.set(0.0F, 0.0F);
          ((TextLayer.TextItem)localObject2).s = localMotionInfo.jdField_a_of_type_Float;
          ((TextLayer.TextItem)localObject2).t = localMotionInfo.b;
          f1 = ((TextLayer.TextItem)localObject2).o;
          ((TextLayer.TextItem)localObject2).q = (localMotionInfo.c * f1);
        }
        for (;;)
        {
          j += 1;
          break;
          label462:
          ((TextLayer.TextItem)localObject2).jdField_a_of_type_AndroidGraphicsPointF.set(-2000.0F, 0.0F);
          ((TextLayer.TextItem)localObject2).s = localMotionInfo.jdField_a_of_type_Float;
        }
      }
    }
    ThreadManager.getUIHandler().post(new anir(this));
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
    int j = paramInt;
    if (paramInt < 1)
    {
      SLog.e("DoodleLayout", "MosaicSize little than 1.");
      j = 1;
    }
    this.jdField_c_of_type_Int = j;
    paramInt = 0;
    while (paramInt < this.jdField_b_of_type_AndroidUtilSparseArray.size())
    {
      MosaicOperator localMosaicOperator = (MosaicOperator)((DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(paramInt)).jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerLineLayer.a(103);
      if (localMosaicOperator != null) {
        localMosaicOperator.b(j);
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
      this.jdField_d_of_type_Int = paramInt1;
      this.jdField_e_of_type_Int = paramInt2;
      int j = 0;
      while (j < this.jdField_b_of_type_AndroidUtilSparseArray.size())
      {
        MosaicOperator localMosaicOperator = (MosaicOperator)((DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(j)).jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerLineLayer.a(103);
        if (localMosaicOperator != null) {
          localMosaicOperator.b(paramInt1, paramInt2);
        }
        j += 1;
      }
    }
  }
  
  public void setOnTextDialogShowListener(anjk paramanjk)
  {
    this.jdField_a_of_type_Anjk = paramanjk;
  }
  
  public void setRecording(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public void setTimeStamp(long paramLong, boolean paramBoolean)
  {
    if ((!this.jdField_f_of_type_Boolean) || (paramBoolean))
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
      paramZoomItem.i = paramInt;
    } while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener == null);
    if (!paramZoomItem.a())
    {
      float f3 = paramZoomItem.jdField_a_of_type_AndroidGraphicsPointF.x + paramZoomItem.s - paramZoomItem.u / 2.0F;
      float f4 = paramZoomItem.jdField_a_of_type_AndroidGraphicsPointF.y + paramZoomItem.t - paramZoomItem.v / 2.0F;
      float f2 = f4;
      float f1 = f3;
      if (paramZoomItem.jdField_f_of_type_Boolean)
      {
        f2 = f4;
        f1 = f3;
        if (paramZoomItem.jdField_g_of_type_Boolean)
        {
          f1 = paramZoomItem.l + paramZoomItem.jdField_j_of_type_Float - paramZoomItem.u / 2.0F;
          f2 = paramZoomItem.m + paramZoomItem.k - paramZoomItem.v / 2.0F;
        }
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener.a(f1, f2, paramZoomItem.u, paramZoomItem.v);
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener.p();
    paramZoomItem.f();
  }
  
  public void setupPersonality()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)super.findViewById(2131364349));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleTextureView = new DoodleTextureView(super.getContext());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleTextureView, localLayoutParams);
    this.jdField_b_of_type_Boolean = PtvFilterSoLoad.c();
    if (!this.jdField_b_of_type_Boolean)
    {
      a(new View[] { this.jdField_a_of_type_AndroidWidgetFrameLayout });
      setDoodleGLViewVisibility(4);
      this.jdField_d_of_type_Boolean = false;
      return;
    }
    this.jdField_d_of_type_Boolean = true;
    u();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout
 * JD-Core Version:    0.7.0.1
 */