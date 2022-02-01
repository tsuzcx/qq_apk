package com.tencent.mobileqq.kandian.biz.publisher.column;

import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tkd.topicsdk.bean.TopicInfo;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0xe31.oidb_0xe31.ReqBody;
import tencent.im.oidb.cmd0xe31.oidb_0xe31.RspBody;
import tencent.im.oidb.cmd0xe31.oidb_0xe31.TopicListReq;
import tencent.im.oidb.cmd0xe31.oidb_0xe31.TopicListRsp;
import tencent.kandian.ugc.topic_info.TopicInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/column/ColumnModeImpl;", "Lcom/tencent/mobileqq/kandian/biz/publisher/column/IColumnModel;", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "(Lcom/tencent/mobileqq/app/QQAppInterface;)V", "getApp", "()Lcom/tencent/mobileqq/app/QQAppInterface;", "createColumn", "", "topicInfo", "Lcom/tencent/tkd/topicsdk/bean/TopicInfo;", "callback", "Lcom/tencent/mobileqq/kandian/biz/publisher/column/IColumnModel$IColumnCallback;", "editColumn", "getColumnList", "cookie", "", "topTopicId", "", "Lcom/tencent/mobileqq/kandian/biz/publisher/column/IColumnModel$IColumnListCallback;", "getCommonReportDataBuilder", "Lcom/tencent/mobileqq/kandian/glue/report/RIJTransMergeKanDianReport$ReportR5Builder;", "handleGetTopicListSuccessResult", "data", "sendGetColumnListRequest", "sendManageColumnRequest", "actionType", "", "parseToTopicInfo", "Ltencent/kandian/ugc/topic_info$TopicInfo;", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ColumnModeImpl
  implements IColumnModel
{
  public static final ColumnModeImpl.Companion a = new ColumnModeImpl.Companion(null);
  @NotNull
  private final QQAppInterface b;
  
  public ColumnModeImpl(@NotNull QQAppInterface paramQQAppInterface)
  {
    this.b = paramQQAppInterface;
  }
  
  private final TopicInfo a(@NotNull topic_info.TopicInfo paramTopicInfo)
  {
    TopicInfo localTopicInfo = new TopicInfo(0L, null, null, null, false, 0L, 0, 127, null);
    localTopicInfo.setTopicId(paramTopicInfo.id.get());
    String str = paramTopicInfo.cover_img.get();
    Intrinsics.checkExpressionValueIsNotNull(str, "cover_img.get()");
    localTopicInfo.setCoverUrl(str);
    str = paramTopicInfo.title.get();
    Intrinsics.checkExpressionValueIsNotNull(str, "title.get()");
    localTopicInfo.setTitle(str);
    str = paramTopicInfo.intro.get();
    Intrinsics.checkExpressionValueIsNotNull(str, "intro.get()");
    localTopicInfo.setIntro(str);
    int i = paramTopicInfo.submit_permission.get();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    localTopicInfo.setAllowSubmit(bool);
    localTopicInfo.setSource(paramTopicInfo.source.get());
    localTopicInfo.setUid(paramTopicInfo.creator_uid.get());
    return localTopicInfo;
  }
  
  private final void a(byte[] paramArrayOfByte, IColumnModel.IColumnListCallback paramIColumnListCallback)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      Object localObject1 = new oidb_0xe31.RspBody();
      ((oidb_0xe31.RspBody)localObject1).mergeFrom(paramArrayOfByte);
      if ((((oidb_0xe31.RspBody)localObject1).topic_list_req_rsp.has()) && (((oidb_0xe31.RspBody)localObject1).topic_list_req_rsp.topics.size() != 0))
      {
        paramArrayOfByte = ((oidb_0xe31.RspBody)localObject1).topic_list_req_rsp;
        localObject1 = paramArrayOfByte.topics.get();
        int i = 0;
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "topics");
        int j = ((Collection)localObject1).size();
        while (i < j)
        {
          localObject2 = ((List)localObject1).get(i);
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "topics[i]");
          localArrayList.add(a((topic_info.TopicInfo)localObject2));
          i += 1;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("loadDataFromNetwork success, topicList.num = ");
        ((StringBuilder)localObject1).append(localArrayList.size());
        QLog.i("ColumnModuleImpl", 2, ((StringBuilder)localObject1).toString());
        if (paramIColumnListCallback == null) {
          break label301;
        }
        localObject1 = paramArrayOfByte.cookie.get().toStringUtf8();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "rsp.cookie.get().toStringUtf8()");
        Object localObject2 = Charsets.UTF_8;
        if (localObject1 != null)
        {
          localObject1 = ((String)localObject1).getBytes((Charset)localObject2);
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "(this as java.lang.String).getBytes(charset)");
          paramIColumnListCallback.a(0, "", (byte[])localObject1, paramArrayOfByte.is_end.get(), (List)localArrayList);
          return;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
      QLog.e("ColumnModuleImpl", 1, "handleGetTopicListSuccessResult no topicInfo data!");
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      label269:
      break label269;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ColumnModuleImpl", 2, "loadColumnListFromNetwork failed.");
    }
    if (paramIColumnListCallback != null) {
      paramIColumnListCallback.a(-1, "", null, true, null);
    }
    label301:
  }
  
  private final void b(byte[] paramArrayOfByte, long paramLong, IColumnModel.IColumnListCallback paramIColumnListCallback)
  {
    oidb_0xe31.TopicListReq localTopicListReq = new oidb_0xe31.TopicListReq();
    PBUInt64Field localPBUInt64Field = localTopicListReq.uid;
    String str = this.b.getCurrentAccountUin();
    Intrinsics.checkExpressionValueIsNotNull(str, "app.currentAccountUin");
    localPBUInt64Field.set(Long.parseLong(str));
    if (paramArrayOfByte != null) {
      localTopicListReq.cookie.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    }
    localTopicListReq.num.set(10);
    if (paramLong != 0L) {
      localTopicListReq.top_topic_id.set((int)paramLong);
    }
    paramArrayOfByte = new oidb_0xe31.ReqBody();
    paramArrayOfByte.topic_list_req_req.set((MessageMicro)localTopicListReq);
    ProtoUtils.a((AppRuntime)this.b, (ProtoUtils.TroopProtocolObserver)new ColumnModeImpl.sendGetColumnListRequest.1(this, paramIColumnListCallback), paramArrayOfByte.toByteArray(), "OidbSvc.0xe31", 3633, 3);
  }
  
  public void a(@Nullable byte[] paramArrayOfByte, long paramLong, @Nullable IColumnModel.IColumnListCallback paramIColumnListCallback)
  {
    b(paramArrayOfByte, paramLong, paramIColumnListCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.column.ColumnModeImpl
 * JD-Core Version:    0.7.0.1
 */