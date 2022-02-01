import android.animation.ObjectAnimator;
import android.content.BroadcastReceiver;
import android.content.DialogInterface.OnClickListener;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.mediacodec.AndroidCodec;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class mha
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new mhb(this);
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new mhc(this);
  private View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private VideoController jdField_a_of_type_ComTencentAvVideoController;
  private AVActivity jdField_a_of_type_ComTencentAvUiAVActivity;
  private Queue<Long> jdField_a_of_type_JavaUtilQueue = new LinkedList();
  private mik jdField_a_of_type_Mik;
  private boolean jdField_a_of_type_Boolean;
  private ImageView[] jdField_a_of_type_ArrayOfAndroidWidgetImageView = new ImageView[4];
  private int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 2;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  
  public mha(View paramView, ViewStub paramViewStub, int paramInt, VideoController paramVideoController, AVActivity paramAVActivity)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidViewViewStub = paramViewStub;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
    this.jdField_a_of_type_ComTencentAvUiAVActivity = paramAVActivity;
    this.jdField_a_of_type_Mik = new mik(paramVideoController, paramAVActivity);
    this.jdField_a_of_type_Mik.a();
    this.jdField_a_of_type_ComTencentAvUiAVActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("tencent.video.q2v.SVIP.PAY"));
  }
  
  private void a(boolean paramBoolean)
  {
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373344);
    String str = this.jdField_a_of_type_ComTencentAvVideoController.a.getApp().getString(2131695097);
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a.getApp();
    if (paramBoolean) {}
    for (int i = 2131695096;; i = 2131695095)
    {
      localObject = ((BaseApplication)localObject).getString(i);
      mhi localmhi = new mhi(this);
      SpannableString localSpannableString = new SpannableString((CharSequence)localObject);
      localSpannableString.setSpan(localmhi, 0, ((String)localObject).length(), 18);
      localSpannableString.setSpan(new ForegroundColorSpan(-11692801), 0, ((String)localObject).length(), 17);
      localTextView.setText(str);
      localTextView.append(localSpannableString);
      localTextView.setMovementMethod(LinkMovementMethod.getInstance());
      return;
    }
  }
  
  private void h()
  {
    Object localObject4 = (RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373514);
    Object localObject3 = (RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373517);
    Object localObject2 = (RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373523);
    Object localObject1 = (RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373519);
    int i = (int)mum.a(this.jdField_a_of_type_ComTencentAvVideoController.a.getApp().getApplicationContext(), 4.0F);
    int j = (int)mum.a(this.jdField_a_of_type_ComTencentAvVideoController.a.getApp().getApplicationContext(), 132.0F);
    int k = (int)mum.a(this.jdField_a_of_type_ComTencentAvVideoController.a.getApp().getApplicationContext(), 8.0F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.width = j;
    ((RelativeLayout)localObject4).setLayoutParams(localLayoutParams);
    localObject4 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject4).addRule(1, 2131373514);
    ((RelativeLayout.LayoutParams)localObject4).leftMargin = i;
    ((RelativeLayout.LayoutParams)localObject4).width = j;
    ((RelativeLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131373514);
    ((RelativeLayout.LayoutParams)localObject3).addRule(7, 2131373514);
    ((RelativeLayout.LayoutParams)localObject3).addRule(3, 2131373514);
    ((RelativeLayout.LayoutParams)localObject3).topMargin = i;
    ((RelativeLayout.LayoutParams)localObject3).width = j;
    ((RelativeLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131373517);
    ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131373517);
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131373517);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = i;
    ((RelativeLayout.LayoutParams)localObject2).width = j;
    ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(8, 2131373525);
    ((RelativeLayout.LayoutParams)localObject1).addRule(14, -1);
    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = k;
    ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373526)).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(8, 2131373521);
    ((RelativeLayout.LayoutParams)localObject1).addRule(14, -1);
    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = k;
    ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373522)).setLayoutParams((ViewGroup.LayoutParams)localObject1);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)
    {
      this.jdField_a_of_type_AndroidViewViewStub.inflate();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0] = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373515));
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0].setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1] = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373518));
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1].setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2] = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373525));
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2].setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373526)).setText(this.jdField_a_of_type_ComTencentAvVideoController.a().n);
      if (AndroidCodec.sIsSupportHwCodec1080P)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373519).setVisibility(0);
        this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[3] = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373521));
        this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[3].setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
        ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373522)).setText(this.jdField_a_of_type_ComTencentAvVideoController.a().n);
        h();
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new mhh(this));
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_Mik.a();
    }
    this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoController.a().w;
    j();
  }
  
  private void j()
  {
    ImageView localImageView = this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0];
    Resources localResources = this.jdField_a_of_type_AndroidViewView.getResources();
    if (this.jdField_b_of_type_Int == 0)
    {
      i = 2130842274;
      localImageView.setBackgroundDrawable(localResources.getDrawable(i));
      localImageView = this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1];
      localResources = this.jdField_a_of_type_AndroidViewView.getResources();
      if (this.jdField_b_of_type_Int != 1) {
        break label157;
      }
      i = 2130842272;
      label62:
      localImageView.setBackgroundDrawable(localResources.getDrawable(i));
      localImageView = this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2];
      localResources = this.jdField_a_of_type_AndroidViewView.getResources();
      if (this.jdField_b_of_type_Int != 2) {
        break label164;
      }
      i = 2130842278;
      label98:
      localImageView.setBackgroundDrawable(localResources.getDrawable(i));
      if (AndroidCodec.sIsSupportHwCodec1080P)
      {
        localImageView = this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[3];
        localResources = this.jdField_a_of_type_AndroidViewView.getResources();
        if (this.jdField_b_of_type_Int != 3) {
          break label171;
        }
      }
    }
    label157:
    label164:
    label171:
    for (int i = 2130842276;; i = 2130842275)
    {
      localImageView.setBackgroundDrawable(localResources.getDrawable(i));
      return;
      i = 2130842273;
      break;
      i = 2130842271;
      break label62;
      i = 2130842277;
      break label98;
    }
  }
  
  private void k()
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0)) {
      return;
    }
    a();
  }
  
  private void l()
  {
    j();
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      lez locallez = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (locallez != null) {
        this.jdField_a_of_type_ComTencentAvVideoController.a(Long.valueOf(locallez.jdField_d_of_type_JavaLangString).longValue(), this.jdField_b_of_type_Int);
      }
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int + 1;
  }
  
  public void a()
  {
    i();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_ComTencentAvUiAVActivity == null) || (this.jdField_a_of_type_ComTencentAvUiAVActivity.a == null) || (this.jdField_a_of_type_AndroidViewView == null)) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
          } while ((localObject == null) || (((lez)localObject).jdField_d_of_type_Int != 2) || ((this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean)) || ((this.jdField_a_of_type_ComTencentAvVideoController.a().w != 0) && (this.jdField_a_of_type_ComTencentAvVideoController.a().w != 2)) || (this.jdField_a_of_type_ComTencentAvUiAVActivity.b() != 2));
          localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131373425);
        } while (((localObject != null) && (((View)localObject).getVisibility() == 0)) || (this.jdField_a_of_type_AndroidViewView.findViewById(2131373552).getVisibility() != 0));
        if (paramInt < 2) {
          break;
        }
      } while ((!AndroidCodec.sIsSupportHwCodec1080P) || (this.jdField_c_of_type_Boolean));
      QLog.i("QavDoubleVideoSharpnessMangaer", 1, "onNetworkQualityChanged. networkQuality = " + paramInt);
      this.jdField_a_of_type_ComTencentAvUiAVActivity.a.L();
      this.jdField_a_of_type_ComTencentAvUiAVActivity.a.C(AudioHelper.b());
      localObject = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373343);
      a(true);
      ((RelativeLayout)localObject).setVisibility(0);
      this.jdField_c_of_type_Boolean = true;
      bcef.b(null, "CliOper", "", "", "0X800AA5D", "0X800AA5D", 4, 0, "", "", "", "");
      return;
    } while ((paramInt < 1) || (this.jdField_b_of_type_Boolean));
    QLog.i("QavDoubleVideoSharpnessMangaer", 1, "onNetworkQualityChanged. networkQuality = " + paramInt);
    this.jdField_a_of_type_ComTencentAvUiAVActivity.a.L();
    this.jdField_a_of_type_ComTencentAvUiAVActivity.a.C(AudioHelper.b());
    Object localObject = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373343);
    a(true);
    ((RelativeLayout)localObject).setVisibility(0);
    this.jdField_b_of_type_Boolean = true;
    bcef.b(null, "CliOper", "", "", "0X800AA5D", "0X800AA5D", 3, 0, "", "", "", "");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_ComTencentAvVideoController.a == null)) {}
    do
    {
      do
      {
        lez locallez;
        do
        {
          return;
          locallez = this.jdField_a_of_type_ComTencentAvVideoController.a();
        } while ((locallez == null) || (locallez.jdField_d_of_type_Int != 2));
        if ((paramInt1 < 1920) || (paramInt2 < 1080)) {
          break;
        }
      } while (this.e);
      QLog.i("QavDoubleVideoSharpnessMangaer", 1, "onRecvVideoResolutionChanged. w = " + paramInt1 + ", h = " + paramInt2);
      mak.a(this.jdField_a_of_type_ComTencentAvVideoController.a, 1058, this.jdField_a_of_type_ComTencentAvVideoController.a.getApp().getString(2131695315));
      this.e = true;
      bcef.b(null, "CliOper", "", "", "0X800AA60", "0X800AA60", 4, 0, "", "", "", "");
      return;
    } while ((paramInt1 < 1280) || (paramInt2 < 720) || (this.d));
    QLog.i("QavDoubleVideoSharpnessMangaer", 1, "onRecvVideoResolutionChanged. w = " + paramInt1 + ", h = " + paramInt2);
    mak.a(this.jdField_a_of_type_ComTencentAvVideoController.a, 1058, this.jdField_a_of_type_ComTencentAvVideoController.a.getApp().getString(2131695316));
    this.d = true;
    bcef.b(null, "CliOper", "", "", "0X800AA60", "0X800AA60", 3, 0, "", "", "", "");
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.jdField_a_of_type_JavaUtilQueue.size() < 5)
    {
      this.jdField_a_of_type_JavaUtilQueue.offer(Long.valueOf(paramLong2));
      if (this.jdField_a_of_type_JavaUtilQueue.size() != 5) {
        break label238;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilQueue.iterator();
      paramLong1 = 0L;
      label53:
      if (!localIterator.hasNext()) {
        break label118;
      }
      if (((Long)localIterator.next()).longValue() >= msu.b()) {
        break label239;
      }
      paramLong1 = 1L + paramLong1;
    }
    label238:
    label239:
    for (;;)
    {
      break label53;
      this.jdField_a_of_type_JavaUtilQueue.poll();
      this.jdField_a_of_type_JavaUtilQueue.offer(Long.valueOf(paramLong2));
      break;
      label118:
      if (paramLong1 >= 4L)
      {
        paramLong2 = System.currentTimeMillis();
        if (paramLong2 - this.jdField_a_of_type_Long > 10000L)
        {
          this.jdField_a_of_type_Long = paramLong2;
          mak.a(this.jdField_a_of_type_ComTencentAvVideoController.a, 1057, amtj.a(2131708019));
          bcef.b(null, "CliOper", "", "", "0X800A346", "0X800A346", 0, 0, "", "", "", "");
        }
        if (QLog.isColorLevel()) {
          QLog.w("QavDoubleVideoSharpnessMangaer", 1, "onReceiveFrameRateInfo frameRate sum/5:=" + paramLong1 / 5L);
        }
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, String paramString, int paramInt2)
  {
    QLog.i("QavDoubleVideoSharpnessMangaer", 1, "onReceiveFrameModeResultInfo. isS2CPush = " + paramBoolean + ", retCode = " + paramInt1 + ", wording = " + paramString + ", videoMode = " + paramInt2);
    if (!paramBoolean)
    {
      if ((paramInt1 != 0) && (!TextUtils.isEmpty(paramString))) {
        mak.a(this.jdField_a_of_type_ComTencentAvVideoController.a, 1057, paramString);
      }
      return;
    }
    int i;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().w != paramInt2)
    {
      i = 1;
      if ((paramInt1 != 0) || (paramInt2 < 0) || (paramInt2 >= 4)) {
        break label287;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a().w = paramInt2;
      this.jdField_a_of_type_JavaUtilQueue.clear();
      QLog.i("QavDoubleVideoSharpnessMangaer", 1, "onReceiveFrameModeResultInfo. newSharpnessMode = " + paramInt2);
    }
    for (;;)
    {
      if (paramInt1 == 10000) {
        bcef.b(null, "CliOper", "", "", "0X800AA5F", "0X800AA5F", 4, 0, "", "", "", "");
      }
      if (!TextUtils.isEmpty(paramString)) {
        mak.a(this.jdField_a_of_type_ComTencentAvVideoController.a, 1057, paramString);
      }
      if ((paramInt1 == 0) && (i != 0))
      {
        k();
        long l = AudioHelper.b();
        this.jdField_a_of_type_ComTencentAvUiAVActivity.a.i(l, 1024);
      }
      this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoController.a().w;
      return;
      i = 0;
      break;
      label287:
      QLog.e("QavDoubleVideoSharpnessMangaer", 1, "onReceiveFrameModeResultInfo. error. newSharpnessMode = " + paramInt2);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0);
  }
  
  public void b()
  {
    i();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetRelativeLayout, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator.setDuration(500L);
    localObjectAnimator.setStartDelay(300L);
    localObjectAnimator.addListener(new mhf(this));
    localObjectAnimator.start();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
  
  public void d()
  {
    ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373343)).setVisibility(4);
    i();
    boolean bool = this.jdField_a_of_type_Mik.a();
    int j = Calendar.getInstance().get(11) * 60 + Calendar.getInstance().get(12);
    QLog.i("QavDoubleVideoSharpnessMangaer", 1, "switchToHDMode. curMinute = " + j + ", startTime = " + this.jdField_a_of_type_ComTencentAvVideoController.a().x + ", endTime = " + this.jdField_a_of_type_ComTencentAvVideoController.a().y + ", tips = " + this.jdField_a_of_type_ComTencentAvVideoController.a().n + ", m1080PHDModeTipsHasShowed = " + this.jdField_c_of_type_Boolean);
    if (this.jdField_c_of_type_Boolean)
    {
      i = 3;
      bcef.b(null, "CliOper", "", "", "0X800AA5E", "0X800AA5E", i + 1, 0, "", "", "", "");
      if ((!bool) && ((this.jdField_a_of_type_ComTencentAvVideoController.a().x > j) || (j >= this.jdField_a_of_type_ComTencentAvVideoController.a().y))) {
        break label252;
      }
      if (!this.jdField_c_of_type_Boolean) {
        break label247;
      }
    }
    label247:
    for (int i = 3;; i = 2)
    {
      this.jdField_b_of_type_Int = i;
      l();
      return;
      i = 2;
      break;
    }
    label252:
    this.jdField_a_of_type_Boolean = true;
    Object localObject = new mhg(this);
    localObject = bfur.a(this.jdField_a_of_type_ComTencentAvUiAVActivity, 0, amtj.a(2131708014), null, amtj.a(2131708015), amtj.a(2131708016), (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
    if (localObject != null) {
      ((QQCustomDialog)localObject).show();
    }
    bcef.b(null, "CliOper", "", "", "0X800A562", "0X800A562", 0, 0, "", "", "", "");
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Mik != null) {
      this.jdField_a_of_type_Mik.b();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Mik != null) {
      this.jdField_a_of_type_Mik.d();
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Mik != null)
    {
      this.jdField_a_of_type_Mik.e();
      this.jdField_a_of_type_Mik = null;
    }
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity != null) {
      this.jdField_a_of_type_ComTencentAvUiAVActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
    if (QLog.isColorLevel()) {
      QLog.w("QavDoubleVideoSharpnessMangaer", 1, "doDestroy");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mha
 * JD-Core Version:    0.7.0.1
 */