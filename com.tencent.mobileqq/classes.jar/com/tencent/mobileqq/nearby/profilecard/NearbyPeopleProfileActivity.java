package com.tencent.mobileqq.nearby.profilecard;

import ajfw;
import ajga;
import ajjh;
import ajjj;
import ajjy;
import ajkn;
import alkc;
import alke;
import alkl;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import apnm;
import aqrr;
import ascv;
import ascz;
import ased;
import asep;
import asfc;
import asft;
import asfx;
import assl;
import assm;
import assn;
import asso;
import assp;
import assr;
import asss;
import asst;
import assu;
import assv;
import assw;
import assx;
import assy;
import assz;
import asta;
import astb;
import astd;
import aste;
import asuq;
import asvv;
import asvw;
import asxa;
import atbs;
import atby;
import atcg;
import avev;
import awqx;
import awsf;
import awsg;
import axsm;
import axvo;
import azzz;
import baaf;
import babr;
import bbms;
import bbmy;
import beex;
import befb;
import begr;
import bfpr;
import bfpy;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.picbrowser.NearbyProfilePicBrowserActivity;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
import vms;

public class NearbyPeopleProfileActivity
  extends FragmentActivity
{
  public static int a;
  public static HashMap<String, Integer> a;
  public static int b;
  public static int c;
  public static int m;
  public float a;
  public long a;
  public ajfw a;
  public ajga a;
  protected ajjh a;
  ajkn jdField_a_of_type_Ajkn = new asso(this);
  private alkc jdField_a_of_type_Alkc;
  protected alke a;
  private alkl jdField_a_of_type_Alkl;
  public Dialog a;
  public Intent a;
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  apnm jdField_a_of_type_Apnm = new assw(this);
  public asft a;
  public asfx a;
  private astd jdField_a_of_type_Astd;
  private asvv jdField_a_of_type_Asvv;
  public avev a;
  bbms jdField_a_of_type_Bbms;
  public URLDrawable a;
  public ProfileActivity.AllInOne a;
  public TopGestureLayout a;
  private NearbyPeopleCard jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
  PicInfo jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo;
  private NearbyPeopleProfileActivity.DownloadHDAvatarRunnable jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity$DownloadHDAvatarRunnable;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  public String a;
  public ArrayList<PicInfo> a;
  public boolean a;
  private long jdField_b_of_type_Long;
  protected ajga b;
  public Dialog b;
  private View jdField_b_of_type_AndroidViewView;
  public String b;
  ArrayList<PicInfo> jdField_b_of_type_JavaUtilArrayList = new ArrayList(13);
  public boolean b;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public boolean d;
  public int e;
  boolean e;
  public int f;
  public boolean f;
  public int g;
  public boolean g;
  public int h;
  public boolean h;
  public int i;
  public boolean i;
  public int j;
  public boolean j;
  public int k;
  boolean k;
  public int l;
  public boolean l;
  public boolean m;
  public int n;
  public boolean n;
  public int o;
  public volatile boolean o;
  private int p;
  public boolean p;
  private int q;
  public boolean q;
  private int r;
  public boolean r;
  boolean s = false;
  public boolean t = false;
  boolean u = false;
  private boolean v;
  private boolean w;
  private boolean x;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_Int = 18;
    jdField_b_of_type_Int = 12;
    jdField_c_of_type_Int = jdField_b_of_type_Int;
  }
  
  public NearbyPeopleProfileActivity()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_i_of_type_Int = 0;
    this.jdField_h_of_type_Boolean = true;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_k_of_type_Boolean = true;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_j_of_type_Int = 0;
    this.jdField_k_of_type_Int = 0;
    this.jdField_l_of_type_Int = -1;
    this.jdField_n_of_type_Int = 18;
    this.jdField_q_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new assx(this);
    this.jdField_a_of_type_AndroidAppDialog = null;
    this.jdField_b_of_type_AndroidAppDialog = null;
    this.jdField_a_of_type_Ajjh = new assn(this);
    this.jdField_a_of_type_Asfx = new assp(this);
    this.jdField_a_of_type_Alke = new asss(this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(13);
    this.jdField_a_of_type_Ajga = new asst(this);
    this.jdField_b_of_type_Ajga = new assu(this);
  }
  
  public static void a(Context paramContext, ProfileActivity.AllInOne paramAllInOne, Bundle paramBundle)
  {
    a(paramContext, paramAllInOne, paramBundle, 6);
  }
  
  public static void a(Context paramContext, ProfileActivity.AllInOne paramAllInOne, Bundle paramBundle, int paramInt)
  {
    if (paramContext != null) {}
    try
    {
      Intent localIntent = new Intent(paramContext, NearbyPeopleProfileActivity.class);
      localIntent.putExtra("AllInOne", paramAllInOne);
      localIntent.putExtras(paramBundle);
      localIntent.putExtra("frome_where", paramInt);
      localIntent.addFlags(536870912);
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.FrdProfileCard", 2, paramContext.toString());
    }
  }
  
  public static boolean a(int paramInt)
  {
    if (paramInt == 22) {}
    while ((paramInt >= 7) && (paramInt <= 12) && (paramInt != 11)) {
      return true;
    }
    return false;
  }
  
  protected int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 11;
    case 10: 
      return 1;
    case 5: 
      return 3;
    case 32: 
    case 34: 
    case 35: 
      return 4;
    case 20: 
    case 31: 
    case 33: 
      return 5;
    case 21: 
      return 6;
    case 99: 
      return 13;
    }
    return 14;
  }
  
  public astd a(int paramInt)
  {
    if (a(paramInt)) {
      return new asuq(this);
    }
    return new aste(this);
  }
  
  public asvv a(int paramInt)
  {
    if (a(paramInt)) {
      return new asxa(this);
    }
    return new asvw(this);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Bbms != null) && (this.jdField_a_of_type_Bbms.isShowing()) && (!isFinishing())) {
      this.jdField_a_of_type_Bbms.dismiss();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidAppDialog = babr.a(this, 0, getString(paramInt), 2131633392, 2131633391, new assy(this), new assz(this));
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (!isFinishing())) {
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  public void a(int paramInt, Rect paramRect)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        if ("showBigPhoto, currentPosition = " + paramInt + ", rect = " + paramRect + ", mPicInfo.size = " + this.jdField_a_of_type_JavaUtilArrayList != null) {
          break label89;
        }
      }
      label89:
      for (paramRect = "null";; paramRect = Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()))
      {
        QLog.e("Q.nearby_people_card.", 2, new Object[] { paramRect });
        return;
      }
    }
    Intent localIntent = new Intent(this, NearbyProfilePicBrowserActivity.class);
    localIntent.putExtra("intent_param_index", paramInt);
    localIntent.putExtra("intent_param_pic_infos", this.jdField_a_of_type_JavaUtilArrayList);
    localIntent.putExtra("report_visited_pic", true);
    localIntent.putExtra("KEY_THUMBNAL_BOUND", paramRect);
    localIntent.addFlags(536870912);
    startActivity(localIntent);
  }
  
  public void a(int paramInt, Rect paramRect, ArrayList<PicInfo> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        if ("showBigPhotoWithDelAndSetHeadView, currentPosition = " + paramInt + ", rect = " + paramRect + ", picInfos.size = " + paramArrayList != null) {
          break label80;
        }
      }
      label80:
      for (paramRect = "null";; paramRect = Integer.valueOf(paramArrayList.size()))
      {
        QLog.e("Q.nearby_people_card.", 2, new Object[] { paramRect });
        return;
      }
    }
    Intent localIntent = new Intent(this, NearbyProfilePicBrowserActivity.class);
    localIntent.putExtra("intent_param_index", paramInt);
    localIntent.putExtra("intent_param_pic_infos", paramArrayList);
    localIntent.putExtra("report_visited_pic", true);
    localIntent.putExtra("intent_param_show_del_pic_and_set_head", true);
    localIntent.putExtra("KEY_THUMBNAL_BOUND", paramRect);
    localIntent.addFlags(536870912);
    startActivityForResult(localIntent, 14);
  }
  
  public void a(int paramInt, String paramString)
  {
    bbmy.a(BaseApplication.getContext(), paramInt, paramString, 0).b(this.jdField_p_of_type_Int);
  }
  
  public void a(long paramLong)
  {
    a(paramLong, -1, -1);
  }
  
  void a(long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_e_of_type_Int = 1;
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator());
    localAlphaAnimation.setDuration(paramLong);
    localAlphaAnimation.setAnimationListener(new assl(this));
    if (this.jdField_a_of_type_AndroidViewView != null) {}
    try
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_AndroidViewView);
      label65:
      if (this.jdField_a_of_type_Asvv != null) {
        this.jdField_a_of_type_Asvv.a();
      }
      this.jdField_a_of_type_AndroidViewView = null;
      this.jdField_a_of_type_Asvv = null;
      this.jdField_a_of_type_Asvv = a(this.jdField_j_of_type_Int);
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_Asvv.a();
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidViewView, new FrameLayout.LayoutParams(-1, -1));
      BounceScrollView localBounceScrollView = (BounceScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299933);
      localBounceScrollView.post(new NearbyPeopleProfileActivity.11(this, localBounceScrollView, this.jdField_b_of_type_AndroidViewView.findViewById(2131297855).getScrollY()));
      this.jdField_a_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
      f();
      return;
    }
    catch (Exception localException)
    {
      break label65;
    }
  }
  
  public void a(ImageView paramImageView, Drawable paramDrawable)
  {
    if (isFinishing())
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.nearby_people_card.", 2, "showVoteUpdateDialog invoke, but activity is finishing");
      }
      return;
    }
    paramImageView.setImageDrawable(paramDrawable);
    paramDrawable = (ased)this.app.getManager(207);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, vms.a(this, 150.0F));
    new atby(this).a(paramImageView, localLayoutParams).a(ajjy.a(2131641451)).b(paramDrawable.a()).a(new atbs(ajjy.a(2131641446), new assr(this))).show();
    this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    paramDrawable.a();
  }
  
  public void a(NearbyPeopleCard paramNearbyPeopleCard, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean2) && (this.jdField_e_of_type_Int != 1))
    {
      this.jdField_a_of_type_Astd.b(paramNearbyPeopleCard);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard = paramNearbyPeopleCard;
    this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin;
    this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname;
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.vTempChatSig != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_b_of_type_ArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.vTempChatSig;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_b_of_type_JavaLangString != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.aioDistanceAndTime = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_b_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag) {
      jdField_c_of_type_Int = jdField_a_of_type_Int;
    }
    for (;;)
    {
      label174:
      label237:
      int i1;
      label282:
      label301:
      long l2;
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 0) {
          awqx.b(this.app, "CliOper", "", "", "0X8005286", "0X8005286", 0, 0, "", "", "", "");
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.picList == null) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.picList.isEmpty())) {
          break label430;
        }
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.picList);
        this.jdField_h_of_type_Boolean = true;
        if (this.jdField_e_of_type_Int == 3)
        {
          if (!azzz.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin)) {
            break label462;
          }
          this.jdField_a_of_type_AndroidContentIntent.putExtra("param_mode", 2);
          this.jdField_e_of_type_Int = 2;
        }
        if (this.jdField_e_of_type_Int != 1) {
          break label510;
        }
        this.jdField_a_of_type_Asvv.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
        if ((this.s) || (this.jdField_e_of_type_Int == 1) || (this.jdField_g_of_type_Boolean)) {
          break;
        }
        this.s = true;
        if (!a(this.jdField_j_of_type_Int)) {
          break label524;
        }
        i1 = 510;
        l2 = 0L;
      }
      try
      {
        l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
        this.jdField_a_of_type_Asft.a(l1, 0L, i1);
        return;
        jdField_c_of_type_Int = jdField_b_of_type_Int;
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 1) {
          break label174;
        }
        awqx.b(this.app, "CliOper", "", "", "0X8005287", "0X8005287", 0, 0, "", "", "", "");
        break label174;
        label430:
        if (1 == this.jdField_e_of_type_Int) {
          break label237;
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.nearby_people_card.", 2, "onNearbyCardDownload need to getQzoneCover.");
        }
        this.jdField_h_of_type_Boolean = false;
        break label237;
        label462:
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin)) {
          break label282;
        }
        paramNearbyPeopleCard = (ajjj)this.app.getManager(51);
        if (paramNearbyPeopleCard == null) {
          break label282;
        }
        this.jdField_g_of_type_Boolean = paramNearbyPeopleCard.b(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
        break label282;
        label510:
        this.jdField_a_of_type_Astd.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
        break label301;
        label524:
        i1 = 509;
      }
      catch (Exception paramNearbyPeopleCard)
      {
        for (;;)
        {
          long l1 = l2;
          if (QLog.isColorLevel())
          {
            QLog.e("NearbyLikeLimitManager", 2, "req NearbyLikeLimitInfo: mCard.uin=" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
            l1 = l2;
          }
        }
      }
    }
  }
  
  public void a(PicInfo paramPicInfo, Rect paramRect)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramPicInfo);
    paramPicInfo = new Intent(this, NearbyProfilePicBrowserActivity.class);
    paramPicInfo.putExtra("intent_param_index", 0);
    paramPicInfo.putExtra("intent_param_pic_infos", localArrayList);
    paramPicInfo.putExtra("KEY_THUMBNAL_BOUND", paramRect);
    paramPicInfo.addFlags(536870912);
    startActivity(paramPicInfo);
  }
  
  public void a(String paramString)
  {
    if (isFinishing()) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Bbms == null) {
        this.jdField_a_of_type_Bbms = new bbms(this, getTitleBarHeight());
      }
      this.jdField_a_of_type_Bbms.a(paramString);
    } while (isFinishing());
    this.jdField_a_of_type_Bbms.show();
  }
  
  public void a(String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    if (this.u)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.nearby_people_card.", 2, "downloadHDAvatar is updated HDAvatar true");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity$DownloadHDAvatarRunnable = new NearbyPeopleProfileActivity.DownloadHDAvatarRunnable(this, paramString1, paramInt, paramString2, paramBoolean);
    ThreadManager.post(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity$DownloadHDAvatarRunnable, 5, null, true);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      View localView = getWindow().getDecorView();
      if ((localView != null) && ((localView instanceof ViewGroup)))
      {
        localView = ((ViewGroup)localView).getChildAt(0);
        if ((localView != null) && ((localView instanceof TopGestureLayout))) {
          this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localView);
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean1, NearbyPeopleCard paramNearbyPeopleCard, boolean paramBoolean2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.nearby_people_card.", 2, "editNearbyProfileCardResult() called with: isSuccess = [" + paramBoolean1 + "], card = [" + paramNearbyPeopleCard + "], isHeadChanged = [" + paramBoolean2 + "], errorTips = [" + paramString + "]");
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.update_profile", 2, "editNearbyProfileCardResult|[" + paramBoolean1 + "," + paramNearbyPeopleCard + "]");
    }
    a();
    if ((paramBoolean1) && (paramNearbyPeopleCard != null))
    {
      this.jdField_c_of_type_Boolean = false;
      a(2, ajjy.a(2131641450));
      if (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college, paramNearbyPeopleCard.college))
      {
        asfc.a(this.app.getCurrentAccountUin(), "school_name", paramNearbyPeopleCard.college);
        asfc.a(this.app.getCurrentAccountUin(), "school_valid_state", Integer.valueOf(this.o));
      }
      this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard = paramNearbyPeopleCard;
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag = false;
        this.jdField_d_of_type_Boolean = false;
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.picList != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.picList.isEmpty()))
      {
        this.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.picList);
        this.jdField_h_of_type_Boolean = true;
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo;
      if (paramBoolean2) {
        ascz.a(this.app);
      }
      if (this.jdField_i_of_type_Int != 1) {
        e();
      }
      if ((this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) && (!this.jdField_b_of_type_JavaUtilArrayList.isEmpty()))
      {
        this.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_b_of_type_JavaUtilArrayList);
        this.jdField_b_of_type_JavaUtilArrayList.clear();
      }
      if (this.jdField_a_of_type_Astd != null) {
        this.jdField_a_of_type_Astd.j();
      }
      this.jdField_a_of_type_AndroidContentIntent.putExtra("param_mode", 2);
      d();
      ThreadManager.post(new NearbyPeopleProfileActivity.23(this), 5, null, true);
      paramNearbyPeopleCard = new Intent();
      paramNearbyPeopleCard.putExtra("param_xuan_yan", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan);
      paramNearbyPeopleCard.putExtra("param_nickname", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname);
      paramNearbyPeopleCard.putExtra("param_gender", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender);
      paramNearbyPeopleCard.putExtra("param_age", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age);
      paramNearbyPeopleCard.putExtra("param_career", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job);
      paramNearbyPeopleCard.putExtra("param_constellation", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.constellation);
      paramNearbyPeopleCard.putExtra("param_marital_status", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus);
      paramNearbyPeopleCard.putExtra("param_god_flag", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag);
      int i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
      paramNearbyPeopleCard.putExtra("param_photo_count", i1);
      int i2 = ((Integer)asfc.a(this.app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
      awqx.b(this.app, "dc00899", "grp_lbs", "", "data_card", "upload_suc", 0, 0, i1 + "", i2 + "", "", "");
      setResult(-1, paramNearbyPeopleCard);
      if (this.jdField_a_of_type_Boolean)
      {
        b(true);
        finish();
      }
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      a(1, ajjy.a(2131641447));
    }
    for (;;)
    {
      this.jdField_d_of_type_Boolean = false;
      return;
      a(1, paramString);
    }
  }
  
  public boolean a(PicInfo paramPicInfo1, PicInfo paramPicInfo2)
  {
    if ((paramPicInfo1 == null) || (paramPicInfo2 == null)) {}
    while (paramPicInfo1.jdField_a_of_type_Int != paramPicInfo2.jdField_a_of_type_Int) {
      return false;
    }
    return true;
  }
  
  public void b()
  {
    this.jdField_b_of_type_AndroidAppDialog = babr.a(this, 2131633399, getString(2131633398), 2131625035, 2131633397, new asta(this), new astb(this));
    if ((this.jdField_b_of_type_AndroidAppDialog != null) && (!isFinishing())) {
      this.jdField_b_of_type_AndroidAppDialog.show();
    }
  }
  
  public void b(String paramString)
  {
    bbmy.a(BaseApplication.getContext(), paramString, 0).b(this.jdField_p_of_type_Int);
  }
  
  public void b(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("isSuccess", paramBoolean);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add("*.qq.com");
        aqrr.a("nearbyUserSummaryInfoChange", localJSONObject, localArrayList, null);
        return;
      }
      catch (JSONException localJSONException) {}
    } while (!QLog.isColorLevel());
    QLog.e("Q.nearby_people_card.", 2, localJSONException.toString());
  }
  
  public void c()
  {
    beex.a(this);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_b_of_type_JavaUtilArrayList);
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    if (this.jdField_a_of_type_Astd != null) {
      this.jdField_a_of_type_Astd.j();
    }
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_e_of_type_Boolean = false;
      this.jdField_a_of_type_Asft.a(new ArrayList());
    }
    int i1 = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_mode", 0);
    if (i1 == 1)
    {
      awqx.b(this.app, "CliOper", "", "", "0X8004A1B", "0X8004A1B", 0, 0, "", "", "", "");
      if (this.jdField_n_of_type_Boolean)
      {
        if (this.m)
        {
          Intent localIntent = new Intent(this, NearbyActivity.class);
          localIntent.putExtra("abp_flag", this.m);
          localIntent.setFlags(67108864);
          startActivity(localIntent);
        }
        finish();
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_Boolean = false;
      b(false);
      return;
      c(false);
      continue;
      if ((i1 == 2) && (this.jdField_e_of_type_Int == 1)) {
        d();
      }
    }
  }
  
  public void c(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.app != null)) {
      ThreadManager.post(new NearbyPeopleProfileActivity.21(this, paramString), 5, null, true);
    }
  }
  
  protected void c(boolean paramBoolean)
  {
    if (paramBoolean) {
      e();
    }
    awqx.b(this.app, "CliOper", "", "", "0X8004A1C", "0X8004A1C", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_no_miss", false)) {
      awqx.b(this.app, "CliOper", "", "", "0X8004A1D", "0X8004A1D", 0, 0, "", "", "", "");
    }
  }
  
  protected void d()
  {
    if (this.jdField_e_of_type_Int == 2)
    {
      if (this.jdField_a_of_type_Astd != null) {
        this.jdField_a_of_type_Astd.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
      }
      return;
    }
    this.jdField_e_of_type_Int = 2;
    if (this.jdField_a_of_type_Asvv != null) {
      this.jdField_a_of_type_Asvv.jdField_a_of_type_Boolean = false;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(300L);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator());
    localAlphaAnimation.setAnimationListener(new assm(this));
    this.jdField_a_of_type_AndroidViewView.clearAnimation();
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 14)
    {
      this.jdField_a_of_type_Asvv.a(paramInt1, paramInt2, paramIntent);
      return;
    }
    if (this.jdField_e_of_type_Int == 1)
    {
      this.jdField_a_of_type_Asvv.a(paramInt1, paramInt2, paramIntent);
      return;
    }
    this.jdField_a_of_type_Astd.a(paramInt1, paramInt2, paramIntent);
  }
  
  /* Error */
  public boolean doOnCreate(Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 950	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:getIntent	()Landroid/content/Intent;
    //   4: ldc_w 952
    //   7: iconst_0
    //   8: invokevirtual 226	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   11: pop
    //   12: aload_0
    //   13: invokevirtual 950	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:getIntent	()Landroid/content/Intent;
    //   16: ldc_w 954
    //   19: invokevirtual 958	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   22: invokestatic 654	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   25: ifeq +17 -> 42
    //   28: aload_0
    //   29: invokevirtual 950	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:getIntent	()Landroid/content/Intent;
    //   32: ldc_w 954
    //   35: ldc_w 960
    //   38: invokevirtual 790	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   41: pop
    //   42: getstatic 965	befb:b	Lbefb;
    //   45: astore_3
    //   46: aload_3
    //   47: ifnull +20 -> 67
    //   50: aload_3
    //   51: invokevirtual 967	befb:a	()Z
    //   54: ifeq +13 -> 67
    //   57: aload_3
    //   58: iconst_0
    //   59: invokevirtual 969	befb:b	(I)V
    //   62: aload_3
    //   63: iconst_1
    //   64: invokevirtual 971	befb:a	(I)V
    //   67: aload_0
    //   68: iconst_0
    //   69: putfield 974	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:mActNeedImmersive	Z
    //   72: aload_0
    //   73: iconst_1
    //   74: putfield 977	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:mNeedStatusTrans	Z
    //   77: aload_1
    //   78: ifnull +11 -> 89
    //   81: aload_1
    //   82: ldc_w 979
    //   85: aconst_null
    //   86: invokevirtual 985	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   89: aload_0
    //   90: aload_1
    //   91: invokespecial 987	android/support/v4/app/FragmentActivity:doOnCreate	(Landroid/os/Bundle;)Z
    //   94: pop
    //   95: aload_0
    //   96: getfield 492	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   99: aload_0
    //   100: getfield 142	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Asfx	Lasfx;
    //   103: invokevirtual 991	com/tencent/mobileqq/app/QQAppInterface:addObserver	(Lajfe;)V
    //   106: aload_0
    //   107: aload_0
    //   108: invokevirtual 950	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:getIntent	()Landroid/content/Intent;
    //   111: putfield 628	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   114: aload_0
    //   115: getfield 492	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   118: invokevirtual 994	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   121: ifeq +10 -> 131
    //   124: aload_0
    //   125: getfield 628	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   128: ifnonnull +9 -> 137
    //   131: aload_0
    //   132: invokevirtual 846	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:finish	()V
    //   135: iconst_0
    //   136: ireturn
    //   137: aload_0
    //   138: ldc_w 995
    //   141: invokespecial 998	android/support/v4/app/FragmentActivity:setContentView	(I)V
    //   144: aload_0
    //   145: invokevirtual 704	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:getWindow	()Landroid/view/Window;
    //   148: aconst_null
    //   149: invokevirtual 1001	android/view/Window:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   152: aload_0
    //   153: aload_0
    //   154: invokevirtual 1005	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:getResources	()Landroid/content/res/Resources;
    //   157: invokevirtual 1011	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   160: getfield 1016	android/util/DisplayMetrics:density	F
    //   163: putfield 1018	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Float	F
    //   166: aload_0
    //   167: aload_0
    //   168: invokevirtual 676	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:getTitleBarHeight	()I
    //   171: putfield 396	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_p_of_type_Int	I
    //   174: aload_0
    //   175: aload_0
    //   176: invokevirtual 1005	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:getResources	()Landroid/content/res/Resources;
    //   179: invokevirtual 1011	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   182: getfield 1021	android/util/DisplayMetrics:widthPixels	I
    //   185: iconst_3
    //   186: idiv
    //   187: putfield 1023	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_f_of_type_Int	I
    //   190: aload_0
    //   191: aload_0
    //   192: invokevirtual 1005	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:getResources	()Landroid/content/res/Resources;
    //   195: invokevirtual 1011	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   198: getfield 1021	android/util/DisplayMetrics:widthPixels	I
    //   201: putfield 1025	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_g_of_type_Int	I
    //   204: aload_0
    //   205: aload_0
    //   206: getfield 492	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   209: bipush 60
    //   211: invokevirtual 1028	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajfb;
    //   214: checkcast 642	asft
    //   217: putfield 640	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Asft	Lasft;
    //   220: aload_0
    //   221: aload_0
    //   222: getfield 492	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   225: bipush 15
    //   227: invokevirtual 498	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   230: checkcast 1030	avev
    //   233: putfield 1032	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Avev	Lavev;
    //   236: aload_0
    //   237: aload_0
    //   238: getfield 492	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   241: bipush 59
    //   243: invokevirtual 498	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   246: checkcast 1034	ajfw
    //   249: putfield 1036	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Ajfw	Lajfw;
    //   252: aload_0
    //   253: getfield 1036	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Ajfw	Lajfw;
    //   256: aload_0
    //   257: invokevirtual 1039	ajfw:a	(Ljava/lang/Object;)V
    //   260: aload_0
    //   261: getfield 1036	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Ajfw	Lajfw;
    //   264: aload_0
    //   265: getfield 166	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_b_of_type_Ajga	Lajga;
    //   268: invokevirtual 1041	ajfw:c	(Ljava/lang/Object;)V
    //   271: aload_0
    //   272: aload_0
    //   273: getfield 492	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   276: sipush 180
    //   279: invokevirtual 498	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   282: checkcast 1043	alkl
    //   285: putfield 1045	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Alkl	Lalkl;
    //   288: aload_0
    //   289: aload_0
    //   290: getfield 1045	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Alkl	Lalkl;
    //   293: invokevirtual 1048	alkl:a	()Lalkc;
    //   296: putfield 182	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Alkc	Lalkc;
    //   299: aload_0
    //   300: aload_0
    //   301: getfield 1045	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Alkl	Lalkl;
    //   304: iconst_4
    //   305: invokevirtual 1049	alkl:a	(I)Z
    //   308: putfield 1051	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_p_of_type_Boolean	Z
    //   311: aload_0
    //   312: getfield 1045	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Alkl	Lalkl;
    //   315: invokevirtual 1054	alkl:a	()Lalkb;
    //   318: ifnull +39 -> 357
    //   321: aload_0
    //   322: aload_0
    //   323: getfield 1045	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Alkl	Lalkl;
    //   326: invokevirtual 1054	alkl:a	()Lalkb;
    //   329: getfield 1058	alkb:jdField_d_of_type_Int	I
    //   332: putfield 110	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_n_of_type_Int	I
    //   335: aload_0
    //   336: getfield 110	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_n_of_type_Int	I
    //   339: iflt +12 -> 351
    //   342: aload_0
    //   343: getfield 110	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_n_of_type_Int	I
    //   346: bipush 30
    //   348: if_icmple +9 -> 357
    //   351: aload_0
    //   352: bipush 18
    //   354: putfield 110	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_n_of_type_Int	I
    //   357: aload_0
    //   358: aload_0
    //   359: getfield 628	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   362: ldc 213
    //   364: invokevirtual 1062	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   367: checkcast 561	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   370: putfield 554	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   373: aload_0
    //   374: getfield 554	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   377: ifnonnull +72 -> 449
    //   380: invokestatic 246	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   383: ifeq +13 -> 396
    //   386: ldc_w 341
    //   389: iconst_2
    //   390: ldc_w 1064
    //   393: invokestatic 739	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   396: aload_0
    //   397: invokevirtual 846	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:finish	()V
    //   400: iconst_1
    //   401: ireturn
    //   402: astore_1
    //   403: aload_0
    //   404: invokevirtual 846	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:finish	()V
    //   407: iconst_0
    //   408: ireturn
    //   409: astore_1
    //   410: invokestatic 246	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   413: ifeq -40 -> 373
    //   416: ldc_w 341
    //   419: iconst_2
    //   420: new 319	java/lang/StringBuilder
    //   423: dup
    //   424: invokespecial 320	java/lang/StringBuilder:<init>	()V
    //   427: ldc_w 1066
    //   430: invokevirtual 326	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: aload_1
    //   434: invokevirtual 1069	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   437: invokevirtual 326	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: invokevirtual 337	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   443: invokestatic 739	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   446: goto -73 -> 373
    //   449: aload_0
    //   450: aload_0
    //   451: getfield 628	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   454: ldc 223
    //   456: iconst_0
    //   457: invokevirtual 897	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   460: putfield 104	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_j_of_type_Int	I
    //   463: aload_0
    //   464: getfield 104	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_j_of_type_Int	I
    //   467: bipush 35
    //   469: if_icmpne +9 -> 478
    //   472: aload_0
    //   473: iconst_0
    //   474: iconst_1
    //   475: invokestatic 1074	baaf:a	(Landroid/app/Activity;ZZ)V
    //   478: aload_0
    //   479: getfield 104	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_j_of_type_Int	I
    //   482: invokestatic 264	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:a	(I)Z
    //   485: ifeq +368 -> 853
    //   488: aload_0
    //   489: bipush 51
    //   491: putfield 1075	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_d_of_type_Int	I
    //   494: aload_0
    //   495: getfield 628	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   498: ldc_w 630
    //   501: iconst_0
    //   502: invokevirtual 897	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   505: istore_2
    //   506: iload_2
    //   507: iconst_2
    //   508: if_icmpeq +8 -> 516
    //   511: iload_2
    //   512: iconst_1
    //   513: if_icmpne +30 -> 543
    //   516: aload_0
    //   517: getfield 554	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   520: getfield 563	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   523: invokestatic 654	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   526: ifeq +17 -> 543
    //   529: aload_0
    //   530: getfield 554	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   533: aload_0
    //   534: getfield 492	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   537: invokevirtual 1078	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   540: putfield 563	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   543: aload_0
    //   544: aload_0
    //   545: getfield 628	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   548: ldc_w 630
    //   551: iconst_0
    //   552: invokevirtual 897	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   555: putfield 405	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_e_of_type_Int	I
    //   558: aload_0
    //   559: aload_0
    //   560: getfield 628	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   563: ldc_w 1080
    //   566: iconst_0
    //   567: invokevirtual 926	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   570: putfield 98	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_j_of_type_Boolean	Z
    //   573: aload_0
    //   574: aload_0
    //   575: getfield 628	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   578: ldc_w 1082
    //   581: lconst_0
    //   582: invokevirtual 1086	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   585: putfield 1088	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Long	J
    //   588: aload_0
    //   589: aload_0
    //   590: getfield 628	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   593: ldc_w 1090
    //   596: lconst_0
    //   597: invokevirtual 1086	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   600: putfield 179	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_b_of_type_Long	J
    //   603: aload_0
    //   604: aload_0
    //   605: getfield 628	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   608: ldc_w 1092
    //   611: iconst_0
    //   612: invokevirtual 897	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   615: putfield 176	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:r	I
    //   618: aload_0
    //   619: aload_0
    //   620: ldc_w 1093
    //   623: invokevirtual 1094	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:findViewById	(I)Landroid/view/View;
    //   626: checkcast 429	android/view/ViewGroup
    //   629: putfield 189	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   632: aload_0
    //   633: getfield 405	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_e_of_type_Int	I
    //   636: iconst_1
    //   637: if_icmpne +245 -> 882
    //   640: aload_0
    //   641: aload_0
    //   642: aload_0
    //   643: getfield 104	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_j_of_type_Int	I
    //   646: invokevirtual 439	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:a	(I)Lasvv;
    //   649: putfield 196	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Asvv	Lasvv;
    //   652: aload_0
    //   653: aload_0
    //   654: getfield 196	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Asvv	Lasvv;
    //   657: invokevirtual 442	asvv:a	()Landroid/view/View;
    //   660: putfield 185	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   663: aload_0
    //   664: getfield 189	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   667: aload_0
    //   668: getfield 185	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   671: new 444	android/widget/FrameLayout$LayoutParams
    //   674: dup
    //   675: iconst_m1
    //   676: iconst_m1
    //   677: invokespecial 447	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   680: invokevirtual 451	android/view/ViewGroup:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   683: aload_0
    //   684: aload_0
    //   685: getfield 106	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_k_of_type_Int	I
    //   688: iconst_1
    //   689: iadd
    //   690: putfield 106	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_k_of_type_Int	I
    //   693: aload_0
    //   694: iconst_1
    //   695: putfield 841	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Boolean	Z
    //   698: aload_0
    //   699: getfield 182	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Alkc	Lalkc;
    //   702: ifnull +14 -> 716
    //   705: aload_0
    //   706: getfield 182	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Alkc	Lalkc;
    //   709: aload_0
    //   710: getfield 147	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Alke	Lalke;
    //   713: invokevirtual 1099	alkc:a	(Lalke;)V
    //   716: aload_0
    //   717: ldc_w 1100
    //   720: invokestatic 522	ajjy:a	(I)Ljava/lang/String;
    //   723: invokevirtual 1101	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:a	(Ljava/lang/String;)V
    //   726: new 1103	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity$1
    //   729: dup
    //   730: aload_0
    //   731: invokespecial 1104	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity$1:<init>	(Lcom/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity;)V
    //   734: iconst_5
    //   735: aconst_null
    //   736: iconst_0
    //   737: invokestatic 697	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   740: aload_3
    //   741: ifnull +15 -> 756
    //   744: aload_3
    //   745: invokevirtual 967	befb:a	()Z
    //   748: ifeq +8 -> 756
    //   751: aload_3
    //   752: iconst_4
    //   753: invokevirtual 971	befb:a	(I)V
    //   756: new 1106	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity$2
    //   759: dup
    //   760: aload_0
    //   761: aload_3
    //   762: invokespecial 1109	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity$2:<init>	(Lcom/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity;Lbefb;)V
    //   765: bipush 8
    //   767: aconst_null
    //   768: iconst_0
    //   769: invokestatic 697	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   772: aload_0
    //   773: getfield 492	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   776: bipush 71
    //   778: invokevirtual 498	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   781: checkcast 1111	amvw
    //   784: astore_1
    //   785: aload_1
    //   786: invokevirtual 1114	amvw:a	()Lamwz;
    //   789: invokevirtual 1118	amwz:a	()I
    //   792: ifle +10 -> 802
    //   795: aload_1
    //   796: invokevirtual 1114	amvw:a	()Lamwz;
    //   799: invokevirtual 1119	amwz:a	()V
    //   802: aload_0
    //   803: getfield 554	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   806: ifnull +16 -> 822
    //   809: aload_0
    //   810: getfield 554	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   813: getfield 1121	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_h_of_type_Int	I
    //   816: sipush 999
    //   819: if_icmpne +184 -> 1003
    //   822: bipush 30
    //   824: istore_2
    //   825: aload_0
    //   826: getfield 492	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   829: aload_0
    //   830: invokevirtual 1125	java/lang/Object:getClass	()Ljava/lang/Class;
    //   833: aload_0
    //   834: invokevirtual 1128	java/lang/Object:hashCode	()I
    //   837: ldc_w 1130
    //   840: iload_2
    //   841: aload_0
    //   842: getfield 1088	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Long	J
    //   845: invokestatic 1135	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   848: invokestatic 1140	awsf:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/Class;ILjava/lang/String;ILjava/lang/String;)V
    //   851: iconst_1
    //   852: ireturn
    //   853: aload_0
    //   854: aload_0
    //   855: getfield 554	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   858: getfield 1121	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_h_of_type_Int	I
    //   861: putfield 1075	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_d_of_type_Int	I
    //   864: aload_0
    //   865: aload_0
    //   866: aload_0
    //   867: getfield 554	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   870: getfield 1121	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_h_of_type_Int	I
    //   873: invokevirtual 1142	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:a	(I)I
    //   876: putfield 104	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_j_of_type_Int	I
    //   879: goto -385 -> 494
    //   882: aload_0
    //   883: aload_0
    //   884: getfield 628	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   887: ldc_w 1144
    //   890: invokevirtual 958	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   893: putfield 1145	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   896: aload_0
    //   897: aload_0
    //   898: getfield 628	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   901: ldc_w 1147
    //   904: iconst_0
    //   905: invokevirtual 897	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   908: putfield 1148	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_h_of_type_Int	I
    //   911: aload_0
    //   912: aload_0
    //   913: getfield 628	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   916: ldc_w 1150
    //   919: iconst_0
    //   920: invokevirtual 926	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   923: putfield 1152	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_f_of_type_Boolean	Z
    //   926: aload_0
    //   927: aload_0
    //   928: aload_0
    //   929: getfield 104	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_j_of_type_Int	I
    //   932: invokevirtual 1154	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:a	(I)Lastd;
    //   935: putfield 192	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Astd	Lastd;
    //   938: aload_0
    //   939: aload_0
    //   940: getfield 192	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Astd	Lastd;
    //   943: invokevirtual 1155	astd:a	()Landroid/view/View;
    //   946: putfield 260	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   949: aload_0
    //   950: getfield 192	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Astd	Lastd;
    //   953: invokevirtual 1156	astd:a	()V
    //   956: aload_0
    //   957: getfield 260	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   960: instanceof 1158
    //   963: ifeq +17 -> 980
    //   966: aload_0
    //   967: getfield 260	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   970: checkcast 1158	com/tencent/mobileqq/widget/PerfRelativeLayout
    //   973: aload_0
    //   974: getfield 173	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Apnm	Lapnm;
    //   977: invokevirtual 1162	com/tencent/mobileqq/widget/PerfRelativeLayout:setOnDrawCompleteListener	(Lapnm;)V
    //   980: aload_0
    //   981: getfield 189	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   984: aload_0
    //   985: getfield 260	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   988: new 444	android/widget/FrameLayout$LayoutParams
    //   991: dup
    //   992: iconst_m1
    //   993: iconst_m1
    //   994: invokespecial 447	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   997: invokevirtual 451	android/view/ViewGroup:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   1000: goto -302 -> 698
    //   1003: aload_0
    //   1004: getfield 554	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1007: getfield 1121	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_h_of_type_Int	I
    //   1010: istore_2
    //   1011: goto -186 -> 825
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1014	0	this	NearbyPeopleProfileActivity
    //   0	1014	1	paramBundle	Bundle
    //   505	506	2	i1	int
    //   45	717	3	localbefb	befb
    // Exception table:
    //   from	to	target	type
    //   137	144	402	java/lang/OutOfMemoryError
    //   357	373	409	java/lang/Exception
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeObserver(this.jdField_a_of_type_Asfx);
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_Ajfw != null)
    {
      this.jdField_a_of_type_Ajfw.d(this.jdField_b_of_type_Ajga);
      this.jdField_a_of_type_Ajfw.d(this.jdField_a_of_type_Ajga);
      this.jdField_a_of_type_Ajfw.b(this);
    }
    if (this.jdField_a_of_type_Asvv != null) {
      this.jdField_a_of_type_Asvv.a();
    }
    if (this.app.a().jdField_a_of_type_JavaUtilArrayList != null) {}
    for (int i1 = this.app.a().jdField_a_of_type_JavaUtilArrayList.size();; i1 = 0)
    {
      int i2;
      if (this.jdField_a_of_type_Astd != null)
      {
        i2 = this.jdField_a_of_type_Astd.b();
        this.jdField_a_of_type_Astd.g();
      }
      for (;;)
      {
        Object localObject = (axsm)this.app.a().a(null, 0L);
        if (localObject != null) {
          ((axsm)localObject).f();
        }
        try
        {
          if (this.jdField_a_of_type_AndroidContentIntent.getIntExtra("frome_where", 0) == -2)
          {
            if (this.jdField_q_of_type_Int > 0) {
              awqx.b(this.app, "CliOper", "", "", "0X80059BB", "0X80059BB", 0, 0, "", "", "", "");
            }
          }
          else
          {
            if (this.jdField_a_of_type_Astd != null) {
              this.jdField_a_of_type_Astd.b();
            }
            localObject = awsf.a(getClass(), hashCode());
            if (localObject != null)
            {
              awqx.b(this.app, "CliOper", "", "", ((awsg)localObject).jdField_a_of_type_JavaLangString, ((awsg)localObject).jdField_a_of_type_JavaLangString, ((awsg)localObject).jdField_a_of_type_Int, 0, String.valueOf(this.jdField_a_of_type_Long), Long.toString(SystemClock.elapsedRealtime() - ((awsg)localObject).jdField_b_of_type_Long), "", "");
              int i3 = (int)(SystemClock.elapsedRealtime() - ((awsg)localObject).jdField_b_of_type_Long) / 1000;
              if (asep.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int, this.jdField_e_of_type_Int)) {
                this.app.a().a(this.jdField_a_of_type_Long, i3, i1, i2);
              }
            }
            if (!Build.BRAND.startsWith("samsung")) {
              break label471;
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            try
            {
              localObject = Class.forName("android.text.MeasuredText").getDeclaredField("sCached");
              ((Field)localObject).setAccessible(true);
              localObject = (Object[])((Field)localObject).get(null);
              i1 = 0;
              if (i1 >= localObject.length) {
                break;
              }
              localObject[i1] = null;
              i1 += 1;
              continue;
              awqx.b(this.app, "CliOper", "", "", "0X80059BC", "0X80059BC", 0, 0, "", "", "", "");
            }
            catch (Throwable localThrowable)
            {
              localThrowable.printStackTrace();
            }
            localException = localException;
          }
        }
        label471:
        return;
        i2 = 0;
      }
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (paramIntent.getBooleanExtra("key_back_from_add_friend", false)) {
      doOnActivityResult(1000, -1, paramIntent);
    }
    do
    {
      for (;;)
      {
        return;
        if (this.jdField_e_of_type_Int != 1) {
          break label233;
        }
        paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        if ((paramIntent == null) || (paramIntent.size() <= 0)) {
          break;
        }
        this.jdField_c_of_type_JavaLangString = null;
        int i1 = 0;
        while (i1 < paramIntent.size())
        {
          if (this.jdField_a_of_type_JavaUtilArrayList.size() < jdField_c_of_type_Int)
          {
            localObject = new PicInfo();
            ((PicInfo)localObject).jdField_c_of_type_JavaLangString = ((String)paramIntent.get(i1));
            if (this.jdField_a_of_type_Asvv.a((PicInfo)localObject)) {
              this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 1000L);
            }
          }
          i1 += 1;
        }
      }
    } while (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString));
    paramIntent = bfpy.a();
    paramIntent.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
    paramIntent.jdField_b_of_type_JavaLangString = this.app.getCurrentNickname();
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("key_title", getString(2131652217));
    ((Bundle)localObject).putInt("key_personal_album_enter_model", 2);
    ((Bundle)localObject).putBoolean("show_album", false);
    ((Bundle)localObject).putString("key_jump_album_id", this.jdField_c_of_type_JavaLangString);
    ((Bundle)localObject).putBoolean("key_need_change_to_jpg", true);
    bfpr.a(this, paramIntent, (Bundle)localObject, 5);
    return;
    label233:
    atcg.a(this, 1000, -1, paramIntent);
  }
  
  public void doOnPause()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(true);
    }
    beex.a(this);
    this.app.removeObserver(this.jdField_a_of_type_Ajjh);
    this.app.removeObserver(this.jdField_a_of_type_Ajkn);
    ApngImage.pauseAll();
    AbstractVideoImage.pauseAll();
    if (this.jdField_a_of_type_Astd != null) {
      this.jdField_a_of_type_Astd.e();
    }
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    if (this.jdField_a_of_type_Astd != null) {
      this.jdField_a_of_type_Astd.d();
    }
    this.app.addObserver(this.jdField_a_of_type_Ajjh);
    this.app.addObserver(this.jdField_a_of_type_Ajkn);
    ApngImage.playByTag(15);
    AbstractVideoImage.resumeAll();
    if (getApplication() == null) {
      finish();
    }
    do
    {
      return;
      super.doOnResume();
      ascz localascz = (ascz)this.app.getManager(106);
      if ((this.jdField_a_of_type_Astd != null) && (this.jdField_a_of_type_Astd.jdField_a_of_type_Boolean))
      {
        localascz.d.put(this.app.getCurrentAccountUin(), Integer.valueOf(1));
        this.jdField_a_of_type_Astd.jdField_a_of_type_Boolean = false;
      }
      this.jdField_k_of_type_Boolean = localascz.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby_people_card.", 2, "doOnResume, isNeedUpdateProfile=" + this.jdField_k_of_type_Boolean + ", isForceUpdateOnResume=" + this.jdField_l_of_type_Boolean);
      }
      if ((this.jdField_k_of_type_Boolean) || (this.jdField_l_of_type_Boolean))
      {
        this.jdField_l_of_type_Boolean = false;
        ThreadManager.post(new NearbyPeopleProfileActivity.3(this), 8, null, false);
        this.v = false;
        return;
      }
      if ((!this.v) || (this.jdField_e_of_type_Int != 3) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null)) {
        break;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.switchGiftVisible != 0L);
    ThreadManager.post(new NearbyPeopleProfileActivity.4(this), 8, null, false);
    this.v = false;
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_a_of_type_Astd != null) {
      this.jdField_a_of_type_Astd.c();
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    this.v = true;
    if ((this.jdField_e_of_type_Int == 2) && (this.jdField_a_of_type_Astd != null) && (this.jdField_a_of_type_Astd.a()))
    {
      this.jdField_a_of_type_Astd.h();
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uRoomid != 0L) && (this.jdField_a_of_type_Astd != null)) {
        this.jdField_a_of_type_Astd.i();
      }
    }
    befb localbefb = befb.b;
    if ((localbefb != null) && (localbefb.a(true))) {
      localbefb.a(this.app.getCurrentAccountUin());
    }
    if (this.jdField_a_of_type_Astd != null) {
      this.jdField_a_of_type_Astd.f();
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (!this.x)
    {
      this.jdField_i_of_type_Int = this.app.getPreferences().getInt("nearby_people_profile_ok_new", 0);
      this.jdField_n_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("is_from_web", false);
      this.m = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("abp_flag", false);
      if (this.jdField_a_of_type_AndroidContentIntent.getIntExtra("frome_where", 0) == -1)
      {
        String str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("PUSH_CONTENT");
        String str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        awqx.b(this.app, "CliOper", "", "", "0X800524A", "0X800524A", 0, 0, "", "", str1, "");
      }
      this.x = true;
    }
  }
  
  protected void e()
  {
    ascv localascv = new ascv();
    localascv.jdField_a_of_type_Int = -1;
    ascv.a(this.app.getCurrentAccountUin(), localascv);
    this.jdField_i_of_type_Int = 1;
    this.app.getPreferences().edit().putInt("nearby_people_profile_ok_new", 1).commit();
  }
  
  protected void f()
  {
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public void finish()
  {
    super.finish();
    if (this.m) {
      overridePendingTransition(2130771988, 2130771989);
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby.tribeAppDownload", 2, "showUploadPhotoActionSheet, isAddPicBtnDownloadAppOpen=" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isAddPicBtnDownloadAppOpen() + ", addPicBtnDownloadAppTips:" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.addPicBtnDownloadAppTips + ", tribeAppDownloadPageUrl=" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tribeAppDownloadPageUrl);
    }
    String[] arrayOfString = getResources().getStringArray(2130903098);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isAddPicBtnDownloadAppOpen()) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.addPicBtnDownloadAppTips)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tribeAppDownloadPageUrl)))
    {
      ascz.a(this, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.addPicBtnDownloadAppTips, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tribeAppDownloadPageUrl, 2);
      return;
    }
    begr localbegr = begr.a(this);
    localbegr.c(arrayOfString[28]);
    localbegr.c(arrayOfString[29]);
    localbegr.d(arrayOfString[16]);
    localbegr.a(new assv(this, localbegr));
    localbegr.show();
  }
  
  public void h()
  {
    bfpy localbfpy = bfpy.a();
    localbfpy.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
    localbfpy.jdField_b_of_type_JavaLangString = this.app.getCurrentNickname();
    Bundle localBundle = new Bundle();
    localBundle.putString("key_title", getString(2131652217));
    localBundle.putInt("key_personal_album_enter_model", 2);
    localBundle.putBoolean("show_album", false);
    localBundle.putBoolean("key_need_change_to_jpg", true);
    bfpr.a(this, localbfpy, localBundle, 5);
    awqx.b(this.app, "CliOper", "", "", "0X800481F", "0X800481F", 2, 0, "", "", "", "");
  }
  
  public void i()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) || (this.w) || (isFinishing())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.nearby_people_card.", 2, "refreshStangerFace.");
    }
    this.w = true;
    this.jdField_a_of_type_JavaLangRunnable = new NearbyPeopleProfileActivity.22(this);
    ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 5, null, true);
  }
  
  public boolean isWrapContent()
  {
    boolean bool = true;
    if (this.jdField_e_of_type_Int == 1) {
      bool = false;
    }
    return bool;
  }
  
  public boolean onBackEvent()
  {
    int i1 = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_mode", 0);
    if (i1 == 1)
    {
      a(2131633403);
      return true;
    }
    if ((i1 == 2) && (this.jdField_e_of_type_Int == 1))
    {
      if (this.jdField_i_of_type_Int == 0)
      {
        a(2131633403);
        return true;
      }
      if (this.jdField_a_of_type_Asvv.a())
      {
        a(2131633393);
        return true;
      }
      c();
      return true;
    }
    if (this.m)
    {
      localIntent = new Intent(this, NearbyActivity.class);
      localIntent.putExtra("abp_flag", this.m);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
    }
    Intent localIntent = new Intent();
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
    {
      localIntent.putExtra("nearby_profile_nickname", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname);
      localIntent.putExtra("param_gender", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender);
      localIntent.putExtra("param_vote_num", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.likeCount);
      localIntent.putExtra("param_vote_num_add", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.likeCountInc);
      localIntent.putExtra("param_level", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.charmLevel);
    }
    if ((getIntent().getBooleanExtra("from_newer_guide", false)) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null))
    {
      Object localObject = this.app.a().a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, 1001);
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label476;
      }
      localObject = ((List)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!((ChatMessage)((Iterator)localObject).next()).isSendFromLocal());
    }
    label466:
    label471:
    label476:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.nearby_people_card.", 2, "onBackEvent hasSayHi: " + bool);
      }
      localIntent.putExtra("has_operation", bool);
      localIntent.putExtra("uin", String.valueOf(this.jdField_a_of_type_Long));
      localIntent.putExtra("intent_key_has_ever_vote", this.jdField_q_of_type_Boolean);
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo.d)))
        {
          bool = true;
          localIntent.putExtra("param_real_video_auth", bool);
        }
      }
      else
      {
        setResult(-1, localIntent);
        if (getIntent().getIntExtra("frome_where", 0) != 35) {
          break label466;
        }
      }
      for (i1 = 1;; i1 = 0)
      {
        if (i1 == 0) {
          break label471;
        }
        finish();
        baaf.a(this, false, false);
        return true;
        bool = false;
        break;
      }
      return super.onBackEvent();
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(paramIntent);
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity
 * JD-Core Version:    0.7.0.1
 */