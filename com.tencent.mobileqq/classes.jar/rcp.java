import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsFloatWindowDragLayout;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsFloatWindowManager.3;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class rcp
  implements View.OnClickListener, View.OnLongClickListener, rcm, rfu, rlg
{
  private static int jdField_a_of_type_Int;
  private static int jdField_b_of_type_Int;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private VideoFeedsFloatWindowDragLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFloatWindowDragLayout;
  private VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<rol> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashSet<String> jdField_a_of_type_JavaUtilHashSet;
  private List<VideoInfo> jdField_a_of_type_JavaUtilList;
  private ntb jdField_a_of_type_Ntb;
  private ntc jdField_a_of_type_Ntc;
  private oxe jdField_a_of_type_Oxe;
  private rch jdField_a_of_type_Rch;
  private rcs jdField_a_of_type_Rcs;
  private rcw jdField_a_of_type_Rcw;
  private rfs jdField_a_of_type_Rfs;
  private boolean jdField_a_of_type_Boolean;
  private rfs jdField_b_of_type_Rfs;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private rfs jdField_c_of_type_Rfs;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = 0;
  private boolean jdField_e_of_type_Boolean;
  private int f;
  private int g;
  private int h;
  private int i;
  
  private rcp()
  {
    jdField_a_of_type_Int = bdkf.a(100.0F);
    jdField_b_of_type_Int = bdkf.a(128.0F);
    this.jdField_c_of_type_Int = bdkf.a(54.0F);
    this.jdField_d_of_type_Int = bdkf.a(6.0F);
    this.jdField_a_of_type_Boolean = true;
  }
  
  private VideoFeedsFloatWindowDragLayout a(Context paramContext)
  {
    VideoFeedsFloatWindowDragLayout localVideoFeedsFloatWindowDragLayout = new VideoFeedsFloatWindowDragLayout(paramContext);
    localVideoFeedsFloatWindowDragLayout.setId(22);
    localVideoFeedsFloatWindowDragLayout.setOnClickListener(this);
    localVideoFeedsFloatWindowDragLayout.setOnLongClickListener(this);
    localVideoFeedsFloatWindowDragLayout.setDragListener(this);
    localVideoFeedsFloatWindowDragLayout.setEdge(this.jdField_d_of_type_Int);
    localVideoFeedsFloatWindowDragLayout.a(ImmersiveUtils.getStatusBarHeight(paramContext));
    localVideoFeedsFloatWindowDragLayout.b(this.jdField_c_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setId(21);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842706);
    int j = bcwh.a(paramContext, 24.0F);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(j, j);
    localLayoutParams.gravity = 5;
    j = bcwh.a(paramContext, 3.0F);
    localLayoutParams.topMargin = j;
    localLayoutParams.rightMargin = j;
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130842535);
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(paramContext);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(0);
    localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 85;
    this.jdField_a_of_type_Rch = new rch(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    this.jdField_a_of_type_Rch.a(paramContext, this.jdField_a_of_type_AndroidWidgetFrameLayout);
    this.jdField_a_of_type_AndroidViewViewGroup = this.jdField_a_of_type_Rch.jdField_a_of_type_AndroidWidgetFrameLayout;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView);
    localVideoFeedsFloatWindowDragLayout.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, localLayoutParams);
    return localVideoFeedsFloatWindowDragLayout;
  }
  
  public static final rcp a()
  {
    return rcx.a();
  }
  
  private rfs a(VideoInfo paramVideoInfo)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_Rfs != null)
    {
      rfs localrfs2 = this.jdField_a_of_type_Rfs;
      this.jdField_a_of_type_Rfs = null;
      localrfs1 = localrfs2;
      if (QLog.isColorLevel())
      {
        QLog.d("VideoFeedsFloatWindowManager", 2, "generateVideoPlayParam: use scrapParams");
        localrfs1 = localrfs2;
      }
      localrfs1.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
      return localrfs1;
    }
    rfs localrfs1 = new rfs();
    localrfs1.jdField_a_of_type_Qyz = this.jdField_a_of_type_Rch;
    localrfs1.jdField_a_of_type_AndroidViewViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
    if (this.f == 1) {}
    for (;;)
    {
      localrfs1.jdField_b_of_type_Boolean = bool;
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsFloatWindowManager", 2, "generateVideoPlayParam: create new params");
      }
      break;
      bool = false;
    }
  }
  
  private ron a()
  {
    long l2 = 0L;
    if ((this.jdField_b_of_type_Rfs != null) && (this.jdField_b_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
    {
      ron localron1 = new ron(this.jdField_b_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      rjn localrjn = this.jdField_b_of_type_Rfs.jdField_a_of_type_Rjn;
      ron localron2 = localron1.h(this.jdField_b_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g);
      if (localrjn != null)
      {
        l1 = localrjn.a(this.jdField_c_of_type_Boolean);
        localron2 = localron2.d(l1);
        if (localrjn == null) {
          break label131;
        }
      }
      label131:
      for (long l1 = localrjn.a();; l1 = 0L)
      {
        localron2 = localron2.a(l1);
        l1 = l2;
        if (localrjn != null) {
          l1 = localrjn.b();
        }
        localron2.c(l1);
        return localron1;
        l1 = 0L;
        break;
      }
    }
    return new ron((VideoInfo)null);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    int[] arrayOfInt = a(paramInt1, paramInt2);
    localLayoutParams.width = arrayOfInt[0];
    localLayoutParams.height = arrayOfInt[1];
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_Rch.a(localLayoutParams.width, localLayoutParams.height);
  }
  
  private void a(Context paramContext)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFloatWindowDragLayout == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFloatWindowDragLayout = a(paramContext);
    }
    if (this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams == null)
    {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams();
      if (Build.VERSION.SDK_INT < 26) {
        break label142;
      }
    }
    label142:
    for (this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.type = 2038;; this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.type = 2003)
    {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.flags = 16778120;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.format = -3;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.gravity = 85;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = -2;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = -2;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y = (this.jdField_c_of_type_Int + this.jdField_d_of_type_Int);
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x = this.jdField_d_of_type_Int;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFloatWindowDragLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFloatWindowDragLayout.setAlpha(0.0F);
      return;
    }
  }
  
  private void a(VideoInfo paramVideoInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsFloatWindowManager", 2, "preplayVide: videoInfo: " + paramVideoInfo.jdField_a_of_type_JavaLangString);
    }
    paramVideoInfo = a(paramVideoInfo);
    paramVideoInfo.jdField_a_of_type_Long = 0L;
    this.jdField_c_of_type_Rfs = paramVideoInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b(paramVideoInfo);
  }
  
  private void a(VideoInfo paramVideoInfo, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsFloatWindowManager", 2, "playVideo: index=" + this.g + ", videoInfo: " + paramVideoInfo.jdField_a_of_type_JavaLangString);
    }
    rfs localrfs2 = this.jdField_b_of_type_Rfs;
    if (localrfs2 != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d();
    }
    a(paramVideoInfo.jdField_b_of_type_Int, paramVideoInfo.jdField_c_of_type_Int);
    if ((this.jdField_c_of_type_Rfs != null) && (this.jdField_c_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == paramVideoInfo))
    {
      rfs localrfs1 = this.jdField_c_of_type_Rfs;
      paramVideoInfo = localrfs1;
      if (QLog.isColorLevel())
      {
        QLog.d("VideoFeedsFloatWindowManager", 2, "playVideo: hit preplay");
        paramVideoInfo = localrfs1;
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Rfs = paramVideoInfo;
      this.jdField_a_of_type_Rfs = localrfs2;
      this.jdField_c_of_type_Boolean = false;
      if ((ors.a() == null) || (ors.a().c())) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(paramVideoInfo, false);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsFloatWindowManager", 2, "playVideo: no hit peplay");
      }
      paramVideoInfo = a(paramVideoInfo);
      paramVideoInfo.jdField_a_of_type_Long = paramLong;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(paramVideoInfo);
  }
  
  private void a(VideoInfo paramVideoInfo1, VideoInfo paramVideoInfo2, List<rol> paramList, qlq paramqlq, long paramLong, int paramInt)
  {
    if (paramVideoInfo1 != null)
    {
      String str2 = paramVideoInfo1.j;
      String str1 = paramVideoInfo1.g;
      int m = ors.e();
      int n = ntd.a();
      int i1 = paramList.size();
      int k = 0;
      if (k < i1)
      {
        Object localObject1 = (rol)paramList.get(k);
        if (QLog.isColorLevel()) {
          QLog.d("VideoFeedsFloatWindowManager", 2, "播放VV上报 totalPlayTime = " + ((rol)localObject1).jdField_a_of_type_Long + ", currentPlayTime = " + ((rol)localObject1).b);
        }
        int j;
        label135:
        Object localObject2;
        if ((((rol)localObject1).b != 0L) || (((rol)localObject1).jdField_a_of_type_Long != 0L))
        {
          if (k != 0) {
            break label618;
          }
          j = 0;
          localObject2 = new ron(paramVideoInfo1).d(((rol)localObject1).jdField_a_of_type_Long).a(((rol)localObject1).b).y(j).z(i1 - 1).B(paramqlq.l).A(paramqlq.k).D(paramqlq.j).C(paramqlq.i).c(paramLong).l(paramInt).a(409409).a(Boolean.valueOf(paramVideoInfo1.jdField_b_of_type_Boolean));
          if (paramVideoInfo1.y == null) {
            break label638;
          }
          localObject1 = paramVideoInfo1.y;
          label244:
          localObject1 = ((ron)localObject2).a((String)localObject1).e(paramVideoInfo1.jdField_c_of_type_Boolean).p(n).q(m).e(paramVideoInfo1.f).c(paramVideoInfo1.o).K(paramVideoInfo1.k).g(paramVideoInfo2.g).j(true).v(this.i);
          if (!paramVideoInfo1.e()) {
            break label646;
          }
          j = 2;
          label319:
          localObject1 = ((ron)localObject1).Y(j);
          if (!paramVideoInfo1.e()) {
            break label652;
          }
          j = paramVideoInfo1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Int;
          label344:
          localObject1 = ((ron)localObject1).t(j);
          if ((!paramVideoInfo1.e()) || (TextUtils.isEmpty(paramVideoInfo1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.h)) || (TextUtils.isEmpty(paramVideoInfo1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.g))) {
            break label658;
          }
          j = 1;
          label389:
          localObject2 = ((ron)localObject1).Z(j);
          if ((!paramVideoInfo1.e()) || (paramVideoInfo1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo == null)) {
            break label664;
          }
          localObject1 = paramVideoInfo1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e;
          label427:
          localObject2 = ((ron)localObject2).o((String)localObject1);
          if ((!paramVideoInfo1.e()) || (paramVideoInfo1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.d == null)) {
            break label672;
          }
          localObject1 = paramVideoInfo1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.d.e;
          label465:
          localObject1 = ((ron)localObject2).p((String)localObject1).h(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.f).N(0);
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "play video [video_from_type : " + this.i + ", first_video_row_key : " + paramVideoInfo2.g + "]");
          }
          localObject2 = ((ron)localObject1).a().a();
          if (TextUtils.isEmpty(str1)) {
            break label680;
          }
        }
        label646:
        label652:
        label658:
        label664:
        label672:
        label680:
        for (localObject1 = str1;; localObject1 = "0")
        {
          nrt.b(null, str2, "0X8007409", "0X8007409", 0, 0, "", "", (String)localObject1, (String)localObject2, false);
          nrt.a("0X8007409", str2, "", "", "", (String)localObject2);
          k += 1;
          break;
          label618:
          if (this.f == 2)
          {
            j = 2;
            break label135;
          }
          j = 1;
          break label135;
          label638:
          localObject1 = "";
          break label244;
          j = 1;
          break label319;
          j = 0;
          break label344;
          j = 0;
          break label389;
          localObject1 = "";
          break label427;
          localObject1 = "";
          break label465;
        }
      }
    }
  }
  
  private void a(List<VideoInfo> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      if (this.jdField_a_of_type_JavaUtilHashSet == null) {
        this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        VideoInfo localVideoInfo = (VideoInfo)paramList.next();
        if ((!localVideoInfo.jdField_c_of_type_Boolean) && (!this.jdField_a_of_type_JavaUtilHashSet.contains(localVideoInfo.jdField_a_of_type_JavaLangString)))
        {
          this.jdField_a_of_type_JavaUtilHashSet.add(localVideoInfo.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_JavaUtilList.add(localVideoInfo);
        }
      }
    }
  }
  
  private boolean a(Activity paramActivity)
  {
    return ((paramActivity instanceof SplashActivity)) && ((BaseActivity.sTopActivity instanceof SplashActivity));
  }
  
  public static int[] a(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = new int[2];
    if (paramInt2 == 0) {}
    float f1;
    do
    {
      return arrayOfInt;
      f1 = paramInt1 / paramInt2;
    } while (f1 == 0.0F);
    if (f1 < 1.0F)
    {
      arrayOfInt[0] = jdField_a_of_type_Int;
      arrayOfInt[1] = ((int)(jdField_a_of_type_Int / f1));
      return arrayOfInt;
    }
    if (f1 > 1.0F)
    {
      arrayOfInt[1] = jdField_a_of_type_Int;
      arrayOfInt[0] = ((int)(f1 * jdField_a_of_type_Int));
      return arrayOfInt;
    }
    paramInt1 = jdField_b_of_type_Int;
    arrayOfInt[1] = paramInt1;
    arrayOfInt[0] = paramInt1;
    return arrayOfInt;
  }
  
  private void b(int paramInt)
  {
    if ((this.jdField_a_of_type_Rcw != null) && (!this.jdField_a_of_type_Rcw.hasMessages(paramInt))) {
      this.jdField_a_of_type_Rcw.sendEmptyMessageDelayed(paramInt, 3500L);
    }
  }
  
  private void b(List<VideoInfo> paramList, @Nullable Bundle paramBundle)
  {
    long l = 0L;
    boolean bool = true;
    if (paramBundle != null) {
      this.i = paramBundle.getInt("VIDEO_FROM_TYPE");
    }
    this.f = bjxj.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = new VideoFeedsPlayManager(BaseApplicationImpl.getContext(), ors.a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d(true);
    VideoFeedsPlayManager localVideoFeedsPlayManager = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
    if (this.f == 2) {}
    for (;;)
    {
      localVideoFeedsPlayManager.g(bool);
      a(paramList);
      if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
      {
        this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = ((VideoInfo)this.jdField_a_of_type_JavaUtilList.get(0));
        if (paramBundle != null) {
          l = paramBundle.getLong("ARGS_VIDEO_START_POSITION", 0L);
        }
        a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, l);
        this.g = 0;
      }
      return;
      bool = false;
    }
  }
  
  private boolean b()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {}
    while (this.g != this.jdField_a_of_type_JavaUtilList.size() - 1) {
      return false;
    }
    return true;
  }
  
  private boolean b(Activity paramActivity)
  {
    return ((paramActivity instanceof ReadInJoyNewFeedsActivity)) && ((BaseActivity.sTopActivity instanceof ReadInJoyNewFeedsActivity));
  }
  
  private void c(int paramInt)
  {
    if ((this.jdField_a_of_type_Rcw != null) && (this.jdField_a_of_type_Rcw.hasMessages(paramInt))) {
      this.jdField_a_of_type_Rcw.removeMessages(paramInt);
    }
  }
  
  private boolean c(Activity paramActivity)
  {
    return (paramActivity == BaseActivity.sTopActivity) && (this.jdField_a_of_type_Boolean);
  }
  
  private void i()
  {
    nrt.a(null, null, "0X8009A28", "0X8009A28", 0, 0, "", "", null, a().a().a(), false);
  }
  
  private void j()
  {
    if (this.f == 0)
    {
      localObject = ors.a();
      if (localObject != null)
      {
        this.jdField_a_of_type_Ntb = ((ntb)((QQAppInterface)localObject).a(90));
        if (this.jdField_a_of_type_Ntc == null) {
          this.jdField_a_of_type_Ntc = new rcu(this, null);
        }
        ((QQAppInterface)localObject).addObserver(this.jdField_a_of_type_Ntc);
      }
    }
    if (this.jdField_a_of_type_Oxe == null) {
      this.jdField_a_of_type_Oxe = new rcv(this, null);
    }
    oxb.a().a(this.jdField_a_of_type_Oxe);
    rlf.a().a(Integer.toHexString(System.identityHashCode(this)));
    rlf.a().a(this);
    rlf.a().a(true, "float window video");
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      if (this.jdField_a_of_type_Rcs == null) {
        this.jdField_a_of_type_Rcs = new rcs(this, null);
      }
      ((BaseApplicationImpl)localObject).registerActivityLifecycleCallbacks(this.jdField_a_of_type_Rcs);
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = new rct(this, null);
      }
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("tencent.av.v2q.StopVideoChat");
      localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
      ((BaseApplicationImpl)localObject).registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_Ntb = null;
    rlf.a().b(Integer.toHexString(System.identityHashCode(this)));
    rlf.a().b(this);
    rlf.a().a(false, "float window video");
    if (this.jdField_a_of_type_Oxe != null) {
      oxb.a().b(this.jdField_a_of_type_Oxe);
    }
    Object localObject = ors.a();
    if ((localObject != null) && (this.jdField_a_of_type_Ntc != null)) {
      ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Ntc);
    }
    localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      if (this.jdField_a_of_type_Rcs != null) {
        ((BaseApplicationImpl)localObject).unregisterActivityLifecycleCallbacks(this.jdField_a_of_type_Rcs);
      }
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
        ((BaseApplicationImpl)localObject).unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      }
    }
    this.jdField_a_of_type_Rcs = null;
    this.jdField_a_of_type_Oxe = null;
    this.jdField_a_of_type_Ntc = null;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  }
  
  private void l()
  {
    if (this.g < this.jdField_a_of_type_JavaUtilList.size() - 1)
    {
      this.g += 1;
      a((VideoInfo)this.jdField_a_of_type_JavaUtilList.get(this.g), 0L);
      return;
    }
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void m()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFloatWindowDragLayout.setEnabled(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFloatWindowDragLayout.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFloatWindowDragLayout.jdField_a_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d(false);
    if (this.jdField_c_of_type_Rfs != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c(this.jdField_c_of_type_Rfs);
      if (this.jdField_c_of_type_Rfs.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_c_of_type_Rfs.jdField_a_of_type_AndroidViewView);
      }
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(-16777216);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    o();
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = ((int)bdcb.i());
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = ((int)bdcb.j());
    this.jdField_a_of_type_AndroidViewWindowManager.updateViewLayout(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFloatWindowDragLayout, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
    n();
  }
  
  private void n()
  {
    rdm.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFloatWindowDragLayout, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_AndroidViewWindowManager, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams, new rcr(this));
  }
  
  private void o()
  {
    try
    {
      int j = ((Integer)this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.getClass().getField("privateFlags").get(this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams)).intValue();
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.getClass().getField("privateFlags").set(this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams, Integer.valueOf(j | 0x40));
      return;
    }
    catch (Exception localException) {}
  }
  
  private void p()
  {
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_Boolean = false;
      oxb.a().k();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFloatWindowDragLayout.setAlpha(1.0F);
      c(0);
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsFloatWindowManager", 2, "onFinishVideoFeedsActivity");
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewWindowManager.updateViewLayout(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFloatWindowDragLayout, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.e(true);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsFloatWindowManager", 2, "onSystemVolumeChanged: volume=" + paramInt);
      }
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.e(false);
    }
  }
  
  public void a(List<VideoInfo> paramList, Bundle paramBundle)
  {
    BaseApplicationImpl localBaseApplicationImpl;
    if (this.jdField_e_of_type_Int == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsFloatWindowManager", 2, "launch: ");
      }
      localBaseApplicationImpl = BaseApplicationImpl.getApplication();
      if (localBaseApplicationImpl != null) {}
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)localBaseApplicationImpl.getSystemService("window"));
    a(localBaseApplicationImpl);
    try
    {
      this.jdField_a_of_type_AndroidViewWindowManager.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFloatWindowDragLayout, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
      b(paramList, paramBundle);
      j();
      i();
      this.jdField_e_of_type_Int = 1;
      this.jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_Rcw = new rcw(this, null);
      b(0);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VideoFeedsFloatWindowManager", 2, "launch: fail", localException);
        }
        localException.printStackTrace();
      }
    }
  }
  
  public void a(rfs paramrfs) {}
  
  public void a(rfs paramrfs, int paramInt)
  {
    if ((paramrfs != null) && (paramrfs.jdField_a_of_type_Rjn != null))
    {
      rol localrol = new rol();
      localrol.jdField_a_of_type_Long = paramrfs.jdField_a_of_type_Rjn.a(true);
      localrol.b = paramrfs.jdField_a_of_type_Rjn.b();
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsFloatWindowManager", 2, "mPlayInfoListForReport add detailInfo.totalPlayTime = " + localrol.jdField_a_of_type_Long + ", detailInfo.currentPlayTime = " + localrol.b);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(localrol);
    }
  }
  
  public void a(rfs paramrfs, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(rfs paramrfs, boolean paramBoolean)
  {
    VideoInfo localVideoInfo1 = paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    VideoInfo localVideoInfo2 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    long l2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
    Object localObject = new rol();
    if (paramBoolean) {}
    for (long l1 = paramrfs.jdField_a_of_type_Rjn.b();; l1 = paramrfs.jdField_a_of_type_Rjn.a())
    {
      ((rol)localObject).b = l1;
      ((rol)localObject).jdField_a_of_type_Long = paramrfs.jdField_a_of_type_Rjn.a(paramBoolean);
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      localObject = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      ThreadManager.excute(new VideoFeedsFloatWindowManager.3(this, localVideoInfo1, localVideoInfo2, (List)localObject, paramrfs.jdField_a_of_type_Qlq, l2, this.g), 16, null, true);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.e(false);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsFloatWindowManager", 2, "onHeadsetStateChanged: on=" + paramBoolean);
      }
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.e(true);
    }
  }
  
  public boolean a()
  {
    return this.jdField_e_of_type_Int == 1;
  }
  
  public void b() {}
  
  public void b(rfs paramrfs)
  {
    if ((this.f == 0) && (b())) {
      this.jdField_a_of_type_Ntb.a(this.jdField_a_of_type_Ntc, this.i, (VideoInfo)this.jdField_a_of_type_JavaUtilList.get(0), this.jdField_a_of_type_JavaLangString, this.h);
    }
    if ((this.g + 1 < this.jdField_a_of_type_JavaUtilList.size()) && (bdee.h(BaseApplicationImpl.getContext())) && (bjxj.u(BaseApplicationImpl.getApplication().getRuntime()))) {
      a((VideoInfo)this.jdField_a_of_type_JavaUtilList.get(this.g + 1));
    }
    p();
  }
  
  public void b(rfs paramrfs, boolean paramBoolean) {}
  
  public void c()
  {
    nrt.a(null, null, "0X8009A2C", "0X8009A2C", 0, 0, "", "", null, a().a().a(), false);
  }
  
  public void c(rfs paramrfs)
  {
    this.jdField_c_of_type_Boolean = true;
    if (this.f == 0)
    {
      l();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFloatWindowDragLayout.a();
    }
  }
  
  public void d()
  {
    if (this.jdField_e_of_type_Int == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsFloatWindowManager", 2, "show: ");
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFloatWindowDragLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.e();
      rlf.a().a(true, "float window video");
      i();
      this.jdField_e_of_type_Int = 1;
    }
  }
  
  public void d(rfs paramrfs) {}
  
  public void e()
  {
    if (this.jdField_e_of_type_Int == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsFloatWindowManager", 2, "hide: ");
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFloatWindowDragLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.f();
      rlf.a().a(false, "float window video");
      this.jdField_e_of_type_Int = 2;
    }
  }
  
  public void e(rfs paramrfs) {}
  
  public void f()
  {
    if (this.jdField_e_of_type_Int != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsFloatWindowManager", 2, "dismiss: ");
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.g();
      this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFloatWindowDragLayout);
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = null;
      this.jdField_a_of_type_AndroidViewWindowManager = null;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = null;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFloatWindowDragLayout = null;
      this.jdField_a_of_type_AndroidWidgetFrameLayout = null;
      this.jdField_a_of_type_AndroidWidgetImageView = null;
      this.jdField_a_of_type_AndroidViewViewGroup = null;
      this.jdField_a_of_type_Rch = null;
      this.jdField_a_of_type_JavaUtilList = null;
      this.jdField_a_of_type_JavaUtilHashSet = null;
      this.jdField_a_of_type_Rfs = null;
      this.jdField_b_of_type_Rfs = null;
      this.jdField_c_of_type_Rfs = null;
      this.g = 0;
      this.jdField_a_of_type_Boolean = true;
      this.h = 0;
      this.jdField_a_of_type_JavaLangString = null;
      this.jdField_b_of_type_Boolean = false;
      this.i = 0;
      k();
      this.jdField_e_of_type_Int = 0;
      this.jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_Rcw = null;
    }
  }
  
  public void f(rfs paramrfs) {}
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
  }
  
  public void h()
  {
    if (this.jdField_e_of_type_Int == 0) {}
    do
    {
      return;
      c(1);
      f();
    } while (!QLog.isColorLevel());
    QLog.d("VideoFeedsFloatWindowManager", 2, "onDismissFloatingWindow");
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      nrt.a(null, null, "0X8009A2A", "0X8009A2A", 0, 0, "", "", null, a().a().a(), false);
      f();
      return;
      if ((ors.a() != null) && (ors.a().c()))
      {
        QQToast.a(BaseApplicationImpl.getContext(), ntg.jdField_a_of_type_JavaLangString, 0).a();
        return;
      }
    } while ((this.jdField_b_of_type_Rfs == null) || (this.jdField_b_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null));
    paramView = a();
    m();
    nrt.a(null, null, "0X8009A29", "0X8009A29", 0, 0, "", "", null, paramView.a().a(), false);
  }
  
  public boolean onLongClick(View paramView)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rcp
 * JD-Core Version:    0.7.0.1
 */