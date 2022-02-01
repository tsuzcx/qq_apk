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
  int a;
  boolean b = false;
  private GroupSearchAdapter c;
  private QQAppInterface d;
  private View e;
  private GroupBaseNetSearchModelItem f;
  private TroopMngObserver g = new ActiveEntitySearchResultPresenter.1(this);
  private TroopNotifyHelper.OnTroopSafeDialogClickConfirm h = new ActiveEntitySearchResultPresenter.2(this);
  
  public ActiveEntitySearchResultPresenter(IFaceDecoder paramIFaceDecoder, int paramInt)
  {
    super(paramIFaceDecoder);
    this.a = paramInt;
    this.d = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  public ActiveEntitySearchResultPresenter(IFaceDecoder paramIFaceDecoder, int paramInt, GroupSearchAdapter paramGroupSearchAdapter)
  {
    super(paramIFaceDecoder);
    this.a = paramInt;
    this.c = paramGroupSearchAdapter;
    this.d = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
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
            if (paramGroupBaseNetSearchModelItem.I) {
              i = 30017;
            } else {
              i = 30019;
            }
          }
        }
        else if (paramGroupBaseNetSearchModelItem.I) {
          i = 30013;
        } else {
          i = 30015;
        }
        JoinTroopUtil.a(paramContext, paramGroupBaseNetSearchModelItem.b, paramGroupBaseNetSearchModelItem.c, i, "", paramGroupBaseNetSearchModelItem.T, false, new ActiveEntitySearchResultPresenter.6(this, paramGroupBaseNetSearchModelItem));
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
      localDrawable = paramImageView2.getResources().getDrawable(2130843374);
      paramImageView1.setColorFilter(-1610612736, PorterDuff.Mode.SRC_OVER);
      paramImageView2.setImageDrawable(localDrawable);
      paramImageView2.setScaleType(ImageView.ScaleType.CENTER);
      paramImageView2.setVisibility(0);
      return;
    }
    if (paramInt == 2)
    {
      localDrawable = paramImageView2.getResources().getDrawable(2130843403);
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
      ReportController.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "P_CliOper", "Grp_find", "", "grptab", "Clk_join", 0, 0, this.f.b, "", "", "");
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void a()
  {
    GroupSearchAdapter localGroupSearchAdapter = this.c;
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
      this.a = localGroupBaseNetSearchModelItem.j();
      Object localObject1 = paramISearchResultView.b();
      Object localObject2 = paramISearchResultView.c();
      Object localObject3 = paramISearchResultView.d();
      Resources localResources = paramISearchResultView.h().getContext().getResources();
      if ((localObject3 != null) && (localGroupBaseNetSearchModelItem.q != -1)) {
        ((TextView)localObject3).setTextColor(localResources.getColor(localGroupBaseNetSearchModelItem.q));
      }
      if ((paramISearchResultView instanceof SearchResultFromNetView))
      {
        paramISearchResultModel = (SearchResultFromNetView)paramISearchResultView;
        if (paramISearchResultModel.l() != null) {
          paramISearchResultModel.l().setVisibility(8);
        }
        if (localObject1 != null) {
          a((TextView)localObject1, localGroupBaseNetSearchModelItem.w);
        }
        if (localObject2 != null) {
          a((TextView)localObject2, localGroupBaseNetSearchModelItem.x);
        }
        int i = this.a;
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
            ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130842600, 0);
            break;
          case 1002: 
            if (paramISearchResultModel.k() != null)
            {
              paramISearchResultModel.k().setVisibility(0);
              paramISearchResultModel.k().setLabelType(1);
              paramISearchResultModel.k().a(localGroupBaseNetSearchModelItem.z);
            }
            if (paramISearchResultModel.b != null) {
              if ((localGroupBaseNetSearchModelItem.v & 0x800) != 0L) {
                paramISearchResultModel.b.setVisibility(0);
              } else {
                paramISearchResultModel.b.setVisibility(8);
              }
            }
            if (paramISearchResultModel.c == null) {
              break;
            }
            paramISearchResultModel.c.setVisibility(8);
            break;
          case 1001: 
            if (paramISearchResultModel.o() != null) {
              paramISearchResultModel.o().a(localGroupBaseNetSearchModelItem.V, localGroupBaseNetSearchModelItem.s, localGroupBaseNetSearchModelItem.r - 1, 1);
            }
            if (paramISearchResultModel.q() != null) {
              if (!TextUtils.isEmpty(localGroupBaseNetSearchModelItem.W)) {
                paramISearchResultModel.q().setText(localGroupBaseNetSearchModelItem.W);
              } else {
                paramISearchResultModel.q().setText("");
              }
            }
            if ((paramISearchResultModel.p() != null) && (paramISearchResultModel.n() != null))
            {
              localObject1 = (FriendsManager)this.d.getManager(QQManagerFactory.FRIENDS_MANAGER);
              if (((FriendsManager)localObject1).n(localGroupBaseNetSearchModelItem.b)) {
                localGroupBaseNetSearchModelItem.X = 2;
              } else if (((FriendsManager)localObject1).v(localGroupBaseNetSearchModelItem.b)) {
                localGroupBaseNetSearchModelItem.X = 1;
              }
              if (localGroupBaseNetSearchModelItem.X == 0)
              {
                if (!RobotUtils.a(this.d, localGroupBaseNetSearchModelItem.b))
                {
                  paramISearchResultModel.n().setVisibility(0);
                  paramISearchResultModel.n().setText(HardCodeUtil.a(2131886199));
                }
                else
                {
                  paramISearchResultModel.n().setVisibility(8);
                }
                paramISearchResultModel.p().setVisibility(8);
              }
              else if (localGroupBaseNetSearchModelItem.X == 1)
              {
                paramISearchResultModel.n().setVisibility(8);
                paramISearchResultModel.p().setVisibility(0);
                paramISearchResultModel.p().setText(2131915704);
              }
              else
              {
                paramISearchResultModel.n().setVisibility(8);
                paramISearchResultModel.p().setVisibility(0);
                paramISearchResultModel.p().setText(2131886630);
              }
            }
            localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            if ((paramISearchResultModel.m() == null) || (paramISearchResultModel.n() == null)) {
              break;
            }
            if (RobotUtils.a((QQAppInterface)localObject1, localGroupBaseNetSearchModelItem.b)) {
              paramISearchResultModel.m().setVisibility(0);
            } else {
              paramISearchResultModel.m().setVisibility(8);
            }
            break;
          }
        } else {
          a((TextView)localObject1, (TextView)localObject3, localGroupBaseNetSearchModelItem.d(), null);
        }
        i = this.a;
        if (i == 1002)
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
              ((TextView)localObject2).setTextAppearance(((TextView)localObject2).getContext(), 2131952365);
              localObject3 = ((TextView)localObject2).getLayoutParams();
              if (((Boolean)((Pair)localObject1).second).booleanValue())
              {
                i = paramISearchResultModel.getContext().getResources().getDimensionPixelSize(2131297073);
                ((TextView)localObject2).setPadding(i, 0, i, 0);
                ((TextView)localObject2).setMinWidth(ScreenUtil.dip2px(60.0F));
                ((TextView)localObject2).setMinWidth(ScreenUtil.dip2px(29.0F));
                ((TextView)localObject2).setBackgroundResource(2130839494);
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
        else if (i == 1107)
        {
          localObject1 = paramISearchResultView.a("ActiveEntitySearchResultPresenter_add_troop");
          paramISearchResultModel = (Pair)localGroupBaseNetSearchModelItem.a("ActiveEntitySearchResultPresenter_add_troop");
          if ((localObject1 != null) && (paramISearchResultModel != null))
          {
            ((View)localObject1).setVisibility(0);
            if ((localObject1 instanceof TextView))
            {
              localObject1 = (TextView)localObject1;
              ((TextView)localObject1).setText((CharSequence)paramISearchResultModel.first);
              ((TextView)localObject1).setEnabled(((Boolean)paramISearchResultModel.second).booleanValue());
            }
          }
        }
        super.a(localGroupBaseNetSearchModelItem, paramISearchResultView);
        a(paramISearchResultView.b(), localGroupBaseNetSearchModelItem.d(), true, false);
        a(paramISearchResultView.c(), localGroupBaseNetSearchModelItem.e(), false);
        a(paramISearchResultView.d(), localGroupBaseNetSearchModelItem.a(), false);
        a(paramISearchResultView.e(), localGroupBaseNetSearchModelItem.f(), false);
        if ((this.a == 1001) && (TextUtils.isEmpty(localGroupBaseNetSearchModelItem.n)))
        {
          paramISearchResultModel = paramISearchResultView.c();
          paramISearchResultModel.setText(localGroupBaseNetSearchModelItem.e());
          PrettyAccountUtil.a(paramISearchResultModel, localGroupBaseNetSearchModelItem.t, localGroupBaseNetSearchModelItem.u, 2131168119, 17);
          PrettyAccountUtil.a("0X800B237", localGroupBaseNetSearchModelItem.t, localGroupBaseNetSearchModelItem.u);
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
    Object localObject = paramISearchResultView.g();
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
        if (this.b) {
          localLayoutParams.height = AIOUtils.b(30.0F, ((ImageView)localObject).getContext().getResources());
        } else if ((localGroupBaseNetSearchModelItem.j() != 8192) && (localGroupBaseNetSearchModelItem.j() != 16) && (localGroupBaseNetSearchModelItem.j() != 8))
        {
          if (localGroupBaseNetSearchModelItem.j() == 1001) {
            localLayoutParams.height = AIOUtils.b(60.0F, ((ImageView)localObject).getContext().getResources());
          } else if ((localGroupBaseNetSearchModelItem.j() != 1024) && (localGroupBaseNetSearchModelItem.j() != 1002) && (localGroupBaseNetSearchModelItem.j() != 1107)) {
            localLayoutParams.height = ((ImageView)localObject).getResources().getDimensionPixelSize(2131299183);
          }
        }
        else {
          localLayoutParams.height = AIOUtils.b(70.0F, ((ImageView)localObject).getContext().getResources());
        }
        ((ImageView)localObject).setLayoutParams(localLayoutParams);
        if (localSearchResultFromNetView.j() != null) {
          localSearchResultFromNetView.j().setLayoutParams(localLayoutParams);
        }
        if ((localGroupBaseNetSearchModelItem.j() != 1001) && (localGroupBaseNetSearchModelItem.j() != 1002))
        {
          int i = paramISearchResultView.h().getResources().getDimensionPixelSize(2131298168);
          paramISearchResultModel = URLDrawable.URLDrawableOptions.obtain();
          paramISearchResultModel.mRequestWidth = i;
          paramISearchResultModel.mRequestHeight = i;
          if (localGroupBaseNetSearchModelItem.o) {
            paramISearchResultModel.mMemoryCacheKeySuffix = "isAvatar";
          }
          if (this.b)
          {
            localObject = new GradientDrawable();
            ((GradientDrawable)localObject).setColor(Color.parseColor("#ECEAE8"));
            ((GradientDrawable)localObject).setShape(1);
            paramISearchResultModel.mLoadingDrawable = ((Drawable)localObject);
            paramISearchResultModel.mFailedDrawable = ((Drawable)localObject);
          }
          paramISearchResultModel = URLDrawable.getDrawable(localGroupBaseNetSearchModelItem.i(), paramISearchResultModel);
          if (localGroupBaseNetSearchModelItem.o) {
            paramISearchResultModel.setDecodeHandler(URLDrawableDecodeHandler.b);
          }
          if ((paramISearchResultModel.getStatus() != 1) && (paramISearchResultModel.getStatus() != 0)) {
            paramISearchResultModel.restartDownload();
          }
          paramISearchResultView.g().setImageDrawable(paramISearchResultModel);
        }
        else
        {
          super.b(paramISearchResultModel, paramISearchResultView);
        }
        if ((paramISearchResultView.g() != null) && (localSearchResultFromNetView.j() != null)) {
          a(paramISearchResultView.g(), localSearchResultFromNetView.j(), localGroupBaseNetSearchModelItem.p);
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
      if (paramISearchResultModel.j() == 1002)
      {
        paramISearchResultView = paramISearchResultView.a("ActiveEntitySearchResultPresenter_add_troop");
        if (paramISearchResultView != null) {
          paramISearchResultView.setOnClickListener(new ActiveEntitySearchResultPresenter.3(this, paramISearchResultModel));
        }
      }
      else if (paramISearchResultModel.j() == 1001)
      {
        paramISearchResultView = (SearchResultFromNetView)paramISearchResultView;
        if (paramISearchResultView.n() != null) {
          paramISearchResultView.n().setOnClickListener(new ActiveEntitySearchResultPresenter.4(this, paramISearchResultModel));
        }
      }
      else if (paramISearchResultModel.j() == 1107)
      {
        paramISearchResultView = paramISearchResultView.a("ActiveEntitySearchResultPresenter_add_troop");
        if (paramISearchResultView != null) {
          paramISearchResultView.setOnClickListener(new ActiveEntitySearchResultPresenter.5(this, paramISearchResultModel));
        }
      }
    }
  }
  
  public void d(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    if (((paramISearchResultModel instanceof GroupBaseNetSearchModelItem)) && (!this.b))
    {
      GroupBaseNetSearchModelItem localGroupBaseNetSearchModelItem = (GroupBaseNetSearchModelItem)paramISearchResultModel;
      if (a(localGroupBaseNetSearchModelItem.j())) {
        SearchViewUtils.a(paramISearchResultModel.ck_(), paramISearchResultModel.cl_(), paramISearchResultView.h(), localGroupBaseNetSearchModelItem.af);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.ActiveEntitySearchResultPresenter
 * JD-Core Version:    0.7.0.1
 */