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
import bdee;
import bmwb;
import bnbg;
import bogc;
import boid;
import boik;
import bolc;
import bomd;
import botf;
import bots;
import botw;
import bovf;
import bovp;
import bovq;
import bovr;
import bovv;
import bovy;
import bovz;
import bowa;
import bowb;
import bowd;
import bowe;
import bowf;
import bowi;
import bown;
import bowq;
import bowt;
import bowv;
import boxn;
import boyu;
import boyv;
import boyw;
import boyx;
import boyy;
import boyz;
import boza;
import bozb;
import bozc;
import bozd;
import boze;
import bozg;
import bozh;
import bozi;
import bozl;
import bozm;
import bozn;
import bozo;
import bozp;
import bozq;
import bozt;
import bpal;
import bpaq;
import bpau;
import bpbd;
import bpde;
import bpdg;
import bphu;
import bphv;
import bphx;
import bptp;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam.MotionInfo;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.qq.im.capture.text.DynamicTextItem.TextMap;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.StoryGuideLineView;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
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
import ykq;
import ykv;
import ykw;

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
  public SparseArray<bowt> a;
  public SparseBooleanArray a;
  public FrameLayout a;
  public ImageView a;
  public RelativeLayout a;
  protected boid a;
  private boik jdField_a_of_type_Boik;
  bolc jdField_a_of_type_Bolc = new bolc();
  private botf jdField_a_of_type_Botf;
  public bovv a;
  public bowa a;
  public boxn a;
  public bozc a;
  public bozd a;
  public boze a;
  private bozm jdField_a_of_type_Bozm;
  private bozo jdField_a_of_type_Bozo;
  public bozp a;
  public EditVideoParams a;
  public DoodleEditView a;
  public DoodleTextureView a;
  public DoodleView a;
  private StoryGuideLineView jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView;
  public HorizontalSelectColorLayout a;
  private RuntimeException jdField_a_of_type_JavaLangRuntimeException;
  private Comparator<bown> jdField_a_of_type_JavaUtilComparator = new boyu(this);
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  private final Condition jdField_a_of_type_JavaUtilConcurrentLocksCondition = this.jdField_a_of_type_JavaUtilConcurrentLocksLock.newCondition();
  private final Lock jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  public int b;
  private long b;
  public SparseArray<bozh> b;
  public SparseBooleanArray b;
  public DoodleView b;
  public boolean b;
  public int c;
  public boolean c;
  public int d;
  private boolean d;
  private int jdField_e_of_type_Int = -1;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = -1;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int = -1;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int = -1;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int = -1;
  private boolean jdField_i_of_type_Boolean = true;
  private int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean = true;
  private int jdField_k_of_type_Int;
  private boolean jdField_k_of_type_Boolean;
  private boolean l;
  
  public DoodleLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
    this.jdField_b_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_Bozp = new bozp(this, null);
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    LayoutInflater.from(super.getContext()).inflate(2131559138, this);
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
    ykv.a("video_edit", paramString, paramInt1, paramInt2, paramVarArgs);
  }
  
  private boolean a(boolean paramBoolean)
  {
    b();
    ykq.b("DoodleLayout", "onBackPressed, buttonState:" + this.jdField_d_of_type_Int + ",activeLayer:" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a());
    if ((this.jdField_d_of_type_Int == 0) || ((this.jdField_d_of_type_Int == 2) && (!paramBoolean))) {
      return false;
    }
    l();
    b(0);
    if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.b())
    {
      ykq.b("DoodleLayout", "onBackPressed, resetDoodleView.");
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.f();
    }
    return true;
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_a_of_type_Bowa == null) {
      this.jdField_a_of_type_Bowa = new bowa(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
    }
    Object localObject1 = (bowt)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    int m;
    if (localObject1 == null)
    {
      ykq.b("DoodleLayout", "initDoodleView for the %d video", Integer.valueOf(paramInt));
      Object localObject4 = a();
      localObject1 = (bovr)((bozl)localObject4).a(bovr.jdField_a_of_type_JavaLangString);
      bovp localbovp = (bovp)((bozl)localObject4).a("DynamicFaceLayer");
      Object localObject2 = (bowb)((bozl)localObject4).a("LineLayer");
      bowf localbowf = (bowf)((bozl)localObject4).a(bowf.jdField_a_of_type_JavaLangString);
      Object localObject3 = (bowa)((bozl)localObject4).a("GuideLineLayer");
      if (localObject2 != null)
      {
        bpal localbpal = (bpal)((bowb)localObject2).a(103);
        if ((localbpal != null) && (this.jdField_e_of_type_Int != -1)) {
          localbpal.b(this.jdField_e_of_type_Int);
        }
        if ((localbpal != null) && (this.jdField_f_of_type_Int != -1) && (this.jdField_g_of_type_Int != -1)) {
          localbpal.b(this.jdField_f_of_type_Int, this.jdField_g_of_type_Int);
        }
      }
      localObject4 = new bowv().a((bowq)localObject4);
      if (this.jdField_h_of_type_Int != -1)
      {
        m = this.jdField_h_of_type_Int;
        localObject4 = ((bowv)localObject4).a(m);
        if (this.jdField_i_of_type_Int == -1) {
          break label508;
        }
        m = this.jdField_i_of_type_Int;
        label241:
        localObject4 = ((bowv)localObject4).b(m).a();
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setDoodleConfig((bowt)localObject4);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setDoodleLayout(this);
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null)
        {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
        }
        localObject3 = new bozh(localbowf, (bowb)localObject2, (bovr)localObject1, localbovp, (bowa)localObject3, (bovq)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(bovq.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject4);
        this.jdField_b_of_type_AndroidUtilSparseArray.put(paramInt, localObject3);
        if (localObject2 != null)
        {
          ((bowb)localObject2).a(new bozi(this, null));
          ((bowb)localObject2).a(new boza(this));
        }
        if (localObject1 != null) {
          ((bovr)localObject1).a(this.jdField_a_of_type_Bozp);
        }
        if (localbovp != null) {
          localbovp.a(this.jdField_a_of_type_Bozp);
        }
        localObject2 = new bozb(this);
        if (localObject1 != null) {
          ((bovr)localObject1).a((bovy)localObject2);
        }
        if (localbovp != null) {
          localbovp.a((bovy)localObject2);
        }
        if ((localbowf != null) && (!this.jdField_d_of_type_Boolean))
        {
          localbowf.a(this.jdField_a_of_type_Bozp);
          localbowf.a(new bozq(this, null));
        }
        this.jdField_a_of_type_Boik = ((boik)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a("PickLayer"));
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
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setDoodleConfig((bowt)localObject1);
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
      ykq.b("DoodleLayout", "rubbish active.");
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(getResources().getColor(2131166367));
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846803);
      return;
    }
    ykq.b("DoodleLayout", "rubbish unActive.");
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(getResources().getColor(2131166368));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846803);
  }
  
  private static void e(boolean paramBoolean)
  {
    if (paramBoolean) {
      bovf.a().a();
    }
  }
  
  private void u()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131377009));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131369532));
    if (LiuHaiUtils.f()) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, LiuHaiUtils.a(), 0, 0);
    }
    this.jdField_a_of_type_Boid = new bozg(this, null);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout = ((HorizontalSelectColorLayout)super.findViewById(2131371921));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setOnUndoViewClickListener(new boyw(this));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setOnStrokeSelectedListener(new boyx(this));
    View localView = super.findViewById(2131363727);
    if (localView != null) {
      localView.setVisibility(0);
    }
    x();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView = ((DoodleView)super.findViewById(2131365800));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView = ((DoodleEditView)super.findViewById(2131365801));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setDoodleLayout(this);
    setOnTextDialogShowListener(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setOnLayerTouchListener();
    this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView = ((DoodleView)super.findViewById(2131365807));
    l();
  }
  
  private void v()
  {
    bowb localbowb = a();
    if ((localbowb != null) && (this.jdField_e_of_type_Boolean))
    {
      localbowb.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleTextureView);
      localbowb.a.a(new boyy(this));
      if (this.jdField_e_of_type_Boolean)
      {
        ((bpaq)localbowb.a.a(102)).a(false);
        localbowb.a.a(new boyz(this));
        localbowb.c();
      }
    }
  }
  
  private void w()
  {
    bpdg localbpdg;
    Object localObject;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b())
    {
      localbpdg = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.a();
      localbpdg.jdField_k_of_type_Boolean = false;
      if (!(localbpdg instanceof bovv)) {
        break label118;
      }
      localObject = a();
      if (((((bovv)localbpdg).jdField_h_of_type_Int != 1) && (((bovv)localbpdg).jdField_h_of_type_Int != 3)) || ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()))) {
        break label147;
      }
      localObject = a();
      ((bovv)localbpdg).jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
    }
    label147:
    for (;;)
    {
      if (localObject != null) {}
      label118:
      do
      {
        ((bovr)localObject).jdField_a_of_type_JavaUtilList.add((bovv)localbpdg);
        do
        {
          return;
        } while (!(localbpdg instanceof bowi));
        localObject = a();
      } while (localObject == null);
      ((bowf)localObject).jdField_a_of_type_JavaUtilArrayList.add((bowi)localbpdg);
      return;
    }
  }
  
  private void x()
  {
    AppInterface localAppInterface = null;
    if ((super.getContext() instanceof QQStoryBaseActivity)) {
      localAppInterface = ((QQStoryBaseActivity)super.getContext()).a;
    }
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (!VideoEnvironment.isX86Platform()) && (bmwb.b())) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setStrokeStrategy(new bphu(localAppInterface, true, bool, a()), true, 2);
      t();
      return;
    }
  }
  
  protected int a()
  {
    return bptp.a(65.0F);
  }
  
  public int a(int paramInt)
  {
    bozh localbozh = (bozh)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localbozh != null)
    {
      paramInt = localbozh.jdField_a_of_type_Bowf.b();
      int m = localbozh.jdField_a_of_type_Bowb.b();
      int n = localbozh.jdField_a_of_type_Bovr.b();
      int i1 = localbozh.jdField_a_of_type_Bovp.b();
      ykq.b("DoodleLayout", "DoodleCount: text->" + paramInt + ",line->" + m + ",face->" + n + " " + i1);
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
    bozh localbozh = (bozh)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localbozh != null) {
      return localbozh.jdField_a_of_type_Bowb.a();
    }
    return null;
  }
  
  /* Error */
  public Bitmap a(int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 249	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView	Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleView;
    //   4: invokevirtual 675	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleView:b	()I
    //   7: istore_3
    //   8: aload_0
    //   9: getfield 249	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView	Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleView;
    //   12: invokevirtual 677	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleView:c	()I
    //   15: istore 4
    //   17: iload_3
    //   18: ifle +8 -> 26
    //   21: iload 4
    //   23: ifgt +32 -> 55
    //   26: ldc 233
    //   28: ldc_w 679
    //   31: iconst_2
    //   32: anewarray 681	java/lang/Object
    //   35: dup
    //   36: iconst_0
    //   37: iload_3
    //   38: invokestatic 302	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   41: aastore
    //   42: dup
    //   43: iconst_1
    //   44: iload 4
    //   46: invokestatic 302	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   49: aastore
    //   50: invokestatic 684	ykq:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   53: aconst_null
    //   54: areturn
    //   55: aload_0
    //   56: getfield 101	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   59: iconst_0
    //   60: invokevirtual 687	java/util/concurrent/atomic/AtomicBoolean:getAndSet	(Z)Z
    //   63: ifeq +16 -> 79
    //   66: aload_0
    //   67: iload_3
    //   68: iload 4
    //   70: getstatic 693	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   73: invokestatic 699	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   76: putfield 701	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   79: aload_0
    //   80: getfield 106	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   83: invokeinterface 704 1 0
    //   88: aload_0
    //   89: getfield 701	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   92: astore 9
    //   94: aload 9
    //   96: ifnonnull +118 -> 214
    //   99: ldc 233
    //   101: ldc_w 706
    //   104: invokestatic 708	ykq:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: aload_0
    //   108: getfield 114	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaUtilConcurrentLocksCondition	Ljava/util/concurrent/locks/Condition;
    //   111: ldc2_w 709
    //   114: getstatic 716	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   117: invokeinterface 722 4 0
    //   122: ifne -34 -> 88
    //   125: ldc 233
    //   127: ldc_w 724
    //   130: iconst_1
    //   131: anewarray 681	java/lang/Object
    //   134: dup
    //   135: iconst_0
    //   136: invokestatic 730	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   139: invokevirtual 734	java/lang/Thread:getId	()J
    //   142: invokestatic 739	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   145: aastore
    //   146: invokestatic 741	ykq:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   149: aload_0
    //   150: getfield 743	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaLangRuntimeException	Ljava/lang/RuntimeException;
    //   153: ifnull -65 -> 88
    //   156: ldc 233
    //   158: ldc_w 745
    //   161: aload_0
    //   162: getfield 743	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaLangRuntimeException	Ljava/lang/RuntimeException;
    //   165: invokestatic 748	ykq:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   168: goto -80 -> 88
    //   171: astore 9
    //   173: ldc 233
    //   175: ldc_w 750
    //   178: aload 9
    //   180: invokestatic 748	ykq:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   183: goto -95 -> 88
    //   186: astore 9
    //   188: aload_0
    //   189: getfield 106	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   192: invokeinterface 753 1 0
    //   197: aload 9
    //   199: athrow
    //   200: astore 9
    //   202: ldc 233
    //   204: ldc_w 755
    //   207: aload 9
    //   209: invokestatic 757	ykq:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   212: aconst_null
    //   213: areturn
    //   214: aload_0
    //   215: getfield 701	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   218: astore 9
    //   220: aload_0
    //   221: aconst_null
    //   222: putfield 701	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   225: new 759	android/graphics/Canvas
    //   228: dup
    //   229: aload 9
    //   231: invokespecial 762	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   234: astore 10
    //   236: new 764	android/graphics/Paint
    //   239: dup
    //   240: invokespecial 765	android/graphics/Paint:<init>	()V
    //   243: astore 11
    //   245: aload 11
    //   247: new 767	android/graphics/PorterDuffXfermode
    //   250: dup
    //   251: getstatic 773	android/graphics/PorterDuff$Mode:CLEAR	Landroid/graphics/PorterDuff$Mode;
    //   254: invokespecial 776	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   257: invokevirtual 780	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   260: pop
    //   261: aload 10
    //   263: aload 11
    //   265: invokevirtual 784	android/graphics/Canvas:drawPaint	(Landroid/graphics/Paint;)V
    //   268: aload_0
    //   269: getfield 82	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   272: iload_1
    //   273: invokevirtual 292	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   276: checkcast 373	bozh
    //   279: astore 11
    //   281: aload 11
    //   283: ifnonnull +34 -> 317
    //   286: ldc 233
    //   288: ldc_w 786
    //   291: iconst_1
    //   292: anewarray 681	java/lang/Object
    //   295: dup
    //   296: iconst_0
    //   297: iload_1
    //   298: invokestatic 302	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   301: aastore
    //   302: invokestatic 684	ykq:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   305: aload_0
    //   306: getfield 106	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   309: invokeinterface 753 1 0
    //   314: aload 9
    //   316: areturn
    //   317: invokestatic 791	android/os/SystemClock:uptimeMillis	()J
    //   320: lstore 5
    //   322: aload 11
    //   324: getfield 647	bozh:jdField_a_of_type_Bowb	Lbowb;
    //   327: astore 12
    //   329: aload 12
    //   331: getfield 535	bowb:a	Lbozt;
    //   334: invokevirtual 792	bozt:a	()Z
    //   337: ifeq +20 -> 357
    //   340: ldc 233
    //   342: ldc_w 794
    //   345: invokestatic 708	ykq:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   348: aload 12
    //   350: getfield 535	bowb:a	Lbozt;
    //   353: iload_3
    //   354: invokevirtual 795	bozt:b	(I)V
    //   357: aload_0
    //   358: getfield 363	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams;
    //   361: ifnull +20 -> 381
    //   364: aload_0
    //   365: getfield 363	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams;
    //   368: invokevirtual 796	dov/com/tencent/biz/qqstory/takevideo/EditVideoParams:a	()Z
    //   371: ifeq +10 -> 381
    //   374: aload 12
    //   376: aload 10
    //   378: invokevirtual 799	bowb:c	(Landroid/graphics/Canvas;)V
    //   381: aload_0
    //   382: getfield 190	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_Botf	Lbotf;
    //   385: getfield 804	botf:a	Lbotw;
    //   388: invokevirtual 808	botw:b	()J
    //   391: lstore 7
    //   393: lload 7
    //   395: lconst_0
    //   396: lcmp
    //   397: ifeq +33 -> 430
    //   400: iload_2
    //   401: ifeq +29 -> 430
    //   404: aload_0
    //   405: getfield 190	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_Botf	Lbotf;
    //   408: lload 7
    //   410: invokevirtual 811	botf:a	(J)V
    //   413: aload_0
    //   414: getfield 190	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_Botf	Lbotf;
    //   417: invokevirtual 814	botf:a	()Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout;
    //   420: lload 7
    //   422: ldc2_w 815
    //   425: ldiv
    //   426: iconst_0
    //   427: invokevirtual 820	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:setTimeStamp	(JZ)V
    //   430: new 822	java/util/LinkedList
    //   433: dup
    //   434: aload 11
    //   436: getfield 823	bozh:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   439: invokespecial 826	java/util/LinkedList:<init>	(Ljava/util/Collection;)V
    //   442: astore 11
    //   444: aload 11
    //   446: aload_0
    //   447: getfield 130	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaUtilComparator	Ljava/util/Comparator;
    //   450: invokestatic 832	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   453: aload 11
    //   455: invokevirtual 835	java/util/LinkedList:size	()I
    //   458: iconst_1
    //   459: isub
    //   460: istore_1
    //   461: iload_1
    //   462: iflt +35 -> 497
    //   465: aload 11
    //   467: iload_1
    //   468: invokevirtual 836	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   471: checkcast 838	bown
    //   474: astore 12
    //   476: aload 12
    //   478: ifnull +118 -> 596
    //   481: aload 12
    //   483: aload 10
    //   485: aload 12
    //   487: invokevirtual 841	bown:a	()F
    //   490: iload_2
    //   491: invokevirtual 844	bown:a	(Landroid/graphics/Canvas;FZ)V
    //   494: goto +102 -> 596
    //   497: iload_2
    //   498: ifeq +49 -> 547
    //   501: aload 11
    //   503: invokevirtual 835	java/util/LinkedList:size	()I
    //   506: iconst_1
    //   507: isub
    //   508: istore_1
    //   509: iload_1
    //   510: iflt +37 -> 547
    //   513: aload 11
    //   515: iload_1
    //   516: invokevirtual 836	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   519: checkcast 838	bown
    //   522: astore 12
    //   524: aload 12
    //   526: ifnull +63 -> 589
    //   529: aload 12
    //   531: instanceof 322
    //   534: ifeq +55 -> 589
    //   537: aload 12
    //   539: checkcast 322	bovp
    //   542: aload 10
    //   544: invokevirtual 845	bovp:c	(Landroid/graphics/Canvas;)V
    //   547: ldc 233
    //   549: new 235	java/lang/StringBuilder
    //   552: dup
    //   553: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   556: ldc_w 847
    //   559: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: invokestatic 791	android/os/SystemClock:uptimeMillis	()J
    //   565: lload 5
    //   567: lsub
    //   568: invokevirtual 850	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   571: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   574: invokestatic 266	ykq:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   577: aload_0
    //   578: getfield 106	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   581: invokeinterface 753 1 0
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
  
  public boid a()
  {
    return this.jdField_a_of_type_Boid;
  }
  
  public bovp a()
  {
    bozh localbozh = (bozh)this.jdField_b_of_type_AndroidUtilSparseArray.get(this.jdField_c_of_type_Int);
    if (localbozh == null)
    {
      ykq.d("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int) });
      return null;
    }
    return localbozh.jdField_a_of_type_Bovp;
  }
  
  public bovq a()
  {
    bozh localbozh = (bozh)this.jdField_b_of_type_AndroidUtilSparseArray.get(this.jdField_c_of_type_Int);
    if (localbozh == null)
    {
      ykq.d("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int) });
      return null;
    }
    return localbozh.jdField_a_of_type_Bovq;
  }
  
  public bovr a()
  {
    bozh localbozh = (bozh)this.jdField_b_of_type_AndroidUtilSparseArray.get(this.jdField_c_of_type_Int);
    if (localbozh == null)
    {
      ykq.d("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int) });
      return null;
    }
    return localbozh.jdField_a_of_type_Bovr;
  }
  
  public bowb a()
  {
    bozh localbozh = (bozh)this.jdField_b_of_type_AndroidUtilSparseArray.get(this.jdField_c_of_type_Int);
    if (localbozh == null)
    {
      ykq.d("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int) });
      return null;
    }
    return localbozh.jdField_a_of_type_Bowb;
  }
  
  public bowf a()
  {
    bozh localbozh = (bozh)this.jdField_b_of_type_AndroidUtilSparseArray.get(this.jdField_c_of_type_Int);
    if (localbozh == null)
    {
      ykq.d("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int) });
      return null;
    }
    return localbozh.jdField_a_of_type_Bowf;
  }
  
  protected bozl a()
  {
    return new bozl(new bown[] { this.jdField_a_of_type_Bowa, new boik(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView), new bovr(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView), new bovp(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView), new bowb(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView), new bowf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView) });
  }
  
  public String a()
  {
    Object localObject2 = "";
    Object localObject3 = a();
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (((bowf)localObject3).jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject1 = localObject2;
        if (!((bowf)localObject3).jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          localObject1 = new JSONArray();
          localObject2 = ((bowf)localObject3).jdField_a_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (bowi)((Iterator)localObject2).next();
            if ((((bowi)localObject3).jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null) && (((bowi)localObject3).jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a() != null)) {
              ((JSONArray)localObject1).put(((bowi)localObject3).jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a().toString());
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
    Object localObject = (bozh)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject == null)
    {
      ykq.d("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(paramInt) });
      return null;
    }
    localObject = ((bozh)localObject).jdField_a_of_type_Bowf;
    if ((((bowf)localObject).jdField_a_of_type_JavaUtilArrayList != null) && (!((bowf)localObject).jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      localObject = ((bowf)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        bowi localbowi = (bowi)((Iterator)localObject).next();
        if (localbowi.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null)
        {
          localObject = localbowi.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a().toString();
          return ((String)localObject).substring(0, ((String)localObject).length() - 1);
        }
      }
    }
    return null;
  }
  
  public List<String> a(int paramInt)
  {
    Object localObject = (bozh)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject != null)
    {
      localObject = ((bozh)localObject).jdField_a_of_type_Bowb.a.a();
      StringBuilder localStringBuilder = new StringBuilder().append("image doodle type count:");
      if ((localObject == null) || (((List)localObject).isEmpty())) {}
      for (paramInt = 0;; paramInt = ((List)localObject).size())
      {
        ykq.b("DoodleLayout", paramInt);
        return localObject;
      }
    }
    return Collections.emptyList();
  }
  
  public Map<String, List<String>> a(int paramInt)
  {
    Object localObject = (bozh)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject != null)
    {
      localObject = ((bozh)localObject).jdField_a_of_type_Bovr.jdField_a_of_type_JavaUtilMap;
      ykq.b("DoodleLayout", "Using face map:" + localObject.toString());
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
    if (this.jdField_a_of_type_Bozd != null) {
      this.jdField_a_of_type_Bozd.a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
    }
  }
  
  public void a(int paramInt)
  {
    if (!bozn.a(paramInt))
    {
      ykq.e("DoodleLayout", "illegal state.");
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
    ykq.b("DoodleLayout", String.format("changeDoodleViewSize, width: %d, height: %d ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
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
    localObject = (bpal)a().a(104);
    if (localObject != null) {
      ((bpal)localObject).e();
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
    if (this.jdField_a_of_type_Bozd != null) {
      this.jdField_a_of_type_Bozd.a_(paramInt, paramObject);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    b();
    ykq.b("DoodleLayout", "addNewSticker, buttonState:" + this.jdField_d_of_type_Int + ",activeLayer:" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a());
    bowf localbowf = a();
    paramString = this.jdField_a_of_type_Bolc.a(paramInt, Arrays.asList(new String[] { paramString }));
    a().a(d());
    a().b(paramString);
    localbowf.d(true);
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
  
  public void a(bpbd parambpbd, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    a(parambpbd, paramFloat1, paramFloat2, paramFloat3, null);
  }
  
  public void a(bpbd parambpbd, float paramFloat1, float paramFloat2, float paramFloat3, SegmentKeeper paramSegmentKeeper)
  {
    b();
    if (parambpbd == null) {
      ykq.e("DoodleLayout", "the item is null.");
    }
    for (;;)
    {
      return;
      ykq.b("DoodleLayout", "addLocationFaceItem:" + parambpbd.toString());
      bovz localbovz = bpde.a(parambpbd, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.getWidth(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.getHeight(), paramFloat1, paramFloat2, paramFloat3);
      File localFile;
      Object localObject;
      if (localbovz != null)
      {
        if ((parambpbd.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) || (!(parambpbd.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof URLDrawable))) {
          break label228;
        }
        localFile = ((URLDrawable)parambpbd.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getFileInLocal();
        if ((localFile == null) || (!localFile.exists())) {
          break label228;
        }
        localObject = a();
        if (((parambpbd.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null)) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b())) {
          localObject = a();
        }
      }
      label228:
      for (boolean bool = ((bovr)localObject).a(parambpbd.g, parambpbd.c, parambpbd.jdField_a_of_type_AndroidGraphicsDrawableDrawable, localbovz, localFile.getAbsolutePath(), true, parambpbd.jdField_a_of_type_Int, d(), paramSegmentKeeper); bool; bool = false)
      {
        this.jdField_a_of_type_Bozd.a(parambpbd);
        ykw.a("0X80076CE");
        e(this.jdField_b_of_type_Boolean);
        return;
        ykq.e("DoodleLayout", "create FaceLayer.ItemParams failed.");
        return;
      }
    }
  }
  
  public void a(DynamicTextItem paramDynamicTextItem, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a()) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a.getBoolean("key_enable_edit_title_bar"))) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramDynamicTextItem, paramInt1, paramInt2, paramBoolean, bool);
      return;
    }
  }
  
  public void a(DynamicTextItem paramDynamicTextItem, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    ykq.b("DoodleLayout", "onClickInside: showEditTextDialog." + paramDynamicTextItem);
    if (paramDynamicTextItem != null) {
      paramDynamicTextItem.b();
    }
    this.jdField_a_of_type_Boze = new boze(this, null);
    this.jdField_a_of_type_Boxn = new boxn(super.getContext(), paramBoolean1);
    if ((this.jdField_a_of_type_Botf != null) && (this.jdField_a_of_type_Botf.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null)) {
      this.jdField_a_of_type_Boxn.jdField_a_of_type_AndroidWidgetRelativeLayout = this.jdField_a_of_type_Botf.a.jdField_a_of_type_AndroidWidgetRelativeLayout;
    }
    if ((((Activity)getContext()).getWindow().getAttributes().flags & 0x400) == 1024)
    {
      paramBoolean1 = true;
      this.jdField_a_of_type_Boxn.d(paramBoolean1);
      this.jdField_a_of_type_Boxn.jdField_g_of_type_Int = paramInt2;
      boxn localboxn = this.jdField_a_of_type_Boxn;
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) || (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a())) {
        break label300;
      }
      paramBoolean1 = true;
      label172:
      localboxn.c(paramBoolean1);
      this.jdField_a_of_type_Boxn.a(a());
      this.jdField_a_of_type_Boxn.b(paramBoolean2);
      this.jdField_a_of_type_Boxn.setContentView(2131561660);
      this.jdField_a_of_type_Boxn.a(this.jdField_a_of_type_Boze);
      this.jdField_a_of_type_Boxn.a(this.jdField_a_of_type_Bolc);
      if (paramInt2 == 0)
      {
        if ((paramDynamicTextItem instanceof bomd)) {
          ((bomd)paramDynamicTextItem).a(bphv.a(a()));
        }
        this.jdField_a_of_type_Boxn.a(paramDynamicTextItem, paramInt1);
      }
      this.jdField_a_of_type_Boxn.show();
      invalidate();
      if (this.jdField_d_of_type_Int != 0) {
        break label306;
      }
    }
    for (;;)
    {
      a(3);
      b(3);
      return;
      paramBoolean1 = false;
      break;
      label300:
      paramBoolean1 = false;
      break label172;
      label306:
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
  
  public void a(Map<Long, TrackerStickerParam.MotionInfo> paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoodleLayout", 2, "notifyFinishMotionTrack");
    }
    ThreadManager.getUIHandler().post(new DoodleLayout.12(this, paramMap));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boik.d(paramBoolean);
  }
  
  public void a(boolean paramBoolean1, float paramFloat, int paramInt1, int paramInt2, PointF paramPointF, boolean paramBoolean2, int paramInt3)
  {
    if (this.jdField_a_of_type_Bowa == null) {
      return;
    }
    this.jdField_a_of_type_Bowa.a(paramBoolean1, paramFloat, paramInt1, paramInt2, paramPointF, paramBoolean2, paramInt3);
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
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Botf != null) {
        break;
      }
      if (((this.jdField_a_of_type_Bozd instanceof bogc)) || ((this.jdField_a_of_type_Bozd instanceof bnbg)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("DoodleLayout", 2, "mEditDoodlePart == null && mListener instanceof QIMCaptureController/AECaptureController, showLimitBorder");
        }
        if ((this.jdField_a_of_type_Bozd instanceof bogc)) {}
        for (int m = ((bogc)this.jdField_a_of_type_Bozd).jdField_a_of_type_Int; (m != 11) && (m != 12); m = 0)
        {
          a(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
          return;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("DoodleLayout", 2, "mEditDoodlePart != null || mListener is not instanceof QIMCaptureController/AECaptureController, broadcast showLimitBorder message");
    }
    this.jdField_a_of_type_Botf.a.a(Message.obtain(null, 15, 0, 0, new bots(paramBoolean3, paramBoolean4, paramBoolean2, paramBoolean1, paramBoolean5)));
  }
  
  public void a(View... paramVarArgs)
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
    if (this.jdField_a_of_type_Bozd != null) {
      return this.jdField_a_of_type_Bozd.a();
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
  
  public boolean a(bowi parambowi, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) && (parambowi != null))
    {
      if (paramBoolean) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setVisibility(0);
      }
      w();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.a(parambowi);
      parambowi.jdField_k_of_type_Boolean = true;
      Object localObject = parambowi.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper;
      if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a()) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        ((SegmentKeeper)localObject).lockData(paramBoolean);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.requestLayout();
        localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a();
        if ((localObject != null) && (((bowd)localObject).a != null) && (parambowi.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null) && (parambowi.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a()))
        {
          parambowi.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.c();
          ((bowd)localObject).a.a(parambowi, parambowi.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b(), 0, 0.0F, 0.0F);
        }
        return true;
      }
    }
    return false;
  }
  
  public byte[] a(int paramInt)
  {
    bozh localbozh = (bozh)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localbozh == null) {
      return null;
    }
    return localbozh.jdField_a_of_type_Bowb.a();
  }
  
  public int[] a(int paramInt)
  {
    Object localObject = (bozh)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject != null)
    {
      localObject = ((bozh)localObject).jdField_a_of_type_Bowb.a.a();
      ykq.b("DoodleLayout", "normal path count:" + localObject[0] + ",mosaic path count:" + localObject[1]);
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
      bozh localbozh = (bozh)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(m);
      n = n + localbozh.jdField_a_of_type_Bowf.b() + localbozh.jdField_a_of_type_Bowb.b() + localbozh.jdField_a_of_type_Bovr.b() + localbozh.jdField_a_of_type_Bovp.b();
      m += 1;
    }
    return n;
  }
  
  public Bitmap b()
  {
    if (this.jdField_a_of_type_Bozc == null) {
      return null;
    }
    return this.jdField_a_of_type_Bozc.b();
  }
  
  public String b()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject1 = a();
      if ((localObject1 != null) && (((bowf)localObject1).jdField_a_of_type_JavaUtilArrayList != null) && (!((bowf)localObject1).jdField_a_of_type_JavaUtilArrayList.isEmpty()))
      {
        localObject1 = ((bowf)localObject1).jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (bowi)((Iterator)localObject1).next();
          if (((bowi)localObject2).jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null)
          {
            localObject2 = bolc.a(((bowi)localObject2).jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.c());
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
  
  public List<bovv> b(int paramInt)
  {
    bozh localbozh = (bozh)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localbozh != null)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(localbozh.jdField_a_of_type_Bovr.b);
      localArrayList.addAll(localbozh.jdField_a_of_type_Bovp.b);
      ykq.b("DoodleLayout", "Using poi list:" + localArrayList.toString());
      return Collections.unmodifiableList(localArrayList);
    }
    return Collections.emptyList();
  }
  
  public void b()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      throw new IllegalStateException("Only the original thread that created a view hierarchy can touch its views.");
    }
  }
  
  public void b(int paramInt)
  {
    a(paramInt, null);
  }
  
  public void b(boolean paramBoolean)
  {
    bovp localbovp = a();
    if (localbovp != null) {
      localbovp.a(paramBoolean);
    }
  }
  
  public void b(View... paramVarArgs)
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
    Object localObject = (bozh)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject != null)
    {
      localObject = ((bozh)localObject).jdField_a_of_type_Bovr.a();
      ykq.b("DoodleLayout", "normal face count:" + localObject[0] + ",location face count:" + localObject[1]);
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
    bovv localbovv;
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localObject = a();
      if ((localObject != null) && (((bovr)localObject).jdField_a_of_type_JavaUtilList != null) && (!((bovr)localObject).jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        localObject = ((bovr)localObject).jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localbovv = (bovv)((Iterator)localObject).next();
          if ((localbovv != null) && (!TextUtils.isEmpty(localbovv.e)))
          {
            localStringBuilder.append(localbovv.e);
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
    if ((localObject != null) && (((bovp)localObject).jdField_a_of_type_JavaUtilList != null) && (!((bovp)localObject).jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      localObject = ((bovp)localObject).jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localbovv = (bovv)((Iterator)localObject).next();
        if ((localbovv != null) && (!TextUtils.isEmpty(localbovv.e)))
        {
          localException.append(localbovv.e);
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
    bowb localbowb = a();
    if (localbowb != null) {
      localbowb.d();
    }
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a() == a());
  }
  
  public boolean c(int paramInt)
  {
    Object localObject = (bozh)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject != null)
    {
      localObject = ((bozh)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (!((bown)((Iterator)localObject).next()).a()) {
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
    ThreadManager.getUIHandler().post(new DoodleLayout.6(this));
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a() == this.jdField_a_of_type_Boik);
  }
  
  public void e()
  {
    b();
    bowb localbowb = a();
    ykq.b("DoodleLayout", "undo, activeLayer:" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a() + ",pathCount:" + localbowb.a.b());
    if (localbowb.d())
    {
      localbowb.e();
      if (localbowb.a.b() == 0) {
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
    ykq.b("DoodleLayout", "onFacePressed, buttonState:" + this.jdField_d_of_type_Int + ",activeLayer:" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a());
    ykw.a("0X80076BA", ykw.jdField_b_of_type_Int);
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
        this.jdField_a_of_type_Boxn.a(false);
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
      this.jdField_a_of_type_Boxn.a(false);
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
      this.jdField_a_of_type_Boxn.a(false);
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
      this.jdField_a_of_type_Boxn.a(false);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a(true);
      }
    }
  }
  
  public void j()
  {
    b();
    ykq.b("DoodleLayout", "onTextPressed, buttonState:" + this.jdField_d_of_type_Int + ",activeLayer:" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a());
    a().d(true);
    DynamicTextItem localDynamicTextItem = a().a(d());
    a(a().a(), false);
    if (localDynamicTextItem != null)
    {
      a(localDynamicTextItem, 0, 0, true);
      return;
    }
    QQToast.a(getContext(), getContext().getString(2131698026), 0).a();
    ThreadManager.getUIHandler().post(new DoodleLayout.9(this));
  }
  
  public void k()
  {
    b();
    ykq.b("DoodleLayout", "onLinePressed, buttonState:" + this.jdField_d_of_type_Int + ",activeLayer:" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a());
    ykw.a("0X80076B8", ykw.jdField_b_of_type_Int);
    bowb localbowb = a();
    b(new View[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout });
    localbowb.d(true);
    t();
    if (localbowb.a.b() > 0)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(true);
      if (this.jdField_d_of_type_Int != 0) {
        break label127;
      }
    }
    for (;;)
    {
      a(2);
      label127:
      do
      {
        return;
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(false);
        break;
        if (this.jdField_d_of_type_Int != 3) {
          break label164;
        }
        a(2);
        this.jdField_a_of_type_Boxn.a(false);
      } while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView == null);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a(true);
      return;
      label164:
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
    if ((this.jdField_d_of_type_Int == 3) && (this.jdField_a_of_type_Boxn != null))
    {
      a(0);
      this.jdField_a_of_type_Boxn.a(false);
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
      bowf localbowf = ((bozh)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(m)).jdField_a_of_type_Bowf;
      localbowf.a(null);
      localbowf.a(null);
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
      localAlphaAnimation.setAnimationListener(new boyv(this));
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.startAnimation(localAlphaAnimation);
      if (this.jdField_a_of_type_Bozc != null) {
        this.jdField_a_of_type_Bozc.b(localAlphaAnimation);
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
      if ((!a(false)) && (this.jdField_a_of_type_Bozd != null)) {
        this.jdField_a_of_type_Bozd.f();
      }
    }
  }
  
  protected void onDetachedFromWindow()
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
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a() == this.jdField_a_of_type_Boik)
    {
      b(7);
      bown localbown = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(paramMotionEvent);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setActiveLayer(localbown);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setTopLevelLayer(localbown);
      localbown.d(paramMotionEvent);
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
    if (this.jdField_a_of_type_Bozd != null) {
      this.jdField_a_of_type_Bozd.e();
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.d();
    }
    e(this.jdField_b_of_type_Boolean);
  }
  
  public void q()
  {
    bpal localbpal = (bpal)a().a(104);
    if (localbpal != null) {
      localbpal.e();
    }
  }
  
  public void r()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.invalidate();
  }
  
  public void s()
  {
    if ((this.jdField_a_of_type_Botf != null) && (this.jdField_a_of_type_Botf.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null))
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.getLayoutParams();
      localLayoutParams.bottomMargin = 0;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setLayoutParams(localLayoutParams);
    }
  }
  
  public void setDoodleBitmapMaxSize(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      ykq.e("DoodleLayout", "width or height is illegal, width=" + paramInt1 + ",height=" + paramInt2);
    }
    for (;;)
    {
      return;
      ykq.b("DoodleLayout", "setDoodleBitmapMaxSize, maxWidth" + paramInt1 + ",maxHeight:" + paramInt2);
      this.jdField_h_of_type_Int = paramInt1;
      this.jdField_i_of_type_Int = paramInt2;
      int m = 0;
      while (m < this.jdField_a_of_type_AndroidUtilSparseArray.size())
      {
        ((bowt)this.jdField_a_of_type_AndroidUtilSparseArray.get(m)).jdField_a_of_type_Int = paramInt1;
        ((bowt)this.jdField_a_of_type_AndroidUtilSparseArray.get(m)).jdField_b_of_type_Int = paramInt2;
        m += 1;
      }
    }
  }
  
  public void setDoodleBtnOperationHelper(bozc parambozc)
  {
    this.jdField_a_of_type_Bozc = parambozc;
  }
  
  public void setDoodleEventListener(bozd parambozd)
  {
    this.jdField_a_of_type_Bozd = parambozd;
  }
  
  @TargetApi(14)
  public void setDoodleGLViewVisibility(int paramInt)
  {
    if (!this.jdField_e_of_type_Boolean) {
      return;
    }
    if (!this.jdField_c_of_type_Boolean)
    {
      ykq.b("DoodleLayout", "setDoodleGLViewVisibility, soload failed, glview default invisible");
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
  
  public void setEditVideoDoodle(botf parambotf)
  {
    this.jdField_a_of_type_Botf = parambotf;
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
      localObject1 = ((bovr)localObject1).jdField_a_of_type_JavaUtilList;
      m = 0;
    }
    for (;;)
    {
      TrackerStickerParam.MotionInfo localMotionInfo;
      float f1;
      if (m < ((List)localObject1).size())
      {
        bovv localbovv = (bovv)((List)localObject1).get(m);
        try
        {
          localMotionInfo = (TrackerStickerParam.MotionInfo)localbovv.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
          if (localMotionInfo == null) {
            break label535;
          }
          if (!localMotionInfo.isLost)
          {
            localbovv.jdField_a_of_type_AndroidGraphicsPointF.set(0.0F, 0.0F);
            localbovv.s = localMotionInfo.x;
            localbovv.t = localMotionInfo.y;
            f1 = localbovv.o;
            localbovv.q = (localMotionInfo.scale * f1);
          }
          else
          {
            localbovv.jdField_a_of_type_AndroidGraphicsPointF.set(-2000.0F, 0.0F);
            localbovv.s = localMotionInfo.x;
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
          localObject1 = ((bovr)localObject1).jdField_a_of_type_JavaUtilList;
          m = 0;
          if (m < ((List)localObject1).size())
          {
            localObject2 = (bovv)((List)localObject1).get(m);
            localMotionInfo = (TrackerStickerParam.MotionInfo)((bovv)localObject2).jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
            if (localMotionInfo != null)
            {
              if (localMotionInfo.isLost) {
                break label332;
              }
              ((bovv)localObject2).jdField_a_of_type_AndroidGraphicsPointF.set(0.0F, 0.0F);
              ((bovv)localObject2).s = localMotionInfo.x;
              ((bovv)localObject2).t = localMotionInfo.y;
              f1 = ((bovv)localObject2).o;
              ((bovv)localObject2).q = (localMotionInfo.scale * f1);
            }
            for (;;)
            {
              m += 1;
              break;
              label332:
              ((bovv)localObject2).jdField_a_of_type_AndroidGraphicsPointF.set(-2000.0F, 0.0F);
              ((bovv)localObject2).s = localMotionInfo.x;
            }
          }
        }
        localObject1 = a();
        if (localObject1 != null)
        {
          localObject1 = ((bowf)localObject1).jdField_a_of_type_JavaUtilArrayList;
          m = n;
          if (m < ((List)localObject1).size())
          {
            localObject2 = (bowi)((List)localObject1).get(m);
            localMotionInfo = (TrackerStickerParam.MotionInfo)((bowi)localObject2).jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
            if (localMotionInfo != null)
            {
              if (localMotionInfo.isLost) {
                break label494;
              }
              ((bowi)localObject2).jdField_a_of_type_AndroidGraphicsPointF.set(0.0F, 0.0F);
              ((bowi)localObject2).s = localMotionInfo.x;
              ((bowi)localObject2).t = localMotionInfo.y;
              f1 = ((bowi)localObject2).o;
              ((bowi)localObject2).q = (localMotionInfo.scale * f1);
            }
            for (;;)
            {
              m += 1;
              break;
              label494:
              ((bowi)localObject2).jdField_a_of_type_AndroidGraphicsPointF.set(-2000.0F, 0.0F);
              ((bowi)localObject2).s = localMotionInfo.x;
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
    if (this.jdField_a_of_type_Bovv == null)
    {
      ykq.e("DoodleLayout", "ClickFaceItem not found.");
      return;
    }
    ykq.b("DoodleLayout", "setLocation: clickItem-->" + this.jdField_a_of_type_Bovv);
    a().a(this.jdField_a_of_type_Bovv, paramTroopBarPOI);
    this.jdField_a_of_type_Bovv = null;
  }
  
  public void setMosaicSize(int paramInt)
  {
    int m = paramInt;
    if (paramInt < 1)
    {
      ykq.e("DoodleLayout", "MosaicSize little than 1.");
      m = 1;
    }
    this.jdField_e_of_type_Int = m;
    paramInt = 0;
    while (paramInt < this.jdField_b_of_type_AndroidUtilSparseArray.size())
    {
      bpal localbpal = (bpal)((bozh)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(paramInt)).jdField_a_of_type_Bowb.a(103);
      if (localbpal != null) {
        localbpal.b(m);
      }
      paramInt += 1;
    }
  }
  
  public void setMosaicStandardSize(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      ykq.e("DoodleLayout", "StandardMosaicSize, width or height <= 0. width:" + paramInt1 + ",height:" + paramInt2);
    }
    for (;;)
    {
      return;
      this.jdField_f_of_type_Int = paramInt1;
      this.jdField_g_of_type_Int = paramInt2;
      int m = 0;
      while (m < this.jdField_b_of_type_AndroidUtilSparseArray.size())
      {
        bpal localbpal = (bpal)((bozh)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(m)).jdField_a_of_type_Bowb.a(103);
        if (localbpal != null) {
          localbpal.b(paramInt1, paramInt2);
        }
        m += 1;
      }
    }
  }
  
  public void setOnTextDialogShowListener(bozm parambozm)
  {
    this.jdField_a_of_type_Bozm = parambozm;
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
  
  public void setTrackerState(bpdg parambpdg, int paramInt)
  {
    if (parambpdg == null) {}
    do
    {
      return;
      parambpdg.jdField_i_of_type_Int = paramInt;
    } while (this.jdField_a_of_type_Bozd == null);
    if (!parambpdg.a())
    {
      float f3 = parambpdg.jdField_a_of_type_AndroidGraphicsPointF.x + parambpdg.s - parambpdg.u / 2.0F;
      float f4 = parambpdg.jdField_a_of_type_AndroidGraphicsPointF.y + parambpdg.t - parambpdg.v / 2.0F;
      float f2 = f4;
      float f1 = f3;
      if (parambpdg.jdField_g_of_type_Boolean)
      {
        f2 = f4;
        f1 = f3;
        if (parambpdg.jdField_h_of_type_Boolean)
        {
          f1 = parambpdg.l + parambpdg.j - parambpdg.u / 2.0F;
          f2 = parambpdg.m + parambpdg.jdField_k_of_type_Float - parambpdg.v / 2.0F;
        }
      }
      this.jdField_a_of_type_Bozd.a(f1, f2, parambpdg.u, parambpdg.v);
      return;
    }
    this.jdField_a_of_type_Bozd.i();
    parambpdg.d();
  }
  
  public void setupPersonality()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)super.findViewById(2131365802));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleTextureView = new DoodleTextureView(super.getContext());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleTextureView, localLayoutParams);
    this.jdField_c_of_type_Boolean = bdee.b();
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
    while ((bpau)((bowb)localObject).a(101) == null) {
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
    for (this.jdField_b_of_type_Int = bphx.a(a());; this.jdField_b_of_type_Int = ((SharedPreferences)localObject).getInt("Line_LastSubType", 0))
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setSelectedStroke(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      return;
      label97:
      this.jdField_a_of_type_Int = ((SharedPreferences)localObject).getInt("Line_LastType", 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout
 * JD-Core Version:    0.7.0.1
 */