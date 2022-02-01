package com.tencent.mobileqq.kandian.biz.publisher.impls;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tkd.topicsdk.bean.CommunityInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0xf77.oidb_cmd0xf77.Community;
import tencent.im.oidb.cmd0xf77.oidb_cmd0xf77.RspBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/publisher/impls/DataTransferImpl$getCommunityList$1", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "onResult", "", "errorCode", "", "data", "", "bundle", "Landroid/os/Bundle;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class DataTransferImpl$getCommunityList$1
  extends ProtoUtils.TroopProtocolObserver
{
  DataTransferImpl$getCommunityList$1(Function5 paramFunction5) {}
  
  public void onResult(int paramInt, @Nullable byte[] paramArrayOfByte, @Nullable Bundle paramBundle)
  {
    paramBundle = Boolean.valueOf(true);
    if ((paramInt == 0) && (paramArrayOfByte != null)) {
      try
      {
        paramArrayOfByte = ((oidb_cmd0xf77.RspBody)new oidb_cmd0xf77.RspBody().mergeFrom(paramArrayOfByte)).community_list.get();
        Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "rspBody.community_list.get()");
        localObject1 = (Iterable)paramArrayOfByte;
        paramArrayOfByte = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject1, 10));
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (oidb_cmd0xf77.Community)((Iterator)localObject1).next();
          CommunityInfo localCommunityInfo = new CommunityInfo(null, null, null, null, null, null, 63, null);
          localCommunityInfo.setCommunityId(String.valueOf(((oidb_cmd0xf77.Community)localObject2).community_id.get()));
          String str = ((oidb_cmd0xf77.Community)localObject2).community_name.get().toStringUtf8();
          Intrinsics.checkExpressionValueIsNotNull(str, "it.community_name.get().toStringUtf8()");
          localCommunityInfo.setTitle(str);
          str = ((oidb_cmd0xf77.Community)localObject2).community_url.get().toStringUtf8();
          Intrinsics.checkExpressionValueIsNotNull(str, "it.community_url.get().toStringUtf8()");
          localCommunityInfo.setJumpUrl(str);
          localObject2 = ((oidb_cmd0xf77.Community)localObject2).description.get().toStringUtf8();
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "it.description.get().toStringUtf8()");
          localCommunityInfo.setIntro((String)localObject2);
          paramArrayOfByte.add(localCommunityInfo);
        }
        paramArrayOfByte = (List)paramArrayOfByte;
        if (QLog.isColorLevel())
        {
          QLog.i("TKP.DataTransferImpl", 2, "print communityList");
          localObject1 = ((Iterable)paramArrayOfByte).iterator();
          while (((Iterator)localObject1).hasNext()) {
            QLog.i("TKP.DataTransferImpl", 2, ((CommunityInfo)((Iterator)localObject1).next()).toString());
          }
        }
        this.a.invoke(Integer.valueOf(paramInt), "", null, paramBundle, paramArrayOfByte);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        QLog.e("TKP.DataTransferImpl", 1, (Throwable)paramArrayOfByte, new Object[] { "getCommunityList exception" });
        this.a.invoke(Integer.valueOf(-1), "", null, paramBundle, null);
        return;
      }
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getCommunityList error, errorCode=");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append(", data=");
    ((StringBuilder)localObject1).append(paramArrayOfByte);
    QLog.e("TKP.DataTransferImpl", 1, ((StringBuilder)localObject1).toString());
    this.a.invoke(Integer.valueOf(paramInt), "", null, paramBundle, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.DataTransferImpl.getCommunityList.1
 * JD-Core Version:    0.7.0.1
 */