package com.tencent.mobileqq.filemanager.activity.recentfile;

import acjn;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class QfileRecentFileBaseExpandableListAdapter
  extends QfileBaseExpandableListAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private View.OnClickListener b;
  private View.OnClickListener c;
  
  public QfileRecentFileBaseExpandableListAdapter(Context paramContext, LinkedHashMap paramLinkedHashMap, BaseFileAssistantActivity paramBaseFileAssistantActivity, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnLongClickListener paramOnLongClickListener, View.OnClickListener paramOnClickListener3)
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
  
  private String a(FileManagerEntity paramFileManagerEntity)
  {
    String str1 = null;
    Object localObject;
    String str2;
    switch (paramFileManagerEntity.getCloudType())
    {
    case 4: 
    default: 
      localObject = null;
      String str3 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131428143);
      str2 = FileUtil.a(paramFileManagerEntity.fileSize) + a(str3, (String)localObject) + a(str3, str1);
      localObject = FileUtil.a(paramFileManagerEntity.fileSize) + a(str3, str1);
      if ((paramFileManagerEntity.getCloudType() == 2) && (3 == paramFileManagerEntity.nOpType)) {
        localObject = str2;
      }
      break;
    }
    do
    {
      return localObject;
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131428100);
      str1 = FileManagerUtil.a(paramFileManagerEntity.srvTime, paramFileManagerEntity.peerType, false);
      str1 = str1 + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131428138);
      break;
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131428101);
      break;
      localObject = null;
      break;
      localObject = null;
      break;
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131431776);
      break;
      if (paramFileManagerEntity.getCloudType() == 5) {
        return str2;
      }
    } while (paramFileManagerEntity.TroopUin == 0L);
    return str2;
  }
  
  private String a(String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (paramString2.equalsIgnoreCase(""))) {
      return "";
    }
    return paramString1 + paramString2;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Object localObject3;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f())
    {
      localObject3 = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1));
      if (localObject3 != null)
      {
        localObject3 = ((ArrayList)localObject3).iterator();
        for (;;)
        {
          localObject2 = localObject1;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject2 = (acjn)((Iterator)localObject3).next();
          if (((acjn)localObject2).jdField_a_of_type_Int != paramInt2) {
            break label1456;
          }
          localObject1 = (FileManagerEntity)getChild(paramInt1, ((acjn)localObject2).jdField_b_of_type_Int);
        }
      }
    }
    while (localObject2 == null)
    {
      return paramView;
      localObject2 = (FileManagerEntity)getChild(paramInt1, paramInt2);
    }
    if (paramView == null) {
      localObject1 = paramView;
    }
    for (;;)
    {
      try
      {
        localObject3 = new QfileRecentFileBaseExpandableListAdapter.RecentItemHolder(this);
        localObject1 = paramView;
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130969996, paramViewGroup, false);
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131368699));
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.b);
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localObject3);
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131368704));
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131368700));
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131368702));
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368703));
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368662));
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131364093));
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368706));
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363183));
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131362724));
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(AIOUtils.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        localObject1 = paramView;
        paramView.setTag(localObject3);
        paramViewGroup = (ViewGroup)localObject3;
      }
      catch (Exception paramViewGroup)
      {
        paramView = (View)localObject1;
        continue;
      }
      try
      {
        FileManagerUtil.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, (FileManagerEntity)localObject2);
        paramViewGroup.jdField_b_of_type_Int = paramInt1;
        paramViewGroup.jdField_c_of_type_Int = paramInt2;
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        paramViewGroup.jdField_a_of_type_JavaLangObject = localObject2;
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.c);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTag(paramViewGroup);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(FileManagerUtil.d(((FileManagerEntity)localObject2).fileName));
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(a((FileManagerEntity)localObject2));
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(FileManagerUtil.a((FileManagerEntity)localObject2));
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        if (5 != ((FileManagerEntity)localObject2).cloudType) {
          FileManagerUtil.c((FileManagerEntity)localObject2);
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        switch (((FileManagerEntity)localObject2).status)
        {
        case 17: 
          paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        }
      }
      catch (Exception paramViewGroup)
      {
        paramViewGroup.printStackTrace();
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131428319);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_a_of_type_Int = 3;
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        continue;
        paramBoolean = FileUtil.a(((FileManagerEntity)localObject2).getFilePath());
        if ((((FileManagerEntity)localObject2).getCloudType() != 3) && (((FileManagerEntity)localObject2).getCloudType() != 5) && (!paramBoolean)) {
          continue;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131428316);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_a_of_type_Int = 0;
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131428320);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_a_of_type_Int = 1;
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131428319);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_a_of_type_Int = 3;
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131428316);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_a_of_type_Int = 0;
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131428320);
        paramViewGroup.jdField_a_of_type_Int = 1;
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131428316);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_a_of_type_Int = 0;
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131428316);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_a_of_type_Int = 0;
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131428320);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_a_of_type_Int = 1;
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131428316);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_a_of_type_Int = 2;
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(((FileManagerEntity)localObject2).fProgress * 100.0F));
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131428320);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_a_of_type_Int = 1;
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131428317);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        paramViewGroup.jdField_a_of_type_Int = 0;
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
        continue;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f())
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838581);
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(FMDataCache.a((FileManagerEntity)localObject2));
        return paramView;
        localObject1 = paramView;
        paramViewGroup = (QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)paramView.getTag();
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131428318);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_a_of_type_Int = 2;
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(((FileManagerEntity)localObject2).fProgress * 100.0F));
      }
      else
      {
        label1456:
        break;
      }
    }
  }
  
  public int getChildrenCount(int paramInt)
  {
    int i = 0;
    Object localObject1 = a(paramInt);
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
        int j = 0;
        i = 0;
        if (localIterator.hasNext())
        {
          Object localObject2 = (FileManagerEntity)localIterator.next();
          int k;
          if ((((FileManagerEntity)localObject2).getCloudType() == 0) || ((((FileManagerEntity)localObject2).getCloudType() == 5) && (!((FileManagerEntity)localObject2).bSend) && (((FileManagerEntity)localObject2).status != 1)))
          {
            k = j + 1;
            j = i;
            i = k;
          }
          for (;;)
          {
            k = j;
            j = i;
            i = k;
            break;
            if (((FileManagerEntity)localObject2).sendCloudUnsuccessful())
            {
              k = j + 1;
              j = i;
              i = k;
            }
            else
            {
              localObject2 = new acjn(this);
              ((acjn)localObject2).jdField_a_of_type_Int = i;
              ((acjn)localObject2).jdField_b_of_type_Int = (i + j);
              localArrayList.add(localObject2);
              k = i + 1;
              i = j;
              j = k;
            }
          }
        }
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localArrayList);
        i = ((ArrayList)localObject1).size() - j;
      }
    }
    else
    {
      return i;
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    return ((ArrayList)localObject1).size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentFileBaseExpandableListAdapter
 * JD-Core Version:    0.7.0.1
 */