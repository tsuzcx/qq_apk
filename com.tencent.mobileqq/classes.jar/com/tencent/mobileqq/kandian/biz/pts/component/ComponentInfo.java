package com.tencent.mobileqq.kandian.biz.pts.component;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.base.utils.ApiCompatibilityUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyNickNameTextView;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ComponentInfo
  extends LinearLayout
  implements ComponentView
{
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  ReadInJoyNickNameTextView jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView;
  CmpCtxt jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt;
  public ComponentNotIntrest a;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  TextView c;
  
  public ComponentInfo(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public ComponentInfo(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  @TargetApi(11)
  public ComponentInfo(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext);
  }
  
  public ComponentInfo(Context paramContext, Object paramObject)
  {
    super(paramContext);
    a(paramContext, paramObject);
  }
  
  public static ShapeDrawable a(int paramInt, Resources paramResources)
  {
    float f2 = AIOUtils.b(1.0F, paramResources);
    float f1 = 6;
    paramResources = new RectF(f2, f2, f2, f2);
    f2 = 5;
    paramResources = new ShapeDrawable(new RoundRectShape(new float[] { f1, f1, f1, f1, f1, f1, f1, f1 }, paramResources, new float[] { f2, f2, f2, f2, f2, f2, f2, f2 }));
    LinearGradient localLinearGradient = new LinearGradient(50.0F, 50.0F, 50.0F, 50.0F, paramInt, paramInt, Shader.TileMode.REPEAT);
    paramResources.getPaint().setShader(localLinearGradient);
    return paramResources;
  }
  
  private void a(Context paramContext, Object paramObject)
  {
    b(paramContext);
    if ((paramObject instanceof IReadInJoyModel))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a((IReadInJoyModel)paramObject);
      b();
    }
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt = new CmpCtxt();
    a(paramContext);
    a();
  }
  
  private void c()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a();
    if (localAbsBaseArticleInfo == null) {
      return;
    }
    if (!TextUtils.isEmpty(localAbsBaseArticleInfo.mArticleSubscriptText))
    {
      String str;
      if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(localAbsBaseArticleInfo))
      {
        int i = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a();
        if ((i != 1) && (i != 2)) {
          str = "#BBBBBB";
        } else {
          str = "#12B7F5";
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(null, 0);
      }
      else
      {
        if (TextUtils.isEmpty(localAbsBaseArticleInfo.mArticleSubscriptColor)) {
          str = "#00a5e0";
        } else {
          str = localAbsBaseArticleInfo.mArticleSubscriptColor;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(null, 1);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localAbsBaseArticleInfo.mArticleSubscriptText);
      try
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(str));
        ApiCompatibilityUtils.a(this.jdField_a_of_type_AndroidWidgetTextView, a(Color.parseColor(str), getResources()));
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.w("ComponentInfo", 2, "configDefaultItem: ", localException);
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#00a5e0"));
        ApiCompatibilityUtils.a(this.jdField_a_of_type_AndroidWidgetTextView, a(Color.parseColor("#00a5e0"), getResources()));
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void d()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a();
    if ((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(localAbsBaseArticleInfo)) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a() == 1))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setVisibility(8);
      return;
    }
    Object localObject = localAbsBaseArticleInfo.getSubscribeName();
    if (localAbsBaseArticleInfo.mSubscribeName.length() > 18)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(localAbsBaseArticleInfo.mSubscribeName.substring(0, 17));
      ((StringBuilder)localObject).append("…");
      localObject = ((StringBuilder)localObject).toString();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setText((CharSequence)localObject);
    if (RIJFeedsType.g(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a())) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setNickNameByUin(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a());
    }
  }
  
  private void e()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a();
    if ((!this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.m()) && ((!(localObject1 instanceof AdvertisementInfo)) || (TextUtils.isEmpty(((AdvertisementInfo)localObject1).mAdBtnTxt))))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentNotIntrest.jdField_a_of_type_AndroidViewView.setPadding(AIOUtils.b(9.75F, getResources()), AIOUtils.b(8.25F, getResources()), AIOUtils.b(9.75F, getResources()), AIOUtils.b(8.25F, getResources()));
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentNotIntrest.jdField_a_of_type_AndroidViewView.setPadding(AIOUtils.b(9.75F, getResources()), AIOUtils.b(3.75F, getResources()), AIOUtils.b(9.75F, getResources()), AIOUtils.b(8.25F, getResources()));
    localObject1 = (AdvertisementInfo)localObject1;
    int i = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a();
    try
    {
      localObject2 = new JSONObject(((AdvertisementInfo)localObject1).mAdExt);
      boolean bool = TextUtils.isEmpty(((AdvertisementInfo)localObject1).mAdBtnTxt);
      if (!bool) {
        localObject1 = ((AdvertisementInfo)localObject1).mAdBtnTxt;
      } else if (PackageUtil.a(getContext(), ((JSONObject)localObject2).optString("pkg_name"))) {
        localObject1 = getContext().getString(2131717918);
      } else {
        localObject1 = getContext().getString(2131717917);
      }
      n = AIOUtils.b(2.0F, getResources());
      localLayoutParams = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      localLayoutParams.rightMargin = AIOUtils.b(9.5F, getResources());
      localLayoutParams.leftMargin = AIOUtils.b(5.0F, getResources());
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            ApiCompatibilityUtils.a(this.jdField_b_of_type_AndroidWidgetTextView, null);
            this.jdField_a_of_type_AndroidViewView.setVisibility(0);
            this.jdField_b_of_type_AndroidViewView.setVisibility(8);
            localObject2 = null;
            i = 0;
            j = 0;
            k = 0;
            f = 14.0F;
            break label828;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("· ");
          ((StringBuilder)localObject2).append((String)localObject1);
          localObject1 = ((StringBuilder)localObject2).toString();
          f = 12.0F;
          ApiCompatibilityUtils.a(this.jdField_b_of_type_AndroidWidgetTextView, null);
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
          localObject2 = null;
          i = 0;
          j = 0;
          k = 0;
          m = -6447715;
        }
        else
        {
          if (PackageUtil.a(getContext(), ((JSONObject)localObject2).optString("pkg_name"))) {
            localObject2 = getResources().getDrawable(2130842826);
          } else {
            localObject2 = getResources().getDrawable(2130842825);
          }
          i = AIOUtils.b(3.0F, getResources());
          k = AIOUtils.b(1.7F, getResources());
          j = AIOUtils.b(1.8F, getResources());
          localLayoutParams.rightMargin = AIOUtils.b(3.5F, getResources());
          ApiCompatibilityUtils.a(this.jdField_b_of_type_AndroidWidgetTextView, a(-15550475, getResources()));
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          f = 11.0F;
          break label828;
        }
      }
      else
      {
        if (PackageUtil.a(getContext(), ((JSONObject)localObject2).optString("pkg_name"))) {
          localObject2 = getResources().getDrawable(2130842826);
        } else {
          localObject2 = getResources().getDrawable(2130842825);
        }
        i = AIOUtils.b(3.0F, getResources());
        k = AIOUtils.b(1.7F, getResources());
        j = AIOUtils.b(1.8F, getResources());
        TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
        Resources localResources = getResources();
        m = -15550475;
        ApiCompatibilityUtils.a(localTextView, a(-15550475, localResources));
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localLayoutParams.leftMargin = AIOUtils.b(8.0F, getResources());
        f = 11.0F;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject2;
        int n;
        LinearLayout.LayoutParams localLayoutParams;
        int j;
        int k;
        float f;
        continue;
        int m = -15550475;
      }
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
    this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject2, null, null, null);
    this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(n);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(m);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(f);
    this.jdField_b_of_type_AndroidWidgetTextView.setTypeface(null, 0);
    this.jdField_b_of_type_AndroidWidgetTextView.setPadding(i, k, i, j);
    this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  private void f()
  {
    this.c.setVisibility(8);
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131560150, this, true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131378109));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramContext.findViewById(2131371697));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131362816));
    this.c = ((TextView)paramContext.findViewById(2131376438));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentNotIntrest = ((ComponentNotIntrest)paramContext.findViewById(2131371954));
    this.jdField_a_of_type_AndroidViewView = paramContext.findViewById(2131372272);
    this.jdField_b_of_type_AndroidViewView = paramContext.findViewById(2131372273);
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a(paramCellListener);
    ComponentNotIntrest localComponentNotIntrest = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentNotIntrest;
    if (localComponentNotIntrest != null) {
      localComponentNotIntrest.a(paramCellListener);
    }
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof IReadInJoyModel))
    {
      CmpCtxt localCmpCtxt = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt;
      IReadInJoyModel localIReadInJoyModel = (IReadInJoyModel)paramObject;
      localCmpCtxt.a(localIReadInJoyModel);
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.h())
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentNotIntrest.setVisibility(8);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentNotIntrest.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentNotIntrest.a(paramObject);
        paramObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentNotIntrest.getLayoutParams();
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.m()) {
          paramObject.gravity = 0;
        } else {
          paramObject.gravity = 80;
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentNotIntrest.setLayoutParams(paramObject);
      }
      if (localIReadInJoyModel.a() == null)
      {
        QLog.e("ComponentInfo", 1, "bindData getArticleInfo null");
        return;
      }
      c();
      d();
      e();
      f();
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.j())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a())
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        localObject = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentNotIntrest.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).rightMargin = AIOUtils.b(7.0F, getResources());
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentNotIntrest.setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
      }
      localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).bottomMargin = AIOUtils.b(18.0F, getResources());
      ((LinearLayout.LayoutParams)localObject).topMargin = AIOUtils.b(0.0F, getResources());
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).bottomMargin = AIOUtils.b(18.0F, getResources());
      ((LinearLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(11.0F, getResources());
      ((LinearLayout.LayoutParams)localObject).topMargin = AIOUtils.b(0.0F, getResources());
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      localObject = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentNotIntrest.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).rightMargin = AIOUtils.b(2.25F, getResources());
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentNotIntrest.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
    if ((!this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.b()) && (!this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.c()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.d())
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).bottomMargin = AIOUtils.b(0.0F, getResources());
        ((LinearLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(13.0F, getResources());
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a())
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        localObject = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentNotIntrest.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).rightMargin = AIOUtils.b(7.0F, getResources());
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentNotIntrest.setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
      }
      localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).bottomMargin = AIOUtils.b(26.0F, getResources());
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).bottomMargin = AIOUtils.b(26.0F, getResources());
      ((LinearLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(11.0F, getResources());
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentNotIntrest.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).rightMargin = AIOUtils.b(2.25F, getResources());
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentNotIntrest.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    Object localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).bottomMargin = AIOUtils.b(0.0F, getResources());
    ((LinearLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(13.0F, getResources());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentInfo
 * JD-Core Version:    0.7.0.1
 */