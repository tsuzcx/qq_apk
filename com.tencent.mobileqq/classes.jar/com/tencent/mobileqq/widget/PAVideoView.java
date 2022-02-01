package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.QQLiveDrawable;
import com.tencent.image.QQLiveDrawable.ErrorInfo;
import com.tencent.image.QQLiveDrawable.OnStateListener;
import com.tencent.image.QQLiveDrawable.QQLiveDrawableParams;
import com.tencent.image.QQLiveImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.ecshop.ad.IEcshopAdHandler;
import com.tencent.mobileqq.ecshop.ad.IEcshopAdHandler.ReportInfo;
import com.tencent.mobileqq.ecshop.ad.api.IEcshopAdApi;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.video.api.IThirdDataSourceAdapterFactory;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoReporter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo.Holder;
import com.tencent.mobileqq.utils.AIOSingleReporter;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class PAVideoView
  extends BubbleVideoView
  implements QQLiveDrawable.OnStateListener
{
  public static int A = 0;
  public static int B = A + 1;
  public static int C = B + 1;
  public static EmptyDrawable V = new EmptyDrawable(-2236446, 100, 100);
  public int D = A;
  public boolean E = false;
  public boolean F = false;
  public boolean G;
  RotateAnimation H;
  public int I;
  public int J;
  public String K;
  public String L;
  public long M;
  public String N;
  public int O;
  public int P;
  public String Q = "";
  public String R;
  public String S;
  public StructMsgItemVideo.Holder T;
  public Handler U = new Handler(Looper.getMainLooper());
  public StructMsgItemVideo W;
  private boolean Z;
  public int a = (int)(Math.random() * 1000.0D);
  private float[] aa = new float[C + 1];
  private Shader ab;
  private long ac;
  private long ad = -1L;
  private boolean ae = true;
  
  static
  {
    QQLiveImage.setDebugEnable(false);
  }
  
  public PAVideoView(Context paramContext)
  {
    super(paramContext);
    paramContext = this.aa;
    paramContext[A] = 1.777F;
    paramContext[B] = 0.83F;
    paramContext[C] = 1.0F;
  }
  
  public static String a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qqlive://msgId=");
    localStringBuilder.append(paramLong);
    return localStringBuilder.toString();
  }
  
  public Drawable a(String paramString)
  {
    Object localObject = V;
    StringBuilder localStringBuilder;
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = URLDrawable.getDrawable(paramString, V, V);
        return paramString;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("PAVideoView");
          ((StringBuilder)localObject).append(this.a);
          localObject = ((StringBuilder)localObject).toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("getCoverDrawable():  getDrawable Exception, mCoverUrl=");
          localStringBuilder.append(this.K);
          QLog.e((String)localObject, 2, localStringBuilder.toString(), paramString);
        }
        return V;
      }
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("PAVideoView");
      paramString.append(this.a);
      paramString = paramString.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCoverDrawable():  mCoverUrl=");
      localStringBuilder.append(this.K);
      QLog.e(paramString, 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  public void a(StructMsgItemVideo paramStructMsgItemVideo, StructMsgItemVideo.Holder paramHolder)
  {
    this.I = paramStructMsgItemVideo.aE;
    this.J = paramStructMsgItemVideo.aF;
    this.K = paramStructMsgItemVideo.au;
    this.L = paramStructMsgItemVideo.az;
    long l;
    if (paramStructMsgItemVideo.as.message == null) {
      l = 0L;
    } else {
      l = paramStructMsgItemVideo.as.message.uniseq;
    }
    this.M = l;
    this.O = paramStructMsgItemVideo.as.uinType;
    this.N = paramStructMsgItemVideo.as.uin;
    this.P = paramStructMsgItemVideo.aR;
    this.R = paramStructMsgItemVideo.aO;
    if ((paramStructMsgItemVideo.as instanceof AbsShareMsg)) {
      this.S = ((AbsShareMsg)paramStructMsgItemVideo.as).mSourceName;
    }
    this.W = paramStructMsgItemVideo;
    this.Q = paramStructMsgItemVideo.av;
    this.T = paramHolder;
    this.G = "1".equals(paramStructMsgItemVideo.be);
  }
  
  QQLiveDrawable.QQLiveDrawableParams d(boolean paramBoolean)
  {
    QQLiveDrawable.QQLiveDrawableParams localQQLiveDrawableParams = new QQLiveDrawable.QQLiveDrawableParams();
    int j = this.I;
    int i = j;
    if (j == 0) {
      i = 400;
    }
    localQQLiveDrawableParams.mPreviewWidth = i;
    j = this.J;
    i = j;
    if (j == 0) {
      i = 200;
    }
    localQQLiveDrawableParams.mPreviewHeight = i;
    localQQLiveDrawableParams.mPlayPause = paramBoolean;
    localQQLiveDrawableParams.mListener = this;
    localQQLiveDrawableParams.mServerType = "20160519";
    i = this.P;
    if ((i != 2) && (i != 4) && (i != 6))
    {
      localQQLiveDrawableParams.mDataSourceType = 0;
    }
    else
    {
      localQQLiveDrawableParams.mDataSourceType = 2;
      localQQLiveDrawableParams.mDataSourceAdapter = ((IThirdDataSourceAdapterFactory)QRoute.api(IThirdDataSourceAdapterFactory.class)).create(this.P);
      localQQLiveDrawableParams.mPlayType = 3;
    }
    localQQLiveDrawableParams.mDataSource = this.L;
    if ((this.P == 4) && (!TextUtils.isEmpty(this.Q)))
    {
      localQQLiveDrawableParams.mDataSourceType = 1;
      localQQLiveDrawableParams.mDataSource = this.Q;
    }
    localQQLiveDrawableParams.mCoverUrl = this.K;
    localQQLiveDrawableParams.mCoverLoadingDrawable = V;
    i = this.P;
    if (((i >= 1) && (i <= 3)) || (this.P == 6))
    {
      if ((this.W.aD == 0) || (this.W.aD > 8))
      {
        localQQLiveDrawableParams.mMaxPlayTimeMs = 8000;
        localQQLiveDrawableParams.mStartPosi = this.W.aC;
      }
      localQQLiveDrawableParams.mLoopback = false;
    }
    if (this.P == 4)
    {
      localQQLiveDrawableParams.mMaxPlayTimeMs = (this.W.aD * 1000);
      localQQLiveDrawableParams.mLoopback = true;
    }
    return localQQLiveDrawableParams;
  }
  
  public void d()
  {
    this.ae = true;
    Object localObject = f();
    if (localObject != null)
    {
      ((QQLiveDrawable)localObject).recyleAndKeepPostion();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("PAVideoView");
        ((StringBuilder)localObject).append(this.a);
        QLog.i(((StringBuilder)localObject).toString(), 2, "onMoveToScrapHeap(): recyleAndKeepPostion ");
      }
    }
  }
  
  public void e()
  {
    this.T.d.setVisibility(0);
    setImageDrawable(a(this.K));
    if (QLog.isColorLevel())
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("PAVideoView");
      ((StringBuilder)localObject).append(this.a);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showCover():  mVid=");
      localStringBuilder.append(this.L);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
  }
  
  public QQLiveDrawable f()
  {
    if ((getDrawable() != null) && ((getDrawable() instanceof URLDrawable)))
    {
      URLDrawable localURLDrawable = (URLDrawable)getDrawable();
      if ((localURLDrawable.getStatus() == 1) && ((localURLDrawable.getCurrDrawable() instanceof QQLiveDrawable))) {
        return (QQLiveDrawable)localURLDrawable.getCurrDrawable();
      }
    }
    return null;
  }
  
  public void g()
  {
    this.ad = -1L;
    this.T.d.clearAnimation();
    this.T.d.setVisibility(0);
    this.T.d.setImageResource(2130844327);
    Object localObject1 = f();
    StringBuilder localStringBuilder;
    if (localObject1 != null)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("PAVideoView");
        ((StringBuilder)localObject2).append(this.a);
        localObject2 = ((StringBuilder)localObject2).toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("pausePlay(): 1. cur video pause, mVid=");
        localStringBuilder.append(this.L);
        QLog.d((String)localObject2, 2, localStringBuilder.toString());
      }
      ((QQLiveDrawable)localObject1).pause();
      return;
    }
    localObject1 = d(true);
    Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject2).mExtraInfo = localObject1;
    localObject1 = URLDrawable.getDrawable(a(this.M), (URLDrawable.URLDrawableOptions)localObject2);
    if (((URLDrawable)localObject1).getStatus() == 1)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("PAVideoView");
        ((StringBuilder)localObject2).append(this.a);
        localObject2 = ((StringBuilder)localObject2).toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("pausePlay(): 2. cache video Pause , mVid=");
        localStringBuilder.append(this.L);
        QLog.d((String)localObject2, 2, localStringBuilder.toString());
      }
      setImageDrawable((Drawable)localObject1);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("PAVideoView");
      ((StringBuilder)localObject1).append(this.a);
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("pausePlay(): 3. set cover, mVid=");
      ((StringBuilder)localObject2).append(this.L);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    setImageDrawable(a(this.K));
  }
  
  public int getReportVideoType()
  {
    return ((IVideoReporter)QRoute.api(IVideoReporter.class)).getReportVideoType(this.P, this.S);
  }
  
  public Shader getShadowMaskShader()
  {
    return this.ab;
  }
  
  public void h()
  {
    if (this.P != 4) {
      this.T.d.setVisibility(8);
    }
    this.ad = System.currentTimeMillis();
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).videoPlayRealtimeReport(this.R, this.L, 0, 0);
    if ((!this.W.aX) && (this.W.as.message != null))
    {
      localObject1 = this.W.as.message.frienduin;
      localObject2 = this.L;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(this.P);
      localObject3 = ((StringBuilder)localObject3).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.W.as.msgId);
      ReportController.b(null, "dc00899", "Pb_account_lifeservice", (String)localObject1, "0X800682E", "0X800682E", 0, 0, (String)localObject2, (String)localObject3, localStringBuilder.toString(), "");
      this.W.aX = true;
    }
    if ((this.W.as.message != null) && (!AIOSingleReporter.a().a(this.W.as.message, "0X80077D9")))
    {
      localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      i = ((IVideoReporter)QRoute.api(IVideoReporter.class)).getUinMemberNum((AppInterface)localObject1, this.N, this.O);
      localObject2 = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject2).put("uin", this.N);
      ((JSONObject)localObject2).put("memNum", i);
      ((JSONObject)localObject2).put("msg_uniseq", this.W.as.message.uniseq);
      ((JSONObject)localObject2).put("rowkey", this.R);
      if (!((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).isStructMsgJumpForUG(this.W.as)) {
        break label695;
      }
      i = 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        continue;
        i = 0;
      }
    }
    ((JSONObject)localObject2).put("UG", i);
    Object localObject3 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    Object localObject1 = this.R;
    if (localObject1 == null) {
      localObject1 = "0";
    }
    ((IPublicAccountReportUtils)localObject3).publicAccountReportClickEvent(null, "", "0X80077D9", "0X80077D9", 0, 0, "1", "", (String)localObject1, ((IVideoReporter)QRoute.api(IVideoReporter.class)).videoReportBaseR5(null, null, this.L, this.R, (JSONObject)localObject2), false);
    AIOSingleReporter.a().b(this.W.as.message, "0X80077D9");
    localObject1 = d(false);
    Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject2).mExtraInfo = localObject1;
    ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = V;
    localObject1 = URLDrawable.getDrawable(a(this.M), (URLDrawable.URLDrawableOptions)localObject2);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("PAVideoView");
      ((StringBuilder)localObject2).append(this.a);
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("startPlay(): new or reuse cache, mVid=");
      ((StringBuilder)localObject3).append(this.L);
      QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
    }
    if ((((URLDrawable)localObject1).getStatus() == 1) && ((((URLDrawable)localObject1).getCurrDrawable() instanceof QQLiveDrawable)) && (((QQLiveDrawable)((URLDrawable)localObject1).getCurrDrawable()).getPlayState() == 6))
    {
      this.T.d.setVisibility(0);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("PAVideoView");
        ((StringBuilder)localObject2).append(this.a);
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("startPlay():reuse cache playCompleted, show play btn");
        ((StringBuilder)localObject3).append(this.L);
        QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
      }
    }
    setImageDrawable((Drawable)localObject1);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Object localObject = f();
    if (localObject != null) {
      ((QQLiveDrawable)localObject).onDetachedFromWindow();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("PAVideoView");
      ((StringBuilder)localObject).append(this.a);
      QLog.i(((StringBuilder)localObject).toString(), 2, "onDetachedFromWindow(): ");
    }
    this.U.removeCallbacksAndMessages(null);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (this.F)
    {
      paramInt2 = View.MeasureSpec.getSize(paramInt1);
      i = getPaddingLeft();
      int j = getPaddingRight();
      float[] arrayOfFloat = this.aa;
      int k = this.D;
      float f = arrayOfFloat[k];
      if (this.E)
      {
        if (k == A)
        {
          paramInt2 = BaseChatItemLayout.e - BaseChatItemLayout.getBubblePaddingAlignError();
          paramInt1 = (int)(paramInt2 / f + 0.5F);
        }
        else
        {
          paramInt1 = BaseChatItemLayout.e - BaseChatItemLayout.getBubblePaddingAlignError();
          paramInt2 = (int)(paramInt1 * f + 0.5F);
        }
        i = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
        paramInt2 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
      }
      else
      {
        paramInt2 = View.MeasureSpec.makeMeasureSpec((int)((paramInt2 - i - j) / f + 0.5F), 1073741824);
        i = paramInt1;
      }
    }
    super.onMeasure(i, paramInt2);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.ab == null)
    {
      paramInt1 = AIOUtils.b(55.0F, getResources());
      if (this.E)
      {
        paramInt3 = this.D;
        if (paramInt3 == A) {
          paramInt1 = AIOUtils.b(55.0F, getResources());
        } else if (paramInt3 == B) {
          paramInt1 = AIOUtils.b(75.0F, getResources());
        }
      }
      else
      {
        paramInt1 = (int)(paramInt2 * 0.6F);
      }
      float f1 = paramInt2 - paramInt1;
      float f2 = paramInt2;
      Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
      this.ab = new LinearGradient(0.0F, f1, 0.0F, f2, new int[] { 0, -1728053248 }, new float[] { 0.0F, 1.0F }, localTileMode);
    }
  }
  
  public void onStateChange(String paramString, QQLiveDrawable.QQLiveDrawableParams paramQQLiveDrawableParams, int paramInt, Object paramObject)
  {
    paramQQLiveDrawableParams = this.T.d;
    if (paramQQLiveDrawableParams != null)
    {
      if (paramInt == 3)
      {
        if (this.H == null)
        {
          this.H = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
          this.H.setDuration(500L);
          this.H.setRepeatCount(-1);
          this.H.setRepeatMode(1);
          this.H.setStartTime(-1L);
          paramString = new LinearInterpolator();
          this.H.setInterpolator(paramString);
        }
        this.U.postDelayed(new PAVideoView.1(this, paramQQLiveDrawableParams), 1200L);
        return;
      }
      paramString = null;
      boolean bool2 = false;
      if (paramInt == 2)
      {
        this.ac = System.currentTimeMillis();
        this.U.removeCallbacksAndMessages(null);
        paramQQLiveDrawableParams.clearAnimation();
        paramQQLiveDrawableParams.setVisibility(8);
        if (this.P != 4) {
          break label903;
        }
        a(false);
        this.U.postDelayed(new PAVideoView.2(this), 5000L);
        return;
      }
      if (paramInt == 5)
      {
        if ((paramObject instanceof QQLiveDrawable.ErrorInfo)) {
          paramString = (QQLiveDrawable.ErrorInfo)paramObject;
        }
        paramQQLiveDrawableParams.setVisibility(0);
        paramQQLiveDrawableParams.setImageResource(2130844323);
        this.T.b.setVisibility(0);
        a(true);
        this.U.post(new PAVideoView.3(this, paramQQLiveDrawableParams));
        if (paramString == null) {
          break label903;
        }
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).videoPlayRealtimeReport(this.R, this.L, 1, paramString.what);
        return;
      }
      if (paramInt == 8)
      {
        boolean bool1 = bool2;
        if ((paramObject instanceof Long))
        {
          long l = ((Long)paramObject).longValue();
          if (l < 300L)
          {
            bool1 = bool2;
            if (l != -1L) {}
          }
          else
          {
            bool1 = true;
          }
        }
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("PAVideoView");
          paramString.append(this.a);
          paramString = paramString.toString();
          paramQQLiveDrawableParams = new StringBuilder();
          paramQQLiveDrawableParams.append("state_init, extra = ");
          paramQQLiveDrawableParams.append(paramObject);
          paramQQLiveDrawableParams.append(" , needReport= ");
          paramQQLiveDrawableParams.append(bool1);
          QLog.d(paramString, 2, paramQQLiveDrawableParams.toString());
        }
        if (!bool1) {
          break label903;
        }
        paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        paramInt = ((IVideoReporter)QRoute.api(IVideoReporter.class)).getUinMemberNum(paramString, this.N, this.O);
        paramQQLiveDrawableParams = new JSONObject();
      }
    }
    try
    {
      paramQQLiveDrawableParams.put("uin", this.N);
      paramQQLiveDrawableParams.put("memNum", paramInt);
      paramQQLiveDrawableParams.put("msg_uniseq", this.W.as.message.uniseq);
      paramObject = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      paramString = this.R;
      if (paramString == null) {
        paramString = "0";
      }
      paramObject.publicAccountReportClickEvent(null, "", "0X8007414", "0X8007414", 0, 0, "1", "", paramString, ((IVideoReporter)QRoute.api(IVideoReporter.class)).videoReportBaseR5(null, null, this.L, this.R, paramQQLiveDrawableParams), false);
      return;
      if (paramInt == 4)
      {
        if ((this.P != 4) || (this.ac == 0L)) {
          break label903;
        }
        paramString = new IEcshopAdHandler.ReportInfo();
        paramString.a = 4;
      }
    }
    catch (Exception paramString)
    {
      try
      {
        paramInt = (int)((System.currentTimeMillis() - this.ac) / 1000L);
        paramQQLiveDrawableParams = new JSONObject();
        paramQQLiveDrawableParams.put("bt", "0");
        paramQQLiveDrawableParams.put("et", String.valueOf(paramInt));
        paramQQLiveDrawableParams.put("bf", "1");
        paramQQLiveDrawableParams.put("ef", "0");
        paramQQLiveDrawableParams.put("pp", "1");
        paramQQLiveDrawableParams.put("pa", "1");
        paramQQLiveDrawableParams.put("pb", "1");
        paramString.l = paramQQLiveDrawableParams.toString();
        label724:
        paramString = ((IEcshopAdApi)QRoute.api(IEcshopAdApi.class)).rebuildReportParam(paramString, this.W.as.message);
        ((IEcshopAdHandler)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.ESHOP_AD_HANDLER)).a(paramString, null);
        this.ac = 0L;
        return;
        if (paramInt == 6)
        {
          paramQQLiveDrawableParams.setVisibility(0);
          paramQQLiveDrawableParams.setImageResource(2130844327);
          this.U.post(new PAVideoView.4(this, paramQQLiveDrawableParams));
          return;
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("PAVideoView");
            paramString.append(this.a);
            paramString = paramString.toString();
            paramQQLiveDrawableParams = new StringBuilder();
            paramQQLiveDrawableParams.append("onStateChange(): onStateChange = ");
            paramQQLiveDrawableParams.append(QQLiveImage.getStateStr(paramInt));
            paramQQLiveDrawableParams.append(", stateIv == null,mVid=");
            paramQQLiveDrawableParams.append(this.L);
            QLog.e(paramString, 2, paramQQLiveDrawableParams.toString());
          }
        }
        label903:
        return;
        paramString = paramString;
      }
      catch (Exception paramQQLiveDrawableParams)
      {
        break label724;
      }
    }
  }
  
  public void requestLayout()
  {
    if (!this.Z) {
      super.requestLayout();
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    this.Z = true;
    super.setImageDrawable(null);
    super.setImageDrawable(paramDrawable);
    this.Z = false;
  }
  
  public void setRatioByMode(int paramInt, float paramFloat)
  {
    if ((paramInt == C) || (paramInt == A) || (paramInt == B)) {
      this.aa[paramInt] = paramFloat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PAVideoView
 * JD-Core Version:    0.7.0.1
 */