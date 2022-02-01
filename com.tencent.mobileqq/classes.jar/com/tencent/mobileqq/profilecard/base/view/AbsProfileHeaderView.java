package com.tencent.mobileqq.profilecard.base.view;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
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
import anui;
import anzj;
import aoot;
import arpg;
import arph;
import arpi;
import arpj;
import asbe;
import azvr;
import azxr;
import azyk;
import azzw;
import baex;
import bafd;
import bafe;
import baff;
import bafg;
import bafh;
import bafi;
import bafj;
import bafk;
import bbvd;
import bbwh;
import bbwi;
import bbwj;
import bbwn;
import bdep;
import bdll;
import begp;
import bhdg;
import bhdh;
import bhgm;
import bhhz;
import bhjx;
import bhlg;
import bhmq;
import bhtq;
import bhyu;
import bizo;
import bjdm;
import blha;
import blrg;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.profile.view.QzonePhotoView;
import com.tencent.mobileqq.profile.view.VipPhotoViewForSimple;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mvd;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f.LongNickItem;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f.RspBody;

public abstract class AbsProfileHeaderView
  extends RelativeLayout
  implements bbwi, blrg
{
  public static String a;
  protected float a;
  public int a;
  public long a;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new bafd(this);
  public View.OnClickListener a;
  public anui a;
  protected asbe a;
  public azxr a;
  protected blha a;
  public BaseActivity a;
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
  
  public AbsProfileHeaderView(BaseActivity paramBaseActivity, azxr paramazxr)
  {
    super(paramBaseActivity);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Anui = new bafk(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
    this.jdField_a_of_type_Azxr = paramazxr;
    this.jdField_a_of_type_Blha = new blha(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    paramBaseActivity = getResources().getDisplayMetrics();
    this.jdField_a_of_type_Float = paramBaseActivity.density;
    this.jdField_b_of_type_Float = Math.min(paramBaseActivity.widthPixels, paramBaseActivity.heightPixels);
    this.c = Math.max(paramBaseActivity.widthPixels, paramBaseActivity.heightPixels);
    this.jdField_a_of_type_Long = 0L;
    this.d = (this.jdField_b_of_type_Float - bdep.a(127.0F));
  }
  
  private SpannableStringBuilder a(azxr paramazxr, SpannableString paramSpannableString, TextView paramTextView)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramSpannableString);
    if (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      localSpannableStringBuilder.insert(0, "[S] ");
      paramazxr = null;
    }
    try
    {
      paramSpannableString = BitmapFactory.decodeResource(getResources(), 2130845860);
      paramazxr = paramSpannableString;
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
    paramazxr = new bjdm(getResources(), paramazxr, false, false);
    i = (int)(paramTextView.getTextSize() + 0.5F);
    paramazxr.setBounds(0, 0, i, i);
    paramazxr = new bizo(paramazxr, 0);
    paramazxr.a(-0.1F);
    localSpannableStringBuilder.setSpan(paramazxr, 0, "[S]".length(), 17);
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
    int i = getResources().getDimensionPixelSize(2131297159);
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
        if (!bhhz.a()) {}
      }
    }
    for (;;)
    {
      try
      {
        paramAllInOne = bhhz.b();
        localObject3 = new File(paramAllInOne);
        localObject1 = new BitmapFactory.Options();
        localObject3 = new FileInputStream((File)localObject3);
        ((BitmapFactory.Options)localObject1).inSampleSize = ((int)bhmq.a((InputStream)localObject3, i, i));
        ((InputStream)localObject3).close();
        paramAllInOne = bhgm.a(paramAllInOne, (BitmapFactory.Options)localObject1);
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
        localObject1 = QQAppInterface.a(paramAllInOne, paramAllInOne.getWidth(), paramAllInOne.getHeight());
        paramAllInOne = (ProfileActivity.AllInOne)localObject1;
        if (localObject1 == null) {
          paramAllInOne = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a(paramString, true);
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
          paramAllInOne = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11, paramString, (byte)3, true, 0);
        }
        else
        {
          if (3 == paramInt)
          {
            if ((localAllInOne instanceof DynamicAvatarView))
            {
              paramAllInOne = (DynamicAvatarView)localAllInOne;
              paramAllInOne.e = bhlg.a(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.k);
              if (!bhlg.a(paramAllInOne.e)) {
                break label382;
              }
              paramAllInOne.setTextSize(getContext().getResources().getDimensionPixelSize(2131298959));
            }
            for (;;)
            {
              try
              {
                paramAllInOne = BitmapFactory.decodeResource(getContext().getResources(), 2130842062);
              }
              catch (OutOfMemoryError paramAllInOne)
              {
                label382:
                paramAllInOne = (ProfileActivity.AllInOne)localObject3;
              }
              paramAllInOne.setTextSize(getContext().getResources().getDimensionPixelSize(2131298960));
            }
          }
          if (2 == paramInt) {
            paramAllInOne = bhmq.b();
          } else {
            paramAllInOne = bhmq.a();
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
    if (!azyk.a().c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      paramView.setVisibility(8);
      return;
    }
    Object localObject = arpj.a();
    if ((localObject == null) || (((arpg)localObject).a()))
    {
      paramView.setVisibility(8);
      return;
    }
    paramView.setVisibility(0);
    TextView localTextView = (TextView)paramView.findViewById(2131379903);
    ImageView localImageView = (ImageView)paramView.findViewById(2131369171);
    ArrayList localArrayList = ((arpg)localObject).a().a;
    localTextView.setText(azyk.a().a((arpg)localObject));
    int i = 0;
    int j;
    while (i < ((arpg)localObject).a().a.size()) {
      if (TextUtils.isEmpty(((arpi)localArrayList.get(i)).jdField_a_of_type_JavaLangString))
      {
        i += 1;
      }
      else
      {
        j = ((arpi)localArrayList.get(i)).jdField_a_of_type_Int;
        localObject = ((arpi)localArrayList.get(i)).jdField_a_of_type_JavaLangString;
      }
    }
    for (i = j;; i = -1)
    {
      if (paramBoolean) {
        paramView.setOnClickListener(new baff(this, (String)localObject, i, paramView));
      }
      localImageView.setOnClickListener(new bafg(this, paramView));
      bdll.b(null, "dc00898", "", "", "0X800A4D4", "0X800A4D4", 0, 0, "2", "0", "", "");
      return;
      localObject = "";
    }
  }
  
  private void a(ImageView paramImageView)
  {
    if (paramImageView != null)
    {
      paramImageView = paramImageView.getDrawable();
      if ((paramImageView instanceof aoot)) {
        ((aoot)paramImageView).a(false);
      }
    }
  }
  
  private void a(LinearLayout paramLinearLayout, azxr paramazxr)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "makeAccountDetailInfoForQQCircle");
    }
    if ((paramazxr == null) || (paramLinearLayout == null)) {
      return;
    }
    paramLinearLayout.removeAllViews();
    List localList = bhhz.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramazxr);
    boolean bool = localList.isEmpty();
    int i;
    int j;
    if ((paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0))
    {
      i = 1;
      if ((bool) && (i != 0)) {
        localList.add(android.util.Pair.create(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698291), ""));
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
            localTextView.setTextColor(getResources().getColor(2131166990));
            if (!TextUtils.isEmpty((CharSequence)localPair.second))
            {
              localTextView.setBackgroundResource(2130844054);
              localTextView.setPadding(bhtq.b(8.0F), bhtq.b(4.5F), bhtq.b(8.0F), bhtq.b(4.5F));
            }
            localTextView.setTextSize(14.0F);
            paramLinearLayout.addView(localTextView);
          }
          try
          {
            ((LinearLayout.LayoutParams)localTextView.getLayoutParams()).rightMargin = bhtq.b(6.0F);
            paramLinearLayout.measure(0, 0);
            QLog.d(jdField_a_of_type_JavaLangString, 2, "makeAccountDetailInfoForQQCircle " + str + ", " + this.d + ", " + paramLinearLayout.getMeasuredWidth());
            if (paramLinearLayout.getMeasuredWidth() > this.d)
            {
              paramLinearLayout.removeView(localTextView);
              paramLinearLayout.setOnTouchListener(mvd.a);
              paramLinearLayout.setOnClickListener(new bafe(this, paramazxr));
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
              bhhz.a(localTextView, null, null);
            }
            i += 1;
          }
        }
      }
    }
    paramLinearLayout.setVisibility(8);
  }
  
  private void a(TextView paramTextView, azxr paramazxr)
  {
    Object localObject2 = null;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "makeAccountDetailInfo");
    }
    if (paramTextView == null) {
      return;
    }
    if (paramazxr == null) {}
    for (Card localCard = null; (paramazxr == null) || (localCard == null) || (ProfileActivity.AllInOne.j(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (ProfileActivity.AllInOne.k(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)); localCard = paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard)
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_uin_info");
      paramTextView.setVisibility(8);
      return;
    }
    paramTextView.setVisibility(0);
    Object localObject1;
    boolean bool;
    String str1;
    if (paramazxr.b)
    {
      localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(paramazxr.jdField_a_of_type_JavaLangString, localCard.uin);
      if ((localObject1 != null) && (TextUtils.isEmpty(((TroopMemberInfo)localObject1).troopnick)) && (!TextUtils.isEmpty(localCard.strReMark))) {
        localObject2 = localCard.strNick;
      }
      for (;;)
      {
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = bhlg.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localCard.uin, false);
        }
        if (!TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramazxr.jdField_a_of_type_JavaLangString)) {
          break;
        }
        localObject2 = localObject1;
        paramTextView.setVisibility(0);
        paramTextView.setSingleLine(true);
        bhyu.a(paramTextView, bhyu.a(localCard), localCard.lhLevel, true, (CharSequence)localObject1);
        paramTextView.setOnTouchListener(mvd.a);
        paramTextView.setOnClickListener(new bafi(this, paramazxr));
        bhhz.a(paramTextView, localCard.uin, (String)localObject2);
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
    if ((paramazxr.jdField_a_of_type_ArrayOfJavaLangString != null) && (!TextUtils.isEmpty(paramazxr.jdField_a_of_type_ArrayOfJavaLangString[5])) && (!TextUtils.equals(paramazxr.jdField_a_of_type_ArrayOfJavaLangString[5], localCard.strNick))) {}
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
  
  private void a(azxr paramazxr, View paramView, TextView paramTextView, RichStatus paramRichStatus, int paramInt, SpannableString paramSpannableString)
  {
    boolean bool2;
    boolean bool1;
    if (paramSpannableString.length() > 0)
    {
      if ((!azyk.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (paramRichStatus.topics != null) && (paramRichStatus.topics.size() > 0)) {
        paramTextView.post(new AbsProfileHeaderView.5(this, paramRichStatus, paramTextView, paramInt));
      }
      azyk.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRichStatus);
      bool2 = azyk.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramView != null)
      {
        if (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
          break label408;
        }
        bool1 = true;
        paramTextView = (TextView)paramView.findViewById(2131379903);
        paramRichStatus = (ImageView)paramView.findViewById(2131369171);
        paramSpannableString = new oidb_0xd9f.RspBody();
        if ((paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard.vLongNickTopicInfo == null)) {}
      }
    }
    for (;;)
    {
      try
      {
        paramSpannableString.mergeFrom(paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard.vLongNickTopicInfo);
        paramazxr = (oidb_0xd9f.LongNickItem)paramSpannableString.longnick_item.get();
        if (paramazxr == null) {
          break label414;
        }
        paramazxr = paramazxr.rpt_topic_item.get();
        if ((bool2) || (azyk.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, azyk.a().a(paramazxr))))
        {
          if ((paramazxr != null) && (paramazxr.size() > 0) && (azyk.a().a(paramazxr) > 0))
          {
            paramView.setTag(new azvr(97, azyk.a().a(paramazxr)));
            paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            paramTextView.setText(anzj.a(2131707372) + azyk.a().a(paramazxr) + anzj.a(2131707370));
            paramRichStatus.setOnClickListener(new bafh(this, paramView));
            paramView.setVisibility(0);
            bdll.b(null, "dc00898", "", "", "0X800A4D4", "0X800A4D4", 0, 0, "1", "0", "", "");
            return;
          }
          a(paramView, bool1);
          return;
        }
      }
      catch (Exception paramazxr)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.SummaryCard", 2, paramazxr.toString());
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
      paramazxr = null;
    }
  }
  
  private void b(TextView paramTextView, azxr paramazxr)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "makeAccountDetailInfo");
    }
    if ((paramazxr == null) || (paramTextView == null)) {
      return;
    }
    List localList = bhhz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramazxr);
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
    if ((paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0))
    {
      i = 1;
      if ((bool) && (i != 0)) {
        localList.add(new SpannableString(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698291)));
      }
      if (localList.isEmpty()) {
        break label577;
      }
      localSpannableStringBuilder = new SpannableStringBuilder();
      n = localList.size();
      localObject2 = bhhz.a(localList, 0, n, "  ", localSpannableStringBuilder);
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
        localObject3 = bhhz.a(localList, i, m, "  ", localSpannableStringBuilder);
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
        localObject1 = bhhz.a(localList, i, m - 1, "  ", localSpannableStringBuilder);
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
      paramTextView.setOnTouchListener(mvd.a);
      paramTextView.setOnClickListener(new bafj(this, paramazxr));
      if (bool) {
        break;
      }
      bhhz.a(paramTextView, null, null);
      return;
      i = 0;
      break label67;
      label471:
      if (m - i == 1)
      {
        localObject1 = bhhz.a(localList, i, n, "  ", localSpannableStringBuilder);
        if (((SpannableStringBuilder)localObject2).length() > 0) {
          ((SpannableStringBuilder)localObject2).append("\n");
        }
        ((SpannableStringBuilder)localObject2).append((CharSequence)localObject1);
        break label309;
      }
      localObject3 = bhhz.a(localList, i, m - 1, "  ", localSpannableStringBuilder);
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
    if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_Blha != null) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      Message localMessage = this.jdField_a_of_type_Blha.obtainMessage(1000);
      if (localMessage != null) {
        this.jdField_a_of_type_Blha.sendMessage(localMessage);
      }
    }
  }
  
  private void j(azxr paramazxr)
  {
    this.jdField_b_of_type_Int &= 0xFFFFFFFD;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips_set_card");
    if (localView == null) {
      localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131562105, null);
    }
    for (;;)
    {
      if ((localView == null) || (paramazxr == null) || (paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard == null))
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        e();
        return;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tips_set_card", localView);
      if ((paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
      {
        long l1 = paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId;
        long l2 = paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId;
        int i = paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard.templateRet;
        paramazxr = paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard.getBgTypeArray();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "updateSetCardBar bgtype = " + paramazxr);
        }
        paramazxr = getResources();
        TextView localTextView = (TextView)localView.findViewById(2131367797);
        ImageView localImageView = (ImageView)localView.findViewById(2131367782);
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
        for (paramazxr = paramazxr.getString(2131694589);; paramazxr = paramazxr.getString(2131718497))
        {
          paramazxr = ((BaseActivity)localObject).getString(2131717382, new Object[] { paramazxr });
          localTextView.setText(paramazxr);
          localImageView.setContentDescription(paramazxr);
          localView.setTag(new azvr(24, Integer.valueOf(i)));
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
  
  private void k(azxr paramazxr)
  {
    int j = 2;
    if (paramazxr != null)
    {
      bhhz.a(paramazxr, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      int i = j;
      if (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null)
      {
        i = j;
        if (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
          i = 1;
        }
      }
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009999", "0X8009999", i, 0, "", "", "", "");
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
    a(this.jdField_a_of_type_Azxr);
  }
  
  public void a(int paramInt) {}
  
  protected void a(azxr paramazxr)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "ProfileHeaderView onInit");
    }
    if (paramazxr.jdField_a_of_type_Azxy != null) {
      j(paramazxr);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anui);
  }
  
  public void a(azxr paramazxr, long paramLong, boolean paramBoolean)
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
      if ((paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt == 0)) {
        ((VoteView)localObject).a();
      }
      ((VoteView)localObject).a(false, true, (int)l, 0, null, paramBoolean);
      ((VoteView)localObject).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((VoteView)localObject).setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691014), new Object[] { String.valueOf(l) }));
    }
  }
  
  public void a(azxr paramazxr, String paramString)
  {
    paramString = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_uin_info");
    if ((paramString instanceof TextView)) {
      a((TextView)paramString, paramazxr);
    }
  }
  
  public abstract void a(azxr paramazxr, boolean paramBoolean);
  
  public void a(bbwh parambbwh, View paramView)
  {
    parambbwh = parambbwh.a();
    if ((parambbwh instanceof com.tencent.util.Pair))
    {
      parambbwh = (com.tencent.util.Pair)parambbwh;
      bbwn.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, bbwn.a(((Integer)parambbwh.first).intValue(), (String)parambbwh.second), -1);
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
    String str = bhhz.a(paramAllInOne);
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
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  protected boolean a(azxr paramazxr)
  {
    boolean bool4 = false;
    boolean bool2;
    boolean bool5;
    boolean bool6;
    boolean bool1;
    if ((paramazxr != null) && (paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard != null))
    {
      bool2 = true;
      bool5 = TextUtils.equals(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      bool6 = ProfileActivity.AllInOne.b(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      if ((bool5) || (bool6)) {
        break label178;
      }
      if ((!bool2) || (!paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard.strangerVoteOpen)) {
        break label173;
      }
      bool1 = true;
    }
    label70:
    for (boolean bool3 = bool1 & bool2;; bool3 = bool2)
    {
      if (QLog.isColorLevel())
      {
        String str = paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
        if (bool2) {
          bool4 = paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard.strangerVoteOpen;
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
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString);
  }
  
  public void b() {}
  
  public void b(azxr paramazxr)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tag_jueban");
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    if (((localObject instanceof ImageView)) && (localView != null) && (paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (a(paramazxr)) && (bhhz.a(paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard.getBgTypeArray())))
    {
      ((View)localObject).setTag(new azvr(34, null));
      ((View)localObject).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((View)localObject).setVisibility(0);
      localObject = "1";
      if (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
        localObject = "0";
      }
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "card_mall", "0X8007A47", 0, 0, (String)localObject, "", "", "");
    }
  }
  
  public void b(azxr paramazxr, boolean paramBoolean)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_avatar_pendant");
    if ((localObject instanceof ImageView))
    {
      localObject = (ImageView)localObject;
      if (!ProfileActivity.AllInOne.g(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        ((ImageView)localObject).setVisibility(4);
        this.jdField_a_of_type_Long = 0L;
      }
    }
    else
    {
      return;
    }
    ThreadManager.post(new AbsProfileHeaderView.7(this, paramazxr, paramBoolean), 8, null, true);
  }
  
  public void c() {}
  
  public void c(azxr paramazxr)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_profile_nick_name");
    if (localObject != null) {
      ((View)localObject).setBackgroundResource(2130845747);
    }
    if ((localObject instanceof TextView))
    {
      localTextView = (TextView)localObject;
      localAllInOne = paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
      localObject = paramazxr.jdField_a_of_type_Bhdh.a.jdField_a_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.FrdProfileCard", 2, "updateHead titleName = " + bhjx.b((String)localObject));
      }
      if (localObject != null)
      {
        paramazxr = (azxr)localObject;
        if (((String)localObject).length() != 0) {}
      }
      else
      {
        if (!ProfileActivity.AllInOne.a(localAllInOne)) {
          break label213;
        }
        paramazxr = String.valueOf(localAllInOne.jdField_a_of_type_JavaLangString);
      }
      localTextView.setText(paramazxr);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691020) + ":";
      localTextView.setContentDescription((String)localObject + paramazxr);
      localTextView.setTag(new azvr(88, localTextView.getText().toString()));
      localTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      baex.a(localTextView);
    }
    label213:
    while (!(localObject instanceof ProfileNameView)) {
      for (;;)
      {
        TextView localTextView;
        ProfileActivity.AllInOne localAllInOne;
        return;
        paramazxr = " ";
      }
    }
    ((ProfileNameView)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramazxr);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anui);
    }
    if (this.jdField_a_of_type_Blha != null) {
      this.jdField_a_of_type_Blha.removeCallbacksAndMessages(null);
    }
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qzonecover");
    if ((localView instanceof QzonePhotoView)) {
      ((QzonePhotoView)localView).a();
    }
  }
  
  public void d(azxr paramazxr)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_sex_age_area");
    String str;
    if ((localObject instanceof TextView))
    {
      localObject = (TextView)localObject;
      str = bhhz.c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramazxr);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea strInfo=" + bhjx.b(str));
      }
      if (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33) {
        break label126;
      }
      paramazxr = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698283);
      if (((TextView)localObject).getVisibility() != 0) {
        ((TextView)localObject).setVisibility(0);
      }
      ((TextView)localObject).setPadding(0, 10, 0, 0);
      ((TextView)localObject).setText(paramazxr);
      ((TextView)localObject).setContentDescription(paramazxr);
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
        ((TextView)localObject).setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131690999) + ":" + str);
        ((TextView)localObject).setClickable(true);
        return;
      }
    } while (((TextView)localObject).getVisibility() == 8);
    ((TextView)localObject).setVisibility(8);
  }
  
  public void e(azxr paramazxr)
  {
    if ((paramazxr != null) && (paramazxr.b) && (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramazxr.jdField_a_of_type_JavaLangString))) {}
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
        } while ((!(localObject1 instanceof TextView)) || (paramazxr == null) || (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null));
        localTextView = (TextView)localObject1;
        if (paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard != null) {
          break;
        }
        localTextView.setVisibility(8);
      } while (localView == null);
      localView.setVisibility(8);
      return;
      localRichStatus = paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard.getRichStatus();
      if ((ProfileActivity.AllInOne.g(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) && (localRichStatus != null)) {
        break;
      }
      if (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
      {
        localTextView.setCompoundDrawablesWithIntrinsicBounds(2130845860, 0, 0, 0);
        localTextView.setText(anzj.a(2131707373));
        localTextView.setVisibility(0);
        localTextView.setTag(new azvr(3, ""));
        localTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691080));
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
      localObject1 = (bbvd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(15);
      if (localObject1 != null)
      {
        localObject1 = ((bbvd)localObject1).a(localRichStatus.actionId, 200);
        localObject1 = new bjdm(getResources(), (Bitmap)localObject1, false, false);
        i = (int)(localTextView.getTextSize() * 1.1F + 0.5F);
        ((BitmapDrawable)localObject1).setBounds(0, 0, i, i);
        localObject1 = new bizo((Drawable)localObject1, 0);
        ((bizo)localObject1).a(-0.1F);
        localSpannableStringBuilder.setSpan(localObject1, 0, "[S]".length(), 17);
        if (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
          localTextView.setCompoundDrawablesWithIntrinsicBounds(2130845860, 0, 0, 0);
        }
        localTextView.setText(new begp(localSpannableStringBuilder, 1, 14));
        localTextView.setMovementMethod(bbwj.a());
        localTextView.setVisibility(0);
        label439:
        a(paramazxr, localView, localTextView, localRichStatus, i, localSpannableString);
        if ((paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) || (ProfileActivity.AllInOne.b(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))) {
          localTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        }
        if ((ProfileActivity.AllInOne.b(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) && (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0)) {
          localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130845861, 0);
        }
        localObject1 = new StringBuilder().append(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691080)).append(":");
        if (TextUtils.isEmpty(localSpannableString)) {
          break label645;
        }
      }
    }
    label645:
    for (paramazxr = localSpannableString.toString();; paramazxr = "")
    {
      for (;;)
      {
        localTextView.setContentDescription(paramazxr);
        return;
        try
        {
          localObject1 = BitmapFactory.decodeResource(getResources(), 2130849586);
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
      localTextView.setText(new begp(a(paramazxr, localSpannableString, localTextView), 1, 14));
      localTextView.setMovementMethod(bbwj.a());
      localTextView.setVisibility(0);
      i = 0;
      break label439;
    }
  }
  
  public void f(azxr paramazxr)
  {
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_details");
    if ((localView instanceof TextView)) {
      b((TextView)localView, paramazxr);
    }
    while (!(localView instanceof LinearLayout)) {
      return;
    }
    a((LinearLayout)localView, paramazxr);
  }
  
  public void g(azxr paramazxr)
  {
    if ((paramazxr.b) && (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramazxr.jdField_a_of_type_JavaLangString))) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    } while (!(localObject1 instanceof VoteView));
    VoteView localVoteView = (VoteView)localObject1;
    boolean bool1 = a(paramazxr);
    boolean bool2 = TextUtils.equals(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (bool1)
    {
      if (localVoteView.getVisibility() != 0) {
        localVoteView.setVisibility(0);
      }
      Object localObject2;
      int j;
      int i;
      if ((paramazxr == null) || (paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard == null))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691091);
        localObject2 = null;
        j = 0;
        i = 0;
        bool1 = false;
        localVoteView.a(bool2, bool1, i, j, this.jdField_a_of_type_Asbe, false);
        localVoteView.setTag(localObject2);
        if (paramazxr == null) {
          break label431;
        }
        localVoteView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      for (;;)
      {
        localVoteView.setContentDescription((CharSequence)localObject1);
        return;
        if (this.jdField_a_of_type_Asbe == null) {
          this.jdField_a_of_type_Asbe = new asbe(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 1);
        }
        j = (int)paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard.lVoteCount;
        i = paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard.iVoteIncrement;
        this.jdField_a_of_type_Asbe.a = paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard.getLastPraiseInfoList();
        if (i <= this.jdField_a_of_type_Asbe.a.size()) {
          this.jdField_a_of_type_Asbe.a = this.jdField_a_of_type_Asbe.a.subList(0, i);
        }
        this.jdField_a_of_type_Asbe.a = azzw.a(this.jdField_a_of_type_Asbe.a);
        if (1 == paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard.bVoted) {}
        for (bool1 = true;; bool1 = false)
        {
          if (!bool2) {
            break label364;
          }
          localObject2 = new azvr(10, paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard);
          localObject1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691089), new Object[] { String.valueOf(j) });
          k = i;
          i = j;
          j = k;
          break;
        }
        label364:
        localObject2 = new azvr(10, paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard);
        localObject1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691002), new Object[] { String.valueOf(j) });
        if (paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt == 0) {
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
  
  public void h(azxr paramazxr)
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
          if (paramazxr.b) {
            VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "group_card", "guide_show", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
          }
        }
      }
    }
  }
  
  public void i(azxr paramazxr) {}
  
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