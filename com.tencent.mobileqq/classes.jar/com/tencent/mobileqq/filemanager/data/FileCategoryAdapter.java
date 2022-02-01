package com.tencent.mobileqq.filemanager.data;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class FileCategoryAdapter
  extends BaseAdapter
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private List<FileCategoryEntity> jdField_a_of_type_JavaUtilList;
  
  public FileCategoryAdapter(BaseFileAssistantActivity paramBaseFileAssistantActivity, List<FileCategoryEntity> paramList, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = paramBaseFileAssistantActivity;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (((FileCategoryEntity)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int == 0) {
      return 0;
    }
    if (((FileCategoryEntity)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int == 3) {
      return 3;
    }
    if (((FileCategoryEntity)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int == 2) {
      return 2;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    FileCategoryEntity localFileCategoryEntity = (FileCategoryEntity)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject1 = null;
    Object localObject2;
    if (localFileCategoryEntity == null)
    {
      localObject2 = paramView;
    }
    else
    {
      Object localObject3;
      if (paramView == null)
      {
        localObject2 = new FileCategoryAdapter.ItemHolder(this);
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(localFileCategoryEntity.jdField_b_of_type_Int, paramViewGroup, false);
        localObject3 = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramView).d(30).a();
        ((View)localObject3).setTag(localObject2);
        if ((localFileCategoryEntity.jdField_a_of_type_Int != 0) && (localFileCategoryEntity.jdField_a_of_type_Int != 3))
        {
          if (localFileCategoryEntity.jdField_a_of_type_Int != 1)
          {
            paramView = (View)localObject3;
            localObject1 = localObject2;
            if (localFileCategoryEntity.jdField_a_of_type_Int != 4) {}
          }
          else
          {
            ((FileCategoryAdapter.ItemHolder)localObject2).d = ((TextView)((View)localObject3).findViewById(2131365754));
            ((FileCategoryAdapter.ItemHolder)localObject2).e = ((TextView)((View)localObject3).findViewById(2131378475));
            paramView = (View)localObject3;
            localObject1 = localObject2;
          }
        }
        else
        {
          ((FileCategoryAdapter.ItemHolder)localObject2).jdField_a_of_type_AndroidViewView = ((View)localObject3).findViewById(2131364361);
          ((FileCategoryAdapter.ItemHolder)localObject2).jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          ((FileCategoryAdapter.ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject3).findViewById(2131364360));
          ((FileCategoryAdapter.ItemHolder)localObject2).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject3).findViewById(2131376316));
          ((FileCategoryAdapter.ItemHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject3).findViewById(2131364362));
          ((FileCategoryAdapter.ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject3).findViewById(2131372043));
          ((FileCategoryAdapter.ItemHolder)localObject2).c = ((TextView)((View)localObject3).findViewById(2131377840));
          paramView = (View)localObject3;
          localObject1 = localObject2;
        }
      }
      else
      {
        localObject1 = (FileCategoryAdapter.ItemHolder)paramView.getTag();
      }
      ((FileCategoryAdapter.ItemHolder)localObject1).jdField_a_of_type_Int = localFileCategoryEntity.e;
      ((FileCategoryAdapter.ItemHolder)localObject1).jdField_a_of_type_JavaLangString = localFileCategoryEntity.jdField_c_of_type_JavaLangString;
      if (localFileCategoryEntity.jdField_a_of_type_Int == 0)
      {
        if (localFileCategoryEntity.jdField_c_of_type_Boolean) {
          ((FileCategoryAdapter.ItemHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        } else {
          ((FileCategoryAdapter.ItemHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        if (localFileCategoryEntity.jdField_b_of_type_Boolean)
        {
          ((FileCategoryAdapter.ItemHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          ((FileCategoryAdapter.ItemHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(localFileCategoryEntity.jdField_c_of_type_Int);
        }
        else
        {
          ((FileCategoryAdapter.ItemHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        if (!TextUtils.isEmpty(localFileCategoryEntity.jdField_b_of_type_JavaLangString))
        {
          ((FileCategoryAdapter.ItemHolder)localObject1).c.setText(localFileCategoryEntity.jdField_b_of_type_JavaLangString);
          ((FileCategoryAdapter.ItemHolder)localObject1).c.setVisibility(0);
        }
        else
        {
          ((FileCategoryAdapter.ItemHolder)localObject1).c.setVisibility(8);
        }
        ((FileCategoryAdapter.ItemHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(localFileCategoryEntity.jdField_a_of_type_JavaLangString);
        ((FileCategoryAdapter.ItemHolder)localObject1).jdField_a_of_type_AndroidViewView.setTag(localObject1);
        if (localFileCategoryEntity.jdField_a_of_type_Boolean)
        {
          localObject2 = ((FileCategoryAdapter.ItemHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("(");
          ((StringBuilder)localObject3).append(localFileCategoryEntity.d);
          ((StringBuilder)localObject3).append(")");
          ((TextView)localObject2).setText(((StringBuilder)localObject3).toString());
        }
        int i = localFileCategoryEntity.f;
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 4) {
                ((FileCategoryAdapter.ItemHolder)localObject1).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839433);
              } else {
                ((FileCategoryAdapter.ItemHolder)localObject1).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839440);
              }
            }
            else {
              ((FileCategoryAdapter.ItemHolder)localObject1).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839443);
            }
          }
          else {
            ((FileCategoryAdapter.ItemHolder)localObject1).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839449);
          }
        }
        else {
          ((FileCategoryAdapter.ItemHolder)localObject1).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839433);
        }
        if ((16 != localFileCategoryEntity.e) && (17 != localFileCategoryEntity.e)) {
          if (22 == localFileCategoryEntity.e)
          {
            localObject2 = ((IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath("100160.100163");
            localObject3 = (RedTouch)paramView;
            ((RedTouch)localObject3).a((BusinessInfoCheckUpdate.AppInfo)localObject2);
            if (((RedTouch)localObject3).c()) {
              ((FileCategoryAdapter.ItemHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
            } else {
              ((FileCategoryAdapter.ItemHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            }
          }
          else
          {
            ((RedTouch)paramView).d();
          }
        }
      }
      else if (localFileCategoryEntity.jdField_a_of_type_Int == 1)
      {
        if (localFileCategoryEntity.jdField_a_of_type_Boolean) {
          ((FileCategoryAdapter.ItemHolder)localObject1).e.setText(localFileCategoryEntity.jdField_a_of_type_JavaLangString);
        } else {
          ((FileCategoryAdapter.ItemHolder)localObject1).e.setVisibility(4);
        }
      }
      else if (localFileCategoryEntity.jdField_a_of_type_Int == 4)
      {
        if (localFileCategoryEntity.jdField_a_of_type_Boolean)
        {
          ((FileCategoryAdapter.ItemHolder)localObject1).e.setGravity(17);
          localObject2 = (IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class);
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
          if (!((IQQFileTempUtils)localObject2).hasShortCut((Activity)localObject3, new String[] { ((BaseFileAssistantActivity)localObject3).getString(2131692363) }))
          {
            localObject2 = QQFileManagerUtil.a(localFileCategoryEntity.jdField_a_of_type_JavaLangString, localFileCategoryEntity.jdField_a_of_type_JavaLangString, null);
            ((FileCategoryAdapter.ItemHolder)localObject1).e.setClickable(true);
            ((FileCategoryAdapter.ItemHolder)localObject1).e.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            ((FileCategoryAdapter.ItemHolder)localObject1).e.setText((CharSequence)localObject2);
            ((FileCategoryAdapter.ItemHolder)localObject1).e.setTag(localObject1);
          }
        }
        else
        {
          ((FileCategoryAdapter.ItemHolder)localObject1).e.setVisibility(4);
        }
      }
      localObject2 = paramView;
      localObject1 = paramView;
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject2, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.FileCategoryAdapter
 * JD-Core Version:    0.7.0.1
 */