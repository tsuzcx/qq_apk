package com.tencent.mobileqq.richstatus;

import aepi;
import aklo;
import aklp;
import alud;
import amct;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aybq;
import aybu;
import aycb;
import aycc;
import aycd;
import ayce;
import aycf;
import aycg;
import aych;
import ayci;
import aycj;
import ayck;
import aycl;
import aycm;
import aydw;
import ayec;
import ayff;
import ayfi;
import ayfm;
import azqs;
import bamp;
import bdeu;
import bdgm;
import bdhb;
import bdin;
import bdjz;
import bdoo;
import bdtv;
import bhsj;
import bhuw;
import bjdt;
import bjea;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.app.SignatureManager.TopicInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.richstatus.topic.TopicEditTextView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XListView;
import cooperation.qzone.LbsDataV2.PoiInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppActivity;
import mww;

public class SignTextEditFragment
  extends IphoneTitleBarFragment
  implements aklp, Handler.Callback, TextWatcher, View.OnClickListener, bhuw
{
  private static final int[][] jdField_a_of_type_Array2dOfInt = { { 2130845712, Color.parseColor("#03081A"), Color.parseColor("#B0B3BF") }, { 2130845713, -1, -1 } };
  private static long jdField_b_of_type_Long;
  public int a;
  private long jdField_a_of_type_Long;
  public aklo a;
  amct jdField_a_of_type_Amct;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  public CheckBox a;
  CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new aycd(this);
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  aybu jdField_a_of_type_Aybu = new aycj(this);
  private ayec jdField_a_of_type_Ayec;
  public QQAppInterface a;
  public RichStatus a;
  TopicEditTextView jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView;
  public XListView a;
  String jdField_a_of_type_JavaLangString;
  public Observer a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public boolean a;
  int jdField_b_of_type_Int;
  public Handler b;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private aybu jdField_b_of_type_Aybu = new aycc(this);
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private int e;
  
  public SignTextEditFragment()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_JavaUtilObserver = new ayck(this);
  }
  
  private <T extends View> T a(int paramInt)
  {
    return this.mContentView.findViewById(paramInt);
  }
  
  private RichStatus a()
  {
    try
    {
      RichStatus localRichStatus = (RichStatus)bdhb.a("file_richstatus_draft_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if (QLog.isColorLevel()) {
        QLog.i("SignTextEditFragment", 2, String.format("readDraft %s", new Object[] { localRichStatus }));
      }
      return localRichStatus;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
  
  private void a(int paramInt)
  {
    if (!isAdded()) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
    localLayoutParams.topMargin = aepi.a(80.0F, getResources());
    this.jdField_d_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    if (paramInt == 1)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      try
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(ColorStateList.createFromXml(getResources(), getResources().getXml(2131166983)));
        this.jdField_d_of_type_AndroidWidgetTextView.setText(alud.a(2131714535));
        return;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SignTextEditFragment", 2, localException1.toString());
          }
        }
      }
    }
    try
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(ColorStateList.createFromXml(getResources(), getResources().getXml(2131166983)));
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849839);
      if (paramInt == 3)
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(alud.a(2131714547));
        return;
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SignTextEditFragment", 2, localException2.toString());
        }
      }
      if (paramInt == 2)
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(alud.a(2131714548));
        return;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 == this.jdField_d_of_type_Int) && (paramInt2 == this.e)) {
      if (QLog.isColorLevel()) {
        QLog.i("SignTextEditFragment", 2, "onAtKeyChanged return");
      }
    }
    long l;
    do
    {
      return;
      if (QLog.isDevelopLevel()) {
        QLog.i("SignTextEditFragment", 2, String.format("onAtKeyChanged [%d, %d, [%s] ]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString }));
      }
      this.jdField_d_of_type_Int = paramInt1;
      this.e = paramInt2;
      if ((paramInt1 < 0) || (paramInt2 <= 0) || (TextUtils.isEmpty(paramString)))
      {
        this.jdField_a_of_type_Long = 0L;
        this.jdField_a_of_type_ComTencentWidgetXListView.setTag(null);
        a();
        return;
      }
      l = a(paramString, this.jdField_d_of_type_Int, paramInt2);
    } while (l <= 0L);
    this.jdField_a_of_type_Long = l;
  }
  
  public static void a(Activity paramActivity, RichStatus paramRichStatus, String paramString, Bundle paramBundle, int paramInt)
  {
    if (System.currentTimeMillis() - jdField_b_of_type_Long < 500L) {
      return;
    }
    jdField_b_of_type_Long = System.currentTimeMillis();
    Intent localIntent = new Intent();
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    localIntent.putExtra("rich_status", paramRichStatus);
    localIntent.putExtra("template_info_text", paramString);
    PublicFragmentActivity.a(paramActivity, localIntent, SignTextEditFragment.class, paramInt);
  }
  
  private void a(CheckBox paramCheckBox, boolean paramBoolean)
  {
    paramCheckBox.setOnCheckedChangeListener(null);
    paramCheckBox.setChecked(paramBoolean);
    paramCheckBox.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
  }
  
  private void a(TextView paramTextView)
  {
    paramTextView = paramTextView.getCompoundDrawables();
    int i = aepi.a(16.0F, getResources());
    if (paramTextView[0] != null) {
      paramTextView[0].setBounds(0, 0, i, i);
    }
  }
  
  private void a(RichStatus paramRichStatus)
  {
    boolean bool1 = false;
    int i = 1;
    bdtv localbdtv = aydw.a().a(paramRichStatus.tplId);
    int j = paramRichStatus.tplId;
    if ((localbdtv.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (localbdtv.jdField_a_of_type_Bdtx != null))
    {
      boolean bool2 = localbdtv.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
      if (localbdtv.jdField_a_of_type_Bdtx != null) {
        bool1 = true;
      }
      QLog.d("SignTextEditFragment", 1, new Object[] { "insureNotImageSign set2Default tplId isParsing=", Boolean.valueOf(bool2), " isImageItem=", Boolean.valueOf(bool1) });
    }
    for (;;)
    {
      paramRichStatus.tplId = i;
      return;
      i = j;
    }
  }
  
  private void a(AdapterView<?> paramAdapterView, SignatureManager.TopicInfo paramTopicInfo)
  {
    Object localObject = paramAdapterView.getTag();
    if ((localObject instanceof Object[]))
    {
      paramAdapterView = (Object[])localObject;
      if (((Object[])localObject).length == 4)
      {
        i = ((Integer)paramAdapterView[0]).intValue();
        int j = ((Integer)paramAdapterView[1]).intValue();
        localObject = (String)paramAdapterView[2];
        if (((Long)paramAdapterView[3]).longValue() == this.jdField_a_of_type_Long) {
          a(paramTopicInfo.topicId, paramTopicInfo.topicStr, i, j);
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        if (!b(this.jdField_d_of_type_Int)) {
          break label174;
        }
        a(paramTopicInfo.topicId, paramTopicInfo.topicStr, this.jdField_d_of_type_Int, 0);
      }
      for (;;)
      {
        a(-1, 0, "");
        azqs.b(null, "dc00898", "", "", "0X800A642", "0X800A642", 0, 0, "0", "0", "", "");
        return;
        label174:
        a(paramTopicInfo.topicId, paramTopicInfo.topicStr, this.jdField_d_of_type_Int);
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    int j = bdoo.c(bdoo.a());
    if (QLog.isColorLevel()) {
      QLog.i("SignTextEditFragment", 2, "width_1x=" + j);
    }
    if ((j < 354) && (paramBoolean))
    {
      this.jdField_d_of_type_Boolean = true;
      localObject = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = bdoo.b(28.0F);
      ((RelativeLayout.LayoutParams)localObject).rightMargin += bdoo.b(8.0F);
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(11);
      ((RelativeLayout.LayoutParams)localObject).addRule(1, 0);
    }
    Object localObject = this.jdField_b_of_type_AndroidWidgetTextView.getText().toString();
    TextPaint localTextPaint = this.jdField_b_of_type_AndroidWidgetTextView.getPaint();
    int k = (int)(Layout.getDesiredWidth((CharSequence)localObject, localTextPaint) + 0.5F) - (int)(Layout.getDesiredWidth(aybq.jdField_a_of_type_JavaLangString, localTextPaint) + 0.5F);
    int i;
    if (this.jdField_d_of_type_Boolean)
    {
      i = bdoo.b(j - 16 - 85 - 4 - 85 - 4 - 93 - 4 - 8 - 16);
      if (QLog.isColorLevel()) {
        QLog.i("SignTextEditFragment", 2, String.format("isNarrow=%b widthLeft=%d needMoreLen=%d width=%d", new Object[] { Boolean.valueOf(this.jdField_d_of_type_Boolean), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) }));
      }
      localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      if (k >= i) {
        break label310;
      }
    }
    label310:
    for (((RelativeLayout.LayoutParams)localObject).width = -2;; ((RelativeLayout.LayoutParams)localObject).width = (i + bdoo.b(85.0F)))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.requestLayout();
      return;
      i = bdoo.b(j - 354);
      break;
    }
  }
  
  private boolean a()
  {
    Bundle localBundle = getArguments();
    int i;
    String str2;
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = ((RichStatus)localBundle.getSerializable("rich_status"));
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionText = null;
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionId = 0;
        this.jdField_a_of_type_JavaLangString = localBundle.getString("template_info_text");
        this.jdField_a_of_type_Int = localBundle.getInt("from_type");
        String str1;
        if (QLog.isColorLevel())
        {
          i = this.jdField_a_of_type_Int;
          if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus == null)
          {
            str1 = "null";
            QLog.i("SignTextEditFragment", 2, String.format("initData from=%d status=%s", new Object[] { Integer.valueOf(i), str1 }));
          }
        }
        else
        {
          if ((this.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Int != 2)) {
            break label283;
          }
          this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = new RichStatus(null);
          this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.copyFrom(this.jdField_a_of_type_Ayec.a(true));
          this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionText = null;
          this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionId = 0;
          i = localBundle.getInt("key_sign_topic_id", -1);
          str1 = localBundle.getString("key_sign_topic_name");
          if ((i >= 0) && (ayfm.a(str1))) {
            break;
          }
          return false;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("SignTextEditFragment", 2, localException.getMessage(), localException);
        }
        return false;
      }
      str2 = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.getPlainText();
    }
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topics.clear();
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topics.add(new Pair(Integer.valueOf(i), str2));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText = null;
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.ensureContent();
    this.jdField_c_of_type_Boolean = true;
    label283:
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus == null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = new RichStatus(null);
    }
    for (;;)
    {
      return true;
      aydw.a().a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId);
    }
  }
  
  public static boolean a(int paramInt)
  {
    return 1.0D - (0.299D * Color.red(paramInt) + 0.587D * Color.green(paramInt) + 0.114D * Color.blue(paramInt)) / 255.0D >= 0.5D;
  }
  
  private boolean a(RichStatus paramRichStatus)
  {
    String str1 = this.jdField_b_of_type_JavaLangString;
    RichStatus localRichStatus = paramRichStatus;
    if (paramRichStatus == null)
    {
      localRichStatus = new RichStatus(null);
      localRichStatus.setEmptyStatus(true);
      str1 = "";
    }
    bdhb.a("file_richstatus_draft_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localRichStatus);
    String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    paramRichStatus = str2;
    if (str2 == null) {
      paramRichStatus = "noLogin";
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(paramRichStatus, 4).edit().putString("sign_location_id_draft_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), str1).commit();
    if (QLog.isColorLevel()) {
      QLog.i("SignTextEditFragment", 2, String.format("saveDraft %s", new Object[] { localRichStatus.getPlainText() }));
    }
    return true;
  }
  
  private void b(RichStatus paramRichStatus)
  {
    if (paramRichStatus == null) {}
    for (int i = 0;; i = paramRichStatus.getTotalLenForShow())
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(i + "/" + 80);
      int j = ((Integer)this.jdField_c_of_type_AndroidWidgetTextView.getTag()).intValue();
      paramRichStatus = this.jdField_c_of_type_AndroidWidgetTextView;
      if (80 - i <= 0) {
        j = Color.parseColor("#FF596A");
      }
      paramRichStatus.setTextColor(j);
      return;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SignTextEditFragment", 2, "updateSignViewShow");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus == null) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.toSpannableStringWithoutAction(null);
    b(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus);
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        localObject2 = this.jdField_a_of_type_JavaLangString;
        localObject1 = localObject2;
        if (paramBoolean)
        {
          this.jdField_a_of_type_JavaLangString = null;
          localObject1 = localObject2;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.ensureContent();
      localObject2 = localObject1;
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.set(0, ((CharSequence)localObject1).toString());
        localObject2 = localObject1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("SignTextEditFragment", 2, String.format("updateSignViewShow content=%s", new Object[] { localObject2 }));
    }
    this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.setText(new bamp((CharSequence)localObject2, 1, 20));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.setSelection(this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.getEditableText().length());
    bhsj.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView);
    d();
    c(ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null));
  }
  
  private boolean b(int paramInt)
  {
    Editable localEditable = this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.getEditableText();
    return (paramInt >= 0) && (localEditable.length() > paramInt) && (localEditable.charAt(paramInt) == '#') && (ayfm.a(localEditable, paramInt) == null);
  }
  
  private void c(RichStatus paramRichStatus)
  {
    if ((paramRichStatus == null) || (paramRichStatus.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("SignTextEditFragment", 2, String.format("mergeByDraft empty", new Object[0]));
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("SignTextEditFragment", 2, String.format("mergeByDraft draft=%s", new Object[] { paramRichStatus }));
    }
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.ensureContent();
    if (paramRichStatus.plainText != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.clear();
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.addAll(paramRichStatus.plainText);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus != null) && (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topics != null) && (paramRichStatus.topics != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topics.clear();
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topics.addAll(paramRichStatus.topics);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus != null) && (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topicsPos != null) && (paramRichStatus.topicsPos != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topicsPos.clear();
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topicsPos.addAll(paramRichStatus.topicsPos);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.locationText = paramRichStatus.locationText;
    this.jdField_c_of_type_Boolean = true;
  }
  
  private void c(boolean paramBoolean)
  {
    if (!isAdded()) {
      return;
    }
    if (paramBoolean)
    {
      this.rightViewText.setTextColor(Color.parseColor("#A8A8A8"));
      this.rightViewText.setBackgroundDrawable(getResources().getDrawable(2130844793));
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable(getResources().getDrawable(2130844793));
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(getResources().getDrawable(2130844793));
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(getResources().getDrawable(2130844793));
      this.rightViewText.setOnTouchListener(mww.a);
      localObject = this.rightViewText;
      if (this.jdField_c_of_type_Boolean) {}
      for (float f = 1.0F;; f = 0.5F)
      {
        ((TextView)localObject).setAlpha(f);
        this.rightViewText.setEnabled(this.jdField_c_of_type_Boolean);
        return;
      }
    }
    paramBoolean = a(this.centerView.getCurrentTextColor());
    if ("2105".equals(ThemeUtil.getCurrentThemeId())) {
      paramBoolean = true;
    }
    Object localObject = jdField_a_of_type_Array2dOfInt;
    label179:
    TextView localTextView;
    if (paramBoolean)
    {
      i = 1;
      localObject = localObject[i];
      this.rightViewText.setBackgroundResource(localObject[0]);
      localTextView = this.rightViewText;
      if (!this.jdField_c_of_type_Boolean) {
        break label236;
      }
    }
    label236:
    for (int i = localObject[1];; i = localObject[2])
    {
      localTextView.setTextColor(i);
      this.rightViewText.setOnTouchListener(null);
      break;
      i = 0;
      break label179;
    }
  }
  
  private void d()
  {
    if (!isAdded()) {
      return;
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130845715);
          int i = aepi.a(16.0F, getResources());
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(i, i, i, i);
          this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
        }
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.locationText)) {
          continue;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.locationText);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-11692801);
        this.jdField_b_of_type_AndroidWidgetTextView.getBackground().setColorFilter(-11692801, PorterDuff.Mode.SRC_ATOP);
        this.jdField_b_of_type_AndroidWidgetTextView.getBackground().setAlpha(33);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setColorFilter(-11692801, PorterDuff.Mode.SRC_ATOP);
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("SignTextEditFragment", 2, localOutOfMemoryError.getMessage(), localOutOfMemoryError);
        continue;
      }
      catch (Throwable localThrowable)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("SignTextEditFragment", 2, localThrowable.getMessage(), localThrowable);
        continue;
      }
      a(false);
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-7894119);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(aybq.jdField_a_of_type_JavaLangString);
      this.jdField_b_of_type_AndroidWidgetTextView.getBackground().setColorFilter(null);
      this.jdField_b_of_type_AndroidWidgetTextView.getBackground().setAlpha(255);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setColorFilter(null);
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SignTextEditFragment", 1, "publishRichStatus");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.getTotalLenForShow() > 80)
    {
      Message localMessage = new Message();
      localMessage.what = 4;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.bOnlyHasTopic())
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.getText().length() == 0)
    {
      bdgm.a(getActivity(), 230, alud.a(2131714540), alud.a(2131714546), alud.a(2131714534), alud.a(2131714538), new aych(this), new ayci(this)).show();
      return;
    }
    f();
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SignTextEditFragment", 2, String.format("publishRichStatusReal %s [tplId=%d fontId=%d, fontType=%d]", new Object[] { this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.fontId), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.fontType) }));
    }
    RichStatus localRichStatus = new RichStatus(null);
    localRichStatus.copyFrom(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus);
    a(localRichStatus);
    this.jdField_a_of_type_Ayec.a(localRichStatus, 1);
    this.jdField_a_of_type_Ayec.a(this.jdField_a_of_type_Aybu);
  }
  
  public long a(String paramString, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Aklo != null) && ((this.jdField_a_of_type_Aklo.a() == null) || (this.jdField_a_of_type_Aklo.a().size() <= 0))) {
      a(1);
    }
    if (bdin.d(getActivity()))
    {
      SignatureHandler localSignatureHandler = (SignatureHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(41);
      if (localSignatureHandler != null)
      {
        long l = System.currentTimeMillis();
        localSignatureHandler.a(paramString, paramInt1, paramInt2, l);
        return l;
      }
    }
    else
    {
      a(2);
    }
    return 0L;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Aklo != null) && (this.jdField_a_of_type_Aklo.b() != null) && (this.jdField_a_of_type_Aklo.b().size() > 0)) {
      if (this.jdField_a_of_type_Aklo.a(this.jdField_a_of_type_Aklo.b(), false)) {
        this.jdField_a_of_type_Aklo.notifyDataSetChanged();
      }
    }
    SignatureHandler localSignatureHandler;
    do
    {
      return;
      a(1);
      if (!bdin.d(getActivity())) {
        break;
      }
      localSignatureHandler = (SignatureHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(41);
    } while (localSignatureHandler == null);
    localSignatureHandler.b();
    return;
    a(2);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt == 100)
    {
      str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = alud.a(2131714549);
      }
      QQToast.a(BaseApplication.context, 2, str, 0).a();
      return;
    }
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = alud.a(2131714544);
    }
    QQToast.a(BaseApplication.context, 1, str, 0).a();
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SignTextEditFragment", 2, String.format("onTagSelectedInsert(%d,%s) index=%d selStart=%d", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(this.jdField_d_of_type_Int), Integer.valueOf(paramInt2) }));
    }
    if ((!ayfm.a(paramString)) || (paramInt1 < 0)) {
      return;
    }
    int j = this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.getText().length();
    int i;
    if (paramInt2 < 0) {
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.getSelectionStart() >= 0) {
        i = this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.getSelectionStart();
      }
    }
    Editable localEditable;
    for (;;)
    {
      localEditable = this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.getText();
      if (localEditable.length() + paramString.length() <= 80) {
        break;
      }
      paramString = new Message();
      paramString.what = 3;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
      return;
      i = 0;
      continue;
      i = j;
      if (paramInt2 <= j) {
        i = paramInt2;
      }
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    ayff localayff = new ayff(null, ayfm.a(-11692801, -2142399233), new Pair(Integer.valueOf(paramInt1), paramString));
    if (i > 0) {
      localSpannableStringBuilder.insert(0, localEditable.subSequence(0, i));
    }
    if (localEditable.length() > i) {
      localSpannableStringBuilder.insert(localSpannableStringBuilder.length(), localEditable.subSequence(i, localEditable.length()));
    }
    localSpannableStringBuilder.insert(i, paramString);
    localSpannableStringBuilder.setSpan(localayff, i, paramString.length() + i, 33);
    if (QLog.isDevelopLevel()) {
      QLog.i("SignTextEditFragment", 2, String.format("onTagSelectedInsert [%d dstLen=%d] [src=%s,dst=%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(localSpannableStringBuilder.length()), localEditable.toString(), localSpannableStringBuilder.toString() }));
    }
    this.jdField_b_of_type_Boolean = true;
    localEditable.delete(0, localEditable.length());
    localEditable.insert(0, localSpannableStringBuilder);
    this.jdField_b_of_type_Boolean = false;
    if ((i >= 0) && (paramString.length() + i <= this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.getEditableText().length()))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.setSelection(i + paramString.length());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.setSelection(this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.getEditableText().length());
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SignTextEditFragment", 2, String.format("onTagSelectedReplace[%d,%s] index=%d len=%d", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.getText().length();
    if (paramInt2 >= i) {}
    while (!b(paramInt2)) {
      return;
    }
    if (i - paramInt3 + paramString.length() > 80)
    {
      paramString = new Message();
      paramString.what = 3;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
      return;
    }
    Editable localEditable = this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.getEditableText();
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (paramInt2 > 0) {
      localSpannableStringBuilder.insert(0, localEditable.subSequence(0, paramInt2));
    }
    if (localEditable.length() > paramInt2 + paramInt3 + 1) {
      localSpannableStringBuilder.insert(localSpannableStringBuilder.length(), localEditable.subSequence(paramInt2 + paramInt3 + 1, localEditable.length()));
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("SignTextEditFragment", 2, String.format("onTagSelectedReplace remove before=%s after=%s", new Object[] { localEditable, localSpannableStringBuilder }));
    }
    this.jdField_b_of_type_Boolean = true;
    localEditable.delete(0, localEditable.length());
    localEditable.insert(0, localSpannableStringBuilder);
    this.jdField_b_of_type_Boolean = false;
    a(paramInt1, paramString, paramInt2 + 1);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.toString().equals(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.toSpannableStringWithoutAction().toString()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SignTextEditFragment", 2, "afterTextChanged text not changed");
      }
      return;
    }
    this.jdField_c_of_type_Boolean |= true;
    c(ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.ensureContent();
    Object localObject = ayfm.a(paramEditable);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.set(0, localObject);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topics.clear();
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topics.addAll(ayfm.a(paramEditable));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topicsPos.clear();
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topicsPos.addAll(ayfm.b(paramEditable));
    b(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus);
    int i = 80 - this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.getTotalLenForShow();
    if (i >= 0) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SignTextEditFragment", 2, String.format("afterTextChanged [%s]", new Object[] { this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.getPlainText() }));
      }
      if (this.jdField_b_of_type_Boolean) {
        break;
      }
      int k = this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.getSelectionStart();
      localObject = "";
      int m = ayfm.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.getEditableText(), k);
      int j = k - 1 - m;
      i = j;
      if (j < 0) {
        i = 0;
      }
      paramEditable = (Editable)localObject;
      if (m >= 0)
      {
        paramEditable = (Editable)localObject;
        if (i > 0) {
          paramEditable = this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.getEditableText().subSequence(m + 1, k).toString();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("SignTextEditFragment", 2, String.format("------------------[selStart=%d, indexAt=%d, len=%d key=[%s] ]", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), paramEditable }));
      }
      a(m, i, paramEditable);
      return;
      ayfm.a(paramEditable, i, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
      localObject = new Message();
      ((Message)localObject).what = 4;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      localObject = ayfm.a(paramEditable);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.set(0, localObject);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topics.clear();
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topics.addAll(ayfm.a(paramEditable));
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topicsPos.clear();
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topicsPos.addAll(ayfm.b(paramEditable));
    }
  }
  
  void b()
  {
    bhsj.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView);
    if (Build.VERSION.SDK_INT > 23)
    {
      FragmentActivity localFragmentActivity = getActivity();
      if (localFragmentActivity != null)
      {
        if (localFragmentActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
          localFragmentActivity.requestPermissions(new aycl(this, localFragmentActivity), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
        }
      }
      else {
        return;
      }
      c();
      return;
    }
    c();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt3;
  }
  
  public void c()
  {
    bjea localbjea = bjea.a();
    localbjea.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localbjea.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getString("sign_location_id_draft_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "");
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getString("sign_location_id_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "");
      }
    }
    Bundle localBundle = new Bundle();
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      localBundle.putInt("key_lbs_state", 1);
      localBundle.putString("key_current_poi_id", this.jdField_b_of_type_JavaLangString);
    }
    bjdt.a(getActivity(), localbjea, 18, localBundle);
    getActivity().overridePendingTransition(2130771979, 2130771990);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle(getString(2131692028));
    setRightButtonText(alud.a(2131714539), this);
    this.jdField_a_of_type_Ayec = ((ayec)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(15));
    if (!a())
    {
      getActivity().finish();
      return;
    }
    this.rightViewText.setBackgroundDrawable(getResources().getDrawable(2130844792));
    paramLayoutInflater = (RelativeLayout.LayoutParams)this.rightViewText.getLayoutParams();
    paramLayoutInflater.height = aepi.a(29.0F, getResources());
    paramLayoutInflater.width = aepi.a(60.0F, getResources());
    paramLayoutInflater.setMargins(0, 0, aepi.a(14.0F, getResources()), 0);
    this.rightViewText.setGravity(17);
    this.rightViewText.setLayoutParams(paramLayoutInflater);
    this.rightViewText.setTextSize(1, 14.0F);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView = ((TopicEditTextView)a(2131365616));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.setMovementMethod(ayfi.a());
    this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.addTextChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.setOnEditorActionListener(new aycb(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131362078));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131362074));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(mww.a);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnTouchListener(mww.a);
    a(this.jdField_a_of_type_AndroidWidgetTextView);
    a(this.jdField_b_of_type_AndroidWidgetTextView);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131369391));
    this.jdField_c_of_type_AndroidWidgetTextView.setTag(new Integer(-5196865));
    this.jdField_a_of_type_AndroidViewView = a(2131369728);
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)a(2131364046));
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(mww.a);
    paramLayoutInflater = this.jdField_a_of_type_AndroidWidgetCheckBox;
    boolean bool;
    if ((this.jdField_a_of_type_Ayec != null) && (this.jdField_a_of_type_Ayec.b()))
    {
      bool = true;
      paramLayoutInflater.setChecked(bool);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      a(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131366461));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131365591));
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)a(2131369570));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new ayce(this));
      this.jdField_b_of_type_AndroidViewView = a(2131365761);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131365740));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131365752));
      this.jdField_a_of_type_Aklo = new aklo(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, this);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Aklo);
      this.jdField_a_of_type_ComTencentWidgetXListView.setEmptyView(this.jdField_b_of_type_AndroidViewView);
      if (this.jdField_a_of_type_Ayec != null) {
        this.jdField_a_of_type_Ayec.a(this.jdField_b_of_type_Aybu);
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(0);
      b(false);
      if ((getActivity() != null) && (getActivity().getWindow() != null)) {
        getActivity().getWindow().setSoftInputMode(32);
      }
      if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        break label727;
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(Color.parseColor("#000000"));
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#000000"));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(Color.parseColor("#000000"));
    }
    for (;;)
    {
      azqs.b(null, "dc00898", "", "", "0X800A63E", "0X800A63E", 0, 0, "0", "0", "", "");
      return;
      bool = false;
      break;
      label727:
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(Color.parseColor("#ffffff"));
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#f5f6fa"));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(Color.parseColor("#ffffff"));
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131561314;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      paramMessage = a();
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, paramMessage).sendToTarget();
      continue;
      a((RichStatus)paramMessage.obj);
      continue;
      paramMessage = (RichStatus)paramMessage.obj;
      if ((this.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Int != 2))
      {
        c(paramMessage);
        b(true);
        continue;
        a((RichStatus)paramMessage.obj);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(7);
        continue;
        if (getActivity() != null)
        {
          getActivity().finish();
          continue;
          QQToast.a(getActivity(), 1, alud.a(2131714542), 1).a();
          continue;
          QQToast.a(getActivity(), 1, alud.a(2131714532), 1).a();
          continue;
          QQToast.a(getActivity(), 1, alud.a(2131714537), 1).a();
          continue;
          a();
        }
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.i("SignTextEditFragment", 2, String.format("onActivityResult requestCode=0x%x resultCode=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    if (paramInt1 == 17)
    {
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        paramInt1 = paramIntent.getIntExtra("key_sign_topic_id", -1);
        paramIntent = paramIntent.getStringExtra("key_sign_topic_name");
        if ((paramInt1 > 0) && (!TextUtils.isEmpty(paramIntent))) {
          a(paramInt1, paramIntent, this.jdField_d_of_type_Int);
        }
      }
      this.jdField_d_of_type_Int = -1;
      this.e = 0;
    }
    for (;;)
    {
      return;
      if ((paramInt1 == 18) && (paramIntent != null))
      {
        paramIntent = (LbsDataV2.PoiInfo)paramIntent.getParcelableExtra("key_select_poi");
        String str = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.locationText;
        if (paramIntent == null) {
          this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.locationText = "";
        }
        while (!bdeu.a(str, this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.locationText))
        {
          this.jdField_c_of_type_Boolean = true;
          b(false);
          return;
          if (paramIntent.poiName.equals(alud.a(2131714545)))
          {
            this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.locationText = "";
            this.jdField_b_of_type_JavaLangString = "";
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.locationText = paramIntent.poiName;
            this.jdField_b_of_type_JavaLangString = paramIntent.poiId;
          }
        }
      }
    }
  }
  
  public boolean onBackEvent()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null) {
      return false;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("publish_ever", this.jdField_a_of_type_Boolean);
    localFragmentActivity.setResult(-1, localIntent);
    int i = this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.getText().length();
    if (QLog.isColorLevel()) {
      QLog.i("SignTextEditFragment", 2, String.format("onBackEvent len=%d bChanged=%b bPublishEver=%b", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.jdField_c_of_type_Boolean), Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    }
    if ((this.jdField_c_of_type_Boolean) && (i > 0) && (isAdded())) {
      bdgm.a(getActivity(), alud.a(2131714536), 2131720749, 2131720748, new aycf(this), new aycg(this)).show();
    }
    for (;;)
    {
      return true;
      if ((i == 0) || ((!this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Boolean))) {
        this.jdField_b_of_type_AndroidOsHandler.obtainMessage(6, null).sendToTarget();
      } else {
        localFragmentActivity.finish();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    if (paramView.getId() == this.rightViewText.getId())
    {
      azqs.b(null, "dc00898", "", "", "0X800A63F", "0X800A63F", 0, 0, "0", "0", "", "");
      if (!bdin.d(getActivity()))
      {
        QQToast.a(getActivity(), 2131693417, 0).a();
        return;
      }
      e();
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131362074: 
      b();
      azqs.b(null, "dc00898", "", "", "0X800A641", "0X800A641", 0, 0, "0", "0", "", "");
      return;
    case 2131362078: 
      this.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.getSelectionStart();
      ayfm.a(getActivity(), "https://ti.qq.com/signature/searchtopic?_wv=3&&_wwv=128", 17);
      azqs.b(null, "dc00898", "", "", "0X800A640", "0X800A640", 0, 0, "0", "0", "", "");
      return;
    }
    paramView = this.jdField_a_of_type_AndroidWidgetCheckBox;
    if (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
      bool = true;
    }
    paramView.setChecked(bool);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Amct = new aycm(this, null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amct);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Ayec.b(this.jdField_b_of_type_Aybu);
    this.jdField_a_of_type_Ayec.b(this.jdField_a_of_type_Aybu);
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amct);
    aydw.a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.jdField_a_of_type_Aklo != null) && (this.jdField_a_of_type_Aklo.a() != null) && (this.jdField_a_of_type_Aklo.a().size() > paramInt)) {
      a(paramAdapterView, this.jdField_a_of_type_Aklo.a(paramInt));
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignTextEditFragment
 * JD-Core Version:    0.7.0.1
 */