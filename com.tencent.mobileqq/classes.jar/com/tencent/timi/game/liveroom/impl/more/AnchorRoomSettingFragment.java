package com.tencent.timi.game.liveroom.impl.more;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.QPublicFragmentActivityForTool;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qqlive.api.IQQLiveUtil;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.data.CoverInfo;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomAttr;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.datareport.api.ILiveReportService;
import com.tencent.timi.game.liveroom.impl.blacklist.AnchorRoomBlackListFragment;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.ui.widget.RoundCornerImageView;
import com.tencent.timi.game.utils.Logger;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AnchorRoomSettingFragment
  extends QPublicBaseFragment
  implements View.OnClickListener
{
  private View a;
  private RoundCornerImageView b;
  private TextView c;
  private View d;
  private View e;
  private long f;
  private Uri g;
  private boolean h = false;
  private URLDrawable.URLDrawableOptions i;
  
  private void a()
  {
    getActivity().finish();
  }
  
  public static void a(Context paramContext, long paramLong)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("roomId", paramLong);
    QPublicFragmentActivity.Launcher.a(paramContext, localIntent, QPublicFragmentActivityForTool.class, AnchorRoomSettingFragment.class);
  }
  
  private void a(View paramView)
  {
    this.f = getActivity().getIntent().getLongExtra("roomId", 0L);
    this.a = paramView.findViewById(2131428350);
    this.b = ((RoundCornerImageView)paramView.findViewById(2131428341));
    this.c = ((TextView)paramView.findViewById(2131428346));
    this.d = paramView.findViewById(2131428344);
    this.e = paramView.findViewById(2131428342);
    a(this.a, getActivity());
    float f1 = Utils.b(12.0F, getResources());
    this.b.setRadius(f1, f1, f1, f1);
    paramView.findViewById(2131428339).setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    Object localObject1 = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).d(this.f);
    if (localObject1 != null) {
      localObject1 = ((QQLiveAnchorRoomInfo)localObject1).roomAttr;
    } else {
      localObject1 = null;
    }
    String str = "";
    if (localObject1 != null)
    {
      str = ((QQLiveAnchorDataRoomAttr)localObject1).roomName;
      localObject1 = ((QQLiveAnchorDataRoomAttr)localObject1).poster16v9;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("init title-");
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append(", cover-");
      ((StringBuilder)localObject2).append((String)localObject1);
      Logger.a("AnchorRoomSettingFragment", ((StringBuilder)localObject2).toString());
    }
    else
    {
      CustomToastView.a("无法获取房间信息");
      localObject1 = "";
    }
    this.i = URLDrawable.URLDrawableOptions.obtain();
    Object localObject2 = getResources().getDrawable(2130852855);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = this.i;
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject2);
    localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject2);
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      this.b.setImageDrawable(URLDrawable.getDrawable((String)localObject1, this.i));
    } else {
      this.b.setImageDrawable((Drawable)localObject2);
    }
    this.c.setText(str);
    localObject1 = AnchorMoreSettingUtil.a(this.f);
    ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).a(this, paramView, "pg_qqlive_roomset", (Map)localObject1);
    ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).a(this.b, false, null, "em_qqlive_cover_edit", new ConcurrentHashMap());
    ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).a(this.d, false, null, "em_qqlive_title_edit", new ConcurrentHashMap());
    ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).a(this.e, false, null, "em_qqlive_blocklistset", new ConcurrentHashMap());
  }
  
  public static void a(View paramView, Activity paramActivity)
  {
    int j = ImmersiveUtils.isSupporImmersive();
    boolean bool = true;
    if (j != 1) {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isSupportImmesive = ");
    localStringBuilder.append(bool);
    Logger.a("AnchorRoomSetting", localStringBuilder.toString());
    if (bool)
    {
      j = ImmersiveUtils.getStatusBarHeight(paramActivity);
      paramActivity = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      paramActivity.setMargins(paramActivity.leftMargin, paramActivity.topMargin + j, paramActivity.rightMargin, paramActivity.bottomMargin);
      paramView.setLayoutParams(paramActivity);
    }
  }
  
  private void a(CoverInfo paramCoverInfo)
  {
    Object localObject;
    if (paramCoverInfo != null) {
      localObject = paramCoverInfo.roomLogo16v9;
    } else {
      localObject = "";
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      this.b.setImageDrawable(URLDrawable.getDrawable((String)localObject, this.i));
      IQQLiveAnchorRoom localIQQLiveAnchorRoom = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).c(this.f);
      if (localIQQLiveAnchorRoom != null)
      {
        QQLiveAnchorDataRoomAttr localQQLiveAnchorDataRoomAttr = localIQQLiveAnchorRoom.getAnchorRoomInfo().roomAttr;
        localObject = localQQLiveAnchorDataRoomAttr;
        if (localQQLiveAnchorDataRoomAttr == null)
        {
          localObject = new QQLiveAnchorDataRoomAttr();
          ((QQLiveAnchorDataRoomAttr)localObject).roomId = localIQQLiveAnchorRoom.getRoomInfo().getRoomId();
        }
        ((QQLiveAnchorDataRoomAttr)localObject).poster = paramCoverInfo.roomLogo;
        ((QQLiveAnchorDataRoomAttr)localObject).poster3v4 = paramCoverInfo.roomLogo3v4;
        ((QQLiveAnchorDataRoomAttr)localObject).poster16v9 = paramCoverInfo.roomLogo16v9;
        ((QQLiveAnchorDataRoomAttr)localObject).posterTime = paramCoverInfo.roomLogoTime;
        ((QQLiveAnchorDataRoomAttr)localObject).posterTime3v4 = paramCoverInfo.roomLogoTime3v4;
        ((QQLiveAnchorDataRoomAttr)localObject).posterTime16v9 = paramCoverInfo.roomLogoTime16v9;
        localIQQLiveAnchorRoom.startSet((QQLiveAnchorDataRoomAttr)localObject);
        CustomToastView.a("封面设置成功");
        return;
      }
      CustomToastView.a("封面设置失败，请退出重试");
    }
  }
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      ((IQQLiveUtil)QRoute.api(IQQLiveUtil.class)).enterCropFragment(getActivity(), paramString, String.valueOf(this.f), 2);
      return;
    }
    Logger.c("AnchorRoomSettingFragment", "cropImg but picPath is null");
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      paramIntent = this.g;
      if (paramIntent != null)
      {
        paramIntent = BaseImageUtil.b(getContext(), paramIntent);
        if (!TextUtils.isEmpty(paramIntent)) {
          a(paramIntent);
        }
      }
    }
    else
    {
      if (paramInt1 == 2)
      {
        if (paramIntent == null) {
          return;
        }
        paramIntent = (CoverInfo)paramIntent.getSerializableExtra("COVER_INFO_KEY");
        if (paramIntent != null) {
          a(paramIntent);
        }
        this.h = false;
        return;
      }
      if (paramInt1 == 3)
      {
        if (paramIntent == null) {
          return;
        }
        paramIntent = paramIntent.getStringExtra("title");
        if (!TextUtils.isEmpty(paramIntent)) {
          this.c.setText(paramIntent);
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    if (j == 2131428339) {
      a();
    } else if (j == 2131428341) {
      CustomToastView.a("暂时未开放编辑，请留意后续版本升级");
    } else if (j == 2131428344) {
      CustomToastView.a("暂时未开放编辑，请留意后续版本升级");
    } else if (j == 2131428342) {
      AnchorRoomBlackListFragment.a(getContext(), this.f);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131629417, paramViewGroup, false);
    a(paramLayoutInflater);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((paramIntent != null) && (!this.h))
    {
      this.h = true;
      if (paramIntent.size() > 0)
      {
        paramIntent = (String)paramIntent.get(0);
        if (!TextUtils.isEmpty(paramIntent))
        {
          a(paramIntent);
          return;
        }
        Logger.c("AnchorRoomSettingFragment", "[onNewIntent] the path is empty");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.more.AnchorRoomSettingFragment
 * JD-Core Version:    0.7.0.1
 */