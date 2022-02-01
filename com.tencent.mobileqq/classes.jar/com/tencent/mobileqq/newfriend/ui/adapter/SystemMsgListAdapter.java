package com.tencent.mobileqq.newfriend.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.contact.connections.ConnectionsTabInfo;
import com.tencent.mobileqq.activity.contact.connections.TabLayoutStatus;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.api.impl.NewFriendServiceImpl;
import com.tencent.mobileqq.newfriend.interfaces.INewFriendListener;
import com.tencent.mobileqq.newfriend.msg.ContactBindedMessage;
import com.tencent.mobileqq.newfriend.msg.ContactMatchMessage;
import com.tencent.mobileqq.newfriend.msg.FriendSystemMessage;
import com.tencent.mobileqq.newfriend.msg.MayKnowBannerMessage;
import com.tencent.mobileqq.newfriend.msg.NewFriendBindContactGuideMsg;
import com.tencent.mobileqq.newfriend.msg.NewFriendBindContactGuideMsgV2;
import com.tencent.mobileqq.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.newfriend.msg.NewFriendMoreInfoMessage;
import com.tencent.mobileqq.newfriend.msg.NewFriendSlideTabMessage;
import com.tencent.mobileqq.newfriend.msg.NewFriendSubTitleMessage;
import com.tencent.mobileqq.newfriend.msg.NewFriendSysEmptyMessage;
import com.tencent.mobileqq.newfriend.msg.NewFriendTabEmptyMessage;
import com.tencent.mobileqq.newfriend.msg.NewFriendTabGuideMessage;
import com.tencent.mobileqq.newfriend.msg.NewFriendVerifyBlockedMsg;
import com.tencent.mobileqq.newfriend.msg.PhoneContactAddMessage;
import com.tencent.mobileqq.newfriend.msg.QIMFollowMessage;
import com.tencent.mobileqq.newfriend.msg.QIMNotifyAddFriendMsg;
import com.tencent.mobileqq.newfriend.poke.NewFriendNotifyPokeMsgHelper;
import com.tencent.mobileqq.newfriend.ui.builder.ContactBindedBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.ContactBindedBuilder.ContactBindedHolder;
import com.tencent.mobileqq.newfriend.ui.builder.ContactMatchBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.ContactMatchBuilder.ContactMatchHolder;
import com.tencent.mobileqq.newfriend.ui.builder.MayKnowRecommendBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.MayKnowRecommendBuilder.MayKnowRecommendHolder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendBaseBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendBaseBuilder.NewFriendBaseHolder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendBindContactGuideBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendBindContactGuideBuilder.MyHolder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendBindContactGuideBuilderV2;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendFillAcademicInfoBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendFillAcademicInfoBuilder.NewFriendFillAcademicInfoHolder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendMoreInfoBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendMoreInfoBuilder.NewFriendMoreInfoHolder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendSlideTabBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendSlideTabBuilder.NewFriendSildeTabHolder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendSubTitleBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendSubTitleBuilder.NewFriendSubTitleHolder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendSysEmptyBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendSysEmptyBuilder.NewFriendSysEmptyHolder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendTabEmptyBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendTabEmptyBuilder.NewFriendTabEmptyHolder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendTabGuideBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendTabGuideBuilder.NewFriendTabInfoHolder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendTabInfoBuilder.NewFriendTabInfoHolder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendVerifyBlockedBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendVerifyBlockedBuilder.NewFriendVerifyBlockedHolder;
import com.tencent.mobileqq.newfriend.ui.builder.PhoneContactAddBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.PhoneContactAddBuilder.PhoneContactAddHolder;
import com.tencent.mobileqq.newfriend.ui.builder.QIMFollowerAddBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.QIMNotifyAddFriendBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.SystemMsgItemBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.SystemMsgItemBuilder.SystemMsgItemHolder;
import com.tencent.mobileqq.newfriend.ui.view.SystemMsgListView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SwipListView.SwipListListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SystemMsgListAdapter
  extends SystemMsgListBaseAdapter
  implements Handler.Callback, DecodeTaskCompletionListener, INewFriendListener, IIconListener, SwipListView.SwipListListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  Handler jdField_a_of_type_AndroidOsHandler = null;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private TabLayoutStatus jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTabLayoutStatus = new TabLayoutStatus();
  private FlingHandler jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private NewFriendServiceImpl jdField_a_of_type_ComTencentMobileqqNewfriendApiImplNewFriendServiceImpl;
  private ContactBindedBuilder jdField_a_of_type_ComTencentMobileqqNewfriendUiBuilderContactBindedBuilder;
  public XListView a;
  protected Runnable a;
  private Hashtable<String, Bitmap> jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private List<NewFriendBaseBuilder> jdField_a_of_type_JavaUtilList = new ArrayList();
  private ConcurrentLinkedQueue<Long> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private boolean jdField_a_of_type_Boolean = true;
  private int b;
  
  public SystemMsgListAdapter(Context paramContext, AppInterface paramAppInterface, XListView paramXListView, SystemMsgListView paramSystemMsgListView, int paramInt, FlingHandler paramFlingHandler)
  {
    super(paramSystemMsgListView);
    this.jdField_a_of_type_JavaLangRunnable = new SystemMsgListAdapter.2(this);
    this.b = paramInt;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)paramAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
    this.jdField_a_of_type_ComTencentMobileqqNewfriendApiImplNewFriendServiceImpl = ((NewFriendServiceImpl)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(INewFriendService.class, ""));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).addListener(this, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqNewfriendApiImplNewFriendServiceImpl.addListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler = paramFlingHandler;
    this.jdField_a_of_type_ComTencentMobileqqNewfriendApiImplNewFriendServiceImpl.reSetLastSysMsgTotalCount(0);
  }
  
  private NewFriendBaseBuilder a(NewFriendMessage paramNewFriendMessage, int paramInt)
  {
    if ((paramNewFriendMessage instanceof ContactMatchMessage)) {
      return new ContactMatchBuilder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this, paramNewFriendMessage);
    }
    Object localObject1;
    if ((paramNewFriendMessage instanceof ContactBindedMessage))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqNewfriendUiBuilderContactBindedBuilder;
      if (localObject1 == null)
      {
        paramNewFriendMessage = new ContactBindedBuilder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this, paramNewFriendMessage);
        this.jdField_a_of_type_ComTencentMobileqqNewfriendUiBuilderContactBindedBuilder = ((ContactBindedBuilder)paramNewFriendMessage);
        return paramNewFriendMessage;
      }
      ((NewFriendBaseBuilder)localObject1).a(paramNewFriendMessage);
      return localObject1;
    }
    Object localObject2;
    if ((paramNewFriendMessage instanceof FriendSystemMessage))
    {
      paramNewFriendMessage = new SystemMsgItemBuilder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this, paramNewFriendMessage);
      localObject2 = (SystemMsgItemBuilder)paramNewFriendMessage;
      localObject1 = paramNewFriendMessage;
      if (((SystemMsgItemBuilder)localObject2).a != 0L)
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(Long.valueOf(((SystemMsgItemBuilder)localObject2).a));
        return paramNewFriendMessage;
      }
    }
    else
    {
      if ((paramNewFriendMessage instanceof NewFriendSubTitleMessage)) {
        return new NewFriendSubTitleBuilder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this, paramNewFriendMessage);
      }
      if ((paramNewFriendMessage instanceof NewFriendMoreInfoMessage)) {
        return new NewFriendMoreInfoBuilder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this, paramNewFriendMessage);
      }
      if ((paramNewFriendMessage instanceof NewFriendBindContactGuideMsg)) {
        return new NewFriendBindContactGuideBuilder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this, paramNewFriendMessage);
      }
      if ((paramNewFriendMessage instanceof NewFriendBindContactGuideMsgV2)) {
        return new NewFriendBindContactGuideBuilderV2(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this, paramNewFriendMessage);
      }
      if ((paramNewFriendMessage instanceof PhoneContactAddMessage)) {
        return new PhoneContactAddBuilder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this, paramNewFriendMessage);
      }
      if ((paramNewFriendMessage instanceof QIMFollowMessage)) {
        return new QIMFollowerAddBuilder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this, paramNewFriendMessage);
      }
      if ((paramNewFriendMessage instanceof QIMNotifyAddFriendMsg)) {
        return new QIMNotifyAddFriendBuilder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this, paramNewFriendMessage);
      }
      if ((paramNewFriendMessage instanceof NewFriendVerifyBlockedMsg)) {
        return new NewFriendVerifyBlockedBuilder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this, paramNewFriendMessage);
      }
      if ((paramNewFriendMessage instanceof NewFriendSysEmptyMessage)) {
        return new NewFriendSysEmptyBuilder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this, paramNewFriendMessage);
      }
      if ((paramNewFriendMessage instanceof NewFriendTabEmptyMessage))
      {
        paramNewFriendMessage = new NewFriendTabEmptyBuilder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this, paramNewFriendMessage);
        boolean bool = b(paramInt);
        ((NewFriendTabEmptyBuilder)paramNewFriendMessage).a(bool);
        return paramNewFriendMessage;
      }
      if ((paramNewFriendMessage instanceof MayKnowBannerMessage)) {
        return new NewFriendFillAcademicInfoBuilder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this, paramNewFriendMessage);
      }
      if ((paramNewFriendMessage instanceof NewFriendSlideTabMessage))
      {
        localObject2 = new NewFriendSlideTabBuilder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this, paramNewFriendMessage);
        Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
        localObject1 = localObject2;
        if (localHandler != null)
        {
          localHandler.removeMessages(3);
          localHandler.sendMessage(localHandler.obtainMessage(3, paramNewFriendMessage));
          return localObject2;
        }
      }
      else
      {
        if ((paramNewFriendMessage instanceof NewFriendTabGuideMessage)) {
          return new NewFriendTabGuideBuilder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this, paramNewFriendMessage);
        }
        localObject1 = null;
      }
    }
    return localObject1;
  }
  
  private void a(NewFriendSlideTabMessage paramNewFriendSlideTabMessage)
  {
    if ((paramNewFriendSlideTabMessage != null) && (paramNewFriendSlideTabMessage.a != null) && (paramNewFriendSlideTabMessage.a.size() != 0))
    {
      paramNewFriendSlideTabMessage = paramNewFriendSlideTabMessage.a;
      if (this.jdField_a_of_type_ComTencentMobileqqNewfriendUiViewSystemMsgListView != null) {
        this.jdField_a_of_type_ComTencentMobileqqNewfriendUiViewSystemMsgListView.a(paramNewFriendSlideTabMessage, b());
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("SystemMsgListAdapter", 2, "refreshHead null");
    }
  }
  
  private void a(ContactBindedBuilder.ContactBindedHolder paramContactBindedHolder)
  {
    Bitmap localBitmap;
    if ((paramContactBindedHolder.jdField_a_of_type_JavaLangString != null) && (paramContactBindedHolder.jdField_a_of_type_JavaLangString.length() > 0))
    {
      localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramContactBindedHolder.jdField_a_of_type_JavaLangString);
      if (localBitmap != null) {
        paramContactBindedHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      }
    }
    if ((paramContactBindedHolder.jdField_b_of_type_JavaLangString != null) && (paramContactBindedHolder.jdField_b_of_type_JavaLangString.length() > 0))
    {
      localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramContactBindedHolder.jdField_b_of_type_JavaLangString);
      if (localBitmap != null) {
        paramContactBindedHolder.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      }
    }
    if ((paramContactBindedHolder.jdField_c_of_type_JavaLangString != null) && (paramContactBindedHolder.jdField_c_of_type_JavaLangString.length() > 0))
    {
      localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramContactBindedHolder.jdField_c_of_type_JavaLangString);
      if (localBitmap != null) {
        paramContactBindedHolder.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      }
    }
    if ((paramContactBindedHolder.jdField_d_of_type_JavaLangString != null) && (paramContactBindedHolder.jdField_d_of_type_JavaLangString.length() > 0))
    {
      localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramContactBindedHolder.jdField_d_of_type_JavaLangString);
      if (localBitmap != null) {
        paramContactBindedHolder.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      }
    }
    if ((paramContactBindedHolder.jdField_e_of_type_JavaLangString != null) && (paramContactBindedHolder.jdField_e_of_type_JavaLangString.length() > 0))
    {
      localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramContactBindedHolder.jdField_e_of_type_JavaLangString);
      if (localBitmap != null) {
        paramContactBindedHolder.jdField_e_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      }
    }
  }
  
  private void b(int paramInt)
  {
    ThreadManager.postImmediately(new SystemMsgListAdapter.1(this, paramInt), null, true);
  }
  
  private boolean b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNewfriendUiViewSystemMsgListView != null) {
      return this.jdField_a_of_type_ComTencentMobileqqNewfriendUiViewSystemMsgListView.a(paramInt);
    }
    return false;
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    if (!a())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTabLayoutStatus.c();
      c();
    }
    if ((NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext)) && (a(paramInt2))) {
      ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).loadConnectionsTabData(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramInt1, this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTabLayoutStatus.jdField_a_of_type_Int);
    }
  }
  
  public int a()
  {
    int i = this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition();
    if (i == 0) {
      return 0;
    }
    return i - 1;
  }
  
  public Bitmap a(int paramInt, String paramString)
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramString, paramInt, true, (byte)0);
    }
    return BaseImageUtil.f();
  }
  
  public TabLayoutStatus a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTabLayoutStatus;
  }
  
  public IFaceDecoder a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    TabLayoutStatus localTabLayoutStatus = this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTabLayoutStatus;
    if (localTabLayoutStatus != null)
    {
      localTabLayoutStatus.b = paramInt2;
      localTabLayoutStatus.jdField_a_of_type_Int = paramInt1;
    }
  }
  
  public void a(long paramLong)
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null)
    {
      localHandler.removeMessages(1);
      localHandler.sendEmptyMessageDelayed(1, paramLong);
    }
  }
  
  public void a(NewFriendBaseBuilder paramNewFriendBaseBuilder)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (localList.size() > 0)) {
      this.jdField_a_of_type_JavaUtilList.remove(paramNewFriendBaseBuilder);
    }
  }
  
  public boolean a()
  {
    int i = b();
    Iterator localIterator = ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getConnectionsTabInfoListLocal(this.jdField_a_of_type_ComTencentCommonAppAppInterface).iterator();
    while (localIterator.hasNext()) {
      if (((ConnectionsTabInfo)localIterator.next()).jdField_a_of_type_Int == i) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).isMayKnowConnectionsUserClosed(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    boolean bool1 = true;
    if (paramInt == 23) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (paramInt == 0)
    {
      if (!bool2) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  public void ac_()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SystemMsgListAdapter", 2, "onMayKnowStatesChanged");
    }
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null)
    {
      localHandler.removeMessages(2);
      localHandler.sendEmptyMessageDelayed(2, 200L);
      localHandler.removeMessages(1);
      localHandler.sendEmptyMessageDelayed(1, 2000L);
    }
  }
  
  public int b()
  {
    TabLayoutStatus localTabLayoutStatus = this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTabLayoutStatus;
    if (localTabLayoutStatus != null) {
      return localTabLayoutStatus.jdField_a_of_type_Int;
    }
    return -1;
  }
  
  public void b()
  {
    c();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onConnectionTabSelected tabId : ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", position =");
      localStringBuilder.append(paramInt2);
      QLog.i("SystemMsgListAdapter", 2, localStringBuilder.toString());
    }
    a(paramInt1, paramInt2);
    if (this.jdField_a_of_type_ComTencentMobileqqNewfriendUiViewSystemMsgListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqNewfriendUiViewSystemMsgListView.setStickHeadSelection(paramInt2);
    }
    a(0L);
  }
  
  public void b(long paramLong)
  {
    if (paramLong == 0L) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        if ((localLong != null) && (localLong.longValue() == paramLong))
        {
          bool = true;
          break label70;
        }
      }
    }
    boolean bool = false;
    label70:
    if (bool) {
      c();
    }
    if (QLog.isColorLevel()) {
      QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "checkIfNeedUpdate discussUin: %d needRefresh: %b", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(bool) }));
    }
  }
  
  public int c()
  {
    TabLayoutStatus localTabLayoutStatus = this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTabLayoutStatus;
    if (localTabLayoutStatus != null) {
      return localTabLayoutStatus.b;
    }
    return -1;
  }
  
  public void c()
  {
    a(400L);
  }
  
  public void d()
  {
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i).getTag();
      if ((localObject instanceof SystemMsgItemBuilder.SystemMsgItemHolder))
      {
        SystemMsgItemBuilder.a((SystemMsgItemBuilder.SystemMsgItemHolder)localObject, this, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      }
      else if ((localObject instanceof ContactMatchBuilder.ContactMatchHolder))
      {
        localObject = (ContactMatchBuilder.ContactMatchHolder)localObject;
        ((ContactMatchBuilder.ContactMatchHolder)localObject).jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(a(11, ((ContactMatchBuilder.ContactMatchHolder)localObject).jdField_f_of_type_JavaLangString));
      }
      else if ((localObject instanceof MayKnowRecommendBuilder.MayKnowRecommendHolder))
      {
        localObject = (MayKnowRecommendBuilder.MayKnowRecommendHolder)localObject;
        ((MayKnowRecommendBuilder.MayKnowRecommendHolder)localObject).jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(a(1, ((MayKnowRecommendBuilder.MayKnowRecommendHolder)localObject).jdField_f_of_type_JavaLangString));
      }
      else if ((localObject instanceof PhoneContactAddBuilder.PhoneContactAddHolder))
      {
        localObject = (PhoneContactAddBuilder.PhoneContactAddHolder)localObject;
        ((PhoneContactAddBuilder.PhoneContactAddHolder)localObject).jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(a(11, ((PhoneContactAddBuilder.PhoneContactAddHolder)localObject).jdField_f_of_type_JavaLangString));
      }
      else if ((localObject instanceof ContactBindedBuilder.ContactBindedHolder))
      {
        localObject = (ContactBindedBuilder.ContactBindedHolder)localObject;
        if ((((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_a_of_type_JavaLangString != null) && (((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_a_of_type_JavaLangString.length() > 0)) {
          ((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(11, ((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_a_of_type_JavaLangString));
        }
        if ((((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_b_of_type_JavaLangString != null) && (((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_b_of_type_JavaLangString.length() > 0)) {
          ((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(a(11, ((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_b_of_type_JavaLangString));
        }
        if ((((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_c_of_type_JavaLangString != null) && (((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_c_of_type_JavaLangString.length() > 0)) {
          ((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(11, ((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_c_of_type_JavaLangString));
        }
        if ((((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_d_of_type_JavaLangString != null) && (((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_d_of_type_JavaLangString.length() > 0)) {
          ((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(a(11, ((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_d_of_type_JavaLangString));
        }
        if ((((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_e_of_type_JavaLangString != null) && (((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_e_of_type_JavaLangString.length() > 0)) {
          ((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_e_of_type_AndroidWidgetImageView.setImageBitmap(a(11, ((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_e_of_type_JavaLangString));
        }
      }
      else if ((localObject instanceof NewFriendVerifyBlockedBuilder.NewFriendVerifyBlockedHolder))
      {
        localObject = (NewFriendVerifyBlockedBuilder.NewFriendVerifyBlockedHolder)localObject;
        ((NewFriendVerifyBlockedBuilder.NewFriendVerifyBlockedHolder)localObject).jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(a(1, ((NewFriendVerifyBlockedBuilder.NewFriendVerifyBlockedHolder)localObject).jdField_f_of_type_JavaLangString));
      }
      i += 1;
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.cancelPendingRequests();
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.pause();
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.resume();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(null);
    this.jdField_a_of_type_ComTencentMobileqqNewfriendApiImplNewFriendServiceImpl.reSetLastSysMsgTotalCount(0);
    this.jdField_a_of_type_ComTencentMobileqqNewfriendApiImplNewFriendServiceImpl.removeListener(this);
    ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).removeListener(this, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(null);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
    NewFriendNotifyPokeMsgHelper.a();
  }
  
  public void g_(int paramInt)
  {
    c();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return new Object();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = ((NewFriendBaseBuilder)getItem(paramInt)).a(paramInt, paramView);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public void h()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("stopVisibleExpose firstVisible: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition());
      ((StringBuilder)localObject).append(" lastvisible: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition());
      QLog.d("SystemMsgListAdapter", 2, ((StringBuilder)localObject).toString());
    }
    if ((getCount() > 0) && (this.jdField_a_of_type_ComTencentWidgetXListView.isShown()))
    {
      int i = this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition();
      while ((i <= this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition()) && (i < getCount()))
      {
        localObject = (NewFriendBaseBuilder)getItem(i);
        if ((localObject instanceof MayKnowRecommendBuilder)) {
          ((MayKnowRecommendBuilder)localObject).c();
        }
        i += 1;
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView;
    if (localObject != null) {
      ((XListView)localObject).removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      b(b());
    } else if (paramMessage.what == 2) {
      notifyDataSetChanged();
    } else if (paramMessage.what == 3) {
      a((NewFriendSlideTabMessage)paramMessage.obj);
    }
    return false;
  }
  
  public void hideMenuPop() {}
  
  public void i()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResume firstVisible: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition());
      ((StringBuilder)localObject).append(" lastvisible: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition());
      QLog.d("SystemMsgListAdapter", 2, ((StringBuilder)localObject).toString());
    }
    if ((getCount() > 0) && (this.jdField_a_of_type_ComTencentWidgetXListView.isShown()))
    {
      int i = this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition();
      while ((i <= this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition()) && (i < getCount()))
      {
        localObject = (NewFriendBaseBuilder)getItem(i);
        if ((localObject instanceof MayKnowRecommendBuilder)) {
          ((MayKnowRecommendBuilder)localObject).b();
        }
        i += 1;
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView;
    if (localObject != null)
    {
      ((XListView)localObject).removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentWidgetXListView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
    }
  }
  
  public void interceptTouchEvent(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler;
    if ((localObject != null) && ((localObject instanceof FlingGestureHandler)))
    {
      localObject = (FlingGestureHandler)localObject;
      if (((FlingGestureHandler)localObject).mTopLayout != null) {
        ((FlingGestureHandler)localObject).mTopLayout.setInterceptTouchFlag(paramBoolean ^ true);
      }
    }
  }
  
  public void j()
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onResume firstVisible: ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition());
      ((StringBuilder)localObject1).append(" lastvisible: ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition());
      QLog.d("SystemMsgListAdapter", 2, ((StringBuilder)localObject1).toString());
    }
    if ((getCount() > 0) && (this.jdField_a_of_type_ComTencentWidgetXListView.isShown()))
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      localObject1 = new ArrayList();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      Object localObject2 = new ArrayList();
      int i = this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition();
      while ((i <= this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition()) && (i < getCount()))
      {
        Object localObject3 = (NewFriendBaseBuilder)getItem(i);
        if ((localObject3 instanceof MayKnowRecommendBuilder))
        {
          localObject3 = (MayKnowRecommendBuilder)localObject3;
          ((ArrayList)localObject1).add(((MayKnowRecommendBuilder)localObject3).b());
          localArrayList1.add(((MayKnowRecommendBuilder)localObject3).a());
          localArrayList2.add(Integer.valueOf(((MayKnowRecommendBuilder)localObject3).b()));
          localArrayList3.add(((MayKnowRecommendBuilder)localObject3).a());
        }
        else if ((localObject3 instanceof NewFriendSlideTabBuilder))
        {
          localObject3 = ((NewFriendSlideTabBuilder)localObject3).a();
          if (localObject3 != null) {
            ((ArrayList)localObject2).addAll((Collection)localObject3);
          }
        }
        i += 1;
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("reportRecommendFrdExpose exp_uins: ");
        ((StringBuilder)localObject2).append(localObject1);
        ((StringBuilder)localObject2).append(" exp_reasons:");
        ((StringBuilder)localObject2).append(localArrayList1);
        ((StringBuilder)localObject2).append(" exp_positions:");
        ((StringBuilder)localObject2).append(localArrayList2);
        ((StringBuilder)localObject2).append(" algh_ids:");
        ((StringBuilder)localObject2).append(localArrayList3);
        QLog.d("SystemMsgListAdapter", 2, ((StringBuilder)localObject2).toString());
      }
      ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).reportRecommendExpose(this.jdField_a_of_type_ComTencentCommonAppAppInterface, b(), (ArrayList)localObject1, localArrayList1, localArrayList2, localArrayList3, 0);
    }
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.jdField_a_of_type_JavaUtilHashtable.put(paramString, paramBitmap);
    }
    if (paramInt1 <= 0)
    {
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        paramString = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1).getTag();
        if (paramString != null) {
          if ((paramString instanceof ContactBindedBuilder.ContactBindedHolder))
          {
            a((ContactBindedBuilder.ContactBindedHolder)paramString);
          }
          else if ((!(paramString instanceof NewFriendSubTitleBuilder.NewFriendSubTitleHolder)) && (!(paramString instanceof NewFriendMoreInfoBuilder.NewFriendMoreInfoHolder)) && (!(paramString instanceof NewFriendBindContactGuideBuilder.MyHolder)) && (!(paramString instanceof NewFriendSlideTabBuilder.NewFriendSildeTabHolder)) && (!(paramString instanceof NewFriendTabInfoBuilder.NewFriendTabInfoHolder)) && (!(paramString instanceof NewFriendTabEmptyBuilder.NewFriendTabEmptyHolder)) && (!(paramString instanceof NewFriendFillAcademicInfoBuilder.NewFriendFillAcademicInfoHolder)) && (!(paramString instanceof NewFriendTabGuideBuilder.NewFriendTabInfoHolder)) && (!(paramString instanceof NewFriendSysEmptyBuilder.NewFriendSysEmptyHolder)))
          {
            paramString = (NewFriendBaseBuilder.NewFriendBaseHolder)paramString;
            if ((paramString.jdField_f_of_type_JavaLangString != null) && (paramString.jdField_f_of_type_JavaLangString.length() > 0))
            {
              paramBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramString.jdField_f_of_type_JavaLangString);
              if (paramBitmap != null) {
                paramString.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
              }
            }
          }
        }
        paramInt1 += 1;
      }
      this.jdField_a_of_type_JavaUtilHashtable.clear();
    }
  }
  
  public void onGetIcon(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((paramInt2 == ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getSizeSmall()) && (paramBitmap != null)) {
      notifyDataSetChanged();
    }
  }
  
  public void updateCurShowRightView(View paramView)
  {
    int j = -1;
    int i = j;
    if (paramView != null)
    {
      paramView = paramView.getTag(-1);
      i = j;
      if ((paramView instanceof Integer)) {
        i = ((Integer)paramView).intValue();
      }
    }
    this.jdField_a_of_type_Int = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter
 * JD-Core Version:    0.7.0.1
 */