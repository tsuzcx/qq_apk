package com.tencent.mobileqq.hiboom;

import adpi;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.flashchat.FlashChatPanel;
import com.tencent.mobileqq.flashchat.OnHolderItemClickListener;
import java.util.List;

public class HiBoomPanelView$HiBoomAdapter
  extends RecyclerView.Adapter
{
  public OnHolderItemClickListener a;
  List jdField_a_of_type_JavaUtilList;
  
  public HiBoomPanelView$HiBoomAdapter(HiBoomPanelView paramHiBoomPanelView, OnHolderItemClickListener paramOnHolderItemClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqFlashchatOnHolderItemClickListener = paramOnHolderItemClickListener;
  }
  
  public adpi a(ViewGroup paramViewGroup, int paramInt)
  {
    return new adpi(LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.getContext()).inflate(2130971719, paramViewGroup, false), this.jdField_a_of_type_ComTencentMobileqqFlashchatOnHolderItemClickListener);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        HiBoomItem localHiBoomItem = (HiBoomItem)this.jdField_a_of_type_JavaUtilList.get(i);
        if (localHiBoomItem.jdField_a_of_type_Int == paramInt1)
        {
          localHiBoomItem.d = paramInt2;
          notifyDataSetChanged();
          return;
        }
        i += 1;
      }
    }
  }
  
  public void a(adpi paramadpi, int paramInt)
  {
    HiBoomItem localHiBoomItem = (HiBoomItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject = (ViewGroup.MarginLayoutParams)paramadpi.itemView.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject).height = FlashChatPanel.f;
    ((ViewGroup.MarginLayoutParams)localObject).width = FlashChatPanel.e;
    if (paramInt % 3 == 0)
    {
      ((ViewGroup.MarginLayoutParams)localObject).leftMargin = 0;
      ((ViewGroup.MarginLayoutParams)localObject).rightMargin = FlashChatPanel.g;
      if (paramInt / 3 != 0) {
        break label327;
      }
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = 0;
      ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = FlashChatPanel.g;
      label82:
      localObject = (HiBoomManager)this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.b.a.getManager(218);
      URLDrawable localURLDrawable;
      if (!TextUtils.isEmpty(localHiBoomItem.g))
      {
        paramadpi.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localHiBoomItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        if ((localHiBoomItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof URLDrawable))
        {
          localURLDrawable = (URLDrawable)localHiBoomItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          if (localURLDrawable.getStatus() == 2) {
            localURLDrawable.restartDownload();
          }
        }
      }
      if (TextUtils.isEmpty(localHiBoomItem.h)) {
        break label375;
      }
      paramadpi.b.setVisibility(0);
      paramadpi.b.setImageDrawable(localHiBoomItem.b);
      if ((localHiBoomItem.b instanceof URLDrawable))
      {
        localURLDrawable = (URLDrawable)localHiBoomItem.b;
        if (localURLDrawable.getStatus() == 2) {
          localURLDrawable.restartDownload();
        }
        if (localURLDrawable.getStatus() != 1) {
          paramadpi.b.setVisibility(8);
        }
      }
      label237:
      if (localHiBoomItem.jdField_a_of_type_Int != ((HiBoomManager)localObject).jdField_a_of_type_Int) {
        break label387;
      }
      paramadpi.c.setVisibility(0);
    }
    for (;;)
    {
      if ((localHiBoomItem.d != 100) && (localHiBoomItem.d != -1)) {
        break label399;
      }
      paramadpi.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
      if (paramInt % 3 == 2)
      {
        ((ViewGroup.MarginLayoutParams)localObject).leftMargin = FlashChatPanel.g;
        ((ViewGroup.MarginLayoutParams)localObject).rightMargin = 0;
        break;
      }
      ((ViewGroup.MarginLayoutParams)localObject).leftMargin = FlashChatPanel.g;
      ((ViewGroup.MarginLayoutParams)localObject).rightMargin = FlashChatPanel.g;
      break;
      label327:
      if (paramInt / 3 == getItemCount() / 3)
      {
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = FlashChatPanel.g;
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = 0;
        break label82;
      }
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = FlashChatPanel.g;
      ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = FlashChatPanel.g;
      break label82;
      label375:
      paramadpi.b.setVisibility(8);
      break label237;
      label387:
      paramadpi.c.setVisibility(8);
    }
    label399:
    paramadpi.jdField_a_of_type_AndroidViewView.setVisibility(0);
    paramInt = paramadpi.jdField_a_of_type_AndroidWidgetImageView.getHeight();
    paramadpi.jdField_a_of_type_AndroidViewView.getLayoutParams().height = ((100 - localHiBoomItem.d) * paramInt / 100);
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomPanelView.HiBoomAdapter
 * JD-Core Version:    0.7.0.1
 */