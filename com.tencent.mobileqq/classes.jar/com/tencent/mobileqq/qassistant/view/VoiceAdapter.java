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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.qassistant.core.FriendSortHelper;
import com.tencent.mobileqq.qassistant.core.IViewPresenter;
import com.tencent.mobileqq.qassistant.data.CommandInfo;
import com.tencent.mobileqq.qassistant.data.FriendItemInfo;
import com.tencent.mobileqq.qassistant.data.JumpInfo;
import com.tencent.mobileqq.qassistant.data.VoiceItemInfo;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class VoiceAdapter
  extends RecyclerView.Adapter<VoiceAdapter.VoiceViewHolder>
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IViewPresenter jdField_a_of_type_ComTencentMobileqqQassistantCoreIViewPresenter;
  private CommandInfo jdField_a_of_type_ComTencentMobileqqQassistantDataCommandInfo;
  private List<VoiceItemInfo> jdField_a_of_type_JavaUtilList;
  
  public VoiceAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramContext = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramContext instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramContext);
    }
  }
  
  private VoiceItemInfo a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (VoiceItemInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantDataCommandInfo != null) {
      return this.jdField_a_of_type_ComTencentMobileqqQassistantDataCommandInfo.jdField_a_of_type_Int;
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
      if (QLog.isColorLevel()) {
        QLog.d("VoiceAdapter", 2, "onCreateViewHolder viewType is error: " + paramInt);
      }
      return new VoiceAdapter.VoiceViewHolder(this, 0, VoiceViewUtils.a(this.jdField_a_of_type_AndroidContentContext));
    case 0: 
      return new VoiceAdapter.VoiceViewHolder(this, paramInt, VoiceViewUtils.a(this.jdField_a_of_type_AndroidContentContext));
    case 1: 
      paramViewGroup = VoiceViewUtils.a(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
      paramViewGroup.setOnClickListener(this);
      return new VoiceAdapter.VoiceViewHolder(this, paramInt, paramViewGroup);
    case 2: 
      return new VoiceAdapter.VoiceViewHolder(this, paramInt, VoiceViewUtils.b(this.jdField_a_of_type_AndroidContentContext));
    case 3: 
      return new VoiceAdapter.VoiceViewHolder(this, paramInt, VoiceViewUtils.c(this.jdField_a_of_type_AndroidContentContext));
    case 4: 
      return new VoiceAdapter.VoiceViewHolder(this, paramInt, VoiceViewUtils.d(this.jdField_a_of_type_AndroidContentContext));
    case 5: 
      paramViewGroup = VoiceViewUtils.b(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
      paramViewGroup.findViewById(2131381755).setOnClickListener(this);
      return new VoiceAdapter.VoiceViewHolder(this, paramInt, paramViewGroup);
    case 6: 
      paramViewGroup = VoiceViewUtils.c(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
      paramViewGroup.findViewById(2131364747).setOnClickListener(this);
      paramViewGroup.findViewById(2131364742).setOnClickListener(this);
      return new VoiceAdapter.VoiceViewHolder(this, paramInt, paramViewGroup);
    case 7: 
      return new VoiceAdapter.VoiceViewHolder(this, paramInt, VoiceViewUtils.a(this.jdField_a_of_type_AndroidContentContext));
    case 8: 
      return new VoiceAdapter.VoiceViewHolder(this, paramInt, VoiceViewUtils.e(this.jdField_a_of_type_AndroidContentContext));
    }
    paramViewGroup = VoiceViewUtils.d(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
    paramViewGroup.setOnClickListener(this);
    return new VoiceAdapter.VoiceViewHolder(this, paramInt, paramViewGroup);
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
    if (paramList == null) {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceAdapter", 2, "setData list is empty");
      }
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_JavaUtilList == null) || (!paramList.isEmpty())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("VoiceAdapter", 2, "setData do not need refresh");
    return;
    this.jdField_a_of_type_ComTencentMobileqqQassistantDataCommandInfo = paramCommandInfo;
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public void a(@NonNull VoiceAdapter.VoiceViewHolder paramVoiceViewHolder, int paramInt)
  {
    Object localObject2 = a(paramInt);
    if (localObject2 != null) {
      switch (paramVoiceViewHolder.jdField_a_of_type_Int)
      {
      case 1: 
      default: 
        if (QLog.isColorLevel()) {
          QLog.d("VoiceAdapter", 2, "onBindViewHolder viewType is error: " + paramVoiceViewHolder.jdField_a_of_type_Int);
        }
        break;
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return;
                      } while (!(paramVoiceViewHolder.jdField_a_of_type_AndroidViewView instanceof TextView));
                      ((TextView)paramVoiceViewHolder.jdField_a_of_type_AndroidViewView).setText(((VoiceItemInfo)localObject2).jdField_a_of_type_JavaLangString);
                      return;
                    } while (!(paramVoiceViewHolder.jdField_a_of_type_AndroidViewView instanceof TextView));
                    ((TextView)paramVoiceViewHolder.jdField_a_of_type_AndroidViewView).setText(((VoiceItemInfo)localObject2).jdField_a_of_type_JavaLangString);
                    return;
                  } while (!(paramVoiceViewHolder.jdField_a_of_type_AndroidViewView instanceof TextView));
                  ((TextView)paramVoiceViewHolder.jdField_a_of_type_AndroidViewView).setText(((VoiceItemInfo)localObject2).jdField_a_of_type_JavaLangString);
                  return;
                } while (!(paramVoiceViewHolder.jdField_a_of_type_AndroidViewView instanceof TextView));
                ((TextView)paramVoiceViewHolder.jdField_a_of_type_AndroidViewView).setText(((VoiceItemInfo)localObject2).jdField_a_of_type_JavaLangString);
                return;
              } while (paramVoiceViewHolder.jdField_a_of_type_AndroidViewView == null);
              paramVoiceViewHolder = (TextView)paramVoiceViewHolder.jdField_a_of_type_AndroidViewView.findViewById(2131381755);
            } while (paramVoiceViewHolder == null);
            paramVoiceViewHolder.setText(((VoiceItemInfo)localObject2).jdField_a_of_type_JavaLangString);
            return;
          } while (paramVoiceViewHolder.jdField_a_of_type_AndroidViewView == null);
          localObject2 = (TextView)paramVoiceViewHolder.jdField_a_of_type_AndroidViewView.findViewById(2131364742);
          localObject3 = (TextView)paramVoiceViewHolder.jdField_a_of_type_AndroidViewView.findViewById(2131364747);
          if (a() == 5)
          {
            localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131720593);
            paramVoiceViewHolder = this.jdField_a_of_type_AndroidContentContext.getString(2131720621);
          }
          for (;;)
          {
            if (localObject2 != null)
            {
              ((TextView)localObject2).setText((CharSequence)localObject1);
              ((TextView)localObject2).setVisibility(0);
            }
            if (localObject3 != null)
            {
              ((TextView)localObject3).setText(paramVoiceViewHolder);
              ((TextView)localObject3).setVisibility(0);
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqQassistantDataCommandInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqQassistantDataCommandInfo.jdField_a_of_type_ComTencentMobileqqQassistantDataJumpInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqQassistantDataCommandInfo.jdField_a_of_type_ComTencentMobileqqQassistantDataJumpInfo.c))
            {
              if (localObject2 != null) {
                ((TextView)localObject2).setText(this.jdField_a_of_type_AndroidContentContext.getString(2131720594));
              }
              if (localObject3 != null) {
                ((TextView)localObject3).setText(this.jdField_a_of_type_AndroidContentContext.getString(2131720596));
              }
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqQassistantDataCommandInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqQassistantDataCommandInfo.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_ComTencentMobileqqQassistantDataCommandInfo.jdField_a_of_type_JavaUtilList.size() != 1)) {
              break;
            }
            paramVoiceViewHolder = (FriendItemInfo)this.jdField_a_of_type_ComTencentMobileqqQassistantDataCommandInfo.jdField_a_of_type_JavaUtilList.get(0);
            if ((paramVoiceViewHolder.jdField_a_of_type_Boolean) || (paramVoiceViewHolder.jdField_a_of_type_Float < FriendSortHelper.a()) || (localObject3 == null)) {
              break;
            }
            ((TextView)localObject3).setVisibility(8);
            return;
            if (a() == 6)
            {
              localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131720619);
              paramVoiceViewHolder = this.jdField_a_of_type_AndroidContentContext.getString(2131720620);
            }
            else
            {
              localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131720595);
              paramVoiceViewHolder = this.jdField_a_of_type_AndroidContentContext.getString(2131720597);
            }
          }
        } while (((VoiceItemInfo)localObject2).jdField_a_of_type_Int != 7);
        paramVoiceViewHolder.jdField_a_of_type_AndroidViewView.setLayoutParams(new ViewGroup.LayoutParams(-1, ScreenUtil.dip2px(((VoiceItemInfo)localObject2).b)));
        return;
      } while (!(paramVoiceViewHolder.jdField_a_of_type_AndroidViewView instanceof TextView));
      ((TextView)paramVoiceViewHolder.jdField_a_of_type_AndroidViewView).setText(((VoiceItemInfo)localObject2).jdField_a_of_type_JavaLangString);
      return;
    } while ((paramVoiceViewHolder.jdField_a_of_type_AndroidViewView == null) || (((VoiceItemInfo)localObject2).jdField_a_of_type_ComTencentMobileqqQassistantDataFriendItemInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
    Object localObject3 = (ImageView)paramVoiceViewHolder.jdField_a_of_type_AndroidViewView.findViewById(2131367569);
    TextView localTextView1 = (TextView)paramVoiceViewHolder.jdField_a_of_type_AndroidViewView.findViewById(2131367587);
    TextView localTextView2 = (TextView)paramVoiceViewHolder.jdField_a_of_type_AndroidViewView.findViewById(2131367570);
    Object localObject1 = null;
    if (((VoiceItemInfo)localObject2).jdField_a_of_type_ComTencentMobileqqQassistantDataFriendItemInfo.jdField_a_of_type_Int == 0)
    {
      localObject1 = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, ((VoiceItemInfo)localObject2).jdField_a_of_type_ComTencentMobileqqQassistantDataFriendItemInfo.jdField_a_of_type_JavaLangString);
      if (localObject1 != null) {
        break label784;
      }
      ((ImageView)localObject3).setImageBitmap(ImageUtil.c());
    }
    for (;;)
    {
      localTextView1.setText(((VoiceItemInfo)localObject2).jdField_a_of_type_ComTencentMobileqqQassistantDataFriendItemInfo.b);
      localTextView2.setText(((VoiceItemInfo)localObject2).jdField_a_of_type_ComTencentMobileqqQassistantDataFriendItemInfo.c);
      paramVoiceViewHolder.jdField_a_of_type_AndroidViewView.setTag(((VoiceItemInfo)localObject2).jdField_a_of_type_ComTencentMobileqqQassistantDataFriendItemInfo);
      return;
      if (1 != ((VoiceItemInfo)localObject2).jdField_a_of_type_ComTencentMobileqqQassistantDataFriendItemInfo.jdField_a_of_type_Int) {
        break;
      }
      localObject1 = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, ((VoiceItemInfo)localObject2).jdField_a_of_type_ComTencentMobileqqQassistantDataFriendItemInfo.jdField_a_of_type_JavaLangString);
      break;
      label784:
      ((ImageView)localObject3).setImageDrawable((Drawable)localObject1);
    }
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
    {
      VoiceItemInfo localVoiceItemInfo = (VoiceItemInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (localVoiceItemInfo != null) {
        return localVoiceItemInfo.jdField_a_of_type_Int;
      }
    }
    return super.getItemViewType(paramInt);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqQassistantCoreIViewPresenter != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqQassistantCoreIViewPresenter.a();
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqQassistantCoreIViewPresenter != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqQassistantCoreIViewPresenter.a(true);
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqQassistantCoreIViewPresenter != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqQassistantCoreIViewPresenter.a(false);
            continue;
            if ((this.jdField_a_of_type_ComTencentMobileqqQassistantCoreIViewPresenter != null) && (this.jdField_a_of_type_ComTencentMobileqqQassistantDataCommandInfo != null))
            {
              this.jdField_a_of_type_ComTencentMobileqqQassistantCoreIViewPresenter.a(this.jdField_a_of_type_ComTencentMobileqqQassistantDataCommandInfo.jdField_a_of_type_Int);
              continue;
              if ((this.jdField_a_of_type_ComTencentMobileqqQassistantCoreIViewPresenter != null) && ((paramView.getTag() instanceof FriendItemInfo)))
              {
                FriendItemInfo localFriendItemInfo = (FriendItemInfo)paramView.getTag();
                this.jdField_a_of_type_ComTencentMobileqqQassistantCoreIViewPresenter.a(localFriendItemInfo);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.view.VoiceAdapter
 * JD-Core Version:    0.7.0.1
 */