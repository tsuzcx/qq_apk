package com.tencent.mobileqq.mini.mainpage;

import NS_COMM.COMM.StCommonExt;
import adky;
import alpo;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import aokd;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivityForMini;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.monitor.service.TaskMonitorManager;
import com.tencent.mobileqq.mini.out.activity.PermissionSettingFragment;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppException;
import com.tencent.mobileqq.mini.share.MiniArkShareModelBuilder;
import com.tencent.mobileqq.mini.share.MiniProgramShareUtils;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class MainPageFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  private static final String LIKE_NUM_POSTFIX = alpo.a(2131706816);
  public static final String TAG = "MainPageFragment";
  private boolean isLike;
  private boolean isMiniGame;
  private ImageView mAppIcon;
  private TextView mAppName;
  private TextView mBackTextView;
  private ImageView mBackView;
  private View mComplainCallbackContainer;
  private Button mEnterMiniAppBtn;
  private TextView mIntroduction;
  private ImageView mLikeBtn;
  private View mLikeContainer;
  private COMM.StCommonExt mLikeExtInfo;
  private TextView mLikeNum;
  private int mLikeNumber;
  private View.OnLongClickListener mLongClickListener = new MainPageFragment.7(this);
  private MiniAppConfig mMiniAppConfig;
  private MiniAppDialog mMiniAppDialog;
  private MiniAppInfo mMiniAppInfo;
  private ImageView mMoreView;
  private Button mRecommendMiniAppBtn;
  private View mRelativePublicAccountContainer;
  private View mSeparator;
  private Switch mSetTopSwitch;
  private TextView mSetTopText;
  private COMM.StCommonExt mTopExtInfo;
  
  /* Error */
  private android.graphics.drawable.Drawable getIconDrawable(String paramString)
  {
    // Byte code:
    //   0: invokestatic 125	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   3: astore_3
    //   4: aload_3
    //   5: iconst_0
    //   6: putfield 128	com/tencent/image/URLDrawable$URLDrawableOptions:mPlayGifImage	Z
    //   9: ldc 129
    //   11: invokestatic 135	bdkf:b	(F)I
    //   14: istore_2
    //   15: aload_3
    //   16: iload_2
    //   17: putfield 138	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestHeight	I
    //   20: aload_3
    //   21: iload_2
    //   22: putfield 141	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestWidth	I
    //   25: getstatic 146	android/os/Build$VERSION:SDK_INT	I
    //   28: bipush 21
    //   30: if_icmplt +29 -> 59
    //   33: aload_3
    //   34: aload_0
    //   35: invokevirtual 150	com/tencent/mobileqq/mini/mainpage/MainPageFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   38: ldc 151
    //   40: invokevirtual 157	android/support/v4/app/FragmentActivity:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   43: putfield 161	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
    //   46: aload_3
    //   47: aload_0
    //   48: invokevirtual 150	com/tencent/mobileqq/mini/mainpage/MainPageFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   51: ldc 151
    //   53: invokevirtual 157	android/support/v4/app/FragmentActivity:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   56: putfield 164	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   59: aload_1
    //   60: aload_3
    //   61: invokestatic 169	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   64: astore_3
    //   65: aload_3
    //   66: iload_2
    //   67: iload_2
    //   68: ldc 170
    //   70: invokestatic 135	bdkf:b	(F)I
    //   73: invokestatic 175	bcuq:b	(III)[I
    //   76: invokevirtual 179	com/tencent/image/URLDrawable:setTag	(Ljava/lang/Object;)V
    //   79: aload_3
    //   80: getstatic 183	bcuq:i	Lcom/tencent/image/DownloadParams$DecodeHandler;
    //   83: invokevirtual 187	com/tencent/image/URLDrawable:setDecodeHandler	(Lcom/tencent/image/DownloadParams$DecodeHandler;)V
    //   86: aload_3
    //   87: astore 4
    //   89: aload 4
    //   91: areturn
    //   92: astore 4
    //   94: ldc 11
    //   96: iconst_1
    //   97: ldc 189
    //   99: invokestatic 195	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   102: aload 4
    //   104: invokevirtual 198	java/lang/Exception:printStackTrace	()V
    //   107: goto -48 -> 59
    //   110: astore 4
    //   112: aconst_null
    //   113: astore_3
    //   114: aload 4
    //   116: invokevirtual 198	java/lang/Exception:printStackTrace	()V
    //   119: aload_3
    //   120: astore 4
    //   122: invokestatic 202	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   125: ifeq -36 -> 89
    //   128: ldc 11
    //   130: iconst_2
    //   131: new 204	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   138: ldc 207
    //   140: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload_1
    //   144: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokestatic 195	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   153: aload_3
    //   154: areturn
    //   155: astore 4
    //   157: goto -43 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	MainPageFragment
    //   0	160	1	paramString	String
    //   14	54	2	i	int
    //   3	151	3	localObject1	Object
    //   87	3	4	localObject2	Object
    //   92	11	4	localException1	java.lang.Exception
    //   110	5	4	localException2	java.lang.Exception
    //   120	1	4	localObject3	Object
    //   155	1	4	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   25	59	92	java/lang/Exception
    //   59	65	110	java/lang/Exception
    //   65	86	155	java/lang/Exception
  }
  
  public static String getUin()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject != null)
    {
      localObject = ((AppRuntime)localObject).getAccount();
      QLog.i("CommonDataAdapter", 2, "get uin from app runtim succ:" + (String)localObject);
      return localObject;
    }
    return null;
  }
  
  private void handleMoreButtonEvent()
  {
    this.mMiniAppDialog = new MiniAppDialog(getActivity());
    this.mMiniAppDialog.setContentView(LayoutInflater.from(getActivity()).inflate(2131562162, null));
    TextView localTextView = (TextView)this.mMiniAppDialog.findViewById(2131370623);
    localTextView.setText(alpo.a(2131706808));
    localTextView.setOnClickListener(this);
    localTextView = (TextView)this.mMiniAppDialog.findViewById(2131370617);
    localTextView.setText(alpo.a(2131706803));
    localTextView.setVisibility(0);
    localTextView.setOnClickListener(this);
    ((TextView)this.mMiniAppDialog.findViewById(2131370599)).setOnClickListener(this);
    this.mMiniAppDialog.show();
  }
  
  private void initData()
  {
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      this.mMiniAppConfig = ((MiniAppConfig)localBundle.getParcelable("app_config"));
      if ((this.mMiniAppConfig != null) && (this.mMiniAppConfig.config != null))
      {
        this.mMiniAppInfo = this.mMiniAppConfig.config;
        if (QLog.isColorLevel()) {
          QLog.d("MainPageFragment", 2, "initData : miniAppConfig = " + this.mMiniAppConfig.toString());
        }
      }
      this.isMiniGame = localBundle.getBoolean("isMiniGame");
    }
  }
  
  private void initUI()
  {
    if (this.mMiniAppInfo != null)
    {
      if (!TextUtils.isEmpty(this.mMiniAppInfo.iconUrl)) {
        this.mAppIcon.setImageDrawable(getIconDrawable(this.mMiniAppInfo.iconUrl));
      }
      this.mAppName.setText(this.mMiniAppInfo.name);
      this.mIntroduction.setText(this.mMiniAppInfo.desc);
      boolean bool = this.mMiniAppInfo.isAppStoreMiniApp();
      if ((bool) || (this.mMiniAppInfo.isLimitedAccessApp()))
      {
        if (getView() != null)
        {
          View localView = getView().findViewById(2131376453);
          if (localView != null) {
            localView.setVisibility(8);
          }
        }
        if (bool)
        {
          this.mRecommendMiniAppBtn.setVisibility(8);
          if (this.mSeparator != null) {
            this.mSeparator.setVisibility(8);
          }
        }
      }
    }
    if (this.isMiniGame)
    {
      this.mSetTopText.setText(alpo.a(2131706807));
      this.mRecommendMiniAppBtn.setText(alpo.a(2131706810));
      this.mEnterMiniAppBtn.setText(alpo.a(2131706806));
      this.mLikeNum.setText(alpo.a(2131706812));
      return;
    }
    if (aokd.g()) {
      this.mSetTopText.setText(alpo.a(2131706807));
    }
    this.mLikeNum.setText(alpo.a(2131706815));
  }
  
  public static void launch(Context paramContext, MiniAppConfig paramMiniAppConfig, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("app_config", paramMiniAppConfig);
    localIntent.putExtra("versionType", paramInt);
    adky.a(paramContext, localIntent, PublicFragmentActivityForMini.class, MainPageFragment.class);
  }
  
  public static void launchForMiniGame(Context paramContext, MiniAppConfig paramMiniAppConfig, int paramInt, boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("app_config", paramMiniAppConfig);
    localIntent.putExtra("versionType", paramInt);
    localIntent.putExtra("isMiniGame", paramBoolean);
    adky.a(paramContext, localIntent, PublicFragmentActivityForMini.class, MainPageFragment.class);
  }
  
  private void reportClick(String paramString)
  {
    MiniProgramLpReportDC04239.reportUserClick(this.mMiniAppConfig, MiniProgramLpReportDC04239.getAppType(this.mMiniAppConfig), null, "user_click", "more_about", paramString);
  }
  
  private void sendGetUserAppInfoRequest()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.mMiniAppInfo.appId);
    update(this.mMiniAppInfo);
    MiniAppCmdUtil.getInstance().getUserAppInfo(localArrayList, new MainPageFragment.2(this));
  }
  
  private void sendSetUserAppLikeRequest(boolean paramBoolean)
  {
    MiniAppCmdUtil.getInstance().setUserAppLike(paramBoolean, this.mLikeExtInfo, this.mMiniAppInfo.appId, new MainPageFragment.5(this));
  }
  
  private void setLikeNum()
  {
    if (this.isLike)
    {
      this.isLike = false;
      this.mLikeNumber -= 1;
      updateLikeNum(this.mLikeNumber);
      updateLikeState(this.isLike);
      sendSetUserAppLikeRequest(this.isLike);
      if (!this.isLike) {
        break label81;
      }
    }
    label81:
    for (String str = "like_on";; str = "like_off")
    {
      reportClick(str);
      return;
      this.isLike = true;
      this.mLikeNumber += 1;
      break;
    }
  }
  
  private void setMiniAppTop(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null)
    {
      QLog.e("MainPageFragment", 1, "setMiniAppTop, miniAppInfo = null");
      return;
    }
    MiniAppCmdUtil.getInstance().setUserAppTop(paramMiniAppInfo.appId, paramMiniAppInfo.topType, paramMiniAppInfo.verType, this.mTopExtInfo, new MainPageFragment.4(this));
  }
  
  private void setTopType(MiniAppInfo paramMiniAppInfo)
  {
    int i;
    if (paramMiniAppInfo.topType == 0)
    {
      i = 1;
      paramMiniAppInfo.topType = i;
      updateTopTypeState(paramMiniAppInfo);
      sendSetUserAppTopRequest(paramMiniAppInfo);
      if (paramMiniAppInfo.topType != 0) {
        break label46;
      }
    }
    label46:
    for (paramMiniAppInfo = "settop_off";; paramMiniAppInfo = "settop_on")
    {
      reportClick(paramMiniAppInfo);
      return;
      i = 0;
      break;
    }
  }
  
  private void startComplainAndCallback()
  {
    if (this.mMiniAppInfo == null)
    {
      QLog.e("MainPageFragment", 1, "startComplainAndCallback, mApkgConfig = " + this.mMiniAppInfo);
      return;
    }
    Object localObject1 = "";
    try
    {
      localObject2 = URLEncoder.encode("https://support.qq.com/data/1368/2018/0927/5e6c84b68d1f3ad390e7beeb6c2f83b0.jpeg", "UTF-8");
      localObject1 = localObject2;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        Object localObject2;
        QLog.e("MainPageFragment", 1, "startComplainAndCallback, url = " + "");
        localUnsupportedEncodingException.printStackTrace();
      }
    }
    localObject2 = "https://tucao.qq.com/qq_miniprogram/tucao?appid=" + this.mMiniAppInfo.appId + "&openid=" + getUin() + "&avatar=" + (String)localObject1 + alpo.a(2131706818);
    localObject1 = new Intent(getActivity(), QQBrowserActivity.class);
    ((Intent)localObject1).putExtra("url", (String)localObject2);
    localObject2 = new Bundle();
    ((Bundle)localObject2).putBoolean("hide_more_button", true);
    ((Intent)localObject1).putExtras((Bundle)localObject2);
    startActivity((Intent)localObject1);
    reportClick("feedback");
    QLog.d("MainPageFragment", 2, "feedback, prepare to upload log ");
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("appid", this.mMiniAppInfo.appId);
    QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", "upload_user_log", (Bundle)localObject1, new MainPageFragment.6(this));
  }
  
  private void startMiniApp()
  {
    try
    {
      MiniAppController.launchMiniAppByAppInfo(getActivity(), this.mMiniAppInfo, 1024);
      return;
    }
    catch (MiniAppException localMiniAppException)
    {
      QLog.e("MainPageFragment", 1, "startMiniApp is failed !!!");
      localMiniAppException.printStackTrace();
    }
  }
  
  private void startMoreInformation()
  {
    if (this.mMiniAppInfo == null)
    {
      QLog.e("MainPageFragment", 1, "startMoreInformation, miniAppInfo = " + this.mMiniAppInfo);
      return;
    }
    Object localObject = "https://q.qq.com/os/store/details-more?appid=" + this.mMiniAppInfo.appId;
    Intent localIntent = new Intent(getActivity(), QQBrowserActivity.class);
    localIntent.putExtra("url", (String)localObject);
    localObject = new Bundle();
    ((Bundle)localObject).putBoolean("hide_more_button", true);
    localIntent.putExtras((Bundle)localObject);
    startActivity(localIntent);
  }
  
  private void startRecommendMiniApp()
  {
    if (this.mMiniAppInfo != null) {
      MiniProgramShareUtils.shareAsArkMessage(getActivity(), new MiniArkShareModelBuilder().setAppId(this.mMiniAppInfo.appId).setTitle(this.mMiniAppInfo.name).setDescription(this.mMiniAppInfo.desc).setShareScene(0).setShareTemplateType(0).setShareBusinessType(this.mMiniAppInfo.getReportType()).setPicUrl(this.mMiniAppInfo.iconUrl).setVidUrl(null).setIconUrl(this.mMiniAppInfo.iconUrl).setVersionType(this.mMiniAppInfo.verType).setVersionId(this.mMiniAppInfo.versionId).createMiniArkShareModel(), false, 10);
    }
  }
  
  private void update(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return;
    }
    if (!TextUtils.isEmpty(this.mMiniAppInfo.iconUrl)) {
      this.mAppIcon.setImageDrawable(getIconDrawable(this.mMiniAppInfo.iconUrl));
    }
    if (!TextUtils.isEmpty(this.mMiniAppInfo.name)) {
      this.mAppName.setText(this.mMiniAppInfo.name);
    }
    if (!TextUtils.isEmpty(this.mMiniAppInfo.desc)) {
      this.mIntroduction.setText(this.mMiniAppInfo.desc);
    }
    updateTopTypeState(paramMiniAppInfo);
  }
  
  private void updateLikeNum(int paramInt)
  {
    if (!this.isLike) {
      if (this.isMiniGame) {
        this.mLikeNum.setText(alpo.a(2131706804));
      }
    }
    while (paramInt <= 0)
    {
      return;
      this.mLikeNum.setText(alpo.a(2131706817));
      return;
    }
    if (paramInt > 9999)
    {
      float f = paramInt / 10000.0F;
      this.mLikeNum.setText(String.format("%.2f", new Object[] { Float.valueOf(f) }) + alpo.a(2131706814) + LIKE_NUM_POSTFIX);
      return;
    }
    this.mLikeNum.setText(paramInt + LIKE_NUM_POSTFIX);
  }
  
  private void updateLikeState(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mLikeBtn.setImageResource(2130840898);
      return;
    }
    this.mLikeBtn.setImageResource(2130840925);
  }
  
  private void updateTopTypeState(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo.topType == 0)
    {
      this.mSetTopSwitch.setChecked(false);
      return;
    }
    this.mSetTopSwitch.setChecked(true);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131370621: 
    default: 
    case 2131370602: 
    case 2131370609: 
    case 2131370622: 
    case 2131370620: 
    case 2131370596: 
    case 2131370626: 
    case 2131370627: 
    case 2131370623: 
      do
      {
        return;
        startMiniApp();
        reportClick("launch");
        return;
        setLikeNum();
        return;
        setTopType(this.mMiniAppInfo);
        return;
        startRecommendMiniApp();
        reportClick("share");
        return;
        startComplainAndCallback();
        return;
        getActivity().finish();
        return;
        handleMoreButtonEvent();
        return;
      } while ((this.mMiniAppInfo == null) || (TextUtils.isEmpty(this.mMiniAppInfo.appId)));
      PermissionSettingFragment.launchForResult(getActivity(), this.mMiniAppInfo.appId, this.mMiniAppInfo.name, 5);
      this.mMiniAppDialog.dismiss();
      reportClick("set");
      return;
    case 2131370617: 
      startMoreInformation();
      this.mMiniAppDialog.dismiss();
      reportClick("profile");
      return;
    }
    this.mMiniAppDialog.dismiss();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = LayoutInflater.from(getActivity()).inflate(2131562163, null);
    if (Build.VERSION.SDK_INT >= 23)
    {
      getActivity().getWindow().clearFlags(67108864);
      getActivity().getWindow().addFlags(-2147483648);
      getActivity().getWindow().setStatusBarColor(-1);
      ImmersiveUtils.a(true, getActivity().getWindow());
    }
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramLayoutInflater.setFitsSystemWindows(true);
      paramLayoutInflater.setPadding(0, ImmersiveUtils.getStatusBarHeight(getActivity()), 0, 0);
    }
    initData();
    return paramLayoutInflater;
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    TaskMonitorManager.g().switchPerfmPage(getClass().getSimpleName(), true);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.mAppIcon = ((ImageView)paramView.findViewById(2131370612));
    this.mAppIcon.setOnLongClickListener(this.mLongClickListener);
    this.mAppName = ((TextView)paramView.findViewById(2131370618));
    this.mIntroduction = ((TextView)paramView.findViewById(2131370598));
    this.mLikeNum = ((TextView)paramView.findViewById(2131370611));
    this.mLikeBtn = ((ImageView)paramView.findViewById(2131370610));
    this.mSetTopSwitch = ((Switch)paramView.findViewById(2131370622));
    this.mRecommendMiniAppBtn = ((Button)paramView.findViewById(2131370620));
    this.mEnterMiniAppBtn = ((Button)paramView.findViewById(2131370602));
    this.mRelativePublicAccountContainer = paramView.findViewById(2131370621);
    this.mComplainCallbackContainer = paramView.findViewById(2131370596);
    this.mLikeContainer = paramView.findViewById(2131370609);
    this.mBackView = ((ImageView)paramView.findViewById(2131370626));
    this.mMoreView = ((ImageView)paramView.findViewById(2131370627));
    this.mSetTopText = ((TextView)paramView.findViewById(2131376454));
    this.mSeparator = paramView.findViewById(2131368559);
    this.mSetTopSwitch.setOnClickListener(this);
    this.mRecommendMiniAppBtn.setOnClickListener(this);
    this.mEnterMiniAppBtn.setOnClickListener(this);
    this.mRelativePublicAccountContainer.setOnClickListener(this);
    this.mComplainCallbackContainer.setOnClickListener(this);
    this.mComplainCallbackContainer.setOnLongClickListener(new MainPageFragment.1(this));
    this.mBackView.setOnClickListener(this);
    this.mMoreView.setOnClickListener(this);
    this.mLikeContainer.setOnClickListener(this);
    initUI();
    sendGetUserAppInfoRequest();
  }
  
  public void sendSetUserAppTopRequest(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MainPageFragment", 1, "sendSetUserAppTopRequest, miniAppInfo = " + this.mMiniAppInfo);
      }
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("appid", paramMiniAppInfo.appId);
    localBundle.putInt("topType", paramMiniAppInfo.topType);
    localBundle.putInt("verType", paramMiniAppInfo.verType);
    QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", "sync_mini_app_data", localBundle, new MainPageFragment.3(this, paramMiniAppInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.mainpage.MainPageFragment
 * JD-Core Version:    0.7.0.1
 */