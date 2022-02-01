package com.tencent.mobileqq.extendfriend.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.bean.FaceFetch;
import com.tencent.mobileqq.extendfriend.bean.FeedBannerViewHolder.FeedBannerClickListener;
import com.tencent.mobileqq.extendfriend.bean.FeedViewHolder;
import com.tencent.mobileqq.extendfriend.bean.StrangerInfo;
import com.tencent.mobileqq.extendfriend.config.ExtendFriendConfig;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendHandler;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendObserver;
import com.tencent.mobileqq.extendfriend.pulltorefresh.extras.PullToRefreshRecyclerView;
import com.tencent.mobileqq.extendfriend.utils.ExpandReportUtils;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendSendMsgHelper;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendVoicePlayer;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendVoicePlayer.ExtendFriendVoicePlayerListener;
import com.tencent.mobileqq.extendfriend.utils.ProfileGuideDialogUtils;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView;
import com.tencent.mobileqq.hotchat.ui.BaseFloatViewBuilder;
import com.tencent.mobileqq.hotchat.ui.FloatViewBuilderFactory;
import com.tencent.mobileqq.nearby.anim.NearbyZanAnimLayout;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import cooperation.vip.manager.GdtGeneralManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class ExtendFriendBaseFragment
  extends ExtendFriendTabFragment
  implements Handler.Callback, DecodeTaskCompletionListener, FaceFetch, FeedBannerViewHolder.FeedBannerClickListener, SquareItemClickListener, ExtendFriendVoicePlayer.ExtendFriendVoicePlayerListener
{
  protected static final Object a;
  protected static final Object b;
  private static boolean e;
  protected int a;
  protected long a;
  protected Dialog a;
  protected FragmentActivity a;
  protected LinearLayoutManager a;
  protected RecyclerView.AdapterDataObserver a;
  protected RecyclerView a;
  protected GdtAppReceiver a;
  protected CardHandler a;
  protected QQAppInterface a;
  protected IFaceDecoder a;
  protected ExtendFriendManager a;
  protected RecyclerViewAdapter a;
  protected RecyclerViewItemDecoration a;
  protected ExtendFriendHandler a;
  private ExtendFriendObserver jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver = new ExtendFriendBaseFragment.8(this);
  protected PullToRefreshRecyclerView a;
  protected ExtendFriendVoicePlayer a;
  protected FloatViewBuilderFactory a;
  protected NearbyZanAnimLayout a;
  protected QQToast a;
  protected WeakReferenceHandler a;
  protected ActionSheet a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ExtendFriendBaseFragment.3(this);
  protected String a;
  protected Map<ImageView, String> a;
  private ConcurrentHashMap<String, ExtendFriendBaseFragment.ExposureFeedInfo> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
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
  private int h;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_b_of_type_JavaLangObject = new Object();
    jdField_e_of_type_Boolean = false;
  }
  
  public ExtendFriendBaseFragment()
  {
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_b_of_type_JavaLangString = ExtendFriendManager.jdField_a_of_type_JavaLangString;
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
      int i = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstCompletelyVisibleItemPosition();
      int j = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findLastCompletelyVisibleItemPosition();
      if ((i >= 0) && (i < this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.getItemCount()) && (j >= 0) && (j < this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.getItemCount()) && (i <= j)) {
        while (i <= j)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.getItemViewType(i) == 0)
          {
            StrangerInfo localStrangerInfo = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.a(i);
            if (localStrangerInfo != null)
            {
              ExtendFriendBaseFragment.ExposureFeedInfo localExposureFeedInfo = new ExtendFriendBaseFragment.ExposureFeedInfo(null);
              localExposureFeedInfo.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
              localExposureFeedInfo.jdField_a_of_type_Int = i;
              localExposureFeedInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanStrangerInfo = localStrangerInfo;
              localArrayList.add(localExposureFeedInfo);
            }
          }
          i += 1;
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
    Bitmap localBitmap = null;
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null) {
        localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(1, paramString1);
      }
      if (localBitmap == null) {
        if (!this.jdField_c_of_type_Boolean)
        {
          if (paramImageView != null) {
            paramImageView.setTag(2131378870, paramString1);
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
      while ((this.jdField_a_of_type_JavaUtilMap == null) || (paramImageView == null))
      {
        paramString1 = localBitmap;
        if (localBitmap == null) {
          paramString1 = ImageUtil.c();
        }
        return new BitmapDrawable(paramString1);
      }
      this.jdField_a_of_type_JavaUtilMap.remove(paramImageView);
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("onFeedVoiceClick position=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter != null)
    {
      StrangerInfo localStrangerInfo = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.a(paramInt);
      if (localStrangerInfo != null)
      {
        int i = localStrangerInfo.mVoiceDuration / 10;
        ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", localStrangerInfo.mUin, "0X80092CF", "0X80092CF", i + 1, 0, "", String.valueOf(paramInt + 1), ExtendFriendReport.a(localStrangerInfo.mStrRecomTrace), this.jdField_b_of_type_JavaLangString);
        ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", localStrangerInfo.mUin, "0X8009C70", "0X8009C70", 0, 0, "", String.valueOf(paramInt + 1), ExtendFriendReport.a(localStrangerInfo.mStrRecomTrace), this.jdField_b_of_type_JavaLangString);
        ExpandReportUtils.a("click#feeds_page#kl_voice", true, -1L, -1L, null, true, true);
      }
    }
    if (paramInt != this.jdField_a_of_type_Int) {
      k();
    }
    g(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("onFeedItemClick position=%s", new Object[] { Integer.valueOf(paramInt1) }));
    }
    StrangerInfo localStrangerInfo = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.a(paramInt1);
    if (localStrangerInfo != null)
    {
      ExtendFriendReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localStrangerInfo.mStrRecomTrace);
      ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", localStrangerInfo.mUin, "0X80092D0", "0X80092D0", 0, 0, "", String.valueOf(paramInt1 + 1), ExtendFriendReport.a(localStrangerInfo.mStrRecomTrace), this.jdField_b_of_type_JavaLangString);
      ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", localStrangerInfo.mUin, "0X8009C6F", "0X8009C6F", paramInt2, 0, "", String.valueOf(paramInt1 + 1), ExtendFriendReport.a(localStrangerInfo.mStrRecomTrace), this.jdField_b_of_type_JavaLangString);
      ExpandReportUtils.a("click#voice_tab#profile_photo", true, -1L, -1L, null, true, true);
      ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(localStrangerInfo.mUin, 96);
      localAllInOne.h = localStrangerInfo.mNickName;
      localAllInOne.c = localStrangerInfo.voiceCode;
      localAllInOne.l = 1;
      ProfileActivity.b(getActivity(), localAllInOne, a());
      this.jdField_c_of_type_Int = paramInt1;
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
    ThreadManager.getUIHandler().post(new ExtendFriendBaseFragment.4(this));
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
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast = new QQToast(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      }
      if ((!this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.d()) || (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramString)) || (this.jdField_d_of_type_Int != paramInt))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.a(QQToast.a(paramInt));
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.b(paramInt);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.a(paramString);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.d(0);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
        this.jdField_a_of_type_JavaLangString = paramString;
        this.jdField_d_of_type_Int = paramInt;
      }
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2) {}
  
  public void a(boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("syncSwitchStatus syncProfileComplete=%s syncShowCard=%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) }));
    }
    Card localCard;
    if ((paramBoolean1) || (paramBoolean2))
    {
      localCard = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      if (localCard != null) {
        if (paramBoolean1) {
          if (TextUtils.isEmpty(localCard.declaration)) {
            break label106;
          }
        }
      }
    }
    label106:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      this.jdField_a_of_type_Boolean = paramBoolean1;
      if (paramBoolean2) {
        this.jdField_b_of_type_Boolean = localCard.isShowCard;
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, RecyclerView.ViewHolder paramViewHolder)
  {
    int j = 0;
    Object localObject = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    Intent localIntent = new Intent();
    localObject = new ExtendFriendProfileEditFragment.ExtendFriendInfo((Card)localObject);
    if ((paramViewHolder != null) && ((paramViewHolder instanceof FeedViewHolder))) {
      j = ((FeedViewHolder)paramViewHolder).b();
    }
    for (int i = ((FeedViewHolder)paramViewHolder).a();; i = 0)
    {
      if (paramBoolean1)
      {
        ((ExtendFriendProfileEditFragment.ExtendFriendInfo)localObject).jdField_e_of_type_Int = j;
        ((ExtendFriendProfileEditFragment.ExtendFriendInfo)localObject).jdField_b_of_type_Boolean = true;
      }
      if (paramBoolean2)
      {
        ((ExtendFriendProfileEditFragment.ExtendFriendInfo)localObject).f = i;
        ((ExtendFriendProfileEditFragment.ExtendFriendInfo)localObject).jdField_c_of_type_Boolean = true;
      }
      localIntent.putExtra("key_extend_friend_info", (Parcelable)localObject);
      PublicFragmentActivity.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localIntent, ExtendFriendEditFragment.class, 4097);
      return;
    }
  }
  
  public boolean a()
  {
    if (ExtendFriendManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null)
      {
        if (this.jdField_b_of_type_AndroidAppDialog == null) {
          this.jdField_b_of_type_AndroidAppDialog = ProfileGuideDialogUtils.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
        }
        if ((!this.jdField_b_of_type_AndroidAppDialog.isShowing()) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())) {
          this.jdField_b_of_type_AndroidAppDialog.show();
        }
      }
      return true;
    }
    return false;
  }
  
  public void an_() {}
  
  protected int b()
  {
    return 0;
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("onFeedLikeClick position=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    StrangerInfo localStrangerInfo = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.a(paramInt);
    if (localStrangerInfo != null)
    {
      if (localStrangerInfo.mAvailLikeCount <= 0) {
        break label320;
      }
      if (NetworkUtil.d(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))
      {
        localStrangerInfo.mLiked = true;
        localStrangerInfo.mAvailLikeCount -= 1;
        ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", localStrangerInfo.mUin, "0X80092CD", "0X80092CD", 0, 0, "", String.valueOf(paramInt + 1), ExtendFriendReport.a(localStrangerInfo.mStrRecomTrace), this.jdField_b_of_type_JavaLangString);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "P_prof", "Prof_good", 9, 1, 0, Integer.toString(53), "1", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localStrangerInfo.mUin);
        ExpandReportUtils.a("click#voice_tab#like_btn", true, -1L, -1L, null, true, true);
      }
    }
    else
    {
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
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.notifyItemChanged(paramInt);
        h(paramInt);
        return;
      }
    }
    a(getString(2131720768), 1);
    return;
    label320:
    Object localObject3 = HardCodeUtil.a(2131704284);
    String str;
    if ((localStrangerInfo.mGender == 1) || (localStrangerInfo.mGender == 2)) {
      if (localStrangerInfo.mGender == 2) {
        str = HardCodeUtil.a(2131704281);
      }
    }
    for (;;)
    {
      a(String.format((String)localObject3, new Object[] { str, Integer.valueOf(b()) }), 0);
      return;
      str = HardCodeUtil.a(2131704263);
      continue;
      str = HardCodeUtil.a(2131704288);
    }
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  protected void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.a() <= 0) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
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
  
  public int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected void c()
  {
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter != null))
    {
      int i = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition();
      int j = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findLastVisibleItemPosition();
      while (i <= j)
      {
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.a(i);
        Object localObject2 = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForPosition(i);
        if ((localObject1 != null) && (localObject2 != null) && ((localObject2 instanceof FeedViewHolder)))
        {
          localObject2 = (FeedViewHolder)localObject2;
          localObject1 = a(((StrangerInfo)localObject1).mUin, ((StrangerInfo)localObject1).mNickName, ((FeedViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView);
          ((FeedViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
        }
        i += 1;
      }
    }
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendBaseFragment", 2, "onFeedSendMsgClick() mActivity is null just return");
      }
    }
    StrangerInfo localStrangerInfo;
    do
    {
      return;
      localStrangerInfo = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.a(paramInt);
    } while (localStrangerInfo == null);
    ExtendFriendSendMsgHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localStrangerInfo.mUin, localStrangerInfo.mNickName, localStrangerInfo.voiceCode, 2, new ExtendFriendBaseFragment.1(this));
    ExtendFriendReport.a().a(3, localStrangerInfo.mUin, "", String.valueOf(paramInt + 1), ExtendFriendReport.a(localStrangerInfo.mStrRecomTrace), this.jdField_b_of_type_JavaLangString);
    ExpandReportUtils.a("click#voice_tab#message_btn", true, -1L, -1L, null, true, true);
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("onFocusChanged focused=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if (!paramBoolean) {
      ThreadManager.getUIHandler().post(new ExtendFriendBaseFragment.6(this));
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("onFooterItemClick", new Object[0]));
    }
    a(true);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.a(0, true);
  }
  
  public void d(int paramInt)
  {
    StrangerInfo localStrangerInfo = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.a(paramInt);
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (localStrangerInfo == null)) {
      return;
    }
    if (!jdField_e_of_type_Boolean)
    {
      localObject = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if ((localObject != null) && (((Card)localObject).declaration == null)) {
        ((ExtendFriendHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
      }
      jdField_e_of_type_Boolean = false;
    }
    Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForPosition(paramInt);
    boolean bool1;
    boolean bool2;
    if ((localObject != null) && ((localObject instanceof FeedViewHolder)))
    {
      bool1 = ((FeedViewHolder)localObject).b();
      bool2 = ((FeedViewHolder)localObject).a();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.create(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131689513, 3);
      if (!SimpleUIUtil.a())
      {
        if (bool1) {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131719071);
        }
        if (bool2) {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131719072);
        }
        if ((!bool2) && (!bool1)) {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131719073);
        }
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690800);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new ExtendFriendBaseFragment.2(this, localStrangerInfo, bool1, bool2, (RecyclerView.ViewHolder)localObject));
      if (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      }
      VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "plaza_click", "", 0, "", "");
      return;
      bool2 = false;
      bool1 = false;
    }
  }
  
  public void e() {}
  
  public void e(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.b(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.notifyDataSetChanged();
      QLog.i("ExtendFriendBaseFragment", 1, "@gdtadv onClickFeedBackHideAdv");
    }
  }
  
  protected void f()
  {
    synchronized (jdField_b_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppCardHandler != null)
      {
        long l1 = Long.valueOf(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getCurrentAccountUin()).longValue();
        Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          int i = ((Integer)this.jdField_b_of_type_JavaUtilMap.get(str)).intValue();
          if (i > 0)
          {
            long l2 = Long.valueOf(str).longValue();
            this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(l1, l2, null, 53, i, 0);
          }
        }
      }
    }
    this.jdField_b_of_type_JavaUtilMap.clear();
  }
  
  public void f(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("onDownloadFailed errCode=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    ThreadManager.getUIHandler().post(new ExtendFriendBaseFragment.5(this));
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
  
  protected void g(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("toggleVoice position=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForPosition(paramInt);
    if ((localObject != null) && ((localObject instanceof FeedViewHolder)))
    {
      localObject = (FeedViewHolder)localObject;
      if (((FeedViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.b())
      {
        ((FeedViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.d();
        if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendVoicePlayer != null) {
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendVoicePlayer.a();
        }
        this.jdField_a_of_type_Int = -1;
      }
    }
    else
    {
      return;
    }
    ((FeedViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.c();
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.a(paramInt);
      if ((localObject != null) && (!TextUtils.isEmpty(((StrangerInfo)localObject).mVoiceUrl)) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendVoicePlayer != null)) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendVoicePlayer.a(((StrangerInfo)localObject).mVoiceUrl);
      }
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void h()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        String str1 = (String)((Map.Entry)localObject).getKey();
        localObject = (ExtendFriendBaseFragment.ExposureFeedInfo)((Map.Entry)localObject).getValue();
        if (System.currentTimeMillis() - ((ExtendFriendBaseFragment.ExposureFeedInfo)localObject).jdField_a_of_type_Long >= this.jdField_c_of_type_Long)
        {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str1);
          String str2 = ExtendFriendReport.a(((ExtendFriendBaseFragment.ExposureFeedInfo)localObject).jdField_a_of_type_ComTencentMobileqqExtendfriendBeanStrangerInfo);
          str2 = String.format("%s_%s", new Object[] { ((ExtendFriendBaseFragment.ExposureFeedInfo)localObject).jdField_a_of_type_JavaLangString, str2 });
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009C6E", "0X8009C6E", 1, 0, "", String.valueOf(((ExtendFriendBaseFragment.ExposureFeedInfo)localObject).jdField_a_of_type_Int + 1), ExtendFriendReport.a(((ExtendFriendBaseFragment.ExposureFeedInfo)localObject).jdField_a_of_type_ComTencentMobileqqExtendfriendBeanStrangerInfo.mStrRecomTrace), str2);
        }
      }
    }
  }
  
  public void h(int paramInt)
  {
    FeedViewHolder localFeedViewHolder = (FeedViewHolder)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForPosition(paramInt);
    if (localFeedViewHolder == null) {
      return;
    }
    int[] arrayOfInt = new int[2];
    localFeedViewHolder.c.getLocationInWindow(arrayOfInt);
    NearbyZanAnimLayout localNearbyZanAnimLayout = this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout;
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilderFactory.a(3, this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.a).a();
    float f1 = arrayOfInt[0] + localFeedViewHolder.c.getPaddingLeft() + this.f;
    paramInt = arrayOfInt[1];
    int i = this.jdField_e_of_type_Int;
    localNearbyZanAnimLayout.a(localBitmap, f1, localFeedViewHolder.c.getPaddingTop() + (paramInt - i) + this.g);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      f();
    }
  }
  
  protected void i()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null) {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollToPosition(0);
    }
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("stopLastVoice mLastPlayVoicePos=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }));
    }
    if (this.jdField_a_of_type_Int >= 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendVoicePlayer != null) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendVoicePlayer.a();
      }
      Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForPosition(this.jdField_a_of_type_Int);
      if ((localObject != null) && ((localObject instanceof FeedViewHolder)))
      {
        localObject = (FeedViewHolder)localObject;
        if (((FeedViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.b()) {
          ((FeedViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.d();
        }
      }
      this.jdField_a_of_type_Int = -1;
    }
  }
  
  public void l()
  {
    this.h = ((ExtendFriendHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), true);
  }
  
  protected void m()
  {
    if (this.jdField_c_of_type_Int >= 0)
    {
      StrangerInfo localStrangerInfo = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.a(this.jdField_c_of_type_Int);
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
            this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.notifyItemChanged(this.jdField_c_of_type_Int);
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app;
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendHandler = ((ExtendFriendHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER));
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager = ((ExtendFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilderFactory = new FloatViewBuilderFactory(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.f = AIOUtils.a(17.5F, getResources());
    this.g = AIOUtils.a(7.0F, getResources());
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendVoicePlayer = new ExtendFriendVoicePlayer(this, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), this);
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager.a();
    if (paramBundle != null) {
      this.jdField_c_of_type_Long = paramBundle.t;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver);
    if (this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver == null) {
      this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = new GdtAppReceiver();
    }
    this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver.register(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    GdtGeneralManager.a().a();
    QLog.d("ExtendFriendBaseFragment", 2, "mGdtAppReceiver register");
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("onDecodeTaskCompleted uin=%s avatar=%s", new Object[] { paramString, paramBitmap }));
    }
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
        if (localIterator.hasNext())
        {
          localObject1 = (Map.Entry)localIterator.next();
          ImageView localImageView = (ImageView)((Map.Entry)localObject1).getKey();
          localObject1 = (String)((Map.Entry)localObject1).getValue();
          if ((localObject1 == null) || (!((String)localObject1).equals(paramString))) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendBaseFragment", 2, String.format("responseDecodeFace hit cache uin=%s avatar=%s", new Object[] { paramString, paramBitmap }));
          }
          localObject1 = localImageView.getTag(2131378870);
          if ((localObject1 == null) || (!(localObject1 instanceof String))) {
            break label218;
          }
          localObject1 = (String)localObject1;
          if (TextUtils.equals(paramString, (CharSequence)localObject1)) {
            localImageView.setImageDrawable(new BitmapDrawable(paramBitmap));
          }
          localIterator.remove();
        }
      }
      return;
      label218:
      Object localObject1 = null;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    g();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(null);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = null;
    }
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      this.jdField_a_of_type_JavaUtilMap.clear();
      this.jdField_a_of_type_JavaUtilMap = null;
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      ExtendFriendSendMsgHelper localExtendFriendSendMsgHelper = ExtendFriendSendMsgHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localExtendFriendSendMsgHelper != null) {
        localExtendFriendSendMsgHelper.a();
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver);
    }
    if (this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver != null)
    {
      this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver.unregister(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      QLog.d("ExtendFriendBaseFragment", 2, "mGdtAppReceiver unregister");
    }
  }
  
  public void onPause()
  {
    super.onPause();
    k();
    h();
    i();
  }
  
  public void onResume()
  {
    super.onResume();
    ExtendFriendReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "");
    ExtendFriendReport.b();
    g();
    b(true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendBaseFragment
 * JD-Core Version:    0.7.0.1
 */