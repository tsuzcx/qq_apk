package com.tencent.mobileqq.richstatus;

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
import com.tencent.av.utils.UITools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.adapter.TopicListAdapter;
import com.tencent.mobileqq.adapter.TopicListAdapter.IAddTopicListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.app.SignatureManager.TopicInfo;
import com.tencent.mobileqq.app.SignatureObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.richstatus.topic.ClickColorTopicSpan;
import com.tencent.mobileqq.richstatus.topic.StateColorMovementMethod;
import com.tencent.mobileqq.richstatus.topic.TopicEditTextView;
import com.tencent.mobileqq.richstatus.topic.TopicUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.Pair;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import cooperation.qzone.LbsDataV2.PoiInfo;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppActivity;

public class SignTextEditFragment
  extends IphoneTitleBarFragment
  implements Handler.Callback, TextWatcher, View.OnClickListener, TopicListAdapter.IAddTopicListener, AdapterView.OnItemClickListener
{
  private static final int[][] jdField_a_of_type_Array2dOfInt = { { 2130846314, Color.parseColor("#03081A"), Color.parseColor("#B0B3BF") }, { 2130846315, -1, -1 } };
  private static long jdField_b_of_type_Long;
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  View jdField_a_of_type_AndroidViewView;
  CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new SignTextEditFragment.11(this);
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  TopicListAdapter jdField_a_of_type_ComTencentMobileqqAdapterTopicListAdapter;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  SignatureObserver jdField_a_of_type_ComTencentMobileqqAppSignatureObserver;
  IStatusListener jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener = new SignTextEditFragment.7(this);
  RichStatus jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  TopicEditTextView jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  String jdField_a_of_type_JavaLangString;
  public Observer a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  Handler jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private IStatusListener jdField_b_of_type_ComTencentMobileqqRichstatusIStatusListener = new SignTextEditFragment.10(this);
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString = null;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = -1;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private int e = 0;
  
  public SignTextEditFragment()
  {
    this.jdField_a_of_type_JavaUtilObserver = new SignTextEditFragment.8(this);
  }
  
  private <T extends View> T a(int paramInt)
  {
    return this.mContentView.findViewById(paramInt);
  }
  
  private RichStatus a()
  {
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("file_richstatus_draft_");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localObject = (RichStatus)FileUtils.readObject(((StringBuilder)localObject).toString());
    }
    catch (Exception localException)
    {
      Object localObject;
      label41:
      break label41;
    }
    localObject = null;
    if (QLog.isColorLevel()) {
      QLog.i("SignTextEditFragment", 2, String.format("readDraft %s", new Object[] { localObject }));
    }
    return localObject;
  }
  
  private void a(int paramInt)
  {
    if (!isAdded()) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
    localLayoutParams.topMargin = AIOUtils.b(80.0F, getResources());
    this.jdField_d_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    if (paramInt == 1)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      try
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(ColorStateList.createFromXml(getResources(), getResources().getXml(2131167144)));
      }
      catch (Exception localException1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SignTextEditFragment", 2, localException1.toString());
        }
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131714018));
      return;
    }
    try
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(ColorStateList.createFromXml(getResources(), getResources().getXml(2131167144)));
    }
    catch (Exception localException2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SignTextEditFragment", 2, localException2.toString());
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850811);
    if (paramInt == 3)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131714030));
      return;
    }
    if (paramInt == 2)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131714031));
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 == this.jdField_d_of_type_Int) && (paramInt2 == this.e))
    {
      if (QLog.isColorLevel()) {
        QLog.i("SignTextEditFragment", 2, "onAtKeyChanged return");
      }
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("SignTextEditFragment", 2, String.format("onAtKeyChanged [%d, %d, [%s] ]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString }));
    }
    this.jdField_d_of_type_Int = paramInt1;
    this.e = paramInt2;
    if ((paramInt1 >= 0) && (paramInt2 > 0) && (!TextUtils.isEmpty(paramString)))
    {
      long l = a(paramString, this.jdField_d_of_type_Int, paramInt2);
      if (l > 0L) {
        this.jdField_a_of_type_Long = l;
      }
    }
    else
    {
      this.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_ComTencentWidgetXListView.setTag(null);
      a();
    }
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
    int i = AIOUtils.b(16.0F, getResources());
    if (paramTextView[0] != null) {
      paramTextView[0].setBounds(0, 0, i, i);
    }
  }
  
  private void a(RichStatus paramRichStatus)
  {
    SignatureTemplateInfo localSignatureTemplateInfo = SignatureManagerForTool.a().a(paramRichStatus.tplId);
    int i = paramRichStatus.tplId;
    if ((localSignatureTemplateInfo.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (localSignatureTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$ImageItem != null))
    {
      boolean bool1 = false;
      boolean bool2 = localSignatureTemplateInfo.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
      if (localSignatureTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$ImageItem != null) {
        bool1 = true;
      }
      QLog.d("SignTextEditFragment", 1, new Object[] { "insureNotImageSign set2Default tplId isParsing=", Boolean.valueOf(bool2), " isImageItem=", Boolean.valueOf(bool1) });
      i = 1;
    }
    paramRichStatus.tplId = i;
  }
  
  private void a(AdapterView<?> paramAdapterView, SignatureManager.TopicInfo paramTopicInfo)
  {
    if (paramTopicInfo == null) {
      return;
    }
    paramAdapterView = paramAdapterView.getTag();
    boolean bool = paramAdapterView instanceof Object[];
    int i = 1;
    if (bool)
    {
      paramAdapterView = (Object[])paramAdapterView;
      if (paramAdapterView.length == 4)
      {
        int j = ((Integer)paramAdapterView[0]).intValue();
        int k = ((Integer)paramAdapterView[1]).intValue();
        String str = (String)paramAdapterView[2];
        if (((Long)paramAdapterView[3]).longValue() == this.jdField_a_of_type_Long)
        {
          a(paramTopicInfo.topicId, paramTopicInfo.topicStr, j, k);
          break label105;
        }
      }
    }
    i = 0;
    label105:
    if (i == 0) {
      if (b(this.jdField_d_of_type_Int)) {
        a(paramTopicInfo.topicId, paramTopicInfo.topicStr, this.jdField_d_of_type_Int, 0);
      } else {
        a(paramTopicInfo.topicId, paramTopicInfo.topicStr, this.jdField_d_of_type_Int);
      }
    }
    a(-1, 0, "");
    ReportController.b(null, "dc00898", "", "", "0X800A642", "0X800A642", 0, 0, "0", "0", "", "");
  }
  
  private void a(boolean paramBoolean)
  {
    int j = ViewUtils.c(ViewUtils.a());
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("width_1x=");
      ((StringBuilder)localObject).append(j);
      QLog.i("SignTextEditFragment", 2, ((StringBuilder)localObject).toString());
    }
    if ((j < 354) && (paramBoolean))
    {
      this.jdField_d_of_type_Boolean = true;
      localObject = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = ViewUtils.b(28.0F);
      ((RelativeLayout.LayoutParams)localObject).rightMargin += ViewUtils.b(8.0F);
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(11);
      ((RelativeLayout.LayoutParams)localObject).addRule(1, 0);
    }
    Object localObject = this.jdField_b_of_type_AndroidWidgetTextView.getText().toString();
    TextPaint localTextPaint = this.jdField_b_of_type_AndroidWidgetTextView.getPaint();
    int k = (int)(Layout.getDesiredWidth((CharSequence)localObject, localTextPaint) + 0.5F) - (int)(Layout.getDesiredWidth(IConst.jdField_a_of_type_JavaLangString, localTextPaint) + 0.5F);
    int i;
    if (this.jdField_d_of_type_Boolean) {
      i = ViewUtils.b(j - 16 - 85 - 4 - 85 - 4 - 93 - 4 - 8 - 16);
    } else {
      i = ViewUtils.b(j - 354);
    }
    if (QLog.isColorLevel()) {
      QLog.i("SignTextEditFragment", 2, String.format("isNarrow=%b widthLeft=%d needMoreLen=%d width=%d", new Object[] { Boolean.valueOf(this.jdField_d_of_type_Boolean), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) }));
    }
    localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
    if (k < i) {
      ((RelativeLayout.LayoutParams)localObject).width = -2;
    } else {
      ((RelativeLayout.LayoutParams)localObject).width = (ViewUtils.b(85.0F) + i);
    }
    this.jdField_b_of_type_AndroidWidgetTextView.requestLayout();
  }
  
  private boolean a()
  {
    Bundle localBundle = getArguments();
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = ((RichStatus)localBundle.getSerializable("rich_status"));
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionText = null;
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionId = 0;
      }
      this.jdField_a_of_type_JavaLangString = localBundle.getString("template_info_text");
      this.jdField_a_of_type_Int = localBundle.getInt("from_type");
      Object localObject;
      if (QLog.isColorLevel())
      {
        i = this.jdField_a_of_type_Int;
        localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
        if (localObject == null) {
          localObject = "null";
        } else {
          localObject = ((RichStatus)localObject).getPlainText();
        }
        QLog.i("SignTextEditFragment", 2, String.format("initData from=%d status=%s", new Object[] { Integer.valueOf(i), localObject }));
      }
      int i = this.jdField_a_of_type_Int;
      if ((i == 1) || (i == 2))
      {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = new RichStatus(null);
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.copyFrom(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(true));
        localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
        ((RichStatus)localObject).actionText = null;
        ((RichStatus)localObject).actionId = 0;
        i = localBundle.getInt("key_sign_topic_id", -1);
        localObject = localBundle.getString("key_sign_topic_name");
        if (i >= 0)
        {
          if (!TopicUtil.a((String)localObject)) {
            return false;
          }
          this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topics.clear();
          this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topics.add(new Pair(Integer.valueOf(i), localObject));
          localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
          ((RichStatus)localObject).plainText = null;
          ((RichStatus)localObject).ensureContent();
          this.jdField_c_of_type_Boolean = true;
        }
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = new RichStatus(null);
          return true;
        }
        SignatureManagerForTool.a().a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId);
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SignTextEditFragment", 2, localException.getMessage(), localException);
      }
    }
    return false;
  }
  
  public static boolean a(int paramInt)
  {
    double d1 = Color.red(paramInt);
    Double.isNaN(d1);
    double d2 = Color.green(paramInt);
    Double.isNaN(d2);
    double d3 = Color.blue(paramInt);
    Double.isNaN(d3);
    return 1.0D - (d1 * 0.299D + d2 * 0.587D + d3 * 0.114D) / 255.0D >= 0.5D;
  }
  
  private boolean a(RichStatus paramRichStatus)
  {
    String str = this.jdField_b_of_type_JavaLangString;
    RichStatus localRichStatus = paramRichStatus;
    if (paramRichStatus == null)
    {
      localRichStatus = new RichStatus(null);
      localRichStatus.setEmptyStatus(true);
      str = "";
    }
    paramRichStatus = new StringBuilder();
    paramRichStatus.append("file_richstatus_draft_");
    paramRichStatus.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    FileUtils.writeObject(paramRichStatus.toString(), localRichStatus);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    paramRichStatus = (RichStatus)localObject;
    if (localObject == null) {
      paramRichStatus = "noLogin";
    }
    paramRichStatus = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(paramRichStatus, 4).edit();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sign_location_id_draft_");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    paramRichStatus.putString(((StringBuilder)localObject).toString(), str).commit();
    if (QLog.isColorLevel()) {
      QLog.i("SignTextEditFragment", 2, String.format("saveDraft %s", new Object[] { localRichStatus.getPlainText() }));
    }
    return true;
  }
  
  private void b(RichStatus paramRichStatus)
  {
    int i;
    if (paramRichStatus == null) {
      i = 0;
    } else {
      i = paramRichStatus.getTotalLenForShow();
    }
    paramRichStatus = this.jdField_c_of_type_AndroidWidgetTextView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    localStringBuilder.append("/");
    localStringBuilder.append(80);
    paramRichStatus.setText(localStringBuilder.toString());
    int j = ((Integer)this.jdField_c_of_type_AndroidWidgetTextView.getTag()).intValue();
    paramRichStatus = this.jdField_c_of_type_AndroidWidgetTextView;
    if (80 - i <= 0) {
      j = Color.parseColor("#FF596A");
    }
    paramRichStatus.setTextColor(j);
  }
  
  private void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SignTextEditFragment", 2, "updateSignViewShow");
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((RichStatus)localObject1).toSpannableStringWithoutAction(null);
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
    this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.setText(new QQText((CharSequence)localObject2, 1, 20));
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView;
    ((TopicEditTextView)localObject1).setSelection(((TopicEditTextView)localObject1).getEditableText().length());
    InputMethodUtil.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView);
    d();
    c(ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null));
  }
  
  private boolean b(int paramInt)
  {
    Editable localEditable = this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.getEditableText();
    return (paramInt >= 0) && (localEditable.length() > paramInt) && (localEditable.charAt(paramInt) == '#') && (TopicUtil.a(localEditable, paramInt) == null);
  }
  
  private void c(RichStatus paramRichStatus)
  {
    if ((paramRichStatus != null) && (!paramRichStatus.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("SignTextEditFragment", 2, String.format("mergeByDraft draft=%s", new Object[] { paramRichStatus }));
      }
      RichStatus localRichStatus = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
      if (localRichStatus != null)
      {
        localRichStatus.ensureContent();
        if (paramRichStatus.plainText != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.clear();
          this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.addAll(paramRichStatus.plainText);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topics != null) && (paramRichStatus.topics != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topics.clear();
          this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topics.addAll(paramRichStatus.topics);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topicsPos != null) && (paramRichStatus.topicsPos != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topicsPos.clear();
          this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topicsPos.addAll(paramRichStatus.topicsPos);
        }
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.locationText = paramRichStatus.locationText;
        this.jdField_c_of_type_Boolean = true;
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("SignTextEditFragment", 2, String.format("mergeByDraft empty", new Object[0]));
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (!isAdded()) {
      return;
    }
    Object localObject;
    if (paramBoolean)
    {
      this.rightViewText.setTextColor(Color.parseColor("#A8A8A8"));
      this.rightViewText.setBackgroundDrawable(getResources().getDrawable(2130845201));
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable(getResources().getDrawable(2130845201));
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(getResources().getDrawable(2130845201));
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(getResources().getDrawable(2130845201));
      this.rightViewText.setOnTouchListener(UITools.a);
      localObject = this.rightViewText;
      float f;
      if (this.jdField_c_of_type_Boolean) {
        f = 1.0F;
      } else {
        f = 0.5F;
      }
      ((TextView)localObject).setAlpha(f);
    }
    else
    {
      paramBoolean = a(this.centerView.getCurrentTextColor());
      if ("2105".equals(ThemeUtil.getCurrentThemeId())) {
        paramBoolean = true;
      }
      localObject = jdField_a_of_type_Array2dOfInt;
      int i;
      if (paramBoolean) {
        i = 1;
      } else {
        i = 0;
      }
      localObject = localObject[i];
      this.rightViewText.setBackgroundResource(localObject[0]);
      TextView localTextView = this.rightViewText;
      if (this.jdField_c_of_type_Boolean) {
        i = localObject[1];
      } else {
        i = localObject[2];
      }
      localTextView.setTextColor(i);
      this.rightViewText.setOnTouchListener(null);
    }
    this.rightViewText.setEnabled(this.jdField_c_of_type_Boolean);
  }
  
  private void d()
  {
    if (!isAdded()) {
      return;
    }
    try
    {
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130846320);
        int i = AIOUtils.b(16.0F, getResources());
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(i, i, i, i);
        this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.locationText))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.locationText);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-11692801);
        this.jdField_b_of_type_AndroidWidgetTextView.getBackground().setColorFilter(-11692801, PorterDuff.Mode.SRC_ATOP);
        this.jdField_b_of_type_AndroidWidgetTextView.getBackground().setAlpha(33);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setColorFilter(-11692801, PorterDuff.Mode.SRC_ATOP);
      }
      else
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-7894119);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(IConst.jdField_a_of_type_JavaLangString);
        this.jdField_b_of_type_AndroidWidgetTextView.getBackground().setColorFilter(null);
        this.jdField_b_of_type_AndroidWidgetTextView.getBackground().setAlpha(255);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setColorFilter(null);
      }
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SignTextEditFragment", 2, localThrowable.getMessage(), localThrowable);
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SignTextEditFragment", 2, localOutOfMemoryError.getMessage(), localOutOfMemoryError);
      }
    }
    a(false);
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
      DialogUtil.a(getBaseActivity(), 230, HardCodeUtil.a(2131714023), HardCodeUtil.a(2131714029), HardCodeUtil.a(2131714017), HardCodeUtil.a(2131714021), new SignTextEditFragment.5(this), new SignTextEditFragment.6(this)).show();
      return;
    }
    f();
  }
  
  private void f()
  {
    if (QLog.isColorLevel())
    {
      localRichStatus = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
      QLog.i("SignTextEditFragment", 2, String.format("publishRichStatusReal %s [tplId=%d fontId=%d, fontType=%d]", new Object[] { localRichStatus, Integer.valueOf(localRichStatus.tplId), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.fontId), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.fontType) }));
    }
    RichStatus localRichStatus = new RichStatus(null);
    localRichStatus.copyFrom(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus);
    a(localRichStatus);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(localRichStatus, 1);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener);
  }
  
  public long a(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAdapterTopicListAdapter;
    if ((localObject != null) && ((((TopicListAdapter)localObject).a() == null) || (this.jdField_a_of_type_ComTencentMobileqqAdapterTopicListAdapter.a().size() <= 0))) {
      a(1);
    }
    if (NetworkUtil.isNetSupport(getBaseActivity()))
    {
      localObject = (SignatureHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SIGNATURE_HANDLER);
      if (localObject != null)
      {
        long l = System.currentTimeMillis();
        ((SignatureHandler)localObject).a(paramString, paramInt1, paramInt2, l);
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAdapterTopicListAdapter;
    if ((localObject != null) && (((TopicListAdapter)localObject).b() != null) && (this.jdField_a_of_type_ComTencentMobileqqAdapterTopicListAdapter.b().size() > 0))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAdapterTopicListAdapter;
      if (((TopicListAdapter)localObject).a(((TopicListAdapter)localObject).b(), false)) {
        this.jdField_a_of_type_ComTencentMobileqqAdapterTopicListAdapter.notifyDataSetChanged();
      }
      return;
    }
    a(1);
    if (NetworkUtil.isNetSupport(getBaseActivity()))
    {
      localObject = (SignatureHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SIGNATURE_HANDLER);
      if (localObject != null) {
        ((SignatureHandler)localObject).b();
      }
    }
    else
    {
      a(2);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt == 100)
    {
      str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = HardCodeUtil.a(2131714032);
      }
      QQToast.a(BaseApplication.context, 2, str, 0).a();
      return;
    }
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = HardCodeUtil.a(2131714027);
    }
    QQToast.a(BaseApplication.context, 1, str, 0).a();
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SignTextEditFragment", 2, String.format("onTagSelectedInsert(%d,%s) index=%d selStart=%d", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(this.jdField_d_of_type_Int), Integer.valueOf(paramInt2) }));
    }
    if (TopicUtil.a(paramString))
    {
      if (paramInt1 < 0) {
        return;
      }
      int j = this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.getText().length();
      int i;
      if (paramInt2 < 0)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.getSelectionStart() >= 0) {
          i = this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.getSelectionStart();
        } else {
          i = 0;
        }
      }
      else
      {
        i = paramInt2;
        if (paramInt2 > j) {
          i = j;
        }
      }
      Editable localEditable = this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.getText();
      if (localEditable.length() + paramString.length() > 80)
      {
        paramString = new Message();
        paramString.what = 3;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
        return;
      }
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      ClickColorTopicSpan localClickColorTopicSpan = new ClickColorTopicSpan(null, TopicUtil.a(-11692801, -2142399233), new Pair(Integer.valueOf(paramInt1), paramString));
      if (i > 0) {
        localSpannableStringBuilder.insert(0, localEditable.subSequence(0, i));
      }
      if (localEditable.length() > i) {
        localSpannableStringBuilder.insert(localSpannableStringBuilder.length(), localEditable.subSequence(i, localEditable.length()));
      }
      localSpannableStringBuilder.insert(i, paramString);
      localSpannableStringBuilder.setSpan(localClickColorTopicSpan, i, paramString.length() + i, 33);
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
      paramString = this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView;
      paramString.setSelection(paramString.getEditableText().length());
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SignTextEditFragment", 2, String.format("onTagSelectedReplace[%d,%s] index=%d len=%d", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.getText().length();
    if (paramInt2 >= i) {
      return;
    }
    if (!b(paramInt2)) {
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
    i = localEditable.length();
    paramInt3 = paramInt3 + paramInt2 + 1;
    if (i > paramInt3) {
      localSpannableStringBuilder.insert(localSpannableStringBuilder.length(), localEditable.subSequence(paramInt3, localEditable.length()));
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
    Object localObject = TopicUtil.a(paramEditable);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.set(0, localObject);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topics.clear();
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topics.addAll(TopicUtil.a(paramEditable));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topicsPos.clear();
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topicsPos.addAll(TopicUtil.b(paramEditable));
    b(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus);
    int i = 80 - this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.getTotalLenForShow();
    if (i < 0)
    {
      TopicUtil.a(paramEditable, i, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
      localObject = new Message();
      ((Message)localObject).what = 4;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      localObject = TopicUtil.a(paramEditable);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.set(0, localObject);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topics.clear();
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topics.addAll(TopicUtil.a(paramEditable));
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topicsPos.clear();
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topicsPos.addAll(TopicUtil.b(paramEditable));
    }
    if (QLog.isColorLevel()) {
      QLog.i("SignTextEditFragment", 2, String.format("afterTextChanged [%s]", new Object[] { this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.getPlainText() }));
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      int k = this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.getSelectionStart();
      int m = TopicUtil.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.getEditableText(), k);
      int j = k - 1 - m;
      i = j;
      if (j < 0) {
        i = 0;
      }
      if ((m >= 0) && (i > 0)) {
        paramEditable = this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.getEditableText().subSequence(m + 1, k).toString();
      } else {
        paramEditable = "";
      }
      if (QLog.isColorLevel()) {
        QLog.i("SignTextEditFragment", 2, String.format("------------------[selStart=%d, indexAt=%d, len=%d key=[%s] ]", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), paramEditable }));
      }
      a(m, i, paramEditable);
    }
  }
  
  void b()
  {
    InputMethodUtil.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView);
    if (Build.VERSION.SDK_INT > 23)
    {
      BaseActivity localBaseActivity = getBaseActivity();
      if (localBaseActivity != null)
      {
        if (localBaseActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
        {
          localBaseActivity.requestPermissions(new SignTextEditFragment.9(this, localBaseActivity), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
          return;
        }
        c();
      }
    }
    else
    {
      c();
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt3;
  }
  
  void c()
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
    localUserInfo.qzone_uin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localUserInfo.nickname = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sign_location_id_draft_");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      this.jdField_b_of_type_JavaLangString = ((SharedPreferences)localObject).getString(localStringBuilder.toString(), "");
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("sign_location_id_");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        this.jdField_b_of_type_JavaLangString = ((SharedPreferences)localObject).getString(localStringBuilder.toString(), "");
      }
    }
    Object localObject = new Bundle();
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      ((Bundle)localObject).putInt("key_lbs_state", 1);
      ((Bundle)localObject).putString("key_current_poi_id", this.jdField_b_of_type_JavaLangString);
    }
    QZoneHelper.forwardToMoodSelectLocation(getBaseActivity(), localUserInfo, 18, (Bundle)localObject);
    getBaseActivity().overridePendingTransition(2130771993, 2130772004);
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle(getString(2131691866));
    setRightButtonText(HardCodeUtil.a(2131714022), this);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER));
    if (!a())
    {
      getBaseActivity().finish();
      return;
    }
    this.rightViewText.setBackgroundDrawable(getResources().getDrawable(2130845200));
    paramLayoutInflater = (RelativeLayout.LayoutParams)this.rightViewText.getLayoutParams();
    paramLayoutInflater.height = AIOUtils.b(29.0F, getResources());
    paramLayoutInflater.width = AIOUtils.b(60.0F, getResources());
    paramLayoutInflater.setMargins(0, 0, AIOUtils.b(14.0F, getResources()), 0);
    this.rightViewText.setGravity(17);
    this.rightViewText.setLayoutParams(paramLayoutInflater);
    this.rightViewText.setTextSize(1, 14.0F);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView = ((TopicEditTextView)a(2131366088));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.setMovementMethod(StateColorMovementMethod.a());
    this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.addTextChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.setOnEditorActionListener(new SignTextEditFragment.1(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131362194));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131362190));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(UITools.a);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnTouchListener(UITools.a);
    a(this.jdField_a_of_type_AndroidWidgetTextView);
    a(this.jdField_b_of_type_AndroidWidgetTextView);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131369987));
    this.jdField_c_of_type_AndroidWidgetTextView.setTag(new Integer(-5196865));
    this.jdField_a_of_type_AndroidViewView = a(2131370323);
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)a(2131364391));
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(UITools.a);
    paramLayoutInflater = this.jdField_a_of_type_AndroidWidgetCheckBox;
    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
    boolean bool;
    if ((paramViewGroup != null) && (paramViewGroup.b())) {
      bool = true;
    } else {
      bool = false;
    }
    paramLayoutInflater.setChecked(bool);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    a(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131366946));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131366065));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)a(2131370164));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new SignTextEditFragment.2(this));
    this.jdField_b_of_type_AndroidViewView = a(2131366238);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131366218));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131366229));
    this.jdField_a_of_type_ComTencentMobileqqAdapterTopicListAdapter = new TopicListAdapter(getBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterTopicListAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setEmptyView(this.jdField_b_of_type_AndroidViewView);
    paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
    if (paramLayoutInflater != null) {
      paramLayoutInflater.a(this.jdField_b_of_type_ComTencentMobileqqRichstatusIStatusListener);
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(0);
    b(false);
    if ((getBaseActivity() != null) && (getBaseActivity().getWindow() != null)) {
      getBaseActivity().getWindow().setSoftInputMode(32);
    }
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(Color.parseColor("#000000"));
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#000000"));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(Color.parseColor("#000000"));
      this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.setTextColor(Color.parseColor("#ffffff"));
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(Color.parseColor("#ffffff"));
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#f5f6fa"));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(Color.parseColor("#ffffff"));
      this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.setTextColor(Color.parseColor("#000000"));
    }
    ReportController.b(null, "dc00898", "", "", "0X800A63E", "0X800A63E", 0, 0, "0", "0", "", "");
  }
  
  protected int getContentLayoutId()
  {
    return 2131561490;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      break;
    case 8: 
      a();
      break;
    case 7: 
      if (getBaseActivity() != null) {
        getBaseActivity().finish();
      }
      break;
    case 6: 
      a((RichStatus)paramMessage.obj);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(7);
      break;
    case 5: 
      if (getBaseActivity() != null) {
        QQToast.a(getBaseActivity(), 1, HardCodeUtil.a(2131714020), 1).a();
      }
      break;
    case 4: 
      if (getBaseActivity() != null) {
        QQToast.a(getBaseActivity(), 1, HardCodeUtil.a(2131714015), 1).a();
      }
      break;
    case 3: 
      if (getBaseActivity() != null) {
        QQToast.a(getBaseActivity(), 1, HardCodeUtil.a(2131714025), 1).a();
      }
      break;
    case 2: 
      paramMessage = (RichStatus)paramMessage.obj;
      int i = this.jdField_a_of_type_Int;
      if ((i != 1) && (i != 2))
      {
        c(paramMessage);
        b(true);
      }
      break;
    case 1: 
      a((RichStatus)paramMessage.obj);
      break;
    case 0: 
      paramMessage = a();
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, paramMessage).sendToTarget();
    }
    return false;
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
      return;
    }
    if ((paramInt1 == 18) && (paramIntent != null))
    {
      paramIntent = (LbsDataV2.PoiInfo)paramIntent.getParcelableExtra("key_select_poi");
      String str = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.locationText;
      if (paramIntent == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.locationText = "";
      }
      else if (paramIntent.poiName.equals(HardCodeUtil.a(2131714028)))
      {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.locationText = "";
        this.jdField_b_of_type_JavaLangString = "";
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.locationText = paramIntent.poiName;
        this.jdField_b_of_type_JavaLangString = paramIntent.poiId;
      }
      if (!Utils.a(str, this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.locationText))
      {
        this.jdField_c_of_type_Boolean = true;
        b(false);
      }
    }
  }
  
  public boolean onBackEvent()
  {
    BaseActivity localBaseActivity = getBaseActivity();
    if (localBaseActivity == null) {
      return false;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("publish_ever", this.jdField_a_of_type_Boolean);
    localBaseActivity.setResult(-1, localIntent);
    int i = this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.getText().length();
    if (QLog.isColorLevel()) {
      QLog.i("SignTextEditFragment", 2, String.format("onBackEvent len=%d bChanged=%b bPublishEver=%b", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.jdField_c_of_type_Boolean), Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    }
    if ((this.jdField_c_of_type_Boolean) && (i > 0) && (isAdded()))
    {
      DialogUtil.a(getBaseActivity(), HardCodeUtil.a(2131714019), 2131719608, 2131719607, new SignTextEditFragment.3(this), new SignTextEditFragment.4(this)).show();
      return true;
    }
    if ((i != 0) && ((this.jdField_c_of_type_Boolean) || (!this.jdField_a_of_type_Boolean)))
    {
      localBaseActivity.finish();
      return true;
    }
    this.jdField_b_of_type_AndroidOsHandler.obtainMessage(6, null).sendToTarget();
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == this.rightViewText.getId())
    {
      ReportController.b(null, "dc00898", "", "", "0X800A63F", "0X800A63F", 0, 0, "0", "0", "", "");
      if (!NetworkUtil.isNetSupport(getBaseActivity())) {
        QQToast.a(getBaseActivity(), 2131693191, 0).a();
      } else {
        e();
      }
    }
    else
    {
      int i = paramView.getId();
      if (i != 2131362190)
      {
        if (i != 2131362194)
        {
          if (i == 2131370323)
          {
            CheckBox localCheckBox = this.jdField_a_of_type_AndroidWidgetCheckBox;
            localCheckBox.setChecked(localCheckBox.isChecked() ^ true);
          }
        }
        else
        {
          this.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.getSelectionStart();
          TopicUtil.a(getBaseActivity(), "https://ti.qq.com/signature/searchtopic?_wv=3&&_wwv=128", 17);
          ReportController.b(null, "dc00898", "", "", "0X800A640", "0X800A640", 0, 0, "0", "0", "", "");
        }
      }
      else
      {
        b();
        ReportController.b(null, "dc00898", "", "", "0X800A641", "0X800A641", 0, 0, "0", "0", "", "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppSignatureObserver = new SignTextEditFragment.SignatureTopicObserver(this, null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getBaseActivity().app;
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramBundle != null) {
      paramBundle.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSignatureObserver);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_b_of_type_ComTencentMobileqqRichstatusIStatusListener);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener);
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface != null) {
      localQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSignatureObserver);
    }
    SignatureManagerForTool.a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqAdapterTopicListAdapter;
    if ((paramView != null) && (paramView.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqAdapterTopicListAdapter.a().size() > paramInt)) {
      a(paramAdapterView, this.jdField_a_of_type_ComTencentMobileqqAdapterTopicListAdapter.a(paramInt));
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignTextEditFragment
 * JD-Core Version:    0.7.0.1
 */