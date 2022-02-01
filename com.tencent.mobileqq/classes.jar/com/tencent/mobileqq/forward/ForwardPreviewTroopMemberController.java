package com.tencent.mobileqq.forward;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberListHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class ForwardPreviewTroopMemberController
  extends ForwardPreviewBaseController
{
  public static int a = 0;
  public static int b = 1;
  private GridLayoutManager jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager;
  private RecyclerView.OnScrollListener jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener = new ForwardPreviewTroopMemberController.4(this);
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private DecodeTaskCompletionListener jdField_a_of_type_ComTencentMobileqqAvatarListenerDecodeTaskCompletionListener = new ForwardPreviewTroopMemberController.3(this);
  private ForwardPreviewTroopMemberController.TroopMemberRecyclerViewAdapter jdField_a_of_type_ComTencentMobileqqForwardForwardPreviewTroopMemberController$TroopMemberRecyclerViewAdapter;
  private TroopObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new ForwardPreviewTroopMemberController.2(this);
  private String jdField_a_of_type_JavaLangString = "";
  
  public ForwardPreviewTroopMemberController(QQCustomDialog paramQQCustomDialog)
  {
    super(paramQQCustomDialog);
  }
  
  private void b(String paramString)
  {
    ThreadManager.getFileThreadHandler().post(new ForwardPreviewTroopMemberController.1(this, paramString));
  }
  
  protected int a()
  {
    return 380;
  }
  
  protected View a()
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView == null)
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = new RecyclerView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = new GridLayoutManager(this.jdField_a_of_type_AndroidContentContext, 5);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      int i = AIOUtils.b(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localLayoutParams.rightMargin = i;
      localLayoutParams.leftMargin = i;
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOverScrollMode(2);
    }
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("bindData title: ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" uin: ");
    localStringBuilder.append(paramString2);
    QLog.i("Forward.Preview.Dialog", 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramQQAppInterface = "";
    }
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface;
    a(paramString1);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this.jdField_a_of_type_ComTencentMobileqqAvatarListenerDecodeTaskCompletionListener);
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardPreviewTroopMemberController$TroopMemberRecyclerViewAdapter = new ForwardPreviewTroopMemberController.TroopMemberRecyclerViewAdapter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqForwardForwardPreviewTroopMemberController$TroopMemberRecyclerViewAdapter);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener);
    d();
    if (paramInt == 1)
    {
      ((ITroopMemberListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LIST_HANDLER)).a(this.jdField_a_of_type_JavaLangString);
      return;
    }
    if (paramInt == 3000) {
      b(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  protected void c()
  {
    QLog.i("Forward.Preview.Dialog", 1, "onDestroy.");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    IFaceDecoder localIFaceDecoder = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localIFaceDecoder != null) {
      localIFaceDecoder.destory();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPreviewTroopMemberController
 * JD-Core Version:    0.7.0.1
 */