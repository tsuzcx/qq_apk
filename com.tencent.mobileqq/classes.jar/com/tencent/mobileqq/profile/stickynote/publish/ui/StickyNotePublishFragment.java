package com.tencent.mobileqq.profile.stickynote.publish.ui;

import QC.SuixintieCheckInfo;
import QC.SuixintieCheckItem;
import aepi;
import alud;
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
import awsz;
import awta;
import awtb;
import awte;
import awtf;
import awtg;
import awth;
import awti;
import awtj;
import awtk;
import awtl;
import awtm;
import awtn;
import awto;
import awtp;
import awtq;
import awtr;
import awts;
import awtv;
import awwk;
import azkz;
import azmk;
import azqs;
import bamp;
import bdgm;
import bdin;
import bdjz;
import bdvb;
import bdvc;
import bdvs;
import bdvv;
import bety;
import bezi;
import bhsj;
import bjqf;
import com.etrump.mixlayout.ETTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.HorizontalListViewEx;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout;
import com.tencent.mobileqq.profile.view.SoftInputDetectView;
import com.tencent.mobileqq.richstatus.SignTextEditFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vas.VasResEngine.VasResDrawable;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ScrollView;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mww;

public class StickyNotePublishFragment
  extends IphoneTitleBarFragment
  implements Handler.Callback, View.OnClickListener, awte, awtv, awwk
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private SuixintieCheckItem jdField_a_of_type_QCSuixintieCheckItem = new SuixintieCheckItem();
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new awts(this);
  private View jdField_a_of_type_AndroidViewView;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private awtb jdField_a_of_type_Awtb;
  private bdvb jdField_a_of_type_Bdvb;
  private bety jdField_a_of_type_Bety;
  private bjqf jdField_a_of_type_Bjqf = new awti(this);
  private ETTextView jdField_a_of_type_ComEtrumpMixlayoutETTextView;
  private EmoticonMainPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
  private StickyNoteShopLayout jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout;
  private SoftInputDetectView jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView;
  private ScrollView jdField_a_of_type_ComTencentWidgetScrollView;
  private XEditTextEx jdField_a_of_type_ComTencentWidgetXEditTextEx;
  private List<awtf> jdField_a_of_type_JavaUtilList = new ArrayList();
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
    paramView.setCallBack(new awto(paramEditText, paramQQAppInterface, paramBaseActivity));
    paramView.jdField_c_of_type_Boolean = true;
    paramView.f = true;
    paramView.jdField_a_of_type_Boolean = false;
    paramView.jdField_b_of_type_Boolean = true;
    paramView.e = true;
    paramView.a(paramQQAppInterface, 100002, paramBaseActivity, paramBaseActivity.getTitleBarHeight(), null, null, false, new awtp());
    paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.setOverScrollMode(2);
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
      localTextPaint.setTextSize(aepi.a(2, 28, getResources()));
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
  
  public awtg a(QQAppInterface paramQQAppInterface)
  {
    awtg localawtg = new awtg();
    localawtg.jdField_a_of_type_JavaLangString = "";
    localawtg.jdField_a_of_type_Boolean = false;
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
      localawtg.jdField_a_of_type_JavaLangString = paramQQAppInterface.getString("draft_stick_note_content", "");
      localawtg.jdField_a_of_type_Boolean = paramQQAppInterface.getBoolean("draft_stick_note_only_self_see", false);
      localawtg.jdField_a_of_type_Int = paramQQAppInterface.getInt("draft_stick_note_font_id", 0);
      localawtg.jdField_b_of_type_Int = paramQQAppInterface.getInt("draft_stick_note_font_type", 0);
      localawtg.d = paramQQAppInterface.getInt("draft_stick_note_clothes_id", 0);
      localawtg.jdField_c_of_type_Int = paramQQAppInterface.getInt("draft_stick_note_text_color", 0);
      if (QLog.isColorLevel()) {
        QLog.i("StickyNotePublishFragment", 2, "readDraft() --> sticky content is " + localawtg.jdField_a_of_type_JavaLangString + " sticky isOnlySelfSee is " + localawtg.jdField_a_of_type_Boolean);
      }
    }
    return localawtg;
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
      bhsj.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
      return;
    case 1: 
      if (this.jdField_a_of_type_Boolean)
      {
        bhsj.b(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
        return;
      }
      a(true);
      b(true);
      return;
    case 2: 
      if (this.jdField_a_of_type_Boolean)
      {
        bhsj.b(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
        return;
      }
      a(true);
      a(this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130849707);
      VasWebviewUtil.reportCommercialDrainage("friend_wall", "page_show", "", 0, "", "1");
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      bhsj.b(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
      return;
    }
    a(true);
    a(this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout);
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130849709);
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
      bdvs localbdvs = new bdvs(localVasResDrawable, getActivity().app, 2130845711);
      localbdvs.a(true);
      localVasResDrawable.a(localbdvs);
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
        awtf localawtf = (awtf)localIterator.next();
        localawtf.jdField_a_of_type_Boolean = false;
        if (localawtf.jdField_a_of_type_Long != paramLong) {
          break label103;
        }
        localawtf.jdField_a_of_type_Boolean = true;
        i = 1;
      }
    }
    label103:
    for (;;)
    {
      break;
      if (i == 0) {
        ((awtf)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_Boolean = true;
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
  
  public void a(awtf paramawtf)
  {
    if ((paramawtf != null) && (this.titleRoot != null) && (getActivity() != null))
    {
      if (paramawtf.jdField_a_of_type_Long == 999L)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.performClick();
        VasWebviewUtil.reportCommercialDrainage("friend_wall", "icon_click", "", 0, "", "3");
      }
    }
    else {
      return;
    }
    a(getActivity().app, paramawtf.jdField_a_of_type_Long);
    a((int)paramawtf.jdField_a_of_type_Long, -1);
    this.titleRoot.setBackgroundDrawable(paramawtf.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setItemId((int)paramawtf.jdField_a_of_type_Long);
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
  
  public void a(QQAppInterface paramQQAppInterface, awtg paramawtg)
  {
    a(paramQQAppInterface, paramawtg, false);
  }
  
  public void a(QQAppInterface paramQQAppInterface, awtg paramawtg, boolean paramBoolean)
  {
    if ((paramQQAppInterface != null) && (paramawtg != null) && (!TextUtils.isEmpty(paramawtg.jdField_a_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("StickyNotePublishFragment", 2, "saveDraft() --> sticky content is " + paramawtg.jdField_a_of_type_JavaLangString + " sticky isOnlySelfSee is " + paramawtg.jdField_a_of_type_Boolean);
      }
      paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
      if (paramBoolean)
      {
        paramQQAppInterface.edit().putString("draft_stick_note_content", paramawtg.jdField_a_of_type_JavaLangString).commit();
        paramQQAppInterface.edit().putBoolean("draft_stick_note_only_self_see", paramawtg.jdField_a_of_type_Boolean).commit();
        paramQQAppInterface.edit().putInt("draft_stick_note_font_id", paramawtg.jdField_a_of_type_Int).commit();
        paramQQAppInterface.edit().putInt("draft_stick_note_font_type", paramawtg.jdField_b_of_type_Int).commit();
        paramQQAppInterface.edit().putInt("draft_stick_note_clothes_id", paramawtg.d).commit();
        paramQQAppInterface.edit().putInt("draft_stick_note_text_color", paramawtg.jdField_c_of_type_Int).commit();
      }
    }
    else
    {
      return;
    }
    paramQQAppInterface.edit().putString("draft_stick_note_content", paramawtg.jdField_a_of_type_JavaLangString).apply();
    paramQQAppInterface.edit().putBoolean("draft_stick_note_only_self_see", paramawtg.jdField_a_of_type_Boolean).apply();
    paramQQAppInterface.edit().putInt("draft_stick_note_font_id", paramawtg.jdField_a_of_type_Int).apply();
    paramQQAppInterface.edit().putInt("draft_stick_note_font_type", paramawtg.jdField_b_of_type_Int).apply();
    paramQQAppInterface.edit().putInt("draft_stick_note_clothes_id", paramawtg.d).apply();
    paramQQAppInterface.edit().putInt("draft_stick_note_text_color", paramawtg.jdField_c_of_type_Int).apply();
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
      ((Window)localObject).setBackgroundDrawable(new ColorDrawable(getActivity().getResources().getColor(2131167194)));
      if (ImmersiveUtils.isSupporImmersive() != 0)
      {
        localObject = ((PublicFragmentActivity)getActivity()).mSystemBarComp;
        ((SystemBarCompact)localObject).init();
        ((SystemBarCompact)localObject).setStatusBarColor(getResources().getColor(2131167140));
      }
      if (getTitleBarView() != null) {
        getTitleBarView().setBackgroundColor(getActivity().getResources().getColor(2131167140));
      }
      setLeftButton(2131690648, this);
      this.leftViewNotBack.setTextColor(getResources().getColor(2131167194));
      localObject = (RelativeLayout.LayoutParams)this.leftViewNotBack.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).leftMargin = aepi.a(8.0F, getResources());
      this.leftViewNotBack.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.leftViewNotBack.setOnTouchListener(mww.a);
      this.leftViewNotBack.setBackgroundDrawable(null);
      setRightButton(2131692682, this);
      this.rightViewText.setTextColor(getResources().getColor(2131167194));
      localObject = (RelativeLayout.LayoutParams)this.rightViewText.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).rightMargin = aepi.a(3.0F, getResources());
      this.rightViewText.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.rightViewText.setOnTouchListener(mww.a);
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
    if (this.jdField_a_of_type_Bdvb == null)
    {
      this.jdField_a_of_type_Bdvb = new bdvb(getActivity().app, paramInt1);
      localObject = new bdvv(this.jdField_a_of_type_Bdvb, (AppRuntime)localObject, paramInt2);
      ((bdvv)localObject).a(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView, this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize(), true);
      this.jdField_a_of_type_Bdvb.a((bdvc)localObject);
      ((bdvv)localObject).a(-1);
      return;
    }
    ((bdvv)this.jdField_a_of_type_Bdvb.a()).a(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView, this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize(), true);
    ((bdvv)this.jdField_a_of_type_Bdvb.a()).a(paramInt1, paramInt2);
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
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837526);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getActivity().getString(2131690365));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new awtq(this));
      if (this.jdField_a_of_type_Int > azkz.jdField_b_of_type_Int / 4) {}
      for (int i = this.jdField_a_of_type_Int;; i = azkz.jdField_b_of_type_Int / 3)
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
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844420);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getActivity().getString(2131690364));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new awtr(this));
  }
  
  public void c()
  {
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130849708);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130849706);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844420);
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
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = aepi.a(60.0F, getResources());
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(8);
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetScrollView.setVisibility(0);
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.requestFocus();
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
      if (this.jdField_c_of_type_Int > 5)
      {
        this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText(new bamp(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString(), 3, 28));
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
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText(new bamp(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString(), 3, 28));
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
    for (int i = 2131165307;; i = 2131167194)
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
      for (i = 2131165307;; i = 2131167194)
      {
        localTextView.setTextColor(localResources.getColor(i));
        return;
      }
    }
    setRightButtonEnable(false);
    TextView localTextView = this.rightViewText;
    Resources localResources = getResources();
    if (this.d) {}
    for (int i = 2131165311;; i = 2131167197)
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
    this.jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView = ((SoftInputDetectView)a(2131368358));
    this.jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView.setExcludeStatusBar(false);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView.setOnImStateChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131366457));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx = ((XEditTextEx)a(2131365852));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEditableFactory(new awth(this));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString())) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString().trim())))
    {
      d(false);
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)a(2131365861));
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnClickListener(new awtl(this));
      this.jdField_a_of_type_ComTencentWidgetScrollView = ((ScrollView)a(2131377298));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131375977));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new awtm(this));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)a(2131376095));
      paramLayoutInflater = new LinearLayoutManager(getActivity());
      paramLayoutInflater.setOrientation(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131369620));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131375941));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131368767));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(mww.a);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131368960));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener(mww.a);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)a(2131368961));
      this.jdField_c_of_type_AndroidWidgetImageView.setOnTouchListener(mww.a);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)a(2131364047));
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new awtn(this));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131379077));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131378914));
      if (!TextUtils.equals(String.valueOf(this.jdField_a_of_type_Long), getActivity().app.getCurrentAccountUin())) {
        break label846;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699891);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131699891);
      label481:
      this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131366444));
      this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = a(getActivity().app, getActivity(), this.mContentView, 2131365682, this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
      b(false);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131375940));
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(0);
      this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout = ((StickyNoteShopLayout)a(2131363193));
      this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setShopCallback(this);
      this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setAppId(9);
      this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setUseId(1);
      this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout = ((StickyNoteShopLayout)a(2131366684));
      this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setShopCallback(this);
      this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setAppId(5);
      this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setUseId(1);
      this.jdField_a_of_type_JavaUtilList.addAll(awsz.jdField_a_of_type_JavaUtilList);
      if (!azmk.b()) {
        break label869;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      e();
    }
    for (;;)
    {
      a(a(getActivity().app));
      this.jdField_a_of_type_Awtb = new awtb(this.jdField_a_of_type_JavaUtilList, getActivity(), this);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramLayoutInflater);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Awtb);
      if (this.titleRoot != null)
      {
        this.jdField_a_of_type_AndroidViewView = new View(getActivity());
        this.titleRoot.addView(this.jdField_a_of_type_AndroidViewView, 0, new RelativeLayout.LayoutParams(-1, -1));
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      azqs.b(null, "dc00898", "", "", "0X800AB2A", "0X800AB2A", 0, 0, "0", "0", "", "");
      VasWebviewUtil.reportCommercialDrainage("friend_wall", "icon_show", "", 0, "", "");
      return;
      d(true);
      break;
      label846:
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699890);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131699890);
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
        if (((awtf)localIterator.next()).jdField_a_of_type_Long == 999L) {
          localIterator.remove();
        }
      }
    }
  }
  
  public void e(boolean paramBoolean)
  {
    FragmentActivity localFragmentActivity = getActivity();
    View localView = localFragmentActivity.findViewById(2131371169);
    if (paramBoolean) {
      if (localView == null)
      {
        localView = new View(getActivity());
        localView.setBackgroundColor(1996488704);
        localView.setId(2131371169);
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
    return 2131561228;
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
              localObject = new awtg();
              ((awtg)localObject).jdField_a_of_type_JavaLangString = paramMessage;
              ((awtg)localObject).jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
              a(getActivity().app, (awtg)localObject);
              return false;
            }
            a(getActivity().app);
            return false;
          } while (getActivity() == null);
          paramMessage = (awtg)paramMessage.obj;
          if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) && (!TextUtils.isEmpty(paramMessage.jdField_a_of_type_JavaLangString)))
          {
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(paramMessage.jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().length());
            if (paramMessage.d != 0)
            {
              localObject = this.jdField_a_of_type_JavaUtilList.iterator();
              while (((Iterator)localObject).hasNext()) {
                ((awtf)((Iterator)localObject).next()).jdField_a_of_type_Boolean = false;
              }
              ((awtf)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1)).jdField_a_of_type_Boolean = true;
              a((awtf)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1));
            }
            b(paramMessage.jdField_a_of_type_Int, paramMessage.jdField_b_of_type_Int);
            a(paramMessage.d, paramMessage.jdField_c_of_type_Int);
          }
        } while (this.jdField_a_of_type_AndroidWidgetCheckBox == null);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(paramMessage.jdField_a_of_type_Boolean);
        return false;
      } while (getActivity() == null);
      if ((paramMessage.obj != null) && ((paramMessage.obj instanceof awtg)))
      {
        paramMessage = (awtg)paramMessage.obj;
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
        localObject = new awtg();
        ((awtg)localObject).jdField_a_of_type_JavaLangString = paramMessage;
        ((awtg)localObject).jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
        a(getActivity().app, (awtg)localObject);
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
      awtg localawtg = new awtg();
      localawtg.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
      localawtg.jdField_a_of_type_Int = this.jdField_b_of_type_QCSuixintieCheckItem.itemId;
      localawtg.jdField_b_of_type_Int = this.jdField_b_of_type_QCSuixintieCheckItem.fontType;
      localawtg.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getCurrentTextColor();
      localawtg.d = this.jdField_a_of_type_QCSuixintieCheckItem.itemId;
      bdgm.a(getActivity(), alud.a(2131714536), 2131720749, 2131720748, new awtj(this, localawtg), new awtk(this)).show();
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
    do
    {
      do
      {
        return;
        c();
        a(2);
        VasWebviewUtil.reportCommercialDrainage("friend_wall", "icon_click", "", 0, "", "1");
        return;
        c();
        a(3);
        VasWebviewUtil.reportCommercialDrainage("friend_wall", "icon_click", "", 0, "", "2");
        return;
        onBackEvent();
        azqs.b(null, "dc00898", "", "", "0X800AB30", "0X800AB30", 0, 0, "0", "0", "", "");
        return;
        if ((getActivity() != null) && (!bdin.d(getActivity())))
        {
          QQToast.a(getActivity(), 1, getString(2131692398), 0).a();
          return;
        }
      } while ((getActivity() == null) || (this.jdField_a_of_type_ComTencentWidgetXEditTextEx == null) || (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText() == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().toString())));
      if (this.jdField_a_of_type_Bety == null) {
        this.jdField_a_of_type_Bety = new bety(getActivity(), getActivity().getTitleBarHeight());
      }
      this.jdField_a_of_type_Bety.a(getResources().getString(2131695785));
      this.jdField_a_of_type_Bety.show();
      paramView = new ArrayList();
      paramView.add(this.jdField_b_of_type_QCSuixintieCheckItem);
      paramView.add(this.jdField_a_of_type_QCSuixintieCheckItem);
      BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
      QQAppInterface localQQAppInterface = getActivity().app;
      long l1 = this.jdField_a_of_type_Long;
      long l2 = Long.valueOf(getActivity().app.c()).longValue();
      if (this.jdField_b_of_type_Boolean) {
        break;
      }
      bool = true;
      awta.a(localBaseApplication, localQQAppInterface, l1, l2, bool, String.valueOf(a(getActivity().app)), bezi.a(new SuixintieCheckInfo(paramView).toByteArray(), 0), awta.b(this.jdField_a_of_type_ComTencentWidgetXEditTextEx), this.jdField_a_of_type_Bjqf);
      azqs.b(null, "dc00898", "", "", "0X800AB2F", "0X800AB2F", 0, 0, "0", "0", "", "");
    } while ((TextUtils.isEmpty(getActivity().getCurrentAccountUin())) || (TextUtils.isEmpty(String.valueOf(this.jdField_a_of_type_Long))));
    if (getActivity().getCurrentAccountUin().equals(String.valueOf(this.jdField_a_of_type_Long))) {}
    for (int i = 1;; i = 2)
    {
      azqs.b(null, "dc00898", "", "", "0X800AB2E", "0X800AB2E", i, 0, "0", "0", "", "");
      return;
      bool = false;
      break;
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
      if (this.jdField_a_of_type_Bdvb != null) {
        this.jdField_a_of_type_Bdvb.a();
      }
      return;
      label98:
      awtg localawtg = new awtg();
      localawtg.jdField_a_of_type_JavaLangString = str;
      localawtg.jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
      a(getActivity().app, localawtg, true);
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
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(getActivity().getResources().getColor(2131165307));
    }
    for (;;)
    {
      e(bool);
      return;
      label62:
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(getActivity().getResources().getColor(2131166351));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment
 * JD-Core Version:    0.7.0.1
 */