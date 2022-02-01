package cooperation.qqlive;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivityForTool;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftServiceModule;
import com.tencent.mobileqq.qqgift.api.view.IQQGiftViewModule;
import com.tencent.mobileqq.qqgift.data.service.GiftListData;
import com.tencent.mobileqq.qqgift.data.service.GiftSendReqData;
import com.tencent.mobileqq.qqgift.data.service.GiftServiceData;
import com.tencent.mobileqq.qqgift.mvvm.business.data.QQGiftDtParams;
import com.tencent.mobileqq.qqgift.mvvm.business.view.IQQGiftPanelView;
import com.tencent.mobileqq.qqgift.mvvm.business.view.IQQGiftPanelView.OnPanelEventListener;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.ilive.lite.event.IliveLiteEventCenter;
import cooperation.qqlive.data.QQLiveAudienceGiftData;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

public class QQLiveAudienceGiftFragment
  extends QPublicBaseFragment
  implements IQQGiftPanelView.OnPanelEventListener
{
  private IQQGiftSDK a;
  private IQQGiftPanelView b;
  private View c;
  private QQLiveAudienceGiftData d;
  
  public static void a(Context paramContext, QQLiveAudienceGiftData paramQQLiveAudienceGiftData)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("extra_gift_data", paramQQLiveAudienceGiftData);
    int i = 1;
    localIntent.putExtra("public_fragment_window_feature", 1);
    if (MobileQQ.sProcessId != 7) {
      i = 0;
    }
    if (i != 0) {
      paramQQLiveAudienceGiftData = QPublicTransFragmentActivityForTool.class;
    } else {
      paramQQLiveAudienceGiftData = QPublicTransFragmentActivity.class;
    }
    QPublicFragmentActivity.Launcher.a(paramContext, localIntent, paramQQLiveAudienceGiftData, QQLiveAudienceGiftFragment.class, 999);
  }
  
  private void a(GiftServiceData paramGiftServiceData)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
    {
      localFragmentActivity.setResult(-1);
      Bundle localBundle = new Bundle();
      GiftMessage localGiftMessage = new GiftMessage();
      localGiftMessage.effectLevel = paramGiftServiceData.e;
      localGiftMessage.giftID = paramGiftServiceData.a;
      localGiftMessage.giftName = paramGiftServiceData.b;
      localGiftMessage.materialID = paramGiftServiceData.g;
      localGiftMessage.giftType = paramGiftServiceData.d;
      localGiftMessage.giftNum = paramGiftServiceData.h;
      localGiftMessage.sender = this.d.d;
      localGiftMessage.senderHead = this.d.f;
      localGiftMessage.senderNick = this.d.b;
      localGiftMessage.receiverNick = this.d.g;
      localGiftMessage.receiverHead = this.d.h;
      localGiftMessage.allComboCnt = paramGiftServiceData.n;
      localGiftMessage.comboSeq = paramGiftServiceData.m;
      localGiftMessage.receiver = this.d.e;
      localBundle.putParcelable("intent_extra_gift_message", localGiftMessage);
      IliveLiteEventCenter.a().a("ACTION_ROOM_RECEIVE_GIFT", localBundle);
      if ((this.b != null) && (paramGiftServiceData.d == 1) && (paramGiftServiceData.e == 1))
      {
        this.b.b();
        ThreadManagerV2.getUIHandlerV2().postDelayed(new QQLiveAudienceGiftFragment.3(this, localFragmentActivity), 500L);
      }
    }
  }
  
  private boolean b(GiftServiceData paramGiftServiceData)
  {
    if (paramGiftServiceData == null)
    {
      QLog.e("QQLiveAudienceGiftActivity", 1, "doBeforeSendGift data is null!");
      return true;
    }
    Object localObject = new GiftSendReqData();
    ((GiftSendReqData)localObject).a = this.d.d;
    ((GiftSendReqData)localObject).b = this.d.e;
    ((GiftSendReqData)localObject).f.put("room_id", String.valueOf(this.d.c));
    ((GiftSendReqData)localObject).e.put("roomid", String.valueOf(this.d.c));
    ((GiftSendReqData)localObject).e.put("anchor_uid", String.valueOf(this.d.e));
    ((GiftSendReqData)localObject).b = this.d.e;
    this.a.d().a((GiftSendReqData)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[initGiftSdk] senderUin:");
      ((StringBuilder)localObject).append(this.d.d);
      ((StringBuilder)localObject).append(",receiverUin:");
      ((StringBuilder)localObject).append(this.d.e);
      ((StringBuilder)localObject).append(",roomId:");
      ((StringBuilder)localObject).append(this.d.c);
      QLog.i("QQLiveAudienceGiftActivity", 2, ((StringBuilder)localObject).toString());
    }
    a(paramGiftServiceData);
    return false;
  }
  
  private void e()
  {
    Object localObject = getActivity();
    if (localObject == null)
    {
      QLog.d("QQLiveAudienceGiftActivity", 1, "[onCreateView] getActivity is null!");
      return;
    }
    localObject = ((Activity)localObject).getIntent();
    if (localObject != null) {
      this.d = ((QQLiveAudienceGiftData)((Intent)localObject).getParcelableExtra("extra_gift_data"));
    }
  }
  
  private void f()
  {
    QBaseActivity localQBaseActivity = getQBaseActivity();
    if (localQBaseActivity != null)
    {
      Object localObject = this.a;
      if ((localObject != null) && (!((IQQGiftSDK)localObject).k()))
      {
        if (this.b == null)
        {
          this.b = this.a.e().a(localQBaseActivity, this.d.i);
          localObject = this.b;
          ((IQQGiftPanelView)localObject).setPanelEventListener(((IQQGiftPanelView)localObject).a(this));
        }
        localObject = h();
        this.b.setSceneData((GiftListData)localObject);
        localObject = g();
        this.b.setDtParams((QQGiftDtParams)localObject);
        localObject = this.c;
        if (localObject != null)
        {
          this.b.a((View)localObject);
          return;
        }
        QLog.d("QQLiveAudienceGiftActivity", 1, "[openGiftPanel] rootView is null!");
        localQBaseActivity.setResult(0);
        localQBaseActivity.finish();
      }
    }
  }
  
  private QQGiftDtParams g()
  {
    QQGiftDtParams localQQGiftDtParams = new QQGiftDtParams();
    localQQGiftDtParams.a = this.d.j;
    localQQGiftDtParams.b = String.valueOf(this.d.d);
    localQQGiftDtParams.c = String.valueOf(this.d.e);
    localQQGiftDtParams.d = String.valueOf(this.d.c);
    localQQGiftDtParams.e = this.d.k;
    localQQGiftDtParams.f = "1";
    localQQGiftDtParams.g = "0";
    localQQGiftDtParams.h = this.d.l;
    localQQGiftDtParams.i = "0";
    localQQGiftDtParams.j = "0";
    return localQQGiftDtParams;
  }
  
  private GiftListData h()
  {
    GiftListData localGiftListData = new GiftListData();
    localGiftListData.a = 1;
    localGiftListData.b = this.d.l;
    localGiftListData.d = String.valueOf(this.d.e);
    localGiftListData.e = this.d.m;
    return localGiftListData;
  }
  
  private void i()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
    {
      localFragmentActivity.setResult(0);
      ThreadManagerV2.getUIHandlerV2().postDelayed(new QQLiveAudienceGiftFragment.4(this, localFragmentActivity), 500L);
    }
  }
  
  public boolean a()
  {
    Object localObject = this.b;
    if ((localObject instanceof View))
    {
      localObject = (View)localObject;
      ((View)localObject).post(new QQLiveAudienceGiftFragment.2(this, (View)localObject));
    }
    return false;
  }
  
  public boolean a(GiftServiceData paramGiftServiceData, int paramInt)
  {
    return false;
  }
  
  public boolean a(boolean paramBoolean, GiftServiceData paramGiftServiceData, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramGiftServiceData = new StringBuilder();
      paramGiftServiceData.append("onSendGiftCallback isSuccess:");
      paramGiftServiceData.append(paramBoolean);
      paramGiftServiceData.append(", errCode:");
      paramGiftServiceData.append(paramInt);
      QLog.d("QQLiveAudienceGiftActivity", 2, paramGiftServiceData.toString());
    }
    return false;
  }
  
  public boolean b()
  {
    i();
    return false;
  }
  
  public boolean b(GiftServiceData paramGiftServiceData, int paramInt)
  {
    return false;
  }
  
  public boolean c()
  {
    return false;
  }
  
  public boolean c(GiftServiceData paramGiftServiceData, int paramInt)
  {
    return b(paramGiftServiceData);
  }
  
  protected void d()
  {
    if (getQBaseActivity() == null)
    {
      QLog.e("QQLiveAudienceGiftActivity", 1, "setStatusBarImmersive qBaseActivity is null");
      return;
    }
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      if (getQBaseActivity().mSystemBarComp == null)
      {
        getQBaseActivity().setImmersiveStatus(0);
        return;
      }
      getQBaseActivity().mSystemBarComp.setStatusBarDrawable(null);
      getQBaseActivity().mSystemBarComp.setStatusBarColor(0);
      getQBaseActivity().mSystemBarComp.setStatusColor(0);
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 5) {
      paramActivity.overridePendingTransition(0, 0);
    }
  }
  
  @androidx.annotation.Nullable
  @org.jetbrains.annotations.Nullable
  public View onCreateView(@NonNull @NotNull LayoutInflater paramLayoutInflater, @androidx.annotation.Nullable @org.jetbrains.annotations.Nullable ViewGroup paramViewGroup, @androidx.annotation.Nullable @org.jetbrains.annotations.Nullable Bundle paramBundle)
  {
    this.c = paramLayoutInflater.inflate(2131627985, paramViewGroup, false);
    d();
    paramLayoutInflater = this.c;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.b = null;
    this.c = null;
  }
  
  public void onFinish()
  {
    super.onFinish();
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 5) {
      localFragmentActivity.overridePendingTransition(0, 0);
    }
  }
  
  public void onViewCreated(@NonNull @NotNull View paramView, @androidx.annotation.Nullable @org.jetbrains.annotations.Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    e();
    this.a = ((IQQGiftManager)QRoute.api(IQQGiftManager.class)).getSDKImpl(this.d.a);
    paramView.post(new QQLiveAudienceGiftFragment.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqlive.QQLiveAudienceGiftFragment
 * JD-Core Version:    0.7.0.1
 */