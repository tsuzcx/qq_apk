package com.tencent.mobileqq.flashchat;

import adse;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import java.util.List;

public class FlashChatTextEffectView$FlashChatAdapter
  extends RecyclerView.Adapter
{
  public OnHolderItemClickListener a;
  List jdField_a_of_type_JavaUtilList;
  
  public adse a(ViewGroup paramViewGroup, int paramInt)
  {
    return new adse(LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.getContext()).inflate(2130970354, paramViewGroup, false), this.jdField_a_of_type_ComTencentMobileqqFlashchatOnHolderItemClickListener, this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.jdField_a_of_type_Int);
  }
  
  public void a(adse paramadse, int paramInt)
  {
    FlashChatPanel.PluginData localPluginData = (FlashChatPanel.PluginData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject = (ViewGroup.MarginLayoutParams)paramadse.itemView.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject).height = FlashChatPanel.f;
    ((ViewGroup.MarginLayoutParams)localObject).width = FlashChatPanel.e;
    if (paramInt % 3 == 0)
    {
      ((ViewGroup.MarginLayoutParams)localObject).leftMargin = 0;
      ((ViewGroup.MarginLayoutParams)localObject).rightMargin = FlashChatPanel.g;
    }
    for (;;)
    {
      if (paramInt / 3 == 0)
      {
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = 0;
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = FlashChatPanel.g;
        label82:
        paramadse.itemView.setBackgroundDrawable(new ColorDrawable(0));
        paramadse.itemView.setContentDescription("已选定 文字特效 " + localPluginData.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem.jdField_b_of_type_JavaLangString);
        if (localPluginData.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem.f == null) {}
      }
      try
      {
        paramadse.itemView.setBackgroundDrawable(new ColorDrawable(Color.parseColor(localPluginData.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem.f)));
        paramadse.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        paramadse.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(localPluginData.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        if ((localPluginData.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof URLDrawable))
        {
          localObject = (URLDrawable)localPluginData.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          if (((URLDrawable)localObject).getStatus() == 2) {
            ((URLDrawable)localObject).restartDownload();
          }
        }
        paramadse.jdField_a_of_type_AndroidWidgetTextView.setText(localPluginData.jdField_a_of_type_JavaLangString);
        if (localPluginData.jdField_a_of_type_Boolean)
        {
          paramadse.c.setVisibility(0);
          switch (localPluginData.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem.jdField_b_of_type_Int)
          {
          default: 
            paramadse.d.setImageDrawable(null);
            paramadse.jdField_a_of_type_Int = localPluginData.jdField_a_of_type_Int;
            paramadse.jdField_b_of_type_Int = localPluginData.jdField_b_of_type_Int;
            paramadse.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem = localPluginData.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem;
            paramadse.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatPanel$PluginData = localPluginData;
            return;
            if (paramInt % 3 == 2)
            {
              ((ViewGroup.MarginLayoutParams)localObject).leftMargin = FlashChatPanel.g;
              ((ViewGroup.MarginLayoutParams)localObject).rightMargin = 0;
              continue;
            }
            ((ViewGroup.MarginLayoutParams)localObject).leftMargin = FlashChatPanel.g;
            ((ViewGroup.MarginLayoutParams)localObject).rightMargin = FlashChatPanel.g;
            continue;
            if (paramInt / 3 == getItemCount() / 3)
            {
              ((ViewGroup.MarginLayoutParams)localObject).topMargin = FlashChatPanel.g;
              ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = 0;
              break label82;
            }
            ((ViewGroup.MarginLayoutParams)localObject).topMargin = FlashChatPanel.g;
            ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = FlashChatPanel.g;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          continue;
          paramadse.c.setVisibility(8);
          continue;
          paramadse.d.setImageResource(2130842561);
          continue;
          paramadse.d.setImageResource(2130842565);
        }
      }
    }
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatTextEffectView.FlashChatAdapter
 * JD-Core Version:    0.7.0.1
 */