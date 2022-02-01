import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler.1;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler.11;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler.2;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler.5;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler.6;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler.7;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler.8;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

public class qdc
  extends qcu
  implements Handler.Callback
{
  private static volatile boolean e;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private AnimationSet jdField_a_of_type_AndroidViewAnimationAnimationSet;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected VideoPreDownloadMgr a;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private oil jdField_a_of_type_Oil;
  public qdh a;
  private sfj jdField_a_of_type_Sfj;
  private sge jdField_a_of_type_Sge;
  protected spg a;
  protected spz a;
  private suw jdField_a_of_type_Suw;
  private sxm jdField_a_of_type_Sxm;
  protected boolean a;
  private int b;
  protected boolean b;
  protected boolean c;
  protected boolean d = true;
  private boolean f;
  private boolean g;
  private boolean h = true;
  
  private void A()
  {
    a().g();
  }
  
  private void B()
  {
    if (b() == 56) {
      pvj.a().a(56);
    }
  }
  
  private LinearLayout a()
  {
    if (plm.c(b())) {
      return this.jdField_a_of_type_AndroidWidgetLinearLayout;
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewStub.inflate());
    }
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  private BaseArticleInfo a(int paramInt)
  {
    return a().b(paramInt);
  }
  
  public static BaseArticleInfo a(qdc paramqdc, View paramView)
  {
    if ((paramqdc == null) || (paramView == null) || (!(paramView.getTag() instanceof qdh))) {
      return null;
    }
    paramView = (qdh)paramView.getTag();
    if (paramView != null) {
      return paramqdc.a(paramView.a());
    }
    return null;
  }
  
  public static qdh a(View paramView)
  {
    if ((paramView == null) || (!(paramView.getTag() instanceof qdh))) {
      return null;
    }
    return (qdh)paramView.getTag();
  }
  
  private spk a()
  {
    if (this.jdField_a_of_type_Spg != null) {
      return this.jdField_a_of_type_Spg.a();
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    a().setLayerType(2, null);
    this.jdField_a_of_type_AndroidWidgetTextView.setLayerType(2, null);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetTextView, View.ALPHA, new float[] { 0.0F, 1.0F });
    localObjectAnimator1.addListener(new qdg(this));
    localObjectAnimator1.setDuration(400L);
    localObjectAnimator1.setInterpolator(new LinearInterpolator());
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(a(), View.TRANSLATION_Y, new float[] { 0.0F, -paramInt });
    localObjectAnimator2.addListener(new qdd(this));
    localObjectAnimator2.setDuration(400L);
    this.jdField_a_of_type_ComTencentWidgetListView.setAlpha(0.0F);
    localObjectAnimator2.start();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    localObjectAnimator1.start();
  }
  
  public static void a(Context paramContext, ImageView paramImageView, spk paramspk)
  {
    if (paramImageView == null) {
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = paramImageView.getLayoutParams();
    localLayoutParams.width = ((int)pjr.a(paramContext, paramspk));
    paramImageView.setLayoutParams(localLayoutParams);
  }
  
  private void a(Intent paramIntent)
  {
    if ((b() == 0) && (!sqb.a.a())) {}
    label16:
    long l1;
    int i;
    spk localspk;
    do
    {
      do
      {
        break label16;
        do
        {
          return;
        } while (paramIntent == null);
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "onActivityResult for OPEN_FULLPLAY");
        }
        a().a().a(false);
        l1 = paramIntent.getLongExtra("VIDEO_PLAY_POSITION", -1L);
        i = paramIntent.getIntExtra("VIDEO_PLAY_STATUS", -1);
        if ((!this.jdField_a_of_type_Spg.d()) || (!this.jdField_a_of_type_Spg.c())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.readinjoy.video", 2, "onActivityResult video is pause  && isPausedByMannul, just return");
      return;
      localspk = this.jdField_a_of_type_Spg.a();
      if (localspk != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.video", 2, "onActivityResult getCurrentPlayVideoParam = null, just return");
    return;
    if (paramIntent.getExtras() != null) {}
    for (paramIntent = paramIntent.getExtras().getString("VIDEO_ARTICLE_ID");; paramIntent = null)
    {
      boolean bool;
      if (!TextUtils.equals(localspk.j, paramIntent))
      {
        paramIntent = b(paramIntent);
        if (paramIntent == null)
        {
          l1 = localspk.d;
          bool = false;
        }
      }
      for (;;)
      {
        if (b(i))
        {
          if (bool) {
            a(paramIntent);
          }
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.readinjoy.video", 2, "onActivityResult continue play, playResumeVideo:" + bool + ",startPosition:" + l1 + ",curPlayParam:" + localspk);
            }
            sqp.a().a(false, "readinoy video continuePlay", 1);
            return;
            if (paramIntent.jdField_a_of_type_Spk != null) {
              paramIntent.jdField_a_of_type_Spk.d = l1;
            }
            bool = true;
            break;
            if ((l1 >= 0L) && (localspk != null)) {
              this.jdField_a_of_type_Spg.a((int)l1, localspk);
            } else {
              this.jdField_a_of_type_Spg.f(true);
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "onActivityResult stop play, should not continue play");
        }
        if (this.jdField_a_of_type_Qdh == null) {
          break;
        }
        long l2 = this.jdField_a_of_type_Spg.a();
        this.jdField_a_of_type_Spg.b(4);
        paramIntent = this.jdField_a_of_type_Qdh.a();
        if (l1 > 0L) {
          l2 = l1;
        }
        paramIntent.d = l2;
        if (l1 > 0L) {
          this.jdField_a_of_type_Qdh.a().e = -1;
        }
        this.jdField_a_of_type_Qdh = null;
        return;
        paramIntent = null;
        bool = false;
      }
    }
  }
  
  public static void a(View paramView)
  {
    if (paramView == null) {}
    View localView2;
    do
    {
      return;
      View localView1 = null;
      if ((paramView.getTag() instanceof sxl)) {
        localView1 = ((sxl)paramView.getTag()).g;
      }
      localView2 = localView1;
      if (localView1 == null)
      {
        localView2 = localView1;
        if ((paramView.getTag(2131376239) instanceof sxl)) {
          localView2 = ((sxl)paramView.getTag(2131376239)).g;
        }
      }
    } while (localView2 == null);
    EventCollector.getInstance().onViewClicked(localView2);
  }
  
  private void a(View paramView, int paramInt)
  {
    if ((a() instanceof ReadInJoyChannelActivity)) {
      if ((this.c) && (paramView != null) && (paramInt > 0) && (paramInt <= 2))
      {
        if ((paramInt != 1) || (!this.d)) {
          break label105;
        }
        this.d = false;
        paramView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.videoanimation", 2, "adapter animation start at item position" + paramInt);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.videoanimation", 2, " judge adapter animation show or not：");
      }
      return;
      label105:
      if (paramInt == 2)
      {
        if (this.c) {
          this.c = false;
        }
        paramView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
      }
    }
  }
  
  private void a(AbsListView paramAbsListView)
  {
    qdh localqdh = a(paramAbsListView);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 4, "playVideoInArea:" + localqdh);
    }
    spk localspk;
    if (localqdh != null)
    {
      paramAbsListView = localqdh.a();
      localspk = this.jdField_a_of_type_Spg.a();
      if (paramAbsListView == this.jdField_a_of_type_Spg.jdField_a_of_type_Spk) {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "error state not play" + paramAbsListView.jdField_c_of_type_JavaLangString);
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((localspk != null) && (localspk.jdField_c_of_type_Long == paramAbsListView.jdField_c_of_type_Long) && (localspk.b == b()) && (!this.jdField_a_of_type_Spg.d()) && (!this.jdField_a_of_type_Spg.e()));
        sqp.a().b();
        a(localqdh);
      } while (!QLog.isColorLevel());
      QLog.d("Q.readinjoy.video", 2, "checkPlayableArea vid: " + paramAbsListView.jdField_c_of_type_JavaLangString);
      return;
      o();
    } while (this.jdField_a_of_type_Spg.a() == null);
    this.jdField_a_of_type_Spg.a().a(paramAbsListView);
    this.jdField_a_of_type_Spg.a().h();
  }
  
  private void a(sxl paramsxl)
  {
    if ((paramsxl == null) || (this.jdField_a_of_type_Sxm == null)) {}
    while (!paramsxl.a()) {
      return;
    }
    paramsxl.a(this.jdField_a_of_type_Sxm);
  }
  
  public static void b(View paramView)
  {
    if (paramView == null) {
      return;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  private void b(spk paramspk1, spk paramspk2)
  {
    spg localspg = this.jdField_a_of_type_Spg;
    if (paramspk1 != paramspk2)
    {
      if (((paramspk1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof ArticleInfo)) && ((paramspk2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof ArticleInfo))) {
        pvj.a().a(b(), (ArticleInfo)paramspk1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (ArticleInfo)paramspk2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      }
      this.jdField_a_of_type_ComTencentWidgetListView.clearFocus();
      this.jdField_a_of_type_ComTencentWidgetListView.postDelayed(new VideoHandler.5(this, paramspk1, localspg, paramspk2), 100L);
    }
    while (localspg.a() != 7) {
      return;
    }
    a(paramspk1);
  }
  
  private static boolean b(int paramInt)
  {
    return (paramInt == 3) || (paramInt == 0) || (paramInt == 4);
  }
  
  private boolean d()
  {
    if (!bmhv.a(c())) {}
    String str;
    do
    {
      do
      {
        do
        {
          return false;
        } while (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext));
        str = pqu.a(this.jdField_a_of_type_Long);
      } while (pqu.jdField_c_of_type_JavaLangString.equals(str));
      if (pqu.a.equals(str)) {
        return true;
      }
    } while (!pqu.b.equals(str));
    return sge.a(this.jdField_a_of_type_AndroidContentContext);
  }
  
  private boolean e()
  {
    boolean bool2 = false;
    ArticleInfo localArticleInfo = a();
    boolean bool1 = bool2;
    if (a() == null)
    {
      bool1 = bool2;
      if (localArticleInfo != null)
      {
        bool1 = bool2;
        if (a(0) != null)
        {
          bool1 = bool2;
          if (localArticleInfo.mArticleID == a(0).mArticleID) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private void t()
  {
    if (b() == 56)
    {
      sgg.a().a(true);
      sgg.a().a(0);
    }
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Sfj);
    if ((a() instanceof ReadInJoyChannelActivity)) {
      this.c = a().getIntent().getBooleanExtra("is_need_show_animation_adapter", false);
    }
    if ((a() instanceof ReadInJoyChannelActivity)) {
      this.jdField_a_of_type_Boolean = a().getIntent().getBooleanExtra("is_need_show_animation_translate", false);
    }
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet = ((AnimationSet)AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130772069));
    if (!six.c()) {
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setDuration(400L);
    }
    this.jdField_a_of_type_Sxm.a.add(this);
    ((ReadInJoyXListView)this.jdField_a_of_type_ComTencentWidgetListView).a(new sfo(this));
  }
  
  private void u()
  {
    if (!NetworkUtil.isWifiConnected(this.jdField_a_of_type_AndroidContentContext)) {}
    try
    {
      Object localObject = this.jdField_a_of_type_Spg.a();
      long l = ((spk)localObject).jdField_c_of_type_Long;
      localObject = a(((spk)localObject).jdField_a_of_type_Int);
      if ((localObject != null) && (l != ((BaseArticleInfo)localObject).mArticleID))
      {
        this.jdField_a_of_type_Spg.b(12);
        if (QLog.isColorLevel()) {
          QLog.e("Q.readinjoy.video", 2, "fixVideoPlayErrorState stopVideo videoVid:" + ((BaseArticleInfo)localObject).getVideoVid());
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.readinjoy.video", 2, "fixVideoPlayErrorState stopVideo throwable:" + localThrowable.getMessage());
    }
  }
  
  private void v()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a().findViewById(2131373864));
    if (plm.c(b()))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a().findViewById(2131373863));
      return;
    }
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a().findViewById(2131373862));
  }
  
  private void w()
  {
    this.jdField_a_of_type_Sge = sge.a();
    this.jdField_a_of_type_Sge.a(this.jdField_a_of_type_Long);
    if (b() == 56)
    {
      omx.jdField_a_of_type_Int = omx.a(a().getIntent().getIntExtra("channel_from", -1));
      this.jdField_a_of_type_ComTencentWidgetListView.setContentBackground(new ColorDrawable(-1));
    }
    if (a().a().a() != null)
    {
      a().a(a().a().a(), this.jdField_a_of_type_Sge);
      return;
    }
    l();
  }
  
  private void x()
  {
    boolean bool = a().getIntent().getBooleanExtra("is_need_show_animation_translate", false);
    ArticleInfo localArticleInfo = a().a();
    int i;
    if ((bool) && ((a() instanceof ReadInJoyChannelActivity)))
    {
      if (!this.h) {
        break label220;
      }
      i = ppe.a(localArticleInfo);
      if ((i != 6) && (i != 71)) {
        break label174;
      }
      this.jdField_b_of_type_Int = a().getIntent().getIntExtra("view_translation_animation_left", 0);
      this.jdField_a_of_type_Int = a().getIntent().getIntExtra("view_translation_animation_top", 0);
      pjh.a(a(), localArticleInfo, a(), (szc)a(), b(), this.jdField_b_of_type_Int, this.jdField_a_of_type_Int);
      a(this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      this.jdField_a_of_type_Oil = new oil(a());
      a().a(this.jdField_a_of_type_Oil);
      ThreadManager.executeOnSubThread(new VideoHandler.8(this));
      return;
      label174:
      if (i == 28)
      {
        i = bmhv.e(pkh.a());
        pjh.a(a(), localArticleInfo, a(), (szc)a(), b(), 0, i);
        a(i);
        continue;
        label220:
        i();
      }
    }
  }
  
  private void y()
  {
    ThreadManager.executeOnSubThread(new VideoHandler.11(this));
  }
  
  private void z()
  {
    boolean bool = a().a().a().getIntent().getBooleanExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", false);
    if ((c()) && (!bool) && ((!bmhv.l()) || ((a().a().a() instanceof ReadInJoyNewFeedsActivity))))
    {
      s();
      A();
    }
    if (((!bmhv.l()) || ((a().a().a() instanceof ReadInJoyNewFeedsActivity))) && (b() == 56)) {
      omx.jdField_a_of_type_Int = omx.a(a().getIntent().getIntExtra("channel_from", -1));
    }
  }
  
  public int a()
  {
    return 0;
  }
  
  public long a()
  {
    long l = 0L;
    if (this.jdField_a_of_type_Spg != null) {
      l = this.jdField_a_of_type_Spg.a();
    }
    return l;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = a(paramInt).intValue();
    Object localObject;
    tbs localtbs;
    if ((paramView == null) || (!(paramView.getTag() instanceof sxl)))
    {
      localObject = a(paramInt, paramView, paramViewGroup, i);
      paramView = ((sxl)localObject).a(paramInt, paramViewGroup);
      ((sxl)localObject).g = paramView;
      ((sxl)localObject).jdField_a_of_type_Int = paramInt;
      paramView.setTag(localObject);
      paramView.setTag(2131369656, a());
      paramViewGroup = new qlj(a(), a().a().a(), a(), a(), a().a(), a().a());
      paramView.setTag(2131381185, paramViewGroup);
      localtbs = new tbs(paramView);
      paramView.setTag(2131381188, localtbs);
    }
    BaseArticleInfo localBaseArticleInfo;
    for (;;)
    {
      localBaseArticleInfo = a(paramInt);
      ((sxl)localObject).a(a());
      if (localBaseArticleInfo != null) {
        break;
      }
      QLog.w("VideoHandler", 2, "article is null, return");
      return localtbs.a();
      localObject = (sxl)paramView.getTag();
      ((sxl)localObject).jdField_a_of_type_Int = paramInt;
      paramViewGroup = (qkv)paramView.getTag(2131381185);
      localtbs = (tbs)paramView.getTag(2131381188);
    }
    long l;
    if (i == 46)
    {
      l = System.currentTimeMillis();
      a().a((sxg)localObject, localBaseArticleInfo);
      uda.a("VideoHandler", String.valueOf(i), "getProteusNormalView.configTwoItemVideo", System.currentTimeMillis() - l);
    }
    for (;;)
    {
      localObject = null;
      if (paramInt < d() - 1) {
        localObject = (ArticleInfo)a(paramInt + 1);
      }
      localObject = new qhk(a(), (ArticleInfo)localBaseArticleInfo, i, b(), c(), paramInt, a(), d(), (ArticleInfo)localObject, a());
      paramView.setTag(2131381183, localObject);
      paramViewGroup.a(localtbs, (qfw)localObject, i);
      return localtbs.a();
      if (i == 4)
      {
        l = System.currentTimeMillis();
        a().a((sxh)localObject, localBaseArticleInfo, paramInt);
        uda.a("VideoHandler", String.valueOf(i), "getProteusNormalView.configVideoItemUI", System.currentTimeMillis() - l);
        if ((a() != null) && (a().a() != null) && (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo)))
        {
          localObject = (AdvertisementInfo)localBaseArticleInfo;
          a().a().a((AdvertisementInfo)localObject, a().a());
        }
      }
      else if (i == 70)
      {
        l = System.currentTimeMillis();
        a().a((sxn)localObject, localBaseArticleInfo, paramInt);
        uda.a("VideoHandler", String.valueOf(i), "getProteusNormalView.configWeishiGridTwoItemUI", System.currentTimeMillis() - l);
      }
      else if (i == 118)
      {
        a().a((sxf)localObject, localBaseArticleInfo, paramInt);
      }
      else if (i == 119)
      {
        a().a((sxh)localObject, localBaseArticleInfo, paramInt);
        localObject = (sxi)localObject;
        ((sxi)localObject).a(localBaseArticleInfo.mVideoColumnInfo);
        ((sxi)localObject).a(localBaseArticleInfo);
        ((sxi)localObject).f.setTag(localObject);
        ((sxi)localObject).l.setTag(localObject);
      }
      else if (i == 6)
      {
        a().a((sxe)localObject, localBaseArticleInfo, paramInt);
      }
      else if (i == 128)
      {
        a().a((sxd)localObject, localBaseArticleInfo, paramInt);
      }
    }
  }
  
  public ArticleInfo a()
  {
    return a().a();
  }
  
  public VideoPreDownloadMgr a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
  }
  
  public Boolean a()
  {
    if ((a() != null) && (a().a() != null) && (a().a().a()))
    {
      a().a().j();
      return Boolean.valueOf(true);
    }
    return super.a();
  }
  
  public qdh a()
  {
    return this.jdField_a_of_type_Qdh;
  }
  
  public qdh a(AbsListView paramAbsListView)
  {
    Object localObject;
    if ((!a().a()) || (this.jdField_a_of_type_Sge == null) || (paramAbsListView.getChildCount() <= 0))
    {
      localObject = null;
      return localObject;
    }
    int i = 0;
    label30:
    if (i < paramAbsListView.getChildCount())
    {
      View localView = paramAbsListView.getChildAt(i);
      if ((localView.getTag() instanceof qdh))
      {
        localObject = (qdh)localView.getTag();
        if (!((qdh)localObject).a(localView)) {}
      }
    }
    for (paramAbsListView = (AbsListView)localObject;; paramAbsListView = null)
    {
      localObject = paramAbsListView;
      if (paramAbsListView != null) {
        break;
      }
      localObject = paramAbsListView;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("Q.readinjoy.video", 2, "checkPlayableArea(): no item can auto play...");
      return paramAbsListView;
      i += 1;
      break label30;
    }
  }
  
  public sge a()
  {
    return this.jdField_a_of_type_Sge;
  }
  
  public spg a()
  {
    return this.jdField_a_of_type_Spg;
  }
  
  public spz a()
  {
    return this.jdField_a_of_type_Spz;
  }
  
  public suw a()
  {
    return this.jdField_a_of_type_Suw;
  }
  
  public sxh a(String paramString)
  {
    int j = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
    this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition();
    int i = Math.max(this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount(), j);
    int k;
    if (i < a().a().size() + this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount())
    {
      k = i - this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount();
      BaseArticleInfo localBaseArticleInfo = a(k);
      if ((4 == a(k).intValue()) && (localBaseArticleInfo != null) && (TextUtils.equals(localBaseArticleInfo.getInnerUniqueID(), paramString)))
      {
        int m = i - j;
        if ((m >= 0) && (m < this.jdField_a_of_type_ComTencentWidgetListView.getChildCount())) {
          paramString = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i - j);
        }
      }
    }
    for (;;)
    {
      if (paramString != null)
      {
        return (sxh)paramString.getTag();
        if ((k >= 0) && (k < a().a().size())) {
          paramString = a(k, null, this.jdField_a_of_type_ComTencentWidgetListView);
        }
      }
      else
      {
        return null;
        i += 1;
        break;
        return null;
      }
      paramString = null;
    }
  }
  
  public sxl a(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    paramView = a();
    switch (paramInt2)
    {
    default: 
      paramView = new sxh(paramView, this);
    }
    for (;;)
    {
      a(paramView);
      return paramView;
      paramView = new sxh(paramView, this);
      continue;
      paramView = new sxg(paramView, this);
      continue;
      paramView = new sxn(paramView, this);
      continue;
      paramView = new sxf(paramView, this);
      continue;
      paramView = new sxi(paramView, this);
      continue;
      paramView = new sxe(paramView, this);
      continue;
      paramView = new sxd(paramView, this);
    }
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Spg == null) {}
    do
    {
      return;
      switch (paramInt)
      {
      default: 
        return;
      case 0: 
        a(paramIntent);
        return;
      case 2: 
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "onActivityResult for REFRESH_EVENT_CHECK_PLAYAREA");
        }
        u();
        b(this.jdField_a_of_type_ComTencentWidgetListView, 50);
        QLog.d("gifvideo.VideoHandler", 2, "check shortcontent play");
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.video", 2, "do nothing!");
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (b() == 40677) {
      if ((paramInt == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramInt, paramBoolean);
      }
    }
    while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramInt, paramBoolean);
  }
  
  public void a(View paramView1, View paramView2, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    super.a(paramView1, paramView2, paramBaseArticleInfo, paramInt);
    a(paramView2, paramInt);
  }
  
  public void a(View paramView, ListView paramListView)
  {
    v();
    w();
    x();
    y();
  }
  
  public void a(View paramView, ListView paramListView, long paramLong)
  {
    this.jdField_a_of_type_Sfj = new sfj(this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Sxm = new sxm();
    this.f = bmhv.e();
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_AndroidContentContext = a();
    this.jdField_a_of_type_Suw = new suw(a());
    t();
    this.jdField_a_of_type_Long = paramLong;
    this.h = six.c();
  }
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView)
  {
    super.e();
    if ((a().a()) && (this.jdField_a_of_type_Sge != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "onDrawFinish checkplayable!");
      }
      if (this.jdField_a_of_type_Sge.b()) {
        this.jdField_a_of_type_Sxm.postDelayed(new VideoHandler.7(this), 1200L);
      }
    }
    else
    {
      return;
    }
    b(this.jdField_a_of_type_ComTencentWidgetListView, szd.jdField_b_of_type_Int);
  }
  
  public void a(qdh paramqdh)
  {
    this.jdField_a_of_type_Spg.b(2);
    this.jdField_a_of_type_Qdh = paramqdh;
    a().a().a(this.jdField_a_of_type_Qdh);
    this.jdField_a_of_type_Spg.a(paramqdh.a());
  }
  
  public void a(spg paramspg, sge paramsge)
  {
    this.jdField_a_of_type_Spg = paramspg;
    this.jdField_a_of_type_Sge = paramsge;
    if (sge.a(BaseApplicationImpl.getContext())) {
      this.jdField_a_of_type_Sge.b(true);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Spg != null) && (!a().e()))
      {
        l();
        this.jdField_a_of_type_Spg.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr);
        this.jdField_a_of_type_Spg.a(this.jdField_a_of_type_Sge);
        if (bmhv.a(c())) {
          this.jdField_a_of_type_Spg.a(0);
        }
      }
      return;
      this.jdField_a_of_type_Sge.b(false);
    }
  }
  
  public void a(spk paramspk)
  {
    this.jdField_a_of_type_Sxm.postDelayed(new VideoHandler.6(this, paramspk), 1000L);
  }
  
  public void a(spk paramspk, int paramInt)
  {
    if (this.jdField_a_of_type_Qdh != null) {}
    for (;;)
    {
      return;
      sxh localsxh = a(paramspk.j);
      if (localsxh != null)
      {
        this.jdField_a_of_type_Qdh = localsxh;
        paramspk.jdField_a_of_type_AndroidViewView = localsxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
      }
      while ((this.jdField_a_of_type_Spg != null) && (this.jdField_a_of_type_Spg.a() != null))
      {
        paramspk = this.jdField_a_of_type_Spg.a();
        if (QLog.isColorLevel()) {
          QLog.i("VideoHandler", 2, "notifyVideoPositionChanged:");
        }
        paramspk.g();
        return;
        if (QLog.isColorLevel()) {
          QLog.e("VideoHandler", 2, "fixNowPlayHolder failed videoPlayParam:" + paramspk + "    callSource:" + paramInt);
        }
      }
    }
  }
  
  public void a(spk paramspk, BaseArticleInfo paramBaseArticleInfo)
  {
    psu.a(paramspk, paramBaseArticleInfo, a());
  }
  
  public void a(spk paramspk1, spk paramspk2)
  {
    ReadInJoyBaseListViewGroup localReadInJoyBaseListViewGroup = a();
    if ((localReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)localReadInJoyBaseListViewGroup).a(paramspk1, paramspk2);
    }
    if (this.jdField_a_of_type_Long == 1002L)
    {
      int i = AIOUtils.dp2px(44.5F, a().getResources());
      int j = a().getResources().getDimensionPixelOffset(2131298776);
      a().setPadding(0, i + j, 0, 0);
    }
    b(paramspk1, paramspk2);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    s();
  }
  
  public boolean a(int paramInt)
  {
    return (paramInt == 4) || (paramInt == 46) || (paramInt == 70) || (paramInt == 118) || (paramInt == 119) || (paramInt == 6) || (paramInt == 128);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return (pqw.a(a(paramInt1))) && (b() == 56) && (this.f) && (paramInt2 == 4);
  }
  
  public sxh b(String paramString)
  {
    Object localObject2 = null;
    int j = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
    int k = this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition();
    int i = Math.max(this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount(), j);
    for (;;)
    {
      Object localObject1 = localObject2;
      if (i <= k)
      {
        int m = i - this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount();
        localObject1 = a(m);
        if ((localObject1 == null) || (4 != a(m).intValue()) || (!TextUtils.equals(((BaseArticleInfo)localObject1).innerUniqueID, paramString))) {
          break label122;
        }
        paramString = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i - j);
        localObject1 = localObject2;
        if (paramString != null) {
          localObject1 = (sxh)paramString.getTag();
        }
      }
      return localObject1;
      label122:
      i += 1;
    }
  }
  
  public void b()
  {
    super.b();
    this.g = true;
    m();
    z();
    B();
    ThreadManager.getUIHandler().postDelayed(new VideoHandler.1(this), 50L);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new VideoHandler.2(this), 1000L);
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramInt, paramBoolean);
    }
  }
  
  public void b(AbsListView paramAbsListView, int paramInt)
  {
    Object localObject = a(paramAbsListView);
    if (b() == 40677) {}
    label16:
    do
    {
      do
      {
        do
        {
          break label16;
          do
          {
            return;
          } while (((this.jdField_a_of_type_Spg != null) && (this.jdField_a_of_type_Spg.h())) || ((paramAbsListView.getFirstVisiblePosition() <= 5) && (!uje.a.a()) && ((ujj.a.a() == 1) || (ujj.a.a() == 2))));
          if (localObject == null) {
            break;
          }
          localObject = ((qdh)localObject).a();
        } while ((localObject != null) && (((spk)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (((spk)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.patchStatus.a.get() == 1));
      } while ((this.jdField_a_of_type_Spg == null) || (!this.jdField_a_of_type_Sge.a()) || (this.jdField_a_of_type_Sge.b()) || (paramAbsListView == null) || (paramAbsListView.getVisibility() != 0));
      this.jdField_a_of_type_Sxm.removeMessages(1001);
      this.jdField_a_of_type_Sxm.sendEmptyMessageDelayed(1001, paramInt);
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.video", 2, "checkPlayableArea delay: " + paramInt);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Spg.a(9, paramBoolean);
  }
  
  public boolean b()
  {
    return this.g;
  }
  
  public void c()
  {
    super.c();
    this.g = false;
    p();
    a().d();
    qcn.b(this.jdField_a_of_type_ComTencentWidgetListView);
  }
  
  public void c(AbsListView paramAbsListView, int paramInt)
  {
    if ((b() == 0) || (b() == 40677)) {}
    do
    {
      do
      {
        return;
      } while ((!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext)) || (this.jdField_a_of_type_Spg == null) || (paramAbsListView == null));
      this.jdField_a_of_type_Sxm.removeMessages(1001);
      this.jdField_a_of_type_Sxm.sendEmptyMessageDelayed(1001, paramInt);
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.video", 2, "force checkPlayableArea delay: " + paramInt);
  }
  
  public boolean c()
  {
    return a().a();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Sxm != null)
    {
      this.jdField_a_of_type_Sxm.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Sxm.a.clear();
    }
    if (this.jdField_a_of_type_Oil != null) {
      this.jdField_a_of_type_Oil.a();
    }
  }
  
  public void e()
  {
    super.e();
    QQAppInterface localQQAppInterface = pnn.a();
    if ((localQQAppInterface != null) && (!e))
    {
      e = true;
      ((avux)localQQAppInterface.getManager(QQManagerFactory.NOW_DYNAMIC_MANAGER)).a();
    }
  }
  
  public void f()
  {
    if (a() != null) {
      qcn.a((ListView)a(), true);
    }
  }
  
  public void g()
  {
    super.g();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "notifyDataSetChanged");
    }
    spk localspk;
    int i;
    if (this.jdField_a_of_type_Spg != null)
    {
      localspk = this.jdField_a_of_type_Spg.a();
      if (((this.jdField_a_of_type_Qdh != null) || (localspk != null)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null))
      {
        int j = -1;
        i = j;
        if (this.jdField_a_of_type_Qdh != null)
        {
          i = j;
          if (this.jdField_a_of_type_Qdh.a() != null) {
            i = this.jdField_a_of_type_Qdh.a().jdField_a_of_type_Int;
          }
        }
        if (localspk == null) {
          break label114;
        }
        i = localspk.jdField_a_of_type_Int;
      }
    }
    label114:
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(i, true);
      return;
      localspk = null;
      break;
    }
  }
  
  public void h()
  {
    ReadInJoyBaseListViewGroup localReadInJoyBaseListViewGroup = a();
    if ((localReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)localReadInJoyBaseListViewGroup).p();
    }
    if (this.jdField_a_of_type_Long == 1002L) {
      a().setPadding(0, 0, 0, 0);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
      this.jdField_a_of_type_ComTencentWidgetListView.getGlobalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect);
    } while (!uks.a(this.jdField_a_of_type_AndroidGraphicsRect));
    if (this.jdField_a_of_type_Boolean) {
      if (this.jdField_b_of_type_Boolean) {
        a(this.jdField_a_of_type_ComTencentWidgetListView);
      }
    }
    for (;;)
    {
      return true;
      if (QLog.isColorLevel())
      {
        QLog.w("VideoHandler", 2, "MSG_FOR_CHECK_PLAYAREA, 平移转场动画未做完，不触发自动播放");
        continue;
        a(this.jdField_a_of_type_ComTencentWidgetListView);
      }
    }
  }
  
  public void i()
  {
    this.jdField_b_of_type_Boolean = true;
    if ((this.jdField_a_of_type_Spg != null) && ((e()) || (this.jdField_a_of_type_Sge.a())) && (!this.jdField_a_of_type_Sge.b()) && (this.jdField_a_of_type_ComTencentWidgetListView != null) && (this.jdField_a_of_type_ComTencentWidgetListView.getVisibility() == 0))
    {
      this.jdField_a_of_type_Sxm.removeMessages(1001);
      this.jdField_a_of_type_Sxm.sendEmptyMessage(1001);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "checkPlayableArea after transAnim: ");
      }
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Sge != null) {
      this.jdField_a_of_type_Sge.a(false);
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_Spg != null) {
      this.jdField_a_of_type_Spg.a(new qde(this));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("VideoHandler", 2, "mVideoPlayManager == null");
  }
  
  public void l()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = new VideoPreDownloadMgr(BaseApplicationImpl.getContext());
    VideoPreDownloadMgr localVideoPreDownloadMgr = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
    if (b() == 56) {}
    for (int i = spx.jdField_b_of_type_Int;; i = spx.jdField_a_of_type_Int)
    {
      localVideoPreDownloadMgr.a = new spx(i, spx.f);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(new qdf(this));
      return;
    }
  }
  
  public void m()
  {
    if ((a().a().f()) && (this.jdField_a_of_type_ComTencentWidgetListView != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.b();
      int j = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
      int i = j;
      if (j >= d()) {
        i = 0;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(i);
      a().a().b(false);
    }
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = null;
    }
  }
  
  public void o()
  {
    this.jdField_a_of_type_Spg.b(9);
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Sxm != null) {
      this.jdField_a_of_type_Sxm.removeMessages(1001);
    }
  }
  
  public void p()
  {
    if (this.jdField_a_of_type_Spg != null) {
      this.jdField_a_of_type_Spg.b();
    }
  }
  
  public void q()
  {
    this.jdField_a_of_type_Sxm.removeMessages(1001);
  }
  
  public void r()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoHandler", 2, "clearData " + this.jdField_a_of_type_Sfj);
    }
    if (this.jdField_a_of_type_Suw != null) {
      this.jdField_a_of_type_Suw.a();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_Sfj);
  }
  
  public void s()
  {
    spg localspg = a().a().a();
    if ((localspg != null) && (localspg.a() != null)) {
      localspg.b(11);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qdc
 * JD-Core Version:    0.7.0.1
 */