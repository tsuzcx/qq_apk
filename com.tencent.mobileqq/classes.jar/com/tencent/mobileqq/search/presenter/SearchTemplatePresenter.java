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
  private long jdField_a_of_type_Long;
  public ColorDrawable a;
  public Drawable a;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private GroupSearchAdapter jdField_a_of_type_ComTencentMobileqqSearchAdapterGroupSearchAdapter;
  private WeakReference<ImageView> jdField_a_of_type_JavaLangRefWeakReference;
  
  public SearchTemplatePresenter(IFaceDecoder paramIFaceDecoder, GroupSearchAdapter paramGroupSearchAdapter)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = URLDrawableHelperConstants.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = paramIFaceDecoder;
    this.jdField_a_of_type_ComTencentMobileqqSearchAdapterGroupSearchAdapter = paramGroupSearchAdapter;
  }
  
  private float a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      return 3.5F;
    }
    return 7.0F;
  }
  
  private int a(NetSearchTemplateUniversalItem paramNetSearchTemplateUniversalItem, NetSearchTemplateUniversalView paramNetSearchTemplateUniversalView)
  {
    if ((paramNetSearchTemplateUniversalItem != null) && (paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateUniversalItem$ActionInfo != null) && (paramNetSearchTemplateUniversalView != null) && (paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetRelativeLayout != null))
    {
      int i = paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateUniversalItem$ActionInfo.jdField_a_of_type_Int;
      int k = 1;
      if (i == 1)
      {
        if (paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetButton != null) {
          paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        }
        if (paramNetSearchTemplateUniversalView.jdField_c_of_type_AndroidWidgetImageView != null) {
          paramNetSearchTemplateUniversalView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        return 0;
      }
      boolean bool1 = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
      Context localContext = paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext();
      if (paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateUniversalItem$ActionInfo.jdField_a_of_type_Int == 2)
      {
        if (paramNetSearchTemplateUniversalView.jdField_c_of_type_AndroidWidgetImageView != null) {
          paramNetSearchTemplateUniversalView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        if (paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetButton == null) {
          return 0;
        }
        if (!TextUtils.isEmpty(paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateUniversalItem$ActionInfo.jdField_a_of_type_JavaLangCharSequence))
        {
          paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
          paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetButton.setText(paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateUniversalItem$ActionInfo.jdField_a_of_type_JavaLangCharSequence);
          paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new SearchTemplatePresenter.7(this, localContext, paramNetSearchTemplateUniversalItem));
        }
        else
        {
          paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        }
        i = (int)(0 + (SearchUtils.a(paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetButton, paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateUniversalItem$ActionInfo.jdField_a_of_type_JavaLangCharSequence) + DisplayUtil.a(localContext, 32.0F) + DisplayUtil.a(localContext, 15.0F)));
        if (bool1)
        {
          paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130843441);
          paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#6991B8"));
          return i;
        }
        paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130843440);
        paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#000000"));
        return i;
      }
      if (paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateUniversalItem$ActionInfo.jdField_a_of_type_Int == 3)
      {
        if (paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetButton != null) {
          paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        }
        if (paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
        {
          if (paramNetSearchTemplateUniversalView.jdField_c_of_type_AndroidWidgetImageView == null) {
            return 0;
          }
          int m = ((Integer)paramNetSearchTemplateUniversalView.a().getTag(2131380885)).intValue();
          SongInfo localSongInfo2 = new SongInfo();
          try
          {
            JSONObject localJSONObject = new JSONObject(paramNetSearchTemplateUniversalItem.h);
            localSongInfo2.jdField_b_of_type_JavaLangString = localJSONObject.optString("audio_url");
            localSongInfo2.jdField_c_of_type_JavaLangString = localJSONObject.optString("title");
            localSongInfo2.d = localJSONObject.optString("desc");
            localSongInfo2.e = localJSONObject.optString("image_url");
            boolean bool2 = TextUtils.isEmpty(localJSONObject.optString("id"));
            j = bool2 ^ true;
            if (j != 0) {}
            try
            {
              localSongInfo2.jdField_a_of_type_Long = Long.parseLong(localJSONObject.optString("id"));
              int n = localJSONObject.optInt("playable");
              i = j;
              if (n != 1) {
                break label511;
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
          label511:
          k = 0;
          int j = i;
          i = k;
          this.jdField_a_of_type_Long = localSongInfo2.jdField_a_of_type_Long;
          QQPlayerService.a(this);
          if (QQPlayerService.a() != 2)
          {
            SearchUtils.jdField_a_of_type_Long = -1L;
          }
          else
          {
            SongInfo localSongInfo1 = QQPlayerService.b();
            if (localSongInfo1 != null) {
              SearchUtils.jdField_a_of_type_Long = localSongInfo1.jdField_a_of_type_Long;
            }
          }
          if (bool1)
          {
            if (this.jdField_a_of_type_Long == SearchUtils.jdField_a_of_type_Long) {
              paramNetSearchTemplateUniversalView.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130849965);
            } else {
              paramNetSearchTemplateUniversalView.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130849963);
            }
          }
          else if (this.jdField_a_of_type_Long == SearchUtils.jdField_a_of_type_Long) {
            paramNetSearchTemplateUniversalView.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130849964);
          } else {
            paramNetSearchTemplateUniversalView.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130849962);
          }
          if ((i != 0) && (j != 0) && (!TextUtils.isEmpty(localSongInfo2.jdField_b_of_type_JavaLangString)))
          {
            paramNetSearchTemplateUniversalView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
            paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new SearchTemplatePresenter.8(this, paramNetSearchTemplateUniversalView, m, localContext, bool1, localSongInfo2, paramNetSearchTemplateUniversalItem));
          }
          else
          {
            paramNetSearchTemplateUniversalView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          }
          return DisplayUtil.a(localContext, 39.0F) + 0;
        }
        return 0;
      }
      paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      return 0;
    }
    if ((paramNetSearchTemplateUniversalView != null) && (paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetButton != null)) {
      paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
    if ((paramNetSearchTemplateUniversalView != null) && (paramNetSearchTemplateUniversalView.jdField_c_of_type_AndroidWidgetImageView != null)) {
      paramNetSearchTemplateUniversalView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    return 0;
  }
  
  private int a(NetSearchTemplateUniversalItem paramNetSearchTemplateUniversalItem, NetSearchTemplateUniversalView paramNetSearchTemplateUniversalView, int paramInt1, int paramInt2)
  {
    if ((paramNetSearchTemplateUniversalView != null) && (paramNetSearchTemplateUniversalItem != null))
    {
      if (paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
        return 0;
      }
      Context localContext = paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetLinearLayout.getContext();
      int i = localContext.getResources().getDisplayMetrics().widthPixels - paramInt1 - paramInt2 - DisplayUtil.a(localContext, 30.0F);
      Object localObject;
      if ((paramNetSearchTemplateUniversalItem.jdField_a_of_type_JavaUtilArrayList != null) && (paramNetSearchTemplateUniversalItem.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        if ((paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateUniversalItem$HeadIconInfo != null) && (paramNetSearchTemplateUniversalItem.jdField_a_of_type_JavaUtilArrayList != null) && (paramNetSearchTemplateUniversalItem.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          if (paramNetSearchTemplateUniversalView.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView != null) {
            paramNetSearchTemplateUniversalView.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(8);
          }
          if (paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_a_of_type_Int == 1)
          {
            if (paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetTextView != null) {
              paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
            }
            if ((paramNetSearchTemplateUniversalView.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView != null) && (!TextUtils.isEmpty(paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_a_of_type_JavaLangString)))
            {
              paramNetSearchTemplateUniversalView.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(0);
              a(paramNetSearchTemplateUniversalView.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView, paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_a_of_type_JavaLangString);
              paramInt1 = DisplayUtil.a(localContext, 24.0F);
            }
          }
          else
          {
            for (;;)
            {
              paramInt1 = i - paramInt1;
              break label522;
              if (paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_a_of_type_Int == 2)
              {
                if (paramNetSearchTemplateUniversalView.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView != null) {
                  paramNetSearchTemplateUniversalView.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(8);
                }
                if ((paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetTextView == null) || (TextUtils.isEmpty(paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_a_of_type_JavaLangCharSequence))) {
                  break;
                }
                if (SearchUtils.b(paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_b_of_type_JavaLangString)) {
                  localObject = paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_b_of_type_JavaLangString;
                } else {
                  localObject = "#fd7f32";
                }
                ((GradientDrawable)paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetTextView.getBackground()).setColor(Color.parseColor((String)localObject));
                paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetTextView.setText(paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_a_of_type_JavaLangCharSequence);
                paramInt1 = (int)(i - (SearchUtils.a(paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetTextView, paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_a_of_type_JavaLangCharSequence) + DisplayUtil.a(localContext, 10.0F)));
                break label522;
              }
              if (paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_a_of_type_Int != 3) {
                break;
              }
              if (paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetTextView != null) {
                paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
              }
              if ((paramNetSearchTemplateUniversalView.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView == null) || (TextUtils.isEmpty(paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_a_of_type_JavaLangString))) {
                break;
              }
              paramNetSearchTemplateUniversalView.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(0);
              if ((paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_b_of_type_Int > 0) && (paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_c_of_type_Int > 0))
              {
                a(paramNetSearchTemplateUniversalView.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView, paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_b_of_type_Int, paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_c_of_type_Int, paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_a_of_type_JavaLangString);
                paramInt1 = DisplayUtil.a(localContext, DisplayUtil.a(localContext, paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_b_of_type_Int) + 4);
              }
              else
              {
                a(paramNetSearchTemplateUniversalView.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView, paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_a_of_type_JavaLangString);
                paramInt1 = DisplayUtil.a(localContext, 24.0F);
              }
            }
          }
          paramInt1 = i;
          label522:
          if ((paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(((NetSearchTemplateUniversalItem.NormalWord)paramNetSearchTemplateUniversalItem.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangCharSequence)))
          {
            localObject = ((NetSearchTemplateUniversalItem.NormalWord)paramNetSearchTemplateUniversalItem.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangCharSequence;
            if (((NetSearchTemplateUniversalItem.NormalWord)paramNetSearchTemplateUniversalItem.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Boolean) {
              localObject = SearchUtils.a(paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetTextView, paramInt1, 1, ((CharSequence)localObject).toString(), paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchUtilHighlightModel.jdField_a_of_type_JavaUtilList, false, false, true);
            } else {
              localObject = SearchUtils.a(paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetTextView, paramInt1, ((CharSequence)localObject).toString());
            }
            paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
          }
          paramInt1 = 1;
        }
        else
        {
          if (paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
            paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          }
          paramInt1 = 0;
        }
        if (paramNetSearchTemplateUniversalView.jdField_c_of_type_AndroidWidgetLinearLayout == null) {
          return paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetLinearLayout.getHeight();
        }
        paramNetSearchTemplateUniversalView.jdField_c_of_type_AndroidWidgetLinearLayout.removeAllViews();
        if ((paramNetSearchTemplateUniversalItem.jdField_a_of_type_JavaUtilArrayList == null) || (paramNetSearchTemplateUniversalItem.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {}
      }
      else
      {
        while (paramInt1 < paramNetSearchTemplateUniversalItem.jdField_a_of_type_JavaUtilArrayList.size())
        {
          NetSearchTemplateUniversalItem.NormalWord localNormalWord = (NetSearchTemplateUniversalItem.NormalWord)paramNetSearchTemplateUniversalItem.jdField_a_of_type_JavaUtilArrayList.get(paramInt1);
          TextView localTextView = new TextView(localContext);
          a(localTextView, localNormalWord.jdField_a_of_type_JavaLangString, localNormalWord.jdField_a_of_type_Int);
          CharSequence localCharSequence = localNormalWord.jdField_a_of_type_JavaLangCharSequence;
          if (!TextUtils.isEmpty(localCharSequence))
          {
            localObject = localCharSequence;
            if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
              localObject = localCharSequence.toString();
            }
            paramInt2 = localNormalWord.jdField_a_of_type_Int;
            if ((localContext instanceof PublicAcntSearchActivity)) {
              paramInt2 = 1;
            }
            if (localNormalWord.jdField_a_of_type_Boolean)
            {
              boolean bool;
              if ((!localNormalWord.jdField_a_of_type_JavaLangString.equals("A")) && (!localNormalWord.jdField_a_of_type_JavaLangString.equals("B"))) {
                bool = false;
              } else {
                bool = true;
              }
              localObject = SearchUtils.a(localTextView, i, paramInt2, ((CharSequence)localObject).toString(), paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchUtilHighlightModel.jdField_a_of_type_JavaUtilList, false, bool, true);
            }
            if (paramInt1 != 0) {
              localTextView.setPadding(0, DisplayUtil.a(localContext, 7.0F - a(((NetSearchTemplateUniversalItem.NormalWord)paramNetSearchTemplateUniversalItem.jdField_a_of_type_JavaUtilArrayList.get(paramInt1 - 1)).jdField_a_of_type_JavaLangString, localNormalWord.jdField_a_of_type_JavaLangString)), 0, 0);
            }
            localTextView.setText((CharSequence)localObject);
            paramNetSearchTemplateUniversalView.jdField_c_of_type_AndroidWidgetLinearLayout.addView(localTextView);
          }
          paramInt1 += 1;
          continue;
          paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
      }
      b(paramNetSearchTemplateUniversalItem, paramNetSearchTemplateUniversalView);
      paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0);
      paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 0);
      paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetLinearLayout.measure(paramInt1, paramInt2);
      return paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredHeight();
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
      if (!SearchUtils.b(paramString)) {
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
    if ((paramNetSearchTemplateBaseView != null) && (paramNetSearchTemplateBaseView.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (paramNetSearchTemplateBaseView.a != null) && (paramNetSearchTemplateBaseItem != null))
    {
      Object localObject1 = paramNetSearchTemplateBaseView.a;
      NetSearchTemplateBaseItem.ImageInfo localImageInfo = paramNetSearchTemplateBaseItem.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateBaseItem$ImageInfo;
      if ((localImageInfo != null) && (!TextUtils.isEmpty(localImageInfo.jdField_a_of_type_JavaLangString)))
      {
        paramNetSearchTemplateBaseView.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        localObject2 = ((SquareImageView)localObject1).getContext();
        paramNetSearchTemplateBaseItem = a((SquareImageView)localObject1, localImageInfo.jdField_a_of_type_Int, localImageInfo.jdField_a_of_type_JavaLangString, localImageInfo.jdField_b_of_type_Int, paramBoolean, paramInt, paramNetSearchTemplateBaseItem);
        paramInt = ((Integer)paramNetSearchTemplateBaseItem.first).intValue();
        int i = ((Integer)paramNetSearchTemplateBaseItem.second).intValue();
        paramNetSearchTemplateBaseItem = ((SquareImageView)localObject1).getLayoutParams();
        paramNetSearchTemplateBaseItem.width = paramInt;
        paramNetSearchTemplateBaseItem.height = i;
        ((SquareImageView)localObject1).setLayoutParams(paramNetSearchTemplateBaseItem);
        paramNetSearchTemplateBaseItem = (RelativeLayout.LayoutParams)paramNetSearchTemplateBaseView.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
        paramNetSearchTemplateBaseItem.width = paramInt;
        paramNetSearchTemplateBaseItem.height = i;
        paramNetSearchTemplateBaseView.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramNetSearchTemplateBaseItem);
        int j = DisplayUtil.a((Context)localObject2, 10.0F);
        if ((!TextUtils.isEmpty(localImageInfo.jdField_a_of_type_JavaLangCharSequence)) && (paramNetSearchTemplateBaseView.i != null))
        {
          if (SearchUtils.b(localImageInfo.jdField_b_of_type_JavaLangString)) {
            paramNetSearchTemplateBaseItem = localImageInfo.jdField_b_of_type_JavaLangString;
          } else {
            paramNetSearchTemplateBaseItem = "#fd7f32";
          }
          ((GradientDrawable)paramNetSearchTemplateBaseView.i.getBackground()).setColor(Color.parseColor(paramNetSearchTemplateBaseItem));
          paramNetSearchTemplateBaseView.i.setVisibility(0);
          paramNetSearchTemplateBaseView.i.setText(localImageInfo.jdField_a_of_type_JavaLangCharSequence);
        }
        else if (paramNetSearchTemplateBaseView.i != null)
        {
          paramNetSearchTemplateBaseView.i.setVisibility(8);
        }
        if (paramNetSearchTemplateBaseView.e != null) {
          if (localImageInfo.jdField_a_of_type_Boolean) {
            paramNetSearchTemplateBaseView.e.setVisibility(0);
          } else {
            paramNetSearchTemplateBaseView.e.setVisibility(8);
          }
        }
        if (paramNetSearchTemplateBaseView.j != null) {
          if (!TextUtils.isEmpty(localImageInfo.jdField_b_of_type_JavaLangCharSequence))
          {
            paramNetSearchTemplateBaseView.j.setVisibility(0);
            paramNetSearchTemplateBaseView.j.setText(localImageInfo.jdField_b_of_type_JavaLangCharSequence);
          }
          else
          {
            paramNetSearchTemplateBaseView.j.setVisibility(8);
          }
        }
        if (paramNetSearchTemplateBaseView.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView != null) {
          if (!TextUtils.isEmpty(localImageInfo.jdField_c_of_type_JavaLangString))
          {
            paramNetSearchTemplateBaseView.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(0);
            paramNetSearchTemplateBaseItem = URLDrawable.URLDrawableOptions.obtain();
            localObject1 = new ColorDrawable(-1);
            paramNetSearchTemplateBaseItem.mFailedDrawable = ((Drawable)localObject1);
            paramNetSearchTemplateBaseItem.mLoadingDrawable = ((Drawable)localObject1);
            paramNetSearchTemplateBaseItem.mRequestWidth = paramNetSearchTemplateBaseView.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView.getLayoutParams().width;
            paramNetSearchTemplateBaseItem.mRequestHeight = paramNetSearchTemplateBaseView.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView.getLayoutParams().height;
            paramNetSearchTemplateBaseItem = URLDrawable.getDrawable(localImageInfo.jdField_c_of_type_JavaLangString, paramNetSearchTemplateBaseItem);
            if ((paramNetSearchTemplateBaseItem.getStatus() != 1) && (paramNetSearchTemplateBaseItem.getStatus() != 0)) {
              paramNetSearchTemplateBaseItem.restartDownload();
            }
            paramNetSearchTemplateBaseView.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView.setImageDrawable(paramNetSearchTemplateBaseItem);
          }
          else
          {
            paramNetSearchTemplateBaseView.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(8);
          }
        }
        if (paramNetSearchTemplateBaseView.k != null) {
          if (!TextUtils.isEmpty(localImageInfo.jdField_c_of_type_JavaLangCharSequence))
          {
            paramNetSearchTemplateBaseView.k.setVisibility(0);
            paramNetSearchTemplateBaseView.k.setText(localImageInfo.jdField_c_of_type_JavaLangCharSequence);
          }
          else
          {
            paramNetSearchTemplateBaseView.k.setVisibility(8);
          }
        }
        return new Pair(Integer.valueOf(paramInt + j), Integer.valueOf(i));
      }
      paramNetSearchTemplateBaseView.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
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
            paramInt1 = DisplayUtil.a((Context)localObject2, paramNetSearchTemplateBaseItem.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateBaseItem$ImageInfo.jdField_c_of_type_Int / 2);
            paramInt3 = DisplayUtil.a((Context)localObject2, paramNetSearchTemplateBaseItem.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateBaseItem$ImageInfo.d / 2);
          }
          else
          {
            paramInt1 = 0;
            paramInt3 = 0;
          }
        } while ((paramInt2 == paramNetSearchTemplateBaseItem.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateBaseItem$ImageInfo.jdField_c_of_type_Int / 2) && (paramInt2 == paramNetSearchTemplateBaseItem.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateBaseItem$ImageInfo.d / 2));
      }
      localObject1 = new ColorDrawable(Color.parseColor("#e7e7e7"));
      if (paramBoolean)
      {
        f = paramInt3 * 1.0F / paramInt1;
        int k = (int)(i * f);
        paramInt1 = i;
        paramInt3 = k;
        if (j != 0)
        {
          double d = i;
          Double.isNaN(d);
          paramInt1 = (int)(d * 0.2D / 2.0D);
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
      float f = paramInt1;
      paramSquareImageView.setImageScale(1.0F * f / paramInt3, 0.0F);
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
            ((GradientDrawable)localObject2).setCornerRadius(f / 2.0F);
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
            paramNetSearchTemplateBaseItem.setDecodeHandler(URLDrawableDecodeHandler.a);
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
            paramNetSearchTemplateBaseItem.setDecodeHandler(URLDrawableDecodeHandler.i);
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
          paramTextView.setTextColor(localContext.getResources().getColor(2131167057));
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
          paramTextView.setTextColor(localContext.getResources().getColor(2131167057));
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
          paramTextView.setTextColor(localContext.getResources().getColor(2131167058));
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
          paramTextView.setTextColor(localContext.getResources().getColor(2131167058));
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
          paramTextView.setTextColor(localContext.getResources().getColor(2131167058));
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
        paramTextView.setTextColor(localContext.getResources().getColor(2131167206));
        return;
      }
      paramTextView.setTextSize(1, 17.0F);
      paramTextView.setTextColor(localContext.getResources().getColor(2131167063));
      paramTextView.setIncludeFontPadding(false);
    }
  }
  
  private void a(NetSearchTemplateAvatarsItem paramNetSearchTemplateAvatarsItem, NetSearchTemplateAvatarsView paramNetSearchTemplateAvatarsView)
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject3 = paramNetSearchTemplateAvatarsView.a().getContext();
    if (ThemeUtil.isNowThemeIsNight((AppRuntime)localObject1, false, null)) {
      paramNetSearchTemplateAvatarsView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
    } else {
      paramNetSearchTemplateAvatarsView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#262626"));
    }
    int i;
    Object localObject2;
    if (TextUtils.isEmpty(paramNetSearchTemplateAvatarsItem.jdField_a_of_type_JavaLangCharSequence))
    {
      paramNetSearchTemplateAvatarsView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    else
    {
      i = (int)(paramNetSearchTemplateAvatarsView.jdField_a_of_type_AndroidWidgetTextView.getContext().getResources().getDisplayMetrics().widthPixels - DisplayUtil.a(paramNetSearchTemplateAvatarsView.jdField_a_of_type_AndroidWidgetTextView.getContext(), 30.0F) - SearchUtils.a(paramNetSearchTemplateAvatarsView.jdField_a_of_type_AndroidWidgetTextView, paramNetSearchTemplateAvatarsItem.jdField_a_of_type_JavaLangString));
      localObject2 = SearchUtils.a(paramNetSearchTemplateAvatarsView.jdField_a_of_type_AndroidWidgetTextView, i, 1, paramNetSearchTemplateAvatarsItem.jdField_a_of_type_JavaLangCharSequence.toString(), paramNetSearchTemplateAvatarsItem.jdField_a_of_type_ComTencentMobileqqSearchUtilHighlightModel.jdField_a_of_type_JavaUtilList, false, false, true);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      if (paramNetSearchTemplateAvatarsItem.jdField_a_of_type_JavaLangString == null) {
        paramNetSearchTemplateAvatarsItem.jdField_a_of_type_JavaLangString = "";
      }
      paramNetSearchTemplateAvatarsView.jdField_a_of_type_AndroidWidgetTextView.setText(new SpannableStringBuilder((CharSequence)localObject1).append(paramNetSearchTemplateAvatarsItem.jdField_a_of_type_JavaLangString));
      paramNetSearchTemplateAvatarsView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    int m;
    int n;
    int j;
    Object localObject4;
    ColorDrawable localColorDrawable;
    int k;
    if (paramNetSearchTemplateAvatarsItem.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelImageItem != null)
    {
      paramNetSearchTemplateAvatarsView.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramNetSearchTemplateAvatarsView.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      i = (int)(DeviceInfoUtil.k() - UIUtils.a((Context)localObject3, 30.0F)) / 2 - UIUtils.a((Context)localObject3, 3.0F);
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = i;
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = i;
      localObject2 = URLDrawable.getDrawable(paramNetSearchTemplateAvatarsItem.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelImageItem.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject1);
      paramNetSearchTemplateAvatarsView.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      localObject2 = (LinearLayout.LayoutParams)paramNetSearchTemplateAvatarsView.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).height = i;
      ((LinearLayout.LayoutParams)localObject2).width = i;
      paramNetSearchTemplateAvatarsView.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      paramNetSearchTemplateAvatarsView.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      if (paramNetSearchTemplateAvatarsItem.jdField_a_of_type_JavaUtilList != null)
      {
        m = Math.min(paramNetSearchTemplateAvatarsItem.jdField_a_of_type_JavaUtilList.size(), 4);
        n = (i - UIUtils.a((Context)localObject3, 3.0F)) / 2;
        localObject2 = new int[4];
        Object tmp449_447 = localObject2;
        tmp449_447[0] = 2131368495;
        Object tmp455_449 = tmp449_447;
        tmp455_449[1] = 2131368496;
        Object tmp461_455 = tmp455_449;
        tmp461_455[2] = 2131368497;
        Object tmp467_461 = tmp461_455;
        tmp467_461[3] = 2131368498;
        tmp467_461;
        i = 0;
        for (;;)
        {
          j = i;
          if (i >= m) {
            break;
          }
          localObject3 = (SquareImageView)paramNetSearchTemplateAvatarsView.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(localObject2[i]);
          localObject4 = ((ImageItem)paramNetSearchTemplateAvatarsItem.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString;
          ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
          localColorDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
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
          if ((i == 3) && (paramNetSearchTemplateAvatarsItem.jdField_a_of_type_Int > 4))
          {
            ((SquareImageView)localObject3).setFilterColor(Color.parseColor("#66000000"));
            k = paramNetSearchTemplateAvatarsItem.jdField_a_of_type_Int - 4;
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("+");
            j = k;
            if (k > 99) {
              j = 99;
            }
            ((StringBuilder)localObject4).append(j);
            ((SquareImageView)localObject3).setFilterText(((StringBuilder)localObject4).toString());
            ((SquareImageView)localObject3).setFilterTextSize(DisplayUtil.a(paramNetSearchTemplateAvatarsView.a().getContext(), 20.0F));
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
          paramNetSearchTemplateAvatarsView.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(localObject2[j]).setVisibility(4);
          j += 1;
        }
      }
    }
    else
    {
      paramNetSearchTemplateAvatarsView.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      paramNetSearchTemplateAvatarsView.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if (paramNetSearchTemplateAvatarsItem.jdField_a_of_type_JavaUtilList != null)
      {
        m = Math.min(paramNetSearchTemplateAvatarsItem.jdField_a_of_type_JavaUtilList.size(), paramNetSearchTemplateAvatarsView.jdField_b_of_type_Int);
        n = (int)(DeviceInfoUtil.k() - UIUtils.a(paramNetSearchTemplateAvatarsView.a().getContext(), (m - 1) * 2 + 27));
        i = 0;
        for (;;)
        {
          j = i;
          if (i >= m) {
            break;
          }
          localObject1 = (SquareImageView)paramNetSearchTemplateAvatarsView.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
          localObject2 = ((ImageItem)paramNetSearchTemplateAvatarsItem.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString;
          localObject4 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject4).mPlayGifImage = true;
          localColorDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
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
          if (paramNetSearchTemplateAvatarsItem.jdField_b_of_type_Int != 0) {
            ((SquareImageView)localObject1).setImageScale(n / 4 * 1.0F / DisplayUtil.a((Context)localObject3, paramNetSearchTemplateAvatarsItem.jdField_b_of_type_Int / 2), 0.0F);
          } else {
            ((SquareImageView)localObject1).setImageScale(1.0F, 0.0F);
          }
          ((SquareImageView)localObject1).setVisibility(0);
          if ((i == paramNetSearchTemplateAvatarsView.jdField_b_of_type_Int - 1) && (paramNetSearchTemplateAvatarsItem.jdField_a_of_type_Int > paramNetSearchTemplateAvatarsView.jdField_b_of_type_Int))
          {
            ((SquareImageView)localObject1).setFilterColor(Color.parseColor("#66000000"));
            k = paramNetSearchTemplateAvatarsItem.jdField_a_of_type_Int - paramNetSearchTemplateAvatarsView.jdField_b_of_type_Int;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("+");
            j = k;
            if (k > 99) {
              j = 99;
            }
            ((StringBuilder)localObject2).append(j);
            ((SquareImageView)localObject1).setFilterText(((StringBuilder)localObject2).toString());
            ((SquareImageView)localObject1).setFilterTextSize(DisplayUtil.a(paramNetSearchTemplateAvatarsView.a().getContext(), 20.0F));
          }
          else
          {
            ((SquareImageView)localObject1).setFilterColor(-1);
            ((SquareImageView)localObject1).setFilterText("");
          }
          i += 1;
        }
        while (j < paramNetSearchTemplateAvatarsView.jdField_b_of_type_Int)
        {
          paramNetSearchTemplateAvatarsView.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j).setVisibility(4);
          j += 1;
        }
      }
    }
  }
  
  private void a(NetSearchTemplateBannerTitleItem paramNetSearchTemplateBannerTitleItem, NetSearchTemplateBannerTitleView paramNetSearchTemplateBannerTitleView)
  {
    Object localObject = paramNetSearchTemplateBannerTitleView.a().getContext();
    if (!TextUtils.isEmpty(paramNetSearchTemplateBannerTitleItem.i))
    {
      paramNetSearchTemplateBannerTitleView.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      a((Context)localObject, (SquareImageView)paramNetSearchTemplateBannerTitleView.jdField_c_of_type_AndroidWidgetImageView, paramNetSearchTemplateBannerTitleView.d, paramNetSearchTemplateBannerTitleView.jdField_b_of_type_AndroidWidgetTextView, paramNetSearchTemplateBannerTitleItem.jdField_a_of_type_Int, paramNetSearchTemplateBannerTitleItem.i, paramNetSearchTemplateBannerTitleItem.jdField_b_of_type_JavaLangString, ((Context)localObject).getResources().getDimensionPixelSize(2131298473));
    }
    else
    {
      paramNetSearchTemplateBannerTitleView.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    int i = ((Context)localObject).getResources().getDimensionPixelSize(2131298473);
    if ((paramNetSearchTemplateBannerTitleItem.jdField_a_of_type_Int == 6) || (paramNetSearchTemplateBannerTitleItem.jdField_a_of_type_Int == 8)) {
      i = DisplayUtil.a((Context)localObject, 100.0F);
    }
    if (paramNetSearchTemplateBannerTitleView.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 8) {
      i = 0;
    } else {
      i += DisplayUtil.a((Context)localObject, 10.0F);
    }
    float f = ((Context)localObject).getResources().getDisplayMetrics().widthPixels - DisplayUtil.a((Context)localObject, 30.0F);
    CharSequence localCharSequence = SearchUtils.a(paramNetSearchTemplateBannerTitleView.jdField_a_of_type_AndroidWidgetTextView, f, 2, paramNetSearchTemplateBannerTitleItem.jdField_a_of_type_JavaLangCharSequence.toString(), paramNetSearchTemplateBannerTitleItem.jdField_a_of_type_ComTencentMobileqqSearchUtilHighlightModel.jdField_a_of_type_JavaUtilList, false, true);
    paramNetSearchTemplateBannerTitleView.jdField_a_of_type_AndroidWidgetTextView.setText(localCharSequence);
    f = ((Context)localObject).getResources().getDisplayMetrics().widthPixels - DisplayUtil.a((Context)localObject, 30.0F) - i;
    localObject = SearchUtils.a(paramNetSearchTemplateBannerTitleView.jdField_c_of_type_AndroidWidgetTextView, f, 2, paramNetSearchTemplateBannerTitleItem.jdField_b_of_type_JavaLangCharSequence.toString(), paramNetSearchTemplateBannerTitleItem.jdField_a_of_type_ComTencentMobileqqSearchUtilHighlightModel.jdField_a_of_type_JavaUtilList, false, false);
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      paramNetSearchTemplateBannerTitleView.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#4A4A4A"));
      paramNetSearchTemplateBannerTitleView.h.setTextColor(Color.parseColor("#4A4A4A"));
    }
    else
    {
      paramNetSearchTemplateBannerTitleView.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      paramNetSearchTemplateBannerTitleView.h.setTextColor(Color.parseColor("#737373"));
    }
    a(paramNetSearchTemplateBannerTitleView.jdField_c_of_type_AndroidWidgetTextView, (CharSequence)localObject, true);
    a(paramNetSearchTemplateBannerTitleView.h, paramNetSearchTemplateBannerTitleItem.jdField_c_of_type_JavaLangCharSequence);
  }
  
  private void a(NetSearchTemplateBigImageItem paramNetSearchTemplateBigImageItem, NetSearchTemplateBigImageView paramNetSearchTemplateBigImageView)
  {
    Context localContext = paramNetSearchTemplateBigImageView.a().getContext();
    int i;
    int j;
    if (paramNetSearchTemplateBigImageItem.jdField_a_of_type_Int == 1)
    {
      i = DisplayUtil.a(localContext, 375.0F);
      j = DisplayUtil.a(localContext, 150.0F);
    }
    else if (paramNetSearchTemplateBigImageItem.jdField_a_of_type_Int == 2)
    {
      i = DisplayUtil.a(localContext, 375.0F);
      j = DisplayUtil.a(localContext, 180.0F);
    }
    else if (paramNetSearchTemplateBigImageItem.jdField_a_of_type_Int == 0)
    {
      i = DisplayUtil.a(localContext, paramNetSearchTemplateBigImageItem.jdField_a_of_type_Float / 2.0F);
      j = DisplayUtil.a(localContext, paramNetSearchTemplateBigImageItem.jdField_b_of_type_Float / 2.0F);
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
    if (!TextUtils.isEmpty(paramNetSearchTemplateBigImageItem.jdField_b_of_type_JavaLangString))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = k;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i;
      ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
      localObject = URLDrawable.getDrawable(paramNetSearchTemplateBigImageItem.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      paramNetSearchTemplateBigImageView.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
    }
    else
    {
      paramNetSearchTemplateBigImageView.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    paramNetSearchTemplateBigImageView.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    Object localObject = (LinearLayout.LayoutParams)paramNetSearchTemplateBigImageView.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).height = ((int)(UIUtils.a(localContext) * i * 1.0F / k));
    paramNetSearchTemplateBigImageView.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramNetSearchTemplateBigImageView.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, 0, 0, 0);
    if (!TextUtils.isEmpty(paramNetSearchTemplateBigImageItem.jdField_a_of_type_JavaLangCharSequence))
    {
      paramNetSearchTemplateBigImageView.jdField_b_of_type_AndroidWidgetTextView.setText(paramNetSearchTemplateBigImageItem.jdField_a_of_type_JavaLangCharSequence);
      paramNetSearchTemplateBigImageView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    else
    {
      paramNetSearchTemplateBigImageView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramNetSearchTemplateBigImageItem.jdField_b_of_type_JavaLangCharSequence))
    {
      paramNetSearchTemplateBigImageView.jdField_c_of_type_AndroidWidgetTextView.setText(paramNetSearchTemplateBigImageItem.jdField_b_of_type_JavaLangCharSequence);
      paramNetSearchTemplateBigImageView.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    else
    {
      paramNetSearchTemplateBigImageView.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramNetSearchTemplateBigImageItem.j)) {
      paramNetSearchTemplateBigImageView.h.setText(paramNetSearchTemplateBigImageItem.j);
    }
    try
    {
      if (!paramNetSearchTemplateBigImageItem.k.startsWith("#"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("#");
        ((StringBuilder)localObject).append(paramNetSearchTemplateBigImageItem.k);
        paramNetSearchTemplateBigImageItem.k = ((StringBuilder)localObject).toString();
      }
      paramNetSearchTemplateBigImageView.h.setBackgroundColor(Color.parseColor(paramNetSearchTemplateBigImageItem.k));
    }
    catch (Exception localException)
    {
      label483:
      break label483;
    }
    paramNetSearchTemplateBigImageView.h.setBackgroundColor(Color.parseColor("#FF00FF00"));
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("bigImageItem.topLeftTagColor = ");
      ((StringBuilder)localObject).append(paramNetSearchTemplateBigImageItem.k);
      QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, ((StringBuilder)localObject).toString());
    }
    paramNetSearchTemplateBigImageView.h.setVisibility(0);
    break label561;
    paramNetSearchTemplateBigImageView.h.setVisibility(8);
    label561:
    localObject = ((ViewGroup)paramNetSearchTemplateBigImageView.a()).getChildAt(((ViewGroup)paramNetSearchTemplateBigImageView.a()).getChildCount() - 1);
    if ((localObject != null) && ((((View)localObject).getLayoutParams() instanceof LinearLayout.LayoutParams)))
    {
      if (paramNetSearchTemplateBigImageItem.f_() == 0)
      {
        ((LinearLayout.LayoutParams)((View)localObject).getLayoutParams()).topMargin = 0;
        paramNetSearchTemplateBigImageView.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, 0, 0, DisplayUtil.a(localContext, 6.0F));
        return;
      }
      if (paramNetSearchTemplateBigImageItem.f_() == 2) {
        ((LinearLayout.LayoutParams)((View)localObject).getLayoutParams()).bottomMargin = 0;
      }
    }
  }
  
  private void a(NetSearchTemplateFriendUpdatesItem paramNetSearchTemplateFriendUpdatesItem, NetSearchTemplateFriendUpdatesView paramNetSearchTemplateFriendUpdatesView)
  {
    Object localObject1 = paramNetSearchTemplateFriendUpdatesView.a().getContext();
    Object localObject2 = paramNetSearchTemplateFriendUpdatesView.a();
    if (paramNetSearchTemplateFriendUpdatesItem.jdField_b_of_type_Boolean) {
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), UIUtils.a(((View)localObject2).getContext(), 6.0F), ((View)localObject2).getPaddingRight(), UIUtils.a(((View)localObject2).getContext(), 6.0F));
    } else {
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), UIUtils.a(((View)localObject2).getContext(), 3.0F), ((View)localObject2).getPaddingRight(), UIUtils.a(((View)localObject2).getContext(), 3.0F));
    }
    localObject2 = (LinearLayout)((View)localObject2).findViewById(2131372733);
    Object localObject3 = new ArrayList();
    int i = 0;
    Object localObject4;
    while (i < ((LinearLayout)localObject2).getChildCount())
    {
      localObject4 = ((LinearLayout)localObject2).getChildAt(i).findViewById(2131368557);
      if ((localObject4 instanceof SquareImageView)) {
        ((List)localObject3).add((SquareImageView)localObject4);
      }
      i += 1;
    }
    if (!((List)localObject3).isEmpty())
    {
      if (paramNetSearchTemplateFriendUpdatesItem.jdField_c_of_type_Boolean)
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
    if (!TextUtils.isEmpty(paramNetSearchTemplateFriendUpdatesItem.i)) {
      a((Context)localObject1, (SquareImageView)paramNetSearchTemplateFriendUpdatesView.b(), paramNetSearchTemplateFriendUpdatesView.d, paramNetSearchTemplateFriendUpdatesView.jdField_a_of_type_AndroidWidgetTextView, paramNetSearchTemplateFriendUpdatesItem.jdField_a_of_type_Int, paramNetSearchTemplateFriendUpdatesItem.i, null, DisplayUtil.a((Context)localObject1, 32.0F));
    }
    if (!TextUtils.isEmpty(paramNetSearchTemplateFriendUpdatesItem.jdField_a_of_type_JavaLangString))
    {
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      localObject3 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject3);
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject3);
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = paramNetSearchTemplateFriendUpdatesView.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = paramNetSearchTemplateFriendUpdatesView.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams().height;
      localObject2 = URLDrawable.getDrawable(paramNetSearchTemplateFriendUpdatesItem.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
      paramNetSearchTemplateFriendUpdatesView.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      paramNetSearchTemplateFriendUpdatesView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    else
    {
      paramNetSearchTemplateFriendUpdatesView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    i = ((Context)localObject1).getResources().getDimensionPixelSize(2131298473);
    if ((paramNetSearchTemplateFriendUpdatesItem.jdField_a_of_type_Int == 6) || (paramNetSearchTemplateFriendUpdatesItem.jdField_a_of_type_Int == 8)) {
      i = DisplayUtil.a((Context)localObject1, 100.0F);
    }
    localObject2 = SearchUtils.a(paramNetSearchTemplateFriendUpdatesView.a(), SearchUtils.a(paramNetSearchTemplateFriendUpdatesView.a(), HardCodeUtil.a(2131713586)) * 10.0F, 1, paramNetSearchTemplateFriendUpdatesItem.jdField_a_of_type_JavaLangCharSequence.toString(), paramNetSearchTemplateFriendUpdatesItem.jdField_a_of_type_ComTencentMobileqqSearchUtilHighlightModel.jdField_a_of_type_JavaUtilList, false, false, true);
    paramNetSearchTemplateFriendUpdatesView.a().setText((CharSequence)localObject2);
    paramNetSearchTemplateFriendUpdatesView.a().setEllipsize(null);
    float f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - DisplayUtil.a((Context)localObject1, 40.0F) - i;
    localObject2 = SearchUtils.a(paramNetSearchTemplateFriendUpdatesView.b(), f1, 2, paramNetSearchTemplateFriendUpdatesItem.jdField_b_of_type_JavaLangCharSequence.toString(), "", false, false, true);
    a(paramNetSearchTemplateFriendUpdatesView.b(), (CharSequence)localObject2, false);
    if (!TextUtils.isEmpty(paramNetSearchTemplateFriendUpdatesItem.jdField_c_of_type_JavaLangCharSequence))
    {
      f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - DisplayUtil.a((Context)localObject1, 30.0F);
      localObject2 = SearchUtils.a(paramNetSearchTemplateFriendUpdatesView.c(), f1, 2, paramNetSearchTemplateFriendUpdatesItem.jdField_c_of_type_JavaLangCharSequence.toString(), paramNetSearchTemplateFriendUpdatesItem.jdField_a_of_type_ComTencentMobileqqSearchUtilHighlightModel.jdField_a_of_type_JavaUtilList, false, false);
      paramNetSearchTemplateFriendUpdatesView.c().setText((CharSequence)localObject2);
      paramNetSearchTemplateFriendUpdatesView.c().setVisibility(0);
    }
    else
    {
      paramNetSearchTemplateFriendUpdatesView.c().setVisibility(8);
    }
    int j;
    Object localObject5;
    if (paramNetSearchTemplateFriendUpdatesItem.jdField_a_of_type_JavaUtilList != null)
    {
      Object localObject6;
      if (paramNetSearchTemplateFriendUpdatesItem.jdField_a_of_type_JavaUtilList.size() == 1)
      {
        paramNetSearchTemplateFriendUpdatesView.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        paramNetSearchTemplateFriendUpdatesView.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        localObject3 = paramNetSearchTemplateFriendUpdatesView.a().getResources();
        if (jdField_a_of_type_Int == 0) {
          jdField_a_of_type_Int = ((Resources)localObject3).getDisplayMetrics().widthPixels;
        }
        localObject2 = paramNetSearchTemplateFriendUpdatesView.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView;
        ((SquareImageView)localObject2).setImageScale((float)(1.0D / paramNetSearchTemplateFriendUpdatesItem.jdField_a_of_type_Double), 0.0F);
        f1 = ((Resources)localObject3).getDimension(2131298466);
        float f2 = ((Resources)localObject3).getDimension(2131298466);
        i = DisplayUtil.a(paramNetSearchTemplateFriendUpdatesView.a().getContext(), 2.0F);
        j = paramNetSearchTemplateFriendUpdatesView.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
        double d1 = (int)(jdField_a_of_type_Int - f1 - f2 - (j - 1) * i) / j;
        double d2 = paramNetSearchTemplateFriendUpdatesItem.jdField_b_of_type_Double;
        Double.isNaN(d1);
        i = (int)(d2 * d1);
        d2 = paramNetSearchTemplateFriendUpdatesItem.jdField_b_of_type_Double;
        Double.isNaN(d1);
        j = (int)(d1 * d2);
        ((SquareImageView)localObject2).setLayoutParams(new FrameLayout.LayoutParams(i, j));
        localObject3 = (ImageItem)paramNetSearchTemplateFriendUpdatesItem.jdField_a_of_type_JavaUtilList.get(0);
        localObject4 = ((ImageItem)localObject3).jdField_a_of_type_JavaLangString;
        localObject5 = URLDrawable.URLDrawableOptions.obtain();
        localObject6 = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
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
        if (((ImageItem)localObject3).jdField_a_of_type_Int == 2) {
          paramNetSearchTemplateFriendUpdatesView.f.setVisibility(0);
        } else {
          paramNetSearchTemplateFriendUpdatesView.f.setVisibility(8);
        }
      }
      else
      {
        paramNetSearchTemplateFriendUpdatesView.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
        paramNetSearchTemplateFriendUpdatesView.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        int m = paramNetSearchTemplateFriendUpdatesView.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
        i = 0;
        for (;;)
        {
          j = i;
          if (i >= paramNetSearchTemplateFriendUpdatesItem.jdField_a_of_type_JavaUtilList.size()) {
            break;
          }
          j = i;
          if (i >= m) {
            break;
          }
          localObject3 = paramNetSearchTemplateFriendUpdatesView.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
          ((View)localObject3).setVisibility(0);
          localObject2 = (SquareImageView)((View)localObject3).findViewById(2131368557);
          localObject3 = (ImageView)((View)localObject3).findViewById(2131369731);
          ((SquareImageView)localObject2).setImageScale((float)(1.0D / paramNetSearchTemplateFriendUpdatesItem.jdField_a_of_type_Double), 0.0F);
          localObject4 = (ImageItem)paramNetSearchTemplateFriendUpdatesItem.jdField_a_of_type_JavaUtilList.get(i);
          localObject5 = ((ImageItem)localObject4).jdField_a_of_type_JavaLangString;
          localObject6 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject6).mRequestHeight = 200;
          ((URLDrawable.URLDrawableOptions)localObject6).mRequestWidth = 200;
          ColorDrawable localColorDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          ((URLDrawable.URLDrawableOptions)localObject6).mFailedDrawable = localColorDrawable;
          ((URLDrawable.URLDrawableOptions)localObject6).mLoadingDrawable = localColorDrawable;
          ((URLDrawable.URLDrawableOptions)localObject6).mPlayGifImage = true;
          localObject5 = URLDrawable.getDrawable((String)localObject5, (URLDrawable.URLDrawableOptions)localObject6);
          ((SquareImageView)localObject2).setImageDrawable((Drawable)localObject5);
          if ((((URLDrawable)localObject5).getStatus() != 1) && (((URLDrawable)localObject5).getStatus() != 0)) {
            ((URLDrawable)localObject5).restartDownload();
          }
          ((SquareImageView)localObject2).setVisibility(0);
          if (((ImageItem)localObject4).jdField_a_of_type_Int == 2) {
            ((ImageView)localObject3).setVisibility(0);
          } else {
            ((ImageView)localObject3).setVisibility(8);
          }
          if ((i == m - 1) && (paramNetSearchTemplateFriendUpdatesItem.jdField_b_of_type_Int > m))
          {
            ((ImageView)localObject3).setVisibility(8);
            ((SquareImageView)localObject2).setFilterColor(Color.parseColor("#66000000"));
            int k = paramNetSearchTemplateFriendUpdatesItem.jdField_b_of_type_Int - m;
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
          paramNetSearchTemplateFriendUpdatesView.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j).setVisibility(4);
          j += 1;
        }
      }
    }
    else
    {
      paramNetSearchTemplateFriendUpdatesView.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      paramNetSearchTemplateFriendUpdatesView.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    if ((paramNetSearchTemplateFriendUpdatesItem.jdField_c_of_type_JavaUtilList == null) && (TextUtils.equals(paramNetSearchTemplateFriendUpdatesItem.k, "0")) && (TextUtils.equals(paramNetSearchTemplateFriendUpdatesItem.m, "0")))
    {
      paramNetSearchTemplateFriendUpdatesView.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    if (paramNetSearchTemplateFriendUpdatesItem.jdField_c_of_type_JavaUtilList != null)
    {
      paramNetSearchTemplateFriendUpdatesView.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      i = paramNetSearchTemplateFriendUpdatesItem.jdField_c_of_type_JavaUtilList.size() - 1;
      while (i >= 0)
      {
        if (i > 0) {
          j = DisplayUtil.a((Context)localObject1, 11.0F) * i;
        } else {
          j = 0;
        }
        localObject2 = (SquareImageView)LayoutInflater.from((Context)localObject1).inflate(2131559812, null, false);
        localObject3 = new RelativeLayout.LayoutParams(DisplayUtil.a((Context)localObject1, 16.0F), DisplayUtil.a((Context)localObject1, 16.0F));
        ((RelativeLayout.LayoutParams)localObject3).leftMargin = j;
        paramNetSearchTemplateFriendUpdatesView.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject2, paramNetSearchTemplateFriendUpdatesItem.jdField_c_of_type_JavaUtilList.size() - 1 - i, (ViewGroup.LayoutParams)localObject3);
        localObject3 = (String)paramNetSearchTemplateFriendUpdatesItem.jdField_c_of_type_JavaUtilList.get(i);
        localObject4 = URLDrawable.URLDrawableOptions.obtain();
        localObject5 = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = ((Drawable)localObject5);
        ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = ((Drawable)localObject5);
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = ((SquareImageView)localObject2).getLayoutParams().width;
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = ((SquareImageView)localObject2).getLayoutParams().height;
        localObject3 = URLDrawable.getDrawable((String)localObject3, (URLDrawable.URLDrawableOptions)localObject4);
        ((URLDrawable)localObject3).setDecodeHandler(URLDrawableDecodeHandler.a);
        ((SquareImageView)localObject2).setImageDrawable((Drawable)localObject3);
        if ((((URLDrawable)localObject3).getStatus() != 1) && (((URLDrawable)localObject3).getStatus() != 0)) {
          ((URLDrawable)localObject3).restartDownload();
        }
        ((SquareImageView)localObject2).setVisibility(0);
        i -= 1;
      }
    }
    paramNetSearchTemplateFriendUpdatesView.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
    if (!TextUtils.isEmpty(paramNetSearchTemplateFriendUpdatesItem.jdField_b_of_type_JavaLangString))
    {
      paramNetSearchTemplateFriendUpdatesView.jdField_b_of_type_AndroidWidgetTextView.setText(paramNetSearchTemplateFriendUpdatesItem.jdField_b_of_type_JavaLangString);
      paramNetSearchTemplateFriendUpdatesView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    else
    {
      paramNetSearchTemplateFriendUpdatesView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramNetSearchTemplateFriendUpdatesItem.j))
    {
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      localObject2 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((Drawable)localObject2);
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject2);
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = paramNetSearchTemplateFriendUpdatesView.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = paramNetSearchTemplateFriendUpdatesView.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().height;
      localObject1 = URLDrawable.getDrawable(paramNetSearchTemplateFriendUpdatesItem.j, (URLDrawable.URLDrawableOptions)localObject1);
      paramNetSearchTemplateFriendUpdatesView.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
      if ((((URLDrawable)localObject1).getStatus() != 1) && (((URLDrawable)localObject1).getStatus() != 0)) {
        ((URLDrawable)localObject1).restartDownload();
      }
      paramNetSearchTemplateFriendUpdatesView.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    }
    else
    {
      paramNetSearchTemplateFriendUpdatesView.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramNetSearchTemplateFriendUpdatesItem.k))
    {
      paramNetSearchTemplateFriendUpdatesView.jdField_c_of_type_AndroidWidgetTextView.setText(paramNetSearchTemplateFriendUpdatesItem.k);
      paramNetSearchTemplateFriendUpdatesView.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    else
    {
      paramNetSearchTemplateFriendUpdatesView.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramNetSearchTemplateFriendUpdatesItem.l))
    {
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      localObject2 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((Drawable)localObject2);
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject2);
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = paramNetSearchTemplateFriendUpdatesView.jdField_b_of_type_ComTencentImageURLImageView.getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = paramNetSearchTemplateFriendUpdatesView.jdField_b_of_type_ComTencentImageURLImageView.getLayoutParams().height;
      localObject1 = URLDrawable.getDrawable(paramNetSearchTemplateFriendUpdatesItem.l, (URLDrawable.URLDrawableOptions)localObject1);
      paramNetSearchTemplateFriendUpdatesView.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
      if ((((URLDrawable)localObject1).getStatus() != 1) && (((URLDrawable)localObject1).getStatus() != 0)) {
        ((URLDrawable)localObject1).restartDownload();
      }
      paramNetSearchTemplateFriendUpdatesView.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(0);
    }
    else
    {
      paramNetSearchTemplateFriendUpdatesView.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramNetSearchTemplateFriendUpdatesItem.m))
    {
      paramNetSearchTemplateFriendUpdatesView.h.setText(paramNetSearchTemplateFriendUpdatesItem.m);
      paramNetSearchTemplateFriendUpdatesView.h.setVisibility(0);
      return;
    }
    paramNetSearchTemplateFriendUpdatesView.h.setVisibility(8);
  }
  
  private void a(NetSearchTemplateNetSeaEntranceItem paramNetSearchTemplateNetSeaEntranceItem, NetSearchTemplateNetSeaEntranceView paramNetSearchTemplateNetSeaEntranceView)
  {
    Object localObject = paramNetSearchTemplateNetSeaEntranceView.a();
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
    if (!TextUtils.isEmpty(paramNetSearchTemplateNetSeaEntranceItem.jdField_b_of_type_JavaLangString))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      localColorDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = DisplayUtil.a(localContext, 50.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = DisplayUtil.a(localContext, 50.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "leftIcon";
      localObject = URLDrawable.getDrawable(paramNetSearchTemplateNetSeaEntranceItem.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      paramNetSearchTemplateNetSeaEntranceView.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      paramNetSearchTemplateNetSeaEntranceView.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    }
    else
    {
      paramNetSearchTemplateNetSeaEntranceView.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramNetSearchTemplateNetSeaEntranceItem.j))
    {
      paramNetSearchTemplateNetSeaEntranceView.jdField_a_of_type_AndroidWidgetTextView.setText(paramNetSearchTemplateNetSeaEntranceItem.j);
      paramNetSearchTemplateNetSeaEntranceView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    else
    {
      paramNetSearchTemplateNetSeaEntranceView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramNetSearchTemplateNetSeaEntranceItem.g))
    {
      paramNetSearchTemplateNetSeaEntranceView.jdField_b_of_type_AndroidWidgetTextView.setText(paramNetSearchTemplateNetSeaEntranceItem.g);
      paramNetSearchTemplateNetSeaEntranceView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    else
    {
      paramNetSearchTemplateNetSeaEntranceView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramNetSearchTemplateNetSeaEntranceItem.k))
    {
      paramNetSearchTemplateNetSeaEntranceView.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramNetSearchTemplateNetSeaEntranceView.jdField_c_of_type_AndroidWidgetTextView.setText(paramNetSearchTemplateNetSeaEntranceItem.k);
    }
    else
    {
      paramNetSearchTemplateNetSeaEntranceView.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramNetSearchTemplateNetSeaEntranceItem.l))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      localColorDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = DisplayUtil.a(localContext, 30.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = DisplayUtil.a(localContext, 30.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "rightIcon";
      localObject = URLDrawable.getDrawable(paramNetSearchTemplateNetSeaEntranceItem.l, (URLDrawable.URLDrawableOptions)localObject);
      paramNetSearchTemplateNetSeaEntranceView.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      paramNetSearchTemplateNetSeaEntranceView.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(0);
    }
    else
    {
      paramNetSearchTemplateNetSeaEntranceView.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
    paramNetSearchTemplateNetSeaEntranceView.a(paramNetSearchTemplateNetSeaEntranceItem);
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
    {
      paramNetSearchTemplateNetSeaEntranceView.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839385);
      paramNetSearchTemplateNetSeaEntranceView.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839385);
      paramNetSearchTemplateNetSeaEntranceView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      paramNetSearchTemplateNetSeaEntranceView.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#4A4A4A"));
    }
    else
    {
      paramNetSearchTemplateNetSeaEntranceView.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839384);
      paramNetSearchTemplateNetSeaEntranceView.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839384);
      paramNetSearchTemplateNetSeaEntranceView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#262626"));
      paramNetSearchTemplateNetSeaEntranceView.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
    }
    if (paramNetSearchTemplateNetSeaEntranceView.jdField_b_of_type_AndroidWidgetTextView != null) {
      paramNetSearchTemplateNetSeaEntranceView.jdField_b_of_type_AndroidWidgetTextView.setTextColor(SearchUtils.a());
    }
    paramNetSearchTemplateNetSeaEntranceView.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new SearchTemplatePresenter.4(this, paramNetSearchTemplateNetSeaEntranceItem, localContext));
    paramNetSearchTemplateNetSeaEntranceView.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(new SearchTemplatePresenter.5(this, paramNetSearchTemplateNetSeaEntranceItem, localContext));
  }
  
  private void a(NetSearchTemplateNewEntranceItem paramNetSearchTemplateNewEntranceItem, NetSearchTemplateNewEntranceView paramNetSearchTemplateNewEntranceView)
  {
    Object localObject = paramNetSearchTemplateNewEntranceView.a();
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
    if (!TextUtils.isEmpty(paramNetSearchTemplateNewEntranceItem.jdField_b_of_type_JavaLangString))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ColorDrawable localColorDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = DisplayUtil.a(localContext, 40.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = DisplayUtil.a(localContext, 40.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "leftIcon";
      localObject = URLDrawable.getDrawable(paramNetSearchTemplateNewEntranceItem.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      paramNetSearchTemplateNewEntranceView.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      paramNetSearchTemplateNewEntranceView.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    }
    else
    {
      paramNetSearchTemplateNewEntranceView.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramNetSearchTemplateNewEntranceItem.j))
    {
      paramNetSearchTemplateNewEntranceView.jdField_a_of_type_AndroidWidgetTextView.setText(paramNetSearchTemplateNewEntranceItem.j);
      paramNetSearchTemplateNewEntranceView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    else
    {
      paramNetSearchTemplateNewEntranceView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramNetSearchTemplateNewEntranceItem.g))
    {
      paramNetSearchTemplateNewEntranceView.jdField_c_of_type_AndroidWidgetTextView.setText(paramNetSearchTemplateNewEntranceItem.g);
      paramNetSearchTemplateNewEntranceView.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    else
    {
      paramNetSearchTemplateNewEntranceView.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramNetSearchTemplateNewEntranceItem.k))
    {
      paramNetSearchTemplateNewEntranceView.h.setVisibility(0);
      paramNetSearchTemplateNewEntranceView.h.setText(paramNetSearchTemplateNewEntranceItem.k);
    }
    else
    {
      paramNetSearchTemplateNewEntranceView.h.setVisibility(8);
    }
    if (paramNetSearchTemplateNewEntranceItem.jdField_b_of_type_Boolean) {
      paramNetSearchTemplateNewEntranceView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    } else {
      paramNetSearchTemplateNewEntranceView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    UniteSearchReportController.a(null, 0, paramNetSearchTemplateNewEntranceItem.jdField_c_of_type_Int, "0X8009D5C", 0, 0, null, null);
    if ((paramNetSearchTemplateNewEntranceItem.jdField_a_of_type_JavaUtilList != null) && (paramNetSearchTemplateNewEntranceItem.jdField_a_of_type_JavaUtilList.size() > 0)) {
      UniteSearchReportController.a(null, 0, paramNetSearchTemplateNewEntranceItem.jdField_c_of_type_Int, "0X8009D5E", 0, 0, null, null);
    }
    paramNetSearchTemplateNewEntranceView.a(paramNetSearchTemplateNewEntranceItem);
    paramNetSearchTemplateNewEntranceView.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new SearchTemplatePresenter.3(this, paramNetSearchTemplateNewEntranceItem, localContext));
  }
  
  private void a(NetSearchTemplateSubItem paramNetSearchTemplateSubItem, NetSearchTemplateSubItemView paramNetSearchTemplateSubItemView)
  {
    if (paramNetSearchTemplateSubItem != null)
    {
      if (paramNetSearchTemplateSubItemView == null) {
        return;
      }
      paramNetSearchTemplateSubItemView.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(paramNetSearchTemplateSubItemView.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingLeft(), 0, paramNetSearchTemplateSubItemView.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingRight(), 0);
      Object localObject = (RelativeLayout.LayoutParams)paramNetSearchTemplateSubItemView.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
      if (paramNetSearchTemplateSubItem.jdField_b_of_type_Boolean)
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(5, 0);
        ((RelativeLayout.LayoutParams)localObject).addRule(14);
      }
      else
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(14, 0);
        ((RelativeLayout.LayoutParams)localObject).addRule(5);
      }
      localObject = paramNetSearchTemplateSubItemView.jdField_a_of_type_AndroidWidgetTextView.getContext();
      int i = ((Context)localObject).getResources().getDisplayMetrics().widthPixels - DisplayUtil.a((Context)localObject, 38.0F);
      if (!TextUtils.isEmpty(paramNetSearchTemplateSubItem.jdField_b_of_type_JavaLangCharSequence))
      {
        paramNetSearchTemplateSubItemView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if (bool) {
          paramNetSearchTemplateSubItemView.jdField_b_of_type_AndroidWidgetTextView.setText(paramNetSearchTemplateSubItem.jdField_b_of_type_JavaLangCharSequence.toString());
        } else {
          paramNetSearchTemplateSubItemView.jdField_b_of_type_AndroidWidgetTextView.setText(paramNetSearchTemplateSubItem.jdField_b_of_type_JavaLangCharSequence);
        }
        i = (int)(i - (SearchUtils.a(paramNetSearchTemplateSubItemView.jdField_b_of_type_AndroidWidgetTextView, paramNetSearchTemplateSubItem.jdField_b_of_type_JavaLangCharSequence) + DisplayUtil.a((Context)localObject, 10.0F)));
      }
      else
      {
        paramNetSearchTemplateSubItemView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (!TextUtils.isEmpty(paramNetSearchTemplateSubItem.jdField_a_of_type_JavaLangCharSequence))
      {
        paramNetSearchTemplateSubItemView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        CharSequence localCharSequence = paramNetSearchTemplateSubItem.jdField_a_of_type_JavaLangCharSequence;
        localObject = localCharSequence;
        if (!paramNetSearchTemplateSubItem.jdField_b_of_type_Boolean) {
          localObject = SearchUtils.a(paramNetSearchTemplateSubItemView.jdField_a_of_type_AndroidWidgetTextView, i, localCharSequence);
        }
        if (bool) {
          paramNetSearchTemplateSubItemView.jdField_a_of_type_AndroidWidgetTextView.setText(((CharSequence)localObject).toString());
        } else {
          paramNetSearchTemplateSubItemView.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        }
      }
      else
      {
        paramNetSearchTemplateSubItemView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      paramNetSearchTemplateSubItemView.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(a(paramNetSearchTemplateSubItem.jdField_a_of_type_JavaLangString));
      paramNetSearchTemplateSubItemView.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new SearchTemplatePresenter.6(this, paramNetSearchTemplateSubItem, paramNetSearchTemplateSubItemView));
    }
  }
  
  private void a(NetSearchTemplateSubItemTitle paramNetSearchTemplateSubItemTitle, NetSearchTemplateSubItemTitleView paramNetSearchTemplateSubItemTitleView)
  {
    if (paramNetSearchTemplateSubItemTitle != null)
    {
      if (paramNetSearchTemplateSubItemTitleView == null) {
        return;
      }
      if ((!TextUtils.isEmpty(paramNetSearchTemplateSubItemTitle.jdField_a_of_type_JavaLangString)) && (paramNetSearchTemplateSubItemTitleView.jdField_a_of_type_AndroidWidgetTextView != null))
      {
        Context localContext = paramNetSearchTemplateSubItemTitleView.jdField_a_of_type_AndroidWidgetTextView.getContext();
        int j = localContext.getResources().getDisplayMetrics().widthPixels - DisplayUtil.a(localContext, 40.0F);
        int i;
        if ((!TextUtils.isEmpty(paramNetSearchTemplateSubItemTitle.e)) && (paramNetSearchTemplateSubItemTitleView.jdField_a_of_type_AndroidWidgetLinearLayout != null))
        {
          paramNetSearchTemplateSubItemTitleView.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          i = j - DisplayUtil.a(localContext, 26.0F);
        }
        else
        {
          i = j;
          if (paramNetSearchTemplateSubItemTitleView.jdField_a_of_type_AndroidWidgetLinearLayout != null)
          {
            paramNetSearchTemplateSubItemTitleView.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            i = j;
          }
        }
        paramNetSearchTemplateSubItemTitle = SearchUtils.a(paramNetSearchTemplateSubItemTitleView.jdField_a_of_type_AndroidWidgetTextView, i, paramNetSearchTemplateSubItemTitle.jdField_a_of_type_JavaLangString);
        paramNetSearchTemplateSubItemTitleView.jdField_a_of_type_AndroidWidgetTextView.setText(paramNetSearchTemplateSubItemTitle);
      }
    }
  }
  
  private void a(NetSearchTemplateUniversalItem paramNetSearchTemplateUniversalItem, NetSearchTemplateUniversalView paramNetSearchTemplateUniversalView)
  {
    Context localContext = paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetRelativeLayout.getContext();
    Object localObject = (RelativeLayout.LayoutParams)paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    if (paramNetSearchTemplateUniversalItem.jdField_b_of_type_Boolean)
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
      ((RelativeLayout.LayoutParams)paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).rightMargin = DisplayUtil.a(localContext, 10.0F);
    }
    int i = a(paramNetSearchTemplateUniversalItem, paramNetSearchTemplateUniversalView);
    int j = a(paramNetSearchTemplateUniversalItem, paramNetSearchTemplateUniversalView, ((Integer)((Pair)localObject).first).intValue(), i);
    i = j;
    if (((Integer)((Pair)localObject).second).intValue() > j) {
      i = ((Integer)((Pair)localObject).second).intValue();
    }
    if (paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      ((RelativeLayout.LayoutParams)paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).height = i;
    }
  }
  
  private void a(NetSearchTemplateUpdatesItem paramNetSearchTemplateUpdatesItem, NetSearchTemplateUpdatesView paramNetSearchTemplateUpdatesView)
  {
    Object localObject1 = paramNetSearchTemplateUpdatesView.a().getContext();
    Object localObject2 = paramNetSearchTemplateUpdatesView.a();
    if (paramNetSearchTemplateUpdatesItem.jdField_b_of_type_Boolean) {
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), UIUtils.a(((View)localObject2).getContext(), 9.0F), ((View)localObject2).getPaddingRight(), UIUtils.a(((View)localObject2).getContext(), 9.0F));
    } else {
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), UIUtils.a(((View)localObject2).getContext(), 6.0F), ((View)localObject2).getPaddingRight(), UIUtils.a(((View)localObject2).getContext(), 6.0F));
    }
    localObject2 = (LinearLayout)((View)localObject2).findViewById(2131372733);
    Object localObject3 = new ArrayList();
    int i = 0;
    Object localObject4;
    while (i < ((LinearLayout)localObject2).getChildCount())
    {
      localObject4 = ((LinearLayout)localObject2).getChildAt(i).findViewById(2131368557);
      if ((localObject4 instanceof SquareImageView)) {
        ((List)localObject3).add((SquareImageView)localObject4);
      }
      i += 1;
    }
    if (!((List)localObject3).isEmpty())
    {
      if (paramNetSearchTemplateUpdatesItem.jdField_c_of_type_Boolean)
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
      paramNetSearchTemplateUpdatesView.a().setTextColor(Color.parseColor("#6991B8"));
      paramNetSearchTemplateUpdatesView.c().setTextColor(Color.parseColor("#44608A"));
      paramNetSearchTemplateUpdatesView.b().setTextColor(Color.parseColor("#44608A"));
    }
    else
    {
      paramNetSearchTemplateUpdatesView.a().setTextColor(Color.parseColor("#262626"));
      paramNetSearchTemplateUpdatesView.c().setTextColor(Color.parseColor("#737373"));
      paramNetSearchTemplateUpdatesView.b().setTextColor(Color.parseColor("#737373"));
    }
    if (!TextUtils.isEmpty(paramNetSearchTemplateUpdatesItem.i)) {
      a((Context)localObject1, (SquareImageView)paramNetSearchTemplateUpdatesView.b(), paramNetSearchTemplateUpdatesView.d, paramNetSearchTemplateUpdatesView.jdField_a_of_type_AndroidWidgetTextView, paramNetSearchTemplateUpdatesItem.jdField_a_of_type_Int, paramNetSearchTemplateUpdatesItem.i, null, DisplayUtil.a((Context)localObject1, 21.0F));
    }
    if (!TextUtils.isEmpty(paramNetSearchTemplateUpdatesItem.jdField_a_of_type_JavaLangString))
    {
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      localObject3 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject3);
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject3);
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = paramNetSearchTemplateUpdatesView.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = paramNetSearchTemplateUpdatesView.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams().height;
      localObject2 = URLDrawable.getDrawable(paramNetSearchTemplateUpdatesItem.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
      paramNetSearchTemplateUpdatesView.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      paramNetSearchTemplateUpdatesView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    else
    {
      paramNetSearchTemplateUpdatesView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    i = ((Context)localObject1).getResources().getDimensionPixelSize(2131298473);
    if ((paramNetSearchTemplateUpdatesItem.jdField_a_of_type_Int == 6) || (paramNetSearchTemplateUpdatesItem.jdField_a_of_type_Int == 8)) {
      i = DisplayUtil.a((Context)localObject1, 100.0F);
    }
    localObject2 = SearchUtils.a(paramNetSearchTemplateUpdatesView.a(), SearchUtils.a(paramNetSearchTemplateUpdatesView.a(), HardCodeUtil.a(2131713585)) * 10.0F, 1, paramNetSearchTemplateUpdatesItem.jdField_a_of_type_JavaLangCharSequence.toString(), paramNetSearchTemplateUpdatesItem.jdField_a_of_type_ComTencentMobileqqSearchUtilHighlightModel.jdField_a_of_type_JavaUtilList, false, false, true);
    paramNetSearchTemplateUpdatesView.a().setText((CharSequence)localObject2);
    paramNetSearchTemplateUpdatesView.a().setEllipsize(null);
    float f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - DisplayUtil.a((Context)localObject1, 40.0F) - i;
    localObject2 = SearchUtils.a(paramNetSearchTemplateUpdatesView.b(), f1, 2, paramNetSearchTemplateUpdatesItem.jdField_b_of_type_JavaLangCharSequence.toString(), "", false, false, true);
    a(paramNetSearchTemplateUpdatesView.b(), (CharSequence)localObject2, false);
    if (!TextUtils.isEmpty(paramNetSearchTemplateUpdatesItem.jdField_c_of_type_JavaLangCharSequence))
    {
      f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - DisplayUtil.a((Context)localObject1, 30.0F);
      localObject2 = SearchUtils.a(paramNetSearchTemplateUpdatesView.c(), f1, 2, paramNetSearchTemplateUpdatesItem.jdField_c_of_type_JavaLangCharSequence.toString(), paramNetSearchTemplateUpdatesItem.jdField_a_of_type_ComTencentMobileqqSearchUtilHighlightModel.jdField_a_of_type_JavaUtilList, false, false);
      paramNetSearchTemplateUpdatesView.c().setText((CharSequence)localObject2);
      paramNetSearchTemplateUpdatesView.c().setVisibility(0);
    }
    else
    {
      paramNetSearchTemplateUpdatesView.c().setVisibility(8);
    }
    if (paramNetSearchTemplateUpdatesItem.jdField_a_of_type_JavaUtilList != null)
    {
      int j;
      double d1;
      double d2;
      if (paramNetSearchTemplateUpdatesItem.jdField_a_of_type_JavaUtilList.size() == 1)
      {
        paramNetSearchTemplateUpdatesView.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        paramNetSearchTemplateUpdatesView.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        localObject2 = paramNetSearchTemplateUpdatesView.a().getResources();
        if (jdField_a_of_type_Int == 0) {
          jdField_a_of_type_Int = ((Resources)localObject2).getDisplayMetrics().widthPixels;
        }
        localObject1 = paramNetSearchTemplateUpdatesView.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView;
        ((SquareImageView)localObject1).setImageScale((float)(1.0D / paramNetSearchTemplateUpdatesItem.jdField_a_of_type_Double), 0.0F);
        f1 = ((Resources)localObject2).getDimension(2131298466);
        float f2 = ((Resources)localObject2).getDimension(2131298466);
        i = DisplayUtil.a(paramNetSearchTemplateUpdatesView.a().getContext(), 2.0F);
        j = paramNetSearchTemplateUpdatesView.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
        d1 = (int)(jdField_a_of_type_Int - f1 - f2 - (j - 1) * i) / j;
        d2 = paramNetSearchTemplateUpdatesItem.jdField_b_of_type_Double;
        Double.isNaN(d1);
        i = (int)(d2 * d1);
        d2 = paramNetSearchTemplateUpdatesItem.jdField_b_of_type_Double;
        Double.isNaN(d1);
        j = (int)(d1 * d2);
        ((SquareImageView)localObject1).setLayoutParams(new FrameLayout.LayoutParams(i, j));
        paramNetSearchTemplateUpdatesItem = (ImageItem)paramNetSearchTemplateUpdatesItem.jdField_a_of_type_JavaUtilList.get(0);
        localObject2 = paramNetSearchTemplateUpdatesItem.jdField_a_of_type_JavaLangString;
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        localObject4 = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
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
        if (paramNetSearchTemplateUpdatesItem.jdField_a_of_type_Int == 2)
        {
          paramNetSearchTemplateUpdatesView.f.setVisibility(0);
          return;
        }
        paramNetSearchTemplateUpdatesView.f.setVisibility(8);
        return;
      }
      paramNetSearchTemplateUpdatesView.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      paramNetSearchTemplateUpdatesView.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      int m = paramNetSearchTemplateUpdatesView.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      i = 0;
      for (;;)
      {
        j = i;
        if (i >= paramNetSearchTemplateUpdatesItem.jdField_a_of_type_JavaUtilList.size()) {
          break;
        }
        j = i;
        if (i >= m) {
          break;
        }
        localObject3 = paramNetSearchTemplateUpdatesView.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
        ((View)localObject3).setVisibility(0);
        localObject2 = (SquareImageView)((View)localObject3).findViewById(2131368557);
        localObject3 = (ImageView)((View)localObject3).findViewById(2131369731);
        j = UIUtils.a((Context)localObject1) / m;
        d1 = j;
        d2 = paramNetSearchTemplateUpdatesItem.jdField_a_of_type_Double;
        Double.isNaN(d1);
        int k = (int)(d1 * d2);
        ((SquareImageView)localObject2).setImageScale((float)(1.0D / paramNetSearchTemplateUpdatesItem.jdField_a_of_type_Double), 0.0F);
        localObject4 = (ImageItem)paramNetSearchTemplateUpdatesItem.jdField_a_of_type_JavaUtilList.get(i);
        Object localObject5 = ((ImageItem)localObject4).jdField_a_of_type_JavaLangString;
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        ColorDrawable localColorDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
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
        if (((ImageItem)localObject4).jdField_a_of_type_Int == 2) {
          ((ImageView)localObject3).setVisibility(0);
        } else {
          ((ImageView)localObject3).setVisibility(8);
        }
        if ((i == m - 1) && (paramNetSearchTemplateUpdatesItem.jdField_b_of_type_Int > m))
        {
          ((ImageView)localObject3).setVisibility(8);
          ((SquareImageView)localObject2).setFilterColor(Color.parseColor("#66000000"));
          k = paramNetSearchTemplateUpdatesItem.jdField_b_of_type_Int - m;
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
        paramNetSearchTemplateUpdatesView.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j).setVisibility(4);
        j += 1;
      }
    }
    paramNetSearchTemplateUpdatesView.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    paramNetSearchTemplateUpdatesView.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void a(SquareImageView paramSquareImageView, int paramInt1, int paramInt2, String paramString)
  {
    if (paramSquareImageView != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      Object localObject = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
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
      ColorDrawable localColorDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      localURLDrawableOptions.mFailedDrawable = localColorDrawable;
      localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
      localURLDrawableOptions.mRequestWidth = paramSquareImageView.getLayoutParams().width;
      localURLDrawableOptions.mRequestHeight = paramSquareImageView.getLayoutParams().height;
      paramSquareImageView.setImageDrawable(URLDrawable.getDrawable(paramString, localURLDrawableOptions));
    }
  }
  
  private void b(NetSearchTemplateUniversalItem paramNetSearchTemplateUniversalItem, NetSearchTemplateUniversalView paramNetSearchTemplateUniversalView)
  {
    if ((paramNetSearchTemplateUniversalItem != null) && (paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateUniversalItem$ActionInfo != null) && (paramNetSearchTemplateUniversalView != null))
    {
      if (paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetButton == null) {
        return;
      }
      Context localContext = paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetButton.getContext();
      if ((paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateUniversalItem$ActionInfo.jdField_a_of_type_Int == 1) && (!TextUtils.isEmpty(paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateUniversalItem$ActionInfo.jdField_a_of_type_JavaLangCharSequence)))
      {
        paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
        paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetButton.setText(paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateUniversalItem$ActionInfo.jdField_a_of_type_JavaLangCharSequence);
        paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new SearchTemplatePresenter.9(this, localContext, paramNetSearchTemplateUniversalItem));
        return;
      }
      paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      return;
    }
    if ((paramNetSearchTemplateUniversalView != null) && (paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetButton != null)) {
      paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
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
      a(paramSquareImageView, paramImageView, paramTextView, DisplayUtil.a(paramContext, 100.0F), paramInt1, false, paramString1, null, 2130842411, false);
      return;
    case 5: 
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, paramInt2, false, paramString1, null, 0, true);
      return;
    case 4: 
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, paramInt2, false, paramString1, null, 2130842411, false);
      return;
    case 3: 
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, paramInt2, false, paramString1, null, 2130842411, false);
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
    Animation localAnimation = AnimationUtils.loadAnimation(paramImageView.getContext(), 2130772249);
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
    SearchViewUtils.a(paramNetSearchTemplateBaseItem.b(), paramNetSearchTemplateBaseItem.f_(), paramNetSearchTemplateBaseView.a(), paramNetSearchTemplateBaseItem.jdField_a_of_type_Boolean, paramNetSearchTemplateBaseItem.u, paramNetSearchTemplateBaseItem.g);
    switch (paramNetSearchTemplateBaseItem.d())
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
    if (TextUtils.isEmpty(paramNetSearchTemplateBaseItem.i)) {
      c(paramNetSearchTemplateBaseItem, paramNetSearchTemplateBaseView);
    }
  }
  
  public void a(NetSearchTemplateBaseItem paramNetSearchTemplateBaseItem, NetSearchTemplateBaseView paramNetSearchTemplateBaseView, Bitmap paramBitmap)
  {
    if (paramNetSearchTemplateBaseView.b() != null) {
      paramNetSearchTemplateBaseView.b().setImageBitmap(paramBitmap);
    }
  }
  
  protected void a(NetSearchTemplateQAItem paramNetSearchTemplateQAItem, NetSearchTemplateQAView paramNetSearchTemplateQAView)
  {
    Object localObject1 = paramNetSearchTemplateQAView.a().getContext();
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      paramNetSearchTemplateQAView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      paramNetSearchTemplateQAView.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#4A4A4A"));
    }
    else
    {
      paramNetSearchTemplateQAView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#262626"));
      paramNetSearchTemplateQAView.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
    }
    Object localObject2;
    Object localObject3;
    if (!TextUtils.isEmpty(paramNetSearchTemplateQAItem.jdField_b_of_type_JavaLangString))
    {
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      localObject3 = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject3);
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject3);
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = DisplayUtil.a((Context)localObject1, 18.0F);
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = DisplayUtil.a((Context)localObject1, 18.0F);
      ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "askIcon";
      localObject2 = URLDrawable.getDrawable(paramNetSearchTemplateQAItem.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
      paramNetSearchTemplateQAView.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      paramNetSearchTemplateQAView.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    }
    else
    {
      paramNetSearchTemplateQAView.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramNetSearchTemplateQAItem.j))
    {
      int j = paramNetSearchTemplateQAView.jdField_a_of_type_AndroidWidgetTextView.getContext().getResources().getDisplayMetrics().widthPixels;
      int i = (int)SearchUtils.a(paramNetSearchTemplateQAView.jdField_a_of_type_AndroidWidgetTextView, " ");
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
      localObject2 = paramNetSearchTemplateQAView.jdField_a_of_type_AndroidWidgetTextView;
      float f = j;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(paramNetSearchTemplateQAItem.j);
      localObject1 = SearchUtils.a((TextView)localObject2, f, 2, ((StringBuilder)localObject3).toString(), paramNetSearchTemplateQAItem.jdField_a_of_type_ComTencentMobileqqSearchUtilHighlightModel.jdField_a_of_type_JavaUtilList, false, false, true);
      paramNetSearchTemplateQAView.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
    }
    paramNetSearchTemplateQAView.a(paramNetSearchTemplateQAItem);
    if ((!TextUtils.isEmpty(paramNetSearchTemplateQAItem.k)) && (paramNetSearchTemplateQAItem.jdField_a_of_type_JavaUtilList != null) && (paramNetSearchTemplateQAItem.jdField_a_of_type_JavaUtilList.size() != 0))
    {
      paramNetSearchTemplateQAView.jdField_b_of_type_AndroidWidgetTextView.setText(paramNetSearchTemplateQAItem.k);
      paramNetSearchTemplateQAView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    paramNetSearchTemplateQAView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  protected void a(NetSearchTemplateTitleItem paramNetSearchTemplateTitleItem, NetSearchTemplateTitleView paramNetSearchTemplateTitleView)
  {
    Object localObject;
    if (!TextUtils.isEmpty(paramNetSearchTemplateTitleItem.jdField_b_of_type_JavaLangString))
    {
      paramNetSearchTemplateTitleView.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ColorDrawable localColorDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramNetSearchTemplateTitleView.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramNetSearchTemplateTitleView.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().height;
      localObject = URLDrawable.getDrawable(paramNetSearchTemplateTitleItem.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      paramNetSearchTemplateTitleView.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
    }
    else
    {
      paramNetSearchTemplateTitleView.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramNetSearchTemplateTitleItem.j))
    {
      paramNetSearchTemplateTitleView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      int i = paramNetSearchTemplateTitleView.jdField_a_of_type_AndroidWidgetTextView.getContext().getResources().getDisplayMetrics().widthPixels;
      localObject = SearchUtils.a(paramNetSearchTemplateTitleView.jdField_a_of_type_AndroidWidgetTextView, i, 1, paramNetSearchTemplateTitleItem.j, paramNetSearchTemplateTitleItem.jdField_a_of_type_ComTencentMobileqqSearchUtilHighlightModel.jdField_a_of_type_JavaUtilList, false, false, true);
      paramNetSearchTemplateTitleView.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    }
    else
    {
      paramNetSearchTemplateTitleView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramNetSearchTemplateTitleItem.l))
    {
      paramNetSearchTemplateTitleView.jdField_b_of_type_AndroidWidgetTextView.setText(paramNetSearchTemplateTitleItem.l);
      paramNetSearchTemplateTitleView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramNetSearchTemplateTitleView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    else
    {
      paramNetSearchTemplateTitleView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramNetSearchTemplateTitleView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramNetSearchTemplateTitleItem.k))
    {
      paramNetSearchTemplateTitleView.jdField_c_of_type_AndroidWidgetTextView.setText(paramNetSearchTemplateTitleItem.k);
      paramNetSearchTemplateTitleView.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    else
    {
      paramNetSearchTemplateTitleView.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      paramNetSearchTemplateTitleView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramNetSearchTemplateTitleView.jdField_a_of_type_AndroidWidgetTextView.getContext().getResources().getColor(2131166983));
      paramNetSearchTemplateTitleView.jdField_c_of_type_AndroidWidgetTextView.setTextColor(paramNetSearchTemplateTitleView.jdField_c_of_type_AndroidWidgetTextView.getContext().getResources().getColor(2131166982));
      paramNetSearchTemplateTitleView.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramNetSearchTemplateTitleView.jdField_b_of_type_AndroidWidgetTextView.getContext().getResources().getColor(2131166982));
      return;
    }
    paramNetSearchTemplateTitleView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#262626"));
    paramNetSearchTemplateTitleView.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
    paramNetSearchTemplateTitleView.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
  }
  
  protected void a(NetSearchTemplateHorSlidingContainerItem paramNetSearchTemplateHorSlidingContainerItem, NetSearchTemplateHorSlidingContainerView paramNetSearchTemplateHorSlidingContainerView)
  {
    if ((paramNetSearchTemplateHorSlidingContainerItem.jdField_a_of_type_JavaUtilArrayList != null) && (paramNetSearchTemplateHorSlidingContainerItem.jdField_a_of_type_JavaUtilArrayList.size() != 0))
    {
      SearchTemplateHorSlidingDataAdapter localSearchTemplateHorSlidingDataAdapter2 = (SearchTemplateHorSlidingDataAdapter)paramNetSearchTemplateHorSlidingContainerView.jdField_a_of_type_ComTencentWidgetHorizontalListView.getAdapter();
      SearchTemplateHorSlidingDataAdapter localSearchTemplateHorSlidingDataAdapter1;
      if (localSearchTemplateHorSlidingDataAdapter2 != null)
      {
        localSearchTemplateHorSlidingDataAdapter1 = localSearchTemplateHorSlidingDataAdapter2;
        if (localSearchTemplateHorSlidingDataAdapter2.a() == paramNetSearchTemplateHorSlidingContainerItem.jdField_a_of_type_JavaUtilArrayList) {}
      }
      else
      {
        localSearchTemplateHorSlidingDataAdapter1 = new SearchTemplateHorSlidingDataAdapter(paramNetSearchTemplateHorSlidingContainerItem, this.jdField_a_of_type_ComTencentMobileqqSearchAdapterGroupSearchAdapter.jdField_b_of_type_Int, paramNetSearchTemplateHorSlidingContainerView.jdField_a_of_type_ComTencentWidgetHorizontalListView);
        paramNetSearchTemplateHorSlidingContainerView.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(localSearchTemplateHorSlidingDataAdapter1);
      }
      if (localSearchTemplateHorSlidingDataAdapter1.a() != paramNetSearchTemplateHorSlidingContainerItem.jdField_a_of_type_JavaUtilArrayList)
      {
        paramNetSearchTemplateHorSlidingContainerView.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateHorSlidingContainerItem = paramNetSearchTemplateHorSlidingContainerItem;
        paramNetSearchTemplateHorSlidingContainerView.jdField_a_of_type_ComTencentWidgetHorizontalListView.resetCurrentX(paramNetSearchTemplateHorSlidingContainerItem.jdField_b_of_type_Int);
      }
      localSearchTemplateHorSlidingDataAdapter1.a(paramNetSearchTemplateHorSlidingContainerItem.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bindHorSlidingContainerTemplateView, containerItem.horizontalModelItems is empty");
    }
  }
  
  protected void a(NetSearchTemplateHorizontalContainerItem paramNetSearchTemplateHorizontalContainerItem, NetSearchTemplateHorizontalContainerView paramNetSearchTemplateHorizontalContainerView)
  {
    paramNetSearchTemplateHorizontalContainerView.a().getContext();
    paramNetSearchTemplateHorizontalContainerView.a();
    if ((paramNetSearchTemplateHorizontalContainerItem.jdField_a_of_type_JavaUtilArrayList != null) && (paramNetSearchTemplateHorizontalContainerItem.jdField_a_of_type_JavaUtilArrayList.size() != 0))
    {
      paramNetSearchTemplateHorizontalContainerView.a(paramNetSearchTemplateHorizontalContainerItem);
      if (paramNetSearchTemplateHorizontalContainerItem.jdField_a_of_type_JavaUtilArrayList.size() != paramNetSearchTemplateHorizontalContainerView.jdField_a_of_type_JavaUtilArrayList.size()) {
        QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bindHorizontalContainerTemplateView, view.size != model.size");
      }
      int j = paramNetSearchTemplateHorizontalContainerItem.jdField_a_of_type_JavaUtilArrayList.size();
      int i = 0;
      while (i < j)
      {
        ((NetSearchTemplateHorizontalBaseItem)paramNetSearchTemplateHorizontalContainerItem.jdField_a_of_type_JavaUtilArrayList.get(i)).a((NetSearchTemplateHorizontalBaseView)paramNetSearchTemplateHorizontalContainerView.jdField_a_of_type_JavaUtilArrayList.get(i));
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
    if ((paramNetSearchTemplateIndividuateContainerItem.jdField_a_of_type_JavaUtilList != null) && (paramNetSearchTemplateIndividuateContainerItem.jdField_a_of_type_JavaUtilList.size() != 0))
    {
      paramNetSearchTemplateIndividuateContainerView.a(paramNetSearchTemplateIndividuateContainerItem);
      if (paramNetSearchTemplateIndividuateContainerItem.jdField_a_of_type_JavaUtilList.size() != paramNetSearchTemplateIndividuateContainerView.jdField_a_of_type_JavaUtilList.size()) {
        QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bindIndividualContainerTemplateView, vas_search, view.size != model.size");
      }
      int j = paramNetSearchTemplateIndividuateContainerItem.jdField_a_of_type_JavaUtilList.size();
      int i = 0;
      while (i < j)
      {
        ((NetSearchTemplateHorizontalBaseItem)paramNetSearchTemplateIndividuateContainerItem.jdField_a_of_type_JavaUtilList.get(i)).a((NetSearchTemplateHorizontalBaseView)paramNetSearchTemplateIndividuateContainerView.jdField_a_of_type_JavaUtilList.get(i));
        i += 1;
      }
      paramNetSearchTemplateIndividuateContainerItem.a(j);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bindIndividualContainerTemplateView, vas_search, containerItem.horizontalModelItems is empty");
    }
  }
  
  protected void a(NetSearchTemplateMiniAppItem paramNetSearchTemplateMiniAppItem, NetSearchTemplateMiniAppView paramNetSearchTemplateMiniAppView)
  {
    Object localObject1 = (LinearLayout)paramNetSearchTemplateMiniAppView.b();
    if ((localObject1 != null) && (paramNetSearchTemplateMiniAppItem.a != null))
    {
      ((LinearLayout)localObject1).removeAllViews();
      if (((LinearLayout)localObject1).getParent() != null) {
        ((View)((LinearLayout)localObject1).getParent()).setPadding(0, 0, 0, 0);
      }
      MiniProgramSearchResultModel localMiniProgramSearchResultModel = paramNetSearchTemplateMiniAppItem.a;
      paramNetSearchTemplateMiniAppItem = paramNetSearchTemplateMiniAppView.a().getContext();
      Object localObject2 = LayoutInflater.from(paramNetSearchTemplateMiniAppItem).inflate(2131562799, null);
      MiniProgramSearchResultView localMiniProgramSearchResultView = new MiniProgramSearchResultView((View)localObject2);
      Object localObject3 = ((View)localObject2).findViewById(2131369010);
      int i = ViewUtils.a(6.0F);
      ((View)localObject3).setPadding(0, i, 0, i);
      ((LinearLayout)localObject1).addView((View)localObject2);
      if (localMiniProgramSearchResultModel.a() == null)
      {
        if (localMiniProgramSearchResultView.c() != null) {
          localMiniProgramSearchResultView.c().setVisibility(8);
        }
        if (localMiniProgramSearchResultView.a() != null) {
          localMiniProgramSearchResultView.a().setVisibility(8);
        }
        localObject1 = localMiniProgramSearchResultView.a();
        if (localObject1 != null) {
          ((URLImageView)localObject1).setVisibility(8);
        }
        localObject1 = localMiniProgramSearchResultView.e();
        if (localObject1 != null)
        {
          ((TextView)localObject1).setVisibility(0);
          if (!TextUtils.isEmpty(localMiniProgramSearchResultModel.b())) {
            ((TextView)localObject1).setText(localMiniProgramSearchResultModel.b());
          }
        }
      }
      else
      {
        if ((localMiniProgramSearchResultView.c() != null) && (!TextUtils.isEmpty(localMiniProgramSearchResultModel.a())))
        {
          localMiniProgramSearchResultView.c().setVisibility(0);
          localMiniProgramSearchResultView.c().setText(localMiniProgramSearchResultModel.a());
        }
        else if (localMiniProgramSearchResultView.c() != null)
        {
          localMiniProgramSearchResultView.c().setVisibility(8);
        }
        if (localMiniProgramSearchResultView.a() != null) {
          localMiniProgramSearchResultView.a().setVisibility(0);
        }
        localObject1 = localMiniProgramSearchResultView.e();
        if (localObject1 != null) {
          ((TextView)localObject1).setVisibility(8);
        }
        if (!TextUtils.isEmpty(localMiniProgramSearchResultModel.b())) {
          localMiniProgramSearchResultView.a().setText(localMiniProgramSearchResultModel.b());
        }
      }
      if ((localMiniProgramSearchResultView.b() != null) && (!TextUtils.isEmpty(localMiniProgramSearchResultModel.f())))
      {
        localObject1 = localMiniProgramSearchResultModel.f();
        localObject2 = new ColorDrawable(Color.parseColor("#e7e7e7"));
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = DisplayUtil.a(paramNetSearchTemplateMiniAppItem, 50.0F);
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = DisplayUtil.a(paramNetSearchTemplateMiniAppItem, 50.0F);
        ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject2);
        ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject2);
        if (URLUtil.a((String)localObject1))
        {
          localObject1 = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject3);
          ((URLDrawable)localObject1).setTag(URLDrawableDecodeHandler.b(DisplayUtil.a(paramNetSearchTemplateMiniAppItem, 50.0F), DisplayUtil.a(paramNetSearchTemplateMiniAppView.a().getContext(), 50.0F), DisplayUtil.a(paramNetSearchTemplateMiniAppItem, 3.0F)));
          ((URLDrawable)localObject1).setDecodeHandler(URLDrawableDecodeHandler.i);
          localMiniProgramSearchResultView.b().setImageDrawable((Drawable)localObject1);
          if ((((URLDrawable)localObject1).getStatus() != 1) && (((URLDrawable)localObject1).getStatus() != 0)) {
            ((URLDrawable)localObject1).restartDownload();
          }
        }
        else
        {
          localMiniProgramSearchResultView.b().setImageDrawable((Drawable)localObject2);
        }
      }
      localMiniProgramSearchResultView.a().setOnClickListener(new SearchTemplatePresenter.2(this, localMiniProgramSearchResultModel));
      if ((localMiniProgramSearchResultView.a() != null) && (localMiniProgramSearchResultModel.c()))
      {
        paramNetSearchTemplateMiniAppView = localMiniProgramSearchResultModel.g();
        localObject1 = new ColorDrawable(Color.parseColor("#e7e7e7"));
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = DisplayUtil.a(paramNetSearchTemplateMiniAppItem, 40.0F);
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = DisplayUtil.a(paramNetSearchTemplateMiniAppItem, 12.0F);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
        paramNetSearchTemplateMiniAppView = URLDrawable.getDrawable(paramNetSearchTemplateMiniAppView, (URLDrawable.URLDrawableOptions)localObject2);
        paramNetSearchTemplateMiniAppView.setTag(URLDrawableDecodeHandler.b(DisplayUtil.a(paramNetSearchTemplateMiniAppItem, 38.0F), DisplayUtil.a(paramNetSearchTemplateMiniAppItem, 12.0F), 0));
        paramNetSearchTemplateMiniAppView.setDecodeHandler(URLDrawableDecodeHandler.i);
        localMiniProgramSearchResultView.a().setImageDrawable(paramNetSearchTemplateMiniAppView);
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
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).report4239Async(paramNetSearchTemplateMiniAppView, "search", "result_view", paramNetSearchTemplateMiniAppItem, localMiniProgramSearchResultModel.b());
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
    paramImageView = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    paramImageView.setBounds(0, 0, paramInt1, paramInt2);
    paramString2 = paramImageView;
    try
    {
      if (TextUtils.isEmpty(paramString1)) {
        break label364;
      }
      paramTextView = URLDrawable.URLDrawableOptions.obtain();
      paramTextView.mRequestWidth = paramInt1;
      paramTextView.mRequestHeight = paramInt2;
      paramTextView.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      paramTextView.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      if (paramBoolean2)
      {
        paramTextView.mMemoryCacheKeySuffix = "isAvatar";
        paramString2 = URLDrawable.getDrawable(paramString1, paramTextView);
        paramString2.setDecodeHandler(URLDrawableDecodeHandler.a);
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
          break label364;
        }
        paramString2 = paramTextView;
        if (paramTextView.getStatus() == 0) {
          break label364;
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
    label364:
    paramSquareImageView.setImageDrawable(paramString2);
  }
  
  protected void b(NetSearchTemplateBaseItem paramNetSearchTemplateBaseItem, NetSearchTemplateBaseView paramNetSearchTemplateBaseView)
  {
    if (paramNetSearchTemplateBaseView.a() != null) {
      paramNetSearchTemplateBaseView.a().setOnClickListener(new SearchTemplatePresenter.1(this, paramNetSearchTemplateBaseItem));
    }
  }
  
  public void c(NetSearchTemplateBaseItem paramNetSearchTemplateBaseItem, NetSearchTemplateBaseView paramNetSearchTemplateBaseView)
  {
    if ((paramNetSearchTemplateBaseView.b() != null) && ((paramNetSearchTemplateBaseItem instanceof IFaceModel)) && (!TextUtils.isEmpty(paramNetSearchTemplateBaseItem.a()))) {
      paramNetSearchTemplateBaseView.b().setImageDrawable(SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, paramNetSearchTemplateBaseItem));
    }
  }
  
  public String getToken()
  {
    return QQPlayerService.a(7, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentUin());
  }
  
  public void onPlaySongChanged(SongInfo paramSongInfo) {}
  
  public void onPlayStateChanged(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null)
    {
      if (((WeakReference)localObject).get() == null) {
        return;
      }
      localObject = (ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
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
        SearchUtils.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
        ((ImageView)localObject).post(new SearchTemplatePresenter.11(this, (ImageView)localObject, bool));
        ((ImageView)localObject).setContentDescription(localResources.getString(2131690213));
        this.jdField_a_of_type_ComTencentMobileqqSearchAdapterGroupSearchAdapter.notifyDataSetChanged();
        return;
      }
      ((ImageView)localObject).post(new SearchTemplatePresenter.12(this, (ImageView)localObject, bool));
      ((ImageView)localObject).setContentDescription(localResources.getString(2131690211));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.SearchTemplatePresenter
 * JD-Core Version:    0.7.0.1
 */