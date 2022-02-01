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
  private static final int[][] I = { { 2130847785, Color.parseColor("#03081A"), Color.parseColor("#B0B3BF") }, { 2130847786, -1, -1 } };
  private static long J;
  CompoundButton.OnCheckedChangeListener A = new SignTextEditFragment.11(this);
  private boolean B = false;
  private int C = -1;
  private int D = 0;
  private long E = 0L;
  private boolean F = false;
  private String G;
  private StatusManager H;
  private AtomicBoolean K = new AtomicBoolean(false);
  private boolean L;
  private String M = null;
  private IStatusListener N = new SignTextEditFragment.10(this);
  TopicEditTextView a;
  TextView b;
  TextView c;
  View d;
  TextView e;
  XListView f;
  View g;
  ImageView h;
  TextView i;
  Drawable j;
  FrameLayout k;
  RelativeLayout l;
  CheckBox m;
  TopicListAdapter n;
  SignatureObserver o;
  RichStatus p;
  String q;
  QQAppInterface r;
  int s;
  boolean t;
  int u;
  int v;
  Handler w = new Handler(Looper.getMainLooper(), this);
  Handler x = new Handler(ThreadManager.getSubThreadLooper(), this);
  IStatusListener y = new SignTextEditFragment.7(this);
  public Observer z = new SignTextEditFragment.8(this);
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 == this.C) && (paramInt2 == this.D))
    {
      if (QLog.isColorLevel()) {
        QLog.i("SignTextEditFragment", 2, "onAtKeyChanged return");
      }
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("SignTextEditFragment", 2, String.format("onAtKeyChanged [%d, %d, [%s] ]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString }));
    }
    this.C = paramInt1;
    this.D = paramInt2;
    if ((paramInt1 >= 0) && (paramInt2 > 0) && (!TextUtils.isEmpty(paramString)))
    {
      long l1 = a(paramString, this.C, paramInt2);
      if (l1 > 0L) {
        this.E = l1;
      }
    }
    else
    {
      this.E = 0L;
      this.f.setTag(null);
      a();
    }
  }
  
  public static void a(Activity paramActivity, RichStatus paramRichStatus, String paramString, Bundle paramBundle, int paramInt)
  {
    if (System.currentTimeMillis() - J < 500L) {
      return;
    }
    J = System.currentTimeMillis();
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
    paramCheckBox.setOnCheckedChangeListener(this.A);
  }
  
  private void a(TextView paramTextView)
  {
    paramTextView = paramTextView.getCompoundDrawables();
    int i1 = AIOUtils.b(16.0F, getResources());
    if (paramTextView[0] != null) {
      paramTextView[0].setBounds(0, 0, i1, i1);
    }
  }
  
  private void a(RichStatus paramRichStatus)
  {
    SignatureTemplateInfo localSignatureTemplateInfo = SignatureManagerForTool.a().a(paramRichStatus.tplId);
    int i1 = paramRichStatus.tplId;
    if ((localSignatureTemplateInfo.a.get()) || (localSignatureTemplateInfo.D != null))
    {
      boolean bool1 = false;
      boolean bool2 = localSignatureTemplateInfo.a.get();
      if (localSignatureTemplateInfo.D != null) {
        bool1 = true;
      }
      QLog.d("SignTextEditFragment", 1, new Object[] { "insureNotImageSign set2Default tplId isParsing=", Boolean.valueOf(bool2), " isImageItem=", Boolean.valueOf(bool1) });
      i1 = 1;
    }
    paramRichStatus.tplId = i1;
  }
  
  private void a(AdapterView<?> paramAdapterView, SignatureManager.TopicInfo paramTopicInfo)
  {
    if (paramTopicInfo == null) {
      return;
    }
    paramAdapterView = paramAdapterView.getTag();
    boolean bool = paramAdapterView instanceof Object[];
    int i1 = 1;
    if (bool)
    {
      paramAdapterView = (Object[])paramAdapterView;
      if (paramAdapterView.length == 4)
      {
        int i2 = ((Integer)paramAdapterView[0]).intValue();
        int i3 = ((Integer)paramAdapterView[1]).intValue();
        String str = (String)paramAdapterView[2];
        if (((Long)paramAdapterView[3]).longValue() == this.E)
        {
          a(paramTopicInfo.topicId, paramTopicInfo.topicStr, i2, i3);
          break label105;
        }
      }
    }
    i1 = 0;
    label105:
    if (i1 == 0) {
      if (c(this.C)) {
        a(paramTopicInfo.topicId, paramTopicInfo.topicStr, this.C, 0);
      } else {
        a(paramTopicInfo.topicId, paramTopicInfo.topicStr, this.C);
      }
    }
    a(-1, 0, "");
    ReportController.b(null, "dc00898", "", "", "0X800A642", "0X800A642", 0, 0, "0", "0", "", "");
  }
  
  private void a(boolean paramBoolean)
  {
    int i2 = ViewUtils.pxToDp(ViewUtils.getScreenWidth());
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("width_1x=");
      ((StringBuilder)localObject).append(i2);
      QLog.i("SignTextEditFragment", 2, ((StringBuilder)localObject).toString());
    }
    if ((i2 < 354) && (paramBoolean))
    {
      this.L = true;
      localObject = (RelativeLayout.LayoutParams)this.e.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = ViewUtils.dpToPx(28.0F);
      ((RelativeLayout.LayoutParams)localObject).rightMargin += ViewUtils.dpToPx(8.0F);
      localObject = (RelativeLayout.LayoutParams)this.d.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(11);
      ((RelativeLayout.LayoutParams)localObject).addRule(1, 0);
    }
    Object localObject = this.c.getText().toString();
    TextPaint localTextPaint = this.c.getPaint();
    int i3 = (int)(Layout.getDesiredWidth((CharSequence)localObject, localTextPaint) + 0.5F) - (int)(Layout.getDesiredWidth(IConst.a, localTextPaint) + 0.5F);
    int i1;
    if (this.L) {
      i1 = ViewUtils.dpToPx(i2 - 16 - 85 - 4 - 85 - 4 - 93 - 4 - 8 - 16);
    } else {
      i1 = ViewUtils.dpToPx(i2 - 354);
    }
    if (QLog.isColorLevel()) {
      QLog.i("SignTextEditFragment", 2, String.format("isNarrow=%b widthLeft=%d needMoreLen=%d width=%d", new Object[] { Boolean.valueOf(this.L), Integer.valueOf(i1), Integer.valueOf(i3), Integer.valueOf(i2) }));
    }
    localObject = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
    if (i3 < i1) {
      ((RelativeLayout.LayoutParams)localObject).width = -2;
    } else {
      ((RelativeLayout.LayoutParams)localObject).width = (ViewUtils.dpToPx(85.0F) + i1);
    }
    this.c.requestLayout();
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
  
  private <T extends View> T b(int paramInt)
  {
    return this.mContentView.findViewById(paramInt);
  }
  
  private void b(RichStatus paramRichStatus)
  {
    int i1;
    if (paramRichStatus == null) {
      i1 = 0;
    } else {
      i1 = paramRichStatus.getTotalLenForShow();
    }
    paramRichStatus = this.e;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i1);
    localStringBuilder.append("/");
    localStringBuilder.append(80);
    paramRichStatus.setText(localStringBuilder.toString());
    int i2 = ((Integer)this.e.getTag()).intValue();
    paramRichStatus = this.e;
    if (80 - i1 <= 0) {
      i2 = Color.parseColor("#FF596A");
    }
    paramRichStatus.setTextColor(i2);
  }
  
  private void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SignTextEditFragment", 2, "updateSignViewShow");
    }
    Object localObject1 = this.p;
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((RichStatus)localObject1).toSpannableStringWithoutAction(null);
    b(this.p);
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (!TextUtils.isEmpty(this.q))
      {
        localObject2 = this.q;
        localObject1 = localObject2;
        if (paramBoolean)
        {
          this.q = null;
          localObject1 = localObject2;
        }
      }
      this.p.ensureContent();
      localObject2 = localObject1;
      if (this.p.tplId != 0)
      {
        this.p.plainText.set(0, ((CharSequence)localObject1).toString());
        localObject2 = localObject1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("SignTextEditFragment", 2, String.format("updateSignViewShow content=%s", new Object[] { localObject2 }));
    }
    this.a.setText(new QQText((CharSequence)localObject2, 1, 20));
    localObject1 = this.a;
    ((TopicEditTextView)localObject1).setSelection(((TopicEditTextView)localObject1).getEditableText().length());
    InputMethodUtil.a(this.a);
    e();
    c(ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null));
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
      this.rightViewText.setBackgroundDrawable(getResources().getDrawable(2130846643));
      this.c.setBackgroundDrawable(getResources().getDrawable(2130846643));
      this.b.setBackgroundDrawable(getResources().getDrawable(2130846643));
      this.d.setBackgroundDrawable(getResources().getDrawable(2130846643));
      this.rightViewText.setOnTouchListener(UITools.a);
      localObject = this.rightViewText;
      float f1;
      if (this.F) {
        f1 = 1.0F;
      } else {
        f1 = 0.5F;
      }
      ((TextView)localObject).setAlpha(f1);
    }
    else
    {
      paramBoolean = a(this.centerView.getCurrentTextColor());
      if ("2105".equals(ThemeUtil.getCurrentThemeId())) {
        paramBoolean = true;
      }
      localObject = I;
      int i1;
      if (paramBoolean) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      localObject = localObject[i1];
      this.rightViewText.setBackgroundResource(localObject[0]);
      TextView localTextView = this.rightViewText;
      if (this.F) {
        i1 = localObject[1];
      } else {
        i1 = localObject[2];
      }
      localTextView.setTextColor(i1);
      this.rightViewText.setOnTouchListener(null);
    }
    this.rightViewText.setEnabled(this.F);
  }
  
  private boolean c(int paramInt)
  {
    Editable localEditable = this.a.getEditableText();
    return (paramInt >= 0) && (localEditable.length() > paramInt) && (localEditable.charAt(paramInt) == '#') && (TopicUtil.a(localEditable, paramInt) == null);
  }
  
  private boolean c(RichStatus paramRichStatus)
  {
    String str = this.G;
    RichStatus localRichStatus = paramRichStatus;
    if (paramRichStatus == null)
    {
      localRichStatus = new RichStatus(null);
      localRichStatus.setEmptyStatus(true);
      str = "";
    }
    paramRichStatus = new StringBuilder();
    paramRichStatus.append("file_richstatus_draft_");
    paramRichStatus.append(this.r.getCurrentAccountUin());
    FileUtils.writeObject(paramRichStatus.toString(), localRichStatus);
    Object localObject = this.r.getAccount();
    paramRichStatus = (RichStatus)localObject;
    if (localObject == null) {
      paramRichStatus = "noLogin";
    }
    paramRichStatus = this.r.getApp().getSharedPreferences(paramRichStatus, 4).edit();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sign_location_id_draft_");
    ((StringBuilder)localObject).append(this.r.getCurrentAccountUin());
    paramRichStatus.putString(((StringBuilder)localObject).toString(), str).commit();
    if (QLog.isColorLevel()) {
      QLog.i("SignTextEditFragment", 2, String.format("saveDraft %s", new Object[] { localRichStatus.getPlainText() }));
    }
    return true;
  }
  
  private void d(int paramInt)
  {
    if (!isAdded()) {
      return;
    }
    this.h.setVisibility(8);
    this.g.setVisibility(0);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.i.getLayoutParams();
    localLayoutParams.topMargin = AIOUtils.b(80.0F, getResources());
    this.i.setLayoutParams(localLayoutParams);
    if (paramInt == 1)
    {
      this.g.setVisibility(8);
      try
      {
        this.i.setTextColor(ColorStateList.createFromXml(getResources(), getResources().getXml(2131168125)));
      }
      catch (Exception localException1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SignTextEditFragment", 2, localException1.toString());
        }
      }
      this.i.setText(HardCodeUtil.a(2131911549));
      return;
    }
    try
    {
      this.i.setTextColor(ColorStateList.createFromXml(getResources(), getResources().getXml(2131168125)));
    }
    catch (Exception localException2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SignTextEditFragment", 2, localException2.toString());
      }
    }
    this.h.setImageResource(2130852641);
    if (paramInt == 3)
    {
      this.i.setText(HardCodeUtil.a(2131911561));
      return;
    }
    if (paramInt == 2)
    {
      this.i.setText(HardCodeUtil.a(2131911562));
      return;
    }
    this.g.setVisibility(8);
  }
  
  private void d(RichStatus paramRichStatus)
  {
    if ((paramRichStatus != null) && (!paramRichStatus.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("SignTextEditFragment", 2, String.format("mergeByDraft draft=%s", new Object[] { paramRichStatus }));
      }
      RichStatus localRichStatus = this.p;
      if (localRichStatus != null)
      {
        localRichStatus.ensureContent();
        if (paramRichStatus.plainText != null)
        {
          this.p.plainText.clear();
          this.p.plainText.addAll(paramRichStatus.plainText);
        }
        if ((this.p.topics != null) && (paramRichStatus.topics != null))
        {
          this.p.topics.clear();
          this.p.topics.addAll(paramRichStatus.topics);
        }
        if ((this.p.topicsPos != null) && (paramRichStatus.topicsPos != null))
        {
          this.p.topicsPos.clear();
          this.p.topicsPos.addAll(paramRichStatus.topicsPos);
        }
        this.p.locationText = paramRichStatus.locationText;
        this.F = true;
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("SignTextEditFragment", 2, String.format("mergeByDraft empty", new Object[0]));
    }
  }
  
  private boolean d()
  {
    Bundle localBundle = getArguments();
    try
    {
      this.p = ((RichStatus)localBundle.getSerializable("rich_status"));
      if (this.p != null)
      {
        this.p.actionText = null;
        this.p.actionId = 0;
      }
      this.q = localBundle.getString("template_info_text");
      this.s = localBundle.getInt("from_type");
      Object localObject;
      if (QLog.isColorLevel())
      {
        i1 = this.s;
        localObject = this.p;
        if (localObject == null) {
          localObject = "null";
        } else {
          localObject = ((RichStatus)localObject).getPlainText();
        }
        QLog.i("SignTextEditFragment", 2, String.format("initData from=%d status=%s", new Object[] { Integer.valueOf(i1), localObject }));
      }
      int i1 = this.s;
      if ((i1 == 1) || (i1 == 2))
      {
        this.p = new RichStatus(null);
        this.p.copyFrom(this.H.b(true));
        localObject = this.p;
        ((RichStatus)localObject).actionText = null;
        ((RichStatus)localObject).actionId = 0;
        i1 = localBundle.getInt("key_sign_topic_id", -1);
        localObject = localBundle.getString("key_sign_topic_name");
        if (i1 >= 0)
        {
          if (!TopicUtil.a((String)localObject)) {
            return false;
          }
          this.p.topics.clear();
          this.p.topics.add(new Pair(Integer.valueOf(i1), localObject));
          localObject = this.p;
          ((RichStatus)localObject).plainText = null;
          ((RichStatus)localObject).ensureContent();
          this.F = true;
        }
      }
      else
      {
        if (this.p == null)
        {
          this.p = new RichStatus(null);
          return true;
        }
        SignatureManagerForTool.a().a(this.p.tplId);
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
  
  private void e()
  {
    if (!isAdded()) {
      return;
    }
    try
    {
      if (this.j == null)
      {
        this.j = getResources().getDrawable(2130847791);
        int i1 = AIOUtils.b(16.0F, getResources());
        this.j.setBounds(i1, i1, i1, i1);
        this.c.setCompoundDrawablesWithIntrinsicBounds(this.j, null, null, null);
      }
      if (!TextUtils.isEmpty(this.p.locationText))
      {
        this.c.setText(this.p.locationText);
        this.c.setTextColor(-11692801);
        this.c.getBackground().setColorFilter(-11692801, PorterDuff.Mode.SRC_ATOP);
        this.c.getBackground().setAlpha(33);
        this.j.setColorFilter(-11692801, PorterDuff.Mode.SRC_ATOP);
      }
      else
      {
        this.c.setTextColor(-7894119);
        this.c.setText(IConst.a);
        this.c.getBackground().setColorFilter(null);
        this.c.getBackground().setAlpha(255);
        this.j.setColorFilter(null);
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
  
  private void f()
  {
    if (this.p == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SignTextEditFragment", 1, "publishRichStatus");
    }
    if (this.p.getTotalLenForShow() > 80)
    {
      Message localMessage = new Message();
      localMessage.what = 4;
      this.w.sendMessage(localMessage);
      return;
    }
    if (this.p.bOnlyHasTopic())
    {
      this.w.sendEmptyMessage(5);
      return;
    }
    if (this.a.getText().length() == 0)
    {
      DialogUtil.a(getBaseActivity(), 230, HardCodeUtil.a(2131911554), HardCodeUtil.a(2131911560), HardCodeUtil.a(2131911548), HardCodeUtil.a(2131911552), new SignTextEditFragment.5(this), new SignTextEditFragment.6(this)).show();
      return;
    }
    g();
  }
  
  private void g()
  {
    if (QLog.isColorLevel())
    {
      localRichStatus = this.p;
      QLog.i("SignTextEditFragment", 2, String.format("publishRichStatusReal %s [tplId=%d fontId=%d, fontType=%d]", new Object[] { localRichStatus, Integer.valueOf(localRichStatus.tplId), Integer.valueOf(this.p.fontId), Integer.valueOf(this.p.fontType) }));
    }
    RichStatus localRichStatus = new RichStatus(null);
    localRichStatus.copyFrom(this.p);
    a(localRichStatus);
    this.H.a(localRichStatus, 1);
    this.H.a(this.y);
  }
  
  private RichStatus h()
  {
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("file_richstatus_draft_");
      ((StringBuilder)localObject).append(this.r.getCurrentAccountUin());
      localObject = (RichStatus)FileUtils.readObject(((StringBuilder)localObject).toString());
    }
    catch (Exception localException)
    {
      Object localObject;
      label42:
      break label42;
    }
    localObject = null;
    if (QLog.isColorLevel()) {
      QLog.i("SignTextEditFragment", 2, String.format("readDraft %s", new Object[] { localObject }));
    }
    return localObject;
  }
  
  public long a(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = this.n;
    if ((localObject != null) && ((((TopicListAdapter)localObject).a() == null) || (this.n.a().size() <= 0))) {
      d(1);
    }
    if (NetworkUtil.isNetSupport(getBaseActivity()))
    {
      localObject = (SignatureHandler)this.r.getBusinessHandler(BusinessHandlerFactory.SIGNATURE_HANDLER);
      if (localObject != null)
      {
        long l1 = System.currentTimeMillis();
        ((SignatureHandler)localObject).a(paramString, paramInt1, paramInt2, l1);
        return l1;
      }
    }
    else
    {
      d(2);
    }
    return 0L;
  }
  
  public void a()
  {
    Object localObject = this.n;
    if ((localObject != null) && (((TopicListAdapter)localObject).b() != null) && (this.n.b().size() > 0))
    {
      localObject = this.n;
      if (((TopicListAdapter)localObject).a(((TopicListAdapter)localObject).b(), false)) {
        this.n.notifyDataSetChanged();
      }
      return;
    }
    d(1);
    if (NetworkUtil.isNetSupport(getBaseActivity()))
    {
      localObject = (SignatureHandler)this.r.getBusinessHandler(BusinessHandlerFactory.SIGNATURE_HANDLER);
      if (localObject != null) {
        ((SignatureHandler)localObject).b();
      }
    }
    else
    {
      d(2);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt == 100)
    {
      str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = HardCodeUtil.a(2131911563);
      }
      QQToast.makeText(BaseApplication.context, 2, str, 0).show();
      return;
    }
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = HardCodeUtil.a(2131911558);
    }
    QQToast.makeText(BaseApplication.context, 1, str, 0).show();
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SignTextEditFragment", 2, String.format("onTagSelectedInsert(%d,%s) index=%d selStart=%d", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(this.C), Integer.valueOf(paramInt2) }));
    }
    if (TopicUtil.a(paramString))
    {
      if (paramInt1 < 0) {
        return;
      }
      int i2 = this.a.getText().length();
      int i1;
      if (paramInt2 < 0)
      {
        if (this.a.getSelectionStart() >= 0) {
          i1 = this.a.getSelectionStart();
        } else {
          i1 = 0;
        }
      }
      else
      {
        i1 = paramInt2;
        if (paramInt2 > i2) {
          i1 = i2;
        }
      }
      Editable localEditable = this.a.getText();
      if (localEditable.length() + paramString.length() > 80)
      {
        paramString = new Message();
        paramString.what = 3;
        this.w.sendMessage(paramString);
        return;
      }
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      ClickColorTopicSpan localClickColorTopicSpan = new ClickColorTopicSpan(null, TopicUtil.a(-11692801, -2142399233), new Pair(Integer.valueOf(paramInt1), paramString));
      if (i1 > 0) {
        localSpannableStringBuilder.insert(0, localEditable.subSequence(0, i1));
      }
      if (localEditable.length() > i1) {
        localSpannableStringBuilder.insert(localSpannableStringBuilder.length(), localEditable.subSequence(i1, localEditable.length()));
      }
      localSpannableStringBuilder.insert(i1, paramString);
      localSpannableStringBuilder.setSpan(localClickColorTopicSpan, i1, paramString.length() + i1, 33);
      if (QLog.isDevelopLevel()) {
        QLog.i("SignTextEditFragment", 2, String.format("onTagSelectedInsert [%d dstLen=%d] [src=%s,dst=%s]", new Object[] { Integer.valueOf(i1), Integer.valueOf(localSpannableStringBuilder.length()), localEditable.toString(), localSpannableStringBuilder.toString() }));
      }
      this.B = true;
      localEditable.delete(0, localEditable.length());
      localEditable.insert(0, localSpannableStringBuilder);
      this.B = false;
      if ((i1 >= 0) && (paramString.length() + i1 <= this.a.getEditableText().length()))
      {
        this.a.setSelection(i1 + paramString.length());
        return;
      }
      paramString = this.a;
      paramString.setSelection(paramString.getEditableText().length());
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SignTextEditFragment", 2, String.format("onTagSelectedReplace[%d,%s] index=%d len=%d", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    }
    int i1 = this.a.getText().length();
    if (paramInt2 >= i1) {
      return;
    }
    if (!c(paramInt2)) {
      return;
    }
    if (i1 - paramInt3 + paramString.length() > 80)
    {
      paramString = new Message();
      paramString.what = 3;
      this.w.sendMessage(paramString);
      return;
    }
    Editable localEditable = this.a.getEditableText();
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (paramInt2 > 0) {
      localSpannableStringBuilder.insert(0, localEditable.subSequence(0, paramInt2));
    }
    i1 = localEditable.length();
    paramInt3 = paramInt3 + paramInt2 + 1;
    if (i1 > paramInt3) {
      localSpannableStringBuilder.insert(localSpannableStringBuilder.length(), localEditable.subSequence(paramInt3, localEditable.length()));
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("SignTextEditFragment", 2, String.format("onTagSelectedReplace remove before=%s after=%s", new Object[] { localEditable, localSpannableStringBuilder }));
    }
    this.B = true;
    localEditable.delete(0, localEditable.length());
    localEditable.insert(0, localSpannableStringBuilder);
    this.B = false;
    a(paramInt1, paramString, paramInt2 + 1);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.toString().equals(this.p.toSpannableStringWithoutAction().toString()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SignTextEditFragment", 2, "afterTextChanged text not changed");
      }
      return;
    }
    this.F |= true;
    c(ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null));
    this.p.ensureContent();
    Object localObject = TopicUtil.a(paramEditable);
    this.p.plainText.set(0, localObject);
    this.p.topics.clear();
    this.p.topics.addAll(TopicUtil.b(paramEditable));
    this.p.topicsPos.clear();
    this.p.topicsPos.addAll(TopicUtil.c(paramEditable));
    b(this.p);
    int i1 = 80 - this.p.getTotalLenForShow();
    if (i1 < 0)
    {
      TopicUtil.a(paramEditable, i1, this.u, this.v);
      localObject = new Message();
      ((Message)localObject).what = 4;
      this.w.sendMessage((Message)localObject);
      localObject = TopicUtil.a(paramEditable);
      this.p.plainText.set(0, localObject);
      this.p.topics.clear();
      this.p.topics.addAll(TopicUtil.b(paramEditable));
      this.p.topicsPos.clear();
      this.p.topicsPos.addAll(TopicUtil.c(paramEditable));
    }
    if (QLog.isColorLevel()) {
      QLog.i("SignTextEditFragment", 2, String.format("afterTextChanged [%s]", new Object[] { this.p.getPlainText() }));
    }
    if (!this.B)
    {
      int i3 = this.a.getSelectionStart();
      int i4 = TopicUtil.a(this.a.getEditableText(), i3);
      int i2 = i3 - 1 - i4;
      i1 = i2;
      if (i2 < 0) {
        i1 = 0;
      }
      if ((i4 >= 0) && (i1 > 0)) {
        paramEditable = this.a.getEditableText().subSequence(i4 + 1, i3).toString();
      } else {
        paramEditable = "";
      }
      if (QLog.isColorLevel()) {
        QLog.i("SignTextEditFragment", 2, String.format("------------------[selStart=%d, indexAt=%d, len=%d key=[%s] ]", new Object[] { Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i1), paramEditable }));
      }
      a(i4, i1, paramEditable);
    }
  }
  
  void b()
  {
    InputMethodUtil.b(this.a);
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
    this.u = paramInt1;
    this.v = paramInt3;
  }
  
  void c()
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
    localUserInfo.qzone_uin = this.r.getCurrentAccountUin();
    localUserInfo.nickname = this.r.getCurrentNickname();
    if (TextUtils.isEmpty(this.G))
    {
      localObject = this.r.getPreferences();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sign_location_id_draft_");
      localStringBuilder.append(this.r.getCurrentAccountUin());
      this.G = ((SharedPreferences)localObject).getString(localStringBuilder.toString(), "");
      if (TextUtils.isEmpty(this.G))
      {
        localObject = this.r.getPreferences();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("sign_location_id_");
        localStringBuilder.append(this.r.getCurrentAccountUin());
        this.G = ((SharedPreferences)localObject).getString(localStringBuilder.toString(), "");
      }
    }
    Object localObject = new Bundle();
    if (!TextUtils.isEmpty(this.G))
    {
      ((Bundle)localObject).putInt("key_lbs_state", 1);
      ((Bundle)localObject).putString("key_current_poi_id", this.G);
    }
    QZoneHelper.forwardToMoodSelectLocation(getBaseActivity(), localUserInfo, 18, (Bundle)localObject);
    getBaseActivity().overridePendingTransition(2130771996, 2130772007);
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle(getString(2131888831));
    setRightButtonText(HardCodeUtil.a(2131911553), this);
    this.H = ((StatusManager)this.r.getManager(QQManagerFactory.STATUS_MANAGER));
    if (!d())
    {
      getBaseActivity().finish();
      return;
    }
    this.rightViewText.setBackgroundDrawable(getResources().getDrawable(2130846642));
    paramLayoutInflater = (RelativeLayout.LayoutParams)this.rightViewText.getLayoutParams();
    paramLayoutInflater.height = AIOUtils.b(29.0F, getResources());
    paramLayoutInflater.width = AIOUtils.b(60.0F, getResources());
    paramLayoutInflater.setMargins(0, 0, AIOUtils.b(14.0F, getResources()), 0);
    this.rightViewText.setGravity(17);
    this.rightViewText.setLayoutParams(paramLayoutInflater);
    this.rightViewText.setTextSize(1, 14.0F);
    this.a = ((TopicEditTextView)b(2131432368));
    this.a.setMovementMethod(StateColorMovementMethod.a());
    this.a.addTextChangedListener(this);
    this.a.setOnEditorActionListener(new SignTextEditFragment.1(this));
    this.b = ((TextView)b(2131427777));
    this.c = ((TextView)b(2131427772));
    this.b.setOnTouchListener(UITools.a);
    this.c.setOnTouchListener(UITools.a);
    a(this.b);
    a(this.c);
    this.e = ((TextView)b(2131437140));
    this.e.setTag(new Integer(-5196865));
    this.d = b(2131437573);
    this.m = ((CheckBox)b(2131430417));
    this.d.setOnTouchListener(UITools.a);
    paramLayoutInflater = this.m;
    paramViewGroup = this.H;
    boolean bool;
    if ((paramViewGroup != null) && (paramViewGroup.d())) {
      bool = true;
    } else {
      bool = false;
    }
    paramLayoutInflater.setChecked(bool);
    this.m.setOnCheckedChangeListener(this.A);
    this.d.setOnClickListener(this);
    a(true);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.k = ((FrameLayout)b(2131433305));
    this.l = ((RelativeLayout)b(2131432341));
    this.f = ((XListView)b(2131437330));
    this.f.setOnItemClickListener(this);
    this.f.setOnTouchListener(new SignTextEditFragment.2(this));
    this.g = b(2131432530);
    this.h = ((ImageView)this.g.findViewById(2131432506));
    this.i = ((TextView)this.g.findViewById(2131432517));
    this.n = new TopicListAdapter(getBaseActivity(), this.r, this.f, this);
    this.f.setAdapter(this.n);
    this.f.setEmptyView(this.g);
    paramLayoutInflater = this.H;
    if (paramLayoutInflater != null) {
      paramLayoutInflater.a(this.N);
    }
    this.w.sendEmptyMessage(8);
    this.x.sendEmptyMessage(0);
    b(false);
    if ((getBaseActivity() != null) && (getBaseActivity().getWindow() != null)) {
      getBaseActivity().getWindow().setSoftInputMode(32);
    }
    if (ThemeUtil.isNowThemeIsNight(this.r, false, null))
    {
      this.k.setBackgroundColor(Color.parseColor("#000000"));
      this.g.setBackgroundColor(Color.parseColor("#000000"));
      this.l.setBackgroundColor(Color.parseColor("#000000"));
      this.a.setTextColor(Color.parseColor("#ffffff"));
    }
    else
    {
      this.k.setBackgroundColor(Color.parseColor("#ffffff"));
      this.g.setBackgroundColor(Color.parseColor("#f5f6fa"));
      this.l.setBackgroundColor(Color.parseColor("#ffffff"));
      this.a.setTextColor(Color.parseColor("#000000"));
    }
    ReportController.b(null, "dc00898", "", "", "0X800A63E", "0X800A63E", 0, 0, "0", "0", "", "");
  }
  
  protected int getContentLayoutId()
  {
    return 2131627847;
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
      c((RichStatus)paramMessage.obj);
      this.w.sendEmptyMessage(7);
      break;
    case 5: 
      if (getBaseActivity() != null) {
        QQToast.makeText(getBaseActivity(), 1, HardCodeUtil.a(2131911551), 1).show();
      }
      break;
    case 4: 
      if (getBaseActivity() != null) {
        QQToast.makeText(getBaseActivity(), 1, HardCodeUtil.a(2131911546), 1).show();
      }
      break;
    case 3: 
      if (getBaseActivity() != null) {
        QQToast.makeText(getBaseActivity(), 1, HardCodeUtil.a(2131911556), 1).show();
      }
      break;
    case 2: 
      paramMessage = (RichStatus)paramMessage.obj;
      int i1 = this.s;
      if ((i1 != 1) && (i1 != 2))
      {
        d(paramMessage);
        b(true);
      }
      break;
    case 1: 
      c((RichStatus)paramMessage.obj);
      break;
    case 0: 
      paramMessage = h();
      this.w.obtainMessage(2, paramMessage).sendToTarget();
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
          a(paramInt1, paramIntent, this.C);
        }
      }
      this.C = -1;
      this.D = 0;
      return;
    }
    if ((paramInt1 == 18) && (paramIntent != null))
    {
      paramIntent = (LbsDataV2.PoiInfo)paramIntent.getParcelableExtra("key_select_poi");
      String str = this.p.locationText;
      if (paramIntent == null)
      {
        this.p.locationText = "";
      }
      else if (paramIntent.poiName.equals(HardCodeUtil.a(2131911559)))
      {
        this.p.locationText = "";
        this.G = "";
      }
      else
      {
        this.p.locationText = paramIntent.poiName;
        this.G = paramIntent.poiId;
      }
      if (!Utils.a(str, this.p.locationText))
      {
        this.F = true;
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
    localIntent.putExtra("publish_ever", this.t);
    localBaseActivity.setResult(-1, localIntent);
    int i1 = this.a.getText().length();
    if (QLog.isColorLevel()) {
      QLog.i("SignTextEditFragment", 2, String.format("onBackEvent len=%d bChanged=%b bPublishEver=%b", new Object[] { Integer.valueOf(i1), Boolean.valueOf(this.F), Boolean.valueOf(this.t) }));
    }
    if ((this.F) && (i1 > 0) && (isAdded()))
    {
      DialogUtil.a(getBaseActivity(), HardCodeUtil.a(2131911550), 2131917171, 2131917170, new SignTextEditFragment.3(this), new SignTextEditFragment.4(this)).show();
      return true;
    }
    if ((i1 != 0) && ((this.F) || (!this.t)))
    {
      localBaseActivity.finish();
      return true;
    }
    this.x.obtainMessage(6, null).sendToTarget();
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == this.rightViewText.getId())
    {
      ReportController.b(null, "dc00898", "", "", "0X800A63F", "0X800A63F", 0, 0, "0", "0", "", "");
      if (!NetworkUtil.isNetSupport(getBaseActivity())) {
        QQToast.makeText(getBaseActivity(), 2131890731, 0).show();
      } else {
        f();
      }
    }
    else
    {
      int i1 = paramView.getId();
      if (i1 != 2131427772)
      {
        if (i1 != 2131427777)
        {
          if (i1 == 2131437573)
          {
            CheckBox localCheckBox = this.m;
            localCheckBox.setChecked(localCheckBox.isChecked() ^ true);
          }
        }
        else
        {
          this.C = this.a.getSelectionStart();
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
    this.o = new SignTextEditFragment.SignatureTopicObserver(this, null);
    this.r = getBaseActivity().app;
    paramBundle = this.r;
    if (paramBundle != null) {
      paramBundle.addObserver(this.o);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.H.b(this.N);
    this.H.b(this.y);
    this.x.removeCallbacksAndMessages(null);
    this.w.removeCallbacksAndMessages(null);
    QQAppInterface localQQAppInterface = this.r;
    if (localQQAppInterface != null) {
      localQQAppInterface.removeObserver(this.o);
    }
    SignatureManagerForTool.a().deleteObserver(this.z);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = this.n;
    if ((paramView != null) && (paramView.a() != null) && (this.n.a().size() > paramInt)) {
      a(paramAdapterView, this.n.a(paramInt));
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignTextEditFragment
 * JD-Core Version:    0.7.0.1
 */