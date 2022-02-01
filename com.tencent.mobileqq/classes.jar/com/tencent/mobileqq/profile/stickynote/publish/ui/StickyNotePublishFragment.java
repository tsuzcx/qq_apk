package com.tencent.mobileqq.profile.stickynote.publish.ui;

import QC.SuixintieCheckInfo;
import QC.SuixintieCheckItem;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.av.utils.UITools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.profile.stickynote.publish.StickyNotePublishConstant;
import com.tencent.mobileqq.profile.stickynote.publish.StickyNotePublishUtils;
import com.tencent.mobileqq.profile.stickynote.publish.adapter.BackgroundSelectorAdapter;
import com.tencent.mobileqq.profile.stickynote.publish.adapter.BackgroundSelectorAdapter.OnSelectListener;
import com.tencent.mobileqq.profile.stickynote.publish.bean.BackgroundSelectBean;
import com.tencent.mobileqq.profile.stickynote.publish.bean.StickyDraftBean;
import com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout;
import com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout.StickyNoteShopSetting;
import com.tencent.mobileqq.profile.view.SoftInputDetectView;
import com.tencent.mobileqq.profile.view.SoftInputDetectView.OnImStateChangedListener;
import com.tencent.mobileqq.richstatus.SignTextEditFragment;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.VasResEngine.VasRes;
import com.tencent.mobileqq.vas.VasResEngine.VasResAdapter;
import com.tencent.mobileqq.vas.VasResEngine.VasResDrawable;
import com.tencent.mobileqq.vas.adapter.SignatureAdapter;
import com.tencent.mobileqq.vas.adapter.SignatureFontAdapter;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wifi.Base64;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.ScrollView;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.qzone.publishInterface.QzonePublishMoodCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class StickyNotePublishFragment
  extends IphoneTitleBarFragment
  implements Handler.Callback, View.OnClickListener, BackgroundSelectorAdapter.OnSelectListener, StickyNoteShopLayout.StickyNoteShopSetting, SoftInputDetectView.OnImStateChangedListener
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private SuixintieCheckItem jdField_a_of_type_QCSuixintieCheckItem = new SuixintieCheckItem();
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new StickyNotePublishFragment.9(this);
  private View jdField_a_of_type_AndroidViewView;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ETTextView jdField_a_of_type_ComEtrumpMixlayoutETTextView;
  private IEmoticonMainPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel;
  private BackgroundSelectorAdapter jdField_a_of_type_ComTencentMobileqqProfileStickynotePublishAdapterBackgroundSelectorAdapter;
  private StickyNoteShopLayout jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout;
  private SoftInputDetectView jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView;
  private VasRes jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private ScrollView jdField_a_of_type_ComTencentWidgetScrollView;
  private XEditTextEx jdField_a_of_type_ComTencentWidgetXEditTextEx;
  private QzonePublishMoodCallback jdField_a_of_type_CooperationQzonePublishInterfaceQzonePublishMoodCallback = new StickyNotePublishFragment.10(this);
  private List<BackgroundSelectBean> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = 0;
  private SuixintieCheckItem jdField_b_of_type_QCSuixintieCheckItem = new SuixintieCheckItem();
  Handler jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private StickyNoteShopLayout jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private boolean jdField_c_of_type_Boolean = true;
  private boolean d = false;
  
  private <T extends View> T a(int paramInt)
  {
    return this.mContentView.findViewById(paramInt);
  }
  
  private static IEmoticonMainPanel a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, View paramView, int paramInt, EditText paramEditText)
  {
    paramView = (IEmoticonMainPanel)paramView.findViewById(paramInt);
    paramView.setCallBack(new StickyNotePublishFragment.5(paramEditText, paramQQAppInterface, paramBaseActivity));
    paramView.setDisableGuide(true);
    paramView.setDisableMoreEmotionButton(true);
    paramView.setHasBigEmotion(false);
    paramView.setOnlySysAndEmoji(true);
    paramView.setDisableAutoDownload(true);
    paramView.init(paramQQAppInterface, 100002, paramBaseActivity, paramBaseActivity.getTitleBarHeight(), null, null, false, new StickyNotePublishFragment.6());
    paramView.setTabListOverScrollMode(2);
    return paramView;
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    Intent localIntent = new Intent();
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    PublicFragmentActivity.a(paramActivity, localIntent, StickyNotePublishFragment.class, paramInt);
  }
  
  private void a(Message paramMessage)
  {
    if (getBaseActivity() != null)
    {
      if ((paramMessage.obj != null) && ((paramMessage.obj instanceof StickyDraftBean)))
      {
        paramMessage = (StickyDraftBean)paramMessage.obj;
        if (!TextUtils.isEmpty(paramMessage.jdField_a_of_type_JavaLangString))
        {
          paramMessage.jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
          a(getBaseActivity().app, paramMessage);
        }
        else
        {
          a(getBaseActivity().app);
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
        return;
      }
      paramMessage = (String)paramMessage.obj;
      if (!TextUtils.isEmpty(paramMessage))
      {
        StickyDraftBean localStickyDraftBean = new StickyDraftBean();
        localStickyDraftBean.jdField_a_of_type_JavaLangString = paramMessage;
        localStickyDraftBean.jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
        a(getBaseActivity().app, localStickyDraftBean);
      }
      else
      {
        a(getBaseActivity().app);
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
    }
  }
  
  private void b(Message paramMessage)
  {
    if (getBaseActivity() != null)
    {
      paramMessage = (StickyDraftBean)paramMessage.obj;
      if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) && (!TextUtils.isEmpty(paramMessage.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(paramMessage.jdField_a_of_type_JavaLangString);
        localObject = this.jdField_a_of_type_ComTencentWidgetXEditTextEx;
        ((XEditTextEx)localObject).setSelection(((XEditTextEx)localObject).getEditableText().length());
        if (paramMessage.d != 0)
        {
          localObject = this.jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((BackgroundSelectBean)((Iterator)localObject).next()).jdField_a_of_type_Boolean = false;
          }
          localObject = this.jdField_a_of_type_JavaUtilList;
          ((BackgroundSelectBean)((List)localObject).get(((List)localObject).size() - 1)).jdField_a_of_type_Boolean = true;
          localObject = this.jdField_a_of_type_JavaUtilList;
          a((BackgroundSelectBean)((List)localObject).get(((List)localObject).size() - 1));
        }
        b(paramMessage.jdField_a_of_type_Int, paramMessage.jdField_b_of_type_Int);
        a(paramMessage.d, paramMessage.jdField_c_of_type_Int);
      }
      Object localObject = this.jdField_a_of_type_AndroidWidgetCheckBox;
      if (localObject != null) {
        ((CheckBox)localObject).setChecked(paramMessage.jdField_a_of_type_Boolean);
      }
    }
  }
  
  private void c(Message paramMessage)
  {
    if (getBaseActivity() != null)
    {
      paramMessage = (String)paramMessage.obj;
      if (!TextUtils.isEmpty(paramMessage))
      {
        StickyDraftBean localStickyDraftBean = new StickyDraftBean();
        localStickyDraftBean.jdField_a_of_type_JavaLangString = paramMessage;
        localStickyDraftBean.jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
        a(getBaseActivity().app, localStickyDraftBean);
        return;
      }
      a(getBaseActivity().app);
    }
  }
  
  private void f()
  {
    if (getBaseActivity() != null)
    {
      StickyDraftBean localStickyDraftBean = a(getBaseActivity().app);
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, localStickyDraftBean).sendToTarget();
    }
  }
  
  private void g()
  {
    if ((getBaseActivity() != null) && (!NetworkUtil.isNetSupport(getBaseActivity())))
    {
      QQToast.a(getBaseActivity(), 1, getString(2131692183), 0).a();
      return;
    }
    if (getBaseActivity() != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetXEditTextEx;
      if ((localObject != null) && (((XEditTextEx)localObject).getEditableText() != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().toString())))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getBaseActivity(), getBaseActivity().getTitleBarHeight());
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getResources().getString(2131695281));
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        localObject = new ArrayList();
        ((ArrayList)localObject).add(this.jdField_b_of_type_QCSuixintieCheckItem);
        ((ArrayList)localObject).add(this.jdField_a_of_type_QCSuixintieCheckItem);
        String str = String.valueOf(a(getBaseActivity().app));
        StickyNotePublishUtils.a(BaseApplicationImpl.getContext(), getBaseActivity().app, this.jdField_a_of_type_Long, Long.valueOf(getBaseActivity().app.getCurrentUin()).longValue(), this.jdField_b_of_type_Boolean ^ true, str, str, Base64.a(new SuixintieCheckInfo((ArrayList)localObject).toByteArray(), 0), StickyNotePublishUtils.b(this.jdField_a_of_type_ComTencentWidgetXEditTextEx), this.jdField_a_of_type_CooperationQzonePublishInterfaceQzonePublishMoodCallback);
        h();
      }
    }
  }
  
  private void h()
  {
    ReportController.b(null, "dc00898", "", "", "0X800AB2F", "0X800AB2F", 0, 0, "0", "0", "", "");
    if ((!TextUtils.isEmpty(getBaseActivity().getCurrentAccountUin())) && (!TextUtils.isEmpty(String.valueOf(this.jdField_a_of_type_Long))))
    {
      int i;
      if (getBaseActivity().getCurrentAccountUin().equals(String.valueOf(this.jdField_a_of_type_Long))) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(null, "dc00898", "", "", "0X800AB2E", "0X800AB2E", i, 0, "0", "0", "", "");
    }
  }
  
  public int a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentWidgetXEditTextEx;
    if ((localObject != null) && (((XEditTextEx)localObject).getEditableText() != null))
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaint();
      float f = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getTextSize();
      ((TextPaint)localObject).setTextSize(AIOUtils.a(2, 28, getResources()));
      StaticLayout localStaticLayout = new StaticLayout(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().toString(), (TextPaint)localObject, this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getWidth() - this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingLeft() - this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
      ((TextPaint)localObject).setTextSize(f);
      return localStaticLayout.getLineCount();
    }
    return -1;
  }
  
  public long a(QQAppInterface paramQQAppInterface)
  {
    long l = 0L;
    if (paramQQAppInterface != null) {
      l = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getLong("default_stick_note_bg", 0L);
    }
    return l;
  }
  
  public StickyDraftBean a(QQAppInterface paramQQAppInterface)
  {
    StickyDraftBean localStickyDraftBean = new StickyDraftBean();
    localStickyDraftBean.jdField_a_of_type_JavaLangString = "";
    localStickyDraftBean.jdField_a_of_type_Boolean = false;
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
      localStickyDraftBean.jdField_a_of_type_JavaLangString = paramQQAppInterface.getString("draft_stick_note_content", "");
      localStickyDraftBean.jdField_a_of_type_Boolean = paramQQAppInterface.getBoolean("draft_stick_note_only_self_see", false);
      localStickyDraftBean.jdField_a_of_type_Int = paramQQAppInterface.getInt("draft_stick_note_font_id", 0);
      localStickyDraftBean.jdField_b_of_type_Int = paramQQAppInterface.getInt("draft_stick_note_font_type", 0);
      localStickyDraftBean.d = paramQQAppInterface.getInt("draft_stick_note_clothes_id", 0);
      localStickyDraftBean.jdField_c_of_type_Int = paramQQAppInterface.getInt("draft_stick_note_text_color", 0);
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("readDraft() --> sticky content is ");
        paramQQAppInterface.append(localStickyDraftBean.jdField_a_of_type_JavaLangString);
        paramQQAppInterface.append(" sticky isOnlySelfSee is ");
        paramQQAppInterface.append(localStickyDraftBean.jdField_a_of_type_Boolean);
        QLog.i("StickyNotePublishFragment", 2, paramQQAppInterface.toString());
      }
    }
    return localStickyDraftBean;
  }
  
  public void a()
  {
    Object localObject = getArguments();
    if (localObject != null)
    {
      this.jdField_a_of_type_Long = ((Bundle)localObject).getLong("key_host_uin");
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("host uin is ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
        QLog.i("StickyNotePublishFragment", 1, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      QLog.e("StickyNotePublishFragment", 1, "can not get host uin info");
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return;
          }
          if (this.jdField_a_of_type_Boolean)
          {
            InputMethodUtil.b(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
            return;
          }
          a(true);
          a(this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout);
          this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130850653);
          VasWebviewUtil.a("friend_wall", "page_show", "", 0, "", "2");
          return;
        }
        if (this.jdField_a_of_type_Boolean)
        {
          InputMethodUtil.b(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
          return;
        }
        a(true);
        a(this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130850650);
        VasWebviewUtil.a("friend_wall", "page_show", "", 0, "", "1");
        return;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        InputMethodUtil.b(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
        return;
      }
      a(true);
      b(true);
      return;
    }
    a(false);
    b(false);
    this.jdField_a_of_type_ComTencentWidgetScrollView.setVisibility(8);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.requestFocus();
    InputMethodUtil.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.d = SignTextEditFragment.a(paramInt2);
    d();
    if (paramInt1 > 10000)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if ((this.jdField_a_of_type_AndroidViewView.getBackground() instanceof VasResDrawable))
      {
        ((VasResDrawable)this.jdField_a_of_type_AndroidViewView.getBackground()).a(paramInt1);
      }
      else
      {
        VasResDrawable localVasResDrawable = new VasResDrawable(getBaseActivity().app, paramInt1);
        SignatureAdapter localSignatureAdapter = new SignatureAdapter(localVasResDrawable, getBaseActivity().app, 2130846313);
        localSignatureAdapter.a(true);
        localVasResDrawable.a(localSignatureAdapter);
        this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(localVasResDrawable);
      }
      this.jdField_a_of_type_QCSuixintieCheckItem.itemId = paramInt1;
    }
    else
    {
      this.jdField_a_of_type_QCSuixintieCheckItem.itemId = 0;
    }
    this.jdField_a_of_type_QCSuixintieCheckItem.appid = 9;
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTextColor(paramInt2);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.mMsgId = System.currentTimeMillis();
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramInt2);
  }
  
  public void a(long paramLong)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      int i = 0;
      while (((Iterator)localObject).hasNext())
      {
        BackgroundSelectBean localBackgroundSelectBean = (BackgroundSelectBean)((Iterator)localObject).next();
        localBackgroundSelectBean.jdField_a_of_type_Boolean = false;
        if (localBackgroundSelectBean.jdField_a_of_type_Long == paramLong)
        {
          localBackgroundSelectBean.jdField_a_of_type_Boolean = true;
          i = 1;
        }
      }
      if (i == 0) {
        ((BackgroundSelectBean)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_Boolean = true;
      }
    }
  }
  
  public void a(View paramView)
  {
    StickyNoteShopLayout localStickyNoteShopLayout = this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout;
    if (localStickyNoteShopLayout != paramView) {
      localStickyNoteShopLayout.b();
    }
    localStickyNoteShopLayout = this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout;
    if (localStickyNoteShopLayout != paramView) {
      localStickyNoteShopLayout.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel.getView().setVisibility(8);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
      paramQQAppInterface.edit().putString("draft_stick_note_content", "").apply();
      paramQQAppInterface.edit().putBoolean("draft_stick_note_only_self_see", false).apply();
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (paramQQAppInterface != null) {
      paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit().putLong("default_stick_note_bg", paramLong).apply();
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, StickyDraftBean paramStickyDraftBean)
  {
    a(paramQQAppInterface, paramStickyDraftBean, false);
  }
  
  public void a(QQAppInterface paramQQAppInterface, StickyDraftBean paramStickyDraftBean, boolean paramBoolean)
  {
    if ((paramQQAppInterface != null) && (paramStickyDraftBean != null) && (!TextUtils.isEmpty(paramStickyDraftBean.jdField_a_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveDraft() --> sticky content is ");
        localStringBuilder.append(paramStickyDraftBean.jdField_a_of_type_JavaLangString);
        localStringBuilder.append(" sticky isOnlySelfSee is ");
        localStringBuilder.append(paramStickyDraftBean.jdField_a_of_type_Boolean);
        QLog.i("StickyNotePublishFragment", 2, localStringBuilder.toString());
      }
      paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
      if (paramBoolean)
      {
        paramQQAppInterface.edit().putString("draft_stick_note_content", paramStickyDraftBean.jdField_a_of_type_JavaLangString).commit();
        paramQQAppInterface.edit().putBoolean("draft_stick_note_only_self_see", paramStickyDraftBean.jdField_a_of_type_Boolean).commit();
        paramQQAppInterface.edit().putInt("draft_stick_note_font_id", paramStickyDraftBean.jdField_a_of_type_Int).commit();
        paramQQAppInterface.edit().putInt("draft_stick_note_font_type", paramStickyDraftBean.jdField_b_of_type_Int).commit();
        paramQQAppInterface.edit().putInt("draft_stick_note_clothes_id", paramStickyDraftBean.d).commit();
        paramQQAppInterface.edit().putInt("draft_stick_note_text_color", paramStickyDraftBean.jdField_c_of_type_Int).commit();
        return;
      }
      paramQQAppInterface.edit().putString("draft_stick_note_content", paramStickyDraftBean.jdField_a_of_type_JavaLangString).apply();
      paramQQAppInterface.edit().putBoolean("draft_stick_note_only_self_see", paramStickyDraftBean.jdField_a_of_type_Boolean).apply();
      paramQQAppInterface.edit().putInt("draft_stick_note_font_id", paramStickyDraftBean.jdField_a_of_type_Int).apply();
      paramQQAppInterface.edit().putInt("draft_stick_note_font_type", paramStickyDraftBean.jdField_b_of_type_Int).apply();
      paramQQAppInterface.edit().putInt("draft_stick_note_clothes_id", paramStickyDraftBean.d).apply();
      paramQQAppInterface.edit().putInt("draft_stick_note_text_color", paramStickyDraftBean.jdField_c_of_type_Int).apply();
    }
  }
  
  public void a(BackgroundSelectBean paramBackgroundSelectBean)
  {
    if ((paramBackgroundSelectBean != null) && (this.titleRoot != null) && (getBaseActivity() != null))
    {
      if (paramBackgroundSelectBean.jdField_a_of_type_Long == 999L)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.performClick();
        VasWebviewUtil.a("friend_wall", "icon_click", "", 0, "", "3");
        return;
      }
      a(getBaseActivity().app, paramBackgroundSelectBean.jdField_a_of_type_Long);
      a((int)paramBackgroundSelectBean.jdField_a_of_type_Long, -1);
      this.titleRoot.setBackgroundDrawable(paramBackgroundSelectBean.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      View localView = this.jdField_a_of_type_AndroidViewView;
      if (localView != null) {
        localView.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setItemId((int)paramBackgroundSelectBean.jdField_a_of_type_Long);
    }
  }
  
  public void a(StickyNoteShopLayout paramStickyNoteShopLayout)
  {
    a(paramStickyNoteShopLayout);
    b(paramStickyNoteShopLayout.a(this.jdField_a_of_type_Int));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    paramStickyNoteShopLayout.a(0);
  }
  
  public void a(boolean paramBoolean)
  {
    FrameLayout localFrameLayout = this.jdField_b_of_type_AndroidWidgetFrameLayout;
    if (localFrameLayout != null)
    {
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localFrameLayout.setVisibility(i);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    int i = 0;
    if (paramBoolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      a(false);
      b(false);
      b(this.jdField_a_of_type_Int);
      c(false);
      int j = this.jdField_a_of_type_Int;
      RelativeLayout localRelativeLayout = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
      if (localRelativeLayout == null) {
        paramInt = i;
      } else {
        paramInt = localRelativeLayout.getHeight();
      }
      c(j, paramInt);
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    c(true);
    paramInt = this.jdField_b_of_type_Int;
    if (paramInt == 1)
    {
      a(true);
      b(true);
      return;
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      a(false);
      b(false);
      c(0, 0);
      return;
    }
    if (paramInt == 2)
    {
      a(2);
      return;
    }
    if (paramInt == 3) {
      a(3);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString().trim()));
  }
  
  public void b()
  {
    if ((getBaseActivity() != null) && (getBaseActivity().getWindow() != null))
    {
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        this.titleRoot.setFitsSystemWindows(false);
        this.titleRoot.setPadding(0, 0, 0, 0);
        if (getTitleBarView() != null)
        {
          getTitleBarView();
          ((ViewGroup.MarginLayoutParams)getTitleBarView().getLayoutParams()).topMargin = ImmersiveUtils.getStatusBarHeight(getBaseActivity());
        }
      }
      Object localObject = getBaseActivity().getWindow();
      ((Window)localObject).setSoftInputMode(16);
      ((Window)localObject).setBackgroundDrawable(new ColorDrawable(getBaseActivity().getResources().getColor(2131167394)));
      if (ImmersiveUtils.isSupporImmersive() != 0)
      {
        localObject = ((PublicFragmentActivity)getBaseActivity()).mSystemBarComp;
        ((SystemBarCompact)localObject).init();
        ((SystemBarCompact)localObject).setStatusBarColor(getResources().getColor(2131167333));
      }
      if (getTitleBarView() != null) {
        getTitleBarView().setBackgroundColor(getBaseActivity().getResources().getColor(2131167333));
      }
      setLeftButton(2131690728, this);
      this.leftViewNotBack.setTextColor(getResources().getColor(2131167394));
      localObject = (RelativeLayout.LayoutParams)this.leftViewNotBack.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(8.0F, getResources());
      this.leftViewNotBack.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.leftViewNotBack.setOnTouchListener(UITools.a);
      this.leftViewNotBack.setBackgroundDrawable(null);
      setRightButton(2131692486, this);
      this.rightViewText.setTextColor(getResources().getColor(2131167394));
      localObject = (RelativeLayout.LayoutParams)this.rightViewText.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.b(3.0F, getResources());
      this.rightViewText.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.rightViewText.setOnTouchListener(UITools.a);
      this.rightViewText.setBackgroundDrawable(null);
    }
  }
  
  public void b(int paramInt)
  {
    ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams()).bottomMargin = paramInt;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(" fontId:");
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append(" fontType:");
    ((StringBuilder)localObject1).append(paramInt2);
    QLog.d("StickyNotePublishFragment", 1, ((StringBuilder)localObject1).toString());
    localObject1 = this.jdField_b_of_type_QCSuixintieCheckItem;
    ((SuixintieCheckItem)localObject1).itemId = paramInt1;
    ((SuixintieCheckItem)localObject1).fontType = paramInt2;
    ((SuixintieCheckItem)localObject1).appid = 5;
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setFont(0, System.currentTimeMillis());
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.mMsgId = System.currentTimeMillis();
    localObject1 = getBaseActivity().app;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes;
    if (localObject2 == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes = new VasRes(getBaseActivity().app, paramInt1);
      localObject1 = new SignatureFontAdapter(this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes, (AppRuntime)localObject1, paramInt2);
      localObject2 = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView;
      ((SignatureFontAdapter)localObject1).a((ETTextView)localObject2, ((ETTextView)localObject2).getTextSize(), true);
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes.a((VasResAdapter)localObject1);
      ((SignatureFontAdapter)localObject1).a(-1);
      return;
    }
    localObject1 = (SignatureFontAdapter)((VasRes)localObject2).a();
    localObject2 = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView;
    ((SignatureFontAdapter)localObject1).a((ETTextView)localObject2, ((ETTextView)localObject2).getTextSize(), true);
    ((SignatureFontAdapter)this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes.a()).a(paramInt1, paramInt2);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel == null) {
      return;
    }
    c();
    if (paramBoolean)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel.getView());
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel.getView().setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837622);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getBaseActivity().getString(2131690247));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new StickyNotePublishFragment.7(this));
      int i;
      if (this.jdField_a_of_type_Int > ScreenUtil.SCREEN_HIGHT / 4) {
        i = this.jdField_a_of_type_Int;
      } else {
        i = ScreenUtil.SCREEN_HIGHT / 3;
      }
      ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel.getView().getLayoutParams();
      localLayoutParams.height = i;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel.getView().setMinimumHeight(localLayoutParams.height);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel.getView().setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      b(i);
      c(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel.getView().setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844810);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getBaseActivity().getString(2131690246));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new StickyNotePublishFragment.8(this));
  }
  
  public void c()
  {
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130850652);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130850649);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844810);
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      ((ViewGroup.MarginLayoutParams)localView.getLayoutParams()).bottomMargin = (paramInt1 + paramInt2);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentWidgetXEditTextEx;
    if (localObject != null)
    {
      if (((XEditTextEx)localObject).getText() == null) {
        return;
      }
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      int i = 8;
      if (paramBoolean)
      {
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.b(60.0F, getResources());
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(8);
        this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentWidgetScrollView.setVisibility(0);
        this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.requestFocus();
        this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
        if (this.jdField_c_of_type_Int > 5)
        {
          this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText(new QQText(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString(), 3, 28));
          this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextSize(24.0F);
        }
        else
        {
          this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextSize(28.0F);
          this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText(new QQText(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString(), 3, 28));
        }
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString())) {
          ((FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetScrollView.getLayoutParams()).gravity = 48;
        } else {
          ((FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetScrollView.getLayoutParams()).gravity = 19;
        }
        b(this.jdField_b_of_type_QCSuixintieCheckItem.itemId, this.jdField_b_of_type_QCSuixintieCheckItem.fontType);
      }
      else
      {
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = 0;
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(0);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.requestFocus();
        this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setVisibility(8);
        this.jdField_a_of_type_ComTencentWidgetScrollView.setVisibility(8);
      }
      if (paramBoolean)
      {
        localObject = this.jdField_c_of_type_AndroidWidgetRelativeLayout;
        if (this.jdField_b_of_type_Boolean) {
          i = 0;
        }
        ((RelativeLayout)localObject).setVisibility(i);
        return;
      }
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
  
  public void d()
  {
    TextView localTextView = this.leftViewNotBack;
    Resources localResources = getResources();
    int i;
    if (this.d) {
      i = 2131165327;
    } else {
      i = 2131167394;
    }
    localTextView.setTextColor(localResources.getColor(i));
    d(this.rightViewText.isEnabled());
    ImmersiveUtils.setStatusTextColor(this.d, getBaseActivity().getWindow());
  }
  
  public void d(boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
    {
      setRightButtonEnable(true);
      localTextView = this.rightViewText;
      localResources = getResources();
      if (this.d) {
        i = 2131165327;
      } else {
        i = 2131167394;
      }
      localTextView.setTextColor(localResources.getColor(i));
      return;
    }
    setRightButtonEnable(false);
    TextView localTextView = this.rightViewText;
    Resources localResources = getResources();
    if (this.d) {
      i = 2131165329;
    } else {
      i = 2131167397;
    }
    localTextView.setTextColor(localResources.getColor(i));
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    b();
    a();
    this.jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView = ((SoftInputDetectView)a(2131368888));
    this.jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView.setExcludeStatusBar(false);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView.setOnImStateChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131366942));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx = ((XEditTextEx)a(2131366335));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEditableFactory(new StickyNotePublishFragment.1(this));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString())) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString().trim()))) {
      d(true);
    } else {
      d(false);
    }
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)a(2131366344));
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnClickListener(new StickyNotePublishFragment.2(this));
    this.jdField_a_of_type_ComTencentWidgetScrollView = ((ScrollView)a(2131378145));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131376743));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new StickyNotePublishFragment.3(this));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)a(2131376870));
    paramLayoutInflater = new LinearLayoutManager(getBaseActivity());
    paramLayoutInflater.setOrientation(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131370228));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131376712));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131369346));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(UITools.a);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131369545));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener(UITools.a);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)a(2131369546));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnTouchListener(UITools.a);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)a(2131364392));
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new StickyNotePublishFragment.4(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131379962));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131379799));
    if (TextUtils.equals(String.valueOf(this.jdField_a_of_type_Long), getBaseActivity().app.getCurrentAccountUin()))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699357);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131699357);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699356);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131699356);
    }
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131366928));
    this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel = a(getBaseActivity().app, getBaseActivity(), this.mContentView, 2131366155, this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
    b(false);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131376711));
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(0);
    this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout = ((StickyNoteShopLayout)a(2131363512));
    this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setShopCallback(this);
    this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setAppId(9);
    this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setUseId(1);
    this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout = ((StickyNoteShopLayout)a(2131367102));
    this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setShopCallback(this);
    this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setAppId(5);
    this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setUseId(1);
    this.jdField_a_of_type_JavaUtilList.addAll(StickyNotePublishConstant.jdField_a_of_type_JavaUtilList);
    if (SimpleUIUtil.a())
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      e();
    }
    else
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    a(a(getBaseActivity().app));
    this.jdField_a_of_type_ComTencentMobileqqProfileStickynotePublishAdapterBackgroundSelectorAdapter = new BackgroundSelectorAdapter(this.jdField_a_of_type_JavaUtilList, getBaseActivity(), this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramLayoutInflater);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqProfileStickynotePublishAdapterBackgroundSelectorAdapter);
    if (this.titleRoot != null)
    {
      this.jdField_a_of_type_AndroidViewView = new View(getBaseActivity());
      this.titleRoot.addView(this.jdField_a_of_type_AndroidViewView, 0, new RelativeLayout.LayoutParams(-1, -1));
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    ReportController.b(null, "dc00898", "", "", "0X800AB2A", "0X800AB2A", 0, 0, "0", "0", "", "");
    VasWebviewUtil.a("friend_wall", "icon_show", "", 0, "", "");
  }
  
  public void e()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((BackgroundSelectBean)((Iterator)localObject).next()).jdField_a_of_type_Long == 999L) {
          ((Iterator)localObject).remove();
        }
      }
    }
  }
  
  public void e(boolean paramBoolean)
  {
    BaseActivity localBaseActivity = getBaseActivity();
    View localView = localBaseActivity.findViewById(2131371886);
    if (paramBoolean)
    {
      if (localView == null)
      {
        localView = new View(getBaseActivity());
        localView.setBackgroundColor(1996488704);
        localView.setId(2131371886);
        localBaseActivity.addContentView(localView, new ViewGroup.LayoutParams(-1, -1));
        return;
      }
      localView.setVisibility(0);
      return;
    }
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131561386;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4) {
              return false;
            }
            if (getBaseActivity() != null)
            {
              this.jdField_c_of_type_Boolean = false;
              getBaseActivity().finish();
              return false;
            }
          }
          else
          {
            a(paramMessage);
            return false;
          }
        }
        else
        {
          b(paramMessage);
          return false;
        }
      }
      else
      {
        c(paramMessage);
        return false;
      }
    }
    else {
      f();
    }
    return false;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    StickyNoteShopLayout localStickyNoteShopLayout = this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout;
    if (localStickyNoteShopLayout != null) {
      localStickyNoteShopLayout.a(paramInt1, paramInt2, paramIntent);
    }
    localStickyNoteShopLayout = this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout;
    if (localStickyNoteShopLayout != null) {
      localStickyNoteShopLayout.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean onBackEvent()
  {
    if (getBaseActivity() == null) {
      return false;
    }
    Object localObject = this.jdField_a_of_type_ComTencentWidgetXEditTextEx;
    if ((localObject != null) && (!TextUtils.isEmpty(((XEditTextEx)localObject).getText())))
    {
      localObject = new StickyDraftBean();
      ((StickyDraftBean)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
      ((StickyDraftBean)localObject).jdField_a_of_type_Int = this.jdField_b_of_type_QCSuixintieCheckItem.itemId;
      ((StickyDraftBean)localObject).jdField_b_of_type_Int = this.jdField_b_of_type_QCSuixintieCheckItem.fontType;
      ((StickyDraftBean)localObject).jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getCurrentTextColor();
      ((StickyDraftBean)localObject).d = this.jdField_a_of_type_QCSuixintieCheckItem.itemId;
      DialogUtil.a(getBaseActivity(), HardCodeUtil.a(2131714019), 2131719608, 2131719607, new StickyNotePublishFragment.11(this, (StickyDraftBean)localObject), new StickyNotePublishFragment.12(this)).show();
    }
    else
    {
      a(getBaseActivity().app);
      if (getBaseActivity() != null)
      {
        this.jdField_c_of_type_Boolean = false;
        getBaseActivity().finish();
      }
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131369546: 
      c();
      a(3);
      VasWebviewUtil.a("friend_wall", "icon_click", "", 0, "", "2");
      break;
    case 2131369545: 
      c();
      a(2);
      VasWebviewUtil.a("friend_wall", "icon_click", "", 0, "", "1");
      break;
    case 2131369233: 
      g();
      break;
    case 2131369204: 
      onBackEvent();
      ReportController.b(null, "dc00898", "", "", "0X800AB30", "0X800AB30", 0, 0, "0", "0", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_c_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("StickyNotePublishFragment", 2, "save draft when exit unexpected");
      }
      if (getBaseActivity() != null)
      {
        localObject = this.jdField_a_of_type_ComTencentWidgetXEditTextEx;
        if ((localObject != null) && (!TextUtils.isEmpty(((XEditTextEx)localObject).getText())))
        {
          localObject = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
          if (TextUtils.isEmpty((CharSequence)localObject))
          {
            a(getBaseActivity().app);
          }
          else
          {
            StickyDraftBean localStickyDraftBean = new StickyDraftBean();
            localStickyDraftBean.jdField_a_of_type_JavaLangString = ((String)localObject);
            localStickyDraftBean.jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
            a(getBaseActivity().app, localStickyDraftBean, true);
          }
        }
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes;
    if (localObject != null) {
      ((VasRes)localObject).a();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if ((getBaseActivity() != null) && (getBaseActivity().app != null))
    {
      boolean bool = ThemeUtil.isInNightMode(getBaseActivity().app);
      if (bool) {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(getBaseActivity().getResources().getColor(2131165327));
      } else {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(getBaseActivity().getResources().getColor(2131166474));
      }
      e(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment
 * JD-Core Version:    0.7.0.1
 */