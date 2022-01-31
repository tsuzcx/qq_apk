package com.tencent.mobileqq.richmedia.capture.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.richmedia.capture.data.SubtitleItem;
import com.tencent.mobileqq.richmedia.capture.data.SubtitleItem.FontItem;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;

public class SubtitleProviderGridAdapter
  extends BaseAdapter
{
  public int a;
  private Context jdField_a_of_type_AndroidContentContext;
  public String a;
  List jdField_a_of_type_JavaUtilList;
  
  public SubtitleProviderGridAdapter(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangString = "SubtitleProviderGridAdapter";
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(SubtitleItem paramSubtitleItem, View paramView)
  {
    if ((paramSubtitleItem == null) || (paramView == null)) {}
    do
    {
      return;
      paramView = (ImageView)paramView.findViewById(2131363422);
    } while (paramView == null);
    if ((paramSubtitleItem != null) && (paramSubtitleItem.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSubtitleItem$FontItem != null) && (paramSubtitleItem.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSubtitleItem$FontItem.d != 2) && (!paramSubtitleItem.jdField_b_of_type_Boolean))
    {
      paramView.setImageResource(2130843289);
      paramView.setVisibility(0);
      return;
    }
    paramView.setVisibility(8);
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    if ((paramList != null) && (QLog.isColorLevel())) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "SubtitleProviderGridAdapter setData size = " + paramList.size());
    }
  }
  
  public void b(SubtitleItem paramSubtitleItem, View paramView)
  {
    if ((paramSubtitleItem == null) || (paramView == null)) {}
    do
    {
      return;
      CircleProgress localCircleProgress = (CircleProgress)paramView.findViewById(2131369945);
      paramView = (ImageView)paramView.findViewById(2131369941);
      if (paramSubtitleItem.jdField_b_of_type_Boolean)
      {
        localCircleProgress.setVisibility(0);
        if (paramSubtitleItem.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSubtitleItem$FontItem != null) {
          localCircleProgress.setProgress(paramSubtitleItem.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSubtitleItem$FontItem.e);
        }
        paramView.setVisibility(8);
        return;
      }
      localCircleProgress.setVisibility(8);
    } while (this.jdField_a_of_type_Int != paramSubtitleItem.jdField_a_of_type_Int);
    paramView.setVisibility(0);
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
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970294, paramViewGroup, false);
    }
    paramView = (TextView)localView.findViewById(2131369942);
    Object localObject2 = (ImageView)localView.findViewById(2131369941);
    paramViewGroup = (ImageView)localView.findViewById(2131362724);
    ImageView localImageView = (ImageView)localView.findViewById(2131363422);
    RelativeLayout localRelativeLayout = (RelativeLayout)localView.findViewById(2131369944);
    Object localObject1 = (CircleProgress)localView.findViewById(2131369945);
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131494220);
    int j = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131493308);
    ((CircleProgress)localObject1).setStrokeWidth(2.0F);
    ((CircleProgress)localObject1).setBgAndProgressColor(30, i, 100, j);
    localObject1 = (SubtitleItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (this.jdField_a_of_type_Int == ((SubtitleItem)localObject1).jdField_a_of_type_Int)
    {
      paramInt = 1;
      localView.setTag(localObject1);
      if ((AbsListView.LayoutParams)localView.getLayoutParams() == null) {
        localView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      }
      if (!((SubtitleItem)localObject1).a()) {
        break label287;
      }
      ((ImageView)localObject2).setVisibility(8);
      if (paramInt == 0) {
        break label268;
      }
      paramViewGroup.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843224));
    }
    for (;;)
    {
      paramViewGroup.setContentDescription("无字幕");
      localImageView.setVisibility(8);
      paramView.setVisibility(0);
      paramView.setText("");
      return localView;
      paramInt = 0;
      break;
      label268:
      paramViewGroup.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843225));
    }
    label287:
    if (paramInt != 0)
    {
      ((ImageView)localObject2).setVisibility(0);
      paramView.setShadowLayer(0.0F, 0.0F, 0.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131492976));
      localRelativeLayout.setVisibility(8);
    }
    for (;;)
    {
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843215);
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843215);
      b((SubtitleItem)localObject1, localView);
      localObject2 = URLDrawable.getDrawable(((SubtitleItem)localObject1).jdField_a_of_type_JavaLangString, URLDrawable.URLDrawableOptions.obtain());
      ((URLDrawable)localObject2).startDownload();
      paramViewGroup.setImageDrawable((Drawable)localObject2);
      paramViewGroup.setContentDescription(((SubtitleItem)localObject1).jdField_b_of_type_JavaLangString);
      paramView.setText(((SubtitleItem)localObject1).jdField_b_of_type_JavaLangString);
      paramView.setVisibility(8);
      a((SubtitleItem)localObject1, localView);
      return localView;
      ((ImageView)localObject2).setVisibility(8);
      paramView.setShadowLayer(3.0F, 0.0F, 0.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131492976));
      localRelativeLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.adapter.SubtitleProviderGridAdapter
 * JD-Core Version:    0.7.0.1
 */