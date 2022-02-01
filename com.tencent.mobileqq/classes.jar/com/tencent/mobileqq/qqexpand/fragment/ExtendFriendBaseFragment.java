package com.tencent.mobileqq.qqexpand.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport;
import com.tencent.mobileqq.hotchat.ui.BaseFloatViewBuilder;
import com.tencent.mobileqq.hotchat.ui.FloatViewBuilderFactory;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qqexpand.bean.feed.StrangerInfo;
import com.tencent.mobileqq.qqexpand.bean.profile.ExtendFriendInfo;
import com.tencent.mobileqq.qqexpand.chat.ExtendFriendSendMsgHelper;
import com.tencent.mobileqq.qqexpand.config.ExpandConfig;
import com.tencent.mobileqq.qqexpand.entrance.IExpandFragmentRouter;
import com.tencent.mobileqq.qqexpand.feed.FaceFetch;
import com.tencent.mobileqq.qqexpand.feed.FeedBannerViewHolder.FeedBannerClickListener;
import com.tencent.mobileqq.qqexpand.feed.FeedViewHolder;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.qqexpand.network.IExpandHandler;
import com.tencent.mobileqq.qqexpand.utils.IExpandQuestionUtils;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qqexpand.utils.ProfileGuideDialogUtils;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.extras.PullToRefreshRecyclerView;
import com.tencent.mobileqq.qqexpand.widget.voice.ExpandVoicePlayer;
import com.tencent.mobileqq.qqexpand.widget.voice.ExpandVoicePlayer.ExtendFriendVoicePlayerListener;
import com.tencent.mobileqq.qqexpand.widget.voice.OldExpandVoiceView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.adv.extfriend.api.IVasAdExtendFriendApi;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.NearbyZanAnimLayout;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class ExtendFriendBaseFragment
  extends ExpandTabFragment
  implements Handler.Callback, DecodeTaskCompletionListener, FaceFetch, FeedBannerViewHolder.FeedBannerClickListener, SquareItemClickListener, ExpandVoicePlayer.ExtendFriendVoicePlayerListener
{
  private static boolean T = false;
  protected static final Object a = new Object();
  protected static final Object d = new Object();
  protected boolean A;
  protected QQToast B;
  protected String C;
  protected int D;
  protected Dialog E;
  protected int F;
  protected NearbyZanAnimLayout G;
  protected FloatViewBuilderFactory H;
  protected int I;
  protected int J;
  protected Dialog K;
  protected ActionSheet L;
  protected GdtAppReceiver M;
  protected String N = "推荐";
  protected long O;
  protected long P = 2L;
  protected boolean Q = false;
  protected String R = null;
  protected long S = -1L;
  private int U;
  private final ConcurrentHashMap<String, ExtendFriendBaseFragment.ExposureFeedInfo> V = new ConcurrentHashMap();
  private final Runnable W = new ExtendFriendBaseFragment.1(this);
  private final ExpandObserver X = new ExtendFriendBaseFragment.2(this);
  protected Map<ImageView, String> e;
  protected Map<String, Integer> f = new HashMap();
  protected IFaceDecoder g;
  protected QBaseActivity h;
  protected QQAppInterface i;
  protected CardHandler j;
  protected IExpandHandler k;
  protected IExpandManager l;
  protected RecyclerViewAdapter m;
  protected PullToRefreshRecyclerView n;
  protected LinearLayoutManager o;
  protected RecyclerView p;
  protected RecyclerView.AdapterDataObserver q;
  protected RecyclerViewItemDecoration r;
  protected WeakReferenceHandler s;
  protected ExpandVoicePlayer t;
  protected int u = -1;
  protected int v = -1;
  protected int w = -1;
  protected long x;
  protected boolean y;
  protected boolean z;
  
  private ArrayList<ExtendFriendBaseFragment.ExposureFeedInfo> r()
  {
    localArrayList = new ArrayList();
    try
    {
      int i1 = this.o.findFirstCompletelyVisibleItemPosition();
      int i2 = this.o.findLastCompletelyVisibleItemPosition();
      if ((i1 >= 0) && (i1 < this.o.getItemCount()) && (i2 >= 0) && (i2 < this.o.getItemCount()) && (i1 <= i2)) {
        while (i1 <= i2)
        {
          if (this.m.getItemViewType(i1) == 0)
          {
            StrangerInfo localStrangerInfo = this.m.b(i1);
            if (localStrangerInfo != null)
            {
              ExtendFriendBaseFragment.ExposureFeedInfo localExposureFeedInfo = new ExtendFriendBaseFragment.ExposureFeedInfo(null);
              localExposureFeedInfo.b = this.N;
              localExposureFeedInfo.c = i1;
              localExposureFeedInfo.d = localStrangerInfo;
              localArrayList.add(localExposureFeedInfo);
            }
          }
          i1 += 1;
        }
      }
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("ExtendFriendBaseFragment", 1, "findCurrentVisibleItems fail.", localThrowable);
    }
  }
  
  public Drawable a(String paramString1, String paramString2, ImageView paramImageView)
  {
    for (;;)
    {
      synchronized (a)
      {
        if (this.g != null)
        {
          localBitmap = this.g.getBitmapFromCache(1, paramString1);
          if (localBitmap == null)
          {
            if (!this.A)
            {
              if (paramImageView != null) {
                paramImageView.setTag(2131446778, paramString1);
              }
              if ((this.e != null) && (this.g != null))
              {
                this.g.requestDecodeFace(paramString1, 1, true);
                if (QLog.isColorLevel()) {
                  QLog.d("ExtendFriendBaseFragment", 2, String.format("requestDecodeFace uin=%s nick=%s", new Object[] { paramString1, paramString2 }));
                }
              }
              if ((this.e != null) && (paramImageView != null)) {
                this.e.put(paramImageView, paramString1);
              }
            }
          }
          else if ((this.e != null) && (paramImageView != null)) {
            this.e.remove(paramImageView);
          }
          paramString1 = localBitmap;
          if (localBitmap == null) {
            paramString1 = ImageUtil.k();
          }
          return new BitmapDrawable(paramString1);
        }
      }
      Bitmap localBitmap = null;
    }
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("onDownloadFailed errCode=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    ThreadManager.getUIHandler().post(new ExtendFriendBaseFragment.6(this));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("onFeedItemClick position=%s", new Object[] { Integer.valueOf(paramInt1) }));
    }
    StrangerInfo localStrangerInfo = this.m.b(paramInt1);
    if (localStrangerInfo != null)
    {
      ExtendFriendReport.a(this.i, localStrangerInfo.mStrRecomTrace);
      Object localObject = this.i;
      String str = localStrangerInfo.mUin;
      int i1 = paramInt1 + 1;
      ReportController.a((AppRuntime)localObject, "dc00898", "", str, "0X80092D0", "0X80092D0", 0, 0, "", String.valueOf(i1), ExtendFriendReport.a(localStrangerInfo.mStrRecomTrace), this.N);
      ReportController.a(this.i, "dc00898", "", localStrangerInfo.mUin, "0X8009C6F", "0X8009C6F", paramInt2, 0, "", String.valueOf(i1), ExtendFriendReport.a(localStrangerInfo.mStrRecomTrace), this.N);
      ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#voice_tab#profile_photo", true, -1L, -1L, null, true, true);
      localObject = new AllInOne(localStrangerInfo.mUin, 96);
      ((AllInOne)localObject).nickname = localStrangerInfo.mNickName;
      ((AllInOne)localObject).extendFriendVoiceCode = localStrangerInfo.voiceCode;
      ((AllInOne)localObject).subSourceId = 1;
      ProfileActivity.a(getQBaseActivity(), (AllInOne)localObject, d());
      this.w = paramInt1;
      this.Q = true;
      this.R = localStrangerInfo.mUin;
      this.S = System.currentTimeMillis();
      ExtendFriendReport.a(2, paramInt1, localStrangerInfo.mStrRecomTrace, this.N, localStrangerInfo);
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("playerCompletion path=%s", new Object[] { paramString }));
    }
    ThreadManager.getUIHandler().post(new ExtendFriendBaseFragment.5(this));
  }
  
  public void a(long paramLong)
  {
    this.x = paramLong;
  }
  
  public void a(File paramFile)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("onDownloadFinish path=%s", new Object[] { paramFile.getAbsoluteFile() }));
    }
  }
  
  protected void a(String paramString, int paramInt)
  {
    QBaseActivity localQBaseActivity = this.h;
    if (localQBaseActivity != null)
    {
      if (this.B == null) {
        this.B = new QQToast(localQBaseActivity);
      }
      if ((!this.B.isShowing()) || (!TextUtils.equals(this.C, paramString)) || (this.D != paramInt))
      {
        this.B.setToastIcon(QQToast.getIconRes(paramInt));
        this.B.setType(paramInt);
        this.B.setToastMsg(paramString);
        this.B.setDuration(0);
        this.B.show(this.h.getTitleBarHeight());
        this.C = paramString;
        this.D = paramInt;
      }
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2) {}
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("onFocusChanged focused=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if (!paramBoolean) {
      ThreadManager.getUIHandler().post(new ExtendFriendBaseFragment.7(this));
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("syncSwitchStatus syncProfileComplete=%s syncShowCard=%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) }));
    }
    if ((paramBoolean1) || (paramBoolean2))
    {
      Card localCard = ((FriendsManager)this.i.getManager(QQManagerFactory.FRIENDS_MANAGER)).f(this.i.getCurrentUin());
      if (localCard != null)
      {
        if (paramBoolean1) {
          this.y = (TextUtils.isEmpty(localCard.declaration) ^ true);
        }
        if (paramBoolean2) {
          this.z = localCard.isShowCard;
        }
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, RecyclerView.ViewHolder paramViewHolder)
  {
    ExtendFriendInfo localExtendFriendInfo = new ExtendFriendInfo(((FriendsManager)this.i.getManager(QQManagerFactory.FRIENDS_MANAGER)).g(this.i.getCurrentAccountUin()));
    int i1 = 0;
    int i2;
    if ((paramViewHolder != null) && ((paramViewHolder instanceof FeedViewHolder)))
    {
      paramViewHolder = (FeedViewHolder)paramViewHolder;
      i1 = paramViewHolder.d();
      i2 = paramViewHolder.c();
    }
    else
    {
      i2 = 0;
    }
    if (paramBoolean1)
    {
      localExtendFriendInfo.h = i1;
      localExtendFriendInfo.j = true;
    }
    if (paramBoolean2)
    {
      localExtendFriendInfo.i = i2;
      localExtendFriendInfo.k = true;
    }
    paramViewHolder = new Intent();
    paramViewHolder.putExtra("key_extend_friend_info", localExtendFriendInfo);
    ((IExpandFragmentRouter)QRoute.api(IExpandFragmentRouter.class)).launchExpandEditFragmentForResult(this.h, paramViewHolder, 4097);
  }
  
  public void b()
  {
    RecyclerView localRecyclerView = this.p;
    if (localRecyclerView != null) {
      localRecyclerView.smoothScrollToPosition(0);
    }
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public void b(boolean paramBoolean) {}
  
  protected void c()
  {
    Object localObject1 = this.o;
    if ((localObject1 != null) && (this.m != null))
    {
      int i1 = ((LinearLayoutManager)localObject1).findFirstVisibleItemPosition();
      int i2 = this.o.findLastVisibleItemPosition();
      while (i1 <= i2)
      {
        localObject1 = this.m.b(i1);
        Object localObject2 = this.p.findViewHolderForPosition(i1);
        if ((localObject1 != null) && (localObject2 != null) && ((localObject2 instanceof FeedViewHolder)))
        {
          localObject2 = (FeedViewHolder)localObject2;
          localObject1 = a(((StrangerInfo)localObject1).mUin, ((StrangerInfo)localObject1).mNickName, ((FeedViewHolder)localObject2).c);
          ((FeedViewHolder)localObject2).c.setImageDrawable((Drawable)localObject1);
        }
        i1 += 1;
      }
    }
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("onFeedVoiceClick position=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    Object localObject = this.m;
    if (localObject != null)
    {
      localObject = ((RecyclerViewAdapter)localObject).b(paramInt);
      if (localObject != null)
      {
        int i1 = ((StrangerInfo)localObject).mVoiceDuration / 10;
        QQAppInterface localQQAppInterface = this.i;
        String str = ((StrangerInfo)localObject).mUin;
        int i2 = paramInt + 1;
        ReportController.a(localQQAppInterface, "dc00898", "", str, "0X80092CF", "0X80092CF", i1 + 1, 0, "", String.valueOf(i2), ExtendFriendReport.a(((StrangerInfo)localObject).mStrRecomTrace), this.N);
        ReportController.a(this.i, "dc00898", "", ((StrangerInfo)localObject).mUin, "0X8009C70", "0X8009C70", 0, 0, "", String.valueOf(i2), ExtendFriendReport.a(((StrangerInfo)localObject).mStrRecomTrace), this.N);
        ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#feeds_page#kl_voice", true, -1L, -1L, null, true, true);
      }
    }
    if (paramInt != this.u) {
      n();
    }
    h(paramInt);
  }
  
  protected void c(boolean paramBoolean)
  {
    RecyclerViewAdapter localRecyclerViewAdapter = this.m;
    if ((localRecyclerViewAdapter != null) && (localRecyclerViewAdapter.b() > 0) && (this.h != null) && (this.o != null))
    {
      if (this.i == null) {
        return;
      }
      this.s.removeCallbacks(this.W);
      if (paramBoolean)
      {
        this.s.postDelayed(this.W, 500L);
        return;
      }
      this.W.run();
    }
  }
  
  protected int d()
  {
    return 0;
  }
  
  public void d(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("onFeedLikeClick position=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    StrangerInfo localStrangerInfo = this.m.b(paramInt);
    if (localStrangerInfo != null)
    {
      if (localStrangerInfo.mAvailLikeCount > 0)
      {
        if (NetworkUtil.isNetSupport(this.h))
        {
          localStrangerInfo.mLiked = true;
          localStrangerInfo.mAvailLikeCount -= 1;
          ReportController.a(this.i, "dc00898", "", localStrangerInfo.mUin, "0X80092CD", "0X80092CD", 0, 0, "", String.valueOf(paramInt + 1), ExtendFriendReport.a(localStrangerInfo.mStrRecomTrace), this.N);
          ReportController.b(this.i, "CliOper", "", "", "P_prof", "Prof_good", 9, 1, 0, Integer.toString(53), "1", this.i.getCurrentAccountUin(), localStrangerInfo.mUin);
          ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#voice_tab#like_btn", true, -1L, -1L, null, true, true);
          synchronized (d)
          {
            localObject3 = (Integer)this.f.get(localStrangerInfo.mUin);
            Object localObject1 = localObject3;
            if (localObject3 == null) {
              localObject1 = Integer.valueOf(0);
            }
            this.f.put(localStrangerInfo.mUin, Integer.valueOf(((Integer)localObject1).intValue() + 1));
            if (!this.s.hasMessages(10))
            {
              localObject1 = Message.obtain();
              ((Message)localObject1).what = 10;
              this.s.sendMessageDelayed((Message)localObject1, 1000L);
            }
            this.m.notifyItemChanged(paramInt);
            i(paramInt);
            return;
          }
        }
        a(getString(2131918210), 1);
        return;
      }
      Object localObject3 = HardCodeUtil.a(2131902288);
      String str;
      if ((localStrangerInfo.mGender != 1) && (localStrangerInfo.mGender != 2)) {
        str = HardCodeUtil.a(2131902292);
      } else if (localStrangerInfo.mGender == 2) {
        str = HardCodeUtil.a(2131902285);
      } else {
        str = HardCodeUtil.a(2131902268);
      }
      a(String.format((String)localObject3, new Object[] { str, Integer.valueOf(e()) }), 0);
    }
  }
  
  protected int e()
  {
    return 0;
  }
  
  public void e(int paramInt)
  {
    if (this.h == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendBaseFragment", 2, "onFeedSendMsgClick() mActivity is null just return");
      }
      return;
    }
    StrangerInfo localStrangerInfo = this.m.b(paramInt);
    if (localStrangerInfo != null)
    {
      ExtendFriendSendMsgHelper.a(this.i).a(this.i, localStrangerInfo.mUin, localStrangerInfo.mNickName, localStrangerInfo.voiceCode, 2, new ExtendFriendBaseFragment.3(this));
      ExtendFriendReport.a().a(3, localStrangerInfo.mUin, "", String.valueOf(paramInt + 1), ExtendFriendReport.a(localStrangerInfo.mStrRecomTrace), this.N);
      ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#voice_tab#message_btn", true, -1L, -1L, null, true, true);
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("onFooterItemClick", new Object[0]));
    }
    b(true);
    this.m.a(0, true);
  }
  
  public void f(int paramInt)
  {
    StrangerInfo localStrangerInfo = this.m.b(paramInt);
    if (this.h != null)
    {
      if (localStrangerInfo == null) {
        return;
      }
      if (!T)
      {
        localObject = ((FriendsManager)this.i.getManager(QQManagerFactory.FRIENDS_MANAGER)).f(this.i.getCurrentAccountUin());
        if ((localObject != null) && (((Card)localObject).declaration == null)) {
          ((IExpandHandler)this.i.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).a(this.i.getCurrentAccountUin(), false);
        }
        T = false;
      }
      Object localObject = this.p.findViewHolderForPosition(paramInt);
      boolean bool1;
      boolean bool2;
      if ((localObject != null) && ((localObject instanceof FeedViewHolder)))
      {
        FeedViewHolder localFeedViewHolder = (FeedViewHolder)localObject;
        bool1 = localFeedViewHolder.b();
        bool2 = localFeedViewHolder.a();
      }
      else
      {
        bool1 = false;
        bool2 = false;
      }
      this.L = ActionSheet.create(this.h);
      this.L.addButton(2131886148, 3);
      if (!SimpleUIUtil.e())
      {
        if (bool1) {
          this.L.addButton(2131916294);
        }
        if (bool2) {
          this.L.addButton(2131916295);
        }
        if ((!bool2) && (!bool1)) {
          this.L.addButton(2131916296);
        }
      }
      this.L.addCancelButton(2131887648);
      this.L.setOnButtonClickListener(new ExtendFriendBaseFragment.4(this, localStrangerInfo, bool1, bool2, (RecyclerView.ViewHolder)localObject));
      if (!this.h.isFinishing()) {
        this.L.show();
      }
      VasWebviewUtil.a("strangers_makefriend", "plaza_click", "", 0, "", "");
    }
  }
  
  public void g() {}
  
  public void g(int paramInt)
  {
    RecyclerViewAdapter localRecyclerViewAdapter = this.m;
    if (localRecyclerViewAdapter != null)
    {
      localRecyclerViewAdapter.c(paramInt);
      this.m.notifyDataSetChanged();
      QLog.i("ExtendFriendBaseFragment", 1, "@gdtadv onClickFeedBackHideAdv");
    }
  }
  
  public long h()
  {
    return this.x;
  }
  
  protected void h(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("toggleVoice position=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    Object localObject = this.p.findViewHolderForPosition(paramInt);
    if ((localObject != null) && ((localObject instanceof FeedViewHolder)))
    {
      localObject = (FeedViewHolder)localObject;
      if (((FeedViewHolder)localObject).k.d())
      {
        ((FeedViewHolder)localObject).k.f();
        localObject = this.t;
        if (localObject != null) {
          ((ExpandVoicePlayer)localObject).a();
        }
        this.u = -1;
        return;
      }
      ((FeedViewHolder)localObject).k.e();
      localObject = this.m;
      if (localObject != null)
      {
        localObject = ((RecyclerViewAdapter)localObject).b(paramInt);
        if ((localObject != null) && (!TextUtils.isEmpty(((StrangerInfo)localObject).mVoiceUrl)))
        {
          ExpandVoicePlayer localExpandVoicePlayer = this.t;
          if (localExpandVoicePlayer != null) {
            localExpandVoicePlayer.a(((StrangerInfo)localObject).mVoiceUrl);
          }
        }
      }
      this.u = paramInt;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 10) {
      j();
    }
    return true;
  }
  
  public int i()
  {
    return this.u;
  }
  
  public void i(int paramInt)
  {
    FeedViewHolder localFeedViewHolder = (FeedViewHolder)this.p.findViewHolderForPosition(paramInt);
    if (localFeedViewHolder == null) {
      return;
    }
    int[] arrayOfInt = new int[2];
    localFeedViewHolder.h.getLocationInWindow(arrayOfInt);
    NearbyZanAnimLayout localNearbyZanAnimLayout = this.G;
    localNearbyZanAnimLayout.a(this.H.a(3, localNearbyZanAnimLayout.d).a(), arrayOfInt[0] + localFeedViewHolder.h.getPaddingLeft() + this.I, arrayOfInt[1] - this.F + localFeedViewHolder.h.getPaddingTop() + this.J);
  }
  
  protected void j()
  {
    synchronized (d)
    {
      if (this.j != null)
      {
        long l1 = Long.valueOf(this.i.getCurrentAccountUin()).longValue();
        Iterator localIterator = this.f.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          int i1 = ((Integer)this.f.get(str)).intValue();
          if (i1 > 0)
          {
            long l2 = Long.valueOf(str).longValue();
            this.j.a(l1, l2, null, 53, i1, 0);
          }
        }
      }
      this.f.clear();
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  protected void k()
  {
    if ((this.Q) && (!TextUtils.isEmpty(this.R)) && (this.S > 0L))
    {
      long l1 = System.currentTimeMillis() - this.S;
      if ((l1 > 0L) && (l1 < 3600000L)) {
        ReportController.b(this.i, "dc00898", "", this.R, "0X8009C71", "0X8009C71", 0, 0, String.valueOf(l1), "", "", this.N);
      }
      this.Q = false;
      this.R = null;
      this.S = -1L;
    }
  }
  
  protected void l()
  {
    Object localObject1 = this.V;
    if ((localObject1 != null) && (!((ConcurrentHashMap)localObject1).isEmpty()))
    {
      localObject1 = this.h;
      if ((localObject1 != null) && (this.o != null) && (this.i != null))
      {
        if (((QBaseActivity)localObject1).isFinishing()) {
          return;
        }
        localObject1 = this.V.entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
          String str1 = (String)((Map.Entry)localObject2).getKey();
          localObject2 = (ExtendFriendBaseFragment.ExposureFeedInfo)((Map.Entry)localObject2).getValue();
          if (System.currentTimeMillis() - ((ExtendFriendBaseFragment.ExposureFeedInfo)localObject2).a >= this.P)
          {
            this.V.remove(str1);
            String str2 = ExtendFriendReport.a(((ExtendFriendBaseFragment.ExposureFeedInfo)localObject2).d);
            str2 = String.format("%s_%s", new Object[] { ((ExtendFriendBaseFragment.ExposureFeedInfo)localObject2).b, str2 });
            ReportController.b(this.i, "dc00898", "", str1, "0X8009C6E", "0X8009C6E", 1, 0, "", String.valueOf(((ExtendFriendBaseFragment.ExposureFeedInfo)localObject2).c + 1), ExtendFriendReport.a(((ExtendFriendBaseFragment.ExposureFeedInfo)localObject2).d.mStrRecomTrace), str2);
          }
        }
      }
    }
  }
  
  protected void m()
  {
    this.V.clear();
  }
  
  public void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("stopLastVoice mLastPlayVoicePos=%s", new Object[] { Integer.valueOf(this.u) }));
    }
    if (this.u >= 0)
    {
      Object localObject = this.t;
      if (localObject != null) {
        ((ExpandVoicePlayer)localObject).a();
      }
      localObject = this.p.findViewHolderForPosition(this.u);
      if ((localObject != null) && ((localObject instanceof FeedViewHolder)))
      {
        localObject = (FeedViewHolder)localObject;
        if (((FeedViewHolder)localObject).k.d()) {
          ((FeedViewHolder)localObject).k.f();
        }
      }
      this.u = -1;
    }
  }
  
  public void o()
  {
    this.U = ((IExpandHandler)this.i.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).a(this.i.getCurrentUin(), true);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.h = getQBaseActivity();
    this.i = ((QQAppInterface)this.h.getAppRuntime());
    this.k = ((IExpandHandler)this.i.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER));
    this.j = ((CardHandler)this.i.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER));
    this.l = ((IExpandManager)this.i.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER));
    this.g = ((IQQAvatarService)this.i.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.i);
    this.g.setDecodeTaskCompletionListener(this);
    this.e = new HashMap();
    this.H = new FloatViewBuilderFactory(this.h);
    this.I = AIOUtils.b(17.5F, getResources());
    this.J = AIOUtils.b(7.0F, getResources());
    this.t = new ExpandVoicePlayer(this, this.h);
    this.s = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), this);
    paramBundle = this.l.t();
    if (paramBundle != null) {
      this.P = paramBundle.exposureTimeLimit;
    }
    this.i.addObserver(this.X);
    if (this.M == null) {
      this.M = new GdtAppReceiver();
    }
    this.M.register(this.h);
    ((IVasAdExtendFriendApi)QRoute.api(IVasAdExtendFriendApi.class)).initDeviceInfo();
    QLog.d("ExtendFriendBaseFragment", 2, "mGdtAppReceiver register");
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("onDecodeTaskCompleted uin=%s avatar=%s", new Object[] { paramString, paramBitmap }));
    }
    synchronized (a)
    {
      Iterator localIterator = this.e.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = (Map.Entry)localIterator.next();
        ImageView localImageView = (ImageView)((Map.Entry)localObject1).getKey();
        localObject1 = (String)((Map.Entry)localObject1).getValue();
        if ((localObject1 != null) && (((String)localObject1).equals(paramString)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendBaseFragment", 2, String.format("responseDecodeFace hit cache uin=%s avatar=%s", new Object[] { paramString, paramBitmap }));
          }
          Object localObject2 = null;
          Object localObject4 = localImageView.getTag(2131446778);
          localObject1 = localObject2;
          if (localObject4 != null)
          {
            localObject1 = localObject2;
            if ((localObject4 instanceof String)) {
              localObject1 = (String)localObject4;
            }
          }
          if (TextUtils.equals(paramString, (CharSequence)localObject1)) {
            localImageView.setImageDrawable(new BitmapDrawable(paramBitmap));
          }
          localIterator.remove();
        }
      }
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    k();
    Object localObject = this.g;
    if (localObject != null)
    {
      ((IFaceDecoder)localObject).setDecodeTaskCompletionListener(null);
      this.g.destory();
      this.g = null;
    }
    localObject = this.e;
    if (localObject != null)
    {
      ((Map)localObject).clear();
      this.e = null;
    }
    this.s.removeCallbacksAndMessages(null);
    localObject = this.i;
    if (localObject != null)
    {
      localObject = ExtendFriendSendMsgHelper.a((BaseQQAppInterface)localObject);
      if (localObject != null) {
        ((ExtendFriendSendMsgHelper)localObject).a();
      }
      this.i.removeObserver(this.X);
    }
    localObject = this.M;
    if (localObject != null)
    {
      ((GdtAppReceiver)localObject).unregister(this.h);
      QLog.d("ExtendFriendBaseFragment", 2, "mGdtAppReceiver unregister");
    }
  }
  
  public void onPause()
  {
    super.onPause();
    n();
    l();
    m();
  }
  
  public void onResume()
  {
    super.onResume();
    ExtendFriendReport.a(this.i, "");
    ExtendFriendReport.b();
    k();
    c(true);
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.s.hasMessages(10))
    {
      this.s.removeMessages(10);
      j();
    }
  }
  
  protected void p()
  {
    int i1 = this.w;
    if (i1 >= 0)
    {
      StrangerInfo localStrangerInfo = this.m.b(i1);
      if (localStrangerInfo != null)
      {
        Card localCard = ((FriendsManager)this.i.getManager(QQManagerFactory.FRIENDS_MANAGER)).f(localStrangerInfo.mUin);
        if (localCard != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendBaseFragment", 2, String.format("syncLikeStatus bVoted=%s bAvailVoteCnt=%s mAvailLikeCount=%s", new Object[] { Byte.valueOf(localCard.bVoted), Short.valueOf(localCard.bAvailVoteCnt), Integer.valueOf(localStrangerInfo.mAvailLikeCount) }));
          }
          if ((localCard.bVoted > 0) && (localCard.bAvailVoteCnt < localStrangerInfo.mAvailLikeCount))
          {
            localStrangerInfo.mLiked = true;
            localStrangerInfo.mAvailLikeCount = localCard.bAvailVoteCnt;
            this.m.notifyItemChanged(this.w);
          }
        }
      }
    }
  }
  
  public boolean q()
  {
    if (((IExpandQuestionUtils)QRoute.api(IExpandQuestionUtils.class)).needAnswerQuestion(this.i.getCurrentAccountUin()))
    {
      QBaseActivity localQBaseActivity = this.h;
      if (localQBaseActivity != null)
      {
        if (this.K == null) {
          this.K = ProfileGuideDialogUtils.a(localQBaseActivity);
        }
        if ((!this.K.isShowing()) && (!this.h.isFinishing())) {
          this.K.show();
        }
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendBaseFragment
 * JD-Core Version:    0.7.0.1
 */