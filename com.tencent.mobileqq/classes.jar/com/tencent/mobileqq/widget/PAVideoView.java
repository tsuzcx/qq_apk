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
  public static EmptyDrawable a;
  public static int c;
  public static int d;
  public static int e;
  public long a;
  public Handler a;
  RotateAnimation a;
  public StructMsgItemVideo.Holder a;
  public StructMsgItemVideo a;
  public String a;
  public int b;
  private long jdField_b_of_type_Long;
  private Shader jdField_b_of_type_AndroidGraphicsShader;
  public String b;
  private long jdField_c_of_type_Long = -1L;
  public String c;
  public boolean c;
  private float[] jdField_c_of_type_ArrayOfFloat = new float[jdField_e_of_type_Int + 1];
  public String d;
  public String e;
  public int f;
  public String f;
  public int g;
  public int h;
  public int i;
  public boolean i;
  public int j;
  public boolean j;
  private boolean k;
  private boolean l = true;
  
  static
  {
    QQLiveImage.setDebugEnable(false);
    jdField_c_of_type_Int = 0;
    jdField_d_of_type_Int = jdField_c_of_type_Int + 1;
    jdField_e_of_type_Int = jdField_d_of_type_Int + 1;
    jdField_a_of_type_ComTencentMobileqqDrawableEmptyDrawable = new EmptyDrawable(-2236446, 100, 100);
  }
  
  public PAVideoView(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Int = ((int)(Math.random() * 1000.0D));
    this.jdField_f_of_type_Int = jdField_c_of_type_Int;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    paramContext = this.jdField_c_of_type_ArrayOfFloat;
    paramContext[jdField_c_of_type_Int] = 1.777F;
    paramContext[jdField_d_of_type_Int] = 0.83F;
    paramContext[jdField_e_of_type_Int] = 1.0F;
  }
  
  public static String a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qqlive://msgId=");
    localStringBuilder.append(paramLong);
    return localStringBuilder.toString();
  }
  
  public Shader a()
  {
    return this.jdField_b_of_type_AndroidGraphicsShader;
  }
  
  public Drawable a(String paramString)
  {
    Object localObject = jdField_a_of_type_ComTencentMobileqqDrawableEmptyDrawable;
    StringBuilder localStringBuilder;
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = URLDrawable.getDrawable(paramString, jdField_a_of_type_ComTencentMobileqqDrawableEmptyDrawable, jdField_a_of_type_ComTencentMobileqqDrawableEmptyDrawable);
        return paramString;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("PAVideoView");
          ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
          localObject = ((StringBuilder)localObject).toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("getCoverDrawable():  getDrawable Exception, mCoverUrl=");
          localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
          QLog.e((String)localObject, 2, localStringBuilder.toString(), paramString);
        }
        return jdField_a_of_type_ComTencentMobileqqDrawableEmptyDrawable;
      }
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("PAVideoView");
      paramString.append(this.jdField_b_of_type_Int);
      paramString = paramString.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCoverDrawable():  mCoverUrl=");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      QLog.e(paramString, 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  QQLiveDrawable.QQLiveDrawableParams a(boolean paramBoolean)
  {
    QQLiveDrawable.QQLiveDrawableParams localQQLiveDrawableParams = new QQLiveDrawable.QQLiveDrawableParams();
    int n = this.g;
    int m = n;
    if (n == 0) {
      m = 400;
    }
    localQQLiveDrawableParams.mPreviewWidth = m;
    n = this.h;
    m = n;
    if (n == 0) {
      m = 200;
    }
    localQQLiveDrawableParams.mPreviewHeight = m;
    localQQLiveDrawableParams.mPlayPause = paramBoolean;
    localQQLiveDrawableParams.mListener = this;
    localQQLiveDrawableParams.mServerType = "20160519";
    m = this.jdField_j_of_type_Int;
    if ((m != 2) && (m != 4) && (m != 6))
    {
      localQQLiveDrawableParams.mDataSourceType = 0;
    }
    else
    {
      localQQLiveDrawableParams.mDataSourceType = 2;
      localQQLiveDrawableParams.mDataSourceAdapter = ((IThirdDataSourceAdapterFactory)QRoute.api(IThirdDataSourceAdapterFactory.class)).create(this.jdField_j_of_type_Int);
      localQQLiveDrawableParams.mPlayType = 3;
    }
    localQQLiveDrawableParams.mDataSource = this.jdField_b_of_type_JavaLangString;
    if ((this.jdField_j_of_type_Int == 4) && (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)))
    {
      localQQLiveDrawableParams.mDataSourceType = 1;
      localQQLiveDrawableParams.mDataSource = this.jdField_d_of_type_JavaLangString;
    }
    localQQLiveDrawableParams.mCoverUrl = this.jdField_a_of_type_JavaLangString;
    localQQLiveDrawableParams.mCoverLoadingDrawable = jdField_a_of_type_ComTencentMobileqqDrawableEmptyDrawable;
    m = this.jdField_j_of_type_Int;
    if (((m >= 1) && (m <= 3)) || (this.jdField_j_of_type_Int == 6))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemVideo.q == 0) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemVideo.q > 8))
      {
        localQQLiveDrawableParams.mMaxPlayTimeMs = 8000;
        localQQLiveDrawableParams.mStartPosi = this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemVideo.p;
      }
      localQQLiveDrawableParams.mLoopback = false;
    }
    if (this.jdField_j_of_type_Int == 4)
    {
      localQQLiveDrawableParams.mMaxPlayTimeMs = (this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemVideo.q * 1000);
      localQQLiveDrawableParams.mLoopback = true;
    }
    return localQQLiveDrawableParams;
  }
  
  public QQLiveDrawable a()
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
  
  public void a(StructMsgItemVideo paramStructMsgItemVideo, StructMsgItemVideo.Holder paramHolder)
  {
    this.g = paramStructMsgItemVideo.r;
    this.h = paramStructMsgItemVideo.s;
    this.jdField_a_of_type_JavaLangString = paramStructMsgItemVideo.ac;
    this.jdField_b_of_type_JavaLangString = paramStructMsgItemVideo.ae;
    long l1;
    if (paramStructMsgItemVideo.a.message == null) {
      l1 = 0L;
    } else {
      l1 = paramStructMsgItemVideo.a.message.uniseq;
    }
    this.jdField_a_of_type_Long = l1;
    this.jdField_i_of_type_Int = paramStructMsgItemVideo.a.uinType;
    this.jdField_c_of_type_JavaLangString = paramStructMsgItemVideo.a.uin;
    this.jdField_j_of_type_Int = paramStructMsgItemVideo.v;
    this.jdField_e_of_type_JavaLangString = paramStructMsgItemVideo.aj;
    if ((paramStructMsgItemVideo.a instanceof AbsShareMsg)) {
      this.jdField_f_of_type_JavaLangString = ((AbsShareMsg)paramStructMsgItemVideo.a).mSourceName;
    }
    this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemVideo = paramStructMsgItemVideo;
    this.jdField_d_of_type_JavaLangString = paramStructMsgItemVideo.ad;
    this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemVideo$Holder = paramHolder;
    this.jdField_j_of_type_Boolean = "1".equals(paramStructMsgItemVideo.ay);
  }
  
  public void c()
  {
    this.l = true;
    Object localObject = a();
    if (localObject != null)
    {
      ((QQLiveDrawable)localObject).recyleAndKeepPostion();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("PAVideoView");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
        QLog.i(((StringBuilder)localObject).toString(), 2, "onMoveToScrapHeap(): recyleAndKeepPostion ");
      }
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemVideo$Holder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    setImageDrawable(a(this.jdField_a_of_type_JavaLangString));
    if (QLog.isColorLevel())
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("PAVideoView");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showCover():  mVid=");
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
  }
  
  public void e()
  {
    this.jdField_c_of_type_Long = -1L;
    this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemVideo$Holder.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemVideo$Holder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemVideo$Holder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843373);
    Object localObject1 = a();
    StringBuilder localStringBuilder;
    if (localObject1 != null)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("PAVideoView");
        ((StringBuilder)localObject2).append(this.jdField_b_of_type_Int);
        localObject2 = ((StringBuilder)localObject2).toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("pausePlay(): 1. cur video pause, mVid=");
        localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
        QLog.d((String)localObject2, 2, localStringBuilder.toString());
      }
      ((QQLiveDrawable)localObject1).pause();
      return;
    }
    localObject1 = a(true);
    Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject2).mExtraInfo = localObject1;
    localObject1 = URLDrawable.getDrawable(a(this.jdField_a_of_type_Long), (URLDrawable.URLDrawableOptions)localObject2);
    if (((URLDrawable)localObject1).getStatus() == 1)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("PAVideoView");
        ((StringBuilder)localObject2).append(this.jdField_b_of_type_Int);
        localObject2 = ((StringBuilder)localObject2).toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("pausePlay(): 2. cache video Pause , mVid=");
        localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
        QLog.d((String)localObject2, 2, localStringBuilder.toString());
      }
      setImageDrawable((Drawable)localObject1);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("PAVideoView");
      ((StringBuilder)localObject1).append(this.jdField_b_of_type_Int);
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("pausePlay(): 3. set cover, mVid=");
      ((StringBuilder)localObject2).append(this.jdField_b_of_type_JavaLangString);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    setImageDrawable(a(this.jdField_a_of_type_JavaLangString));
  }
  
  public void f()
  {
    if (this.jdField_j_of_type_Int != 4) {
      this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemVideo$Holder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).videoPlayRealtimeReport(this.jdField_e_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, 0, 0);
    if ((!this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemVideo.b) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemVideo.a.message != null))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemVideo.a.message.frienduin;
      localObject2 = this.jdField_b_of_type_JavaLangString;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(this.jdField_j_of_type_Int);
      localObject3 = ((StringBuilder)localObject3).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemVideo.a.msgId);
      ReportController.b(null, "dc00899", "Pb_account_lifeservice", (String)localObject1, "0X800682E", "0X800682E", 0, 0, (String)localObject2, (String)localObject3, localStringBuilder.toString(), "");
      this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemVideo.b = true;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemVideo.a.message != null) && (!AIOSingleReporter.a().a(this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemVideo.a.message, "0X80077D9")))
    {
      localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      m = ((IVideoReporter)QRoute.api(IVideoReporter.class)).getUinMemberNum((AppInterface)localObject1, this.jdField_c_of_type_JavaLangString, this.jdField_i_of_type_Int);
      localObject2 = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject2).put("uin", this.jdField_c_of_type_JavaLangString);
      ((JSONObject)localObject2).put("memNum", m);
      ((JSONObject)localObject2).put("msg_uniseq", this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemVideo.a.message.uniseq);
      ((JSONObject)localObject2).put("rowkey", this.jdField_e_of_type_JavaLangString);
      if (!((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).isStructMsgJumpForUG(this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemVideo.a)) {
        break label696;
      }
      m = 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        continue;
        m = 0;
      }
    }
    ((JSONObject)localObject2).put("UG", m);
    Object localObject3 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    Object localObject1 = this.jdField_e_of_type_JavaLangString;
    if (localObject1 == null) {
      localObject1 = "0";
    }
    ((IPublicAccountReportUtils)localObject3).publicAccountReportClickEvent(null, "", "0X80077D9", "0X80077D9", 0, 0, "1", "", (String)localObject1, ((IVideoReporter)QRoute.api(IVideoReporter.class)).videoReportBaseR5(null, null, this.jdField_b_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, (JSONObject)localObject2), false);
    AIOSingleReporter.a().a(this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemVideo.a.message, "0X80077D9");
    localObject1 = a(false);
    Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject2).mExtraInfo = localObject1;
    ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = jdField_a_of_type_ComTencentMobileqqDrawableEmptyDrawable;
    localObject1 = URLDrawable.getDrawable(a(this.jdField_a_of_type_Long), (URLDrawable.URLDrawableOptions)localObject2);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("PAVideoView");
      ((StringBuilder)localObject2).append(this.jdField_b_of_type_Int);
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("startPlay(): new or reuse cache, mVid=");
      ((StringBuilder)localObject3).append(this.jdField_b_of_type_JavaLangString);
      QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
    }
    if ((((URLDrawable)localObject1).getStatus() == 1) && ((((URLDrawable)localObject1).getCurrDrawable() instanceof QQLiveDrawable)) && (((QQLiveDrawable)((URLDrawable)localObject1).getCurrDrawable()).getPlayState() == 6))
    {
      this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemVideo$Holder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("PAVideoView");
        ((StringBuilder)localObject2).append(this.jdField_b_of_type_Int);
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("startPlay():reuse cache playCompleted, show play btn");
        ((StringBuilder)localObject3).append(this.jdField_b_of_type_JavaLangString);
        QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
      }
    }
    setImageDrawable((Drawable)localObject1);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Object localObject = a();
    if (localObject != null) {
      ((QQLiveDrawable)localObject).onDetachedFromWindow();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("PAVideoView");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
      QLog.i(((StringBuilder)localObject).toString(), 2, "onDetachedFromWindow(): ");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int m = paramInt1;
    if (this.jdField_i_of_type_Boolean)
    {
      paramInt2 = View.MeasureSpec.getSize(paramInt1);
      m = getPaddingLeft();
      int n = getPaddingRight();
      float[] arrayOfFloat = this.jdField_c_of_type_ArrayOfFloat;
      int i1 = this.jdField_f_of_type_Int;
      float f1 = arrayOfFloat[i1];
      if (this.jdField_c_of_type_Boolean)
      {
        if (i1 == jdField_c_of_type_Int)
        {
          paramInt2 = BaseChatItemLayout.jdField_e_of_type_Int - BaseChatItemLayout.k;
          paramInt1 = (int)(paramInt2 / f1 + 0.5F);
        }
        else
        {
          paramInt1 = BaseChatItemLayout.jdField_e_of_type_Int - BaseChatItemLayout.k;
          paramInt2 = (int)(paramInt1 * f1 + 0.5F);
        }
        m = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
        paramInt2 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
      }
      else
      {
        paramInt2 = View.MeasureSpec.makeMeasureSpec((int)((paramInt2 - m - n) / f1 + 0.5F), 1073741824);
        m = paramInt1;
      }
    }
    super.onMeasure(m, paramInt2);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_b_of_type_AndroidGraphicsShader == null)
    {
      paramInt1 = AIOUtils.b(55.0F, getResources());
      if (this.jdField_c_of_type_Boolean)
      {
        paramInt3 = this.jdField_f_of_type_Int;
        if (paramInt3 == jdField_c_of_type_Int) {
          paramInt1 = AIOUtils.b(55.0F, getResources());
        } else if (paramInt3 == jdField_d_of_type_Int) {
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
      this.jdField_b_of_type_AndroidGraphicsShader = new LinearGradient(0.0F, f1, 0.0F, f2, new int[] { 0, -1728053248 }, new float[] { 0.0F, 1.0F }, localTileMode);
    }
  }
  
  public void onStateChange(String paramString, QQLiveDrawable.QQLiveDrawableParams paramQQLiveDrawableParams, int paramInt, Object paramObject)
  {
    paramQQLiveDrawableParams = this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemVideo$Holder.jdField_a_of_type_AndroidWidgetImageView;
    if (paramQQLiveDrawableParams != null)
    {
      if (paramInt == 3)
      {
        if (this.jdField_a_of_type_AndroidViewAnimationRotateAnimation == null)
        {
          this.jdField_a_of_type_AndroidViewAnimationRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
          this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setDuration(500L);
          this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setRepeatCount(-1);
          this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setRepeatMode(1);
          this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setStartTime(-1L);
          paramString = new LinearInterpolator();
          this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setInterpolator(paramString);
        }
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new PAVideoView.1(this, paramQQLiveDrawableParams), 1200L);
        return;
      }
      paramString = null;
      boolean bool2 = false;
      if (paramInt == 2)
      {
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        paramQQLiveDrawableParams.clearAnimation();
        paramQQLiveDrawableParams.setVisibility(8);
        if (this.jdField_j_of_type_Int != 4) {
          break label908;
        }
        b(false);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new PAVideoView.2(this), 5000L);
        return;
      }
      if (paramInt == 5)
      {
        if ((paramObject instanceof QQLiveDrawable.ErrorInfo)) {
          paramString = (QQLiveDrawable.ErrorInfo)paramObject;
        }
        paramQQLiveDrawableParams.setVisibility(0);
        paramQQLiveDrawableParams.setImageResource(2130843369);
        this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemVideo$Holder.jdField_a_of_type_AndroidViewView.setVisibility(0);
        b(true);
        this.jdField_a_of_type_AndroidOsHandler.post(new PAVideoView.3(this, paramQQLiveDrawableParams));
        if (paramString == null) {
          break label908;
        }
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).videoPlayRealtimeReport(this.jdField_e_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, 1, paramString.what);
        return;
      }
      if (paramInt == 8)
      {
        boolean bool1 = bool2;
        if ((paramObject instanceof Long))
        {
          long l1 = ((Long)paramObject).longValue();
          if (l1 < 300L)
          {
            bool1 = bool2;
            if (l1 != -1L) {}
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
          paramString.append(this.jdField_b_of_type_Int);
          paramString = paramString.toString();
          paramQQLiveDrawableParams = new StringBuilder();
          paramQQLiveDrawableParams.append("state_init, extra = ");
          paramQQLiveDrawableParams.append(paramObject);
          paramQQLiveDrawableParams.append(" , needReport= ");
          paramQQLiveDrawableParams.append(bool1);
          QLog.d(paramString, 2, paramQQLiveDrawableParams.toString());
        }
        if (!bool1) {
          break label908;
        }
        paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        paramInt = ((IVideoReporter)QRoute.api(IVideoReporter.class)).getUinMemberNum(paramString, this.jdField_c_of_type_JavaLangString, this.jdField_i_of_type_Int);
        paramQQLiveDrawableParams = new JSONObject();
      }
    }
    try
    {
      paramQQLiveDrawableParams.put("uin", this.jdField_c_of_type_JavaLangString);
      paramQQLiveDrawableParams.put("memNum", paramInt);
      paramQQLiveDrawableParams.put("msg_uniseq", this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemVideo.a.message.uniseq);
      paramObject = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      paramString = this.jdField_e_of_type_JavaLangString;
      if (paramString == null) {
        paramString = "0";
      }
      paramObject.publicAccountReportClickEvent(null, "", "0X8007414", "0X8007414", 0, 0, "1", "", paramString, ((IVideoReporter)QRoute.api(IVideoReporter.class)).videoReportBaseR5(null, null, this.jdField_b_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, paramQQLiveDrawableParams), false);
      return;
      if (paramInt == 4)
      {
        if ((this.jdField_j_of_type_Int != 4) || (this.jdField_b_of_type_Long == 0L)) {
          break label908;
        }
        paramString = new IEcshopAdHandler.ReportInfo();
        paramString.a = 4;
      }
    }
    catch (Exception paramString)
    {
      try
      {
        paramInt = (int)((System.currentTimeMillis() - this.jdField_b_of_type_Long) / 1000L);
        paramQQLiveDrawableParams = new JSONObject();
        paramQQLiveDrawableParams.put("bt", "0");
        paramQQLiveDrawableParams.put("et", String.valueOf(paramInt));
        paramQQLiveDrawableParams.put("bf", "1");
        paramQQLiveDrawableParams.put("ef", "0");
        paramQQLiveDrawableParams.put("pp", "1");
        paramQQLiveDrawableParams.put("pa", "1");
        paramQQLiveDrawableParams.put("pb", "1");
        paramString.h = paramQQLiveDrawableParams.toString();
        label729:
        paramString = ((IEcshopAdApi)QRoute.api(IEcshopAdApi.class)).rebuildReportParam(paramString, this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemVideo.a.message);
        ((IEcshopAdHandler)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.ESHOP_AD_HANDLER)).a(paramString, null);
        this.jdField_b_of_type_Long = 0L;
        return;
        if (paramInt == 6)
        {
          paramQQLiveDrawableParams.setVisibility(0);
          paramQQLiveDrawableParams.setImageResource(2130843373);
          this.jdField_a_of_type_AndroidOsHandler.post(new PAVideoView.4(this, paramQQLiveDrawableParams));
          return;
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("PAVideoView");
            paramString.append(this.jdField_b_of_type_Int);
            paramString = paramString.toString();
            paramQQLiveDrawableParams = new StringBuilder();
            paramQQLiveDrawableParams.append("onStateChange(): onStateChange = ");
            paramQQLiveDrawableParams.append(QQLiveImage.getStateStr(paramInt));
            paramQQLiveDrawableParams.append(", stateIv == null,mVid=");
            paramQQLiveDrawableParams.append(this.jdField_b_of_type_JavaLangString);
            QLog.e(paramString, 2, paramQQLiveDrawableParams.toString());
          }
        }
        label908:
        return;
        paramString = paramString;
      }
      catch (Exception paramQQLiveDrawableParams)
      {
        break label729;
      }
    }
  }
  
  public void requestLayout()
  {
    if (!this.k) {
      super.requestLayout();
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    this.k = true;
    super.setImageDrawable(null);
    super.setImageDrawable(paramDrawable);
    this.k = false;
  }
  
  public void setRatioByMode(int paramInt, float paramFloat)
  {
    if ((paramInt == jdField_e_of_type_Int) || (paramInt == jdField_c_of_type_Int) || (paramInt == jdField_d_of_type_Int)) {
      this.jdField_c_of_type_ArrayOfFloat[paramInt] = paramFloat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PAVideoView
 * JD-Core Version:    0.7.0.1
 */