package cooperation.vip.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.adv.common.data.AlumBasicData;
import com.tencent.mobileqq.vas.adv.qzone.api.IVasQZoneApi;
import com.tencent.mobileqq.vas.adv.qzone.data.VasAdMetaReportParam.Builder;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;

public class VipGeneralGdtShowView
{
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new VipGeneralGdtShowView.1(this);
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private GdtAppReceiver jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver;
  private AlumBasicData jdField_a_of_type_ComTencentMobileqqVasAdvCommonDataAlumBasicData;
  VipGeneralGdtShowView.VipGeneralGdtClickListner jdField_a_of_type_CooperationVipWidgetVipGeneralGdtShowView$VipGeneralGdtClickListner;
  private int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int jdField_c_of_type_Int;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private int jdField_d_of_type_Int;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private int jdField_e_of_type_Int;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private int f;
  
  public VipGeneralGdtShowView(Context paramContext, int paramInt1, int paramInt2, int paramInt3, GdtAppReceiver paramGdtAppReceiver)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(paramInt1, null);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    if (paramGdtAppReceiver == null)
    {
      this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = new GdtAppReceiver();
      this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver.register(this.jdField_a_of_type_AndroidContentContext);
    }
    else
    {
      this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = paramGdtAppReceiver;
    }
    this.jdField_d_of_type_Int = paramInt3;
  }
  
  private void a(AlumBasicData paramAlumBasicData)
  {
    URLDrawable localURLDrawable = URLDrawable.getDrawable(paramAlumBasicData.advimageUrl, null);
    if (localURLDrawable != null)
    {
      this.jdField_e_of_type_Int = paramAlumBasicData.imageWith;
      this.f = paramAlumBasicData.imageHeight;
      int j = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels - ViewUtils.b(56.0F);
      int i = this.jdField_e_of_type_Int;
      if (i != 0)
      {
        int k = this.f;
        if (k != 0)
        {
          double d1 = k;
          double d2 = i;
          Double.isNaN(d2);
          Double.isNaN(d1);
          d1 /= d2 * 1.0D;
          d2 = j;
          Double.isNaN(d2);
          i = (int)(d1 * d2);
          break label125;
        }
      }
      i = 0;
      label125:
      if (i != 0)
      {
        Object localObject = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = i;
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" @getGdtInfo height  =");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append("contrlwith =");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append("imagewith =");
        ((StringBuilder)localObject).append(this.jdField_e_of_type_Int);
        ((StringBuilder)localObject).append("imageheight =");
        ((StringBuilder)localObject).append(this.f);
        QZLog.i("VipGeneralGdtShowView", ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localURLDrawable);
      if (paramAlumBasicData.hasExposed == 0)
      {
        paramAlumBasicData.hasExposed = 1;
        a(paramAlumBasicData.qqbexposureInfor);
        a(1, paramAlumBasicData.recCookie, 0);
      }
    }
  }
  
  private void b(AlumBasicData paramAlumBasicData)
  {
    Drawable localDrawable = this.jdField_a_of_type_AndroidWidgetTextView.getResources().getDrawable(2130840321);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    localURLDrawableOptions.mUseMemoryCache = false;
    paramAlumBasicData = URLDrawable.getDrawable(paramAlumBasicData.advLogoUrl, localURLDrawableOptions);
    if ((this.jdField_c_of_type_Int == 3) && (!SimpleUIUtil.a()))
    {
      paramAlumBasicData.setTag(URLDrawableDecodeHandler.a(ViewUtils.a(40.0F), ViewUtils.a(40.0F)));
      paramAlumBasicData.setDecodeHandler(URLDrawableDecodeHandler.n);
    }
    else
    {
      paramAlumBasicData.setTag(URLDrawableDecodeHandler.b(ViewUtils.a(40.0F), ViewUtils.a(40.0F), ViewUtils.a(3.5F)));
      paramAlumBasicData.setDecodeHandler(URLDrawableDecodeHandler.i);
    }
    if (paramAlumBasicData != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramAlumBasicData);
    }
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      long l = 0L;
      if ((localObject instanceof QQAppInterface)) {
        l = ((QQAppInterface)localObject).getLongAccountUin();
      }
      localObject = new VasAdMetaReportParam.Builder();
      ((VasAdMetaReportParam.Builder)localObject).setAdvPos(Integer.valueOf(this.jdField_c_of_type_Int));
      ((VasAdMetaReportParam.Builder)localObject).setUin(Long.valueOf(l));
      ((VasAdMetaReportParam.Builder)localObject).setActionType(Integer.valueOf(paramInt1));
      ((VasAdMetaReportParam.Builder)localObject).setRecommendCookie(paramString);
      ((VasAdMetaReportParam.Builder)localObject).setFeedIndex(Integer.valueOf(paramInt2));
      ((VasAdMetaReportParam.Builder)localObject).setActionType(Integer.valueOf(1));
      ((IVasQZoneApi)QRoute.api(IVasQZoneApi.class)).reportAdvAsync(((VasAdMetaReportParam.Builder)localObject).build());
      return;
    }
    QZLog.i("VipGeneralGdtShowView", " @getGdtInfo sendBusinessReport");
  }
  
  public void a(View paramView, VipGeneralGdtShowView.VipGeneralGdtClickListner paramVipGeneralGdtClickListner)
  {
    if (paramView == null) {
      return;
    }
    this.jdField_a_of_type_CooperationVipWidgetVipGeneralGdtShowView$VipGeneralGdtClickListner = paramVipGeneralGdtClickListner;
    QZLog.i("VipGeneralGdtShowView", " @getGdtInfo initAdvView");
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131367607));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367616));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367617));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367619));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367615));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367620));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367621));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367618));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  public void a(AlumBasicData paramAlumBasicData, int paramInt)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqVasAdvCommonDataAlumBasicData = paramAlumBasicData;
      this.jdField_b_of_type_Int = (paramInt + 1);
      if ((paramAlumBasicData != null) && (!TextUtils.isEmpty(paramAlumBasicData.advimageUrl)) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_c_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView != null))
      {
        b(paramAlumBasicData);
        a(paramAlumBasicData);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(paramAlumBasicData.leftBottomText);
        this.jdField_e_of_type_AndroidWidgetTextView.setText(paramAlumBasicData.rightBottomButton);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramAlumBasicData.advTextTitle);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramAlumBasicData.advTextText);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        if (QZLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("setDataChanged titile =");
          localStringBuilder.append(paramAlumBasicData.advTextTitle);
          localStringBuilder.append(" desc =");
          localStringBuilder.append(paramAlumBasicData.advTextText);
          localStringBuilder.append(" url =");
          localStringBuilder.append(paramAlumBasicData.advimageUrl);
          QZLog.i("VipGeneralGdtShowView", localStringBuilder.toString());
        }
      }
      else
      {
        if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        }
        QZLog.i("VipGeneralGdtShowView", " @getGdtInfo setDataChanged is null");
        return;
      }
    }
    catch (Exception paramAlumBasicData)
    {
      QZLog.e("VipGeneralGdtShowView", paramAlumBasicData.toString());
    }
  }
  
  public void a(String paramString)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").postDelayed(new VipGeneralGdtShowView.2(this, paramString), 0L);
  }
  
  public void a(WeakReference<Activity> paramWeakReference, int paramInt)
  {
    GdtHandler.Params localParams = new GdtHandler.Params();
    localParams.jdField_c_of_type_Int = paramInt;
    if (paramWeakReference != null)
    {
      localParams.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
      localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd = new GdtAd(this.jdField_a_of_type_ComTencentMobileqqVasAdvCommonDataAlumBasicData.adInfo);
      localParams.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver);
      localParams.jdField_a_of_type_Boolean = true;
      localParams.jdField_b_of_type_Boolean = true;
      localParams.jdField_a_of_type_AndroidOsBundle = new Bundle();
      if (this.jdField_c_of_type_Int == 3) {
        localParams.jdField_a_of_type_AndroidOsBundle.putString("big_brother_ref_source_key", "biz_src_jc_kuolie");
      }
      GdtHandler.a(localParams);
      QZLog.i("VipGeneralGdtShowView", " @getGdtInfo clickAdvInfoToQiQiaoBan");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.widget.VipGeneralGdtShowView
 * JD-Core Version:    0.7.0.1
 */