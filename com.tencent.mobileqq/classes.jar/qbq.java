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

public class qbq
  implements View.OnClickListener, View.OnLongClickListener, qbn, qes, qjn
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
  private ArrayList<qmt> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashSet<String> jdField_a_of_type_JavaUtilHashSet;
  private List<VideoInfo> jdField_a_of_type_JavaUtilList;
  private neu jdField_a_of_type_Neu;
  private nev jdField_a_of_type_Nev;
  private ohe jdField_a_of_type_Ohe;
  private qbi jdField_a_of_type_Qbi;
  private qbt jdField_a_of_type_Qbt;
  private qbx jdField_a_of_type_Qbx;
  private qeq jdField_a_of_type_Qeq;
  private boolean jdField_a_of_type_Boolean;
  private qeq jdField_b_of_type_Qeq;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private qeq jdField_c_of_type_Qeq;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = 0;
  private boolean jdField_e_of_type_Boolean;
  private int f;
  private int g;
  private int h;
  private int i;
  
  private qbq()
  {
    jdField_a_of_type_Int = bajq.a(100.0F);
    jdField_b_of_type_Int = bajq.a(128.0F);
    this.jdField_c_of_type_Int = bajq.a(54.0F);
    this.jdField_d_of_type_Int = bajq.a(6.0F);
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
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842452);
    int j = azvv.a(paramContext, 24.0F);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(j, j);
    localLayoutParams.gravity = 5;
    j = azvv.a(paramContext, 3.0F);
    localLayoutParams.topMargin = j;
    localLayoutParams.rightMargin = j;
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130842282);
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(paramContext);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(0);
    localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 85;
    this.jdField_a_of_type_Qbi = new qbi(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    this.jdField_a_of_type_Qbi.a(paramContext, this.jdField_a_of_type_AndroidWidgetFrameLayout);
    this.jdField_a_of_type_AndroidViewViewGroup = this.jdField_a_of_type_Qbi.jdField_a_of_type_AndroidWidgetFrameLayout;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView);
    localVideoFeedsFloatWindowDragLayout.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, localLayoutParams);
    return localVideoFeedsFloatWindowDragLayout;
  }
  
  public static final qbq a()
  {
    return qby.a();
  }
  
  private qeq a(VideoInfo paramVideoInfo)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_Qeq != null)
    {
      qeq localqeq2 = this.jdField_a_of_type_Qeq;
      this.jdField_a_of_type_Qeq = null;
      localqeq1 = localqeq2;
      if (QLog.isColorLevel())
      {
        QLog.d("VideoFeedsFloatWindowManager", 2, "generateVideoPlayParam: use scrapParams");
        localqeq1 = localqeq2;
      }
      localqeq1.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
      return localqeq1;
    }
    qeq localqeq1 = new qeq();
    localqeq1.jdField_a_of_type_Pxw = this.jdField_a_of_type_Qbi;
    localqeq1.jdField_a_of_type_AndroidViewViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
    if (this.f == 1) {}
    for (;;)
    {
      localqeq1.jdField_b_of_type_Boolean = bool;
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsFloatWindowManager", 2, "generateVideoPlayParam: create new params");
      }
      break;
      bool = false;
    }
  }
  
  private qmv a()
  {
    long l2 = 0L;
    if ((this.jdField_b_of_type_Qeq != null) && (this.jdField_b_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
    {
      qmv localqmv1 = new qmv(this.jdField_b_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      qhw localqhw = this.jdField_b_of_type_Qeq.jdField_a_of_type_Qhw;
      qmv localqmv2 = localqmv1.h(this.jdField_b_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g);
      if (localqhw != null)
      {
        l1 = localqhw.a(this.jdField_c_of_type_Boolean);
        localqmv2 = localqmv2.d(l1);
        if (localqhw == null) {
          break label131;
        }
      }
      label131:
      for (long l1 = localqhw.a();; l1 = 0L)
      {
        localqmv2 = localqmv2.a(l1);
        l1 = l2;
        if (localqhw != null) {
          l1 = localqhw.b();
        }
        localqmv2.c(l1);
        return localqmv1;
        l1 = 0L;
        break;
      }
    }
    return new qmv((VideoInfo)null);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    int[] arrayOfInt = a(paramInt1, paramInt2);
    localLayoutParams.width = arrayOfInt[0];
    localLayoutParams.height = arrayOfInt[1];
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_Qbi.a(localLayoutParams.width, localLayoutParams.height);
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
    this.jdField_c_of_type_Qeq = paramVideoInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b(paramVideoInfo);
  }
  
  private void a(VideoInfo paramVideoInfo, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsFloatWindowManager", 2, "playVideo: index=" + this.g + ", videoInfo: " + paramVideoInfo.jdField_a_of_type_JavaLangString);
    }
    qeq localqeq2 = this.jdField_b_of_type_Qeq;
    if (localqeq2 != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d();
    }
    a(paramVideoInfo.jdField_b_of_type_Int, paramVideoInfo.jdField_c_of_type_Int);
    if ((this.jdField_c_of_type_Qeq != null) && (this.jdField_c_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == paramVideoInfo))
    {
      qeq localqeq1 = this.jdField_c_of_type_Qeq;
      paramVideoInfo = localqeq1;
      if (QLog.isColorLevel())
      {
        QLog.d("VideoFeedsFloatWindowManager", 2, "playVideo: hit preplay");
        paramVideoInfo = localqeq1;
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Qeq = paramVideoInfo;
      this.jdField_a_of_type_Qeq = localqeq2;
      this.jdField_c_of_type_Boolean = false;
      if ((obz.a() == null) || (obz.a().c())) {
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
  
  private void a(VideoInfo paramVideoInfo1, VideoInfo paramVideoInfo2, List<qmt> paramList, pqb parampqb, long paramLong, int paramInt)
  {
    if (paramVideoInfo1 != null)
    {
      String str2 = paramVideoInfo1.j;
      String str1 = paramVideoInfo1.g;
      int m = obz.e();
      int n = new.a();
      int i1 = paramList.size();
      int k = 0;
      if (k < i1)
      {
        Object localObject1 = (qmt)paramList.get(k);
        if (QLog.isColorLevel()) {
          QLog.d("VideoFeedsFloatWindowManager", 2, "播放VV上报 totalPlayTime = " + ((qmt)localObject1).jdField_a_of_type_Long + ", currentPlayTime = " + ((qmt)localObject1).b);
        }
        int j;
        label135:
        Object localObject2;
        if ((((qmt)localObject1).b != 0L) || (((qmt)localObject1).jdField_a_of_type_Long != 0L))
        {
          if (k != 0) {
            break label618;
          }
          j = 0;
          localObject2 = new qmv(paramVideoInfo1).d(((qmt)localObject1).jdField_a_of_type_Long).a(((qmt)localObject1).b).y(j).z(i1 - 1).B(parampqb.l).A(parampqb.k).D(parampqb.j).C(parampqb.i).c(paramLong).l(paramInt).a(409409).a(Boolean.valueOf(paramVideoInfo1.jdField_b_of_type_Boolean));
          if (paramVideoInfo1.N == null) {
            break label638;
          }
          localObject1 = paramVideoInfo1.N;
          label244:
          localObject1 = ((qmv)localObject2).a((String)localObject1).d(paramVideoInfo1.jdField_c_of_type_Boolean).p(n).q(m).e(paramVideoInfo1.f).c(paramVideoInfo1.r).K(paramVideoInfo1.o).g(paramVideoInfo2.g).i(true).v(this.i);
          if (!paramVideoInfo1.e()) {
            break label646;
          }
          j = 2;
          label319:
          localObject1 = ((qmv)localObject1).Y(j);
          if (!paramVideoInfo1.e()) {
            break label652;
          }
          j = paramVideoInfo1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Int;
          label344:
          localObject1 = ((qmv)localObject1).t(j);
          if ((!paramVideoInfo1.e()) || (TextUtils.isEmpty(paramVideoInfo1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.g)) || (TextUtils.isEmpty(paramVideoInfo1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.f))) {
            break label658;
          }
          j = 1;
          label389:
          localObject2 = ((qmv)localObject1).Z(j);
          if ((!paramVideoInfo1.e()) || (paramVideoInfo1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo == null)) {
            break label664;
          }
          localObject1 = paramVideoInfo1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e;
          label427:
          localObject2 = ((qmv)localObject2).o((String)localObject1);
          if ((!paramVideoInfo1.e()) || (paramVideoInfo1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.d == null)) {
            break label672;
          }
          localObject1 = paramVideoInfo1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.d.e;
          label465:
          localObject1 = ((qmv)localObject2).p((String)localObject1).h(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.f).N(0);
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "play video [video_from_type : " + this.i + ", first_video_row_key : " + paramVideoInfo2.g + "]");
          }
          localObject2 = ((qmv)localObject1).a().a();
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
          ndn.b(null, str2, "0X8007409", "0X8007409", 0, 0, "", "", (String)localObject1, (String)localObject2, false);
          ndn.a("0X8007409", str2, "", "", "", (String)localObject2);
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
    if ((this.jdField_a_of_type_Qbx != null) && (!this.jdField_a_of_type_Qbx.hasMessages(paramInt))) {
      this.jdField_a_of_type_Qbx.sendEmptyMessageDelayed(paramInt, 3500L);
    }
  }
  
  private void b(List<VideoInfo> paramList, @Nullable Bundle paramBundle)
  {
    long l = 0L;
    boolean bool = true;
    if (paramBundle != null) {
      this.i = paramBundle.getInt("VIDEO_FROM_TYPE");
    }
    this.f = bgmq.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = new VideoFeedsPlayManager(BaseApplicationImpl.getContext(), obz.a());
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
    if ((this.jdField_a_of_type_Qbx != null) && (this.jdField_a_of_type_Qbx.hasMessages(paramInt))) {
      this.jdField_a_of_type_Qbx.removeMessages(paramInt);
    }
  }
  
  private boolean c(Activity paramActivity)
  {
    return (paramActivity == BaseActivity.sTopActivity) && (this.jdField_a_of_type_Boolean);
  }
  
  private void i()
  {
    ndn.a(null, null, "0X8009A28", "0X8009A28", 0, 0, "", "", null, a().a().a(), false);
  }
  
  private void j()
  {
    if (this.f == 0)
    {
      localObject = obz.a();
      if (localObject != null)
      {
        this.jdField_a_of_type_Neu = ((neu)((QQAppInterface)localObject).a(90));
        if (this.jdField_a_of_type_Nev == null) {
          this.jdField_a_of_type_Nev = new qbv(this, null);
        }
        ((QQAppInterface)localObject).addObserver(this.jdField_a_of_type_Nev);
      }
    }
    if (this.jdField_a_of_type_Ohe == null) {
      this.jdField_a_of_type_Ohe = new qbw(this, null);
    }
    ohb.a().a(this.jdField_a_of_type_Ohe);
    qjm.a().a(Integer.toHexString(System.identityHashCode(this)));
    qjm.a().a(this);
    qjm.a().a(true, "float window video");
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      if (this.jdField_a_of_type_Qbt == null) {
        this.jdField_a_of_type_Qbt = new qbt(this, null);
      }
      ((BaseApplicationImpl)localObject).registerActivityLifecycleCallbacks(this.jdField_a_of_type_Qbt);
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = new qbu(this, null);
      }
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("tencent.av.v2q.StopVideoChat");
      localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
      ((BaseApplicationImpl)localObject).registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_Neu = null;
    qjm.a().b(Integer.toHexString(System.identityHashCode(this)));
    qjm.a().b(this);
    qjm.a().a(false, "float window video");
    if (this.jdField_a_of_type_Ohe != null) {
      ohb.a().b(this.jdField_a_of_type_Ohe);
    }
    Object localObject = obz.a();
    if ((localObject != null) && (this.jdField_a_of_type_Nev != null)) {
      ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Nev);
    }
    localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      if (this.jdField_a_of_type_Qbt != null) {
        ((BaseApplicationImpl)localObject).unregisterActivityLifecycleCallbacks(this.jdField_a_of_type_Qbt);
      }
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
        ((BaseApplicationImpl)localObject).unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      }
    }
    this.jdField_a_of_type_Qbt = null;
    this.jdField_a_of_type_Ohe = null;
    this.jdField_a_of_type_Nev = null;
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
    if (this.jdField_c_of_type_Qeq != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c(this.jdField_c_of_type_Qeq);
      if (this.jdField_c_of_type_Qeq.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_c_of_type_Qeq.jdField_a_of_type_AndroidViewView);
      }
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(-16777216);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    o();
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = ((int)babp.i());
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = ((int)babp.j());
    this.jdField_a_of_type_AndroidViewWindowManager.updateViewLayout(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFloatWindowDragLayout, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
    n();
  }
  
  private void n()
  {
    qcn.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFloatWindowDragLayout, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_AndroidViewWindowManager, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams, new qbs(this));
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
      ohb.a().l();
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
      this.jdField_a_of_type_Qbx = new qbx(this, null);
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
  
  public void a(qeq paramqeq) {}
  
  public void a(qeq paramqeq, int paramInt)
  {
    if ((paramqeq != null) && (paramqeq.jdField_a_of_type_Qhw != null))
    {
      qmt localqmt = new qmt();
      localqmt.jdField_a_of_type_Long = paramqeq.jdField_a_of_type_Qhw.a(true);
      localqmt.b = paramqeq.jdField_a_of_type_Qhw.b();
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsFloatWindowManager", 2, "mPlayInfoListForReport add detailInfo.totalPlayTime = " + localqmt.jdField_a_of_type_Long + ", detailInfo.currentPlayTime = " + localqmt.b);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(localqmt);
    }
  }
  
  public void a(qeq paramqeq, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(qeq paramqeq, boolean paramBoolean)
  {
    VideoInfo localVideoInfo1 = paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    VideoInfo localVideoInfo2 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    long l2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
    Object localObject = new qmt();
    if (paramBoolean) {}
    for (long l1 = paramqeq.jdField_a_of_type_Qhw.b();; l1 = paramqeq.jdField_a_of_type_Qhw.a())
    {
      ((qmt)localObject).b = l1;
      ((qmt)localObject).jdField_a_of_type_Long = paramqeq.jdField_a_of_type_Qhw.a(paramBoolean);
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      localObject = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      ThreadManager.excute(new VideoFeedsFloatWindowManager.3(this, localVideoInfo1, localVideoInfo2, (List)localObject, paramqeq.jdField_a_of_type_Pqb, l2, this.g), 16, null, true);
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
  
  public void b(qeq paramqeq)
  {
    if ((this.f == 0) && (b())) {
      this.jdField_a_of_type_Neu.a(this.jdField_a_of_type_Nev, this.i, (VideoInfo)this.jdField_a_of_type_JavaUtilList.get(0), this.jdField_a_of_type_JavaLangString, this.h);
    }
    if ((this.g + 1 < this.jdField_a_of_type_JavaUtilList.size()) && (badq.h(BaseApplicationImpl.getContext())) && (bgmq.s(BaseApplicationImpl.getApplication().getRuntime()))) {
      a((VideoInfo)this.jdField_a_of_type_JavaUtilList.get(this.g + 1));
    }
    p();
  }
  
  public void c()
  {
    ndn.a(null, null, "0X8009A2C", "0X8009A2C", 0, 0, "", "", null, a().a().a(), false);
  }
  
  public void c(qeq paramqeq)
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
      qjm.a().a(true, "float window video");
      i();
      this.jdField_e_of_type_Int = 1;
    }
  }
  
  public void d(qeq paramqeq) {}
  
  public void e()
  {
    if (this.jdField_e_of_type_Int == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsFloatWindowManager", 2, "hide: ");
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFloatWindowDragLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.f();
      qjm.a().a(false, "float window video");
      this.jdField_e_of_type_Int = 2;
    }
  }
  
  public void e(qeq paramqeq) {}
  
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
      this.jdField_a_of_type_Qbi = null;
      this.jdField_a_of_type_JavaUtilList = null;
      this.jdField_a_of_type_JavaUtilHashSet = null;
      this.jdField_a_of_type_Qeq = null;
      this.jdField_b_of_type_Qeq = null;
      this.jdField_c_of_type_Qeq = null;
      this.g = 0;
      this.jdField_a_of_type_Boolean = true;
      this.h = 0;
      this.jdField_a_of_type_JavaLangString = null;
      this.jdField_b_of_type_Boolean = false;
      this.i = 0;
      k();
      this.jdField_e_of_type_Int = 0;
      this.jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_Qbx = null;
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
      ndn.a(null, null, "0X8009A2A", "0X8009A2A", 0, 0, "", "", null, a().a().a(), false);
      f();
      return;
      if ((obz.a() != null) && (obz.a().c()))
      {
        bbmy.a(BaseApplicationImpl.getContext(), nez.jdField_a_of_type_JavaLangString, 0).a();
        return;
      }
    } while ((this.jdField_b_of_type_Qeq == null) || (this.jdField_b_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null));
    paramView = a();
    m();
    ndn.a(null, null, "0X8009A29", "0X8009A29", 0, 0, "", "", null, paramView.a().a(), false);
  }
  
  public boolean onLongClick(View paramView)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qbq
 * JD-Core Version:    0.7.0.1
 */