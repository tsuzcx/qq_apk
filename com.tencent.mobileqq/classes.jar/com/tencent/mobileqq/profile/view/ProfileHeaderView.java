package com.tencent.mobileqq.profile.view;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import ajfe;
import ajjy;
import amko;
import amkp;
import amkq;
import amkr;
import amwq;
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
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aroh;
import atuw;
import atwx;
import atxe;
import atxq;
import atxr;
import atyt;
import atzz;
import auaa;
import auab;
import auac;
import auad;
import auae;
import auaf;
import auag;
import auah;
import avev;
import avfz;
import avga;
import avgb;
import avgf;
import awmc;
import awnu;
import awqx;
import axkd;
import azub;
import azuc;
import azwp;
import azyk;
import azzz;
import babh;
import bbgm;
import bbkk;
import bboi;
import beez;
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
import com.tencent.util.Pair;
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
  implements View.OnClickListener, avga, bbgm
{
  public static String a;
  public static int b;
  public static int c;
  protected float a;
  public int a;
  public long a;
  protected ajfe a;
  public amwq a;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new atzz(this);
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new auad(this);
  public atwx a;
  public beez a;
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
  
  public ProfileHeaderView(BaseActivity paramBaseActivity, atwx paramatwx)
  {
    super(paramBaseActivity);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Beez = new beez(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_Ajfe = new auah(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    this.jdField_a_of_type_Atwx = paramatwx;
    paramBaseActivity = getResources().getDisplayMetrics();
    this.jdField_a_of_type_Float = paramBaseActivity.density;
    this.jdField_b_of_type_Float = Math.min(paramBaseActivity.widthPixels, paramBaseActivity.heightPixels);
    this.jdField_c_of_type_Float = Math.max(paramBaseActivity.widthPixels, paramBaseActivity.heightPixels);
    this.jdField_d_of_type_Float = (this.jdField_b_of_type_Float - awmc.a(127.0F));
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
      if ((paramImageView instanceof azwp)) {
        ((azwp)paramImageView).a(false);
      }
    }
  }
  
  private void d()
  {
    if ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_Beez != null) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      Message localMessage = this.jdField_a_of_type_Beez.obtainMessage(jdField_b_of_type_Int);
      if (localMessage != null) {
        this.jdField_a_of_type_Beez.sendMessage(localMessage);
      }
    }
  }
  
  private void d(atwx paramatwx)
  {
    int j = 2;
    if (paramatwx != null)
    {
      azyk.a(paramatwx, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      int i = j;
      if (paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null)
      {
        i = j;
        if (paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
          i = 1;
        }
      }
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009999", "0X8009999", i, 0, "", "", "", "");
    }
  }
  
  public int a()
  {
    return 0;
  }
  
  public SpannableStringBuilder a(atwx paramatwx, SpannableString paramSpannableString, TextView paramTextView)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramSpannableString);
    if (paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      localSpannableStringBuilder.insert(0, "[S] ");
      paramatwx = null;
    }
    try
    {
      paramSpannableString = BitmapFactory.decodeResource(getResources(), 2130844928);
      paramatwx = paramSpannableString;
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
    paramatwx = new bboi(getResources(), paramatwx, false, false);
    i = (int)(paramTextView.getTextSize() + 0.5F);
    paramatwx.setBounds(0, 0, i, i);
    paramatwx = new bbkk(paramatwx, 0);
    paramatwx.a(-0.1F);
    localSpannableStringBuilder.setSpan(paramatwx, 0, "[S]".length(), 17);
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
    if (!atxr.a().c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      paramView.setVisibility(8);
      return;
    }
    Object localObject = amkr.a();
    if ((localObject == null) || (((amko)localObject).a()))
    {
      paramView.setVisibility(8);
      return;
    }
    paramView.setVisibility(0);
    TextView localTextView = (TextView)paramView.findViewById(2131312396);
    ImageView localImageView = (ImageView)paramView.findViewById(2131302908);
    ArrayList localArrayList = ((amko)localObject).a().a;
    localTextView.setText(atxr.a().a((amko)localObject));
    int i = 0;
    int j;
    while (i < ((amko)localObject).a().a.size()) {
      if (TextUtils.isEmpty(((amkq)localArrayList.get(i)).jdField_a_of_type_JavaLangString))
      {
        i += 1;
      }
      else
      {
        j = ((amkq)localArrayList.get(i)).jdField_a_of_type_Int;
        localObject = ((amkq)localArrayList.get(i)).jdField_a_of_type_JavaLangString;
      }
    }
    for (i = j;; i = -1)
    {
      if (paramBoolean) {
        paramView.setOnClickListener(new auab(this, (String)localObject, i, paramView));
      }
      localImageView.setOnClickListener(new auac(this, paramView));
      awqx.b(null, "dc00898", "", "", "0X800A4D4", "0X800A4D4", 0, 0, "2", "0", "", "");
      return;
      localObject = "";
    }
  }
  
  public void a(TextView paramTextView, atwx paramatwx)
  {
    Object localObject2 = null;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "makeAccountDetailInfo");
    }
    if (paramTextView == null) {
      return;
    }
    if (paramatwx == null) {}
    for (Card localCard = null; (paramatwx == null) || (localCard == null) || (ProfileActivity.AllInOne.j(paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (ProfileActivity.AllInOne.k(paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)); localCard = paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard)
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_uin_info");
      paramTextView.setVisibility(8);
      return;
    }
    paramTextView.setVisibility(0);
    Object localObject1;
    boolean bool;
    String str1;
    if (paramatwx.b)
    {
      localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(paramatwx.jdField_a_of_type_JavaLangString, localCard.uin);
      if ((localObject1 != null) && (TextUtils.isEmpty(((TroopMemberInfo)localObject1).troopnick)) && (!TextUtils.isEmpty(localCard.strReMark))) {
        localObject2 = localCard.strNick;
      }
      for (;;)
      {
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = babh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localCard.uin, false);
        }
        if (!TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramatwx.jdField_a_of_type_JavaLangString)) {
          break;
        }
        localObject2 = localObject1;
        paramTextView.setVisibility(0);
        paramTextView.setSingleLine(true);
        paramTextView.setText((CharSequence)localObject1);
        paramTextView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
        paramTextView.setOnClickListener(new auag(this, paramatwx));
        azyk.a(paramTextView, localCard.uin, (String)localObject2, paramatwx.jdField_a_of_type_AndroidViewView$OnLongClickListener);
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
    if ((paramatwx.jdField_a_of_type_ArrayOfJavaLangString != null) && (!TextUtils.isEmpty(paramatwx.jdField_a_of_type_ArrayOfJavaLangString[5])) && (!TextUtils.equals(paramatwx.jdField_a_of_type_ArrayOfJavaLangString[5], localCard.strNick))) {}
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
  
  public void a(atwx paramatwx)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "ProfileHeaderView onInit");
    }
    c(paramatwx);
    if (paramatwx.jdField_a_of_type_Atxe != null) {
      j(paramatwx);
    }
    View localView;
    if ((paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) || (paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
    {
      paramatwx = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("VipPersonalLike", 0);
      if (paramatwx.getInt("ProfilePersonalLikeMasterHasShownTip_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), -1) != 1)
      {
        localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_personal_like_tip");
        if (!awnu.b()) {
          break label163;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "ProfileHeaderView onInit, SimpleUIMode is open now");
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajfe);
      return;
      label163:
      if (localView != null)
      {
        localView.setVisibility(0);
        paramatwx.edit().putInt("ProfilePersonalLikeMasterHasShownTip_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1).apply();
      }
    }
  }
  
  public void a(atwx paramatwx, long paramLong, boolean paramBoolean)
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
      if ((paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt == 0)) {
        ((VoteView)localObject).a();
      }
      ((VoteView)localObject).a(false, true, (int)l, 0, null, paramBoolean);
      ((VoteView)localObject).setOnClickListener(paramatwx.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((VoteView)localObject).setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131625584), new Object[] { String.valueOf(l) }));
    }
  }
  
  public void a(atwx paramatwx, String paramString)
  {
    paramString = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_uin_info");
    if ((paramString instanceof TextView)) {
      a((TextView)paramString, paramatwx);
    }
  }
  
  public void a(atwx paramatwx, HashMap<String, String> paramHashMap)
  {
    paramatwx = paramatwx.jdField_a_of_type_Atxe.a;
    String str1 = getClass().getName();
    if ((paramatwx == null) || (paramatwx.size() <= 0)) {
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
        localObject2 = paramatwx.get(str2);
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
  
  public abstract void a(atwx paramatwx, boolean paramBoolean);
  
  public void a(avfz paramavfz, View paramView)
  {
    paramavfz = paramavfz.a();
    if ((paramavfz instanceof Pair))
    {
      paramavfz = (Pair)paramavfz;
      avgf.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, avgf.a(((Integer)paramavfz.first).intValue(), (String)paramavfz.second), -1);
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
      str = azyk.a(paramAllInOne);
      if ((str != null) && (str.length() > 0))
      {
        localObject = (aroh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
        if (localObject == null) {
          break label264;
        }
      }
    }
    label264:
    for (Object localObject = ((aroh)localObject).c(str);; localObject = null)
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
      localObject = azyk.a(paramAllInOne);
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
  
  public void a(String paramString, int paramInt, List<atxq> paramList) {}
  
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
  
  protected boolean a(atwx paramatwx)
  {
    boolean bool4 = false;
    boolean bool2;
    boolean bool5;
    boolean bool6;
    boolean bool1;
    if ((paramatwx != null) && (paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard != null))
    {
      bool2 = true;
      bool5 = TextUtils.equals(paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      bool6 = ProfileActivity.AllInOne.b(paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      if ((bool5) || (bool6)) {
        break label178;
      }
      if ((!bool2) || (!paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard.strangerVoteOpen)) {
        break label173;
      }
      bool1 = true;
    }
    label70:
    for (boolean bool3 = bool1 & bool2;; bool3 = bool2)
    {
      if (QLog.isColorLevel())
      {
        String str = paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
        if (bool2) {
          bool4 = paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard.strangerVoteOpen;
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
  
  public void b(TextView paramTextView, atwx paramatwx)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "makeAccountDetailInfo");
    }
    if ((paramatwx == null) || (paramTextView == null)) {
      return;
    }
    List localList = azyk.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard);
    boolean bool = localList.isEmpty();
    int i;
    label66:
    StringBuilder localStringBuilder;
    int n;
    Object localObject2;
    Object localObject3;
    int m;
    int j;
    int k;
    if ((paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0))
    {
      i = 1;
      if ((bool) && (i != 0)) {
        localList.add(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131633545));
      }
      if (localList.isEmpty()) {
        break label562;
      }
      localStringBuilder = new StringBuilder(200);
      n = localList.size();
      localObject2 = azyk.a(localList, 0, n, "  ", localStringBuilder);
      localObject3 = paramTextView.getPaint();
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = new TextPaint(1);
        ((TextPaint)localObject1).density = this.jdField_a_of_type_Float;
      }
      if (((TextPaint)localObject1).measureText((String)localObject2) <= this.jdField_d_of_type_Float) {
        break label569;
      }
      localObject2 = new StringBuilder(50);
      i = 0;
      m = 1;
      for (;;)
      {
        if (((TextPaint)localObject1).measureText(azyk.a(localList, i, m, "  ", localStringBuilder)) < this.jdField_d_of_type_Float)
        {
          j = m + 1;
          k = i;
          label239:
          m = j;
          i = k;
          if (k >= 0)
          {
            m = j;
            i = k;
            if (j <= n)
            {
              m = j;
              i = k;
              if (k < j) {
                continue;
              }
              i = k;
              m = j;
            }
          }
          label286:
          if ((m > 1) && (i < m - 1) && (m - 1 == n))
          {
            localObject1 = azyk.a(localList, i, m - 1, "  ", localStringBuilder);
            if (((StringBuilder)localObject2).length() > 0) {
              ((StringBuilder)localObject2).append("\n");
            }
            ((StringBuilder)localObject2).append((String)localObject1);
          }
        }
      }
    }
    label562:
    label569:
    for (Object localObject1 = ((StringBuilder)localObject2).toString();; localObject1 = localObject2)
    {
      localObject2 = (ViewGroup.MarginLayoutParams)((View)paramTextView.getParent()).getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = 0;
      ((View)paramTextView.getParent()).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      paramTextView.setVisibility(0);
      paramTextView.setSingleLine(true);
      paramTextView.setText((CharSequence)localObject1);
      paramTextView.setEllipsize(TextUtils.TruncateAt.END);
      paramTextView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      paramTextView.setOnClickListener(new auaa(this, paramatwx));
      if (bool) {
        break;
      }
      azyk.a(paramTextView, null, null, paramatwx.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      return;
      i = 0;
      break label66;
      if (m - i == 1)
      {
        localObject1 = azyk.a(localList, i, n, "  ", localStringBuilder);
        if (((StringBuilder)localObject2).length() > 0) {
          ((StringBuilder)localObject2).append("\n");
        }
        ((StringBuilder)localObject2).append((String)localObject1);
        break label286;
      }
      localObject3 = azyk.a(localList, i, m - 1, "  ", localStringBuilder);
      if (((StringBuilder)localObject2).length() > 0) {
        ((StringBuilder)localObject2).append("\n");
      }
      ((StringBuilder)localObject2).append((String)localObject3);
      k = m - 1;
      j = m;
      break label239;
      paramTextView.setVisibility(8);
      return;
    }
  }
  
  public void b(atwx paramatwx)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_sex_age_area");
    String str;
    if ((localObject instanceof TextView))
    {
      localObject = (TextView)localObject;
      str = azyk.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramatwx);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea strInfo=" + azzz.b(str));
      }
      if (paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33) {
        break label126;
      }
      paramatwx = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131633544);
      if (((TextView)localObject).getVisibility() != 0) {
        ((TextView)localObject).setVisibility(0);
      }
      ((TextView)localObject).setPadding(0, 10, 0, 0);
      ((TextView)localObject).setText(paramatwx);
      ((TextView)localObject).setContentDescription(paramatwx);
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
        ((TextView)localObject).setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131625569) + ":" + str);
        ((TextView)localObject).setClickable(true);
        return;
      }
    } while (((TextView)localObject).getVisibility() == 8);
    ((TextView)localObject).setVisibility(8);
  }
  
  public void b(atwx paramatwx, boolean paramBoolean)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_avatar_pendant");
    if ((localObject instanceof ImageView))
    {
      localObject = (ImageView)localObject;
      if (!ProfileActivity.AllInOne.g(paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        ((ImageView)localObject).setVisibility(4);
        this.jdField_a_of_type_Long = 0L;
      }
    }
    else
    {
      return;
    }
    ThreadManager.post(new ProfileHeaderView.8(this, paramatwx, paramBoolean), 8, null, true);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajfe);
    }
    if (this.jdField_a_of_type_Beez != null) {
      this.jdField_a_of_type_Beez.removeCallbacksAndMessages(null);
    }
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qzonecover");
    if ((localView instanceof QzonePhotoView)) {
      ((QzonePhotoView)localView).a();
    }
  }
  
  public void c(int paramInt) {}
  
  public void c(atwx paramatwx)
  {
    this.jdField_d_of_type_Int &= 0xFFFFFFFE;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips_net_voice");
    paramatwx = localView;
    if (localView == null) {
      paramatwx = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131496042, null);
    }
    if (paramatwx != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      d();
    }
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tips_net_voice", paramatwx);
  }
  
  public void e(atwx paramatwx)
  {
    if ((paramatwx.b) && (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramatwx.jdField_a_of_type_JavaLangString))) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    } while (!(localObject1 instanceof VoteView));
    VoteView localVoteView = (VoteView)localObject1;
    boolean bool1 = a(paramatwx);
    boolean bool2 = TextUtils.equals(paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (bool1)
    {
      if (localVoteView.getVisibility() != 0) {
        localVoteView.setVisibility(0);
      }
      Object localObject2;
      int j;
      int i;
      if ((paramatwx == null) || (paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard == null))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131625657);
        localObject2 = null;
        j = 0;
        i = 0;
        bool1 = false;
        localVoteView.a(bool2, bool1, i, j, this.jdField_a_of_type_Amwq, false);
        localVoteView.setTag(localObject2);
        if (paramatwx == null) {
          break label431;
        }
        localVoteView.setOnClickListener(paramatwx.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      for (;;)
      {
        localVoteView.setContentDescription((CharSequence)localObject1);
        return;
        if (this.jdField_a_of_type_Amwq == null) {
          this.jdField_a_of_type_Amwq = new amwq(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 1);
        }
        j = (int)paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard.lVoteCount;
        i = paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard.iVoteIncrement;
        this.jdField_a_of_type_Amwq.a = paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard.getLastPraiseInfoList();
        if (i <= this.jdField_a_of_type_Amwq.a.size()) {
          this.jdField_a_of_type_Amwq.a = this.jdField_a_of_type_Amwq.a.subList(0, i);
        }
        this.jdField_a_of_type_Amwq.a = atyt.a(this.jdField_a_of_type_Amwq.a);
        if (1 == paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard.bVoted) {}
        for (bool1 = true;; bool1 = false)
        {
          if (!bool2) {
            break label364;
          }
          localObject2 = new atuw(10, paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard);
          localObject1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131625655), new Object[] { String.valueOf(j) });
          k = i;
          i = j;
          j = k;
          break;
        }
        label364:
        localObject2 = new atuw(10, paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard);
        localObject1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131625572), new Object[] { String.valueOf(j) });
        if (paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt == 0) {
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
  
  public void f(atwx paramatwx)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_profile_nick_name");
    ((View)localObject).setBackgroundResource(2130844817);
    if ((localObject instanceof TextView))
    {
      localTextView = (TextView)localObject;
      localAllInOne = paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
      str = paramatwx.jdField_a_of_type_Azuc.a.jdField_a_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.FrdProfileCard", 2, "updateHead titleName = " + azzz.b(str));
      }
      if (str != null)
      {
        localObject = str;
        if (str.length() != 0) {}
      }
      else
      {
        if (!ProfileActivity.AllInOne.a(localAllInOne)) {
          break label219;
        }
        localObject = String.valueOf(localAllInOne.jdField_a_of_type_JavaLangString);
      }
      localTextView.setText((CharSequence)localObject);
      str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131625590) + ":";
      localTextView.setContentDescription(str + (String)localObject);
      localTextView.setTag(new atuw(88, localTextView.getText().toString()));
      localTextView.setOnClickListener(paramatwx.jdField_a_of_type_AndroidViewView$OnClickListener);
      localTextView.setOnLongClickListener(paramatwx.jdField_a_of_type_AndroidViewView$OnLongClickListener);
    }
    label219:
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
    ((ProfileNameView)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramatwx);
  }
  
  @TargetApi(16)
  public void g(atwx paramatwx)
  {
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tag_jueban");
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    if (((localView instanceof ImageView)) && (localObject != null) && (paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (a(paramatwx)) && (azyk.a(paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard.getBgTypeArray())))
    {
      localObject = "1";
      if (paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
        localObject = "0";
      }
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "card_mall", "0X8007A47", 0, 0, (String)localObject, "", "", "");
      localView.setVisibility(0);
      localView.setTag(new atuw(34, null));
      localView.setOnClickListener(paramatwx.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
  }
  
  public void h(atwx paramatwx)
  {
    if ((paramatwx != null) && (paramatwx.b) && (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramatwx.jdField_a_of_type_JavaLangString))) {}
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
        } while ((!(localObject1 instanceof TextView)) || (paramatwx == null) || (paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null));
        localTextView = (TextView)localObject1;
        if (paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard != null) {
          break;
        }
        localTextView.setVisibility(8);
      } while (localView == null);
      localView.setVisibility(8);
      return;
      localObject4 = paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard.getRichStatus();
      if ((ProfileActivity.AllInOne.g(paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) && (localObject4 != null)) {
        break;
      }
      if (paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
      {
        localTextView.setCompoundDrawablesWithIntrinsicBounds(2130844928, 0, 0, 0);
        localTextView.setText(ajjy.a(2131642708));
        localTextView.setVisibility(0);
        localTextView.setTag(new atuw(3, ""));
        localTextView.setOnClickListener(paramatwx.jdField_a_of_type_AndroidViewView$OnClickListener);
        localTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131625646));
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
      localObject1 = (avev)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(15);
      if (localObject1 != null)
      {
        localObject1 = ((avev)localObject1).a(((RichStatus)localObject4).actionId, 200);
        localObject1 = new bboi(getResources(), (Bitmap)localObject1, false, false);
        int i = (int)(localTextView.getTextSize() * 1.1F + 0.5F);
        ((BitmapDrawable)localObject1).setBounds(0, 0, i, i);
        localObject1 = new bbkk((Drawable)localObject1, 0);
        ((bbkk)localObject1).a(-0.1F);
        ((SpannableStringBuilder)localObject5).setSpan(localObject1, 0, "[S]".length(), 17);
        this.f = i;
        if (paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
          localTextView.setCompoundDrawablesWithIntrinsicBounds(2130844928, 0, 0, 0);
        }
        localTextView.setText(new axkd((CharSequence)localObject5, 1, 20));
        localTextView.setMovementMethod(avgb.a());
        localTextView.setVisibility(0);
        if (localSpannableString.length() > 0)
        {
          if ((!atxr.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (((RichStatus)localObject4).topics != null) && (((RichStatus)localObject4).topics.size() > 0)) {
            localTextView.post(new ProfileHeaderView.5(this, (RichStatus)localObject4, localTextView));
          }
          atxr.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RichStatus)localObject4);
          bool2 = atxr.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (localView != null)
          {
            if (paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
              break label1082;
            }
            bool1 = true;
            label565:
            localObject4 = (TextView)localView.findViewById(2131312396);
            localObject5 = (ImageView)localView.findViewById(2131302908);
            localObject1 = new oidb_0xd9f.RspBody();
            if ((paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard.vLongNickTopicInfo == null)) {
              break label1143;
            }
          }
        }
      }
    }
    try
    {
      ((oidb_0xd9f.RspBody)localObject1).mergeFrom(paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard.vLongNickTopicInfo);
      localObject1 = (oidb_0xd9f.LongNickItem)((oidb_0xd9f.RspBody)localObject1).longnick_item.get();
      if (localObject1 == null) {
        break label1087;
      }
      localObject1 = ((oidb_0xd9f.LongNickItem)localObject1).rpt_topic_item.get();
      label658:
      if ((!bool2) && (!atxr.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, atxr.a().a((List)localObject1)))) {
        break label1133;
      }
      if ((localObject1 == null) || (((List)localObject1).size() <= 0) || (atxr.a().a((List)localObject1) <= 0)) {
        break label1093;
      }
      localView.setTag(new atuw(97, atxr.a().a((List)localObject1)));
      localView.setOnClickListener(paramatwx.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((TextView)localObject4).setText(ajjy.a(2131642707) + atxr.a().a((List)localObject1) + ajjy.a(2131642705));
      ((ImageView)localObject5).setOnClickListener(new auae(this, localView));
      localView.setVisibility(0);
      awqx.b(null, "dc00898", "", "", "0X800A4D4", "0X800A4D4", 0, 0, "1", "0", "", "");
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
    if ((paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) || (ProfileActivity.AllInOne.b(paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))) {
      localTextView.setOnClickListener(paramatwx.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    if ((ProfileActivity.AllInOne.b(paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) && (paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0)) {
      localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130844929, 0);
    }
    if (!TextUtils.isEmpty(localSpannableString))
    {
      localObject1 = localSpannableString.toString();
      localTextView.setTag(new atuw(3, localObject1));
      localTextView.setOnLongClickListener(paramatwx.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      localObject1 = new StringBuilder().append(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131625646)).append(":");
      if (TextUtils.isEmpty(localSpannableString)) {
        break label1161;
      }
    }
    label1161:
    for (paramatwx = localSpannableString.toString();; paramatwx = "")
    {
      for (;;)
      {
        localTextView.setContentDescription(paramatwx);
        return;
        try
        {
          localObject1 = BitmapFactory.decodeResource(getResources(), 2130848301);
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
      localTextView.setText(new axkd(a(paramatwx, localSpannableString, localTextView), 1, 20));
      localTextView.setMovementMethod(avgb.a());
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
  
  public void i(atwx paramatwx)
  {
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_details");
    if ((localView instanceof TextView)) {
      b((TextView)localView, paramatwx);
    }
  }
  
  public void j(atwx paramatwx)
  {
    this.jdField_d_of_type_Int &= 0xFFFFFFFD;
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips_set_card");
    if (localView == null) {
      localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131496025, null);
    }
    for (;;)
    {
      if ((localView == null) || (paramatwx == null) || (paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard == null))
      {
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        d();
        return;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tips_set_card", localView);
      if ((paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
      {
        long l1 = paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId;
        long l2 = paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId;
        int i = paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard.templateRet;
        Object localObject1 = paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard.getBgTypeArray();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "updateSetCardBar bgtype = " + localObject1);
        }
        localObject1 = getResources();
        TextView localTextView = (TextView)localView.findViewById(2131301667);
        ImageView localImageView = (ImageView)localView.findViewById(2131301653);
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
        for (localObject1 = ((Resources)localObject1).getString(2131629804);; localObject1 = ((Resources)localObject1).getString(2131654075))
        {
          localObject1 = ((BaseActivity)localObject2).getString(2131652808, new Object[] { localObject1 });
          localTextView.setText((CharSequence)localObject1);
          localImageView.setContentDescription((CharSequence)localObject1);
          localView.setTag(new atuw(24, Integer.valueOf(i)));
          localView.setOnClickListener(paramatwx.jdField_a_of_type_AndroidViewView$OnClickListener);
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
  
  public void k(atwx paramatwx)
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
      paramatwx = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips_net_voice");
      localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips_set_card");
      if ((paramatwx != null) && (localObject != null))
      {
        if (localLinearLayout.getChildCount() != 0) {
          break label171;
        }
        localLinearLayout.addView(paramatwx);
        localLinearLayout.setVisibility(0);
        if (this.jdField_a_of_type_Int < 4)
        {
          this.jdField_a_of_type_Int += 1;
          paramatwx = this.jdField_a_of_type_Beez.obtainMessage(jdField_b_of_type_Int);
          this.jdField_a_of_type_Beez.sendMessageDelayed(paramatwx, 4000L);
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
              if (localView.getId() == 2131306291) {
                paramatwx = (atwx)localObject;
              }
              for (;;)
              {
                localObject = AnimationUtils.loadAnimation(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130772246);
                ((Animation)localObject).setFillAfter(true);
                ((Animation)localObject).setAnimationListener(new auaf(this, localLinearLayout, paramatwx));
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
              paramatwx = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips_net_voice");
            } while (paramatwx == null);
            localLinearLayout.removeAllViews();
            localLinearLayout.addView(paramatwx);
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
        } while (!paramatwx.b);
        VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "group_card", "guide_show", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        return;
      } while ((paramatwx == null) || (paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId != atxe.h));
      localLinearLayout.setVisibility(8);
      paramatwx = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_space_view");
    } while (paramatwx == null);
    localObject = (RelativeLayout.LayoutParams)paramatwx.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height += azyk.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 18);
    paramatwx.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramatwx.setFocusable(true);
    paramatwx.setFocusableInTouchMode(true);
  }
  
  public void l(atwx paramatwx) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileHeaderView
 * JD-Core Version:    0.7.0.1
 */