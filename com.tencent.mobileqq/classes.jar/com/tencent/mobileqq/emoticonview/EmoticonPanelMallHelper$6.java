package com.tencent.mobileqq.emoticonview;

import amtj;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import bcef;
import bfzg;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.app.MobileQQ;

class EmoticonPanelMallHelper$6
  implements AdapterView.OnItemClickListener
{
  EmoticonPanelMallHelper$6(EmoticonPanelMallHelper paramEmoticonPanelMallHelper) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    QQAppInterface localQQAppInterface = this.this$0.mPanelController.app;
    long l = System.currentTimeMillis();
    bfzg.a(null, "AIO_EmoticonPanel_TabClick");
    Object localObject1 = this.this$0.mPanelController.panelDataList;
    if (localObject1 == null) {}
    while ((paramInt >= ((List)localObject1).size()) || (((EmoticonPanelTabSortHelper)this.this$0.mPanelController.getHelper(8)).setSelection(paramInt)))
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelMallHelper", 2, "mOnItemClicked position: " + paramInt);
    }
    EmoticonPanelMallHelper.access$002(this.this$0, true);
    EmoticonPanelMallHelper.access$102(this.this$0, 1);
    this.this$0.mPanelController.mEmoticonTabs.setSelection(paramInt);
    boolean bool;
    label185:
    Object localObject2;
    Object localObject6;
    Object localObject4;
    label262:
    int i;
    Object localObject3;
    if ((((List)localObject1).size() > EmoticonPanelController.sRecommendEmoticonViewPoSition) && (((EmotionPanelInfo)((List)localObject1).get(EmoticonPanelController.sRecommendEmoticonViewPoSition)).type == 8))
    {
      bool = true;
      EmoticonPanelController.sIsRecommendExist = bool;
      localObject2 = (EmotionPanelInfo)((List)localObject1).get(paramInt);
      localObject1 = "";
      localObject6 = "";
      localObject4 = "";
      if (((EmotionPanelInfo)localObject2).type != 8) {
        break label594;
      }
      localObject2 = amtj.a(2131703205);
      localObject1 = (ImageView)paramView.findViewById(2131376196);
      bool = false;
      if (localObject1 != null)
      {
        if (((ImageView)localObject1).getVisibility() != 0) {
          break label581;
        }
        bool = true;
        ((ImageView)localObject1).setVisibility(8);
      }
      localObject1 = localQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0);
      ((SharedPreferences)localObject1).edit().putBoolean("isClickRecommendRedpoint", true).putBoolean("is_red_when_click_recommend", bool).apply();
      i = ((SharedPreferences)localObject1).getInt("recommendRuleId", -1);
      localObject3 = localQQAppInterface.getCurrentUin();
      if (!bool) {
        break label587;
      }
      localObject1 = "1";
      label339:
      VasWebviewUtil.reportCommercialDrainage((String)localObject3, "ep_mall", "0X8005798", "", 0, 0, 0, "", "", "", (String)localObject1, "", i + "", "", 0, 0, 0, 0);
      bool = false;
      localObject1 = "0X800AE0B";
      localObject3 = "0X8005798";
    }
    for (;;)
    {
      i = this.this$0.mPanelController.getFromType(bool);
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (i != 0)) {
        bcef.b(localQQAppInterface, "dc00898", "", "", (String)localObject1, (String)localObject1, i, 0, "1", "", "", "");
      }
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        bcef.b(localQQAppInterface, "CliOper", "", "", "ep_mall", (String)localObject3, 0, 0, (String)localObject6, "", (String)localObject4, "");
      }
      if (EmoticonPanelController.sLastSelectedSecondTabIndex == paramInt) {
        break;
      }
      EmoticonPanelController.sLastSelectedSecondTabIndex = paramInt;
      this.this$0.mPanelController.showPanelByTabIndex(paramInt);
      if (AppSetting.c) {
        QQAppInterface.speak((String)localObject2);
      }
      bfzg.a("AIO_EmoticonPanel_TabClick", null);
      this.this$0.mPanelController.isClickNoChangeTab = true;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("EmoticonPanelMallHelper", 2, "[Performance] TabsChanged duration:" + (System.currentTimeMillis() - l));
      break;
      bool = false;
      break label185;
      label581:
      bool = false;
      break label262;
      label587:
      localObject1 = "";
      break label339;
      label594:
      if (((EmotionPanelInfo)localObject2).type == 9)
      {
        localObject1 = "0X800AE0D";
        bool = false;
        localObject2 = amtj.a(2131703194);
        localObject3 = "0X8005797";
      }
      else if (((EmotionPanelInfo)localObject2).type == 4)
      {
        localObject2 = amtj.a(2131703167);
        bcef.b(localQQAppInterface, "dc00898", "", "", "0x800a56e", "0x800a56e", 0, 0, "", "", "", "");
        ((EmoticonPanelFavHelper)this.this$0.mPanelController.getHelper(2)).doSyncFavEmotion();
        bool = true;
        localObject1 = "0X800AE08";
        localObject3 = "0X8005799";
      }
      else
      {
        if (((EmotionPanelInfo)localObject2).type != 7) {
          break label739;
        }
        localObject1 = "0X800AE07";
        localObject2 = amtj.a(2131703214);
        bool = true;
        localObject3 = "0X800579A";
      }
    }
    label739:
    Object localObject5;
    if (((EmotionPanelInfo)localObject2).type == 6)
    {
      localObject4 = ((EmotionPanelInfo)localObject2).emotionPkg;
      if (localObject4 == null) {
        break label1152;
      }
      localObject2 = ((EmoticonPackage)localObject4).epId;
      if (((EmoticonPackage)localObject4).status == 2)
      {
        localObject1 = "0X800584E";
        label782:
        localObject3 = Integer.toString(this.this$0.mPanelController.getEmoticonTab((String)localObject2));
        localObject6 = amtj.a(2131703174) + ((EmoticonPackage)localObject4).name + amtj.a(2131703191);
        if (((EmoticonPackage)localObject4).status == 2) {
          break label1125;
        }
        localObject6 = (String)localObject6 + amtj.a(2131703217);
        localObject5 = localObject3;
        localObject4 = localObject1;
        localObject1 = localObject6;
        localObject3 = localObject2;
        localObject2 = localObject5;
      }
    }
    for (;;)
    {
      Object localObject7 = localObject1;
      localObject5 = localObject2;
      localObject6 = localObject3;
      localObject3 = localObject4;
      bool = false;
      localObject1 = "0X800AE0C";
      localObject2 = localObject7;
      localObject4 = localObject5;
      break;
      localObject1 = "0X80059B8";
      break label782;
      if (((EmotionPanelInfo)localObject2).type == 11)
      {
        localObject2 = amtj.a(2131703215);
        localObject1 = (ImageView)paramView.findViewById(2131376196);
        if (localObject1 != null)
        {
          ((ImageView)localObject1).setVisibility(8);
          localObject1 = this.this$0.mPanelController.mBaseChatPie;
          if ((localObject1 != null) && (((BaseChatPie)localObject1).panelicons != null)) {
            ((BaseChatPie)localObject1).panelicons.setShowRed(3, false);
          }
        }
        bcef.b(localQQAppInterface, "dc00898", "", "", "0X800A36D", "0X800A36D", 0, 0, "", "", "", "");
        bool = true;
        localObject1 = "0X800AE0A";
        localObject3 = "";
        break;
      }
      if (((EmotionPanelInfo)localObject2).type == 12)
      {
        localObject1 = "0X800AE09";
        bool = true;
        localObject3 = "";
        localObject2 = "";
        break;
      }
      if (((EmotionPanelInfo)localObject2).type == 10)
      {
        bool = false;
        localObject1 = "0X800AE0C";
        localObject2 = "";
        localObject3 = "";
        break;
      }
      bool = true;
      localObject3 = "";
      localObject2 = "";
      break;
      label1125:
      localObject4 = localObject2;
      localObject5 = localObject1;
      localObject1 = localObject6;
      localObject2 = localObject3;
      localObject3 = localObject4;
      localObject4 = localObject5;
      continue;
      label1152:
      localObject1 = "";
      localObject4 = "";
      localObject3 = "";
      localObject2 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.6
 * JD-Core Version:    0.7.0.1
 */