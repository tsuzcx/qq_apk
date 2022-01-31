package com.tencent.mobileqq.flashchat;

import adaa;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
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
  StaggeredGridLayoutManager jdField_a_of_type_AndroidSupportV7WidgetStaggeredGridLayoutManager;
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  FlashChatObserver jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatObserver = new adaa(this);
  FlashChatTextEffectView.FlashChatAdapter jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$FlashChatAdapter;
  OnHolderItemClickListener jdField_a_of_type_ComTencentMobileqqFlashchatOnHolderItemClickListener;
  
  public FlashChatTextEffectView(Context paramContext)
  {
    super(paramContext);
  }
  
  public FlashChatTextEffectView(Context paramContext, BaseChatPie paramBaseChatPie, OnHolderItemClickListener paramOnHolderItemClickListener, int paramInt)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqFlashchatOnHolderItemClickListener = paramOnHolderItemClickListener;
    this.jdField_a_of_type_Int = paramInt;
    setClipToPadding(false);
    a();
    b();
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
  
  @TargetApi(9)
  public void a()
  {
    setOverScrollMode(2);
    this.jdField_a_of_type_AndroidSupportV7WidgetStaggeredGridLayoutManager = new StaggeredGridLayoutManager(3, 1);
    setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetStaggeredGridLayoutManager);
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$FlashChatAdapter = new FlashChatTextEffectView.FlashChatAdapter(this, this.jdField_a_of_type_ComTencentMobileqqFlashchatOnHolderItemClickListener);
    setAdapter(this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$FlashChatAdapter);
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
  
  public void b()
  {
    Object localObject = ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.getManager(216)).a();
    ArrayList localArrayList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    if (((Iterator)localObject).hasNext())
    {
      FlashChatItem localFlashChatItem = (FlashChatItem)((Iterator)localObject).next();
      FlashChatPanel.PluginData localPluginData = new FlashChatPanel.PluginData();
      localPluginData.jdField_b_of_type_Int = localFlashChatItem.jdField_a_of_type_Int;
      if (localFlashChatItem.jdField_a_of_type_Int == -100000) {}
      URLDrawable localURLDrawable;
      for (localPluginData.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getContext().getResources().getDrawable(2130842432);; localPluginData.jdField_a_of_type_AndroidGraphicsDrawableDrawable = localURLDrawable)
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
  
  public void onVisibilityChanged(View paramView, int paramInt)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatTextEffectView
 * JD-Core Version:    0.7.0.1
 */