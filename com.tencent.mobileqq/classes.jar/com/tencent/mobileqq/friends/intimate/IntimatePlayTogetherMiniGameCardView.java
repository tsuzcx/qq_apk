package com.tencent.mobileqq.friends.intimate;

import NS_MINI_APP_MISC.MISC.StAppPlayingInfo;
import NS_MINI_APP_MISC.MISC.StGetFriendPlayListV2Rsp;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig.SimpleMiniAppInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageView;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.CommonBody;
import tencent.im.oidb.oidb_0xd84.RspBody;

public class IntimatePlayTogetherMiniGameCardView
  extends FrameLayout
{
  private RecyclerView a;
  private TextView b;
  private ImageView c;
  private LinearLayout d;
  
  public IntimatePlayTogetherMiniGameCardView(@NonNull Context paramContext)
  {
    super(paramContext);
    a(paramContext, null, 0);
  }
  
  public IntimatePlayTogetherMiniGameCardView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet, 0);
  }
  
  public IntimatePlayTogetherMiniGameCardView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    LayoutInflater.from(paramContext).inflate(2131625194, this);
    this.a = ((RecyclerView)findViewById(2131433808));
    this.b = ((TextView)findViewById(2131433811));
    this.c = ((ImageView)findViewById(2131433809));
    this.d = ((LinearLayout)findViewById(2131433812));
    setVisibility(8);
  }
  
  public static void a(View paramView, IntimateInfo paramIntimateInfo)
  {
    if ((paramView instanceof ViewGroup))
    {
      paramView = (IntimatePlayTogetherMiniGameCardView)((ViewGroup)paramView).findViewById(2131433807);
      if (paramView != null) {
        paramView.a(paramIntimateInfo);
      }
    }
  }
  
  private void a(IntimateInfo paramIntimateInfo)
  {
    Object localObject1;
    Object localObject3;
    Object localObject2;
    int i;
    if ((paramIntimateInfo != null) && (paramIntimateInfo.commonBodies != null) && (!paramIntimateInfo.commonBodies.isEmpty()))
    {
      localObject1 = null;
      localObject3 = paramIntimateInfo.commonBodies.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject2 = (oidb_0xcf4.CommonBody)((Iterator)localObject3).next();
        if (((oidb_0xcf4.CommonBody)localObject2).uint32_oidb_cmd.get() == 3460) {
          localObject1 = localObject2;
        }
      }
      i = 1;
      if (localObject1 == null)
      {
        QLog.d("IntimatePlayTogetherMin", 1, new Object[] { "updateIntimateInfo", "no 0xd84 cmd found in common body response" });
        setVisibility(8);
        return;
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = new oidb_0xd84.RspBody();
        ((oidb_0xd84.RspBody)localObject2).mergeFrom(((oidb_0xcf4.CommonBody)localObject1).string_oidb_body.get().toByteArray());
        localObject1 = new MISC.StGetFriendPlayListV2Rsp();
        ((MISC.StGetFriendPlayListV2Rsp)localObject1).mergeFrom(((oidb_0xd84.RspBody)localObject2).bytes_xmitinfo.get().toByteArray());
        if (((MISC.StGetFriendPlayListV2Rsp)localObject1).appPlayingInfos.size() <= 0)
        {
          setVisibility(8);
          return;
        }
        localObject2 = new IntimatePlayTogetherMiniGameCardView.1(this, (MISC.StGetFriendPlayListV2Rsp)localObject1);
        setVisibility(0);
        if (this.b != null) {
          this.b.setText(String.valueOf(((MISC.StGetFriendPlayListV2Rsp)localObject1).total.get()));
        }
        if ((((MISC.StGetFriendPlayListV2Rsp)localObject1).total.get() < 2) || (TextUtils.isEmpty(((MISC.StGetFriendPlayListV2Rsp)localObject1).moreJumpLink.get()))) {
          break label500;
        }
        if (this.c != null)
        {
          localObject3 = this.c;
          if (i == 0) {
            break label505;
          }
          j = 0;
          ((ImageView)localObject3).setVisibility(j);
        }
        if (this.a != null)
        {
          this.a.setLayoutManager(new LinearLayoutManager(getContext()));
          paramIntimateInfo = new IntimatePlayTogetherMiniGameCardView.IntimatePlayTogetherAdapter(((MISC.StGetFriendPlayListV2Rsp)localObject1).appPlayingInfos.get(), paramIntimateInfo.friendUin, (View.OnClickListener)localObject2);
          paramIntimateInfo.b(2064);
          this.a.setAdapter(paramIntimateInfo);
        }
        paramIntimateInfo = ((MISC.StAppPlayingInfo)((MISC.StGetFriendPlayListV2Rsp)localObject1).appPlayingInfos.get().get(0)).appMetaInfo;
        localObject3 = new SimpleMiniAppConfig(SimpleMiniAppConfig.SimpleMiniAppInfo.from(paramIntimateInfo));
        if (((SimpleMiniAppConfig)localObject3).launchParam != null) {
          ((SimpleMiniAppConfig)localObject3).launchParam.scene = 2064;
        }
        if (!MiniGamePlayTogetherHandler.a(paramIntimateInfo)) {
          break label510;
        }
        paramIntimateInfo = "c2close";
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).report4239Async((SimpleMiniAppConfig)localObject3, paramIntimateInfo, "expo", null, null);
        if (i != 0) {
          ((IMiniAppService)QRoute.api(IMiniAppService.class)).onMiniGameCardShowMoreView(((MISC.StGetFriendPlayListV2Rsp)localObject1).moreJumpLink.get(), 2, ((MISC.StGetFriendPlayListV2Rsp)localObject1).total.get());
        }
        setOnClickListener((View.OnClickListener)localObject2);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramIntimateInfo)
      {
        QLog.e("IntimatePlayTogetherMin", 2, "updateIntimateInfo", paramIntimateInfo);
        setVisibility(8);
        return;
      }
      setVisibility(8);
      return;
      label500:
      i = 0;
      continue;
      label505:
      int j = 4;
      continue;
      label510:
      paramIntimateInfo = "page_view";
    }
  }
  
  private static void b(ThemeImageView paramThemeImageView, String paramString)
  {
    if (paramThemeImageView != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = (QQAppInterface)localObject;
        localObject = ((IQQAvatarService)((QQAppInterface)localObject).getRuntimeService(IQQAvatarService.class, "")).getInstance((AppInterface)localObject);
        Bitmap localBitmap = ((IFaceDecoder)localObject).getBitmapFromCache(1, paramString, 0, (byte)4);
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          ((IFaceDecoder)localObject).destory();
          paramThemeImageView.setImageBitmap(localBitmap);
          return;
        }
        ((IFaceDecoder)localObject).setDecodeTaskCompletionListener(new IntimatePlayTogetherMiniGameCardView.2((IFaceDecoder)localObject, paramThemeImageView));
        ((IFaceDecoder)localObject).requestDecodeFace(paramString, 200, false, 1, true, (byte)0, 4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.friends.intimate.IntimatePlayTogetherMiniGameCardView
 * JD-Core Version:    0.7.0.1
 */