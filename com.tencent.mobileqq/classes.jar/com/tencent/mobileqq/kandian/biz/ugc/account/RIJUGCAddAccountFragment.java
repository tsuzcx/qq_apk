package com.tencent.mobileqq.kandian.biz.ugc.account;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJStringUtils;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.detail.ReadInJoyArticleDetailActivity;
import com.tencent.mobileqq.kandian.biz.ugc.constant.IRIJUGCAddAccountFragmentConst;
import com.tencent.mobileqq.kandian.biz.viola.view.ViolaLazyFragment;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.kandian.repo.xtab.api.impl.RIJXTabConfigHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class RIJUGCAddAccountFragment
  extends ViolaLazyFragment
  implements IRIJUGCAddAccountFragmentConst
{
  static int a = 1;
  static int b = 2;
  static int c = 3;
  private static String d = "RIJUGCAddAccountFragment";
  private static boolean f;
  private static boolean g;
  private RIJUGCPopupPtsLiteBuilder e;
  
  static ReadInJoyUserInfo a(long paramLong)
  {
    return ReadInJoyUserInfoModule.a(paramLong, null);
  }
  
  static String a()
  {
    ReadInJoyUserInfo localReadInJoyUserInfo = a(RIJQQAppInterfaceUtil.c());
    String str = ReadInJoyUserInfoModule.d();
    if (localReadInJoyUserInfo == null)
    {
      QLog.d(d, 2, "RIJUGCAddAccountFragment getNickName getReadInJoyUserInfoByUin is null! ");
      return RIJStringUtils.a(str);
    }
    return RIJStringUtils.a(localReadInJoyUserInfo.nick);
  }
  
  static void a(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = RIJTransMergeKanDianReport.d();
      localJSONObject.put("uin", RIJQQAppInterfaceUtil.c());
      localJSONObject.put("click_area", paramInt);
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X800AD89", "0X800AD89", 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      String str = d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RIJUGCAddAccountFragment ugcAddAccountClickReport exception: ");
      localStringBuilder.append(localJSONException.getMessage());
      QLog.e(str, 2, localStringBuilder.toString());
    }
  }
  
  static void a(Context paramContext)
  {
    boolean bool;
    if (a(RIJQQAppInterfaceUtil.c()) != null) {
      bool = true;
    } else {
      bool = false;
    }
    f = bool;
    c(paramContext);
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    ViewGroup localViewGroup1 = (ViewGroup)paramViewGroup.findViewById(2131449027);
    ViewGroup localViewGroup2 = (ViewGroup)paramViewGroup.findViewById(2131449028);
    Object localObject1 = (KandianUrlImageView)paramViewGroup.findViewById(2131436639);
    Object localObject2 = (KandianUrlImageView)paramViewGroup.findViewById(2131436640);
    paramViewGroup = ((KandianUrlImageView)localObject2).getLayoutParams();
    if ((paramViewGroup instanceof ViewGroup.MarginLayoutParams))
    {
      ((ViewGroup.MarginLayoutParams)paramViewGroup).topMargin = (ImmersiveUtils.getStatusBarHeight(getQBaseActivity()) + (getResources().getDimensionPixelSize(2131299920) - AIOUtils.b(19.5F, getResources())) / 2);
      ((KandianUrlImageView)localObject2).setLayoutParams(paramViewGroup);
    }
    paramViewGroup = (ViewGroup.MarginLayoutParams)((KandianUrlImageView)localObject1).getLayoutParams();
    int i;
    if (RIJXTabConfigHandler.INSTANCE.isXTabMode()) {
      i = paramViewGroup.leftMargin + AIOUtils.b(6.0F, getResources());
    } else {
      i = paramViewGroup.leftMargin;
    }
    paramViewGroup.leftMargin = i;
    ((KandianUrlImageView)localObject1).setLayoutParams(paramViewGroup);
    if (RIJXTabConfigHandler.INSTANCE.isXTabMode()) {
      i = 8;
    } else {
      i = 0;
    }
    ((KandianUrlImageView)localObject2).setVisibility(i);
    for (;;)
    {
      try
      {
        if (!RIJXTabConfigHandler.INSTANCE.isXTabMode()) {
          break label297;
        }
        paramViewGroup = "https://pub.idqqimg.com/pc/misc/files/20201030/894f73da508f4e45b4defab92dfa40c2.png";
        ReadInJoyDisplayUtils.a((KandianUrlImageView)localObject1, new URL(paramViewGroup), getQBaseActivity());
        ReadInJoyDisplayUtils.a((KandianUrlImageView)localObject2, new URL("https://pub.idqqimg.com/pc/misc/files/20200430/eb40275894c9455f9ab438dd91081678.png"), getQBaseActivity());
      }
      catch (MalformedURLException paramViewGroup)
      {
        localObject1 = d;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[initView] error, e = ");
        ((StringBuilder)localObject2).append(paramViewGroup);
        QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      }
      this.e = new RIJUGCPopupPtsLiteBuilder(getQBaseActivity(), localViewGroup2);
      localViewGroup1.setOnClickListener(new RIJUGCAddAccountFragment.1(this));
      return;
      label297:
      paramViewGroup = "https://pub.idqqimg.com/pc/misc/files/20200430/21b88f2ba3bd43919173a767982d649d.png";
    }
  }
  
  static void b()
  {
    try
    {
      JSONObject localJSONObject = RIJTransMergeKanDianReport.d();
      localJSONObject.put("uin", RIJQQAppInterfaceUtil.c());
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X800AD87", "0X800AD87", 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      String str = d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RIJUGCAddAccountFragment ugcAddAccountExposureReport exception: ");
      localStringBuilder.append(localJSONException.getMessage());
      QLog.e(str, 2, localStringBuilder.toString());
    }
  }
  
  static void b(Context paramContext)
  {
    if (TextUtils.isEmpty(RIJQQAppInterfaceUtil.d()))
    {
      QLog.e(d, 2, "editUGCAccount , but uin is empty !");
      g = false;
      return;
    }
    g = true;
    Bundle localBundle = new Bundle();
    localBundle.putString("url", "https://kandian.qq.com/mqq/vue/mainProfile?_wv=3&_bid=3302&source=2");
    localBundle.putBoolean("hide_operation_bar", true);
    localBundle.putString("from", String.valueOf(53));
    Intent localIntent = new Intent(paramContext, ReadInJoyArticleDetailActivity.class);
    localIntent.putExtras(localBundle);
    if ((paramContext instanceof Activity)) {
      ((Activity)paramContext).startActivityForResult(localIntent, 10000);
    }
  }
  
  public static void c()
  {
    ThreadManager.executeOnFileThread(new RIJUGCAddAccountFragment.2());
  }
  
  private static void c(@NonNull Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_ugc_account_create", f);
    localIntent.putExtra("key_ugc_account_edit", g);
    if ((paramContext instanceof Activity)) {
      ((Activity)paramContext).setResult(-1, localIntent);
    }
  }
  
  private void e()
  {
    a(a);
    a(getQBaseActivity());
    getQBaseActivity().finish();
  }
  
  public void doOnBackPressed()
  {
    if (getQBaseActivity() != null) {
      e();
    }
  }
  
  public int getContentViewId()
  {
    return 2131626346;
  }
  
  public void initAfterVisible(Bundle paramBundle, ViewGroup paramViewGroup)
  {
    hideTitleBar();
    setStatusBarImmersive();
    a(paramViewGroup);
    b();
  }
  
  public void initBeforeVisible(Bundle paramBundle) {}
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 10000) && (paramInt2 == -1))
    {
      c(getQBaseActivity());
      getQBaseActivity().finish();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.e.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.account.RIJUGCAddAccountFragment
 * JD-Core Version:    0.7.0.1
 */