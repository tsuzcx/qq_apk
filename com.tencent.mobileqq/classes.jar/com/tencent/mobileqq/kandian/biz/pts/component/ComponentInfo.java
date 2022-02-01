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
  CmpCtxt a;
  TextView b;
  TextView c;
  ReadInJoyNickNameTextView d;
  TextView e;
  View f;
  View g;
  public ComponentNotIntrest h;
  
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
      this.a.a((IReadInJoyModel)paramObject);
      b();
    }
  }
  
  private void b(Context paramContext)
  {
    this.a = new CmpCtxt();
    a(paramContext);
    a();
  }
  
  private void c()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.a.a.k();
    if (localAbsBaseArticleInfo == null) {
      return;
    }
    if (!TextUtils.isEmpty(localAbsBaseArticleInfo.mArticleSubscriptText))
    {
      String str;
      if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(localAbsBaseArticleInfo))
      {
        int i = this.a.p();
        if ((i != 1) && (i != 2)) {
          str = "#BBBBBB";
        } else {
          str = "#12B7F5";
        }
        this.b.setTypeface(null, 0);
      }
      else
      {
        if (TextUtils.isEmpty(localAbsBaseArticleInfo.mArticleSubscriptColor)) {
          str = "#00a5e0";
        } else {
          str = localAbsBaseArticleInfo.mArticleSubscriptColor;
        }
        this.b.setTypeface(null, 1);
      }
      this.b.setText(localAbsBaseArticleInfo.mArticleSubscriptText);
      try
      {
        this.b.setTextColor(Color.parseColor(str));
        ApiCompatibilityUtils.a(this.b, a(Color.parseColor(str), getResources()));
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.w("ComponentInfo", 2, "configDefaultItem: ", localException);
        }
        this.b.setTextColor(Color.parseColor("#00a5e0"));
        ApiCompatibilityUtils.a(this.b, a(Color.parseColor("#00a5e0"), getResources()));
      }
      this.b.setVisibility(0);
      return;
    }
    this.b.setVisibility(8);
  }
  
  private void d()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.a.a.k();
    if ((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(localAbsBaseArticleInfo)) && (this.a.p() == 1))
    {
      this.d.setVisibility(8);
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
    this.d.setVisibility(0);
    this.d.setText((CharSequence)localObject);
    if (RIJFeedsType.i(this.a.a.k())) {
      this.d.setNickNameByUin(this.a.o());
    }
  }
  
  private void e()
  {
    Object localObject1 = this.a.a.k();
    if ((!this.a.n()) && ((!(localObject1 instanceof AdvertisementInfo)) || (TextUtils.isEmpty(((AdvertisementInfo)localObject1).mAdBtnTxt))))
    {
      this.h.b.setPadding(AIOUtils.b(9.75F, getResources()), AIOUtils.b(8.25F, getResources()), AIOUtils.b(9.75F, getResources()), AIOUtils.b(8.25F, getResources()));
      this.c.setVisibility(8);
      this.f.setVisibility(0);
      this.g.setVisibility(8);
      return;
    }
    this.h.b.setPadding(AIOUtils.b(9.75F, getResources()), AIOUtils.b(3.75F, getResources()), AIOUtils.b(9.75F, getResources()), AIOUtils.b(8.25F, getResources()));
    localObject1 = (AdvertisementInfo)localObject1;
    int i = this.a.p();
    try
    {
      localObject2 = new JSONObject(((AdvertisementInfo)localObject1).mAdExt);
      boolean bool = TextUtils.isEmpty(((AdvertisementInfo)localObject1).mAdBtnTxt);
      if (!bool) {
        localObject1 = ((AdvertisementInfo)localObject1).mAdBtnTxt;
      } else if (PackageUtil.a(getContext(), ((JSONObject)localObject2).optString("pkg_name"))) {
        localObject1 = getContext().getString(2131915392);
      } else {
        localObject1 = getContext().getString(2131915391);
      }
      n = AIOUtils.b(2.0F, getResources());
      localLayoutParams = (LinearLayout.LayoutParams)this.c.getLayoutParams();
      localLayoutParams.rightMargin = AIOUtils.b(9.5F, getResources());
      localLayoutParams.leftMargin = AIOUtils.b(5.0F, getResources());
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            ApiCompatibilityUtils.a(this.c, null);
            this.f.setVisibility(0);
            this.g.setVisibility(8);
            localObject2 = null;
            i = 0;
            j = 0;
            k = 0;
            f1 = 14.0F;
            break label835;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("· ");
          ((StringBuilder)localObject2).append((String)localObject1);
          localObject1 = ((StringBuilder)localObject2).toString();
          f1 = 12.0F;
          ApiCompatibilityUtils.a(this.c, null);
          this.f.setVisibility(8);
          this.g.setVisibility(0);
          localObject2 = null;
          i = 0;
          j = 0;
          k = 0;
          m = -6447715;
        }
        else
        {
          if (PackageUtil.a(getContext(), ((JSONObject)localObject2).optString("pkg_name"))) {
            localObject2 = getResources().getDrawable(2130843782);
          } else {
            localObject2 = getResources().getDrawable(2130843781);
          }
          i = AIOUtils.b(3.0F, getResources());
          k = AIOUtils.b(1.7F, getResources());
          j = AIOUtils.b(1.8F, getResources());
          localLayoutParams.rightMargin = AIOUtils.b(3.5F, getResources());
          ApiCompatibilityUtils.a(this.c, a(-15550475, getResources()));
          this.f.setVisibility(0);
          this.g.setVisibility(8);
          f1 = 11.0F;
          break label835;
        }
      }
      else
      {
        if (PackageUtil.a(getContext(), ((JSONObject)localObject2).optString("pkg_name"))) {
          localObject2 = getResources().getDrawable(2130843782);
        } else {
          localObject2 = getResources().getDrawable(2130843781);
        }
        i = AIOUtils.b(3.0F, getResources());
        k = AIOUtils.b(1.7F, getResources());
        j = AIOUtils.b(1.8F, getResources());
        TextView localTextView = this.c;
        Resources localResources = getResources();
        m = -15550475;
        ApiCompatibilityUtils.a(localTextView, a(-15550475, localResources));
        this.f.setVisibility(8);
        this.g.setVisibility(0);
        localLayoutParams.leftMargin = AIOUtils.b(8.0F, getResources());
        f1 = 11.0F;
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
        float f1;
        continue;
        int m = -15550475;
      }
    }
    this.c.setText((CharSequence)localObject1);
    this.c.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject2, null, null, null);
    this.c.setCompoundDrawablePadding(n);
    this.c.setTextColor(m);
    this.c.setTextSize(f1);
    this.c.setTypeface(null, 0);
    this.c.setPadding(i, k, i, j);
    this.c.setLayoutParams(localLayoutParams);
    this.c.setVisibility(0);
  }
  
  private void f()
  {
    this.e.setVisibility(8);
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131626197, this, true);
    this.b = ((TextView)paramContext.findViewById(2131446615));
    this.d = ((ReadInJoyNickNameTextView)paramContext.findViewById(2131439121));
    this.c = ((TextView)paramContext.findViewById(2131428503));
    this.e = ((TextView)paramContext.findViewById(2131444659));
    this.h = ((ComponentNotIntrest)paramContext.findViewById(2131439399));
    this.f = paramContext.findViewById(2131439778);
    this.g = paramContext.findViewById(2131439779);
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.a.a(paramCellListener);
    ComponentNotIntrest localComponentNotIntrest = this.h;
    if (localComponentNotIntrest != null) {
      localComponentNotIntrest.a(paramCellListener);
    }
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof IReadInJoyModel))
    {
      CmpCtxt localCmpCtxt = this.a;
      IReadInJoyModel localIReadInJoyModel = (IReadInJoyModel)paramObject;
      localCmpCtxt.a(localIReadInJoyModel);
      if (this.a.a.j())
      {
        this.h.setVisibility(8);
      }
      else
      {
        this.h.setVisibility(0);
        this.h.a(paramObject);
        paramObject = (LinearLayout.LayoutParams)this.h.getLayoutParams();
        if (this.a.n()) {
          paramObject.gravity = 0;
        } else {
          paramObject.gravity = 80;
        }
        this.h.setLayoutParams(paramObject);
      }
      if (localIReadInJoyModel.k() == null)
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
    if (this.a.k())
    {
      if (this.a.b())
      {
        this.b.setVisibility(8);
        this.d.setVisibility(8);
        this.c.setVisibility(8);
        localObject = (ViewGroup.MarginLayoutParams)this.h.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).rightMargin = AIOUtils.b(7.0F, getResources());
        this.h.setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
      }
      localObject = (LinearLayout.LayoutParams)this.b.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).bottomMargin = AIOUtils.b(18.0F, getResources());
      ((LinearLayout.LayoutParams)localObject).topMargin = AIOUtils.b(0.0F, getResources());
      this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LinearLayout.LayoutParams)this.d.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).bottomMargin = AIOUtils.b(18.0F, getResources());
      ((LinearLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(11.0F, getResources());
      ((LinearLayout.LayoutParams)localObject).topMargin = AIOUtils.b(0.0F, getResources());
      this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.c.setVisibility(8);
      localObject = (ViewGroup.MarginLayoutParams)this.h.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).rightMargin = AIOUtils.b(2.25F, getResources());
      this.h.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
    if ((!this.a.c()) && (!this.a.d()))
    {
      if (this.a.e())
      {
        this.b.setVisibility(8);
        this.d.setVisibility(0);
        this.c.setVisibility(8);
        localObject = (LinearLayout.LayoutParams)this.d.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).bottomMargin = AIOUtils.b(0.0F, getResources());
        ((LinearLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(13.0F, getResources());
        this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
      }
      if (this.a.b())
      {
        this.b.setVisibility(8);
        this.d.setVisibility(8);
        this.c.setVisibility(8);
        localObject = (ViewGroup.MarginLayoutParams)this.h.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).rightMargin = AIOUtils.b(7.0F, getResources());
        this.h.setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
      }
      localObject = (LinearLayout.LayoutParams)this.b.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).bottomMargin = AIOUtils.b(26.0F, getResources());
      this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LinearLayout.LayoutParams)this.d.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).bottomMargin = AIOUtils.b(26.0F, getResources());
      ((LinearLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(11.0F, getResources());
      this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (ViewGroup.MarginLayoutParams)this.h.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).rightMargin = AIOUtils.b(2.25F, getResources());
      this.h.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
    this.b.setVisibility(8);
    this.d.setVisibility(0);
    this.c.setVisibility(8);
    Object localObject = (LinearLayout.LayoutParams)this.d.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).bottomMargin = AIOUtils.b(0.0F, getResources());
    ((LinearLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(13.0F, getResources());
    this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentInfo
 * JD-Core Version:    0.7.0.1
 */