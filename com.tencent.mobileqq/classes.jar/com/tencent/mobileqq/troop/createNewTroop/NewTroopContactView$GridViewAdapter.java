package com.tencent.mobileqq.troop.createNewTroop;

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
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130845076);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.c != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.c.size() > 0))
      {
        String str = ((ResultRecord)this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.c.get(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.c.size() - 1)).uin;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.a(str))
        {
          NewTroopContactView.a(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView, str);
          this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopContactListAdapter.notifyDataSetChanged();
          this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.b(false);
          NewTroopContactView.a(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView);
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
    return this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.c.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.c.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ResultRecord localResultRecord = (ResultRecord)getItem(paramInt);
    if (paramView == null) {
      paramView = this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.getLayoutInflater().inflate(2131559402, null);
    }
    for (;;)
    {
      paramView.setTag(localResultRecord);
      ImageView localImageView = (ImageView)paramView.findViewById(2131366520);
      if (paramInt == getCount() - 1) {
        if (this.jdField_a_of_type_Boolean)
        {
          localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          localImageView.setImageDrawable((Drawable)localObject);
          label78:
          localImageView.setBackgroundDrawable(null);
          if (localResultRecord.type != 4) {
            break label190;
          }
        }
      }
      TextView localTextView;
      label190:
      for (int i = 11;; i = 1)
      {
        localTextView = (TextView)paramView.findViewById(2131380409);
        if (localResultRecord.type != 5) {
          break label196;
        }
        localImageView.setImageResource(2130842261);
        localTextView.setVisibility(0);
        localTextView.setText(ContactUtils.a(localResultRecord.name));
        if (AppSetting.d) {
          localImageView.setContentDescription(localResultRecord.name);
        }
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localObject = null;
        break;
        localImageView.setImageDrawable(null);
        break label78;
      }
      label196:
      String str = localResultRecord.uin;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(i, str);
      if (localObject == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(str, i, true);
        localObject = this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.jdField_a_of_type_AndroidGraphicsBitmap;
      }
      for (;;)
      {
        localImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.getResources(), (Bitmap)localObject));
        localTextView.setVisibility(8);
        break;
      }
    }
  }
  
  public void notifyDataSetChanged()
  {
    this.jdField_a_of_type_Boolean = false;
    super.notifyDataSetChanged();
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.jdField_a_of_type_AndroidWidgetGridView == null) {}
    for (;;)
    {
      return;
      paramInt1 = 0;
      while (paramInt1 < this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.jdField_a_of_type_AndroidWidgetGridView.getChildCount())
      {
        View localView = this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.jdField_a_of_type_AndroidWidgetGridView.getChildAt(paramInt1);
        Object localObject = localView.getTag();
        if ((localObject != null) && ((localObject instanceof ResultRecord)) && (paramString.equals(((ResultRecord)localObject).uin))) {
          ((ImageView)localView.findViewById(2131366520)).setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.getResources(), paramBitmap));
        }
        paramInt1 += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.NewTroopContactView.GridViewAdapter
 * JD-Core Version:    0.7.0.1
 */