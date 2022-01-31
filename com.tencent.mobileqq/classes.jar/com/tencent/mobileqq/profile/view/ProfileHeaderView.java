package com.tencent.mobileqq.profile.view;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import alpg;
import alud;
import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aowp;
import aowq;
import aowr;
import aows;
import apit;
import aufv;
import awor;
import awqt;
import awra;
import awrm;
import awrn;
import awsp;
import awvc;
import awvd;
import awve;
import awvf;
import awvg;
import awvh;
import awvi;
import awvj;
import awvk;
import awvl;
import ayec;
import ayfg;
import ayfh;
import ayfi;
import ayfm;
import azkz;
import azmk;
import azqs;
import bamp;
import bcyw;
import bcyx;
import bdbk;
import bddf;
import bdeu;
import bdgc;
import bdoo;
import benl;
import beri;
import bevq;
import bhsl;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.model.CoverCacheData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f.LongNickItem;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f.RspBody;

public abstract class ProfileHeaderView
  extends RelativeLayout
  implements View.OnClickListener, ayfh, benl
{
  public static String a;
  public static int b;
  public static int c;
  protected float a;
  public int a;
  public long a;
  protected alpg a;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new awvc(this);
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new awvh(this);
  public apit a;
  public awqt a;
  public bhsl a;
  public BaseActivity a;
  public QQAppInterface a;
  public HashMap<String, View> a;
  public AtomicBoolean a;
  private boolean jdField_a_of_type_Boolean;
  protected float b;
  public String b;
  public AtomicBoolean b;
  protected float c;
  private float d;
  public int d;
  public int e;
  public int f;
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.profilecard.FrdProfileCard.ProfileHeaderView";
    jdField_b_of_type_Int = 1000;
    jdField_c_of_type_Int = 1003;
  }
  
  public ProfileHeaderView(BaseActivity paramBaseActivity, awqt paramawqt)
  {
    super(paramBaseActivity);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Bhsl = new bhsl(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_Alpg = new awvl(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    this.jdField_a_of_type_Awqt = paramawqt;
    paramBaseActivity = getResources().getDisplayMetrics();
    this.jdField_a_of_type_Float = paramBaseActivity.density;
    this.jdField_b_of_type_Float = Math.min(paramBaseActivity.widthPixels, paramBaseActivity.heightPixels);
    this.jdField_c_of_type_Float = Math.max(paramBaseActivity.widthPixels, paramBaseActivity.heightPixels);
    this.jdField_d_of_type_Float = (this.jdField_b_of_type_Float - azkz.a(127.0F));
  }
  
  private String a(TextView paramTextView, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "combineNickNameAndNumber");
    }
    if ((paramTextView == null) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {
      return null;
    }
    TextPaint localTextPaint = paramTextView.getPaint();
    paramTextView = localTextPaint;
    if (localTextPaint == null)
    {
      paramTextView = new TextPaint(1);
      paramTextView.density = this.jdField_a_of_type_Float;
    }
    float f1 = paramTextView.measureText("…");
    float f2 = this.jdField_a_of_type_Float;
    float f3 = paramTextView.measureText(String.format("QQ：%s ()", new Object[] { paramString2 }));
    paramString1 = TextUtils.ellipsize(paramString1, paramTextView, this.jdField_d_of_type_Float - f3 - (f1 + 5.0F * f2), TextUtils.TruncateAt.END);
    paramTextView = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramTextView = "…";
    }
    return String.format("QQ：%s (%s)", new Object[] { paramString2, paramTextView });
  }
  
  private void a(ImageView paramImageView)
  {
    if (paramImageView != null)
    {
      paramImageView = paramImageView.getDrawable();
      if ((paramImageView instanceof bdbk)) {
        ((bdbk)paramImageView).a(false);
      }
    }
  }
  
  private void d()
  {
    if ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_Bhsl != null) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      Message localMessage = this.jdField_a_of_type_Bhsl.obtainMessage(jdField_b_of_type_Int);
      if (localMessage != null) {
        this.jdField_a_of_type_Bhsl.sendMessage(localMessage);
      }
    }
  }
  
  private void d(awqt paramawqt)
  {
    int j = 2;
    if (paramawqt != null)
    {
      bddf.a(paramawqt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      int i = j;
      if (paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null)
      {
        i = j;
        if (paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
          i = 1;
        }
      }
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009999", "0X8009999", i, 0, "", "", "", "");
    }
  }
  
  public int a()
  {
    return 0;
  }
  
  public SpannableStringBuilder a(awqt paramawqt, SpannableString paramSpannableString, TextView paramTextView)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramSpannableString);
    if (paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      localSpannableStringBuilder.insert(0, "[S] ");
      paramawqt = null;
    }
    try
    {
      paramSpannableString = BitmapFactory.decodeResource(getResources(), 2130845448);
      paramawqt = paramSpannableString;
    }
    catch (OutOfMemoryError paramSpannableString)
    {
      for (;;)
      {
        int i;
        paramSpannableString.printStackTrace();
      }
    }
    catch (Throwable paramSpannableString)
    {
      for (;;)
      {
        paramSpannableString.printStackTrace();
      }
    }
    paramawqt = new bevq(getResources(), paramawqt, false, false);
    i = (int)(paramTextView.getTextSize() + 0.5F);
    paramawqt.setBounds(0, 0, i, i);
    paramawqt = new beri(paramawqt, 0);
    paramawqt.a(-0.1F);
    localSpannableStringBuilder.setSpan(paramawqt, 0, "[S]".length(), 17);
    return localSpannableStringBuilder;
  }
  
  public CoverCacheData a()
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qzonecover");
    if ((localObject instanceof QzonePhotoView))
    {
      localObject = (QzonePhotoView)localObject;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "updateQzonePhotoView");
      }
      return ((QzonePhotoView)localObject).a();
    }
    if ((localObject instanceof VipPhotoViewForSimple))
    {
      localObject = (VipPhotoViewForSimple)localObject;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "updateVipPhotoViewForSimple");
      }
      return ((VipPhotoViewForSimple)localObject).a();
    }
    return null;
  }
  
  public void a() {}
  
  public void a(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    if (!paramBoolean)
    {
      paramView.setVisibility(8);
      return;
    }
    if (!awrn.a().c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      paramView.setVisibility(8);
      return;
    }
    Object localObject = aows.a();
    if ((localObject == null) || (((aowp)localObject).a()))
    {
      paramView.setVisibility(8);
      return;
    }
    paramView.setVisibility(0);
    TextView localTextView = (TextView)paramView.findViewById(2131378847);
    ImageView localImageView = (ImageView)paramView.findViewById(2131368742);
    ArrayList localArrayList = ((aowp)localObject).a().a;
    localTextView.setText(awrn.a().a((aowp)localObject));
    int i = 0;
    int j;
    while (i < ((aowp)localObject).a().a.size()) {
      if (TextUtils.isEmpty(((aowr)localArrayList.get(i)).jdField_a_of_type_JavaLangString))
      {
        i += 1;
      }
      else
      {
        j = ((aowr)localArrayList.get(i)).jdField_a_of_type_Int;
        localObject = ((aowr)localArrayList.get(i)).jdField_a_of_type_JavaLangString;
      }
    }
    for (i = j;; i = -1)
    {
      if (paramBoolean) {
        paramView.setOnClickListener(new awvf(this, (String)localObject, i, paramView));
      }
      localImageView.setOnClickListener(new awvg(this, paramView));
      azqs.b(null, "dc00898", "", "", "0X800A4D4", "0X800A4D4", 0, 0, "2", "0", "", "");
      return;
      localObject = "";
    }
  }
  
  public void a(LinearLayout paramLinearLayout, awqt paramawqt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "makeAccountDetailInfoForQQCircle");
    }
    if ((paramawqt == null) || (paramLinearLayout == null)) {
      return;
    }
    paramLinearLayout.removeAllViews();
    List localList = bddf.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard);
    boolean bool = localList.isEmpty();
    int i;
    int j;
    if ((paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0))
    {
      i = 1;
      if ((bool) && (i != 0)) {
        localList.add(android.util.Pair.create(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131699679), ""));
      }
      if (!localList.isEmpty())
      {
        j = localList.size();
        i = 0;
      }
    }
    else
    {
      for (;;)
      {
        for (;;)
        {
          String str;
          TextView localTextView;
          if (i < j)
          {
            android.util.Pair localPair = (android.util.Pair)localList.get(i);
            str = (String)localPair.first;
            localTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
            localTextView.setText(str);
            localTextView.setTextColor(getResources().getColor(2131166903));
            if (!TextUtils.isEmpty((CharSequence)localPair.second))
            {
              localTextView.setBackgroundResource(2130843659);
              localTextView.setPadding(bdoo.b(8.0F), bdoo.b(4.5F), bdoo.b(8.0F), bdoo.b(4.5F));
            }
            localTextView.setTextSize(14.0F);
            paramLinearLayout.addView(localTextView);
          }
          try
          {
            ((LinearLayout.LayoutParams)localTextView.getLayoutParams()).rightMargin = bdoo.b(6.0F);
            paramLinearLayout.measure(0, 0);
            QLog.d(jdField_a_of_type_JavaLangString, 2, "makeAccountDetailInfoForQQCircle " + str + ", " + this.jdField_d_of_type_Float + ", " + paramLinearLayout.getMeasuredWidth());
            if (paramLinearLayout.getMeasuredWidth() > this.jdField_d_of_type_Float)
            {
              paramLinearLayout.removeView(localTextView);
              paramLinearLayout.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
              paramLinearLayout.setOnClickListener(new awve(this, paramawqt));
              return;
              i = 0;
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
            }
            if (!bool) {
              bddf.a(localTextView, null, null, paramawqt.jdField_a_of_type_AndroidViewView$OnLongClickListener);
            }
            i += 1;
          }
        }
      }
    }
    paramLinearLayout.setVisibility(8);
  }
  
  public void a(TextView paramTextView, awqt paramawqt)
  {
    Object localObject2 = null;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "makeAccountDetailInfo");
    }
    if (paramTextView == null) {
      return;
    }
    if (paramawqt == null) {}
    for (Card localCard = null; (paramawqt == null) || (localCard == null) || (ProfileActivity.AllInOne.j(paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (ProfileActivity.AllInOne.k(paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)); localCard = paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard)
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_uin_info");
      paramTextView.setVisibility(8);
      return;
    }
    paramTextView.setVisibility(0);
    Object localObject1;
    boolean bool;
    String str1;
    if (paramawqt.b)
    {
      localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(paramawqt.jdField_a_of_type_JavaLangString, localCard.uin);
      if ((localObject1 != null) && (TextUtils.isEmpty(((TroopMemberInfo)localObject1).troopnick)) && (!TextUtils.isEmpty(localCard.strReMark))) {
        localObject2 = localCard.strNick;
      }
      for (;;)
      {
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = bdgc.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localCard.uin, false);
        }
        if (!TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramawqt.jdField_a_of_type_JavaLangString)) {
          break;
        }
        localObject2 = localObject1;
        paramTextView.setVisibility(0);
        paramTextView.setSingleLine(true);
        paramTextView.setText((CharSequence)localObject1);
        paramTextView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
        paramTextView.setOnClickListener(new awvk(this, paramawqt));
        bddf.a(paramTextView, localCard.uin, (String)localObject2, paramawqt.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        return;
        if (TextUtils.isEmpty(localCard.strReMark)) {
          localObject2 = localCard.strNick;
        } else {
          localObject2 = localCard.strReMark;
        }
      }
      localObject2 = localCard.uin;
      if (!localCard.isNoCover()) {}
      for (bool = true;; bool = false)
      {
        str1 = a(paramTextView, (String)localObject1, (String)localObject2, bool);
        localObject2 = localObject1;
        localObject1 = str1;
        break;
      }
    }
    if ((paramawqt.jdField_a_of_type_ArrayOfJavaLangString != null) && (!TextUtils.isEmpty(paramawqt.jdField_a_of_type_ArrayOfJavaLangString[5])) && (!TextUtils.equals(paramawqt.jdField_a_of_type_ArrayOfJavaLangString[5], localCard.strNick))) {}
    for (int i = 1;; i = 0)
    {
      if ((!TextUtils.isEmpty(localCard.strReMark)) || (i != 0))
      {
        localObject1 = localCard.strNick;
        localObject2 = localCard.uin;
        if (!localCard.isNoCover()) {}
        for (bool = true;; bool = false)
        {
          String str2 = a(paramTextView, (String)localObject1, (String)localObject2, bool);
          str1 = localCard.strNick;
          localObject1 = str2;
          localObject2 = str1;
          if (!TextUtils.isEmpty(str2)) {
            break;
          }
          localObject1 = String.format("QQ：%s", new Object[] { localCard.uin });
          localObject2 = str1;
          break;
        }
      }
      localObject1 = String.format("QQ：%s", new Object[] { localCard.uin });
      break;
    }
  }
  
  public void a(awqt paramawqt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "ProfileHeaderView onInit");
    }
    c(paramawqt);
    if (paramawqt.jdField_a_of_type_Awra != null) {
      j(paramawqt);
    }
    View localView;
    if ((paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) || (paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
    {
      paramawqt = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("VipPersonalLike", 0);
      if (paramawqt.getInt("ProfilePersonalLikeMasterHasShownTip_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), -1) != 1)
      {
        localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_personal_like_tip");
        if (!azmk.b()) {
          break label163;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "ProfileHeaderView onInit, SimpleUIMode is open now");
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alpg);
      return;
      label163:
      if (localView != null)
      {
        localView.setVisibility(0);
        paramawqt.edit().putInt("ProfilePersonalLikeMasterHasShownTip_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1).apply();
      }
    }
  }
  
  public void a(awqt paramawqt, long paramLong, boolean paramBoolean)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    if ((localObject instanceof VoteView))
    {
      localObject = (VoteView)localObject;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateLiked");
      }
      long l = paramLong;
      if (paramLong == -1L) {
        l = ((VoteView)localObject).jdField_a_of_type_Int;
      }
      if ((paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt == 0)) {
        ((VoteView)localObject).a();
      }
      ((VoteView)localObject).a(false, true, (int)l, 0, null, paramBoolean);
      ((VoteView)localObject).setOnClickListener(paramawqt.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((VoteView)localObject).setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691210), new Object[] { String.valueOf(l) }));
    }
  }
  
  public void a(awqt paramawqt, String paramString)
  {
    paramString = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_uin_info");
    if ((paramString instanceof TextView)) {
      a((TextView)paramString, paramawqt);
    }
  }
  
  public void a(awqt paramawqt, HashMap<String, String> paramHashMap)
  {
    paramawqt = paramawqt.jdField_a_of_type_Awra.a;
    String str1 = getClass().getName();
    if ((paramawqt == null) || (paramawqt.size() <= 0)) {
      throw new ProfileTemplateException(str1 + " template templateAttr is null");
    }
    paramHashMap.put("commonBottomBtnBackground", "drawable");
    paramHashMap.put("commonBottomBtnTextColor", "color");
    paramHashMap.put("commonItemTitleColor", "color");
    paramHashMap.put("commonItemContentColor", "color");
    paramHashMap.put("commonItemContentLinkColor", "color");
    paramHashMap.put("commonItemTopBorderBackground", "drawable");
    paramHashMap.put("commonItemBottomBorderBackground", "drawable");
    paramHashMap.put("commonItemBorderBackground", "drawable");
    paramHashMap.put("commonItemMoreSrc", "drawable");
    paramHashMap.put("commonQrCodeSrc", "drawable");
    paramHashMap.put("commonMaskBackground", "color");
    paramHashMap = paramHashMap.entrySet().iterator();
    label435:
    label438:
    for (;;)
    {
      Object localObject1;
      String str2;
      Object localObject2;
      int i;
      String str3;
      if (paramHashMap.hasNext())
      {
        localObject1 = (Map.Entry)paramHashMap.next();
        str2 = (String)((Map.Entry)localObject1).getKey();
        localObject1 = (String)((Map.Entry)localObject1).getValue();
        localObject2 = paramawqt.get(str2);
        String[] arrayOfString = ((String)localObject1).split(",");
        int j = arrayOfString.length;
        i = 0;
        if (i >= j) {
          break label435;
        }
        str3 = arrayOfString[i];
        if ((localObject2 != null) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3))) {
          if ((str3.equalsIgnoreCase("color")) && (((localObject2 instanceof ColorStateList)) || ((localObject2 instanceof String)))) {
            i = 1;
          }
        }
      }
      for (;;)
      {
        if (i != 0) {
          break label438;
        }
        throw new ProfileTemplateException(str1 + " template attr " + str2 + " type is not " + (String)localObject1);
        if ((str3.equalsIgnoreCase("drawable")) && ((localObject2 instanceof Drawable)))
        {
          i = 1;
        }
        else if ((str3.equalsIgnoreCase("string")) && ((localObject2 instanceof String)) && (!TextUtils.isEmpty((String)localObject2)))
        {
          i = 1;
        }
        else
        {
          i += 1;
          break;
          return;
          i = 0;
        }
      }
    }
  }
  
  public abstract void a(awqt paramawqt, boolean paramBoolean);
  
  public void a(ayfg paramayfg, View paramView)
  {
    paramayfg = paramayfg.a();
    if ((paramayfg instanceof com.tencent.util.Pair))
    {
      paramayfg = (com.tencent.util.Pair)paramayfg;
      ayfm.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ayfm.a(((Integer)paramayfg.first).intValue(), (String)paramayfg.second), -1);
    }
  }
  
  public void a(ProfileActivity.AllInOne paramAllInOne)
  {
    if (paramAllInOne.jdField_a_of_type_Int == 33)
    {
      a(paramAllInOne, 2, paramAllInOne.jdField_a_of_type_JavaLangString, false);
      return;
    }
    String str;
    if (paramAllInOne.jdField_a_of_type_Int == 80)
    {
      str = bddf.a(paramAllInOne);
      if ((str != null) && (str.length() > 0))
      {
        localObject = (aufv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
        if (localObject == null) {
          break label264;
        }
      }
    }
    label264:
    for (Object localObject = ((aufv)localObject).c(str);; localObject = null)
    {
      if (localObject != null)
      {
        a(paramAllInOne, 1, str, false);
        return;
      }
      a(paramAllInOne, 0, paramAllInOne.jdField_a_of_type_JavaLangString, false);
      return;
      a(paramAllInOne, 0, paramAllInOne.jdField_a_of_type_JavaLangString, false);
      return;
      if (ProfileActivity.AllInOne.g(paramAllInOne))
      {
        if (((paramAllInOne.jdField_a_of_type_Int == 41) || (paramAllInOne.jdField_a_of_type_Int == 86)) && (!TextUtils.isEmpty(paramAllInOne.jdField_a_of_type_JavaLangString)) && (paramAllInOne.jdField_a_of_type_JavaLangString.equals("0")) && (!TextUtils.isEmpty(paramAllInOne.p)))
        {
          a(paramAllInOne, 0, paramAllInOne.p, false);
          return;
        }
        a(paramAllInOne, 0, paramAllInOne.jdField_a_of_type_JavaLangString, true);
        return;
      }
      localObject = bddf.a(paramAllInOne);
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        if (paramAllInOne.jdField_a_of_type_Int == 53)
        {
          if (paramAllInOne.b) {}
          for (int i = 1;; i = 3)
          {
            a(paramAllInOne, i, (String)localObject, false);
            return;
          }
        }
        a(paramAllInOne, 1, (String)localObject, false);
        return;
      }
      a(paramAllInOne, 2, paramAllInOne.jdField_a_of_type_JavaLangString, false);
      return;
    }
  }
  
  public void a(ProfileActivity.AllInOne paramAllInOne, int paramInt, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "updateAvatar() type = " + paramInt + "key = " + paramString + ",isDynamicMode:" + paramBoolean);
    }
    if ((!paramBoolean) || (paramInt != 0))
    {
      ThreadManager.post(new ProfileHeaderView.3(this, paramInt, paramAllInOne, paramString), 8, null, true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new ProfileHeaderView.4(this, paramAllInOne, paramInt, paramString));
  }
  
  public void a(CoverCacheData paramCoverCacheData)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qzonecover");
    if ((localObject instanceof QzonePhotoView))
    {
      localObject = (QzonePhotoView)localObject;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "updateQzonePhotoView");
      }
      ((QzonePhotoView)localObject).a(paramCoverCacheData);
    }
    while (!(localObject instanceof VipPhotoViewForSimple)) {
      return;
    }
    localObject = (VipPhotoViewForSimple)localObject;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "updateVipPhotoViewForSimple");
    }
    ((VipPhotoViewForSimple)localObject).a(paramCoverCacheData);
  }
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString, int paramInt, List<awrm> paramList) {}
  
  public void a(boolean paramBoolean, String paramString, mobile_sub_get_photo_wall_rsp parammobile_sub_get_photo_wall_rsp)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qzonecover");
    if ((localObject instanceof QzonePhotoView))
    {
      localObject = (QzonePhotoView)localObject;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "QzonePhotoView onGetQZoneCover isSuccess=" + String.valueOf(paramBoolean) + ",uin=" + paramString);
      }
      ((QzonePhotoView)localObject).a(paramBoolean, paramString, parammobile_sub_get_photo_wall_rsp);
    }
    while (!(localObject instanceof VipPhotoViewForSimple)) {
      return;
    }
    localObject = (VipPhotoViewForSimple)localObject;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "VipPhotoViewForSimple onGetQZoneCover isSuccess=" + String.valueOf(paramBoolean) + ",uin=" + paramString);
    }
    ((VipPhotoViewForSimple)localObject).a(paramBoolean, paramString, parammobile_sub_get_photo_wall_rsp);
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  protected boolean a(awqt paramawqt)
  {
    boolean bool4 = false;
    boolean bool2;
    boolean bool5;
    boolean bool6;
    boolean bool1;
    if ((paramawqt != null) && (paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard != null))
    {
      bool2 = true;
      bool5 = TextUtils.equals(paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      bool6 = ProfileActivity.AllInOne.b(paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      if ((bool5) || (bool6)) {
        break label178;
      }
      if ((!bool2) || (!paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard.strangerVoteOpen)) {
        break label173;
      }
      bool1 = true;
    }
    label70:
    for (boolean bool3 = bool1 & bool2;; bool3 = bool2)
    {
      if (QLog.isColorLevel())
      {
        String str = paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
        if (bool2) {
          bool4 = paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard.strangerVoteOpen;
        }
        QLog.d("Q.profilecard.FrdProfileCard", 2, String.format("isShowZan updateLike show=%b uin=%sself=%b frd=%b cardOk=%b open=%b ", new Object[] { Boolean.valueOf(bool3), str, Boolean.valueOf(bool5), Boolean.valueOf(bool6), Boolean.valueOf(bool2), Boolean.valueOf(bool4) }));
      }
      return bool3;
      bool2 = false;
      break;
      bool1 = false;
      break label70;
    }
  }
  
  public void b() {}
  
  public void b(TextView paramTextView, awqt paramawqt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "makeAccountDetailInfo");
    }
    if ((paramawqt == null) || (paramTextView == null)) {
      return;
    }
    List localList = bddf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard);
    boolean bool = localList.isEmpty();
    int i;
    label70:
    SpannableStringBuilder localSpannableStringBuilder;
    int n;
    Object localObject2;
    Object localObject3;
    int m;
    int j;
    int k;
    if ((paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0))
    {
      i = 1;
      if ((bool) && (i != 0)) {
        localList.add(new SpannableString(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131699679)));
      }
      if (localList.isEmpty()) {
        break label585;
      }
      localSpannableStringBuilder = new SpannableStringBuilder();
      n = localList.size();
      localObject2 = bddf.a(localList, 0, n, "  ", localSpannableStringBuilder);
      localObject3 = paramTextView.getPaint();
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = new TextPaint(1);
        ((TextPaint)localObject1).density = this.jdField_a_of_type_Float;
      }
      if (((TextPaint)localObject1).measureText((CharSequence)localObject2, 0, ((SpannableStringBuilder)localObject2).length() - 1) <= this.jdField_d_of_type_Float) {
        break label592;
      }
      localObject2 = new SpannableStringBuilder();
      i = 0;
      m = 1;
      label265:
      do
      {
        localObject3 = bddf.a(localList, i, m, "  ", localSpannableStringBuilder);
        if (((TextPaint)localObject1).measureText((CharSequence)localObject3, 0, ((SpannableStringBuilder)localObject3).length() - 1) >= this.jdField_d_of_type_Float) {
          break label479;
        }
        j = m + 1;
        k = i;
        m = j;
        i = k;
        if (k < 0) {
          break;
        }
        m = j;
        i = k;
        if (j > n) {
          break;
        }
        m = j;
        i = k;
      } while (k < j);
      i = k;
      m = j;
      label312:
      if ((m > 1) && (i < m - 1) && (m - 1 == n))
      {
        localObject1 = bddf.a(localList, i, m - 1, "  ", localSpannableStringBuilder);
        if (((SpannableStringBuilder)localObject2).length() > 0) {
          ((SpannableStringBuilder)localObject2).append("\n");
        }
        ((SpannableStringBuilder)localObject2).append((CharSequence)localObject1);
      }
    }
    label585:
    label592:
    for (Object localObject1 = localObject2;; localObject1 = localObject2)
    {
      localObject2 = (ViewGroup.MarginLayoutParams)((View)paramTextView.getParent()).getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = 0;
      ((View)paramTextView.getParent()).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      paramTextView.setVisibility(0);
      paramTextView.setSingleLine(true);
      paramTextView.setText((CharSequence)localObject1);
      paramTextView.setEllipsize(TextUtils.TruncateAt.END);
      paramTextView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      paramTextView.setOnClickListener(new awvd(this, paramawqt));
      if (bool) {
        break;
      }
      bddf.a(paramTextView, null, null, paramawqt.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      return;
      i = 0;
      break label70;
      label479:
      if (m - i == 1)
      {
        localObject1 = bddf.a(localList, i, n, "  ", localSpannableStringBuilder);
        if (((SpannableStringBuilder)localObject2).length() > 0) {
          ((SpannableStringBuilder)localObject2).append("\n");
        }
        ((SpannableStringBuilder)localObject2).append((CharSequence)localObject1);
        break label312;
      }
      localObject3 = bddf.a(localList, i, m - 1, "  ", localSpannableStringBuilder);
      if (((SpannableStringBuilder)localObject2).length() > 0) {
        ((SpannableStringBuilder)localObject2).append("\n");
      }
      ((SpannableStringBuilder)localObject2).append((CharSequence)localObject3);
      k = m - 1;
      j = m;
      break label265;
      paramTextView.setVisibility(8);
      return;
    }
  }
  
  public void b(awqt paramawqt)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_sex_age_area");
    String str;
    if ((localObject instanceof TextView))
    {
      localObject = (TextView)localObject;
      str = bddf.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramawqt);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea strInfo=" + bdeu.b(str));
      }
      if (paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33) {
        break label126;
      }
      paramawqt = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131699673);
      if (((TextView)localObject).getVisibility() != 0) {
        ((TextView)localObject).setVisibility(0);
      }
      ((TextView)localObject).setPadding(0, 10, 0, 0);
      ((TextView)localObject).setText(paramawqt);
      ((TextView)localObject).setContentDescription(paramawqt);
    }
    label126:
    do
    {
      return;
      if ((str != null) && (str.length() > 0))
      {
        if (((TextView)localObject).getVisibility() != 0) {
          ((TextView)localObject).setVisibility(0);
        }
        ((TextView)localObject).setPadding(0, 0, 0, 0);
        ((TextView)localObject).setText(str);
        ((TextView)localObject).setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691195) + ":" + str);
        ((TextView)localObject).setClickable(true);
        return;
      }
    } while (((TextView)localObject).getVisibility() == 8);
    ((TextView)localObject).setVisibility(8);
  }
  
  public void b(awqt paramawqt, boolean paramBoolean)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_avatar_pendant");
    if ((localObject instanceof ImageView))
    {
      localObject = (ImageView)localObject;
      if (!ProfileActivity.AllInOne.g(paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        ((ImageView)localObject).setVisibility(4);
        this.jdField_a_of_type_Long = 0L;
      }
    }
    else
    {
      return;
    }
    ThreadManager.post(new ProfileHeaderView.8(this, paramawqt, paramBoolean), 8, null, true);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alpg);
    }
    if (this.jdField_a_of_type_Bhsl != null) {
      this.jdField_a_of_type_Bhsl.removeCallbacksAndMessages(null);
    }
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qzonecover");
    if ((localView instanceof QzonePhotoView)) {
      ((QzonePhotoView)localView).a();
    }
  }
  
  public void c(int paramInt) {}
  
  public void c(awqt paramawqt)
  {
    this.jdField_d_of_type_Int &= 0xFFFFFFFE;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips_net_voice");
    paramawqt = localView;
    if (localView == null) {
      paramawqt = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131561842, null);
    }
    if (paramawqt != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      d();
    }
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tips_net_voice", paramawqt);
  }
  
  public void e(awqt paramawqt)
  {
    if ((paramawqt.b) && (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramawqt.jdField_a_of_type_JavaLangString))) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    } while (!(localObject1 instanceof VoteView));
    VoteView localVoteView = (VoteView)localObject1;
    boolean bool1 = a(paramawqt);
    boolean bool2 = TextUtils.equals(paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (bool1)
    {
      if (localVoteView.getVisibility() != 0) {
        localVoteView.setVisibility(0);
      }
      Object localObject2;
      int j;
      int i;
      if ((paramawqt == null) || (paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard == null))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691286);
        localObject2 = null;
        j = 0;
        i = 0;
        bool1 = false;
        localVoteView.a(bool2, bool1, i, j, this.jdField_a_of_type_Apit, false);
        localVoteView.setTag(localObject2);
        if (paramawqt == null) {
          break label431;
        }
        localVoteView.setOnClickListener(paramawqt.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      for (;;)
      {
        localVoteView.setContentDescription((CharSequence)localObject1);
        return;
        if (this.jdField_a_of_type_Apit == null) {
          this.jdField_a_of_type_Apit = new apit(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 1);
        }
        j = (int)paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard.lVoteCount;
        i = paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard.iVoteIncrement;
        this.jdField_a_of_type_Apit.a = paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard.getLastPraiseInfoList();
        if (i <= this.jdField_a_of_type_Apit.a.size()) {
          this.jdField_a_of_type_Apit.a = this.jdField_a_of_type_Apit.a.subList(0, i);
        }
        this.jdField_a_of_type_Apit.a = awsp.a(this.jdField_a_of_type_Apit.a);
        if (1 == paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard.bVoted) {}
        for (bool1 = true;; bool1 = false)
        {
          if (!bool2) {
            break label364;
          }
          localObject2 = new awor(10, paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard);
          localObject1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691284), new Object[] { String.valueOf(j) });
          k = i;
          i = j;
          j = k;
          break;
        }
        label364:
        localObject2 = new awor(10, paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard);
        localObject1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691198), new Object[] { String.valueOf(j) });
        if (paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt == 0) {
          localVoteView.a();
        }
        int k = i;
        i = j;
        j = k;
        break;
        label431:
        localVoteView.setOnClickListener(null);
      }
    }
    localVoteView.setVisibility(4);
  }
  
  public void f(awqt paramawqt)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_profile_nick_name");
    if (localObject != null) {
      ((View)localObject).setBackgroundResource(2130845335);
    }
    if ((localObject instanceof TextView))
    {
      localTextView = (TextView)localObject;
      localAllInOne = paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
      str = paramawqt.jdField_a_of_type_Bcyx.a.jdField_a_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.FrdProfileCard", 2, "updateHead titleName = " + bdeu.b(str));
      }
      if (str != null)
      {
        localObject = str;
        if (str.length() != 0) {}
      }
      else
      {
        if (!ProfileActivity.AllInOne.a(localAllInOne)) {
          break label223;
        }
        localObject = String.valueOf(localAllInOne.jdField_a_of_type_JavaLangString);
      }
      localTextView.setText((CharSequence)localObject);
      str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691216) + ":";
      localTextView.setContentDescription(str + (String)localObject);
      localTextView.setTag(new awor(88, localTextView.getText().toString()));
      localTextView.setOnClickListener(paramawqt.jdField_a_of_type_AndroidViewView$OnClickListener);
      localTextView.setOnLongClickListener(paramawqt.jdField_a_of_type_AndroidViewView$OnLongClickListener);
    }
    label223:
    while (!(localObject instanceof ProfileNameView)) {
      for (;;)
      {
        TextView localTextView;
        ProfileActivity.AllInOne localAllInOne;
        String str;
        return;
        localObject = " ";
      }
    }
    ((ProfileNameView)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramawqt);
  }
  
  @TargetApi(16)
  public void g(awqt paramawqt)
  {
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tag_jueban");
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    if (((localView instanceof ImageView)) && (localObject != null) && (paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (a(paramawqt)) && (bddf.a(paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard.getBgTypeArray())))
    {
      localObject = "1";
      if (paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
        localObject = "0";
      }
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "card_mall", "0X8007A47", 0, 0, (String)localObject, "", "", "");
      localView.setVisibility(0);
      localView.setTag(new awor(34, null));
      localView.setOnClickListener(paramawqt.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
  }
  
  public void h(awqt paramawqt)
  {
    if ((paramawqt != null) && (paramawqt.b) && (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramawqt.jdField_a_of_type_JavaLangString))) {}
    Object localObject1;
    View localView;
    TextView localTextView;
    Object localObject4;
    do
    {
      do
      {
        do
        {
          return;
          localObject1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_sign");
          localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_sign_common_topic");
        } while ((!(localObject1 instanceof TextView)) || (paramawqt == null) || (paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null));
        localTextView = (TextView)localObject1;
        if (paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard != null) {
          break;
        }
        localTextView.setVisibility(8);
      } while (localView == null);
      localView.setVisibility(8);
      return;
      localObject4 = paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard.getRichStatus();
      if ((ProfileActivity.AllInOne.g(paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) && (localObject4 != null)) {
        break;
      }
      if (paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
      {
        localTextView.setCompoundDrawablesWithIntrinsicBounds(2130845448, 0, 0, 0);
        localTextView.setText(alud.a(2131708888));
        localTextView.setVisibility(0);
        localTextView.setTag(new awor(3, ""));
        localTextView.setOnClickListener(paramawqt.jdField_a_of_type_AndroidViewView$OnClickListener);
        localTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691275));
        a(localView, true);
        return;
      }
      localTextView.setVisibility(8);
    } while (localView == null);
    localView.setVisibility(8);
    return;
    SpannableString localSpannableString = new SpannableString(((RichStatus)localObject4).toSpannableStringWithTopic("", -8947849, -2039584, this));
    Object localObject5;
    label464:
    boolean bool2;
    boolean bool1;
    if (!TextUtils.isEmpty(((RichStatus)localObject4).actionText))
    {
      localObject5 = new SpannableStringBuilder(localSpannableString);
      ((SpannableStringBuilder)localObject5).insert(0, "[S] ");
      localObject1 = (ayec)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(15);
      if (localObject1 != null)
      {
        localObject1 = ((ayec)localObject1).a(((RichStatus)localObject4).actionId, 200);
        localObject1 = new bevq(getResources(), (Bitmap)localObject1, false, false);
        int i = (int)(localTextView.getTextSize() * 1.1F + 0.5F);
        ((BitmapDrawable)localObject1).setBounds(0, 0, i, i);
        localObject1 = new beri((Drawable)localObject1, 0);
        ((beri)localObject1).a(-0.1F);
        ((SpannableStringBuilder)localObject5).setSpan(localObject1, 0, "[S]".length(), 17);
        this.f = i;
        if (paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
          localTextView.setCompoundDrawablesWithIntrinsicBounds(2130845448, 0, 0, 0);
        }
        localTextView.setText(new bamp((CharSequence)localObject5, 1, 14));
        localTextView.setMovementMethod(ayfi.a());
        localTextView.setVisibility(0);
        if (localSpannableString.length() > 0)
        {
          if ((!awrn.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (((RichStatus)localObject4).topics != null) && (((RichStatus)localObject4).topics.size() > 0)) {
            localTextView.post(new ProfileHeaderView.5(this, (RichStatus)localObject4, localTextView));
          }
          awrn.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RichStatus)localObject4);
          bool2 = awrn.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (localView != null)
          {
            if (paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
              break label1082;
            }
            bool1 = true;
            label565:
            localObject4 = (TextView)localView.findViewById(2131378847);
            localObject5 = (ImageView)localView.findViewById(2131368742);
            localObject1 = new oidb_0xd9f.RspBody();
            if ((paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard.vLongNickTopicInfo == null)) {
              break label1143;
            }
          }
        }
      }
    }
    try
    {
      ((oidb_0xd9f.RspBody)localObject1).mergeFrom(paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard.vLongNickTopicInfo);
      localObject1 = (oidb_0xd9f.LongNickItem)((oidb_0xd9f.RspBody)localObject1).longnick_item.get();
      if (localObject1 == null) {
        break label1087;
      }
      localObject1 = ((oidb_0xd9f.LongNickItem)localObject1).rpt_topic_item.get();
      label658:
      if ((!bool2) && (!awrn.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, awrn.a().a((List)localObject1)))) {
        break label1133;
      }
      if ((localObject1 == null) || (((List)localObject1).size() <= 0) || (awrn.a().a((List)localObject1) <= 0)) {
        break label1093;
      }
      localView.setTag(new awor(97, awrn.a().a((List)localObject1)));
      localView.setOnClickListener(paramawqt.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((TextView)localObject4).setText(alud.a(2131708887) + awrn.a().a((List)localObject1) + alud.a(2131708885));
      ((ImageView)localObject5).setOnClickListener(new awvi(this, localView));
      localView.setVisibility(0);
      azqs.b(null, "dc00898", "", "", "0X800A4D4", "0X800A4D4", 0, 0, "1", "0", "", "");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        label839:
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.SummaryCard", 2, localException.toString());
        }
        label914:
        label1082:
        label1087:
        label1093:
        a(localView, bool1);
        continue;
        label1133:
        a(localView, bool1);
      }
    }
    if ((paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) || (ProfileActivity.AllInOne.b(paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))) {
      localTextView.setOnClickListener(paramawqt.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    if ((ProfileActivity.AllInOne.b(paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) && (paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0)) {
      localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130845449, 0);
    }
    if (!TextUtils.isEmpty(localSpannableString))
    {
      localObject1 = localSpannableString.toString();
      localTextView.setTag(new awor(3, localObject1));
      localTextView.setOnLongClickListener(paramawqt.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      localObject1 = new StringBuilder().append(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691275)).append(":");
      if (TextUtils.isEmpty(localSpannableString)) {
        break label1161;
      }
    }
    label1161:
    for (paramawqt = localSpannableString.toString();; paramawqt = "")
    {
      for (;;)
      {
        localTextView.setContentDescription(paramawqt);
        return;
        try
        {
          localObject1 = BitmapFactory.decodeResource(getResources(), 2130849040);
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          localOutOfMemoryError.printStackTrace();
          Object localObject2 = null;
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          localObject3 = null;
        }
      }
      break;
      this.f = 0;
      localTextView.setText(new bamp(a(paramawqt, localSpannableString, localTextView), 1, 14));
      localTextView.setMovementMethod(ayfi.a());
      localTextView.setVisibility(0);
      break label464;
      bool1 = false;
      break label565;
      Object localObject3 = null;
      break label658;
      a(localView, bool1);
      break label839;
      label1143:
      a(localView, bool1);
      break label839;
      String str = "";
      break label914;
    }
  }
  
  public void i(awqt paramawqt)
  {
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_details");
    if ((localView instanceof TextView)) {
      b((TextView)localView, paramawqt);
    }
    while (!(localView instanceof LinearLayout)) {
      return;
    }
    a((LinearLayout)localView, paramawqt);
  }
  
  public void j(awqt paramawqt)
  {
    this.jdField_d_of_type_Int &= 0xFFFFFFFD;
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips_set_card");
    if (localView == null) {
      localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131561825, null);
    }
    for (;;)
    {
      if ((localView == null) || (paramawqt == null) || (paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard == null))
      {
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        d();
        return;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tips_set_card", localView);
      if ((paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
      {
        long l1 = paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId;
        long l2 = paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId;
        int i = paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard.templateRet;
        Object localObject1 = paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard.getBgTypeArray();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "updateSetCardBar bgtype = " + localObject1);
        }
        localObject1 = getResources();
        TextView localTextView = (TextView)localView.findViewById(2131367419);
        ImageView localImageView = (ImageView)localView.findViewById(2131367405);
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
        boolean bool = false;
        if (localObject2 != null) {
          bool = ((SharedPreferences)localObject2).getBoolean("svip_profile_use_guide_shown_flag", false);
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "isShowTips" + bool + ",templateRet=" + i + ",myTemplateId=" + l1);
        }
        if (((101107 == i) || (101108 == i)) && (!bool) && (localObject2 != null))
        {
          ((SharedPreferences)localObject2).edit().putBoolean("svip_profile_use_guide_shown_flag", true).commit();
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
          if (101107 != i) {
            break label460;
          }
        }
        label460:
        for (localObject1 = ((Resources)localObject1).getString(2131695646);; localObject1 = ((Resources)localObject1).getString(2131720522))
        {
          localObject1 = ((BaseActivity)localObject2).getString(2131719129, new Object[] { localObject1 });
          localTextView.setText((CharSequence)localObject1);
          localImageView.setContentDescription((CharSequence)localObject1);
          localView.setTag(new awor(24, Integer.valueOf(i)));
          localView.setOnClickListener(paramawqt.jdField_a_of_type_AndroidViewView$OnClickListener);
          this.jdField_d_of_type_Int |= 0x2;
          this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
          d();
          return;
        }
      }
      ThreadManager.post(new ProfileHeaderView.UpdateProfileSetCardTask(this), 5, null, true);
      return;
    }
  }
  
  public void k(awqt paramawqt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "ProfileHeaderView updateTips");
    }
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips");
    LinearLayout localLinearLayout;
    if ((localObject instanceof LinearLayout))
    {
      localLinearLayout = (LinearLayout)localObject;
      if (((this.jdField_d_of_type_Int & 0x1) == 0) || ((this.jdField_d_of_type_Int & 0x2) == 0)) {
        break label241;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "ProfileHeaderView updateTips netvoice and setcard");
      }
      paramawqt = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips_net_voice");
      localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips_set_card");
      if ((paramawqt != null) && (localObject != null))
      {
        if (localLinearLayout.getChildCount() != 0) {
          break label171;
        }
        localLinearLayout.addView(paramawqt);
        localLinearLayout.setVisibility(0);
        if (this.jdField_a_of_type_Int < 4)
        {
          this.jdField_a_of_type_Int += 1;
          paramawqt = this.jdField_a_of_type_Bhsl.obtainMessage(jdField_b_of_type_Int);
          this.jdField_a_of_type_Bhsl.sendMessageDelayed(paramawqt, 4000L);
        }
      }
    }
    label171:
    label241:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              View localView;
              do
              {
                return;
                localView = localLinearLayout.getChildAt(0);
              } while (localView == null);
              if (localView.getId() == 2131372325) {
                paramawqt = (awqt)localObject;
              }
              for (;;)
              {
                localObject = AnimationUtils.loadAnimation(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130772263);
                ((Animation)localObject).setFillAfter(true);
                ((Animation)localObject).setAnimationListener(new awvj(this, localLinearLayout, paramawqt));
                localLinearLayout.setVisibility(0);
                localView.startAnimation((Animation)localObject);
                return;
              }
              if ((this.jdField_d_of_type_Int & 0x1) == 0) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "ProfileHeaderView updateTips netvoice");
              }
              paramawqt = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips_net_voice");
            } while (paramawqt == null);
            localLinearLayout.removeAllViews();
            localLinearLayout.addView(paramawqt);
            localLinearLayout.setVisibility(0);
            return;
            if ((this.jdField_d_of_type_Int & 0x2) == 0) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "ProfileHeaderView updateTips setcard");
            }
            localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips_set_card");
          } while (localObject == null);
          localLinearLayout.removeAllViews();
          localLinearLayout.addView((View)localObject);
          localLinearLayout.setVisibility(0);
        } while (!paramawqt.b);
        VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "group_card", "guide_show", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        return;
      } while ((paramawqt == null) || (paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId != awra.h));
      localLinearLayout.setVisibility(8);
      paramawqt = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_space_view");
    } while (paramawqt == null);
    localObject = (RelativeLayout.LayoutParams)paramawqt.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height += bddf.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 18);
    paramawqt.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramawqt.setFocusable(true);
    paramawqt.setFocusableInTouchMode(true);
  }
  
  public void l(awqt paramawqt) {}
  
  public void onClick(View paramView) {}
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = getResources().getDisplayMetrics();
    this.jdField_a_of_type_Float = paramConfiguration.density;
    this.jdField_b_of_type_Float = Math.min(paramConfiguration.widthPixels, paramConfiguration.heightPixels);
    this.jdField_c_of_type_Float = Math.max(paramConfiguration.widthPixels, paramConfiguration.heightPixels);
  }
  
  public void setShoppingBgBlur(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileHeaderView
 * JD-Core Version:    0.7.0.1
 */