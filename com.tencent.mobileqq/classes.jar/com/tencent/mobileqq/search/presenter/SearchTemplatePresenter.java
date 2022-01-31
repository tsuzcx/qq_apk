package com.tencent.mobileqq.search.presenter;

import ahuo;
import ahup;
import ahuq;
import ahur;
import ahus;
import ahut;
import ahuu;
import ahuv;
import ahuw;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;
import android.view.View.MeasureSpec;
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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.QQPlayerService.QQPlayerCallback;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.search.activity.PublicAcntSearchActivity;
import com.tencent.mobileqq.search.adapter.GroupSearchAdapter;
import com.tencent.mobileqq.search.model.IFaceModel;
import com.tencent.mobileqq.search.model.ImageItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateAvatarsItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateBannerTitleItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateBaseItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateBaseItem.ImageInfo;
import com.tencent.mobileqq.search.model.NetSearchTemplateHorizontalBaseItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateHorizontalContainerItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateMovieItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateNormalItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateSubItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateSubItemTitle;
import com.tencent.mobileqq.search.model.NetSearchTemplateUniversalItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateUniversalItem.ActionInfo;
import com.tencent.mobileqq.search.model.NetSearchTemplateUniversalItem.HeadIconInfo;
import com.tencent.mobileqq.search.model.NetSearchTemplateUniversalItem.NormalWord;
import com.tencent.mobileqq.search.model.NetSearchTemplateUpdatesItem;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.SearchViewUtils;
import com.tencent.mobileqq.search.view.NetSearchTemplateAvatarsView;
import com.tencent.mobileqq.search.view.NetSearchTemplateBannerTitleView;
import com.tencent.mobileqq.search.view.NetSearchTemplateBaseView;
import com.tencent.mobileqq.search.view.NetSearchTemplateHorizontalBaseView;
import com.tencent.mobileqq.search.view.NetSearchTemplateHorizontalContainerView;
import com.tencent.mobileqq.search.view.NetSearchTemplateMovieView;
import com.tencent.mobileqq.search.view.NetSearchTemplateNormalView;
import com.tencent.mobileqq.search.view.NetSearchTemplateSubItemTitleView;
import com.tencent.mobileqq.search.view.NetSearchTemplateSubItemView;
import com.tencent.mobileqq.search.view.NetSearchTemplateUniversalView;
import com.tencent.mobileqq.search.view.NetSearchTemplateUpdatesView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class SearchTemplatePresenter
  implements QQPlayerService.QQPlayerCallback, IFacePresenter
{
  public static int a;
  private long jdField_a_of_type_Long;
  public ColorDrawable a;
  public Drawable a;
  private GroupSearchAdapter jdField_a_of_type_ComTencentMobileqqSearchAdapterGroupSearchAdapter;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public SearchTemplatePresenter(FaceDecoder paramFaceDecoder, GroupSearchAdapter paramGroupSearchAdapter)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = URLDrawableHelper.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = paramFaceDecoder;
    this.jdField_a_of_type_ComTencentMobileqqSearchAdapterGroupSearchAdapter = paramGroupSearchAdapter;
  }
  
  private float a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return 7.0F;
    }
    return 3.5F;
  }
  
  public static int a(TextView paramTextView1, TextView paramTextView2, CharSequence paramCharSequence)
  {
    Paint localPaint = new Paint();
    if ((paramTextView1 == null) || (paramTextView2 == null) || (paramCharSequence == null)) {
      return 1;
    }
    float f = paramTextView1.getContext().getResources().getDisplayMetrics().widthPixels - AIOUtils.a(89.0F, paramTextView1.getContext().getResources());
    localPaint.setTextSize(paramTextView1.getTextSize());
    if (localPaint.measureText(paramCharSequence, 0, paramCharSequence.length()) > f)
    {
      paramTextView1.setMaxLines(2);
      paramTextView2.setMaxLines(1);
      return 2;
    }
    paramTextView1.setMaxLines(1);
    paramTextView2.setMaxLines(2);
    return 1;
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
        paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new ahur(this, localContext, paramNetSearchTemplateUniversalItem));
      }
      for (;;)
      {
        i = (int)(0 + (SearchUtils.a(paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetButton, paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem$ActionInfo.jdField_a_of_type_JavaLangCharSequence) + DisplayUtil.a(localContext, 32.0F) + DisplayUtil.a(localContext, 15.0F)));
        if (!bool) {
          break;
        }
        paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130840967);
        paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#6991B8"));
        return i;
        paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130840966);
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
      int k = ((Integer)paramNetSearchTemplateUniversalView.a().getTag(2131362080)).intValue();
      SongInfo localSongInfo1 = new SongInfo();
      i = 0;
      j = i;
      for (;;)
      {
        try
        {
          JSONObject localJSONObject = new JSONObject(paramNetSearchTemplateUniversalItem.h);
          j = i;
          localSongInfo1.jdField_a_of_type_JavaLangString = localJSONObject.optString("audio_url");
          j = i;
          localSongInfo1.jdField_b_of_type_JavaLangString = localJSONObject.optString("title");
          j = i;
          localSongInfo1.c = localJSONObject.optString("desc");
          j = i;
          localSongInfo1.d = localJSONObject.optString("image_url");
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
          SongInfo localSongInfo2 = QQPlayerService.a();
          if (localSongInfo2 == null) {
            continue;
          }
          SearchUtils.jdField_a_of_type_Long = localSongInfo2.jdField_a_of_type_Long;
          continue;
          paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845492);
          continue;
          if (this.jdField_a_of_type_Long != SearchUtils.jdField_a_of_type_Long) {
            continue;
          }
          paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845493);
          continue;
          paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845491);
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
        paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845494);
        if ((j == 0) || (i == 0) || (TextUtils.isEmpty(localSongInfo1.jdField_a_of_type_JavaLangString))) {
          continue;
        }
        paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new ahus(this, paramNetSearchTemplateUniversalView, k, localContext, bool, localSongInfo1, paramNetSearchTemplateUniversalItem));
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
        if (paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_a_of_type_Int == 1)
        {
          if (paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetTextView != null) {
            paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          if ((paramNetSearchTemplateUniversalView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView == null) || (TextUtils.isEmpty(paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_a_of_type_JavaLangString))) {
            break label784;
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
          break label453;
        }
        localObject1 = SearchUtils.a(paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetTextView, paramInt1, ((CharSequence)localObject1).toString(), paramNetSearchTemplateUniversalItem.a((CharSequence)localObject1), false);
        label277:
        paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      }
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramNetSearchTemplateUniversalView.c != null) {
          break label495;
        }
        return paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetLinearLayout.getHeight();
        if (paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_a_of_type_Int != 2) {
          break label784;
        }
        if (paramNetSearchTemplateUniversalView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView != null) {
          paramNetSearchTemplateUniversalView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(8);
        }
        if ((paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetTextView == null) || (TextUtils.isEmpty(paramNetSearchTemplateUniversalItem.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_a_of_type_JavaLangCharSequence))) {
          break label784;
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
        label453:
        localObject1 = SearchUtils.a(paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetTextView, paramInt1, ((CharSequence)localObject1).toString());
        break label277;
        if (paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
          paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
      }
      label495:
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
              break label781;
            }
            localObject1 = ((CharSequence)localObject1).toString();
          }
        }
      }
      label781:
      for (;;)
      {
        paramInt2 = localNormalWord.jdField_a_of_type_Int;
        if ((localContext instanceof PublicAcntSearchActivity)) {
          paramInt2 = 1;
        }
        Object localObject2 = localObject1;
        if (localNormalWord.jdField_a_of_type_Boolean) {
          localObject2 = SearchUtils.a(localTextView, i, paramInt2, ((CharSequence)localObject1).toString(), paramNetSearchTemplateUniversalItem.a((CharSequence)localObject1), false);
        }
        if (paramInt1 != 0) {
          localTextView.setPadding(0, DisplayUtil.a(localContext, 7.0F - a(((NetSearchTemplateUniversalItem.NormalWord)paramNetSearchTemplateUniversalItem.jdField_a_of_type_JavaUtilArrayList.get(paramInt1 - 1)).jdField_a_of_type_JavaLangString, localNormalWord.jdField_a_of_type_JavaLangString)), 0, 0);
        }
        localTextView.setText((CharSequence)localObject2);
        paramNetSearchTemplateUniversalView.c.addView(localTextView);
        break;
        paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        b(paramNetSearchTemplateUniversalItem, paramNetSearchTemplateUniversalView);
        paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0);
        paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetLinearLayout.measure(paramInt1, paramInt2);
        return paramNetSearchTemplateUniversalView.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredHeight();
      }
      label784:
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
  
  public static Pair a(NetSearchTemplateBaseItem paramNetSearchTemplateBaseItem, NetSearchTemplateBaseView paramNetSearchTemplateBaseView, boolean paramBoolean, int paramInt)
  {
    if ((paramNetSearchTemplateBaseView == null) || (paramNetSearchTemplateBaseView.jdField_b_of_type_AndroidWidgetRelativeLayout == null) || (paramNetSearchTemplateBaseView.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView == null) || (paramNetSearchTemplateBaseItem == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.SearchTemplatePresenter", 2, "bindUniversalTemplateLeftImageview or item is null");
      }
      return new Pair(Integer.valueOf(0), Integer.valueOf(0));
    }
    Object localObject1 = paramNetSearchTemplateBaseView.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView;
    NetSearchTemplateBaseItem.ImageInfo localImageInfo = paramNetSearchTemplateBaseItem.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateBaseItem$ImageInfo;
    if ((localImageInfo == null) || (TextUtils.isEmpty(localImageInfo.jdField_a_of_type_JavaLangString)))
    {
      paramNetSearchTemplateBaseView.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return new Pair(Integer.valueOf(0), Integer.valueOf(0));
    }
    paramNetSearchTemplateBaseView.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    paramNetSearchTemplateBaseItem = ((SquareImageView)localObject1).getContext();
    Object localObject2 = a((SquareImageView)localObject1, localImageInfo.jdField_a_of_type_Int, localImageInfo.jdField_a_of_type_JavaLangString, localImageInfo.jdField_b_of_type_Int, paramBoolean, paramInt);
    paramInt = ((Integer)((Pair)localObject2).first).intValue();
    int i = ((Integer)((Pair)localObject2).second).intValue();
    localObject2 = ((SquareImageView)localObject1).getLayoutParams();
    ((ViewGroup.LayoutParams)localObject2).width = paramInt;
    ((ViewGroup.LayoutParams)localObject2).height = i;
    ((SquareImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject1 = new RelativeLayout.LayoutParams(paramInt, i);
    paramNetSearchTemplateBaseView.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    int j = DisplayUtil.a(paramNetSearchTemplateBaseItem, 10.0F);
    if ((!TextUtils.isEmpty(localImageInfo.jdField_a_of_type_JavaLangCharSequence)) && (paramNetSearchTemplateBaseView.e != null)) {
      if (SearchUtils.e(localImageInfo.jdField_b_of_type_JavaLangString))
      {
        paramNetSearchTemplateBaseItem = localImageInfo.jdField_b_of_type_JavaLangString;
        ((GradientDrawable)paramNetSearchTemplateBaseView.e.getBackground()).setColor(Color.parseColor(paramNetSearchTemplateBaseItem));
        paramNetSearchTemplateBaseView.e.setVisibility(0);
        paramNetSearchTemplateBaseView.e.setText(localImageInfo.jdField_a_of_type_JavaLangCharSequence);
        label299:
        if (paramNetSearchTemplateBaseView.c != null)
        {
          if (!localImageInfo.jdField_a_of_type_Boolean) {
            break label406;
          }
          paramNetSearchTemplateBaseView.c.setVisibility(0);
        }
        label322:
        if (paramNetSearchTemplateBaseView.f != null)
        {
          if (TextUtils.isEmpty(localImageInfo.jdField_b_of_type_JavaLangCharSequence)) {
            break label418;
          }
          paramNetSearchTemplateBaseView.f.setVisibility(0);
          paramNetSearchTemplateBaseView.f.setText(localImageInfo.jdField_b_of_type_JavaLangCharSequence);
        }
      }
    }
    for (;;)
    {
      return new Pair(Integer.valueOf(paramInt + j), Integer.valueOf(i));
      paramNetSearchTemplateBaseItem = "#fd7f32";
      break;
      if (paramNetSearchTemplateBaseView.e == null) {
        break label299;
      }
      paramNetSearchTemplateBaseView.e.setVisibility(8);
      break label299;
      label406:
      paramNetSearchTemplateBaseView.c.setVisibility(8);
      break label322;
      label418:
      paramNetSearchTemplateBaseView.f.setVisibility(8);
    }
  }
  
  public static Pair a(SquareImageView paramSquareImageView, int paramInt1, String paramString, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    if ((paramSquareImageView == null) || (TextUtils.isEmpty(paramString))) {
      return new Pair(Integer.valueOf(0), Integer.valueOf(0));
    }
    Object localObject1 = paramSquareImageView.getContext();
    int i;
    int j;
    ColorDrawable localColorDrawable;
    switch (paramInt1)
    {
    default: 
      i = DisplayUtil.a((Context)localObject1, 60.0F);
      paramInt1 = DisplayUtil.a((Context)localObject1, 60.0F);
      j = 0;
      localColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
      if (paramBoolean)
      {
        int k = (int)(paramInt1 * 1.0F / i * paramInt3);
        paramInt1 = k;
        i = paramInt3;
        if (j != 0)
        {
          i = (int)(paramInt3 * 0.9D);
          paramInt1 = (int)(k * 0.9D);
        }
      }
      break;
    }
    for (;;)
    {
      paramSquareImageView.setImageScale(i * 1.0F / paramInt1, 0.0F);
      localColorDrawable.setBounds(0, 0, i, paramInt1);
      for (;;)
      {
        try
        {
          if (TextUtils.isEmpty(paramString)) {
            continue;
          }
          localObject1 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = i;
          ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = paramInt1;
          ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = localColorDrawable;
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = localColorDrawable;
          if (j == 0) {
            continue;
          }
          ((URLDrawable.URLDrawableOptions)localObject1).mMemoryCacheKeySuffix = ("isAvatar" + i + paramInt1);
          localObject1 = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject1);
          ((URLDrawable)localObject1).setDecodeHandler(URLDrawableDecodeHandler.a);
          localObject2 = localObject1;
          if (((URLDrawable)localObject1).getStatus() != 1)
          {
            localObject2 = localObject1;
            if (((URLDrawable)localObject1).getStatus() != 0)
            {
              ((URLDrawable)localObject1).restartDownload();
              localObject2 = localObject1;
            }
          }
        }
        catch (Exception localException)
        {
          QLog.e("Q.uniteSearch.SearchTemplatePresenter", 1, "imageUrl is not valid. imageUrl=" + paramString, localException);
          Object localObject2 = localColorDrawable;
          continue;
        }
        paramSquareImageView.setImageDrawable((Drawable)localObject2);
        return new Pair(Integer.valueOf(i), Integer.valueOf(paramInt1));
        i = DisplayUtil.a((Context)localObject1, 60.0F);
        paramInt1 = DisplayUtil.a((Context)localObject1, 60.0F);
        j = 0;
        break;
        i = DisplayUtil.a((Context)localObject1, 50.0F);
        paramInt1 = DisplayUtil.a((Context)localObject1, 50.0F);
        j = 0;
        break;
        if ((paramSquareImageView.getContext() instanceof PublicAcntSearchActivity))
        {
          i = DisplayUtil.a(paramSquareImageView.getContext(), 50.0F);
          paramInt1 = DisplayUtil.a(paramSquareImageView.getContext(), 50.0F);
          j = 1;
          break;
        }
        i = DisplayUtil.a((Context)localObject1, 60.0F);
        paramInt1 = DisplayUtil.a((Context)localObject1, 60.0F);
        continue;
        i = DisplayUtil.a((Context)localObject1, 50.0F);
        paramInt1 = DisplayUtil.a((Context)localObject1, 50.0F);
        j = 1;
        break;
        i = DisplayUtil.a((Context)localObject1, 60.0F);
        paramInt1 = DisplayUtil.a((Context)localObject1, 85.0F);
        j = 0;
        break;
        i = DisplayUtil.a((Context)localObject1, 100.0F);
        paramInt1 = DisplayUtil.a((Context)localObject1, 60.0F);
        j = 0;
        break;
        i = DisplayUtil.a((Context)localObject1, 100.0F);
        paramInt1 = DisplayUtil.a((Context)localObject1, 141.0F);
        j = 0;
        break;
        i = DisplayUtil.a((Context)localObject1, 220.0F);
        paramInt1 = DisplayUtil.a((Context)localObject1, 136.0F);
        j = 0;
        break;
        i = DisplayUtil.a((Context)localObject1, 162.0F);
        paramInt1 = DisplayUtil.a((Context)localObject1, 162.0F);
        j = 0;
        break;
        i = DisplayUtil.a((Context)localObject1, 162.0F);
        paramInt1 = DisplayUtil.a((Context)localObject1, 228.0F);
        j = 0;
        break;
        i = DisplayUtil.a((Context)localObject1, 162.0F);
        paramInt1 = DisplayUtil.a((Context)localObject1, 162.0F);
        j = 1;
        break;
        ((URLDrawable.URLDrawableOptions)localObject1).mMemoryCacheKeySuffix = ("isNotAvatar" + i + paramInt1 + paramInt2);
        localObject1 = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject1);
        ((URLDrawable)localObject1).setTag(URLDrawableDecodeHandler.a(i, paramInt1, paramInt2));
        ((URLDrawable)localObject1).setDecodeHandler(URLDrawableDecodeHandler.g);
      }
    }
  }
  
  private void a(TextView paramTextView, String paramString, int paramInt)
  {
    if ((paramTextView == null) || (TextUtils.isEmpty(paramString)) || (paramInt <= 0)) {
      return;
    }
    paramTextView.getContext();
    paramTextView.setMaxLines(paramInt);
    paramTextView.setEllipsize(TextUtils.TruncateAt.END);
    boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    if (paramString.equals("A"))
    {
      paramTextView.setTextSize(1, 17.0F);
      if (bool) {
        paramTextView.setTextColor(Color.parseColor("#6991B8"));
      }
      for (;;)
      {
        paramTextView.setIncludeFontPadding(false);
        return;
        paramTextView.setTextColor(Color.parseColor("#000000"));
      }
    }
    if (paramString.equals("B"))
    {
      paramTextView.setTextSize(1, 15.0F);
      if (bool) {
        paramTextView.setTextColor(Color.parseColor("#6991B8"));
      }
      for (;;)
      {
        paramTextView.setIncludeFontPadding(false);
        return;
        paramTextView.setTextColor(Color.parseColor("#000000"));
      }
    }
    if (paramString.equals("C"))
    {
      paramTextView.setTextSize(1, 14.0F);
      if (bool) {
        paramTextView.setTextColor(Color.parseColor("#44608A"));
      }
      for (;;)
      {
        paramTextView.setIncludeFontPadding(false);
        return;
        paramTextView.setTextColor(Color.parseColor("#777777"));
      }
    }
    if (paramString.equals("D"))
    {
      paramTextView.setTextSize(1, 13.0F);
      if (bool) {
        paramTextView.setTextColor(Color.parseColor("#44608A"));
      }
      for (;;)
      {
        paramTextView.setIncludeFontPadding(false);
        return;
        paramTextView.setTextColor(Color.parseColor("#777777"));
      }
    }
    if (paramString.equals("E"))
    {
      paramTextView.setTextSize(1, 12.0F);
      if (bool) {
        paramTextView.setTextColor(Color.parseColor("#717D86"));
      }
      for (;;)
      {
        paramTextView.setIncludeFontPadding(false);
        return;
        paramTextView.setTextColor(Color.parseColor("#BBBBBB"));
      }
    }
    if (paramString.equals("F"))
    {
      paramTextView.setTextSize(1, 12.0F);
      paramTextView.setIncludeFontPadding(false);
      if (bool)
      {
        paramTextView.setTextColor(Color.parseColor("#717D86"));
        return;
      }
      paramTextView.setTextColor(Color.parseColor("#FF9466"));
      return;
    }
    paramTextView.setTextSize(1, 17.0F);
    paramTextView.setTextColor(Color.parseColor("#000000"));
    paramTextView.setIncludeFontPadding(false);
  }
  
  private void a(NetSearchTemplateAvatarsItem paramNetSearchTemplateAvatarsItem, NetSearchTemplateAvatarsView paramNetSearchTemplateAvatarsView)
  {
    int i;
    label28:
    int j;
    Object localObject1;
    if (TextUtils.isEmpty(paramNetSearchTemplateAvatarsItem.jdField_a_of_type_JavaLangCharSequence))
    {
      paramNetSearchTemplateAvatarsView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (paramNetSearchTemplateAvatarsItem.jdField_a_of_type_JavaUtilList == null) {
        return;
      }
      i = 0;
      j = i;
      if (i >= paramNetSearchTemplateAvatarsItem.jdField_a_of_type_JavaUtilList.size()) {
        break label368;
      }
      j = i;
      if (i >= paramNetSearchTemplateAvatarsView.jdField_a_of_type_Int) {
        break label368;
      }
      localObject1 = (SquareImageView)paramNetSearchTemplateAvatarsView.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      Object localObject2 = ((ImageItem)paramNetSearchTemplateAvatarsItem.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString;
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mPlayGifImage = true;
      localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      localObject2 = URLDrawable.getDrawable((String)localObject2, localURLDrawableOptions);
      ((SquareImageView)localObject1).setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      ((SquareImageView)localObject1).setVisibility(0);
      if ((i != paramNetSearchTemplateAvatarsView.jdField_a_of_type_Int - 1) || (paramNetSearchTemplateAvatarsItem.jdField_a_of_type_Int <= paramNetSearchTemplateAvatarsView.jdField_a_of_type_Int)) {
        break label351;
      }
      ((SquareImageView)localObject1).setFilterColor(Color.parseColor("#66000000"));
      int k = paramNetSearchTemplateAvatarsItem.jdField_a_of_type_Int - paramNetSearchTemplateAvatarsView.jdField_a_of_type_Int;
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
      break label28;
      localObject1 = SearchUtils.a(paramNetSearchTemplateAvatarsView.jdField_a_of_type_AndroidWidgetTextView, paramNetSearchTemplateAvatarsView.jdField_a_of_type_AndroidWidgetTextView.getContext().getResources().getDisplayMetrics().widthPixels - DisplayUtil.a(paramNetSearchTemplateAvatarsView.jdField_a_of_type_AndroidWidgetTextView.getContext(), 30.0F), 1, paramNetSearchTemplateAvatarsItem.jdField_a_of_type_JavaLangCharSequence.toString(), paramNetSearchTemplateAvatarsItem.a(paramNetSearchTemplateAvatarsItem.jdField_a_of_type_JavaLangCharSequence), false);
      paramNetSearchTemplateAvatarsView.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      paramNetSearchTemplateAvatarsView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      break;
      label351:
      ((SquareImageView)localObject1).setFilterColor(-1);
      ((SquareImageView)localObject1).setFilterText("");
    }
    label368:
    while (j < paramNetSearchTemplateAvatarsView.jdField_a_of_type_Int)
    {
      paramNetSearchTemplateAvatarsView.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j).setVisibility(4);
      j += 1;
    }
  }
  
  private void a(NetSearchTemplateBannerTitleItem paramNetSearchTemplateBannerTitleItem, NetSearchTemplateBannerTitleView paramNetSearchTemplateBannerTitleView)
  {
    Object localObject = paramNetSearchTemplateBannerTitleView.a().getContext();
    int i;
    if (!TextUtils.isEmpty(paramNetSearchTemplateBannerTitleItem.i))
    {
      paramNetSearchTemplateBannerTitleView.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      a((Context)localObject, (SquareImageView)paramNetSearchTemplateBannerTitleView.jdField_a_of_type_AndroidWidgetImageView, paramNetSearchTemplateBannerTitleView.jdField_b_of_type_AndroidWidgetImageView, paramNetSearchTemplateBannerTitleView.jdField_b_of_type_AndroidWidgetTextView, paramNetSearchTemplateBannerTitleItem.jdField_a_of_type_Int, paramNetSearchTemplateBannerTitleItem.i, paramNetSearchTemplateBannerTitleItem.jdField_b_of_type_JavaLangString, ((Context)localObject).getResources().getDimensionPixelSize(2131559135));
      i = ((Context)localObject).getResources().getDimensionPixelSize(2131559135);
      if ((paramNetSearchTemplateBannerTitleItem.jdField_a_of_type_Int == 6) || (paramNetSearchTemplateBannerTitleItem.jdField_a_of_type_Int == 8)) {
        i = DisplayUtil.a((Context)localObject, 100.0F);
      }
      if (paramNetSearchTemplateBannerTitleView.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 8) {
        break label285;
      }
      i = 0;
    }
    for (;;)
    {
      float f = ((Context)localObject).getResources().getDisplayMetrics().widthPixels - DisplayUtil.a((Context)localObject, 30.0F);
      CharSequence localCharSequence = SearchUtils.a(paramNetSearchTemplateBannerTitleView.jdField_a_of_type_AndroidWidgetTextView, f, 2, paramNetSearchTemplateBannerTitleItem.jdField_a_of_type_JavaLangCharSequence.toString(), paramNetSearchTemplateBannerTitleItem.a(paramNetSearchTemplateBannerTitleItem.jdField_a_of_type_JavaLangCharSequence), false);
      paramNetSearchTemplateBannerTitleView.jdField_a_of_type_AndroidWidgetTextView.setText(localCharSequence);
      paramNetSearchTemplateBannerTitleView.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(null);
      f = ((Context)localObject).getResources().getDisplayMetrics().widthPixels - DisplayUtil.a((Context)localObject, 30.0F) - i;
      localObject = SearchUtils.a(paramNetSearchTemplateBannerTitleView.jdField_c_of_type_AndroidWidgetTextView, f, 2, paramNetSearchTemplateBannerTitleItem.jdField_b_of_type_JavaLangCharSequence.toString(), paramNetSearchTemplateBannerTitleItem.a(paramNetSearchTemplateBannerTitleItem.jdField_b_of_type_JavaLangCharSequence), false);
      a(paramNetSearchTemplateBannerTitleView.jdField_c_of_type_AndroidWidgetTextView, (CharSequence)localObject, false);
      a(paramNetSearchTemplateBannerTitleView.d, paramNetSearchTemplateBannerTitleItem.jdField_c_of_type_JavaLangCharSequence);
      return;
      paramNetSearchTemplateBannerTitleView.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      break;
      label285:
      i += DisplayUtil.a((Context)localObject, 10.0F);
    }
  }
  
  private void a(NetSearchTemplateMovieItem paramNetSearchTemplateMovieItem, NetSearchTemplateMovieView paramNetSearchTemplateMovieView)
  {
    Object localObject1 = paramNetSearchTemplateMovieView.a().getContext();
    Object localObject2 = (RelativeLayout.LayoutParams)paramNetSearchTemplateMovieView.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    float f1;
    label191:
    float f2;
    if (!TextUtils.isEmpty(paramNetSearchTemplateMovieItem.i))
    {
      paramNetSearchTemplateMovieView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramNetSearchTemplateMovieView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = DisplayUtil.a((Context)localObject1, 10.0F);
      a((Context)localObject1, (SquareImageView)paramNetSearchTemplateMovieView.jdField_a_of_type_AndroidWidgetImageView, paramNetSearchTemplateMovieView.jdField_b_of_type_AndroidWidgetImageView, paramNetSearchTemplateMovieView.jdField_a_of_type_AndroidWidgetTextView, paramNetSearchTemplateMovieItem.jdField_a_of_type_Int, paramNetSearchTemplateMovieItem.i, null, ((Context)localObject1).getResources().getDimensionPixelSize(2131559136));
      paramNetSearchTemplateMovieView.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().height = ((int)(((Context)localObject1).getResources().getDimensionPixelSize(2131559136) * 1.4F));
      f1 = 0.0F;
      if (TextUtils.isEmpty(paramNetSearchTemplateMovieItem.jdField_b_of_type_JavaLangCharSequence)) {
        break label532;
      }
      paramNetSearchTemplateMovieView.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      f1 = SearchUtils.a(paramNetSearchTemplateMovieView.jdField_c_of_type_AndroidWidgetTextView, paramNetSearchTemplateMovieItem.jdField_b_of_type_JavaLangCharSequence.toString()) + DisplayUtil.a((Context)localObject1, 10.0F);
      paramNetSearchTemplateMovieView.jdField_c_of_type_AndroidWidgetTextView.setText(paramNetSearchTemplateMovieItem.jdField_b_of_type_JavaLangCharSequence.toString());
      f2 = 0.0F;
      if (paramNetSearchTemplateMovieView.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 8) {
        f2 = DisplayUtil.a((Context)localObject1, 32.0F);
      }
      if (paramNetSearchTemplateMovieView.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 8) {
        break label544;
      }
    }
    label532:
    label544:
    for (int i = ((Context)localObject1).getResources().getDimensionPixelSize(2131559136) + DisplayUtil.a((Context)localObject1, 10.0F);; i = 0)
    {
      float f3 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - DisplayUtil.a((Context)localObject1, 30.0F) - i;
      localObject2 = SearchUtils.a(paramNetSearchTemplateMovieView.jdField_b_of_type_AndroidWidgetTextView, f3 - f1 - f2, 1, paramNetSearchTemplateMovieItem.jdField_a_of_type_JavaLangCharSequence.toString(), paramNetSearchTemplateMovieItem.a(paramNetSearchTemplateMovieItem.jdField_a_of_type_JavaLangCharSequence), false);
      paramNetSearchTemplateMovieView.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      paramNetSearchTemplateMovieView.jdField_b_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
      f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - DisplayUtil.a((Context)localObject1, 30.0F) - i;
      localObject2 = SearchUtils.a(paramNetSearchTemplateMovieView.d, f1, 1, paramNetSearchTemplateMovieItem.jdField_c_of_type_JavaLangCharSequence.toString(), paramNetSearchTemplateMovieItem.a(paramNetSearchTemplateMovieItem.jdField_c_of_type_JavaLangCharSequence), false);
      a(paramNetSearchTemplateMovieView.d, (CharSequence)localObject2, true);
      f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - DisplayUtil.a((Context)localObject1, 30.0F) - i;
      localObject1 = SearchUtils.a(paramNetSearchTemplateMovieView.g, f1, 2, paramNetSearchTemplateMovieItem.d.toString(), paramNetSearchTemplateMovieItem.a(paramNetSearchTemplateMovieItem.d), false);
      a(paramNetSearchTemplateMovieView.g, (CharSequence)localObject1, true);
      a(paramNetSearchTemplateMovieView.h, paramNetSearchTemplateMovieItem.e);
      paramNetSearchTemplateMovieView.jdField_a_of_type_AndroidWidgetButton.setText(paramNetSearchTemplateMovieItem.f);
      paramNetSearchTemplateMovieView.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new ahup(this, paramNetSearchTemplateMovieItem));
      return;
      paramNetSearchTemplateMovieView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramNetSearchTemplateMovieView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = DisplayUtil.a((Context)localObject1, 0.0F);
      break;
      paramNetSearchTemplateMovieView.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      break label191;
    }
  }
  
  private void a(NetSearchTemplateNormalItem paramNetSearchTemplateNormalItem, NetSearchTemplateNormalView paramNetSearchTemplateNormalView)
  {
    Context localContext = paramNetSearchTemplateNormalView.a().getContext();
    Object localObject = (LinearLayout.LayoutParams)paramNetSearchTemplateNormalView.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams;
    label200:
    int j;
    label213:
    int n;
    label299:
    int i;
    label490:
    float f;
    if (TextUtils.isEmpty(paramNetSearchTemplateNormalItem.i))
    {
      paramNetSearchTemplateNormalView.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      ((LinearLayout.LayoutParams)localObject).leftMargin = localContext.getResources().getDimensionPixelSize(2131559140);
      if ((localContext instanceof PublicAcntSearchActivity))
      {
        ((LinearLayout.LayoutParams)localObject).topMargin = localContext.getResources().getDimensionPixelSize(2131559139);
        ((LinearLayout.LayoutParams)localObject).bottomMargin = localContext.getResources().getDimensionPixelSize(2131559139);
      }
      a(localContext, paramNetSearchTemplateNormalView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView, paramNetSearchTemplateNormalView.jdField_a_of_type_AndroidWidgetImageView, paramNetSearchTemplateNormalView.jdField_a_of_type_AndroidWidgetTextView, paramNetSearchTemplateNormalItem.jdField_a_of_type_Int, paramNetSearchTemplateNormalItem.i, paramNetSearchTemplateNormalItem.l, localContext.getResources().getDimensionPixelSize(2131559135));
      localObject = (LinearLayout.LayoutParams)paramNetSearchTemplateNormalView.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      localLayoutParams = (LinearLayout.LayoutParams)paramNetSearchTemplateNormalView.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      if ((paramNetSearchTemplateNormalItem.jdField_a_of_type_Int != 6) && (paramNetSearchTemplateNormalItem.jdField_a_of_type_Int != 8) && (!paramNetSearchTemplateNormalItem.jdField_b_of_type_Boolean)) {
        break label781;
      }
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      localLayoutParams.gravity = 16;
      if (TextUtils.isEmpty(paramNetSearchTemplateNormalItem.jdField_a_of_type_JavaLangString)) {
        break label831;
      }
      j = 1;
      if (j == 0) {
        break label837;
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      localObject = URLDrawable.getDrawable(paramNetSearchTemplateNormalItem.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      paramNetSearchTemplateNormalView.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      paramNetSearchTemplateNormalView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      paramNetSearchTemplateNormalView.jdField_b_of_type_AndroidWidgetTextView.setSingleLine(true);
      n = a(paramNetSearchTemplateNormalView.jdField_b_of_type_AndroidWidgetTextView, paramNetSearchTemplateNormalView.jdField_c_of_type_AndroidWidgetTextView, paramNetSearchTemplateNormalItem.jdField_a_of_type_JavaLangCharSequence);
      int k = localContext.getResources().getDimensionPixelSize(2131559135);
      if ((paramNetSearchTemplateNormalItem.jdField_a_of_type_Int == 6) || (paramNetSearchTemplateNormalItem.jdField_a_of_type_Int == 7) || (paramNetSearchTemplateNormalItem.jdField_a_of_type_Int == 8)) {
        k = DisplayUtil.a(localContext, 100.0F);
      }
      int m = localContext.getResources().getDisplayMetrics().widthPixels;
      i = m;
      if (j != 0) {
        i = m - DisplayUtil.a(localContext, 26.0F);
      }
      m = i;
      if (paramNetSearchTemplateNormalView.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 8) {
        m = i - (DisplayUtil.a(localContext, 10.0F) + k);
      }
      i = m - DisplayUtil.a(localContext, 39.0F);
      paramNetSearchTemplateNormalView.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth(i);
      if (j == 0) {
        break label865;
      }
      localObject = SearchUtils.a(paramNetSearchTemplateNormalView.jdField_b_of_type_AndroidWidgetTextView, i, paramNetSearchTemplateNormalItem.jdField_a_of_type_JavaLangCharSequence.toString(), paramNetSearchTemplateNormalItem.a(paramNetSearchTemplateNormalItem.jdField_a_of_type_JavaLangCharSequence), false);
      paramNetSearchTemplateNormalView.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      paramNetSearchTemplateNormalView.jdField_b_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
      f = localContext.getResources().getDisplayMetrics().widthPixels - DisplayUtil.a(localContext, 39.0F);
      if (j == 0) {
        break label973;
      }
      f -= k + DisplayUtil.a(localContext, 10.0F);
    }
    label781:
    label831:
    label837:
    label973:
    for (;;)
    {
      i = 3 - n;
      if (paramNetSearchTemplateNormalItem.jdField_a_of_type_Int == 7) {
        i = 1;
      }
      if ((localContext instanceof PublicAcntSearchActivity)) {
        i = 1;
      }
      for (;;)
      {
        localObject = SearchUtils.a(paramNetSearchTemplateNormalView.jdField_c_of_type_AndroidWidgetTextView, f, i, paramNetSearchTemplateNormalItem.jdField_b_of_type_JavaLangCharSequence.toString(), paramNetSearchTemplateNormalItem.a(paramNetSearchTemplateNormalItem.jdField_b_of_type_JavaLangCharSequence), false);
        paramNetSearchTemplateNormalView.jdField_c_of_type_AndroidWidgetTextView.setMaxLines(i);
        a(paramNetSearchTemplateNormalView.jdField_c_of_type_AndroidWidgetTextView, (CharSequence)localObject, true);
        a(paramNetSearchTemplateNormalView.d, paramNetSearchTemplateNormalItem.jdField_c_of_type_JavaLangCharSequence);
        if (!TextUtils.isEmpty(paramNetSearchTemplateNormalItem.jdField_c_of_type_JavaLangCharSequence)) {
          ((View)paramNetSearchTemplateNormalView.d.getParent()).setVisibility(0);
        }
        if (TextUtils.isEmpty(paramNetSearchTemplateNormalItem.jdField_c_of_type_JavaLangCharSequence))
        {
          paramNetSearchTemplateNormalView.i.setVisibility(8);
          ((RelativeLayout)paramNetSearchTemplateNormalView.i.getParent()).setVisibility(8);
          a(paramNetSearchTemplateNormalView.jdField_c_of_type_AndroidWidgetTextView, paramNetSearchTemplateNormalItem.jdField_b_of_type_JavaLangCharSequence, paramNetSearchTemplateNormalView.g, paramNetSearchTemplateNormalItem.d, paramNetSearchTemplateNormalView.h);
          if ((TextUtils.isEmpty(paramNetSearchTemplateNormalItem.jdField_b_of_type_JavaLangCharSequence)) && (TextUtils.isEmpty(paramNetSearchTemplateNormalItem.d)))
          {
            paramNetSearchTemplateNormalView.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            return;
            paramNetSearchTemplateNormalView.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            ((LinearLayout.LayoutParams)localObject).leftMargin = localContext.getResources().getDimensionPixelSize(2131559141);
            break;
            if (((localContext instanceof PublicAcntSearchActivity)) && (paramNetSearchTemplateNormalItem.jdField_a_of_type_Int == 5))
            {
              ((LinearLayout.LayoutParams)localObject).gravity = 16;
              localLayoutParams.gravity = 16;
              break label200;
            }
            ((LinearLayout.LayoutParams)localObject).gravity = 48;
            localLayoutParams.gravity = 48;
            break label200;
            j = 0;
            break label213;
            paramNetSearchTemplateNormalView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            paramNetSearchTemplateNormalView.jdField_b_of_type_AndroidWidgetTextView.setSingleLine(false);
            paramNetSearchTemplateNormalView.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(2);
            break label299;
            label865:
            localObject = SearchUtils.a(paramNetSearchTemplateNormalView.jdField_b_of_type_AndroidWidgetTextView, i, 2, paramNetSearchTemplateNormalItem.jdField_a_of_type_JavaLangCharSequence.toString(), paramNetSearchTemplateNormalItem.a(paramNetSearchTemplateNormalItem.jdField_a_of_type_JavaLangCharSequence), false);
            break label490;
          }
          paramNetSearchTemplateNormalView.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          return;
        }
        paramNetSearchTemplateNormalView.g.setVisibility(8);
        a(paramNetSearchTemplateNormalView.d, paramNetSearchTemplateNormalItem.jdField_c_of_type_JavaLangCharSequence, paramNetSearchTemplateNormalView.h, paramNetSearchTemplateNormalItem.d, paramNetSearchTemplateNormalView.i);
        if (TextUtils.isEmpty(paramNetSearchTemplateNormalItem.jdField_b_of_type_JavaLangCharSequence))
        {
          paramNetSearchTemplateNormalView.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          return;
        }
        paramNetSearchTemplateNormalView.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        return;
      }
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
        paramNetSearchTemplateSubItemView.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new ahuq(this, paramNetSearchTemplateSubItem, paramNetSearchTemplateSubItemView));
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
    if ((!TextUtils.isEmpty(paramNetSearchTemplateSubItemTitle.e)) && (paramNetSearchTemplateSubItemTitleView.jdField_a_of_type_AndroidWidgetImageView != null))
    {
      paramNetSearchTemplateSubItemTitleView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      i = j - DisplayUtil.a(localContext, 10.0F);
    }
    for (;;)
    {
      paramNetSearchTemplateSubItemTitle = SearchUtils.a(paramNetSearchTemplateSubItemTitleView.jdField_a_of_type_AndroidWidgetTextView, i, paramNetSearchTemplateSubItemTitle.jdField_a_of_type_JavaLangString);
      paramNetSearchTemplateSubItemTitleView.jdField_a_of_type_AndroidWidgetTextView.setText(paramNetSearchTemplateSubItemTitle);
      return;
      i = j;
      if (paramNetSearchTemplateSubItemTitleView.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        paramNetSearchTemplateSubItemTitleView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
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
      localObject2 = (LinearLayout)((View)localObject2).findViewById(2131366336);
      localObject3 = new ArrayList();
      i = 0;
      while (i < ((LinearLayout)localObject2).getChildCount())
      {
        localObject4 = ((LinearLayout)localObject2).getChildAt(i).findViewById(2131366380);
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
    if (!TextUtils.isEmpty(paramNetSearchTemplateUpdatesItem.i)) {
      a((Context)localObject1, (SquareImageView)paramNetSearchTemplateUpdatesView.a(), paramNetSearchTemplateUpdatesView.jdField_b_of_type_AndroidWidgetImageView, paramNetSearchTemplateUpdatesView.jdField_a_of_type_AndroidWidgetTextView, paramNetSearchTemplateUpdatesItem.jdField_a_of_type_Int, paramNetSearchTemplateUpdatesItem.i, null, DisplayUtil.a((Context)localObject1, 21.0F));
    }
    label657:
    int j;
    if (!TextUtils.isEmpty(paramNetSearchTemplateUpdatesItem.jdField_a_of_type_JavaLangString))
    {
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      localObject2 = URLDrawable.getDrawable(paramNetSearchTemplateUpdatesItem.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
      paramNetSearchTemplateUpdatesView.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      paramNetSearchTemplateUpdatesView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      i = ((Context)localObject1).getResources().getDimensionPixelSize(2131559135);
      if ((paramNetSearchTemplateUpdatesItem.jdField_a_of_type_Int == 6) || (paramNetSearchTemplateUpdatesItem.jdField_a_of_type_Int == 8)) {
        i = DisplayUtil.a((Context)localObject1, 100.0F);
      }
      localObject2 = SearchUtils.a(paramNetSearchTemplateUpdatesView.e(), 10.0F * SearchUtils.a(paramNetSearchTemplateUpdatesView.e(), "测"), 1, paramNetSearchTemplateUpdatesItem.jdField_a_of_type_JavaLangCharSequence.toString(), paramNetSearchTemplateUpdatesItem.a(paramNetSearchTemplateUpdatesItem.jdField_a_of_type_JavaLangCharSequence), false);
      paramNetSearchTemplateUpdatesView.e().setText((CharSequence)localObject2);
      paramNetSearchTemplateUpdatesView.e().setEllipsize(null);
      float f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - DisplayUtil.a((Context)localObject1, 40.0F) - i;
      localObject2 = SearchUtils.a(paramNetSearchTemplateUpdatesView.f(), f1, 2, paramNetSearchTemplateUpdatesItem.jdField_b_of_type_JavaLangCharSequence.toString(), paramNetSearchTemplateUpdatesItem.a(paramNetSearchTemplateUpdatesItem.jdField_b_of_type_JavaLangCharSequence), false);
      a(paramNetSearchTemplateUpdatesView.f(), (CharSequence)localObject2, false);
      if (TextUtils.isEmpty(paramNetSearchTemplateUpdatesItem.jdField_c_of_type_JavaLangCharSequence)) {
        break label950;
      }
      f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - DisplayUtil.a((Context)localObject1, 30.0F);
      localObject1 = SearchUtils.a(paramNetSearchTemplateUpdatesView.g(), f1, 2, paramNetSearchTemplateUpdatesItem.jdField_c_of_type_JavaLangCharSequence.toString(), paramNetSearchTemplateUpdatesItem.a(paramNetSearchTemplateUpdatesItem.jdField_c_of_type_JavaLangCharSequence), false);
      paramNetSearchTemplateUpdatesView.g().setText((CharSequence)localObject1);
      paramNetSearchTemplateUpdatesView.g().setVisibility(0);
      if (paramNetSearchTemplateUpdatesItem.jdField_a_of_type_JavaUtilList == null) {
        break label1364;
      }
      if (paramNetSearchTemplateUpdatesItem.jdField_a_of_type_JavaUtilList.size() != 1) {
        break label972;
      }
      paramNetSearchTemplateUpdatesView.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      paramNetSearchTemplateUpdatesView.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localObject2 = paramNetSearchTemplateUpdatesView.a().getResources();
      if (jdField_a_of_type_Int == 0) {
        jdField_a_of_type_Int = ((Resources)localObject2).getDisplayMetrics().widthPixels;
      }
      localObject1 = paramNetSearchTemplateUpdatesView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
      ((SquareImageView)localObject1).setImageScale((float)(1.0D / paramNetSearchTemplateUpdatesItem.jdField_a_of_type_Double), 0.0F);
      f1 = ((Resources)localObject2).getDimension(2131559142);
      float f2 = ((Resources)localObject2).getDimension(2131559142);
      i = DisplayUtil.a(paramNetSearchTemplateUpdatesView.a().getContext(), 2.0F);
      j = paramNetSearchTemplateUpdatesView.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      i = (int)(jdField_a_of_type_Int - f1 - f2 - (j - 1) * i) / j;
      ((SquareImageView)localObject1).setLayoutParams(new FrameLayout.LayoutParams((int)(i * paramNetSearchTemplateUpdatesItem.jdField_b_of_type_Double), (int)(i * paramNetSearchTemplateUpdatesItem.jdField_b_of_type_Double)));
      paramNetSearchTemplateUpdatesItem = (ImageItem)paramNetSearchTemplateUpdatesItem.jdField_a_of_type_JavaUtilList.get(0);
      localObject2 = paramNetSearchTemplateUpdatesItem.jdField_a_of_type_JavaLangString;
      localObject3 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = true;
      localObject2 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject3);
      ((SquareImageView)localObject1).setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      if (paramNetSearchTemplateUpdatesItem.jdField_a_of_type_Int != 2) {
        break label962;
      }
      paramNetSearchTemplateUpdatesView.d.setVisibility(0);
    }
    for (;;)
    {
      return;
      paramNetSearchTemplateUpdatesView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      label950:
      paramNetSearchTemplateUpdatesView.g().setVisibility(8);
      break label657;
      label962:
      paramNetSearchTemplateUpdatesView.d.setVisibility(8);
      return;
      label972:
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
          localObject2 = paramNetSearchTemplateUpdatesView.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
          ((View)localObject2).setVisibility(0);
          localObject1 = (SquareImageView)((View)localObject2).findViewById(2131366380);
          localObject2 = (ImageView)((View)localObject2).findViewById(2131366342);
          ((SquareImageView)localObject1).setImageScale((float)(1.0D / paramNetSearchTemplateUpdatesItem.jdField_a_of_type_Double), 0.0F);
          localObject3 = (ImageItem)paramNetSearchTemplateUpdatesItem.jdField_a_of_type_JavaUtilList.get(i);
          localObject4 = ((ImageItem)localObject3).jdField_a_of_type_JavaLangString;
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          localURLDrawableOptions.mPlayGifImage = true;
          localObject4 = URLDrawable.getDrawable((String)localObject4, localURLDrawableOptions);
          ((SquareImageView)localObject1).setImageDrawable((Drawable)localObject4);
          if ((((URLDrawable)localObject4).getStatus() != 1) && (((URLDrawable)localObject4).getStatus() != 0)) {
            ((URLDrawable)localObject4).restartDownload();
          }
          ((SquareImageView)localObject1).setVisibility(0);
          if (((ImageItem)localObject3).jdField_a_of_type_Int == 2)
          {
            ((ImageView)localObject2).setVisibility(0);
            label1197:
            if ((i != m - 1) || (paramNetSearchTemplateUpdatesItem.d <= m)) {
              break label1318;
            }
            ((ImageView)localObject2).setVisibility(8);
            ((SquareImageView)localObject1).setFilterColor(Color.parseColor("#66000000"));
            int k = paramNetSearchTemplateUpdatesItem.d - m;
            j = k;
            if (k > 99) {
              j = 99;
            }
            ((SquareImageView)localObject1).setFilterText("+" + j);
            ((SquareImageView)localObject1).setFilterTextSize(DisplayUtil.a(((SquareImageView)localObject1).getContext(), 20.0F));
          }
          for (;;)
          {
            i += 1;
            break;
            ((ImageView)localObject2).setVisibility(8);
            break label1197;
            label1318:
            ((SquareImageView)localObject1).setFilterColor(-1);
            ((SquareImageView)localObject1).setFilterText("");
          }
        }
      }
      while (j < m)
      {
        paramNetSearchTemplateUpdatesView.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j).setVisibility(4);
        j += 1;
      }
    }
    label1364:
    paramNetSearchTemplateUpdatesView.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    paramNetSearchTemplateUpdatesView.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void a(SquareImageView paramSquareImageView, String paramString)
  {
    if ((paramSquareImageView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
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
      paramNetSearchTemplateUniversalView.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new ahut(this, localContext, paramNetSearchTemplateUniversalItem));
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
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, paramInt2, false, paramString1, null, 2130840367, false);
      return;
    case 4: 
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, paramInt2, false, paramString1, null, 2130840367, false);
      return;
    case 5: 
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, paramInt2, false, paramString1, null, 0, true);
      return;
    case 6: 
      paramInt1 = DisplayUtil.a(paramContext, 62.0F);
      a(paramSquareImageView, paramImageView, paramTextView, DisplayUtil.a(paramContext, 100.0F), paramInt1, false, paramString1, null, 2130840367, false);
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
      localAnimation = AnimationUtils.loadAnimation(paramImageView.getContext(), 2131034287);
    } while (localAnimation == null);
    localAnimation.setInterpolator(new LinearInterpolator());
    paramImageView.startAnimation(localAnimation);
  }
  
  public void a(TextView paramTextView, CharSequence paramCharSequence)
  {
    a(paramTextView, paramCharSequence, true);
  }
  
  public void a(TextView paramTextView1, CharSequence paramCharSequence1, TextView paramTextView2, CharSequence paramCharSequence2, TextView paramTextView3)
  {
    if (TextUtils.isEmpty(paramCharSequence2))
    {
      paramTextView2.setVisibility(8);
      paramTextView3.setVisibility(8);
      ((RelativeLayout)paramTextView3.getParent()).setVisibility(8);
      return;
    }
    Paint localPaint = new Paint();
    localPaint.setTextSize(paramTextView2.getTextSize());
    paramTextView1 = paramTextView1.getResources();
    int i = paramTextView1.getDisplayMetrics().widthPixels;
    if (TextUtils.isEmpty(paramCharSequence1)) {}
    for (float f1 = 0.0F;; f1 = localPaint.measureText(paramCharSequence1, 0, paramCharSequence1.length()))
    {
      float f2 = localPaint.measureText(paramCharSequence2, 0, paramCharSequence2.length());
      if (i - AIOUtils.a(86.0F, paramTextView1) - f1 <= f2) {
        break;
      }
      a(paramTextView2, paramCharSequence2);
      paramTextView3.setVisibility(8);
      ((RelativeLayout)paramTextView3.getParent()).setVisibility(8);
      return;
    }
    a(paramTextView3, paramCharSequence2);
    ((RelativeLayout)paramTextView3.getParent()).setVisibility(0);
    paramTextView2.setVisibility(8);
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
    SearchViewUtils.a(paramNetSearchTemplateBaseItem.c(), paramNetSearchTemplateBaseItem.d(), paramNetSearchTemplateBaseView.a(), paramNetSearchTemplateBaseItem.jdField_a_of_type_Boolean, paramNetSearchTemplateBaseItem.c);
    switch (paramNetSearchTemplateBaseItem.b())
    {
    }
    for (;;)
    {
      b(paramNetSearchTemplateBaseItem, paramNetSearchTemplateBaseView);
      if (TextUtils.isEmpty(paramNetSearchTemplateBaseItem.i)) {
        c(paramNetSearchTemplateBaseItem, paramNetSearchTemplateBaseView);
      }
      return;
      a((NetSearchTemplateNormalItem)paramNetSearchTemplateBaseItem, (NetSearchTemplateNormalView)paramNetSearchTemplateBaseView);
      continue;
      a((NetSearchTemplateAvatarsItem)paramNetSearchTemplateBaseItem, (NetSearchTemplateAvatarsView)paramNetSearchTemplateBaseView);
      continue;
      a((NetSearchTemplateUpdatesItem)paramNetSearchTemplateBaseItem, (NetSearchTemplateUpdatesView)paramNetSearchTemplateBaseView);
      continue;
      a((NetSearchTemplateBannerTitleItem)paramNetSearchTemplateBaseItem, (NetSearchTemplateBannerTitleView)paramNetSearchTemplateBaseView);
      continue;
      a((NetSearchTemplateMovieItem)paramNetSearchTemplateBaseItem, (NetSearchTemplateMovieView)paramNetSearchTemplateBaseView);
      continue;
      a((NetSearchTemplateHorizontalContainerItem)paramNetSearchTemplateBaseItem, (NetSearchTemplateHorizontalContainerView)paramNetSearchTemplateBaseView);
      continue;
      a((NetSearchTemplateUniversalItem)paramNetSearchTemplateBaseItem, (NetSearchTemplateUniversalView)paramNetSearchTemplateBaseView);
      continue;
      a((NetSearchTemplateSubItem)paramNetSearchTemplateBaseItem, (NetSearchTemplateSubItemView)paramNetSearchTemplateBaseView);
      continue;
      a((NetSearchTemplateSubItemTitle)paramNetSearchTemplateBaseItem, (NetSearchTemplateSubItemTitleView)paramNetSearchTemplateBaseView);
    }
  }
  
  public void a(NetSearchTemplateBaseItem paramNetSearchTemplateBaseItem, NetSearchTemplateBaseView paramNetSearchTemplateBaseView, Bitmap paramBitmap)
  {
    if (paramNetSearchTemplateBaseView.a() != null) {
      paramNetSearchTemplateBaseView.a().setImageBitmap(paramBitmap);
    }
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
      paramNetSearchTemplateBaseView.a().setOnClickListener(new ahuo(this, paramNetSearchTemplateBaseItem));
    }
  }
  
  public void c(NetSearchTemplateBaseItem paramNetSearchTemplateBaseItem, NetSearchTemplateBaseView paramNetSearchTemplateBaseView)
  {
    if ((paramNetSearchTemplateBaseView.a() != null) && ((paramNetSearchTemplateBaseItem instanceof IFaceModel)) && (!TextUtils.isEmpty(paramNetSearchTemplateBaseItem.a()))) {
      paramNetSearchTemplateBaseView.a().setImageDrawable(SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, paramNetSearchTemplateBaseItem));
    }
  }
  
  public String getToken()
  {
    return QQPlayerService.a(7, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).c());
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
      localImageView.post(new ahuu(this, bool, localImageView));
      return;
    }
    if (paramInt == 2)
    {
      localImageView.getContext();
      ((Integer)localImageView.getTag()).intValue();
      SearchUtils.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      localImageView.post(new ahuv(this, localImageView, bool));
      localImageView.setContentDescription(localResources.getString(2131437019));
      this.jdField_a_of_type_ComTencentMobileqqSearchAdapterGroupSearchAdapter.notifyDataSetChanged();
      return;
    }
    localImageView.post(new ahuw(this, localImageView, bool));
    localImageView.setContentDescription(localResources.getString(2131437018));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.SearchTemplatePresenter
 * JD-Core Version:    0.7.0.1
 */