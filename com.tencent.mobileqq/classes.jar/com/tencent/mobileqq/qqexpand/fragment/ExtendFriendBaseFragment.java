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
import com.tencent.mobileqq.qqexpand.widget.voice.ExpandVoiceView;
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
  protected static final Object a;
  protected static final Object b;
  private static boolean e;
  protected long a;
  protected Dialog a;
  protected LinearLayoutManager a;
  protected RecyclerView.AdapterDataObserver a;
  protected RecyclerView a;
  protected GdtAppReceiver a;
  protected CardHandler a;
  protected QBaseActivity a;
  protected QQAppInterface a;
  protected IFaceDecoder a;
  protected FloatViewBuilderFactory a;
  protected RecyclerViewAdapter a;
  protected RecyclerViewItemDecoration a;
  protected IExpandManager a;
  private final ExpandObserver jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver = new ExtendFriendBaseFragment.2(this);
  protected IExpandHandler a;
  protected PullToRefreshRecyclerView a;
  protected ExpandVoicePlayer a;
  protected NearbyZanAnimLayout a;
  protected QQToast a;
  protected WeakReferenceHandler a;
  protected ActionSheet a;
  private final Runnable jdField_a_of_type_JavaLangRunnable = new ExtendFriendBaseFragment.1(this);
  protected String a;
  protected Map<ImageView, String> a;
  private final ConcurrentHashMap<String, ExtendFriendBaseFragment.ExposureFeedInfo> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  protected boolean a;
  protected int b;
  protected long b;
  protected Dialog b;
  protected String b;
  protected Map<String, Integer> b;
  protected boolean b;
  protected int c;
  protected long c;
  protected String c;
  protected boolean c;
  protected int d;
  protected long d;
  protected boolean d;
  protected int e;
  protected int f;
  protected int g;
  protected int h;
  private int i;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_b_of_type_JavaLangObject = new Object();
    jdField_e_of_type_Boolean = false;
  }
  
  public ExtendFriendBaseFragment()
  {
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_b_of_type_JavaLangString = "推荐";
    this.jdField_c_of_type_Long = 2L;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_d_of_type_Long = -1L;
  }
  
  private ArrayList<ExtendFriendBaseFragment.ExposureFeedInfo> a()
  {
    localArrayList = new ArrayList();
    try
    {
      int j = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstCompletelyVisibleItemPosition();
      int k = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findLastCompletelyVisibleItemPosition();
      if ((j >= 0) && (j < this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.getItemCount()) && (k >= 0) && (k < this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.getItemCount()) && (j <= k)) {
        while (j <= k)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.getItemViewType(j) == 0)
          {
            StrangerInfo localStrangerInfo = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.a(j);
            if (localStrangerInfo != null)
            {
              ExtendFriendBaseFragment.ExposureFeedInfo localExposureFeedInfo = new ExtendFriendBaseFragment.ExposureFeedInfo(null);
              localExposureFeedInfo.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
              localExposureFeedInfo.jdField_a_of_type_Int = j;
              localExposureFeedInfo.jdField_a_of_type_ComTencentMobileqqQqexpandBeanFeedStrangerInfo = localStrangerInfo;
              localArrayList.add(localExposureFeedInfo);
            }
          }
          j += 1;
        }
      }
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("ExtendFriendBaseFragment", 1, "findCurrentVisibleItems fail.", localThrowable);
    }
  }
  
  protected int a()
  {
    return 0;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public Drawable a(String paramString1, String paramString2, ImageView paramImageView)
  {
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null)
        {
          localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(1, paramString1);
          if (localBitmap == null)
          {
            if (!this.jdField_c_of_type_Boolean)
            {
              if (paramImageView != null) {
                paramImageView.setTag(2131378259, paramString1);
              }
              if ((this.jdField_a_of_type_JavaUtilMap != null) && (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null))
              {
                this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramString1, 1, true);
                if (QLog.isColorLevel()) {
                  QLog.d("ExtendFriendBaseFragment", 2, String.format("requestDecodeFace uin=%s nick=%s", new Object[] { paramString1, paramString2 }));
                }
              }
              if ((this.jdField_a_of_type_JavaUtilMap != null) && (paramImageView != null)) {
                this.jdField_a_of_type_JavaUtilMap.put(paramImageView, paramString1);
              }
            }
          }
          else if ((this.jdField_a_of_type_JavaUtilMap != null) && (paramImageView != null)) {
            this.jdField_a_of_type_JavaUtilMap.remove(paramImageView);
          }
          paramString1 = localBitmap;
          if (localBitmap == null) {
            paramString1 = ImageUtil.f();
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
    StrangerInfo localStrangerInfo = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.a(paramInt1);
    if (localStrangerInfo != null)
    {
      ExtendFriendReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localStrangerInfo.mStrRecomTrace);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      String str = localStrangerInfo.mUin;
      int j = paramInt1 + 1;
      ReportController.a((AppRuntime)localObject, "dc00898", "", str, "0X80092D0", "0X80092D0", 0, 0, "", String.valueOf(j), ExtendFriendReport.a(localStrangerInfo.mStrRecomTrace), this.jdField_b_of_type_JavaLangString);
      ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", localStrangerInfo.mUin, "0X8009C6F", "0X8009C6F", paramInt2, 0, "", String.valueOf(j), ExtendFriendReport.a(localStrangerInfo.mStrRecomTrace), this.jdField_b_of_type_JavaLangString);
      ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#voice_tab#profile_photo", true, -1L, -1L, null, true, true);
      localObject = new AllInOne(localStrangerInfo.mUin, 96);
      ((AllInOne)localObject).nickname = localStrangerInfo.mNickName;
      ((AllInOne)localObject).extendFriendVoiceCode = localStrangerInfo.voiceCode;
      ((AllInOne)localObject).subSourceId = 1;
      ProfileActivity.a(getQBaseActivity(), (AllInOne)localObject, a());
      this.jdField_d_of_type_Int = paramInt1;
      this.jdField_d_of_type_Boolean = true;
      this.jdField_c_of_type_JavaLangString = localStrangerInfo.mUin;
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      ExtendFriendReport.a(2, paramInt1, localStrangerInfo.mStrRecomTrace, this.jdField_b_of_type_JavaLangString, localStrangerInfo);
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
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(File paramFile)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("onDownloadFinish path=%s", new Object[] { paramFile.getAbsoluteFile() }));
    }
  }
  
  protected void a(String paramString, int paramInt)
  {
    QBaseActivity localQBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
    if (localQBaseActivity != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast = new QQToast(localQBaseActivity);
      }
      if ((!this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.d()) || (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramString)) || (this.jdField_e_of_type_Int != paramInt))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.a(QQToast.a(paramInt));
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.b(paramInt);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.a(paramString);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.d(0);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getTitleBarHeight());
        this.jdField_a_of_type_JavaLangString = paramString;
        this.jdField_e_of_type_Int = paramInt;
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
      Card localCard = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      if (localCard != null)
      {
        if (paramBoolean1) {
          this.jdField_a_of_type_Boolean = (TextUtils.isEmpty(localCard.declaration) ^ true);
        }
        if (paramBoolean2) {
          this.jdField_b_of_type_Boolean = localCard.isShowCard;
        }
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, RecyclerView.ViewHolder paramViewHolder)
  {
    ExtendFriendInfo localExtendFriendInfo = new ExtendFriendInfo(((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    int j = 0;
    int k;
    if ((paramViewHolder != null) && ((paramViewHolder instanceof FeedViewHolder)))
    {
      paramViewHolder = (FeedViewHolder)paramViewHolder;
      j = paramViewHolder.b();
      k = paramViewHolder.a();
    }
    else
    {
      k = 0;
    }
    if (paramBoolean1)
    {
      localExtendFriendInfo.jdField_e_of_type_Int = j;
      localExtendFriendInfo.jdField_b_of_type_Boolean = true;
    }
    if (paramBoolean2)
    {
      localExtendFriendInfo.f = k;
      localExtendFriendInfo.jdField_c_of_type_Boolean = true;
    }
    paramViewHolder = new Intent();
    paramViewHolder.putExtra("key_extend_friend_info", localExtendFriendInfo);
    ((IExpandFragmentRouter)QRoute.api(IExpandFragmentRouter.class)).launchExpandEditFragmentForResult(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, paramViewHolder, 4097);
  }
  
  public boolean a()
  {
    if (((IExpandQuestionUtils)QRoute.api(IExpandQuestionUtils.class)).needAnswerQuestion(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      QBaseActivity localQBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
      if (localQBaseActivity != null)
      {
        if (this.jdField_b_of_type_AndroidAppDialog == null) {
          this.jdField_b_of_type_AndroidAppDialog = ProfileGuideDialogUtils.a(localQBaseActivity);
        }
        if ((!this.jdField_b_of_type_AndroidAppDialog.isShowing()) && (!this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.isFinishing())) {
          this.jdField_b_of_type_AndroidAppDialog.show();
        }
      }
      return true;
    }
    return false;
  }
  
  protected int b()
  {
    return 0;
  }
  
  public void b()
  {
    RecyclerView localRecyclerView = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
    if (localRecyclerView != null) {
      localRecyclerView.smoothScrollToPosition(0);
    }
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public void b(boolean paramBoolean) {}
  
  public int c()
  {
    return this.jdField_b_of_type_Int;
  }
  
  protected void c()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
    if ((localObject1 != null) && (this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter != null))
    {
      int j = ((LinearLayoutManager)localObject1).findFirstVisibleItemPosition();
      int k = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findLastVisibleItemPosition();
      while (j <= k)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.a(j);
        Object localObject2 = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForPosition(j);
        if ((localObject1 != null) && (localObject2 != null) && ((localObject2 instanceof FeedViewHolder)))
        {
          localObject2 = (FeedViewHolder)localObject2;
          localObject1 = a(((StrangerInfo)localObject1).mUin, ((StrangerInfo)localObject1).mNickName, ((FeedViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView);
          ((FeedViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
        }
        j += 1;
      }
    }
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("onFeedVoiceClick position=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter;
    if (localObject != null)
    {
      localObject = ((RecyclerViewAdapter)localObject).a(paramInt);
      if (localObject != null)
      {
        int j = ((StrangerInfo)localObject).mVoiceDuration / 10;
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        String str = ((StrangerInfo)localObject).mUin;
        int k = paramInt + 1;
        ReportController.a(localQQAppInterface, "dc00898", "", str, "0X80092CF", "0X80092CF", j + 1, 0, "", String.valueOf(k), ExtendFriendReport.a(((StrangerInfo)localObject).mStrRecomTrace), this.jdField_b_of_type_JavaLangString);
        ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", ((StrangerInfo)localObject).mUin, "0X8009C70", "0X8009C70", 0, 0, "", String.valueOf(k), ExtendFriendReport.a(((StrangerInfo)localObject).mStrRecomTrace), this.jdField_b_of_type_JavaLangString);
        ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#feeds_page#kl_voice", true, -1L, -1L, null, true, true);
      }
    }
    if (paramInt != this.jdField_b_of_type_Int) {
      j();
    }
    h(paramInt);
  }
  
  protected void c(boolean paramBoolean)
  {
    RecyclerViewAdapter localRecyclerViewAdapter = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter;
    if ((localRecyclerViewAdapter != null) && (localRecyclerViewAdapter.a() > 0) && (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity != null) && (this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
        return;
      }
      this.jdField_a_of_type_JavaLangRunnable.run();
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("onFooterItemClick", new Object[0]));
    }
    b(true);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.a(0, true);
  }
  
  public void d(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("onFeedLikeClick position=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    StrangerInfo localStrangerInfo = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.a(paramInt);
    if (localStrangerInfo != null)
    {
      if (localStrangerInfo.mAvailLikeCount > 0)
      {
        if (NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity))
        {
          localStrangerInfo.mLiked = true;
          localStrangerInfo.mAvailLikeCount -= 1;
          ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", localStrangerInfo.mUin, "0X80092CD", "0X80092CD", 0, 0, "", String.valueOf(paramInt + 1), ExtendFriendReport.a(localStrangerInfo.mStrRecomTrace), this.jdField_b_of_type_JavaLangString);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "P_prof", "Prof_good", 9, 1, 0, Integer.toString(53), "1", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localStrangerInfo.mUin);
          ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#voice_tab#like_btn", true, -1L, -1L, null, true, true);
          synchronized (jdField_b_of_type_JavaLangObject)
          {
            localObject3 = (Integer)this.jdField_b_of_type_JavaUtilMap.get(localStrangerInfo.mUin);
            Object localObject1 = localObject3;
            if (localObject3 == null) {
              localObject1 = Integer.valueOf(0);
            }
            this.jdField_b_of_type_JavaUtilMap.put(localStrangerInfo.mUin, Integer.valueOf(((Integer)localObject1).intValue() + 1));
            if (!this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.hasMessages(10))
            {
              localObject1 = Message.obtain();
              ((Message)localObject1).what = 10;
              this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessageDelayed((Message)localObject1, 1000L);
            }
            this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.notifyItemChanged(paramInt);
            i(paramInt);
            return;
          }
        }
        a(getString(2131720493), 1);
        return;
      }
      Object localObject3 = HardCodeUtil.a(2131704375);
      String str;
      if ((localStrangerInfo.mGender != 1) && (localStrangerInfo.mGender != 2)) {
        str = HardCodeUtil.a(2131704379);
      } else if (localStrangerInfo.mGender == 2) {
        str = HardCodeUtil.a(2131704372);
      } else {
        str = HardCodeUtil.a(2131704354);
      }
      a(String.format((String)localObject3, new Object[] { str, Integer.valueOf(b()) }), 0);
    }
  }
  
  public void e() {}
  
  public void e(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendBaseFragment", 2, "onFeedSendMsgClick() mActivity is null just return");
      }
      return;
    }
    StrangerInfo localStrangerInfo = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.a(paramInt);
    if (localStrangerInfo != null)
    {
      ExtendFriendSendMsgHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localStrangerInfo.mUin, localStrangerInfo.mNickName, localStrangerInfo.voiceCode, 2, new ExtendFriendBaseFragment.3(this));
      ExtendFriendReport.a().a(3, localStrangerInfo.mUin, "", String.valueOf(paramInt + 1), ExtendFriendReport.a(localStrangerInfo.mStrRecomTrace), this.jdField_b_of_type_JavaLangString);
      ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#voice_tab#message_btn", true, -1L, -1L, null, true, true);
    }
  }
  
  protected void f()
  {
    synchronized (jdField_b_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppCardHandler != null)
      {
        long l1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue();
        Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          int j = ((Integer)this.jdField_b_of_type_JavaUtilMap.get(str)).intValue();
          if (j > 0)
          {
            long l2 = Long.valueOf(str).longValue();
            this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(l1, l2, null, 53, j, 0);
          }
        }
      }
      this.jdField_b_of_type_JavaUtilMap.clear();
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void f(int paramInt)
  {
    StrangerInfo localStrangerInfo = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.a(paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity != null)
    {
      if (localStrangerInfo == null) {
        return;
      }
      if (!jdField_e_of_type_Boolean)
      {
        localObject = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if ((localObject != null) && (((Card)localObject).declaration == null)) {
          ((IExpandHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
        }
        jdField_e_of_type_Boolean = false;
      }
      Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForPosition(paramInt);
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
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.create(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131689540, 3);
      if (!SimpleUIUtil.a())
      {
        if (bool1) {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131718788);
        }
        if (bool2) {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131718789);
        }
        if ((!bool2) && (!bool1)) {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131718790);
        }
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690728);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new ExtendFriendBaseFragment.4(this, localStrangerInfo, bool1, bool2, (RecyclerView.ViewHolder)localObject));
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.isFinishing()) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      }
      VasWebviewUtil.a("strangers_makefriend", "plaza_click", "", 0, "", "");
    }
  }
  
  protected void g()
  {
    if ((this.jdField_d_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (this.jdField_d_of_type_Long > 0L))
    {
      long l = System.currentTimeMillis() - this.jdField_d_of_type_Long;
      if ((l > 0L) && (l < 3600000L)) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_c_of_type_JavaLangString, "0X8009C71", "0X8009C71", 0, 0, String.valueOf(l), "", "", this.jdField_b_of_type_JavaLangString);
      }
      this.jdField_d_of_type_Boolean = false;
      this.jdField_c_of_type_JavaLangString = null;
      this.jdField_d_of_type_Long = -1L;
    }
  }
  
  public void g(int paramInt)
  {
    RecyclerViewAdapter localRecyclerViewAdapter = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter;
    if (localRecyclerViewAdapter != null)
    {
      localRecyclerViewAdapter.b(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.notifyDataSetChanged();
      QLog.i("ExtendFriendBaseFragment", 1, "@gdtadv onClickFeedBackHideAdv");
    }
  }
  
  protected void h()
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    if ((localObject1 != null) && (!((ConcurrentHashMap)localObject1).isEmpty()))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
      if ((localObject1 != null) && (this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
      {
        if (((QBaseActivity)localObject1).isFinishing()) {
          return;
        }
        localObject1 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
          String str1 = (String)((Map.Entry)localObject2).getKey();
          localObject2 = (ExtendFriendBaseFragment.ExposureFeedInfo)((Map.Entry)localObject2).getValue();
          if (System.currentTimeMillis() - ((ExtendFriendBaseFragment.ExposureFeedInfo)localObject2).jdField_a_of_type_Long >= this.jdField_c_of_type_Long)
          {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str1);
            String str2 = ExtendFriendReport.a(((ExtendFriendBaseFragment.ExposureFeedInfo)localObject2).jdField_a_of_type_ComTencentMobileqqQqexpandBeanFeedStrangerInfo);
            str2 = String.format("%s_%s", new Object[] { ((ExtendFriendBaseFragment.ExposureFeedInfo)localObject2).jdField_a_of_type_JavaLangString, str2 });
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009C6E", "0X8009C6E", 1, 0, "", String.valueOf(((ExtendFriendBaseFragment.ExposureFeedInfo)localObject2).jdField_a_of_type_Int + 1), ExtendFriendReport.a(((ExtendFriendBaseFragment.ExposureFeedInfo)localObject2).jdField_a_of_type_ComTencentMobileqqQqexpandBeanFeedStrangerInfo.mStrRecomTrace), str2);
          }
        }
      }
    }
  }
  
  protected void h(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("toggleVoice position=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForPosition(paramInt);
    if ((localObject != null) && ((localObject instanceof FeedViewHolder)))
    {
      localObject = (FeedViewHolder)localObject;
      if (((FeedViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView.b())
      {
        ((FeedViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView.d();
        localObject = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoicePlayer;
        if (localObject != null) {
          ((ExpandVoicePlayer)localObject).a();
        }
        this.jdField_b_of_type_Int = -1;
        return;
      }
      ((FeedViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView.c();
      localObject = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter;
      if (localObject != null)
      {
        localObject = ((RecyclerViewAdapter)localObject).a(paramInt);
        if ((localObject != null) && (!TextUtils.isEmpty(((StrangerInfo)localObject).mVoiceUrl)))
        {
          ExpandVoicePlayer localExpandVoicePlayer = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoicePlayer;
          if (localExpandVoicePlayer != null) {
            localExpandVoicePlayer.a(((StrangerInfo)localObject).mVoiceUrl);
          }
        }
      }
      this.jdField_b_of_type_Int = paramInt;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 10) {
      f();
    }
    return true;
  }
  
  protected void i()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public void i(int paramInt)
  {
    FeedViewHolder localFeedViewHolder = (FeedViewHolder)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForPosition(paramInt);
    if (localFeedViewHolder == null) {
      return;
    }
    int[] arrayOfInt = new int[2];
    localFeedViewHolder.c.getLocationInWindow(arrayOfInt);
    NearbyZanAnimLayout localNearbyZanAnimLayout = this.jdField_a_of_type_ComTencentMobileqqWidgetNearbyZanAnimLayout;
    localNearbyZanAnimLayout.a(this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilderFactory.a(3, localNearbyZanAnimLayout.a).a(), arrayOfInt[0] + localFeedViewHolder.c.getPaddingLeft() + this.g, arrayOfInt[1] - this.f + localFeedViewHolder.c.getPaddingTop() + this.h);
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("stopLastVoice mLastPlayVoicePos=%s", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) }));
    }
    if (this.jdField_b_of_type_Int >= 0)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoicePlayer;
      if (localObject != null) {
        ((ExpandVoicePlayer)localObject).a();
      }
      localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForPosition(this.jdField_b_of_type_Int);
      if ((localObject != null) && ((localObject instanceof FeedViewHolder)))
      {
        localObject = (FeedViewHolder)localObject;
        if (((FeedViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView.b()) {
          ((FeedViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView.d();
        }
      }
      this.jdField_b_of_type_Int = -1;
    }
  }
  
  public void k()
  {
    this.i = ((IExpandHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), true);
  }
  
  protected void l()
  {
    int j = this.jdField_d_of_type_Int;
    if (j >= 0)
    {
      StrangerInfo localStrangerInfo = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.a(j);
      if (localStrangerInfo != null)
      {
        Card localCard = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(localStrangerInfo.mUin);
        if (localCard != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendBaseFragment", 2, String.format("syncLikeStatus bVoted=%s bAvailVoteCnt=%s mAvailLikeCount=%s", new Object[] { Byte.valueOf(localCard.bVoted), Short.valueOf(localCard.bAvailVoteCnt), Integer.valueOf(localStrangerInfo.mAvailLikeCount) }));
          }
          if ((localCard.bVoted > 0) && (localCard.bAvailVoteCnt < localStrangerInfo.mAvailLikeCount))
          {
            localStrangerInfo.mLiked = true;
            localStrangerInfo.mAvailLikeCount = localCard.bAvailVoteCnt;
            this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.notifyItemChanged(this.jdField_d_of_type_Int);
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = getQBaseActivity();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime());
    this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkIExpandHandler = ((IExpandHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER));
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER));
    this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerIExpandManager = ((IExpandManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilderFactory = new FloatViewBuilderFactory(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    this.g = AIOUtils.b(17.5F, getResources());
    this.h = AIOUtils.b(7.0F, getResources());
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoicePlayer = new ExpandVoicePlayer(this, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), this);
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerIExpandManager.a();
    if (paramBundle != null) {
      this.jdField_c_of_type_Long = paramBundle.exposureTimeLimit;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver);
    if (this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver == null) {
      this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = new GdtAppReceiver();
    }
    this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver.register(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    ((IVasAdExtendFriendApi)QRoute.api(IVasAdExtendFriendApi.class)).initDeviceInfo();
    QLog.d("ExtendFriendBaseFragment", 2, "mGdtAppReceiver register");
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("onDecodeTaskCompleted uin=%s avatar=%s", new Object[] { paramString, paramBitmap }));
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
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
          Object localObject4 = localImageView.getTag(2131378259);
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
    g();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localObject != null)
    {
      ((IFaceDecoder)localObject).setDecodeTaskCompletionListener(null);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = null;
    }
    localObject = this.jdField_a_of_type_JavaUtilMap;
    if (localObject != null)
    {
      ((Map)localObject).clear();
      this.jdField_a_of_type_JavaUtilMap = null;
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject != null)
    {
      localObject = ExtendFriendSendMsgHelper.a((BaseQQAppInterface)localObject);
      if (localObject != null) {
        ((ExtendFriendSendMsgHelper)localObject).a();
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver);
    }
    localObject = this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver;
    if (localObject != null)
    {
      ((GdtAppReceiver)localObject).unregister(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
      QLog.d("ExtendFriendBaseFragment", 2, "mGdtAppReceiver unregister");
    }
  }
  
  public void onPause()
  {
    super.onPause();
    j();
    h();
    i();
  }
  
  public void onResume()
  {
    super.onResume();
    ExtendFriendReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "");
    ExtendFriendReport.a();
    g();
    c(true);
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.hasMessages(10))
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(10);
      f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendBaseFragment
 * JD-Core Version:    0.7.0.1
 */