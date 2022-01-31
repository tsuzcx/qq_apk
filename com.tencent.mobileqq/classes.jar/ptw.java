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
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.ProteusRecycleView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.RvPolymericContainer.10;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.RvPolymericContainer.11;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.RvPolymericContainer.6;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.RvPolymericContainer.7;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.RvPolymericContainer.8;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.SideBarView;
import com.tencent.biz.pubaccount.readinjoy.view.BezierSideBarView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.valueitem.SizeValue;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ptw
  extends ViewBase
{
  private int jdField_a_of_type_Int = 0;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private RecyclerView.OnScrollListener jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener = new ptx(this);
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private ProteusRecycleView jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView;
  private SizeValue jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue;
  private String jdField_a_of_type_JavaLangString = "RvPolymericContainer";
  private ptv jdField_a_of_type_Ptv;
  private puf jdField_a_of_type_Puf;
  private pug jdField_a_of_type_Pug;
  private pus jdField_a_of_type_Pus;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt = new int[4];
  private int jdField_b_of_type_Int = 3000;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private SizeValue jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 1000;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = Utils.rp2px(16.0D);
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = Utils.rp2px(3.0D);
  private String jdField_e_of_type_JavaLangString = "#80FFFFFF";
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = Utils.rp2px(2.5D);
  private String jdField_f_of_type_JavaLangString = "#FF07D0B0";
  private boolean jdField_f_of_type_Boolean = true;
  private int g = Utils.rp2px(4.0D);
  private int h = Utils.rp2px(12.0D);
  
  public ptw(VafContext paramVafContext)
  {
    super(paramVafContext);
    a(paramVafContext);
  }
  
  private void a(long paramLong)
  {
    ThreadManager.getUIHandler().post(new RvPolymericContainer.10(this, paramLong));
  }
  
  private void a(VafContext paramVafContext)
  {
    this.jdField_a_of_type_Pug = new pug(paramVafContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView = new ProteusRecycleView(paramVafContext.getContext());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView.setAdapter(this.jdField_a_of_type_Pug);
    this.jdField_a_of_type_Pug.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView);
    this.jdField_a_of_type_Pug.a(new pty(this));
    Object localObject = new LinearLayoutManager(paramVafContext.getContext());
    if (this.jdField_f_of_type_Boolean) {
      ((LinearLayoutManager)localObject).setOrientation(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView.setLayoutManager((RecyclerView.LayoutManager)localObject);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView.addOnScrollListener(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView.addOnChildAttachStateChangeListener(new ptz(this));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(paramVafContext.getContext());
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView, (ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramVafContext.getContext());
      paramVafContext = new RelativeLayout.LayoutParams(-2, -2);
      paramVafContext.addRule(14);
      paramVafContext.addRule(12);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(0, 0, 0, this.h);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, paramVafContext);
      oxb.a().a(new pub(this));
      return;
      ((LinearLayoutManager)localObject).setOrientation(1);
    }
  }
  
  private void a(Runnable paramRunnable)
  {
    if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView.isComputingLayout())
    {
      paramRunnable.run();
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView.postDelayed(new RvPolymericContainer.8(this, paramRunnable), 100L);
  }
  
  private void a(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {}
    do
    {
      return;
      String str = paramJSONArray.optString(0, "0");
      paramJSONArray = paramJSONArray.optJSONArray(1);
      this.jdField_c_of_type_Boolean = "1".equals(str);
    } while (paramJSONArray == null);
    this.jdField_e_of_type_JavaLangString = paramJSONArray.optString(0, "#80FFFFFF");
    this.jdField_f_of_type_JavaLangString = paramJSONArray.optString(1, "#FF07D0B0");
  }
  
  private void b()
  {
    int i = 0;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 0) {}
    for (;;)
    {
      return;
      int m = this.jdField_a_of_type_Pug.a();
      int k = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      if (m <= 1)
      {
        while (i < k)
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i).setVisibility(8);
          i += 1;
        }
      }
      else
      {
        if (m > k)
        {
          Context localContext = this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext();
          int n = this.jdField_d_of_type_Int;
          int i1 = this.jdField_e_of_type_Int;
          i = k;
          if (i < m)
          {
            View localView = new View(localContext);
            LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(n, i1);
            int j;
            if (i == 0)
            {
              j = 0;
              label126:
              localLayoutParams.leftMargin = j;
              this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = localContext.getResources().getDrawable(2130848851);
              this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = localContext.getResources().getDrawable(2130848852);
              this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setColorFilter(Color.parseColor(this.jdField_e_of_type_JavaLangString), PorterDuff.Mode.SRC_OVER);
              this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setColorFilter(Color.parseColor(this.jdField_f_of_type_JavaLangString), PorterDuff.Mode.SRC_OVER);
              if (((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof GradientDrawable)) && ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable instanceof GradientDrawable)))
              {
                ((GradientDrawable)this.jdField_b_of_type_AndroidGraphicsDrawableDrawable).setCornerRadius(this.jdField_f_of_type_Int);
                ((GradientDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).setCornerRadius(this.jdField_f_of_type_Int);
              }
              if (i != 0) {
                break label289;
              }
            }
            label289:
            for (Drawable localDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;; localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable)
            {
              localView.setBackgroundDrawable(localDrawable);
              this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView, localLayoutParams);
              i += 1;
              break;
              j = this.g;
              break label126;
            }
          }
        }
        i = 0;
        while (i < m)
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i).setVisibility(0);
          i += 1;
        }
        i = m;
        while (i < k)
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i).setVisibility(8);
          i += 1;
        }
      }
    }
  }
  
  private void b(JSONArray paramJSONArray)
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
  
  private void c()
  {
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Puf != null))
    {
      if (this.jdField_a_of_type_Pug.a() > 1)
      {
        this.jdField_a_of_type_Puf.a();
        this.jdField_a_of_type_Puf.a(this.jdField_b_of_type_Int);
        this.jdField_a_of_type_Puf.b(this.jdField_c_of_type_Int);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Puf.b();
  }
  
  private void d()
  {
    RelativeLayout.LayoutParams localLayoutParams;
    SideBarView localSideBarView;
    if (this.jdField_a_of_type_Boolean)
    {
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue != null) {
        localLayoutParams = new RelativeLayout.LayoutParams(-1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue.getLayoutSize());
      }
      if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue != null)) {
        localLayoutParams.topMargin = (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue.getLayoutSize() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue.getLayoutSize() / 2);
      }
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView.a() == null))
      {
        localSideBarView = new SideBarView(this.mContext.getContext());
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localSideBarView, localLayoutParams);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView.setSideBarView(localSideBarView);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView.a().setPath(this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView.a().setBgColor(this.jdField_c_of_type_JavaLangString);
      localSideBarView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView.a();
      if (!this.jdField_b_of_type_Boolean) {
        break label212;
      }
    }
    label212:
    for (float f1 = 1.0F;; f1 = 0.0F)
    {
      localSideBarView.setAlpha(f1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView.a().setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView.a().setMinimumHeight(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView.setOnStateChangeListener(new pud(this));
      return;
    }
  }
  
  private void e()
  {
    ThreadManager.getUIHandler().post(new RvPolymericContainer.11(this));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Pug == null) {
      return;
    }
    b();
  }
  
  public void a(int paramInt)
  {
    int j = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      if (i == paramInt) {}
      for (Drawable localDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;; localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable)
      {
        localView.setBackgroundDrawable(localDrawable);
        i += 1;
        break;
      }
    }
  }
  
  public void a(pgd parampgd)
  {
    this.jdField_a_of_type_Pug.a(parampgd);
    a();
  }
  
  public void a(ptv paramptv)
  {
    this.jdField_a_of_type_Ptv = paramptv;
  }
  
  public void a(puq parampuq)
  {
    this.jdField_a_of_type_Pug.a(parampuq);
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
    SideBarView localSideBarView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView.a();
    if ((localSideBarView != null) && (localSideBarView.getLayoutParams() != null))
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localSideBarView.getLayoutParams();
      paramInt1 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getMeasuredHeight();
      if (QLog.isColorLevel())
      {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "sideBarView, onComMeasure, height = " + this.jdField_a_of_type_AndroidWidgetRelativeLayout.getMeasuredHeight());
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "sideBarView, onComMeasure, width = " + this.jdField_a_of_type_AndroidWidgetRelativeLayout.getMeasuredWidth());
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue == null) && (localLayoutParams.height != paramInt1))
      {
        localLayoutParams.height = paramInt1;
        localSideBarView.setLayoutParams(localLayoutParams);
        localSideBarView.setMinimumHeight(localLayoutParams.height);
      }
      if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue == null))
      {
        localLayoutParams.topMargin = (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue.getLayoutSize() - paramInt1 / 2);
        localSideBarView.setLayoutParams(localLayoutParams);
      }
    }
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(this.mBackground);
    d();
    if ((this.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_Puf == null))
    {
      this.jdField_a_of_type_Puf = new puf();
      this.jdField_a_of_type_Puf.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView);
      this.jdField_a_of_type_Puf.a(new puc(this));
    }
    if (this.jdField_a_of_type_Pus == null)
    {
      this.jdField_a_of_type_Pus = new pus(this.jdField_f_of_type_Boolean, this.jdField_a_of_type_ArrayOfInt[0], this.jdField_a_of_type_ArrayOfInt[1], this.jdField_a_of_type_ArrayOfInt[2], this.jdField_a_of_type_ArrayOfInt[3]);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView.addItemDecoration(this.jdField_a_of_type_Pus);
    }
    LinearLayout localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (this.jdField_c_of_type_Boolean) {}
    for (int i = 0;; i = 8)
    {
      localLinearLayout.setVisibility(i);
      this.jdField_a_of_type_Pug.a(this.jdField_d_of_type_Boolean);
      c();
      return;
    }
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    int i = 1003;
    int j = 0;
    Object localObject1;
    switch (paramInt)
    {
    default: 
      return super.setAttribute(paramInt, paramObject);
    case 1069: 
      if (!(paramObject instanceof List)) {
        break;
      }
    case 52: 
    case 1052: 
      try
      {
        List localList = (List)paramObject;
        this.jdField_a_of_type_Pug.a(localList);
        if ((paramObject instanceof JSONArray)) {
          a(new RvPolymericContainer.6(this, (JSONArray)paramObject));
        }
        return true;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
        try
        {
          if (!(paramObject instanceof JSONArray)) {
            return false;
          }
          paramObject = (JSONArray)paramObject;
          paramInt = j;
          if (paramObject.length() < 4) {
            return false;
          }
          while (paramInt < 4)
          {
            localObject1 = Utils.toInteger(Integer.valueOf(paramObject.getInt(paramInt)));
            if (localObject1 != null) {
              this.jdField_a_of_type_ArrayOfInt[paramInt] = Utils.rp2px(((Integer)localObject1).intValue());
            }
            paramInt += 1;
          }
          return true;
        }
        catch (JSONException paramObject)
        {
          paramObject.printStackTrace();
        }
      }
    case 54: 
      if (!(paramObject instanceof JSONArray)) {
        return false;
      }
      for (;;)
      {
        try
        {
          paramObject = (JSONArray)paramObject;
          if ((paramObject.length() == 0) || (!(paramObject.get(0) instanceof JSONArray))) {
            break;
          }
          localObject1 = (JSONArray)paramObject.get(0);
          paramInt = 1;
          if (paramInt < paramObject.length())
          {
            Object localObject2 = paramObject.get(paramInt);
            if (!(localObject2 instanceof JSONArray)) {
              break label446;
            }
            localObject2 = (JSONArray)localObject2;
            i = 0;
            if ((i >= paramObject.length()) || (i >= ((JSONArray)localObject1).length())) {
              break label446;
            }
            if (((((JSONArray)localObject2).get(i) instanceof JSONObject)) && ((((JSONArray)localObject1).get(i) instanceof JSONObject)))
            {
              JSONObject localJSONObject1 = (JSONObject)((JSONArray)localObject2).get(i);
              JSONObject localJSONObject2 = (JSONObject)((JSONArray)localObject1).get(i);
              Iterator localIterator = localJSONObject1.keys();
              if (localIterator.hasNext())
              {
                String str = (String)localIterator.next();
                localJSONObject2.put(str, localJSONObject1.get(str));
                continue;
              }
            }
          }
          else
          {
            return true;
          }
        }
        catch (Exception paramObject)
        {
          QLog.e(this.jdField_a_of_type_JavaLangString, 2, "setCellArray:remoteArray: ", paramObject);
        }
        i += 1;
        continue;
        a(new RvPolymericContainer.7(this, (JSONArray)localObject1));
        paramInt += 1;
      }
    case 1118: 
      if (!(paramObject instanceof JSONArray)) {
        return false;
      }
      a((JSONArray)paramObject);
      return true;
    case 1119: 
      if (!(paramObject instanceof JSONArray)) {
        return false;
      }
      b((JSONArray)paramObject);
      return true;
    case 1126: 
      this.jdField_d_of_type_Boolean = "1".equals(paramObject);
      return true;
    case 1129: 
      for (;;)
      {
        try
        {
          label446:
          paramObject = (JSONArray)paramObject;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue = new SizeValue();
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue.value = Double.valueOf(paramObject.getString(0)).doubleValue();
          localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue;
          if (!"relative".equals(paramObject.getString(0))) {
            continue;
          }
          ((SizeValue)localObject1).valueType = i;
        }
        catch (Exception paramObject)
        {
          QLog.e(this.jdField_a_of_type_JavaLangString, 2, "setEdgeDragHeight:type: ", paramObject);
          continue;
        }
        return true;
        i = 1004;
      }
    }
    for (;;)
    {
      try
      {
        paramObject = (JSONArray)paramObject;
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue = new SizeValue();
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue.value = Double.valueOf(paramObject.getString(0)).doubleValue();
        localObject1 = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueitemSizeValue;
        if (!"relative".equals(paramObject.getString(0))) {
          continue;
        }
        ((SizeValue)localObject1).valueType = i;
      }
      catch (Exception paramObject)
      {
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, "setEdgeDragCenterY:type: ", paramObject);
        continue;
      }
      return true;
      i = 1004;
    }
    return false;
  }
  
  public boolean setAttribute(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return super.setAttribute(paramInt, paramString);
    case 1048: 
      this.jdField_d_of_type_JavaLangString = paramString;
      return true;
    case 1049: 
      if (String.valueOf(1).equals(paramString))
      {
        this.jdField_a_of_type_Int = 1;
        return true;
      }
      this.jdField_a_of_type_Int = 0;
      return true;
    case 1051: 
      if ("1".equals(paramString))
      {
        this.jdField_a_of_type_Boolean = true;
        return true;
      }
      this.jdField_a_of_type_Boolean = false;
      return true;
    case 1047: 
      if ("1".equals(paramString))
      {
        this.jdField_b_of_type_Boolean = true;
        return true;
      }
      this.jdField_b_of_type_Boolean = false;
      return true;
    case 1050: 
      this.jdField_c_of_type_Boolean = "1".equals(paramString);
      return true;
    case 1125: 
      this.jdField_d_of_type_Boolean = true;
      this.jdField_e_of_type_Boolean = true;
      this.jdField_b_of_type_Int = Integer.valueOf(paramString).intValue();
      return true;
    case 1127: 
      this.jdField_c_of_type_JavaLangString = paramString;
      return true;
    }
    this.jdField_b_of_type_JavaLangString = paramString;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ptw
 * JD-Core Version:    0.7.0.1
 */