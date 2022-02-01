package com.tencent.mobileqq.profile.stickynote.publish.ui;

import QC.SuixintieCheckInfo;
import QC.SuixintieCheckItem;
import amtj;
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
import android.support.v4.app.FragmentActivity;
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
import ayov;
import ayow;
import ayox;
import aypa;
import aypb;
import aypc;
import aypd;
import aype;
import aypf;
import aypg;
import ayph;
import aypi;
import aypj;
import aypk;
import aypl;
import aypm;
import aypn;
import aypo;
import aypr;
import ayre;
import bbyp;
import bcef;
import bfur;
import bggs;
import bggt;
import bghk;
import bghn;
import bhht;
import bhmx;
import bjmm;
import com.etrump.mixlayout.ETTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.HorizontalListViewEx;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout;
import com.tencent.mobileqq.profile.view.SoftInputDetectView;
import com.tencent.mobileqq.richstatus.SignTextEditFragment;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.VasResEngine.VasResDrawable;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ScrollView;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.qzone.publishInterface.QzonePublishMoodCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mum;

public class StickyNotePublishFragment
  extends IphoneTitleBarFragment
  implements Handler.Callback, View.OnClickListener, aypa, aypr, ayre
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private SuixintieCheckItem jdField_a_of_type_QCSuixintieCheckItem = new SuixintieCheckItem();
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new aypo(this);
  private View jdField_a_of_type_AndroidViewView;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ayox jdField_a_of_type_Ayox;
  private bggs jdField_a_of_type_Bggs;
  private bhht jdField_a_of_type_Bhht;
  private ETTextView jdField_a_of_type_ComEtrumpMixlayoutETTextView;
  private EmoticonMainPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
  private StickyNoteShopLayout jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout;
  private SoftInputDetectView jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView;
  private ScrollView jdField_a_of_type_ComTencentWidgetScrollView;
  private XEditTextEx jdField_a_of_type_ComTencentWidgetXEditTextEx;
  private QzonePublishMoodCallback jdField_a_of_type_CooperationQzonePublishInterfaceQzonePublishMoodCallback = new aype(this);
  private List<aypb> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = 0;
  private SuixintieCheckItem jdField_b_of_type_QCSuixintieCheckItem = new SuixintieCheckItem();
  public Handler b;
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private StickyNoteShopLayout jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private boolean jdField_c_of_type_Boolean = true;
  private boolean d;
  
  public StickyNotePublishFragment()
  {
    this.jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private <T extends View> T a(int paramInt)
  {
    return this.mContentView.findViewById(paramInt);
  }
  
  private static EmoticonMainPanel a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, View paramView, int paramInt, EditText paramEditText)
  {
    paramView = (EmoticonMainPanel)paramView.findViewById(paramInt);
    paramView.setCallBack(new aypk(paramEditText, paramQQAppInterface, paramBaseActivity));
    paramView.disableGuide = true;
    paramView.disableMoreEmotionButton = true;
    paramView.hasBigEmotion = false;
    paramView.onlySysAndEmoji = true;
    paramView.disableAutoDownload = true;
    paramView.init(paramQQAppInterface, 100002, paramBaseActivity, paramBaseActivity.getTitleBarHeight(), null, null, false, new aypl());
    paramView.mEmoticonTabs.setOverScrollMode(2);
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
  
  public int a()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText() != null))
    {
      TextPaint localTextPaint = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaint();
      float f = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getTextSize();
      localTextPaint.setTextSize(AIOUtils.sp2TextSize(2, 28, getResources()));
      StaticLayout localStaticLayout = new StaticLayout(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().toString(), localTextPaint, this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getWidth() - this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingLeft() - this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
      localTextPaint.setTextSize(f);
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
  
  public aypc a(QQAppInterface paramQQAppInterface)
  {
    aypc localaypc = new aypc();
    localaypc.jdField_a_of_type_JavaLangString = "";
    localaypc.jdField_a_of_type_Boolean = false;
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
      localaypc.jdField_a_of_type_JavaLangString = paramQQAppInterface.getString("draft_stick_note_content", "");
      localaypc.jdField_a_of_type_Boolean = paramQQAppInterface.getBoolean("draft_stick_note_only_self_see", false);
      localaypc.jdField_a_of_type_Int = paramQQAppInterface.getInt("draft_stick_note_font_id", 0);
      localaypc.jdField_b_of_type_Int = paramQQAppInterface.getInt("draft_stick_note_font_type", 0);
      localaypc.d = paramQQAppInterface.getInt("draft_stick_note_clothes_id", 0);
      localaypc.jdField_c_of_type_Int = paramQQAppInterface.getInt("draft_stick_note_text_color", 0);
      if (QLog.isColorLevel()) {
        QLog.i("StickyNotePublishFragment", 2, "readDraft() --> sticky content is " + localaypc.jdField_a_of_type_JavaLangString + " sticky isOnlySelfSee is " + localaypc.jdField_a_of_type_Boolean);
      }
    }
    return localaypc;
  }
  
  public void a()
  {
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      this.jdField_a_of_type_Long = localBundle.getLong("key_host_uin");
      if (QLog.isColorLevel()) {
        QLog.i("StickyNotePublishFragment", 1, "host uin is " + this.jdField_a_of_type_Long);
      }
      return;
    }
    QLog.e("StickyNotePublishFragment", 1, "can not get host uin info");
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      a(false);
      b(false);
      this.jdField_a_of_type_ComTencentWidgetScrollView.setVisibility(8);
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.requestFocus();
      bjmm.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
      return;
    case 1: 
      if (this.jdField_a_of_type_Boolean)
      {
        bjmm.b(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
        return;
      }
      a(true);
      b(true);
      return;
    case 2: 
      if (this.jdField_a_of_type_Boolean)
      {
        bjmm.b(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
        return;
      }
      a(true);
      a(this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130850220);
      VasWebviewUtil.reportCommercialDrainage("friend_wall", "page_show", "", 0, "", "1");
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      bjmm.b(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
      return;
    }
    a(true);
    a(this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout);
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130850223);
    VasWebviewUtil.reportCommercialDrainage("friend_wall", "page_show", "", 0, "", "2");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.d = SignTextEditFragment.a(paramInt2);
    d();
    if (paramInt1 > 10000)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if ((this.jdField_a_of_type_AndroidViewView.getBackground() instanceof VasResDrawable)) {
        ((VasResDrawable)this.jdField_a_of_type_AndroidViewView.getBackground()).b(paramInt1);
      }
    }
    for (this.jdField_a_of_type_QCSuixintieCheckItem.itemId = paramInt1;; this.jdField_a_of_type_QCSuixintieCheckItem.itemId = 0)
    {
      this.jdField_a_of_type_QCSuixintieCheckItem.appid = 9;
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTextColor(paramInt2);
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.mMsgId = System.currentTimeMillis();
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramInt2);
      return;
      VasResDrawable localVasResDrawable = new VasResDrawable(getActivity().app, paramInt1);
      bghk localbghk = new bghk(localVasResDrawable, getActivity().app, 2130846027);
      localbghk.a(true);
      localVasResDrawable.a(localbghk);
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(localVasResDrawable);
      break;
    }
  }
  
  public void a(long paramLong)
  {
    int i;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      i = 0;
      if (localIterator.hasNext())
      {
        aypb localaypb = (aypb)localIterator.next();
        localaypb.jdField_a_of_type_Boolean = false;
        if (localaypb.jdField_a_of_type_Long != paramLong) {
          break label103;
        }
        localaypb.jdField_a_of_type_Boolean = true;
        i = 1;
      }
    }
    label103:
    for (;;)
    {
      break;
      if (i == 0) {
        ((aypb)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_Boolean = true;
      }
      return;
    }
  }
  
  public void a(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout != paramView) {
      this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.b();
    }
    if (this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout != paramView) {
      this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setVisibility(8);
  }
  
  public void a(aypb paramaypb)
  {
    if ((paramaypb != null) && (this.titleRoot != null) && (getActivity() != null))
    {
      if (paramaypb.jdField_a_of_type_Long == 999L)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.performClick();
        VasWebviewUtil.reportCommercialDrainage("friend_wall", "icon_click", "", 0, "", "3");
      }
    }
    else {
      return;
    }
    a(getActivity().app, paramaypb.jdField_a_of_type_Long);
    a((int)paramaypb.jdField_a_of_type_Long, -1);
    this.titleRoot.setBackgroundDrawable(paramaypb.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setItemId((int)paramaypb.jdField_a_of_type_Long);
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
  
  public void a(QQAppInterface paramQQAppInterface, aypc paramaypc)
  {
    a(paramQQAppInterface, paramaypc, false);
  }
  
  public void a(QQAppInterface paramQQAppInterface, aypc paramaypc, boolean paramBoolean)
  {
    if ((paramQQAppInterface != null) && (paramaypc != null) && (!TextUtils.isEmpty(paramaypc.jdField_a_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("StickyNotePublishFragment", 2, "saveDraft() --> sticky content is " + paramaypc.jdField_a_of_type_JavaLangString + " sticky isOnlySelfSee is " + paramaypc.jdField_a_of_type_Boolean);
      }
      paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
      if (paramBoolean)
      {
        paramQQAppInterface.edit().putString("draft_stick_note_content", paramaypc.jdField_a_of_type_JavaLangString).commit();
        paramQQAppInterface.edit().putBoolean("draft_stick_note_only_self_see", paramaypc.jdField_a_of_type_Boolean).commit();
        paramQQAppInterface.edit().putInt("draft_stick_note_font_id", paramaypc.jdField_a_of_type_Int).commit();
        paramQQAppInterface.edit().putInt("draft_stick_note_font_type", paramaypc.jdField_b_of_type_Int).commit();
        paramQQAppInterface.edit().putInt("draft_stick_note_clothes_id", paramaypc.d).commit();
        paramQQAppInterface.edit().putInt("draft_stick_note_text_color", paramaypc.jdField_c_of_type_Int).commit();
      }
    }
    else
    {
      return;
    }
    paramQQAppInterface.edit().putString("draft_stick_note_content", paramaypc.jdField_a_of_type_JavaLangString).apply();
    paramQQAppInterface.edit().putBoolean("draft_stick_note_only_self_see", paramaypc.jdField_a_of_type_Boolean).apply();
    paramQQAppInterface.edit().putInt("draft_stick_note_font_id", paramaypc.jdField_a_of_type_Int).apply();
    paramQQAppInterface.edit().putInt("draft_stick_note_font_type", paramaypc.jdField_b_of_type_Int).apply();
    paramQQAppInterface.edit().putInt("draft_stick_note_clothes_id", paramaypc.d).apply();
    paramQQAppInterface.edit().putInt("draft_stick_note_text_color", paramaypc.jdField_c_of_type_Int).apply();
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
    FrameLayout localFrameLayout;
    if (this.jdField_b_of_type_AndroidWidgetFrameLayout != null)
    {
      localFrameLayout = this.jdField_b_of_type_AndroidWidgetFrameLayout;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localFrameLayout.setVisibility(i);
      return;
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
      if (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null)
      {
        paramInt = i;
        c(j, paramInt);
      }
    }
    do
    {
      return;
      paramInt = this.jdField_b_of_type_AndroidWidgetRelativeLayout.getHeight();
      break;
      this.jdField_a_of_type_Boolean = false;
      c(true);
      if (this.jdField_b_of_type_Int == 1)
      {
        a(true);
        b(true);
        return;
      }
      if (this.jdField_b_of_type_Int == 0)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        a(false);
        b(false);
        c(0, 0);
        return;
      }
      if (this.jdField_b_of_type_Int == 2)
      {
        a(2);
        return;
      }
    } while (this.jdField_b_of_type_Int != 3);
    a(3);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString().trim()));
  }
  
  public void b()
  {
    if ((getActivity() != null) && (getActivity().getWindow() != null))
    {
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        this.titleRoot.setFitsSystemWindows(false);
        this.titleRoot.setPadding(0, 0, 0, 0);
        if (getTitleBarView() != null)
        {
          getTitleBarView();
          ((ViewGroup.MarginLayoutParams)getTitleBarView().getLayoutParams()).topMargin = ImmersiveUtils.getStatusBarHeight(getActivity());
        }
      }
      Object localObject = getActivity().getWindow();
      ((Window)localObject).setSoftInputMode(16);
      ((Window)localObject).setBackgroundDrawable(new ColorDrawable(getActivity().getResources().getColor(2131167337)));
      if (ImmersiveUtils.isSupporImmersive() != 0)
      {
        localObject = ((PublicFragmentActivity)getActivity()).mSystemBarComp;
        ((SystemBarCompact)localObject).init();
        ((SystemBarCompact)localObject).setStatusBarColor(getResources().getColor(2131167276));
      }
      if (getTitleBarView() != null) {
        getTitleBarView().setBackgroundColor(getActivity().getResources().getColor(2131167276));
      }
      setLeftButton(2131690620, this);
      this.leftViewNotBack.setTextColor(getResources().getColor(2131167337));
      localObject = (RelativeLayout.LayoutParams)this.leftViewNotBack.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.dp2px(8.0F, getResources());
      this.leftViewNotBack.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.leftViewNotBack.setOnTouchListener(mum.a);
      this.leftViewNotBack.setBackgroundDrawable(null);
      setRightButton(2131692310, this);
      this.rightViewText.setTextColor(getResources().getColor(2131167337));
      localObject = (RelativeLayout.LayoutParams)this.rightViewText.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.dp2px(3.0F, getResources());
      this.rightViewText.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.rightViewText.setOnTouchListener(mum.a);
      this.rightViewText.setBackgroundDrawable(null);
    }
  }
  
  public void b(int paramInt)
  {
    ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams()).bottomMargin = paramInt;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    QLog.d("StickyNotePublishFragment", 1, " fontId:" + paramInt1 + " fontType:" + paramInt2);
    this.jdField_b_of_type_QCSuixintieCheckItem.itemId = paramInt1;
    this.jdField_b_of_type_QCSuixintieCheckItem.fontType = paramInt2;
    this.jdField_b_of_type_QCSuixintieCheckItem.appid = 5;
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setFont(0, System.currentTimeMillis());
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.mMsgId = System.currentTimeMillis();
    Object localObject = getActivity().app;
    if (this.jdField_a_of_type_Bggs == null)
    {
      this.jdField_a_of_type_Bggs = new bggs(getActivity().app, paramInt1);
      localObject = new bghn(this.jdField_a_of_type_Bggs, (AppRuntime)localObject, paramInt2);
      ((bghn)localObject).a(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView, this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize(), true);
      this.jdField_a_of_type_Bggs.a((bggt)localObject);
      ((bghn)localObject).a(-1);
      return;
    }
    ((bghn)this.jdField_a_of_type_Bggs.a()).a(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView, this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize(), true);
    ((bghn)this.jdField_a_of_type_Bggs.a()).a(paramInt1, paramInt2);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel == null) {
      return;
    }
    c();
    if (paramBoolean)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837535);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getActivity().getString(2131690223));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new aypm(this));
      if (this.jdField_a_of_type_Int > ScreenUtil.SCREEN_HIGHT / 4) {}
      for (int i = this.jdField_a_of_type_Int;; i = ScreenUtil.SCREEN_HIGHT / 3)
      {
        ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.getLayoutParams();
        localLayoutParams.height = i;
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setMinimumHeight(localLayoutParams.height);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setLayoutParams(localLayoutParams);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        b(i);
        c(false);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844704);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getActivity().getString(2131690222));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new aypn(this));
  }
  
  public void c()
  {
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130850222);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130850219);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844704);
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      ((ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).bottomMargin = (paramInt1 + paramInt2);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx == null) || (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() == null)) {
      return;
    }
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    if (paramBoolean)
    {
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.dp2px(60.0F, getResources());
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(8);
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetScrollView.setVisibility(0);
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.requestFocus();
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
      if (this.jdField_c_of_type_Int > 5)
      {
        this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText(new QQText(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString(), 3, 28));
        this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextSize(24.0F);
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString())) {
          break label255;
        }
        ((FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetScrollView.getLayoutParams()).gravity = 48;
        label173:
        b(this.jdField_b_of_type_QCSuixintieCheckItem.itemId, this.jdField_b_of_type_QCSuixintieCheckItem.fontType);
        label191:
        if (!paramBoolean) {
          break label321;
        }
        localObject = this.jdField_c_of_type_AndroidWidgetRelativeLayout;
        if (!this.jdField_b_of_type_Boolean) {
          break label315;
        }
      }
    }
    label315:
    for (int i = 0;; i = 8)
    {
      ((RelativeLayout)localObject).setVisibility(i);
      return;
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextSize(28.0F);
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText(new QQText(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString(), 3, 28));
      break;
      label255:
      ((FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetScrollView.getLayoutParams()).gravity = 19;
      break label173;
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = 0;
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.requestFocus();
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetScrollView.setVisibility(8);
      break label191;
    }
    label321:
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  public void d()
  {
    TextView localTextView = this.leftViewNotBack;
    Resources localResources = getResources();
    if (this.d) {}
    for (int i = 2131165351;; i = 2131167337)
    {
      localTextView.setTextColor(localResources.getColor(i));
      d(this.rightViewText.isEnabled());
      ImmersiveUtils.a(this.d, getActivity().getWindow());
      return;
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setRightButtonEnable(true);
      localTextView = this.rightViewText;
      localResources = getResources();
      if (this.d) {}
      for (i = 2131165351;; i = 2131167337)
      {
        localTextView.setTextColor(localResources.getColor(i));
        return;
      }
    }
    setRightButtonEnable(false);
    TextView localTextView = this.rightViewText;
    Resources localResources = getResources();
    if (this.d) {}
    for (int i = 2131165355;; i = 2131167340)
    {
      localTextView.setTextColor(localResources.getColor(i));
      return;
    }
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    b();
    a();
    this.jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView = ((SoftInputDetectView)a(2131368765));
    this.jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView.setExcludeStatusBar(false);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView.setOnImStateChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131366797));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx = ((XEditTextEx)a(2131366181));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEditableFactory(new aypd(this));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString())) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString().trim())))
    {
      d(false);
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)a(2131366190));
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnClickListener(new ayph(this));
      this.jdField_a_of_type_ComTencentWidgetScrollView = ((ScrollView)a(2131378036));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131376618));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new aypi(this));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)a(2131376743));
      paramLayoutInflater = new LinearLayoutManager(getActivity());
      paramLayoutInflater.setOrientation(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131370129));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131376585));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131369224));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(mum.a);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131369418));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener(mum.a);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)a(2131369419));
      this.jdField_c_of_type_AndroidWidgetImageView.setOnTouchListener(mum.a);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)a(2131364316));
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new aypj(this));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131379911));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131379746));
      if (!TextUtils.equals(String.valueOf(this.jdField_a_of_type_Long), getActivity().app.getCurrentAccountUin())) {
        break label846;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698614);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131698614);
      label481:
      this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131366780));
      this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = a(getActivity().app, getActivity(), this.mContentView, 2131365994, this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
      b(false);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131376584));
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(0);
      this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout = ((StickyNoteShopLayout)a(2131363433));
      this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setShopCallback(this);
      this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setAppId(9);
      this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setUseId(1);
      this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout = ((StickyNoteShopLayout)a(2131367011));
      this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setShopCallback(this);
      this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setAppId(5);
      this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setUseId(1);
      this.jdField_a_of_type_JavaUtilList.addAll(ayov.jdField_a_of_type_JavaUtilList);
      if (!bbyp.b()) {
        break label869;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      e();
    }
    for (;;)
    {
      a(a(getActivity().app));
      this.jdField_a_of_type_Ayox = new ayox(this.jdField_a_of_type_JavaUtilList, getActivity(), this);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramLayoutInflater);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Ayox);
      if (this.titleRoot != null)
      {
        this.jdField_a_of_type_AndroidViewView = new View(getActivity());
        this.titleRoot.addView(this.jdField_a_of_type_AndroidViewView, 0, new RelativeLayout.LayoutParams(-1, -1));
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      bcef.b(null, "dc00898", "", "", "0X800AB2A", "0X800AB2A", 0, 0, "0", "0", "", "");
      VasWebviewUtil.reportCommercialDrainage("friend_wall", "icon_show", "", 0, "", "");
      return;
      d(true);
      break;
      label846:
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698613);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131698613);
      break label481;
      label869:
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        if (((aypb)localIterator.next()).jdField_a_of_type_Long == 999L) {
          localIterator.remove();
        }
      }
    }
  }
  
  public void e(boolean paramBoolean)
  {
    FragmentActivity localFragmentActivity = getActivity();
    View localView = localFragmentActivity.findViewById(2131371801);
    if (paramBoolean) {
      if (localView == null)
      {
        localView = new View(getActivity());
        localView.setBackgroundColor(1996488704);
        localView.setId(2131371801);
        localFragmentActivity.addContentView(localView, new ViewGroup.LayoutParams(-1, -1));
      }
    }
    while (localView == null)
    {
      return;
      localView.setVisibility(0);
      return;
    }
    localView.setVisibility(8);
  }
  
  public int getContentLayoutId()
  {
    return 2131561376;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      Object localObject;
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
                return false;
              } while (getActivity() == null);
              paramMessage = a(getActivity().app);
              this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, paramMessage).sendToTarget();
              return false;
            } while (getActivity() == null);
            paramMessage = (String)paramMessage.obj;
            if (!TextUtils.isEmpty(paramMessage))
            {
              localObject = new aypc();
              ((aypc)localObject).jdField_a_of_type_JavaLangString = paramMessage;
              ((aypc)localObject).jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
              a(getActivity().app, (aypc)localObject);
              return false;
            }
            a(getActivity().app);
            return false;
          } while (getActivity() == null);
          paramMessage = (aypc)paramMessage.obj;
          if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) && (!TextUtils.isEmpty(paramMessage.jdField_a_of_type_JavaLangString)))
          {
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(paramMessage.jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().length());
            if (paramMessage.d != 0)
            {
              localObject = this.jdField_a_of_type_JavaUtilList.iterator();
              while (((Iterator)localObject).hasNext()) {
                ((aypb)((Iterator)localObject).next()).jdField_a_of_type_Boolean = false;
              }
              ((aypb)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1)).jdField_a_of_type_Boolean = true;
              a((aypb)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1));
            }
            b(paramMessage.jdField_a_of_type_Int, paramMessage.jdField_b_of_type_Int);
            a(paramMessage.d, paramMessage.jdField_c_of_type_Int);
          }
        } while (this.jdField_a_of_type_AndroidWidgetCheckBox == null);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(paramMessage.jdField_a_of_type_Boolean);
        return false;
      } while (getActivity() == null);
      if ((paramMessage.obj != null) && ((paramMessage.obj instanceof aypc)))
      {
        paramMessage = (aypc)paramMessage.obj;
        if (!TextUtils.isEmpty(paramMessage.jdField_a_of_type_JavaLangString))
        {
          paramMessage.jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
          a(getActivity().app, paramMessage);
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
          return false;
          a(getActivity().app);
        }
      }
      paramMessage = (String)paramMessage.obj;
      if (!TextUtils.isEmpty(paramMessage))
      {
        localObject = new aypc();
        ((aypc)localObject).jdField_a_of_type_JavaLangString = paramMessage;
        ((aypc)localObject).jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
        a(getActivity().app, (aypc)localObject);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
        return false;
        a(getActivity().app);
      }
    } while (getActivity() == null);
    this.jdField_c_of_type_Boolean = false;
    getActivity().finish();
    return false;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.a(paramInt1, paramInt2, paramIntent);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout != null) {
      this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean onBackEvent()
  {
    if (getActivity() == null) {
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText())))
    {
      aypc localaypc = new aypc();
      localaypc.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
      localaypc.jdField_a_of_type_Int = this.jdField_b_of_type_QCSuixintieCheckItem.itemId;
      localaypc.jdField_b_of_type_Int = this.jdField_b_of_type_QCSuixintieCheckItem.fontType;
      localaypc.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getCurrentTextColor();
      localaypc.d = this.jdField_a_of_type_QCSuixintieCheckItem.itemId;
      bfur.a(getActivity(), amtj.a(2131713247), 2131718923, 2131718922, new aypf(this, localaypc), new aypg(this)).show();
    }
    for (;;)
    {
      return true;
      a(getActivity().app);
      if (getActivity() != null)
      {
        this.jdField_c_of_type_Boolean = false;
        getActivity().finish();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    boolean bool;
    label384:
    do
    {
      do
      {
        for (;;)
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          c();
          a(2);
          VasWebviewUtil.reportCommercialDrainage("friend_wall", "icon_click", "", 0, "", "1");
          continue;
          c();
          a(3);
          VasWebviewUtil.reportCommercialDrainage("friend_wall", "icon_click", "", 0, "", "2");
          continue;
          onBackEvent();
          bcef.b(null, "dc00898", "", "", "0X800AB30", "0X800AB30", 0, 0, "0", "0", "", "");
          continue;
          if ((getActivity() == null) || (NetworkUtil.isNetSupport(getActivity()))) {
            break;
          }
          QQToast.a(getActivity(), 1, getString(2131692035), 0).a();
        }
      } while ((getActivity() == null) || (this.jdField_a_of_type_ComTencentWidgetXEditTextEx == null) || (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText() == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().toString())));
      if (this.jdField_a_of_type_Bhht == null) {
        this.jdField_a_of_type_Bhht = new bhht(getActivity(), getActivity().getTitleBarHeight());
      }
      this.jdField_a_of_type_Bhht.a(getResources().getString(2131694826));
      this.jdField_a_of_type_Bhht.show();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.jdField_b_of_type_QCSuixintieCheckItem);
      localArrayList.add(this.jdField_a_of_type_QCSuixintieCheckItem);
      String str = String.valueOf(a(getActivity().app));
      BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
      QQAppInterface localQQAppInterface = getActivity().app;
      long l1 = this.jdField_a_of_type_Long;
      long l2 = Long.valueOf(getActivity().app.getCurrentUin()).longValue();
      if (this.jdField_b_of_type_Boolean) {
        break;
      }
      bool = true;
      ayow.a(localBaseApplication, localQQAppInterface, l1, l2, bool, str, str, bhmx.a(new SuixintieCheckInfo(localArrayList).toByteArray(), 0), ayow.b(this.jdField_a_of_type_ComTencentWidgetXEditTextEx), this.jdField_a_of_type_CooperationQzonePublishInterfaceQzonePublishMoodCallback);
      bcef.b(null, "dc00898", "", "", "0X800AB2F", "0X800AB2F", 0, 0, "0", "0", "", "");
    } while ((TextUtils.isEmpty(getActivity().getCurrentAccountUin())) || (TextUtils.isEmpty(String.valueOf(this.jdField_a_of_type_Long))));
    if (getActivity().getCurrentAccountUin().equals(String.valueOf(this.jdField_a_of_type_Long))) {}
    for (int i = 1;; i = 2)
    {
      bcef.b(null, "dc00898", "", "", "0X800AB2E", "0X800AB2E", i, 0, "0", "0", "", "");
      break;
      bool = false;
      break label384;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    String str;
    if (this.jdField_c_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("StickyNotePublishFragment", 2, "save draft when exit unexpected");
      }
      if ((getActivity() != null) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText())))
      {
        str = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
        if (!TextUtils.isEmpty(str)) {
          break label98;
        }
        a(getActivity().app);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bggs != null) {
        this.jdField_a_of_type_Bggs.a();
      }
      return;
      label98:
      aypc localaypc = new aypc();
      localaypc.jdField_a_of_type_JavaLangString = str;
      localaypc.jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
      a(getActivity().app, localaypc, true);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    boolean bool;
    if ((getActivity() != null) && (getActivity().app != null))
    {
      bool = ThemeUtil.isInNightMode(getActivity().app);
      if (!bool) {
        break label62;
      }
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(getActivity().getResources().getColor(2131165351));
    }
    for (;;)
    {
      e(bool);
      return;
      label62:
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(getActivity().getResources().getColor(2131166446));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment
 * JD-Core Version:    0.7.0.1
 */