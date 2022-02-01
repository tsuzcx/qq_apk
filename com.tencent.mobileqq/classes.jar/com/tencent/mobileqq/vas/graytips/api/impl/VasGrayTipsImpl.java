package com.tencent.mobileqq.vas.graytips.api.impl;

import android.os.Build.VERSION;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.vas.api.IPbProtocol;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.graytips.api.IVasGrayTips;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.pb.vas.uni_gray_tip.UniGrayTip.FromChannel;
import com.tencent.pb.vas.uni_gray_tip.UniGrayTip.PlatformComm;
import com.tencent.pb.vas.uni_gray_tip.UniGrayTip.UniAIOTipsReq;
import com.tencent.pb.vas.uni_gray_tip.UniGrayTip.UniAIOTipsRsp;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/graytips/api/impl/VasGrayTipsImpl;", "Lcom/tencent/mobileqq/vas/graytips/api/IVasGrayTips;", "()V", "requestUnitGrayTips", "", "cmd", "", "channel", "Lcom/tencent/pb/vas/uni_gray_tip/UniGrayTip$FromChannel;", "map", "", "", "observer", "Lcom/tencent/mobileqq/app/BusinessObserver;", "transformFrom", "peerType", "Companion", "vas-impl_release"}, k=1, mv={1, 1, 16})
public final class VasGrayTipsImpl
  implements IVasGrayTips
{
  public static final long AND_PLATFORM = 109L;
  public static final int CHANNEL_DISCUSSION = 3;
  public static final int CHANNEL_FRIEND = 1;
  public static final int CHANNEL_TROOP = 2;
  @NotNull
  public static final String CMD = "trpc.qqva.uni_gray_tip.UniGrayTip.UniAIOTips";
  public static final VasGrayTipsImpl.Companion Companion = new VasGrayTipsImpl.Companion(null);
  @NotNull
  public static final String TAG = "VasGrayTipsRequestImpl";
  
  public void requestUnitGrayTips(int paramInt, @NotNull UniGrayTip.FromChannel paramFromChannel, @Nullable Map<String, String> paramMap, @Nullable BusinessObserver paramBusinessObserver)
  {
    Intrinsics.checkParameterIsNotNull(paramFromChannel, "channel");
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (paramMap != null) {
      try
      {
        localObject1 = new JSONObject(paramMap).toString();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "JSONObject(map).toString()");
      }
      catch (Exception paramMap)
      {
        paramMap.printStackTrace();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("json error ");
        ((StringBuilder)localObject1).append(paramMap.getMessage());
        QLog.d("VasGrayTipsRequestImpl", 1, ((StringBuilder)localObject1).toString());
        localObject1 = localObject2;
      }
    }
    paramMap = new UniGrayTip.UniAIOTipsReq();
    localObject2 = new UniGrayTip.PlatformComm();
    ((UniGrayTip.PlatformComm)localObject2).platForm.set(109L);
    ((UniGrayTip.PlatformComm)localObject2).osver.set(Build.VERSION.RELEASE);
    ((UniGrayTip.PlatformComm)localObject2).mqqver.set("8.8.17.5770");
    paramMap.platInfo.set((MessageMicro)localObject2);
    paramMap.cmd.set(paramInt);
    paramMap.from.set((MessageMicro)paramFromChannel);
    paramMap.exInfo.set(ByteStringMicro.copyFromUtf8((String)localObject1));
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("cmd: ");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(' ');
      ((StringBuilder)localObject2).append("channelId: ");
      if (paramFromChannel.channel.has()) {
        paramInt = paramFromChannel.channel.get();
      } else {
        paramInt = -1;
      }
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(' ');
      ((StringBuilder)localObject2).append("json: ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("VasGrayTipsRequestImpl", 2, ((StringBuilder)localObject2).toString());
    }
    VasUtil.a().getPbRequest().request("trpc.qqva.uni_gray_tip.UniGrayTip.UniAIOTips", (MessageMicro)paramMap, UniGrayTip.UniAIOTipsRsp.class, (BusinessObserver)new VasGrayTipsImpl.requestUnitGrayTips.1(paramBusinessObserver));
  }
  
  public int transformFrom(int paramInt)
  {
    int i = 1;
    if (paramInt == 1) {
      return 2;
    }
    if (paramInt == 3000) {
      i = 3;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.graytips.api.impl.VasGrayTipsImpl
 * JD-Core Version:    0.7.0.1
 */