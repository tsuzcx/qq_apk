package com.tencent.timi.game.liveroom.impl.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveAnchorStreamRecordType;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.widget.CommonButton;
import com.tencent.timi.game.utils.Logger;

public class TgLiveRoomTestFragment
  extends QPublicBaseFragment
{
  private EditText a;
  private TextView b;
  private TextView c;
  private CommonButton d;
  private TextView e;
  private View f;
  
  private void a(View paramView)
  {
    paramView.findViewById(2131447295).setOnClickListener(new TgLiveRoomTestFragment.1(this));
    paramView.findViewById(2131447286).setOnClickListener(new TgLiveRoomTestFragment.2(this));
    paramView.findViewById(2131447288).setOnClickListener(new TgLiveRoomTestFragment.3(this));
    paramView.findViewById(2131447285).setOnClickListener(new TgLiveRoomTestFragment.4(this));
    paramView.findViewById(2131447287).setOnClickListener(new TgLiveRoomTestFragment.5(this));
    this.a = ((EditText)paramView.findViewById(2131447300));
    paramView.findViewById(2131447299).setOnClickListener(new TgLiveRoomTestFragment.6(this));
    this.b = ((TextView)paramView.findViewById(2131447292));
    this.c = ((TextView)paramView.findViewById(2131447290));
    this.d = ((CommonButton)paramView.findViewById(2131447291));
    this.e = ((TextView)paramView.findViewById(2131447289));
    this.d.setOnClickListener(new TgLiveRoomTestFragment.7(this));
    this.e.setOnClickListener(new TgLiveRoomTestFragment.8(this));
    this.d.setEnabled(false);
    this.e.setEnabled(false);
    paramView.findViewById(2131447301).setOnClickListener(new TgLiveRoomTestFragment.9(this));
    paramView = new LiveUserInfo();
    paramView.headUrl = "https://thirdqq.qlogo.cn/g?b=oidb&k=8GHTq0bzoYEklP24NyBYPg&s=140&t=1555927329";
    paramView.nick = "haha";
  }
  
  private void a(QQLiveAnchorStreamRecordType paramQQLiveAnchorStreamRecordType)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("anchorStartLive_");
    localStringBuilder.append(paramQQLiveAnchorStreamRecordType);
    Logger.a("TgLiveTag_TgLiveUtilsTgLiveRoomTestFragment_", localStringBuilder.toString());
    ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).a(paramQQLiveAnchorStreamRecordType, false, new TgLiveRoomTestFragment.10(this, paramQQLiveAnchorStreamRecordType));
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.f = paramLayoutInflater.inflate(2131629503, paramViewGroup, false);
    a(this.f);
    paramLayoutInflater = this.f;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.test.TgLiveRoomTestFragment
 * JD-Core Version:    0.7.0.1
 */