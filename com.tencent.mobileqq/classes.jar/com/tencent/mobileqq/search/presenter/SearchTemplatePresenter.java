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
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.QQPlayerService.QQPlayerCallback;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.activity.PublicAcntSearchActivity;
import com.tencent.mobileqq.search.adapter.GroupSearchAdapter;
import com.tencent.mobileqq.search.adapter.SearchTemplateHorSlidingDataAdapter;
import com.tencent.mobileqq.search.model.IFaceModel;
import com.tencent.mobileqq.search.model.ImageItem;
import com.tencent.mobileqq.search.model.MiniProgramSearchResultModel;
import com.tencent.mobileqq.search.model.NetSearchTemplateAvatarsItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateBannerTitleItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateBaseItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateBaseItem.ImageInfo;
import com.tencent.mobileqq.search.model.NetSearchTemplateBigImageItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateFriendUpdatesItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateHorSlidingContainerItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateHorizontalBaseItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateHorizontalContainerItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateMiniAppItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateNetSeaEntranceItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateNewEntranceItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateQAItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateSubItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateSubItemTitle;
import com.tencent.mobileqq.search.model.NetSearchTemplateTitleItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateUniversalItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateUniversalItem.ActionInfo;
import com.tencent.mobileqq.search.model.NetSearchTemplateUniversalItem.HeadIconInfo;
import com.tencent.mobileqq.search.model.NetSearchTemplateUniversalItem.NormalWord;
import com.tencent.mobileqq.search.model.NetSearchTemplateUpdatesItem;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.HighlightModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.SearchViewUtils;
import com.tencent.mobileqq.search.view.MiniProgramSearchResultView;
import com.tencent.mobileqq.search.view.NetSearchTemplateAvatarsView;
import com.tencent.mobileqq.search.view.NetSearchTemplateBannerTitleView;
import com.tencent.mobileqq.search.view.NetSearchTemplateBaseView;
import com.tencent.mobileqq.search.view.NetSearchTemplateBigImageView;
import com.tencent.mobileqq.search.view.NetSearchTemplateFriendUpdatesView;
import com.tencent.mobileqq.search.view.NetSearchTemplateHorSlidingContainerView;
import com.tencent.mobileqq.search.view.NetSearchTemplateHorizontalBaseView;
import com.tencent.mobileqq.search.view.NetSearchTemplateHorizontalContainerView;
import com.tencent.mobileqq.search.view.NetSearchTemplateMiniAppView;
import com.tencent.mobileqq.search.view.NetSearchTemplateNetSeaEntranceView;
import com.tencent.mobileqq.search.view.NetSearchTemplateNewEntranceView;
import com.tencent.mobileqq.search.view.NetSearchTemplateQAView;
import com.tencent.mobileqq.search.view.NetSearchTemplateSubItemTitleView;
import com.tencent.mobileqq.search.view.NetSearchTemplateSubItemView;
import com.tencent.mobileqq.search.view.NetSearchTemplateTitleView;
import com.tencent.mobileqq.search.view.NetSearchTemplateUniversalView;
import com.tencent.mobileqq.search.view.NetSearchTemplateUpdatesView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ViewUtils;
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
  implements QQPlayerService.QQPlayerCallback, IFacePresenter<NetSearchTemplateBaseItem, NetSearchTemplateBaseView>
{
  public static int a;
  private long jdField_a_of_type_Long;
  public ColorDrawable a;
  public Drawable a;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private GroupSearchAdapter jdField_a_of_type_ComTencentMobileqqSearchAdapterGroupSearchAdapter;
  private WeakReference<ImageView> jdField_a_of_type_JavaLangRefWeakReference;
  
  static
  {
    jdField_a_of_type_Int = 0;
  }
  
  public SearchTemplatePresenter(IFaceDecoder paramIFaceDecoder, GroupSearchAdapter paramGroupSearchAdapter)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = URLDrawableHelper.TRANSPARENT;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = paramIFaceDecoder;
    this.jdField_a_of_type_ComTencentMobileqqSearchAdapterGroupSearchAdapter = paramGroupSearchAdapter;
  }
  
  private float a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return 7.0F;
    }
    return 3.5F;
  }
  
  private int a(NetSearchTemplateUniversalItem paramNetSearchTemplateUniversalItem, NetSearchTemplateUniversalView paramNetSearchTemplateUniversalView)
  {
    if ((paramNetSearchTemplateUniversalItem == null) || (paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem$ActionInfo == null) || (paramNetSearchTemplateUniversalView == null) || (paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetRelativeLayout == null))
    {
      if ((paramNetSearchTemplateUniversalView != null) && (paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetButton != null)) {
        paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      if ((paramNetSearchTemplateUniversalView != null) && (paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetImageView != null)) {
        paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      return 0;
    }
    if (paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem$ActionInfo.jdField_a_of_type_Int == 1)
    {
      if (paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetButton != null) {
        paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      if (paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetImageView != null) {
        paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      return 0;
    }
    boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    Context localContext = paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext();
    int i;
    if (paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem$ActionInfo.jdField_a_of_type_Int == 2)
    {
      if (paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetImageView != null) {
        paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetButton == null) {
        return 0;
      }
      if (!TextUtils.isEmpty(paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem$ActionInfo.jdField_a_of_type_JavaLangCharSequence))
      {
        paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetButton.setText(paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem$ActionInfo.jdField_a_of_type_JavaLangCharSequence);
        paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new SearchTemplatePresenter.7(this, localContext, paramNetSearchTemplateUniversalItem));
      }
      for (;;)
      {
        i = (int)(0 + (SearchUtils.a(paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetButton, paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem$ActionInfo.jdField_a_of_type_JavaLangCharSequence) + DisplayUtil.a(localContext, 32.0F) + DisplayUtil.a(localContext, 15.0F)));
        if (!bool) {
          break;
        }
        paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130843527);
        paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#6991B8"));
        return i;
        paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130843526);
      paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#000000"));
      return i;
    }
    int j;
    if (paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem$ActionInfo.jdField_a_of_type_Int == 3)
    {
      if (paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetButton != null) {
        paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      if ((paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetImageView == null)) {
        return 0;
      }
      int k = ((Integer)paramNetSearchTemplateUniversalView.a().getTag(2131381652)).intValue();
      SongInfo localSongInfo1 = new SongInfo();
      i = 0;
      j = i;
      for (;;)
      {
        try
        {
          JSONObject localJSONObject = new JSONObject(paramNetSearchTemplateUniversalItem.h);
          j = i;
          localSongInfo1.jdField_b_of_type_JavaLangString = localJSONObject.optString("audio_url");
          j = i;
          localSongInfo1.jdField_c_of_type_JavaLangString = localJSONObject.optString("title");
          j = i;
          localSongInfo1.d = localJSONObject.optString("desc");
          j = i;
          localSongInfo1.e = localJSONObject.optString("image_url");
          j = i;
          if (TextUtils.isEmpty(localJSONObject.optString("id"))) {
            continue;
          }
          i = 1;
          if (i != 0)
          {
            j = i;
            localSongInfo1.jdField_a_of_type_Long = Long.parseLong(localJSONObject.optString("id"));
          }
          j = i;
          int m = localJSONObject.optInt("playable");
          if (m != 1) {
            continue;
          }
          j = 1;
        }
        catch (Exception localException)
        {
          i = j;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.uniteSearch.SearchTemplatePresenter", 2, localException.toString());
          j = 0;
          continue;
          SongInfo localSongInfo2 = QQPlayerService.b();
          if (localSongInfo2 == null) {
            continue;
          }
          SearchUtils.jdField_a_of_type_Long = localSongInfo2.jdField_a_of_type_Long;
          continue;
          paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850036);
          continue;
          if (this.jdField_a_of_type_Long != SearchUtils.jdField_a_of_type_Long) {
            continue;
          }
          paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850037);
          continue;
          paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850035);
          continue;
          paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          continue;
        }
        this.jdField_a_of_type_Long = localSongInfo1.jdField_a_of_type_Long;
        QQPlayerService.a(this);
        if (QQPlayerService.a() == 2) {
          continue;
        }
        SearchUtils.jdField_a_of_type_Long = -1L;
        if (!bool) {
          continue;
        }
        if (this.jdField_a_of_type_Long != SearchUtils.jdField_a_of_type_Long) {
          continue;
        }
        paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850038);
        if ((j == 0) || (i == 0) || (TextUtils.isEmpty(localSongInfo1.jdField_b_of_type_JavaLangString))) {
          continue;
        }
        paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new SearchTemplatePresenter.8(this, paramNetSearchTemplateUniversalView, k, localContext, bool, localSongInfo1, paramNetSearchTemplateUniversalItem));
        return DisplayUtil.a(localContext, 39.0F) + 0;
        i = 0;
        continue;
        j = 0;
      }
    }
    paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    return 0;
  }
  
  private int a(NetSearchTemplateUniversalItem paramNetSearchTemplateUniversalItem, NetSearchTemplateUniversalView paramNetSearchTemplateUniversalView, int paramInt1, int paramInt2)
  {
    if ((paramNetSearchTemplateUniversalView == null) || (paramNetSearchTemplateUniversalItem == null) || (paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetLinearLayout == null)) {
      return 0;
    }
    Context localContext = paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetLinearLayout.getContext();
    int i = localContext.getResources().getDisplayMetrics().widthPixels - paramInt1 - paramInt2 - DisplayUtil.a(localContext, 30.0F);
    if ((paramNetSearchTemplateUniversalItem.jdField_a_of_type_JavaUtilArrayList != null) && (paramNetSearchTemplateUniversalItem.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if ((paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem$HeadIconInfo != null) && (paramNetSearchTemplateUniversalItem.jdField_a_of_type_JavaUtilArrayList != null) && (paramNetSearchTemplateUniversalItem.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        if (paramNetSearchTemplateUniversalView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView != null) {
          paramNetSearchTemplateUniversalView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(8);
        }
        if (paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_a_of_type_Int == 1)
        {
          if (paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetTextView != null) {
            paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          if ((paramNetSearchTemplateUniversalView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView == null) || (TextUtils.isEmpty(paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_a_of_type_JavaLangString))) {
            break label1007;
          }
          paramNetSearchTemplateUniversalView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(0);
          a(paramNetSearchTemplateUniversalView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView, paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_a_of_type_JavaLangString);
          paramInt1 = i - DisplayUtil.a(localContext, 24.0F);
        }
      }
    }
    for (;;)
    {
      Object localObject1;
      if ((paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(((NetSearchTemplateUniversalItem.NormalWord)paramNetSearchTemplateUniversalItem.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangCharSequence)))
      {
        localObject1 = ((NetSearchTemplateUniversalItem.NormalWord)paramNetSearchTemplateUniversalItem.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangCharSequence;
        if (!((NetSearchTemplateUniversalItem.NormalWord)paramNetSearchTemplateUniversalItem.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Boolean) {
          break label635;
        }
        localObject1 = SearchUtils.a(paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetTextView, paramInt1, 1, ((CharSequence)localObject1).toString(), paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchUtilHighlightModel.jdField_a_of_type_JavaUtilList, false, false, true);
        label297:
        paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      }
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramNetSearchTemplateUniversalView.c != null) {
          break label677;
        }
        return paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetLinearLayout.getHeight();
        if (paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_a_of_type_Int == 2)
        {
          if (paramNetSearchTemplateUniversalView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView != null) {
            paramNetSearchTemplateUniversalView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(8);
          }
          if ((paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetTextView == null) || (TextUtils.isEmpty(paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_a_of_type_JavaLangCharSequence))) {
            break label1007;
          }
          if (SearchUtils.e(paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_b_of_type_JavaLangString)) {}
          for (localObject1 = paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_b_of_type_JavaLangString;; localObject1 = "#fd7f32")
          {
            ((GradientDrawable)paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetTextView.getBackground()).setColor(Color.parseColor((String)localObject1));
            paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetTextView.setText(paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_a_of_type_JavaLangCharSequence);
            paramInt1 = (int)(i - (SearchUtils.a(paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetTextView, paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_a_of_type_JavaLangCharSequence) + DisplayUtil.a(localContext, 10.0F)));
            break;
          }
        }
        if (paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_a_of_type_Int != 3) {
          break label1007;
        }
        if (paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetTextView != null) {
          paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        if ((paramNetSearchTemplateUniversalView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView == null) || (TextUtils.isEmpty(paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_a_of_type_JavaLangString))) {
          break label1007;
        }
        paramNetSearchTemplateUniversalView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(0);
        if ((paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_b_of_type_Int > 0) && (paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_c_of_type_Int > 0))
        {
          a(paramNetSearchTemplateUniversalView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView, paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_b_of_type_Int, paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_c_of_type_Int, paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_a_of_type_JavaLangString);
          paramInt1 = i - DisplayUtil.a(localContext, DisplayUtil.a(localContext, paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_b_of_type_Int) + 4);
          break;
        }
        a(paramNetSearchTemplateUniversalView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView, paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_a_of_type_JavaLangString);
        paramInt1 = i - DisplayUtil.a(localContext, 24.0F);
        break;
        label635:
        localObject1 = SearchUtils.a(paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetTextView, paramInt1, ((CharSequence)localObject1).toString());
        break label297;
        if (paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
          paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
      }
      label677:
      paramNetSearchTemplateUniversalView.c.removeAllViews();
      NetSearchTemplateUniversalItem.NormalWord localNormalWord;
      TextView localTextView;
      if ((paramNetSearchTemplateUniversalItem.jdField_a_of_type_JavaUtilArrayList != null) && (paramNetSearchTemplateUniversalItem.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        while (paramInt1 < paramNetSearchTemplateUniversalItem.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localNormalWord = (NetSearchTemplateUniversalItem.NormalWord)paramNetSearchTemplateUniversalItem.jdField_a_of_type_JavaUtilArrayList.get(paramInt1);
          localTextView = new TextView(localContext);
          a(localTextView, localNormalWord.jdField_a_of_type_JavaLangString, localNormalWord.jdField_a_of_type_Int);
          localObject1 = localNormalWord.jdField_a_of_type_JavaLangCharSequence;
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            paramInt1 += 1;
          }
          else
          {
            if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
              break label1004;
            }
            localObject1 = ((CharSequence)localObject1).toString();
          }
        }
      }
      label952:
      label1004:
      for (;;)
      {
        paramInt2 = localNormalWord.jdField_a_of_type_Int;
        if ((localContext instanceof PublicAcntSearchActivity)) {
          paramInt2 = 1;
        }
        Object localObject2 = localObject1;
        if (localNormalWord.jdField_a_of_type_Boolean) {
          if ((!localNormalWord.jdField_a_of_type_JavaLangString.equals("A")) && (!localNormalWord.jdField_a_of_type_JavaLangString.equals("B"))) {
            break label952;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          localObject2 = SearchUtils.a(localTextView, i, paramInt2, ((CharSequence)localObject1).toString(), paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchUtilHighlightModel.jdField_a_of_type_JavaUtilList, false, bool, true);
          if (paramInt1 != 0) {
            localTextView.setPadding(0, DisplayUtil.a(localContext, 7.0F - a(((NetSearchTemplateUniversalItem.NormalWord)paramNetSearchTemplateUniversalItem.jdField_a_of_type_JavaUtilArrayList.get(paramInt1 - 1)).jdField_a_of_type_JavaLangString, localNormalWord.jdField_a_of_type_JavaLangString)), 0, 0);
          }
          localTextView.setText((CharSequence)localObject2);
          paramNetSearchTemplateUniversalView.c.addView(localTextView);
          break;
        }
        paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        b(paramNetSearchTemplateUniversalItem, paramNetSearchTemplateUniversalView);
        paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0);
        paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetLinearLayout.measure(paramInt1, paramInt2);
        return paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredHeight();
      }
      label1007:
      paramInt1 = i;
    }
  }
  
  private StateListDrawable a(String paramString)
  {
    Object localObject;
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
      localObject = "#040E1C";
    }
    for (paramString = "#194A90";; paramString = "#E5E6E7")
    {
      StateListDrawable localStateListDrawable = new StateListDrawable();
      paramString = new ColorDrawable(Color.parseColor(paramString));
      localObject = new ColorDrawable(Color.parseColor((String)localObject));
      localStateListDrawable.addState(new int[] { 16842919, 16842910 }, paramString);
      localStateListDrawable.addState(new int[0], (Drawable)localObject);
      return localStateListDrawable;
      localObject = paramString;
      if (!SearchUtils.e(paramString)) {
        localObject = "#F1F1F1";
      }
    }
  }
  
  public static Pair<Integer, Integer> a(NetSearchTemplateBaseItem paramNetSearchTemplateBaseItem, NetSearchTemplateBaseView paramNetSearchTemplateBaseView, boolean paramBoolean, int paramInt)
  {
    if ((paramNetSearchTemplateBaseView == null) || (paramNetSearchTemplateBaseView.jdField_b_of_type_AndroidWidgetRelativeLayout == null) || (paramNetSearchTemplateBaseView.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView == null) || (paramNetSearchTemplateBaseItem == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.SearchTemplatePresenter", 2, "bindUniversalTemplateLeftImageview or item is null");
      }
      return new Pair(Integer.valueOf(0), Integer.valueOf(0));
    }
    SquareImageView localSquareImageView = paramNetSearchTemplateBaseView.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView;
    NetSearchTemplateBaseItem.ImageInfo localImageInfo = paramNetSearchTemplateBaseItem.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateBaseItem$ImageInfo;
    if ((localImageInfo == null) || (TextUtils.isEmpty(localImageInfo.jdField_a_of_type_JavaLangString)))
    {
      paramNetSearchTemplateBaseView.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return new Pair(Integer.valueOf(0), Integer.valueOf(0));
    }
    paramNetSearchTemplateBaseView.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    Object localObject = localSquareImageView.getContext();
    paramNetSearchTemplateBaseItem = a(localSquareImageView, localImageInfo.jdField_a_of_type_Int, localImageInfo.jdField_a_of_type_JavaLangString, localImageInfo.jdField_b_of_type_Int, paramBoolean, paramInt, paramNetSearchTemplateBaseItem);
    paramInt = ((Integer)paramNetSearchTemplateBaseItem.first).intValue();
    int i = ((Integer)paramNetSearchTemplateBaseItem.second).intValue();
    paramNetSearchTemplateBaseItem = localSquareImageView.getLayoutParams();
    paramNetSearchTemplateBaseItem.width = paramInt;
    paramNetSearchTemplateBaseItem.height = i;
    localSquareImageView.setLayoutParams(paramNetSearchTemplateBaseItem);
    paramNetSearchTemplateBaseItem = (RelativeLayout.LayoutParams)paramNetSearchTemplateBaseView.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    paramNetSearchTemplateBaseItem.width = paramInt;
    paramNetSearchTemplateBaseItem.height = i;
    paramNetSearchTemplateBaseView.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramNetSearchTemplateBaseItem);
    int j = DisplayUtil.a((Context)localObject, 10.0F);
    if ((!TextUtils.isEmpty(localImageInfo.jdField_a_of_type_JavaLangCharSequence)) && (paramNetSearchTemplateBaseView.e != null)) {
      if (SearchUtils.e(localImageInfo.jdField_b_of_type_JavaLangString))
      {
        paramNetSearchTemplateBaseItem = localImageInfo.jdField_b_of_type_JavaLangString;
        ((GradientDrawable)paramNetSearchTemplateBaseView.e.getBackground()).setColor(Color.parseColor(paramNetSearchTemplateBaseItem));
        paramNetSearchTemplateBaseView.e.setVisibility(0);
        paramNetSearchTemplateBaseView.e.setText(localImageInfo.jdField_a_of_type_JavaLangCharSequence);
        label303:
        if (paramNetSearchTemplateBaseView.jdField_c_of_type_AndroidWidgetImageView != null)
        {
          if (!localImageInfo.jdField_a_of_type_Boolean) {
            break label565;
          }
          paramNetSearchTemplateBaseView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        label326:
        if (paramNetSearchTemplateBaseView.f != null)
        {
          if (TextUtils.isEmpty(localImageInfo.jdField_b_of_type_JavaLangCharSequence)) {
            break label577;
          }
          paramNetSearchTemplateBaseView.f.setVisibility(0);
          paramNetSearchTemplateBaseView.f.setText(localImageInfo.jdField_b_of_type_JavaLangCharSequence);
        }
        label364:
        if (paramNetSearchTemplateBaseView.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView != null)
        {
          if (TextUtils.isEmpty(localImageInfo.jdField_c_of_type_JavaLangString)) {
            break label589;
          }
          paramNetSearchTemplateBaseView.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(0);
          paramNetSearchTemplateBaseItem = URLDrawable.URLDrawableOptions.obtain();
          localObject = new ColorDrawable(-1);
          paramNetSearchTemplateBaseItem.mFailedDrawable = ((Drawable)localObject);
          paramNetSearchTemplateBaseItem.mLoadingDrawable = ((Drawable)localObject);
          paramNetSearchTemplateBaseItem.mRequestWidth = paramNetSearchTemplateBaseView.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.getLayoutParams().width;
          paramNetSearchTemplateBaseItem.mRequestHeight = paramNetSearchTemplateBaseView.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.getLayoutParams().height;
          paramNetSearchTemplateBaseItem = URLDrawable.getDrawable(localImageInfo.jdField_c_of_type_JavaLangString, paramNetSearchTemplateBaseItem);
          if ((paramNetSearchTemplateBaseItem.getStatus() != 1) && (paramNetSearchTemplateBaseItem.getStatus() != 0)) {
            paramNetSearchTemplateBaseItem.restartDownload();
          }
          paramNetSearchTemplateBaseView.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.setImageDrawable(paramNetSearchTemplateBaseItem);
        }
        label481:
        if (paramNetSearchTemplateBaseView.g != null)
        {
          if (TextUtils.isEmpty(localImageInfo.jdField_c_of_type_JavaLangCharSequence)) {
            break label601;
          }
          paramNetSearchTemplateBaseView.g.setVisibility(0);
          paramNetSearchTemplateBaseView.g.setText(localImageInfo.jdField_c_of_type_JavaLangCharSequence);
        }
      }
    }
    for (;;)
    {
      return new Pair(Integer.valueOf(paramInt + j), Integer.valueOf(i));
      paramNetSearchTemplateBaseItem = "#fd7f32";
      break;
      if (paramNetSearchTemplateBaseView.e == null) {
        break label303;
      }
      paramNetSearchTemplateBaseView.e.setVisibility(8);
      break label303;
      label565:
      paramNetSearchTemplateBaseView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      break label326;
      label577:
      paramNetSearchTemplateBaseView.f.setVisibility(8);
      break label364;
      label589:
      paramNetSearchTemplateBaseView.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(8);
      break label481;
      label601:
      paramNetSearchTemplateBaseView.g.setVisibility(8);
    }
  }
  
  public static Pair<Integer, Integer> a(SquareImageView paramSquareImageView, int paramInt1, String paramString, int paramInt2, boolean paramBoolean, int paramInt3, NetSearchTemplateBaseItem paramNetSearchTemplateBaseItem)
  {
    int j = 0;
    int i = 0;
    if ((paramSquareImageView == null) || (TextUtils.isEmpty(paramString))) {
      return new Pair(Integer.valueOf(0), Integer.valueOf(0));
    }
    Object localObject = paramSquareImageView.getContext();
    ColorDrawable localColorDrawable;
    switch (paramInt1)
    {
    default: 
      paramInt1 = DisplayUtil.a((Context)localObject, 60.0F);
      i = DisplayUtil.a((Context)localObject, 60.0F);
      j = 0;
      localColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
      if (paramBoolean)
      {
        paramInt1 = (int)(i * 1.0F / paramInt1 * paramInt3);
        if (j != 0)
        {
          i = (int)(paramInt3 * 0.2D / 2.0D);
          paramSquareImageView.setPadding(DisplayUtil.a((Context)localObject, 3.0F), DisplayUtil.a((Context)localObject, 3.0F), DisplayUtil.a((Context)localObject, 3.0F), DisplayUtil.a((Context)localObject, 3.0F));
          paramNetSearchTemplateBaseItem = (RelativeLayout.LayoutParams)paramSquareImageView.getLayoutParams();
          i -= DisplayUtil.a((Context)localObject, 3.0F);
          paramNetSearchTemplateBaseItem.rightMargin = i;
          paramNetSearchTemplateBaseItem.leftMargin = i;
          paramNetSearchTemplateBaseItem.topMargin = i;
          paramSquareImageView.setLayoutParams(paramNetSearchTemplateBaseItem);
        }
      }
      break;
    }
    for (;;)
    {
      paramSquareImageView.setImageScale(paramInt3 * 1.0F / paramInt1, 0.0F);
      for (;;)
      {
        try
        {
          if (TextUtils.isEmpty(paramString)) {
            continue;
          }
          paramNetSearchTemplateBaseItem = URLDrawable.URLDrawableOptions.obtain();
          paramNetSearchTemplateBaseItem.mRequestWidth = paramInt3;
          paramNetSearchTemplateBaseItem.mRequestHeight = paramInt1;
          if (j == 0) {
            continue;
          }
          localObject = new GradientDrawable();
          ((GradientDrawable)localObject).setShape(0);
          ((GradientDrawable)localObject).setCornerRadius(paramInt3 / 2.0F);
          ((GradientDrawable)localObject).setColor(-1579033);
          paramNetSearchTemplateBaseItem.mLoadingDrawable = ((Drawable)localObject);
          paramNetSearchTemplateBaseItem.mFailedDrawable = ((Drawable)localObject);
          paramNetSearchTemplateBaseItem.mPlayGifImage = true;
          if (j == 0) {
            continue;
          }
          paramNetSearchTemplateBaseItem.mMemoryCacheKeySuffix = ("isAvatar" + paramInt3 + paramInt1);
          paramNetSearchTemplateBaseItem = URLDrawable.getDrawable(paramString, paramNetSearchTemplateBaseItem);
          paramNetSearchTemplateBaseItem.setDecodeHandler(URLDrawableDecodeHandler.a);
        }
        catch (Exception paramNetSearchTemplateBaseItem)
        {
          QLog.e("Q.uniteSearch.SearchTemplatePresenter", 1, "imageUrl is not valid. imageUrl=" + paramString, paramNetSearchTemplateBaseItem);
          localObject = localColorDrawable;
          continue;
          paramNetSearchTemplateBaseItem.mMemoryCacheKeySuffix = ("isNotAvatar" + paramInt3 + paramInt1 + paramInt2);
          paramNetSearchTemplateBaseItem = URLDrawable.getDrawable(paramString, paramNetSearchTemplateBaseItem);
          paramNetSearchTemplateBaseItem.setTag(URLDrawableDecodeHandler.b(paramInt3, paramInt1, paramInt2));
          paramNetSearchTemplateBaseItem.setDecodeHandler(URLDrawableDecodeHandler.j);
          continue;
        }
        localObject = paramNetSearchTemplateBaseItem;
        if (paramNetSearchTemplateBaseItem.getStatus() != 1)
        {
          localObject = paramNetSearchTemplateBaseItem;
          if (paramNetSearchTemplateBaseItem.getStatus() != 0)
          {
            paramNetSearchTemplateBaseItem.restartDownload();
            localObject = paramNetSearchTemplateBaseItem;
          }
        }
        paramSquareImageView.setImageDrawable((Drawable)localObject);
        return new Pair(Integer.valueOf(paramInt3), Integer.valueOf(paramInt1));
        paramInt1 = DisplayUtil.a((Context)localObject, 60.0F);
        i = DisplayUtil.a((Context)localObject, 60.0F);
        j = 0;
        break;
        paramInt1 = DisplayUtil.a((Context)localObject, 50.0F);
        i = DisplayUtil.a((Context)localObject, 50.0F);
        j = 0;
        break;
        if ((paramSquareImageView.getContext() instanceof PublicAcntSearchActivity))
        {
          paramInt1 = DisplayUtil.a(paramSquareImageView.getContext(), 50.0F);
          i = DisplayUtil.a(paramSquareImageView.getContext(), 50.0F);
          j = 1;
          break;
        }
        paramInt1 = DisplayUtil.a((Context)localObject, 60.0F);
        i = DisplayUtil.a((Context)localObject, 60.0F);
        continue;
        paramInt1 = DisplayUtil.a((Context)localObject, 50.0F);
        i = DisplayUtil.a((Context)localObject, 50.0F);
        j = 1;
        break;
        paramInt1 = DisplayUtil.a((Context)localObject, 60.0F);
        i = DisplayUtil.a((Context)localObject, 85.0F);
        j = 0;
        break;
        paramInt1 = DisplayUtil.a((Context)localObject, 113.0F);
        i = DisplayUtil.a((Context)localObject, 60.0F);
        j = 0;
        break;
        paramInt1 = DisplayUtil.a((Context)localObject, 100.0F);
        i = DisplayUtil.a((Context)localObject, 141.0F);
        j = 0;
        break;
        paramInt1 = j;
        if ((paramNetSearchTemplateBaseItem instanceof NetSearchTemplateUniversalItem))
        {
          paramInt1 = DisplayUtil.a((Context)localObject, paramNetSearchTemplateBaseItem.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateBaseItem$ImageInfo.jdField_c_of_type_Int / 2);
          i = DisplayUtil.a((Context)localObject, paramNetSearchTemplateBaseItem.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateBaseItem$ImageInfo.d / 2);
        }
        if ((paramInt2 == paramNetSearchTemplateBaseItem.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateBaseItem$ImageInfo.jdField_c_of_type_Int / 2) && (paramInt2 == paramNetSearchTemplateBaseItem.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateBaseItem$ImageInfo.d / 2))
        {
          j = 1;
          break;
        }
        j = 0;
        break;
        paramInt1 = DisplayUtil.a((Context)localObject, 220.0F);
        i = DisplayUtil.a((Context)localObject, 136.0F);
        j = 0;
        break;
        paramInt1 = DisplayUtil.a((Context)localObject, 162.0F);
        i = DisplayUtil.a((Context)localObject, 162.0F);
        j = 0;
        break;
        paramInt1 = DisplayUtil.a((Context)localObject, 162.0F);
        i = DisplayUtil.a((Context)localObject, 228.0F);
        j = 0;
        break;
        paramInt1 = DisplayUtil.a((Context)localObject, 162.0F);
        i = DisplayUtil.a((Context)localObject, 162.0F);
        j = 1;
        break;
        paramNetSearchTemplateBaseItem.mFailedDrawable = localColorDrawable;
        paramNetSearchTemplateBaseItem.mLoadingDrawable = localColorDrawable;
        paramSquareImageView.setBackgroundColor(0);
      }
      paramInt3 = paramInt1;
      paramInt1 = i;
    }
  }
  
  private void a(TextView paramTextView, String paramString, int paramInt)
  {
    if ((paramTextView == null) || (TextUtils.isEmpty(paramString)) || (paramInt <= 0)) {
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
      }
      for (;;)
      {
        paramTextView.setIncludeFontPadding(false);
        return;
        paramTextView.setTextColor(localContext.getResources().getColor(2131167034));
      }
    }
    if (paramString.equals("B"))
    {
      paramTextView.setTextSize(1, 15.0F);
      if (bool) {
        paramTextView.setTextColor(Color.parseColor("#737373"));
      }
      for (;;)
      {
        paramTextView.setIncludeFontPadding(false);
        return;
        paramTextView.setTextColor(localContext.getResources().getColor(2131167034));
      }
    }
    if (paramString.equals("C"))
    {
      paramTextView.setTextSize(1, 14.0F);
      if (bool) {
        paramTextView.setTextColor(Color.parseColor("#4A4A4A"));
      }
      for (;;)
      {
        paramTextView.setIncludeFontPadding(false);
        return;
        paramTextView.setTextColor(localContext.getResources().getColor(2131167035));
      }
    }
    if (paramString.equals("D"))
    {
      paramTextView.setTextSize(1, 13.0F);
      if (bool) {
        paramTextView.setTextColor(Color.parseColor("#4A4A4A"));
      }
      for (;;)
      {
        paramTextView.setIncludeFontPadding(false);
        return;
        paramTextView.setTextColor(localContext.getResources().getColor(2131167035));
      }
    }
    if (paramString.equals("E"))
    {
      paramTextView.setTextSize(1, 12.0F);
      if (bool) {
        paramTextView.setTextColor(Color.parseColor("#4A4A4A"));
      }
      for (;;)
      {
        paramTextView.setIncludeFontPadding(false);
        return;
        paramTextView.setTextColor(localContext.getResources().getColor(2131167035));
      }
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
      paramTextView.setTextColor(localContext.getResources().getColor(2131167181));
      return;
    }
    paramTextView.setTextSize(1, 17.0F);
    paramTextView.setTextColor(localContext.getResources().getColor(2131167040));
    paramTextView.setIncludeFontPadding(false);
  }
  
  private void a(NetSearchTemplateAvatarsItem paramNetSearchTemplateAvatarsItem, NetSearchTemplateAvatarsView paramNetSearchTemplateAvatarsView)
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject3 = paramNetSearchTemplateAvatarsView.a().getContext();
    label59:
    int i;
    Object localObject2;
    int m;
    int n;
    label322:
    Object localObject4;
    int k;
    int j;
    if (ThemeUtil.isNowThemeIsNight((AppRuntime)localObject1, false, null))
    {
      paramNetSearchTemplateAvatarsView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      if (!TextUtils.isEmpty(paramNetSearchTemplateAvatarsItem.jdField_a_of_type_JavaLangCharSequence)) {
        break label593;
      }
      paramNetSearchTemplateAvatarsView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (paramNetSearchTemplateAvatarsItem.jdField_a_of_type_ComTencentMobileqqSearchModelImageItem == null) {
        break label775;
      }
      paramNetSearchTemplateAvatarsView.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramNetSearchTemplateAvatarsView.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      i = (int)(DeviceInfoUtil.k() - UIUtils.a((Context)localObject3, 30.0F)) / 2 - UIUtils.a((Context)localObject3, 3.0F);
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = i;
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = i;
      localObject2 = URLDrawable.getDrawable(paramNetSearchTemplateAvatarsItem.jdField_a_of_type_ComTencentMobileqqSearchModelImageItem.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject1);
      paramNetSearchTemplateAvatarsView.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      localObject2 = (LinearLayout.LayoutParams)paramNetSearchTemplateAvatarsView.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).height = i;
      ((LinearLayout.LayoutParams)localObject2).width = i;
      paramNetSearchTemplateAvatarsView.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      paramNetSearchTemplateAvatarsView.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      if (paramNetSearchTemplateAvatarsItem.jdField_a_of_type_JavaUtilList == null) {
        return;
      }
      m = Math.min(paramNetSearchTemplateAvatarsItem.jdField_a_of_type_JavaUtilList.size(), 4);
      n = (i - UIUtils.a((Context)localObject3, 3.0F)) / 2;
      localObject2 = new int[4];
      Object tmp295_293 = localObject2;
      tmp295_293[0] = 2131368765;
      Object tmp301_295 = tmp295_293;
      tmp301_295[1] = 2131368766;
      Object tmp307_301 = tmp301_295;
      tmp307_301[2] = 2131368767;
      Object tmp313_307 = tmp307_301;
      tmp313_307[3] = 2131368768;
      tmp313_307;
      i = 0;
      if (i >= m) {
        break label748;
      }
      localObject3 = (SquareImageView)paramNetSearchTemplateAvatarsView.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(localObject2[i]);
      localObject4 = ((ImageItem)paramNetSearchTemplateAvatarsItem.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString;
      ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
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
      if ((i != 3) || (paramNetSearchTemplateAvatarsItem.jdField_a_of_type_Int <= 4)) {
        break label731;
      }
      ((SquareImageView)localObject3).setFilterColor(Color.parseColor("#66000000"));
      k = paramNetSearchTemplateAvatarsItem.jdField_a_of_type_Int - 4;
      localObject4 = new StringBuilder().append("+");
      j = k;
      if (k > 99) {
        j = 99;
      }
      ((SquareImageView)localObject3).setFilterText(j);
      ((SquareImageView)localObject3).setFilterTextSize(DisplayUtil.a(paramNetSearchTemplateAvatarsView.a().getContext(), 20.0F));
    }
    for (;;)
    {
      i += 1;
      break label322;
      paramNetSearchTemplateAvatarsView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#262626"));
      break;
      label593:
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
      break label59;
      label731:
      ((SquareImageView)localObject3).setFilterColor(-1);
      ((SquareImageView)localObject3).setFilterText("");
    }
    label748:
    while (i < 4)
    {
      paramNetSearchTemplateAvatarsView.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(localObject2[i]).setVisibility(4);
      i += 1;
    }
    label775:
    paramNetSearchTemplateAvatarsView.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    paramNetSearchTemplateAvatarsView.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    if (paramNetSearchTemplateAvatarsItem.jdField_a_of_type_JavaUtilList != null)
    {
      m = Math.min(paramNetSearchTemplateAvatarsItem.jdField_a_of_type_JavaUtilList.size(), paramNetSearchTemplateAvatarsView.jdField_a_of_type_Int);
      n = (int)(DeviceInfoUtil.k() - UIUtils.a(paramNetSearchTemplateAvatarsView.a().getContext(), (m - 1) * 2 + 27));
      i = 0;
      if (i < m)
      {
        localObject1 = (SquareImageView)paramNetSearchTemplateAvatarsView.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
        localObject2 = ((ImageItem)paramNetSearchTemplateAvatarsItem.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString;
        localObject4 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject4).mPlayGifImage = true;
        ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = n;
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = n;
        ((URLDrawable.URLDrawableOptions)localObject4).mMemoryCacheKeySuffix = "fourPic";
        localObject2 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject4);
        ((SquareImageView)localObject1).setImageDrawable((Drawable)localObject2);
        if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
          ((URLDrawable)localObject2).restartDownload();
        }
        if (paramNetSearchTemplateAvatarsItem.jdField_b_of_type_Int != 0)
        {
          ((SquareImageView)localObject1).setImageScale(n / 4 * 1.0F / DisplayUtil.a((Context)localObject3, paramNetSearchTemplateAvatarsItem.jdField_b_of_type_Int / 2), 0.0F);
          label1007:
          ((SquareImageView)localObject1).setVisibility(0);
          if ((i != paramNetSearchTemplateAvatarsView.jdField_a_of_type_Int - 1) || (paramNetSearchTemplateAvatarsItem.jdField_a_of_type_Int <= paramNetSearchTemplateAvatarsView.jdField_a_of_type_Int)) {
            break label1136;
          }
          ((SquareImageView)localObject1).setFilterColor(Color.parseColor("#66000000"));
          k = paramNetSearchTemplateAvatarsItem.jdField_a_of_type_Int - paramNetSearchTemplateAvatarsView.jdField_a_of_type_Int;
          localObject2 = new StringBuilder().append("+");
          j = k;
          if (k > 99) {
            j = 99;
          }
          ((SquareImageView)localObject1).setFilterText(j);
          ((SquareImageView)localObject1).setFilterTextSize(DisplayUtil.a(paramNetSearchTemplateAvatarsView.a().getContext(), 20.0F));
        }
        for (;;)
        {
          i += 1;
          break;
          ((SquareImageView)localObject1).setImageScale(1.0F, 0.0F);
          break label1007;
          label1136:
          ((SquareImageView)localObject1).setFilterColor(-1);
          ((SquareImageView)localObject1).setFilterText("");
        }
      }
      while (i < paramNetSearchTemplateAvatarsView.jdField_a_of_type_Int)
      {
        paramNetSearchTemplateAvatarsView.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i).setVisibility(4);
        i += 1;
      }
    }
  }
  
  private void a(NetSearchTemplateBannerTitleItem paramNetSearchTemplateBannerTitleItem, NetSearchTemplateBannerTitleView paramNetSearchTemplateBannerTitleView)
  {
    Object localObject = paramNetSearchTemplateBannerTitleView.a().getContext();
    int i;
    if (!TextUtils.isEmpty(paramNetSearchTemplateBannerTitleItem.i))
    {
      paramNetSearchTemplateBannerTitleView.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      a((Context)localObject, (SquareImageView)paramNetSearchTemplateBannerTitleView.jdField_a_of_type_AndroidWidgetImageView, paramNetSearchTemplateBannerTitleView.jdField_b_of_type_AndroidWidgetImageView, paramNetSearchTemplateBannerTitleView.jdField_b_of_type_AndroidWidgetTextView, paramNetSearchTemplateBannerTitleItem.jdField_a_of_type_Int, paramNetSearchTemplateBannerTitleItem.i, paramNetSearchTemplateBannerTitleItem.jdField_b_of_type_JavaLangString, ((Context)localObject).getResources().getDimensionPixelSize(2131298478));
      i = ((Context)localObject).getResources().getDimensionPixelSize(2131298478);
      if ((paramNetSearchTemplateBannerTitleItem.jdField_a_of_type_Int == 6) || (paramNetSearchTemplateBannerTitleItem.jdField_a_of_type_Int == 8)) {
        i = DisplayUtil.a((Context)localObject, 100.0F);
      }
      if (paramNetSearchTemplateBannerTitleView.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 8) {
        break label317;
      }
      i = 0;
      label127:
      float f = ((Context)localObject).getResources().getDisplayMetrics().widthPixels - DisplayUtil.a((Context)localObject, 30.0F);
      CharSequence localCharSequence = SearchUtils.a(paramNetSearchTemplateBannerTitleView.jdField_a_of_type_AndroidWidgetTextView, f, 2, paramNetSearchTemplateBannerTitleItem.jdField_a_of_type_JavaLangCharSequence.toString(), paramNetSearchTemplateBannerTitleItem.jdField_a_of_type_ComTencentMobileqqSearchUtilHighlightModel.jdField_a_of_type_JavaUtilList, false, true);
      paramNetSearchTemplateBannerTitleView.jdField_a_of_type_AndroidWidgetTextView.setText(localCharSequence);
      f = ((Context)localObject).getResources().getDisplayMetrics().widthPixels - DisplayUtil.a((Context)localObject, 30.0F) - i;
      localObject = SearchUtils.a(paramNetSearchTemplateBannerTitleView.c, f, 2, paramNetSearchTemplateBannerTitleItem.jdField_b_of_type_JavaLangCharSequence.toString(), paramNetSearchTemplateBannerTitleItem.jdField_a_of_type_ComTencentMobileqqSearchUtilHighlightModel.jdField_a_of_type_JavaUtilList, false, false);
      if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        break label333;
      }
      paramNetSearchTemplateBannerTitleView.c.setTextColor(Color.parseColor("#4A4A4A"));
      paramNetSearchTemplateBannerTitleView.jdField_d_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#4A4A4A"));
    }
    for (;;)
    {
      a(paramNetSearchTemplateBannerTitleView.c, (CharSequence)localObject, true);
      a(paramNetSearchTemplateBannerTitleView.jdField_d_of_type_AndroidWidgetTextView, paramNetSearchTemplateBannerTitleItem.jdField_c_of_type_JavaLangCharSequence);
      return;
      paramNetSearchTemplateBannerTitleView.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      break;
      label317:
      i += DisplayUtil.a((Context)localObject, 10.0F);
      break label127;
      label333:
      paramNetSearchTemplateBannerTitleView.c.setTextColor(Color.parseColor("#737373"));
      paramNetSearchTemplateBannerTitleView.jdField_d_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
    }
  }
  
  private void a(NetSearchTemplateBigImageItem paramNetSearchTemplateBigImageItem, NetSearchTemplateBigImageView paramNetSearchTemplateBigImageView)
  {
    Context localContext = paramNetSearchTemplateBigImageView.a().getContext();
    int j;
    int i;
    if (paramNetSearchTemplateBigImageItem.jdField_a_of_type_Int == 1)
    {
      j = DisplayUtil.a(localContext, 375.0F);
      i = DisplayUtil.a(localContext, 150.0F);
    }
    for (;;)
    {
      int k;
      if ((j == 0) || (i == 0))
      {
        i = DisplayUtil.a(localContext, 375.0F);
        j = DisplayUtil.a(localContext, 150.0F);
        k = i;
        i = j;
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramNetSearchTemplateBigImageItem.jdField_b_of_type_JavaLangString))
        {
          localObject = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = k;
          ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i;
          ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
          localObject = URLDrawable.getDrawable(paramNetSearchTemplateBigImageItem.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
          paramNetSearchTemplateBigImageView.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
          if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
            ((URLDrawable)localObject).restartDownload();
          }
          label164:
          paramNetSearchTemplateBigImageView.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
          localObject = (LinearLayout.LayoutParams)paramNetSearchTemplateBigImageView.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).height = ((int)(i * UIUtils.a(localContext) * 1.0F / k));
          paramNetSearchTemplateBigImageView.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
          paramNetSearchTemplateBigImageView.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, 0, 0, 0);
          if (TextUtils.isEmpty(paramNetSearchTemplateBigImageItem.jdField_a_of_type_JavaLangCharSequence)) {
            break label522;
          }
          paramNetSearchTemplateBigImageView.jdField_b_of_type_AndroidWidgetTextView.setText(paramNetSearchTemplateBigImageItem.jdField_a_of_type_JavaLangCharSequence);
          paramNetSearchTemplateBigImageView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          label253:
          if (TextUtils.isEmpty(paramNetSearchTemplateBigImageItem.jdField_b_of_type_JavaLangCharSequence)) {
            break label534;
          }
          paramNetSearchTemplateBigImageView.c.setText(paramNetSearchTemplateBigImageItem.jdField_b_of_type_JavaLangCharSequence);
          paramNetSearchTemplateBigImageView.c.setVisibility(0);
          label282:
          if (TextUtils.isEmpty(paramNetSearchTemplateBigImageItem.j)) {
            break label599;
          }
          paramNetSearchTemplateBigImageView.jdField_d_of_type_AndroidWidgetTextView.setText(paramNetSearchTemplateBigImageItem.j);
        }
        try
        {
          if (!paramNetSearchTemplateBigImageItem.k.startsWith("#")) {
            paramNetSearchTemplateBigImageItem.k = ("#" + paramNetSearchTemplateBigImageItem.k);
          }
          paramNetSearchTemplateBigImageView.jdField_d_of_type_AndroidWidgetTextView.setBackgroundColor(Color.parseColor(paramNetSearchTemplateBigImageItem.k));
        }
        catch (Exception localException)
        {
          for (;;)
          {
            label365:
            paramNetSearchTemplateBigImageView.jdField_d_of_type_AndroidWidgetTextView.setBackgroundColor(Color.parseColor("#FF00FF00"));
            if (QLog.isColorLevel()) {
              QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bigImageItem.topLeftTagColor = " + paramNetSearchTemplateBigImageItem.k);
            }
          }
        }
        paramNetSearchTemplateBigImageView.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        Object localObject = ((ViewGroup)paramNetSearchTemplateBigImageView.a()).getChildAt(((ViewGroup)paramNetSearchTemplateBigImageView.a()).getChildCount() - 1);
        if ((localObject != null) && ((((View)localObject).getLayoutParams() instanceof LinearLayout.LayoutParams)))
        {
          if (paramNetSearchTemplateBigImageItem.b() != 0) {
            break label611;
          }
          ((LinearLayout.LayoutParams)((View)localObject).getLayoutParams()).topMargin = 0;
          paramNetSearchTemplateBigImageView.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, 0, 0, DisplayUtil.a(localContext, 6.0F));
        }
        label522:
        label534:
        label599:
        label611:
        while (paramNetSearchTemplateBigImageItem.b() != 2)
        {
          return;
          if (paramNetSearchTemplateBigImageItem.jdField_a_of_type_Int == 2)
          {
            j = DisplayUtil.a(localContext, 375.0F);
            i = DisplayUtil.a(localContext, 180.0F);
            break;
          }
          if (paramNetSearchTemplateBigImageItem.jdField_a_of_type_Int != 0) {
            break label639;
          }
          j = DisplayUtil.a(localContext, paramNetSearchTemplateBigImageItem.jdField_a_of_type_Float / 2.0F);
          i = DisplayUtil.a(localContext, paramNetSearchTemplateBigImageItem.jdField_b_of_type_Float / 2.0F);
          break;
          paramNetSearchTemplateBigImageView.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          break label164;
          paramNetSearchTemplateBigImageView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          break label253;
          paramNetSearchTemplateBigImageView.c.setVisibility(8);
          break label282;
          paramNetSearchTemplateBigImageView.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
          break label365;
        }
        ((LinearLayout.LayoutParams)localException.getLayoutParams()).bottomMargin = 0;
        return;
        k = j;
      }
      label639:
      i = 0;
      j = 0;
    }
  }
  
  private void a(NetSearchTemplateFriendUpdatesItem paramNetSearchTemplateFriendUpdatesItem, NetSearchTemplateFriendUpdatesView paramNetSearchTemplateFriendUpdatesView)
  {
    Object localObject1 = paramNetSearchTemplateFriendUpdatesView.a().getContext();
    Object localObject2 = paramNetSearchTemplateFriendUpdatesView.a();
    if (paramNetSearchTemplateFriendUpdatesItem.jdField_b_of_type_Boolean) {
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), UIUtils.a(((View)localObject2).getContext(), 6.0F), ((View)localObject2).getPaddingRight(), UIUtils.a(((View)localObject2).getContext(), 6.0F));
    }
    Object localObject3;
    int i;
    Object localObject4;
    for (;;)
    {
      localObject2 = (LinearLayout)((View)localObject2).findViewById(2131373155);
      localObject3 = new ArrayList();
      i = 0;
      while (i < ((LinearLayout)localObject2).getChildCount())
      {
        localObject4 = ((LinearLayout)localObject2).getChildAt(i).findViewById(2131368829);
        if ((localObject4 instanceof SquareImageView)) {
          ((List)localObject3).add((SquareImageView)localObject4);
        }
        i += 1;
      }
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), UIUtils.a(((View)localObject2).getContext(), 3.0F), ((View)localObject2).getPaddingRight(), UIUtils.a(((View)localObject2).getContext(), 3.0F));
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
      a((Context)localObject1, (SquareImageView)paramNetSearchTemplateFriendUpdatesView.b(), paramNetSearchTemplateFriendUpdatesView.jdField_b_of_type_AndroidWidgetImageView, paramNetSearchTemplateFriendUpdatesView.jdField_a_of_type_AndroidWidgetTextView, paramNetSearchTemplateFriendUpdatesItem.jdField_a_of_type_Int, paramNetSearchTemplateFriendUpdatesItem.i, null, DisplayUtil.a((Context)localObject1, 32.0F));
    }
    label687:
    Object localObject5;
    if (!TextUtils.isEmpty(paramNetSearchTemplateFriendUpdatesItem.jdField_a_of_type_JavaLangString))
    {
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = paramNetSearchTemplateFriendUpdatesView.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = paramNetSearchTemplateFriendUpdatesView.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height;
      localObject2 = URLDrawable.getDrawable(paramNetSearchTemplateFriendUpdatesItem.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
      paramNetSearchTemplateFriendUpdatesView.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      paramNetSearchTemplateFriendUpdatesView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      i = ((Context)localObject1).getResources().getDimensionPixelSize(2131298478);
      if ((paramNetSearchTemplateFriendUpdatesItem.jdField_a_of_type_Int == 6) || (paramNetSearchTemplateFriendUpdatesItem.jdField_a_of_type_Int == 8)) {
        i = DisplayUtil.a((Context)localObject1, 100.0F);
      }
      localObject2 = SearchUtils.a(paramNetSearchTemplateFriendUpdatesView.a(), 10.0F * SearchUtils.a(paramNetSearchTemplateFriendUpdatesView.a(), HardCodeUtil.a(2131713619)), 1, paramNetSearchTemplateFriendUpdatesItem.jdField_a_of_type_JavaLangCharSequence.toString(), paramNetSearchTemplateFriendUpdatesItem.jdField_a_of_type_ComTencentMobileqqSearchUtilHighlightModel.jdField_a_of_type_JavaUtilList, false, false, true);
      paramNetSearchTemplateFriendUpdatesView.a().setText((CharSequence)localObject2);
      paramNetSearchTemplateFriendUpdatesView.a().setEllipsize(null);
      float f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - DisplayUtil.a((Context)localObject1, 40.0F) - i;
      localObject2 = SearchUtils.a(paramNetSearchTemplateFriendUpdatesView.b(), f1, 2, paramNetSearchTemplateFriendUpdatesItem.jdField_b_of_type_JavaLangCharSequence.toString(), "", false, false, true);
      a(paramNetSearchTemplateFriendUpdatesView.b(), (CharSequence)localObject2, false);
      if (TextUtils.isEmpty(paramNetSearchTemplateFriendUpdatesItem.jdField_c_of_type_JavaLangCharSequence)) {
        break label1047;
      }
      f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - DisplayUtil.a((Context)localObject1, 30.0F);
      localObject2 = SearchUtils.a(paramNetSearchTemplateFriendUpdatesView.c(), f1, 2, paramNetSearchTemplateFriendUpdatesItem.jdField_c_of_type_JavaLangCharSequence.toString(), paramNetSearchTemplateFriendUpdatesItem.jdField_a_of_type_ComTencentMobileqqSearchUtilHighlightModel.jdField_a_of_type_JavaUtilList, false, false);
      paramNetSearchTemplateFriendUpdatesView.c().setText((CharSequence)localObject2);
      paramNetSearchTemplateFriendUpdatesView.c().setVisibility(0);
      if (paramNetSearchTemplateFriendUpdatesItem.jdField_a_of_type_JavaUtilList == null) {
        break label1479;
      }
      if (paramNetSearchTemplateFriendUpdatesItem.jdField_a_of_type_JavaUtilList.size() != 1) {
        break label1071;
      }
      paramNetSearchTemplateFriendUpdatesView.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      paramNetSearchTemplateFriendUpdatesView.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localObject3 = paramNetSearchTemplateFriendUpdatesView.a().getResources();
      if (jdField_a_of_type_Int == 0) {
        jdField_a_of_type_Int = ((Resources)localObject3).getDisplayMetrics().widthPixels;
      }
      localObject2 = paramNetSearchTemplateFriendUpdatesView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
      ((SquareImageView)localObject2).setImageScale((float)(1.0D / paramNetSearchTemplateFriendUpdatesItem.jdField_a_of_type_Double), 0.0F);
      f1 = ((Resources)localObject3).getDimension(2131298471);
      float f2 = ((Resources)localObject3).getDimension(2131298471);
      i = DisplayUtil.a(paramNetSearchTemplateFriendUpdatesView.a().getContext(), 2.0F);
      j = paramNetSearchTemplateFriendUpdatesView.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      j = (int)(jdField_a_of_type_Int - f1 - f2 - (j - 1) * i) / j;
      i = (int)(j * paramNetSearchTemplateFriendUpdatesItem.jdField_b_of_type_Double);
      j = (int)(j * paramNetSearchTemplateFriendUpdatesItem.jdField_b_of_type_Double);
      ((SquareImageView)localObject2).setLayoutParams(new FrameLayout.LayoutParams(i, j));
      localObject3 = (ImageItem)paramNetSearchTemplateFriendUpdatesItem.jdField_a_of_type_JavaUtilList.get(0);
      localObject4 = ((ImageItem)localObject3).jdField_a_of_type_JavaLangString;
      localObject5 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject5).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject5).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject5).mRequestWidth = i;
      ((URLDrawable.URLDrawableOptions)localObject5).mRequestHeight = j;
      ((URLDrawable.URLDrawableOptions)localObject5).mPlayGifImage = true;
      localObject4 = URLDrawable.getDrawable((String)localObject4, (URLDrawable.URLDrawableOptions)localObject5);
      ((SquareImageView)localObject2).setImageDrawable((Drawable)localObject4);
      if ((((URLDrawable)localObject4).getStatus() != 1) && (((URLDrawable)localObject4).getStatus() != 0)) {
        ((URLDrawable)localObject4).restartDownload();
      }
      if (((ImageItem)localObject3).jdField_a_of_type_Int != 2) {
        break label1059;
      }
      paramNetSearchTemplateFriendUpdatesView.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      if ((paramNetSearchTemplateFriendUpdatesItem.jdField_c_of_type_JavaUtilList != null) || (!TextUtils.equals(paramNetSearchTemplateFriendUpdatesItem.k, "0")) || (!TextUtils.equals(paramNetSearchTemplateFriendUpdatesItem.m, "0"))) {
        break label1500;
      }
      paramNetSearchTemplateFriendUpdatesView.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
      paramNetSearchTemplateFriendUpdatesView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      label1047:
      paramNetSearchTemplateFriendUpdatesView.c().setVisibility(8);
      break label687;
      label1059:
      paramNetSearchTemplateFriendUpdatesView.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      continue;
      label1071:
      paramNetSearchTemplateFriendUpdatesView.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      paramNetSearchTemplateFriendUpdatesView.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      int m = paramNetSearchTemplateFriendUpdatesView.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      i = 0;
      j = i;
      if (i < paramNetSearchTemplateFriendUpdatesItem.jdField_a_of_type_JavaUtilList.size())
      {
        j = i;
        if (i < m)
        {
          localObject3 = paramNetSearchTemplateFriendUpdatesView.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
          ((View)localObject3).setVisibility(0);
          localObject2 = (SquareImageView)((View)localObject3).findViewById(2131368829);
          localObject3 = (ImageView)((View)localObject3).findViewById(2131370047);
          ((SquareImageView)localObject2).setImageScale((float)(1.0D / paramNetSearchTemplateFriendUpdatesItem.jdField_a_of_type_Double), 0.0F);
          localObject4 = (ImageItem)paramNetSearchTemplateFriendUpdatesItem.jdField_a_of_type_JavaUtilList.get(i);
          localObject5 = ((ImageItem)localObject4).jdField_a_of_type_JavaLangString;
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mRequestHeight = 200;
          localURLDrawableOptions.mRequestWidth = 200;
          localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          localURLDrawableOptions.mPlayGifImage = true;
          localObject5 = URLDrawable.getDrawable((String)localObject5, localURLDrawableOptions);
          ((SquareImageView)localObject2).setImageDrawable((Drawable)localObject5);
          if ((((URLDrawable)localObject5).getStatus() != 1) && (((URLDrawable)localObject5).getStatus() != 0)) {
            ((URLDrawable)localObject5).restartDownload();
          }
          ((SquareImageView)localObject2).setVisibility(0);
          if (((ImageItem)localObject4).jdField_a_of_type_Int == 2)
          {
            ((ImageView)localObject3).setVisibility(0);
            label1312:
            if ((i != m - 1) || (paramNetSearchTemplateFriendUpdatesItem.jdField_b_of_type_Int <= m)) {
              break label1433;
            }
            ((ImageView)localObject3).setVisibility(8);
            ((SquareImageView)localObject2).setFilterColor(Color.parseColor("#66000000"));
            int k = paramNetSearchTemplateFriendUpdatesItem.jdField_b_of_type_Int - m;
            j = k;
            if (k > 99) {
              j = 99;
            }
            ((SquareImageView)localObject2).setFilterText("+" + j);
            ((SquareImageView)localObject2).setFilterTextSize(DisplayUtil.a(((SquareImageView)localObject2).getContext(), 20.0F));
          }
          for (;;)
          {
            i += 1;
            break;
            ((ImageView)localObject3).setVisibility(8);
            break label1312;
            label1433:
            ((SquareImageView)localObject2).setFilterColor(-1);
            ((SquareImageView)localObject2).setFilterText("");
          }
        }
      }
      while (j < m)
      {
        paramNetSearchTemplateFriendUpdatesView.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j).setVisibility(4);
        j += 1;
      }
      continue;
      label1479:
      paramNetSearchTemplateFriendUpdatesView.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      paramNetSearchTemplateFriendUpdatesView.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    label1500:
    if (paramNetSearchTemplateFriendUpdatesItem.jdField_c_of_type_JavaUtilList != null)
    {
      paramNetSearchTemplateFriendUpdatesView.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      i = paramNetSearchTemplateFriendUpdatesItem.jdField_c_of_type_JavaUtilList.size() - 1;
      if (i < 0) {
        break label1758;
      }
      if (i <= 0) {
        break label2130;
      }
    }
    label1929:
    label2084:
    label2096:
    label2108:
    label2120:
    label2130:
    for (int j = DisplayUtil.a((Context)localObject1, 11.0F) * i;; j = 0)
    {
      localObject2 = (SquareImageView)LayoutInflater.from((Context)localObject1).inflate(2131559942, null, false);
      localObject3 = new RelativeLayout.LayoutParams(DisplayUtil.a((Context)localObject1, 16.0F), DisplayUtil.a((Context)localObject1, 16.0F));
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = j;
      paramNetSearchTemplateFriendUpdatesView.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject2, paramNetSearchTemplateFriendUpdatesItem.jdField_c_of_type_JavaUtilList.size() - 1 - i, (ViewGroup.LayoutParams)localObject3);
      localObject3 = (String)paramNetSearchTemplateFriendUpdatesItem.jdField_c_of_type_JavaUtilList.get(i);
      localObject4 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
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
      break;
      paramNetSearchTemplateFriendUpdatesView.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      label1758:
      if (!TextUtils.isEmpty(paramNetSearchTemplateFriendUpdatesItem.jdField_b_of_type_JavaLangString))
      {
        paramNetSearchTemplateFriendUpdatesView.jdField_b_of_type_AndroidWidgetTextView.setText(paramNetSearchTemplateFriendUpdatesItem.jdField_b_of_type_JavaLangString);
        paramNetSearchTemplateFriendUpdatesView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if (TextUtils.isEmpty(paramNetSearchTemplateFriendUpdatesItem.j)) {
          break label2084;
        }
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = paramNetSearchTemplateFriendUpdatesView.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().width;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = paramNetSearchTemplateFriendUpdatesView.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().height;
        localObject1 = URLDrawable.getDrawable(paramNetSearchTemplateFriendUpdatesItem.j, (URLDrawable.URLDrawableOptions)localObject1);
        paramNetSearchTemplateFriendUpdatesView.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
        if ((((URLDrawable)localObject1).getStatus() != 1) && (((URLDrawable)localObject1).getStatus() != 0)) {
          ((URLDrawable)localObject1).restartDownload();
        }
        paramNetSearchTemplateFriendUpdatesView.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        label1900:
        if (TextUtils.isEmpty(paramNetSearchTemplateFriendUpdatesItem.k)) {
          break label2096;
        }
        paramNetSearchTemplateFriendUpdatesView.c.setText(paramNetSearchTemplateFriendUpdatesItem.k);
        paramNetSearchTemplateFriendUpdatesView.c.setVisibility(0);
        if (TextUtils.isEmpty(paramNetSearchTemplateFriendUpdatesItem.l)) {
          break label2108;
        }
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = paramNetSearchTemplateFriendUpdatesView.jdField_b_of_type_ComTencentImageURLImageView.getLayoutParams().width;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = paramNetSearchTemplateFriendUpdatesView.jdField_b_of_type_ComTencentImageURLImageView.getLayoutParams().height;
        localObject1 = URLDrawable.getDrawable(paramNetSearchTemplateFriendUpdatesItem.l, (URLDrawable.URLDrawableOptions)localObject1);
        paramNetSearchTemplateFriendUpdatesView.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
        if ((((URLDrawable)localObject1).getStatus() != 1) && (((URLDrawable)localObject1).getStatus() != 0)) {
          ((URLDrawable)localObject1).restartDownload();
        }
        paramNetSearchTemplateFriendUpdatesView.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(0);
      }
      for (;;)
      {
        if (TextUtils.isEmpty(paramNetSearchTemplateFriendUpdatesItem.m)) {
          break label2120;
        }
        paramNetSearchTemplateFriendUpdatesView.jdField_d_of_type_AndroidWidgetTextView.setText(paramNetSearchTemplateFriendUpdatesItem.m);
        paramNetSearchTemplateFriendUpdatesView.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
        paramNetSearchTemplateFriendUpdatesView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        break;
        paramNetSearchTemplateFriendUpdatesView.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        break label1900;
        paramNetSearchTemplateFriendUpdatesView.c.setVisibility(8);
        break label1929;
        paramNetSearchTemplateFriendUpdatesView.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
      paramNetSearchTemplateFriendUpdatesView.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
  }
  
  private void a(NetSearchTemplateNetSeaEntranceItem paramNetSearchTemplateNetSeaEntranceItem, NetSearchTemplateNetSeaEntranceView paramNetSearchTemplateNetSeaEntranceView)
  {
    Object localObject = paramNetSearchTemplateNetSeaEntranceView.a();
    Context localContext = ((View)localObject).getContext();
    if (((localObject instanceof LinearLayout)) && (((LinearLayout)localObject).getChildCount() == 1))
    {
      localObject = ((LinearLayout)localObject).getChildAt(0);
      ((View)localObject).setPadding(((View)localObject).getPaddingLeft(), 0, ((View)localObject).getPaddingRight(), 0);
    }
    if (!TextUtils.isEmpty(paramNetSearchTemplateNetSeaEntranceItem.jdField_b_of_type_JavaLangString))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = DisplayUtil.a(localContext, 50.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = DisplayUtil.a(localContext, 50.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "leftIcon";
      localObject = URLDrawable.getDrawable(paramNetSearchTemplateNetSeaEntranceItem.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      paramNetSearchTemplateNetSeaEntranceView.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      paramNetSearchTemplateNetSeaEntranceView.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      if (TextUtils.isEmpty(paramNetSearchTemplateNetSeaEntranceItem.j)) {
        break label504;
      }
      paramNetSearchTemplateNetSeaEntranceView.jdField_a_of_type_AndroidWidgetTextView.setText(paramNetSearchTemplateNetSeaEntranceItem.j);
      paramNetSearchTemplateNetSeaEntranceView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      label204:
      if (TextUtils.isEmpty(paramNetSearchTemplateNetSeaEntranceItem.g)) {
        break label516;
      }
      paramNetSearchTemplateNetSeaEntranceView.jdField_b_of_type_AndroidWidgetTextView.setText(paramNetSearchTemplateNetSeaEntranceItem.g);
      paramNetSearchTemplateNetSeaEntranceView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      label233:
      if (TextUtils.isEmpty(paramNetSearchTemplateNetSeaEntranceItem.k)) {
        break label528;
      }
      paramNetSearchTemplateNetSeaEntranceView.c.setVisibility(0);
      paramNetSearchTemplateNetSeaEntranceView.c.setText(paramNetSearchTemplateNetSeaEntranceItem.k);
      label262:
      if (TextUtils.isEmpty(paramNetSearchTemplateNetSeaEntranceItem.l)) {
        break label540;
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = DisplayUtil.a(localContext, 30.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = DisplayUtil.a(localContext, 30.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "rightIcon";
      localObject = URLDrawable.getDrawable(paramNetSearchTemplateNetSeaEntranceItem.l, (URLDrawable.URLDrawableOptions)localObject);
      paramNetSearchTemplateNetSeaEntranceView.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      paramNetSearchTemplateNetSeaEntranceView.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(0);
      label377:
      paramNetSearchTemplateNetSeaEntranceView.a(paramNetSearchTemplateNetSeaEntranceItem);
      if (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
        break label552;
      }
      paramNetSearchTemplateNetSeaEntranceView.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839529);
      paramNetSearchTemplateNetSeaEntranceView.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839529);
      paramNetSearchTemplateNetSeaEntranceView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      paramNetSearchTemplateNetSeaEntranceView.c.setTextColor(Color.parseColor("#4A4A4A"));
    }
    for (;;)
    {
      if (paramNetSearchTemplateNetSeaEntranceView.jdField_b_of_type_AndroidWidgetTextView != null) {
        paramNetSearchTemplateNetSeaEntranceView.jdField_b_of_type_AndroidWidgetTextView.setTextColor(SearchUtils.b());
      }
      paramNetSearchTemplateNetSeaEntranceView.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new SearchTemplatePresenter.4(this, paramNetSearchTemplateNetSeaEntranceItem, localContext));
      paramNetSearchTemplateNetSeaEntranceView.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(new SearchTemplatePresenter.5(this, paramNetSearchTemplateNetSeaEntranceItem, localContext));
      return;
      paramNetSearchTemplateNetSeaEntranceView.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break;
      label504:
      paramNetSearchTemplateNetSeaEntranceView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label204;
      label516:
      paramNetSearchTemplateNetSeaEntranceView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label233;
      label528:
      paramNetSearchTemplateNetSeaEntranceView.c.setVisibility(8);
      break label262;
      label540:
      paramNetSearchTemplateNetSeaEntranceView.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
      break label377;
      label552:
      paramNetSearchTemplateNetSeaEntranceView.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839528);
      paramNetSearchTemplateNetSeaEntranceView.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839528);
      paramNetSearchTemplateNetSeaEntranceView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#262626"));
      paramNetSearchTemplateNetSeaEntranceView.c.setTextColor(Color.parseColor("#737373"));
    }
  }
  
  private void a(NetSearchTemplateNewEntranceItem paramNetSearchTemplateNewEntranceItem, NetSearchTemplateNewEntranceView paramNetSearchTemplateNewEntranceView)
  {
    Object localObject = paramNetSearchTemplateNewEntranceView.a();
    Context localContext = ((View)localObject).getContext();
    if (((localObject instanceof LinearLayout)) && (((LinearLayout)localObject).getChildCount() == 1))
    {
      localObject = ((LinearLayout)localObject).getChildAt(0);
      ((View)localObject).setPadding(((View)localObject).getPaddingLeft(), 0, ((View)localObject).getPaddingRight(), 0);
    }
    if (!TextUtils.isEmpty(paramNetSearchTemplateNewEntranceItem.jdField_b_of_type_JavaLangString))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = DisplayUtil.a(localContext, 40.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = DisplayUtil.a(localContext, 40.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "leftIcon";
      localObject = URLDrawable.getDrawable(paramNetSearchTemplateNewEntranceItem.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      paramNetSearchTemplateNewEntranceView.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      paramNetSearchTemplateNewEntranceView.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      if (TextUtils.isEmpty(paramNetSearchTemplateNewEntranceItem.j)) {
        break label363;
      }
      paramNetSearchTemplateNewEntranceView.jdField_a_of_type_AndroidWidgetTextView.setText(paramNetSearchTemplateNewEntranceItem.j);
      paramNetSearchTemplateNewEntranceView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      label204:
      if (TextUtils.isEmpty(paramNetSearchTemplateNewEntranceItem.g)) {
        break label375;
      }
      paramNetSearchTemplateNewEntranceView.c.setText(paramNetSearchTemplateNewEntranceItem.g);
      paramNetSearchTemplateNewEntranceView.c.setVisibility(0);
      label233:
      if (TextUtils.isEmpty(paramNetSearchTemplateNewEntranceItem.k)) {
        break label387;
      }
      paramNetSearchTemplateNewEntranceView.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      paramNetSearchTemplateNewEntranceView.jdField_d_of_type_AndroidWidgetTextView.setText(paramNetSearchTemplateNewEntranceItem.k);
      label262:
      if (!paramNetSearchTemplateNewEntranceItem.jdField_b_of_type_Boolean) {
        break label399;
      }
      paramNetSearchTemplateNewEntranceView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      UniteSearchReportController.a(null, 0, paramNetSearchTemplateNewEntranceItem.jdField_c_of_type_Int, "0X8009D5C", 0, 0, null, null);
      if ((paramNetSearchTemplateNewEntranceItem.jdField_a_of_type_JavaUtilList != null) && (paramNetSearchTemplateNewEntranceItem.jdField_a_of_type_JavaUtilList.size() > 0)) {
        UniteSearchReportController.a(null, 0, paramNetSearchTemplateNewEntranceItem.jdField_c_of_type_Int, "0X8009D5E", 0, 0, null, null);
      }
      paramNetSearchTemplateNewEntranceView.a(paramNetSearchTemplateNewEntranceItem);
      paramNetSearchTemplateNewEntranceView.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new SearchTemplatePresenter.3(this, paramNetSearchTemplateNewEntranceItem, localContext));
      return;
      paramNetSearchTemplateNewEntranceView.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break;
      label363:
      paramNetSearchTemplateNewEntranceView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label204;
      label375:
      paramNetSearchTemplateNewEntranceView.c.setVisibility(8);
      break label233;
      label387:
      paramNetSearchTemplateNewEntranceView.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      break label262;
      label399:
      paramNetSearchTemplateNewEntranceView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  private void a(NetSearchTemplateSubItem paramNetSearchTemplateSubItem, NetSearchTemplateSubItemView paramNetSearchTemplateSubItemView)
  {
    if ((paramNetSearchTemplateSubItem == null) || (paramNetSearchTemplateSubItemView == null)) {
      return;
    }
    paramNetSearchTemplateSubItemView.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(paramNetSearchTemplateSubItemView.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingLeft(), 0, paramNetSearchTemplateSubItemView.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingRight(), 0);
    Object localObject = (RelativeLayout.LayoutParams)paramNetSearchTemplateSubItemView.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    if (paramNetSearchTemplateSubItem.jdField_b_of_type_Boolean)
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(5, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      localObject = paramNetSearchTemplateSubItemView.jdField_a_of_type_AndroidWidgetTextView.getContext();
      int i = ((Context)localObject).getResources().getDisplayMetrics().widthPixels - DisplayUtil.a((Context)localObject, 38.0F);
      if (TextUtils.isEmpty(paramNetSearchTemplateSubItem.jdField_b_of_type_JavaLangCharSequence)) {
        break label310;
      }
      paramNetSearchTemplateSubItemView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (!bool) {
        break label296;
      }
      paramNetSearchTemplateSubItemView.jdField_b_of_type_AndroidWidgetTextView.setText(paramNetSearchTemplateSubItem.jdField_b_of_type_JavaLangCharSequence.toString());
      label148:
      float f1 = i;
      float f2 = SearchUtils.a(paramNetSearchTemplateSubItemView.jdField_b_of_type_AndroidWidgetTextView, paramNetSearchTemplateSubItem.jdField_b_of_type_JavaLangCharSequence);
      i = (int)(f1 - (DisplayUtil.a((Context)localObject, 10.0F) + f2));
      label182:
      if (TextUtils.isEmpty(paramNetSearchTemplateSubItem.jdField_a_of_type_JavaLangCharSequence)) {
        break label334;
      }
      paramNetSearchTemplateSubItemView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject = paramNetSearchTemplateSubItem.jdField_a_of_type_JavaLangCharSequence;
      if (paramNetSearchTemplateSubItem.jdField_b_of_type_Boolean) {
        break label346;
      }
      localObject = SearchUtils.a(paramNetSearchTemplateSubItemView.jdField_a_of_type_AndroidWidgetTextView, i, (CharSequence)localObject);
    }
    label296:
    label310:
    label334:
    label346:
    for (;;)
    {
      if (bool) {
        paramNetSearchTemplateSubItemView.jdField_a_of_type_AndroidWidgetTextView.setText(((CharSequence)localObject).toString());
      }
      for (;;)
      {
        paramNetSearchTemplateSubItemView.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(a(paramNetSearchTemplateSubItem.jdField_a_of_type_JavaLangString));
        paramNetSearchTemplateSubItemView.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new SearchTemplatePresenter.6(this, paramNetSearchTemplateSubItem, paramNetSearchTemplateSubItemView));
        return;
        ((RelativeLayout.LayoutParams)localObject).addRule(14, 0);
        ((RelativeLayout.LayoutParams)localObject).addRule(5);
        break;
        paramNetSearchTemplateSubItemView.jdField_b_of_type_AndroidWidgetTextView.setText(paramNetSearchTemplateSubItem.jdField_b_of_type_JavaLangCharSequence);
        break label148;
        paramNetSearchTemplateSubItemView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        break label182;
        paramNetSearchTemplateSubItemView.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        continue;
        paramNetSearchTemplateSubItemView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
  }
  
  private void a(NetSearchTemplateSubItemTitle paramNetSearchTemplateSubItemTitle, NetSearchTemplateSubItemTitleView paramNetSearchTemplateSubItemTitleView)
  {
    if ((paramNetSearchTemplateSubItemTitle == null) || (paramNetSearchTemplateSubItemTitleView == null)) {}
    while ((TextUtils.isEmpty(paramNetSearchTemplateSubItemTitle.jdField_a_of_type_JavaLangString)) || (paramNetSearchTemplateSubItemTitleView.jdField_a_of_type_AndroidWidgetTextView == null)) {
      return;
    }
    Context localContext = paramNetSearchTemplateSubItemTitleView.jdField_a_of_type_AndroidWidgetTextView.getContext();
    int j = localContext.getResources().getDisplayMetrics().widthPixels - DisplayUtil.a(localContext, 40.0F);
    int i;
    if ((!TextUtils.isEmpty(paramNetSearchTemplateSubItemTitle.e)) && (paramNetSearchTemplateSubItemTitleView.jdField_a_of_type_AndroidWidgetLinearLayout != null))
    {
      paramNetSearchTemplateSubItemTitleView.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      i = j - DisplayUtil.a(localContext, 26.0F);
    }
    for (;;)
    {
      paramNetSearchTemplateSubItemTitle = SearchUtils.a(paramNetSearchTemplateSubItemTitleView.jdField_a_of_type_AndroidWidgetTextView, i, paramNetSearchTemplateSubItemTitle.jdField_a_of_type_JavaLangString);
      paramNetSearchTemplateSubItemTitleView.jdField_a_of_type_AndroidWidgetTextView.setText(paramNetSearchTemplateSubItemTitle);
      return;
      i = j;
      if (paramNetSearchTemplateSubItemTitleView.jdField_a_of_type_AndroidWidgetLinearLayout != null)
      {
        paramNetSearchTemplateSubItemTitleView.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        i = j;
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
    for (;;)
    {
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
      return;
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
      localLayoutParams.addRule(10);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, 0);
      localLayoutParams.addRule(15, 0);
    }
  }
  
  private void a(NetSearchTemplateUpdatesItem paramNetSearchTemplateUpdatesItem, NetSearchTemplateUpdatesView paramNetSearchTemplateUpdatesView)
  {
    Object localObject1 = paramNetSearchTemplateUpdatesView.a().getContext();
    Object localObject2 = paramNetSearchTemplateUpdatesView.a();
    if (paramNetSearchTemplateUpdatesItem.jdField_b_of_type_Boolean) {
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), UIUtils.a(((View)localObject2).getContext(), 9.0F), ((View)localObject2).getPaddingRight(), UIUtils.a(((View)localObject2).getContext(), 9.0F));
    }
    Object localObject3;
    int i;
    Object localObject4;
    for (;;)
    {
      localObject2 = (LinearLayout)((View)localObject2).findViewById(2131373155);
      localObject3 = new ArrayList();
      i = 0;
      while (i < ((LinearLayout)localObject2).getChildCount())
      {
        localObject4 = ((LinearLayout)localObject2).getChildAt(i).findViewById(2131368829);
        if ((localObject4 instanceof SquareImageView)) {
          ((List)localObject3).add((SquareImageView)localObject4);
        }
        i += 1;
      }
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), UIUtils.a(((View)localObject2).getContext(), 6.0F), ((View)localObject2).getPaddingRight(), UIUtils.a(((View)localObject2).getContext(), 6.0F));
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
    label496:
    int j;
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      paramNetSearchTemplateUpdatesView.a().setTextColor(Color.parseColor("#6991B8"));
      paramNetSearchTemplateUpdatesView.c().setTextColor(Color.parseColor("#44608A"));
      paramNetSearchTemplateUpdatesView.b().setTextColor(Color.parseColor("#44608A"));
      if (!TextUtils.isEmpty(paramNetSearchTemplateUpdatesItem.i)) {
        a((Context)localObject1, (SquareImageView)paramNetSearchTemplateUpdatesView.b(), paramNetSearchTemplateUpdatesView.jdField_b_of_type_AndroidWidgetImageView, paramNetSearchTemplateUpdatesView.jdField_a_of_type_AndroidWidgetTextView, paramNetSearchTemplateUpdatesItem.jdField_a_of_type_Int, paramNetSearchTemplateUpdatesItem.i, null, DisplayUtil.a((Context)localObject1, 21.0F));
      }
      if (TextUtils.isEmpty(paramNetSearchTemplateUpdatesItem.jdField_a_of_type_JavaLangString)) {
        break label1085;
      }
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = paramNetSearchTemplateUpdatesView.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = paramNetSearchTemplateUpdatesView.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height;
      localObject2 = URLDrawable.getDrawable(paramNetSearchTemplateUpdatesItem.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
      paramNetSearchTemplateUpdatesView.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      paramNetSearchTemplateUpdatesView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      i = ((Context)localObject1).getResources().getDimensionPixelSize(2131298478);
      if ((paramNetSearchTemplateUpdatesItem.jdField_a_of_type_Int == 6) || (paramNetSearchTemplateUpdatesItem.jdField_a_of_type_Int == 8)) {
        i = DisplayUtil.a((Context)localObject1, 100.0F);
      }
      localObject2 = SearchUtils.a(paramNetSearchTemplateUpdatesView.a(), 10.0F * SearchUtils.a(paramNetSearchTemplateUpdatesView.a(), HardCodeUtil.a(2131713618)), 1, paramNetSearchTemplateUpdatesItem.jdField_a_of_type_JavaLangCharSequence.toString(), paramNetSearchTemplateUpdatesItem.jdField_a_of_type_ComTencentMobileqqSearchUtilHighlightModel.jdField_a_of_type_JavaUtilList, false, false, true);
      paramNetSearchTemplateUpdatesView.a().setText((CharSequence)localObject2);
      paramNetSearchTemplateUpdatesView.a().setEllipsize(null);
      float f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - DisplayUtil.a((Context)localObject1, 40.0F) - i;
      localObject2 = SearchUtils.a(paramNetSearchTemplateUpdatesView.b(), f1, 2, paramNetSearchTemplateUpdatesItem.jdField_b_of_type_JavaLangCharSequence.toString(), "", false, false, true);
      a(paramNetSearchTemplateUpdatesView.b(), (CharSequence)localObject2, false);
      if (TextUtils.isEmpty(paramNetSearchTemplateUpdatesItem.jdField_c_of_type_JavaLangCharSequence)) {
        break label1097;
      }
      f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - DisplayUtil.a((Context)localObject1, 30.0F);
      localObject2 = SearchUtils.a(paramNetSearchTemplateUpdatesView.c(), f1, 2, paramNetSearchTemplateUpdatesItem.jdField_c_of_type_JavaLangCharSequence.toString(), paramNetSearchTemplateUpdatesItem.jdField_a_of_type_ComTencentMobileqqSearchUtilHighlightModel.jdField_a_of_type_JavaUtilList, false, false);
      paramNetSearchTemplateUpdatesView.c().setText((CharSequence)localObject2);
      paramNetSearchTemplateUpdatesView.c().setVisibility(0);
      label740:
      if (paramNetSearchTemplateUpdatesItem.jdField_a_of_type_JavaUtilList == null) {
        break label1546;
      }
      if (paramNetSearchTemplateUpdatesItem.jdField_a_of_type_JavaUtilList.size() != 1) {
        break label1119;
      }
      paramNetSearchTemplateUpdatesView.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      paramNetSearchTemplateUpdatesView.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localObject2 = paramNetSearchTemplateUpdatesView.a().getResources();
      if (jdField_a_of_type_Int == 0) {
        jdField_a_of_type_Int = ((Resources)localObject2).getDisplayMetrics().widthPixels;
      }
      localObject1 = paramNetSearchTemplateUpdatesView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
      ((SquareImageView)localObject1).setImageScale((float)(1.0D / paramNetSearchTemplateUpdatesItem.jdField_a_of_type_Double), 0.0F);
      f1 = ((Resources)localObject2).getDimension(2131298471);
      float f2 = ((Resources)localObject2).getDimension(2131298471);
      i = DisplayUtil.a(paramNetSearchTemplateUpdatesView.a().getContext(), 2.0F);
      j = paramNetSearchTemplateUpdatesView.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      j = (int)(jdField_a_of_type_Int - f1 - f2 - (j - 1) * i) / j;
      i = (int)(j * paramNetSearchTemplateUpdatesItem.jdField_b_of_type_Double);
      j = (int)(j * paramNetSearchTemplateUpdatesItem.jdField_b_of_type_Double);
      ((SquareImageView)localObject1).setLayoutParams(new FrameLayout.LayoutParams(i, j));
      paramNetSearchTemplateUpdatesItem = (ImageItem)paramNetSearchTemplateUpdatesItem.jdField_a_of_type_JavaUtilList.get(0);
      localObject2 = paramNetSearchTemplateUpdatesItem.jdField_a_of_type_JavaLangString;
      localObject3 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = i;
      ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = j;
      ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = true;
      localObject2 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject3);
      ((SquareImageView)localObject1).setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      if (paramNetSearchTemplateUpdatesItem.jdField_a_of_type_Int != 2) {
        break label1109;
      }
      paramNetSearchTemplateUpdatesView.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      return;
      paramNetSearchTemplateUpdatesView.a().setTextColor(Color.parseColor("#262626"));
      paramNetSearchTemplateUpdatesView.c().setTextColor(Color.parseColor("#737373"));
      paramNetSearchTemplateUpdatesView.b().setTextColor(Color.parseColor("#737373"));
      break;
      label1085:
      paramNetSearchTemplateUpdatesView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label496;
      label1097:
      paramNetSearchTemplateUpdatesView.c().setVisibility(8);
      break label740;
      label1109:
      paramNetSearchTemplateUpdatesView.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
      label1119:
      paramNetSearchTemplateUpdatesView.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      paramNetSearchTemplateUpdatesView.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      int m = paramNetSearchTemplateUpdatesView.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      i = 0;
      j = i;
      if (i < paramNetSearchTemplateUpdatesItem.jdField_a_of_type_JavaUtilList.size())
      {
        j = i;
        if (i < m)
        {
          localObject3 = paramNetSearchTemplateUpdatesView.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
          ((View)localObject3).setVisibility(0);
          localObject2 = (SquareImageView)((View)localObject3).findViewById(2131368829);
          localObject3 = (ImageView)((View)localObject3).findViewById(2131370047);
          j = UIUtils.a((Context)localObject1) / m;
          int k = (int)(j * paramNetSearchTemplateUpdatesItem.jdField_a_of_type_Double);
          ((SquareImageView)localObject2).setImageScale((float)(1.0D / paramNetSearchTemplateUpdatesItem.jdField_a_of_type_Double), 0.0F);
          localObject4 = (ImageItem)paramNetSearchTemplateUpdatesItem.jdField_a_of_type_JavaUtilList.get(i);
          Object localObject5 = ((ImageItem)localObject4).jdField_a_of_type_JavaLangString;
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          localURLDrawableOptions.mRequestWidth = j;
          localURLDrawableOptions.mRequestHeight = k;
          localURLDrawableOptions.mPlayGifImage = true;
          localObject5 = URLDrawable.getDrawable((String)localObject5, localURLDrawableOptions);
          ((SquareImageView)localObject2).setImageDrawable((Drawable)localObject5);
          if ((((URLDrawable)localObject5).getStatus() != 1) && (((URLDrawable)localObject5).getStatus() != 0)) {
            ((URLDrawable)localObject5).restartDownload();
          }
          ((SquareImageView)localObject2).setVisibility(0);
          if (((ImageItem)localObject4).jdField_a_of_type_Int == 2)
          {
            ((ImageView)localObject3).setVisibility(0);
            label1379:
            if ((i != m - 1) || (paramNetSearchTemplateUpdatesItem.jdField_b_of_type_Int <= m)) {
              break label1500;
            }
            ((ImageView)localObject3).setVisibility(8);
            ((SquareImageView)localObject2).setFilterColor(Color.parseColor("#66000000"));
            k = paramNetSearchTemplateUpdatesItem.jdField_b_of_type_Int - m;
            j = k;
            if (k > 99) {
              j = 99;
            }
            ((SquareImageView)localObject2).setFilterText("+" + j);
            ((SquareImageView)localObject2).setFilterTextSize(DisplayUtil.a(((SquareImageView)localObject2).getContext(), 20.0F));
          }
          for (;;)
          {
            i += 1;
            break;
            ((ImageView)localObject3).setVisibility(8);
            break label1379;
            label1500:
            ((SquareImageView)localObject2).setFilterColor(-1);
            ((SquareImageView)localObject2).setFilterText("");
          }
        }
      }
      while (j < m)
      {
        paramNetSearchTemplateUpdatesView.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j).setVisibility(4);
        j += 1;
      }
    }
    label1546:
    paramNetSearchTemplateUpdatesView.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    paramNetSearchTemplateUpdatesView.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void a(SquareImageView paramSquareImageView, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramSquareImageView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    paramSquareImageView.getLayoutParams().width = DisplayUtil.a(paramSquareImageView.getContext(), paramInt1);
    paramSquareImageView.getLayoutParams().height = DisplayUtil.a(paramSquareImageView.getContext(), paramInt2);
    paramSquareImageView.setImageScale(paramInt1 / paramInt2, 0.0F);
    localURLDrawableOptions.mRequestWidth = paramSquareImageView.getLayoutParams().width;
    localURLDrawableOptions.mRequestHeight = paramSquareImageView.getLayoutParams().height;
    paramSquareImageView.setImageDrawable(URLDrawable.getDrawable(paramString, localURLDrawableOptions));
  }
  
  private void a(SquareImageView paramSquareImageView, String paramString)
  {
    if ((paramSquareImageView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localURLDrawableOptions.mRequestWidth = paramSquareImageView.getLayoutParams().width;
    localURLDrawableOptions.mRequestHeight = paramSquareImageView.getLayoutParams().height;
    paramSquareImageView.setImageDrawable(URLDrawable.getDrawable(paramString, localURLDrawableOptions));
  }
  
  private void b(NetSearchTemplateUniversalItem paramNetSearchTemplateUniversalItem, NetSearchTemplateUniversalView paramNetSearchTemplateUniversalView)
  {
    if ((paramNetSearchTemplateUniversalItem == null) || (paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem$ActionInfo == null) || (paramNetSearchTemplateUniversalView == null)) {
      if ((paramNetSearchTemplateUniversalView != null) && (paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetButton != null)) {
        paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      }
    }
    while (paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetButton == null) {
      return;
    }
    Context localContext = paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetButton.getContext();
    if ((paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem$ActionInfo.jdField_a_of_type_Int == 1) && (!TextUtils.isEmpty(paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem$ActionInfo.jdField_a_of_type_JavaLangCharSequence)))
    {
      paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetButton.setText(paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem$ActionInfo.jdField_a_of_type_JavaLangCharSequence);
      paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new SearchTemplatePresenter.9(this, localContext, paramNetSearchTemplateUniversalItem));
      return;
    }
    paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
  }
  
  public void a(Context paramContext, SquareImageView paramSquareImageView, ImageView paramImageView, TextView paramTextView, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return;
    case 1: 
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, paramInt2, false, paramString1, null, 0, false);
      return;
    case 2: 
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, (int)(paramInt2 * 1.4F), false, paramString1, null, 0, false);
      return;
    case 3: 
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, paramInt2, false, paramString1, null, 2130842512, false);
      return;
    case 4: 
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, paramInt2, false, paramString1, null, 2130842512, false);
      return;
    case 5: 
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, paramInt2, false, paramString1, null, 0, true);
      return;
    case 6: 
      paramInt1 = DisplayUtil.a(paramContext, 62.0F);
      a(paramSquareImageView, paramImageView, paramTextView, DisplayUtil.a(paramContext, 100.0F), paramInt1, false, paramString1, null, 2130842512, false);
      return;
    case 7: 
      a(paramSquareImageView, paramImageView, paramTextView, DisplayUtil.a(paramContext, 100.0F), DisplayUtil.a(paramContext, 62.0F), false, paramString1, paramString2, 0, false);
      return;
    }
    a(paramSquareImageView, paramImageView, paramTextView, DisplayUtil.a(paramContext, 100.0F), DisplayUtil.a(paramContext, 62.0F), false, paramString1, null, 0, false);
  }
  
  public void a(ImageView paramImageView)
  {
    if (paramImageView == null) {}
    Animation localAnimation;
    do
    {
      return;
      localAnimation = AnimationUtils.loadAnimation(paramImageView.getContext(), 2130772220);
    } while (localAnimation == null);
    localAnimation.setInterpolator(new LinearInterpolator());
    paramImageView.startAnimation(localAnimation);
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
    while (paramTextView.getVisibility() == 8) {
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  public void a(NetSearchTemplateBaseItem paramNetSearchTemplateBaseItem, NetSearchTemplateBaseView paramNetSearchTemplateBaseView)
  {
    SearchViewUtils.a(paramNetSearchTemplateBaseItem.a(), paramNetSearchTemplateBaseItem.b(), paramNetSearchTemplateBaseView.a(), paramNetSearchTemplateBaseItem.jdField_a_of_type_Boolean, paramNetSearchTemplateBaseItem.u, paramNetSearchTemplateBaseItem.g);
    switch (paramNetSearchTemplateBaseItem.d())
    {
    }
    for (;;)
    {
      b(paramNetSearchTemplateBaseItem, paramNetSearchTemplateBaseView);
      if (TextUtils.isEmpty(paramNetSearchTemplateBaseItem.i)) {
        c(paramNetSearchTemplateBaseItem, paramNetSearchTemplateBaseView);
      }
      return;
      a((NetSearchTemplateAvatarsItem)paramNetSearchTemplateBaseItem, (NetSearchTemplateAvatarsView)paramNetSearchTemplateBaseView);
      continue;
      a((NetSearchTemplateUpdatesItem)paramNetSearchTemplateBaseItem, (NetSearchTemplateUpdatesView)paramNetSearchTemplateBaseView);
      continue;
      a((NetSearchTemplateBannerTitleItem)paramNetSearchTemplateBaseItem, (NetSearchTemplateBannerTitleView)paramNetSearchTemplateBaseView);
      continue;
      a((NetSearchTemplateHorizontalContainerItem)paramNetSearchTemplateBaseItem, (NetSearchTemplateHorizontalContainerView)paramNetSearchTemplateBaseView);
      continue;
      a((NetSearchTemplateUniversalItem)paramNetSearchTemplateBaseItem, (NetSearchTemplateUniversalView)paramNetSearchTemplateBaseView);
      continue;
      a((NetSearchTemplateSubItem)paramNetSearchTemplateBaseItem, (NetSearchTemplateSubItemView)paramNetSearchTemplateBaseView);
      continue;
      a((NetSearchTemplateSubItemTitle)paramNetSearchTemplateBaseItem, (NetSearchTemplateSubItemTitleView)paramNetSearchTemplateBaseView);
      continue;
      a((NetSearchTemplateFriendUpdatesItem)paramNetSearchTemplateBaseItem, (NetSearchTemplateFriendUpdatesView)paramNetSearchTemplateBaseView);
      continue;
      a((NetSearchTemplateBigImageItem)paramNetSearchTemplateBaseItem, (NetSearchTemplateBigImageView)paramNetSearchTemplateBaseView);
      continue;
      a((NetSearchTemplateHorSlidingContainerItem)paramNetSearchTemplateBaseItem, (NetSearchTemplateHorSlidingContainerView)paramNetSearchTemplateBaseView);
      continue;
      a((NetSearchTemplateTitleItem)paramNetSearchTemplateBaseItem, (NetSearchTemplateTitleView)paramNetSearchTemplateBaseView);
      continue;
      a((NetSearchTemplateQAItem)paramNetSearchTemplateBaseItem, (NetSearchTemplateQAView)paramNetSearchTemplateBaseView);
      continue;
      a((NetSearchTemplateNetSeaEntranceItem)paramNetSearchTemplateBaseItem, (NetSearchTemplateNetSeaEntranceView)paramNetSearchTemplateBaseView);
      continue;
      a((NetSearchTemplateNewEntranceItem)paramNetSearchTemplateBaseItem, (NetSearchTemplateNewEntranceView)paramNetSearchTemplateBaseView);
      continue;
      a((NetSearchTemplateMiniAppItem)paramNetSearchTemplateBaseItem, (NetSearchTemplateMiniAppView)paramNetSearchTemplateBaseView);
    }
  }
  
  public void a(NetSearchTemplateBaseItem paramNetSearchTemplateBaseItem, NetSearchTemplateBaseView paramNetSearchTemplateBaseView, Bitmap paramBitmap)
  {
    if (paramNetSearchTemplateBaseView.b() != null) {
      paramNetSearchTemplateBaseView.b().setImageBitmap(paramBitmap);
    }
  }
  
  protected void a(NetSearchTemplateHorSlidingContainerItem paramNetSearchTemplateHorSlidingContainerItem, NetSearchTemplateHorSlidingContainerView paramNetSearchTemplateHorSlidingContainerView)
  {
    if ((paramNetSearchTemplateHorSlidingContainerItem.jdField_a_of_type_JavaUtilArrayList == null) || (paramNetSearchTemplateHorSlidingContainerItem.jdField_a_of_type_JavaUtilArrayList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bindHorSlidingContainerTemplateView, containerItem.horizontalModelItems is empty");
      }
      return;
    }
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
  }
  
  protected void a(NetSearchTemplateHorizontalContainerItem paramNetSearchTemplateHorizontalContainerItem, NetSearchTemplateHorizontalContainerView paramNetSearchTemplateHorizontalContainerView)
  {
    paramNetSearchTemplateHorizontalContainerView.a().getContext();
    paramNetSearchTemplateHorizontalContainerView.a();
    if ((paramNetSearchTemplateHorizontalContainerItem.jdField_a_of_type_JavaUtilArrayList == null) || (paramNetSearchTemplateHorizontalContainerItem.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bindHorizontalContainerTemplateView, containerItem.horizontalModelItems is empty");
      }
    }
    for (;;)
    {
      return;
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
    }
  }
  
  protected void a(NetSearchTemplateMiniAppItem paramNetSearchTemplateMiniAppItem, NetSearchTemplateMiniAppView paramNetSearchTemplateMiniAppView)
  {
    Object localObject1 = (LinearLayout)paramNetSearchTemplateMiniAppView.b();
    MiniProgramSearchResultModel localMiniProgramSearchResultModel;
    Object localObject2;
    MiniProgramSearchResultView localMiniProgramSearchResultView;
    if ((localObject1 != null) && (paramNetSearchTemplateMiniAppItem.a != null))
    {
      ((LinearLayout)localObject1).removeAllViews();
      if (((LinearLayout)localObject1).getParent() != null) {
        ((View)((LinearLayout)localObject1).getParent()).setPadding(0, 0, 0, 0);
      }
      localMiniProgramSearchResultModel = paramNetSearchTemplateMiniAppItem.a;
      paramNetSearchTemplateMiniAppItem = paramNetSearchTemplateMiniAppView.a().getContext();
      localObject2 = LayoutInflater.from(paramNetSearchTemplateMiniAppItem).inflate(2131562980, null);
      localMiniProgramSearchResultView = new MiniProgramSearchResultView((View)localObject2);
      Object localObject3 = ((View)localObject2).findViewById(2131369281);
      int i = ViewUtils.a(6.0F);
      ((View)localObject3).setPadding(0, i, 0, i);
      ((LinearLayout)localObject1).addView((View)localObject2);
      if (localMiniProgramSearchResultModel.c() != null) {
        break label631;
      }
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
        if (!TextUtils.isEmpty(localMiniProgramSearchResultModel.a())) {
          ((TextView)localObject1).setText(localMiniProgramSearchResultModel.a());
        }
      }
      if ((localMiniProgramSearchResultView.b() != null) && (!TextUtils.isEmpty(localMiniProgramSearchResultModel.g())))
      {
        localObject1 = localMiniProgramSearchResultModel.g();
        localObject2 = new ColorDrawable(Color.parseColor("#e7e7e7"));
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = DisplayUtil.a(paramNetSearchTemplateMiniAppItem, 50.0F);
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = DisplayUtil.a(paramNetSearchTemplateMiniAppItem, 50.0F);
        ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject2);
        ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject2);
        if (!URLUtil.a((String)localObject1)) {
          break label756;
        }
        localObject1 = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject3);
        ((URLDrawable)localObject1).setTag(URLDrawableDecodeHandler.b(DisplayUtil.a(paramNetSearchTemplateMiniAppItem, 50.0F), DisplayUtil.a(paramNetSearchTemplateMiniAppView.a().getContext(), 50.0F), DisplayUtil.a(paramNetSearchTemplateMiniAppItem, 3.0F)));
        ((URLDrawable)localObject1).setDecodeHandler(URLDrawableDecodeHandler.j);
        localMiniProgramSearchResultView.b().setImageDrawable((Drawable)localObject1);
        if ((((URLDrawable)localObject1).getStatus() != 1) && (((URLDrawable)localObject1).getStatus() != 0)) {
          ((URLDrawable)localObject1).restartDownload();
        }
      }
      label397:
      localMiniProgramSearchResultView.a().setOnClickListener(new SearchTemplatePresenter.2(this, localMiniProgramSearchResultModel));
      if ((localMiniProgramSearchResultView.a() != null) && (localMiniProgramSearchResultModel.c()))
      {
        paramNetSearchTemplateMiniAppView = localMiniProgramSearchResultModel.h();
        localObject1 = new ColorDrawable(Color.parseColor("#e7e7e7"));
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = DisplayUtil.a(paramNetSearchTemplateMiniAppItem, 40.0F);
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = DisplayUtil.a(paramNetSearchTemplateMiniAppItem, 12.0F);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
        paramNetSearchTemplateMiniAppView = URLDrawable.getDrawable(paramNetSearchTemplateMiniAppView, (URLDrawable.URLDrawableOptions)localObject2);
        paramNetSearchTemplateMiniAppView.setTag(URLDrawableDecodeHandler.b(DisplayUtil.a(paramNetSearchTemplateMiniAppItem, 38.0F), DisplayUtil.a(paramNetSearchTemplateMiniAppItem, 12.0F), 0));
        paramNetSearchTemplateMiniAppView.setDecodeHandler(URLDrawableDecodeHandler.j);
        localMiniProgramSearchResultView.a().setImageDrawable(paramNetSearchTemplateMiniAppView);
        if ((paramNetSearchTemplateMiniAppView.getStatus() != 1) && (paramNetSearchTemplateMiniAppView.getStatus() != 0)) {
          paramNetSearchTemplateMiniAppView.restartDownload();
        }
      }
      paramNetSearchTemplateMiniAppItem = new SimpleMiniAppConfig.SimpleMiniAppInfo();
      paramNetSearchTemplateMiniAppItem.appId = localMiniProgramSearchResultModel.a.appId;
      paramNetSearchTemplateMiniAppView = new SimpleMiniAppConfig(paramNetSearchTemplateMiniAppItem);
      if (localMiniProgramSearchResultModel.a.showMask != 1) {
        break label769;
      }
    }
    label769:
    for (paramNetSearchTemplateMiniAppItem = "used";; paramNetSearchTemplateMiniAppItem = "unused")
    {
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).report4239Async(paramNetSearchTemplateMiniAppView, "search", "result_view", paramNetSearchTemplateMiniAppItem, localMiniProgramSearchResultModel.a());
      return;
      label631:
      if ((localMiniProgramSearchResultView.c() != null) && (!TextUtils.isEmpty(localMiniProgramSearchResultModel.c())))
      {
        localMiniProgramSearchResultView.c().setVisibility(0);
        localMiniProgramSearchResultView.c().setText(localMiniProgramSearchResultModel.c());
      }
      for (;;)
      {
        if (localMiniProgramSearchResultView.a() != null) {
          localMiniProgramSearchResultView.a().setVisibility(0);
        }
        localObject1 = localMiniProgramSearchResultView.e();
        if (localObject1 != null) {
          ((TextView)localObject1).setVisibility(8);
        }
        if (TextUtils.isEmpty(localMiniProgramSearchResultModel.a())) {
          break;
        }
        localMiniProgramSearchResultView.a().setText(localMiniProgramSearchResultModel.a());
        break;
        if (localMiniProgramSearchResultView.c() != null) {
          localMiniProgramSearchResultView.c().setVisibility(8);
        }
      }
      label756:
      localMiniProgramSearchResultView.b().setImageDrawable((Drawable)localObject2);
      break label397;
    }
  }
  
  protected void a(NetSearchTemplateQAItem paramNetSearchTemplateQAItem, NetSearchTemplateQAView paramNetSearchTemplateQAView)
  {
    Object localObject1 = paramNetSearchTemplateQAView.a().getContext();
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      paramNetSearchTemplateQAView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      paramNetSearchTemplateQAView.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#4A4A4A"));
      if (TextUtils.isEmpty(paramNetSearchTemplateQAItem.jdField_b_of_type_JavaLangString)) {
        break label290;
      }
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
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
    label290:
    for (;;)
    {
      label166:
      if (!TextUtils.isEmpty(paramNetSearchTemplateQAItem.j))
      {
        int j = paramNetSearchTemplateQAView.jdField_a_of_type_AndroidWidgetTextView.getContext().getResources().getDisplayMetrics().widthPixels;
        int i = (int)SearchUtils.a(paramNetSearchTemplateQAView.jdField_a_of_type_AndroidWidgetTextView, " ");
        int k = DisplayUtil.a((Context)localObject1, 22.0F) / i;
        localObject1 = "";
        i = 0;
        for (;;)
        {
          if (i < k)
          {
            localObject1 = (String)localObject1 + " ";
            i += 1;
            continue;
            paramNetSearchTemplateQAView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#262626"));
            paramNetSearchTemplateQAView.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
            break;
            paramNetSearchTemplateQAView.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
            break label166;
          }
        }
        localObject1 = SearchUtils.a(paramNetSearchTemplateQAView.jdField_a_of_type_AndroidWidgetTextView, j, 2, (String)localObject1 + paramNetSearchTemplateQAItem.j, paramNetSearchTemplateQAItem.jdField_a_of_type_ComTencentMobileqqSearchUtilHighlightModel.jdField_a_of_type_JavaUtilList, false, false, true);
        paramNetSearchTemplateQAView.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      }
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
    if (!TextUtils.isEmpty(paramNetSearchTemplateTitleItem.jdField_b_of_type_JavaLangString))
    {
      paramNetSearchTemplateTitleView.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramNetSearchTemplateTitleView.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramNetSearchTemplateTitleView.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().height;
      localObject = URLDrawable.getDrawable(paramNetSearchTemplateTitleItem.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      paramNetSearchTemplateTitleView.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      if (TextUtils.isEmpty(paramNetSearchTemplateTitleItem.j)) {
        break label345;
      }
      paramNetSearchTemplateTitleView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      int i = paramNetSearchTemplateTitleView.jdField_a_of_type_AndroidWidgetTextView.getContext().getResources().getDisplayMetrics().widthPixels;
      localObject = SearchUtils.a(paramNetSearchTemplateTitleView.jdField_a_of_type_AndroidWidgetTextView, i, 1, paramNetSearchTemplateTitleItem.j, paramNetSearchTemplateTitleItem.jdField_a_of_type_ComTencentMobileqqSearchUtilHighlightModel.jdField_a_of_type_JavaUtilList, false, false, true);
      paramNetSearchTemplateTitleView.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      label183:
      if (TextUtils.isEmpty(paramNetSearchTemplateTitleItem.l)) {
        break label357;
      }
      paramNetSearchTemplateTitleView.jdField_b_of_type_AndroidWidgetTextView.setText(paramNetSearchTemplateTitleItem.l);
      paramNetSearchTemplateTitleView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramNetSearchTemplateTitleView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      label220:
      if (TextUtils.isEmpty(paramNetSearchTemplateTitleItem.k)) {
        break label378;
      }
      paramNetSearchTemplateTitleView.c.setText(paramNetSearchTemplateTitleItem.k);
      paramNetSearchTemplateTitleView.c.setVisibility(0);
    }
    for (;;)
    {
      if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        break label390;
      }
      paramNetSearchTemplateTitleView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramNetSearchTemplateTitleView.jdField_a_of_type_AndroidWidgetTextView.getContext().getResources().getColor(2131166964));
      paramNetSearchTemplateTitleView.c.setTextColor(paramNetSearchTemplateTitleView.c.getContext().getResources().getColor(2131166963));
      paramNetSearchTemplateTitleView.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramNetSearchTemplateTitleView.jdField_b_of_type_AndroidWidgetTextView.getContext().getResources().getColor(2131166963));
      return;
      paramNetSearchTemplateTitleView.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break;
      label345:
      paramNetSearchTemplateTitleView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label183;
      label357:
      paramNetSearchTemplateTitleView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramNetSearchTemplateTitleView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label220;
      label378:
      paramNetSearchTemplateTitleView.c.setVisibility(8);
    }
    label390:
    paramNetSearchTemplateTitleView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#262626"));
    paramNetSearchTemplateTitleView.c.setTextColor(Color.parseColor("#737373"));
    paramNetSearchTemplateTitleView.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
  }
  
  public void a(SquareImageView paramSquareImageView, ImageView paramImageView, TextView paramTextView, int paramInt1, int paramInt2, boolean paramBoolean1, String paramString1, String paramString2, int paramInt3, boolean paramBoolean2)
  {
    ViewGroup.LayoutParams localLayoutParams = paramSquareImageView.getLayoutParams();
    if ((paramSquareImageView.getContext() instanceof PublicAcntSearchActivity))
    {
      localLayoutParams.width = DisplayUtil.a(paramSquareImageView.getContext(), 50.0F);
      localLayoutParams.height = DisplayUtil.a(paramSquareImageView.getContext(), 50.0F);
      paramSquareImageView.setLayoutParams(localLayoutParams);
      if (paramInt2 == 0) {
        break label273;
      }
      paramSquareImageView.setImageScale(paramInt1 * 1.0F / paramInt2, 0.0F);
      label71:
      if (!paramBoolean1) {
        break label282;
      }
      paramSquareImageView.setFilterColor(Color.parseColor("#66000000"));
      label86:
      if (paramInt3 == 0) {
        break label290;
      }
      paramImageView.setImageResource(paramInt3);
      paramImageView.setVisibility(0);
      label102:
      if ((paramString2 == null) || (TextUtils.isEmpty(paramString2))) {
        break label299;
      }
      paramTextView.setVisibility(0);
      paramTextView.setText(paramString2);
      label126:
      paramImageView = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable.setBounds(0, 0, paramInt1, paramInt2);
      paramString2 = paramImageView;
    }
    for (;;)
    {
      label273:
      label282:
      label290:
      label299:
      try
      {
        if (!TextUtils.isEmpty(paramString1))
        {
          paramTextView = URLDrawable.URLDrawableOptions.obtain();
          paramTextView.mRequestWidth = paramInt1;
          paramTextView.mRequestHeight = paramInt2;
          paramTextView.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          paramTextView.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          if (!paramBoolean2) {
            continue;
          }
          paramTextView.mMemoryCacheKeySuffix = "isAvatar";
          paramTextView = URLDrawable.getDrawable(paramString1, paramTextView);
          paramTextView.setDecodeHandler(URLDrawableDecodeHandler.a);
          paramString2 = paramTextView;
          paramImageView = paramTextView;
          paramTextView = paramString2;
          paramString2 = paramTextView;
        }
      }
      catch (Exception paramTextView) {}
      try
      {
        if (paramTextView.getStatus() != 1)
        {
          paramString2 = paramTextView;
          if (paramTextView.getStatus() != 0)
          {
            paramTextView.restartDownload();
            paramString2 = paramTextView;
          }
        }
        paramSquareImageView.setImageDrawable(paramString2);
        return;
      }
      catch (Exception paramTextView)
      {
        break label326;
      }
      localLayoutParams.width = paramInt1;
      localLayoutParams.height = paramInt2;
      break;
      paramSquareImageView.setImageScale(1.0F, 0.0F);
      break label71;
      paramSquareImageView.setFilterColor(-1);
      break label86;
      paramImageView.setVisibility(8);
      break label102;
      paramTextView.setVisibility(8);
      break label126;
      paramTextView.mMemoryCacheKeySuffix = "isNotAvatar";
      paramTextView = URLDrawable.getDrawable(paramString1, paramTextView);
      continue;
      label326:
      QLog.e("Q.uniteSearch.SearchTemplatePresenter", 1, "imageUrl is not valid. imageUrl=" + paramString1, paramTextView);
      paramString2 = paramImageView;
    }
  }
  
  protected void b(NetSearchTemplateBaseItem paramNetSearchTemplateBaseItem, NetSearchTemplateBaseView paramNetSearchTemplateBaseView)
  {
    if (paramNetSearchTemplateBaseView.a() != null) {
      paramNetSearchTemplateBaseView.a().setOnClickListener(new SearchTemplatePresenter.1(this, paramNetSearchTemplateBaseItem));
    }
  }
  
  public void c(NetSearchTemplateBaseItem paramNetSearchTemplateBaseItem, NetSearchTemplateBaseView paramNetSearchTemplateBaseView)
  {
    if ((paramNetSearchTemplateBaseView.b() != null) && ((paramNetSearchTemplateBaseItem instanceof IFaceModel)) && (!TextUtils.isEmpty(paramNetSearchTemplateBaseItem.b()))) {
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
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {}
    ImageView localImageView;
    do
    {
      return;
      localImageView = (ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localImageView == null);
    boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    Resources localResources = localImageView.getContext().getResources();
    if (paramInt == 1)
    {
      localImageView.post(new SearchTemplatePresenter.10(this, bool, localImageView));
      return;
    }
    if (paramInt == 2)
    {
      localImageView.getContext();
      ((Integer)localImageView.getTag()).intValue();
      SearchUtils.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      localImageView.post(new SearchTemplatePresenter.11(this, localImageView, bool));
      localImageView.setContentDescription(localResources.getString(2131690295));
      this.jdField_a_of_type_ComTencentMobileqqSearchAdapterGroupSearchAdapter.notifyDataSetChanged();
      return;
    }
    localImageView.post(new SearchTemplatePresenter.12(this, localImageView, bool));
    localImageView.setContentDescription(localResources.getString(2131690293));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.SearchTemplatePresenter
 * JD-Core Version:    0.7.0.1
 */