package com.tencent.mobileqq.leba;

import adzl;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.leba.header.PluginActionFactory.PluginPool;
import com.tencent.mobileqq.leba.model.LebaGridItemInfo;
import com.tencent.mobileqq.leba.model.PluginInfo;
import com.tencent.mobileqq.leba.model.pluginactions.PluginAction;
import com.tencent.mobileqq.statistics.EXReportController;
import com.tencent.mobileqq.statistics.exreportitem.DC03309ReportItem;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class LebaTopBarAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  private static String jdField_a_of_type_JavaLangString = "LebaTopBar";
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray;
  private PluginActionFactory.PluginPool jdField_a_of_type_ComTencentMobileqqLebaHeaderPluginActionFactory$PluginPool = new PluginActionFactory.PluginPool();
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public LebaTopBarAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.5F, 1.0F, 0.5F, 1.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(200L);
    if ((this.jdField_a_of_type_AndroidUtilSparseArray != null) && (this.jdField_a_of_type_AndroidUtilSparseArray.size() > 0) && (paramInt2 < this.jdField_a_of_type_AndroidUtilSparseArray.size())) {
      while (paramInt1 < paramInt2 + 1)
      {
        ((ImageView)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1)).startAnimation(localScaleAnimation);
        paramInt1 += 1;
      }
    }
  }
  
  public void a(PluginActionFactory.PluginPool paramPluginPool)
  {
    this.jdField_a_of_type_ComTencentMobileqqLebaHeaderPluginActionFactory$PluginPool = paramPluginPool;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(paramList.size());
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
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = 0;
    BaseViewHolder localBaseViewHolder;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970394, paramViewGroup, false);
      localBaseViewHolder = new BaseViewHolder(paramView);
      paramView.setTag(localBaseViewHolder);
      if ((paramViewGroup.getTag(2131362520) == null) || (((Boolean)paramViewGroup.getTag(2131362520)).booleanValue())) {
        i = 1;
      }
      paramViewGroup = (ImageView)localBaseViewHolder.a(2131366363);
      if (i == 0) {
        break label95;
      }
    }
    label95:
    LebaGridItemInfo localLebaGridItemInfo;
    do
    {
      return paramView;
      localBaseViewHolder = (BaseViewHolder)paramView.getTag();
      break;
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramViewGroup);
      localLebaGridItemInfo = (LebaGridItemInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (localLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo != null) {
        break label167;
      }
      paramViewGroup.setImageResource(2130842664);
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "info is null :" + paramInt);
    return paramView;
    label167:
    Object localObject = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app;
    if (localLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.pluginId == 10000) {
      paramViewGroup.setImageResource(2130844836);
    }
    for (;;)
    {
      paramViewGroup.setTag(Integer.valueOf(paramInt));
      paramViewGroup.setOnClickListener(this);
      if ((AppSetting.b) && (localLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo != null) && (!TextUtils.isEmpty(localLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.resName))) {
        AccessibilityUtil.a(paramView, localLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.resName, Button.class.getName());
      }
      localBaseViewHolder.a("dataItem", localLebaGridItemInfo);
      return paramView;
      if ((localLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.pluginId == 10001) && (localObject != null) && (LebaUtils.a(((QQAppInterface)localObject).getAccount())))
      {
        paramViewGroup.setImageResource(2130842670);
      }
      else if (localLebaGridItemInfo.jdField_a_of_type_JavaLangString != null)
      {
        localObject = localLebaGridItemInfo.jdField_a_of_type_JavaLangString;
        Bitmap localBitmap = (Bitmap)BaseApplicationImpl.sImageHashMap.get(localObject);
        if (localBitmap != null)
        {
          paramViewGroup.setImageBitmap(localBitmap);
        }
        else
        {
          paramViewGroup.setImageResource(2130842664);
          ThreadManager.post(new adzl(this, localLebaGridItemInfo, (String)localObject, paramViewGroup), 5, null, true);
        }
      }
      else
      {
        paramViewGroup.setImageResource(2130842664);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    Object localObject1 = (LebaGridItemInfo)this.jdField_a_of_type_JavaUtilList.get(i);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqLebaHeaderPluginActionFactory$PluginPool.a(((LebaGridItemInfo)localObject1).jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.pluginId, this.jdField_a_of_type_AndroidContentContext);
    if (localObject2 == null) {}
    do
    {
      do
      {
        return;
        ((PluginAction)localObject2).a(paramView, (LebaGridItemInfo)localObject1);
        ((PluginAction)localObject2).c((LebaGridItemInfo)localObject1);
        paramView = ((PluginAction)localObject2).a();
      } while (paramView == null);
      localObject1 = Integer.toString(((LebaGridItemInfo)localObject1).jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.pluginId);
      localObject2 = new DC03309ReportItem();
      ((DC03309ReportItem)localObject2).i = "trends_tab";
      ((DC03309ReportItem)localObject2).j = "trends_plugin";
      ((DC03309ReportItem)localObject2).k = "plugin_clk";
      ((DC03309ReportItem)localObject2).jdField_a_of_type_Int = 3;
      ((DC03309ReportItem)localObject2).jdField_c_of_type_Int = 1;
      ((DC03309ReportItem)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject1);
      ((DC03309ReportItem)localObject2).jdField_c_of_type_JavaLangString = Integer.toString(i + 1);
      EXReportController.b(paramView, (DC03309ReportItem)localObject2);
    } while (!QLog.isDevelopLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 4, "click report " + localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.leba.LebaTopBarAdapter
 * JD-Core Version:    0.7.0.1
 */