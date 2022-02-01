package com.tencent.mobileqq.troop.troopcard.ui;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ProtoServlet;
import com.tencent.common.app.AppInterface;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopSystemMsgUtilApi;
import com.tencent.mobileqq.troop.api.handler.ITroopMngHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopModifyHandler;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.api.observer.TroopModifyObserver;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.avatar.AvatarInfo;
import com.tencent.mobileqq.troop.avatar.TroopAvatarController;
import com.tencent.mobileqq.troop.avatar.TroopAvatarManger;
import com.tencent.mobileqq.troop.avatar.TroopPhotoController;
import com.tencent.mobileqq.troop.avatar.TroopPhotoController.OnGotoBigPicListener;
import com.tencent.mobileqq.troop.avatar.TroopUploadingTask;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.handler.TroopModifyHandler;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUtilsApi;
import com.tencent.mobileqq.troop.observer.TempFriendListObserver;
import com.tencent.mobileqq.troop.observer.TroopAuditObserver;
import com.tencent.mobileqq.troop.troopcard.TroopInfoActivityHelper;
import com.tencent.mobileqq.troop.troopcatalog.GroupCatalogBean;
import com.tencent.mobileqq.troop.troopcatalog.GroupCatalogTool;
import com.tencent.mobileqq.troop.troopmanager.api.ITroopManagerBizHandler;
import com.tencent.mobileqq.troop.troopmanager.api.TroopManagerBizObserver;
import com.tencent.mobileqq.troop.troopsetting.api.TroopSettingObserver;
import com.tencent.mobileqq.troop.utils.TroopInfoUIUtil;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.TroopInfoActivityConstant;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.config.business.qvip.QVipBigTroopExpiredConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipBigTroopExpiredProcessor;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.troop.bindgame.GCBindGroup.GCBindGroupSsoServerReq;
import com.tencent.pb.troop.bindgame.GCBindGroup.GCBindGroupSsoServerRsp;
import com.tencent.pb.troop.bindgame.GCBindGroup.QQBindInfo;
import com.tencent.pb.troop.bindgame.GCBindGroup.QQGroupBind;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XListView;
import com.tencent.widget.XSimpleListAdapter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Observer;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupGeoInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.TagRecord;

public class TroopInfoActivity
  extends QIphoneTitleBarActivity
  implements View.OnClickListener, DecodeTaskCompletionListener, TroopPhotoController.OnGotoBigPicListener
{
  public static final DownloadParams.DecodeHandler W = new TroopInfoActivity.34();
  protected String A = "";
  protected long B = 0L;
  protected boolean C = false;
  public TroopAvatarManger D;
  protected IFaceDecoder E;
  protected boolean F = false;
  protected int G = 0;
  AppInterface H;
  BroadcastReceiver I = new TroopInfoActivity.1(this);
  Handler J = new TroopInfoActivity.18(this);
  AvatarObserver K = new TroopInfoActivity.19(this);
  TempFriendListObserver L = new TroopInfoActivity.20(this);
  TroopManagerBizObserver M = new TroopInfoActivity.21(this);
  TroopModifyObserver N = new TroopInfoActivity.22(this);
  TroopObserver O = new TroopInfoActivity.23(this);
  TroopMngObserver P = new TroopInfoActivity.24(this);
  TroopSettingObserver Q = new TroopInfoActivity.25(this);
  TroopAuditObserver R = new TroopInfoActivity.26(this);
  protected QQProgressDialog S;
  protected View T;
  protected View U;
  Observer V = new TroopInfoActivity.33(this);
  private int X;
  private int Y;
  private boolean Z = false;
  protected boolean a;
  private boolean aa = false;
  private TroopPhotoController ab;
  private TroopAvatarController ac;
  private boolean ad = false;
  protected LinearLayout b;
  protected View[] c;
  protected View d;
  protected Button e;
  protected TroopInfoData f = new TroopInfoData();
  protected boolean g = false;
  protected boolean h;
  protected TroopInfo i;
  protected List<Integer> j;
  boolean k = false;
  public boolean l = false;
  protected boolean m = false;
  protected ArrayList<String> n = new ArrayList();
  public boolean o = false;
  public boolean p = false;
  public String q;
  public int r = -1;
  public Dialog s;
  public long t = -1L;
  public long u = -1L;
  public int v;
  public int w = -1;
  public int x = -1;
  public int y = -1;
  protected XListView z;
  
  private void A()
  {
    Object localObject = this.H.getCurrentAccountUin();
    int i1;
    if (String.valueOf(this.f.troopowneruin).equals(localObject))
    {
      i1 = 0;
    }
    else
    {
      if (!TextUtils.isEmpty(this.f.troopowneruin))
      {
        if (((IFriendDataService)this.H.getRuntimeService(IFriendDataService.class, "")).isFriend(this.f.troopowneruin))
        {
          i1 = 20;
          break label97;
        }
        if (this.f.isMember)
        {
          i1 = 21;
          break label97;
        }
      }
      i1 = 19;
    }
    label97:
    localObject = new AllInOne(this.f.troopowneruin, i1);
    if (!TextUtils.isEmpty(this.f.troopowneruin)) {
      ((AllInOne)localObject).nickname = this.f.troopOwnerNick;
    }
    ((AllInOne)localObject).troopCode = this.f.troopUin;
    ((AllInOne)localObject).troopUin = this.f.troopCode;
    if (i1 == 21) {
      ((AllInOne)localObject).subSourceId = 11;
    }
    ProfileUtils.openProfileCard(getActivity(), (AllInOne)localObject);
  }
  
  private void B()
  {
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this, "/base/browser");
    Intent localIntent = new Intent();
    localIntent.putExtra("url", String.format("https://admin.qun.qq.com/mcreatev4/classinfo?gc=%1$s&from=%2$s", new Object[] { this.f.troopUin, IHWTroopUtilsApi.HOMEWORK_SCHOOL_EDIT_FROM }));
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    localActivityURIRequest.extra().putAll(localIntent.getExtras());
    localActivityURIRequest.setRequestCode(19);
    QRoute.startUri(localActivityURIRequest, null);
  }
  
  private void C()
  {
    ThreadManager.post(new TroopInfoActivity.27(this), 5, null, true);
  }
  
  private void D()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "updateTroopOwnerName");
    }
    ThreadManager.post(new TroopInfoActivity.28(this), 5, null, true);
  }
  
  private void E()
  {
    Object localObject = this.T;
    if (localObject != null)
    {
      localObject = (TextView)((View)localObject).findViewById(2131447119);
      if ((2 != this.f.troopTypeExt) && (4 != this.f.troopTypeExt)) {
        i2 = 0;
      } else {
        i2 = 1;
      }
      int i1 = i2;
      if ((this.i.dwAppPrivilegeFlag & 0x4000) != 0L) {
        i1 = i2 | 0x2;
      }
      if (4 != this.f.troopTypeExt)
      {
        i2 = i1;
        if (3 != this.f.troopTypeExt) {}
      }
      else
      {
        i2 = i1 | 0x4;
      }
      if (this.f.tribeStatus != 2)
      {
        i1 = i2;
        if (this.f.tribeStatus != 3) {}
      }
      else
      {
        i1 = i2 | 0x8;
      }
      int i2 = i1;
      if (this.f.tribeStatus == 1) {
        i2 = i1 | 0x10;
      }
      i1 = i2;
      if ((this.f.dwGroupFlagExt & 0x800) != 0L) {
        i1 = i2 | 0x20;
      }
      SharedPreferences localSharedPreferences = this.H.getApplication().getSharedPreferences("auth_troop_info_filename", 4);
      boolean bool = localSharedPreferences.getBoolean("has_shown_tips", false);
      if (b(i1, 32))
      {
        i1 = this.w;
        if (i1 == 2)
        {
          i1 = 2131895297;
          break label496;
        }
        if ((i1 == 3) && (!bool))
        {
          i1 = 2131895298;
          localSharedPreferences.edit().putBoolean("has_shown_tips", true).commit();
          break label496;
        }
      }
      else
      {
        if (b(i1, 1))
        {
          if (b(i1, 2))
          {
            if ((!b(i1, 4)) && (!b(i1, 8)) && (!b(i1, 16)))
            {
              i1 = 2131895310;
              break label496;
            }
            i1 = 2131895311;
            break label496;
          }
          if (b(i1, 8))
          {
            i1 = 2131895304;
            break label496;
          }
          if (b(i1, 4))
          {
            i1 = 2131895303;
            break label496;
          }
          i1 = 2131895302;
          break label496;
        }
        if (b(i1, 2))
        {
          if (b(i1, 4))
          {
            i1 = 2131895309;
            break label496;
          }
          if ((!b(i1, 8)) && (!b(i1, 16)))
          {
            i1 = 2131895307;
            break label496;
          }
          i1 = 2131895308;
          break label496;
        }
        if ((b(i1, 8)) && (b(i1, 4)))
        {
          i1 = 2131895299;
          break label496;
        }
        if (b(i1, 8))
        {
          i1 = 2131895301;
          break label496;
        }
        if (b(i1, 4))
        {
          i1 = 2131895300;
          break label496;
        }
      }
      i1 = 0;
      label496:
      if (i1 != 0)
      {
        this.U.setVisibility(0);
        ((TextView)localObject).setText(i1);
        ((TextView)localObject).setContentDescription(getString(i1));
        return;
      }
      this.U.setVisibility(8);
    }
  }
  
  private void F()
  {
    startTitleProgress();
    TroopInfoActivityHelper.a(this.H, Long.valueOf(this.f.troopUin).longValue(), new TroopInfoActivity.30(this));
  }
  
  private void G()
  {
    TroopInfoActivityHelper.a(this.H, Long.valueOf(this.f.troopUin).longValue(), new TroopInfoActivity.31(this));
  }
  
  public static Bundle a(String paramString, int paramInt)
  {
    return TroopInfoUIUtil.a(paramString, "", paramInt);
  }
  
  public static Bundle a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    return TroopInfoUIUtil.a(paramString1, paramInt1, paramInt2, paramInt3, paramInt4, paramString2);
  }
  
  private String a(int paramInt1, int paramInt2, String paramString)
  {
    TroopInfoData localTroopInfoData = this.f;
    Object localObject = "";
    if (localTroopInfoData != null)
    {
      int i1 = localTroopInfoData.cityId;
      double d1 = paramInt1;
      Double.isNaN(d1);
      d1 /= 1000000.0D;
      double d2 = paramInt2;
      Double.isNaN(d2);
      d2 /= 1000000.0D;
      localObject = paramString;
      if (TextUtils.isEmpty(paramString)) {
        localObject = "";
      }
      paramString = String.format("%d|%f|%f|%s", new Object[] { Integer.valueOf(i1), Double.valueOf(d1), Double.valueOf(d2), localObject });
      localObject = paramString;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("initCurrentLocationStruct==>locationStruct:");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("Q.troopinfo.troop.location_info", 2, ((StringBuilder)localObject).toString());
        localObject = paramString;
      }
    }
    return localObject;
  }
  
  public static ArrayList<String> a(Context paramContext, TroopInfoData paramTroopInfoData)
  {
    if (paramTroopInfoData == null) {
      return null;
    }
    Object localObject = Long.toString(paramTroopInfoData.dwGroupClassExt);
    paramContext = GroupCatalogTool.a(paramContext).a(paramContext, (String)localObject);
    if (!TextUtils.isEmpty(paramTroopInfoData.mTroopClassExtText)) {
      paramContext = paramTroopInfoData.mTroopClassExtText;
    } else if ((paramContext != null) && (!TextUtils.isEmpty(paramContext.b)) && (!paramContext.b.equals(HardCodeUtil.a(2131912715)))) {
      paramContext = paramContext.b;
    } else {
      paramContext = "";
    }
    localObject = new ArrayList();
    boolean bool = TextUtils.isEmpty(paramContext);
    int i2 = 0;
    int i1;
    if (!bool)
    {
      ((ArrayList)localObject).add(paramContext);
      i1 = 1;
    }
    else
    {
      i1 = 0;
    }
    if ((paramTroopInfoData.troopTags != null) && (paramTroopInfoData.troopTags.size() > 0))
    {
      int i3 = paramTroopInfoData.troopTags.size();
      while (i2 < i3)
      {
        if ((i1 == 0) || (!((String)paramTroopInfoData.troopTags.get(i2)).equals(paramContext))) {
          ((ArrayList)localObject).add(paramTroopInfoData.troopTags.get(i2));
        }
        i2 += 1;
      }
    }
    return localObject;
  }
  
  private void a(int paramInt, View paramView)
  {
    TroopInfoData localTroopInfoData = this.f;
    if ((localTroopInfoData != null) && (localTroopInfoData.bOwner))
    {
      paramView = paramView.findViewById(2131444526);
      if ((paramView != null) && (paramView.getVisibility() == 0))
      {
        ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).setTroopInfoEditRedShow(this.H, this.f.troopUin, paramInt, false);
        b(paramInt, false);
      }
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if ((this.f.bOwner) && (!this.F) && (!this.f.isNewTroop))
    {
      int i2 = 1;
      int i1 = i2;
      if (paramInt == 8)
      {
        i1 = i2;
        if (!((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).isTroopTagNeedRedDot(this.f.dwGroupClassExt)) {
          i1 = 0;
        }
      }
      if ((i1 != 0) && (((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getTroopInfoEditRedShow(this.H, this.f.troopUin, paramInt))) {
        b(paramInt, paramBoolean);
      }
    }
  }
  
  private void a(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString)
  {
    ReportDialog localReportDialog = new ReportDialog(this, 2131953338);
    localReportDialog.setContentView(2131627374);
    ((TextView)localReportDialog.findViewById(2131431915)).setVisibility(8);
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131431902);
    TextView localTextView2 = (TextView)localReportDialog.findViewById(2131431900);
    TextView localTextView3 = (TextView)localReportDialog.findViewById(2131431907);
    localTextView1.setText(String.format(getString(2131890905), new Object[] { Integer.valueOf(this.x) }));
    localTextView1.setGravity(3);
    localTextView2.setText(2131892267);
    localTextView3.setText(2131890885);
    localReportDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new TroopInfoActivity.15(this, localReportDialog, paramLong1, paramInt2, paramLong2, paramLong3, paramString));
    localTextView3.setOnClickListener(new TroopInfoActivity.16(this, localReportDialog));
    try
    {
      localReportDialog.show();
      return;
    }
    catch (Exception paramString) {}
  }
  
  private void a(XListView paramXListView)
  {
    if (paramXListView == null) {
      return;
    }
    this.T = super.getLayoutInflater().inflate(2131626675, paramXListView, false);
    this.U = this.T.findViewById(2131447431);
    ((ImageButton)this.T.findViewById(2131430806)).setOnClickListener(new TroopInfoActivity.29(this, paramXListView));
    paramXListView.addHeaderView(this.T);
    this.U.setVisibility(8);
  }
  
  private void a(boolean paramBoolean, long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    n();
    Object localObject1 = "";
    Object localObject3;
    Object localObject2;
    if (!paramBoolean)
    {
      if (TextUtils.isEmpty(paramString))
      {
        int i1 = (int)paramLong1;
        if (i1 != 1793) {
          switch (i1)
          {
          default: 
            paramString = getString(2131890900);
            break;
          case 1283: 
            paramString = getString(2131890903);
            break;
          case 1282: 
            paramString = getString(2131890902);
            break;
          case 1281: 
            paramString = getString(2131890901);
            break;
          }
        } else {
          paramString = getString(2131890904);
        }
      }
      AppInterface localAppInterface = this.H;
      localObject3 = this.f;
      localObject2 = localObject1;
      if (localObject3 != null) {
        localObject2 = ((TroopInfoData)localObject3).troopUin;
      }
      if (this.F) {
        localObject3 = "2";
      } else {
        localObject3 = "1";
      }
      localObject1 = this.f;
      if ((localObject1 != null) && (!((TroopInfoData)localObject1).bOwner))
      {
        if (this.f.bAdmin) {
          localObject1 = "1";
        } else {
          localObject1 = "2";
        }
      }
      else {
        localObject1 = "0";
      }
      ReportController.b(localAppInterface, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, (String)localObject2, (String)localObject3, (String)localObject1, "");
      QQToast.makeText(this, 1, paramString, 1).show(getTitleBarHeight());
    }
    else
    {
      localObject3 = this.H;
      paramString = this.f;
      if (paramString != null) {
        localObject1 = paramString.troopUin;
      }
      if (this.F) {
        localObject2 = "2";
      } else {
        localObject2 = "1";
      }
      paramString = this.f;
      if ((paramString != null) && (!paramString.bOwner))
      {
        if (this.f.bAdmin) {
          paramString = "1";
        } else {
          paramString = "2";
        }
      }
      else {
        paramString = "0";
      }
      ReportController.b((AppRuntime)localObject3, "P_CliOper", "Grp_create", "", "edit_data", "suc_modify", 0, 0, (String)localObject1, (String)localObject2, paramString, "");
      if (!this.F) {
        QQToast.makeText(this, 2, getString(2131890907), 1).show(getTitleBarHeight());
      }
    }
    if (paramBoolean)
    {
      this.H.getBusinessHandler(TroopModifyHandler.class.getName()).notifyUI(TroopModifyObserver.g, true, new Object[] { this.f.troopUin, Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      this.ad = true;
      finish();
    }
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.c;
    if (paramInt < localObject.length)
    {
      localObject = localObject[paramInt];
      if (localObject != null)
      {
        View localView = ((View)localObject).findViewById(2131444526);
        int i1 = 8;
        if (paramInt == 8) {
          localObject = ((View)localObject).findViewById(2131447069);
        } else {
          localObject = ((View)localObject).findViewById(2131431322);
        }
        if (localView != null)
        {
          paramInt = i1;
          if (paramBoolean) {
            paramInt = 0;
          }
          localView.setVisibility(paramInt);
        }
        if ((localObject != null) && ((((View)localObject).getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
        {
          localObject = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
          i1 = getResources().getDimensionPixelSize(2131299256);
          paramInt = i1;
          if (paramBoolean) {
            paramInt = i1 * 2;
          }
          ((ViewGroup.MarginLayoutParams)localObject).rightMargin = paramInt;
        }
      }
    }
  }
  
  private View c(String paramString)
  {
    TextView localTextView = new TextView(this);
    localTextView.setText(paramString);
    localTextView.setTextColor(getResources().getColor(2131168118));
    localTextView.setPadding(getResources().getDimensionPixelSize(2131299972), ViewUtils.dip2px(20.0F), 0, ViewUtils.dip2px(10.0F));
    localTextView.setFocusable(true);
    return localTextView;
  }
  
  private void c(int paramInt)
  {
    if (paramInt == 11) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if ((QVipBigTroopExpiredProcessor.e().mIsEnable) && (this.f.mIsFreezed == 1) && (this.f.isOwnerOrAdim()))
    {
      ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).handleModiftyTroopHeadFreezed(this.f, this);
      ReportController.b(null, "dc00898", "", "", "qq_vip", "0X8009E37", 2, 0, "", "", "", "");
      return;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putBoolean("IS_COVER", paramInt ^ 0x1);
    ((Bundle)localObject).putBoolean("IS_EDIT", true);
    b((Bundle)localObject);
    ReportController.b(this.H, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "nonmber_Clk_head", 0, 0, this.f.troopUin, "", "", "");
    String str = this.f.troopUin;
    if (this.f.isMember) {
      localObject = "1";
    } else {
      localObject = "0";
    }
    TroopReportor.a("Grp_set_new", "grpData_admin", "clk_head", 0, 0, new String[] { str, localObject });
  }
  
  private void c(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.c;
    if (paramInt < localObject.length)
    {
      localObject = localObject[paramInt];
      if (localObject != null)
      {
        localObject = ((View)localObject).findViewById(2131444525);
        if (localObject != null)
        {
          if (paramBoolean) {
            paramInt = 0;
          } else {
            paramInt = 8;
          }
          ((View)localObject).setVisibility(paramInt);
        }
      }
    }
  }
  
  private void d(int paramInt)
  {
    if (this.i == null)
    {
      localObject = (ITroopInfoService)this.H.getRuntimeService(ITroopInfoService.class, "");
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((ITroopInfoService)localObject).findTroopInfo(this.f.troopUin);
      }
      this.i = ((TroopInfo)localObject);
    }
    Object localObject = this.i;
    if (localObject != null)
    {
      if ((paramInt & 0x2) > 0)
      {
        this.f.dwGroupClassExt = ((TroopInfo)localObject).dwGroupClassExt;
        C();
      }
      if ((paramInt & 0x20) > 0)
      {
        this.f.mRichFingerMemo = this.i.fingertroopmemo;
        a(6, this.i.fingertroopmemo, this.f.isOwnerOrAdim());
      }
    }
  }
  
  private String e(int paramInt)
  {
    Object localObject1;
    try
    {
      JSONArray localJSONArray1 = new JSONObject("{\"datas\":{\"0\":[{\"id\":10,\"text\":\"幼儿园\",\"subs\":[{\"id\":11,\"text\":\"小班\"},{\"id\":12,\"text\":\"中班\"},{\"id\":13,\"text\":\"大班\"}]},{\"id\":20,\"text\":\"小学\",\"subs\":[{\"id\":21,\"text\":\"一年级\"},{\"id\":22,\"text\":\"二年级\"},{\"id\":23,\"text\":\"三年级\"},{\"id\":24,\"text\":\"四年级\"},{\"id\":25,\"text\":\"五年级\"},{\"id\":26,\"text\":\"六年级\"}]},{\"id\":30,\"text\":\"初中\",\"subs\":[{\"id\":31,\"text\":\"初一\"},{\"id\":32,\"text\":\"初二\"},{\"id\":33,\"text\":\"初三\"}]},{\"id\":40,\"text\":\"高中\",\"subs\":[{\"id\":41,\"text\":\"高一\"},{\"id\":42,\"text\":\"高二\"},{\"id\":43,\"text\":\"高三\"}]},{\"id\":50,\"text\":\"其他\",\"subs\":[{\"id\":51,\"text\":\"普通高校\"},{\"id\":52,\"text\":\"中职院校\"},{\"id\":53,\"text\":\"培训机构\"}]}]}}").getJSONObject("datas").getJSONArray("0");
      localObject1 = "";
      int i1 = 0;
      for (;;)
      {
        Object localObject2 = localObject1;
        try
        {
          if (i1 >= localJSONArray1.length()) {
            break label170;
          }
          localObject2 = localJSONArray1.getJSONObject(i1);
          int i2 = ((JSONObject)localObject2).getInt("id");
          if (paramInt == i2) {
            return ((JSONObject)localObject2).getString("text");
          }
          JSONArray localJSONArray2 = ((JSONObject)localObject2).getJSONArray("subs");
          i2 = 0;
          for (;;)
          {
            localObject2 = localObject1;
            if (i2 >= localJSONArray2.length()) {
              break;
            }
            localObject2 = localJSONArray2.getJSONObject(i2);
            if (paramInt == ((JSONObject)localObject2).getInt("id"))
            {
              localObject2 = ((JSONObject)localObject2).getString("text");
              break;
            }
            i2 += 1;
          }
          i1 += 1;
          localObject1 = localObject2;
        }
        catch (JSONException localJSONException1) {}
      }
      localJSONException2.printStackTrace();
    }
    catch (JSONException localJSONException2)
    {
      localObject1 = "";
    }
    Object localObject3 = localObject1;
    label170:
    return localObject3;
  }
  
  private void t()
  {
    Object localObject = this.f;
    if (localObject == null) {
      return;
    }
    if ((((TroopInfoData)localObject).tribeId == 0L) && (this.B == 0L))
    {
      int i1 = this.f.troopTypeExt;
      if ((i1 != 0) && (i1 != 1))
      {
        if ((i1 != 2) && (i1 != 3) && (i1 != 4)) {
          return;
        }
        long l1 = this.t;
        if ((l1 > 0L) && (l1 <= this.u) && (this.v == 0))
        {
          localObject = DialogUtil.a(this, 230);
          ((QQCustomDialog)localObject).setTitle(null);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.t);
          localStringBuilder.append("");
          ((QQCustomDialog)localObject).setMessage(getString(2131890890, new Object[] { localStringBuilder.toString() }));
          ((QQCustomDialog)localObject).setPositiveButton(getString(2131890888), new DialogUtil.DialogOnClickAdapter());
          ((QQCustomDialog)localObject).setPositiveButtonContentDescription(getString(2131890888));
          ((QQCustomDialog)localObject).show();
          return;
        }
        localObject = y();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          a((String)localObject);
          return;
        }
        x();
        return;
      }
      m();
      return;
    }
    g();
  }
  
  private Drawable u()
  {
    Object localObject1 = this.E;
    if (localObject1 != null)
    {
      localObject2 = ((IFaceDecoder)localObject1).getBitmapFromCache(4, this.f.troopUin);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (!this.E.isPausing())
        {
          this.E.requestDecodeFace(this.f.troopUin, 4, true);
          localObject1 = localObject2;
        }
      }
    }
    else
    {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = BaseImageUtil.k();
    }
    localObject1 = new BitmapDrawable((Bitmap)localObject2);
    if (ThemeUtil.isInNightMode(this.H)) {
      ((Drawable)localObject1).setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
    }
    return localObject1;
  }
  
  private void v()
  {
    View localView = this.c[11];
    if (localView != null)
    {
      if (this.f.hasSetNewTroopHead)
      {
        SpannableString localSpannableString = new SpannableString("[Avatar]");
        Drawable localDrawable = u();
        if (localDrawable != null)
        {
          localDrawable.setBounds(0, 0, ScreenUtil.dip2px(32.0F), ScreenUtil.dip2px(32.0F));
          localSpannableString.setSpan(new ImageSpan(localDrawable, 0), 0, localSpannableString.length(), 17);
          a(11, 2, localView, getString(2131897491), localSpannableString, this.f.isOwnerOrAdim());
          a(11, false);
        }
      }
      else
      {
        a(11, 2, localView, getString(2131897491), HardCodeUtil.a(2131912714), this.f.isOwnerOrAdim());
        a(11, true);
      }
      if (this.F)
      {
        c(11, true);
        return;
      }
      c(11, false);
    }
  }
  
  private void w()
  {
    View localView = this.c[12];
    ArrayList localArrayList = new ArrayList();
    ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getCoverFromDb(localArrayList, this.i);
    if (localArrayList.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "updateCoverEntry infoList is empty.");
      }
      a(12, 2, localView, getString(2131917683), HardCodeUtil.a(2131912717), this.f.isOwnerOrAdim());
      a(12, true);
    }
    else
    {
      Object localObject1 = (AvatarInfo)localArrayList.get(0);
      Object localObject2 = (ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class);
      String str = ((ITroopAvatarUtilApi)localObject2).getArtWork(((ITroopAvatarUtilApi)localObject2).getAvatarAddress(((AvatarInfo)localObject1).d, this.i.troopuin, 1));
      int i1 = ScreenUtil.dip2px(30.0F);
      try
      {
        localObject1 = ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getURL4TroopPhoto(str);
        if (localObject1 != null)
        {
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = URLDrawableHelperConstants.a;
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = i1;
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = i1;
          localObject2 = URLDrawable.getDrawable((URL)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
          try
          {
            ((URLDrawable)localObject2).setTag(new int[] { i1, i1, 0 });
            ((URLDrawable)localObject2).setDecodeHandler(W);
            localObject1 = localObject2;
            if (((URLDrawable)localObject2).getStatus() == 1) {
              break label301;
            }
            ((URLDrawable)localObject2).setURLDrawableListener(new TroopInfoActivity.5(this));
            localObject1 = localObject2;
          }
          catch (Exception localException2)
          {
            localObject1 = localObject2;
            localObject2 = localException2;
            break label296;
          }
        }
        else
        {
          localObject1 = null;
        }
      }
      catch (Exception localException1)
      {
        localObject1 = null;
        label296:
        localException1.printStackTrace();
      }
      label301:
      if (QLog.isColorLevel())
      {
        boolean bool;
        if (localObject1 != null) {
          bool = true;
        } else {
          bool = false;
        }
        QLog.i("Q.troopinfo", 2, String.format("updateCoverEntry ud!=null?%b path=%s", new Object[] { Boolean.valueOf(bool), str }));
      }
      if (localObject1 != null)
      {
        SpannableString localSpannableString = new SpannableString("[Avatar]");
        ((URLDrawable)localObject1).setBounds(0, 0, i1, i1);
        localSpannableString.setSpan(new ImageSpan((Drawable)localObject1, 0), 0, localSpannableString.length(), 17);
        localObject1 = localSpannableString;
      }
      else
      {
        localObject1 = null;
      }
      a(12, 2, localView, getString(2131917683), (CharSequence)localObject1, this.f.isOwnerOrAdim());
      a(12, false);
    }
    localView.setTag(2131917683, Integer.valueOf(localArrayList.size()));
  }
  
  private void x()
  {
    if ((this.o) && (this.v == 0))
    {
      Object localObject1 = DialogUtil.a(this, 230);
      ((QQCustomDialog)localObject1).setTitle(null);
      long l2 = this.t;
      long l1 = l2;
      if (l2 <= 0L) {
        l1 = 5L;
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(l1);
      ((StringBuilder)localObject2).append("");
      ((QQCustomDialog)localObject1).setMessage(getString(2131890908, new Object[] { ((StringBuilder)localObject2).toString() }));
      ((QQCustomDialog)localObject1).setNegativeButton(getString(2131890888), new TroopInfoActivity.9(this));
      ((QQCustomDialog)localObject1).setPositiveButton(getString(2131890834), new TroopInfoActivity.10(this));
      ((QQCustomDialog)localObject1).show();
      localObject2 = this.H;
      String str = this.f.troopUin;
      if (this.f.bOwner) {
        localObject1 = "0";
      } else {
        localObject1 = "1";
      }
      ReportController.b((AppRuntime)localObject2, "P_CliOper", "Grp_manage", "", "manage_grp", "sub_exp", 0, 0, str, (String)localObject1, "", "");
      return;
    }
    m();
  }
  
  private String y()
  {
    if ((!TextUtils.isEmpty(this.f.troopName)) && (this.f.troopName.length() >= 2))
    {
      if (TextUtils.isEmpty(this.f.troopLocation))
      {
        ReportController.b(this.H, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, this.f.troopUin, "2", "", "");
        return getString(2131895290);
      }
      if ((!TextUtils.isEmpty(this.f.mRichFingerMemo)) && (this.f.mRichFingerMemo.length() >= 15))
      {
        if (3 == this.f.cGroupOption)
        {
          ReportController.b(this.H, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, this.f.troopUin, "3", "", "");
          return getString(2131895289);
        }
        TroopInfo localTroopInfo = this.i;
        if ((localTroopInfo != null) && (((localTroopInfo.dwGroupFlag & 0x400) == 0L) || (0L != (this.i.dwGroupFlagExt & 0x20000)))) {
          return getString(2131895288);
        }
        return "";
      }
      ReportController.b(this.H, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, this.f.troopUin, "1", "", "");
      return getString(2131895291);
    }
    ReportController.b(this.H, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, this.f.troopUin, "0", "", "");
    return getString(2131895292);
  }
  
  private void z()
  {
    if (this.f.cGroupOption != 3)
    {
      if (!TextUtils.isEmpty(this.f.remark))
      {
        startActivity(((ITroopCardApi)QRoute.api(ITroopCardApi.class)).addFriendLogicActivity_startJoinTroop(this, this.f.troopUin, this.f.troopName, this.f.cGroupOption, this.f.getStatOption(), this.f.mStrJoinQuestion, this.f.mStrJoinAnswer, this.f.remark, setLastActivityName(), null));
        return;
      }
      startActivityForResult(((ITroopCardApi)QRoute.api(ITroopCardApi.class)).addFriendLogicActivity_startJoinTroop(this, this.f.troopUin, this.f.troopName, this.f.cGroupOption, this.f.getStatOption(), this.f.mStrJoinQuestion, this.f.mStrJoinAnswer, null, setLastActivityName(), null), 8);
      return;
    }
    a(2131917537, 1);
  }
  
  public void a(int paramInt)
  {
    String str = getString(paramInt);
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setTitle(str);
    localQQCustomDialog.setMessage(null);
    localQQCustomDialog.setPositiveButton(getString(2131890895), new TroopInfoActivity.11(this, localQQCustomDialog));
    localQQCustomDialog.setPositiveButtonContentDescription(getString(2131890895));
    localQQCustomDialog.setNegativeButton(getString(2131890834), new DialogUtil.DialogOnClickAdapter());
    localQQCustomDialog.setNegativeButtonContentDescription(getString(2131890834));
    localQQCustomDialog.show();
  }
  
  void a(int paramInt1, int paramInt2)
  {
    QQToast.makeText(BaseApplication.getContext(), paramInt2, paramInt1, 0).show(getTitleBarHeight());
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString, CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramView.setTag(Integer.valueOf(paramInt1));
      paramView.setOnClickListener(this);
    }
    else
    {
      paramView.setTag(null);
      paramView.setOnClickListener(null);
    }
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 != 2)
        {
          if (paramInt2 == 3) {
            paramView.setBackgroundResource(2130839629);
          }
        }
        else {
          paramView.setBackgroundResource(2130839632);
        }
      }
      else {
        paramView.setBackgroundResource(2130839638);
      }
    }
    else {
      paramView.setBackgroundResource(2130839622);
    }
    TextView localTextView1 = (TextView)paramView.findViewById(2131447463);
    TextView localTextView2 = (TextView)paramView.findViewById(2131435692);
    View localView = paramView.findViewById(2131428774);
    paramView = paramString;
    if (paramString == null) {
      paramView = "";
    }
    localTextView1.setText(paramView);
    paramInt2 = 8;
    if (6 == paramInt1)
    {
      localTextView2.setMovementMethod(LinkMovementMethod.getInstance());
      if (TextUtils.isEmpty(paramCharSequence))
      {
        localTextView2.setVisibility(8);
      }
      else
      {
        localTextView2.setVisibility(0);
        localTextView2.setText(new QQText(paramCharSequence, 11, 20));
      }
    }
    else
    {
      localTextView2.setText(paramCharSequence);
    }
    paramInt1 = paramInt2;
    if (paramBoolean) {
      paramInt1 = 0;
    }
    localView.setVisibility(paramInt1);
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString, String[] paramArrayOfString, boolean paramBoolean, int paramInt3)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initClrTextItemView(), tag = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", info = ");
      ((StringBuilder)localObject).append(paramArrayOfString);
      ((StringBuilder)localObject).append(", bShowArrow = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("Q.troopinfo", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (TextView)paramView.findViewById(2131447463);
    paramArrayOfString = paramString;
    if (paramString == null) {
      paramArrayOfString = "";
    }
    ((TextView)localObject).setText(paramArrayOfString);
    paramString = paramView.findViewById(2131428774);
    if (paramBoolean) {
      paramInt3 = 0;
    } else {
      paramInt3 = 8;
    }
    paramString.setVisibility(paramInt3);
    if (paramBoolean)
    {
      paramView.setTag(Integer.valueOf(paramInt1));
      paramView.setOnClickListener(this);
    }
    else
    {
      paramView.setTag(null);
      paramView.setOnClickListener(null);
    }
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 != 2)
        {
          if (paramInt2 != 3) {
            return;
          }
          paramView.setBackgroundResource(2130839629);
          return;
        }
        paramView.setBackgroundResource(2130839632);
        return;
      }
      paramView.setBackgroundResource(2130839638);
      return;
    }
    paramView.setBackgroundResource(2130839622);
  }
  
  protected void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateDefaultItemView(), tag = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", info = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", bShowArrow = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("Q.troopinfo", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt >= 0)
    {
      localObject = this.c;
      if (paramInt < localObject.length)
      {
        localObject = localObject[paramInt];
        break label104;
      }
    }
    Object localObject = null;
    label104:
    if (localObject != null)
    {
      TextView localTextView = (TextView)((View)localObject).findViewById(2131435692);
      View localView = ((View)localObject).findViewById(2131428774);
      if (paramInt == 6)
      {
        if (TextUtils.isEmpty(paramString))
        {
          localTextView.setVisibility(8);
        }
        else
        {
          localTextView.setVisibility(0);
          localTextView.setText(new QQText(paramString, 11, 20));
        }
        a(paramInt, TextUtils.isEmpty(this.f.mRichFingerMemo));
      }
      else
      {
        String str = paramString;
        if (paramInt == 4) {
          if (TextUtils.isEmpty(paramString))
          {
            str = HardCodeUtil.a(2131912719);
            a(paramInt, true);
          }
          else
          {
            a(paramInt, false);
            str = paramString;
          }
        }
        localTextView.setText(str);
      }
      if (paramBoolean)
      {
        ((View)localObject).setTag(Integer.valueOf(paramInt));
        ((View)localObject).setOnClickListener(this);
        localView.setVisibility(0);
        return;
      }
      ((View)localObject).setTag(null);
      ((View)localObject).setOnClickListener(null);
      localView.setVisibility(8);
    }
  }
  
  protected void a(int paramInt1, ArrayList<String> paramArrayList, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateClrTextItemView(), tag = ");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(", info = ");
      ((StringBuilder)localObject1).append(paramArrayList);
      ((StringBuilder)localObject1).append(", bShowArrow = ");
      ((StringBuilder)localObject1).append(paramBoolean1);
      QLog.i("Q.troopinfo", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramInt1 >= 0)
    {
      localObject1 = this.c;
      if (paramInt1 < localObject1.length)
      {
        localObject1 = localObject1[paramInt1];
        break label104;
      }
    }
    Object localObject1 = null;
    label104:
    if (localObject1 != null)
    {
      LinearLayout localLinearLayout = (LinearLayout)((View)localObject1).findViewById(2131430860);
      localLinearLayout.removeAllViews();
      Object localObject2 = (LinearLayout)((View)localObject1).findViewById(2131447069);
      Object localObject3 = (TextView)((View)localObject1).findViewById(2131435692);
      if ((paramArrayList != null) && (paramArrayList.size() != 0))
      {
        a(paramInt1, false);
        ((LinearLayout)localObject2).setVisibility(8);
        localLinearLayout.setVisibility(0);
        int i1 = 0;
        while ((i1 < paramArrayList.size()) && (i1 < 3))
        {
          if (!TextUtils.isEmpty((CharSequence)paramArrayList.get(i1)))
          {
            localObject2 = new TextView(this);
            ((TextView)localObject2).setId(2131441564);
            int i2 = 2130844937;
            if (paramInt2 == 1) {
              i2 = 2130844939;
            }
            localObject3 = getResources().getDrawable(i2);
            ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).setNightModeFilterForDrawable((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null), (Drawable)localObject3);
            ((TextView)localObject2).setBackgroundDrawable((Drawable)localObject3);
            ((TextView)localObject2).setTextSize(2, 15.0F);
            if (paramBoolean2) {
              ((TextView)localObject2).setMaxWidth(Utils.a(77.0F, getResources()));
            }
            ((TextView)localObject2).setSingleLine();
            ((TextView)localObject2).setTextColor(getResources().getColor(2131168212));
            ((TextView)localObject2).setPadding(Utils.a(6.0F, getResources()), Utils.a(2.0F, getResources()), Utils.a(8.0F, getResources()), Utils.a(2.0F, getResources()));
            ((TextView)localObject2).setGravity(17);
            ((TextView)localObject2).setText((CharSequence)paramArrayList.get(i1));
            ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
            localObject3 = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams)localObject3).leftMargin = Utils.a(5.0F, getResources());
            localLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
          }
          i1 += 1;
        }
        paramArrayList = ((View)localObject1).findViewById(2131428774);
        if (paramBoolean1)
        {
          ((View)localObject1).setTag(Integer.valueOf(paramInt1));
          ((View)localObject1).setOnClickListener(this);
          paramArrayList.setVisibility(0);
          return;
        }
        ((View)localObject1).setTag(null);
        ((View)localObject1).setOnClickListener(null);
        paramArrayList.setVisibility(8);
        return;
      }
      ((LinearLayout)localObject2).setVisibility(0);
      localLinearLayout.setVisibility(8);
      ((TextView)localObject3).setText(HardCodeUtil.a(2131912720));
      a(paramInt1, true);
    }
  }
  
  protected void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    TextView localTextView = (TextView)paramView.findViewById(2131447463);
    paramView = (LinearLayout)paramView.findViewById(2131431322);
    if ((localTextView != null) && (paramView != null) && (!TextUtils.isEmpty(localTextView.getText())))
    {
      int i1 = (int)localTextView.getPaint().measureText(localTextView.getText().toString());
      paramView = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      if (this.F)
      {
        paramView.leftMargin = (i1 + Utils.a(100.0F, getResources()));
        return;
      }
      paramView.leftMargin = (i1 + Utils.a(90.0F, getResources()));
    }
  }
  
  public void a(GCBindGroup.GCBindGroupSsoServerRsp paramGCBindGroupSsoServerRsp)
  {
    int i1 = paramGCBindGroupSsoServerRsp.ret.get();
    Object localObject;
    if (i1 == -3000005)
    {
      this.G = 2;
    }
    else if (i1 == 0)
    {
      localObject = paramGCBindGroupSsoServerRsp.bind_info.app_name.get();
      paramGCBindGroupSsoServerRsp = (GCBindGroup.GCBindGroupSsoServerRsp)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label59;
      }
      this.G = 1;
      paramGCBindGroupSsoServerRsp = (GCBindGroup.GCBindGroupSsoServerRsp)localObject;
      break label59;
    }
    paramGCBindGroupSsoServerRsp = null;
    label59:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetGameBindStatus ret=");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append(", status=");
      ((StringBuilder)localObject).append(this.G);
      ((StringBuilder)localObject).append(", name=");
      ((StringBuilder)localObject).append(paramGCBindGroupSsoServerRsp);
      QLog.d("Q.troopinfo", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(String paramString)
  {
    QQToast.makeText(this, paramString, 0).show();
  }
  
  protected void a(String paramString1, String paramString2, String paramString3)
  {
    ReportController.b(this.H, "P_CliOper", "Grp_set", "", paramString1, paramString2, 0, 0, this.f.troopUin, paramString3, "", "");
  }
  
  protected void a(oidb_0x88d.GroupInfo paramGroupInfo)
  {
    if (paramGroupInfo != null)
    {
      if (paramGroupInfo.string_group_name.has()) {
        this.f.troopName = paramGroupInfo.string_group_name.get().toStringUtf8();
      }
      Object localObject1;
      if (paramGroupInfo.group_geo_info.has())
      {
        localObject1 = (oidb_0x88d.GroupGeoInfo)paramGroupInfo.group_geo_info.get();
        this.f.troopLat = ((int)((oidb_0x88d.GroupGeoInfo)localObject1).int64_latitude.get());
        this.f.troopLon = ((int)((oidb_0x88d.GroupGeoInfo)localObject1).int64_longitude.get());
        this.f.troopLocation = ((oidb_0x88d.GroupGeoInfo)localObject1).bytes_geocontent.get().toStringUtf8();
      }
      if (paramGroupInfo.uint32_group_class_ext.has()) {
        this.f.dwGroupClassExt = paramGroupInfo.uint32_group_class_ext.get();
      }
      if ((paramGroupInfo.rpt_tag_record.has()) && (paramGroupInfo.rpt_tag_record.size() > 0))
      {
        Object localObject2 = paramGroupInfo.rpt_tag_record.get();
        localObject1 = new ArrayList();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((List)localObject1).add(((oidb_0x88d.TagRecord)((Iterator)localObject2).next()).bytes_tag_value.get().toStringUtf8());
        }
        this.f.troopTags = ((List)localObject1);
      }
      if (paramGroupInfo.string_group_finger_memo.has()) {
        this.f.mRichFingerMemo = paramGroupInfo.string_group_rich_finger_memo.get().toStringUtf8();
      }
      this.J.sendEmptyMessage(4);
      this.J.sendEmptyMessage(6);
      C();
      d();
      c();
    }
  }
  
  protected boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "checkParams");
    }
    label645:
    boolean bool2;
    try
    {
      Object localObject = getIntent().getExtras();
      this.f.troopUin = ((Bundle)localObject).getString("troop_uin");
      if (Long.parseLong(this.f.troopUin) > 0L)
      {
        this.f.pa = ((Bundle)localObject).getInt("troop_info_from");
        this.X = ((Bundle)localObject).getInt("troop_info_report_from", -1);
        this.f.nStatOption = ((Bundle)localObject).getInt("troop_info_from_ex");
        this.f.remark = ((Bundle)localObject).getString("param_return_addr");
        this.f.isMember = ((Bundle)localObject).getBoolean("troop_info_is_member");
        this.f.troopface = ((Bundle)localObject).getShort("troop_info_faceid");
        this.f.troopName = ((Bundle)localObject).getString("troop_info_name");
        this.f.newTroopName = this.f.troopName;
        this.f.troopowneruin = ((Bundle)localObject).getString("troop_info_owner");
        this.f.dwGroupClassExt = ((Bundle)localObject).getLong("troop_info_classext");
        this.f.troopLocation = ((Bundle)localObject).getString("troop_info_loca");
        this.q = this.f.troopLocation;
        this.f.troopLat = ((Bundle)localObject).getInt("troop_info_lat", 0);
        this.f.troopLon = ((Bundle)localObject).getInt("troop_info_lon", 0);
        this.f.cityId = ((Bundle)localObject).getInt("troop_info_cityid", 0);
        this.f.currentTroopLocationStruct = a(this.f.troopLat, this.f.troopLon, this.f.troopLocation);
        this.f.mRichFingerMemo = ((Bundle)localObject).getString("troop_info_fingermemo");
        this.f.location = ((Bundle)localObject).getString("troop_info_school_location");
        this.f.school = ((Bundle)localObject).getString("troop_info_school_schoolid");
        this.f.grade = ((Bundle)localObject).getInt("troop_info_school_grade");
        this.f.cGroupOption = ((short)((Bundle)localObject).getByte("troop_info_opt"));
        this.f.mStrJoinQuestion = ((ITroopSystemMsgUtilApi)QRoute.api(ITroopSystemMsgUtilApi.class)).getTroopQuestionFromSP(this, this.f.troopUin);
        this.f.mStrJoinAnswer = ((ITroopSystemMsgUtilApi)QRoute.api(ITroopSystemMsgUtilApi.class)).getTroopAnswerFromSP(this, this.f.troopUin);
        this.f.dwGroupFlagExt = ((Bundle)localObject).getLong("TROOP_INFO_FLAG_EXT");
        this.f.troopTags = TroopInfo.getTags(((Bundle)localObject).getString("TROOP_INFO_TAGS_EXT"));
        this.f.troopTypeExt = ((Bundle)localObject).getInt("troop_type_ex");
        this.r = ((Bundle)localObject).getInt("troop_type_ex");
        this.f.wMemberNum = ((Bundle)localObject).getInt("TROOP_INFO_MEMBER_NUM");
        this.v = ((Bundle)localObject).getInt("troop_auth_submit_time");
        this.Y = ((Bundle)localObject).getInt("PARAM_EXIT_ANIMATION", 0);
        this.F = ((Bundle)localObject).getBoolean(TroopInfoActivityConstant.a, false);
        localObject = (ITroopInfoService)this.H.getRuntimeService(ITroopInfoService.class, "");
        if (localObject != null)
        {
          localObject = ((ITroopInfoService)localObject).findTroopInfo(this.f.troopUin);
          if (localObject != null)
          {
            this.i = ((TroopInfo)localObject);
            this.f.isMember = true;
            this.f.updateForTroopInfo((TroopInfo)localObject, this.H.getCurrentAccountUin());
            bool1 = true;
            break label645;
          }
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("can't find troop info of :");
            ((StringBuilder)localObject).append(this.f.troopUin);
            QLog.e("Q.troopinfo", 2, ((StringBuilder)localObject).toString());
          }
        }
        bool1 = false;
        try
        {
          if (this.f.bOwner)
          {
            this.A = "0";
            bool2 = bool1;
          }
          else
          {
            bool2 = bool1;
            if (this.f.bAdmin)
            {
              this.A = "1";
              bool2 = bool1;
            }
          }
        }
        catch (Exception localException1)
        {
          break label703;
        }
      }
      else
      {
        bool2 = false;
      }
    }
    catch (Exception localException2)
    {
      boolean bool1 = false;
      label703:
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, localException2.toString());
      }
      bool2 = bool1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.troopinfo", 2, String.format("checkParams troopUin: %s, classExt: %s", new Object[] { this.f.troopUin, Long.valueOf(this.f.dwGroupClassExt) }));
    }
    return bool2;
  }
  
  protected void b()
  {
    long l1 = System.currentTimeMillis();
    View localView = View.inflate(this, 2131627900, null);
    Object localObject1 = (ListView)localView.findViewById(2131430098);
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(HardCodeUtil.a(2131912712));
    ((ArrayList)localObject2).add(HardCodeUtil.a(2131912711));
    ((ListView)localObject1).setAdapter(new ArrayAdapter(this, 17367046, (List)localObject2));
    ((ListView)localObject1).setVisibility(4);
    this.z = ((XListView)localView.findViewById(2131431170));
    this.z.setVerticalScrollBarEnabled(false);
    this.z.setDivider(null);
    this.c = new View[14];
    this.b = new LinearLayout(this);
    localObject1 = new AbsListView.LayoutParams(-1, -2);
    this.b.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.b.setOrientation(1);
    this.b.setFocusable(false);
    this.b.setClickable(false);
    a(this.z);
    localObject1 = new XSimpleListAdapter(this.b);
    this.z.setAdapter((ListAdapter)localObject1);
    this.z.setBackgroundResource(2130838958);
    this.z.setFocusable(false);
    this.z.setClickable(false);
    this.a = ((ITroopInfoService)this.H.getRuntimeService(ITroopInfoService.class, "")).isQidianPrivateTroop(this.f.troopUin);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("mIsQidianPrivateTroop : ");
      ((StringBuilder)localObject1).append(this.a);
      ((StringBuilder)localObject1).append(", troopUin = ");
      ((StringBuilder)localObject1).append(this.f.troopUin);
      QLog.d("Q.troopinfo", 2, ((StringBuilder)localObject1).toString());
    }
    super.setContentView(localView);
    localObject2 = getIntent().getExtras().getString("troop_info_title");
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      if (this.F) {
        localObject1 = getString(2131917651);
      } else {
        localObject1 = getString(2131917520);
      }
    }
    setTitle((CharSequence)localObject1);
    if ((this.f.dwGroupFlagExt & 0x800) != 0L)
    {
      localObject1 = View.inflate(this, 2131627906, null);
      this.c[7] = localObject1;
      this.b.addView((View)localObject1);
      a(7, 0, (View)localObject1, getString(2131890825), this.f.troopAuthenticateInfo, false);
      localObject1 = View.inflate(this, 2131627926, null);
      this.b.addView((View)localObject1);
    }
    if (this.F)
    {
      localObject1 = c(HardCodeUtil.a(2131917583));
      this.b.addView((View)localObject1);
    }
    localObject1 = View.inflate(this, 2131627906, null);
    this.c[10] = localObject1;
    this.b.addView((View)localObject1);
    ((View)localObject1).setTag(Integer.valueOf(10));
    a(10, 2, (View)localObject1, getString(2131888754), "", true);
    d();
    a((View)localObject1);
    localObject1 = View.inflate(this, 2131627906, null);
    this.c[11] = localObject1;
    this.b.addView((View)localObject1);
    v();
    ((View)localObject1).setOnClickListener(this);
    if (this.F)
    {
      localObject1 = c(HardCodeUtil.a(2131917406));
      this.b.addView((View)localObject1);
    }
    localObject1 = View.inflate(this, 2131627906, null);
    this.c[12] = localObject1;
    this.b.addView((View)localObject1);
    w();
    ((View)localObject1).setOnClickListener(this);
    localObject1 = View.inflate(this, 2131627906, null);
    this.c[5] = localObject1;
    this.b.addView((View)localObject1);
    a(5, 2, (View)localObject1, getString(2131917684), this.f.troopLocation, this.f.isOwnerOrAdim());
    o();
    localObject1 = View.inflate(this, 2131627906, null);
    this.c[4] = localObject1;
    this.b.addView((View)localObject1);
    a(4, 2, (View)localObject1, getString(2131917407), this.f.troopClass, this.f.isOwnerOrAdim());
    if (this.f.isHomeworkTroop())
    {
      localObject1 = View.inflate(this, 2131627906, null);
      this.c[13] = localObject1;
      this.b.addView((View)localObject1);
      ((View)localObject1).setTag(Integer.valueOf(13));
      a(13, 2, (View)localObject1, getString(2131917408), "", true);
      c();
    }
    localObject1 = View.inflate(this, 2131627905, null);
    this.c[8] = localObject1;
    this.b.addView((View)localObject1);
    a(8, 3, (View)localObject1, getString(2131917409), null, this.f.isOwnerOrAdim(), 1);
    if (this.F) {
      ((View)localObject1).setBackgroundResource(2130839632);
    }
    ThreadManager.post(new TroopInfoActivity.2(this), 8, null, true);
    if (!this.F)
    {
      localObject1 = View.inflate(this, 2131627926, null);
      this.b.addView((View)localObject1);
    }
    localObject2 = View.inflate(this, 2131627913, null);
    this.c[6] = localObject2;
    this.b.addView((View)localObject2);
    if (!TextUtils.isEmpty(this.f.mRichFingerMemo)) {
      localObject1 = this.f.mRichFingerMemo;
    } else {
      localObject1 = getResources().getString(2131893929);
    }
    a(6, 3, (View)localObject2, getString(2131890938), (CharSequence)localObject1, this.f.isOwnerOrAdim());
    if (!this.F)
    {
      localObject1 = new LinearLayout.LayoutParams(-1, (int)(this.mDensity * 60.0F));
      localObject2 = View.inflate(this, 2131627926, null);
      this.b.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    }
    this.d = localView.findViewById(2131429850);
    this.e = ((Button)localView.findViewById(2131429754));
    if (this.f.isMember)
    {
      if (this.F) {
        b(18);
      } else {
        b(14);
      }
    }
    else {
      b(15);
    }
    this.e.setOnClickListener(this);
    if (this.F)
    {
      this.leftView.setText("取消");
      this.leftView.setBackgroundDrawable(null);
      this.leftView.setPadding(0, 5, 52, 5);
    }
    this.leftView.setOnClickListener(new TroopInfoActivity.3(this));
    this.rightViewText.setOnClickListener(new TroopInfoActivity.4(this));
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("initUI: time = ");
      ((StringBuilder)localObject1).append(System.currentTimeMillis() - l1);
      QLog.i("Q.troopinfo", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void b(int paramInt)
  {
    if (paramInt != 14)
    {
      if (paramInt != 15)
      {
        if (paramInt != 18)
        {
          this.d.setVisibility(8);
          this.e.setVisibility(8);
          return;
        }
        this.e.setText(2131917613);
        this.e.setTag(Integer.valueOf(18));
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.d.getLayoutParams();
        localLayoutParams.addRule(12, 0);
        localLayoutParams.setMargins(0, 76, 0, 0);
        this.d.setVisibility(0);
        this.e.setVisibility(0);
        if (this.d.getParent() != null) {
          ((ViewGroup)this.d.getParent()).removeView(this.d);
        }
        this.b.addView(this.d);
        return;
      }
      this.e.setText(2131891066);
      this.e.setTag(Integer.valueOf(15));
      this.d.setVisibility(0);
      this.e.setVisibility(0);
      return;
    }
    this.d.setVisibility(8);
    this.e.setVisibility(8);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setEnabled(true);
    this.rightViewText.setText(2131890914);
  }
  
  public void b(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    paramBundle = new Intent();
    paramBundle.setClass(this, ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).getTroopAvatarWallEditActivityClass());
    localBundle.putInt("index", 0);
    localBundle.putString("troop_uin", this.f.troopUin);
    localBundle.putLong("troop_flag_ext", this.f.dwGroupFlagExt);
    localBundle.putInt("troop_auth_submit_time", this.v);
    localBundle.putBoolean("troop_info_is_member", this.f.isMember);
    localBundle.putBoolean("isUseClassAvatar", this.f.isUseClassAvatar);
    paramBundle.putExtras(localBundle);
    paramBundle.addFlags(603979776);
    int i1;
    if ((localBundle.getBoolean("IS_COVER") ^ true)) {
      i1 = 260;
    } else {
      i1 = 258;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, String.format("gotoBigPic code=%d bundle=%s", new Object[] { Integer.valueOf(i1), localBundle }));
    }
    startActivityForResult(paramBundle, i1);
  }
  
  protected void b(String paramString)
  {
    n();
    QQProgressDialog localQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    localQQProgressDialog.a(paramString);
    localQQProgressDialog.setCancelable(false);
    localQQProgressDialog.setOnDismissListener(new TroopInfoActivity.17(this));
    this.s = localQQProgressDialog;
    this.s.show();
  }
  
  boolean b(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) != 0;
  }
  
  protected void c()
  {
    View localView = this.c[13];
    if (localView != null)
    {
      String str;
      if (TextUtils.isEmpty(this.f.location))
      {
        str = HardCodeUtil.a(2131905195);
        ReportController.b(this.H, "dc00898", "", "", "0X800B281", "0X800B281", 0, 0, this.f.troopUin, "1", "", "");
      }
      else
      {
        str = e(this.f.grade);
        ReportController.b(this.H, "dc00898", "", "", "0X800B281", "0X800B281", 0, 0, this.f.troopUin, "2", "", "");
      }
      ((TextView)localView.findViewById(2131435692)).setText(str);
      if (str.equals(HardCodeUtil.a(2131905195))) {
        a(13, true);
      } else {
        a(13, false);
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, String.format("updateTroopClassInfoEntry %s", new Object[] { str }));
      }
    }
  }
  
  protected void d()
  {
    Object localObject = this.c[10];
    if (localObject != null)
    {
      String str;
      if (this.f.hasSetNewTroopName) {
        str = this.f.newTroopName;
      } else {
        str = HardCodeUtil.a(2131899988);
      }
      localObject = (TextView)((View)localObject).findViewById(2131435692);
      if (localObject != null) {
        ((TextView)localObject).setText(str);
      }
      if (str.equals(HardCodeUtil.a(2131899988))) {
        a(10, true);
      } else {
        a(10, false);
      }
      if (this.F) {
        c(10, true);
      } else {
        c(10, false);
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, String.format("updateTroopNameEntry %s", new Object[] { str }));
      }
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onActivityResult, requestCode = ");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(", resultCode = ");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append(", data = ");
      ((StringBuilder)localObject1).append(paramIntent);
      QLog.i("Q.troopinfo", 2, ((StringBuilder)localObject1).toString());
    }
    if (-1 == paramInt2) {
      if (paramInt1 != 5) {
        if (paramInt1 != 11) {
          if (paramInt1 != 16) {
            if (paramInt1 != 257) {
              if (paramInt1 != 7) {
                if (paramInt1 != 8)
                {
                  if (paramInt1 != 9)
                  {
                    if (paramInt1 != 18)
                    {
                      if ((paramInt1 != 19) || (paramIntent == null) || (paramInt2 != -1)) {
                        break label1321;
                      }
                      localObject1 = paramIntent.getStringExtra("SchoolJsonObject");
                      try
                      {
                        localObject1 = new JSONObject((String)localObject1);
                        localObject3 = ((JSONObject)localObject1).getJSONObject("location");
                        this.o = true;
                        this.f.grade = ((JSONObject)localObject1).optInt("grade");
                        this.f.location = ((JSONObject)localObject3).toString();
                        this.f.school = ((JSONObject)localObject1).getString("school");
                      }
                      catch (JSONException localJSONException1)
                      {
                        localJSONException1.printStackTrace();
                      }
                      c();
                      break label1321;
                    }
                    if ((paramInt2 != -1) || (paramIntent == null)) {
                      break label1321;
                    }
                    if (!NetworkUtil.isNetworkAvailable(this))
                    {
                      QQToast.makeText(this, 1, 2131892105, 0).show(getTitleBarHeight());
                      return;
                    }
                    localObject2 = paramIntent.getStringExtra("result");
                    if (TextUtils.isEmpty((CharSequence)localObject2)) {
                      break label1321;
                    }
                    localObject3 = this.i;
                    if ((localObject3 == null) || (((String)localObject2).equals(((TroopInfo)localObject3).troopname))) {
                      break label1321;
                    }
                    localObject3 = (ITroopModifyHandler)this.H.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopModifyHandlerName());
                    boolean bool;
                    if ((!this.f.isOwnerOrAdim()) && (this.f.allowMemberModifTroopName == 1)) {
                      bool = true;
                    } else {
                      bool = false;
                    }
                    ((ITroopModifyHandler)localObject3).a(this.i.troopuin, (String)localObject2, bool);
                    localObject3 = this.i;
                    ((TroopInfo)localObject3).oldTroopName = ((TroopInfo)localObject3).troopname;
                    localObject3 = this.f;
                    ((TroopInfoData)localObject3).troopName = ((String)localObject2);
                    ((TroopInfoData)localObject3).newTroopName = this.i.getTroopDisplayName();
                    d();
                    break label1321;
                  }
                  localObject3 = paramIntent.getStringExtra("tags");
                  if ((localObject3 == null) || (((String)localObject3).length() <= 0)) {
                    break label1321;
                  }
                  localObject2 = new ArrayList();
                  new JSONArray();
                }
              }
            }
          }
        }
      }
    }
    try
    {
      localObject3 = new JSONArray((String)localObject3);
      paramInt2 = 0;
    }
    catch (JSONException localJSONException2)
    {
      try
      {
        for (;;)
        {
          int i1;
          ((List)localObject2).add(((JSONArray)localObject3).getString(paramInt2));
          paramInt2 += 1;
        }
        for (;;)
        {
          this.o = true;
          this.f.troopTags = ((List)localObject2);
          this.J.sendEmptyMessage(6);
          break label1321;
          if ((this.f.pa == 2) || (this.f.pa == 6) || (this.f.pa == 15) || (this.f.pa == 10) || (this.f.pa == 11) || (this.f.pa == 19) || (this.f.pa == 101) || (this.f.pa == 102) || (this.f.pa == 103) || (this.f.pa == 104) || (this.f.pa == 105) || (this.f.pa == 106) || (this.f.pa == 112) || (this.f.pa == 113))
          {
            setResult(-1);
            finish();
            break label1321;
            if ((paramIntent != null) && (paramIntent.getExtras() != null))
            {
              localObject2 = paramIntent.getExtras();
              this.f.troopLocation = ((Bundle)localObject2).getString("location");
              this.f.troopLat = ((Bundle)localObject2).getInt("lat", 0);
              this.f.troopLon = ((Bundle)localObject2).getInt("lon", 0);
              o();
              break label1321;
              if (this.aa)
              {
                localObject2 = this.ac;
                if (localObject2 != null) {
                  ((TroopAvatarController)localObject2).i();
                }
              }
              else
              {
                localObject2 = this.ab;
                if (localObject2 != null)
                {
                  ((TroopPhotoController)localObject2).i();
                  break label1321;
                  if ((paramIntent != null) && (paramIntent.getExtras() != null))
                  {
                    localObject2 = paramIntent.getExtras();
                    if (!Utils.a(this.f.troopLocation, ((Bundle)localObject2).getString("location"))) {
                      this.o = true;
                    }
                    this.f.currentTroopLocationStruct = ((Bundle)localObject2).getString("locationOriginal");
                    if (QLog.isColorLevel())
                    {
                      localObject3 = new StringBuilder();
                      ((StringBuilder)localObject3).append("REQUEST_FOR_EDIT_TROOP_LOCATION_WITHOUT_SAVE==>originalLocation:");
                      ((StringBuilder)localObject3).append(this.f.currentTroopLocationStruct);
                      QLog.e("Q.troopinfo.troop.location_info", 2, ((StringBuilder)localObject3).toString());
                    }
                    if (!TextUtils.isEmpty(this.f.currentTroopLocationStruct))
                    {
                      localObject3 = this.f.currentTroopLocationStruct.split("\\|");
                      if (localObject3.length < 5) {}
                    }
                  }
                }
              }
            }
          }
          try
          {
            this.f.mPoiId = Long.parseLong(localObject3[4]);
          }
          catch (NumberFormatException localNumberFormatException)
          {
            StringBuilder localStringBuilder;
            long l1;
            String str;
            break label1004;
          }
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("poi id is invalid:");
            localStringBuilder.append(localObject3[4]);
            localStringBuilder.append(", originalLocation:");
            localStringBuilder.append(this.f.currentTroopLocationStruct);
            QLog.e("Q.troopinfo", 2, localStringBuilder.toString());
            break label1124;
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("no poi id, location:");
              ((StringBuilder)localObject3).append(this.f.currentTroopLocationStruct);
              QLog.w("Q.troopinfo", 2, ((StringBuilder)localObject3).toString());
            }
          }
          this.f.troopLocation = ((Bundle)localObject2).getString("location");
          o();
          break label1321;
          try
          {
            l1 = Long.parseLong(paramIntent.getStringExtra("id"));
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel()) {
              QLog.i("Q.troopinfo", 2, localException.toString());
            }
            l1 = 9223372036854775807L;
          }
          if ((this.f.dwGroupClassExt != l1) && (l1 != 9223372036854775807L))
          {
            this.o = true;
            this.f.dwGroupClassExt = l1;
            C();
            break label1321;
            str = paramIntent.getStringExtra("result");
            if (!TextUtils.equals(str, this.f.mRichFingerMemo))
            {
              this.o = true;
              localObject3 = this.f;
              ((TroopInfoData)localObject3).mRichFingerMemo = str;
              if (!TextUtils.isEmpty(((TroopInfoData)localObject3).mRichFingerMemo)) {
                str = this.f.mRichFingerMemo;
              } else {
                str = getResources().getString(2131893929);
              }
              a(6, str, this.f.isOwnerOrAdim());
            }
          }
          if (paramInt1 == 258)
          {
            if (paramIntent != null)
            {
              paramIntent = paramIntent.getStringArrayListExtra("key_del_pics");
              if (QLog.isColorLevel())
              {
                if (paramIntent == null) {
                  paramIntent = null;
                } else {
                  paramIntent = Arrays.toString(paramIntent.toArray());
                }
                QLog.i("Q.troopinfo", 2, String.format("doOnActivityResult delPics=%s", new Object[] { paramIntent }));
              }
            }
            w();
            return;
          }
          if (paramInt1 == 260) {
            v();
          }
          return;
          localJSONException2 = localJSONException2;
        }
      }
      catch (JSONException localJSONException3)
      {
        break label516;
      }
    }
    i1 = ((JSONArray)localObject3).length();
    if (paramInt2 >= i1) {}
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if ((getAppRuntime() instanceof AppInterface)) {
      this.H = ((AppInterface)getAppRuntime());
    }
    if (this.H == null) {
      return false;
    }
    long l1 = 0L;
    if (QLog.isColorLevel()) {
      l1 = System.currentTimeMillis();
    }
    this.p = getIntent().getExtras().getBoolean("returnMsgList", false);
    if (!a())
    {
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("onCreate, illegal param, troopuin = ");
        paramBundle.append(this.f.troopUin);
        QLog.i("Q.troopinfo", 2, paramBundle.toString());
      }
      finish();
      return true;
    }
    if (this.f.isGameTroop()) {
      s();
    }
    this.E = ((IQQAvatarService)this.H.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.H);
    this.E.setDecodeTaskCompletionListener(this);
    b();
    addObserver(this.M);
    paramBundle = (ITroopManagerBizHandler)this.H.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopManagerBizHandlerName());
    if (paramBundle != null) {
      paramBundle.b(this.i.troopuin, "");
    }
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    registerReceiver(this.I, paramBundle, "com.tencent.msg.permission.pushnotify", null);
    this.C = true;
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onCreate(), time = ");
      paramBundle.append(System.currentTimeMillis() - l1);
      QLog.i("Q.troopinfo", 2, paramBundle.toString());
    }
    ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).bnrReport(this.H, 78);
    AppInterface localAppInterface = this.H;
    String str = this.f.troopUin;
    int i1 = this.X;
    if (this.f.bOwner) {
      paramBundle = "0";
    } else {
      paramBundle = "1";
    }
    ReportController.b(localAppInterface, "P_CliOper", "Grp_create", "", "edit_data", "edit", 0, 0, str, String.valueOf(i1), paramBundle, "");
    return true;
  }
  
  public void doOnDestroy()
  {
    this.k = true;
    long l1;
    if (QLog.isColorLevel()) {
      l1 = System.currentTimeMillis();
    } else {
      l1 = 0L;
    }
    GroupCatalogTool.a(getApplicationContext()).c();
    removeObserver(this.R);
    removeObserver(this.Q);
    removeObserver(this.P);
    removeObserver(this.N);
    removeObserver(this.O);
    removeObserver(this.L);
    removeObserver(this.K);
    removeObserver(this.M);
    if (this.C) {}
    try
    {
      unregisterReceiver(this.I);
      this.C = false;
    }
    catch (Exception localException)
    {
      label117:
      Object localObject;
      break label117;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.troopinfo", 2, "onDestroy(), unregisterReceiver Exception");
    }
    localObject = this.D;
    if (localObject != null) {
      ((TroopAvatarManger)localObject).b(this.V);
    }
    localObject = this.ab;
    if (localObject != null) {
      ((TroopPhotoController)localObject).e();
    }
    localObject = this.ac;
    if (localObject != null) {
      ((TroopAvatarController)localObject).e();
    }
    localObject = this.E;
    if (localObject != null) {
      ((IFaceDecoder)localObject).destory();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDestroy(), time = ");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - l1);
      QLog.i("Q.troopinfo", 2, ((StringBuilder)localObject).toString());
    }
    super.doOnDestroy();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    String str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    paramIntent = paramIntent.getStringExtra("key_clip_info");
    if (!TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, String.format("doOnNewIntent bAvatarEdit=%b clip=%s path=%s", new Object[] { Boolean.valueOf(this.aa), paramIntent, str }));
      }
      Object localObject;
      if (this.aa)
      {
        localObject = this.ac;
        if (localObject != null) {
          ((TroopAvatarController)localObject).b(str, paramIntent);
        }
      }
      else
      {
        localObject = this.ab;
        if (localObject != null) {
          ((TroopPhotoController)localObject).b(str, paramIntent);
        }
      }
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.g)) {
      this.J.sendEmptyMessage(1);
    }
  }
  
  protected void e()
  {
    if ((this.i != null) && (this.f.isMember))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.troopinfo", 4, "updateTroopInfoToDB");
      }
      ThreadManager.post(new TroopInfoActivity.6(this), 5, null, false);
    }
  }
  
  protected String f()
  {
    if (TextUtils.isEmpty(this.f.troopName)) {
      return getString(2131895306);
    }
    if (TextUtils.isEmpty(this.f.mRichFingerMemo)) {
      return getString(2131895305);
    }
    if (this.f.troopName.length() < 2) {
      return getString(2131895292);
    }
    if (this.f.mRichFingerMemo.length() < 15) {
      return getString(2131895291);
    }
    TroopInfo localTroopInfo = this.i;
    if ((localTroopInfo != null) && (((localTroopInfo.dwGroupFlag & 0x400) == 0L) || (0L != (this.i.dwGroupFlagExt & 0x20000)))) {
      return getString(2131895288);
    }
    return "";
  }
  
  public void finish()
  {
    n();
    i();
    Object localObject = this.f;
    if ((localObject != null) && (((TroopInfoData)localObject).pa != 28)) {
      setResult(-1, getIntent());
    }
    if (this.p) {
      p();
    }
    if (this.F)
    {
      localObject = this.f;
      if ((localObject != null) && (((TroopInfoData)localObject).troopUin != null) && (!this.f.isNewTroop) && (this.ad))
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("openSearchTroopWay", true);
        setResult(-1, (Intent)localObject);
      }
    }
    super.finish();
    int i1 = this.Y;
    if (i1 != 1)
    {
      if (i1 != 2) {
        return;
      }
      overridePendingTransition(0, 2130772030);
      return;
    }
    overridePendingTransition(0, 2130771995);
  }
  
  protected void g()
  {
    if (((this.B != 0L) || (this.f.tribeId != 0L)) && (this.v == 0))
    {
      Object localObject;
      if (this.f.modifyCount <= 0)
      {
        localObject = DialogUtil.a(this, 230);
        ((QQCustomDialog)localObject).setTitle(null);
        ((QQCustomDialog)localObject).setMessage(getString(2131895287));
        ((QQCustomDialog)localObject).setPositiveButton(getString(2131890888), new DialogUtil.DialogOnClickAdapter());
        ((QQCustomDialog)localObject).setPositiveButtonContentDescription(getString(2131890888));
        ((QQCustomDialog)localObject).show();
        return;
      }
      if (this.o)
      {
        localObject = f();
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = DialogUtil.a(this, 230);
          ((QQCustomDialog)localObject).setTitle(null);
          ((QQCustomDialog)localObject).setMessage(getString(2131895286, new Object[] { String.valueOf(this.f.modifyCount) }));
          ((QQCustomDialog)localObject).setPositiveButton(getString(2131890888), new TroopInfoActivity.7(this));
          ((QQCustomDialog)localObject).setNegativeButton(getString(2131890834), new TroopInfoActivity.8(this));
          ((QQCustomDialog)localObject).show();
          return;
        }
        a((String)localObject);
        return;
      }
      m();
      return;
    }
    m();
  }
  
  public void h()
  {
    if (!this.o)
    {
      this.Z = true;
      finish();
      return;
    }
    a(2131890896);
  }
  
  public void i()
  {
    if (this.f == null) {
      return;
    }
    Intent localIntent = getIntent();
    localIntent.putExtra("location", this.f.troopLocation);
    localIntent.putExtra("lat", this.f.troopLat);
    localIntent.putExtra("lon", this.f.troopLon);
    localIntent.putExtra("name", this.f.troopName);
    localIntent.putExtra("class", this.f.dwGroupClassExt);
    localIntent.putExtra("intro", this.f.mRichFingerMemo);
    localIntent.putExtra("location", this.f.location);
    localIntent.putExtra("grade", this.f.grade);
    localIntent.putExtra("school", this.f.school);
  }
  
  protected void j()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init(), isInitialized = ");
      localStringBuilder.append(this.g);
      QLog.i("Q.troopinfo", 2, localStringBuilder.toString());
    }
    if (this.g) {
      return;
    }
    this.g = true;
    addObserver(this.R);
    addObserver(this.Q);
    addObserver(this.P);
    addObserver(this.N);
    addObserver(this.O);
    addObserver(this.L);
    addObserver(this.K);
    addObserver(this.M);
    ThreadManager.post(new TroopInfoActivity.12(this), 5, null, true);
  }
  
  protected void k()
  {
    Object localObject2 = this.f.troopTags;
    Intent localIntent = new Intent(this, ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).getTroopTagViewActivityClass());
    localIntent.putExtra("troopuin", this.f.troopUin);
    localIntent.putExtra("isAdmin", this.f.isOwnerOrAdim());
    Object localObject1 = Long.toString(this.f.dwGroupClassExt);
    localObject1 = GroupCatalogTool.a(getApplicationContext()).a(this, (String)localObject1);
    if (!TextUtils.isEmpty(this.f.mTroopClassExtText)) {}
    for (localObject1 = this.f.mTroopClassExtText;; localObject1 = ((GroupCatalogBean)localObject1).b)
    {
      i1 = 1;
      break label158;
      if ((localObject1 == null) || (TextUtils.isEmpty(((GroupCatalogBean)localObject1).b)) || (((GroupCatalogBean)localObject1).b.equals(HardCodeUtil.a(2131912721)))) {
        break;
      }
    }
    localObject1 = "";
    int i1 = 0;
    label158:
    if (i1 != 0) {
      localIntent.putExtra("subclass", (String)localObject1);
    }
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      localObject1 = new StringBuffer();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("\n");
        ((StringBuffer)localObject1).append(localStringBuilder.toString());
      }
      ((StringBuffer)localObject1).deleteCharAt(((StringBuffer)localObject1).length() - 1);
      localIntent.putExtra("tags", ((StringBuffer)localObject1).toString());
    }
    localIntent.putExtra("act_type", 1);
    localIntent.putExtra("uin", this.H.getCurrentAccountUin());
    localIntent.putExtra("modifyToSrv", 0);
    startActivityForResult(localIntent, 9);
  }
  
  public void l()
  {
    if (this.f.isOwnerOrAdim())
    {
      AppInterface localAppInterface = this.H;
      String str2 = this.f.troopUin;
      String str1;
      if (this.F) {
        str1 = "2";
      } else {
        str1 = "1";
      }
      ReportController.b(localAppInterface, "P_CliOper", "Grp_set", "", "Grp_data", "add_place", 0, 0, str2, str1, "", "");
      ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).startModifyLocationActivityForResultEx(this, this.f.troopUin, this.f.troopLocation, 16);
    }
  }
  
  public void m()
  {
    if (this.f.pa == 28) {
      setResult(-1);
    }
    if (!this.o)
    {
      this.ad = true;
      finish();
      return;
    }
    Object localObject3 = this.H;
    Object localObject4 = this.f.troopUin;
    Object localObject2;
    if (this.F) {
      localObject2 = "2";
    } else {
      localObject2 = "1";
    }
    if (this.f.bOwner) {
      localObject1 = "0";
    } else if (this.f.bAdmin) {
      localObject1 = "1";
    } else {
      localObject1 = "2";
    }
    ReportController.b((AppRuntime)localObject3, "P_CliOper", "Grp_create", "", "edit_data", "modify", 0, 0, (String)localObject4, (String)localObject2, (String)localObject1, "");
    ITroopModifyHandler localITroopModifyHandler = (ITroopModifyHandler)this.H.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopModifyHandlerName());
    if (localITroopModifyHandler == null)
    {
      this.ad = true;
      finish();
      return;
    }
    try
    {
      l4 = Long.parseLong(this.f.troopUin);
      if (this.f.troopTypeExt == -1)
      {
        this.ad = true;
        finish();
        return;
      }
      localObject1 = this.f.currentTroopLocationStruct;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      long l4;
      int i1;
      double d1;
      int i2;
      long l1;
      long l3;
      long l2;
      label312:
      int i3;
      int i4;
      break label1298;
    }
    try
    {
      localObject1 = ((String)localObject1).split("\\|");
      i1 = Integer.valueOf(localObject1[0]).intValue();
    }
    catch (NumberFormatException|ArrayIndexOutOfBoundsException localNumberFormatException2)
    {
      break label328;
    }
    try
    {
      d1 = Double.valueOf(localObject1[1]).doubleValue();
      i2 = i1;
      l1 = (d1 * 1000000.0D);
    }
    catch (NumberFormatException localNumberFormatException3)
    {
      break label318;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      break label312;
    }
    try
    {
      d1 = Double.valueOf(localObject1[2]).doubleValue();
      l3 = (d1 * 1000000.0D);
      localObject1 = localObject1[3];
      l2 = l1;
      i1 = i2;
      l1 = l3;
    }
    catch (NumberFormatException|ArrayIndexOutOfBoundsException localNumberFormatException4)
    {
      break label321;
    }
    l1 = 0L;
    break label321;
    label318:
    l1 = 0L;
    label321:
    l2 = l1;
    break label333;
    label328:
    l2 = 0L;
    i1 = 0;
    label333:
    l1 = 0L;
    Object localObject1 = "";
    i2 = i1;
    break label359;
    localObject1 = "";
    l2 = 0L;
    i2 = 0;
    l1 = 0L;
    label359:
    b(getString(2131890906));
    if (this.f.troopTypeExt == 2) {
      i3 = 3;
    } else {
      i3 = this.f.troopTypeExt;
    }
    if (i3 == -1) {
      return;
    }
    if (this.B != 0L)
    {
      if (this.f.tribeId != this.B)
      {
        i1 = 3;
        break label468;
      }
      if (this.f.tribeId == 0L)
      {
        i1 = 4;
        break label468;
      }
    }
    else if (this.f.tribeId != 0L)
    {
      i1 = 2;
      break label468;
    }
    i1 = 1;
    label468:
    i4 = this.r;
    if (((i4 == 0) || (1 == i4)) && (i3 == 3)) {
      ReportController.b(this.H, "P_CliOper", "Grp_create", "", "edit_data", "set_local", 0, 0, this.f.troopUin, this.A, "", "");
    }
    i4 = this.r;
    if (((i4 == 2) || (i4 == 3) || (i4 == 4)) && ((i3 == 0) || (1 == i3))) {
      ReportController.b(this.H, "P_CliOper", "Grp_create", "", "edit_data", "un_local", 0, 0, this.f.troopUin, this.A, "", "");
    }
    if ((this.f.dwGroupFlagExt & 0x800) != 0L)
    {
      n();
      if (this.y > 0)
      {
        a(l4, i3, i2, l2, l1, (String)localObject1);
        localObject1 = this.H;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(l4);
        ReportController.b((AppRuntime)localObject1, "dc00899", "Grp_certified", "", "data", "exp_edit_data", 4, 0, ((StringBuilder)localObject2).toString(), "", "", "");
        return;
      }
      if (this.x > 0)
      {
        localObject1 = DialogUtil.a(this, 230);
        ((QQCustomDialog)localObject1).setTitle(null);
        ((QQCustomDialog)localObject1).setMessage(getString(2131890898, new Object[] { Integer.valueOf(this.x) }));
        ((QQCustomDialog)localObject1).setPositiveButton(getString(2131890888), new DialogUtil.DialogOnClickAdapter());
        ((QQCustomDialog)localObject1).setPositiveButtonContentDescription(getString(2131890888));
        ((QQCustomDialog)localObject1).show();
      }
    }
    else
    {
      i4 = this.r;
      if (((2 != i4) && (4 != i4)) || ((this.f.troopTypeExt != 2) && (this.f.troopTypeExt != 4)))
      {
        if ((this.f.tribeId == 0L) && (this.B == 0L))
        {
          if (!TextUtils.isEmpty(this.f.location)) {
            localObject2 = this.f.location;
          } else {
            localObject2 = "";
          }
          if (this.f.grade != 0) {
            i1 = this.f.grade;
          } else {
            i1 = 0;
          }
          if (!TextUtils.isEmpty(this.f.school)) {
            localObject3 = this.f.school;
          } else {
            localObject3 = "";
          }
          localObject4 = GroupCatalogTool.a(MobileQQ.sMobileQQ).a(MobileQQ.sMobileQQ, String.valueOf(this.f.dwGroupClassExt));
          if (localObject4 == null) {
            localObject4 = "";
          } else {
            localObject4 = ((GroupCatalogBean)localObject4).b;
          }
          localITroopModifyHandler.a(l4, i3, this.f.troopName, this.f.dwGroupClassExt, this.f.troopTags, i2, l2, l1, this.f.mPoiId, (String)localObject1, this.f.mRichFingerMemo, (String)localObject2, i1, (String)localObject3, (String)localObject4);
          return;
        }
        TroopInfoActivityHelper.a(this.H, l4, this.f.troopName, i2, l2, l1, this.f.mPoiId, (String)localObject1, this.f.dwGroupClassExt, this.f.troopTags, this.f.mRichFingerMemo, this.f.tribeId, i1, this.f.tribeName, new TroopInfoActivity.14(this));
        return;
      }
      if ((0L == l2) && (0L == l1))
      {
        l1 = this.f.troopLat;
        l2 = this.f.troopLon;
        localObject1 = this.f.troopLocation;
        l3 = l2;
      }
      else
      {
        l3 = l1;
        l1 = l2;
      }
      ReportController.b(this.H, "P_CliOper", "Grp_create", "", "edit_data", "local_sub", 0, 0, this.f.troopUin, this.A, "", "");
      TroopInfoActivityHelper.a(this.H, l4, this.f.troopName, i2, l1, l3, this.f.mPoiId, (String)localObject1, this.f.dwGroupClassExt, this.f.troopTags, this.f.mRichFingerMemo, this.f.tribeId, i1, this.f.tribeName, new TroopInfoActivity.13(this));
    }
    return;
    label1298:
    finish();
  }
  
  void n()
  {
    Dialog localDialog = this.s;
    if (localDialog != null)
    {
      if (localDialog.isShowing()) {
        this.s.dismiss();
      }
      this.s = null;
    }
  }
  
  public void o()
  {
    Object localObject = this.f;
    if (localObject == null) {
      return;
    }
    if ((!TextUtils.isEmpty(((TroopInfoData)localObject).troopLocation)) && (this.f.troopLat != 0) && (this.f.troopLon != 0))
    {
      a(5, this.f.troopLocation, true);
      a(5, false);
      return;
    }
    if (this.f.isOwnerOrAdim())
    {
      if (!TextUtils.isEmpty(this.f.troopLocation))
      {
        a(5, this.f.troopLocation, true);
        a(5, false);
        return;
      }
      a(5, HardCodeUtil.a(2131912713), true);
      a(5, true);
      return;
    }
    if (!TextUtils.isEmpty(this.f.troopLocation))
    {
      a(5, this.f.troopLocation, false);
      a(5, false);
      return;
    }
    localObject = this.c;
    if (localObject[5] != null) {
      localObject[5].setVisibility(8);
    }
  }
  
  public void onBackPressed()
  {
    h();
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    if ((localObject1 instanceof Integer))
    {
      int i3 = ((Integer)localObject1).intValue();
      if (i3 != 2)
      {
        if (i3 != 15)
        {
          if (i3 != 18)
          {
            localObject1 = "2";
            Object localObject2;
            Object localObject3;
            String str;
            if (i3 != 4)
            {
              if (i3 != 5)
              {
                if (i3 != 6)
                {
                  int i1;
                  switch (i3)
                  {
                  default: 
                    break;
                  case 13: 
                    ReportController.b(null, "dc00898", "", "", "0X800B282", "0X800B282", 0, 0, this.f.troopUin, "", "", "");
                    if (!this.f.isOwnerOrAdim()) {
                      break;
                    }
                    B();
                    break;
                  case 12: 
                    if (this.f == null) {
                      break;
                    }
                    localObject1 = paramView.getTag(2131917683);
                    if ((localObject1 != null) && ((localObject1 instanceof Integer))) {
                      i1 = ((Integer)localObject1).intValue();
                    } else {
                      i1 = 0;
                    }
                    if (i1 > 0)
                    {
                      c(12);
                    }
                    else
                    {
                      if (this.ab == null)
                      {
                        localObject1 = new Bundle();
                        ((Bundle)localObject1).putString("troopUin", this.f.troopUin);
                        ((Bundle)localObject1).putInt("type", 1);
                        this.ab = new TroopPhotoController(this, this, this.H, (Bundle)localObject1);
                        this.ab.a(this);
                      }
                      this.aa = false;
                      this.ab.b();
                    }
                    if (this.D == null)
                    {
                      this.D = new TroopAvatarManger(this.f.troopUin, TroopUploadingTask.class, this.H);
                      this.D.a(this.V);
                    }
                    a(i3, paramView);
                    localObject2 = this.H;
                    localObject3 = this.f.troopUin;
                    if (this.F) {
                      localObject1 = "2";
                    } else {
                      localObject1 = "1";
                    }
                    ReportController.b((AppRuntime)localObject2, "dc00899", "Grp_create_new", "", "edit_data", "cover", 0, 0, (String)localObject3, (String)localObject1, "", "");
                    break;
                  case 11: 
                    if (this.f.hasSetNewTroopHead)
                    {
                      c(11);
                    }
                    else if (this.f.isOwnerOrAdim())
                    {
                      if (this.ac == null)
                      {
                        localObject1 = new Bundle();
                        ((Bundle)localObject1).putString("troopUin", this.f.troopUin);
                        ((Bundle)localObject1).putInt("type", 1);
                        this.ac = new TroopAvatarController(this, this, this.H, (Bundle)localObject1);
                        this.ac.a(this);
                      }
                      this.aa = true;
                      this.ac.b();
                      if (this.D == null)
                      {
                        this.D = new TroopAvatarManger(this.f.troopUin, TroopUploadingTask.class, this.H);
                        this.D.a(this.V);
                      }
                    }
                    a(i3, paramView);
                    localObject3 = this.H;
                    str = this.f.troopUin;
                    if (this.F) {
                      localObject2 = "2";
                    } else {
                      localObject2 = "1";
                    }
                    if (this.f.bOwner) {
                      localObject1 = "0";
                    } else if (this.f.bAdmin) {
                      localObject1 = "1";
                    } else {
                      localObject1 = "2";
                    }
                    ReportController.b((AppRuntime)localObject3, "dc00899", "Grp_set_new", "", "grpData_admin", "clk_image", 0, 0, str, (String)localObject2, (String)localObject1, "");
                    break;
                  case 10: 
                    localObject1 = this.f;
                    if (localObject1 != null)
                    {
                      boolean bool;
                      if ((!((TroopInfoData)localObject1).isOwnerOrAdim()) && (this.f.allowMemberModifTroopName != 1)) {
                        bool = false;
                      } else {
                        bool = true;
                      }
                      if ((bool) && (QVipBigTroopExpiredProcessor.e().mIsEnable) && (this.f.mIsFreezed == 1) && (this.f.isOwnerOrAdim()))
                      {
                        ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).handleModifyNameFreezed(this.f, this);
                        ReportController.b(null, "dc00898", "", "", "qq_vip", "0X8009E37", 1, 0, "", "", "", "");
                      }
                      else
                      {
                        if (this.f.hasSetNewTroopName) {
                          localObject1 = this.f.newTroopName;
                        } else {
                          localObject1 = "";
                        }
                        localObject2 = localObject1;
                        if (localObject1 == null) {
                          localObject2 = "";
                        }
                        if ((!this.a) && (!this.f.isNewTroop)) {
                          i1 = 1;
                        } else {
                          i1 = 0;
                        }
                        localObject3 = new Intent();
                        ((Intent)localObject3).putExtra("edit_type", 1);
                        ((Intent)localObject3).putExtra("edit_mode", 2);
                        int i2;
                        if (bool) {
                          i2 = 2131899967;
                        } else {
                          i2 = 2131899966;
                        }
                        ((Intent)localObject3).putExtra("title", HardCodeUtil.a(i2));
                        ((Intent)localObject3).putExtra("default_text", (String)localObject2);
                        ((Intent)localObject3).putExtra("max_num", 96);
                        ((Intent)localObject3).putExtra("canPostNull", false);
                        if (bool) {
                          localObject1 = HardCodeUtil.a(2131899952);
                        } else {
                          localObject1 = "";
                        }
                        ((Intent)localObject3).putExtra("right_btn", (String)localObject1);
                        ((Intent)localObject3).putExtra("edit_mode", bool);
                        if (i1 != 0) {
                          localObject1 = this.f.troopUin;
                        } else {
                          localObject1 = "";
                        }
                        ((Intent)localObject3).putExtra("troopUin", (String)localObject1);
                        RouteUtils.a(this, (Intent)localObject3, "/base/activity/editInfoActivity", 18);
                        localObject3 = this.H;
                        str = this.f.troopUin;
                        if (this.F) {
                          localObject2 = "2";
                        } else {
                          localObject2 = "1";
                        }
                        if (this.f.bOwner) {
                          localObject1 = "0";
                        } else if (this.f.bAdmin) {
                          localObject1 = "1";
                        } else {
                          localObject1 = "2";
                        }
                        ReportController.b((AppRuntime)localObject3, "dc00899", "Grp_set", "", "Grp_data", "add_name", 0, 0, str, (String)localObject2, (String)localObject1, "");
                      }
                    }
                    else
                    {
                      a(i3, paramView);
                    }
                    break;
                  case 9: 
                    localObject1 = new ActivityURIRequest(this, "/base/browser");
                    localObject2 = new Intent();
                    ((Intent)localObject2).putExtra("url", "https://buluo.qq.com/mobile/qunbindbuluo.html?_wv=1027");
                    ((Intent)localObject2).putExtra("bid", this.f.tribeId);
                    ((ActivityURIRequest)localObject1).extra().putAll(((Intent)localObject2).getExtras());
                    ((ActivityURIRequest)localObject1).setRequestCode(17);
                    QRoute.startUri((URIRequest)localObject1, null);
                    break;
                  case 8: 
                    localObject3 = this.H;
                    str = this.f.troopUin;
                    if (this.F) {
                      localObject2 = "2";
                    } else {
                      localObject2 = "1";
                    }
                    if (this.f.bOwner) {
                      localObject1 = "0";
                    } else if (this.f.bAdmin) {
                      localObject1 = "1";
                    } else {
                      localObject1 = "2";
                    }
                    ReportController.b((AppRuntime)localObject3, "dc00899", "Grp_set", "", "Grp_data", "add_tag", 0, 0, str, (String)localObject2, (String)localObject1, "");
                    k();
                    a(i3, paramView);
                    break;
                  }
                }
                else
                {
                  localObject2 = new Intent();
                  ((Intent)localObject2).putExtra("edit_type", 2);
                  ((Intent)localObject2).putExtra("edit_mode", 1);
                  ((Intent)localObject2).putExtra("title", getString(2131890938));
                  ((Intent)localObject2).putExtra("default_text", this.f.mRichFingerMemo);
                  ((Intent)localObject2).putExtra("max_num", 900);
                  ((Intent)localObject2).putExtra("canPostNull", true);
                  ((Intent)localObject2).putExtra("support_emotion", true);
                  ((Intent)localObject2).putExtra("full_screen", true);
                  RouteUtils.a(this, (Intent)localObject2, "/base/activity/editInfoActivity", 5);
                  if (!this.F) {
                    localObject1 = "1";
                  }
                  a("Grp_moredata", "Clk_brief", (String)localObject1);
                  a(i3, paramView);
                }
              }
              else
              {
                l();
                a(i3, paramView);
              }
            }
            else
            {
              if (this.G == 1)
              {
                QQToast.makeText(getApplicationContext(), 1, HardCodeUtil.a(2131912716), 0).show();
              }
              else
              {
                localObject3 = this.H;
                str = this.f.troopUin;
                if (this.F) {
                  localObject2 = "2";
                } else {
                  localObject2 = "1";
                }
                if (this.f.bOwner) {
                  localObject1 = "0";
                } else if (this.f.bAdmin) {
                  localObject1 = "1";
                } else {
                  localObject1 = "2";
                }
                ReportController.b((AppRuntime)localObject3, "dc00899", "Grp_set", "", "Grp_data", "add_category", 0, 0, str, (String)localObject2, (String)localObject1, "");
                localObject1 = new Intent(getActivity(), ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).getTroopClassChoiceActivtiyClass());
                ((Intent)localObject1).putExtra("troopGroupClassExt", Long.toString(this.f.dwGroupClassExt));
                startActivityForResult((Intent)localObject1, 11);
              }
              a(i3, paramView);
            }
          }
          else if (!NetworkUtil.isNetworkAvailable(this))
          {
            if ((this.f.isNewTroop) && (!this.i.hasSetNewTroopHead) && (!this.i.hasSetNewTroopName)) {
              QQToast.makeText(this, 1, 2131892105, 0).show(getTitleBarHeight());
            } else if (!this.o) {
              t();
            } else {
              QQToast.makeText(this, 1, 2131892105, 0).show(getTitleBarHeight());
            }
          }
          else if ((this.f.isNewTroop) && (!this.i.hasSetNewTroopHead) && (!this.i.hasSetNewTroopName))
          {
            a(2131917624);
          }
          else if ((this.f.isNewTroop) && (!this.i.hasSetNewTroopHead))
          {
            a(2131917622);
          }
          else if ((this.f.isNewTroop) && (!this.i.hasSetNewTroopName))
          {
            a(2131917623);
          }
          else
          {
            t();
          }
        }
        else if (!NetworkUtil.isNetSupport(this))
        {
          a(2131892102, 0);
        }
        else
        {
          localObject1 = (ITroopMngHandler)this.H.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopMngHandlerName());
          if (localObject1 != null)
          {
            try
            {
              long l1 = Long.parseLong(this.f.troopUin);
              q();
              ((ITroopMngHandler)localObject1).a(l1, 8390784);
            }
            catch (Exception localException)
            {
              if (!QLog.isColorLevel()) {
                break label2023;
              }
            }
            QLog.i("Q.troopinfo", 2, localException.toString());
          }
        }
      }
      else {
        A();
      }
    }
    label2023:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, String.format("onDecodeTaskCompleted uin=%s", new Object[] { paramString }));
      }
      if ((paramString != null) && (paramString.equals(this.f.troopUin))) {
        v();
      }
    }
  }
  
  public void p()
  {
    ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).goToMsgList(this);
  }
  
  public void q()
  {
    try
    {
      if (this.S == null)
      {
        this.S = new QQProgressDialog(getActivity(), getTitleBarHeight());
        this.S.c(2131892360);
        this.S.c(false);
      }
      this.S.show();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, localException.toString());
      }
    }
  }
  
  public void r()
  {
    try
    {
      if ((this.S != null) && (this.S.isShowing()))
      {
        this.S.dismiss();
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, localException.toString());
      }
    }
  }
  
  public void s()
  {
    Object localObject1 = new GCBindGroup.GCBindGroupSsoServerReq();
    ((GCBindGroup.GCBindGroupSsoServerReq)localObject1).cmd.set("get_appid");
    Object localObject2 = new GCBindGroup.QQGroupBind();
    try
    {
      long l1 = Long.parseLong(this.f.troopUin);
      ((GCBindGroup.QQGroupBind)localObject2).group_code.set(l1);
      ((GCBindGroup.GCBindGroupSsoServerReq)localObject1).bind_req.set((MessageMicro)localObject2);
      localObject2 = new NewIntent(MobileQQ.getContext(), ProtoServlet.class);
      TroopInfoActivity.32 local32 = new TroopInfoActivity.32(this);
      local32.mApp = new WeakReference(this.H);
      local32.mType = 2;
      ((NewIntent)localObject2).setObserver(local32);
      ((NewIntent)localObject2).putExtra("cmd", "gcbindgroupsso.get_appid");
      ((NewIntent)localObject2).putExtra("data", ((GCBindGroup.GCBindGroupSsoServerReq)localObject1).toByteArray());
      this.H.startServlet((NewIntent)localObject2);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label145:
      break label145;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("get game bind status failed, troop=");
    ((StringBuilder)localObject1).append(this.f.troopUin);
    QLog.e("Q.troopinfo", 1, ((StringBuilder)localObject1).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.TroopInfoActivity
 * JD-Core Version:    0.7.0.1
 */