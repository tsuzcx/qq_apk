package com.tencent.mobileqq.extendfriend.fragment;

import agej;
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
import anum;
import anyw;
import anzj;
import aoof;
import aoog;
import asvg;
import asvi;
import asvr;
import asvt;
import aswh;
import aswn;
import aswq;
import asxh;
import asxo;
import asxp;
import asxq;
import asxr;
import aszw;
import aszx;
import aszy;
import aszz;
import atci;
import atck;
import atcs;
import atcu;
import atcx;
import avsx;
import avsz;
import bdgb;
import bdll;
import bhmq;
import bhnv;
import blhq;
import blir;
import bnvx;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.pulltorefresh.extras.PullToRefreshRecyclerView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView;
import com.tencent.mobileqq.nearby.anim.NearbyZanAnimLayout;
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
  extends aszw
  implements Handler.Callback, aoog, aswh, aswn, aszz, atcu
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
  protected anum a;
  public aoof a;
  public asvg a;
  protected asvi a;
  private asvt jdField_a_of_type_Asvt = new asxq(this);
  public aszx a;
  public aszy a;
  protected atcs a;
  protected avsz a;
  protected blhq a;
  public blir a;
  protected GdtAppReceiver a;
  public QQAppInterface a;
  protected PullToRefreshRecyclerView a;
  protected NearbyZanAnimLayout a;
  protected QQToast a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ExtendFriendBaseFragment.3(this);
  protected String a;
  public Map<ImageView, String> a;
  private ConcurrentHashMap<String, asxr> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
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
    this.jdField_b_of_type_JavaLangString = asvi.jdField_a_of_type_JavaLangString;
    this.jdField_c_of_type_Long = 2L;
    this.jdField_d_of_type_Long = -1L;
  }
  
  private ArrayList<asxr> a()
  {
    localArrayList = new ArrayList();
    try
    {
      int i = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstCompletelyVisibleItemPosition();
      int j = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findLastCompletelyVisibleItemPosition();
      if ((i >= 0) && (i < this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.getItemCount()) && (j >= 0) && (j < this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.getItemCount()) && (i <= j)) {
        while (i <= j)
        {
          if (this.jdField_a_of_type_Aszx.getItemViewType(i) == 0)
          {
            asxh localasxh = this.jdField_a_of_type_Aszx.a(i);
            if (localasxh != null)
            {
              asxr localasxr = new asxr(null);
              localasxr.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
              localasxr.jdField_a_of_type_Int = i;
              localasxr.jdField_a_of_type_Asxh = localasxh;
              localArrayList.add(localasxr);
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
      if (this.jdField_a_of_type_Aoof != null) {
        localBitmap = this.jdField_a_of_type_Aoof.a(1, paramString1);
      }
      if (localBitmap == null) {
        if (!this.jdField_c_of_type_Boolean)
        {
          if (paramImageView != null) {
            paramImageView.setTag(2131378384, paramString1);
          }
          if ((this.jdField_a_of_type_JavaUtilMap != null) && (this.jdField_a_of_type_Aoof != null))
          {
            this.jdField_a_of_type_Aoof.a(paramString1, 1, true);
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
          paramString1 = bhmq.a();
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
    if (this.jdField_a_of_type_Aszx != null)
    {
      asxh localasxh = this.jdField_a_of_type_Aszx.a(paramInt);
      if (localasxh != null)
      {
        int i = localasxh.mVoiceDuration / 10;
        bdll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", localasxh.mUin, "0X80092CF", "0X80092CF", i + 1, 0, "", String.valueOf(paramInt + 1), atci.a(localasxh.mStrRecomTrace), this.jdField_b_of_type_JavaLangString);
        bdll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", localasxh.mUin, "0X8009C70", "0X8009C70", 0, 0, "", String.valueOf(paramInt + 1), atci.a(localasxh.mStrRecomTrace), this.jdField_b_of_type_JavaLangString);
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
    asxh localasxh = this.jdField_a_of_type_Aszx.a(paramInt1);
    if (localasxh != null)
    {
      atci.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localasxh.mStrRecomTrace);
      bdll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", localasxh.mUin, "0X80092D0", "0X80092D0", 0, 0, "", String.valueOf(paramInt1 + 1), atci.a(localasxh.mStrRecomTrace), this.jdField_b_of_type_JavaLangString);
      bdll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", localasxh.mUin, "0X8009C6F", "0X8009C6F", paramInt2, 0, "", String.valueOf(paramInt1 + 1), atci.a(localasxh.mStrRecomTrace), this.jdField_b_of_type_JavaLangString);
      ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(localasxh.mUin, 96);
      localAllInOne.h = localasxh.mNickName;
      localAllInOne.c = localasxh.voiceCode;
      localAllInOne.l = 1;
      ProfileActivity.b(getActivity(), localAllInOne, a());
      this.jdField_c_of_type_Int = paramInt1;
      this.jdField_d_of_type_Boolean = true;
      this.jdField_c_of_type_JavaLangString = localasxh.mUin;
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      atci.a(2, paramInt1, localasxh.mStrRecomTrace, this.jdField_b_of_type_JavaLangString, localasxh);
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
      localCard = ((anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      if (localCard != null) {
        if (paramBoolean1) {
          if (TextUtils.isEmpty(localCard.declaration)) {
            break label105;
          }
        }
      }
    }
    label105:
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
    Object localObject = ((anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    Intent localIntent = new Intent();
    localObject = new ExtendFriendProfileEditFragment.ExtendFriendInfo((Card)localObject);
    if ((paramViewHolder != null) && ((paramViewHolder instanceof aswq))) {
      j = ((aswq)paramViewHolder).b();
    }
    for (int i = ((aswq)paramViewHolder).a();; i = 0)
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
    if (asvi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null)
      {
        if (this.jdField_a_of_type_AndroidAppDialog == null) {
          this.jdField_a_of_type_AndroidAppDialog = atcx.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
        }
        if ((!this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())) {
          this.jdField_a_of_type_AndroidAppDialog.show();
        }
      }
      return true;
    }
    return false;
  }
  
  public void av_()
  {
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager != null) && (this.jdField_a_of_type_Aszx != null))
    {
      int i = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition();
      int j = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findLastVisibleItemPosition();
      while (i <= j)
      {
        Object localObject1 = this.jdField_a_of_type_Aszx.a(i);
        Object localObject2 = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForPosition(i);
        if ((localObject1 != null) && (localObject2 != null) && ((localObject2 instanceof aswq)))
        {
          localObject2 = (aswq)localObject2;
          localObject1 = a(((asxh)localObject1).mUin, ((asxh)localObject1).mNickName, ((aswq)localObject2).jdField_a_of_type_AndroidWidgetImageView);
          ((aswq)localObject2).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
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
    asxh localasxh = this.jdField_a_of_type_Aszx.a(paramInt);
    if (localasxh != null)
    {
      if (localasxh.mAvailLikeCount <= 0) {
        break label299;
      }
      if (bhnv.d(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))
      {
        localasxh.mLiked = true;
        localasxh.mAvailLikeCount -= 1;
        bdll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", localasxh.mUin, "0X80092CD", "0X80092CD", 0, 0, "", String.valueOf(paramInt + 1), atci.a(localasxh.mStrRecomTrace), this.jdField_b_of_type_JavaLangString);
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "P_prof", "Prof_good", 9, 1, 0, Integer.toString(53), "1", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localasxh.mUin);
      }
    }
    else
    {
      synchronized (jdField_b_of_type_JavaLangObject)
      {
        localObject3 = (Integer)this.jdField_b_of_type_JavaUtilMap.get(localasxh.mUin);
        Object localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = Integer.valueOf(0);
        }
        this.jdField_b_of_type_JavaUtilMap.put(localasxh.mUin, Integer.valueOf(((Integer)localObject1).intValue() + 1));
        if (!this.jdField_a_of_type_Blhq.hasMessages(10))
        {
          localObject1 = Message.obtain();
          ((Message)localObject1).what = 10;
          this.jdField_a_of_type_Blhq.sendMessageDelayed((Message)localObject1, 1000L);
        }
        this.jdField_a_of_type_Aszx.notifyItemChanged(paramInt);
        h(paramInt);
        return;
      }
    }
    a(getString(2131719413), 1);
    return;
    label299:
    Object localObject3 = anzj.a(2131703155);
    String str;
    if ((localasxh.mGender == 1) || (localasxh.mGender == 2)) {
      if (localasxh.mGender == 2) {
        str = anzj.a(2131703152);
      }
    }
    for (;;)
    {
      a(String.format((String)localObject3, new Object[] { str, Integer.valueOf(b()) }), 0);
      return;
      str = anzj.a(2131703134);
      continue;
      str = anzj.a(2131703159);
    }
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Aszx == null) || (this.jdField_a_of_type_Aszx.a() <= 0) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    this.jdField_a_of_type_Blhq.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if (paramBoolean)
    {
      this.jdField_a_of_type_Blhq.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
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
    this.jdField_a_of_type_Aszx.a(0, true);
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendBaseFragment", 2, "onFeedSendMsgClick() mActivity is null just return");
      }
    }
    asxh localasxh;
    do
    {
      return;
      localasxh = this.jdField_a_of_type_Aszx.a(paramInt);
    } while (localasxh == null);
    atck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localasxh.mUin, localasxh.mNickName, localasxh.voiceCode, 2, new asxo(this));
    atci.a().a(3, localasxh.mUin, "", String.valueOf(paramInt + 1), atci.a(localasxh.mStrRecomTrace), this.jdField_b_of_type_JavaLangString);
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
    asxh localasxh = this.jdField_a_of_type_Aszx.a(paramInt);
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (localasxh == null)) {
      return;
    }
    if (!jdField_e_of_type_Boolean)
    {
      if (((anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).declaration == null) {
        ((asvg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(127)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
      }
      jdField_e_of_type_Boolean = false;
    }
    RecyclerView.ViewHolder localViewHolder = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForPosition(paramInt);
    boolean bool1;
    boolean bool2;
    if ((localViewHolder != null) && ((localViewHolder instanceof aswq)))
    {
      bool1 = ((aswq)localViewHolder).b();
      bool2 = ((aswq)localViewHolder).a();
    }
    for (;;)
    {
      this.jdField_a_of_type_Blir = blir.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.jdField_a_of_type_Blir.a(2131689512, 3);
      if (!bdgb.b())
      {
        if (bool1) {
          this.jdField_a_of_type_Blir.b(2131717922);
        }
        if (bool2) {
          this.jdField_a_of_type_Blir.b(2131717923);
        }
        if ((!bool2) && (!bool1)) {
          this.jdField_a_of_type_Blir.b(2131717924);
        }
      }
      this.jdField_a_of_type_Blir.c(2131690580);
      this.jdField_a_of_type_Blir.a(new asxp(this, localasxh, bool1, bool2, localViewHolder));
      if (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) {
        this.jdField_a_of_type_Blir.show();
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
      if (this.jdField_a_of_type_Anum != null)
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
            this.jdField_a_of_type_Anum.a(l1, l2, null, 53, i, 0);
          }
        }
      }
    }
    this.jdField_b_of_type_JavaUtilMap.clear();
  }
  
  public void e(int paramInt)
  {
    if (this.jdField_a_of_type_Aszx != null)
    {
      this.jdField_a_of_type_Aszx.b(paramInt);
      this.jdField_a_of_type_Aszx.notifyDataSetChanged();
      QLog.i("ExtendFriendBaseFragment", 1, "@gdtadv onClickFeedBackHideAdv");
    }
  }
  
  protected void f()
  {
    if ((this.jdField_d_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (this.jdField_d_of_type_Long > 0L))
    {
      long l = System.currentTimeMillis() - this.jdField_d_of_type_Long;
      if ((l > 0L) && (l < 3600000L)) {
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_c_of_type_JavaLangString, "0X8009C71", "0X8009C71", 0, 0, String.valueOf(l), "", "", this.jdField_b_of_type_JavaLangString);
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
        localObject = (asxr)((Map.Entry)localObject).getValue();
        if (System.currentTimeMillis() - ((asxr)localObject).jdField_a_of_type_Long >= this.jdField_c_of_type_Long)
        {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str1);
          String str2 = atci.a(((asxr)localObject).jdField_a_of_type_Asxh);
          str2 = String.format("%s_%s", new Object[] { ((asxr)localObject).jdField_a_of_type_JavaLangString, str2 });
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009C6E", "0X8009C6E", 1, 0, "", String.valueOf(((asxr)localObject).jdField_a_of_type_Int + 1), atci.a(((asxr)localObject).jdField_a_of_type_Asxh.mStrRecomTrace), str2);
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
    if ((localObject != null) && ((localObject instanceof aswq)))
    {
      localObject = (aswq)localObject;
      if (((aswq)localObject).jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.b())
      {
        ((aswq)localObject).jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.d();
        if (this.jdField_a_of_type_Atcs != null) {
          this.jdField_a_of_type_Atcs.a();
        }
        this.jdField_a_of_type_Int = -1;
      }
    }
    else
    {
      return;
    }
    ((aswq)localObject).jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.c();
    if (this.jdField_a_of_type_Aszx != null)
    {
      localObject = this.jdField_a_of_type_Aszx.a(paramInt);
      if ((localObject != null) && (!TextUtils.isEmpty(((asxh)localObject).mVoiceUrl)) && (this.jdField_a_of_type_Atcs != null)) {
        this.jdField_a_of_type_Atcs.a(((asxh)localObject).mVoiceUrl);
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
    aswq localaswq = (aswq)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForPosition(paramInt);
    if (localaswq == null) {
      return;
    }
    int[] arrayOfInt = new int[2];
    localaswq.c.getLocationInWindow(arrayOfInt);
    NearbyZanAnimLayout localNearbyZanAnimLayout = this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout;
    Bitmap localBitmap = this.jdField_a_of_type_Avsz.a(3, this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.a).a();
    float f1 = arrayOfInt[0] + localaswq.c.getPaddingLeft() + this.f;
    paramInt = arrayOfInt[1];
    int i = this.jdField_e_of_type_Int;
    localNearbyZanAnimLayout.a(localBitmap, f1, localaswq.c.getPaddingTop() + (paramInt - i) + this.g);
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
      if (this.jdField_a_of_type_Atcs != null) {
        this.jdField_a_of_type_Atcs.a();
      }
      Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForPosition(this.jdField_a_of_type_Int);
      if ((localObject != null) && ((localObject instanceof aswq)))
      {
        localObject = (aswq)localObject;
        if (((aswq)localObject).jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.b()) {
          ((aswq)localObject).jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.d();
        }
      }
      this.jdField_a_of_type_Int = -1;
    }
  }
  
  public void k()
  {
    this.h = ((asvg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(127)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), true);
  }
  
  protected void l()
  {
    if (this.jdField_c_of_type_Int >= 0)
    {
      asxh localasxh = this.jdField_a_of_type_Aszx.a(this.jdField_c_of_type_Int);
      if (localasxh != null)
      {
        Card localCard = ((anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(localasxh.mUin);
        if (localCard != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendBaseFragment", 2, String.format("syncLikeStatus bVoted=%s bAvailVoteCnt=%s mAvailLikeCount=%s", new Object[] { Byte.valueOf(localCard.bVoted), Short.valueOf(localCard.bAvailVoteCnt), Integer.valueOf(localasxh.mAvailLikeCount) }));
          }
          if ((localCard.bVoted > 0) && (localCard.bAvailVoteCnt < localasxh.mAvailLikeCount))
          {
            localasxh.mLiked = true;
            localasxh.mAvailLikeCount = localCard.bAvailVoteCnt;
            this.jdField_a_of_type_Aszx.notifyItemChanged(this.jdField_c_of_type_Int);
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
    this.jdField_a_of_type_Asvg = ((asvg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(127));
    this.jdField_a_of_type_Anum = ((anum)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2));
    this.jdField_a_of_type_Asvi = ((asvi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(264));
    this.jdField_a_of_type_Aoof = new aoof(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Aoof.a(this);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_Avsz = new avsz(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.f = agej.a(17.5F, getResources());
    this.g = agej.a(7.0F, getResources());
    this.jdField_a_of_type_Atcs = new atcs(this, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_Blhq = new blhq(ThreadManager.getSubThreadLooper(), this);
    paramBundle = this.jdField_a_of_type_Asvi.a();
    if (paramBundle != null) {
      this.jdField_c_of_type_Long = paramBundle.m;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Asvt);
    if (this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver == null) {
      this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = new GdtAppReceiver();
    }
    this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver.register(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    bnvx.a().a();
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
          localObject1 = localImageView.getTag(2131378384);
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
    if (this.jdField_a_of_type_Aoof != null)
    {
      this.jdField_a_of_type_Aoof.a(null);
      this.jdField_a_of_type_Aoof.d();
      this.jdField_a_of_type_Aoof = null;
    }
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      this.jdField_a_of_type_JavaUtilMap.clear();
      this.jdField_a_of_type_JavaUtilMap = null;
    }
    this.jdField_a_of_type_Blhq.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Asvt);
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
    atci.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "");
    atci.b();
    f();
    b(true);
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_Blhq.hasMessages(10))
    {
      this.jdField_a_of_type_Blhq.removeMessages(10);
      e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendBaseFragment
 * JD-Core Version:    0.7.0.1
 */