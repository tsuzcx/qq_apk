package com.tencent.mobileqq.search.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyHelper.OnTroopSafeDialogClickConfirm;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.adapter.GroupSearchAdapter;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.util.SearchViewUtils;
import com.tencent.mobileqq.search.view.ISearchResultView;
import com.tencent.mobileqq.search.view.SearchResultFromNetView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.activity.JoinTroopUtil;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.mobileqq.troop.widget.TroopActiveLayout;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.vas.PrettyAccountUtil;
import com.tencent.mobileqq.widget.FolderTextView;
import com.tencent.qphone.base.util.QLog;

public class ActiveEntitySearchResultPresenter
  extends SearchResultPresenter
{
  int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private TroopNotifyHelper.OnTroopSafeDialogClickConfirm jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyHelper$OnTroopSafeDialogClickConfirm = new ActiveEntitySearchResultPresenter.2(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopBusinessObserver jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new ActiveEntitySearchResultPresenter.1(this);
  private GroupSearchAdapter jdField_a_of_type_ComTencentMobileqqSearchAdapterGroupSearchAdapter;
  private GroupBaseNetSearchModelItem jdField_a_of_type_ComTencentMobileqqSearchModelGroupBaseNetSearchModelItem;
  boolean jdField_a_of_type_Boolean = false;
  
  public ActiveEntitySearchResultPresenter(IFaceDecoder paramIFaceDecoder, int paramInt)
  {
    super(paramIFaceDecoder);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  public ActiveEntitySearchResultPresenter(IFaceDecoder paramIFaceDecoder, int paramInt, GroupSearchAdapter paramGroupSearchAdapter)
  {
    super(paramIFaceDecoder);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqSearchAdapterGroupSearchAdapter = paramGroupSearchAdapter;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  private void a(Context paramContext, GroupBaseNetSearchModelItem paramGroupBaseNetSearchModelItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, "joinTroop, ctx = " + paramContext + ", model = " + paramGroupBaseNetSearchModelItem);
    }
    if ((paramContext == null) || (paramGroupBaseNetSearchModelItem == null)) {}
    do
    {
      return;
      if (!(paramContext instanceof Activity)) {
        break;
      }
    } while (((Activity)paramContext).isFinishing());
    Object localObject = ((Activity)paramContext).getIntent();
    if (localObject != null) {}
    for (int j = ((Intent)localObject).getIntExtra("from_type_for_report", 0);; j = 0)
    {
      if (j == 9) {}
      for (int i = 112; (paramContext instanceof ActiveEntitySearchActivity); i = 103)
      {
        localObject = ((Activity)paramContext).getIntent().getLongArrayExtra("group_mask_long_array");
        if ((localObject != null) && (localObject.length == 1) && (localObject[0] == 1002L)) {
          if (j == 9) {
            i = 113;
          }
        }
        for (;;)
        {
          switch (i)
          {
          }
          for (;;)
          {
            JoinTroopUtil.a(paramContext, paramGroupBaseNetSearchModelItem.jdField_b_of_type_JavaLangString, paramGroupBaseNetSearchModelItem.jdField_c_of_type_JavaLangString, i, "", paramGroupBaseNetSearchModelItem.q, false, new ActiveEntitySearchResultPresenter.5(this, paramGroupBaseNetSearchModelItem));
            return;
            i = 104;
            break;
            if (paramGroupBaseNetSearchModelItem.jdField_d_of_type_Boolean)
            {
              i = 30013;
            }
            else
            {
              i = 30015;
              continue;
              if (paramGroupBaseNetSearchModelItem.jdField_d_of_type_Boolean) {
                i = 30017;
              } else {
                i = 30019;
              }
            }
          }
        }
      }
      break;
    }
  }
  
  public static void a(ImageView paramImageView1, ImageView paramImageView2, int paramInt)
  {
    Drawable localDrawable;
    if (paramInt == 1)
    {
      localDrawable = paramImageView2.getResources().getDrawable(2130842522);
      paramImageView1.setColorFilter(-1610612736, PorterDuff.Mode.SRC_OVER);
      paramImageView2.setImageDrawable(localDrawable);
      paramImageView2.setScaleType(ImageView.ScaleType.CENTER);
      paramImageView2.setVisibility(0);
      return;
    }
    if (paramInt == 2)
    {
      localDrawable = paramImageView2.getResources().getDrawable(2130842551);
      paramImageView1.setColorFilter(-1610612736, PorterDuff.Mode.SRC_OVER);
      paramImageView2.setImageDrawable(localDrawable);
      paramImageView2.setScaleType(ImageView.ScaleType.CENTER);
      paramImageView2.setVisibility(0);
      return;
    }
    paramImageView1.setColorFilter(0);
    paramImageView2.setVisibility(8);
  }
  
  public static void a(TextView paramTextView1, TextView paramTextView2, CharSequence paramCharSequence, TextView paramTextView3)
  {
    Paint localPaint = new Paint();
    if ((paramTextView1 == null) || (paramTextView2 == null) || (paramCharSequence == null)) {
      return;
    }
    int i = paramTextView1.getContext().getResources().getDisplayMetrics().widthPixels;
    float f1;
    if (paramTextView3 != null)
    {
      localPaint.setTextSize(paramTextView3.getTextSize());
      f1 = localPaint.measureText(paramTextView3.getText(), 0, paramTextView3.getText().length()) + AIOUtils.a(4.0F, paramTextView1.getContext().getResources());
      paramTextView3.getLayoutParams().width = ((int)f1);
      paramTextView3.setLayoutParams(paramTextView3.getLayoutParams());
      paramTextView3.setPadding(AIOUtils.a(2.0F, paramTextView1.getContext().getResources()), 0, AIOUtils.a(2.0F, paramTextView1.getContext().getResources()), 0);
    }
    for (;;)
    {
      float f2 = i - AIOUtils.a(89.0F, paramTextView1.getContext().getResources());
      if (f1 != 0.0F) {}
      for (f1 = f2 - (f1 + AIOUtils.a(6.0F, paramTextView1.getContext().getResources()));; f1 = f2)
      {
        localPaint.setTextSize(paramTextView1.getTextSize());
        if (localPaint.measureText(paramCharSequence, 0, paramCharSequence.length()) > f1)
        {
          paramTextView1.setMaxLines(2);
          paramTextView2.setMaxLines(1);
          return;
        }
        paramTextView1.setMaxLines(1);
        paramTextView2.setMaxLines(2);
        return;
      }
      f1 = 0.0F;
    }
  }
  
  private void a(TextView paramTextView, String paramString)
  {
    if ((paramString != null) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))))
    {
      paramString = URLDrawable.getDrawable(paramString);
      if ((paramString.getStatus() != 1) && (paramString.getStatus() != 0)) {
        paramString.restartDownload();
      }
      Resources localResources = paramTextView.getContext().getResources();
      paramString.setBounds(0, 0, AIOUtils.a(14.0F, localResources), AIOUtils.a(14.0F, localResources));
      paramTextView.setCompoundDrawablePadding(AIOUtils.a(4.0F, localResources));
      paramTextView.setCompoundDrawables(null, null, paramString, null);
      return;
    }
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
  }
  
  private void b()
  {
    try
    {
      ReportController.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "P_CliOper", "Grp_find", "", "grptab", "Clk_join", 0, 0, this.jdField_a_of_type_ComTencentMobileqqSearchModelGroupBaseNetSearchModelItem.jdField_b_of_type_JavaLangString, "", "", "");
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSearchAdapterGroupSearchAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchAdapterGroupSearchAdapter.notifyDataSetChanged();
    }
  }
  
  public void a(View paramView, CharSequence paramCharSequence, boolean paramBoolean)
  {
    a(paramView, paramCharSequence, paramBoolean, false);
  }
  
  public void a(View paramView, CharSequence paramCharSequence, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if (paramView != null)
    {
      if (TextUtils.isEmpty(paramCharSequence)) {
        break label32;
      }
      i = 1;
      if ((i == 0) || (paramView.getVisibility() == 0)) {
        break label38;
      }
      paramView.setVisibility(0);
    }
    label32:
    label38:
    do
    {
      do
      {
        return;
        i = 0;
        break;
      } while (i != 0);
      if ((paramBoolean1) && (!paramBoolean2) && (paramView.getVisibility() != 4))
      {
        paramView.setVisibility(4);
        return;
      }
    } while (paramView.getVisibility() == 8);
    paramView.setVisibility(8);
  }
  
  public void a(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    Object localObject = paramISearchResultView.b();
    if (localObject == null) {
      return;
    }
    for (;;)
    {
      GroupBaseNetSearchModelItem localGroupBaseNetSearchModelItem;
      ViewGroup.LayoutParams localLayoutParams;
      try
      {
        if ((!(paramISearchResultModel instanceof GroupBaseNetSearchModelItem)) || (!(paramISearchResultView instanceof SearchResultFromNetView))) {
          break label468;
        }
        localGroupBaseNetSearchModelItem = (GroupBaseNetSearchModelItem)paramISearchResultModel;
        SearchResultFromNetView localSearchResultFromNetView = (SearchResultFromNetView)paramISearchResultView;
        localLayoutParams = ((ImageView)localObject).getLayoutParams();
        if (this.jdField_a_of_type_Boolean)
        {
          localLayoutParams.height = AIOUtils.a(30.0F, ((ImageView)localObject).getContext().getResources());
          ((ImageView)localObject).setLayoutParams(localLayoutParams);
          if (localSearchResultFromNetView.c() != null) {
            localSearchResultFromNetView.c().setLayoutParams(localLayoutParams);
          }
          if ((localGroupBaseNetSearchModelItem.d() == 1001) || (localGroupBaseNetSearchModelItem.d() == 1002)) {
            break label459;
          }
          int i = paramISearchResultView.a().getResources().getDimensionPixelSize(2131297524);
          paramISearchResultModel = URLDrawable.URLDrawableOptions.obtain();
          paramISearchResultModel.mRequestWidth = i;
          paramISearchResultModel.mRequestHeight = i;
          if (localGroupBaseNetSearchModelItem.jdField_b_of_type_Boolean) {
            paramISearchResultModel.mMemoryCacheKeySuffix = "isAvatar";
          }
          if (this.jdField_a_of_type_Boolean)
          {
            localObject = new GradientDrawable();
            ((GradientDrawable)localObject).setColor(Color.parseColor("#ECEAE8"));
            ((GradientDrawable)localObject).setShape(1);
            paramISearchResultModel.mLoadingDrawable = ((Drawable)localObject);
            paramISearchResultModel.mFailedDrawable = ((Drawable)localObject);
          }
          paramISearchResultModel = URLDrawable.getDrawable(localGroupBaseNetSearchModelItem.c(), paramISearchResultModel);
          if (localGroupBaseNetSearchModelItem.jdField_b_of_type_Boolean) {
            paramISearchResultModel.setDecodeHandler(URLDrawableDecodeHandler.a);
          }
          if ((paramISearchResultModel.getStatus() != 1) && (paramISearchResultModel.getStatus() != 0)) {
            paramISearchResultModel.restartDownload();
          }
          paramISearchResultView.b().setImageDrawable(paramISearchResultModel);
          if ((paramISearchResultView.b() == null) || (localSearchResultFromNetView.c() == null)) {
            break;
          }
          a(paramISearchResultView.b(), localSearchResultFromNetView.c(), localGroupBaseNetSearchModelItem.jdField_b_of_type_Int);
          return;
        }
      }
      catch (Exception paramISearchResultModel)
      {
        QLog.e("Q.uniteSearch.ActiveEntitySearchResultPresenter", 1, "get face drawable error:" + paramISearchResultModel.toString());
        return;
      }
      if ((localGroupBaseNetSearchModelItem.d() == 8192) || (localGroupBaseNetSearchModelItem.d() == 16) || (localGroupBaseNetSearchModelItem.d() == 8))
      {
        localLayoutParams.height = AIOUtils.a(70.0F, ((ImageView)localObject).getContext().getResources());
      }
      else if (localGroupBaseNetSearchModelItem.d() == 1001)
      {
        localLayoutParams.height = AIOUtils.a(60.0F, ((ImageView)localObject).getContext().getResources());
      }
      else if ((localGroupBaseNetSearchModelItem.d() != 1024) && (localGroupBaseNetSearchModelItem.d() != 1002))
      {
        localLayoutParams.height = ((ImageView)localObject).getResources().getDimensionPixelSize(2131298474);
        continue;
        label459:
        super.a(paramISearchResultModel, paramISearchResultView);
      }
    }
    label468:
    super.a(paramISearchResultModel, paramISearchResultView);
  }
  
  public boolean a(int paramInt)
  {
    boolean bool = false;
    switch (paramInt)
    {
    default: 
      bool = true;
    }
    return bool;
  }
  
  public void b(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    if (!(paramISearchResultModel instanceof GroupBaseNetSearchModelItem))
    {
      QLog.e("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, "Model is not GroupBaseNetSearchModelItem type. m = " + paramISearchResultModel);
      throw new RuntimeException("Model is not GroupBaseNetSearchModelItem type. m = " + paramISearchResultModel);
    }
    GroupBaseNetSearchModelItem localGroupBaseNetSearchModelItem = (GroupBaseNetSearchModelItem)paramISearchResultModel;
    this.jdField_a_of_type_Int = localGroupBaseNetSearchModelItem.d();
    Object localObject1 = paramISearchResultView.a();
    Object localObject2 = paramISearchResultView.b();
    Object localObject3 = paramISearchResultView.c();
    Resources localResources = paramISearchResultView.a().getContext().getResources();
    if ((localObject3 != null) && (localGroupBaseNetSearchModelItem.jdField_c_of_type_Int != -1)) {
      ((TextView)localObject3).setTextColor(localResources.getColor(localGroupBaseNetSearchModelItem.jdField_c_of_type_Int));
    }
    int i;
    if ((paramISearchResultView instanceof SearchResultFromNetView))
    {
      paramISearchResultModel = (SearchResultFromNetView)paramISearchResultView;
      if (paramISearchResultModel.e() != null) {
        paramISearchResultModel.e().setVisibility(8);
      }
      if (localObject1 != null) {
        a((TextView)localObject1, localGroupBaseNetSearchModelItem.i);
      }
      if (localObject2 != null) {
        a((TextView)localObject2, localGroupBaseNetSearchModelItem.j);
      }
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        if (localObject3 != null) {
          ((TextView)localObject3).setMaxLines(1);
        }
        if (this.jdField_a_of_type_Int == 1002)
        {
          paramISearchResultModel = paramISearchResultView.a("ActiveEntitySearchResultPresenter_add_troop");
          localObject1 = (Pair)localGroupBaseNetSearchModelItem.a("ActiveEntitySearchResultPresenter_add_troop");
          if ((paramISearchResultModel != null) && (localObject1 != null))
          {
            paramISearchResultModel.setVisibility(0);
            if ((paramISearchResultModel instanceof TextView))
            {
              localObject2 = (TextView)paramISearchResultModel;
              ((TextView)localObject2).setText((CharSequence)((Pair)localObject1).first);
              ((TextView)localObject2).setEnabled(((Boolean)((Pair)localObject1).second).booleanValue());
              ((TextView)localObject2).setTextAppearance(((TextView)localObject2).getContext(), 2131755358);
              localObject3 = ((TextView)localObject2).getLayoutParams();
              if (!((Boolean)((Pair)localObject1).second).booleanValue()) {
                break label1316;
              }
              i = paramISearchResultModel.getContext().getResources().getDimensionPixelSize(2131296762);
              ((TextView)localObject2).setPadding(i, 0, i, 0);
              ((TextView)localObject2).setMinWidth(ScreenUtil.dip2px(60.0F));
              ((TextView)localObject2).setMinWidth(ScreenUtil.dip2px(29.0F));
              ((TextView)localObject2).setBackgroundResource(2130839458);
              if (localObject3 != null)
              {
                ((ViewGroup.LayoutParams)localObject3).height = -2;
                ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
              }
            }
          }
          label462:
          localObject2 = paramISearchResultView.a("ActiveEntitySearchResultPresenter_pay_troop");
          localObject1 = (Boolean)localGroupBaseNetSearchModelItem.a("ActiveEntitySearchResultPresenter_pay_troop");
          paramISearchResultModel = (ISearchResultModel)localObject1;
          if (localObject1 == null) {
            paramISearchResultModel = Boolean.valueOf(false);
          }
          if (localObject2 != null)
          {
            if (!paramISearchResultModel.booleanValue()) {
              break label1369;
            }
            i = 0;
            label513:
            ((View)localObject2).setVisibility(i);
          }
          localObject1 = paramISearchResultView.a("ActiveEntitySearchResultPresenter_hot_troop");
          paramISearchResultModel = (Integer)localGroupBaseNetSearchModelItem.a("ActiveEntitySearchResultPresenter_hot_troop");
          if (paramISearchResultModel != null) {
            break label1385;
          }
          paramISearchResultModel = Integer.valueOf(0);
        }
        break;
      }
    }
    label842:
    label1107:
    label1369:
    label1375:
    label1385:
    for (;;)
    {
      if ((localObject1 instanceof TroopActiveLayout))
      {
        if (paramISearchResultModel.intValue() <= 0) {
          break label1375;
        }
        ((View)localObject1).setVisibility(0);
        ((TroopActiveLayout)localObject1).setHotLevel(paramISearchResultModel.intValue());
      }
      for (;;)
      {
        paramISearchResultModel = paramISearchResultView.a("ActiveEntitySearchResultPresenter_expand_desc");
        localObject1 = localGroupBaseNetSearchModelItem.c();
        if (((paramISearchResultModel instanceof FolderTextView)) && (localObject1 != null)) {
          ((FolderTextView)paramISearchResultModel).setText(new QQText((CharSequence)localObject1, 11, 16));
        }
        super.b(localGroupBaseNetSearchModelItem, paramISearchResultView);
        a(paramISearchResultView.a(), localGroupBaseNetSearchModelItem.a(), true, false);
        a(paramISearchResultView.b(), localGroupBaseNetSearchModelItem.b(), false);
        a(paramISearchResultView.c(), localGroupBaseNetSearchModelItem.c(), false);
        a(paramISearchResultView.d(), localGroupBaseNetSearchModelItem.d(), false);
        if ((this.jdField_a_of_type_Int == 1001) && (TextUtils.isEmpty(localGroupBaseNetSearchModelItem.h)))
        {
          paramISearchResultModel = paramISearchResultView.b();
          paramISearchResultModel.setText(localGroupBaseNetSearchModelItem.b());
          PrettyAccountUtil.a(paramISearchResultModel, localGroupBaseNetSearchModelItem.f, localGroupBaseNetSearchModelItem.g, 2131167114, 17);
          PrettyAccountUtil.a("0X800B237", localGroupBaseNetSearchModelItem.f, localGroupBaseNetSearchModelItem.g);
        }
        return;
        if (paramISearchResultModel.b() != null) {
          paramISearchResultModel.b().a(localGroupBaseNetSearchModelItem.jdField_b_of_type_JavaUtilList, localGroupBaseNetSearchModelItem.e, localGroupBaseNetSearchModelItem.jdField_d_of_type_Int - 1, 1);
        }
        if (paramISearchResultModel.h() != null)
        {
          if (!TextUtils.isEmpty(localGroupBaseNetSearchModelItem.s)) {
            paramISearchResultModel.h().setText(localGroupBaseNetSearchModelItem.s);
          }
        }
        else if ((paramISearchResultModel.g() != null) && (paramISearchResultModel.f() != null))
        {
          localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
          if (!((FriendsManager)localObject1).b(localGroupBaseNetSearchModelItem.jdField_b_of_type_JavaLangString)) {
            break label1004;
          }
          localGroupBaseNetSearchModelItem.n = 2;
          label890:
          if (localGroupBaseNetSearchModelItem.n != 0) {
            break label1038;
          }
          if (RobotUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localGroupBaseNetSearchModelItem.jdField_b_of_type_JavaLangString)) {
            break label1026;
          }
          paramISearchResultModel.f().setVisibility(0);
          paramISearchResultModel.f().setText(HardCodeUtil.a(2131689557));
          paramISearchResultModel.g().setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          if ((paramISearchResultModel.b() == null) || (paramISearchResultModel.f() == null)) {
            break;
          }
          if (!RobotUtils.b((QQAppInterface)localObject1, localGroupBaseNetSearchModelItem.jdField_b_of_type_JavaLangString)) {
            break label1107;
          }
          paramISearchResultModel.b().setVisibility(0);
          break;
          paramISearchResultModel.h().setText("");
          break label842;
          label1004:
          if (!((FriendsManager)localObject1).d(localGroupBaseNetSearchModelItem.jdField_b_of_type_JavaLangString)) {
            break label890;
          }
          localGroupBaseNetSearchModelItem.n = 1;
          break label890;
          paramISearchResultModel.f().setVisibility(8);
          break label934;
          if (localGroupBaseNetSearchModelItem.n == 1)
          {
            paramISearchResultModel.f().setVisibility(8);
            paramISearchResultModel.g().setVisibility(0);
            paramISearchResultModel.g().setText(2131718554);
          }
          else
          {
            paramISearchResultModel.f().setVisibility(8);
            paramISearchResultModel.g().setVisibility(0);
            paramISearchResultModel.g().setText(2131690072);
          }
        }
        paramISearchResultModel.b().setVisibility(8);
        break;
        if (paramISearchResultModel.a() != null)
        {
          paramISearchResultModel.a().setVisibility(0);
          paramISearchResultModel.a().setLabelType(1);
          paramISearchResultModel.a().a(localGroupBaseNetSearchModelItem.a);
        }
        if (paramISearchResultModel.a != null)
        {
          if ((localGroupBaseNetSearchModelItem.jdField_b_of_type_Long & 0x800) == 0L) {
            break label1203;
          }
          paramISearchResultModel.a.setVisibility(0);
        }
        while (paramISearchResultModel.b != null)
        {
          paramISearchResultModel.b.setVisibility(8);
          break;
          paramISearchResultModel.a.setVisibility(8);
        }
        if (localObject1 == null) {
          break;
        }
        ((TextView)localObject1).setCompoundDrawablePadding(AIOUtils.a(4.0F, localResources));
        ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130841799, 0);
        break;
        a((TextView)localObject1, (TextView)localObject3, localGroupBaseNetSearchModelItem.a(), null);
        break;
        QLog.e("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, "View is not SearchResultFromNetView. View = " + paramISearchResultView);
        throw new RuntimeException("View is not SearchResultFromNetView. View = " + paramISearchResultView);
        ((TextView)localObject2).setPadding(0, 0, 0, 0);
        ((TextView)localObject2).setMinWidth(0);
        ((TextView)localObject2).setMinHeight(0);
        ((TextView)localObject2).setBackgroundDrawable(null);
        if (localObject3 == null) {
          break label462;
        }
        ((ViewGroup.LayoutParams)localObject3).height = ScreenUtil.dip2px(20.0F);
        ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        break label462;
        i = 8;
        break label513;
        ((View)localObject1).setVisibility(8);
      }
    }
  }
  
  protected void c(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    super.c(paramISearchResultModel, paramISearchResultView);
    if ((paramISearchResultModel instanceof GroupBaseNetSearchModelItem))
    {
      paramISearchResultModel = (GroupBaseNetSearchModelItem)paramISearchResultModel;
      if (paramISearchResultModel.d() != 1002) {
        break label56;
      }
      paramISearchResultView = paramISearchResultView.a("ActiveEntitySearchResultPresenter_add_troop");
      if (paramISearchResultView != null) {
        paramISearchResultView.setOnClickListener(new ActiveEntitySearchResultPresenter.3(this, paramISearchResultModel));
      }
    }
    label56:
    while ((paramISearchResultModel.d() != 1001) || (((SearchResultFromNetView)paramISearchResultView).f() == null)) {
      return;
    }
    ((SearchResultFromNetView)paramISearchResultView).f().setOnClickListener(new ActiveEntitySearchResultPresenter.4(this, paramISearchResultModel));
  }
  
  public void d(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    if (((paramISearchResultModel instanceof GroupBaseNetSearchModelItem)) && (!this.jdField_a_of_type_Boolean) && (a(((GroupBaseNetSearchModelItem)paramISearchResultModel).d()))) {
      SearchViewUtils.a(paramISearchResultModel.a(), paramISearchResultModel.b(), paramISearchResultView.a(), ((GroupBaseNetSearchModelItem)paramISearchResultModel).u);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.ActiveEntitySearchResultPresenter
 * JD-Core Version:    0.7.0.1
 */