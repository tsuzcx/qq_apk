package com.tencent.mobileqq.search.model;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateHorizontalBaseItem;
import com.tencent.mobileqq.search.business.net.view.NetSearchTemplateHorizontalBaseView;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.HighlightModel;
import com.tencent.mobileqq.search.util.SearchReportUtil;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.view.NetSearchTemplateIndividuateOneView;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.signature.SignatureEditManager;
import com.tencent.mobileqq.vas.util.VasColorUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.List;
import org.json.JSONObject;
import unify.search.UnifySearchCommon.ResultItem;

public class NetSearchTemplateIndividuateOneItem
  extends NetSearchTemplateHorizontalBaseItem
{
  public int A;
  public int B;
  public int C;
  public int D;
  public String E;
  public boolean F = false;
  public String f;
  public String t;
  public String u;
  public String v;
  public String w;
  public String x;
  public String y;
  public int z;
  
  protected NetSearchTemplateIndividuateOneItem(String paramString, long paramLong, List<String> paramList, int paramInt1, JSONObject paramJSONObject, int paramInt2, UnifySearchCommon.ResultItem paramResultItem)
  {
    super(paramString, paramLong, paramList, paramInt1, paramJSONObject, paramInt2, paramResultItem);
  }
  
  private void a(View paramView, Uri paramUri)
  {
    paramView = paramView.getContext();
    if (!(paramView instanceof Activity)) {
      return;
    }
    Object localObject = paramUri.getPath();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    try
    {
      if (((String)localObject).equals("/signatureEdit"))
      {
        localObject = paramUri.getQueryParameter("templateId");
        paramUri = paramUri.getQueryParameter("fontId");
        SignatureEditManager.a((Activity)paramView, VasUtil.d(), 0, "signature_chouti", -1, Integer.parseInt((String)localObject), Integer.parseInt(paramUri), null);
        return;
      }
    }
    catch (Exception paramView)
    {
      paramUri = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("vas_search_schema_error, e = ");
      ((StringBuilder)localObject).append(paramView);
      QLog.e(paramUri, 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void b(NetSearchTemplateIndividuateOneView paramNetSearchTemplateIndividuateOneView)
  {
    if (TextUtils.isEmpty(this.y))
    {
      paramNetSearchTemplateIndividuateOneView.d.setVisibility(8);
      return;
    }
    paramNetSearchTemplateIndividuateOneView.d.setVisibility(0);
    paramNetSearchTemplateIndividuateOneView.d.setText(this.y);
    String str;
    StringBuilder localStringBuilder;
    try
    {
      paramNetSearchTemplateIndividuateOneView.d.setTextColor(Color.parseColor(this.x));
    }
    catch (Exception localException1)
    {
      str = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("vas_search_type_shape, e = ");
      localStringBuilder.append(localException1);
      QLog.e(str, 2, localStringBuilder.toString());
    }
    Object localObject = (RelativeLayout.LayoutParams)paramNetSearchTemplateIndividuateOneView.d.getLayoutParams();
    int i = this.z;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3)
          {
            ((RelativeLayout.LayoutParams)localObject).addRule(11);
            ((RelativeLayout.LayoutParams)localObject).addRule(12);
          }
        }
        else
        {
          ((RelativeLayout.LayoutParams)localObject).addRule(11);
          ((RelativeLayout.LayoutParams)localObject).addRule(10);
        }
      }
      else
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(9);
        ((RelativeLayout.LayoutParams)localObject).addRule(10);
      }
    }
    else
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(9);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
    }
    paramNetSearchTemplateIndividuateOneView.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
    try
    {
      localObject = new GradientDrawable();
      ((GradientDrawable)localObject).setColor(Color.parseColor(this.w));
      ((GradientDrawable)localObject).setCornerRadius(AIOUtils.b(3.0F, BaseApplicationImpl.getApplication().getResources()));
      paramNetSearchTemplateIndividuateOneView.d.setBackgroundDrawable((Drawable)localObject);
    }
    catch (Exception localException2)
    {
      str = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("vas_search_bg_shape, e = ");
      localStringBuilder.append(localException2);
      QLog.e(str, 2, localStringBuilder.toString());
    }
    i = paramNetSearchTemplateIndividuateOneView.h().getLayoutParams().width;
    paramNetSearchTemplateIndividuateOneView.o.setText(SearchUtils.a(paramNetSearchTemplateIndividuateOneView.o, i, 1, this.v, this.n.a, false, false));
  }
  
  private void c(NetSearchTemplateIndividuateOneView paramNetSearchTemplateIndividuateOneView)
  {
    Object localObject = new ApngOptions();
    ((ApngOptions)localObject).a(new NetSearchTemplateIndividuateOneItem.1(this, paramNetSearchTemplateIndividuateOneView));
    localObject = VipUtils.a(AIOUtils.b(12.0F, BaseApplicationImpl.getContext().getResources()), ((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable(this.u, (ApngOptions)localObject));
    paramNetSearchTemplateIndividuateOneView.o.setCompoundDrawables(null, null, (Drawable)localObject, null);
  }
  
  private void d(NetSearchTemplateIndividuateOneView paramNetSearchTemplateIndividuateOneView)
  {
    paramNetSearchTemplateIndividuateOneView.h().setOnClickListener(this);
  }
  
  @RequiresApi(api=16)
  private void e(NetSearchTemplateIndividuateOneView paramNetSearchTemplateIndividuateOneView)
  {
    if (!TextUtils.isEmpty(this.E)) {
      try
      {
        i = Color.parseColor(this.E);
        GradientDrawable localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setShape(0);
        localGradientDrawable.setColors(new int[] { VasColorUtil.a(0.3F, i), VasColorUtil.a(0.5F, i) });
        localGradientDrawable.setGradientType(0);
        localGradientDrawable.setOrientation(GradientDrawable.Orientation.TR_BL);
        paramNetSearchTemplateIndividuateOneView.b.setBackgroundDrawable(localGradientDrawable);
      }
      catch (Exception localException)
      {
        String str = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("vas_search_content_color, e = ");
        localStringBuilder.append(localException);
        QLog.e(str, 2, localStringBuilder.toString());
      }
    }
    Object localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setStroke(ViewUtils.dip2px(1.0F), Color.parseColor("#05000000"));
    ((GradientDrawable)localObject).setCornerRadius(ViewUtils.dip2px(6.0F));
    ((GradientDrawable)localObject).setShape(0);
    paramNetSearchTemplateIndividuateOneView.n.setBackgroundDrawable((Drawable)localObject);
    localObject = (RelativeLayout.LayoutParams)paramNetSearchTemplateIndividuateOneView.c.getLayoutParams();
    if (localObject == null) {
      return;
    }
    if (this.D == -1) {
      paramNetSearchTemplateIndividuateOneView.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
    } else {
      paramNetSearchTemplateIndividuateOneView.c.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }
    if (this.C == -1) {
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
    }
    int i = Math.max(ViewUtils.dip2px(this.C / 2.0F), 0);
    int j = Math.max(ViewUtils.dip2px(this.D / 2.0F), 0);
    ((RelativeLayout.LayoutParams)localObject).setMargins(j, i, j, i);
  }
  
  private void r()
  {
    if (this.i == 1106L)
    {
      MobileReportManager.getInstance().reportAction(String.valueOf(this.B), String.valueOf(this.A), "platform898", "7", "1", 102, 1, System.currentTimeMillis());
      UniteSearchReportController.a(null, 0, this.p, "0X800BAC5", this.B, this.A, null, null);
    }
  }
  
  private void s()
  {
    if (this.F) {
      return;
    }
    this.F = true;
    if (this.i == 1106L)
    {
      MobileReportManager.getInstance().reportAction(String.valueOf(this.B), String.valueOf(this.A), "platform898", "7", "1", 101, 1, System.currentTimeMillis());
      UniteSearchReportController.a(null, 0, this.p, "0X800BAC4", this.B, this.A, null, null);
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (TextUtils.isEmpty(this.f)) {
      return;
    }
    Uri localUri = Uri.parse(this.f);
    if (localUri == null) {
      return;
    }
    String str = localUri.getScheme();
    if (StringUtil.isEmpty(str)) {
      return;
    }
    if ((!str.startsWith("http")) && (!str.startsWith("https")))
    {
      if (str.startsWith("mqzone")) {
        a(paramView, localUri);
      }
    }
    else {
      SearchUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramView.getContext(), this.f);
    }
    r();
  }
  
  public void a(NetSearchTemplateHorizontalBaseView paramNetSearchTemplateHorizontalBaseView)
  {
    if (!(paramNetSearchTemplateHorizontalBaseView instanceof NetSearchTemplateIndividuateOneView)) {
      return;
    }
    paramNetSearchTemplateHorizontalBaseView = (NetSearchTemplateIndividuateOneView)paramNetSearchTemplateHorizontalBaseView;
    d(paramNetSearchTemplateHorizontalBaseView);
    a(paramNetSearchTemplateHorizontalBaseView);
    c(paramNetSearchTemplateHorizontalBaseView);
    b(paramNetSearchTemplateHorizontalBaseView);
    s();
  }
  
  public void a(NetSearchTemplateIndividuateOneView paramNetSearchTemplateIndividuateOneView)
  {
    if (Build.VERSION.SDK_INT > 15) {
      e(paramNetSearchTemplateIndividuateOneView);
    }
    Object localObject = new ApngOptions();
    ((ApngOptions)localObject).a(new int[] { 41 });
    ((ApngOptions)localObject).a(new NetSearchTemplateIndividuateOneItem.2(this, paramNetSearchTemplateIndividuateOneView));
    localObject = ((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable(this.t, (ApngOptions)localObject);
    paramNetSearchTemplateIndividuateOneView.c.setImageDrawable((Drawable)localObject);
  }
  
  public void b(JSONObject paramJSONObject)
  {
    this.f = paramJSONObject.optString("actionURL");
    this.t = paramJSONObject.optString("contentPic");
    this.u = paramJSONObject.optString("icon");
    this.v = paramJSONObject.optString("name");
    this.w = paramJSONObject.optString("typeBackgroupColor");
    this.x = paramJSONObject.optString("typeFontColor");
    this.y = paramJSONObject.optString("typeName");
    this.z = paramJSONObject.optInt("typePosition");
    this.B = paramJSONObject.optInt("itemID");
    this.A = paramJSONObject.optInt("appID");
    this.E = paramJSONObject.optString("contextBackgroundColor");
    this.C = paramJSONObject.optInt("topMargin", -1);
    this.D = paramJSONObject.optInt("leftMargin", 0);
  }
  
  public CharSequence d()
  {
    if (this.i == 1106L) {
      return this.v;
    }
    return super.d();
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    SearchReportUtil.a(this);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.NetSearchTemplateIndividuateOneItem
 * JD-Core Version:    0.7.0.1
 */