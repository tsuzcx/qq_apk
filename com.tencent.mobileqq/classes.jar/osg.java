import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ImageCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class osg
  extends ViewBase
  implements View.OnClickListener
{
  private static final Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#E9E9E9"));
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private NativeReadInjoyImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView;
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private osk jdField_a_of_type_Osk;
  private pxk jdField_a_of_type_Pxk;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private NativeReadInjoyImageView jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView;
  private URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  private osk jdField_b_of_type_Osk;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private NativeReadInjoyImageView jdField_c_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView;
  private URLImageView jdField_c_of_type_ComTencentImageURLImageView;
  private int jdField_d_of_type_Int;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private NativeReadInjoyImageView jdField_d_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView;
  private URLImageView jdField_d_of_type_ComTencentImageURLImageView;
  private int jdField_e_of_type_Int;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private NativeReadInjoyImageView jdField_e_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView;
  private URLImageView jdField_e_of_type_ComTencentImageURLImageView;
  private int jdField_f_of_type_Int;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private NativeReadInjoyImageView jdField_f_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView;
  private URLImageView jdField_f_of_type_ComTencentImageURLImageView;
  private int jdField_g_of_type_Int;
  private URLImageView jdField_g_of_type_ComTencentImageURLImageView;
  private int jdField_h_of_type_Int;
  private URLImageView jdField_h_of_type_ComTencentImageURLImageView;
  private int i;
  
  public osg(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_AndroidContentContext = paramVafContext.getContext();
    a(this.jdField_a_of_type_AndroidContentContext);
    c();
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 + paramInt2 - paramInt3 / 2;
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131562747, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView = ((NativeReadInjoyImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380363));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368339));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView = ((NativeReadInjoyImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368452));
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView = ((NativeReadInjoyImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368453));
    this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView = ((NativeReadInjoyImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368454));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362040));
    this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView = ((NativeReadInjoyImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367549));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131367546));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362040));
    this.jdField_f_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView = ((NativeReadInjoyImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367544));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367547));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367553));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367545));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362109));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362106));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369780));
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376571));
    this.jdField_c_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369743));
    this.jdField_d_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376528));
    this.jdField_e_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367551));
    this.jdField_f_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367555));
    this.jdField_g_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367550));
    this.jdField_h_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367554));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setOnClickListener(this);
    this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setOnClickListener(this);
    this.jdField_f_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new osh(this));
  }
  
  private void a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    if (paramFloat1 < paramFloat2) {
      return;
    }
    paramFloat2 = (paramFloat1 - paramFloat2) * paramFloat3;
    paramFloat1 = paramFloat2;
    if (paramFloat2 > 1.0F) {
      paramFloat1 = 1.0F;
    }
    paramView.setTranslationY((paramFloat1 - 1.0F) * paramInt);
    paramView.setAlpha(paramFloat1);
  }
  
  private void a(RelativeLayout.LayoutParams paramLayoutParams, float paramFloat, int paramInt)
  {
    float f1 = 1.0F;
    if (paramFloat >= 0.33F)
    {
      paramLayoutParams.height = paramInt;
      return;
    }
    paramFloat = 3.0F * paramFloat;
    if (paramFloat > 1.0F) {
      paramFloat = f1;
    }
    for (;;)
    {
      paramLayoutParams.height = ((int)(paramFloat * paramInt));
      return;
    }
  }
  
  private void a(RelativeLayout.LayoutParams paramLayoutParams, float paramFloat1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat2)
  {
    paramLayoutParams.leftMargin = ((int)(paramInt3 * paramFloat1) + paramInt1);
    paramLayoutParams.topMargin = ((int)(paramInt4 * paramFloat1) + paramInt2);
    float f1 = this.jdField_a_of_type_Osk.jdField_a_of_type_Int - paramInt5 * paramFloat1;
    QLog.d("ANGLE_DEV", 4, "angle = " + f1);
    this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setRotation(f1);
    this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setScaleX(this.jdField_a_of_type_Osk.jdField_a_of_type_Float + paramFloat2 * paramFloat1);
    this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setScaleY(this.jdField_a_of_type_Osk.jdField_a_of_type_Float + paramFloat2 * paramFloat1);
    this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setLayoutParams(paramLayoutParams);
  }
  
  private void a(JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.optString("img_start_position");
    String str = paramJSONObject.optString("img_end_position");
    int j = paramJSONObject.optInt("img_start_size", 100);
    int k = paramJSONObject.optInt("img_end_size", 100);
    int m = paramJSONObject.optInt("img_start_angle", 0);
    int n = paramJSONObject.optInt("img_end_angle", 360);
    paramJSONObject = new int[2];
    JSONObject tmp64_63 = paramJSONObject;
    tmp64_63[0] = 0;
    JSONObject tmp68_64 = tmp64_63;
    tmp68_64[1] = 0;
    tmp68_64;
    a(paramJSONObject, (String)localObject);
    int i1 = paramJSONObject[0];
    int i2 = paramJSONObject[1];
    a(paramJSONObject, str);
    int i3 = paramJSONObject[0];
    int i4 = paramJSONObject[1];
    paramJSONObject = new osk();
    paramJSONObject.jdField_a_of_type_Float = (j / 100.0F);
    paramJSONObject.jdField_a_of_type_Int = m;
    paramJSONObject.jdField_b_of_type_Int = afur.a(i1 / 2, this.jdField_a_of_type_AndroidContentContext.getResources());
    paramJSONObject.jdField_c_of_type_Int = afur.a(i2 / 2, this.jdField_a_of_type_AndroidContentContext.getResources());
    localObject = new osk();
    ((osk)localObject).jdField_a_of_type_Float = (k / 100.0F);
    ((osk)localObject).jdField_a_of_type_Int = n;
    ((osk)localObject).jdField_b_of_type_Int = afur.a(i3 / 2, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((osk)localObject).jdField_c_of_type_Int = afur.a(i4 / 2, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_Osk = paramJSONObject;
    this.jdField_b_of_type_Osk = ((osk)localObject);
  }
  
  private void a(int[] paramArrayOfInt, String paramString)
  {
    if (paramString.contains(","))
    {
      paramString = paramString.split(",");
      if (paramString.length < 2) {}
    }
    try
    {
      paramArrayOfInt[0] = Integer.parseInt(paramString[0]);
      paramArrayOfInt[1] = Integer.parseInt(paramString[1]);
      return;
    }
    catch (Exception paramArrayOfInt) {}
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Osk == null) || (this.jdField_b_of_type_Osk == null) || (this.jdField_b_of_type_Boolean)) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.getLayoutParams();
    int j = localLayoutParams2.leftMargin;
    int k = localLayoutParams2.topMargin;
    int m = a(this.i, this.jdField_b_of_type_Osk.jdField_b_of_type_Int, this.jdField_d_of_type_Int);
    int n = a(this.jdField_h_of_type_Int, this.jdField_b_of_type_Osk.jdField_c_of_type_Int, this.jdField_e_of_type_Int);
    m -= j;
    n -= k;
    int i1 = -this.jdField_b_of_type_Osk.jdField_a_of_type_Int + this.jdField_a_of_type_Osk.jdField_a_of_type_Int;
    float f1 = this.jdField_b_of_type_Osk.jdField_a_of_type_Float - this.jdField_a_of_type_Osk.jdField_a_of_type_Float;
    if (paramBoolean)
    {
      a(localLayoutParams2, 1.0F, j, k, m, n, i1, f1);
      a(localLayoutParams1, 1.0F, this.jdField_c_of_type_Int);
      a(this.jdField_b_of_type_AndroidWidgetTextView, 1.0F, 0.2F, 1.7F, afur.a(34.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      a(this.jdField_c_of_type_AndroidWidgetTextView, 1.0F, 0.2F, 2.0F, afur.a(34.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      a(this.jdField_d_of_type_AndroidWidgetTextView, 1.0F, 0.2F, 2.0F, afur.a(34.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.addUpdateListener(new osi(this, localLayoutParams2, j, k, m, n, i1, f1, localLayoutParams1));
    localValueAnimator.addListener(new osj(this));
    localValueAnimator.setDuration(412L);
    localValueAnimator.start();
  }
  
  private void c()
  {
    this.jdField_c_of_type_Int = afur.a(84.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_e_of_type_Int = afur.a(60.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_d_of_type_Int = afur.a(60.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_Int = afur.a(52.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_b_of_type_Int = afur.a(135.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(0);
    this.jdField_c_of_type_ComTencentImageURLImageView.setVisibility(0);
    this.jdField_d_of_type_ComTencentImageURLImageView.setVisibility(0);
    this.jdField_e_of_type_ComTencentImageURLImageView.setVisibility(0);
    this.jdField_f_of_type_ComTencentImageURLImageView.setVisibility(0);
    this.jdField_g_of_type_ComTencentImageURLImageView.setVisibility(0);
    this.jdField_h_of_type_ComTencentImageURLImageView.setVisibility(0);
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().height = afur.a(128.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_b_of_type_Int = afur.a(128.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#40A0FF"));
    int j = afur.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_f_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setCorner(j, j, j, j);
  }
  
  private void f()
  {
    this.jdField_a_of_type_Boolean = true;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.getLayoutParams();
    localLayoutParams.leftMargin = a(this.jdField_g_of_type_Int, this.jdField_a_of_type_Osk.jdField_b_of_type_Int, this.jdField_d_of_type_Int);
    localLayoutParams.topMargin = a(this.jdField_f_of_type_Int, this.jdField_a_of_type_Osk.jdField_c_of_type_Int, this.jdField_e_of_type_Int);
    this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setLayoutParams(localLayoutParams);
    this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setRotation(this.jdField_a_of_type_Osk.jdField_a_of_type_Int);
    this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setScaleX(this.jdField_a_of_type_Osk.jdField_a_of_type_Float);
    this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setScaleY(this.jdField_a_of_type_Osk.jdField_a_of_type_Float);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).height = 0;
  }
  
  protected void a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdImgList == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdImgList.size() < 3)) {}
    for (;;)
    {
      return;
      Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = afur.a(28.0F, this.jdField_a_of_type_AndroidViewView.getResources());
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = afur.a(28.0F, this.jdField_a_of_type_AndroidViewView.getResources());
      ((URLDrawable.URLDrawableOptions)localObject1).mMemoryCacheKeySuffix = "brand_user_icon";
      Object localObject3 = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdCorporateLogo, (URLDrawable.URLDrawableOptions)localObject1);
      ((URLDrawable)localObject3).setTag(bgey.b(((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth, ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight, afur.a(25.0F, this.jdField_a_of_type_AndroidViewView.getResources())));
      ((URLDrawable)localObject3).setDecodeHandler(bgey.j);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageDrawable((Drawable)localObject3);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mSubscribeName);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mArticleSubscriptText);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mTitle);
      a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView, (String)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdImgList.get(0), jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      a(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView, (String)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdImgList.get(1), jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      a(this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView, (String)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdImgList.get(2), jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdExtInfo;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("BrandOptimizationView", 2, "brand extJson is empty ");
        return;
      }
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        if (localObject1 == null) {
          continue;
        }
        localObject3 = ((JSONObject)localObject1).optString("goods_small_img");
        String str1 = ((JSONObject)localObject1).optString("goods_bottom_img");
        String str2 = ((JSONObject)localObject1).optString("goods_price");
        String str3 = ((JSONObject)localObject1).optString("goods_title");
        a(this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView, (String)localObject3, jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        a(this.jdField_f_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView, str1, jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        a((JSONObject)localObject1);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdBtnTxt);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(str3);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(str2);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isShowBrandAnimate = false;
        if (!this.jdField_a_of_type_Boolean) {
          continue;
        }
        f();
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("BrandOptimizationView", 2, localJSONException.getMessage());
          }
          Object localObject2 = null;
        }
      }
    }
  }
  
  public void a(NativeReadInjoyImageView paramNativeReadInjoyImageView, String paramString, Drawable paramDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BrandOptimizationView", 2, "loadImage: path is " + paramString);
    }
    if ((paramString != null) && (!paramString.equals("-1")))
    {
      if ((!paramString.startsWith("http")) && (!paramString.startsWith("pubaccount"))) {
        break label83;
      }
      if (paramDrawable != null) {
        paramNativeReadInjoyImageView.setImagePlaceHolder(paramDrawable);
      }
      paramNativeReadInjoyImageView.setImageSrc(paramString);
    }
    label83:
    do
    {
      return;
      paramString = ImageCommon.getDrawableResourceId(paramString);
    } while (paramString == null);
    if (QLog.isColorLevel()) {
      QLog.d("BrandOptimizationView", 2, "loadImage: cant find in offline dir, try to load from resources");
    }
    try
    {
      paramNativeReadInjoyImageView.setImageDrawable(paramNativeReadInjoyImageView.getResources().getDrawable(paramString.intValue()));
      return;
    }
    catch (Resources.NotFoundException paramNativeReadInjoyImageView)
    {
      QLog.d("BrandOptimizationView", 2, "loadImage: cant find in resources dir, do nothing");
    }
  }
  
  public void a(pxk parampxk)
  {
    this.jdField_a_of_type_Pxk = parampxk;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      d();
      e();
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isShowBrandAnimate) {
      return;
    }
    b(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isShowBrandAnimate = true;
  }
  
  public int getComMeasuredHeight()
  {
    return this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.jdField_a_of_type_AndroidViewView.getMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onClick(View paramView)
  {
    int j;
    switch (paramView.getId())
    {
    default: 
      j = 0;
    }
    for (;;)
    {
      oml localoml = new oml();
      if (j == 8) {
        localoml.c = true;
      }
      oqj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, j, null);
      ubb.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_Pxk.a(), this.jdField_a_of_type_Pxk.e(), false, oqi.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo), localoml);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      j = 2;
      continue;
      j = 3;
      continue;
      j = 1;
      continue;
      j = 4;
      continue;
      j = 5;
      continue;
      j = 8;
      continue;
      j = 2001;
      continue;
      j = 2002;
      continue;
      j = 2003;
    }
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_AndroidViewView.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewView.measure(paramInt1, paramInt2);
    if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isShowBrandAnimate) && (this.jdField_a_of_type_Osk != null) && (this.jdField_b_of_type_Osk != null))
    {
      paramInt1 = this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredHeight();
      this.jdField_f_of_type_Int = (this.jdField_a_of_type_Int + paramInt1 + afur.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      this.jdField_g_of_type_Int = 0;
      this.jdField_h_of_type_Int = (paramInt1 + this.jdField_a_of_type_Int + this.jdField_b_of_type_Int + afur.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      this.i = afur.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      f();
    }
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    a();
    refresh();
  }
  
  public void reset()
  {
    super.reset();
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageSrc(null);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageSrc(null);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageSrc(null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isShowBrandAnimate = false;
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    switch (paramInt)
    {
    default: 
      bool1 = super.setAttribute(paramInt, paramObject);
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (paramObject != null)
      {
        bool1 = bool2;
        try
        {
          if ((paramObject instanceof AdvertisementInfo))
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = ((AdvertisementInfo)paramObject);
            return true;
          }
        }
        catch (Exception paramObject)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = null;
          QLog.d("BrandOptimizationView", 1, "setAttribute STR_ID_SET_AD_BANNER exception " + paramObject.toString());
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     osg
 * JD-Core Version:    0.7.0.1
 */