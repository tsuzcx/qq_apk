package com.tencent.mobileqq.profilecard.base.view;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
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
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anil;
import anni;
import aoch;
import aqzp;
import aqzq;
import aqzr;
import aqzs;
import arlo;
import azde;
import azfe;
import azfy;
import azhk;
import azml;
import azmr;
import azms;
import azmt;
import azmu;
import azmv;
import azmw;
import azmx;
import azmy;
import bbck;
import bbdo;
import bbdp;
import bbdq;
import bbdu;
import bclx;
import bcst;
import bdnt;
import bgdf;
import bgdg;
import bghy;
import bgjw;
import bglf;
import bgtn;
import bhyq;
import bico;
import bkfv;
import bkqd;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.profile.view.QzonePhotoView;
import com.tencent.mobileqq.profile.view.VipPhotoViewForSimple;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mue;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f.LongNickItem;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f.RspBody;

public abstract class AbsProfileHeaderView
  extends RelativeLayout
  implements bbdp, bkqd
{
  public static String a;
  protected float a;
  public int a;
  public long a;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new azmr(this);
  public View.OnClickListener a;
  public anil a;
  protected arlo a;
  public azfe a;
  protected bkfv a;
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
  
  public AbsProfileHeaderView(BaseActivity paramBaseActivity, azfe paramazfe)
  {
    super(paramBaseActivity);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Anil = new azmy(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
    this.jdField_a_of_type_Azfe = paramazfe;
    this.jdField_a_of_type_Bkfv = new bkfv(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    paramBaseActivity = getResources().getDisplayMetrics();
    this.jdField_a_of_type_Float = paramBaseActivity.density;
    this.jdField_b_of_type_Float = Math.min(paramBaseActivity.widthPixels, paramBaseActivity.heightPixels);
    this.c = Math.max(paramBaseActivity.widthPixels, paramBaseActivity.heightPixels);
    this.jdField_a_of_type_Long = 0L;
    this.d = (this.jdField_b_of_type_Float - bclx.a(127.0F));
  }
  
  private SpannableStringBuilder a(azfe paramazfe, SpannableString paramSpannableString, TextView paramTextView)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramSpannableString);
    if (paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      localSpannableStringBuilder.insert(0, "[S] ");
      paramazfe = null;
    }
    try
    {
      paramSpannableString = BitmapFactory.decodeResource(getResources(), 2130845845);
      paramazfe = paramSpannableString;
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
    paramazfe = new bico(getResources(), paramazfe, false, false);
    i = (int)(paramTextView.getTextSize() + 0.5F);
    paramazfe.setBounds(0, 0, i, i);
    paramazfe = new bhyq(paramazfe, 0);
    paramazfe.a(-0.1F);
    localSpannableStringBuilder.setSpan(paramazfe, 0, "[S]".length(), 17);
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
    if (!azfy.a().c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      paramView.setVisibility(8);
      return;
    }
    Object localObject = aqzs.a();
    if ((localObject == null) || (((aqzp)localObject).a()))
    {
      paramView.setVisibility(8);
      return;
    }
    paramView.setVisibility(0);
    TextView localTextView = (TextView)paramView.findViewById(2131379725);
    ImageView localImageView = (ImageView)paramView.findViewById(2131369081);
    ArrayList localArrayList = ((aqzp)localObject).a().a;
    localTextView.setText(azfy.a().a((aqzp)localObject));
    int i = 0;
    int j;
    while (i < ((aqzp)localObject).a().a.size()) {
      if (TextUtils.isEmpty(((aqzr)localArrayList.get(i)).jdField_a_of_type_JavaLangString))
      {
        i += 1;
      }
      else
      {
        j = ((aqzr)localArrayList.get(i)).jdField_a_of_type_Int;
        localObject = ((aqzr)localArrayList.get(i)).jdField_a_of_type_JavaLangString;
      }
    }
    for (i = j;; i = -1)
    {
      if (paramBoolean) {
        paramView.setOnClickListener(new azms(this, (String)localObject, i, paramView));
      }
      localImageView.setOnClickListener(new azmt(this, paramView));
      bcst.b(null, "dc00898", "", "", "0X800A4D4", "0X800A4D4", 0, 0, "2", "0", "", "");
      return;
      localObject = "";
    }
  }
  
  private void a(ImageView paramImageView)
  {
    if (paramImageView != null)
    {
      paramImageView = paramImageView.getDrawable();
      if ((paramImageView instanceof aoch)) {
        ((aoch)paramImageView).a(false);
      }
    }
  }
  
  private void a(LinearLayout paramLinearLayout, azfe paramazfe)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "makeAccountDetailInfoForQQCircle");
    }
    if ((paramazfe == null) || (paramLinearLayout == null)) {
      return;
    }
    paramLinearLayout.removeAllViews();
    List localList = bghy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramazfe);
    boolean bool = localList.isEmpty();
    int i;
    int j;
    if ((paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0))
    {
      i = 1;
      if ((bool) && (i != 0)) {
        localList.add(android.util.Pair.create(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698190), ""));
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
            localTextView.setTextColor(getResources().getColor(2131166986));
            if (!TextUtils.isEmpty((CharSequence)localPair.second))
            {
              localTextView.setBackgroundResource(2130844035);
              localTextView.setPadding(bgtn.b(8.0F), bgtn.b(4.5F), bgtn.b(8.0F), bgtn.b(4.5F));
            }
            localTextView.setTextSize(14.0F);
            paramLinearLayout.addView(localTextView);
          }
          try
          {
            ((LinearLayout.LayoutParams)localTextView.getLayoutParams()).rightMargin = bgtn.b(6.0F);
            paramLinearLayout.measure(0, 0);
            QLog.d(jdField_a_of_type_JavaLangString, 2, "makeAccountDetailInfoForQQCircle " + str + ", " + this.d + ", " + paramLinearLayout.getMeasuredWidth());
            if (paramLinearLayout.getMeasuredWidth() > this.d)
            {
              paramLinearLayout.removeView(localTextView);
              paramLinearLayout.setOnTouchListener(mue.a);
              paramLinearLayout.setOnClickListener(new azmx(this, paramazfe));
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
              bghy.a(localTextView, null, null);
            }
            i += 1;
          }
        }
      }
    }
    paramLinearLayout.setVisibility(8);
  }
  
  private void a(TextView paramTextView, azfe paramazfe)
  {
    Object localObject2 = null;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "makeAccountDetailInfo");
    }
    if (paramTextView == null) {
      return;
    }
    if (paramazfe == null) {}
    for (Card localCard = null; (paramazfe == null) || (localCard == null) || (ProfileActivity.AllInOne.j(paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (ProfileActivity.AllInOne.k(paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)); localCard = paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard)
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_uin_info");
      paramTextView.setVisibility(8);
      return;
    }
    paramTextView.setVisibility(0);
    Object localObject1;
    boolean bool;
    String str1;
    if (paramazfe.b)
    {
      localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(paramazfe.jdField_a_of_type_JavaLangString, localCard.uin);
      if ((localObject1 != null) && (TextUtils.isEmpty(((TroopMemberInfo)localObject1).troopnick)) && (!TextUtils.isEmpty(localCard.strReMark))) {
        localObject2 = localCard.strNick;
      }
      for (;;)
      {
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = bglf.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localCard.uin, false);
        }
        if (!TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramazfe.jdField_a_of_type_JavaLangString)) {
          break;
        }
        localObject2 = localObject1;
        paramTextView.setVisibility(0);
        paramTextView.setSingleLine(true);
        paramTextView.setText((CharSequence)localObject1);
        paramTextView.setOnTouchListener(mue.a);
        paramTextView.setOnClickListener(new azmv(this, paramazfe));
        bghy.a(paramTextView, localCard.uin, (String)localObject2);
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
    if ((paramazfe.jdField_a_of_type_ArrayOfJavaLangString != null) && (!TextUtils.isEmpty(paramazfe.jdField_a_of_type_ArrayOfJavaLangString[5])) && (!TextUtils.equals(paramazfe.jdField_a_of_type_ArrayOfJavaLangString[5], localCard.strNick))) {}
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
  
  private void b(TextView paramTextView, azfe paramazfe)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "makeAccountDetailInfo");
    }
    if ((paramazfe == null) || (paramTextView == null)) {
      return;
    }
    List localList = bghy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramazfe);
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
    if ((paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0))
    {
      i = 1;
      if ((bool) && (i != 0)) {
        localList.add(new SpannableString(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698190)));
      }
      if (localList.isEmpty()) {
        break label577;
      }
      localSpannableStringBuilder = new SpannableStringBuilder();
      n = localList.size();
      localObject2 = bghy.a(localList, 0, n, "  ", localSpannableStringBuilder);
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
        localObject3 = bghy.a(localList, i, m, "  ", localSpannableStringBuilder);
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
        localObject1 = bghy.a(localList, i, m - 1, "  ", localSpannableStringBuilder);
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
      paramTextView.setOnTouchListener(mue.a);
      paramTextView.setOnClickListener(new azmw(this, paramazfe));
      if (bool) {
        break;
      }
      bghy.a(paramTextView, null, null);
      return;
      i = 0;
      break label67;
      label471:
      if (m - i == 1)
      {
        localObject1 = bghy.a(localList, i, n, "  ", localSpannableStringBuilder);
        if (((SpannableStringBuilder)localObject2).length() > 0) {
          ((SpannableStringBuilder)localObject2).append("\n");
        }
        ((SpannableStringBuilder)localObject2).append((CharSequence)localObject1);
        break label309;
      }
      localObject3 = bghy.a(localList, i, m - 1, "  ", localSpannableStringBuilder);
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
    if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_Bkfv != null) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      Message localMessage = this.jdField_a_of_type_Bkfv.obtainMessage(1000);
      if (localMessage != null) {
        this.jdField_a_of_type_Bkfv.sendMessage(localMessage);
      }
    }
  }
  
  private void j(azfe paramazfe)
  {
    this.jdField_b_of_type_Int &= 0xFFFFFFFD;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips_set_card");
    if (localView == null) {
      localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131562065, null);
    }
    for (;;)
    {
      if ((localView == null) || (paramazfe == null) || (paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard == null))
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        e();
        return;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tips_set_card", localView);
      if ((paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
      {
        long l1 = paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId;
        long l2 = paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId;
        int i = paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard.templateRet;
        paramazfe = paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard.getBgTypeArray();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "updateSetCardBar bgtype = " + paramazfe);
        }
        paramazfe = getResources();
        TextView localTextView = (TextView)localView.findViewById(2131367728);
        ImageView localImageView = (ImageView)localView.findViewById(2131367713);
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
        for (paramazfe = paramazfe.getString(2131694547);; paramazfe = paramazfe.getString(2131718361))
        {
          paramazfe = ((BaseActivity)localObject).getString(2131717266, new Object[] { paramazfe });
          localTextView.setText(paramazfe);
          localImageView.setContentDescription(paramazfe);
          localView.setTag(new azde(24, Integer.valueOf(i)));
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
  
  private void k(azfe paramazfe)
  {
    int j = 2;
    if (paramazfe != null)
    {
      bghy.a(paramazfe, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      int i = j;
      if (paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null)
      {
        i = j;
        if (paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
          i = 1;
        }
      }
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009999", "0X8009999", i, 0, "", "", "", "");
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
    a(this.jdField_a_of_type_Azfe);
  }
  
  public void a(int paramInt) {}
  
  protected void a(azfe paramazfe)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "ProfileHeaderView onInit");
    }
    if (paramazfe.jdField_a_of_type_Azfl != null) {
      j(paramazfe);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anil);
  }
  
  public void a(azfe paramazfe, long paramLong, boolean paramBoolean)
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
      if ((paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt == 0)) {
        ((VoteView)localObject).a();
      }
      ((VoteView)localObject).a(false, true, (int)l, 0, null, paramBoolean);
      ((VoteView)localObject).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((VoteView)localObject).setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691014), new Object[] { String.valueOf(l) }));
    }
  }
  
  public void a(azfe paramazfe, String paramString)
  {
    paramString = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_uin_info");
    if ((paramString instanceof TextView)) {
      a((TextView)paramString, paramazfe);
    }
  }
  
  public abstract void a(azfe paramazfe, boolean paramBoolean);
  
  public void a(bbdo parambbdo, View paramView)
  {
    parambbdo = parambbdo.a();
    if ((parambbdo instanceof com.tencent.util.Pair))
    {
      parambbdo = (com.tencent.util.Pair)parambbdo;
      bbdu.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, bbdu.a(((Integer)parambbdo.first).intValue(), (String)parambbdo.second), -1);
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
    String str = bghy.a(paramAllInOne);
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
  
  protected boolean a(azfe paramazfe)
  {
    boolean bool4 = false;
    boolean bool2;
    boolean bool5;
    boolean bool6;
    boolean bool1;
    if ((paramazfe != null) && (paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard != null))
    {
      bool2 = true;
      bool5 = TextUtils.equals(paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      bool6 = ProfileActivity.AllInOne.b(paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      if ((bool5) || (bool6)) {
        break label178;
      }
      if ((!bool2) || (!paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard.strangerVoteOpen)) {
        break label173;
      }
      bool1 = true;
    }
    label70:
    for (boolean bool3 = bool1 & bool2;; bool3 = bool2)
    {
      if (QLog.isColorLevel())
      {
        String str = paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
        if (bool2) {
          bool4 = paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard.strangerVoteOpen;
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
  
  public void b(azfe paramazfe)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tag_jueban");
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    if (((localObject instanceof ImageView)) && (localView != null) && (paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (a(paramazfe)) && (bghy.a(paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard.getBgTypeArray())))
    {
      ((View)localObject).setTag(new azde(34, null));
      ((View)localObject).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((View)localObject).setVisibility(0);
      localObject = "1";
      if (paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
        localObject = "0";
      }
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "card_mall", "0X8007A47", 0, 0, (String)localObject, "", "", "");
    }
  }
  
  public void b(azfe paramazfe, boolean paramBoolean)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_avatar_pendant");
    if ((localObject instanceof ImageView))
    {
      localObject = (ImageView)localObject;
      if (!ProfileActivity.AllInOne.g(paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        ((ImageView)localObject).setVisibility(4);
        this.jdField_a_of_type_Long = 0L;
      }
    }
    else
    {
      return;
    }
    ThreadManager.post(new AbsProfileHeaderView.6(this, paramazfe, paramBoolean), 8, null, true);
  }
  
  public void c() {}
  
  public void c(azfe paramazfe)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_profile_nick_name");
    if (localObject != null) {
      ((View)localObject).setBackgroundResource(2130845732);
    }
    if ((localObject instanceof TextView))
    {
      localTextView = (TextView)localObject;
      localAllInOne = paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
      localObject = paramazfe.jdField_a_of_type_Bgdg.a.jdField_a_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.FrdProfileCard", 2, "updateHead titleName = " + bgjw.b((String)localObject));
      }
      if (localObject != null)
      {
        paramazfe = (azfe)localObject;
        if (((String)localObject).length() != 0) {}
      }
      else
      {
        if (!ProfileActivity.AllInOne.a(localAllInOne)) {
          break label213;
        }
        paramazfe = String.valueOf(localAllInOne.jdField_a_of_type_JavaLangString);
      }
      localTextView.setText(paramazfe);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691020) + ":";
      localTextView.setContentDescription((String)localObject + paramazfe);
      localTextView.setTag(new azde(88, localTextView.getText().toString()));
      localTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      azml.a(localTextView);
    }
    label213:
    while (!(localObject instanceof ProfileNameView)) {
      for (;;)
      {
        TextView localTextView;
        ProfileActivity.AllInOne localAllInOne;
        return;
        paramazfe = " ";
      }
    }
    ((ProfileNameView)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramazfe);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anil);
    }
    if (this.jdField_a_of_type_Bkfv != null) {
      this.jdField_a_of_type_Bkfv.removeCallbacksAndMessages(null);
    }
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qzonecover");
    if ((localView instanceof QzonePhotoView)) {
      ((QzonePhotoView)localView).a();
    }
  }
  
  public void d(azfe paramazfe)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_sex_age_area");
    String str;
    if ((localObject instanceof TextView))
    {
      localObject = (TextView)localObject;
      str = bghy.c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramazfe);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea strInfo=" + bgjw.b(str));
      }
      if (paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33) {
        break label126;
      }
      paramazfe = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698182);
      if (((TextView)localObject).getVisibility() != 0) {
        ((TextView)localObject).setVisibility(0);
      }
      ((TextView)localObject).setPadding(0, 10, 0, 0);
      ((TextView)localObject).setText(paramazfe);
      ((TextView)localObject).setContentDescription(paramazfe);
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
  
  public void e(azfe paramazfe)
  {
    if ((paramazfe != null) && (paramazfe.b) && (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramazfe.jdField_a_of_type_JavaLangString))) {}
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
        } while ((!(localObject1 instanceof TextView)) || (paramazfe == null) || (paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null));
        localTextView = (TextView)localObject1;
        if (paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard != null) {
          break;
        }
        localTextView.setVisibility(8);
      } while (localView == null);
      localView.setVisibility(8);
      return;
      localObject4 = paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard.getRichStatus();
      if ((ProfileActivity.AllInOne.g(paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) && (localObject4 != null)) {
        break;
      }
      if (paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
      {
        localTextView.setCompoundDrawablesWithIntrinsicBounds(2130845845, 0, 0, 0);
        localTextView.setText(anni.a(2131707264));
        localTextView.setVisibility(0);
        localTextView.setTag(new azde(3, ""));
        localTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691080));
        a(localView, true);
        return;
      }
      localTextView.setVisibility(8);
    } while (localView == null);
    localView.setVisibility(8);
    return;
    SpannableString localSpannableString = new SpannableString(((RichStatus)localObject4).toSpannableStringWithTopic("", -8947849, -2039584, this));
    Object localObject5;
    int i;
    label453:
    boolean bool2;
    boolean bool1;
    if (!TextUtils.isEmpty(((RichStatus)localObject4).actionText))
    {
      localObject5 = new SpannableStringBuilder(localSpannableString);
      ((SpannableStringBuilder)localObject5).insert(0, "[S] ");
      localObject1 = (bbck)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(15);
      if (localObject1 != null)
      {
        localObject1 = ((bbck)localObject1).a(((RichStatus)localObject4).actionId, 200);
        localObject1 = new bico(getResources(), (Bitmap)localObject1, false, false);
        i = (int)(localTextView.getTextSize() * 1.1F + 0.5F);
        ((BitmapDrawable)localObject1).setBounds(0, 0, i, i);
        localObject1 = new bhyq((Drawable)localObject1, 0);
        ((bhyq)localObject1).a(-0.1F);
        ((SpannableStringBuilder)localObject5).setSpan(localObject1, 0, "[S]".length(), 17);
        if (paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
          localTextView.setCompoundDrawablesWithIntrinsicBounds(2130845845, 0, 0, 0);
        }
        localTextView.setText(new bdnt((CharSequence)localObject5, 1, 14));
        localTextView.setMovementMethod(bbdq.a());
        localTextView.setVisibility(0);
        if (localSpannableString.length() > 0)
        {
          if ((!azfy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (((RichStatus)localObject4).topics != null) && (((RichStatus)localObject4).topics.size() > 0)) {
            localTextView.post(new AbsProfileHeaderView.4(this, (RichStatus)localObject4, localTextView, i));
          }
          azfy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RichStatus)localObject4);
          bool2 = azfy.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (localView != null)
          {
            if (paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
              break label1030;
            }
            bool1 = true;
            label555:
            localObject4 = (TextView)localView.findViewById(2131379725);
            localObject5 = (ImageView)localView.findViewById(2131369081);
            localObject1 = new oidb_0xd9f.RspBody();
            if ((paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard.vLongNickTopicInfo == null)) {
              break label1091;
            }
          }
        }
      }
    }
    try
    {
      ((oidb_0xd9f.RspBody)localObject1).mergeFrom(paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard.vLongNickTopicInfo);
      localObject1 = (oidb_0xd9f.LongNickItem)((oidb_0xd9f.RspBody)localObject1).longnick_item.get();
      if (localObject1 == null) {
        break label1035;
      }
      localObject1 = ((oidb_0xd9f.LongNickItem)localObject1).rpt_topic_item.get();
      label648:
      if ((!bool2) && (!azfy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, azfy.a().a((List)localObject1)))) {
        break label1081;
      }
      if ((localObject1 == null) || (((List)localObject1).size() <= 0) || (azfy.a().a((List)localObject1) <= 0)) {
        break label1041;
      }
      localView.setTag(new azde(97, azfy.a().a((List)localObject1)));
      localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((TextView)localObject4).setText(anni.a(2131707263) + azfy.a().a((List)localObject1) + anni.a(2131707261));
      ((ImageView)localObject5).setOnClickListener(new azmu(this, localView));
      localView.setVisibility(0);
      bcst.b(null, "dc00898", "", "", "0X800A4D4", "0X800A4D4", 0, 0, "1", "0", "", "");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        label829:
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.SummaryCard", 2, localException.toString());
        }
        a(localView, bool1);
        continue;
        a(localView, bool1);
      }
    }
    if ((paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) || (ProfileActivity.AllInOne.b(paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))) {
      localTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    if ((ProfileActivity.AllInOne.b(paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) && (paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0)) {
      localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130845846, 0);
    }
    Object localObject1 = new StringBuilder().append(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691080)).append(":");
    if (!TextUtils.isEmpty(localSpannableString)) {}
    for (paramazfe = localSpannableString.toString();; paramazfe = "")
    {
      for (;;)
      {
        localTextView.setContentDescription(paramazfe);
        return;
        try
        {
          localObject1 = BitmapFactory.decodeResource(getResources(), 2130849577);
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
      i = 0;
      localTextView.setText(new bdnt(a(paramazfe, localSpannableString, localTextView), 1, 14));
      localTextView.setMovementMethod(bbdq.a());
      localTextView.setVisibility(0);
      break label453;
      label1030:
      bool1 = false;
      break label555;
      label1035:
      Object localObject3 = null;
      break label648;
      label1041:
      a(localView, bool1);
      break label829;
      label1081:
      label1091:
      a(localView, bool1);
      break label829;
    }
  }
  
  public void f(azfe paramazfe)
  {
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_details");
    if ((localView instanceof TextView)) {
      b((TextView)localView, paramazfe);
    }
    while (!(localView instanceof LinearLayout)) {
      return;
    }
    a((LinearLayout)localView, paramazfe);
  }
  
  public void g(azfe paramazfe)
  {
    if ((paramazfe.b) && (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramazfe.jdField_a_of_type_JavaLangString))) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    } while (!(localObject1 instanceof VoteView));
    VoteView localVoteView = (VoteView)localObject1;
    boolean bool1 = a(paramazfe);
    boolean bool2 = TextUtils.equals(paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (bool1)
    {
      if (localVoteView.getVisibility() != 0) {
        localVoteView.setVisibility(0);
      }
      Object localObject2;
      int j;
      int i;
      if ((paramazfe == null) || (paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard == null))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691091);
        localObject2 = null;
        j = 0;
        i = 0;
        bool1 = false;
        localVoteView.a(bool2, bool1, i, j, this.jdField_a_of_type_Arlo, false);
        localVoteView.setTag(localObject2);
        if (paramazfe == null) {
          break label431;
        }
        localVoteView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      for (;;)
      {
        localVoteView.setContentDescription((CharSequence)localObject1);
        return;
        if (this.jdField_a_of_type_Arlo == null) {
          this.jdField_a_of_type_Arlo = new arlo(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 1);
        }
        j = (int)paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard.lVoteCount;
        i = paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard.iVoteIncrement;
        this.jdField_a_of_type_Arlo.a = paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard.getLastPraiseInfoList();
        if (i <= this.jdField_a_of_type_Arlo.a.size()) {
          this.jdField_a_of_type_Arlo.a = this.jdField_a_of_type_Arlo.a.subList(0, i);
        }
        this.jdField_a_of_type_Arlo.a = azhk.a(this.jdField_a_of_type_Arlo.a);
        if (1 == paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard.bVoted) {}
        for (bool1 = true;; bool1 = false)
        {
          if (!bool2) {
            break label364;
          }
          localObject2 = new azde(10, paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard);
          localObject1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691089), new Object[] { String.valueOf(j) });
          k = i;
          i = j;
          j = k;
          break;
        }
        label364:
        localObject2 = new azde(10, paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard);
        localObject1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691002), new Object[] { String.valueOf(j) });
        if (paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt == 0) {
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
  
  public void h(azfe paramazfe)
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
          if (paramazfe.b) {
            VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "group_card", "guide_show", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
          }
        }
      }
    }
  }
  
  public void i(azfe paramazfe) {}
  
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
  
  public void setShoppingBgBlur(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
 * JD-Core Version:    0.7.0.1
 */