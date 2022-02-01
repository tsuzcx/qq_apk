package com.tencent.mobileqq.search.presenter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.avbiz.IModule;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig.SimpleMiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppLocalSearchEntity;
import com.tencent.mobileqq.music.QQPlayerCallback;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.activity.PublicAcntSearchActivity;
import com.tencent.mobileqq.search.adapter.GroupSearchAdapter;
import com.tencent.mobileqq.search.adapter.SearchTemplateHorSlidingDataAdapter;
import com.tencent.mobileqq.search.base.presenter.IFacePresenter;
import com.tencent.mobileqq.search.base.util.SearchViewUtils;
import com.tencent.mobileqq.search.business.miniprogram.view.MiniProgramSearchResultView;
import com.tencent.mobileqq.search.business.net.model.ImageItem;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateAvatarsItem;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateAvatarsView;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateBannerTitleItem;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateBaseItem;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateBaseItem.ImageInfo;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateBigImageItem;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateFriendUpdatesItem;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateHorizontalBaseItem;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateNetSeaEntranceItem;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateNewEntranceItem;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateQAItem;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateSubItem;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateSubItemTitle;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateTitleItem;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateUniversalItem;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateUniversalItem.ActionInfo;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateUniversalItem.HeadIconInfo;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateUniversalItem.NormalWord;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateUpdatesItem;
import com.tencent.mobileqq.search.business.net.view.NetSearchTemplateBannerTitleView;
import com.tencent.mobileqq.search.business.net.view.NetSearchTemplateBaseView;
import com.tencent.mobileqq.search.business.net.view.NetSearchTemplateBigImageView;
import com.tencent.mobileqq.search.business.net.view.NetSearchTemplateFriendUpdatesView;
import com.tencent.mobileqq.search.business.net.view.NetSearchTemplateHorizontalBaseView;
import com.tencent.mobileqq.search.business.net.view.NetSearchTemplateMiniAppView;
import com.tencent.mobileqq.search.business.net.view.NetSearchTemplateTitleView;
import com.tencent.mobileqq.search.business.net.view.NetSearchTemplateUniversalView;
import com.tencent.mobileqq.search.business.net.view.NetSearchTemplateUpdatesView;
import com.tencent.mobileqq.search.model.IFaceModel;
import com.tencent.mobileqq.search.model.MiniProgramSearchResultModel;
import com.tencent.mobileqq.search.model.NetSearchTemplateHorSlidingContainerItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateHorizontalContainerItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateIndividuateContainerItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateMiniAppItem;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.HighlightModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.view.NetSearchTemplateHorSlidingContainerView;
import com.tencent.mobileqq.search.view.NetSearchTemplateHorizontalContainerView;
import com.tencent.mobileqq.search.view.NetSearchTemplateIndividuateContainerView;
import com.tencent.mobileqq.search.view.NetSearchTemplateNetSeaEntranceView;
import com.tencent.mobileqq.search.view.NetSearchTemplateNewEntranceView;
import com.tencent.mobileqq.search.view.NetSearchTemplateQAView;
import com.tencent.mobileqq.search.view.NetSearchTemplateSubItemTitleView;
import com.tencent.mobileqq.search.view.NetSearchTemplateSubItemView;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import com.tencent.widget.HorizontalListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class SearchTemplatePresenter
  implements QQPlayerCallback, IFacePresenter<NetSearchTemplateBaseItem, NetSearchTemplateBaseView>
{
  public static int a;
  public ColorDrawable b = new ColorDrawable(Color.parseColor("#e7e7e7"));
  public Drawable c = URLDrawableHelperConstants.a;
  private IFaceDecoder d;
  private long e;
  private WeakReference<ImageView> f;
  private GroupSearchAdapter g;
  
  public SearchTemplatePresenter(IFaceDecoder paramIFaceDecoder, GroupSearchAdapter paramGroupSearchAdapter)
  {
    this.d = paramIFaceDecoder;
    this.g = paramGroupSearchAdapter;
  }
  
  private float a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      return 3.5F;
    }
    return 7.0F;
  }
  
  private int a(NetSearchTemplateUniversalItem paramNetSearchTemplateUniversalItem, NetSearchTemplateUniversalView paramNetSearchTemplateUniversalView, int paramInt1, int paramInt2)
  {
    if ((paramNetSearchTemplateUniversalView != null) && (paramNetSearchTemplateUniversalItem != null))
    {
      if (paramNetSearchTemplateUniversalView.d == null) {
        return 0;
      }
      Context localContext = paramNetSearchTemplateUniversalView.d.getContext();
      int i = localContext.getResources().getDisplayMetrics().widthPixels - paramInt1 - paramInt2 - DisplayUtil.a(localContext, 30.0F);
      Object localObject;
      if ((paramNetSearchTemplateUniversalItem.c != null) && (paramNetSearchTemplateUniversalItem.c.size() > 0))
      {
        paramNetSearchTemplateUniversalView.d.setVisibility(0);
        if ((paramNetSearchTemplateUniversalItem.b != null) && (paramNetSearchTemplateUniversalItem.c != null) && (paramNetSearchTemplateUniversalItem.c.size() > 0))
        {
          paramNetSearchTemplateUniversalView.n.setVisibility(0);
          if (paramNetSearchTemplateUniversalView.q != null) {
            paramNetSearchTemplateUniversalView.q.setVisibility(8);
          }
          if (paramNetSearchTemplateUniversalItem.b.a == 1)
          {
            if (paramNetSearchTemplateUniversalView.p != null) {
              paramNetSearchTemplateUniversalView.p.setVisibility(8);
            }
            if ((paramNetSearchTemplateUniversalView.q != null) && (!TextUtils.isEmpty(paramNetSearchTemplateUniversalItem.b.b)))
            {
              paramNetSearchTemplateUniversalView.q.setVisibility(0);
              a(paramNetSearchTemplateUniversalView.q, paramNetSearchTemplateUniversalItem.b.b);
              paramInt1 = DisplayUtil.a(localContext, 24.0F);
            }
          }
          else
          {
            for (;;)
            {
              paramInt1 = i - paramInt1;
              break label517;
              if (paramNetSearchTemplateUniversalItem.b.a == 2)
              {
                if (paramNetSearchTemplateUniversalView.q != null) {
                  paramNetSearchTemplateUniversalView.q.setVisibility(8);
                }
                if ((paramNetSearchTemplateUniversalView.p == null) || (TextUtils.isEmpty(paramNetSearchTemplateUniversalItem.b.e))) {
                  break;
                }
                if (SearchUtils.g(paramNetSearchTemplateUniversalItem.b.f)) {
                  localObject = paramNetSearchTemplateUniversalItem.b.f;
                } else {
                  localObject = "#fd7f32";
                }
                ((GradientDrawable)paramNetSearchTemplateUniversalView.p.getBackground()).setColor(Color.parseColor((String)localObject));
                paramNetSearchTemplateUniversalView.p.setVisibility(0);
                paramNetSearchTemplateUniversalView.p.setText(paramNetSearchTemplateUniversalItem.b.e);
                paramInt1 = (int)(i - (SearchUtils.a(paramNetSearchTemplateUniversalView.p, paramNetSearchTemplateUniversalItem.b.e) + DisplayUtil.a(localContext, 10.0F)));
                break label517;
              }
              if (paramNetSearchTemplateUniversalItem.b.a != 3) {
                break;
              }
              if (paramNetSearchTemplateUniversalView.p != null) {
                paramNetSearchTemplateUniversalView.p.setVisibility(8);
              }
              if ((paramNetSearchTemplateUniversalView.q == null) || (TextUtils.isEmpty(paramNetSearchTemplateUniversalItem.b.b))) {
                break;
              }
              paramNetSearchTemplateUniversalView.q.setVisibility(0);
              if ((paramNetSearchTemplateUniversalItem.b.c > 0) && (paramNetSearchTemplateUniversalItem.b.d > 0))
              {
                a(paramNetSearchTemplateUniversalView.q, paramNetSearchTemplateUniversalItem.b.c, paramNetSearchTemplateUniversalItem.b.d, paramNetSearchTemplateUniversalItem.b.b);
                paramInt1 = DisplayUtil.a(localContext, DisplayUtil.a(localContext, paramNetSearchTemplateUniversalItem.b.c) + 4);
              }
              else
              {
                a(paramNetSearchTemplateUniversalView.q, paramNetSearchTemplateUniversalItem.b.b);
                paramInt1 = DisplayUtil.a(localContext, 24.0F);
              }
            }
          }
          paramInt1 = i;
          label517:
          if ((paramNetSearchTemplateUniversalView.o != null) && (!TextUtils.isEmpty(((NetSearchTemplateUniversalItem.NormalWord)paramNetSearchTemplateUniversalItem.c.get(0)).a)))
          {
            localObject = ((NetSearchTemplateUniversalItem.NormalWord)paramNetSearchTemplateUniversalItem.c.get(0)).a;
            if (((NetSearchTemplateUniversalItem.NormalWord)paramNetSearchTemplateUniversalItem.c.get(0)).d) {
              localObject = SearchUtils.a(paramNetSearchTemplateUniversalView.o, paramInt1, 1, ((CharSequence)localObject).toString(), paramNetSearchTemplateUniversalItem.n.a, false, false, true);
            } else {
              localObject = SearchUtils.a(paramNetSearchTemplateUniversalView.o, paramInt1, ((CharSequence)localObject).toString());
            }
            paramNetSearchTemplateUniversalView.o.setText((CharSequence)localObject);
          }
          paramInt1 = 1;
        }
        else
        {
          if (paramNetSearchTemplateUniversalView.n != null) {
            paramNetSearchTemplateUniversalView.n.setVisibility(8);
          }
          paramInt1 = 0;
        }
        if (paramNetSearchTemplateUniversalView.y == null) {
          return paramNetSearchTemplateUniversalView.d.getHeight();
        }
        paramNetSearchTemplateUniversalView.y.removeAllViews();
        if ((paramNetSearchTemplateUniversalItem.c == null) || (paramNetSearchTemplateUniversalItem.c.size() <= 0)) {}
      }
      else
      {
        while (paramInt1 < paramNetSearchTemplateUniversalItem.c.size())
        {
          NetSearchTemplateUniversalItem.NormalWord localNormalWord = (NetSearchTemplateUniversalItem.NormalWord)paramNetSearchTemplateUniversalItem.c.get(paramInt1);
          TextView localTextView = new TextView(localContext);
          a(localTextView, localNormalWord.b, localNormalWord.c);
          CharSequence localCharSequence = localNormalWord.a;
          if (!TextUtils.isEmpty(localCharSequence))
          {
            localObject = localCharSequence;
            if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
              localObject = localCharSequence.toString();
            }
            paramInt2 = localNormalWord.c;
            if ((localContext instanceof PublicAcntSearchActivity)) {
              paramInt2 = 1;
            }
            if (localNormalWord.d)
            {
              boolean bool;
              if ((!localNormalWord.b.equals("A")) && (!localNormalWord.b.equals("B"))) {
                bool = false;
              } else {
                bool = true;
              }
              localObject = SearchUtils.a(localTextView, i, paramInt2, ((CharSequence)localObject).toString(), paramNetSearchTemplateUniversalItem.n.a, false, bool, true);
            }
            if (paramInt1 != 0) {
              localTextView.setPadding(0, DisplayUtil.a(localContext, 7.0F - a(((NetSearchTemplateUniversalItem.NormalWord)paramNetSearchTemplateUniversalItem.c.get(paramInt1 - 1)).b, localNormalWord.b)), 0, 0);
            }
            localTextView.setText((CharSequence)localObject);
            paramNetSearchTemplateUniversalView.y.addView(localTextView);
          }
          paramInt1 += 1;
          continue;
          paramNetSearchTemplateUniversalView.d.setVisibility(8);
        }
      }
      c(paramNetSearchTemplateUniversalItem, paramNetSearchTemplateUniversalView);
      paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0);
      paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 0);
      paramNetSearchTemplateUniversalView.d.measure(paramInt1, paramInt2);
      return paramNetSearchTemplateUniversalView.d.getMeasuredHeight();
    }
    return 0;
  }
  
  private StateListDrawable a(String paramString)
  {
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      localObject = "#040E1C";
      paramString = "#194A90";
    }
    else
    {
      localObject = paramString;
      if (!SearchUtils.g(paramString)) {
        localObject = "#F1F1F1";
      }
      paramString = "#E5E6E7";
    }
    StateListDrawable localStateListDrawable = new StateListDrawable();
    paramString = new ColorDrawable(Color.parseColor(paramString));
    Object localObject = new ColorDrawable(Color.parseColor((String)localObject));
    localStateListDrawable.addState(new int[] { 16842919, 16842910 }, paramString);
    localStateListDrawable.addState(new int[0], (Drawable)localObject);
    return localStateListDrawable;
  }
  
  public static Pair<Integer, Integer> a(NetSearchTemplateBaseItem paramNetSearchTemplateBaseItem, NetSearchTemplateBaseView paramNetSearchTemplateBaseView, boolean paramBoolean, int paramInt)
  {
    Object localObject2 = Integer.valueOf(0);
    if ((paramNetSearchTemplateBaseView != null) && (paramNetSearchTemplateBaseView.r != null) && (paramNetSearchTemplateBaseView.s != null) && (paramNetSearchTemplateBaseItem != null))
    {
      Object localObject1 = paramNetSearchTemplateBaseView.s;
      NetSearchTemplateBaseItem.ImageInfo localImageInfo = paramNetSearchTemplateBaseItem.q;
      if ((localImageInfo != null) && (!TextUtils.isEmpty(localImageInfo.b)))
      {
        paramNetSearchTemplateBaseView.r.setVisibility(0);
        localObject2 = ((SquareImageView)localObject1).getContext();
        paramNetSearchTemplateBaseItem = a((SquareImageView)localObject1, localImageInfo.a, localImageInfo.b, localImageInfo.c, paramBoolean, paramInt, paramNetSearchTemplateBaseItem);
        paramInt = ((Integer)paramNetSearchTemplateBaseItem.first).intValue();
        int i = ((Integer)paramNetSearchTemplateBaseItem.second).intValue();
        paramNetSearchTemplateBaseItem = ((SquareImageView)localObject1).getLayoutParams();
        paramNetSearchTemplateBaseItem.width = paramInt;
        paramNetSearchTemplateBaseItem.height = i;
        ((SquareImageView)localObject1).setLayoutParams(paramNetSearchTemplateBaseItem);
        paramNetSearchTemplateBaseItem = (RelativeLayout.LayoutParams)paramNetSearchTemplateBaseView.r.getLayoutParams();
        paramNetSearchTemplateBaseItem.width = paramInt;
        paramNetSearchTemplateBaseItem.height = i;
        paramNetSearchTemplateBaseView.r.setLayoutParams(paramNetSearchTemplateBaseItem);
        int j = DisplayUtil.a((Context)localObject2, 10.0F);
        if ((!TextUtils.isEmpty(localImageInfo.e)) && (paramNetSearchTemplateBaseView.u != null))
        {
          if (SearchUtils.g(localImageInfo.f)) {
            paramNetSearchTemplateBaseItem = localImageInfo.f;
          } else {
            paramNetSearchTemplateBaseItem = "#fd7f32";
          }
          ((GradientDrawable)paramNetSearchTemplateBaseView.u.getBackground()).setColor(Color.parseColor(paramNetSearchTemplateBaseItem));
          paramNetSearchTemplateBaseView.u.setVisibility(0);
          paramNetSearchTemplateBaseView.u.setText(localImageInfo.e);
        }
        else if (paramNetSearchTemplateBaseView.u != null)
        {
          paramNetSearchTemplateBaseView.u.setVisibility(8);
        }
        if (paramNetSearchTemplateBaseView.t != null) {
          if (localImageInfo.d) {
            paramNetSearchTemplateBaseView.t.setVisibility(0);
          } else {
            paramNetSearchTemplateBaseView.t.setVisibility(8);
          }
        }
        if (paramNetSearchTemplateBaseView.v != null) {
          if (!TextUtils.isEmpty(localImageInfo.g))
          {
            paramNetSearchTemplateBaseView.v.setVisibility(0);
            paramNetSearchTemplateBaseView.v.setText(localImageInfo.g);
          }
          else
          {
            paramNetSearchTemplateBaseView.v.setVisibility(8);
          }
        }
        if (paramNetSearchTemplateBaseView.w != null) {
          if (!TextUtils.isEmpty(localImageInfo.h))
          {
            paramNetSearchTemplateBaseView.w.setVisibility(0);
            paramNetSearchTemplateBaseItem = URLDrawable.URLDrawableOptions.obtain();
            localObject1 = new ColorDrawable(-1);
            paramNetSearchTemplateBaseItem.mFailedDrawable = ((Drawable)localObject1);
            paramNetSearchTemplateBaseItem.mLoadingDrawable = ((Drawable)localObject1);
            paramNetSearchTemplateBaseItem.mRequestWidth = paramNetSearchTemplateBaseView.w.getLayoutParams().width;
            paramNetSearchTemplateBaseItem.mRequestHeight = paramNetSearchTemplateBaseView.w.getLayoutParams().height;
            paramNetSearchTemplateBaseItem = URLDrawable.getDrawable(localImageInfo.h, paramNetSearchTemplateBaseItem);
            if ((paramNetSearchTemplateBaseItem.getStatus() != 1) && (paramNetSearchTemplateBaseItem.getStatus() != 0)) {
              paramNetSearchTemplateBaseItem.restartDownload();
            }
            paramNetSearchTemplateBaseView.w.setImageDrawable(paramNetSearchTemplateBaseItem);
          }
          else
          {
            paramNetSearchTemplateBaseView.w.setVisibility(8);
          }
        }
        if (paramNetSearchTemplateBaseView.x != null) {
          if (!TextUtils.isEmpty(localImageInfo.i))
          {
            paramNetSearchTemplateBaseView.x.setVisibility(0);
            paramNetSearchTemplateBaseView.x.setText(localImageInfo.i);
          }
          else
          {
            paramNetSearchTemplateBaseView.x.setVisibility(8);
          }
        }
        return new Pair(Integer.valueOf(paramInt + j), Integer.valueOf(i));
      }
      paramNetSearchTemplateBaseView.r.setVisibility(8);
      return new Pair(localObject2, localObject2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.SearchTemplatePresenter", 2, "bindUniversalTemplateLeftImageview or item is null");
    }
    return new Pair(localObject2, localObject2);
  }
  
  public static Pair<Integer, Integer> a(SquareImageView paramSquareImageView, int paramInt1, String paramString, int paramInt2, boolean paramBoolean, int paramInt3, NetSearchTemplateBaseItem paramNetSearchTemplateBaseItem)
  {
    int i = paramInt3;
    Object localObject1 = Integer.valueOf(0);
    if ((paramSquareImageView != null) && (!TextUtils.isEmpty(paramString)))
    {
      Object localObject2 = paramSquareImageView.getContext();
      if (paramInt1 != 128) {
        switch (paramInt1)
        {
        default: 
          paramInt1 = DisplayUtil.a((Context)localObject2, 60.0F);
          paramInt3 = DisplayUtil.a((Context)localObject2, 60.0F);
        }
      }
      int j;
      for (;;)
      {
        j = 0;
        break;
        paramInt1 = DisplayUtil.a((Context)localObject2, 162.0F);
        paramInt3 = DisplayUtil.a((Context)localObject2, 162.0F);
        break label294;
        paramInt1 = DisplayUtil.a((Context)localObject2, 162.0F);
        paramInt3 = DisplayUtil.a((Context)localObject2, 228.0F);
        continue;
        paramInt1 = DisplayUtil.a((Context)localObject2, 162.0F);
        paramInt3 = DisplayUtil.a((Context)localObject2, 162.0F);
        continue;
        paramInt1 = DisplayUtil.a((Context)localObject2, 220.0F);
        paramInt3 = DisplayUtil.a((Context)localObject2, 136.0F);
        continue;
        paramInt1 = DisplayUtil.a((Context)localObject2, 100.0F);
        paramInt3 = DisplayUtil.a((Context)localObject2, 141.0F);
        continue;
        paramInt1 = DisplayUtil.a((Context)localObject2, 113.0F);
        paramInt3 = DisplayUtil.a((Context)localObject2, 60.0F);
        continue;
        paramInt1 = DisplayUtil.a((Context)localObject2, 60.0F);
        paramInt3 = DisplayUtil.a((Context)localObject2, 85.0F);
        continue;
        paramInt1 = DisplayUtil.a((Context)localObject2, 50.0F);
        paramInt3 = DisplayUtil.a((Context)localObject2, 50.0F);
        label294:
        do
        {
          for (;;)
          {
            j = 1;
            break;
            if ((paramSquareImageView.getContext() instanceof PublicAcntSearchActivity))
            {
              paramInt1 = DisplayUtil.a(paramSquareImageView.getContext(), 50.0F);
              paramInt3 = DisplayUtil.a(paramSquareImageView.getContext(), 50.0F);
            }
            else
            {
              paramInt1 = DisplayUtil.a((Context)localObject2, 60.0F);
              paramInt3 = DisplayUtil.a((Context)localObject2, 60.0F);
            }
          }
          paramInt1 = DisplayUtil.a((Context)localObject2, 50.0F);
          paramInt3 = DisplayUtil.a((Context)localObject2, 50.0F);
          break;
          paramInt1 = DisplayUtil.a((Context)localObject2, 60.0F);
          paramInt3 = DisplayUtil.a((Context)localObject2, 60.0F);
          break;
          if ((paramNetSearchTemplateBaseItem instanceof NetSearchTemplateUniversalItem))
          {
            paramInt1 = DisplayUtil.a((Context)localObject2, paramNetSearchTemplateBaseItem.q.j / 2);
            paramInt3 = DisplayUtil.a((Context)localObject2, paramNetSearchTemplateBaseItem.q.k / 2);
          }
          else
          {
            paramInt1 = 0;
            paramInt3 = 0;
          }
        } while ((paramInt2 == paramNetSearchTemplateBaseItem.q.j / 2) && (paramInt2 == paramNetSearchTemplateBaseItem.q.k / 2));
      }
      localObject1 = new ColorDrawable(Color.parseColor("#e7e7e7"));
      if (paramBoolean)
      {
        f1 = paramInt3 * 1.0F / paramInt1;
        int k = (int)(i * f1);
        paramInt1 = i;
        paramInt3 = k;
        if (j != 0)
        {
          double d1 = i;
          Double.isNaN(d1);
          paramInt1 = (int)(d1 * 0.2D / 2.0D);
          paramSquareImageView.setPadding(DisplayUtil.a((Context)localObject2, 3.0F), DisplayUtil.a((Context)localObject2, 3.0F), DisplayUtil.a((Context)localObject2, 3.0F), DisplayUtil.a((Context)localObject2, 3.0F));
          paramNetSearchTemplateBaseItem = (RelativeLayout.LayoutParams)paramSquareImageView.getLayoutParams();
          paramInt1 -= DisplayUtil.a((Context)localObject2, 3.0F);
          paramNetSearchTemplateBaseItem.rightMargin = paramInt1;
          paramNetSearchTemplateBaseItem.leftMargin = paramInt1;
          paramNetSearchTemplateBaseItem.topMargin = paramInt1;
          paramSquareImageView.setLayoutParams(paramNetSearchTemplateBaseItem);
          paramInt1 = i;
          paramInt3 = k;
        }
      }
      float f1 = paramInt1;
      paramSquareImageView.setImageScale(1.0F * f1 / paramInt3, 0.0F);
      paramNetSearchTemplateBaseItem = (NetSearchTemplateBaseItem)localObject1;
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          paramNetSearchTemplateBaseItem = URLDrawable.URLDrawableOptions.obtain();
          paramNetSearchTemplateBaseItem.mRequestWidth = paramInt1;
          paramNetSearchTemplateBaseItem.mRequestHeight = paramInt3;
          if (j != 0)
          {
            localObject2 = new GradientDrawable();
            ((GradientDrawable)localObject2).setShape(0);
            ((GradientDrawable)localObject2).setCornerRadius(f1 / 2.0F);
            ((GradientDrawable)localObject2).setColor(-1579033);
            paramNetSearchTemplateBaseItem.mLoadingDrawable = ((Drawable)localObject2);
            paramNetSearchTemplateBaseItem.mFailedDrawable = ((Drawable)localObject2);
          }
          else
          {
            paramNetSearchTemplateBaseItem.mFailedDrawable = ((Drawable)localObject1);
            paramNetSearchTemplateBaseItem.mLoadingDrawable = ((Drawable)localObject1);
            paramSquareImageView.setBackgroundColor(0);
          }
          paramNetSearchTemplateBaseItem.mPlayGifImage = true;
          if (j != 0)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("isAvatar");
            ((StringBuilder)localObject2).append(paramInt1);
            ((StringBuilder)localObject2).append(paramInt3);
            paramNetSearchTemplateBaseItem.mMemoryCacheKeySuffix = ((StringBuilder)localObject2).toString();
            paramNetSearchTemplateBaseItem = URLDrawable.getDrawable(paramString, paramNetSearchTemplateBaseItem);
            paramNetSearchTemplateBaseItem.setDecodeHandler(URLDrawableDecodeHandler.b);
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("isNotAvatar");
            ((StringBuilder)localObject2).append(paramInt1);
            ((StringBuilder)localObject2).append(paramInt3);
            ((StringBuilder)localObject2).append(paramInt2);
            paramNetSearchTemplateBaseItem.mMemoryCacheKeySuffix = ((StringBuilder)localObject2).toString();
            paramNetSearchTemplateBaseItem = URLDrawable.getDrawable(paramString, paramNetSearchTemplateBaseItem);
            paramNetSearchTemplateBaseItem.setTag(URLDrawableDecodeHandler.b(paramInt1, paramInt3, paramInt2));
            paramNetSearchTemplateBaseItem.setDecodeHandler(URLDrawableDecodeHandler.j);
          }
          if ((paramNetSearchTemplateBaseItem.getStatus() != 1) && (paramNetSearchTemplateBaseItem.getStatus() != 0)) {
            paramNetSearchTemplateBaseItem.restartDownload();
          }
        }
      }
      catch (Exception paramNetSearchTemplateBaseItem)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("imageUrl is not valid. imageUrl=");
        ((StringBuilder)localObject2).append(paramString);
        QLog.e("Q.uniteSearch.SearchTemplatePresenter", 1, ((StringBuilder)localObject2).toString(), paramNetSearchTemplateBaseItem);
        paramNetSearchTemplateBaseItem = (NetSearchTemplateBaseItem)localObject1;
      }
      paramSquareImageView.setImageDrawable(paramNetSearchTemplateBaseItem);
      return new Pair(Integer.valueOf(paramInt1), Integer.valueOf(paramInt3));
    }
    return new Pair(localObject1, localObject1);
  }
  
  private void a(TextView paramTextView, String paramString, int paramInt)
  {
    if ((paramTextView != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (paramInt <= 0) {
        return;
      }
      Context localContext = paramTextView.getContext();
      paramTextView.setMaxLines(paramInt);
      paramTextView.setEllipsize(TextUtils.TruncateAt.END);
      boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
      if (paramString.equals("A"))
      {
        paramTextView.setTextSize(1, 17.0F);
        if (bool) {
          paramTextView.setTextColor(Color.parseColor("#737373"));
        } else {
          paramTextView.setTextColor(localContext.getResources().getColor(2131167995));
        }
        paramTextView.setIncludeFontPadding(false);
        return;
      }
      if (paramString.equals("B"))
      {
        paramTextView.setTextSize(1, 15.0F);
        if (bool) {
          paramTextView.setTextColor(Color.parseColor("#737373"));
        } else {
          paramTextView.setTextColor(localContext.getResources().getColor(2131167995));
        }
        paramTextView.setIncludeFontPadding(false);
        return;
      }
      if (paramString.equals("C"))
      {
        paramTextView.setTextSize(1, 14.0F);
        if (bool) {
          paramTextView.setTextColor(Color.parseColor("#4A4A4A"));
        } else {
          paramTextView.setTextColor(localContext.getResources().getColor(2131167996));
        }
        paramTextView.setIncludeFontPadding(false);
        return;
      }
      if (paramString.equals("D"))
      {
        paramTextView.setTextSize(1, 13.0F);
        if (bool) {
          paramTextView.setTextColor(Color.parseColor("#4A4A4A"));
        } else {
          paramTextView.setTextColor(localContext.getResources().getColor(2131167996));
        }
        paramTextView.setIncludeFontPadding(false);
        return;
      }
      if (paramString.equals("E"))
      {
        paramTextView.setTextSize(1, 12.0F);
        if (bool) {
          paramTextView.setTextColor(Color.parseColor("#4A4A4A"));
        } else {
          paramTextView.setTextColor(localContext.getResources().getColor(2131167996));
        }
        paramTextView.setIncludeFontPadding(false);
        return;
      }
      if (paramString.equals("F"))
      {
        paramTextView.setTextSize(1, 12.0F);
        paramTextView.setIncludeFontPadding(false);
        if (bool)
        {
          paramTextView.setTextColor(Color.parseColor("#4A4A4A"));
          return;
        }
        paramTextView.setTextColor(localContext.getResources().getColor(2131168192));
        return;
      }
      paramTextView.setTextSize(1, 17.0F);
      paramTextView.setTextColor(localContext.getResources().getColor(2131168001));
      paramTextView.setIncludeFontPadding(false);
    }
  }
  
  private void a(NetSearchTemplateAvatarsItem paramNetSearchTemplateAvatarsItem, NetSearchTemplateAvatarsView paramNetSearchTemplateAvatarsView)
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject3 = paramNetSearchTemplateAvatarsView.h().getContext();
    if (ThemeUtil.isNowThemeIsNight((AppRuntime)localObject1, false, null)) {
      paramNetSearchTemplateAvatarsView.a.setTextColor(Color.parseColor("#737373"));
    } else {
      paramNetSearchTemplateAvatarsView.a.setTextColor(Color.parseColor("#262626"));
    }
    int i;
    Object localObject2;
    if (TextUtils.isEmpty(paramNetSearchTemplateAvatarsItem.a))
    {
      paramNetSearchTemplateAvatarsView.a.setVisibility(8);
    }
    else
    {
      i = (int)(paramNetSearchTemplateAvatarsView.a.getContext().getResources().getDisplayMetrics().widthPixels - DisplayUtil.a(paramNetSearchTemplateAvatarsView.a.getContext(), 30.0F) - SearchUtils.a(paramNetSearchTemplateAvatarsView.a, paramNetSearchTemplateAvatarsItem.b));
      localObject2 = SearchUtils.a(paramNetSearchTemplateAvatarsView.a, i, 1, paramNetSearchTemplateAvatarsItem.a.toString(), paramNetSearchTemplateAvatarsItem.n.a, false, false, true);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      if (paramNetSearchTemplateAvatarsItem.b == null) {
        paramNetSearchTemplateAvatarsItem.b = "";
      }
      paramNetSearchTemplateAvatarsView.a.setText(new SpannableStringBuilder((CharSequence)localObject1).append(paramNetSearchTemplateAvatarsItem.b));
      paramNetSearchTemplateAvatarsView.a.setVisibility(0);
    }
    int m;
    int n;
    int j;
    Object localObject4;
    ColorDrawable localColorDrawable;
    int k;
    if (paramNetSearchTemplateAvatarsItem.e != null)
    {
      paramNetSearchTemplateAvatarsView.d.setVisibility(0);
      paramNetSearchTemplateAvatarsView.b.setVisibility(8);
      i = (int)(DeviceInfoUtil.F() - UIUtils.a((Context)localObject3, 30.0F)) / 2 - UIUtils.a((Context)localObject3, 3.0F);
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = i;
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = i;
      localObject2 = URLDrawable.getDrawable(paramNetSearchTemplateAvatarsItem.e.a, (URLDrawable.URLDrawableOptions)localObject1);
      paramNetSearchTemplateAvatarsView.o.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      localObject2 = (LinearLayout.LayoutParams)paramNetSearchTemplateAvatarsView.o.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).height = i;
      ((LinearLayout.LayoutParams)localObject2).width = i;
      paramNetSearchTemplateAvatarsView.o.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      paramNetSearchTemplateAvatarsView.o.setVisibility(0);
      if (paramNetSearchTemplateAvatarsItem.d != null)
      {
        m = Math.min(paramNetSearchTemplateAvatarsItem.d.size(), 4);
        n = (i - UIUtils.a((Context)localObject3, 3.0F)) / 2;
        localObject2 = new int[4];
        Object tmp447_445 = localObject2;
        tmp447_445[0] = 2131435397;
        Object tmp453_447 = tmp447_445;
        tmp453_447[1] = 2131435398;
        Object tmp459_453 = tmp453_447;
        tmp459_453[2] = 2131435399;
        Object tmp465_459 = tmp459_453;
        tmp465_459[3] = 2131435400;
        tmp465_459;
        i = 0;
        for (;;)
        {
          j = i;
          if (i >= m) {
            break;
          }
          localObject3 = (SquareImageView)paramNetSearchTemplateAvatarsView.d.findViewById(localObject2[i]);
          localObject4 = ((ImageItem)paramNetSearchTemplateAvatarsItem.d.get(i)).a;
          ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
          localColorDrawable = this.b;
          ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = localColorDrawable;
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = localColorDrawable;
          ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = n;
          ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = n;
          localObject4 = URLDrawable.getDrawable((String)localObject4, (URLDrawable.URLDrawableOptions)localObject1);
          ((SquareImageView)localObject3).setImageDrawable((Drawable)localObject4);
          if ((((URLDrawable)localObject4).getStatus() != 1) && (((URLDrawable)localObject4).getStatus() != 0)) {
            ((URLDrawable)localObject4).restartDownload();
          }
          localObject4 = (LinearLayout.LayoutParams)((SquareImageView)localObject3).getLayoutParams();
          ((LinearLayout.LayoutParams)localObject4).height = n;
          ((LinearLayout.LayoutParams)localObject4).width = n;
          ((SquareImageView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
          ((SquareImageView)localObject3).setVisibility(0);
          if ((i == 3) && (paramNetSearchTemplateAvatarsItem.c > 4))
          {
            ((SquareImageView)localObject3).setFilterColor(Color.parseColor("#66000000"));
            k = paramNetSearchTemplateAvatarsItem.c - 4;
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("+");
            j = k;
            if (k > 99) {
              j = 99;
            }
            ((StringBuilder)localObject4).append(j);
            ((SquareImageView)localObject3).setFilterText(((StringBuilder)localObject4).toString());
            ((SquareImageView)localObject3).setFilterTextSize(DisplayUtil.a(paramNetSearchTemplateAvatarsView.h().getContext(), 20.0F));
          }
          else
          {
            ((SquareImageView)localObject3).setFilterColor(-1);
            ((SquareImageView)localObject3).setFilterText("");
          }
          i += 1;
        }
        while (j < 4)
        {
          paramNetSearchTemplateAvatarsView.d.findViewById(localObject2[j]).setVisibility(4);
          j += 1;
        }
      }
    }
    else
    {
      paramNetSearchTemplateAvatarsView.d.setVisibility(8);
      paramNetSearchTemplateAvatarsView.b.setVisibility(0);
      if (paramNetSearchTemplateAvatarsItem.d != null)
      {
        m = Math.min(paramNetSearchTemplateAvatarsItem.d.size(), paramNetSearchTemplateAvatarsView.c);
        n = (int)(DeviceInfoUtil.F() - UIUtils.a(paramNetSearchTemplateAvatarsView.h().getContext(), (m - 1) * 2 + 27));
        i = 0;
        for (;;)
        {
          j = i;
          if (i >= m) {
            break;
          }
          localObject1 = (SquareImageView)paramNetSearchTemplateAvatarsView.b.getChildAt(i);
          localObject2 = ((ImageItem)paramNetSearchTemplateAvatarsItem.d.get(i)).a;
          localObject4 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject4).mPlayGifImage = true;
          localColorDrawable = this.b;
          ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = localColorDrawable;
          ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = localColorDrawable;
          ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = n;
          ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = n;
          ((URLDrawable.URLDrawableOptions)localObject4).mMemoryCacheKeySuffix = "fourPic";
          localObject2 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject4);
          ((SquareImageView)localObject1).setImageDrawable((Drawable)localObject2);
          if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
            ((URLDrawable)localObject2).restartDownload();
          }
          if (paramNetSearchTemplateAvatarsItem.f != 0) {
            ((SquareImageView)localObject1).setImageScale(n / 4 * 1.0F / DisplayUtil.a((Context)localObject3, paramNetSearchTemplateAvatarsItem.f / 2), 0.0F);
          } else {
            ((SquareImageView)localObject1).setImageScale(1.0F, 0.0F);
          }
          ((SquareImageView)localObject1).setVisibility(0);
          if ((i == paramNetSearchTemplateAvatarsView.c - 1) && (paramNetSearchTemplateAvatarsItem.c > paramNetSearchTemplateAvatarsView.c))
          {
            ((SquareImageView)localObject1).setFilterColor(Color.parseColor("#66000000"));
            k = paramNetSearchTemplateAvatarsItem.c - paramNetSearchTemplateAvatarsView.c;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("+");
            j = k;
            if (k > 99) {
              j = 99;
            }
            ((StringBuilder)localObject2).append(j);
            ((SquareImageView)localObject1).setFilterText(((StringBuilder)localObject2).toString());
            ((SquareImageView)localObject1).setFilterTextSize(DisplayUtil.a(paramNetSearchTemplateAvatarsView.h().getContext(), 20.0F));
          }
          else
          {
            ((SquareImageView)localObject1).setFilterColor(-1);
            ((SquareImageView)localObject1).setFilterText("");
          }
          i += 1;
        }
        while (j < paramNetSearchTemplateAvatarsView.c)
        {
          paramNetSearchTemplateAvatarsView.b.getChildAt(j).setVisibility(4);
          j += 1;
        }
      }
    }
  }
  
  private void a(NetSearchTemplateBannerTitleItem paramNetSearchTemplateBannerTitleItem, NetSearchTemplateBannerTitleView paramNetSearchTemplateBannerTitleView)
  {
    Object localObject = paramNetSearchTemplateBannerTitleView.h().getContext();
    if (!TextUtils.isEmpty(paramNetSearchTemplateBannerTitleItem.s))
    {
      paramNetSearchTemplateBannerTitleView.n.setVisibility(0);
      a((Context)localObject, (SquareImageView)paramNetSearchTemplateBannerTitleView.o, paramNetSearchTemplateBannerTitleView.p, paramNetSearchTemplateBannerTitleView.b, paramNetSearchTemplateBannerTitleItem.c, paramNetSearchTemplateBannerTitleItem.s, paramNetSearchTemplateBannerTitleItem.f, ((Context)localObject).getResources().getDimensionPixelSize(2131299187));
    }
    else
    {
      paramNetSearchTemplateBannerTitleView.n.setVisibility(8);
    }
    int i = ((Context)localObject).getResources().getDimensionPixelSize(2131299187);
    if ((paramNetSearchTemplateBannerTitleItem.c == 6) || (paramNetSearchTemplateBannerTitleItem.c == 8)) {
      i = DisplayUtil.a((Context)localObject, 100.0F);
    }
    if (paramNetSearchTemplateBannerTitleView.n.getVisibility() == 8) {
      i = 0;
    } else {
      i += DisplayUtil.a((Context)localObject, 10.0F);
    }
    float f1 = ((Context)localObject).getResources().getDisplayMetrics().widthPixels - DisplayUtil.a((Context)localObject, 30.0F);
    CharSequence localCharSequence = SearchUtils.a(paramNetSearchTemplateBannerTitleView.a, f1, 2, paramNetSearchTemplateBannerTitleItem.b.toString(), paramNetSearchTemplateBannerTitleItem.n.a, false, true);
    paramNetSearchTemplateBannerTitleView.a.setText(localCharSequence);
    f1 = ((Context)localObject).getResources().getDisplayMetrics().widthPixels - DisplayUtil.a((Context)localObject, 30.0F) - i;
    localObject = SearchUtils.a(paramNetSearchTemplateBannerTitleView.c, f1, 2, paramNetSearchTemplateBannerTitleItem.d.toString(), paramNetSearchTemplateBannerTitleItem.n.a, false, false);
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      paramNetSearchTemplateBannerTitleView.c.setTextColor(Color.parseColor("#4A4A4A"));
      paramNetSearchTemplateBannerTitleView.d.setTextColor(Color.parseColor("#4A4A4A"));
    }
    else
    {
      paramNetSearchTemplateBannerTitleView.c.setTextColor(Color.parseColor("#737373"));
      paramNetSearchTemplateBannerTitleView.d.setTextColor(Color.parseColor("#737373"));
    }
    a(paramNetSearchTemplateBannerTitleView.c, (CharSequence)localObject, true);
    a(paramNetSearchTemplateBannerTitleView.d, paramNetSearchTemplateBannerTitleItem.e);
  }
  
  private void a(NetSearchTemplateBigImageItem paramNetSearchTemplateBigImageItem, NetSearchTemplateBigImageView paramNetSearchTemplateBigImageView)
  {
    Context localContext = paramNetSearchTemplateBigImageView.h().getContext();
    int i;
    int j;
    if (paramNetSearchTemplateBigImageItem.b == 1)
    {
      i = DisplayUtil.a(localContext, 375.0F);
      j = DisplayUtil.a(localContext, 150.0F);
    }
    else if (paramNetSearchTemplateBigImageItem.b == 2)
    {
      i = DisplayUtil.a(localContext, 375.0F);
      j = DisplayUtil.a(localContext, 180.0F);
    }
    else if (paramNetSearchTemplateBigImageItem.b == 0)
    {
      i = DisplayUtil.a(localContext, paramNetSearchTemplateBigImageItem.d / 2.0F);
      j = DisplayUtil.a(localContext, paramNetSearchTemplateBigImageItem.e / 2.0F);
    }
    else
    {
      i = 0;
      j = 0;
    }
    int k;
    if (i != 0)
    {
      k = i;
      i = j;
      if (j != 0) {}
    }
    else
    {
      k = DisplayUtil.a(localContext, 375.0F);
      i = DisplayUtil.a(localContext, 150.0F);
    }
    if (!TextUtils.isEmpty(paramNetSearchTemplateBigImageItem.c))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      Drawable localDrawable = this.c;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = k;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i;
      ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
      localObject = URLDrawable.getDrawable(paramNetSearchTemplateBigImageItem.c, (URLDrawable.URLDrawableOptions)localObject);
      paramNetSearchTemplateBigImageView.b.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
    }
    else
    {
      paramNetSearchTemplateBigImageView.b.setImageDrawable(this.c);
    }
    paramNetSearchTemplateBigImageView.b.setVisibility(0);
    Object localObject = (LinearLayout.LayoutParams)paramNetSearchTemplateBigImageView.a.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).height = ((int)(UIUtils.b(localContext) * i * 1.0F / k));
    paramNetSearchTemplateBigImageView.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramNetSearchTemplateBigImageView.a.setPadding(0, 0, 0, 0);
    if (!TextUtils.isEmpty(paramNetSearchTemplateBigImageItem.u))
    {
      paramNetSearchTemplateBigImageView.d.setText(paramNetSearchTemplateBigImageItem.u);
      paramNetSearchTemplateBigImageView.d.setVisibility(0);
    }
    else
    {
      paramNetSearchTemplateBigImageView.d.setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramNetSearchTemplateBigImageItem.v))
    {
      paramNetSearchTemplateBigImageView.n.setText(paramNetSearchTemplateBigImageItem.v);
      paramNetSearchTemplateBigImageView.n.setVisibility(0);
    }
    else
    {
      paramNetSearchTemplateBigImageView.n.setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramNetSearchTemplateBigImageItem.f)) {
      paramNetSearchTemplateBigImageView.o.setText(paramNetSearchTemplateBigImageItem.f);
    }
    try
    {
      if (!paramNetSearchTemplateBigImageItem.t.startsWith("#"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("#");
        ((StringBuilder)localObject).append(paramNetSearchTemplateBigImageItem.t);
        paramNetSearchTemplateBigImageItem.t = ((StringBuilder)localObject).toString();
      }
      paramNetSearchTemplateBigImageView.o.setBackgroundColor(Color.parseColor(paramNetSearchTemplateBigImageItem.t));
    }
    catch (Exception localException)
    {
      label483:
      break label483;
    }
    paramNetSearchTemplateBigImageView.o.setBackgroundColor(Color.parseColor("#FF00FF00"));
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("bigImageItem.topLeftTagColor = ");
      ((StringBuilder)localObject).append(paramNetSearchTemplateBigImageItem.t);
      QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, ((StringBuilder)localObject).toString());
    }
    paramNetSearchTemplateBigImageView.o.setVisibility(0);
    break label562;
    paramNetSearchTemplateBigImageView.o.setVisibility(8);
    label562:
    localObject = ((ViewGroup)paramNetSearchTemplateBigImageView.h()).getChildAt(((ViewGroup)paramNetSearchTemplateBigImageView.h()).getChildCount() - 1);
    if ((localObject != null) && ((((View)localObject).getLayoutParams() instanceof LinearLayout.LayoutParams)))
    {
      if (paramNetSearchTemplateBigImageItem.cl_() == 0)
      {
        ((LinearLayout.LayoutParams)((View)localObject).getLayoutParams()).topMargin = 0;
        paramNetSearchTemplateBigImageView.a.setPadding(0, 0, 0, DisplayUtil.a(localContext, 6.0F));
        return;
      }
      if (paramNetSearchTemplateBigImageItem.cl_() == 2) {
        ((LinearLayout.LayoutParams)((View)localObject).getLayoutParams()).bottomMargin = 0;
      }
    }
  }
  
  private void a(NetSearchTemplateFriendUpdatesItem paramNetSearchTemplateFriendUpdatesItem, NetSearchTemplateFriendUpdatesView paramNetSearchTemplateFriendUpdatesView)
  {
    Object localObject1 = paramNetSearchTemplateFriendUpdatesView.h().getContext();
    Object localObject2 = paramNetSearchTemplateFriendUpdatesView.h();
    if (paramNetSearchTemplateFriendUpdatesItem.w) {
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), UIUtils.a(((View)localObject2).getContext(), 6.0F), ((View)localObject2).getPaddingRight(), UIUtils.a(((View)localObject2).getContext(), 6.0F));
    } else {
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), UIUtils.a(((View)localObject2).getContext(), 3.0F), ((View)localObject2).getPaddingRight(), UIUtils.a(((View)localObject2).getContext(), 3.0F));
    }
    localObject2 = (LinearLayout)((View)localObject2).findViewById(2131440280);
    Object localObject3 = new ArrayList();
    int i = 0;
    Object localObject4;
    while (i < ((LinearLayout)localObject2).getChildCount())
    {
      localObject4 = ((LinearLayout)localObject2).getChildAt(i).findViewById(2131435463);
      if ((localObject4 instanceof SquareImageView)) {
        ((List)localObject3).add((SquareImageView)localObject4);
      }
      i += 1;
    }
    if (!((List)localObject3).isEmpty())
    {
      if (paramNetSearchTemplateFriendUpdatesItem.x)
      {
        i = 0;
        while (i < ((List)localObject3).size())
        {
          ((SquareImageView)((List)localObject3).get(i)).setRoundRect(UIUtils.a((Context)localObject1, 4.0F));
          i += 1;
        }
      }
      i = 0;
      while (i < ((List)localObject3).size())
      {
        ((SquareImageView)((List)localObject3).get(i)).setRoundRect(0);
        i += 1;
      }
    }
    if (!TextUtils.isEmpty(paramNetSearchTemplateFriendUpdatesItem.s)) {
      a((Context)localObject1, (SquareImageView)paramNetSearchTemplateFriendUpdatesView.g(), paramNetSearchTemplateFriendUpdatesView.b, paramNetSearchTemplateFriendUpdatesView.c, paramNetSearchTemplateFriendUpdatesItem.a, paramNetSearchTemplateFriendUpdatesItem.s, null, DisplayUtil.a((Context)localObject1, 32.0F));
    }
    if (!TextUtils.isEmpty(paramNetSearchTemplateFriendUpdatesItem.c))
    {
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      localObject3 = this.c;
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject3);
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject3);
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = paramNetSearchTemplateFriendUpdatesView.a.getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = paramNetSearchTemplateFriendUpdatesView.a.getLayoutParams().height;
      localObject2 = URLDrawable.getDrawable(paramNetSearchTemplateFriendUpdatesItem.c, (URLDrawable.URLDrawableOptions)localObject2);
      paramNetSearchTemplateFriendUpdatesView.a.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      paramNetSearchTemplateFriendUpdatesView.a.setVisibility(0);
    }
    else
    {
      paramNetSearchTemplateFriendUpdatesView.a.setVisibility(8);
    }
    i = ((Context)localObject1).getResources().getDimensionPixelSize(2131299187);
    if ((paramNetSearchTemplateFriendUpdatesItem.a == 6) || (paramNetSearchTemplateFriendUpdatesItem.a == 8)) {
      i = DisplayUtil.a((Context)localObject1, 100.0F);
    }
    localObject2 = SearchUtils.a(paramNetSearchTemplateFriendUpdatesView.b(), SearchUtils.a(paramNetSearchTemplateFriendUpdatesView.b(), HardCodeUtil.a(2131911131)) * 10.0F, 1, paramNetSearchTemplateFriendUpdatesItem.b.toString(), paramNetSearchTemplateFriendUpdatesItem.n.a, false, false, true);
    paramNetSearchTemplateFriendUpdatesView.b().setText((CharSequence)localObject2);
    paramNetSearchTemplateFriendUpdatesView.b().setEllipsize(null);
    float f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - DisplayUtil.a((Context)localObject1, 40.0F) - i;
    localObject2 = SearchUtils.a(paramNetSearchTemplateFriendUpdatesView.c(), f1, 2, paramNetSearchTemplateFriendUpdatesItem.d.toString(), "", false, false, true);
    a(paramNetSearchTemplateFriendUpdatesView.c(), (CharSequence)localObject2, false);
    if (!TextUtils.isEmpty(paramNetSearchTemplateFriendUpdatesItem.e))
    {
      f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - DisplayUtil.a((Context)localObject1, 30.0F);
      localObject2 = SearchUtils.a(paramNetSearchTemplateFriendUpdatesView.d(), f1, 2, paramNetSearchTemplateFriendUpdatesItem.e.toString(), paramNetSearchTemplateFriendUpdatesItem.n.a, false, false);
      paramNetSearchTemplateFriendUpdatesView.d().setText((CharSequence)localObject2);
      paramNetSearchTemplateFriendUpdatesView.d().setVisibility(0);
    }
    else
    {
      paramNetSearchTemplateFriendUpdatesView.d().setVisibility(8);
    }
    int j;
    Object localObject5;
    if (paramNetSearchTemplateFriendUpdatesItem.f != null)
    {
      Object localObject6;
      if (paramNetSearchTemplateFriendUpdatesItem.f.size() == 1)
      {
        paramNetSearchTemplateFriendUpdatesView.p.setVisibility(0);
        paramNetSearchTemplateFriendUpdatesView.d.setVisibility(8);
        localObject3 = paramNetSearchTemplateFriendUpdatesView.h().getResources();
        if (a == 0) {
          a = ((Resources)localObject3).getDisplayMetrics().widthPixels;
        }
        localObject2 = paramNetSearchTemplateFriendUpdatesView.n;
        ((SquareImageView)localObject2).setImageScale((float)(1.0D / paramNetSearchTemplateFriendUpdatesItem.t), 0.0F);
        f1 = ((Resources)localObject3).getDimension(2131299180);
        float f2 = ((Resources)localObject3).getDimension(2131299180);
        i = DisplayUtil.a(paramNetSearchTemplateFriendUpdatesView.h().getContext(), 2.0F);
        j = paramNetSearchTemplateFriendUpdatesView.d.getChildCount();
        double d1 = (int)(a - f1 - f2 - (j - 1) * i) / j;
        double d2 = paramNetSearchTemplateFriendUpdatesItem.v;
        Double.isNaN(d1);
        i = (int)(d2 * d1);
        d2 = paramNetSearchTemplateFriendUpdatesItem.v;
        Double.isNaN(d1);
        j = (int)(d1 * d2);
        ((SquareImageView)localObject2).setLayoutParams(new FrameLayout.LayoutParams(i, j));
        localObject3 = (ImageItem)paramNetSearchTemplateFriendUpdatesItem.f.get(0);
        localObject4 = ((ImageItem)localObject3).a;
        localObject5 = URLDrawable.URLDrawableOptions.obtain();
        localObject6 = this.b;
        ((URLDrawable.URLDrawableOptions)localObject5).mFailedDrawable = ((Drawable)localObject6);
        ((URLDrawable.URLDrawableOptions)localObject5).mLoadingDrawable = ((Drawable)localObject6);
        ((URLDrawable.URLDrawableOptions)localObject5).mRequestWidth = i;
        ((URLDrawable.URLDrawableOptions)localObject5).mRequestHeight = j;
        ((URLDrawable.URLDrawableOptions)localObject5).mPlayGifImage = true;
        localObject4 = URLDrawable.getDrawable((String)localObject4, (URLDrawable.URLDrawableOptions)localObject5);
        ((SquareImageView)localObject2).setImageDrawable((Drawable)localObject4);
        if ((((URLDrawable)localObject4).getStatus() != 1) && (((URLDrawable)localObject4).getStatus() != 0)) {
          ((URLDrawable)localObject4).restartDownload();
        }
        if (((ImageItem)localObject3).b == 2) {
          paramNetSearchTemplateFriendUpdatesView.o.setVisibility(0);
        } else {
          paramNetSearchTemplateFriendUpdatesView.o.setVisibility(8);
        }
      }
      else
      {
        paramNetSearchTemplateFriendUpdatesView.p.setVisibility(8);
        paramNetSearchTemplateFriendUpdatesView.d.setVisibility(0);
        int m = paramNetSearchTemplateFriendUpdatesView.d.getChildCount();
        i = 0;
        for (;;)
        {
          j = i;
          if (i >= paramNetSearchTemplateFriendUpdatesItem.f.size()) {
            break;
          }
          j = i;
          if (i >= m) {
            break;
          }
          localObject3 = paramNetSearchTemplateFriendUpdatesView.d.getChildAt(i);
          ((View)localObject3).setVisibility(0);
          localObject2 = (SquareImageView)((View)localObject3).findViewById(2131435463);
          localObject3 = (ImageView)((View)localObject3).findViewById(2131436849);
          ((SquareImageView)localObject2).setImageScale((float)(1.0D / paramNetSearchTemplateFriendUpdatesItem.t), 0.0F);
          localObject4 = (ImageItem)paramNetSearchTemplateFriendUpdatesItem.f.get(i);
          localObject5 = ((ImageItem)localObject4).a;
          localObject6 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject6).mRequestHeight = 200;
          ((URLDrawable.URLDrawableOptions)localObject6).mRequestWidth = 200;
          ColorDrawable localColorDrawable = this.b;
          ((URLDrawable.URLDrawableOptions)localObject6).mFailedDrawable = localColorDrawable;
          ((URLDrawable.URLDrawableOptions)localObject6).mLoadingDrawable = localColorDrawable;
          ((URLDrawable.URLDrawableOptions)localObject6).mPlayGifImage = true;
          localObject5 = URLDrawable.getDrawable((String)localObject5, (URLDrawable.URLDrawableOptions)localObject6);
          ((SquareImageView)localObject2).setImageDrawable((Drawable)localObject5);
          if ((((URLDrawable)localObject5).getStatus() != 1) && (((URLDrawable)localObject5).getStatus() != 0)) {
            ((URLDrawable)localObject5).restartDownload();
          }
          ((SquareImageView)localObject2).setVisibility(0);
          if (((ImageItem)localObject4).b == 2) {
            ((ImageView)localObject3).setVisibility(0);
          } else {
            ((ImageView)localObject3).setVisibility(8);
          }
          if ((i == m - 1) && (paramNetSearchTemplateFriendUpdatesItem.u > m))
          {
            ((ImageView)localObject3).setVisibility(8);
            ((SquareImageView)localObject2).setFilterColor(Color.parseColor("#66000000"));
            int k = paramNetSearchTemplateFriendUpdatesItem.u - m;
            j = k;
            if (k > 99) {
              j = 99;
            }
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("+");
            ((StringBuilder)localObject3).append(j);
            ((SquareImageView)localObject2).setFilterText(((StringBuilder)localObject3).toString());
            ((SquareImageView)localObject2).setFilterTextSize(DisplayUtil.a(((SquareImageView)localObject2).getContext(), 20.0F));
          }
          else
          {
            ((SquareImageView)localObject2).setFilterColor(-1);
            ((SquareImageView)localObject2).setFilterText("");
          }
          i += 1;
        }
        while (j < m)
        {
          paramNetSearchTemplateFriendUpdatesView.d.getChildAt(j).setVisibility(4);
          j += 1;
        }
      }
    }
    else
    {
      paramNetSearchTemplateFriendUpdatesView.p.setVisibility(8);
      paramNetSearchTemplateFriendUpdatesView.d.setVisibility(8);
    }
    if ((paramNetSearchTemplateFriendUpdatesItem.y == null) && (TextUtils.equals(paramNetSearchTemplateFriendUpdatesItem.B, "0")) && (TextUtils.equals(paramNetSearchTemplateFriendUpdatesItem.D, "0")))
    {
      paramNetSearchTemplateFriendUpdatesView.y.setVisibility(8);
      return;
    }
    if (paramNetSearchTemplateFriendUpdatesItem.y != null)
    {
      paramNetSearchTemplateFriendUpdatesView.q.removeAllViews();
      i = paramNetSearchTemplateFriendUpdatesItem.y.size() - 1;
      while (i >= 0)
      {
        if (i > 0) {
          j = DisplayUtil.a((Context)localObject1, 11.0F) * i;
        } else {
          j = 0;
        }
        localObject2 = (SquareImageView)LayoutInflater.from((Context)localObject1).inflate(2131625855, null, false);
        localObject3 = new RelativeLayout.LayoutParams(DisplayUtil.a((Context)localObject1, 16.0F), DisplayUtil.a((Context)localObject1, 16.0F));
        ((RelativeLayout.LayoutParams)localObject3).leftMargin = j;
        paramNetSearchTemplateFriendUpdatesView.q.addView((View)localObject2, paramNetSearchTemplateFriendUpdatesItem.y.size() - 1 - i, (ViewGroup.LayoutParams)localObject3);
        localObject3 = (String)paramNetSearchTemplateFriendUpdatesItem.y.get(i);
        localObject4 = URLDrawable.URLDrawableOptions.obtain();
        localObject5 = this.b;
        ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = ((Drawable)localObject5);
        ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = ((Drawable)localObject5);
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = ((SquareImageView)localObject2).getLayoutParams().width;
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = ((SquareImageView)localObject2).getLayoutParams().height;
        localObject3 = URLDrawable.getDrawable((String)localObject3, (URLDrawable.URLDrawableOptions)localObject4);
        ((URLDrawable)localObject3).setDecodeHandler(URLDrawableDecodeHandler.b);
        ((SquareImageView)localObject2).setImageDrawable((Drawable)localObject3);
        if ((((URLDrawable)localObject3).getStatus() != 1) && (((URLDrawable)localObject3).getStatus() != 0)) {
          ((URLDrawable)localObject3).restartDownload();
        }
        ((SquareImageView)localObject2).setVisibility(0);
        i -= 1;
      }
    }
    paramNetSearchTemplateFriendUpdatesView.q.removeAllViews();
    if (!TextUtils.isEmpty(paramNetSearchTemplateFriendUpdatesItem.z))
    {
      paramNetSearchTemplateFriendUpdatesView.z.setText(paramNetSearchTemplateFriendUpdatesItem.z);
      paramNetSearchTemplateFriendUpdatesView.z.setVisibility(0);
    }
    else
    {
      paramNetSearchTemplateFriendUpdatesView.z.setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramNetSearchTemplateFriendUpdatesItem.A))
    {
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      localObject2 = this.c;
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((Drawable)localObject2);
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject2);
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = paramNetSearchTemplateFriendUpdatesView.A.getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = paramNetSearchTemplateFriendUpdatesView.A.getLayoutParams().height;
      localObject1 = URLDrawable.getDrawable(paramNetSearchTemplateFriendUpdatesItem.A, (URLDrawable.URLDrawableOptions)localObject1);
      paramNetSearchTemplateFriendUpdatesView.A.setImageDrawable((Drawable)localObject1);
      if ((((URLDrawable)localObject1).getStatus() != 1) && (((URLDrawable)localObject1).getStatus() != 0)) {
        ((URLDrawable)localObject1).restartDownload();
      }
      paramNetSearchTemplateFriendUpdatesView.A.setVisibility(0);
    }
    else
    {
      paramNetSearchTemplateFriendUpdatesView.A.setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramNetSearchTemplateFriendUpdatesItem.B))
    {
      paramNetSearchTemplateFriendUpdatesView.B.setText(paramNetSearchTemplateFriendUpdatesItem.B);
      paramNetSearchTemplateFriendUpdatesView.B.setVisibility(0);
    }
    else
    {
      paramNetSearchTemplateFriendUpdatesView.B.setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramNetSearchTemplateFriendUpdatesItem.C))
    {
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      localObject2 = this.c;
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((Drawable)localObject2);
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject2);
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = paramNetSearchTemplateFriendUpdatesView.C.getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = paramNetSearchTemplateFriendUpdatesView.C.getLayoutParams().height;
      localObject1 = URLDrawable.getDrawable(paramNetSearchTemplateFriendUpdatesItem.C, (URLDrawable.URLDrawableOptions)localObject1);
      paramNetSearchTemplateFriendUpdatesView.C.setImageDrawable((Drawable)localObject1);
      if ((((URLDrawable)localObject1).getStatus() != 1) && (((URLDrawable)localObject1).getStatus() != 0)) {
        ((URLDrawable)localObject1).restartDownload();
      }
      paramNetSearchTemplateFriendUpdatesView.C.setVisibility(0);
    }
    else
    {
      paramNetSearchTemplateFriendUpdatesView.C.setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramNetSearchTemplateFriendUpdatesItem.D))
    {
      paramNetSearchTemplateFriendUpdatesView.D.setText(paramNetSearchTemplateFriendUpdatesItem.D);
      paramNetSearchTemplateFriendUpdatesView.D.setVisibility(0);
      return;
    }
    paramNetSearchTemplateFriendUpdatesView.D.setVisibility(8);
  }
  
  private void a(NetSearchTemplateNetSeaEntranceItem paramNetSearchTemplateNetSeaEntranceItem, NetSearchTemplateNetSeaEntranceView paramNetSearchTemplateNetSeaEntranceView)
  {
    Object localObject = paramNetSearchTemplateNetSeaEntranceView.h();
    Context localContext = ((View)localObject).getContext();
    if ((localObject instanceof LinearLayout))
    {
      localObject = (LinearLayout)localObject;
      if (((LinearLayout)localObject).getChildCount() == 1)
      {
        localObject = ((LinearLayout)localObject).getChildAt(0);
        ((View)localObject).setPadding(((View)localObject).getPaddingLeft(), 0, ((View)localObject).getPaddingRight(), 0);
      }
    }
    ColorDrawable localColorDrawable;
    if (!TextUtils.isEmpty(paramNetSearchTemplateNetSeaEntranceItem.b))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      localColorDrawable = this.b;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = DisplayUtil.a(localContext, 50.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = DisplayUtil.a(localContext, 50.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "leftIcon";
      localObject = URLDrawable.getDrawable(paramNetSearchTemplateNetSeaEntranceItem.b, (URLDrawable.URLDrawableOptions)localObject);
      paramNetSearchTemplateNetSeaEntranceView.b.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      paramNetSearchTemplateNetSeaEntranceView.b.setVisibility(0);
    }
    else
    {
      paramNetSearchTemplateNetSeaEntranceView.b.setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramNetSearchTemplateNetSeaEntranceItem.c))
    {
      paramNetSearchTemplateNetSeaEntranceView.c.setText(paramNetSearchTemplateNetSeaEntranceItem.c);
      paramNetSearchTemplateNetSeaEntranceView.c.setVisibility(0);
    }
    else
    {
      paramNetSearchTemplateNetSeaEntranceView.c.setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramNetSearchTemplateNetSeaEntranceItem.m))
    {
      paramNetSearchTemplateNetSeaEntranceView.d.setText(paramNetSearchTemplateNetSeaEntranceItem.m);
      paramNetSearchTemplateNetSeaEntranceView.d.setVisibility(0);
    }
    else
    {
      paramNetSearchTemplateNetSeaEntranceView.d.setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramNetSearchTemplateNetSeaEntranceItem.d))
    {
      paramNetSearchTemplateNetSeaEntranceView.n.setVisibility(0);
      paramNetSearchTemplateNetSeaEntranceView.n.setText(paramNetSearchTemplateNetSeaEntranceItem.d);
    }
    else
    {
      paramNetSearchTemplateNetSeaEntranceView.n.setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramNetSearchTemplateNetSeaEntranceItem.e))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      localColorDrawable = this.b;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = DisplayUtil.a(localContext, 30.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = DisplayUtil.a(localContext, 30.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "rightIcon";
      localObject = URLDrawable.getDrawable(paramNetSearchTemplateNetSeaEntranceItem.e, (URLDrawable.URLDrawableOptions)localObject);
      paramNetSearchTemplateNetSeaEntranceView.o.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      paramNetSearchTemplateNetSeaEntranceView.o.setVisibility(0);
    }
    else
    {
      paramNetSearchTemplateNetSeaEntranceView.o.setVisibility(8);
    }
    paramNetSearchTemplateNetSeaEntranceView.a(paramNetSearchTemplateNetSeaEntranceItem);
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
    {
      paramNetSearchTemplateNetSeaEntranceView.a.setBackgroundResource(2130839569);
      paramNetSearchTemplateNetSeaEntranceView.q.setBackgroundResource(2130839569);
      paramNetSearchTemplateNetSeaEntranceView.c.setTextColor(Color.parseColor("#737373"));
      paramNetSearchTemplateNetSeaEntranceView.n.setTextColor(Color.parseColor("#4A4A4A"));
    }
    else
    {
      paramNetSearchTemplateNetSeaEntranceView.a.setBackgroundResource(2130839568);
      paramNetSearchTemplateNetSeaEntranceView.q.setBackgroundResource(2130839568);
      paramNetSearchTemplateNetSeaEntranceView.c.setTextColor(Color.parseColor("#262626"));
      paramNetSearchTemplateNetSeaEntranceView.n.setTextColor(Color.parseColor("#737373"));
    }
    if (paramNetSearchTemplateNetSeaEntranceView.d != null) {
      paramNetSearchTemplateNetSeaEntranceView.d.setTextColor(SearchUtils.a());
    }
    paramNetSearchTemplateNetSeaEntranceView.a.setOnClickListener(new SearchTemplatePresenter.4(this, paramNetSearchTemplateNetSeaEntranceItem, localContext));
    paramNetSearchTemplateNetSeaEntranceView.q.setOnClickListener(new SearchTemplatePresenter.5(this, paramNetSearchTemplateNetSeaEntranceItem, localContext));
  }
  
  private void a(NetSearchTemplateNewEntranceItem paramNetSearchTemplateNewEntranceItem, NetSearchTemplateNewEntranceView paramNetSearchTemplateNewEntranceView)
  {
    Object localObject = paramNetSearchTemplateNewEntranceView.h();
    Context localContext = ((View)localObject).getContext();
    if ((localObject instanceof LinearLayout))
    {
      localObject = (LinearLayout)localObject;
      if (((LinearLayout)localObject).getChildCount() == 1)
      {
        localObject = ((LinearLayout)localObject).getChildAt(0);
        ((View)localObject).setPadding(((View)localObject).getPaddingLeft(), 0, ((View)localObject).getPaddingRight(), 0);
      }
    }
    if (!TextUtils.isEmpty(paramNetSearchTemplateNewEntranceItem.b))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ColorDrawable localColorDrawable = this.b;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = DisplayUtil.a(localContext, 40.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = DisplayUtil.a(localContext, 40.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "leftIcon";
      localObject = URLDrawable.getDrawable(paramNetSearchTemplateNewEntranceItem.b, (URLDrawable.URLDrawableOptions)localObject);
      paramNetSearchTemplateNewEntranceView.b.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      paramNetSearchTemplateNewEntranceView.b.setVisibility(0);
    }
    else
    {
      paramNetSearchTemplateNewEntranceView.b.setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramNetSearchTemplateNewEntranceItem.c))
    {
      paramNetSearchTemplateNewEntranceView.c.setText(paramNetSearchTemplateNewEntranceItem.c);
      paramNetSearchTemplateNewEntranceView.c.setVisibility(0);
    }
    else
    {
      paramNetSearchTemplateNewEntranceView.c.setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramNetSearchTemplateNewEntranceItem.m))
    {
      paramNetSearchTemplateNewEntranceView.n.setText(paramNetSearchTemplateNewEntranceItem.m);
      paramNetSearchTemplateNewEntranceView.n.setVisibility(0);
    }
    else
    {
      paramNetSearchTemplateNewEntranceView.n.setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramNetSearchTemplateNewEntranceItem.d))
    {
      paramNetSearchTemplateNewEntranceView.o.setVisibility(0);
      paramNetSearchTemplateNewEntranceView.o.setText(paramNetSearchTemplateNewEntranceItem.d);
    }
    else
    {
      paramNetSearchTemplateNewEntranceView.o.setVisibility(8);
    }
    if (paramNetSearchTemplateNewEntranceItem.e) {
      paramNetSearchTemplateNewEntranceView.p.setVisibility(0);
    } else {
      paramNetSearchTemplateNewEntranceView.p.setVisibility(8);
    }
    UniteSearchReportController.a(null, 0, paramNetSearchTemplateNewEntranceItem.p, "0X8009D5C", 0, 0, null, null);
    if ((paramNetSearchTemplateNewEntranceItem.t != null) && (paramNetSearchTemplateNewEntranceItem.t.size() > 0)) {
      UniteSearchReportController.a(null, 0, paramNetSearchTemplateNewEntranceItem.p, "0X8009D5E", 0, 0, null, null);
    }
    paramNetSearchTemplateNewEntranceView.a(paramNetSearchTemplateNewEntranceItem);
    paramNetSearchTemplateNewEntranceView.a.setOnClickListener(new SearchTemplatePresenter.3(this, paramNetSearchTemplateNewEntranceItem, localContext));
  }
  
  private void a(NetSearchTemplateSubItem paramNetSearchTemplateSubItem, NetSearchTemplateSubItemView paramNetSearchTemplateSubItemView)
  {
    if (paramNetSearchTemplateSubItem != null)
    {
      if (paramNetSearchTemplateSubItemView == null) {
        return;
      }
      paramNetSearchTemplateSubItemView.d.setPadding(paramNetSearchTemplateSubItemView.d.getPaddingLeft(), 0, paramNetSearchTemplateSubItemView.d.getPaddingRight(), 0);
      Object localObject = (RelativeLayout.LayoutParams)paramNetSearchTemplateSubItemView.a.getLayoutParams();
      boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
      if (paramNetSearchTemplateSubItem.d)
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(5, 0);
        ((RelativeLayout.LayoutParams)localObject).addRule(14);
      }
      else
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(14, 0);
        ((RelativeLayout.LayoutParams)localObject).addRule(5);
      }
      localObject = paramNetSearchTemplateSubItemView.a.getContext();
      int i = ((Context)localObject).getResources().getDisplayMetrics().widthPixels - DisplayUtil.a((Context)localObject, 38.0F);
      if (!TextUtils.isEmpty(paramNetSearchTemplateSubItem.b))
      {
        paramNetSearchTemplateSubItemView.b.setVisibility(0);
        if (bool) {
          paramNetSearchTemplateSubItemView.b.setText(paramNetSearchTemplateSubItem.b.toString());
        } else {
          paramNetSearchTemplateSubItemView.b.setText(paramNetSearchTemplateSubItem.b);
        }
        i = (int)(i - (SearchUtils.a(paramNetSearchTemplateSubItemView.b, paramNetSearchTemplateSubItem.b) + DisplayUtil.a((Context)localObject, 10.0F)));
      }
      else
      {
        paramNetSearchTemplateSubItemView.b.setVisibility(8);
      }
      if (!TextUtils.isEmpty(paramNetSearchTemplateSubItem.a))
      {
        paramNetSearchTemplateSubItemView.a.setVisibility(0);
        CharSequence localCharSequence = paramNetSearchTemplateSubItem.a;
        localObject = localCharSequence;
        if (!paramNetSearchTemplateSubItem.d) {
          localObject = SearchUtils.a(paramNetSearchTemplateSubItemView.a, i, localCharSequence);
        }
        if (bool) {
          paramNetSearchTemplateSubItemView.a.setText(((CharSequence)localObject).toString());
        } else {
          paramNetSearchTemplateSubItemView.a.setText((CharSequence)localObject);
        }
      }
      else
      {
        paramNetSearchTemplateSubItemView.a.setVisibility(8);
      }
      paramNetSearchTemplateSubItemView.c.setBackgroundDrawable(a(paramNetSearchTemplateSubItem.c));
      paramNetSearchTemplateSubItemView.c.setOnClickListener(new SearchTemplatePresenter.6(this, paramNetSearchTemplateSubItem, paramNetSearchTemplateSubItemView));
    }
  }
  
  private void a(NetSearchTemplateSubItemTitle paramNetSearchTemplateSubItemTitle, NetSearchTemplateSubItemTitleView paramNetSearchTemplateSubItemTitleView)
  {
    if (paramNetSearchTemplateSubItemTitle != null)
    {
      if (paramNetSearchTemplateSubItemTitleView == null) {
        return;
      }
      if ((!TextUtils.isEmpty(paramNetSearchTemplateSubItemTitle.a)) && (paramNetSearchTemplateSubItemTitleView.a != null))
      {
        Context localContext = paramNetSearchTemplateSubItemTitleView.a.getContext();
        int j = localContext.getResources().getDisplayMetrics().widthPixels - DisplayUtil.a(localContext, 40.0F);
        int i;
        if ((!TextUtils.isEmpty(paramNetSearchTemplateSubItemTitle.j)) && (paramNetSearchTemplateSubItemTitleView.b != null))
        {
          paramNetSearchTemplateSubItemTitleView.b.setVisibility(0);
          i = j - DisplayUtil.a(localContext, 26.0F);
        }
        else
        {
          i = j;
          if (paramNetSearchTemplateSubItemTitleView.b != null)
          {
            paramNetSearchTemplateSubItemTitleView.b.setVisibility(8);
            i = j;
          }
        }
        paramNetSearchTemplateSubItemTitle = SearchUtils.a(paramNetSearchTemplateSubItemTitleView.a, i, paramNetSearchTemplateSubItemTitle.a);
        paramNetSearchTemplateSubItemTitleView.a.setText(paramNetSearchTemplateSubItemTitle);
      }
    }
  }
  
  private void a(NetSearchTemplateUniversalItem paramNetSearchTemplateUniversalItem, NetSearchTemplateUniversalView paramNetSearchTemplateUniversalView)
  {
    Context localContext = paramNetSearchTemplateUniversalView.r.getContext();
    Object localObject = (RelativeLayout.LayoutParams)paramNetSearchTemplateUniversalView.d.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramNetSearchTemplateUniversalView.r.getLayoutParams();
    if (paramNetSearchTemplateUniversalItem.d)
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      localLayoutParams.addRule(15);
      localLayoutParams.addRule(10, 0);
      localLayoutParams.addRule(10, 0);
    }
    else
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
      localLayoutParams.addRule(10);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, 0);
      localLayoutParams.addRule(15, 0);
    }
    localObject = a(paramNetSearchTemplateUniversalItem, paramNetSearchTemplateUniversalView, false, 0);
    if (((Integer)((Pair)localObject).first).intValue() != 0) {
      ((RelativeLayout.LayoutParams)paramNetSearchTemplateUniversalView.r.getLayoutParams()).rightMargin = DisplayUtil.a(localContext, 10.0F);
    }
    int i = b(paramNetSearchTemplateUniversalItem, paramNetSearchTemplateUniversalView);
    int j = a(paramNetSearchTemplateUniversalItem, paramNetSearchTemplateUniversalView, ((Integer)((Pair)localObject).first).intValue(), i);
    i = j;
    if (((Integer)((Pair)localObject).second).intValue() > j) {
      i = ((Integer)((Pair)localObject).second).intValue();
    }
    if (paramNetSearchTemplateUniversalView.a != null) {
      ((RelativeLayout.LayoutParams)paramNetSearchTemplateUniversalView.a.getLayoutParams()).height = i;
    }
  }
  
  private void a(NetSearchTemplateUpdatesItem paramNetSearchTemplateUpdatesItem, NetSearchTemplateUpdatesView paramNetSearchTemplateUpdatesView)
  {
    Object localObject1 = paramNetSearchTemplateUpdatesView.h().getContext();
    Object localObject2 = paramNetSearchTemplateUpdatesView.h();
    if (paramNetSearchTemplateUpdatesItem.w) {
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), UIUtils.a(((View)localObject2).getContext(), 9.0F), ((View)localObject2).getPaddingRight(), UIUtils.a(((View)localObject2).getContext(), 9.0F));
    } else {
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), UIUtils.a(((View)localObject2).getContext(), 6.0F), ((View)localObject2).getPaddingRight(), UIUtils.a(((View)localObject2).getContext(), 6.0F));
    }
    localObject2 = (LinearLayout)((View)localObject2).findViewById(2131440280);
    Object localObject3 = new ArrayList();
    int i = 0;
    Object localObject4;
    while (i < ((LinearLayout)localObject2).getChildCount())
    {
      localObject4 = ((LinearLayout)localObject2).getChildAt(i).findViewById(2131435463);
      if ((localObject4 instanceof SquareImageView)) {
        ((List)localObject3).add((SquareImageView)localObject4);
      }
      i += 1;
    }
    if (!((List)localObject3).isEmpty())
    {
      if (paramNetSearchTemplateUpdatesItem.x)
      {
        i = 0;
        while (i < ((List)localObject3).size())
        {
          ((SquareImageView)((List)localObject3).get(i)).setRoundRect(UIUtils.a((Context)localObject1, 4.0F));
          i += 1;
        }
      }
      i = 0;
      while (i < ((List)localObject3).size())
      {
        ((SquareImageView)((List)localObject3).get(i)).setRoundRect(0);
        i += 1;
      }
    }
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      paramNetSearchTemplateUpdatesView.b().setTextColor(Color.parseColor("#6991B8"));
      paramNetSearchTemplateUpdatesView.d().setTextColor(Color.parseColor("#44608A"));
      paramNetSearchTemplateUpdatesView.c().setTextColor(Color.parseColor("#44608A"));
    }
    else
    {
      paramNetSearchTemplateUpdatesView.b().setTextColor(Color.parseColor("#262626"));
      paramNetSearchTemplateUpdatesView.d().setTextColor(Color.parseColor("#737373"));
      paramNetSearchTemplateUpdatesView.c().setTextColor(Color.parseColor("#737373"));
    }
    if (!TextUtils.isEmpty(paramNetSearchTemplateUpdatesItem.s)) {
      a((Context)localObject1, (SquareImageView)paramNetSearchTemplateUpdatesView.g(), paramNetSearchTemplateUpdatesView.b, paramNetSearchTemplateUpdatesView.c, paramNetSearchTemplateUpdatesItem.a, paramNetSearchTemplateUpdatesItem.s, null, DisplayUtil.a((Context)localObject1, 21.0F));
    }
    if (!TextUtils.isEmpty(paramNetSearchTemplateUpdatesItem.c))
    {
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      localObject3 = this.c;
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject3);
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject3);
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = paramNetSearchTemplateUpdatesView.a.getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = paramNetSearchTemplateUpdatesView.a.getLayoutParams().height;
      localObject2 = URLDrawable.getDrawable(paramNetSearchTemplateUpdatesItem.c, (URLDrawable.URLDrawableOptions)localObject2);
      paramNetSearchTemplateUpdatesView.a.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      paramNetSearchTemplateUpdatesView.a.setVisibility(0);
    }
    else
    {
      paramNetSearchTemplateUpdatesView.a.setVisibility(8);
    }
    i = ((Context)localObject1).getResources().getDimensionPixelSize(2131299187);
    if ((paramNetSearchTemplateUpdatesItem.a == 6) || (paramNetSearchTemplateUpdatesItem.a == 8)) {
      i = DisplayUtil.a((Context)localObject1, 100.0F);
    }
    localObject2 = SearchUtils.a(paramNetSearchTemplateUpdatesView.b(), SearchUtils.a(paramNetSearchTemplateUpdatesView.b(), HardCodeUtil.a(2131911130)) * 10.0F, 1, paramNetSearchTemplateUpdatesItem.b.toString(), paramNetSearchTemplateUpdatesItem.n.a, false, false, true);
    paramNetSearchTemplateUpdatesView.b().setText((CharSequence)localObject2);
    paramNetSearchTemplateUpdatesView.b().setEllipsize(null);
    float f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - DisplayUtil.a((Context)localObject1, 40.0F) - i;
    localObject2 = SearchUtils.a(paramNetSearchTemplateUpdatesView.c(), f1, 2, paramNetSearchTemplateUpdatesItem.d.toString(), "", false, false, true);
    a(paramNetSearchTemplateUpdatesView.c(), (CharSequence)localObject2, false);
    if (!TextUtils.isEmpty(paramNetSearchTemplateUpdatesItem.e))
    {
      f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - DisplayUtil.a((Context)localObject1, 30.0F);
      localObject2 = SearchUtils.a(paramNetSearchTemplateUpdatesView.d(), f1, 2, paramNetSearchTemplateUpdatesItem.e.toString(), paramNetSearchTemplateUpdatesItem.n.a, false, false);
      paramNetSearchTemplateUpdatesView.d().setText((CharSequence)localObject2);
      paramNetSearchTemplateUpdatesView.d().setVisibility(0);
    }
    else
    {
      paramNetSearchTemplateUpdatesView.d().setVisibility(8);
    }
    if (paramNetSearchTemplateUpdatesItem.f != null)
    {
      int j;
      double d1;
      double d2;
      if (paramNetSearchTemplateUpdatesItem.f.size() == 1)
      {
        paramNetSearchTemplateUpdatesView.p.setVisibility(0);
        paramNetSearchTemplateUpdatesView.d.setVisibility(8);
        localObject2 = paramNetSearchTemplateUpdatesView.h().getResources();
        if (a == 0) {
          a = ((Resources)localObject2).getDisplayMetrics().widthPixels;
        }
        localObject1 = paramNetSearchTemplateUpdatesView.n;
        ((SquareImageView)localObject1).setImageScale((float)(1.0D / paramNetSearchTemplateUpdatesItem.t), 0.0F);
        f1 = ((Resources)localObject2).getDimension(2131299180);
        float f2 = ((Resources)localObject2).getDimension(2131299180);
        i = DisplayUtil.a(paramNetSearchTemplateUpdatesView.h().getContext(), 2.0F);
        j = paramNetSearchTemplateUpdatesView.d.getChildCount();
        d1 = (int)(a - f1 - f2 - (j - 1) * i) / j;
        d2 = paramNetSearchTemplateUpdatesItem.v;
        Double.isNaN(d1);
        i = (int)(d2 * d1);
        d2 = paramNetSearchTemplateUpdatesItem.v;
        Double.isNaN(d1);
        j = (int)(d1 * d2);
        ((SquareImageView)localObject1).setLayoutParams(new FrameLayout.LayoutParams(i, j));
        paramNetSearchTemplateUpdatesItem = (ImageItem)paramNetSearchTemplateUpdatesItem.f.get(0);
        localObject2 = paramNetSearchTemplateUpdatesItem.a;
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        localObject4 = this.b;
        ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject4);
        ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject4);
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = i;
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = j;
        ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = true;
        localObject2 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject3);
        ((SquareImageView)localObject1).setImageDrawable((Drawable)localObject2);
        if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
          ((URLDrawable)localObject2).restartDownload();
        }
        if (paramNetSearchTemplateUpdatesItem.b == 2)
        {
          paramNetSearchTemplateUpdatesView.o.setVisibility(0);
          return;
        }
        paramNetSearchTemplateUpdatesView.o.setVisibility(8);
        return;
      }
      paramNetSearchTemplateUpdatesView.p.setVisibility(8);
      paramNetSearchTemplateUpdatesView.d.setVisibility(0);
      int m = paramNetSearchTemplateUpdatesView.d.getChildCount();
      i = 0;
      for (;;)
      {
        j = i;
        if (i >= paramNetSearchTemplateUpdatesItem.f.size()) {
          break;
        }
        j = i;
        if (i >= m) {
          break;
        }
        localObject3 = paramNetSearchTemplateUpdatesView.d.getChildAt(i);
        ((View)localObject3).setVisibility(0);
        localObject2 = (SquareImageView)((View)localObject3).findViewById(2131435463);
        localObject3 = (ImageView)((View)localObject3).findViewById(2131436849);
        j = UIUtils.b((Context)localObject1) / m;
        d1 = j;
        d2 = paramNetSearchTemplateUpdatesItem.t;
        Double.isNaN(d1);
        int k = (int)(d1 * d2);
        ((SquareImageView)localObject2).setImageScale((float)(1.0D / paramNetSearchTemplateUpdatesItem.t), 0.0F);
        localObject4 = (ImageItem)paramNetSearchTemplateUpdatesItem.f.get(i);
        Object localObject5 = ((ImageItem)localObject4).a;
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        ColorDrawable localColorDrawable = this.b;
        localURLDrawableOptions.mFailedDrawable = localColorDrawable;
        localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
        localURLDrawableOptions.mRequestWidth = j;
        localURLDrawableOptions.mRequestHeight = k;
        localURLDrawableOptions.mPlayGifImage = true;
        localObject5 = URLDrawable.getDrawable((String)localObject5, localURLDrawableOptions);
        ((SquareImageView)localObject2).setImageDrawable((Drawable)localObject5);
        if ((((URLDrawable)localObject5).getStatus() != 1) && (((URLDrawable)localObject5).getStatus() != 0)) {
          ((URLDrawable)localObject5).restartDownload();
        }
        ((SquareImageView)localObject2).setVisibility(0);
        if (((ImageItem)localObject4).b == 2) {
          ((ImageView)localObject3).setVisibility(0);
        } else {
          ((ImageView)localObject3).setVisibility(8);
        }
        if ((i == m - 1) && (paramNetSearchTemplateUpdatesItem.u > m))
        {
          ((ImageView)localObject3).setVisibility(8);
          ((SquareImageView)localObject2).setFilterColor(Color.parseColor("#66000000"));
          k = paramNetSearchTemplateUpdatesItem.u - m;
          j = k;
          if (k > 99) {
            j = 99;
          }
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("+");
          ((StringBuilder)localObject3).append(j);
          ((SquareImageView)localObject2).setFilterText(((StringBuilder)localObject3).toString());
          ((SquareImageView)localObject2).setFilterTextSize(DisplayUtil.a(((SquareImageView)localObject2).getContext(), 20.0F));
        }
        else
        {
          ((SquareImageView)localObject2).setFilterColor(-1);
          ((SquareImageView)localObject2).setFilterText("");
        }
        i += 1;
      }
      while (j < m)
      {
        paramNetSearchTemplateUpdatesView.d.getChildAt(j).setVisibility(4);
        j += 1;
      }
    }
    paramNetSearchTemplateUpdatesView.p.setVisibility(8);
    paramNetSearchTemplateUpdatesView.d.setVisibility(8);
  }
  
  private void a(SquareImageView paramSquareImageView, int paramInt1, int paramInt2, String paramString)
  {
    if (paramSquareImageView != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      Object localObject = this.b;
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
      localObject = paramSquareImageView.getLayoutParams();
      Context localContext = paramSquareImageView.getContext();
      float f1 = paramInt1;
      ((ViewGroup.LayoutParams)localObject).width = DisplayUtil.a(localContext, f1);
      localObject = paramSquareImageView.getLayoutParams();
      localContext = paramSquareImageView.getContext();
      float f2 = paramInt2;
      ((ViewGroup.LayoutParams)localObject).height = DisplayUtil.a(localContext, f2);
      paramSquareImageView.setImageScale(f1 / f2, 0.0F);
      localURLDrawableOptions.mRequestWidth = paramSquareImageView.getLayoutParams().width;
      localURLDrawableOptions.mRequestHeight = paramSquareImageView.getLayoutParams().height;
      paramSquareImageView.setImageDrawable(URLDrawable.getDrawable(paramString, localURLDrawableOptions));
    }
  }
  
  private void a(SquareImageView paramSquareImageView, String paramString)
  {
    if (paramSquareImageView != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      ColorDrawable localColorDrawable = this.b;
      localURLDrawableOptions.mFailedDrawable = localColorDrawable;
      localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
      localURLDrawableOptions.mRequestWidth = paramSquareImageView.getLayoutParams().width;
      localURLDrawableOptions.mRequestHeight = paramSquareImageView.getLayoutParams().height;
      paramSquareImageView.setImageDrawable(URLDrawable.getDrawable(paramString, localURLDrawableOptions));
    }
  }
  
  private boolean a()
  {
    boolean bool = "true".equals(AVBizModuleFactory.getModuleByName("默认").checkAVFocus()) ^ true;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isAudioBusy=");
    localStringBuilder.append(bool);
    QLog.i("Q.uniteSearch.SearchTemplatePresenter", 1, localStringBuilder.toString());
    return bool;
  }
  
  private int b(NetSearchTemplateUniversalItem paramNetSearchTemplateUniversalItem, NetSearchTemplateUniversalView paramNetSearchTemplateUniversalView)
  {
    if ((paramNetSearchTemplateUniversalItem != null) && (paramNetSearchTemplateUniversalItem.a != null) && (paramNetSearchTemplateUniversalView != null) && (paramNetSearchTemplateUniversalView.a != null))
    {
      int i = paramNetSearchTemplateUniversalItem.a.a;
      int k = 1;
      if (i == 1)
      {
        if (paramNetSearchTemplateUniversalView.b != null) {
          paramNetSearchTemplateUniversalView.b.setVisibility(8);
        }
        if (paramNetSearchTemplateUniversalView.c != null) {
          paramNetSearchTemplateUniversalView.c.setVisibility(8);
        }
        return 0;
      }
      boolean bool1 = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
      Context localContext = paramNetSearchTemplateUniversalView.a.getContext();
      if (paramNetSearchTemplateUniversalItem.a.a == 2)
      {
        if (paramNetSearchTemplateUniversalView.c != null) {
          paramNetSearchTemplateUniversalView.c.setVisibility(8);
        }
        if (paramNetSearchTemplateUniversalView.b == null) {
          return 0;
        }
        if (!TextUtils.isEmpty(paramNetSearchTemplateUniversalItem.a.b))
        {
          paramNetSearchTemplateUniversalView.b.setVisibility(0);
          paramNetSearchTemplateUniversalView.b.setText(paramNetSearchTemplateUniversalItem.a.b);
          paramNetSearchTemplateUniversalView.b.setOnClickListener(new SearchTemplatePresenter.7(this, localContext, paramNetSearchTemplateUniversalItem));
        }
        else
        {
          paramNetSearchTemplateUniversalView.b.setVisibility(8);
        }
        i = (int)(0 + (SearchUtils.a(paramNetSearchTemplateUniversalView.b, paramNetSearchTemplateUniversalItem.a.b) + DisplayUtil.a(localContext, 32.0F) + DisplayUtil.a(localContext, 15.0F)));
        if (bool1)
        {
          paramNetSearchTemplateUniversalView.b.setBackgroundResource(2130844395);
          paramNetSearchTemplateUniversalView.b.setTextColor(Color.parseColor("#6991B8"));
          return i;
        }
        paramNetSearchTemplateUniversalView.b.setBackgroundResource(2130844394);
        paramNetSearchTemplateUniversalView.b.setTextColor(Color.parseColor("#000000"));
        return i;
      }
      if (paramNetSearchTemplateUniversalItem.a.a == 3)
      {
        if (paramNetSearchTemplateUniversalView.b != null) {
          paramNetSearchTemplateUniversalView.b.setVisibility(8);
        }
        if (paramNetSearchTemplateUniversalView.a != null)
        {
          if (paramNetSearchTemplateUniversalView.c == null) {
            return 0;
          }
          int m = ((Integer)paramNetSearchTemplateUniversalView.h().getTag(2131449868)).intValue();
          SongInfo localSongInfo2 = new SongInfo();
          try
          {
            JSONObject localJSONObject = new JSONObject(paramNetSearchTemplateUniversalItem.o);
            localSongInfo2.d = localJSONObject.optString("audio_url");
            localSongInfo2.e = localJSONObject.optString("title");
            localSongInfo2.f = localJSONObject.optString("desc");
            localSongInfo2.g = localJSONObject.optString("image_url");
            boolean bool2 = TextUtils.isEmpty(localJSONObject.optString("id"));
            j = bool2 ^ true;
            if (j != 0) {}
            try
            {
              localSongInfo2.a = Long.parseLong(localJSONObject.optString("id"));
              int n = localJSONObject.optInt("playable");
              i = j;
              if (n != 1) {
                break label526;
              }
              i = k;
            }
            catch (Exception localException1) {}
            i = j;
          }
          catch (Exception localException2)
          {
            j = 0;
          }
          if (QLog.isColorLevel())
          {
            QLog.d("Q.uniteSearch.SearchTemplatePresenter", 2, localException2.toString());
            i = j;
          }
          label526:
          k = 0;
          int j = i;
          i = k;
          this.e = localSongInfo2.a;
          QQPlayerService.d(this);
          if (QQPlayerService.c() != 2)
          {
            SearchUtils.c = -1L;
          }
          else
          {
            SongInfo localSongInfo1 = QQPlayerService.g();
            if (localSongInfo1 != null) {
              SearchUtils.c = localSongInfo1.a;
            }
          }
          if (bool1)
          {
            if (this.e == SearchUtils.c) {
              paramNetSearchTemplateUniversalView.c.setImageResource(2130851721);
            } else {
              paramNetSearchTemplateUniversalView.c.setImageResource(2130851719);
            }
          }
          else if (this.e == SearchUtils.c) {
            paramNetSearchTemplateUniversalView.c.setImageResource(2130851720);
          } else {
            paramNetSearchTemplateUniversalView.c.setImageResource(2130851718);
          }
          if ((i != 0) && (j != 0) && (!TextUtils.isEmpty(localSongInfo2.d)))
          {
            paramNetSearchTemplateUniversalView.c.setVisibility(0);
            paramNetSearchTemplateUniversalView.a.setOnClickListener(new SearchTemplatePresenter.8(this, paramNetSearchTemplateUniversalView, m, localContext, bool1, localSongInfo2, paramNetSearchTemplateUniversalItem));
          }
          else
          {
            paramNetSearchTemplateUniversalView.c.setVisibility(8);
          }
          return DisplayUtil.a(localContext, 39.0F) + 0;
        }
        return 0;
      }
      paramNetSearchTemplateUniversalView.b.setVisibility(8);
      return 0;
    }
    if ((paramNetSearchTemplateUniversalView != null) && (paramNetSearchTemplateUniversalView.b != null)) {
      paramNetSearchTemplateUniversalView.b.setVisibility(8);
    }
    if ((paramNetSearchTemplateUniversalView != null) && (paramNetSearchTemplateUniversalView.c != null)) {
      paramNetSearchTemplateUniversalView.c.setVisibility(8);
    }
    return 0;
  }
  
  private void c(NetSearchTemplateUniversalItem paramNetSearchTemplateUniversalItem, NetSearchTemplateUniversalView paramNetSearchTemplateUniversalView)
  {
    if ((paramNetSearchTemplateUniversalItem != null) && (paramNetSearchTemplateUniversalItem.a != null) && (paramNetSearchTemplateUniversalView != null))
    {
      if (paramNetSearchTemplateUniversalView.z == null) {
        return;
      }
      Context localContext = paramNetSearchTemplateUniversalView.z.getContext();
      if ((paramNetSearchTemplateUniversalItem.a.a == 1) && (!TextUtils.isEmpty(paramNetSearchTemplateUniversalItem.a.b)))
      {
        paramNetSearchTemplateUniversalView.z.setVisibility(0);
        paramNetSearchTemplateUniversalView.z.setText(paramNetSearchTemplateUniversalItem.a.b);
        paramNetSearchTemplateUniversalView.z.setOnClickListener(new SearchTemplatePresenter.9(this, localContext, paramNetSearchTemplateUniversalItem));
        return;
      }
      paramNetSearchTemplateUniversalView.z.setVisibility(8);
      return;
    }
    if ((paramNetSearchTemplateUniversalView != null) && (paramNetSearchTemplateUniversalView.z != null)) {
      paramNetSearchTemplateUniversalView.z.setVisibility(8);
    }
  }
  
  public void a(Context paramContext, SquareImageView paramSquareImageView, ImageView paramImageView, TextView paramTextView, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return;
    case 8: 
      a(paramSquareImageView, paramImageView, paramTextView, DisplayUtil.a(paramContext, 100.0F), DisplayUtil.a(paramContext, 62.0F), false, paramString1, null, 0, false);
      return;
    case 7: 
      a(paramSquareImageView, paramImageView, paramTextView, DisplayUtil.a(paramContext, 100.0F), DisplayUtil.a(paramContext, 62.0F), false, paramString1, paramString2, 0, false);
      return;
    case 6: 
      paramInt1 = DisplayUtil.a(paramContext, 62.0F);
      a(paramSquareImageView, paramImageView, paramTextView, DisplayUtil.a(paramContext, 100.0F), paramInt1, false, paramString1, null, 2130843364, false);
      return;
    case 5: 
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, paramInt2, false, paramString1, null, 0, true);
      return;
    case 4: 
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, paramInt2, false, paramString1, null, 2130843364, false);
      return;
    case 3: 
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, paramInt2, false, paramString1, null, 2130843364, false);
      return;
    case 2: 
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, (int)(paramInt2 * 1.4F), false, paramString1, null, 0, false);
      return;
    }
    a(paramSquareImageView, paramImageView, paramTextView, paramInt2, paramInt2, false, paramString1, null, 0, false);
  }
  
  public void a(ImageView paramImageView)
  {
    if (paramImageView == null) {
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(paramImageView.getContext(), 2130772315);
    if (localAnimation != null)
    {
      localAnimation.setInterpolator(new LinearInterpolator());
      paramImageView.startAnimation(localAnimation);
    }
  }
  
  public void a(TextView paramTextView, CharSequence paramCharSequence)
  {
    a(paramTextView, paramCharSequence, true);
  }
  
  public void a(TextView paramTextView, CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (!paramBoolean) {
      paramTextView.setEllipsize(null);
    }
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      paramTextView.setText(paramCharSequence);
      if (paramTextView.getVisibility() != 0) {
        paramTextView.setVisibility(0);
      }
    }
    else if (paramTextView.getVisibility() != 8)
    {
      paramTextView.setVisibility(8);
    }
  }
  
  public void a(NetSearchTemplateBaseItem paramNetSearchTemplateBaseItem, NetSearchTemplateBaseView paramNetSearchTemplateBaseView)
  {
    SearchViewUtils.a(paramNetSearchTemplateBaseItem.ck_(), paramNetSearchTemplateBaseItem.cl_(), paramNetSearchTemplateBaseView.h(), paramNetSearchTemplateBaseItem.r, paramNetSearchTemplateBaseItem.af, paramNetSearchTemplateBaseItem.ag);
    switch (paramNetSearchTemplateBaseItem.m())
    {
    case 5: 
    case 10: 
    default: 
      break;
    case 19: 
      a((NetSearchTemplateIndividuateContainerItem)paramNetSearchTemplateBaseItem, (NetSearchTemplateIndividuateContainerView)paramNetSearchTemplateBaseView);
      break;
    case 18: 
      a((NetSearchTemplateMiniAppItem)paramNetSearchTemplateBaseItem, (NetSearchTemplateMiniAppView)paramNetSearchTemplateBaseView);
      break;
    case 17: 
      a((NetSearchTemplateNewEntranceItem)paramNetSearchTemplateBaseItem, (NetSearchTemplateNewEntranceView)paramNetSearchTemplateBaseView);
      break;
    case 16: 
      a((NetSearchTemplateNetSeaEntranceItem)paramNetSearchTemplateBaseItem, (NetSearchTemplateNetSeaEntranceView)paramNetSearchTemplateBaseView);
      break;
    case 15: 
      a((NetSearchTemplateQAItem)paramNetSearchTemplateBaseItem, (NetSearchTemplateQAView)paramNetSearchTemplateBaseView);
      break;
    case 14: 
      a((NetSearchTemplateTitleItem)paramNetSearchTemplateBaseItem, (NetSearchTemplateTitleView)paramNetSearchTemplateBaseView);
      break;
    case 13: 
      a((NetSearchTemplateHorSlidingContainerItem)paramNetSearchTemplateBaseItem, (NetSearchTemplateHorSlidingContainerView)paramNetSearchTemplateBaseView);
      break;
    case 12: 
      a((NetSearchTemplateBigImageItem)paramNetSearchTemplateBaseItem, (NetSearchTemplateBigImageView)paramNetSearchTemplateBaseView);
      break;
    case 11: 
      a((NetSearchTemplateFriendUpdatesItem)paramNetSearchTemplateBaseItem, (NetSearchTemplateFriendUpdatesView)paramNetSearchTemplateBaseView);
      break;
    case 9: 
      a((NetSearchTemplateSubItemTitle)paramNetSearchTemplateBaseItem, (NetSearchTemplateSubItemTitleView)paramNetSearchTemplateBaseView);
      break;
    case 8: 
      a((NetSearchTemplateSubItem)paramNetSearchTemplateBaseItem, (NetSearchTemplateSubItemView)paramNetSearchTemplateBaseView);
      break;
    case 7: 
      a((NetSearchTemplateHorizontalContainerItem)paramNetSearchTemplateBaseItem, (NetSearchTemplateHorizontalContainerView)paramNetSearchTemplateBaseView);
      break;
    case 6: 
      a((NetSearchTemplateUniversalItem)paramNetSearchTemplateBaseItem, (NetSearchTemplateUniversalView)paramNetSearchTemplateBaseView);
      break;
    case 4: 
      a((NetSearchTemplateBannerTitleItem)paramNetSearchTemplateBaseItem, (NetSearchTemplateBannerTitleView)paramNetSearchTemplateBaseView);
      break;
    case 3: 
      a((NetSearchTemplateUpdatesItem)paramNetSearchTemplateBaseItem, (NetSearchTemplateUpdatesView)paramNetSearchTemplateBaseView);
      break;
    case 2: 
      a((NetSearchTemplateAvatarsItem)paramNetSearchTemplateBaseItem, (NetSearchTemplateAvatarsView)paramNetSearchTemplateBaseView);
    }
    b(paramNetSearchTemplateBaseItem, paramNetSearchTemplateBaseView);
    paramNetSearchTemplateBaseItem.o();
    if (TextUtils.isEmpty(paramNetSearchTemplateBaseItem.s)) {
      c(paramNetSearchTemplateBaseItem, paramNetSearchTemplateBaseView);
    }
  }
  
  public void a(NetSearchTemplateBaseItem paramNetSearchTemplateBaseItem, NetSearchTemplateBaseView paramNetSearchTemplateBaseView, Bitmap paramBitmap)
  {
    if (paramNetSearchTemplateBaseView.g() != null) {
      paramNetSearchTemplateBaseView.g().setImageBitmap(paramBitmap);
    }
  }
  
  protected void a(NetSearchTemplateQAItem paramNetSearchTemplateQAItem, NetSearchTemplateQAView paramNetSearchTemplateQAView)
  {
    Object localObject1 = paramNetSearchTemplateQAView.h().getContext();
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      paramNetSearchTemplateQAView.b.setTextColor(Color.parseColor("#737373"));
      paramNetSearchTemplateQAView.d.setTextColor(Color.parseColor("#4A4A4A"));
    }
    else
    {
      paramNetSearchTemplateQAView.b.setTextColor(Color.parseColor("#262626"));
      paramNetSearchTemplateQAView.d.setTextColor(Color.parseColor("#737373"));
    }
    Object localObject2;
    Object localObject3;
    if (!TextUtils.isEmpty(paramNetSearchTemplateQAItem.b))
    {
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      localObject3 = this.b;
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject3);
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject3);
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = DisplayUtil.a((Context)localObject1, 18.0F);
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = DisplayUtil.a((Context)localObject1, 18.0F);
      ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "askIcon";
      localObject2 = URLDrawable.getDrawable(paramNetSearchTemplateQAItem.b, (URLDrawable.URLDrawableOptions)localObject2);
      paramNetSearchTemplateQAView.a.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      paramNetSearchTemplateQAView.a.setVisibility(0);
    }
    else
    {
      paramNetSearchTemplateQAView.a.setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramNetSearchTemplateQAItem.c))
    {
      int j = paramNetSearchTemplateQAView.b.getContext().getResources().getDisplayMetrics().widthPixels;
      int i = (int)SearchUtils.a(paramNetSearchTemplateQAView.b, " ");
      int k = DisplayUtil.a((Context)localObject1, 22.0F) / i;
      localObject1 = "";
      i = 0;
      while (i < k)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" ");
        localObject1 = ((StringBuilder)localObject2).toString();
        i += 1;
      }
      localObject2 = paramNetSearchTemplateQAView.b;
      float f1 = j;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(paramNetSearchTemplateQAItem.c);
      localObject1 = SearchUtils.a((TextView)localObject2, f1, 2, ((StringBuilder)localObject3).toString(), paramNetSearchTemplateQAItem.n.a, false, false, true);
      paramNetSearchTemplateQAView.b.setText((CharSequence)localObject1);
    }
    paramNetSearchTemplateQAView.a(paramNetSearchTemplateQAItem);
    if ((!TextUtils.isEmpty(paramNetSearchTemplateQAItem.d)) && (paramNetSearchTemplateQAItem.e != null) && (paramNetSearchTemplateQAItem.e.size() != 0))
    {
      paramNetSearchTemplateQAView.d.setText(paramNetSearchTemplateQAItem.d);
      paramNetSearchTemplateQAView.d.setVisibility(0);
      return;
    }
    paramNetSearchTemplateQAView.d.setVisibility(8);
  }
  
  protected void a(NetSearchTemplateTitleItem paramNetSearchTemplateTitleItem, NetSearchTemplateTitleView paramNetSearchTemplateTitleView)
  {
    Object localObject;
    if (!TextUtils.isEmpty(paramNetSearchTemplateTitleItem.b))
    {
      paramNetSearchTemplateTitleView.a.setVisibility(0);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ColorDrawable localColorDrawable = this.b;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramNetSearchTemplateTitleView.a.getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramNetSearchTemplateTitleView.a.getLayoutParams().height;
      localObject = URLDrawable.getDrawable(paramNetSearchTemplateTitleItem.b, (URLDrawable.URLDrawableOptions)localObject);
      paramNetSearchTemplateTitleView.a.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
    }
    else
    {
      paramNetSearchTemplateTitleView.a.setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramNetSearchTemplateTitleItem.c))
    {
      paramNetSearchTemplateTitleView.b.setVisibility(0);
      int i = paramNetSearchTemplateTitleView.b.getContext().getResources().getDisplayMetrics().widthPixels;
      localObject = SearchUtils.a(paramNetSearchTemplateTitleView.b, i, 1, paramNetSearchTemplateTitleItem.c, paramNetSearchTemplateTitleItem.n.a, false, false, true);
      paramNetSearchTemplateTitleView.b.setText((CharSequence)localObject);
    }
    else
    {
      paramNetSearchTemplateTitleView.b.setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramNetSearchTemplateTitleItem.e))
    {
      paramNetSearchTemplateTitleView.c.setText(paramNetSearchTemplateTitleItem.e);
      paramNetSearchTemplateTitleView.c.setVisibility(0);
      paramNetSearchTemplateTitleView.d.setVisibility(0);
    }
    else
    {
      paramNetSearchTemplateTitleView.c.setVisibility(8);
      paramNetSearchTemplateTitleView.d.setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramNetSearchTemplateTitleItem.d))
    {
      paramNetSearchTemplateTitleView.n.setText(paramNetSearchTemplateTitleItem.d);
      paramNetSearchTemplateTitleView.n.setVisibility(0);
    }
    else
    {
      paramNetSearchTemplateTitleView.n.setVisibility(8);
    }
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      paramNetSearchTemplateTitleView.b.setTextColor(paramNetSearchTemplateTitleView.b.getContext().getResources().getColor(2131167917));
      paramNetSearchTemplateTitleView.n.setTextColor(paramNetSearchTemplateTitleView.n.getContext().getResources().getColor(2131167916));
      paramNetSearchTemplateTitleView.c.setTextColor(paramNetSearchTemplateTitleView.c.getContext().getResources().getColor(2131167916));
      return;
    }
    paramNetSearchTemplateTitleView.b.setTextColor(Color.parseColor("#262626"));
    paramNetSearchTemplateTitleView.n.setTextColor(Color.parseColor("#737373"));
    paramNetSearchTemplateTitleView.c.setTextColor(Color.parseColor("#737373"));
  }
  
  protected void a(NetSearchTemplateHorSlidingContainerItem paramNetSearchTemplateHorSlidingContainerItem, NetSearchTemplateHorSlidingContainerView paramNetSearchTemplateHorSlidingContainerView)
  {
    if ((paramNetSearchTemplateHorSlidingContainerItem.v != null) && (paramNetSearchTemplateHorSlidingContainerItem.v.size() != 0))
    {
      SearchTemplateHorSlidingDataAdapter localSearchTemplateHorSlidingDataAdapter2 = (SearchTemplateHorSlidingDataAdapter)paramNetSearchTemplateHorSlidingContainerView.a.getAdapter();
      SearchTemplateHorSlidingDataAdapter localSearchTemplateHorSlidingDataAdapter1;
      if (localSearchTemplateHorSlidingDataAdapter2 != null)
      {
        localSearchTemplateHorSlidingDataAdapter1 = localSearchTemplateHorSlidingDataAdapter2;
        if (localSearchTemplateHorSlidingDataAdapter2.a() == paramNetSearchTemplateHorSlidingContainerItem.v) {}
      }
      else
      {
        localSearchTemplateHorSlidingDataAdapter1 = new SearchTemplateHorSlidingDataAdapter(paramNetSearchTemplateHorSlidingContainerItem, this.g.b, paramNetSearchTemplateHorSlidingContainerView.a);
        paramNetSearchTemplateHorSlidingContainerView.a.setAdapter(localSearchTemplateHorSlidingDataAdapter1);
      }
      if (localSearchTemplateHorSlidingDataAdapter1.a() != paramNetSearchTemplateHorSlidingContainerItem.v)
      {
        paramNetSearchTemplateHorSlidingContainerView.b = paramNetSearchTemplateHorSlidingContainerItem;
        paramNetSearchTemplateHorSlidingContainerView.a.resetCurrentX(paramNetSearchTemplateHorSlidingContainerItem.w);
      }
      localSearchTemplateHorSlidingDataAdapter1.a(paramNetSearchTemplateHorSlidingContainerItem.v);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bindHorSlidingContainerTemplateView, containerItem.horizontalModelItems is empty");
    }
  }
  
  protected void a(NetSearchTemplateHorizontalContainerItem paramNetSearchTemplateHorizontalContainerItem, NetSearchTemplateHorizontalContainerView paramNetSearchTemplateHorizontalContainerView)
  {
    paramNetSearchTemplateHorizontalContainerView.h().getContext();
    paramNetSearchTemplateHorizontalContainerView.h();
    if ((paramNetSearchTemplateHorizontalContainerItem.c != null) && (paramNetSearchTemplateHorizontalContainerItem.c.size() != 0))
    {
      paramNetSearchTemplateHorizontalContainerView.a(paramNetSearchTemplateHorizontalContainerItem);
      if (paramNetSearchTemplateHorizontalContainerItem.c.size() != paramNetSearchTemplateHorizontalContainerView.a.size()) {
        QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bindHorizontalContainerTemplateView, view.size != model.size");
      }
      int j = paramNetSearchTemplateHorizontalContainerItem.c.size();
      int i = 0;
      while (i < j)
      {
        ((NetSearchTemplateHorizontalBaseItem)paramNetSearchTemplateHorizontalContainerItem.c.get(i)).a((NetSearchTemplateHorizontalBaseView)paramNetSearchTemplateHorizontalContainerView.a.get(i));
        i += 1;
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bindHorizontalContainerTemplateView, containerItem.horizontalModelItems is empty");
    }
  }
  
  protected void a(NetSearchTemplateIndividuateContainerItem paramNetSearchTemplateIndividuateContainerItem, NetSearchTemplateIndividuateContainerView paramNetSearchTemplateIndividuateContainerView)
  {
    if ((paramNetSearchTemplateIndividuateContainerItem.a != null) && (paramNetSearchTemplateIndividuateContainerItem.a.size() != 0))
    {
      paramNetSearchTemplateIndividuateContainerView.a(paramNetSearchTemplateIndividuateContainerItem);
      if (paramNetSearchTemplateIndividuateContainerItem.a.size() != paramNetSearchTemplateIndividuateContainerView.a.size()) {
        QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bindIndividualContainerTemplateView, vas_search, view.size != model.size");
      }
      int j = paramNetSearchTemplateIndividuateContainerItem.a.size();
      int i = 0;
      while (i < j)
      {
        ((NetSearchTemplateHorizontalBaseItem)paramNetSearchTemplateIndividuateContainerItem.a.get(i)).a((NetSearchTemplateHorizontalBaseView)paramNetSearchTemplateIndividuateContainerView.a.get(i));
        i += 1;
      }
      paramNetSearchTemplateIndividuateContainerItem.b(j);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bindIndividualContainerTemplateView, vas_search, containerItem.horizontalModelItems is empty");
    }
  }
  
  protected void a(NetSearchTemplateMiniAppItem paramNetSearchTemplateMiniAppItem, NetSearchTemplateMiniAppView paramNetSearchTemplateMiniAppView)
  {
    Object localObject1 = (LinearLayout)paramNetSearchTemplateMiniAppView.j();
    if ((localObject1 != null) && (paramNetSearchTemplateMiniAppItem.a != null))
    {
      ((LinearLayout)localObject1).removeAllViews();
      if (((LinearLayout)localObject1).getParent() != null) {
        ((View)((LinearLayout)localObject1).getParent()).setPadding(0, 0, 0, 0);
      }
      MiniProgramSearchResultModel localMiniProgramSearchResultModel = paramNetSearchTemplateMiniAppItem.a;
      paramNetSearchTemplateMiniAppItem = paramNetSearchTemplateMiniAppView.h().getContext();
      Object localObject2 = LayoutInflater.from(paramNetSearchTemplateMiniAppItem).inflate(2131629244, null);
      MiniProgramSearchResultView localMiniProgramSearchResultView = new MiniProgramSearchResultView((View)localObject2);
      Object localObject3 = ((View)localObject2).findViewById(2131435970);
      int i = ViewUtils.dip2px(6.0F);
      ((View)localObject3).setPadding(0, i, 0, i);
      ((LinearLayout)localObject1).addView((View)localObject2);
      if (localMiniProgramSearchResultModel.a() == null)
      {
        if (localMiniProgramSearchResultView.d() != null) {
          localMiniProgramSearchResultView.d().setVisibility(8);
        }
        if (localMiniProgramSearchResultView.b() != null) {
          localMiniProgramSearchResultView.b().setVisibility(8);
        }
        localObject1 = localMiniProgramSearchResultView.k();
        if (localObject1 != null) {
          ((URLImageView)localObject1).setVisibility(8);
        }
        localObject1 = localMiniProgramSearchResultView.j();
        if (localObject1 != null)
        {
          ((TextView)localObject1).setVisibility(0);
          if (!TextUtils.isEmpty(localMiniProgramSearchResultModel.d())) {
            ((TextView)localObject1).setText(localMiniProgramSearchResultModel.d());
          }
        }
      }
      else
      {
        if ((localMiniProgramSearchResultView.d() != null) && (!TextUtils.isEmpty(localMiniProgramSearchResultModel.a())))
        {
          localMiniProgramSearchResultView.d().setVisibility(0);
          localMiniProgramSearchResultView.d().setText(localMiniProgramSearchResultModel.a());
        }
        else if (localMiniProgramSearchResultView.d() != null)
        {
          localMiniProgramSearchResultView.d().setVisibility(8);
        }
        if (localMiniProgramSearchResultView.b() != null) {
          localMiniProgramSearchResultView.b().setVisibility(0);
        }
        localObject1 = localMiniProgramSearchResultView.j();
        if (localObject1 != null) {
          ((TextView)localObject1).setVisibility(8);
        }
        if (!TextUtils.isEmpty(localMiniProgramSearchResultModel.d())) {
          localMiniProgramSearchResultView.b().setText(localMiniProgramSearchResultModel.d());
        }
      }
      if ((localMiniProgramSearchResultView.g() != null) && (!TextUtils.isEmpty(localMiniProgramSearchResultModel.t())))
      {
        localObject1 = localMiniProgramSearchResultModel.t();
        localObject2 = new ColorDrawable(Color.parseColor("#e7e7e7"));
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = DisplayUtil.a(paramNetSearchTemplateMiniAppItem, 50.0F);
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = DisplayUtil.a(paramNetSearchTemplateMiniAppItem, 50.0F);
        ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject2);
        ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject2);
        if (URLUtil.e((String)localObject1))
        {
          localObject1 = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject3);
          ((URLDrawable)localObject1).setTag(URLDrawableDecodeHandler.b(DisplayUtil.a(paramNetSearchTemplateMiniAppItem, 50.0F), DisplayUtil.a(paramNetSearchTemplateMiniAppView.h().getContext(), 50.0F), DisplayUtil.a(paramNetSearchTemplateMiniAppItem, 3.0F)));
          ((URLDrawable)localObject1).setDecodeHandler(URLDrawableDecodeHandler.j);
          localMiniProgramSearchResultView.g().setImageDrawable((Drawable)localObject1);
          if ((((URLDrawable)localObject1).getStatus() != 1) && (((URLDrawable)localObject1).getStatus() != 0)) {
            ((URLDrawable)localObject1).restartDownload();
          }
        }
        else
        {
          localMiniProgramSearchResultView.g().setImageDrawable((Drawable)localObject2);
        }
      }
      localMiniProgramSearchResultView.h().setOnClickListener(new SearchTemplatePresenter.2(this, localMiniProgramSearchResultModel));
      if ((localMiniProgramSearchResultView.k() != null) && (localMiniProgramSearchResultModel.x()))
      {
        paramNetSearchTemplateMiniAppView = localMiniProgramSearchResultModel.w();
        localObject1 = new ColorDrawable(Color.parseColor("#e7e7e7"));
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = DisplayUtil.a(paramNetSearchTemplateMiniAppItem, 40.0F);
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = DisplayUtil.a(paramNetSearchTemplateMiniAppItem, 12.0F);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
        paramNetSearchTemplateMiniAppView = URLDrawable.getDrawable(paramNetSearchTemplateMiniAppView, (URLDrawable.URLDrawableOptions)localObject2);
        paramNetSearchTemplateMiniAppView.setTag(URLDrawableDecodeHandler.b(DisplayUtil.a(paramNetSearchTemplateMiniAppItem, 38.0F), DisplayUtil.a(paramNetSearchTemplateMiniAppItem, 12.0F), 0));
        paramNetSearchTemplateMiniAppView.setDecodeHandler(URLDrawableDecodeHandler.j);
        localMiniProgramSearchResultView.k().setImageDrawable(paramNetSearchTemplateMiniAppView);
        if ((paramNetSearchTemplateMiniAppView.getStatus() != 1) && (paramNetSearchTemplateMiniAppView.getStatus() != 0)) {
          paramNetSearchTemplateMiniAppView.restartDownload();
        }
      }
      paramNetSearchTemplateMiniAppItem = new SimpleMiniAppConfig.SimpleMiniAppInfo();
      paramNetSearchTemplateMiniAppItem.appId = localMiniProgramSearchResultModel.a.appId;
      paramNetSearchTemplateMiniAppView = new SimpleMiniAppConfig(paramNetSearchTemplateMiniAppItem);
      if (localMiniProgramSearchResultModel.a.showMask == 1) {
        paramNetSearchTemplateMiniAppItem = "used";
      } else {
        paramNetSearchTemplateMiniAppItem = "unused";
      }
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).report4239Async(paramNetSearchTemplateMiniAppView, "search", "result_view", paramNetSearchTemplateMiniAppItem, localMiniProgramSearchResultModel.g());
    }
  }
  
  public void a(SquareImageView paramSquareImageView, ImageView paramImageView, TextView paramTextView, int paramInt1, int paramInt2, boolean paramBoolean1, String paramString1, String paramString2, int paramInt3, boolean paramBoolean2)
  {
    ViewGroup.LayoutParams localLayoutParams = paramSquareImageView.getLayoutParams();
    if ((paramSquareImageView.getContext() instanceof PublicAcntSearchActivity))
    {
      localLayoutParams.width = DisplayUtil.a(paramSquareImageView.getContext(), 50.0F);
      localLayoutParams.height = DisplayUtil.a(paramSquareImageView.getContext(), 50.0F);
    }
    else
    {
      localLayoutParams.width = paramInt1;
      localLayoutParams.height = paramInt2;
    }
    paramSquareImageView.setLayoutParams(localLayoutParams);
    if (paramInt2 != 0) {
      paramSquareImageView.setImageScale(paramInt1 * 1.0F / paramInt2, 0.0F);
    } else {
      paramSquareImageView.setImageScale(1.0F, 0.0F);
    }
    if (paramBoolean1) {
      paramSquareImageView.setFilterColor(Color.parseColor("#66000000"));
    } else {
      paramSquareImageView.setFilterColor(-1);
    }
    if (paramInt3 != 0)
    {
      paramImageView.setImageResource(paramInt3);
      paramImageView.setVisibility(0);
    }
    else
    {
      paramImageView.setVisibility(8);
    }
    if ((paramString2 != null) && (!TextUtils.isEmpty(paramString2)))
    {
      paramTextView.setVisibility(0);
      paramTextView.setText(paramString2);
    }
    else
    {
      paramTextView.setVisibility(8);
    }
    paramImageView = this.b;
    paramImageView.setBounds(0, 0, paramInt1, paramInt2);
    paramString2 = paramImageView;
    try
    {
      if (TextUtils.isEmpty(paramString1)) {
        break label365;
      }
      paramTextView = URLDrawable.URLDrawableOptions.obtain();
      paramTextView.mRequestWidth = paramInt1;
      paramTextView.mRequestHeight = paramInt2;
      paramTextView.mFailedDrawable = this.b;
      paramTextView.mLoadingDrawable = this.b;
      if (paramBoolean2)
      {
        paramTextView.mMemoryCacheKeySuffix = "isAvatar";
        paramString2 = URLDrawable.getDrawable(paramString1, paramTextView);
        paramString2.setDecodeHandler(URLDrawableDecodeHandler.b);
        paramTextView = paramString2;
        paramImageView = paramString2;
      }
      else
      {
        paramTextView.mMemoryCacheKeySuffix = "isNotAvatar";
        paramTextView = URLDrawable.getDrawable(paramString1, paramTextView);
      }
      paramString2 = paramTextView;
      try
      {
        if (paramTextView.getStatus() == 1) {
          break label365;
        }
        paramString2 = paramTextView;
        if (paramTextView.getStatus() == 0) {
          break label365;
        }
        paramTextView.restartDownload();
        paramString2 = paramTextView;
      }
      catch (Exception paramTextView) {}
      paramString2 = new StringBuilder();
    }
    catch (Exception paramTextView) {}
    paramString2.append("imageUrl is not valid. imageUrl=");
    paramString2.append(paramString1);
    QLog.e("Q.uniteSearch.SearchTemplatePresenter", 1, paramString2.toString(), paramTextView);
    paramString2 = paramImageView;
    label365:
    paramSquareImageView.setImageDrawable(paramString2);
  }
  
  protected void b(NetSearchTemplateBaseItem paramNetSearchTemplateBaseItem, NetSearchTemplateBaseView paramNetSearchTemplateBaseView)
  {
    if (paramNetSearchTemplateBaseView.h() != null) {
      paramNetSearchTemplateBaseView.h().setOnClickListener(new SearchTemplatePresenter.1(this, paramNetSearchTemplateBaseItem));
    }
  }
  
  public void c(NetSearchTemplateBaseItem paramNetSearchTemplateBaseItem, NetSearchTemplateBaseView paramNetSearchTemplateBaseView)
  {
    if ((paramNetSearchTemplateBaseView.g() != null) && ((paramNetSearchTemplateBaseItem instanceof IFaceModel)) && (!TextUtils.isEmpty(paramNetSearchTemplateBaseItem.c()))) {
      paramNetSearchTemplateBaseView.g().setImageDrawable(SearchUtils.a(this.d, paramNetSearchTemplateBaseItem));
    }
  }
  
  public String getToken()
  {
    return QQPlayerService.a(7, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentUin());
  }
  
  public void onPlaySongChanged(SongInfo paramSongInfo) {}
  
  public void onPlayStateChanged(int paramInt)
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      if (((WeakReference)localObject).get() == null) {
        return;
      }
      localObject = (ImageView)this.f.get();
      if (localObject == null) {
        return;
      }
      boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
      Resources localResources = ((ImageView)localObject).getContext().getResources();
      if (paramInt == 1)
      {
        ((ImageView)localObject).post(new SearchTemplatePresenter.10(this, bool, (ImageView)localObject));
        return;
      }
      if (paramInt == 2)
      {
        ((ImageView)localObject).getContext();
        ((Integer)((ImageView)localObject).getTag()).intValue();
        SearchUtils.c = this.e;
        ((ImageView)localObject).post(new SearchTemplatePresenter.11(this, (ImageView)localObject, bool));
        ((ImageView)localObject).setContentDescription(localResources.getString(2131887113));
        this.g.notifyDataSetChanged();
        return;
      }
      ((ImageView)localObject).post(new SearchTemplatePresenter.12(this, (ImageView)localObject, bool));
      ((ImageView)localObject).setContentDescription(localResources.getString(2131887111));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.SearchTemplatePresenter
 * JD-Core Version:    0.7.0.1
 */