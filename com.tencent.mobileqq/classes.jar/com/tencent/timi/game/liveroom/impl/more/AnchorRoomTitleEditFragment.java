package com.tencent.timi.game.liveroom.impl.more;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomAttr;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.timi.game.component.chat.input.TimiInputUtil;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.datareport.api.ILiveReportService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.widget.CommonButton;
import com.tencent.timi.game.ui.widget.CustomToastView;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AnchorRoomTitleEditFragment
  extends QPublicBaseFragment
  implements View.OnClickListener
{
  private View a;
  private EditText b;
  private CommonButton c;
  private long d;
  private String e;
  private int f;
  
  private void a()
  {
    getActivity().finish();
  }
  
  private void a(View paramView)
  {
    this.d = getActivity().getIntent().getLongExtra("roomId", 0L);
    this.e = getActivity().getIntent().getStringExtra("roomName");
    this.f = getActivity().getIntent().getIntExtra("requestCode", 0);
    paramView.findViewById(2131428339).setOnClickListener(this);
    this.a = paramView.findViewById(2131428350);
    this.b = ((EditText)paramView.findViewById(2131428348));
    this.c = ((CommonButton)paramView.findViewById(2131428347));
    AnchorRoomSettingFragment.a(this.a, getActivity());
    this.c.setOnClickListener(this);
    this.b.setText(this.e);
    this.b.addTextChangedListener(new AnchorRoomTitleEditFragment.1(this));
    ConcurrentHashMap localConcurrentHashMap = AnchorMoreSettingUtil.a(this.d);
    ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).a(this, paramView, "pg_qqlive_title_edit", localConcurrentHashMap);
    ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).a(this.b, false, null, "em_qqlive_inputbar", new ConcurrentHashMap());
    ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).a(this.c, false, null, "em_qqlive_savebutton", new ConcurrentHashMap());
    VideoReport.setElementClickPolicy(this.c, ClickPolicy.REPORT_NONE);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityCreated(@Nullable Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.b.requestFocus();
    getActivity().getWindow().setSoftInputMode(5);
    TimiInputUtil.a.a(getActivity(), this.b);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131428339)
    {
      a();
    }
    else if (i == 2131428347)
    {
      boolean bool2 = false;
      Object localObject1;
      boolean bool1;
      if (TextUtils.isEmpty(this.b.getText()))
      {
        CustomToastView.a("标题不能为空");
        localObject1 = "";
        bool1 = bool2;
      }
      else
      {
        localObject2 = this.b.getText().toString();
        bool1 = bool2;
        localObject1 = localObject2;
        if (!((String)localObject2).equals(this.e))
        {
          IQQLiveAnchorRoom localIQQLiveAnchorRoom = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).c(this.d);
          if (localIQQLiveAnchorRoom != null)
          {
            QQLiveAnchorDataRoomAttr localQQLiveAnchorDataRoomAttr = localIQQLiveAnchorRoom.getAnchorRoomInfo().roomAttr;
            localObject1 = localQQLiveAnchorDataRoomAttr;
            if (localQQLiveAnchorDataRoomAttr == null)
            {
              localObject1 = new QQLiveAnchorDataRoomAttr();
              ((QQLiveAnchorDataRoomAttr)localObject1).roomId = localIQQLiveAnchorRoom.getRoomInfo().getRoomId();
            }
            ((QQLiveAnchorDataRoomAttr)localObject1).roomName = ((String)localObject2);
            localIQQLiveAnchorRoom.startSet((QQLiveAnchorDataRoomAttr)localObject1);
            CustomToastView.a("修改成功");
            bool1 = true;
            localObject1 = localObject2;
          }
          else
          {
            CustomToastView.a("修改失败，请退出重试");
            localObject1 = localObject2;
            bool1 = bool2;
          }
        }
      }
      Object localObject2 = new ConcurrentHashMap();
      ((ConcurrentHashMap)localObject2).put("qqlive_title_content", localObject1);
      ((ConcurrentHashMap)localObject2).put("qqlive_is_success", String.valueOf(bool1));
      ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).a("clck", this.c, (Map)localObject2);
      if (bool1)
      {
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("title", (String)localObject1);
        getActivity().setResult(this.f, (Intent)localObject2);
        getActivity().finish();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131629418, paramViewGroup, false);
    a(paramLayoutInflater);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.more.AnchorRoomTitleEditFragment
 * JD-Core Version:    0.7.0.1
 */