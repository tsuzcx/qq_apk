package com.tencent.mobileqq.troop.troopcreate.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.troop.api.troopcreate.IQQBase;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter;
import java.util.ArrayList;

public class NewTroopContactView$GridViewAdapter
  extends BaseAdapter
  implements DecodeTaskCompletionListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private final Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_a_of_type_Boolean = false;
  
  public NewTroopContactView$GridViewAdapter(NewTroopContactView paramNewTroopContactView, Context paramContext)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130844953);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiNewTroopContactView.c != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiNewTroopContactView.c.size() > 0))
      {
        String str = ((ResultRecord)this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiNewTroopContactView.c.get(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiNewTroopContactView.c.size() - 1)).uin;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiNewTroopContactView.a(str))
        {
          NewTroopContactView.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiNewTroopContactView, str);
          this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiNewTroopContactView.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$ExpandableListAdapter.notifyDataSetChanged();
          this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiNewTroopContactView.b(false);
          this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiNewTroopContactView.o();
        }
      }
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiNewTroopContactView.c.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiNewTroopContactView.c.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ResultRecord localResultRecord = (ResultRecord)getItem(paramInt);
    View localView = paramView;
    if (paramView == null) {
      localView = this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiNewTroopContactView.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getLayoutInflater().inflate(2131559277, null);
    }
    localView.setTag(localResultRecord);
    ImageView localImageView = (ImageView)localView.findViewById(2131366401);
    if (paramInt == getCount() - 1)
    {
      if (this.jdField_a_of_type_Boolean) {
        paramView = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      } else {
        paramView = null;
      }
      localImageView.setImageDrawable(paramView);
    }
    else
    {
      localImageView.setImageDrawable(null);
    }
    localImageView.setBackgroundDrawable(null);
    int i;
    if (localResultRecord.type == 4) {
      i = 11;
    } else {
      i = 1;
    }
    TextView localTextView = (TextView)localView.findViewById(2131379723);
    if (localResultRecord.type == 5)
    {
      localImageView.setImageResource(2130842159);
      localTextView.setVisibility(0);
      localTextView.setText(NewTroopContactView.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiNewTroopContactView).getHeaderText(localResultRecord.name));
    }
    else
    {
      String str = localResultRecord.uin;
      Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiNewTroopContactView.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(i, str);
      paramView = localBitmap;
      if (localBitmap == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiNewTroopContactView.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(str, i, true);
        paramView = this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiNewTroopContactView.jdField_a_of_type_AndroidGraphicsBitmap;
      }
      localImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiNewTroopContactView.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources(), paramView));
      localTextView.setVisibility(8);
    }
    if (AppSetting.d) {
      localImageView.setContentDescription(localResultRecord.name);
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public void notifyDataSetChanged()
  {
    this.jdField_a_of_type_Boolean = false;
    super.notifyDataSetChanged();
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiNewTroopContactView.jdField_a_of_type_AndroidWidgetGridView == null) {
      return;
    }
    paramInt1 = 0;
    while (paramInt1 < this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiNewTroopContactView.jdField_a_of_type_AndroidWidgetGridView.getChildCount())
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiNewTroopContactView.jdField_a_of_type_AndroidWidgetGridView.getChildAt(paramInt1);
      Object localObject = localView.getTag();
      if ((localObject != null) && ((localObject instanceof ResultRecord)) && (paramString.equals(((ResultRecord)localObject).uin))) {
        ((ImageView)localView.findViewById(2131366401)).setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiNewTroopContactView.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources(), paramBitmap));
      }
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.NewTroopContactView.GridViewAdapter
 * JD-Core Version:    0.7.0.1
 */