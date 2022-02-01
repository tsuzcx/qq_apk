package com.tencent.mobileqq.now.message;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.msglist.item.ItemBuilderFactory;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.nearby.now.utils.IImageLoader;
import com.tencent.mobileqq.now.roport.NowQQLiveDataReport;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgClickHandler;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import java.util.Iterator;
import java.util.List;

public class MessageReceivingAdapter
  extends PagerAdapter
{
  private BaseActivity a;
  private List<ChatMessage> b;
  private ItemBuilderFactory c;
  
  public MessageReceivingAdapter(BaseActivity paramBaseActivity, BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseActivity;
    this.c = new ItemBuilderFactory(paramBaseActivity, paramBaseActivity.app, paramBaseChatPie.ah, null, paramBaseChatPie);
  }
  
  private View a(Context paramContext, ViewGroup paramViewGroup, MessageForArkApp paramMessageForArkApp, int paramInt)
  {
    paramContext = new WrapperArkView(paramContext, paramViewGroup, paramMessageForArkApp, this.c.a(paramMessageForArkApp, null), paramInt);
    paramContext.setOnArkViewTouchListener(new MessageReceivingAdapter.2(this, paramInt, paramMessageForArkApp));
    return paramContext;
  }
  
  private View a(Context paramContext, ViewGroup paramViewGroup, MessageForStructing paramMessageForStructing, int paramInt)
  {
    ChatItemBuilder localChatItemBuilder = this.c.a(paramMessageForStructing, null);
    if ((paramMessageForStructing.structingMsg instanceof StructMsgForGeneralShare))
    {
      StructMsgForGeneralShare localStructMsgForGeneralShare = (StructMsgForGeneralShare)paramMessageForStructing.structingMsg;
      paramContext = new GeneralSharePagerView(paramContext);
      ((IImageLoader)QRoute.api(IImageLoader.class)).displayImage(paramContext.b, localStructMsgForGeneralShare.mContentCover, new ColorDrawable(0), new ColorDrawable(0), null);
      paramContext.a(localChatItemBuilder.a(paramInt, getCount(), paramMessageForStructing, null, paramViewGroup, new MessageReceivingAdapter.1(this, paramInt, paramMessageForStructing, localStructMsgForGeneralShare)));
      return paramContext;
    }
    return a(paramViewGroup, paramMessageForStructing, paramInt);
  }
  
  private View a(ViewGroup paramViewGroup, int paramInt)
  {
    int i = getCount();
    View localView = null;
    if (paramInt >= i) {
      return null;
    }
    if (paramInt == 3) {
      return b(paramViewGroup, paramInt);
    }
    ChatMessage localChatMessage = a(paramInt);
    if ((localChatMessage instanceof MessageForStructing))
    {
      paramViewGroup = a(this.a, paramViewGroup, (MessageForStructing)localChatMessage, paramInt);
      NowQQLiveDataReport.a(paramInt + 1, ChatMessageHelper.b(localChatMessage), "2");
      return paramViewGroup;
    }
    if ((localChatMessage instanceof MessageForArkApp))
    {
      paramViewGroup = a(this.a, paramViewGroup, (MessageForArkApp)localChatMessage, paramInt);
      NowQQLiveDataReport.a(paramInt + 1, ChatMessageHelper.b(localChatMessage), "1");
      return paramViewGroup;
    }
    if (localChatMessage != null) {
      localView = a(paramViewGroup, localChatMessage, paramInt);
    }
    return localView;
  }
  
  private View a(ViewGroup paramViewGroup, ChatMessage paramChatMessage, int paramInt)
  {
    return this.c.a(paramChatMessage, null).a(paramInt, getCount(), paramChatMessage, null, paramViewGroup, new OnArkViewTouchListener());
  }
  
  private boolean a(View paramView, ChatMessage paramChatMessage, StructMsgForGeneralShare paramStructMsgForGeneralShare)
  {
    paramView = new StructMsgClickHandler(this.a.app, paramView, paramChatMessage);
    if (!TextUtils.isEmpty(paramStructMsgForGeneralShare.mMsgUrl)) {
      return paramView.a(paramStructMsgForGeneralShare.mMsgUrl, paramChatMessage.getId(), null);
    }
    Iterator localIterator = paramStructMsgForGeneralShare.mStructMsgItemLists.iterator();
    while (localIterator.hasNext())
    {
      AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)localIterator.next();
      if ((localAbsStructMsgElement.ao == paramStructMsgForGeneralShare.msgId) && (!TextUtils.isEmpty(localAbsStructMsgElement.d))) {
        return paramView.a(localAbsStructMsgElement.d, paramChatMessage.getId(), null);
      }
    }
    return false;
  }
  
  private View b(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return LayoutInflater.from(this.a).inflate(2131625542, paramViewGroup, false);
  }
  
  public ChatMessage a(int paramInt)
  {
    List localList = this.b;
    if ((localList != null) && (paramInt < localList.size())) {
      return (ChatMessage)this.b.get(paramInt);
    }
    return null;
  }
  
  public void a(List<ChatMessage> paramList)
  {
    this.b = paramList;
    notifyDataSetChanged();
  }
  
  public void destroyItem(@NonNull ViewGroup paramViewGroup, int paramInt, @NonNull Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    List localList = this.b;
    if ((localList != null) && (localList.size() != 0))
    {
      if (this.b.size() > 3) {
        return 4;
      }
      return this.b.size();
    }
    return 0;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.message.MessageReceivingAdapter
 * JD-Core Version:    0.7.0.1
 */