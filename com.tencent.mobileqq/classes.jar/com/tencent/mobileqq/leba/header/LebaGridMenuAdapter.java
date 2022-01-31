package com.tencent.mobileqq.leba.header;

import aeax;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.leba.model.LebaGridItemInfo;
import com.tencent.mobileqq.leba.model.PluginInfo;
import com.tencent.mobileqq.leba.model.pluginactions.PluginAction;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class LebaGridMenuAdapter
  extends GridMenuAdapter
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private PluginActionFactory.PluginPool jdField_a_of_type_ComTencentMobileqqLebaHeaderPluginActionFactory$PluginPool = new PluginActionFactory.PluginPool();
  private int h;
  
  public LebaGridMenuAdapter(Context paramContext, List paramList, int paramInt1, int paramInt2)
  {
    super(paramContext, paramList, paramInt1, paramInt2);
    this.h = LebaGridUtils.a(paramContext, paramInt1);
    paramContext = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramContext instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramContext);
    }
  }
  
  protected View a(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    int i = this.d;
    Object localObject2 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    Object localObject1 = (LebaGridItemInfo)this.jdField_a_of_type_JavaUtilList.get(i * paramInt2 + paramInt1);
    label235:
    String str;
    if (paramView == null)
    {
      paramView = ((LayoutInflater)localObject2).inflate(2130970380, paramViewGroup, false);
      localObject2 = paramView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).height = this.h;
      ((ViewGroup.LayoutParams)localObject2).width = this.h;
      paramViewGroup = new LebaGridMenuAdapter.LebaGridItemViewHolder(this);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366364));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366363));
      paramViewGroup.b = paramView.findViewById(2131370309);
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131363259);
      paramViewGroup.c = paramView.findViewById(2131369750);
      paramView = new RedTouch(this.jdField_a_of_type_AndroidContentContext, paramView).a(49).d(13).b(17).g(1).b(10, 0, 18, 0).f(20).a();
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      paramView.setTag(paramViewGroup);
      if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        break label525;
      }
      paramViewGroup.b.setBackgroundColor(Color.parseColor("#1D2A3D"));
      paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#1D2A3D"));
      if (((LebaGridItemInfo)localObject1).jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo != null)
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((LebaGridItemInfo)localObject1).jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.resName);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqLebaModelLebaGridItemInfo = ((LebaGridItemInfo)localObject1);
      }
      if (((LebaGridItemInfo)localObject1).jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo == null) {
        break label615;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqLebaHeaderPluginActionFactory$PluginPool.a(((LebaGridItemInfo)localObject1).jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.pluginId, this.jdField_a_of_type_AndroidContentContext);
      if (((LebaGridItemInfo)localObject1).jdField_a_of_type_JavaLangString == null) {
        break label595;
      }
      str = ((LebaGridItemInfo)localObject1).jdField_a_of_type_JavaLangString;
      Bitmap localBitmap = (Bitmap)BaseApplicationImpl.sImageHashMap.get(str);
      if (localBitmap == null) {
        break label554;
      }
      if (localObject2 != null) {
        ((PluginAction)localObject2).a(paramViewGroup.jdField_a_of_type_AndroidWidgetImageView, localBitmap);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null)
      {
        paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramView.setTag(-1, Integer.valueOf(paramInt1));
      }
      if (((LebaGridItemInfo)localObject1).jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo != null)
      {
        paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqLebaHeaderPluginActionFactory$PluginPool.a(((LebaGridItemInfo)localObject1).jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.pluginId, this.jdField_a_of_type_AndroidContentContext);
        if (paramViewGroup != null) {
          paramViewGroup.a((LebaGridItemInfo)localObject1, paramView);
        }
      }
      ((LebaGridItemInfo)localObject1).c = paramInt2;
      if (AppSetting.b)
      {
        boolean bool = ((RedTouch)paramView).a();
        if ((((LebaGridItemInfo)localObject1).jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo != null) && (!TextUtils.isEmpty(((LebaGridItemInfo)localObject1).jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.resName)))
        {
          localObject1 = ((LebaGridItemInfo)localObject1).jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.resName + "按钮";
          paramViewGroup = (ViewGroup)localObject1;
          if (bool) {
            paramViewGroup = (String)localObject1 + "有更新";
          }
          paramView.setContentDescription(paramViewGroup);
        }
      }
      return paramView;
      paramViewGroup = (LebaGridMenuAdapter.LebaGridItemViewHolder)paramView.getTag();
      break;
      label525:
      paramViewGroup.b.setBackgroundColor(Color.parseColor("#DEDFE0"));
      paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#DEDFE0"));
      break label235;
      label554:
      if (localObject2 != null) {
        ((PluginAction)localObject2).a(paramViewGroup.jdField_a_of_type_AndroidWidgetImageView, 2130842664);
      }
      ThreadManager.post(new aeax(this, (LebaGridItemInfo)localObject1, str, (PluginAction)localObject2, paramViewGroup), 5, null, true);
      continue;
      label595:
      if (localObject2 != null)
      {
        ((PluginAction)localObject2).a(paramViewGroup.jdField_a_of_type_AndroidWidgetImageView, 2130842664);
        continue;
        label615:
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842664);
        if (QLog.isColorLevel()) {
          QLog.d("raymondguo", 2, "info is null :" + paramInt1);
        }
      }
    }
  }
  
  public String a(int paramInt, boolean paramBoolean)
  {
    if (this.c == 0) {
      return "";
    }
    int i;
    JSONObject localJSONObject;
    if (paramInt == this.c - 1) {
      if (paramInt == 0)
      {
        i = this.jdField_a_of_type_JavaUtilList.size();
        paramInt = 0;
        localJSONObject = new JSONObject();
        if (!paramBoolean) {}
      }
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("p" + Integer.toString(1), Integer.toString(10000));
        if ((paramInt >= i) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) || (paramInt < 0))
        {
          return localJSONObject.toString();
          int j = this.d;
          i = this.jdField_a_of_type_JavaUtilList.size();
          paramInt *= j;
          break;
          i = this.d;
          j = this.d;
          i = paramInt * i;
          j = (paramInt + 1) * j;
          paramInt = i;
          i = j;
        }
      }
      catch (Exception localException1)
      {
        QLog.e("LebaGridMenuAdapter", 1, localException1, new Object[0]);
        continue;
        if (((LebaGridItemInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo == null) {}
      }
      try
      {
        localJSONObject.put("p" + Integer.toString(paramInt + 2), Integer.toString(((LebaGridItemInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.pluginId));
        paramInt += 1;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          QLog.e("LebaGridMenuAdapter", 1, localException2, new Object[0]);
        }
      }
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(PluginActionFactory.PluginPool paramPluginPool)
  {
    this.jdField_a_of_type_ComTencentMobileqqLebaHeaderPluginActionFactory$PluginPool = paramPluginPool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.leba.header.LebaGridMenuAdapter
 * JD-Core Version:    0.7.0.1
 */