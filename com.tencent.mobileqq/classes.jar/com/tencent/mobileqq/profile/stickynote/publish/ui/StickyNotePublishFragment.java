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
  private int A = 0;
  private int B = 0;
  private boolean C = true;
  private boolean D = false;
  private boolean E = true;
  private List<BackgroundSelectBean> F = new ArrayList();
  private boolean G = false;
  private SuixintieCheckItem H = new SuixintieCheckItem();
  private SuixintieCheckItem I = new SuixintieCheckItem();
  private int J = 0;
  private VasRes K;
  private TextWatcher L = new StickyNotePublishFragment.9(this);
  private QzonePublishMoodCallback M = new StickyNotePublishFragment.10(this);
  Handler a = new Handler(Looper.getMainLooper(), this);
  Handler b = new Handler(ThreadManager.getSubThreadLooper(), this);
  private RelativeLayout c;
  private SoftInputDetectView d;
  private XEditTextEx e;
  private ETTextView f;
  private ScrollView g;
  private FrameLayout h;
  private RecyclerView i;
  private IEmoticonMainPanel j;
  private StickyNoteShopLayout k;
  private StickyNoteShopLayout l;
  private ImageView m;
  private ImageView n;
  private ImageView o;
  private CheckBox p;
  private TextView q;
  private FrameLayout r;
  private RelativeLayout s;
  private LinearLayout t;
  private RelativeLayout u;
  private TextView v;
  private QQProgressDialog w;
  private View x;
  private BackgroundSelectorAdapter y;
  private long z;
  
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
        if (!TextUtils.isEmpty(paramMessage.a))
        {
          paramMessage.b = this.D;
          a(getBaseActivity().app, paramMessage);
        }
        else
        {
          b(getBaseActivity().app);
        }
        this.a.sendEmptyMessage(4);
        return;
      }
      paramMessage = (String)paramMessage.obj;
      if (!TextUtils.isEmpty(paramMessage))
      {
        StickyDraftBean localStickyDraftBean = new StickyDraftBean();
        localStickyDraftBean.a = paramMessage;
        localStickyDraftBean.b = this.D;
        a(getBaseActivity().app, localStickyDraftBean);
      }
      else
      {
        b(getBaseActivity().app);
      }
      this.a.sendEmptyMessage(4);
    }
  }
  
  private void b(Message paramMessage)
  {
    if (getBaseActivity() != null)
    {
      paramMessage = (StickyDraftBean)paramMessage.obj;
      if ((this.e != null) && (!TextUtils.isEmpty(paramMessage.a)))
      {
        this.e.setText(paramMessage.a);
        localObject = this.e;
        ((XEditTextEx)localObject).setSelection(((XEditTextEx)localObject).getEditableText().length());
        if (paramMessage.f != 0)
        {
          localObject = this.F.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((BackgroundSelectBean)((Iterator)localObject).next()).b = false;
          }
          localObject = this.F;
          ((BackgroundSelectBean)((List)localObject).get(((List)localObject).size() - 1)).b = true;
          localObject = this.F;
          a((BackgroundSelectBean)((List)localObject).get(((List)localObject).size() - 1));
        }
        b(paramMessage.c, paramMessage.d);
        a(paramMessage.f, paramMessage.e);
      }
      Object localObject = this.p;
      if (localObject != null) {
        ((CheckBox)localObject).setChecked(paramMessage.b);
      }
    }
  }
  
  private <T extends View> T c(int paramInt)
  {
    return this.mContentView.findViewById(paramInt);
  }
  
  private void c(Message paramMessage)
  {
    if (getBaseActivity() != null)
    {
      paramMessage = (String)paramMessage.obj;
      if (!TextUtils.isEmpty(paramMessage))
      {
        StickyDraftBean localStickyDraftBean = new StickyDraftBean();
        localStickyDraftBean.a = paramMessage;
        localStickyDraftBean.b = this.D;
        a(getBaseActivity().app, localStickyDraftBean);
        return;
      }
      b(getBaseActivity().app);
    }
  }
  
  private void h()
  {
    if (getBaseActivity() != null)
    {
      StickyDraftBean localStickyDraftBean = c(getBaseActivity().app);
      this.a.obtainMessage(2, localStickyDraftBean).sendToTarget();
    }
  }
  
  private void i()
  {
    if ((getBaseActivity() != null) && (!NetworkUtil.isNetSupport(getBaseActivity())))
    {
      QQToast.makeText(getBaseActivity(), 1, getString(2131889169), 0).show();
      return;
    }
    if (getBaseActivity() != null)
    {
      Object localObject = this.e;
      if ((localObject != null) && (((XEditTextEx)localObject).getEditableText() != null) && (!TextUtils.isEmpty(this.e.getEditableText().toString())))
      {
        if (this.w == null) {
          this.w = new QQProgressDialog(getBaseActivity(), getBaseActivity().getTitleBarHeight());
        }
        this.w.a(getResources().getString(2131893016));
        this.w.show();
        localObject = new ArrayList();
        ((ArrayList)localObject).add(this.I);
        ((ArrayList)localObject).add(this.H);
        String str = String.valueOf(a(getBaseActivity().app));
        StickyNotePublishUtils.a(BaseApplicationImpl.getContext(), getBaseActivity().app, this.z, Long.valueOf(getBaseActivity().app.getCurrentUin()).longValue(), this.D ^ true, str, str, Base64.b(new SuixintieCheckInfo((ArrayList)localObject).toByteArray(), 0), StickyNotePublishUtils.b(this.e), this.M);
        j();
      }
    }
  }
  
  private void j()
  {
    ReportController.b(null, "dc00898", "", "", "0X800AB2F", "0X800AB2F", 0, 0, "0", "0", "", "");
    if ((!TextUtils.isEmpty(getBaseActivity().getCurrentAccountUin())) && (!TextUtils.isEmpty(String.valueOf(this.z))))
    {
      int i1;
      if (getBaseActivity().getCurrentAccountUin().equals(String.valueOf(this.z))) {
        i1 = 1;
      } else {
        i1 = 2;
      }
      ReportController.b(null, "dc00898", "", "", "0X800AB2E", "0X800AB2E", i1, 0, "0", "0", "", "");
    }
  }
  
  public long a(QQAppInterface paramQQAppInterface)
  {
    long l1 = 0L;
    if (paramQQAppInterface != null) {
      l1 = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getLong("default_stick_note_bg", 0L);
    }
    return l1;
  }
  
  public void a()
  {
    Object localObject = getArguments();
    if (localObject != null)
    {
      this.z = ((Bundle)localObject).getLong("key_host_uin");
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("host uin is ");
        ((StringBuilder)localObject).append(this.z);
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
    this.B = paramInt;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return;
          }
          if (this.C)
          {
            InputMethodUtil.b(this.e);
            return;
          }
          a(true);
          a(this.l);
          this.o.setImageResource(2130852457);
          VasWebviewUtil.a("friend_wall", "page_show", "", 0, "", "2");
          return;
        }
        if (this.C)
        {
          InputMethodUtil.b(this.e);
          return;
        }
        a(true);
        a(this.k);
        this.n.setImageResource(2130852454);
        VasWebviewUtil.a("friend_wall", "page_show", "", 0, "", "1");
        return;
      }
      if (this.C)
      {
        InputMethodUtil.b(this.e);
        return;
      }
      a(true);
      b(true);
      return;
    }
    a(false);
    b(false);
    this.g.setVisibility(8);
    this.f.setVisibility(8);
    this.e.setVisibility(0);
    this.e.requestFocus();
    InputMethodUtil.a(this.e);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.G = SignTextEditFragment.a(paramInt2);
    e();
    if (paramInt1 > 10000)
    {
      this.x.setVisibility(0);
      if ((this.x.getBackground() instanceof VasResDrawable))
      {
        ((VasResDrawable)this.x.getBackground()).a(paramInt1);
      }
      else
      {
        VasResDrawable localVasResDrawable = new VasResDrawable(getBaseActivity().app, paramInt1);
        SignatureAdapter localSignatureAdapter = new SignatureAdapter(localVasResDrawable, getBaseActivity().app, 2130847784);
        localSignatureAdapter.a(true);
        localVasResDrawable.a(localSignatureAdapter);
        this.x.setBackgroundDrawable(localVasResDrawable);
      }
      this.H.itemId = paramInt1;
    }
    else
    {
      this.H.itemId = 0;
    }
    this.H.appid = 9;
    this.e.setTextColor(paramInt2);
    this.f.mMsgId = System.currentTimeMillis();
    this.f.setTextColor(paramInt2);
  }
  
  public void a(long paramLong)
  {
    Object localObject = this.F;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = this.F.iterator();
      int i1 = 0;
      while (((Iterator)localObject).hasNext())
      {
        BackgroundSelectBean localBackgroundSelectBean = (BackgroundSelectBean)((Iterator)localObject).next();
        localBackgroundSelectBean.b = false;
        if (localBackgroundSelectBean.a == paramLong)
        {
          localBackgroundSelectBean.b = true;
          i1 = 1;
        }
      }
      if (i1 == 0) {
        ((BackgroundSelectBean)this.F.get(0)).b = true;
      }
    }
  }
  
  public void a(View paramView)
  {
    StickyNoteShopLayout localStickyNoteShopLayout = this.k;
    if (localStickyNoteShopLayout != paramView) {
      localStickyNoteShopLayout.b();
    }
    localStickyNoteShopLayout = this.l;
    if (localStickyNoteShopLayout != paramView) {
      localStickyNoteShopLayout.b();
    }
    this.j.getView().setVisibility(8);
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
    if ((paramQQAppInterface != null) && (paramStickyDraftBean != null) && (!TextUtils.isEmpty(paramStickyDraftBean.a)))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveDraft() --> sticky content is ");
        localStringBuilder.append(paramStickyDraftBean.a);
        localStringBuilder.append(" sticky isOnlySelfSee is ");
        localStringBuilder.append(paramStickyDraftBean.b);
        QLog.i("StickyNotePublishFragment", 2, localStringBuilder.toString());
      }
      paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
      if (paramBoolean)
      {
        paramQQAppInterface.edit().putString("draft_stick_note_content", paramStickyDraftBean.a).commit();
        paramQQAppInterface.edit().putBoolean("draft_stick_note_only_self_see", paramStickyDraftBean.b).commit();
        paramQQAppInterface.edit().putInt("draft_stick_note_font_id", paramStickyDraftBean.c).commit();
        paramQQAppInterface.edit().putInt("draft_stick_note_font_type", paramStickyDraftBean.d).commit();
        paramQQAppInterface.edit().putInt("draft_stick_note_clothes_id", paramStickyDraftBean.f).commit();
        paramQQAppInterface.edit().putInt("draft_stick_note_text_color", paramStickyDraftBean.e).commit();
        return;
      }
      paramQQAppInterface.edit().putString("draft_stick_note_content", paramStickyDraftBean.a).apply();
      paramQQAppInterface.edit().putBoolean("draft_stick_note_only_self_see", paramStickyDraftBean.b).apply();
      paramQQAppInterface.edit().putInt("draft_stick_note_font_id", paramStickyDraftBean.c).apply();
      paramQQAppInterface.edit().putInt("draft_stick_note_font_type", paramStickyDraftBean.d).apply();
      paramQQAppInterface.edit().putInt("draft_stick_note_clothes_id", paramStickyDraftBean.f).apply();
      paramQQAppInterface.edit().putInt("draft_stick_note_text_color", paramStickyDraftBean.e).apply();
    }
  }
  
  public void a(BackgroundSelectBean paramBackgroundSelectBean)
  {
    if ((paramBackgroundSelectBean != null) && (this.titleRoot != null) && (getBaseActivity() != null))
    {
      if (paramBackgroundSelectBean.a == 999L)
      {
        this.n.performClick();
        VasWebviewUtil.a("friend_wall", "icon_click", "", 0, "", "3");
        return;
      }
      a(getBaseActivity().app, paramBackgroundSelectBean.a);
      a((int)paramBackgroundSelectBean.a, -1);
      this.titleRoot.setBackgroundDrawable(paramBackgroundSelectBean.c);
      View localView = this.x;
      if (localView != null) {
        localView.setVisibility(8);
      }
      this.k.setItemId((int)paramBackgroundSelectBean.a);
    }
  }
  
  public void a(StickyNoteShopLayout paramStickyNoteShopLayout)
  {
    a(paramStickyNoteShopLayout);
    b(paramStickyNoteShopLayout.a(this.A));
    this.t.setVisibility(0);
    paramStickyNoteShopLayout.b(0);
  }
  
  public void a(boolean paramBoolean)
  {
    FrameLayout localFrameLayout = this.r;
    if (localFrameLayout != null)
    {
      int i1;
      if (paramBoolean) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      localFrameLayout.setVisibility(i1);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    int i1 = 0;
    if (paramBoolean)
    {
      this.C = true;
      this.A = paramInt;
      this.t.setVisibility(0);
      a(false);
      b(false);
      b(this.A);
      c(false);
      int i2 = this.A;
      RelativeLayout localRelativeLayout = this.s;
      if (localRelativeLayout == null) {
        paramInt = i1;
      } else {
        paramInt = localRelativeLayout.getHeight();
      }
      c(i2, paramInt);
      return;
    }
    this.C = false;
    c(true);
    paramInt = this.B;
    if (paramInt == 1)
    {
      a(true);
      b(true);
      return;
    }
    if (paramInt == 0)
    {
      this.t.setVisibility(8);
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
      ((Window)localObject).setBackgroundDrawable(new ColorDrawable(getBaseActivity().getResources().getColor(2131168464)));
      if (ImmersiveUtils.isSupporImmersive() != 0)
      {
        localObject = ((PublicFragmentActivity)getBaseActivity()).mSystemBarComp;
        ((SystemBarCompact)localObject).init();
        ((SystemBarCompact)localObject).setStatusBarColor(getResources().getColor(2131168376));
      }
      if (getTitleBarView() != null) {
        getTitleBarView().setBackgroundColor(getBaseActivity().getResources().getColor(2131168376));
      }
      setLeftButton(2131887648, this);
      this.leftViewNotBack.setTextColor(getResources().getColor(2131168464));
      localObject = (RelativeLayout.LayoutParams)this.leftViewNotBack.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(8.0F, getResources());
      this.leftViewNotBack.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.leftViewNotBack.setOnTouchListener(UITools.a);
      this.leftViewNotBack.setBackgroundDrawable(null);
      setRightButton(2131889474, this);
      this.rightViewText.setTextColor(getResources().getColor(2131168464));
      localObject = (RelativeLayout.LayoutParams)this.rightViewText.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.b(3.0F, getResources());
      this.rightViewText.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.rightViewText.setOnTouchListener(UITools.a);
      this.rightViewText.setBackgroundDrawable(null);
    }
  }
  
  public void b(int paramInt)
  {
    ((RelativeLayout.LayoutParams)this.t.getLayoutParams()).bottomMargin = paramInt;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(" fontId:");
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append(" fontType:");
    ((StringBuilder)localObject1).append(paramInt2);
    QLog.d("StickyNotePublishFragment", 1, ((StringBuilder)localObject1).toString());
    localObject1 = this.I;
    ((SuixintieCheckItem)localObject1).itemId = paramInt1;
    ((SuixintieCheckItem)localObject1).fontType = paramInt2;
    ((SuixintieCheckItem)localObject1).appid = 5;
    this.f.setFont(0, System.currentTimeMillis());
    this.f.mMsgId = System.currentTimeMillis();
    localObject1 = getBaseActivity().app;
    Object localObject2 = this.K;
    if (localObject2 == null)
    {
      this.K = new VasRes(getBaseActivity().app, paramInt1);
      localObject1 = new SignatureFontAdapter(this.K, (AppRuntime)localObject1, paramInt2);
      localObject2 = this.f;
      ((SignatureFontAdapter)localObject1).a((ETTextView)localObject2, ((ETTextView)localObject2).getTextSize(), true);
      this.K.a((VasResAdapter)localObject1);
      ((SignatureFontAdapter)localObject1).a(-1);
      return;
    }
    localObject1 = (SignatureFontAdapter)((VasRes)localObject2).c();
    localObject2 = this.f;
    ((SignatureFontAdapter)localObject1).a((ETTextView)localObject2, ((ETTextView)localObject2).getTextSize(), true);
    ((SignatureFontAdapter)this.K.c()).a(paramInt1, paramInt2);
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
      paramQQAppInterface.edit().putString("draft_stick_note_content", "").apply();
      paramQQAppInterface.edit().putBoolean("draft_stick_note_only_self_see", false).apply();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.j == null) {
      return;
    }
    c();
    if (paramBoolean)
    {
      a(this.j.getView());
      this.j.getView().setVisibility(0);
      this.m.setImageResource(2130837628);
      this.m.setContentDescription(getBaseActivity().getString(2131887158));
      this.m.setOnClickListener(new StickyNotePublishFragment.7(this));
      int i1;
      if (this.A > ScreenUtil.SCREEN_HIGHT / 4) {
        i1 = this.A;
      } else {
        i1 = ScreenUtil.SCREEN_HIGHT / 3;
      }
      ViewGroup.LayoutParams localLayoutParams = this.j.getView().getLayoutParams();
      localLayoutParams.height = i1;
      this.j.getView().setMinimumHeight(localLayoutParams.height);
      this.j.getView().setLayoutParams(localLayoutParams);
      this.t.setVisibility(0);
      b(i1);
      c(false);
      return;
    }
    this.j.getView().setVisibility(8);
    this.m.setImageResource(2130846244);
    this.m.setContentDescription(getBaseActivity().getString(2131887157));
    this.m.setOnClickListener(new StickyNotePublishFragment.8(this));
  }
  
  public StickyDraftBean c(QQAppInterface paramQQAppInterface)
  {
    StickyDraftBean localStickyDraftBean = new StickyDraftBean();
    localStickyDraftBean.a = "";
    localStickyDraftBean.b = false;
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
      localStickyDraftBean.a = paramQQAppInterface.getString("draft_stick_note_content", "");
      localStickyDraftBean.b = paramQQAppInterface.getBoolean("draft_stick_note_only_self_see", false);
      localStickyDraftBean.c = paramQQAppInterface.getInt("draft_stick_note_font_id", 0);
      localStickyDraftBean.d = paramQQAppInterface.getInt("draft_stick_note_font_type", 0);
      localStickyDraftBean.f = paramQQAppInterface.getInt("draft_stick_note_clothes_id", 0);
      localStickyDraftBean.e = paramQQAppInterface.getInt("draft_stick_note_text_color", 0);
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("readDraft() --> sticky content is ");
        paramQQAppInterface.append(localStickyDraftBean.a);
        paramQQAppInterface.append(" sticky isOnlySelfSee is ");
        paramQQAppInterface.append(localStickyDraftBean.b);
        QLog.i("StickyNotePublishFragment", 2, paramQQAppInterface.toString());
      }
    }
    return localStickyDraftBean;
  }
  
  public void c()
  {
    this.o.setImageResource(2130852456);
    this.n.setImageResource(2130852453);
    this.m.setImageResource(2130846244);
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    View localView = this.x;
    if (localView != null) {
      ((ViewGroup.MarginLayoutParams)localView.getLayoutParams()).bottomMargin = (paramInt1 + paramInt2);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      if (((XEditTextEx)localObject).getText() == null) {
        return;
      }
      localObject = (RelativeLayout.LayoutParams)this.h.getLayoutParams();
      int i1 = 8;
      if (paramBoolean)
      {
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.b(60.0F, getResources());
        this.e.setVisibility(8);
        this.f.setVisibility(0);
        this.g.setVisibility(0);
        this.f.requestFocus();
        this.f.setText(this.e.getText().toString());
        if (this.J > 5)
        {
          this.f.setText(new QQText(this.e.getText().toString(), 3, 28));
          this.f.setTextSize(24.0F);
        }
        else
        {
          this.f.setTextSize(28.0F);
          this.f.setText(new QQText(this.e.getText().toString(), 3, 28));
        }
        if (TextUtils.isEmpty(this.e.getText().toString())) {
          ((FrameLayout.LayoutParams)this.g.getLayoutParams()).gravity = 48;
        } else {
          ((FrameLayout.LayoutParams)this.g.getLayoutParams()).gravity = 19;
        }
        b(this.I.itemId, this.I.fontType);
      }
      else
      {
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = 0;
        this.e.setVisibility(0);
        this.e.requestFocus();
        this.f.setVisibility(8);
        this.g.setVisibility(8);
      }
      if (paramBoolean)
      {
        localObject = this.u;
        if (this.D) {
          i1 = 0;
        }
        ((RelativeLayout)localObject).setVisibility(i1);
        return;
      }
      this.u.setVisibility(8);
    }
  }
  
  public int d()
  {
    Object localObject = this.e;
    if ((localObject != null) && (((XEditTextEx)localObject).getEditableText() != null))
    {
      localObject = this.e.getPaint();
      float f1 = this.e.getTextSize();
      ((TextPaint)localObject).setTextSize(AIOUtils.a(2, 28, getResources()));
      StaticLayout localStaticLayout = new StaticLayout(this.e.getEditableText().toString(), (TextPaint)localObject, this.e.getWidth() - this.e.getPaddingLeft() - this.e.getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
      ((TextPaint)localObject).setTextSize(f1);
      return localStaticLayout.getLineCount();
    }
    return -1;
  }
  
  public void d(boolean paramBoolean)
  {
    int i1;
    if (paramBoolean)
    {
      setRightButtonEnable(true);
      localTextView = this.rightViewText;
      localResources = getResources();
      if (this.G) {
        i1 = 2131165564;
      } else {
        i1 = 2131168464;
      }
      localTextView.setTextColor(localResources.getColor(i1));
      return;
    }
    setRightButtonEnable(false);
    TextView localTextView = this.rightViewText;
    Resources localResources = getResources();
    if (this.G) {
      i1 = 2131165566;
    } else {
      i1 = 2131168467;
    }
    localTextView.setTextColor(localResources.getColor(i1));
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    b();
    a();
    this.d = ((SoftInputDetectView)c(2131435828));
    this.d.setExcludeStatusBar(false);
    this.d.setOnImStateChangedListener(this);
    this.h = ((FrameLayout)c(2131433298));
    this.e = ((XEditTextEx)c(2131432636));
    this.e.setEditableFactory(new StickyNotePublishFragment.1(this));
    this.e.addTextChangedListener(this.L);
    if ((this.e.getText() != null) && (!TextUtils.isEmpty(this.e.getText().toString())) && (!TextUtils.isEmpty(this.e.getText().toString().trim()))) {
      d(true);
    } else {
      d(false);
    }
    this.f = ((ETTextView)c(2131432645));
    this.f.setOnClickListener(new StickyNotePublishFragment.2(this));
    this.g = ((ScrollView)c(2131446654));
    this.c = ((RelativeLayout)c(2131445031));
    this.c.setOnTouchListener(new StickyNotePublishFragment.3(this));
    this.i = ((RecyclerView)c(2131445204));
    paramLayoutInflater = new LinearLayoutManager(getBaseActivity());
    paramLayoutInflater.setOrientation(0);
    this.t = ((LinearLayout)c(2131437415));
    this.s = ((RelativeLayout)c(2131444994));
    this.m = ((ImageView)c(2131436359));
    this.m.setOnTouchListener(UITools.a);
    this.n = ((ImageView)c(2131436647));
    this.n.setOnTouchListener(UITools.a);
    this.n.setOnClickListener(this);
    this.o = ((ImageView)c(2131436648));
    this.o.setOnTouchListener(UITools.a);
    this.o.setOnClickListener(this);
    this.p = ((CheckBox)c(2131430420));
    this.D = false;
    this.p.setChecked(false);
    this.p.setOnCheckedChangeListener(new StickyNotePublishFragment.4(this));
    this.q = ((TextView)c(2131448854));
    this.v = ((TextView)c(2131448628));
    if (TextUtils.equals(String.valueOf(this.z), getBaseActivity().app.getCurrentAccountUin()))
    {
      this.q.setText(2131897374);
      this.v.setText(2131897374);
    }
    else
    {
      this.q.setText(2131897373);
      this.v.setText(2131897373);
    }
    this.r = ((FrameLayout)c(2131433275));
    this.r.setVisibility(8);
    this.j = a(getBaseActivity().app, getBaseActivity(), this.mContentView, 2131432442, this.e);
    b(false);
    this.u = ((RelativeLayout)c(2131444993));
    this.b.sendEmptyMessage(0);
    this.k = ((StickyNoteShopLayout)c(2131429415));
    this.k.setShopCallback(this);
    this.k.setAppId(9);
    this.k.setUseId(1);
    this.l = ((StickyNoteShopLayout)c(2131433556));
    this.l.setShopCallback(this);
    this.l.setAppId(5);
    this.l.setUseId(1);
    this.F.addAll(StickyNotePublishConstant.a);
    if (SimpleUIUtil.e())
    {
      this.n.setVisibility(8);
      this.o.setVisibility(8);
      f();
    }
    else
    {
      this.n.setVisibility(0);
      this.o.setVisibility(0);
    }
    a(a(getBaseActivity().app));
    this.y = new BackgroundSelectorAdapter(this.F, getBaseActivity(), this);
    this.i.setLayoutManager(paramLayoutInflater);
    this.i.setAdapter(this.y);
    if (this.titleRoot != null)
    {
      this.x = new View(getBaseActivity());
      this.titleRoot.addView(this.x, 0, new RelativeLayout.LayoutParams(-1, -1));
      this.x.setVisibility(8);
    }
    ReportController.b(null, "dc00898", "", "", "0X800AB2A", "0X800AB2A", 0, 0, "0", "0", "", "");
    VasWebviewUtil.a("friend_wall", "icon_show", "", 0, "", "");
  }
  
  public void e()
  {
    TextView localTextView = this.leftViewNotBack;
    Resources localResources = getResources();
    int i1;
    if (this.G) {
      i1 = 2131165564;
    } else {
      i1 = 2131168464;
    }
    localTextView.setTextColor(localResources.getColor(i1));
    d(this.rightViewText.isEnabled());
    ImmersiveUtils.setStatusTextColor(this.G, getBaseActivity().getWindow());
  }
  
  public void e(boolean paramBoolean)
  {
    BaseActivity localBaseActivity = getBaseActivity();
    View localView = localBaseActivity.findViewById(2131439329);
    if (paramBoolean)
    {
      if (localView == null)
      {
        localView = new View(getBaseActivity());
        localView.setBackgroundColor(1996488704);
        localView.setId(2131439329);
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
  
  public void f()
  {
    Object localObject = this.F;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((BackgroundSelectBean)((Iterator)localObject).next()).a == 999L) {
          ((Iterator)localObject).remove();
        }
      }
    }
  }
  
  public boolean g()
  {
    return (this.e.getText() != null) && (!TextUtils.isEmpty(this.e.getText().toString().trim()));
  }
  
  protected int getContentLayoutId()
  {
    return 2131627742;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if (i1 != 4) {
              return false;
            }
            if (getBaseActivity() != null)
            {
              this.E = false;
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
      h();
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
    StickyNoteShopLayout localStickyNoteShopLayout = this.k;
    if (localStickyNoteShopLayout != null) {
      localStickyNoteShopLayout.a(paramInt1, paramInt2, paramIntent);
    }
    localStickyNoteShopLayout = this.l;
    if (localStickyNoteShopLayout != null) {
      localStickyNoteShopLayout.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean onBackEvent()
  {
    if (getBaseActivity() == null) {
      return false;
    }
    Object localObject = this.e;
    if ((localObject != null) && (!TextUtils.isEmpty(((XEditTextEx)localObject).getText())))
    {
      localObject = new StickyDraftBean();
      ((StickyDraftBean)localObject).a = this.e.getText().toString();
      ((StickyDraftBean)localObject).c = this.I.itemId;
      ((StickyDraftBean)localObject).d = this.I.fontType;
      ((StickyDraftBean)localObject).e = this.e.getCurrentTextColor();
      ((StickyDraftBean)localObject).f = this.H.itemId;
      DialogUtil.a(getBaseActivity(), HardCodeUtil.a(2131911550), 2131917171, 2131917170, new StickyNotePublishFragment.11(this, (StickyDraftBean)localObject), new StickyNotePublishFragment.12(this)).show();
    }
    else
    {
      b(getBaseActivity().app);
      if (getBaseActivity() != null)
      {
        this.E = false;
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
    case 2131436648: 
      c();
      a(3);
      VasWebviewUtil.a("friend_wall", "icon_click", "", 0, "", "2");
      break;
    case 2131436647: 
      c();
      a(2);
      VasWebviewUtil.a("friend_wall", "icon_click", "", 0, "", "1");
      break;
    case 2131436211: 
      i();
      break;
    case 2131436182: 
      onBackEvent();
      ReportController.b(null, "dc00898", "", "", "0X800AB30", "0X800AB30", 0, 0, "0", "0", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.E)
    {
      if (QLog.isColorLevel()) {
        QLog.i("StickyNotePublishFragment", 2, "save draft when exit unexpected");
      }
      if (getBaseActivity() != null)
      {
        localObject = this.e;
        if ((localObject != null) && (!TextUtils.isEmpty(((XEditTextEx)localObject).getText())))
        {
          localObject = this.e.getText().toString();
          if (TextUtils.isEmpty((CharSequence)localObject))
          {
            b(getBaseActivity().app);
          }
          else
          {
            StickyDraftBean localStickyDraftBean = new StickyDraftBean();
            localStickyDraftBean.a = ((String)localObject);
            localStickyDraftBean.b = this.D;
            a(getBaseActivity().app, localStickyDraftBean, true);
          }
        }
      }
    }
    Object localObject = this.K;
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
        this.s.setBackgroundColor(getBaseActivity().getResources().getColor(2131165564));
      } else {
        this.s.setBackgroundColor(getBaseActivity().getResources().getColor(2131167316));
      }
      e(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment
 * JD-Core Version:    0.7.0.1
 */