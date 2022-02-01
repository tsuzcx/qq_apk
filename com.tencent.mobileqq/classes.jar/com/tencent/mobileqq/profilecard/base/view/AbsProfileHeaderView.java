package com.tencent.mobileqq.profilecard.base.view;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import amtj;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
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
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqje;
import aqjf;
import aqjg;
import aqjh;
import aqvb;
import aykg;
import aymg;
import aymz;
import ayol;
import aytm;
import ayts;
import aytt;
import aytu;
import aytv;
import aytw;
import aytx;
import ayty;
import aytz;
import baoy;
import baqc;
import baqd;
import baqe;
import baqi;
import bcef;
import bfms;
import bfmt;
import bfpx;
import bfrj;
import bftf;
import bfvo;
import bgff;
import bhfp;
import bhji;
import bjmp;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.profile.view.QzonePhotoView;
import com.tencent.mobileqq.profile.view.VipPhotoViewForSimple;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView.MotionEventInterceptor;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mum;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f.LongNickItem;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f.RspBody;

public abstract class AbsProfileHeaderView
  extends RelativeLayout
  implements baqd, XListView.MotionEventInterceptor
{
  public static String a;
  protected float a;
  public int a;
  public long a;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new ayts(this);
  public View.OnClickListener a;
  protected aqvb a;
  public aymg a;
  protected bjmp a;
  public BaseActivity a;
  public BusinessObserver a;
  public QQAppInterface a;
  public HashMap<String, View> a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_a_of_type_Boolean;
  protected float b;
  private int b;
  public String b;
  protected float c;
  private float d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "AbsProfileHeaderView";
  }
  
  public AbsProfileHeaderView(BaseActivity paramBaseActivity, aymg paramaymg)
  {
    super(paramBaseActivity);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver = new aytz(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
    this.jdField_a_of_type_Aymg = paramaymg;
    this.jdField_a_of_type_Bjmp = new bjmp(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    paramBaseActivity = getResources().getDisplayMetrics();
    this.jdField_a_of_type_Float = paramBaseActivity.density;
    this.jdField_b_of_type_Float = Math.min(paramBaseActivity.widthPixels, paramBaseActivity.heightPixels);
    this.c = Math.max(paramBaseActivity.widthPixels, paramBaseActivity.heightPixels);
    this.jdField_a_of_type_Long = 0L;
    this.d = (this.jdField_b_of_type_Float - ScreenUtil.dip2px(127.0F));
  }
  
  private SpannableStringBuilder a(aymg paramaymg, SpannableString paramSpannableString, TextView paramTextView)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramSpannableString);
    if (paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      localSpannableStringBuilder.insert(0, "[S] ");
      paramaymg = null;
    }
    try
    {
      paramSpannableString = BitmapFactory.decodeResource(getResources(), 2130845760);
      paramaymg = paramSpannableString;
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
    paramaymg = new bhji(getResources(), paramaymg, false, false);
    i = (int)(paramTextView.getTextSize() + 0.5F);
    paramaymg.setBounds(0, 0, i, i);
    paramaymg = new bhfp(paramaymg, 0);
    paramaymg.a(-0.1F);
    localSpannableStringBuilder.setSpan(paramaymg, 0, "[S]".length(), 17);
    return localSpannableStringBuilder;
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
    paramString1 = TextUtils.ellipsize(paramString1, paramTextView, this.d - f3 - (f1 + 5.0F * f2), TextUtils.TruncateAt.END);
    paramTextView = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramTextView = "…";
    }
    return String.format("QQ：%s (%s)", new Object[] { paramString2, paramTextView });
  }
  
  private void a(int paramInt, ProfileActivity.AllInOne paramAllInOne, String paramString)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject4 = null;
    int i = getResources().getDimensionPixelSize(2131297214);
    Object localObject1 = (AvatarLayout)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_face");
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject1 = (ImageView)localObject1;
      if ((3 != paramInt) && ((localObject1 instanceof DynamicAvatarView))) {
        ((DynamicAvatarView)localObject1).e = "";
      }
      if (paramInt != 0) {
        break label280;
      }
      localObject1 = localObject4;
      if (paramAllInOne.jdField_a_of_type_Int == 0)
      {
        localObject1 = localObject4;
        if (!bfrj.a()) {}
      }
    }
    for (;;)
    {
      try
      {
        paramAllInOne = bfrj.b();
        localObject3 = new File(paramAllInOne);
        localObject1 = new BitmapFactory.Options();
        localObject3 = new FileInputStream((File)localObject3);
        ((BitmapFactory.Options)localObject1).inSampleSize = ((int)bfvo.a((InputStream)localObject3, i, i));
        ((InputStream)localObject3).close();
        paramAllInOne = bfpx.a(paramAllInOne, (BitmapFactory.Options)localObject1);
        localObject1 = paramAllInOne;
        if (paramAllInOne == null) {}
      }
      catch (Exception localException1)
      {
        paramAllInOne = localObject2;
        localObject2 = localException1;
      }
      try
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localObject1 = QQAppInterface.getCircleFaceBitmap(paramAllInOne, paramAllInOne.getWidth(), paramAllInOne.getHeight());
        paramAllInOne = (ProfileActivity.AllInOne)localObject1;
        if (localObject1 == null) {
          paramAllInOne = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getFaceBitmap(paramString, true);
        }
        if (paramAllInOne != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new AbsProfileHeaderView.4(this, paramAllInOne));
        }
        return;
      }
      catch (Exception localException2)
      {
        ProfileActivity.AllInOne localAllInOne;
        break label253;
      }
      localObject1 = ((AvatarLayout)localObject1).a(0);
      break;
      label253:
      localAllInOne = paramAllInOne;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.profilecard.FrdProfileCard", 2, localObject2.toString());
        localAllInOne = paramAllInOne;
        continue;
        label280:
        if (1 == paramInt)
        {
          paramAllInOne = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFaceBitmap(11, paramString, (byte)3, true, 0);
        }
        else
        {
          if (3 == paramInt)
          {
            if ((localAllInOne instanceof DynamicAvatarView))
            {
              paramAllInOne = (DynamicAvatarView)localAllInOne;
              paramAllInOne.e = ContactUtils.getHeaderText(this.jdField_a_of_type_Aymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.k);
              if (!ContactUtils.isContainChinese(paramAllInOne.e)) {
                break label382;
              }
              paramAllInOne.setTextSize(getContext().getResources().getDimensionPixelSize(2131299024));
            }
            for (;;)
            {
              try
              {
                paramAllInOne = BitmapFactory.decodeResource(getContext().getResources(), 2130842104);
              }
              catch (OutOfMemoryError paramAllInOne)
              {
                label382:
                paramAllInOne = (ProfileActivity.AllInOne)localObject3;
              }
              paramAllInOne.setTextSize(getContext().getResources().getDimensionPixelSize(2131299025));
            }
          }
          if (2 == paramInt) {
            paramAllInOne = bfvo.b();
          } else {
            paramAllInOne = bfvo.a();
          }
        }
      }
    }
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    if (!paramBoolean)
    {
      paramView.setVisibility(8);
      return;
    }
    if (!aymz.a().c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      paramView.setVisibility(8);
      return;
    }
    Object localObject = aqjh.a();
    if ((localObject == null) || (((aqje)localObject).a()))
    {
      paramView.setVisibility(8);
      return;
    }
    paramView.setVisibility(0);
    TextView localTextView = (TextView)paramView.findViewById(2131379675);
    ImageView localImageView = (ImageView)paramView.findViewById(2131369194);
    ArrayList localArrayList = ((aqje)localObject).a().a;
    localTextView.setText(aymz.a().a((aqje)localObject));
    int i = 0;
    int j;
    while (i < ((aqje)localObject).a().a.size()) {
      if (TextUtils.isEmpty(((aqjg)localArrayList.get(i)).jdField_a_of_type_JavaLangString))
      {
        i += 1;
      }
      else
      {
        j = ((aqjg)localArrayList.get(i)).jdField_a_of_type_Int;
        localObject = ((aqjg)localArrayList.get(i)).jdField_a_of_type_JavaLangString;
      }
    }
    for (i = j;; i = -1)
    {
      if (paramBoolean) {
        paramView.setOnClickListener(new aytu(this, (String)localObject, i, paramView));
      }
      localImageView.setOnClickListener(new aytv(this, paramView));
      bcef.b(null, "dc00898", "", "", "0X800A4D4", "0X800A4D4", 0, 0, "2", "0", "", "");
      return;
      localObject = "";
    }
  }
  
  private void a(ImageView paramImageView)
  {
    if (paramImageView != null)
    {
      paramImageView = paramImageView.getDrawable();
      if ((paramImageView instanceof FaceDrawable)) {
        ((FaceDrawable)paramImageView).setSupportMaskView(false);
      }
    }
  }
  
  private void a(LinearLayout paramLinearLayout, aymg paramaymg)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "makeAccountDetailInfoForQQCircle");
    }
    if ((paramaymg == null) || (paramLinearLayout == null)) {
      return;
    }
    paramLinearLayout.removeAllViews();
    List localList = bfrj.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramaymg);
    boolean bool = localList.isEmpty();
    int i;
    int j;
    if ((paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0))
    {
      i = 1;
      if ((bool) && (i != 0)) {
        localList.add(android.util.Pair.create(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698460), ""));
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
            localTextView.setTextColor(getResources().getColor(2131167012));
            if (!TextUtils.isEmpty((CharSequence)localPair.second))
            {
              localTextView.setBackgroundResource(2130844001);
              localTextView.setPadding(ViewUtils.dpToPx(8.0F), ViewUtils.dpToPx(4.5F), ViewUtils.dpToPx(8.0F), ViewUtils.dpToPx(4.5F));
            }
            localTextView.setTextSize(14.0F);
            paramLinearLayout.addView(localTextView);
          }
          try
          {
            ((LinearLayout.LayoutParams)localTextView.getLayoutParams()).rightMargin = ViewUtils.dpToPx(6.0F);
            paramLinearLayout.measure(0, 0);
            QLog.d(jdField_a_of_type_JavaLangString, 2, "makeAccountDetailInfoForQQCircle " + str + ", " + this.d + ", " + paramLinearLayout.getMeasuredWidth());
            if (paramLinearLayout.getMeasuredWidth() > this.d)
            {
              paramLinearLayout.removeView(localTextView);
              paramLinearLayout.setOnTouchListener(mum.a);
              paramLinearLayout.setOnClickListener(new aytt(this, paramaymg));
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
              bfrj.a(localTextView, null, null);
            }
            i += 1;
          }
        }
      }
    }
    paramLinearLayout.setVisibility(8);
  }
  
  private void a(TextView paramTextView, aymg paramaymg)
  {
    Object localObject2 = null;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "makeAccountDetailInfo");
    }
    if (paramTextView == null) {
      return;
    }
    if (paramaymg == null) {}
    for (Card localCard = null; (paramaymg == null) || (localCard == null) || (ProfileActivity.AllInOne.j(paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (ProfileActivity.AllInOne.k(paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)); localCard = paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard)
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_uin_info");
      paramTextView.setVisibility(8);
      return;
    }
    paramTextView.setVisibility(0);
    Object localObject1;
    boolean bool;
    String str1;
    if (paramaymg.b)
    {
      localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(paramaymg.jdField_a_of_type_JavaLangString, localCard.uin);
      if ((localObject1 != null) && (TextUtils.isEmpty(((TroopMemberInfo)localObject1).troopnick)) && (!TextUtils.isEmpty(localCard.strReMark))) {
        localObject2 = localCard.strNick;
      }
      for (;;)
      {
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = ContactUtils.getBuddyName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localCard.uin, false);
        }
        if (!TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramaymg.jdField_a_of_type_JavaLangString)) {
          break;
        }
        localObject2 = localObject1;
        paramTextView.setVisibility(0);
        paramTextView.setSingleLine(true);
        bgff.a(paramTextView, bgff.a(localCard), localCard.lhLevel, true, (CharSequence)localObject1);
        paramTextView.setOnTouchListener(mum.a);
        paramTextView.setOnClickListener(new aytx(this, paramaymg));
        bfrj.a(paramTextView, localCard.uin, (String)localObject2);
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
    if ((paramaymg.jdField_a_of_type_ArrayOfJavaLangString != null) && (!TextUtils.isEmpty(paramaymg.jdField_a_of_type_ArrayOfJavaLangString[5])) && (!TextUtils.equals(paramaymg.jdField_a_of_type_ArrayOfJavaLangString[5], localCard.strNick))) {}
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
  
  private void a(aymg paramaymg, View paramView, TextView paramTextView, RichStatus paramRichStatus, int paramInt, SpannableString paramSpannableString)
  {
    boolean bool2;
    boolean bool1;
    if (paramSpannableString.length() > 0)
    {
      if ((!aymz.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (paramRichStatus.topics != null) && (paramRichStatus.topics.size() > 0)) {
        paramTextView.post(new AbsProfileHeaderView.5(this, paramRichStatus, paramTextView, paramInt));
      }
      aymz.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRichStatus);
      bool2 = aymz.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramView != null)
      {
        if (paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
          break label408;
        }
        bool1 = true;
        paramTextView = (TextView)paramView.findViewById(2131379675);
        paramRichStatus = (ImageView)paramView.findViewById(2131369194);
        paramSpannableString = new oidb_0xd9f.RspBody();
        if ((paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard.vLongNickTopicInfo == null)) {}
      }
    }
    for (;;)
    {
      try
      {
        paramSpannableString.mergeFrom(paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard.vLongNickTopicInfo);
        paramaymg = (oidb_0xd9f.LongNickItem)paramSpannableString.longnick_item.get();
        if (paramaymg == null) {
          break label414;
        }
        paramaymg = paramaymg.rpt_topic_item.get();
        if ((bool2) || (aymz.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, aymz.a().a(paramaymg))))
        {
          if ((paramaymg != null) && (paramaymg.size() > 0) && (aymz.a().a(paramaymg) > 0))
          {
            paramView.setTag(new aykg(97, aymz.a().a(paramaymg)));
            paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            paramTextView.setText(amtj.a(2131707604) + aymz.a().a(paramaymg) + amtj.a(2131707602));
            paramRichStatus.setOnClickListener(new aytw(this, paramView));
            paramView.setVisibility(0);
            bcef.b(null, "dc00898", "", "", "0X800A4D4", "0X800A4D4", 0, 0, "1", "0", "", "");
            return;
          }
          a(paramView, bool1);
          return;
        }
      }
      catch (Exception paramaymg)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.SummaryCard", 2, paramaymg.toString());
        }
        a(paramView, bool1);
        return;
      }
      a(paramView, bool1);
      return;
      a(paramView, bool1);
      return;
      label408:
      bool1 = false;
      break;
      label414:
      paramaymg = null;
    }
  }
  
  private void b(TextView paramTextView, aymg paramaymg)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "makeAccountDetailInfo");
    }
    if ((paramaymg == null) || (paramTextView == null)) {
      return;
    }
    List localList = bfrj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramaymg);
    boolean bool = localList.isEmpty();
    int i;
    label67:
    SpannableStringBuilder localSpannableStringBuilder;
    int n;
    Object localObject2;
    Object localObject3;
    int m;
    int j;
    int k;
    if ((paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0))
    {
      i = 1;
      if ((bool) && (i != 0)) {
        localList.add(new SpannableString(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698460)));
      }
      if (localList.isEmpty()) {
        break label577;
      }
      localSpannableStringBuilder = new SpannableStringBuilder();
      n = localList.size();
      localObject2 = bfrj.a(localList, 0, n, "  ", localSpannableStringBuilder);
      localObject3 = paramTextView.getPaint();
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = new TextPaint(1);
        ((TextPaint)localObject1).density = this.jdField_a_of_type_Float;
      }
      if (((TextPaint)localObject1).measureText((CharSequence)localObject2, 0, ((SpannableStringBuilder)localObject2).length() - 1) <= this.d) {
        break label584;
      }
      localObject2 = new SpannableStringBuilder();
      i = 0;
      m = 1;
      label262:
      do
      {
        localObject3 = bfrj.a(localList, i, m, "  ", localSpannableStringBuilder);
        if (((TextPaint)localObject1).measureText((CharSequence)localObject3, 0, ((SpannableStringBuilder)localObject3).length() - 1) >= this.d) {
          break label471;
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
      label309:
      if ((m > 1) && (i < m - 1) && (m - 1 == n))
      {
        localObject1 = bfrj.a(localList, i, m - 1, "  ", localSpannableStringBuilder);
        if (((SpannableStringBuilder)localObject2).length() > 0) {
          ((SpannableStringBuilder)localObject2).append("\n");
        }
        ((SpannableStringBuilder)localObject2).append((CharSequence)localObject1);
      }
    }
    label577:
    label584:
    for (Object localObject1 = localObject2;; localObject1 = localObject2)
    {
      localObject2 = (ViewGroup.MarginLayoutParams)((View)paramTextView.getParent()).getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = 0;
      ((View)paramTextView.getParent()).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      paramTextView.setVisibility(0);
      paramTextView.setSingleLine(true);
      paramTextView.setText((CharSequence)localObject1);
      paramTextView.setEllipsize(TextUtils.TruncateAt.END);
      paramTextView.setOnTouchListener(mum.a);
      paramTextView.setOnClickListener(new ayty(this, paramaymg));
      if (bool) {
        break;
      }
      bfrj.a(paramTextView, null, null);
      return;
      i = 0;
      break label67;
      label471:
      if (m - i == 1)
      {
        localObject1 = bfrj.a(localList, i, n, "  ", localSpannableStringBuilder);
        if (((SpannableStringBuilder)localObject2).length() > 0) {
          ((SpannableStringBuilder)localObject2).append("\n");
        }
        ((SpannableStringBuilder)localObject2).append((CharSequence)localObject1);
        break label309;
      }
      localObject3 = bfrj.a(localList, i, m - 1, "  ", localSpannableStringBuilder);
      if (((SpannableStringBuilder)localObject2).length() > 0) {
        ((SpannableStringBuilder)localObject2).append("\n");
      }
      ((SpannableStringBuilder)localObject2).append((CharSequence)localObject3);
      k = m - 1;
      j = m;
      break label262;
      paramTextView.setVisibility(8);
      return;
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_Bjmp != null) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      Message localMessage = this.jdField_a_of_type_Bjmp.obtainMessage(1000);
      if (localMessage != null) {
        this.jdField_a_of_type_Bjmp.sendMessage(localMessage);
      }
    }
  }
  
  private void j(aymg paramaymg)
  {
    this.jdField_b_of_type_Int &= 0xFFFFFFFD;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips_set_card");
    if (localView == null) {
      localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131561980, null);
    }
    for (;;)
    {
      if ((localView == null) || (paramaymg == null) || (paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard == null))
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        e();
        return;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tips_set_card", localView);
      if ((paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
      {
        long l1 = paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId;
        long l2 = paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId;
        int i = paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard.templateRet;
        paramaymg = paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard.getBgTypeArray();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "updateSetCardBar bgtype = " + paramaymg);
        }
        paramaymg = getResources();
        TextView localTextView = (TextView)localView.findViewById(2131367829);
        ImageView localImageView = (ImageView)localView.findViewById(2131367814);
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
        boolean bool = false;
        if (localObject != null) {
          bool = ((SharedPreferences)localObject).getBoolean("svip_profile_use_guide_shown_flag", false);
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "isShowTips" + bool + ",templateRet=" + i + ",myTemplateId=" + l1);
        }
        if (((101107 == i) || (101108 == i)) && (!bool) && (localObject != null))
        {
          ((SharedPreferences)localObject).edit().putBoolean("svip_profile_use_guide_shown_flag", true).commit();
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
          if (101107 != i) {
            break label451;
          }
        }
        label451:
        for (paramaymg = paramaymg.getString(2131694705);; paramaymg = paramaymg.getString(2131718745))
        {
          paramaymg = ((BaseActivity)localObject).getString(2131717614, new Object[] { paramaymg });
          localTextView.setText(paramaymg);
          localImageView.setContentDescription(paramaymg);
          localView.setTag(new aykg(24, Integer.valueOf(i)));
          localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          this.jdField_b_of_type_Int |= 0x2;
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
          e();
          return;
        }
      }
      ThreadManager.post(new AbsProfileHeaderView.UpdateProfileSetCardTask(this), 5, null, true);
      return;
    }
  }
  
  private void k(aymg paramaymg)
  {
    int j = 2;
    if (paramaymg != null)
    {
      bfrj.a(paramaymg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      int i = j;
      if (paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null)
      {
        i = j;
        if (paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
          i = 1;
        }
      }
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009999", "0X8009999", i, 0, "", "", "", "");
    }
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public View a(String paramString)
  {
    return (View)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public void a()
  {
    a(this.jdField_a_of_type_Aymg);
  }
  
  public void a(int paramInt) {}
  
  protected void a(aymg paramaymg)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "ProfileHeaderView onInit");
    }
    if (paramaymg.jdField_a_of_type_Aymn != null) {
      j(paramaymg);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver);
  }
  
  public void a(aymg paramaymg, long paramLong, boolean paramBoolean)
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
      if ((paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt == 0)) {
        ((VoteView)localObject).a();
      }
      ((VoteView)localObject).a(false, true, (int)l, 0, null, paramBoolean);
      ((VoteView)localObject).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((VoteView)localObject).setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691054), new Object[] { String.valueOf(l) }));
    }
  }
  
  public void a(aymg paramaymg, String paramString)
  {
    paramString = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_uin_info");
    if ((paramString instanceof TextView)) {
      a((TextView)paramString, paramaymg);
    }
  }
  
  public abstract void a(aymg paramaymg, boolean paramBoolean);
  
  public void a(baqc parambaqc, View paramView)
  {
    parambaqc = parambaqc.a();
    if ((parambaqc instanceof com.tencent.util.Pair))
    {
      parambaqc = (com.tencent.util.Pair)parambaqc;
      baqi.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, baqi.a(((Integer)parambaqc.first).intValue(), (String)parambaqc.second), -1);
    }
  }
  
  public void a(ProfileActivity.AllInOne paramAllInOne)
  {
    int i = 1;
    if (paramAllInOne.jdField_a_of_type_Int == 33)
    {
      a(paramAllInOne, 2, paramAllInOne.jdField_a_of_type_JavaLangString, false);
      return;
    }
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
    String str = bfrj.a(paramAllInOne);
    if ((str != null) && (str.length() > 0))
    {
      if (paramAllInOne.jdField_a_of_type_Int == 53)
      {
        if (paramAllInOne.b) {}
        for (;;)
        {
          a(paramAllInOne, i, str, false);
          return;
          i = 3;
        }
      }
      a(paramAllInOne, 1, str, false);
      return;
    }
    a(paramAllInOne, 2, paramAllInOne.jdField_a_of_type_JavaLangString, false);
  }
  
  public void a(ProfileActivity.AllInOne paramAllInOne, int paramInt, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, String.format("updateAvatar type=%s kye=%s isDynamicMode=%s", new Object[] { Integer.valueOf(paramInt), paramString, Boolean.valueOf(paramBoolean) }));
    }
    if ((!paramBoolean) || (paramInt != 0))
    {
      ThreadManager.post(new AbsProfileHeaderView.2(this, paramInt, paramAllInOne, paramString), 8, null, true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new AbsProfileHeaderView.3(this, paramAllInOne, paramInt, paramString));
  }
  
  public void a(String paramString, View paramView)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramView);
  }
  
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
  
  protected boolean a(aymg paramaymg)
  {
    boolean bool4 = false;
    boolean bool2;
    boolean bool5;
    boolean bool6;
    boolean bool1;
    if (paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard != null)
    {
      bool2 = true;
      bool5 = TextUtils.equals(paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      bool6 = ProfileActivity.AllInOne.b(paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      if ((bool5) || (bool6)) {
        break label174;
      }
      if ((!bool2) || (!paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard.strangerVoteOpen)) {
        break label169;
      }
      bool1 = true;
    }
    label66:
    for (boolean bool3 = bool1 & bool2;; bool3 = bool2)
    {
      if (QLog.isColorLevel())
      {
        String str = paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
        if (bool2) {
          bool4 = paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard.strangerVoteOpen;
        }
        QLog.d("Q.profilecard.FrdProfileCard", 2, String.format("isShowZan updateLike show=%b uin=%sself=%b frd=%b cardOk=%b open=%b ", new Object[] { Boolean.valueOf(bool3), str, Boolean.valueOf(bool5), Boolean.valueOf(bool6), Boolean.valueOf(bool2), Boolean.valueOf(bool4) }));
      }
      return bool3;
      bool2 = false;
      break;
      bool1 = false;
      break label66;
    }
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString);
  }
  
  public void b() {}
  
  public void b(aymg paramaymg)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tag_jueban");
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    if (((localObject instanceof ImageView)) && (localView != null) && (paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (a(paramaymg)) && (bfrj.a(paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard.getBgTypeArray())))
    {
      ((View)localObject).setTag(new aykg(34, null));
      ((View)localObject).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((View)localObject).setVisibility(0);
      localObject = "1";
      if (paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
        localObject = "0";
      }
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "card_mall", "0X8007A47", 0, 0, (String)localObject, "", "", "");
    }
  }
  
  public void b(aymg paramaymg, boolean paramBoolean)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_avatar_pendant");
    if ((localObject instanceof ImageView))
    {
      localObject = (ImageView)localObject;
      if (!ProfileActivity.AllInOne.g(paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        ((ImageView)localObject).setVisibility(4);
        this.jdField_a_of_type_Long = 0L;
      }
    }
    else
    {
      return;
    }
    ThreadManager.post(new AbsProfileHeaderView.7(this, paramaymg, paramBoolean), 8, null, true);
  }
  
  public void c() {}
  
  public void c(aymg paramaymg)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_profile_nick_name");
    if (localObject != null) {
      ((View)localObject).setBackgroundResource(2130845647);
    }
    if ((localObject instanceof TextView))
    {
      localTextView = (TextView)localObject;
      localAllInOne = paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
      localObject = paramaymg.jdField_a_of_type_Bfmt.a.jdField_a_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.FrdProfileCard", 2, "updateHead titleName = " + bftf.b((String)localObject));
      }
      if (localObject != null)
      {
        paramaymg = (aymg)localObject;
        if (((String)localObject).length() != 0) {}
      }
      else
      {
        if (!ProfileActivity.AllInOne.a(localAllInOne)) {
          break label213;
        }
        paramaymg = String.valueOf(localAllInOne.jdField_a_of_type_JavaLangString);
      }
      localTextView.setText(paramaymg);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691060) + ":";
      localTextView.setContentDescription((String)localObject + paramaymg);
      localTextView.setTag(new aykg(88, localTextView.getText().toString()));
      localTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      aytm.a(localTextView);
    }
    label213:
    while (!(localObject instanceof ProfileNameView)) {
      for (;;)
      {
        TextView localTextView;
        ProfileActivity.AllInOne localAllInOne;
        return;
        paramaymg = " ";
      }
    }
    ((ProfileNameView)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramaymg);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver);
    }
    if (this.jdField_a_of_type_Bjmp != null) {
      this.jdField_a_of_type_Bjmp.removeCallbacksAndMessages(null);
    }
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qzonecover");
    if ((localView instanceof QzonePhotoView)) {
      ((QzonePhotoView)localView).a();
    }
  }
  
  public void d(aymg paramaymg)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_sex_age_area");
    String str;
    if ((localObject instanceof TextView))
    {
      localObject = (TextView)localObject;
      str = bfrj.c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramaymg);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea strInfo=" + bftf.b(str));
      }
      if (paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33) {
        break label126;
      }
      paramaymg = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698452);
      if (((TextView)localObject).getVisibility() != 0) {
        ((TextView)localObject).setVisibility(0);
      }
      ((TextView)localObject).setPadding(0, 10, 0, 0);
      ((TextView)localObject).setText(paramaymg);
      ((TextView)localObject).setContentDescription(paramaymg);
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
        ((TextView)localObject).setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691039) + ":" + str);
        ((TextView)localObject).setClickable(true);
        return;
      }
    } while (((TextView)localObject).getVisibility() == 8);
    ((TextView)localObject).setVisibility(8);
  }
  
  public void e(aymg paramaymg)
  {
    if ((paramaymg != null) && (paramaymg.b) && (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramaymg.jdField_a_of_type_JavaLangString))) {}
    Object localObject1;
    View localView;
    TextView localTextView;
    RichStatus localRichStatus;
    do
    {
      do
      {
        do
        {
          return;
          localObject1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_sign");
          localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_sign_common_topic");
        } while ((!(localObject1 instanceof TextView)) || (paramaymg == null) || (paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null));
        localTextView = (TextView)localObject1;
        if (paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard != null) {
          break;
        }
        localTextView.setVisibility(8);
      } while (localView == null);
      localView.setVisibility(8);
      return;
      localRichStatus = paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard.getRichStatus();
      if ((ProfileActivity.AllInOne.g(paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) && (localRichStatus != null)) {
        break;
      }
      if (paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
      {
        localTextView.setCompoundDrawablesWithIntrinsicBounds(2130845760, 0, 0, 0);
        localTextView.setText(amtj.a(2131707605));
        localTextView.setVisibility(0);
        localTextView.setTag(new aykg(3, ""));
        localTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691120));
        a(localView, true);
        return;
      }
      localTextView.setVisibility(8);
    } while (localView == null);
    localView.setVisibility(8);
    return;
    SpannableString localSpannableString = new SpannableString(localRichStatus.toSpannableStringWithTopic("", -8947849, -2039584, this));
    int i;
    if (!TextUtils.isEmpty(localRichStatus.actionText))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(localSpannableString);
      localSpannableStringBuilder.insert(0, "[S] ");
      localObject1 = (baoy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(15);
      if (localObject1 != null)
      {
        localObject1 = ((baoy)localObject1).a(localRichStatus.actionId, 200);
        localObject1 = new bhji(getResources(), (Bitmap)localObject1, false, false);
        i = (int)(localTextView.getTextSize() * 1.1F + 0.5F);
        ((BitmapDrawable)localObject1).setBounds(0, 0, i, i);
        localObject1 = new bhfp((Drawable)localObject1, 0);
        ((bhfp)localObject1).a(-0.1F);
        localSpannableStringBuilder.setSpan(localObject1, 0, "[S]".length(), 17);
        if (paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
          localTextView.setCompoundDrawablesWithIntrinsicBounds(2130845760, 0, 0, 0);
        }
        localTextView.setText(new QQText(localSpannableStringBuilder, 1, 14));
        localTextView.setMovementMethod(baqe.a());
        localTextView.setVisibility(0);
        label439:
        a(paramaymg, localView, localTextView, localRichStatus, i, localSpannableString);
        if ((paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) || (ProfileActivity.AllInOne.b(paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))) {
          localTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        }
        if ((ProfileActivity.AllInOne.b(paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) && (paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0)) {
          localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130845761, 0);
        }
        localObject1 = new StringBuilder().append(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691120)).append(":");
        if (TextUtils.isEmpty(localSpannableString)) {
          break label645;
        }
      }
    }
    label645:
    for (paramaymg = localSpannableString.toString();; paramaymg = "")
    {
      for (;;)
      {
        localTextView.setContentDescription(paramaymg);
        return;
        try
        {
          localObject1 = BitmapFactory.decodeResource(getResources(), 2130849498);
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          localOutOfMemoryError.printStackTrace();
          Object localObject2 = null;
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          Object localObject3 = null;
        }
      }
      break;
      localTextView.setText(new QQText(a(paramaymg, localSpannableString, localTextView), 1, 14));
      localTextView.setMovementMethod(baqe.a());
      localTextView.setVisibility(0);
      i = 0;
      break label439;
    }
  }
  
  public void f(aymg paramaymg)
  {
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_details");
    if ((localView instanceof TextView)) {
      b((TextView)localView, paramaymg);
    }
    while (!(localView instanceof LinearLayout)) {
      return;
    }
    a((LinearLayout)localView, paramaymg);
  }
  
  public void g(aymg paramaymg)
  {
    if ((paramaymg.b) && (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramaymg.jdField_a_of_type_JavaLangString))) {}
    Object localObject;
    do
    {
      return;
      localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    } while (!(localObject instanceof VoteView));
    VoteView localVoteView = (VoteView)localObject;
    boolean bool1 = a(paramaymg);
    boolean bool2 = TextUtils.equals(paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (bool1)
    {
      if (localVoteView.getVisibility() != 0) {
        localVoteView.setVisibility(0);
      }
      int i;
      int j;
      if (paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard == null)
      {
        paramaymg = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691131);
        localObject = null;
        i = 0;
        j = 0;
        bool1 = false;
      }
      for (;;)
      {
        localVoteView.a(bool2, bool1, i, j, this.jdField_a_of_type_Aqvb, false);
        localVoteView.setTag(localObject);
        localVoteView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localVoteView.setContentDescription(paramaymg);
        return;
        if (this.jdField_a_of_type_Aqvb == null) {
          this.jdField_a_of_type_Aqvb = new aqvb(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 1);
        }
        i = (int)paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard.lVoteCount;
        j = paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard.iVoteIncrement;
        this.jdField_a_of_type_Aqvb.a = paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard.getLastPraiseInfoList();
        if (j <= this.jdField_a_of_type_Aqvb.a.size()) {
          this.jdField_a_of_type_Aqvb.a = this.jdField_a_of_type_Aqvb.a.subList(0, j);
        }
        this.jdField_a_of_type_Aqvb.a = ayol.a(this.jdField_a_of_type_Aqvb.a);
        if (1 == paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard.bVoted) {}
        for (bool1 = true;; bool1 = false)
        {
          localObject = new aykg(10, paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard);
          if (!bool2) {
            break label345;
          }
          paramaymg = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691129), new Object[] { String.valueOf(i) });
          break;
        }
        label345:
        String str = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691042), new Object[] { String.valueOf(i) });
        if (paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt == 0) {
          localVoteView.a();
        }
        paramaymg = str;
      }
    }
    localVoteView.setVisibility(4);
  }
  
  public void h(aymg paramaymg)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "ProfileHeaderView updateTips");
    }
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips");
    if ((localObject instanceof LinearLayout))
    {
      localObject = (LinearLayout)localObject;
      if ((this.jdField_b_of_type_Int & 0x2) != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "ProfileHeaderView updateTips setcard");
        }
        View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips_set_card");
        if (localView != null)
        {
          ((LinearLayout)localObject).removeAllViews();
          ((LinearLayout)localObject).addView(localView);
          ((LinearLayout)localObject).setVisibility(0);
          if (paramaymg.b) {
            VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "group_card", "guide_show", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
          }
        }
      }
    }
  }
  
  public void i(aymg paramaymg) {}
  
  public boolean intercept(View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = getResources().getDisplayMetrics();
    this.jdField_a_of_type_Float = paramConfiguration.density;
    this.jdField_b_of_type_Float = Math.min(paramConfiguration.widthPixels, paramConfiguration.heightPixels);
    this.c = Math.max(paramConfiguration.widthPixels, paramConfiguration.heightPixels);
  }
  
  public void setClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
 * JD-Core Version:    0.7.0.1
 */