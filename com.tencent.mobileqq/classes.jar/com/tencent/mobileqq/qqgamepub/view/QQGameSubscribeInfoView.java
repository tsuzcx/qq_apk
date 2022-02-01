package com.tencent.mobileqq.qqgamepub.view;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameSubscribeService;
import com.tencent.mobileqq.qqgamepub.api.IQQGameSubscribeService.GameBaseInfo;
import com.tencent.mobileqq.qqgamepub.data.QQGamePubSubscribe.AppSubscribeInfo;
import com.tencent.mobileqq.qqgamepub.utils.QQGameImageLoader;
import com.tencent.mobileqq.qqgamepub.utils.UIUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QQGameSubscribeInfoView
  extends FrameLayout
  implements View.OnClickListener
{
  private TextView a;
  private ImageView b;
  private ImageView c;
  private ImageView d;
  private TextView e;
  private TextView f;
  private QQGamePubSubscribe.AppSubscribeInfo g;
  private boolean h = false;
  private String i;
  private long j;
  
  public QQGameSubscribeInfoView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QQGameSubscribeInfoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QQGameSubscribeInfoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private QQGamePubSubscribe.AppSubscribeInfo a(String paramString, IQQGameSubscribeService arg2)
  {
    try
    {
      synchronized (???.getCachedSubscribeList())
      {
        Iterator localIterator = ???.iterator();
        while (localIterator.hasNext())
        {
          QQGamePubSubscribe.AppSubscribeInfo localAppSubscribeInfo = (QQGamePubSubscribe.AppSubscribeInfo)localIterator.next();
          if ((localAppSubscribeInfo != null) && (localAppSubscribeInfo.appid.get() == Integer.parseInt(paramString))) {
            return localAppSubscribeInfo;
          }
        }
      }
      return null;
    }
    catch (Throwable paramString)
    {
      QLog.e("QQGamePub_QQGameSubscribeInfoView", 1, paramString, new Object[0]);
    }
  }
  
  private void a()
  {
    Object localObject = PropertyValuesHolder.ofFloat("scaleX", new float[] { 1.0F, 1.5F, 1.0F });
    PropertyValuesHolder localPropertyValuesHolder = PropertyValuesHolder.ofFloat("scaleY", new float[] { 1.0F, 1.5F, 1.0F });
    localObject = ObjectAnimator.ofPropertyValuesHolder(this.c, new PropertyValuesHolder[] { localObject, localPropertyValuesHolder });
    ((ObjectAnimator)localObject).setDuration(300L);
    ((ObjectAnimator)localObject).start();
  }
  
  private void a(long paramLong)
  {
    if (paramLong <= 0L)
    {
      this.f.setVisibility(4);
      return;
    }
    this.f.setVisibility(0);
    if (paramLong >= 10000L)
    {
      paramLong /= 10000L;
      localTextView = this.f;
      str = getResources().getString(2131892999);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramLong);
      localStringBuilder.append("");
      localTextView.setText(String.format(str, new Object[] { localStringBuilder.toString() }));
      return;
    }
    TextView localTextView = this.f;
    String str = getResources().getString(2131892998);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong);
    localStringBuilder.append("");
    localTextView.setText(String.format(str, new Object[] { localStringBuilder.toString() }));
  }
  
  private void a(Context paramContext)
  {
    View.inflate(paramContext, 2131624920, this);
    this.a = ((TextView)findViewById(2131448773));
    this.b = ((ImageView)findViewById(2131448772));
    this.c = ((ImageView)findViewById(2131436601));
    this.d = ((ImageView)findViewById(2131436602));
    this.e = ((TextView)findViewById(2131448775));
    this.f = ((TextView)findViewById(2131448774));
    findViewById(2131437572).setOnClickListener(this);
    setId(2131442589);
    setOnClickListener(this);
  }
  
  private void a(String paramString)
  {
    int k = UIUtils.a(60.0F, getResources());
    Bitmap localBitmap = BaseImageUtil.a(QQGameImageLoader.a().a(paramString), UIUtils.a(12.0F, this.b.getResources()), true, k, k);
    if (localBitmap != null)
    {
      this.b.setImageBitmap(localBitmap);
      return;
    }
    QQGameImageLoader.a().a(paramString, new QQGameSubscribeInfoView.1(this, k), k, k);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.d.setVisibility(8);
      this.c.setBackgroundDrawable(getContext().getResources().getDrawable(2130840521));
      this.e.setText(getResources().getString(2131892996));
      this.e.setTextColor(Color.parseColor("#8f9194"));
      if (paramBoolean2) {
        a();
      }
    }
    else
    {
      this.d.setVisibility(0);
      this.c.setBackgroundDrawable(getContext().getResources().getDrawable(2130840516));
      this.e.setText(getResources().getString(2131892993));
      this.e.setTextColor(getResources().getColor(2131167347));
    }
    this.h = paramBoolean1;
  }
  
  private boolean a(int paramInt)
  {
    return paramInt == 1;
  }
  
  private boolean a(String paramString, QQGamePubSubscribe.AppSubscribeInfo paramAppSubscribeInfo)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isDataInvalid..appId:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",info:");
      localStringBuilder.append(paramAppSubscribeInfo);
      QLog.i("QQGamePub_QQGameSubscribeInfoView", 2, localStringBuilder.toString());
    }
    if (((IQQGameHelper)QRoute.api(IQQGameHelper.class)).isInValidGameAppId(paramString))
    {
      setVisibility(8);
      QLog.e("QQGamePub_QQGameSubscribeInfoView", 1, "isDataInvalid..appId is isInValid");
      return true;
    }
    setVisibility(0);
    this.i = paramString;
    if (paramAppSubscribeInfo != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramAppSubscribeInfo.appid.get());
      localStringBuilder.append("");
      if (!paramString.equals(localStringBuilder.toString()))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("isDataInvalid..appId is not match,current appid:");
        localStringBuilder.append(paramString);
        localStringBuilder.append(",rspAppId:");
        localStringBuilder.append(paramAppSubscribeInfo.appid.get());
        QLog.e("QQGamePub_QQGameSubscribeInfoView", 1, localStringBuilder.toString());
        return true;
      }
    }
    return false;
  }
  
  public void a(String paramString, QQGamePubSubscribe.AppSubscribeInfo paramAppSubscribeInfo, boolean paramBoolean)
  {
    if (a(paramString, paramAppSubscribeInfo)) {
      return;
    }
    IQQGameSubscribeService localIQQGameSubscribeService = (IQQGameSubscribeService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQQGameSubscribeService.class, "all");
    Object localObject2 = getResources().getString(2131892960);
    long l = 0L;
    boolean bool = false;
    IQQGameSubscribeService.GameBaseInfo localGameBaseInfo = localIQQGameSubscribeService.getGameInfoFromCacheMap(paramString);
    Object localObject1 = localObject2;
    if (localGameBaseInfo != null)
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(localGameBaseInfo.b)) {
        localObject1 = localGameBaseInfo.b;
      }
      bool = localGameBaseInfo.c;
    }
    this.g = paramAppSubscribeInfo;
    if (this.g == null) {
      this.g = a(paramString, localIQQGameSubscribeService);
    }
    paramString = this.g;
    if (paramString != null)
    {
      bool = a(paramString.subscribe.get());
      l = this.g.subscribeCount.get();
      paramString = this.g.appIcon.get();
    }
    else
    {
      paramString = "";
    }
    this.a.setText((CharSequence)localObject1);
    a(bool, paramBoolean);
    a(paramString);
    a(l);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("refreshUi...info:");
      ((StringBuilder)localObject2).append(paramAppSubscribeInfo);
      ((StringBuilder)localObject2).append(",mSubScribeInfo:");
      ((StringBuilder)localObject2).append(this.g);
      ((StringBuilder)localObject2).append(",appName:");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(",appIcon:");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(",subscribeNum:");
      ((StringBuilder)localObject2).append(l);
      ((StringBuilder)localObject2).append(",needAnim:");
      ((StringBuilder)localObject2).append(paramBoolean);
      ((StringBuilder)localObject2).append(",isSubscribed:");
      ((StringBuilder)localObject2).append(bool);
      QLog.i("QQGamePub_QQGameSubscribeInfoView", 2, ((StringBuilder)localObject2).toString());
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onClick...mSubScribeInfo");
      ((StringBuilder)localObject).append(this.g);
      ((StringBuilder)localObject).append(",isNetSupport:");
      ((StringBuilder)localObject).append(AppNetConnInfo.isNetSupport());
      ((StringBuilder)localObject).append(",mAppId:");
      ((StringBuilder)localObject).append(this.i);
      QLog.i("QQGamePub_QQGameSubscribeInfoView", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool = AppNetConnInfo.isNetSupport();
    int k = 1;
    if (!bool)
    {
      QQToast.makeText(getContext(), 1, getResources().getString(2131892950), 0).show();
    }
    else if (((IQQGameHelper)QRoute.api(IQQGameHelper.class)).isInValidGameAppId(this.i))
    {
      QQToast.makeText(getContext(), 1, getResources().getString(2131892995), 0).show();
    }
    else if ((2131437572 == paramView.getId()) && (Math.abs(System.currentTimeMillis() - this.j) >= 1000L))
    {
      localObject = (IQQGameSubscribeService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQQGameSubscribeService.class, "all");
      if (this.h) {
        k = 2;
      }
      this.j = ((IQQGameSubscribeService)localObject).reqSetSubscribeStatus(this.i, k, 2);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.view.QQGameSubscribeInfoView
 * JD-Core Version:    0.7.0.1
 */