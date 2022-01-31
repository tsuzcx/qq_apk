package com.tencent.mobileqq.filemanager.data;

import android.annotation.SuppressLint;
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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileFileAdapterFacade;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class RecentFileAdapter
  extends BaseFileAdapter
{
  private long jdField_a_of_type_Long;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private String jdField_a_of_type_JavaLangString;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private List jdField_a_of_type_JavaUtilList;
  private View.OnClickListener b;
  
  private String a(FileManagerEntity paramFileManagerEntity)
  {
    String str4 = null;
    String str1;
    String str2;
    label218:
    String str3;
    switch (paramFileManagerEntity.getCloudType())
    {
    case 4: 
    default: 
      str1 = null;
      str2 = null;
      switch (paramFileManagerEntity.nOpType)
      {
      default: 
        localObject = null;
        if (paramFileManagerEntity.getCloudType() == 0) {
          localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131428135);
        }
        str3 = str4;
        if (localObject != null)
        {
          str3 = str4;
          if (!((String)localObject).equals(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131428125)))
          {
            str3 = str4;
            if (!((String)localObject).equals(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131428136))) {
              str3 = paramFileManagerEntity.peerNick;
            }
          }
        }
        if (paramFileManagerEntity.getCloudType() == 5) {
          if (!paramFileManagerEntity.bSend) {
            break label757;
          }
        }
        break;
      }
      break;
    }
    label757:
    for (Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131428137);; localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131428135))
    {
      str3 = paramFileManagerEntity.peerNick;
      str4 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131428143);
      str2 = FileUtil.a(paramFileManagerEntity.fileSize) + a(str4, str2) + a(str4, str1) + a(str4, (String)localObject) + a("", str3);
      str1 = FileUtil.a(paramFileManagerEntity.fileSize) + a(str4, str1) + a(str4, (String)localObject) + a("", str3);
      if ((paramFileManagerEntity.getCloudType() != 2) || (3 != paramFileManagerEntity.nOpType)) {
        break label770;
      }
      return str2;
      str2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131428100);
      localObject = FileManagerUtil.a(paramFileManagerEntity.srvTime, paramFileManagerEntity.peerType, false);
      str1 = (String)localObject + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131428138);
      break;
      str2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131428101);
      str1 = null;
      break;
      str1 = null;
      str2 = null;
      break;
      str1 = null;
      str2 = null;
      break;
      str2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131431804);
      str1 = null;
      break;
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131428135);
      break label218;
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131428125);
      break label218;
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131428137);
      break label218;
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131428136);
      break label218;
      if (paramFileManagerEntity.bSend)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131428137);
        break label218;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131428135);
      break label218;
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131428269);
      break label218;
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131428270);
      break label218;
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131428271);
      break label218;
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131428272);
      break label218;
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131428273);
      break label218;
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131428274);
      break label218;
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131428275);
      break label218;
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131428276);
      break label218;
    }
    label770:
    if (paramFileManagerEntity.getCloudType() == 5) {
      return str2;
    }
    if (paramFileManagerEntity.TroopUin != 0L)
    {
      localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app.getManager(51)).a(String.valueOf(paramFileManagerEntity.TroopUin));
      if (localObject == null) {}
      for (localObject = "-"; paramFileManagerEntity.bSend; localObject = ((TroopInfo)localObject).getTroopName()) {
        return str1 + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131428287) + (String)localObject;
      }
      return str1 + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131428286) + (String)localObject;
    }
    return str1;
  }
  
  private String a(String paramString, long paramLong)
  {
    Object localObject = (HashMap)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if ((localObject == null) || (!a()))
    {
      localObject = new HashMap();
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject);
    }
    for (paramString = (String)localObject;; paramString = (String)localObject)
    {
      localObject = TimeFormatterUtils.a(paramLong, true, this.jdField_a_of_type_JavaLangString);
      paramString.put(paramLong + "", localObject);
      paramString = (String)localObject;
      String str;
      do
      {
        return paramString;
        str = (String)((HashMap)localObject).get(paramLong + "");
        paramString = str;
      } while (str != null);
      ((HashMap)localObject).clear();
    }
  }
  
  private String a(String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (paramString2.equalsIgnoreCase(""))) {
      return "";
    }
    return paramString1 + paramString2;
  }
  
  private void a()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(5, 1);
    localCalendar.set(10, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    this.jdField_a_of_type_Long = localCalendar.getTimeInMillis();
  }
  
  private void a(AsyncImageView paramAsyncImageView, String paramString)
  {
    paramAsyncImageView.setDefaultImage(2130841666);
    paramAsyncImageView.setAsyncImage(paramString);
  }
  
  private boolean a()
  {
    if (System.currentTimeMillis() >= this.jdField_a_of_type_Long)
    {
      a();
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      return false;
    }
    return true;
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
    return super.getItemViewType(paramInt);
  }
  
  @SuppressLint({"InlinedApi"})
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)getItem(paramInt);
    View localView;
    if (localFileManagerEntity == null)
    {
      localView = null;
      label18:
      return localView;
    }
    if (paramView == null) {}
    for (;;)
    {
      for (;;)
      {
        try
        {
          localItemHolder = new RecentFileAdapter.ItemHolder(this);
          paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970035, paramViewGroup, false);
          paramView = paramViewGroup;
          paramViewGroup = paramView;
        }
        catch (Exception localException)
        {
          RecentFileAdapter.ItemHolder localItemHolder;
          paramViewGroup = paramView;
          paramView = localException;
          continue;
          continue;
        }
        try
        {
          localItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131368769));
          paramViewGroup = paramView;
          localItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          paramViewGroup = paramView;
          localItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
          paramViewGroup = paramView;
          localItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localItemHolder);
          paramViewGroup = paramView;
          localItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131368811));
          paramViewGroup = paramView;
          localItemHolder.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131368770));
          paramViewGroup = paramView;
          localItemHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368812));
          paramViewGroup = paramView;
          localItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131368772));
          paramViewGroup = paramView;
          localItemHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368773));
          paramViewGroup = paramView;
          localItemHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368732));
          paramViewGroup = paramView;
          localItemHolder.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131364142));
          paramViewGroup = paramView;
          localItemHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368776));
          paramViewGroup = paramView;
          localItemHolder.c = ((TextView)paramView.findViewById(2131363205));
          paramViewGroup = paramView;
          localItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout = ((ShaderAnimLayout)paramView.findViewById(2131362746));
          paramViewGroup = paramView;
          localItemHolder.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131364626));
          paramViewGroup = paramView;
          paramView.setTag(localItemHolder);
          paramViewGroup = paramView;
          if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f()) {
            continue;
          }
          paramViewGroup = paramView;
          if (localFileManagerEntity.getCloudType() != 0) {
            continue;
          }
          paramViewGroup = paramView;
          localItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          paramViewGroup = paramView;
          localItemHolder.jdField_a_of_type_Long = localFileManagerEntity.uniseq;
          paramViewGroup = paramView;
          localItemHolder.jdField_b_of_type_Long = localFileManagerEntity.nSessionId;
          paramViewGroup = paramView;
          localItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = localFileManagerEntity;
          paramViewGroup = paramView;
          localItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.b);
          paramViewGroup = paramView;
          localItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setTag(localItemHolder);
          paramViewGroup = paramView;
          if (FileManagerUtil.a(localFileManagerEntity.fileName) != 0) {
            continue;
          }
          paramViewGroup = paramView;
          if (!FileUtils.b(localFileManagerEntity.strThumbPath)) {
            continue;
          }
          paramViewGroup = paramView;
          a(localItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity.strThumbPath);
          paramViewGroup = paramView;
          localItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localFileManagerEntity.fileName);
          paramViewGroup = paramView;
          localItemHolder.jdField_b_of_type_AndroidWidgetTextView.setText(a(localFileManagerEntity));
          paramViewGroup = paramView;
          localItemHolder.c.setText(a(localFileManagerEntity.selfUin, localFileManagerEntity.srvTime));
          paramViewGroup = paramView;
          localItemHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          paramViewGroup = paramView;
          switch (localFileManagerEntity.status)
          {
          case 16: 
          case 17: 
            paramViewGroup = paramView;
            localItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            paramViewGroup = paramView;
            localItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            paramViewGroup = paramView;
            localItemHolder.c.setVisibility(0);
            paramViewGroup = paramView;
            if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f()) {
              continue;
            }
            paramViewGroup = paramView;
            localItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            paramViewGroup = paramView;
            localItemHolder.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
            paramViewGroup = paramView;
            localItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            paramViewGroup = paramView;
            localItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838591);
            paramViewGroup = paramView;
            localItemHolder.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
            paramViewGroup = paramView;
            localItemHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(FMDataCache.a(localFileManagerEntity));
            localView = paramView;
            paramViewGroup = paramView;
            if (!a(paramInt, paramView, localItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout, localItemHolder.jdField_a_of_type_AndroidWidgetButton, localFileManagerEntity)) {
              break label18;
            }
            paramViewGroup = paramView;
            localItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            paramViewGroup = paramView;
            localItemHolder.c.setVisibility(4);
            paramViewGroup = paramView;
            localItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            return paramView;
          }
        }
        catch (Exception paramView) {}
      }
      paramView.printStackTrace();
      return paramViewGroup;
      localItemHolder = (RecentFileAdapter.ItemHolder)paramView.getTag();
      continue;
      paramViewGroup = paramView;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f())
      {
        paramViewGroup = paramView;
        if (localFileManagerEntity.getCloudType() == 5)
        {
          paramViewGroup = paramView;
          if (!localFileManagerEntity.bSend)
          {
            paramViewGroup = paramView;
            if (localFileManagerEntity.status != 1)
            {
              paramViewGroup = paramView;
              localItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
              continue;
            }
          }
        }
      }
      paramViewGroup = paramView;
      localItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      continue;
      paramViewGroup = paramView;
      if (localFileManagerEntity.getFilePath() != null)
      {
        paramViewGroup = paramView;
        if (localFileManagerEntity.getFilePath().length() > 0)
        {
          paramViewGroup = paramView;
          QfileFileAdapterFacade.a(localItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity.getFilePath(), localFileManagerEntity.nFileType);
          continue;
        }
      }
      paramViewGroup = paramView;
      QfileFileAdapterFacade.a(localItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity.fileName, localFileManagerEntity.nFileType);
      continue;
      paramViewGroup = paramView;
      FileManagerUtil.a(localItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity);
      continue;
      paramViewGroup = paramView;
      localItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      paramViewGroup = paramView;
      localItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      paramViewGroup = paramView;
      localItemHolder.c.setVisibility(0);
      paramViewGroup = paramView;
      localItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(localFileManagerEntity.fProgress * 100.0F));
      continue;
      paramViewGroup = paramView;
      localItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      paramViewGroup = paramView;
      localItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      paramViewGroup = paramView;
      localItemHolder.c.setVisibility(0);
      continue;
      paramViewGroup = paramView;
      localItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      paramViewGroup = paramView;
      localItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      paramViewGroup = paramView;
      localItemHolder.c.setVisibility(0);
      continue;
      paramViewGroup = paramView;
      localItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      paramViewGroup = paramView;
      localItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      paramViewGroup = paramView;
      localItemHolder.c.setVisibility(4);
      continue;
      paramViewGroup = paramView;
      if (13 == localFileManagerEntity.nOpType)
      {
        paramViewGroup = paramView;
        localItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        paramViewGroup = paramView;
        localItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        paramViewGroup = paramView;
        localItemHolder.c.setVisibility(4);
      }
      else
      {
        paramViewGroup = paramView;
        localItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        paramViewGroup = paramView;
        localItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        paramViewGroup = paramView;
        localItemHolder.c.setVisibility(0);
        continue;
        paramViewGroup = paramView;
        localItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        paramViewGroup = paramView;
        localItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        paramViewGroup = paramView;
        localItemHolder.c.setVisibility(0);
        continue;
        paramViewGroup = paramView;
        if (10 == localFileManagerEntity.nOpType)
        {
          paramViewGroup = paramView;
          localItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
          paramViewGroup = paramView;
          localItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          paramViewGroup = paramView;
          localItemHolder.c.setVisibility(0);
        }
        else
        {
          paramViewGroup = paramView;
          localItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
          paramViewGroup = paramView;
          localItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          paramViewGroup = paramView;
          localItemHolder.c.setVisibility(4);
          continue;
          paramViewGroup = paramView;
          localItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
          paramViewGroup = paramView;
          localItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          paramViewGroup = paramView;
          localItemHolder.c.setVisibility(0);
          continue;
          paramViewGroup = paramView;
          if (9 == localFileManagerEntity.nOpType)
          {
            paramViewGroup = paramView;
            localItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            paramViewGroup = paramView;
            localItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
            paramViewGroup = paramView;
            localItemHolder.c.setVisibility(0);
            paramViewGroup = paramView;
            localItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(localFileManagerEntity.fProgress * 100.0F));
          }
          else
          {
            paramViewGroup = paramView;
            localItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
            paramViewGroup = paramView;
            localItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            paramViewGroup = paramView;
            localItemHolder.c.setVisibility(0);
            continue;
            paramViewGroup = paramView;
            localItemHolder.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
          }
        }
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return super.getViewTypeCount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.RecentFileAdapter
 * JD-Core Version:    0.7.0.1
 */