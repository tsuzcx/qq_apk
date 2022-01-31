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
import aqkm;
import aqko;
import aqkp;
import aqkq;
import baxk;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageView;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.CommonBody;
import tencent.im.oidb.oidb_0xd84.RspBody;

public class IntimatePlayTogetherMiniGameCardView
  extends FrameLayout
{
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
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
    LayoutInflater.from(paramContext).inflate(2131559155, this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131366811));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366814));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131366812));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131366815));
    setVisibility(8);
  }
  
  public static void a(View paramView, IntimateInfo paramIntimateInfo)
  {
    if ((paramView instanceof ViewGroup))
    {
      paramView = (IntimatePlayTogetherMiniGameCardView)((ViewGroup)paramView).findViewById(2131366810);
      if (paramView != null) {
        paramView.a(paramIntimateInfo);
      }
    }
  }
  
  private void a(IntimateInfo paramIntimateInfo)
  {
    Object localObject1 = null;
    Object localObject3;
    Object localObject2;
    if ((paramIntimateInfo != null) && (paramIntimateInfo.commonBodies != null) && (!paramIntimateInfo.commonBodies.isEmpty()))
    {
      localObject3 = paramIntimateInfo.commonBodies.iterator();
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = (oidb_0xcf4.CommonBody)((Iterator)localObject3).next();
        if (((oidb_0xcf4.CommonBody)localObject2).uint32_oidb_cmd.get() != 3460) {
          break label469;
        }
        localObject1 = localObject2;
      }
    }
    label457:
    label469:
    for (;;)
    {
      break;
      if (localObject1 == null)
      {
        QLog.d("IntimatePlayTogetherMin", 1, new Object[] { "updateIntimateInfo", "no 0xd84 cmd found in common body response" });
        setVisibility(8);
        return;
      }
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
      }
      catch (InvalidProtocolBufferMicroException paramIntimateInfo)
      {
        QLog.e("IntimatePlayTogetherMin", 2, "updateIntimateInfo", paramIntimateInfo);
        setVisibility(8);
        return;
      }
      localObject2 = new aqkm(this, (MISC.StGetFriendPlayListV2Rsp)localObject1);
      setVisibility(0);
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(((MISC.StGetFriendPlayListV2Rsp)localObject1).total.get()));
      }
      int i;
      if ((((MISC.StGetFriendPlayListV2Rsp)localObject1).total.get() >= 2) && (!TextUtils.isEmpty(((MISC.StGetFriendPlayListV2Rsp)localObject1).moreJumpLink.get())))
      {
        i = 1;
        if (this.jdField_a_of_type_AndroidWidgetImageView != null)
        {
          localObject3 = this.jdField_a_of_type_AndroidWidgetImageView;
          if (i == 0) {
            break label457;
          }
        }
      }
      for (int j = 0;; j = 4)
      {
        ((ImageView)localObject3).setVisibility(j);
        if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null)
        {
          this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
          paramIntimateInfo = new aqkq(((MISC.StGetFriendPlayListV2Rsp)localObject1).appPlayingInfos.get(), paramIntimateInfo.friendUin, (View.OnClickListener)localObject2);
          paramIntimateInfo.b(2064);
          this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(paramIntimateInfo);
        }
        paramIntimateInfo = new MiniAppConfig(MiniAppInfo.from(((MISC.StAppPlayingInfo)((MISC.StGetFriendPlayListV2Rsp)localObject1).appPlayingInfos.get().get(0)).appMetaInfo));
        if (paramIntimateInfo.launchParam != null) {
          paramIntimateInfo.launchParam.scene = 2064;
        }
        MiniProgramLpReportDC04239.reportAsync(paramIntimateInfo, "page_view", "expo", null, null);
        if (i != 0) {
          MiniAppCmdUtil.getInstance().getAppInfoByLink(((MISC.StGetFriendPlayListV2Rsp)localObject1).moreJumpLink.get(), 2, new aqko(this, (MISC.StGetFriendPlayListV2Rsp)localObject1));
        }
        setOnClickListener((View.OnClickListener)localObject2);
        return;
        i = 0;
        break;
      }
      setVisibility(8);
      return;
    }
  }
  
  private static void b(ThemeImageView paramThemeImageView, String paramString)
  {
    if ((paramThemeImageView == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      localObject = BaseApplicationImpl.getApplication().getRuntime();
    } while (!(localObject instanceof QQAppInterface));
    Object localObject = new baxk(paramThemeImageView.getContext(), (QQAppInterface)localObject);
    Bitmap localBitmap = ((baxk)localObject).a(1, paramString, 0, (byte)4);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      ((baxk)localObject).d();
      paramThemeImageView.setImageBitmap(localBitmap);
      return;
    }
    ((baxk)localObject).a(new aqkp((baxk)localObject, paramThemeImageView));
    ((baxk)localObject).a(paramString, 200, false, 1, true, (byte)0, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.friends.intimate.IntimatePlayTogetherMiniGameCardView
 * JD-Core Version:    0.7.0.1
 */