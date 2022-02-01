package com.tencent.mobileqq.troop.troopcard;

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
  public static final DownloadParams.DecodeHandler a;
  public int a;
  public long a;
  public Dialog a;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new TroopInfoActivity.1(this);
  Handler jdField_a_of_type_AndroidOsHandler = new TroopInfoActivity.18(this);
  protected View a;
  protected Button a;
  protected LinearLayout a;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  protected IFaceDecoder a;
  AvatarObserver jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new TroopInfoActivity.19(this);
  protected TroopInfo a;
  TroopMngObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver = new TroopInfoActivity.24(this);
  TroopModifyObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopModifyObserver = new TroopInfoActivity.22(this);
  TroopObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new TroopInfoActivity.23(this);
  private TroopAvatarController jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopAvatarController;
  public TroopAvatarManger a;
  private TroopPhotoController jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController;
  protected TroopInfoData a;
  TempFriendListObserver jdField_a_of_type_ComTencentMobileqqTroopObserverTempFriendListObserver = new TroopInfoActivity.20(this);
  TroopAuditObserver jdField_a_of_type_ComTencentMobileqqTroopObserverTroopAuditObserver = new TroopInfoActivity.26(this);
  TroopManagerBizObserver jdField_a_of_type_ComTencentMobileqqTroopTroopmanagerApiTroopManagerBizObserver = new TroopInfoActivity.21(this);
  TroopSettingObserver jdField_a_of_type_ComTencentMobileqqTroopTroopsettingApiTroopSettingObserver = new TroopInfoActivity.25(this);
  protected QQProgressDialog a;
  protected XListView a;
  public String a;
  protected ArrayList<String> a;
  protected List<Integer> a;
  Observer jdField_a_of_type_JavaUtilObserver = new TroopInfoActivity.33(this);
  protected boolean a;
  protected View[] a;
  public int b;
  public long b;
  protected View b;
  protected String b;
  protected boolean b;
  public int c;
  protected long c;
  protected View c;
  protected boolean c;
  public int d;
  boolean d;
  public int e;
  public boolean e;
  protected int f;
  protected boolean f;
  private int g;
  public boolean g;
  private int h;
  public boolean h;
  protected boolean i = false;
  protected boolean j = false;
  private boolean k = false;
  private boolean l = false;
  private boolean m = false;
  
  static
  {
    jdField_a_of_type_ComTencentImageDownloadParams$DecodeHandler = new TroopInfoActivity.34();
  }
  
  public TroopInfoActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData = new TroopInfoData();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = -1;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_Long = 0L;
    this.jdField_f_of_type_Int = 0;
  }
  
  private void A()
  {
    Object localObject = this.jdField_b_of_type_AndroidViewView;
    if (localObject != null)
    {
      localObject = (TextView)((View)localObject).findViewById(2131378503);
      if ((2 != this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopTypeExt) && (4 != this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopTypeExt)) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      int n = i1;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.dwAppPrivilegeFlag & 0x4000) != 0L) {
        n = i1 | 0x2;
      }
      if (4 != this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopTypeExt)
      {
        i1 = n;
        if (3 != this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopTypeExt) {}
      }
      else
      {
        i1 = n | 0x4;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.tribeStatus != 2)
      {
        n = i1;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.tribeStatus != 3) {}
      }
      else
      {
        n = i1 | 0x8;
      }
      int i1 = n;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.tribeStatus == 1) {
        i1 = n | 0x10;
      }
      n = i1;
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwGroupFlagExt & 0x800) != 0L) {
        n = i1 | 0x20;
      }
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getSharedPreferences("auth_troop_info_filename", 4);
      boolean bool = localSharedPreferences.getBoolean("has_shown_tips", false);
      if (a(n, 32))
      {
        n = this.jdField_c_of_type_Int;
        if (n == 2)
        {
          n = 2131697524;
          break label489;
        }
        if ((n == 3) && (!bool))
        {
          n = 2131697525;
          localSharedPreferences.edit().putBoolean("has_shown_tips", true).commit();
          break label489;
        }
      }
      else
      {
        if (a(n, 1))
        {
          if (a(n, 2))
          {
            if ((!a(n, 4)) && (!a(n, 8)) && (!a(n, 16)))
            {
              n = 2131697537;
              break label489;
            }
            n = 2131697538;
            break label489;
          }
          if (a(n, 8))
          {
            n = 2131697531;
            break label489;
          }
          if (a(n, 4))
          {
            n = 2131697530;
            break label489;
          }
          n = 2131697529;
          break label489;
        }
        if (a(n, 2))
        {
          if (a(n, 4))
          {
            n = 2131697536;
            break label489;
          }
          if ((!a(n, 8)) && (!a(n, 16)))
          {
            n = 2131697534;
            break label489;
          }
          n = 2131697535;
          break label489;
        }
        if ((a(n, 8)) && (a(n, 4)))
        {
          n = 2131697526;
          break label489;
        }
        if (a(n, 8))
        {
          n = 2131697528;
          break label489;
        }
        if (a(n, 4))
        {
          n = 2131697527;
          break label489;
        }
      }
      n = 0;
      label489:
      if (n != 0)
      {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        ((TextView)localObject).setText(n);
        ((TextView)localObject).setContentDescription(getString(n));
        return;
      }
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  private void B()
  {
    startTitleProgress();
    TroopInfoActivityHelper.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin).longValue(), new TroopInfoActivity.30(this));
  }
  
  private void C()
  {
    TroopInfoActivityHelper.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin).longValue(), new TroopInfoActivity.31(this));
  }
  
  private Drawable a()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localObject1 != null)
    {
      localObject2 = ((IFaceDecoder)localObject1).getBitmapFromCache(4, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing())
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, 4, true);
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
      localObject2 = BaseImageUtil.f();
    }
    localObject1 = new BitmapDrawable((Bitmap)localObject2);
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentCommonAppAppInterface)) {
      ((Drawable)localObject1).setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
    }
    return localObject1;
  }
  
  public static Bundle a(String paramString, int paramInt)
  {
    return TroopInfoUIUtil.a(paramString, "", paramInt);
  }
  
  public static Bundle a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    return TroopInfoUIUtil.a(paramString1, paramInt1, paramInt2, paramInt3, paramInt4, paramString2);
  }
  
  private View a(String paramString)
  {
    TextView localTextView = new TextView(this);
    localTextView.setText(paramString);
    localTextView.setTextColor(getResources().getColor(2131167138));
    localTextView.setPadding(getResources().getDimensionPixelSize(2131299219), ViewUtils.a(20.0F), 0, ViewUtils.a(10.0F));
    localTextView.setFocusable(true);
    return localTextView;
  }
  
  private String a(int paramInt)
  {
    Object localObject1;
    try
    {
      JSONArray localJSONArray1 = new JSONObject("{\"datas\":{\"0\":[{\"id\":10,\"text\":\"幼儿园\",\"subs\":[{\"id\":11,\"text\":\"小班\"},{\"id\":12,\"text\":\"中班\"},{\"id\":13,\"text\":\"大班\"}]},{\"id\":20,\"text\":\"小学\",\"subs\":[{\"id\":21,\"text\":\"一年级\"},{\"id\":22,\"text\":\"二年级\"},{\"id\":23,\"text\":\"三年级\"},{\"id\":24,\"text\":\"四年级\"},{\"id\":25,\"text\":\"五年级\"},{\"id\":26,\"text\":\"六年级\"}]},{\"id\":30,\"text\":\"初中\",\"subs\":[{\"id\":31,\"text\":\"初一\"},{\"id\":32,\"text\":\"初二\"},{\"id\":33,\"text\":\"初三\"}]},{\"id\":40,\"text\":\"高中\",\"subs\":[{\"id\":41,\"text\":\"高一\"},{\"id\":42,\"text\":\"高二\"},{\"id\":43,\"text\":\"高三\"}]},{\"id\":50,\"text\":\"其他\",\"subs\":[{\"id\":51,\"text\":\"普通高校\"},{\"id\":52,\"text\":\"中职院校\"},{\"id\":53,\"text\":\"培训机构\"}]}]}}").getJSONObject("datas").getJSONArray("0");
      localObject1 = "";
      int n = 0;
      for (;;)
      {
        Object localObject2 = localObject1;
        try
        {
          if (n >= localJSONArray1.length()) {
            break label170;
          }
          localObject2 = localJSONArray1.getJSONObject(n);
          int i1 = ((JSONObject)localObject2).getInt("id");
          if (paramInt == i1) {
            return ((JSONObject)localObject2).getString("text");
          }
          JSONArray localJSONArray2 = ((JSONObject)localObject2).getJSONArray("subs");
          i1 = 0;
          for (;;)
          {
            localObject2 = localObject1;
            if (i1 >= localJSONArray2.length()) {
              break;
            }
            localObject2 = localJSONArray2.getJSONObject(i1);
            if (paramInt == ((JSONObject)localObject2).getInt("id"))
            {
              localObject2 = ((JSONObject)localObject2).getString("text");
              break;
            }
            i1 += 1;
          }
          n += 1;
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
  
  private String a(int paramInt1, int paramInt2, String paramString)
  {
    TroopInfoData localTroopInfoData = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
    Object localObject = "";
    if (localTroopInfoData != null)
    {
      int n = localTroopInfoData.cityId;
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
      paramString = String.format("%d|%f|%f|%s", new Object[] { Integer.valueOf(n), Double.valueOf(d1), Double.valueOf(d2), localObject });
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
    } else if ((paramContext != null) && (!TextUtils.isEmpty(paramContext.jdField_a_of_type_JavaLangString)) && (!paramContext.jdField_a_of_type_JavaLangString.equals(HardCodeUtil.a(2131715232)))) {
      paramContext = paramContext.jdField_a_of_type_JavaLangString;
    } else {
      paramContext = "";
    }
    localObject = new ArrayList();
    boolean bool = TextUtils.isEmpty(paramContext);
    int i1 = 0;
    int n;
    if (!bool)
    {
      ((ArrayList)localObject).add(paramContext);
      n = 1;
    }
    else
    {
      n = 0;
    }
    if ((paramTroopInfoData.troopTags != null) && (paramTroopInfoData.troopTags.size() > 0))
    {
      int i2 = paramTroopInfoData.troopTags.size();
      while (i1 < i2)
      {
        if ((n == 0) || (!((String)paramTroopInfoData.troopTags.get(i1)).equals(paramContext))) {
          ((ArrayList)localObject).add(paramTroopInfoData.troopTags.get(i1));
        }
        i1 += 1;
      }
    }
    return localObject;
  }
  
  private void a(int paramInt, View paramView)
  {
    TroopInfoData localTroopInfoData = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
    if ((localTroopInfoData != null) && (localTroopInfoData.bOwner))
    {
      paramView = paramView.findViewById(2131376315);
      if ((paramView != null) && (paramView.getVisibility() == 0))
      {
        ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).setTroopInfoEditRedShow(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, paramInt, false);
        b(paramInt, false);
      }
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.bOwner) && (!this.j) && (!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isNewTroop))
    {
      int i1 = 1;
      int n = i1;
      if (paramInt == 8)
      {
        n = i1;
        if (!((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).isTroopTagNeedRedDot(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwGroupClassExt)) {
          n = 0;
        }
      }
      if ((n != 0) && (((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getTroopInfoEditRedShow(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, paramInt))) {
        b(paramInt, paramBoolean);
      }
    }
  }
  
  private void a(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString)
  {
    ReportDialog localReportDialog = new ReportDialog(this, 2131756189);
    localReportDialog.setContentView(2131561033);
    ((TextView)localReportDialog.findViewById(2131365681)).setVisibility(8);
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131365669);
    TextView localTextView2 = (TextView)localReportDialog.findViewById(2131365667);
    TextView localTextView3 = (TextView)localReportDialog.findViewById(2131365673);
    localTextView1.setText(String.format(getString(2131693356), new Object[] { Integer.valueOf(this.jdField_d_of_type_Int) }));
    localTextView1.setGravity(3);
    localTextView2.setText(2131694583);
    localTextView3.setText(2131693336);
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
    this.jdField_b_of_type_AndroidViewView = super.getLayoutInflater().inflate(2131560630, paramXListView, false);
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131378757);
    ((ImageButton)this.jdField_b_of_type_AndroidViewView.findViewById(2131364703)).setOnClickListener(new TroopInfoActivity.29(this, paramXListView));
    paramXListView.addHeaderView(this.jdField_b_of_type_AndroidViewView);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void a(boolean paramBoolean, long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    l();
    Object localObject1 = "";
    Object localObject3;
    Object localObject2;
    if (!paramBoolean)
    {
      if (TextUtils.isEmpty(paramString))
      {
        int n = (int)paramLong1;
        if (n != 1793) {
          switch (n)
          {
          default: 
            paramString = getString(2131693351);
            break;
          case 1283: 
            paramString = getString(2131693354);
            break;
          case 1282: 
            paramString = getString(2131693353);
            break;
          case 1281: 
            paramString = getString(2131693352);
            break;
          }
        } else {
          paramString = getString(2131693355);
        }
      }
      AppInterface localAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
      localObject2 = localObject1;
      if (localObject3 != null) {
        localObject2 = ((TroopInfoData)localObject3).troopUin;
      }
      if (this.j) {
        localObject3 = "2";
      } else {
        localObject3 = "1";
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
      if ((localObject1 != null) && (!((TroopInfoData)localObject1).bOwner))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.bAdmin) {
          localObject1 = "1";
        } else {
          localObject1 = "2";
        }
      }
      else {
        localObject1 = "0";
      }
      ReportController.b(localAppInterface, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, (String)localObject2, (String)localObject3, (String)localObject1, "");
      QQToast.a(this, 1, paramString, 1).b(getTitleBarHeight());
    }
    else
    {
      localObject3 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
      paramString = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
      if (paramString != null) {
        localObject1 = paramString.troopUin;
      }
      if (this.j) {
        localObject2 = "2";
      } else {
        localObject2 = "1";
      }
      paramString = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
      if ((paramString != null) && (!paramString.bOwner))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.bAdmin) {
          paramString = "1";
        } else {
          paramString = "2";
        }
      }
      else {
        paramString = "0";
      }
      ReportController.b((AppRuntime)localObject3, "P_CliOper", "Grp_create", "", "edit_data", "suc_modify", 0, 0, (String)localObject1, (String)localObject2, paramString, "");
      if (!this.j) {
        QQToast.a(this, 2, getString(2131693358), 1).b(getTitleBarHeight());
      }
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(TroopModifyHandler.class.getName()).notifyUI(TroopModifyObserver.jdField_f_of_type_Int, true, new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      this.m = true;
      finish();
    }
  }
  
  private String b()
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopName)) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopName.length() >= 2))
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLocation))
      {
        ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, "2", "", "");
        return getString(2131697517);
      }
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mRichFingerMemo)) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mRichFingerMemo.length() >= 15))
      {
        if (3 == this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.cGroupOption)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, "3", "", "");
          return getString(2131697516);
        }
        TroopInfo localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
        if ((localTroopInfo != null) && (((localTroopInfo.dwGroupFlag & 0x400) == 0L) || (0L != (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.dwGroupFlagExt & 0x20000)))) {
          return getString(2131697515);
        }
        return "";
      }
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, "1", "", "");
      return getString(2131697518);
    }
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, "0", "", "");
    return getString(2131697519);
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView;
    if (paramInt < localObject.length)
    {
      localObject = localObject[paramInt];
      if (localObject != null)
      {
        View localView = ((View)localObject).findViewById(2131376315);
        int n = 8;
        if (paramInt == 8) {
          localObject = ((View)localObject).findViewById(2131378467);
        } else {
          localObject = ((View)localObject).findViewById(2131365169);
        }
        if (localView != null)
        {
          paramInt = n;
          if (paramBoolean) {
            paramInt = 0;
          }
          localView.setVisibility(paramInt);
        }
        if ((localObject != null) && ((((View)localObject).getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
        {
          localObject = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
          n = getResources().getDimensionPixelSize(2131298542);
          paramInt = n;
          if (paramBoolean) {
            paramInt = n * 2;
          }
          ((ViewGroup.MarginLayoutParams)localObject).rightMargin = paramInt;
        }
      }
    }
  }
  
  private void c(int paramInt)
  {
    if (paramInt == 11) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if ((QVipBigTroopExpiredProcessor.c().mIsEnable) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mIsFreezed == 1) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim()))
    {
      ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).handleModiftyTroopHeadFreezed(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData, this);
      ReportController.b(null, "dc00898", "", "", "qq_vip", "0X8009E37", 2, 0, "", "", "", "");
      return;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putBoolean("IS_COVER", paramInt ^ 0x1);
    ((Bundle)localObject).putBoolean("IS_EDIT", true);
    b((Bundle)localObject);
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "nonmber_Clk_head", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, "", "", "");
    String str = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isMember) {
      localObject = "1";
    } else {
      localObject = "0";
    }
    TroopReportor.a("Grp_set_new", "grpData_admin", "clk_head", 0, 0, new String[] { str, localObject });
  }
  
  private void c(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView;
    if (paramInt < localObject.length)
    {
      localObject = localObject[paramInt];
      if (localObject != null)
      {
        localObject = ((View)localObject).findViewById(2131376314);
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
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null)
    {
      localObject = (ITroopInfoService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopInfoService.class, "");
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((ITroopInfoService)localObject).findTroopInfo(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
      }
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = ((TroopInfo)localObject);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
    if (localObject != null)
    {
      if ((paramInt & 0x2) > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwGroupClassExt = ((TroopInfo)localObject).dwGroupClassExt;
        y();
      }
      if ((paramInt & 0x20) > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mRichFingerMemo = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.fingertroopmemo;
        a(6, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.fingertroopmemo, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim());
      }
    }
  }
  
  private void r()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
    if (localObject == null) {
      return;
    }
    if ((((TroopInfoData)localObject).tribeId == 0L) && (this.jdField_c_of_type_Long == 0L))
    {
      int n = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopTypeExt;
      if ((n != 0) && (n != 1))
      {
        if ((n != 2) && (n != 3) && (n != 4)) {
          return;
        }
        long l1 = this.jdField_a_of_type_Long;
        if ((l1 > 0L) && (l1 <= this.jdField_b_of_type_Long) && (this.jdField_b_of_type_Int == 0))
        {
          localObject = DialogUtil.a(this, 230);
          ((QQCustomDialog)localObject).setTitle(null);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.jdField_a_of_type_Long);
          localStringBuilder.append("");
          ((QQCustomDialog)localObject).setMessage(getString(2131693341, new Object[] { localStringBuilder.toString() }));
          ((QQCustomDialog)localObject).setPositiveButton(getString(2131693339), new DialogUtil.DialogOnClickAdapter());
          ((QQCustomDialog)localObject).setPositiveButtonContentDescription(getString(2131693339));
          ((QQCustomDialog)localObject).show();
          return;
        }
        localObject = b();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          a((String)localObject);
          return;
        }
        u();
        return;
      }
      k();
      return;
    }
    e();
  }
  
  private void s()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[11];
    if (localView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.hasSetNewTroopHead)
      {
        SpannableString localSpannableString = new SpannableString("[Avatar]");
        Drawable localDrawable = a();
        if (localDrawable != null)
        {
          localDrawable.setBounds(0, 0, ScreenUtil.dip2px(32.0F), ScreenUtil.dip2px(32.0F));
          localSpannableString.setSpan(new ImageSpan(localDrawable, 0), 0, localSpannableString.length(), 17);
          a(11, 2, localView, getString(2131699460), localSpannableString, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim());
          a(11, false);
        }
      }
      else
      {
        a(11, 2, localView, getString(2131699460), HardCodeUtil.a(2131715231), this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim());
        a(11, true);
      }
      if (this.j)
      {
        c(11, true);
        return;
      }
      c(11, false);
    }
  }
  
  private void t()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[12];
    ArrayList localArrayList = new ArrayList();
    ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getCoverFromDb(localArrayList, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo);
    if (localArrayList.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "updateCoverEntry infoList is empty.");
      }
      a(12, 2, localView, getString(2131720062), HardCodeUtil.a(2131715235), this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim());
      a(12, true);
    }
    else
    {
      Object localObject1 = (AvatarInfo)localArrayList.get(0);
      Object localObject2 = (ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class);
      String str = ((ITroopAvatarUtilApi)localObject2).getArtWork(((ITroopAvatarUtilApi)localObject2).getAvatarAddress(((AvatarInfo)localObject1).c, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, 1));
      int n = ScreenUtil.dip2px(30.0F);
      try
      {
        localObject1 = ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getURL4TroopPhoto(str);
        if (localObject1 != null)
        {
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = URLDrawableHelperConstants.a;
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = n;
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = n;
          localObject2 = URLDrawable.getDrawable((URL)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
          try
          {
            ((URLDrawable)localObject2).setTag(new int[] { n, n, 0 });
            ((URLDrawable)localObject2).setDecodeHandler(jdField_a_of_type_ComTencentImageDownloadParams$DecodeHandler);
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
        ((URLDrawable)localObject1).setBounds(0, 0, n, n);
        localSpannableString.setSpan(new ImageSpan((Drawable)localObject1, 0), 0, localSpannableString.length(), 17);
        localObject1 = localSpannableString;
      }
      else
      {
        localObject1 = null;
      }
      a(12, 2, localView, getString(2131720062), (CharSequence)localObject1, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim());
      a(12, false);
    }
    localView.setTag(2131720062, Integer.valueOf(localArrayList.size()));
  }
  
  private void u()
  {
    if ((this.jdField_g_of_type_Boolean) && (this.jdField_b_of_type_Int == 0))
    {
      Object localObject1 = DialogUtil.a(this, 230);
      ((QQCustomDialog)localObject1).setTitle(null);
      long l2 = this.jdField_a_of_type_Long;
      long l1 = l2;
      if (l2 <= 0L) {
        l1 = 5L;
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(l1);
      ((StringBuilder)localObject2).append("");
      ((QQCustomDialog)localObject1).setMessage(getString(2131693359, new Object[] { ((StringBuilder)localObject2).toString() }));
      ((QQCustomDialog)localObject1).setNegativeButton(getString(2131693339), new TroopInfoActivity.9(this));
      ((QQCustomDialog)localObject1).setPositiveButton(getString(2131693286), new TroopInfoActivity.10(this));
      ((QQCustomDialog)localObject1).show();
      localObject2 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
      String str = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.bOwner) {
        localObject1 = "0";
      } else {
        localObject1 = "1";
      }
      ReportController.b((AppRuntime)localObject2, "P_CliOper", "Grp_manage", "", "manage_grp", "sub_exp", 0, 0, str, (String)localObject1, "", "");
      return;
    }
    k();
  }
  
  private void v()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.cGroupOption != 3)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.remark))
      {
        startActivity(((ITroopCardApi)QRoute.api(ITroopCardApi.class)).addFriendLogicActivity_startJoinTroop(this, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopName, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.cGroupOption, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.getStatOption(), this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mStrJoinQuestion, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mStrJoinAnswer, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.remark, setLastActivityName(), null));
        return;
      }
      startActivityForResult(((ITroopCardApi)QRoute.api(ITroopCardApi.class)).addFriendLogicActivity_startJoinTroop(this, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopName, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.cGroupOption, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.getStatOption(), this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mStrJoinQuestion, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mStrJoinAnswer, null, setLastActivityName(), null), 8);
      return;
    }
    a(2131719932, 1);
  }
  
  private void w()
  {
    Object localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    int n;
    if (String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopowneruin).equals(localObject))
    {
      n = 0;
    }
    else
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopowneruin))
      {
        if (((IFriendDataService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IFriendDataService.class, "")).isFriend(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopowneruin))
        {
          n = 20;
          break label98;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isMember)
        {
          n = 21;
          break label98;
        }
      }
      n = 19;
    }
    label98:
    localObject = new AllInOne(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopowneruin, n);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopowneruin)) {
      ((AllInOne)localObject).nickname = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopOwnerNick;
    }
    ((AllInOne)localObject).troopCode = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin;
    ((AllInOne)localObject).troopUin = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopCode;
    if (n == 21) {
      ((AllInOne)localObject).subSourceId = 11;
    }
    ProfileUtils.openProfileCard(getActivity(), (AllInOne)localObject);
  }
  
  private void x()
  {
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this, "/base/browser");
    Intent localIntent = new Intent();
    localIntent.putExtra("url", String.format("https://admin.qun.qq.com/mcreatev4/classinfo?gc=%1$s&from=%2$s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, IHWTroopUtilsApi.HOMEWORK_SCHOOL_EDIT_FROM }));
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    localActivityURIRequest.extra().putAll(localIntent.getExtras());
    localActivityURIRequest.setRequestCode(19);
    QRoute.startUri(localActivityURIRequest, null);
  }
  
  private void y()
  {
    ThreadManager.post(new TroopInfoActivity.27(this), 5, null, true);
  }
  
  private void z()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "updateTroopOwnerName");
    }
    ThreadManager.post(new TroopInfoActivity.28(this), 5, null, true);
  }
  
  protected String a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopName)) {
      return getString(2131697533);
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mRichFingerMemo)) {
      return getString(2131697532);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopName.length() < 2) {
      return getString(2131697519);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mRichFingerMemo.length() < 15) {
      return getString(2131697518);
    }
    TroopInfo localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
    if ((localTroopInfo != null) && (((localTroopInfo.dwGroupFlag & 0x400) == 0L) || (0L != (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.dwGroupFlagExt & 0x20000)))) {
      return getString(2131697515);
    }
    return "";
  }
  
  protected void a()
  {
    long l1 = System.currentTimeMillis();
    View localView = View.inflate(this, 2131561539, null);
    Object localObject1 = (ListView)localView.findViewById(2131364131);
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(HardCodeUtil.a(2131715229));
    ((ArrayList)localObject2).add(HardCodeUtil.a(2131715228));
    ((ListView)localObject1).setAdapter(new ArrayAdapter(this, 17367046, (List)localObject2));
    ((ListView)localObject1).setVisibility(4);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localView.findViewById(2131365037));
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[14];
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this);
    localObject1 = new AbsListView.LayoutParams(-1, -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setFocusable(false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(false);
    a(this.jdField_a_of_type_ComTencentWidgetXListView);
    localObject1 = new XSimpleListAdapter(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter((ListAdapter)localObject1);
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundResource(2130838739);
    this.jdField_a_of_type_ComTencentWidgetXListView.setFocusable(false);
    this.jdField_a_of_type_ComTencentWidgetXListView.setClickable(false);
    this.jdField_a_of_type_Boolean = ((ITroopInfoService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopInfoService.class, "")).isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("mIsQidianPrivateTroop : ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject1).append(", troopUin = ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
      QLog.d("Q.troopinfo", 2, ((StringBuilder)localObject1).toString());
    }
    super.setContentView(localView);
    localObject2 = getIntent().getExtras().getString("troop_info_title");
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      if (this.j) {
        localObject1 = getString(2131720030);
      } else {
        localObject1 = getString(2131719915);
      }
    }
    setTitle((CharSequence)localObject1);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwGroupFlagExt & 0x800) != 0L)
    {
      localObject1 = View.inflate(this, 2131561545, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[7] = localObject1;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      a(7, 0, (View)localObject1, getString(2131693277), this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopAuthenticateInfo, false);
      localObject1 = View.inflate(this, 2131561565, null);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    }
    if (this.j)
    {
      localObject1 = a(HardCodeUtil.a(2131719978));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    }
    localObject1 = View.inflate(this, 2131561545, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[10] = localObject1;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    ((View)localObject1).setTag(Integer.valueOf(10));
    a(10, 2, (View)localObject1, getString(2131691792), "", true);
    c();
    a((View)localObject1);
    localObject1 = View.inflate(this, 2131561545, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[11] = localObject1;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    s();
    ((View)localObject1).setOnClickListener(this);
    if (this.j)
    {
      localObject1 = a(HardCodeUtil.a(2131719802));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    }
    localObject1 = View.inflate(this, 2131561545, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[12] = localObject1;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    t();
    ((View)localObject1).setOnClickListener(this);
    localObject1 = View.inflate(this, 2131561545, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[5] = localObject1;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    a(5, 2, (View)localObject1, getString(2131720063), this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLocation, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim());
    m();
    localObject1 = View.inflate(this, 2131561545, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[4] = localObject1;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    a(4, 2, (View)localObject1, getString(2131719803), this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopClass, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim());
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isHomeworkTroop())
    {
      localObject1 = View.inflate(this, 2131561545, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[13] = localObject1;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      ((View)localObject1).setTag(Integer.valueOf(13));
      a(13, 2, (View)localObject1, getString(2131719804), "", true);
      b();
    }
    localObject1 = View.inflate(this, 2131561544, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[8] = localObject1;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    a(8, 3, (View)localObject1, getString(2131719805), null, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim(), 1);
    if (this.j) {
      ((View)localObject1).setBackgroundResource(2130839443);
    }
    ThreadManager.post(new TroopInfoActivity.2(this), 8, null, true);
    if (!this.j)
    {
      localObject1 = View.inflate(this, 2131561565, null);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    }
    localObject2 = View.inflate(this, 2131561552, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[6] = localObject2;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mRichFingerMemo)) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mRichFingerMemo;
    } else {
      localObject1 = getResources().getString(2131696163);
    }
    a(6, 3, (View)localObject2, getString(2131693389), (CharSequence)localObject1, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim());
    if (!this.j)
    {
      localObject1 = new LinearLayout.LayoutParams(-1, (int)(this.mDensity * 60.0F));
      localObject2 = View.inflate(this, 2131561565, null);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    }
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131363900);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131363819));
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isMember)
    {
      if (this.j) {
        b(18);
      } else {
        b(14);
      }
    }
    else {
      b(15);
    }
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    if (this.j)
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
  
  public void a(int paramInt)
  {
    String str = getString(paramInt);
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setTitle(str);
    localQQCustomDialog.setMessage(null);
    localQQCustomDialog.setPositiveButton(getString(2131693346), new TroopInfoActivity.11(this, localQQCustomDialog));
    localQQCustomDialog.setPositiveButtonContentDescription(getString(2131693346));
    localQQCustomDialog.setNegativeButton(getString(2131693286), new DialogUtil.DialogOnClickAdapter());
    localQQCustomDialog.setNegativeButtonContentDescription(getString(2131693286));
    localQQCustomDialog.show();
  }
  
  void a(int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).b(getTitleBarHeight());
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
            paramView.setBackgroundResource(2130839440);
          }
        }
        else {
          paramView.setBackgroundResource(2130839443);
        }
      }
      else {
        paramView.setBackgroundResource(2130839449);
      }
    }
    else {
      paramView.setBackgroundResource(2130839433);
    }
    TextView localTextView1 = (TextView)paramView.findViewById(2131378784);
    TextView localTextView2 = (TextView)paramView.findViewById(2131368773);
    View localView = paramView.findViewById(2131362975);
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
    Object localObject = (TextView)paramView.findViewById(2131378784);
    paramArrayOfString = paramString;
    if (paramString == null) {
      paramArrayOfString = "";
    }
    ((TextView)localObject).setText(paramArrayOfString);
    paramString = paramView.findViewById(2131362975);
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
          paramView.setBackgroundResource(2130839440);
          return;
        }
        paramView.setBackgroundResource(2130839443);
        return;
      }
      paramView.setBackgroundResource(2130839449);
      return;
    }
    paramView.setBackgroundResource(2130839433);
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
      localObject = this.jdField_a_of_type_ArrayOfAndroidViewView;
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
      TextView localTextView = (TextView)((View)localObject).findViewById(2131368773);
      View localView = ((View)localObject).findViewById(2131362975);
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
        a(paramInt, TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mRichFingerMemo));
      }
      else
      {
        String str = paramString;
        if (paramInt == 4) {
          if (TextUtils.isEmpty(paramString))
          {
            str = HardCodeUtil.a(2131715237);
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
      localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView;
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
      LinearLayout localLinearLayout = (LinearLayout)((View)localObject1).findViewById(2131364752);
      localLinearLayout.removeAllViews();
      Object localObject2 = (LinearLayout)((View)localObject1).findViewById(2131378467);
      Object localObject3 = (TextView)((View)localObject1).findViewById(2131368773);
      if ((paramArrayList != null) && (paramArrayList.size() != 0))
      {
        a(paramInt1, false);
        ((LinearLayout)localObject2).setVisibility(8);
        localLinearLayout.setVisibility(0);
        int n = 0;
        while ((n < paramArrayList.size()) && (n < 3))
        {
          if (!TextUtils.isEmpty((CharSequence)paramArrayList.get(n)))
          {
            localObject2 = new TextView(this);
            ((TextView)localObject2).setId(2131373890);
            int i1 = 2130843982;
            if (paramInt2 == 1) {
              i1 = 2130843984;
            }
            localObject3 = getResources().getDrawable(i1);
            ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).setNightModeFilterForDrawable((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null), (Drawable)localObject3);
            ((TextView)localObject2).setBackgroundDrawable((Drawable)localObject3);
            ((TextView)localObject2).setTextSize(2, 15.0F);
            if (paramBoolean2) {
              ((TextView)localObject2).setMaxWidth(Utils.a(77.0F, getResources()));
            }
            ((TextView)localObject2).setSingleLine();
            ((TextView)localObject2).setTextColor(getResources().getColor(2131167222));
            ((TextView)localObject2).setPadding(Utils.a(6.0F, getResources()), Utils.a(2.0F, getResources()), Utils.a(8.0F, getResources()), Utils.a(2.0F, getResources()));
            ((TextView)localObject2).setGravity(17);
            ((TextView)localObject2).setText((CharSequence)paramArrayList.get(n));
            ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
            localObject3 = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams)localObject3).leftMargin = Utils.a(5.0F, getResources());
            localLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
          }
          n += 1;
        }
        paramArrayList = ((View)localObject1).findViewById(2131362975);
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
      ((TextView)localObject3).setText(HardCodeUtil.a(2131715238));
      a(paramInt1, true);
    }
  }
  
  protected void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    TextView localTextView = (TextView)paramView.findViewById(2131378784);
    paramView = (LinearLayout)paramView.findViewById(2131365169);
    if ((localTextView != null) && (paramView != null) && (!TextUtils.isEmpty(localTextView.getText())))
    {
      int n = (int)localTextView.getPaint().measureText(localTextView.getText().toString());
      paramView = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      if (this.j)
      {
        paramView.leftMargin = (n + Utils.a(100.0F, getResources()));
        return;
      }
      paramView.leftMargin = (n + Utils.a(90.0F, getResources()));
    }
  }
  
  public void a(GCBindGroup.GCBindGroupSsoServerRsp paramGCBindGroupSsoServerRsp)
  {
    int n = paramGCBindGroupSsoServerRsp.ret.get();
    Object localObject;
    if (n == -3000005)
    {
      this.jdField_f_of_type_Int = 2;
    }
    else if (n == 0)
    {
      localObject = paramGCBindGroupSsoServerRsp.bind_info.app_name.get();
      paramGCBindGroupSsoServerRsp = (GCBindGroup.GCBindGroupSsoServerRsp)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label59;
      }
      this.jdField_f_of_type_Int = 1;
      paramGCBindGroupSsoServerRsp = (GCBindGroup.GCBindGroupSsoServerRsp)localObject;
      break label59;
    }
    paramGCBindGroupSsoServerRsp = null;
    label59:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetGameBindStatus ret=");
      ((StringBuilder)localObject).append(n);
      ((StringBuilder)localObject).append(", status=");
      ((StringBuilder)localObject).append(this.jdField_f_of_type_Int);
      ((StringBuilder)localObject).append(", name=");
      ((StringBuilder)localObject).append(paramGCBindGroupSsoServerRsp);
      QLog.d("Q.troopinfo", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(String paramString)
  {
    QQToast.a(this, paramString, 0).a();
  }
  
  protected void a(String paramString1, String paramString2, String paramString3)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "P_CliOper", "Grp_set", "", paramString1, paramString2, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, paramString3, "", "");
  }
  
  protected void a(oidb_0x88d.GroupInfo paramGroupInfo)
  {
    if (paramGroupInfo != null)
    {
      if (paramGroupInfo.string_group_name.has()) {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopName = paramGroupInfo.string_group_name.get().toStringUtf8();
      }
      Object localObject1;
      if (paramGroupInfo.group_geo_info.has())
      {
        localObject1 = (oidb_0x88d.GroupGeoInfo)paramGroupInfo.group_geo_info.get();
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLat = ((int)((oidb_0x88d.GroupGeoInfo)localObject1).int64_latitude.get());
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLon = ((int)((oidb_0x88d.GroupGeoInfo)localObject1).int64_longitude.get());
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLocation = ((oidb_0x88d.GroupGeoInfo)localObject1).bytes_geocontent.get().toStringUtf8();
      }
      if (paramGroupInfo.uint32_group_class_ext.has()) {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwGroupClassExt = paramGroupInfo.uint32_group_class_ext.get();
      }
      if ((paramGroupInfo.rpt_tag_record.has()) && (paramGroupInfo.rpt_tag_record.size() > 0))
      {
        Object localObject2 = paramGroupInfo.rpt_tag_record.get();
        localObject1 = new ArrayList();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((List)localObject1).add(((oidb_0x88d.TagRecord)((Iterator)localObject2).next()).bytes_tag_value.get().toStringUtf8());
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopTags = ((List)localObject1);
      }
      if (paramGroupInfo.string_group_finger_memo.has()) {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mRichFingerMemo = paramGroupInfo.string_group_rich_finger_memo.get().toStringUtf8();
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
      y();
      c();
      b();
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
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin = ((Bundle)localObject).getString("troop_uin");
      if (Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin) > 0L)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.pa = ((Bundle)localObject).getInt("troop_info_from");
        this.jdField_g_of_type_Int = ((Bundle)localObject).getInt("troop_info_report_from", -1);
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.nStatOption = ((Bundle)localObject).getInt("troop_info_from_ex");
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.remark = ((Bundle)localObject).getString("param_return_addr");
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isMember = ((Bundle)localObject).getBoolean("troop_info_is_member");
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopface = ((Bundle)localObject).getShort("troop_info_faceid");
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopName = ((Bundle)localObject).getString("troop_info_name");
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.newTroopName = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopName;
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopowneruin = ((Bundle)localObject).getString("troop_info_owner");
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwGroupClassExt = ((Bundle)localObject).getLong("troop_info_classext");
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLocation = ((Bundle)localObject).getString("troop_info_loca");
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLocation;
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLat = ((Bundle)localObject).getInt("troop_info_lat", 0);
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLon = ((Bundle)localObject).getInt("troop_info_lon", 0);
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.cityId = ((Bundle)localObject).getInt("troop_info_cityid", 0);
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.currentTroopLocationStruct = a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLat, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLon, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLocation);
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mRichFingerMemo = ((Bundle)localObject).getString("troop_info_fingermemo");
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.location = ((Bundle)localObject).getString("troop_info_school_location");
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.school = ((Bundle)localObject).getString("troop_info_school_schoolid");
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.grade = ((Bundle)localObject).getInt("troop_info_school_grade");
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.cGroupOption = ((short)((Bundle)localObject).getByte("troop_info_opt"));
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mStrJoinQuestion = ((ITroopSystemMsgUtilApi)QRoute.api(ITroopSystemMsgUtilApi.class)).getTroopQuestionFromSP(this, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mStrJoinAnswer = ((ITroopSystemMsgUtilApi)QRoute.api(ITroopSystemMsgUtilApi.class)).getTroopAnswerFromSP(this, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwGroupFlagExt = ((Bundle)localObject).getLong("TROOP_INFO_FLAG_EXT");
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopTags = TroopInfo.getTags(((Bundle)localObject).getString("TROOP_INFO_TAGS_EXT"));
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopTypeExt = ((Bundle)localObject).getInt("troop_type_ex");
        this.jdField_a_of_type_Int = ((Bundle)localObject).getInt("troop_type_ex");
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.wMemberNum = ((Bundle)localObject).getInt("TROOP_INFO_MEMBER_NUM");
        this.jdField_b_of_type_Int = ((Bundle)localObject).getInt("troop_auth_submit_time");
        this.jdField_h_of_type_Int = ((Bundle)localObject).getInt("PARAM_EXIT_ANIMATION", 0);
        this.j = ((Bundle)localObject).getBoolean(TroopInfoActivityConstant.jdField_a_of_type_JavaLangString, false);
        localObject = (ITroopInfoService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopInfoService.class, "");
        if (localObject != null)
        {
          localObject = ((ITroopInfoService)localObject).findTroopInfo(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
          if (localObject != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = ((TroopInfo)localObject);
            this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isMember = true;
            this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.updateForTroopInfo((TroopInfo)localObject, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
            bool1 = true;
            break label645;
          }
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("can't find troop info of :");
            ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
            QLog.e("Q.troopinfo", 2, ((StringBuilder)localObject).toString());
          }
        }
        bool1 = false;
        try
        {
          if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.bOwner)
          {
            this.jdField_b_of_type_JavaLangString = "0";
            bool2 = bool1;
          }
          else
          {
            bool2 = bool1;
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.bAdmin)
            {
              this.jdField_b_of_type_JavaLangString = "1";
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
      QLog.d("Q.troopinfo", 2, String.format("checkParams troopUin: %s, classExt: %s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwGroupClassExt) }));
    }
    return bool2;
  }
  
  boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) != 0;
  }
  
  protected void b()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[13];
    if (localView != null)
    {
      String str;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.location))
      {
        str = HardCodeUtil.a(2131707375);
        ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X800B281", "0X800B281", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, "1", "", "");
      }
      else
      {
        str = a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.grade);
        ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X800B281", "0X800B281", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, "2", "", "");
      }
      ((TextView)localView.findViewById(2131368773)).setText(str);
      if (str.equals(HardCodeUtil.a(2131707375))) {
        a(13, true);
      } else {
        a(13, false);
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, String.format("updateTroopClassInfoEntry %s", new Object[] { str }));
      }
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
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          return;
        }
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131720008);
        this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(18));
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        localLayoutParams.addRule(12, 0);
        localLayoutParams.setMargins(0, 76, 0, 0);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        if (this.jdField_a_of_type_AndroidViewView.getParent() != null) {
          ((ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent()).removeView(this.jdField_a_of_type_AndroidViewView);
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidViewView);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131693512);
      this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(15));
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setEnabled(true);
    this.rightViewText.setText(2131693365);
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
    localBundle.putString("troop_uin", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    localBundle.putLong("troop_flag_ext", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwGroupFlagExt);
    localBundle.putInt("troop_auth_submit_time", this.jdField_b_of_type_Int);
    localBundle.putBoolean("troop_info_is_member", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isMember);
    localBundle.putBoolean("isUseClassAvatar", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isUseClassAvatar);
    paramBundle.putExtras(localBundle);
    paramBundle.addFlags(603979776);
    int n;
    if ((localBundle.getBoolean("IS_COVER") ^ true)) {
      n = 260;
    } else {
      n = 258;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, String.format("gotoBigPic code=%d bundle=%s", new Object[] { Integer.valueOf(n), localBundle }));
    }
    startActivityForResult(paramBundle, n);
  }
  
  protected void b(String paramString)
  {
    l();
    QQProgressDialog localQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    localQQProgressDialog.a(paramString);
    localQQProgressDialog.setCancelable(false);
    localQQProgressDialog.setOnDismissListener(new TroopInfoActivity.17(this));
    this.jdField_a_of_type_AndroidAppDialog = localQQProgressDialog;
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  protected void c()
  {
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[10];
    if (localObject != null)
    {
      String str;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.hasSetNewTroopName) {
        str = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.newTroopName;
      } else {
        str = HardCodeUtil.a(2131701974);
      }
      localObject = (TextView)((View)localObject).findViewById(2131368773);
      if (localObject != null) {
        ((TextView)localObject).setText(str);
      }
      if (str.equals(HardCodeUtil.a(2131701974))) {
        a(10, true);
      } else {
        a(10, false);
      }
      if (this.j) {
        c(10, true);
      } else {
        c(10, false);
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, String.format("updateTroopNameEntry %s", new Object[] { str }));
      }
    }
  }
  
  protected void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isMember))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.troopinfo", 4, "updateTroopInfoToDB");
      }
      ThreadManager.post(new TroopInfoActivity.6(this), 5, null, false);
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
                        this.jdField_g_of_type_Boolean = true;
                        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.grade = ((JSONObject)localObject1).optInt("grade");
                        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.location = ((JSONObject)localObject3).toString();
                        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.school = ((JSONObject)localObject1).getString("school");
                      }
                      catch (JSONException localJSONException1)
                      {
                        localJSONException1.printStackTrace();
                      }
                      b();
                      break label1321;
                    }
                    if ((paramInt2 != -1) || (paramIntent == null)) {
                      break label1321;
                    }
                    if (!NetworkUtil.isNetworkAvailable(this))
                    {
                      QQToast.a(this, 1, 2131694425, 0).b(getTitleBarHeight());
                      return;
                    }
                    localObject2 = paramIntent.getStringExtra("result");
                    if (TextUtils.isEmpty((CharSequence)localObject2)) {
                      break label1321;
                    }
                    localObject3 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
                    if ((localObject3 == null) || (((String)localObject2).equals(((TroopInfo)localObject3).troopname))) {
                      break label1321;
                    }
                    localObject3 = (ITroopModifyHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopModifyHandlerName());
                    boolean bool;
                    if ((!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim()) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.allowMemberModifTroopName == 1)) {
                      bool = true;
                    } else {
                      bool = false;
                    }
                    ((ITroopModifyHandler)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, (String)localObject2, bool);
                    localObject3 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
                    ((TroopInfo)localObject3).oldTroopName = ((TroopInfo)localObject3).troopname;
                    localObject3 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
                    ((TroopInfoData)localObject3).troopName = ((String)localObject2);
                    ((TroopInfoData)localObject3).newTroopName = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getTroopDisplayName();
                    c();
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
          int n;
          ((List)localObject2).add(((JSONArray)localObject3).getString(paramInt2));
          paramInt2 += 1;
        }
        for (;;)
        {
          this.jdField_g_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopTags = ((List)localObject2);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
          break label1321;
          if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.pa == 2) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.pa == 6) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.pa == 15) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.pa == 10) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.pa == 11) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.pa == 19) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.pa == 101) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.pa == 102) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.pa == 103) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.pa == 104) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.pa == 105) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.pa == 106) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.pa == 112) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.pa == 113))
          {
            setResult(-1);
            finish();
            break label1321;
            if ((paramIntent != null) && (paramIntent.getExtras() != null))
            {
              localObject2 = paramIntent.getExtras();
              this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLocation = ((Bundle)localObject2).getString("location");
              this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLat = ((Bundle)localObject2).getInt("lat", 0);
              this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLon = ((Bundle)localObject2).getInt("lon", 0);
              m();
              break label1321;
              if (this.l)
              {
                localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopAvatarController;
                if (localObject2 != null) {
                  ((TroopAvatarController)localObject2).d();
                }
              }
              else
              {
                localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController;
                if (localObject2 != null)
                {
                  ((TroopPhotoController)localObject2).d();
                  break label1321;
                  if ((paramIntent != null) && (paramIntent.getExtras() != null))
                  {
                    localObject2 = paramIntent.getExtras();
                    if (!Utils.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLocation, ((Bundle)localObject2).getString("location"))) {
                      this.jdField_g_of_type_Boolean = true;
                    }
                    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.currentTroopLocationStruct = ((Bundle)localObject2).getString("locationOriginal");
                    if (QLog.isColorLevel())
                    {
                      localObject3 = new StringBuilder();
                      ((StringBuilder)localObject3).append("REQUEST_FOR_EDIT_TROOP_LOCATION_WITHOUT_SAVE==>originalLocation:");
                      ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.currentTroopLocationStruct);
                      QLog.e("Q.troopinfo.troop.location_info", 2, ((StringBuilder)localObject3).toString());
                    }
                    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.currentTroopLocationStruct))
                    {
                      localObject3 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.currentTroopLocationStruct.split("\\|");
                      if (localObject3.length < 5) {}
                    }
                  }
                }
              }
            }
          }
          try
          {
            this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mPoiId = Long.parseLong(localObject3[4]);
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
            localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.currentTroopLocationStruct);
            QLog.e("Q.troopinfo", 2, localStringBuilder.toString());
            break label1124;
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("no poi id, location:");
              ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.currentTroopLocationStruct);
              QLog.w("Q.troopinfo", 2, ((StringBuilder)localObject3).toString());
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLocation = ((Bundle)localObject2).getString("location");
          m();
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
          if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwGroupClassExt != l1) && (l1 != 9223372036854775807L))
          {
            this.jdField_g_of_type_Boolean = true;
            this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwGroupClassExt = l1;
            y();
            break label1321;
            str = paramIntent.getStringExtra("result");
            if (!TextUtils.equals(str, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mRichFingerMemo))
            {
              this.jdField_g_of_type_Boolean = true;
              localObject3 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
              ((TroopInfoData)localObject3).mRichFingerMemo = str;
              if (!TextUtils.isEmpty(((TroopInfoData)localObject3).mRichFingerMemo)) {
                str = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mRichFingerMemo;
              } else {
                str = getResources().getString(2131696163);
              }
              a(6, str, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim());
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
            t();
            return;
          }
          if (paramInt1 == 260) {
            s();
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
    n = ((JSONArray)localObject3).length();
    if (paramInt2 >= n) {}
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if ((getAppRuntime() instanceof AppInterface)) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)getAppRuntime());
    }
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      return false;
    }
    long l1 = 0L;
    if (QLog.isColorLevel()) {
      l1 = System.currentTimeMillis();
    }
    this.jdField_h_of_type_Boolean = getIntent().getExtras().getBoolean("returnMsgList", false);
    if (!a())
    {
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("onCreate, illegal param, troopuin = ");
        paramBundle.append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
        QLog.i("Q.troopinfo", 2, paramBundle.toString());
      }
      finish();
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isGameTroop()) {
      q();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
    a();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopmanagerApiTroopManagerBizObserver);
    paramBundle = (ITroopManagerBizHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopManagerBizHandlerName());
    if (paramBundle != null) {
      paramBundle.b(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, "");
    }
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle, "com.tencent.msg.permission.pushnotify", null);
    this.i = true;
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onCreate(), time = ");
      paramBundle.append(System.currentTimeMillis() - l1);
      QLog.i("Q.troopinfo", 2, paramBundle.toString());
    }
    ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).bnrReport(this.jdField_a_of_type_ComTencentCommonAppAppInterface, 78);
    AppInterface localAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    String str = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin;
    int n = this.jdField_g_of_type_Int;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.bOwner) {
      paramBundle = "0";
    } else {
      paramBundle = "1";
    }
    ReportController.b(localAppInterface, "P_CliOper", "Grp_create", "", "edit_data", "edit", 0, 0, str, String.valueOf(n), paramBundle, "");
    return true;
  }
  
  public void doOnDestroy()
  {
    this.jdField_d_of_type_Boolean = true;
    long l1;
    if (QLog.isColorLevel()) {
      l1 = System.currentTimeMillis();
    } else {
      l1 = 0L;
    }
    GroupCatalogTool.a(getApplicationContext()).a();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopObserverTroopAuditObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingApiTroopSettingObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopModifyObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopObserverTempFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopmanagerApiTroopManagerBizObserver);
    if (this.i) {}
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.i = false;
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
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopAvatarManger;
    if (localObject != null) {
      ((TroopAvatarManger)localObject).b(this.jdField_a_of_type_JavaUtilObserver);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController;
    if (localObject != null) {
      ((TroopPhotoController)localObject).f();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopAvatarController;
    if (localObject != null) {
      ((TroopAvatarController)localObject).f();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
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
        QLog.i("Q.troopinfo", 2, String.format("doOnNewIntent bAvatarEdit=%b clip=%s path=%s", new Object[] { Boolean.valueOf(this.l), paramIntent, str }));
      }
      Object localObject;
      if (this.l)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopAvatarController;
        if (localObject != null) {
          ((TroopAvatarController)localObject).a(str, paramIntent);
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController;
        if (localObject != null) {
          ((TroopPhotoController)localObject).a(str, paramIntent);
        }
      }
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.jdField_b_of_type_Boolean)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
  }
  
  protected void e()
  {
    if (((this.jdField_c_of_type_Long != 0L) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.tribeId != 0L)) && (this.jdField_b_of_type_Int == 0))
    {
      Object localObject;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.modifyCount <= 0)
      {
        localObject = DialogUtil.a(this, 230);
        ((QQCustomDialog)localObject).setTitle(null);
        ((QQCustomDialog)localObject).setMessage(getString(2131697514));
        ((QQCustomDialog)localObject).setPositiveButton(getString(2131693339), new DialogUtil.DialogOnClickAdapter());
        ((QQCustomDialog)localObject).setPositiveButtonContentDescription(getString(2131693339));
        ((QQCustomDialog)localObject).show();
        return;
      }
      if (this.jdField_g_of_type_Boolean)
      {
        localObject = a();
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = DialogUtil.a(this, 230);
          ((QQCustomDialog)localObject).setTitle(null);
          ((QQCustomDialog)localObject).setMessage(getString(2131697513, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.modifyCount) }));
          ((QQCustomDialog)localObject).setPositiveButton(getString(2131693339), new TroopInfoActivity.7(this));
          ((QQCustomDialog)localObject).setNegativeButton(getString(2131693286), new TroopInfoActivity.8(this));
          ((QQCustomDialog)localObject).show();
          return;
        }
        a((String)localObject);
        return;
      }
      k();
      return;
    }
    k();
  }
  
  public void f()
  {
    if (!this.jdField_g_of_type_Boolean)
    {
      this.k = true;
      finish();
      return;
    }
    a(2131693347);
  }
  
  public void finish()
  {
    l();
    g();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
    if ((localObject != null) && (((TroopInfoData)localObject).pa != 28)) {
      setResult(-1, getIntent());
    }
    if (this.jdField_h_of_type_Boolean) {
      n();
    }
    if (this.j)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
      if ((localObject != null) && (((TroopInfoData)localObject).troopUin != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isNewTroop) && (this.m))
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("openSearchTroopWay", true);
        setResult(-1, (Intent)localObject);
      }
    }
    super.finish();
    int n = this.jdField_h_of_type_Int;
    if (n != 1)
    {
      if (n != 2) {
        return;
      }
      overridePendingTransition(0, 2130772025);
      return;
    }
    overridePendingTransition(0, 2130771992);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData == null) {
      return;
    }
    Intent localIntent = getIntent();
    localIntent.putExtra("location", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLocation);
    localIntent.putExtra("lat", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLat);
    localIntent.putExtra("lon", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLon);
    localIntent.putExtra("name", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopName);
    localIntent.putExtra("class", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwGroupClassExt);
    localIntent.putExtra("intro", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mRichFingerMemo);
    localIntent.putExtra("location", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.location);
    localIntent.putExtra("grade", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.grade);
    localIntent.putExtra("school", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.school);
  }
  
  protected void h()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init(), isInitialized = ");
      localStringBuilder.append(this.jdField_b_of_type_Boolean);
      QLog.i("Q.troopinfo", 2, localStringBuilder.toString());
    }
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopObserverTroopAuditObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingApiTroopSettingObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopModifyObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopObserverTempFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopmanagerApiTroopManagerBizObserver);
    ThreadManager.post(new TroopInfoActivity.12(this), 5, null, true);
  }
  
  protected void i()
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopTags;
    Intent localIntent = new Intent(this, ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).getTroopTagViewActivityClass());
    localIntent.putExtra("troopuin", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    localIntent.putExtra("isAdmin", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim());
    Object localObject1 = Long.toString(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwGroupClassExt);
    localObject1 = GroupCatalogTool.a(getApplicationContext()).a(this, (String)localObject1);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mTroopClassExtText)) {}
    for (localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mTroopClassExtText;; localObject1 = ((GroupCatalogBean)localObject1).jdField_a_of_type_JavaLangString)
    {
      n = 1;
      break label158;
      if ((localObject1 == null) || (TextUtils.isEmpty(((GroupCatalogBean)localObject1).jdField_a_of_type_JavaLangString)) || (((GroupCatalogBean)localObject1).jdField_a_of_type_JavaLangString.equals(HardCodeUtil.a(2131715239)))) {
        break;
      }
    }
    localObject1 = "";
    int n = 0;
    label158:
    if (n != 0) {
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
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    localIntent.putExtra("modifyToSrv", 0);
    startActivityForResult(localIntent, 9);
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim())
    {
      AppInterface localAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
      String str2 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin;
      String str1;
      if (this.j) {
        str1 = "2";
      } else {
        str1 = "1";
      }
      ReportController.b(localAppInterface, "P_CliOper", "Grp_set", "", "Grp_data", "add_place", 0, 0, str2, str1, "", "");
      ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).startModifyLocationActivityForResultEx(this, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLocation, 16);
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.pa == 28) {
      setResult(-1);
    }
    if (!this.jdField_g_of_type_Boolean)
    {
      this.m = true;
      finish();
      return;
    }
    Object localObject3 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin;
    Object localObject2;
    if (this.j) {
      localObject2 = "2";
    } else {
      localObject2 = "1";
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.bOwner) {
      localObject1 = "0";
    } else if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.bAdmin) {
      localObject1 = "1";
    } else {
      localObject1 = "2";
    }
    ReportController.b((AppRuntime)localObject3, "P_CliOper", "Grp_create", "", "edit_data", "modify", 0, 0, (String)localObject4, (String)localObject2, (String)localObject1, "");
    ITroopModifyHandler localITroopModifyHandler = (ITroopModifyHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopModifyHandlerName());
    if (localITroopModifyHandler == null)
    {
      this.m = true;
      finish();
      return;
    }
    try
    {
      l4 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopTypeExt == -1)
      {
        this.m = true;
        finish();
        return;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.currentTroopLocationStruct;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      long l4;
      int n;
      double d1;
      int i1;
      long l1;
      long l3;
      long l2;
      label312:
      int i2;
      int i3;
      break label1298;
    }
    try
    {
      localObject1 = ((String)localObject1).split("\\|");
      n = Integer.valueOf(localObject1[0]).intValue();
    }
    catch (NumberFormatException|ArrayIndexOutOfBoundsException localNumberFormatException2)
    {
      break label328;
    }
    try
    {
      d1 = Double.valueOf(localObject1[1]).doubleValue();
      i1 = n;
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
      n = i1;
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
    n = 0;
    label333:
    l1 = 0L;
    Object localObject1 = "";
    i1 = n;
    break label359;
    localObject1 = "";
    l2 = 0L;
    i1 = 0;
    l1 = 0L;
    label359:
    b(getString(2131693357));
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopTypeExt == 2) {
      i2 = 3;
    } else {
      i2 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopTypeExt;
    }
    if (i2 == -1) {
      return;
    }
    if (this.jdField_c_of_type_Long != 0L)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.tribeId != this.jdField_c_of_type_Long)
      {
        n = 3;
        break label468;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.tribeId == 0L)
      {
        n = 4;
        break label468;
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.tribeId != 0L)
    {
      n = 2;
      break label468;
    }
    n = 1;
    label468:
    i3 = this.jdField_a_of_type_Int;
    if (((i3 == 0) || (1 == i3)) && (i2 == 3)) {
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "P_CliOper", "Grp_create", "", "edit_data", "set_local", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, this.jdField_b_of_type_JavaLangString, "", "");
    }
    i3 = this.jdField_a_of_type_Int;
    if (((i3 == 2) || (i3 == 3) || (i3 == 4)) && ((i2 == 0) || (1 == i2))) {
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "P_CliOper", "Grp_create", "", "edit_data", "un_local", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, this.jdField_b_of_type_JavaLangString, "", "");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwGroupFlagExt & 0x800) != 0L)
    {
      l();
      if (this.jdField_e_of_type_Int > 0)
      {
        a(l4, i2, i1, l2, l1, (String)localObject1);
        localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(l4);
        ReportController.b((AppRuntime)localObject1, "dc00899", "Grp_certified", "", "data", "exp_edit_data", 4, 0, ((StringBuilder)localObject2).toString(), "", "", "");
        return;
      }
      if (this.jdField_d_of_type_Int > 0)
      {
        localObject1 = DialogUtil.a(this, 230);
        ((QQCustomDialog)localObject1).setTitle(null);
        ((QQCustomDialog)localObject1).setMessage(getString(2131693349, new Object[] { Integer.valueOf(this.jdField_d_of_type_Int) }));
        ((QQCustomDialog)localObject1).setPositiveButton(getString(2131693339), new DialogUtil.DialogOnClickAdapter());
        ((QQCustomDialog)localObject1).setPositiveButtonContentDescription(getString(2131693339));
        ((QQCustomDialog)localObject1).show();
      }
    }
    else
    {
      i3 = this.jdField_a_of_type_Int;
      if (((2 != i3) && (4 != i3)) || ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopTypeExt != 2) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopTypeExt != 4)))
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.tribeId == 0L) && (this.jdField_c_of_type_Long == 0L))
        {
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.location)) {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.location;
          } else {
            localObject2 = "";
          }
          if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.grade != 0) {
            n = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.grade;
          } else {
            n = 0;
          }
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.school)) {
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.school;
          } else {
            localObject3 = "";
          }
          localObject4 = GroupCatalogTool.a(MobileQQ.sMobileQQ).a(MobileQQ.sMobileQQ, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwGroupClassExt));
          if (localObject4 == null) {
            localObject4 = "";
          } else {
            localObject4 = ((GroupCatalogBean)localObject4).jdField_a_of_type_JavaLangString;
          }
          localITroopModifyHandler.a(l4, i2, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopName, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwGroupClassExt, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopTags, i1, l2, l1, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mPoiId, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mRichFingerMemo, (String)localObject2, n, (String)localObject3, (String)localObject4);
          return;
        }
        TroopInfoActivityHelper.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, l4, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopName, i1, l2, l1, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mPoiId, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwGroupClassExt, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopTags, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mRichFingerMemo, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.tribeId, n, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.tribeName, new TroopInfoActivity.14(this));
        return;
      }
      if ((0L == l2) && (0L == l1))
      {
        l1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLat;
        l2 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLon;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLocation;
        l3 = l2;
      }
      else
      {
        l3 = l1;
        l1 = l2;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "P_CliOper", "Grp_create", "", "edit_data", "local_sub", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, this.jdField_b_of_type_JavaLangString, "", "");
      TroopInfoActivityHelper.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, l4, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopName, i1, l1, l3, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mPoiId, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwGroupClassExt, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopTags, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mRichFingerMemo, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.tribeId, n, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.tribeName, new TroopInfoActivity.13(this));
    }
    return;
    label1298:
    finish();
  }
  
  void l()
  {
    Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
    if (localDialog != null)
    {
      if (localDialog.isShowing()) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
  }
  
  public void m()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
    if (localObject == null) {
      return;
    }
    if ((!TextUtils.isEmpty(((TroopInfoData)localObject).troopLocation)) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLat != 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLon != 0))
    {
      a(5, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLocation, true);
      a(5, false);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim())
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLocation))
      {
        a(5, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLocation, true);
        a(5, false);
        return;
      }
      a(5, HardCodeUtil.a(2131715230), true);
      a(5, true);
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLocation))
    {
      a(5, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLocation, false);
      a(5, false);
      return;
    }
    localObject = this.jdField_a_of_type_ArrayOfAndroidViewView;
    if (localObject[5] != null) {
      localObject[5].setVisibility(8);
    }
  }
  
  public void n()
  {
    ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).goToMsgList(this);
  }
  
  public void o()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131694668);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, localException.toString());
      }
    }
  }
  
  public void onBackPressed()
  {
    f();
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    if ((localObject1 instanceof Integer))
    {
      int i2 = ((Integer)localObject1).intValue();
      if (i2 != 2)
      {
        if (i2 != 15)
        {
          if (i2 != 18)
          {
            localObject1 = "2";
            Object localObject2;
            Object localObject3;
            String str;
            if (i2 != 4)
            {
              if (i2 != 5)
              {
                if (i2 != 6)
                {
                  int n;
                  switch (i2)
                  {
                  default: 
                    break;
                  case 13: 
                    ReportController.b(null, "dc00898", "", "", "0X800B282", "0X800B282", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, "", "", "");
                    if (!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim()) {
                      break;
                    }
                    x();
                    break;
                  case 12: 
                    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData == null) {
                      break;
                    }
                    localObject1 = paramView.getTag(2131720062);
                    if ((localObject1 != null) && ((localObject1 instanceof Integer))) {
                      n = ((Integer)localObject1).intValue();
                    } else {
                      n = 0;
                    }
                    if (n > 0)
                    {
                      c(12);
                    }
                    else
                    {
                      if (this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController == null)
                      {
                        this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController = new TroopPhotoController(this, this, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
                        this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController.a(this);
                      }
                      this.l = false;
                      this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController.c();
                    }
                    if (this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopAvatarManger == null)
                    {
                      this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopAvatarManger = new TroopAvatarManger(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, TroopUploadingTask.class, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
                      this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopAvatarManger.a(this.jdField_a_of_type_JavaUtilObserver);
                    }
                    a(i2, paramView);
                    localObject2 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
                    localObject3 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin;
                    if (this.j) {
                      localObject1 = "2";
                    } else {
                      localObject1 = "1";
                    }
                    ReportController.b((AppRuntime)localObject2, "dc00899", "Grp_create_new", "", "edit_data", "cover", 0, 0, (String)localObject3, (String)localObject1, "", "");
                    break;
                  case 11: 
                    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.hasSetNewTroopHead)
                    {
                      c(11);
                    }
                    else if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim())
                    {
                      if (this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopAvatarController == null)
                      {
                        this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopAvatarController = new TroopAvatarController(this, this, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
                        this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopAvatarController.a(this);
                      }
                      this.l = true;
                      this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopAvatarController.c();
                      if (this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopAvatarManger == null)
                      {
                        this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopAvatarManger = new TroopAvatarManger(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, TroopUploadingTask.class, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
                        this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopAvatarManger.a(this.jdField_a_of_type_JavaUtilObserver);
                      }
                    }
                    a(i2, paramView);
                    localObject3 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
                    str = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin;
                    if (this.j) {
                      localObject2 = "2";
                    } else {
                      localObject2 = "1";
                    }
                    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.bOwner) {
                      localObject1 = "0";
                    } else if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.bAdmin) {
                      localObject1 = "1";
                    } else {
                      localObject1 = "2";
                    }
                    ReportController.b((AppRuntime)localObject3, "dc00899", "Grp_set_new", "", "grpData_admin", "clk_image", 0, 0, str, (String)localObject2, (String)localObject1, "");
                    break;
                  case 10: 
                    localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
                    if (localObject1 != null)
                    {
                      boolean bool;
                      if ((!((TroopInfoData)localObject1).isOwnerOrAdim()) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.allowMemberModifTroopName != 1)) {
                        bool = false;
                      } else {
                        bool = true;
                      }
                      if ((bool) && (QVipBigTroopExpiredProcessor.c().mIsEnable) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mIsFreezed == 1) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim()))
                      {
                        ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).handleModifyNameFreezed(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData, this);
                        ReportController.b(null, "dc00898", "", "", "qq_vip", "0X8009E37", 1, 0, "", "", "", "");
                      }
                      else
                      {
                        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.hasSetNewTroopName) {
                          localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.newTroopName;
                        } else {
                          localObject1 = "";
                        }
                        localObject2 = localObject1;
                        if (localObject1 == null) {
                          localObject2 = "";
                        }
                        if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isNewTroop)) {
                          n = 1;
                        } else {
                          n = 0;
                        }
                        localObject3 = new Intent();
                        ((Intent)localObject3).putExtra("edit_type", 1);
                        ((Intent)localObject3).putExtra("edit_mode", 2);
                        int i1;
                        if (bool) {
                          i1 = 2131701952;
                        } else {
                          i1 = 2131701951;
                        }
                        ((Intent)localObject3).putExtra("title", HardCodeUtil.a(i1));
                        ((Intent)localObject3).putExtra("default_text", (String)localObject2);
                        ((Intent)localObject3).putExtra("max_num", 96);
                        ((Intent)localObject3).putExtra("canPostNull", false);
                        if (bool) {
                          localObject1 = HardCodeUtil.a(2131701937);
                        } else {
                          localObject1 = "";
                        }
                        ((Intent)localObject3).putExtra("right_btn", (String)localObject1);
                        ((Intent)localObject3).putExtra("edit_mode", bool);
                        if (n != 0) {
                          localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin;
                        } else {
                          localObject1 = "";
                        }
                        ((Intent)localObject3).putExtra("troopUin", (String)localObject1);
                        RouteUtils.a(this, (Intent)localObject3, "/base/activity/editInfoActivity", 18);
                        localObject3 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
                        str = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin;
                        if (this.j) {
                          localObject2 = "2";
                        } else {
                          localObject2 = "1";
                        }
                        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.bOwner) {
                          localObject1 = "0";
                        } else if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.bAdmin) {
                          localObject1 = "1";
                        } else {
                          localObject1 = "2";
                        }
                        ReportController.b((AppRuntime)localObject3, "dc00899", "Grp_set", "", "Grp_data", "add_name", 0, 0, str, (String)localObject2, (String)localObject1, "");
                      }
                    }
                    else
                    {
                      a(i2, paramView);
                    }
                    break;
                  case 9: 
                    localObject1 = new ActivityURIRequest(this, "/base/browser");
                    localObject2 = new Intent();
                    ((Intent)localObject2).putExtra("url", "https://buluo.qq.com/mobile/qunbindbuluo.html?_wv=1027");
                    ((Intent)localObject2).putExtra("bid", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.tribeId);
                    ((ActivityURIRequest)localObject1).extra().putAll(((Intent)localObject2).getExtras());
                    ((ActivityURIRequest)localObject1).setRequestCode(17);
                    QRoute.startUri((URIRequest)localObject1, null);
                    break;
                  case 8: 
                    localObject3 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
                    str = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin;
                    if (this.j) {
                      localObject2 = "2";
                    } else {
                      localObject2 = "1";
                    }
                    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.bOwner) {
                      localObject1 = "0";
                    } else if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.bAdmin) {
                      localObject1 = "1";
                    } else {
                      localObject1 = "2";
                    }
                    ReportController.b((AppRuntime)localObject3, "dc00899", "Grp_set", "", "Grp_data", "add_tag", 0, 0, str, (String)localObject2, (String)localObject1, "");
                    i();
                    a(i2, paramView);
                    break;
                  }
                }
                else
                {
                  localObject2 = new Intent();
                  ((Intent)localObject2).putExtra("edit_type", 2);
                  ((Intent)localObject2).putExtra("edit_mode", 1);
                  ((Intent)localObject2).putExtra("title", getString(2131693389));
                  ((Intent)localObject2).putExtra("default_text", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mRichFingerMemo);
                  ((Intent)localObject2).putExtra("max_num", 900);
                  ((Intent)localObject2).putExtra("canPostNull", true);
                  ((Intent)localObject2).putExtra("support_emotion", true);
                  ((Intent)localObject2).putExtra("full_screen", true);
                  RouteUtils.a(this, (Intent)localObject2, "/base/activity/editInfoActivity", 5);
                  if (!this.j) {
                    localObject1 = "1";
                  }
                  a("Grp_moredata", "Clk_brief", (String)localObject1);
                  a(i2, paramView);
                }
              }
              else
              {
                j();
                a(i2, paramView);
              }
            }
            else
            {
              if (this.jdField_f_of_type_Int == 1)
              {
                QQToast.a(getApplicationContext(), 1, HardCodeUtil.a(2131715233), 0).a();
              }
              else
              {
                localObject3 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
                str = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin;
                if (this.j) {
                  localObject2 = "2";
                } else {
                  localObject2 = "1";
                }
                if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.bOwner) {
                  localObject1 = "0";
                } else if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.bAdmin) {
                  localObject1 = "1";
                } else {
                  localObject1 = "2";
                }
                ReportController.b((AppRuntime)localObject3, "dc00899", "Grp_set", "", "Grp_data", "add_category", 0, 0, str, (String)localObject2, (String)localObject1, "");
                localObject1 = new Intent(getActivity(), ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).getTroopClassChoiceActivtiyClass());
                ((Intent)localObject1).putExtra("troopGroupClassExt", Long.toString(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwGroupClassExt));
                startActivityForResult((Intent)localObject1, 11);
              }
              a(i2, paramView);
            }
          }
          else if (!NetworkUtil.isNetworkAvailable(this))
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isNewTroop) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.hasSetNewTroopHead) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.hasSetNewTroopName)) {
              QQToast.a(this, 1, 2131694425, 0).b(getTitleBarHeight());
            } else if (!this.jdField_g_of_type_Boolean) {
              r();
            } else {
              QQToast.a(this, 1, 2131694425, 0).b(getTitleBarHeight());
            }
          }
          else if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isNewTroop) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.hasSetNewTroopHead) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.hasSetNewTroopName))
          {
            a(2131720019);
          }
          else if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isNewTroop) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.hasSetNewTroopHead))
          {
            a(2131720017);
          }
          else if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isNewTroop) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.hasSetNewTroopName))
          {
            a(2131720018);
          }
          else
          {
            r();
          }
        }
        else if (!NetworkUtil.isNetSupport(this))
        {
          a(2131694422, 0);
        }
        else
        {
          localObject1 = (ITroopMngHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopMngHandlerName());
          if (localObject1 != null)
          {
            try
            {
              long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
              o();
              ((ITroopMngHandler)localObject1).a(l1, 8390784);
            }
            catch (Exception localException)
            {
              if (!QLog.isColorLevel()) {
                break label1967;
              }
            }
            QLog.i("Q.troopinfo", 2, localException.toString());
          }
        }
      }
      else {
        w();
      }
    }
    label1967:
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
      if ((paramString != null) && (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin))) {
        s();
      }
    }
  }
  
  public void p()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
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
  
  public void q()
  {
    Object localObject1 = new GCBindGroup.GCBindGroupSsoServerReq();
    ((GCBindGroup.GCBindGroupSsoServerReq)localObject1).cmd.set("get_appid");
    Object localObject2 = new GCBindGroup.QQGroupBind();
    try
    {
      long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
      ((GCBindGroup.QQGroupBind)localObject2).group_code.set(l1);
      ((GCBindGroup.GCBindGroupSsoServerReq)localObject1).bind_req.set((MessageMicro)localObject2);
      localObject2 = new NewIntent(MobileQQ.getContext(), ProtoServlet.class);
      TroopInfoActivity.32 local32 = new TroopInfoActivity.32(this);
      local32.mApp = new WeakReference(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      local32.mType = 2;
      ((NewIntent)localObject2).setObserver(local32);
      ((NewIntent)localObject2).putExtra("cmd", "gcbindgroupsso.get_appid");
      ((NewIntent)localObject2).putExtra("data", ((GCBindGroup.GCBindGroupSsoServerReq)localObject1).toByteArray());
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet((NewIntent)localObject2);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label145:
      break label145;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("get game bind status failed, troop=");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    QLog.e("Q.troopinfo", 1, ((StringBuilder)localObject1).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.TroopInfoActivity
 * JD-Core Version:    0.7.0.1
 */