package com.tencent.mobileqq.extendfriend.fragment;

import acqx;
import acqy;
import acqz;
import acra;
import acrc;
import acrd;
import acrf;
import acrg;
import acrh;
import acri;
import acrj;
import acrl;
import acrm;
import acro;
import acrp;
import acrq;
import acrr;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.SimpleItemAnimator;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.ExtendFriendHandler;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.ExtendFriendObserver;
import com.tencent.mobileqq.extendfriend.pulltorefresh.ILoadingLayout;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase.OnRefreshListener2;
import com.tencent.mobileqq.extendfriend.pulltorefresh.extras.PullToRefreshRecyclerView;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendVoicePlayer;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendVoicePlayer.ExtendFriendVoicePlayerListener;
import com.tencent.mobileqq.extendfriend.utils.ProfileGuideDialogUtils;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView;
import com.tencent.mobileqq.extendfriend.wiget.WrapContentLinearLayoutManager;
import com.tencent.mobileqq.hotchat.ui.BaseFloatViewBuilder;
import com.tencent.mobileqq.hotchat.ui.FloatViewBuilderFactory;
import com.tencent.mobileqq.nearby.anim.NearbyZanAnimLayout;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.extendfriend.ExtendFriendSquareInfo.RspBody;
import com.tencent.pb.extendfriend.ExtendFriendSquareInfo.StrangerInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.os.MqqHandler;

public class ExtendFriendSquareFragment
  extends Fragment
  implements acrr, PullToRefreshBase.OnRefreshListener2, ExtendFriendVoicePlayer.ExtendFriendVoicePlayerListener
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private acrl jdField_a_of_type_Acrl = new acrl(this, null);
  private acro jdField_a_of_type_Acro;
  private acrp jdField_a_of_type_Acrp;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new acrc(this);
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView.AdapterDataObserver jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private CardHandler jdField_a_of_type_ComTencentMobileqqAppCardHandler;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new acra(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ExtendFriendHandler jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendHandler;
  private ExtendFriendObserver jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendObserver = new acqx(this);
  private PullToRefreshRecyclerView jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView;
  private ExtendFriendVoicePlayer jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendVoicePlayer;
  private FloatViewBuilderFactory jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilderFactory;
  private NearbyZanAnimLayout jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout;
  private QQToast jdField_a_of_type_ComTencentMobileqqWidgetQQToast;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  private String jdField_a_of_type_JavaLangString;
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int = -1;
  private long jdField_b_of_type_Long;
  private WeakReferenceHandler jdField_b_of_type_ComTencentUtilWeakReferenceHandler;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private int g;
  private int h;
  
  private void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast = new QQToast(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      }
      if ((!this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.c()) || (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramString)) || (this.jdField_a_of_type_Int != paramInt))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.a(QQToast.a(paramInt));
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.b(paramInt);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.a(paramString);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.d(0);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
        this.jdField_a_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_Int = paramInt;
      }
    }
  }
  
  private void a(boolean paramBoolean, ExtendFriendSquareInfo.RspBody paramRspBody)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("handleGetSquareStrangerList success=%s rspBody=%s", new Object[] { Boolean.valueOf(paramBoolean), paramRspBody }));
    }
    if (!isAdded()) {
      return;
    }
    if ((!paramBoolean) || (paramRspBody == null))
    {
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_Acro.a(1, true);
      }
      a(getString(2131439365), 1);
      if ((this.jdField_a_of_type_Acro != null) && (this.jdField_a_of_type_Acro.getItemCount() == 0)) {
        this.jdField_a_of_type_Acro.a(true);
      }
      if ((!this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView != null)) {
        if (!paramBoolean) {
          break label813;
        }
      }
    }
    label656:
    label662:
    label668:
    label674:
    label680:
    label813:
    for (paramRspBody = "刷新成功 (｡･∀･)ﾉﾞ";; paramRspBody = "嘤嘤嘤刷新失败了(/▽＼)")
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.a(true, false).setRefreshResultLabel(paramRspBody);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.b();
      this.jdField_b_of_type_Boolean = false;
      return;
      for (;;)
      {
        acrq localacrq;
        try
        {
          if (paramRspBody.uint32_over.get() == 1)
          {
            bool1 = true;
            Object localObject = paramRspBody.bytes_rsp_page_cookies.get().toByteArray();
            if (paramRspBody.uint32_is_profile_complete.get() != 1) {
              break label656;
            }
            bool2 = true;
            if (paramRspBody.uint32_is_show_card.get() != 1) {
              break label662;
            }
            bool3 = true;
            int i = paramRspBody.uint32_friend_max_votes.get();
            this.jdField_d_of_type_Boolean = bool1;
            this.jdField_a_of_type_ArrayOfByte = ((byte[])localObject);
            this.jdField_e_of_type_Boolean = bool2;
            this.jdField_f_of_type_Boolean = bool3;
            this.h = i;
            if (QLog.isColorLevel()) {
              QLog.d("ExtendFriendSquareFragment", 2, String.format("handleGetSquareStrangerList mLoadOver=%s mRequestCookies=%s mProfileComplete=%s mShowCard=%s mMaxLikeCount=%s", new Object[] { Boolean.valueOf(this.jdField_d_of_type_Boolean), this.jdField_a_of_type_ArrayOfByte, Boolean.valueOf(this.jdField_e_of_type_Boolean), Boolean.valueOf(this.jdField_f_of_type_Boolean), Integer.valueOf(this.h) }));
            }
            if (!this.jdField_c_of_type_Boolean) {
              this.jdField_a_of_type_Acro.a();
            }
            if (this.jdField_d_of_type_Boolean) {
              this.jdField_a_of_type_Acro.a(2, false);
            }
            localObject = paramRspBody.rpt_msg_stranger_info.get();
            if ((localObject == null) || (((List)localObject).size() <= 0)) {
              break label735;
            }
            paramRspBody = new ArrayList();
            localObject = ((List)localObject).iterator();
            if (!((Iterator)localObject).hasNext()) {
              break label713;
            }
            ExtendFriendSquareInfo.StrangerInfo localStrangerInfo = (ExtendFriendSquareInfo.StrangerInfo)((Iterator)localObject).next();
            localacrq = new acrq(null);
            localacrq.jdField_a_of_type_JavaLangString = String.valueOf(localStrangerInfo.uint64_uin.get());
            localacrq.jdField_b_of_type_JavaLangString = localStrangerInfo.bytes_nick.get().toStringUtf8();
            localacrq.jdField_b_of_type_Int = localStrangerInfo.uint32_gender.get();
            if (localStrangerInfo.uint32_is_my_like.get() != 1) {
              break label668;
            }
            bool1 = true;
            localacrq.jdField_b_of_type_Boolean = bool1;
            localacrq.jdField_c_of_type_Int = localStrangerInfo.uint32_my_left_like_count.get();
            if (localStrangerInfo.uint32_addfri_status.get() != 1) {
              break label674;
            }
            bool1 = true;
            localacrq.jdField_c_of_type_Boolean = bool1;
            localacrq.jdField_d_of_type_Int = localStrangerInfo.uint32_popularity.get();
            localacrq.jdField_c_of_type_JavaLangString = localStrangerInfo.bytes_declaration.get().toStringUtf8();
            localacrq.jdField_d_of_type_JavaLangString = localStrangerInfo.bytes_voice_url.get().toStringUtf8();
            localacrq.jdField_e_of_type_Int = localStrangerInfo.uint32_voice_duration.get();
            if (!TextUtils.isEmpty(localacrq.jdField_c_of_type_JavaLangString))
            {
              localacrq.jdField_c_of_type_JavaLangString = localacrq.jdField_c_of_type_JavaLangString.replace('\n', ' ');
              localacrq.jdField_c_of_type_JavaLangString = localacrq.jdField_c_of_type_JavaLangString.trim();
            }
            if (TextUtils.isEmpty(localacrq.jdField_b_of_type_JavaLangString)) {
              break label680;
            }
            paramRspBody.add(localacrq);
            continue;
          }
        }
        catch (Exception paramRspBody)
        {
          QLog.e("ExtendFriendSquareFragment", 1, "handleGetSquareStrangerList fail!", paramRspBody);
        }
        boolean bool1 = false;
        continue;
        boolean bool2 = false;
        continue;
        boolean bool3 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        if (QLog.isColorLevel()) {
          QLog.w("ExtendFriendSquareFragment", 2, String.format("handleGetSquareStrangerList nick name is empty, uin=%s", new Object[] { localacrq.jdField_a_of_type_JavaLangString }));
        }
      }
      label713:
      if (this.jdField_a_of_type_Acro != null)
      {
        this.jdField_a_of_type_Acro.a(paramRspBody);
        this.jdField_a_of_type_Acro.notifyDataSetChanged();
      }
      label735:
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView != null)
      {
        paramRspBody = this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.a(true, false);
        if (paramRspBody != null)
        {
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          paramRspBody.setLastUpdatedLabel(String.format("%s%s", new Object[] { getResources().getString(2131434364), TimeFormatterUtils.a(this.jdField_a_of_type_Long, true, "yyyy-MM-dd") }));
        }
      }
      h();
      break;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("syncSwitchStatus syncProfileComplete=%s syncShowCard=%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) }));
    }
    Card localCard;
    if ((paramBoolean1) || (paramBoolean2))
    {
      localCard = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      if (localCard != null) {
        if (paramBoolean1) {
          if (TextUtils.isEmpty(localCard.declaration)) {
            break label109;
          }
        }
      }
    }
    label109:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      this.jdField_e_of_type_Boolean = paramBoolean1;
      if (paramBoolean2) {
        this.jdField_f_of_type_Boolean = localCard.isShowCard;
      }
      h();
      return;
    }
  }
  
  private boolean a()
  {
    for (;;)
    {
      try
      {
        if ((ExtendFriendManager.a == null) || (ExtendFriendManager.a.jdField_a_of_type_JavaUtilList == null) || (ExtendFriendManager.a.jdField_a_of_type_JavaUtilList.isEmpty())) {
          continue;
        }
        this.jdField_d_of_type_Boolean = ExtendFriendManager.a.jdField_a_of_type_Boolean;
        this.jdField_a_of_type_ArrayOfByte = ExtendFriendManager.a.jdField_a_of_type_ArrayOfByte;
        this.jdField_e_of_type_Boolean = ExtendFriendManager.a.jdField_b_of_type_Boolean;
        this.jdField_f_of_type_Boolean = ExtendFriendManager.a.jdField_c_of_type_Boolean;
        this.h = ExtendFriendManager.a.jdField_a_of_type_Int;
        this.jdField_a_of_type_Long = ExtendFriendManager.a.jdField_a_of_type_Long;
        if (this.jdField_a_of_type_Acro != null)
        {
          if (!this.jdField_d_of_type_Boolean) {
            continue;
          }
          this.jdField_a_of_type_Acro.a(2, false);
          this.jdField_a_of_type_Acro.a();
          this.jdField_a_of_type_Acro.a(ExtendFriendManager.a.jdField_a_of_type_JavaUtilList);
          this.jdField_a_of_type_Acro.notifyDataSetChanged();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView != null)
        {
          ILoadingLayout localILoadingLayout = this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.a(true, false);
          if (localILoadingLayout != null) {
            localILoadingLayout.setLastUpdatedLabel(String.format("%s%s", new Object[] { getResources().getString(2131434364), TimeFormatterUtils.a(ExtendFriendManager.a.jdField_a_of_type_Long, true, "yyyy-MM-dd") }));
          }
        }
        bool = true;
      }
      catch (Exception localException)
      {
        QLog.e("ExtendFriendSquareFragment", 1, "loadCacheData fail.", localException);
        boolean bool = false;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSquareFragment", 2, String.format("loadCacheData result=%s %s", new Object[] { Boolean.valueOf(bool), ExtendFriendManager.a }));
      }
      return bool;
      this.jdField_a_of_type_Acro.a(0, false);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("requestSquareStrangerList loadMore=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    this.jdField_c_of_type_Boolean = paramBoolean;
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_ArrayOfByte = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendHandler != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.jdField_a_of_type_ArrayOfByte, 20);
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  private void e()
  {
    if (this.jdField_c_of_type_Int >= 0)
    {
      acrq localacrq = this.jdField_a_of_type_Acro.a(this.jdField_c_of_type_Int);
      if (localacrq != null)
      {
        Card localCard = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(localacrq.jdField_a_of_type_JavaLangString);
        if (localCard != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendSquareFragment", 2, String.format("syncLikeStatus bVoted=%s bAvailVoteCnt=%s mAvailLikeCount=%s", new Object[] { Byte.valueOf(localCard.bVoted), Short.valueOf(localCard.bAvailVoteCnt), Integer.valueOf(localacrq.jdField_c_of_type_Int) }));
          }
          if ((localCard.bVoted > 0) && (localCard.bAvailVoteCnt < localacrq.jdField_c_of_type_Int))
          {
            localacrq.jdField_b_of_type_Boolean = true;
            localacrq.jdField_c_of_type_Int = localCard.bAvailVoteCnt;
            this.jdField_a_of_type_Acro.notifyItemChanged(this.jdField_c_of_type_Int);
          }
        }
      }
    }
  }
  
  private void f()
  {
    FragmentActivity localFragmentActivity = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    if (!this.jdField_e_of_type_Boolean) {}
    for (int i = 1;; i = 2)
    {
      this.jdField_a_of_type_AndroidAppDialog = ProfileGuideDialogUtils.a(localFragmentActivity, i, new acri(this));
      try
      {
        if (this.jdField_a_of_type_AndroidAppDialog != null)
        {
          this.jdField_a_of_type_AndroidAppDialog.show();
          if (!this.jdField_e_of_type_Boolean)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092EA", "0X80092EA", 0, 0, "", "", "", "");
            return;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092E7", "0X80092E7", 0, 0, "", "", "", "");
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("ExtendFriendSquareFragment", 1, "showProfileGuide fail.");
      }
      return;
    }
  }
  
  private void g()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppCardHandler != null)
      {
        long l1 = Long.valueOf(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getCurrentAccountUin()).longValue();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          int i = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(str)).intValue();
          if (i > 0)
          {
            long l2 = Long.valueOf(str).longValue();
            this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(l1, l2, null, 53, i, 0);
          }
        }
      }
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  private void g(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("toggleVoice position=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForPosition(paramInt);
    if ((localObject != null) && ((localObject instanceof acrm)))
    {
      localObject = (acrm)localObject;
      if (((acrm)localObject).a.b())
      {
        ((acrm)localObject).a.d();
        if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendVoicePlayer != null) {
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendVoicePlayer.a();
        }
        this.jdField_d_of_type_Int = -1;
      }
    }
    else
    {
      return;
    }
    ((acrm)localObject).a.c();
    if (this.jdField_a_of_type_Acro != null)
    {
      localObject = this.jdField_a_of_type_Acro.a(paramInt);
      if ((localObject != null) && (!TextUtils.isEmpty(((acrq)localObject).jdField_d_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendVoicePlayer != null)) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendVoicePlayer.a(((acrq)localObject).jdField_d_of_type_JavaLangString);
      }
    }
    this.jdField_d_of_type_Int = paramInt;
  }
  
  private void h()
  {
    try
    {
      if (ExtendFriendManager.a == null)
      {
        ExtendFriendManager.a = new ExtendFriendSquareFragment.CacheData();
        ExtendFriendManager.a.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      ExtendFriendManager.a.jdField_a_of_type_JavaUtilList.clear();
      if (this.jdField_a_of_type_Acro != null)
      {
        ExtendFriendManager.a.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_Acro.a());
        ExtendFriendManager.a.jdField_a_of_type_Boolean = this.jdField_d_of_type_Boolean;
        ExtendFriendManager.a.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
        ExtendFriendManager.a.jdField_b_of_type_Boolean = this.jdField_e_of_type_Boolean;
        ExtendFriendManager.a.jdField_c_of_type_Boolean = this.jdField_f_of_type_Boolean;
        ExtendFriendManager.a.jdField_a_of_type_Int = this.h;
        ExtendFriendManager.a.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ExtendFriendManager.a = null;
        QLog.e("ExtendFriendSquareFragment", 1, "saveCacheData fail.", localException);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("saveCacheData %s", new Object[] { ExtendFriendManager.a }));
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("onFooterItemClick", new Object[0]));
    }
    b(true);
    this.jdField_a_of_type_Acro.a(0, true);
  }
  
  public void a(int paramInt)
  {
    acrm localacrm = (acrm)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForPosition(paramInt);
    if (localacrm == null) {
      return;
    }
    int[] arrayOfInt = new int[2];
    localacrm.c.getLocationInWindow(arrayOfInt);
    NearbyZanAnimLayout localNearbyZanAnimLayout = this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout;
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilderFactory.a(3, this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.a).a();
    float f1 = arrayOfInt[0] + localacrm.c.getPaddingLeft() + this.jdField_f_of_type_Int;
    paramInt = arrayOfInt[1];
    int i = this.jdField_e_of_type_Int;
    localNearbyZanAnimLayout.a(localBitmap, f1, localacrm.c.getPaddingTop() + (paramInt - i) + this.g);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("playerCompletion path=%s", new Object[] { paramString }));
    }
    ThreadManager.getUIHandler().post(new acqz(this));
  }
  
  public void a(PullToRefreshBase paramPullToRefreshBase)
  {
    if (this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.hasMessages(10))
    {
      this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(10);
      g();
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092D4", "0X80092D4", 0, 0, "", "", "", "");
    if (NetworkUtil.g(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))
    {
      b(false);
      d();
    }
    for (;;)
    {
      this.jdField_a_of_type_Acro.a(0, true);
      return;
      a(getString(2131437550), 1);
      a(false, null);
    }
  }
  
  public void a(File paramFile)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("onDownloadFinish path=%s", new Object[] { paramFile.getAbsoluteFile() }));
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2) {}
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("onFocusChanged focused=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if (!paramBoolean) {
      ThreadManager.getUIHandler().post(new acqy(this));
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null) {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollToPosition(0);
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("onFeedItemClick position=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092D0", "0X80092D0", 0, 0, "", "", "", "");
    Object localObject = this.jdField_a_of_type_Acro.a(paramInt);
    if (localObject != null)
    {
      localObject = new ProfileActivity.AllInOne(((acrq)localObject).jdField_a_of_type_JavaLangString, 96);
      ProfileActivity.b(getActivity(), (ProfileActivity.AllInOne)localObject, 1031);
      this.jdField_c_of_type_Int = paramInt;
    }
  }
  
  public void b(PullToRefreshBase paramPullToRefreshBase) {}
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public void c()
  {
    Card localCard = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    boolean bool;
    int i;
    if (localCard != null)
    {
      if (TextUtils.isEmpty(localCard.declaration)) {
        break label273;
      }
      bool = true;
      this.jdField_e_of_type_Boolean = bool;
      this.jdField_f_of_type_Boolean = localCard.isShowCard;
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSquareFragment", 2, String.format("addMyFeed mProfileComplete=%s mShowCard=%s", new Object[] { Boolean.valueOf(this.jdField_e_of_type_Boolean), Boolean.valueOf(this.jdField_f_of_type_Boolean) }));
      }
      if (this.jdField_a_of_type_Acro != null)
      {
        if (localCard.shGender != 0) {
          break label278;
        }
        i = 1;
      }
    }
    for (;;)
    {
      label115:
      acrq localacrq = this.jdField_a_of_type_Acro.a(0);
      if ((localacrq != null) && (TextUtils.equals(localacrq.jdField_a_of_type_JavaLangString, localCard.uin)))
      {
        localacrq.jdField_a_of_type_Boolean = true;
        localacrq.jdField_a_of_type_JavaLangString = localCard.uin;
        localacrq.jdField_b_of_type_JavaLangString = localCard.strNick;
        localacrq.jdField_b_of_type_Int = i;
        localacrq.jdField_d_of_type_Int = localCard.popularity;
        localacrq.jdField_c_of_type_JavaLangString = localCard.declaration;
        localacrq.jdField_d_of_type_JavaLangString = localCard.voiceUrl;
        localacrq.jdField_e_of_type_Int = localCard.extendFriendVoiceDuration;
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(localacrq.jdField_c_of_type_JavaLangString))
        {
          localacrq.jdField_c_of_type_JavaLangString = localacrq.jdField_c_of_type_JavaLangString.replace('\n', ' ');
          localacrq.jdField_c_of_type_JavaLangString = localacrq.jdField_c_of_type_JavaLangString.trim();
        }
        if ((!this.jdField_f_of_type_Boolean) || (!this.jdField_e_of_type_Boolean)) {
          this.jdField_a_of_type_Acro.a(0);
        }
        this.jdField_a_of_type_Acro.notifyDataSetChanged();
        return;
        label273:
        bool = false;
        break;
        label278:
        if (localCard.shGender != 1) {
          break label377;
        }
        i = 2;
        break label115;
        localacrq = new acrq(null);
        localacrq.jdField_a_of_type_Boolean = true;
        localacrq.jdField_a_of_type_JavaLangString = localCard.uin;
        localacrq.jdField_b_of_type_JavaLangString = localCard.strNick;
        localacrq.jdField_b_of_type_Int = i;
        localacrq.jdField_d_of_type_Int = localCard.popularity;
        localacrq.jdField_c_of_type_JavaLangString = localCard.declaration;
        localacrq.jdField_d_of_type_JavaLangString = localCard.voiceUrl;
        localacrq.jdField_e_of_type_Int = localCard.extendFriendVoiceDuration;
        this.jdField_a_of_type_Acro.a(0, localacrq);
      }
      label377:
      i = 0;
    }
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("onFeedVoiceClick position=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    if (this.jdField_a_of_type_Acro != null)
    {
      acrq localacrq = this.jdField_a_of_type_Acro.a(paramInt);
      if (localacrq != null)
      {
        int i = localacrq.jdField_e_of_type_Int / 10;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092CF", "0X80092CF", i + 1, 0, "", "", "", "");
      }
    }
    if (paramInt != this.jdField_d_of_type_Int) {
      d();
    }
    g(paramInt);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("stopLastVoice mLastPlayVoicePos=%s", new Object[] { Integer.valueOf(this.jdField_d_of_type_Int) }));
    }
    if (this.jdField_d_of_type_Int >= 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendVoicePlayer != null) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendVoicePlayer.a();
      }
      Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForPosition(this.jdField_d_of_type_Int);
      if ((localObject != null) && ((localObject instanceof acrm)))
      {
        localObject = (acrm)localObject;
        if (((acrm)localObject).a.b()) {
          ((acrm)localObject).a.d();
        }
      }
      this.jdField_d_of_type_Int = -1;
    }
  }
  
  public void d(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("onFeedLikeClick position=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    acrq localacrq = this.jdField_a_of_type_Acro.a(paramInt);
    if (localacrq != null)
    {
      if (localacrq.jdField_c_of_type_Int <= 0) {
        break label249;
      }
      if (NetworkUtil.d(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))
      {
        localacrq.jdField_b_of_type_Boolean = true;
        localacrq.jdField_c_of_type_Int -= 1;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", localacrq.jdField_a_of_type_JavaLangString, "0X80092CD", "0X80092CD", 0, 0, "", "", "", "");
      }
    }
    else
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilMap.get(localacrq.jdField_a_of_type_JavaLangString);
        Object localObject1 = localInteger;
        if (localInteger == null) {
          localObject1 = Integer.valueOf(0);
        }
        this.jdField_a_of_type_JavaUtilMap.put(localacrq.jdField_a_of_type_JavaLangString, Integer.valueOf(((Integer)localObject1).intValue() + 1));
        if (!this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.hasMessages(10))
        {
          localObject1 = Message.obtain();
          ((Message)localObject1).what = 10;
          this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.sendMessageDelayed((Message)localObject1, 1000L);
        }
        this.jdField_a_of_type_Acro.notifyItemChanged(paramInt);
        a(paramInt);
        return;
      }
    }
    a(getString(2131435782), 1);
    return;
    label249:
    String str;
    if ((localacrq.jdField_b_of_type_Int == 1) || (localacrq.jdField_b_of_type_Int == 2)) {
      if (localacrq.jdField_b_of_type_Int == 2) {
        str = "她";
      }
    }
    for (;;)
    {
      a(String.format("每天最多给%s点%s个赞哦。", new Object[] { str, Integer.valueOf(this.h) }), 0);
      return;
      str = "他";
      continue;
      str = "他（她）";
    }
  }
  
  public void e(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("onFeedAddFriendClick position=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092CB", "0X80092CB", 0, 0, "", "", "", "");
    if ((!this.jdField_e_of_type_Boolean) || (!this.jdField_f_of_type_Boolean)) {
      f();
    }
    acrq localacrq;
    do
    {
      return;
      localacrq = this.jdField_a_of_type_Acro.a(paramInt);
    } while ((localacrq == null) || (localacrq.jdField_c_of_type_Boolean));
    startActivityForResult(AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, localacrq.jdField_a_of_type_JavaLangString, null, 3094, 2, localacrq.jdField_b_of_type_JavaLangString, null, null, null, null), 1);
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void f(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("onDownloadFailed errCode=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    ThreadManager.getUIHandler().post(new acrj(this));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("onActivityResult requestCode=%s resultCode=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    if (paramInt1 == 1031)
    {
      e();
      a(true, true);
      if (paramInt2 == 8193) {
        c();
      }
      this.jdField_c_of_type_Int = -1;
    }
    do
    {
      do
      {
        return;
        if ((paramInt1 != 1) || (paramInt2 != -1)) {
          break;
        }
        paramIntent = this.jdField_a_of_type_Acro.a(this.jdField_b_of_type_Int);
      } while ((paramIntent == null) || (paramIntent.jdField_c_of_type_Boolean));
      paramIntent.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_Acro.notifyItemChanged(this.jdField_b_of_type_Int);
      return;
    } while ((paramInt1 != 2) || (paramInt2 != -1));
    a(false, true);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "onCreate");
    }
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendHandler = ((ExtendFriendHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(128));
      this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), null);
    this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendVoicePlayer = new ExtendFriendVoicePlayer(this, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilderFactory = new FloatViewBuilderFactory(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_f_of_type_Int = AIOUtils.a(17.5F, getResources());
    this.g = AIOUtils.a(7.0F, getResources());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "onCreateView");
    }
    paramLayoutInflater = paramLayoutInflater.inflate(2130970351, null);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView = ((PullToRefreshRecyclerView)paramLayoutInflater.findViewById(2131370102));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.setOnRefreshListener(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new WrapContentLinearLayoutManager(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.a());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    ((SimpleItemAnimator)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOnScrollListener(new acrd(this));
    this.jdField_a_of_type_Acrp = new acrp(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver = new acrf(this);
    this.jdField_a_of_type_Acro = new acro(this, this);
    this.jdField_a_of_type_Acro.registerAdapterDataObserver(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver);
    this.jdField_a_of_type_Acro.a(this.jdField_a_of_type_Acrl);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Acro);
    this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout = ((NearbyZanAnimLayout)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.findViewById(2131370086));
    paramViewGroup = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.findViewById(2131363570);
    paramViewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new acrg(this, paramViewGroup));
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "onDestroy");
    }
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    }
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver != null) {
      this.jdField_a_of_type_Acro.unregisterAdapterDataObserver(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver);
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = null;
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendHandler = null;
    if (this.jdField_a_of_type_Acrl != null)
    {
      this.jdField_a_of_type_Acrl.a();
      this.jdField_a_of_type_Acrl = null;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    d();
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "onResume");
    }
    super.onResume();
    if ((!this.jdField_a_of_type_Boolean) && (isAdded()))
    {
      boolean bool = a();
      long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSquareFragment", 2, String.format("onResume loadSuccess=%s interval=%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(l) }));
      }
      if ((!bool) || (l > 60000L)) {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.postDelayed(new acrh(this), 500L);
      }
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.hasMessages(10))
    {
      this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(10);
      g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment
 * JD-Core Version:    0.7.0.1
 */