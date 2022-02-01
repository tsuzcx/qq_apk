package com.tencent.mobileqq.nearby.profilecard.moment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.QQNearbyManager;
import com.tencent.mobileqq.nearby.now.utils.INowVideoReporter;
import com.tencent.mobileqq.nearby.profilecard.moment.data.MomentFeedInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.PicMomentFeedInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseMomentItemBuilder
  implements View.OnClickListener, CommentsAdapter.CommentsItemClickListener
{
  protected int a;
  protected Context a;
  protected QQAppInterface a;
  protected NearbyPeopleCard a;
  protected Map<String, MomentFeedInfo> a;
  protected boolean a;
  protected Map<String, MomentFeedInfo> b = new HashMap();
  protected Map<String, MomentFeedInfo> c = new HashMap();
  
  public BaseMomentItemBuilder(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void g(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    MomentFeedInfo localMomentFeedInfo = paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo;
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(HardCodeUtil.a(2131701250)).setNegativeButton(2131690728, new BaseMomentItemBuilder.5(this)).setPositiveButton(2131691479, new BaseMomentItemBuilder.4(this, localMomentFeedInfo, paramMomentViewHolder)).show();
  }
  
  private void h(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, HardCodeUtil.a(2131701247), 0).a();
      return;
    }
    boolean bool = paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.jdField_a_of_type_Boolean;
    Object localObject2 = b(paramMomentViewHolder);
    Object localObject1 = (NearbyMomentManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_MOMENT_MANAGER);
    if (!bool) {
      ((NearbyMomentManager)localObject1).d((String)localObject2);
    } else {
      ((NearbyMomentManager)localObject1).e((String)localObject2);
    }
    INowVideoReporter localINowVideoReporter = ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).opType("data_card");
    if (bool) {
      localObject1 = "feed_unlike";
    } else {
      localObject1 = "feed_like";
    }
    localINowVideoReporter = localINowVideoReporter.opName((String)localObject1);
    localObject1 = "2";
    localObject2 = localINowVideoReporter.source("2").timelong(a(paramMomentViewHolder)).feedid((String)localObject2).feed_type(String.valueOf(a(paramMomentViewHolder)));
    paramMomentViewHolder = (BaseMomentItemBuilder.MomentViewHolder)localObject1;
    if (this.jdField_a_of_type_Boolean) {
      paramMomentViewHolder = "1";
    }
    ((INowVideoReporter)localObject2).d1(paramMomentViewHolder).report(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public abstract int a(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder);
  
  public abstract View a(ViewGroup paramViewGroup, BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder);
  
  public View a(MomentFeedInfo paramMomentFeedInfo, Context paramContext, View paramView)
  {
    Object localObject = (LinearLayout)paramView;
    paramView = (View)localObject;
    if (localObject == null)
    {
      localObject = new LinearLayout(paramContext);
      ((LinearLayout)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      ((LinearLayout)localObject).setBackgroundColor(-1);
      ((LinearLayout)localObject).setOrientation(1);
      BaseMomentItemBuilder.MomentViewHolder localMomentViewHolder = a();
      if (localMomentViewHolder == null) {
        return null;
      }
      localMomentViewHolder.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
      localMomentViewHolder.jdField_a_of_type_AndroidViewView = ((View)localObject);
      paramView = LayoutInflater.from(paramContext).inflate(2131561226, (ViewGroup)localObject, false);
      LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams1.topMargin = UIUtils.a(paramContext, 20.0F);
      localLayoutParams1.leftMargin = UIUtils.a(paramContext, 16.0F);
      localLayoutParams1.bottomMargin = UIUtils.a(paramContext, 0.0F);
      localLayoutParams1.rightMargin = UIUtils.a(paramContext, 6.0F);
      localMomentViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369372));
      localMomentViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379778));
      localMomentViewHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369420));
      View localView1 = LayoutInflater.from(paramContext).inflate(2131561222, (ViewGroup)localObject, false);
      LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams2.leftMargin = UIUtils.a(paramContext, 66.0F);
      localLayoutParams2.rightMargin = UIUtils.a(paramContext, 6.0F);
      localMomentViewHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView1.findViewById(2131379763));
      localMomentViewHolder.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView1.findViewById(2131379669));
      localMomentViewHolder.jdField_c_of_type_AndroidViewView = localView1.findViewById(2131373009);
      localMomentViewHolder.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView1.findViewById(2131369444));
      localMomentViewHolder.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      localMomentViewHolder.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView1.findViewById(2131379817));
      localMomentViewHolder.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)localView1.findViewById(2131369325));
      localMomentViewHolder.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
      localMomentViewHolder.e = ((TextView)localView1.findViewById(2131379580));
      localMomentViewHolder.jdField_a_of_type_AndroidWidgetListView = ((ListView)localView1.findViewById(2131364995));
      localMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentCommentsAdapter = new CommentsAdapter();
      localMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentCommentsAdapter.a(this);
      localMomentViewHolder.jdField_a_of_type_AndroidWidgetListView.setAdapter(localMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentCommentsAdapter);
      localMomentViewHolder.f = ((TextView)localView1.findViewById(2131381021));
      localMomentViewHolder.jdField_d_of_type_AndroidViewView = localView1.findViewById(2131364993);
      localMomentViewHolder.f.setOnClickListener(this);
      ((LinearLayout)localObject).addView(paramView, localLayoutParams1);
      View localView2 = a((ViewGroup)localObject, localMomentViewHolder);
      if (localView2 != null)
      {
        localLayoutParams1 = (LinearLayout.LayoutParams)localView2.getLayoutParams();
        paramView = localLayoutParams1;
        if (localLayoutParams1 == null) {
          paramView = new LinearLayout.LayoutParams(-1, -2);
        }
        paramView.leftMargin = UIUtils.a(paramContext, 66.0F);
        paramView.rightMargin = UIUtils.a(paramContext, 6.0F);
        paramView.topMargin = UIUtils.a(paramContext, -14.0F);
        ((LinearLayout)localObject).addView(localView2);
        localView2.setId(2131374283);
        localMomentViewHolder.jdField_b_of_type_AndroidViewView = localView2;
        localView2.setOnClickListener(this);
      }
      ((LinearLayout)localObject).addView(localView1, localLayoutParams2);
      ((LinearLayout)localObject).setTag(localMomentViewHolder);
      localMomentViewHolder.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      paramView = new View(this.jdField_a_of_type_AndroidContentContext);
      paramView.setLayoutParams(new LinearLayout.LayoutParams(-1, UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F)));
      paramView.setBackgroundColor(-460807);
      ((LinearLayout)localObject).addView(paramView);
      paramView = (View)localObject;
    }
    localObject = (BaseMomentItemBuilder.MomentViewHolder)paramView.getTag();
    ((BaseMomentItemBuilder.MomentViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo = paramMomentFeedInfo;
    a((BaseMomentItemBuilder.MomentViewHolder)localObject);
    if ((!TextUtils.isEmpty(paramMomentFeedInfo.k)) && (!paramMomentFeedInfo.k.endsWith(HardCodeUtil.a(2131701251))))
    {
      ((BaseMomentItemBuilder.MomentViewHolder)localObject).jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130845694, 0, 0, 0);
      ((BaseMomentItemBuilder.MomentViewHolder)localObject).jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#576B95"));
      ((BaseMomentItemBuilder.MomentViewHolder)localObject).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new BaseMomentItemBuilder.1(this, paramContext, paramMomentFeedInfo, (BaseMomentItemBuilder.MomentViewHolder)localObject));
    }
    else
    {
      ((BaseMomentItemBuilder.MomentViewHolder)localObject).jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130845692, 0, 0, 0);
      ((BaseMomentItemBuilder.MomentViewHolder)localObject).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(null);
      ((BaseMomentItemBuilder.MomentViewHolder)localObject).jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
    }
    if (this.jdField_a_of_type_JavaUtilMap.get(((BaseMomentItemBuilder.MomentViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.c) == null)
    {
      paramContext = ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).opType("data_card").opName("feed_exp").timelong(a((BaseMomentItemBuilder.MomentViewHolder)localObject));
      paramMomentFeedInfo = "2";
      paramContext = paramContext.source("2").feedid(((BaseMomentItemBuilder.MomentViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.c).feed_type(String.valueOf(a((BaseMomentItemBuilder.MomentViewHolder)localObject)));
      if (this.jdField_a_of_type_Boolean) {
        paramMomentFeedInfo = "1";
      }
      paramContext.d1(paramMomentFeedInfo).report(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_JavaUtilMap.put(((BaseMomentItemBuilder.MomentViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.c, ((BaseMomentItemBuilder.MomentViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo);
    }
    return paramView;
  }
  
  public abstract BaseMomentItemBuilder.MomentViewHolder a();
  
  public String a(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    return "";
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(View paramView)
  {
    paramView = (BaseMomentItemBuilder.MomentViewHolder)NearbyMomentUtils.a(paramView, BaseMomentItemBuilder.MomentViewHolder.class);
    if (paramView == null) {
      return;
    }
    c(paramView);
  }
  
  public void a(NearbyPeopleCard paramNearbyPeopleCard)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard = paramNearbyPeopleCard;
    this.jdField_a_of_type_Boolean = paramNearbyPeopleCard.isHostSelf;
  }
  
  public void a(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 40.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 40.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840323);
    try
    {
      localObject = URLDrawable.getDrawable(paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.d, (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setTag(URLDrawableDecodeHandler.a(UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 40.0F), UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 40.0F)));
      ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.a);
      paramMomentViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    }
    catch (Exception localException)
    {
      label106:
      List localList;
      INowVideoReporter localINowVideoReporter;
      break label106;
    }
    paramMomentViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840323));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateUI, holder.momentFeedInfo.headUrl=");
    ((StringBuilder)localObject).append(paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.d);
    QLog.i("BaseMomentItemBuilder", 1, ((StringBuilder)localObject).toString());
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) {
      paramMomentViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname);
    }
    paramMomentViewHolder.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    f(paramMomentViewHolder);
    if (!TextUtils.isEmpty(paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.jdField_g_of_type_JavaLangString))
    {
      paramMomentViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramMomentViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.jdField_g_of_type_JavaLangString);
    }
    else
    {
      paramMomentViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    localObject = new StringBuilder();
    if (!TextUtils.isEmpty(paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.jdField_f_of_type_JavaLangString))
    {
      if (((StringBuilder)localObject).length() > 0) {
        ((StringBuilder)localObject).append(" · ");
      }
      ((StringBuilder)localObject).append(paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.jdField_f_of_type_JavaLangString);
    }
    if (((StringBuilder)localObject).length() > 0)
    {
      paramMomentViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject).toString());
      paramMomentViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    else
    {
      paramMomentViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (a(paramMomentViewHolder))
    {
      paramMomentViewHolder.jdField_c_of_type_AndroidViewView.setVisibility(0);
      if (paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.jdField_a_of_type_Boolean)
      {
        paramMomentViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845635);
        paramMomentViewHolder.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-52924);
      }
      else
      {
        paramMomentViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845653);
        paramMomentViewHolder.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-4473925);
      }
      paramMomentViewHolder.jdField_d_of_type_AndroidWidgetTextView.setText(String.valueOf(paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.jdField_f_of_type_Int));
      paramMomentViewHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      paramMomentViewHolder.e.setText(String.valueOf(paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.jdField_g_of_type_Int));
    }
    else
    {
      paramMomentViewHolder.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    localList = paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (localList.size() > 0))
    {
      paramMomentViewHolder.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
      paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentCommentsAdapter.a(localList);
      paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentCommentsAdapter.notifyDataSetChanged();
      if (this.b.get(paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.c) == null)
      {
        localINowVideoReporter = ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).opType("data_card").opName("feed_com_exp");
        localObject = "2";
        localINowVideoReporter = localINowVideoReporter.source("2").timelong(a(paramMomentViewHolder)).feedid(paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.c).feed_type(String.valueOf(a(paramMomentViewHolder)));
        if (this.jdField_a_of_type_Boolean) {
          localObject = "1";
        }
        localINowVideoReporter.d1((String)localObject).report(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.b.put(paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.c, paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo);
      }
    }
    else
    {
      paramMomentViewHolder.jdField_a_of_type_AndroidWidgetListView.setVisibility(8);
    }
    if ((localList != null) && (localList.size() > 0) && (paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.jdField_g_of_type_Int > localList.size())) {
      paramMomentViewHolder.f.setVisibility(0);
    } else {
      paramMomentViewHolder.f.setVisibility(8);
    }
    if ((paramMomentViewHolder.jdField_a_of_type_AndroidWidgetListView.getVisibility() != 0) && (paramMomentViewHolder.f.getVisibility() != 0)) {
      paramMomentViewHolder.jdField_d_of_type_AndroidViewView.setVisibility(8);
    } else {
      paramMomentViewHolder.jdField_d_of_type_AndroidViewView.setVisibility(0);
    }
    paramMomentViewHolder.jdField_b_of_type_AndroidWidgetImageView.setClickable(true);
    paramMomentViewHolder.jdField_b_of_type_AndroidWidgetImageView.setAlpha(1.0F);
    paramMomentViewHolder.jdField_c_of_type_AndroidWidgetImageView.setClickable(true);
    paramMomentViewHolder.jdField_d_of_type_AndroidWidgetImageView.setClickable(true);
    paramMomentViewHolder.jdField_c_of_type_AndroidWidgetImageView.setAlpha(1.0F);
    paramMomentViewHolder.jdField_d_of_type_AndroidWidgetTextView.setAlpha(1.0F);
    paramMomentViewHolder.jdField_d_of_type_AndroidWidgetImageView.setAlpha(1.0F);
    paramMomentViewHolder.e.setAlpha(1.0F);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    try
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("raw_url", paramString);
      ((Intent)localObject).putExtra("scroll_to_comment", paramBoolean);
      ((Intent)localObject).putExtra("play_mode", "2");
      ((Intent)localObject).putExtra("is_multi_progress_bar", true);
      ((Intent)localObject).putExtra("_from", "3");
      ((Intent)localObject).addFlags(268435456);
      ((Intent)localObject).putExtra("public_fragment_window_feature", 1);
      PublicTransFragmentActivity.b(this.jdField_a_of_type_AndroidContentContext, (Intent)localObject, QQNearbyManager.m());
      return;
    }
    catch (Exception paramString)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onItemClick exp:");
        ((StringBuilder)localObject).append(paramString.toString());
        QLog.w("BaseMomentItemBuilder", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public boolean a(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    return true;
  }
  
  public String b(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    return paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.c;
  }
  
  public void b(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    MomentFeedInfo localMomentFeedInfo = paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo;
    INowVideoReporter localINowVideoReporter = ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).opType("data_card").opName("feed_more_clk");
    Object localObject = "2";
    localINowVideoReporter = localINowVideoReporter.source("2").timelong(a(paramMomentViewHolder)).feedid(localMomentFeedInfo.c).feed_type(String.valueOf(a(paramMomentViewHolder)));
    if (this.jdField_a_of_type_Boolean) {
      localObject = "1";
    }
    localINowVideoReporter.d1((String)localObject).report(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localMomentFeedInfo.e))
    {
      localObject = ActionSheet.create(this.jdField_a_of_type_AndroidContentContext);
      ((ActionSheet)localObject).addButton(2131691479, 1);
      ((ActionSheet)localObject).addCancelButton(2131690728);
      ((ActionSheet)localObject).setOnButtonClickListener(new BaseMomentItemBuilder.2(this, paramMomentViewHolder, localMomentFeedInfo, (ActionSheet)localObject));
      ((ActionSheet)localObject).show();
      return;
    }
    localObject = ActionSheet.create(this.jdField_a_of_type_AndroidContentContext);
    ((ActionSheet)localObject).addButton(2131717470, 1);
    ((ActionSheet)localObject).addCancelButton(2131690728);
    ((ActionSheet)localObject).setOnButtonClickListener(new BaseMomentItemBuilder.3(this, paramMomentViewHolder, localMomentFeedInfo, (ActionSheet)localObject));
    ((ActionSheet)localObject).show();
  }
  
  public void c(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, HardCodeUtil.a(2131701245), 0).a();
      return;
    }
    a(paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.m, true);
  }
  
  public void d(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    Object localObject = paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.c;
    INowVideoReporter localINowVideoReporter = ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).opType("data_card").opName("feed_clk");
    String str = "2";
    localObject = localINowVideoReporter.source("2").timelong(a(paramMomentViewHolder)).feedid((String)localObject).feed_type(String.valueOf(a(paramMomentViewHolder)));
    if (this.jdField_a_of_type_Boolean) {
      str = "1";
    }
    ((INowVideoReporter)localObject).d1(str).report(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, HardCodeUtil.a(2131701248), 0).a();
      return;
    }
    a(paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.m, false);
  }
  
  public void e(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    PicMomentFeedInfo localPicMomentFeedInfo = (PicMomentFeedInfo)paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo;
    Object localObject = localPicMomentFeedInfo.a;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("feedId", localPicMomentFeedInfo.c);
      ((JSONObject)localObject).put("tinyId", "");
      ((JSONObject)localObject).put("uin", localPicMomentFeedInfo.e);
      ((JSONObject)localObject).put("reason", HardCodeUtil.a(2131701249));
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    TroopNoticeJsHandler.a(paramMomentViewHolder.jdField_a_of_type_AndroidAppActivity, 0, localArrayList, null, null, false, false, "5", 100, null, null, ((JSONObject)localObject).toString());
  }
  
  public abstract void f(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder);
  
  public void onClick(View paramView)
  {
    BaseMomentItemBuilder.MomentViewHolder localMomentViewHolder = (BaseMomentItemBuilder.MomentViewHolder)NearbyMomentUtils.a(paramView, BaseMomentItemBuilder.MomentViewHolder.class);
    if (localMomentViewHolder == null) {
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131381021: 
      INowVideoReporter localINowVideoReporter = ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).opType("data_card").opName("feed_com_clk");
      paramView = "2";
      localINowVideoReporter = localINowVideoReporter.source("2").timelong(a(localMomentViewHolder)).feedid(localMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.c).feed_type(String.valueOf(a(localMomentViewHolder)));
      if (this.jdField_a_of_type_Boolean) {
        paramView = "1";
      }
      localINowVideoReporter.d1(paramView).report(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      break;
    case 2131374283: 
      d(localMomentViewHolder);
      return;
    case 2131369444: 
      h(localMomentViewHolder);
      return;
    case 2131369437: 
      e(localMomentViewHolder);
      return;
    case 2131369420: 
      b(localMomentViewHolder);
      return;
    }
    c(localMomentViewHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.BaseMomentItemBuilder
 * JD-Core Version:    0.7.0.1
 */