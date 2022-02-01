package com.tencent.mobileqq.nearby.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RoundRelativeLayout;
import org.json.JSONObject;

public class NearbyActivityDialog
  extends Dialog
  implements View.OnClickListener
{
  protected int a;
  protected Context a;
  protected Drawable a;
  protected Handler a;
  protected Button a;
  protected ImageView a;
  protected AppInterface a;
  protected RoundRelativeLayout a;
  protected String a;
  protected int b;
  protected ImageView b;
  protected RoundRelativeLayout b;
  protected RoundRelativeLayout c;
  
  public NearbyActivityDialog(AppInterface paramAppInterface, Context paramContext)
  {
    super(paramContext, 2131756189);
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    a();
  }
  
  private void a()
  {
    setContentView(2131558970);
    this.jdField_a_of_type_ComTencentWidgetRoundRelativeLayout = ((RoundRelativeLayout)findViewById(2131368630));
    this.jdField_b_of_type_ComTencentWidgetRoundRelativeLayout = ((RoundRelativeLayout)findViewById(2131363900));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363840));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368631));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368624));
    this.c = ((RoundRelativeLayout)findViewById(2131370373));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetRoundRelativeLayout.setRoundLayoutRadius(ScreenUtil.dip2px(3.0F));
    this.jdField_b_of_type_ComTencentWidgetRoundRelativeLayout.setRoundLayoutRadius(ScreenUtil.dip2px(3.0F));
    this.c.setRoundLayoutRadius(ScreenUtil.dip2px(3.0F));
    this.jdField_a_of_type_Int = (ScreenUtil.SCREEN_WIDTH - ScreenUtil.dip2px(28.0F) * 2);
    this.jdField_b_of_type_Int = (this.jdField_a_of_type_Int * 5 / 4);
    Object localObject = this.jdField_a_of_type_ComTencentWidgetRoundRelativeLayout.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = this.jdField_a_of_type_Int;
    ((ViewGroup.LayoutParams)localObject).height = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_ComTencentWidgetRoundRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("init, w=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(", h=");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
      QLog.d("NearbyActivityDialog", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(ImageView paramImageView, String paramString)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#f2f2f2"));
    }
    Object localObject2 = null;
    URLDrawable localURLDrawable2 = null;
    URLDrawable localURLDrawable1 = localURLDrawable2;
    Object localObject1;
    try
    {
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawable1 = localURLDrawable2;
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = this.jdField_b_of_type_Int;
      localURLDrawable1 = localURLDrawable2;
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = this.jdField_a_of_type_Int;
      localURLDrawable1 = localURLDrawable2;
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      localURLDrawable1 = localURLDrawable2;
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      localURLDrawable1 = localURLDrawable2;
      if (!TextUtils.isEmpty(paramString))
      {
        localURLDrawable1 = localURLDrawable2;
        localURLDrawable2 = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject1);
        localURLDrawable1 = localURLDrawable2;
        if (QLog.isColorLevel())
        {
          localURLDrawable1 = localURLDrawable2;
          localObject1 = new StringBuilder();
          localURLDrawable1 = localURLDrawable2;
          ((StringBuilder)localObject1).append("loadImage, status=");
          localURLDrawable1 = localURLDrawable2;
          ((StringBuilder)localObject1).append(localURLDrawable2.getStatus());
          localURLDrawable1 = localURLDrawable2;
          ((StringBuilder)localObject1).append(", url=");
          localURLDrawable1 = localURLDrawable2;
          ((StringBuilder)localObject1).append(paramString);
          localURLDrawable1 = localURLDrawable2;
          QLog.d("NearbyActivityDialog", 2, ((StringBuilder)localObject1).toString());
        }
        localURLDrawable1 = localURLDrawable2;
        localObject1 = localURLDrawable2;
        if (localURLDrawable2.getStatus() != 1)
        {
          localURLDrawable1 = localURLDrawable2;
          this.c.setVisibility(0);
          localURLDrawable1 = localURLDrawable2;
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new NearbyActivityDialog.1(this), 2500L);
          localURLDrawable1 = localURLDrawable2;
          localURLDrawable2.setDownloadListener(new NearbyActivityDialog.2(this));
          localURLDrawable1 = localURLDrawable2;
          localURLDrawable2.restartDownload();
          localObject1 = localURLDrawable2;
        }
      }
      else
      {
        localURLDrawable1 = localURLDrawable2;
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          localURLDrawable1 = localURLDrawable2;
          QLog.w("NearbyActivityDialog", 2, "loadImage empty url");
          localObject1 = localObject2;
        }
      }
    }
    catch (Exception localException)
    {
      localObject1 = localURLDrawable1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("loadImage exp: url=");
        ((StringBuilder)localObject1).append(paramString);
        QLog.w("NearbyActivityDialog", 2, ((StringBuilder)localObject1).toString(), localException);
        localObject1 = localURLDrawable1;
      }
    }
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    }
    paramImageView.setImageDrawable(paramString);
  }
  
  public boolean a(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateContent=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("NearbyActivityDialog", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      paramString = new JSONObject(paramString);
      localObject = paramString.optJSONObject("pic").optString("pic_url");
      a(this.jdField_a_of_type_AndroidWidgetImageView, (String)localObject);
      paramString = paramString.optJSONObject("jump_button");
      localObject = paramString.optString("text");
      int i = paramString.optInt("text_color");
      int j = paramString.optInt("bg_color");
      this.jdField_a_of_type_JavaLangString = paramString.optString("jump_url");
      this.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(i);
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundColor(j);
      return true;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.w("NearbyActivityDialog", 2, "updateContent exception:", paramString);
      }
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1)));
    ((StringBuilder)localObject).append("");
    localObject = ((StringBuilder)localObject).toString();
    int i = paramView.getId();
    if (i == 2131368624)
    {
      dismiss();
      ReportController.b(null, "dc00899", "grp_lbs", "", "home", "pop_clk_close", 0, 0, (String)localObject, "", "", "");
      return;
    }
    if (i == 2131363840)
    {
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("onClick, mJumpUrl=");
        paramView.append(this.jdField_a_of_type_JavaLangString);
        QLog.d("NearbyActivityDialog", 2, paramView.toString());
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        if (this.jdField_a_of_type_JavaLangString.startsWith("http"))
        {
          paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
          paramView.putExtra("url", this.jdField_a_of_type_JavaLangString);
          ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(paramView, this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
        }
        else if (this.jdField_a_of_type_JavaLangString.startsWith("mqqapi"))
        {
          paramView = this.jdField_a_of_type_AndroidContentContext;
          paramView.startActivity(new Intent(paramView, JumpActivity.class).setData(Uri.parse(this.jdField_a_of_type_JavaLangString)));
        }
      }
      dismiss();
      ReportController.b(null, "dc00899", "grp_lbs", "", "home", "pop_clk_btn", 0, 0, (String)localObject, "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.NearbyActivityDialog
 * JD-Core Version:    0.7.0.1
 */