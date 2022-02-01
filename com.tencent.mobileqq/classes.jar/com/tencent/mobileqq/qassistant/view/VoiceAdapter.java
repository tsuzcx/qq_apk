package com.tencent.mobileqq.qassistant.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.qassistant.core.FriendSortHelper;
import com.tencent.mobileqq.qassistant.core.IViewPresenter;
import com.tencent.mobileqq.qassistant.data.CommandInfo;
import com.tencent.mobileqq.qassistant.data.FriendItemInfo;
import com.tencent.mobileqq.qassistant.data.JumpInfo;
import com.tencent.mobileqq.qassistant.data.VoiceItemInfo;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.app.MobileQQ;

public class VoiceAdapter
  extends RecyclerView.Adapter<VoiceAdapter.VoiceViewHolder>
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private IViewPresenter jdField_a_of_type_ComTencentMobileqqQassistantCoreIViewPresenter;
  private CommandInfo jdField_a_of_type_ComTencentMobileqqQassistantDataCommandInfo;
  private List<VoiceItemInfo> jdField_a_of_type_JavaUtilList;
  
  public VoiceAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramContext = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((paramContext instanceof AppInterface)) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)paramContext);
    }
  }
  
  private VoiceItemInfo a(int paramInt)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (paramInt >= 0) && (paramInt < localList.size())) {
      return (VoiceItemInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public int a()
  {
    CommandInfo localCommandInfo = this.jdField_a_of_type_ComTencentMobileqqQassistantDataCommandInfo;
    if (localCommandInfo != null) {
      return localCommandInfo.jdField_a_of_type_Int;
    }
    return -1;
  }
  
  public CommandInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQassistantDataCommandInfo;
  }
  
  public VoiceAdapter.VoiceViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel())
      {
        paramViewGroup = new StringBuilder();
        paramViewGroup.append("onCreateViewHolder viewType is error: ");
        paramViewGroup.append(paramInt);
        QLog.d("VoiceAdapter", 2, paramViewGroup.toString());
      }
      break;
    case 9: 
      paramViewGroup = VoiceViewUtils.d(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
      paramViewGroup.setOnClickListener(this);
      return new VoiceAdapter.VoiceViewHolder(this, paramInt, paramViewGroup);
    case 8: 
      return new VoiceAdapter.VoiceViewHolder(this, paramInt, VoiceViewUtils.e(this.jdField_a_of_type_AndroidContentContext));
    case 7: 
      return new VoiceAdapter.VoiceViewHolder(this, paramInt, VoiceViewUtils.a(this.jdField_a_of_type_AndroidContentContext));
    case 6: 
      paramViewGroup = VoiceViewUtils.c(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
      paramViewGroup.findViewById(2131364634).setOnClickListener(this);
      paramViewGroup.findViewById(2131364631).setOnClickListener(this);
      return new VoiceAdapter.VoiceViewHolder(this, paramInt, paramViewGroup);
    case 5: 
      paramViewGroup = VoiceViewUtils.b(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
      paramViewGroup.findViewById(2131380985).setOnClickListener(this);
      return new VoiceAdapter.VoiceViewHolder(this, paramInt, paramViewGroup);
    case 4: 
      return new VoiceAdapter.VoiceViewHolder(this, paramInt, VoiceViewUtils.d(this.jdField_a_of_type_AndroidContentContext));
    case 3: 
      return new VoiceAdapter.VoiceViewHolder(this, paramInt, VoiceViewUtils.c(this.jdField_a_of_type_AndroidContentContext));
    case 2: 
      return new VoiceAdapter.VoiceViewHolder(this, paramInt, VoiceViewUtils.b(this.jdField_a_of_type_AndroidContentContext));
    case 1: 
      paramViewGroup = VoiceViewUtils.a(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
      paramViewGroup.setOnClickListener(this);
      return new VoiceAdapter.VoiceViewHolder(this, paramInt, paramViewGroup);
    case 0: 
      return new VoiceAdapter.VoiceViewHolder(this, paramInt, VoiceViewUtils.a(this.jdField_a_of_type_AndroidContentContext));
    }
    return new VoiceAdapter.VoiceViewHolder(this, 0, VoiceViewUtils.a(this.jdField_a_of_type_AndroidContentContext));
  }
  
  public List<VoiceItemInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(IViewPresenter paramIViewPresenter)
  {
    this.jdField_a_of_type_ComTencentMobileqqQassistantCoreIViewPresenter = paramIViewPresenter;
  }
  
  public void a(CommandInfo paramCommandInfo, List<VoiceItemInfo> paramList)
  {
    if (paramList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceAdapter", 2, "setData list is empty");
      }
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceAdapter", 2, "setData do not need refresh");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqQassistantDataCommandInfo = paramCommandInfo;
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public void a(@NonNull VoiceAdapter.VoiceViewHolder paramVoiceViewHolder, int paramInt)
  {
    Object localObject2 = a(paramInt);
    if (localObject2 != null)
    {
      paramInt = paramVoiceViewHolder.jdField_a_of_type_Int;
      if (paramInt != 0)
      {
        Object localObject1;
        Object localObject3;
        switch (paramInt)
        {
        default: 
          if (!QLog.isColorLevel()) {
            break;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onBindViewHolder viewType is error: ");
          ((StringBuilder)localObject1).append(paramVoiceViewHolder.jdField_a_of_type_Int);
          QLog.d("VoiceAdapter", 2, ((StringBuilder)localObject1).toString());
          return;
        case 9: 
          if ((paramVoiceViewHolder.jdField_a_of_type_AndroidViewView == null) || (((VoiceItemInfo)localObject2).jdField_a_of_type_ComTencentMobileqqQassistantDataFriendItemInfo == null) || (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null)) {
            break;
          }
          localObject3 = (ImageView)paramVoiceViewHolder.jdField_a_of_type_AndroidViewView.findViewById(2131367327);
          TextView localTextView1 = (TextView)paramVoiceViewHolder.jdField_a_of_type_AndroidViewView.findViewById(2131367345);
          TextView localTextView2 = (TextView)paramVoiceViewHolder.jdField_a_of_type_AndroidViewView.findViewById(2131367328);
          localObject1 = null;
          if (((VoiceItemInfo)localObject2).jdField_a_of_type_ComTencentMobileqqQassistantDataFriendItemInfo.jdField_a_of_type_Int == 0) {
            localObject1 = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentCommonAppAppInterface, 1, ((VoiceItemInfo)localObject2).jdField_a_of_type_ComTencentMobileqqQassistantDataFriendItemInfo.jdField_a_of_type_JavaLangString);
          } else if (1 == ((VoiceItemInfo)localObject2).jdField_a_of_type_ComTencentMobileqqQassistantDataFriendItemInfo.jdField_a_of_type_Int) {
            localObject1 = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentCommonAppAppInterface, 4, ((VoiceItemInfo)localObject2).jdField_a_of_type_ComTencentMobileqqQassistantDataFriendItemInfo.jdField_a_of_type_JavaLangString);
          }
          if (localObject1 == null) {
            ((ImageView)localObject3).setImageBitmap(BaseImageUtil.f());
          } else {
            ((ImageView)localObject3).setImageDrawable((Drawable)localObject1);
          }
          localTextView1.setText(((VoiceItemInfo)localObject2).jdField_a_of_type_ComTencentMobileqqQassistantDataFriendItemInfo.b);
          localTextView2.setText(((VoiceItemInfo)localObject2).jdField_a_of_type_ComTencentMobileqqQassistantDataFriendItemInfo.c);
          paramVoiceViewHolder.jdField_a_of_type_AndroidViewView.setTag(((VoiceItemInfo)localObject2).jdField_a_of_type_ComTencentMobileqqQassistantDataFriendItemInfo);
          return;
        case 8: 
          if (!(paramVoiceViewHolder.jdField_a_of_type_AndroidViewView instanceof TextView)) {
            break;
          }
          ((TextView)paramVoiceViewHolder.jdField_a_of_type_AndroidViewView).setText(((VoiceItemInfo)localObject2).jdField_a_of_type_JavaLangString);
          return;
        case 7: 
          if (((VoiceItemInfo)localObject2).jdField_a_of_type_Int != 7) {
            break;
          }
          paramVoiceViewHolder.jdField_a_of_type_AndroidViewView.setLayoutParams(new ViewGroup.LayoutParams(-1, ScreenUtil.dip2px(((VoiceItemInfo)localObject2).b)));
          return;
        case 6: 
          if (paramVoiceViewHolder.jdField_a_of_type_AndroidViewView == null) {
            break;
          }
          localObject3 = (TextView)paramVoiceViewHolder.jdField_a_of_type_AndroidViewView.findViewById(2131364631);
          localObject2 = (TextView)paramVoiceViewHolder.jdField_a_of_type_AndroidViewView.findViewById(2131364634);
          if (a() == 5)
          {
            paramVoiceViewHolder = this.jdField_a_of_type_AndroidContentContext.getString(2131695328);
            localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131720336);
          }
          else if (a() == 6)
          {
            paramVoiceViewHolder = this.jdField_a_of_type_AndroidContentContext.getString(2131720334);
            localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131720335);
          }
          else
          {
            paramVoiceViewHolder = this.jdField_a_of_type_AndroidContentContext.getString(2131720310);
            localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131720312);
          }
          if (localObject3 != null)
          {
            ((TextView)localObject3).setText(paramVoiceViewHolder);
            ((TextView)localObject3).setVisibility(0);
          }
          if (localObject2 != null)
          {
            ((TextView)localObject2).setText((CharSequence)localObject1);
            ((TextView)localObject2).setVisibility(0);
          }
          paramVoiceViewHolder = this.jdField_a_of_type_ComTencentMobileqqQassistantDataCommandInfo;
          if ((paramVoiceViewHolder != null) && (paramVoiceViewHolder.jdField_a_of_type_ComTencentMobileqqQassistantDataJumpInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqQassistantDataCommandInfo.jdField_a_of_type_ComTencentMobileqqQassistantDataJumpInfo.c))
          {
            if (localObject3 != null) {
              ((TextView)localObject3).setText(this.jdField_a_of_type_AndroidContentContext.getString(2131720309));
            }
            if (localObject2 != null) {
              ((TextView)localObject2).setText(this.jdField_a_of_type_AndroidContentContext.getString(2131720311));
            }
          }
          paramVoiceViewHolder = this.jdField_a_of_type_ComTencentMobileqqQassistantDataCommandInfo;
          if ((paramVoiceViewHolder == null) || (paramVoiceViewHolder.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_ComTencentMobileqqQassistantDataCommandInfo.jdField_a_of_type_JavaUtilList.size() != 1)) {
            break;
          }
          paramVoiceViewHolder = (FriendItemInfo)this.jdField_a_of_type_ComTencentMobileqqQassistantDataCommandInfo.jdField_a_of_type_JavaUtilList.get(0);
          if ((paramVoiceViewHolder.jdField_a_of_type_Boolean) || (paramVoiceViewHolder.jdField_a_of_type_Float < FriendSortHelper.a()) || (localObject2 == null)) {
            break;
          }
          ((TextView)localObject2).setVisibility(8);
          return;
        case 5: 
          if (paramVoiceViewHolder.jdField_a_of_type_AndroidViewView == null) {
            break;
          }
          paramVoiceViewHolder = (TextView)paramVoiceViewHolder.jdField_a_of_type_AndroidViewView.findViewById(2131380985);
          if (paramVoiceViewHolder == null) {
            break;
          }
          paramVoiceViewHolder.setText(((VoiceItemInfo)localObject2).jdField_a_of_type_JavaLangString);
          return;
        case 4: 
          if (!(paramVoiceViewHolder.jdField_a_of_type_AndroidViewView instanceof TextView)) {
            break;
          }
          ((TextView)paramVoiceViewHolder.jdField_a_of_type_AndroidViewView).setText(((VoiceItemInfo)localObject2).jdField_a_of_type_JavaLangString);
          return;
        case 3: 
          if (!(paramVoiceViewHolder.jdField_a_of_type_AndroidViewView instanceof TextView)) {
            break;
          }
          ((TextView)paramVoiceViewHolder.jdField_a_of_type_AndroidViewView).setText(((VoiceItemInfo)localObject2).jdField_a_of_type_JavaLangString);
          return;
        case 2: 
          if (!(paramVoiceViewHolder.jdField_a_of_type_AndroidViewView instanceof TextView)) {
            break;
          }
          ((TextView)paramVoiceViewHolder.jdField_a_of_type_AndroidViewView).setText(((VoiceItemInfo)localObject2).jdField_a_of_type_JavaLangString);
          return;
        }
      }
      else if ((paramVoiceViewHolder.jdField_a_of_type_AndroidViewView instanceof TextView))
      {
        ((TextView)paramVoiceViewHolder.jdField_a_of_type_AndroidViewView).setText(((VoiceItemInfo)localObject2).jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public int getItemCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public int getItemViewType(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (paramInt < ((List)localObject).size()))
    {
      localObject = (VoiceItemInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (localObject != null) {
        return ((VoiceItemInfo)localObject).jdField_a_of_type_Int;
      }
    }
    return super.getItemViewType(paramInt);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if (i == 2131380834)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqQassistantCoreIViewPresenter;
      if (localObject != null) {
        ((IViewPresenter)localObject).a();
      }
    }
    else if (i == 2131364634)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqQassistantCoreIViewPresenter;
      if (localObject != null) {
        ((IViewPresenter)localObject).a(true);
      }
    }
    else if (i == 2131364631)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqQassistantCoreIViewPresenter;
      if (localObject != null) {
        ((IViewPresenter)localObject).a(false);
      }
    }
    else if (i == 2131380985)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqQassistantCoreIViewPresenter;
      if (localObject != null)
      {
        CommandInfo localCommandInfo = this.jdField_a_of_type_ComTencentMobileqqQassistantDataCommandInfo;
        if (localCommandInfo != null) {
          ((IViewPresenter)localObject).a(localCommandInfo.jdField_a_of_type_Int);
        }
      }
    }
    else if ((i == 2131367331) && (this.jdField_a_of_type_ComTencentMobileqqQassistantCoreIViewPresenter != null) && ((paramView.getTag() instanceof FriendItemInfo)))
    {
      localObject = (FriendItemInfo)paramView.getTag();
      this.jdField_a_of_type_ComTencentMobileqqQassistantCoreIViewPresenter.a((FriendItemInfo)localObject);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.view.VoiceAdapter
 * JD-Core Version:    0.7.0.1
 */