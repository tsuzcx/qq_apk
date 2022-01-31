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
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class qnl
  implements View.OnClickListener, View.OnLongClickListener, qni, qqn, qvp
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
  private ArrayList<qyz> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashSet<String> jdField_a_of_type_JavaUtilHashSet;
  private List<VideoInfo> jdField_a_of_type_JavaUtilList;
  private nps jdField_a_of_type_Nps;
  private npt jdField_a_of_type_Npt;
  private osm jdField_a_of_type_Osm;
  private qnd jdField_a_of_type_Qnd;
  private qno jdField_a_of_type_Qno;
  private qns jdField_a_of_type_Qns;
  private qql jdField_a_of_type_Qql;
  private boolean jdField_a_of_type_Boolean;
  private qql jdField_b_of_type_Qql;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private qql jdField_c_of_type_Qql;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = 0;
  private boolean jdField_e_of_type_Boolean;
  private int f;
  private int g;
  private int h;
  private int i;
  
  private qnl()
  {
    jdField_a_of_type_Int = bbll.a(100.0F);
    jdField_b_of_type_Int = bbll.a(128.0F);
    this.jdField_c_of_type_Int = bbll.a(54.0F);
    this.jdField_d_of_type_Int = bbll.a(6.0F);
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
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842527);
    int j = baxn.a(paramContext, 24.0F);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(j, j);
    localLayoutParams.gravity = 5;
    j = baxn.a(paramContext, 3.0F);
    localLayoutParams.topMargin = j;
    localLayoutParams.rightMargin = j;
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130842366);
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(paramContext);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(0);
    localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 85;
    this.jdField_a_of_type_Qnd = new qnd(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    this.jdField_a_of_type_Qnd.a(paramContext, this.jdField_a_of_type_AndroidWidgetFrameLayout);
    this.jdField_a_of_type_AndroidViewViewGroup = this.jdField_a_of_type_Qnd.jdField_a_of_type_AndroidWidgetFrameLayout;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView);
    localVideoFeedsFloatWindowDragLayout.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, localLayoutParams);
    return localVideoFeedsFloatWindowDragLayout;
  }
  
  public static final qnl a()
  {
    return qnt.a();
  }
  
  private qql a(VideoInfo paramVideoInfo)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_Qql != null)
    {
      qql localqql2 = this.jdField_a_of_type_Qql;
      this.jdField_a_of_type_Qql = null;
      localqql1 = localqql2;
      if (QLog.isColorLevel())
      {
        QLog.d("VideoFeedsFloatWindowManager", 2, "generateVideoPlayParam: use scrapParams");
        localqql1 = localqql2;
      }
      localqql1.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
      return localqql1;
    }
    qql localqql1 = new qql();
    localqql1.jdField_a_of_type_Qjs = this.jdField_a_of_type_Qnd;
    localqql1.jdField_a_of_type_AndroidViewViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
    if (this.f == 1) {}
    for (;;)
    {
      localqql1.jdField_b_of_type_Boolean = bool;
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsFloatWindowManager", 2, "generateVideoPlayParam: create new params");
      }
      break;
      bool = false;
    }
  }
  
  private qzb a()
  {
    long l2 = 0L;
    if ((this.jdField_b_of_type_Qql != null) && (this.jdField_b_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
    {
      qzb localqzb1 = new qzb(this.jdField_b_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      qty localqty = this.jdField_b_of_type_Qql.jdField_a_of_type_Qty;
      qzb localqzb2 = localqzb1.h(this.jdField_b_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g);
      if (localqty != null)
      {
        l1 = localqty.a(this.jdField_c_of_type_Boolean);
        localqzb2 = localqzb2.d(l1);
        if (localqty == null) {
          break label131;
        }
      }
      label131:
      for (long l1 = localqty.a();; l1 = 0L)
      {
        localqzb2 = localqzb2.a(l1);
        l1 = l2;
        if (localqty != null) {
          l1 = localqty.b();
        }
        localqzb2.c(l1);
        return localqzb1;
        l1 = 0L;
        break;
      }
    }
    return new qzb((VideoInfo)null);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    int[] arrayOfInt = a(paramInt1, paramInt2);
    localLayoutParams.width = arrayOfInt[0];
    localLayoutParams.height = arrayOfInt[1];
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_Qnd.a(localLayoutParams.width, localLayoutParams.height);
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
    this.jdField_c_of_type_Qql = paramVideoInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b(paramVideoInfo);
  }
  
  private void a(VideoInfo paramVideoInfo, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsFloatWindowManager", 2, "playVideo: index=" + this.g + ", videoInfo: " + paramVideoInfo.jdField_a_of_type_JavaLangString);
    }
    qql localqql2 = this.jdField_b_of_type_Qql;
    if (localqql2 != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d();
    }
    a(paramVideoInfo.jdField_b_of_type_Int, paramVideoInfo.jdField_c_of_type_Int);
    if ((this.jdField_c_of_type_Qql != null) && (this.jdField_c_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == paramVideoInfo))
    {
      qql localqql1 = this.jdField_c_of_type_Qql;
      paramVideoInfo = localqql1;
      if (QLog.isColorLevel())
      {
        QLog.d("VideoFeedsFloatWindowManager", 2, "playVideo: hit preplay");
        paramVideoInfo = localqql1;
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Qql = paramVideoInfo;
      this.jdField_a_of_type_Qql = localqql2;
      this.jdField_c_of_type_Boolean = false;
      if ((onh.a() == null) || (onh.a().c())) {
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
  
  private void a(VideoInfo paramVideoInfo1, VideoInfo paramVideoInfo2, List<qyz> paramList, qbu paramqbu, long paramLong, int paramInt)
  {
    if (paramVideoInfo1 != null)
    {
      String str2 = paramVideoInfo1.j;
      String str1 = paramVideoInfo1.g;
      int m = onh.e();
      int n = npu.a();
      int i1 = paramList.size();
      int k = 0;
      if (k < i1)
      {
        Object localObject1 = (qyz)paramList.get(k);
        if (QLog.isColorLevel()) {
          QLog.d("VideoFeedsFloatWindowManager", 2, "播放VV上报 totalPlayTime = " + ((qyz)localObject1).jdField_a_of_type_Long + ", currentPlayTime = " + ((qyz)localObject1).b);
        }
        int j;
        label135:
        Object localObject2;
        if ((((qyz)localObject1).b != 0L) || (((qyz)localObject1).jdField_a_of_type_Long != 0L))
        {
          if (k != 0) {
            break label618;
          }
          j = 0;
          localObject2 = new qzb(paramVideoInfo1).d(((qyz)localObject1).jdField_a_of_type_Long).a(((qyz)localObject1).b).z(j).A(i1 - 1).C(paramqbu.l).B(paramqbu.k).E(paramqbu.j).D(paramqbu.i).c(paramLong).m(paramInt).a(409409).a(Boolean.valueOf(paramVideoInfo1.jdField_b_of_type_Boolean));
          if (paramVideoInfo1.N == null) {
            break label638;
          }
          localObject1 = paramVideoInfo1.N;
          label244:
          localObject1 = ((qzb)localObject2).a((String)localObject1).d(paramVideoInfo1.jdField_c_of_type_Boolean).q(n).r(m).e(paramVideoInfo1.f).d(paramVideoInfo1.r).L(paramVideoInfo1.o).g(paramVideoInfo2.g).i(true).w(this.i);
          if (!paramVideoInfo1.e()) {
            break label646;
          }
          j = 2;
          label319:
          localObject1 = ((qzb)localObject1).Z(j);
          if (!paramVideoInfo1.e()) {
            break label652;
          }
          j = paramVideoInfo1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Int;
          label344:
          localObject1 = ((qzb)localObject1).u(j);
          if ((!paramVideoInfo1.e()) || (TextUtils.isEmpty(paramVideoInfo1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.g)) || (TextUtils.isEmpty(paramVideoInfo1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.f))) {
            break label658;
          }
          j = 1;
          label389:
          localObject2 = ((qzb)localObject1).aa(j);
          if ((!paramVideoInfo1.e()) || (paramVideoInfo1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo == null)) {
            break label664;
          }
          localObject1 = paramVideoInfo1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e;
          label427:
          localObject2 = ((qzb)localObject2).o((String)localObject1);
          if ((!paramVideoInfo1.e()) || (paramVideoInfo1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.d == null)) {
            break label672;
          }
          localObject1 = paramVideoInfo1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.d.e;
          label465:
          localObject1 = ((qzb)localObject2).p((String)localObject1).h(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.f).O(0);
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "play video [video_from_type : " + this.i + ", first_video_row_key : " + paramVideoInfo2.g + "]");
          }
          localObject2 = ((qzb)localObject1).a().a();
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
          nol.b(null, str2, "0X8007409", "0X8007409", 0, 0, "", "", (String)localObject1, (String)localObject2, false);
          nol.a("0X8007409", str2, "", "", "", (String)localObject2);
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
    if ((this.jdField_a_of_type_Qns != null) && (!this.jdField_a_of_type_Qns.hasMessages(paramInt))) {
      this.jdField_a_of_type_Qns.sendEmptyMessageDelayed(paramInt, 3500L);
    }
  }
  
  private void b(List<VideoInfo> paramList, @Nullable Bundle paramBundle)
  {
    long l = 0L;
    boolean bool = true;
    if (paramBundle != null) {
      this.i = paramBundle.getInt("VIDEO_FROM_TYPE");
    }
    this.f = bhvy.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = new VideoFeedsPlayManager(BaseApplicationImpl.getContext(), onh.a());
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
    if ((this.jdField_a_of_type_Qns != null) && (this.jdField_a_of_type_Qns.hasMessages(paramInt))) {
      this.jdField_a_of_type_Qns.removeMessages(paramInt);
    }
  }
  
  private boolean c(Activity paramActivity)
  {
    return (paramActivity == BaseActivity.sTopActivity) && (this.jdField_a_of_type_Boolean);
  }
  
  private void i()
  {
    nol.a(null, null, "0X8009A28", "0X8009A28", 0, 0, "", "", null, a().a().a(), false);
  }
  
  private void j()
  {
    if (this.f == 0)
    {
      localObject = onh.a();
      if (localObject != null)
      {
        this.jdField_a_of_type_Nps = ((nps)((QQAppInterface)localObject).a(90));
        if (this.jdField_a_of_type_Npt == null) {
          this.jdField_a_of_type_Npt = new qnq(this, null);
        }
        ((QQAppInterface)localObject).addObserver(this.jdField_a_of_type_Npt);
      }
    }
    if (this.jdField_a_of_type_Osm == null) {
      this.jdField_a_of_type_Osm = new qnr(this, null);
    }
    osj.a().a(this.jdField_a_of_type_Osm);
    qvo.a().a(Integer.toHexString(System.identityHashCode(this)));
    qvo.a().a(this);
    qvo.a().a(true, "float window video");
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      if (this.jdField_a_of_type_Qno == null) {
        this.jdField_a_of_type_Qno = new qno(this, null);
      }
      ((BaseApplicationImpl)localObject).registerActivityLifecycleCallbacks(this.jdField_a_of_type_Qno);
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = new qnp(this, null);
      }
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("tencent.av.v2q.StopVideoChat");
      localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
      ((BaseApplicationImpl)localObject).registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_Nps = null;
    qvo.a().b(Integer.toHexString(System.identityHashCode(this)));
    qvo.a().b(this);
    qvo.a().a(false, "float window video");
    if (this.jdField_a_of_type_Osm != null) {
      osj.a().b(this.jdField_a_of_type_Osm);
    }
    Object localObject = onh.a();
    if ((localObject != null) && (this.jdField_a_of_type_Npt != null)) {
      ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Npt);
    }
    localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      if (this.jdField_a_of_type_Qno != null) {
        ((BaseApplicationImpl)localObject).unregisterActivityLifecycleCallbacks(this.jdField_a_of_type_Qno);
      }
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
        ((BaseApplicationImpl)localObject).unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      }
    }
    this.jdField_a_of_type_Qno = null;
    this.jdField_a_of_type_Osm = null;
    this.jdField_a_of_type_Npt = null;
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
    if (this.jdField_c_of_type_Qql != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c(this.jdField_c_of_type_Qql);
      if (this.jdField_c_of_type_Qql.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_c_of_type_Qql.jdField_a_of_type_AndroidViewView);
      }
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(-16777216);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    o();
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = ((int)bbdh.i());
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = ((int)bbdh.j());
    this.jdField_a_of_type_AndroidViewWindowManager.updateViewLayout(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFloatWindowDragLayout, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
    n();
  }
  
  private void n()
  {
    qoi.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFloatWindowDragLayout, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_AndroidViewWindowManager, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams, new qnn(this));
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
      osj.a().l();
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
      this.jdField_a_of_type_Qns = new qns(this, null);
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
  
  public void a(qql paramqql) {}
  
  public void a(qql paramqql, int paramInt)
  {
    if ((paramqql != null) && (paramqql.jdField_a_of_type_Qty != null))
    {
      qyz localqyz = new qyz();
      localqyz.jdField_a_of_type_Long = paramqql.jdField_a_of_type_Qty.a(true);
      localqyz.b = paramqql.jdField_a_of_type_Qty.b();
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsFloatWindowManager", 2, "mPlayInfoListForReport add detailInfo.totalPlayTime = " + localqyz.jdField_a_of_type_Long + ", detailInfo.currentPlayTime = " + localqyz.b);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(localqyz);
    }
  }
  
  public void a(qql paramqql, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(qql paramqql, boolean paramBoolean)
  {
    VideoInfo localVideoInfo1 = paramqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    VideoInfo localVideoInfo2 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    long l2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
    Object localObject = new qyz();
    if (paramBoolean) {}
    for (long l1 = paramqql.jdField_a_of_type_Qty.b();; l1 = paramqql.jdField_a_of_type_Qty.a())
    {
      ((qyz)localObject).b = l1;
      ((qyz)localObject).jdField_a_of_type_Long = paramqql.jdField_a_of_type_Qty.a(paramBoolean);
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      localObject = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      ThreadManager.excute(new VideoFeedsFloatWindowManager.3(this, localVideoInfo1, localVideoInfo2, (List)localObject, paramqql.jdField_a_of_type_Qbu, l2, this.g), 16, null, true);
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
  
  public void b(qql paramqql)
  {
    if ((this.f == 0) && (b())) {
      this.jdField_a_of_type_Nps.a(this.jdField_a_of_type_Npt, this.i, (VideoInfo)this.jdField_a_of_type_JavaUtilList.get(0), this.jdField_a_of_type_JavaLangString, this.h);
    }
    if ((this.g + 1 < this.jdField_a_of_type_JavaUtilList.size()) && (bbfj.h(BaseApplicationImpl.getContext())) && (bhvy.t(BaseApplicationImpl.getApplication().getRuntime()))) {
      a((VideoInfo)this.jdField_a_of_type_JavaUtilList.get(this.g + 1));
    }
    p();
  }
  
  public void c()
  {
    nol.a(null, null, "0X8009A2C", "0X8009A2C", 0, 0, "", "", null, a().a().a(), false);
  }
  
  public void c(qql paramqql)
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
      qvo.a().a(true, "float window video");
      i();
      this.jdField_e_of_type_Int = 1;
    }
  }
  
  public void d(qql paramqql) {}
  
  public void e()
  {
    if (this.jdField_e_of_type_Int == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsFloatWindowManager", 2, "hide: ");
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFloatWindowDragLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.f();
      qvo.a().a(false, "float window video");
      this.jdField_e_of_type_Int = 2;
    }
  }
  
  public void e(qql paramqql) {}
  
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
      this.jdField_a_of_type_Qnd = null;
      this.jdField_a_of_type_JavaUtilList = null;
      this.jdField_a_of_type_JavaUtilHashSet = null;
      this.jdField_a_of_type_Qql = null;
      this.jdField_b_of_type_Qql = null;
      this.jdField_c_of_type_Qql = null;
      this.g = 0;
      this.jdField_a_of_type_Boolean = true;
      this.h = 0;
      this.jdField_a_of_type_JavaLangString = null;
      this.jdField_b_of_type_Boolean = false;
      this.i = 0;
      k();
      this.jdField_e_of_type_Int = 0;
      this.jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_Qns = null;
    }
  }
  
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
      nol.a(null, null, "0X8009A2A", "0X8009A2A", 0, 0, "", "", null, a().a().a(), false);
      f();
      return;
      if ((onh.a() != null) && (onh.a().c()))
      {
        bcql.a(BaseApplicationImpl.getContext(), npx.jdField_a_of_type_JavaLangString, 0).a();
        return;
      }
    } while ((this.jdField_b_of_type_Qql == null) || (this.jdField_b_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null));
    paramView = a();
    m();
    nol.a(null, null, "0X8009A29", "0X8009A29", 0, 0, "", "", null, paramView.a().a(), false);
  }
  
  public boolean onLongClick(View paramView)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qnl
 * JD-Core Version:    0.7.0.1
 */