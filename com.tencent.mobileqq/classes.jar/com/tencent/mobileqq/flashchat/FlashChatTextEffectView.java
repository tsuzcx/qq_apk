package com.tencent.mobileqq.flashchat;

import adsd;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlashChatTextEffectView
  extends RecyclerView
{
  int jdField_a_of_type_Int;
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  FlashChatObserver jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatObserver = new adsd(this);
  FlashChatTextEffectView.FlashChatAdapter jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$FlashChatAdapter;
  
  public FlashChatTextEffectView(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$FlashChatAdapter.getItemCount();
  }
  
  public FlashChatItem a(int paramInt)
  {
    try
    {
      FlashChatItem localFlashChatItem = ((FlashChatPanel.PluginData)this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$FlashChatAdapter.a.get(paramInt)).jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem;
      return localFlashChatItem;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public void a()
  {
    Object localObject = ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.getManager(216)).a();
    ArrayList localArrayList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    if (((Iterator)localObject).hasNext())
    {
      FlashChatItem localFlashChatItem = (FlashChatItem)((Iterator)localObject).next();
      FlashChatPanel.PluginData localPluginData = new FlashChatPanel.PluginData();
      localPluginData.jdField_b_of_type_Int = localFlashChatItem.a;
      if (localFlashChatItem.a == -100000) {}
      URLDrawable localURLDrawable;
      for (localPluginData.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getContext().getResources().getDrawable(2130842559);; localPluginData.jdField_a_of_type_AndroidGraphicsDrawableDrawable = localURLDrawable)
      {
        localPluginData.jdField_b_of_type_JavaLangString = "插件描述内容";
        localPluginData.jdField_a_of_type_JavaLangString = localFlashChatItem.jdField_b_of_type_JavaLangString;
        localPluginData.jdField_a_of_type_Boolean = false;
        localPluginData.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem = localFlashChatItem;
        localArrayList.add(localPluginData);
        break;
        localURLDrawable = URLDrawable.getDrawable(localFlashChatItem.c, URLDrawable.URLDrawableOptions.obtain());
        localURLDrawable.startDownload();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$FlashChatAdapter.a(localArrayList);
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$FlashChatAdapter.notifyDataSetChanged();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$FlashChatAdapter.a != null)
    {
      int i = 0;
      if (i < this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$FlashChatAdapter.a.size())
      {
        FlashChatPanel.PluginData localPluginData = (FlashChatPanel.PluginData)this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$FlashChatAdapter.a.get(i);
        if (i == paramInt) {}
        for (localPluginData.jdField_a_of_type_Boolean = true;; localPluginData.jdField_a_of_type_Boolean = false)
        {
          i += 1;
          break;
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$FlashChatAdapter.notifyDataSetChanged();
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.registObserver(this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatObserver);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatTextEffectView
 * JD-Core Version:    0.7.0.1
 */