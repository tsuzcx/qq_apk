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
  private int A = Utils.rp2px(3.0D);
  private int B = Utils.rp2px(2.5D);
  private int C = Utils.rp2px(4.0D);
  private int D = Utils.rp2px(12.0D);
  private ProteusRecycleView.OnStateChangeListener E;
  private RecyclerView.OnScrollListener F = new RvPolymericContainer.1(this);
  private RelativeLayout a;
  private ProteusRecycleView b;
  private LinearLayout c;
  private RecycleViewAdapterHelper d;
  private boolean e;
  private boolean f;
  private String g;
  private String h;
  private SizeValue i;
  private SizeValue j;
  private boolean k = false;
  private String l;
  private int[] m = new int[4];
  private SpaceManager n;
  private int o = 0;
  private ProteusPagerSnapHelper p;
  private boolean q = false;
  private boolean r = false;
  private int s = 3000;
  private int t = 1000;
  private boolean u = true;
  private Drawable v;
  private Drawable w;
  private String x = "#80FFFFFF";
  private String y = "#FF07D0B0";
  private int z = Utils.rp2px(16.0D);
  
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
    this.d = new RecycleViewAdapterHelper(paramVafContext);
    this.b = new ProteusRecycleView(paramVafContext.getContext());
    this.b.setAdapter(this.d);
    this.d.a(this.b);
    this.d.a(new RvPolymericContainer.2(this));
    Object localObject = new LinearLayoutManager(paramVafContext.getContext());
    if (this.u) {
      ((LinearLayoutManager)localObject).setOrientation(0);
    } else {
      ((LinearLayoutManager)localObject).setOrientation(1);
    }
    this.b.setLayoutManager((RecyclerView.LayoutManager)localObject);
    this.b.addOnScrollListener(this.F);
    this.b.addOnChildAttachStateChangeListener(new RvPolymericContainer.3(this));
    this.a = new RelativeLayout(paramVafContext.getContext());
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.a.addView(this.b, (ViewGroup.LayoutParams)localObject);
    this.c = new LinearLayout(paramVafContext.getContext());
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(14);
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    this.c.setPadding(0, 0, 0, this.D);
    this.a.addView(this.c, (ViewGroup.LayoutParams)localObject);
    a(paramVafContext.getCurActivity());
  }
  
  private void a(Runnable paramRunnable)
  {
    if (!this.b.isComputingLayout())
    {
      paramRunnable.run();
      return;
    }
    this.b.postDelayed(new RvPolymericContainer.7(this, paramRunnable), 100L);
  }
  
  private void a(JSONArray paramJSONArray1, JSONArray paramJSONArray2)
  {
    int i1 = 1;
    while (i1 < paramJSONArray1.length())
    {
      a(paramJSONArray1, paramJSONArray2, paramJSONArray1.get(i1));
      c(paramJSONArray2);
      i1 += 1;
    }
  }
  
  private void a(JSONArray paramJSONArray1, JSONArray paramJSONArray2, int paramInt)
  {
    if (b(paramJSONArray1, paramJSONArray2, paramInt))
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
      int i1 = 0;
      while ((i1 < paramJSONArray1.length()) && (i1 < paramJSONArray2.length()))
      {
        a(paramJSONArray2, paramObject, i1);
        i1 += 1;
      }
    }
  }
  
  private boolean a(String paramString)
  {
    this.g = paramString;
    return true;
  }
  
  private boolean a(JSONArray paramJSONArray)
  {
    for (;;)
    {
      try
      {
        this.j = new SizeValue();
        this.j.value = Double.valueOf(paramJSONArray.getString(0)).doubleValue();
        SizeValue localSizeValue = this.j;
        if (!"relative".equals(paramJSONArray.getString(0))) {
          break label77;
        }
        i1 = 1003;
        localSizeValue.valueType = i1;
      }
      catch (Exception paramJSONArray)
      {
        QLog.e("RvPolymericContainer", 2, "setEdgeDragCenterY:type: ", paramJSONArray);
      }
      return true;
      label77:
      int i1 = 1004;
    }
  }
  
  private void b()
  {
    if (this.c.getVisibility() != 0) {
      return;
    }
    int i4 = this.d.a();
    int i3 = this.c.getChildCount();
    int i1 = 0;
    if (i4 <= 1)
    {
      while (i1 < i3)
      {
        this.c.getChildAt(i1).setVisibility(8);
        i1 += 1;
      }
      return;
    }
    int i2;
    if (i4 > i3)
    {
      Context localContext = this.c.getContext();
      int i5 = this.z;
      int i6 = this.A;
      i1 = i3;
      while (i1 < i4)
      {
        View localView = new View(localContext);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i5, i6);
        if (i1 == 0) {
          i2 = 0;
        } else {
          i2 = this.C;
        }
        localLayoutParams.leftMargin = i2;
        this.v = localContext.getResources().getDrawable(2130851426);
        this.w = localContext.getResources().getDrawable(2130851427);
        this.v.setColorFilter(Color.parseColor(this.x), PorterDuff.Mode.SRC_OVER);
        this.w.setColorFilter(Color.parseColor(this.y), PorterDuff.Mode.SRC_OVER);
        Drawable localDrawable;
        if ((this.v instanceof GradientDrawable))
        {
          localDrawable = this.w;
          if ((localDrawable instanceof GradientDrawable))
          {
            ((GradientDrawable)localDrawable).setCornerRadius(this.B);
            ((GradientDrawable)this.v).setCornerRadius(this.B);
          }
        }
        if (i1 == 0) {
          localDrawable = this.w;
        } else {
          localDrawable = this.v;
        }
        localView.setBackgroundDrawable(localDrawable);
        this.c.addView(localView, localLayoutParams);
        i1 += 1;
      }
    }
    i1 = 0;
    for (;;)
    {
      i2 = i4;
      if (i1 >= i4) {
        break;
      }
      this.c.getChildAt(i1).setVisibility(0);
      i1 += 1;
    }
    while (i2 < i3)
    {
      this.c.getChildAt(i2).setVisibility(8);
      i2 += 1;
    }
  }
  
  private boolean b(Object paramObject)
  {
    this.q = "1".equals(paramObject);
    return true;
  }
  
  private boolean b(String paramString)
  {
    this.h = paramString;
    return true;
  }
  
  private boolean b(JSONArray paramJSONArray)
  {
    for (;;)
    {
      try
      {
        this.i = new SizeValue();
        this.i.value = Double.valueOf(paramJSONArray.getString(0)).doubleValue();
        SizeValue localSizeValue = this.i;
        if (!"relative".equals(paramJSONArray.getString(0))) {
          break label77;
        }
        i1 = 1003;
        localSizeValue.valueType = i1;
      }
      catch (Exception paramJSONArray)
      {
        QLog.e("RvPolymericContainer", 2, "setEdgeDragHeight:type: ", paramJSONArray);
      }
      return true;
      label77:
      int i1 = 1004;
    }
  }
  
  private boolean b(JSONArray paramJSONArray1, JSONArray paramJSONArray2, int paramInt)
  {
    return ((paramJSONArray2.get(paramInt) instanceof JSONObject)) && ((paramJSONArray1.get(paramInt) instanceof JSONObject));
  }
  
  private void c()
  {
    if ((this.r) && (this.p != null))
    {
      if (this.d.a() > 1)
      {
        this.p.a();
        this.p.a(this.s);
        this.p.b(this.t);
        return;
      }
      this.p.b();
    }
  }
  
  private void c(JSONArray paramJSONArray)
  {
    a(new RvPolymericContainer.6(this, paramJSONArray));
  }
  
  private boolean c(Object paramObject)
  {
    if (!(paramObject instanceof JSONArray)) {
      return false;
    }
    f((JSONArray)paramObject);
    return true;
  }
  
  private boolean c(String paramString)
  {
    this.q = true;
    this.r = true;
    this.s = Integer.valueOf(paramString).intValue();
    return true;
  }
  
  private void d()
  {
    if (this.e)
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      Object localObject = this.i;
      if (localObject != null) {
        localLayoutParams = new RelativeLayout.LayoutParams(-1, ((SizeValue)localObject).getLayoutSize());
      }
      localObject = this.j;
      if ((localObject != null) && (this.i != null)) {
        localLayoutParams.topMargin = (((SizeValue)localObject).getLayoutSize() - this.i.getLayoutSize() / 2);
      }
      if ((this.e) && (this.b.getSideBarView() == null))
      {
        localObject = new SideBarView(this.mContext.getContext());
        this.a.addView((View)localObject, localLayoutParams);
        this.b.setSideBarView((SideBarView)localObject);
      }
      this.b.getSideBarView().setPath(this.g);
      this.b.getSideBarView().setBgColor(this.h);
      localObject = this.b.getSideBarView();
      float f1;
      if (this.f) {
        f1 = 1.0F;
      } else {
        f1 = 0.0F;
      }
      ((SideBarView)localObject).setAlpha(f1);
      this.b.getSideBarView().setLayoutParams(localLayoutParams);
      this.b.getSideBarView().setMinimumHeight(0);
      this.b.setOnStateChangeListener(new RvPolymericContainer.8(this));
    }
  }
  
  private boolean d(Object paramObject)
  {
    if (!(paramObject instanceof JSONArray)) {
      return false;
    }
    e((JSONArray)paramObject);
    return true;
  }
  
  private boolean d(String paramString)
  {
    this.k = "1".equals(paramString);
    return true;
  }
  
  private boolean d(JSONArray paramJSONArray)
  {
    return (paramJSONArray.length() == 0) || (!(paramJSONArray.get(0) instanceof JSONArray));
  }
  
  private void e()
  {
    ThreadManager.getUIHandler().post(new RvPolymericContainer.10(this));
  }
  
  private void e(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return;
    }
    String str = paramJSONArray.optString(0, "0");
    paramJSONArray = paramJSONArray.optJSONArray(1);
    this.k = "1".equals(str);
    if (paramJSONArray != null)
    {
      this.x = paramJSONArray.optString(0, "#80FFFFFF");
      this.y = paramJSONArray.optString(1, "#FF07D0B0");
    }
  }
  
  private boolean e(Object paramObject)
  {
    try
    {
      if ((paramObject instanceof JSONArray))
      {
        if (d((JSONArray)paramObject)) {
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
  
  private boolean e(String paramString)
  {
    this.f = "1".equals(paramString);
    return true;
  }
  
  private void f(JSONArray paramJSONArray)
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
      this.z = Utils.rp2px(d1);
      this.A = Utils.rp2px(d2);
      this.B = Utils.rp2px(d3);
      this.C = Utils.rp2px(d4);
      this.D = Utils.rp2px(d5);
      return;
    }
    this.z = Utils.dp2px(d1);
    this.A = Utils.dp2px(d2);
    this.B = Utils.dp2px(d3);
    this.C = Utils.dp2px(d4);
    this.D = Utils.dp2px(d5);
  }
  
  private boolean f(Object paramObject)
  {
    try
    {
      boolean bool = paramObject instanceof JSONArray;
      int i1 = 0;
      if (!bool) {
        return false;
      }
      paramObject = (JSONArray)paramObject;
      if (paramObject.length() < 4) {
        return false;
      }
      while (i1 < 4)
      {
        Integer localInteger = Utils.toInteger(Integer.valueOf(paramObject.getInt(i1)));
        if (localInteger != null) {
          this.m[i1] = Utils.rp2px(localInteger.intValue());
        }
        i1 += 1;
      }
      return true;
    }
    catch (JSONException paramObject)
    {
      paramObject.printStackTrace();
    }
  }
  
  private boolean f(String paramString)
  {
    this.e = "1".equals(paramString);
    return true;
  }
  
  private boolean g(Object paramObject)
  {
    if ((paramObject instanceof JSONArray)) {
      c((JSONArray)paramObject);
    }
    return true;
  }
  
  private boolean g(String paramString)
  {
    if (String.valueOf(1).equals(paramString))
    {
      this.o = 1;
      return true;
    }
    this.o = 0;
    return true;
  }
  
  private boolean h(Object paramObject)
  {
    if ((paramObject instanceof List)) {
      try
      {
        paramObject = (List)paramObject;
        this.d.a(paramObject);
      }
      catch (Exception paramObject)
      {
        paramObject.printStackTrace();
      }
    }
    return true;
  }
  
  private boolean h(String paramString)
  {
    this.l = paramString;
    return true;
  }
  
  public void a()
  {
    if (this.d == null) {
      return;
    }
    b();
  }
  
  public void a(int paramInt)
  {
    int i2 = this.c.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = this.c.getChildAt(i1);
      Drawable localDrawable;
      if (i1 == paramInt) {
        localDrawable = this.w;
      } else {
        localDrawable = this.v;
      }
      localView.setBackgroundDrawable(localDrawable);
      i1 += 1;
    }
  }
  
  public void a(ProteusRecycleView.OnStateChangeListener paramOnStateChangeListener)
  {
    this.E = paramOnStateChangeListener;
  }
  
  public void a(RecycleViewAdapterHelper.OnItemClickListener paramOnItemClickListener)
  {
    this.d.a(paramOnItemClickListener);
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel)
  {
    this.d.a(paramIReadInJoyModel);
    a();
  }
  
  public void a(Object paramObject)
  {
    this.d.a(paramObject);
  }
  
  public int getComMeasuredHeight()
  {
    return this.a.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.a.getMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.a;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.a.measure(paramInt1, paramInt2);
    SideBarView localSideBarView = this.b.getSideBarView();
    if ((localSideBarView != null) && (localSideBarView.getLayoutParams() != null))
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localSideBarView.getLayoutParams();
      paramInt1 = this.a.getMeasuredHeight();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sideBarView, onComMeasure, height = ");
        ((StringBuilder)localObject).append(this.a.getMeasuredHeight());
        QLog.i("RvPolymericContainer", 2, ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sideBarView, onComMeasure, width = ");
        ((StringBuilder)localObject).append(this.a.getMeasuredWidth());
        QLog.i("RvPolymericContainer", 2, ((StringBuilder)localObject).toString());
      }
      if ((this.i == null) && (localLayoutParams.height != paramInt1))
      {
        localLayoutParams.height = paramInt1;
        localSideBarView.setLayoutParams(localLayoutParams);
        localSideBarView.setMinimumHeight(localLayoutParams.height);
      }
      Object localObject = this.j;
      if ((localObject != null) && (this.i == null))
      {
        localLayoutParams.topMargin = (((SizeValue)localObject).getLayoutSize() - paramInt1 / 2);
        localSideBarView.setLayoutParams(localLayoutParams);
      }
    }
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.a.setBackgroundColor(this.mBackground);
    d();
    if ((this.o == 1) && (this.p == null))
    {
      this.p = new ProteusPagerSnapHelper();
      this.p.a(this.b);
      this.p.a(new RvPolymericContainer.5(this));
    }
    Object localObject = this.n;
    int i1 = 0;
    if (localObject == null)
    {
      boolean bool = this.u;
      localObject = this.m;
      this.n = new SpaceManager(bool, localObject[0], localObject[1], localObject[2], localObject[3]);
      this.b.addItemDecoration(this.n);
    }
    localObject = this.c;
    if (!this.k) {
      i1 = 8;
    }
    ((LinearLayout)localObject).setVisibility(i1);
    this.d.a(this.q);
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
                return c(paramObject);
              }
              return d(paramObject);
            }
            return b(paramObject);
          }
          return h(paramObject);
        }
        return f(paramObject);
      }
      return e(paramObject);
    }
    return g(paramObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.polymeric.RvPolymericContainer
 * JD-Core Version:    0.7.0.1
 */