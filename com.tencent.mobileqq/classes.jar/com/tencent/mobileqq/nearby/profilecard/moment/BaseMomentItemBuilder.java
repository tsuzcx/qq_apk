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
import com.tencent.mobileqq.nearby.now.SmallVideoFragment;
import com.tencent.mobileqq.nearby.now.utils.NowVideoReporter;
import com.tencent.mobileqq.nearby.profilecard.moment.data.MomentFeedInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.PicMomentFeedInfo;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(HardCodeUtil.a(2131701109)).setNegativeButton(2131690800, new BaseMomentItemBuilder.5(this)).setPositiveButton(2131691558, new BaseMomentItemBuilder.4(this, localMomentFeedInfo, paramMomentViewHolder)).show();
  }
  
  private void h(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    if (!NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, HardCodeUtil.a(2131701106), 0).a();
      return;
    }
    boolean bool = paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.jdField_a_of_type_Boolean;
    String str = b(paramMomentViewHolder);
    Object localObject = (NearbyMomentManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_MOMENT_MANAGER);
    if (!bool)
    {
      ((NearbyMomentManager)localObject).a(str);
      NowVideoReporter localNowVideoReporter = new NowVideoReporter().h("data_card");
      if (!bool) {
        break label157;
      }
      localObject = "feed_unlike";
      label89:
      localObject = localNowVideoReporter.i((String)localObject).d("2").a(a(paramMomentViewHolder)).b(str).c(String.valueOf(a(paramMomentViewHolder)));
      if (!this.jdField_a_of_type_Boolean) {
        break label163;
      }
    }
    label157:
    label163:
    for (paramMomentViewHolder = "1";; paramMomentViewHolder = "2")
    {
      ((NowVideoReporter)localObject).e(paramMomentViewHolder).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      ((NearbyMomentManager)localObject).b(str);
      break;
      localObject = "feed_like";
      break label89;
    }
  }
  
  public abstract int a(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder);
  
  public abstract View a(ViewGroup paramViewGroup, BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder);
  
  public View a(MomentFeedInfo paramMomentFeedInfo, Context paramContext, View paramView)
  {
    Object localObject = (LinearLayout)paramView;
    paramView = (View)localObject;
    BaseMomentItemBuilder.MomentViewHolder localMomentViewHolder;
    if (localObject == null)
    {
      localObject = new LinearLayout(paramContext);
      ((LinearLayout)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      ((LinearLayout)localObject).setBackgroundColor(-1);
      ((LinearLayout)localObject).setOrientation(1);
      localMomentViewHolder = a();
      if (localMomentViewHolder == null) {
        paramMomentFeedInfo = null;
      }
    }
    do
    {
      return paramMomentFeedInfo;
      localMomentViewHolder.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
      localMomentViewHolder.jdField_a_of_type_AndroidViewView = ((View)localObject);
      paramView = LayoutInflater.from(paramContext).inflate(2131561387, (ViewGroup)localObject, false);
      LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams1.topMargin = UIUtils.a(paramContext, 20.0F);
      localLayoutParams1.leftMargin = UIUtils.a(paramContext, 16.0F);
      localLayoutParams1.bottomMargin = UIUtils.a(paramContext, 0.0F);
      localLayoutParams1.rightMargin = UIUtils.a(paramContext, 6.0F);
      localMomentViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369675));
      localMomentViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380475));
      localMomentViewHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369722));
      View localView1 = LayoutInflater.from(paramContext).inflate(2131561383, (ViewGroup)localObject, false);
      LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams2.leftMargin = UIUtils.a(paramContext, 66.0F);
      localLayoutParams2.rightMargin = UIUtils.a(paramContext, 6.0F);
      localMomentViewHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView1.findViewById(2131380451));
      localMomentViewHolder.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView1.findViewById(2131380349));
      localMomentViewHolder.jdField_c_of_type_AndroidViewView = localView1.findViewById(2131373429);
      localMomentViewHolder.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView1.findViewById(2131369754));
      localMomentViewHolder.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      localMomentViewHolder.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView1.findViewById(2131380521));
      localMomentViewHolder.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)localView1.findViewById(2131369619));
      localMomentViewHolder.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
      localMomentViewHolder.e = ((TextView)localView1.findViewById(2131380267));
      localMomentViewHolder.jdField_a_of_type_AndroidWidgetListView = ((ListView)localView1.findViewById(2131365115));
      localMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentCommentsAdapter = new CommentsAdapter();
      localMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentCommentsAdapter.a(this);
      localMomentViewHolder.jdField_a_of_type_AndroidWidgetListView.setAdapter(localMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentCommentsAdapter);
      localMomentViewHolder.f = ((TextView)localView1.findViewById(2131381799));
      localMomentViewHolder.jdField_d_of_type_AndroidViewView = localView1.findViewById(2131365113);
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
        localView2.setId(2131374747);
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
      localObject = (BaseMomentItemBuilder.MomentViewHolder)paramView.getTag();
      ((BaseMomentItemBuilder.MomentViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo = paramMomentFeedInfo;
      a((BaseMomentItemBuilder.MomentViewHolder)localObject);
      if ((!TextUtils.isEmpty(paramMomentFeedInfo.k)) && (!paramMomentFeedInfo.k.endsWith(HardCodeUtil.a(2131701110)))) {
        break;
      }
      ((BaseMomentItemBuilder.MomentViewHolder)localObject).jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130845819, 0, 0, 0);
      ((BaseMomentItemBuilder.MomentViewHolder)localObject).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(null);
      ((BaseMomentItemBuilder.MomentViewHolder)localObject).jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
      paramMomentFeedInfo = paramView;
    } while (this.jdField_a_of_type_JavaUtilMap.get(((BaseMomentItemBuilder.MomentViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.c) != null);
    paramContext = new NowVideoReporter().h("data_card").i("feed_exp").a(a((BaseMomentItemBuilder.MomentViewHolder)localObject)).d("2").b(((BaseMomentItemBuilder.MomentViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.c).c(String.valueOf(a((BaseMomentItemBuilder.MomentViewHolder)localObject)));
    if (this.jdField_a_of_type_Boolean) {}
    for (paramMomentFeedInfo = "1";; paramMomentFeedInfo = "2")
    {
      paramContext.e(paramMomentFeedInfo).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_JavaUtilMap.put(((BaseMomentItemBuilder.MomentViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.c, ((BaseMomentItemBuilder.MomentViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo);
      return paramView;
      ((BaseMomentItemBuilder.MomentViewHolder)localObject).jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130845821, 0, 0, 0);
      ((BaseMomentItemBuilder.MomentViewHolder)localObject).jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#576B95"));
      ((BaseMomentItemBuilder.MomentViewHolder)localObject).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new BaseMomentItemBuilder.1(this, paramContext, paramMomentFeedInfo, (BaseMomentItemBuilder.MomentViewHolder)localObject));
      break;
    }
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
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840454);
    try
    {
      localObject = URLDrawable.getDrawable(paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.d, (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setTag(URLDrawableDecodeHandler.a(UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 40.0F), UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 40.0F)));
      ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.a);
      paramMomentViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) {
        paramMomentViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname);
      }
      paramMomentViewHolder.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      f(paramMomentViewHolder);
      if (!TextUtils.isEmpty(paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.jdField_g_of_type_JavaLangString))
      {
        paramMomentViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramMomentViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.jdField_g_of_type_JavaLangString);
        localObject = new StringBuilder();
        if (!TextUtils.isEmpty(paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.jdField_f_of_type_JavaLangString))
        {
          if (((StringBuilder)localObject).length() > 0) {
            ((StringBuilder)localObject).append(" · ");
          }
          ((StringBuilder)localObject).append(paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.jdField_f_of_type_JavaLangString);
        }
        if (((StringBuilder)localObject).length() <= 0) {
          break label695;
        }
        paramMomentViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject).toString());
        paramMomentViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        if (!a(paramMomentViewHolder)) {
          break label730;
        }
        paramMomentViewHolder.jdField_c_of_type_AndroidViewView.setVisibility(0);
        if (!paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.jdField_a_of_type_Boolean) {
          break label707;
        }
        paramMomentViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845762);
        paramMomentViewHolder.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-52924);
        paramMomentViewHolder.jdField_d_of_type_AndroidWidgetTextView.setText(String.valueOf(paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.jdField_f_of_type_Int));
        paramMomentViewHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        paramMomentViewHolder.e.setText(String.valueOf(paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.jdField_g_of_type_Int));
        List localList = paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.jdField_a_of_type_JavaUtilList;
        if ((localList == null) || (localList.size() <= 0)) {
          break label748;
        }
        paramMomentViewHolder.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
        paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentCommentsAdapter.a(localList);
        paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentCommentsAdapter.notifyDataSetChanged();
        if (this.b.get(paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.c) == null)
        {
          NowVideoReporter localNowVideoReporter = new NowVideoReporter().h("data_card").i("feed_com_exp").d("2").a(a(paramMomentViewHolder)).b(paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.c).c(String.valueOf(a(paramMomentViewHolder)));
          if (!this.jdField_a_of_type_Boolean) {
            break label742;
          }
          localObject = "1";
          localNowVideoReporter.e((String)localObject).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          this.b.put(paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.c, paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo);
        }
        if ((localList == null) || (localList.size() <= 0) || (paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.jdField_g_of_type_Int <= localList.size())) {
          break label760;
        }
        paramMomentViewHolder.f.setVisibility(0);
        if ((paramMomentViewHolder.jdField_a_of_type_AndroidWidgetListView.getVisibility() == 0) || (paramMomentViewHolder.f.getVisibility() == 0)) {
          break label772;
        }
        paramMomentViewHolder.jdField_d_of_type_AndroidViewView.setVisibility(8);
        paramMomentViewHolder.jdField_b_of_type_AndroidWidgetImageView.setClickable(true);
        paramMomentViewHolder.jdField_b_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        paramMomentViewHolder.jdField_c_of_type_AndroidWidgetImageView.setClickable(true);
        paramMomentViewHolder.jdField_d_of_type_AndroidWidgetImageView.setClickable(true);
        paramMomentViewHolder.jdField_c_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        paramMomentViewHolder.jdField_d_of_type_AndroidWidgetTextView.setAlpha(1.0F);
        paramMomentViewHolder.jdField_d_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        paramMomentViewHolder.e.setAlpha(1.0F);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramMomentViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840454));
        QLog.i("BaseMomentItemBuilder", 1, "updateUI, holder.momentFeedInfo.headUrl=" + paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.d);
        continue;
        paramMomentViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        continue;
        label695:
        paramMomentViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        continue;
        label707:
        paramMomentViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845780);
        paramMomentViewHolder.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-4473925);
        continue;
        label730:
        paramMomentViewHolder.jdField_c_of_type_AndroidViewView.setVisibility(8);
        continue;
        label742:
        String str = "2";
        continue;
        label748:
        paramMomentViewHolder.jdField_a_of_type_AndroidWidgetListView.setVisibility(8);
        continue;
        label760:
        paramMomentViewHolder.f.setVisibility(8);
        continue;
        label772:
        paramMomentViewHolder.jdField_d_of_type_AndroidViewView.setVisibility(0);
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("raw_url", paramString);
      localIntent.putExtra("scroll_to_comment", paramBoolean);
      localIntent.putExtra("play_mode", "2");
      localIntent.putExtra("is_multi_progress_bar", true);
      localIntent.putExtra("_from", "3");
      localIntent.addFlags(268435456);
      localIntent.putExtra("public_fragment_window_feature", 1);
      PublicTransFragmentActivity.b(this.jdField_a_of_type_AndroidContentContext, localIntent, SmallVideoFragment.class);
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("BaseMomentItemBuilder", 2, "onItemClick exp:" + paramString.toString());
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
    NowVideoReporter localNowVideoReporter = new NowVideoReporter().h("data_card").i("feed_more_clk").d("2").a(a(paramMomentViewHolder)).b(localMomentFeedInfo.c).c(String.valueOf(a(paramMomentViewHolder)));
    if (this.jdField_a_of_type_Boolean) {}
    for (Object localObject = "1";; localObject = "2")
    {
      localNowVideoReporter.e((String)localObject).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localMomentFeedInfo.e)) {
        break;
      }
      localObject = ActionSheet.create(this.jdField_a_of_type_AndroidContentContext);
      ((ActionSheet)localObject).addButton(2131691558, 1);
      ((ActionSheet)localObject).addCancelButton(2131690800);
      ((ActionSheet)localObject).setOnButtonClickListener(new BaseMomentItemBuilder.2(this, paramMomentViewHolder, localMomentFeedInfo, (ActionSheet)localObject));
      ((ActionSheet)localObject).show();
      return;
    }
    localObject = ActionSheet.create(this.jdField_a_of_type_AndroidContentContext);
    ((ActionSheet)localObject).addButton(2131717811, 1);
    ((ActionSheet)localObject).addCancelButton(2131690800);
    ((ActionSheet)localObject).setOnButtonClickListener(new BaseMomentItemBuilder.3(this, paramMomentViewHolder, localMomentFeedInfo, (ActionSheet)localObject));
    ((ActionSheet)localObject).show();
  }
  
  public void c(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    if (!NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, HardCodeUtil.a(2131701104), 0).a();
      return;
    }
    a(paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.m, true);
  }
  
  public void d(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    String str = paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.c;
    NowVideoReporter localNowVideoReporter = new NowVideoReporter().h("data_card").i("feed_clk").d("2").a(a(paramMomentViewHolder)).b(str).c(String.valueOf(a(paramMomentViewHolder)));
    if (this.jdField_a_of_type_Boolean) {}
    for (str = "1";; str = "2")
    {
      localNowVideoReporter.e(str).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext)) {
        break;
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, HardCodeUtil.a(2131701107), 0).a();
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
      ((JSONObject)localObject).put("reason", HardCodeUtil.a(2131701108));
      TroopNoticeJsHandler.a(paramMomentViewHolder.jdField_a_of_type_AndroidAppActivity, 0, localArrayList, null, null, false, false, "5", 100, null, null, ((JSONObject)localObject).toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public abstract void f(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder);
  
  public void onClick(View paramView)
  {
    BaseMomentItemBuilder.MomentViewHolder localMomentViewHolder = (BaseMomentItemBuilder.MomentViewHolder)NearbyMomentUtils.a(paramView, BaseMomentItemBuilder.MomentViewHolder.class);
    if (localMomentViewHolder == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131369619: 
        c(localMomentViewHolder);
        break;
      case 2131369722: 
        b(localMomentViewHolder);
        break;
      case 2131369754: 
        h(localMomentViewHolder);
        break;
      case 2131381799: 
        NowVideoReporter localNowVideoReporter = new NowVideoReporter().h("data_card").i("feed_com_clk").d("2").a(a(localMomentViewHolder)).b(localMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.c).c(String.valueOf(a(localMomentViewHolder)));
        if (this.jdField_a_of_type_Boolean) {}
        for (String str = "1";; str = "2")
        {
          localNowVideoReporter.e(str).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          break;
        }
      case 2131374747: 
        d(localMomentViewHolder);
        break;
      case 2131369746: 
        e(localMomentViewHolder);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.BaseMomentItemBuilder
 * JD-Core Version:    0.7.0.1
 */