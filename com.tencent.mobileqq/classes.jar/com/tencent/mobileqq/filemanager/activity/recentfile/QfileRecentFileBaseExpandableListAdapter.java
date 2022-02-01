package com.tencent.mobileqq.filemanager.activity.recentfile;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.activity.adapter.RecentItemHolder;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.CircleFileStateView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class QfileRecentFileBaseExpandableListAdapter
  extends QfileBaseExpandableListAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private HashMap<Integer, ArrayList<QfileRecentFileBaseExpandableListAdapter.PosInfo>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private View.OnClickListener b;
  private View.OnClickListener c;
  
  public QfileRecentFileBaseExpandableListAdapter(Context paramContext, LinkedHashMap<String, List<FileManagerEntity>> paramLinkedHashMap, BaseFileAssistantActivity paramBaseFileAssistantActivity, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnLongClickListener paramOnLongClickListener, View.OnClickListener paramOnClickListener3)
  {
    super(paramContext, paramLinkedHashMap);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener1;
    this.b = paramOnClickListener2;
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
    this.c = paramOnClickListener3;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = paramBaseFileAssistantActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
  }
  
  private void a(FileManagerEntity paramFileManagerEntity, RecentItemHolder paramRecentItemHolder)
  {
    switch (paramFileManagerEntity.status)
    {
    case 17: 
    default: 
      paramRecentItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(4);
      return;
    case 16: 
      paramRecentItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(4);
      return;
    case 14: 
    case 15: 
      paramRecentItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(4);
      return;
    case 13: 
      paramRecentItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
      paramRecentItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
      paramRecentItemHolder.jdField_a_of_type_Int = 1;
      return;
    case 10: 
    case 11: 
      paramRecentItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(4);
      return;
    case 9: 
    case 12: 
      paramRecentItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(4);
      return;
    case 5: 
    case 6: 
    case 7: 
    case 8: 
      paramRecentItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(4);
      return;
    case 4: 
      paramRecentItemHolder.jdField_a_of_type_Int = 1;
      paramRecentItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
      paramRecentItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
      return;
    case 3: 
      a(paramFileManagerEntity, paramRecentItemHolder, ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).isFileExists(paramFileManagerEntity.getFilePath()));
      return;
    case 2: 
    case 18: 
      paramRecentItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
      paramRecentItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(1);
      paramRecentItemHolder.jdField_a_of_type_Int = 2;
      return;
    case 1: 
      b(paramFileManagerEntity, paramRecentItemHolder, ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).isFileExists(paramFileManagerEntity.getFilePath()));
      return;
    case 0: 
      paramRecentItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
      paramRecentItemHolder.jdField_a_of_type_Int = 3;
      boolean bool = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).isFileExists(paramFileManagerEntity.getFilePath());
      if ((paramFileManagerEntity.bSend) && (bool))
      {
        paramRecentItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(3);
        return;
      }
      paramRecentItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
      return;
    }
    paramRecentItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
    paramRecentItemHolder.jdField_a_of_type_Int = 1;
    paramRecentItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
  }
  
  private void a(FileManagerEntity paramFileManagerEntity, RecentItemHolder paramRecentItemHolder, boolean paramBoolean)
  {
    if ((paramFileManagerEntity.bSend) && (paramBoolean)) {
      paramRecentItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(3);
    } else {
      paramRecentItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
    }
    paramRecentItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
    paramRecentItemHolder.jdField_a_of_type_Int = 3;
  }
  
  private void b(FileManagerEntity paramFileManagerEntity, RecentItemHolder paramRecentItemHolder, boolean paramBoolean)
  {
    if ((paramFileManagerEntity.getCloudType() != 3) && (paramFileManagerEntity.getCloudType() != 5) && (!paramBoolean))
    {
      paramRecentItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
      paramRecentItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
      paramRecentItemHolder.jdField_a_of_type_Int = 1;
      return;
    }
    paramRecentItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(4);
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    Object localObject3;
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f())
    {
      localObject1 = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1));
      if (localObject1 != null)
      {
        localObject3 = ((ArrayList)localObject1).iterator();
        localObject2 = null;
        for (;;)
        {
          localObject1 = localObject2;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject1 = (QfileRecentFileBaseExpandableListAdapter.PosInfo)((Iterator)localObject3).next();
          if (((QfileRecentFileBaseExpandableListAdapter.PosInfo)localObject1).jdField_a_of_type_Int == paramInt2) {
            localObject2 = (FileManagerEntity)getChild(paramInt1, ((QfileRecentFileBaseExpandableListAdapter.PosInfo)localObject1).jdField_b_of_type_Int);
          }
        }
      }
      localObject1 = null;
    }
    else
    {
      localObject1 = (FileManagerEntity)getChild(paramInt1, paramInt2);
    }
    if (localObject1 == null) {
      return paramView;
    }
    if (paramView == null) {
      localObject2 = paramView;
    }
    try
    {
      localObject3 = new RecentItemHolder();
      localObject2 = paramView;
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560778, paramViewGroup, false);
      localObject2 = paramView;
      ((RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376167));
      localObject2 = paramView;
      ((RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      localObject2 = paramView;
      ((RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localObject3);
      localObject2 = paramView;
      ((RecentItemHolder)localObject3).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370701);
      localObject2 = paramView;
      ((RecentItemHolder)localObject3).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView = ((CircleFileStateView)paramView.findViewById(2131361949));
      localObject2 = paramView;
      ((RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131366794));
      localObject2 = paramView;
      ((RecentItemHolder)localObject3).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366781));
      localObject2 = paramView;
      ((RecentItemHolder)localObject3).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setTag(localObject3);
      localObject2 = paramView;
      ((RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366792));
      localObject2 = paramView;
      ((RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetTextView.setGravity(48);
      localObject2 = paramView;
      ((RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      localObject2 = paramView;
      ((RecentItemHolder)localObject3).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366779));
      localObject2 = paramView;
      int i = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).dp2px(70, this.jdField_a_of_type_AndroidContentContext.getResources());
      localObject2 = paramView;
      ((RecentItemHolder)localObject3).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(i, i);
      localObject2 = paramView;
      paramView.setTag(localObject3);
      paramViewGroup = (ViewGroup)localObject3;
      break label432;
      localObject2 = paramView;
      paramViewGroup = (RecentItemHolder)paramView.getTag();
      label432:
      localObject2 = paramView;
      QQFileManagerUtil.b(paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, (FileManagerEntity)localObject1);
      localObject2 = paramView;
      paramViewGroup.jdField_b_of_type_Int = paramInt1;
      localObject2 = paramView;
      paramViewGroup.c = paramInt2;
      localObject2 = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      localObject2 = paramView;
      if (QQFileManagerUtil.a(this.jdField_a_of_type_AndroidContentContext, (FileManagerEntity)localObject1))
      {
        localObject2 = paramView;
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localObject2 = paramView;
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(null);
      }
      else
      {
        localObject2 = paramView;
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localObject2 = paramView;
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.b);
        localObject2 = paramView;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setOnClickListener(this.b);
      }
      localObject2 = paramView;
      paramViewGroup.jdField_a_of_type_JavaLangObject = localObject1;
      localObject2 = paramView;
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setOnClickListener(this.c);
      localObject2 = paramView;
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setTag(paramViewGroup);
      localObject2 = paramView;
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setProgressRingWidth(3.0F);
      localObject2 = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((FileManagerEntity)localObject1).fileName);
      localObject2 = paramView;
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setProgress((int)(((FileManagerEntity)localObject1).fProgress * 100.0F));
      localObject2 = paramView;
      if (5 != ((FileManagerEntity)localObject1).cloudType)
      {
        localObject2 = paramView;
        QQFileManagerUtil.c((FileManagerEntity)localObject1);
      }
      localObject2 = paramView;
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setEnabled(true);
      localObject2 = paramView;
      a((FileManagerEntity)localObject1, paramViewGroup);
      localObject2 = paramView;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f())
      {
        localObject2 = paramView;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
        localObject2 = paramView;
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
        localObject2 = paramView;
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(FMDataCache.a((FileManagerEntity)localObject1));
      }
      else
      {
        localObject2 = paramView;
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      }
      localObject2 = paramView;
      if (((FileManagerEntity)localObject1).nFileType == 13)
      {
        localObject2 = paramView;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
      }
      localObject2 = paramView;
      localObject3 = (LinearLayout.LayoutParams)paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      localObject2 = paramView;
      ((LinearLayout.LayoutParams)localObject3).topMargin = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).dp2px(3, this.jdField_a_of_type_AndroidContentContext.getResources());
      localObject2 = paramView;
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setLineSpacing(TypedValue.applyDimension(1, 0.8F, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics()), 1.0F);
      localObject2 = paramView;
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      localObject2 = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setLineSpacing(TypedValue.applyDimension(1, 0.25F, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics()), 1.0F);
      localObject2 = paramView;
      QQFileManagerUtil.a(paramViewGroup.jdField_b_of_type_AndroidWidgetTextView, (FileManagerEntity)localObject1);
      return paramView;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
    return localObject2;
  }
  
  public int getChildrenCount(int paramInt)
  {
    Object localObject1 = a(paramInt);
    int j = 0;
    if (localObject1 != null)
    {
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), new ArrayList());
      }
      localObject1 = (ArrayList)localObject1;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f())
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = ((ArrayList)localObject1).iterator();
        int i = 0;
        while (localIterator.hasNext())
        {
          Object localObject2 = (FileManagerEntity)localIterator.next();
          if ((((FileManagerEntity)localObject2).getCloudType() != 0) && ((((FileManagerEntity)localObject2).getCloudType() != 5) || (((FileManagerEntity)localObject2).bSend) || (((FileManagerEntity)localObject2).status == 1)) && (!((FileManagerEntity)localObject2).sendCloudUnsuccessful()))
          {
            localObject2 = new QfileRecentFileBaseExpandableListAdapter.PosInfo(this);
            ((QfileRecentFileBaseExpandableListAdapter.PosInfo)localObject2).jdField_a_of_type_Int = i;
            ((QfileRecentFileBaseExpandableListAdapter.PosInfo)localObject2).jdField_b_of_type_Int = (i + j);
            localArrayList.add(localObject2);
            i += 1;
          }
          else
          {
            j += 1;
          }
        }
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localArrayList);
        return ((ArrayList)localObject1).size() - j;
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      return ((ArrayList)localObject1).size();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentFileBaseExpandableListAdapter
 * JD-Core Version:    0.7.0.1
 */