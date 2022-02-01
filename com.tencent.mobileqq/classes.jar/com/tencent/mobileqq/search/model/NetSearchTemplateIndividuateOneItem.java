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
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.List;
import org.json.JSONObject;
import unify.search.UnifySearchCommon.ResultItem;

public class NetSearchTemplateIndividuateOneItem
  extends NetSearchTemplateHorizontalBaseItem
{
  public int b;
  public boolean b;
  public int d;
  public int e;
  public int f;
  public int g;
  public String k;
  public String l;
  public String m;
  public String n;
  public String o;
  public String p;
  public String q;
  public String r;
  
  protected NetSearchTemplateIndividuateOneItem(String paramString, long paramLong, List<String> paramList, int paramInt1, JSONObject paramJSONObject, int paramInt2, UnifySearchCommon.ResultItem paramResultItem)
  {
    super(paramString, paramLong, paramList, paramInt1, paramJSONObject, paramInt2, paramResultItem);
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Long == 1106L)
    {
      MobileReportManager.getInstance().reportAction(String.valueOf(this.e), String.valueOf(this.d), "platform898", "7", "1", 102, 1, System.currentTimeMillis());
      UniteSearchReportController.a(null, 0, this.c, "0X800BAC5", this.e, this.d, null, null);
    }
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
        SignatureEditManager.a((Activity)paramView, VasUtil.a(), 0, "signature_chouti", -1, Integer.parseInt((String)localObject), Integer.parseInt(paramUri), null);
        return;
      }
    }
    catch (Exception paramView)
    {
      paramUri = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("vas_search_schema_error, e = ");
      ((StringBuilder)localObject).append(paramView);
      QLog.e(paramUri, 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void b()
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_Long == 1106L)
    {
      MobileReportManager.getInstance().reportAction(String.valueOf(this.e), String.valueOf(this.d), "platform898", "7", "1", 101, 1, System.currentTimeMillis());
      UniteSearchReportController.a(null, 0, this.c, "0X800BAC4", this.e, this.d, null, null);
    }
  }
  
  private void b(NetSearchTemplateIndividuateOneView paramNetSearchTemplateIndividuateOneView)
  {
    if (TextUtils.isEmpty(this.q))
    {
      paramNetSearchTemplateIndividuateOneView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    paramNetSearchTemplateIndividuateOneView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramNetSearchTemplateIndividuateOneView.jdField_a_of_type_AndroidWidgetTextView.setText(this.q);
    String str;
    StringBuilder localStringBuilder;
    try
    {
      paramNetSearchTemplateIndividuateOneView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(this.p));
    }
    catch (Exception localException1)
    {
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("vas_search_type_shape, e = ");
      localStringBuilder.append(localException1);
      QLog.e(str, 2, localStringBuilder.toString());
    }
    Object localObject = (RelativeLayout.LayoutParams)paramNetSearchTemplateIndividuateOneView.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    int i = this.jdField_b_of_type_Int;
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
    paramNetSearchTemplateIndividuateOneView.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    try
    {
      localObject = new GradientDrawable();
      ((GradientDrawable)localObject).setColor(Color.parseColor(this.o));
      ((GradientDrawable)localObject).setCornerRadius(AIOUtils.b(3.0F, BaseApplicationImpl.getApplication().getResources()));
      paramNetSearchTemplateIndividuateOneView.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable((Drawable)localObject);
    }
    catch (Exception localException2)
    {
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("vas_search_bg_shape, e = ");
      localStringBuilder.append(localException2);
      QLog.e(str, 2, localStringBuilder.toString());
    }
    i = paramNetSearchTemplateIndividuateOneView.a().getLayoutParams().width;
    paramNetSearchTemplateIndividuateOneView.b.setText(SearchUtils.a(paramNetSearchTemplateIndividuateOneView.b, i, 1, this.n, this.jdField_a_of_type_ComTencentMobileqqSearchUtilHighlightModel.a, false, false));
  }
  
  private void c(NetSearchTemplateIndividuateOneView paramNetSearchTemplateIndividuateOneView)
  {
    Object localObject = new ApngOptions();
    ((ApngOptions)localObject).a(new NetSearchTemplateIndividuateOneItem.1(this, paramNetSearchTemplateIndividuateOneView));
    localObject = VipUtils.a(AIOUtils.b(12.0F, BaseApplicationImpl.getContext().getResources()), ((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable(this.m, (ApngOptions)localObject));
    paramNetSearchTemplateIndividuateOneView.b.setCompoundDrawables(null, null, (Drawable)localObject, null);
  }
  
  private void d(NetSearchTemplateIndividuateOneView paramNetSearchTemplateIndividuateOneView)
  {
    paramNetSearchTemplateIndividuateOneView.a().setOnClickListener(this);
  }
  
  @RequiresApi(api=16)
  private void e(NetSearchTemplateIndividuateOneView paramNetSearchTemplateIndividuateOneView)
  {
    if (!TextUtils.isEmpty(this.r)) {
      try
      {
        i = Color.parseColor(this.r);
        GradientDrawable localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setShape(0);
        localGradientDrawable.setColors(new int[] { VasColorUtil.a(0.3F, i), VasColorUtil.a(0.5F, i) });
        localGradientDrawable.setGradientType(0);
        localGradientDrawable.setOrientation(GradientDrawable.Orientation.TR_BL);
        paramNetSearchTemplateIndividuateOneView.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(localGradientDrawable);
      }
      catch (Exception localException)
      {
        String str = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("vas_search_content_color, e = ");
        localStringBuilder.append(localException);
        QLog.e(str, 2, localStringBuilder.toString());
      }
    }
    Object localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setStroke(ViewUtils.a(1.0F), Color.parseColor("#05000000"));
    ((GradientDrawable)localObject).setCornerRadius(ViewUtils.a(6.0F));
    ((GradientDrawable)localObject).setShape(0);
    paramNetSearchTemplateIndividuateOneView.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundDrawable((Drawable)localObject);
    localObject = (RelativeLayout.LayoutParams)paramNetSearchTemplateIndividuateOneView.c.getLayoutParams();
    if (localObject == null) {
      return;
    }
    if (this.g == -1) {
      paramNetSearchTemplateIndividuateOneView.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
    } else {
      paramNetSearchTemplateIndividuateOneView.c.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }
    if (this.f == -1) {
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
    }
    int i = Math.max(ViewUtils.a(this.f / 2.0F), 0);
    int j = Math.max(ViewUtils.a(this.g / 2.0F), 0);
    ((RelativeLayout.LayoutParams)localObject).setMargins(j, i, j, i);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (TextUtils.isEmpty(this.k)) {
      return;
    }
    Uri localUri = Uri.parse(this.k);
    if (localUri == null) {
      return;
    }
    String str = localUri.getScheme();
    if (StringUtil.a(str)) {
      return;
    }
    if ((!str.startsWith("http")) && (!str.startsWith("https")))
    {
      if (str.startsWith("mqzone")) {
        a(paramView, localUri);
      }
    }
    else {
      SearchUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramView.getContext(), this.k);
    }
    a();
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
    b();
  }
  
  public void a(NetSearchTemplateIndividuateOneView paramNetSearchTemplateIndividuateOneView)
  {
    if (Build.VERSION.SDK_INT > 15) {
      e(paramNetSearchTemplateIndividuateOneView);
    }
    Object localObject = new ApngOptions();
    ((ApngOptions)localObject).a(new int[] { 41 });
    ((ApngOptions)localObject).a(new NetSearchTemplateIndividuateOneItem.2(this, paramNetSearchTemplateIndividuateOneView));
    localObject = ((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable(this.l, (ApngOptions)localObject);
    paramNetSearchTemplateIndividuateOneView.c.setImageDrawable((Drawable)localObject);
  }
  
  public void b(JSONObject paramJSONObject)
  {
    this.k = paramJSONObject.optString("actionURL");
    this.l = paramJSONObject.optString("contentPic");
    this.m = paramJSONObject.optString("icon");
    this.n = paramJSONObject.optString("name");
    this.o = paramJSONObject.optString("typeBackgroupColor");
    this.p = paramJSONObject.optString("typeFontColor");
    this.q = paramJSONObject.optString("typeName");
    this.jdField_b_of_type_Int = paramJSONObject.optInt("typePosition");
    this.e = paramJSONObject.optInt("itemID");
    this.d = paramJSONObject.optInt("appID");
    this.r = paramJSONObject.optString("contextBackgroundColor");
    this.f = paramJSONObject.optInt("topMargin", -1);
    this.g = paramJSONObject.optInt("leftMargin", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.NetSearchTemplateIndividuateOneItem
 * JD-Core Version:    0.7.0.1
 */