package com.tencent.mobileqq.location.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.location.api.IFloatMapService;
import com.tencent.mobileqq.location.data.LocationItem;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.ui.headset.HeadAdapter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class HeadSetViewModule
  implements View.OnClickListener
{
  private QPublicFragmentActivity a;
  private HeadAdapter b;
  private TextView c;
  private LocationRoom.RoomKey d;
  
  HeadSetViewModule(Context paramContext)
  {
    if ((paramContext instanceof QPublicFragmentActivity)) {
      this.a = ((QPublicFragmentActivity)paramContext);
    }
    a();
    b();
  }
  
  private void a() {}
  
  private void a(ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel())
    {
      Iterator localIterator = paramArrayList.iterator();
      StringBuilder localStringBuilder;
      for (String str1 = ""; localIterator.hasNext(); str1 = localStringBuilder.toString())
      {
        String str2 = (String)localIterator.next();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str1);
        localStringBuilder.append(", ");
        localStringBuilder.append(str2);
      }
      QLog.d("HeadSetViewModule", 2, new Object[] { "refreshHeadSet: invoked. ", " uins: ", str1, " headAdapter.count: ", Integer.valueOf(this.b.getCount()) });
    }
    if (this.b == null) {
      return;
    }
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = new HeadSetViewModule.1(this, paramArrayList);
      ThreadManager.getUIHandlerV2().post(paramArrayList);
      return;
    }
    QLog.e("HeadSetViewModule", 1, "refreshHeadSet: failed. uins empty, maybe exit room");
  }
  
  private void b()
  {
    ImmersiveUtils.setStatusTextColor(true, this.a.getWindow());
    ImmersiveUtils.setStatusBarDarkMode(this.a.getWindow(), true);
  }
  
  private void b(ArrayList<String> paramArrayList)
  {
    if (paramArrayList.size() == 1)
    {
      this.c.setText(this.a.getResources().getString(2131891382));
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramArrayList.size());
      localStringBuilder.append(this.a.getString(2131891402));
      paramArrayList = localStringBuilder.toString();
      this.c.setText(paramArrayList);
    }
    paramArrayList = this.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.c.getText());
    MapUtils.a(paramArrayList, localStringBuilder.toString());
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HeadSetViewModule", 2, new Object[] { "onClickMinimizeShare: invoked. ", " textSharingCount: ", this.c });
    }
    if (((IFloatMapService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IFloatMapService.class, "")).enterFloat(this.a, this.d)) {
      this.a.finish();
    }
    ReportController.b(null, "CliOper", "", "", "0X800A76F", "0X800A76F", 0, 0, "", "0", "0", "");
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HeadSetViewModule", 2, "onClickCancelShare: invoked. ");
    }
    ActionSheet localActionSheet = ActionSheet.create(this.a);
    localActionSheet.addButton(2131888919, 3);
    localActionSheet.setMainTitle(2131892099);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new HeadSetViewModule.2(this, localActionSheet));
    localActionSheet.show();
    ReportController.b(null, "CliOper", "", "", "0X800A76D", "0X800A76D", 0, 0, "", "0", "0", "");
  }
  
  void a(TextView paramTextView)
  {
    this.c = paramTextView;
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey)
  {
    this.d = paramRoomKey;
  }
  
  void a(HeadAdapter paramHeadAdapter)
  {
    this.b = paramHeadAdapter;
  }
  
  void a(List<LocationItem> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(String.valueOf(((LocationItem)paramList.next()).c()));
    }
    a(localArrayList);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131430289) {
      d();
    } else if (i == 2131438378) {
      c();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.HeadSetViewModule
 * JD-Core Version:    0.7.0.1
 */