package dov.com.qq.im.aeeditor.view.videotrack;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.annotation.RequiresApi;
import bnrh;
import bnzx;
import bodu;
import bodv;
import bodw;
import bodx;
import body;
import boek;
import boer;
import boex;
import bofb;
import bofd;
import bofe;
import boff;
import bofg;
import bofh;
import bofi;
import bofj;
import bofk;
import bofl;
import bofm;
import bofn;
import bofo;
import bofp;
import bofq;
import bofr;
import bofs;
import boft;
import bofu;
import bofx;
import com.tencent.tavsticker.utils.ViewUtils;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.weishi.module.edit.widget.playtrack.provider.VideoThumbListener;
import com.tencent.weishi.module.edit.widget.playtrack.provider.VideoThumbProviderManager;
import com.tencent.weseevideo.camera.mvauto.redo.CutModelKt;
import com.tencent.weseevideo.camera.mvauto.redo.VideoResourceModelKt;
import com.tencent.weseevideo.model.effect.VideoTransitionModel;
import dov.com.qq.im.aeeditor.view.playtrack.view.PlayTrackExpandWidthView;
import dov.com.qq.im.aeeditor.view.timebar.ScaleTimeBar;
import dov.com.qq.im.aeeditor.view.timeline.EffectTimelineView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VideoTrackContainerView
  extends HorizontalScrollView
  implements bodw, bodx, boex, bofx
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 2147483647L;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Context jdField_a_of_type_AndroidContentContext;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private bnzx jdField_a_of_type_Bnzx;
  private bodu jdField_a_of_type_Bodu;
  private body jdField_a_of_type_Body;
  private boer jdField_a_of_type_Boer;
  private bofb jdField_a_of_type_Bofb;
  private bofd jdField_a_of_type_Bofd;
  private bofr jdField_a_of_type_Bofr;
  private bofs jdField_a_of_type_Bofs;
  private boft jdField_a_of_type_Boft;
  private bofu jdField_a_of_type_Bofu;
  private VideoThumbListener jdField_a_of_type_ComTencentWeishiModuleEditWidgetPlaytrackProviderVideoThumbListener = new bofi(this);
  private ScaleTimeBar jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleTimeBar;
  private Runnable jdField_a_of_type_JavaLangRunnable = new VideoTrackContainerView.1(this);
  private List<CutModelKt> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private List<VideoTransitionModel> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private List<VideoTrackTimeLineView> jdField_c_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  private List<ImageView> jdField_d_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = -1;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = -1;
  private boolean jdField_f_of_type_Boolean = true;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean = true;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean = true;
  private boolean i;
  private boolean j;
  
  public VideoTrackContainerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoTrackContainerView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VideoTrackContainerView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    h();
  }
  
  private int a(ImageView paramImageView)
  {
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    int k = -1;
    while (localIterator.hasNext())
    {
      VideoTrackTimeLineView localVideoTrackTimeLineView = (VideoTrackTimeLineView)localIterator.next();
      int m = k + 1;
      k = m;
      if (localVideoTrackTimeLineView.getTag() != null)
      {
        k = m;
        if (localVideoTrackTimeLineView.getTag() == paramImageView) {
          return m;
        }
      }
    }
    return -1;
  }
  
  private long a(int paramInt)
  {
    return (this.jdField_a_of_type_Boer.a(Math.abs(paramInt)) * 70 / this.jdField_a_of_type_Boer.a());
  }
  
  @RequiresApi(api=17)
  private ImageView a()
  {
    ImageView localImageView = new ImageView(getContext());
    if (Build.VERSION.SDK_INT >= 17) {
      localImageView.setId(View.generateViewId());
    }
    localImageView.setImageResource(2130837939);
    localImageView.setOnClickListener(new bofm(this));
    return localImageView;
  }
  
  private VideoTransitionModel a(List<VideoTransitionModel> paramList, int paramInt)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        VideoTransitionModel localVideoTransitionModel = (VideoTransitionModel)paramList.next();
        if (localVideoTransitionModel.getTransitionPosition() == paramInt) {
          return localVideoTransitionModel;
        }
      }
    }
    return null;
  }
  
  private void a(long paramLong)
  {
    if (this.jdField_a_of_type_Boer != null) {
      this.jdField_a_of_type_Boer.a(paramLong);
    }
  }
  
  private void a(long paramLong, VideoTrackTimeLineView paramVideoTrackTimeLineView, VideoResourceModelKt paramVideoResourceModelKt)
  {
    long l;
    if (paramVideoResourceModelKt.getScaleDuration() + paramLong > this.jdField_a_of_type_Long)
    {
      if (paramLong <= this.jdField_a_of_type_Long) {
        break label41;
      }
      l = 0L;
    }
    for (paramLong = paramVideoResourceModelKt.getScaleDuration();; paramLong = paramVideoResourceModelKt.getScaleDuration() + paramLong - this.jdField_a_of_type_Long)
    {
      paramVideoTrackTimeLineView.setRedMaskViewShowTimeRange(l, paramLong);
      return;
      label41:
      l = this.jdField_a_of_type_Long - paramLong;
    }
  }
  
  private void a(View paramView)
  {
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (VideoTrackTimeLineView)localIterator.next();
      if (((VideoTrackTimeLineView)localObject).getTag() != null)
      {
        localObject = (ImageView)((VideoTrackTimeLineView)localObject).getTag();
        if (localObject == paramView) {
          ((ImageView)localObject).setSelected(true);
        } else {
          ((ImageView)localObject).setSelected(false);
        }
      }
    }
  }
  
  private void a(bodv parambodv, int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { paramInt, 0 });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(a(paramInt));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
    int k = this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleTimeBar.getScrollX();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new bofn(this, parambodv, k, paramInt));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new bofo(this, parambodv));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  private void a(bodv parambodv, long paramLong1, long paramLong2, int paramInt)
  {
    this.jdField_b_of_type_Int = this.jdField_d_of_type_Int;
    this.jdField_c_of_type_Int = this.jdField_e_of_type_Int;
    a(a());
    if (this.jdField_a_of_type_Boolean)
    {
      bnrh.b("miles", "onTimeLineChanged >> 拖动结束，滚动到当前滑块的起始位置:" + parambodv.a());
      if (this.jdField_a_of_type_Bofs != null) {
        this.jdField_a_of_type_Bofs.a(parambodv.a());
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_f_of_type_Boolean = true;
      parambodv = a();
      if ((this.jdField_a_of_type_Bofu != null) && (parambodv != null)) {
        this.jdField_a_of_type_Bofu.a(parambodv.getUuid(), parambodv.getResource().getSelectTimeStartUs(), parambodv.getResource().getSelectTimeDurationUs());
      }
      return;
      if (this.jdField_b_of_type_Boolean)
      {
        bnrh.b("miles", "onTimeLineChanged >> 拖动结束，滚动到当前滑块的结束位置:" + parambodv.b());
        if (this.jdField_a_of_type_Bofs != null) {
          this.jdField_a_of_type_Bofs.b(parambodv.b());
        }
      }
    }
  }
  
  private void a(bodv parambodv, LinearLayout.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    if (paramLayoutParams == null) {
      return;
    }
    if (!c()) {
      b(parambodv);
    }
    if (a(parambodv))
    {
      paramLayoutParams.leftMargin = this.jdField_d_of_type_Int;
      if (!paramBoolean) {
        break label103;
      }
    }
    label103:
    for (paramLayoutParams.rightMargin = this.jdField_e_of_type_Int;; paramLayoutParams.rightMargin = (-parambodv.b()))
    {
      paramLayoutParams.width = (this.jdField_a_of_type_Boer.a(parambodv.b() - parambodv.a()) + parambodv.a() + parambodv.b());
      paramLayoutParams.height = -1;
      return;
      paramLayoutParams.leftMargin = (-parambodv.a());
      break;
    }
  }
  
  private boolean a(bodv parambodv)
  {
    return parambodv.a() == 0L;
  }
  
  private float b()
  {
    return getResources().getDimension(2131296332);
  }
  
  private void b(bodv parambodv)
  {
    this.jdField_d_of_type_Int = (c() / 2 - parambodv.a());
    this.jdField_e_of_type_Int = (c() / 2 - parambodv.b());
    this.jdField_b_of_type_Int = this.jdField_d_of_type_Int;
    this.jdField_c_of_type_Int = this.jdField_e_of_type_Int;
  }
  
  private void b(bodv parambodv, int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { paramInt, 0 });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(a(paramInt));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
    int k = this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleTimeBar.getScrollX();
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)((VideoTrackTimeLineView)this.jdField_c_of_type_JavaUtilList.get(0)).getLayoutParams();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new bofp(this, parambodv, k, paramInt));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new bofq(this, parambodv));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  private void b(bodv parambodv, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        VideoTrackTimeLineView localVideoTrackTimeLineView = (VideoTrackTimeLineView)localIterator.next();
        if ((localVideoTrackTimeLineView != parambodv) && (localVideoTrackTimeLineView.isSelected())) {
          localVideoTrackTimeLineView.setSelected(false);
        }
      }
      ((View)parambodv).bringToFront();
    }
  }
  
  private int c()
  {
    return this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  private void c(bodv parambodv, int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { paramInt, 0 });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(a(paramInt));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
    int k = this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleTimeBar.getScrollX();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new bofe(this, parambodv, k, paramInt));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new boff(this, parambodv));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  private boolean c()
  {
    return (this.jdField_d_of_type_Int != -1) && (this.jdField_e_of_type_Int != -1);
  }
  
  private int d()
  {
    return (int)getResources().getDimension(2131296312);
  }
  
  private void d(bodv parambodv, int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { paramInt, 0 });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(a(paramInt));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
    int k = this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleTimeBar.getScrollX();
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)((VideoTrackTimeLineView)this.jdField_c_of_type_JavaUtilList.get(this.jdField_c_of_type_JavaUtilList.size() - 1)).getLayoutParams();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new bofg(this, parambodv, k, paramInt));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new bofh(this, parambodv));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  private void h()
  {
    Object localObject = new FrameLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new BringToFrontLinearLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new bofj(this));
    this.jdField_g_of_type_Int = ViewUtils.dip2px(40.0F);
    VideoThumbProviderManager.getInstance().registerListener(this.jdField_a_of_type_ComTencentWeishiModuleEditWidgetPlaytrackProviderVideoThumbListener);
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    Iterator localIterator = this.jdField_d_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      ImageView localImageView = (ImageView)localIterator.next();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(localImageView);
    }
    this.jdField_d_of_type_JavaUtilList.clear();
    this.jdField_c_of_type_JavaUtilList.clear();
  }
  
  private void j()
  {
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    int k = 0;
    int m = -1;
    VideoTrackTimeLineView localVideoTrackTimeLineView;
    int i1;
    ImageView localImageView;
    Object localObject;
    if (localIterator.hasNext())
    {
      localVideoTrackTimeLineView = (VideoTrackTimeLineView)localIterator.next();
      i1 = m + 1;
      m = k;
      if (localVideoTrackTimeLineView.getTag() != null)
      {
        localImageView = (ImageView)localVideoTrackTimeLineView.getTag();
        localObject = a(this.jdField_b_of_type_JavaUtilList, i1);
        if (localObject == null) {
          break label212;
        }
      }
    }
    label212:
    for (int n = this.jdField_a_of_type_Boer.a((((VideoTransitionModel)localObject).getOverlapTime() / ((VideoTransitionModel)localObject).getSpeed()));; n = 0)
    {
      localObject = (LinearLayout.LayoutParams)localVideoTrackTimeLineView.getLayoutParams();
      m = k;
      if (localObject != null)
      {
        m = this.jdField_a_of_type_Boer.a(localVideoTrackTimeLineView.b() - localVideoTrackTimeLineView.a()) + localVideoTrackTimeLineView.a() + localVideoTrackTimeLineView.b() - n;
        if (((LinearLayout.LayoutParams)localObject).width != m)
        {
          ((LinearLayout.LayoutParams)localObject).width = m;
          localVideoTrackTimeLineView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        m = k + (((LinearLayout.LayoutParams)localObject).leftMargin + ((LinearLayout.LayoutParams)localObject).width + ((LinearLayout.LayoutParams)localObject).rightMargin);
        localImageView.setX(m - d());
      }
      k = m;
      m = i1;
      break;
      return;
    }
  }
  
  private void k()
  {
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      VideoTrackTimeLineView localVideoTrackTimeLineView = (VideoTrackTimeLineView)localIterator.next();
      if (localVideoTrackTimeLineView.getTag() != null) {
        ((ImageView)localVideoTrackTimeLineView.getTag()).setX(localVideoTrackTimeLineView.getRight() - localVideoTrackTimeLineView.b() - d());
      }
    }
  }
  
  public float a()
  {
    if (CollectionUtils.isEmpty(this.jdField_c_of_type_JavaUtilList)) {
      return 0.0F;
    }
    Object localObject = (VideoTrackTimeLineView)this.jdField_c_of_type_JavaUtilList.get(0);
    if (localObject == null) {
      return 0.0F;
    }
    CutModelKt localCutModelKt = ((VideoTrackTimeLineView)localObject).a();
    localObject = ((VideoTrackTimeLineView)localObject).a();
    if ((localCutModelKt == null) || (localCutModelKt.getResource() == null) || (localObject == null)) {
      return 0.0F;
    }
    return ((PlayTrackExpandWidthView)localObject).getWidth() * 1.0F / (float)localCutModelKt.getResource().getScaleDuration();
  }
  
  public int a()
  {
    int k = 0;
    while (k < this.jdField_c_of_type_JavaUtilList.size())
    {
      if (((VideoTrackTimeLineView)this.jdField_c_of_type_JavaUtilList.get(k)).isSelected()) {
        return k;
      }
      k += 1;
    }
    return 0;
  }
  
  public long a()
  {
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    for (long l = 0L; localIterator.hasNext(); l = ((VideoTrackTimeLineView)localIterator.next()).a().getResource().getScaleDuration() + l) {}
    localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    VideoTransitionModel localVideoTransitionModel;
    float f1;
    for (int k = 0; localIterator.hasNext(); k = (int)(localVideoTransitionModel.getOverlapTime() / localVideoTransitionModel.getSpeed() + f1))
    {
      localVideoTransitionModel = (VideoTransitionModel)localIterator.next();
      f1 = k;
    }
    return l - k;
  }
  
  public long a(@NonNull View paramView, long paramLong)
  {
    return 0L;
  }
  
  public long a(bodv parambodv)
  {
    long l = 0L;
    int k = 0;
    for (;;)
    {
      VideoTrackTimeLineView localVideoTrackTimeLineView;
      if (k < this.jdField_c_of_type_JavaUtilList.size())
      {
        localVideoTrackTimeLineView = (VideoTrackTimeLineView)this.jdField_c_of_type_JavaUtilList.get(k);
        if (parambodv != localVideoTrackTimeLineView) {}
      }
      else
      {
        return l;
      }
      l += this.jdField_a_of_type_Boer.a(localVideoTrackTimeLineView.getWidth() - localVideoTrackTimeLineView.a() - localVideoTrackTimeLineView.b());
      k += 1;
    }
  }
  
  public ViewGroup a()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  public CutModelKt a()
  {
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      VideoTrackTimeLineView localVideoTrackTimeLineView = (VideoTrackTimeLineView)localIterator.next();
      if (localVideoTrackTimeLineView.isSelected()) {
        return localVideoTrackTimeLineView.a();
      }
    }
    return null;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning()))
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (getScrollX() == 0) && (paramInt2 == 0) && (getScrollY() == 0)) {}
    do
    {
      return;
      this.jdField_e_of_type_Boolean = true;
    } while (!this.jdField_f_of_type_Boolean);
    scrollBy(paramInt1 - getScrollX(), paramInt2 - getScrollY());
  }
  
  public void a(@NonNull bodv parambodv) {}
  
  public void a(bodv parambodv, long paramLong1, long paramLong2)
  {
    paramLong1 = 0L;
    if ((this.jdField_a_of_type_Bnzx != null) && (this.jdField_a_of_type_Bnzx.a())) {
      this.jdField_a_of_type_Bnzx.b();
    }
    Object localObject1 = this.jdField_c_of_type_JavaUtilList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (VideoTrackTimeLineView)((Iterator)localObject1).next();
      if (((VideoTrackTimeLineView)localObject2).getLocalVisibleRect(new Rect())) {
        ((VideoTrackTimeLineView)localObject2).a().invalidate();
      }
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = false;
    if ((this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Boolean)) {
      bnrh.b("miles", "正在滚动，直接返回");
    }
    for (;;)
    {
      return;
      localObject1 = (ViewGroup.MarginLayoutParams)((VideoTrackTimeLineView)this.jdField_c_of_type_JavaUtilList.get(0)).getLayoutParams();
      localObject2 = new int[2];
      ((VideoTrackTimeLineView)parambodv).getLocationOnScreen((int[])localObject2);
      if ((paramLong2 <= 0L) && (localObject2[0] <= b())) {
        a(parambodv, (int)((VideoTrackTimeLineView)parambodv).e());
      }
      while (this.jdField_a_of_type_Bnzx != null)
      {
        parambodv = this.jdField_c_of_type_JavaUtilList.iterator();
        while (parambodv.hasNext()) {
          paramLong1 = ((VideoTrackTimeLineView)parambodv.next()).d() + paramLong1;
        }
        if ((paramLong2 >= 0L) && (localObject2[0] >= c() - b()))
        {
          b(parambodv, (int)((VideoTrackTimeLineView)parambodv).f());
        }
        else
        {
          ((ViewGroup.MarginLayoutParams)localObject1).leftMargin = (this.jdField_b_of_type_Int + this.jdField_a_of_type_Boer.a(paramLong2));
          ((VideoTrackTimeLineView)parambodv).a().scrollTo(this.jdField_a_of_type_Boer.a(((VideoTrackTimeLineView)parambodv).e()), ((VideoTrackTimeLineView)parambodv).a().getScrollY());
        }
      }
    }
    this.jdField_a_of_type_Bnzx.a(paramLong1);
  }
  
  public void a(bodv parambodv, long paramLong1, long paramLong2, int paramInt, boolean paramBoolean)
  {
    a(parambodv, paramLong1, paramLong2, paramInt);
  }
  
  public void a(bodv parambodv, boolean paramBoolean)
  {
    b(parambodv, paramBoolean);
    bofd localbofd;
    if (this.jdField_a_of_type_Bofd != null)
    {
      localbofd = this.jdField_a_of_type_Bofd;
      if (!paramBoolean) {
        break label39;
      }
    }
    label39:
    for (int k = a();; k = 0)
    {
      localbofd.a(parambodv, paramBoolean, k);
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_c_of_type_JavaUtilList.isEmpty()) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        VideoTrackTimeLineView localVideoTrackTimeLineView = (VideoTrackTimeLineView)localIterator.next();
        if (TextUtils.equals(paramString, localVideoTrackTimeLineView.a())) {
          localVideoTrackTimeLineView.e();
        }
      }
    }
  }
  
  @RequiresApi(api=17)
  public void a(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return;
    }
    VideoTrackTimeLineView localVideoTrackTimeLineView;
    do
    {
      Iterator localIterator;
      do
      {
        localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
      } while (!localIterator.hasNext());
      localVideoTrackTimeLineView = (VideoTrackTimeLineView)localIterator.next();
      if (!localVideoTrackTimeLineView.a().getUuid().equals(paramString)) {
        break;
      }
      localVideoTrackTimeLineView.setShowSliderView(this.jdField_h_of_type_Boolean);
      localVideoTrackTimeLineView.setSelected(true);
    } while (!paramBoolean);
    localVideoTrackTimeLineView.f();
  }
  
  @RequiresApi(api=17)
  public void a(List<CutModelKt> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    label137:
    label527:
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilList = paramList;
      i();
      long l = 0L;
      int m = 0;
      int k = 0;
      if (k < this.jdField_a_of_type_JavaUtilList.size())
      {
        Object localObject1 = (CutModelKt)this.jdField_a_of_type_JavaUtilList.get(k);
        paramList = new VideoTrackTimeLineView(this.jdField_a_of_type_AndroidContentContext);
        paramList.setBitmapWidth(this.jdField_g_of_type_Int);
        paramList.setMediaClipModel((CutModelKt)localObject1);
        Object localObject2 = ((CutModelKt)localObject1).getResource();
        if (this.jdField_a_of_type_Body != null) {
          paramList.setOnLongClickListener(new bofk(this, (CutModelKt)localObject1));
        }
        int n = boek.a.a(((CutModelKt)localObject1).getUuid());
        if (n != -1)
        {
          paramList.setId(n);
          paramList.setStartValue(l);
          paramList.setEndValue(((VideoResourceModelKt)localObject2).getScaleDuration() + l);
          paramList.setShowSliderView(this.jdField_h_of_type_Boolean);
          paramList.setSelected(false);
          paramList.setSelectedStyle(this.jdField_a_of_type_Int);
          if (this.jdField_f_of_type_Int != -1) {
            paramList.setCornerRadius(this.jdField_f_of_type_Int);
          }
          if (this.jdField_g_of_type_Boolean) {
            paramList.setOnClickListener(new bofl(this, k));
          }
          paramList.setValueChangeListener(this);
          paramList.setStateChangeListener(this);
          paramList.setTimeLineViewListener(this);
          paramList.setOnSlideChangedListener(this);
          paramList.setScaleModel(this.jdField_a_of_type_Boer);
          localObject1 = new LinearLayout.LayoutParams(-2, -2);
          if (k != this.jdField_a_of_type_JavaUtilList.size() - 1) {
            break label527;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          a(paramList, (LinearLayout.LayoutParams)localObject1, bool);
          a(l, paramList, (VideoResourceModelKt)localObject2);
          paramList.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramList);
          this.jdField_c_of_type_JavaUtilList.add(paramList);
          l += ((VideoResourceModelKt)localObject2).getScaleDuration();
          n = m;
          if (this.i)
          {
            n = m;
            if (k < this.jdField_a_of_type_JavaUtilList.size() - 1)
            {
              localObject2 = a();
              RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(ViewUtils.dip2px(29.0F), ViewUtils.dip2px(29.0F));
              localLayoutParams.topMargin = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingTop();
              n = m + (((LinearLayout.LayoutParams)localObject1).leftMargin + ((LinearLayout.LayoutParams)localObject1).width + ((LinearLayout.LayoutParams)localObject1).rightMargin);
              ((ImageView)localObject2).setX(n - d());
              this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject2, localLayoutParams);
              this.jdField_d_of_type_JavaUtilList.add(localObject2);
              paramList.setTag(localObject2);
              bnrh.a("VideoTrackContainerView", "add piece view,x:" + ((ImageView)localObject2).getX());
            }
          }
          k += 1;
          m = n;
          break;
          if (Build.VERSION.SDK_INT >= 17) {
            paramList.setId(View.generateViewId());
          }
          boek.a.a(((CutModelKt)localObject1).getUuid(), paramList.getId());
          break label137;
        }
      }
    } while (!this.i);
    b();
  }
  
  public void a(List<VideoTransitionModel> paramList, int paramInt)
  {
    this.jdField_b_of_type_JavaUtilList = paramList;
    if (paramList == null) {
      return;
    }
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    int k = -1;
    while (localIterator.hasNext())
    {
      Object localObject = (VideoTrackTimeLineView)localIterator.next();
      int m = k + 1;
      k = m;
      if (((VideoTrackTimeLineView)localObject).getTag() != null)
      {
        localObject = (ImageView)((VideoTrackTimeLineView)localObject).getTag();
        if (a(paramList, m) != null) {
          ((ImageView)localObject).setImageResource(2130837960);
        }
        for (;;)
        {
          if (paramInt != m) {
            break label117;
          }
          ((ImageView)localObject).setSelected(true);
          k = m;
          break;
          ((ImageView)localObject).setImageResource(2130837939);
        }
        label117:
        ((ImageView)localObject).setSelected(false);
        k = m;
      }
    }
    j();
    b();
  }
  
  public void a(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public void a(boolean paramBoolean, EffectTimelineView paramEffectTimelineView)
  {
    bnrh.a("VideoTrackContainerView", "[onTimeLineViewSelected], selected=" + paramBoolean + ", view=" + paramEffectTimelineView);
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public int b()
  {
    int m;
    if ((this.jdField_a_of_type_Boer == null) || (CollectionUtils.isEmpty(this.jdField_c_of_type_JavaUtilList)))
    {
      m = -1;
      return m;
    }
    long l2 = this.jdField_a_of_type_Boer.c();
    long l1 = 0L;
    int k = 0;
    label67:
    long l3;
    for (;;)
    {
      if (k < this.jdField_c_of_type_JavaUtilList.size())
      {
        VideoTrackTimeLineView localVideoTrackTimeLineView = (VideoTrackTimeLineView)this.jdField_c_of_type_JavaUtilList.get(k);
        if (localVideoTrackTimeLineView == null)
        {
          k += 1;
        }
        else
        {
          l3 = localVideoTrackTimeLineView.b() - localVideoTrackTimeLineView.a();
          if ((l1 > l2) || (l2 >= l1 + l3)) {
            break;
          }
        }
      }
    }
    for (;;)
    {
      m = k;
      if (k != -1) {
        break;
      }
      return this.jdField_c_of_type_JavaUtilList.size() - 1;
      l1 += l3;
      break label67;
      k = -1;
    }
  }
  
  public long b(@NonNull View paramView, long paramLong)
  {
    return 0L;
  }
  
  public long b(bodv parambodv)
  {
    long l1 = 0L;
    int k = 0;
    for (;;)
    {
      long l2 = l1;
      if (k < this.jdField_c_of_type_JavaUtilList.size())
      {
        VideoTrackTimeLineView localVideoTrackTimeLineView = (VideoTrackTimeLineView)this.jdField_c_of_type_JavaUtilList.get(k);
        l1 += this.jdField_a_of_type_Boer.a(localVideoTrackTimeLineView.getWidth() - localVideoTrackTimeLineView.a() - localVideoTrackTimeLineView.b());
        if (parambodv == localVideoTrackTimeLineView) {
          l2 = l1;
        }
      }
      else
      {
        return l2;
      }
      k += 1;
    }
  }
  
  public void b()
  {
    Object localObject1 = null;
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    if (localIterator.hasNext())
    {
      Object localObject2 = (VideoTrackTimeLineView)localIterator.next();
      ImageView localImageView;
      if (((VideoTrackTimeLineView)localObject2).getTag() != null)
      {
        localImageView = (ImageView)((VideoTrackTimeLineView)localObject2).getTag();
        if (((VideoTrackTimeLineView)localObject2).isSelected())
        {
          localImageView.setVisibility(8);
          bnrh.a("VideoTrackContainerView", "refreshPieceView GONE");
          localObject2 = localImageView;
          if (localObject1 != null)
          {
            localObject1.setVisibility(8);
            bnrh.a("VideoTrackContainerView", "refreshPieceView lastPieceView GONE");
            localObject2 = localImageView;
          }
        }
      }
      for (;;)
      {
        localObject1 = localObject2;
        break;
        localImageView.setVisibility(0);
        bnrh.a("VideoTrackContainerView", "refreshPieceView VISIBLE");
        localObject2 = localImageView;
        continue;
        if ((localObject1 != null) && (((VideoTrackTimeLineView)localObject2).isSelected()))
        {
          localObject1.setVisibility(8);
          bnrh.a("VideoTrackContainerView", "refreshPieceView lastPieceView GONE");
        }
        localObject2 = localObject1;
      }
    }
  }
  
  public void b(bodv parambodv, long paramLong1, long paramLong2)
  {
    paramLong1 = 0L;
    if ((this.jdField_a_of_type_Bnzx != null) && (this.jdField_a_of_type_Bnzx.a())) {
      this.jdField_a_of_type_Bnzx.b();
    }
    Object localObject1 = this.jdField_c_of_type_JavaUtilList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (VideoTrackTimeLineView)((Iterator)localObject1).next();
      if (((VideoTrackTimeLineView)localObject2).getLocalVisibleRect(new Rect())) {
        ((VideoTrackTimeLineView)localObject2).a().invalidate();
      }
    }
    this.jdField_b_of_type_Boolean = true;
    if ((this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Boolean)) {
      bnrh.b("miles", "正在滚动，直接返回");
    }
    for (;;)
    {
      return;
      localObject1 = (ViewGroup.MarginLayoutParams)((VideoTrackTimeLineView)this.jdField_c_of_type_JavaUtilList.get(this.jdField_c_of_type_JavaUtilList.size() - 1)).getLayoutParams();
      localObject2 = new int[2];
      ((VideoTrackTimeLineView)parambodv).getLocationOnScreen((int[])localObject2);
      int k;
      if (paramLong2 <= 0L)
      {
        k = localObject2[0];
        if (((VideoTrackTimeLineView)parambodv).getWidth() + k <= b()) {
          c(parambodv, (int)((VideoTrackTimeLineView)parambodv).g());
        }
      }
      while (this.jdField_a_of_type_Bnzx != null)
      {
        parambodv = this.jdField_c_of_type_JavaUtilList.iterator();
        while (parambodv.hasNext()) {
          paramLong1 = ((VideoTrackTimeLineView)parambodv.next()).d() + paramLong1;
        }
        if (paramLong2 >= 0L)
        {
          k = localObject2[0];
          if (((VideoTrackTimeLineView)parambodv).getWidth() + k >= c() - b())
          {
            d(parambodv, (int)((VideoTrackTimeLineView)parambodv).h());
            continue;
          }
        }
        ((ViewGroup.MarginLayoutParams)localObject1).rightMargin = (this.jdField_c_of_type_Int - this.jdField_a_of_type_Boer.a(paramLong2));
      }
    }
    this.jdField_a_of_type_Bnzx.a(paramLong1);
  }
  
  public void b(List<VideoTransitionModel> paramList)
  {
    this.jdField_b_of_type_JavaUtilList = paramList;
    paramList = this.jdField_c_of_type_JavaUtilList.iterator();
    int k = -1;
    VideoTrackTimeLineView localVideoTrackTimeLineView;
    int m;
    Object localObject;
    if (paramList.hasNext())
    {
      localVideoTrackTimeLineView = (VideoTrackTimeLineView)paramList.next();
      m = k + 1;
      localObject = a(this.jdField_b_of_type_JavaUtilList, m);
      if (localObject == null) {
        break label153;
      }
    }
    label153:
    for (k = this.jdField_a_of_type_Boer.a((((VideoTransitionModel)localObject).getOverlapTime() / ((VideoTransitionModel)localObject).getSpeed()));; k = 0)
    {
      localObject = (LinearLayout.LayoutParams)localVideoTrackTimeLineView.getLayoutParams();
      if (localObject != null)
      {
        k = this.jdField_a_of_type_Boer.a(localVideoTrackTimeLineView.b() - localVideoTrackTimeLineView.a()) + localVideoTrackTimeLineView.a() + localVideoTrackTimeLineView.b() - k;
        if (((LinearLayout.LayoutParams)localObject).width != k)
        {
          ((LinearLayout.LayoutParams)localObject).width = k;
          localVideoTrackTimeLineView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      k = m;
      break;
      return;
    }
  }
  
  public boolean b()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean)) {
      return;
    }
    Object localObject;
    VideoTrackTimeLineView localVideoTrackTimeLineView;
    do
    {
      do
      {
        localObject = this.jdField_c_of_type_JavaUtilList.iterator();
      } while (!((Iterator)localObject).hasNext());
      localVideoTrackTimeLineView = (VideoTrackTimeLineView)((Iterator)localObject).next();
      if (!localVideoTrackTimeLineView.isSelected()) {
        break;
      }
      localObject = new int[2];
      localVideoTrackTimeLineView.getLocationOnScreen((int[])localObject);
    } while ((localObject[0] + localVideoTrackTimeLineView.getWidth() >= c() / 2) && (localObject[0] <= c() / 2));
    localVideoTrackTimeLineView.setSelected(false);
  }
  
  public void d()
  {
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      VideoTrackTimeLineView localVideoTrackTimeLineView = (VideoTrackTimeLineView)localIterator.next();
      if (localVideoTrackTimeLineView.isSelected()) {
        localVideoTrackTimeLineView.setSelected(false);
      }
    }
  }
  
  public void e()
  {
    k();
  }
  
  public void f()
  {
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    int k = 0;
    long l = 0L;
    if (localIterator.hasNext())
    {
      VideoTrackTimeLineView localVideoTrackTimeLineView = (VideoTrackTimeLineView)localIterator.next();
      VideoResourceModelKt localVideoResourceModelKt = localVideoTrackTimeLineView.a().getResource();
      localVideoTrackTimeLineView.setStartValue(l);
      localVideoTrackTimeLineView.setEndValue(localVideoResourceModelKt.getScaleDuration() + l);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localVideoTrackTimeLineView.getLayoutParams();
      if (k == this.jdField_c_of_type_JavaUtilList.size() - 1) {}
      for (boolean bool = true;; bool = false)
      {
        a(localVideoTrackTimeLineView, localLayoutParams, bool);
        localVideoTrackTimeLineView.setLayoutParams(localVideoTrackTimeLineView.getLayoutParams());
        l += localVideoResourceModelKt.getScaleDuration();
        localVideoTrackTimeLineView.d();
        k += 1;
        break;
      }
    }
    if (this.i)
    {
      j();
      return;
    }
    b(this.jdField_b_of_type_JavaUtilList);
  }
  
  public void g()
  {
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((VideoTrackTimeLineView)localIterator.next()).e();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    VideoThumbProviderManager.getInstance().unRegisterListener(this.jdField_a_of_type_ComTencentWeishiModuleEditWidgetPlaytrackProviderVideoThumbListener);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.jdField_a_of_type_Bodu != null) && (!this.jdField_e_of_type_Boolean)) {
      this.jdField_a_of_type_Bodu.a(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((VideoTrackTimeLineView)localIterator.next()).a(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
    {
      this.jdField_e_of_type_Boolean = false;
      if (this.jdField_a_of_type_Bofr != null) {
        post(this.jdField_a_of_type_JavaLangRunnable);
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setBitmapWidth(int paramInt)
  {
    this.jdField_g_of_type_Int = paramInt;
  }
  
  public void setClickable(boolean paramBoolean)
  {
    super.setClickable(paramBoolean);
    this.jdField_g_of_type_Boolean = paramBoolean;
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((VideoTrackTimeLineView)localIterator.next()).setClickable(paramBoolean);
    }
  }
  
  public void setContentPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setCornerRadius(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
  }
  
  public void setItemOnLongClickListener(body parambody)
  {
    this.jdField_a_of_type_Body = parambody;
  }
  
  public void setMaxDurationLimit(long paramLong)
  {
    if (paramLong > 0L) {
      this.jdField_a_of_type_Long = paramLong;
    }
  }
  
  public void setOnScrollStoppedListener(bofr parambofr)
  {
    this.jdField_a_of_type_Bofr = parambofr;
  }
  
  public void setOnStartTimeChangedListener(bofs parambofs)
  {
    this.jdField_a_of_type_Bofs = parambofs;
  }
  
  public void setOnTransitionListener(bofb parambofb)
  {
    this.jdField_a_of_type_Bofb = parambofb;
  }
  
  public void setScaleAdapter(boer paramboer)
  {
    this.jdField_a_of_type_Boer = paramboer;
  }
  
  public void setScrollByPassive(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public void setScrollListener(bodu parambodu)
  {
    this.jdField_a_of_type_Bodu = parambodu;
  }
  
  public void setSelectedStateListener(bofd parambofd)
  {
    this.jdField_a_of_type_Bofd = parambofd;
  }
  
  public void setShowLeftAndRightSliderView(boolean paramBoolean)
  {
    this.jdField_h_of_type_Boolean = paramBoolean;
  }
  
  public void setShowPieces(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void setTimeBar(ScaleTimeBar paramScaleTimeBar)
  {
    this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleTimeBar = paramScaleTimeBar;
  }
  
  public void setVideoClipClickListener(boft paramboft)
  {
    this.jdField_a_of_type_Boft = paramboft;
  }
  
  public void setVideoModel(bnzx parambnzx)
  {
    this.jdField_a_of_type_Bnzx = parambnzx;
  }
  
  public void setVideoTrackSelectedStyle(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setVideoTrackStoreListener(bofu parambofu)
  {
    this.jdField_a_of_type_Bofu = parambofu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.view.videotrack.VideoTrackContainerView
 * JD-Core Version:    0.7.0.1
 */