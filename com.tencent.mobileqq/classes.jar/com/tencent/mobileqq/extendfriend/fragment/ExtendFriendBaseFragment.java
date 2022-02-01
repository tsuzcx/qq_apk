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
import anri;
import anvk;
import anvx;
import aslm;
import aslo;
import aslx;
import aslz;
import asmq;
import asmw;
import asmz;
import asnq;
import asob;
import asoc;
import asod;
import asoe;
import asqj;
import asqk;
import asql;
import asqm;
import assw;
import assy;
import astg;
import asti;
import astl;
import avls;
import avlu;
import bdfk;
import bdla;
import bheg;
import bkys;
import bkzi;
import bmnn;
import com.tencent.beacon.event.UserAction;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.pulltorefresh.extras.PullToRefreshRecyclerView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView;
import com.tencent.mobileqq.nearby.anim.NearbyZanAnimLayout;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
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
  extends asqj
  implements Handler.Callback, asmq, asmw, asqm, asti, FaceDecoder.DecodeTaskCompletionListener
{
  public static final Object a;
  protected static final Object b;
  private static boolean e;
  protected int a;
  protected long a;
  protected Dialog a;
  public FragmentActivity a;
  public LinearLayoutManager a;
  protected RecyclerView.AdapterDataObserver a;
  public RecyclerView a;
  protected anri a;
  public aslm a;
  protected aslo a;
  private aslz jdField_a_of_type_Aslz = new asod(this);
  public asqk a;
  public asql a;
  protected astg a;
  protected avlu a;
  protected bkys a;
  public bkzi a;
  protected GdtAppReceiver a;
  public QQAppInterface a;
  public FaceDecoder a;
  protected PullToRefreshRecyclerView a;
  protected NearbyZanAnimLayout a;
  protected QQToast a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ExtendFriendBaseFragment.3(this);
  protected String a;
  public Map<ImageView, String> a;
  private ConcurrentHashMap<String, asoe> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public boolean a;
  protected int b;
  public long b;
  public String b;
  protected Map<String, Integer> b;
  public boolean b;
  public int c;
  protected long c;
  protected String c;
  public boolean c;
  protected int d;
  protected long d;
  protected boolean d;
  public int e;
  protected int f;
  protected int g;
  private int h;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_b_of_type_JavaLangObject = new Object();
  }
  
  public ExtendFriendBaseFragment()
  {
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_b_of_type_JavaLangString = aslo.jdField_a_of_type_JavaLangString;
    this.jdField_c_of_type_Long = 2L;
    this.jdField_d_of_type_Long = -1L;
  }
  
  private ArrayList<asoe> a()
  {
    localArrayList = new ArrayList();
    try
    {
      int i = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstCompletelyVisibleItemPosition();
      int j = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findLastCompletelyVisibleItemPosition();
      if ((i >= 0) && (i < this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.getItemCount()) && (j >= 0) && (j < this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.getItemCount()) && (i <= j)) {
        while (i <= j)
        {
          if (this.jdField_a_of_type_Asqk.getItemViewType(i) == 0)
          {
            asnq localasnq = this.jdField_a_of_type_Asqk.a(i);
            if (localasnq != null)
            {
              asoe localasoe = new asoe(null);
              localasoe.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
              localasoe.jdField_a_of_type_Int = i;
              localasoe.jdField_a_of_type_Asnq = localasnq;
              localArrayList.add(localasoe);
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
      if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null) {
        localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(1, paramString1);
      }
      if (localBitmap == null) {
        if (!this.jdField_c_of_type_Boolean)
        {
          if (paramImageView != null) {
            paramImageView.setTag(2131378439, paramString1);
          }
          if ((this.jdField_a_of_type_JavaUtilMap != null) && (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null))
          {
            this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeFace(paramString1, 1, true);
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
          paramString1 = bheg.a();
        }
        return new BitmapDrawable(paramString1);
      }
      this.jdField_a_of_type_JavaUtilMap.remove(paramImageView);
    }
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("onFeedVoiceClick position=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    if (this.jdField_a_of_type_Asqk != null)
    {
      asnq localasnq = this.jdField_a_of_type_Asqk.a(paramInt);
      if (localasnq != null)
      {
        int i = localasnq.mVoiceDuration / 10;
        bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", localasnq.mUin, "0X80092CF", "0X80092CF", i + 1, 0, "", String.valueOf(paramInt + 1), assw.a(localasnq.mStrRecomTrace), this.jdField_b_of_type_JavaLangString);
        bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", localasnq.mUin, "0X8009C70", "0X8009C70", 0, 0, "", String.valueOf(paramInt + 1), assw.a(localasnq.mStrRecomTrace), this.jdField_b_of_type_JavaLangString);
        UserAction.onUserActionToTunnel("0AND0Y11VZ3PFHQD", "click#feeds_page#kl_voice", true, -1L, -1L, null, true, true);
      }
    }
    if (paramInt != this.jdField_a_of_type_Int) {
      j();
    }
    g(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("onFeedItemClick position=%s", new Object[] { Integer.valueOf(paramInt1) }));
    }
    asnq localasnq = this.jdField_a_of_type_Asqk.a(paramInt1);
    if (localasnq != null)
    {
      assw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localasnq.mStrRecomTrace);
      bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", localasnq.mUin, "0X80092D0", "0X80092D0", 0, 0, "", String.valueOf(paramInt1 + 1), assw.a(localasnq.mStrRecomTrace), this.jdField_b_of_type_JavaLangString);
      bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", localasnq.mUin, "0X8009C6F", "0X8009C6F", paramInt2, 0, "", String.valueOf(paramInt1 + 1), assw.a(localasnq.mStrRecomTrace), this.jdField_b_of_type_JavaLangString);
      UserAction.onUserActionToTunnel("0AND0Y11VZ3PFHQD", "click#voice_tab#profile_photo", true, -1L, -1L, null, true, true);
      ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(localasnq.mUin, 96);
      localAllInOne.h = localasnq.mNickName;
      localAllInOne.c = localasnq.voiceCode;
      localAllInOne.l = 1;
      ProfileActivity.b(getActivity(), localAllInOne, a());
      this.jdField_c_of_type_Int = paramInt1;
      this.jdField_d_of_type_Boolean = true;
      this.jdField_c_of_type_JavaLangString = localasnq.mUin;
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      assw.a(2, paramInt1, localasnq.mStrRecomTrace, this.jdField_b_of_type_JavaLangString, localasnq);
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
      if ((!this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.c()) || (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramString)) || (this.jdField_d_of_type_Int != paramInt))
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
      localCard = ((anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
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
    Object localObject = ((anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    Intent localIntent = new Intent();
    localObject = new ExtendFriendProfileEditFragment.ExtendFriendInfo((Card)localObject);
    if ((paramViewHolder != null) && ((paramViewHolder instanceof asmz))) {
      j = ((asmz)paramViewHolder).b();
    }
    for (int i = ((asmz)paramViewHolder).a();; i = 0)
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
    if (aslo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null)
      {
        if (this.jdField_a_of_type_AndroidAppDialog == null) {
          this.jdField_a_of_type_AndroidAppDialog = astl.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
        }
        if ((!this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())) {
          this.jdField_a_of_type_AndroidAppDialog.show();
        }
      }
      return true;
    }
    return false;
  }
  
  public void am_()
  {
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager != null) && (this.jdField_a_of_type_Asqk != null))
    {
      int i = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition();
      int j = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findLastVisibleItemPosition();
      while (i <= j)
      {
        Object localObject1 = this.jdField_a_of_type_Asqk.a(i);
        Object localObject2 = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForPosition(i);
        if ((localObject1 != null) && (localObject2 != null) && ((localObject2 instanceof asmz)))
        {
          localObject2 = (asmz)localObject2;
          localObject1 = a(((asnq)localObject1).mUin, ((asnq)localObject1).mNickName, ((asmz)localObject2).jdField_a_of_type_AndroidWidgetImageView);
          ((asmz)localObject2).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
        }
        i += 1;
      }
    }
  }
  
  protected int b()
  {
    return 0;
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("onFeedLikeClick position=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    asnq localasnq = this.jdField_a_of_type_Asqk.a(paramInt);
    if (localasnq != null)
    {
      if (localasnq.mAvailLikeCount <= 0) {
        break label323;
      }
      if (NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))
      {
        localasnq.mLiked = true;
        localasnq.mAvailLikeCount -= 1;
        bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", localasnq.mUin, "0X80092CD", "0X80092CD", 0, 0, "", String.valueOf(paramInt + 1), assw.a(localasnq.mStrRecomTrace), this.jdField_b_of_type_JavaLangString);
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "P_prof", "Prof_good", 9, 1, 0, Integer.toString(53), "1", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localasnq.mUin);
        UserAction.onUserActionToTunnel("0AND0Y11VZ3PFHQD", "click#voice_tab#like_btn", true, -1L, -1L, null, true, true);
      }
    }
    else
    {
      synchronized (jdField_b_of_type_JavaLangObject)
      {
        localObject3 = (Integer)this.jdField_b_of_type_JavaUtilMap.get(localasnq.mUin);
        Object localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = Integer.valueOf(0);
        }
        this.jdField_b_of_type_JavaUtilMap.put(localasnq.mUin, Integer.valueOf(((Integer)localObject1).intValue() + 1));
        if (!this.jdField_a_of_type_Bkys.hasMessages(10))
        {
          localObject1 = Message.obtain();
          ((Message)localObject1).what = 10;
          this.jdField_a_of_type_Bkys.sendMessageDelayed((Message)localObject1, 1000L);
        }
        this.jdField_a_of_type_Asqk.notifyItemChanged(paramInt);
        h(paramInt);
        return;
      }
    }
    a(getString(2131720190), 1);
    return;
    label323:
    Object localObject3 = anvx.a(2131703736);
    String str;
    if ((localasnq.mGender == 1) || (localasnq.mGender == 2)) {
      if (localasnq.mGender == 2) {
        str = anvx.a(2131703733);
      }
    }
    for (;;)
    {
      a(String.format((String)localObject3, new Object[] { str, Integer.valueOf(b()) }), 0);
      return;
      str = anvx.a(2131703715);
      continue;
      str = anvx.a(2131703740);
    }
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Asqk == null) || (this.jdField_a_of_type_Asqk.a() <= 0) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    this.jdField_a_of_type_Bkys.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if (paramBoolean)
    {
      this.jdField_a_of_type_Bkys.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
      return;
    }
    this.jdField_a_of_type_JavaLangRunnable.run();
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("onFooterItemClick", new Object[0]));
    }
    a(true);
    this.jdField_a_of_type_Asqk.a(0, true);
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendBaseFragment", 2, "onFeedSendMsgClick() mActivity is null just return");
      }
    }
    asnq localasnq;
    do
    {
      return;
      localasnq = this.jdField_a_of_type_Asqk.a(paramInt);
    } while (localasnq == null);
    assy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localasnq.mUin, localasnq.mNickName, localasnq.voiceCode, 2, new asob(this));
    assw.a().a(3, localasnq.mUin, "", String.valueOf(paramInt + 1), assw.a(localasnq.mStrRecomTrace), this.jdField_b_of_type_JavaLangString);
    UserAction.onUserActionToTunnel("0AND0Y11VZ3PFHQD", "click#voice_tab#message_btn", true, -1L, -1L, null, true, true);
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
  
  public void d() {}
  
  public void d(int paramInt)
  {
    asnq localasnq = this.jdField_a_of_type_Asqk.a(paramInt);
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (localasnq == null)) {
      return;
    }
    if (!jdField_e_of_type_Boolean)
    {
      localObject = ((anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if ((localObject != null) && (((Card)localObject).declaration == null)) {
        ((aslm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
      }
      jdField_e_of_type_Boolean = false;
    }
    Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForPosition(paramInt);
    boolean bool1;
    boolean bool2;
    if ((localObject != null) && ((localObject instanceof asmz)))
    {
      bool1 = ((asmz)localObject).b();
      bool2 = ((asmz)localObject).a();
    }
    for (;;)
    {
      this.jdField_a_of_type_Bkzi = bkzi.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.jdField_a_of_type_Bkzi.a(2131689512, 3);
      if (!bdfk.b())
      {
        if (bool1) {
          this.jdField_a_of_type_Bkzi.b(2131718548);
        }
        if (bool2) {
          this.jdField_a_of_type_Bkzi.b(2131718549);
        }
        if ((!bool2) && (!bool1)) {
          this.jdField_a_of_type_Bkzi.b(2131718550);
        }
      }
      this.jdField_a_of_type_Bkzi.c(2131690697);
      this.jdField_a_of_type_Bkzi.a(new asoc(this, localasnq, bool1, bool2, (RecyclerView.ViewHolder)localObject));
      if (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) {
        this.jdField_a_of_type_Bkzi.show();
      }
      VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "plaza_click", "", 0, "", "");
      return;
      bool2 = false;
      bool1 = false;
    }
  }
  
  protected void e()
  {
    synchronized (jdField_b_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Anri != null)
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
            this.jdField_a_of_type_Anri.a(l1, l2, null, 53, i, 0);
          }
        }
      }
    }
    this.jdField_b_of_type_JavaUtilMap.clear();
  }
  
  public void e(int paramInt)
  {
    if (this.jdField_a_of_type_Asqk != null)
    {
      this.jdField_a_of_type_Asqk.b(paramInt);
      this.jdField_a_of_type_Asqk.notifyDataSetChanged();
      QLog.i("ExtendFriendBaseFragment", 1, "@gdtadv onClickFeedBackHideAdv");
    }
  }
  
  protected void f()
  {
    if ((this.jdField_d_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (this.jdField_d_of_type_Long > 0L))
    {
      long l = System.currentTimeMillis() - this.jdField_d_of_type_Long;
      if ((l > 0L) && (l < 3600000L)) {
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_c_of_type_JavaLangString, "0X8009C71", "0X8009C71", 0, 0, String.valueOf(l), "", "", this.jdField_b_of_type_JavaLangString);
      }
      this.jdField_d_of_type_Boolean = false;
      this.jdField_c_of_type_JavaLangString = null;
      this.jdField_d_of_type_Long = -1L;
    }
  }
  
  public void f(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("onDownloadFailed errCode=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    ThreadManager.getUIHandler().post(new ExtendFriendBaseFragment.5(this));
  }
  
  public void g()
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
        localObject = (asoe)((Map.Entry)localObject).getValue();
        if (System.currentTimeMillis() - ((asoe)localObject).jdField_a_of_type_Long >= this.jdField_c_of_type_Long)
        {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str1);
          String str2 = assw.a(((asoe)localObject).jdField_a_of_type_Asnq);
          str2 = String.format("%s_%s", new Object[] { ((asoe)localObject).jdField_a_of_type_JavaLangString, str2 });
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009C6E", "0X8009C6E", 1, 0, "", String.valueOf(((asoe)localObject).jdField_a_of_type_Int + 1), assw.a(((asoe)localObject).jdField_a_of_type_Asnq.mStrRecomTrace), str2);
        }
      }
    }
  }
  
  protected void g(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("toggleVoice position=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForPosition(paramInt);
    if ((localObject != null) && ((localObject instanceof asmz)))
    {
      localObject = (asmz)localObject;
      if (((asmz)localObject).jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.b())
      {
        ((asmz)localObject).jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.d();
        if (this.jdField_a_of_type_Astg != null) {
          this.jdField_a_of_type_Astg.a();
        }
        this.jdField_a_of_type_Int = -1;
      }
    }
    else
    {
      return;
    }
    ((asmz)localObject).jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.c();
    if (this.jdField_a_of_type_Asqk != null)
    {
      localObject = this.jdField_a_of_type_Asqk.a(paramInt);
      if ((localObject != null) && (!TextUtils.isEmpty(((asnq)localObject).mVoiceUrl)) && (this.jdField_a_of_type_Astg != null)) {
        this.jdField_a_of_type_Astg.a(((asnq)localObject).mVoiceUrl);
      }
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void h()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public void h(int paramInt)
  {
    asmz localasmz = (asmz)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForPosition(paramInt);
    if (localasmz == null) {
      return;
    }
    int[] arrayOfInt = new int[2];
    localasmz.c.getLocationInWindow(arrayOfInt);
    NearbyZanAnimLayout localNearbyZanAnimLayout = this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout;
    Bitmap localBitmap = this.jdField_a_of_type_Avlu.a(3, this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.a).a();
    float f1 = arrayOfInt[0] + localasmz.c.getPaddingLeft() + this.f;
    paramInt = arrayOfInt[1];
    int i = this.jdField_e_of_type_Int;
    localNearbyZanAnimLayout.a(localBitmap, f1, localasmz.c.getPaddingTop() + (paramInt - i) + this.g);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      e();
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null) {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollToPosition(0);
    }
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("stopLastVoice mLastPlayVoicePos=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }));
    }
    if (this.jdField_a_of_type_Int >= 0)
    {
      if (this.jdField_a_of_type_Astg != null) {
        this.jdField_a_of_type_Astg.a();
      }
      Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForPosition(this.jdField_a_of_type_Int);
      if ((localObject != null) && ((localObject instanceof asmz)))
      {
        localObject = (asmz)localObject;
        if (((asmz)localObject).jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.b()) {
          ((asmz)localObject).jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.d();
        }
      }
      this.jdField_a_of_type_Int = -1;
    }
  }
  
  public void k()
  {
    this.h = ((aslm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), true);
  }
  
  protected void l()
  {
    if (this.jdField_c_of_type_Int >= 0)
    {
      asnq localasnq = this.jdField_a_of_type_Asqk.a(this.jdField_c_of_type_Int);
      if (localasnq != null)
      {
        Card localCard = ((anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(localasnq.mUin);
        if (localCard != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendBaseFragment", 2, String.format("syncLikeStatus bVoted=%s bAvailVoteCnt=%s mAvailLikeCount=%s", new Object[] { Byte.valueOf(localCard.bVoted), Short.valueOf(localCard.bAvailVoteCnt), Integer.valueOf(localasnq.mAvailLikeCount) }));
          }
          if ((localCard.bVoted > 0) && (localCard.bAvailVoteCnt < localasnq.mAvailLikeCount))
          {
            localasnq.mLiked = true;
            localasnq.mAvailLikeCount = localCard.bAvailVoteCnt;
            this.jdField_a_of_type_Asqk.notifyItemChanged(this.jdField_c_of_type_Int);
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
    this.jdField_a_of_type_Aslm = ((aslm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER));
    this.jdField_a_of_type_Anri = ((anri)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER));
    this.jdField_a_of_type_Aslo = ((aslo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_Avlu = new avlu(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.f = AIOUtils.dp2px(17.5F, getResources());
    this.g = AIOUtils.dp2px(7.0F, getResources());
    this.jdField_a_of_type_Astg = new astg(this, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_Bkys = new bkys(ThreadManager.getSubThreadLooper(), this);
    paramBundle = this.jdField_a_of_type_Aslo.a();
    if (paramBundle != null) {
      this.jdField_c_of_type_Long = paramBundle.m;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aslz);
    if (this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver == null) {
      this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = new GdtAppReceiver();
    }
    this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver.register(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    bmnn.a().a();
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
          localObject1 = localImageView.getTag(2131378439);
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
    f();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(null);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = null;
    }
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      this.jdField_a_of_type_JavaUtilMap.clear();
      this.jdField_a_of_type_JavaUtilMap = null;
    }
    this.jdField_a_of_type_Bkys.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      assy localassy = assy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localassy != null) {
        localassy.a();
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aslz);
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
    j();
    g();
    h();
  }
  
  public void onResume()
  {
    super.onResume();
    assw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "");
    assw.b();
    f();
    b(true);
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_Bkys.hasMessages(10))
    {
      this.jdField_a_of_type_Bkys.removeMessages(10);
      e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendBaseFragment
 * JD-Core Version:    0.7.0.1
 */