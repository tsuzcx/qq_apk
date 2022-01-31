package com.tencent.mobileqq.nearby.profilecard.moment;

import afjp;
import afjq;
import afjr;
import afju;
import afjv;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.now.SmallVideoFragment;
import com.tencent.mobileqq.nearby.now.utils.NowVideoReporter;
import com.tencent.mobileqq.nearby.profilecard.moment.data.MomentFeedInfo;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ActionSheet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseMomentItemBuilder
  implements View.OnClickListener, CommentsAdapter.CommentsItemClickListener
{
  public Context a;
  protected GradientDrawable a;
  public QQAppInterface a;
  protected NearbyPeopleCard a;
  protected FaceDecoder a;
  protected Map a;
  public boolean a;
  protected GradientDrawable b;
  protected Map b;
  protected Map c = new HashMap();
  
  public BaseMomentItemBuilder(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private GradientDrawable a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable == null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable = new GradientDrawable();
      this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setColor(-6503177);
      this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setCornerRadius(UIUtils.a(BaseApplicationImpl.getContext(), 2.0F));
    }
    return this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable;
  }
  
  private void a(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder, String paramString)
  {
    String[] arrayOfString = this.jdField_a_of_type_AndroidContentContext.getResources().getStringArray(2131296325);
    ActionSheet localActionSheet = ActionSheet.a(this.jdField_a_of_type_AndroidContentContext);
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      localActionSheet.a(str, 1);
      localActionSheet.a(str, 1);
      localActionSheet.a(str, 1);
      i += 1;
    }
    localActionSheet.c(2131433015);
    localActionSheet.a(new afjv(this, paramMomentViewHolder, arrayOfString, paramString, localActionSheet));
    localActionSheet.show();
  }
  
  private GradientDrawable b()
  {
    if (this.jdField_b_of_type_AndroidGraphicsDrawableGradientDrawable == null)
    {
      this.jdField_b_of_type_AndroidGraphicsDrawableGradientDrawable = new GradientDrawable();
      this.jdField_b_of_type_AndroidGraphicsDrawableGradientDrawable.setColor(-75114);
      this.jdField_b_of_type_AndroidGraphicsDrawableGradientDrawable.setCornerRadius(UIUtils.a(BaseApplicationImpl.getContext(), 2.0F));
    }
    return this.jdField_b_of_type_AndroidGraphicsDrawableGradientDrawable;
  }
  
  private void g(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    MomentFeedInfo localMomentFeedInfo = paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo;
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle("确定删除该动态？").setNegativeButton(2131433015, new afju(this, paramMomentViewHolder)).setPositiveButton(2131434041, new afjr(this, paramMomentViewHolder, localMomentFeedInfo)).show();
  }
  
  private void h(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    if (!NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, "网络异常，无法操作", 0).a();
      return;
    }
    boolean bool = paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.jdField_a_of_type_Boolean;
    String str = b(paramMomentViewHolder);
    Object localObject = (NearbyMomentManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(262);
    if (!bool)
    {
      ((NearbyMomentManager)localObject).a(str);
      NowVideoReporter localNowVideoReporter = new NowVideoReporter().h("data_card");
      if (!bool) {
        break label154;
      }
      localObject = "feed_unlike";
      label86:
      localObject = localNowVideoReporter.i((String)localObject).d("2").a(a(paramMomentViewHolder)).b(str).c(String.valueOf(a(paramMomentViewHolder)));
      if (!this.jdField_a_of_type_Boolean) {
        break label160;
      }
    }
    label154:
    label160:
    for (paramMomentViewHolder = "1";; paramMomentViewHolder = "2")
    {
      ((NowVideoReporter)localObject).e(paramMomentViewHolder).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      ((NearbyMomentManager)localObject).b(str);
      break;
      localObject = "feed_like";
      break label86;
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
      localMomentViewHolder.jdField_a_of_type_AndroidViewView = ((View)localObject);
      paramView = LayoutInflater.from(paramContext).inflate(2130970480, (ViewGroup)localObject, false);
      LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams1.topMargin = UIUtils.a(paramContext, 20.0F);
      localLayoutParams1.leftMargin = UIUtils.a(paramContext, 16.0F);
      localLayoutParams1.bottomMargin = UIUtils.a(paramContext, 12.0F);
      localLayoutParams1.rightMargin = UIUtils.a(paramContext, 6.0F);
      localMomentViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364301));
      localMomentViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363549));
      localMomentViewHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370842));
      localMomentViewHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370843));
      localMomentViewHolder.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370844));
      localMomentViewHolder.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370845));
      View localView1 = LayoutInflater.from(paramContext).inflate(2130970475, (ViewGroup)localObject, false);
      LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams2.leftMargin = UIUtils.a(paramContext, 66.0F);
      localLayoutParams2.rightMargin = UIUtils.a(paramContext, 6.0F);
      localMomentViewHolder.i = ((TextView)localView1.findViewById(2131370826));
      localMomentViewHolder.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView1.findViewById(2131363555));
      localMomentViewHolder.jdField_e_of_type_AndroidWidgetTextView = ((TextView)localView1.findViewById(2131370827));
      localMomentViewHolder.jdField_c_of_type_AndroidViewView = localView1.findViewById(2131370828);
      localMomentViewHolder.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)localView1.findViewById(2131370829));
      localMomentViewHolder.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
      localMomentViewHolder.f = ((TextView)localView1.findViewById(2131370830));
      localMomentViewHolder.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)localView1.findViewById(2131370831));
      localMomentViewHolder.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this);
      localMomentViewHolder.g = ((TextView)localView1.findViewById(2131368478));
      localMomentViewHolder.jdField_a_of_type_AndroidWidgetListView = ((ListView)localView1.findViewById(2131370833));
      localMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentCommentsAdapter = new CommentsAdapter();
      localMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentCommentsAdapter.a(this);
      localMomentViewHolder.jdField_a_of_type_AndroidWidgetListView.setAdapter(localMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentCommentsAdapter);
      localMomentViewHolder.h = ((TextView)localView1.findViewById(2131370834));
      localMomentViewHolder.jdField_d_of_type_AndroidViewView = localView1.findViewById(2131370832);
      localMomentViewHolder.h.setOnClickListener(this);
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
        ((LinearLayout)localObject).addView(localView2);
        localView2.setId(2131362465);
        localMomentViewHolder.jdField_b_of_type_AndroidViewView = localView2;
        localView2.setOnClickListener(this);
      }
      ((LinearLayout)localObject).addView(localView1, localLayoutParams2);
      ((LinearLayout)localObject).setTag(localMomentViewHolder);
      localMomentViewHolder.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      paramContext = new View(this.jdField_a_of_type_AndroidContentContext);
      paramContext.setLayoutParams(new LinearLayout.LayoutParams(-1, UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F)));
      paramContext.setBackgroundColor(-460807);
      ((LinearLayout)localObject).addView(paramContext);
      paramView = (View)localObject;
      paramContext = (BaseMomentItemBuilder.MomentViewHolder)paramView.getTag();
      paramContext.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo = paramMomentFeedInfo;
      a(paramContext);
      paramMomentFeedInfo = paramView;
    } while (this.jdField_a_of_type_JavaUtilMap.get(paramContext.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.c) != null);
    localObject = new NowVideoReporter().h("data_card").i("feed_exp").a(a(paramContext)).d("2").b(paramContext.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.c).c(String.valueOf(a(paramContext)));
    if (this.jdField_a_of_type_Boolean) {}
    for (paramMomentFeedInfo = "1";; paramMomentFeedInfo = "2")
    {
      ((NowVideoReporter)localObject).e(paramMomentFeedInfo).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_JavaUtilMap.put(paramContext.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.c, paramContext.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo);
      return paramView;
    }
  }
  
  public abstract BaseMomentItemBuilder.MomentViewHolder a();
  
  public String a(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    return "";
  }
  
  public void a(View paramView)
  {
    c((BaseMomentItemBuilder.MomentViewHolder)NearbyMomentUtils.a(paramView));
  }
  
  public void a(NearbyPeopleCard paramNearbyPeopleCard)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard = paramNearbyPeopleCard;
    if (TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramNearbyPeopleCard.uin)) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    Object localObject3;
    Object localObject2;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null)
    {
      localObject3 = paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.d;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(32, (String)localObject3, 200);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a((String)localObject3, 200, true, false);
        localObject1 = ImageUtil.c();
      }
      paramMomentViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
    {
      paramMomentViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname);
      paramMomentViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 0)
      {
        paramMomentViewHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130842855);
        paramMomentViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age == 0) {
          break label998;
        }
        paramMomentViewHolder.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable(a());
        paramMomentViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age + "岁");
        label175:
        paramMomentViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.charmLevel <= 0) {
          break label1010;
        }
        paramMomentViewHolder.jdField_c_of_type_AndroidWidgetTextView.setBackgroundDrawable(b());
        paramMomentViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText("LV" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.charmLevel);
      }
    }
    else
    {
      label237:
      paramMomentViewHolder.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      f(paramMomentViewHolder);
      paramMomentViewHolder.i.setOnClickListener(this);
      if (TextUtils.isEmpty(paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.jdField_f_of_type_JavaLangString)) {
        break label1022;
      }
      paramMomentViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      paramMomentViewHolder.jdField_d_of_type_AndroidWidgetTextView.setText(paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.jdField_f_of_type_JavaLangString);
      label293:
      localObject1 = new StringBuilder();
      if (!TextUtils.isEmpty(paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.jdField_g_of_type_JavaLangString)) {
        ((StringBuilder)localObject1).append(paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.jdField_g_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.jdField_e_of_type_JavaLangString))
      {
        if (((StringBuilder)localObject1).length() > 0) {
          ((StringBuilder)localObject1).append(" · ");
        }
        ((StringBuilder)localObject1).append(paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.jdField_e_of_type_JavaLangString);
      }
      if ((c(paramMomentViewHolder)) && (!b(paramMomentViewHolder)) && (!b(paramMomentViewHolder)))
      {
        if (((StringBuilder)localObject1).length() > 0) {
          ((StringBuilder)localObject1).append(" · ");
        }
        ((StringBuilder)localObject1).append(paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.jdField_e_of_type_Int).append("次播放");
      }
      if (((StringBuilder)localObject1).length() <= 0) {
        break label1034;
      }
      paramMomentViewHolder.jdField_e_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject1).toString());
      paramMomentViewHolder.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      label449:
      if (!d(paramMomentViewHolder)) {
        break label1069;
      }
      paramMomentViewHolder.jdField_c_of_type_AndroidViewView.setVisibility(0);
      if (!paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.jdField_a_of_type_Boolean) {
        break label1046;
      }
      paramMomentViewHolder.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130842859);
      paramMomentViewHolder.f.setTextColor(-52924);
      label495:
      paramMomentViewHolder.f.setText(String.valueOf(paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.jdField_f_of_type_Int));
      paramMomentViewHolder.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
      paramMomentViewHolder.g.setText(String.valueOf(paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.jdField_g_of_type_Int));
      label537:
      localObject2 = paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.jdField_a_of_type_JavaUtilList;
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break label1087;
      }
      paramMomentViewHolder.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
      paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentCommentsAdapter.a((List)localObject2);
      if (this.jdField_b_of_type_JavaUtilMap.get(paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.c) == null)
      {
        localObject3 = new NowVideoReporter().h("data_card").i("feed_com_exp").d("2").a(a(paramMomentViewHolder)).b(paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.c).c(String.valueOf(a(paramMomentViewHolder)));
        if (!this.jdField_a_of_type_Boolean) {
          break label1081;
        }
        localObject1 = "1";
        label657:
        ((NowVideoReporter)localObject3).e((String)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_b_of_type_JavaUtilMap.put(paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.c, paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo);
      }
      label691:
      if ((localObject2 == null) || (((List)localObject2).size() <= 0) || (paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.jdField_g_of_type_Int <= ((List)localObject2).size())) {
        break label1099;
      }
      paramMomentViewHolder.h.setVisibility(0);
      label728:
      if ((paramMomentViewHolder.jdField_a_of_type_AndroidWidgetListView.getVisibility() == 0) || (paramMomentViewHolder.h.getVisibility() == 0)) {
        break label1111;
      }
      paramMomentViewHolder.jdField_d_of_type_AndroidViewView.setVisibility(8);
      label757:
      if (!b(paramMomentViewHolder)) {
        break label1122;
      }
      paramMomentViewHolder.i.setVisibility(0);
      if (this.c.get(paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.c) == null)
      {
        new NowVideoReporter().h("video_public").i("exp_failfeed").d("2").a(a(paramMomentViewHolder)).c(String.valueOf(a(paramMomentViewHolder))).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.c.put(paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.c, paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo);
      }
      label863:
      if (!a(paramMomentViewHolder)) {
        break label1134;
      }
      paramMomentViewHolder.jdField_c_of_type_AndroidWidgetImageView.setClickable(false);
      paramMomentViewHolder.jdField_c_of_type_AndroidWidgetImageView.setAlpha(0.3F);
    }
    for (;;)
    {
      if ((!b(paramMomentViewHolder)) && (!a(paramMomentViewHolder))) {
        break label1153;
      }
      paramMomentViewHolder.jdField_d_of_type_AndroidWidgetImageView.setClickable(false);
      paramMomentViewHolder.jdField_e_of_type_AndroidWidgetImageView.setClickable(false);
      paramMomentViewHolder.jdField_d_of_type_AndroidWidgetImageView.setAlpha(0.3F);
      paramMomentViewHolder.f.setAlpha(0.3F);
      paramMomentViewHolder.jdField_e_of_type_AndroidWidgetImageView.setAlpha(0.3F);
      paramMomentViewHolder.g.setAlpha(0.3F);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 1)
      {
        paramMomentViewHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130842862);
        break;
      }
      paramMomentViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      label998:
      paramMomentViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label175;
      label1010:
      paramMomentViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      break label237;
      label1022:
      paramMomentViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      break label293;
      label1034:
      paramMomentViewHolder.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      break label449;
      label1046:
      paramMomentViewHolder.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130842860);
      paramMomentViewHolder.f.setTextColor(-4473925);
      break label495;
      label1069:
      paramMomentViewHolder.jdField_c_of_type_AndroidViewView.setVisibility(8);
      break label537;
      label1081:
      localObject1 = "2";
      break label657;
      label1087:
      paramMomentViewHolder.jdField_a_of_type_AndroidWidgetListView.setVisibility(8);
      break label691;
      label1099:
      paramMomentViewHolder.h.setVisibility(8);
      break label728;
      label1111:
      paramMomentViewHolder.jdField_d_of_type_AndroidViewView.setVisibility(0);
      break label757;
      label1122:
      paramMomentViewHolder.i.setVisibility(8);
      break label863;
      label1134:
      paramMomentViewHolder.jdField_c_of_type_AndroidWidgetImageView.setClickable(true);
      paramMomentViewHolder.jdField_c_of_type_AndroidWidgetImageView.setAlpha(1.0F);
    }
    label1153:
    paramMomentViewHolder.jdField_d_of_type_AndroidWidgetImageView.setClickable(true);
    paramMomentViewHolder.jdField_e_of_type_AndroidWidgetImageView.setClickable(true);
    paramMomentViewHolder.jdField_d_of_type_AndroidWidgetImageView.setAlpha(1.0F);
    paramMomentViewHolder.f.setAlpha(1.0F);
    paramMomentViewHolder.jdField_e_of_type_AndroidWidgetImageView.setAlpha(1.0F);
    paramMomentViewHolder.g.setAlpha(1.0F);
  }
  
  public void a(FaceDecoder paramFaceDecoder)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = paramFaceDecoder;
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
    return false;
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
      if (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localMomentFeedInfo.d)) {
        break;
      }
      localObject = ActionSheet.a(this.jdField_a_of_type_AndroidContentContext);
      ((ActionSheet)localObject).a(2131434041, 1);
      ((ActionSheet)localObject).c(2131433015);
      ((ActionSheet)localObject).a(new afjp(this, paramMomentViewHolder, localMomentFeedInfo, (ActionSheet)localObject));
      ((ActionSheet)localObject).show();
      return;
    }
    localObject = ActionSheet.a(this.jdField_a_of_type_AndroidContentContext);
    ((ActionSheet)localObject).a(2131432526, 1);
    ((ActionSheet)localObject).c(2131433015);
    ((ActionSheet)localObject).a(new afjq(this, paramMomentViewHolder, localMomentFeedInfo, (ActionSheet)localObject));
    ((ActionSheet)localObject).show();
  }
  
  public boolean b(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    return false;
  }
  
  public void c(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    if (!NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, "网络异常，无法操作", 0).a();
      return;
    }
    a(paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.h, true);
  }
  
  public boolean c(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    return true;
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
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, "网络异常，无法观看", 0).a();
      return;
    }
    a(paramMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.h, false);
  }
  
  public boolean d(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    return true;
  }
  
  public void e(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BaseMomentItemBuilder", 2, "handleRetryViewClick");
    }
  }
  
  public abstract void f(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder);
  
  public void onClick(View paramView)
  {
    BaseMomentItemBuilder.MomentViewHolder localMomentViewHolder = (BaseMomentItemBuilder.MomentViewHolder)NearbyMomentUtils.a(paramView);
    if (localMomentViewHolder == null) {
      return;
    }
    NowVideoReporter localNowVideoReporter;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131362465: 
      d(localMomentViewHolder);
      return;
    case 2131370845: 
      b(localMomentViewHolder);
      return;
    case 2131370829: 
      h(localMomentViewHolder);
      return;
    case 2131370834: 
      localNowVideoReporter = new NowVideoReporter().h("data_card").i("feed_com_clk").d("2").a(a(localMomentViewHolder)).b(localMomentViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.c).c(String.valueOf(a(localMomentViewHolder)));
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
    case 2131370831: 
      for (paramView = "1";; paramView = "2")
      {
        localNowVideoReporter.e(paramView).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        c(localMomentViewHolder);
        return;
      }
    }
    e(localMomentViewHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.BaseMomentItemBuilder
 * JD-Core Version:    0.7.0.1
 */