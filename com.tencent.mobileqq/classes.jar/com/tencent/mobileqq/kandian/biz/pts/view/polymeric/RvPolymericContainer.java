package com.tencent.mobileqq.kandian.biz.pts.view.polymeric;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.valueitem.SizeValue;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.view.widget.BezierSideBarView;
import com.tencent.mobileqq.kandian.biz.pts.IRvPolymericContainer;
import com.tencent.mobileqq.kandian.biz.pts.view.polymeric.helper.ProteusPagerSnapHelper;
import com.tencent.mobileqq.kandian.biz.pts.view.polymeric.helper.RecycleViewAdapterHelper;
import com.tencent.mobileqq.kandian.biz.pts.view.polymeric.helper.RecycleViewAdapterHelper.OnItemClickListener;
import com.tencent.mobileqq.kandian.biz.pts.view.polymeric.layout.SpaceManager;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RvPolymericContainer
  extends ViewBase
  implements IRvPolymericContainer, RvPolymericOnChangedListener
{
  private int jdField_a_of_type_Int = 0;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private RecyclerView.OnScrollListener jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener = new RvPolymericContainer.1(this);
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private SizeValue jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue;
  private ProteusRecycleView.OnStateChangeListener jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericProteusRecycleView$OnStateChangeListener;
  private ProteusRecycleView jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericProteusRecycleView;
  private ProteusPagerSnapHelper jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericHelperProteusPagerSnapHelper;
  private RecycleViewAdapterHelper jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericHelperRecycleViewAdapterHelper;
  private SpaceManager jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericLayoutSpaceManager;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt = new int[4];
  private int jdField_b_of_type_Int = 3000;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private SizeValue jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 1000;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = Utils.rp2px(16.0D);
  private String jdField_d_of_type_JavaLangString = "#80FFFFFF";
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = Utils.rp2px(3.0D);
  private String jdField_e_of_type_JavaLangString = "#FF07D0B0";
  private boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int = Utils.rp2px(2.5D);
  private boolean jdField_f_of_type_Boolean = true;
  private int g = Utils.rp2px(4.0D);
  private int h = Utils.rp2px(12.0D);
  
  public RvPolymericContainer(VafContext paramVafContext)
  {
    super(paramVafContext);
    a(paramVafContext);
  }
  
  private void a(long paramLong)
  {
    ThreadManager.getUIHandler().post(new RvPolymericContainer.9(this, paramLong));
  }
  
  private void a(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    BaseApplication localBaseApplication = BaseApplication.getContext();
    if (localBaseApplication == null) {
      return;
    }
    localBaseApplication.registerActivityLifecycleCallbacks(new RvPolymericContainer.4(this, paramActivity));
  }
  
  private void a(VafContext paramVafContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericHelperRecycleViewAdapterHelper = new RecycleViewAdapterHelper(paramVafContext);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericProteusRecycleView = new ProteusRecycleView(paramVafContext.getContext());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericProteusRecycleView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericHelperRecycleViewAdapterHelper);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericHelperRecycleViewAdapterHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericProteusRecycleView);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericHelperRecycleViewAdapterHelper.a(new RvPolymericContainer.2(this));
    Object localObject = new LinearLayoutManager(paramVafContext.getContext());
    if (this.jdField_f_of_type_Boolean) {
      ((LinearLayoutManager)localObject).setOrientation(0);
    } else {
      ((LinearLayoutManager)localObject).setOrientation(1);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericProteusRecycleView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericProteusRecycleView.addOnScrollListener(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericProteusRecycleView.addOnChildAttachStateChangeListener(new RvPolymericContainer.3(this));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(paramVafContext.getContext());
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericProteusRecycleView, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramVafContext.getContext());
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(14);
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(0, 0, 0, this.h);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject);
    a(paramVafContext.getCurActivity());
  }
  
  private void a(Runnable paramRunnable)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericProteusRecycleView.isComputingLayout())
    {
      paramRunnable.run();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericProteusRecycleView.postDelayed(new RvPolymericContainer.7(this, paramRunnable), 100L);
  }
  
  private void a(JSONArray paramJSONArray)
  {
    a(new RvPolymericContainer.6(this, paramJSONArray));
  }
  
  private void a(JSONArray paramJSONArray1, JSONArray paramJSONArray2)
  {
    int i = 1;
    while (i < paramJSONArray1.length())
    {
      a(paramJSONArray1, paramJSONArray2, paramJSONArray1.get(i));
      a(paramJSONArray2);
      i += 1;
    }
  }
  
  private void a(JSONArray paramJSONArray1, JSONArray paramJSONArray2, int paramInt)
  {
    if (a(paramJSONArray1, paramJSONArray2, paramInt))
    {
      paramJSONArray2 = (JSONObject)paramJSONArray2.get(paramInt);
      paramJSONArray1 = (JSONObject)paramJSONArray1.get(paramInt);
      Iterator localIterator = paramJSONArray2.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramJSONArray1.put(str, paramJSONArray2.get(str));
      }
    }
  }
  
  private void a(JSONArray paramJSONArray1, JSONArray paramJSONArray2, Object paramObject)
  {
    if ((paramObject instanceof JSONArray))
    {
      paramObject = (JSONArray)paramObject;
      int i = 0;
      while ((i < paramJSONArray1.length()) && (i < paramJSONArray2.length()))
      {
        a(paramJSONArray2, paramObject, i);
        i += 1;
      }
    }
  }
  
  private boolean a(Object paramObject)
  {
    this.jdField_d_of_type_Boolean = "1".equals(paramObject);
    return true;
  }
  
  private boolean a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return true;
  }
  
  private boolean a(JSONArray paramJSONArray)
  {
    for (;;)
    {
      try
      {
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue = new SizeValue();
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue.value = Double.valueOf(paramJSONArray.getString(0)).doubleValue();
        SizeValue localSizeValue = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue;
        if (!"relative".equals(paramJSONArray.getString(0))) {
          break label77;
        }
        i = 1003;
        localSizeValue.valueType = i;
      }
      catch (Exception paramJSONArray)
      {
        QLog.e("RvPolymericContainer", 2, "setEdgeDragCenterY:type: ", paramJSONArray);
      }
      return true;
      label77:
      int i = 1004;
    }
  }
  
  private boolean a(JSONArray paramJSONArray1, JSONArray paramJSONArray2, int paramInt)
  {
    return ((paramJSONArray2.get(paramInt) instanceof JSONObject)) && ((paramJSONArray1.get(paramInt) instanceof JSONObject));
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 0) {
      return;
    }
    int m = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericHelperRecycleViewAdapterHelper.a();
    int k = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    int i = 0;
    if (m <= 1)
    {
      while (i < k)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i).setVisibility(8);
        i += 1;
      }
      return;
    }
    int j;
    if (m > k)
    {
      Context localContext = this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext();
      int n = this.jdField_d_of_type_Int;
      int i1 = this.jdField_e_of_type_Int;
      i = k;
      while (i < m)
      {
        View localView = new View(localContext);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(n, i1);
        if (i == 0) {
          j = 0;
        } else {
          j = this.g;
        }
        localLayoutParams.leftMargin = j;
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = localContext.getResources().getDrawable(2130849717);
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = localContext.getResources().getDrawable(2130849718);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setColorFilter(Color.parseColor(this.jdField_d_of_type_JavaLangString), PorterDuff.Mode.SRC_OVER);
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setColorFilter(Color.parseColor(this.jdField_e_of_type_JavaLangString), PorterDuff.Mode.SRC_OVER);
        Drawable localDrawable;
        if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof GradientDrawable))
        {
          localDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
          if ((localDrawable instanceof GradientDrawable))
          {
            ((GradientDrawable)localDrawable).setCornerRadius(this.jdField_f_of_type_Int);
            ((GradientDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).setCornerRadius(this.jdField_f_of_type_Int);
          }
        }
        if (i == 0) {
          localDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
        } else {
          localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        }
        localView.setBackgroundDrawable(localDrawable);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView, localLayoutParams);
        i += 1;
      }
    }
    i = 0;
    for (;;)
    {
      j = m;
      if (i >= m) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i).setVisibility(0);
      i += 1;
    }
    while (j < k)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j).setVisibility(8);
      j += 1;
    }
  }
  
  private void b(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return;
    }
    String str = paramJSONArray.optString(0, "0");
    paramJSONArray = paramJSONArray.optJSONArray(1);
    this.jdField_c_of_type_Boolean = "1".equals(str);
    if (paramJSONArray != null)
    {
      this.jdField_d_of_type_JavaLangString = paramJSONArray.optString(0, "#80FFFFFF");
      this.jdField_e_of_type_JavaLangString = paramJSONArray.optString(1, "#FF07D0B0");
    }
  }
  
  private boolean b(Object paramObject)
  {
    if (!(paramObject instanceof JSONArray)) {
      return false;
    }
    c((JSONArray)paramObject);
    return true;
  }
  
  private boolean b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return true;
  }
  
  private boolean b(JSONArray paramJSONArray)
  {
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue = new SizeValue();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue.value = Double.valueOf(paramJSONArray.getString(0)).doubleValue();
        SizeValue localSizeValue = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue;
        if (!"relative".equals(paramJSONArray.getString(0))) {
          break label77;
        }
        i = 1003;
        localSizeValue.valueType = i;
      }
      catch (Exception paramJSONArray)
      {
        QLog.e("RvPolymericContainer", 2, "setEdgeDragHeight:type: ", paramJSONArray);
      }
      return true;
      label77:
      int i = 1004;
    }
  }
  
  private void c()
  {
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericHelperProteusPagerSnapHelper != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericHelperRecycleViewAdapterHelper.a() > 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericHelperProteusPagerSnapHelper.a();
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericHelperProteusPagerSnapHelper.a(this.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericHelperProteusPagerSnapHelper.b(this.jdField_c_of_type_Int);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericHelperProteusPagerSnapHelper.b();
    }
  }
  
  private void c(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return;
    }
    String str = paramJSONArray.optString(0, "relative");
    double d1 = paramJSONArray.optDouble(1, 16.0D);
    double d2 = paramJSONArray.optDouble(2, 3.0D);
    double d3 = paramJSONArray.optDouble(3, 2.5D);
    double d4 = paramJSONArray.optDouble(4, 4.0D);
    double d5 = paramJSONArray.optDouble(5, 12.0D);
    if ("relative".equals(str))
    {
      this.jdField_d_of_type_Int = Utils.rp2px(d1);
      this.jdField_e_of_type_Int = Utils.rp2px(d2);
      this.jdField_f_of_type_Int = Utils.rp2px(d3);
      this.g = Utils.rp2px(d4);
      this.h = Utils.rp2px(d5);
      return;
    }
    this.jdField_d_of_type_Int = Utils.dp2px(d1);
    this.jdField_e_of_type_Int = Utils.dp2px(d2);
    this.jdField_f_of_type_Int = Utils.dp2px(d3);
    this.g = Utils.dp2px(d4);
    this.h = Utils.dp2px(d5);
  }
  
  private boolean c(Object paramObject)
  {
    if (!(paramObject instanceof JSONArray)) {
      return false;
    }
    b((JSONArray)paramObject);
    return true;
  }
  
  private boolean c(String paramString)
  {
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_b_of_type_Int = Integer.valueOf(paramString).intValue();
    return true;
  }
  
  private boolean c(JSONArray paramJSONArray)
  {
    return (paramJSONArray.length() == 0) || (!(paramJSONArray.get(0) instanceof JSONArray));
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue;
      if (localObject != null) {
        localLayoutParams = new RelativeLayout.LayoutParams(-1, ((SizeValue)localObject).getLayoutSize());
      }
      localObject = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue;
      if ((localObject != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue != null)) {
        localLayoutParams.topMargin = (((SizeValue)localObject).getLayoutSize() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue.getLayoutSize() / 2);
      }
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericProteusRecycleView.a() == null))
      {
        localObject = new SideBarView(this.mContext.getContext());
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject, localLayoutParams);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericProteusRecycleView.setSideBarView((SideBarView)localObject);
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericProteusRecycleView.a().setPath(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericProteusRecycleView.a().setBgColor(this.jdField_b_of_type_JavaLangString);
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericProteusRecycleView.a();
      float f1;
      if (this.jdField_b_of_type_Boolean) {
        f1 = 1.0F;
      } else {
        f1 = 0.0F;
      }
      ((SideBarView)localObject).setAlpha(f1);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericProteusRecycleView.a().setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericProteusRecycleView.a().setMinimumHeight(0);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericProteusRecycleView.setOnStateChangeListener(new RvPolymericContainer.8(this));
    }
  }
  
  private boolean d(Object paramObject)
  {
    try
    {
      if ((paramObject instanceof JSONArray))
      {
        if (c((JSONArray)paramObject)) {
          return false;
        }
        paramObject = (JSONArray)paramObject;
        a(paramObject, (JSONArray)paramObject.get(0));
        return true;
      }
      return false;
    }
    catch (Exception paramObject)
    {
      QLog.e("RvPolymericContainer", 1, "setCellArray:remoteArray: ", paramObject);
    }
    return true;
  }
  
  private boolean d(String paramString)
  {
    this.jdField_c_of_type_Boolean = "1".equals(paramString);
    return true;
  }
  
  private void e()
  {
    ThreadManager.getUIHandler().post(new RvPolymericContainer.10(this));
  }
  
  private boolean e(Object paramObject)
  {
    try
    {
      boolean bool = paramObject instanceof JSONArray;
      int i = 0;
      if (!bool) {
        return false;
      }
      paramObject = (JSONArray)paramObject;
      if (paramObject.length() < 4) {
        return false;
      }
      while (i < 4)
      {
        Integer localInteger = Utils.toInteger(Integer.valueOf(paramObject.getInt(i)));
        if (localInteger != null) {
          this.jdField_a_of_type_ArrayOfInt[i] = Utils.rp2px(localInteger.intValue());
        }
        i += 1;
      }
      return true;
    }
    catch (JSONException paramObject)
    {
      paramObject.printStackTrace();
    }
  }
  
  private boolean e(String paramString)
  {
    this.jdField_b_of_type_Boolean = "1".equals(paramString);
    return true;
  }
  
  private boolean f(Object paramObject)
  {
    if ((paramObject instanceof JSONArray)) {
      a((JSONArray)paramObject);
    }
    return true;
  }
  
  private boolean f(String paramString)
  {
    this.jdField_a_of_type_Boolean = "1".equals(paramString);
    return true;
  }
  
  private boolean g(Object paramObject)
  {
    if ((paramObject instanceof List)) {
      try
      {
        paramObject = (List)paramObject;
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericHelperRecycleViewAdapterHelper.a(paramObject);
      }
      catch (Exception paramObject)
      {
        paramObject.printStackTrace();
      }
    }
    return true;
  }
  
  private boolean g(String paramString)
  {
    if (String.valueOf(1).equals(paramString))
    {
      this.jdField_a_of_type_Int = 1;
      return true;
    }
    this.jdField_a_of_type_Int = 0;
    return true;
  }
  
  private boolean h(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    return true;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericHelperRecycleViewAdapterHelper == null) {
      return;
    }
    b();
  }
  
  public void a(int paramInt)
  {
    int j = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      Drawable localDrawable;
      if (i == paramInt) {
        localDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      } else {
        localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      }
      localView.setBackgroundDrawable(localDrawable);
      i += 1;
    }
  }
  
  public void a(ProteusRecycleView.OnStateChangeListener paramOnStateChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericProteusRecycleView$OnStateChangeListener = paramOnStateChangeListener;
  }
  
  public void a(RecycleViewAdapterHelper.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericHelperRecycleViewAdapterHelper.a(paramOnItemClickListener);
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericHelperRecycleViewAdapterHelper.a(paramIReadInJoyModel);
    a();
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericHelperRecycleViewAdapterHelper.a(paramObject);
  }
  
  public int getComMeasuredHeight()
  {
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout.getMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.measure(paramInt1, paramInt2);
    SideBarView localSideBarView = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericProteusRecycleView.a();
    if ((localSideBarView != null) && (localSideBarView.getLayoutParams() != null))
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localSideBarView.getLayoutParams();
      paramInt1 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getMeasuredHeight();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sideBarView, onComMeasure, height = ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getMeasuredHeight());
        QLog.i("RvPolymericContainer", 2, ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sideBarView, onComMeasure, width = ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getMeasuredWidth());
        QLog.i("RvPolymericContainer", 2, ((StringBuilder)localObject).toString());
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue == null) && (localLayoutParams.height != paramInt1))
      {
        localLayoutParams.height = paramInt1;
        localSideBarView.setLayoutParams(localLayoutParams);
        localSideBarView.setMinimumHeight(localLayoutParams.height);
      }
      Object localObject = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue;
      if ((localObject != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue == null))
      {
        localLayoutParams.topMargin = (((SizeValue)localObject).getLayoutSize() - paramInt1 / 2);
        localSideBarView.setLayoutParams(localLayoutParams);
      }
    }
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(this.mBackground);
    d();
    if ((this.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericHelperProteusPagerSnapHelper == null))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericHelperProteusPagerSnapHelper = new ProteusPagerSnapHelper();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericHelperProteusPagerSnapHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericProteusRecycleView);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericHelperProteusPagerSnapHelper.a(new RvPolymericContainer.5(this));
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericLayoutSpaceManager;
    int i = 0;
    if (localObject == null)
    {
      boolean bool = this.jdField_f_of_type_Boolean;
      localObject = this.jdField_a_of_type_ArrayOfInt;
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericLayoutSpaceManager = new SpaceManager(bool, localObject[0], localObject[1], localObject[2], localObject[3]);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericProteusRecycleView.addItemDecoration(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericLayoutSpaceManager);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (!this.jdField_c_of_type_Boolean) {
      i = 8;
    }
    ((LinearLayout)localObject).setVisibility(i);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericHelperRecycleViewAdapterHelper.a(this.jdField_d_of_type_Boolean);
    c();
  }
  
  protected boolean setAttribute(int paramInt, Object paramObject)
  {
    if (paramInt != 52)
    {
      if (paramInt != 54)
      {
        if (paramInt != 1053)
        {
          if (paramInt != 1070)
          {
            if (paramInt != 1137)
            {
              if (paramInt != 1129)
              {
                if (paramInt != 1130)
                {
                  if (paramInt != 1140)
                  {
                    if (paramInt != 1141) {
                      return super.setAttribute(paramInt, paramObject);
                    }
                    return a((JSONArray)paramObject);
                  }
                  return b((JSONArray)paramObject);
                }
                return b(paramObject);
              }
              return c(paramObject);
            }
            return a(paramObject);
          }
          return g(paramObject);
        }
        return e(paramObject);
      }
      return d(paramObject);
    }
    return f(paramObject);
  }
  
  protected boolean setAttribute(int paramInt, String paramString)
  {
    if (paramInt != 1136)
    {
      if (paramInt != 1138)
      {
        if (paramInt != 1139)
        {
          switch (paramInt)
          {
          default: 
            return super.setAttribute(paramInt, paramString);
          case 1052: 
            return f(paramString);
          case 1051: 
            return d(paramString);
          case 1050: 
            return g(paramString);
          case 1049: 
            return h(paramString);
          }
          return e(paramString);
        }
        return a(paramString);
      }
      return b(paramString);
    }
    return c(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.polymeric.RvPolymericContainer
 * JD-Core Version:    0.7.0.1
 */