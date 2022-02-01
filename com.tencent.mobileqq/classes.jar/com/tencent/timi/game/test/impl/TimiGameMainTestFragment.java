package com.tencent.timi.game.test.impl;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.timi.game.api.live.ILiveReportUtil;
import com.tencent.timi.game.datareport.api.ILiveReportService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService;
import com.tencent.timi.game.tim.api.ITimiGameTimApi;
import com.tencent.timi.game.web.business.api.IWebBusinessService;
import com.tencent.widget.Switch;
import java.util.HashMap;
import java.util.Map;

public class TimiGameMainTestFragment
  extends QPublicBaseFragment
{
  private String a = "https://test-live.yes.qq.com/Home?gameId=1&anchorId=E10CA96B796C0CA835EEDB8D416B24F8";
  
  private void a(View paramView)
  {
    ((ITimiGameTimApi)ServiceCenter.a(ITimiGameTimApi.class)).a();
    ((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).d(null);
    Object localObject1 = (Switch)paramView.findViewById(2131429775);
    ((Switch)localObject1).setChecked(false);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("网络底层切换(当前：");
    ((StringBuilder)localObject2).append("MSF");
    ((StringBuilder)localObject2).append(")   ");
    ((Switch)localObject1).setText(((StringBuilder)localObject2).toString());
    ((Switch)localObject1).setOnCheckedChangeListener(new TimiGameMainTestFragment.1(this));
    paramView.findViewById(2131429779).setOnClickListener(new TimiGameMainTestFragment.2(this));
    paramView.findViewById(2131429774).setOnClickListener(new TimiGameMainTestFragment.3(this));
    ((IWebBusinessService)ServiceCenter.a(IWebBusinessService.class)).b();
    paramView.findViewById(2131435849).setOnClickListener(new TimiGameMainTestFragment.4(this));
    paramView.findViewById(2131439426).setOnClickListener(new TimiGameMainTestFragment.5(this));
    paramView.findViewById(2131450067).setOnClickListener(new TimiGameMainTestFragment.6(this));
    paramView.findViewById(2131431568).setOnClickListener(new TimiGameMainTestFragment.7(this));
    paramView.findViewById(2131434238).setOnClickListener(new TimiGameMainTestFragment.8(this));
    paramView.findViewById(2131435368).setOnClickListener(new TimiGameMainTestFragment.9(this));
    paramView.findViewById(2131433431).setOnClickListener(new TimiGameMainTestFragment.10(this));
    localObject1 = paramView.findViewById(2131445143);
    localObject2 = new HashMap();
    ((HashMap)localObject2).put("url", "https://puui.qpic.cn/vupload/0/20190307_1551949943235_fyzjsfvz9xk.png/0");
    ((HashMap)localObject2).put("ranlili", "https://puui.qpic.cn/vupload/0/20190307_1551949943235_fyzjsfvz9xk.png/0");
    ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).a().a(this, localObject1, "page_yolo_test", (Map)localObject2);
    localObject1 = paramView.findViewById(2131444663);
    VideoReport.setElementId(localObject1, "ranliliReportTestContainer");
    localObject2 = new HashMap(1);
    ((Map)localObject2).put("buttonType", "submit");
    ((Map)localObject2).put("ranliliContainer", "ranliliContainerValue");
    VideoReport.setElementParams(localObject1, (Map)localObject2);
    paramView = paramView.findViewById(2131444662);
    VideoReport.setElementId(paramView, "ranliliReportTestBtn");
    localObject2 = new HashMap(1);
    ((Map)localObject2).put("ranliliBtnButtonType", "submitButtonTyp");
    ((Map)localObject2).put("ranliliBtn", "ranliliContainerBtn");
    VideoReport.setElementParams(paramView, (Map)localObject2);
    paramView.setOnClickListener(new TimiGameMainTestFragment.11(this));
    VideoReport.setElementClickPolicy(localObject1, ClickPolicy.REPORT_ALL);
    VideoReport.setElementExposePolicy(localObject1, ExposurePolicy.REPORT_ALL);
    VideoReport.setElementEndExposePolicy(localObject1, EndExposurePolicy.REPORT_ALL);
    VideoReport.setElementClickPolicy(paramView, ClickPolicy.REPORT_ALL);
    VideoReport.setElementExposePolicy(paramView, ExposurePolicy.REPORT_ALL);
    VideoReport.setElementEndExposePolicy(paramView, EndExposurePolicy.REPORT_ALL);
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131629500, paramViewGroup, false);
    a(paramLayoutInflater);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.test.impl.TimiGameMainTestFragment
 * JD-Core Version:    0.7.0.1
 */