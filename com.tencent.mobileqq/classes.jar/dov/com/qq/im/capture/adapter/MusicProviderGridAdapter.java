package dov.com.qq.im.capture.adapter;

import android.content.Context;
import android.graphics.Color;
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
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.utils.ViewUtils;
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
  List jdField_a_of_type_JavaUtilList;
  int b;
  
  public MusicProviderGridAdapter(Context paramContext, MusicProviderView paramMusicProviderView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_DovComQqImCaptureViewMusicProviderView = paramMusicProviderView;
  }
  
  private void a(MusicProviderGridAdapter.ViewHolder paramViewHolder)
  {
    int j = 2130841924;
    MusicItemInfo localMusicItemInfo2 = paramViewHolder.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
    int k = localMusicItemInfo2.d;
    int i = paramViewHolder.jdField_a_of_type_Int;
    MusicItemInfo localMusicItemInfo1 = ((QimMusicPlayer)QIMManager.a().c(8)).c();
    Object localObject = localMusicItemInfo1;
    if (localMusicItemInfo1 == null) {
      localObject = ((QIMMusicConfigManager)QIMManager.a(2)).a(-1, -1);
    }
    boolean bool = localMusicItemInfo2.a((MusicItemInfo)localObject);
    if ((k == 1) || (k == 5))
    {
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      paramViewHolder.d.setVisibility(8);
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localMusicItemInfo2.a);
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(localMusicItemInfo2.b);
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841919);
      if ((bool) && (!localMusicItemInfo2.a()))
      {
        i = 2130841881;
        if (localMusicItemInfo2.e())
        {
          i = 2130841920;
          paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText("编辑");
          paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          paramViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(i);
          paramViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        }
      }
      for (;;)
      {
        paramViewHolder.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setVisibility(0);
        localObject = QIMCommonLoadingProgress.a(localMusicItemInfo2);
        paramViewHolder.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.a((QIMCommonLoadingProgress)localObject);
        if ((!localMusicItemInfo2.a()) || (((QIMCommonLoadingProgress)localObject).a != 2)) {
          break label293;
        }
        paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        return;
        paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        break;
        paramViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      label293:
      if (!localMusicItemInfo2.f())
      {
        paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        return;
      }
      paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    paramViewHolder.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.a(null);
    paramViewHolder.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setVisibility(8);
    paramViewHolder.d.setVisibility(8);
    paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    paramViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    localObject = "视频原声";
    i = 2130841921;
    if (k == 3)
    {
      localObject = "静音";
      j = 2130841922;
      i = 2130841923;
      if (!bool) {
        break label511;
      }
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(i);
    }
    for (;;)
    {
      paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      return;
      if (k == 6)
      {
        localObject = "听歌识曲";
        break;
      }
      if (k == 8)
      {
        localObject = "背景音替换";
        break;
      }
      if (k == 4)
      {
        localObject = "自定义音乐";
        j = 2130841917;
        i = 2130841918;
        break;
      }
      if (k != 10) {
        break;
      }
      localObject = "歌词字幕";
      j = 2130841925;
      i = 2130841925;
      paramViewHolder.d.setVisibility(0);
      break;
      label511:
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(j);
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
    ((ImageView)localObject2).setId(2131362492);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131362491);
    ((TextView)localObject2).setPadding(((TextView)localObject2).getPaddingLeft(), ((TextView)localObject2).getPaddingTop(), ((TextView)localObject2).getPaddingRight(), ViewUtils.b(10.0F));
    ((TextView)localObject2).setMaxLines(4);
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject2).setTextColor(Color.parseColor("#ffffffff"));
    ((TextView)localObject2).setTextSize(2, 12.0F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
    i = ViewUtils.b(5.0F);
    localLayoutParams.topMargin = ViewUtils.b(8.0F);
    localLayoutParams.leftMargin = i;
    localLayoutParams.rightMargin = i;
    localLayoutParams.addRule(10, -1);
    localLayoutParams.addRule(9, -1);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131362490);
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
    ((ImageView)localObject2).setId(2131362489);
    ((ImageView)localObject2).setImageResource(2130841881);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131362512);
    ((TextView)localObject2).setTextSize(2, 12.0F);
    ((TextView)localObject2).setTextColor(Color.parseColor("#ffffffff"));
    ((TextView)localObject2).setVisibility(8);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.bottomMargin = ViewUtils.b(5.0F);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(14, -1);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject2 = new QIMCommonLoadingView(this.jdField_a_of_type_AndroidContentContext);
    ((QIMCommonLoadingView)localObject2).setId(2131362488);
    ((QIMCommonLoadingView)localObject2).setVisibility(8);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject1 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject1).setId(2131362487);
    ((ImageView)localObject1).setVisibility(8);
    ((ImageView)localObject1).setImageResource(2130843189);
    i = ViewUtils.b(18.0F);
    localObject2 = new RelativeLayout.LayoutParams(i, i);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject1).setId(2131369936);
    ((ImageView)localObject1).setImageResource(2130843196);
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
  
  public void a(List paramList)
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
    if (paramView == null)
    {
      paramViewGroup = new MusicProviderGridAdapter.ViewHolder(this);
      paramView = a();
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362491));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362490));
      paramViewGroup.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView = ((QIMCommonLoadingView)paramView.findViewById(2131362488));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362492));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362512));
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362489));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362487));
      paramViewGroup.d = ((ImageView)paramView.findViewById(2131369936));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setVisibility(0);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = localMusicItemInfo;
      paramViewGroup.jdField_a_of_type_Int = paramInt;
      AbsListView.LayoutParams localLayoutParams2 = (AbsListView.LayoutParams)paramView.getLayoutParams();
      AbsListView.LayoutParams localLayoutParams1 = localLayoutParams2;
      if (localLayoutParams2 == null)
      {
        localLayoutParams1 = new AbsListView.LayoutParams(-1, -1);
        paramView.setLayoutParams(localLayoutParams1);
      }
      localLayoutParams1.height = this.b;
      a(paramViewGroup);
      if (localMusicItemInfo.d()) {
        WeishiGuideUtils.a(localMusicItemInfo);
      }
      return paramView;
      paramViewGroup = (MusicProviderGridAdapter.ViewHolder)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.adapter.MusicProviderGridAdapter
 * JD-Core Version:    0.7.0.1
 */