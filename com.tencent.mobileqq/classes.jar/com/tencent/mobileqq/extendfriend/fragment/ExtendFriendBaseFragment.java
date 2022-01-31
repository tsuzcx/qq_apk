package com.tencent.mobileqq.extendfriend.fragment;

import aciy;
import ajfi;
import ajjj;
import ajjy;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.text.TextUtils;
import android.widget.ImageView;
import anod;
import anoe;
import anoh;
import anoj;
import anov;
import anpb;
import anpv;
import anpz;
import anqa;
import anqb;
import ansi;
import ansj;
import ansk;
import anty;
import anua;
import anuc;
import anue;
import aqel;
import aqen;
import awqx;
import azwg;
import azwh;
import bacm;
import badq;
import bbmy;
import befq;
import begr;
import bgqd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.pulltorefresh.extras.PullToRefreshRecyclerView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.nearby.anim.NearbyZanAnimLayout;
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
  extends PublicBaseFragment
  implements Handler.Callback, anov, ansk, anuc, azwh
{
  public static final Object a;
  protected static final Object b;
  protected int a;
  protected long a;
  protected ajfi a;
  public Dialog a;
  public FragmentActivity a;
  public LinearLayoutManager a;
  protected RecyclerView.AdapterDataObserver a;
  public RecyclerView a;
  public anod a;
  protected anoe a;
  private anoj jdField_a_of_type_Anoj = new anqb(this);
  public ansi a;
  public ansj a;
  protected anua a;
  protected aqen a;
  public azwg a;
  protected bbmy a;
  protected befq a;
  public begr a;
  protected GdtAppReceiver a;
  public QQAppInterface a;
  protected PullToRefreshRecyclerView a;
  protected NearbyZanAnimLayout a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ExtendFriendBaseFragment.2(this);
  protected String a;
  public Map<ImageView, String> a;
  private ConcurrentHashMap<String, Long> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  public boolean a;
  protected int b;
  protected long b;
  protected Dialog b;
  protected String b;
  protected Map<String, Integer> b;
  public boolean b;
  public int c;
  protected long c;
  public boolean c;
  protected int d;
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
    this.jdField_b_of_type_Long = 2L;
    this.jdField_c_of_type_Long = -1L;
  }
  
  private ArrayList<String> a()
  {
    localArrayList = new ArrayList();
    try
    {
      int i = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstCompletelyVisibleItemPosition();
      int j = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findLastCompletelyVisibleItemPosition();
      if ((i >= 0) && (i < this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.getItemCount()) && (j >= 0) && (j < this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.getItemCount()) && (i <= j)) {
        while (i <= j)
        {
          if (this.jdField_a_of_type_Ansi.getItemViewType(i) == 0)
          {
            anpv localanpv = this.jdField_a_of_type_Ansi.a(i);
            if (localanpv != null) {
              localArrayList.add(localanpv.mUin);
            }
          }
          i += 1;
        }
      }
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("ExtendFriendBaseFragment", 1, "findCurrentVisibleItems error:" + localThrowable.getMessage());
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
      if (this.jdField_a_of_type_Azwg != null) {
        localBitmap = this.jdField_a_of_type_Azwg.a(1, paramString1);
      }
      if (localBitmap == null) {
        if (!this.jdField_c_of_type_Boolean)
        {
          if (paramImageView != null) {
            paramImageView.setTag(2131311024, paramString1);
          }
          if ((this.jdField_a_of_type_JavaUtilMap != null) && (this.jdField_a_of_type_Azwg != null))
          {
            this.jdField_a_of_type_Azwg.a(paramString1, 1, true);
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
          paramString1 = bacm.a();
        }
        return new BitmapDrawable(paramString1);
      }
      this.jdField_a_of_type_JavaUtilMap.remove(paramImageView);
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager != null) && (this.jdField_a_of_type_Ansi != null))
    {
      int i = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition();
      int j = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findLastVisibleItemPosition();
      while (i <= j)
      {
        Object localObject1 = this.jdField_a_of_type_Ansi.a(i);
        Object localObject2 = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForPosition(i);
        if ((localObject1 != null) && (localObject2 != null) && ((localObject2 instanceof anpb)))
        {
          localObject2 = (anpb)localObject2;
          localObject1 = a(((anpv)localObject1).mUin, ((anpv)localObject1).mNickName, ((anpb)localObject2).jdField_a_of_type_AndroidWidgetImageView);
          ((anpb)localObject2).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
        }
        i += 1;
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("onFeedVoiceClick position=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    if (this.jdField_a_of_type_Ansi != null)
    {
      anpv localanpv = this.jdField_a_of_type_Ansi.a(paramInt);
      if (localanpv != null)
      {
        int i = localanpv.mVoiceDuration / 10;
        awqx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", localanpv.mUin, "0X80092CF", "0X80092CF", i + 1, 0, "", "", anty.a(localanpv.mStrRecomTrace), "");
        awqx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", localanpv.mUin, "0X8009C70", "0X8009C70", 0, 0, "", "", anty.a(localanpv.mStrRecomTrace), "");
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
    anpv localanpv = this.jdField_a_of_type_Ansi.a(paramInt1);
    if (localanpv != null)
    {
      anty.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localanpv.mStrRecomTrace);
      awqx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", localanpv.mUin, "0X80092D0", "0X80092D0", 0, 0, "", "", anty.a(localanpv.mStrRecomTrace), "");
      awqx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", localanpv.mUin, "0X8009C6F", "0X8009C6F", paramInt2, 0, "", "", anty.a(localanpv.mStrRecomTrace), "");
      ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(localanpv.mUin, 96);
      ProfileActivity.b(getActivity(), localAllInOne, a());
      this.jdField_c_of_type_Int = paramInt1;
      this.jdField_d_of_type_Boolean = true;
      this.jdField_b_of_type_JavaLangString = localanpv.mUin;
      this.jdField_c_of_type_Long = System.currentTimeMillis();
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("playerCompletion path=%s", new Object[] { paramString }));
    }
    ThreadManager.getUIHandler().post(new ExtendFriendBaseFragment.3(this));
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
      if (this.jdField_a_of_type_Bbmy == null) {
        this.jdField_a_of_type_Bbmy = new bbmy(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      }
      if ((!this.jdField_a_of_type_Bbmy.c()) || (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramString)) || (this.jdField_d_of_type_Int != paramInt))
      {
        this.jdField_a_of_type_Bbmy.a(bbmy.a(paramInt));
        this.jdField_a_of_type_Bbmy.b(paramInt);
        this.jdField_a_of_type_Bbmy.a(paramString);
        this.jdField_a_of_type_Bbmy.d(0);
        this.jdField_a_of_type_Bbmy.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
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
      localCard = ((ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
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
  
  public boolean a()
  {
    if (anoe.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null)
      {
        if (this.jdField_b_of_type_AndroidAppDialog == null) {
          this.jdField_b_of_type_AndroidAppDialog = anue.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
        }
        if ((!this.jdField_b_of_type_AndroidAppDialog.isShowing()) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())) {
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
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("onFooterItemClick", new Object[0]));
    }
    a(true);
    this.jdField_a_of_type_Ansi.a(0, true);
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("onFeedLikeClick position=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    anpv localanpv = this.jdField_a_of_type_Ansi.a(paramInt);
    if (localanpv != null)
    {
      if (localanpv.mAvailLikeCount <= 0) {
        break label300;
      }
      if (badq.d(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))
      {
        localanpv.mLiked = true;
        localanpv.mAvailLikeCount -= 1;
        awqx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", localanpv.mUin, "0X80092CD", "0X80092CD", 0, 0, "", "", anty.a(localanpv.mStrRecomTrace), "");
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "P_prof", "Prof_good", 9, 1, 0, Integer.toString(53), "1", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localanpv.mUin);
      }
    }
    else
    {
      synchronized (jdField_b_of_type_JavaLangObject)
      {
        localObject3 = (Integer)this.jdField_b_of_type_JavaUtilMap.get(localanpv.mUin);
        Object localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = Integer.valueOf(0);
        }
        this.jdField_b_of_type_JavaUtilMap.put(localanpv.mUin, Integer.valueOf(((Integer)localObject1).intValue() + 1));
        if (!this.jdField_a_of_type_Befq.hasMessages(10))
        {
          localObject1 = Message.obtain();
          ((Message)localObject1).what = 10;
          this.jdField_a_of_type_Befq.sendMessageDelayed((Message)localObject1, 1000L);
        }
        this.jdField_a_of_type_Ansi.notifyItemChanged(paramInt);
        h(paramInt);
        return;
      }
    }
    a(getString(2131655024), 1);
    return;
    label300:
    Object localObject3 = ajjy.a(2131638471);
    String str;
    if ((localanpv.mGender == 1) || (localanpv.mGender == 2)) {
      if (localanpv.mGender == 2) {
        str = ajjy.a(2131638468);
      }
    }
    for (;;)
    {
      a(String.format((String)localObject3, new Object[] { str, Integer.valueOf(b()) }), 0);
      return;
      str = ajjy.a(2131638450);
      continue;
      str = ajjy.a(2131638475);
    }
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Ansi == null) || (this.jdField_a_of_type_Ansi.a() <= 0) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    this.jdField_a_of_type_Befq.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if (paramBoolean)
    {
      this.jdField_a_of_type_Befq.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
      return;
    }
    this.jdField_a_of_type_JavaLangRunnable.run();
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void c() {}
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("onFeedAddFriendClick position=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    if (a())
    {
      awqx.b(null, "dc00898", "", "", "kuolie", "0X80097DA", 1, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendBaseFragment", 2, "onFeedAddFriendClick, showExtendFriendQuestionDialog");
      }
    }
    anpv localanpv;
    do
    {
      return;
      if ((!this.jdField_a_of_type_Boolean) || (!this.jdField_b_of_type_Boolean))
      {
        k();
        return;
      }
      localanpv = this.jdField_a_of_type_Ansi.a(paramInt);
    } while ((localanpv == null) || (localanpv.mAddFriendVerified));
    anty.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localanpv.mStrRecomTrace);
    startActivityForResult(AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, localanpv.mUin, null, 3094, 2, localanpv.mNickName, null, null, null, null), 1);
    this.jdField_b_of_type_Int = paramInt;
    awqx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", localanpv.mUin, "0X80092CB", "0X80092CB", 0, 0, "", "", anty.a(localanpv.mStrRecomTrace), "");
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("onFocusChanged focused=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if (!paramBoolean) {
      ThreadManager.getUIHandler().post(new ExtendFriendBaseFragment.5(this));
    }
  }
  
  public void d() {}
  
  public void d(int paramInt)
  {
    anpv localanpv = this.jdField_a_of_type_Ansi.a(paramInt);
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (localanpv == null)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Begr == null)
      {
        this.jdField_a_of_type_Begr = begr.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
        this.jdField_a_of_type_Begr.b(2131624038);
        this.jdField_a_of_type_Begr.c(2131625035);
        this.jdField_a_of_type_Begr.a(new anpz(this, localanpv));
      }
    } while (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing());
    this.jdField_a_of_type_Begr.show();
  }
  
  protected void e()
  {
    synchronized (jdField_b_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Ajfi != null)
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
            this.jdField_a_of_type_Ajfi.a(l1, l2, null, 53, i, 0);
          }
        }
      }
    }
    this.jdField_b_of_type_JavaUtilMap.clear();
  }
  
  public void e(int paramInt)
  {
    if (this.jdField_a_of_type_Ansi != null)
    {
      this.jdField_a_of_type_Ansi.b(paramInt);
      this.jdField_a_of_type_Ansi.notifyDataSetChanged();
      QLog.i("ExtendFriendBaseFragment", 1, "@gdtadv onClickFeedBackHideAdv");
    }
  }
  
  protected void f()
  {
    if ((this.jdField_d_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.jdField_c_of_type_Long > 0L))
    {
      long l = System.currentTimeMillis() - this.jdField_c_of_type_Long;
      if ((l > 0L) && (l < 3600000L)) {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_b_of_type_JavaLangString, "0X8009C71", "0X8009C71", 0, 0, String.valueOf(l), "", "", "");
      }
      this.jdField_d_of_type_Boolean = false;
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_c_of_type_Long = -1L;
    }
  }
  
  public void f(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("onDownloadFailed errCode=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    ThreadManager.getUIHandler().post(new ExtendFriendBaseFragment.4(this));
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())) {}
    StringBuilder localStringBuilder;
    do
    {
      return;
      long l = System.currentTimeMillis();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[ ");
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((((Long)localEntry.getValue()).longValue() > 0L) && (!TextUtils.isEmpty((CharSequence)localEntry.getKey())) && (l - ((Long)localEntry.getValue()).longValue() >= this.jdField_b_of_type_Long))
        {
          localStringBuilder.append((String)localEntry.getKey()).append(" ");
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", (String)localEntry.getKey(), "0X8009C6E", "0X8009C6E", 1, 0, "", "", "", "");
          localEntry.setValue(Long.valueOf(-1L));
        }
      }
      localStringBuilder.append("]");
    } while (!QLog.isColorLevel());
    QLog.d("ExtendFriendBaseFragment", 2, "endExposureReport  exposure uins:" + localStringBuilder.toString());
  }
  
  protected void g(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("toggleVoice position=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForPosition(paramInt);
    if ((localObject != null) && ((localObject instanceof anpb)))
    {
      localObject = (anpb)localObject;
      if (((anpb)localObject).jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.b())
      {
        ((anpb)localObject).jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.d();
        if (this.jdField_a_of_type_Anua != null) {
          this.jdField_a_of_type_Anua.a();
        }
        this.jdField_a_of_type_Int = -1;
      }
    }
    else
    {
      return;
    }
    ((anpb)localObject).jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.c();
    if (this.jdField_a_of_type_Ansi != null)
    {
      localObject = this.jdField_a_of_type_Ansi.a(paramInt);
      if ((localObject != null) && (!TextUtils.isEmpty(((anpv)localObject).mVoiceUrl)) && (this.jdField_a_of_type_Anua != null)) {
        this.jdField_a_of_type_Anua.a(((anpv)localObject).mVoiceUrl);
      }
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void h()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
  }
  
  public void h(int paramInt)
  {
    anpb localanpb = (anpb)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForPosition(paramInt);
    if (localanpb == null) {
      return;
    }
    int[] arrayOfInt = new int[2];
    localanpb.c.getLocationInWindow(arrayOfInt);
    NearbyZanAnimLayout localNearbyZanAnimLayout = this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout;
    Bitmap localBitmap = this.jdField_a_of_type_Aqen.a(3, this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.a).a();
    float f1 = arrayOfInt[0] + localanpb.c.getPaddingLeft() + this.f;
    paramInt = arrayOfInt[1];
    int i = this.e;
    localNearbyZanAnimLayout.a(localBitmap, f1, localanpb.c.getPaddingTop() + (paramInt - i) + this.g);
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
      if (this.jdField_a_of_type_Anua != null) {
        this.jdField_a_of_type_Anua.a();
      }
      Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForPosition(this.jdField_a_of_type_Int);
      if ((localObject != null) && ((localObject instanceof anpb)))
      {
        localObject = (anpb)localObject;
        if (((anpb)localObject).jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.b()) {
          ((anpb)localObject).jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.d();
        }
      }
      this.jdField_a_of_type_Int = -1;
    }
  }
  
  protected void k()
  {
    FragmentActivity localFragmentActivity = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    if (!this.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 2)
    {
      this.jdField_a_of_type_AndroidAppDialog = anue.a(localFragmentActivity, i, new anqa(this));
      try
      {
        if (this.jdField_a_of_type_AndroidAppDialog != null)
        {
          this.jdField_a_of_type_AndroidAppDialog.show();
          if (!this.jdField_a_of_type_Boolean)
          {
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092EA", "0X80092EA", 0, 0, "", "", "", "");
            return;
          }
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092E7", "0X80092E7", 0, 0, "", "", "", "");
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("ExtendFriendBaseFragment", 1, "showProfileGuide fail.");
      }
      return;
    }
  }
  
  public void l()
  {
    this.h = ((anod)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(127)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), true);
  }
  
  protected void m()
  {
    if (this.jdField_c_of_type_Int >= 0)
    {
      anpv localanpv = this.jdField_a_of_type_Ansi.a(this.jdField_c_of_type_Int);
      if (localanpv != null)
      {
        Card localCard = ((ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(localanpv.mUin);
        if (localCard != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendBaseFragment", 2, String.format("syncLikeStatus bVoted=%s bAvailVoteCnt=%s mAvailLikeCount=%s", new Object[] { Byte.valueOf(localCard.bVoted), Short.valueOf(localCard.bAvailVoteCnt), Integer.valueOf(localanpv.mAvailLikeCount) }));
          }
          if ((localCard.bVoted > 0) && (localCard.bAvailVoteCnt < localanpv.mAvailLikeCount))
          {
            localanpv.mLiked = true;
            localanpv.mAvailLikeCount = localCard.bAvailVoteCnt;
            this.jdField_a_of_type_Ansi.notifyItemChanged(this.jdField_c_of_type_Int);
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
    this.jdField_a_of_type_Anod = ((anod)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(127));
    this.jdField_a_of_type_Ajfi = ((ajfi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2));
    this.jdField_a_of_type_Anoe = ((anoe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(264));
    this.jdField_a_of_type_Azwg = new azwg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Azwg.a(this);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_Aqen = new aqen(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.f = aciy.a(17.5F, getResources());
    this.g = aciy.a(7.0F, getResources());
    this.jdField_a_of_type_Anua = new anua(this, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_Befq = new befq(ThreadManager.getSubThreadLooper(), this);
    paramBundle = this.jdField_a_of_type_Anoe.a();
    if (paramBundle != null) {
      this.jdField_b_of_type_Long = paramBundle.j;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anoj);
    if (this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver == null) {
      this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = new GdtAppReceiver();
    }
    this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver.register(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    bgqd.a().a();
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
          localObject1 = localImageView.getTag(2131311024);
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
    if (this.jdField_a_of_type_Azwg != null)
    {
      this.jdField_a_of_type_Azwg.a(null);
      this.jdField_a_of_type_Azwg.d();
      this.jdField_a_of_type_Azwg = null;
    }
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      this.jdField_a_of_type_JavaUtilMap.clear();
      this.jdField_a_of_type_JavaUtilMap = null;
    }
    this.jdField_a_of_type_Befq.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anoj);
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
    anty.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "");
    f();
    b(true);
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_Befq.hasMessages(10))
    {
      this.jdField_a_of_type_Befq.removeMessages(10);
      e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendBaseFragment
 * JD-Core Version:    0.7.0.1
 */