package com.tencent.mobileqq.qassistant.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qassistant.core.IViewPresenter;
import com.tencent.mobileqq.qassistant.data.CommandInfo;
import com.tencent.mobileqq.qassistant.data.FriendItemInfo;
import com.tencent.mobileqq.qassistant.data.VoiceItemInfo;
import com.tencent.mobileqq.qassistant.listener.IPanelDragListener;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class VoiceView
  implements IViewPresenter, IPanelDragListener
{
  private Context jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RecyclerView jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView;
  private IViewPresenter jdField_a_of_type_ComTencentMobileqqQassistantCoreIViewPresenter;
  private VoiceAdapter jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceAdapter;
  private VoicePanelSlideContainer jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelSlideContainer;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public VoiceView(IViewPresenter paramIViewPresenter)
  {
    this.jdField_a_of_type_ComTencentMobileqqQassistantCoreIViewPresenter = paramIViewPresenter;
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558746, null);
    this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelSlideContainer = ((VoicePanelSlideContainer)this.jdField_a_of_type_AndroidViewView.findViewById(2131378243));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372861));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372862));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363070));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131378242);
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381752));
    d();
    e();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new VoiceView.1(this));
  }
  
  private void c(boolean paramBoolean)
  {
    View localView;
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      localView = this.jdField_b_of_type_AndroidViewView;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 4)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  private void d()
  {
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(this.jdField_a_of_type_AndroidContentContext, 1, false);
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceAdapter = new VoiceAdapter(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceAdapter.a(this);
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceAdapter);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelSlideContainer != null) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelSlideContainer.setPanelDragListener(this);
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceAdapter != null) {
      return this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceAdapter.a();
    }
    return 3;
  }
  
  public View a()
  {
    c();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public CommandInfo a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceAdapter != null) {
      return this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceAdapter.a();
    }
    return null;
  }
  
  public List<VoiceItemInfo> a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceAdapter != null) {
      return this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceAdapter.a();
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantCoreIViewPresenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantCoreIViewPresenter.a();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantCoreIViewPresenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantCoreIViewPresenter.a(paramInt);
    }
  }
  
  public void a(CommandInfo paramCommandInfo, List<VoiceItemInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceView", 2, "showCommandView infoList is empty");
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceAdapter == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceAdapter.a(paramCommandInfo, paramList);
  }
  
  public void a(FriendItemInfo paramFriendItemInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantCoreIViewPresenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantCoreIViewPresenter.a(paramFriendItemInfo);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantCoreIViewPresenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantCoreIViewPresenter.a(paramBoolean);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelSlideContainer != null) && (this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelSlideContainer.a());
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoiceAdapter = null;
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidViewView = null;
  }
  
  public void b(boolean paramBoolean)
  {
    c(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.view.VoiceView
 * JD-Core Version:    0.7.0.1
 */