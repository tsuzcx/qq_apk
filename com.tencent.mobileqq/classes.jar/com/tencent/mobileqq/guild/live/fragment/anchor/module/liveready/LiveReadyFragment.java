package com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.live.QQGuildLiveRoomStartParams;
import com.tencent.mobileqq.guild.live.QQGuildLiveStartParamsCache;
import com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment;
import com.tencent.mobileqq.guild.live.livemanager.LiveRoomEventListener;
import com.tencent.mobileqq.guild.live.livemanager.QQGuildLiveEventHelper;
import com.tencent.mobileqq.guild.live.livemanager.anchor.QQGuildLiveAnchorRoomMgr;
import com.tencent.mobileqq.guild.live.livemanager.model.QQGuildEndLiveModel;
import com.tencent.mobileqq.guild.live.livemanager.repo.QQGuildLiveRoomUiData;
import com.tencent.mobileqq.guild.share.live.GuildLiveShareActionSheet;
import com.tencent.mobileqq.guild.util.GuildFastClickUtil;
import com.tencent.mobileqq.guild.util.GuildLiveDtUtil;
import com.tencent.mobileqq.guild.util.GuildLiveToast;
import com.tencent.mobileqq.guild.util.livedata.GulidLiveDataUtils;
import com.tencent.mobileqq.guild.util.livedata.GulidLiveDataUtils.Function3;
import com.tencent.mobileqq.guild.widget.CharacterCountEditText;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.callback.IResultCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomAttr;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/LiveReadyFragment;", "Lcom/tencent/mobileqq/guild/live/fragment/base/QQGuildLiveModuleBaseFragment;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/guild/live/livemanager/LiveRoomEventListener;", "()V", "chooseCoverController", "Lcom/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/ChooseCoverController;", "mAnchorRoomMgr", "Lcom/tencent/mobileqq/guild/live/livemanager/anchor/QQGuildLiveAnchorRoomMgr;", "kotlin.jvm.PlatformType", "mCheckBoxFl", "Landroid/widget/FrameLayout;", "mCopySecretKey", "Landroid/widget/ImageView;", "mCopySerAddr", "mHasFillName", "Landroidx/lifecycle/MutableLiveData;", "", "mLiveAvatar", "Lcom/tencent/biz/qqstory/storyHome/discover/RoundCornerImageView;", "mLiveBackIcon", "mLiveName", "Lcom/tencent/mobileqq/guild/widget/CharacterCountEditText;", "mLiveProtocol", "Landroid/widget/TextView;", "mLiveProtocolCheckBox", "Landroid/widget/CheckBox;", "mLiveReadyLL", "Landroid/widget/LinearLayout;", "mLiveSecretKey", "mLiveSerAddr", "mLiveStartBtn", "Landroid/widget/Button;", "mLiveStartBtnDis", "mLiveTips", "mProtocolStatus", "mProtocolText", "", "mRoomAttr", "Lcom/tencent/mobileqq/qqlive/data/anchor/sso/QQLiveAnchorDataRoomAttr;", "mRoomID", "", "mUploadUrl", "mVideoPre", "mVideoPreContainer", "Landroid/widget/RelativeLayout;", "doHideSoftKeyBoard", "", "v", "Landroid/view/View;", "exitLiveReadyFragment", "getClickableSpan", "Landroid/text/SpannableString;", "getLayoutId", "", "getSelfAvatar", "Landroid/graphics/drawable/Drawable;", "getShareText", "handleCheckBoxClick", "initEditTextView", "editText", "initSubVideoBarHeight", "subVideoBar", "isWrapContent", "needImmersive", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "context", "Landroid/content/Context;", "onAutoExitRoomPage", "dialogTip", "onBackEvent", "onClick", "onDestroyView", "onDetach", "onEndLiveEvent", "model", "Lcom/tencent/mobileqq/guild/live/livemanager/model/QQGuildEndLiveModel;", "onLiveRoomStatusOpenEvent", "onNewIntent", "intent", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "reportStartLive", "setDtElement", "setDtPage", "setProtocolSpan", "sharePlainText", "startLive", "Companion", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public final class LiveReadyFragment
  extends QQGuildLiveModuleBaseFragment
  implements View.OnClickListener, LiveRoomEventListener
{
  public static final LiveReadyFragment.Companion a = new LiveReadyFragment.Companion(null);
  private final String A;
  private HashMap B;
  private final QQGuildLiveAnchorRoomMgr d = QQGuildLiveAnchorRoomMgr.a();
  private ChooseCoverController e;
  private RoundCornerImageView f;
  private CharacterCountEditText g;
  private TextView h;
  private TextView i;
  private TextView j;
  private Button k;
  private Button l;
  private FrameLayout m;
  private RelativeLayout n;
  private CheckBox o;
  private FrameLayout p;
  private ImageView q;
  private ImageView r;
  private LinearLayout s;
  private TextView t;
  private ImageView u;
  private QQLiveAnchorDataRoomAttr v;
  private long w;
  private String x = "";
  private final MutableLiveData<Boolean> y;
  private final MutableLiveData<Boolean> z;
  
  public LiveReadyFragment()
  {
    Boolean localBoolean = Boolean.valueOf(false);
    this.y = new MutableLiveData(localBoolean);
    this.z = new MutableLiveData(localBoolean);
    this.A = HardCodeUtil.a(2131890458);
  }
  
  private final void a(RelativeLayout paramRelativeLayout)
  {
    if (getContext() == null) {
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = paramRelativeLayout.getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = (DisplayUtil.a(getContext()).a * 9 / 16);
    paramRelativeLayout.setLayoutParams(localLayoutParams);
  }
  
  private final void a(CharacterCountEditText paramCharacterCountEditText)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramCharacterCountEditText.setLimitCount(20);
    }
    paramCharacterCountEditText.addTextChangedListener((TextWatcher)new LiveReadyFragment.initEditTextView.1(this));
  }
  
  private final void b(View paramView)
  {
    if (paramView.getId() != 2131437367)
    {
      Object localObject = paramView.getContext().getSystemService("input_method");
      if (localObject != null)
      {
        ((InputMethodManager)localObject).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }
  }
  
  private final void c(View paramView)
  {
    Object localObject1 = QQGuildLiveStartParamsCache.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "QQGuildLiveStartParamsCache.getCache()");
    localObject1 = ((QQGuildLiveRoomStartParams)localObject1).getChannelInfo();
    Object localObject2 = QQGuildLiveStartParamsCache.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "QQGuildLiveStartParamsCache.getCache()");
    localObject2 = ((QQGuildLiveRoomStartParams)localObject2).getGuildInfo();
    if (localObject1 != null)
    {
      if (localObject2 == null) {
        return;
      }
      Object localObject3 = new GuildLiveDtUtil((IGProChannelInfo)localObject1, (IGProGuildInfo)localObject2);
      localObject2 = i().getRuntimeService(IGPSService.class, "");
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "appRuntime.getRuntimeSer…va, ProcessConstant.MAIN)");
      localObject2 = ((IGPSService)localObject2).getSelfTinyId();
      localObject3 = ((GuildLiveDtUtil)localObject3).a();
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "pageParams");
      localObject3 = (Map)localObject3;
      ((Map)localObject3).put("sgrp_stream_star_type", Integer.valueOf(1));
      ((Map)localObject3).put("sgrp_access_id", localObject2);
      VideoReport.setPageId(paramView, "pg_sgrp_stream_star");
      ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setChannelPageParams(paramView, (IGProChannelInfo)localObject1, (Map)localObject3);
    }
  }
  
  private final void d(View paramView)
  {
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementClickParams(paramView.findViewById(2131437380), "em_stream_star_type", null);
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementClickParams(paramView.findViewById(2131431426), "em_stream_star_copy", null);
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementClickParams(paramView.findViewById(2131431425), "em_stream_star_copy", null);
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementClickParams(paramView.findViewById(2131437367), "em_stream_star_title", null);
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementClickParams(paramView.findViewById(2131437352), "em_stream_star_cover", null);
  }
  
  private final void g()
  {
    TextView localTextView = this.j;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mLiveProtocol");
    }
    localTextView.setText((CharSequence)n());
    localTextView = this.j;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mLiveProtocol");
    }
    localTextView.setMovementMethod(LinkMovementMethod.getInstance());
  }
  
  private final Drawable h()
  {
    Object localObject = FaceDrawable.getDefaultDrawable(1, 1);
    AppInterface localAppInterface = (AppInterface)i();
    AppRuntime localAppRuntime = i();
    Intrinsics.checkExpressionValueIsNotNull(localAppRuntime, "appRuntime");
    localObject = FaceDrawable.getFaceDrawable(localAppInterface, 1, localAppRuntime.getCurrentUin(), 1, (Drawable)localObject, (Drawable)localObject);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "FaceDrawable.getFaceDraw…rawable, defaultDrawable)");
    return (Drawable)localObject;
  }
  
  private final void j()
  {
    String str = k();
    Object localObject = requireContext().getSystemService("clipboard");
    if (localObject != null)
    {
      localObject = (ClipboardManager)localObject;
      ClipData localClipData = ClipData.newPlainText((CharSequence)"label", (CharSequence)str);
      Intrinsics.checkExpressionValueIsNotNull(localClipData, "ClipData.newPlainText(\"label\", shareText)");
      ClipboardMonitor.setPrimaryClip((ClipboardManager)localObject, localClipData);
      ((ClipboardManager)localObject).setPrimaryClip(localClipData);
      QQToast.makeText(getContext(), 2131890476, 0).show();
      new GuildLiveShareActionSheet((Activity)requireActivity(), str).a();
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.content.ClipboardManager");
  }
  
  private final String k()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getString(2131890468));
    ((StringBuilder)localObject).append("：");
    ((StringBuilder)localObject).append("\n");
    TextView localTextView = this.h;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mLiveSerAddr");
    }
    ((StringBuilder)localObject).append(localTextView.getText().toString());
    ((StringBuilder)localObject).append("\n");
    ((StringBuilder)localObject).append("\n");
    ((StringBuilder)localObject).append(getString(2131890466));
    ((StringBuilder)localObject).append("：");
    ((StringBuilder)localObject).append("\n");
    localTextView = this.i;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mLiveSecretKey");
    }
    ((StringBuilder)localObject).append(localTextView.getText().toString());
    localObject = ((StringBuilder)localObject).toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "shareTxtBuilder.toString()");
    return localObject;
  }
  
  private final void l()
  {
    Object localObject = this.o;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mLiveProtocolCheckBox");
    }
    CheckBox localCheckBox = this.o;
    if (localCheckBox == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mLiveProtocolCheckBox");
    }
    ((CheckBox)localObject).setChecked(localCheckBox.isChecked() ^ true);
    localObject = this.y;
    localCheckBox = this.o;
    if (localCheckBox == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mLiveProtocolCheckBox");
    }
    ((MutableLiveData)localObject).setValue(Boolean.valueOf(localCheckBox.isChecked()));
  }
  
  private final void m()
  {
    if (GuildFastClickUtil.a("QGL.start_live_click"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QGL.LiveReadyFragment", 2, "click too fast return");
      }
      return;
    }
    if (!NetworkUtil.isNetSupport((Context)BaseApplication.getContext()))
    {
      GuildLiveToast.b(2131890472);
      return;
    }
    Object localObject1 = this.d.a;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "mAnchorRoomMgr.thirdPushChecked");
    if (Intrinsics.areEqual((Boolean)((MutableLiveData)localObject1).getValue(), Boolean.valueOf(false)))
    {
      GuildLiveToast.b(2131890456);
      return;
    }
    if (Intrinsics.areEqual((Boolean)this.y.getValue(), Boolean.valueOf(false)))
    {
      GuildLiveToast.b(2131890455);
      return;
    }
    if (Intrinsics.areEqual((Boolean)this.z.getValue(), Boolean.valueOf(false))) {
      return;
    }
    localObject1 = this.e;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("chooseCoverController");
    }
    this.x = ((ChooseCoverController)localObject1).a();
    if (!TextUtils.isEmpty((CharSequence)this.x))
    {
      localObject1 = this.v;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mRoomAttr");
      }
      ((QQLiveAnchorDataRoomAttr)localObject1).poster = this.x;
    }
    localObject1 = this.g;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mLiveName");
    }
    localObject1 = ((CharacterCountEditText)localObject1).getText().toString();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("startLive click!!! with room name ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("QGL.LiveReadyFragment", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = this.v;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRoomAttr");
    }
    ((QQLiveAnchorDataRoomAttr)localObject2).roomName = ((String)localObject1);
    localObject1 = this.d;
    localObject2 = this.v;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRoomAttr");
    }
    ((QQGuildLiveAnchorRoomMgr)localObject1).a((QQLiveAnchorDataRoomAttr)localObject2);
  }
  
  private final SpannableString n()
  {
    String str = HardCodeUtil.a(2131890457);
    Object localObject = this.A;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mProtocolText");
    localObject = (CharSequence)localObject;
    Intrinsics.checkExpressionValueIsNotNull(str, "clickStr");
    int i1 = StringsKt.indexOf$default((CharSequence)localObject, str, 0, false, 6, null);
    localObject = new SpannableString((CharSequence)this.A);
    ((SpannableString)localObject).setSpan(new LiveReadyFragment.getClickableSpan.1(this, Color.parseColor("#12B7F5")), i1, str.length() + i1, 33);
    return localObject;
  }
  
  private final void o()
  {
    this.d.a(false);
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.finish();
    }
  }
  
  private final void p()
  {
    Object localObject = QQGuildLiveStartParamsCache.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "QQGuildLiveStartParamsCache.getCache()");
    localObject = ((QQGuildLiveRoomStartParams)localObject).getChannelInfo();
    if (localObject == null)
    {
      QLog.d("QGL.LiveReadyFragment", 1, "getCache().getChannelInfo() == null, please check it.");
      return;
    }
    IRuntimeService localIRuntimeService = i().getRuntimeService(IGPSService.class, "");
    Intrinsics.checkExpressionValueIsNotNull(localIRuntimeService, "appRuntime.getRuntimeSer…va, ProcessConstant.MAIN)");
    ((IGPSService)localIRuntimeService).requestBeginBroadcast(((IGProChannelInfo)localObject).getGuildId(), ((IGProChannelInfo)localObject).getChannelUin(), String.valueOf(this.w), (IResultCallback)new LiveReadyFragment.reportStartLive.1(this));
  }
  
  public void a(@NotNull QQGuildEndLiveModel paramQQGuildEndLiveModel)
  {
    Intrinsics.checkParameterIsNotNull(paramQQGuildEndLiveModel, "model");
  }
  
  public void a(@Nullable String paramString)
  {
    paramString = getActivity();
    if (paramString != null) {
      paramString.finish();
    }
    paramString = getActivity();
    if (paramString != null) {
      paramString.overridePendingTransition(0, 0);
    }
  }
  
  protected int b()
  {
    return 2131625073;
  }
  
  public void d()
  {
    HashMap localHashMap = this.B;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public boolean e()
  {
    return true;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 257))
    {
      paramIntent = this.e;
      if (paramIntent == null) {
        Intrinsics.throwUninitializedPropertyAccessException("chooseCoverController");
      }
      paramIntent.c();
    }
  }
  
  public void onAttach(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    super.onAttach(paramContext);
    QQGuildLiveEventHelper.a().a((LiveRoomEventListener)this);
  }
  
  public boolean onBackEvent()
  {
    o();
    return super.onBackEvent();
  }
  
  public void onClick(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "v");
    b(paramView);
    int i1 = paramView.getId();
    if (i1 == 2131437352)
    {
      if (getContext() != null)
      {
        ChooseCoverController localChooseCoverController = this.e;
        if (localChooseCoverController == null) {
          Intrinsics.throwUninitializedPropertyAccessException("chooseCoverController");
        }
        localChooseCoverController.b();
      }
    }
    else if ((i1 == 2131437381) || (i1 == 2131437380)) {
      m();
    } else if ((i1 == 2131431426) || (i1 == 2131431425)) {
      j();
    } else if (i1 == 2131433244) {
      l();
    } else if (i1 == 2131436278) {
      o();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    Object localObject = QQGuildLiveRoomUiData.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "QQGuildLiveRoomUiData.getInstance()");
    localObject = ((QQGuildLiveRoomUiData)localObject).b();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "QQGuildLiveRoomUiData.ge…ance().selfIsAnchorLiving");
    if ((Intrinsics.areEqual((Boolean)((LiveData)localObject).getValue(), Boolean.valueOf(true)) ^ true)) {
      o();
    }
    d();
  }
  
  public void onDetach()
  {
    super.onDetach();
    QQGuildLiveEventHelper.a().b((LiveRoomEventListener)this);
  }
  
  public void onNewIntent(@NotNull Intent paramIntent)
  {
    Intrinsics.checkParameterIsNotNull(paramIntent, "intent");
    super.onNewIntent(paramIntent);
    paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    if (!TextUtils.isEmpty((CharSequence)paramIntent))
    {
      if (QLog.isColorLevel())
      {
        localObject = StringCompanionObject.INSTANCE;
        localObject = new Object[1];
        localObject[0] = paramIntent;
        localObject = String.format("doOnNewIntent path=%s", Arrays.copyOf((Object[])localObject, localObject.length));
        Intrinsics.checkExpressionValueIsNotNull(localObject, "java.lang.String.format(format, *args)");
        QLog.d("QGL.LiveReadyFragment", 2, (String)localObject);
      }
      Object localObject = this.f;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mLiveAvatar");
      }
      ((RoundCornerImageView)localObject).setImageURI(Uri.fromFile(new File(paramIntent)));
      localObject = this.e;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("chooseCoverController");
      }
      ((ChooseCoverController)localObject).a(this.w);
      localObject = this.e;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("chooseCoverController");
      }
      ((ChooseCoverController)localObject).a(paramIntent, "");
    }
  }
  
  public void onViewCreated(@NotNull View paramView, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    paramBundle = paramView.findViewById(2131437375);
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "view.findViewById(R.id.live_ready_ll)");
    this.s = ((LinearLayout)paramBundle);
    paramBundle = paramView.findViewById(2131437352);
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "view.findViewById(R.id.live_avatar_iv)");
    this.f = ((RoundCornerImageView)paramBundle);
    paramBundle = paramView.findViewById(2131437367);
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "view.findViewById(R.id.live_name_et)");
    this.g = ((CharacterCountEditText)paramBundle);
    paramBundle = paramView.findViewById(2131437378);
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "view.findViewById(R.id.live_server_addr)");
    this.h = ((TextView)paramBundle);
    paramBundle = paramView.findViewById(2131437377);
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "view.findViewById(R.id.live_secret_key)");
    this.i = ((TextView)paramBundle);
    paramBundle = paramView.findViewById(2131437380);
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "view.findViewById(R.id.live_start_btn)");
    this.k = ((Button)paramBundle);
    paramBundle = paramView.findViewById(2131437381);
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "view.findViewById(R.id.live_start_btn_disable)");
    this.l = ((Button)paramBundle);
    paramBundle = paramView.findViewById(2131437372);
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "view.findViewById(R.id.live_protocol_checkbox)");
    this.o = ((CheckBox)paramBundle);
    paramBundle = paramView.findViewById(2131433244);
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "view.findViewById(R.id.fl_checkbox)");
    this.p = ((FrameLayout)paramBundle);
    paramBundle = paramView.findViewById(2131431426);
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "view.findViewById(R.id.copy_server_addr)");
    this.q = ((ImageView)paramBundle);
    paramBundle = paramView.findViewById(2131431425);
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "view.findViewById(R.id.copy_secret_key)");
    this.r = ((ImageView)paramBundle);
    paramBundle = paramView.findViewById(2131437373);
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "view.findViewById(R.id.live_protocol_tv)");
    this.j = ((TextView)paramBundle);
    paramBundle = paramView.findViewById(2131428336);
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "view.findViewById(R.id.anchor_pre)");
    this.m = ((FrameLayout)paramBundle);
    paramBundle = paramView.findViewById(2131428337);
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "view.findViewById(R.id.anchor_pre_container)");
    this.n = ((RelativeLayout)paramBundle);
    paramBundle = paramView.findViewById(2131428338);
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "view.findViewById(R.id.anchor_pre_tips)");
    this.t = ((TextView)paramBundle);
    paramBundle = paramView.findViewById(2131436278);
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "view.findViewById(R.id.iv_back_icon)");
    this.u = ((ImageView)paramBundle);
    Object localObject = this.s;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mLiveReadyLL");
    }
    paramBundle = (View.OnClickListener)this;
    ((LinearLayout)localObject).setOnClickListener(paramBundle);
    localObject = this.f;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mLiveAvatar");
    }
    ((RoundCornerImageView)localObject).setOnClickListener(paramBundle);
    localObject = this.g;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mLiveName");
    }
    ((CharacterCountEditText)localObject).setOnClickListener(paramBundle);
    localObject = this.k;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mLiveStartBtn");
    }
    ((Button)localObject).setOnClickListener(paramBundle);
    localObject = this.l;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mLiveStartBtnDis");
    }
    ((Button)localObject).setOnClickListener(paramBundle);
    localObject = this.q;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mCopySerAddr");
    }
    ((ImageView)localObject).setOnClickListener(paramBundle);
    localObject = this.r;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mCopySecretKey");
    }
    ((ImageView)localObject).setOnClickListener(paramBundle);
    localObject = this.p;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mCheckBoxFl");
    }
    ((FrameLayout)localObject).setOnClickListener(paramBundle);
    localObject = this.u;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mLiveBackIcon");
    }
    ((ImageView)localObject).setOnClickListener(paramBundle);
    paramBundle = requireContext();
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "requireContext()");
    this.e = new ChooseCoverController(paramBundle);
    this.d.c.observe(getViewLifecycleOwner(), (Observer)new LiveReadyFragment.onViewCreated.1(this));
    paramBundle = this.g;
    if (paramBundle == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mLiveName");
    }
    a(paramBundle);
    g();
    paramBundle = this.n;
    if (paramBundle == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mVideoPreContainer");
    }
    a(paramBundle);
    GulidLiveDataUtils.a((LiveData)this.d.a, (LiveData)this.y, (LiveData)this.z, (GulidLiveDataUtils.Function3)new LiveReadyFragment.onViewCreated.2(this)).observe(getViewLifecycleOwner(), (Observer)LiveReadyFragment.onViewCreated.3.a);
    this.d.b.observe(getViewLifecycleOwner(), (Observer)new LiveReadyFragment.onViewCreated.4(this));
    c(paramView);
    d(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyFragment
 * JD-Core Version:    0.7.0.1
 */