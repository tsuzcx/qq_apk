package com.tencent.mobileqq.qqlive.prepare;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.QPublicFragmentActivityForTool;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mvvm.LifeCycleAndViewModelStoreOwner;
import com.tencent.mobileqq.mvvm.ViewModelProviderHelper;
import com.tencent.mobileqq.mvvm.api.ILifeCycleFragmentInjectApi;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.IQQLiveUtil;
import com.tencent.mobileqq.qqlive.api.anchor.IQQLiveModuleAnchor;
import com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareThirdPush;
import com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareWrapper;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.base.QQLiveBaseFragment;
import com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback;
import com.tencent.mobileqq.qqlive.data.CoverInfo;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveAnchorStreamRecordType;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRecord;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomConfig;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomGameInfo;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomAttr;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.data.record.QQLiveCurRoomInfo;
import com.tencent.mobileqq.qqlive.util.PermissionManager;
import com.tencent.mobileqq.qqlive.util.QQLiveCommonUtil;
import com.tencent.mobileqq.qqlive.widget.FastResumeDialog;
import com.tencent.mobileqq.qqlive.widget.GameListDialog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.timi.game.api.ITimiGameApi;
import com.tencent.timi.game.api.live.ILiveReportUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.ilive.util.IQQLiveEntranceUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class QQLivePrepareFragment
  extends QQLiveBaseFragment
  implements View.OnClickListener, IQQLivePrepareView
{
  private TextView A;
  private QQCustomDialog B;
  private final PermissionManager C = new PermissionManager();
  private Uri D;
  private boolean E = false;
  private boolean F = false;
  private boolean G = false;
  private QQLivePrepareFragment.ClosePreparePageBrocastReceiver H = new QQLivePrepareFragment.ClosePreparePageBrocastReceiver(this);
  private final QQLiveAnchorRoomThirdPushBaseCallback I = new QQLivePrepareFragment.1(this);
  private final LbsManagerServiceOnLocationChangeListener J = new QQLivePrepareFragment.2(this, "QQLive", true);
  protected IQQLiveModuleAnchor b;
  private View c;
  private IQQLiveAnchorPrepareWrapper d;
  private IQQLiveAnchorPrepareThirdPush e;
  private LifeCycleAndViewModelStoreOwner f;
  private PrepareFragmentViewModel g;
  private FrameLayout h;
  private TextView i;
  private RelativeLayout j;
  private TextView k;
  private ImageView l;
  private URLImageView m;
  private URLImageView n;
  private EditText o;
  private ImageView p;
  private LinearLayout q;
  private Switch r;
  private TextView s;
  private CheckBox t;
  private TextView u;
  private Button v;
  private TextView w;
  private ScrollView x;
  private TextView y;
  private TextView z;
  
  private QQLiveAnchorStreamRecordType a(PrepareFragmentViewModel paramPrepareFragmentViewModel)
  {
    if (paramPrepareFragmentViewModel == null) {
      return QQLiveAnchorStreamRecordType.SCREEN;
    }
    paramPrepareFragmentViewModel = (Integer)paramPrepareFragmentViewModel.f.getValue();
    if (paramPrepareFragmentViewModel == null) {
      return QQLiveAnchorStreamRecordType.SCREEN;
    }
    if (paramPrepareFragmentViewModel.intValue() == 2) {
      return QQLiveAnchorStreamRecordType.THIRD_PUSH;
    }
    return QQLiveAnchorStreamRecordType.SCREEN;
  }
  
  private void a(long paramLong, String paramString)
  {
    ((ITimiGameApi)QRoute.api(ITimiGameApi.class)).resumeGameLive(this.c.getContext(), paramLong, paramString, new QQLivePrepareFragment.14(this));
  }
  
  public static void a(Context paramContext, boolean paramBoolean, Intent paramIntent)
  {
    if (!((IQQLiveUtil)QRoute.api(IQQLiveUtil.class)).checkAvEnable(paramContext))
    {
      QLog.d("QQLivePrepareFragment", 1, "the audio is not enable ");
      return;
    }
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.putExtra("moduleId", "qq_live");
    localIntent.addFlags(536870912);
    if (paramBoolean) {
      paramIntent = QPublicFragmentActivityForTool.class;
    } else {
      paramIntent = QPublicFragmentActivity.class;
    }
    QPublicFragmentActivity.Launcher.a(paramContext, localIntent, paramIntent, QQLivePrepareFragment.class);
  }
  
  private void a(View paramView)
  {
    Map localMap = PrepareDTHelper.a(this.g, this.a);
    ((ITimiGameApi)QRoute.api(ITimiGameApi.class)).getLiveReportUtil().a(this, paramView, "pg_qqlive_gamelive_start", localMap);
  }
  
  private void a(URLImageView paramURLImageView, int paramInt1, String paramString, int paramInt2)
  {
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      if ((paramInt2 != 0) && (getQBaseActivity().getResources() != null)) {
        localURLDrawableOptions.mFailedDrawable = getQBaseActivity().getResources().getDrawable(paramInt2);
      }
      paramInt1 = ViewUtils.dip2px(paramInt1);
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      paramString.setTag(new int[] { paramInt1, paramInt1 });
      paramString.setDecodeHandler(GameListAdapter.a);
      paramURLImageView.setImageDrawable(paramString);
      return;
    }
    catch (Exception paramURLImageView)
    {
      QLog.e("QQLivePrepareFragment", 1, paramURLImageView, new Object[0]);
    }
  }
  
  private void a(QQLiveAnchorDataPrepare paramQQLiveAnchorDataPrepare)
  {
    if (this.b != null) {
      this.d.set(paramQQLiveAnchorDataPrepare.roomAttr, this.I);
    }
  }
  
  private QQLiveAnchorRoomInfo b(QQLiveAnchorDataPrepare paramQQLiveAnchorDataPrepare)
  {
    QQLiveAnchorRoomInfo localQQLiveAnchorRoomInfo = new QQLiveAnchorRoomInfo();
    localQQLiveAnchorRoomInfo.roomAttr = paramQQLiveAnchorDataPrepare.roomAttr;
    localQQLiveAnchorRoomInfo.roomData = paramQQLiveAnchorDataPrepare.roomInfo;
    return localQQLiveAnchorRoomInfo;
  }
  
  private void d()
  {
    this.h = ((FrameLayout)this.c.findViewById(2131442410));
    this.i = ((TextView)this.c.findViewById(2131442409));
    this.j = ((RelativeLayout)this.c.findViewById(2131442395));
    this.k = ((TextView)this.c.findViewById(2131442393));
    this.l = ((ImageView)this.c.findViewById(2131442376));
    this.m = ((URLImageView)this.c.findViewById(2131442383));
    this.n = ((URLImageView)this.c.findViewById(2131442378));
    this.r = ((Switch)this.c.findViewById(2131442399));
    this.w = ((TextView)this.c.findViewById(2131442375));
    this.x = ((ScrollView)this.c.findViewById(2131442426));
    this.y = ((TextView)this.c.findViewById(2131442407));
    this.p = ((ImageView)this.c.findViewById(2131442405));
    this.z = ((TextView)this.c.findViewById(2131442406));
    this.A = ((TextView)this.c.findViewById(2131442425));
    this.o = ((EditText)this.c.findViewById(2131442401));
    this.q = ((LinearLayout)this.c.findViewById(2131442387));
    this.s = ((TextView)this.c.findViewById(2131442385));
    this.t = ((CheckBox)this.c.findViewById(2131442390));
    this.u = ((TextView)this.c.findViewById(2131442392));
    this.v = ((Button)this.c.findViewById(2131442396));
    this.i.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.n.setOnClickListener(this);
    this.q.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.v.setOnClickListener(this);
    this.y.setOnClickListener(this);
    this.z.setOnClickListener(this);
    this.u.setOnClickListener(this);
    this.o.setOnClickListener(this);
    this.t.setOnCheckedChangeListener(new QQLivePrepareFragment.4(this));
    this.o.addTextChangedListener(new QQLivePrepareFragment.5(this));
  }
  
  private void d(String paramString)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (localFragmentActivity.isFinishing()))
    {
      if (this.B == null) {
        this.B = DialogUtil.a(localFragmentActivity, 230, null, paramString, null, "知道了", new QQLivePrepareFragment.11(this), null);
      }
      if (!this.B.isShowing())
      {
        this.B.setMessage(paramString);
        this.B.show();
      }
      return;
    }
    QLog.d("QQLivePrepareFragment", 1, "[showTipDialog] the activity is null or is finished ");
  }
  
  private void e()
  {
    if (this.a.getLoginModule().isLogined())
    {
      g();
      return;
    }
    this.a.getLoginModule().registerLoginStateCallback(new QQLivePrepareFragment.6(this));
  }
  
  private void e(String paramString)
  {
    if ((getQBaseActivity() != null) && (getQBaseActivity().getSystemService("clipboard") != null))
    {
      ClipboardManager localClipboardManager = (ClipboardManager)getQBaseActivity().getSystemService("clipboard");
      paramString = ClipData.newPlainText(null, paramString);
      ClipboardMonitor.setPrimaryClip(localClipboardManager, paramString);
      localClipboardManager.setPrimaryClip(paramString);
      QQToast.makeText(getQBaseActivity(), "复制成功", 1).show();
    }
  }
  
  private void f()
  {
    this.f = ((ILifeCycleFragmentInjectApi)QRoute.api(ILifeCycleFragmentInjectApi.class)).checkAndAddLifeCycleFragment(getQBaseActivity());
    this.g = ((PrepareFragmentViewModel)ViewModelProviderHelper.a(this.f, PrepareFragmentViewModel.k).get(PrepareFragmentViewModel.class));
    QQLiveGamePrepareViewBinderHelper.a(this, this.g, this);
  }
  
  private void f(String paramString)
  {
    if (getActivity() != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        paramString = "服务器开小差，请稍后重试";
      }
      QQToast.makeText(getActivity(), paramString, 1).show();
    }
  }
  
  private void g()
  {
    if (u())
    {
      QLog.d("QQLivePrepareFragment", 1, "the user has the valid anchor record");
      return;
    }
    h();
  }
  
  private void h()
  {
    this.C.a(this, new QQLivePrepareFragment.7(this));
  }
  
  private void i()
  {
    this.b = this.a.getAnchorModule();
    QBaseActivity localQBaseActivity = getQBaseActivity();
    if (localQBaseActivity != null)
    {
      IQQLiveModuleAnchor localIQQLiveModuleAnchor = this.b;
      if (localIQQLiveModuleAnchor != null)
      {
        this.d = localIQQLiveModuleAnchor.createPrepareWrapper();
        this.e = this.d.getThirdPushModule(this.h);
        long l1 = 0L;
        if (this.a.getLoginModule().getLoginInfo() != null) {
          l1 = this.a.getLoginModule().getLoginInfo().uid;
        }
        this.d.init(this.a, l1, "QQ_Live_Game");
        this.d.prepare(localQBaseActivity, this.I);
      }
    }
  }
  
  private void j()
  {
    if (this.F)
    {
      QLog.i("QQLivePrepareFragment", 1, "has click start live");
      return;
    }
    if (!((IQQLiveUtil)QRoute.api(IQQLiveUtil.class)).checkAvEnable(getQBaseActivity()))
    {
      QLog.d("QQLivePrepareFragment", 1, "the audio is not enable ");
      return;
    }
    if (TextUtils.isEmpty(this.g.a().roomAttr.roomName))
    {
      QLog.i("QQLivePrepareFragment", 1, "the room name is null");
      QQToast.makeText(getQBaseActivity(), "标题不能为空", 1).show();
      return;
    }
    if (TextUtils.isEmpty(this.g.a().roomAttr.poster16v9))
    {
      QLog.i("QQLivePrepareFragment", 1, "the room cover is null");
      QQToast.makeText(getQBaseActivity(), "封面不能为空", 1).show();
      return;
    }
    if (!QQLiveCommonUtil.a(getActivity())) {
      return;
    }
    this.F = true;
    r();
    QQLiveAnchorRoomConfig localQQLiveAnchorRoomConfig = new QQLiveAnchorRoomConfig();
    localQQLiveAnchorRoomConfig.streamRecordType = a(this.g);
    this.a.getAnchorModule().createRoom(this.c.getContext(), localQQLiveAnchorRoomConfig, null).setAnchorRoomInfo(b(this.g.a));
    ((ITimiGameApi)QRoute.api(ITimiGameApi.class)).startGameLive(this.c.getContext(), localQQLiveAnchorRoomConfig.streamRecordType, new QQLivePrepareFragment.8(this));
  }
  
  private void k()
  {
    ThreadManager.getUIHandler().postDelayed(new QQLivePrepareFragment.9(this), 400L);
  }
  
  private void l()
  {
    ((IQQLiveEntranceUtil)QRoute.api(IQQLiveEntranceUtil.class)).oldLiveAnchorEntranceJump(getQBaseActivity(), "add");
  }
  
  private void m()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(getQBaseActivity(), null);
    localActionSheet.addButton(2131896977, 5);
    localActionSheet.addButton(2131896976, 5);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new QQLivePrepareFragment.10(this, localActionSheet));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
  }
  
  private void n()
  {
    QBaseActivity localQBaseActivity = getQBaseActivity();
    ArrayList localArrayList = new ArrayList();
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("PhotoConst.PHOTO_PATHS", localArrayList);
    localBundle.putInt("PhotoConst.MAXUM_SELECTED_NUM", 1);
    localBundle.putBoolean("PhotoConst.IS_SINGLE_MODE", true);
    localBundle.putBoolean("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    localBundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", localQBaseActivity.getClass().getName());
    localBundle.putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localBundle.putBoolean("PhotoConst.IS_SINGLE_DERECTBACK_MODE", true);
    localQBaseActivity.overridePendingTransition(2130771996, 2130771994);
    ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).startPhotoList(localQBaseActivity, localBundle);
  }
  
  private void o()
  {
    GameListDialog localGameListDialog = new GameListDialog(getQBaseActivity(), 2131953559, true);
    localGameListDialog.a(this.g);
    localGameListDialog.show();
  }
  
  private void p()
  {
    LocationData localLocationData = this.g.d();
    if (localLocationData != null)
    {
      this.g.i.setValue(localLocationData);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("get the city from cache city ");
      localStringBuilder.append(localLocationData.b);
      QLog.d("QQLivePrepareFragment", 1, localStringBuilder.toString());
      return;
    }
    this.C.b(this, new QQLivePrepareFragment.12(this));
  }
  
  private void q()
  {
    LocationData localLocationData = (LocationData)this.g.i.getValue();
    if ((localLocationData != null) && (localLocationData.a))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("get the city from viewModel city ");
      localStringBuilder.append(localLocationData.b);
      QLog.d("QQLivePrepareFragment", 1, localStringBuilder.toString());
      localLocationData.a = false;
      this.g.i.setValue(localLocationData);
      return;
    }
    p();
  }
  
  private void r()
  {
    LocationData localLocationData = (LocationData)this.g.i.getValue();
    this.g.a(localLocationData);
  }
  
  private void s()
  {
    ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation(this.J);
  }
  
  private void t()
  {
    Object localObject = this.D;
    if (localObject != null)
    {
      localObject = BaseImageUtil.b(getContext(), (Uri)localObject);
      String str = String.valueOf(this.g.a.roomAttr.roomId);
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str))) {
        ((IQQLiveUtil)QRoute.api(IQQLiveUtil.class)).enterCropFragment(getQBaseActivity(), (String)localObject, str, 2);
      }
    }
  }
  
  private boolean u()
  {
    String str = this.a.getAppRuntime().getCurrentUin();
    QQLiveAnchorRecord localQQLiveAnchorRecord = this.a.getAnchorModule().getValidAnchorRecord(str);
    if (localQQLiveAnchorRecord != null)
    {
      FastResumeDialog localFastResumeDialog = new FastResumeDialog(getQBaseActivity(), 2131953559);
      localFastResumeDialog.a(new QQLivePrepareFragment.13(this, str, localQQLiveAnchorRecord));
      localFastResumeDialog.show();
    }
    return localQQLiveAnchorRecord != null;
  }
  
  private void v()
  {
    Intent localIntent = new Intent(getQBaseActivity(), QQBrowserActivity.class);
    localIntent.putExtra("url", "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/live/license/live_ugc.html");
    getQBaseActivity().startActivity(localIntent);
  }
  
  private boolean w()
  {
    Object localObject = this.a.getCurRoomInfo();
    int i1 = 0;
    if (localObject != null)
    {
      if (this.a.getCurRoomInfo().roomType == 1)
      {
        x();
      }
      else if (this.a.getCurRoomInfo().roomType == 2)
      {
        if (getActivity() != null) {
          QQToast.makeText(getActivity(), "无法同时进入多个直播房，请先退出房间后再开播", 1).show();
        }
        i1 = 1;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      if (i1 != 0) {
        localObject = "AudienceRoom";
      } else {
        localObject = "AnchorRoom";
      }
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" is living");
      QLog.i("QQLivePrepareFragment", 1, localStringBuilder.toString());
      return true;
    }
    return false;
  }
  
  private void x()
  {
    QBaseActivity localQBaseActivity = getQBaseActivity();
    if (localQBaseActivity != null) {
      ((ITimiGameApi)QRoute.api(ITimiGameApi.class)).openAnchorRoomPage(localQBaseActivity);
    }
  }
  
  private void y()
  {
    HashMap localHashMap = new HashMap();
    PrepareDTHelper.a(this.j, "em_qqlive_content_choice", localHashMap);
    PrepareDTHelper.a(this.n, "em_qqlive_cover_edit", localHashMap);
    PrepareDTHelper.a(this.o, "em_qqlive_title_edit", localHashMap);
    PrepareDTHelper.a(this.q, "em_qqlive_mylocation", localHashMap);
    PrepareDTHelper.a(this.r, "em_qqlive_live_mode", localHashMap);
    PrepareDTHelper.a(this.v, "em_qqlive_live_start", localHashMap);
    PrepareDTHelper.a(this.t, "em_qqlive_protocol", localHashMap);
  }
  
  public void a()
  {
    this.x.setVisibility(0);
    this.w.setVisibility(8);
  }
  
  public void a(GameItem paramGameItem)
  {
    this.k.setText(paramGameItem.b());
    if (!TextUtils.isEmpty(paramGameItem.c())) {
      a(this.m, 32, paramGameItem.c(), 2130848131);
    }
  }
  
  public void a(ThirdPushRtmpData paramThirdPushRtmpData)
  {
    if (paramThirdPushRtmpData != null)
    {
      this.y.setText(paramThirdPushRtmpData.a);
      this.z.setText(paramThirdPushRtmpData.b);
      if (paramThirdPushRtmpData.c)
      {
        this.A.setText(2131896978);
        this.A.setTextColor(getQBaseActivity().getResources().getColor(2131167274));
        return;
      }
      this.A.setText(2131896979);
      this.A.setTextColor(getQBaseActivity().getResources().getColor(2131167275));
      return;
    }
    this.A.setText(2131896979);
    this.A.setTextColor(getQBaseActivity().getResources().getColor(2131167275));
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("QQLivePrepareFragment", 1, "coverUrl is empty");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("upload success cover url is ");
    localStringBuilder.append(paramString);
    QLog.d("QQLivePrepareFragment", 1, localStringBuilder.toString());
    a(this.n, 60, paramString, 2130848129);
  }
  
  public void a(boolean paramBoolean)
  {
    this.v.setEnabled(paramBoolean);
  }
  
  public void b()
  {
    this.x.setVisibility(8);
    this.w.setVisibility(0);
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.o.setText("");
      this.o.setHint("    输入标题更吸引人哦");
      this.o.clearFocus();
      this.n.requestFocus();
      this.p.setVisibility(0);
      return;
    }
    this.p.setVisibility(8);
    this.o.setText(paramString);
    this.o.post(new QQLivePrepareFragment.3(this));
  }
  
  public void b(boolean paramBoolean)
  {
    this.t.setChecked(paramBoolean);
  }
  
  protected void c()
  {
    QBaseActivity localQBaseActivity = getQBaseActivity();
    if (localQBaseActivity == null)
    {
      QLog.e("QQLivePrepareFragment", 1, "setStatusBarImmersive qBaseActivity is null");
      return;
    }
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      if (localQBaseActivity.mSystemBarComp == null)
      {
        localQBaseActivity.setImmersiveStatus(0);
        return;
      }
      localQBaseActivity.mSystemBarComp.setStatusBarDrawable(null);
      localQBaseActivity.mSystemBarComp.setStatusBarColor(0);
      localQBaseActivity.mSystemBarComp.setStatusColor(0);
    }
  }
  
  public void c(String paramString)
  {
    this.s.setText(paramString);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      t();
      return;
    }
    if (paramInt1 == 2)
    {
      this.E = false;
      if (paramIntent == null) {
        return;
      }
      Object localObject = (CoverInfo)paramIntent.getSerializableExtra("COVER_INFO_KEY");
      if (localObject != null)
      {
        this.g.d.setValue(localObject);
        return;
      }
      paramInt1 = paramIntent.getIntExtra("upload_error_code", 0);
      if (paramInt1 != 0) {
        QQToast.makeText(getQBaseActivity(), "上传失败", 1).show();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onActivityResult[REQUEST_CODE_EDIT_PHOTO] error code ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" errorMsg ");
      ((StringBuilder)localObject).append(paramIntent.getStringExtra("upload_error_message"));
      QLog.d("QQLivePrepareFragment", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == 2131442409) {
      a(this.g.a(0));
    } else if (i1 == 2131442376) {
      getQBaseActivity().finish();
    } else if (i1 == 2131442395) {
      o();
    } else if (i1 == 2131442378) {
      m();
    } else if (i1 == 2131442387) {
      q();
    } else if (i1 == 2131442405) {
      this.p.setVisibility(8);
    } else if ((i1 != 2131442399) && (i1 != 2131442408))
    {
      if (i1 == 2131442396)
      {
        Object localObject = this.g.a(1);
        a((QQLiveAnchorDataPrepare)localObject);
        HashMap localHashMap = new HashMap();
        if (((QQLiveAnchorDataPrepare)localObject).roomAttr.gameInfo != null) {
          localHashMap.put("qqlive_zhibo_content", String.valueOf(((QQLiveAnchorDataPrepare)localObject).roomAttr.gameInfo.id));
        }
        localHashMap.put("qqlive_title_content", ((QQLiveAnchorDataPrepare)localObject).roomAttr.roomName);
        if (TextUtils.isEmpty(((QQLiveAnchorDataPrepare)localObject).roomAttr.city)) {
          localObject = "0";
        } else {
          localObject = "1";
        }
        localHashMap.put("qqlive_is_located", localObject);
        localHashMap.put("qqlive_start_type", String.valueOf(this.g.f.getValue()));
        ((ITimiGameApi)QRoute.api(ITimiGameApi.class)).getLiveReportUtil().a("clck", this.v, localHashMap);
      }
      else if (i1 == 2131442407)
      {
        e(this.y.getText().toString());
      }
      else if (i1 == 2131442406)
      {
        e(this.z.getText().toString());
      }
      else if (i1 == 2131442392)
      {
        v();
      }
    }
    else {
      this.g.b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (w()) {
      k();
    }
    try
    {
      paramBundle = new IntentFilter("qqlive_anchor_prepare_fragment");
      getContext().registerReceiver(this.H, paramBundle);
      return;
    }
    catch (Throwable paramBundle)
    {
      QLog.e("QQLivePrepareFragment", 1, paramBundle, new Object[0]);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    c();
    paramBundle = new StringBuilder();
    paramBundle.append("onCreateView: ");
    paramBundle.append(getClass().getSimpleName());
    QLog.i("QQLivePrepareFragment", 2, paramBundle.toString());
    this.c = paramLayoutInflater.inflate(2131627989, paramViewGroup, false);
    d();
    f();
    e();
    paramLayoutInflater = this.c;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.G = true;
    IQQLiveAnchorPrepareThirdPush localIQQLiveAnchorPrepareThirdPush = this.e;
    if (localIQQLiveAnchorPrepareThirdPush != null) {
      localIQQLiveAnchorPrepareThirdPush.destroy();
    }
    ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).removeListener(this.J);
    try
    {
      getContext().unregisterReceiver(this.H);
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQLivePrepareFragment", 1, localThrowable, new Object[0]);
    }
    this.H = null;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    QLog.d("QQLivePrepareFragment", 1, "onNewIntent function");
    String str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((paramIntent != null) && (paramIntent.size() > 0)) {
      paramIntent = (String)paramIntent.get(0);
    } else if (!TextUtils.isEmpty(str)) {
      paramIntent = str;
    } else {
      paramIntent = "";
    }
    if (TextUtils.isEmpty(paramIntent))
    {
      QLog.d("QQLivePrepareFragment", 1, "the path is empty");
      return;
    }
    if (!this.E)
    {
      this.E = true;
      str = String.valueOf(this.g.a.roomAttr.roomId);
      if (!TextUtils.isEmpty(str))
      {
        ((IQQLiveUtil)QRoute.api(IQQLiveUtil.class)).enterCropFragment(getQBaseActivity(), paramIntent, str, 2);
        return;
      }
      QLog.d("QQLivePrepareFragment", 1, "[onNewIntent] the roomId is empty");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.prepare.QQLivePrepareFragment
 * JD-Core Version:    0.7.0.1
 */