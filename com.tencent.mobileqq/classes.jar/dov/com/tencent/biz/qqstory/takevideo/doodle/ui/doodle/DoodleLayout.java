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
import android.support.v4.util.MQLruCache;
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
import axkb;
import axlc;
import bbdr;
import bcpw;
import biht;
import biju;
import bizx;
import bjcd;
import bjck;
import bjgr;
import bjsh;
import bjvb;
import bjvc;
import bjwp;
import bjww;
import bjyl;
import bjzc;
import bjzr;
import bjzs;
import bjzt;
import bjzx;
import bkaa;
import bkab;
import bkac;
import bkad;
import bkae;
import bkaf;
import bkah;
import bkai;
import bkaj;
import bkam;
import bkar;
import bkat;
import bkav;
import bkay;
import bkbb;
import bkbd;
import bkbv;
import bkdc;
import bkdd;
import bkde;
import bkdf;
import bkdg;
import bkdh;
import bkdi;
import bkdj;
import bkdk;
import bkdl;
import bkdm;
import bkdn;
import bkdo;
import bkdp;
import bkdr;
import bkds;
import bkdt;
import bkdw;
import bkdx;
import bkdy;
import bkdz;
import bkea;
import bkeb;
import bkec;
import bkef;
import bkex;
import bkfc;
import bkfg;
import bkfq;
import bkhu;
import bkhw;
import bkok;
import bkur;
import blbz;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam.MotionInfo;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.qq.im.capture.text.DynamicTextItem.TextMap;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalGifSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.StoryGuideLineView;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
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
import org.json.JSONObject;
import veg;
import vel;
import vem;

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
  public SparseArray<bkbb> a;
  public SparseBooleanArray a;
  public FrameLayout a;
  public ImageView a;
  public RelativeLayout a;
  protected bjcd a;
  private bjck jdField_a_of_type_Bjck;
  bjgr jdField_a_of_type_Bjgr = new bjgr();
  private bjvc jdField_a_of_type_Bjvc;
  public bjzx a;
  public bkac a;
  public bkad a;
  public bkar a;
  public bkbv a;
  public bkdn a;
  public bkdo a;
  public bkdp a;
  private bkdx jdField_a_of_type_Bkdx;
  private bkdz jdField_a_of_type_Bkdz;
  public bkea a;
  private bkec jdField_a_of_type_Bkec = new bkec(this, null);
  public EditVideoParams a;
  public DoodleEditView a;
  public DoodleTextureView a;
  public DoodleView a;
  private StoryGuideLineView jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView;
  public HorizontalSelectColorLayout a;
  private RuntimeException jdField_a_of_type_JavaLangRuntimeException;
  private Comparator<bkav> jdField_a_of_type_JavaUtilComparator = new bkdc(this);
  private List<Long> jdField_a_of_type_JavaUtilList;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  private final Condition jdField_a_of_type_JavaUtilConcurrentLocksCondition = this.jdField_a_of_type_JavaUtilConcurrentLocksLock.newCondition();
  private final Lock jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  public int b;
  private long b;
  public SparseArray<bkds> b;
  public SparseBooleanArray b;
  public DoodleView b;
  public boolean b;
  public int c;
  private long c;
  public boolean c;
  public int d;
  private long jdField_d_of_type_Long;
  private boolean jdField_d_of_type_Boolean;
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
  private boolean jdField_j_of_type_Boolean;
  private int jdField_k_of_type_Int;
  private boolean jdField_k_of_type_Boolean = true;
  private int jdField_l_of_type_Int = -1;
  private boolean jdField_l_of_type_Boolean;
  private boolean m;
  
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
    this.jdField_a_of_type_Bkea = new bkea(this, null);
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    LayoutInflater.from(super.getContext()).inflate(2131558997, this);
    y();
    d(this.jdField_c_of_type_Int);
    e(this.jdField_c_of_type_Int);
    this.jdField_j_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  private void A()
  {
    bkhw localbkhw;
    Object localObject;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b())
    {
      localbkhw = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.a();
      localbkhw.jdField_k_of_type_Boolean = false;
      if (!(localbkhw instanceof bjzx)) {
        break label118;
      }
      localObject = a();
      if (((((bjzx)localbkhw).jdField_h_of_type_Int != 1) && (((bjzx)localbkhw).jdField_h_of_type_Int != 3)) || ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()))) {
        break label147;
      }
      localObject = a();
      ((bjzx)localbkhw).jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
    }
    label147:
    for (;;)
    {
      if (localObject != null) {}
      label118:
      do
      {
        ((bjzt)localObject).jdField_a_of_type_JavaUtilList.add((bjzx)localbkhw);
        do
        {
          return;
        } while (!(localbkhw instanceof bkam));
        localObject = a();
      } while (localObject == null);
      ((bkaj)localObject).jdField_a_of_type_JavaUtilArrayList.add((bkam)localbkhw);
      return;
    }
  }
  
  private void B()
  {
    boolean bool3 = false;
    AppInterface localAppInterface = null;
    if ((super.getContext() instanceof QQStoryBaseActivity)) {
      localAppInterface = ((QQStoryBaseActivity)super.getContext()).a;
    }
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) || (!(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalGifSource))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool3;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null)
      {
        bool2 = bool3;
        if (!bjww.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Long, 262144))
        {
          bool2 = bool3;
          if (!VideoEnvironment.c())
          {
            bool2 = bool3;
            if (biht.b()) {
              bool2 = true;
            }
          }
        }
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setStrokeStrategy(new bkok(localAppInterface, bool1, bool2), true, 2);
      x();
      return;
    }
  }
  
  private void a(long paramLong)
  {
    SegmentKeeper.adjustTime(-1L * paramLong);
  }
  
  private void a(bkhw parambkhw)
  {
    if (parambkhw != null)
    {
      if (!(parambkhw instanceof bkae)) {
        break label29;
      }
      a((bkae)parambkhw);
      veg.b("DoodleLayout", "delete interact item from edit layer.");
    }
    label29:
    while (!(parambkhw instanceof bkat)) {
      return;
    }
    a((bkat)parambkhw);
    veg.b("DoodleLayout", "delete vote item from edit layer.");
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
    vel.a("video_edit", paramString, paramInt1, paramInt2, paramVarArgs);
  }
  
  private boolean a(boolean paramBoolean)
  {
    c();
    veg.b("DoodleLayout", "onBackPressed, buttonState:" + this.jdField_d_of_type_Int + ",activeLayer:" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a());
    if ((this.jdField_d_of_type_Int == 0) || ((this.jdField_d_of_type_Int == 2) && (!paramBoolean))) {
      return false;
    }
    n();
    c(0);
    if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.b())
    {
      veg.b("DoodleLayout", "onBackPressed, resetDoodleView.");
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.f();
    }
    return true;
  }
  
  private void d(int paramInt)
  {
    if (this.jdField_a_of_type_Bkac == null) {
      this.jdField_a_of_type_Bkac = new bkac(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
    }
    Object localObject1 = (bkds)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    localObject1 = (bkbb)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    int n;
    if (localObject1 == null)
    {
      veg.b("DoodleLayout", "initDoodleView for the %d video", Integer.valueOf(paramInt));
      Object localObject4 = a();
      localObject1 = (bjzt)((bkdw)localObject4).a(bjzt.jdField_a_of_type_JavaLangString);
      bjzr localbjzr = (bjzr)((bkdw)localObject4).a("DynamicFaceLayer");
      Object localObject2 = (bkaf)((bkdw)localObject4).a("LineLayer");
      bkaj localbkaj = (bkaj)((bkdw)localObject4).a(bkaj.jdField_a_of_type_JavaLangString);
      Object localObject3 = (bkac)((bkdw)localObject4).a("GuideLineLayer");
      if (localObject2 != null)
      {
        bkex localbkex = (bkex)((bkaf)localObject2).a(103);
        if ((localbkex != null) && (this.jdField_e_of_type_Int != -1)) {
          localbkex.b(this.jdField_e_of_type_Int);
        }
        if ((localbkex != null) && (this.jdField_f_of_type_Int != -1) && (this.jdField_g_of_type_Int != -1)) {
          localbkex.b(this.jdField_f_of_type_Int, this.jdField_g_of_type_Int);
        }
      }
      localObject4 = new bkbd().a((bkay)localObject4);
      if (this.jdField_h_of_type_Int != -1)
      {
        n = this.jdField_h_of_type_Int;
        localObject4 = ((bkbd)localObject4).a(n);
        if (this.jdField_i_of_type_Int == -1) {
          break label516;
        }
        n = this.jdField_i_of_type_Int;
        label254:
        localObject4 = ((bkbd)localObject4).b(n).a();
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setDoodleConfig((bkbb)localObject4);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setDoodleLayout(this);
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null)
        {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
        }
        localObject3 = new bkds(localbkaj, (bkaf)localObject2, (bjzt)localObject1, localbjzr, (bkac)localObject3, (bjzs)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(bjzs.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject4);
        this.jdField_b_of_type_AndroidUtilSparseArray.put(paramInt, localObject3);
        if (localObject2 != null)
        {
          ((bkaf)localObject2).a(new bkdt(this, null));
          ((bkaf)localObject2).a(new bkdk(this));
        }
        if (localObject1 != null) {
          ((bjzt)localObject1).a(this.jdField_a_of_type_Bkea);
        }
        if (localbjzr != null) {
          localbjzr.a(this.jdField_a_of_type_Bkea);
        }
        localObject2 = new bkdl(this);
        if (localObject1 != null) {
          ((bjzt)localObject1).a((bkaa)localObject2);
        }
        if (localbjzr != null) {
          localbjzr.a((bkaa)localObject2);
        }
        if (!this.jdField_d_of_type_Boolean)
        {
          localbkaj.a(this.jdField_a_of_type_Bkea);
          localbkaj.a(new bkeb(this, null));
        }
        this.jdField_a_of_type_Bjck = ((bjck)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a("PickLayer"));
      }
    }
    for (;;)
    {
      z();
      this.jdField_f_of_type_Boolean = false;
      return;
      n = 480;
      break;
      label516:
      n = 640;
      break label254;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setDoodleConfig((bkbb)localObject1);
    }
  }
  
  private void e(int paramInt)
  {
    this.jdField_a_of_type_Bkar = new bkar(this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
    this.jdField_a_of_type_Bkad = new bkad(this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
    Object localObject = new bkdm(this);
    localObject = new bkbd().a((bkay)localObject);
    if (this.jdField_h_of_type_Int != -1)
    {
      paramInt = this.jdField_h_of_type_Int;
      localObject = ((bkbd)localObject).a(paramInt);
      if (this.jdField_i_of_type_Int == -1) {
        break label168;
      }
    }
    label168:
    for (paramInt = this.jdField_i_of_type_Int;; paramInt = 640)
    {
      localObject = ((bkbd)localObject).b(paramInt).a();
      this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setDoodleConfig((bkbb)localObject);
      this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setDoodleLayout(this);
      this.jdField_a_of_type_Bkar.a(this.jdField_a_of_type_Bkec);
      this.jdField_a_of_type_Bkar.a(new bkdd(this));
      this.jdField_a_of_type_Bkad.a(this.jdField_a_of_type_Bkec);
      this.jdField_a_of_type_Bkad.a(new bkde(this));
      return;
      paramInt = 480;
      break;
    }
  }
  
  private void e(boolean paramBoolean)
  {
    if (!this.jdField_k_of_type_Boolean) {}
    while (this.jdField_l_of_type_Boolean == paramBoolean) {
      return;
    }
    this.jdField_l_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      veg.b("DoodleLayout", "rubbish active.");
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(getResources().getColor(2131166215));
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845885);
      return;
    }
    veg.b("DoodleLayout", "rubbish unActive.");
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(getResources().getColor(2131166216));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845885);
  }
  
  private void f(int paramInt)
  {
    Object localObject = a(this.jdField_c_of_type_Int);
    if (localObject != null)
    {
      localObject = ((bkds)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        bkav localbkav = (bkav)((Iterator)localObject).next();
        if (localbkav != null) {
          localbkav.a(paramInt);
        }
      }
    }
  }
  
  private static void f(boolean paramBoolean)
  {
    if (paramBoolean) {
      bjzc.a().a();
    }
  }
  
  private void y()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131375551));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131368681));
    if (bkur.f()) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, bkur.a(), 0, 0);
    }
    this.jdField_a_of_type_Bjcd = new bkdr(this, null);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout = ((HorizontalSelectColorLayout)super.findViewById(2131370770));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setOnUndoViewClickListener(new bkdg(this));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setOnStrokeSelectedListener(new bkdh(this));
    View localView = super.findViewById(2131363370);
    if (localView != null) {
      localView.setVisibility(0);
    }
    B();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView = ((DoodleView)super.findViewById(2131365309));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView = ((DoodleEditView)super.findViewById(2131365310));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setDoodleLayout(this);
    setOnTextDialogShowListener(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setOnLayerTouchListener();
    this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView = ((DoodleView)super.findViewById(2131365316));
    n();
  }
  
  private void z()
  {
    bkaf localbkaf = a();
    if ((localbkaf != null) && (this.jdField_e_of_type_Boolean))
    {
      localbkaf.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleTextureView);
      localbkaf.a.a(new bkdi(this));
      if (this.jdField_e_of_type_Boolean)
      {
        ((bkfc)localbkaf.a.a(102)).a(false);
        localbkaf.a.a(new bkdj(this));
        localbkaf.c();
      }
    }
  }
  
  protected int a()
  {
    return blbz.a(65.0F);
  }
  
  public int a(int paramInt)
  {
    bkds localbkds = (bkds)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localbkds != null)
    {
      paramInt = localbkds.jdField_a_of_type_Bkaj.b();
      int n = localbkds.jdField_a_of_type_Bkaf.b();
      int i1 = localbkds.jdField_a_of_type_Bjzt.b();
      int i2 = localbkds.jdField_a_of_type_Bjzr.b();
      veg.b("DoodleLayout", "DoodleCount: text->" + paramInt + ",line->" + n + ",face->" + i1 + " " + i2);
      return i2 + (paramInt + n + i1);
    }
    return 0;
  }
  
  public Bitmap a()
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a();
  }
  
  public Bitmap a(int paramInt)
  {
    bkds localbkds = (bkds)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localbkds != null) {
      return localbkds.jdField_a_of_type_Bkaf.a();
    }
    return null;
  }
  
  /* Error */
  public Bitmap a(int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 231	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView	Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleView;
    //   4: invokevirtual 776	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleView:b	()I
    //   7: istore_3
    //   8: aload_0
    //   9: getfield 231	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView	Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleView;
    //   12: invokevirtual 778	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleView:c	()I
    //   15: istore 4
    //   17: iload_3
    //   18: ifle +8 -> 26
    //   21: iload 4
    //   23: ifgt +33 -> 56
    //   26: ldc_w 343
    //   29: ldc_w 780
    //   32: iconst_2
    //   33: anewarray 782	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: iload_3
    //   39: invokestatic 455	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   42: aastore
    //   43: dup
    //   44: iconst_1
    //   45: iload 4
    //   47: invokestatic 455	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   50: aastore
    //   51: invokestatic 785	veg:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   54: aconst_null
    //   55: areturn
    //   56: aload_0
    //   57: getfield 109	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   60: iconst_0
    //   61: invokevirtual 788	java/util/concurrent/atomic/AtomicBoolean:getAndSet	(Z)Z
    //   64: ifeq +16 -> 80
    //   67: aload_0
    //   68: iload_3
    //   69: iload 4
    //   71: getstatic 794	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   74: invokestatic 800	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   77: putfield 802	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   80: aload_0
    //   81: getfield 114	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   84: invokeinterface 805 1 0
    //   89: aload_0
    //   90: getfield 802	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   93: astore 9
    //   95: aload 9
    //   97: ifnonnull +123 -> 220
    //   100: ldc_w 343
    //   103: ldc_w 807
    //   106: invokestatic 809	veg:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   109: aload_0
    //   110: getfield 122	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaUtilConcurrentLocksCondition	Ljava/util/concurrent/locks/Condition;
    //   113: ldc2_w 810
    //   116: getstatic 817	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   119: invokeinterface 823 4 0
    //   124: ifne -35 -> 89
    //   127: ldc_w 343
    //   130: ldc_w 825
    //   133: iconst_1
    //   134: anewarray 782	java/lang/Object
    //   137: dup
    //   138: iconst_0
    //   139: invokestatic 831	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   142: invokevirtual 835	java/lang/Thread:getId	()J
    //   145: invokestatic 840	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   148: aastore
    //   149: invokestatic 842	veg:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   152: aload_0
    //   153: getfield 844	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaLangRuntimeException	Ljava/lang/RuntimeException;
    //   156: ifnull -67 -> 89
    //   159: ldc_w 343
    //   162: ldc_w 846
    //   165: aload_0
    //   166: getfield 844	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaLangRuntimeException	Ljava/lang/RuntimeException;
    //   169: invokestatic 849	veg:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   172: goto -83 -> 89
    //   175: astore 9
    //   177: ldc_w 343
    //   180: ldc_w 851
    //   183: aload 9
    //   185: invokestatic 849	veg:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   188: goto -99 -> 89
    //   191: astore 9
    //   193: aload_0
    //   194: getfield 114	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   197: invokeinterface 854 1 0
    //   202: aload 9
    //   204: athrow
    //   205: astore 9
    //   207: ldc_w 343
    //   210: ldc_w 856
    //   213: aload 9
    //   215: invokestatic 858	veg:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   218: aconst_null
    //   219: areturn
    //   220: aload_0
    //   221: getfield 802	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   224: astore 9
    //   226: aload_0
    //   227: aconst_null
    //   228: putfield 802	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   231: new 860	android/graphics/Canvas
    //   234: dup
    //   235: aload 9
    //   237: invokespecial 863	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   240: astore 10
    //   242: new 865	android/graphics/Paint
    //   245: dup
    //   246: invokespecial 866	android/graphics/Paint:<init>	()V
    //   249: astore 11
    //   251: aload 11
    //   253: new 868	android/graphics/PorterDuffXfermode
    //   256: dup
    //   257: getstatic 874	android/graphics/PorterDuff$Mode:CLEAR	Landroid/graphics/PorterDuff$Mode;
    //   260: invokespecial 877	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   263: invokevirtual 881	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   266: pop
    //   267: aload 10
    //   269: aload 11
    //   271: invokevirtual 885	android/graphics/Canvas:drawPaint	(Landroid/graphics/Paint;)V
    //   274: aload_0
    //   275: getfield 88	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   278: iload_1
    //   279: invokevirtual 443	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   282: checkcast 445	bkds
    //   285: astore 11
    //   287: aload 11
    //   289: ifnonnull +35 -> 324
    //   292: ldc_w 343
    //   295: ldc_w 887
    //   298: iconst_1
    //   299: anewarray 782	java/lang/Object
    //   302: dup
    //   303: iconst_0
    //   304: iload_1
    //   305: invokestatic 455	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   308: aastore
    //   309: invokestatic 785	veg:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   312: aload_0
    //   313: getfield 114	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   316: invokeinterface 854 1 0
    //   321: aload 9
    //   323: areturn
    //   324: invokestatic 892	android/os/SystemClock:uptimeMillis	()J
    //   327: lstore 5
    //   329: aload 11
    //   331: getfield 748	bkds:jdField_a_of_type_Bkaf	Lbkaf;
    //   334: astore 12
    //   336: aload 12
    //   338: getfield 717	bkaf:a	Lbkef;
    //   341: invokevirtual 894	bkef:a	()Z
    //   344: ifeq +142 -> 486
    //   347: ldc_w 343
    //   350: ldc_w 896
    //   353: invokestatic 809	veg:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   356: aload_0
    //   357: getfield 709	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_e_of_type_Boolean	Z
    //   360: ifeq +117 -> 477
    //   363: aload_0
    //   364: getfield 220	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams;
    //   367: ifnull +110 -> 477
    //   370: aload_0
    //   371: getfield 220	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams;
    //   374: getfield 897	dov/com/tencent/biz/qqstory/takevideo/EditVideoParams:jdField_a_of_type_Int	I
    //   377: iconst_1
    //   378: if_icmpne +99 -> 477
    //   381: aload 12
    //   383: getfield 717	bkaf:a	Lbkef;
    //   386: invokevirtual 898	bkef:b	()Z
    //   389: ifeq +88 -> 477
    //   392: iconst_1
    //   393: newarray int
    //   395: astore 13
    //   397: aload 13
    //   399: iconst_0
    //   400: iconst_0
    //   401: iastore
    //   402: iconst_5
    //   403: istore_1
    //   404: aload 12
    //   406: getfield 717	bkaf:a	Lbkef;
    //   409: new 900	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout$13
    //   412: dup
    //   413: aload_0
    //   414: aload 12
    //   416: iload_3
    //   417: aload 13
    //   419: invokespecial 903	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout$13:<init>	(Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout;Lbkaf;I[I)V
    //   422: invokevirtual 906	bkef:a	(Ljava/lang/Runnable;)V
    //   425: aload 13
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
    //   443: ldc2_w 810
    //   446: invokestatic 909	java/lang/Thread:sleep	(J)V
    //   449: ldc_w 343
    //   452: ldc_w 911
    //   455: iload_3
    //   456: invokestatic 455	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   459: invokestatic 458	veg:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   462: iload_3
    //   463: istore_1
    //   464: goto -39 -> 425
    //   467: astore 14
    //   469: aload 14
    //   471: invokevirtual 914	java/lang/InterruptedException:printStackTrace	()V
    //   474: goto -25 -> 449
    //   477: aload 12
    //   479: getfield 717	bkaf:a	Lbkef;
    //   482: iload_3
    //   483: invokevirtual 915	bkef:b	(I)V
    //   486: aload_0
    //   487: getfield 220	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams;
    //   490: ifnull +20 -> 510
    //   493: aload_0
    //   494: getfield 220	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams;
    //   497: invokevirtual 916	dov/com/tencent/biz/qqstory/takevideo/EditVideoParams:a	()Z
    //   500: ifeq +10 -> 510
    //   503: aload 12
    //   505: aload 10
    //   507: invokevirtual 919	bkaf:c	(Landroid/graphics/Canvas;)V
    //   510: aload_0
    //   511: getfield 317	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_Bjvc	Lbjvc;
    //   514: getfield 924	bjvc:a	Lbjww;
    //   517: invokevirtual 926	bjww:c	()J
    //   520: lstore 7
    //   522: lload 7
    //   524: lconst_0
    //   525: lcmp
    //   526: ifeq +33 -> 559
    //   529: iload_2
    //   530: ifeq +29 -> 559
    //   533: aload_0
    //   534: getfield 317	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_Bjvc	Lbjvc;
    //   537: lload 7
    //   539: invokevirtual 928	bjvc:a	(J)V
    //   542: aload_0
    //   543: getfield 317	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_Bjvc	Lbjvc;
    //   546: invokevirtual 931	bjvc:a	()Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout;
    //   549: lload 7
    //   551: ldc2_w 932
    //   554: ldiv
    //   555: iconst_0
    //   556: invokevirtual 937	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:setTimeStamp	(JZ)V
    //   559: new 939	java/util/LinkedList
    //   562: dup
    //   563: aload 11
    //   565: getfield 627	bkds:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   568: invokespecial 942	java/util/LinkedList:<init>	(Ljava/util/Collection;)V
    //   571: astore 11
    //   573: aload 11
    //   575: aload_0
    //   576: getfield 138	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaUtilComparator	Ljava/util/Comparator;
    //   579: invokestatic 948	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   582: aload 11
    //   584: invokevirtual 951	java/util/LinkedList:size	()I
    //   587: iconst_1
    //   588: isub
    //   589: istore_1
    //   590: iload_1
    //   591: iflt +35 -> 626
    //   594: aload 11
    //   596: iload_1
    //   597: invokevirtual 952	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   600: checkcast 642	bkav
    //   603: astore 12
    //   605: aload 12
    //   607: ifnull +119 -> 726
    //   610: aload 12
    //   612: aload 10
    //   614: aload 12
    //   616: invokevirtual 955	bkav:a	()F
    //   619: iload_2
    //   620: invokevirtual 958	bkav:a	(Landroid/graphics/Canvas;FZ)V
    //   623: goto +103 -> 726
    //   626: iload_2
    //   627: ifeq +49 -> 676
    //   630: aload 11
    //   632: invokevirtual 951	java/util/LinkedList:size	()I
    //   635: iconst_1
    //   636: isub
    //   637: istore_1
    //   638: iload_1
    //   639: iflt +37 -> 676
    //   642: aload 11
    //   644: iload_1
    //   645: invokevirtual 952	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   648: checkcast 642	bkav
    //   651: astore 12
    //   653: aload 12
    //   655: ifnull +64 -> 719
    //   658: aload 12
    //   660: instanceof 473
    //   663: ifeq +56 -> 719
    //   666: aload 12
    //   668: checkcast 473	bjzr
    //   671: aload 10
    //   673: invokevirtual 959	bjzr:c	(Landroid/graphics/Canvas;)V
    //   676: ldc_w 343
    //   679: new 395	java/lang/StringBuilder
    //   682: dup
    //   683: invokespecial 396	java/lang/StringBuilder:<init>	()V
    //   686: ldc_w 961
    //   689: invokevirtual 402	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: invokestatic 892	android/os/SystemClock:uptimeMillis	()J
    //   695: lload 5
    //   697: lsub
    //   698: invokevirtual 964	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   701: invokevirtual 419	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   704: invokestatic 350	veg:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   707: aload_0
    //   708: getfield 114	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   711: invokeinterface 854 1 0
    //   716: aload 9
    //   718: areturn
    //   719: iload_1
    //   720: iconst_1
    //   721: isub
    //   722: istore_1
    //   723: goto -85 -> 638
    //   726: iload_1
    //   727: iconst_1
    //   728: isub
    //   729: istore_1
    //   730: goto -140 -> 590
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	733	0	this	DoodleLayout
    //   0	733	1	paramInt	int
    //   0	733	2	paramBoolean	boolean
    //   7	476	3	n	int
    //   15	55	4	i1	int
    //   327	369	5	l1	long
    //   520	30	7	l2	long
    //   93	3	9	localBitmap1	Bitmap
    //   175	9	9	localInterruptedException1	java.lang.InterruptedException
    //   191	12	9	localObject1	Object
    //   205	9	9	localOutOfMemoryError	OutOfMemoryError
    //   224	493	9	localBitmap2	Bitmap
    //   240	432	10	localCanvas	android.graphics.Canvas
    //   249	394	11	localObject2	Object
    //   334	333	12	localObject3	Object
    //   395	31	13	arrayOfInt	int[]
    //   467	3	14	localInterruptedException2	java.lang.InterruptedException
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
    //   510	522	191	finally
    //   533	559	191	finally
    //   559	590	191	finally
    //   594	605	191	finally
    //   610	623	191	finally
    //   630	638	191	finally
    //   642	653	191	finally
    //   658	676	191	finally
    //   676	707	191	finally
    //   67	80	205	java/lang/OutOfMemoryError
    //   443	449	467	java/lang/InterruptedException
  }
  
  public bjcd a()
  {
    return this.jdField_a_of_type_Bjcd;
  }
  
  public bjzr a()
  {
    bkds localbkds = (bkds)this.jdField_b_of_type_AndroidUtilSparseArray.get(this.jdField_c_of_type_Int);
    if (localbkds == null)
    {
      veg.d("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int) });
      return null;
    }
    return localbkds.jdField_a_of_type_Bjzr;
  }
  
  public bjzs a()
  {
    bkds localbkds = (bkds)this.jdField_b_of_type_AndroidUtilSparseArray.get(this.jdField_c_of_type_Int);
    if (localbkds == null)
    {
      veg.d("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int) });
      return null;
    }
    return localbkds.jdField_a_of_type_Bjzs;
  }
  
  public bjzt a()
  {
    bkds localbkds = (bkds)this.jdField_b_of_type_AndroidUtilSparseArray.get(this.jdField_c_of_type_Int);
    if (localbkds == null)
    {
      veg.d("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int) });
      return null;
    }
    return localbkds.jdField_a_of_type_Bjzt;
  }
  
  public bkad a()
  {
    return this.jdField_a_of_type_Bkad;
  }
  
  public bkaf a()
  {
    bkds localbkds = (bkds)this.jdField_b_of_type_AndroidUtilSparseArray.get(this.jdField_c_of_type_Int);
    if (localbkds == null)
    {
      veg.d("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int) });
      return null;
    }
    return localbkds.jdField_a_of_type_Bkaf;
  }
  
  public bkaj a()
  {
    bkds localbkds = (bkds)this.jdField_b_of_type_AndroidUtilSparseArray.get(this.jdField_c_of_type_Int);
    if (localbkds == null)
    {
      veg.d("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int) });
      return null;
    }
    return localbkds.jdField_a_of_type_Bkaj;
  }
  
  public bkar a()
  {
    return this.jdField_a_of_type_Bkar;
  }
  
  public bkds a(int paramInt)
  {
    return (bkds)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  protected bkdw a()
  {
    return new bkdw(new bkav[] { this.jdField_a_of_type_Bkac, new bjck(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView), new bjzt(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView), new bjzr(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView), new bkaf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView), new bkaj(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView) });
  }
  
  public String a()
  {
    Object localObject2 = "";
    Object localObject3 = a();
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (((bkaj)localObject3).jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject1 = localObject2;
        if (!((bkaj)localObject3).jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          localObject1 = new JSONArray();
          localObject2 = ((bkaj)localObject3).jdField_a_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (bkam)((Iterator)localObject2).next();
            if ((((bkam)localObject3).jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null) && (((bkam)localObject3).jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a() != null)) {
              ((JSONArray)localObject1).put(((bkam)localObject3).jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a().toString());
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
    Object localObject = (bkds)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject == null)
    {
      veg.d("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(paramInt) });
      return null;
    }
    localObject = ((bkds)localObject).jdField_a_of_type_Bkaj;
    if ((((bkaj)localObject).jdField_a_of_type_JavaUtilArrayList != null) && (!((bkaj)localObject).jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      localObject = ((bkaj)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        bkam localbkam = (bkam)((Iterator)localObject).next();
        if (localbkam.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null)
        {
          localObject = localbkam.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a().toString();
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
      localObject1 = ((bjzt)localObject1).a();
      if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
      {
        localObject2 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          TrackerStickerParam localTrackerStickerParam = (TrackerStickerParam)((Iterator)localObject2).next();
          if (localTrackerStickerParam.mSegmentKeeper != null) {
            localTrackerStickerParam.mSegmentKeeper.setAdjustTimeValid(false);
          }
        }
        localArrayList.addAll((Collection)localObject1);
      }
    }
    localObject1 = a();
    if (localObject1 != null)
    {
      paramString = ((bkaj)localObject1).a(paramString);
      if ((paramString != null) && (!paramString.isEmpty()))
      {
        localObject1 = paramString.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (TrackerStickerParam)((Iterator)localObject1).next();
          if (((TrackerStickerParam)localObject2).mSegmentKeeper != null) {
            ((TrackerStickerParam)localObject2).mSegmentKeeper.setAdjustTimeValid(false);
          }
        }
        localArrayList.addAll(paramString);
      }
    }
    return TrackerStickerParam.ToJsonString(localArrayList);
  }
  
  public List<String> a(int paramInt)
  {
    Object localObject = (bkds)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject != null)
    {
      localObject = ((bkds)localObject).jdField_a_of_type_Bkaf.a.b();
      StringBuilder localStringBuilder = new StringBuilder().append("image doodle type count:");
      if ((localObject == null) || (((List)localObject).isEmpty())) {}
      for (paramInt = 0;; paramInt = ((List)localObject).size())
      {
        veg.b("DoodleLayout", paramInt);
        return localObject;
      }
    }
    return Collections.emptyList();
  }
  
  public Map<String, List<String>> a(int paramInt)
  {
    Object localObject = (bkds)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject != null)
    {
      localObject = ((bkds)localObject).jdField_a_of_type_Bjzt.jdField_a_of_type_JavaUtilMap;
      veg.b("DoodleLayout", "Using face map:" + localObject.toString());
      return Collections.unmodifiableMap((Map)localObject);
    }
    return Collections.emptyMap();
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView != null) {
        return;
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView = ((StoryGuideLineView)findViewById(2131371295));
      Object localObject1 = "";
      Object localObject2 = axkb.a().a("CMD_GET_CURRENT_NICK_NAME", null);
      if (localObject2 != null) {
        localObject1 = ((Bundle)localObject2).getString("VALUE_GET_CURRENT_NICK_NAME");
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.setUserName((String)localObject1);
      localObject1 = "";
      localObject2 = axkb.a().a("CMD_GET_CURRENT_USER_HEAD", null);
      if (localObject2 != null) {
        localObject1 = ((Bundle)localObject2).getString("VALUE_GET_CURRENT_USER_HEAD");
      }
      try
      {
        localObject1 = SafeBitmapFactory.decodeFile((String)localObject1);
        localObject2 = bbdr.c((Bitmap)localObject1, 50, 50);
        BaseApplicationImpl.sImageCache.put("story_user_avatar", localObject2);
        ((Bitmap)localObject1).recycle();
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.setUserHead((Bitmap)localObject2);
        return;
      }
      catch (Exception localException1)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      QLog.d("DoodleLayout", 2, "user Head Path can't read");
      return;
    }
    catch (Exception localException2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoodleLayout", 2, "makeSureInitLayout error : " + localException2.getMessage());
      }
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    if (this.jdField_a_of_type_Bkdo != null) {
      this.jdField_a_of_type_Bkdo.a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
    }
  }
  
  public void a(int paramInt)
  {
    veg.b("DoodleLayout", "changeVideoIndex from %d to %d", Integer.valueOf(this.jdField_c_of_type_Int), Integer.valueOf(paramInt));
    this.jdField_c_of_type_Int = paramInt;
    d(paramInt);
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
    veg.b("DoodleLayout", String.format("changeDoodleViewSize, width: %d, height: %d ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    setDoodleBitmapMaxSize(paramInt1, paramInt2);
    int n = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.getWidth();
    int i1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.getHeight();
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = paramInt1;
    ((RelativeLayout.LayoutParams)localObject).height = paramInt2;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (!paramBoolean) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.g();
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.h();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.onSizeChanged(paramInt1, paramInt2, n, i1);
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a(paramInt1, paramInt2);
    }
    localObject = (bkex)a().a(104);
    if (localObject != null) {
      ((bkex)localObject).e();
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
    if (this.jdField_a_of_type_Bkdo != null) {
      this.jdField_a_of_type_Bkdo.b(paramInt, paramObject);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    c();
    veg.b("DoodleLayout", "addNewSticker, buttonState:" + this.jdField_d_of_type_Int + ",activeLayer:" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a());
    bkaj localbkaj = a();
    paramString = this.jdField_a_of_type_Bjgr.a(paramInt, Arrays.asList(new String[] { paramString }));
    a().a(d());
    a().b(paramString);
    localbkaj.d(true);
    a().b(4);
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
  
  public void a(bjzx parambjzx)
  {
    this.jdField_a_of_type_Bjzx = parambjzx;
    if (this.jdField_a_of_type_Bkdo != null)
    {
      veg.b("DoodleLayout", "selectLocation: clickItem-->" + parambjzx.toString());
      this.jdField_a_of_type_Bkdo.b(this.jdField_a_of_type_Bjzx.a());
    }
  }
  
  public void a(bkae parambkae)
  {
    a().a();
  }
  
  public void a(bkae parambkae, float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_Bjvc != null)
    {
      bjsh localbjsh = (bjsh)this.jdField_a_of_type_Bjvc.a(bjsh.class);
      if (localbjsh != null) {
        localbjsh.a(parambkae, paramFloat1, paramFloat2);
      }
    }
    a().e();
  }
  
  public void a(bkat parambkat)
  {
    a().a();
  }
  
  public void a(bkat parambkat, float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_Bjvc != null)
    {
      bjyl localbjyl = (bjyl)this.jdField_a_of_type_Bjvc.a(bjyl.class);
      if (localbjyl != null) {
        localbjyl.a(parambkat, paramFloat1, paramFloat2);
      }
    }
    a().e();
  }
  
  public void a(bkfq parambkfq, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    a(parambkfq, paramFloat1, paramFloat2, paramFloat3, null);
  }
  
  public void a(bkfq parambkfq, float paramFloat1, float paramFloat2, float paramFloat3, SegmentKeeper paramSegmentKeeper)
  {
    c();
    if (parambkfq == null) {
      veg.e("DoodleLayout", "the item is null.");
    }
    for (;;)
    {
      return;
      veg.b("DoodleLayout", "addLocationFaceItem:" + parambkfq.toString());
      bkab localbkab = bkhu.a(parambkfq, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.getWidth(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.getHeight(), paramFloat1, paramFloat2, paramFloat3);
      File localFile;
      Object localObject;
      if (localbkab != null)
      {
        if ((parambkfq.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) || (!(parambkfq.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof URLDrawable))) {
          break label231;
        }
        localFile = ((URLDrawable)parambkfq.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getFileInLocal();
        if ((localFile == null) || (!localFile.exists())) {
          break label231;
        }
        localObject = a();
        if (((parambkfq.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null)) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b())) {
          localObject = a();
        }
      }
      label231:
      for (boolean bool = ((bjzt)localObject).a(parambkfq.g, parambkfq.c, parambkfq.jdField_a_of_type_AndroidGraphicsDrawableDrawable, localbkab, localFile.getAbsolutePath(), true, parambkfq.jdField_a_of_type_Int, d(), paramSegmentKeeper); bool; bool = false)
      {
        this.jdField_a_of_type_Bkdo.a(parambkfq);
        vem.a("0X80076CE");
        f(this.jdField_b_of_type_Boolean);
        return;
        veg.e("DoodleLayout", "create FaceLayer.ItemParams failed.");
        return;
      }
    }
  }
  
  public void a(DynamicTextItem paramDynamicTextItem, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a()) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle.getBoolean("key_enable_edit_title_bar"))) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramDynamicTextItem, paramInt1, paramInt2, paramBoolean, bool);
      return;
    }
  }
  
  public void a(DynamicTextItem paramDynamicTextItem, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    veg.b("DoodleLayout", "onClickInside: showEditTextDialog." + paramDynamicTextItem);
    if (paramDynamicTextItem != null) {
      paramDynamicTextItem.b();
    }
    this.jdField_a_of_type_Bkdp = new bkdp(this, null);
    this.jdField_a_of_type_Bkbv = new bkbv(super.getContext(), paramBoolean1);
    if ((this.jdField_a_of_type_Bjvc != null) && (this.jdField_a_of_type_Bjvc.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null)) {
      this.jdField_a_of_type_Bkbv.jdField_a_of_type_AndroidWidgetRelativeLayout = this.jdField_a_of_type_Bjvc.a.jdField_a_of_type_AndroidWidgetRelativeLayout;
    }
    if ((((Activity)getContext()).getWindow().getAttributes().flags & 0x400) == 1024)
    {
      paramBoolean1 = true;
      this.jdField_a_of_type_Bkbv.d(paramBoolean1);
      this.jdField_a_of_type_Bkbv.jdField_g_of_type_Int = paramInt2;
      bkbv localbkbv = this.jdField_a_of_type_Bkbv;
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) || (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a())) {
        break label280;
      }
      paramBoolean1 = true;
      label173:
      localbkbv.c(paramBoolean1);
      this.jdField_a_of_type_Bkbv.a(a());
      this.jdField_a_of_type_Bkbv.b(paramBoolean2);
      this.jdField_a_of_type_Bkbv.setContentView(2131561229);
      this.jdField_a_of_type_Bkbv.a(this.jdField_a_of_type_Bkdp);
      this.jdField_a_of_type_Bkbv.a(this.jdField_a_of_type_Bjgr);
      if (paramInt2 == 0) {
        this.jdField_a_of_type_Bkbv.a(paramDynamicTextItem, paramInt1);
      }
      this.jdField_a_of_type_Bkbv.show();
      invalidate();
      if (this.jdField_d_of_type_Int != 0) {
        break label286;
      }
    }
    for (;;)
    {
      b(3);
      c(3);
      return;
      paramBoolean1 = false;
      break;
      label280:
      paramBoolean1 = false;
      break label173;
      label286:
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
    ThreadManager.getUIHandler().post(new DoodleLayout.16(this, paramMap));
  }
  
  public void a(JSONObject paramJSONObject)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(localJSONObject)) {
        paramJSONObject.put(bjvc.b, localJSONObject);
      }
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Bjck.d(paramBoolean);
  }
  
  public void a(boolean paramBoolean1, float paramFloat, int paramInt1, int paramInt2, PointF paramPointF, boolean paramBoolean2, int paramInt3)
  {
    if (this.jdField_a_of_type_Bkac == null) {
      return;
    }
    this.jdField_a_of_type_Bkac.a(paramBoolean1, paramFloat, paramInt1, paramInt2, paramPointF, paramBoolean2, paramInt3);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    long l1 = System.currentTimeMillis();
    if (paramBoolean1) {
      if (paramBoolean2)
      {
        this.jdField_d_of_type_Long = l1;
        this.jdField_a_of_type_JavaUtilList.clear();
        f(0);
        a(this.jdField_d_of_type_Long);
      }
    }
    for (this.jdField_g_of_type_Boolean = false;; this.jdField_g_of_type_Boolean = true)
    {
      this.jdField_c_of_type_Long = l1;
      return;
      this.jdField_d_of_type_Long += l1 - this.jdField_c_of_type_Long;
      break;
      this.jdField_a_of_type_JavaUtilList.add(Long.valueOf(l1 - this.jdField_c_of_type_Long));
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoodleLayout", 2, "show limitView in doodleLayout  , mStoryGuideLineView : " + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView);
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView == null) {
      return;
    }
    if ((!paramBoolean3) || (paramBoolean4))
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.a(true);
      if (!paramBoolean2) {
        break label94;
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.f();
    }
    for (;;)
    {
      if (!paramBoolean1) {
        break label104;
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.h();
      return;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.e();
      break;
      label94:
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.g();
    }
    label104:
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.i();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    if (this.jdField_h_of_type_Boolean) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Bjvc != null) {
        break;
      }
      if (((this.jdField_a_of_type_Bkdo instanceof bizx)) || ((this.jdField_a_of_type_Bkdo instanceof biju)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("DoodleLayout", 2, "mEditDoodlePart == null && mListener instanceof QIMCaptureController/AECaptureController, showLimitBorder");
        }
        if ((this.jdField_a_of_type_Bkdo instanceof bizx)) {}
        for (int n = ((bizx)this.jdField_a_of_type_Bkdo).jdField_a_of_type_Int; (n != 11) && (n != 12); n = 0)
        {
          a(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
          return;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("DoodleLayout", 2, "mEditDoodlePart != null || mListener is not instanceof QIMCaptureController/AECaptureController, broadcast showLimitBorder message");
    }
    this.jdField_a_of_type_Bjvc.a.a(Message.obtain(null, 17, 0, 0, new bjwp(paramBoolean3, paramBoolean4, paramBoolean2, paramBoolean1, paramBoolean5)));
  }
  
  public void a(View... paramVarArgs)
  {
    int i1 = paramVarArgs.length;
    int n = 0;
    while (n < i1)
    {
      View localView = paramVarArgs[n];
      if (localView != null) {
        localView.setVisibility(4);
      }
      n += 1;
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Bkdo != null) {
      return this.jdField_a_of_type_Bkdo.b();
    }
    return true;
  }
  
  public boolean a(float paramFloat1, float paramFloat2, Rect paramRect, float paramFloat3)
  {
    boolean bool = false;
    if (paramRect == null) {}
    for (int n = 0;; n = paramRect.width() / 2)
    {
      if ((paramFloat1 < -n) || (paramFloat2 < -n) || (paramFloat1 > this.jdField_a_of_type_AndroidGraphicsRect.width() + n) || (paramFloat2 > n + this.jdField_a_of_type_AndroidGraphicsRect.height() + paramFloat3)) {
        bool = true;
      }
      return bool;
    }
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(paramInt, false);
  }
  
  public boolean a(bkam parambkam, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) && (parambkam != null))
    {
      if (paramBoolean) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setVisibility(0);
      }
      A();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.a(parambkam);
      parambkam.jdField_k_of_type_Boolean = true;
      Object localObject = parambkam.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper;
      if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a()) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        ((SegmentKeeper)localObject).lockData(paramBoolean);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.requestLayout();
        localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a();
        if ((localObject != null) && (((bkah)localObject).a != null) && (parambkam.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null) && (parambkam.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a()))
        {
          parambkam.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.c();
          ((bkah)localObject).a.a(parambkam, parambkam.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b(), 0, 0.0F, 0.0F);
        }
        return true;
      }
    }
    return false;
  }
  
  public byte[] a(int paramInt)
  {
    bkds localbkds = (bkds)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localbkds == null) {
      return null;
    }
    return localbkds.jdField_a_of_type_Bkaf.a();
  }
  
  public int[] a(int paramInt)
  {
    Object localObject = (bkds)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject != null)
    {
      localObject = ((bkds)localObject).jdField_a_of_type_Bkaf.a.a();
      veg.b("DoodleLayout", "normal path count:" + localObject[0] + ",mosaic path count:" + localObject[1]);
      return localObject;
    }
    return new int[] { 0, 0 };
  }
  
  public int b()
  {
    int n = 0;
    int i1 = 0;
    while (n < this.jdField_b_of_type_AndroidUtilSparseArray.size())
    {
      bkds localbkds = (bkds)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(n);
      i1 = i1 + localbkds.jdField_a_of_type_Bkaj.b() + localbkds.jdField_a_of_type_Bkaf.b() + localbkds.jdField_a_of_type_Bjzt.b() + localbkds.jdField_a_of_type_Bjzr.b();
      n += 1;
    }
    return i1;
  }
  
  public Bitmap b()
  {
    if (this.jdField_a_of_type_Bkdn == null) {
      return null;
    }
    return this.jdField_a_of_type_Bkdn.b();
  }
  
  public String b()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject1 = a();
      if ((localObject1 != null) && (((bkaj)localObject1).jdField_a_of_type_JavaUtilArrayList != null) && (!((bkaj)localObject1).jdField_a_of_type_JavaUtilArrayList.isEmpty()))
      {
        localObject1 = ((bkaj)localObject1).jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (bkam)((Iterator)localObject1).next();
          if (((bkam)localObject2).jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null)
          {
            localObject2 = bjgr.a(((bkam)localObject2).jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.c());
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
  
  public List<bjzx> b(int paramInt)
  {
    bkds localbkds = (bkds)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localbkds != null)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(localbkds.jdField_a_of_type_Bjzt.b);
      localArrayList.addAll(localbkds.jdField_a_of_type_Bjzr.b);
      veg.b("DoodleLayout", "Using poi list:" + localArrayList.toString());
      return Collections.unmodifiableList(localArrayList);
    }
    return Collections.emptyList();
  }
  
  public void b()
  {
    this.jdField_k_of_type_Boolean = false;
  }
  
  public void b(int paramInt)
  {
    if (!bkdy.a(paramInt))
    {
      veg.e("DoodleLayout", "illegal state.");
      return;
    }
    this.jdField_d_of_type_Int = paramInt;
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
    int i1 = paramVarArgs.length;
    int n = 0;
    while (n < i1)
    {
      View localView = paramVarArgs[n];
      if (localView != null) {
        localView.setVisibility(0);
      }
      n += 1;
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
    Object localObject = (bkds)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject != null)
    {
      localObject = ((bkds)localObject).jdField_a_of_type_Bjzt.a();
      veg.b("DoodleLayout", "normal face count:" + localObject[0] + ",location face count:" + localObject[1]);
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
    bjzx localbjzx;
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localObject = a();
      if ((localObject != null) && (((bjzt)localObject).jdField_a_of_type_JavaUtilList != null) && (!((bjzt)localObject).jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        localObject = ((bjzt)localObject).jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localbjzx = (bjzx)((Iterator)localObject).next();
          if ((localbjzx != null) && (!TextUtils.isEmpty(localbjzx.e)))
          {
            localStringBuilder.append(localbjzx.e);
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
    if ((localObject != null) && (((bjzr)localObject).jdField_a_of_type_JavaUtilList != null) && (!((bjzr)localObject).jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      localObject = ((bjzr)localObject).jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localbjzx = (bjzx)((Iterator)localObject).next();
        if ((localbjzx != null) && (!TextUtils.isEmpty(localbjzx.e)))
        {
          localException.append(localbjzx.e);
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
    if (Looper.myLooper() != Looper.getMainLooper()) {
      throw new IllegalStateException("Only the original thread that created a view hierarchy can touch its views.");
    }
  }
  
  public void c(int paramInt)
  {
    a(paramInt, null);
  }
  
  public void c(boolean paramBoolean)
  {
    bjzr localbjzr = a();
    if (localbjzr != null) {
      localbjzr.a(paramBoolean);
    }
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a() == a());
  }
  
  public boolean c(int paramInt)
  {
    Object localObject = (bkds)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject != null)
    {
      localObject = ((bkds)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (!((bkav)((Iterator)localObject).next()).a()) {
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
    bkaf localbkaf = a();
    if (localbkaf != null) {
      localbkaf.d();
    }
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a() == this.jdField_a_of_type_Bjck);
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
    ThreadManager.getUIHandler().post(new DoodleLayout.6(this));
  }
  
  public boolean e()
  {
    return this.jdField_h_of_type_Boolean;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Bjvc != null)
    {
      bjvb localbjvb = (bjvb)this.jdField_a_of_type_Bjvc.a(bjvb.class);
      if (localbjvb != null) {
        localbjvb.a(this);
      }
    }
  }
  
  public void g()
  {
    c();
    bkaf localbkaf = a();
    veg.b("DoodleLayout", "undo, activeLayer:" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a() + ",pathCount:" + localbkaf.a.b());
    if (localbkaf.d())
    {
      localbkaf.e();
      if (localbkaf.a.b() == 0) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(false);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(true);
  }
  
  public void h()
  {
    c();
    veg.b("DoodleLayout", "onFacePressed, buttonState:" + this.jdField_d_of_type_Int + ",activeLayer:" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a());
    vem.a("0X80076BA", vem.jdField_b_of_type_Int);
    if (this.jdField_d_of_type_Int == 0) {}
    for (;;)
    {
      b(1);
      do
      {
        return;
        if (this.jdField_d_of_type_Int != 3) {
          break;
        }
        b(1);
        this.jdField_a_of_type_Bkbv.a(false);
      } while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView == null);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.b(true);
      return;
      if (this.jdField_d_of_type_Int == 2)
      {
        a().d(false);
        a(new View[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout });
      }
    }
  }
  
  public void i()
  {
    if (this.jdField_d_of_type_Int == 3)
    {
      b(0);
      this.jdField_a_of_type_Bkbv.a(false);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.b(true);
      }
    }
  }
  
  public void j()
  {
    if (this.jdField_d_of_type_Int == 3)
    {
      b(0);
      c(0);
      this.jdField_a_of_type_Bkbv.a(false);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.b(true);
      }
    }
  }
  
  public void k()
  {
    if (this.jdField_d_of_type_Int == 3)
    {
      b(0);
      c(0);
      this.jdField_a_of_type_Bkbv.a(false);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.b(true);
      }
    }
  }
  
  public void l()
  {
    c();
    veg.b("DoodleLayout", "onTextPressed, buttonState:" + this.jdField_d_of_type_Int + ",activeLayer:" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a());
    a().d(true);
    DynamicTextItem localDynamicTextItem = a().a(d());
    a(a().a(), false);
    if (localDynamicTextItem != null)
    {
      a(localDynamicTextItem, 0, 0, true);
      return;
    }
    bcpw.a(getContext(), getContext().getString(2131698316), 0).a();
    ThreadManager.getUIHandler().post(new DoodleLayout.12(this));
  }
  
  public void m()
  {
    c();
    veg.b("DoodleLayout", "onLinePressed, buttonState:" + this.jdField_d_of_type_Int + ",activeLayer:" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a());
    vem.a("0X80076B8", vem.jdField_b_of_type_Int);
    bkaf localbkaf = a();
    b(new View[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout });
    localbkaf.d(true);
    x();
    if (localbkaf.a.b() > 0)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(true);
      if (this.jdField_d_of_type_Int != 0) {
        break label129;
      }
    }
    for (;;)
    {
      b(2);
      label129:
      do
      {
        return;
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(false);
        break;
        if (this.jdField_d_of_type_Int != 3) {
          break label166;
        }
        b(2);
        this.jdField_a_of_type_Bkbv.a(false);
      } while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView == null);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.b(true);
      return;
      label166:
      if (this.jdField_d_of_type_Int == 1)
      {
        b(new View[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView });
        setDoodleGLViewVisibility(0);
      }
    }
  }
  
  public void n()
  {
    c();
    b(new View[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView, this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView });
    setDoodleGLViewVisibility(0);
    a(new View[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout, this.jdField_a_of_type_AndroidWidgetRelativeLayout });
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(false);
    if ((this.jdField_d_of_type_Int == 3) && (this.jdField_a_of_type_Bkbv != null))
    {
      b(0);
      this.jdField_a_of_type_Bkbv.a(false);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.b(true);
      }
      return;
    }
    b(0);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.f();
    this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.f();
  }
  
  public void o()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.i();
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_b_of_type_Long > System.currentTimeMillis()) {}
    while ((a(false)) || (this.jdField_a_of_type_Bkdo == null)) {
      return;
    }
    this.jdField_a_of_type_Bkdo.p();
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
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a() == this.jdField_a_of_type_Bjck)
    {
      c(7);
      bkav localbkav = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(paramMotionEvent);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setActiveLayer(localbkav);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setTopLevelLayer(localbkav);
      localbkav.d(paramMotionEvent);
      this.m = true;
    }
    do
    {
      return true;
      if (!this.m) {
        break;
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a().d(paramMotionEvent);
    } while ((paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3));
    this.m = false;
    return true;
    this.m = false;
    return false;
  }
  
  public void p()
  {
    this.jdField_d_of_type_Boolean = true;
    int n = 0;
    while (n < this.jdField_b_of_type_AndroidUtilSparseArray.size())
    {
      bkaj localbkaj = ((bkds)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(n)).jdField_a_of_type_Bkaj;
      localbkaj.a(null);
      localbkaj.a(null);
      n += 1;
    }
  }
  
  public void q()
  {
    if (this.jdField_d_of_type_Int == 6)
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
      localAlphaAnimation.setAnimationListener(new bkdf(this));
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.startAnimation(localAlphaAnimation);
      if (this.jdField_a_of_type_Bkdn != null) {
        this.jdField_a_of_type_Bkdn.b(localAlphaAnimation);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Personality", 2, "exitFullScreen");
      }
      return;
      label135:
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(false);
    }
  }
  
  public void r()
  {
    if (this.jdField_a_of_type_Bkdo != null) {
      this.jdField_a_of_type_Bkdo.o();
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.d();
    }
    f(this.jdField_b_of_type_Boolean);
  }
  
  public void s()
  {
    bkex localbkex = (bkex)a().a(104);
    if (localbkex != null) {
      localbkex.e();
    }
  }
  
  public void setDoodleBitmapMaxSize(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      veg.e("DoodleLayout", "width or height is illegal, width=" + paramInt1 + ",height=" + paramInt2);
    }
    for (;;)
    {
      return;
      veg.b("DoodleLayout", "setDoodleBitmapMaxSize, maxWidth" + paramInt1 + ",maxHeight:" + paramInt2);
      this.jdField_h_of_type_Int = paramInt1;
      this.jdField_i_of_type_Int = paramInt2;
      int n = 0;
      while (n < this.jdField_a_of_type_AndroidUtilSparseArray.size())
      {
        ((bkbb)this.jdField_a_of_type_AndroidUtilSparseArray.get(n)).jdField_a_of_type_Int = paramInt1;
        ((bkbb)this.jdField_a_of_type_AndroidUtilSparseArray.get(n)).jdField_b_of_type_Int = paramInt2;
        n += 1;
      }
    }
  }
  
  public void setDoodleBtnOperationHelper(bkdn parambkdn)
  {
    this.jdField_a_of_type_Bkdn = parambkdn;
  }
  
  public void setDoodleEventListener(bkdo parambkdo)
  {
    this.jdField_a_of_type_Bkdo = parambkdo;
  }
  
  @TargetApi(14)
  public void setDoodleGLViewVisibility(int paramInt)
  {
    if (!this.jdField_e_of_type_Boolean) {
      return;
    }
    if (!this.jdField_c_of_type_Boolean)
    {
      veg.b("DoodleLayout", "setDoodleGLViewVisibility, soload failed, glview default invisible");
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
  
  public void setEditVideoDoodle(bjvc parambjvc)
  {
    this.jdField_a_of_type_Bjvc = parambjvc;
  }
  
  public void setEditVideoParams(EditVideoParams paramEditVideoParams)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(paramEditVideoParams);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a(paramEditVideoParams);
    jdField_a_of_type_Boolean = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a();
    B();
  }
  
  public void setEntrance(int paramInt)
  {
    this.jdField_l_of_type_Int = paramInt;
  }
  
  public void setFaceLayerPosition(long paramLong)
  {
    int i1 = 0;
    Object localObject1 = a();
    int n;
    if (localObject1 != null)
    {
      localObject1 = ((bjzt)localObject1).jdField_a_of_type_JavaUtilList;
      n = 0;
    }
    for (;;)
    {
      TrackerStickerParam.MotionInfo localMotionInfo;
      float f1;
      if (n < ((List)localObject1).size())
      {
        bjzx localbjzx = (bjzx)((List)localObject1).get(n);
        try
        {
          localMotionInfo = (TrackerStickerParam.MotionInfo)localbjzx.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
          if (localMotionInfo == null) {
            break label536;
          }
          if (!localMotionInfo.isLost)
          {
            localbjzx.b.set(0.0F, 0.0F);
            localbjzx.s = localMotionInfo.x;
            localbjzx.t = localMotionInfo.y;
            f1 = localbjzx.o;
            localbjzx.q = (localMotionInfo.scale * f1);
          }
          else
          {
            localbjzx.b.set(-2000.0F, 0.0F);
            localbjzx.s = localMotionInfo.x;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          if (!QLog.isColorLevel()) {
            break label536;
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
          localObject1 = ((bjzt)localObject1).jdField_a_of_type_JavaUtilList;
          n = 0;
          if (n < ((List)localObject1).size())
          {
            localObject2 = (bjzx)((List)localObject1).get(n);
            localMotionInfo = (TrackerStickerParam.MotionInfo)((bjzx)localObject2).jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
            if (localMotionInfo != null)
            {
              if (localMotionInfo.isLost) {
                break label333;
              }
              ((bjzx)localObject2).b.set(0.0F, 0.0F);
              ((bjzx)localObject2).s = localMotionInfo.x;
              ((bjzx)localObject2).t = localMotionInfo.y;
              f1 = ((bjzx)localObject2).o;
              ((bjzx)localObject2).q = (localMotionInfo.scale * f1);
            }
            for (;;)
            {
              n += 1;
              break;
              label333:
              ((bjzx)localObject2).b.set(-2000.0F, 0.0F);
              ((bjzx)localObject2).s = localMotionInfo.x;
            }
          }
        }
        localObject1 = a();
        if (localObject1 != null)
        {
          localObject1 = ((bkaj)localObject1).jdField_a_of_type_JavaUtilArrayList;
          n = i1;
          if (n < ((List)localObject1).size())
          {
            localObject2 = (bkam)((List)localObject1).get(n);
            localMotionInfo = (TrackerStickerParam.MotionInfo)((bkam)localObject2).jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
            if (localMotionInfo != null)
            {
              if (localMotionInfo.isLost) {
                break label495;
              }
              ((bkam)localObject2).b.set(0.0F, 0.0F);
              ((bkam)localObject2).s = localMotionInfo.x;
              ((bkam)localObject2).t = localMotionInfo.y;
              f1 = ((bkam)localObject2).o;
              ((bkam)localObject2).q = (localMotionInfo.scale * f1);
            }
            for (;;)
            {
              n += 1;
              break;
              label495:
              ((bkam)localObject2).b.set(-2000.0F, 0.0F);
              ((bkam)localObject2).s = localMotionInfo.x;
            }
          }
        }
        ThreadManager.getUIHandler().post(new DoodleLayout.15(this));
        return;
      }
      label536:
      n += 1;
    }
  }
  
  public void setLocation(TroopBarPOI paramTroopBarPOI)
  {
    if (this.jdField_a_of_type_Bjzx == null)
    {
      veg.e("DoodleLayout", "ClickFaceItem not found.");
      return;
    }
    veg.b("DoodleLayout", "setLocation: clickItem-->" + this.jdField_a_of_type_Bjzx);
    a().a(this.jdField_a_of_type_Bjzx, paramTroopBarPOI);
    this.jdField_a_of_type_Bjzx = null;
  }
  
  public void setMosaicSize(int paramInt)
  {
    int n = paramInt;
    if (paramInt < 1)
    {
      veg.e("DoodleLayout", "MosaicSize little than 1.");
      n = 1;
    }
    this.jdField_e_of_type_Int = n;
    paramInt = 0;
    while (paramInt < this.jdField_b_of_type_AndroidUtilSparseArray.size())
    {
      bkex localbkex = (bkex)((bkds)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(paramInt)).jdField_a_of_type_Bkaf.a(103);
      if (localbkex != null) {
        localbkex.b(n);
      }
      paramInt += 1;
    }
  }
  
  public void setMosaicStandardSize(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      veg.e("DoodleLayout", "StandardMosaicSize, width or height <= 0. width:" + paramInt1 + ",height:" + paramInt2);
    }
    for (;;)
    {
      return;
      this.jdField_f_of_type_Int = paramInt1;
      this.jdField_g_of_type_Int = paramInt2;
      int n = 0;
      while (n < this.jdField_b_of_type_AndroidUtilSparseArray.size())
      {
        bkex localbkex = (bkex)((bkds)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(n)).jdField_a_of_type_Bkaf.a(103);
        if (localbkex != null) {
          localbkex.b(paramInt1, paramInt2);
        }
        n += 1;
      }
    }
  }
  
  public void setOnTextDialogShowListener(bkdx parambkdx)
  {
    this.jdField_a_of_type_Bkdx = parambkdx;
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
  
  public void setTrackerState(bkhw parambkhw, int paramInt)
  {
    if (parambkhw == null) {}
    do
    {
      return;
      parambkhw.jdField_i_of_type_Int = paramInt;
    } while (this.jdField_a_of_type_Bkdo == null);
    if (!parambkhw.a())
    {
      float f3 = parambkhw.b.x + parambkhw.s - parambkhw.u / 2.0F;
      float f4 = parambkhw.b.y + parambkhw.t - parambkhw.v / 2.0F;
      float f2 = f4;
      float f1 = f3;
      if (parambkhw.jdField_g_of_type_Boolean)
      {
        f2 = f4;
        f1 = f3;
        if (parambkhw.jdField_h_of_type_Boolean)
        {
          f1 = parambkhw.l + parambkhw.j - parambkhw.u / 2.0F;
          f2 = parambkhw.m + parambkhw.jdField_k_of_type_Float - parambkhw.v / 2.0F;
        }
      }
      this.jdField_a_of_type_Bkdo.a(f1, f2, parambkhw.u, parambkhw.v);
      return;
    }
    this.jdField_a_of_type_Bkdo.t();
    parambkhw.d();
  }
  
  public void setupPersonality()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)super.findViewById(2131365311));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleTextureView = new DoodleTextureView(super.getContext());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleTextureView, localLayoutParams);
    this.jdField_c_of_type_Boolean = axlc.e();
    if (!this.jdField_c_of_type_Boolean)
    {
      a(new View[] { this.jdField_a_of_type_AndroidWidgetFrameLayout });
      setDoodleGLViewVisibility(4);
      this.jdField_e_of_type_Boolean = false;
      return;
    }
    this.jdField_e_of_type_Boolean = true;
    z();
  }
  
  public void t()
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
  
  public void u()
  {
    this.jdField_g_of_type_Boolean = false;
    f(1);
    a(System.currentTimeMillis());
  }
  
  public void v()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.invalidate();
  }
  
  public void w()
  {
    if ((this.jdField_a_of_type_Bjvc != null) && (this.jdField_a_of_type_Bjvc.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null))
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.getLayoutParams();
      localLayoutParams.bottomMargin = 0;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setLayoutParams(localLayoutParams);
    }
  }
  
  public void x()
  {
    Object localObject = a();
    if (localObject == null) {}
    do
    {
      return;
      localObject = (bkfg)((bkaf)localObject).a(101);
    } while (localObject == null);
    SharedPreferences localSharedPreferences;
    if (this.jdField_a_of_type_Int == -1)
    {
      localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("DoodleLay_State", 4);
      if ((localSharedPreferences.contains("Line_LastType")) && (localSharedPreferences.contains("Line_LastSubType"))) {
        break label96;
      }
      this.jdField_a_of_type_Int = 0;
    }
    for (this.jdField_b_of_type_Int = ((bkfg)localObject).jdField_b_of_type_Int;; this.jdField_b_of_type_Int = localSharedPreferences.getInt("Line_LastSubType", 0))
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setSelectedStroke(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      return;
      label96:
      this.jdField_a_of_type_Int = localSharedPreferences.getInt("Line_LastType", 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout
 * JD-Core Version:    0.7.0.1
 */