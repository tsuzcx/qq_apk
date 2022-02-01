package com.tencent.mobileqq.newfriend.ui.builder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class NewFriendFillAcademicInfoBuilder
  extends NewFriendBaseBuilder
  implements View.OnClickListener
{
  public NewFriendFillAcademicInfoBuilder(Context paramContext, AppInterface paramAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
  }
  
  private URLDrawable a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    if (((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable == null) {
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelperConstants.a;
    }
    if (((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable == null) {
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelperConstants.a;
    }
    localObject = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDrawable downLoadUrl ->");
      localStringBuilder.append(paramString);
      QLog.d("NewFriendFillAcademicInfoBuilder", 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  private void a(NewFriendFillAcademicInfoBuilder.NewFriendFillAcademicInfoHolder paramNewFriendFillAcademicInfoHolder)
  {
    if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentCommonAppAppInterface, false, null))
    {
      paramNewFriendFillAcademicInfoHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839301);
      paramNewFriendFillAcademicInfoHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#12B7F5"));
      paramNewFriendFillAcademicInfoHolder.b.setTextColor(Color.parseColor("#7F12B7F5"));
      paramNewFriendFillAcademicInfoHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a("https://qzonestyle.gtimg.cn/aoi/sola/20190920103348_DVTS7XhGQJ.png"));
      return;
    }
    paramNewFriendFillAcademicInfoHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839302);
    paramNewFriendFillAcademicInfoHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.argb(102, 255, 255, 255));
    paramNewFriendFillAcademicInfoHolder.b.setTextColor(Color.argb(102, 255, 255, 255));
    paramNewFriendFillAcademicInfoHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a("https://qzonestyle.gtimg.cn/aoi/sola/20190920103348_9H32GY0LpT.png"));
  }
  
  public View a(int paramInt, View paramView)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof NewFriendFillAcademicInfoBuilder.NewFriendFillAcademicInfoHolder)))
    {
      localObject = (NewFriendFillAcademicInfoBuilder.NewFriendFillAcademicInfoHolder)paramView.getTag();
      return paramView;
    }
    paramView = new NewFriendFillAcademicInfoBuilder.NewFriendFillAcademicInfoHolder();
    Object localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561512, null);
    a((View)localObject, ViewUtils.a(78.0F));
    paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131369294));
    paramView.b = ((TextView)((View)localObject).findViewById(2131379679));
    paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131379930));
    paramView.jdField_a_of_type_AndroidWidgetButton = ((Button)((View)localObject).findViewById(2131363864));
    a(paramView);
    ((View)localObject).setOnClickListener(this);
    paramView.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    ((View)localObject).setTag(paramView);
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "frd_list", "info_add_exp", 1, 0, "", "", "", "");
    return localObject;
  }
  
  public void onClick(View paramView)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "frd_list", "info_add_clk", 1, 0, "", "", "", "");
    Intent localIntent = ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getFriendProfileMoreInfoIntent(paramView.getContext());
    localIntent.addFlags(536870912);
    localIntent.addFlags(67108864);
    ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(localIntent, 231);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.builder.NewFriendFillAcademicInfoBuilder
 * JD-Core Version:    0.7.0.1
 */