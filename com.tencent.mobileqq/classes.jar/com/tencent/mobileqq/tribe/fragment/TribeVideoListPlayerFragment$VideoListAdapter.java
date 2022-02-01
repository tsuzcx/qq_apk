package com.tencent.mobileqq.tribe.fragment;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.tribe.playvideo.TribeVideoADItem;
import com.tencent.mobileqq.tribe.playvideo.TribeVideoItem;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class TribeVideoListPlayerFragment$VideoListAdapter
  extends RecyclerView.Adapter<TribeVideoListPlayerFragment.BaseVideoViewHolder>
{
  protected TribeVideoListPlayerFragment$VideoListAdapter(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment) {}
  
  public TribeVideoListPlayerFragment.BaseVideoViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = null;
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramViewGroup.getContext());
    if (paramInt == 0)
    {
      localObject = localLayoutInflater.inflate(2131560710, paramViewGroup, false);
      ((View)localObject).setOnClickListener(new TribeVideoListPlayerFragment.VideoListAdapter.1(this));
      paramViewGroup = new TribeVideoListPlayerFragment.VideoViewHolder(this.a, (View)localObject);
      paramViewGroup.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131365123));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131374337));
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131374335));
      paramViewGroup.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131368345));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131381704));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131368349));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131365695));
      paramViewGroup.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)((View)localObject).findViewById(2131373572));
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131367356));
      paramViewGroup.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131367341));
      paramViewGroup.jdField_d_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131367368));
      paramViewGroup.g = ((ImageView)((View)localObject).findViewById(2131367365));
      paramViewGroup.h = ((ImageView)((View)localObject).findViewById(2131367367));
      paramViewGroup.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131367347));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131367346));
      paramViewGroup.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131367345));
      paramViewGroup.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131367348));
      paramViewGroup.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131367358));
      paramViewGroup.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131367351));
      paramViewGroup.jdField_e_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131367353));
      paramViewGroup.i = ((ImageView)((View)localObject).findViewById(2131367349));
      paramViewGroup.i.setImageResource(2130843830);
      paramViewGroup.j = ((ImageView)((View)localObject).findViewById(2131367352));
      paramViewGroup.jdField_e_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_c_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_d_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)((View)localObject).findViewById(2131379797));
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131361878));
      paramViewGroup.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131368341));
      paramViewGroup.k = ((ImageView)((View)localObject).findViewById(2131368340));
      paramViewGroup.l = ((ImageView)((View)localObject).findViewById(2131368338));
      paramViewGroup.m = ((ImageView)((View)localObject).findViewById(2131368343));
      paramViewGroup.jdField_f_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131368344));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(DisplayUtil.a(this.a.getActivity(), 10.0F));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(2);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(new TribeVideoListPlayerFragment.TribeListAdapter(this.a));
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setOnTouchListener(new TribeVideoListPlayerFragment.VideoListAdapter.2(this));
      ((View)localObject).setTag(paramViewGroup);
    }
    do
    {
      return paramViewGroup;
      if (paramInt == 1)
      {
        paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560709, paramViewGroup, false);
        paramViewGroup.setOnClickListener(new TribeVideoListPlayerFragment.VideoListAdapter.3(this));
        localObject = new TribeVideoListPlayerFragment.ADViewHolder(this.a, paramViewGroup);
        ((TribeVideoListPlayerFragment.ADViewHolder)localObject).jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131365123));
        ((TribeVideoListPlayerFragment.ADViewHolder)localObject).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131374337));
        ((TribeVideoListPlayerFragment.ADViewHolder)localObject).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131374335));
        ((TribeVideoListPlayerFragment.ADViewHolder)localObject).jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367807));
        ((TribeVideoListPlayerFragment.ADViewHolder)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131367818));
        ((TribeVideoListPlayerFragment.ADViewHolder)localObject).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131367819));
        ((TribeVideoListPlayerFragment.ADViewHolder)localObject).jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)paramViewGroup.findViewById(2131373572));
        ((TribeVideoListPlayerFragment.ADViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367763));
        ((TribeVideoListPlayerFragment.ADViewHolder)localObject).jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131362051);
        ((TribeVideoListPlayerFragment.ADViewHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131367804));
        ((TribeVideoListPlayerFragment.ADViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131362053));
        ((TribeVideoListPlayerFragment.ADViewHolder)localObject).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131362055));
        ((TribeVideoListPlayerFragment.ADViewHolder)localObject).jdField_d_of_type_AndroidWidgetImageView.setOnClickListener((View.OnClickListener)localObject);
        ((TribeVideoListPlayerFragment.ADViewHolder)localObject).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener((View.OnClickListener)localObject);
        ((TribeVideoListPlayerFragment.ADViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setOnClickListener((View.OnClickListener)localObject);
        ((TribeVideoListPlayerFragment.ADViewHolder)localObject).jdField_c_of_type_AndroidWidgetTextView.setOnClickListener((View.OnClickListener)localObject);
        ((TribeVideoListPlayerFragment.ADViewHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener((View.OnClickListener)localObject);
        ((TribeVideoListPlayerFragment.ADViewHolder)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener((View.OnClickListener)localObject);
        paramViewGroup.setTag(localObject);
        return localObject;
      }
      paramViewGroup = (ViewGroup)localObject;
    } while (paramInt != 2);
    paramViewGroup = this.a.jdField_b_of_type_AndroidWidgetRelativeLayout;
    localObject = new TribeVideoListPlayerFragment.FooterViewHolder(paramViewGroup);
    paramViewGroup.setTag(localObject);
    return localObject;
  }
  
  public void a(TribeVideoListPlayerFragment.BaseVideoViewHolder paramBaseVideoViewHolder, int paramInt)
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    label328:
    label356:
    int i;
    if (getItemViewType(paramInt) == 0)
    {
      localObject1 = (TribeVideoListPlayerFragment.VideoViewHolder)paramBaseVideoViewHolder;
      localObject2 = (TribeVideoItem)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      ((TribeVideoListPlayerFragment.VideoViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqTribePlayvideoTribeVideoItem = ((TribeVideoItem)localObject2);
      ((TribeVideoListPlayerFragment.VideoViewHolder)localObject1).jdField_a_of_type_Int = paramInt;
      this.a.j();
      if (!TextUtils.isEmpty(((TribeVideoItem)localObject2).jdField_b_of_type_JavaLangString))
      {
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        localObject4 = new ColorDrawable(0);
        ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject4);
        ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject4);
        ((TribeVideoListPlayerFragment.VideoViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(((TribeVideoItem)localObject2).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject3));
        if (((TribeVideoItem)localObject2).jdField_b_of_type_Int / ((TribeVideoItem)localObject2).jdField_a_of_type_Int > 0.75F)
        {
          ((TribeVideoListPlayerFragment.VideoViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
          ((TribeVideoListPlayerFragment.VideoViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          localObject3 = URLDrawable.URLDrawableOptions.obtain();
          localObject4 = new ColorDrawable(0);
          ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject4);
          ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject4);
          ((URLDrawable.URLDrawableOptions)localObject3).mMemoryCacheKeySuffix = "tribe_video_blur";
          localObject3 = URLDrawable.getDrawable(((TribeVideoItem)localObject2).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject3);
          ((URLDrawable)localObject3).setDecodeHandler(URLDrawableDecodeHandler.u);
          ((TribeVideoListPlayerFragment.VideoViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
          if (((TribeVideoItem)localObject2).jdField_a_of_type_AndroidTextSpannable == null) {
            ((TribeVideoItem)localObject2).jdField_a_of_type_AndroidTextSpannable = this.a.a((TribeVideoItem)localObject2);
          }
          ((TribeVideoListPlayerFragment.VideoViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView.setText(((TribeVideoItem)localObject2).jdField_a_of_type_AndroidTextSpannable);
          ((TribeVideoListPlayerFragment.VideoViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(((TribeVideoItem)localObject2).jdField_k_of_type_JavaLangString);
          if (TextUtils.isEmpty(((TribeVideoItem)localObject2).jdField_l_of_type_JavaLangString)) {
            break label569;
          }
          localObject3 = URLDrawable.URLDrawableOptions.obtain();
          localObject4 = ImageUtil.c();
          ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject4);
          ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject4);
          localObject3 = URLDrawable.getDrawable(((TribeVideoItem)localObject2).jdField_l_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject3);
          ((URLDrawable)localObject3).setDecodeHandler(URLDrawableDecodeHandler.a);
          ((TribeVideoListPlayerFragment.VideoViewHolder)localObject1).jdField_d_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
          if (!((TribeVideoItem)localObject2).d) {
            break label583;
          }
          ((TribeVideoListPlayerFragment.VideoViewHolder)localObject1).jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130843837);
          ((TribeVideoListPlayerFragment.VideoViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          if ((((TribeVideoItem)localObject2).jdField_c_of_type_Long != BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()) && (!((TribeVideoItem)localObject2).jdField_c_of_type_Boolean)) {
            break label607;
          }
          ((TribeVideoListPlayerFragment.VideoViewHolder)localObject1).jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          label392:
          ((TribeVideoListPlayerFragment.VideoViewHolder)localObject1).jdField_e_of_type_AndroidWidgetTextView.setText(this.a.a(((TribeVideoItem)localObject2).jdField_l_of_type_Int));
          ((TribeVideoListPlayerFragment.VideoViewHolder)localObject1).jdField_e_of_type_AndroidWidgetTextView.setMaxLines(1);
          localObject3 = ((TribeVideoListPlayerFragment.VideoViewHolder)localObject1).i;
          if (((TribeVideoItem)localObject2).jdField_k_of_type_Int == 0) {
            break label643;
          }
          i = 2130843831;
          label440:
          ((ImageView)localObject3).setImageResource(i);
          ((TribeVideoListPlayerFragment.VideoViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(this.a.b(((TribeVideoItem)localObject2).m));
          ((TribeVideoListPlayerFragment.VideoViewHolder)localObject1).jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
          ((TribeVideoListPlayerFragment.TribeListAdapter)((TribeVideoListPlayerFragment.VideoViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetHorizontalListView.getAdapter()).a(((TribeVideoItem)localObject2).jdField_a_of_type_JavaUtilArrayList, (TribeVideoItem)localObject2);
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramBaseVideoViewHolder, paramInt, getItemId(paramInt));
      return;
      ((TribeVideoListPlayerFragment.VideoViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      ((TribeVideoListPlayerFragment.VideoViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      ((TribeVideoListPlayerFragment.VideoViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(new ColorDrawable(0));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TribeVideoListPlayerFragment", 2, "video.videoThumbUrl is null");
      break;
      label569:
      ((TribeVideoListPlayerFragment.VideoViewHolder)localObject1).jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(ImageUtil.c());
      break label328;
      label583:
      ((TribeVideoListPlayerFragment.VideoViewHolder)localObject1).jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130843836);
      ((TribeVideoListPlayerFragment.VideoViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label356;
      label607:
      ((TribeVideoListPlayerFragment.VideoViewHolder)localObject1).jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      ((TribeVideoListPlayerFragment.VideoViewHolder)localObject1).l.clearAnimation();
      ((TribeVideoListPlayerFragment.VideoViewHolder)localObject1).k.clearAnimation();
      ((TribeVideoListPlayerFragment.VideoViewHolder)localObject1).jdField_f_of_type_AndroidWidgetTextView.clearAnimation();
      break label392;
      label643:
      i = 2130843830;
      break label440;
      if (getItemViewType(paramInt) == 1)
      {
        localObject1 = (TribeVideoADItem)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        localObject2 = (TribeVideoListPlayerFragment.ADViewHolder)paramBaseVideoViewHolder;
        this.a.j();
        ((TribeVideoListPlayerFragment.ADViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqTribePlayvideoTribeVideoADItem = ((TribeVideoADItem)localObject1);
        ((TribeVideoListPlayerFragment.ADViewHolder)localObject2).jdField_a_of_type_Int = paramInt;
        if (!TextUtils.isEmpty(((TribeVideoADItem)localObject1).jdField_b_of_type_JavaLangString))
        {
          localObject3 = URLDrawable.URLDrawableOptions.obtain();
          localObject4 = new ColorDrawable(0);
          ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject4);
          ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject4);
          ((TribeVideoListPlayerFragment.ADViewHolder)localObject2).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(((TribeVideoADItem)localObject1).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject3));
          if (((TribeVideoADItem)localObject1).jdField_a_of_type_Boolean)
          {
            ((TribeVideoListPlayerFragment.ADViewHolder)localObject2).jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ((TribeVideoListPlayerFragment.ADViewHolder)localObject2).jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
            localObject3 = URLDrawable.URLDrawableOptions.obtain();
            localObject4 = new ColorDrawable(0);
            ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject4);
            ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject4);
            ((URLDrawable.URLDrawableOptions)localObject3).mMemoryCacheKeySuffix = "tribe_video_blur";
            localObject3 = URLDrawable.getDrawable(((TribeVideoADItem)localObject1).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject3);
            ((URLDrawable)localObject3).setDecodeHandler(URLDrawableDecodeHandler.u);
            ((TribeVideoListPlayerFragment.ADViewHolder)localObject2).jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
            label853:
            ((TribeVideoListPlayerFragment.ADViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(((TribeVideoADItem)localObject1).d);
            if (TextUtils.isEmpty(((TribeVideoADItem)localObject1).e)) {
              break label1078;
            }
            localObject3 = URLDrawable.URLDrawableOptions.obtain();
            localObject4 = ImageUtil.c();
            ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject4);
            ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject4);
            localObject3 = URLDrawable.getDrawable(((TribeVideoADItem)localObject1).e, (URLDrawable.URLDrawableOptions)localObject3);
            ((URLDrawable)localObject3).setDecodeHandler(URLDrawableDecodeHandler.a);
            ((TribeVideoListPlayerFragment.ADViewHolder)localObject2).jdField_d_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
            label931:
            ((TribeVideoListPlayerFragment.ADViewHolder)localObject2).jdField_c_of_type_AndroidWidgetTextView.setText(((TribeVideoADItem)localObject1).f);
            ((TribeVideoListPlayerFragment.ADViewHolder)localObject2).jdField_a_of_type_AndroidViewView.clearAnimation();
            ((TribeVideoListPlayerFragment.ADViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
            if (((TribeVideoADItem)localObject1).jdField_a_of_type_Int != 12) {
              break label1103;
            }
            localObject2 = ((TribeVideoListPlayerFragment.ADViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView;
            if (!TribeVideoListPlayerFragment.a(this.a, this.a.getActivity(), ((TribeVideoADItem)localObject1).g)) {
              break label1092;
            }
          }
        }
        label1078:
        label1092:
        for (localObject1 = HardCodeUtil.a(2131714959);; localObject1 = HardCodeUtil.a(2131714970))
        {
          ((TextView)localObject2).setText((CharSequence)localObject1);
          break;
          ((TribeVideoListPlayerFragment.ADViewHolder)localObject2).jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
          ((TribeVideoListPlayerFragment.ADViewHolder)localObject2).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          break label853;
          ((TribeVideoListPlayerFragment.ADViewHolder)localObject2).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(new ColorDrawable(0));
          if (!QLog.isColorLevel()) {
            break label853;
          }
          QLog.d("TribeVideoListPlayerFragment", 2, "video.videoThumbUrl is null");
          break label853;
          ((TribeVideoListPlayerFragment.ADViewHolder)localObject2).jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(ImageUtil.c());
          break label931;
        }
        label1103:
        ((TribeVideoListPlayerFragment.ADViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131714958));
      }
      else if (getItemViewType(paramInt) == 2)
      {
        ((TribeVideoListPlayerFragment.FooterViewHolder)paramBaseVideoViewHolder).jdField_a_of_type_Int = (this.a.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$VideoListAdapter.getItemCount() - 1);
      }
    }
  }
  
  public int getItemCount()
  {
    return this.a.jdField_a_of_type_JavaUtilArrayList.size() + 1;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt < this.a.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if ((this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt) instanceof TribeVideoItem)) {
        return 0;
      }
      return 1;
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment.VideoListAdapter
 * JD-Core Version:    0.7.0.1
 */