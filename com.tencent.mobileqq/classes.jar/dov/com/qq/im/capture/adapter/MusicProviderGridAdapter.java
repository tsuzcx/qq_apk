package dov.com.qq.im.capture.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.music.QimMusicPlayer;
import dov.com.qq.im.capture.view.MusicProviderView;
import dov.com.qq.im.capture.view.QIMCommonLoadingProgress;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;
import java.util.List;

public class MusicProviderGridAdapter
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  MusicProviderView jdField_a_of_type_DovComQqImCaptureViewMusicProviderView;
  List<MusicItemInfo> jdField_a_of_type_JavaUtilList;
  int b;
  
  public MusicProviderGridAdapter(Context paramContext, MusicProviderView paramMusicProviderView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_DovComQqImCaptureViewMusicProviderView = paramMusicProviderView;
  }
  
  private void a(MusicProviderGridAdapter.ViewHolder paramViewHolder)
  {
    int j = 2130844706;
    MusicItemInfo localMusicItemInfo2 = paramViewHolder.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
    int k = localMusicItemInfo2.mType;
    MusicItemInfo localMusicItemInfo1 = ((QimMusicPlayer)QIMManager.a().c(8)).b();
    Object localObject = localMusicItemInfo1;
    if (localMusicItemInfo1 == null) {
      localObject = ((QIMMusicConfigManager)QIMManager.a(2)).a(-1, -1);
    }
    boolean bool = localMusicItemInfo2.equals((MusicItemInfo)localObject);
    if ((k == 1) || (k == 5))
    {
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      paramViewHolder.d.setVisibility(8);
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localMusicItemInfo2.mMusicName);
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(localMusicItemInfo2.mSingername);
      if ((bool) && (!localMusicItemInfo2.isDownloading()))
      {
        i = 2130844685;
        if (localMusicItemInfo2.isMyMusicInfo())
        {
          i = 2130844701;
          paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131707046));
          paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          paramViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(i);
          paramViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          label198:
          paramViewHolder.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setVisibility(0);
          localObject = QIMCommonLoadingProgress.a(localMusicItemInfo2);
          paramViewHolder.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.a((QIMCommonLoadingProgress)localObject);
          if ((!localMusicItemInfo2.isDownloading()) || (((QIMCommonLoadingProgress)localObject).a != 2)) {
            break label289;
          }
          paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
      for (;;)
      {
        a(paramViewHolder, localMusicItemInfo2);
        return;
        paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        break;
        paramViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        break label198;
        label289:
        if (!localMusicItemInfo2.isFileExist()) {
          paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        } else {
          paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
    }
    paramViewHolder.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.a(null);
    paramViewHolder.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setVisibility(8);
    paramViewHolder.d.setVisibility(8);
    paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    paramViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    localObject = HardCodeUtil.a(2131707052);
    int i = 2130844702;
    if (k == 3)
    {
      localObject = HardCodeUtil.a(2131707049);
      j = 2130844703;
      i = 2130844704;
    }
    for (;;)
    {
      if (bool) {
        paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(i);
      }
      for (;;)
      {
        paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        return;
        if (k == 4)
        {
          localObject = HardCodeUtil.a(2131707047);
          j = 2130844698;
          i = 2130844699;
          break;
        }
        if (k != 10) {
          break label503;
        }
        localObject = HardCodeUtil.a(2131707053);
        paramViewHolder.d.setVisibility(0);
        i = 2130844706;
        break;
        paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(j);
      }
      label503:
      j = 2130844705;
    }
  }
  
  public View a()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    Object localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    int i = ViewUtils.b(5.0F);
    ((RelativeLayout.LayoutParams)localObject2).setMargins(i, i, i, i);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject2).setId(2131372028);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131372029);
    ((TextView)localObject2).setPadding(((TextView)localObject2).getPaddingLeft(), ((TextView)localObject2).getPaddingTop(), ((TextView)localObject2).getPaddingRight(), ViewUtils.b(10.0F));
    ((TextView)localObject2).setMaxLines(4);
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject2).setTextColor(Color.parseColor("#ffffffff"));
    ((TextView)localObject2).setTextSize(2, 12.0F);
    ((TextView)localObject2).setShadowLayer(4.0F, 0.0F, 2.0F, Color.parseColor("#80000000"));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
    i = ViewUtils.b(5.0F);
    localLayoutParams.topMargin = ViewUtils.b(8.0F);
    localLayoutParams.leftMargin = i;
    localLayoutParams.rightMargin = i;
    localLayoutParams.addRule(10, -1);
    localLayoutParams.addRule(9, -1);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131372027);
    ((TextView)localObject2).setTextColor(Color.parseColor("#9fffffff"));
    ((TextView)localObject2).setTextSize(2, 9.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(9, -1);
    i = ViewUtils.b(5.0F);
    localLayoutParams.leftMargin = i;
    localLayoutParams.rightMargin = i;
    localLayoutParams.bottomMargin = ViewUtils.b(4.0F);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject2).setId(2131372030);
    ((ImageView)localObject2).setImageResource(2130844685);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131374461);
    ((TextView)localObject2).setTextSize(2, 12.0F);
    ((TextView)localObject2).setTextColor(Color.parseColor("#ffffffff"));
    ((TextView)localObject2).setVisibility(8);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.bottomMargin = ViewUtils.b(5.0F);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(14, -1);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject2 = new QIMCommonLoadingView(this.jdField_a_of_type_AndroidContentContext);
    ((QIMCommonLoadingView)localObject2).setId(2131372047);
    ((QIMCommonLoadingView)localObject2).setVisibility(8);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject1 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject1).setId(2131372021);
    ((ImageView)localObject1).setVisibility(8);
    ((ImageView)localObject1).setImageResource(2130846256);
    i = ViewUtils.b(18.0F);
    localObject2 = new RelativeLayout.LayoutParams(i, i);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject1).setId(2131382009);
    ((ImageView)localObject1).setImageResource(2130846263);
    ((ImageView)localObject1).setVisibility(8);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    return localRelativeLayout;
  }
  
  public void a(View paramView)
  {
    paramView = (MusicProviderGridAdapter.ViewHolder)paramView.getTag();
    if (paramView != null) {
      a(paramView);
    }
  }
  
  public void a(MusicProviderGridAdapter.ViewHolder paramViewHolder, MusicItemInfo paramMusicItemInfo)
  {
    if (TextUtils.isEmpty(paramMusicItemInfo.mAlbumUrl))
    {
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844700);
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    int i = AIOUtils.a(80.0F, paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.getResources());
    localURLDrawableOptions.mRequestWidth = i;
    localURLDrawableOptions.mRequestHeight = i;
    localURLDrawableOptions.mRetryCount = 3;
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844700);
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844700);
    paramMusicItemInfo = URLDrawable.getDrawable(paramMusicItemInfo.mAlbumUrl, localURLDrawableOptions);
    if (paramMusicItemInfo.getStatus() == 2) {
      paramMusicItemInfo.restartDownload();
    }
    paramMusicItemInfo.setDecodeHandler(URLDrawableDecodeHandler.w);
    paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramMusicItemInfo);
  }
  
  public void a(List<MusicItemInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_Int <= 0) && (paramViewGroup != null))
    {
      this.jdField_a_of_type_Int = paramViewGroup.getMeasuredWidth();
      this.b = ((int)((this.jdField_a_of_type_Int - MusicProviderPagerAdapter.b * 3 - paramViewGroup.getPaddingLeft() - paramViewGroup.getPaddingRight()) / 4 + 0.5F));
    }
    MusicItemInfo localMusicItemInfo = (MusicItemInfo)getItem(paramInt);
    MusicProviderGridAdapter.ViewHolder localViewHolder;
    if (paramView == null)
    {
      localViewHolder = new MusicProviderGridAdapter.ViewHolder(this);
      paramView = a();
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372029));
      localViewHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372027));
      localViewHolder.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView = ((QIMCommonLoadingView)paramView.findViewById(2131372047));
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372028));
      localViewHolder.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131374461));
      localViewHolder.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372030));
      localViewHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372021));
      localViewHolder.d = ((ImageView)paramView.findViewById(2131382009));
      paramView.setTag(localViewHolder);
    }
    for (;;)
    {
      localViewHolder.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setVisibility(0);
      localViewHolder.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = localMusicItemInfo;
      localViewHolder.jdField_a_of_type_Int = paramInt;
      AbsListView.LayoutParams localLayoutParams2 = (AbsListView.LayoutParams)paramView.getLayoutParams();
      AbsListView.LayoutParams localLayoutParams1 = localLayoutParams2;
      if (localLayoutParams2 == null)
      {
        localLayoutParams1 = new AbsListView.LayoutParams(-1, -1);
        paramView.setLayoutParams(localLayoutParams1);
      }
      localLayoutParams1.height = this.b;
      a(localViewHolder);
      if (localMusicItemInfo.isWsBanner()) {
        WeishiGuideUtils.a(localMusicItemInfo);
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localViewHolder = (MusicProviderGridAdapter.ViewHolder)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.adapter.MusicProviderGridAdapter
 * JD-Core Version:    0.7.0.1
 */