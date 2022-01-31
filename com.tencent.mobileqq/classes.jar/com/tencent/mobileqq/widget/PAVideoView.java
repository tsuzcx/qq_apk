package com.tencent.mobileqq.widget;

import actj;
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
import anoz;
import axqy;
import axzs;
import axzz;
import bbbt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.QQLiveDrawable;
import com.tencent.image.QQLiveDrawable.ErrorInfo;
import com.tencent.image.QQLiveDrawable.OnStateListener;
import com.tencent.image.QQLiveDrawable.QQLiveDrawableParams;
import com.tencent.image.QQLiveImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import nol;
import npu;
import nqu;
import nqx;
import ons;
import org.json.JSONObject;
import qtx;
import sgg;

public class PAVideoView
  extends BubbleVideoView
  implements QQLiveDrawable.OnStateListener
{
  public static anoz a;
  public static int c;
  public static int d;
  public static int e;
  public long a;
  public Handler a;
  RotateAnimation a;
  public axzs a;
  public axzz a;
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
  private boolean j;
  private boolean k = true;
  
  static
  {
    QQLiveImage.setDebugEnable(false);
    jdField_d_of_type_Int = jdField_c_of_type_Int + 1;
    jdField_e_of_type_Int = jdField_d_of_type_Int + 1;
    jdField_a_of_type_Anoz = new anoz(-2236446, 100, 100);
  }
  
  public PAVideoView(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Int = ((int)(Math.random() * 1000.0D));
    this.jdField_f_of_type_Int = jdField_c_of_type_Int;
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_c_of_type_ArrayOfFloat[jdField_c_of_type_Int] = 1.777F;
    this.jdField_c_of_type_ArrayOfFloat[jdField_d_of_type_Int] = 0.83F;
    this.jdField_c_of_type_ArrayOfFloat[jdField_e_of_type_Int] = 1.0F;
  }
  
  public static String a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qqlive://msgId=").append(paramLong);
    return localStringBuilder.toString();
  }
  
  public Shader a()
  {
    return this.jdField_b_of_type_AndroidGraphicsShader;
  }
  
  public Drawable a(String paramString)
  {
    anoz localanoz = jdField_a_of_type_Anoz;
    if (!TextUtils.isEmpty(paramString)) {}
    do
    {
      try
      {
        paramString = URLDrawable.getDrawable(paramString, jdField_a_of_type_Anoz, jdField_a_of_type_Anoz);
        return paramString;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PAVideoView" + this.jdField_b_of_type_Int, 2, "getCoverDrawable():  getDrawable Exception, mCoverUrl=" + this.jdField_a_of_type_JavaLangString, paramString);
        }
        return jdField_a_of_type_Anoz;
      }
      paramString = localanoz;
    } while (!QLog.isColorLevel());
    QLog.e("PAVideoView" + this.jdField_b_of_type_Int, 2, "getCoverDrawable():  mCoverUrl=" + this.jdField_a_of_type_JavaLangString);
    return localanoz;
  }
  
  QQLiveDrawable.QQLiveDrawableParams a(boolean paramBoolean)
  {
    QQLiveDrawable.QQLiveDrawableParams localQQLiveDrawableParams = new QQLiveDrawable.QQLiveDrawableParams();
    int m;
    if (this.g == 0)
    {
      m = 400;
      localQQLiveDrawableParams.mPreviewWidth = m;
      if (this.h != 0) {
        break label269;
      }
      m = 200;
      label35:
      localQQLiveDrawableParams.mPreviewHeight = m;
      localQQLiveDrawableParams.mPlayPause = paramBoolean;
      localQQLiveDrawableParams.mListener = this;
      localQQLiveDrawableParams.mServerType = qtx.jdField_a_of_type_JavaLangString;
      if ((this.jdField_j_of_type_Int != 2) && (this.jdField_j_of_type_Int != 4) && (this.jdField_j_of_type_Int != 6)) {
        break label277;
      }
      localQQLiveDrawableParams.mDataSourceType = 2;
      localQQLiveDrawableParams.mDataSourceAdapter = new ons(this.jdField_j_of_type_Int);
      localQQLiveDrawableParams.mPlayType = 3;
    }
    for (;;)
    {
      localQQLiveDrawableParams.mDataSource = this.jdField_b_of_type_JavaLangString;
      if ((this.jdField_j_of_type_Int == 4) && (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)))
      {
        localQQLiveDrawableParams.mDataSourceType = 1;
        localQQLiveDrawableParams.mDataSource = this.jdField_d_of_type_JavaLangString;
      }
      localQQLiveDrawableParams.mCoverUrl = this.jdField_a_of_type_JavaLangString;
      localQQLiveDrawableParams.mCoverLoadingDrawable = jdField_a_of_type_Anoz;
      if (((this.jdField_j_of_type_Int >= 1) && (this.jdField_j_of_type_Int <= 3)) || (this.jdField_j_of_type_Int == 6))
      {
        if ((this.jdField_a_of_type_Axzs.m == 0) || (this.jdField_a_of_type_Axzs.m > 8))
        {
          localQQLiveDrawableParams.mMaxPlayTimeMs = 8000;
          localQQLiveDrawableParams.mStartPosi = this.jdField_a_of_type_Axzs.l;
        }
        localQQLiveDrawableParams.mLoopback = false;
      }
      if (this.jdField_j_of_type_Int == 4)
      {
        localQQLiveDrawableParams.mMaxPlayTimeMs = (this.jdField_a_of_type_Axzs.m * 1000);
        localQQLiveDrawableParams.mLoopback = true;
      }
      return localQQLiveDrawableParams;
      m = this.g;
      break;
      label269:
      m = this.h;
      break label35;
      label277:
      localQQLiveDrawableParams.mDataSourceType = 0;
    }
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
  
  public void a(axzs paramaxzs, axzz paramaxzz)
  {
    this.g = paramaxzs.n;
    this.h = paramaxzs.o;
    this.jdField_a_of_type_JavaLangString = paramaxzs.S;
    this.jdField_b_of_type_JavaLangString = paramaxzs.U;
    if (paramaxzs.a.message == null) {}
    for (long l = 0L;; l = paramaxzs.a.message.uniseq)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_i_of_type_Int = paramaxzs.a.uinType;
      this.jdField_c_of_type_JavaLangString = paramaxzs.a.uin;
      this.jdField_j_of_type_Int = paramaxzs.r;
      this.jdField_e_of_type_JavaLangString = paramaxzs.Z;
      if ((paramaxzs.a instanceof AbsShareMsg)) {
        this.jdField_f_of_type_JavaLangString = ((AbsShareMsg)paramaxzs.a).mSourceName;
      }
      this.jdField_a_of_type_Axzs = paramaxzs;
      this.jdField_d_of_type_JavaLangString = paramaxzs.T;
      this.jdField_a_of_type_Axzz = paramaxzz;
      return;
    }
  }
  
  public void c()
  {
    this.k = true;
    QQLiveDrawable localQQLiveDrawable = a();
    if (localQQLiveDrawable != null)
    {
      localQQLiveDrawable.recyleAndKeepPostion();
      if (QLog.isColorLevel()) {
        QLog.i("PAVideoView" + this.jdField_b_of_type_Int, 2, "onMoveToScrapHeap(): recyleAndKeepPostion ");
      }
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_Axzz.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    setImageDrawable(a(this.jdField_a_of_type_JavaLangString));
    if (QLog.isColorLevel()) {
      QLog.d("PAVideoView" + this.jdField_b_of_type_Int, 2, "showCover():  mVid=" + this.jdField_b_of_type_JavaLangString);
    }
  }
  
  public void e()
  {
    this.jdField_c_of_type_Long = -1L;
    this.jdField_a_of_type_Axzz.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_Axzz.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_Axzz.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842640);
    Object localObject = a();
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PAVideoView" + this.jdField_b_of_type_Int, 2, "pausePlay(): 1. cur video pause, mVid=" + this.jdField_b_of_type_JavaLangString);
      }
      ((QQLiveDrawable)localObject).pause();
      return;
    }
    localObject = a(true);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mExtraInfo = localObject;
    localObject = URLDrawable.getDrawable(a(this.jdField_a_of_type_Long), localURLDrawableOptions);
    if (((URLDrawable)localObject).getStatus() == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PAVideoView" + this.jdField_b_of_type_Int, 2, "pausePlay(): 2. cache video Pause , mVid=" + this.jdField_b_of_type_JavaLangString);
      }
      setImageDrawable((Drawable)localObject);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PAVideoView" + this.jdField_b_of_type_Int, 2, "pausePlay(): 3. set cover, mVid=" + this.jdField_b_of_type_JavaLangString);
    }
    setImageDrawable(a(this.jdField_a_of_type_JavaLangString));
  }
  
  public void f()
  {
    if (this.jdField_j_of_type_Int != 4) {
      this.jdField_a_of_type_Axzz.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    sgg.a(this.jdField_e_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, 0, 0);
    if ((!this.jdField_a_of_type_Axzs.b) && (this.jdField_a_of_type_Axzs.a.message != null))
    {
      axqy.b(null, "dc00899", "Pb_account_lifeservice", this.jdField_a_of_type_Axzs.a.message.frienduin, "0X800682E", "0X800682E", 0, 0, this.jdField_b_of_type_JavaLangString, "" + this.jdField_j_of_type_Int, "" + this.jdField_a_of_type_Axzs.a.msgId, "");
      this.jdField_a_of_type_Axzs.b = true;
    }
    int m;
    Object localObject2;
    if ((this.jdField_a_of_type_Axzs.a.message != null) && (!bbbt.a().a(this.jdField_a_of_type_Axzs.a.message, "0X80077D9")))
    {
      m = npu.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_c_of_type_JavaLangString, this.jdField_i_of_type_Int);
      localObject2 = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject2).put("uin", this.jdField_c_of_type_JavaLangString);
      ((JSONObject)localObject2).put("memNum", m);
      ((JSONObject)localObject2).put("msg_uniseq", this.jdField_a_of_type_Axzs.a.message.uniseq);
      label264:
      if (this.jdField_e_of_type_JavaLangString != null) {}
      for (Object localObject1 = this.jdField_e_of_type_JavaLangString;; localObject1 = "0")
      {
        nol.a(null, "", "0X80077D9", "0X80077D9", 0, 0, "1", "", (String)localObject1, npu.a(null, null, this.jdField_b_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, (JSONObject)localObject2), false);
        bbbt.a().a(this.jdField_a_of_type_Axzs.a.message, "0X80077D9");
        localObject1 = a(false);
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mExtraInfo = localObject1;
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = jdField_a_of_type_Anoz;
        localObject1 = URLDrawable.getDrawable(a(this.jdField_a_of_type_Long), (URLDrawable.URLDrawableOptions)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("PAVideoView" + this.jdField_b_of_type_Int, 2, "startPlay(): new or reuse cache, mVid=" + this.jdField_b_of_type_JavaLangString);
        }
        if ((((URLDrawable)localObject1).getStatus() == 1) && ((((URLDrawable)localObject1).getCurrDrawable() instanceof QQLiveDrawable)) && (((QQLiveDrawable)((URLDrawable)localObject1).getCurrDrawable()).getPlayState() == 6))
        {
          this.jdField_a_of_type_Axzz.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          if (QLog.isColorLevel()) {
            QLog.d("PAVideoView" + this.jdField_b_of_type_Int, 2, "startPlay():reuse cache playCompleted, show play btn" + this.jdField_b_of_type_JavaLangString);
          }
        }
        setImageDrawable((Drawable)localObject1);
        return;
      }
    }
    catch (Exception localException)
    {
      break label264;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    QQLiveDrawable localQQLiveDrawable = a();
    if (localQQLiveDrawable != null) {
      localQQLiveDrawable.onDetachedFromWindow();
    }
    if (QLog.isColorLevel()) {
      QLog.i("PAVideoView" + this.jdField_b_of_type_Int, 2, "onDetachedFromWindow(): ");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int m = paramInt1;
    int n;
    float f1;
    if (this.jdField_i_of_type_Boolean)
    {
      paramInt2 = View.MeasureSpec.getSize(paramInt1);
      m = getPaddingLeft();
      n = getPaddingRight();
      f1 = this.jdField_c_of_type_ArrayOfFloat[this.jdField_f_of_type_Int];
      if (!this.jdField_c_of_type_Boolean) {
        break label118;
      }
      if (this.jdField_f_of_type_Int != jdField_c_of_type_Int) {
        break label97;
      }
      paramInt2 = BaseChatItemLayout.jdField_d_of_type_Int - BaseChatItemLayout.jdField_j_of_type_Int;
      paramInt1 = (int)(paramInt2 / f1 + 0.5F);
      m = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
      paramInt2 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
    }
    for (;;)
    {
      super.onMeasure(m, paramInt2);
      return;
      label97:
      paramInt1 = BaseChatItemLayout.jdField_d_of_type_Int - BaseChatItemLayout.jdField_j_of_type_Int;
      paramInt2 = (int)(paramInt1 * f1 + 0.5F);
      break;
      label118:
      paramInt2 = View.MeasureSpec.makeMeasureSpec((int)((paramInt2 - m - n) / f1 + 0.5F), 1073741824);
      m = paramInt1;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_b_of_type_AndroidGraphicsShader == null)
    {
      paramInt1 = actj.a(55.0F, getResources());
      if (!this.jdField_c_of_type_Boolean) {
        break label138;
      }
      if (this.jdField_f_of_type_Int != jdField_c_of_type_Int) {
        break label114;
      }
      paramInt1 = actj.a(55.0F, getResources());
    }
    label138:
    for (;;)
    {
      float f1 = paramInt2 - paramInt1;
      float f2 = paramInt2;
      Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
      this.jdField_b_of_type_AndroidGraphicsShader = new LinearGradient(0.0F, f1, 0.0F, f2, new int[] { 0, -1728053248 }, new float[] { 0.0F, 1.0F }, localTileMode);
      return;
      label114:
      if (this.jdField_f_of_type_Int == jdField_d_of_type_Int)
      {
        paramInt1 = actj.a(75.0F, getResources());
        continue;
        paramInt1 = (int)(paramInt2 * 0.6F);
      }
    }
  }
  
  public void onStateChange(String paramString, QQLiveDrawable.QQLiveDrawableParams paramQQLiveDrawableParams, int paramInt, Object paramObject)
  {
    boolean bool2 = true;
    paramQQLiveDrawableParams = this.jdField_a_of_type_Axzz.jdField_a_of_type_AndroidWidgetImageView;
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
      }
      do
      {
        return;
        if (paramInt != 2) {
          break;
        }
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        paramQQLiveDrawableParams.clearAnimation();
        paramQQLiveDrawableParams.setVisibility(8);
      } while (this.jdField_j_of_type_Int != 4);
      b(false);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new PAVideoView.2(this), 5000L);
      return;
      if (paramInt == 5) {
        if (!(paramObject instanceof QQLiveDrawable.ErrorInfo)) {
          break label822;
        }
      }
    }
    label659:
    label816:
    label822:
    for (paramString = (QQLiveDrawable.ErrorInfo)paramObject;; paramString = null)
    {
      paramQQLiveDrawableParams.setVisibility(0);
      paramQQLiveDrawableParams.setImageResource(2130842636);
      this.jdField_a_of_type_Axzz.jdField_a_of_type_AndroidViewView.setVisibility(0);
      b(true);
      this.jdField_a_of_type_AndroidOsHandler.post(new PAVideoView.3(this, paramQQLiveDrawableParams));
      if (paramString == null) {
        break;
      }
      sgg.a(this.jdField_e_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, 1, paramString.what);
      return;
      if (paramInt == 8)
      {
        if (!(paramObject instanceof Long)) {
          break label816;
        }
        long l = ((Long)paramObject).longValue();
        bool1 = bool2;
        if (l < 300L) {
          if (l != -1L) {
            break label816;
          }
        }
      }
      for (boolean bool1 = bool2;; bool1 = false) {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PAVideoView" + this.jdField_b_of_type_Int, 2, "state_init, extra = " + paramObject + " , needReport= " + bool1);
          }
          if (!bool1) {
            break;
          }
          paramInt = npu.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_c_of_type_JavaLangString, this.jdField_i_of_type_Int);
          paramQQLiveDrawableParams = new JSONObject();
          try
          {
            for (;;)
            {
              paramQQLiveDrawableParams.put("uin", this.jdField_c_of_type_JavaLangString);
              paramQQLiveDrawableParams.put("memNum", paramInt);
              paramQQLiveDrawableParams.put("msg_uniseq", this.jdField_a_of_type_Axzs.a.message.uniseq);
              label461:
              if (this.jdField_e_of_type_JavaLangString != null) {}
              for (paramString = this.jdField_e_of_type_JavaLangString;; paramString = "0")
              {
                nol.a(null, "", "0X8007414", "0X8007414", 0, 0, "1", "", paramString, npu.a(null, null, this.jdField_b_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, paramQQLiveDrawableParams), false);
                return;
              }
              if (paramInt == 4)
              {
                if ((this.jdField_j_of_type_Int != 4) || (this.jdField_b_of_type_Long == 0L)) {
                  break;
                }
                paramString = new nqx();
                paramString.a = 4;
              }
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
                paramString = nqu.a(paramString, this.jdField_a_of_type_Axzs.a.message);
                ((nqu)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(139)).a(paramString, null);
                this.jdField_b_of_type_Long = 0L;
                return;
                if (paramInt != 6) {
                  break;
                }
                paramQQLiveDrawableParams.setVisibility(0);
                paramQQLiveDrawableParams.setImageResource(2130842640);
                this.jdField_a_of_type_AndroidOsHandler.post(new PAVideoView.4(this, paramQQLiveDrawableParams));
                return;
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.e("PAVideoView" + this.jdField_b_of_type_Int, 2, "onStateChange(): onStateChange = " + QQLiveImage.getStateStr(paramInt) + ", stateIv == null,mVid=" + this.jdField_b_of_type_JavaLangString);
                return;
              }
              catch (Exception paramQQLiveDrawableParams)
              {
                break label659;
              }
            }
          }
          catch (Exception paramString)
          {
            break label461;
          }
        }
      }
    }
  }
  
  public void requestLayout()
  {
    if (!this.jdField_j_of_type_Boolean) {
      super.requestLayout();
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    this.jdField_j_of_type_Boolean = true;
    super.setImageDrawable(null);
    super.setImageDrawable(paramDrawable);
    this.jdField_j_of_type_Boolean = false;
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