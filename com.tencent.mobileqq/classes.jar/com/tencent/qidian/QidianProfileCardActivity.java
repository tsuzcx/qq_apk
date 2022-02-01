package com.tencent.qidian;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.bmqq.app.BmqqBusinessObserver;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.data.BmqqUserSimpleInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profilecard.base.container.ProfileBottomContainer;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.profilecard.utils.ProfileNameUtils;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.troop.utils.TroopInfoUIUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.unifiedname.MQQProfileName;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qidian.data.BmqqAccountType;
import com.tencent.qidian.data.GroupItem;
import com.tencent.qidian.data.PublicAccountItem;
import com.tencent.qidian.data.QidianCorpInfo;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qidian.data.QidianProfileUiInfo;
import com.tencent.qidian.data.QidianProfileUiInfo.ConfigCorpSimpleInfo;
import com.tencent.qidian.data.QidianProfileUiInfo.ConfigGroupInfo;
import com.tencent.qidian.data.QidianProfileUiInfo.ConfigInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.pm.PackageUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class QidianProfileCardActivity
  extends ProfileActivity
{
  private RelativeLayout A;
  private TextView B;
  private TextView C;
  private TextView D;
  private ImageView E;
  private ImageView F;
  private QidianProfileCardActivity.UiHandler G;
  private QidianCorpInfo H;
  private QidianProfileUiInfo I;
  private ActionSheet J;
  private ActionSheet K;
  private boolean L;
  private boolean M = false;
  private boolean N = false;
  private AvatarObserver O = new QidianProfileCardActivity.13(this);
  private FriendListObserver P = new QidianProfileCardActivity.14(this);
  private View.OnLongClickListener Q = new QidianProfileCardActivity.15(this);
  private View.OnClickListener R = new QidianProfileCardActivity.16(this);
  private CardObserver S = new QidianProfileCardActivity.19(this);
  private ProfileCardObserver T = new QidianProfileCardActivity.20(this);
  private QidianBusinessObserver U = new QidianProfileCardActivity.21(this);
  private BmqqBusinessObserver V = new QidianProfileCardActivity.22(this);
  private QQToastNotifier W;
  private String X = "";
  private String Y = "";
  public ImageView a;
  public ImageView b;
  public LinearLayout c;
  public LinearLayout d;
  ProfileCardInfo e = new ProfileCardInfo();
  public Bitmap f;
  public QidianExternalInfo g;
  public ConcurrentHashMap<String, QidianProfileCardActivity.PaGroupStruct> h;
  public ConcurrentHashMap<String, Drawable> i;
  Dialog j;
  public int k;
  public int l = 0;
  int m = 4;
  public QQProgressDialog n = null;
  public BmqqUserSimpleInfo o;
  int p;
  int q;
  int r;
  QidianManager s;
  FriendsManager t;
  CardHandler u;
  PhotoWallViewForQiDianProfile.PhotoWallCallback v = new QidianProfileCardActivity.11(this);
  QQCustomDialog w;
  PreloadProcHitPluginSession x = new PreloadProcHitPluginSession("qzone_friendprofile", "com.tencent.mobileqq:qzone", QzonePluginProxyActivity.getQZonePluginName());
  private LinearLayout y;
  private BounceScrollView z;
  
  public static Bitmap a(QQAppInterface paramQQAppInterface, URLDrawable paramURLDrawable, boolean paramBoolean)
  {
    paramQQAppInterface = paramURLDrawable.getCurrDrawable();
    if (paramQQAppInterface != null)
    {
      if ((paramQQAppInterface instanceof BitmapDrawable))
      {
        paramURLDrawable = ((BitmapDrawable)paramQQAppInterface).getBitmap();
        paramQQAppInterface = paramURLDrawable;
        if (paramBoolean) {
          return QQAppInterface.getCircleFaceBitmap(paramURLDrawable, 50, 50);
        }
      }
      else if ((paramQQAppInterface instanceof SkinnableBitmapDrawable))
      {
        paramURLDrawable = ((SkinnableBitmapDrawable)paramQQAppInterface).getBitmap();
        paramQQAppInterface = paramURLDrawable;
        if (paramBoolean) {
          return QQAppInterface.getCircleFaceBitmap(paramURLDrawable, 50, 50);
        }
      }
      else
      {
        paramURLDrawable = ImageUtil.a(paramQQAppInterface);
        paramQQAppInterface = paramURLDrawable;
        if (paramBoolean) {
          return QQAppInterface.getCircleFaceBitmap(paramURLDrawable, 50, 50);
        }
      }
    }
    else {
      paramQQAppInterface = null;
    }
    return paramQQAppInterface;
  }
  
  private View a(int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -2);
    View localView = View.inflate(this, paramInt2, null);
    int i1 = getResources().getDimensionPixelSize(2131298828);
    localView.setVisibility(0);
    Button localButton = (Button)localView.findViewById(2131448897);
    localButton.setText(paramInt1);
    localButton.setOnClickListener(paramOnClickListener);
    localLayoutParams.weight = 1.0F;
    localLayoutParams.rightMargin = i1;
    if (this.L) {
      if (paramInt2 == 2131627184)
      {
        localButton.setBackgroundResource(2130845843);
        localButton.setTextColor(getResources().getColor(2131167100));
      }
      else if (paramInt2 == 2131627183)
      {
        localButton.setBackgroundResource(2130845842);
        localButton.setTextColor(getResources().getColor(2131167099));
      }
    }
    this.y.addView(localView, localLayoutParams);
    return localButton;
  }
  
  private View a(QidianProfileUiInfo.ConfigInfo paramConfigInfo, boolean paramBoolean)
  {
    if ((paramConfigInfo.d != null) && ((!TextUtils.isEmpty(paramConfigInfo.d.trim())) || (paramConfigInfo.l == 11) || (paramConfigInfo.c.equals(HardCodeUtil.a(2131907430)))))
    {
      QidianProfileCardActivity.QidianSimpleProfileItem localQidianSimpleProfileItem = new QidianProfileCardActivity.QidianSimpleProfileItem();
      localQidianSimpleProfileItem.a = paramConfigInfo.c;
      localQidianSimpleProfileItem.b = paramConfigInfo.d;
      localQidianSimpleProfileItem.d = paramConfigInfo.a;
      localQidianSimpleProfileItem.e = paramConfigInfo.b;
      String str;
      if (!TextUtils.isEmpty(paramConfigInfo.f)) {
        str = paramConfigInfo.f;
      } else {
        str = paramConfigInfo.e;
      }
      localQidianSimpleProfileItem.f = str;
      boolean bool;
      if (localQidianSimpleProfileItem.e != 0) {
        bool = true;
      } else {
        bool = false;
      }
      localQidianSimpleProfileItem.c = bool;
      localQidianSimpleProfileItem.g = paramBoolean;
      localQidianSimpleProfileItem.h = paramConfigInfo.g;
      localQidianSimpleProfileItem.i = paramConfigInfo.l;
      return a(localQidianSimpleProfileItem);
    }
    return null;
  }
  
  private DataTag a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    switch (paramInt)
    {
    case 8: 
    default: 
      return null;
    case 9: 
      return new DataTag(82, paramString3);
    case 7: 
      return new DataTag(54, paramString3);
    case 6: 
      return new DataTag(75, paramString2);
    case 5: 
      return new DataTag(76, paramString3);
    case 4: 
      return new DataTag(48, new String[] { paramString1, paramString2 });
    case 3: 
      return new DataTag(47, paramString2);
    case 2: 
      return new DataTag(4, paramString2);
    }
    return new DataTag(52, paramString2);
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    ThreadManager.executeOnFileThread(new QidianProfileCardActivity.ForwardRunnable(this, paramURLDrawable));
  }
  
  private void a(URLDrawable paramURLDrawable, String paramString)
  {
    ActionSheet localActionSheet = ActionSheet.createMenuSheet(this);
    localActionSheet.addButton(2131890804);
    localActionSheet.addButton(2131890810);
    localActionSheet.addButton(2131896249);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new QidianProfileCardActivity.25(this, localActionSheet, paramURLDrawable, paramString));
    localActionSheet.show();
  }
  
  private void a(QidianProfileUiInfo.ConfigGroupInfo paramConfigGroupInfo)
  {
    Object localObject5 = new ArrayList();
    Object localObject4 = n();
    List localList = paramConfigGroupInfo.a;
    if (localList != null)
    {
      int i2 = localList.size();
      Object localObject1 = null;
      paramConfigGroupInfo = (QidianProfileUiInfo.ConfigGroupInfo)localObject1;
      int i1 = 0;
      while (i1 < i2)
      {
        QidianProfileUiInfo.ConfigInfo localConfigInfo = (QidianProfileUiInfo.ConfigInfo)localList.get(i1);
        localObject2 = localObject1;
        localObject3 = paramConfigGroupInfo;
        if (localConfigInfo != null)
        {
          int i3 = localConfigInfo.a;
          boolean bool = true;
          if (i3 != 1) {
            if (i3 != 2)
            {
              if (i3 != 3)
              {
                if (i3 != 6)
                {
                  localObject2 = localObject1;
                  localObject3 = paramConfigGroupInfo;
                  break label176;
                }
              }
              else
              {
                localObject2 = p();
                localObject3 = paramConfigGroupInfo;
                break label176;
              }
            }
            else
            {
              localObject3 = o();
              localObject2 = localObject1;
              break label176;
            }
          }
          if (i1 != i2 - 1) {
            bool = false;
          }
          ((ArrayList)localObject5).add(a(localConfigInfo, bool));
          localObject3 = paramConfigGroupInfo;
          localObject2 = localObject1;
        }
        label176:
        i1 += 1;
        localObject1 = localObject2;
        paramConfigGroupInfo = (QidianProfileUiInfo.ConfigGroupInfo)localObject3;
      }
      Object localObject2 = ((ArrayList)localObject5).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (View)((Iterator)localObject2).next();
        if (localObject3 != null) {
          this.d.addView((View)localObject3);
        }
      }
      localObject2 = ((ArrayList)localObject4).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (View)((Iterator)localObject2).next();
        if (localObject3 != null) {
          this.d.addView((View)localObject3);
        }
      }
      localObject2 = (LinearLayout)getLayoutInflater().inflate(2131627180, null);
      Object localObject3 = (LinearLayout)((LinearLayout)localObject2).findViewById(2131431280);
      localObject4 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject4).setMargins(ViewUtils.dip2px(15.0F), 0, 0, 0);
      if (localObject1 != null)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject5 = (View)((Iterator)localObject1).next();
          if (((LinearLayout)localObject3).getChildCount() > 6) {
            break;
          }
          if (localObject5 != null) {
            ((LinearLayout)localObject3).addView((View)localObject5, (ViewGroup.LayoutParams)localObject4);
          }
        }
      }
      if (paramConfigGroupInfo != null)
      {
        paramConfigGroupInfo = paramConfigGroupInfo.iterator();
        while (paramConfigGroupInfo.hasNext())
        {
          localObject1 = (View)paramConfigGroupInfo.next();
          if (((LinearLayout)localObject3).getChildCount() > 6) {
            break;
          }
          if (localObject1 != null) {
            ((LinearLayout)localObject3).addView((View)localObject1, (ViewGroup.LayoutParams)localObject4);
          }
        }
      }
      if (((LinearLayout)localObject3).getChildCount() > 0) {
        this.d.addView((View)localObject2);
      }
    }
  }
  
  private void b(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable.getStatus() != 1) {
      return;
    }
    new File(AppConstants.SDCARD_IMG_SAVE).mkdirs();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppConstants.SDCARD_IMG_SAVE);
    ((StringBuilder)localObject).append(com.tencent.image.Utils.Crc64String(this.e.allInOne.uin));
    ((StringBuilder)localObject).append(com.tencent.image.Utils.Crc64String(paramURLDrawable.getURL().toString()));
    localObject = ((StringBuilder)localObject).toString();
    File localFile = new File((String)localObject);
    if (!localFile.exists()) {}
    try
    {
      if (!localFile.createNewFile()) {
        break label195;
      }
      b(paramURLDrawable, localFile.getPath());
      return;
    }
    catch (IOException paramURLDrawable)
    {
      label110:
      break label110;
    }
    QQToast.makeText(this, getString(2131892637), 0).show();
    return;
    DialogUtil.a(this, 230).setTitle(getString(2131915885)).setMessage(getString(2131892633)).setPositiveButton(getString(2131915687), new QidianProfileCardActivity.27(this, paramURLDrawable, (String)localObject)).setNegativeButton(getString(2131892140), new QidianProfileCardActivity.26(this)).show();
    label195:
  }
  
  private void b(URLDrawable paramURLDrawable, String paramString)
  {
    ThreadManager.executeOnFileThread(new QidianProfileCardActivity.SavePhotoRunnable(this, paramURLDrawable, paramString));
  }
  
  private void b(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(this, QQMapActivity.class);
    localIntent.putExtra("lat", paramString1);
    localIntent.putExtra("lon", paramString2);
    startActivity(localIntent);
  }
  
  private void e(int paramInt)
  {
    if (paramInt == 4) {
      a(2131893010);
    }
    if (this.s.a(this.e.allInOne.uin, true))
    {
      this.s.c(this.e.allInOne.uin, false);
    }
    else if (this.s.b(this.e.allInOne.uin, false))
    {
      BmqqAccountType localBmqqAccountType = new BmqqAccountType(this.e.allInOne.uin, 1);
      this.s.b(this, localBmqqAccountType);
    }
    else
    {
      this.s.n(this.e.allInOne.uin);
    }
    if (paramInt == 6) {
      ((QidianHandler)this.app.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).c(Long.parseLong(this.e.allInOne.uin));
    }
  }
  
  private void f(int paramInt)
  {
    int i2 = 0;
    int i1;
    if (paramInt == 6)
    {
      i1 = i2;
      if (this.g != null) {}
    }
    else
    {
      do
      {
        for (;;)
        {
          i1 = 1;
          break label72;
          if (paramInt != 1) {
            break;
          }
          if (this.g != null)
          {
            i1 = i2;
            if (this.e.card != null) {
              break label72;
            }
          }
        }
        if (paramInt != 2)
        {
          i1 = i2;
          if (paramInt != 0) {
            break;
          }
        }
        i1 = i2;
      } while (this.o == null);
    }
    label72:
    if (i1 != 0) {
      ThreadManager.post(new QidianProfileCardActivity.3(this, paramInt), 8, null, true);
    }
  }
  
  private void g(int paramInt)
  {
    int i1 = 1;
    Object localObject4 = "";
    if ((paramInt != 1) && (paramInt != 6))
    {
      if ((paramInt != 0) && (paramInt != 2))
      {
        localObject1 = "";
        localObject2 = localObject1;
        break label200;
      }
      localObject3 = l();
      localObject2 = this.o;
      localObject1 = localObject3;
      if (localObject2 == null) {
        break label196;
      }
      localObject1 = localObject3;
      if (TextUtils.isEmpty(((BmqqUserSimpleInfo)localObject2).mBmqqJobTitle)) {
        break label196;
      }
      localObject2 = this.o.mBmqqJobTitle;
      localObject1 = localObject3;
    }
    else
    {
      String str = l();
      localObject2 = this.g;
      localObject1 = str;
      if (localObject2 == null) {
        break label196;
      }
      if (!TextUtils.isEmpty(((QidianExternalInfo)localObject2).job))
      {
        localObject3 = this.g.job;
        paramInt = this.g.verity;
      }
      else
      {
        localObject3 = "";
      }
      localObject2 = localObject3;
      localObject1 = str;
      if (!TextUtils.isEmpty(this.g.sign))
      {
        localObject4 = this.g.sign;
        localObject1 = str;
        localObject2 = localObject3;
      }
    }
    Object localObject3 = localObject4;
    localObject4 = localObject2;
    Object localObject2 = localObject3;
    break label200;
    label196:
    localObject2 = "";
    label200:
    this.B.setText((CharSequence)localObject1);
    this.C.setText((CharSequence)localObject4);
    this.D.setText((CharSequence)localObject2);
    Object localObject1 = this.g;
    if (localObject1 == null) {
      return;
    }
    if (((QidianExternalInfo)localObject1).verity == 2) {
      paramInt = i1;
    } else {
      paramInt = 0;
    }
    if (paramInt != 0)
    {
      localObject1 = this.b;
      if (localObject1 != null) {
        ((ImageView)localObject1).setVisibility(4);
      }
    }
  }
  
  private void h(int paramInt)
  {
    this.d.removeAllViews();
    if ((paramInt != 1) && (paramInt != 6))
    {
      if ((paramInt == 0) || (paramInt == 2)) {
        m();
      }
    }
    else
    {
      Object localObject = this.I;
      if (localObject != null)
      {
        localObject = ((QidianProfileUiInfo)localObject).getConfigGroupInfos().iterator();
        while (((Iterator)localObject).hasNext()) {
          a((QidianProfileUiInfo.ConfigGroupInfo)((Iterator)localObject).next());
        }
      }
    }
  }
  
  private void h(String paramString)
  {
    this.e.allInOne.remark = paramString;
    ProfileNameUtils.updateNameArray(this.e, 4, paramString);
    ProfileNameUtils.updateProfileName(this.e);
    paramString = l();
    this.B.setText(paramString);
  }
  
  private void i(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.t == null) {
        return;
      }
      ThreadManager.post(new QidianProfileCardActivity.2(this, paramString), 8, null, true);
    }
  }
  
  private void j()
  {
    ConcurrentHashMap localConcurrentHashMap = this.h;
    if (localConcurrentHashMap != null) {
      localConcurrentHashMap.clear();
    }
    localConcurrentHashMap = this.i;
    if (localConcurrentHashMap != null) {
      localConcurrentHashMap.clear();
    }
    this.g = null;
    this.H = null;
    this.I = null;
    this.J = null;
    this.K = null;
    this.o = null;
  }
  
  private void j(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = paramString;
    if (!paramString.startsWith("http"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("https://");
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    paramString = new Intent(this, QQBrowserActivity.class);
    paramString.putExtra("url", (String)localObject);
    paramString.putExtra("isShowAd", false);
    paramString.putExtra("big_brother_source_key", "biz_src_qycp");
    startActivity(paramString);
  }
  
  private void k()
  {
    Object localObject = getResources();
    DisplayMetrics localDisplayMetrics = ((Resources)localObject).getDisplayMetrics();
    this.k = (((Resources)localObject).getDimensionPixelSize(2131299920) - (int)(localDisplayMetrics.density * 66.0F));
    this.y = ((LinearLayout)findViewById(2131430077));
    this.A = ((RelativeLayout)findViewById(2131434940));
    this.a = ((ImageView)findViewById(2131434907));
    this.a.setOnClickListener(new QidianProfileCardActivity.4(this));
    if (!SimpleUIUtil.e()) {
      this.a.setImageDrawable(getResources().getDrawable(2130845839));
    }
    this.b = ((ImageView)findViewById(2131449358));
    this.c = ((LinearLayout)findViewById(2131431280));
    this.d = ((LinearLayout)findViewById(2131436151));
    this.z = ((BounceScrollView)findViewById(2131431170));
    localObject = this.z;
    ((BounceScrollView)localObject).mScrollFlag = 1;
    ((BounceScrollView)localObject).setVerticalScrollBarEnabled(false);
    this.z.setOnScrollChangedListener(new QidianProfileCardActivity.5(this));
    this.B = ((TextView)findViewById(2131439121));
    this.C = ((TextView)findViewById(2131436676));
    this.D = ((TextView)findViewById(2131446005));
    findViewById(2131446021).setOnClickListener(new QidianProfileCardActivity.6(this));
    this.E = ((ImageView)findViewById(2131437139));
    this.E.setOnClickListener(new QidianProfileCardActivity.7(this));
    this.F = ((ImageView)findViewById(2131444860));
    this.F.setTag(new DataTag(53, null));
    this.F.setOnClickListener(this.R);
    c();
  }
  
  private void k(String paramString)
  {
    Object localObject = (ClipboardManager)getSystemService("clipboard");
    ClipboardMonitor.setText((ClipboardManager)localObject, paramString);
    ((ClipboardManager)localObject).setText(paramString);
    if (r())
    {
      paramString = new Intent();
      localObject = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI");
      paramString.setAction("android.intent.action.MAIN");
      paramString.addCategory("android.intent.category.LAUNCHER");
      paramString.addFlags(268435456);
      paramString.setComponent((ComponentName)localObject);
      startActivity(paramString);
      return;
    }
    j("https://weixin.qq.com/d");
  }
  
  private String l()
  {
    if (!TextUtils.isEmpty(this.e.allInOne.remark)) {
      return this.e.allInOne.remark;
    }
    int i1 = this.m;
    Object localObject;
    if (i1 == 0)
    {
      localObject = this.o;
      if ((localObject != null) && (!TextUtils.isEmpty(((BmqqUserSimpleInfo)localObject).mBmqqNickName))) {
        return this.o.mBmqqNickName;
      }
    }
    else if ((i1 == 1) || (i1 == 6))
    {
      localObject = this.g;
      if (localObject != null)
      {
        if (TextUtils.isEmpty(((QidianExternalInfo)localObject).nickname)) {
          return this.g.uin;
        }
        return this.g.nickname;
      }
    }
    return this.e.allInOne.uin;
  }
  
  private void m()
  {
    if (this.o != null)
    {
      QidianProfileUiInfo.ConfigGroupInfo localConfigGroupInfo = new QidianProfileUiInfo.ConfigGroupInfo();
      localConfigGroupInfo.a = new ArrayList(5);
      new QidianProfileUiInfo.ConfigInfo();
      QidianProfileUiInfo.ConfigInfo localConfigInfo = new QidianProfileUiInfo.ConfigInfo();
      localConfigInfo.a = 1;
      localConfigInfo.b = 0;
      localConfigInfo.c = HardCodeUtil.a(2131907437);
      localConfigInfo.d = this.e.allInOne.uin;
      localConfigGroupInfo.a.add(localConfigInfo);
      localConfigInfo = new QidianProfileUiInfo.ConfigInfo();
      localConfigInfo.a = 1;
      localConfigInfo.b = 2;
      localConfigInfo.c = getResources().getString(2131895946);
      localConfigInfo.d = this.o.mBmqqMobileNum;
      localConfigInfo.e = this.o.mBmqqMobileNum;
      localConfigGroupInfo.a.add(localConfigInfo);
      localConfigInfo = new QidianProfileUiInfo.ConfigInfo();
      localConfigInfo.a = 1;
      localConfigInfo.b = 1;
      localConfigInfo.c = getResources().getString(2131917001);
      localConfigInfo.d = this.o.mBmqqTelphone;
      localConfigInfo.e = this.o.mBmqqTelphone;
      localConfigGroupInfo.a.add(localConfigInfo);
      localConfigInfo = new QidianProfileUiInfo.ConfigInfo();
      localConfigInfo.a = 1;
      localConfigInfo.b = 3;
      localConfigInfo.c = getResources().getString(2131891476);
      localConfigInfo.d = this.o.mBmqqEmail;
      localConfigInfo.e = this.o.mBmqqEmail;
      localConfigGroupInfo.a.add(localConfigInfo);
      localConfigInfo = new QidianProfileUiInfo.ConfigInfo();
      localConfigInfo.a = 1;
      localConfigInfo.c = getResources().getString(2131892748);
      localConfigInfo.d = this.o.mBmqqCompany;
      if ((BmqqSegmentUtil.b(getApplicationContext(), this.o.mBmqqUin)) && (!TextUtils.isEmpty(this.o.mBmqqMasterUin)) && (BmqqSegmentUtil.a(this.o.mBmqqMasterUin)))
      {
        localConfigInfo.b = 7;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mqqwpa://card/show_pslcard?card_type=crm&uin=");
        localStringBuilder.append(this.o.mBmqqMasterUin);
        localConfigInfo.f = localStringBuilder.toString();
        localConfigInfo.g = this.o.isCertified();
      }
      else
      {
        localConfigInfo.b = 0;
        localConfigInfo.g = this.o.isCertified();
      }
      localConfigGroupInfo.a.add(localConfigInfo);
      a(localConfigGroupInfo);
    }
  }
  
  private ArrayList<View> n()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.g;
    if ((localObject1 != null) && (((QidianExternalInfo)localObject1).getCompanyShowCaseInfos() != null) && (this.g.getCompanyShowCaseInfos().size() > 0))
    {
      localObject1 = (LinearLayout)getLayoutInflater().inflate(2131627179, null);
      Object localObject2 = (TextView)((LinearLayout)localObject1).findViewById(2131447463);
      localObject2 = (LinearLayout)((LinearLayout)localObject1).findViewById(2131431280);
      PhotoWallViewForQiDianProfile localPhotoWallViewForQiDianProfile = new PhotoWallViewForQiDianProfile(getApplicationContext());
      localPhotoWallViewForQiDianProfile.setPhotoWallCallback(this.v);
      List localList = this.g.getCompanyShowCaseInfos();
      localPhotoWallViewForQiDianProfile.a(getApplicationContext(), localList);
      localPhotoWallViewForQiDianProfile.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      ((LinearLayout)localObject2).addView(localPhotoWallViewForQiDianProfile);
      localArrayList.add(localObject1);
    }
    return localArrayList;
  }
  
  private ArrayList<View> o()
  {
    ArrayList localArrayList = new ArrayList(6);
    if ((this.g != null) && (h() != null) && (h().size() > 0))
    {
      Iterator localIterator = h().iterator();
      while (localIterator.hasNext())
      {
        PublicAccountItem localPublicAccountItem = (PublicAccountItem)localIterator.next();
        RelativeLayout localRelativeLayout = (RelativeLayout)getLayoutInflater().inflate(2131627181, null);
        URLImageView localURLImageView = (URLImageView)localRelativeLayout.findViewById(2131435219);
        TextView localTextView1 = (TextView)localRelativeLayout.findViewById(2131439121);
        ImageView localImageView = (ImageView)localRelativeLayout.findViewById(2131430460);
        TextView localTextView2 = (TextView)localRelativeLayout.findViewById(2131431733);
        localURLImageView.post(new QidianProfileCardActivity.9(this, localPublicAccountItem, localURLImageView));
        localTextView1.setText(localPublicAccountItem.b);
        localRelativeLayout.setOnClickListener(this.R);
        if (localPublicAccountItem.c == 0)
        {
          localTextView2.setText(2131896256);
          localRelativeLayout.setTag(new DataTag(49, localPublicAccountItem.a));
        }
        else if (localPublicAccountItem.c == 1)
        {
          localTextView2.setText(2131896257);
          localRelativeLayout.setTag(new DataTag(50, localPublicAccountItem));
        }
        else if (localPublicAccountItem.c == 2)
        {
          localTextView2.setText(2131896260);
          localRelativeLayout.setTag(new DataTag(106, localPublicAccountItem));
        }
        if ((localPublicAccountItem.c == 0) && (localPublicAccountItem.d == 1))
        {
          localImageView.setVisibility(0);
          localImageView.setBackgroundResource(2130843687);
        }
        else if ((localPublicAccountItem.c == 1) && (localPublicAccountItem.d == 1))
        {
          localImageView.setVisibility(0);
          localImageView.setBackgroundResource(2130845867);
        }
        else
        {
          localImageView.setVisibility(8);
        }
        localArrayList.add(localRelativeLayout);
      }
    }
    return localArrayList;
  }
  
  private ArrayList<View> p()
  {
    ArrayList localArrayList = new ArrayList(6);
    if ((this.g != null) && (i() != null) && (i().size() > 0))
    {
      Iterator localIterator = i().iterator();
      while (localIterator.hasNext())
      {
        GroupItem localGroupItem = (GroupItem)localIterator.next();
        RelativeLayout localRelativeLayout = (RelativeLayout)getLayoutInflater().inflate(2131627181, null);
        URLImageView localURLImageView = (URLImageView)localRelativeLayout.findViewById(2131435219);
        TextView localTextView1 = (TextView)localRelativeLayout.findViewById(2131439121);
        ImageView localImageView = (ImageView)localRelativeLayout.findViewById(2131430460);
        TextView localTextView2 = (TextView)localRelativeLayout.findViewById(2131431733);
        localURLImageView.post(new QidianProfileCardActivity.10(this, localGroupItem, localURLImageView));
        localTextView1.setText(String.valueOf(localGroupItem.c));
        localRelativeLayout.setOnClickListener(this.R);
        localTextView2.setText(HardCodeUtil.a(2131907429));
        localRelativeLayout.setTag(new DataTag(51, String.valueOf(localGroupItem.a)));
        localImageView.setVisibility(8);
        localArrayList.add(localRelativeLayout);
      }
    }
    return localArrayList;
  }
  
  private void q()
  {
    ThreadManager.executeOnSubThread(new QidianProfileCardActivity.12(this));
  }
  
  private boolean r()
  {
    return PackageUtil.d(getApplicationContext(), "com.tencent.mm");
  }
  
  public Drawable a(URLImageView paramURLImageView, String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject2 = null;
    if (bool) {
      return null;
    }
    Object localObject1;
    try
    {
      localObject1 = URLDrawable.getDrawable(paramString);
    }
    catch (Exception localException)
    {
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getWeixinPAFaceDrawable load net error, ");
        ((StringBuilder)localObject1).append(localException.getMessage());
        QLog.d("QidianProfileCardActivity", 4, ((StringBuilder)localObject1).toString());
        localObject1 = localObject2;
      }
    }
    if ((localObject1 != null) && (((URLDrawable)localObject1).getStatus() != 2))
    {
      if (((URLDrawable)localObject1).getStatus() == 1) {
        return new BitmapDrawable(a(this.app, (URLDrawable)localObject1, SimpleUIUtil.e() ^ true));
      }
      paramURLImageView.setURLDrawableDownListener(new QidianProfileCardActivity.DrawableListener(this, this.app, paramURLImageView, paramString, ImageUtil.j(), SimpleUIUtil.e() ^ true));
      return localObject1;
    }
    return ImageUtil.j();
  }
  
  public View a(QidianProfileCardActivity.QidianSimpleProfileItem paramQidianSimpleProfileItem)
  {
    int i3 = paramQidianSimpleProfileItem.i;
    int i2 = 2130845845;
    int i1 = 11;
    Object localObject6;
    if ((i3 != 11) && (!paramQidianSimpleProfileItem.a.equals(HardCodeUtil.a(2131907426))))
    {
      if ((paramQidianSimpleProfileItem.i != 1) && (!paramQidianSimpleProfileItem.a.equals(HardCodeUtil.a(2131907420))))
      {
        if ((paramQidianSimpleProfileItem.i != 2) && (!paramQidianSimpleProfileItem.a.equals(HardCodeUtil.a(2131907422))))
        {
          if ((paramQidianSimpleProfileItem.i != 3) && (!paramQidianSimpleProfileItem.a.equals(HardCodeUtil.a(2131907424))))
          {
            if ((paramQidianSimpleProfileItem.i != 4) && (!paramQidianSimpleProfileItem.a.equals(HardCodeUtil.a(2131907432))))
            {
              if ((paramQidianSimpleProfileItem.i != 5) && (!paramQidianSimpleProfileItem.a.equals(HardCodeUtil.a(2131907421))))
              {
                if ((paramQidianSimpleProfileItem.i != 6) && (!paramQidianSimpleProfileItem.a.equals(HardCodeUtil.a(2131907428))))
                {
                  i1 = i2;
                  if (paramQidianSimpleProfileItem.i != 7) {
                    if (paramQidianSimpleProfileItem.a.equals(HardCodeUtil.a(2131907435))) {
                      i1 = i2;
                    } else if ((paramQidianSimpleProfileItem.i != 8) && (!paramQidianSimpleProfileItem.a.equals(HardCodeUtil.a(2131907425))))
                    {
                      if ((paramQidianSimpleProfileItem.i != 9) && (!paramQidianSimpleProfileItem.a.equals(HardCodeUtil.a(2131907434))))
                      {
                        if ((paramQidianSimpleProfileItem.i != 10) && (!paramQidianSimpleProfileItem.a.equals("QQ空间"))) {
                          i1 = 2130845846;
                        } else {
                          i1 = 2130845852;
                        }
                      }
                      else {
                        return null;
                      }
                    }
                    else {
                      i1 = 2130845850;
                    }
                  }
                }
                else
                {
                  i1 = 2130845848;
                }
              }
              else {
                i1 = 2130845844;
              }
            }
            else {
              i1 = 2130847425;
            }
          }
          else {
            i1 = 2130845847;
          }
        }
        else {
          i1 = 2130845849;
        }
      }
      else {
        i1 = 2130845851;
      }
      localRelativeLayout = (RelativeLayout)super.getLayoutInflater().inflate(2131627182, this.d, false);
      localObject1 = (ImageView)localRelativeLayout.findViewById(2131437100);
      localObject2 = (TextView)localRelativeLayout.findViewById(2131438362);
      localObject3 = (ImageView)localRelativeLayout.findViewById(2131444825);
      localObject4 = (ImageView)localRelativeLayout.findViewById(2131438360);
      ((TextView)localObject2).setText(paramQidianSimpleProfileItem.b);
      if (!paramQidianSimpleProfileItem.c)
      {
        ((ImageView)localObject3).setVisibility(4);
        localRelativeLayout.setLongClickable(true);
        localRelativeLayout.setTag(paramQidianSimpleProfileItem.b);
        localRelativeLayout.setOnLongClickListener(this.Q);
      }
      else
      {
        localRelativeLayout.setTag(a(paramQidianSimpleProfileItem.e, paramQidianSimpleProfileItem.a, paramQidianSimpleProfileItem.b, paramQidianSimpleProfileItem.f));
        localRelativeLayout.setClickable(true);
        localRelativeLayout.setOnClickListener(this.R);
        ((ImageView)localObject3).setVisibility(0);
      }
      if (paramQidianSimpleProfileItem.h) {
        ((ImageView)localObject4).setVisibility(0);
      } else {
        ((ImageView)localObject4).setVisibility(8);
      }
      ((ImageView)localObject1).setImageResource(i1);
      if ((paramQidianSimpleProfileItem.i == 5) || (paramQidianSimpleProfileItem.a.equals(HardCodeUtil.a(2131907431))))
      {
        localObject1 = this.I;
        if ((localObject1 != null) && (((QidianProfileUiInfo)localObject1).mConfigGroupInfos != null))
        {
          localObject1 = this.I.mConfigGroupInfos.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (QidianProfileUiInfo.ConfigGroupInfo)((Iterator)localObject1).next();
            if ((localObject2 == null) || (((QidianProfileUiInfo.ConfigGroupInfo)localObject2).a == null)) {
              break;
            }
            localObject2 = ((QidianProfileUiInfo.ConfigGroupInfo)localObject2).a.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (QidianProfileUiInfo.ConfigInfo)((Iterator)localObject2).next();
              if ((localObject3 != null) && ((((QidianProfileUiInfo.ConfigInfo)localObject3).l == 5) || (((QidianProfileUiInfo.ConfigInfo)localObject3).c.equals(HardCodeUtil.a(2131907427)))))
              {
                i1 = paramQidianSimpleProfileItem.e;
                localObject4 = paramQidianSimpleProfileItem.a;
                localObject5 = paramQidianSimpleProfileItem.b;
                localObject6 = new StringBuilder();
                ((StringBuilder)localObject6).append(((QidianProfileUiInfo.ConfigInfo)localObject3).j);
                ((StringBuilder)localObject6).append("|");
                ((StringBuilder)localObject6).append(((QidianProfileUiInfo.ConfigInfo)localObject3).k);
                localRelativeLayout.setTag(a(i1, (String)localObject4, (String)localObject5, ((StringBuilder)localObject6).toString()));
              }
            }
          }
        }
      }
      localObject1 = (TextView)localRelativeLayout.findViewById(2131432705);
      ((TextView)localObject1).setVisibility(8);
      if (paramQidianSimpleProfileItem.e == 2)
      {
        paramQidianSimpleProfileItem = this.g;
        if ((paramQidianSimpleProfileItem != null) && (!TextUtils.isEmpty(paramQidianSimpleProfileItem.mobile)))
        {
          ((TextView)localObject1).setVisibility(0);
          if (this.g.isExternalMobileVerified())
          {
            ((TextView)localObject1).setText(2131907307);
            ((TextView)localObject1).setTextColor(Color.parseColor("#7CE7C2"));
            ((TextView)localObject1).setBackgroundResource(2130845475);
            return localRelativeLayout;
          }
          ((TextView)localObject1).setText(2131907306);
          ((TextView)localObject1).setTextColor(Color.parseColor("#FFCD9C"));
          ((TextView)localObject1).setBackgroundResource(2130845474);
        }
      }
      return localRelativeLayout;
    }
    RelativeLayout localRelativeLayout = (RelativeLayout)getLayoutInflater().inflate(2131627178, this.d, false);
    Object localObject5 = (ImageView)localRelativeLayout.findViewById(2131437100);
    Object localObject1 = (TextView)localRelativeLayout.findViewById(2131438362);
    Object localObject2 = (TextView)localRelativeLayout.findViewById(2131429702);
    Object localObject3 = (ImageView)localRelativeLayout.findViewById(2131444825);
    Object localObject4 = (ImageView)localRelativeLayout.findViewById(2131438360);
    ((ImageView)localObject5).setImageResource(2130845845);
    localObject5 = this.I;
    if ((localObject5 != null) && (((QidianProfileUiInfo)localObject5).mConfigGroupInfos != null))
    {
      localObject5 = this.I.mConfigGroupInfos.iterator();
      if (((Iterator)localObject5).hasNext())
      {
        localObject6 = (QidianProfileUiInfo.ConfigGroupInfo)((Iterator)localObject5).next();
        if ((localObject6 != null) && (((QidianProfileUiInfo.ConfigGroupInfo)localObject6).a != null))
        {
          localObject6 = ((QidianProfileUiInfo.ConfigGroupInfo)localObject6).a.iterator();
          for (i2 = i1;; i2 = 11)
          {
            i1 = i2;
            if (!((Iterator)localObject6).hasNext()) {
              break;
            }
            Object localObject7 = (QidianProfileUiInfo.ConfigInfo)((Iterator)localObject6).next();
            if ((localObject7 != null) && ((((QidianProfileUiInfo.ConfigInfo)localObject7).l == i2) || (((QidianProfileUiInfo.ConfigInfo)localObject7).c.equals(HardCodeUtil.a(2131907423)))) && (((QidianProfileUiInfo.ConfigInfo)localObject7).h != null))
            {
              ((TextView)localObject1).setText(((QidianProfileUiInfo.ConfigInfo)localObject7).h.a);
              ((TextView)localObject2).setText(((QidianProfileUiInfo.ConfigInfo)localObject7).h.c);
              localRelativeLayout.setTag(a(paramQidianSimpleProfileItem.e, paramQidianSimpleProfileItem.a, ((QidianProfileUiInfo.ConfigInfo)localObject7).h.d, paramQidianSimpleProfileItem.f));
              this.Y = ((QidianProfileUiInfo.ConfigInfo)localObject7).h.d;
              localObject7 = this.g;
              if (localObject7 != null)
              {
                if (((QidianExternalInfo)localObject7).verity == 2) {
                  i1 = 1;
                } else {
                  i1 = 0;
                }
                if ((i1 != 0) && (!TextUtils.isEmpty(this.g.verify_url)) && (HttpUtil.isValidUrl(this.g.verify_url)))
                {
                  localObject7 = URLDrawable.URLDrawableOptions.obtain();
                  ((URLDrawable.URLDrawableOptions)localObject7).mLoadingDrawable = getResources().getDrawable(2130845840);
                  ((URLDrawable.URLDrawableOptions)localObject7).mFailedDrawable = getResources().getDrawable(2130845840);
                  ((URLDrawable.URLDrawableOptions)localObject7).mPlayGifImage = false;
                  ((URLDrawable.URLDrawableOptions)localObject7).mGifRoundCorner = 0.0F;
                  ((URLDrawable.URLDrawableOptions)localObject7).mRequestWidth = 20;
                  ((URLDrawable.URLDrawableOptions)localObject7).mRequestHeight = 20;
                  localObject7 = URLDrawable.getDrawable(this.g.verify_url, (URLDrawable.URLDrawableOptions)localObject7);
                  if (localObject4 != null)
                  {
                    ((ImageView)localObject4).setMaxWidth(20);
                    ((ImageView)localObject4).setMaxHeight(20);
                    ((ImageView)localObject4).setVisibility(0);
                    ((ImageView)localObject4).setImageDrawable((Drawable)localObject7);
                  }
                }
              }
            }
          }
        }
      }
    }
    if (!paramQidianSimpleProfileItem.c)
    {
      ((ImageView)localObject3).setVisibility(4);
      localRelativeLayout.setLongClickable(true);
      localRelativeLayout.setTag(paramQidianSimpleProfileItem.b);
      localRelativeLayout.setOnLongClickListener(this.Q);
      return localRelativeLayout;
    }
    localRelativeLayout.setClickable(true);
    localRelativeLayout.setOnClickListener(this.R);
    ((ImageView)localObject3).setVisibility(0);
    return localRelativeLayout;
  }
  
  public void a()
  {
    QQProgressDialog localQQProgressDialog = this.n;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.n.dismiss();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.n == null) {
      this.n = new QQProgressDialog(this, getResources().getDimensionPixelSize(2131299920));
    }
    this.n.setCanceledOnTouchOutside(true);
    this.n.c(paramInt);
    this.n.show();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.W == null) {
      this.W = new QQToastNotifier(this);
    }
    this.W.notifyUser(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  public void a(int paramInt, URLImageView paramURLImageView, String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramURLImageView == null) {
        return;
      }
      if ((!paramBoolean) && (this.i.containsKey(paramString)) && (this.i.get(paramString) != null))
      {
        paramURLImageView.setImageDrawable((Drawable)this.i.get(paramString));
        return;
      }
      Object localObject;
      if (paramInt == 0) {
        localObject = FaceDrawable.getFaceDrawable(this.app, 1, paramString);
      } else if ((paramInt != 1) && (paramInt != 2)) {
        localObject = this.app.getTroopFaceDrawable(paramString);
      } else {
        localObject = a(paramURLImageView, paramString);
      }
      if (localObject != null)
      {
        this.i.put(paramString, localObject);
        paramURLImageView.setImageDrawable((Drawable)localObject);
      }
    }
  }
  
  public void a(PublicAccountItem paramPublicAccountItem, int paramInt)
  {
    Object localObject = paramPublicAccountItem.g;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    if (this.w == null)
    {
      this.w = DialogUtil.a(this, 0, 2131627186, null, null, getString(2131887812), getString(2131887812), new QidianProfileCardActivity.23(this), null);
      this.w.setCanceledOnTouchOutside(true);
    }
    if (paramInt == 50) {
      paramInt = 2131896254;
    } else {
      paramInt = 2131896255;
    }
    this.w.setMessageCount(super.getString(paramInt));
    localObject = b((URLImageView)this.w.framePreviewImage, (String)localObject);
    this.w.setPreviewImage((Drawable)localObject, true, 1);
    if (this.w.getWindow() != null) {
      this.w.getWindow().findViewById(2131433674).setOnLongClickListener(new QidianProfileCardActivity.24(this, (Drawable)localObject, paramPublicAccountItem));
    }
    this.w.show();
  }
  
  public void a(String paramString)
  {
    if (this.K == null)
    {
      this.K = ((ActionSheet)ActionSheetHelper.b(this, null));
      this.K.addButton(super.getResources().getStringArray(2130968585)[0], 1);
      if ((this.m == 1) && (this.s.i(this.e.allInOne.uin))) {
        this.K.addButton(super.getResources().getStringArray(2130968585)[1]);
      }
      this.K.addCancelButton(super.getResources().getStringArray(2130968585)[2]);
      this.K.setOnButtonClickListener(new QidianProfileCardActivity.17(this, paramString));
    }
    this.K.show();
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QidianProfileCardActivity", 2, "enterNewPage content is null");
      }
      return;
    }
    Intent localIntent = new Intent(this, QidianProfileAllTextActivity.class);
    localIntent.putExtra("title", paramString1);
    localIntent.putExtra("content", paramString2);
    super.startActivity(localIntent);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    ThreadManager.post(new QidianProfileCardActivity.28(this, paramArrayOfByte), 8, null, true);
  }
  
  public Drawable b(URLImageView paramURLImageView, String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject2 = null;
    if (bool) {
      return null;
    }
    Object localObject1;
    try
    {
      localObject1 = URLDrawable.getDrawable(paramString);
    }
    catch (Exception localException)
    {
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getWeixinPAQrDrawable load net error, ");
        ((StringBuilder)localObject1).append(localException.getMessage());
        QLog.d("QidianProfileCardActivity", 4, ((StringBuilder)localObject1).toString());
        localObject1 = localObject2;
      }
    }
    if ((localObject1 != null) && (((URLDrawable)localObject1).getStatus() != 2))
    {
      if (((URLDrawable)localObject1).getStatus() == 1) {
        return localObject1;
      }
      paramURLImageView.setURLDrawableDownListener(new QidianProfileCardActivity.DrawableListener(this, this.app, paramURLImageView, paramString, getResources().getDrawable(2130853414), false));
      return localObject1;
    }
    return ImageUtil.j();
  }
  
  public void b(int paramInt)
  {
    Object localObject1;
    if (paramInt == 1) {
      localObject1 = this.app.getEntityManagerFactory().createEntityManager();
    }
    try
    {
      this.g = ((QidianExternalInfo)((EntityManager)localObject1).find(QidianExternalInfo.class, this.e.allInOne.uin));
      this.I = ((QidianProfileUiInfo)((EntityManager)localObject1).find(QidianProfileUiInfo.class, this.e.allInOne.uin));
      FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      this.e.card = localFriendsManager.f(this.e.allInOne.uin);
      if ((this.g != null) && (!TextUtils.isEmpty(this.g.masterUin))) {
        this.H = ((QidianCorpInfo)((EntityManager)localObject1).find(QidianCorpInfo.class, this.g.masterUin));
      }
      if (localObject1 == null) {
        break label304;
      }
      ((EntityManager)localObject1).close();
    }
    finally
    {
      if (localObject1 != null) {
        ((EntityManager)localObject1).close();
      }
    }
    if (paramInt == 6)
    {
      localObject1 = this.app.getEntityManagerFactory().createEntityManager();
      try
      {
        this.g = ((QidianExternalInfo)((EntityManager)localObject1).find(QidianExternalInfo.class, this.e.allInOne.uin));
        this.I = ((QidianProfileUiInfo)((EntityManager)localObject1).find(QidianProfileUiInfo.class, this.e.allInOne.uin));
        if (localObject1 != null) {
          ((EntityManager)localObject1).close();
        }
      }
      finally
      {
        if (localObject1 != null) {
          ((EntityManager)localObject1).close();
        }
      }
    }
    try
    {
      this.o = ((BmqqUserSimpleInfo)((EntityManager)localObject1).find(BmqqUserSimpleInfo.class, this.e.allInOne.uin));
      if (localObject1 != null) {
        ((EntityManager)localObject1).close();
      }
      label304:
      localObject1 = this.g;
      if (localObject1 != null) {
        ((QidianExternalInfo)localObject1).initList();
      }
      runOnUiThread(new QidianProfileCardActivity.8(this, paramInt));
      return;
    }
    finally
    {
      if (localObject1 != null) {
        ((EntityManager)localObject1).close();
      }
    }
  }
  
  public void b(String paramString)
  {
    this.J = ((ActionSheet)ActionSheetHelper.b(this, null));
    boolean bool;
    if (!this.g.isExternalMobileVerified())
    {
      this.J.addButton(super.getResources().getStringArray(2130968584)[4], 1);
      bool = true;
    }
    else
    {
      bool = false;
    }
    this.J.addButton(super.getResources().getStringArray(2130968584)[0], 1);
    if ((this.m == 1) && (this.s.i(this.e.allInOne.uin))) {
      this.J.addButton(super.getResources().getStringArray(2130968584)[1], 1);
    }
    this.J.addButton(super.getResources().getStringArray(2130968584)[2], 1);
    this.J.addCancelButton(super.getResources().getStringArray(2130968584)[3]);
    this.J.setOnButtonClickListener(new QidianProfileCardActivity.18(this, bool, paramString));
    this.J.show();
  }
  
  public boolean b()
  {
    boolean bool1 = QidianManager.a(this.l);
    boolean bool2 = true;
    if (bool1) {
      return true;
    }
    this.m = this.s.a(this.e.allInOne.uin, this.app);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initAccountType accountType: ");
      localStringBuilder.append(this.m);
      QLog.d("QidianProfileCardActivity", 2, localStringBuilder.toString());
    }
    int i1 = this.m;
    bool1 = bool2;
    if (i1 != 0)
    {
      bool1 = bool2;
      if (i1 != 1)
      {
        bool1 = bool2;
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if (i1 != 4)
            {
              bool1 = bool2;
              if (i1 == 6) {
                return bool1;
              }
            }
            else
            {
              a(2131893010);
              return true;
            }
          }
          else {
            CrmUtils.a(this, null, this.e.allInOne.uin, true, -1, true, -1);
          }
          bool1 = false;
        }
      }
    }
    return bool1;
  }
  
  public void c()
  {
    int i1 = this.m;
    if ((i1 != 1) && (i1 != 2) && (i1 != 0) && (i1 != 6)) {
      return;
    }
    this.y.removeAllViews();
    boolean bool2 = ProfilePAUtils.isPaTypeCanAddAsFriend(this.e.allInOne);
    boolean bool1;
    if (this.m == 6) {
      bool1 = true;
    } else {
      bool1 = ProfilePAUtils.isPaTypeCanTalk(this.e.allInOne);
    }
    boolean bool3 = ProfilePAUtils.isPaTypeCanFreeCall(this.e.allInOne);
    if (bool2) {
      a(2131890826, 2131627184, this.R).setTag(new DataTag(7, null));
    }
    if ((this.m == 1) && (this.s.i(this.e.allInOne.uin))) {
      a(2131896251, 2131627184, this.R).setTag(new DataTag(55, null));
    } else if ((this.m == 6) && (this.s.g(this.e.allInOne.uin))) {
      a(2131890851, 2131627184, this.R).setTag(new DataTag(20, null));
    } else if ((bool3) && (this.m != 6)) {
      a(2131890851, 2131627184, this.R).setTag(new DataTag(20, null));
    }
    if (bool1) {
      a(2131896682, 2131627183, this.R).setTag(new DataTag(8, Integer.valueOf(this.m)));
    }
  }
  
  public void c(int paramInt)
  {
    g(paramInt);
    h(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("QidianProfileCardActivity", 2, "Show finish");
    }
  }
  
  public void c(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("need_finish", true);
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).gotoProfile(localIntent, this.app, this, paramString, -1);
  }
  
  public void d()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    QidianProfileCardActivity.UiHandler localUiHandler = this.G;
    if (localUiHandler != null) {
      localUiHandler.sendMessage(localMessage);
    }
  }
  
  public void d(int paramInt)
  {
    Object localObject;
    if (paramInt == 1)
    {
      Intent localIntent = new Intent(getActivity(), ChatActivity.class);
      localIntent.addFlags(67108864);
      String str = this.e.allInOne.uin;
      if (this.t.n(str))
      {
        paramInt = 0;
        localObject = ContactUtils.c(this.app, str);
      }
      else
      {
        localObject = null;
        paramInt = 1025;
      }
      localIntent.putExtra("uin", str);
      localIntent.putExtra("uintype", paramInt);
      if (localObject != null) {
        localIntent.putExtra("uinname", (String)localObject);
      }
      startActivity(localIntent);
      return;
    }
    if (paramInt == 6)
    {
      localObject = new Intent(getActivity(), ChatActivity.class);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("uin", this.e.allInOne.uin);
      ((Intent)localObject).putExtra("uintype", 1024);
      startActivity((Intent)localObject);
      return;
    }
    ProfileBottomContainer.enterChat(this.app, this, this.e);
  }
  
  public void d(String paramString)
  {
    TroopUtils.a(this, TroopInfoUIUtil.a(paramString, 31), 2);
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
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      if (paramInt1 != 1000)
      {
        if (paramInt1 != 1012) {
          return;
        }
        if (paramIntent != null)
        {
          if (paramIntent.getBooleanExtra("finchat", false))
          {
            super.finish();
            return;
          }
          paramIntent = paramIntent.getStringExtra("remark");
          if (!com.tencent.mobileqq.util.Utils.a(this.e.allInOne.remark, paramIntent)) {
            h(paramIntent);
          }
        }
      }
      else
      {
        super.setResult(-1);
        super.finish();
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    this.mNeedStatusTrans = true;
    super.doOnCreate(paramBundle);
    this.L = ThemeUtil.isInNightMode(this.app);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("open profile card start ");
      paramBundle.append(System.currentTimeMillis());
      QLog.d("performance", 2, paramBundle.toString());
    }
    this.s = ((QidianManager)this.app.getManager(QQManagerFactory.QIDIAN_MANAGER));
    this.t = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER));
    this.u = ((CardHandler)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER));
    try
    {
      setContentView(2131627175);
      this.p = AIOUtils.b(16.0F, getResources());
      this.q = AIOUtils.b(10.0F, getResources());
      this.r = AIOUtils.b(8.0F, getResources());
      this.e.allInOne = ((AllInOne)super.getIntent().getParcelableExtra("AllInOne"));
      if (this.e.allInOne == null)
      {
        paramBundle = super.getIntent().getStringExtra("uin");
        this.e.allInOne = new AllInOne(paramBundle, 104);
      }
      this.l = super.getIntent().getIntExtra("cspecialflag", 0);
      if ((this.e.allInOne != null) && (this.e.allInOne.uin != null))
      {
        paramBundle = this.t;
        if ((paramBundle != null) && (paramBundle.n(this.e.allInOne.uin)) && (!this.e.allInOne.uin.equals(this.app.getCurrentAccountUin()))) {
          this.e.allInOne.pa = 1;
        }
        this.e.nameArray = new String[8];
        j();
        this.app.addObserver(this.P);
        this.app.addObserver(this.O);
        this.app.addObserver(this.V);
        this.app.addObserver(this.U);
        this.app.addObserver(this.S);
        this.app.addObserver(this.T);
        if (!b())
        {
          super.finish();
          return false;
        }
        this.G = new QidianProfileCardActivity.UiHandler(this);
        this.h = new ConcurrentHashMap();
        this.i = new ConcurrentHashMap();
        ThreadManager.post(new QidianProfileCardActivity.1(this), 8, null, true);
        e(this.m);
        k();
        q();
        f(this.m);
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append("open profile card end ");
          paramBundle.append(System.currentTimeMillis());
          QLog.d("performance", 2, paramBundle.toString());
        }
        return true;
      }
      super.finish();
      return false;
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
      finish();
    }
    return false;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    Dialog localDialog = this.j;
    if ((localDialog != null) && (localDialog.isShowing()))
    {
      this.j.dismiss();
      this.j = null;
    }
    this.app.removeObserver(this.P);
    this.app.removeObserver(this.O);
    this.app.removeObserver(this.U);
    this.app.removeObserver(this.S);
    this.app.removeObserver(this.T);
    this.app.removeObserver(this.V);
    j();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (paramIntent.getBooleanExtra("key_back_from_add_friend", false)) {
      doOnActivityResult(1000, -1, paramIntent);
    }
    AllInOne localAllInOne = (AllInOne)paramIntent.getParcelableExtra("AllInOne");
    if ((localAllInOne != null) && (localAllInOne.uin.equals(this.e.allInOne.uin))) {
      e(this.m);
    }
    if ((localAllInOne != null) && (!localAllInOne.uin.equals(this.e.allInOne.uin)))
    {
      startActivity(paramIntent);
      super.finish();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    i(this.e.allInOne.uin);
  }
  
  public void e()
  {
    if (this.e == null) {
      return;
    }
    Intent localIntent = new Intent(this, ProfileCardMoreActivity.class);
    if (TextUtils.isEmpty(this.X))
    {
      localObject = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).m(this.e.allInOne.uin);
      if ((localObject != null) && (!TextUtils.isEmpty(((Friends)localObject).name)))
      {
        this.X = ((Friends)localObject).name;
      }
      else
      {
        localObject = this.g;
        if (localObject != null) {
          this.X = ((QidianExternalInfo)localObject).nickname;
        }
      }
    }
    localIntent.putExtra("key_nick_name", this.X);
    if (this.m == 6) {
      localIntent.putExtra("key_qidian_detail_url", this.Y);
    }
    Object localObject = BusinessCardUtils.a(this.app, this.e);
    localIntent = ProfileCardUtil.a(localIntent, this.e.allInOne.uin, this.app, this.e.allInOne, (BusinessCard)localObject);
    localIntent.addFlags(536870912);
    super.startActivityForResult(localIntent, 1012);
  }
  
  public void e(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mailto:");
    localStringBuilder.append(paramString);
    super.startActivity(new Intent("android.intent.action.SENDTO", Uri.parse(localStringBuilder.toString())));
  }
  
  public void f()
  {
    QidianExternalInfo localQidianExternalInfo = this.g;
    if ((localQidianExternalInfo != null) && (!TextUtils.isEmpty(localQidianExternalInfo.masterUin)) && (this.e.allInOne != null) && (!TextUtils.isEmpty(this.e.allInOne.uin)))
    {
      CrmUtils.b(this.app, this, this.g.masterUin, this.e.allInOne.uin);
      return;
    }
    a(2131890882, 1);
  }
  
  public void f(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("tel:");
      localStringBuilder.append(paramString);
      super.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(localStringBuilder.toString())));
    }
  }
  
  public void g()
  {
    getIntent().putExtra("param_return_addr", QidianProfileCardActivity.class.getName());
    if (this.g != null) {
      this.e.profileName.a.b = this.g.nickname;
    }
    ProfileBottomContainer.addFriend(this.app, this, this.e, this.j);
  }
  
  public void g(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("smsto:");
      localStringBuilder.append(paramString);
      super.startActivity(new Intent("android.intent.action.SENDTO", Uri.parse(localStringBuilder.toString())));
    }
  }
  
  public List<PublicAccountItem> h()
  {
    if (this.m == 6) {
      return this.g.getPublicAccountItemsCorp();
    }
    return this.g.getPublicAccountItemsUser();
  }
  
  public List<GroupItem> i()
  {
    if (this.m == 6) {
      return this.g.getGroupItemsCorp();
    }
    return this.g.getGroupItemsUser();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 21))
    {
      Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
      localIntent.putExtras(new Bundle(paramIntent.getExtras()));
      startActivity(localIntent);
      finish();
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(1);
    getWindow().setFormat(-3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity
 * JD-Core Version:    0.7.0.1
 */