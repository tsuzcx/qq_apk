package com.tencent.mobileqq.now.message;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.msglist.item.ItemBuilderFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.nearby.now.utils.ImageLoader;
import com.tencent.mobileqq.now.roport.NowQQLiveDataReport;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgClickHandler;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import java.util.Iterator;
import java.util.List;

public class MessageReceivingAdapter
  extends PagerAdapter
{
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private ItemBuilderFactory jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistItemItemBuilderFactory;
  private List<ChatMessage> jdField_a_of_type_JavaUtilList;
  
  public MessageReceivingAdapter(FragmentActivity paramFragmentActivity, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistItemItemBuilderFactory = new ItemBuilderFactory(paramFragmentActivity, paramFragmentActivity.app, paramBaseChatPie.a, null, paramBaseChatPie);
  }
  
  private View a(Context paramContext, ViewGroup paramViewGroup, MessageForArkApp paramMessageForArkApp, int paramInt)
  {
    paramContext = new WrapperArkView(paramContext, paramViewGroup, paramMessageForArkApp, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistItemItemBuilderFactory.a(paramMessageForArkApp, null), paramInt);
    paramContext.setOnArkViewTouchListener(new MessageReceivingAdapter.2(this, paramInt, paramMessageForArkApp));
    return paramContext;
  }
  
  private View a(Context paramContext, ViewGroup paramViewGroup, MessageForStructing paramMessageForStructing, int paramInt)
  {
    ChatItemBuilder localChatItemBuilder = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistItemItemBuilderFactory.a(paramMessageForStructing, null);
    if ((paramMessageForStructing.structingMsg instanceof StructMsgForGeneralShare))
    {
      StructMsgForGeneralShare localStructMsgForGeneralShare = (StructMsgForGeneralShare)paramMessageForStructing.structingMsg;
      paramContext = new GeneralSharePagerView(paramContext);
      ImageLoader.a().a(paramContext.a, localStructMsgForGeneralShare.mContentCover, new ColorDrawable(0), new ColorDrawable(0), null);
      paramContext.a(localChatItemBuilder.a(paramInt, getCount(), paramMessageForStructing, null, paramViewGroup, new MessageReceivingAdapter.1(this, paramInt, paramMessageForStructing, localStructMsgForGeneralShare)));
      return paramContext;
    }
    return a(paramViewGroup, paramMessageForStructing, paramInt);
  }
  
  private View a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt >= getCount()) {}
    ChatMessage localChatMessage;
    do
    {
      return null;
      if (paramInt == 3) {
        return b(paramViewGroup, paramInt);
      }
      localChatMessage = a(paramInt);
      if ((localChatMessage instanceof MessageForStructing))
      {
        paramViewGroup = a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramViewGroup, (MessageForStructing)localChatMessage, paramInt);
        NowQQLiveDataReport.a(paramInt + 1, ChatMessageHelper.b(localChatMessage), "2");
        return paramViewGroup;
      }
      if ((localChatMessage instanceof MessageForArkApp))
      {
        paramViewGroup = a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramViewGroup, (MessageForArkApp)localChatMessage, paramInt);
        NowQQLiveDataReport.a(paramInt + 1, ChatMessageHelper.b(localChatMessage), "1");
        return paramViewGroup;
      }
    } while (localChatMessage == null);
    return a(paramViewGroup, localChatMessage, paramInt);
  }
  
  private View a(ViewGroup paramViewGroup, ChatMessage paramChatMessage, int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistItemItemBuilderFactory.a(paramChatMessage, null).a(paramInt, getCount(), paramChatMessage, null, paramViewGroup, new OnArkViewTouchListener());
  }
  
  private boolean a(View paramView, ChatMessage paramChatMessage, StructMsgForGeneralShare paramStructMsgForGeneralShare)
  {
    paramView = new StructMsgClickHandler(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, paramView, paramChatMessage);
    if (!TextUtils.isEmpty(paramStructMsgForGeneralShare.mMsgUrl)) {
      return paramView.a(paramStructMsgForGeneralShare.mMsgUrl, paramChatMessage.getId(), null);
    }
    Iterator localIterator = paramStructMsgForGeneralShare.mStructMsgItemLists.iterator();
    while (localIterator.hasNext())
    {
      AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)localIterator.next();
      if ((localAbsStructMsgElement.a == paramStructMsgForGeneralShare.msgId) && (!TextUtils.isEmpty(localAbsStructMsgElement.b))) {
        return paramView.a(localAbsStructMsgElement.b, paramChatMessage.getId(), null);
      }
    }
    return false;
  }
  
  private View b(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131559643, paramViewGroup, false);
  }
  
  public ChatMessage a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(List<ChatMessage> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public void destroyItem(@NonNull ViewGroup paramViewGroup, int paramInt, @NonNull Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return 0;
    }
    if (this.jdField_a_of_type_JavaUtilList.size() > 3) {
      return 4;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  @NonNull
  public Object instantiateItem(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    View localView = a(paramViewGroup, paramInt);
    if (localView != null) {
      paramViewGroup.addView(localView);
    }
    return localView;
  }
  
  public boolean isViewFromObject(@NonNull View paramView, @NonNull Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.message.MessageReceivingAdapter
 * JD-Core Version:    0.7.0.1
 */