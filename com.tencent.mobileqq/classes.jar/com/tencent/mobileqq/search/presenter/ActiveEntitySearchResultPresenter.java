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
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.adapter.GroupSearchAdapter;
import com.tencent.mobileqq.search.base.presenter.SearchResultPresenter;
import com.tencent.mobileqq.search.base.util.SearchViewUtils;
import com.tencent.mobileqq.search.base.view.ISearchResultView;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.view.SearchResultFromNetView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.activity.JoinTroopUtil;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.mobileqq.troop.utils.TroopNotifyHelper.OnTroopSafeDialogClickConfirm;
import com.tencent.mobileqq.troop.widget.TroopActiveLayout;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.vas.util.PrettyAccountUtil;
import com.tencent.mobileqq.widget.FolderTextView;
import com.tencent.qphone.base.util.QLog;

public class ActiveEntitySearchResultPresenter
  extends SearchResultPresenter
{
  int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private GroupSearchAdapter jdField_a_of_type_ComTencentMobileqqSearchAdapterGroupSearchAdapter;
  private GroupBaseNetSearchModelItem jdField_a_of_type_ComTencentMobileqqSearchModelGroupBaseNetSearchModelItem;
  private TroopMngObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver = new ActiveEntitySearchResultPresenter.1(this);
  private TroopNotifyHelper.OnTroopSafeDialogClickConfirm jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNotifyHelper$OnTroopSafeDialogClickConfirm = new ActiveEntitySearchResultPresenter.2(this);
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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("joinTroop, ctx = ");
      ((StringBuilder)localObject).append(paramContext);
      ((StringBuilder)localObject).append(", model = ");
      ((StringBuilder)localObject).append(paramGroupBaseNetSearchModelItem);
      QLog.d("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramContext != null) && (paramGroupBaseNetSearchModelItem != null))
    {
      if ((paramContext instanceof Activity))
      {
        localObject = (Activity)paramContext;
        if (((Activity)localObject).isFinishing()) {
          return;
        }
        localObject = ((Activity)localObject).getIntent();
        if (localObject != null)
        {
          k = ((Intent)localObject).getIntExtra("from_type_for_report", 0);
          break label117;
        }
      }
      int k = 0;
      label117:
      int j;
      if (k == 9) {
        j = 112;
      } else {
        j = 103;
      }
      if ((paramContext instanceof ActiveEntitySearchActivity))
      {
        localObject = ((Activity)paramContext).getIntent().getLongArrayExtra("group_mask_long_array");
        int i = j;
        if (localObject != null)
        {
          i = j;
          if (localObject.length == 1)
          {
            i = j;
            if (localObject[0] == 1002L) {
              if (k == 9) {
                i = 113;
              } else {
                i = 104;
              }
            }
          }
        }
        if ((i != 103) && (i != 104))
        {
          if ((i == 112) || (i == 113)) {
            if (paramGroupBaseNetSearchModelItem.jdField_d_of_type_Boolean) {
              i = 30017;
            } else {
              i = 30019;
            }
          }
        }
        else if (paramGroupBaseNetSearchModelItem.jdField_d_of_type_Boolean) {
          i = 30013;
        } else {
          i = 30015;
        }
        JoinTroopUtil.a(paramContext, paramGroupBaseNetSearchModelItem.jdField_b_of_type_JavaLangString, paramGroupBaseNetSearchModelItem.jdField_c_of_type_JavaLangString, i, "", paramGroupBaseNetSearchModelItem.q, false, new ActiveEntitySearchResultPresenter.5(this, paramGroupBaseNetSearchModelItem));
        return;
      }
      return;
    }
  }
  
  public static void a(ImageView paramImageView1, ImageView paramImageView2, int paramInt)
  {
    Drawable localDrawable;
    if (paramInt == 1)
    {
      localDrawable = paramImageView2.getResources().getDrawable(2130842421);
      paramImageView1.setColorFilter(-1610612736, PorterDuff.Mode.SRC_OVER);
      paramImageView2.setImageDrawable(localDrawable);
      paramImageView2.setScaleType(ImageView.ScaleType.CENTER);
      paramImageView2.setVisibility(0);
      return;
    }
    if (paramInt == 2)
    {
      localDrawable = paramImageView2.getResources().getDrawable(2130842450);
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
    if ((paramTextView1 != null) && (paramTextView2 != null))
    {
      if (paramCharSequence == null) {
        return;
      }
      int i = paramTextView1.getContext().getResources().getDisplayMetrics().widthPixels;
      float f1;
      if (paramTextView3 != null)
      {
        localPaint.setTextSize(paramTextView3.getTextSize());
        f1 = localPaint.measureText(paramTextView3.getText(), 0, paramTextView3.getText().length()) + AIOUtils.b(4.0F, paramTextView1.getContext().getResources());
        paramTextView3.getLayoutParams().width = ((int)f1);
        paramTextView3.setLayoutParams(paramTextView3.getLayoutParams());
        paramTextView3.setPadding(AIOUtils.b(2.0F, paramTextView1.getContext().getResources()), 0, AIOUtils.b(2.0F, paramTextView1.getContext().getResources()), 0);
      }
      else
      {
        f1 = 0.0F;
      }
      float f3 = i - AIOUtils.b(89.0F, paramTextView1.getContext().getResources());
      float f2 = f3;
      if (f1 != 0.0F) {
        f2 = f3 - (f1 + AIOUtils.b(6.0F, paramTextView1.getContext().getResources()));
      }
      localPaint.setTextSize(paramTextView1.getTextSize());
      if (localPaint.measureText(paramCharSequence, 0, paramCharSequence.length()) > f2)
      {
        paramTextView1.setMaxLines(2);
        paramTextView2.setMaxLines(1);
        return;
      }
      paramTextView1.setMaxLines(1);
      paramTextView2.setMaxLines(2);
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
      paramString.setBounds(0, 0, AIOUtils.b(14.0F, localResources), AIOUtils.b(14.0F, localResources));
      paramTextView.setCompoundDrawablePadding(AIOUtils.b(4.0F, localResources));
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
    GroupSearchAdapter localGroupSearchAdapter = this.jdField_a_of_type_ComTencentMobileqqSearchAdapterGroupSearchAdapter;
    if (localGroupSearchAdapter != null) {
      localGroupSearchAdapter.notifyDataSetChanged();
    }
  }
  
  public void a(View paramView, CharSequence paramCharSequence, boolean paramBoolean)
  {
    a(paramView, paramCharSequence, paramBoolean, false);
  }
  
  public void a(View paramView, CharSequence paramCharSequence, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramView != null)
    {
      boolean bool = TextUtils.isEmpty(paramCharSequence) ^ true;
      if ((bool) && (paramView.getVisibility() != 0))
      {
        paramView.setVisibility(0);
        return;
      }
      if (!bool)
      {
        if ((paramBoolean1) && (!paramBoolean2) && (paramView.getVisibility() != 4))
        {
          paramView.setVisibility(4);
          return;
        }
        if (paramView.getVisibility() != 8) {
          paramView.setVisibility(8);
        }
      }
    }
  }
  
  public void a(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    if ((paramISearchResultModel instanceof GroupBaseNetSearchModelItem))
    {
      GroupBaseNetSearchModelItem localGroupBaseNetSearchModelItem = (GroupBaseNetSearchModelItem)paramISearchResultModel;
      this.jdField_a_of_type_Int = localGroupBaseNetSearchModelItem.d();
      Object localObject1 = paramISearchResultView.a();
      Object localObject2 = paramISearchResultView.b();
      Object localObject3 = paramISearchResultView.c();
      Resources localResources = paramISearchResultView.a().getContext().getResources();
      if ((localObject3 != null) && (localGroupBaseNetSearchModelItem.jdField_c_of_type_Int != -1)) {
        ((TextView)localObject3).setTextColor(localResources.getColor(localGroupBaseNetSearchModelItem.jdField_c_of_type_Int));
      }
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
        int i = this.jdField_a_of_type_Int;
        if (i != 1073745984) {
          switch (i)
          {
          default: 
            if (localObject3 == null) {
              break;
            }
            ((TextView)localObject3).setMaxLines(1);
            break;
          case 1003: 
            if (localObject1 == null) {
              break;
            }
            ((TextView)localObject1).setCompoundDrawablePadding(AIOUtils.b(4.0F, localResources));
            ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130841685, 0);
            break;
          case 1002: 
            if (paramISearchResultModel.a() != null)
            {
              paramISearchResultModel.a().setVisibility(0);
              paramISearchResultModel.a().setLabelType(1);
              paramISearchResultModel.a().a(localGroupBaseNetSearchModelItem.a);
            }
            if (paramISearchResultModel.c != null) {
              if ((localGroupBaseNetSearchModelItem.jdField_b_of_type_Long & 0x800) != 0L) {
                paramISearchResultModel.c.setVisibility(0);
              } else {
                paramISearchResultModel.c.setVisibility(8);
              }
            }
            if (paramISearchResultModel.d == null) {
              break;
            }
            paramISearchResultModel.d.setVisibility(8);
            break;
          case 1001: 
            if (paramISearchResultModel.b() != null) {
              paramISearchResultModel.b().a(localGroupBaseNetSearchModelItem.jdField_b_of_type_JavaUtilList, localGroupBaseNetSearchModelItem.e, localGroupBaseNetSearchModelItem.jdField_d_of_type_Int - 1, 1);
            }
            if (paramISearchResultModel.h() != null) {
              if (!TextUtils.isEmpty(localGroupBaseNetSearchModelItem.s)) {
                paramISearchResultModel.h().setText(localGroupBaseNetSearchModelItem.s);
              } else {
                paramISearchResultModel.h().setText("");
              }
            }
            if ((paramISearchResultModel.g() != null) && (paramISearchResultModel.f() != null))
            {
              localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
              if (((FriendsManager)localObject1).b(localGroupBaseNetSearchModelItem.jdField_b_of_type_JavaLangString)) {
                localGroupBaseNetSearchModelItem.n = 2;
              } else if (((FriendsManager)localObject1).d(localGroupBaseNetSearchModelItem.jdField_b_of_type_JavaLangString)) {
                localGroupBaseNetSearchModelItem.n = 1;
              }
              if (localGroupBaseNetSearchModelItem.n == 0)
              {
                if (!RobotUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localGroupBaseNetSearchModelItem.jdField_b_of_type_JavaLangString))
                {
                  paramISearchResultModel.f().setVisibility(0);
                  paramISearchResultModel.f().setText(HardCodeUtil.a(2131689589));
                }
                else
                {
                  paramISearchResultModel.f().setVisibility(8);
                }
                paramISearchResultModel.g().setVisibility(8);
              }
              else if (localGroupBaseNetSearchModelItem.n == 1)
              {
                paramISearchResultModel.f().setVisibility(8);
                paramISearchResultModel.g().setVisibility(0);
                paramISearchResultModel.g().setText(2131718222);
              }
              else
              {
                paramISearchResultModel.f().setVisibility(8);
                paramISearchResultModel.g().setVisibility(0);
                paramISearchResultModel.g().setText(2131689988);
              }
            }
            localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            if ((paramISearchResultModel.b() == null) || (paramISearchResultModel.f() == null)) {
              break;
            }
            if (RobotUtils.a((QQAppInterface)localObject1, localGroupBaseNetSearchModelItem.jdField_b_of_type_JavaLangString)) {
              paramISearchResultModel.b().setVisibility(0);
            } else {
              paramISearchResultModel.b().setVisibility(8);
            }
            break;
          }
        } else {
          a((TextView)localObject1, (TextView)localObject3, localGroupBaseNetSearchModelItem.b(), null);
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
              ((TextView)localObject2).setTextAppearance(((TextView)localObject2).getContext(), 2131755552);
              localObject3 = ((TextView)localObject2).getLayoutParams();
              if (((Boolean)((Pair)localObject1).second).booleanValue())
              {
                i = paramISearchResultModel.getContext().getResources().getDimensionPixelSize(2131296742);
                ((TextView)localObject2).setPadding(i, 0, i, 0);
                ((TextView)localObject2).setMinWidth(ScreenUtil.dip2px(60.0F));
                ((TextView)localObject2).setMinWidth(ScreenUtil.dip2px(29.0F));
                ((TextView)localObject2).setBackgroundResource(2130839314);
                if (localObject3 != null)
                {
                  ((ViewGroup.LayoutParams)localObject3).height = -2;
                  ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
                }
              }
              else
              {
                ((TextView)localObject2).setPadding(0, 0, 0, 0);
                ((TextView)localObject2).setMinWidth(0);
                ((TextView)localObject2).setMinHeight(0);
                ((TextView)localObject2).setBackgroundDrawable(null);
                if (localObject3 != null)
                {
                  ((ViewGroup.LayoutParams)localObject3).height = ScreenUtil.dip2px(20.0F);
                  ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
                }
              }
            }
          }
          localObject2 = paramISearchResultView.a("ActiveEntitySearchResultPresenter_pay_troop");
          localObject1 = (Boolean)localGroupBaseNetSearchModelItem.a("ActiveEntitySearchResultPresenter_pay_troop");
          paramISearchResultModel = (ISearchResultModel)localObject1;
          if (localObject1 == null) {
            paramISearchResultModel = Boolean.valueOf(false);
          }
          if (localObject2 != null)
          {
            if (paramISearchResultModel.booleanValue()) {
              i = 0;
            } else {
              i = 8;
            }
            ((View)localObject2).setVisibility(i);
          }
          localObject2 = paramISearchResultView.a("ActiveEntitySearchResultPresenter_hot_troop");
          localObject1 = (Integer)localGroupBaseNetSearchModelItem.a("ActiveEntitySearchResultPresenter_hot_troop");
          paramISearchResultModel = (ISearchResultModel)localObject1;
          if (localObject1 == null) {
            paramISearchResultModel = Integer.valueOf(0);
          }
          if ((localObject2 instanceof TroopActiveLayout)) {
            if (paramISearchResultModel.intValue() > 0)
            {
              ((View)localObject2).setVisibility(0);
              ((TroopActiveLayout)localObject2).setHotLevel(paramISearchResultModel.intValue());
            }
            else
            {
              ((View)localObject2).setVisibility(8);
            }
          }
          paramISearchResultModel = paramISearchResultView.a("ActiveEntitySearchResultPresenter_expand_desc");
          localObject1 = localGroupBaseNetSearchModelItem.a();
          if (((paramISearchResultModel instanceof FolderTextView)) && (localObject1 != null)) {
            ((FolderTextView)paramISearchResultModel).setText(new QQText((CharSequence)localObject1, 11, 16));
          }
        }
        super.a(localGroupBaseNetSearchModelItem, paramISearchResultView);
        a(paramISearchResultView.a(), localGroupBaseNetSearchModelItem.b(), true, false);
        a(paramISearchResultView.b(), localGroupBaseNetSearchModelItem.c(), false);
        a(paramISearchResultView.c(), localGroupBaseNetSearchModelItem.a(), false);
        a(paramISearchResultView.d(), localGroupBaseNetSearchModelItem.d(), false);
        if ((this.jdField_a_of_type_Int == 1001) && (TextUtils.isEmpty(localGroupBaseNetSearchModelItem.h)))
        {
          paramISearchResultModel = paramISearchResultView.b();
          paramISearchResultModel.setText(localGroupBaseNetSearchModelItem.c());
          PrettyAccountUtil.a(paramISearchResultModel, localGroupBaseNetSearchModelItem.f, localGroupBaseNetSearchModelItem.g, 2131167139, 17);
          PrettyAccountUtil.a("0X800B237", localGroupBaseNetSearchModelItem.f, localGroupBaseNetSearchModelItem.g);
        }
        return;
      }
      paramISearchResultModel = new StringBuilder();
      paramISearchResultModel.append("View is not SearchResultFromNetView. View = ");
      paramISearchResultModel.append(paramISearchResultView);
      QLog.e("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, paramISearchResultModel.toString());
      paramISearchResultModel = new StringBuilder();
      paramISearchResultModel.append("View is not SearchResultFromNetView. View = ");
      paramISearchResultModel.append(paramISearchResultView);
      throw new RuntimeException(paramISearchResultModel.toString());
    }
    paramISearchResultView = new StringBuilder();
    paramISearchResultView.append("Model is not GroupBaseNetSearchModelItem type. m = ");
    paramISearchResultView.append(paramISearchResultModel);
    QLog.e("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, paramISearchResultView.toString());
    paramISearchResultView = new StringBuilder();
    paramISearchResultView.append("Model is not GroupBaseNetSearchModelItem type. m = ");
    paramISearchResultView.append(paramISearchResultModel);
    throw new RuntimeException(paramISearchResultView.toString());
  }
  
  public boolean a(int paramInt)
  {
    return (paramInt != 1001) && (paramInt != 1002);
  }
  
  public void b(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    Object localObject = paramISearchResultView.b();
    if (localObject == null) {
      return;
    }
    try
    {
      if (((paramISearchResultModel instanceof GroupBaseNetSearchModelItem)) && ((paramISearchResultView instanceof SearchResultFromNetView)))
      {
        GroupBaseNetSearchModelItem localGroupBaseNetSearchModelItem = (GroupBaseNetSearchModelItem)paramISearchResultModel;
        SearchResultFromNetView localSearchResultFromNetView = (SearchResultFromNetView)paramISearchResultView;
        ViewGroup.LayoutParams localLayoutParams = ((ImageView)localObject).getLayoutParams();
        if (this.jdField_a_of_type_Boolean) {
          localLayoutParams.height = AIOUtils.b(30.0F, ((ImageView)localObject).getContext().getResources());
        } else if ((localGroupBaseNetSearchModelItem.d() != 8192) && (localGroupBaseNetSearchModelItem.d() != 16) && (localGroupBaseNetSearchModelItem.d() != 8))
        {
          if (localGroupBaseNetSearchModelItem.d() == 1001) {
            localLayoutParams.height = AIOUtils.b(60.0F, ((ImageView)localObject).getContext().getResources());
          } else if ((localGroupBaseNetSearchModelItem.d() != 1024) && (localGroupBaseNetSearchModelItem.d() != 1002)) {
            localLayoutParams.height = ((ImageView)localObject).getResources().getDimensionPixelSize(2131298469);
          }
        }
        else {
          localLayoutParams.height = AIOUtils.b(70.0F, ((ImageView)localObject).getContext().getResources());
        }
        ((ImageView)localObject).setLayoutParams(localLayoutParams);
        if (localSearchResultFromNetView.c() != null) {
          localSearchResultFromNetView.c().setLayoutParams(localLayoutParams);
        }
        if ((localGroupBaseNetSearchModelItem.d() != 1001) && (localGroupBaseNetSearchModelItem.d() != 1002))
        {
          int i = paramISearchResultView.a().getResources().getDimensionPixelSize(2131297515);
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
        }
        else
        {
          super.b(paramISearchResultModel, paramISearchResultView);
        }
        if ((paramISearchResultView.b() != null) && (localSearchResultFromNetView.c() != null)) {
          a(paramISearchResultView.b(), localSearchResultFromNetView.c(), localGroupBaseNetSearchModelItem.jdField_b_of_type_Int);
        }
      }
      else
      {
        super.b(paramISearchResultModel, paramISearchResultView);
        return;
      }
    }
    catch (Exception paramISearchResultModel)
    {
      paramISearchResultView = new StringBuilder();
      paramISearchResultView.append("get face drawable error:");
      paramISearchResultView.append(paramISearchResultModel.toString());
      QLog.e("Q.uniteSearch.ActiveEntitySearchResultPresenter", 1, paramISearchResultView.toString());
    }
  }
  
  protected void c(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    super.c(paramISearchResultModel, paramISearchResultView);
    if ((paramISearchResultModel instanceof GroupBaseNetSearchModelItem))
    {
      paramISearchResultModel = (GroupBaseNetSearchModelItem)paramISearchResultModel;
      if (paramISearchResultModel.d() == 1002)
      {
        paramISearchResultView = paramISearchResultView.a("ActiveEntitySearchResultPresenter_add_troop");
        if (paramISearchResultView != null) {
          paramISearchResultView.setOnClickListener(new ActiveEntitySearchResultPresenter.3(this, paramISearchResultModel));
        }
      }
      else if (paramISearchResultModel.d() == 1001)
      {
        paramISearchResultView = (SearchResultFromNetView)paramISearchResultView;
        if (paramISearchResultView.f() != null) {
          paramISearchResultView.f().setOnClickListener(new ActiveEntitySearchResultPresenter.4(this, paramISearchResultModel));
        }
      }
    }
  }
  
  public void d(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    if (((paramISearchResultModel instanceof GroupBaseNetSearchModelItem)) && (!this.jdField_a_of_type_Boolean))
    {
      GroupBaseNetSearchModelItem localGroupBaseNetSearchModelItem = (GroupBaseNetSearchModelItem)paramISearchResultModel;
      if (a(localGroupBaseNetSearchModelItem.d())) {
        SearchViewUtils.a(paramISearchResultModel.b(), paramISearchResultModel.f_(), paramISearchResultView.a(), localGroupBaseNetSearchModelItem.u);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.ActiveEntitySearchResultPresenter
 * JD-Core Version:    0.7.0.1
 */