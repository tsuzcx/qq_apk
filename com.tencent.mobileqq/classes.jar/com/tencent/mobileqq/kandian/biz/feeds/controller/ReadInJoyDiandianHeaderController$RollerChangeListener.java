package com.tencent.mobileqq.kandian.biz.feeds.controller;

import androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener;
import com.tencent.mobileqq.kandian.biz.channel.banner.RollViewPager;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.repo.comment.entity.DiandianTopConfig;
import com.tencent.mobileqq.widget.MeasureGridView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyDiandianHeaderController$RollerChangeListener
  extends ViewPager.SimpleOnPageChangeListener
{
  int a = 0;
  
  protected ReadInJoyDiandianHeaderController$RollerChangeListener(ReadInJoyDiandianHeaderController paramReadInJoyDiandianHeaderController) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt != 0) {
      return;
    }
    int i = ReadInJoyDiandianHeaderController.c(this.b).getCurrentItem();
    ReadInJoyDiandianHeaderController localReadInJoyDiandianHeaderController = this.b;
    localReadInJoyDiandianHeaderController.b = i;
    paramInt = ReadInJoyDiandianHeaderController.b(localReadInJoyDiandianHeaderController).getCount();
    if (paramInt <= 1) {
      return;
    }
    if (i == 1) {
      ReadInJoyDiandianHeaderController.b(this.b).instantiateItem(null, paramInt - 3);
    } else if (i == paramInt - 3) {
      ReadInJoyDiandianHeaderController.b(this.b).instantiateItem(null, 1);
    }
    if (i == 0) {
      paramInt -= 3;
    } else if (i == paramInt - 2) {
      paramInt = 1;
    } else {
      paramInt = i;
    }
    if (i != paramInt)
    {
      localReadInJoyDiandianHeaderController = this.b;
      localReadInJoyDiandianHeaderController.b = paramInt;
      ReadInJoyDiandianHeaderController.c(localReadInJoyDiandianHeaderController).setCurrentItem(paramInt, false);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    super.onPageScrolled(paramInt1, paramFloat, paramInt2);
  }
  
  public void onPageSelected(int paramInt)
  {
    int i = ReadInJoyDiandianHeaderController.b(this.b).a(paramInt);
    if ((this.a != i) && (ReadInJoyDiandianHeaderController.a(this.b))) {
      PublicAccountReportUtils.a(null, "", "0X8009826", "0X8009826", 0, 0, "", "", "", "", false);
    }
    if ((i >= 0) && (this.a >= 0)) {
      this.a = i;
    }
    if (ReadInJoyDiandianHeaderController.f(this.b).get(i) != null)
    {
      ReadInJoyDiandianHeaderController.HeaderListAdapter localHeaderListAdapter = (ReadInJoyDiandianHeaderController.HeaderListAdapter)((MeasureGridView)ReadInJoyDiandianHeaderController.f(this.b).get(i)).getAdapter();
      paramInt = 0;
      while (paramInt < localHeaderListAdapter.getCount())
      {
        DiandianTopConfig localDiandianTopConfig = (DiandianTopConfig)localHeaderListAdapter.getItem(paramInt);
        if ((localDiandianTopConfig != null) && (!localDiandianTopConfig.hasExposeReported)) {
          try
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
            int j = localDiandianTopConfig.type;
            if (j == 5) {
              localJSONObject.put("list_URL", localDiandianTopConfig.jumpUrl);
            } else {
              localJSONObject.put("list_URL", "0");
            }
            localJSONObject.put("type", localDiandianTopConfig.type);
            Object localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(ReadInJoyDiandianHeaderController.g(this.b).size());
            ((StringBuilder)localObject1).append("");
            localObject1 = ((StringBuilder)localObject1).toString();
            Object localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(i + 1);
            ((StringBuilder)localObject2).append("");
            localObject2 = ((StringBuilder)localObject2).toString();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(localDiandianTopConfig.topicId);
            localStringBuilder.append("");
            PublicAccountReportUtils.a(null, "", "0X80092FC", "0X80092FC", 0, 0, (String)localObject1, (String)localObject2, localStringBuilder.toString(), localJSONObject.toString(), false);
            localDiandianTopConfig.hasExposeReported = true;
            localHeaderListAdapter.a(paramInt, localDiandianTopConfig);
          }
          catch (JSONException localJSONException)
          {
            if (QLog.isColorLevel()) {
              QLog.e("ReadInJoyDiandianHeaderController", 2, localJSONException.toString());
            }
          }
        }
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyDiandianHeaderController.RollerChangeListener
 * JD-Core Version:    0.7.0.1
 */